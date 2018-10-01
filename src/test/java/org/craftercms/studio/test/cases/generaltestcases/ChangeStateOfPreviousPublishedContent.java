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
package org.craftercms.studio.test.cases.generaltestcases;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.Assert;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.craftercms.studio.test.cases.StudioBaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;

/**
 * 
 * @author Juan Camacho
 *
 * 
 * 
 */

public class ChangeStateOfPreviousPublishedContent extends StudioBaseTest {

	private String userName;
	private String password;
	private String selectAllSegmentsCheckBox;
	private String selectAllCategoriesCheckBox;
	private String siteconfigGroupsOption;
	private String userOptions;
	private String userOptionsLogout;
	private String requestPublishButton;
	private String publishSubmitButton;
	private String cancelWorkflowContinueButton;
	private String staticAssetsButton;
	private String homeTree;
	private String sidebarMenuOption;
	private String dependenciesMenuOption;
	private String staticAssetsChildFolder;
	private String staticAssetsImagesChildFolder;
	private String editAuthorGroupOption;
	private String groupsAddNewMembersCheckbox;
	private String groupsAddNewMembersInput;
	private String groupsAddNewMembersAutocompleteOption1;
	private String groupsAddNewMembersButton;
	private String generalSiteDropdown;
	private String pageStatus;
	private String staticAssetsGearImageXpath;
	private String articlesFolder;
	private String createFormFrameElementCss;
	private String generalEditOption;
	private String expandPagesTree;
	private String editedPageArticleName;
	private String articleTitle;
	private String createSiteButton;
	private String siteDropdownElementXPath;
	private String newUserFirstNameId;
	private String newUserLastNameId;
	private String newUserEmailId;
	private String newUserUserNameId;
	private String newUserPasswordId;
	private String newUserPasswordVerificationId;
	private String newUserUserNameCreatedXpath;
	private String articleContentCreatedName;
	private String gearImageXpath;
	private String siteDropdownListElementXPath;
	private int numberOfAttemptsForElementsDisplayed;
	private static Logger logger = LogManager.getLogger(ChangeStateOfPreviousPublishedContent.class);

	@BeforeMethod

	public void beforeTest() {

		userName = constantsPropertiesManager.getSharedExecutionConstants().getProperty("crafter.username");
		password = constantsPropertiesManager.getSharedExecutionConstants().getProperty("crafter.password");
		articlesFolder = uiElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("dashboard.articlesfolder");
		selectAllSegmentsCheckBox = uiElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("frame2.article_select_all_segments_checkbox");
		selectAllCategoriesCheckBox = uiElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("frame2.select_All_Categories_CheckBox");
		siteconfigGroupsOption = uiElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("adminconsole.groups_option");
		userOptions = uiElementsPropertiesManager.getSharedUIElementsLocators().getProperty("dashboard.user_options");
		userOptionsLogout = uiElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("dashboard.user_options_logout");
		requestPublishButton = uiElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("general.requestpublishtopnavoption");
		publishSubmitButton = uiElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("general.approve&publish.submit");
		cancelWorkflowContinueButton = uiElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("preview.workflow_cancellation_continue_Button");
		staticAssetsButton = uiElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("preview.static_assets_button");
		homeTree = uiElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("dashboard.expand_GlobalEntry_Tree");
		sidebarMenuOption = uiElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("complexscenarios.general.sitedropdownmenuinnerxpath");
		dependenciesMenuOption = uiElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("general.dependenciestopnavoption");
		staticAssetsChildFolder = uiElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("preview.static_assets_child_folder");
		staticAssetsImagesChildFolder = uiElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("preview.static_assets_images_child_folder");
		editAuthorGroupOption = uiElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("groups.edit_author_group_option");
		groupsAddNewMembersCheckbox = uiElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("groups.add_new_members_checkbox");
		groupsAddNewMembersInput = uiElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("groups.add_new_members_input");
		groupsAddNewMembersAutocompleteOption1 = uiElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("groups.add_new_members_autocomplete_option1");
		groupsAddNewMembersButton = uiElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("groups.add_new_members_button");
		generalSiteDropdown = uiElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("general.sitedropdown");
		pageStatus = uiElementsPropertiesManager.getSharedUIElementsLocators().getProperty("general.pageStatus");
		staticAssetsGearImageXpath = uiElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("preview.staticassets.gear.image.xpath");
		createFormFrameElementCss = uiElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("complexscenarios.general.createformframe");
		generalEditOption = uiElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("general.edittopnavoption");
		expandPagesTree = uiElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("dashboard.expand_Pages_Tree");
		editedPageArticleName = uiElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("complexscenarios.general.editedarticlename");
		articleTitle = uiElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("complexscenarios.general.cssarticletitle");
		createSiteButton = uiElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("home.createsitebutton");
		siteDropdownElementXPath = uiElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("complexscenarios.general.sitedropdown");
		newUserFirstNameId = uiElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("general.users.firstname");
		newUserLastNameId = uiElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("general.users.lastname");
		newUserEmailId = uiElementsPropertiesManager.getSharedUIElementsLocators().getProperty("general.users.email");
		newUserUserNameId = uiElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("general.users.username");
		newUserPasswordId = uiElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("general.users.password");
		newUserPasswordVerificationId = uiElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("general.users.passwordVerification");
		newUserUserNameCreatedXpath = uiElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("general.users.authorusernamecreated");
		articleContentCreatedName = uiElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("general.testingcontentitem");
		gearImageXpath = uiElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("complexscenarios.general.gearimagexpath");
		siteDropdownListElementXPath = uiElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("complexscenarios.general.sitedropdownlielement");
		this.numberOfAttemptsForElementsDisplayed = Integer.parseInt(constantsPropertiesManager
				.getSharedExecutionConstants().getProperty("crafter.numberofattemptsforelementdisplayed"));
		
	}

