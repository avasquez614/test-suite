package org.craftercms.studio.test.sanitytesttestcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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

public class LoginTest {

	WebDriver driver;

	LoginPage objLogin;

	HomePage objHomePage;

	private WebDriverManager driverManager;

	private LoginPage loginPage;

	private UIElementsPropertiesManager UIElementsPropertiesManager;

	private HomePage homePage;

	private ConstantsPropertiesManager constantsPropertiesManager;



	@BeforeClass
	public void beforeTest() {
		this.driverManager = new WebDriverManager();
		this.UIElementsPropertiesManager = new org.craftercms.studio.test.utils.UIElementsPropertiesManager(
				FilesLocations.UIELEMENTSPROPERTIESFILEPATH);
		this.constantsPropertiesManager = new ConstantsPropertiesManager(FilesLocations.CONSTANTSPROPERTIESFILEPATH);
		
		this.loginPage = new LoginPage(driverManager, this.UIElementsPropertiesManager,constantsPropertiesManager);
		this.homePage = new HomePage(driverManager, this.UIElementsPropertiesManager,constantsPropertiesManager);
	}

	@AfterClass
	public void afterTest() {
		driverManager.closeConnection();
	}

	@Test(priority = 0)

	public void login_Test() {

		// login to application

		loginPage.loginToCrafter("admin", "admin");

		// wait for element is clickeable

		homePage.getDriverManager().driverWait(2000);

		// Assert create button is present.

		WebElement createButton = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(3, "cssSelector",
				".btn.btn-default.btn-pill.btn-block");
				//driverManager.getDriver()
				//.findElement(By.cssSelector(".btn.btn-default.btn-pill.btn-block"));

		Assert.assertTrue(createButton.isDisplayed());
		Assert.assertTrue(this.driverManager.getDriver().getCurrentUrl().contains("/studio#/sites"));

	}

}
