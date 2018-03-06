package org.craftercms.delivery.test.cases.verification;

import org.craftercms.studio.test.cases.DeliveryBaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * 
 * @author Luis Hernandez
 *
 */
//Related to ticket: https://github.com/craftercms/craftercms/issues/1869
public class VerifyThatPageIsOnLive extends DeliveryBaseTest {
	private String pageTitleXpath;

	@BeforeMethod
	public void beforeTest() {
		String pageURL = uiElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("delivery.verification.pageurl");
		pageTitleXpath = uiElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("delivery.verification.pagetitle");
		this.driverManager.getDriver().get(pageURL);
	}

	@Test(priority = 0)
	public void verifyThatPageIsOnLive() {
		this.driverManager.waitForAnimation();
		this.driverManager.waitUntilElementIsDisplayed("xpath", pageTitleXpath);
		Assert.assertTrue(this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("xpath", pageTitleXpath)
				.getText().equalsIgnoreCase("testingpage"));
	}

}