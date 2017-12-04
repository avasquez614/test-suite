/**
 * 
 */
package org.craftercms.studio.test.cases.generaltestcases;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.Assert;
import org.craftercms.studio.test.pages.CreateSitePage;
import org.craftercms.studio.test.pages.DashboardPage;
import org.craftercms.studio.test.pages.HomePage;
import org.craftercms.studio.test.pages.LoginPage;
import org.craftercms.studio.test.pages.PreviewPage;
import org.craftercms.studio.test.pages.UsersPage;
import org.craftercms.studio.test.utils.ConstantsPropertiesManager;
import org.craftercms.studio.test.utils.FilesLocations;
import org.craftercms.studio.test.utils.UIElementsPropertiesManager;
import org.craftercms.studio.test.utils.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

/**
 * @author Juan Camacho
 *
 */
public class ChangeStateOfPreviousPublishedContent {

	private WebDriverManager driverManager;
	private LoginPage loginPage;
	private HomePage homePage;
	private DashboardPage dashboardPage;

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
	private String navigationElement;
	private String editAuthorGroupOption;
	private String groupsAddNewMembersCheckbox;
	private String groupsAddNewMembersInput;
	private String groupsAddNewMembersAutocompleteOption1;
	private String groupsAddNewMembersButton;
	private String groupsMembersOption1;
	private String navigationSitebarNameId;
	private String crafterLogo;
	private String generalSiteDropdown;
	private String pageStatus;
	
	private CreateSitePage createSitePage;
	private UsersPage usersPage;
	private PreviewPage previewPage;
	private String articlesFolder;

	private String crafterLogoId;

	@BeforeClass
	public void beforeTest() {
		this.driverManager = new WebDriverManager();
		UIElementsPropertiesManager UIElementsPropertiesManager = new UIElementsPropertiesManager(
				FilesLocations.UIELEMENTSPROPERTIESFILEPATH);
		ConstantsPropertiesManager constantsPropertiesManager = new ConstantsPropertiesManager(
				FilesLocations.CONSTANTSPROPERTIESFILEPATH);
		UIElementsPropertiesManager uIElementsPropertiesManager = new UIElementsPropertiesManager(
				FilesLocations.UIELEMENTSPROPERTIESFILEPATH);
		this.driverManager.setConstantsPropertiesManager(constantsPropertiesManager);
		this.loginPage = new LoginPage(driverManager, UIElementsPropertiesManager);
		this.homePage = new HomePage(driverManager, UIElementsPropertiesManager);
		this.dashboardPage = new DashboardPage(driverManager, UIElementsPropertiesManager);
		this.createSitePage = new CreateSitePage(driverManager, UIElementsPropertiesManager);

		userName = constantsPropertiesManager.getSharedExecutionConstants().getProperty("crafter.username");
		password = constantsPropertiesManager.getSharedExecutionConstants().getProperty("crafter.password");
		this.usersPage = new UsersPage(driverManager, uIElementsPropertiesManager);
		this.previewPage = new PreviewPage(driverManager, UIElementsPropertiesManager);
		articlesFolder = UIElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("dashboard.articlesfolder");
		selectAllSegmentsCheckBox = UIElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("frame2.article_select_all_segments_checkbox");
		selectAllCategoriesCheckBox = UIElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("frame2.select_All_Categories_CheckBox");
		siteconfigGroupsOption = UIElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("siteconfig.groups_option");
		userOptions = UIElementsPropertiesManager.getSharedUIElementsLocators().getProperty("dashboard.user_options");
		userOptionsLogout = UIElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("dashboard.user_options_logout");
		requestPublishButton = UIElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("preview.request_publish_button");
		publishSubmitButton = UIElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("preview.approve&publish_submit");
		cancelWorkflowContinueButton = UIElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("preview.workflow_cancellation_continue_Button");
		staticAssetsButton = UIElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("preview.static_assets_button");
		homeTree = UIElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("dashboard.expand_GlobalEntry_Tree");
		crafterLogoId = UIElementsPropertiesManager.getSharedUIElementsLocators().getProperty("general.studiologo");
		sidebarMenuOption = UIElementsPropertiesManager.getSharedUIElementsLocators().getProperty(
				"complexscenarios.general.sitedropdownmenuinnerxpath");
		dependenciesMenuOption =UIElementsPropertiesManager.getSharedUIElementsLocators().getProperty(
				"general.dependenciestopnavoption");
		staticAssetsChildFolder = UIElementsPropertiesManager.getSharedUIElementsLocators().getProperty(
				"preview.static_assets_child_folder");
		staticAssetsImagesChildFolder = UIElementsPropertiesManager.getSharedUIElementsLocators().getProperty(
				"preview.static_assets_images_child_folder");
		navigationElement = UIElementsPropertiesManager.getSharedUIElementsLocators().getProperty(
				"complexscenarios.general.togglenavigationelement");
		editAuthorGroupOption = UIElementsPropertiesManager.getSharedUIElementsLocators().getProperty(
				"groups.edit_author_group_option");
		groupsAddNewMembersCheckbox = UIElementsPropertiesManager.getSharedUIElementsLocators().getProperty(
				"groups.add_new_members_checkbox");
		groupsAddNewMembersInput = UIElementsPropertiesManager.getSharedUIElementsLocators().getProperty(
				"groups.add_new_members_input");
		groupsAddNewMembersAutocompleteOption1= UIElementsPropertiesManager.getSharedUIElementsLocators().getProperty(
				"groups.add_new_members_autocomplete_option1");
		groupsAddNewMembersButton = UIElementsPropertiesManager.getSharedUIElementsLocators().getProperty(
				"groups.add_new_members_button");
		groupsMembersOption1 = UIElementsPropertiesManager.getSharedUIElementsLocators().getProperty(
				"groups.members_list_option1");
		navigationSitebarNameId = UIElementsPropertiesManager.getSharedUIElementsLocators().getProperty(
				"general.navigation_sitebar_name_id"); 
		crafterLogo = UIElementsPropertiesManager.getSharedUIElementsLocators().getProperty(
				"users.crafterlogo"); 
		generalSiteDropdown = UIElementsPropertiesManager.getSharedUIElementsLocators().getProperty(
				"general.sitedropdown"); 
		pageStatus = UIElementsPropertiesManager.getSharedUIElementsLocators().getProperty(
				"general.pageStatus");
	}

