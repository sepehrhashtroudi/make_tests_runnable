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
     assertFalse(BooleanUtils.isTrue((Boolean) null)); 
 }
@Test
public void test_isNotTrue_Boolean3() { 
     assertFalse(BooleanUtils.isNotTrue(Boolean.TRUE)); 
     assertTrue(BooleanUtils.isNotTrue(Boolean.FALSE)); 
     assertTrue(BooleanUtils.isNotTrue((Boolean) null)); 
 }
@Test
public void test_isNotFalse_Boolean4() { 
     assertTrue(BooleanUtils.isNotFalse(Boolean.TRUE)); 
     assertFalse(BooleanUtils.isNotFalse(Boolean.FALSE)); 
     assertTrue(BooleanUtils.isNotFalse((Boolean) null)); 
 }
@Test
public void test_toBoolean_Boolean5() { 
     assertTrue(BooleanUtils.toBoolean(Boolean.TRUE)); 
     assertFalse(BooleanUtils.toBoolean(Boolean.FALSE)); 
     assertFalse(BooleanUtils.toBoolean((Boolean) null)); 
 }
@Test
public void test_toBooleanDefaultIfNull_Boolean_boolean6() { 
     assertTrue(BooleanUtils.toBooleanDefaultIfNull(Boolean.TRUE, true)); 
     assertTrue(BooleanUtils.toBooleanDefaultIfNull(Boolean.TRUE, false)); 
     assertFalse(BooleanUtils.toBooleanDefaultIfNull(Boolean.FALSE, true)); 
     assertFalse(BooleanUtils.toBooleanDefaultIfNull(Boolean.FALSE, false)); 
     assertTrue(BooleanUtils.toBooleanDefaultIfNull((Boolean) null, true)); 
     assertFalse(BooleanUtils.toBooleanDefaultIfNull((Boolean) null, false)); 
 }
@Test
public void test_toBoolean_int7() { 
     assertTrue(BooleanUtils.toBoolean(1)); 
     assertTrue(BooleanUtils.toBoolean(-1)); 
     assertFalse(BooleanUtils.toBoolean(0)); 
 }
@Test
public void test_toBooleanObject_Integer8() { 
     assertEquals(Boolean.TRUE, BooleanUtils.toBooleanObject(Integer.valueOf(1))); 
     assertEquals(Boolean.TRUE, BooleanUtils.toBooleanObject(Integer.valueOf(-1))); 
     assertEquals(Boolean.FALSE, BooleanUtils.toBooleanObject(Integer.valueOf(0))); 
     assertEquals(null, BooleanUtils.toBooleanObject((Integer) null)); 
 }
@Test
public void test_toBoolean_int_int_int9() { 
     assertTrue(BooleanUtils.toBoolean(6, 6, 7)); 
     assertFalse(BooleanUtils.toBoolean(7, 6, 7)); 
 }
@Test(expected = IllegalArgumentException.class) 
 public void test_toBoolean_int_int_int_noMatch10() { 
     BooleanUtils.toBoolean(8, 6, 7); 
 }
@Test
public void test_toBoolean_Integer_Integer_Integer11() { 
     final Integer six = Integer.valueOf(6); 
     final Integer seven = Integer.valueOf(7); 
     assertTrue(BooleanUtils.toBoolean((Integer) null, null, seven)); 
     assertFalse(BooleanUtils.toBoolean((Integer) null, six, null)); 
     assertTrue(BooleanUtils.toBoolean(Integer.valueOf(6), six, seven)); 
     assertFalse(BooleanUtils.toBoolean(Integer.valueOf(7), six, seven)); 
 }
@Test
public void test_toBooleanObject_int_int_int12() { 
     assertEquals(Boolean.TRUE, BooleanUtils.toBooleanObject(6, 6, 7, 8)); 
     assertEquals(Boolean.FALSE, BooleanUtils.toBooleanObject(7, 6, 7, 8)); 
     assertEquals(null, BooleanUtils.toBooleanObject(8, 6, 7, 8)); 
 }
