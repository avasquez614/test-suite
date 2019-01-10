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

package org.craftercms.studio.test.api.objects;


import org.craftercms.studio.test.utils.APIConnectionManager;
import org.craftercms.studio.test.utils.JsonTester;

/**
 * @author chris lim
 *
 */
public class MonitoringAPI extends BaseAPI {


	public MonitoringAPI(JsonTester api, APIConnectionManager apiConnectionManager) {
		super(api, apiConnectionManager);
	}

 	public void testVersion(){
   		api.get("studio/api/1/services/api/1/monitor/version.json").execute().status(200).debug();
 	}
 	
 	public void testStatus(){
   		api.get("studio/api/1/services/api/1/monitor/status.json").execute().status(200).debug();
 	}

 	public void testMemory(){
   		api.get("studio/api/1/services/api/1/monitor/memory.json").execute().status(200).debug();
 	}
 	
}
