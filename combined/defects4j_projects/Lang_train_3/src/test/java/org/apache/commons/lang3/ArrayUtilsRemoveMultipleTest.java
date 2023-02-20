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
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;

import org.junit.Test;

/**
 * Tests ArrayUtils remove and removeElement methods.
 * 
 * @version $Id$
 */
public class ArrayUtilsRemoveMultipleTest {

@Test(expected = IndexOutOfBoundsException.class) 
 public void testRemoveAllFloatArrayNegativeIndex473() { 
     ArrayUtils.removeAll(new float[] { 1, 2 }, -1); 
 }
@Test
@SuppressWarnings("cast") 
 public void testRemoveElementDoubleArray540() { 
     double[] array; 
     array = ArrayUtils.removeElements((double[]) null, (double) 1); 
     assertNull(array); 
     array = ArrayUtils.removeElements(ArrayUtils.EMPTY_DOUBLE_ARRAY, (double) 1); 
     assertTrue(Arrays.equals(ArrayUtils.EMPTY_DOUBLE_ARRAY, array)); 
     assertEquals(Double.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeElements(new double[] { 1 }, (double) 1); 
     assertTrue(Arrays.equals(ArrayUtils.EMPTY_DOUBLE_ARRAY, array)); 
     assertEquals(Double.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeElements(new double[] { 1, 2 }, (double) 1); 
     assertTrue(Arrays.equals(new double[] { 2 }, array)); 
     assertEquals(Double.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeElements(new double[] { 1, 2, 1 }, (double) 1); 
     assertTrue(Arrays.equals(new double[] { 2, 1 }, array)); 
     assertEquals(Double.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeElements((double[]) null, (double) 1, (double) 2); 
     assertNull(array); 
     array = ArrayUtils.removeElements(ArrayUtils.EMPTY_DOUBLE_ARRAY, (double) 1, (double) 2); 
     assertTrue(Arrays.equals(ArrayUtils.EMPTY_DOUBLE_ARRAY, array)); 
     assertEquals(Double.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeElements(new double[] { 1 }, (double) 1, (double) 2); 
     assertTrue(Arrays.equals(ArrayUtils.EMPTY_DOUBLE_ARRAY, array)); 
     assertEquals(Double.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeElements(new double[] { 1, 2 }, (double) 1, (double) 2); 
     assertTrue(Arrays.equals(ArrayUtils.EMPTY_DOUBLE_ARRAY, array)); 
     assertEquals(Double.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeElements(new double[] { 1, 2 }, (double) 1, (double) 1); 
     assertTrue(Arrays.equals(new double[] { 2 }, array)); 
     assertEquals(Double.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeElements(new double[] { 1, 2, 1 }, (double) 1, (double) 2); 
     assertTrue(Arrays.equals(new double[] { 1 }, array)); 
     assertEquals(Double.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeElements(new double[] { 1, 2, 1 }, (double) 1, (double) 1); 
     assertTrue(Arrays.equals(new double[] { 2 }, array)); 
     assertEquals(Double.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeElements(new double[] { 1, 2, 1 }, (double) 1, (double) 1, (double) 1, (double) 1); 
     assertTrue(Arrays.equals(new double[] { 2 }, array)); 
     assertEquals(Double.TYPE, array.getClass().getComponentType()); 
 }
@Test
public void testRemoveAllNumberArray593() { 
     final Number[] inarray = { Integer.valueOf(1), Long.valueOf(2L), Byte.valueOf((byte) 3) }; 
     assertEquals(3, inarray.length); 
     Number[] outarray; 
     outarray = ArrayUtils.removeAll(inarray, 1); 
     assertArrayEquals(new Number[] { Integer.valueOf(1), Byte.valueOf((byte) 3) }, outarray); 
     assertEquals(Number.class, outarray.getClass().getComponentType()); 
     outarray = ArrayUtils.removeAll(outarray, 1); 
     assertArrayEquals(new Number[] { Integer.valueOf(1) }, outarray); 
     assertEquals(Number.class, outarray.getClass().getComponentType()); 
     outarray = ArrayUtils.removeAll(outarray, 0); 
     assertEquals(0, outarray.length); 
     assertEquals(Number.class, outarray.getClass().getComponentType()); 
     outarray = ArrayUtils.removeAll(inarray, 0, 1); 
     assertArrayEquals(new Number[] { Byte.valueOf((byte) 3) }, outarray); 
     assertEquals(Number.class, outarray.getClass().getComponentType()); 
     outarray = ArrayUtils.removeAll(inarray, 0, 2); 
     assertArrayEquals(new Number[] { Long.valueOf(2L) }, outarray); 
     assertEquals(Number.class, outarray.getClass().getComponentType()); 
     outarray = ArrayUtils.removeAll(inarray, 1, 2); 
     assertArrayEquals(new Number[] { Integer.valueOf(1) }, outarray); 
     assertEquals(Number.class, outarray.getClass().getComponentType()); 
 }
@Test
public void testRemoveElementsObjectArray594() { 
     Object[] array; 
     array = ArrayUtils.removeElements((Object[]) null, "a"); 
     assertNull(array); 
     array = ArrayUtils.removeElements(ArrayUtils.EMPTY_OBJECT_ARRAY, "a"); 
     assertTrue(Arrays.equals(ArrayUtils.EMPTY_OBJECT_ARRAY, array)); 
     assertEquals(Object.class, array.getClass().getComponentType()); 
     array = ArrayUtils.removeElements(new Object[] { "a" }, "a"); 
     assertTrue(Arrays.equals(ArrayUtils.EMPTY_OBJECT_ARRAY, array)); 
     assertEquals(Object.class, array.getClass().getComponentType()); 
     array = ArrayUtils.removeElements(new Object[] { "a", "b" }, "a"); 
     assertTrue(Arrays.equals(new Object[] { "b" }, array)); 
     assertEquals(Object.class, array.getClass().getComponentType()); 
     array = ArrayUtils.removeElements(new Object[] { "a", "b", "a" }, "a"); 
     assertTrue(Arrays.equals(new Object[] { "b", "a" }, array)); 
     assertEquals(Object.class, array.getClass().getComponentType()); 
     array = ArrayUtils.removeElements((Object[]) null, "a", "b"); 
     assertNull(array); 
     array = ArrayUtils.removeElements(ArrayUtils.EMPTY_OBJECT_ARRAY, "a", "b"); 
     assertTrue(Arrays.equals(ArrayUtils.EMPTY_OBJECT_ARRAY, array)); 
     assertEquals(Object.class, array.getClass().getComponentType()); 
     array = ArrayUtils.removeElements(new Object[] { "a" }, "a", "b"); 
     assertTrue(Arrays.equals(ArrayUtils.EMPTY_OBJECT_ARRAY, array)); 
     assertEquals(Object.class, array.getClass().getComponentType()); 
     array = ArrayUtils.removeElements(new Object[] { "a", "b" }, "a", "c"); 
     assertTrue(Arrays.equals(new Object[] { "b" }, array)); 
     assertEquals(Object.class, array.getClass().getComponentType()); 
     array = ArrayUtils.removeElements(new Object[] { "a", "b", "a" }, "a"); 
     assertTrue(Arrays.equals(new Object[] { "b", "a" }, array)); 
     assertEquals(Object.class, array.getClass().getComponentType()); 
     array = ArrayUtils.removeElements(new Object[] { "a", "b", "a" }, "a", "b"); 
     assertTrue(Arrays.equals(new Object[] { "a" }, array)); 
     assertEquals(Object.class, array.getClass().getComponentType()); 
     array = ArrayUtils.removeElements(new Object[] { "a", "b", "a" }, "a", "a"); 
     assertTrue(Arrays.equals(new Object[] { "b" }, array)); 
     assertEquals(Object.class, array.getClass().getComponentType()); 
     array = ArrayUtils.removeElements(new Object[] { "a", "b", "a" }, "a", "a", "a", "a"); 
     assertTrue(Arrays.equals(new Object[] { "b" }, array)); 
     assertEquals(Object.class, array.getClass().getComponentType()); 
 }
@Test
public void testRemoveElementByteArray595() { 
     byte[] array; 
     array = ArrayUtils.removeElements((byte[]) null, (byte) 1); 
     assertNull(array); 
     array = ArrayUtils.removeElements(ArrayUtils.EMPTY_BYTE_ARRAY, (byte) 1); 
     assertTrue(Arrays.equals(ArrayUtils.EMPTY_BYTE_ARRAY, array)); 
     assertEquals(Byte.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeElements(new byte[] { 1 }, (byte) 1); 
     assertTrue(Arrays.equals(ArrayUtils.EMPTY_BYTE_ARRAY, array)); 
     assertEquals(Byte.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeElements(new byte[] { 1, 2 }, (byte) 1); 
     assertTrue(Arrays.equals(new byte[] { 2 }, array)); 
     assertEquals(Byte.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeElements(new byte[] { 1, 2, 1 }, (byte) 1); 
     assertTrue(Arrays.equals(new byte[] { 2, 1 }, array)); 
     assertEquals(Byte.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeElements((byte[]) null, (byte) 1, (byte) 2); 
     assertNull(array); 
     array = ArrayUtils.removeElements(ArrayUtils.EMPTY_BYTE_ARRAY, (byte) 1, (byte) 2); 
     assertTrue(Arrays.equals(ArrayUtils.EMPTY_BYTE_ARRAY, array)); 
     assertEquals(Byte.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeElements(new byte[] { 1 }, (byte) 1, (byte) 2); 
     assertTrue(Arrays.equals(ArrayUtils.EMPTY_BYTE_ARRAY, array)); 
     assertEquals(Byte.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeElements(new byte[] { 1, 2 }, (byte) 1, (byte) 2); 
     assertTrue(Arrays.equals(ArrayUtils.EMPTY_BYTE_ARRAY, array)); 
     assertEquals(Byte.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeElements(new byte[] { 1, 2 }, (byte) 1, (byte) 1); 
     assertTrue(Arrays.equals(new byte[] { 2 }, array)); 
     assertEquals(Byte.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeElements(new byte[] { 1, 2, 1 }, (byte) 1, (byte) 2); 
     assertTrue(Arrays.equals(new byte[] { 1 }, array)); 
     assertEquals(Byte.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeElements(new byte[] { 1, 2, 1 }, (byte) 1, (byte) 1); 
     assertTrue(Arrays.equals(new byte[] { 2 }, array)); 
     assertEquals(Byte.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeElements(new byte[] { 1, 2, 1 }, (byte) 1, (byte) 1, (byte) 1, (byte) 1); 
     assertTrue(Arrays.equals(new byte[] { 2 }, array)); 
     assertEquals(Byte.TYPE, array.getClass().getComponentType()); 
 }
@Test(expected = IndexOutOfBoundsException.class) 
 public void testRemoveAllShortArrayNegativeIndex596() { 
     ArrayUtils.removeAll(new short[] { 1, 2 }, -1, 0); 
 }
@Test
public void testRemoveAllIntArrayRemoveNone597() { 
     final int[] array1 = new int[] { 1, 2 }; 
     final int[] array2 = ArrayUtils.removeAll(array1); 
     assertNotSame(array1, array2); 
     assertArrayEquals(array1, array2); 
     assertEquals(int.class, array2.getClass().getComponentType()); 
 }
@Test
public void testRemoveElementIntArray598() { 
     int[] array; 
     array = ArrayUtils.removeElements((int[]) null, 1); 
     assertNull(array); 
     array = ArrayUtils.removeElements(ArrayUtils.EMPTY_INT_ARRAY, 1); 
     assertTrue(Arrays.equals(ArrayUtils.EMPTY_INT_ARRAY, array)); 
     assertEquals(Integer.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeElements(new int[] { 1 }, 1); 
     assertTrue(Arrays.equals(ArrayUtils.EMPTY_INT_ARRAY, array)); 
     assertEquals(Integer.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeElements(new int[] { 1, 2 }, 1); 
     assertTrue(Arrays.equals(new int[] { 2 }, array)); 
     assertEquals(Integer.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeElements(new int[] { 1, 2, 1 }, 1); 
     assertTrue(Arrays.equals(new int[] { 2, 1 }, array)); 
     assertEquals(Integer.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeElements((int[]) null, 1); 
     assertNull(array); 
     array = ArrayUtils.removeElements(ArrayUtils.EMPTY_INT_ARRAY, 1, 1); 
     assertTrue(Arrays.equals(ArrayUtils.EMPTY_INT_ARRAY, array)); 
     assertEquals(Integer.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeElements(new int[] { 1 }, 1, 1); 
     assertTrue(Arrays.equals(ArrayUtils.EMPTY_INT_ARRAY, array)); 
     assertEquals(Integer.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeElements(new int[] { 1, 2 }, 1, 2); 
     assertTrue(Arrays.equals(ArrayUtils.EMPTY_INT_ARRAY, array)); 
     assertEquals(Integer.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeElements(new int[] { 1, 2 }, 1, 1); 
     assertTrue(Arrays.equals(new int[] { 2 }, array)); 
     assertEquals(Integer.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeElements(new int[] { 1, 2, 1 }, 1, 2); 
     assertTrue(Arrays.equals(new int[] { 1 }, array)); 
     assertEquals(Integer.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeElements(new int[] { 1, 2, 1 }, 1, 1); 
     assertTrue(Arrays.equals(new int[] { 2 }, array)); 
     assertEquals(Integer.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeElements(new int[] { 1, 2, 1 }, 1, 1, 1, 1); 
     assertTrue(Arrays.equals(new int[] { 2 }, array)); 
     assertEquals(Integer.TYPE, array.getClass().getComponentType()); 
 }
@Test(expected = IndexOutOfBoundsException.class) 
 public void testRemoveAllNullCharArray599() { 
     ArrayUtils.removeAll((char[]) null, 0); 
 }
@Test
public void testRemoveElementCharArray600() { 
     char[] array; 
     array = ArrayUtils.removeElements((char[]) null, 'a'); 
     assertNull(array); 
     array = ArrayUtils.removeElements(ArrayUtils.EMPTY_CHAR_ARRAY, 'a'); 
     assertTrue(Arrays.equals(ArrayUtils.EMPTY_CHAR_ARRAY, array)); 
     assertEquals(Character.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeElements(new char[] { 'a' }, 'a'); 
     assertTrue(Arrays.equals(ArrayUtils.EMPTY_CHAR_ARRAY, array)); 
     assertEquals(Character.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeElements(new char[] { 'a', 'b' }, 'a'); 
     assertTrue(Arrays.equals(new char[] { 'b' }, array)); 
     assertEquals(Character.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeElements(new char[] { 'a', 'b', 'a' }, 'a'); 
     assertTrue(Arrays.equals(new char[] { 'b', 'a' }, array)); 
     assertEquals(Character.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeElements((char[]) null, 'a', 'b'); 
     assertNull(array); 
     array = ArrayUtils.removeElements(ArrayUtils.EMPTY_CHAR_ARRAY, 'a', 'b'); 
     assertTrue(Arrays.equals(ArrayUtils.EMPTY_CHAR_ARRAY, array)); 
     assertEquals(Character.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeElements(new char[] { 'a' }, 'a', 'b'); 
     assertTrue(Arrays.equals(ArrayUtils.EMPTY_CHAR_ARRAY, array)); 
     assertEquals(Character.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeElements(new char[] { 'a', 'b' }, 'a', 'b'); 
     assertTrue(Arrays.equals(ArrayUtils.EMPTY_CHAR_ARRAY, array)); 
     assertEquals(Character.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeElements(new char[] { 'a', 'b' }, 'a', 'a'); 
     assertTrue(Arrays.equals(new char[] { 'b' }, array)); 
     assertEquals(Character.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeElements(new char[] { 'a', 'b', 'a' }, 'a', 'b'); 
     assertTrue(Arrays.equals(new char[] { 'a' }, array)); 
     assertEquals(Character.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeElements(new char[] { 'a', 'b', 'a' }, 'a', 'a'); 
     assertTrue(Arrays.equals(new char[] { 'b' }, array)); 
     assertEquals(Character.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeElements(new char[] { 'a', 'b', 'a' }, 'a', 'a', 'a', 'a'); 
     assertTrue(Arrays.equals(new char[] { 'b' }, array)); 
     assertEquals(Character.TYPE, array.getClass().getComponentType()); 
 }
@Test
@SuppressWarnings("cast") 
 public void testRemoveElementLongArray601() { 
     long[] array; 
     array = ArrayUtils.removeElements((long[]) null, (long) 1); 
     assertNull(array); 
     array = ArrayUtils.removeElements(ArrayUtils.EMPTY_LONG_ARRAY, (long) 1); 
     assertTrue(Arrays.equals(ArrayUtils.EMPTY_LONG_ARRAY, array)); 
     assertEquals(Long.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeElements(new long[] { 1 }, (long) 1); 
     assertTrue(Arrays.equals(ArrayUtils.EMPTY_LONG_ARRAY, array)); 
     assertEquals(Long.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeElements(new long[] { 1, 2 }, (long) 1); 
     assertTrue(Arrays.equals(new long[] { 2 }, array)); 
     assertEquals(Long.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeElements(new long[] { 1, 2, 1 }, (long) 1); 
     assertTrue(Arrays.equals(new long[] { 2, 1 }, array)); 
     assertEquals(Long.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeElements((long[]) null, (long) 1, (long) 1); 
     assertNull(array); 
     array = ArrayUtils.removeElements(ArrayUtils.EMPTY_LONG_ARRAY, (long) 1, (long) 1); 
     assertTrue(Arrays.equals(ArrayUtils.EMPTY_LONG_ARRAY, array)); 
     assertEquals(Long.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeElements(new long[] { 1 }, (long) 1, (long) 1); 
     assertTrue(Arrays.equals(ArrayUtils.EMPTY_LONG_ARRAY, array)); 
     assertEquals(Long.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeElements(new long[] { 1, 2 }, (long) 1, (long) 2); 
     assertTrue(Arrays.equals(ArrayUtils.EMPTY_LONG_ARRAY, array)); 
     assertEquals(Long.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeElements(new long[] { 1, 2 }, (long) 1, (long) 1); 
     assertTrue(Arrays.equals(new long[] { 2 }, array)); 
     assertEquals(Long.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeElements(new long[] { 1, 2, 1 }, (long) 1, (long) 1); 
     assertTrue(Arrays.equals(new long[] { 2 }, array)); 
     assertEquals(Long.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeElements(new long[] { 1, 2, 1 }, (long) 1, (long) 2); 
     assertTrue(Arrays.equals(new long[] { 1 }, array)); 
     assertEquals(Long.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeElements(new long[] { 1, 2, 1 }, (long) 1, (long) 1, (long) 1, (long) 1); 
     assertTrue(Arrays.equals(new long[] { 2 }, array)); 
     assertEquals(Long.TYPE, array.getClass().getComponentType()); 
 }
@Test(expected = IndexOutOfBoundsException.class) 
 public void testRemoveAllNullBooleanArray602() { 
     ArrayUtils.removeAll((boolean[]) null, 0); 
 }
@Test
public void testRemoveElementBooleanArray603() { 
     boolean[] array; 
     array = ArrayUtils.removeElements((boolean[]) null, true); 
     assertNull(array); 
     array = ArrayUtils.removeElements(ArrayUtils.EMPTY_BOOLEAN_ARRAY, true); 
     assertTrue(Arrays.equals(ArrayUtils.EMPTY_BOOLEAN_ARRAY, array)); 
     assertEquals(Boolean.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeElements(new boolean[] { true }, true); 
     assertTrue(Arrays.equals(ArrayUtils.EMPTY_BOOLEAN_ARRAY, array)); 
     assertEquals(Boolean.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeElements(new boolean[] { true, false }, true); 
     assertTrue(Arrays.equals(new boolean[] { false }, array)); 
     assertEquals(Boolean.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeElements(new boolean[] { true, false, true }, true); 
     assertTrue(Arrays.equals(new boolean[] { false, true }, array)); 
     assertEquals(Boolean.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeElements((boolean[]) null, true, false); 
     assertNull(array); 
     array = ArrayUtils.removeElements(ArrayUtils.EMPTY_BOOLEAN_ARRAY, true, false); 
     assertTrue(Arrays.equals(ArrayUtils.EMPTY_BOOLEAN_ARRAY, array)); 
     assertEquals(Boolean.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeElements(new boolean[] { true }, true, false); 
     assertTrue(Arrays.equals(ArrayUtils.EMPTY_BOOLEAN_ARRAY, array)); 
     assertEquals(Boolean.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeElements(new boolean[] { true, false }, true, false); 
     assertTrue(Arrays.equals(ArrayUtils.EMPTY_BOOLEAN_ARRAY, array)); 
     assertEquals(Boolean.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeElements(new boolean[] { true, false }, true, true); 
     assertTrue(Arrays.equals(new boolean[] { false }, array)); 
     assertEquals(Boolean.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeElements(new boolean[] { true, false, true }, true, false); 
     assertTrue(Arrays.equals(new boolean[] { true }, array)); 
     assertEquals(Boolean.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeElements(new boolean[] { true, false, true }, true, true); 
     assertTrue(Arrays.equals(new boolean[] { false }, array)); 
     assertEquals(Boolean.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeElements(new boolean[] { true, false, true }, true, true, true, true); 
     assertTrue(Arrays.equals(new boolean[] { false }, array)); 
     assertEquals(Boolean.TYPE, array.getClass().getComponentType()); 
 }
@Test
public void testRemoveAllObjectArray604() { 
     Object[] array; 
     array = ArrayUtils.removeAll(new Object[] { "a" }, 0); 
     assertArrayEquals(ArrayUtils.EMPTY_OBJECT_ARRAY, array); 
     assertEquals(Object.class, array.getClass().getComponentType()); 
     array = ArrayUtils.removeAll(new Object[] { "a", "b" }, 0, 1); 
     assertArrayEquals(ArrayUtils.EMPTY_OBJECT_ARRAY, array); 
     assertEquals(Object.class, array.getClass().getComponentType()); 
     array = ArrayUtils.removeAll(new Object[] { "a", "b", "c" }, 1, 2); 
     assertArrayEquals(new Object[] { "a" }, array); 
     assertEquals(Object.class, array.getClass().getComponentType()); 
     array = ArrayUtils.removeAll(new Object[] { "a", "b", "c", "d" }, 1, 2); 
     assertArrayEquals(new Object[] { "a", "d" }, array); 
     assertEquals(Object.class, array.getClass().getComponentType()); 
     array = ArrayUtils.removeAll(new Object[] { "a", "b", "c", "d" }, 0, 3); 
     assertArrayEquals(new Object[] { "b", "c" }, array); 
     assertEquals(Object.class, array.getClass().getComponentType()); 
     array = ArrayUtils.removeAll(new Object[] { "a", "b", "c", "d" }, 0, 1, 3); 
     assertArrayEquals(new Object[] { "c" }, array); 
     assertEquals(Object.class, array.getClass().getComponentType()); 
     array = ArrayUtils.removeAll(new Object[] { "a", "b", "c", "d", "e" }, 0, 1, 3); 
     assertArrayEquals(new Object[] { "c", "e" }, array); 
     assertEquals(Object.class, array.getClass().getComponentType()); 
     array = ArrayUtils.removeAll(new Object[] { "a", "b", "c", "d", "e" }, 0, 2, 4); 
     assertArrayEquals(new Object[] { "b", "d" }, array); 
     assertEquals(Object.class, array.getClass().getComponentType()); 
     array = ArrayUtils.removeAll(new Object[] { "a", "b", "c", "d" }, 0, 1, 3, 0, 1, 3); 
     assertArrayEquals(new Object[] { "c" }, array); 
     assertEquals(Object.class, array.getClass().getComponentType()); 
     array = ArrayUtils.removeAll(new Object[] { "a", "b", "c", "d" }, 2, 1, 0, 3); 
     assertArrayEquals(ArrayUtils.EMPTY_OBJECT_ARRAY, array); 
     assertEquals(Object.class, array.getClass().getComponentType()); 
     array = ArrayUtils.removeAll(new Object[] { "a", "b", "c", "d" }, 2, 0, 1, 3, 0, 2, 1, 3); 
     assertArrayEquals(ArrayUtils.EMPTY_OBJECT_ARRAY, array); 
     assertEquals(Object.class, array.getClass().getComponentType()); 
 }
    

    

    

    

    

    

    

    

    

    

    

    

    

    

    

    

    

    

    

    

    

    

    

    

    

    

    

    

    

    

    

    

    

    

    

    

    

    

    

    

    

    

    

    

    

    

    

    

    

    

    

    

    

    

    

}