	@AfterClass
	public void afterTest() {
		driverManager.closeConnection();
	}

	public void addNewUser() {

		// click On Users option
		createSitePage.clickOnUsersOption();

		// click on new user button
		usersPage.clickOnNewUser();

		// Follow the form
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("cssSelector", "#firstName").sendKeys("Name");

		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("cssSelector", "#lastName")
				.sendKeys("Last Name");

		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("cssSelector", "#email")
				.sendKeys("email@email.com");

		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("cssSelector", "#username").sendKeys("author");

		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("cssSelector", "#password").sendKeys("author");

		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("cssSelector", "#passwordVerification")
				.sendKeys("author");

		// Save Button
		usersPage.clickOnSaveNewUser();

		// Assert new users created is present
		WebElement newUserCreated = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("cssSelector",
				"#container > div > div > div > div > div > table > tbody > tr:nth-child(2) > td:nth-child(1) > a");

		Assert.assertTrue(newUserCreated.isDisplayed());

		// Switch to the form
		driverManager.getDriver().navigate().refresh();
		driverManager.getDriver().switchTo().defaultContent();

		this.driverManager.driverWaitUntilElementIsPresentAndDisplayedAndClickable("xpath",
				crafterLogo);

		this.driverManager.driverWaitUntilElementIsPresentAndDisplayedAndClickable("xpath",
				crafterLogo).click();

	}

	public void login(String user, String loginpassword) {
		// login to application
		loginPage.loginToCrafter(user, loginpassword);
		// go to preview page

	}

	public void editPageArticleContent(String pageName) {
		// Switch to the iframe
		driverManager.getDriver().switchTo().defaultContent();
		driverManager.getDriver().switchTo().frame(this.driverManager
				.driverWaitUntilElementIsPresentAndDisplayed("cssSelector", ".studio-ice-dialog > .bd iframe"));
		this.driverManager.isElementPresentAndClickableBycssSelector(".studio-ice-dialog > .bd iframe");

		// creating random values for URL field and InternalName field
		String randomInternalName = pageName;
		// Set basics fields of the new content created

		dashboardPage.updateFieldsOfPageArticleContent(randomInternalName, pageName);

		// Set the title of main content
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("cssSelector", "#title > div > input")
				.sendKeys(pageName);
		this.driverManager.scrollUp();
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("cssSelector", "#cstudio-form-expand-all")
				.click();

		// save and close
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("id", "cstudioSaveAndClose").click();
		// Switch back to the dashboard page
		driverManager.getDriver().switchTo().defaultContent();

		this.driverManager.isElementPresentByXpath(navigationElement);

	}

	public void changeBodyToNotRequiredOnPageArticleContent() {

		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("xpath", generalSiteDropdown)
				.click();

		previewPage.changeBodyOfArticlePageToNotRequired();

	}

