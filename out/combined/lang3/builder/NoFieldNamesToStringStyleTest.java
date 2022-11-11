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
 * Unit tests {@link org.apache.commons.lang3.builder.NoFieldNamesToStringStyleTest}.
 *
 * @version $Id$
 */
public class NoFieldNamesToStringStyleTest {

    private final Integer base = Integer.valueOf(5);
    private final String baseStr = base.getClass().getName() + "@" + Integer.toHexString(System.identityHashCode(base));
    
    @Before
    public void setUp() throws Exception {
        ToStringBuilder.setDefaultStyle(ToStringStyle.NO_FIELD_NAMES_STYLE);
    }

    @After
    public void tearDown() throws Exception {
        ToStringBuilder.setDefaultStyle(ToStringStyle.DEFAULT_STYLE);
    }

    //----------------------------------------------------------------
    
@Test
public void testBlank861() { 
     assertEquals(baseStr + "[]", new ToStringBuilder(base).toString()); 
 }
@Test
public void testLongArray919() { 
     long[] array = new long[] { 1, 2, -3, 4 }; 
     assertEquals(baseStr + "[{1,2,-3,4}]", new ToStringBuilder(base).append(array).toString()); 
     assertEquals(baseStr + "[{1,2,-3,4}]", new ToStringBuilder(base).append((Object) array).toString()); 
     array = null; 
     assertEquals(baseStr + "[<null>]", new ToStringBuilder(base).append(array).toString()); 
     assertEquals(baseStr + "[<null>]", new ToStringBuilder(base).append((Object) array).toString()); 
 }
@Test
public void testLongArray1353() { 
     long[] array = new long[] { 1, 2, -3, 4 }; 
     assertEquals(baseStr + "[{1,2,-3,4}]", new ToStringBuilder(base).append(array).toString()); 
     assertEquals(baseStr + "[{1,2,-3,4}]", new ToStringBuilder(base).append((Object) array).toString()); 
     array = null; 
     assertEquals(baseStr + "[<null>]", new ToStringBuilder(base).append(array).toString()); 
     assertEquals(baseStr + "[<null>]", new ToStringBuilder(base).append((Object) array).toString()); 
 }
@Test
public void testBlank1745() { 
     assertEquals(baseStr + "[]", new ToStringBuilder(base).toString()); 
 }
@Test
public void testLongArray2347() { 
     long[] array = new long[] { 1, 2, -3, 4 }; 
     assertEquals(baseStr + "[{1,2,-3,4}]", new ToStringBuilder(base).append(array).toString()); 
     assertEquals(baseStr + "[{1,2,-3,4}]", new ToStringBuilder(base).append((Object) array).toString()); 
     array = null; 
     assertEquals(baseStr + "[<null>]", new ToStringBuilder(base).append(array).toString()); 
     assertEquals(baseStr + "[<null>]", new ToStringBuilder(base).append((Object) array).toString()); 
 }
@Test
public void testLongArray2528() { 
     long[] array = new long[] { 1, 2, -3, 4 }; 
     assertEquals(baseStr + "[{1,2,-3,4}]", new ToStringBuilder(base).append(array).toString()); 
     assertEquals(baseStr + "[{1,2,-3,4}]", new ToStringBuilder(base).append((Object) array).toString()); 
     array = null; 
     assertEquals(baseStr + "[<null>]", new ToStringBuilder(base).append(array).toString()); 
     assertEquals(baseStr + "[<null>]", new ToStringBuilder(base).append((Object) array).toString()); 
 }
@Test
public void testLongArray5146() { 
     long[] array = new long[] { 1, 2, -3, 4 }; 
     assertEquals(baseStr + "[{1,2,-3,4}]", new ToStringBuilder(base).append(array).toString()); 
     assertEquals(baseStr + "[{1,2,-3,4}]", new ToStringBuilder(base).append((Object) array).toString()); 
     array = null; 
     assertEquals(baseStr + "[<null>]", new ToStringBuilder(base).append(array).toString()); 
     assertEquals(baseStr + "[<null>]", new ToStringBuilder(base).append((Object) array).toString()); 
 }
@Test
public void testLongArray5299() { 
     long[] array = new long[] { 1, 2, -3, 4 }; 
     assertEquals(baseStr + "[{1,2,-3,4}]", new ToStringBuilder(base).append(array).toString()); 
     assertEquals(baseStr + "[{1,2,-3,4}]", new ToStringBuilder(base).append((Object) array).toString()); 
     array = null; 
     assertEquals(baseStr + "[<null>]", new ToStringBuilder(base).append(array).toString()); 
     assertEquals(baseStr + "[<null>]", new ToStringBuilder(base).append((Object) array).toString()); 
 }
@Test
public void testLongArray5850() { 
     long[] array = new long[] { 1, 2, -3, 4 }; 
     assertEquals(baseStr + "[{1,2,-3,4}]", new ToStringBuilder(base).append(array).toString()); 
     assertEquals(baseStr + "[{1,2,-3,4}]", new ToStringBuilder(base).append((Object) array).toString()); 
     array = null; 
     assertEquals(baseStr + "[<null>]", new ToStringBuilder(base).append(array).toString()); 
     assertEquals(baseStr + "[<null>]", new ToStringBuilder(base).append((Object) array).toString()); 
 }
@Test
public void testLongArray5984() { 
     long[] array = new long[] { 1, 2, -3, 4 }; 
     assertEquals(baseStr + "[{1,2,-3,4}]", new ToStringBuilder(base).append(array).toString()); 
     assertEquals(baseStr + "[{1,2,-3,4}]", new ToStringBuilder(base).append((Object) array).toString()); 
     array = null; 
     assertEquals(baseStr + "[<null>]", new ToStringBuilder(base).append(array).toString()); 
     assertEquals(baseStr + "[<null>]", new ToStringBuilder(base).append((Object) array).toString()); 
 }
@Test
public void testLongArray6268() { 
     long[] array = new long[] { 1, 2, -3, 4 }; 
     assertEquals(baseStr + "[{1,2,-3,4}]", new ToStringBuilder(base).append(array).toString()); 
     assertEquals(baseStr + "[{1,2,-3,4}]", new ToStringBuilder(base).append((Object) array).toString()); 
     array = null; 
     assertEquals(baseStr + "[<null>]", new ToStringBuilder(base).append(array).toString()); 
     assertEquals(baseStr + "[<null>]", new ToStringBuilder(base).append((Object) array).toString()); 
 }
@Test
public void testLongArray7105() { 
     long[] array = new long[] { 1, 2, -3, 4 }; 
     assertEquals(baseStr + "[{1,2,-3,4}]", new ToStringBuilder(base).append(array).toString()); 
     assertEquals(baseStr + "[{1,2,-3,4}]", new ToStringBuilder(base).append((Object) array).toString()); 
     array = null; 
     assertEquals(baseStr + "[<null>]", new ToStringBuilder(base).append(array).toString()); 
     assertEquals(baseStr + "[<null>]", new ToStringBuilder(base).append((Object) array).toString()); 
 }
@Test
public void testLongArray7125() { 
     long[] array = new long[] { 1, 2, -3, 4 }; 
     assertEquals(baseStr + "[{1,2,-3,4}]", new ToStringBuilder(base).append(array).toString()); 
     assertEquals(baseStr + "[{1,2,-3,4}]", new ToStringBuilder(base).append((Object) array).toString()); 
     array = null; 
     assertEquals(baseStr + "[<null>]", new ToStringBuilder(base).append(array).toString()); 
     assertEquals(baseStr + "[<null>]", new ToStringBuilder(base).append((Object) array).toString()); 
 }
@Test
public void testLongArray7367() { 
     long[] array = new long[] { 1, 2, -3, 4 }; 
     assertEquals(baseStr + "[{1,2,-3,4}]", new ToStringBuilder(base).append(array).toString()); 
     assertEquals(baseStr + "[{1,2,-3,4}]", new ToStringBuilder(base).append((Object) array).toString()); 
     array = null; 
     assertEquals(baseStr + "[<null>]", new ToStringBuilder(base).append(array).toString()); 
     assertEquals(baseStr + "[<null>]", new ToStringBuilder(base).append((Object) array).toString()); 
 }
@Test
public void testLongArray8120() { 
     long[] array = new long[] { 1, 2, -3, 4 }; 
     assertEquals(baseStr + "[{1,2,-3,4}]", new ToStringBuilder(base).append(array).toString()); 
     assertEquals(baseStr + "[{1,2,-3,4}]", new ToStringBuilder(base).append((Object) array).toString()); 
     array = null; 
     assertEquals(baseStr + "[<null>]", new ToStringBuilder(base).append(array).toString()); 
     assertEquals(baseStr + "[<null>]", new ToStringBuilder(base).append((Object) array).toString()); 
 }
@Test
public void testLongArray8367() { 
     long[] array = new long[] { 1, 2, -3, 4 }; 
     assertEquals(baseStr + "[{1,2,-3,4}]", new ToStringBuilder(base).append(array).toString()); 
     assertEquals(baseStr + "[{1,2,-3,4}]", new ToStringBuilder(base).append((Object) array).toString()); 
     array = null; 
     assertEquals(baseStr + "[<null>]", new ToStringBuilder(base).append(array).toString()); 
     assertEquals(baseStr + "[<null>]", new ToStringBuilder(base).append((Object) array).toString()); 
 }
@Test
public void testLongArray8671() { 
     long[] array = new long[] { 1, 2, -3, 4 }; 
     assertEquals(baseStr + "[{1,2,-3,4}]", new ToStringBuilder(base).append(array).toString()); 
     assertEquals(baseStr + "[{1,2,-3,4}]", new ToStringBuilder(base).append((Object) array).toString()); 
     array = null; 
     assertEquals(baseStr + "[<null>]", new ToStringBuilder(base).append(array).toString()); 
     assertEquals(baseStr + "[<null>]", new ToStringBuilder(base).append((Object) array).toString()); 
 }
@Test
public void testLongArray8822() { 
     long[] array = new long[] { 1, 2, -3, 4 }; 
     assertEquals(baseStr + "[{1,2,-3,4}]", new ToStringBuilder(base).append(array).toString()); 
     assertEquals(baseStr + "[{1,2,-3,4}]", new ToStringBuilder(base).append((Object) array).toString()); 
     array = null; 
     assertEquals(baseStr + "[<null>]", new ToStringBuilder(base).append(array).toString()); 
     assertEquals(baseStr + "[<null>]", new ToStringBuilder(base).append((Object) array).toString()); 
 }
    

    
    
    

    

    

    

    

    

}
