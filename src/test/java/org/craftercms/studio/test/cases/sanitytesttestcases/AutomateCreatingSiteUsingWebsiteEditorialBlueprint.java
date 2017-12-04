package org.craftercms.studio.test.cases.sanitytesttestcases;

import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import static org.testng.Assert.assertFalse;

import org.craftercms.studio.test.pages.CreateSitePage;
import org.craftercms.studio.test.pages.HomePage;
import org.craftercms.studio.test.pages.LoginPage;
import org.craftercms.studio.test.utils.ConstantsPropertiesManager;
import org.craftercms.studio.test.utils.FilesLocations;
import org.craftercms.studio.test.utils.UIElementsPropertiesManager;
import org.craftercms.studio.test.utils.WebDriverManager;
import org.openqa.selenium.WebElement;

/**
 * 
 * 
 * @author Juan Camacho A
 *
 */
//Test Case created to cover ticket https://github.com/craftercms/craftercms/issues/1445
public class AutomateCreatingSiteUsingWebsiteEditorialBlueprint {

	private WebDriverManager driverManager;
	private LoginPage loginPage;
	private HomePage homePage;
	private CreateSitePage createSitePage;

	private String userName;
	private String password;
	private String siteDropdownElementXPath;
	private String createSiteErrorNotificationWindow;
	private String editorialSitePreviewPageTitle;
	private String createSiteButtonXpath;
	private String menuSitesButton;
	
	@BeforeClass
	public void beforeTest() {
		this.driverManager = new WebDriverManager();
		UIElementsPropertiesManager uIElementsPropertiesManager = new UIElementsPropertiesManager(
				FilesLocations.UIELEMENTSPROPERTIESFILEPATH);
		ConstantsPropertiesManager constantsPropertiesManager = new ConstantsPropertiesManager(
				FilesLocations.CONSTANTSPROPERTIESFILEPATH);

		this.driverManager.setConstantsPropertiesManager(constantsPropertiesManager);

		this.loginPage = new LoginPage(this.driverManager, uIElementsPropertiesManager);
		this.homePage = new HomePage(this.driverManager, uIElementsPropertiesManager);
		this.createSitePage = new CreateSitePage(this.driverManager, uIElementsPropertiesManager);

		userName = constantsPropertiesManager.getSharedExecutionConstants().getProperty("crafter.username");
		password = constantsPropertiesManager.getSharedExecutionConstants().getProperty("crafter.password");
		siteDropdownElementXPath = uIElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("complexscenarios.general.sitedropdown");
		createSiteErrorNotificationWindow = uIElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("general.sites.createsite.errowindow");
		editorialSitePreviewPageTitle = uIElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("preview.editorial.site.title");
		createSiteButtonXpath= uIElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("general.sites.createsitebutton");
		menuSitesButton = uIElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("preview.sites.menu.button");
	}
	
	public void deleteSite() {
		
		this.driverManager.getDriver().switchTo().defaultContent();
		
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayedAndClickable(
				"xpath", menuSitesButton).click();

		// Click on Delete icon
		this.driverManager.isElementPresentAndClickableByXpath(createSiteButtonXpath);
		homePage.clickOnDeleteSiteIcon();

		// Click on YES to confirm the delete.
		homePage.clickOnYesToDeleteSite();
		
		//Refresh the page
		driverManager.getDriver().navigate().refresh();

	}

	@AfterClass
	public void afterTest() {
		deleteSite();
		driverManager.closeConnection();
	}

	@Test(priority = 0)
	public void createSiteWithWebSiteEditorialBluePrintTest() {

		// login to application
		loginPage.loginToCrafter(
				userName,password);

		// Click on the create site button

		homePage.clickOnCreateSiteButton();

		// Filling the name of site

		createSitePage.fillSiteName();

		// Filling the description of the site

		createSitePage.fillDescription("Description");

		// Open blueprint combo
		// Select blueprint

		createSitePage.selectWebSiteEditorialBluePrintOption();

		// Click on Create button

		createSitePage.clickOnCreateSiteButton();
		
		//Verify No error messages after clicking on the Create button
		
		assertFalse(driverManager.isElementPresentByXpath(createSiteErrorNotificationWindow));
		
		this.driverManager.waitWhileElementIsDisplayedAndClickableByXpath(siteDropdownElementXPath);
		

		//Assert Page is displayed
		this.driverManager.waitWhileElementIsDisplayedAndClickableByXpath(siteDropdownElementXPath);
		
		//Move to the content frame
		Assert.assertTrue(this.driverManager.isElementPresentAndClickableByXpath(siteDropdownElementXPath));
		
		driverManager.getDriver().switchTo().defaultContent();
        driverManager.getDriver().switchTo().frame(this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(
                "id", "engineWindow"));
        
		//Assert Title of the page correspond to a Editorial Blueprint site
	
        WebElement siteTitle = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(
    		  "xpath", editorialSitePreviewPageTitle);

        Assert.assertTrue(siteTitle.getText().contains("Hi, I’m Editorial"));	
		
	}

}
