package org.craftercms.studio.test.cases.apitestcases;

import org.craftercms.studio.test.api.objects.RepoManagementAPI;
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

public class RebuildDataBaseAPITest {

	private SecurityAPI securityAPI;
	private SiteManagementAPI siteManagementAPI;
	private RepoManagementAPI repoManagementAPI;
	private String siteId="siteRebuildDataBaseAPITest";
	
	public RebuildDataBaseAPITest() {
		APIConnectionManager apiConnectionManager = new APIConnectionManager();
		JsonTester api = new JsonTester(apiConnectionManager.getProtocol(), apiConnectionManager.getHost(),
				apiConnectionManager.getPort());
		securityAPI = new SecurityAPI(api, apiConnectionManager);
		siteManagementAPI = new SiteManagementAPI(api, apiConnectionManager);
		repoManagementAPI = new RepoManagementAPI(api, apiConnectionManager);
	}

	@BeforeTest
	public void beforeTest() {
		securityAPI.logInIntoStudioUsingAPICall();
		siteManagementAPI.testCreateSite(siteId);
	}

    @Test(priority=1)
   	public void testRebuildDatabase() {
    	repoManagementAPI.testRebuildDatabase(siteManagementAPI.getSiteId());
   	}
    
    
//    @Test(priority=2)
//   	public void testRebuildDatabaseInvalidParameter() {
//     	repoManagementAPI.testRebuildDatabaseInvalidParameter(siteManagementAPI.getSiteId());
//   	}
//    
    
    @AfterTest
	public void afterTest() {
		siteManagementAPI.testDeleteSite(siteId);
		securityAPI.logOutFromStudioUsingAPICall();
	}
    
}
