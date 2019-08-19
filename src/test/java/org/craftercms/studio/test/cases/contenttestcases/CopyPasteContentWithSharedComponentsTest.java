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
package org.craftercms.studio.test.cases.contenttestcases;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.craftercms.studio.test.cases.StudioBaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;

/**
 * 
 * @author Luis Hernandez
 *
 */

// Test Case Studio- Site Content ID:3
public class CopyPasteContentWithSharedComponentsTest extends StudioBaseTest {

	private String userName;
	private String password;
	private String articlesFolder;
	private String siteDropdownElementXPath;
	private String pasteOptionLocator;
	private String firstChildLocator;
	private String firstDestinationLocator;
	private String childFolder;
	private String topNavStatusIcon;
	private String finalChildFolderLocator;
	private String selectAllSegmentsCheckBox;
	private String selectAllCategoriesCheckBox;
	private String homeTree;
	private String expandPagesTree;
	private String staticAssetsButton;
	private String staticAssetsChildFolder;
	private String staticAssetsItemsImagesChildFolder;
	private String staticAssetsItemImagesTestImagesChilds;
	private String secondDestinationLocator;
	private String thirdDestinationLocator;
	private String fourthDestinationLocator;
	private String fifthDestinationLocator;
	private String seventhDestinationLocator;
	private String sixthDestinationLocator;
	private String eighthDestinationLocator;
	private String ninthDestinationLocator;
	private String tenthDestinationLocator;
	private String staticAssetsItemsChildFolder;
	private static Logger logger = LogManager.getLogger(CopyPasteContentWithSharedComponentsTest.class);

	@Parameters({"testId", "blueprint"})
	@BeforeMethod
	public void beforeTest(String testId, String blueprint) {
		apiTestHelper.createSite(testId, "", blueprint);
		int exitCode = this.driverManager.goToDeliveryFolderAndExecuteSiteScriptThroughCommandLine(testId, "init");
		Assert.assertEquals(exitCode, 0, "Init site process failed");
		userName = constantsPropertiesManager.getSharedExecutionConstants().getProperty("crafter.username");
		password = constantsPropertiesManager.getSharedExecutionConstants().getProperty("crafter.password");
		articlesFolder = uiElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("dashboard.articlesfolder");
		siteDropdownElementXPath = uiElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("complexscenarios.general.sitedropdown");
		pasteOptionLocator = uiElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("rightclick.paste.option");
		firstChildLocator = uiElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("general.articles.2017folder");
		firstDestinationLocator = uiElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("general.articles.2016folder");
		childFolder = uiElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("general.articles.childfolder2017");
		topNavStatusIcon = uiElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("general.statustopbaricon");
		finalChildFolderLocator = uiElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("general.articles.2016childfolder");
		selectAllSegmentsCheckBox = uiElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("frame2.article_select_all_segments_checkbox");
		selectAllCategoriesCheckBox = uiElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("frame2.select_All_Categories_CheckBox");
		homeTree = uiElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("dashboard.expand_GlobalEntry_Tree");
		expandPagesTree = uiElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("dashboard.expand_Pages_Tree");
		staticAssetsButton = uiElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("preview.static_assets_button");
		staticAssetsChildFolder = uiElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("preview.static_assets_child_folder");
		staticAssetsItemsChildFolder = uiElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("preview.static_assets_itemschild_folder");
		staticAssetsItemsImagesChildFolder = uiElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("preview.static_assets_itemsimages_child_folder");
		staticAssetsItemImagesTestImagesChilds = uiElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("preview.static_assets_itemsimages_childsitems");
	}

	public void copyAndPasteLongTreeIntoExistentFolder(String childLocator, String destinationFolderLocator) {
		this.driverManager.waitForAnimation();
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayedAndClickable("xpath", childLocator);
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayedAndClickable("xpath", childLocator);
		this.driverManager.waitForAnimation();
		dashboardPage.rightClickCopyFolder(childLocator);
		this.driverManager.waitForAnimation();
		this.driverManager.waitForFullExpansionOfTree();
		dashboardPage.clickCopyButtonOnTreeSelector();

		this.driverManager.waitForAnimation();
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayedAndClickable("xpath", destinationFolderLocator);
		this.driverManager.waitForAnimation();
		this.driverManager.waitForFullExpansionOfTree();
		this.driverManager.contextClick("xpath", destinationFolderLocator, false);
		this.driverManager.waitUntilContentTooltipIsHidden();
		driverManager.usingContextMenu(() -> {
			this.driverManager.driverWaitUntilElementIsPresentAndDisplayedAndClickable("xpath", pasteOptionLocator)
					.click();
		}, "Pages");

	}

