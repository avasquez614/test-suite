/*
 * Copyright (C) 2007-2019 Crafter Software Corporation. All Rights Reserved.
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
// Related to ticket: https://github.com/craftercms/craftercms/issues/1869
public class VerifyThatPageIsNotOnLive extends DeliveryBaseTest {
	private String pageTitleXpath;

	@BeforeMethod
	public void beforeTest() {
		String pageURL = uiElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("delivery.verification.pageurl");
		String siteURL = uiElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("delivery.verification.siteurl");
		String siteId = deliveryExecutionValuesManager.getSharedExecutionConstants()
				.getProperty("general.currentsiteid");
		pageTitleXpath = uiElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("delivery.verification.pagetitle");
		this.driverManager.getDriver().get(siteURL+siteId);
		this.driverManager.getDriver().get(pageURL);
	}

	@Test(priority = 0)
	public void verifyThatPageIsNotOnLive() {
		this.driverManager.waitForAnimation();
		this.driverManager.waitUntilElementIsDisplayed("xpath", pageTitleXpath);
		this.driverManager.waitForAnimation();
		Assert.assertTrue(this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("xpath", pageTitleXpath)
				.getText().equalsIgnoreCase("The page you are looking for doesn't exist."));
	}

}
