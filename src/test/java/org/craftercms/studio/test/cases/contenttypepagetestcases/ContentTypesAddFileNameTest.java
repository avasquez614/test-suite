/**
 * 
 */
package org.craftercms.studio.test.cases.contenttypepagetestcases;

import org.craftercms.studio.test.pages.SiteConfigPage;
import org.craftercms.studio.test.pages.HomePage;
import org.craftercms.studio.test.pages.LoginPage;
import org.craftercms.studio.test.utils.ConstantsPropertiesManager;
import org.craftercms.studio.test.utils.FilesLocations;
import org.craftercms.studio.test.utils.UIElementsPropertiesManager;
import org.craftercms.studio.test.utils.WebDriverManager;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * @author luishernandez
 *
 */
public class ContentTypesAddFileNameTest {
	private WebDriverManager driverManager;
	private LoginPage loginPage;
	private HomePage homePage;
	private SiteConfigPage siteConfigPage;

	private String controlsSectionFormSectionLocator;
	private String contentTypeContainerLocator;
	private String controlsSectionFileNameLocator;
	private String contentTypeContainerFormSectionContainerLocator;
	private String contentTypeContainerFileNameTitleLocator;
	private UIElementsPropertiesManager uIElementsPropertiesManager;
	private ConstantsPropertiesManager constantsPropertiesManager;

	@BeforeClass
	public void beforeTest() {
		this.driverManager = new WebDriverManager();
		
		this.uIElementsPropertiesManager = new UIElementsPropertiesManager(
				FilesLocations.UIELEMENTSPROPERTIESFILEPATH);
		this.constantsPropertiesManager = new ConstantsPropertiesManager(FilesLocations.CONSTANTSPROPERTIESFILEPATH);
		
		this.loginPage = new LoginPage(driverManager, uIElementsPropertiesManager,constantsPropertiesManager);
		this.homePage = new HomePage(driverManager, uIElementsPropertiesManager,constantsPropertiesManager);
		this.siteConfigPage = new SiteConfigPage(driverManager, uIElementsPropertiesManager,constantsPropertiesManager);
		
		this.controlsSectionFormSectionLocator = uIElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("adminconsole.contenttype.entry.controlssectionformsection");
		this.contentTypeContainerLocator = uIElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("adminconsole.contenttype.entry.contenttypecontainer");
		this.controlsSectionFileNameLocator = uIElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("adminconsole.contenttype.entry.controlsfilename");
		this.contentTypeContainerFormSectionContainerLocator = uIElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("adminconsole.contenttype.entry.contenttypecontainerformsectioncontainer");
		this.contentTypeContainerFileNameTitleLocator = uIElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("adminconsole.contenttype.entry.contenttypecontainerfilenametitle");

	}

	@AfterClass
	public void afterTest() {
		driverManager.closeConnection();
	}

	public void dragAndDrop() {

		driverManager.driverWait(1000);

		// Getting the Form Section control input for drag and drop action
		WebElement FromControlSectionFormSectionElement = this.driverManager
				.driverWaitUntilElementIsPresentAndDisplayed(3, "xpath", controlsSectionFormSectionLocator);
		// driverManager.getDriver()
		// .findElement(By.xpath(controlsSectionFormSectionLocator));

		// Getting the Content Type Container for drag and drop action
		// (destination)
		WebElement ToContentTypeContainer = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(3, "xpath",
				contentTypeContainerLocator);
		// driverManager.getDriver()
		// .findElement(By.xpath(contentTypeContainerLocator));

		driverManager.dragAndDropElement(FromControlSectionFormSectionElement, ToContentTypeContainer);
		// wait for element

		homePage.getDriverManager().driverWait(2000);

		// driverManager.driverWait();

		WebElement FromFileName = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(3, "xpath",
				controlsSectionFileNameLocator);
		// driverManager.getDriver().findElement(By.xpath(controlsSectionFileNameLocator));

		WebElement ToDefaultSection = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(3, "xpath",
				contentTypeContainerFormSectionContainerLocator);
		// driverManager.getDriver()
		// .findElement(By.xpath(contentTypeContainerFormSectionContainerLocator));

		siteConfigPage.getDriverManager().dragAndDropElement(FromFileName, ToDefaultSection);

		// Complete the input fields basics
		siteConfigPage.completeControlFieldsBasics("TestTitle", "TestICEGroup", "TestDescription", "TestDefault");

		// Save the data
		siteConfigPage.saveDragAndDropProcess();

	}

	@Test(priority = 0)
	public void contentTypeAddFileNameTest() {

		// login to application

		loginPage.loginToCrafter("admin", "admin");

		// wait for element
		homePage.getDriverManager().driverWait(2000);

		// go to preview page
		homePage.goToPreviewPage();

		// wait for element is clickeable
		homePage.getDriverManager().driverWait(5000);

		// Show site content panel
		// homePage.getDriverManager().driverWait();
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(5, "xpath",
				"/html/body/div[2]/div[1]/nav/div/div[2]/ul[1]/li/div/div[1]/a").click();
		// driverManager.getDriver().findElement(By.xpath("/html/body/div[2]/div[1]/nav/div/div[2]/ul[1]/li/div/div[1]/a"))
		// .click();

		// Show admin console page
		homePage.getDriverManager().driverWait(2000);
		// homePage.getDriverManager().driverWait();
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(3, "xpath", ".//a[@id='admin-console']").click();
		// driverManager.getDriver().findElement(By.xpath(".//a[@id='admin-console']")).click();

		// wait for element
		homePage.getDriverManager().driverWait(1000);

		// Select the content type to the test
		siteConfigPage.selectEntryContentTypeFromAdminConsole();

		// wait for element
		siteConfigPage.getDriverManager().driverWait(1000);

		// drag and drop
		this.dragAndDrop();

		// open content types
		siteConfigPage.clickExistingTypeOption();

		// wait for element
		siteConfigPage.getDriverManager().driverWait(1000);

		// Select the generic content type
		siteConfigPage.selectEntryContentType();

		// Confirm the content type selected
		siteConfigPage.confirmContentTypeSelected();

		// wait for element
		homePage.getDriverManager().driverWait(1000);

		// driverManager.driverWait();

		// Click on input section to can view the properties
		siteConfigPage.clickFileNameSection();

		// Asserts that fields are not empty.
		String titleText = this.driverManager
				.driverWaitUntilElementIsPresentAndDisplayed(3, "xpath", contentTypeContainerFileNameTitleLocator)
				.getText();
		// driverManager.getDriver().findElement(By.xpath(contentTypeContainerFileNameTitleLocator))
		// .getText();

		Assert.assertTrue(titleText.contains("TestTitle"));

	}
}
