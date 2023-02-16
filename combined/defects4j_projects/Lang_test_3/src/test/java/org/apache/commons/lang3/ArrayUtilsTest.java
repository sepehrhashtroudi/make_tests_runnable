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
public void testCloneObject272() { 
     assertEquals(null, ArrayUtils.clone((Object[]) null)); 
     final Object[] original = new Object[] { Boolean.TRUE, Boolean.FALSE }; 
     final Object[] cloned = ArrayUtils.clone(original); 
     assertTrue(Arrays.equals(original, cloned)); 
     assertTrue(original != cloned); 
 }
@Test
public void testCloneBoolean273() { 
     assertEquals(null, ArrayUtils.clone((boolean[]) null)); 
     final boolean[] original = new boolean[] { true, false }; 
     final boolean[] cloned = ArrayUtils.clone(original); 
     assertTrue(Arrays.equals(original, cloned)); 
     assertTrue(original != cloned); 
 }
@Test
public void testNullToEmptyString274() { 
     assertEquals(ArrayUtils.EMPTY_STRING_ARRAY, ArrayUtils.nullToEmpty((String[]) null)); 
     final String[] original = new String[] { "a", "b" }; 
     assertEquals(original, ArrayUtils.nullToEmpty(original)); 
     final String[] empty = new String[] {}; 
     final String[] result = ArrayUtils.nullToEmpty(empty); 
     assertEquals(ArrayUtils.EMPTY_STRING_ARRAY, result); 
     assertTrue(empty != result); 
 }
@Test
public void testNullToEmptyByte275() { 
     assertEquals(ArrayUtils.EMPTY_BYTE_ARRAY, ArrayUtils.nullToEmpty((byte[]) null)); 
     final byte[] original = new byte[] { 1, 2 }; 
     assertEquals(original, ArrayUtils.nullToEmpty(original)); 
     final byte[] empty = new byte[] {}; 
     final byte[] result = ArrayUtils.nullToEmpty(empty); 
     assertEquals(ArrayUtils.EMPTY_BYTE_ARRAY, result); 
     assertTrue(empty != result); 
 }
@Test
public void testNullToEmptyIntegerObject276() { 
     assertArrayEquals(ArrayUtils.EMPTY_INTEGER_OBJECT_ARRAY, ArrayUtils.nullToEmpty((Integer[]) null)); 
     final Integer[] original = new Integer[] { 1, 2 }; 
     assertArrayEquals(original, ArrayUtils.nullToEmpty(original)); 
     final Integer[] empty = new Integer[] {}; 
     final Integer[] result = ArrayUtils.nullToEmpty(empty); 
     assertArrayEquals(ArrayUtils.EMPTY_INTEGER_OBJECT_ARRAY, result); 
     assertTrue(empty != result); 
 }
@Test
public void testNullToEmptyIntegerObject277() { 
     assertArrayEquals(ArrayUtils.EMPTY_INTEGER_OBJECT_ARRAY, ArrayUtils.nullToEmpty((Integer[]) null)); 
     @SuppressWarnings("boxing") 
     final Integer[] original = new Integer[] { 1, 2 }; 
     assertArrayEquals(original, ArrayUtils.nullToEmpty(original)); 
     final Integer[] empty = new Integer[] {}; 
     final Integer[] result = ArrayUtils.nullToEmpty(empty); 
     assertArrayEquals(ArrayUtils.EMPTY_INTEGER_OBJECT_ARRAY, result); 
     assertTrue(empty != result); 
 }