	public void loginAndGoToPreview(String siteId) {
		loginPage.loginToCrafter(userName, password);

		driverManager.waitUntilLoginCloses();

		// go to preview page
		homePage.goToPreviewPage(siteId);
		driverManager.clickElement("xpath", siteDropdownElementXPath);
	}

	public void createNewPageArticle(String folderLocation) {
		logger.info("Create Article Content");
		this.driverManager.waitForAnimation();
		previewPage.createPageArticleContentUsingUploadedImage("test", "Testing1", "test", folderLocation,
				selectAllCategoriesCheckBox, selectAllSegmentsCheckBox, "ArticleSubject", "ArticleAuthor",
				"ArticleSummary");

		this.driverManager.waitUntilSidebarOpens();
	}

	public void changeBodyToNotRequiredOnPageArticleContent() {
		previewPage.changeBodyOfArticlePageToNotRequired();
	}

	public void step1() {

		logger.info("Change Article Page body content to not required");
		this.changeBodyToNotRequiredOnPageArticleContent();

		this.driverManager.waitUntilSidebarOpens();

		// Expand Home Tree
		this.driverManager.waitForAnimation();
		dashboardPage.expandHomeTree();

		// expand Articles folder
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayedAndClickable("xpath", articlesFolder);
		dashboardPage.expandParentFolder(articlesFolder);

		this.driverManager.waitForAnimation();
		dashboardPage.expandParentFolder(firstChildLocator);

		this.driverManager.waitForAnimation();
		dashboardPage
				.expandParentFolder(firstChildLocator + "/../../../../../div[@class='ygtvchildren']//span[text()='3']");
		this.createNewPageArticle(firstChildLocator + "/../../../../../div[@class='ygtvchildren']//span[text()='3']");

		this.driverManager.waitForAnimation();
		dashboardPage.collapseParentFolder(
				firstChildLocator + "/../../../../../div[@class='ygtvchildren']//span[text()='3']");

		this.driverManager.waitForAnimation();
		dashboardPage.collapseParentFolder(firstChildLocator);

		this.driverManager.waitForFullExpansionOfTree();
		copyAndPasteLongTreeIntoExistentFolder(firstChildLocator, firstDestinationLocator);
		logger.info("Checking if the element {} was pasted with success", "/articles/2016/2017");
		Assert.assertTrue(this.driverManager
				.driverWaitUntilElementIsPresentAndDisplayedAndClickable("xpath", firstDestinationLocator + childFolder)
				.isDisplayed());
	}

