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
     assertSame(null, BooleanUtils.negate(null)); 
     assertSame(Boolean.TRUE, BooleanUtils.negate(Boolean.FALSE)); 
     assertSame(Boolean.FALSE, BooleanUtils.negate(Boolean.TRUE)); 
 }
@Test
public void test_isNotTrue_Boolean2() { 
     assertFalse(BooleanUtils.isNotTrue(Boolean.TRUE)); 
     assertTrue(BooleanUtils.isNotTrue(Boolean.FALSE)); 
     assertTrue(BooleanUtils.isNotTrue((Boolean) null)); 
 }
@Test
public void test_isNotFalse_Boolean3() { 
     assertTrue(BooleanUtils.isNotFalse(Boolean.TRUE)); 
     assertFalse(BooleanUtils.isNotFalse(Boolean.FALSE)); 
     assertTrue(BooleanUtils.isNotFalse((Boolean) null)); 
 }
@Test
public void test_toBoolean_Boolean4() { 
     assertTrue(BooleanUtils.toBoolean(Boolean.TRUE)); 
     assertFalse(BooleanUtils.toBoolean(Boolean.FALSE)); 
     assertFalse(BooleanUtils.toBoolean((Boolean) null)); 
 }
@Test
public void test_toBooleanObject_int5() { 
     assertEquals(Boolean.TRUE, BooleanUtils.toBooleanObject(1)); 
     assertEquals(Boolean.TRUE, BooleanUtils.toBooleanObject(-1)); 
     assertEquals(Boolean.FALSE, BooleanUtils.toBooleanObject(0)); 
 }
@Test
public void test_toBoolean_int_int_int6() { 
     assertTrue(BooleanUtils.toBoolean(6, 6, 7)); 
     assertFalse(BooleanUtils.toBoolean(7, 6, 7)); 
 }
@Test(expected = IllegalArgumentException.class) 
 public void test_toBoolean_int_int_int_noMatch7() { 
     BooleanUtils.toBoolean(8, 6, 7); 
 }
@Test
public void test_toBoolean_Integer_Integer_Integer8() { 
     final Integer six = Integer.valueOf(6); 
     final Integer seven = Integer.valueOf(7); 
     assertTrue(BooleanUtils.toBoolean((Integer) null, null, seven)); 
     assertFalse(BooleanUtils.toBoolean((Integer) null, six, null)); 
     assertTrue(BooleanUtils.toBoolean(Integer.valueOf(6), six, seven)); 
     assertFalse(BooleanUtils.toBoolean(Integer.valueOf(7), six, seven)); 
 }
@Test(expected = IllegalArgumentException.class) 
 public void test_toBoolean_Integer_Integer_Integer_nullValue9() { 
     BooleanUtils.toBoolean(null, Integer.valueOf(6), Integer.valueOf(7)); 
 }
@Test(expected = IllegalArgumentException.class) 
 public void test_toBooleanObject_int_int_int_noMatch10() { 
     BooleanUtils.toBooleanObject(9, 6, 7, 8); 
 }
@Test
public void test_toBooleanObject_int_int_int11() { 
     assertEquals(Boolean.TRUE, BooleanUtils.toBooleanObject(6, 6, 7, 8)); 
     assertEquals(Boolean.FALSE, BooleanUtils.toBooleanObject(7, 6, 7, 8)); 
     assertEquals(null, BooleanUtils.toBooleanObject(8, 6, 7, 8)); 
 }
@Test
public void test_toBooleanObject_Integer_Integer_Integer_Integer12() { 
     final Integer six = Integer.valueOf(6); 
     final Integer seven = Integer.valueOf(7); 
     final Integer eight = Integer.valueOf(8); 
     assertSame(Boolean.TRUE, BooleanUtils.toBooleanObject((Integer) null, null, seven, eight)); 
     assertSame(Boolean.FALSE, BooleanUtils.toBooleanObject((Integer) null, six, null, eight)); 
     assertSame(null, BooleanUtils.toBooleanObject((Integer) null, six, seven, null)); 
     assertEquals(Boolean.TRUE, BooleanUtils.toBooleanObject(Integer.valueOf(6), six, seven, eight)); 
     assertEquals(Boolean.FALSE, BooleanUtils.toBooleanObject(Integer.valueOf(7), six, seven, eight)); 
     assertEquals(null, BooleanUtils.toBooleanObject(Integer.valueOf(8), six, seven, eight)); 
 }
@Test(expected = IllegalArgumentException.class) 
 public void test_toBooleanObject_Integer_Integer_Integer_Integer_noMatch13() { 
     BooleanUtils.toBooleanObject(Integer.valueOf(9), Integer.valueOf(6), Integer.valueOf(7), Integer.valueOf(8)); 
 }
