/*
 * Copyright (C) 2007-2018 Crafter Software Corporation. All Rights Reserved.
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

import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;

import java.util.LinkedList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.craftercms.studio.test.cases.StudioBaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
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

	private String userName;
	private String password;
	private String siteDropdownElementXPath;
	private String pagesTreeLink;
	private String pagesTree;
	private String homeContent;
	private String createFormFrameElementCss;
	private String homePageEditedName;
	private String homePageEditedExpand;
	private String menStylesEditedPageName;
	private String menStylesForWinterEditedPageName;
	private String rightClickOptions;
	private String crafterLogo;
	private String expandPagesTree;
	private String createSiteButton;
	private String siteconfigGroupsOption;
	private String editAuthorGroupOption;
	private String editReviewerGroupOption;
	private String groupsAddNewMembersCheckbox;
	private String groupsAddNewMembersInput;
	private String groupsAddNewMembersAutocompleteOption1;
	private String groupsAddNewMembersButton;
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
	private String siteDropdownListElementXPath;
	private static Logger logger = LogManager.getLogger(
			VerifyRightClickOptionsOfAnEditedAndRequestPublishPageUnderPageStructureUsingReviewerUser.class);

	@BeforeMethod
	public void beforeTest() {
		userName = constantsPropertiesManager.getSharedExecutionConstants().getProperty("crafter.username");
		password = constantsPropertiesManager.getSharedExecutionConstants().getProperty("crafter.password");
		siteDropdownElementXPath = uiElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("complexscenarios.general.sitedropdownmenuinnerxpath");
		pagesTreeLink = uiElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("general.sitecontent.expandpages");
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
		crafterLogo = uiElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("users.crafterlogo");
		expandPagesTree = uiElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("dashboard.expand_Pages_Tree");
		siteconfigGroupsOption = uiElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("adminconsole.groups_option");
		createSiteButton = uiElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("home.createsitebutton");
		editAuthorGroupOption = uiElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("groups.edit_author_group_option");
		editReviewerGroupOption = uiElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("groups.edit_reviewer_group_option");
		groupsAddNewMembersCheckbox = uiElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("groups.add_new_members_checkbox");
		groupsAddNewMembersInput = uiElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("groups.add_new_members_input");
		groupsAddNewMembersAutocompleteOption1 = uiElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("groups.add_new_members_autocomplete_option1");
		groupsAddNewMembersButton = uiElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("groups.add_new_members_button");
		userOptions = uiElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("dashboard.user_options");
		userOptionsLogout = uiElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("dashboard.user_options_logout");
		siteDropdownListElementXPath = uiElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("complexscenarios.general.sitedropdownlielement");

	}

	public void rightClickHomePage() {
		this.driverManager.waitUntilPageLoad();
		this.driverManager.waitUntilSidebarOpens();

		this.driverManager.waitUntilFolderOpens("xpath", pagesTree);
		this.driverManager.waitForAnimation();

		this.driverManager.driverWaitUntilElementIsPresentAndDisplayedAndClickable("xpath",
				homePageEditedName);
		dashboardPage.getDriverManager().contextClick("xpath", homePageEditedName, false);

	}

	public void rightClickCategoryLandingPage() {
		this.driverManager.waitUntilPageLoad();
		this.driverManager.waitUntilSidebarOpens();
		this.driverManager.waitForAnimation();

		this.driverManager.driverWaitUntilElementIsPresentAndDisplayedAndClickable("xpath",
				menStylesEditedPageName);
		dashboardPage.getDriverManager().contextClick("xpath", menStylesEditedPageName, false);
		this.driverManager.waitForAnimation();
	}

	public void rightClickArticlesFolderMenStylesForWinter() {
		this.driverManager.waitUntilPageLoad();
		this.driverManager.waitUntilSidebarOpens();
		this.driverManager.waitForAnimation();

		this.driverManager.driverWaitUntilElementIsPresentAndDisplayedAndClickable("xpath",
				menStylesForWinterEditedPageName);
		dashboardPage.getDriverManager().contextClick("xpath", menStylesForWinterEditedPageName, false);
		this.driverManager.waitForAnimation();
	}

	public void verifyViewOptionIsPresent(String section) {
		WebElement rightclickViewOptionElement = this.driverManager
				.driverWaitUntilElementIsPresentAndDisplayed("xpath", rightclickViewOption);
		Assert.assertTrue(rightclickViewOptionElement.isDisplayed(),
				"ERROR: Right click View Option is not present on right click of " + section);
	}

	public void verifyCopyOptionIsPresent(String section) {
		WebElement rightclickCopyOptionElement = this.driverManager
				.driverWaitUntilElementIsPresentAndDisplayed("xpath", rightclickCopyOption);
		Assert.assertTrue(rightclickCopyOptionElement.isDisplayed(),
				"ERROR: Right click Copy Option is not present on right click of " + section);
	}

	public void verifyApproveAndPublishOptionIsPresent(String section) {
		WebElement rightclickApproveAndPublishOptionElement = this.driverManager
				.driverWaitUntilElementIsPresentAndDisplayed("xpath", rightclickApproveAndPublishOption);
		Assert.assertTrue(rightclickApproveAndPublishOptionElement.isDisplayed(),
				"ERROR: Right click Approve and Publish Option is not present on right click of " + section);
	}

	public void verifyDependenciesOptionIsPresent(String section) {
		WebElement rightclickDependenciesOptionElement = this.driverManager
				.driverWaitUntilElementIsPresentAndDisplayed("xpath", rightclickDependenciesOption);
		Assert.assertTrue(rightclickDependenciesOptionElement.isDisplayed(),
				"ERROR: Right click Dependencies Option is not present on right click of " + section);
	}

	public void step4() {
		// Step 4 Right Right click on "Home" and verify options
		logger.info("Step 4 Right click on the Edited and Requested Publish Home Page To verify options");
		this.rightClickHomePage();

		driverManager.usingContextMenu(() -> {
			logger.info("Checking that only the expected options are listed");
			rightClickOptionsListInHomePage = new LinkedList<String>();
			rightClickOptionsListInHomePage.add(0, "View");
			rightClickOptionsListInHomePage.add(1, "Copy");
			rightClickOptionsListInHomePage.add(2, "Approve & Publish");
			rightClickOptionsListInHomePage.add(3, "Dependencies");

			List<WebElement> rightClickOptionsList = this.driverManager.getDriver()
					.findElements(By.xpath(rightClickOptions));
			int currentIndex = 0;
			for (WebElement element : rightClickOptionsList) {
				this.driverManager.waitForAnimation();
				this.driverManager.waitUntilSidebarOpens();
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

			this.driverManager.getDriver().navigate().refresh();
			this.driverManager.waitForAnimation();
			this.driverManager.waitUntilSidebarOpens();
		}, "Pages");
	}

	public void step6() {
		// Step 6 Right click on any Category Landing page and verify options
		logger.info(
				"Step 6 Right click on the Edited and Requested Publish Category Landing Page (Style) Page To verify options");
		this.rightClickCategoryLandingPage();

		driverManager.usingContextMenu(() -> {
			logger.info("Checking that only the expected options are listed");
			rightClickOptionsListInCategoryLandingPage = new LinkedList<String>();
			rightClickOptionsListInCategoryLandingPage.add(0, "View");
			rightClickOptionsListInCategoryLandingPage.add(1, "Copy");
			rightClickOptionsListInCategoryLandingPage.add(2, "Approve & Publish");
			rightClickOptionsListInCategoryLandingPage.add(3, "Dependencies");

			List<WebElement> rightClickOptionsList = this.driverManager.getDriver()
					.findElements(By.xpath(rightClickOptions));
			int currentIndex = 0;
			for (WebElement element : rightClickOptionsList) {
				this.driverManager.waitForAnimation();
				this.driverManager.waitUntilSidebarOpens();
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

			this.driverManager.getDriver().navigate().refresh();
			this.driverManager.waitForAnimation();
		}, "Pages");
	}

	public void expandTheArticles2017folder() {
		// Step 8 Click on the + of folder 2017
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayedAndClickable("xpath",
				articlesFolder2017);
		this.driverManager.waitUntilContentTooltipIsHidden();
		this.driverManager.clickIfFolderIsNotExpanded(articlesFolder2017);
		this.driverManager.waitUntilFolderOpens("xpath", articlesFolder2017);
	}

	public void step10() {
		// Step 10 Right click on any of the article (Men Styles For Winter)
		logger.info(
				"Step 10 Right click on the Edited and Requested Publish article Men Styles For Winter Page To verify options");
		this.driverManager.waitForAnimation();

		this.rightClickArticlesFolderMenStylesForWinter();

		driverManager.usingContextMenu(() -> {

			logger.info("Checking that only the expected options are listed");
			rightClickOptionsListInMenStylesForWinterPage = new LinkedList<String>();
			rightClickOptionsListInMenStylesForWinterPage.add(0, "View");
			rightClickOptionsListInMenStylesForWinterPage.add(1, "Copy");
			rightClickOptionsListInMenStylesForWinterPage.add(2, "Approve & Publish");
			rightClickOptionsListInMenStylesForWinterPage.add(3, "Dependencies");

			List<WebElement> rightClickOptionsList = this.driverManager.getDriver()
					.findElements(By.xpath(rightClickOptions));
			int currentIndex = 0;
			for (WebElement element : rightClickOptionsList) {
				this.driverManager.waitForAnimation();
				this.driverManager.waitUntilSidebarOpens();
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

			this.driverManager.getDriver().navigate().refresh();
			this.driverManager.waitForAnimation();
		}, "Pages");

	}

	public void editHomePage() {
		// Step 3 Edit the Home Page and Save
		logger.info("Edit the Home Page and Save");
		dashboardPage.rightClickEditOnAPresentPage(homeContent);

		driverManager.usingCrafterForm("cssSelector", createFormFrameElementCss, () -> {

			// creating random values for URL field and InternalName field

			String randomInternalName = "HomePageEdited";

			// Set basics fields of the new content created

			dashboardPage.editInternalName(randomInternalName);
		});

		this.driverManager.waitUntilSidebarOpens();
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("Xpath", homePageEditedName);

	}

	public void editLandingPageStylePage() {

		dashboardPage.rightClickEditOnAPresentPage(styleLandingpage);

		driverManager.usingCrafterForm("cssSelector", createFormFrameElementCss, () -> {

			// creating random values for URL field and InternalName field

			String randomInternalName = "StylePageEdited";

			// Set basics fields of the new content created

			dashboardPage.editInternalName(randomInternalName);
		});

		this.driverManager.waitUntilSidebarOpens();
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("Xpath", menStylesEditedPageName);

	}

	public void editMenStylesForWinterPage() {

		dashboardPage.rightClickEditOnAPresentPage(articlesFolderMenStylesForWinter);

		driverManager.usingCrafterForm("cssSelector", createFormFrameElementCss, () -> {

			// creating random values for URL field and InternalName field

			String randomInternalName = "MenStylesForWinterEdited";

			// Set basics fields of the new content created

			dashboardPage.editInternalName(randomInternalName);
		});

		this.driverManager.waitUntilSidebarOpens();
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("Xpath",
				menStylesForWinterEditedPageName);

	}

	public void expandHomeTree() {
		this.driverManager.waitUntilSidebarOpens();
		this.driverManager.waitForAnimation();

		// Verify if the home tree is already expanded
		if (!(this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("xpath", homePageEditedName)
				.getAttribute("class").contains("open"))) {
			this.driverManager
					.driverWaitUntilElementIsPresentAndDisplayedAndClickable("xpath", homePageEditedExpand)
					.click();
		}

	}

	public void login(String user, String loginpassword) {

		// login to application
		loginPage.loginToCrafter(user, loginpassword);

		// Wait for login page to close
		driverManager.waitUntilLoginCloses();
	}

	public void addNewUser(String userToAdd) {

		// click On Users option
		createSitePage.clickOnUsersOption();

		// click on new user button
		usersPage.addNewUser(userToAdd);

		// Switch to the form

		driverManager.getDriver().navigate().refresh();

		driverManager.getDriver().switchTo().defaultContent();
		this.driverManager.waitForAnimation();

		this.driverManager.driverWaitUntilElementIsPresentAndDisplayedAndClickable("xpath",

				crafterLogo);

		this.driverManager.driverWaitUntilElementIsPresentAndDisplayedAndClickable("xpath",

				crafterLogo).click();
	}

	private void goToSiteContentPagesStructure() {

		this.driverManager.driverWaitUntilElementIsPresentAndDisplayedAndClickable("xpath", createSiteButton);

		this.driverManager.waitForAnimation();
		homePage.goToPreviewPage();

		this.driverManager.waitForAnimation();
		if (this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("xpath", siteDropdownElementXPath)
				.isDisplayed()) {
			if (!(this.driverManager.waitUntilElementIsPresent("xpath", siteDropdownListElementXPath)
					.getAttribute("class").contains("site-dropdown-open")))
				this.driverManager
						.driverWaitUntilElementIsPresentAndDisplayed("xpath", siteDropdownElementXPath)
						.click();
		} else
			throw new NoSuchElementException(
					"Site creation process is taking too long time and the element was not found");
	}

	public void addUserToRespectiveGroup(String userGroup, String userToAdd) {

		this.driverManager.driverWaitUntilElementIsPresentAndDisplayedAndClickable("xpath",
				siteconfigGroupsOption);

		this.driverManager
				.driverWaitUntilElementIsPresentAndDisplayedAndClickable("xpath", siteconfigGroupsOption)

				.click();
		this.driverManager.waitForAnimation();
		driverManager.getDriver().switchTo().defaultContent();
		this.driverManager.getDriver().switchTo().activeElement();

		this.driverManager.driverWaitUntilElementIsPresentAndDisplayedAndClickable("xpath",

				userGroup);

		this.driverManager

				.driverWaitUntilElementIsPresentAndDisplayedAndClickable("xpath", userGroup)

				.click();

		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("xpath", groupsAddNewMembersCheckbox);

		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("xpath", groupsAddNewMembersCheckbox)
				.click();

		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("xpath", groupsAddNewMembersInput)
				.sendKeys(userToAdd);

		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("xpath",
				groupsAddNewMembersAutocompleteOption1);
		this.driverManager
				.driverWaitUntilElementIsPresentAndDisplayed("xpath", groupsAddNewMembersAutocompleteOption1)
				.click();

		this.driverManager.driverWaitUntilElementIsPresentAndDisplayedAndClickable("xpath",
				groupsAddNewMembersButton);

		this.driverManager
				.driverWaitUntilElementIsPresentAndDisplayedAndClickable("xpath", groupsAddNewMembersButton)
				.click();

		this.driverManager.waitForAnimation();
		driverManager.getDriver().switchTo().defaultContent();
		this.driverManager.getDriver().switchTo().activeElement();

		this.driverManager.waitUntilAddUserModalCloses();
		this.driverManager.waitForAnimation();

		createSitePage.clickOnSitesOption();
	}

	private void logoutFromCrafter() {
		logger.info("logout from Crafter");

		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("xpath", userOptions);

		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("xpath", userOptions).click();

		this.driverManager.driverWaitUntilElementIsPresentAndDisplayedAndClickable("xpath",
				userOptionsLogout);

		this.driverManager.driverWaitUntilElementIsPresentAndDisplayedAndClickable("xpath", userOptionsLogout)
				.click();

	}

	public void expandPagesTree() {
		// Expand the site bar
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("xpath", siteDropdownElementXPath);

		Assert.assertTrue(this.driverManager.isElementPresentAndClickableByXpath(siteDropdownElementXPath));

		// Click on Pages tree
		this.driverManager.clickIfFolderIsNotExpanded(pagesTreeLink);

		this.driverManager.waitUntilFolderOpens("xpath", pagesTreeLink);
	}

	@Test(
			priority = 0)
	public void verifyRightClickOptionsOfAnEditedAndRequestPublishPageUnderPageStructureUsingReviewerUser() {

		this.login(userName, password);
		// wait for login page to close
		driverManager.waitUntilLoginCloses();

		logger.info("Add New User Author");
		this.addNewUser("author");

		logger.info("Add New User Reviewer");
		this.addNewUser("reviewer");

		logger.info("Add previous created author user to Author Group");
		this.addUserToRespectiveGroup(editAuthorGroupOption, "author");

		logger.info("Add previous created reviewer user to Reviewer Group");
		this.addUserToRespectiveGroup(editReviewerGroupOption, "reviewer");

		logger.info("Go to Site Preview");
		this.goToSiteContentPagesStructure();

		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("xpath", expandPagesTree);

		this.driverManager.waitUntilSidebarOpens();

		// logout from Crafter
		this.logoutFromCrafter();

		// login to application with author user
		logger.info("login to application with Author user");
		loginPage.loginToCrafter("author", "author");

		// wait for login page to close
		driverManager.waitUntilLoginCloses();

		logger.info("Go to Preview Page");
		this.homePage.goToPreviewPage();

		this.driverManager.waitForAnimation();

		// Expand the site bar and Pages Tree
		this.expandPagesTree();

		logger.info("Edit the home page");
		this.editHomePage();

		logger.info("Request Publish for home page");
		this.rightClickHomePage();
		dashboardPage.requestPublish();
		this.driverManager.waitUntilSidebarOpens();

		logger.info("Click on the + of Home tree and Edit the selected Category Landing Page");
		this.expandHomeTree();

		logger.info("Edit the Category Landing Page(Style) and Save");
		this.editLandingPageStylePage();

		logger.info("Request Publish for the Category Landin Page (Style)");
		this.rightClickCategoryLandingPage();
		dashboardPage.requestPublish();
		this.driverManager.waitUntilSidebarOpens();

		logger.info("Click on the + of Articles tree to expand the tree");
		this.driverManager.waitForAnimation();
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayedAndClickable("xpath", articlesFolder);
		this.driverManager.waitUntilContentTooltipIsHidden();

		this.driverManager.clickIfFolderIsNotExpanded(articlesFolder);
		this.driverManager.waitUntilFolderOpens("xpath", articlesFolder);

		logger.info("Click on the + of folder 2017");
		this.expandTheArticles2017folder();

		logger.info(
				"Click on the + of folder 1 and Edit then article page Men Styles For Winter under articles/2017/1");
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayedAndClickable("xpath", articlesFolder1)
				.click();
		this.driverManager.waitUntilFolderOpens("xpath", articlesFolder1);

		logger.info("Edit the Men Styles for Winter Pageand Save");
		this.editMenStylesForWinterPage();

		logger.info("Request Publish for the Men Styles For Winter under articles/2017/1 folders");
		rightClickArticlesFolderMenStylesForWinter();
		dashboardPage.requestPublish();

		// logout from Crafter
		this.logoutFromCrafter();

		// login to application with Reviewer user
		logger.info("login to application with Reviewer user");
		loginPage.loginToCrafter("reviewer", "reviewer");

		logger.info("Go to Preview Page");
		this.homePage.goToPreviewPage();

		this.driverManager.waitForAnimation();

		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("xpath", siteDropdownElementXPath);

		Assert.assertTrue(this.driverManager.isElementPresentAndClickableByXpath(siteDropdownElementXPath));

		this.step4();

		this.step6();

		this.step10();
	}
}