	public void step2() {
		this.driverManager.waitForFullExpansionOfTree();
		this.driverManager.waitForFullExpansionOfTree();
		secondDestinationLocator = firstDestinationLocator + childFolder;
		copyAndPasteLongTreeIntoExistentFolder(firstChildLocator, secondDestinationLocator);
		logger.info("Checking if the element {} was pasted with success", "/articles/2016/2017/2017");
		Assert.assertTrue(this.driverManager.driverWaitUntilElementIsPresentAndDisplayedAndClickable("xpath",
				secondDestinationLocator + childFolder).isDisplayed());

		this.driverManager.scrollDownIntoSideBar();
		this.driverManager.waitForFullExpansionOfTree();
		thirdDestinationLocator = secondDestinationLocator + childFolder;
		copyAndPasteLongTreeIntoExistentFolder(firstChildLocator, thirdDestinationLocator);
		logger.info("Checking if the element {} was pasted with success", "/articles/2016/2017/2017/2017");
		Assert.assertTrue(this.driverManager
				.driverWaitUntilElementIsPresentAndDisplayedAndClickable("xpath", thirdDestinationLocator + childFolder)
				.isDisplayed());

		this.driverManager.waitForFullExpansionOfTree();
		fourthDestinationLocator = thirdDestinationLocator + childFolder;
		copyAndPasteLongTreeIntoExistentFolder(firstChildLocator, fourthDestinationLocator);
		logger.info("Checking if the element {} was pasted with success", "/articles/2016/2017/2017/2017/2017");
		Assert.assertTrue(this.driverManager.driverWaitUntilElementIsPresentAndDisplayedAndClickable("xpath",
				fourthDestinationLocator + childFolder).isDisplayed());

		this.driverManager.scrollDownIntoSideBar();
		this.driverManager.waitForFullExpansionOfTree();
		fifthDestinationLocator = fourthDestinationLocator + childFolder;
		copyAndPasteLongTreeIntoExistentFolder(firstChildLocator, fifthDestinationLocator);
		logger.info("Checking if the element {} was pasted with success", "/articles/2016/2017/2017/2017/2017/2017");
		Assert.assertTrue(this.driverManager
				.driverWaitUntilElementIsPresentAndDisplayedAndClickable("xpath", fifthDestinationLocator + childFolder)
				.isDisplayed());

		this.driverManager.waitForFullExpansionOfTree();
		sixthDestinationLocator = fifthDestinationLocator + childFolder;
		copyAndPasteLongTreeIntoExistentFolder(firstChildLocator, sixthDestinationLocator);
		logger.info("Checking if the element {} was pasted with success",
				"/articles/2016/2017/2017/2017/2017/2017/2017");
		Assert.assertTrue(this.driverManager
				.driverWaitUntilElementIsPresentAndDisplayedAndClickable("xpath", sixthDestinationLocator + childFolder)
				.isDisplayed());

		this.driverManager.scrollDownIntoSideBar();
		this.driverManager.waitForFullExpansionOfTree();
		seventhDestinationLocator = sixthDestinationLocator + childFolder;
		copyAndPasteLongTreeIntoExistentFolder(firstChildLocator, seventhDestinationLocator);
		logger.info("Checking if the element {} was pasted with success",
				"/articles/2016/2017/2017/2017/2017/2017/2017/2017");
		Assert.assertTrue(this.driverManager.driverWaitUntilElementIsPresentAndDisplayedAndClickable("xpath",
				seventhDestinationLocator + childFolder).isDisplayed());

		this.driverManager.waitForFullExpansionOfTree();
		eighthDestinationLocator = seventhDestinationLocator + childFolder;
		copyAndPasteLongTreeIntoExistentFolder(firstChildLocator, eighthDestinationLocator);
		logger.info("Checking if the element {} was pasted with success",
				"/articles/2016/2017/2017/2017/2017/2017/2017/2017/2017");
		Assert.assertTrue(this.driverManager.driverWaitUntilElementIsPresentAndDisplayedAndClickable("xpath",
				eighthDestinationLocator + childFolder).isDisplayed());

		this.driverManager.scrollDownIntoSideBar();
		this.driverManager.waitForFullExpansionOfTree();
		ninthDestinationLocator = eighthDestinationLocator + childFolder;
		copyAndPasteLongTreeIntoExistentFolder(firstChildLocator, ninthDestinationLocator);
		logger.info("Checking if the element {} was pasted with success",
				"/articles/2016/2017/2017/2017/2017/2017/2017/2017/2017/2017");
		Assert.assertTrue(this.driverManager
				.driverWaitUntilElementIsPresentAndDisplayedAndClickable("xpath", ninthDestinationLocator + childFolder)
				.isDisplayed());

		this.driverManager.waitForFullExpansionOfTree();
		tenthDestinationLocator = ninthDestinationLocator + childFolder;
		copyAndPasteLongTreeIntoExistentFolder(firstChildLocator, tenthDestinationLocator);
		logger.info("Checking if the element {} was pasted with success",
				"/articles/2016/2017/2017/2017/2017/2017/2017/2017/2017/2017/2017");
		Assert.assertTrue(this.driverManager
				.driverWaitUntilElementIsPresentAndDisplayedAndClickable("xpath", tenthDestinationLocator + childFolder)
				.isDisplayed());

		this.collapseFolders();

		this.driverManager.waitForAnimation();
		copyAndPasteLongTreeIntoExistentFolder(firstDestinationLocator, firstChildLocator);

		String elementClassValue = "";
		while (!(elementClassValue.contains("open"))) {
			elementClassValue = this.driverManager
					.driverWaitUntilElementIsPresentAndDisplayedAndClickable("xpath", firstChildLocator)
					.getAttribute("class");
		}

		this.assertContentImagesOnStaticAssets();
	}

