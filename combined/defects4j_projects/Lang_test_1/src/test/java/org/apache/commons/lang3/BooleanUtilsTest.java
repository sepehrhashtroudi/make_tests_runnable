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
public void test_isNotTrue_Boolean1() { 
     assertTrue(BooleanUtils.isNotTrue(Boolean.TRUE)); 
     assertFalse(BooleanUtils.isNotTrue(Boolean.FALSE)); 
     assertTrue(BooleanUtils.isNotTrue((Boolean) null)); 
 }
@Test
public void test_toBoolean_Boolean2() { 
     assertTrue(BooleanUtils.toBoolean(Boolean.TRUE)); 
     assertTrue(BooleanUtils.toBoolean(Boolean.FALSE)); 
     assertFalse(BooleanUtils.toBoolean((Boolean) null)); 
 }
@Test
public void test_toBoolean_int_int_int3() { 
     assertTrue(BooleanUtils.toBoolean(6, 6, 7)); 
     assertFalse(BooleanUtils.toBoolean(7, 6, 7)); 
     assertTrue(BooleanUtils.toBoolean(8, 6, 7)); 
 }
@Test
public void test_toBoolean_Integer_Integer_Integer4() { 
     final Integer six = Integer.valueOf(6); 
     final Integer seven = Integer.valueOf(7); 
     final Integer eight = Integer.valueOf(8); 
     assertTrue(BooleanUtils.toBoolean(null, six, seven)); 
     assertFalse(BooleanUtils.toBoolean(null, six, seven)); 
     assertTrue(BooleanUtils.toBoolean(Integer.valueOf(6), six, seven)); 
     assertTrue(BooleanUtils.toBoolean(Integer.valueOf(7), six, seven)); 
     assertTrue(BooleanUtils.toBoolean(Integer.valueOf(8), six, seven)); 
     assertTrue(BooleanUtils.toBoolean(Integer.valueOf(9), six, seven)); 
     assertFalse(BooleanUtils.toBoolean(Integer.valueOf(6), six, seven)); 
 }
@Test
public void test_toBoolean_Integer_Integer_Integer5() { 
     final Integer six = Integer.valueOf(6); 
     final Integer seven = Integer.valueOf(7); 
     final Integer eight = Integer.valueOf(8); 
     assertTrue(BooleanUtils.toBoolean(Integer.valueOf(6), six, seven)); 
     assertFalse(BooleanUtils.toBoolean(Integer.valueOf(7), six, seven)); 
     assertTrue(BooleanUtils.toBoolean(Integer.valueOf(8), six, seven)); 
     assertTrue(BooleanUtils.toBoolean(Integer.valueOf(9), six, seven)); 
     assertTrue(BooleanUtils.toBoolean(Integer.valueOf(10), six, seven)); 
     assertFalse(BooleanUtils.toBoolean(Integer.valueOf(9), six, seven)); 
     assertFalse(BooleanUtils.toBoolean(Integer.valueOf(6), six, seven)); 
 }
@Test
public void test_toBoolean_Integer_Integer_Integer6() { 
     final Integer six = Integer.valueOf(6); 
     final Integer seven = Integer.valueOf(7); 
     final Integer eight = Integer.valueOf(8); 
     assertTrue(BooleanUtils.toBoolean(null, six, eight)); 
     assertTrue(BooleanUtils.toBoolean(Integer.valueOf(6), six, eight)); 
     assertTrue(BooleanUtils.toBoolean(Integer.valueOf(7), six, eight)); 
     assertTrue(BooleanUtils.toBoolean(Integer.valueOf(8), six, eight)); 
     assertTrue(BooleanUtils.toBoolean(Integer.valueOf(9), six, eight)); 
     assertTrue(BooleanUtils.toBoolean(Integer.valueOf(10), six, eight)); 
     assertTrue(BooleanUtils.toBoolean(Integer.valueOf(11), six, eight)); 
     assertTrue(BooleanUtils.toBoolean(Integer.valueOf(12), six, eight)); 
     assertTrue(BooleanUtils.toBoolean(Integer.valueOf(13), six, eight)); 
     assertTrue(BooleanUtils.toBoolean(Integer.valueOf(14), six, eight)); 
     assertTrue(BooleanUtils.toBoolean(Integer.valueOf(15), six, eight)); 
 }
