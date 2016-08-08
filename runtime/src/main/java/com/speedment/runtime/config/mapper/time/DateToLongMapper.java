/**
 *
 * Copyright (c) 2006-2016, Speedment, Inc. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); You may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at:
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package com.speedment.runtime.config.mapper.time;

import com.speedment.runtime.annotation.Api;
import com.speedment.runtime.config.Column;
import com.speedment.runtime.config.mapper.TypeMapper;
import java.lang.reflect.Type;

import java.sql.Date;


/**
 *
 * @author  Maria Sparenberg
 * @author  Patrick Hobusch
 */
@Api(version = "3.0")
public final class DateToLongMapper implements TypeMapper<Date, Long> {

    @Override
    public String getLabel() {
        return "Date to Long";
    }
    
    @Override
    public Type getJavaType(Column column) {
        return Long.class;
    }

    @Override
    public <ENTITY> Long toJavaType(Column column, Class<ENTITY> entityType, Date value) {
        return value == null ? null : value.getTime();
    }

    @Override
    public Date toDatabaseType(Long value) {
        return value == null ? null : new Date(value);
    }
}