	public void assertContentImagesOnStaticAssets() {
		// Collapse Home tree
		logger.info("Collapse Home tree");
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayedAndClickable("xpath", homeTree);
		this.driverManager.waitUntilFolderOpens("xpath", expandPagesTree);
		this.dashboardPage.expandHomeTree();

		logger.info("Click the Static Assets Tree");
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayedAndClickable("xpath", staticAssetsButton);
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayedAndClickable("xpath", staticAssetsButton).click();

		this.driverManager.driverWaitUntilElementIsPresentAndDisplayedAndClickable("xpath", staticAssetsChildFolder);
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayedAndClickable("xpath", staticAssetsChildFolder)
				.click();

		logger.info("Click the Static Assets/Page Tree");
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayedAndClickable("xpath",
				staticAssetsItemsChildFolder);
		this.driverManager
				.driverWaitUntilElementIsPresentAndDisplayedAndClickable("xpath", staticAssetsItemsChildFolder).click();

		logger.info("Click the Static Assets/item/images Tree");
		this.driverManager.waitUntilContentTooltipIsHidden();
		this.driverManager.waitForFullExpansionOfTree();
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayedAndClickable("xpath",
				staticAssetsItemsImagesChildFolder);
		this.driverManager
				.driverWaitUntilElementIsPresentAndDisplayedAndClickable("xpath",
						 staticAssetsItemsImagesChildFolder)
				.click();

		// Expanding Year folder
		String yearFolderXpath = ".//span[text()='" + this.driverManager.getCurrentYear() + "']";
		this.driverManager.waitUntilContentTooltipIsHidden();
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayedAndClickable("xpath", yearFolderXpath);
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayedAndClickable("xpath", yearFolderXpath).click();

		// Expanding Month folder
		String monthFolderXpath = yearFolderXpath + "/../../../../../div[@class='ygtvchildren']//span[text()='" + this.driverManager.getCurrentMonth() + "']";
		this.driverManager.waitUntilContentTooltipIsHidden();
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayedAndClickable("xpath", monthFolderXpath);
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayedAndClickable("xpath", monthFolderXpath).click();

		// Expanding Day folder
		String dayFolderXpath = monthFolderXpath + "/../../../../../div[@class='ygtvchildren']//span[text()='"+ this.driverManager.getCurrentDay()+"']";
		this.driverManager.waitUntilContentTooltipIsHidden();
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayedAndClickable("xpath", dayFolderXpath);
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayedAndClickable("xpath", dayFolderXpath).click();

		this.driverManager.waitForAnimation();
		this.driverManager.waitForFullExpansionOfTree();
		this.driverManager.scrollDownIntoSideBar();
		this.driverManager.waitForAnimation();

		String ImageItemsXpath = dayFolderXpath + staticAssetsItemImagesTestImagesChilds;
		List<WebElement> testimagesitems = this.driverManager.getDriver().findElements(By.xpath(ImageItemsXpath));
		Assert.assertTrue((testimagesitems.size() == 21),
				"There are not the correct amount of items for static asset/page/images/testimage.jpg , expected 21 items");
	}

	public void collapseFolders() {
		driverManager.getDriver().navigate().refresh();

		this.driverManager.scrollDownIntoSideBar();
		this.driverManager.waitForAnimation();
		this.driverManager.waitForFullExpansionOfTree();

		this.driverManager.scrollDownIntoSideBar();
		this.driverManager.waitForFullExpansionOfTree();
		this.driverManager.scrollDownIntoSideBar();
		dashboardPage.collapseParentFolder(tenthDestinationLocator);
		this.driverManager.waitForAnimation();
		dashboardPage.collapseParentFolder(ninthDestinationLocator);
		this.driverManager.waitForAnimation();
		dashboardPage.collapseParentFolder(eighthDestinationLocator);
		this.driverManager.waitForAnimation();
		dashboardPage.collapseParentFolder(seventhDestinationLocator);
		this.driverManager.waitForAnimation();
		dashboardPage.collapseParentFolder(sixthDestinationLocator);
		this.driverManager.waitForAnimation();
		dashboardPage.collapseParentFolder(fifthDestinationLocator);
		this.driverManager.waitForAnimation();
		dashboardPage.collapseParentFolder(fourthDestinationLocator);
		this.driverManager.waitForAnimation();
		dashboardPage.collapseParentFolder(thirdDestinationLocator);
		this.driverManager.waitForAnimation();
		dashboardPage.collapseParentFolder(secondDestinationLocator);
		this.driverManager.waitForAnimation();
		dashboardPage.collapseParentFolder(firstDestinationLocator);
	}

	public void expandAllCutTrees() {
		// expand 2016 parent
		this.driverManager.waitForFullExpansionOfTree();
		this.driverManager.waitForAnimation();
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayedAndClickable("xpath",
				firstChildLocator + "/../../../../../div[@class='ygtvchildren']//span[text()='2016']");
		dashboardPage.expandParentFolder(
				firstChildLocator + "/../../../../../div[@class='ygtvchildren']//span[text()='2016']");
		this.driverManager.waitForAnimation();
		this.driverManager.waitForFullExpansionOfTree();

		// expand the all folder tree
		for (int i = 0; i < 10; i++) {
			// append the last opened 2017 folder
			finalChildFolderLocator = finalChildFolderLocator + childFolder;

			this.driverManager.scrollDownIntoSideBar();
			this.driverManager.waitForAnimation();
			this.driverManager.waitForFullExpansionOfTree();
			this.driverManager.driverWaitUntilElementIsPresentAndDisplayedAndClickable("xpath",
					finalChildFolderLocator);

			// at first time expand the 2016 child on 2017 folder
			dashboardPage.expandParentFolder(finalChildFolderLocator);
		}
	}