@Test
public void test_toInteger_boolean14() { 
     assertEquals(1, BooleanUtils.toInteger(true)); 
     assertEquals(0, BooleanUtils.toInteger(false)); 
 }
@Test
public void test_toIntegerObject_boolean15() { 
     assertEquals(Integer.valueOf(1), BooleanUtils.toIntegerObject(true)); 
     assertEquals(Integer.valueOf(0), BooleanUtils.toIntegerObject(false)); 
 }
@Test
public void test_toIntegerObject_Boolean16() { 
     assertEquals(Integer.valueOf(1), BooleanUtils.toIntegerObject(Boolean.TRUE)); 
     assertEquals(Integer.valueOf(0), BooleanUtils.toIntegerObject(Boolean.FALSE)); 
     assertEquals(null, BooleanUtils.toIntegerObject((Boolean) null)); 
 }
@Test
public void test_toInteger_boolean_int_int17() { 
     assertEquals(6, BooleanUtils.toInteger(true, 6, 7)); 
     assertEquals(7, BooleanUtils.toInteger(false, 6, 7)); 
 }
@Test
public void test_toInteger_Boolean_int_int_int18() { 
     assertEquals(6, BooleanUtils.toInteger(Boolean.TRUE, 6, 7, 8)); 
     assertEquals(7, BooleanUtils.toInteger(Boolean.FALSE, 6, 7, 8)); 
     assertEquals(8, BooleanUtils.toInteger(null, 6, 7, 8)); 
 }
@Test
public void test_toIntegerObject_boolean_Integer_Integer19() { 
     final Integer six = Integer.valueOf(6); 
     final Integer seven = Integer.valueOf(7); 
     assertEquals(six, BooleanUtils.toIntegerObject(true, six, seven)); 
     assertEquals(seven, BooleanUtils.toIntegerObject(false, six, seven)); 
 }
@Test
public void test_toIntegerObject_Boolean_Integer_Integer_Integer20() { 
     final Integer six = Integer.valueOf(6); 
     final Integer seven = Integer.valueOf(7); 
     final Integer eight = Integer.valueOf(8); 
     assertEquals(six, BooleanUtils.toIntegerObject(Boolean.TRUE, six, seven, eight)); 
     assertEquals(seven, BooleanUtils.toIntegerObject(Boolean.FALSE, six, seven, eight)); 
     assertEquals(eight, BooleanUtils.toIntegerObject((Boolean) null, six, seven, eight)); 
     assertEquals(null, BooleanUtils.toIntegerObject((Boolean) null, six, seven, null)); 
 }
@Test
public void test_toBoolean_String21() { 
     assertFalse(BooleanUtils.toBoolean((String) null)); 
     assertFalse(BooleanUtils.toBoolean("")); 
     assertFalse(BooleanUtils.toBoolean("off")); 
     assertFalse(BooleanUtils.toBoolean("oof")); 
     assertFalse(BooleanUtils.toBoolean("yep")); 
     assertFalse(BooleanUtils.toBoolean("trux")); 
     assertFalse(BooleanUtils.toBoolean("false")); 
     assertFalse(BooleanUtils.toBoolean("a")); 
     assertTrue(BooleanUtils.toBoolean("true")); 
     assertTrue(BooleanUtils.toBoolean(new StringBuffer("tr").append("ue").toString())); 
     assertTrue(BooleanUtils.toBoolean("truE")); 
     assertTrue(BooleanUtils.toBoolean("trUe")); 
     assertTrue(BooleanUtils.toBoolean("trUE")); 
     assertTrue(BooleanUtils.toBoolean("tRue")); 
     assertTrue(BooleanUtils.toBoolean("tRuE")); 
     assertTrue(BooleanUtils.toBoolean("tRUe")); 
     assertTrue(BooleanUtils.toBoolean("tRUE")); 
     assertTrue(BooleanUtils.toBoolean("TRUE")); 
     assertTrue(BooleanUtils.toBoolean("TRUe")); 
     assertTrue(BooleanUtils.toBoolean("TRuE")); 
     assertTrue(BooleanUtils.toBoolean("TRue")); 
     assertTrue(BooleanUtils.toBoolean("TrUE")); 
     assertTrue(BooleanUtils.toBoolean("TrUe")); 
     assertTrue(BooleanUtils.toBoolean("TruE")); 
     assertTrue(BooleanUtils.toBoolean("True")); 
     assertTrue(BooleanUtils.toBoolean("on")); 
     assertTrue(BooleanUtils.toBoolean("oN")); 
     assertTrue(BooleanUtils.toBoolean("On")); 
     assertTrue(BooleanUtils.toBoolean("ON")); 
     assertTrue(BooleanUtils.toBoolean("yes")); 
     assertTrue(BooleanUtils.toBoolean("yeS")); 
     assertTrue(BooleanUtils.toBoolean("yEs")); 
     assertTrue(BooleanUtils.toBoolean("yES")); 
     assertTrue(BooleanUtils.toBoolean("Yes")); 
     assertTrue(BooleanUtils.toBoolean("YeS")); 
     assertTrue(BooleanUtils.toBoolean("YEs")); 
     assertTrue(BooleanUtils.toBoolean("YES")); 
     assertFalse(BooleanUtils.toBoolean("yes?")); 
     assertFalse(BooleanUtils.toBoolean("tru")); 
     assertFalse(BooleanUtils.toBoolean("no")); 
     assertFalse(BooleanUtils.toBoolean("off")); 
     assertFalse(BooleanUtils.toBoolean("yoo")); 
 }
