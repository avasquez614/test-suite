/*
 * Copyright (C) 2007-2019 Crafter Software Corporation. All Rights Reserved.
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.craftercms.studio.test.cases.generaltestcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.Assert;
import org.craftercms.studio.test.cases.StudioBaseTest;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

/**
 * @author luishernandez
 *
 */
public class RenameParentPageAndPublishChildTest extends StudioBaseTest{

	private String userName;
	private String password;
	private String parentPageName;
	private String childPage1Name;
	private String childPage2Name;
	private String parentPageNewName;
	private String parentPageLocator;
	private String childPage1Locator;
	private String childPage2Locator;
	private String parentPageNewLocator;
	private String homeContent;
	private String siteDropdownElementXPath;
	private String approveSubmitId;
	private String unselectAllCheckBox;
	private String createFormFrameElementCss;
	private String createFormSaveAndCloseElement;
	private String homeExpansorXpath;
	private String createFormArticleMainTitleElementXPath;
	private String siteDropdownListElementXPath;
	private String categoryDrowpdownXpath;

	@Parameters({"testId", "blueprint"})
	@BeforeMethod
	public void beforeTest(String testId, String blueprint) {
		apiTestHelper.createSite(testId, "", blueprint);
		this.parentPageName = "1";
		this.childPage1Name = "2";
		this.childPage2Name = "3";
		this.parentPageNewName = "11";
		
		userName = constantsPropertiesManager.getSharedExecutionConstants().getProperty("crafter.username");
		password = constantsPropertiesManager.getSharedExecutionConstants().getProperty("crafter.password");

		homeContent = uiElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("dashboard.home_Content_Page");
		this.parentPageLocator = uiElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("complexscenarios.crafter3loadtest.parentfolder") + this.parentPageName + "')]";
		this.childPage1Locator = this.parentPageLocator + uiElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("complexscenarios.crafter3loadtest.childfolder") + this.childPage1Name + "')]";
		this.childPage2Locator = this.childPage1Locator + uiElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("complexscenarios.crafter3loadtest.childfolder") + this.childPage2Name + "')]";
		this.parentPageNewLocator = uiElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("complexscenarios.crafter3loadtest.parentfolder") + this.parentPageNewName + "')]";
		siteDropdownElementXPath = uiElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("complexscenarios.general.sitedropdown");
		approveSubmitId = uiElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("complexscenarios.renameparentpageandpublishchildtest.approvesubmitid");
		unselectAllCheckBox = uiElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("complexscenarios.renameparentpageandpublishchildtest.unselectallcheckbox");
		createFormFrameElementCss = uiElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("complexscenarios.general.createformframe");
		createFormArticleMainTitleElementXPath = uiElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("complexscenarios.general.createformMainTitle");
		createFormSaveAndCloseElement = uiElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("complexscenarios.general.saveandclosebutton");
		homeExpansorXpath = uiElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("complexscenarios.general.homeexpansor");
		siteDropdownListElementXPath = uiElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("complexscenarios.general.sitedropdownlielement");
		categoryDrowpdownXpath = uiElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("complexscenarios.general.createformcategorydropdown");
	}

	public void loginAndGoToSiteContentPagesStructure(String siteId) {
		// login to application
		loginPage.loginToCrafter(userName, password);

		// Wait for login page to close
		driverManager.waitUntilLoginCloses();

		// go to preview page
		homePage.goToPreviewPage(siteId);

		if (this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("xpath",siteDropdownElementXPath).isDisplayed())
			if (!(this.driverManager.waitUntilElementIsPresent("xpath", siteDropdownListElementXPath)
					.getAttribute("class").contains("site-dropdown-open")))
			this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("xpath", siteDropdownElementXPath).click();
		else
			throw new NoSuchElementException(
					"Site creation process is taking too long time and the element was not found");
	}

	public void publishElement(String elementLocator, String pageName) {

		dashboardPage.rightClickOnAContentPage(elementLocator);
		// selecting the Publish option
		driverManager.usingContextMenu(() -> {
			dashboardPage.clickOnPublishOption();
		},"Pages");
		// moving to the publish dialog, clicking on Submit and confirm action
		this.selectOnlyOnePageToPublish(pageName);
		this.confirmPublishAction();
		this.driverManager.waitUntilSidebarOpens();
	}

	private void selectOnlyOnePageToPublish(String pageName) {
		// Switch to the form
		driverManager.getDriver().switchTo().activeElement();
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayedAndClickable("id", approveSubmitId);
		WebElement unSelectAllCheck = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("xpath",
				unselectAllCheckBox);
		unSelectAllCheck.click();

		String pageNameCheckLocator = ".//table[@class='item-listing scroll-body']/tbody/tr/td/div/span[contains(text(),'"
				+ pageName + "')]/../../../td/input";
		WebElement pageNameCheck = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("xpath",
				pageNameCheckLocator);
		pageNameCheck.click();
	}

	public void confirmPublishAction() {
		// Switch to the form
		driverManager.getDriver().switchTo().activeElement();
		// Click on Publish button
		dashboardPage.clickApproveAndPublishSubmitButton();
		// switch to default content
		driverManager.getDriver().switchTo().defaultContent();
	}

