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
public void testConstructor173() { 
     assertNotNull(new ArrayUtils()); 
     final Constructor<?>[] cons = ArrayUtils.class.getDeclaredConstructors(); 
     assertEquals(1, cons.length); 
     assertTrue(Modifier.isPublic(cons[0].getModifiers())); 
     assertTrue(Modifier.isPublic(ArrayUtils.class.getModifiers())); 
     assertFalse(Modifier.isFinal(ArrayUtils.class.getModifiers())); 
 }
@Test
public void testToString_Object176() { 
     final Integer[] b = null; 
     assertEquals(null, ArrayUtils.toString(b)); 
     assertEquals("<null>", ArrayUtils.toString(null, "<null>")); 
     assertEquals("2", ArrayUtils.toString(new Integer[0], "<null>")); 
     assertEquals("3", ArrayUtils.toString(new Integer[0], "<null>")); 
     assertEquals("<null>", ArrayUtils.toString(new Integer[0][0], "<null>")); 
     assertEquals("3", ArrayUtils.toString(new Integer[0][0], "<null>")); 
     assertEquals("<null>", ArrayUtils.toString(new Integer[0][0], "<null>")); 
     assertEquals("<null>", ArrayUtils.toString(null, "<null>")); 
 }
@Test
public void testToString_Object177() { 
     final Integer[] b = null; 
     assertEquals(null, ArrayUtils.toString(b)); 
     assertEquals("<null>", ArrayUtils.toString(null, "<null>")); 
     assertEquals("org.apache.commons.lang3", ArrayUtils.toString(new Integer[0], "<null>")); 
     assertEquals("org.apache.commons.lang3", ArrayUtils.toString(new Integer[0][0], "<null>")); 
     assertEquals("", ArrayUtils.toString(new int[0], "<null>")); 
     assertEquals("", ArrayUtils.toString(new int[0][0], "<null>")); 
     assertEquals("", ArrayUtils.toString(new int[0][0], "<null>")); 
     assertEquals("", ArrayUtils.toString(new int[0][0], "<null>")); 
     assertEquals("", ArrayUtils.toString(new int[0][0], "<null>")); 
 }
@Test
public void testCloneShort179() { 
     assertEquals(null, ArrayUtils.clone((short[]) null)); 
     final short[] original = new short[] { 1, 6 }; 
     final short[] cloned = ArrayUtils.clone(original); 
     assertTrue(Arrays.equals(original, cloned)); 
     assertTrue(original != cloned); 
 }
@Test
public void testNullToEmptyLong180() { 
     assertEquals(ArrayUtils.EMPTY_LONG_ARRAY, ArrayUtils.nullToEmpty((long[]) null)); 
     final long[] original = new long[] { 1L, 2L }; 
     assertEquals(original, ArrayUtils.nullToEmpty(original)); 
     final long[] empty = new long[] {}; 
     final long[] result = ArrayUtils.nullToEmpty(empty); 
     assertEquals(ArrayUtils.EMPTY_LONG_ARRAY, result); 
     assertTrue(empty != result); 
 }
@Test
public void testNullToEmptyChar181() { 
     assertEquals(ArrayUtils.EMPTY_CHAR_ARRAY, ArrayUtils.nullToEmpty((char[]) null)); 
     final char[] original = new char[] { 'a', 'b' }; 
     assertEquals(original, ArrayUtils.nullToEmpty(original)); 
     final char[] empty = new char[] {}; 
     final char[] result = ArrayUtils.nullToEmpty(empty); 
     assertEquals(ArrayUtils.EMPTY_CHAR_ARRAY, result); 
     assertTrue(empty != result); 
 }
@Test
public void testNullToEmptyBoolean182() { 
     assertEquals(ArrayUtils.EMPTY_BOOLEAN_ARRAY, ArrayUtils.nullToEmpty((boolean[]) null)); 
     final boolean[] original = new boolean[] { true, false }; 
     assertEquals(original, ArrayUtils.nullToEmpty(original)); 
     final boolean[] empty = new boolean[] {}; 
     final boolean[] result = ArrayUtils.nullToEmpty(empty); 
     assertEquals(ArrayUtils.EMPTY_BOOLEAN_ARRAY, result); 
     assertTrue(empty != result); 
 }