@Test
public void test_toBooleanObject_String_String_String_String22() { 
     assertSame(Boolean.TRUE, BooleanUtils.toBooleanObject((String) null, null, "N", "U")); 
     assertSame(Boolean.FALSE, BooleanUtils.toBooleanObject((String) null, "Y", null, "U")); 
     assertSame(null, BooleanUtils.toBooleanObject((String) null, "Y", "N", null)); 
     assertEquals(Boolean.TRUE, BooleanUtils.toBooleanObject("Y", "Y", "N", "U")); 
     assertEquals(Boolean.FALSE, BooleanUtils.toBooleanObject("N", "Y", "N", "U")); 
     assertEquals(null, BooleanUtils.toBooleanObject("U", "Y", "N", "U")); 
 }
@Test
public void test_toBoolean_String_String_String23() { 
     assertTrue(BooleanUtils.toBoolean((String) null, null, "N")); 
     assertFalse(BooleanUtils.toBoolean((String) null, "Y", null)); 
     assertTrue(BooleanUtils.toBoolean("Y", "Y", "N")); 
     assertTrue(BooleanUtils.toBoolean("Y", new String("Y"), new String("N"))); 
     assertFalse(BooleanUtils.toBoolean("N", "Y", "N")); 
     assertFalse(BooleanUtils.toBoolean("N", new String("Y"), new String("N"))); 
     assertTrue(BooleanUtils.toBoolean((String) null, null, null)); 
     assertTrue(BooleanUtils.toBoolean("Y", "Y", "Y")); 
     assertTrue(BooleanUtils.toBoolean("Y", new String("Y"), new String("Y"))); 
 }
@Test(expected = IllegalArgumentException.class) 
 public void test_toBoolean_String_String_String_nullValue24() { 
     BooleanUtils.toBoolean(null, "Y", "N"); 
 }
@Test
public void test_toStringTrueFalse_Boolean25() { 
     assertEquals(null, BooleanUtils.toStringTrueFalse((Boolean) null)); 
     assertEquals("true", BooleanUtils.toStringTrueFalse(Boolean.TRUE)); 
     assertEquals("false", BooleanUtils.toStringTrueFalse(Boolean.FALSE)); 
 }
@Test
public void test_toStringOnOff_Boolean26() { 
     assertEquals(null, BooleanUtils.toStringOnOff((Boolean) null)); 
     assertEquals("on", BooleanUtils.toStringOnOff(Boolean.TRUE)); 
     assertEquals("off", BooleanUtils.toStringOnOff(Boolean.FALSE)); 
 }
@Test
public void test_toStringTrueFalse_boolean27() { 
     assertEquals("true", BooleanUtils.toStringTrueFalse(true)); 
     assertEquals("false", BooleanUtils.toStringTrueFalse(false)); 
 }
@Test
public void test_toStringOnOff_boolean28() { 
     assertEquals("on", BooleanUtils.toStringOnOff(true)); 
     assertEquals("off", BooleanUtils.toStringOnOff(false)); 
 }
@Test
public void test_toStringYesNo_boolean29() { 
     assertEquals("yes", BooleanUtils.toStringYesNo(true)); 
     assertEquals("no", BooleanUtils.toStringYesNo(false)); 
 }
@Test
public void testAnd_primitive_validInput_2items30() { 
     assertTrue("False result for (true, true)", BooleanUtils.and(new boolean[] { true, true })); 
     assertTrue("True result for (false, false)", !BooleanUtils.and(new boolean[] { false, false })); 
     assertTrue("True result for (true, false)", !BooleanUtils.and(new boolean[] { true, false })); 
     assertTrue("True result for (false, true)", !BooleanUtils.and(new boolean[] { false, true })); 
 }