@Test
public void testSameLengthInt279() { 
     final int[] nullArray = null; 
     final int[] emptyArray = new int[0]; 
     final int[] oneArray = new int[] { 1 }; 
     final int[] twoArray = new int[] { 6, 8 }; 
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
public void testSameLengthInt280() { 
     final int[] nullArray = null; 
     final int[] emptyArray = new int[0]; 
     final int[] oneArray = new int[] { 1 }; 
     final int[] twoArray = new int[] { 2, 4 }; 
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
public void testSameLengthChar281() { 
     final char[] nullArray = null; 
     final char[] emptyArray = new char[0]; 
     final char[] oneArray = new char[] { 'a' }; 
     final char[] twoArray = new char[] { 'b', 'c' }; 
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
public void testIndexOf282() { 
     final Object[] array = new Object[] { "0", "1", "2", "3", null, "0" }; 
     assertEquals(-1, ArrayUtils.indexOf(null, null)); 
     assertEquals(-1, ArrayUtils.indexOf(null, "0")); 
     assertEquals(-1, ArrayUtils.indexOf(new Object[0], "0")); 
     assertEquals(0, ArrayUtils.indexOf(array, "0")); 
     assertEquals(1, ArrayUtils.indexOf(array, "1")); 
     assertEquals(2, ArrayUtils.indexOf(array, "2")); 
     assertEquals(3, ArrayUtils.indexOf(array, "3")); 
     assertEquals(4, ArrayUtils.indexOf(array, null)); 
     assertEquals(-1, ArrayUtils.indexOf(array, "notInArray")); 
 }
@Test
public void testLastIndexOfWithStartIndex283() { 
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
public void testContains284() { 
     final Object[] array = new Object[] { "0", "1", "2", "3", null, "0" }; 
     assertFalse(ArrayUtils.contains(null, null)); 
     assertFalse(ArrayUtils.contains(null, "0")); 
     assertFalse(ArrayUtils.contains(new Object[0], "0")); 
     assertTrue(ArrayUtils.contains(array, "0")); 
     assertTrue(ArrayUtils.contains(array, "1")); 
     assertTrue(ArrayUtils.contains(array, "2")); 
     assertTrue(ArrayUtils.contains(array, "3")); 
     assertFalse(ArrayUtils.contains(array, null)); 
     assertFalse(ArrayUtils.contains(array, "notInArray")); 
 }
@Test
@SuppressWarnings("cast") 
 public void testRemoveElementLongArray285() { 
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
public void testLastIndexOfLongWithStartIndex286() { 
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
public void testLastIndexOfIntWithStartIndex287() { 
     int[] array = null; 
     assertEquals(-1, ArrayUtils.lastIndexOf(array, 0, 2)); 
     array = new int[] { 0, 1, 2, 3, 0 }; 
     assertEquals(0, ArrayUtils.lastIndexOf(array, 0, 2)); 
     assertEquals(1, ArrayUtils.lastIndexOf(array, 1, 2)); 
     assertEquals(2, ArrayUtils.lastIndexOf(array, 2, 2)); 
     assertEquals(-1, ArrayUtils.lastIndexOf(array, 3, 2)); 
     assertEquals(-1, ArrayUtils.lastIndexOf(array, 3, -1)); 
     assertEquals(-1, ArrayUtils.lastIndexOf(array, 99, 4)); 
     assertEquals(4, ArrayUtils.lastIndexOf(array, 0, 88)); 
 }
@Test
public void testContainsByte288() { 
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
@SuppressWarnings("cast") 
 public void testRemoveElementDoubleArray289() { 
     double[] array; 
     array = ArrayUtils.removeElement((double[]) null, (double) 1); 
     assertNull(array); 
     array = ArrayUtils.removeElement(ArrayUtils.EMPTY_DOUBLE_ARRAY, (double) 1); 
     assertTrue(Arrays.equals(ArrayUtils.EMPTY_DOUBLE_ARRAY, array)); 
     assertEquals(Double.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeElement(new double[] { 1 }, (double) 1); 
     assertTrue(Arrays.equals(ArrayUtils.EMPTY_DOUBLE_ARRAY, array)); 
     assertEquals(Double.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeElement(new double[] { 1, 2 }, (double) 1); 
     assertTrue(Arrays.equals(new double[] { 2 }, array)); 
     assertEquals(Double.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeElement(new double[] { 1, 2, 1 }, (double) 1); 
     assertTrue(Arrays.equals(new double[] { 2, 1 }, array)); 
     assertEquals(Double.TYPE, array.getClass().getComponentType()); 
 }
@SuppressWarnings("cast")
@Test
public void testContainsDoubleTolerance290() { 
     double[] array = null; 
     assertFalse(ArrayUtils.contains(array, (double) 0, (double) 0)); 
     array = new double[0]; 
     assertFalse(ArrayUtils.contains(array, (double) 0, (double) 0)); 
     array = new double[] { 0, 1, 2, 3, 0 }; 
     assertTrue(ArrayUtils.contains(array, (double) 0, (double) 0.3)); 
     assertTrue(ArrayUtils.contains(array, (double) 2.2, (double) 0.35)); 
     assertTrue(ArrayUtils.contains(array, (double) 4.15, (double) 2.0)); 
     assertTrue(ArrayUtils.contains(array, (double) 1.00001324, (double) 0.0001)); 
 }
@SuppressWarnings("cast")
@Test
public void testLastIndexOfFloatWithStartIndex291() { 
     float[] array = null; 
     assertEquals(-1, ArrayUtils.lastIndexOf(array, (float) 0, 2)); 
     array = new float[0]; 
     assertEquals(-1, ArrayUtils.lastIndexOf(array, (float) 0, 2)); 
     array = new float[] { 0, 1, 2, 3, 0 }; 
     assertEquals(4, ArrayUtils.lastIndexOf(array, (float) 0, 2)); 
     assertEquals(-1, ArrayUtils.lastIndexOf(array, (float) 1, 2)); 
     assertEquals(2, ArrayUtils.lastIndexOf(array, (float) 2, 2)); 
     assertEquals(-1, ArrayUtils.lastIndexOf(array, (float) 3, 2)); 
     assertEquals(-1, ArrayUtils.lastIndexOf(array, (float) 3, -1)); 
     assertEquals(-1, ArrayUtils.lastIndexOf(array, (float) 99)); 
     assertEquals(4, ArrayUtils.lastIndexOf(array, (float) 0, 88)); 
 }
@SuppressWarnings("cast")
@Test
public void testContainsFloat292() { 
     float[] array = null; 
     assertFalse(ArrayUtils.contains(array, (float) 1)); 
     array = new float[0]; 
     assertFalse(ArrayUtils.contains(array, (float) 0)); 
     array = new float[] { 0, 1, 2, 3, 0 }; 
     assertTrue(ArrayUtils.contains(array, (float) 0)); 
     assertTrue(ArrayUtils.contains(array, (float) 1)); 
     assertTrue(ArrayUtils.contains(array, (float) 2)); 
     assertTrue(ArrayUtils.contains(array, (float) 3)); 
     assertFalse(ArrayUtils.contains(array, (float) 99)); 
 }
@Test
public void testContainsBoolean293() { 
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
public void testLastIndexOfBoolean294() { 
     boolean[] array = null; 
     assertEquals(-1, ArrayUtils.lastIndexOf(array, true)); 
     array = new boolean[0]; 
     assertEquals(-1, ArrayUtils.lastIndexOf(array, true)); 
     array = new boolean[] { true, false, true }; 
     assertEquals(2, ArrayUtils.lastIndexOf(array, true)); 
     assertEquals(1, ArrayUtils.lastIndexOf(array, false)); 
     array = new boolean[] { true, true }; 
     assertEquals(-1, ArrayUtils.lastIndexOf(array, false)); 
 }
@Test
public void testToPrimitive_char_char295() { 
     final Character[] b = null; 
     assertEquals(null, ArrayUtils.toPrimitive(b, Character.MIN_VALUE)); 
     assertSame(ArrayUtils.EMPTY_CHAR_ARRAY, ArrayUtils.toPrimitive(new Character[0], Character.MIN_VALUE)); 
     assertTrue(Arrays.equals(new char[] { Character.MIN_VALUE, Character.MAX_VALUE, '0' }, ArrayUtils.toPrimitive(new Character[] { new Character(Character.MIN_VALUE), new Character(Character.MAX_VALUE), new Character('0') }, Character.MIN_VALUE))); 
     assertTrue(Arrays.equals(new char[] { Character.MIN_VALUE, Character.MAX_VALUE, '0' }, ArrayUtils.toPrimitive(new Character[] { new Character(Character.MIN_VALUE), null, new Character('0') }, Character.MAX_VALUE))); 
 }
@Test
public void testToPrimitive_char_char296() { 
     final Character[] b = null; 
     assertEquals(null, ArrayUtils.toPrimitive(b, Character.MIN_VALUE)); 
     assertSame(ArrayUtils.EMPTY_CHAR_ARRAY, ArrayUtils.toPrimitive(new Character[0], 'a')); 
     assertTrue(Arrays.equals(new char[] { Character.MIN_VALUE, Character.MAX_VALUE, '0' }, ArrayUtils.toPrimitive(new Character[] { new Character(Character.MIN_VALUE), new Character(Character.MAX_VALUE), new Character('0') }, Character.MIN_VALUE))); 
     assertTrue(Arrays.equals(new char[] { Character.MIN_VALUE, Character.MAX_VALUE, '0' }, ArrayUtils.toPrimitive(new Character[] { new Character(Character.MIN_VALUE), null, new Character('0') }, Character.MAX_VALUE))); 
 }
@Test
public void testToPrimitive_char_char297() { 
     final Character[] l = null; 
     assertEquals(null, ArrayUtils.toPrimitive(l, Character.MIN_VALUE)); 
     assertSame(ArrayUtils.EMPTY_CHAR_ARRAY, ArrayUtils.toPrimitive(new Character[0], 'a')); 
     assertTrue(Arrays.equals(new char[] { Character.MIN_VALUE, Character.MAX_VALUE, '0' }, ArrayUtils.toPrimitive(new Character[] { new Character(Character.MIN_VALUE), new Character(Character.MAX_VALUE), new Character('0') }, Character.MIN_VALUE))); 
     assertTrue(Arrays.equals(new char[] { Character.MIN_VALUE, Character.MAX_VALUE, '0' }, ArrayUtils.toPrimitive(new Character[] { new Character(Character.MIN_VALUE), null, new Character('0') }, Character.MAX_VALUE))); 
 }
@Test
public void testToPrimitive_int_int298() { 
     final Long[] l = null; 
     assertEquals(null, ArrayUtils.toPrimitive(l, Integer.MIN_VALUE)); 
     assertSame(ArrayUtils.EMPTY_INT_ARRAY, ArrayUtils.toPrimitive(new Integer[0], 1)); 
     assertTrue(Arrays.equals(new int[] { Integer.MIN_VALUE, Integer.MAX_VALUE, 9999999 }, ArrayUtils.toPrimitive(new Integer[] { Integer.valueOf(Integer.MIN_VALUE), Integer.valueOf(Integer.MAX_VALUE), Integer.valueOf(9999999) }, 1))); 
     assertTrue(Arrays.equals(new int[] { Integer.MIN_VALUE, Integer.MAX_VALUE, 9999999 }, ArrayUtils.toPrimitive(new Integer[] { Integer.valueOf(Integer.MIN_VALUE), null, Integer.valueOf(9999999) }, Integer.MAX_VALUE))); 
 }
@Test
public void testToPrimitive_boolean299() { 
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