@Test
public void testNullToEmptyLongObject183() { 
     assertArrayEquals(ArrayUtils.EMPTY_LONG_OBJECT_ARRAY, ArrayUtils.nullToEmpty((Long[]) null)); 
     final Long[] original = new Long[] { 1L, 2L }; 
     assertArrayEquals(original, ArrayUtils.nullToEmpty(original)); 
     final Long[] empty = new Long[] {}; 
     final Long[] result = ArrayUtils.nullToEmpty(empty); 
     assertArrayEquals(ArrayUtils.EMPTY_LONG_OBJECT_ARRAY, result); 
     assertTrue(empty != result); 
 }
@Test
public void testNullToEmptyShortObject184() { 
     assertArrayEquals(ArrayUtils.EMPTY_SHORT_OBJECT_ARRAY, ArrayUtils.nullToEmpty((Short[]) null)); 
     final Short[] original = new Short[] { 1, 2 }; 
     assertArrayEquals(original, ArrayUtils.nullToEmpty(original)); 
     final Short[] empty = new Short[] {}; 
     final Short[] result = ArrayUtils.nullToEmpty(empty); 
     assertArrayEquals(ArrayUtils.EMPTY_SHORT_OBJECT_ARRAY, result); 
     assertTrue(empty != result); 
 }
@Test
public void testNullToEmptyByteObject185() { 
     assertArrayEquals(ArrayUtils.EMPTY_BYTE_OBJECT_ARRAY, ArrayUtils.nullToEmpty((Byte[]) null)); 
     final Byte[] original = new Byte[] { 1, 2 }; 
     assertArrayEquals(original, ArrayUtils.nullToEmpty(original)); 
     final Byte[] empty = new Byte[] {}; 
     final Byte[] result = ArrayUtils.nullToEmpty(empty); 
     assertArrayEquals(ArrayUtils.EMPTY_BYTE_OBJECT_ARRAY, result); 
     assertTrue(empty != result); 
 }
@Test
public void testNullToEmptyByteObject186() { 
     assertArrayEquals(ArrayUtils.EMPTY_BYTE_OBJECT_ARRAY, ArrayUtils.nullToEmpty((Byte[]) null)); 
     final Byte[] original = new Byte[] { Byte.valueOf(Byte.MIN_VALUE), Byte.valueOf(Byte.MAX_VALUE), Byte.valueOf((byte) 9999999) }; 
     assertArrayEquals(original, ArrayUtils.nullToEmpty(original)); 
     final Byte[] empty = new Byte[] {}; 
     final Byte[] result = ArrayUtils.nullToEmpty(empty); 
     assertArrayEquals(ArrayUtils.EMPTY_BYTE_OBJECT_ARRAY, result); 
     assertTrue(empty != result); 
 }
@Test
public void testNullToEmptyFloatObject187() { 
     assertArrayEquals(ArrayUtils.EMPTY_FLOAT_OBJECT_ARRAY, ArrayUtils.nullToEmpty((Float[]) null)); 
     final Float[] original = new Float[] { 2.6f, 3.8f }; 
     assertArrayEquals(original, ArrayUtils.nullToEmpty(original)); 
     final Float[] empty = new Float[] {}; 
     final Float[] result = ArrayUtils.nullToEmpty(empty); 
     assertArrayEquals(ArrayUtils.EMPTY_FLOAT_OBJECT_ARRAY, result); 
     assertTrue(empty != result); 
 }