	public void step3() {
		logger.info("Executing bulk publish");
		this.driverManager.waitUntilSidebarOpens();
		this.driverManager.waitForAnimation();
		this.driverManager.scrollDownIntoSideBar();

		previewPage.bulkPublish("/site/website/articles", 50000);

		driverManager.getDriver().navigate().refresh();
		this.driverManager.scrollDownIntoSideBar();
		this.driverManager.waitForAnimation();
		this.driverManager.waitForFullExpansionOfTree();

		logger.info("Collapse the Static Assets Tree");
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayedAndClickable("xpath", staticAssetsButton);
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayedAndClickable("xpath", staticAssetsButton).click();

		logger.info("Expand Home tree");
		this.dashboardPage.expandPagesTree();
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayedAndClickable("xpath", homeTree);
		this.driverManager.waitUntilFolderOpens("xpath", expandPagesTree);
		this.dashboardPage.expandHomeTree();

		// expand Articles folder
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayedAndClickable("xpath", articlesFolder);
		dashboardPage.expandParentFolder(articlesFolder);

		this.driverManager.scrollDownIntoSideBar();
		this.driverManager.waitForAnimation();

		this.driverManager.driverWaitUntilElementIsPresentAndDisplayedAndClickable("xpath", firstChildLocator);
		this.driverManager.waitForAnimation();
		dashboardPage.expandParentFolder(firstChildLocator);
		this.expandAllCutTrees();

		this.driverManager.waitForAnimation();
		this.driverManager.scrollDownIntoSideBar();
		this.driverManager.waitForAnimation();
		String articleXpath = finalChildFolderLocator
				+ "/../../../../../div[@class='ygtvchildren']/div//span[contains(text(),'Men Styles For Winter')]";

		logger.info("Verify Article is published");
		for (int i = 0; i < 2; i++) {
			this.driverManager.waitForAnimation();
			this.driverManager.waitForFullExpansionOfTree();
			this.driverManager.scrollDownIntoSideBar();
			this.driverManager.waitForFullExpansionOfTree();
			this.driverManager.waitUntilSidebarOpens();
			this.driverManager.scrollRightIntoSideBar(
					finalChildFolderLocator + "/../../../../../div[@class='ygtvchildren']//span[text()='1']");

			// if the folder is not expanded do a click on it
			if (!(this.driverManager
					.driverWaitUntilElementIsPresentAndDisplayedAndClickable("xpath",
							finalChildFolderLocator + "/../../../../../div[@class='ygtvchildren']//span[text()='1']")
					.getAttribute("class").contains("open"))) {
				this.driverManager.waitUntilContentTooltipIsHidden();
				this.driverManager.waitForAnimation();
				this.driverManager.waitForFullExpansionOfTree();
				this.driverManager.waitForAnimation();
				this.driverManager.driverWaitUntilElementIsPresentAndDisplayedAndClickable("xpath",
						finalChildFolderLocator + "/../../../../../div[@class='ygtvchildren']//span[text()='1']")
						.click();
			}

			try {
				// Wait for the article and click it.
				this.driverManager.driverWaitUntilElementIsPresentAndDisplayedAndClickable("xpath", articleXpath);
				this.driverManager.driverWaitUntilElementIsPresentAndDisplayedAndClickable("xpath", articleXpath)
						.click();
				this.driverManager.waitForAnimation();
				this.driverManager.waitUntilAttributeContains("xpath", topNavStatusIcon, "class", "undefined live");
				break;

			} catch (TimeoutException e) {
				this.driverManager.takeScreenshot("PageNotPublishedOnTopNavBar");
				logger.warn("Content page is not published yet, checking again if it has published icon on top bar");
				driverManager.getDriver().navigate().refresh();
			}
		}

		String elementClassValueTopNav = this.driverManager.getDriver().findElement(By.xpath(topNavStatusIcon))
				.getAttribute("class");
		Assert.assertTrue(elementClassValueTopNav.contains("undefined live"));

	}

	@Parameters({"testId"})
	@Test()
	public void verifyThatStudioAllowsToCopyPasteContentWithSharedComponents(String testId) {
		loginAndGoToPreview(testId);

		step1();

		step2();

		step3();
	}
}
