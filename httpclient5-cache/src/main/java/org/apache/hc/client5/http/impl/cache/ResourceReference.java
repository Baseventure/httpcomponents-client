/*
 * ====================================================================
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 * ====================================================================
 *
 * This software consists of voluntary contributions made by many
 * individuals on behalf of the Apache Software Foundation.  For more
 * information on the Apache Software Foundation, please see
 * <http://www.apache.org/>.
 *
 */
package org.apache.hc.client5.http.impl.cache;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;

import org.apache.hc.client5.http.cache.HttpCacheEntry;
import org.apache.hc.client5.http.cache.Resource;
import org.apache.hc.core5.util.Args;

class ResourceReference extends PhantomReference<HttpCacheEntry> {

    private final Resource resource;

    public ResourceReference(final HttpCacheEntry entry, final ReferenceQueue<HttpCacheEntry> q) {
        super(entry, q);
        Args.notNull(entry.getResource(), "Resource");
        this.resource = entry.getResource();
    }

    public Resource getResource() {
        return this.resource;
    }

    @Override
    public int hashCode() {
        return this.resource.hashCode();
    }

    @Override
    public boolean equals(final Object obj) {
        return this.resource.equals(obj);
    }

}
