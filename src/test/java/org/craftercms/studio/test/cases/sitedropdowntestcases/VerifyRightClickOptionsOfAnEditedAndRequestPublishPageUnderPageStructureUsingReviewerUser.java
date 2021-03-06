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
package org.craftercms.studio.test.cases.sitedropdowntestcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;

import java.util.LinkedList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.craftercms.studio.test.cases.StudioBaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * 
 * 
 * @author Juan Camacho A
 *
 */
// Test Case Studio- Site Dropdown ID:25
public class VerifyRightClickOptionsOfAnEditedAndRequestPublishPageUnderPageStructureUsingReviewerUser
		extends StudioBaseTest {

	private String siteDropdownElementXPath;
	private String pagesTree;
	private String homeContent;
	private String createFormFrameElementCss;
	private String homePageEditedName;
	private String homePageEditedExpand;
	private String menStylesEditedPageName;
	private String menStylesForWinterEditedPageName;
	private String rightClickOptions;
	private String userOptions;
	private String userOptionsLogout;
	private String rightclickViewOption;
	private String rightclickCopyOption;
	private String rightclickApproveAndPublishOption;
	private String rightclickDependenciesOption;
	private String styleLandingpage;
	private String articlesFolder;
	private String articlesFolder2017;
	private String articlesFolder1;
	private String articlesFolderMenStylesForWinter;
	private LinkedList<String> rightClickOptionsListInHomePage;
	private LinkedList<String> rightClickOptionsListInCategoryLandingPage;
	private LinkedList<String> rightClickOptionsListInMenStylesForWinterPage;
	private static Logger logger = LogManager.getLogger(
			VerifyRightClickOptionsOfAnEditedAndRequestPublishPageUnderPageStructureUsingReviewerUser.class);

	@Parameters({"testId", "blueprint", "testUser", "testGroup", "testUser2", "testGroup2"})
	@BeforeMethod
	public void beforeTest(String testId, String blueprint, String testUser, String testGroup,
						   String testUser2, String testGroup2) {
		apiTestHelper.createSite(testId, "", blueprint);
		apiTestHelper.createUserAddToGroup(testUser, testGroup);
		apiTestHelper.createUserAddToGroup(testUser2, testGroup2);
		siteDropdownElementXPath = uiElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("complexscenarios.general.sitedropdownmenuinnerxpath");
		pagesTree = uiElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("dashboard.expand_Pages_Tree");
		homeContent = uiElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("dashboard.home_Content_Page");
		homePageEditedName = uiElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("dashboard.new_home_Content_Page_name_edited");
		menStylesEditedPageName = uiElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("dashboard.pagestree.style.landingpage.edited");
		homePageEditedExpand = uiElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("dashboard.new_home_Content_Page_name_edited_expand");
		menStylesForWinterEditedPageName = uiElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("dashboard.pagestree.articlesfolder.menstylesforwinter.page.edited");

		rightclickViewOption = uiElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("rightclick.view.option");
		rightclickCopyOption = uiElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("rightclick.copy.option");
		rightclickApproveAndPublishOption = uiElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("rightclick.approveandpublish.option");
		rightclickDependenciesOption = uiElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("rightclick.dependenciesoption");
		styleLandingpage = uiElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("dashboard.pagestree.style.landingpage");
		articlesFolder = uiElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("dashboard.articlesfolder");
		articlesFolder2017 = uiElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("dashboard.articles.folder.2017");
		articlesFolder1 = uiElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("dashboard.articles.folder.2017.1");
		articlesFolderMenStylesForWinter = uiElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("dashboard.articles.folder.2017.1.menstylesforwinter");
		createFormFrameElementCss = uiElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("complexscenarios.general.createformframe");
		rightClickOptions = uiElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("rightclick.list.all.options");
		userOptions = uiElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("dashboard.user_options");
		userOptionsLogout = uiElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("dashboard.user_options_logout");
	}

	public void rightClickHomePage() {
		this.getWebDriverManager().waitUntilPageLoad();
		this.getWebDriverManager().waitUntilSidebarOpens();

		this.getWebDriverManager().waitUntilFolderOpens("xpath", pagesTree);
		this.getWebDriverManager().waitForAnimation();

		this.getWebDriverManager().driverWaitUntilElementIsPresentAndDisplayedAndClickable("xpath",
				homePageEditedName);
		dashboardPage.getDriverManager().contextClick("xpath", homePageEditedName, false);

	}

	public void rightClickCategoryLandingPage() {
		this.getWebDriverManager().waitUntilPageLoad();
		this.getWebDriverManager().waitUntilSidebarOpens();
		this.getWebDriverManager().waitForAnimation();

		this.getWebDriverManager().driverWaitUntilElementIsPresentAndDisplayedAndClickable("xpath",
				menStylesEditedPageName);
		dashboardPage.getDriverManager().contextClick("xpath", menStylesEditedPageName, false);
		this.getWebDriverManager().waitForAnimation();
	}

	public void rightClickArticlesFolderMenStylesForWinter() {
		this.getWebDriverManager().waitUntilPageLoad();
		this.getWebDriverManager().waitUntilSidebarOpens();
		this.getWebDriverManager().waitForAnimation();

		this.getWebDriverManager().driverWaitUntilElementIsPresentAndDisplayedAndClickable("xpath",
				menStylesForWinterEditedPageName);
		dashboardPage.getDriverManager().contextClick("xpath", menStylesForWinterEditedPageName, false);
		this.getWebDriverManager().waitForAnimation();
	}

	public void verifyViewOptionIsPresent(String section) {
		WebElement rightclickViewOptionElement = this.getWebDriverManager()
				.driverWaitUntilElementIsPresentAndDisplayed("xpath", rightclickViewOption);
		Assert.assertTrue(rightclickViewOptionElement.isDisplayed(),
				"ERROR: Right click View Option is not present on right click of " + section);
	}

	public void verifyCopyOptionIsPresent(String section) {
		WebElement rightclickCopyOptionElement = this.getWebDriverManager()
				.driverWaitUntilElementIsPresentAndDisplayed("xpath", rightclickCopyOption);
		Assert.assertTrue(rightclickCopyOptionElement.isDisplayed(),
				"ERROR: Right click Copy Option is not present on right click of " + section);
	}

	public void verifyApproveAndPublishOptionIsPresent(String section) {
		WebElement rightclickApproveAndPublishOptionElement = this.getWebDriverManager()
				.driverWaitUntilElementIsPresentAndDisplayed("xpath", rightclickApproveAndPublishOption);
		Assert.assertTrue(rightclickApproveAndPublishOptionElement.isDisplayed(),
				"ERROR: Right click Approve and Publish Option is not present on right click of " + section);
	}

	public void verifyDependenciesOptionIsPresent(String section) {
		WebElement rightclickDependenciesOptionElement = this.getWebDriverManager()
				.driverWaitUntilElementIsPresentAndDisplayed("xpath", rightclickDependenciesOption);
		Assert.assertTrue(rightclickDependenciesOptionElement.isDisplayed(),
				"ERROR: Right click Dependencies Option is not present on right click of " + section);
	}

	public void step4() {
		// Step 4 Right Right click on "Home" and verify options
		logger.info("Step 4 Right click on the Edited and Requested Publish Home Page To verify options");
		this.rightClickHomePage();

		getWebDriverManager().usingContextMenu(() -> {
			logger.info("Checking that only the expected options are listed");
			rightClickOptionsListInHomePage = new LinkedList<String>();
			rightClickOptionsListInHomePage.add(0, "View");
			rightClickOptionsListInHomePage.add(1, "Copy");
			rightClickOptionsListInHomePage.add(2, "Approve & Publish");
			rightClickOptionsListInHomePage.add(3, "Dependencies");
			rightClickOptionsListInHomePage.add(4, "History");

			List<WebElement> rightClickOptionsList = this.getWebDriverManager().getDriver()
					.findElements(By.xpath(rightClickOptions));
			int currentIndex = 0;
			for (WebElement element : rightClickOptionsList) {
				this.getWebDriverManager().waitForAnimation();
				this.getWebDriverManager().waitUntilSidebarOpens();
				Assert.assertTrue(element.getText().equals(rightClickOptionsListInHomePage.get(currentIndex)),
						"ERROR: Link Option: " + element.getText()
								+ " is not in the correct order in the HomePage, check that the correct options are listed");
				currentIndex++;
			}

			String section = "Step 4 Right Click on 'Home'";

			verifyViewOptionIsPresent(section);
			verifyCopyOptionIsPresent(section);
			verifyApproveAndPublishOptionIsPresent(section);
			verifyDependenciesOptionIsPresent(section);

			this.getWebDriverManager().getDriver().navigate().refresh();
			this.getWebDriverManager().waitForAnimation();
			this.getWebDriverManager().waitUntilSidebarOpens();
		}, "Pages");
	}

	public void step6() {
		// Step 6 Right click on any Category Landing page and verify options
		logger.info(
				"Step 6 Right click on the Edited and Requested Publish Category Landing Page (Style) Page To verify options");
		this.rightClickCategoryLandingPage();

		getWebDriverManager().usingContextMenu(() -> {
			logger.info("Checking that only the expected options are listed");
			rightClickOptionsListInCategoryLandingPage = new LinkedList<String>();
			rightClickOptionsListInCategoryLandingPage.add(0, "View");
			rightClickOptionsListInCategoryLandingPage.add(1, "Copy");
			rightClickOptionsListInCategoryLandingPage.add(2, "Approve & Publish");
			rightClickOptionsListInCategoryLandingPage.add(3, "Dependencies");
			rightClickOptionsListInCategoryLandingPage.add(4, "History");

			List<WebElement> rightClickOptionsList = this.getWebDriverManager().getDriver()
					.findElements(By.xpath(rightClickOptions));
			int currentIndex = 0;
			for (WebElement element : rightClickOptionsList) {
				this.getWebDriverManager().waitForAnimation();
				this.getWebDriverManager().waitUntilSidebarOpens();
				Assert.assertTrue(
						element.getText()
								.equals(rightClickOptionsListInCategoryLandingPage.get(currentIndex)),
						"ERROR: Link Option: " + element.getText()
								+ " is not in the correct order in the selected category landing page, check that the correct options are listed");
				currentIndex++;
			}

			String section = "Step 6 Right click on a 'Category Landing' page";

			verifyViewOptionIsPresent(section);
			verifyCopyOptionIsPresent(section);
			verifyApproveAndPublishOptionIsPresent(section);
			verifyDependenciesOptionIsPresent(section);

			this.getWebDriverManager().getDriver().navigate().refresh();
			this.getWebDriverManager().waitForAnimation();
		}, "Pages");
	}

	public void expandTheArticles2017folder() {
		// Step 8 Click on the + of folder 2017
		this.getWebDriverManager().driverWaitUntilElementIsPresentAndDisplayedAndClickable("xpath",
				articlesFolder2017);
		this.getWebDriverManager().waitUntilContentTooltipIsHidden();
		this.getWebDriverManager().clickIfFolderIsNotExpanded(articlesFolder2017);
		this.getWebDriverManager().waitUntilFolderOpens("xpath", articlesFolder2017);
	}

	public void step10() {
		// Step 10 Right click on any of the article (Men Styles For Winter)
		logger.info(
				"Step 10 Right click on the Edited and Requested Publish article Men Styles For Winter Page To verify options");
		this.getWebDriverManager().waitForAnimation();

		this.rightClickArticlesFolderMenStylesForWinter();

		getWebDriverManager().usingContextMenu(() -> {

			logger.info("Checking that only the expected options are listed");
			rightClickOptionsListInMenStylesForWinterPage = new LinkedList<String>();
			rightClickOptionsListInMenStylesForWinterPage.add(0, "View");
			rightClickOptionsListInMenStylesForWinterPage.add(1, "Copy");
			rightClickOptionsListInMenStylesForWinterPage.add(2, "Approve & Publish");
			rightClickOptionsListInMenStylesForWinterPage.add(3, "Dependencies");
			rightClickOptionsListInMenStylesForWinterPage.add(4, "History");
			
			List<WebElement> rightClickOptionsList = this.getWebDriverManager().getDriver()
					.findElements(By.xpath(rightClickOptions));
			int currentIndex = 0;
			for (WebElement element : rightClickOptionsList) {
				this.getWebDriverManager().waitForAnimation();
				this.getWebDriverManager().waitUntilSidebarOpens();
				Assert.assertTrue(
						element.getText()
								.equals(rightClickOptionsListInMenStylesForWinterPage.get(currentIndex)),
						"ERROR: Link Option: " + element.getText()
								+ " is not in the correct order in the Men Styles For Winter page, check that the correct options are listed");
				currentIndex++;
			}

			String section = "Step 11 Right click on folder articles -2017- 1- Men Styles For Winter;";

			verifyViewOptionIsPresent(section);
			verifyCopyOptionIsPresent(section);
			verifyApproveAndPublishOptionIsPresent(section);
			verifyDependenciesOptionIsPresent(section);

			this.getWebDriverManager().getDriver().navigate().refresh();
			this.getWebDriverManager().waitForAnimation();
		}, "Pages");

	}

	public void editHomePage() {
		// Step 3 Edit the Home Page and Save
		logger.info("Edit the Home Page and Save");
		dashboardPage.rightClickEditOnAPresentPage(homeContent);

		getWebDriverManager().usingCrafterForm("cssSelector", createFormFrameElementCss, () -> {

			// creating random values for URL field and InternalName field

			String randomInternalName = "HomePageEdited";

			// Set basics fields of the new content created

			dashboardPage.editInternalName(randomInternalName);
		});

		this.getWebDriverManager().waitUntilSidebarOpens();
		this.getWebDriverManager().driverWaitUntilElementIsPresentAndDisplayed("Xpath", homePageEditedName);

	}

	public void editLandingPageStylePage() {

		dashboardPage.rightClickEditOnAPresentPage(styleLandingpage);

		getWebDriverManager().usingCrafterForm("cssSelector", createFormFrameElementCss, () -> {

			// creating random values for URL field and InternalName field

			String randomInternalName = "StylePageEdited";

			// Set basics fields of the new content created

			dashboardPage.editInternalName(randomInternalName);
		});

		this.getWebDriverManager().waitUntilSidebarOpens();
		this.getWebDriverManager().driverWaitUntilElementIsPresentAndDisplayed("Xpath", menStylesEditedPageName);

	}

	public void editMenStylesForWinterPage() {

		dashboardPage.rightClickEditOnAPresentPage(articlesFolderMenStylesForWinter);

		getWebDriverManager().usingCrafterForm("cssSelector", createFormFrameElementCss, () -> {

			// creating random values for URL field and InternalName field

			String randomInternalName = "MenStylesForWinterEdited";

			// Set basics fields of the new content created

			dashboardPage.editInternalName(randomInternalName);
		});

		this.getWebDriverManager().waitUntilSidebarOpens();
		this.getWebDriverManager().driverWaitUntilElementIsPresentAndDisplayed("Xpath",
				menStylesForWinterEditedPageName);

	}

	public void expandHomeTree() {
		this.getWebDriverManager().waitUntilSidebarOpens();
		this.getWebDriverManager().waitForAnimation();
		this.getWebDriverManager().clickElement("xpath", homePageEditedExpand);
	}

	private void logoutFromCrafter() {
		logger.info("logout from Crafter");

		this.getWebDriverManager().clickElement("xpath", userOptions);
		this.getWebDriverManager().clickElement("xpath", userOptionsLogout);
	}

	@Parameters({"testId", "testUser", "testUser2"})
	@Test()
	public void verifyRightClickOptionsOfAnEditedAndRequestPublishPageUnderPageStructureUsingReviewerUser(
			String testId, String testUser, String testUser2) {
		logger.info("login to application with {} user", testUser2);
		loginPage.loginToCrafter(testUser2, testUser2);

		logger.info("Go to Preview Page {}", testId);
		this.homePage.goToPreviewPage(testId);

		this.getWebDriverManager().clickElement("xpath", siteDropdownElementXPath);

		logger.info("Edit the home page");
		this.editHomePage();

		logger.info("Request Publish for home page");
		this.rightClickHomePage();
		dashboardPage.requestPublish();
		this.getWebDriverManager().waitUntilSidebarOpens();

		logger.info("Click on the + of Home tree and Edit the selected Category Landing Page");
		this.expandHomeTree();

		logger.info("Edit the Category Landing Page(Style) and Save");
		this.editLandingPageStylePage();

		logger.info("Request Publish for the Category Landin Page (Style)");
		this.rightClickCategoryLandingPage();
		dashboardPage.requestPublish();
		this.getWebDriverManager().waitUntilSidebarOpens();

		logger.info("Click on the + of Articles tree to expand the tree");
		this.getWebDriverManager().waitForAnimation();
		this.getWebDriverManager().driverWaitUntilElementIsPresentAndDisplayedAndClickable("xpath", articlesFolder);
		this.getWebDriverManager().waitUntilContentTooltipIsHidden();

		this.getWebDriverManager().clickIfFolderIsNotExpanded(articlesFolder);
		this.getWebDriverManager().waitUntilFolderOpens("xpath", articlesFolder);

		logger.info("Click on the + of folder 2017");
		this.expandTheArticles2017folder();

		logger.info(
				"Click on the + of folder 1 and Edit then article page Men Styles For Winter under articles/2017/1");
		this.getWebDriverManager().clickElement("xpath", articlesFolder1);
		this.getWebDriverManager().waitUntilFolderOpens("xpath", articlesFolder1);

		logger.info("Edit the Men Styles for Winter Pageand Save");
		this.editMenStylesForWinterPage();

		logger.info("Request Publish for the Men Styles For Winter under articles/2017/1 folders");
		rightClickArticlesFolderMenStylesForWinter();
		dashboardPage.requestPublish();

		this.logoutFromCrafter();

		logger.info("login to application with {} user", testUser);
		loginPage.loginToCrafter(testUser, testUser);

		logger.info("Go to Preview Page {}", testId);
		this.homePage.goToPreviewPage(testId);

		this.step4();

		this.step6();

		this.step10();
	}

	@Parameters({"testId", "testUser", "testUser2"})
	@AfterMethod(alwaysRun = true)
	public void afterTest(String testId, String testUser, String testUser2) {
		apiTestHelper.deleteSite(testId);
		apiTestHelper.deleteUser(testUser);
		apiTestHelper.deleteUser(testUser2);
	}
}
