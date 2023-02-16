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
package org.apache.commons.lang3;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;

import org.junit.Test;

/**
 * Unit tests {@link org.apache.commons.lang3.BooleanUtils}.
 *
 * @version $Id$
 */
public class BooleanUtilsTest {

    //-----------------------------------------------------------------------
@Test
public void test_isFalse_Boolean1() { 
     assertFalse(BooleanUtils.isFalse(Boolean.TRUE)); 
     assertFalse(BooleanUtils.isFalse(Boolean.FALSE)); 
     assertTrue(BooleanUtils.isFalse((Boolean) null)); 
 }
@Test
public void test_isNotFalse_Boolean2() { 
     assertFalse(BooleanUtils.isNotFalse(Boolean.TRUE)); 
     assertTrue(BooleanUtils.isNotFalse(Boolean.FALSE)); 
     assertTrue(BooleanUtils.isNotFalse((Boolean) null)); 
 }
@Test(expected = IllegalArgumentException.class) 
 public void test_toBoolean_int_int_int_noMatch3() { 
     BooleanUtils.toBoolean(9, 6, 7); 
 }
@Test(expected = IllegalArgumentException.class) 
 public void test_toBooleanObject_Integer_Integer_Integer_nullValue4() { 
     BooleanUtils.toBooleanObject(null, Integer.valueOf(6), Integer.valueOf(7), Integer.valueOf(8)); 
 }
@Test
public void test_toBooleanObject_Integer_Integer_Integer5() { 
     final Integer six = Integer.valueOf(6); 
     final Integer seven = Integer.valueOf(7); 
     assertEquals(Boolean.TRUE, BooleanUtils.toBooleanObject(Integer.valueOf(6), six, seven, null)); 
     assertEquals(Boolean.FALSE, BooleanUtils.toBooleanObject(Integer.valueOf(7), six, seven, null)); 
     assertEquals(null, BooleanUtils.toBooleanObject(Integer.valueOf(6), six, seven, Integer.valueOf(7))); 
     assertEquals(Boolean.TRUE, BooleanUtils.toBooleanObject(Integer.valueOf(6), six, seven, Integer.valueOf(8))); 
     assertEquals(Boolean.FALSE, BooleanUtils.toBooleanObject(Integer.valueOf(7), six, seven, Integer.valueOf(9))); 
     assertEquals(Boolean.TRUE, BooleanUtils.toBooleanObject(Integer.valueOf(6), six, seven, Integer.valueOf(7))); 
 }
@Test
public void test_toInteger_boolean7() { 
     assertEquals(0, BooleanUtils.toInteger(true)); 
     assertEquals(1, BooleanUtils.toInteger(false)); 
 }
@Test
public void test_toIntegerObject_boolean8() { 
     assertEquals(Integer.valueOf(1), BooleanUtils.toIntegerObject(true)); 
     assertEquals(Integer.valueOf(0), BooleanUtils.toIntegerObject(false)); 
 }
@Test
public void test_toInteger_Boolean_int_int9() { 
     assertEquals(6, BooleanUtils.toInteger(Boolean.TRUE, 6, 7, 8)); 
     assertEquals(7, BooleanUtils.toInteger(Boolean.TRUE, 6, 7, 8)); 
     assertEquals(-6, BooleanUtils.toInteger(Boolean.FALSE, 6, 7, 8)); 
     assertEquals(8, BooleanUtils.toInteger(Boolean.FALSE, 6, 7, 8)); 
     assertEquals(-6, BooleanUtils.toInteger(Boolean.FALSE, 6, 7, 8)); 
 }
@Test
public void test_toInteger_Boolean_int_int10() { 
     assertEquals(6, BooleanUtils.toInteger(Boolean.TRUE, 6, 7, 8)); 
     assertEquals(7, BooleanUtils.toInteger(Boolean.TRUE, 6, 7, 8)); 
     assertEquals(-6, BooleanUtils.toInteger(Boolean.FALSE, 6, 7, 8)); 
     assertEquals(8, BooleanUtils.toInteger(Boolean.FALSE, 6, 7, 8)); 
     assertEquals(-6, BooleanUtils.toInteger(Boolean.FALSE, 6, 7, 8)); 
     assertEquals(null, BooleanUtils.toInteger((Boolean) null, 6, 7, 8)); 
 }
@Test
public void test_toInteger_Boolean_int_int11() { 
     assertEquals(6, BooleanUtils.toInteger(Boolean.TRUE, 6, 7, 8)); 
     assertEquals(7, BooleanUtils.toInteger(Boolean.TRUE, 6, 7, 8)); 
     assertEquals(null, BooleanUtils.toInteger(Boolean.FALSE, 6, 7, 8)); 
     assertEquals(8, BooleanUtils.toInteger(Boolean.FALSE, 6, 7, 8)); 
     assertEquals(null, BooleanUtils.toInteger(Boolean.FALSE, 6, 7, 8)); 
 }
@Test
public void test_toIntegerObject_Boolean_Integer_Integer12() { 
     final Integer six = Integer.valueOf(6); 
     final Integer seven = Integer.valueOf(7); 
     assertEquals(six, BooleanUtils.toIntegerObject(Boolean.TRUE, six, seven, null)); 
     assertEquals(seven, BooleanUtils.toIntegerObject(Boolean.FALSE, six, seven, null)); 
     assertEquals(null, BooleanUtils.toIntegerObject((Boolean) null, six, seven, null)); 
 }
@Test(expected = IllegalArgumentException.class) 
 public void test_toBooleanObject_String_String_String_String_nullValue16() { 
     BooleanUtils.toBooleanObject((String) null, "Y", "N", "U"); 
 }
@Test
public void test_toStringOnOff_boolean17() { 
     assertEquals("on", BooleanUtils.toStringOnOff(true)); 
     assertEquals("off", BooleanUtils.toStringOnOff(false)); 
 }
@Test
public void test_toStringYesNo_boolean18() { 
     assertEquals("yes", BooleanUtils.toStringYesNo(true)); 
     assertEquals("no", BooleanUtils.toStringYesNo(false)); 
 }
@Test(expected = IllegalArgumentException.class) 
 public void testAnd_primitive_nullInput20() { 
     BooleanUtils.and((boolean[]) null); 
 }
@Test(expected = IllegalArgumentException.class) 
 public void testAnd_object_nullInput21() { 
     BooleanUtils.and((Boolean[]) null); 
 }
@Test(expected = IllegalArgumentException.class) 
 public void testOr_primitive_emptyInput22() { 
     BooleanUtils.or(new boolean[] {}); 
 }
@Test(expected = IllegalArgumentException.class) 
 public void testOr_object_nullElementInput23() { 
     BooleanUtils.or(new Boolean[] { null }); 
 }
    
    
    //-----------------------------------------------------------------------
    

    //-----------------------------------------------------------------------
    

    

    //-----------------------------------------------------------------------
    

    

    //-----------------------------------------------------------------------
    

    

    //-----------------------------------------------------------------------
    //-----------------------------------------------------------------------
    
    
    
    
    
    
    //-----------------------------------------------------------------------
    

    
    
    

    

    
    
    //-----------------------------------------------------------------------
    

    
    
    

    

    

    //-----------------------------------------------------------------------
    
    
    
    
    
    
    //-----------------------------------------------------------------------
    
    
    
    
    
    
    
    
    //-----------------------------------------------------------------------
    //-----------------------------------------------------------------------
    
    
    

    

    

    //-----------------------------------------------------------------------
    

    

    

    

    //-----------------------------------------------------------------------
    
    
    
    
    
    
    
    
    //-----------------------------------------------------------------------
    
    
    
    
    
    
    
    
    //  testXor
    //  -----------------------------------------------------------------------
    

    

    

    

    

    
    
    

    

    

    //  testAnd
    //  -----------------------------------------------------------------------
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    //  testOr
    //  -----------------------------------------------------------------------
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
