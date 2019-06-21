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

import org.craftercms.studio.test.api.objects.SecurityAPI;
import org.craftercms.studio.test.api.objects.SiteManagementAPI;
import org.craftercms.studio.test.api2.objects.RepositoryAPI2;
import org.craftercms.studio.test.utils.*;
import org.testng.annotations.AfterGroups;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 *
 * @author yacdaniel
 *
 */
public class PullFromRemoteAPI2Test {

    private SecurityAPI securityAPI;
    private RepositoryAPI2 repositoryAPI2;
    private SiteManagementAPI siteManagementAPI;
    private WebDriverManager webDriverManager;
    private ConstantsPropertiesManager constantsPropertiesManager;
    private String gitRepoUrl;
    private String gitRepoUrlSsh;
    private String gitUsername;
    private String gitPassword;
    private String gitToken;
    private String gitPrivateKey;
    private String siteId = "pushpullremoteapi2test";

    public PullFromRemoteAPI2Test() {
        APIConnectionManager apiConnectionManager = new APIConnectionManager();
        JsonTester api = new JsonTester(apiConnectionManager.getProtocol(), apiConnectionManager.getHost(),
                apiConnectionManager.getPort());
        securityAPI = new SecurityAPI(api, apiConnectionManager);
        siteManagementAPI = new SiteManagementAPI(api, apiConnectionManager);
        repositoryAPI2 = new RepositoryAPI2(api, apiConnectionManager);
        constantsPropertiesManager = new ConstantsPropertiesManager(FilesLocations.CONSTANTSPROPERTIESFILEPATH);
        webDriverManager = new WebDriverManager();
    }

    @BeforeTest
    public void beforeTest() {
        gitRepoUrl = constantsPropertiesManager.getSharedExecutionConstants()
                .getProperty("crafter.api2.repository.url.http");
        gitRepoUrlSsh = constantsPropertiesManager.getSharedExecutionConstants()
                .getProperty("crafter.api2.repository.url.ssh");
        gitUsername = constantsPropertiesManager.getSharedExecutionConstants()
                .getProperty("crafter.gitrepository.username");
        gitPassword = constantsPropertiesManager.getSharedExecutionConstants()
                .getProperty("crafter.gitrepository.password");
        gitToken = constantsPropertiesManager.getSharedExecutionConstants()
                .getProperty("crafter.gitrepository.token");
        gitPrivateKey = webDriverManager.getPrivateKeyContentFromPrivateKeyTestFile(FilesLocations.PRIVATEKEYCONTENTFILEPATH);

        securityAPI.logInIntoStudioUsingAPICall();
        siteManagementAPI.testCreateSite(siteId);
        //siteManagementAPI.testCreateSite(siteId, "Test API 2 pull", "org.craftercms.blueprint.editorial");
        repositoryAPI2.testAddRemote(siteId, "originbasic", gitRepoUrl, "basic",
                gitUsername, gitPassword, "", "");
        repositoryAPI2.testAddRemote(siteId, "origintoken", gitRepoUrl, "token",
                "", "", gitToken, "");
        repositoryAPI2.testAddRemote(siteId, "originkey", gitRepoUrlSsh, "key",
                "", "", "", gitPrivateKey);
    }

    @Test(groups = { "pullFromRemoteAPI2" })
    public void testPullFromRemote() {
        repositoryAPI2.testPullFromRemote(siteId, "originbasic", "master");
    }

    @Test(groups = { "pullFromRemoteAPI2" })
    public void testPullFromRemoteBadRequest() {
        repositoryAPI2.testPullFromRemoteBadRequest(siteId, "originbasic", "master");
        repositoryAPI2.testPullFromRemoteBadRequest(siteId, "origintoken", "master");
        repositoryAPI2.testPullFromRemoteBadRequest(siteId, "originkey", "master");
    }

    @Test(groups = { "pullFromRemoteAPI2" })
    public void testPullFromRemoteInvalidSiteId() {
        repositoryAPI2.testPullFromRemoteInvalidSiteId(siteId + "invalid", "originbasic", "master");
        repositoryAPI2.testPullFromRemoteInvalidSiteId(siteId + "invalid", "origintoken", "master");
        repositoryAPI2.testPullFromRemoteInvalidSiteId(siteId + "invalid", "originkey", "master");
    }

    @AfterGroups(groups = { "pullFromRemoteAPI2" })
    public void afterTest() {
        siteManagementAPI.testDeleteSite(siteId);
        securityAPI.logOutFromStudioUsingAPICall();
    }

    @Test( dependsOnGroups = { "pullFromRemoteAPI2" })
    public void testPullFromRemoteUnauthorized() {
        repositoryAPI2.testPullFromRemoteUnAuthorized(siteId, "originbasic", "master");
        repositoryAPI2.testPullFromRemoteUnAuthorized(siteId, "origintoken", "master");
        repositoryAPI2.testPullFromRemoteUnAuthorized(siteId, "originkey", "master");
    }
}