	public void addUserToAuthorGroup() {

		WebElement siteConfigButton = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("id",
				"admin-console");
		siteConfigButton.click();

		this.driverManager.driverWaitUntilElementIsPresentAndDisplayedAndClickable("xpath", siteconfigGroupsOption);

		this.driverManager.driverWaitUntilElementIsPresentAndDisplayedAndClickable("xpath", siteconfigGroupsOption)
				.click();

		driverManager.getDriver().switchTo().defaultContent();
		this.driverManager.getDriver().switchTo()
				.frame(this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("xpath", ".//iframe"));
		this.driverManager.isElementPresentAndClickableByXpath(".//iframe");

		this.driverManager.getDriver().switchTo().activeElement();

		this.driverManager.driverWaitUntilElementIsPresentAndDisplayedAndClickable("xpath",
				editAuthorGroupOption);
		
		this.driverManager
				.driverWaitUntilElementIsPresentAndDisplayedAndClickable("xpath", editAuthorGroupOption)
				.click();

		driverManager.getDriver().switchTo().defaultContent();
		this.driverManager.getDriver().switchTo()
				.frame(this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("xpath", ".//iframe"));
		this.driverManager.isElementPresentAndClickableByXpath(".//iframe");

		this.driverManager.getDriver().switchTo().activeElement();
		// id container

		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("xpath", groupsAddNewMembersCheckbox);

		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("xpath", groupsAddNewMembersCheckbox)
				.click();

		this.driverManager
				.driverWaitUntilElementIsPresentAndDisplayed("xpath", groupsAddNewMembersInput)
				.sendKeys("author");
		
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("xpath",
				groupsAddNewMembersAutocompleteOption1);

		this.driverManager
				.driverWaitUntilElementIsPresentAndDisplayed("xpath",
						groupsAddNewMembersAutocompleteOption1)
				.click();

		this.driverManager.driverWaitUntilElementIsPresentAndDisplayedAndClickable("xpath",
				groupsAddNewMembersButton); 

		this.driverManager.driverWaitUntilElementIsPresentAndDisplayedAndClickable("xpath",
				groupsAddNewMembersButton).click();

		Assert.assertTrue(
				driverManager.isElementPresentByXpath(groupsMembersOption1));

		driverManager.getDriver().switchTo().defaultContent();
		this.driverManager.getDriver().switchTo().activeElement();

		this.driverManager.driverWaitUntilElementIsPresentAndDisplayedAndClickable("id", navigationSitebarNameId);

		this.driverManager.driverWaitUntilElementIsPresentAndDisplayedAndClickable("id", navigationSitebarNameId).click();

		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("cssSelector", "#admin-console");

	}

	private void goToSiteContentPagesStructure() {
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayedAndClickable("xpath",
				"//SPAN[@class='ng-binding'][text()='Create Site']");

		homePage.goToPreviewPage();
		String siteDropdownElementXPath = ".//a[@id='acn-dropdown-toggler']";

		if (this.driverManager.isElementPresentByXpath(siteDropdownElementXPath))
			this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("xpath", siteDropdownElementXPath).click();
		else
			throw new NoSuchElementException(
					"Site creation process is taking too long time and the element was not found");

	}

	private void renamePage(WebElement parentPage, String newPageName) {
		dashboardPage.rightClickEditOnAPresentPage(parentPage);
		// creating new Page Article into the empty folder
		this.editPageArticleContent(newPageName);

	}

	private void renamePageWithWorkflowCancelation(WebElement parentPage, String newPageName) {
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

		// Switch back to the dashboard page
		driverManager.getDriver().switchTo().defaultContent();

		this.driverManager.isElementPresentByXpath(navigationElement);

	}

