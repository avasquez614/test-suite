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

package org.craftercms.studio.test.cases.api2testcases;

import org.craftercms.studio.test.api2.objects.AuditAPI2;
import org.craftercms.studio.test.api.objects.SecurityAPI;
import org.craftercms.studio.test.api.objects.SiteManagementAPI;
import org.craftercms.studio.test.utils.APIConnectionManager;
import org.craftercms.studio.test.utils.JsonTester;
import org.testng.annotations.AfterGroups;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 * Created by Gustavo Ortiz Alfaro
 */

public class GetAuditLogAPI2Test {

	private SecurityAPI securityAPI;
	private SiteManagementAPI siteManagementAPI;
	private AuditAPI2 auditAPI2;
	private String siteId="sitegetauditlogapi2test";
	
	public GetAuditLogAPI2Test() {
		APIConnectionManager apiConnectionManager = new APIConnectionManager();
		JsonTester api = new JsonTester(apiConnectionManager.getProtocol(), apiConnectionManager.getHost(),
				apiConnectionManager.getPort());
		securityAPI = new SecurityAPI(api, apiConnectionManager);
		siteManagementAPI = new SiteManagementAPI(api, apiConnectionManager);
		auditAPI2 = new AuditAPI2(api, apiConnectionManager);
	}

	@BeforeTest
	public void beforeTest() {
		securityAPI.logInIntoStudioUsingAPICall();
		siteManagementAPI.testCreateSite(siteId);
	}

	@Test(priority = 1,groups={"getAuditLog"})
	public void testGetAuditLog() {
		auditAPI2.testGetAuditLog(siteId);
	}

	@Test(priority = 2,groups={"getAuditLog"})
	public void testGetAuditLogSiteNotFound() {
		auditAPI2.testGetAuditLogSiteNotFound(siteId);
	}

	@Test(priority = 3, groups = {"getAuditLog"})
	public void testGetAuditLogEntry() {
		auditAPI2.testGetAuditLogEntry(1);
	}

	@Test(priority = 3, groups = {"getAuditLog"})
	public void testGetAuditLogByUser() {
		auditAPI2.testGetAuditLogByUser("admin");
	}

	@AfterGroups(groups={"getAuditLog"})
	public void afterTest() {
		siteManagementAPI.testDeleteSite(siteId);
		securityAPI.logOutFromStudioUsingAPICall();
	}

	@Test(dependsOnGroups={"getAuditLog"})
	public void testGetAuditLogUnauthorized() {
		auditAPI2.testGetAuditLogUnauthorized(siteManagementAPI.getSiteId());
	}
}