	public void createNewPageArticleContent(String pageName) {

		driverManager.usingCrafterForm("cssSelector", createFormFrameElementCss, () -> {
			// Set basics fields of the new content created
			dashboardPage.setBasicFieldsOfNewPageArticleContent(pageName, pageName, pageName);

			// Set the title of main content
			this.driverManager.scrollDown();
			driverManager.sendText("xpath", createFormArticleMainTitleElementXPath, pageName);
			
			WebElement categoryDropdown = this.driverManager
					.driverWaitUntilElementIsPresentAndDisplayed("xpath", categoryDrowpdownXpath);
			Select select = new Select(categoryDropdown);
			select.selectByValue("style");

			// save and close
			this.driverManager.waitForAnimation();
			this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("xpath", createFormSaveAndCloseElement)
					.click();
		});
		this.driverManager.waitUntilSidebarOpens();

	}

	public void editPageArticleContent(String pageName) {
		// Switch to the iframe
		this.driverManager.waitForAnimation();

		driverManager.usingCrafterForm("cssSelector", createFormFrameElementCss, () -> {
			// creating random values for URL field and InternalName field
			String randomInternalName = pageName;
			// Set basics fields of the new content created
			dashboardPage.updateBasicFieldsOfNewPageArticleContent(randomInternalName, pageName);
			// Set the title of main content
			this.driverManager.scrollUp();
			this.driverManager
					.driverWaitUntilElementIsPresentAndDisplayed("xpath", createFormArticleMainTitleElementXPath)
					.sendKeys(pageName);
			// save and close

			this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("xpath", createFormSaveAndCloseElement)
					.click();
		});
		this.driverManager.waitUntilSidebarOpens();
	}

	public void createPageCategoryLandingPage(String folderWebElementSelector, String pageName) {
		dashboardPage.rightClickCreatePageOnAPresentPage(folderWebElementSelector);
		// selecting Page Category Landing Page
		dashboardPage.selectPageArticleContentType();
		// click on the Ok button to confirm the select content type above
		dashboardPage.clickOKButton();
		// creating new Page Article into the empty folder
		driverManager.getDriver().switchTo().defaultContent();
		this.createNewPageArticleContent(pageName);
	}

	public void testScenario() {
		this.createPageCategoryLandingPage(homeContent, parentPageName);

		Assert.assertTrue(driverManager.waitUntilElementIsClickable("xpath", parentPageLocator).isDisplayed());

		this.driverManager.driverWaitUntilElementIsPresentAndDisplayedAndClickable("xpath", parentPageLocator);

		this.createPageCategoryLandingPage(parentPageLocator, childPage1Name);

		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("xpath", childPage1Locator);
		this.createPageCategoryLandingPage(childPage1Locator, childPage2Name);
		driverManager.getDriver().navigate().refresh();
		
		this.driverManager.waitForAnimation();
		this.driverManager.waitUntilSidebarOpens();
		this.renamePage(parentPageLocator, parentPageNewName);

		this.childPage1Locator = this.parentPageNewLocator + uiElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("complexscenarios.crafter3loadtest.childfolder") + this.childPage1Name + "')]";


		this.childPage2Locator = this.childPage1Locator + uiElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("complexscenarios.crafter3loadtest.childfolder") + this.childPage2Name + "')]";

		this.driverManager.driverWaitUntilElementIsPresentAndDisplayedAndClickable("xpath", childPage2Locator).click();
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayedAndClickable("xpath", childPage2Locator);

		this.publishElement(childPage2Locator, childPage2Name);
		this.verifyPublishedItemsOnDashboard();

	}

	private void verifyPublishedItemsOnDashboard() {

		String iconNeverPublishedForParentPage = this.parentPageNewLocator
				+ "/div/span/span[contains(@class,'never-published')]";
		String iconNeverPublishedForChild1Page = this.childPage1Locator
				+ "/div/span/span[contains(@class,'never-published')]";

		this.driverManager.waitUntilPageLoad();
		this.driverManager.waitForAnimation();

		boolean isPresent = this.driverManager.isElementPresentAndClickableByXpath(iconNeverPublishedForChild1Page);

		while (isPresent) {
			this.driverManager.waitUntilPageLoad();
			driverManager.getDriver().navigate().refresh();
			isPresent = this.driverManager.isElementPresentAndClickableByXpath(iconNeverPublishedForChild1Page);
		}

		Assert.assertFalse(this.driverManager.isElementPresentAndClickableByXpath(iconNeverPublishedForParentPage));
		Assert.assertFalse(this.driverManager.isElementPresentAndClickableByXpath(iconNeverPublishedForChild1Page));

	}

	public void confirmDeleteAction() {

		// Switch to the form
		driverManager.getDriver().switchTo().activeElement();
		// Click on delete button
		dashboardPage.clickDeleteDeleteSubmitButton();
		driverManager.getDriver().switchTo().defaultContent();
	}

	private void renamePage(String pageLocator, String newPageName) {
		dashboardPage.rightClickEditOnAPresentPage(pageLocator);
		// creating new Page Article into the empty folder
		this.editPageArticleContent(newPageName);
	}

	@Parameters({"testId"})
	@Test
	public void renameParentPageAndPublishChildTest(String testId) {
		// Related to the bug:
		// https://github.com/craftercms/craftercms/issues/1248
		this.loginAndGoToSiteContentPagesStructure(testId);

		// expand pages folder
		//dashboardPage.expandPagesTree();

		// create the folders structure according with script
		this.testScenario();
	}

	@Parameters({"testId"})
	@AfterMethod(alwaysRun = true)
	public void afterTest(String testId) {
		apiTestHelper.deleteSite(testId);
	}
}