	public void addNewUser() {

		// click On Users option

		createSitePage.clickOnUsersOption();

		// click on new user button

		usersPage.clickOnNewUser();

		// Follow the form
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("xpath", newUserFirstNameId).sendKeys("Name");

		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("xpath", newUserLastNameId)
				.sendKeys("Last Name");

		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("xpath", newUserEmailId)
				.sendKeys("email@email.com");

		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("xpath", newUserUserNameId).sendKeys("author");

		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("xpath", newUserPasswordId).sendKeys("author");

		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("xpath", newUserPasswordVerificationId)
				.sendKeys("author");

		// Save Button
		usersPage.clickOnSaveNewUser();

		// Assert new users created is present
		WebElement newUserCreated = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("xpath",
				newUserUserNameCreatedXpath);

		Assert.assertTrue(newUserCreated.isDisplayed(), "ERROR: Recently created user is not displayed");

		// Switch to the form
		driverManager.getDriver().navigate().refresh();

		driverManager.getDriver().switchTo().defaultContent();

	}

	public void login(String user, String loginpassword) {
		// login to application
		loginPage.loginToCrafter(user, loginpassword);
		// Wait for login page to close
		driverManager.waitUntilLoginCloses();

	}

	public void editPageArticleContent(String pageName) {

		driverManager.usingCrafterForm("cssSelector", createFormFrameElementCss, () -> {

			// creating random values for URL field and InternalName field

			String randomInternalName = pageName;

			// Set basics fields of the new content created

			dashboardPage.updateFieldsOfPageArticleContent(randomInternalName, pageName);

			// Set the title of main content
			this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("xpath", articleTitle).clear();

			this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("xpath", articleTitle).sendKeys(pageName);

			// save and close
			this.driverManager.waitForAnimation();
			this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("id", "cstudioSaveAndClose").click();

		});

		this.driverManager.waitUntilSidebarOpens();

	}

	public void changeBodyToNotRequiredOnPageArticleContent() {
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("xpath", generalSiteDropdown).click();

		previewPage.changeBodyOfArticlePageToNotRequired();
		
		previewPage.changeDateOfArticlePageToNotRequired();

	}

