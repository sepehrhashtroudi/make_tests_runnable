/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.commons.lang3.builder;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.commons.lang3.builder.ToStringStyleTest.Person;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Unit tests {@link org.apache.commons.lang3.builder.SimpleToStringStyleTest}.
 *
 * @version $Id$
 */
public class SimpleToStringStyleTest {

    private final Integer base = Integer.valueOf(5);
    
    @Before
    public void setUp() throws Exception {
        ToStringBuilder.setDefaultStyle(ToStringStyle.SIMPLE_STYLE);
    }

    @After
    public void tearDown() throws Exception {
        ToStringBuilder.setDefaultStyle(ToStringStyle.DEFAULT_STYLE);
    }

    //----------------------------------------------------------------
    
@Test
public void testLong991() { 
     assertEquals("3", new ToStringBuilder(base).append(3L).toString()); 
     assertEquals("3", new ToStringBuilder(base).append("a", 3L).toString()); 
     assertEquals("3,4", new ToStringBuilder(base).append("a", 3L).append("b", 4L).toString()); 
 }
@Test
public void testLong2092() { 
     assertEquals("3", new ToStringBuilder(base).append(3L).toString()); 
     assertEquals("3", new ToStringBuilder(base).append("a", 3L).toString()); 
     assertEquals("3,4", new ToStringBuilder(base).append("a", 3L).append("b", 4L).toString()); 
 }
@Test
public void testLong2790() { 
     assertEquals("3", new ToStringBuilder(base).append(3L).toString()); 
     assertEquals("3", new ToStringBuilder(base).append("a", 3L).toString()); 
     assertEquals("3,4", new ToStringBuilder(base).append("a", 3L).append("b", 4L).toString()); 
 }
@Test
public void testLong3753() { 
     assertEquals("3", new ToStringBuilder(base).append(3L).toString()); 
     assertEquals("3", new ToStringBuilder(base).append("a", 3L).toString()); 
     assertEquals("3,4", new ToStringBuilder(base).append("a", 3L).append("b", 4L).toString()); 
 }
@Test
public void testLong3997() { 
     assertEquals("3", new ToStringBuilder(base).append(3L).toString()); 
     assertEquals("3", new ToStringBuilder(base).append("a", 3L).toString()); 
     assertEquals("3,4", new ToStringBuilder(base).append("a", 3L).append("b", 4L).toString()); 
 }
@Test
public void testLong8546() { 
     assertEquals("3", new ToStringBuilder(base).append(3L).toString()); 
     assertEquals("3", new ToStringBuilder(base).append("a", 3L).toString()); 
     assertEquals("3,4", new ToStringBuilder(base).append("a", 3L).append("b", 4L).toString()); 
 }
    

    
    
    

    

    

    

    

    

}