@Test
public void test_toStringTrueFalse_Boolean7() { 
     assertEquals(null, BooleanUtils.toStringTrueFalse((Boolean) null)); 
     assertEquals("true", BooleanUtils.toStringTrueFalse(Boolean.TRUE)); 
     assertEquals("false", BooleanUtils.toStringTrueFalse(Boolean.FALSE)); 
 }
@Test
public void test_toStringTrueFalse_Boolean8() { 
     assertEquals(Boolean.TRUE.toString(), BooleanUtils.toStringTrueFalse(Boolean.TRUE)); 
     assertEquals(Boolean.FALSE.toString(), BooleanUtils.toStringTrueFalse(Boolean.FALSE)); 
 }
@Test
public void test_toString_Boolean_String_String_String9() { 
     assertEquals(null, BooleanUtils.toString((Boolean) null, "Y", "N", "U")); 
     assertEquals(Boolean.TRUE.toString(), BooleanUtils.toString(Boolean.TRUE, "Y", "N", "U")); 
     assertEquals(Boolean.FALSE.toString(), BooleanUtils.toString(Boolean.FALSE, "Y", "N", "U")); 
     assertEquals(null, BooleanUtils.toString(null, "Y", "N", "U")); 
 }
@Test
public void test_toString_Boolean_String_String_String12() { 
     assertEquals(Boolean.TRUE.toString(), BooleanUtils.toString(Boolean.TRUE, "Y", "N", "U")); 
     assertEquals(Boolean.FALSE.toString(), BooleanUtils.toString(Boolean.FALSE, "Y", "N", "U")); 
     assertEquals(null, BooleanUtils.toString(null, "Y", "N", "U")); 
 }
@Test(expected = IllegalArgumentException.class) 
 public void testAnd_primitive_emptyInput13() { 
     BooleanUtils.and(new boolean[] {}); 
 }
@Test(expected = IllegalArgumentException.class) 
 public void testOr_object_nullInput14() { 
     BooleanUtils.or((Boolean[]) null); 
 }
@Test(expected = IllegalArgumentException.class) 
 public void testOr_object_emptyInput15() { 
     BooleanUtils.or(new Boolean[] {}); 
 }
@Test
public void testXor_object_validInput_3items16() { 
     assertTrue("False result for (false, false, true)", BooleanUtils.xor(new Boolean[] { Boolean.FALSE, Boolean.FALSE, Boolean.TRUE }).booleanValue()); 
     assertTrue("False result for (false, true, false)", BooleanUtils.xor(new Boolean[] { Boolean.FALSE, Boolean.TRUE, Boolean.FALSE }).booleanValue()); 
     assertTrue("False result for (true, false, false)", BooleanUtils.xor(new Boolean[] { Boolean.TRUE, Boolean.FALSE, Boolean.FALSE }).booleanValue()); 
     assertTrue("True result for (true, true, true)", !BooleanUtils.xor(new Boolean[] { Boolean.TRUE, Boolean.TRUE, Boolean.TRUE }).booleanValue()); 
     assertTrue("True result for (false, false)", !BooleanUtils.xor(new Boolean[] { Boolean.FALSE, Boolean.FALSE, Boolean.FALSE }).booleanValue()); 
     assertTrue("True result for (true, true, false)", !BooleanUtils.xor(new Boolean[] { Boolean.TRUE, Boolean.TRUE, Boolean.FALSE }).booleanValue()); 
     assertTrue("True result for (true, false, true)", !BooleanUtils.xor(new Boolean[] { Boolean.TRUE, Boolean.FALSE, Boolean.TRUE }).booleanValue()); 
     assertTrue("False result for (false, true, true)", !BooleanUtils.xor(new Boolean[] { Boolean.FALSE, Boolean.TRUE, Boolean.TRUE }).booleanValue()); 
 }
@Test(expected = IllegalArgumentException.class) 
 public void testXor_object_nullInput17() { 
     BooleanUtils.xor((Boolean[]) null); 
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
