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
package org.craftercms.studio.test.cases.userstestcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.craftercms.studio.test.cases.StudioBaseTest;

/**
 * 
 * @author Gustavo Andrei Ortiz Alfaro
 *
 */

public class EditUserTest extends StudioBaseTest {

	private String userName;
	private String password;
	private String newUserLastNameId;
	private String newUserEmailId;
	private String newUserFirstNameId;
	private String newUserUserNameId;
	private String newUserPasswordId;
	private String newUserPasswordVerificationId;
	private String newUserButtonXpath;
	private String newUserNewPasswordId;
	private String newUserLastNameCellXpath;

	@BeforeMethod
	public void beforeTest() {
		userName = constantsPropertiesManager.getSharedExecutionConstants().getProperty("crafter.username");
		password = constantsPropertiesManager.getSharedExecutionConstants().getProperty("crafter.password");
		newUserFirstNameId = uiElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("general.users.firstname");
		newUserLastNameId = uiElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("general.users.lastname");
		newUserEmailId = uiElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("general.users.email");
		newUserUserNameId = uiElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("general.users.username");
		newUserPasswordId = uiElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("general.users.password");
		newUserPasswordVerificationId = uiElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("general.users.passwordVerification");
		newUserButtonXpath = uiElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("general.users.newuserbutton");
		newUserNewPasswordId = uiElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("general.users.newpassword");
		newUserLastNameCellXpath = uiElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("general.users.newuserlastnamecell");
	}

	public void createUserToEdit() {
		// click on new user button
		usersPage.clickOnNewUser();

		// Follow the form
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("xpath", newUserFirstNameId)
				.sendKeys("Name");

		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("xpath", newUserLastNameId)
				.sendKeys("Last Name");

		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("xpath", newUserEmailId)
				.sendKeys("email@email.com");

		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("xpath", newUserUserNameId)
				.sendKeys("username");

		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("xpath", newUserPasswordId)
				.sendKeys("password");

		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("xpath", newUserPasswordVerificationId)
				.sendKeys("password");

		// Save Button
		usersPage.clickOnSaveNewUser();

	}

	public void editingUser() {
		// Click on edit option

		usersPage.clickOnEditUserCreated();

		// Follow the form
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("xpath", newUserFirstNameId).clear();
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("xpath", newUserFirstNameId)
				.sendKeys("Test");

		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("xpath", newUserLastNameId).clear();
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("xpath", newUserLastNameId)
				.sendKeys("Test");

		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("xpath", newUserEmailId).clear();
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("xpath", newUserEmailId)
				.sendKeys("Test@email.com");

		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("xpath", newUserNewPasswordId).clear();
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("xpath", newUserNewPasswordId)
				.sendKeys("passwordEdited");

		// Save Button
		usersPage.clickOnSaveNewUser();
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayedAndClickable("xpath",newUserButtonXpath);

	}

	@Test(
			priority = 0)
	public void verifyThatStudioAllowsToEditAnUser() {

		// login to application
		loginPage.loginToCrafter(userName, password);

		// Wait for login page to close
		driverManager.waitUntilLoginCloses();

		// click On Users option
		createSitePage.clickOnUsersOption();

		// create a new user
		createUserToEdit();

		// wait for element is clickeable
		this.driverManager.waitUntilModalCloses();

		// edit user
		editingUser();

		this.driverManager.waitForAnimation();

		String nameElementText = this.driverManager
				.driverWaitUntilElementIsPresentAndDisplayed("xpath", newUserLastNameCellXpath).getText();

		Assert.assertEquals(nameElementText, "Test");

	}

	@AfterMethod
	public void afterTest() {
		// Click on delete user
		usersPage.deleteAllUsersExceptAdmin();
	}
}
