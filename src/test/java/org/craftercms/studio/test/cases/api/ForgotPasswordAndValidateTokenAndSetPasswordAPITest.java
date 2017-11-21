package org.craftercms.studio.test.cases.api;

import org.craftercms.studio.test.api.objects.SecurityAPI;
import org.craftercms.studio.test.api.objects.UserManagementAPI;
import org.craftercms.studio.test.utils.APIConnectionManager;
import org.craftercms.studio.test.utils.FakeSMTPServerManager;
import org.craftercms.studio.test.utils.JsonTester;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 * Created by Gustavo Ortiz Alfaro.
 */

public class ForgotPasswordAndValidateTokenAndSetPasswordAPITest {

	private SecurityAPI securityAPI;
	private UserManagementAPI userManagementAPI;
	private FakeSMTPServerManager fakeSMTPServerManager;

	public ForgotPasswordAndValidateTokenAndSetPasswordAPITest() {
		APIConnectionManager apiConnectionManager = new APIConnectionManager();
		JsonTester api = new JsonTester(apiConnectionManager.getProtocol(), apiConnectionManager.getHost(),
				apiConnectionManager.getPort());
		securityAPI = new SecurityAPI(api,apiConnectionManager);
		userManagementAPI = new UserManagementAPI(api,apiConnectionManager);
		fakeSMTPServerManager = new FakeSMTPServerManager();
	}

	@BeforeTest
	public void beforeTest() {
		securityAPI.logInIntoStudioUsingAPICall();
		userManagementAPI.testCreateUser();
		
	}
	
	@Test(priority=1)
	public void testForgotPassword() {
		fakeSMTPServerManager.startFakeSMTPServer();
		userManagementAPI.testForgotPassword();
		userManagementAPI.setToken(fakeSMTPServerManager.getRecentlyGeneratedToken());
		fakeSMTPServerManager.stopFakeSMTPServer();
	}
	
	@Test(priority=2)
	public void testForgotPasswordUserNotFound() {
		userManagementAPI.testForgotPasswordUserNotFound();

	}
	
	@Test(priority=3)
	public void testForgotPasswordInternalServerError() {
		userManagementAPI.testForgotPasswordInternalServerError();
	}

	@Test(priority = 4)
	public void testValidateToken() {
		userManagementAPI.testValidateToken();
	}

	@Test(priority = 5)
	public void testValidateTokenInvalidParameters() {
		userManagementAPI.testValidateTokenInvalidParameters();
	}

	//TODO: This scenario can't be tested because this call is not login dependent
//	@Test(priority = 6)
//	public void testValidateTokenUnauthorized() {
//		securityAPI.logOutFromStudioUsingAPICall();
//		userManagementAPI.testValidateTokenUnauthorized();
//		securityAPI.logInIntoStudioUsingAPICall();
//	}

	
	//TODO: This scenario can't be tested because LDAP is needed for this
//	@Test(priority = 7)
//	public void testValidateTokenExternallyManagedUser() {
//		userManagementAPI.testUpdateUserToExternallyManaged();
//		userManagementAPI.testValidateTokenExternallyManagedUser();
//	}

	//TODO: This scenario can't be executed because there are no way to cause the return of 500
//	@Test(priority = 8)
//	public void testValidateTokenInternalServerError() {
//		userManagementAPI.testValidateTokenInternalServerError();
//	}
	
	@Test(priority = 9)
	public void testSetPassword() {
		userManagementAPI.testSetPassword();
	}

	@Test(priority = 10)
	public void testSetPasswordInvalidParameters() {
		userManagementAPI.testSetPasswordInvalidParameters();
	}

	//TODO: This scenario can't be tested because this call is not login dependent
//	@Test(priority = 11)
//	public void testSetPasswordUnauthorized() {
//		securityAPI.logOutFromStudioUsingAPICall();
//		userManagementAPI.testSetPasswordUnauthorized();
//		securityAPI.logInIntoStudioUsingAPICall();
//	}
	
	@AfterTest
	public void afterTest() {	
		userManagementAPI.testDeleteUser();
		securityAPI.logOutFromStudioUsingAPICall();
	}
}
