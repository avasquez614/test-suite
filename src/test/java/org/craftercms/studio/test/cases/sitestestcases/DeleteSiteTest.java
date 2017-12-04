package org.craftercms.studio.test.cases.sitestestcases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.craftercms.studio.test.pages.HomePage;
import org.craftercms.studio.test.pages.LoginPage;
import org.craftercms.studio.test.utils.ConstantsPropertiesManager;
import org.craftercms.studio.test.utils.FilesLocations;
import org.craftercms.studio.test.utils.UIElementsPropertiesManager;
import org.craftercms.studio.test.utils.WebDriverManager;

/**
 * 
 * @author Gustavo Andrei Ortiz Alfaro
 *
 */

public class DeleteSiteTest {

	WebDriver driver;
	LoginPage Login;
	HomePage HomePage;

	private WebDriverManager driverManager;
	private LoginPage loginPage;
	private HomePage homePage;
	
	private String userName;
	private String password;
	private String deletedSiteRow;
	private String createSiteButton;

	@BeforeClass
	public void beforeTest() {
		this.driverManager = new WebDriverManager();
		UIElementsPropertiesManager uIElementsPropertiesManager = new UIElementsPropertiesManager(
				FilesLocations.UIELEMENTSPROPERTIESFILEPATH);
		ConstantsPropertiesManager constantsPropertiesManager = new ConstantsPropertiesManager(
				FilesLocations.CONSTANTSPROPERTIESFILEPATH);
		
		this.driverManager.setConstantsPropertiesManager(constantsPropertiesManager);
		
		this.loginPage = new LoginPage(driverManager, uIElementsPropertiesManager);
		this.homePage = new HomePage(driverManager, uIElementsPropertiesManager);
		
		userName = constantsPropertiesManager.getSharedExecutionConstants().getProperty("crafter.username");
		password = constantsPropertiesManager.getSharedExecutionConstants().getProperty("crafter.password");
		deletedSiteRow = uIElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("general.sites.deletedsiterow");
		createSiteButton = uIElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("general.sites.createsitebutton");

	}

	@AfterClass
	public void afterTest() {
		driverManager.closeConnection();
	}

	@Test(priority = 0)

	public void deleteSiteTest() {

		// login to application
		loginPage.loginToCrafter(
				userName,password);

		// Click on Delete icon
        this.driverManager.isElementPresentAndClickableByXpath(createSiteButton);
		homePage.clickOnDeleteSiteIcon();
		
		// Click on YES to confirm the delete.
		homePage.clickOnYesToDeleteSite();
		
		driverManager.getDriver().navigate().refresh();
		// Assert
		
		this.driverManager.waitWhileElementIsNotDisplayedByXpath(deletedSiteRow);
		Assert.assertFalse(this.driverManager.isElementPresentAndClickableByXpath(deletedSiteRow));
	}
}