	public void testScenario() {
		// Related to the bug:
		// issue https://github.com/craftercms/craftercms/issues/1557

		this.login(userName, password);

		this.addNewUser();

		this.goToSiteContentPagesStructure();

		this.addUserToAuthorGroup();

		// body not required Page-Article
		this.changeBodyToNotRequiredOnPageArticleContent();

		// expand pages folder
		dashboardPage.expandPagesTree();

		this.driverManager.driverWaitUntilElementIsPresentAndDisplayedAndClickable("xpath", homeTree);
		// expand Home tree
		dashboardPage.expandHomeTree();

		previewPage.createPageArticleContent("test", "Testing1", "test", articlesFolder, selectAllCategoriesCheckBox,
				selectAllSegmentsCheckBox, "ArticleSubject", "ArticleAuthor", "ArticleSummary");

		// Switch back to the dashboard page
		this.driverManager.getDriver().switchTo().activeElement();

		this.driverManager.getDriver().navigate().refresh();

		// Open dependencies for the previous created element
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayedAndClickable("xpath",
				articlesFolder);
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayedAndClickable("xpath",
				articlesFolder).click();

		
		this.driverManager
				.driverWaitUntilElementIsPresentAndDisplayedAndClickable("xpath", sidebarMenuOption)
				.click();

		this.driverManager
				.driverWaitUntilElementIsPresentAndDisplayedAndClickable("xpath", sidebarMenuOption)
				.click();

		this.driverManager.driverWaitUntilElementIsPresentAndDisplayedAndClickable("xpath",
				".//span[contains(text(),'Testing1')]");
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayedAndClickable("xpath",
				".//span[contains(text(),'Testing1')]").click();

		// Bulk Publish
		previewPage.bulkPublish();

		// Verify Article is published

		previewPage.verifyPageArticleIsPublished();

		// logout from Crafter
		this.logoutFromCrafter();

		// login to application with author user
		loginPage.loginToCrafter("author", "author");

		//this.driverManager.getDriver().switchTo().activeElement();

		// Go to the site page
        this.driverManager.waitUntilPageLoad();
        
		homePage.goToPreviewPage();
		String siteDropdownElementXPath = sidebarMenuOption;

		if (this.driverManager.isElementPresentByXpath(siteDropdownElementXPath))
			this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("xpath", siteDropdownElementXPath).click();
		else
			throw new NoSuchElementException(
					"Site creation process is taking too long time and the element was not found");

		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("xpath", siteDropdownElementXPath).click();

		// expand pages folder
		dashboardPage.expandPagesTree();

		driverManager.isElementPresentAndClickableById(crafterLogoId);
		
		//refresh
		this.driverManager.getDriver().navigate().refresh();

		// expand Home tree
		dashboardPage.expandHomeTree();

		// Fix race condition expanding Home Tree
		if (!(this.driverManager.isElementPresentAndClickableByXpath(articlesFolder))) {
			this.dashboardPage.expandHomeTree();
		}

		this.driverManager.driverWaitUntilElementIsPresentAndDisplayedAndClickable("xpath",
				articlesFolder);
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayedAndClickable("xpath",
				articlesFolder).click();

		this.driverManager
				.driverWaitUntilElementIsPresentAndDisplayedAndClickable("xpath", sidebarMenuOption)
				.click();

		this.driverManager
				.driverWaitUntilElementIsPresentAndDisplayedAndClickable("xpath", sidebarMenuOption)
				.click();

		this.driverManager.driverWaitUntilElementIsPresentAndDisplayedAndClickable("xpath",
				".//span[contains(text(),'Testing1')]");
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayedAndClickable("xpath",
				".//span[contains(text(),'Testing1')]").click();

		WebElement articlePage;

		articlePage = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("xpath",
				".//span[contains(text(),'Testing1')]");

		// Edit content Page with the Author User
		String newPageArticleName = "Testing1Edited";
		this.renamePage(articlePage, newPageArticleName);

		// request publish
		this.requestPublish(newPageArticleName);

		// Switch back to the dashboard page
		this.driverManager.getDriver().switchTo().defaultContent();

		this.driverManager.getDriver().navigate().refresh();

		// Open dependencies for the previous created element
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayedAndClickable("xpath",
				dependenciesMenuOption);
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayedAndClickable("xpath",
				dependenciesMenuOption).click();

		// check dependencies are listed
		previewPage.checkDependencies();

		// Cancel the Workflow and Edit again the Page Article Content

		newPageArticleName = "Testing1Edited2";
		articlePage = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("xpath",
				".//span[contains(text(),'Testing1Edited')]");
		this.renamePageWithWorkflowCancelation(articlePage, newPageArticleName);

		// Check on Static Assets that dependencies are not mark as edited

		// Collapse Home tree
		dashboardPage.expandHomeTree();

		this.driverManager.driverWaitUntilElementIsPresentAndDisplayedAndClickable("xpath", staticAssetsButton);
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayedAndClickable("xpath", staticAssetsButton).click();

		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("xpath",
				staticAssetsChildFolder);
		this.driverManager
				.driverWaitUntilElementIsPresentAndDisplayed("xpath", staticAssetsChildFolder)
				.click();

		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(
				"xpath", staticAssetsImagesChildFolder);
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(
				"xpath", staticAssetsImagesChildFolder)
				.click();

		this.driverManager.driverWaitUntilElementIsPresentAndDisplayedAndClickable("xpath",
				".//span[contains(text(),'1-gear.png')]");
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayedAndClickable("xpath",
				".//span[contains(text(),'1-gear.png')]").click();

		this.driverManager.driverWaitUntilElementIsPresentAndDisplayedAndClickable("xpath",
				dependenciesMenuOption);

		String isLifeContent = "";

		while (!(isLifeContent.contains("undefined live"))) {
			isLifeContent = this.driverManager.getDriver()
					.findElement(By.xpath(pageStatus)) 
					.getAttribute("class").toString();
			this.driverManager.driverWaitUntilElementIsPresentAndDisplayedAndClickable("xpath",
					".//span[contains(text(),'1-gear.png')]").click();
			this.dashboardPage.expandHomeTree();
		}

		Assert.assertTrue(this.driverManager.getDriver()
				.findElement(By.xpath(pageStatus))
				.getAttribute("class").contains("undefined live"));

	}

	@Test
	public void changeStateOfPreviousPublishedContent() {
		this.testScenario();
	}

}