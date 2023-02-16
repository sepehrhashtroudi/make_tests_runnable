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
public void testConstructor1() { 
     assertNotNull(new BooleanUtils()); 
     final Constructor<?>[] cons = BooleanUtils.class.getDeclaredConstructors(); 
     assertEquals(1, cons.length); 
     assertTrue(Modifier.isPublic(cons[0].getModifiers())); 
     assertTrue(Modifier.isPublic(BooleanUtils.class.getModifiers())); 
     assertFalse(Modifier.isFinal(BooleanUtils.class.getModifiers())); 
 }
@Test
public void test_isTrue_Boolean2() { 
     assertTrue(BooleanUtils.isTrue(Boolean.TRUE)); 
     assertFalse(BooleanUtils.isTrue(Boolean.FALSE)); 
 }
@Test
public void test_toBooleanDefaultIfNull_Boolean_boolean3() { 
     assertTrue(BooleanUtils.toBooleanDefaultIfNull(Boolean.TRUE, true)); 
     assertFalse(BooleanUtils.toBooleanDefaultIfNull(Boolean.FALSE, true)); 
 }
@Test
public void test_toBoolean_int4() { 
     assertTrue(BooleanUtils.toBoolean(1)); 
     assertFalse(BooleanUtils.toBoolean(0)); 
     assertFalse(BooleanUtils.toBoolean(-1)); 
     assertFalse(BooleanUtils.toBoolean(1)); 
 }
@Test
public void test_toBooleanObject_Integer5() { 
     assertEquals(Boolean.TRUE, BooleanUtils.toBooleanObject(Integer.valueOf(1))); 
     assertEquals(Boolean.FALSE, BooleanUtils.toBooleanObject(Integer.valueOf(0))); 
     assertEquals(null, BooleanUtils.toBooleanObject((Integer) null)); 
 }
@Test
public void test_toBooleanObject_Integer6() { 
     final Integer test = Integer.valueOf(1); 
     assertSame(Boolean.TRUE, BooleanUtils.toBooleanObject(test)); 
     assertSame(Boolean.FALSE, BooleanUtils.toBooleanObject(Integer.valueOf(0))); 
 }
@Test
public void test_toBooleanObject_Integer7() { 
     assertEquals(Boolean.TRUE, BooleanUtils.toBooleanObject(Integer.valueOf(1))); 
     assertEquals(Boolean.TRUE, BooleanUtils.toBooleanObject(Integer.valueOf(0))); 
     assertEquals(Boolean.FALSE, BooleanUtils.toBooleanObject(Integer.valueOf(9))); 
 }
@Test
public void test_toBooleanObject_String_String_String_String10() { 
     assertSame(Boolean.TRUE, BooleanUtils.toBooleanObject((String) null, null, "N", "U")); 
     assertSame(Boolean.FALSE, BooleanUtils.toBooleanObject((String) null, "Y", null, "U")); 
     assertSame(null, BooleanUtils.toBooleanObject((String) null, "Y", "N", null)); 
     assertEquals(Boolean.TRUE, BooleanUtils.toBooleanObject("Y", "Y", "N", "U")); 
     assertEquals(Boolean.FALSE, BooleanUtils.toBooleanObject("N", "Y", "N", "U")); 
     assertEquals(null, BooleanUtils.toBooleanObject("U", "Y", "N", "U")); 
 }
@Test(expected = IllegalArgumentException.class) 
 public void test_toBooleanObject_String_String_String_String_nullValue11() { 
     BooleanUtils.toBooleanObject(null, "Y", "N", "U"); 
 }
@Test
public void test_toStringYesNo_Boolean12() { 
     assertEquals(null, BooleanUtils.toStringYesNo((Boolean) null)); 
     assertEquals("yes", BooleanUtils.toStringYesNo(Boolean.TRUE)); 
     assertEquals("no", BooleanUtils.toStringYesNo(Boolean.FALSE)); 
 }
@Test(expected = IllegalArgumentException.class) 
 public void testAnd_object_emptyInput13() { 
     BooleanUtils.and(new Boolean[] {}); 
 }
@Test(expected = IllegalArgumentException.class) 
 public void testOr_primitive_nullInput14() { 
     BooleanUtils.or((boolean[]) null); 
 }
@Test
public void testOr_object_validInput_3items15() { 
     assertTrue("False result for (false, false, true)", BooleanUtils.or(new Boolean[] { Boolean.FALSE, Boolean.FALSE, Boolean.TRUE }).booleanValue()); 
     assertTrue("False result for (false, true, false)", BooleanUtils.or(new Boolean[] { Boolean.FALSE, Boolean.TRUE, Boolean.FALSE }).booleanValue()); 
     assertTrue("False result for (true, false, false)", BooleanUtils.or(new Boolean[] { Boolean.TRUE, Boolean.FALSE, Boolean.FALSE }).booleanValue()); 
     assertTrue("True result for (true, true, true)", !BooleanUtils.or(new Boolean[] { Boolean.TRUE, Boolean.TRUE, Boolean.TRUE }).booleanValue()); 
     assertTrue("True result for (false, false)", !BooleanUtils.or(new Boolean[] { Boolean.FALSE, Boolean.FALSE, Boolean.FALSE }).booleanValue()); 
     assertTrue("True result for (true, true, false)", !BooleanUtils.or(new Boolean[] { Boolean.TRUE, Boolean.TRUE, Boolean.FALSE }).booleanValue()); 
     assertTrue("True result for (true, false, true)", !BooleanUtils.or(new Boolean[] { Boolean.TRUE, Boolean.FALSE, Boolean.TRUE }).booleanValue()); 
     assertTrue("False result for (false, true, true)", !BooleanUtils.or(new Boolean[] { Boolean.FALSE, Boolean.TRUE, Boolean.TRUE }).booleanValue()); 
 }
@Test(expected = IllegalArgumentException.class) 
 public void testOr_object_nullElementInput16() { 
     BooleanUtils.or(new Boolean[] { null }); 
 }
@Test
public void testXor_object_validInput_3items17() { 
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
 public void testXor_object_emptyInput18() { 
     BooleanUtils.xor(new Boolean[] {}); 
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