	public void addUserToAuthorGroup() {

		this.driverManager.driverWaitUntilElementIsPresentAndDisplayedAndClickable("xpath",
				siteconfigGroupsOption);

		this.driverManager
				.driverWaitUntilElementIsPresentAndDisplayedAndClickable("xpath", siteconfigGroupsOption)

				.click();
		this.driverManager.waitForAnimation();
		driverManager.getDriver().switchTo().defaultContent();
		this.driverManager.getDriver().switchTo().activeElement();

		this.driverManager.driverWaitUntilElementIsPresentAndDisplayedAndClickable("xpath",

				editAuthorGroupOption);

		this.driverManager
				.driverWaitUntilElementIsPresentAndDisplayedAndClickable("xpath", editAuthorGroupOption)
				.click();

		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("xpath", groupsAddNewMembersCheckbox);

		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("xpath", groupsAddNewMembersCheckbox)
				.click();

		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("xpath", groupsAddNewMembersInput)
				.sendKeys("author");

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

	private void goToSiteContentPagesStructure() {

		this.driverManager.driverWaitUntilElementIsPresentAndDisplayedAndClickable("xpath",

				createSiteButton);

		homePage.goToPreviewPage();

		if (this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("xpath", siteDropdownElementXPath)
				.isDisplayed())
			if (!(this.driverManager.waitUntilElementIsPresent("xpath", siteDropdownListElementXPath)
					.getAttribute("class").contains("site-dropdown-open")))
				this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("xpath", siteDropdownElementXPath)
						.click();
			else
				throw new NoSuchElementException(
						"Site creation process is taking too long time and the element was not found");

	}

	private void renamePage(String parentPage, String newPageName) {

		dashboardPage.rightClickEditOnAPresentPage(parentPage);

		// creating new Page Article into the empty folder

		this.editPageArticleContent(newPageName);

	}

	private void renamePageWithWorkflowCancelation(String parentPage, String newPageName) {

		dashboardPage.rightClickEditOnAPresentPage(parentPage);

		// Cancel the Workflow

		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("xpath", cancelWorkflowContinueButton);

		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("xpath", cancelWorkflowContinueButton).click();

		// Edit PAge Article

		this.editPageArticleContent(newPageName);

	}

	private void logoutFromCrafter() {

		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("xpath", userOptions);

		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("xpath", userOptions).click();

		this.driverManager.driverWaitUntilElementIsPresentAndDisplayedAndClickable("xpath", userOptionsLogout);

		this.driverManager.driverWaitUntilElementIsPresentAndDisplayedAndClickable("xpath", userOptionsLogout).click();

	}

	private void requestPublish(String newPageArticleName) {
		this.driverManager.waitForFullExpansionOfTree();
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayedAndClickable("xpath",
				".//span[contains(text(),'" + newPageArticleName + "')]");
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayedAndClickable("xpath",
				".//span[contains(text(),'" + newPageArticleName + "')]").click();

		this.driverManager.getDriver().navigate().refresh();

		this.driverManager.driverWaitUntilElementIsPresentAndDisplayedAndClickable("xpath", requestPublishButton);

		this.driverManager.driverWaitUntilElementIsPresentAndDisplayedAndClickable("xpath", requestPublishButton)
				.click();

		this.driverManager.driverWaitUntilElementIsPresentAndDisplayedAndClickable("xpath", publishSubmitButton);

		this.driverManager.driverWaitUntilElementIsPresentAndDisplayedAndClickable("xpath", publishSubmitButton)
				.click();

	}

	public void testScenario() {

		// Related to the bug:
		// issue https://github.com/craftercms/craftercms/issues/1557
		this.login(userName, password);

		logger.info("Adding New User");

		this.addNewUser();

		logger.info("Add previous created user to Author Group");
		this.addUserToAuthorGroup();
		
		logger.info("Go to Site Preview");
		this.goToSiteContentPagesStructure();

		// expand pages folder
		this.dashboardPage.expandPagesTree();

		this.driverManager.waitUntilFolderOpens("xpath", expandPagesTree);

		this.driverManager.waitUntilSidebarOpens();


		// body not required Page-Article
		logger.info("Change Article Page body content to not required");

		this.changeBodyToNotRequiredOnPageArticleContent();

		this.driverManager.driverWaitUntilElementIsPresentAndDisplayedAndClickable("id",

				"admin-console");

		// expand Home tree
		this.driverManager.waitUntilFolderOpens("xpath", expandPagesTree);

		this.dashboardPage.expandHomeTree();

		this.driverManager.getDriver().navigate().refresh();

		logger.info("Create Article Content");
		this.driverManager.waitForAnimation();
		previewPage.createPageArticleContent("test", "Testing1", "test", articlesFolder, selectAllCategoriesCheckBox,

				selectAllSegmentsCheckBox, "ArticleSubject", "ArticleAuthor", "ArticleSummary");

		// Switch back to the dashboard page
		this.driverManager.getDriver().switchTo().activeElement();
		this.driverManager.getDriver().navigate().refresh();

		// Open dependencies for the previous created element
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayedAndClickable("xpath", articlesFolder);

		this.driverManager.driverWaitUntilElementIsPresentAndDisplayedAndClickable("xpath", articlesFolder).click();

		this.driverManager.driverWaitUntilElementIsPresentAndDisplayedAndClickable("xpath", sidebarMenuOption).click();

		this.driverManager.driverWaitUntilElementIsPresentAndDisplayedAndClickable("xpath", sidebarMenuOption).click();

		this.driverManager.waitUntilSidebarOpens();

		// Bulk Publish
		logger.info("Executing bulk publish");
		previewPage.bulkPublish("/", 30000);

		this.driverManager.waitForAnimation();
		this.driverManager.waitForFullExpansionOfTree();
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayedAndClickable("xpath", articlesFolder);
		this.driverManager.clickIfFolderIsNotExpanded(articlesFolder);

		// Verify Article is published
		logger.info("Verify Article is published");
		this.driverManager.waitForAnimation();
		this.driverManager.waitForFullExpansionOfTree();
		previewPage.verifyPageArticleIsPublished();

		// logout from Crafter
		logger.info("logout from Crafter");
		this.logoutFromCrafter();

		// login to application with author user
		logger.info("login to application with author user");
		loginPage.loginToCrafter("author", "author");

		logger.info("Go to Preview Page");
		this.homePage.goToPreviewPage();

		this.driverManager.waitForAnimation();
		this.driverManager.waitUntilFolderOpens("xpath", expandPagesTree);

		this.driverManager.waitForAnimation();
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("xpath", generalEditOption);
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayedAndClickable("xpath", articlesFolder);

		this.driverManager.waitUntilContentTooltipIsHidden();
		this.driverManager.waitForAnimation();
		WebElement articlesFolderElement = this.driverManager
				.driverWaitUntilElementIsPresentAndDisplayedAndClickable("xpath", articlesFolder);

		if (!(articlesFolderElement.getAttribute("class").contains("open"))) {
			articlesFolderElement.click();
		}

		this.driverManager.waitForAnimation();

		this.driverManager.driverWaitUntilElementIsPresentAndDisplayedAndClickable("xpath", articleContentCreatedName);

		this.driverManager.waitUntilContentTooltipIsHidden();

		this.driverManager.driverWaitUntilElementIsPresentAndDisplayedAndClickable("xpath", articleContentCreatedName)
				.click();

		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("xpath", articleContentCreatedName);

		// Edit content Page with the Author User
		logger.info("Edit content Page with the Author User");
		String newPageArticleName = "Testing1Edited";
		this.renamePage(articleContentCreatedName, newPageArticleName);

		// request publish
		logger.info("Request Publish");
		this.driverManager.waitForAnimation();
		this.requestPublish(newPageArticleName);

		// Open dependencies for the previous created element
		this.driverManager.waitForAnimation();
		this.driverManager.waitUntilPublishMaskedModalCloses();

		logger.info("Open dependencies for the previous created element");
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayedAndClickable("xpath", generalEditOption);
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayedAndClickable("xpath", dependenciesMenuOption);

		this.driverManager.waitForAnimation();
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayedAndClickable("xpath", dependenciesMenuOption)
				.click();

		// check dependencies are listed
		logger.info("Check Listed Dependencies");
		previewPage.checkDependencies();

		// Cancel the Workflow and Edit again the Page Article Content
		newPageArticleName = "Testing1Edited2";
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("xpath", editedPageArticleName);

		logger.info("Edit again the Page Article Page");

		this.renamePageWithWorkflowCancelation(editedPageArticleName, newPageArticleName);

		// Collapse Home tree

		logger.info("Collapse Home tree");

		this.driverManager.driverWaitUntilElementIsPresentAndDisplayedAndClickable("xpath", generalEditOption);

		this.driverManager.driverWaitUntilElementIsPresentAndDisplayedAndClickable("xpath", homeTree);

		this.driverManager.waitUntilFolderOpens("xpath", expandPagesTree);

		this.dashboardPage.expandHomeTree();

		logger.info("Click the Static Assets Button");

		this.driverManager.driverWaitUntilElementIsPresentAndDisplayedAndClickable("xpath", staticAssetsButton);

		this.driverManager.driverWaitUntilElementIsPresentAndDisplayedAndClickable("xpath", staticAssetsButton).click();

		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("xpath", staticAssetsChildFolder);

		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("xpath", staticAssetsChildFolder).click();

		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("xpath", staticAssetsImagesChildFolder);

		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("xpath", staticAssetsImagesChildFolder).click();

		this.driverManager.driverWaitUntilElementIsPresentAndDisplayedAndClickable("xpath", staticAssetsGearImageXpath);
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayedAndClickable("xpath", staticAssetsGearImageXpath)
				.click();
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayedAndClickable("xpath", dependenciesMenuOption);

		for (int i = 0; i < numberOfAttemptsForElementsDisplayed; i++) {
			try {
				this.driverManager.driverWaitUntilElementIsPresentAndDisplayedAndClickable("xpath", pageStatus).click();
				this.driverManager.waitUntilAttributeContains("xpath", pageStatus, "class", "undefined live");
				break;
			} catch (TimeoutException e) {
				this.driverManager.takeScreenshot("PageNotPublishedOnTopNavBar");
				logger.warn("Content page is not published yet, checking again if it has published icon on top bar");
				this.driverManager.waitForAnimation();
				this.driverManager.driverWaitUntilElementIsPresentAndDisplayedAndClickable("xpath", gearImageXpath)
						.click();
				driverManager.getDriver().navigate().refresh();
			}
		}

		Assert.assertTrue(this.driverManager.getDriver().findElement(By.xpath(pageStatus)).getAttribute("class")
				.contains("undefined live"));
	}

	@Test
	public void changeStateOfPreviousPublishedContent() {

		this.testScenario();

	}

}
