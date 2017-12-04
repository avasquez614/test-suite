package org.craftercms.studio.test.cases.apitestcases;

import org.craftercms.studio.test.api.objects.AuditAPI;
import org.craftercms.studio.test.api.objects.SecurityAPI;
import org.craftercms.studio.test.api.objects.SiteManagementAPI;
import org.craftercms.studio.test.utils.APIConnectionManager;
import org.craftercms.studio.test.utils.JsonTester;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 * Created by Gustavo Ortiz Alfaro
 */

public class GetAuditLogAPITest {

	private SecurityAPI securityAPI;
	private SiteManagementAPI siteManagementAPI;
	private AuditAPI auditAPI;
	private String siteId="siteGetAuditLogAPITest";
	
	public GetAuditLogAPITest() {
		APIConnectionManager apiConnectionManager = new APIConnectionManager();
		JsonTester api = new JsonTester(apiConnectionManager.getProtocol(), apiConnectionManager.getHost(),
				apiConnectionManager.getPort());
		securityAPI = new SecurityAPI(api, apiConnectionManager);
		siteManagementAPI = new SiteManagementAPI(api, apiConnectionManager);
		auditAPI = new AuditAPI(api, apiConnectionManager);
	}

	@BeforeTest
	public void beforeTest() {
		securityAPI.logInIntoStudioUsingAPICall();
		siteManagementAPI.testCreateSite(siteId);

	}

	@Test(priority = 1)
	public void testGetAuditLog() {
		auditAPI.testGetAuditLog(siteManagementAPI.getSiteId());
	}

	@Test(priority = 2)
	public void testGetAuditLogInvalidParameters() {
		auditAPI.testGetAuditLogInvalidParameter(siteManagementAPI.getSiteId());
	}

	@Test(priority = 3)
	public void testGetAuditLogSiteNotFound() {
		auditAPI.testGetAuditLogSiteNotFound(siteManagementAPI.getSiteId());
	}

	@AfterTest
	public void afterTest() {
		siteManagementAPI.testDeleteSite(siteId);
		securityAPI.logOutFromStudioUsingAPICall();
	}

}
