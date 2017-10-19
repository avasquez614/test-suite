package org.craftercms.studio.test.cases.dashboardpagetestcases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.craftercms.studio.test.pages.HomePage;
import org.craftercms.studio.test.pages.LoginPage;
import org.craftercms.studio.test.pages.PreviewPage;
import org.craftercms.studio.test.utils.ConstantsPropertiesManager;
import org.craftercms.studio.test.utils.FilesLocations;
import org.craftercms.studio.test.utils.UIElementsPropertiesManager;
import org.craftercms.studio.test.utils.WebDriverManager;

/**
 * 
 * @author Gustavo Andrei Ortiz Alfaro 
 *
 */

public class EnableDisableEditingInContextTest {

	WebDriver driver;

	private WebDriverManager driverManager;

	private LoginPage loginPage;

	private UIElementsPropertiesManager UIElementsPropertiesManager;

	private HomePage homePage;

	private PreviewPage previewPage;

	private ConstantsPropertiesManager constantsPropertiesManager;

	

	@BeforeClass
	public void beforeTest() {
		this.driverManager = new WebDriverManager();
		this.UIElementsPropertiesManager = new org.craftercms.studio.test.utils.UIElementsPropertiesManager(
				FilesLocations.UIELEMENTSPROPERTIESFILEPATH);
		this.constantsPropertiesManager = new ConstantsPropertiesManager(FilesLocations.CONSTANTSPROPERTIESFILEPATH);
		
		this.loginPage = new LoginPage(driverManager, this.UIElementsPropertiesManager,constantsPropertiesManager);
		this.homePage = new HomePage(driverManager, this.UIElementsPropertiesManager,constantsPropertiesManager);
		this.previewPage = new PreviewPage(driverManager, this.UIElementsPropertiesManager,constantsPropertiesManager);

	}

	@AfterClass
	public void afterTest() {
    driverManager.closeConnection();
	}

	@Test(priority = 0)

	public void Enable_Disable_Editing_In_Context_Test() {

		// login to application

		loginPage.loginToCrafter("admin", "admin");

		// wait for element is clickeable

		homePage.getDriverManager().driverWait(2000);

		// go to dashboard page

		homePage.goToPreviewPage();
		
		// wait for element is clickeable

		homePage.getDriverManager().driverWait(300);
		//homePage.getDriverManager().driverWait();
		// Click on Preview Tools icon
		
		previewPage.clickOnPreviewTools();
		
		// Expand context editing section
		
		previewPage.clickToExpandInContextEditing();
		
		// Enable/disable In Context edit
		
		previewPage.clickToEnableDisableInContextEditing();
		
		//Assert 
		
		String editIconActive = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(3, "xpath",
				"/html/body/div[3]/div[1]/div[2]/div/div[2]/div/div[1]/button").getText();
				//driverManager.getDriver().findElement(By.xpath("/html/body/div[3]/div[1]/div[2]/div/div[2]/div/div[1]/button")).getText();
		Assert.assertEquals(editIconActive, "In-Context Edit Off");
		
	}
	
}