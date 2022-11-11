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
 * Unit tests {@link org.apache.commons.lang3.builder.DefaultToStringStyleTest}.
 *
 * @version $Id$
 */
public class DefaultToStringStyleTest {

    private final Integer base = Integer.valueOf(5);
    private final String baseStr = base.getClass().getName() + "@" + Integer.toHexString(System.identityHashCode(base));
    
    @Before
    public void setUp() throws Exception {
        ToStringBuilder.setDefaultStyle(ToStringStyle.DEFAULT_STYLE);
    }

    @After
    public void tearDown() throws Exception {
        ToStringBuilder.setDefaultStyle(ToStringStyle.DEFAULT_STYLE);
    }

    //----------------------------------------------------------------
    
@Test
public void testPerson93() { 
     final Person p = new Person(); 
     p.name = "John Doe"; 
     p.age = 33; 
     p.smoker = false; 
     final String pBaseStr = p.getClass().getName() + "@" + Integer.toHexString(System.identityHashCode(p)); 
     assertEquals(pBaseStr + "[name=John Doe,age=33,smoker=false]", new ToStringBuilder(p).append("name", p.name).append("age", p.age).append("smoker", p.smoker).toString()); 
 }
@Test
public void testObject433() { 
     final Integer i3 = Integer.valueOf(3); 
     final Integer i4 = Integer.valueOf(4); 
     assertEquals(baseStr + "[<null>]", new ToStringBuilder(base).append((Object) null).toString()); 
     assertEquals(baseStr + "[3]", new ToStringBuilder(base).append(i3).toString()); 
     assertEquals(baseStr + "[a=<null>]", new ToStringBuilder(base).append("a", (Object) null).toString()); 
     assertEquals(baseStr + "[a=3]", new ToStringBuilder(base).append("a", i3).toString()); 
     assertEquals(baseStr + "[a=3,b=4]", new ToStringBuilder(base).append("a", i3).append("b", i4).toString()); 
     assertEquals(baseStr + "[a=<Integer>]", new ToStringBuilder(base).append("a", i3, false).toString()); 
     assertEquals(baseStr + "[a=<size=0>]", new ToStringBuilder(base).append("a", new ArrayList<Object>(), false).toString()); 
     assertEquals(baseStr + "[a=[]]", new ToStringBuilder(base).append("a", new ArrayList<Object>(), true).toString()); 
     assertEquals(baseStr + "[a=<size=0>]", new ToStringBuilder(base).append("a", new HashMap<Object, Object>(), false).toString()); 
     assertEquals(baseStr + "[a={}]", new ToStringBuilder(base).append("a", new HashMap<Object, Object>(), true).toString()); 
     assertEquals(baseStr + "[a=<size=0>]", new ToStringBuilder(base).append("a", (Object) new String[0], false).toString()); 
     assertEquals(baseStr + "[a={}]", new ToStringBuilder(base).append("a", (Object) new String[0], true).toString()); 
 }
@Test
public void testObject658() { 
     final Integer i3 = Integer.valueOf(3); 
     final Integer i4 = Integer.valueOf(4); 
     assertEquals(baseStr + "[<null>]", new ToStringBuilder(base).append((Object) null).toString()); 
     assertEquals(baseStr + "[3]", new ToStringBuilder(base).append(i3).toString()); 
     assertEquals(baseStr + "[a=<null>]", new ToStringBuilder(base).append("a", (Object) null).toString()); 
     assertEquals(baseStr + "[a=3]", new ToStringBuilder(base).append("a", i3).toString()); 
     assertEquals(baseStr + "[a=3,b=4]", new ToStringBuilder(base).append("a", i3).append("b", i4).toString()); 
     assertEquals(baseStr + "[a=<Integer>]", new ToStringBuilder(base).append("a", i3, false).toString()); 
     assertEquals(baseStr + "[a=<size=0>]", new ToStringBuilder(base).append("a", new ArrayList<Object>(), false).toString()); 
     assertEquals(baseStr + "[a=[]]", new ToStringBuilder(base).append("a", new ArrayList<Object>(), true).toString()); 
     assertEquals(baseStr + "[a=<size=0>]", new ToStringBuilder(base).append("a", new HashMap<Object, Object>(), false).toString()); 
     assertEquals(baseStr + "[a={}]", new ToStringBuilder(base).append("a", new HashMap<Object, Object>(), true).toString()); 
     assertEquals(baseStr + "[a=<size=0>]", new ToStringBuilder(base).append("a", (Object) new String[0], false).toString()); 
     assertEquals(baseStr + "[a={}]", new ToStringBuilder(base).append("a", (Object) new String[0], true).toString()); 
 }
@Test
public void testObject756() { 
     final Integer i3 = Integer.valueOf(3); 
     final Integer i4 = Integer.valueOf(4); 
     assertEquals(baseStr + "[<null>]", new ToStringBuilder(base).append((Object) null).toString()); 
     assertEquals(baseStr + "[3]", new ToStringBuilder(base).append(i3).toString()); 
     assertEquals(baseStr + "[a=<null>]", new ToStringBuilder(base).append("a", (Object) null).toString()); 
     assertEquals(baseStr + "[a=3]", new ToStringBuilder(base).append("a", i3).toString()); 
     assertEquals(baseStr + "[a=3,b=4]", new ToStringBuilder(base).append("a", i3).append("b", i4).toString()); 
     assertEquals(baseStr + "[a=<Integer>]", new ToStringBuilder(base).append("a", i3, false).toString()); 
     assertEquals(baseStr + "[a=<size=0>]", new ToStringBuilder(base).append("a", new ArrayList<Object>(), false).toString()); 
     assertEquals(baseStr + "[a=[]]", new ToStringBuilder(base).append("a", new ArrayList<Object>(), true).toString()); 
     assertEquals(baseStr + "[a=<size=0>]", new ToStringBuilder(base).append("a", new HashMap<Object, Object>(), false).toString()); 
     assertEquals(baseStr + "[a={}]", new ToStringBuilder(base).append("a", new HashMap<Object, Object>(), true).toString()); 
     assertEquals(baseStr + "[a=<size=0>]", new ToStringBuilder(base).append("a", (Object) new String[0], false).toString()); 
     assertEquals(baseStr + "[a={}]", new ToStringBuilder(base).append("a", (Object) new String[0], true).toString()); 
 }
@Test
public void testObject851() { 
     final Integer i3 = Integer.valueOf(3); 
     final Integer i4 = Integer.valueOf(4); 
     assertEquals(baseStr + "[<null>]", new ToStringBuilder(base).append((Object) null).toString()); 
     assertEquals(baseStr + "[3]", new ToStringBuilder(base).append(i3).toString()); 
     assertEquals(baseStr + "[a=<null>]", new ToStringBuilder(base).append("a", (Object) null).toString()); 
     assertEquals(baseStr + "[a=3]", new ToStringBuilder(base).append("a", i3).toString()); 
     assertEquals(baseStr + "[a=3,b=4]", new ToStringBuilder(base).append("a", i3).append("b", i4).toString()); 
     assertEquals(baseStr + "[a=<Integer>]", new ToStringBuilder(base).append("a", i3, false).toString()); 
     assertEquals(baseStr + "[a=<size=0>]", new ToStringBuilder(base).append("a", new ArrayList<Object>(), false).toString()); 
     assertEquals(baseStr + "[a=[]]", new ToStringBuilder(base).append("a", new ArrayList<Object>(), true).toString()); 
     assertEquals(baseStr + "[a=<size=0>]", new ToStringBuilder(base).append("a", new HashMap<Object, Object>(), false).toString()); 
     assertEquals(baseStr + "[a={}]", new ToStringBuilder(base).append("a", new HashMap<Object, Object>(), true).toString()); 
     assertEquals(baseStr + "[a=<size=0>]", new ToStringBuilder(base).append("a", (Object) new String[0], false).toString()); 
     assertEquals(baseStr + "[a={}]", new ToStringBuilder(base).append("a", (Object) new String[0], true).toString()); 
 }
@Test
public void testObject1570() { 
     final Integer i3 = Integer.valueOf(3); 
     final Integer i4 = Integer.valueOf(4); 
     assertEquals(baseStr + "[<null>]", new ToStringBuilder(base).append((Object) null).toString()); 
     assertEquals(baseStr + "[3]", new ToStringBuilder(base).append(i3).toString()); 
     assertEquals(baseStr + "[a=<null>]", new ToStringBuilder(base).append("a", (Object) null).toString()); 
     assertEquals(baseStr + "[a=3]", new ToStringBuilder(base).append("a", i3).toString()); 
     assertEquals(baseStr + "[a=3,b=4]", new ToStringBuilder(base).append("a", i3).append("b", i4).toString()); 
     assertEquals(baseStr + "[a=<Integer>]", new ToStringBuilder(base).append("a", i3, false).toString()); 
     assertEquals(baseStr + "[a=<size=0>]", new ToStringBuilder(base).append("a", new ArrayList<Object>(), false).toString()); 
     assertEquals(baseStr + "[a=[]]", new ToStringBuilder(base).append("a", new ArrayList<Object>(), true).toString()); 
     assertEquals(baseStr + "[a=<size=0>]", new ToStringBuilder(base).append("a", new HashMap<Object, Object>(), false).toString()); 
     assertEquals(baseStr + "[a={}]", new ToStringBuilder(base).append("a", new HashMap<Object, Object>(), true).toString()); 
     assertEquals(baseStr + "[a=<size=0>]", new ToStringBuilder(base).append("a", (Object) new String[0], false).toString()); 
     assertEquals(baseStr + "[a={}]", new ToStringBuilder(base).append("a", (Object) new String[0], true).toString()); 
 }
@Test
public void testPerson1783() { 
     final Person p = new Person(); 
     p.name = "John Doe"; 
     p.age = 33; 
     p.smoker = false; 
     final String pBaseStr = p.getClass().getName() + "@" + Integer.toHexString(System.identityHashCode(p)); 
     assertEquals(pBaseStr + "[name=John Doe,age=33,smoker=false]", new ToStringBuilder(p).append("name", p.name).append("age", p.age).append("smoker", p.smoker).toString()); 
 }
@Test
public void testObject2067() { 
     final Integer i3 = Integer.valueOf(3); 
     final Integer i4 = Integer.valueOf(4); 
     assertEquals(baseStr + "[<null>]", new ToStringBuilder(base).append((Object) null).toString()); 
     assertEquals(baseStr + "[3]", new ToStringBuilder(base).append(i3).toString()); 
     assertEquals(baseStr + "[a=<null>]", new ToStringBuilder(base).append("a", (Object) null).toString()); 
     assertEquals(baseStr + "[a=3]", new ToStringBuilder(base).append("a", i3).toString()); 
     assertEquals(baseStr + "[a=3,b=4]", new ToStringBuilder(base).append("a", i3).append("b", i4).toString()); 
     assertEquals(baseStr + "[a=<Integer>]", new ToStringBuilder(base).append("a", i3, false).toString()); 
     assertEquals(baseStr + "[a=<size=0>]", new ToStringBuilder(base).append("a", new ArrayList<Object>(), false).toString()); 
     assertEquals(baseStr + "[a=[]]", new ToStringBuilder(base).append("a", new ArrayList<Object>(), true).toString()); 
     assertEquals(baseStr + "[a=<size=0>]", new ToStringBuilder(base).append("a", new HashMap<Object, Object>(), false).toString()); 
     assertEquals(baseStr + "[a={}]", new ToStringBuilder(base).append("a", new HashMap<Object, Object>(), true).toString()); 
     assertEquals(baseStr + "[a=<size=0>]", new ToStringBuilder(base).append("a", (Object) new String[0], false).toString()); 
     assertEquals(baseStr + "[a={}]", new ToStringBuilder(base).append("a", (Object) new String[0], true).toString()); 
 }
@Test
public void testObject2364() { 
     final Integer i3 = Integer.valueOf(3); 
     final Integer i4 = Integer.valueOf(4); 
     assertEquals(baseStr + "[<null>]", new ToStringBuilder(base).append((Object) null).toString()); 
     assertEquals(baseStr + "[3]", new ToStringBuilder(base).append(i3).toString()); 
     assertEquals(baseStr + "[a=<null>]", new ToStringBuilder(base).append("a", (Object) null).toString()); 
     assertEquals(baseStr + "[a=3]", new ToStringBuilder(base).append("a", i3).toString()); 
     assertEquals(baseStr + "[a=3,b=4]", new ToStringBuilder(base).append("a", i3).append("b", i4).toString()); 
     assertEquals(baseStr + "[a=<Integer>]", new ToStringBuilder(base).append("a", i3, false).toString()); 
     assertEquals(baseStr + "[a=<size=0>]", new ToStringBuilder(base).append("a", new ArrayList<Object>(), false).toString()); 
     assertEquals(baseStr + "[a=[]]", new ToStringBuilder(base).append("a", new ArrayList<Object>(), true).toString()); 
     assertEquals(baseStr + "[a=<size=0>]", new ToStringBuilder(base).append("a", new HashMap<Object, Object>(), false).toString()); 
     assertEquals(baseStr + "[a={}]", new ToStringBuilder(base).append("a", new HashMap<Object, Object>(), true).toString()); 
     assertEquals(baseStr + "[a=<size=0>]", new ToStringBuilder(base).append("a", (Object) new String[0], false).toString()); 
     assertEquals(baseStr + "[a={}]", new ToStringBuilder(base).append("a", (Object) new String[0], true).toString()); 
 }
@Test
public void testPerson3220() { 
     final Person p = new Person(); 
     p.name = "John Doe"; 
     p.age = 33; 
     p.smoker = false; 
     final String pBaseStr = p.getClass().getName() + "@" + Integer.toHexString(System.identityHashCode(p)); 
     assertEquals(pBaseStr + "[name=John Doe,age=33,smoker=false]", new ToStringBuilder(p).append("name", p.name).append("age", p.age).append("smoker", p.smoker).toString()); 
 }
@Test
public void testObject3268() { 
     final Integer i3 = Integer.valueOf(3); 
     final Integer i4 = Integer.valueOf(4); 
     assertEquals(baseStr + "[<null>]", new ToStringBuilder(base).append((Object) null).toString()); 
     assertEquals(baseStr + "[3]", new ToStringBuilder(base).append(i3).toString()); 
     assertEquals(baseStr + "[a=<null>]", new ToStringBuilder(base).append("a", (Object) null).toString()); 
     assertEquals(baseStr + "[a=3]", new ToStringBuilder(base).append("a", i3).toString()); 
     assertEquals(baseStr + "[a=3,b=4]", new ToStringBuilder(base).append("a", i3).append("b", i4).toString()); 
     assertEquals(baseStr + "[a=<Integer>]", new ToStringBuilder(base).append("a", i3, false).toString()); 
     assertEquals(baseStr + "[a=<size=0>]", new ToStringBuilder(base).append("a", new ArrayList<Object>(), false).toString()); 
     assertEquals(baseStr + "[a=[]]", new ToStringBuilder(base).append("a", new ArrayList<Object>(), true).toString()); 
     assertEquals(baseStr + "[a=<size=0>]", new ToStringBuilder(base).append("a", new HashMap<Object, Object>(), false).toString()); 
     assertEquals(baseStr + "[a={}]", new ToStringBuilder(base).append("a", new HashMap<Object, Object>(), true).toString()); 
     assertEquals(baseStr + "[a=<size=0>]", new ToStringBuilder(base).append("a", (Object) new String[0], false).toString()); 
     assertEquals(baseStr + "[a={}]", new ToStringBuilder(base).append("a", (Object) new String[0], true).toString()); 
 }
@Test
public void testObject3454() { 
     final Integer i3 = Integer.valueOf(3); 
     final Integer i4 = Integer.valueOf(4); 
     assertEquals(baseStr + "[<null>]", new ToStringBuilder(base).append((Object) null).toString()); 
     assertEquals(baseStr + "[3]", new ToStringBuilder(base).append(i3).toString()); 
     assertEquals(baseStr + "[a=<null>]", new ToStringBuilder(base).append("a", (Object) null).toString()); 
     assertEquals(baseStr + "[a=3]", new ToStringBuilder(base).append("a", i3).toString()); 
     assertEquals(baseStr + "[a=3,b=4]", new ToStringBuilder(base).append("a", i3).append("b", i4).toString()); 
     assertEquals(baseStr + "[a=<Integer>]", new ToStringBuilder(base).append("a", i3, false).toString()); 
     assertEquals(baseStr + "[a=<size=0>]", new ToStringBuilder(base).append("a", new ArrayList<Object>(), false).toString()); 
     assertEquals(baseStr + "[a=[]]", new ToStringBuilder(base).append("a", new ArrayList<Object>(), true).toString()); 
     assertEquals(baseStr + "[a=<size=0>]", new ToStringBuilder(base).append("a", new HashMap<Object, Object>(), false).toString()); 
     assertEquals(baseStr + "[a={}]", new ToStringBuilder(base).append("a", new HashMap<Object, Object>(), true).toString()); 
     assertEquals(baseStr + "[a=<size=0>]", new ToStringBuilder(base).append("a", (Object) new String[0], false).toString()); 
     assertEquals(baseStr + "[a={}]", new ToStringBuilder(base).append("a", (Object) new String[0], true).toString()); 
 }
@Test
public void testObject3507() { 
     final Integer i3 = Integer.valueOf(3); 
     final Integer i4 = Integer.valueOf(4); 
     assertEquals(baseStr + "[<null>]", new ToStringBuilder(base).append((Object) null).toString()); 
     assertEquals(baseStr + "[3]", new ToStringBuilder(base).append(i3).toString()); 
     assertEquals(baseStr + "[a=<null>]", new ToStringBuilder(base).append("a", (Object) null).toString()); 
     assertEquals(baseStr + "[a=3]", new ToStringBuilder(base).append("a", i3).toString()); 
     assertEquals(baseStr + "[a=3,b=4]", new ToStringBuilder(base).append("a", i3).append("b", i4).toString()); 
     assertEquals(baseStr + "[a=<Integer>]", new ToStringBuilder(base).append("a", i3, false).toString()); 
     assertEquals(baseStr + "[a=<size=0>]", new ToStringBuilder(base).append("a", new ArrayList<Object>(), false).toString()); 
     assertEquals(baseStr + "[a=[]]", new ToStringBuilder(base).append("a", new ArrayList<Object>(), true).toString()); 
     assertEquals(baseStr + "[a=<size=0>]", new ToStringBuilder(base).append("a", new HashMap<Object, Object>(), false).toString()); 
     assertEquals(baseStr + "[a={}]", new ToStringBuilder(base).append("a", new HashMap<Object, Object>(), true).toString()); 
     assertEquals(baseStr + "[a=<size=0>]", new ToStringBuilder(base).append("a", (Object) new String[0], false).toString()); 
     assertEquals(baseStr + "[a={}]", new ToStringBuilder(base).append("a", (Object) new String[0], true).toString()); 
 }
@Test
public void testObject3702() { 
     final Integer i3 = Integer.valueOf(3); 
     final Integer i4 = Integer.valueOf(4); 
     assertEquals(baseStr + "[<null>]", new ToStringBuilder(base).append((Object) null).toString()); 
     assertEquals(baseStr + "[3]", new ToStringBuilder(base).append(i3).toString()); 
     assertEquals(baseStr + "[a=<null>]", new ToStringBuilder(base).append("a", (Object) null).toString()); 
     assertEquals(baseStr + "[a=3]", new ToStringBuilder(base).append("a", i3).toString()); 
     assertEquals(baseStr + "[a=3,b=4]", new ToStringBuilder(base).append("a", i3).append("b", i4).toString()); 
     assertEquals(baseStr + "[a=<Integer>]", new ToStringBuilder(base).append("a", i3, false).toString()); 
     assertEquals(baseStr + "[a=<size=0>]", new ToStringBuilder(base).append("a", new ArrayList<Object>(), false).toString()); 
     assertEquals(baseStr + "[a=[]]", new ToStringBuilder(base).append("a", new ArrayList<Object>(), true).toString()); 
     assertEquals(baseStr + "[a=<size=0>]", new ToStringBuilder(base).append("a", new HashMap<Object, Object>(), false).toString()); 
     assertEquals(baseStr + "[a={}]", new ToStringBuilder(base).append("a", new HashMap<Object, Object>(), true).toString()); 
     assertEquals(baseStr + "[a=<size=0>]", new ToStringBuilder(base).append("a", (Object) new String[0], false).toString()); 
     assertEquals(baseStr + "[a={}]", new ToStringBuilder(base).append("a", (Object) new String[0], true).toString()); 
 }
@Test
public void testPerson4050() { 
     final Person p = new Person(); 
     p.name = "John Doe"; 
     p.age = 33; 
     p.smoker = false; 
     final String pBaseStr = p.getClass().getName() + "@" + Integer.toHexString(System.identityHashCode(p)); 
     assertEquals(pBaseStr + "[name=John Doe,age=33,smoker=false]", new ToStringBuilder(p).append("name", p.name).append("age", p.age).append("smoker", p.smoker).toString()); 
 }
@Test
public void testObject4250() { 
     final Integer i3 = Integer.valueOf(3); 
     final Integer i4 = Integer.valueOf(4); 
     assertEquals(baseStr + "[<null>]", new ToStringBuilder(base).append((Object) null).toString()); 
     assertEquals(baseStr + "[3]", new ToStringBuilder(base).append(i3).toString()); 
     assertEquals(baseStr + "[a=<null>]", new ToStringBuilder(base).append("a", (Object) null).toString()); 
     assertEquals(baseStr + "[a=3]", new ToStringBuilder(base).append("a", i3).toString()); 
     assertEquals(baseStr + "[a=3,b=4]", new ToStringBuilder(base).append("a", i3).append("b", i4).toString()); 
     assertEquals(baseStr + "[a=<Integer>]", new ToStringBuilder(base).append("a", i3, false).toString()); 
     assertEquals(baseStr + "[a=<size=0>]", new ToStringBuilder(base).append("a", new ArrayList<Object>(), false).toString()); 
     assertEquals(baseStr + "[a=[]]", new ToStringBuilder(base).append("a", new ArrayList<Object>(), true).toString()); 
     assertEquals(baseStr + "[a=<size=0>]", new ToStringBuilder(base).append("a", new HashMap<Object, Object>(), false).toString()); 
     assertEquals(baseStr + "[a={}]", new ToStringBuilder(base).append("a", new HashMap<Object, Object>(), true).toString()); 
     assertEquals(baseStr + "[a=<size=0>]", new ToStringBuilder(base).append("a", (Object) new String[0], false).toString()); 
     assertEquals(baseStr + "[a={}]", new ToStringBuilder(base).append("a", (Object) new String[0], true).toString()); 
 }
@Test
public void testObject4325() { 
     final Integer i3 = Integer.valueOf(3); 
     final Integer i4 = Integer.valueOf(4); 
     assertEquals(baseStr + "[<null>]", new ToStringBuilder(base).append((Object) null).toString()); 
     assertEquals(baseStr + "[3]", new ToStringBuilder(base).append(i3).toString()); 
     assertEquals(baseStr + "[a=<null>]", new ToStringBuilder(base).append("a", (Object) null).toString()); 
     assertEquals(baseStr + "[a=3]", new ToStringBuilder(base).append("a", i3).toString()); 
     assertEquals(baseStr + "[a=3,b=4]", new ToStringBuilder(base).append("a", i3).append("b", i4).toString()); 
     assertEquals(baseStr + "[a=<Integer>]", new ToStringBuilder(base).append("a", i3, false).toString()); 
     assertEquals(baseStr + "[a=<size=0>]", new ToStringBuilder(base).append("a", new ArrayList<Object>(), false).toString()); 
     assertEquals(baseStr + "[a=[]]", new ToStringBuilder(base).append("a", new ArrayList<Object>(), true).toString()); 
     assertEquals(baseStr + "[a=<size=0>]", new ToStringBuilder(base).append("a", new HashMap<Object, Object>(), false).toString()); 
     assertEquals(baseStr + "[a={}]", new ToStringBuilder(base).append("a", new HashMap<Object, Object>(), true).toString()); 
     assertEquals(baseStr + "[a=<size=0>]", new ToStringBuilder(base).append("a", (Object) new String[0], false).toString()); 
     assertEquals(baseStr + "[a={}]", new ToStringBuilder(base).append("a", (Object) new String[0], true).toString()); 
 }
@Test
public void testObject4764() { 
     final Integer i3 = Integer.valueOf(3); 
     final Integer i4 = Integer.valueOf(4); 
     assertEquals(baseStr + "[<null>]", new ToStringBuilder(base).append((Object) null).toString()); 
     assertEquals(baseStr + "[3]", new ToStringBuilder(base).append(i3).toString()); 
     assertEquals(baseStr + "[a=<null>]", new ToStringBuilder(base).append("a", (Object) null).toString()); 
     assertEquals(baseStr + "[a=3]", new ToStringBuilder(base).append("a", i3).toString()); 
     assertEquals(baseStr + "[a=3,b=4]", new ToStringBuilder(base).append("a", i3).append("b", i4).toString()); 
     assertEquals(baseStr + "[a=<Integer>]", new ToStringBuilder(base).append("a", i3, false).toString()); 
     assertEquals(baseStr + "[a=<size=0>]", new ToStringBuilder(base).append("a", new ArrayList<Object>(), false).toString()); 
     assertEquals(baseStr + "[a=[]]", new ToStringBuilder(base).append("a", new ArrayList<Object>(), true).toString()); 
     assertEquals(baseStr + "[a=<size=0>]", new ToStringBuilder(base).append("a", new HashMap<Object, Object>(), false).toString()); 
     assertEquals(baseStr + "[a={}]", new ToStringBuilder(base).append("a", new HashMap<Object, Object>(), true).toString()); 
     assertEquals(baseStr + "[a=<size=0>]", new ToStringBuilder(base).append("a", (Object) new String[0], false).toString()); 
     assertEquals(baseStr + "[a={}]", new ToStringBuilder(base).append("a", (Object) new String[0], true).toString()); 
 }
@Test
public void testPerson4967() { 
     final Person p = new Person(); 
     p.name = "John Doe"; 
     p.age = 33; 
     p.smoker = false; 
     final String pBaseStr = p.getClass().getName() + "@" + Integer.toHexString(System.identityHashCode(p)); 
     assertEquals(pBaseStr + "[name=John Doe,age=33,smoker=false]", new ToStringBuilder(p).append("name", p.name).append("age", p.age).append("smoker", p.smoker).toString()); 
 }
@Test
public void testObject5208() { 
     final Integer i3 = Integer.valueOf(3); 
     final Integer i4 = Integer.valueOf(4); 
     assertEquals(baseStr + "[<null>]", new ToStringBuilder(base).append((Object) null).toString()); 
     assertEquals(baseStr + "[3]", new ToStringBuilder(base).append(i3).toString()); 
     assertEquals(baseStr + "[a=<null>]", new ToStringBuilder(base).append("a", (Object) null).toString()); 
     assertEquals(baseStr + "[a=3]", new ToStringBuilder(base).append("a", i3).toString()); 
     assertEquals(baseStr + "[a=3,b=4]", new ToStringBuilder(base).append("a", i3).append("b", i4).toString()); 
     assertEquals(baseStr + "[a=<Integer>]", new ToStringBuilder(base).append("a", i3, false).toString()); 
     assertEquals(baseStr + "[a=<size=0>]", new ToStringBuilder(base).append("a", new ArrayList<Object>(), false).toString()); 
     assertEquals(baseStr + "[a=[]]", new ToStringBuilder(base).append("a", new ArrayList<Object>(), true).toString()); 
     assertEquals(baseStr + "[a=<size=0>]", new ToStringBuilder(base).append("a", new HashMap<Object, Object>(), false).toString()); 
     assertEquals(baseStr + "[a={}]", new ToStringBuilder(base).append("a", new HashMap<Object, Object>(), true).toString()); 
     assertEquals(baseStr + "[a=<size=0>]", new ToStringBuilder(base).append("a", (Object) new String[0], false).toString()); 
     assertEquals(baseStr + "[a={}]", new ToStringBuilder(base).append("a", (Object) new String[0], true).toString()); 
 }
@Test
public void testObject5466() { 
     final Integer i3 = Integer.valueOf(3); 
     final Integer i4 = Integer.valueOf(4); 
     assertEquals(baseStr + "[<null>]", new ToStringBuilder(base).append((Object) null).toString()); 
     assertEquals(baseStr + "[3]", new ToStringBuilder(base).append(i3).toString()); 
     assertEquals(baseStr + "[a=<null>]", new ToStringBuilder(base).append("a", (Object) null).toString()); 
     assertEquals(baseStr + "[a=3]", new ToStringBuilder(base).append("a", i3).toString()); 
     assertEquals(baseStr + "[a=3,b=4]", new ToStringBuilder(base).append("a", i3).append("b", i4).toString()); 
     assertEquals(baseStr + "[a=<Integer>]", new ToStringBuilder(base).append("a", i3, false).toString()); 
     assertEquals(baseStr + "[a=<size=0>]", new ToStringBuilder(base).append("a", new ArrayList<Object>(), false).toString()); 
     assertEquals(baseStr + "[a=[]]", new ToStringBuilder(base).append("a", new ArrayList<Object>(), true).toString()); 
     assertEquals(baseStr + "[a=<size=0>]", new ToStringBuilder(base).append("a", new HashMap<Object, Object>(), false).toString()); 
     assertEquals(baseStr + "[a={}]", new ToStringBuilder(base).append("a", new HashMap<Object, Object>(), true).toString()); 
     assertEquals(baseStr + "[a=<size=0>]", new ToStringBuilder(base).append("a", (Object) new String[0], false).toString()); 
     assertEquals(baseStr + "[a={}]", new ToStringBuilder(base).append("a", (Object) new String[0], true).toString()); 
 }
@Test
public void testObject5539() { 
     final Integer i3 = Integer.valueOf(3); 
     final Integer i4 = Integer.valueOf(4); 
     assertEquals(baseStr + "[<null>]", new ToStringBuilder(base).append((Object) null).toString()); 
     assertEquals(baseStr + "[3]", new ToStringBuilder(base).append(i3).toString()); 
     assertEquals(baseStr + "[a=<null>]", new ToStringBuilder(base).append("a", (Object) null).toString()); 
     assertEquals(baseStr + "[a=3]", new ToStringBuilder(base).append("a", i3).toString()); 
     assertEquals(baseStr + "[a=3,b=4]", new ToStringBuilder(base).append("a", i3).append("b", i4).toString()); 
     assertEquals(baseStr + "[a=<Integer>]", new ToStringBuilder(base).append("a", i3, false).toString()); 
     assertEquals(baseStr + "[a=<size=0>]", new ToStringBuilder(base).append("a", new ArrayList<Object>(), false).toString()); 
     assertEquals(baseStr + "[a=[]]", new ToStringBuilder(base).append("a", new ArrayList<Object>(), true).toString()); 
     assertEquals(baseStr + "[a=<size=0>]", new ToStringBuilder(base).append("a", new HashMap<Object, Object>(), false).toString()); 
     assertEquals(baseStr + "[a={}]", new ToStringBuilder(base).append("a", new HashMap<Object, Object>(), true).toString()); 
     assertEquals(baseStr + "[a=<size=0>]", new ToStringBuilder(base).append("a", (Object) new String[0], false).toString()); 
     assertEquals(baseStr + "[a={}]", new ToStringBuilder(base).append("a", (Object) new String[0], true).toString()); 
 }
@Test
public void testPerson5580() { 
     final Person p = new Person(); 
     p.name = "John Doe"; 
     p.age = 33; 
     p.smoker = false; 
     final String pBaseStr = p.getClass().getName() + "@" + Integer.toHexString(System.identityHashCode(p)); 
     assertEquals(pBaseStr + "[name=John Doe,age=33,smoker=false]", new ToStringBuilder(p).append("name", p.name).append("age", p.age).append("smoker", p.smoker).toString()); 
 }
@Test
public void testPerson5637() { 
     final Person p = new Person(); 
     p.name = "John Doe"; 
     p.age = 33; 
     p.smoker = false; 
     final String pBaseStr = p.getClass().getName() + "@" + Integer.toHexString(System.identityHashCode(p)); 
     assertEquals(pBaseStr + "[name=John Doe,age=33,smoker=false]", new ToStringBuilder(p).append("name", p.name).append("age", p.age).append("smoker", p.smoker).toString()); 
 }
@Test
public void testObject6024() { 
     final Integer i3 = Integer.valueOf(3); 
     final Integer i4 = Integer.valueOf(4); 
     assertEquals(baseStr + "[<null>]", new ToStringBuilder(base).append((Object) null).toString()); 
     assertEquals(baseStr + "[3]", new ToStringBuilder(base).append(i3).toString()); 
     assertEquals(baseStr + "[a=<null>]", new ToStringBuilder(base).append("a", (Object) null).toString()); 
     assertEquals(baseStr + "[a=3]", new ToStringBuilder(base).append("a", i3).toString()); 
     assertEquals(baseStr + "[a=3,b=4]", new ToStringBuilder(base).append("a", i3).append("b", i4).toString()); 
     assertEquals(baseStr + "[a=<Integer>]", new ToStringBuilder(base).append("a", i3, false).toString()); 
     assertEquals(baseStr + "[a=<size=0>]", new ToStringBuilder(base).append("a", new ArrayList<Object>(), false).toString()); 
     assertEquals(baseStr + "[a=[]]", new ToStringBuilder(base).append("a", new ArrayList<Object>(), true).toString()); 
     assertEquals(baseStr + "[a=<size=0>]", new ToStringBuilder(base).append("a", new HashMap<Object, Object>(), false).toString()); 
     assertEquals(baseStr + "[a={}]", new ToStringBuilder(base).append("a", new HashMap<Object, Object>(), true).toString()); 
     assertEquals(baseStr + "[a=<size=0>]", new ToStringBuilder(base).append("a", (Object) new String[0], false).toString()); 
     assertEquals(baseStr + "[a={}]", new ToStringBuilder(base).append("a", (Object) new String[0], true).toString()); 
 }
@Test
public void testObject7096() { 
     final Integer i3 = Integer.valueOf(3); 
     final Integer i4 = Integer.valueOf(4); 
     assertEquals(baseStr + "[<null>]", new ToStringBuilder(base).append((Object) null).toString()); 
     assertEquals(baseStr + "[3]", new ToStringBuilder(base).append(i3).toString()); 
     assertEquals(baseStr + "[a=<null>]", new ToStringBuilder(base).append("a", (Object) null).toString()); 
     assertEquals(baseStr + "[a=3]", new ToStringBuilder(base).append("a", i3).toString()); 
     assertEquals(baseStr + "[a=3,b=4]", new ToStringBuilder(base).append("a", i3).append("b", i4).toString()); 
     assertEquals(baseStr + "[a=<Integer>]", new ToStringBuilder(base).append("a", i3, false).toString()); 
     assertEquals(baseStr + "[a=<size=0>]", new ToStringBuilder(base).append("a", new ArrayList<Object>(), false).toString()); 
     assertEquals(baseStr + "[a=[]]", new ToStringBuilder(base).append("a", new ArrayList<Object>(), true).toString()); 
     assertEquals(baseStr + "[a=<size=0>]", new ToStringBuilder(base).append("a", new HashMap<Object, Object>(), false).toString()); 
     assertEquals(baseStr + "[a={}]", new ToStringBuilder(base).append("a", new HashMap<Object, Object>(), true).toString()); 
     assertEquals(baseStr + "[a=<size=0>]", new ToStringBuilder(base).append("a", (Object) new String[0], false).toString()); 
     assertEquals(baseStr + "[a={}]", new ToStringBuilder(base).append("a", (Object) new String[0], true).toString()); 
 }
@Test
public void testObject7117() { 
     final Integer i3 = Integer.valueOf(3); 
     final Integer i4 = Integer.valueOf(4); 
     assertEquals(baseStr + "[<null>]", new ToStringBuilder(base).append((Object) null).toString()); 
     assertEquals(baseStr + "[3]", new ToStringBuilder(base).append(i3).toString()); 
     assertEquals(baseStr + "[a=<null>]", new ToStringBuilder(base).append("a", (Object) null).toString()); 
     assertEquals(baseStr + "[a=3]", new ToStringBuilder(base).append("a", i3).toString()); 
     assertEquals(baseStr + "[a=3,b=4]", new ToStringBuilder(base).append("a", i3).append("b", i4).toString()); 
     assertEquals(baseStr + "[a=<Integer>]", new ToStringBuilder(base).append("a", i3, false).toString()); 
     assertEquals(baseStr + "[a=<size=0>]", new ToStringBuilder(base).append("a", new ArrayList<Object>(), false).toString()); 
     assertEquals(baseStr + "[a=[]]", new ToStringBuilder(base).append("a", new ArrayList<Object>(), true).toString()); 
     assertEquals(baseStr + "[a=<size=0>]", new ToStringBuilder(base).append("a", new HashMap<Object, Object>(), false).toString()); 
     assertEquals(baseStr + "[a={}]", new ToStringBuilder(base).append("a", new HashMap<Object, Object>(), true).toString()); 
     assertEquals(baseStr + "[a=<size=0>]", new ToStringBuilder(base).append("a", (Object) new String[0], false).toString()); 
     assertEquals(baseStr + "[a={}]", new ToStringBuilder(base).append("a", (Object) new String[0], true).toString()); 
 }
@Test
public void testObject7420() { 
     final Integer i3 = Integer.valueOf(3); 
     final Integer i4 = Integer.valueOf(4); 
     assertEquals(baseStr + "[<null>]", new ToStringBuilder(base).append((Object) null).toString()); 
     assertEquals(baseStr + "[3]", new ToStringBuilder(base).append(i3).toString()); 
     assertEquals(baseStr + "[a=<null>]", new ToStringBuilder(base).append("a", (Object) null).toString()); 
     assertEquals(baseStr + "[a=3]", new ToStringBuilder(base).append("a", i3).toString()); 
     assertEquals(baseStr + "[a=3,b=4]", new ToStringBuilder(base).append("a", i3).append("b", i4).toString()); 
     assertEquals(baseStr + "[a=<Integer>]", new ToStringBuilder(base).append("a", i3, false).toString()); 
     assertEquals(baseStr + "[a=<size=0>]", new ToStringBuilder(base).append("a", new ArrayList<Object>(), false).toString()); 
     assertEquals(baseStr + "[a=[]]", new ToStringBuilder(base).append("a", new ArrayList<Object>(), true).toString()); 
     assertEquals(baseStr + "[a=<size=0>]", new ToStringBuilder(base).append("a", new HashMap<Object, Object>(), false).toString()); 
     assertEquals(baseStr + "[a={}]", new ToStringBuilder(base).append("a", new HashMap<Object, Object>(), true).toString()); 
     assertEquals(baseStr + "[a=<size=0>]", new ToStringBuilder(base).append("a", (Object) new String[0], false).toString()); 
     assertEquals(baseStr + "[a={}]", new ToStringBuilder(base).append("a", (Object) new String[0], true).toString()); 
 }
@Test
public void testPerson7470() { 
     final Person p = new Person(); 
     p.name = "John Doe"; 
     p.age = 33; 
     p.smoker = false; 
     final String pBaseStr = p.getClass().getName() + "@" + Integer.toHexString(System.identityHashCode(p)); 
     assertEquals(pBaseStr + "[name=John Doe,age=33,smoker=false]", new ToStringBuilder(p).append("name", p.name).append("age", p.age).append("smoker", p.smoker).toString()); 
 }
@Test
public void testObject7756() { 
     final Integer i3 = Integer.valueOf(3); 
     final Integer i4 = Integer.valueOf(4); 
     assertEquals(baseStr + "[<null>]", new ToStringBuilder(base).append((Object) null).toString()); 
     assertEquals(baseStr + "[3]", new ToStringBuilder(base).append(i3).toString()); 
     assertEquals(baseStr + "[a=<null>]", new ToStringBuilder(base).append("a", (Object) null).toString()); 
     assertEquals(baseStr + "[a=3]", new ToStringBuilder(base).append("a", i3).toString()); 
     assertEquals(baseStr + "[a=3,b=4]", new ToStringBuilder(base).append("a", i3).append("b", i4).toString()); 
     assertEquals(baseStr + "[a=<Integer>]", new ToStringBuilder(base).append("a", i3, false).toString()); 
     assertEquals(baseStr + "[a=<size=0>]", new ToStringBuilder(base).append("a", new ArrayList<Object>(), false).toString()); 
     assertEquals(baseStr + "[a=[]]", new ToStringBuilder(base).append("a", new ArrayList<Object>(), true).toString()); 
     assertEquals(baseStr + "[a=<size=0>]", new ToStringBuilder(base).append("a", new HashMap<Object, Object>(), false).toString()); 
     assertEquals(baseStr + "[a={}]", new ToStringBuilder(base).append("a", new HashMap<Object, Object>(), true).toString()); 
     assertEquals(baseStr + "[a=<size=0>]", new ToStringBuilder(base).append("a", (Object) new String[0], false).toString()); 
     assertEquals(baseStr + "[a={}]", new ToStringBuilder(base).append("a", (Object) new String[0], true).toString()); 
 }
@Test
public void testObject8168() { 
     final Integer i3 = Integer.valueOf(3); 
     final Integer i4 = Integer.valueOf(4); 
     assertEquals(baseStr + "[<null>]", new ToStringBuilder(base).append((Object) null).toString()); 
     assertEquals(baseStr + "[3]", new ToStringBuilder(base).append(i3).toString()); 
     assertEquals(baseStr + "[a=<null>]", new ToStringBuilder(base).append("a", (Object) null).toString()); 
     assertEquals(baseStr + "[a=3]", new ToStringBuilder(base).append("a", i3).toString()); 
     assertEquals(baseStr + "[a=3,b=4]", new ToStringBuilder(base).append("a", i3).append("b", i4).toString()); 
     assertEquals(baseStr + "[a=<Integer>]", new ToStringBuilder(base).append("a", i3, false).toString()); 
     assertEquals(baseStr + "[a=<size=0>]", new ToStringBuilder(base).append("a", new ArrayList<Object>(), false).toString()); 
     assertEquals(baseStr + "[a=[]]", new ToStringBuilder(base).append("a", new ArrayList<Object>(), true).toString()); 
     assertEquals(baseStr + "[a=<size=0>]", new ToStringBuilder(base).append("a", new HashMap<Object, Object>(), false).toString()); 
     assertEquals(baseStr + "[a={}]", new ToStringBuilder(base).append("a", new HashMap<Object, Object>(), true).toString()); 
     assertEquals(baseStr + "[a=<size=0>]", new ToStringBuilder(base).append("a", (Object) new String[0], false).toString()); 
     assertEquals(baseStr + "[a={}]", new ToStringBuilder(base).append("a", (Object) new String[0], true).toString()); 
 }
@Test
public void testObject8321() { 
     final Integer i3 = Integer.valueOf(3); 
     final Integer i4 = Integer.valueOf(4); 
     assertEquals(baseStr + "[<null>]", new ToStringBuilder(base).append((Object) null).toString()); 
     assertEquals(baseStr + "[3]", new ToStringBuilder(base).append(i3).toString()); 
     assertEquals(baseStr + "[a=<null>]", new ToStringBuilder(base).append("a", (Object) null).toString()); 
     assertEquals(baseStr + "[a=3]", new ToStringBuilder(base).append("a", i3).toString()); 
     assertEquals(baseStr + "[a=3,b=4]", new ToStringBuilder(base).append("a", i3).append("b", i4).toString()); 
     assertEquals(baseStr + "[a=<Integer>]", new ToStringBuilder(base).append("a", i3, false).toString()); 
     assertEquals(baseStr + "[a=<size=0>]", new ToStringBuilder(base).append("a", new ArrayList<Object>(), false).toString()); 
     assertEquals(baseStr + "[a=[]]", new ToStringBuilder(base).append("a", new ArrayList<Object>(), true).toString()); 
     assertEquals(baseStr + "[a=<size=0>]", new ToStringBuilder(base).append("a", new HashMap<Object, Object>(), false).toString()); 
     assertEquals(baseStr + "[a={}]", new ToStringBuilder(base).append("a", new HashMap<Object, Object>(), true).toString()); 
     assertEquals(baseStr + "[a=<size=0>]", new ToStringBuilder(base).append("a", (Object) new String[0], false).toString()); 
     assertEquals(baseStr + "[a={}]", new ToStringBuilder(base).append("a", (Object) new String[0], true).toString()); 
 }
@Test
public void testObject8633() { 
     final Integer i3 = Integer.valueOf(3); 
     final Integer i4 = Integer.valueOf(4); 
     assertEquals(baseStr + "[<null>]", new ToStringBuilder(base).append((Object) null).toString()); 
     assertEquals(baseStr + "[3]", new ToStringBuilder(base).append(i3).toString()); 
     assertEquals(baseStr + "[a=<null>]", new ToStringBuilder(base).append("a", (Object) null).toString()); 
     assertEquals(baseStr + "[a=3]", new ToStringBuilder(base).append("a", i3).toString()); 
     assertEquals(baseStr + "[a=3,b=4]", new ToStringBuilder(base).append("a", i3).append("b", i4).toString()); 
     assertEquals(baseStr + "[a=<Integer>]", new ToStringBuilder(base).append("a", i3, false).toString()); 
     assertEquals(baseStr + "[a=<size=0>]", new ToStringBuilder(base).append("a", new ArrayList<Object>(), false).toString()); 
     assertEquals(baseStr + "[a=[]]", new ToStringBuilder(base).append("a", new ArrayList<Object>(), true).toString()); 
     assertEquals(baseStr + "[a=<size=0>]", new ToStringBuilder(base).append("a", new HashMap<Object, Object>(), false).toString()); 
     assertEquals(baseStr + "[a={}]", new ToStringBuilder(base).append("a", new HashMap<Object, Object>(), true).toString()); 
     assertEquals(baseStr + "[a=<size=0>]", new ToStringBuilder(base).append("a", (Object) new String[0], false).toString()); 
     assertEquals(baseStr + "[a={}]", new ToStringBuilder(base).append("a", (Object) new String[0], true).toString()); 
 }
@Test
public void testObject9117() { 
     final Integer i3 = Integer.valueOf(3); 
     final Integer i4 = Integer.valueOf(4); 
     assertEquals(baseStr + "[<null>]", new ToStringBuilder(base).append((Object) null).toString()); 
     assertEquals(baseStr + "[3]", new ToStringBuilder(base).append(i3).toString()); 
     assertEquals(baseStr + "[a=<null>]", new ToStringBuilder(base).append("a", (Object) null).toString()); 
     assertEquals(baseStr + "[a=3]", new ToStringBuilder(base).append("a", i3).toString()); 
     assertEquals(baseStr + "[a=3,b=4]", new ToStringBuilder(base).append("a", i3).append("b", i4).toString()); 
     assertEquals(baseStr + "[a=<Integer>]", new ToStringBuilder(base).append("a", i3, false).toString()); 
     assertEquals(baseStr + "[a=<size=0>]", new ToStringBuilder(base).append("a", new ArrayList<Object>(), false).toString()); 
     assertEquals(baseStr + "[a=[]]", new ToStringBuilder(base).append("a", new ArrayList<Object>(), true).toString()); 
     assertEquals(baseStr + "[a=<size=0>]", new ToStringBuilder(base).append("a", new HashMap<Object, Object>(), false).toString()); 
     assertEquals(baseStr + "[a={}]", new ToStringBuilder(base).append("a", new HashMap<Object, Object>(), true).toString()); 
     assertEquals(baseStr + "[a=<size=0>]", new ToStringBuilder(base).append("a", (Object) new String[0], false).toString()); 
     assertEquals(baseStr + "[a={}]", new ToStringBuilder(base).append("a", (Object) new String[0], true).toString()); 
 }
@Test
public void testObject9203() { 
     final Integer i3 = Integer.valueOf(3); 
     final Integer i4 = Integer.valueOf(4); 
     assertEquals(baseStr + "[<null>]", new ToStringBuilder(base).append((Object) null).toString()); 
     assertEquals(baseStr + "[3]", new ToStringBuilder(base).append(i3).toString()); 
     assertEquals(baseStr + "[a=<null>]", new ToStringBuilder(base).append("a", (Object) null).toString()); 
     assertEquals(baseStr + "[a=3]", new ToStringBuilder(base).append("a", i3).toString()); 
     assertEquals(baseStr + "[a=3,b=4]", new ToStringBuilder(base).append("a", i3).append("b", i4).toString()); 
     assertEquals(baseStr + "[a=<Integer>]", new ToStringBuilder(base).append("a", i3, false).toString()); 
     assertEquals(baseStr + "[a=<size=0>]", new ToStringBuilder(base).append("a", new ArrayList<Object>(), false).toString()); 
     assertEquals(baseStr + "[a=[]]", new ToStringBuilder(base).append("a", new ArrayList<Object>(), true).toString()); 
     assertEquals(baseStr + "[a=<size=0>]", new ToStringBuilder(base).append("a", new HashMap<Object, Object>(), false).toString()); 
     assertEquals(baseStr + "[a={}]", new ToStringBuilder(base).append("a", new HashMap<Object, Object>(), true).toString()); 
     assertEquals(baseStr + "[a=<size=0>]", new ToStringBuilder(base).append("a", (Object) new String[0], false).toString()); 
     assertEquals(baseStr + "[a={}]", new ToStringBuilder(base).append("a", (Object) new String[0], true).toString()); 
 }
@Test
public void testPerson9214() { 
     final Person p = new Person(); 
     p.name = "John Doe"; 
     p.age = 33; 
     p.smoker = false; 
     final String pBaseStr = p.getClass().getName() + "@" + Integer.toHexString(System.identityHashCode(p)); 
     assertEquals(pBaseStr + "[name=John Doe,age=33,smoker=false]", new ToStringBuilder(p).append("name", p.name).append("age", p.age).append("smoker", p.smoker).toString()); 
 }
@Test
public void testPerson9500() { 
     final Person p = new Person(); 
     p.name = "John Doe"; 
     p.age = 33; 
     p.smoker = false; 
     final String pBaseStr = p.getClass().getName() + "@" + Integer.toHexString(System.identityHashCode(p)); 
     assertEquals(pBaseStr + "[name=John Doe,age=33,smoker=false]", new ToStringBuilder(p).append("name", p.name).append("age", p.age).append("smoker", p.smoker).toString()); 
 }
@Test
public void testIntArray9578() { 
         int[] array = new int[] {1, 2, -3, 4}; 
         assertEquals(baseStr + "[{1,2,-3,4}]", new ToStringBuilder(base).append(array).toString()); 
         assertEquals(baseStr + "[{1,2,-3,4}]", new ToStringBuilder(base).append((Object) array).toString()); 
         array = null; 
         assertEquals(baseStr + "[<null>]", new ToStringBuilder(base).append(array).toString()); 
         assertEquals(baseStr + "[<null>]", new ToStringBuilder(base).append((Object) array).toString()); 
     }
@Test
public void testIntArray10016() { 
         int[] array = new int[] {1, 2, -3, 4}; 
         assertEquals(baseStr + "[{1,2,-3,4}]", new ToStringBuilder(base).append(array).toString()); 
         assertEquals(baseStr + "[{1,2,-3,4}]", new ToStringBuilder(base).append((Object) array).toString()); 
         array = null; 
         assertEquals(baseStr + "[<null>]", new ToStringBuilder(base).append(array).toString()); 
         assertEquals(baseStr + "[<null>]", new ToStringBuilder(base).append((Object) array).toString()); 
     }
@Test
public void testOneArgNull10020() { 
         assertFalse(AnnotationUtils.equals(field1.getAnnotation(TestAnnotation.class), null)); 
         assertFalse(AnnotationUtils.equals(null, field1.getAnnotation(TestAnnotation.class))); 
     }
@Test
public void testOneArgNull10028() { 
         assertFalse(AnnotationUtils.equals(field1.getAnnotation(TestAnnotation.class), null)); 
         assertFalse(AnnotationUtils.equals(null, field1.getAnnotation(TestAnnotation.class))); 
     }
@Test
public void testOneArgNull10034() { 
         assertFalse(AnnotationUtils.equals(field1.getAnnotation(TestAnnotation.class), null)); 
         assertFalse(AnnotationUtils.equals(null, field1.getAnnotation(TestAnnotation.class))); 
     }
@Test
public void testLongArray10035() { 
         long[] array = new long[] {1, 2, -3, 4}; 
         assertEquals(baseStr + "[{1,2,-3,4}]", new ToStringBuilder(base).append(array).toString()); 
         assertEquals(baseStr + "[{1,2,-3,4}]", new ToStringBuilder(base).append((Object) array).toString()); 
         array = null; 
         assertEquals(baseStr + "[<null>]", new ToStringBuilder(base).append(array).toString()); 
         assertEquals(baseStr + "[<null>]", new ToStringBuilder(base).append((Object) array).toString()); 
     }
@Test
public void testBooleanArray10038() { 
         boolean[] array = new boolean[] { true, false, false }; 
         assertEquals(baseStr + "[{true,false,false}]", new ToStringBuilder(base).append(array).toString()); 
         assertEquals(baseStr + "[{true,false,false}]", new ToStringBuilder(base).append((Object) array).toString()); 
         array = null; 
         assertEquals(baseStr + "[<null>]", new ToStringBuilder(base).append(array).toString()); 
         assertEquals(baseStr + "[<null>]", new ToStringBuilder(base).append((Object) array).toString()); 
     }
@Test
public void testPerson10040() { 
         final Person p = new Person(); 
         p.name = "John Doe"; 
         p.age = 33; 
         p.smoker = false; 
         final String pBaseStr = p.getClass().getName() + "@" + Integer.toHexString(System.identityHashCode(p)); 
         assertEquals(pBaseStr + "[name=John Doe,age=33,smoker=false]", new ToStringBuilder(p).append("name", p.name).append("age", p.age).append("smoker", p.smoker).toString()); 
     }
@Test
public void testIntArray10045() { 
         int[] array = new int[] {1, 2, -3, 4}; 
         assertEquals(baseStr + "[{1,2,-3,4}]", new ToStringBuilder(base).append(array).toString()); 
         assertEquals(baseStr + "[{1,2,-3,4}]", new ToStringBuilder(base).append((Object) array).toString()); 
         array = null; 
         assertEquals(baseStr + "[<null>]", new ToStringBuilder(base).append(array).toString()); 
         assertEquals(baseStr + "[<null>]", new ToStringBuilder(base).append((Object) array).toString()); 
     }
@Test
public void testDoubleArray10048() { 
         double[] array = new double[] {1.0, 2.9876, -3.00001, 4.3}; 
         assertEquals(baseStr + "[{1.0,2.9876,-3.00001,4.3}]", new ToStringBuilder(base).append(array).toString()); 
         assertEquals(baseStr + "[{1.0,2.9876,-3.00001,4.3}]", new ToStringBuilder(base).append((Object) array).toString()); 
         array = null; 
         assertEquals(baseStr + "[<null>]", new ToStringBuilder(base).append(array).toString()); 
         assertEquals(baseStr + "[<null>]", new ToStringBuilder(base).append((Object) array).toString()); 
     }
@Test
public void testPerson10069() { 
         final Person p = new Person(); 
         p.name = "John Doe"; 
         p.age = 33; 
         p.smoker = false; 
         final String pBaseStr = p.getClass().getName() + "@" + Integer.toHexString(System.identityHashCode(p)); 
         assertEquals(pBaseStr + "[name=John Doe,age=33,smoker=false]", new ToStringBuilder(p).append("name", p.name).append("age", p.age).append("smoker", p.smoker).toString()); 
     }
@Test
public void testIntArray10076() { 
         int[] array = new int[] {1, 2, -3, 4}; 
         assertEquals(baseStr + "[{1,2,-3,4}]", new ToStringBuilder(base).append(array).toString()); 
         assertEquals(baseStr + "[{1,2,-3,4}]", new ToStringBuilder(base).append((Object) array).toString()); 
         array = null; 
         assertEquals(baseStr + "[<null>]", new ToStringBuilder(base).append(array).toString()); 
         assertEquals(baseStr + "[<null>]", new ToStringBuilder(base).append((Object) array).toString()); 
     }
@Test
public void testIntArray10093() { 
         int[] array = new int[] {1, 2, -3, 4}; 
         assertEquals(baseStr + "[{1,2,-3,4}]", new ToStringBuilder(base).append(array).toString()); 
         assertEquals(baseStr + "[{1,2,-3,4}]", new ToStringBuilder(base).append((Object) array).toString()); 
         array = null; 
         assertEquals(baseStr + "[<null>]", new ToStringBuilder(base).append(array).toString()); 
         assertEquals(baseStr + "[<null>]", new ToStringBuilder(base).append((Object) array).toString()); 
     }
@Test
public void testIntArray10103() { 
         int[] array = new int[] {1, 2, -3, 4}; 
         assertEquals(baseStr + "[{1,2,-3,4}]", new ToStringBuilder(base).append(array).toString()); 
         assertEquals(baseStr + "[{1,2,-3,4}]", new ToStringBuilder(base).append((Object) array).toString()); 
         array = null; 
         assertEquals(baseStr + "[<null>]", new ToStringBuilder(base).append(array).toString()); 
         assertEquals(baseStr + "[<null>]", new ToStringBuilder(base).append((Object) array).toString()); 
     }
@Test
public void testIntArray10107() { 
         int[] array = new int[] {1, 2, -3, 4}; 
         assertEquals(baseStr + "[{1,2,-3,4}]", new ToStringBuilder(base).append(array).toString()); 
         assertEquals(baseStr + "[{1,2,-3,4}]", new ToStringBuilder(base).append((Object) array).toString()); 
         array = null; 
         assertEquals(baseStr + "[<null>]", new ToStringBuilder(base).append(array).toString()); 
         assertEquals(baseStr + "[<null>]", new ToStringBuilder(base).append((Object) array).toString()); 
     }
@Test
public void testFloatArray10108() { 
         float[] array = new float[] {1.0f, 2.9876f, -3.00001f, 4.3f}; 
         assertEquals(baseStr + "[{1.0,2.9876,-3.00001,4.3}]", new ToStringBuilder(base).append(array).toString()); 
         assertEquals(baseStr + "[{1.0,2.9876,-3.00001,4.3}]", new ToStringBuilder(base).append((Object) array).toString()); 
         array = null; 
         assertEquals(baseStr + "[<null>]", new ToStringBuilder(base).append(array).toString()); 
         assertEquals(baseStr + "[<null>]", new ToStringBuilder(base).append((Object) array).toString()); 
     }
@Test
public void testOneArgNull10117() { 
         assertFalse(AnnotationUtils.equals(field1.getAnnotation(TestAnnotation.class), null)); 
         assertFalse(AnnotationUtils.equals(null, field1.getAnnotation(TestAnnotation.class))); 
     }
    

    
    
    

    

    

    

    

    

}
