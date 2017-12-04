package org.craftercms.studio.test.cases.apitestcases;

import org.craftercms.studio.test.api.objects.GroupManagementAPI;
import org.craftercms.studio.test.api.objects.SecurityAPI;
import org.craftercms.studio.test.api.objects.SiteManagementAPI;
import org.craftercms.studio.test.api.objects.UserManagementAPI;
import org.craftercms.studio.test.utils.APIConnectionManager;
import org.craftercms.studio.test.utils.JsonTester;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


/**
 * Created by Gustavo Ortiz Alfaro.
 */

public class AddUserToGroupAPITest {

	private SecurityAPI securityAPI;
	private SiteManagementAPI siteManagementAPI;
	private GroupManagementAPI groupManagementAPI;
	private UserManagementAPI userManagementAPI;
	private String siteId="siteTestAddUserToGroupAPITest";

	public AddUserToGroupAPITest() {
		APIConnectionManager apiConnectionManager = new APIConnectionManager();
		JsonTester api = new JsonTester(apiConnectionManager.getProtocol(), apiConnectionManager.getHost(),
				apiConnectionManager.getPort());
		securityAPI = new SecurityAPI(api, apiConnectionManager);
		siteManagementAPI = new SiteManagementAPI(api, apiConnectionManager);
		groupManagementAPI = new GroupManagementAPI(api, apiConnectionManager);
		userManagementAPI = new UserManagementAPI(api, apiConnectionManager);
	}

	@BeforeTest
	public void beforeTest() {
		securityAPI.logInIntoStudioUsingAPICall();
		siteManagementAPI.testCreateSite(siteId);
		groupManagementAPI.testCreateStudioGroup01(siteManagementAPI.getSiteId());
		userManagementAPI.testCreateUser();
	}

	@Test(priority = 1)
	public void testAddUserToGroup() {
		groupManagementAPI.testAddUserToGroup(userManagementAPI.getNewusername(),siteManagementAPI.getSiteId());
	}

	@Test(priority = 2)
	public void testInvalidParameters() {
		groupManagementAPI.testAddUserToGroupInvalidParameters(userManagementAPI.getNewusername(), siteManagementAPI.getSiteId());
	}

	@Test(priority = 3)
	public void testUserNotFound() {
		groupManagementAPI.testAddUserToGroupUserNotFound(userManagementAPI.getNewusername(), siteManagementAPI.getSiteId());
	}

	@Test(priority = 4)
	public void testGroupNotFound() {
		groupManagementAPI.testAddUserToGroupGroupNotFound(userManagementAPI.getNewusername(), siteManagementAPI.getSiteId());
	}

	@Test(priority = 5)
	public void testUserAlreadyInGroup() {
		groupManagementAPI.testAddUserToGroupAlreadyInGroup(userManagementAPI.getNewusername(), siteManagementAPI.getSiteId());
	}
	
	@AfterTest
	public void afterTest() {
		userManagementAPI.testDeleteUser();
		siteManagementAPI.testDeleteSite(siteId);
		securityAPI.logOutFromStudioUsingAPICall();
	}
}
