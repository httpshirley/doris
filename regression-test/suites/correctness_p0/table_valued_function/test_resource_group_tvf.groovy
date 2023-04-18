// Licensed to the Apache Software Foundation (ASF) under one
// or more contributor license agreements.  See the NOTICE file
// distributed with this work for additional information
// regarding copyright ownership.  The ASF licenses this file
// to you under the Apache License, Version 2.0 (the
// "License"); you may not use this file except in compliance
// with the License.  You may obtain a copy of the License at
//
//   http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing,
// software distributed under the License is distributed on an
// "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
// KIND, either express or implied.  See the License for the
// specific language governing permissions and limitations
// under the License.

// This suit test the `resource_groups` tvf
// TO DO
suite("test_resource_groups_tvf") {
    sql """ADMIN SET FRONTEND CONFIG ("experimental_enable_resource_group" = "true");"""

    def name1 = "test";
	sql "create resource group if not exists ${name1} properties('cpu_share'='10');"
    List<List<Object>> table =  sql """ select * from resource_groups(); """
    assertTrue(table.size() > 0)
    assertTrue(table[0].size == 4) // column should be 4

    sql """ADMIN SET FRONTEND CONFIG ("experimental_enable_resource_group" = "false");"""
}