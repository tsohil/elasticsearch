/*
 * Licensed to Elasticsearch under one or more contributor
 * license agreements. See the NOTICE file distributed with
 * this work for additional information regarding copyright
 * ownership. Elasticsearch licenses this file to you under
 * the Apache License, Version 2.0 (the "License"); you may
 * not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.elasticsearch.index.shard;

import org.elasticsearch.common.inject.Module;
import org.elasticsearch.plugins.AbstractPlugin;
import org.elasticsearch.test.engine.MockEngineFactory;
import org.elasticsearch.test.engine.MockEngineSupportModule;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

// this must exist in the same package as IndexShardModule to allow access to setting the impl
public class MockEngineFactoryPlugin extends AbstractPlugin {
    @Override
    public String name() {
        return "mock-engine-factory";
    }
    @Override
    public String description() {
        return "a mock engine factory for testing";
    }
    @Override
    public Collection<Class<? extends Module>> indexModules() {
        List<Class<? extends Module>> modules = new ArrayList<>();
        modules.add(MockEngineSupportModule.class);
        return modules;
    }
    public void onModule(IndexShardModule module) {
        module.engineFactoryImpl = MockEngineFactory.class;
    }
}