@Test
public void test_toBooleanObject_Integer_Integer_Integer_Integer13() { 
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
 public void test_toBooleanObject_Integer_Integer_Integer_Integer_noMatch14() { 
     BooleanUtils.toBooleanObject(Integer.valueOf(9), Integer.valueOf(6), Integer.valueOf(7), Integer.valueOf(8)); 
 }
@Test
public void test_toInteger_boolean15() { 
     assertEquals(1, BooleanUtils.toInteger(true)); 
     assertEquals(0, BooleanUtils.toInteger(false)); 
 }
@Test
public void test_toIntegerObject_boolean16() { 
     assertEquals(Integer.valueOf(1), BooleanUtils.toIntegerObject(true)); 
     assertEquals(Integer.valueOf(0), BooleanUtils.toIntegerObject(false)); 
 }
@Test
public void test_toInteger_Boolean_int_int_int17() { 
     assertEquals(6, BooleanUtils.toInteger(Boolean.TRUE, 6, 7, 8)); 
     assertEquals(7, BooleanUtils.toInteger(Boolean.FALSE, 6, 7, 8)); 
     assertEquals(8, BooleanUtils.toInteger(null, 6, 7, 8)); 
 }
@Test
public void test_toIntegerObject_boolean_Integer_Integer18() { 
     final Integer six = Integer.valueOf(6); 
     final Integer seven = Integer.valueOf(7); 
     assertEquals(six, BooleanUtils.toIntegerObject(true, six, seven)); 
     assertEquals(seven, BooleanUtils.toIntegerObject(false, six, seven)); 
 }
@Test
public void test_toIntegerObject_Boolean_Integer_Integer_Integer19() { 
     final Integer six = Integer.valueOf(6); 
     final Integer seven = Integer.valueOf(7); 
     final Integer eight = Integer.valueOf(8); 
     assertEquals(six, BooleanUtils.toIntegerObject(Boolean.TRUE, six, seven, eight)); 
     assertEquals(seven, BooleanUtils.toIntegerObject(Boolean.FALSE, six, seven, eight)); 
     assertEquals(eight, BooleanUtils.toIntegerObject((Boolean) null, six, seven, eight)); 
     assertEquals(null, BooleanUtils.toIntegerObject((Boolean) null, six, seven, null)); 
 }
@Test
public void test_toBooleanObject_String20() { 
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
     assertEquals(Boolean.FALSE, BooleanUtils.toBooleanObject("n")); 
     assertEquals(Boolean.FALSE, BooleanUtils.toBooleanObject("N")); 
     assertEquals(null, BooleanUtils.toBooleanObject("z")); 
     assertEquals(null, BooleanUtils.toBooleanObject("ab")); 
     assertEquals(null, BooleanUtils.toBooleanObject("yoo")); 
 }
@Test(expected = IllegalArgumentException.class) 
 public void test_toBooleanObject_String_String_String_String_nullValue21() { 
     BooleanUtils.toBooleanObject((String) null, "Y", "N", "U"); 
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
public void test_toStringYesNo_Boolean27() { 
     assertEquals(null, BooleanUtils.toStringYesNo((Boolean) null)); 
     assertEquals("yes", BooleanUtils.toStringYesNo(Boolean.TRUE)); 
     assertEquals("no", BooleanUtils.toStringYesNo(Boolean.FALSE)); 
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
@Test(expected = IllegalArgumentException.class) 
 public void testAnd_primitive_nullInput30() { 
     BooleanUtils.and((boolean[]) null); 
 }
@Test(expected = IllegalArgumentException.class) 
 public void testAnd_primitive_emptyInput31() { 
     BooleanUtils.and(new boolean[] {}); 
 }
@Test(expected = IllegalArgumentException.class) 
 public void testAnd_object_nullInput32() { 
     BooleanUtils.and((Boolean[]) null); 
 }
@Test(expected = IllegalArgumentException.class) 
 public void testAnd_object_emptyInput33() { 
     BooleanUtils.and(new Boolean[] {}); 
 }
@Test(expected = IllegalArgumentException.class) 
 public void testAnd_object_nullElementInput34() { 
     BooleanUtils.and(new Boolean[] { null }); 
 }
@Test
public void testOr_primitive_validInput_2items35() { 
     assertTrue("False result for (true, true)", BooleanUtils.or(new boolean[] { true, true })); 
     assertTrue("True result for (false, false)", !BooleanUtils.or(new boolean[] { false, false })); 
     assertTrue("False result for (true, false)", BooleanUtils.or(new boolean[] { true, false })); 
     assertTrue("False result for (false, true)", BooleanUtils.or(new boolean[] { false, true })); 
 }
@Test(expected = IllegalArgumentException.class) 
 public void testOr_primitive_nullInput36() { 
     BooleanUtils.or((boolean[]) null); 
 }
@Test(expected = IllegalArgumentException.class) 
 public void testOr_primitive_emptyInput37() { 
     BooleanUtils.or(new boolean[] {}); 
 }
@Test(expected = IllegalArgumentException.class) 
 public void testOr_object_nullInput38() { 
     BooleanUtils.or((Boolean[]) null); 
 }
@Test(expected = IllegalArgumentException.class) 
 public void testOr_object_emptyInput39() { 
     BooleanUtils.or(new Boolean[] {}); 
 }
@Test(expected = IllegalArgumentException.class) 
 public void testOr_object_nullElementInput40() { 
     BooleanUtils.or(new Boolean[] { null }); 
 }
@Test
public void testOr_object_validInput_2items41() { 
     assertTrue("False result for (true, true)", BooleanUtils.or(new Boolean[] { Boolean.TRUE, Boolean.TRUE }).booleanValue()); 
     assertTrue("True result for (false, false)", !BooleanUtils.or(new Boolean[] { Boolean.FALSE, Boolean.FALSE }).booleanValue()); 
     assertTrue("False result for (true, false)", BooleanUtils.or(new Boolean[] { Boolean.TRUE, Boolean.FALSE }).booleanValue()); 
     assertTrue("False result for (false, true)", BooleanUtils.or(new Boolean[] { Boolean.FALSE, Boolean.TRUE }).booleanValue()); 
 }
@Test
public void testXor_object_validInput_3items42() { 
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
 public void testXor_primitive_nullInput43() { 
     BooleanUtils.xor((boolean[]) null); 
 }
@Test(expected = IllegalArgumentException.class) 
 public void testXor_object_nullInput44() { 
     BooleanUtils.xor((Boolean[]) null); 
 }
@Test(expected = IllegalArgumentException.class) 
 public void testXor_object_emptyInput45() { 
     BooleanUtils.xor(new Boolean[] {}); 
 }
@Test(expected = IllegalArgumentException.class) 
 public void testXor_object_nullElementInput46() { 
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
