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
public class PushToRemoteAPI2Test {

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

    public PushToRemoteAPI2Test() {
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
        repositoryAPI2.testAddRemote(siteId, "originbasic", gitRepoUrl, "basic",
                gitUsername, gitPassword, "", "");
        repositoryAPI2.testAddRemote(siteId, "origintoken", gitRepoUrl, "token",
                "", "", gitToken, "");
        repositoryAPI2.testAddRemote(siteId, "originkey", gitRepoUrlSsh, "key",
                "", "", "", gitPrivateKey);
    }

    @Test(groups = { "pushToRemoteAPI2" })
    public void testPushToRemote() {
        repositoryAPI2.testPushToRemote(siteId, "originbasic", "master");
        repositoryAPI2.testPushToRemote(siteId, "origintoken", "master");
        repositoryAPI2.testPushToRemote(siteId, "originkey", "master");
    }

    @Test(groups = { "pushToRemoteAPI2" })
    public void testPushToRemoteBadRequest() {
        repositoryAPI2.testPushToRemoteBadRequest(siteId, "originbasic", "master");
        repositoryAPI2.testPushToRemoteBadRequest(siteId, "origintoken", "master");
        repositoryAPI2.testPushToRemoteBadRequest(siteId, "originkey", "master");
    }

    @Test(groups = { "pushToRemoteAPI2" })
    public void testPushToRemoteInvalidSiteId() {
        repositoryAPI2.testPushToRemoteInvalidSiteId(siteId + "invalid", "originbasic", "master");
        repositoryAPI2.testPushToRemoteInvalidSiteId(siteId + "invalid", "origintoken", "master");
        repositoryAPI2.testPushToRemoteInvalidSiteId(siteId + "invalid", "originkey", "master");
    }

    @AfterGroups(groups = { "pushToRemoteAPI2" })
    public void afterTest() {
        siteManagementAPI.testDeleteSite(siteId);
        securityAPI.logOutFromStudioUsingAPICall();
    }

    @Test( dependsOnGroups = { "pushToRemoteAPI2" })
    public void testPushToRemoteUnauthorized() {
        repositoryAPI2.testPushToRemoteUnAuthorized(siteId, "originbasic", "master");
        repositoryAPI2.testPushToRemoteUnAuthorized(siteId, "origintoken", "master");
        repositoryAPI2.testPushToRemoteUnAuthorized(siteId, "originkey", "master");
    }
}