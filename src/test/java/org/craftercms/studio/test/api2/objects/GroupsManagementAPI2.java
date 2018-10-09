/*
 * Copyright (C) 2007-2018 Crafter Software Corporation. All Rights Reserved.
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

package org.craftercms.studio.test.api2.objects;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.http.HttpStatus;
import org.craftercms.studio.test.api.objects.BaseAPI;
import org.craftercms.studio.test.utils.APIConnectionManager;
import org.craftercms.studio.test.utils.JsonResponse;
import org.craftercms.studio.test.utils.JsonTester;
import com.fasterxml.jackson.databind.ObjectMapper;
import net.minidev.json.JSONArray;
import net.minidev.json.JSONObject;

/**
 * @author luishernandez
 *
 */
public class GroupsManagementAPI2 extends BaseAPI {

	private String offSet;
	private String limit;
	private String sort;
	
	public GroupsManagementAPI2(JsonTester api, APIConnectionManager apiConnectionManager, String offSet, String limit, String sort) {
		super(api, apiConnectionManager);
		this.offSet=offSet;
		this.limit=limit;
		this.sort=sort;
	}

	public void testGetAllGroups() {
		api.get("/studio/api/2/groups").urlParam("offset", offSet).urlParam("limit", limit)
				.urlParam("sort", sort).execute().status(HttpStatus.SC_OK);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public String getGroupIDForGroupName(String groupName) {
		String id = "";
		JsonResponse response = api.get("/studio/api/2/groups").urlParam("offset", offSet)
				.urlParam("limit", limit).urlParam("sort", sort).execute();

		ObjectMapper mapper = new ObjectMapper();
		try {
			Map responseMap = mapper.readValue(response.getRaw(), Map.class);
			Map resultMap = (Map) responseMap.get("result");
			List<Map> entities = (List<Map>) resultMap.get("entities");

			id = String.valueOf(entities.stream().filter(e -> e.get("name").equals(groupName)).map(e -> e.get("id"))
					.findFirst().get());
		} catch (IOException e) {
			e.printStackTrace();
		}

		return id;
	}

	public void testGetAllGroupsBadRequest() {
		api.get("/studio/api/2/groups").urlParam("offset", offSet+"nonint").urlParam("limit", limit)
				.urlParam("sort", sort).execute().status(HttpStatus.SC_BAD_REQUEST);
	}

	public void testGetAllGroupsNonAuthorized() {
		api.get("/studio/api/2/groups").urlParam("offset", offSet).urlParam("limit", limit)
				.urlParam("sort", sort).execute().status(HttpStatus.SC_UNAUTHORIZED);
	}
	
	public void testCreateGroupsWithGivenID(String id, String groupName) {
		Map<String, Object> json = new HashMap<>();
		json.put("id", id);
		json.put("name", groupName);
		json.put("desc", "Testing Group API2 with given id");

		api.post("/studio/api/2/groups").json(json).execute().status(HttpStatus.SC_CREATED);
	}

	public void testCreateGroupsResourceAlreadyExists(String id, String groupName) {
		Map<String, Object> json = new HashMap<>();
		json.put("id", id);
		json.put("name", groupName);
		json.put("desc", "Testing Group API2 with given id");

		api.post("/studio/api/2/groups").json(json).execute().status(HttpStatus.SC_CONFLICT);
	}

	
	public void testCreateGroupsBadRequest() {
		Map<String, Object> json = new HashMap<>();
		json.put("idnonvalid", 0);
		json.put("name", "Test_Groups");
		json.put("desc", "Testing Group API2");

		api.post("/studio/api/2/groups").json(json).execute().status(HttpStatus.SC_BAD_REQUEST);
	}

	public void testCreateGroupsUnauthorized() {
		Map<String, Object> json = new HashMap<>();
		json.put("id", 0);
		json.put("name", "Test_Groups");
		json.put("desc", "Testing Group API2");

		api.post("/studio/api/2/groups").json(json).execute().status(HttpStatus.SC_UNAUTHORIZED);
	}

	public void testDeleteGroups(String id) {
		api.delete("/studio/api/2/groups").urlParam("id", id).execute().status(HttpStatus.SC_OK);
	}

	public void testDeleteGroupsBadRequest(String id) {
		api.delete("/studio/api/2/groups").urlParam("idnonvalid", id).execute().status(HttpStatus.SC_BAD_REQUEST);
	}

	public void testDeleteGroupsUnauthorized(String id) {
		api.delete("/studio/api/2/groups").urlParam("idnonvalid", id).execute().status(HttpStatus.SC_UNAUTHORIZED);
	}

	public void testUpdateGroups(String id, String groupName) {
		Map<String, Object> json = new HashMap<>();
		json.put("id", id);
		json.put("name", groupName);
		json.put("desc", "Testing Group API2 updated");

		api.patch("/studio/api/2/groups").json(json).execute().status(HttpStatus.SC_OK);
	}

	public void testUpdateGroupsResourceNotFound(String id, String groupName) {
		Map<String, Object> json = new HashMap<>();
		json.put("id", id);
		json.put("name", groupName);
		json.put("desc", "Testing Group API2 updated");

		api.patch("/studio/api/2/groups").json(json).execute().status(HttpStatus.SC_NOT_FOUND);
	}

	public void testUpdateGroupsBadRequest(String id, String groupName) {
		Map<String, Object> json = new HashMap<>();
		json.put("idnonvalid", id);
		json.put("name", groupName);
		json.put("desc", "Testing Group API2 updated");

		api.patch("/studio/api/2/groups").json(json).execute().status(HttpStatus.SC_BAD_REQUEST);
	}

	public void testUpdateGroupsUnauthorized(String id, String groupName) {
		Map<String, Object> json = new HashMap<>();
		json.put("id", id);
		json.put("name", groupName);
		json.put("desc", "Testing Group API2 updated");

		api.patch("/studio/api/2/groups").json(json).execute().status(HttpStatus.SC_UNAUTHORIZED);
	}

	public void testGetGroupsByID(String id) {
		api.get("/studio/api/2/groups/" + id).execute().status(HttpStatus.SC_OK);
	}

	public void testGetGroupsByIDResourceNotFound(String id) {
		api.get("/studio/api/2/groups/" + id).execute().status(HttpStatus.SC_NOT_FOUND);
	}

	public void testGetGroupsByIDBadRequest(String id) {
		api.get("/studio/api/2/groups/" + id + "nonvalid").execute().status(HttpStatus.SC_BAD_REQUEST);
	}

	public void testGetGroupsByIDNonAuthorized(String id) {
		api.get("/studio/api/2/groups/" + id).execute().status(HttpStatus.SC_UNAUTHORIZED);
	}

	public void testGetGroupsMembers(String id) {
		api.get("/studio/api/2/groups/" + id + "/members").execute().status(HttpStatus.SC_OK);
	}

	public void testGetGroupsMembersResourceNotFound(String id) {
		api.get("/studio/api/2/groups/" + id + "/members").execute().status(HttpStatus.SC_NOT_FOUND);
	}

	public void testGetGroupsMembersBadRequest(String id) {
		api.get("/studio/api/2/groups/" + id + "nonvalid" + "/members").execute().status(HttpStatus.SC_BAD_REQUEST);
	}

	public void testGetGroupsMembersNonAuthorized(String id) {
		api.get("/studio/api/2/groups/" + id + "/members").execute().status(HttpStatus.SC_UNAUTHORIZED);
	}

	public void testAddMemberToGroupUsingUsername(String groupId, String userName) {

		JSONArray usernames = new JSONArray();
		usernames.add(userName);

		JSONObject json = new JSONObject();
		json.put("usernames", usernames);

		api.post("/studio/api/2/groups/" + groupId + "/members").json(json).execute().status(HttpStatus.SC_OK);
	}
	
	public void testAddMemberToGroupUsingUsernameNonAuthorized(String groupId, String userName) {

		JSONArray usernames = new JSONArray();
		usernames.add(userName);

		JSONObject json = new JSONObject();
		json.put("usernames", usernames);

		api.post("/studio/api/2/groups/" + groupId + "/members").json(json).execute().status(HttpStatus.SC_UNAUTHORIZED);
	}
	
	public void testAddMemberToGroupUsingUsernameBadRequest(String groupId, String userName) {

		JSONArray usernames = new JSONArray();
		usernames.add(userName);

		JSONObject json = new JSONObject();
		json.put("usernamesnonvalid", usernames);

		api.post("/studio/api/2/groups/" + groupId + "/members").json(json).execute().status(HttpStatus.SC_BAD_REQUEST);
	}
	
	public void testAddMemberToGroupUsingUsernameResourceNotFound(String groupId, String userName) {

		JSONArray usernames = new JSONArray();
		usernames.add(userName);

		JSONObject json = new JSONObject();
		json.put("usernames", usernames);

		api.post("/studio/api/2/groups/" + groupId + "/members").json(json).execute().status(HttpStatus.SC_NOT_FOUND);
	}
	
	public void testRemoveMemberFromGroupUsingUsername(String groupId, String userName) {
		api.delete("/studio/api/2/groups/" + groupId + "/members").urlParam("username",userName).execute().status(HttpStatus.SC_OK);
	}
	
	public void testRemoveMemberFromGroupUsingUsernameNonAuthorized(String groupId, String userName) {
		api.delete("/studio/api/2/groups/" + groupId + "/members").urlParam("username",userName).execute().status(HttpStatus.SC_UNAUTHORIZED);
	}
	
	public void testRemoveMemberFromGroupUsingUsernameBadRequest(String groupId, String userName) {
		api.delete("/studio/api/2/groups/" + groupId + "/members").urlParam("username"+"nonvalid",userName).execute().status(HttpStatus.SC_BAD_REQUEST);
	}
	
	public void testRemoveMemberFromUsingUsernameResourceNotFound(String groupId, String userName) {
		api.delete("/studio/api/2/groups/" + groupId + "/members").urlParam("username",userName).execute().status(HttpStatus.SC_NOT_FOUND);
	}
	
}