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
package org.craftercms.studio.test.cases.sitedropdowntestcases;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.LinkedList;
import java.util.List;

import org.craftercms.studio.test.cases.StudioBaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * 
 * 
 * @author Juan Camacho A
 *
 */
// Test Case Studio- Site Dropdown ID:1
public class VerifyTheSideBarDropdownOptionsUsingWebEditorialBlueprintWithAdminUser extends StudioBaseTest {

	private String userName;
	private String password;
	private String siteDropdownElementXPath;
	private String dashboardLink;
	private String pagesTreeLink;
	private String componentsTreeLink;
	private String taxonomyTreeLink;
	private String staticAssetsTreeLink;
	private String templatesTreeLink;
	private String scriptsTreeLink;
	private String siteConfigLink;
	private LinkedList<String> siteDropdownItemsInExpectedOrder;
	private String siteDropdownItemsXpath;

	@Parameters({"testId", "blueprint"})
	@BeforeMethod
	public void beforeTest(String testId, String blueprint) {
		apiTestHelper.createSite(testId, "", blueprint);
		userName = constantsPropertiesManager.getSharedExecutionConstants().getProperty("crafter.username");
		password = constantsPropertiesManager.getSharedExecutionConstants().getProperty("crafter.password");
		siteDropdownElementXPath = uiElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("complexscenarios.general.sitedropdownmenuinnerxpath");
		dashboardLink = uiElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("dashboard.dashboard_menu_option");
		pagesTreeLink = uiElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("general.sitecontent.expandpages");
		componentsTreeLink = uiElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("dashboard.expand_components_tree");
		taxonomyTreeLink = uiElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("dashboard.expand_taxonomy_tree");
		staticAssetsTreeLink = uiElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("preview.static_assets_button");
		templatesTreeLink = uiElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("dashboard.expand_templates_tree");
		scriptsTreeLink = uiElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("dashboard.expand_scripts_tree");
		siteConfigLink = uiElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("general.adminconsole");
		siteDropdownItemsXpath = uiElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("dashboard.sitebar.dropdown.items");
		siteDropdownItemsInExpectedOrder = new LinkedList<String>();
		siteDropdownItemsInExpectedOrder.add(0, "Dashboard");
		siteDropdownItemsInExpectedOrder.add(1, "Pages");
		siteDropdownItemsInExpectedOrder.add(2, "Components");
		siteDropdownItemsInExpectedOrder.add(3, "Taxonomy");
		siteDropdownItemsInExpectedOrder.add(4, "Static Assets");
		siteDropdownItemsInExpectedOrder.add(5, "Templates");
		siteDropdownItemsInExpectedOrder.add(6, "Scripts");
		siteDropdownItemsInExpectedOrder.add(7, "Site Config");
		siteDropdownItemsInExpectedOrder.add(8, "here");
		siteDropdownItemsInExpectedOrder.add(9, "bug");
		siteDropdownItemsInExpectedOrder.add(10, "Crafter News");

	}

	@Parameters({"testId"})
	@Test()
	public void verifyTheSideBarDropdownOptionsUsingWebEditorialBlueprint(String testId) {
		// login to application
		loginPage.loginToCrafter(userName, password);

		// Wait for login page to close
		getWebDriverManager().waitUntilLoginCloses();

		// go to preview page
		homePage.goToPreviewPage(testId);

		// Expand the site bar
		this.getWebDriverManager().clickElement("xpath", siteDropdownElementXPath);

		// Check all the section are present;
		WebElement dashboardLinkElement = this.getWebDriverManager()
				.driverWaitUntilElementIsPresentAndDisplayed("xpath", dashboardLink);
		Assert.assertTrue(dashboardLinkElement.isDisplayed(), "ERROR: Dashboard link is not present");

		WebElement pagesTreeLinkElement = this.getWebDriverManager()
				.driverWaitUntilElementIsPresentAndDisplayed("xpath", pagesTreeLink);
		Assert.assertTrue(pagesTreeLinkElement.isDisplayed(), "ERROR: Pages Tree link is not present");

		WebElement componentsTreeLinkElement = this.getWebDriverManager()
				.driverWaitUntilElementIsPresentAndDisplayed("xpath", componentsTreeLink);
		Assert.assertTrue(componentsTreeLinkElement.isDisplayed(),
				"ERROR: Components Tree link is not present");

		WebElement taxonomyTreeLinkElement = this.getWebDriverManager()
				.driverWaitUntilElementIsPresentAndDisplayed("xpath", taxonomyTreeLink);
		Assert.assertTrue(taxonomyTreeLinkElement.isDisplayed(), "ERROR: Taxonomy Tree link is not present");

		WebElement staticAssetsTreeLinkElement = this.getWebDriverManager()
				.driverWaitUntilElementIsPresentAndDisplayed("xpath", staticAssetsTreeLink);
		Assert.assertTrue(staticAssetsTreeLinkElement.isDisplayed(),
				"ERROR: Static Assets Tree link is not present");

		WebElement templatesTreeLinkElement = this.getWebDriverManager()
				.driverWaitUntilElementIsPresentAndDisplayed("xpath", templatesTreeLink);
		Assert.assertTrue(templatesTreeLinkElement.isDisplayed(),
				"ERROR: Templates Tree link is not present");

		WebElement scriptsTreeLinkElement = this.getWebDriverManager()
				.driverWaitUntilElementIsPresentAndDisplayed("xpath", scriptsTreeLink);
		Assert.assertTrue(scriptsTreeLinkElement.isDisplayed(), "ERROR: Scripts Tree link is not present");

		WebElement siteConfigLinkElement = this.getWebDriverManager()
				.driverWaitUntilElementIsPresentAndDisplayed("xpath", siteConfigLink);
		Assert.assertTrue(siteConfigLinkElement.isDisplayed(), "ERROR: Site Config link is not present");

		List<WebElement> siteDropdownItems = this.getWebDriverManager().getDriver()
				.findElements(By.xpath(siteDropdownItemsXpath));
		int currentIndex = 0;
		for (WebElement element : siteDropdownItems) {
			this.getWebDriverManager().waitForAnimation();
			this.getWebDriverManager().waitUntilSidebarOpens();
			Assert.assertTrue(element.getText().equals(siteDropdownItemsInExpectedOrder.get(currentIndex)),
					"ERROR: Link Option: " + element.getText() + " is not in the correct order");
			currentIndex++;
		}
	}

	@Parameters({"testId"})
	@AfterMethod(alwaysRun = true)
	public void afterTest(String testId) {
		apiTestHelper.deleteSite(testId);
	}
}
