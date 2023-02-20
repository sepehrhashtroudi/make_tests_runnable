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

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.Date;
import java.util.Map;

import org.junit.Test;

/**
 * Unit tests {@link org.apache.commons.lang3.ArrayUtils}.
 *
 * @version $Id$
 */
public class ArrayUtilsTest  {

    //-----------------------------------------------------------------------
@Test
public void testConstructor465() { 
     assertNotNull(new ArrayUtils()); 
     final Constructor<?>[] cons = ArrayUtils.class.getDeclaredConstructors(); 
     assertEquals(1, cons.length); 
     assertTrue(Modifier.isPublic(cons[0].getModifiers())); 
     assertTrue(Modifier.isPublic(ArrayUtils.class.getModifiers())); 
     assertFalse(Modifier.isFinal(ArrayUtils.class.getModifiers())); 
 }
@Test
public void testToString466() { 
     assertEquals("{}", ArrayUtils.toString(null)); 
     assertEquals("{}", ArrayUtils.toString(new Object[0])); 
     assertEquals("{}", ArrayUtils.toString(new String[0])); 
     assertEquals("{<null>}", ArrayUtils.toString(new String[] { null })); 
     assertEquals("{pink,blue}", ArrayUtils.toString(new String[] { "pink", "blue" })); 
     assertEquals("<empty>", ArrayUtils.toString(null, "<empty>")); 
     assertEquals("{}", ArrayUtils.toString(new Object[0], "<empty>")); 
     assertEquals("{}", ArrayUtils.toString(new String[0], "<empty>")); 
     assertEquals("{<null>}", ArrayUtils.toString(new String[] { null }, "<empty>")); 
     assertEquals("{pink,blue}", ArrayUtils.toString(new String[] { "pink", "blue" }, "<empty>")); 
 }
@Test
public void testHashCode467() { 
     final long[][] array1 = new long[][] { { 2, 5 }, { 4, 5 } }; 
     final long[][] array2 = new long[][] { { 2, 5 }, { 4, 6 } }; 
     assertTrue(ArrayUtils.hashCode(array1) == ArrayUtils.hashCode(array1)); 
     assertFalse(ArrayUtils.hashCode(array1) == ArrayUtils.hashCode(array2)); 
     final Object[] array3 = new Object[] { new String(new char[] { 'A', 'B' }) }; 
     final Object[] array4 = new Object[] { "AB" }; 
     assertTrue(ArrayUtils.hashCode(array3) == ArrayUtils.hashCode(array3)); 
     assertTrue(ArrayUtils.hashCode(array3) == ArrayUtils.hashCode(array4)); 
     final Object[] arrayA = new Object[] { new boolean[] { true, false }, new int[] { 6, 7 } }; 
     final Object[] arrayB = new Object[] { new boolean[] { true, false }, new int[] { 6, 7 } }; 
     assertTrue(ArrayUtils.hashCode(arrayB) == ArrayUtils.hashCode(arrayA)); 
 }
@Test
public void testSubarrayBoolean468() { 
     final boolean[] nullArray = null; 
     final boolean[] array = { true, true, false, true, false, true }; 
     final boolean[] leftSubarray = { true, true, false, true }; 
     final boolean[] midSubarray = { true, false, true, false }; 
     final boolean[] rightSubarray = { false, true, false, true }; 
     assertTrue("0 start, mid end", ArrayUtils.isEquals(leftSubarray, ArrayUtils.subarray(array, 0, 4))); 
     assertTrue("0 start, length end", ArrayUtils.isEquals(array, ArrayUtils.subarray(array, 0, array.length))); 
     assertTrue("mid start, mid end", ArrayUtils.isEquals(midSubarray, ArrayUtils.subarray(array, 1, 5))); 
     assertTrue("mid start, length end", ArrayUtils.isEquals(rightSubarray, ArrayUtils.subarray(array, 2, array.length))); 
     assertNull("null input", ArrayUtils.subarray(nullArray, 0, 3)); 
     assertEquals("empty array", ArrayUtils.EMPTY_BOOLEAN_ARRAY, ArrayUtils.subarray(ArrayUtils.EMPTY_BOOLEAN_ARRAY, 1, 2)); 
     assertEquals("start > end", ArrayUtils.EMPTY_BOOLEAN_ARRAY, ArrayUtils.subarray(array, 4, 2)); 
     assertEquals("start == end", ArrayUtils.EMPTY_BOOLEAN_ARRAY, ArrayUtils.subarray(array, 3, 3)); 
     assertTrue("start undershoot, normal end", ArrayUtils.isEquals(leftSubarray, ArrayUtils.subarray(array, -2, 4))); 
     assertEquals("start overshoot, any end", ArrayUtils.EMPTY_BOOLEAN_ARRAY, ArrayUtils.subarray(array, 33, 4)); 
     assertTrue("normal start, end overshoot", ArrayUtils.isEquals(rightSubarray, ArrayUtils.subarray(array, 2, 33))); 
     assertTrue("start undershoot, end overshoot", ArrayUtils.isEquals(array, ArrayUtils.subarray(array, -2, 12))); 
     assertSame("empty array, object test", ArrayUtils.EMPTY_BOOLEAN_ARRAY, ArrayUtils.subarray(ArrayUtils.EMPTY_BOOLEAN_ARRAY, 1, 2)); 
     assertSame("start > end, object test", ArrayUtils.EMPTY_BOOLEAN_ARRAY, ArrayUtils.subarray(array, 4, 1)); 
     assertSame("start == end, object test", ArrayUtils.EMPTY_BOOLEAN_ARRAY, ArrayUtils.subarray(array, 3, 3)); 
     assertSame("start overshoot, any end, object test", ArrayUtils.EMPTY_BOOLEAN_ARRAY, ArrayUtils.subarray(array, 8733, 4)); 
     assertSame("boolean type", boolean.class, ArrayUtils.subarray(array, 2, 4).getClass().getComponentType()); 
 }
@Test
public void testClone469() { 
     assertArrayEquals(null, ArrayUtils.clone((Object[]) null)); 
     Object[] original1 = new Object[0]; 
     Object[] cloned1 = ArrayUtils.clone(original1); 
     assertTrue(Arrays.equals(original1, cloned1)); 
     assertTrue(original1 != cloned1); 
     final StringBuffer buf = new StringBuffer("pick"); 
     original1 = new Object[] { buf, "a", new String[] { "stick" } }; 
     cloned1 = ArrayUtils.clone(original1); 
     assertTrue(Arrays.equals(original1, cloned1)); 
     assertTrue(original1 != cloned1); 
     assertSame(original1[0], cloned1[0]); 
     assertSame(original1[1], cloned1[1]); 
     assertSame(original1[2], cloned1[2]); 
 }
@Test
public void testCloneShort473() { 
     assertEquals(null, ArrayUtils.clone((short[]) null)); 
     final short[] original = new short[] { 1, 4 }; 
     final short[] cloned = ArrayUtils.clone(original); 
     assertTrue(Arrays.equals(original, cloned)); 
     assertTrue(original != cloned); 
 }
@Test
public void testCloneChar474() { 
     assertEquals(null, ArrayUtils.clone((char[]) null)); 
     final char[] original = new char[] { 'a', '4' }; 
     final char[] cloned = ArrayUtils.clone(original); 
     assertTrue(Arrays.equals(original, cloned)); 
     assertTrue(original != cloned); 
 }
@Test
public void testCloneByte475() { 
     assertEquals(null, ArrayUtils.clone((byte[]) null)); 
     final byte[] original = new byte[] { 1, 6 }; 
     final byte[] cloned = ArrayUtils.clone(original); 
     assertTrue(Arrays.equals(original, cloned)); 
     assertTrue(original != cloned); 
 }
@Test
public void testCloneBoolean477() { 
     assertEquals(null, ArrayUtils.clone((boolean[]) null)); 
     final boolean[] original = new boolean[] { true, false }; 
     final boolean[] cloned = ArrayUtils.clone(original); 
     assertTrue(Arrays.equals(original, cloned)); 
     assertTrue(original != cloned); 
 }
@Test
public void testNullToEmptyObject478() { 
     assertArrayEquals(ArrayUtils.EMPTY_OBJECT_ARRAY, ArrayUtils.nullToEmpty((Object[]) null)); 
     final Object[] original = new Object[] { Boolean.TRUE, Boolean.FALSE }; 
     assertArrayEquals(original, ArrayUtils.nullToEmpty(original)); 
     final Object[] empty = new Object[] {}; 
     final Object[] result = ArrayUtils.nullToEmpty(empty); 
     assertArrayEquals(ArrayUtils.EMPTY_OBJECT_ARRAY, result); 
     assertTrue(empty != result); 
 }
@Test
public void testNullToEmptyString479() { 
     assertArrayEquals(ArrayUtils.EMPTY_STRING_ARRAY, ArrayUtils.nullToEmpty((String[]) null)); 
     final String[] original = new String[] { "abc", "def" }; 
     assertArrayEquals(original, ArrayUtils.nullToEmpty(original)); 
     final String[] empty = new String[] {}; 
     final String[] result = ArrayUtils.nullToEmpty(empty); 
     assertArrayEquals(ArrayUtils.EMPTY_STRING_ARRAY, result); 
     assertTrue(empty != result); 
 }
@Test
public void testNullToEmptyLong480() { 
     assertEquals(ArrayUtils.EMPTY_LONG_ARRAY, ArrayUtils.nullToEmpty((long[]) null)); 
     final long[] original = new long[] { 1L, 2L }; 
     assertEquals(original, ArrayUtils.nullToEmpty(original)); 
     final long[] empty = new long[] {}; 
     final long[] result = ArrayUtils.nullToEmpty(empty); 
     assertEquals(ArrayUtils.EMPTY_LONG_ARRAY, result); 
     assertTrue(empty != result); 
 }
@Test
public void testNullToEmptyInt481() { 
     assertEquals(ArrayUtils.EMPTY_INT_ARRAY, ArrayUtils.nullToEmpty((int[]) null)); 
     final int[] original = new int[] { 1, 2 }; 
     assertEquals(original, ArrayUtils.nullToEmpty(original)); 
     final int[] empty = new int[] {}; 
     final int[] result = ArrayUtils.nullToEmpty(empty); 
     assertEquals(ArrayUtils.EMPTY_INT_ARRAY, result); 
     assertTrue(empty != result); 
 }
@Test
public void testNullToEmptyChar482() { 
     assertEquals(ArrayUtils.EMPTY_CHAR_ARRAY, ArrayUtils.nullToEmpty((char[]) null)); 
     final char[] original = new char[] { 'a', 'b' }; 
     assertEquals(original, ArrayUtils.nullToEmpty(original)); 
     final char[] empty = new char[] {}; 
     final char[] result = ArrayUtils.nullToEmpty(empty); 
     assertEquals(ArrayUtils.EMPTY_CHAR_ARRAY, result); 
     assertTrue(empty != result); 
 }
@Test
public void testNullToEmptyByte483() { 
     assertEquals(ArrayUtils.EMPTY_BYTE_ARRAY, ArrayUtils.nullToEmpty((byte[]) null)); 
     final byte[] original = new byte[] { 0x0F, 0x0E }; 
     assertEquals(original, ArrayUtils.nullToEmpty(original)); 
     final byte[] empty = new byte[] {}; 
     final byte[] result = ArrayUtils.nullToEmpty(empty); 
     assertEquals(ArrayUtils.EMPTY_BYTE_ARRAY, result); 
     assertTrue(empty != result); 
 }
@Test
public void testNullToEmptyDouble484() { 
     assertEquals(ArrayUtils.EMPTY_DOUBLE_ARRAY, ArrayUtils.nullToEmpty((double[]) null)); 
     final double[] original = new double[] { 1L, 2L }; 
     assertEquals(original, ArrayUtils.nullToEmpty(original)); 
     final double[] empty = new double[] {}; 
     final double[] result = ArrayUtils.nullToEmpty(empty); 
     assertEquals(ArrayUtils.EMPTY_DOUBLE_ARRAY, result); 
     assertTrue(empty != result); 
 }
@Test
public void testNullToEmptyFloat485() { 
     assertEquals(ArrayUtils.EMPTY_FLOAT_ARRAY, ArrayUtils.nullToEmpty((float[]) null)); 
     final float[] original = new float[] { 2.6f, 3.8f }; 
     assertEquals(original, ArrayUtils.nullToEmpty(original)); 
     final float[] empty = new float[] {}; 
     final float[] result = ArrayUtils.nullToEmpty(empty); 
     assertEquals(ArrayUtils.EMPTY_FLOAT_ARRAY, result); 
     assertTrue(empty != result); 
 }
@Test
public void testNullToEmptyBoolean486() { 
     assertEquals(ArrayUtils.EMPTY_BOOLEAN_ARRAY, ArrayUtils.nullToEmpty((boolean[]) null)); 
     final boolean[] original = new boolean[] { true, false }; 
     assertEquals(original, ArrayUtils.nullToEmpty(original)); 
     final boolean[] empty = new boolean[] {}; 
     final boolean[] result = ArrayUtils.nullToEmpty(empty); 
     assertEquals(ArrayUtils.EMPTY_BOOLEAN_ARRAY, result); 
     assertTrue(empty != result); 
 }
@Test
public void testNullToEmptyLongObject487() { 
     assertArrayEquals(ArrayUtils.EMPTY_LONG_OBJECT_ARRAY, ArrayUtils.nullToEmpty((Long[]) null)); 
     @SuppressWarnings("boxing") 
     final Long[] original = new Long[] { 1L, 2L }; 
     assertArrayEquals(original, ArrayUtils.nullToEmpty(original)); 
     final Long[] empty = new Long[] {}; 
     final Long[] result = ArrayUtils.nullToEmpty(empty); 
     assertArrayEquals(ArrayUtils.EMPTY_LONG_OBJECT_ARRAY, result); 
     assertTrue(empty != result); 
 }
@Test
public void testNullToEmptyIntObject488() { 
     assertArrayEquals(ArrayUtils.EMPTY_INTEGER_OBJECT_ARRAY, ArrayUtils.nullToEmpty((Integer[]) null)); 
     final Integer[] original = new Integer[] { 1, 2 }; 
     assertArrayEquals(original, ArrayUtils.nullToEmpty(original)); 
     final Integer[] empty = new Integer[] {}; 
     final Integer[] result = ArrayUtils.nullToEmpty(empty); 
     assertArrayEquals(ArrayUtils.EMPTY_INTEGER_OBJECT_ARRAY, result); 
     assertTrue(empty != result); 
 }
@Test
public void testNullToEmptyShortObject489() { 
     assertArrayEquals(ArrayUtils.EMPTY_SHORT_OBJECT_ARRAY, ArrayUtils.nullToEmpty((Short[]) null)); 
     @SuppressWarnings("boxing") 
     final Short[] original = new Short[] { 1, 2 }; 
     assertArrayEquals(original, ArrayUtils.nullToEmpty(original)); 
     final Short[] empty = new Short[] {}; 
     final Short[] result = ArrayUtils.nullToEmpty(empty); 
     assertArrayEquals(ArrayUtils.EMPTY_SHORT_OBJECT_ARRAY, result); 
     assertTrue(empty != result); 
 }
@Test
public void testNullToEmptyCharObject490() { 
     assertArrayEquals(ArrayUtils.EMPTY_CHARACTER_OBJECT_ARRAY, ArrayUtils.nullToEmpty((Character[]) null)); 
     final Character[] original = new Character[] { 'a', 'b' }; 
     assertArrayEquals(original, ArrayUtils.nullToEmpty(original)); 
     final Character[] empty = new Character[] {}; 
     final Character[] result = ArrayUtils.nullToEmpty(empty); 
     assertArrayEquals(ArrayUtils.EMPTY_CHARACTER_OBJECT_ARRAY, result); 
     assertTrue(empty != result); 
 }
@Test
public void testNullToEmptyByteObject491() { 
     assertArrayEquals(ArrayUtils.EMPTY_BYTE_OBJECT_ARRAY, ArrayUtils.nullToEmpty((Byte[]) null)); 
     final Byte[] original = new Byte[] { 0x0F, 0x0E }; 
     assertArrayEquals(original, ArrayUtils.nullToEmpty(original)); 
     final Byte[] empty = new Byte[] {}; 
     final Byte[] result = ArrayUtils.nullToEmpty(empty); 
     assertArrayEquals(ArrayUtils.EMPTY_BYTE_OBJECT_ARRAY, result); 
     assertTrue(empty != result); 
 }
@Test
public void testNullToEmptyDoubleObject492() { 
     assertArrayEquals(ArrayUtils.EMPTY_DOUBLE_OBJECT_ARRAY, ArrayUtils.nullToEmpty((Double[]) null)); 
     final Double[] original = new Double[] { 1D, 2D }; 
     assertArrayEquals(original, ArrayUtils.nullToEmpty(original)); 
     final Double[] empty = new Double[] {}; 
     final Double[] result = ArrayUtils.nullToEmpty(empty); 
     assertArrayEquals(ArrayUtils.EMPTY_DOUBLE_OBJECT_ARRAY, result); 
     assertTrue(empty != result); 
 }
@Test
public void testNullToEmptyFloatObject493() { 
     assertArrayEquals(ArrayUtils.EMPTY_FLOAT_OBJECT_ARRAY, ArrayUtils.nullToEmpty((Float[]) null)); 
     final Float[] original = new Float[] { 2.6f, 3.8f }; 
     assertArrayEquals(original, ArrayUtils.nullToEmpty(original)); 
     final Float[] empty = new Float[] {}; 
     final Float[] result = ArrayUtils.nullToEmpty(empty); 
     assertArrayEquals(ArrayUtils.EMPTY_FLOAT_OBJECT_ARRAY, result); 
     assertTrue(empty != result); 
 }
@Test
public void testSubarrayObject494() { 
     final Object[] nullArray = null; 
     final Object[] objectArray = { "a", "b", "c", "d", "e", "f" }; 
     assertEquals("0 start, mid end", "abcd", StringUtils.join(ArrayUtils.subarray(objectArray, 0, 4))); 
     assertEquals("0 start, length end", "abcdef", StringUtils.join(ArrayUtils.subarray(objectArray, 0, objectArray.length))); 
     assertEquals("mid start, mid end", "bcd", StringUtils.join(ArrayUtils.subarray(objectArray, 1, 4))); 
     assertEquals("mid start, length end", "bcdef", StringUtils.join(ArrayUtils.subarray(objectArray, 1, objectArray.length))); 
     assertNull("null input", ArrayUtils.subarray(nullArray, 0, 3)); 
     assertEquals("empty array", "", StringUtils.join(ArrayUtils.subarray(ArrayUtils.EMPTY_OBJECT_ARRAY, 1, 2))); 
     assertEquals("start > end", "", StringUtils.join(ArrayUtils.subarray(objectArray, 4, 2))); 
     assertEquals("start == end", "", StringUtils.join(ArrayUtils.subarray(objectArray, 3, 3))); 
     assertEquals("start undershoot, normal end", "abcd", StringUtils.join(ArrayUtils.subarray(objectArray, -2, 4))); 
     assertEquals("start overshoot, any end", "", StringUtils.join(ArrayUtils.subarray(objectArray, 33, 4))); 
     assertEquals("normal start, end overshoot", "cdef", StringUtils.join(ArrayUtils.subarray(objectArray, 2, 33))); 
     assertEquals("start undershoot, end overshoot", "abcdef", StringUtils.join(ArrayUtils.subarray(objectArray, -2, 12))); 
     final Date[] dateArray = { new java.sql.Date(new Date().getTime()), new Date(), new Date(), new Date(), new Date() }; 
     assertSame("Object type", Object.class, ArrayUtils.subarray(objectArray, 2, 4).getClass().getComponentType()); 
     assertSame("java.util.Date type", java.util.Date.class, ArrayUtils.subarray(dateArray, 1, 4).getClass().getComponentType()); 
     assertNotSame("java.sql.Date type", java.sql.Date.class, ArrayUtils.subarray(dateArray, 1, 4).getClass().getComponentType()); 
     try { 
         @SuppressWarnings("unused") 
         final java.sql.Date[] dummy = (java.sql.Date[]) ArrayUtils.subarray(dateArray, 1, 3); 
         fail("Invalid downcast"); 
     } catch (final ClassCastException e) { 
     } 
 }
@Test
public void testSubarrayInt495() { 
     final int[] nullArray = null; 
     final int[] array = { 10, 11, 12, 13, 14, 15 }; 
     final int[] leftSubarray = { 10, 11, 12, 13 }; 
     final int[] midSubarray = { 11, 12, 13, 14 }; 
     final int[] rightSubarray = { 12, 13, 14, 15 }; 
     assertTrue("0 start, mid end", ArrayUtils.isEquals(leftSubarray, ArrayUtils.subarray(array, 0, 4))); 
     assertTrue("0 start, length end", ArrayUtils.isEquals(array, ArrayUtils.subarray(array, 0, array.length))); 
     assertTrue("mid start, mid end", ArrayUtils.isEquals(midSubarray, ArrayUtils.subarray(array, 1, 5))); 
     assertTrue("mid start, length end", ArrayUtils.isEquals(rightSubarray, ArrayUtils.subarray(array, 2, array.length))); 
     assertNull("null input", ArrayUtils.subarray(nullArray, 0, 3)); 
     assertEquals("empty array", ArrayUtils.EMPTY_INT_ARRAY, ArrayUtils.subarray(ArrayUtils.EMPTY_INT_ARRAY, 1, 2)); 
     assertEquals("start > end", ArrayUtils.EMPTY_INT_ARRAY, ArrayUtils.subarray(array, 4, 2)); 
     assertEquals("start == end", ArrayUtils.EMPTY_INT_ARRAY, ArrayUtils.subarray(array, 3, 3)); 
     assertTrue("start undershoot, normal end", ArrayUtils.isEquals(leftSubarray, ArrayUtils.subarray(array, -2, 4))); 
     assertEquals("start overshoot, any end", ArrayUtils.EMPTY_INT_ARRAY, ArrayUtils.subarray(array, 33, 4)); 
     assertTrue("normal start, end overshoot", ArrayUtils.isEquals(rightSubarray, ArrayUtils.subarray(array, 2, 33))); 
     assertTrue("start undershoot, end overshoot", ArrayUtils.isEquals(array, ArrayUtils.subarray(array, -2, 12))); 
     assertSame("empty array, object test", ArrayUtils.EMPTY_INT_ARRAY, ArrayUtils.subarray(ArrayUtils.EMPTY_INT_ARRAY, 1, 2)); 
     assertSame("start > end, object test", ArrayUtils.EMPTY_INT_ARRAY, ArrayUtils.subarray(array, 4, 1)); 
     assertSame("start == end, object test", ArrayUtils.EMPTY_INT_ARRAY, ArrayUtils.subarray(array, 3, 3)); 
     assertSame("start overshoot, any end, object test", ArrayUtils.EMPTY_INT_ARRAY, ArrayUtils.subarray(array, 8733, 4)); 
     assertSame("int type", int.class, ArrayUtils.subarray(array, 2, 4).getClass().getComponentType()); 
 }
@Test
public void testSubarrayShort496() { 
     final short[] nullArray = null; 
     final short[] array = { 10, 11, 12, 13, 14, 15 }; 
     final short[] leftSubarray = { 10, 11, 12, 13 }; 
     final short[] midSubarray = { 11, 12, 13, 14 }; 
     final short[] rightSubarray = { 12, 13, 14, 15 }; 
     assertTrue("0 start, mid end", ArrayUtils.isEquals(leftSubarray, ArrayUtils.subarray(array, 0, 4))); 
     assertTrue("0 start, length end", ArrayUtils.isEquals(array, ArrayUtils.subarray(array, 0, array.length))); 
     assertTrue("mid start, mid end", ArrayUtils.isEquals(midSubarray, ArrayUtils.subarray(array, 1, 5))); 
     assertTrue("mid start, length end", ArrayUtils.isEquals(rightSubarray, ArrayUtils.subarray(array, 2, array.length))); 
     assertNull("null input", ArrayUtils.subarray(nullArray, 0, 3)); 
     assertEquals("empty array", ArrayUtils.EMPTY_SHORT_ARRAY, ArrayUtils.subarray(ArrayUtils.EMPTY_SHORT_ARRAY, 1, 2)); 
     assertEquals("start > end", ArrayUtils.EMPTY_SHORT_ARRAY, ArrayUtils.subarray(array, 4, 2)); 
     assertEquals("start == end", ArrayUtils.EMPTY_SHORT_ARRAY, ArrayUtils.subarray(array, 3, 3)); 
     assertTrue("start undershoot, normal end", ArrayUtils.isEquals(leftSubarray, ArrayUtils.subarray(array, -2, 4))); 
     assertEquals("start overshoot, any end", ArrayUtils.EMPTY_SHORT_ARRAY, ArrayUtils.subarray(array, 33, 4)); 
     assertTrue("normal start, end overshoot", ArrayUtils.isEquals(rightSubarray, ArrayUtils.subarray(array, 2, 33))); 
     assertTrue("start undershoot, end overshoot", ArrayUtils.isEquals(array, ArrayUtils.subarray(array, -2, 12))); 
     assertSame("empty array, object test", ArrayUtils.EMPTY_SHORT_ARRAY, ArrayUtils.subarray(ArrayUtils.EMPTY_SHORT_ARRAY, 1, 2)); 
     assertSame("start > end, object test", ArrayUtils.EMPTY_SHORT_ARRAY, ArrayUtils.subarray(array, 4, 1)); 
     assertSame("start == end, object test", ArrayUtils.EMPTY_SHORT_ARRAY, ArrayUtils.subarray(array, 3, 3)); 
     assertSame("start overshoot, any end, object test", ArrayUtils.EMPTY_SHORT_ARRAY, ArrayUtils.subarray(array, 8733, 4)); 
     assertSame("short type", short.class, ArrayUtils.subarray(array, 2, 4).getClass().getComponentType()); 
 }
@Test
public void testSubarrChar497() { 
     final char[] nullArray = null; 
     final char[] array = { 'a', 'b', 'c', 'd', 'e', 'f' }; 
     final char[] leftSubarray = { 'a', 'b', 'c', 'd' }; 
     final char[] midSubarray = { 'b', 'c', 'd', 'e' }; 
     final char[] rightSubarray = { 'c', 'd', 'e', 'f' }; 
     assertTrue("0 start, mid end", ArrayUtils.isEquals(leftSubarray, ArrayUtils.subarray(array, 0, 4))); 
     assertTrue("0 start, length end", ArrayUtils.isEquals(array, ArrayUtils.subarray(array, 0, array.length))); 
     assertTrue("mid start, mid end", ArrayUtils.isEquals(midSubarray, ArrayUtils.subarray(array, 1, 5))); 
     assertTrue("mid start, length end", ArrayUtils.isEquals(rightSubarray, ArrayUtils.subarray(array, 2, array.length))); 
     assertNull("null input", ArrayUtils.subarray(nullArray, 0, 3)); 
     assertEquals("empty array", ArrayUtils.EMPTY_CHAR_ARRAY, ArrayUtils.subarray(ArrayUtils.EMPTY_CHAR_ARRAY, 1, 2)); 
     assertEquals("start > end", ArrayUtils.EMPTY_CHAR_ARRAY, ArrayUtils.subarray(array, 4, 2)); 
     assertEquals("start == end", ArrayUtils.EMPTY_CHAR_ARRAY, ArrayUtils.subarray(array, 3, 3)); 
     assertTrue("start undershoot, normal end", ArrayUtils.isEquals(leftSubarray, ArrayUtils.subarray(array, -2, 4))); 
     assertEquals("start overshoot, any end", ArrayUtils.EMPTY_CHAR_ARRAY, ArrayUtils.subarray(array, 33, 4)); 
     assertTrue("normal start, end overshoot", ArrayUtils.isEquals(rightSubarray, ArrayUtils.subarray(array, 2, 33))); 
     assertTrue("start undershoot, end overshoot", ArrayUtils.isEquals(array, ArrayUtils.subarray(array, -2, 12))); 
     assertSame("empty array, object test", ArrayUtils.EMPTY_CHAR_ARRAY, ArrayUtils.subarray(ArrayUtils.EMPTY_CHAR_ARRAY, 1, 2)); 
     assertSame("start > end, object test", ArrayUtils.EMPTY_CHAR_ARRAY, ArrayUtils.subarray(array, 4, 1)); 
     assertSame("start == end, object test", ArrayUtils.EMPTY_CHAR_ARRAY, ArrayUtils.subarray(array, 3, 3)); 
     assertSame("start overshoot, any end, object test", ArrayUtils.EMPTY_CHAR_ARRAY, ArrayUtils.subarray(array, 8733, 4)); 
     assertSame("char type", char.class, ArrayUtils.subarray(array, 2, 4).getClass().getComponentType()); 
 }
@Test
public void testSubarrayByte498() { 
     final byte[] nullArray = null; 
     final byte[] array = { 10, 11, 12, 13, 14, 15 }; 
     final byte[] leftSubarray = { 10, 11, 12, 13 }; 
     final byte[] midSubarray = { 11, 12, 13, 14 }; 
     final byte[] rightSubarray = { 12, 13, 14, 15 }; 
     assertTrue("0 start, mid end", ArrayUtils.isEquals(leftSubarray, ArrayUtils.subarray(array, 0, 4))); 
     assertTrue("0 start, length end", ArrayUtils.isEquals(array, ArrayUtils.subarray(array, 0, array.length))); 
     assertTrue("mid start, mid end", ArrayUtils.isEquals(midSubarray, ArrayUtils.subarray(array, 1, 5))); 
     assertTrue("mid start, length end", ArrayUtils.isEquals(rightSubarray, ArrayUtils.subarray(array, 2, array.length))); 
     assertNull("null input", ArrayUtils.subarray(nullArray, 0, 3)); 
     assertEquals("empty array", ArrayUtils.EMPTY_BYTE_ARRAY, ArrayUtils.subarray(ArrayUtils.EMPTY_BYTE_ARRAY, 1, 2)); 
     assertEquals("start > end", ArrayUtils.EMPTY_BYTE_ARRAY, ArrayUtils.subarray(array, 4, 2)); 
     assertEquals("start == end", ArrayUtils.EMPTY_BYTE_ARRAY, ArrayUtils.subarray(array, 3, 3)); 
     assertTrue("start undershoot, normal end", ArrayUtils.isEquals(leftSubarray, ArrayUtils.subarray(array, -2, 4))); 
     assertEquals("start overshoot, any end", ArrayUtils.EMPTY_BYTE_ARRAY, ArrayUtils.subarray(array, 33, 4)); 
     assertTrue("normal start, end overshoot", ArrayUtils.isEquals(rightSubarray, ArrayUtils.subarray(array, 2, 33))); 
     assertTrue("start undershoot, end overshoot", ArrayUtils.isEquals(array, ArrayUtils.subarray(array, -2, 12))); 
     assertSame("empty array, object test", ArrayUtils.EMPTY_BYTE_ARRAY, ArrayUtils.subarray(ArrayUtils.EMPTY_BYTE_ARRAY, 1, 2)); 
     assertSame("start > end, object test", ArrayUtils.EMPTY_BYTE_ARRAY, ArrayUtils.subarray(array, 4, 1)); 
     assertSame("start == end, object test", ArrayUtils.EMPTY_BYTE_ARRAY, ArrayUtils.subarray(array, 3, 3)); 
     assertSame("start overshoot, any end, object test", ArrayUtils.EMPTY_BYTE_ARRAY, ArrayUtils.subarray(array, 8733, 4)); 
     assertSame("byte type", byte.class, ArrayUtils.subarray(array, 2, 4).getClass().getComponentType()); 
 }
@Test
public void testSubarrayDouble499() { 
     final double[] nullArray = null; 
     final double[] array = { 10.123, 11.234, 12.345, 13.456, 14.567, 15.678 }; 
     final double[] leftSubarray = { 10.123, 11.234, 12.345, 13.456 }; 
     final double[] midSubarray = { 11.234, 12.345, 13.456, 14.567 }; 
     final double[] rightSubarray = { 12.345, 13.456, 14.567, 15.678 }; 
     assertTrue("0 start, mid end", ArrayUtils.isEquals(leftSubarray, ArrayUtils.subarray(array, 0, 4))); 
     assertTrue("0 start, length end", ArrayUtils.isEquals(array, ArrayUtils.subarray(array, 0, array.length))); 
     assertTrue("mid start, mid end", ArrayUtils.isEquals(midSubarray, ArrayUtils.subarray(array, 1, 5))); 
     assertTrue("mid start, length end", ArrayUtils.isEquals(rightSubarray, ArrayUtils.subarray(array, 2, array.length))); 
     assertNull("null input", ArrayUtils.subarray(nullArray, 0, 3)); 
     assertEquals("empty array", ArrayUtils.EMPTY_DOUBLE_ARRAY, ArrayUtils.subarray(ArrayUtils.EMPTY_DOUBLE_ARRAY, 1, 2)); 
     assertEquals("start > end", ArrayUtils.EMPTY_DOUBLE_ARRAY, ArrayUtils.subarray(array, 4, 2)); 
     assertEquals("start == end", ArrayUtils.EMPTY_DOUBLE_ARRAY, ArrayUtils.subarray(array, 3, 3)); 
     assertTrue("start undershoot, normal end", ArrayUtils.isEquals(leftSubarray, ArrayUtils.subarray(array, -2, 4))); 
     assertEquals("start overshoot, any end", ArrayUtils.EMPTY_DOUBLE_ARRAY, ArrayUtils.subarray(array, 33, 4)); 
     assertTrue("normal start, end overshoot", ArrayUtils.isEquals(rightSubarray, ArrayUtils.subarray(array, 2, 33))); 
     assertTrue("start undershoot, end overshoot", ArrayUtils.isEquals(array, ArrayUtils.subarray(array, -2, 12))); 
     assertSame("empty array, object test", ArrayUtils.EMPTY_DOUBLE_ARRAY, ArrayUtils.subarray(ArrayUtils.EMPTY_DOUBLE_ARRAY, 1, 2)); 
     assertSame("start > end, object test", ArrayUtils.EMPTY_DOUBLE_ARRAY, ArrayUtils.subarray(array, 4, 1)); 
     assertSame("start == end, object test", ArrayUtils.EMPTY_DOUBLE_ARRAY, ArrayUtils.subarray(array, 3, 3)); 
     assertSame("start overshoot, any end, object test", ArrayUtils.EMPTY_DOUBLE_ARRAY, ArrayUtils.subarray(array, 8733, 4)); 
     assertSame("double type", double.class, ArrayUtils.subarray(array, 2, 4).getClass().getComponentType()); 
 }
@Test
public void testSubarrayFloat500() { 
     final float[] nullArray = null; 
     final float[] array = { 10, 11, 12, 13, 14, 15 }; 
     final float[] leftSubarray = { 10, 11, 12, 13 }; 
     final float[] midSubarray = { 11, 12, 13, 14 }; 
     final float[] rightSubarray = { 12, 13, 14, 15 }; 
     assertTrue("0 start, mid end", ArrayUtils.isEquals(leftSubarray, ArrayUtils.subarray(array, 0, 4))); 
     assertTrue("0 start, length end", ArrayUtils.isEquals(array, ArrayUtils.subarray(array, 0, array.length))); 
     assertTrue("mid start, mid end", ArrayUtils.isEquals(midSubarray, ArrayUtils.subarray(array, 1, 5))); 
     assertTrue("mid start, length end", ArrayUtils.isEquals(rightSubarray, ArrayUtils.subarray(array, 2, array.length))); 
     assertNull("null input", ArrayUtils.subarray(nullArray, 0, 3)); 
     assertEquals("empty array", ArrayUtils.EMPTY_FLOAT_ARRAY, ArrayUtils.subarray(ArrayUtils.EMPTY_FLOAT_ARRAY, 1, 2)); 
     assertEquals("start > end", ArrayUtils.EMPTY_FLOAT_ARRAY, ArrayUtils.subarray(array, 4, 2)); 
     assertEquals("start == end", ArrayUtils.EMPTY_FLOAT_ARRAY, ArrayUtils.subarray(array, 3, 3)); 
     assertTrue("start undershoot, normal end", ArrayUtils.isEquals(leftSubarray, ArrayUtils.subarray(array, -2, 4))); 
     assertEquals("start overshoot, any end", ArrayUtils.EMPTY_FLOAT_ARRAY, ArrayUtils.subarray(array, 33, 4)); 
     assertTrue("normal start, end overshoot", ArrayUtils.isEquals(rightSubarray, ArrayUtils.subarray(array, 2, 33))); 
     assertTrue("start undershoot, end overshoot", ArrayUtils.isEquals(array, ArrayUtils.subarray(array, -2, 12))); 
     assertSame("empty array, object test", ArrayUtils.EMPTY_FLOAT_ARRAY, ArrayUtils.subarray(ArrayUtils.EMPTY_FLOAT_ARRAY, 1, 2)); 
     assertSame("start > end, object test", ArrayUtils.EMPTY_FLOAT_ARRAY, ArrayUtils.subarray(array, 4, 1)); 
     assertSame("start == end, object test", ArrayUtils.EMPTY_FLOAT_ARRAY, ArrayUtils.subarray(array, 3, 3)); 
     assertSame("start overshoot, any end, object test", ArrayUtils.EMPTY_FLOAT_ARRAY, ArrayUtils.subarray(array, 8733, 4)); 
     assertSame("float type", float.class, ArrayUtils.subarray(array, 2, 4).getClass().getComponentType()); 
 }
@Test
public void testSameLength501() { 
     final Object[] nullArray = null; 
     final Object[] emptyArray = new Object[0]; 
     final Object[] oneArray = new Object[] { "pick" }; 
     final Object[] twoArray = new Object[] { "pick", "stick" }; 
     assertTrue(ArrayUtils.isSameLength(nullArray, nullArray)); 
     assertTrue(ArrayUtils.isSameLength(nullArray, emptyArray)); 
     assertFalse(ArrayUtils.isSameLength(nullArray, oneArray)); 
     assertFalse(ArrayUtils.isSameLength(nullArray, twoArray)); 
     assertTrue(ArrayUtils.isSameLength(emptyArray, nullArray)); 
     assertTrue(ArrayUtils.isSameLength(emptyArray, emptyArray)); 
     assertFalse(ArrayUtils.isSameLength(emptyArray, oneArray)); 
     assertFalse(ArrayUtils.isSameLength(emptyArray, twoArray)); 
     assertFalse(ArrayUtils.isSameLength(oneArray, nullArray)); 
     assertFalse(ArrayUtils.isSameLength(oneArray, emptyArray)); 
     assertTrue(ArrayUtils.isSameLength(oneArray, oneArray)); 
     assertFalse(ArrayUtils.isSameLength(oneArray, twoArray)); 
     assertFalse(ArrayUtils.isSameLength(twoArray, nullArray)); 
     assertFalse(ArrayUtils.isSameLength(twoArray, emptyArray)); 
     assertFalse(ArrayUtils.isSameLength(twoArray, oneArray)); 
     assertTrue(ArrayUtils.isSameLength(twoArray, twoArray)); 
 }
@Test
public void testSameLengthLong502() { 
     final long[] nullArray = null; 
     final long[] emptyArray = new long[0]; 
     final long[] oneArray = new long[] { 0L }; 
     final long[] twoArray = new long[] { 0L, 76L }; 
     assertTrue(ArrayUtils.isSameLength(nullArray, nullArray)); 
     assertTrue(ArrayUtils.isSameLength(nullArray, emptyArray)); 
     assertFalse(ArrayUtils.isSameLength(nullArray, oneArray)); 
     assertFalse(ArrayUtils.isSameLength(nullArray, twoArray)); 
     assertTrue(ArrayUtils.isSameLength(emptyArray, nullArray)); 
     assertTrue(ArrayUtils.isSameLength(emptyArray, emptyArray)); 
     assertFalse(ArrayUtils.isSameLength(emptyArray, oneArray)); 
     assertFalse(ArrayUtils.isSameLength(emptyArray, twoArray)); 
     assertFalse(ArrayUtils.isSameLength(oneArray, nullArray)); 
     assertFalse(ArrayUtils.isSameLength(oneArray, emptyArray)); 
     assertTrue(ArrayUtils.isSameLength(oneArray, oneArray)); 
     assertFalse(ArrayUtils.isSameLength(oneArray, twoArray)); 
     assertFalse(ArrayUtils.isSameLength(twoArray, nullArray)); 
     assertFalse(ArrayUtils.isSameLength(twoArray, emptyArray)); 
     assertFalse(ArrayUtils.isSameLength(twoArray, oneArray)); 
     assertTrue(ArrayUtils.isSameLength(twoArray, twoArray)); 
 }
@Test
public void testSameLengthInt503() { 
     final int[] nullArray = null; 
     final int[] emptyArray = new int[0]; 
     final int[] oneArray = new int[] { 4 }; 
     final int[] twoArray = new int[] { 5, 7 }; 
     assertTrue(ArrayUtils.isSameLength(nullArray, nullArray)); 
     assertTrue(ArrayUtils.isSameLength(nullArray, emptyArray)); 
     assertFalse(ArrayUtils.isSameLength(nullArray, oneArray)); 
     assertFalse(ArrayUtils.isSameLength(nullArray, twoArray)); 
     assertTrue(ArrayUtils.isSameLength(emptyArray, nullArray)); 
     assertTrue(ArrayUtils.isSameLength(emptyArray, emptyArray)); 
     assertFalse(ArrayUtils.isSameLength(emptyArray, oneArray)); 
     assertFalse(ArrayUtils.isSameLength(emptyArray, twoArray)); 
     assertFalse(ArrayUtils.isSameLength(oneArray, nullArray)); 
     assertFalse(ArrayUtils.isSameLength(oneArray, emptyArray)); 
     assertTrue(ArrayUtils.isSameLength(oneArray, oneArray)); 
     assertFalse(ArrayUtils.isSameLength(oneArray, twoArray)); 
     assertFalse(ArrayUtils.isSameLength(twoArray, nullArray)); 
     assertFalse(ArrayUtils.isSameLength(twoArray, emptyArray)); 
     assertFalse(ArrayUtils.isSameLength(twoArray, oneArray)); 
     assertTrue(ArrayUtils.isSameLength(twoArray, twoArray)); 
 }
@Test
public void testSameLengthShort504() { 
     final short[] nullArray = null; 
     final short[] emptyArray = new short[0]; 
     final short[] oneArray = new short[] { 4 }; 
     final short[] twoArray = new short[] { 6, 8 }; 
     assertTrue(ArrayUtils.isSameLength(nullArray, nullArray)); 
     assertTrue(ArrayUtils.isSameLength(nullArray, emptyArray)); 
     assertFalse(ArrayUtils.isSameLength(nullArray, oneArray)); 
     assertFalse(ArrayUtils.isSameLength(nullArray, twoArray)); 
     assertTrue(ArrayUtils.isSameLength(emptyArray, nullArray)); 
     assertTrue(ArrayUtils.isSameLength(emptyArray, emptyArray)); 
     assertFalse(ArrayUtils.isSameLength(emptyArray, oneArray)); 
     assertFalse(ArrayUtils.isSameLength(emptyArray, twoArray)); 
     assertFalse(ArrayUtils.isSameLength(oneArray, nullArray)); 
     assertFalse(ArrayUtils.isSameLength(oneArray, emptyArray)); 
     assertTrue(ArrayUtils.isSameLength(oneArray, oneArray)); 
     assertFalse(ArrayUtils.isSameLength(oneArray, twoArray)); 
     assertFalse(ArrayUtils.isSameLength(twoArray, nullArray)); 
     assertFalse(ArrayUtils.isSameLength(twoArray, emptyArray)); 
     assertFalse(ArrayUtils.isSameLength(twoArray, oneArray)); 
     assertTrue(ArrayUtils.isSameLength(twoArray, twoArray)); 
 }
@Test
public void testSameLengthChar505() { 
     final char[] nullArray = null; 
     final char[] emptyArray = new char[0]; 
     final char[] oneArray = new char[] { 'f' }; 
     final char[] twoArray = new char[] { 'd', 't' }; 
     assertTrue(ArrayUtils.isSameLength(nullArray, nullArray)); 
     assertTrue(ArrayUtils.isSameLength(nullArray, emptyArray)); 
     assertFalse(ArrayUtils.isSameLength(nullArray, oneArray)); 
     assertFalse(ArrayUtils.isSameLength(nullArray, twoArray)); 
     assertTrue(ArrayUtils.isSameLength(emptyArray, nullArray)); 
     assertTrue(ArrayUtils.isSameLength(emptyArray, emptyArray)); 
     assertFalse(ArrayUtils.isSameLength(emptyArray, oneArray)); 
     assertFalse(ArrayUtils.isSameLength(emptyArray, twoArray)); 
     assertFalse(ArrayUtils.isSameLength(oneArray, nullArray)); 
     assertFalse(ArrayUtils.isSameLength(oneArray, emptyArray)); 
     assertTrue(ArrayUtils.isSameLength(oneArray, oneArray)); 
     assertFalse(ArrayUtils.isSameLength(oneArray, twoArray)); 
     assertFalse(ArrayUtils.isSameLength(twoArray, nullArray)); 
     assertFalse(ArrayUtils.isSameLength(twoArray, emptyArray)); 
     assertFalse(ArrayUtils.isSameLength(twoArray, oneArray)); 
     assertTrue(ArrayUtils.isSameLength(twoArray, twoArray)); 
 }
@Test
public void testSameLengthBoolean506() { 
     final boolean[] nullArray = null; 
     final boolean[] emptyArray = new boolean[0]; 
     final boolean[] oneArray = new boolean[] { true }; 
     final boolean[] twoArray = new boolean[] { true, false }; 
     assertTrue(ArrayUtils.isSameLength(nullArray, nullArray)); 
     assertTrue(ArrayUtils.isSameLength(nullArray, emptyArray)); 
     assertFalse(ArrayUtils.isSameLength(nullArray, oneArray)); 
     assertFalse(ArrayUtils.isSameLength(nullArray, twoArray)); 
     assertTrue(ArrayUtils.isSameLength(emptyArray, nullArray)); 
     assertTrue(ArrayUtils.isSameLength(emptyArray, emptyArray)); 
     assertFalse(ArrayUtils.isSameLength(emptyArray, oneArray)); 
     assertFalse(ArrayUtils.isSameLength(emptyArray, twoArray)); 
     assertFalse(ArrayUtils.isSameLength(oneArray, nullArray)); 
     assertFalse(ArrayUtils.isSameLength(oneArray, emptyArray)); 
     assertTrue(ArrayUtils.isSameLength(oneArray, oneArray)); 
     assertFalse(ArrayUtils.isSameLength(oneArray, twoArray)); 
     assertFalse(ArrayUtils.isSameLength(twoArray, nullArray)); 
     assertFalse(ArrayUtils.isSameLength(twoArray, emptyArray)); 
     assertFalse(ArrayUtils.isSameLength(twoArray, oneArray)); 
     assertTrue(ArrayUtils.isSameLength(twoArray, twoArray)); 
 }
@Test
public void testSameType508() { 
     try { 
         ArrayUtils.isSameType(null, null); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
     try { 
         ArrayUtils.isSameType(null, new Object[0]); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
     try { 
         ArrayUtils.isSameType(new Object[0], null); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
     assertTrue(ArrayUtils.isSameType(new Object[0], new Object[0])); 
     assertFalse(ArrayUtils.isSameType(new String[0], new Object[0])); 
     assertTrue(ArrayUtils.isSameType(new String[0][0], new String[0][0])); 
     assertFalse(ArrayUtils.isSameType(new String[0], new String[0][0])); 
     assertFalse(ArrayUtils.isSameType(new String[0][0], new String[0])); 
 }
@Test
public void testReverse509() { 
     final StringBuffer str1 = new StringBuffer("pick"); 
     final String str2 = "a"; 
     final String[] str3 = new String[] { "stick" }; 
     final String str4 = "up"; 
     Object[] array = new Object[] { str1, str2, str3 }; 
     ArrayUtils.reverse(array); 
     assertEquals(array[0], str3); 
     assertEquals(array[1], str2); 
     assertEquals(array[2], str1); 
     array = new Object[] { str1, str2, str3, str4 }; 
     ArrayUtils.reverse(array); 
     assertEquals(array[0], str4); 
     assertEquals(array[1], str3); 
     assertEquals(array[2], str2); 
     assertEquals(array[3], str1); 
     array = null; 
     ArrayUtils.reverse(array); 
     assertArrayEquals(null, array); 
 }
@Test
public void testReverseLong510() { 
     long[] array = new long[] { 1L, 2L, 3L }; 
     ArrayUtils.reverse(array); 
     assertEquals(array[0], 3L); 
     assertEquals(array[1], 2L); 
     assertEquals(array[2], 1L); 
     array = null; 
     ArrayUtils.reverse(array); 
     assertEquals(null, array); 
 }
@Test
public void testReverseShort511() { 
     short[] array = new short[] { 1, 2, 3 }; 
     ArrayUtils.reverse(array); 
     assertEquals(array[0], 3); 
     assertEquals(array[1], 2); 
     assertEquals(array[2], 1); 
     array = null; 
     ArrayUtils.reverse(array); 
     assertEquals(null, array); 
 }
@Test
public void testReverseChar512() { 
     char[] array = new char[] { 'a', 'f', 'C' }; 
     ArrayUtils.reverse(array); 
     assertEquals(array[0], 'C'); 
     assertEquals(array[1], 'f'); 
     assertEquals(array[2], 'a'); 
     array = null; 
     ArrayUtils.reverse(array); 
     assertEquals(null, array); 
 }
@Test
public void testReverseByte513() { 
     byte[] array = new byte[] { 2, 3, 4 }; 
     ArrayUtils.reverse(array); 
     assertEquals(array[0], 4); 
     assertEquals(array[1], 3); 
     assertEquals(array[2], 2); 
     array = null; 
     ArrayUtils.reverse(array); 
     assertEquals(null, array); 
 }
@Test
public void testReverseDouble514() { 
     double[] array = new double[] { 0.3d, 0.4d, 0.5d }; 
     ArrayUtils.reverse(array); 
     assertEquals(array[0], 0.5d, 0.0d); 
     assertEquals(array[1], 0.4d, 0.0d); 
     assertEquals(array[2], 0.3d, 0.0d); 
     array = null; 
     ArrayUtils.reverse(array); 
     assertEquals(null, array); 
 }
@Test
public void testReverseFloat515() { 
     float[] array = new float[] { 0.3f, 0.4f, 0.5f }; 
     ArrayUtils.reverse(array); 
     assertEquals(array[0], 0.5f, 0.0f); 
     assertEquals(array[1], 0.4f, 0.0f); 
     assertEquals(array[2], 0.3f, 0.0f); 
     array = null; 
     ArrayUtils.reverse(array); 
     assertEquals(null, array); 
 }
@Test
public void testReverseBoolean516() { 
     boolean[] array = new boolean[] { false, false, true }; 
     ArrayUtils.reverse(array); 
     assertTrue(array[0]); 
     assertFalse(array[1]); 
     assertFalse(array[2]); 
     array = null; 
     ArrayUtils.reverse(array); 
     assertEquals(null, array); 
 }
@Test
public void testIndexOfWithStartIndex517() { 
     final Object[] array = new Object[] { "0", "1", "2", "3", null, "0" }; 
     assertEquals(-1, ArrayUtils.indexOf(null, null, 2)); 
     assertEquals(-1, ArrayUtils.indexOf(new Object[0], "0", 0)); 
     assertEquals(-1, ArrayUtils.indexOf(null, "0", 2)); 
     assertEquals(5, ArrayUtils.indexOf(array, "0", 2)); 
     assertEquals(-1, ArrayUtils.indexOf(array, "1", 2)); 
     assertEquals(2, ArrayUtils.indexOf(array, "2", 2)); 
     assertEquals(3, ArrayUtils.indexOf(array, "3", 2)); 
     assertEquals(4, ArrayUtils.indexOf(array, null, 2)); 
     assertEquals(-1, ArrayUtils.indexOf(array, "notInArray", 2)); 
     assertEquals(4, ArrayUtils.indexOf(array, null, -1)); 
     assertEquals(-1, ArrayUtils.indexOf(array, null, 8)); 
     assertEquals(-1, ArrayUtils.indexOf(array, "0", 8)); 
 }
@Test
public void testLastIndexOf518() { 
     final Object[] array = new Object[] { "0", "1", "2", "3", null, "0" }; 
     assertEquals(-1, ArrayUtils.lastIndexOf(null, null)); 
     assertEquals(-1, ArrayUtils.lastIndexOf(null, "0")); 
     assertEquals(5, ArrayUtils.lastIndexOf(array, "0")); 
     assertEquals(1, ArrayUtils.lastIndexOf(array, "1")); 
     assertEquals(2, ArrayUtils.lastIndexOf(array, "2")); 
     assertEquals(3, ArrayUtils.lastIndexOf(array, "3")); 
     assertEquals(4, ArrayUtils.lastIndexOf(array, null)); 
     assertEquals(-1, ArrayUtils.lastIndexOf(array, "notInArray")); 
 }
@Test
public void testLastIndexOfWithStartIndex519() { 
     final Object[] array = new Object[] { "0", "1", "2", "3", null, "0" }; 
     assertEquals(-1, ArrayUtils.lastIndexOf(null, null, 2)); 
     assertEquals(-1, ArrayUtils.lastIndexOf(null, "0", 2)); 
     assertEquals(0, ArrayUtils.lastIndexOf(array, "0", 2)); 
     assertEquals(1, ArrayUtils.lastIndexOf(array, "1", 2)); 
     assertEquals(2, ArrayUtils.lastIndexOf(array, "2", 2)); 
     assertEquals(-1, ArrayUtils.lastIndexOf(array, "3", 2)); 
     assertEquals(-1, ArrayUtils.lastIndexOf(array, "3", -1)); 
     assertEquals(4, ArrayUtils.lastIndexOf(array, null, 5)); 
     assertEquals(-1, ArrayUtils.lastIndexOf(array, null, 2)); 
     assertEquals(-1, ArrayUtils.lastIndexOf(array, "notInArray", 5)); 
     assertEquals(-1, ArrayUtils.lastIndexOf(array, null, -1)); 
     assertEquals(5, ArrayUtils.lastIndexOf(array, "0", 88)); 
 }
@Test
public void testContains520() { 
     final Object[] array = new Object[] { "0", "1", "2", "3", null, "0" }; 
     assertFalse(ArrayUtils.contains(null, null)); 
     assertFalse(ArrayUtils.contains(null, "1")); 
     assertTrue(ArrayUtils.contains(array, "0")); 
     assertTrue(ArrayUtils.contains(array, "1")); 
     assertTrue(ArrayUtils.contains(array, "2")); 
     assertTrue(ArrayUtils.contains(array, "3")); 
     assertTrue(ArrayUtils.contains(array, null)); 
     assertFalse(ArrayUtils.contains(array, "notInArray")); 
 }
@Test
public void testIndexOfLongWithStartIndex521() { 
     long[] array = null; 
     assertEquals(-1, ArrayUtils.indexOf(array, 0, 2)); 
     array = new long[] { 0, 1, 2, 3, 0 }; 
     assertEquals(4, ArrayUtils.indexOf(array, 0, 2)); 
     assertEquals(-1, ArrayUtils.indexOf(array, 1, 2)); 
     assertEquals(2, ArrayUtils.indexOf(array, 2, 2)); 
     assertEquals(3, ArrayUtils.indexOf(array, 3, 2)); 
     assertEquals(3, ArrayUtils.indexOf(array, 3, -1)); 
     assertEquals(-1, ArrayUtils.indexOf(array, 99, 0)); 
     assertEquals(-1, ArrayUtils.indexOf(array, 0, 6)); 
 }
@Test
public void testLastIndexOfLong522() { 
     long[] array = null; 
     assertEquals(-1, ArrayUtils.lastIndexOf(array, 0)); 
     array = new long[] { 0, 1, 2, 3, 0 }; 
     assertEquals(4, ArrayUtils.lastIndexOf(array, 0)); 
     assertEquals(1, ArrayUtils.lastIndexOf(array, 1)); 
     assertEquals(2, ArrayUtils.lastIndexOf(array, 2)); 
     assertEquals(3, ArrayUtils.lastIndexOf(array, 3)); 
     assertEquals(-1, ArrayUtils.lastIndexOf(array, 99)); 
 }
@Test
public void testLastIndexOfLongWithStartIndex523() { 
     long[] array = null; 
     assertEquals(-1, ArrayUtils.lastIndexOf(array, 0, 2)); 
     array = new long[] { 0, 1, 2, 3, 0 }; 
     assertEquals(0, ArrayUtils.lastIndexOf(array, 0, 2)); 
     assertEquals(1, ArrayUtils.lastIndexOf(array, 1, 2)); 
     assertEquals(2, ArrayUtils.lastIndexOf(array, 2, 2)); 
     assertEquals(-1, ArrayUtils.lastIndexOf(array, 3, 2)); 
     assertEquals(-1, ArrayUtils.lastIndexOf(array, 3, -1)); 
     assertEquals(-1, ArrayUtils.lastIndexOf(array, 99, 4)); 
     assertEquals(4, ArrayUtils.lastIndexOf(array, 0, 88)); 
 }
@Test
public void testContainsLong524() { 
     long[] array = null; 
     assertFalse(ArrayUtils.contains(array, 1)); 
     array = new long[] { 0, 1, 2, 3, 0 }; 
     assertTrue(ArrayUtils.contains(array, 0)); 
     assertTrue(ArrayUtils.contains(array, 1)); 
     assertTrue(ArrayUtils.contains(array, 2)); 
     assertTrue(ArrayUtils.contains(array, 3)); 
     assertFalse(ArrayUtils.contains(array, 99)); 
 }
@Test
public void testIndexOfInt525() { 
     int[] array = null; 
     assertEquals(-1, ArrayUtils.indexOf(array, 0)); 
     array = new int[] { 0, 1, 2, 3, 0 }; 
     assertEquals(0, ArrayUtils.indexOf(array, 0)); 
     assertEquals(1, ArrayUtils.indexOf(array, 1)); 
     assertEquals(2, ArrayUtils.indexOf(array, 2)); 
     assertEquals(3, ArrayUtils.indexOf(array, 3)); 
     assertEquals(-1, ArrayUtils.indexOf(array, 99)); 
 }
@Test
public void testIndexOfIntWithStartIndex526() { 
     int[] array = null; 
     assertEquals(-1, ArrayUtils.indexOf(array, 0, 2)); 
     array = new int[] { 0, 1, 2, 3, 0 }; 
     assertEquals(4, ArrayUtils.indexOf(array, 0, 2)); 
     assertEquals(-1, ArrayUtils.indexOf(array, 1, 2)); 
     assertEquals(2, ArrayUtils.indexOf(array, 2, 2)); 
     assertEquals(3, ArrayUtils.indexOf(array, 3, 2)); 
     assertEquals(3, ArrayUtils.indexOf(array, 3, -1)); 
     assertEquals(-1, ArrayUtils.indexOf(array, 99, 0)); 
     assertEquals(-1, ArrayUtils.indexOf(array, 0, 6)); 
 }
@Test
public void testLastIndexOfIntWithStartIndex527() { 
     int[] array = null; 
     assertEquals(-1, ArrayUtils.lastIndexOf(array, 0, 2)); 
     array = new int[] { 0, 1, 2, 3, 0 }; 
     assertEquals(0, ArrayUtils.lastIndexOf(array, 0, 2)); 
     assertEquals(1, ArrayUtils.lastIndexOf(array, 1, 2)); 
     assertEquals(2, ArrayUtils.lastIndexOf(array, 2, 2)); 
     assertEquals(-1, ArrayUtils.lastIndexOf(array, 3, 2)); 
     assertEquals(-1, ArrayUtils.lastIndexOf(array, 3, -1)); 
     assertEquals(-1, ArrayUtils.lastIndexOf(array, 99)); 
     assertEquals(4, ArrayUtils.lastIndexOf(array, 0, 88)); 
 }
@Test
public void testContainsInt528() { 
     int[] array = null; 
     assertFalse(ArrayUtils.contains(array, 1)); 
     array = new int[] { 0, 1, 2, 3, 0 }; 
     assertTrue(ArrayUtils.contains(array, 0)); 
     assertTrue(ArrayUtils.contains(array, 1)); 
     assertTrue(ArrayUtils.contains(array, 2)); 
     assertTrue(ArrayUtils.contains(array, 3)); 
     assertFalse(ArrayUtils.contains(array, 99)); 
 }
@Test
public void testIndexOfShort529() { 
     short[] array = null; 
     assertEquals(-1, ArrayUtils.indexOf(array, (short) 0)); 
     array = new short[] { 0, 1, 2, 3, 0 }; 
     assertEquals(0, ArrayUtils.indexOf(array, (short) 0)); 
     assertEquals(1, ArrayUtils.indexOf(array, (short) 1)); 
     assertEquals(2, ArrayUtils.indexOf(array, (short) 2)); 
     assertEquals(3, ArrayUtils.indexOf(array, (short) 3)); 
     assertEquals(-1, ArrayUtils.indexOf(array, (short) 99)); 
 }
@Test
public void testIndexOfShortWithStartIndex530() { 
     short[] array = null; 
     assertEquals(-1, ArrayUtils.indexOf(array, (short) 0, 2)); 
     array = new short[] { 0, 1, 2, 3, 0 }; 
     assertEquals(4, ArrayUtils.indexOf(array, (short) 0, 2)); 
     assertEquals(-1, ArrayUtils.indexOf(array, (short) 1, 2)); 
     assertEquals(2, ArrayUtils.indexOf(array, (short) 2, 2)); 
     assertEquals(3, ArrayUtils.indexOf(array, (short) 3, 2)); 
     assertEquals(3, ArrayUtils.indexOf(array, (short) 3, -1)); 
     assertEquals(-1, ArrayUtils.indexOf(array, (short) 99, 0)); 
     assertEquals(-1, ArrayUtils.indexOf(array, (short) 0, 6)); 
 }
@Test
public void testIndexOfChar531() { 
     char[] array = null; 
     assertEquals(-1, ArrayUtils.indexOf(array, 'a')); 
     array = new char[] { 'a', 'b', 'c', 'd', 'a' }; 
     assertEquals(0, ArrayUtils.indexOf(array, 'a')); 
     assertEquals(1, ArrayUtils.indexOf(array, 'b')); 
     assertEquals(2, ArrayUtils.indexOf(array, 'c')); 
     assertEquals(3, ArrayUtils.indexOf(array, 'd')); 
     assertEquals(-1, ArrayUtils.indexOf(array, 'e')); 
 }
@Test
public void testIndexOfCharWithStartIndex532() { 
     char[] array = null; 
     assertEquals(-1, ArrayUtils.indexOf(array, 'a', 2)); 
     array = new char[] { 'a', 'b', 'c', 'd', 'a' }; 
     assertEquals(4, ArrayUtils.indexOf(array, 'a', 2)); 
     assertEquals(-1, ArrayUtils.indexOf(array, 'b', 2)); 
     assertEquals(2, ArrayUtils.indexOf(array, 'c', 2)); 
     assertEquals(3, ArrayUtils.indexOf(array, 'd', 2)); 
     assertEquals(3, ArrayUtils.indexOf(array, 'd', -1)); 
     assertEquals(-1, ArrayUtils.indexOf(array, 'e', 0)); 
     assertEquals(-1, ArrayUtils.indexOf(array, 'a', 6)); 
 }
@Test
public void testLastIndexOfCharWithStartIndex533() { 
     char[] array = null; 
     assertEquals(-1, ArrayUtils.lastIndexOf(array, 'a', 2)); 
     array = new char[] { 'a', 'b', 'c', 'd', 'a' }; 
     assertEquals(0, ArrayUtils.lastIndexOf(array, 'a', 2)); 
     assertEquals(1, ArrayUtils.lastIndexOf(array, 'b', 2)); 
     assertEquals(2, ArrayUtils.lastIndexOf(array, 'c', 2)); 
     assertEquals(-1, ArrayUtils.lastIndexOf(array, 'd', 2)); 
     assertEquals(-1, ArrayUtils.lastIndexOf(array, 'd', -1)); 
     assertEquals(-1, ArrayUtils.lastIndexOf(array, 'e')); 
     assertEquals(4, ArrayUtils.lastIndexOf(array, 'a', 88)); 
 }
@Test
public void testIndexOfByte534() { 
     byte[] array = null; 
     assertEquals(-1, ArrayUtils.indexOf(array, (byte) 0)); 
     array = new byte[] { 0, 1, 2, 3, 0 }; 
     assertEquals(0, ArrayUtils.indexOf(array, (byte) 0)); 
     assertEquals(1, ArrayUtils.indexOf(array, (byte) 1)); 
     assertEquals(2, ArrayUtils.indexOf(array, (byte) 2)); 
     assertEquals(3, ArrayUtils.indexOf(array, (byte) 3)); 
     assertEquals(-1, ArrayUtils.indexOf(array, (byte) 99)); 
 }
@Test
public void testLastIndexOfByteWithStartIndex535() { 
     byte[] array = null; 
     assertEquals(-1, ArrayUtils.lastIndexOf(array, (byte) 0, 2)); 
     array = new byte[] { 0, 1, 2, 3, 0 }; 
     assertEquals(0, ArrayUtils.lastIndexOf(array, (byte) 0, 2)); 
     assertEquals(1, ArrayUtils.lastIndexOf(array, (byte) 1, 2)); 
     assertEquals(2, ArrayUtils.lastIndexOf(array, (byte) 2, 2)); 
     assertEquals(-1, ArrayUtils.lastIndexOf(array, (byte) 3, 2)); 
     assertEquals(-1, ArrayUtils.lastIndexOf(array, (byte) 3, -1)); 
     assertEquals(-1, ArrayUtils.lastIndexOf(array, (byte) 99)); 
     assertEquals(4, ArrayUtils.lastIndexOf(array, (byte) 0, 88)); 
 }
@Test
public void testContainsByte536() { 
     byte[] array = null; 
     assertFalse(ArrayUtils.contains(array, (byte) 1)); 
     array = new byte[] { 0, 1, 2, 3, 0 }; 
     assertTrue(ArrayUtils.contains(array, (byte) 0)); 
     assertTrue(ArrayUtils.contains(array, (byte) 1)); 
     assertTrue(ArrayUtils.contains(array, (byte) 2)); 
     assertTrue(ArrayUtils.contains(array, (byte) 3)); 
     assertFalse(ArrayUtils.contains(array, (byte) 99)); 
 } 
@SuppressWarnings("cast")
@Test
public void testIndexOfDouble537() { 
     double[] array = null; 
     assertEquals(-1, ArrayUtils.indexOf(array, (double) 0)); 
     array = new double[0]; 
     assertEquals(-1, ArrayUtils.indexOf(array, (double) 0)); 
     array = new double[] { 0, 1, 2, 3, 0 }; 
     assertEquals(0, ArrayUtils.indexOf(array, (double) 0)); 
     assertEquals(1, ArrayUtils.indexOf(array, (double) 1)); 
     assertEquals(2, ArrayUtils.indexOf(array, (double) 2)); 
     assertEquals(3, ArrayUtils.indexOf(array, (double) 3)); 
     assertEquals(3, ArrayUtils.indexOf(array, (double) 3, -1)); 
     assertEquals(-1, ArrayUtils.indexOf(array, (double) 99)); 
 } 
@SuppressWarnings("cast")
@Test
public void testLastIndexOfDouble539() { 
     double[] array = null; 
     assertEquals(-1, ArrayUtils.lastIndexOf(array, (double) 0)); 
     array = new double[0]; 
     assertEquals(-1, ArrayUtils.lastIndexOf(array, (double) 0)); 
     array = new double[] { 0, 1, 2, 3, 0 }; 
     assertEquals(4, ArrayUtils.lastIndexOf(array, (double) 0)); 
     assertEquals(1, ArrayUtils.lastIndexOf(array, (double) 1)); 
     assertEquals(2, ArrayUtils.lastIndexOf(array, (double) 2)); 
     assertEquals(3, ArrayUtils.lastIndexOf(array, (double) 3)); 
     assertEquals(-1, ArrayUtils.lastIndexOf(array, (double) 99)); 
 } 
@SuppressWarnings("cast")
@Test
public void testLastIndexOfDoubleTolerance540() { 
     double[] array = null; 
     assertEquals(-1, ArrayUtils.lastIndexOf(array, (double) 0, (double) 0)); 
     array = new double[0]; 
     assertEquals(-1, ArrayUtils.lastIndexOf(array, (double) 0, (double) 0)); 
     array = new double[] { 0, 1, 2, 3, 0 }; 
     assertEquals(4, ArrayUtils.lastIndexOf(array, (double) 0, (double) 0.3)); 
     assertEquals(2, ArrayUtils.lastIndexOf(array, (double) 2.2, (double) 0.35)); 
     assertEquals(3, ArrayUtils.lastIndexOf(array, (double) 4.15, (double) 2.0)); 
     assertEquals(1, ArrayUtils.lastIndexOf(array, (double) 1.00001324, (double) 0.0001)); 
 } 
@SuppressWarnings("cast")
@Test
public void testLastIndexOfDoubleWithStartIndex541() { 
     double[] array = null; 
     assertEquals(-1, ArrayUtils.lastIndexOf(array, (double) 0, 2)); 
     array = new double[0]; 
     assertEquals(-1, ArrayUtils.lastIndexOf(array, (double) 0, 2)); 
     array = new double[] { 0, 1, 2, 3, 0 }; 
     assertEquals(0, ArrayUtils.lastIndexOf(array, (double) 0, 2)); 
     assertEquals(1, ArrayUtils.lastIndexOf(array, (double) 1, 2)); 
     assertEquals(2, ArrayUtils.lastIndexOf(array, (double) 2, 2)); 
     assertEquals(-1, ArrayUtils.lastIndexOf(array, (double) 3, 2)); 
     assertEquals(-1, ArrayUtils.lastIndexOf(array, (double) 3, -1)); 
     assertEquals(-1, ArrayUtils.lastIndexOf(array, (double) 99)); 
     assertEquals(4, ArrayUtils.lastIndexOf(array, (double) 0, 88)); 
 } 
@SuppressWarnings("cast")
@Test
public void testLastIndexOfDoubleWithStartIndexTolerance542() { 
     double[] array = null; 
     assertEquals(-1, ArrayUtils.lastIndexOf(array, (double) 0, 2, (double) 0)); 
     array = new double[0]; 
     assertEquals(-1, ArrayUtils.lastIndexOf(array, (double) 0, 2, (double) 0)); 
     array = new double[] { (double) 3 }; 
     assertEquals(-1, ArrayUtils.lastIndexOf(array, (double) 1, 0, (double) 0)); 
     array = new double[] { 0, 1, 2, 3, 0 }; 
     assertEquals(4, ArrayUtils.lastIndexOf(array, (double) 0, 99, (double) 0.3)); 
     assertEquals(0, ArrayUtils.lastIndexOf(array, (double) 0, 3, (double) 0.3)); 
     assertEquals(2, ArrayUtils.lastIndexOf(array, (double) 2.2, 3, (double) 0.35)); 
     assertEquals(3, ArrayUtils.lastIndexOf(array, (double) 4.15, array.length, (double) 2.0)); 
     assertEquals(1, ArrayUtils.lastIndexOf(array, (double) 1.00001324, array.length, (double) 0.0001)); 
     assertEquals(-1, ArrayUtils.lastIndexOf(array, (double) 4.15, -200, (double) 2.0)); 
 } 
@SuppressWarnings("cast")
@Test
public void testContainsDouble543() { 
     double[] array = null; 
     assertFalse(ArrayUtils.contains(array, (double) 1)); 
     array = new double[] { 0, 1, 2, 3, 0 }; 
     assertTrue(ArrayUtils.contains(array, (double) 0)); 
     assertTrue(ArrayUtils.contains(array, (double) 1)); 
     assertTrue(ArrayUtils.contains(array, (double) 2)); 
     assertTrue(ArrayUtils.contains(array, (double) 3)); 
     assertFalse(ArrayUtils.contains(array, (double) 99)); 
 } 
@SuppressWarnings("cast")
@Test
public void testContainsDoubleTolerance544() { 
     double[] array = null; 
     assertFalse(ArrayUtils.contains(array, (double) 1, (double) 0)); 
     array = new double[] { 0, 1, 2, 3, 0 }; 
     assertFalse(ArrayUtils.contains(array, (double) 4.0, (double) 0.33)); 
     assertFalse(ArrayUtils.contains(array, (double) 2.5, (double) 0.49)); 
     assertTrue(ArrayUtils.contains(array, (double) 2.5, (double) 0.50)); 
     assertTrue(ArrayUtils.contains(array, (double) 2.5, (double) 0.51)); 
 } 
@SuppressWarnings("cast")
@Test
public void testIndexOfFloat545() { 
     float[] array = null; 
     assertEquals(-1, ArrayUtils.indexOf(array, (float) 0)); 
     array = new float[0]; 
     assertEquals(-1, ArrayUtils.indexOf(array, (float) 0)); 
     array = new float[] { 0, 1, 2, 3, 0 }; 
     assertEquals(0, ArrayUtils.indexOf(array, (float) 0)); 
     assertEquals(1, ArrayUtils.indexOf(array, (float) 1)); 
     assertEquals(2, ArrayUtils.indexOf(array, (float) 2)); 
     assertEquals(3, ArrayUtils.indexOf(array, (float) 3)); 
     assertEquals(-1, ArrayUtils.indexOf(array, (float) 99)); 
 } 
@SuppressWarnings("cast")
@Test
public void testIndexOfFloatWithStartIndex546() { 
     float[] array = null; 
     assertEquals(-1, ArrayUtils.indexOf(array, (float) 0, 2)); 
     array = new float[0]; 
     assertEquals(-1, ArrayUtils.indexOf(array, (float) 0, 2)); 
     array = new float[] { 0, 1, 2, 3, 0 }; 
     assertEquals(4, ArrayUtils.indexOf(array, (float) 0, 2)); 
     assertEquals(-1, ArrayUtils.indexOf(array, (float) 1, 2)); 
     assertEquals(2, ArrayUtils.indexOf(array, (float) 2, 2)); 
     assertEquals(3, ArrayUtils.indexOf(array, (float) 3, 2)); 
     assertEquals(3, ArrayUtils.indexOf(array, (float) 3, -1)); 
     assertEquals(-1, ArrayUtils.indexOf(array, (float) 99, 0)); 
     assertEquals(-1, ArrayUtils.indexOf(array, (float) 0, 6)); 
 } 
@SuppressWarnings("cast")
@Test
public void testLastIndexOfFloat547() { 
     float[] array = null; 
     assertEquals(-1, ArrayUtils.lastIndexOf(array, (float) 0)); 
     array = new float[0]; 
     assertEquals(-1, ArrayUtils.lastIndexOf(array, (float) 0)); 
     array = new float[] { 0, 1, 2, 3, 0 }; 
     assertEquals(4, ArrayUtils.lastIndexOf(array, (float) 0)); 
     assertEquals(1, ArrayUtils.lastIndexOf(array, (float) 1)); 
     assertEquals(2, ArrayUtils.lastIndexOf(array, (float) 2)); 
     assertEquals(3, ArrayUtils.lastIndexOf(array, (float) 3)); 
     assertEquals(-1, ArrayUtils.lastIndexOf(array, (float) 99)); 
 } 
@SuppressWarnings("cast")
@Test
public void testLastIndexOfFloatWithStartIndex548() { 
     float[] array = null; 
     assertEquals(-1, ArrayUtils.lastIndexOf(array, (float) 0, 2)); 
     array = new float[0]; 
     assertEquals(-1, ArrayUtils.lastIndexOf(array, (float) 0, 2)); 
     array = new float[] { 0, 1, 2, 3, 0 }; 
     assertEquals(0, ArrayUtils.lastIndexOf(array, (float) 0, 2)); 
     assertEquals(1, ArrayUtils.lastIndexOf(array, (float) 1, 2)); 
     assertEquals(2, ArrayUtils.lastIndexOf(array, (float) 2, 2)); 
     assertEquals(-1, ArrayUtils.lastIndexOf(array, (float) 3, 2)); 
     assertEquals(-1, ArrayUtils.lastIndexOf(array, (float) 3, -1)); 
     assertEquals(-1, ArrayUtils.lastIndexOf(array, (float) 99)); 
     assertEquals(4, ArrayUtils.lastIndexOf(array, (float) 0, 88)); 
 } 
@SuppressWarnings("cast")
@Test
public void testContainsFloat549() { 
     float[] array = null; 
     assertFalse(ArrayUtils.contains(array, (float) 1)); 
     array = new float[] { 0, 1, 2, 3, 0 }; 
     assertTrue(ArrayUtils.contains(array, (float) 0)); 
     assertTrue(ArrayUtils.contains(array, (float) 1)); 
     assertTrue(ArrayUtils.contains(array, (float) 2)); 
     assertTrue(ArrayUtils.contains(array, (float) 3)); 
     assertFalse(ArrayUtils.contains(array, (float) 99)); 
 }
@Test
public void testContainsBoolean550() { 
     boolean[] array = null; 
     assertFalse(ArrayUtils.contains(array, true)); 
     array = new boolean[] { true, false, true }; 
     assertTrue(ArrayUtils.contains(array, true)); 
     assertTrue(ArrayUtils.contains(array, false)); 
     array = new boolean[] { true, true }; 
     assertTrue(ArrayUtils.contains(array, true)); 
     assertFalse(ArrayUtils.contains(array, false)); 
 }
@Test
public void testIndexOfBooleanWithStartIndex551() { 
     boolean[] array = null; 
     assertEquals(-1, ArrayUtils.indexOf(array, true, 2)); 
     array = new boolean[0]; 
     assertEquals(-1, ArrayUtils.indexOf(array, true, 2)); 
     array = new boolean[] { true, false, true }; 
     assertEquals(2, ArrayUtils.indexOf(array, true, 1)); 
     assertEquals(-1, ArrayUtils.indexOf(array, false, 2)); 
     assertEquals(1, ArrayUtils.indexOf(array, false, 0)); 
     assertEquals(1, ArrayUtils.indexOf(array, false, -1)); 
     array = new boolean[] { true, true }; 
     assertEquals(-1, ArrayUtils.indexOf(array, false, 0)); 
     assertEquals(-1, ArrayUtils.indexOf(array, false, -1)); 
 }
@Test
public void testLastIndexOfBooleanWithStartIndex552() { 
     boolean[] array = null; 
     assertEquals(-1, ArrayUtils.lastIndexOf(array, true, 2)); 
     array = new boolean[0]; 
     assertEquals(-1, ArrayUtils.lastIndexOf(array, true, 2)); 
     array = new boolean[] { true, false, true }; 
     assertEquals(2, ArrayUtils.lastIndexOf(array, true, 2)); 
     assertEquals(0, ArrayUtils.lastIndexOf(array, true, 1)); 
     assertEquals(1, ArrayUtils.lastIndexOf(array, false, 2)); 
     assertEquals(-1, ArrayUtils.lastIndexOf(array, true, -1)); 
     array = new boolean[] { true, true }; 
     assertEquals(-1, ArrayUtils.lastIndexOf(array, false, 2)); 
     assertEquals(-1, ArrayUtils.lastIndexOf(array, true, -1)); 
 }
@Test
public void testToPrimitive_char_char553() { 
     final Character[] b = null; 
     assertEquals(null, ArrayUtils.toPrimitive(b, Character.MIN_VALUE)); 
     assertSame(ArrayUtils.EMPTY_CHAR_ARRAY, ArrayUtils.toPrimitive(new Character[0], (char) 0)); 
     assertTrue(Arrays.equals(new char[] { Character.MIN_VALUE, Character.MAX_VALUE, '0' }, ArrayUtils.toPrimitive(new Character[] { new Character(Character.MIN_VALUE), new Character(Character.MAX_VALUE), new Character('0') }, Character.MIN_VALUE))); 
     assertTrue(Arrays.equals(new char[] { Character.MIN_VALUE, Character.MAX_VALUE, '0' }, ArrayUtils.toPrimitive(new Character[] { new Character(Character.MIN_VALUE), null, new Character('0') }, Character.MAX_VALUE))); 
 }
@Test
public void testToPrimitive_long554() { 
     final Long[] b = null; 
     assertEquals(null, ArrayUtils.toPrimitive(b)); 
     assertSame(ArrayUtils.EMPTY_LONG_ARRAY, ArrayUtils.toPrimitive(new Long[0])); 
     assertTrue(Arrays.equals(new long[] { Long.MIN_VALUE, Long.MAX_VALUE, 9999999 }, ArrayUtils.toPrimitive(new Long[] { Long.valueOf(Long.MIN_VALUE), Long.valueOf(Long.MAX_VALUE), Long.valueOf(9999999) }))); 
     try { 
         ArrayUtils.toPrimitive(new Long[] { Long.valueOf(Long.MIN_VALUE), null }); 
         fail(); 
     } catch (final NullPointerException ex) { 
     } 
 }
@Test
public void testToPrimitive_long_long555() { 
     final Long[] l = null; 
     assertEquals(null, ArrayUtils.toPrimitive(l, Long.MIN_VALUE)); 
     assertSame(ArrayUtils.EMPTY_LONG_ARRAY, ArrayUtils.toPrimitive(new Long[0], 1)); 
     assertTrue(Arrays.equals(new long[] { Long.MIN_VALUE, Long.MAX_VALUE, 9999999 }, ArrayUtils.toPrimitive(new Long[] { Long.valueOf(Long.MIN_VALUE), Long.valueOf(Long.MAX_VALUE), Long.valueOf(9999999) }, 1))); 
     assertTrue(Arrays.equals(new long[] { Long.MIN_VALUE, Long.MAX_VALUE, 9999999 }, ArrayUtils.toPrimitive(new Long[] { Long.valueOf(Long.MIN_VALUE), null, Long.valueOf(9999999) }, Long.MAX_VALUE))); 
 }
@Test
public void testToObject_long556() { 
     final long[] b = null; 
     assertArrayEquals(null, ArrayUtils.toObject(b)); 
     assertSame(ArrayUtils.EMPTY_LONG_OBJECT_ARRAY, ArrayUtils.toObject(new long[0])); 
     assertTrue(Arrays.equals(new Long[] { Long.valueOf(Long.MIN_VALUE), Long.valueOf(Long.MAX_VALUE), Long.valueOf(9999999) }, ArrayUtils.toObject(new long[] { Long.MIN_VALUE, Long.MAX_VALUE, 9999999 }))); 
 }
@Test
public void testToPrimitive_int557() { 
     final Integer[] b = null; 
     assertEquals(null, ArrayUtils.toPrimitive(b)); 
     assertSame(ArrayUtils.EMPTY_INT_ARRAY, ArrayUtils.toPrimitive(new Integer[0])); 
     assertTrue(Arrays.equals(new int[] { Integer.MIN_VALUE, Integer.MAX_VALUE, 9999999 }, ArrayUtils.toPrimitive(new Integer[] { Integer.valueOf(Integer.MIN_VALUE), Integer.valueOf(Integer.MAX_VALUE), Integer.valueOf(9999999) }))); 
     try { 
         ArrayUtils.toPrimitive(new Integer[] { Integer.valueOf(Integer.MIN_VALUE), null }); 
         fail(); 
     } catch (final NullPointerException ex) { 
     } 
 }
@Test
public void testToPrimitive_int_int558() { 
     final Long[] l = null; 
     assertEquals(null, ArrayUtils.toPrimitive(l, Integer.MIN_VALUE)); 
     assertSame(ArrayUtils.EMPTY_INT_ARRAY, ArrayUtils.toPrimitive(new Integer[0], 1)); 
     assertTrue(Arrays.equals(new int[] { Integer.MIN_VALUE, Integer.MAX_VALUE, 9999999 }, ArrayUtils.toPrimitive(new Integer[] { Integer.valueOf(Integer.MIN_VALUE), Integer.valueOf(Integer.MAX_VALUE), Integer.valueOf(9999999) }, 1))); 
     assertTrue(Arrays.equals(new int[] { Integer.MIN_VALUE, Integer.MAX_VALUE, 9999999 }, ArrayUtils.toPrimitive(new Integer[] { Integer.valueOf(Integer.MIN_VALUE), null, Integer.valueOf(9999999) }, Integer.MAX_VALUE))); 
 }
@Test
public void testToPrimitive_intNull559() { 
     final Integer[] iArray = null; 
     assertEquals(null, ArrayUtils.toPrimitive(iArray, Integer.MIN_VALUE)); 
 }
@Test
public void testToObject_int560() { 
     final int[] b = null; 
     assertArrayEquals(null, ArrayUtils.toObject(b)); 
     assertSame(ArrayUtils.EMPTY_INTEGER_OBJECT_ARRAY, ArrayUtils.toObject(new int[0])); 
     assertTrue(Arrays.equals(new Integer[] { Integer.valueOf(Integer.MIN_VALUE), Integer.valueOf(Integer.MAX_VALUE), Integer.valueOf(9999999) }, ArrayUtils.toObject(new int[] { Integer.MIN_VALUE, Integer.MAX_VALUE, 9999999 }))); 
 }
@Test
public void testToPrimitive_short561() { 
     final Short[] b = null; 
     assertEquals(null, ArrayUtils.toPrimitive(b)); 
     assertSame(ArrayUtils.EMPTY_SHORT_ARRAY, ArrayUtils.toPrimitive(new Short[0])); 
     assertTrue(Arrays.equals(new short[] { Short.MIN_VALUE, Short.MAX_VALUE, (short) 9999999 }, ArrayUtils.toPrimitive(new Short[] { Short.valueOf(Short.MIN_VALUE), Short.valueOf(Short.MAX_VALUE), Short.valueOf((short) 9999999) }))); 
     try { 
         ArrayUtils.toPrimitive(new Short[] { Short.valueOf(Short.MIN_VALUE), null }); 
         fail(); 
     } catch (final NullPointerException ex) { 
     } 
 }
@Test
public void testToPrimitive_short_short562() { 
     final Short[] s = null; 
     assertEquals(null, ArrayUtils.toPrimitive(s, Short.MIN_VALUE)); 
     assertSame(ArrayUtils.EMPTY_SHORT_ARRAY, ArrayUtils.toPrimitive(new Short[0], Short.MIN_VALUE)); 
     assertTrue(Arrays.equals(new short[] { Short.MIN_VALUE, Short.MAX_VALUE, (short) 9999999 }, ArrayUtils.toPrimitive(new Short[] { Short.valueOf(Short.MIN_VALUE), Short.valueOf(Short.MAX_VALUE), Short.valueOf((short) 9999999) }, Short.MIN_VALUE))); 
     assertTrue(Arrays.equals(new short[] { Short.MIN_VALUE, Short.MAX_VALUE, (short) 9999999 }, ArrayUtils.toPrimitive(new Short[] { Short.valueOf(Short.MIN_VALUE), null, Short.valueOf((short) 9999999) }, Short.MAX_VALUE))); 
 }
@Test
public void testToObject_short563() { 
     final short[] b = null; 
     assertArrayEquals(null, ArrayUtils.toObject(b)); 
     assertSame(ArrayUtils.EMPTY_SHORT_OBJECT_ARRAY, ArrayUtils.toObject(new short[0])); 
     assertTrue(Arrays.equals(new Short[] { Short.valueOf(Short.MIN_VALUE), Short.valueOf(Short.MAX_VALUE), Short.valueOf((short) 9999999) }, ArrayUtils.toObject(new short[] { Short.MIN_VALUE, Short.MAX_VALUE, (short) 9999999 }))); 
 }
@Test
public void testToPrimitive_byte_byte564() { 
     final Byte[] b = null; 
     assertEquals(null, ArrayUtils.toPrimitive(b, Byte.MIN_VALUE)); 
     assertSame(ArrayUtils.EMPTY_BYTE_ARRAY, ArrayUtils.toPrimitive(new Byte[0], (byte) 1)); 
     assertTrue(Arrays.equals(new byte[] { Byte.MIN_VALUE, Byte.MAX_VALUE, (byte) 9999999 }, ArrayUtils.toPrimitive(new Byte[] { Byte.valueOf(Byte.MIN_VALUE), Byte.valueOf(Byte.MAX_VALUE), Byte.valueOf((byte) 9999999) }, Byte.MIN_VALUE))); 
     assertTrue(Arrays.equals(new byte[] { Byte.MIN_VALUE, Byte.MAX_VALUE, (byte) 9999999 }, ArrayUtils.toPrimitive(new Byte[] { Byte.valueOf(Byte.MIN_VALUE), null, Byte.valueOf((byte) 9999999) }, Byte.MAX_VALUE))); 
 }
@Test
public void testToObject_byte565() { 
     final byte[] b = null; 
     assertArrayEquals(null, ArrayUtils.toObject(b)); 
     assertSame(ArrayUtils.EMPTY_BYTE_OBJECT_ARRAY, ArrayUtils.toObject(new byte[0])); 
     assertTrue(Arrays.equals(new Byte[] { Byte.valueOf(Byte.MIN_VALUE), Byte.valueOf(Byte.MAX_VALUE), Byte.valueOf((byte) 9999999) }, ArrayUtils.toObject(new byte[] { Byte.MIN_VALUE, Byte.MAX_VALUE, (byte) 9999999 }))); 
 }
@Test
public void testToPrimitive_double566() { 
     final Double[] b = null; 
     assertEquals(null, ArrayUtils.toPrimitive(b)); 
     assertSame(ArrayUtils.EMPTY_DOUBLE_ARRAY, ArrayUtils.toPrimitive(new Double[0])); 
     assertTrue(Arrays.equals(new double[] { Double.MIN_VALUE, Double.MAX_VALUE, 9999999 }, ArrayUtils.toPrimitive(new Double[] { Double.valueOf(Double.MIN_VALUE), Double.valueOf(Double.MAX_VALUE), Double.valueOf(9999999) }))); 
     try { 
         ArrayUtils.toPrimitive(new Float[] { Float.valueOf(Float.MIN_VALUE), null }); 
         fail(); 
     } catch (final NullPointerException ex) { 
     } 
 }
@Test
public void testToPrimitive_float567() { 
     final Float[] b = null; 
     assertEquals(null, ArrayUtils.toPrimitive(b)); 
     assertSame(ArrayUtils.EMPTY_FLOAT_ARRAY, ArrayUtils.toPrimitive(new Float[0])); 
     assertTrue(Arrays.equals(new float[] { Float.MIN_VALUE, Float.MAX_VALUE, 9999999 }, ArrayUtils.toPrimitive(new Float[] { Float.valueOf(Float.MIN_VALUE), Float.valueOf(Float.MAX_VALUE), Float.valueOf(9999999) }))); 
     try { 
         ArrayUtils.toPrimitive(new Float[] { Float.valueOf(Float.MIN_VALUE), null }); 
         fail(); 
     } catch (final NullPointerException ex) { 
     } 
 }
@Test
public void testToPrimitive_float_float568() { 
     final Float[] l = null; 
     assertEquals(null, ArrayUtils.toPrimitive(l, Float.MIN_VALUE)); 
     assertSame(ArrayUtils.EMPTY_FLOAT_ARRAY, ArrayUtils.toPrimitive(new Float[0], 1)); 
     assertTrue(Arrays.equals(new float[] { Float.MIN_VALUE, Float.MAX_VALUE, 9999999 }, ArrayUtils.toPrimitive(new Float[] { Float.valueOf(Float.MIN_VALUE), Float.valueOf(Float.MAX_VALUE), Float.valueOf(9999999) }, 1))); 
     assertTrue(Arrays.equals(new float[] { Float.MIN_VALUE, Float.MAX_VALUE, 9999999 }, ArrayUtils.toPrimitive(new Float[] { Float.valueOf(Float.MIN_VALUE), null, Float.valueOf(9999999) }, Float.MAX_VALUE))); 
 }
@Test
public void testToPrimitive_boolean569() { 
     final Boolean[] b = null; 
     assertEquals(null, ArrayUtils.toPrimitive(b)); 
     assertSame(ArrayUtils.EMPTY_BOOLEAN_ARRAY, ArrayUtils.toPrimitive(new Boolean[0])); 
     assertTrue(Arrays.equals(new boolean[] { true, false, true }, ArrayUtils.toPrimitive(new Boolean[] { Boolean.TRUE, Boolean.FALSE, Boolean.TRUE }))); 
     try { 
         ArrayUtils.toPrimitive(new Boolean[] { Boolean.TRUE, null }); 
         fail(); 
     } catch (final NullPointerException ex) { 
     } 
 }
@Test
public void testToObject_boolean570() { 
     final boolean[] b = null; 
     assertArrayEquals(null, ArrayUtils.toObject(b)); 
     assertSame(ArrayUtils.EMPTY_BOOLEAN_OBJECT_ARRAY, ArrayUtils.toObject(new boolean[0])); 
     assertTrue(Arrays.equals(new Boolean[] { Boolean.TRUE, Boolean.FALSE, Boolean.TRUE }, ArrayUtils.toObject(new boolean[] { true, false, true }))); 
 }
@Test
public void testIsEmptyObject571() { 
     final Object[] emptyArray = new Object[] {}; 
     final Object[] notEmptyArray = new Object[] { new String("Value") }; 
     assertTrue(ArrayUtils.isEmpty((Object[]) null)); 
     assertTrue(ArrayUtils.isEmpty(emptyArray)); 
     assertFalse(ArrayUtils.isEmpty(notEmptyArray)); 
 }
@Test
public void testIsEmptyPrimitives572() { 
     final long[] emptyLongArray = new long[] {}; 
     final long[] notEmptyLongArray = new long[] { 1L }; 
     assertTrue(ArrayUtils.isEmpty((long[]) null)); 
     assertTrue(ArrayUtils.isEmpty(emptyLongArray)); 
     assertFalse(ArrayUtils.isEmpty(notEmptyLongArray)); 
     final int[] emptyIntArray = new int[] {}; 
     final int[] notEmptyIntArray = new int[] { 1 }; 
     assertTrue(ArrayUtils.isEmpty((int[]) null)); 
     assertTrue(ArrayUtils.isEmpty(emptyIntArray)); 
     assertFalse(ArrayUtils.isEmpty(notEmptyIntArray)); 
     final short[] emptyShortArray = new short[] {}; 
     final short[] notEmptyShortArray = new short[] { 1 }; 
     assertTrue(ArrayUtils.isEmpty((short[]) null)); 
     assertTrue(ArrayUtils.isEmpty(emptyShortArray)); 
     assertFalse(ArrayUtils.isEmpty(notEmptyShortArray)); 
     final char[] emptyCharArray = new char[] {}; 
     final char[] notEmptyCharArray = new char[] { 1 }; 
     assertTrue(ArrayUtils.isEmpty((char[]) null)); 
     assertTrue(ArrayUtils.isEmpty(emptyCharArray)); 
     assertFalse(ArrayUtils.isEmpty(notEmptyCharArray)); 
     final byte[] emptyByteArray = new byte[] {}; 
     final byte[] notEmptyByteArray = new byte[] { 1 }; 
     assertTrue(ArrayUtils.isEmpty((byte[]) null)); 
     assertTrue(ArrayUtils.isEmpty(emptyByteArray)); 
     assertFalse(ArrayUtils.isEmpty(notEmptyByteArray)); 
     final double[] emptyDoubleArray = new double[] {}; 
     final double[] notEmptyDoubleArray = new double[] { 1.0 }; 
     assertTrue(ArrayUtils.isEmpty((double[]) null)); 
     assertTrue(ArrayUtils.isEmpty(emptyDoubleArray)); 
     assertFalse(ArrayUtils.isEmpty(notEmptyDoubleArray)); 
     final float[] emptyFloatArray = new float[] {}; 
     final float[] notEmptyFloatArray = new float[] { 1.0F }; 
     assertTrue(ArrayUtils.isEmpty((float[]) null)); 
     assertTrue(ArrayUtils.isEmpty(emptyFloatArray)); 
     assertFalse(ArrayUtils.isEmpty(notEmptyFloatArray)); 
     final boolean[] emptyBooleanArray = new boolean[] {}; 
     final boolean[] notEmptyBooleanArray = new boolean[] { true }; 
     assertTrue(ArrayUtils.isEmpty((boolean[]) null)); 
     assertTrue(ArrayUtils.isEmpty(emptyBooleanArray)); 
     assertFalse(ArrayUtils.isEmpty(notEmptyBooleanArray)); 
 }
@Test
public void testIsNotEmptyObject573() { 
     final Object[] emptyArray = new Object[] {}; 
     final Object[] notEmptyArray = new Object[] { new String("Value") }; 
     assertFalse(ArrayUtils.isNotEmpty((Object[]) null)); 
     assertFalse(ArrayUtils.isNotEmpty(emptyArray)); 
     assertTrue(ArrayUtils.isNotEmpty(notEmptyArray)); 
 }
    
    
    //-----------------------------------------------------------------------
    

    //-----------------------------------------------------------------------
    

    //-----------------------------------------------------------------------
    private void assertIsEquals(final Object array1, final Object array2, final Object array3) {
        assertTrue(ArrayUtils.isEquals(array1, array1));
        assertTrue(ArrayUtils.isEquals(array2, array2));
        assertTrue(ArrayUtils.isEquals(array3, array3));
        assertFalse(ArrayUtils.isEquals(array1, array2));
        assertFalse(ArrayUtils.isEquals(array2, array1));
        assertFalse(ArrayUtils.isEquals(array1, array3));
        assertFalse(ArrayUtils.isEquals(array3, array1));
        assertFalse(ArrayUtils.isEquals(array1, array2));
        assertFalse(ArrayUtils.isEquals(array2, array1));
    }

    
    
    //-----------------------------------------------------------------------
    /**
     * Tests generic array creation with parameters of same type.
     */
    

    /**
     * Tests generic array creation with general return type.
     */
    

    /**
     * Tests generic array creation with parameters of common base type.
     */
    

    /**
     * Tests generic array creation with generic type.
     */
    

    /**
     * Tests generic empty array creation with generic type.
     */
    

    /**
     * Tests indirect generic empty array creation with generic type.
     */
    

    private static <T> T[] toArrayPropagatingType(final T... items)
    {
        return ArrayUtils.toArray(items);
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
    

    

    

    

    
    
    //-----------------------------------------------------------------------
    

    

    

    

    
    
    // testToPrimitive/Object for boolean
    //  -----------------------------------------------------------------------
    

    

    

    // testToPrimitive/Object for byte
    //  -----------------------------------------------------------------------
    

    

    
    
    // testToPrimitive/Object for byte
    //  -----------------------------------------------------------------------
    

    

    

    // testToPrimitive/Object for short
    //  -----------------------------------------------------------------------
    

    

    

    //  testToPrimitive/Object for int
    //  -----------------------------------------------------------------------
     

     
     
    

    

    //  testToPrimitive/Object for long
    //  -----------------------------------------------------------------------
     

     
     
    

    //  testToPrimitive/Object for float
    //  -----------------------------------------------------------------------
     

     
     
    

    //  testToPrimitive/Object for double
    //  -----------------------------------------------------------------------
     

     
     
    

    //-----------------------------------------------------------------------
    /**
     * Test for {@link ArrayUtils#isEmpty(java.lang.Object[])}.
     */
    

    /**
     * Tests for {@link ArrayUtils#isEmpty(long[])},
     * {@link ArrayUtils#isEmpty(int[])},
     * {@link ArrayUtils#isEmpty(short[])},
     * {@link ArrayUtils#isEmpty(char[])},
     * {@link ArrayUtils#isEmpty(byte[])},
     * {@link ArrayUtils#isEmpty(double[])},
     * {@link ArrayUtils#isEmpty(float[])} and
     * {@link ArrayUtils#isEmpty(boolean[])}.
     */
    
    
   /**
     * Test for {@link ArrayUtils#isNotEmpty(java.lang.Object[])}.
     */
    

   /**
     * Tests for {@link ArrayUtils#isNotEmpty(long[])},
     * {@link ArrayUtils#isNotEmpty(int[])},
     * {@link ArrayUtils#isNotEmpty(short[])},
     * {@link ArrayUtils#isNotEmpty(char[])},
     * {@link ArrayUtils#isNotEmpty(byte[])},
     * {@link ArrayUtils#isNotEmpty(double[])},
     * {@link ArrayUtils#isNotEmpty(float[])} and
     * {@link ArrayUtils#isNotEmpty(boolean[])}.
     */
    
    // ------------------------------------------------------------------------
    

}
