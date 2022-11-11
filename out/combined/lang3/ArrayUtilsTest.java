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
public void testToString21() { 
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
public void testIsNotEmptyPrimitives27() { 
     final long[] emptyLongArray = new long[] {}; 
     final long[] notEmptyLongArray = new long[] { 1L }; 
     assertFalse(ArrayUtils.isNotEmpty((long[]) null)); 
     assertFalse(ArrayUtils.isNotEmpty(emptyLongArray)); 
     assertTrue(ArrayUtils.isNotEmpty(notEmptyLongArray)); 
     final int[] emptyIntArray = new int[] {}; 
     final int[] notEmptyIntArray = new int[] { 1 }; 
     assertFalse(ArrayUtils.isNotEmpty((int[]) null)); 
     assertFalse(ArrayUtils.isNotEmpty(emptyIntArray)); 
     assertTrue(ArrayUtils.isNotEmpty(notEmptyIntArray)); 
     final short[] emptyShortArray = new short[] {}; 
     final short[] notEmptyShortArray = new short[] { 1 }; 
     assertFalse(ArrayUtils.isNotEmpty((short[]) null)); 
     assertFalse(ArrayUtils.isNotEmpty(emptyShortArray)); 
     assertTrue(ArrayUtils.isNotEmpty(notEmptyShortArray)); 
     final char[] emptyCharArray = new char[] {}; 
     final char[] notEmptyCharArray = new char[] { 1 }; 
     assertFalse(ArrayUtils.isNotEmpty((char[]) null)); 
     assertFalse(ArrayUtils.isNotEmpty(emptyCharArray)); 
     assertTrue(ArrayUtils.isNotEmpty(notEmptyCharArray)); 
     final byte[] emptyByteArray = new byte[] {}; 
     final byte[] notEmptyByteArray = new byte[] { 1 }; 
     assertFalse(ArrayUtils.isNotEmpty((byte[]) null)); 
     assertFalse(ArrayUtils.isNotEmpty(emptyByteArray)); 
     assertTrue(ArrayUtils.isNotEmpty(notEmptyByteArray)); 
     final double[] emptyDoubleArray = new double[] {}; 
     final double[] notEmptyDoubleArray = new double[] { 1.0 }; 
     assertFalse(ArrayUtils.isNotEmpty((double[]) null)); 
     assertFalse(ArrayUtils.isNotEmpty(emptyDoubleArray)); 
     assertTrue(ArrayUtils.isNotEmpty(notEmptyDoubleArray)); 
     final float[] emptyFloatArray = new float[] {}; 
     final float[] notEmptyFloatArray = new float[] { 1.0F }; 
     assertFalse(ArrayUtils.isNotEmpty((float[]) null)); 
     assertFalse(ArrayUtils.isNotEmpty(emptyFloatArray)); 
     assertTrue(ArrayUtils.isNotEmpty(notEmptyFloatArray)); 
     final boolean[] emptyBooleanArray = new boolean[] {}; 
     final boolean[] notEmptyBooleanArray = new boolean[] { true }; 
     assertFalse(ArrayUtils.isNotEmpty((boolean[]) null)); 
     assertFalse(ArrayUtils.isNotEmpty(emptyBooleanArray)); 
     assertTrue(ArrayUtils.isNotEmpty(notEmptyBooleanArray)); 
 }
@Test
public void testContainsShort40() { 
     short[] array = null; 
     assertFalse(ArrayUtils.contains(array, (short) 1)); 
     array = new short[] { 0, 1, 2, 3, 0 }; 
     assertTrue(ArrayUtils.contains(array, (short) 0)); 
     assertTrue(ArrayUtils.contains(array, (short) 1)); 
     assertTrue(ArrayUtils.contains(array, (short) 2)); 
     assertTrue(ArrayUtils.contains(array, (short) 3)); 
     assertFalse(ArrayUtils.contains(array, (short) 99)); 
 }
@Test
public void testToPrimitive_byte49() { 
     final Byte[] b = null; 
     assertEquals(null, ArrayUtils.toPrimitive(b)); 
     assertSame(ArrayUtils.EMPTY_BYTE_ARRAY, ArrayUtils.toPrimitive(new Byte[0])); 
     assertTrue(Arrays.equals(new byte[] { Byte.MIN_VALUE, Byte.MAX_VALUE, (byte) 9999999 }, ArrayUtils.toPrimitive(new Byte[] { Byte.valueOf(Byte.MIN_VALUE), Byte.valueOf(Byte.MAX_VALUE), Byte.valueOf((byte) 9999999) }))); 
     try { 
         ArrayUtils.toPrimitive(new Byte[] { Byte.valueOf(Byte.MIN_VALUE), null }); 
         fail(); 
     } catch (final NullPointerException ex) { 
     } 
 }
@Test
public void testReverseChar55() { 
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
public void testSameLengthByte68() { 
     final byte[] nullArray = null; 
     final byte[] emptyArray = new byte[0]; 
     final byte[] oneArray = new byte[] { 3 }; 
     final byte[] twoArray = new byte[] { 4, 6 }; 
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
public void testReverseLong74() { 
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
public void testReverse85() { 
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
public void testReverse90() { 
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
@SuppressWarnings("cast")
@Test
public void testContainsDoubleTolerance98() { 
     double[] array = null; 
     assertFalse(ArrayUtils.contains(array, (double) 1, (double) 0)); 
     array = new double[] { 0, 1, 2, 3, 0 }; 
     assertFalse(ArrayUtils.contains(array, (double) 4.0, (double) 0.33)); 
     assertFalse(ArrayUtils.contains(array, (double) 2.5, (double) 0.49)); 
     assertTrue(ArrayUtils.contains(array, (double) 2.5, (double) 0.50)); 
     assertTrue(ArrayUtils.contains(array, (double) 2.5, (double) 0.51)); 
 }
@Test
public void testNullToEmptyInt112() { 
     assertEquals(ArrayUtils.EMPTY_INT_ARRAY, ArrayUtils.nullToEmpty((int[]) null)); 
     final int[] original = new int[] { 1, 2 }; 
     assertEquals(original, ArrayUtils.nullToEmpty(original)); 
     final int[] empty = new int[] {}; 
     final int[] result = ArrayUtils.nullToEmpty(empty); 
     assertEquals(ArrayUtils.EMPTY_INT_ARRAY, result); 
     assertTrue(empty != result); 
 }
@Test
public void testToPrimitive_byte_byte115() { 
     final Byte[] b = null; 
     assertEquals(null, ArrayUtils.toPrimitive(b, Byte.MIN_VALUE)); 
     assertSame(ArrayUtils.EMPTY_BYTE_ARRAY, ArrayUtils.toPrimitive(new Byte[0], (byte) 1)); 
     assertTrue(Arrays.equals(new byte[] { Byte.MIN_VALUE, Byte.MAX_VALUE, (byte) 9999999 }, ArrayUtils.toPrimitive(new Byte[] { Byte.valueOf(Byte.MIN_VALUE), Byte.valueOf(Byte.MAX_VALUE), Byte.valueOf((byte) 9999999) }, Byte.MIN_VALUE))); 
     assertTrue(Arrays.equals(new byte[] { Byte.MIN_VALUE, Byte.MAX_VALUE, (byte) 9999999 }, ArrayUtils.toPrimitive(new Byte[] { Byte.valueOf(Byte.MIN_VALUE), null, Byte.valueOf((byte) 9999999) }, Byte.MAX_VALUE))); 
 }
@Test
public void testSubarrayInt133() { 
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
public void testReverseInt146() { 
     int[] array = new int[] { 1, 2, 3 }; 
     ArrayUtils.reverse(array); 
     assertEquals(array[0], 3); 
     assertEquals(array[1], 2); 
     assertEquals(array[2], 1); 
     array = null; 
     ArrayUtils.reverse(array); 
     assertEquals(null, array); 
 }
@Test
public void testToPrimitive_char_char148() { 
     final Character[] b = null; 
     assertEquals(null, ArrayUtils.toPrimitive(b, Character.MIN_VALUE)); 
     assertSame(ArrayUtils.EMPTY_CHAR_ARRAY, ArrayUtils.toPrimitive(new Character[0], (char) 0)); 
     assertTrue(Arrays.equals(new char[] { Character.MIN_VALUE, Character.MAX_VALUE, '0' }, ArrayUtils.toPrimitive(new Character[] { new Character(Character.MIN_VALUE), new Character(Character.MAX_VALUE), new Character('0') }, Character.MIN_VALUE))); 
     assertTrue(Arrays.equals(new char[] { Character.MIN_VALUE, Character.MAX_VALUE, '0' }, ArrayUtils.toPrimitive(new Character[] { new Character(Character.MIN_VALUE), null, new Character('0') }, Character.MAX_VALUE))); 
 } 
@SuppressWarnings("cast")
@Test
public void testIndexOfDoubleWithStartIndexTolerance162() { 
     double[] array = null; 
     assertEquals(-1, ArrayUtils.indexOf(array, (double) 0, 2, (double) 0)); 
     array = new double[0]; 
     assertEquals(-1, ArrayUtils.indexOf(array, (double) 0, 2, (double) 0)); 
     array = new double[] { 0, 1, 2, 3, 0 }; 
     assertEquals(-1, ArrayUtils.indexOf(array, (double) 0, 99, (double) 0.3)); 
     assertEquals(0, ArrayUtils.indexOf(array, (double) 0, 0, (double) 0.3)); 
     assertEquals(4, ArrayUtils.indexOf(array, (double) 0, 3, (double) 0.3)); 
     assertEquals(2, ArrayUtils.indexOf(array, (double) 2.2, 0, (double) 0.35)); 
     assertEquals(3, ArrayUtils.indexOf(array, (double) 4.15, 0, (double) 2.0)); 
     assertEquals(1, ArrayUtils.indexOf(array, (double) 1.00001324, 0, (double) 0.0001)); 
     assertEquals(3, ArrayUtils.indexOf(array, (double) 4.15, -1, (double) 2.0)); 
     assertEquals(1, ArrayUtils.indexOf(array, (double) 1.00001324, -300, (double) 0.0001)); 
 }
@Test
public void testToPrimitive_byte169() { 
     final Byte[] b = null; 
     assertEquals(null, ArrayUtils.toPrimitive(b)); 
     assertSame(ArrayUtils.EMPTY_BYTE_ARRAY, ArrayUtils.toPrimitive(new Byte[0])); 
     assertTrue(Arrays.equals(new byte[] { Byte.MIN_VALUE, Byte.MAX_VALUE, (byte) 9999999 }, ArrayUtils.toPrimitive(new Byte[] { Byte.valueOf(Byte.MIN_VALUE), Byte.valueOf(Byte.MAX_VALUE), Byte.valueOf((byte) 9999999) }))); 
     try { 
         ArrayUtils.toPrimitive(new Byte[] { Byte.valueOf(Byte.MIN_VALUE), null }); 
         fail(); 
     } catch (final NullPointerException ex) { 
     } 
 }
@Test
public void testContainsShort201() { 
     short[] array = null; 
     assertFalse(ArrayUtils.contains(array, (short) 1)); 
     array = new short[] { 0, 1, 2, 3, 0 }; 
     assertTrue(ArrayUtils.contains(array, (short) 0)); 
     assertTrue(ArrayUtils.contains(array, (short) 1)); 
     assertTrue(ArrayUtils.contains(array, (short) 2)); 
     assertTrue(ArrayUtils.contains(array, (short) 3)); 
     assertFalse(ArrayUtils.contains(array, (short) 99)); 
 }
@Test
public void testToPrimitive_boolean211() { 
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
public void testSubarrayBoolean216() { 
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
@SuppressWarnings("cast")
@Test
public void testContainsDoubleTolerance234() { 
     double[] array = null; 
     assertFalse(ArrayUtils.contains(array, (double) 1, (double) 0)); 
     array = new double[] { 0, 1, 2, 3, 0 }; 
     assertFalse(ArrayUtils.contains(array, (double) 4.0, (double) 0.33)); 
     assertFalse(ArrayUtils.contains(array, (double) 2.5, (double) 0.49)); 
     assertTrue(ArrayUtils.contains(array, (double) 2.5, (double) 0.50)); 
     assertTrue(ArrayUtils.contains(array, (double) 2.5, (double) 0.51)); 
 }
@Test
public void testSameLengthShort246() { 
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
public void testNullToEmptyObject252() { 
     assertArrayEquals(ArrayUtils.EMPTY_OBJECT_ARRAY, ArrayUtils.nullToEmpty((Object[]) null)); 
     final Object[] original = new Object[] { Boolean.TRUE, Boolean.FALSE }; 
     assertArrayEquals(original, ArrayUtils.nullToEmpty(original)); 
     final Object[] empty = new Object[] {}; 
     final Object[] result = ArrayUtils.nullToEmpty(empty); 
     assertArrayEquals(ArrayUtils.EMPTY_OBJECT_ARRAY, result); 
     assertTrue(empty != result); 
 } 
@SuppressWarnings("cast")
@Test
public void testIndexOfDoubleWithStartIndexTolerance289() { 
     double[] array = null; 
     assertEquals(-1, ArrayUtils.indexOf(array, (double) 0, 2, (double) 0)); 
     array = new double[0]; 
     assertEquals(-1, ArrayUtils.indexOf(array, (double) 0, 2, (double) 0)); 
     array = new double[] { 0, 1, 2, 3, 0 }; 
     assertEquals(-1, ArrayUtils.indexOf(array, (double) 0, 99, (double) 0.3)); 
     assertEquals(0, ArrayUtils.indexOf(array, (double) 0, 0, (double) 0.3)); 
     assertEquals(4, ArrayUtils.indexOf(array, (double) 0, 3, (double) 0.3)); 
     assertEquals(2, ArrayUtils.indexOf(array, (double) 2.2, 0, (double) 0.35)); 
     assertEquals(3, ArrayUtils.indexOf(array, (double) 4.15, 0, (double) 2.0)); 
     assertEquals(1, ArrayUtils.indexOf(array, (double) 1.00001324, 0, (double) 0.0001)); 
     assertEquals(3, ArrayUtils.indexOf(array, (double) 4.15, -1, (double) 2.0)); 
     assertEquals(1, ArrayUtils.indexOf(array, (double) 1.00001324, -300, (double) 0.0001)); 
 }
@Test
public void testToPrimitive_byte308() { 
     final Byte[] b = null; 
     assertEquals(null, ArrayUtils.toPrimitive(b)); 
     assertSame(ArrayUtils.EMPTY_BYTE_ARRAY, ArrayUtils.toPrimitive(new Byte[0])); 
     assertTrue(Arrays.equals(new byte[] { Byte.MIN_VALUE, Byte.MAX_VALUE, (byte) 9999999 }, ArrayUtils.toPrimitive(new Byte[] { Byte.valueOf(Byte.MIN_VALUE), Byte.valueOf(Byte.MAX_VALUE), Byte.valueOf((byte) 9999999) }))); 
     try { 
         ArrayUtils.toPrimitive(new Byte[] { Byte.valueOf(Byte.MIN_VALUE), null }); 
         fail(); 
     } catch (final NullPointerException ex) { 
     } 
 }
@Test
public void testNullToEmptyString335() { 
     assertArrayEquals(ArrayUtils.EMPTY_STRING_ARRAY, ArrayUtils.nullToEmpty((String[]) null)); 
     final String[] original = new String[] { "abc", "def" }; 
     assertArrayEquals(original, ArrayUtils.nullToEmpty(original)); 
     final String[] empty = new String[] {}; 
     final String[] result = ArrayUtils.nullToEmpty(empty); 
     assertArrayEquals(ArrayUtils.EMPTY_STRING_ARRAY, result); 
     assertTrue(empty != result); 
 }
@Test
public void testNullToEmptyString338() { 
     assertArrayEquals(ArrayUtils.EMPTY_STRING_ARRAY, ArrayUtils.nullToEmpty((String[]) null)); 
     final String[] original = new String[] { "abc", "def" }; 
     assertArrayEquals(original, ArrayUtils.nullToEmpty(original)); 
     final String[] empty = new String[] {}; 
     final String[] result = ArrayUtils.nullToEmpty(empty); 
     assertArrayEquals(ArrayUtils.EMPTY_STRING_ARRAY, result); 
     assertTrue(empty != result); 
 }
@Test
public void testToObject_long349() { 
     final long[] b = null; 
     assertArrayEquals(null, ArrayUtils.toObject(b)); 
     assertSame(ArrayUtils.EMPTY_LONG_OBJECT_ARRAY, ArrayUtils.toObject(new long[0])); 
     assertTrue(Arrays.equals(new Long[] { Long.valueOf(Long.MIN_VALUE), Long.valueOf(Long.MAX_VALUE), Long.valueOf(9999999) }, ArrayUtils.toObject(new long[] { Long.MIN_VALUE, Long.MAX_VALUE, 9999999 }))); 
 }
@Test
public void testIndexOfCharWithStartIndex351() { 
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
public void testReverseChar404() { 
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
public void testIndexOfCharWithStartIndex440() { 
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
public void testToString452() { 
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
public void testNullToEmptyLongObject461() { 
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
public void testReverseLong465() { 
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
public void testContains466() { 
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
public void testNullToEmptyShortObject469() { 
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
public void testSameType470() { 
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
public void testToString478() { 
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
public void testReverseFloat523() { 
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
public void testToObject_double543() { 
     final double[] b = null; 
     assertArrayEquals(null, ArrayUtils.toObject(b)); 
     assertSame(ArrayUtils.EMPTY_DOUBLE_OBJECT_ARRAY, ArrayUtils.toObject(new double[0])); 
     assertTrue(Arrays.equals(new Double[] { Double.valueOf(Double.MIN_VALUE), Double.valueOf(Double.MAX_VALUE), Double.valueOf(9999999) }, ArrayUtils.toObject(new double[] { Double.MIN_VALUE, Double.MAX_VALUE, 9999999 }))); 
 }
@Test
public void testHashCode557() { 
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
public void testToPrimitive_long561() { 
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
public void testReverseByte577() { 
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
public void testToString597() { 
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
public void testToString610() { 
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
public void testSubarrayShort620() { 
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
public void testContainsLong659() { 
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
public void testNullToEmptyShortObject671() { 
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
public void testLastIndexOfCharWithStartIndex676() { 
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
@SuppressWarnings("cast")
@Test
public void testLastIndexOfFloatWithStartIndex700() { 
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
@Test
public void testContainsShort702() { 
     short[] array = null; 
     assertFalse(ArrayUtils.contains(array, (short) 1)); 
     array = new short[] { 0, 1, 2, 3, 0 }; 
     assertTrue(ArrayUtils.contains(array, (short) 0)); 
     assertTrue(ArrayUtils.contains(array, (short) 1)); 
     assertTrue(ArrayUtils.contains(array, (short) 2)); 
     assertTrue(ArrayUtils.contains(array, (short) 3)); 
     assertFalse(ArrayUtils.contains(array, (short) 99)); 
 }
@Test
public void testToPrimitive_char724() { 
     final Character[] b = null; 
     assertEquals(null, ArrayUtils.toPrimitive(b)); 
     assertSame(ArrayUtils.EMPTY_CHAR_ARRAY, ArrayUtils.toPrimitive(new Character[0])); 
     assertTrue(Arrays.equals(new char[] { Character.MIN_VALUE, Character.MAX_VALUE, '0' }, ArrayUtils.toPrimitive(new Character[] { new Character(Character.MIN_VALUE), new Character(Character.MAX_VALUE), new Character('0') }))); 
     try { 
         ArrayUtils.toPrimitive(new Character[] { new Character(Character.MIN_VALUE), null }); 
         fail(); 
     } catch (final NullPointerException ex) { 
     } 
 }
@Test
public void testReverseBoolean734() { 
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
public void testReverseShort748() { 
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
public void testNullToEmptyChar750() { 
     assertEquals(ArrayUtils.EMPTY_CHAR_ARRAY, ArrayUtils.nullToEmpty((char[]) null)); 
     final char[] original = new char[] { 'a', 'b' }; 
     assertEquals(original, ArrayUtils.nullToEmpty(original)); 
     final char[] empty = new char[] {}; 
     final char[] result = ArrayUtils.nullToEmpty(empty); 
     assertEquals(ArrayUtils.EMPTY_CHAR_ARRAY, result); 
     assertTrue(empty != result); 
 }
@Test
public void testSameLength773() { 
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
public void testSubarrayByte786() { 
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
public void testToString808() { 
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
public void testToObject_byte810() { 
     final byte[] b = null; 
     assertArrayEquals(null, ArrayUtils.toObject(b)); 
     assertSame(ArrayUtils.EMPTY_BYTE_OBJECT_ARRAY, ArrayUtils.toObject(new byte[0])); 
     assertTrue(Arrays.equals(new Byte[] { Byte.valueOf(Byte.MIN_VALUE), Byte.valueOf(Byte.MAX_VALUE), Byte.valueOf((byte) 9999999) }, ArrayUtils.toObject(new byte[] { Byte.MIN_VALUE, Byte.MAX_VALUE, (byte) 9999999 }))); 
 }
@Test
public void testContainsShort815() { 
     short[] array = null; 
     assertFalse(ArrayUtils.contains(array, (short) 1)); 
     array = new short[] { 0, 1, 2, 3, 0 }; 
     assertTrue(ArrayUtils.contains(array, (short) 0)); 
     assertTrue(ArrayUtils.contains(array, (short) 1)); 
     assertTrue(ArrayUtils.contains(array, (short) 2)); 
     assertTrue(ArrayUtils.contains(array, (short) 3)); 
     assertFalse(ArrayUtils.contains(array, (short) 99)); 
 }
@Test
public void testSubarrayBoolean827() { 
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
public void testNullToEmptyIntObject841() { 
     assertArrayEquals(ArrayUtils.EMPTY_INTEGER_OBJECT_ARRAY, ArrayUtils.nullToEmpty((Integer[]) null)); 
     final Integer[] original = new Integer[] { 1, 2 }; 
     assertArrayEquals(original, ArrayUtils.nullToEmpty(original)); 
     final Integer[] empty = new Integer[] {}; 
     final Integer[] result = ArrayUtils.nullToEmpty(empty); 
     assertArrayEquals(ArrayUtils.EMPTY_INTEGER_OBJECT_ARRAY, result); 
     assertTrue(empty != result); 
 }
@Test
public void testToPrimitive_char870() { 
     final Character[] b = null; 
     assertEquals(null, ArrayUtils.toPrimitive(b)); 
     assertSame(ArrayUtils.EMPTY_CHAR_ARRAY, ArrayUtils.toPrimitive(new Character[0])); 
     assertTrue(Arrays.equals(new char[] { Character.MIN_VALUE, Character.MAX_VALUE, '0' }, ArrayUtils.toPrimitive(new Character[] { new Character(Character.MIN_VALUE), new Character(Character.MAX_VALUE), new Character('0') }))); 
     try { 
         ArrayUtils.toPrimitive(new Character[] { new Character(Character.MIN_VALUE), null }); 
         fail(); 
     } catch (final NullPointerException ex) { 
     } 
 } 
@SuppressWarnings("cast")
@Test
public void testContainsFloat871() { 
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
public void testIsEmptyObject874() { 
     final Object[] emptyArray = new Object[] {}; 
     final Object[] notEmptyArray = new Object[] { new String("Value") }; 
     assertTrue(ArrayUtils.isEmpty((Object[]) null)); 
     assertTrue(ArrayUtils.isEmpty(emptyArray)); 
     assertFalse(ArrayUtils.isEmpty(notEmptyArray)); 
 }
@Test
public void testToPrimitive_long877() { 
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
public void testToPrimitive_float_float914() { 
     final Float[] l = null; 
     assertEquals(null, ArrayUtils.toPrimitive(l, Float.MIN_VALUE)); 
     assertSame(ArrayUtils.EMPTY_FLOAT_ARRAY, ArrayUtils.toPrimitive(new Float[0], 1)); 
     assertTrue(Arrays.equals(new float[] { Float.MIN_VALUE, Float.MAX_VALUE, 9999999 }, ArrayUtils.toPrimitive(new Float[] { Float.valueOf(Float.MIN_VALUE), Float.valueOf(Float.MAX_VALUE), Float.valueOf(9999999) }, 1))); 
     assertTrue(Arrays.equals(new float[] { Float.MIN_VALUE, Float.MAX_VALUE, 9999999 }, ArrayUtils.toPrimitive(new Float[] { Float.valueOf(Float.MIN_VALUE), null, Float.valueOf(9999999) }, Float.MAX_VALUE))); 
 }
@Test
public void testReverseChar918() { 
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
public void testLastIndexOfByteWithStartIndex924() { 
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
public void testReverseByte939() { 
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
public void testSameLengthBoolean961() { 
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
public void testNullToEmptyObject983() { 
     assertArrayEquals(ArrayUtils.EMPTY_OBJECT_ARRAY, ArrayUtils.nullToEmpty((Object[]) null)); 
     final Object[] original = new Object[] { Boolean.TRUE, Boolean.FALSE }; 
     assertArrayEquals(original, ArrayUtils.nullToEmpty(original)); 
     final Object[] empty = new Object[] {}; 
     final Object[] result = ArrayUtils.nullToEmpty(empty); 
     assertArrayEquals(ArrayUtils.EMPTY_OBJECT_ARRAY, result); 
     assertTrue(empty != result); 
 }
@Test
public void testToPrimitive_byte1011() { 
     final Byte[] b = null; 
     assertEquals(null, ArrayUtils.toPrimitive(b)); 
     assertSame(ArrayUtils.EMPTY_BYTE_ARRAY, ArrayUtils.toPrimitive(new Byte[0])); 
     assertTrue(Arrays.equals(new byte[] { Byte.MIN_VALUE, Byte.MAX_VALUE, (byte) 9999999 }, ArrayUtils.toPrimitive(new Byte[] { Byte.valueOf(Byte.MIN_VALUE), Byte.valueOf(Byte.MAX_VALUE), Byte.valueOf((byte) 9999999) }))); 
     try { 
         ArrayUtils.toPrimitive(new Byte[] { Byte.valueOf(Byte.MIN_VALUE), null }); 
         fail(); 
     } catch (final NullPointerException ex) { 
     } 
 } 
@SuppressWarnings("cast")
@Test
public void testLastIndexOfFloatWithStartIndex1025() { 
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
@Test
public void testIsEmptyPrimitives1028() { 
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
public void testIsEmptyPrimitives1068() { 
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
public void testSubarrayShort1072() { 
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
public void testToPrimitive_char1093() { 
     final Character[] b = null; 
     assertEquals(null, ArrayUtils.toPrimitive(b)); 
     assertSame(ArrayUtils.EMPTY_CHAR_ARRAY, ArrayUtils.toPrimitive(new Character[0])); 
     assertTrue(Arrays.equals(new char[] { Character.MIN_VALUE, Character.MAX_VALUE, '0' }, ArrayUtils.toPrimitive(new Character[] { new Character(Character.MIN_VALUE), new Character(Character.MAX_VALUE), new Character('0') }))); 
     try { 
         ArrayUtils.toPrimitive(new Character[] { new Character(Character.MIN_VALUE), null }); 
         fail(); 
     } catch (final NullPointerException ex) { 
     } 
 }
@Test
public void testSameLength1111() { 
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
public void testSubarrayFloat1122() { 
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
public void testToObject_char1130() { 
     final char[] b = null; 
     assertArrayEquals(null, ArrayUtils.toObject(b)); 
     assertSame(ArrayUtils.EMPTY_CHARACTER_OBJECT_ARRAY, ArrayUtils.toObject(new char[0])); 
     assertTrue(Arrays.equals(new Character[] { new Character(Character.MIN_VALUE), new Character(Character.MAX_VALUE), new Character('0') }, ArrayUtils.toObject(new char[] { Character.MIN_VALUE, Character.MAX_VALUE, '0' }))); 
 }
@Test
public void testLastIndexOfInt1132() { 
     int[] array = null; 
     assertEquals(-1, ArrayUtils.lastIndexOf(array, 0)); 
     array = new int[] { 0, 1, 2, 3, 0 }; 
     assertEquals(4, ArrayUtils.lastIndexOf(array, 0)); 
     assertEquals(1, ArrayUtils.lastIndexOf(array, 1)); 
     assertEquals(2, ArrayUtils.lastIndexOf(array, 2)); 
     assertEquals(3, ArrayUtils.lastIndexOf(array, 3)); 
     assertEquals(-1, ArrayUtils.lastIndexOf(array, 99)); 
 }
@Test
public void testToPrimitive_char_char1150() { 
     final Character[] b = null; 
     assertEquals(null, ArrayUtils.toPrimitive(b, Character.MIN_VALUE)); 
     assertSame(ArrayUtils.EMPTY_CHAR_ARRAY, ArrayUtils.toPrimitive(new Character[0], (char) 0)); 
     assertTrue(Arrays.equals(new char[] { Character.MIN_VALUE, Character.MAX_VALUE, '0' }, ArrayUtils.toPrimitive(new Character[] { new Character(Character.MIN_VALUE), new Character(Character.MAX_VALUE), new Character('0') }, Character.MIN_VALUE))); 
     assertTrue(Arrays.equals(new char[] { Character.MIN_VALUE, Character.MAX_VALUE, '0' }, ArrayUtils.toPrimitive(new Character[] { new Character(Character.MIN_VALUE), null, new Character('0') }, Character.MAX_VALUE))); 
 }
@Test
public void testToPrimitive_float1158() { 
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
public void testLastIndexOfShort1159() { 
     short[] array = null; 
     assertEquals(-1, ArrayUtils.lastIndexOf(array, (short) 0)); 
     array = new short[] { 0, 1, 2, 3, 0 }; 
     assertEquals(4, ArrayUtils.lastIndexOf(array, (short) 0)); 
     assertEquals(1, ArrayUtils.lastIndexOf(array, (short) 1)); 
     assertEquals(2, ArrayUtils.lastIndexOf(array, (short) 2)); 
     assertEquals(3, ArrayUtils.lastIndexOf(array, (short) 3)); 
     assertEquals(-1, ArrayUtils.lastIndexOf(array, (short) 99)); 
 }
@Test
public void testNullToEmptyByteObject1191() { 
     assertArrayEquals(ArrayUtils.EMPTY_BYTE_OBJECT_ARRAY, ArrayUtils.nullToEmpty((Byte[]) null)); 
     final Byte[] original = new Byte[] { 0x0F, 0x0E }; 
     assertArrayEquals(original, ArrayUtils.nullToEmpty(original)); 
     final Byte[] empty = new Byte[] {}; 
     final Byte[] result = ArrayUtils.nullToEmpty(empty); 
     assertArrayEquals(ArrayUtils.EMPTY_BYTE_OBJECT_ARRAY, result); 
     assertTrue(empty != result); 
 }
@Test
public void testSubarrayFloat1225() { 
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
public void testToObject_short1238() { 
     final short[] b = null; 
     assertArrayEquals(null, ArrayUtils.toObject(b)); 
     assertSame(ArrayUtils.EMPTY_SHORT_OBJECT_ARRAY, ArrayUtils.toObject(new short[0])); 
     assertTrue(Arrays.equals(new Short[] { Short.valueOf(Short.MIN_VALUE), Short.valueOf(Short.MAX_VALUE), Short.valueOf((short) 9999999) }, ArrayUtils.toObject(new short[] { Short.MIN_VALUE, Short.MAX_VALUE, (short) 9999999 }))); 
 }
@Test
public void testToPrimitive_byte_byte1253() { 
     final Byte[] b = null; 
     assertEquals(null, ArrayUtils.toPrimitive(b, Byte.MIN_VALUE)); 
     assertSame(ArrayUtils.EMPTY_BYTE_ARRAY, ArrayUtils.toPrimitive(new Byte[0], (byte) 1)); 
     assertTrue(Arrays.equals(new byte[] { Byte.MIN_VALUE, Byte.MAX_VALUE, (byte) 9999999 }, ArrayUtils.toPrimitive(new Byte[] { Byte.valueOf(Byte.MIN_VALUE), Byte.valueOf(Byte.MAX_VALUE), Byte.valueOf((byte) 9999999) }, Byte.MIN_VALUE))); 
     assertTrue(Arrays.equals(new byte[] { Byte.MIN_VALUE, Byte.MAX_VALUE, (byte) 9999999 }, ArrayUtils.toPrimitive(new Byte[] { Byte.valueOf(Byte.MIN_VALUE), null, Byte.valueOf((byte) 9999999) }, Byte.MAX_VALUE))); 
 }
@Test
public void testToPrimitive_boolean_boolean1270() { 
     assertEquals(null, ArrayUtils.toPrimitive(null, false)); 
     assertSame(ArrayUtils.EMPTY_BOOLEAN_ARRAY, ArrayUtils.toPrimitive(new Boolean[0], false)); 
     assertTrue(Arrays.equals(new boolean[] { true, false, true }, ArrayUtils.toPrimitive(new Boolean[] { Boolean.TRUE, Boolean.FALSE, Boolean.TRUE }, false))); 
     assertTrue(Arrays.equals(new boolean[] { true, false, false }, ArrayUtils.toPrimitive(new Boolean[] { Boolean.TRUE, null, Boolean.FALSE }, false))); 
     assertTrue(Arrays.equals(new boolean[] { true, true, false }, ArrayUtils.toPrimitive(new Boolean[] { Boolean.TRUE, null, Boolean.FALSE }, true))); 
 }
@Test
public void testToPrimitive_intNull1273() { 
     final Integer[] iArray = null; 
     assertEquals(null, ArrayUtils.toPrimitive(iArray, Integer.MIN_VALUE)); 
 } 
@SuppressWarnings("cast")
@Test
public void testLastIndexOfDoubleWithStartIndex1275() { 
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
@Test
public void testSubarrayFloat1289() { 
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
public void testContainsShort1305() { 
     short[] array = null; 
     assertFalse(ArrayUtils.contains(array, (short) 1)); 
     array = new short[] { 0, 1, 2, 3, 0 }; 
     assertTrue(ArrayUtils.contains(array, (short) 0)); 
     assertTrue(ArrayUtils.contains(array, (short) 1)); 
     assertTrue(ArrayUtils.contains(array, (short) 2)); 
     assertTrue(ArrayUtils.contains(array, (short) 3)); 
     assertFalse(ArrayUtils.contains(array, (short) 99)); 
 }
@Test
public void testSubarrayByte1309() { 
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
public void testNullToEmptyBooleanObject1312() { 
     assertArrayEquals(ArrayUtils.EMPTY_BOOLEAN_OBJECT_ARRAY, ArrayUtils.nullToEmpty((Boolean[]) null)); 
     final Boolean[] original = new Boolean[] { Boolean.TRUE, Boolean.FALSE }; 
     assertArrayEquals(original, ArrayUtils.nullToEmpty(original)); 
     final Boolean[] empty = new Boolean[] {}; 
     final Boolean[] result = ArrayUtils.nullToEmpty(empty); 
     assertArrayEquals(ArrayUtils.EMPTY_BOOLEAN_OBJECT_ARRAY, result); 
     assertTrue(empty != result); 
 }
@Test
public void testToString1320() { 
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
public void testSubarrChar1331() { 
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
public void testToObject_double1332() { 
     final double[] b = null; 
     assertArrayEquals(null, ArrayUtils.toObject(b)); 
     assertSame(ArrayUtils.EMPTY_DOUBLE_OBJECT_ARRAY, ArrayUtils.toObject(new double[0])); 
     assertTrue(Arrays.equals(new Double[] { Double.valueOf(Double.MIN_VALUE), Double.valueOf(Double.MAX_VALUE), Double.valueOf(9999999) }, ArrayUtils.toObject(new double[] { Double.MIN_VALUE, Double.MAX_VALUE, 9999999 }))); 
 }
@Test
public void testLastIndexOfByteWithStartIndex1333() { 
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
public void testLastIndexOfLongWithStartIndex1363() { 
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
public void testIndexOfCharWithStartIndex1367() { 
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
public void testToPrimitive_double1373() { 
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
public void testNullToEmptyDoubleObject1378() { 
     assertArrayEquals(ArrayUtils.EMPTY_DOUBLE_OBJECT_ARRAY, ArrayUtils.nullToEmpty((Double[]) null)); 
     final Double[] original = new Double[] { 1D, 2D }; 
     assertArrayEquals(original, ArrayUtils.nullToEmpty(original)); 
     final Double[] empty = new Double[] {}; 
     final Double[] result = ArrayUtils.nullToEmpty(empty); 
     assertArrayEquals(ArrayUtils.EMPTY_DOUBLE_OBJECT_ARRAY, result); 
     assertTrue(empty != result); 
 }
@Test
public void testToPrimitive_byte_byte1383() { 
     final Byte[] b = null; 
     assertEquals(null, ArrayUtils.toPrimitive(b, Byte.MIN_VALUE)); 
     assertSame(ArrayUtils.EMPTY_BYTE_ARRAY, ArrayUtils.toPrimitive(new Byte[0], (byte) 1)); 
     assertTrue(Arrays.equals(new byte[] { Byte.MIN_VALUE, Byte.MAX_VALUE, (byte) 9999999 }, ArrayUtils.toPrimitive(new Byte[] { Byte.valueOf(Byte.MIN_VALUE), Byte.valueOf(Byte.MAX_VALUE), Byte.valueOf((byte) 9999999) }, Byte.MIN_VALUE))); 
     assertTrue(Arrays.equals(new byte[] { Byte.MIN_VALUE, Byte.MAX_VALUE, (byte) 9999999 }, ArrayUtils.toPrimitive(new Byte[] { Byte.valueOf(Byte.MIN_VALUE), null, Byte.valueOf((byte) 9999999) }, Byte.MAX_VALUE))); 
 } 
@SuppressWarnings("cast")
@Test
public void testLastIndexOfFloatWithStartIndex1391() { 
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
@Test
public void testToObject_byte1396() { 
     final byte[] b = null; 
     assertArrayEquals(null, ArrayUtils.toObject(b)); 
     assertSame(ArrayUtils.EMPTY_BYTE_OBJECT_ARRAY, ArrayUtils.toObject(new byte[0])); 
     assertTrue(Arrays.equals(new Byte[] { Byte.valueOf(Byte.MIN_VALUE), Byte.valueOf(Byte.MAX_VALUE), Byte.valueOf((byte) 9999999) }, ArrayUtils.toObject(new byte[] { Byte.MIN_VALUE, Byte.MAX_VALUE, (byte) 9999999 }))); 
 }
@Test
public void testLastIndexOfInt1449() { 
     int[] array = null; 
     assertEquals(-1, ArrayUtils.lastIndexOf(array, 0)); 
     array = new int[] { 0, 1, 2, 3, 0 }; 
     assertEquals(4, ArrayUtils.lastIndexOf(array, 0)); 
     assertEquals(1, ArrayUtils.lastIndexOf(array, 1)); 
     assertEquals(2, ArrayUtils.lastIndexOf(array, 2)); 
     assertEquals(3, ArrayUtils.lastIndexOf(array, 3)); 
     assertEquals(-1, ArrayUtils.lastIndexOf(array, 99)); 
 }
@Test
public void testToString1454() { 
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
public void testSubarrayDouble1462() { 
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
public void testToString1464() { 
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
public void testToPrimitive_long1488() { 
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
public void testToPrimitive_boolean_boolean1495() { 
     assertEquals(null, ArrayUtils.toPrimitive(null, false)); 
     assertSame(ArrayUtils.EMPTY_BOOLEAN_ARRAY, ArrayUtils.toPrimitive(new Boolean[0], false)); 
     assertTrue(Arrays.equals(new boolean[] { true, false, true }, ArrayUtils.toPrimitive(new Boolean[] { Boolean.TRUE, Boolean.FALSE, Boolean.TRUE }, false))); 
     assertTrue(Arrays.equals(new boolean[] { true, false, false }, ArrayUtils.toPrimitive(new Boolean[] { Boolean.TRUE, null, Boolean.FALSE }, false))); 
     assertTrue(Arrays.equals(new boolean[] { true, true, false }, ArrayUtils.toPrimitive(new Boolean[] { Boolean.TRUE, null, Boolean.FALSE }, true))); 
 }
@Test
public void testSubarrayBoolean1535() { 
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
public void testNullToEmptyShort1550() { 
     assertEquals(ArrayUtils.EMPTY_SHORT_ARRAY, ArrayUtils.nullToEmpty((short[]) null)); 
     final short[] original = new short[] { 1, 2 }; 
     assertEquals(original, ArrayUtils.nullToEmpty(original)); 
     final short[] empty = new short[] {}; 
     final short[] result = ArrayUtils.nullToEmpty(empty); 
     assertEquals(ArrayUtils.EMPTY_SHORT_ARRAY, result); 
     assertTrue(empty != result); 
 }
@Test
public void testIndexOfCharWithStartIndex1554() { 
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
public void testContainsShort1563() { 
     short[] array = null; 
     assertFalse(ArrayUtils.contains(array, (short) 1)); 
     array = new short[] { 0, 1, 2, 3, 0 }; 
     assertTrue(ArrayUtils.contains(array, (short) 0)); 
     assertTrue(ArrayUtils.contains(array, (short) 1)); 
     assertTrue(ArrayUtils.contains(array, (short) 2)); 
     assertTrue(ArrayUtils.contains(array, (short) 3)); 
     assertFalse(ArrayUtils.contains(array, (short) 99)); 
 }
@Test
public void testToString1571() { 
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
public void testLastIndexOfLongWithStartIndex1577() { 
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
public void testReverseLong1591() { 
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
public void testSubarrChar1630() { 
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
public void testToPrimitive_long_long1632() { 
     final Long[] l = null; 
     assertEquals(null, ArrayUtils.toPrimitive(l, Long.MIN_VALUE)); 
     assertSame(ArrayUtils.EMPTY_LONG_ARRAY, ArrayUtils.toPrimitive(new Long[0], 1)); 
     assertTrue(Arrays.equals(new long[] { Long.MIN_VALUE, Long.MAX_VALUE, 9999999 }, ArrayUtils.toPrimitive(new Long[] { Long.valueOf(Long.MIN_VALUE), Long.valueOf(Long.MAX_VALUE), Long.valueOf(9999999) }, 1))); 
     assertTrue(Arrays.equals(new long[] { Long.MIN_VALUE, Long.MAX_VALUE, 9999999 }, ArrayUtils.toPrimitive(new Long[] { Long.valueOf(Long.MIN_VALUE), null, Long.valueOf(9999999) }, Long.MAX_VALUE))); 
 }
@Test
public void testContains1638() { 
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
public void testToObject_char1644() { 
     final char[] b = null; 
     assertArrayEquals(null, ArrayUtils.toObject(b)); 
     assertSame(ArrayUtils.EMPTY_CHARACTER_OBJECT_ARRAY, ArrayUtils.toObject(new char[0])); 
     assertTrue(Arrays.equals(new Character[] { new Character(Character.MIN_VALUE), new Character(Character.MAX_VALUE), new Character('0') }, ArrayUtils.toObject(new char[] { Character.MIN_VALUE, Character.MAX_VALUE, '0' }))); 
 } 
@SuppressWarnings("cast")
@Test
public void testLastIndexOfDoubleWithStartIndex1647() { 
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
public void testContainsDouble1658() { 
     double[] array = null; 
     assertFalse(ArrayUtils.contains(array, (double) 1)); 
     array = new double[] { 0, 1, 2, 3, 0 }; 
     assertTrue(ArrayUtils.contains(array, (double) 0)); 
     assertTrue(ArrayUtils.contains(array, (double) 1)); 
     assertTrue(ArrayUtils.contains(array, (double) 2)); 
     assertTrue(ArrayUtils.contains(array, (double) 3)); 
     assertFalse(ArrayUtils.contains(array, (double) 99)); 
 }
@Test
public void testReverseDouble1665() { 
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
public void testNullToEmptyDoubleObject1668() { 
     assertArrayEquals(ArrayUtils.EMPTY_DOUBLE_OBJECT_ARRAY, ArrayUtils.nullToEmpty((Double[]) null)); 
     final Double[] original = new Double[] { 1D, 2D }; 
     assertArrayEquals(original, ArrayUtils.nullToEmpty(original)); 
     final Double[] empty = new Double[] {}; 
     final Double[] result = ArrayUtils.nullToEmpty(empty); 
     assertArrayEquals(ArrayUtils.EMPTY_DOUBLE_OBJECT_ARRAY, result); 
     assertTrue(empty != result); 
 }
@Test
public void testIndexOfBooleanWithStartIndex1669() { 
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
public void testToString1677() { 
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
public void testNullToEmptyBoolean1691() { 
     assertEquals(ArrayUtils.EMPTY_BOOLEAN_ARRAY, ArrayUtils.nullToEmpty((boolean[]) null)); 
     final boolean[] original = new boolean[] { true, false }; 
     assertEquals(original, ArrayUtils.nullToEmpty(original)); 
     final boolean[] empty = new boolean[] {}; 
     final boolean[] result = ArrayUtils.nullToEmpty(empty); 
     assertEquals(ArrayUtils.EMPTY_BOOLEAN_ARRAY, result); 
     assertTrue(empty != result); 
 }
@Test
public void testToPrimitive_int1715() { 
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
public void testCloneChar1719() { 
     assertEquals(null, ArrayUtils.clone((char[]) null)); 
     final char[] original = new char[] { 'a', '4' }; 
     final char[] cloned = ArrayUtils.clone(original); 
     assertTrue(Arrays.equals(original, cloned)); 
     assertTrue(original != cloned); 
 }
@Test
public void testToString1721() { 
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
public void testNullToEmptyByte1731() { 
     assertEquals(ArrayUtils.EMPTY_BYTE_ARRAY, ArrayUtils.nullToEmpty((byte[]) null)); 
     final byte[] original = new byte[] { 0x0F, 0x0E }; 
     assertEquals(original, ArrayUtils.nullToEmpty(original)); 
     final byte[] empty = new byte[] {}; 
     final byte[] result = ArrayUtils.nullToEmpty(empty); 
     assertEquals(ArrayUtils.EMPTY_BYTE_ARRAY, result); 
     assertTrue(empty != result); 
 }
@Test
public void testToString1742() { 
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
public void testToString1784() { 
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
public void testReverseByte1803() { 
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
public void testContainsByte1805() { 
     byte[] array = null; 
     assertFalse(ArrayUtils.contains(array, (byte) 1)); 
     array = new byte[] { 0, 1, 2, 3, 0 }; 
     assertTrue(ArrayUtils.contains(array, (byte) 0)); 
     assertTrue(ArrayUtils.contains(array, (byte) 1)); 
     assertTrue(ArrayUtils.contains(array, (byte) 2)); 
     assertTrue(ArrayUtils.contains(array, (byte) 3)); 
     assertFalse(ArrayUtils.contains(array, (byte) 99)); 
 }
@Test
public void testToPrimitive_double_double1820() { 
     final Double[] l = null; 
     assertEquals(null, ArrayUtils.toPrimitive(l, Double.MIN_VALUE)); 
     assertSame(ArrayUtils.EMPTY_DOUBLE_ARRAY, ArrayUtils.toPrimitive(new Double[0], 1)); 
     assertTrue(Arrays.equals(new double[] { Double.MIN_VALUE, Double.MAX_VALUE, 9999999 }, ArrayUtils.toPrimitive(new Double[] { Double.valueOf(Double.MIN_VALUE), Double.valueOf(Double.MAX_VALUE), Double.valueOf(9999999) }, 1))); 
     assertTrue(Arrays.equals(new double[] { Double.MIN_VALUE, Double.MAX_VALUE, 9999999 }, ArrayUtils.toPrimitive(new Double[] { Double.valueOf(Double.MIN_VALUE), null, Double.valueOf(9999999) }, Double.MAX_VALUE))); 
 }
@Test
public void testLastIndexOfLongWithStartIndex1840() { 
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
public void testToPrimitive_boolean_boolean1871() { 
     assertEquals(null, ArrayUtils.toPrimitive(null, false)); 
     assertSame(ArrayUtils.EMPTY_BOOLEAN_ARRAY, ArrayUtils.toPrimitive(new Boolean[0], false)); 
     assertTrue(Arrays.equals(new boolean[] { true, false, true }, ArrayUtils.toPrimitive(new Boolean[] { Boolean.TRUE, Boolean.FALSE, Boolean.TRUE }, false))); 
     assertTrue(Arrays.equals(new boolean[] { true, false, false }, ArrayUtils.toPrimitive(new Boolean[] { Boolean.TRUE, null, Boolean.FALSE }, false))); 
     assertTrue(Arrays.equals(new boolean[] { true, true, false }, ArrayUtils.toPrimitive(new Boolean[] { Boolean.TRUE, null, Boolean.FALSE }, true))); 
 }
@Test
public void testReverse1875() { 
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
public void testIndexOfIntWithStartIndex1885() { 
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
public void testToPrimitive_long_long1890() { 
     final Long[] l = null; 
     assertEquals(null, ArrayUtils.toPrimitive(l, Long.MIN_VALUE)); 
     assertSame(ArrayUtils.EMPTY_LONG_ARRAY, ArrayUtils.toPrimitive(new Long[0], 1)); 
     assertTrue(Arrays.equals(new long[] { Long.MIN_VALUE, Long.MAX_VALUE, 9999999 }, ArrayUtils.toPrimitive(new Long[] { Long.valueOf(Long.MIN_VALUE), Long.valueOf(Long.MAX_VALUE), Long.valueOf(9999999) }, 1))); 
     assertTrue(Arrays.equals(new long[] { Long.MIN_VALUE, Long.MAX_VALUE, 9999999 }, ArrayUtils.toPrimitive(new Long[] { Long.valueOf(Long.MIN_VALUE), null, Long.valueOf(9999999) }, Long.MAX_VALUE))); 
 } 
@SuppressWarnings("cast")
@Test
public void testIndexOfDoubleWithStartIndexTolerance1896() { 
     double[] array = null; 
     assertEquals(-1, ArrayUtils.indexOf(array, (double) 0, 2, (double) 0)); 
     array = new double[0]; 
     assertEquals(-1, ArrayUtils.indexOf(array, (double) 0, 2, (double) 0)); 
     array = new double[] { 0, 1, 2, 3, 0 }; 
     assertEquals(-1, ArrayUtils.indexOf(array, (double) 0, 99, (double) 0.3)); 
     assertEquals(0, ArrayUtils.indexOf(array, (double) 0, 0, (double) 0.3)); 
     assertEquals(4, ArrayUtils.indexOf(array, (double) 0, 3, (double) 0.3)); 
     assertEquals(2, ArrayUtils.indexOf(array, (double) 2.2, 0, (double) 0.35)); 
     assertEquals(3, ArrayUtils.indexOf(array, (double) 4.15, 0, (double) 2.0)); 
     assertEquals(1, ArrayUtils.indexOf(array, (double) 1.00001324, 0, (double) 0.0001)); 
     assertEquals(3, ArrayUtils.indexOf(array, (double) 4.15, -1, (double) 2.0)); 
     assertEquals(1, ArrayUtils.indexOf(array, (double) 1.00001324, -300, (double) 0.0001)); 
 }
@Test
public void testLastIndexOfShort1897() { 
     short[] array = null; 
     assertEquals(-1, ArrayUtils.lastIndexOf(array, (short) 0)); 
     array = new short[] { 0, 1, 2, 3, 0 }; 
     assertEquals(4, ArrayUtils.lastIndexOf(array, (short) 0)); 
     assertEquals(1, ArrayUtils.lastIndexOf(array, (short) 1)); 
     assertEquals(2, ArrayUtils.lastIndexOf(array, (short) 2)); 
     assertEquals(3, ArrayUtils.lastIndexOf(array, (short) 3)); 
     assertEquals(-1, ArrayUtils.lastIndexOf(array, (short) 99)); 
 }
@Test
public void testToPrimitive_byte1912() { 
     final Byte[] b = null; 
     assertEquals(null, ArrayUtils.toPrimitive(b)); 
     assertSame(ArrayUtils.EMPTY_BYTE_ARRAY, ArrayUtils.toPrimitive(new Byte[0])); 
     assertTrue(Arrays.equals(new byte[] { Byte.MIN_VALUE, Byte.MAX_VALUE, (byte) 9999999 }, ArrayUtils.toPrimitive(new Byte[] { Byte.valueOf(Byte.MIN_VALUE), Byte.valueOf(Byte.MAX_VALUE), Byte.valueOf((byte) 9999999) }))); 
     try { 
         ArrayUtils.toPrimitive(new Byte[] { Byte.valueOf(Byte.MIN_VALUE), null }); 
         fail(); 
     } catch (final NullPointerException ex) { 
     } 
 }
@Test
public void testReverseFloat1917() { 
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
public void testLastIndexOfShortWithStartIndex1948() { 
     short[] array = null; 
     assertEquals(-1, ArrayUtils.lastIndexOf(array, (short) 0, 2)); 
     array = new short[] { 0, 1, 2, 3, 0 }; 
     assertEquals(0, ArrayUtils.lastIndexOf(array, (short) 0, 2)); 
     assertEquals(1, ArrayUtils.lastIndexOf(array, (short) 1, 2)); 
     assertEquals(2, ArrayUtils.lastIndexOf(array, (short) 2, 2)); 
     assertEquals(-1, ArrayUtils.lastIndexOf(array, (short) 3, 2)); 
     assertEquals(-1, ArrayUtils.lastIndexOf(array, (short) 3, -1)); 
     assertEquals(-1, ArrayUtils.lastIndexOf(array, (short) 99)); 
     assertEquals(4, ArrayUtils.lastIndexOf(array, (short) 0, 88)); 
 }
@Test
public void testReverseInt1960() { 
     int[] array = new int[] { 1, 2, 3 }; 
     ArrayUtils.reverse(array); 
     assertEquals(array[0], 3); 
     assertEquals(array[1], 2); 
     assertEquals(array[2], 1); 
     array = null; 
     ArrayUtils.reverse(array); 
     assertEquals(null, array); 
 }
@Test
public void testIndexOfIntWithStartIndex1967() { 
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
public void testToPrimitive_int_int1971() { 
     final Long[] l = null; 
     assertEquals(null, ArrayUtils.toPrimitive(l, Integer.MIN_VALUE)); 
     assertSame(ArrayUtils.EMPTY_INT_ARRAY, ArrayUtils.toPrimitive(new Integer[0], 1)); 
     assertTrue(Arrays.equals(new int[] { Integer.MIN_VALUE, Integer.MAX_VALUE, 9999999 }, ArrayUtils.toPrimitive(new Integer[] { Integer.valueOf(Integer.MIN_VALUE), Integer.valueOf(Integer.MAX_VALUE), Integer.valueOf(9999999) }, 1))); 
     assertTrue(Arrays.equals(new int[] { Integer.MIN_VALUE, Integer.MAX_VALUE, 9999999 }, ArrayUtils.toPrimitive(new Integer[] { Integer.valueOf(Integer.MIN_VALUE), null, Integer.valueOf(9999999) }, Integer.MAX_VALUE))); 
 } 
@SuppressWarnings("cast")
@Test
public void testIndexOfDoubleWithStartIndexTolerance1975() { 
     double[] array = null; 
     assertEquals(-1, ArrayUtils.indexOf(array, (double) 0, 2, (double) 0)); 
     array = new double[0]; 
     assertEquals(-1, ArrayUtils.indexOf(array, (double) 0, 2, (double) 0)); 
     array = new double[] { 0, 1, 2, 3, 0 }; 
     assertEquals(-1, ArrayUtils.indexOf(array, (double) 0, 99, (double) 0.3)); 
     assertEquals(0, ArrayUtils.indexOf(array, (double) 0, 0, (double) 0.3)); 
     assertEquals(4, ArrayUtils.indexOf(array, (double) 0, 3, (double) 0.3)); 
     assertEquals(2, ArrayUtils.indexOf(array, (double) 2.2, 0, (double) 0.35)); 
     assertEquals(3, ArrayUtils.indexOf(array, (double) 4.15, 0, (double) 2.0)); 
     assertEquals(1, ArrayUtils.indexOf(array, (double) 1.00001324, 0, (double) 0.0001)); 
     assertEquals(3, ArrayUtils.indexOf(array, (double) 4.15, -1, (double) 2.0)); 
     assertEquals(1, ArrayUtils.indexOf(array, (double) 1.00001324, -300, (double) 0.0001)); 
 }
@Test
public void testIsNotEmptyPrimitives1976() { 
     final long[] emptyLongArray = new long[] {}; 
     final long[] notEmptyLongArray = new long[] { 1L }; 
     assertFalse(ArrayUtils.isNotEmpty((long[]) null)); 
     assertFalse(ArrayUtils.isNotEmpty(emptyLongArray)); 
     assertTrue(ArrayUtils.isNotEmpty(notEmptyLongArray)); 
     final int[] emptyIntArray = new int[] {}; 
     final int[] notEmptyIntArray = new int[] { 1 }; 
     assertFalse(ArrayUtils.isNotEmpty((int[]) null)); 
     assertFalse(ArrayUtils.isNotEmpty(emptyIntArray)); 
     assertTrue(ArrayUtils.isNotEmpty(notEmptyIntArray)); 
     final short[] emptyShortArray = new short[] {}; 
     final short[] notEmptyShortArray = new short[] { 1 }; 
     assertFalse(ArrayUtils.isNotEmpty((short[]) null)); 
     assertFalse(ArrayUtils.isNotEmpty(emptyShortArray)); 
     assertTrue(ArrayUtils.isNotEmpty(notEmptyShortArray)); 
     final char[] emptyCharArray = new char[] {}; 
     final char[] notEmptyCharArray = new char[] { 1 }; 
     assertFalse(ArrayUtils.isNotEmpty((char[]) null)); 
     assertFalse(ArrayUtils.isNotEmpty(emptyCharArray)); 
     assertTrue(ArrayUtils.isNotEmpty(notEmptyCharArray)); 
     final byte[] emptyByteArray = new byte[] {}; 
     final byte[] notEmptyByteArray = new byte[] { 1 }; 
     assertFalse(ArrayUtils.isNotEmpty((byte[]) null)); 
     assertFalse(ArrayUtils.isNotEmpty(emptyByteArray)); 
     assertTrue(ArrayUtils.isNotEmpty(notEmptyByteArray)); 
     final double[] emptyDoubleArray = new double[] {}; 
     final double[] notEmptyDoubleArray = new double[] { 1.0 }; 
     assertFalse(ArrayUtils.isNotEmpty((double[]) null)); 
     assertFalse(ArrayUtils.isNotEmpty(emptyDoubleArray)); 
     assertTrue(ArrayUtils.isNotEmpty(notEmptyDoubleArray)); 
     final float[] emptyFloatArray = new float[] {}; 
     final float[] notEmptyFloatArray = new float[] { 1.0F }; 
     assertFalse(ArrayUtils.isNotEmpty((float[]) null)); 
     assertFalse(ArrayUtils.isNotEmpty(emptyFloatArray)); 
     assertTrue(ArrayUtils.isNotEmpty(notEmptyFloatArray)); 
     final boolean[] emptyBooleanArray = new boolean[] {}; 
     final boolean[] notEmptyBooleanArray = new boolean[] { true }; 
     assertFalse(ArrayUtils.isNotEmpty((boolean[]) null)); 
     assertFalse(ArrayUtils.isNotEmpty(emptyBooleanArray)); 
     assertTrue(ArrayUtils.isNotEmpty(notEmptyBooleanArray)); 
 }
@Test
public void testContainsChar1984() { 
     char[] array = null; 
     assertFalse(ArrayUtils.contains(array, 'b')); 
     array = new char[] { 'a', 'b', 'c', 'd', 'a' }; 
     assertTrue(ArrayUtils.contains(array, 'a')); 
     assertTrue(ArrayUtils.contains(array, 'b')); 
     assertTrue(ArrayUtils.contains(array, 'c')); 
     assertTrue(ArrayUtils.contains(array, 'd')); 
     assertFalse(ArrayUtils.contains(array, 'e')); 
 }
@Test
public void testSubarrayBoolean1989() { 
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
public void testToPrimitive_long2000() { 
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
public void testToObject_int2014() { 
     final int[] b = null; 
     assertArrayEquals(null, ArrayUtils.toObject(b)); 
     assertSame(ArrayUtils.EMPTY_INTEGER_OBJECT_ARRAY, ArrayUtils.toObject(new int[0])); 
     assertTrue(Arrays.equals(new Integer[] { Integer.valueOf(Integer.MIN_VALUE), Integer.valueOf(Integer.MAX_VALUE), Integer.valueOf(9999999) }, ArrayUtils.toObject(new int[] { Integer.MIN_VALUE, Integer.MAX_VALUE, 9999999 }))); 
 }
@Test
public void testReverseFloat2028() { 
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
public void testSubarrayFloat2039() { 
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
public void testToPrimitive_short2058() { 
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
public void testToPrimitive_int_int2059() { 
     final Long[] l = null; 
     assertEquals(null, ArrayUtils.toPrimitive(l, Integer.MIN_VALUE)); 
     assertSame(ArrayUtils.EMPTY_INT_ARRAY, ArrayUtils.toPrimitive(new Integer[0], 1)); 
     assertTrue(Arrays.equals(new int[] { Integer.MIN_VALUE, Integer.MAX_VALUE, 9999999 }, ArrayUtils.toPrimitive(new Integer[] { Integer.valueOf(Integer.MIN_VALUE), Integer.valueOf(Integer.MAX_VALUE), Integer.valueOf(9999999) }, 1))); 
     assertTrue(Arrays.equals(new int[] { Integer.MIN_VALUE, Integer.MAX_VALUE, 9999999 }, ArrayUtils.toPrimitive(new Integer[] { Integer.valueOf(Integer.MIN_VALUE), null, Integer.valueOf(9999999) }, Integer.MAX_VALUE))); 
 }
@Test
public void testToPrimitive_float2065() { 
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
public void testLastIndexOfCharWithStartIndex2101() { 
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
public void testContainsShort2107() { 
     short[] array = null; 
     assertFalse(ArrayUtils.contains(array, (short) 1)); 
     array = new short[] { 0, 1, 2, 3, 0 }; 
     assertTrue(ArrayUtils.contains(array, (short) 0)); 
     assertTrue(ArrayUtils.contains(array, (short) 1)); 
     assertTrue(ArrayUtils.contains(array, (short) 2)); 
     assertTrue(ArrayUtils.contains(array, (short) 3)); 
     assertFalse(ArrayUtils.contains(array, (short) 99)); 
 }
@Test
public void testToPrimitive_float_float2125() { 
     final Float[] l = null; 
     assertEquals(null, ArrayUtils.toPrimitive(l, Float.MIN_VALUE)); 
     assertSame(ArrayUtils.EMPTY_FLOAT_ARRAY, ArrayUtils.toPrimitive(new Float[0], 1)); 
     assertTrue(Arrays.equals(new float[] { Float.MIN_VALUE, Float.MAX_VALUE, 9999999 }, ArrayUtils.toPrimitive(new Float[] { Float.valueOf(Float.MIN_VALUE), Float.valueOf(Float.MAX_VALUE), Float.valueOf(9999999) }, 1))); 
     assertTrue(Arrays.equals(new float[] { Float.MIN_VALUE, Float.MAX_VALUE, 9999999 }, ArrayUtils.toPrimitive(new Float[] { Float.valueOf(Float.MIN_VALUE), null, Float.valueOf(9999999) }, Float.MAX_VALUE))); 
 }
@Test
public void testSubarrayShort2126() { 
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
public void testSameLengthLong2140() { 
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
public void testSubarrayInt2167() { 
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
public void testReverseLong2196() { 
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
public void testNullToEmptyObject2204() { 
     assertArrayEquals(ArrayUtils.EMPTY_OBJECT_ARRAY, ArrayUtils.nullToEmpty((Object[]) null)); 
     final Object[] original = new Object[] { Boolean.TRUE, Boolean.FALSE }; 
     assertArrayEquals(original, ArrayUtils.nullToEmpty(original)); 
     final Object[] empty = new Object[] {}; 
     final Object[] result = ArrayUtils.nullToEmpty(empty); 
     assertArrayEquals(ArrayUtils.EMPTY_OBJECT_ARRAY, result); 
     assertTrue(empty != result); 
 }
@Test
public void testToPrimitive_long_long2226() { 
     final Long[] l = null; 
     assertEquals(null, ArrayUtils.toPrimitive(l, Long.MIN_VALUE)); 
     assertSame(ArrayUtils.EMPTY_LONG_ARRAY, ArrayUtils.toPrimitive(new Long[0], 1)); 
     assertTrue(Arrays.equals(new long[] { Long.MIN_VALUE, Long.MAX_VALUE, 9999999 }, ArrayUtils.toPrimitive(new Long[] { Long.valueOf(Long.MIN_VALUE), Long.valueOf(Long.MAX_VALUE), Long.valueOf(9999999) }, 1))); 
     assertTrue(Arrays.equals(new long[] { Long.MIN_VALUE, Long.MAX_VALUE, 9999999 }, ArrayUtils.toPrimitive(new Long[] { Long.valueOf(Long.MIN_VALUE), null, Long.valueOf(9999999) }, Long.MAX_VALUE))); 
 }
@Test
public void testNullToEmptyChar2235() { 
     assertEquals(ArrayUtils.EMPTY_CHAR_ARRAY, ArrayUtils.nullToEmpty((char[]) null)); 
     final char[] original = new char[] { 'a', 'b' }; 
     assertEquals(original, ArrayUtils.nullToEmpty(original)); 
     final char[] empty = new char[] {}; 
     final char[] result = ArrayUtils.nullToEmpty(empty); 
     assertEquals(ArrayUtils.EMPTY_CHAR_ARRAY, result); 
     assertTrue(empty != result); 
 }
@Test
public void testSubarrayBoolean2257() { 
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
public void testReverseByte2267() { 
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
public void testToString2268() { 
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
public void testNullToEmptyIntObject2275() { 
     assertArrayEquals(ArrayUtils.EMPTY_INTEGER_OBJECT_ARRAY, ArrayUtils.nullToEmpty((Integer[]) null)); 
     final Integer[] original = new Integer[] { 1, 2 }; 
     assertArrayEquals(original, ArrayUtils.nullToEmpty(original)); 
     final Integer[] empty = new Integer[] {}; 
     final Integer[] result = ArrayUtils.nullToEmpty(empty); 
     assertArrayEquals(ArrayUtils.EMPTY_INTEGER_OBJECT_ARRAY, result); 
     assertTrue(empty != result); 
 }
@Test
public void testSubarrayByte2292() { 
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
public void testIndexOfByteWithStartIndex2302() { 
     byte[] array = null; 
     assertEquals(-1, ArrayUtils.indexOf(array, (byte) 0, 2)); 
     array = new byte[] { 0, 1, 2, 3, 0 }; 
     assertEquals(4, ArrayUtils.indexOf(array, (byte) 0, 2)); 
     assertEquals(-1, ArrayUtils.indexOf(array, (byte) 1, 2)); 
     assertEquals(2, ArrayUtils.indexOf(array, (byte) 2, 2)); 
     assertEquals(3, ArrayUtils.indexOf(array, (byte) 3, 2)); 
     assertEquals(3, ArrayUtils.indexOf(array, (byte) 3, -1)); 
     assertEquals(-1, ArrayUtils.indexOf(array, (byte) 99, 0)); 
     assertEquals(-1, ArrayUtils.indexOf(array, (byte) 0, 6)); 
 }
@Test
public void testToString2313() { 
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
public void testToPrimitive_int2328() { 
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
public void testSubarrayInt2341() { 
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
public void testSubarrayByte2346() { 
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
public void testLastIndexOfShort2348() { 
     short[] array = null; 
     assertEquals(-1, ArrayUtils.lastIndexOf(array, (short) 0)); 
     array = new short[] { 0, 1, 2, 3, 0 }; 
     assertEquals(4, ArrayUtils.lastIndexOf(array, (short) 0)); 
     assertEquals(1, ArrayUtils.lastIndexOf(array, (short) 1)); 
     assertEquals(2, ArrayUtils.lastIndexOf(array, (short) 2)); 
     assertEquals(3, ArrayUtils.lastIndexOf(array, (short) 3)); 
     assertEquals(-1, ArrayUtils.lastIndexOf(array, (short) 99)); 
 }
@Test
public void testToString2366() { 
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
public void testToPrimitive_byte_byte2369() { 
     final Byte[] b = null; 
     assertEquals(null, ArrayUtils.toPrimitive(b, Byte.MIN_VALUE)); 
     assertSame(ArrayUtils.EMPTY_BYTE_ARRAY, ArrayUtils.toPrimitive(new Byte[0], (byte) 1)); 
     assertTrue(Arrays.equals(new byte[] { Byte.MIN_VALUE, Byte.MAX_VALUE, (byte) 9999999 }, ArrayUtils.toPrimitive(new Byte[] { Byte.valueOf(Byte.MIN_VALUE), Byte.valueOf(Byte.MAX_VALUE), Byte.valueOf((byte) 9999999) }, Byte.MIN_VALUE))); 
     assertTrue(Arrays.equals(new byte[] { Byte.MIN_VALUE, Byte.MAX_VALUE, (byte) 9999999 }, ArrayUtils.toPrimitive(new Byte[] { Byte.valueOf(Byte.MIN_VALUE), null, Byte.valueOf((byte) 9999999) }, Byte.MAX_VALUE))); 
 }
@Test
public void testLastIndexOfShort2386() { 
     short[] array = null; 
     assertEquals(-1, ArrayUtils.lastIndexOf(array, (short) 0)); 
     array = new short[] { 0, 1, 2, 3, 0 }; 
     assertEquals(4, ArrayUtils.lastIndexOf(array, (short) 0)); 
     assertEquals(1, ArrayUtils.lastIndexOf(array, (short) 1)); 
     assertEquals(2, ArrayUtils.lastIndexOf(array, (short) 2)); 
     assertEquals(3, ArrayUtils.lastIndexOf(array, (short) 3)); 
     assertEquals(-1, ArrayUtils.lastIndexOf(array, (short) 99)); 
 }
@Test
public void testToPrimitive_float_float2427() { 
     final Float[] l = null; 
     assertEquals(null, ArrayUtils.toPrimitive(l, Float.MIN_VALUE)); 
     assertSame(ArrayUtils.EMPTY_FLOAT_ARRAY, ArrayUtils.toPrimitive(new Float[0], 1)); 
     assertTrue(Arrays.equals(new float[] { Float.MIN_VALUE, Float.MAX_VALUE, 9999999 }, ArrayUtils.toPrimitive(new Float[] { Float.valueOf(Float.MIN_VALUE), Float.valueOf(Float.MAX_VALUE), Float.valueOf(9999999) }, 1))); 
     assertTrue(Arrays.equals(new float[] { Float.MIN_VALUE, Float.MAX_VALUE, 9999999 }, ArrayUtils.toPrimitive(new Float[] { Float.valueOf(Float.MIN_VALUE), null, Float.valueOf(9999999) }, Float.MAX_VALUE))); 
 }
@Test
public void testReverseDouble2430() { 
     double[] array = new double[] { 0.3d, 0.4d, 0.5d }; 
     ArrayUtils.reverse(array); 
     assertEquals(array[0], 0.5d, 0.0d); 
     assertEquals(array[1], 0.4d, 0.0d); 
     assertEquals(array[2], 0.3d, 0.0d); 
     array = null; 
     ArrayUtils.reverse(array); 
     assertEquals(null, array); 
 } 
@SuppressWarnings("cast")
@Test
public void testIndexOfDoubleWithStartIndex2455() { 
     double[] array = null; 
     assertEquals(-1, ArrayUtils.indexOf(array, (double) 0, 2)); 
     array = new double[0]; 
     assertEquals(-1, ArrayUtils.indexOf(array, (double) 0, 2)); 
     array = new double[] { 0, 1, 2, 3, 0 }; 
     assertEquals(4, ArrayUtils.indexOf(array, (double) 0, 2)); 
     assertEquals(-1, ArrayUtils.indexOf(array, (double) 1, 2)); 
     assertEquals(2, ArrayUtils.indexOf(array, (double) 2, 2)); 
     assertEquals(3, ArrayUtils.indexOf(array, (double) 3, 2)); 
     assertEquals(-1, ArrayUtils.indexOf(array, (double) 99, 0)); 
     assertEquals(-1, ArrayUtils.indexOf(array, (double) 0, 6)); 
 }
@Test
public void testNullToEmptyShortObject2478() { 
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
public void testToPrimitive_short2487() { 
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
public void testReverseChar2514() { 
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
public void testReverseBoolean2537() { 
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
public void testLastIndexOfWithStartIndex2568() { 
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
public void testToPrimitive_double2579() { 
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
public void testIsEmptyPrimitives2585() { 
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
public void testReverseBoolean2603() { 
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
public void testReverseChar2617() { 
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
public void testToPrimitive_char2619() { 
     final Character[] b = null; 
     assertEquals(null, ArrayUtils.toPrimitive(b)); 
     assertSame(ArrayUtils.EMPTY_CHAR_ARRAY, ArrayUtils.toPrimitive(new Character[0])); 
     assertTrue(Arrays.equals(new char[] { Character.MIN_VALUE, Character.MAX_VALUE, '0' }, ArrayUtils.toPrimitive(new Character[] { new Character(Character.MIN_VALUE), new Character(Character.MAX_VALUE), new Character('0') }))); 
     try { 
         ArrayUtils.toPrimitive(new Character[] { new Character(Character.MIN_VALUE), null }); 
         fail(); 
     } catch (final NullPointerException ex) { 
     } 
 }
@Test
public void testSubarrayInt2629() { 
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
public void testToPrimitive_float2636() { 
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
public void testReverse2638() { 
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
public void testIsNotEmptyPrimitives2655() { 
     final long[] emptyLongArray = new long[] {}; 
     final long[] notEmptyLongArray = new long[] { 1L }; 
     assertFalse(ArrayUtils.isNotEmpty((long[]) null)); 
     assertFalse(ArrayUtils.isNotEmpty(emptyLongArray)); 
     assertTrue(ArrayUtils.isNotEmpty(notEmptyLongArray)); 
     final int[] emptyIntArray = new int[] {}; 
     final int[] notEmptyIntArray = new int[] { 1 }; 
     assertFalse(ArrayUtils.isNotEmpty((int[]) null)); 
     assertFalse(ArrayUtils.isNotEmpty(emptyIntArray)); 
     assertTrue(ArrayUtils.isNotEmpty(notEmptyIntArray)); 
     final short[] emptyShortArray = new short[] {}; 
     final short[] notEmptyShortArray = new short[] { 1 }; 
     assertFalse(ArrayUtils.isNotEmpty((short[]) null)); 
     assertFalse(ArrayUtils.isNotEmpty(emptyShortArray)); 
     assertTrue(ArrayUtils.isNotEmpty(notEmptyShortArray)); 
     final char[] emptyCharArray = new char[] {}; 
     final char[] notEmptyCharArray = new char[] { 1 }; 
     assertFalse(ArrayUtils.isNotEmpty((char[]) null)); 
     assertFalse(ArrayUtils.isNotEmpty(emptyCharArray)); 
     assertTrue(ArrayUtils.isNotEmpty(notEmptyCharArray)); 
     final byte[] emptyByteArray = new byte[] {}; 
     final byte[] notEmptyByteArray = new byte[] { 1 }; 
     assertFalse(ArrayUtils.isNotEmpty((byte[]) null)); 
     assertFalse(ArrayUtils.isNotEmpty(emptyByteArray)); 
     assertTrue(ArrayUtils.isNotEmpty(notEmptyByteArray)); 
     final double[] emptyDoubleArray = new double[] {}; 
     final double[] notEmptyDoubleArray = new double[] { 1.0 }; 
     assertFalse(ArrayUtils.isNotEmpty((double[]) null)); 
     assertFalse(ArrayUtils.isNotEmpty(emptyDoubleArray)); 
     assertTrue(ArrayUtils.isNotEmpty(notEmptyDoubleArray)); 
     final float[] emptyFloatArray = new float[] {}; 
     final float[] notEmptyFloatArray = new float[] { 1.0F }; 
     assertFalse(ArrayUtils.isNotEmpty((float[]) null)); 
     assertFalse(ArrayUtils.isNotEmpty(emptyFloatArray)); 
     assertTrue(ArrayUtils.isNotEmpty(notEmptyFloatArray)); 
     final boolean[] emptyBooleanArray = new boolean[] {}; 
     final boolean[] notEmptyBooleanArray = new boolean[] { true }; 
     assertFalse(ArrayUtils.isNotEmpty((boolean[]) null)); 
     assertFalse(ArrayUtils.isNotEmpty(emptyBooleanArray)); 
     assertTrue(ArrayUtils.isNotEmpty(notEmptyBooleanArray)); 
 }
@Test
public void testToObject_float2661() { 
     final float[] b = null; 
     assertArrayEquals(null, ArrayUtils.toObject(b)); 
     assertSame(ArrayUtils.EMPTY_FLOAT_OBJECT_ARRAY, ArrayUtils.toObject(new float[0])); 
     assertTrue(Arrays.equals(new Float[] { Float.valueOf(Float.MIN_VALUE), Float.valueOf(Float.MAX_VALUE), Float.valueOf(9999999) }, ArrayUtils.toObject(new float[] { Float.MIN_VALUE, Float.MAX_VALUE, 9999999 }))); 
 }
@Test
public void testLastIndexOfByteWithStartIndex2664() { 
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
public void testLastIndexOfShort2691() { 
     short[] array = null; 
     assertEquals(-1, ArrayUtils.lastIndexOf(array, (short) 0)); 
     array = new short[] { 0, 1, 2, 3, 0 }; 
     assertEquals(4, ArrayUtils.lastIndexOf(array, (short) 0)); 
     assertEquals(1, ArrayUtils.lastIndexOf(array, (short) 1)); 
     assertEquals(2, ArrayUtils.lastIndexOf(array, (short) 2)); 
     assertEquals(3, ArrayUtils.lastIndexOf(array, (short) 3)); 
     assertEquals(-1, ArrayUtils.lastIndexOf(array, (short) 99)); 
 } 
@SuppressWarnings("cast")
@Test
public void testIndexOfDoubleWithStartIndexTolerance2695() { 
     double[] array = null; 
     assertEquals(-1, ArrayUtils.indexOf(array, (double) 0, 2, (double) 0)); 
     array = new double[0]; 
     assertEquals(-1, ArrayUtils.indexOf(array, (double) 0, 2, (double) 0)); 
     array = new double[] { 0, 1, 2, 3, 0 }; 
     assertEquals(-1, ArrayUtils.indexOf(array, (double) 0, 99, (double) 0.3)); 
     assertEquals(0, ArrayUtils.indexOf(array, (double) 0, 0, (double) 0.3)); 
     assertEquals(4, ArrayUtils.indexOf(array, (double) 0, 3, (double) 0.3)); 
     assertEquals(2, ArrayUtils.indexOf(array, (double) 2.2, 0, (double) 0.35)); 
     assertEquals(3, ArrayUtils.indexOf(array, (double) 4.15, 0, (double) 2.0)); 
     assertEquals(1, ArrayUtils.indexOf(array, (double) 1.00001324, 0, (double) 0.0001)); 
     assertEquals(3, ArrayUtils.indexOf(array, (double) 4.15, -1, (double) 2.0)); 
     assertEquals(1, ArrayUtils.indexOf(array, (double) 1.00001324, -300, (double) 0.0001)); 
 }
@Test
public void testSameLengthLong2700() { 
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
public void testToPrimitive_intNull2702() { 
     final Integer[] iArray = null; 
     assertEquals(null, ArrayUtils.toPrimitive(iArray, Integer.MIN_VALUE)); 
 } 
@SuppressWarnings("cast")
@Test
public void testIndexOfDoubleTolerance2705() { 
     double[] array = null; 
     assertEquals(-1, ArrayUtils.indexOf(array, (double) 0, (double) 0)); 
     array = new double[0]; 
     assertEquals(-1, ArrayUtils.indexOf(array, (double) 0, (double) 0)); 
     array = new double[] { 0, 1, 2, 3, 0 }; 
     assertEquals(0, ArrayUtils.indexOf(array, (double) 0, (double) 0.3)); 
     assertEquals(2, ArrayUtils.indexOf(array, (double) 2.2, (double) 0.35)); 
     assertEquals(3, ArrayUtils.indexOf(array, (double) 4.15, (double) 2.0)); 
     assertEquals(1, ArrayUtils.indexOf(array, (double) 1.00001324, (double) 0.0001)); 
 }
@Test
public void testContainsBoolean2713() { 
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
public void testIndexOfIntWithStartIndex2715() { 
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
public void testReverseFloat2716() { 
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
public void testReverseChar2737() { 
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
public void testToObject_double2738() { 
     final double[] b = null; 
     assertArrayEquals(null, ArrayUtils.toObject(b)); 
     assertSame(ArrayUtils.EMPTY_DOUBLE_OBJECT_ARRAY, ArrayUtils.toObject(new double[0])); 
     assertTrue(Arrays.equals(new Double[] { Double.valueOf(Double.MIN_VALUE), Double.valueOf(Double.MAX_VALUE), Double.valueOf(9999999) }, ArrayUtils.toObject(new double[] { Double.MIN_VALUE, Double.MAX_VALUE, 9999999 }))); 
 }
@Test
public void testToPrimitive_char_char2769() { 
     final Character[] b = null; 
     assertEquals(null, ArrayUtils.toPrimitive(b, Character.MIN_VALUE)); 
     assertSame(ArrayUtils.EMPTY_CHAR_ARRAY, ArrayUtils.toPrimitive(new Character[0], (char) 0)); 
     assertTrue(Arrays.equals(new char[] { Character.MIN_VALUE, Character.MAX_VALUE, '0' }, ArrayUtils.toPrimitive(new Character[] { new Character(Character.MIN_VALUE), new Character(Character.MAX_VALUE), new Character('0') }, Character.MIN_VALUE))); 
     assertTrue(Arrays.equals(new char[] { Character.MIN_VALUE, Character.MAX_VALUE, '0' }, ArrayUtils.toPrimitive(new Character[] { new Character(Character.MIN_VALUE), null, new Character('0') }, Character.MAX_VALUE))); 
 }
@Test
public void testToPrimitive_boolean_boolean2774() { 
     assertEquals(null, ArrayUtils.toPrimitive(null, false)); 
     assertSame(ArrayUtils.EMPTY_BOOLEAN_ARRAY, ArrayUtils.toPrimitive(new Boolean[0], false)); 
     assertTrue(Arrays.equals(new boolean[] { true, false, true }, ArrayUtils.toPrimitive(new Boolean[] { Boolean.TRUE, Boolean.FALSE, Boolean.TRUE }, false))); 
     assertTrue(Arrays.equals(new boolean[] { true, false, false }, ArrayUtils.toPrimitive(new Boolean[] { Boolean.TRUE, null, Boolean.FALSE }, false))); 
     assertTrue(Arrays.equals(new boolean[] { true, true, false }, ArrayUtils.toPrimitive(new Boolean[] { Boolean.TRUE, null, Boolean.FALSE }, true))); 
 }
@Test
public void testLastIndexOfLongWithStartIndex2799() { 
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
public void testLastIndexOfShort2817() { 
     short[] array = null; 
     assertEquals(-1, ArrayUtils.lastIndexOf(array, (short) 0)); 
     array = new short[] { 0, 1, 2, 3, 0 }; 
     assertEquals(4, ArrayUtils.lastIndexOf(array, (short) 0)); 
     assertEquals(1, ArrayUtils.lastIndexOf(array, (short) 1)); 
     assertEquals(2, ArrayUtils.lastIndexOf(array, (short) 2)); 
     assertEquals(3, ArrayUtils.lastIndexOf(array, (short) 3)); 
     assertEquals(-1, ArrayUtils.lastIndexOf(array, (short) 99)); 
 }
@Test
public void testToObject_int2825() { 
     final int[] b = null; 
     assertArrayEquals(null, ArrayUtils.toObject(b)); 
     assertSame(ArrayUtils.EMPTY_INTEGER_OBJECT_ARRAY, ArrayUtils.toObject(new int[0])); 
     assertTrue(Arrays.equals(new Integer[] { Integer.valueOf(Integer.MIN_VALUE), Integer.valueOf(Integer.MAX_VALUE), Integer.valueOf(9999999) }, ArrayUtils.toObject(new int[] { Integer.MIN_VALUE, Integer.MAX_VALUE, 9999999 }))); 
 }
@Test
public void testToPrimitive_short2832() { 
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
public void testSameLengthFloat2842() { 
     final float[] nullArray = null; 
     final float[] emptyArray = new float[0]; 
     final float[] oneArray = new float[] { 2.5f }; 
     final float[] twoArray = new float[] { 6.4f, 5.8f }; 
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
public void testToObject_long2843() { 
     final long[] b = null; 
     assertArrayEquals(null, ArrayUtils.toObject(b)); 
     assertSame(ArrayUtils.EMPTY_LONG_OBJECT_ARRAY, ArrayUtils.toObject(new long[0])); 
     assertTrue(Arrays.equals(new Long[] { Long.valueOf(Long.MIN_VALUE), Long.valueOf(Long.MAX_VALUE), Long.valueOf(9999999) }, ArrayUtils.toObject(new long[] { Long.MIN_VALUE, Long.MAX_VALUE, 9999999 }))); 
 }
@Test
public void testToObject_float2845() { 
     final float[] b = null; 
     assertArrayEquals(null, ArrayUtils.toObject(b)); 
     assertSame(ArrayUtils.EMPTY_FLOAT_OBJECT_ARRAY, ArrayUtils.toObject(new float[0])); 
     assertTrue(Arrays.equals(new Float[] { Float.valueOf(Float.MIN_VALUE), Float.valueOf(Float.MAX_VALUE), Float.valueOf(9999999) }, ArrayUtils.toObject(new float[] { Float.MIN_VALUE, Float.MAX_VALUE, 9999999 }))); 
 }
@Test
public void testToObject_byte2846() { 
     final byte[] b = null; 
     assertArrayEquals(null, ArrayUtils.toObject(b)); 
     assertSame(ArrayUtils.EMPTY_BYTE_OBJECT_ARRAY, ArrayUtils.toObject(new byte[0])); 
     assertTrue(Arrays.equals(new Byte[] { Byte.valueOf(Byte.MIN_VALUE), Byte.valueOf(Byte.MAX_VALUE), Byte.valueOf((byte) 9999999) }, ArrayUtils.toObject(new byte[] { Byte.MIN_VALUE, Byte.MAX_VALUE, (byte) 9999999 }))); 
 } 
@SuppressWarnings("cast")
@Test
public void testIndexOfFloatWithStartIndex2849() { 
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
@Test
public void testReverseLong2869() { 
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
public void testToPrimitive_byte_byte2895() { 
     final Byte[] b = null; 
     assertEquals(null, ArrayUtils.toPrimitive(b, Byte.MIN_VALUE)); 
     assertSame(ArrayUtils.EMPTY_BYTE_ARRAY, ArrayUtils.toPrimitive(new Byte[0], (byte) 1)); 
     assertTrue(Arrays.equals(new byte[] { Byte.MIN_VALUE, Byte.MAX_VALUE, (byte) 9999999 }, ArrayUtils.toPrimitive(new Byte[] { Byte.valueOf(Byte.MIN_VALUE), Byte.valueOf(Byte.MAX_VALUE), Byte.valueOf((byte) 9999999) }, Byte.MIN_VALUE))); 
     assertTrue(Arrays.equals(new byte[] { Byte.MIN_VALUE, Byte.MAX_VALUE, (byte) 9999999 }, ArrayUtils.toPrimitive(new Byte[] { Byte.valueOf(Byte.MIN_VALUE), null, Byte.valueOf((byte) 9999999) }, Byte.MAX_VALUE))); 
 }
@Test
public void testSubarrayInt2900() { 
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
public void testReverseBoolean2909() { 
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
public void testToString2936() { 
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
public void testToObject_boolean2940() { 
     final boolean[] b = null; 
     assertArrayEquals(null, ArrayUtils.toObject(b)); 
     assertSame(ArrayUtils.EMPTY_BOOLEAN_OBJECT_ARRAY, ArrayUtils.toObject(new boolean[0])); 
     assertTrue(Arrays.equals(new Boolean[] { Boolean.TRUE, Boolean.FALSE, Boolean.TRUE }, ArrayUtils.toObject(new boolean[] { true, false, true }))); 
 }
@Test
public void testCloneLong2942() { 
     assertEquals(null, ArrayUtils.clone((long[]) null)); 
     final long[] original = new long[] { 0L, 1L }; 
     final long[] cloned = ArrayUtils.clone(original); 
     assertTrue(Arrays.equals(original, cloned)); 
     assertTrue(original != cloned); 
 }
@Test
public void testSameLengthInt2960() { 
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
public void testSubarrayShort2968() { 
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
public void testLastIndexOfLongWithStartIndex2974() { 
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
public void testToPrimitive_int2981() { 
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
public void testNullToEmptyChar2985() { 
     assertEquals(ArrayUtils.EMPTY_CHAR_ARRAY, ArrayUtils.nullToEmpty((char[]) null)); 
     final char[] original = new char[] { 'a', 'b' }; 
     assertEquals(original, ArrayUtils.nullToEmpty(original)); 
     final char[] empty = new char[] {}; 
     final char[] result = ArrayUtils.nullToEmpty(empty); 
     assertEquals(ArrayUtils.EMPTY_CHAR_ARRAY, result); 
     assertTrue(empty != result); 
 }
@Test
public void testToPrimitive_double2999() { 
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
public void testToString3020() { 
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
public void testNullToEmptyBoolean3025() { 
     assertEquals(ArrayUtils.EMPTY_BOOLEAN_ARRAY, ArrayUtils.nullToEmpty((boolean[]) null)); 
     final boolean[] original = new boolean[] { true, false }; 
     assertEquals(original, ArrayUtils.nullToEmpty(original)); 
     final boolean[] empty = new boolean[] {}; 
     final boolean[] result = ArrayUtils.nullToEmpty(empty); 
     assertEquals(ArrayUtils.EMPTY_BOOLEAN_ARRAY, result); 
     assertTrue(empty != result); 
 }
@Test
public void testToObject_short3029() { 
     final short[] b = null; 
     assertArrayEquals(null, ArrayUtils.toObject(b)); 
     assertSame(ArrayUtils.EMPTY_SHORT_OBJECT_ARRAY, ArrayUtils.toObject(new short[0])); 
     assertTrue(Arrays.equals(new Short[] { Short.valueOf(Short.MIN_VALUE), Short.valueOf(Short.MAX_VALUE), Short.valueOf((short) 9999999) }, ArrayUtils.toObject(new short[] { Short.MIN_VALUE, Short.MAX_VALUE, (short) 9999999 }))); 
 }
@Test
public void testReverseLong3031() { 
     long[] array = new long[] { 1L, 2L, 3L }; 
     ArrayUtils.reverse(array); 
     assertEquals(array[0], 3L); 
     assertEquals(array[1], 2L); 
     assertEquals(array[2], 1L); 
     array = null; 
     ArrayUtils.reverse(array); 
     assertEquals(null, array); 
 } 
@SuppressWarnings("cast")
@Test
public void testLastIndexOfDoubleWithStartIndex3041() { 
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
@Test
public void testNullToEmptyShort3049() { 
     assertEquals(ArrayUtils.EMPTY_SHORT_ARRAY, ArrayUtils.nullToEmpty((short[]) null)); 
     final short[] original = new short[] { 1, 2 }; 
     assertEquals(original, ArrayUtils.nullToEmpty(original)); 
     final short[] empty = new short[] {}; 
     final short[] result = ArrayUtils.nullToEmpty(empty); 
     assertEquals(ArrayUtils.EMPTY_SHORT_ARRAY, result); 
     assertTrue(empty != result); 
 }
@Test
public void testToPrimitive_long3061() { 
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
public void testReverseInt3078() { 
     int[] array = new int[] { 1, 2, 3 }; 
     ArrayUtils.reverse(array); 
     assertEquals(array[0], 3); 
     assertEquals(array[1], 2); 
     assertEquals(array[2], 1); 
     array = null; 
     ArrayUtils.reverse(array); 
     assertEquals(null, array); 
 }
@Test
public void testSameLengthChar3101() { 
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
public void testToPrimitive_double3113() { 
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
public void testReverseShort3142() { 
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
public void testLastIndexOfInt3145() { 
     int[] array = null; 
     assertEquals(-1, ArrayUtils.lastIndexOf(array, 0)); 
     array = new int[] { 0, 1, 2, 3, 0 }; 
     assertEquals(4, ArrayUtils.lastIndexOf(array, 0)); 
     assertEquals(1, ArrayUtils.lastIndexOf(array, 1)); 
     assertEquals(2, ArrayUtils.lastIndexOf(array, 2)); 
     assertEquals(3, ArrayUtils.lastIndexOf(array, 3)); 
     assertEquals(-1, ArrayUtils.lastIndexOf(array, 99)); 
 }
@Test
public void testToObject_long3154() { 
     final long[] b = null; 
     assertArrayEquals(null, ArrayUtils.toObject(b)); 
     assertSame(ArrayUtils.EMPTY_LONG_OBJECT_ARRAY, ArrayUtils.toObject(new long[0])); 
     assertTrue(Arrays.equals(new Long[] { Long.valueOf(Long.MIN_VALUE), Long.valueOf(Long.MAX_VALUE), Long.valueOf(9999999) }, ArrayUtils.toObject(new long[] { Long.MIN_VALUE, Long.MAX_VALUE, 9999999 }))); 
 }
@Test
public void testToString3156() { 
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
public void testToPrimitive_char3186() { 
     final Character[] b = null; 
     assertEquals(null, ArrayUtils.toPrimitive(b)); 
     assertSame(ArrayUtils.EMPTY_CHAR_ARRAY, ArrayUtils.toPrimitive(new Character[0])); 
     assertTrue(Arrays.equals(new char[] { Character.MIN_VALUE, Character.MAX_VALUE, '0' }, ArrayUtils.toPrimitive(new Character[] { new Character(Character.MIN_VALUE), new Character(Character.MAX_VALUE), new Character('0') }))); 
     try { 
         ArrayUtils.toPrimitive(new Character[] { new Character(Character.MIN_VALUE), null }); 
         fail(); 
     } catch (final NullPointerException ex) { 
     } 
 }
@Test
public void testToObject_short3229() { 
     final short[] b = null; 
     assertArrayEquals(null, ArrayUtils.toObject(b)); 
     assertSame(ArrayUtils.EMPTY_SHORT_OBJECT_ARRAY, ArrayUtils.toObject(new short[0])); 
     assertTrue(Arrays.equals(new Short[] { Short.valueOf(Short.MIN_VALUE), Short.valueOf(Short.MAX_VALUE), Short.valueOf((short) 9999999) }, ArrayUtils.toObject(new short[] { Short.MIN_VALUE, Short.MAX_VALUE, (short) 9999999 }))); 
 }
@Test
public void testNullToEmptyByteObject3273() { 
     assertArrayEquals(ArrayUtils.EMPTY_BYTE_OBJECT_ARRAY, ArrayUtils.nullToEmpty((Byte[]) null)); 
     final Byte[] original = new Byte[] { 0x0F, 0x0E }; 
     assertArrayEquals(original, ArrayUtils.nullToEmpty(original)); 
     final Byte[] empty = new Byte[] {}; 
     final Byte[] result = ArrayUtils.nullToEmpty(empty); 
     assertArrayEquals(ArrayUtils.EMPTY_BYTE_OBJECT_ARRAY, result); 
     assertTrue(empty != result); 
 }
@Test
public void testReverseByte3288() { 
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
public void testLastIndexOfShort3290() { 
     short[] array = null; 
     assertEquals(-1, ArrayUtils.lastIndexOf(array, (short) 0)); 
     array = new short[] { 0, 1, 2, 3, 0 }; 
     assertEquals(4, ArrayUtils.lastIndexOf(array, (short) 0)); 
     assertEquals(1, ArrayUtils.lastIndexOf(array, (short) 1)); 
     assertEquals(2, ArrayUtils.lastIndexOf(array, (short) 2)); 
     assertEquals(3, ArrayUtils.lastIndexOf(array, (short) 3)); 
     assertEquals(-1, ArrayUtils.lastIndexOf(array, (short) 99)); 
 }
@Test
public void testToPrimitive_char_char3310() { 
     final Character[] b = null; 
     assertEquals(null, ArrayUtils.toPrimitive(b, Character.MIN_VALUE)); 
     assertSame(ArrayUtils.EMPTY_CHAR_ARRAY, ArrayUtils.toPrimitive(new Character[0], (char) 0)); 
     assertTrue(Arrays.equals(new char[] { Character.MIN_VALUE, Character.MAX_VALUE, '0' }, ArrayUtils.toPrimitive(new Character[] { new Character(Character.MIN_VALUE), new Character(Character.MAX_VALUE), new Character('0') }, Character.MIN_VALUE))); 
     assertTrue(Arrays.equals(new char[] { Character.MIN_VALUE, Character.MAX_VALUE, '0' }, ArrayUtils.toPrimitive(new Character[] { new Character(Character.MIN_VALUE), null, new Character('0') }, Character.MAX_VALUE))); 
 }
@Test
public void testToPrimitive_long_long3316() { 
     final Long[] l = null; 
     assertEquals(null, ArrayUtils.toPrimitive(l, Long.MIN_VALUE)); 
     assertSame(ArrayUtils.EMPTY_LONG_ARRAY, ArrayUtils.toPrimitive(new Long[0], 1)); 
     assertTrue(Arrays.equals(new long[] { Long.MIN_VALUE, Long.MAX_VALUE, 9999999 }, ArrayUtils.toPrimitive(new Long[] { Long.valueOf(Long.MIN_VALUE), Long.valueOf(Long.MAX_VALUE), Long.valueOf(9999999) }, 1))); 
     assertTrue(Arrays.equals(new long[] { Long.MIN_VALUE, Long.MAX_VALUE, 9999999 }, ArrayUtils.toPrimitive(new Long[] { Long.valueOf(Long.MIN_VALUE), null, Long.valueOf(9999999) }, Long.MAX_VALUE))); 
 }
@Test
public void testContainsShort3320() { 
     short[] array = null; 
     assertFalse(ArrayUtils.contains(array, (short) 1)); 
     array = new short[] { 0, 1, 2, 3, 0 }; 
     assertTrue(ArrayUtils.contains(array, (short) 0)); 
     assertTrue(ArrayUtils.contains(array, (short) 1)); 
     assertTrue(ArrayUtils.contains(array, (short) 2)); 
     assertTrue(ArrayUtils.contains(array, (short) 3)); 
     assertFalse(ArrayUtils.contains(array, (short) 99)); 
 }
@Test
public void testIndexOfCharWithStartIndex3323() { 
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
public void testContainsInt3327() { 
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
public void testReverseByte3340() { 
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
public void testReverseChar3359() { 
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
public void testSubarrayInt3375() { 
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
@SuppressWarnings("cast")
@Test
public void testLastIndexOfDoubleWithStartIndex3386() { 
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
@Test
public void testToObject_boolean3417() { 
     final boolean[] b = null; 
     assertArrayEquals(null, ArrayUtils.toObject(b)); 
     assertSame(ArrayUtils.EMPTY_BOOLEAN_OBJECT_ARRAY, ArrayUtils.toObject(new boolean[0])); 
     assertTrue(Arrays.equals(new Boolean[] { Boolean.TRUE, Boolean.FALSE, Boolean.TRUE }, ArrayUtils.toObject(new boolean[] { true, false, true }))); 
 }
@Test
public void testLastIndexOfInt3459() { 
     int[] array = null; 
     assertEquals(-1, ArrayUtils.lastIndexOf(array, 0)); 
     array = new int[] { 0, 1, 2, 3, 0 }; 
     assertEquals(4, ArrayUtils.lastIndexOf(array, 0)); 
     assertEquals(1, ArrayUtils.lastIndexOf(array, 1)); 
     assertEquals(2, ArrayUtils.lastIndexOf(array, 2)); 
     assertEquals(3, ArrayUtils.lastIndexOf(array, 3)); 
     assertEquals(-1, ArrayUtils.lastIndexOf(array, 99)); 
 }
@Test
public void testReverseInt3465() { 
     int[] array = new int[] { 1, 2, 3 }; 
     ArrayUtils.reverse(array); 
     assertEquals(array[0], 3); 
     assertEquals(array[1], 2); 
     assertEquals(array[2], 1); 
     array = null; 
     ArrayUtils.reverse(array); 
     assertEquals(null, array); 
 }
@Test
public void testReverse3471() { 
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
public void testToPrimitive_byte_byte3487() { 
     final Byte[] b = null; 
     assertEquals(null, ArrayUtils.toPrimitive(b, Byte.MIN_VALUE)); 
     assertSame(ArrayUtils.EMPTY_BYTE_ARRAY, ArrayUtils.toPrimitive(new Byte[0], (byte) 1)); 
     assertTrue(Arrays.equals(new byte[] { Byte.MIN_VALUE, Byte.MAX_VALUE, (byte) 9999999 }, ArrayUtils.toPrimitive(new Byte[] { Byte.valueOf(Byte.MIN_VALUE), Byte.valueOf(Byte.MAX_VALUE), Byte.valueOf((byte) 9999999) }, Byte.MIN_VALUE))); 
     assertTrue(Arrays.equals(new byte[] { Byte.MIN_VALUE, Byte.MAX_VALUE, (byte) 9999999 }, ArrayUtils.toPrimitive(new Byte[] { Byte.valueOf(Byte.MIN_VALUE), null, Byte.valueOf((byte) 9999999) }, Byte.MAX_VALUE))); 
 }
@Test
public void testIndexOfIntWithStartIndex3494() { 
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
public void testReverseShort3504() { 
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
public void testSameLengthInt3505() { 
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
public void testToPrimitive_char_char3512() { 
     final Character[] b = null; 
     assertEquals(null, ArrayUtils.toPrimitive(b, Character.MIN_VALUE)); 
     assertSame(ArrayUtils.EMPTY_CHAR_ARRAY, ArrayUtils.toPrimitive(new Character[0], (char) 0)); 
     assertTrue(Arrays.equals(new char[] { Character.MIN_VALUE, Character.MAX_VALUE, '0' }, ArrayUtils.toPrimitive(new Character[] { new Character(Character.MIN_VALUE), new Character(Character.MAX_VALUE), new Character('0') }, Character.MIN_VALUE))); 
     assertTrue(Arrays.equals(new char[] { Character.MIN_VALUE, Character.MAX_VALUE, '0' }, ArrayUtils.toPrimitive(new Character[] { new Character(Character.MIN_VALUE), null, new Character('0') }, Character.MAX_VALUE))); 
 }
@Test
public void testNullToEmptyFloat3526() { 
     assertEquals(ArrayUtils.EMPTY_FLOAT_ARRAY, ArrayUtils.nullToEmpty((float[]) null)); 
     final float[] original = new float[] { 2.6f, 3.8f }; 
     assertEquals(original, ArrayUtils.nullToEmpty(original)); 
     final float[] empty = new float[] {}; 
     final float[] result = ArrayUtils.nullToEmpty(empty); 
     assertEquals(ArrayUtils.EMPTY_FLOAT_ARRAY, result); 
     assertTrue(empty != result); 
 }
@Test
public void testToPrimitive_boolean_boolean3548() { 
     assertEquals(null, ArrayUtils.toPrimitive(null, false)); 
     assertSame(ArrayUtils.EMPTY_BOOLEAN_ARRAY, ArrayUtils.toPrimitive(new Boolean[0], false)); 
     assertTrue(Arrays.equals(new boolean[] { true, false, true }, ArrayUtils.toPrimitive(new Boolean[] { Boolean.TRUE, Boolean.FALSE, Boolean.TRUE }, false))); 
     assertTrue(Arrays.equals(new boolean[] { true, false, false }, ArrayUtils.toPrimitive(new Boolean[] { Boolean.TRUE, null, Boolean.FALSE }, false))); 
     assertTrue(Arrays.equals(new boolean[] { true, true, false }, ArrayUtils.toPrimitive(new Boolean[] { Boolean.TRUE, null, Boolean.FALSE }, true))); 
 }
@Test
public void testSubarrayBoolean3549() { 
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
public void testNullToEmptyBooleanObject3554() { 
     assertArrayEquals(ArrayUtils.EMPTY_BOOLEAN_OBJECT_ARRAY, ArrayUtils.nullToEmpty((Boolean[]) null)); 
     final Boolean[] original = new Boolean[] { Boolean.TRUE, Boolean.FALSE }; 
     assertArrayEquals(original, ArrayUtils.nullToEmpty(original)); 
     final Boolean[] empty = new Boolean[] {}; 
     final Boolean[] result = ArrayUtils.nullToEmpty(empty); 
     assertArrayEquals(ArrayUtils.EMPTY_BOOLEAN_OBJECT_ARRAY, result); 
     assertTrue(empty != result); 
 }
@Test
public void testSubarrayDouble3559() { 
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
public void testReverseInt3565() { 
     int[] array = new int[] { 1, 2, 3 }; 
     ArrayUtils.reverse(array); 
     assertEquals(array[0], 3); 
     assertEquals(array[1], 2); 
     assertEquals(array[2], 1); 
     array = null; 
     ArrayUtils.reverse(array); 
     assertEquals(null, array); 
 }
@Test
public void testLastIndexOfInt3569() { 
     int[] array = null; 
     assertEquals(-1, ArrayUtils.lastIndexOf(array, 0)); 
     array = new int[] { 0, 1, 2, 3, 0 }; 
     assertEquals(4, ArrayUtils.lastIndexOf(array, 0)); 
     assertEquals(1, ArrayUtils.lastIndexOf(array, 1)); 
     assertEquals(2, ArrayUtils.lastIndexOf(array, 2)); 
     assertEquals(3, ArrayUtils.lastIndexOf(array, 3)); 
     assertEquals(-1, ArrayUtils.lastIndexOf(array, 99)); 
 }
@Test
public void testIsEmptyPrimitives3570() { 
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
public void testLastIndexOfByteWithStartIndex3588() { 
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
public void testSubarrayByte3627() { 
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
public void testIndexOfIntWithStartIndex3635() { 
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
public void testLastIndexOf3637() { 
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
@SuppressWarnings("cast")
@Test
public void testLastIndexOfDoubleWithStartIndexTolerance3647() { 
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
@Test
public void testToObject_char3648() { 
     final char[] b = null; 
     assertArrayEquals(null, ArrayUtils.toObject(b)); 
     assertSame(ArrayUtils.EMPTY_CHARACTER_OBJECT_ARRAY, ArrayUtils.toObject(new char[0])); 
     assertTrue(Arrays.equals(new Character[] { new Character(Character.MIN_VALUE), new Character(Character.MAX_VALUE), new Character('0') }, ArrayUtils.toObject(new char[] { Character.MIN_VALUE, Character.MAX_VALUE, '0' }))); 
 }
@Test
public void testToPrimitive_boolean3652() { 
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
public void testToPrimitive_byte_byte3663() { 
     final Byte[] b = null; 
     assertEquals(null, ArrayUtils.toPrimitive(b, Byte.MIN_VALUE)); 
     assertSame(ArrayUtils.EMPTY_BYTE_ARRAY, ArrayUtils.toPrimitive(new Byte[0], (byte) 1)); 
     assertTrue(Arrays.equals(new byte[] { Byte.MIN_VALUE, Byte.MAX_VALUE, (byte) 9999999 }, ArrayUtils.toPrimitive(new Byte[] { Byte.valueOf(Byte.MIN_VALUE), Byte.valueOf(Byte.MAX_VALUE), Byte.valueOf((byte) 9999999) }, Byte.MIN_VALUE))); 
     assertTrue(Arrays.equals(new byte[] { Byte.MIN_VALUE, Byte.MAX_VALUE, (byte) 9999999 }, ArrayUtils.toPrimitive(new Byte[] { Byte.valueOf(Byte.MIN_VALUE), null, Byte.valueOf((byte) 9999999) }, Byte.MAX_VALUE))); 
 }
@Test
public void testSubarrayInt3670() { 
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
public void testSameLengthDouble3671() { 
     final double[] nullArray = null; 
     final double[] emptyArray = new double[0]; 
     final double[] oneArray = new double[] { 1.3d }; 
     final double[] twoArray = new double[] { 4.5d, 6.3d }; 
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
public void testToPrimitive_boolean3675() { 
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
public void testToPrimitive_boolean3680() { 
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
public void testToPrimitive_short_short3700() { 
     final Short[] s = null; 
     assertEquals(null, ArrayUtils.toPrimitive(s, Short.MIN_VALUE)); 
     assertSame(ArrayUtils.EMPTY_SHORT_ARRAY, ArrayUtils.toPrimitive(new Short[0], Short.MIN_VALUE)); 
     assertTrue(Arrays.equals(new short[] { Short.MIN_VALUE, Short.MAX_VALUE, (short) 9999999 }, ArrayUtils.toPrimitive(new Short[] { Short.valueOf(Short.MIN_VALUE), Short.valueOf(Short.MAX_VALUE), Short.valueOf((short) 9999999) }, Short.MIN_VALUE))); 
     assertTrue(Arrays.equals(new short[] { Short.MIN_VALUE, Short.MAX_VALUE, (short) 9999999 }, ArrayUtils.toPrimitive(new Short[] { Short.valueOf(Short.MIN_VALUE), null, Short.valueOf((short) 9999999) }, Short.MAX_VALUE))); 
 }
@Test
public void testToObject_byte3707() { 
     final byte[] b = null; 
     assertArrayEquals(null, ArrayUtils.toObject(b)); 
     assertSame(ArrayUtils.EMPTY_BYTE_OBJECT_ARRAY, ArrayUtils.toObject(new byte[0])); 
     assertTrue(Arrays.equals(new Byte[] { Byte.valueOf(Byte.MIN_VALUE), Byte.valueOf(Byte.MAX_VALUE), Byte.valueOf((byte) 9999999) }, ArrayUtils.toObject(new byte[] { Byte.MIN_VALUE, Byte.MAX_VALUE, (byte) 9999999 }))); 
 }
@Test
public void testSameType3725() { 
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
public void testIndexOfLongWithStartIndex3726() { 
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
public void testReverseBoolean3738() { 
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
public void testToPrimitive_byte3756() { 
     final Byte[] b = null; 
     assertEquals(null, ArrayUtils.toPrimitive(b)); 
     assertSame(ArrayUtils.EMPTY_BYTE_ARRAY, ArrayUtils.toPrimitive(new Byte[0])); 
     assertTrue(Arrays.equals(new byte[] { Byte.MIN_VALUE, Byte.MAX_VALUE, (byte) 9999999 }, ArrayUtils.toPrimitive(new Byte[] { Byte.valueOf(Byte.MIN_VALUE), Byte.valueOf(Byte.MAX_VALUE), Byte.valueOf((byte) 9999999) }))); 
     try { 
         ArrayUtils.toPrimitive(new Byte[] { Byte.valueOf(Byte.MIN_VALUE), null }); 
         fail(); 
     } catch (final NullPointerException ex) { 
     } 
 }
@Test
public void testSubarrayDouble3758() { 
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
public void testIsNotEmptyPrimitives3777() { 
     final long[] emptyLongArray = new long[] {}; 
     final long[] notEmptyLongArray = new long[] { 1L }; 
     assertFalse(ArrayUtils.isNotEmpty((long[]) null)); 
     assertFalse(ArrayUtils.isNotEmpty(emptyLongArray)); 
     assertTrue(ArrayUtils.isNotEmpty(notEmptyLongArray)); 
     final int[] emptyIntArray = new int[] {}; 
     final int[] notEmptyIntArray = new int[] { 1 }; 
     assertFalse(ArrayUtils.isNotEmpty((int[]) null)); 
     assertFalse(ArrayUtils.isNotEmpty(emptyIntArray)); 
     assertTrue(ArrayUtils.isNotEmpty(notEmptyIntArray)); 
     final short[] emptyShortArray = new short[] {}; 
     final short[] notEmptyShortArray = new short[] { 1 }; 
     assertFalse(ArrayUtils.isNotEmpty((short[]) null)); 
     assertFalse(ArrayUtils.isNotEmpty(emptyShortArray)); 
     assertTrue(ArrayUtils.isNotEmpty(notEmptyShortArray)); 
     final char[] emptyCharArray = new char[] {}; 
     final char[] notEmptyCharArray = new char[] { 1 }; 
     assertFalse(ArrayUtils.isNotEmpty((char[]) null)); 
     assertFalse(ArrayUtils.isNotEmpty(emptyCharArray)); 
     assertTrue(ArrayUtils.isNotEmpty(notEmptyCharArray)); 
     final byte[] emptyByteArray = new byte[] {}; 
     final byte[] notEmptyByteArray = new byte[] { 1 }; 
     assertFalse(ArrayUtils.isNotEmpty((byte[]) null)); 
     assertFalse(ArrayUtils.isNotEmpty(emptyByteArray)); 
     assertTrue(ArrayUtils.isNotEmpty(notEmptyByteArray)); 
     final double[] emptyDoubleArray = new double[] {}; 
     final double[] notEmptyDoubleArray = new double[] { 1.0 }; 
     assertFalse(ArrayUtils.isNotEmpty((double[]) null)); 
     assertFalse(ArrayUtils.isNotEmpty(emptyDoubleArray)); 
     assertTrue(ArrayUtils.isNotEmpty(notEmptyDoubleArray)); 
     final float[] emptyFloatArray = new float[] {}; 
     final float[] notEmptyFloatArray = new float[] { 1.0F }; 
     assertFalse(ArrayUtils.isNotEmpty((float[]) null)); 
     assertFalse(ArrayUtils.isNotEmpty(emptyFloatArray)); 
     assertTrue(ArrayUtils.isNotEmpty(notEmptyFloatArray)); 
     final boolean[] emptyBooleanArray = new boolean[] {}; 
     final boolean[] notEmptyBooleanArray = new boolean[] { true }; 
     assertFalse(ArrayUtils.isNotEmpty((boolean[]) null)); 
     assertFalse(ArrayUtils.isNotEmpty(emptyBooleanArray)); 
     assertTrue(ArrayUtils.isNotEmpty(notEmptyBooleanArray)); 
 }
@Test
public void testReverseFloat3786() { 
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
public void testReverseByte3866() { 
     byte[] array = new byte[] { 2, 3, 4 }; 
     ArrayUtils.reverse(array); 
     assertEquals(array[0], 4); 
     assertEquals(array[1], 3); 
     assertEquals(array[2], 2); 
     array = null; 
     ArrayUtils.reverse(array); 
     assertEquals(null, array); 
 } 
@SuppressWarnings("cast")
@Test
public void testLastIndexOfDoubleWithStartIndex3872() { 
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
@Test
public void testSubarrayDouble3891() { 
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
public void testReverse3913() { 
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
public void testSameLengthBoolean3918() { 
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
public void testSubarrChar3937() { 
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
public void testSubarrChar3938() { 
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
public void testIsEmptyPrimitives3943() { 
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
public void testSameLength3955() { 
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
public void testToObject_boolean3962() { 
     final boolean[] b = null; 
     assertArrayEquals(null, ArrayUtils.toObject(b)); 
     assertSame(ArrayUtils.EMPTY_BOOLEAN_OBJECT_ARRAY, ArrayUtils.toObject(new boolean[0])); 
     assertTrue(Arrays.equals(new Boolean[] { Boolean.TRUE, Boolean.FALSE, Boolean.TRUE }, ArrayUtils.toObject(new boolean[] { true, false, true }))); 
 }
@Test
public void testReverseChar3969() { 
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
public void testToObject_boolean3983() { 
     final boolean[] b = null; 
     assertArrayEquals(null, ArrayUtils.toObject(b)); 
     assertSame(ArrayUtils.EMPTY_BOOLEAN_OBJECT_ARRAY, ArrayUtils.toObject(new boolean[0])); 
     assertTrue(Arrays.equals(new Boolean[] { Boolean.TRUE, Boolean.FALSE, Boolean.TRUE }, ArrayUtils.toObject(new boolean[] { true, false, true }))); 
 }
@Test
public void testLastIndexOfInt3989() { 
     int[] array = null; 
     assertEquals(-1, ArrayUtils.lastIndexOf(array, 0)); 
     array = new int[] { 0, 1, 2, 3, 0 }; 
     assertEquals(4, ArrayUtils.lastIndexOf(array, 0)); 
     assertEquals(1, ArrayUtils.lastIndexOf(array, 1)); 
     assertEquals(2, ArrayUtils.lastIndexOf(array, 2)); 
     assertEquals(3, ArrayUtils.lastIndexOf(array, 3)); 
     assertEquals(-1, ArrayUtils.lastIndexOf(array, 99)); 
 }
@Test
public void testLastIndexOfShort4011() { 
     short[] array = null; 
     assertEquals(-1, ArrayUtils.lastIndexOf(array, (short) 0)); 
     array = new short[] { 0, 1, 2, 3, 0 }; 
     assertEquals(4, ArrayUtils.lastIndexOf(array, (short) 0)); 
     assertEquals(1, ArrayUtils.lastIndexOf(array, (short) 1)); 
     assertEquals(2, ArrayUtils.lastIndexOf(array, (short) 2)); 
     assertEquals(3, ArrayUtils.lastIndexOf(array, (short) 3)); 
     assertEquals(-1, ArrayUtils.lastIndexOf(array, (short) 99)); 
 }
@Test
public void testLastIndexOfByteWithStartIndex4015() { 
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
public void testSubarrayShort4032() { 
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
public void testToObject_short4044() { 
     final short[] b = null; 
     assertArrayEquals(null, ArrayUtils.toObject(b)); 
     assertSame(ArrayUtils.EMPTY_SHORT_OBJECT_ARRAY, ArrayUtils.toObject(new short[0])); 
     assertTrue(Arrays.equals(new Short[] { Short.valueOf(Short.MIN_VALUE), Short.valueOf(Short.MAX_VALUE), Short.valueOf((short) 9999999) }, ArrayUtils.toObject(new short[] { Short.MIN_VALUE, Short.MAX_VALUE, (short) 9999999 }))); 
 }
@Test
public void testNullToEmptyFloat4049() { 
     assertEquals(ArrayUtils.EMPTY_FLOAT_ARRAY, ArrayUtils.nullToEmpty((float[]) null)); 
     final float[] original = new float[] { 2.6f, 3.8f }; 
     assertEquals(original, ArrayUtils.nullToEmpty(original)); 
     final float[] empty = new float[] {}; 
     final float[] result = ArrayUtils.nullToEmpty(empty); 
     assertEquals(ArrayUtils.EMPTY_FLOAT_ARRAY, result); 
     assertTrue(empty != result); 
 } 
@SuppressWarnings("cast")
@Test
public void testLastIndexOfFloatWithStartIndex4059() { 
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
@Test
public void testIsEmptyPrimitives4061() { 
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
public void testReverseInt4078() { 
     int[] array = new int[] { 1, 2, 3 }; 
     ArrayUtils.reverse(array); 
     assertEquals(array[0], 3); 
     assertEquals(array[1], 2); 
     assertEquals(array[2], 1); 
     array = null; 
     ArrayUtils.reverse(array); 
     assertEquals(null, array); 
 }
@Test
public void testSubarrayInt4140() { 
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
public void testSubarrayByte4204() { 
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
public void testToObject_long4240() { 
     final long[] b = null; 
     assertArrayEquals(null, ArrayUtils.toObject(b)); 
     assertSame(ArrayUtils.EMPTY_LONG_OBJECT_ARRAY, ArrayUtils.toObject(new long[0])); 
     assertTrue(Arrays.equals(new Long[] { Long.valueOf(Long.MIN_VALUE), Long.valueOf(Long.MAX_VALUE), Long.valueOf(9999999) }, ArrayUtils.toObject(new long[] { Long.MIN_VALUE, Long.MAX_VALUE, 9999999 }))); 
 }
@Test
public void testToPrimitive_short4257() { 
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
public void testToPrimitive_char_char4261() { 
     final Character[] b = null; 
     assertEquals(null, ArrayUtils.toPrimitive(b, Character.MIN_VALUE)); 
     assertSame(ArrayUtils.EMPTY_CHAR_ARRAY, ArrayUtils.toPrimitive(new Character[0], (char) 0)); 
     assertTrue(Arrays.equals(new char[] { Character.MIN_VALUE, Character.MAX_VALUE, '0' }, ArrayUtils.toPrimitive(new Character[] { new Character(Character.MIN_VALUE), new Character(Character.MAX_VALUE), new Character('0') }, Character.MIN_VALUE))); 
     assertTrue(Arrays.equals(new char[] { Character.MIN_VALUE, Character.MAX_VALUE, '0' }, ArrayUtils.toPrimitive(new Character[] { new Character(Character.MIN_VALUE), null, new Character('0') }, Character.MAX_VALUE))); 
 } 
@SuppressWarnings("cast")
@Test
public void testIndexOfDoubleWithStartIndexTolerance4269() { 
     double[] array = null; 
     assertEquals(-1, ArrayUtils.indexOf(array, (double) 0, 2, (double) 0)); 
     array = new double[0]; 
     assertEquals(-1, ArrayUtils.indexOf(array, (double) 0, 2, (double) 0)); 
     array = new double[] { 0, 1, 2, 3, 0 }; 
     assertEquals(-1, ArrayUtils.indexOf(array, (double) 0, 99, (double) 0.3)); 
     assertEquals(0, ArrayUtils.indexOf(array, (double) 0, 0, (double) 0.3)); 
     assertEquals(4, ArrayUtils.indexOf(array, (double) 0, 3, (double) 0.3)); 
     assertEquals(2, ArrayUtils.indexOf(array, (double) 2.2, 0, (double) 0.35)); 
     assertEquals(3, ArrayUtils.indexOf(array, (double) 4.15, 0, (double) 2.0)); 
     assertEquals(1, ArrayUtils.indexOf(array, (double) 1.00001324, 0, (double) 0.0001)); 
     assertEquals(3, ArrayUtils.indexOf(array, (double) 4.15, -1, (double) 2.0)); 
     assertEquals(1, ArrayUtils.indexOf(array, (double) 1.00001324, -300, (double) 0.0001)); 
 }
@Test
public void testLastIndexOfWithStartIndex4283() { 
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
public void testToString4288() { 
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
public void testSubarrChar4294() { 
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
public void testIndexOfChar4307() { 
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
public void testToString4312() { 
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
public void testSubarrayDouble4317() { 
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
public void testLastIndexOfLongWithStartIndex4319() { 
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
public void testSubarrayFloat4329() { 
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
public void testReverseBoolean4348() { 
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
public void testSameLengthFloat4354() { 
     final float[] nullArray = null; 
     final float[] emptyArray = new float[0]; 
     final float[] oneArray = new float[] { 2.5f }; 
     final float[] twoArray = new float[] { 6.4f, 5.8f }; 
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
public void testLastIndexOfLong4357() { 
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
public void testIndexOfCharWithStartIndex4358() { 
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
public void testSubarrayByte4360() { 
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
@SuppressWarnings("cast")
@Test
public void testContainsDouble4378() { 
     double[] array = null; 
     assertFalse(ArrayUtils.contains(array, (double) 1)); 
     array = new double[] { 0, 1, 2, 3, 0 }; 
     assertTrue(ArrayUtils.contains(array, (double) 0)); 
     assertTrue(ArrayUtils.contains(array, (double) 1)); 
     assertTrue(ArrayUtils.contains(array, (double) 2)); 
     assertTrue(ArrayUtils.contains(array, (double) 3)); 
     assertFalse(ArrayUtils.contains(array, (double) 99)); 
 }
@Test
public void testToObject_short4386() { 
     final short[] b = null; 
     assertArrayEquals(null, ArrayUtils.toObject(b)); 
     assertSame(ArrayUtils.EMPTY_SHORT_OBJECT_ARRAY, ArrayUtils.toObject(new short[0])); 
     assertTrue(Arrays.equals(new Short[] { Short.valueOf(Short.MIN_VALUE), Short.valueOf(Short.MAX_VALUE), Short.valueOf((short) 9999999) }, ArrayUtils.toObject(new short[] { Short.MIN_VALUE, Short.MAX_VALUE, (short) 9999999 }))); 
 }
@Test
public void testContainsByte4387() { 
     byte[] array = null; 
     assertFalse(ArrayUtils.contains(array, (byte) 1)); 
     array = new byte[] { 0, 1, 2, 3, 0 }; 
     assertTrue(ArrayUtils.contains(array, (byte) 0)); 
     assertTrue(ArrayUtils.contains(array, (byte) 1)); 
     assertTrue(ArrayUtils.contains(array, (byte) 2)); 
     assertTrue(ArrayUtils.contains(array, (byte) 3)); 
     assertFalse(ArrayUtils.contains(array, (byte) 99)); 
 }
@Test
public void testToString4401() { 
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
public void testToPrimitive_char4423() { 
     final Character[] b = null; 
     assertEquals(null, ArrayUtils.toPrimitive(b)); 
     assertSame(ArrayUtils.EMPTY_CHAR_ARRAY, ArrayUtils.toPrimitive(new Character[0])); 
     assertTrue(Arrays.equals(new char[] { Character.MIN_VALUE, Character.MAX_VALUE, '0' }, ArrayUtils.toPrimitive(new Character[] { new Character(Character.MIN_VALUE), new Character(Character.MAX_VALUE), new Character('0') }))); 
     try { 
         ArrayUtils.toPrimitive(new Character[] { new Character(Character.MIN_VALUE), null }); 
         fail(); 
     } catch (final NullPointerException ex) { 
     } 
 }
@Test
public void testToPrimitive_byte_byte4433() { 
     final Byte[] b = null; 
     assertEquals(null, ArrayUtils.toPrimitive(b, Byte.MIN_VALUE)); 
     assertSame(ArrayUtils.EMPTY_BYTE_ARRAY, ArrayUtils.toPrimitive(new Byte[0], (byte) 1)); 
     assertTrue(Arrays.equals(new byte[] { Byte.MIN_VALUE, Byte.MAX_VALUE, (byte) 9999999 }, ArrayUtils.toPrimitive(new Byte[] { Byte.valueOf(Byte.MIN_VALUE), Byte.valueOf(Byte.MAX_VALUE), Byte.valueOf((byte) 9999999) }, Byte.MIN_VALUE))); 
     assertTrue(Arrays.equals(new byte[] { Byte.MIN_VALUE, Byte.MAX_VALUE, (byte) 9999999 }, ArrayUtils.toPrimitive(new Byte[] { Byte.valueOf(Byte.MIN_VALUE), null, Byte.valueOf((byte) 9999999) }, Byte.MAX_VALUE))); 
 }
@Test
public void testReverseDouble4454() { 
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
public void testReverse4460() { 
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
public void testReverseDouble4464() { 
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
public void testReverse4493() { 
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
public void testSubarrChar4502() { 
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
public void testToObject_char4503() { 
     final char[] b = null; 
     assertArrayEquals(null, ArrayUtils.toObject(b)); 
     assertSame(ArrayUtils.EMPTY_CHARACTER_OBJECT_ARRAY, ArrayUtils.toObject(new char[0])); 
     assertTrue(Arrays.equals(new Character[] { new Character(Character.MIN_VALUE), new Character(Character.MAX_VALUE), new Character('0') }, ArrayUtils.toObject(new char[] { Character.MIN_VALUE, Character.MAX_VALUE, '0' }))); 
 }
@Test
public void testToPrimitive_boolean4522() { 
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
public void testToObject_long4530() { 
     final long[] b = null; 
     assertArrayEquals(null, ArrayUtils.toObject(b)); 
     assertSame(ArrayUtils.EMPTY_LONG_OBJECT_ARRAY, ArrayUtils.toObject(new long[0])); 
     assertTrue(Arrays.equals(new Long[] { Long.valueOf(Long.MIN_VALUE), Long.valueOf(Long.MAX_VALUE), Long.valueOf(9999999) }, ArrayUtils.toObject(new long[] { Long.MIN_VALUE, Long.MAX_VALUE, 9999999 }))); 
 }
@Test
public void testNullToEmptyBooleanObject4541() { 
     assertArrayEquals(ArrayUtils.EMPTY_BOOLEAN_OBJECT_ARRAY, ArrayUtils.nullToEmpty((Boolean[]) null)); 
     final Boolean[] original = new Boolean[] { Boolean.TRUE, Boolean.FALSE }; 
     assertArrayEquals(original, ArrayUtils.nullToEmpty(original)); 
     final Boolean[] empty = new Boolean[] {}; 
     final Boolean[] result = ArrayUtils.nullToEmpty(empty); 
     assertArrayEquals(ArrayUtils.EMPTY_BOOLEAN_OBJECT_ARRAY, result); 
     assertTrue(empty != result); 
 } 
@SuppressWarnings("cast")
@Test
public void testLastIndexOfDoubleWithStartIndexTolerance4554() { 
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
@Test
public void testReverseInt4555() { 
     int[] array = new int[] { 1, 2, 3 }; 
     ArrayUtils.reverse(array); 
     assertEquals(array[0], 3); 
     assertEquals(array[1], 2); 
     assertEquals(array[2], 1); 
     array = null; 
     ArrayUtils.reverse(array); 
     assertEquals(null, array); 
 }
@Test
public void testSubarrayShort4565() { 
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
public void testSameLengthByte4588() { 
     final byte[] nullArray = null; 
     final byte[] emptyArray = new byte[0]; 
     final byte[] oneArray = new byte[] { 3 }; 
     final byte[] twoArray = new byte[] { 4, 6 }; 
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
public void testIsNotEmptyPrimitives4602() { 
     final long[] emptyLongArray = new long[] {}; 
     final long[] notEmptyLongArray = new long[] { 1L }; 
     assertFalse(ArrayUtils.isNotEmpty((long[]) null)); 
     assertFalse(ArrayUtils.isNotEmpty(emptyLongArray)); 
     assertTrue(ArrayUtils.isNotEmpty(notEmptyLongArray)); 
     final int[] emptyIntArray = new int[] {}; 
     final int[] notEmptyIntArray = new int[] { 1 }; 
     assertFalse(ArrayUtils.isNotEmpty((int[]) null)); 
     assertFalse(ArrayUtils.isNotEmpty(emptyIntArray)); 
     assertTrue(ArrayUtils.isNotEmpty(notEmptyIntArray)); 
     final short[] emptyShortArray = new short[] {}; 
     final short[] notEmptyShortArray = new short[] { 1 }; 
     assertFalse(ArrayUtils.isNotEmpty((short[]) null)); 
     assertFalse(ArrayUtils.isNotEmpty(emptyShortArray)); 
     assertTrue(ArrayUtils.isNotEmpty(notEmptyShortArray)); 
     final char[] emptyCharArray = new char[] {}; 
     final char[] notEmptyCharArray = new char[] { 1 }; 
     assertFalse(ArrayUtils.isNotEmpty((char[]) null)); 
     assertFalse(ArrayUtils.isNotEmpty(emptyCharArray)); 
     assertTrue(ArrayUtils.isNotEmpty(notEmptyCharArray)); 
     final byte[] emptyByteArray = new byte[] {}; 
     final byte[] notEmptyByteArray = new byte[] { 1 }; 
     assertFalse(ArrayUtils.isNotEmpty((byte[]) null)); 
     assertFalse(ArrayUtils.isNotEmpty(emptyByteArray)); 
     assertTrue(ArrayUtils.isNotEmpty(notEmptyByteArray)); 
     final double[] emptyDoubleArray = new double[] {}; 
     final double[] notEmptyDoubleArray = new double[] { 1.0 }; 
     assertFalse(ArrayUtils.isNotEmpty((double[]) null)); 
     assertFalse(ArrayUtils.isNotEmpty(emptyDoubleArray)); 
     assertTrue(ArrayUtils.isNotEmpty(notEmptyDoubleArray)); 
     final float[] emptyFloatArray = new float[] {}; 
     final float[] notEmptyFloatArray = new float[] { 1.0F }; 
     assertFalse(ArrayUtils.isNotEmpty((float[]) null)); 
     assertFalse(ArrayUtils.isNotEmpty(emptyFloatArray)); 
     assertTrue(ArrayUtils.isNotEmpty(notEmptyFloatArray)); 
     final boolean[] emptyBooleanArray = new boolean[] {}; 
     final boolean[] notEmptyBooleanArray = new boolean[] { true }; 
     assertFalse(ArrayUtils.isNotEmpty((boolean[]) null)); 
     assertFalse(ArrayUtils.isNotEmpty(emptyBooleanArray)); 
     assertTrue(ArrayUtils.isNotEmpty(notEmptyBooleanArray)); 
 }
@Test
public void testToPrimitive_short_short4605() { 
     final Short[] s = null; 
     assertEquals(null, ArrayUtils.toPrimitive(s, Short.MIN_VALUE)); 
     assertSame(ArrayUtils.EMPTY_SHORT_ARRAY, ArrayUtils.toPrimitive(new Short[0], Short.MIN_VALUE)); 
     assertTrue(Arrays.equals(new short[] { Short.MIN_VALUE, Short.MAX_VALUE, (short) 9999999 }, ArrayUtils.toPrimitive(new Short[] { Short.valueOf(Short.MIN_VALUE), Short.valueOf(Short.MAX_VALUE), Short.valueOf((short) 9999999) }, Short.MIN_VALUE))); 
     assertTrue(Arrays.equals(new short[] { Short.MIN_VALUE, Short.MAX_VALUE, (short) 9999999 }, ArrayUtils.toPrimitive(new Short[] { Short.valueOf(Short.MIN_VALUE), null, Short.valueOf((short) 9999999) }, Short.MAX_VALUE))); 
 }
@Test
public void testReverseInt4612() { 
     int[] array = new int[] { 1, 2, 3 }; 
     ArrayUtils.reverse(array); 
     assertEquals(array[0], 3); 
     assertEquals(array[1], 2); 
     assertEquals(array[2], 1); 
     array = null; 
     ArrayUtils.reverse(array); 
     assertEquals(null, array); 
 }
@Test
public void testNullToEmptyLongObject4622() { 
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
public void testToPrimitive_short_short4638() { 
     final Short[] s = null; 
     assertEquals(null, ArrayUtils.toPrimitive(s, Short.MIN_VALUE)); 
     assertSame(ArrayUtils.EMPTY_SHORT_ARRAY, ArrayUtils.toPrimitive(new Short[0], Short.MIN_VALUE)); 
     assertTrue(Arrays.equals(new short[] { Short.MIN_VALUE, Short.MAX_VALUE, (short) 9999999 }, ArrayUtils.toPrimitive(new Short[] { Short.valueOf(Short.MIN_VALUE), Short.valueOf(Short.MAX_VALUE), Short.valueOf((short) 9999999) }, Short.MIN_VALUE))); 
     assertTrue(Arrays.equals(new short[] { Short.MIN_VALUE, Short.MAX_VALUE, (short) 9999999 }, ArrayUtils.toPrimitive(new Short[] { Short.valueOf(Short.MIN_VALUE), null, Short.valueOf((short) 9999999) }, Short.MAX_VALUE))); 
 }
@Test
public void testLastIndexOfWithStartIndex4654() { 
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
public void testSubarrChar4663() { 
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
public void testToObject_int4667() { 
     final int[] b = null; 
     assertArrayEquals(null, ArrayUtils.toObject(b)); 
     assertSame(ArrayUtils.EMPTY_INTEGER_OBJECT_ARRAY, ArrayUtils.toObject(new int[0])); 
     assertTrue(Arrays.equals(new Integer[] { Integer.valueOf(Integer.MIN_VALUE), Integer.valueOf(Integer.MAX_VALUE), Integer.valueOf(9999999) }, ArrayUtils.toObject(new int[] { Integer.MIN_VALUE, Integer.MAX_VALUE, 9999999 }))); 
 }
@Test
public void testToPrimitive_short4690() { 
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
public void testToPrimitive_long_long4705() { 
     final Long[] l = null; 
     assertEquals(null, ArrayUtils.toPrimitive(l, Long.MIN_VALUE)); 
     assertSame(ArrayUtils.EMPTY_LONG_ARRAY, ArrayUtils.toPrimitive(new Long[0], 1)); 
     assertTrue(Arrays.equals(new long[] { Long.MIN_VALUE, Long.MAX_VALUE, 9999999 }, ArrayUtils.toPrimitive(new Long[] { Long.valueOf(Long.MIN_VALUE), Long.valueOf(Long.MAX_VALUE), Long.valueOf(9999999) }, 1))); 
     assertTrue(Arrays.equals(new long[] { Long.MIN_VALUE, Long.MAX_VALUE, 9999999 }, ArrayUtils.toPrimitive(new Long[] { Long.valueOf(Long.MIN_VALUE), null, Long.valueOf(9999999) }, Long.MAX_VALUE))); 
 }
@Test
public void testContainsShort4706() { 
     short[] array = null; 
     assertFalse(ArrayUtils.contains(array, (short) 1)); 
     array = new short[] { 0, 1, 2, 3, 0 }; 
     assertTrue(ArrayUtils.contains(array, (short) 0)); 
     assertTrue(ArrayUtils.contains(array, (short) 1)); 
     assertTrue(ArrayUtils.contains(array, (short) 2)); 
     assertTrue(ArrayUtils.contains(array, (short) 3)); 
     assertFalse(ArrayUtils.contains(array, (short) 99)); 
 }
@Test
public void testContainsBoolean4722() { 
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
public void testSubarrayFloat4725() { 
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
public void testToString4749() { 
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
@SuppressWarnings("cast")
@Test
public void testLastIndexOfDoubleWithStartIndex4770() { 
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
@Test
public void testToPrimitive_long_long4779() { 
     final Long[] l = null; 
     assertEquals(null, ArrayUtils.toPrimitive(l, Long.MIN_VALUE)); 
     assertSame(ArrayUtils.EMPTY_LONG_ARRAY, ArrayUtils.toPrimitive(new Long[0], 1)); 
     assertTrue(Arrays.equals(new long[] { Long.MIN_VALUE, Long.MAX_VALUE, 9999999 }, ArrayUtils.toPrimitive(new Long[] { Long.valueOf(Long.MIN_VALUE), Long.valueOf(Long.MAX_VALUE), Long.valueOf(9999999) }, 1))); 
     assertTrue(Arrays.equals(new long[] { Long.MIN_VALUE, Long.MAX_VALUE, 9999999 }, ArrayUtils.toPrimitive(new Long[] { Long.valueOf(Long.MIN_VALUE), null, Long.valueOf(9999999) }, Long.MAX_VALUE))); 
 }
@Test
public void testNullToEmptyCharObject4787() { 
     assertArrayEquals(ArrayUtils.EMPTY_CHARACTER_OBJECT_ARRAY, ArrayUtils.nullToEmpty((Character[]) null)); 
     final Character[] original = new Character[] { 'a', 'b' }; 
     assertArrayEquals(original, ArrayUtils.nullToEmpty(original)); 
     final Character[] empty = new Character[] {}; 
     final Character[] result = ArrayUtils.nullToEmpty(empty); 
     assertArrayEquals(ArrayUtils.EMPTY_CHARACTER_OBJECT_ARRAY, result); 
     assertTrue(empty != result); 
 }
@Test
public void testToPrimitive_char_char4796() { 
     final Character[] b = null; 
     assertEquals(null, ArrayUtils.toPrimitive(b, Character.MIN_VALUE)); 
     assertSame(ArrayUtils.EMPTY_CHAR_ARRAY, ArrayUtils.toPrimitive(new Character[0], (char) 0)); 
     assertTrue(Arrays.equals(new char[] { Character.MIN_VALUE, Character.MAX_VALUE, '0' }, ArrayUtils.toPrimitive(new Character[] { new Character(Character.MIN_VALUE), new Character(Character.MAX_VALUE), new Character('0') }, Character.MIN_VALUE))); 
     assertTrue(Arrays.equals(new char[] { Character.MIN_VALUE, Character.MAX_VALUE, '0' }, ArrayUtils.toPrimitive(new Character[] { new Character(Character.MIN_VALUE), null, new Character('0') }, Character.MAX_VALUE))); 
 }
@Test
public void testNullToEmptyFloat4797() { 
     assertEquals(ArrayUtils.EMPTY_FLOAT_ARRAY, ArrayUtils.nullToEmpty((float[]) null)); 
     final float[] original = new float[] { 2.6f, 3.8f }; 
     assertEquals(original, ArrayUtils.nullToEmpty(original)); 
     final float[] empty = new float[] {}; 
     final float[] result = ArrayUtils.nullToEmpty(empty); 
     assertEquals(ArrayUtils.EMPTY_FLOAT_ARRAY, result); 
     assertTrue(empty != result); 
 } 
@SuppressWarnings("cast")
@Test
public void testLastIndexOfFloatWithStartIndex4805() { 
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
@Test
public void testNullToEmptyLongObject4810() { 
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
public void testLastIndexOfByteWithStartIndex4811() { 
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
public void testContainsBoolean4813() { 
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
public void testSubarrayShort4824() { 
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
public void testToObject_double4845() { 
     final double[] b = null; 
     assertArrayEquals(null, ArrayUtils.toObject(b)); 
     assertSame(ArrayUtils.EMPTY_DOUBLE_OBJECT_ARRAY, ArrayUtils.toObject(new double[0])); 
     assertTrue(Arrays.equals(new Double[] { Double.valueOf(Double.MIN_VALUE), Double.valueOf(Double.MAX_VALUE), Double.valueOf(9999999) }, ArrayUtils.toObject(new double[] { Double.MIN_VALUE, Double.MAX_VALUE, 9999999 }))); 
 }
@Test
public void testToObject_boolean4854() { 
     final boolean[] b = null; 
     assertArrayEquals(null, ArrayUtils.toObject(b)); 
     assertSame(ArrayUtils.EMPTY_BOOLEAN_OBJECT_ARRAY, ArrayUtils.toObject(new boolean[0])); 
     assertTrue(Arrays.equals(new Boolean[] { Boolean.TRUE, Boolean.FALSE, Boolean.TRUE }, ArrayUtils.toObject(new boolean[] { true, false, true }))); 
 }
@Test
public void testToPrimitive_int4856() { 
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
public void testLastIndexOfInt4882() { 
     int[] array = null; 
     assertEquals(-1, ArrayUtils.lastIndexOf(array, 0)); 
     array = new int[] { 0, 1, 2, 3, 0 }; 
     assertEquals(4, ArrayUtils.lastIndexOf(array, 0)); 
     assertEquals(1, ArrayUtils.lastIndexOf(array, 1)); 
     assertEquals(2, ArrayUtils.lastIndexOf(array, 2)); 
     assertEquals(3, ArrayUtils.lastIndexOf(array, 3)); 
     assertEquals(-1, ArrayUtils.lastIndexOf(array, 99)); 
 }
@Test
public void testLastIndexOfCharWithStartIndex4895() { 
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
public void testToPrimitive_long4923() { 
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
public void testIsNotEmptyPrimitives4929() { 
     final long[] emptyLongArray = new long[] {}; 
     final long[] notEmptyLongArray = new long[] { 1L }; 
     assertFalse(ArrayUtils.isNotEmpty((long[]) null)); 
     assertFalse(ArrayUtils.isNotEmpty(emptyLongArray)); 
     assertTrue(ArrayUtils.isNotEmpty(notEmptyLongArray)); 
     final int[] emptyIntArray = new int[] {}; 
     final int[] notEmptyIntArray = new int[] { 1 }; 
     assertFalse(ArrayUtils.isNotEmpty((int[]) null)); 
     assertFalse(ArrayUtils.isNotEmpty(emptyIntArray)); 
     assertTrue(ArrayUtils.isNotEmpty(notEmptyIntArray)); 
     final short[] emptyShortArray = new short[] {}; 
     final short[] notEmptyShortArray = new short[] { 1 }; 
     assertFalse(ArrayUtils.isNotEmpty((short[]) null)); 
     assertFalse(ArrayUtils.isNotEmpty(emptyShortArray)); 
     assertTrue(ArrayUtils.isNotEmpty(notEmptyShortArray)); 
     final char[] emptyCharArray = new char[] {}; 
     final char[] notEmptyCharArray = new char[] { 1 }; 
     assertFalse(ArrayUtils.isNotEmpty((char[]) null)); 
     assertFalse(ArrayUtils.isNotEmpty(emptyCharArray)); 
     assertTrue(ArrayUtils.isNotEmpty(notEmptyCharArray)); 
     final byte[] emptyByteArray = new byte[] {}; 
     final byte[] notEmptyByteArray = new byte[] { 1 }; 
     assertFalse(ArrayUtils.isNotEmpty((byte[]) null)); 
     assertFalse(ArrayUtils.isNotEmpty(emptyByteArray)); 
     assertTrue(ArrayUtils.isNotEmpty(notEmptyByteArray)); 
     final double[] emptyDoubleArray = new double[] {}; 
     final double[] notEmptyDoubleArray = new double[] { 1.0 }; 
     assertFalse(ArrayUtils.isNotEmpty((double[]) null)); 
     assertFalse(ArrayUtils.isNotEmpty(emptyDoubleArray)); 
     assertTrue(ArrayUtils.isNotEmpty(notEmptyDoubleArray)); 
     final float[] emptyFloatArray = new float[] {}; 
     final float[] notEmptyFloatArray = new float[] { 1.0F }; 
     assertFalse(ArrayUtils.isNotEmpty((float[]) null)); 
     assertFalse(ArrayUtils.isNotEmpty(emptyFloatArray)); 
     assertTrue(ArrayUtils.isNotEmpty(notEmptyFloatArray)); 
     final boolean[] emptyBooleanArray = new boolean[] {}; 
     final boolean[] notEmptyBooleanArray = new boolean[] { true }; 
     assertFalse(ArrayUtils.isNotEmpty((boolean[]) null)); 
     assertFalse(ArrayUtils.isNotEmpty(emptyBooleanArray)); 
     assertTrue(ArrayUtils.isNotEmpty(notEmptyBooleanArray)); 
 }
@Test
public void testToPrimitive_char_char4931() { 
     final Character[] b = null; 
     assertEquals(null, ArrayUtils.toPrimitive(b, Character.MIN_VALUE)); 
     assertSame(ArrayUtils.EMPTY_CHAR_ARRAY, ArrayUtils.toPrimitive(new Character[0], (char) 0)); 
     assertTrue(Arrays.equals(new char[] { Character.MIN_VALUE, Character.MAX_VALUE, '0' }, ArrayUtils.toPrimitive(new Character[] { new Character(Character.MIN_VALUE), new Character(Character.MAX_VALUE), new Character('0') }, Character.MIN_VALUE))); 
     assertTrue(Arrays.equals(new char[] { Character.MIN_VALUE, Character.MAX_VALUE, '0' }, ArrayUtils.toPrimitive(new Character[] { new Character(Character.MIN_VALUE), null, new Character('0') }, Character.MAX_VALUE))); 
 }
@Test
public void testContainsInt4936() { 
     int[] array = null; 
     assertFalse(ArrayUtils.contains(array, 1)); 
     array = new int[] { 0, 1, 2, 3, 0 }; 
     assertTrue(ArrayUtils.contains(array, 0)); 
     assertTrue(ArrayUtils.contains(array, 1)); 
     assertTrue(ArrayUtils.contains(array, 2)); 
     assertTrue(ArrayUtils.contains(array, 3)); 
     assertFalse(ArrayUtils.contains(array, 99)); 
 } 
@SuppressWarnings("cast")
@Test
public void testLastIndexOfDoubleWithStartIndexTolerance4937() { 
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
@Test
public void testToString4942() { 
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
public void testReverseDouble4952() { 
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
public void testReverseBoolean4956() { 
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
public void testToObject_short4972() { 
     final short[] b = null; 
     assertArrayEquals(null, ArrayUtils.toObject(b)); 
     assertSame(ArrayUtils.EMPTY_SHORT_OBJECT_ARRAY, ArrayUtils.toObject(new short[0])); 
     assertTrue(Arrays.equals(new Short[] { Short.valueOf(Short.MIN_VALUE), Short.valueOf(Short.MAX_VALUE), Short.valueOf((short) 9999999) }, ArrayUtils.toObject(new short[] { Short.MIN_VALUE, Short.MAX_VALUE, (short) 9999999 }))); 
 }
@Test
public void testIsNotEmptyPrimitives5004() { 
     final long[] emptyLongArray = new long[] {}; 
     final long[] notEmptyLongArray = new long[] { 1L }; 
     assertFalse(ArrayUtils.isNotEmpty((long[]) null)); 
     assertFalse(ArrayUtils.isNotEmpty(emptyLongArray)); 
     assertTrue(ArrayUtils.isNotEmpty(notEmptyLongArray)); 
     final int[] emptyIntArray = new int[] {}; 
     final int[] notEmptyIntArray = new int[] { 1 }; 
     assertFalse(ArrayUtils.isNotEmpty((int[]) null)); 
     assertFalse(ArrayUtils.isNotEmpty(emptyIntArray)); 
     assertTrue(ArrayUtils.isNotEmpty(notEmptyIntArray)); 
     final short[] emptyShortArray = new short[] {}; 
     final short[] notEmptyShortArray = new short[] { 1 }; 
     assertFalse(ArrayUtils.isNotEmpty((short[]) null)); 
     assertFalse(ArrayUtils.isNotEmpty(emptyShortArray)); 
     assertTrue(ArrayUtils.isNotEmpty(notEmptyShortArray)); 
     final char[] emptyCharArray = new char[] {}; 
     final char[] notEmptyCharArray = new char[] { 1 }; 
     assertFalse(ArrayUtils.isNotEmpty((char[]) null)); 
     assertFalse(ArrayUtils.isNotEmpty(emptyCharArray)); 
     assertTrue(ArrayUtils.isNotEmpty(notEmptyCharArray)); 
     final byte[] emptyByteArray = new byte[] {}; 
     final byte[] notEmptyByteArray = new byte[] { 1 }; 
     assertFalse(ArrayUtils.isNotEmpty((byte[]) null)); 
     assertFalse(ArrayUtils.isNotEmpty(emptyByteArray)); 
     assertTrue(ArrayUtils.isNotEmpty(notEmptyByteArray)); 
     final double[] emptyDoubleArray = new double[] {}; 
     final double[] notEmptyDoubleArray = new double[] { 1.0 }; 
     assertFalse(ArrayUtils.isNotEmpty((double[]) null)); 
     assertFalse(ArrayUtils.isNotEmpty(emptyDoubleArray)); 
     assertTrue(ArrayUtils.isNotEmpty(notEmptyDoubleArray)); 
     final float[] emptyFloatArray = new float[] {}; 
     final float[] notEmptyFloatArray = new float[] { 1.0F }; 
     assertFalse(ArrayUtils.isNotEmpty((float[]) null)); 
     assertFalse(ArrayUtils.isNotEmpty(emptyFloatArray)); 
     assertTrue(ArrayUtils.isNotEmpty(notEmptyFloatArray)); 
     final boolean[] emptyBooleanArray = new boolean[] {}; 
     final boolean[] notEmptyBooleanArray = new boolean[] { true }; 
     assertFalse(ArrayUtils.isNotEmpty((boolean[]) null)); 
     assertFalse(ArrayUtils.isNotEmpty(emptyBooleanArray)); 
     assertTrue(ArrayUtils.isNotEmpty(notEmptyBooleanArray)); 
 }
@Test
public void testNullToEmptyBooleanObject5032() { 
     assertArrayEquals(ArrayUtils.EMPTY_BOOLEAN_OBJECT_ARRAY, ArrayUtils.nullToEmpty((Boolean[]) null)); 
     final Boolean[] original = new Boolean[] { Boolean.TRUE, Boolean.FALSE }; 
     assertArrayEquals(original, ArrayUtils.nullToEmpty(original)); 
     final Boolean[] empty = new Boolean[] {}; 
     final Boolean[] result = ArrayUtils.nullToEmpty(empty); 
     assertArrayEquals(ArrayUtils.EMPTY_BOOLEAN_OBJECT_ARRAY, result); 
     assertTrue(empty != result); 
 }
@Test
public void testToString5034() { 
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
public void testToPrimitive_boolean_boolean5047() { 
     assertEquals(null, ArrayUtils.toPrimitive(null, false)); 
     assertSame(ArrayUtils.EMPTY_BOOLEAN_ARRAY, ArrayUtils.toPrimitive(new Boolean[0], false)); 
     assertTrue(Arrays.equals(new boolean[] { true, false, true }, ArrayUtils.toPrimitive(new Boolean[] { Boolean.TRUE, Boolean.FALSE, Boolean.TRUE }, false))); 
     assertTrue(Arrays.equals(new boolean[] { true, false, false }, ArrayUtils.toPrimitive(new Boolean[] { Boolean.TRUE, null, Boolean.FALSE }, false))); 
     assertTrue(Arrays.equals(new boolean[] { true, true, false }, ArrayUtils.toPrimitive(new Boolean[] { Boolean.TRUE, null, Boolean.FALSE }, true))); 
 }
@Test
public void testReverseShort5059() { 
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
public void testReverse5075() { 
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
public void testLastIndexOfInt5092() { 
     int[] array = null; 
     assertEquals(-1, ArrayUtils.lastIndexOf(array, 0)); 
     array = new int[] { 0, 1, 2, 3, 0 }; 
     assertEquals(4, ArrayUtils.lastIndexOf(array, 0)); 
     assertEquals(1, ArrayUtils.lastIndexOf(array, 1)); 
     assertEquals(2, ArrayUtils.lastIndexOf(array, 2)); 
     assertEquals(3, ArrayUtils.lastIndexOf(array, 3)); 
     assertEquals(-1, ArrayUtils.lastIndexOf(array, 99)); 
 } 
@SuppressWarnings("cast")
@Test
public void testLastIndexOfDoubleWithStartIndex5107() { 
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
@Test
public void testToPrimitive_long_long5110() { 
     final Long[] l = null; 
     assertEquals(null, ArrayUtils.toPrimitive(l, Long.MIN_VALUE)); 
     assertSame(ArrayUtils.EMPTY_LONG_ARRAY, ArrayUtils.toPrimitive(new Long[0], 1)); 
     assertTrue(Arrays.equals(new long[] { Long.MIN_VALUE, Long.MAX_VALUE, 9999999 }, ArrayUtils.toPrimitive(new Long[] { Long.valueOf(Long.MIN_VALUE), Long.valueOf(Long.MAX_VALUE), Long.valueOf(9999999) }, 1))); 
     assertTrue(Arrays.equals(new long[] { Long.MIN_VALUE, Long.MAX_VALUE, 9999999 }, ArrayUtils.toPrimitive(new Long[] { Long.valueOf(Long.MIN_VALUE), null, Long.valueOf(9999999) }, Long.MAX_VALUE))); 
 }
@Test
public void testSubarrayShort5113() { 
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
public void testReverseChar5116() { 
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
public void testToPrimitive_float5142() { 
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
public void testToPrimitive_float_float5149() { 
     final Float[] l = null; 
     assertEquals(null, ArrayUtils.toPrimitive(l, Float.MIN_VALUE)); 
     assertSame(ArrayUtils.EMPTY_FLOAT_ARRAY, ArrayUtils.toPrimitive(new Float[0], 1)); 
     assertTrue(Arrays.equals(new float[] { Float.MIN_VALUE, Float.MAX_VALUE, 9999999 }, ArrayUtils.toPrimitive(new Float[] { Float.valueOf(Float.MIN_VALUE), Float.valueOf(Float.MAX_VALUE), Float.valueOf(9999999) }, 1))); 
     assertTrue(Arrays.equals(new float[] { Float.MIN_VALUE, Float.MAX_VALUE, 9999999 }, ArrayUtils.toPrimitive(new Float[] { Float.valueOf(Float.MIN_VALUE), null, Float.valueOf(9999999) }, Float.MAX_VALUE))); 
 }
@Test
public void testHashCode5152() { 
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
public void testSubarrayInt5180() { 
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
public void testReverseShort5186() { 
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
public void testLastIndexOfWithStartIndex5193() { 
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
public void testToObject_boolean5214() { 
     final boolean[] b = null; 
     assertArrayEquals(null, ArrayUtils.toObject(b)); 
     assertSame(ArrayUtils.EMPTY_BOOLEAN_OBJECT_ARRAY, ArrayUtils.toObject(new boolean[0])); 
     assertTrue(Arrays.equals(new Boolean[] { Boolean.TRUE, Boolean.FALSE, Boolean.TRUE }, ArrayUtils.toObject(new boolean[] { true, false, true }))); 
 }
@Test
public void testLastIndexOfBooleanWithStartIndex5221() { 
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
public void testIsNotEmptyObject5250() { 
     final Object[] emptyArray = new Object[] {}; 
     final Object[] notEmptyArray = new Object[] { new String("Value") }; 
     assertFalse(ArrayUtils.isNotEmpty((Object[]) null)); 
     assertFalse(ArrayUtils.isNotEmpty(emptyArray)); 
     assertTrue(ArrayUtils.isNotEmpty(notEmptyArray)); 
 }
@Test
public void testReverseChar5279() { 
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
public void testNullToEmptyDouble5291() { 
     assertEquals(ArrayUtils.EMPTY_DOUBLE_ARRAY, ArrayUtils.nullToEmpty((double[]) null)); 
     final double[] original = new double[] { 1L, 2L }; 
     assertEquals(original, ArrayUtils.nullToEmpty(original)); 
     final double[] empty = new double[] {}; 
     final double[] result = ArrayUtils.nullToEmpty(empty); 
     assertEquals(ArrayUtils.EMPTY_DOUBLE_ARRAY, result); 
     assertTrue(empty != result); 
 }
@Test
public void testToObject_byte5292() { 
     final byte[] b = null; 
     assertArrayEquals(null, ArrayUtils.toObject(b)); 
     assertSame(ArrayUtils.EMPTY_BYTE_OBJECT_ARRAY, ArrayUtils.toObject(new byte[0])); 
     assertTrue(Arrays.equals(new Byte[] { Byte.valueOf(Byte.MIN_VALUE), Byte.valueOf(Byte.MAX_VALUE), Byte.valueOf((byte) 9999999) }, ArrayUtils.toObject(new byte[] { Byte.MIN_VALUE, Byte.MAX_VALUE, (byte) 9999999 }))); 
 }
@Test
public void testIndexOfShortWithStartIndex5300() { 
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
public void testNullToEmptyBoolean5301() { 
     assertEquals(ArrayUtils.EMPTY_BOOLEAN_ARRAY, ArrayUtils.nullToEmpty((boolean[]) null)); 
     final boolean[] original = new boolean[] { true, false }; 
     assertEquals(original, ArrayUtils.nullToEmpty(original)); 
     final boolean[] empty = new boolean[] {}; 
     final boolean[] result = ArrayUtils.nullToEmpty(empty); 
     assertEquals(ArrayUtils.EMPTY_BOOLEAN_ARRAY, result); 
     assertTrue(empty != result); 
 }
@Test
public void testIndexOfCharWithStartIndex5306() { 
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
public void testLastIndexOf5315() { 
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
public void testSameType5320() { 
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
@SuppressWarnings("cast")
@Test
public void testLastIndexOfDoubleWithStartIndexTolerance5339() { 
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
@Test
public void testSubarrayDouble5340() { 
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
public void testReverseShort5345() { 
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
public void testToObject_double5351() { 
     final double[] b = null; 
     assertArrayEquals(null, ArrayUtils.toObject(b)); 
     assertSame(ArrayUtils.EMPTY_DOUBLE_OBJECT_ARRAY, ArrayUtils.toObject(new double[0])); 
     assertTrue(Arrays.equals(new Double[] { Double.valueOf(Double.MIN_VALUE), Double.valueOf(Double.MAX_VALUE), Double.valueOf(9999999) }, ArrayUtils.toObject(new double[] { Double.MIN_VALUE, Double.MAX_VALUE, 9999999 }))); 
 }
@Test
public void testSubarrChar5382() { 
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
@SuppressWarnings("cast")
@Test
public void testLastIndexOfDoubleWithStartIndexTolerance5390() { 
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
@Test
public void testToString5427() { 
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
public void testToString5444() { 
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
public void testToPrimitive_boolean_boolean5458() { 
     assertEquals(null, ArrayUtils.toPrimitive(null, false)); 
     assertSame(ArrayUtils.EMPTY_BOOLEAN_ARRAY, ArrayUtils.toPrimitive(new Boolean[0], false)); 
     assertTrue(Arrays.equals(new boolean[] { true, false, true }, ArrayUtils.toPrimitive(new Boolean[] { Boolean.TRUE, Boolean.FALSE, Boolean.TRUE }, false))); 
     assertTrue(Arrays.equals(new boolean[] { true, false, false }, ArrayUtils.toPrimitive(new Boolean[] { Boolean.TRUE, null, Boolean.FALSE }, false))); 
     assertTrue(Arrays.equals(new boolean[] { true, true, false }, ArrayUtils.toPrimitive(new Boolean[] { Boolean.TRUE, null, Boolean.FALSE }, true))); 
 }
@Test
public void testReverseShort5470() { 
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
public void testReverseFloat5476() { 
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
public void testSubarrayDouble5479() { 
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
public void testSameLengthBoolean5482() { 
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
public void testSameLengthShort5491() { 
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
public void testToPrimitive_boolean_boolean5493() { 
     assertEquals(null, ArrayUtils.toPrimitive(null, false)); 
     assertSame(ArrayUtils.EMPTY_BOOLEAN_ARRAY, ArrayUtils.toPrimitive(new Boolean[0], false)); 
     assertTrue(Arrays.equals(new boolean[] { true, false, true }, ArrayUtils.toPrimitive(new Boolean[] { Boolean.TRUE, Boolean.FALSE, Boolean.TRUE }, false))); 
     assertTrue(Arrays.equals(new boolean[] { true, false, false }, ArrayUtils.toPrimitive(new Boolean[] { Boolean.TRUE, null, Boolean.FALSE }, false))); 
     assertTrue(Arrays.equals(new boolean[] { true, true, false }, ArrayUtils.toPrimitive(new Boolean[] { Boolean.TRUE, null, Boolean.FALSE }, true))); 
 }
@Test
public void testLastIndexOfWithStartIndex5501() { 
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
public void testSameLengthDouble5506() { 
     final double[] nullArray = null; 
     final double[] emptyArray = new double[0]; 
     final double[] oneArray = new double[] { 1.3d }; 
     final double[] twoArray = new double[] { 4.5d, 6.3d }; 
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
public void testReverseLong5522() { 
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
public void testSubarrayInt5566() { 
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
public void testToPrimitive_boolean5578() { 
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
@SuppressWarnings("cast")
@Test
public void testLastIndexOfFloatWithStartIndex5583() { 
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
@Test
public void testSameLengthFloat5603() { 
     final float[] nullArray = null; 
     final float[] emptyArray = new float[0]; 
     final float[] oneArray = new float[] { 2.5f }; 
     final float[] twoArray = new float[] { 6.4f, 5.8f }; 
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
public void testLastIndexOfInt5604() { 
     int[] array = null; 
     assertEquals(-1, ArrayUtils.lastIndexOf(array, 0)); 
     array = new int[] { 0, 1, 2, 3, 0 }; 
     assertEquals(4, ArrayUtils.lastIndexOf(array, 0)); 
     assertEquals(1, ArrayUtils.lastIndexOf(array, 1)); 
     assertEquals(2, ArrayUtils.lastIndexOf(array, 2)); 
     assertEquals(3, ArrayUtils.lastIndexOf(array, 3)); 
     assertEquals(-1, ArrayUtils.lastIndexOf(array, 99)); 
 }
@Test
public void testToString5610() { 
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
public void testReverse5620() { 
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
@SuppressWarnings("cast")
@Test
public void testLastIndexOfFloatWithStartIndex5625() { 
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
@Test
public void testSubarrChar5634() { 
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
public void testToObject_long5661() { 
     final long[] b = null; 
     assertArrayEquals(null, ArrayUtils.toObject(b)); 
     assertSame(ArrayUtils.EMPTY_LONG_OBJECT_ARRAY, ArrayUtils.toObject(new long[0])); 
     assertTrue(Arrays.equals(new Long[] { Long.valueOf(Long.MIN_VALUE), Long.valueOf(Long.MAX_VALUE), Long.valueOf(9999999) }, ArrayUtils.toObject(new long[] { Long.MIN_VALUE, Long.MAX_VALUE, 9999999 }))); 
 }
@Test
public void testConstructor5673() { 
     assertNotNull(new ArrayUtils()); 
     final Constructor<?>[] cons = ArrayUtils.class.getDeclaredConstructors(); 
     assertEquals(1, cons.length); 
     assertTrue(Modifier.isPublic(cons[0].getModifiers())); 
     assertTrue(Modifier.isPublic(ArrayUtils.class.getModifiers())); 
     assertFalse(Modifier.isFinal(ArrayUtils.class.getModifiers())); 
 }
@Test
public void testToPrimitive_int5695() { 
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
public void testIsEmptyPrimitives5711() { 
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
public void testReverseBoolean5722() { 
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
public void testLastIndexOfWithStartIndex5724() { 
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
public void testLastIndexOfLongWithStartIndex5770() { 
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
public void testToPrimitive_double_double5780() { 
     final Double[] l = null; 
     assertEquals(null, ArrayUtils.toPrimitive(l, Double.MIN_VALUE)); 
     assertSame(ArrayUtils.EMPTY_DOUBLE_ARRAY, ArrayUtils.toPrimitive(new Double[0], 1)); 
     assertTrue(Arrays.equals(new double[] { Double.MIN_VALUE, Double.MAX_VALUE, 9999999 }, ArrayUtils.toPrimitive(new Double[] { Double.valueOf(Double.MIN_VALUE), Double.valueOf(Double.MAX_VALUE), Double.valueOf(9999999) }, 1))); 
     assertTrue(Arrays.equals(new double[] { Double.MIN_VALUE, Double.MAX_VALUE, 9999999 }, ArrayUtils.toPrimitive(new Double[] { Double.valueOf(Double.MIN_VALUE), null, Double.valueOf(9999999) }, Double.MAX_VALUE))); 
 }
@Test
public void testIsEmptyPrimitives5790() { 
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
public void testLastIndexOfCharWithStartIndex5836() { 
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
public void testToObject_boolean5838() { 
     final boolean[] b = null; 
     assertArrayEquals(null, ArrayUtils.toObject(b)); 
     assertSame(ArrayUtils.EMPTY_BOOLEAN_OBJECT_ARRAY, ArrayUtils.toObject(new boolean[0])); 
     assertTrue(Arrays.equals(new Boolean[] { Boolean.TRUE, Boolean.FALSE, Boolean.TRUE }, ArrayUtils.toObject(new boolean[] { true, false, true }))); 
 }
@Test
public void testReverseDouble5849() { 
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
public void testNullToEmptyBoolean5865() { 
     assertEquals(ArrayUtils.EMPTY_BOOLEAN_ARRAY, ArrayUtils.nullToEmpty((boolean[]) null)); 
     final boolean[] original = new boolean[] { true, false }; 
     assertEquals(original, ArrayUtils.nullToEmpty(original)); 
     final boolean[] empty = new boolean[] {}; 
     final boolean[] result = ArrayUtils.nullToEmpty(empty); 
     assertEquals(ArrayUtils.EMPTY_BOOLEAN_ARRAY, result); 
     assertTrue(empty != result); 
 }
@Test
public void testToObject_byte5867() { 
     final byte[] b = null; 
     assertArrayEquals(null, ArrayUtils.toObject(b)); 
     assertSame(ArrayUtils.EMPTY_BYTE_OBJECT_ARRAY, ArrayUtils.toObject(new byte[0])); 
     assertTrue(Arrays.equals(new Byte[] { Byte.valueOf(Byte.MIN_VALUE), Byte.valueOf(Byte.MAX_VALUE), Byte.valueOf((byte) 9999999) }, ArrayUtils.toObject(new byte[] { Byte.MIN_VALUE, Byte.MAX_VALUE, (byte) 9999999 }))); 
 }
@Test
public void testSubarrayFloat5884() { 
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
public void testHashCode5885() { 
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
public void testIndexOfIntWithStartIndex5889() { 
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
public void testNullToEmptyCharObject5893() { 
     assertArrayEquals(ArrayUtils.EMPTY_CHARACTER_OBJECT_ARRAY, ArrayUtils.nullToEmpty((Character[]) null)); 
     final Character[] original = new Character[] { 'a', 'b' }; 
     assertArrayEquals(original, ArrayUtils.nullToEmpty(original)); 
     final Character[] empty = new Character[] {}; 
     final Character[] result = ArrayUtils.nullToEmpty(empty); 
     assertArrayEquals(ArrayUtils.EMPTY_CHARACTER_OBJECT_ARRAY, result); 
     assertTrue(empty != result); 
 }
@Test
public void testSameLengthShort5908() { 
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
public void testToPrimitive_int_int5919() { 
     final Long[] l = null; 
     assertEquals(null, ArrayUtils.toPrimitive(l, Integer.MIN_VALUE)); 
     assertSame(ArrayUtils.EMPTY_INT_ARRAY, ArrayUtils.toPrimitive(new Integer[0], 1)); 
     assertTrue(Arrays.equals(new int[] { Integer.MIN_VALUE, Integer.MAX_VALUE, 9999999 }, ArrayUtils.toPrimitive(new Integer[] { Integer.valueOf(Integer.MIN_VALUE), Integer.valueOf(Integer.MAX_VALUE), Integer.valueOf(9999999) }, 1))); 
     assertTrue(Arrays.equals(new int[] { Integer.MIN_VALUE, Integer.MAX_VALUE, 9999999 }, ArrayUtils.toPrimitive(new Integer[] { Integer.valueOf(Integer.MIN_VALUE), null, Integer.valueOf(9999999) }, Integer.MAX_VALUE))); 
 }
@Test
public void testArrayCreationWithDifferentTypes5921() { 
     final Number[] array = ArrayUtils.<Number>toArray(Integer.valueOf(42), Double.valueOf(Math.PI)); 
     assertEquals(2, array.length); 
     assertEquals(Integer.valueOf(42), array[0]); 
     assertEquals(Double.valueOf(Math.PI), array[1]); 
 }
@Test
public void testSubarrChar5936() { 
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
@SuppressWarnings("cast")
@Test
public void testLastIndexOfFloatWithStartIndex5946() { 
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
@Test
public void testToPrimitive_int_int5959() { 
     final Long[] l = null; 
     assertEquals(null, ArrayUtils.toPrimitive(l, Integer.MIN_VALUE)); 
     assertSame(ArrayUtils.EMPTY_INT_ARRAY, ArrayUtils.toPrimitive(new Integer[0], 1)); 
     assertTrue(Arrays.equals(new int[] { Integer.MIN_VALUE, Integer.MAX_VALUE, 9999999 }, ArrayUtils.toPrimitive(new Integer[] { Integer.valueOf(Integer.MIN_VALUE), Integer.valueOf(Integer.MAX_VALUE), Integer.valueOf(9999999) }, 1))); 
     assertTrue(Arrays.equals(new int[] { Integer.MIN_VALUE, Integer.MAX_VALUE, 9999999 }, ArrayUtils.toPrimitive(new Integer[] { Integer.valueOf(Integer.MIN_VALUE), null, Integer.valueOf(9999999) }, Integer.MAX_VALUE))); 
 }
@Test
public void testIsNotEmptyPrimitives5964() { 
     final long[] emptyLongArray = new long[] {}; 
     final long[] notEmptyLongArray = new long[] { 1L }; 
     assertFalse(ArrayUtils.isNotEmpty((long[]) null)); 
     assertFalse(ArrayUtils.isNotEmpty(emptyLongArray)); 
     assertTrue(ArrayUtils.isNotEmpty(notEmptyLongArray)); 
     final int[] emptyIntArray = new int[] {}; 
     final int[] notEmptyIntArray = new int[] { 1 }; 
     assertFalse(ArrayUtils.isNotEmpty((int[]) null)); 
     assertFalse(ArrayUtils.isNotEmpty(emptyIntArray)); 
     assertTrue(ArrayUtils.isNotEmpty(notEmptyIntArray)); 
     final short[] emptyShortArray = new short[] {}; 
     final short[] notEmptyShortArray = new short[] { 1 }; 
     assertFalse(ArrayUtils.isNotEmpty((short[]) null)); 
     assertFalse(ArrayUtils.isNotEmpty(emptyShortArray)); 
     assertTrue(ArrayUtils.isNotEmpty(notEmptyShortArray)); 
     final char[] emptyCharArray = new char[] {}; 
     final char[] notEmptyCharArray = new char[] { 1 }; 
     assertFalse(ArrayUtils.isNotEmpty((char[]) null)); 
     assertFalse(ArrayUtils.isNotEmpty(emptyCharArray)); 
     assertTrue(ArrayUtils.isNotEmpty(notEmptyCharArray)); 
     final byte[] emptyByteArray = new byte[] {}; 
     final byte[] notEmptyByteArray = new byte[] { 1 }; 
     assertFalse(ArrayUtils.isNotEmpty((byte[]) null)); 
     assertFalse(ArrayUtils.isNotEmpty(emptyByteArray)); 
     assertTrue(ArrayUtils.isNotEmpty(notEmptyByteArray)); 
     final double[] emptyDoubleArray = new double[] {}; 
     final double[] notEmptyDoubleArray = new double[] { 1.0 }; 
     assertFalse(ArrayUtils.isNotEmpty((double[]) null)); 
     assertFalse(ArrayUtils.isNotEmpty(emptyDoubleArray)); 
     assertTrue(ArrayUtils.isNotEmpty(notEmptyDoubleArray)); 
     final float[] emptyFloatArray = new float[] {}; 
     final float[] notEmptyFloatArray = new float[] { 1.0F }; 
     assertFalse(ArrayUtils.isNotEmpty((float[]) null)); 
     assertFalse(ArrayUtils.isNotEmpty(emptyFloatArray)); 
     assertTrue(ArrayUtils.isNotEmpty(notEmptyFloatArray)); 
     final boolean[] emptyBooleanArray = new boolean[] {}; 
     final boolean[] notEmptyBooleanArray = new boolean[] { true }; 
     assertFalse(ArrayUtils.isNotEmpty((boolean[]) null)); 
     assertFalse(ArrayUtils.isNotEmpty(emptyBooleanArray)); 
     assertTrue(ArrayUtils.isNotEmpty(notEmptyBooleanArray)); 
 }
@Test
public void testLastIndexOfByteWithStartIndex5969() { 
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
public void testToObject_int5989() { 
     final int[] b = null; 
     assertArrayEquals(null, ArrayUtils.toObject(b)); 
     assertSame(ArrayUtils.EMPTY_INTEGER_OBJECT_ARRAY, ArrayUtils.toObject(new int[0])); 
     assertTrue(Arrays.equals(new Integer[] { Integer.valueOf(Integer.MIN_VALUE), Integer.valueOf(Integer.MAX_VALUE), Integer.valueOf(9999999) }, ArrayUtils.toObject(new int[] { Integer.MIN_VALUE, Integer.MAX_VALUE, 9999999 }))); 
 }
@Test
public void testNullToEmptyObject5992() { 
     assertArrayEquals(ArrayUtils.EMPTY_OBJECT_ARRAY, ArrayUtils.nullToEmpty((Object[]) null)); 
     final Object[] original = new Object[] { Boolean.TRUE, Boolean.FALSE }; 
     assertArrayEquals(original, ArrayUtils.nullToEmpty(original)); 
     final Object[] empty = new Object[] {}; 
     final Object[] result = ArrayUtils.nullToEmpty(empty); 
     assertArrayEquals(ArrayUtils.EMPTY_OBJECT_ARRAY, result); 
     assertTrue(empty != result); 
 } 
@SuppressWarnings("cast")
@Test
public void testIndexOfDoubleWithStartIndexTolerance6016() { 
     double[] array = null; 
     assertEquals(-1, ArrayUtils.indexOf(array, (double) 0, 2, (double) 0)); 
     array = new double[0]; 
     assertEquals(-1, ArrayUtils.indexOf(array, (double) 0, 2, (double) 0)); 
     array = new double[] { 0, 1, 2, 3, 0 }; 
     assertEquals(-1, ArrayUtils.indexOf(array, (double) 0, 99, (double) 0.3)); 
     assertEquals(0, ArrayUtils.indexOf(array, (double) 0, 0, (double) 0.3)); 
     assertEquals(4, ArrayUtils.indexOf(array, (double) 0, 3, (double) 0.3)); 
     assertEquals(2, ArrayUtils.indexOf(array, (double) 2.2, 0, (double) 0.35)); 
     assertEquals(3, ArrayUtils.indexOf(array, (double) 4.15, 0, (double) 2.0)); 
     assertEquals(1, ArrayUtils.indexOf(array, (double) 1.00001324, 0, (double) 0.0001)); 
     assertEquals(3, ArrayUtils.indexOf(array, (double) 4.15, -1, (double) 2.0)); 
     assertEquals(1, ArrayUtils.indexOf(array, (double) 1.00001324, -300, (double) 0.0001)); 
 }
@Test
public void testToPrimitive_long_long6040() { 
     final Long[] l = null; 
     assertEquals(null, ArrayUtils.toPrimitive(l, Long.MIN_VALUE)); 
     assertSame(ArrayUtils.EMPTY_LONG_ARRAY, ArrayUtils.toPrimitive(new Long[0], 1)); 
     assertTrue(Arrays.equals(new long[] { Long.MIN_VALUE, Long.MAX_VALUE, 9999999 }, ArrayUtils.toPrimitive(new Long[] { Long.valueOf(Long.MIN_VALUE), Long.valueOf(Long.MAX_VALUE), Long.valueOf(9999999) }, 1))); 
     assertTrue(Arrays.equals(new long[] { Long.MIN_VALUE, Long.MAX_VALUE, 9999999 }, ArrayUtils.toPrimitive(new Long[] { Long.valueOf(Long.MIN_VALUE), null, Long.valueOf(9999999) }, Long.MAX_VALUE))); 
 }
@Test
public void testSubarrayDouble6065() { 
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
public void testToPrimitive_int_int6076() { 
     final Long[] l = null; 
     assertEquals(null, ArrayUtils.toPrimitive(l, Integer.MIN_VALUE)); 
     assertSame(ArrayUtils.EMPTY_INT_ARRAY, ArrayUtils.toPrimitive(new Integer[0], 1)); 
     assertTrue(Arrays.equals(new int[] { Integer.MIN_VALUE, Integer.MAX_VALUE, 9999999 }, ArrayUtils.toPrimitive(new Integer[] { Integer.valueOf(Integer.MIN_VALUE), Integer.valueOf(Integer.MAX_VALUE), Integer.valueOf(9999999) }, 1))); 
     assertTrue(Arrays.equals(new int[] { Integer.MIN_VALUE, Integer.MAX_VALUE, 9999999 }, ArrayUtils.toPrimitive(new Integer[] { Integer.valueOf(Integer.MIN_VALUE), null, Integer.valueOf(9999999) }, Integer.MAX_VALUE))); 
 }
@Test
public void testSubarrayShort6084() { 
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
public void testToPrimitive_float6094() { 
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
public void testToObject_byte6106() { 
     final byte[] b = null; 
     assertArrayEquals(null, ArrayUtils.toObject(b)); 
     assertSame(ArrayUtils.EMPTY_BYTE_OBJECT_ARRAY, ArrayUtils.toObject(new byte[0])); 
     assertTrue(Arrays.equals(new Byte[] { Byte.valueOf(Byte.MIN_VALUE), Byte.valueOf(Byte.MAX_VALUE), Byte.valueOf((byte) 9999999) }, ArrayUtils.toObject(new byte[] { Byte.MIN_VALUE, Byte.MAX_VALUE, (byte) 9999999 }))); 
 }
@Test
public void testNullToEmptyLong6110() { 
     assertEquals(ArrayUtils.EMPTY_LONG_ARRAY, ArrayUtils.nullToEmpty((long[]) null)); 
     final long[] original = new long[] { 1L, 2L }; 
     assertEquals(original, ArrayUtils.nullToEmpty(original)); 
     final long[] empty = new long[] {}; 
     final long[] result = ArrayUtils.nullToEmpty(empty); 
     assertEquals(ArrayUtils.EMPTY_LONG_ARRAY, result); 
     assertTrue(empty != result); 
 }
@Test
public void testSubarrChar6113() { 
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
public void testReverseByte6128() { 
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
public void testToPrimitive_double6139() { 
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
public void testSubarrayShort6142() { 
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
public void testSameLengthInt6159() { 
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
public void testSameLength6162() { 
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
public void testIsNotEmptyPrimitives6176() { 
     final long[] emptyLongArray = new long[] {}; 
     final long[] notEmptyLongArray = new long[] { 1L }; 
     assertFalse(ArrayUtils.isNotEmpty((long[]) null)); 
     assertFalse(ArrayUtils.isNotEmpty(emptyLongArray)); 
     assertTrue(ArrayUtils.isNotEmpty(notEmptyLongArray)); 
     final int[] emptyIntArray = new int[] {}; 
     final int[] notEmptyIntArray = new int[] { 1 }; 
     assertFalse(ArrayUtils.isNotEmpty((int[]) null)); 
     assertFalse(ArrayUtils.isNotEmpty(emptyIntArray)); 
     assertTrue(ArrayUtils.isNotEmpty(notEmptyIntArray)); 
     final short[] emptyShortArray = new short[] {}; 
     final short[] notEmptyShortArray = new short[] { 1 }; 
     assertFalse(ArrayUtils.isNotEmpty((short[]) null)); 
     assertFalse(ArrayUtils.isNotEmpty(emptyShortArray)); 
     assertTrue(ArrayUtils.isNotEmpty(notEmptyShortArray)); 
     final char[] emptyCharArray = new char[] {}; 
     final char[] notEmptyCharArray = new char[] { 1 }; 
     assertFalse(ArrayUtils.isNotEmpty((char[]) null)); 
     assertFalse(ArrayUtils.isNotEmpty(emptyCharArray)); 
     assertTrue(ArrayUtils.isNotEmpty(notEmptyCharArray)); 
     final byte[] emptyByteArray = new byte[] {}; 
     final byte[] notEmptyByteArray = new byte[] { 1 }; 
     assertFalse(ArrayUtils.isNotEmpty((byte[]) null)); 
     assertFalse(ArrayUtils.isNotEmpty(emptyByteArray)); 
     assertTrue(ArrayUtils.isNotEmpty(notEmptyByteArray)); 
     final double[] emptyDoubleArray = new double[] {}; 
     final double[] notEmptyDoubleArray = new double[] { 1.0 }; 
     assertFalse(ArrayUtils.isNotEmpty((double[]) null)); 
     assertFalse(ArrayUtils.isNotEmpty(emptyDoubleArray)); 
     assertTrue(ArrayUtils.isNotEmpty(notEmptyDoubleArray)); 
     final float[] emptyFloatArray = new float[] {}; 
     final float[] notEmptyFloatArray = new float[] { 1.0F }; 
     assertFalse(ArrayUtils.isNotEmpty((float[]) null)); 
     assertFalse(ArrayUtils.isNotEmpty(emptyFloatArray)); 
     assertTrue(ArrayUtils.isNotEmpty(notEmptyFloatArray)); 
     final boolean[] emptyBooleanArray = new boolean[] {}; 
     final boolean[] notEmptyBooleanArray = new boolean[] { true }; 
     assertFalse(ArrayUtils.isNotEmpty((boolean[]) null)); 
     assertFalse(ArrayUtils.isNotEmpty(emptyBooleanArray)); 
     assertTrue(ArrayUtils.isNotEmpty(notEmptyBooleanArray)); 
 }
@Test
public void testToPrimitive_long_long6183() { 
     final Long[] l = null; 
     assertEquals(null, ArrayUtils.toPrimitive(l, Long.MIN_VALUE)); 
     assertSame(ArrayUtils.EMPTY_LONG_ARRAY, ArrayUtils.toPrimitive(new Long[0], 1)); 
     assertTrue(Arrays.equals(new long[] { Long.MIN_VALUE, Long.MAX_VALUE, 9999999 }, ArrayUtils.toPrimitive(new Long[] { Long.valueOf(Long.MIN_VALUE), Long.valueOf(Long.MAX_VALUE), Long.valueOf(9999999) }, 1))); 
     assertTrue(Arrays.equals(new long[] { Long.MIN_VALUE, Long.MAX_VALUE, 9999999 }, ArrayUtils.toPrimitive(new Long[] { Long.valueOf(Long.MIN_VALUE), null, Long.valueOf(9999999) }, Long.MAX_VALUE))); 
 }
@Test
public void testSubarrayShort6191() { 
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
public void testLastIndexOfWithStartIndex6196() { 
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
public void testToPrimitive_char6203() { 
     final Character[] b = null; 
     assertEquals(null, ArrayUtils.toPrimitive(b)); 
     assertSame(ArrayUtils.EMPTY_CHAR_ARRAY, ArrayUtils.toPrimitive(new Character[0])); 
     assertTrue(Arrays.equals(new char[] { Character.MIN_VALUE, Character.MAX_VALUE, '0' }, ArrayUtils.toPrimitive(new Character[] { new Character(Character.MIN_VALUE), new Character(Character.MAX_VALUE), new Character('0') }))); 
     try { 
         ArrayUtils.toPrimitive(new Character[] { new Character(Character.MIN_VALUE), null }); 
         fail(); 
     } catch (final NullPointerException ex) { 
     } 
 }
@Test
public void testToString6230() { 
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
public void testReverseFloat6241() { 
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
public void testNullToEmptyCharObject6254() { 
     assertArrayEquals(ArrayUtils.EMPTY_CHARACTER_OBJECT_ARRAY, ArrayUtils.nullToEmpty((Character[]) null)); 
     final Character[] original = new Character[] { 'a', 'b' }; 
     assertArrayEquals(original, ArrayUtils.nullToEmpty(original)); 
     final Character[] empty = new Character[] {}; 
     final Character[] result = ArrayUtils.nullToEmpty(empty); 
     assertArrayEquals(ArrayUtils.EMPTY_CHARACTER_OBJECT_ARRAY, result); 
     assertTrue(empty != result); 
 }
@Test
public void testToString6265() { 
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
public void testLastIndexOfWithStartIndex6282() { 
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
public void testIndexOfWithStartIndex6291() { 
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
public void testLastIndexOfCharWithStartIndex6303() { 
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
public void testContainsShort6325() { 
     short[] array = null; 
     assertFalse(ArrayUtils.contains(array, (short) 1)); 
     array = new short[] { 0, 1, 2, 3, 0 }; 
     assertTrue(ArrayUtils.contains(array, (short) 0)); 
     assertTrue(ArrayUtils.contains(array, (short) 1)); 
     assertTrue(ArrayUtils.contains(array, (short) 2)); 
     assertTrue(ArrayUtils.contains(array, (short) 3)); 
     assertFalse(ArrayUtils.contains(array, (short) 99)); 
 }
@Test
public void testToPrimitive_float_float6340() { 
     final Float[] l = null; 
     assertEquals(null, ArrayUtils.toPrimitive(l, Float.MIN_VALUE)); 
     assertSame(ArrayUtils.EMPTY_FLOAT_ARRAY, ArrayUtils.toPrimitive(new Float[0], 1)); 
     assertTrue(Arrays.equals(new float[] { Float.MIN_VALUE, Float.MAX_VALUE, 9999999 }, ArrayUtils.toPrimitive(new Float[] { Float.valueOf(Float.MIN_VALUE), Float.valueOf(Float.MAX_VALUE), Float.valueOf(9999999) }, 1))); 
     assertTrue(Arrays.equals(new float[] { Float.MIN_VALUE, Float.MAX_VALUE, 9999999 }, ArrayUtils.toPrimitive(new Float[] { Float.valueOf(Float.MIN_VALUE), null, Float.valueOf(9999999) }, Float.MAX_VALUE))); 
 }
@Test
public void testToPrimitive_char_char6359() { 
     final Character[] b = null; 
     assertEquals(null, ArrayUtils.toPrimitive(b, Character.MIN_VALUE)); 
     assertSame(ArrayUtils.EMPTY_CHAR_ARRAY, ArrayUtils.toPrimitive(new Character[0], (char) 0)); 
     assertTrue(Arrays.equals(new char[] { Character.MIN_VALUE, Character.MAX_VALUE, '0' }, ArrayUtils.toPrimitive(new Character[] { new Character(Character.MIN_VALUE), new Character(Character.MAX_VALUE), new Character('0') }, Character.MIN_VALUE))); 
     assertTrue(Arrays.equals(new char[] { Character.MIN_VALUE, Character.MAX_VALUE, '0' }, ArrayUtils.toPrimitive(new Character[] { new Character(Character.MIN_VALUE), null, new Character('0') }, Character.MAX_VALUE))); 
 }
@Test
public void testReverseShort6361() { 
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
public void testToPrimitive_double6370() { 
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
public void testReverseInt6382() { 
     int[] array = new int[] { 1, 2, 3 }; 
     ArrayUtils.reverse(array); 
     assertEquals(array[0], 3); 
     assertEquals(array[1], 2); 
     assertEquals(array[2], 1); 
     array = null; 
     ArrayUtils.reverse(array); 
     assertEquals(null, array); 
 }
@Test
public void testContainsChar6394() { 
     char[] array = null; 
     assertFalse(ArrayUtils.contains(array, 'b')); 
     array = new char[] { 'a', 'b', 'c', 'd', 'a' }; 
     assertTrue(ArrayUtils.contains(array, 'a')); 
     assertTrue(ArrayUtils.contains(array, 'b')); 
     assertTrue(ArrayUtils.contains(array, 'c')); 
     assertTrue(ArrayUtils.contains(array, 'd')); 
     assertFalse(ArrayUtils.contains(array, 'e')); 
 }
@Test
public void testToPrimitive_short_short6400() { 
     final Short[] s = null; 
     assertEquals(null, ArrayUtils.toPrimitive(s, Short.MIN_VALUE)); 
     assertSame(ArrayUtils.EMPTY_SHORT_ARRAY, ArrayUtils.toPrimitive(new Short[0], Short.MIN_VALUE)); 
     assertTrue(Arrays.equals(new short[] { Short.MIN_VALUE, Short.MAX_VALUE, (short) 9999999 }, ArrayUtils.toPrimitive(new Short[] { Short.valueOf(Short.MIN_VALUE), Short.valueOf(Short.MAX_VALUE), Short.valueOf((short) 9999999) }, Short.MIN_VALUE))); 
     assertTrue(Arrays.equals(new short[] { Short.MIN_VALUE, Short.MAX_VALUE, (short) 9999999 }, ArrayUtils.toPrimitive(new Short[] { Short.valueOf(Short.MIN_VALUE), null, Short.valueOf((short) 9999999) }, Short.MAX_VALUE))); 
 }
@Test
public void testLastIndexOfByteWithStartIndex6425() { 
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
public void testSubarrayFloat6440() { 
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
public void testReverseShort6442() { 
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
public void testToObject_int6478() { 
     final int[] b = null; 
     assertArrayEquals(null, ArrayUtils.toObject(b)); 
     assertSame(ArrayUtils.EMPTY_INTEGER_OBJECT_ARRAY, ArrayUtils.toObject(new int[0])); 
     assertTrue(Arrays.equals(new Integer[] { Integer.valueOf(Integer.MIN_VALUE), Integer.valueOf(Integer.MAX_VALUE), Integer.valueOf(9999999) }, ArrayUtils.toObject(new int[] { Integer.MIN_VALUE, Integer.MAX_VALUE, 9999999 }))); 
 }
@Test
public void testToPrimitive_byte_byte6497() { 
     final Byte[] b = null; 
     assertEquals(null, ArrayUtils.toPrimitive(b, Byte.MIN_VALUE)); 
     assertSame(ArrayUtils.EMPTY_BYTE_ARRAY, ArrayUtils.toPrimitive(new Byte[0], (byte) 1)); 
     assertTrue(Arrays.equals(new byte[] { Byte.MIN_VALUE, Byte.MAX_VALUE, (byte) 9999999 }, ArrayUtils.toPrimitive(new Byte[] { Byte.valueOf(Byte.MIN_VALUE), Byte.valueOf(Byte.MAX_VALUE), Byte.valueOf((byte) 9999999) }, Byte.MIN_VALUE))); 
     assertTrue(Arrays.equals(new byte[] { Byte.MIN_VALUE, Byte.MAX_VALUE, (byte) 9999999 }, ArrayUtils.toPrimitive(new Byte[] { Byte.valueOf(Byte.MIN_VALUE), null, Byte.valueOf((byte) 9999999) }, Byte.MAX_VALUE))); 
 }
@Test
public void testSameLengthFloat6498() { 
     final float[] nullArray = null; 
     final float[] emptyArray = new float[0]; 
     final float[] oneArray = new float[] { 2.5f }; 
     final float[] twoArray = new float[] { 6.4f, 5.8f }; 
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
public void testSubarrayBoolean6514() { 
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
public void testToPrimitive_double_double6551() { 
     final Double[] l = null; 
     assertEquals(null, ArrayUtils.toPrimitive(l, Double.MIN_VALUE)); 
     assertSame(ArrayUtils.EMPTY_DOUBLE_ARRAY, ArrayUtils.toPrimitive(new Double[0], 1)); 
     assertTrue(Arrays.equals(new double[] { Double.MIN_VALUE, Double.MAX_VALUE, 9999999 }, ArrayUtils.toPrimitive(new Double[] { Double.valueOf(Double.MIN_VALUE), Double.valueOf(Double.MAX_VALUE), Double.valueOf(9999999) }, 1))); 
     assertTrue(Arrays.equals(new double[] { Double.MIN_VALUE, Double.MAX_VALUE, 9999999 }, ArrayUtils.toPrimitive(new Double[] { Double.valueOf(Double.MIN_VALUE), null, Double.valueOf(9999999) }, Double.MAX_VALUE))); 
 }
@Test
public void testContainsByte6557() { 
     byte[] array = null; 
     assertFalse(ArrayUtils.contains(array, (byte) 1)); 
     array = new byte[] { 0, 1, 2, 3, 0 }; 
     assertTrue(ArrayUtils.contains(array, (byte) 0)); 
     assertTrue(ArrayUtils.contains(array, (byte) 1)); 
     assertTrue(ArrayUtils.contains(array, (byte) 2)); 
     assertTrue(ArrayUtils.contains(array, (byte) 3)); 
     assertFalse(ArrayUtils.contains(array, (byte) 99)); 
 }
@Test
public void testToPrimitive_short6558() { 
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
public void testIndexOfIntWithStartIndex6563() { 
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
public void testLastIndexOfInt6592() { 
     int[] array = null; 
     assertEquals(-1, ArrayUtils.lastIndexOf(array, 0)); 
     array = new int[] { 0, 1, 2, 3, 0 }; 
     assertEquals(4, ArrayUtils.lastIndexOf(array, 0)); 
     assertEquals(1, ArrayUtils.lastIndexOf(array, 1)); 
     assertEquals(2, ArrayUtils.lastIndexOf(array, 2)); 
     assertEquals(3, ArrayUtils.lastIndexOf(array, 3)); 
     assertEquals(-1, ArrayUtils.lastIndexOf(array, 99)); 
 }
@Test
public void testReverseFloat6601() { 
     float[] array = new float[] { 0.3f, 0.4f, 0.5f }; 
     ArrayUtils.reverse(array); 
     assertEquals(array[0], 0.5f, 0.0f); 
     assertEquals(array[1], 0.4f, 0.0f); 
     assertEquals(array[2], 0.3f, 0.0f); 
     array = null; 
     ArrayUtils.reverse(array); 
     assertEquals(null, array); 
 } 
@SuppressWarnings("cast")
@Test
public void testLastIndexOfDoubleWithStartIndexTolerance6610() { 
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
public void testLastIndexOfDoubleWithStartIndexTolerance6621() { 
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
@Test
public void testToString6626() { 
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
@SuppressWarnings("cast")
@Test
public void testLastIndexOfDoubleWithStartIndexTolerance6660() { 
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
@Test
public void testSubarrayByte6664() { 
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
public void testNullToEmptyShort6668() { 
     assertEquals(ArrayUtils.EMPTY_SHORT_ARRAY, ArrayUtils.nullToEmpty((short[]) null)); 
     final short[] original = new short[] { 1, 2 }; 
     assertEquals(original, ArrayUtils.nullToEmpty(original)); 
     final short[] empty = new short[] {}; 
     final short[] result = ArrayUtils.nullToEmpty(empty); 
     assertEquals(ArrayUtils.EMPTY_SHORT_ARRAY, result); 
     assertTrue(empty != result); 
 }
@Test
public void testIndexOfCharWithStartIndex6676() { 
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
public void testSameLengthLong6702() { 
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
public void testIsEmptyPrimitives6713() { 
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
@SuppressWarnings("cast")
@Test
public void testLastIndexOfFloatWithStartIndex6717() { 
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
@Test
public void testToObject_char6748() { 
     final char[] b = null; 
     assertArrayEquals(null, ArrayUtils.toObject(b)); 
     assertSame(ArrayUtils.EMPTY_CHARACTER_OBJECT_ARRAY, ArrayUtils.toObject(new char[0])); 
     assertTrue(Arrays.equals(new Character[] { new Character(Character.MIN_VALUE), new Character(Character.MAX_VALUE), new Character('0') }, ArrayUtils.toObject(new char[] { Character.MIN_VALUE, Character.MAX_VALUE, '0' }))); 
 }
@Test
public void testToPrimitive_long6765() { 
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
public void testReverseBoolean6768() { 
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
public void testIndexOfIntWithStartIndex6777() { 
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
public void testLastIndexOfCharWithStartIndex6782() { 
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
public void testToPrimitive_int_int6786() { 
     final Long[] l = null; 
     assertEquals(null, ArrayUtils.toPrimitive(l, Integer.MIN_VALUE)); 
     assertSame(ArrayUtils.EMPTY_INT_ARRAY, ArrayUtils.toPrimitive(new Integer[0], 1)); 
     assertTrue(Arrays.equals(new int[] { Integer.MIN_VALUE, Integer.MAX_VALUE, 9999999 }, ArrayUtils.toPrimitive(new Integer[] { Integer.valueOf(Integer.MIN_VALUE), Integer.valueOf(Integer.MAX_VALUE), Integer.valueOf(9999999) }, 1))); 
     assertTrue(Arrays.equals(new int[] { Integer.MIN_VALUE, Integer.MAX_VALUE, 9999999 }, ArrayUtils.toPrimitive(new Integer[] { Integer.valueOf(Integer.MIN_VALUE), null, Integer.valueOf(9999999) }, Integer.MAX_VALUE))); 
 }
@Test
public void testNullToEmptyDouble6810() { 
     assertEquals(ArrayUtils.EMPTY_DOUBLE_ARRAY, ArrayUtils.nullToEmpty((double[]) null)); 
     final double[] original = new double[] { 1L, 2L }; 
     assertEquals(original, ArrayUtils.nullToEmpty(original)); 
     final double[] empty = new double[] {}; 
     final double[] result = ArrayUtils.nullToEmpty(empty); 
     assertEquals(ArrayUtils.EMPTY_DOUBLE_ARRAY, result); 
     assertTrue(empty != result); 
 }
@Test
public void testToObject_char6811() { 
     final char[] b = null; 
     assertArrayEquals(null, ArrayUtils.toObject(b)); 
     assertSame(ArrayUtils.EMPTY_CHARACTER_OBJECT_ARRAY, ArrayUtils.toObject(new char[0])); 
     assertTrue(Arrays.equals(new Character[] { new Character(Character.MIN_VALUE), new Character(Character.MAX_VALUE), new Character('0') }, ArrayUtils.toObject(new char[] { Character.MIN_VALUE, Character.MAX_VALUE, '0' }))); 
 }
@Test
public void testReverse6815() { 
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
public void testLastIndexOfCharWithStartIndex6822() { 
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
public void testSubarrChar6823() { 
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
public void testNullToEmptyIntObject6825() { 
     assertArrayEquals(ArrayUtils.EMPTY_INTEGER_OBJECT_ARRAY, ArrayUtils.nullToEmpty((Integer[]) null)); 
     final Integer[] original = new Integer[] { 1, 2 }; 
     assertArrayEquals(original, ArrayUtils.nullToEmpty(original)); 
     final Integer[] empty = new Integer[] {}; 
     final Integer[] result = ArrayUtils.nullToEmpty(empty); 
     assertArrayEquals(ArrayUtils.EMPTY_INTEGER_OBJECT_ARRAY, result); 
     assertTrue(empty != result); 
 }
@Test
public void testSubarrayFloat6840() { 
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
public void testArrayCreationWithDifferentTypes6846() { 
     final Number[] array = ArrayUtils.<Number>toArray(Integer.valueOf(42), Double.valueOf(Math.PI)); 
     assertEquals(2, array.length); 
     assertEquals(Integer.valueOf(42), array[0]); 
     assertEquals(Double.valueOf(Math.PI), array[1]); 
 }
@Test
public void testSubarrayByte6867() { 
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
public void testIsNotEmptyPrimitives6875() { 
     final long[] emptyLongArray = new long[] {}; 
     final long[] notEmptyLongArray = new long[] { 1L }; 
     assertFalse(ArrayUtils.isNotEmpty((long[]) null)); 
     assertFalse(ArrayUtils.isNotEmpty(emptyLongArray)); 
     assertTrue(ArrayUtils.isNotEmpty(notEmptyLongArray)); 
     final int[] emptyIntArray = new int[] {}; 
     final int[] notEmptyIntArray = new int[] { 1 }; 
     assertFalse(ArrayUtils.isNotEmpty((int[]) null)); 
     assertFalse(ArrayUtils.isNotEmpty(emptyIntArray)); 
     assertTrue(ArrayUtils.isNotEmpty(notEmptyIntArray)); 
     final short[] emptyShortArray = new short[] {}; 
     final short[] notEmptyShortArray = new short[] { 1 }; 
     assertFalse(ArrayUtils.isNotEmpty((short[]) null)); 
     assertFalse(ArrayUtils.isNotEmpty(emptyShortArray)); 
     assertTrue(ArrayUtils.isNotEmpty(notEmptyShortArray)); 
     final char[] emptyCharArray = new char[] {}; 
     final char[] notEmptyCharArray = new char[] { 1 }; 
     assertFalse(ArrayUtils.isNotEmpty((char[]) null)); 
     assertFalse(ArrayUtils.isNotEmpty(emptyCharArray)); 
     assertTrue(ArrayUtils.isNotEmpty(notEmptyCharArray)); 
     final byte[] emptyByteArray = new byte[] {}; 
     final byte[] notEmptyByteArray = new byte[] { 1 }; 
     assertFalse(ArrayUtils.isNotEmpty((byte[]) null)); 
     assertFalse(ArrayUtils.isNotEmpty(emptyByteArray)); 
     assertTrue(ArrayUtils.isNotEmpty(notEmptyByteArray)); 
     final double[] emptyDoubleArray = new double[] {}; 
     final double[] notEmptyDoubleArray = new double[] { 1.0 }; 
     assertFalse(ArrayUtils.isNotEmpty((double[]) null)); 
     assertFalse(ArrayUtils.isNotEmpty(emptyDoubleArray)); 
     assertTrue(ArrayUtils.isNotEmpty(notEmptyDoubleArray)); 
     final float[] emptyFloatArray = new float[] {}; 
     final float[] notEmptyFloatArray = new float[] { 1.0F }; 
     assertFalse(ArrayUtils.isNotEmpty((float[]) null)); 
     assertFalse(ArrayUtils.isNotEmpty(emptyFloatArray)); 
     assertTrue(ArrayUtils.isNotEmpty(notEmptyFloatArray)); 
     final boolean[] emptyBooleanArray = new boolean[] {}; 
     final boolean[] notEmptyBooleanArray = new boolean[] { true }; 
     assertFalse(ArrayUtils.isNotEmpty((boolean[]) null)); 
     assertFalse(ArrayUtils.isNotEmpty(emptyBooleanArray)); 
     assertTrue(ArrayUtils.isNotEmpty(notEmptyBooleanArray)); 
 } 
@SuppressWarnings("cast")
@Test
public void testLastIndexOfFloatWithStartIndex6877() { 
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
@Test
public void testSubarrayShort6922() { 
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
@SuppressWarnings("cast")
@Test
public void testLastIndexOfDoubleWithStartIndex6927() { 
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
@Test
public void testToPrimitive_short_short6940() { 
     final Short[] s = null; 
     assertEquals(null, ArrayUtils.toPrimitive(s, Short.MIN_VALUE)); 
     assertSame(ArrayUtils.EMPTY_SHORT_ARRAY, ArrayUtils.toPrimitive(new Short[0], Short.MIN_VALUE)); 
     assertTrue(Arrays.equals(new short[] { Short.MIN_VALUE, Short.MAX_VALUE, (short) 9999999 }, ArrayUtils.toPrimitive(new Short[] { Short.valueOf(Short.MIN_VALUE), Short.valueOf(Short.MAX_VALUE), Short.valueOf((short) 9999999) }, Short.MIN_VALUE))); 
     assertTrue(Arrays.equals(new short[] { Short.MIN_VALUE, Short.MAX_VALUE, (short) 9999999 }, ArrayUtils.toPrimitive(new Short[] { Short.valueOf(Short.MIN_VALUE), null, Short.valueOf((short) 9999999) }, Short.MAX_VALUE))); 
 }
@Test
public void testToObject_float6950() { 
     final float[] b = null; 
     assertArrayEquals(null, ArrayUtils.toObject(b)); 
     assertSame(ArrayUtils.EMPTY_FLOAT_OBJECT_ARRAY, ArrayUtils.toObject(new float[0])); 
     assertTrue(Arrays.equals(new Float[] { Float.valueOf(Float.MIN_VALUE), Float.valueOf(Float.MAX_VALUE), Float.valueOf(9999999) }, ArrayUtils.toObject(new float[] { Float.MIN_VALUE, Float.MAX_VALUE, 9999999 }))); 
 }
@Test
public void testToPrimitive_boolean6952() { 
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
public void testToPrimitive_short_short6955() { 
     final Short[] s = null; 
     assertEquals(null, ArrayUtils.toPrimitive(s, Short.MIN_VALUE)); 
     assertSame(ArrayUtils.EMPTY_SHORT_ARRAY, ArrayUtils.toPrimitive(new Short[0], Short.MIN_VALUE)); 
     assertTrue(Arrays.equals(new short[] { Short.MIN_VALUE, Short.MAX_VALUE, (short) 9999999 }, ArrayUtils.toPrimitive(new Short[] { Short.valueOf(Short.MIN_VALUE), Short.valueOf(Short.MAX_VALUE), Short.valueOf((short) 9999999) }, Short.MIN_VALUE))); 
     assertTrue(Arrays.equals(new short[] { Short.MIN_VALUE, Short.MAX_VALUE, (short) 9999999 }, ArrayUtils.toPrimitive(new Short[] { Short.valueOf(Short.MIN_VALUE), null, Short.valueOf((short) 9999999) }, Short.MAX_VALUE))); 
 }
@Test
public void testHashCode6991() { 
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
@SuppressWarnings("cast")
@Test
public void testLastIndexOfFloatWithStartIndex7000() { 
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
@Test
public void testToPrimitive_float7004() { 
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
public void testToPrimitive_int7032() { 
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
public void testToString7043() { 
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
public void testNullToEmptyIntObject7045() { 
     assertArrayEquals(ArrayUtils.EMPTY_INTEGER_OBJECT_ARRAY, ArrayUtils.nullToEmpty((Integer[]) null)); 
     final Integer[] original = new Integer[] { 1, 2 }; 
     assertArrayEquals(original, ArrayUtils.nullToEmpty(original)); 
     final Integer[] empty = new Integer[] {}; 
     final Integer[] result = ArrayUtils.nullToEmpty(empty); 
     assertArrayEquals(ArrayUtils.EMPTY_INTEGER_OBJECT_ARRAY, result); 
     assertTrue(empty != result); 
 }
@Test
public void testToPrimitive_double7082() { 
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
public void testReverseInt7092() { 
     int[] array = new int[] { 1, 2, 3 }; 
     ArrayUtils.reverse(array); 
     assertEquals(array[0], 3); 
     assertEquals(array[1], 2); 
     assertEquals(array[2], 1); 
     array = null; 
     ArrayUtils.reverse(array); 
     assertEquals(null, array); 
 }
@Test
public void testReverseBoolean7109() { 
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
public void testToObject_float7110() { 
     final float[] b = null; 
     assertArrayEquals(null, ArrayUtils.toObject(b)); 
     assertSame(ArrayUtils.EMPTY_FLOAT_OBJECT_ARRAY, ArrayUtils.toObject(new float[0])); 
     assertTrue(Arrays.equals(new Float[] { Float.valueOf(Float.MIN_VALUE), Float.valueOf(Float.MAX_VALUE), Float.valueOf(9999999) }, ArrayUtils.toObject(new float[] { Float.MIN_VALUE, Float.MAX_VALUE, 9999999 }))); 
 }
@Test
public void testSubarrayFloat7143() { 
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
public void testNullToEmptyLong7158() { 
     assertEquals(ArrayUtils.EMPTY_LONG_ARRAY, ArrayUtils.nullToEmpty((long[]) null)); 
     final long[] original = new long[] { 1L, 2L }; 
     assertEquals(original, ArrayUtils.nullToEmpty(original)); 
     final long[] empty = new long[] {}; 
     final long[] result = ArrayUtils.nullToEmpty(empty); 
     assertEquals(ArrayUtils.EMPTY_LONG_ARRAY, result); 
     assertTrue(empty != result); 
 }
@Test
public void testToPrimitive_byte7162() { 
     final Byte[] b = null; 
     assertEquals(null, ArrayUtils.toPrimitive(b)); 
     assertSame(ArrayUtils.EMPTY_BYTE_ARRAY, ArrayUtils.toPrimitive(new Byte[0])); 
     assertTrue(Arrays.equals(new byte[] { Byte.MIN_VALUE, Byte.MAX_VALUE, (byte) 9999999 }, ArrayUtils.toPrimitive(new Byte[] { Byte.valueOf(Byte.MIN_VALUE), Byte.valueOf(Byte.MAX_VALUE), Byte.valueOf((byte) 9999999) }))); 
     try { 
         ArrayUtils.toPrimitive(new Byte[] { Byte.valueOf(Byte.MIN_VALUE), null }); 
         fail(); 
     } catch (final NullPointerException ex) { 
     } 
 }
@Test
public void testToPrimitive_float_float7166() { 
     final Float[] l = null; 
     assertEquals(null, ArrayUtils.toPrimitive(l, Float.MIN_VALUE)); 
     assertSame(ArrayUtils.EMPTY_FLOAT_ARRAY, ArrayUtils.toPrimitive(new Float[0], 1)); 
     assertTrue(Arrays.equals(new float[] { Float.MIN_VALUE, Float.MAX_VALUE, 9999999 }, ArrayUtils.toPrimitive(new Float[] { Float.valueOf(Float.MIN_VALUE), Float.valueOf(Float.MAX_VALUE), Float.valueOf(9999999) }, 1))); 
     assertTrue(Arrays.equals(new float[] { Float.MIN_VALUE, Float.MAX_VALUE, 9999999 }, ArrayUtils.toPrimitive(new Float[] { Float.valueOf(Float.MIN_VALUE), null, Float.valueOf(9999999) }, Float.MAX_VALUE))); 
 }
@Test
public void testNullToEmptyString7168() { 
     assertArrayEquals(ArrayUtils.EMPTY_STRING_ARRAY, ArrayUtils.nullToEmpty((String[]) null)); 
     final String[] original = new String[] { "abc", "def" }; 
     assertArrayEquals(original, ArrayUtils.nullToEmpty(original)); 
     final String[] empty = new String[] {}; 
     final String[] result = ArrayUtils.nullToEmpty(empty); 
     assertArrayEquals(ArrayUtils.EMPTY_STRING_ARRAY, result); 
     assertTrue(empty != result); 
 }
@Test
public void testNullToEmptyDoubleObject7188() { 
     assertArrayEquals(ArrayUtils.EMPTY_DOUBLE_OBJECT_ARRAY, ArrayUtils.nullToEmpty((Double[]) null)); 
     final Double[] original = new Double[] { 1D, 2D }; 
     assertArrayEquals(original, ArrayUtils.nullToEmpty(original)); 
     final Double[] empty = new Double[] {}; 
     final Double[] result = ArrayUtils.nullToEmpty(empty); 
     assertArrayEquals(ArrayUtils.EMPTY_DOUBLE_OBJECT_ARRAY, result); 
     assertTrue(empty != result); 
 }
@Test
public void testNullToEmptyInt7189() { 
     assertEquals(ArrayUtils.EMPTY_INT_ARRAY, ArrayUtils.nullToEmpty((int[]) null)); 
     final int[] original = new int[] { 1, 2 }; 
     assertEquals(original, ArrayUtils.nullToEmpty(original)); 
     final int[] empty = new int[] {}; 
     final int[] result = ArrayUtils.nullToEmpty(empty); 
     assertEquals(ArrayUtils.EMPTY_INT_ARRAY, result); 
     assertTrue(empty != result); 
 }
@Test
public void testConstructor7192() { 
     assertNotNull(new ArrayUtils()); 
     final Constructor<?>[] cons = ArrayUtils.class.getDeclaredConstructors(); 
     assertEquals(1, cons.length); 
     assertTrue(Modifier.isPublic(cons[0].getModifiers())); 
     assertTrue(Modifier.isPublic(ArrayUtils.class.getModifiers())); 
     assertFalse(Modifier.isFinal(ArrayUtils.class.getModifiers())); 
 }
@Test
public void testIsNotEmptyPrimitives7200() { 
     final long[] emptyLongArray = new long[] {}; 
     final long[] notEmptyLongArray = new long[] { 1L }; 
     assertFalse(ArrayUtils.isNotEmpty((long[]) null)); 
     assertFalse(ArrayUtils.isNotEmpty(emptyLongArray)); 
     assertTrue(ArrayUtils.isNotEmpty(notEmptyLongArray)); 
     final int[] emptyIntArray = new int[] {}; 
     final int[] notEmptyIntArray = new int[] { 1 }; 
     assertFalse(ArrayUtils.isNotEmpty((int[]) null)); 
     assertFalse(ArrayUtils.isNotEmpty(emptyIntArray)); 
     assertTrue(ArrayUtils.isNotEmpty(notEmptyIntArray)); 
     final short[] emptyShortArray = new short[] {}; 
     final short[] notEmptyShortArray = new short[] { 1 }; 
     assertFalse(ArrayUtils.isNotEmpty((short[]) null)); 
     assertFalse(ArrayUtils.isNotEmpty(emptyShortArray)); 
     assertTrue(ArrayUtils.isNotEmpty(notEmptyShortArray)); 
     final char[] emptyCharArray = new char[] {}; 
     final char[] notEmptyCharArray = new char[] { 1 }; 
     assertFalse(ArrayUtils.isNotEmpty((char[]) null)); 
     assertFalse(ArrayUtils.isNotEmpty(emptyCharArray)); 
     assertTrue(ArrayUtils.isNotEmpty(notEmptyCharArray)); 
     final byte[] emptyByteArray = new byte[] {}; 
     final byte[] notEmptyByteArray = new byte[] { 1 }; 
     assertFalse(ArrayUtils.isNotEmpty((byte[]) null)); 
     assertFalse(ArrayUtils.isNotEmpty(emptyByteArray)); 
     assertTrue(ArrayUtils.isNotEmpty(notEmptyByteArray)); 
     final double[] emptyDoubleArray = new double[] {}; 
     final double[] notEmptyDoubleArray = new double[] { 1.0 }; 
     assertFalse(ArrayUtils.isNotEmpty((double[]) null)); 
     assertFalse(ArrayUtils.isNotEmpty(emptyDoubleArray)); 
     assertTrue(ArrayUtils.isNotEmpty(notEmptyDoubleArray)); 
     final float[] emptyFloatArray = new float[] {}; 
     final float[] notEmptyFloatArray = new float[] { 1.0F }; 
     assertFalse(ArrayUtils.isNotEmpty((float[]) null)); 
     assertFalse(ArrayUtils.isNotEmpty(emptyFloatArray)); 
     assertTrue(ArrayUtils.isNotEmpty(notEmptyFloatArray)); 
     final boolean[] emptyBooleanArray = new boolean[] {}; 
     final boolean[] notEmptyBooleanArray = new boolean[] { true }; 
     assertFalse(ArrayUtils.isNotEmpty((boolean[]) null)); 
     assertFalse(ArrayUtils.isNotEmpty(emptyBooleanArray)); 
     assertTrue(ArrayUtils.isNotEmpty(notEmptyBooleanArray)); 
 }
@Test
public void testSameLengthByte7201() { 
     final byte[] nullArray = null; 
     final byte[] emptyArray = new byte[0]; 
     final byte[] oneArray = new byte[] { 3 }; 
     final byte[] twoArray = new byte[] { 4, 6 }; 
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
public void testIsNotEmptyObject7209() { 
     final Object[] emptyArray = new Object[] {}; 
     final Object[] notEmptyArray = new Object[] { new String("Value") }; 
     assertFalse(ArrayUtils.isNotEmpty((Object[]) null)); 
     assertFalse(ArrayUtils.isNotEmpty(emptyArray)); 
     assertTrue(ArrayUtils.isNotEmpty(notEmptyArray)); 
 }
@Test
public void testToPrimitive_short7212() { 
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
public void testToObject_int7213() { 
     final int[] b = null; 
     assertArrayEquals(null, ArrayUtils.toObject(b)); 
     assertSame(ArrayUtils.EMPTY_INTEGER_OBJECT_ARRAY, ArrayUtils.toObject(new int[0])); 
     assertTrue(Arrays.equals(new Integer[] { Integer.valueOf(Integer.MIN_VALUE), Integer.valueOf(Integer.MAX_VALUE), Integer.valueOf(9999999) }, ArrayUtils.toObject(new int[] { Integer.MIN_VALUE, Integer.MAX_VALUE, 9999999 }))); 
 }
@Test
public void testToString7219() { 
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
public void testReverseLong7259() { 
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
public void testSubarrayBoolean7277() { 
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
public void testToObject_long7285() { 
     final long[] b = null; 
     assertArrayEquals(null, ArrayUtils.toObject(b)); 
     assertSame(ArrayUtils.EMPTY_LONG_OBJECT_ARRAY, ArrayUtils.toObject(new long[0])); 
     assertTrue(Arrays.equals(new Long[] { Long.valueOf(Long.MIN_VALUE), Long.valueOf(Long.MAX_VALUE), Long.valueOf(9999999) }, ArrayUtils.toObject(new long[] { Long.MIN_VALUE, Long.MAX_VALUE, 9999999 }))); 
 }
@Test
public void testToPrimitive_boolean7290() { 
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
public void testLastIndexOfWithStartIndex7293() { 
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
public void testSubarrayByte7294() { 
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
public void testToObject_short7296() { 
     final short[] b = null; 
     assertArrayEquals(null, ArrayUtils.toObject(b)); 
     assertSame(ArrayUtils.EMPTY_SHORT_OBJECT_ARRAY, ArrayUtils.toObject(new short[0])); 
     assertTrue(Arrays.equals(new Short[] { Short.valueOf(Short.MIN_VALUE), Short.valueOf(Short.MAX_VALUE), Short.valueOf((short) 9999999) }, ArrayUtils.toObject(new short[] { Short.MIN_VALUE, Short.MAX_VALUE, (short) 9999999 }))); 
 }
@Test
public void testIsEmptyPrimitives7311() { 
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
public void testLastIndexOfShort7332() { 
     short[] array = null; 
     assertEquals(-1, ArrayUtils.lastIndexOf(array, (short) 0)); 
     array = new short[] { 0, 1, 2, 3, 0 }; 
     assertEquals(4, ArrayUtils.lastIndexOf(array, (short) 0)); 
     assertEquals(1, ArrayUtils.lastIndexOf(array, (short) 1)); 
     assertEquals(2, ArrayUtils.lastIndexOf(array, (short) 2)); 
     assertEquals(3, ArrayUtils.lastIndexOf(array, (short) 3)); 
     assertEquals(-1, ArrayUtils.lastIndexOf(array, (short) 99)); 
 } 
@SuppressWarnings("cast")
@Test
public void testLastIndexOfFloatWithStartIndex7340() { 
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
@Test
public void testToPrimitive_byte_byte7355() { 
     final Byte[] b = null; 
     assertEquals(null, ArrayUtils.toPrimitive(b, Byte.MIN_VALUE)); 
     assertSame(ArrayUtils.EMPTY_BYTE_ARRAY, ArrayUtils.toPrimitive(new Byte[0], (byte) 1)); 
     assertTrue(Arrays.equals(new byte[] { Byte.MIN_VALUE, Byte.MAX_VALUE, (byte) 9999999 }, ArrayUtils.toPrimitive(new Byte[] { Byte.valueOf(Byte.MIN_VALUE), Byte.valueOf(Byte.MAX_VALUE), Byte.valueOf((byte) 9999999) }, Byte.MIN_VALUE))); 
     assertTrue(Arrays.equals(new byte[] { Byte.MIN_VALUE, Byte.MAX_VALUE, (byte) 9999999 }, ArrayUtils.toPrimitive(new Byte[] { Byte.valueOf(Byte.MIN_VALUE), null, Byte.valueOf((byte) 9999999) }, Byte.MAX_VALUE))); 
 }
@Test
public void testSameLengthBoolean7357() { 
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
public void testToPrimitive_float_float7397() { 
     final Float[] l = null; 
     assertEquals(null, ArrayUtils.toPrimitive(l, Float.MIN_VALUE)); 
     assertSame(ArrayUtils.EMPTY_FLOAT_ARRAY, ArrayUtils.toPrimitive(new Float[0], 1)); 
     assertTrue(Arrays.equals(new float[] { Float.MIN_VALUE, Float.MAX_VALUE, 9999999 }, ArrayUtils.toPrimitive(new Float[] { Float.valueOf(Float.MIN_VALUE), Float.valueOf(Float.MAX_VALUE), Float.valueOf(9999999) }, 1))); 
     assertTrue(Arrays.equals(new float[] { Float.MIN_VALUE, Float.MAX_VALUE, 9999999 }, ArrayUtils.toPrimitive(new Float[] { Float.valueOf(Float.MIN_VALUE), null, Float.valueOf(9999999) }, Float.MAX_VALUE))); 
 }
@Test
public void testReverseShort7405() { 
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
public void testToObject_float7415() { 
     final float[] b = null; 
     assertArrayEquals(null, ArrayUtils.toObject(b)); 
     assertSame(ArrayUtils.EMPTY_FLOAT_OBJECT_ARRAY, ArrayUtils.toObject(new float[0])); 
     assertTrue(Arrays.equals(new Float[] { Float.valueOf(Float.MIN_VALUE), Float.valueOf(Float.MAX_VALUE), Float.valueOf(9999999) }, ArrayUtils.toObject(new float[] { Float.MIN_VALUE, Float.MAX_VALUE, 9999999 }))); 
 }
@Test
public void testLastIndexOfLongWithStartIndex7426() { 
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
public void testToObject_boolean7437() { 
     final boolean[] b = null; 
     assertArrayEquals(null, ArrayUtils.toObject(b)); 
     assertSame(ArrayUtils.EMPTY_BOOLEAN_OBJECT_ARRAY, ArrayUtils.toObject(new boolean[0])); 
     assertTrue(Arrays.equals(new Boolean[] { Boolean.TRUE, Boolean.FALSE, Boolean.TRUE }, ArrayUtils.toObject(new boolean[] { true, false, true }))); 
 }
@Test
public void testLastIndexOfCharWithStartIndex7444() { 
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
public void testReverseShort7451() { 
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
public void testIsEmptyPrimitives7466() { 
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
@SuppressWarnings("cast")
@Test
public void testContainsFloat7469() { 
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
public void testToPrimitive_double_double7471() { 
     final Double[] l = null; 
     assertEquals(null, ArrayUtils.toPrimitive(l, Double.MIN_VALUE)); 
     assertSame(ArrayUtils.EMPTY_DOUBLE_ARRAY, ArrayUtils.toPrimitive(new Double[0], 1)); 
     assertTrue(Arrays.equals(new double[] { Double.MIN_VALUE, Double.MAX_VALUE, 9999999 }, ArrayUtils.toPrimitive(new Double[] { Double.valueOf(Double.MIN_VALUE), Double.valueOf(Double.MAX_VALUE), Double.valueOf(9999999) }, 1))); 
     assertTrue(Arrays.equals(new double[] { Double.MIN_VALUE, Double.MAX_VALUE, 9999999 }, ArrayUtils.toPrimitive(new Double[] { Double.valueOf(Double.MIN_VALUE), null, Double.valueOf(9999999) }, Double.MAX_VALUE))); 
 } 
@SuppressWarnings("cast")
@Test
public void testLastIndexOfDoubleWithStartIndexTolerance7489() { 
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
public void testLastIndexOfDoubleWithStartIndexTolerance7497() { 
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
@Test
public void testToPrimitive_int7515() { 
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
public void testToPrimitive_char7516() { 
     final Character[] b = null; 
     assertEquals(null, ArrayUtils.toPrimitive(b)); 
     assertSame(ArrayUtils.EMPTY_CHAR_ARRAY, ArrayUtils.toPrimitive(new Character[0])); 
     assertTrue(Arrays.equals(new char[] { Character.MIN_VALUE, Character.MAX_VALUE, '0' }, ArrayUtils.toPrimitive(new Character[] { new Character(Character.MIN_VALUE), new Character(Character.MAX_VALUE), new Character('0') }))); 
     try { 
         ArrayUtils.toPrimitive(new Character[] { new Character(Character.MIN_VALUE), null }); 
         fail(); 
     } catch (final NullPointerException ex) { 
     } 
 }
@Test
public void testNullToEmptyShortObject7530() { 
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
public void testToObject_float7537() { 
     final float[] b = null; 
     assertArrayEquals(null, ArrayUtils.toObject(b)); 
     assertSame(ArrayUtils.EMPTY_FLOAT_OBJECT_ARRAY, ArrayUtils.toObject(new float[0])); 
     assertTrue(Arrays.equals(new Float[] { Float.valueOf(Float.MIN_VALUE), Float.valueOf(Float.MAX_VALUE), Float.valueOf(9999999) }, ArrayUtils.toObject(new float[] { Float.MIN_VALUE, Float.MAX_VALUE, 9999999 }))); 
 }
@Test
public void testLastIndexOfWithStartIndex7548() { 
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
public void testNullToEmptyLongObject7550() { 
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
public void testToPrimitive_float7563() { 
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
public void testReverseByte7586() { 
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
public void testLastIndexOfCharWithStartIndex7612() { 
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
public void testReverseByte7630() { 
     byte[] array = new byte[] { 2, 3, 4 }; 
     ArrayUtils.reverse(array); 
     assertEquals(array[0], 4); 
     assertEquals(array[1], 3); 
     assertEquals(array[2], 2); 
     array = null; 
     ArrayUtils.reverse(array); 
     assertEquals(null, array); 
 } 
@SuppressWarnings("cast")
@Test
public void testLastIndexOfFloatWithStartIndex7649() { 
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
@Test
public void testToObject_int7650() { 
     final int[] b = null; 
     assertArrayEquals(null, ArrayUtils.toObject(b)); 
     assertSame(ArrayUtils.EMPTY_INTEGER_OBJECT_ARRAY, ArrayUtils.toObject(new int[0])); 
     assertTrue(Arrays.equals(new Integer[] { Integer.valueOf(Integer.MIN_VALUE), Integer.valueOf(Integer.MAX_VALUE), Integer.valueOf(9999999) }, ArrayUtils.toObject(new int[] { Integer.MIN_VALUE, Integer.MAX_VALUE, 9999999 }))); 
 }
@Test
public void testSubarrayBoolean7660() { 
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
public void testReverseInt7667() { 
     int[] array = new int[] { 1, 2, 3 }; 
     ArrayUtils.reverse(array); 
     assertEquals(array[0], 3); 
     assertEquals(array[1], 2); 
     assertEquals(array[2], 1); 
     array = null; 
     ArrayUtils.reverse(array); 
     assertEquals(null, array); 
 }
@Test
public void testToPrimitive_float7689() { 
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
public void testHashCode7694() { 
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
public void testToPrimitive_short_short7697() { 
     final Short[] s = null; 
     assertEquals(null, ArrayUtils.toPrimitive(s, Short.MIN_VALUE)); 
     assertSame(ArrayUtils.EMPTY_SHORT_ARRAY, ArrayUtils.toPrimitive(new Short[0], Short.MIN_VALUE)); 
     assertTrue(Arrays.equals(new short[] { Short.MIN_VALUE, Short.MAX_VALUE, (short) 9999999 }, ArrayUtils.toPrimitive(new Short[] { Short.valueOf(Short.MIN_VALUE), Short.valueOf(Short.MAX_VALUE), Short.valueOf((short) 9999999) }, Short.MIN_VALUE))); 
     assertTrue(Arrays.equals(new short[] { Short.MIN_VALUE, Short.MAX_VALUE, (short) 9999999 }, ArrayUtils.toPrimitive(new Short[] { Short.valueOf(Short.MIN_VALUE), null, Short.valueOf((short) 9999999) }, Short.MAX_VALUE))); 
 }
@Test
public void testLastIndexOfCharWithStartIndex7722() { 
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
public void testSameLengthInt7740() { 
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
public void testToString7746() { 
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
public void testIsEmptyObject7752() { 
     final Object[] emptyArray = new Object[] {}; 
     final Object[] notEmptyArray = new Object[] { new String("Value") }; 
     assertTrue(ArrayUtils.isEmpty((Object[]) null)); 
     assertTrue(ArrayUtils.isEmpty(emptyArray)); 
     assertFalse(ArrayUtils.isEmpty(notEmptyArray)); 
 }
@Test
public void testLastIndexOfShort7764() { 
     short[] array = null; 
     assertEquals(-1, ArrayUtils.lastIndexOf(array, (short) 0)); 
     array = new short[] { 0, 1, 2, 3, 0 }; 
     assertEquals(4, ArrayUtils.lastIndexOf(array, (short) 0)); 
     assertEquals(1, ArrayUtils.lastIndexOf(array, (short) 1)); 
     assertEquals(2, ArrayUtils.lastIndexOf(array, (short) 2)); 
     assertEquals(3, ArrayUtils.lastIndexOf(array, (short) 3)); 
     assertEquals(-1, ArrayUtils.lastIndexOf(array, (short) 99)); 
 }
@Test
public void testSameLengthByte7770() { 
     final byte[] nullArray = null; 
     final byte[] emptyArray = new byte[0]; 
     final byte[] oneArray = new byte[] { 3 }; 
     final byte[] twoArray = new byte[] { 4, 6 }; 
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
public void testToPrimitive_double_double7771() { 
     final Double[] l = null; 
     assertEquals(null, ArrayUtils.toPrimitive(l, Double.MIN_VALUE)); 
     assertSame(ArrayUtils.EMPTY_DOUBLE_ARRAY, ArrayUtils.toPrimitive(new Double[0], 1)); 
     assertTrue(Arrays.equals(new double[] { Double.MIN_VALUE, Double.MAX_VALUE, 9999999 }, ArrayUtils.toPrimitive(new Double[] { Double.valueOf(Double.MIN_VALUE), Double.valueOf(Double.MAX_VALUE), Double.valueOf(9999999) }, 1))); 
     assertTrue(Arrays.equals(new double[] { Double.MIN_VALUE, Double.MAX_VALUE, 9999999 }, ArrayUtils.toPrimitive(new Double[] { Double.valueOf(Double.MIN_VALUE), null, Double.valueOf(9999999) }, Double.MAX_VALUE))); 
 }
@Test
public void testSubarrayInt7775() { 
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
public void testLastIndexOfWithStartIndex7788() { 
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
public void testToObject_char7827() { 
     final char[] b = null; 
     assertArrayEquals(null, ArrayUtils.toObject(b)); 
     assertSame(ArrayUtils.EMPTY_CHARACTER_OBJECT_ARRAY, ArrayUtils.toObject(new char[0])); 
     assertTrue(Arrays.equals(new Character[] { new Character(Character.MIN_VALUE), new Character(Character.MAX_VALUE), new Character('0') }, ArrayUtils.toObject(new char[] { Character.MIN_VALUE, Character.MAX_VALUE, '0' }))); 
 }
@Test
public void testToPrimitive_char_char7835() { 
     final Character[] b = null; 
     assertEquals(null, ArrayUtils.toPrimitive(b, Character.MIN_VALUE)); 
     assertSame(ArrayUtils.EMPTY_CHAR_ARRAY, ArrayUtils.toPrimitive(new Character[0], (char) 0)); 
     assertTrue(Arrays.equals(new char[] { Character.MIN_VALUE, Character.MAX_VALUE, '0' }, ArrayUtils.toPrimitive(new Character[] { new Character(Character.MIN_VALUE), new Character(Character.MAX_VALUE), new Character('0') }, Character.MIN_VALUE))); 
     assertTrue(Arrays.equals(new char[] { Character.MIN_VALUE, Character.MAX_VALUE, '0' }, ArrayUtils.toPrimitive(new Character[] { new Character(Character.MIN_VALUE), null, new Character('0') }, Character.MAX_VALUE))); 
 }
@Test
public void testNullToEmptyLong7837() { 
     assertEquals(ArrayUtils.EMPTY_LONG_ARRAY, ArrayUtils.nullToEmpty((long[]) null)); 
     final long[] original = new long[] { 1L, 2L }; 
     assertEquals(original, ArrayUtils.nullToEmpty(original)); 
     final long[] empty = new long[] {}; 
     final long[] result = ArrayUtils.nullToEmpty(empty); 
     assertEquals(ArrayUtils.EMPTY_LONG_ARRAY, result); 
     assertTrue(empty != result); 
 }
@Test
public void testNullToEmptyLong7849() { 
     assertEquals(ArrayUtils.EMPTY_LONG_ARRAY, ArrayUtils.nullToEmpty((long[]) null)); 
     final long[] original = new long[] { 1L, 2L }; 
     assertEquals(original, ArrayUtils.nullToEmpty(original)); 
     final long[] empty = new long[] {}; 
     final long[] result = ArrayUtils.nullToEmpty(empty); 
     assertEquals(ArrayUtils.EMPTY_LONG_ARRAY, result); 
     assertTrue(empty != result); 
 }
@Test
public void testNullToEmptyCharObject7863() { 
     assertArrayEquals(ArrayUtils.EMPTY_CHARACTER_OBJECT_ARRAY, ArrayUtils.nullToEmpty((Character[]) null)); 
     final Character[] original = new Character[] { 'a', 'b' }; 
     assertArrayEquals(original, ArrayUtils.nullToEmpty(original)); 
     final Character[] empty = new Character[] {}; 
     final Character[] result = ArrayUtils.nullToEmpty(empty); 
     assertArrayEquals(ArrayUtils.EMPTY_CHARACTER_OBJECT_ARRAY, result); 
     assertTrue(empty != result); 
 }
@Test
public void testSameLengthDouble7880() { 
     final double[] nullArray = null; 
     final double[] emptyArray = new double[0]; 
     final double[] oneArray = new double[] { 1.3d }; 
     final double[] twoArray = new double[] { 4.5d, 6.3d }; 
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
public void testIsNotEmptyPrimitives7891() { 
     final long[] emptyLongArray = new long[] {}; 
     final long[] notEmptyLongArray = new long[] { 1L }; 
     assertFalse(ArrayUtils.isNotEmpty((long[]) null)); 
     assertFalse(ArrayUtils.isNotEmpty(emptyLongArray)); 
     assertTrue(ArrayUtils.isNotEmpty(notEmptyLongArray)); 
     final int[] emptyIntArray = new int[] {}; 
     final int[] notEmptyIntArray = new int[] { 1 }; 
     assertFalse(ArrayUtils.isNotEmpty((int[]) null)); 
     assertFalse(ArrayUtils.isNotEmpty(emptyIntArray)); 
     assertTrue(ArrayUtils.isNotEmpty(notEmptyIntArray)); 
     final short[] emptyShortArray = new short[] {}; 
     final short[] notEmptyShortArray = new short[] { 1 }; 
     assertFalse(ArrayUtils.isNotEmpty((short[]) null)); 
     assertFalse(ArrayUtils.isNotEmpty(emptyShortArray)); 
     assertTrue(ArrayUtils.isNotEmpty(notEmptyShortArray)); 
     final char[] emptyCharArray = new char[] {}; 
     final char[] notEmptyCharArray = new char[] { 1 }; 
     assertFalse(ArrayUtils.isNotEmpty((char[]) null)); 
     assertFalse(ArrayUtils.isNotEmpty(emptyCharArray)); 
     assertTrue(ArrayUtils.isNotEmpty(notEmptyCharArray)); 
     final byte[] emptyByteArray = new byte[] {}; 
     final byte[] notEmptyByteArray = new byte[] { 1 }; 
     assertFalse(ArrayUtils.isNotEmpty((byte[]) null)); 
     assertFalse(ArrayUtils.isNotEmpty(emptyByteArray)); 
     assertTrue(ArrayUtils.isNotEmpty(notEmptyByteArray)); 
     final double[] emptyDoubleArray = new double[] {}; 
     final double[] notEmptyDoubleArray = new double[] { 1.0 }; 
     assertFalse(ArrayUtils.isNotEmpty((double[]) null)); 
     assertFalse(ArrayUtils.isNotEmpty(emptyDoubleArray)); 
     assertTrue(ArrayUtils.isNotEmpty(notEmptyDoubleArray)); 
     final float[] emptyFloatArray = new float[] {}; 
     final float[] notEmptyFloatArray = new float[] { 1.0F }; 
     assertFalse(ArrayUtils.isNotEmpty((float[]) null)); 
     assertFalse(ArrayUtils.isNotEmpty(emptyFloatArray)); 
     assertTrue(ArrayUtils.isNotEmpty(notEmptyFloatArray)); 
     final boolean[] emptyBooleanArray = new boolean[] {}; 
     final boolean[] notEmptyBooleanArray = new boolean[] { true }; 
     assertFalse(ArrayUtils.isNotEmpty((boolean[]) null)); 
     assertFalse(ArrayUtils.isNotEmpty(emptyBooleanArray)); 
     assertTrue(ArrayUtils.isNotEmpty(notEmptyBooleanArray)); 
 } 
@SuppressWarnings("cast")
@Test
public void testLastIndexOfDoubleWithStartIndex7893() { 
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
@Test
public void testIndexOfIntWithStartIndex7906() { 
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
public void testLastIndexOfByteWithStartIndex7932() { 
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
public void testSubarrChar7933() { 
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
public void testReverseLong7957() { 
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
public void testLastIndexOfLongWithStartIndex7962() { 
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
public void testToPrimitive_intNull7967() { 
     final Integer[] iArray = null; 
     assertEquals(null, ArrayUtils.toPrimitive(iArray, Integer.MIN_VALUE)); 
 }
@Test
public void testIndexOfChar7968() { 
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
public void testIndexOfCharWithStartIndex7974() { 
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
public void testToPrimitive_long7993() { 
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
public void testSubarrayByte8025() { 
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
public void testLastIndexOfByteWithStartIndex8027() { 
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
public void testToObject_double8033() { 
     final double[] b = null; 
     assertArrayEquals(null, ArrayUtils.toObject(b)); 
     assertSame(ArrayUtils.EMPTY_DOUBLE_OBJECT_ARRAY, ArrayUtils.toObject(new double[0])); 
     assertTrue(Arrays.equals(new Double[] { Double.valueOf(Double.MIN_VALUE), Double.valueOf(Double.MAX_VALUE), Double.valueOf(9999999) }, ArrayUtils.toObject(new double[] { Double.MIN_VALUE, Double.MAX_VALUE, 9999999 }))); 
 }
@Test
public void testToObject_double8038() { 
     final double[] b = null; 
     assertArrayEquals(null, ArrayUtils.toObject(b)); 
     assertSame(ArrayUtils.EMPTY_DOUBLE_OBJECT_ARRAY, ArrayUtils.toObject(new double[0])); 
     assertTrue(Arrays.equals(new Double[] { Double.valueOf(Double.MIN_VALUE), Double.valueOf(Double.MAX_VALUE), Double.valueOf(9999999) }, ArrayUtils.toObject(new double[] { Double.MIN_VALUE, Double.MAX_VALUE, 9999999 }))); 
 }
@Test
public void testToObject_long8046() { 
     final long[] b = null; 
     assertArrayEquals(null, ArrayUtils.toObject(b)); 
     assertSame(ArrayUtils.EMPTY_LONG_OBJECT_ARRAY, ArrayUtils.toObject(new long[0])); 
     assertTrue(Arrays.equals(new Long[] { Long.valueOf(Long.MIN_VALUE), Long.valueOf(Long.MAX_VALUE), Long.valueOf(9999999) }, ArrayUtils.toObject(new long[] { Long.MIN_VALUE, Long.MAX_VALUE, 9999999 }))); 
 }
@Test
public void testToString8052() { 
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
public void testToObject_float8087() { 
     final float[] b = null; 
     assertArrayEquals(null, ArrayUtils.toObject(b)); 
     assertSame(ArrayUtils.EMPTY_FLOAT_OBJECT_ARRAY, ArrayUtils.toObject(new float[0])); 
     assertTrue(Arrays.equals(new Float[] { Float.valueOf(Float.MIN_VALUE), Float.valueOf(Float.MAX_VALUE), Float.valueOf(9999999) }, ArrayUtils.toObject(new float[] { Float.MIN_VALUE, Float.MAX_VALUE, 9999999 }))); 
 }
@Test
public void testToPrimitive_byte8113() { 
     final Byte[] b = null; 
     assertEquals(null, ArrayUtils.toPrimitive(b)); 
     assertSame(ArrayUtils.EMPTY_BYTE_ARRAY, ArrayUtils.toPrimitive(new Byte[0])); 
     assertTrue(Arrays.equals(new byte[] { Byte.MIN_VALUE, Byte.MAX_VALUE, (byte) 9999999 }, ArrayUtils.toPrimitive(new Byte[] { Byte.valueOf(Byte.MIN_VALUE), Byte.valueOf(Byte.MAX_VALUE), Byte.valueOf((byte) 9999999) }))); 
     try { 
         ArrayUtils.toPrimitive(new Byte[] { Byte.valueOf(Byte.MIN_VALUE), null }); 
         fail(); 
     } catch (final NullPointerException ex) { 
     } 
 }
@Test
public void testToPrimitive_long_long8127() { 
     final Long[] l = null; 
     assertEquals(null, ArrayUtils.toPrimitive(l, Long.MIN_VALUE)); 
     assertSame(ArrayUtils.EMPTY_LONG_ARRAY, ArrayUtils.toPrimitive(new Long[0], 1)); 
     assertTrue(Arrays.equals(new long[] { Long.MIN_VALUE, Long.MAX_VALUE, 9999999 }, ArrayUtils.toPrimitive(new Long[] { Long.valueOf(Long.MIN_VALUE), Long.valueOf(Long.MAX_VALUE), Long.valueOf(9999999) }, 1))); 
     assertTrue(Arrays.equals(new long[] { Long.MIN_VALUE, Long.MAX_VALUE, 9999999 }, ArrayUtils.toPrimitive(new Long[] { Long.valueOf(Long.MIN_VALUE), null, Long.valueOf(9999999) }, Long.MAX_VALUE))); 
 }
@Test
public void testSubarrayDouble8136() { 
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
public void testNullToEmptyByte8143() { 
     assertEquals(ArrayUtils.EMPTY_BYTE_ARRAY, ArrayUtils.nullToEmpty((byte[]) null)); 
     final byte[] original = new byte[] { 0x0F, 0x0E }; 
     assertEquals(original, ArrayUtils.nullToEmpty(original)); 
     final byte[] empty = new byte[] {}; 
     final byte[] result = ArrayUtils.nullToEmpty(empty); 
     assertEquals(ArrayUtils.EMPTY_BYTE_ARRAY, result); 
     assertTrue(empty != result); 
 }
@Test
public void testLastIndexOfInt8154() { 
     int[] array = null; 
     assertEquals(-1, ArrayUtils.lastIndexOf(array, 0)); 
     array = new int[] { 0, 1, 2, 3, 0 }; 
     assertEquals(4, ArrayUtils.lastIndexOf(array, 0)); 
     assertEquals(1, ArrayUtils.lastIndexOf(array, 1)); 
     assertEquals(2, ArrayUtils.lastIndexOf(array, 2)); 
     assertEquals(3, ArrayUtils.lastIndexOf(array, 3)); 
     assertEquals(-1, ArrayUtils.lastIndexOf(array, 99)); 
 }
@Test
public void testReverseFloat8156() { 
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
public void testContainsShort8171() { 
     short[] array = null; 
     assertFalse(ArrayUtils.contains(array, (short) 1)); 
     array = new short[] { 0, 1, 2, 3, 0 }; 
     assertTrue(ArrayUtils.contains(array, (short) 0)); 
     assertTrue(ArrayUtils.contains(array, (short) 1)); 
     assertTrue(ArrayUtils.contains(array, (short) 2)); 
     assertTrue(ArrayUtils.contains(array, (short) 3)); 
     assertFalse(ArrayUtils.contains(array, (short) 99)); 
 }
@Test
public void testToPrimitive_boolean_boolean8202() { 
     assertEquals(null, ArrayUtils.toPrimitive(null, false)); 
     assertSame(ArrayUtils.EMPTY_BOOLEAN_ARRAY, ArrayUtils.toPrimitive(new Boolean[0], false)); 
     assertTrue(Arrays.equals(new boolean[] { true, false, true }, ArrayUtils.toPrimitive(new Boolean[] { Boolean.TRUE, Boolean.FALSE, Boolean.TRUE }, false))); 
     assertTrue(Arrays.equals(new boolean[] { true, false, false }, ArrayUtils.toPrimitive(new Boolean[] { Boolean.TRUE, null, Boolean.FALSE }, false))); 
     assertTrue(Arrays.equals(new boolean[] { true, true, false }, ArrayUtils.toPrimitive(new Boolean[] { Boolean.TRUE, null, Boolean.FALSE }, true))); 
 }
@Test
public void testToPrimitive_int8207() { 
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
public void testToObject_short8227() { 
     final short[] b = null; 
     assertArrayEquals(null, ArrayUtils.toObject(b)); 
     assertSame(ArrayUtils.EMPTY_SHORT_OBJECT_ARRAY, ArrayUtils.toObject(new short[0])); 
     assertTrue(Arrays.equals(new Short[] { Short.valueOf(Short.MIN_VALUE), Short.valueOf(Short.MAX_VALUE), Short.valueOf((short) 9999999) }, ArrayUtils.toObject(new short[] { Short.MIN_VALUE, Short.MAX_VALUE, (short) 9999999 }))); 
 }
@Test
public void testSubarrayDouble8238() { 
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
public void testToPrimitive_float_float8249() { 
     final Float[] l = null; 
     assertEquals(null, ArrayUtils.toPrimitive(l, Float.MIN_VALUE)); 
     assertSame(ArrayUtils.EMPTY_FLOAT_ARRAY, ArrayUtils.toPrimitive(new Float[0], 1)); 
     assertTrue(Arrays.equals(new float[] { Float.MIN_VALUE, Float.MAX_VALUE, 9999999 }, ArrayUtils.toPrimitive(new Float[] { Float.valueOf(Float.MIN_VALUE), Float.valueOf(Float.MAX_VALUE), Float.valueOf(9999999) }, 1))); 
     assertTrue(Arrays.equals(new float[] { Float.MIN_VALUE, Float.MAX_VALUE, 9999999 }, ArrayUtils.toPrimitive(new Float[] { Float.valueOf(Float.MIN_VALUE), null, Float.valueOf(9999999) }, Float.MAX_VALUE))); 
 }
@Test
public void testToObject_long8250() { 
     final long[] b = null; 
     assertArrayEquals(null, ArrayUtils.toObject(b)); 
     assertSame(ArrayUtils.EMPTY_LONG_OBJECT_ARRAY, ArrayUtils.toObject(new long[0])); 
     assertTrue(Arrays.equals(new Long[] { Long.valueOf(Long.MIN_VALUE), Long.valueOf(Long.MAX_VALUE), Long.valueOf(9999999) }, ArrayUtils.toObject(new long[] { Long.MIN_VALUE, Long.MAX_VALUE, 9999999 }))); 
 }
@Test
public void testToObject_char8252() { 
     final char[] b = null; 
     assertArrayEquals(null, ArrayUtils.toObject(b)); 
     assertSame(ArrayUtils.EMPTY_CHARACTER_OBJECT_ARRAY, ArrayUtils.toObject(new char[0])); 
     assertTrue(Arrays.equals(new Character[] { new Character(Character.MIN_VALUE), new Character(Character.MAX_VALUE), new Character('0') }, ArrayUtils.toObject(new char[] { Character.MIN_VALUE, Character.MAX_VALUE, '0' }))); 
 }
@Test
public void testToPrimitive_float8257() { 
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
public void testIsNotEmptyPrimitives8275() { 
     final long[] emptyLongArray = new long[] {}; 
     final long[] notEmptyLongArray = new long[] { 1L }; 
     assertFalse(ArrayUtils.isNotEmpty((long[]) null)); 
     assertFalse(ArrayUtils.isNotEmpty(emptyLongArray)); 
     assertTrue(ArrayUtils.isNotEmpty(notEmptyLongArray)); 
     final int[] emptyIntArray = new int[] {}; 
     final int[] notEmptyIntArray = new int[] { 1 }; 
     assertFalse(ArrayUtils.isNotEmpty((int[]) null)); 
     assertFalse(ArrayUtils.isNotEmpty(emptyIntArray)); 
     assertTrue(ArrayUtils.isNotEmpty(notEmptyIntArray)); 
     final short[] emptyShortArray = new short[] {}; 
     final short[] notEmptyShortArray = new short[] { 1 }; 
     assertFalse(ArrayUtils.isNotEmpty((short[]) null)); 
     assertFalse(ArrayUtils.isNotEmpty(emptyShortArray)); 
     assertTrue(ArrayUtils.isNotEmpty(notEmptyShortArray)); 
     final char[] emptyCharArray = new char[] {}; 
     final char[] notEmptyCharArray = new char[] { 1 }; 
     assertFalse(ArrayUtils.isNotEmpty((char[]) null)); 
     assertFalse(ArrayUtils.isNotEmpty(emptyCharArray)); 
     assertTrue(ArrayUtils.isNotEmpty(notEmptyCharArray)); 
     final byte[] emptyByteArray = new byte[] {}; 
     final byte[] notEmptyByteArray = new byte[] { 1 }; 
     assertFalse(ArrayUtils.isNotEmpty((byte[]) null)); 
     assertFalse(ArrayUtils.isNotEmpty(emptyByteArray)); 
     assertTrue(ArrayUtils.isNotEmpty(notEmptyByteArray)); 
     final double[] emptyDoubleArray = new double[] {}; 
     final double[] notEmptyDoubleArray = new double[] { 1.0 }; 
     assertFalse(ArrayUtils.isNotEmpty((double[]) null)); 
     assertFalse(ArrayUtils.isNotEmpty(emptyDoubleArray)); 
     assertTrue(ArrayUtils.isNotEmpty(notEmptyDoubleArray)); 
     final float[] emptyFloatArray = new float[] {}; 
     final float[] notEmptyFloatArray = new float[] { 1.0F }; 
     assertFalse(ArrayUtils.isNotEmpty((float[]) null)); 
     assertFalse(ArrayUtils.isNotEmpty(emptyFloatArray)); 
     assertTrue(ArrayUtils.isNotEmpty(notEmptyFloatArray)); 
     final boolean[] emptyBooleanArray = new boolean[] {}; 
     final boolean[] notEmptyBooleanArray = new boolean[] { true }; 
     assertFalse(ArrayUtils.isNotEmpty((boolean[]) null)); 
     assertFalse(ArrayUtils.isNotEmpty(emptyBooleanArray)); 
     assertTrue(ArrayUtils.isNotEmpty(notEmptyBooleanArray)); 
 }
@Test
public void testToPrimitive_double_double8297() { 
     final Double[] l = null; 
     assertEquals(null, ArrayUtils.toPrimitive(l, Double.MIN_VALUE)); 
     assertSame(ArrayUtils.EMPTY_DOUBLE_ARRAY, ArrayUtils.toPrimitive(new Double[0], 1)); 
     assertTrue(Arrays.equals(new double[] { Double.MIN_VALUE, Double.MAX_VALUE, 9999999 }, ArrayUtils.toPrimitive(new Double[] { Double.valueOf(Double.MIN_VALUE), Double.valueOf(Double.MAX_VALUE), Double.valueOf(9999999) }, 1))); 
     assertTrue(Arrays.equals(new double[] { Double.MIN_VALUE, Double.MAX_VALUE, 9999999 }, ArrayUtils.toPrimitive(new Double[] { Double.valueOf(Double.MIN_VALUE), null, Double.valueOf(9999999) }, Double.MAX_VALUE))); 
 } 
@SuppressWarnings("cast")
@Test
public void testLastIndexOfDoubleWithStartIndexTolerance8306() { 
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
@Test
public void testIsNotEmptyPrimitives8310() { 
     final long[] emptyLongArray = new long[] {}; 
     final long[] notEmptyLongArray = new long[] { 1L }; 
     assertFalse(ArrayUtils.isNotEmpty((long[]) null)); 
     assertFalse(ArrayUtils.isNotEmpty(emptyLongArray)); 
     assertTrue(ArrayUtils.isNotEmpty(notEmptyLongArray)); 
     final int[] emptyIntArray = new int[] {}; 
     final int[] notEmptyIntArray = new int[] { 1 }; 
     assertFalse(ArrayUtils.isNotEmpty((int[]) null)); 
     assertFalse(ArrayUtils.isNotEmpty(emptyIntArray)); 
     assertTrue(ArrayUtils.isNotEmpty(notEmptyIntArray)); 
     final short[] emptyShortArray = new short[] {}; 
     final short[] notEmptyShortArray = new short[] { 1 }; 
     assertFalse(ArrayUtils.isNotEmpty((short[]) null)); 
     assertFalse(ArrayUtils.isNotEmpty(emptyShortArray)); 
     assertTrue(ArrayUtils.isNotEmpty(notEmptyShortArray)); 
     final char[] emptyCharArray = new char[] {}; 
     final char[] notEmptyCharArray = new char[] { 1 }; 
     assertFalse(ArrayUtils.isNotEmpty((char[]) null)); 
     assertFalse(ArrayUtils.isNotEmpty(emptyCharArray)); 
     assertTrue(ArrayUtils.isNotEmpty(notEmptyCharArray)); 
     final byte[] emptyByteArray = new byte[] {}; 
     final byte[] notEmptyByteArray = new byte[] { 1 }; 
     assertFalse(ArrayUtils.isNotEmpty((byte[]) null)); 
     assertFalse(ArrayUtils.isNotEmpty(emptyByteArray)); 
     assertTrue(ArrayUtils.isNotEmpty(notEmptyByteArray)); 
     final double[] emptyDoubleArray = new double[] {}; 
     final double[] notEmptyDoubleArray = new double[] { 1.0 }; 
     assertFalse(ArrayUtils.isNotEmpty((double[]) null)); 
     assertFalse(ArrayUtils.isNotEmpty(emptyDoubleArray)); 
     assertTrue(ArrayUtils.isNotEmpty(notEmptyDoubleArray)); 
     final float[] emptyFloatArray = new float[] {}; 
     final float[] notEmptyFloatArray = new float[] { 1.0F }; 
     assertFalse(ArrayUtils.isNotEmpty((float[]) null)); 
     assertFalse(ArrayUtils.isNotEmpty(emptyFloatArray)); 
     assertTrue(ArrayUtils.isNotEmpty(notEmptyFloatArray)); 
     final boolean[] emptyBooleanArray = new boolean[] {}; 
     final boolean[] notEmptyBooleanArray = new boolean[] { true }; 
     assertFalse(ArrayUtils.isNotEmpty((boolean[]) null)); 
     assertFalse(ArrayUtils.isNotEmpty(emptyBooleanArray)); 
     assertTrue(ArrayUtils.isNotEmpty(notEmptyBooleanArray)); 
 }
@Test
public void testSubarrayFloat8330() { 
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
public void testReverseLong8338() { 
     long[] array = new long[] { 1L, 2L, 3L }; 
     ArrayUtils.reverse(array); 
     assertEquals(array[0], 3L); 
     assertEquals(array[1], 2L); 
     assertEquals(array[2], 1L); 
     array = null; 
     ArrayUtils.reverse(array); 
     assertEquals(null, array); 
 } 
@SuppressWarnings("cast")
@Test
public void testLastIndexOfDoubleWithStartIndex8343() { 
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
@Test
public void testToString8344() { 
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
public void testNullToEmptyChar8365() { 
     assertEquals(ArrayUtils.EMPTY_CHAR_ARRAY, ArrayUtils.nullToEmpty((char[]) null)); 
     final char[] original = new char[] { 'a', 'b' }; 
     assertEquals(original, ArrayUtils.nullToEmpty(original)); 
     final char[] empty = new char[] {}; 
     final char[] result = ArrayUtils.nullToEmpty(empty); 
     assertEquals(ArrayUtils.EMPTY_CHAR_ARRAY, result); 
     assertTrue(empty != result); 
 } 
@SuppressWarnings("cast")
@Test
public void testIndexOfDoubleWithStartIndexTolerance8368() { 
     double[] array = null; 
     assertEquals(-1, ArrayUtils.indexOf(array, (double) 0, 2, (double) 0)); 
     array = new double[0]; 
     assertEquals(-1, ArrayUtils.indexOf(array, (double) 0, 2, (double) 0)); 
     array = new double[] { 0, 1, 2, 3, 0 }; 
     assertEquals(-1, ArrayUtils.indexOf(array, (double) 0, 99, (double) 0.3)); 
     assertEquals(0, ArrayUtils.indexOf(array, (double) 0, 0, (double) 0.3)); 
     assertEquals(4, ArrayUtils.indexOf(array, (double) 0, 3, (double) 0.3)); 
     assertEquals(2, ArrayUtils.indexOf(array, (double) 2.2, 0, (double) 0.35)); 
     assertEquals(3, ArrayUtils.indexOf(array, (double) 4.15, 0, (double) 2.0)); 
     assertEquals(1, ArrayUtils.indexOf(array, (double) 1.00001324, 0, (double) 0.0001)); 
     assertEquals(3, ArrayUtils.indexOf(array, (double) 4.15, -1, (double) 2.0)); 
     assertEquals(1, ArrayUtils.indexOf(array, (double) 1.00001324, -300, (double) 0.0001)); 
 } 
@SuppressWarnings("cast")
@Test
public void testIndexOfDoubleWithStartIndexTolerance8391() { 
     double[] array = null; 
     assertEquals(-1, ArrayUtils.indexOf(array, (double) 0, 2, (double) 0)); 
     array = new double[0]; 
     assertEquals(-1, ArrayUtils.indexOf(array, (double) 0, 2, (double) 0)); 
     array = new double[] { 0, 1, 2, 3, 0 }; 
     assertEquals(-1, ArrayUtils.indexOf(array, (double) 0, 99, (double) 0.3)); 
     assertEquals(0, ArrayUtils.indexOf(array, (double) 0, 0, (double) 0.3)); 
     assertEquals(4, ArrayUtils.indexOf(array, (double) 0, 3, (double) 0.3)); 
     assertEquals(2, ArrayUtils.indexOf(array, (double) 2.2, 0, (double) 0.35)); 
     assertEquals(3, ArrayUtils.indexOf(array, (double) 4.15, 0, (double) 2.0)); 
     assertEquals(1, ArrayUtils.indexOf(array, (double) 1.00001324, 0, (double) 0.0001)); 
     assertEquals(3, ArrayUtils.indexOf(array, (double) 4.15, -1, (double) 2.0)); 
     assertEquals(1, ArrayUtils.indexOf(array, (double) 1.00001324, -300, (double) 0.0001)); 
 }
@Test
public void testReverseFloat8400() { 
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
public void testLastIndexOfLongWithStartIndex8411() { 
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
public void testSubarrayFloat8417() { 
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
public void testToObject_double8423() { 
     final double[] b = null; 
     assertArrayEquals(null, ArrayUtils.toObject(b)); 
     assertSame(ArrayUtils.EMPTY_DOUBLE_OBJECT_ARRAY, ArrayUtils.toObject(new double[0])); 
     assertTrue(Arrays.equals(new Double[] { Double.valueOf(Double.MIN_VALUE), Double.valueOf(Double.MAX_VALUE), Double.valueOf(9999999) }, ArrayUtils.toObject(new double[] { Double.MIN_VALUE, Double.MAX_VALUE, 9999999 }))); 
 }
@Test
public void testReverseByte8424() { 
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
public void testContainsByte8442() { 
     byte[] array = null; 
     assertFalse(ArrayUtils.contains(array, (byte) 1)); 
     array = new byte[] { 0, 1, 2, 3, 0 }; 
     assertTrue(ArrayUtils.contains(array, (byte) 0)); 
     assertTrue(ArrayUtils.contains(array, (byte) 1)); 
     assertTrue(ArrayUtils.contains(array, (byte) 2)); 
     assertTrue(ArrayUtils.contains(array, (byte) 3)); 
     assertFalse(ArrayUtils.contains(array, (byte) 99)); 
 }
@Test
public void testSubarrayInt8451() { 
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
@SuppressWarnings("cast")
@Test
public void testLastIndexOfDoubleTolerance8457() { 
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
@Test
public void testReverseBoolean8461() { 
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
public void testReverseDouble8468() { 
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
public void testSameLengthShort8472() { 
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
public void testToPrimitive_float_float8483() { 
     final Float[] l = null; 
     assertEquals(null, ArrayUtils.toPrimitive(l, Float.MIN_VALUE)); 
     assertSame(ArrayUtils.EMPTY_FLOAT_ARRAY, ArrayUtils.toPrimitive(new Float[0], 1)); 
     assertTrue(Arrays.equals(new float[] { Float.MIN_VALUE, Float.MAX_VALUE, 9999999 }, ArrayUtils.toPrimitive(new Float[] { Float.valueOf(Float.MIN_VALUE), Float.valueOf(Float.MAX_VALUE), Float.valueOf(9999999) }, 1))); 
     assertTrue(Arrays.equals(new float[] { Float.MIN_VALUE, Float.MAX_VALUE, 9999999 }, ArrayUtils.toPrimitive(new Float[] { Float.valueOf(Float.MIN_VALUE), null, Float.valueOf(9999999) }, Float.MAX_VALUE))); 
 }
@Test
public void testToPrimitive_short8485() { 
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
public void testToPrimitive_int8491() { 
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
public void testLastIndexOfByteWithStartIndex8498() { 
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
public void testNullToEmptyInt8506() { 
     assertEquals(ArrayUtils.EMPTY_INT_ARRAY, ArrayUtils.nullToEmpty((int[]) null)); 
     final int[] original = new int[] { 1, 2 }; 
     assertEquals(original, ArrayUtils.nullToEmpty(original)); 
     final int[] empty = new int[] {}; 
     final int[] result = ArrayUtils.nullToEmpty(empty); 
     assertEquals(ArrayUtils.EMPTY_INT_ARRAY, result); 
     assertTrue(empty != result); 
 }
@Test
public void testReverseChar8509() { 
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
public void testNullToEmptyByteObject8545() { 
     assertArrayEquals(ArrayUtils.EMPTY_BYTE_OBJECT_ARRAY, ArrayUtils.nullToEmpty((Byte[]) null)); 
     final Byte[] original = new Byte[] { 0x0F, 0x0E }; 
     assertArrayEquals(original, ArrayUtils.nullToEmpty(original)); 
     final Byte[] empty = new Byte[] {}; 
     final Byte[] result = ArrayUtils.nullToEmpty(empty); 
     assertArrayEquals(ArrayUtils.EMPTY_BYTE_OBJECT_ARRAY, result); 
     assertTrue(empty != result); 
 }
@Test
public void testToObject_float8547() { 
     final float[] b = null; 
     assertArrayEquals(null, ArrayUtils.toObject(b)); 
     assertSame(ArrayUtils.EMPTY_FLOAT_OBJECT_ARRAY, ArrayUtils.toObject(new float[0])); 
     assertTrue(Arrays.equals(new Float[] { Float.valueOf(Float.MIN_VALUE), Float.valueOf(Float.MAX_VALUE), Float.valueOf(9999999) }, ArrayUtils.toObject(new float[] { Float.MIN_VALUE, Float.MAX_VALUE, 9999999 }))); 
 }
@Test
public void testReverseDouble8561() { 
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
public void testToObject_double8601() { 
     final double[] b = null; 
     assertArrayEquals(null, ArrayUtils.toObject(b)); 
     assertSame(ArrayUtils.EMPTY_DOUBLE_OBJECT_ARRAY, ArrayUtils.toObject(new double[0])); 
     assertTrue(Arrays.equals(new Double[] { Double.valueOf(Double.MIN_VALUE), Double.valueOf(Double.MAX_VALUE), Double.valueOf(9999999) }, ArrayUtils.toObject(new double[] { Double.MIN_VALUE, Double.MAX_VALUE, 9999999 }))); 
 }
@Test
public void testSubarrayInt8620() { 
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
public void testReverseDouble8624() { 
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
public void testToPrimitive_double8625() { 
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
public void testSubarrayBoolean8628() { 
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
public void testReverseLong8637() { 
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
public void testLastIndexOfCharWithStartIndex8645() { 
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
public void testToObject_char8658() { 
     final char[] b = null; 
     assertArrayEquals(null, ArrayUtils.toObject(b)); 
     assertSame(ArrayUtils.EMPTY_CHARACTER_OBJECT_ARRAY, ArrayUtils.toObject(new char[0])); 
     assertTrue(Arrays.equals(new Character[] { new Character(Character.MIN_VALUE), new Character(Character.MAX_VALUE), new Character('0') }, ArrayUtils.toObject(new char[] { Character.MIN_VALUE, Character.MAX_VALUE, '0' }))); 
 }
@Test
public void testSubarrayInt8660() { 
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
public void testSubarrayDouble8661() { 
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
public void testReverseFloat8667() { 
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
public void testLastIndexOfWithStartIndex8684() { 
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
public void testReverseByte8689() { 
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
public void testToString8704() { 
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
public void testToPrimitive_double_double8713() { 
     final Double[] l = null; 
     assertEquals(null, ArrayUtils.toPrimitive(l, Double.MIN_VALUE)); 
     assertSame(ArrayUtils.EMPTY_DOUBLE_ARRAY, ArrayUtils.toPrimitive(new Double[0], 1)); 
     assertTrue(Arrays.equals(new double[] { Double.MIN_VALUE, Double.MAX_VALUE, 9999999 }, ArrayUtils.toPrimitive(new Double[] { Double.valueOf(Double.MIN_VALUE), Double.valueOf(Double.MAX_VALUE), Double.valueOf(9999999) }, 1))); 
     assertTrue(Arrays.equals(new double[] { Double.MIN_VALUE, Double.MAX_VALUE, 9999999 }, ArrayUtils.toPrimitive(new Double[] { Double.valueOf(Double.MIN_VALUE), null, Double.valueOf(9999999) }, Double.MAX_VALUE))); 
 }
@Test
public void testSameLengthDouble8717() { 
     final double[] nullArray = null; 
     final double[] emptyArray = new double[0]; 
     final double[] oneArray = new double[] { 1.3d }; 
     final double[] twoArray = new double[] { 4.5d, 6.3d }; 
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
public void testToPrimitive_short_short8726() { 
     final Short[] s = null; 
     assertEquals(null, ArrayUtils.toPrimitive(s, Short.MIN_VALUE)); 
     assertSame(ArrayUtils.EMPTY_SHORT_ARRAY, ArrayUtils.toPrimitive(new Short[0], Short.MIN_VALUE)); 
     assertTrue(Arrays.equals(new short[] { Short.MIN_VALUE, Short.MAX_VALUE, (short) 9999999 }, ArrayUtils.toPrimitive(new Short[] { Short.valueOf(Short.MIN_VALUE), Short.valueOf(Short.MAX_VALUE), Short.valueOf((short) 9999999) }, Short.MIN_VALUE))); 
     assertTrue(Arrays.equals(new short[] { Short.MIN_VALUE, Short.MAX_VALUE, (short) 9999999 }, ArrayUtils.toPrimitive(new Short[] { Short.valueOf(Short.MIN_VALUE), null, Short.valueOf((short) 9999999) }, Short.MAX_VALUE))); 
 }
@Test
public void testSameLengthChar8732() { 
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
public void testToObject_byte8734() { 
     final byte[] b = null; 
     assertArrayEquals(null, ArrayUtils.toObject(b)); 
     assertSame(ArrayUtils.EMPTY_BYTE_OBJECT_ARRAY, ArrayUtils.toObject(new byte[0])); 
     assertTrue(Arrays.equals(new Byte[] { Byte.valueOf(Byte.MIN_VALUE), Byte.valueOf(Byte.MAX_VALUE), Byte.valueOf((byte) 9999999) }, ArrayUtils.toObject(new byte[] { Byte.MIN_VALUE, Byte.MAX_VALUE, (byte) 9999999 }))); 
 }
@Test
public void testIsEmptyPrimitives8743() { 
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
public void testToObject_float8753() { 
     final float[] b = null; 
     assertArrayEquals(null, ArrayUtils.toObject(b)); 
     assertSame(ArrayUtils.EMPTY_FLOAT_OBJECT_ARRAY, ArrayUtils.toObject(new float[0])); 
     assertTrue(Arrays.equals(new Float[] { Float.valueOf(Float.MIN_VALUE), Float.valueOf(Float.MAX_VALUE), Float.valueOf(9999999) }, ArrayUtils.toObject(new float[] { Float.MIN_VALUE, Float.MAX_VALUE, 9999999 }))); 
 }
@Test
public void testNullToEmptyInt8758() { 
     assertEquals(ArrayUtils.EMPTY_INT_ARRAY, ArrayUtils.nullToEmpty((int[]) null)); 
     final int[] original = new int[] { 1, 2 }; 
     assertEquals(original, ArrayUtils.nullToEmpty(original)); 
     final int[] empty = new int[] {}; 
     final int[] result = ArrayUtils.nullToEmpty(empty); 
     assertEquals(ArrayUtils.EMPTY_INT_ARRAY, result); 
     assertTrue(empty != result); 
 }
@Test
public void testSubarrayBoolean8762() { 
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
public void testSubarrayShort8774() { 
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
public void testToPrimitive_boolean8781() { 
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
@SuppressWarnings("cast")
@Test
public void testLastIndexOfDoubleWithStartIndex8801() { 
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
@Test
public void testToPrimitive_byte8815() { 
     final Byte[] b = null; 
     assertEquals(null, ArrayUtils.toPrimitive(b)); 
     assertSame(ArrayUtils.EMPTY_BYTE_ARRAY, ArrayUtils.toPrimitive(new Byte[0])); 
     assertTrue(Arrays.equals(new byte[] { Byte.MIN_VALUE, Byte.MAX_VALUE, (byte) 9999999 }, ArrayUtils.toPrimitive(new Byte[] { Byte.valueOf(Byte.MIN_VALUE), Byte.valueOf(Byte.MAX_VALUE), Byte.valueOf((byte) 9999999) }))); 
     try { 
         ArrayUtils.toPrimitive(new Byte[] { Byte.valueOf(Byte.MIN_VALUE), null }); 
         fail(); 
     } catch (final NullPointerException ex) { 
     } 
 }
@Test
public void testToPrimitive_double_double8816() { 
     final Double[] l = null; 
     assertEquals(null, ArrayUtils.toPrimitive(l, Double.MIN_VALUE)); 
     assertSame(ArrayUtils.EMPTY_DOUBLE_ARRAY, ArrayUtils.toPrimitive(new Double[0], 1)); 
     assertTrue(Arrays.equals(new double[] { Double.MIN_VALUE, Double.MAX_VALUE, 9999999 }, ArrayUtils.toPrimitive(new Double[] { Double.valueOf(Double.MIN_VALUE), Double.valueOf(Double.MAX_VALUE), Double.valueOf(9999999) }, 1))); 
     assertTrue(Arrays.equals(new double[] { Double.MIN_VALUE, Double.MAX_VALUE, 9999999 }, ArrayUtils.toPrimitive(new Double[] { Double.valueOf(Double.MIN_VALUE), null, Double.valueOf(9999999) }, Double.MAX_VALUE))); 
 } 
@SuppressWarnings("cast")
@Test
public void testLastIndexOfDoubleWithStartIndex8827() { 
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
@Test
public void testNullToEmptyShort8832() { 
     assertEquals(ArrayUtils.EMPTY_SHORT_ARRAY, ArrayUtils.nullToEmpty((short[]) null)); 
     final short[] original = new short[] { 1, 2 }; 
     assertEquals(original, ArrayUtils.nullToEmpty(original)); 
     final short[] empty = new short[] {}; 
     final short[] result = ArrayUtils.nullToEmpty(empty); 
     assertEquals(ArrayUtils.EMPTY_SHORT_ARRAY, result); 
     assertTrue(empty != result); 
 }
@Test
public void testLastIndexOfWithStartIndex8844() { 
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
public void testIsEmptyPrimitives8851() { 
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
public void testLastIndexOfWithStartIndex8853() { 
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
@SuppressWarnings("cast")
@Test
public void testIndexOfDouble8859() { 
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
@Test
public void testSameLengthLong8862() { 
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
public void testReverseShort8875() { 
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
public void testToPrimitive_double_double8888() { 
     final Double[] l = null; 
     assertEquals(null, ArrayUtils.toPrimitive(l, Double.MIN_VALUE)); 
     assertSame(ArrayUtils.EMPTY_DOUBLE_ARRAY, ArrayUtils.toPrimitive(new Double[0], 1)); 
     assertTrue(Arrays.equals(new double[] { Double.MIN_VALUE, Double.MAX_VALUE, 9999999 }, ArrayUtils.toPrimitive(new Double[] { Double.valueOf(Double.MIN_VALUE), Double.valueOf(Double.MAX_VALUE), Double.valueOf(9999999) }, 1))); 
     assertTrue(Arrays.equals(new double[] { Double.MIN_VALUE, Double.MAX_VALUE, 9999999 }, ArrayUtils.toPrimitive(new Double[] { Double.valueOf(Double.MIN_VALUE), null, Double.valueOf(9999999) }, Double.MAX_VALUE))); 
 } 
@SuppressWarnings("cast")
@Test
public void testIndexOfDoubleWithStartIndexTolerance8903() { 
     double[] array = null; 
     assertEquals(-1, ArrayUtils.indexOf(array, (double) 0, 2, (double) 0)); 
     array = new double[0]; 
     assertEquals(-1, ArrayUtils.indexOf(array, (double) 0, 2, (double) 0)); 
     array = new double[] { 0, 1, 2, 3, 0 }; 
     assertEquals(-1, ArrayUtils.indexOf(array, (double) 0, 99, (double) 0.3)); 
     assertEquals(0, ArrayUtils.indexOf(array, (double) 0, 0, (double) 0.3)); 
     assertEquals(4, ArrayUtils.indexOf(array, (double) 0, 3, (double) 0.3)); 
     assertEquals(2, ArrayUtils.indexOf(array, (double) 2.2, 0, (double) 0.35)); 
     assertEquals(3, ArrayUtils.indexOf(array, (double) 4.15, 0, (double) 2.0)); 
     assertEquals(1, ArrayUtils.indexOf(array, (double) 1.00001324, 0, (double) 0.0001)); 
     assertEquals(3, ArrayUtils.indexOf(array, (double) 4.15, -1, (double) 2.0)); 
     assertEquals(1, ArrayUtils.indexOf(array, (double) 1.00001324, -300, (double) 0.0001)); 
 }
@Test
public void testReverseChar8910() { 
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
public void testNullToEmptyString8931() { 
     assertArrayEquals(ArrayUtils.EMPTY_STRING_ARRAY, ArrayUtils.nullToEmpty((String[]) null)); 
     final String[] original = new String[] { "abc", "def" }; 
     assertArrayEquals(original, ArrayUtils.nullToEmpty(original)); 
     final String[] empty = new String[] {}; 
     final String[] result = ArrayUtils.nullToEmpty(empty); 
     assertArrayEquals(ArrayUtils.EMPTY_STRING_ARRAY, result); 
     assertTrue(empty != result); 
 }
@Test
public void testSameLengthChar8962() { 
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
public void testNullToEmptyDouble8972() { 
     assertEquals(ArrayUtils.EMPTY_DOUBLE_ARRAY, ArrayUtils.nullToEmpty((double[]) null)); 
     final double[] original = new double[] { 1L, 2L }; 
     assertEquals(original, ArrayUtils.nullToEmpty(original)); 
     final double[] empty = new double[] {}; 
     final double[] result = ArrayUtils.nullToEmpty(empty); 
     assertEquals(ArrayUtils.EMPTY_DOUBLE_ARRAY, result); 
     assertTrue(empty != result); 
 }
@Test
public void testReverseInt8981() { 
     int[] array = new int[] { 1, 2, 3 }; 
     ArrayUtils.reverse(array); 
     assertEquals(array[0], 3); 
     assertEquals(array[1], 2); 
     assertEquals(array[2], 1); 
     array = null; 
     ArrayUtils.reverse(array); 
     assertEquals(null, array); 
 }
@Test
public void testNullToEmptyFloat8983() { 
     assertEquals(ArrayUtils.EMPTY_FLOAT_ARRAY, ArrayUtils.nullToEmpty((float[]) null)); 
     final float[] original = new float[] { 2.6f, 3.8f }; 
     assertEquals(original, ArrayUtils.nullToEmpty(original)); 
     final float[] empty = new float[] {}; 
     final float[] result = ArrayUtils.nullToEmpty(empty); 
     assertEquals(ArrayUtils.EMPTY_FLOAT_ARRAY, result); 
     assertTrue(empty != result); 
 }
@Test
public void testToPrimitive_double8993() { 
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
public void testNullToEmptyDoubleObject8995() { 
     assertArrayEquals(ArrayUtils.EMPTY_DOUBLE_OBJECT_ARRAY, ArrayUtils.nullToEmpty((Double[]) null)); 
     final Double[] original = new Double[] { 1D, 2D }; 
     assertArrayEquals(original, ArrayUtils.nullToEmpty(original)); 
     final Double[] empty = new Double[] {}; 
     final Double[] result = ArrayUtils.nullToEmpty(empty); 
     assertArrayEquals(ArrayUtils.EMPTY_DOUBLE_OBJECT_ARRAY, result); 
     assertTrue(empty != result); 
 } 
@SuppressWarnings("cast")
@Test
public void testLastIndexOfDoubleTolerance8996() { 
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
@Test
public void testSubarrayBoolean8997() { 
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
public void testToPrimitive_int_int9008() { 
     final Long[] l = null; 
     assertEquals(null, ArrayUtils.toPrimitive(l, Integer.MIN_VALUE)); 
     assertSame(ArrayUtils.EMPTY_INT_ARRAY, ArrayUtils.toPrimitive(new Integer[0], 1)); 
     assertTrue(Arrays.equals(new int[] { Integer.MIN_VALUE, Integer.MAX_VALUE, 9999999 }, ArrayUtils.toPrimitive(new Integer[] { Integer.valueOf(Integer.MIN_VALUE), Integer.valueOf(Integer.MAX_VALUE), Integer.valueOf(9999999) }, 1))); 
     assertTrue(Arrays.equals(new int[] { Integer.MIN_VALUE, Integer.MAX_VALUE, 9999999 }, ArrayUtils.toPrimitive(new Integer[] { Integer.valueOf(Integer.MIN_VALUE), null, Integer.valueOf(9999999) }, Integer.MAX_VALUE))); 
 }
@Test
public void testToPrimitive_double_double9021() { 
     final Double[] l = null; 
     assertEquals(null, ArrayUtils.toPrimitive(l, Double.MIN_VALUE)); 
     assertSame(ArrayUtils.EMPTY_DOUBLE_ARRAY, ArrayUtils.toPrimitive(new Double[0], 1)); 
     assertTrue(Arrays.equals(new double[] { Double.MIN_VALUE, Double.MAX_VALUE, 9999999 }, ArrayUtils.toPrimitive(new Double[] { Double.valueOf(Double.MIN_VALUE), Double.valueOf(Double.MAX_VALUE), Double.valueOf(9999999) }, 1))); 
     assertTrue(Arrays.equals(new double[] { Double.MIN_VALUE, Double.MAX_VALUE, 9999999 }, ArrayUtils.toPrimitive(new Double[] { Double.valueOf(Double.MIN_VALUE), null, Double.valueOf(9999999) }, Double.MAX_VALUE))); 
 }
@Test
public void testIsEmptyPrimitives9022() { 
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
public void testContainsByte9037() { 
     byte[] array = null; 
     assertFalse(ArrayUtils.contains(array, (byte) 1)); 
     array = new byte[] { 0, 1, 2, 3, 0 }; 
     assertTrue(ArrayUtils.contains(array, (byte) 0)); 
     assertTrue(ArrayUtils.contains(array, (byte) 1)); 
     assertTrue(ArrayUtils.contains(array, (byte) 2)); 
     assertTrue(ArrayUtils.contains(array, (byte) 3)); 
     assertFalse(ArrayUtils.contains(array, (byte) 99)); 
 }
@Test
public void testReverse9043() { 
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
@SuppressWarnings("cast")
@Test
public void testLastIndexOfDoubleWithStartIndexTolerance9047() { 
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
public void testIndexOfFloat9048() { 
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
public void testLastIndexOfDoubleWithStartIndex9061() { 
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
@Test
public void testSameType9063() { 
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
public void testLastIndexOfCharWithStartIndex9069() { 
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
public void testSubarrayBoolean9072() { 
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
public void testLastIndexOfLong9074() { 
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
public void testToPrimitive_boolean_boolean9078() { 
     assertEquals(null, ArrayUtils.toPrimitive(null, false)); 
     assertSame(ArrayUtils.EMPTY_BOOLEAN_ARRAY, ArrayUtils.toPrimitive(new Boolean[0], false)); 
     assertTrue(Arrays.equals(new boolean[] { true, false, true }, ArrayUtils.toPrimitive(new Boolean[] { Boolean.TRUE, Boolean.FALSE, Boolean.TRUE }, false))); 
     assertTrue(Arrays.equals(new boolean[] { true, false, false }, ArrayUtils.toPrimitive(new Boolean[] { Boolean.TRUE, null, Boolean.FALSE }, false))); 
     assertTrue(Arrays.equals(new boolean[] { true, true, false }, ArrayUtils.toPrimitive(new Boolean[] { Boolean.TRUE, null, Boolean.FALSE }, true))); 
 }
@Test
public void testToPrimitive_short_short9107() { 
     final Short[] s = null; 
     assertEquals(null, ArrayUtils.toPrimitive(s, Short.MIN_VALUE)); 
     assertSame(ArrayUtils.EMPTY_SHORT_ARRAY, ArrayUtils.toPrimitive(new Short[0], Short.MIN_VALUE)); 
     assertTrue(Arrays.equals(new short[] { Short.MIN_VALUE, Short.MAX_VALUE, (short) 9999999 }, ArrayUtils.toPrimitive(new Short[] { Short.valueOf(Short.MIN_VALUE), Short.valueOf(Short.MAX_VALUE), Short.valueOf((short) 9999999) }, Short.MIN_VALUE))); 
     assertTrue(Arrays.equals(new short[] { Short.MIN_VALUE, Short.MAX_VALUE, (short) 9999999 }, ArrayUtils.toPrimitive(new Short[] { Short.valueOf(Short.MIN_VALUE), null, Short.valueOf((short) 9999999) }, Short.MAX_VALUE))); 
 }
@Test
public void testNullToEmptyByteObject9108() { 
     assertArrayEquals(ArrayUtils.EMPTY_BYTE_OBJECT_ARRAY, ArrayUtils.nullToEmpty((Byte[]) null)); 
     final Byte[] original = new Byte[] { 0x0F, 0x0E }; 
     assertArrayEquals(original, ArrayUtils.nullToEmpty(original)); 
     final Byte[] empty = new Byte[] {}; 
     final Byte[] result = ArrayUtils.nullToEmpty(empty); 
     assertArrayEquals(ArrayUtils.EMPTY_BYTE_OBJECT_ARRAY, result); 
     assertTrue(empty != result); 
 }
@Test
public void testLastIndexOfLongWithStartIndex9114() { 
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
public void testReverseFloat9121() { 
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
public void testSubarrayByte9125() { 
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
public void testToString9133() { 
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
public void testToObject_byte9137() { 
     final byte[] b = null; 
     assertArrayEquals(null, ArrayUtils.toObject(b)); 
     assertSame(ArrayUtils.EMPTY_BYTE_OBJECT_ARRAY, ArrayUtils.toObject(new byte[0])); 
     assertTrue(Arrays.equals(new Byte[] { Byte.valueOf(Byte.MIN_VALUE), Byte.valueOf(Byte.MAX_VALUE), Byte.valueOf((byte) 9999999) }, ArrayUtils.toObject(new byte[] { Byte.MIN_VALUE, Byte.MAX_VALUE, (byte) 9999999 }))); 
 }
@Test
public void testToPrimitive_float_float9146() { 
     final Float[] l = null; 
     assertEquals(null, ArrayUtils.toPrimitive(l, Float.MIN_VALUE)); 
     assertSame(ArrayUtils.EMPTY_FLOAT_ARRAY, ArrayUtils.toPrimitive(new Float[0], 1)); 
     assertTrue(Arrays.equals(new float[] { Float.MIN_VALUE, Float.MAX_VALUE, 9999999 }, ArrayUtils.toPrimitive(new Float[] { Float.valueOf(Float.MIN_VALUE), Float.valueOf(Float.MAX_VALUE), Float.valueOf(9999999) }, 1))); 
     assertTrue(Arrays.equals(new float[] { Float.MIN_VALUE, Float.MAX_VALUE, 9999999 }, ArrayUtils.toPrimitive(new Float[] { Float.valueOf(Float.MIN_VALUE), null, Float.valueOf(9999999) }, Float.MAX_VALUE))); 
 }
@Test
public void testReverseBoolean9151() { 
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
public void testLastIndexOfByteWithStartIndex9158() { 
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
public void testSameLengthChar9168() { 
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
public void testReverseDouble9169() { 
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
public void testLastIndexOfWithStartIndex9171() { 
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
public void testSubarrayInt9189() { 
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
public void testToString9196() { 
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
public void testToString9227() { 
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
@SuppressWarnings("cast")
@Test
public void testIndexOfDoubleTolerance9228() { 
     double[] array = null; 
     assertEquals(-1, ArrayUtils.indexOf(array, (double) 0, (double) 0)); 
     array = new double[0]; 
     assertEquals(-1, ArrayUtils.indexOf(array, (double) 0, (double) 0)); 
     array = new double[] { 0, 1, 2, 3, 0 }; 
     assertEquals(0, ArrayUtils.indexOf(array, (double) 0, (double) 0.3)); 
     assertEquals(2, ArrayUtils.indexOf(array, (double) 2.2, (double) 0.35)); 
     assertEquals(3, ArrayUtils.indexOf(array, (double) 4.15, (double) 2.0)); 
     assertEquals(1, ArrayUtils.indexOf(array, (double) 1.00001324, (double) 0.0001)); 
 }
@Test
public void testNullToEmptyByte9234() { 
     assertEquals(ArrayUtils.EMPTY_BYTE_ARRAY, ArrayUtils.nullToEmpty((byte[]) null)); 
     final byte[] original = new byte[] { 0x0F, 0x0E }; 
     assertEquals(original, ArrayUtils.nullToEmpty(original)); 
     final byte[] empty = new byte[] {}; 
     final byte[] result = ArrayUtils.nullToEmpty(empty); 
     assertEquals(ArrayUtils.EMPTY_BYTE_ARRAY, result); 
     assertTrue(empty != result); 
 }
@Test
public void testLastIndexOfInt9256() { 
     int[] array = null; 
     assertEquals(-1, ArrayUtils.lastIndexOf(array, 0)); 
     array = new int[] { 0, 1, 2, 3, 0 }; 
     assertEquals(4, ArrayUtils.lastIndexOf(array, 0)); 
     assertEquals(1, ArrayUtils.lastIndexOf(array, 1)); 
     assertEquals(2, ArrayUtils.lastIndexOf(array, 2)); 
     assertEquals(3, ArrayUtils.lastIndexOf(array, 3)); 
     assertEquals(-1, ArrayUtils.lastIndexOf(array, 99)); 
 }
@Test
public void testSubarrayDouble9262() { 
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
public void testToString9288() { 
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
public void testLastIndexOfWithStartIndex9294() { 
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
public void testReverseDouble9298() { 
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
public void testContainsShort9328() { 
     short[] array = null; 
     assertFalse(ArrayUtils.contains(array, (short) 1)); 
     array = new short[] { 0, 1, 2, 3, 0 }; 
     assertTrue(ArrayUtils.contains(array, (short) 0)); 
     assertTrue(ArrayUtils.contains(array, (short) 1)); 
     assertTrue(ArrayUtils.contains(array, (short) 2)); 
     assertTrue(ArrayUtils.contains(array, (short) 3)); 
     assertFalse(ArrayUtils.contains(array, (short) 99)); 
 }
@Test
public void testLastIndexOfShort9334() { 
     short[] array = null; 
     assertEquals(-1, ArrayUtils.lastIndexOf(array, (short) 0)); 
     array = new short[] { 0, 1, 2, 3, 0 }; 
     assertEquals(4, ArrayUtils.lastIndexOf(array, (short) 0)); 
     assertEquals(1, ArrayUtils.lastIndexOf(array, (short) 1)); 
     assertEquals(2, ArrayUtils.lastIndexOf(array, (short) 2)); 
     assertEquals(3, ArrayUtils.lastIndexOf(array, (short) 3)); 
     assertEquals(-1, ArrayUtils.lastIndexOf(array, (short) 99)); 
 }
@Test
public void testToString9337() { 
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
public void testToPrimitive_char9353() { 
     final Character[] b = null; 
     assertEquals(null, ArrayUtils.toPrimitive(b)); 
     assertSame(ArrayUtils.EMPTY_CHAR_ARRAY, ArrayUtils.toPrimitive(new Character[0])); 
     assertTrue(Arrays.equals(new char[] { Character.MIN_VALUE, Character.MAX_VALUE, '0' }, ArrayUtils.toPrimitive(new Character[] { new Character(Character.MIN_VALUE), new Character(Character.MAX_VALUE), new Character('0') }))); 
     try { 
         ArrayUtils.toPrimitive(new Character[] { new Character(Character.MIN_VALUE), null }); 
         fail(); 
     } catch (final NullPointerException ex) { 
     } 
 }
@Test
public void testLastIndexOfCharWithStartIndex9366() { 
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
public void testToPrimitive_long9374() { 
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
@SuppressWarnings("cast")
@Test
public void testIndexOfDoubleWithStartIndexTolerance9377() { 
     double[] array = null; 
     assertEquals(-1, ArrayUtils.indexOf(array, (double) 0, 2, (double) 0)); 
     array = new double[0]; 
     assertEquals(-1, ArrayUtils.indexOf(array, (double) 0, 2, (double) 0)); 
     array = new double[] { 0, 1, 2, 3, 0 }; 
     assertEquals(-1, ArrayUtils.indexOf(array, (double) 0, 99, (double) 0.3)); 
     assertEquals(0, ArrayUtils.indexOf(array, (double) 0, 0, (double) 0.3)); 
     assertEquals(4, ArrayUtils.indexOf(array, (double) 0, 3, (double) 0.3)); 
     assertEquals(2, ArrayUtils.indexOf(array, (double) 2.2, 0, (double) 0.35)); 
     assertEquals(3, ArrayUtils.indexOf(array, (double) 4.15, 0, (double) 2.0)); 
     assertEquals(1, ArrayUtils.indexOf(array, (double) 1.00001324, 0, (double) 0.0001)); 
     assertEquals(3, ArrayUtils.indexOf(array, (double) 4.15, -1, (double) 2.0)); 
     assertEquals(1, ArrayUtils.indexOf(array, (double) 1.00001324, -300, (double) 0.0001)); 
 }
@Test
public void testToObject_boolean9378() { 
     final boolean[] b = null; 
     assertArrayEquals(null, ArrayUtils.toObject(b)); 
     assertSame(ArrayUtils.EMPTY_BOOLEAN_OBJECT_ARRAY, ArrayUtils.toObject(new boolean[0])); 
     assertTrue(Arrays.equals(new Boolean[] { Boolean.TRUE, Boolean.FALSE, Boolean.TRUE }, ArrayUtils.toObject(new boolean[] { true, false, true }))); 
 }
@Test
public void testLastIndexOfByteWithStartIndex9385() { 
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
public void testNullToEmptyDouble9392() { 
     assertEquals(ArrayUtils.EMPTY_DOUBLE_ARRAY, ArrayUtils.nullToEmpty((double[]) null)); 
     final double[] original = new double[] { 1L, 2L }; 
     assertEquals(original, ArrayUtils.nullToEmpty(original)); 
     final double[] empty = new double[] {}; 
     final double[] result = ArrayUtils.nullToEmpty(empty); 
     assertEquals(ArrayUtils.EMPTY_DOUBLE_ARRAY, result); 
     assertTrue(empty != result); 
 }
@Test
public void testToObject_short9396() { 
     final short[] b = null; 
     assertArrayEquals(null, ArrayUtils.toObject(b)); 
     assertSame(ArrayUtils.EMPTY_SHORT_OBJECT_ARRAY, ArrayUtils.toObject(new short[0])); 
     assertTrue(Arrays.equals(new Short[] { Short.valueOf(Short.MIN_VALUE), Short.valueOf(Short.MAX_VALUE), Short.valueOf((short) 9999999) }, ArrayUtils.toObject(new short[] { Short.MIN_VALUE, Short.MAX_VALUE, (short) 9999999 }))); 
 }
@Test
public void testContainsLong9402() { 
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
public void testReverseLong9403() { 
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
public void testToPrimitive_short9406() { 
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
public void testToObject_int9415() { 
     final int[] b = null; 
     assertArrayEquals(null, ArrayUtils.toObject(b)); 
     assertSame(ArrayUtils.EMPTY_INTEGER_OBJECT_ARRAY, ArrayUtils.toObject(new int[0])); 
     assertTrue(Arrays.equals(new Integer[] { Integer.valueOf(Integer.MIN_VALUE), Integer.valueOf(Integer.MAX_VALUE), Integer.valueOf(9999999) }, ArrayUtils.toObject(new int[] { Integer.MIN_VALUE, Integer.MAX_VALUE, 9999999 }))); 
 } 
@SuppressWarnings("cast")
@Test
public void testLastIndexOfDoubleWithStartIndexTolerance9429() { 
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
@Test
public void testReverseDouble9436() { 
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
public void testToString9470() { 
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
public void testNullToEmptyByte9475() { 
     assertEquals(ArrayUtils.EMPTY_BYTE_ARRAY, ArrayUtils.nullToEmpty((byte[]) null)); 
     final byte[] original = new byte[] { 0x0F, 0x0E }; 
     assertEquals(original, ArrayUtils.nullToEmpty(original)); 
     final byte[] empty = new byte[] {}; 
     final byte[] result = ArrayUtils.nullToEmpty(empty); 
     assertEquals(ArrayUtils.EMPTY_BYTE_ARRAY, result); 
     assertTrue(empty != result); 
 }
@Test
public void testToPrimitive_short_short9516() { 
     final Short[] s = null; 
     assertEquals(null, ArrayUtils.toPrimitive(s, Short.MIN_VALUE)); 
     assertSame(ArrayUtils.EMPTY_SHORT_ARRAY, ArrayUtils.toPrimitive(new Short[0], Short.MIN_VALUE)); 
     assertTrue(Arrays.equals(new short[] { Short.MIN_VALUE, Short.MAX_VALUE, (short) 9999999 }, ArrayUtils.toPrimitive(new Short[] { Short.valueOf(Short.MIN_VALUE), Short.valueOf(Short.MAX_VALUE), Short.valueOf((short) 9999999) }, Short.MIN_VALUE))); 
     assertTrue(Arrays.equals(new short[] { Short.MIN_VALUE, Short.MAX_VALUE, (short) 9999999 }, ArrayUtils.toPrimitive(new Short[] { Short.valueOf(Short.MIN_VALUE), null, Short.valueOf((short) 9999999) }, Short.MAX_VALUE))); 
 }
@Test
public void testSubarrayByte9530() { 
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
public void testLastIndexOfShort9533() { 
     short[] array = null; 
     assertEquals(-1, ArrayUtils.lastIndexOf(array, (short) 0)); 
     array = new short[] { 0, 1, 2, 3, 0 }; 
     assertEquals(4, ArrayUtils.lastIndexOf(array, (short) 0)); 
     assertEquals(1, ArrayUtils.lastIndexOf(array, (short) 1)); 
     assertEquals(2, ArrayUtils.lastIndexOf(array, (short) 2)); 
     assertEquals(3, ArrayUtils.lastIndexOf(array, (short) 3)); 
     assertEquals(-1, ArrayUtils.lastIndexOf(array, (short) 99)); 
 }
@Test
public void testSubarrayDouble9546() { 
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
public void testSubarrayFloat9557() { 
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
public void testLastIndexOfIntWithStartIndex9558() { 
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
public void testToObject_int9559() { 
     final int[] b = null; 
     assertArrayEquals(null, ArrayUtils.toObject(b)); 
     assertSame(ArrayUtils.EMPTY_INTEGER_OBJECT_ARRAY, ArrayUtils.toObject(new int[0])); 
     assertTrue(Arrays.equals(new Integer[] { Integer.valueOf(Integer.MIN_VALUE), Integer.valueOf(Integer.MAX_VALUE), Integer.valueOf(9999999) }, ArrayUtils.toObject(new int[] { Integer.MIN_VALUE, Integer.MAX_VALUE, 9999999 }))); 
 }
@Test
public void testNullToEmptyFloatObject9586() { 
         // Test null handling 
         assertArrayEquals(ArrayUtils.EMPTY_FLOAT_OBJECT_ARRAY, ArrayUtils.nullToEmpty((Float[]) null)); 
         // Test valid array handling 
         final Float[] original = new Float[] {0f, 0f}; 
         assertArrayEquals(original, ArrayUtils.nullToEmpty(original)); 
         // Test empty array handling 
         final Float[] empty = new Float[]{}; 
         final Float[] result = ArrayUtils.nullToEmpty(empty); 
         assertArrayEquals(ArrayUtils.EMPTY_FLOAT_OBJECT_ARRAY, result); 
         assertTrue(empty != result); 
     }
@Test
public void testIndexOfWithStartIndex9614() { 
         final Object[] array = new Object[] { "0", "1", "2", "3", null, "0" }; 
         assertEquals(-1, ArrayUtils.indexOf(null, null, 2)); 
         assertEquals(-1, ArrayUtils.indexOf(null, "0", 2)); 
         assertEquals(0, ArrayUtils.indexOf(array, "0", 2)); 
         assertEquals(1, ArrayUtils.indexOf(array, "1", 2)); 
         assertEquals(2, ArrayUtils.indexOf(array, "2", 2)); 
         assertEquals(-1, ArrayUtils.indexOf(array, "3", 2)); 
         assertEquals(-1, ArrayUtils.indexOf(array, "3", -1)); 
         assertEquals(4, ArrayUtils.indexOf(array, null, 5)); 
         assertEquals(-1, ArrayUtils.indexOf(array, null, 2)); 
         assertEquals(-1, ArrayUtils.indexOf(array, "notInArray", 5)); 
          
         assertEquals(-1, ArrayUtils.indexOf(array, null, -1)); 
         assertEquals(-1, ArrayUtils.indexOf(array, "0", 88)); 
     }
@Test
public void testLastIndexOfBooleanWithStartIndex9693() { 
         boolean[] array = null; 
         assertEquals(-1, ArrayUtils.lastIndexOf(array, true, 2)); 
         array = new boolean[] { true, true, false, true }; 
         assertEquals(0, ArrayUtils.lastIndexOf(array, true, 2)); 
         assertEquals(1, ArrayUtils.lastIndexOf(array, false, 1)); 
         array = new boolean[] { true, true, false, true }; 
         assertEquals(4, ArrayUtils.lastIndexOf(array, true, 2)); 
         assertEquals(-1, ArrayUtils.lastIndexOf(array, false, -1)); 
         assertEquals(-1, ArrayUtils.lastIndexOf(array, false, 88)); 
     }
@Test
public void testNullToEmptyFloatObject10374() { 
         // Test null handling 
         assertArrayEquals(ArrayUtils.EMPTY_FLOAT_OBJECT_ARRAY, ArrayUtils.nullToEmpty((Float[]) null)); 
         // Test valid array handling 
         final Float[] original = new Float[] {Float.valueOf(Float.MIN_VALUE),  
                 Float.valueOf(Float.MAX_VALUE), Float.valueOf(9999999)}; 
         assertArrayEquals(original, ArrayUtils.nullToEmpty(original)); 
         // Test empty array handling 
         final Float[] empty = new Float[]{}; 
         final Float[] result = ArrayUtils.nullToEmpty(empty); 
         assertArrayEquals(ArrayUtils.EMPTY_FLOAT_OBJECT_ARRAY, result); 
         assertTrue(empty != result); 
     }
@Test
public void testNullToEmptyFloatObject10375() { 
         // Test null handling 
         assertArrayEquals(ArrayUtils.EMPTY_FLOAT_OBJECT_ARRAY, ArrayUtils.nullToEmpty((Float[]) null)); 
         // Test valid array handling 
         final Float[] original = new Float[] {Float.valueOf(Float.MIN_VALUE),  
                 Float.valueOf(Float.MAX_VALUE), Float.valueOf(9999999)}; 
         assertArrayEquals(original, ArrayUtils.nullToEmpty(original)); 
         // Test empty array handling 
         final Float[] empty = new Float[]{}; 
         final Float[] result = ArrayUtils.nullToEmpty(empty); 
         assertArrayEquals(ArrayUtils.EMPTY_FLOAT_OBJECT_ARRAY, result); 
         assertTrue(empty != result); 
     }
@Test
public void testNullToEmptyFloatObject10376() { 
         // Test null handling 
         assertArrayEquals(ArrayUtils.EMPTY_FLOAT_OBJECT_ARRAY, ArrayUtils.nullToEmpty((Float[]) null)); 
         // Test valid array handling 
         final Float[] original = new Float[] {Float.valueOf(Float.MIN_VALUE),  
                 Float.valueOf(Float.MAX_VALUE), Float.valueOf(9999999)}; 
         assertArrayEquals(original, ArrayUtils.nullToEmpty(original)); 
         // Test empty array handling 
         final Float[] empty = new Float[]{}; 
         final Float[] result = ArrayUtils.nullToEmpty(empty); 
         assertArrayEquals(ArrayUtils.EMPTY_FLOAT_OBJECT_ARRAY, result); 
         assertTrue(empty != result); 
     }
@Test
public void testToObject_object11008() { 
         final Object[] obj = new Object[] { "0", "1", "2", "3", null, "0" }; 
         final Map<Object, Object> map = ArrayUtils.toMap(obj); 
         assertEquals(3, map.size()); 
         assertEquals("0", map.get("0")); 
         assertEquals("1", map.get("1")); 
         assertEquals("2", map.get("2")); 
         assertEquals(null, map.get("3")); 
     }
@Test
public void testToObject_object11013() { 
         final Object[] b = null; 
         assertEquals(null, ArrayUtils.toMap(b)); 
          
         assertSame(null, ArrayUtils.toMap(new Object[0])); 
          
         assertTrue(Arrays.equals( 
             new HashMap<Object, Object>(), 
             ArrayUtils.toMap(new Object[] {Boolean.TRUE, Boolean.FALSE})) 
         ); 
         assertTrue(Arrays.equals( 
             new HashMap<Object, Object>(), 
             ArrayUtils.toMap(new Object[] {Boolean.TRUE, null, Boolean.FALSE})) 
         ); 
         assertTrue(Arrays.equals( 
             new HashMap<Object, Object>(), 
             ArrayUtils.toMap(new Object[] {Boolean.TRUE, null, Boolean.FALSE})) 
         ); 
     }
@Test
public void testToObject_object11017() { 
         final Object[] obj = new Object[] { "0", "1", "2", "3", null, "0" }; 
         final Map<Object, Object> map = ArrayUtils.toMap(obj); 
         assertEquals(4, map.size()); 
         assertEquals("0", map.get("0")); 
         assertEquals("1", map.get("1")); 
         assertEquals("2", map.get("2")); 
         assertEquals(null, map.get("3")); 
         assertEquals("3", map.get("3")); 
     }
@Test
public void testToObject_object11018() { 
         final Object[] b = null; 
         assertEquals(null, ArrayUtils.toMap(b)); 
          
         assertSame(null, ArrayUtils.toMap(new Object[0])); 
          
         assertTrue(Arrays.equals( 
             new HashMap<Object, Object>(), 
             ArrayUtils.toMap(new Object[] {Boolean.TRUE, Boolean.FALSE})) 
         ); 
         assertTrue(Arrays.equals( 
             new HashMap<Object, Object>(), 
             ArrayUtils.toMap(new Object[] {Boolean.TRUE, null, Boolean.FALSE})) 
         ); 
         assertTrue(Arrays.equals( 
             new HashMap<Object, Object>(), 
             ArrayUtils.toMap(new Object[] {Boolean.TRUE, null, Boolean.FALSE})) 
         ); 
     }
@Test
public void testIndexOfWithStartIndex11252() { 
         final Object[] array = new Object[] { "0", "1", "2", "3", null, "0" }; 
         assertEquals(-1, ArrayUtils.indexOf(null, null, 2)); 
         assertEquals(-1, ArrayUtils.indexOf(null, "0", 2)); 
         assertEquals(0, ArrayUtils.indexOf(array, "0", 2)); 
         assertEquals(1, ArrayUtils.indexOf(array, "1", 2)); 
         assertEquals(2, ArrayUtils.indexOf(array, "2", 2)); 
         assertEquals(-1, ArrayUtils.indexOf(array, "3", 2)); 
         assertEquals(-1, ArrayUtils.indexOf(array, "3", -1)); 
         assertEquals(4, ArrayUtils.indexOf(array, null, 5)); 
         assertEquals(-1, ArrayUtils.indexOf(array, null, 2)); 
         assertEquals(-1, ArrayUtils.indexOf(array, "notInArray", 5)); 
          
         assertEquals(-1, ArrayUtils.indexOf(array, null, -1)); 
         assertEquals(5, ArrayUtils.indexOf(array, "0", 88)); 
     }
@Test
public void testIndexOfWithStartIndex11253() { 
         final Object[] array = new Object[] { "0", "1", "2", "3", null, "0" }; 
         assertEquals(-1, ArrayUtils.indexOf(null, null, 2)); 
         assertEquals(-1, ArrayUtils.indexOf(null, "0", 2)); 
         assertEquals(0, ArrayUtils.indexOf(array, "0", 2)); 
         assertEquals(1, ArrayUtils.indexOf(array, "1", 2)); 
         assertEquals(2, ArrayUtils.indexOf(array, "2", 2)); 
         assertEquals(-1, ArrayUtils.indexOf(array, "3", 2)); 
         assertEquals(-1, ArrayUtils.indexOf(array, "3", -1)); 
         assertEquals(4, ArrayUtils.indexOf(array, null, 5)); 
         assertEquals(-1, ArrayUtils.indexOf(array, null, 2)); 
         assertEquals(-1, ArrayUtils.indexOf(array, "notInArray", 5)); 
          
         assertEquals(-1, ArrayUtils.indexOf(null, null, -1)); 
         assertEquals(-1, ArrayUtils.indexOf(array, "0", 88)); 
     }
@Test
public void testIndexOfWithStartIndex11254() { 
         final Object[] array = new Object[] { "0", "1", "2", "3", null, "0" }; 
         assertEquals(-1, ArrayUtils.indexOf(null, null, 2)); 
         assertEquals(-1, ArrayUtils.indexOf(null, "0", 2)); 
         assertEquals(0, ArrayUtils.indexOf(array, "0", 2)); 
         assertEquals(1, ArrayUtils.indexOf(array, "1", 2)); 
         assertEquals(2, ArrayUtils.indexOf(array, "2", 2)); 
         assertEquals(-1, ArrayUtils.indexOf(array, "3", 2)); 
         assertEquals(-1, ArrayUtils.indexOf(array, "3", -1)); 
         assertEquals(4, ArrayUtils.indexOf(array, null, 5)); 
         assertEquals(-1, ArrayUtils.indexOf(array, null, 2)); 
         assertEquals(-1, ArrayUtils.indexOf(array, "notInArray", 5)); 
          
         assertEquals(-1, ArrayUtils.indexOf(array, null, -1)); 
         assertEquals(5, ArrayUtils.indexOf(array, "0", 88)); 
     }
@Test
public void testIndexOfWithStartIndex11255() { 
         final Object[] array = new Object[] { "0", "1", "2", "3", null, "0" }; 
         assertEquals(-1, ArrayUtils.indexOf(null, null, 2)); 
         assertEquals(-1, ArrayUtils.indexOf(null, "0", 2)); 
         assertEquals(0, ArrayUtils.indexOf(array, "0", 2)); 
         assertEquals(1, ArrayUtils.indexOf(array, "1", 2)); 
         assertEquals(2, ArrayUtils.indexOf(array, "2", 2)); 
         assertEquals(-1, ArrayUtils.indexOf(array, "3", 2)); 
         assertEquals(-1, ArrayUtils.indexOf(array, "3", -1)); 
         assertEquals(4, ArrayUtils.indexOf(array, null, 5)); 
         assertEquals(-1, ArrayUtils.indexOf(array, null, 2)); 
         assertEquals(-1, ArrayUtils.indexOf(array, "notInArray", 5)); 
          
         assertEquals(-1, ArrayUtils.indexOf(array, null, -1)); 
         assertEquals(-1, ArrayUtils.indexOf(array, "0", 88)); 
     }
@Test
@SuppressWarnings("cast") 
     public void testRemoveElementBooleanArray11256() { 
         boolean[] array; 
         array = ArrayUtils.removeElement((boolean[]) null, true); 
         assertNull(array); 
         array = ArrayUtils.removeElement(ArrayUtils.EMPTY_BOOLEAN_ARRAY, true); 
         assertTrue(Arrays.equals(ArrayUtils.EMPTY_BOOLEAN_ARRAY, array)); 
         assertEquals(Boolean.TYPE, array.getClass().getComponentType()); 
         array = ArrayUtils.removeElement(new boolean[] {true}, true); 
         assertTrue(Arrays.equals(ArrayUtils.EMPTY_BOOLEAN_ARRAY, array)); 
         assertEquals(Boolean.TYPE, array.getClass().getComponentType()); 
         array = ArrayUtils.removeElement(new boolean[] {true, false}, true); 
         assertTrue(Arrays.equals(new boolean[] {false}, array)); 
         assertEquals(Boolean.TYPE, array.getClass().getComponentType()); 
         array = ArrayUtils.removeElement(new boolean[] {true, false, true}, true); 
         assertTrue(Arrays.equals(new boolean[] {false, true}, array)); 
         assertEquals(Boolean.TYPE, array.getClass().getComponentType()); 
     }
@Test
public void testIndexOfWithStartIndex11257() { 
         final Object[] array = new Object[] { "0", "1", "2", "3", null, "0" }; 
         assertEquals(-1, ArrayUtils.indexOf(null, null, 2)); 
         assertEquals(-1, ArrayUtils.indexOf(null, "0", 2)); 
         assertEquals(0, ArrayUtils.indexOf(array, "0", 2)); 
         assertEquals(1, ArrayUtils.indexOf(array, "1", 2)); 
         assertEquals(2, ArrayUtils.indexOf(array, "2", 2)); 
         assertEquals(-1, ArrayUtils.indexOf(array, "3", 2)); 
         assertEquals(-1, ArrayUtils.indexOf(array, "3", -1)); 
         assertEquals(4, ArrayUtils.indexOf(array, null, 5)); 
         assertEquals(-1, ArrayUtils.indexOf(array, null, 2)); 
         assertEquals(-1, ArrayUtils.indexOf(array, "notInArray", 5)); 
          
         assertEquals(-1, ArrayUtils.indexOf(array, null, -1)); 
         assertEquals(5, ArrayUtils.indexOf(array, "0", 88)); 
     }
@Test
public void testIndexOfWithStartIndex11258() { 
         final Object[] array = new Object[] { "0", "1", "2", "3", null, "0" }; 
         assertEquals(-1, ArrayUtils.indexOf(null, null, 2)); 
         assertEquals(-1, ArrayUtils.indexOf(null, "0", 2)); 
         assertEquals(0, ArrayUtils.indexOf(array, "0", 2)); 
         assertEquals(1, ArrayUtils.indexOf(array, "1", 2)); 
         assertEquals(2, ArrayUtils.indexOf(array, "2", 2)); 
         assertEquals(-1, ArrayUtils.indexOf(array, "3", 2)); 
         assertEquals(-1, ArrayUtils.indexOf(array, "3", -1)); 
         assertEquals(4, ArrayUtils.indexOf(array, null, 5)); 
         assertEquals(-1, ArrayUtils.indexOf(array, null, 2)); 
         assertEquals(-1, ArrayUtils.indexOf(array, "notInArray", 5)); 
          
         assertEquals(-1, ArrayUtils.indexOf(array, null, -1)); 
         assertEquals(-1, ArrayUtils.indexOf(array, "0", 88)); 
     }
@Test
public void testIndexOfWithStartIndex11259() { 
         final Object[] array = new Object[] { "0", "1", "2", "3", null, "0" }; 
         assertEquals(-1, ArrayUtils.indexOf(null, null, 2)); 
         assertEquals(-1, ArrayUtils.indexOf(null, "0", 2)); 
         assertEquals(0, ArrayUtils.indexOf(array, "0", 2)); 
         assertEquals(1, ArrayUtils.indexOf(array, "1", 2)); 
         assertEquals(2, ArrayUtils.indexOf(array, "2", 2)); 
         assertEquals(-1, ArrayUtils.indexOf(array, "3", 2)); 
         assertEquals(-1, ArrayUtils.indexOf(array, "3", -1)); 
         assertEquals(4, ArrayUtils.indexOf(array, null, 5)); 
         assertEquals(-1, ArrayUtils.indexOf(array, null, 2)); 
         assertEquals(-1, ArrayUtils.indexOf(array, "notInArray", 5)); 
          
         assertEquals(-1, ArrayUtils.indexOf(array, null, -1)); 
         assertEquals(-1, ArrayUtils.indexOf(array, "0", 88)); 
     }
@Test
public void testIndexOfWithStartIndex11260() { 
         final Object[] array = new Object[] { "0", "1", "2", "3", null, "0" }; 
         assertEquals(-1, ArrayUtils.indexOf(null, null, 2)); 
         assertEquals(-1, ArrayUtils.indexOf(null, "0", 2)); 
         assertEquals(0, ArrayUtils.indexOf(array, "0", 2)); 
         assertEquals(1, ArrayUtils.indexOf(array, "1", 2)); 
         assertEquals(2, ArrayUtils.indexOf(array, "2", 2)); 
         assertEquals(-1, ArrayUtils.indexOf(array, "3", 2)); 
         assertEquals(-1, ArrayUtils.indexOf(array, "3", -1)); 
         assertEquals(4, ArrayUtils.indexOf(array, null, 5)); 
         assertEquals(-1, ArrayUtils.indexOf(array, null, 2)); 
         assertEquals(-1, ArrayUtils.indexOf(array, "notInArray", 5)); 
          
         assertEquals(-1, ArrayUtils.indexOf(array, null, -1)); 
         assertEquals(-1, ArrayUtils.indexOf(array, "0", 88)); 
     }
@Test
public void testIndexOfWithStartIndex11261() { 
         final Object[] array = new Object[] { "0", "1", "2", "3", null, "0" }; 
         assertEquals(-1, ArrayUtils.indexOf(null, null, 2)); 
         assertEquals(-1, ArrayUtils.indexOf(null, "0", 2)); 
         assertEquals(0, ArrayUtils.indexOf(array, "0", 2)); 
         assertEquals(1, ArrayUtils.indexOf(array, "1", 2)); 
         assertEquals(2, ArrayUtils.indexOf(array, "2", 2)); 
         assertEquals(-1, ArrayUtils.indexOf(array, "3", 2)); 
         assertEquals(-1, ArrayUtils.indexOf(array, "3", -1)); 
         assertEquals(4, ArrayUtils.indexOf(array, null, 5)); 
         assertEquals(-1, ArrayUtils.indexOf(array, null, 2)); 
         assertEquals(-1, ArrayUtils.indexOf(array, "notInArray", 5)); 
          
         assertEquals(-1, ArrayUtils.indexOf(array, null, -1)); 
         assertEquals(-1, ArrayUtils.indexOf(array, "0", 88)); 
     }
@Test
public void testIndexOfWithStartIndex11262() { 
         final Object[] array = new Object[] { "0", "1", "2", "3", null, "0" }; 
         assertEquals(-1, ArrayUtils.indexOf(null, null, 2)); 
         assertEquals(-1, ArrayUtils.indexOf(null, "0", 2)); 
         assertEquals(0, ArrayUtils.indexOf(array, "0", 2)); 
         assertEquals(1, ArrayUtils.indexOf(array, "1", 2)); 
         assertEquals(2, ArrayUtils.indexOf(array, "2", 2)); 
         assertEquals(-1, ArrayUtils.indexOf(array, "3", 2)); 
         assertEquals(-1, ArrayUtils.indexOf(array, "3", -1)); 
         assertEquals(4, ArrayUtils.indexOf(array, null, 5)); 
         assertEquals(-1, ArrayUtils.indexOf(array, null, 2)); 
         assertEquals(-1, ArrayUtils.indexOf(array, "notInArray", 5)); 
          
         assertEquals(-1, ArrayUtils.indexOf(array, null, -1)); 
         assertEquals(-1, ArrayUtils.indexOf(array, "0", 88)); 
     }
@Test
public void testIndexOfWithStartIndex11263() { 
         final Object[] array = new Object[] { "0", "1", "2", "3", null, "0" }; 
         assertEquals(-1, ArrayUtils.indexOf(null, null, 2)); 
         assertEquals(-1, ArrayUtils.indexOf(null, "0", 2)); 
         assertEquals(0, ArrayUtils.indexOf(array, "0", 2)); 
         assertEquals(1, ArrayUtils.indexOf(array, "1", 2)); 
         assertEquals(2, ArrayUtils.indexOf(array, "2", 2)); 
         assertEquals(-1, ArrayUtils.indexOf(array, "3", 2)); 
         assertEquals(-1, ArrayUtils.indexOf(array, "3", -1)); 
         assertEquals(4, ArrayUtils.indexOf(array, null, 5)); 
         assertEquals(-1, ArrayUtils.indexOf(array, null, 2)); 
         assertEquals(-1, ArrayUtils.indexOf(array, "notInArray", 5)); 
          
         assertEquals(-1, ArrayUtils.indexOf(array, null, -1)); 
         assertEquals(5, ArrayUtils.indexOf(array, "0", 88)); 
     }
@Test
public void testIndexOfWithStartIndex11264() { 
         final Object[] array = new Object[] { "0", "1", "2", "3", null, "0" }; 
         assertEquals(-1, ArrayUtils.indexOf(null, null, 2)); 
         assertEquals(-1, ArrayUtils.indexOf(null, "0", 2)); 
         assertEquals(0, ArrayUtils.indexOf(array, "0", 2)); 
         assertEquals(1, ArrayUtils.indexOf(array, "1", 2)); 
         assertEquals(2, ArrayUtils.indexOf(array, "2", 2)); 
         assertEquals(-1, ArrayUtils.indexOf(array, "3", 2)); 
         assertEquals(-1, ArrayUtils.indexOf(array, "3", -1)); 
         assertEquals(4, ArrayUtils.indexOf(array, null, 5)); 
         assertEquals(-1, ArrayUtils.indexOf(array, null, 2)); 
         assertEquals(-1, ArrayUtils.indexOf(array, "notInArray", 5)); 
          
         assertEquals(-1, ArrayUtils.indexOf(array, null, -1)); 
         assertEquals(-1, ArrayUtils.indexOf(array, "0", 88)); 
     }
@Test
@SuppressWarnings("cast") 
     public void testRemoveElementBooleanArray11265() { 
         boolean[] array; 
         array = ArrayUtils.removeElement((boolean[]) null, true); 
         assertNull(array); 
         array = ArrayUtils.removeElement(ArrayUtils.EMPTY_BOOLEAN_ARRAY, true); 
         assertTrue(Arrays.equals(ArrayUtils.EMPTY_BOOLEAN_ARRAY, array)); 
         assertEquals(Boolean.TYPE, array.getClass().getComponentType()); 
         array = ArrayUtils.removeElement(new boolean[] {true}, true); 
         assertTrue(Arrays.equals(ArrayUtils.EMPTY_BOOLEAN_ARRAY, array)); 
         assertEquals(Boolean.TYPE, array.getClass().getComponentType()); 
         array = ArrayUtils.removeElement(new boolean[] {true, false}, true); 
         assertTrue(Arrays.equals(new boolean[] {false}, array)); 
         assertEquals(Boolean.TYPE, array.getClass().getComponentType()); 
         array = ArrayUtils.removeElement(new boolean[] {true, false, true}, true); 
         assertTrue(Arrays.equals(new boolean[] {false, true}, array)); 
         assertEquals(Boolean.TYPE, array.getClass().getComponentType()); 
     }
@Test
public void testLastIndexOfBooleanWithStartIndex12586() { 
         boolean[] array = null; 
         assertEquals(-1, ArrayUtils.lastIndexOf(array, true, 2)); 
         array = new boolean[0]; 
         assertEquals(-1, ArrayUtils.lastIndexOf(array, true, 2)); 
         array = new boolean[] { true, false, true }; 
         assertEquals(0, ArrayUtils.lastIndexOf(array, false, 2)); 
         assertEquals(1, ArrayUtils.lastIndexOf(array, true, -1)); 
         assertEquals(2, ArrayUtils.lastIndexOf(array, false, 2)); 
         assertEquals(-1, ArrayUtils.lastIndexOf(array, false, -1)); 
         assertEquals(-1, ArrayUtils.lastIndexOf(array, true, 88)); 
     }
@Test
public void testLastIndexOfBooleanWithStartIndex12587() { 
         boolean[] array = null; 
         assertEquals(-1, ArrayUtils.lastIndexOf(array, true, 2)); 
         array = new boolean[0]; 
         assertEquals(-1, ArrayUtils.lastIndexOf(array, true, 2)); 
         array = new boolean[] { true, false, true }; 
         assertEquals(0, ArrayUtils.lastIndexOf(array, false, 2)); 
         array = new boolean[] { true, true, false }; 
         assertEquals(1, ArrayUtils.lastIndexOf(array, true, 2)); 
         assertEquals(2, ArrayUtils.lastIndexOf(array, false, -1)); 
         assertEquals(-1, ArrayUtils.lastIndexOf(array, false, 88)); 
     }
@Test
public void testLastIndexOfBooleanWithStartIndex12588() { 
         boolean[] array = null; 
         assertEquals(-1, ArrayUtils.lastIndexOf(array, true, 2)); 
         array = new boolean[0]; 
         assertEquals(-1, ArrayUtils.lastIndexOf(array, true, 2)); 
         array = new boolean[] { true, false, true }; 
         assertEquals(0, ArrayUtils.lastIndexOf(array, false, 2)); 
         array = new boolean[] { true, true, false }; 
         assertEquals(1, ArrayUtils.lastIndexOf(array, true, 2)); 
         assertEquals(2, ArrayUtils.lastIndexOf(array, false, -1)); 
         assertEquals(-1, ArrayUtils.lastIndexOf(array, false, 2)); 
         assertEquals(-1, ArrayUtils.lastIndexOf(array, false, -1)); 
         assertEquals(-1, ArrayUtils.lastIndexOf(array, true, 88)); 
     }
@Test
public void testLastIndexOfBooleanWithStartIndex12589() { 
         boolean[] array = null; 
         assertEquals(-1, ArrayUtils.lastIndexOf(array, true, 2)); 
         array = new boolean[] { true, true, false, true }; 
         assertEquals(0, ArrayUtils.lastIndexOf(array, true, 2)); 
         assertEquals(1, ArrayUtils.lastIndexOf(array, false, 2)); 
         array = new boolean[] { true, true, false, true }; 
         assertEquals(4, ArrayUtils.lastIndexOf(array, true, 2)); 
         assertEquals(2, ArrayUtils.lastIndexOf(array, false, 2)); 
         assertEquals(-1, ArrayUtils.lastIndexOf(array, false, -1)); 
         assertEquals(-1, ArrayUtils.lastIndexOf(array, false, -1)); 
     }
@Test
public void testLastIndexOfBooleanWithStartIndex12590() { 
         boolean[] array = null; 
         assertEquals(-1, ArrayUtils.lastIndexOf(array, true, 2)); 
         array = new boolean[0]; 
         assertEquals(-1, ArrayUtils.lastIndexOf(array, true, 2)); 
         array = new boolean[] { true, false, true }; 
         assertEquals(0, ArrayUtils.lastIndexOf(array, false, 2)); 
         array = new boolean[] { true, true, false }; 
         assertEquals(1, ArrayUtils.lastIndexOf(array, true, 2)); 
         assertEquals(2, ArrayUtils.lastIndexOf(array, false, -1)); 
         assertEquals(-1, ArrayUtils.lastIndexOf(array, false, 88)); 
     }
@Test
public void testLastIndexOfBooleanWithStartIndex12591() { 
         boolean[] array = null; 
         assertEquals(-1, ArrayUtils.lastIndexOf(array, true, 2)); 
         array = new boolean[] { true, true, false, true }; 
         assertEquals(0, ArrayUtils.lastIndexOf(array, true, 2)); 
         assertEquals(1, ArrayUtils.lastIndexOf(array, false, 1)); 
         array = new boolean[] { true, true, false, true }; 
         assertEquals(2, ArrayUtils.lastIndexOf(array, true, 2)); 
         assertEquals(-1, ArrayUtils.lastIndexOf(array, false, -1)); 
         assertEquals(-1, ArrayUtils.lastIndexOf(array, false, 88)); 
     }
@Test
public void testLastIndexOfBooleanWithStartIndex12592() { 
         boolean[] array = null; 
         assertEquals(-1, ArrayUtils.lastIndexOf(array, true, 2)); 
         array = new boolean[] { true, true, false, true }; 
         assertEquals(0, ArrayUtils.lastIndexOf(array, true, 2)); 
         assertEquals(1, ArrayUtils.lastIndexOf(array, false, 2)); 
         array = new boolean[] { true, true, false, true }; 
         assertEquals(4, ArrayUtils.lastIndexOf(array, true, 2)); 
         assertEquals(2, ArrayUtils.lastIndexOf(array, false, 2)); 
         assertEquals(-1, ArrayUtils.lastIndexOf(array, false, -1)); 
         assertEquals(-1, ArrayUtils.lastIndexOf(array, false, -1)); 
     }
@Test
public void testLastIndexOfBooleanWithStartIndex12593() { 
         boolean[] array = null; 
         assertEquals(-1, ArrayUtils.lastIndexOf(array, true, 2)); 
         array = new boolean[] { true, true, false, true }; 
         assertEquals(0, ArrayUtils.lastIndexOf(array, true, 2)); 
         assertEquals(1, ArrayUtils.lastIndexOf(array, false, 1)); 
         array = new boolean[] { true, true, false, true }; 
         assertEquals(4, ArrayUtils.lastIndexOf(array, true, 2)); 
         assertEquals(-1, ArrayUtils.lastIndexOf(array, false, -1)); 
         assertEquals(-1, ArrayUtils.lastIndexOf(array, false, 88)); 
     }
@Test
public void testLastIndexOfBooleanWithStartIndex12594() { 
         boolean[] array = null; 
         assertEquals(-1, ArrayUtils.lastIndexOf(array, true, 2)); 
         array = new boolean[] { true, true, false, true }; 
         assertEquals(0, ArrayUtils.lastIndexOf(array, true, 2)); 
         assertEquals(1, ArrayUtils.lastIndexOf(array, false, 1)); 
         array = new boolean[] { true, true, false, true }; 
         assertEquals(4, ArrayUtils.lastIndexOf(array, true, 2)); 
         assertEquals(-1, ArrayUtils.lastIndexOf(array, false, -1)); 
         assertEquals(-1, ArrayUtils.lastIndexOf(array, false, 88)); 
     }
@Test
public void testLastIndexOfBooleanWithStartIndex12595() { 
         boolean[] array = null; 
         assertEquals(-1, ArrayUtils.lastIndexOf(array, true, 2)); 
         array = new boolean[] { true, true, false, true }; 
         assertEquals(0, ArrayUtils.lastIndexOf(array, true, 2)); 
         assertEquals(1, ArrayUtils.lastIndexOf(array, false, 1)); 
         array = new boolean[] { true, true, false, true }; 
         assertEquals(2, ArrayUtils.lastIndexOf(array, true, 2)); 
         assertEquals(-1, ArrayUtils.lastIndexOf(array, false, -1)); 
         assertEquals(-1, ArrayUtils.lastIndexOf(array, false, 88)); 
     }
@Test
public void testLastIndexOfBooleanWithStartIndex12596() { 
         boolean[] array = null; 
         assertEquals(-1, ArrayUtils.lastIndexOf(array, true, 2)); 
         array = new boolean[] { true, true, false, true }; 
         assertEquals(0, ArrayUtils.lastIndexOf(array, true, 2)); 
         assertEquals(1, ArrayUtils.lastIndexOf(array, false, 1)); 
         array = new boolean[] { true, true, false, true }; 
         assertEquals(4, ArrayUtils.lastIndexOf(array, true, 2)); 
         assertEquals(-1, ArrayUtils.lastIndexOf(array, false, -1)); 
         assertEquals(-1, ArrayUtils.lastIndexOf(array, false, 88)); 
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
