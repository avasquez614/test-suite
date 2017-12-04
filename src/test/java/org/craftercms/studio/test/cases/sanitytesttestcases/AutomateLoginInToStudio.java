package org.craftercms.studio.test.cases.sanitytesttestcases;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.craftercms.studio.test.pages.LoginPage;
import org.craftercms.studio.test.utils.ConstantsPropertiesManager;
import org.craftercms.studio.test.utils.FilesLocations;
import org.craftercms.studio.test.utils.UIElementsPropertiesManager;
import org.craftercms.studio.test.utils.WebDriverManager;

/**
 * 
 * @author Juan Camacho
 */

//Test to cover ticket https://github.com/craftercms/craftercms/issues/1435
public class AutomateLoginInToStudio {

	private WebDriverManager driverManager;

	private LoginPage loginPage;

	private String userName;
	private String password;

	private String createSiteButtonXpath;
	private String sitesPageTitle;
	private String sitesPageURL;
	
	@BeforeClass
	public void beforeTest() {
		this.driverManager = new WebDriverManager();
		
		UIElementsPropertiesManager UIElementsPropertiesManager = new UIElementsPropertiesManager(
				FilesLocations.UIELEMENTSPROPERTIESFILEPATH);
		ConstantsPropertiesManager constantsPropertiesManager = new ConstantsPropertiesManager(FilesLocations.CONSTANTSPROPERTIESFILEPATH);
		
		this.driverManager.setConstantsPropertiesManager(constantsPropertiesManager);
		
		this.loginPage = new LoginPage(driverManager, UIElementsPropertiesManager);
		
		userName = constantsPropertiesManager.getSharedExecutionConstants().getProperty("crafter.username");
		password = constantsPropertiesManager.getSharedExecutionConstants().getProperty("crafter.password");
		createSiteButtonXpath = UIElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("general.sites.createsitebutton");
		sitesPageTitle = UIElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("general.sites.sitespagetitle"); 
		sitesPageURL = UIElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("general.sites.sitepageurl");
	}

	@AfterClass
	public void afterTest() {
		driverManager.closeConnection();
	}

	@Test(priority = 0)

	public void loginInToStudioTest() {

		// login to application
		loginPage.loginToCrafter(userName, password);

		// Assert create button is present.
		WebElement createButton = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed( "xpath",
				createSiteButtonXpath);

		//Assert is the Create Button Present
		Assert.assertTrue(createButton.isDisplayed());
		
		//Assert Is the Site Page title Displayed
		Assert.assertTrue(driverManager.isElementPresentAndClickableByXpath(sitesPageTitle));
		
		//Assert URL of the page is the correct
		String siteURL = driverManager.getDriver().getCurrentUrl();
		Assert.assertTrue(siteURL.contains(sitesPageURL));
	
	}

}