@Test(expected = IllegalArgumentException.class) 
 public void testAnd_primitive_nullInput31() { 
     BooleanUtils.and((boolean[]) null); 
 }
@Test(expected = IllegalArgumentException.class) 
 public void testAnd_primitive_emptyInput32() { 
     BooleanUtils.and(new boolean[] {}); 
 }
@Test
public void testAnd_object_validInput_3items33() { 
     assertTrue("True result for (false, false, true)", !BooleanUtils.and(new Boolean[] { Boolean.FALSE, Boolean.FALSE, Boolean.TRUE }).booleanValue()); 
     assertTrue("True result for (false, true, false)", !BooleanUtils.and(new Boolean[] { Boolean.FALSE, Boolean.TRUE, Boolean.FALSE }).booleanValue()); 
     assertTrue("True result for (true, false, false)", !BooleanUtils.and(new Boolean[] { Boolean.TRUE, Boolean.FALSE, Boolean.FALSE }).booleanValue()); 
     assertTrue("False result for (true, true, true)", BooleanUtils.and(new Boolean[] { Boolean.TRUE, Boolean.TRUE, Boolean.TRUE }).booleanValue()); 
     assertTrue("True result for (false, false)", !BooleanUtils.and(new Boolean[] { Boolean.FALSE, Boolean.FALSE, Boolean.FALSE }).booleanValue()); 
     assertTrue("True result for (true, true, false)", !BooleanUtils.and(new Boolean[] { Boolean.TRUE, Boolean.TRUE, Boolean.FALSE }).booleanValue()); 
     assertTrue("True result for (true, false, true)", !BooleanUtils.and(new Boolean[] { Boolean.TRUE, Boolean.FALSE, Boolean.TRUE }).booleanValue()); 
     assertTrue("True result for (false, true, true)", !BooleanUtils.and(new Boolean[] { Boolean.FALSE, Boolean.TRUE, Boolean.TRUE }).booleanValue()); 
 }
@Test(expected = IllegalArgumentException.class) 
 public void testAnd_object_nullInput34() { 
     BooleanUtils.and((Boolean[]) null); 
 }
@Test(expected = IllegalArgumentException.class) 
 public void testAnd_object_nullElementInput35() { 
     BooleanUtils.and(new Boolean[] { null }); 
 }
@Test
public void testOr_primitive_validInput_2items36() { 
     assertTrue("False result for (true, true)", BooleanUtils.or(new boolean[] { true, true })); 
     assertTrue("True result for (false, false)", !BooleanUtils.or(new boolean[] { false, false })); 
     assertTrue("False result for (true, false)", BooleanUtils.or(new boolean[] { true, false })); 
     assertTrue("False result for (false, true)", BooleanUtils.or(new boolean[] { false, true })); 
 }
@Test(expected = IllegalArgumentException.class) 
 public void testOr_primitive_emptyInput37() { 
     BooleanUtils.or(new boolean[] {}); 
 }
@Test(expected = IllegalArgumentException.class) 
 public void testOr_object_emptyInput38() { 
     BooleanUtils.or(new Boolean[] {}); 
 }
@Test(expected = IllegalArgumentException.class) 
 public void testOr_object_nullElementInput39() { 
     BooleanUtils.or(new Boolean[] { null }); 
 }
@Test
public void testOr_object_validInput_2items40() { 
     assertTrue("False result for (true, true)", BooleanUtils.or(new Boolean[] { Boolean.TRUE, Boolean.TRUE }).booleanValue()); 
     assertTrue("True result for (false, false)", !BooleanUtils.or(new Boolean[] { Boolean.FALSE, Boolean.FALSE }).booleanValue()); 
     assertTrue("False result for (true, false)", BooleanUtils.or(new Boolean[] { Boolean.TRUE, Boolean.FALSE }).booleanValue()); 
     assertTrue("False result for (false, true)", BooleanUtils.or(new Boolean[] { Boolean.FALSE, Boolean.TRUE }).booleanValue()); 
 }
@Test
public void testXor_object_validInput_3items41() { 
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
 public void testXor_primitive_emptyInput42() { 
     BooleanUtils.xor(new boolean[] {}); 
 }
@Test(expected = IllegalArgumentException.class) 
 public void testXor_object_nullInput43() { 
     BooleanUtils.xor((Boolean[]) null); 
 }
@Test(expected = IllegalArgumentException.class) 
 public void testXor_object_nullElementInput44() { 
     BooleanUtils.xor(new Boolean[] { null }); 
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
