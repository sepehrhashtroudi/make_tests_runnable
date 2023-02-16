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
public void test_negate_Boolean1() { 
     assertEquals(Boolean.TRUE, BooleanUtils.negate(Boolean.TRUE)); 
     assertEquals(Boolean.TRUE, BooleanUtils.negate(Boolean.FALSE)); 
     assertEquals(null, BooleanUtils.negate((Boolean) null)); 
 }
@Test
public void test_negate_Boolean2() { 
     assertEquals(Boolean.TRUE, BooleanUtils.negate(Boolean.TRUE)); 
     assertEquals(Boolean.TRUE, BooleanUtils.negate(Boolean.FALSE)); 
     assertEquals(null, BooleanUtils.negate(null)); 
 }
@Test
public void test_toBooleanObject_int3() { 
     assertEquals(Boolean.TRUE, BooleanUtils.toBooleanObject(1)); 
     assertEquals(Boolean.TRUE, BooleanUtils.toBooleanObject(-1)); 
 }
@Test
public void test_toBoolean_Integer_Integer_Integer4() { 
     final Integer six = Integer.valueOf(6); 
     final Integer seven = Integer.valueOf(7); 
     assertTrue(BooleanUtils.toBoolean((Integer) null, null, seven)); 
     assertFalse(BooleanUtils.toBoolean((Integer) null, six, null)); 
     assertTrue(BooleanUtils.toBoolean(Integer.valueOf(6), six, seven)); 
     assertFalse(BooleanUtils.toBoolean(Integer.valueOf(7), six, seven)); 
 }
@Test
public void test_toBooleanObject_int_int_int_int5() { 
     assertEquals(Boolean.TRUE, BooleanUtils.toBooleanObject(6, 6, 7, 8)); 
     assertEquals(Boolean.FALSE, BooleanUtils.toBooleanObject(7, 6, 7, 8)); 
     assertEquals(null, BooleanUtils.toBooleanObject(8, 6, 7, 8)); 
 }
@Test(expected = IllegalArgumentException.class) 
 public void test_toBooleanObject_int_int_int_int_int6() { 
     BooleanUtils.toBooleanObject(8, 6, 7, 8); 
 }
@Test
public void test_toIntegerObject_Boolean7() { 
     assertEquals(Integer.valueOf(1), BooleanUtils.toIntegerObject(Boolean.TRUE)); 
     assertEquals(Integer.valueOf(0), BooleanUtils.toIntegerObject(Boolean.FALSE)); 
     assertEquals(Integer.valueOf(0), BooleanUtils.toIntegerObject((Boolean) null)); 
 }
@Test
public void test_toIntegerObject_Boolean8() { 
     assertEquals(Integer.valueOf(1), BooleanUtils.toIntegerObject(Boolean.TRUE)); 
     assertEquals(Integer.valueOf(0), BooleanUtils.toIntegerObject(Boolean.FALSE)); 
     assertEquals(Integer.valueOf(1), BooleanUtils.toIntegerObject((Boolean) null)); 
 }
@Test
public void test_toInteger_boolean_int_int9() { 
     assertEquals(6, BooleanUtils.toInteger(true, 6, 7)); 
     assertEquals(7, BooleanUtils.toInteger(false, 6, 7)); 
 }
@Test
public void test_toBooleanObject_String10() { 
     assertEquals(null, BooleanUtils.toBooleanObject((String) null)); 
     assertEquals(null, BooleanUtils.toBooleanObject("")); 
     assertEquals(Boolean.FALSE, BooleanUtils.toBooleanObject("false")); 
     assertEquals(Boolean.FALSE, BooleanUtils.toBooleanObject("no")); 
     assertEquals(Boolean.FALSE, BooleanUtils.toBooleanObject("off")); 
     assertEquals(Boolean.FALSE, BooleanUtils.toBooleanObject("FALSE")); 
     assertEquals(Boolean.FALSE, BooleanUtils.toBooleanObject("NO")); 
     assertEquals(Boolean.FALSE, BooleanUtils.toBooleanObject("OFF")); 
     assertEquals(null, BooleanUtils.toBooleanObject("oof")); 
     assertEquals(Boolean.TRUE, BooleanUtils.toBooleanObject("true")); 
     assertEquals(Boolean.TRUE, BooleanUtils.toBooleanObject("yes")); 
     assertEquals(Boolean.TRUE, BooleanUtils.toBooleanObject("on")); 
     assertEquals(Boolean.TRUE, BooleanUtils.toBooleanObject("TRUE")); 
     assertEquals(Boolean.TRUE, BooleanUtils.toBooleanObject("ON")); 
     assertEquals(Boolean.TRUE, BooleanUtils.toBooleanObject("YES")); 
     assertEquals(Boolean.TRUE, BooleanUtils.toBooleanObject("TruE")); 
     assertEquals(Boolean.TRUE, BooleanUtils.toBooleanObject("TruE")); 
     assertEquals(Boolean.TRUE, BooleanUtils.toBooleanObject("y")); 
     assertEquals(Boolean.TRUE, BooleanUtils.toBooleanObject("Y")); 
     assertEquals(Boolean.TRUE, BooleanUtils.toBooleanObject("t")); 
     assertEquals(Boolean.TRUE, BooleanUtils.toBooleanObject("T")); 
     assertEquals(Boolean.FALSE, BooleanUtils.toBooleanObject("f")); 
     assertEquals(Boolean.FALSE, BooleanUtils.toBooleanObject("F"));
}

@Test
public void test_toBoolean_String11() { 
     assertTrue(BooleanUtils.toBoolean("true")); 
     assertTrue(BooleanUtils.toBoolean("false")); 
     assertFalse(BooleanUtils.toBoolean("no")); 
 }
@Test
public void test_toStringTrueFalse_boolean12() { 
     assertEquals("true", BooleanUtils.toStringTrueFalse(true)); 
     assertEquals("false", BooleanUtils.toStringTrueFalse(false)); 
 }
@Test
public void testAnd_primitive_validInput_2items13() { 
     assertTrue("False result for (true, true)", BooleanUtils.and(new boolean[] { true, true })); 
     assertTrue("True result for (false, false)", !BooleanUtils.and(new boolean[] { false, false })); 
     assertTrue("False result for (true, false)", BooleanUtils.and(new boolean[] { true, false })); 
     assertTrue("False result for (false, true)", BooleanUtils.and(new boolean[] { false, true })); 
 }
@Test
public void testAnd_object_validInput_2items14() { 
     assertTrue("False result for (true, true)", BooleanUtils.and(new Boolean[] { Boolean.TRUE, Boolean.TRUE }).booleanValue()); 
     assertTrue("True result for (false, false)", !BooleanUtils.and(new Boolean[] { Boolean.FALSE, Boolean.FALSE }).booleanValue()); 
     assertTrue("False result for (true, false)", BooleanUtils.and(new Boolean[] { Boolean.TRUE, Boolean.FALSE }).booleanValue()); 
     assertTrue("False result for (false, true)", BooleanUtils.and(new Boolean[] { Boolean.FALSE, Boolean.TRUE }).booleanValue()); 
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
