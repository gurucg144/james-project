/****************************************************************
 * Licensed to the Apache Software Foundation (ASF) under one   *
 * or more contributor license agreements.  See the NOTICE file *
 * distributed with this work for additional information        *
 * regarding copyright ownership.  The ASF licenses this file   *
 * to you under the Apache License, Version 2.0 (the            *
 * "License"); you may not use this file except in compliance   *
 * with the License.  You may obtain a copy of the License at   *
 *                                                              *
 *   http://www.apache.org/licenses/LICENSE-2.0                 *
 *                                                              *
 * Unless required by applicable law or agreed to in writing,   *
 * software distributed under the License is distributed on an  *
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY       *
 * KIND, either express or implied.  See the License for the    *
 * specific language governing permissions and limitations      *
 * under the License.                                           *
 ****************************************************************/

package org.apache.james;

import static org.assertj.core.api.Assertions.assertThat;

import org.apache.commons.configuration.HierarchicalConfiguration;
import org.apache.james.utils.ConfigurationProvider;
import org.apache.james.utils.FailingPropertiesProvider;
import org.apache.james.utils.PropertiesProvider;
import org.junit.After;
import org.junit.Before;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;

public class DefaultCassandraJamesServerTest {

    @ClassRule
    public static DockerCassandraRule cassandra = new DockerCassandraRule();
    
    @Rule
    public CassandraJmapTestRule cassandraJmap = CassandraJmapTestRule.defaultTestRule();

    private GuiceJamesServer guiceJamesServer;

    @Before
    public void setUp() {
        guiceJamesServer = cassandraJmap.jmapServer(cassandra.getModule())
            .overrideWith(binder -> binder.bind(PropertiesProvider.class).to(FailingPropertiesProvider.class))
            .overrideWith(binder -> binder.bind(ConfigurationProvider.class).toInstance(s -> new HierarchicalConfiguration()));
    }

    @After
    public void clean() {
        guiceJamesServer.stop();
    }

    @Test
    public void memoryJamesServerShouldStartWithNoConfigurationFile() throws Exception {
        guiceJamesServer.start();

        assertThat(guiceJamesServer.isStarted()).isTrue();
    }

}
