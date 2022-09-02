/*
 * Copyright 2020 American Express Travel Related Services Company, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */

package io.americanexpress.synapse.data.mongodb.entity;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.annotation.Version;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDateTime;

public abstract class BaseDocument {

    /**
     * Identifier
     */
    @Id
    protected String identifier;

    /**
     * Created Date Time
     */
    @CreatedDate
    @Field("created_date_time")
    protected LocalDateTime createdDateTime;

    /**
     * Last Modified Date Time
     */
    @LastModifiedDate
    @Field("last_modified_date_time")
    protected LocalDateTime lastModifiedDateTime;

    /**
     * Created By
     */
    @CreatedBy
    @Field("created_by")
    protected String createdBy;

    /**
     * Last Modified By
     */
    @LastModifiedBy
    @Field("last_modified_by")
    protected String lastModifiedBy;

    /**
     * Version
     */
    @Version
    @Field("version")
    protected Long version;

    /**
     * Empty constructor, do not delete it. It is used by Spring Data.
     */
    public BaseDocument() {
    }

}