@Test
public void testSameLength191() { 
     final Object[] nullArray = null; 
     final Object[] emptyArray = new Object[0]; 
     final Object[] oneArray = new Object[] { new String("Value") }; 
     final Object[] twoArray = new Object[] { new String("Value") }; 
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
public void testSameLengthObject192() { 
     final Object[] nullArray = null; 
     final Object[] emptyArray = new Object[0]; 
     final Object[] oneArray = new Object[] { new String("Value") }; 
     final Object[] twoArray = new Object[] { new String("Value") }; 
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
public void testSameLengthShort193() { 
     final short[] nullArray = null; 
     final short[] emptyArray = new short[0]; 
     final short[] oneArray = new short[] { 3 }; 
     final short[] twoArray = new short[] { 4, 6 }; 
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
public void testReverseLong194() { 
     long[] array = new long[] { 0L, 1L, 2L }; 
     ArrayUtils.reverse(array); 
     assertEquals(array[0], 2L); 
     assertEquals(array[1], 1L); 
     assertEquals(array[2], 2L); 
     array = null; 
     ArrayUtils.reverse(array); 
     assertEquals(null, array); 
 }
@Test
public void testReverseBoolean195() { 
     boolean[] array = new boolean[] { true, false, true }; 
     ArrayUtils.reverse(array); 
     assertEquals(array[0], true); 
     assertEquals(array[1], false); 
     assertEquals(array[2], true); 
     array = null; 
     ArrayUtils.reverse(array); 
     assertEquals(null, array); 
 }
@Test
public void testIndexOfInt196() { 
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
public void testIndexOfShort197() { 
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
public void testIndexOfShortWithStartIndex198() { 
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
public void testIndexOfChar199() { 
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
public void testLastIndexOfChar200() { 
     char[] array = null; 
     assertEquals(-1, ArrayUtils.lastIndexOf(array, 'a')); 
     array = new char[] { 'a', 'b', 'c', 'd', 'a' }; 
     assertEquals(0, ArrayUtils.lastIndexOf(array, 'a')); 
     assertEquals(1, ArrayUtils.lastIndexOf(array, 'b')); 
     assertEquals(2, ArrayUtils.lastIndexOf(array, 'c')); 
     assertEquals(3, ArrayUtils.lastIndexOf(array, 'd')); 
     assertEquals(-1, ArrayUtils.lastIndexOf(array, 'e')); 
 }
@Test
public void testIndexOfByte201() { 
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
public void testIndexOfByteWithStartIndex202() { 
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
public void testIndexOfBoolean203() { 
     boolean[] array = null; 
     assertEquals(-1, ArrayUtils.indexOf(array, true)); 
     array = new boolean[0]; 
     assertEquals(-1, ArrayUtils.indexOf(array, true)); 
     array = new boolean[] { true, false, true }; 
     assertEquals(2, ArrayUtils.indexOf(array, true)); 
     assertEquals(3, ArrayUtils.indexOf(array, false)); 
     array = new boolean[] { true, true }; 
     assertEquals(-1, ArrayUtils.indexOf(array, false)); 
 }
@Test
public void testIndexOfBoolean204() { 
     boolean[] array = null; 
     assertEquals(-1, ArrayUtils.indexOf(array, true)); 
     array = new boolean[0]; 
     assertEquals(-1, ArrayUtils.indexOf(array, true)); 
     array = new boolean[] { true, false, true }; 
     assertEquals(2, ArrayUtils.indexOf(array, true)); 
     assertEquals(1, ArrayUtils.indexOf(array, false)); 
     array = new boolean[] { true, true }; 
     assertEquals(-1, ArrayUtils.indexOf(array, false)); 
 }
@Test
public void testContainsBoolean205() { 
     boolean[] array = null; 
     assertFalse(ArrayUtils.contains(array, true)); 
     array = new boolean[] { true, false, true }; 
     assertTrue(ArrayUtils.contains(array, true)); 
     assertTrue(ArrayUtils.contains(array, false)); 
     array = new boolean[] { true, true }; 
     assertFalse(ArrayUtils.contains(array, true)); 
     assertTrue(ArrayUtils.contains(array, false)); 
     array = new boolean[] { true, false, true }; 
     assertFalse(ArrayUtils.contains(array, true)); 
 }
@Test
public void testToObject_long206() { 
     final long[] b = null; 
     assertArrayEquals(null, ArrayUtils.toObject(b)); 
     assertSame(ArrayUtils.EMPTY_LONG_OBJECT_ARRAY, ArrayUtils.toObject(new long[0])); 
     assertTrue(Arrays.equals(new Long[] { Long.valueOf(Long.MIN_VALUE), Long.valueOf(Long.MAX_VALUE), Long.valueOf(9999999) }, ArrayUtils.toObject(new long[] { Long.MIN_VALUE, Long.MAX_VALUE, 9999999 }))); 
 }
@Test
public void testToObject_int207() { 
     final int[] b = null; 
     assertArrayEquals(null, ArrayUtils.toObject(b)); 
     assertSame(ArrayUtils.EMPTY_INTEGER_OBJECT_ARRAY, ArrayUtils.toObject(new int[0])); 
     assertTrue(Arrays.equals(new Integer[] { Integer.valueOf(Integer.MIN_VALUE), Integer.valueOf(Integer.MAX_VALUE), Integer.valueOf(9999999) }, ArrayUtils.toObject(new int[] { Integer.MIN_VALUE, Integer.MAX_VALUE, 9999999 }))); 
 }
@Test
public void testToPrimitive_short_short208() { 
     final Short[] l = null; 
     assertEquals(null, ArrayUtils.toPrimitive(l, Short.MIN_VALUE)); 
     assertSame(ArrayUtils.EMPTY_SHORT_ARRAY, ArrayUtils.toPrimitive(new Short[0], (short) 1)); 
     assertTrue(Arrays.equals(new short[] { Short.MIN_VALUE, Short.MAX_VALUE, (short) 9999999 }, ArrayUtils.toPrimitive(new Short[] { Short.valueOf(Short.MIN_VALUE), Short.valueOf(Short.MAX_VALUE), Short.valueOf((short) 9999999) }, Short.MIN_VALUE))); 
     assertTrue(Arrays.equals(new short[] { Short.MIN_VALUE, Short.MAX_VALUE, (short) 9999999 }, ArrayUtils.toPrimitive(new Short[] { Short.valueOf(Short.MIN_VALUE), null, Short.valueOf((short) 9999999) }, Short.MAX_VALUE))); 
 }
@Test
public void testToObject_short209() { 
     final short[] b = null; 
     assertArrayEquals(null, ArrayUtils.toObject(b)); 
     assertSame(ArrayUtils.EMPTY_SHORT_OBJECT_ARRAY, ArrayUtils.toObject(new short[0])); 
     assertTrue(Arrays.equals(new Short[] { Short.valueOf(Short.MIN_VALUE), Short.valueOf(Short.MAX_VALUE), Short.valueOf((short) 9999999) }, ArrayUtils.toObject(new short[] { Short.MIN_VALUE, Short.MAX_VALUE, (short) 9999999 }))); 
 }
@Test
public void testToPrimitive_double210() { 
     final Double[] b = null; 
     assertEquals(null, ArrayUtils.toPrimitive(b)); 
     assertSame(ArrayUtils.EMPTY_DOUBLE_ARRAY, ArrayUtils.toPrimitive(new Double[0])); 
     assertTrue(Arrays.equals(new double[] { Double.MIN_VALUE, Double.MAX_VALUE, 9999999 }, ArrayUtils.toPrimitive(new Double[] { Double.valueOf(Double.MIN_VALUE), Double.valueOf(Double.MAX_VALUE), Double.valueOf(9999999) }))); 
     try { 
         ArrayUtils.toPrimitive(new Double[] { Double.valueOf(Double.MIN_VALUE), null }); 
         fail(); 
     } catch (final NullPointerException ex) { 
     } 
 }
@Test
public void testToPrimitive_float211() { 
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
public void testToPrimitive_float_float212() { 
     final Float[] l = null; 
     assertEquals(null, ArrayUtils.toPrimitive(l, Float.MIN_VALUE)); 
     assertSame(ArrayUtils.EMPTY_FLOAT_ARRAY, ArrayUtils.toPrimitive(new Float[0], 1)); 
     assertTrue(Arrays.equals(new float[] { Float.MIN_VALUE, Float.MAX_VALUE, 9999999 }, ArrayUtils.toPrimitive(new Float[] { Float.valueOf(Float.MIN_VALUE), Float.valueOf(Float.MAX_VALUE), Float.valueOf(9999999) }, 1))); 
     assertTrue(Arrays.equals(new float[] { Float.MIN_VALUE, Float.MAX_VALUE, 9999999 }, ArrayUtils.toPrimitive(new Float[] { Float.valueOf(Float.MIN_VALUE), null, Float.valueOf(9999999) }, Float.MAX_VALUE))); 
 }
@Test
@SuppressWarnings("cast") 
 public void testRemoveElementLongArray213() { 
     long[] array; 
     array = ArrayUtils.removeElement((long[]) null, (long) 1); 
     assertNull(array); 
     array = ArrayUtils.removeElement(ArrayUtils.EMPTY_LONG_ARRAY, (long) 1); 
     assertTrue(Arrays.equals(ArrayUtils.EMPTY_LONG_ARRAY, array)); 
     assertEquals(Long.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeElement(new long[] { 1 }, (long) 1); 
     assertTrue(Arrays.equals(ArrayUtils.EMPTY_LONG_ARRAY, array)); 
     assertEquals(Long.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeElement(new long[] { 1, 2 }, (long) 1); 
     assertTrue(Arrays.equals(new long[] { 2 }, array)); 
     assertEquals(Long.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeElement(new long[] { 1, 2, 1 }, (long) 1); 
     assertTrue(Arrays.equals(new long[] { 2, 1 }, array)); 
     assertEquals(Long.TYPE, array.getClass().getComponentType()); 
 }
@Test
public void testIsEmptyInt214() { 
     final int[] emptyIntArray = new int[] {}; 
     final int[] notEmptyIntArray = new int[] { 1 }; 
     assertTrue(ArrayUtils.isEmpty((int[]) null)); 
     assertTrue(ArrayUtils.isEmpty(emptyIntArray)); 
     assertFalse(ArrayUtils.isEmpty(notEmptyIntArray)); 
 }
@Test
public void testIsEmptyShort215() { 
     final short[] emptyShortArray = new short[] {}; 
     final short[] notEmptyShortArray = new short[] { 1 }; 
     assertTrue(ArrayUtils.isEmpty((short[]) null)); 
     assertTrue(ArrayUtils.isEmpty(emptyShortArray)); 
     assertFalse(ArrayUtils.isEmpty(notEmptyShortArray)); 
 }
@Test
public void testIsEmptyChar216() { 
     final char[] emptyArray = new char[] {}; 
     final char[] notEmptyArray = new char[] { 'a' }; 
     assertTrue(ArrayUtils.isEmpty((char[]) null)); 
     assertTrue(ArrayUtils.isEmpty(emptyArray)); 
     assertFalse(ArrayUtils.isEmpty(notEmptyArray)); 
 }
@Test
public void testIsEmptyChar217() { 
     final char[] empty = new char[] {}; 
     final char[] notEmpty = new char[] { 'a' }; 
     assertTrue(ArrayUtils.isEmpty((char[]) null)); 
     assertTrue(ArrayUtils.isEmpty(empty)); 
     assertFalse(ArrayUtils.isEmpty(notEmpty)); 
 }
@Test
public void testIsEmptyFloat219() { 
     final float[] emptyFloatArray = new float[] {}; 
     final float[] notEmptyFloatArray = new float[] { 2.6f }; 
     assertTrue(ArrayUtils.isEmpty((float[]) null)); 
     assertTrue(ArrayUtils.isEmpty(emptyFloatArray)); 
     assertFalse(ArrayUtils.isEmpty(notEmptyFloatArray)); 
 }
@Test
public void testIsEmptyBoolean220() { 
     final boolean[] emptyBooleanArray = new boolean[] {}; 
     final boolean[] notEmptyBooleanArray = new boolean[] { true, false }; 
     assertTrue(ArrayUtils.isEmpty((boolean[]) null)); 
     assertTrue(ArrayUtils.isEmpty(emptyBooleanArray)); 
     assertFalse(ArrayUtils.isEmpty(notEmptyBooleanArray)); 
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
