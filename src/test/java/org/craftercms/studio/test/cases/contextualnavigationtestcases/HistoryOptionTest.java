package org.craftercms.studio.test.cases.contextualnavigationtestcases;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.craftercms.studio.test.cases.StudioBaseTest;
import org.openqa.selenium.TimeoutException;


/**
 * 
 * @author Gustavo Andrei Ortiz Alfaro
 *
 */

public class HistoryOptionTest extends StudioBaseTest{

	private String userName;
	private String password;
	private String siteDropdownXpath;
	private String homeXpath;
	private String historyDialogTitle;
	private String actionsHeaderXpath;
	private String siteDropdownListElementXPath;

	private static Logger logger = LogManager.getLogger(HistoryOptionTest.class);
	
	@BeforeMethod
	public void beforeTest() {

		userName = constantsPropertiesManager.getSharedExecutionConstants().getProperty("crafter.username");
		password = constantsPropertiesManager.getSharedExecutionConstants().getProperty("crafter.password");
		siteDropdownXpath = uiElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("general.sitedropdown");
		homeXpath = uiElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("general.home");
		historyDialogTitle = uiElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("general.historydialogtitle");
		actionsHeaderXpath = uiElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("complexscenarios.general.historydialogactionsheader");
		siteDropdownListElementXPath = uiElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("complexscenarios.general.sitedropdownlielement");
	}

	@Test(priority = 0)
	public void verifyThatTheHistoryDialogIsDisplayedTest() {

		// login to application
		loginPage.loginToCrafter(userName, password);
		
		//Wait for login page to close
		driverManager.waitUntilLoginCloses();
		
		// go to preview page
		homePage.goToPreviewPage();

		// Show site content panel
		if (!(this.driverManager.waitUntilElementIsPresent("xpath", siteDropdownListElementXPath)
				.getAttribute("class").contains("site-dropdown-open")))
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayedAndClickable("xpath",
				siteDropdownXpath).click();
		
		this.driverManager.waitUntilSidebarOpens();
		
		// expand pages folder
		previewPage.expandPagesTree();
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayedAndClickable("xpath", homeXpath);
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayedAndClickable("xpath", homeXpath).click();

		// click on history option
		previewPage.clickOnHistoryOption();

		// Assert
		this.driverManager.waitForAnimation();
		try {
			this.driverManager.waitUntilElementIsDisplayed("xpath", actionsHeaderXpath);
		} catch (TimeoutException e) {
			this.driverManager.takeScreenshot("HistoryDialogNotCompletedRendered");
			logger.warn("History dialog is not completely rendered");
		}
		
		this.driverManager.waitForAnimation();
		String historyPage = this.driverManager
				.driverWaitUntilElementIsPresentAndDisplayed("xpath", historyDialogTitle).getText();
		this.driverManager.waitForAnimation();
		Assert.assertEquals(historyPage, "Version History");

	}

}
