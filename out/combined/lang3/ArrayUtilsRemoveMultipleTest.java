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

@Test
public void testRemoveElementBooleanArray13() { 
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
public void testRemoveElementIntArray15() { 
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
@Test
public void testRemoveElementBooleanArray180() { 
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
public void testRemoveElementCharArray183() { 
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
public void testRemoveAllDoubleArray190() { 
     double[] array; 
     array = ArrayUtils.removeAll(new double[] { 1 }, 0); 
     assertTrue(Arrays.equals(ArrayUtils.EMPTY_DOUBLE_ARRAY, array)); 
     assertEquals(Double.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeAll(new double[] { 1, 2 }, 0); 
     assertTrue(Arrays.equals(new double[] { 2 }, array)); 
     assertEquals(Double.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeAll(new double[] { 1, 2 }, 1); 
     assertTrue(Arrays.equals(new double[] { 1 }, array)); 
     assertEquals(Double.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeAll(new double[] { 1, 2, 1 }, 1); 
     assertTrue(Arrays.equals(new double[] { 1, 1 }, array)); 
     assertEquals(Double.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeAll(new double[] { 1, 2 }, 0, 1); 
     assertTrue(Arrays.equals(ArrayUtils.EMPTY_DOUBLE_ARRAY, array)); 
     assertEquals(Double.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeAll(new double[] { 1, 2, 3 }, 0, 1); 
     assertTrue(Arrays.equals(new double[] { 3 }, array)); 
     assertEquals(Double.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeAll(new double[] { 1, 2, 3 }, 1, 2); 
     assertTrue(Arrays.equals(new double[] { 1 }, array)); 
     assertEquals(Double.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeAll(new double[] { 1, 2, 3 }, 0, 2); 
     assertTrue(Arrays.equals(new double[] { 2 }, array)); 
     assertEquals(Double.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeAll(new double[] { 1, 2, 3, 4, 5 }, 1, 3); 
     assertTrue(Arrays.equals(new double[] { 1, 3, 5 }, array)); 
     assertEquals(Double.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeAll(new double[] { 1, 2, 3, 4, 5 }, 0, 2, 4); 
     assertTrue(Arrays.equals(new double[] { 2, 4 }, array)); 
     assertEquals(Double.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeAll(new double[] { 1, 2, 3, 4, 5, 6, 7 }, 1, 3, 5); 
     assertTrue(Arrays.equals(new double[] { 1, 3, 5, 7 }, array)); 
     assertEquals(Double.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeAll(new double[] { 1, 2, 3, 4, 5, 6, 7 }, 0, 2, 4, 6); 
     assertTrue(Arrays.equals(new double[] { 2, 4, 6 }, array)); 
     assertEquals(Double.TYPE, array.getClass().getComponentType()); 
 }
@Test
@SuppressWarnings("cast") 
 public void testRemoveElementLongArray236() { 
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
@Test
public void testRemoveElementShortArray281() { 
     short[] array; 
     array = ArrayUtils.removeElements((short[]) null, (short) 1); 
     assertNull(array); 
     array = ArrayUtils.removeElements(ArrayUtils.EMPTY_SHORT_ARRAY, (short) 1); 
     assertTrue(Arrays.equals(ArrayUtils.EMPTY_SHORT_ARRAY, array)); 
     assertEquals(Short.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeElements(new short[] { 1 }, (short) 1); 
     assertTrue(Arrays.equals(ArrayUtils.EMPTY_SHORT_ARRAY, array)); 
     assertEquals(Short.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeElements(new short[] { 1, 2 }, (short) 1); 
     assertTrue(Arrays.equals(new short[] { 2 }, array)); 
     assertEquals(Short.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeElements(new short[] { 1, 2, 1 }, (short) 1); 
     assertTrue(Arrays.equals(new short[] { 2, 1 }, array)); 
     assertEquals(Short.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeElements((short[]) null, (short) 1, (short) 1); 
     assertNull(array); 
     array = ArrayUtils.removeElements(ArrayUtils.EMPTY_SHORT_ARRAY, (short) 1, (short) 1); 
     assertTrue(Arrays.equals(ArrayUtils.EMPTY_SHORT_ARRAY, array)); 
     assertEquals(Short.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeElements(new short[] { 1 }, (short) 1, (short) 1); 
     assertTrue(Arrays.equals(ArrayUtils.EMPTY_SHORT_ARRAY, array)); 
     assertEquals(Short.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeElements(new short[] { 1, 2 }, (short) 1, (short) 2); 
     assertTrue(Arrays.equals(ArrayUtils.EMPTY_SHORT_ARRAY, array)); 
     assertEquals(Short.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeElements(new short[] { 1, 2 }, (short) 1, (short) 1); 
     assertTrue(Arrays.equals(new short[] { 2 }, array)); 
     assertEquals(Short.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeElements(new short[] { 1, 2, 1 }, (short) 1, (short) 1); 
     assertTrue(Arrays.equals(new short[] { 2 }, array)); 
     assertEquals(Short.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeElements(new short[] { 1, 2, 1 }, (short) 1, (short) 2); 
     assertTrue(Arrays.equals(new short[] { 1 }, array)); 
     assertEquals(Short.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeElements(new short[] { 1, 2, 1 }, (short) 1, (short) 1, (short) 1, (short) 1); 
     assertTrue(Arrays.equals(new short[] { 2 }, array)); 
     assertEquals(Short.TYPE, array.getClass().getComponentType()); 
 }
@Test
@SuppressWarnings("cast") 
 public void testRemoveElementLongArray367() { 
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
@Test
@SuppressWarnings("cast") 
 public void testRemoveElementDoubleArray405() { 
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
public void testRemoveElementBooleanArray418() { 
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
@SuppressWarnings("cast") 
 public void testRemoveElementDoubleArray627() { 
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
public void testRemoveAllDoubleArray653() { 
     double[] array; 
     array = ArrayUtils.removeAll(new double[] { 1 }, 0); 
     assertTrue(Arrays.equals(ArrayUtils.EMPTY_DOUBLE_ARRAY, array)); 
     assertEquals(Double.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeAll(new double[] { 1, 2 }, 0); 
     assertTrue(Arrays.equals(new double[] { 2 }, array)); 
     assertEquals(Double.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeAll(new double[] { 1, 2 }, 1); 
     assertTrue(Arrays.equals(new double[] { 1 }, array)); 
     assertEquals(Double.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeAll(new double[] { 1, 2, 1 }, 1); 
     assertTrue(Arrays.equals(new double[] { 1, 1 }, array)); 
     assertEquals(Double.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeAll(new double[] { 1, 2 }, 0, 1); 
     assertTrue(Arrays.equals(ArrayUtils.EMPTY_DOUBLE_ARRAY, array)); 
     assertEquals(Double.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeAll(new double[] { 1, 2, 3 }, 0, 1); 
     assertTrue(Arrays.equals(new double[] { 3 }, array)); 
     assertEquals(Double.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeAll(new double[] { 1, 2, 3 }, 1, 2); 
     assertTrue(Arrays.equals(new double[] { 1 }, array)); 
     assertEquals(Double.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeAll(new double[] { 1, 2, 3 }, 0, 2); 
     assertTrue(Arrays.equals(new double[] { 2 }, array)); 
     assertEquals(Double.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeAll(new double[] { 1, 2, 3, 4, 5 }, 1, 3); 
     assertTrue(Arrays.equals(new double[] { 1, 3, 5 }, array)); 
     assertEquals(Double.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeAll(new double[] { 1, 2, 3, 4, 5 }, 0, 2, 4); 
     assertTrue(Arrays.equals(new double[] { 2, 4 }, array)); 
     assertEquals(Double.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeAll(new double[] { 1, 2, 3, 4, 5, 6, 7 }, 1, 3, 5); 
     assertTrue(Arrays.equals(new double[] { 1, 3, 5, 7 }, array)); 
     assertEquals(Double.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeAll(new double[] { 1, 2, 3, 4, 5, 6, 7 }, 0, 2, 4, 6); 
     assertTrue(Arrays.equals(new double[] { 2, 4, 6 }, array)); 
     assertEquals(Double.TYPE, array.getClass().getComponentType()); 
 }
@Test
@SuppressWarnings("cast") 
 public void testRemoveElementDoubleArray677() { 
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
public void testRemoveElementBooleanArray730() { 
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
public void testRemoveElementIntArray771() { 
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
 public void testRemoveAllLongArrayOutOfBoundsIndex906() { 
     ArrayUtils.removeAll(new long[] { 1, 2 }, 2); 
 }
@Test(expected = IndexOutOfBoundsException.class) 
 public void testRemoveAllLongArrayOutOfBoundsIndex917() { 
     ArrayUtils.removeAll(new long[] { 1, 2 }, 2); 
 }
@Test
public void testRemoveElementIntArray946() { 
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
@Test
public void testRemoveElementShortArray1040() { 
     short[] array; 
     array = ArrayUtils.removeElements((short[]) null, (short) 1); 
     assertNull(array); 
     array = ArrayUtils.removeElements(ArrayUtils.EMPTY_SHORT_ARRAY, (short) 1); 
     assertTrue(Arrays.equals(ArrayUtils.EMPTY_SHORT_ARRAY, array)); 
     assertEquals(Short.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeElements(new short[] { 1 }, (short) 1); 
     assertTrue(Arrays.equals(ArrayUtils.EMPTY_SHORT_ARRAY, array)); 
     assertEquals(Short.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeElements(new short[] { 1, 2 }, (short) 1); 
     assertTrue(Arrays.equals(new short[] { 2 }, array)); 
     assertEquals(Short.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeElements(new short[] { 1, 2, 1 }, (short) 1); 
     assertTrue(Arrays.equals(new short[] { 2, 1 }, array)); 
     assertEquals(Short.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeElements((short[]) null, (short) 1, (short) 1); 
     assertNull(array); 
     array = ArrayUtils.removeElements(ArrayUtils.EMPTY_SHORT_ARRAY, (short) 1, (short) 1); 
     assertTrue(Arrays.equals(ArrayUtils.EMPTY_SHORT_ARRAY, array)); 
     assertEquals(Short.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeElements(new short[] { 1 }, (short) 1, (short) 1); 
     assertTrue(Arrays.equals(ArrayUtils.EMPTY_SHORT_ARRAY, array)); 
     assertEquals(Short.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeElements(new short[] { 1, 2 }, (short) 1, (short) 2); 
     assertTrue(Arrays.equals(ArrayUtils.EMPTY_SHORT_ARRAY, array)); 
     assertEquals(Short.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeElements(new short[] { 1, 2 }, (short) 1, (short) 1); 
     assertTrue(Arrays.equals(new short[] { 2 }, array)); 
     assertEquals(Short.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeElements(new short[] { 1, 2, 1 }, (short) 1, (short) 1); 
     assertTrue(Arrays.equals(new short[] { 2 }, array)); 
     assertEquals(Short.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeElements(new short[] { 1, 2, 1 }, (short) 1, (short) 2); 
     assertTrue(Arrays.equals(new short[] { 1 }, array)); 
     assertEquals(Short.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeElements(new short[] { 1, 2, 1 }, (short) 1, (short) 1, (short) 1, (short) 1); 
     assertTrue(Arrays.equals(new short[] { 2 }, array)); 
     assertEquals(Short.TYPE, array.getClass().getComponentType()); 
 }
@Test
public void testRemoveElementBooleanArray1051() { 
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
public void testRemoveElementCharArray1206() { 
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
 public void testRemoveElementLongArray1215() { 
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
@Test
public void testRemoveElementShortArray1267() { 
     short[] array; 
     array = ArrayUtils.removeElements((short[]) null, (short) 1); 
     assertNull(array); 
     array = ArrayUtils.removeElements(ArrayUtils.EMPTY_SHORT_ARRAY, (short) 1); 
     assertTrue(Arrays.equals(ArrayUtils.EMPTY_SHORT_ARRAY, array)); 
     assertEquals(Short.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeElements(new short[] { 1 }, (short) 1); 
     assertTrue(Arrays.equals(ArrayUtils.EMPTY_SHORT_ARRAY, array)); 
     assertEquals(Short.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeElements(new short[] { 1, 2 }, (short) 1); 
     assertTrue(Arrays.equals(new short[] { 2 }, array)); 
     assertEquals(Short.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeElements(new short[] { 1, 2, 1 }, (short) 1); 
     assertTrue(Arrays.equals(new short[] { 2, 1 }, array)); 
     assertEquals(Short.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeElements((short[]) null, (short) 1, (short) 1); 
     assertNull(array); 
     array = ArrayUtils.removeElements(ArrayUtils.EMPTY_SHORT_ARRAY, (short) 1, (short) 1); 
     assertTrue(Arrays.equals(ArrayUtils.EMPTY_SHORT_ARRAY, array)); 
     assertEquals(Short.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeElements(new short[] { 1 }, (short) 1, (short) 1); 
     assertTrue(Arrays.equals(ArrayUtils.EMPTY_SHORT_ARRAY, array)); 
     assertEquals(Short.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeElements(new short[] { 1, 2 }, (short) 1, (short) 2); 
     assertTrue(Arrays.equals(ArrayUtils.EMPTY_SHORT_ARRAY, array)); 
     assertEquals(Short.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeElements(new short[] { 1, 2 }, (short) 1, (short) 1); 
     assertTrue(Arrays.equals(new short[] { 2 }, array)); 
     assertEquals(Short.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeElements(new short[] { 1, 2, 1 }, (short) 1, (short) 1); 
     assertTrue(Arrays.equals(new short[] { 2 }, array)); 
     assertEquals(Short.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeElements(new short[] { 1, 2, 1 }, (short) 1, (short) 2); 
     assertTrue(Arrays.equals(new short[] { 1 }, array)); 
     assertEquals(Short.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeElements(new short[] { 1, 2, 1 }, (short) 1, (short) 1, (short) 1, (short) 1); 
     assertTrue(Arrays.equals(new short[] { 2 }, array)); 
     assertEquals(Short.TYPE, array.getClass().getComponentType()); 
 }
@Test(expected = IndexOutOfBoundsException.class) 
 public void testRemoveAllCharArrayNegativeIndex1325() { 
     ArrayUtils.removeAll(new char[] { 'a', 'b' }, -1); 
 }
@Test
public void testRemoveElementCharArray1350() { 
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
public void testRemoveElementCharArray1461() { 
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
@Test(expected = IndexOutOfBoundsException.class) 
 public void testRemoveAllCharArrayNegativeIndex1499() { 
     ArrayUtils.removeAll(new char[] { 'a', 'b' }, -1); 
 }
@Test
public void testRemoveElementIntArray1524() { 
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
@Test
public void testRemoveElementShortArray1540() { 
     short[] array; 
     array = ArrayUtils.removeElements((short[]) null, (short) 1); 
     assertNull(array); 
     array = ArrayUtils.removeElements(ArrayUtils.EMPTY_SHORT_ARRAY, (short) 1); 
     assertTrue(Arrays.equals(ArrayUtils.EMPTY_SHORT_ARRAY, array)); 
     assertEquals(Short.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeElements(new short[] { 1 }, (short) 1); 
     assertTrue(Arrays.equals(ArrayUtils.EMPTY_SHORT_ARRAY, array)); 
     assertEquals(Short.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeElements(new short[] { 1, 2 }, (short) 1); 
     assertTrue(Arrays.equals(new short[] { 2 }, array)); 
     assertEquals(Short.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeElements(new short[] { 1, 2, 1 }, (short) 1); 
     assertTrue(Arrays.equals(new short[] { 2, 1 }, array)); 
     assertEquals(Short.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeElements((short[]) null, (short) 1, (short) 1); 
     assertNull(array); 
     array = ArrayUtils.removeElements(ArrayUtils.EMPTY_SHORT_ARRAY, (short) 1, (short) 1); 
     assertTrue(Arrays.equals(ArrayUtils.EMPTY_SHORT_ARRAY, array)); 
     assertEquals(Short.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeElements(new short[] { 1 }, (short) 1, (short) 1); 
     assertTrue(Arrays.equals(ArrayUtils.EMPTY_SHORT_ARRAY, array)); 
     assertEquals(Short.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeElements(new short[] { 1, 2 }, (short) 1, (short) 2); 
     assertTrue(Arrays.equals(ArrayUtils.EMPTY_SHORT_ARRAY, array)); 
     assertEquals(Short.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeElements(new short[] { 1, 2 }, (short) 1, (short) 1); 
     assertTrue(Arrays.equals(new short[] { 2 }, array)); 
     assertEquals(Short.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeElements(new short[] { 1, 2, 1 }, (short) 1, (short) 1); 
     assertTrue(Arrays.equals(new short[] { 2 }, array)); 
     assertEquals(Short.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeElements(new short[] { 1, 2, 1 }, (short) 1, (short) 2); 
     assertTrue(Arrays.equals(new short[] { 1 }, array)); 
     assertEquals(Short.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeElements(new short[] { 1, 2, 1 }, (short) 1, (short) 1, (short) 1, (short) 1); 
     assertTrue(Arrays.equals(new short[] { 2 }, array)); 
     assertEquals(Short.TYPE, array.getClass().getComponentType()); 
 }
@Test(expected = IndexOutOfBoundsException.class) 
 public void testRemoveAllObjectArrayOutOfBoundsIndex1837() { 
     ArrayUtils.removeAll(new Object[] { "a", "b" }, 2); 
 }
@Test
public void testRemoveAllDoubleArray1847() { 
     double[] array; 
     array = ArrayUtils.removeAll(new double[] { 1 }, 0); 
     assertTrue(Arrays.equals(ArrayUtils.EMPTY_DOUBLE_ARRAY, array)); 
     assertEquals(Double.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeAll(new double[] { 1, 2 }, 0); 
     assertTrue(Arrays.equals(new double[] { 2 }, array)); 
     assertEquals(Double.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeAll(new double[] { 1, 2 }, 1); 
     assertTrue(Arrays.equals(new double[] { 1 }, array)); 
     assertEquals(Double.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeAll(new double[] { 1, 2, 1 }, 1); 
     assertTrue(Arrays.equals(new double[] { 1, 1 }, array)); 
     assertEquals(Double.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeAll(new double[] { 1, 2 }, 0, 1); 
     assertTrue(Arrays.equals(ArrayUtils.EMPTY_DOUBLE_ARRAY, array)); 
     assertEquals(Double.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeAll(new double[] { 1, 2, 3 }, 0, 1); 
     assertTrue(Arrays.equals(new double[] { 3 }, array)); 
     assertEquals(Double.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeAll(new double[] { 1, 2, 3 }, 1, 2); 
     assertTrue(Arrays.equals(new double[] { 1 }, array)); 
     assertEquals(Double.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeAll(new double[] { 1, 2, 3 }, 0, 2); 
     assertTrue(Arrays.equals(new double[] { 2 }, array)); 
     assertEquals(Double.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeAll(new double[] { 1, 2, 3, 4, 5 }, 1, 3); 
     assertTrue(Arrays.equals(new double[] { 1, 3, 5 }, array)); 
     assertEquals(Double.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeAll(new double[] { 1, 2, 3, 4, 5 }, 0, 2, 4); 
     assertTrue(Arrays.equals(new double[] { 2, 4 }, array)); 
     assertEquals(Double.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeAll(new double[] { 1, 2, 3, 4, 5, 6, 7 }, 1, 3, 5); 
     assertTrue(Arrays.equals(new double[] { 1, 3, 5, 7 }, array)); 
     assertEquals(Double.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeAll(new double[] { 1, 2, 3, 4, 5, 6, 7 }, 0, 2, 4, 6); 
     assertTrue(Arrays.equals(new double[] { 2, 4, 6 }, array)); 
     assertEquals(Double.TYPE, array.getClass().getComponentType()); 
 }
@Test
@SuppressWarnings("cast") 
 public void testRemoveElementDoubleArray1860() { 
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
public void testRemoveElementShortArray1939() { 
     short[] array; 
     array = ArrayUtils.removeElements((short[]) null, (short) 1); 
     assertNull(array); 
     array = ArrayUtils.removeElements(ArrayUtils.EMPTY_SHORT_ARRAY, (short) 1); 
     assertTrue(Arrays.equals(ArrayUtils.EMPTY_SHORT_ARRAY, array)); 
     assertEquals(Short.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeElements(new short[] { 1 }, (short) 1); 
     assertTrue(Arrays.equals(ArrayUtils.EMPTY_SHORT_ARRAY, array)); 
     assertEquals(Short.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeElements(new short[] { 1, 2 }, (short) 1); 
     assertTrue(Arrays.equals(new short[] { 2 }, array)); 
     assertEquals(Short.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeElements(new short[] { 1, 2, 1 }, (short) 1); 
     assertTrue(Arrays.equals(new short[] { 2, 1 }, array)); 
     assertEquals(Short.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeElements((short[]) null, (short) 1, (short) 1); 
     assertNull(array); 
     array = ArrayUtils.removeElements(ArrayUtils.EMPTY_SHORT_ARRAY, (short) 1, (short) 1); 
     assertTrue(Arrays.equals(ArrayUtils.EMPTY_SHORT_ARRAY, array)); 
     assertEquals(Short.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeElements(new short[] { 1 }, (short) 1, (short) 1); 
     assertTrue(Arrays.equals(ArrayUtils.EMPTY_SHORT_ARRAY, array)); 
     assertEquals(Short.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeElements(new short[] { 1, 2 }, (short) 1, (short) 2); 
     assertTrue(Arrays.equals(ArrayUtils.EMPTY_SHORT_ARRAY, array)); 
     assertEquals(Short.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeElements(new short[] { 1, 2 }, (short) 1, (short) 1); 
     assertTrue(Arrays.equals(new short[] { 2 }, array)); 
     assertEquals(Short.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeElements(new short[] { 1, 2, 1 }, (short) 1, (short) 1); 
     assertTrue(Arrays.equals(new short[] { 2 }, array)); 
     assertEquals(Short.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeElements(new short[] { 1, 2, 1 }, (short) 1, (short) 2); 
     assertTrue(Arrays.equals(new short[] { 1 }, array)); 
     assertEquals(Short.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeElements(new short[] { 1, 2, 1 }, (short) 1, (short) 1, (short) 1, (short) 1); 
     assertTrue(Arrays.equals(new short[] { 2 }, array)); 
     assertEquals(Short.TYPE, array.getClass().getComponentType()); 
 }
@Test
public void testRemoveElementIntArray2015() { 
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
@Test
public void testRemoveElementShortArray2018() { 
     short[] array; 
     array = ArrayUtils.removeElements((short[]) null, (short) 1); 
     assertNull(array); 
     array = ArrayUtils.removeElements(ArrayUtils.EMPTY_SHORT_ARRAY, (short) 1); 
     assertTrue(Arrays.equals(ArrayUtils.EMPTY_SHORT_ARRAY, array)); 
     assertEquals(Short.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeElements(new short[] { 1 }, (short) 1); 
     assertTrue(Arrays.equals(ArrayUtils.EMPTY_SHORT_ARRAY, array)); 
     assertEquals(Short.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeElements(new short[] { 1, 2 }, (short) 1); 
     assertTrue(Arrays.equals(new short[] { 2 }, array)); 
     assertEquals(Short.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeElements(new short[] { 1, 2, 1 }, (short) 1); 
     assertTrue(Arrays.equals(new short[] { 2, 1 }, array)); 
     assertEquals(Short.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeElements((short[]) null, (short) 1, (short) 1); 
     assertNull(array); 
     array = ArrayUtils.removeElements(ArrayUtils.EMPTY_SHORT_ARRAY, (short) 1, (short) 1); 
     assertTrue(Arrays.equals(ArrayUtils.EMPTY_SHORT_ARRAY, array)); 
     assertEquals(Short.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeElements(new short[] { 1 }, (short) 1, (short) 1); 
     assertTrue(Arrays.equals(ArrayUtils.EMPTY_SHORT_ARRAY, array)); 
     assertEquals(Short.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeElements(new short[] { 1, 2 }, (short) 1, (short) 2); 
     assertTrue(Arrays.equals(ArrayUtils.EMPTY_SHORT_ARRAY, array)); 
     assertEquals(Short.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeElements(new short[] { 1, 2 }, (short) 1, (short) 1); 
     assertTrue(Arrays.equals(new short[] { 2 }, array)); 
     assertEquals(Short.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeElements(new short[] { 1, 2, 1 }, (short) 1, (short) 1); 
     assertTrue(Arrays.equals(new short[] { 2 }, array)); 
     assertEquals(Short.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeElements(new short[] { 1, 2, 1 }, (short) 1, (short) 2); 
     assertTrue(Arrays.equals(new short[] { 1 }, array)); 
     assertEquals(Short.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeElements(new short[] { 1, 2, 1 }, (short) 1, (short) 1, (short) 1, (short) 1); 
     assertTrue(Arrays.equals(new short[] { 2 }, array)); 
     assertEquals(Short.TYPE, array.getClass().getComponentType()); 
 }
@Test
@SuppressWarnings("cast") 
 public void testRemoveElementLongArray2083() { 
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
 public void testRemoveAllByteArrayNegativeIndex2087() { 
     ArrayUtils.removeAll(new byte[] { 1, 2 }, -1); 
 }
@Test
public void testRemoveAllDoubleArray2141() { 
     double[] array; 
     array = ArrayUtils.removeAll(new double[] { 1 }, 0); 
     assertTrue(Arrays.equals(ArrayUtils.EMPTY_DOUBLE_ARRAY, array)); 
     assertEquals(Double.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeAll(new double[] { 1, 2 }, 0); 
     assertTrue(Arrays.equals(new double[] { 2 }, array)); 
     assertEquals(Double.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeAll(new double[] { 1, 2 }, 1); 
     assertTrue(Arrays.equals(new double[] { 1 }, array)); 
     assertEquals(Double.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeAll(new double[] { 1, 2, 1 }, 1); 
     assertTrue(Arrays.equals(new double[] { 1, 1 }, array)); 
     assertEquals(Double.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeAll(new double[] { 1, 2 }, 0, 1); 
     assertTrue(Arrays.equals(ArrayUtils.EMPTY_DOUBLE_ARRAY, array)); 
     assertEquals(Double.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeAll(new double[] { 1, 2, 3 }, 0, 1); 
     assertTrue(Arrays.equals(new double[] { 3 }, array)); 
     assertEquals(Double.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeAll(new double[] { 1, 2, 3 }, 1, 2); 
     assertTrue(Arrays.equals(new double[] { 1 }, array)); 
     assertEquals(Double.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeAll(new double[] { 1, 2, 3 }, 0, 2); 
     assertTrue(Arrays.equals(new double[] { 2 }, array)); 
     assertEquals(Double.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeAll(new double[] { 1, 2, 3, 4, 5 }, 1, 3); 
     assertTrue(Arrays.equals(new double[] { 1, 3, 5 }, array)); 
     assertEquals(Double.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeAll(new double[] { 1, 2, 3, 4, 5 }, 0, 2, 4); 
     assertTrue(Arrays.equals(new double[] { 2, 4 }, array)); 
     assertEquals(Double.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeAll(new double[] { 1, 2, 3, 4, 5, 6, 7 }, 1, 3, 5); 
     assertTrue(Arrays.equals(new double[] { 1, 3, 5, 7 }, array)); 
     assertEquals(Double.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeAll(new double[] { 1, 2, 3, 4, 5, 6, 7 }, 0, 2, 4, 6); 
     assertTrue(Arrays.equals(new double[] { 2, 4, 6 }, array)); 
     assertEquals(Double.TYPE, array.getClass().getComponentType()); 
 }
@Test
public void testRemoveAllDoubleArray2149() { 
     double[] array; 
     array = ArrayUtils.removeAll(new double[] { 1 }, 0); 
     assertTrue(Arrays.equals(ArrayUtils.EMPTY_DOUBLE_ARRAY, array)); 
     assertEquals(Double.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeAll(new double[] { 1, 2 }, 0); 
     assertTrue(Arrays.equals(new double[] { 2 }, array)); 
     assertEquals(Double.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeAll(new double[] { 1, 2 }, 1); 
     assertTrue(Arrays.equals(new double[] { 1 }, array)); 
     assertEquals(Double.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeAll(new double[] { 1, 2, 1 }, 1); 
     assertTrue(Arrays.equals(new double[] { 1, 1 }, array)); 
     assertEquals(Double.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeAll(new double[] { 1, 2 }, 0, 1); 
     assertTrue(Arrays.equals(ArrayUtils.EMPTY_DOUBLE_ARRAY, array)); 
     assertEquals(Double.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeAll(new double[] { 1, 2, 3 }, 0, 1); 
     assertTrue(Arrays.equals(new double[] { 3 }, array)); 
     assertEquals(Double.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeAll(new double[] { 1, 2, 3 }, 1, 2); 
     assertTrue(Arrays.equals(new double[] { 1 }, array)); 
     assertEquals(Double.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeAll(new double[] { 1, 2, 3 }, 0, 2); 
     assertTrue(Arrays.equals(new double[] { 2 }, array)); 
     assertEquals(Double.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeAll(new double[] { 1, 2, 3, 4, 5 }, 1, 3); 
     assertTrue(Arrays.equals(new double[] { 1, 3, 5 }, array)); 
     assertEquals(Double.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeAll(new double[] { 1, 2, 3, 4, 5 }, 0, 2, 4); 
     assertTrue(Arrays.equals(new double[] { 2, 4 }, array)); 
     assertEquals(Double.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeAll(new double[] { 1, 2, 3, 4, 5, 6, 7 }, 1, 3, 5); 
     assertTrue(Arrays.equals(new double[] { 1, 3, 5, 7 }, array)); 
     assertEquals(Double.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeAll(new double[] { 1, 2, 3, 4, 5, 6, 7 }, 0, 2, 4, 6); 
     assertTrue(Arrays.equals(new double[] { 2, 4, 6 }, array)); 
     assertEquals(Double.TYPE, array.getClass().getComponentType()); 
 }
@Test
@SuppressWarnings("cast") 
 public void testRemoveElementLongArray2161() { 
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
@Test
@SuppressWarnings("cast") 
 public void testRemoveElementDoubleArray2250() { 
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
public void testRemoveElementCharArray2270() { 
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
@Test(expected = IndexOutOfBoundsException.class) 
 public void testRemoveAllLongArrayOutOfBoundsIndex2288() { 
     ArrayUtils.removeAll(new long[] { 1, 2 }, 2); 
 }
@Test
public void testRemoveElementIntArray2410() { 
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
@Test
@SuppressWarnings("cast") 
 public void testRemoveElementDoubleArray2472() { 
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
@SuppressWarnings("cast") 
 public void testRemoveElementLongArray2521() { 
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
 public void testRemoveAllLongArrayOutOfBoundsIndex2530() { 
     ArrayUtils.removeAll(new long[] { 1, 2 }, 2); 
 }
@Test
public void testRemoveElementBooleanArray2692() { 
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
@SuppressWarnings("cast") 
 public void testRemoveElementLongArray2694() { 
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
 public void testRemoveAllLongArrayOutOfBoundsIndex2838() { 
     ArrayUtils.removeAll(new long[] { 1, 2 }, 2); 
 }
@Test
public void testRemoveElementIntArray3011() { 
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
@Test
@SuppressWarnings("cast") 
 public void testRemoveElementLongArray3104() { 
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
@Test
public void testRemoveAllDoubleArray3121() { 
     double[] array; 
     array = ArrayUtils.removeAll(new double[] { 1 }, 0); 
     assertTrue(Arrays.equals(ArrayUtils.EMPTY_DOUBLE_ARRAY, array)); 
     assertEquals(Double.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeAll(new double[] { 1, 2 }, 0); 
     assertTrue(Arrays.equals(new double[] { 2 }, array)); 
     assertEquals(Double.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeAll(new double[] { 1, 2 }, 1); 
     assertTrue(Arrays.equals(new double[] { 1 }, array)); 
     assertEquals(Double.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeAll(new double[] { 1, 2, 1 }, 1); 
     assertTrue(Arrays.equals(new double[] { 1, 1 }, array)); 
     assertEquals(Double.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeAll(new double[] { 1, 2 }, 0, 1); 
     assertTrue(Arrays.equals(ArrayUtils.EMPTY_DOUBLE_ARRAY, array)); 
     assertEquals(Double.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeAll(new double[] { 1, 2, 3 }, 0, 1); 
     assertTrue(Arrays.equals(new double[] { 3 }, array)); 
     assertEquals(Double.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeAll(new double[] { 1, 2, 3 }, 1, 2); 
     assertTrue(Arrays.equals(new double[] { 1 }, array)); 
     assertEquals(Double.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeAll(new double[] { 1, 2, 3 }, 0, 2); 
     assertTrue(Arrays.equals(new double[] { 2 }, array)); 
     assertEquals(Double.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeAll(new double[] { 1, 2, 3, 4, 5 }, 1, 3); 
     assertTrue(Arrays.equals(new double[] { 1, 3, 5 }, array)); 
     assertEquals(Double.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeAll(new double[] { 1, 2, 3, 4, 5 }, 0, 2, 4); 
     assertTrue(Arrays.equals(new double[] { 2, 4 }, array)); 
     assertEquals(Double.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeAll(new double[] { 1, 2, 3, 4, 5, 6, 7 }, 1, 3, 5); 
     assertTrue(Arrays.equals(new double[] { 1, 3, 5, 7 }, array)); 
     assertEquals(Double.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeAll(new double[] { 1, 2, 3, 4, 5, 6, 7 }, 0, 2, 4, 6); 
     assertTrue(Arrays.equals(new double[] { 2, 4, 6 }, array)); 
     assertEquals(Double.TYPE, array.getClass().getComponentType()); 
 }
@Test(expected = IndexOutOfBoundsException.class) 
 public void testRemoveAllLongArrayOutOfBoundsIndex3167() { 
     ArrayUtils.removeAll(new long[] { 1, 2 }, 2); 
 }
@Test
public void testRemoveElementIntArray3253() { 
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
@Test
public void testRemoveElementShortArray3307() { 
     short[] array; 
     array = ArrayUtils.removeElements((short[]) null, (short) 1); 
     assertNull(array); 
     array = ArrayUtils.removeElements(ArrayUtils.EMPTY_SHORT_ARRAY, (short) 1); 
     assertTrue(Arrays.equals(ArrayUtils.EMPTY_SHORT_ARRAY, array)); 
     assertEquals(Short.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeElements(new short[] { 1 }, (short) 1); 
     assertTrue(Arrays.equals(ArrayUtils.EMPTY_SHORT_ARRAY, array)); 
     assertEquals(Short.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeElements(new short[] { 1, 2 }, (short) 1); 
     assertTrue(Arrays.equals(new short[] { 2 }, array)); 
     assertEquals(Short.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeElements(new short[] { 1, 2, 1 }, (short) 1); 
     assertTrue(Arrays.equals(new short[] { 2, 1 }, array)); 
     assertEquals(Short.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeElements((short[]) null, (short) 1, (short) 1); 
     assertNull(array); 
     array = ArrayUtils.removeElements(ArrayUtils.EMPTY_SHORT_ARRAY, (short) 1, (short) 1); 
     assertTrue(Arrays.equals(ArrayUtils.EMPTY_SHORT_ARRAY, array)); 
     assertEquals(Short.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeElements(new short[] { 1 }, (short) 1, (short) 1); 
     assertTrue(Arrays.equals(ArrayUtils.EMPTY_SHORT_ARRAY, array)); 
     assertEquals(Short.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeElements(new short[] { 1, 2 }, (short) 1, (short) 2); 
     assertTrue(Arrays.equals(ArrayUtils.EMPTY_SHORT_ARRAY, array)); 
     assertEquals(Short.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeElements(new short[] { 1, 2 }, (short) 1, (short) 1); 
     assertTrue(Arrays.equals(new short[] { 2 }, array)); 
     assertEquals(Short.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeElements(new short[] { 1, 2, 1 }, (short) 1, (short) 1); 
     assertTrue(Arrays.equals(new short[] { 2 }, array)); 
     assertEquals(Short.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeElements(new short[] { 1, 2, 1 }, (short) 1, (short) 2); 
     assertTrue(Arrays.equals(new short[] { 1 }, array)); 
     assertEquals(Short.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeElements(new short[] { 1, 2, 1 }, (short) 1, (short) 1, (short) 1, (short) 1); 
     assertTrue(Arrays.equals(new short[] { 2 }, array)); 
     assertEquals(Short.TYPE, array.getClass().getComponentType()); 
 }
@Test(expected = IndexOutOfBoundsException.class) 
 public void testRemoveAllLongArrayOutOfBoundsIndex3313() { 
     ArrayUtils.removeAll(new long[] { 1, 2 }, 2); 
 }
@Test
public void testRemoveAllDoubleArray3357() { 
     double[] array; 
     array = ArrayUtils.removeAll(new double[] { 1 }, 0); 
     assertTrue(Arrays.equals(ArrayUtils.EMPTY_DOUBLE_ARRAY, array)); 
     assertEquals(Double.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeAll(new double[] { 1, 2 }, 0); 
     assertTrue(Arrays.equals(new double[] { 2 }, array)); 
     assertEquals(Double.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeAll(new double[] { 1, 2 }, 1); 
     assertTrue(Arrays.equals(new double[] { 1 }, array)); 
     assertEquals(Double.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeAll(new double[] { 1, 2, 1 }, 1); 
     assertTrue(Arrays.equals(new double[] { 1, 1 }, array)); 
     assertEquals(Double.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeAll(new double[] { 1, 2 }, 0, 1); 
     assertTrue(Arrays.equals(ArrayUtils.EMPTY_DOUBLE_ARRAY, array)); 
     assertEquals(Double.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeAll(new double[] { 1, 2, 3 }, 0, 1); 
     assertTrue(Arrays.equals(new double[] { 3 }, array)); 
     assertEquals(Double.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeAll(new double[] { 1, 2, 3 }, 1, 2); 
     assertTrue(Arrays.equals(new double[] { 1 }, array)); 
     assertEquals(Double.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeAll(new double[] { 1, 2, 3 }, 0, 2); 
     assertTrue(Arrays.equals(new double[] { 2 }, array)); 
     assertEquals(Double.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeAll(new double[] { 1, 2, 3, 4, 5 }, 1, 3); 
     assertTrue(Arrays.equals(new double[] { 1, 3, 5 }, array)); 
     assertEquals(Double.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeAll(new double[] { 1, 2, 3, 4, 5 }, 0, 2, 4); 
     assertTrue(Arrays.equals(new double[] { 2, 4 }, array)); 
     assertEquals(Double.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeAll(new double[] { 1, 2, 3, 4, 5, 6, 7 }, 1, 3, 5); 
     assertTrue(Arrays.equals(new double[] { 1, 3, 5, 7 }, array)); 
     assertEquals(Double.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeAll(new double[] { 1, 2, 3, 4, 5, 6, 7 }, 0, 2, 4, 6); 
     assertTrue(Arrays.equals(new double[] { 2, 4, 6 }, array)); 
     assertEquals(Double.TYPE, array.getClass().getComponentType()); 
 }
@Test
public void testRemoveElementBooleanArray3423() { 
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
public void testRemoveElementShortArray3436() { 
     short[] array; 
     array = ArrayUtils.removeElements((short[]) null, (short) 1); 
     assertNull(array); 
     array = ArrayUtils.removeElements(ArrayUtils.EMPTY_SHORT_ARRAY, (short) 1); 
     assertTrue(Arrays.equals(ArrayUtils.EMPTY_SHORT_ARRAY, array)); 
     assertEquals(Short.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeElements(new short[] { 1 }, (short) 1); 
     assertTrue(Arrays.equals(ArrayUtils.EMPTY_SHORT_ARRAY, array)); 
     assertEquals(Short.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeElements(new short[] { 1, 2 }, (short) 1); 
     assertTrue(Arrays.equals(new short[] { 2 }, array)); 
     assertEquals(Short.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeElements(new short[] { 1, 2, 1 }, (short) 1); 
     assertTrue(Arrays.equals(new short[] { 2, 1 }, array)); 
     assertEquals(Short.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeElements((short[]) null, (short) 1, (short) 1); 
     assertNull(array); 
     array = ArrayUtils.removeElements(ArrayUtils.EMPTY_SHORT_ARRAY, (short) 1, (short) 1); 
     assertTrue(Arrays.equals(ArrayUtils.EMPTY_SHORT_ARRAY, array)); 
     assertEquals(Short.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeElements(new short[] { 1 }, (short) 1, (short) 1); 
     assertTrue(Arrays.equals(ArrayUtils.EMPTY_SHORT_ARRAY, array)); 
     assertEquals(Short.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeElements(new short[] { 1, 2 }, (short) 1, (short) 2); 
     assertTrue(Arrays.equals(ArrayUtils.EMPTY_SHORT_ARRAY, array)); 
     assertEquals(Short.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeElements(new short[] { 1, 2 }, (short) 1, (short) 1); 
     assertTrue(Arrays.equals(new short[] { 2 }, array)); 
     assertEquals(Short.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeElements(new short[] { 1, 2, 1 }, (short) 1, (short) 1); 
     assertTrue(Arrays.equals(new short[] { 2 }, array)); 
     assertEquals(Short.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeElements(new short[] { 1, 2, 1 }, (short) 1, (short) 2); 
     assertTrue(Arrays.equals(new short[] { 1 }, array)); 
     assertEquals(Short.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeElements(new short[] { 1, 2, 1 }, (short) 1, (short) 1, (short) 1, (short) 1); 
     assertTrue(Arrays.equals(new short[] { 2 }, array)); 
     assertEquals(Short.TYPE, array.getClass().getComponentType()); 
 }
@Test
public void testRemoveElementBooleanArray3453() { 
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
public void testRemoveElementShortArray3469() { 
     short[] array; 
     array = ArrayUtils.removeElements((short[]) null, (short) 1); 
     assertNull(array); 
     array = ArrayUtils.removeElements(ArrayUtils.EMPTY_SHORT_ARRAY, (short) 1); 
     assertTrue(Arrays.equals(ArrayUtils.EMPTY_SHORT_ARRAY, array)); 
     assertEquals(Short.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeElements(new short[] { 1 }, (short) 1); 
     assertTrue(Arrays.equals(ArrayUtils.EMPTY_SHORT_ARRAY, array)); 
     assertEquals(Short.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeElements(new short[] { 1, 2 }, (short) 1); 
     assertTrue(Arrays.equals(new short[] { 2 }, array)); 
     assertEquals(Short.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeElements(new short[] { 1, 2, 1 }, (short) 1); 
     assertTrue(Arrays.equals(new short[] { 2, 1 }, array)); 
     assertEquals(Short.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeElements((short[]) null, (short) 1, (short) 1); 
     assertNull(array); 
     array = ArrayUtils.removeElements(ArrayUtils.EMPTY_SHORT_ARRAY, (short) 1, (short) 1); 
     assertTrue(Arrays.equals(ArrayUtils.EMPTY_SHORT_ARRAY, array)); 
     assertEquals(Short.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeElements(new short[] { 1 }, (short) 1, (short) 1); 
     assertTrue(Arrays.equals(ArrayUtils.EMPTY_SHORT_ARRAY, array)); 
     assertEquals(Short.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeElements(new short[] { 1, 2 }, (short) 1, (short) 2); 
     assertTrue(Arrays.equals(ArrayUtils.EMPTY_SHORT_ARRAY, array)); 
     assertEquals(Short.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeElements(new short[] { 1, 2 }, (short) 1, (short) 1); 
     assertTrue(Arrays.equals(new short[] { 2 }, array)); 
     assertEquals(Short.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeElements(new short[] { 1, 2, 1 }, (short) 1, (short) 1); 
     assertTrue(Arrays.equals(new short[] { 2 }, array)); 
     assertEquals(Short.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeElements(new short[] { 1, 2, 1 }, (short) 1, (short) 2); 
     assertTrue(Arrays.equals(new short[] { 1 }, array)); 
     assertEquals(Short.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeElements(new short[] { 1, 2, 1 }, (short) 1, (short) 1, (short) 1, (short) 1); 
     assertTrue(Arrays.equals(new short[] { 2 }, array)); 
     assertEquals(Short.TYPE, array.getClass().getComponentType()); 
 }
@Test(expected = IndexOutOfBoundsException.class) 
 public void testRemoveAllObjectArrayOutOfBoundsIndex3495() { 
     ArrayUtils.removeAll(new Object[] { "a", "b" }, 2); 
 }
@Test
public void testRemoveElementBooleanArray3558() { 
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
@Test(expected = IndexOutOfBoundsException.class) 
 public void testRemoveAllLongArrayOutOfBoundsIndex3664() { 
     ArrayUtils.removeAll(new long[] { 1, 2 }, 2); 
 }
@Test
@SuppressWarnings("cast") 
 public void testRemoveElementDoubleArray3750() { 
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
public void testRemoveElementShortArray3793() { 
     short[] array; 
     array = ArrayUtils.removeElements((short[]) null, (short) 1); 
     assertNull(array); 
     array = ArrayUtils.removeElements(ArrayUtils.EMPTY_SHORT_ARRAY, (short) 1); 
     assertTrue(Arrays.equals(ArrayUtils.EMPTY_SHORT_ARRAY, array)); 
     assertEquals(Short.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeElements(new short[] { 1 }, (short) 1); 
     assertTrue(Arrays.equals(ArrayUtils.EMPTY_SHORT_ARRAY, array)); 
     assertEquals(Short.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeElements(new short[] { 1, 2 }, (short) 1); 
     assertTrue(Arrays.equals(new short[] { 2 }, array)); 
     assertEquals(Short.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeElements(new short[] { 1, 2, 1 }, (short) 1); 
     assertTrue(Arrays.equals(new short[] { 2, 1 }, array)); 
     assertEquals(Short.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeElements((short[]) null, (short) 1, (short) 1); 
     assertNull(array); 
     array = ArrayUtils.removeElements(ArrayUtils.EMPTY_SHORT_ARRAY, (short) 1, (short) 1); 
     assertTrue(Arrays.equals(ArrayUtils.EMPTY_SHORT_ARRAY, array)); 
     assertEquals(Short.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeElements(new short[] { 1 }, (short) 1, (short) 1); 
     assertTrue(Arrays.equals(ArrayUtils.EMPTY_SHORT_ARRAY, array)); 
     assertEquals(Short.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeElements(new short[] { 1, 2 }, (short) 1, (short) 2); 
     assertTrue(Arrays.equals(ArrayUtils.EMPTY_SHORT_ARRAY, array)); 
     assertEquals(Short.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeElements(new short[] { 1, 2 }, (short) 1, (short) 1); 
     assertTrue(Arrays.equals(new short[] { 2 }, array)); 
     assertEquals(Short.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeElements(new short[] { 1, 2, 1 }, (short) 1, (short) 1); 
     assertTrue(Arrays.equals(new short[] { 2 }, array)); 
     assertEquals(Short.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeElements(new short[] { 1, 2, 1 }, (short) 1, (short) 2); 
     assertTrue(Arrays.equals(new short[] { 1 }, array)); 
     assertEquals(Short.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeElements(new short[] { 1, 2, 1 }, (short) 1, (short) 1, (short) 1, (short) 1); 
     assertTrue(Arrays.equals(new short[] { 2 }, array)); 
     assertEquals(Short.TYPE, array.getClass().getComponentType()); 
 }
@Test
public void testRemoveElementBooleanArray3824() { 
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
public void testRemoveAllDoubleArray3829() { 
     double[] array; 
     array = ArrayUtils.removeAll(new double[] { 1 }, 0); 
     assertTrue(Arrays.equals(ArrayUtils.EMPTY_DOUBLE_ARRAY, array)); 
     assertEquals(Double.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeAll(new double[] { 1, 2 }, 0); 
     assertTrue(Arrays.equals(new double[] { 2 }, array)); 
     assertEquals(Double.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeAll(new double[] { 1, 2 }, 1); 
     assertTrue(Arrays.equals(new double[] { 1 }, array)); 
     assertEquals(Double.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeAll(new double[] { 1, 2, 1 }, 1); 
     assertTrue(Arrays.equals(new double[] { 1, 1 }, array)); 
     assertEquals(Double.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeAll(new double[] { 1, 2 }, 0, 1); 
     assertTrue(Arrays.equals(ArrayUtils.EMPTY_DOUBLE_ARRAY, array)); 
     assertEquals(Double.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeAll(new double[] { 1, 2, 3 }, 0, 1); 
     assertTrue(Arrays.equals(new double[] { 3 }, array)); 
     assertEquals(Double.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeAll(new double[] { 1, 2, 3 }, 1, 2); 
     assertTrue(Arrays.equals(new double[] { 1 }, array)); 
     assertEquals(Double.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeAll(new double[] { 1, 2, 3 }, 0, 2); 
     assertTrue(Arrays.equals(new double[] { 2 }, array)); 
     assertEquals(Double.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeAll(new double[] { 1, 2, 3, 4, 5 }, 1, 3); 
     assertTrue(Arrays.equals(new double[] { 1, 3, 5 }, array)); 
     assertEquals(Double.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeAll(new double[] { 1, 2, 3, 4, 5 }, 0, 2, 4); 
     assertTrue(Arrays.equals(new double[] { 2, 4 }, array)); 
     assertEquals(Double.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeAll(new double[] { 1, 2, 3, 4, 5, 6, 7 }, 1, 3, 5); 
     assertTrue(Arrays.equals(new double[] { 1, 3, 5, 7 }, array)); 
     assertEquals(Double.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeAll(new double[] { 1, 2, 3, 4, 5, 6, 7 }, 0, 2, 4, 6); 
     assertTrue(Arrays.equals(new double[] { 2, 4, 6 }, array)); 
     assertEquals(Double.TYPE, array.getClass().getComponentType()); 
 }
@Test(expected = IndexOutOfBoundsException.class) 
 public void testRemoveAllLongArrayOutOfBoundsIndex3840() { 
     ArrayUtils.removeAll(new long[] { 1, 2 }, 2); 
 }
@Test
@SuppressWarnings("cast") 
 public void testRemoveElementDoubleArray3864() { 
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
@Test(expected = IndexOutOfBoundsException.class) 
 public void testRemoveAllNullFloatArray3901() { 
     ArrayUtils.removeAll((float[]) null, 0); 
 }
@Test
public void testRemoveElementIntArray3945() { 
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
@Test
@SuppressWarnings("cast") 
 public void testRemoveElementLongArray4046() { 
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
 public void testRemoveAllLongArrayOutOfBoundsIndex4053() { 
     ArrayUtils.removeAll(new long[] { 1, 2 }, 2); 
 }
@Test
public void testRemoveElementShortArray4075() { 
     short[] array; 
     array = ArrayUtils.removeElements((short[]) null, (short) 1); 
     assertNull(array); 
     array = ArrayUtils.removeElements(ArrayUtils.EMPTY_SHORT_ARRAY, (short) 1); 
     assertTrue(Arrays.equals(ArrayUtils.EMPTY_SHORT_ARRAY, array)); 
     assertEquals(Short.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeElements(new short[] { 1 }, (short) 1); 
     assertTrue(Arrays.equals(ArrayUtils.EMPTY_SHORT_ARRAY, array)); 
     assertEquals(Short.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeElements(new short[] { 1, 2 }, (short) 1); 
     assertTrue(Arrays.equals(new short[] { 2 }, array)); 
     assertEquals(Short.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeElements(new short[] { 1, 2, 1 }, (short) 1); 
     assertTrue(Arrays.equals(new short[] { 2, 1 }, array)); 
     assertEquals(Short.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeElements((short[]) null, (short) 1, (short) 1); 
     assertNull(array); 
     array = ArrayUtils.removeElements(ArrayUtils.EMPTY_SHORT_ARRAY, (short) 1, (short) 1); 
     assertTrue(Arrays.equals(ArrayUtils.EMPTY_SHORT_ARRAY, array)); 
     assertEquals(Short.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeElements(new short[] { 1 }, (short) 1, (short) 1); 
     assertTrue(Arrays.equals(ArrayUtils.EMPTY_SHORT_ARRAY, array)); 
     assertEquals(Short.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeElements(new short[] { 1, 2 }, (short) 1, (short) 2); 
     assertTrue(Arrays.equals(ArrayUtils.EMPTY_SHORT_ARRAY, array)); 
     assertEquals(Short.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeElements(new short[] { 1, 2 }, (short) 1, (short) 1); 
     assertTrue(Arrays.equals(new short[] { 2 }, array)); 
     assertEquals(Short.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeElements(new short[] { 1, 2, 1 }, (short) 1, (short) 1); 
     assertTrue(Arrays.equals(new short[] { 2 }, array)); 
     assertEquals(Short.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeElements(new short[] { 1, 2, 1 }, (short) 1, (short) 2); 
     assertTrue(Arrays.equals(new short[] { 1 }, array)); 
     assertEquals(Short.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeElements(new short[] { 1, 2, 1 }, (short) 1, (short) 1, (short) 1, (short) 1); 
     assertTrue(Arrays.equals(new short[] { 2 }, array)); 
     assertEquals(Short.TYPE, array.getClass().getComponentType()); 
 }
@Test
public void testRemoveElementShortArray4116() { 
     short[] array; 
     array = ArrayUtils.removeElements((short[]) null, (short) 1); 
     assertNull(array); 
     array = ArrayUtils.removeElements(ArrayUtils.EMPTY_SHORT_ARRAY, (short) 1); 
     assertTrue(Arrays.equals(ArrayUtils.EMPTY_SHORT_ARRAY, array)); 
     assertEquals(Short.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeElements(new short[] { 1 }, (short) 1); 
     assertTrue(Arrays.equals(ArrayUtils.EMPTY_SHORT_ARRAY, array)); 
     assertEquals(Short.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeElements(new short[] { 1, 2 }, (short) 1); 
     assertTrue(Arrays.equals(new short[] { 2 }, array)); 
     assertEquals(Short.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeElements(new short[] { 1, 2, 1 }, (short) 1); 
     assertTrue(Arrays.equals(new short[] { 2, 1 }, array)); 
     assertEquals(Short.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeElements((short[]) null, (short) 1, (short) 1); 
     assertNull(array); 
     array = ArrayUtils.removeElements(ArrayUtils.EMPTY_SHORT_ARRAY, (short) 1, (short) 1); 
     assertTrue(Arrays.equals(ArrayUtils.EMPTY_SHORT_ARRAY, array)); 
     assertEquals(Short.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeElements(new short[] { 1 }, (short) 1, (short) 1); 
     assertTrue(Arrays.equals(ArrayUtils.EMPTY_SHORT_ARRAY, array)); 
     assertEquals(Short.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeElements(new short[] { 1, 2 }, (short) 1, (short) 2); 
     assertTrue(Arrays.equals(ArrayUtils.EMPTY_SHORT_ARRAY, array)); 
     assertEquals(Short.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeElements(new short[] { 1, 2 }, (short) 1, (short) 1); 
     assertTrue(Arrays.equals(new short[] { 2 }, array)); 
     assertEquals(Short.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeElements(new short[] { 1, 2, 1 }, (short) 1, (short) 1); 
     assertTrue(Arrays.equals(new short[] { 2 }, array)); 
     assertEquals(Short.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeElements(new short[] { 1, 2, 1 }, (short) 1, (short) 2); 
     assertTrue(Arrays.equals(new short[] { 1 }, array)); 
     assertEquals(Short.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeElements(new short[] { 1, 2, 1 }, (short) 1, (short) 1, (short) 1, (short) 1); 
     assertTrue(Arrays.equals(new short[] { 2 }, array)); 
     assertEquals(Short.TYPE, array.getClass().getComponentType()); 
 }
@Test
public void testRemoveElementIntArray4184() { 
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
 public void testRemoveAllByteArrayNegativeIndex4195() { 
     ArrayUtils.removeAll(new byte[] { 1, 2 }, -1); 
 }
@Test
public void testRemoveElementShortArray4246() { 
     short[] array; 
     array = ArrayUtils.removeElements((short[]) null, (short) 1); 
     assertNull(array); 
     array = ArrayUtils.removeElements(ArrayUtils.EMPTY_SHORT_ARRAY, (short) 1); 
     assertTrue(Arrays.equals(ArrayUtils.EMPTY_SHORT_ARRAY, array)); 
     assertEquals(Short.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeElements(new short[] { 1 }, (short) 1); 
     assertTrue(Arrays.equals(ArrayUtils.EMPTY_SHORT_ARRAY, array)); 
     assertEquals(Short.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeElements(new short[] { 1, 2 }, (short) 1); 
     assertTrue(Arrays.equals(new short[] { 2 }, array)); 
     assertEquals(Short.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeElements(new short[] { 1, 2, 1 }, (short) 1); 
     assertTrue(Arrays.equals(new short[] { 2, 1 }, array)); 
     assertEquals(Short.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeElements((short[]) null, (short) 1, (short) 1); 
     assertNull(array); 
     array = ArrayUtils.removeElements(ArrayUtils.EMPTY_SHORT_ARRAY, (short) 1, (short) 1); 
     assertTrue(Arrays.equals(ArrayUtils.EMPTY_SHORT_ARRAY, array)); 
     assertEquals(Short.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeElements(new short[] { 1 }, (short) 1, (short) 1); 
     assertTrue(Arrays.equals(ArrayUtils.EMPTY_SHORT_ARRAY, array)); 
     assertEquals(Short.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeElements(new short[] { 1, 2 }, (short) 1, (short) 2); 
     assertTrue(Arrays.equals(ArrayUtils.EMPTY_SHORT_ARRAY, array)); 
     assertEquals(Short.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeElements(new short[] { 1, 2 }, (short) 1, (short) 1); 
     assertTrue(Arrays.equals(new short[] { 2 }, array)); 
     assertEquals(Short.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeElements(new short[] { 1, 2, 1 }, (short) 1, (short) 1); 
     assertTrue(Arrays.equals(new short[] { 2 }, array)); 
     assertEquals(Short.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeElements(new short[] { 1, 2, 1 }, (short) 1, (short) 2); 
     assertTrue(Arrays.equals(new short[] { 1 }, array)); 
     assertEquals(Short.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeElements(new short[] { 1, 2, 1 }, (short) 1, (short) 1, (short) 1, (short) 1); 
     assertTrue(Arrays.equals(new short[] { 2 }, array)); 
     assertEquals(Short.TYPE, array.getClass().getComponentType()); 
 }
@Test
@SuppressWarnings("cast") 
 public void testRemoveElementDoubleArray4276() { 
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
@Test(expected = IndexOutOfBoundsException.class) 
 public void testRemoveAllBooleanArrayOutOfBoundsIndex4301() { 
     ArrayUtils.removeAll(new boolean[] { true, false }, 2); 
 }
@Test
public void testRemoveElementShortArray4315() { 
     short[] array; 
     array = ArrayUtils.removeElements((short[]) null, (short) 1); 
     assertNull(array); 
     array = ArrayUtils.removeElements(ArrayUtils.EMPTY_SHORT_ARRAY, (short) 1); 
     assertTrue(Arrays.equals(ArrayUtils.EMPTY_SHORT_ARRAY, array)); 
     assertEquals(Short.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeElements(new short[] { 1 }, (short) 1); 
     assertTrue(Arrays.equals(ArrayUtils.EMPTY_SHORT_ARRAY, array)); 
     assertEquals(Short.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeElements(new short[] { 1, 2 }, (short) 1); 
     assertTrue(Arrays.equals(new short[] { 2 }, array)); 
     assertEquals(Short.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeElements(new short[] { 1, 2, 1 }, (short) 1); 
     assertTrue(Arrays.equals(new short[] { 2, 1 }, array)); 
     assertEquals(Short.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeElements((short[]) null, (short) 1, (short) 1); 
     assertNull(array); 
     array = ArrayUtils.removeElements(ArrayUtils.EMPTY_SHORT_ARRAY, (short) 1, (short) 1); 
     assertTrue(Arrays.equals(ArrayUtils.EMPTY_SHORT_ARRAY, array)); 
     assertEquals(Short.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeElements(new short[] { 1 }, (short) 1, (short) 1); 
     assertTrue(Arrays.equals(ArrayUtils.EMPTY_SHORT_ARRAY, array)); 
     assertEquals(Short.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeElements(new short[] { 1, 2 }, (short) 1, (short) 2); 
     assertTrue(Arrays.equals(ArrayUtils.EMPTY_SHORT_ARRAY, array)); 
     assertEquals(Short.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeElements(new short[] { 1, 2 }, (short) 1, (short) 1); 
     assertTrue(Arrays.equals(new short[] { 2 }, array)); 
     assertEquals(Short.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeElements(new short[] { 1, 2, 1 }, (short) 1, (short) 1); 
     assertTrue(Arrays.equals(new short[] { 2 }, array)); 
     assertEquals(Short.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeElements(new short[] { 1, 2, 1 }, (short) 1, (short) 2); 
     assertTrue(Arrays.equals(new short[] { 1 }, array)); 
     assertEquals(Short.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeElements(new short[] { 1, 2, 1 }, (short) 1, (short) 1, (short) 1, (short) 1); 
     assertTrue(Arrays.equals(new short[] { 2 }, array)); 
     assertEquals(Short.TYPE, array.getClass().getComponentType()); 
 }
@Test
@SuppressWarnings("cast") 
 public void testRemoveElementLongArray4335() { 
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
@Test
@SuppressWarnings("cast") 
 public void testRemoveElementDoubleArray4390() { 
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
public void testRemoveElementCharArray4392() { 
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
@Test(expected = IndexOutOfBoundsException.class) 
 public void testRemoveAllBooleanArrayOutOfBoundsIndex4590() { 
     ArrayUtils.removeAll(new boolean[] { true, false }, 2); 
 }
@Test
public void testRemoveElementCharArray4604() { 
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
 public void testRemoveElementDoubleArray4606() { 
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
@Test(expected = IndexOutOfBoundsException.class) 
 public void testRemoveAllLongArrayOutOfBoundsIndex4671() { 
     ArrayUtils.removeAll(new long[] { 1, 2 }, 2); 
 }
@Test
public void testRemoveElementShortArray4677() { 
     short[] array; 
     array = ArrayUtils.removeElements((short[]) null, (short) 1); 
     assertNull(array); 
     array = ArrayUtils.removeElements(ArrayUtils.EMPTY_SHORT_ARRAY, (short) 1); 
     assertTrue(Arrays.equals(ArrayUtils.EMPTY_SHORT_ARRAY, array)); 
     assertEquals(Short.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeElements(new short[] { 1 }, (short) 1); 
     assertTrue(Arrays.equals(ArrayUtils.EMPTY_SHORT_ARRAY, array)); 
     assertEquals(Short.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeElements(new short[] { 1, 2 }, (short) 1); 
     assertTrue(Arrays.equals(new short[] { 2 }, array)); 
     assertEquals(Short.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeElements(new short[] { 1, 2, 1 }, (short) 1); 
     assertTrue(Arrays.equals(new short[] { 2, 1 }, array)); 
     assertEquals(Short.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeElements((short[]) null, (short) 1, (short) 1); 
     assertNull(array); 
     array = ArrayUtils.removeElements(ArrayUtils.EMPTY_SHORT_ARRAY, (short) 1, (short) 1); 
     assertTrue(Arrays.equals(ArrayUtils.EMPTY_SHORT_ARRAY, array)); 
     assertEquals(Short.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeElements(new short[] { 1 }, (short) 1, (short) 1); 
     assertTrue(Arrays.equals(ArrayUtils.EMPTY_SHORT_ARRAY, array)); 
     assertEquals(Short.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeElements(new short[] { 1, 2 }, (short) 1, (short) 2); 
     assertTrue(Arrays.equals(ArrayUtils.EMPTY_SHORT_ARRAY, array)); 
     assertEquals(Short.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeElements(new short[] { 1, 2 }, (short) 1, (short) 1); 
     assertTrue(Arrays.equals(new short[] { 2 }, array)); 
     assertEquals(Short.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeElements(new short[] { 1, 2, 1 }, (short) 1, (short) 1); 
     assertTrue(Arrays.equals(new short[] { 2 }, array)); 
     assertEquals(Short.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeElements(new short[] { 1, 2, 1 }, (short) 1, (short) 2); 
     assertTrue(Arrays.equals(new short[] { 1 }, array)); 
     assertEquals(Short.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeElements(new short[] { 1, 2, 1 }, (short) 1, (short) 1, (short) 1, (short) 1); 
     assertTrue(Arrays.equals(new short[] { 2 }, array)); 
     assertEquals(Short.TYPE, array.getClass().getComponentType()); 
 }
@Test
public void testRemoveElementBooleanArray4723() { 
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
public void testRemoveElementIntArray4739() { 
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
@Test
@SuppressWarnings("cast") 
 public void testRemoveElementLongArray5050() { 
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
@Test
public void testRemoveAllDoubleArray5071() { 
     double[] array; 
     array = ArrayUtils.removeAll(new double[] { 1 }, 0); 
     assertTrue(Arrays.equals(ArrayUtils.EMPTY_DOUBLE_ARRAY, array)); 
     assertEquals(Double.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeAll(new double[] { 1, 2 }, 0); 
     assertTrue(Arrays.equals(new double[] { 2 }, array)); 
     assertEquals(Double.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeAll(new double[] { 1, 2 }, 1); 
     assertTrue(Arrays.equals(new double[] { 1 }, array)); 
     assertEquals(Double.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeAll(new double[] { 1, 2, 1 }, 1); 
     assertTrue(Arrays.equals(new double[] { 1, 1 }, array)); 
     assertEquals(Double.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeAll(new double[] { 1, 2 }, 0, 1); 
     assertTrue(Arrays.equals(ArrayUtils.EMPTY_DOUBLE_ARRAY, array)); 
     assertEquals(Double.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeAll(new double[] { 1, 2, 3 }, 0, 1); 
     assertTrue(Arrays.equals(new double[] { 3 }, array)); 
     assertEquals(Double.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeAll(new double[] { 1, 2, 3 }, 1, 2); 
     assertTrue(Arrays.equals(new double[] { 1 }, array)); 
     assertEquals(Double.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeAll(new double[] { 1, 2, 3 }, 0, 2); 
     assertTrue(Arrays.equals(new double[] { 2 }, array)); 
     assertEquals(Double.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeAll(new double[] { 1, 2, 3, 4, 5 }, 1, 3); 
     assertTrue(Arrays.equals(new double[] { 1, 3, 5 }, array)); 
     assertEquals(Double.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeAll(new double[] { 1, 2, 3, 4, 5 }, 0, 2, 4); 
     assertTrue(Arrays.equals(new double[] { 2, 4 }, array)); 
     assertEquals(Double.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeAll(new double[] { 1, 2, 3, 4, 5, 6, 7 }, 1, 3, 5); 
     assertTrue(Arrays.equals(new double[] { 1, 3, 5, 7 }, array)); 
     assertEquals(Double.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeAll(new double[] { 1, 2, 3, 4, 5, 6, 7 }, 0, 2, 4, 6); 
     assertTrue(Arrays.equals(new double[] { 2, 4, 6 }, array)); 
     assertEquals(Double.TYPE, array.getClass().getComponentType()); 
 }
@Test
public void testRemoveElementCharArray5133() { 
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
public void testRemoveElementCharArray5135() { 
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
 public void testRemoveElementLongArray5278() { 
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
@Test
public void testRemoveElementIntArray5294() { 
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
@Test
public void testRemoveElementIntArray5338() { 
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
@Test
public void testRemoveElementShortArray5532() { 
     short[] array; 
     array = ArrayUtils.removeElements((short[]) null, (short) 1); 
     assertNull(array); 
     array = ArrayUtils.removeElements(ArrayUtils.EMPTY_SHORT_ARRAY, (short) 1); 
     assertTrue(Arrays.equals(ArrayUtils.EMPTY_SHORT_ARRAY, array)); 
     assertEquals(Short.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeElements(new short[] { 1 }, (short) 1); 
     assertTrue(Arrays.equals(ArrayUtils.EMPTY_SHORT_ARRAY, array)); 
     assertEquals(Short.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeElements(new short[] { 1, 2 }, (short) 1); 
     assertTrue(Arrays.equals(new short[] { 2 }, array)); 
     assertEquals(Short.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeElements(new short[] { 1, 2, 1 }, (short) 1); 
     assertTrue(Arrays.equals(new short[] { 2, 1 }, array)); 
     assertEquals(Short.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeElements((short[]) null, (short) 1, (short) 1); 
     assertNull(array); 
     array = ArrayUtils.removeElements(ArrayUtils.EMPTY_SHORT_ARRAY, (short) 1, (short) 1); 
     assertTrue(Arrays.equals(ArrayUtils.EMPTY_SHORT_ARRAY, array)); 
     assertEquals(Short.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeElements(new short[] { 1 }, (short) 1, (short) 1); 
     assertTrue(Arrays.equals(ArrayUtils.EMPTY_SHORT_ARRAY, array)); 
     assertEquals(Short.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeElements(new short[] { 1, 2 }, (short) 1, (short) 2); 
     assertTrue(Arrays.equals(ArrayUtils.EMPTY_SHORT_ARRAY, array)); 
     assertEquals(Short.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeElements(new short[] { 1, 2 }, (short) 1, (short) 1); 
     assertTrue(Arrays.equals(new short[] { 2 }, array)); 
     assertEquals(Short.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeElements(new short[] { 1, 2, 1 }, (short) 1, (short) 1); 
     assertTrue(Arrays.equals(new short[] { 2 }, array)); 
     assertEquals(Short.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeElements(new short[] { 1, 2, 1 }, (short) 1, (short) 2); 
     assertTrue(Arrays.equals(new short[] { 1 }, array)); 
     assertEquals(Short.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeElements(new short[] { 1, 2, 1 }, (short) 1, (short) 1, (short) 1, (short) 1); 
     assertTrue(Arrays.equals(new short[] { 2 }, array)); 
     assertEquals(Short.TYPE, array.getClass().getComponentType()); 
 }
@Test
public void testRemoveAllDoubleArray5540() { 
     double[] array; 
     array = ArrayUtils.removeAll(new double[] { 1 }, 0); 
     assertTrue(Arrays.equals(ArrayUtils.EMPTY_DOUBLE_ARRAY, array)); 
     assertEquals(Double.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeAll(new double[] { 1, 2 }, 0); 
     assertTrue(Arrays.equals(new double[] { 2 }, array)); 
     assertEquals(Double.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeAll(new double[] { 1, 2 }, 1); 
     assertTrue(Arrays.equals(new double[] { 1 }, array)); 
     assertEquals(Double.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeAll(new double[] { 1, 2, 1 }, 1); 
     assertTrue(Arrays.equals(new double[] { 1, 1 }, array)); 
     assertEquals(Double.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeAll(new double[] { 1, 2 }, 0, 1); 
     assertTrue(Arrays.equals(ArrayUtils.EMPTY_DOUBLE_ARRAY, array)); 
     assertEquals(Double.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeAll(new double[] { 1, 2, 3 }, 0, 1); 
     assertTrue(Arrays.equals(new double[] { 3 }, array)); 
     assertEquals(Double.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeAll(new double[] { 1, 2, 3 }, 1, 2); 
     assertTrue(Arrays.equals(new double[] { 1 }, array)); 
     assertEquals(Double.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeAll(new double[] { 1, 2, 3 }, 0, 2); 
     assertTrue(Arrays.equals(new double[] { 2 }, array)); 
     assertEquals(Double.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeAll(new double[] { 1, 2, 3, 4, 5 }, 1, 3); 
     assertTrue(Arrays.equals(new double[] { 1, 3, 5 }, array)); 
     assertEquals(Double.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeAll(new double[] { 1, 2, 3, 4, 5 }, 0, 2, 4); 
     assertTrue(Arrays.equals(new double[] { 2, 4 }, array)); 
     assertEquals(Double.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeAll(new double[] { 1, 2, 3, 4, 5, 6, 7 }, 1, 3, 5); 
     assertTrue(Arrays.equals(new double[] { 1, 3, 5, 7 }, array)); 
     assertEquals(Double.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeAll(new double[] { 1, 2, 3, 4, 5, 6, 7 }, 0, 2, 4, 6); 
     assertTrue(Arrays.equals(new double[] { 2, 4, 6 }, array)); 
     assertEquals(Double.TYPE, array.getClass().getComponentType()); 
 }
@Test
public void testRemoveElementCharArray5590() { 
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
public void testRemoveElementCharArray5692() { 
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
public void testRemoveElementCharArray5759() { 
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
 public void testRemoveElementDoubleArray5842() { 
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
@Test(expected = IndexOutOfBoundsException.class) 
 public void testRemoveAllLongArrayOutOfBoundsIndex5883() { 
     ArrayUtils.removeAll(new long[] { 1, 2 }, 2); 
 }
@Test
@SuppressWarnings("cast") 
 public void testRemoveElementLongArray5951() { 
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
@Test
public void testRemoveElementBooleanArray6038() { 
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
@SuppressWarnings("cast") 
 public void testRemoveElementDoubleArray6105() { 
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
public void testRemoveElementBooleanArray6201() { 
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
@Test(expected = IndexOutOfBoundsException.class) 
 public void testRemoveAllLongArrayOutOfBoundsIndex6208() { 
     ArrayUtils.removeAll(new long[] { 1, 2 }, 2); 
 }
@Test(expected = IndexOutOfBoundsException.class) 
 public void testRemoveAllLongArrayOutOfBoundsIndex6237() { 
     ArrayUtils.removeAll(new long[] { 1, 2 }, 2); 
 }
@Test
public void testRemoveElementIntArray6339() { 
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
 public void testRemoveAllLongArrayOutOfBoundsIndex6356() { 
     ArrayUtils.removeAll(new long[] { 1, 2 }, 2); 
 }
@Test(expected = IndexOutOfBoundsException.class) 
 public void testRemoveAllNullFloatArray6568() { 
     ArrayUtils.removeAll((float[]) null, 0); 
 }
@Test
public void testRemoveElementIntArray6649() { 
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
@Test
public void testRemoveAllDoubleArray6650() { 
     double[] array; 
     array = ArrayUtils.removeAll(new double[] { 1 }, 0); 
     assertTrue(Arrays.equals(ArrayUtils.EMPTY_DOUBLE_ARRAY, array)); 
     assertEquals(Double.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeAll(new double[] { 1, 2 }, 0); 
     assertTrue(Arrays.equals(new double[] { 2 }, array)); 
     assertEquals(Double.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeAll(new double[] { 1, 2 }, 1); 
     assertTrue(Arrays.equals(new double[] { 1 }, array)); 
     assertEquals(Double.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeAll(new double[] { 1, 2, 1 }, 1); 
     assertTrue(Arrays.equals(new double[] { 1, 1 }, array)); 
     assertEquals(Double.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeAll(new double[] { 1, 2 }, 0, 1); 
     assertTrue(Arrays.equals(ArrayUtils.EMPTY_DOUBLE_ARRAY, array)); 
     assertEquals(Double.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeAll(new double[] { 1, 2, 3 }, 0, 1); 
     assertTrue(Arrays.equals(new double[] { 3 }, array)); 
     assertEquals(Double.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeAll(new double[] { 1, 2, 3 }, 1, 2); 
     assertTrue(Arrays.equals(new double[] { 1 }, array)); 
     assertEquals(Double.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeAll(new double[] { 1, 2, 3 }, 0, 2); 
     assertTrue(Arrays.equals(new double[] { 2 }, array)); 
     assertEquals(Double.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeAll(new double[] { 1, 2, 3, 4, 5 }, 1, 3); 
     assertTrue(Arrays.equals(new double[] { 1, 3, 5 }, array)); 
     assertEquals(Double.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeAll(new double[] { 1, 2, 3, 4, 5 }, 0, 2, 4); 
     assertTrue(Arrays.equals(new double[] { 2, 4 }, array)); 
     assertEquals(Double.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeAll(new double[] { 1, 2, 3, 4, 5, 6, 7 }, 1, 3, 5); 
     assertTrue(Arrays.equals(new double[] { 1, 3, 5, 7 }, array)); 
     assertEquals(Double.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeAll(new double[] { 1, 2, 3, 4, 5, 6, 7 }, 0, 2, 4, 6); 
     assertTrue(Arrays.equals(new double[] { 2, 4, 6 }, array)); 
     assertEquals(Double.TYPE, array.getClass().getComponentType()); 
 }
@Test
public void testRemoveAllObjectArray6689() { 
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
@Test
@SuppressWarnings("cast") 
 public void testRemoveElementDoubleArray6737() { 
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
public void testRemoveElementIntArray6817() { 
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
@Test
@SuppressWarnings("cast") 
 public void testRemoveElementLongArray7023() { 
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
@Test
@SuppressWarnings("cast") 
 public void testRemoveElementDoubleArray7233() { 
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
public void testRemoveElementBooleanArray7283() { 
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
public void testRemoveElementCharArray7391() { 
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
public void testRemoveElementShortArray7408() { 
     short[] array; 
     array = ArrayUtils.removeElements((short[]) null, (short) 1); 
     assertNull(array); 
     array = ArrayUtils.removeElements(ArrayUtils.EMPTY_SHORT_ARRAY, (short) 1); 
     assertTrue(Arrays.equals(ArrayUtils.EMPTY_SHORT_ARRAY, array)); 
     assertEquals(Short.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeElements(new short[] { 1 }, (short) 1); 
     assertTrue(Arrays.equals(ArrayUtils.EMPTY_SHORT_ARRAY, array)); 
     assertEquals(Short.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeElements(new short[] { 1, 2 }, (short) 1); 
     assertTrue(Arrays.equals(new short[] { 2 }, array)); 
     assertEquals(Short.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeElements(new short[] { 1, 2, 1 }, (short) 1); 
     assertTrue(Arrays.equals(new short[] { 2, 1 }, array)); 
     assertEquals(Short.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeElements((short[]) null, (short) 1, (short) 1); 
     assertNull(array); 
     array = ArrayUtils.removeElements(ArrayUtils.EMPTY_SHORT_ARRAY, (short) 1, (short) 1); 
     assertTrue(Arrays.equals(ArrayUtils.EMPTY_SHORT_ARRAY, array)); 
     assertEquals(Short.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeElements(new short[] { 1 }, (short) 1, (short) 1); 
     assertTrue(Arrays.equals(ArrayUtils.EMPTY_SHORT_ARRAY, array)); 
     assertEquals(Short.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeElements(new short[] { 1, 2 }, (short) 1, (short) 2); 
     assertTrue(Arrays.equals(ArrayUtils.EMPTY_SHORT_ARRAY, array)); 
     assertEquals(Short.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeElements(new short[] { 1, 2 }, (short) 1, (short) 1); 
     assertTrue(Arrays.equals(new short[] { 2 }, array)); 
     assertEquals(Short.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeElements(new short[] { 1, 2, 1 }, (short) 1, (short) 1); 
     assertTrue(Arrays.equals(new short[] { 2 }, array)); 
     assertEquals(Short.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeElements(new short[] { 1, 2, 1 }, (short) 1, (short) 2); 
     assertTrue(Arrays.equals(new short[] { 1 }, array)); 
     assertEquals(Short.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeElements(new short[] { 1, 2, 1 }, (short) 1, (short) 1, (short) 1, (short) 1); 
     assertTrue(Arrays.equals(new short[] { 2 }, array)); 
     assertEquals(Short.TYPE, array.getClass().getComponentType()); 
 }
@Test
public void testRemoveAllShortArrayRemoveNone7527() { 
     final short[] array1 = new short[] { 1, 2 }; 
     final short[] array2 = ArrayUtils.removeAll(array1); 
     assertNotSame(array1, array2); 
     assertArrayEquals(array1, array2); 
     assertEquals(short.class, array2.getClass().getComponentType()); 
 }
@Test
@SuppressWarnings("cast") 
 public void testRemoveElementDoubleArray7580() { 
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
@SuppressWarnings("cast") 
 public void testRemoveElementLongArray7644() { 
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
@Test
@SuppressWarnings("cast") 
 public void testRemoveElementDoubleArray7652() { 
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
public void testRemoveElementCharArray7804() { 
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
public void testRemoveElementCharArray7811() { 
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
public void testRemoveElementBooleanArray7868() { 
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
public void testRemoveAllDoubleArray7897() { 
     double[] array; 
     array = ArrayUtils.removeAll(new double[] { 1 }, 0); 
     assertTrue(Arrays.equals(ArrayUtils.EMPTY_DOUBLE_ARRAY, array)); 
     assertEquals(Double.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeAll(new double[] { 1, 2 }, 0); 
     assertTrue(Arrays.equals(new double[] { 2 }, array)); 
     assertEquals(Double.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeAll(new double[] { 1, 2 }, 1); 
     assertTrue(Arrays.equals(new double[] { 1 }, array)); 
     assertEquals(Double.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeAll(new double[] { 1, 2, 1 }, 1); 
     assertTrue(Arrays.equals(new double[] { 1, 1 }, array)); 
     assertEquals(Double.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeAll(new double[] { 1, 2 }, 0, 1); 
     assertTrue(Arrays.equals(ArrayUtils.EMPTY_DOUBLE_ARRAY, array)); 
     assertEquals(Double.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeAll(new double[] { 1, 2, 3 }, 0, 1); 
     assertTrue(Arrays.equals(new double[] { 3 }, array)); 
     assertEquals(Double.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeAll(new double[] { 1, 2, 3 }, 1, 2); 
     assertTrue(Arrays.equals(new double[] { 1 }, array)); 
     assertEquals(Double.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeAll(new double[] { 1, 2, 3 }, 0, 2); 
     assertTrue(Arrays.equals(new double[] { 2 }, array)); 
     assertEquals(Double.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeAll(new double[] { 1, 2, 3, 4, 5 }, 1, 3); 
     assertTrue(Arrays.equals(new double[] { 1, 3, 5 }, array)); 
     assertEquals(Double.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeAll(new double[] { 1, 2, 3, 4, 5 }, 0, 2, 4); 
     assertTrue(Arrays.equals(new double[] { 2, 4 }, array)); 
     assertEquals(Double.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeAll(new double[] { 1, 2, 3, 4, 5, 6, 7 }, 1, 3, 5); 
     assertTrue(Arrays.equals(new double[] { 1, 3, 5, 7 }, array)); 
     assertEquals(Double.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeAll(new double[] { 1, 2, 3, 4, 5, 6, 7 }, 0, 2, 4, 6); 
     assertTrue(Arrays.equals(new double[] { 2, 4, 6 }, array)); 
     assertEquals(Double.TYPE, array.getClass().getComponentType()); 
 }
@Test(expected = IndexOutOfBoundsException.class) 
 public void testRemoveAllLongArrayOutOfBoundsIndex7929() { 
     ArrayUtils.removeAll(new long[] { 1, 2 }, 2); 
 }
@Test
public void testRemoveElementIntArray7953() { 
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
 public void testRemoveAllIntArrayOutOfBoundsIndex7961() { 
     ArrayUtils.removeAll(new int[] { 1, 2 }, 2); 
 }
@Test
public void testRemoveElementBooleanArray8035() { 
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
public void testRemoveAllDoubleArray8065() { 
     double[] array; 
     array = ArrayUtils.removeAll(new double[] { 1 }, 0); 
     assertTrue(Arrays.equals(ArrayUtils.EMPTY_DOUBLE_ARRAY, array)); 
     assertEquals(Double.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeAll(new double[] { 1, 2 }, 0); 
     assertTrue(Arrays.equals(new double[] { 2 }, array)); 
     assertEquals(Double.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeAll(new double[] { 1, 2 }, 1); 
     assertTrue(Arrays.equals(new double[] { 1 }, array)); 
     assertEquals(Double.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeAll(new double[] { 1, 2, 1 }, 1); 
     assertTrue(Arrays.equals(new double[] { 1, 1 }, array)); 
     assertEquals(Double.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeAll(new double[] { 1, 2 }, 0, 1); 
     assertTrue(Arrays.equals(ArrayUtils.EMPTY_DOUBLE_ARRAY, array)); 
     assertEquals(Double.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeAll(new double[] { 1, 2, 3 }, 0, 1); 
     assertTrue(Arrays.equals(new double[] { 3 }, array)); 
     assertEquals(Double.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeAll(new double[] { 1, 2, 3 }, 1, 2); 
     assertTrue(Arrays.equals(new double[] { 1 }, array)); 
     assertEquals(Double.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeAll(new double[] { 1, 2, 3 }, 0, 2); 
     assertTrue(Arrays.equals(new double[] { 2 }, array)); 
     assertEquals(Double.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeAll(new double[] { 1, 2, 3, 4, 5 }, 1, 3); 
     assertTrue(Arrays.equals(new double[] { 1, 3, 5 }, array)); 
     assertEquals(Double.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeAll(new double[] { 1, 2, 3, 4, 5 }, 0, 2, 4); 
     assertTrue(Arrays.equals(new double[] { 2, 4 }, array)); 
     assertEquals(Double.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeAll(new double[] { 1, 2, 3, 4, 5, 6, 7 }, 1, 3, 5); 
     assertTrue(Arrays.equals(new double[] { 1, 3, 5, 7 }, array)); 
     assertEquals(Double.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeAll(new double[] { 1, 2, 3, 4, 5, 6, 7 }, 0, 2, 4, 6); 
     assertTrue(Arrays.equals(new double[] { 2, 4, 6 }, array)); 
     assertEquals(Double.TYPE, array.getClass().getComponentType()); 
 }
@Test
public void testRemoveElementBooleanArray8068() { 
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
@SuppressWarnings("cast") 
 public void testRemoveElementLongArray8114() { 
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
@Test
public void testRemoveElementShortArray8196() { 
     short[] array; 
     array = ArrayUtils.removeElements((short[]) null, (short) 1); 
     assertNull(array); 
     array = ArrayUtils.removeElements(ArrayUtils.EMPTY_SHORT_ARRAY, (short) 1); 
     assertTrue(Arrays.equals(ArrayUtils.EMPTY_SHORT_ARRAY, array)); 
     assertEquals(Short.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeElements(new short[] { 1 }, (short) 1); 
     assertTrue(Arrays.equals(ArrayUtils.EMPTY_SHORT_ARRAY, array)); 
     assertEquals(Short.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeElements(new short[] { 1, 2 }, (short) 1); 
     assertTrue(Arrays.equals(new short[] { 2 }, array)); 
     assertEquals(Short.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeElements(new short[] { 1, 2, 1 }, (short) 1); 
     assertTrue(Arrays.equals(new short[] { 2, 1 }, array)); 
     assertEquals(Short.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeElements((short[]) null, (short) 1, (short) 1); 
     assertNull(array); 
     array = ArrayUtils.removeElements(ArrayUtils.EMPTY_SHORT_ARRAY, (short) 1, (short) 1); 
     assertTrue(Arrays.equals(ArrayUtils.EMPTY_SHORT_ARRAY, array)); 
     assertEquals(Short.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeElements(new short[] { 1 }, (short) 1, (short) 1); 
     assertTrue(Arrays.equals(ArrayUtils.EMPTY_SHORT_ARRAY, array)); 
     assertEquals(Short.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeElements(new short[] { 1, 2 }, (short) 1, (short) 2); 
     assertTrue(Arrays.equals(ArrayUtils.EMPTY_SHORT_ARRAY, array)); 
     assertEquals(Short.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeElements(new short[] { 1, 2 }, (short) 1, (short) 1); 
     assertTrue(Arrays.equals(new short[] { 2 }, array)); 
     assertEquals(Short.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeElements(new short[] { 1, 2, 1 }, (short) 1, (short) 1); 
     assertTrue(Arrays.equals(new short[] { 2 }, array)); 
     assertEquals(Short.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeElements(new short[] { 1, 2, 1 }, (short) 1, (short) 2); 
     assertTrue(Arrays.equals(new short[] { 1 }, array)); 
     assertEquals(Short.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeElements(new short[] { 1, 2, 1 }, (short) 1, (short) 1, (short) 1, (short) 1); 
     assertTrue(Arrays.equals(new short[] { 2 }, array)); 
     assertEquals(Short.TYPE, array.getClass().getComponentType()); 
 }
@Test
public void testRemoveElementBooleanArray8299() { 
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
public void testRemoveElementCharArray8356() { 
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
 public void testRemoveElementDoubleArray8412() { 
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
@SuppressWarnings("cast") 
 public void testRemoveElementDoubleArray8455() { 
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
public void testRemoveElementCharArray8477() { 
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
public void testRemoveElementCharArray8504() { 
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
 public void testRemoveElementLongArray8508() { 
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
@Test
public void testRemoveElementCharArray8510() { 
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
 public void testRemoveElementLongArray8516() { 
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
@Test
public void testRemoveElementBooleanArray8594() { 
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
public void testRemoveAllShortArrayRemoveNone8614() { 
     final short[] array1 = new short[] { 1, 2 }; 
     final short[] array2 = ArrayUtils.removeAll(array1); 
     assertNotSame(array1, array2); 
     assertArrayEquals(array1, array2); 
     assertEquals(short.class, array2.getClass().getComponentType()); 
 }
@Test
public void testRemoveElementIntArray8622() { 
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
@Test
public void testRemoveElementShortArray8784() { 
     short[] array; 
     array = ArrayUtils.removeElements((short[]) null, (short) 1); 
     assertNull(array); 
     array = ArrayUtils.removeElements(ArrayUtils.EMPTY_SHORT_ARRAY, (short) 1); 
     assertTrue(Arrays.equals(ArrayUtils.EMPTY_SHORT_ARRAY, array)); 
     assertEquals(Short.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeElements(new short[] { 1 }, (short) 1); 
     assertTrue(Arrays.equals(ArrayUtils.EMPTY_SHORT_ARRAY, array)); 
     assertEquals(Short.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeElements(new short[] { 1, 2 }, (short) 1); 
     assertTrue(Arrays.equals(new short[] { 2 }, array)); 
     assertEquals(Short.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeElements(new short[] { 1, 2, 1 }, (short) 1); 
     assertTrue(Arrays.equals(new short[] { 2, 1 }, array)); 
     assertEquals(Short.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeElements((short[]) null, (short) 1, (short) 1); 
     assertNull(array); 
     array = ArrayUtils.removeElements(ArrayUtils.EMPTY_SHORT_ARRAY, (short) 1, (short) 1); 
     assertTrue(Arrays.equals(ArrayUtils.EMPTY_SHORT_ARRAY, array)); 
     assertEquals(Short.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeElements(new short[] { 1 }, (short) 1, (short) 1); 
     assertTrue(Arrays.equals(ArrayUtils.EMPTY_SHORT_ARRAY, array)); 
     assertEquals(Short.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeElements(new short[] { 1, 2 }, (short) 1, (short) 2); 
     assertTrue(Arrays.equals(ArrayUtils.EMPTY_SHORT_ARRAY, array)); 
     assertEquals(Short.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeElements(new short[] { 1, 2 }, (short) 1, (short) 1); 
     assertTrue(Arrays.equals(new short[] { 2 }, array)); 
     assertEquals(Short.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeElements(new short[] { 1, 2, 1 }, (short) 1, (short) 1); 
     assertTrue(Arrays.equals(new short[] { 2 }, array)); 
     assertEquals(Short.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeElements(new short[] { 1, 2, 1 }, (short) 1, (short) 2); 
     assertTrue(Arrays.equals(new short[] { 1 }, array)); 
     assertEquals(Short.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeElements(new short[] { 1, 2, 1 }, (short) 1, (short) 1, (short) 1, (short) 1); 
     assertTrue(Arrays.equals(new short[] { 2 }, array)); 
     assertEquals(Short.TYPE, array.getClass().getComponentType()); 
 }
@Test(expected = IndexOutOfBoundsException.class) 
 public void testRemoveAllIntArrayOutOfBoundsIndex8788() { 
     ArrayUtils.removeAll(new int[] { 1, 2 }, 2); 
 }
@Test
public void testRemoveElementIntArray8849() { 
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
@Test
public void testRemoveElementCharArray8923() { 
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
@Test(expected = IndexOutOfBoundsException.class) 
 public void testRemoveAllLongArrayOutOfBoundsIndex8927() { 
     ArrayUtils.removeAll(new long[] { 1, 2 }, 2); 
 }
@Test
public void testRemoveAllDoubleArray9086() { 
     double[] array; 
     array = ArrayUtils.removeAll(new double[] { 1 }, 0); 
     assertTrue(Arrays.equals(ArrayUtils.EMPTY_DOUBLE_ARRAY, array)); 
     assertEquals(Double.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeAll(new double[] { 1, 2 }, 0); 
     assertTrue(Arrays.equals(new double[] { 2 }, array)); 
     assertEquals(Double.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeAll(new double[] { 1, 2 }, 1); 
     assertTrue(Arrays.equals(new double[] { 1 }, array)); 
     assertEquals(Double.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeAll(new double[] { 1, 2, 1 }, 1); 
     assertTrue(Arrays.equals(new double[] { 1, 1 }, array)); 
     assertEquals(Double.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeAll(new double[] { 1, 2 }, 0, 1); 
     assertTrue(Arrays.equals(ArrayUtils.EMPTY_DOUBLE_ARRAY, array)); 
     assertEquals(Double.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeAll(new double[] { 1, 2, 3 }, 0, 1); 
     assertTrue(Arrays.equals(new double[] { 3 }, array)); 
     assertEquals(Double.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeAll(new double[] { 1, 2, 3 }, 1, 2); 
     assertTrue(Arrays.equals(new double[] { 1 }, array)); 
     assertEquals(Double.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeAll(new double[] { 1, 2, 3 }, 0, 2); 
     assertTrue(Arrays.equals(new double[] { 2 }, array)); 
     assertEquals(Double.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeAll(new double[] { 1, 2, 3, 4, 5 }, 1, 3); 
     assertTrue(Arrays.equals(new double[] { 1, 3, 5 }, array)); 
     assertEquals(Double.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeAll(new double[] { 1, 2, 3, 4, 5 }, 0, 2, 4); 
     assertTrue(Arrays.equals(new double[] { 2, 4 }, array)); 
     assertEquals(Double.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeAll(new double[] { 1, 2, 3, 4, 5, 6, 7 }, 1, 3, 5); 
     assertTrue(Arrays.equals(new double[] { 1, 3, 5, 7 }, array)); 
     assertEquals(Double.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeAll(new double[] { 1, 2, 3, 4, 5, 6, 7 }, 0, 2, 4, 6); 
     assertTrue(Arrays.equals(new double[] { 2, 4, 6 }, array)); 
     assertEquals(Double.TYPE, array.getClass().getComponentType()); 
 }
@Test
public void testRemoveElementIntArray9126() { 
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
 public void testRemoveAllLongArrayOutOfBoundsIndex9195() { 
     ArrayUtils.removeAll(new long[] { 1, 2 }, 2); 
 }
@Test
public void testRemoveAllDoubleArray9205() { 
     double[] array; 
     array = ArrayUtils.removeAll(new double[] { 1 }, 0); 
     assertTrue(Arrays.equals(ArrayUtils.EMPTY_DOUBLE_ARRAY, array)); 
     assertEquals(Double.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeAll(new double[] { 1, 2 }, 0); 
     assertTrue(Arrays.equals(new double[] { 2 }, array)); 
     assertEquals(Double.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeAll(new double[] { 1, 2 }, 1); 
     assertTrue(Arrays.equals(new double[] { 1 }, array)); 
     assertEquals(Double.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeAll(new double[] { 1, 2, 1 }, 1); 
     assertTrue(Arrays.equals(new double[] { 1, 1 }, array)); 
     assertEquals(Double.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeAll(new double[] { 1, 2 }, 0, 1); 
     assertTrue(Arrays.equals(ArrayUtils.EMPTY_DOUBLE_ARRAY, array)); 
     assertEquals(Double.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeAll(new double[] { 1, 2, 3 }, 0, 1); 
     assertTrue(Arrays.equals(new double[] { 3 }, array)); 
     assertEquals(Double.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeAll(new double[] { 1, 2, 3 }, 1, 2); 
     assertTrue(Arrays.equals(new double[] { 1 }, array)); 
     assertEquals(Double.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeAll(new double[] { 1, 2, 3 }, 0, 2); 
     assertTrue(Arrays.equals(new double[] { 2 }, array)); 
     assertEquals(Double.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeAll(new double[] { 1, 2, 3, 4, 5 }, 1, 3); 
     assertTrue(Arrays.equals(new double[] { 1, 3, 5 }, array)); 
     assertEquals(Double.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeAll(new double[] { 1, 2, 3, 4, 5 }, 0, 2, 4); 
     assertTrue(Arrays.equals(new double[] { 2, 4 }, array)); 
     assertEquals(Double.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeAll(new double[] { 1, 2, 3, 4, 5, 6, 7 }, 1, 3, 5); 
     assertTrue(Arrays.equals(new double[] { 1, 3, 5, 7 }, array)); 
     assertEquals(Double.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeAll(new double[] { 1, 2, 3, 4, 5, 6, 7 }, 0, 2, 4, 6); 
     assertTrue(Arrays.equals(new double[] { 2, 4, 6 }, array)); 
     assertEquals(Double.TYPE, array.getClass().getComponentType()); 
 }
@Test
@SuppressWarnings("cast") 
 public void testRemoveElementDoubleArray9206() { 
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
public void testRemoveAllDoubleArray9281() { 
     double[] array; 
     array = ArrayUtils.removeAll(new double[] { 1 }, 0); 
     assertTrue(Arrays.equals(ArrayUtils.EMPTY_DOUBLE_ARRAY, array)); 
     assertEquals(Double.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeAll(new double[] { 1, 2 }, 0); 
     assertTrue(Arrays.equals(new double[] { 2 }, array)); 
     assertEquals(Double.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeAll(new double[] { 1, 2 }, 1); 
     assertTrue(Arrays.equals(new double[] { 1 }, array)); 
     assertEquals(Double.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeAll(new double[] { 1, 2, 1 }, 1); 
     assertTrue(Arrays.equals(new double[] { 1, 1 }, array)); 
     assertEquals(Double.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeAll(new double[] { 1, 2 }, 0, 1); 
     assertTrue(Arrays.equals(ArrayUtils.EMPTY_DOUBLE_ARRAY, array)); 
     assertEquals(Double.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeAll(new double[] { 1, 2, 3 }, 0, 1); 
     assertTrue(Arrays.equals(new double[] { 3 }, array)); 
     assertEquals(Double.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeAll(new double[] { 1, 2, 3 }, 1, 2); 
     assertTrue(Arrays.equals(new double[] { 1 }, array)); 
     assertEquals(Double.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeAll(new double[] { 1, 2, 3 }, 0, 2); 
     assertTrue(Arrays.equals(new double[] { 2 }, array)); 
     assertEquals(Double.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeAll(new double[] { 1, 2, 3, 4, 5 }, 1, 3); 
     assertTrue(Arrays.equals(new double[] { 1, 3, 5 }, array)); 
     assertEquals(Double.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeAll(new double[] { 1, 2, 3, 4, 5 }, 0, 2, 4); 
     assertTrue(Arrays.equals(new double[] { 2, 4 }, array)); 
     assertEquals(Double.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeAll(new double[] { 1, 2, 3, 4, 5, 6, 7 }, 1, 3, 5); 
     assertTrue(Arrays.equals(new double[] { 1, 3, 5, 7 }, array)); 
     assertEquals(Double.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeAll(new double[] { 1, 2, 3, 4, 5, 6, 7 }, 0, 2, 4, 6); 
     assertTrue(Arrays.equals(new double[] { 2, 4, 6 }, array)); 
     assertEquals(Double.TYPE, array.getClass().getComponentType()); 
 }
@Test
public void testRemoveElementBooleanArray9318() { 
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
public void testRemoveElementShortArray9329() { 
     short[] array; 
     array = ArrayUtils.removeElements((short[]) null, (short) 1); 
     assertNull(array); 
     array = ArrayUtils.removeElements(ArrayUtils.EMPTY_SHORT_ARRAY, (short) 1); 
     assertTrue(Arrays.equals(ArrayUtils.EMPTY_SHORT_ARRAY, array)); 
     assertEquals(Short.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeElements(new short[] { 1 }, (short) 1); 
     assertTrue(Arrays.equals(ArrayUtils.EMPTY_SHORT_ARRAY, array)); 
     assertEquals(Short.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeElements(new short[] { 1, 2 }, (short) 1); 
     assertTrue(Arrays.equals(new short[] { 2 }, array)); 
     assertEquals(Short.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeElements(new short[] { 1, 2, 1 }, (short) 1); 
     assertTrue(Arrays.equals(new short[] { 2, 1 }, array)); 
     assertEquals(Short.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeElements((short[]) null, (short) 1, (short) 1); 
     assertNull(array); 
     array = ArrayUtils.removeElements(ArrayUtils.EMPTY_SHORT_ARRAY, (short) 1, (short) 1); 
     assertTrue(Arrays.equals(ArrayUtils.EMPTY_SHORT_ARRAY, array)); 
     assertEquals(Short.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeElements(new short[] { 1 }, (short) 1, (short) 1); 
     assertTrue(Arrays.equals(ArrayUtils.EMPTY_SHORT_ARRAY, array)); 
     assertEquals(Short.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeElements(new short[] { 1, 2 }, (short) 1, (short) 2); 
     assertTrue(Arrays.equals(ArrayUtils.EMPTY_SHORT_ARRAY, array)); 
     assertEquals(Short.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeElements(new short[] { 1, 2 }, (short) 1, (short) 1); 
     assertTrue(Arrays.equals(new short[] { 2 }, array)); 
     assertEquals(Short.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeElements(new short[] { 1, 2, 1 }, (short) 1, (short) 1); 
     assertTrue(Arrays.equals(new short[] { 2 }, array)); 
     assertEquals(Short.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeElements(new short[] { 1, 2, 1 }, (short) 1, (short) 2); 
     assertTrue(Arrays.equals(new short[] { 1 }, array)); 
     assertEquals(Short.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeElements(new short[] { 1, 2, 1 }, (short) 1, (short) 1, (short) 1, (short) 1); 
     assertTrue(Arrays.equals(new short[] { 2 }, array)); 
     assertEquals(Short.TYPE, array.getClass().getComponentType()); 
 }
@Test
@SuppressWarnings("cast") 
 public void testRemoveElementLongArray9332() { 
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
@Test
public void testRemoveAllDoubleArray9344() { 
     double[] array; 
     array = ArrayUtils.removeAll(new double[] { 1 }, 0); 
     assertTrue(Arrays.equals(ArrayUtils.EMPTY_DOUBLE_ARRAY, array)); 
     assertEquals(Double.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeAll(new double[] { 1, 2 }, 0); 
     assertTrue(Arrays.equals(new double[] { 2 }, array)); 
     assertEquals(Double.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeAll(new double[] { 1, 2 }, 1); 
     assertTrue(Arrays.equals(new double[] { 1 }, array)); 
     assertEquals(Double.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeAll(new double[] { 1, 2, 1 }, 1); 
     assertTrue(Arrays.equals(new double[] { 1, 1 }, array)); 
     assertEquals(Double.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeAll(new double[] { 1, 2 }, 0, 1); 
     assertTrue(Arrays.equals(ArrayUtils.EMPTY_DOUBLE_ARRAY, array)); 
     assertEquals(Double.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeAll(new double[] { 1, 2, 3 }, 0, 1); 
     assertTrue(Arrays.equals(new double[] { 3 }, array)); 
     assertEquals(Double.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeAll(new double[] { 1, 2, 3 }, 1, 2); 
     assertTrue(Arrays.equals(new double[] { 1 }, array)); 
     assertEquals(Double.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeAll(new double[] { 1, 2, 3 }, 0, 2); 
     assertTrue(Arrays.equals(new double[] { 2 }, array)); 
     assertEquals(Double.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeAll(new double[] { 1, 2, 3, 4, 5 }, 1, 3); 
     assertTrue(Arrays.equals(new double[] { 1, 3, 5 }, array)); 
     assertEquals(Double.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeAll(new double[] { 1, 2, 3, 4, 5 }, 0, 2, 4); 
     assertTrue(Arrays.equals(new double[] { 2, 4 }, array)); 
     assertEquals(Double.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeAll(new double[] { 1, 2, 3, 4, 5, 6, 7 }, 1, 3, 5); 
     assertTrue(Arrays.equals(new double[] { 1, 3, 5, 7 }, array)); 
     assertEquals(Double.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeAll(new double[] { 1, 2, 3, 4, 5, 6, 7 }, 0, 2, 4, 6); 
     assertTrue(Arrays.equals(new double[] { 2, 4, 6 }, array)); 
     assertEquals(Double.TYPE, array.getClass().getComponentType()); 
 }
@Test
public void testRemoveAllDoubleArray9399() { 
     double[] array; 
     array = ArrayUtils.removeAll(new double[] { 1 }, 0); 
     assertTrue(Arrays.equals(ArrayUtils.EMPTY_DOUBLE_ARRAY, array)); 
     assertEquals(Double.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeAll(new double[] { 1, 2 }, 0); 
     assertTrue(Arrays.equals(new double[] { 2 }, array)); 
     assertEquals(Double.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeAll(new double[] { 1, 2 }, 1); 
     assertTrue(Arrays.equals(new double[] { 1 }, array)); 
     assertEquals(Double.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeAll(new double[] { 1, 2, 1 }, 1); 
     assertTrue(Arrays.equals(new double[] { 1, 1 }, array)); 
     assertEquals(Double.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeAll(new double[] { 1, 2 }, 0, 1); 
     assertTrue(Arrays.equals(ArrayUtils.EMPTY_DOUBLE_ARRAY, array)); 
     assertEquals(Double.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeAll(new double[] { 1, 2, 3 }, 0, 1); 
     assertTrue(Arrays.equals(new double[] { 3 }, array)); 
     assertEquals(Double.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeAll(new double[] { 1, 2, 3 }, 1, 2); 
     assertTrue(Arrays.equals(new double[] { 1 }, array)); 
     assertEquals(Double.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeAll(new double[] { 1, 2, 3 }, 0, 2); 
     assertTrue(Arrays.equals(new double[] { 2 }, array)); 
     assertEquals(Double.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeAll(new double[] { 1, 2, 3, 4, 5 }, 1, 3); 
     assertTrue(Arrays.equals(new double[] { 1, 3, 5 }, array)); 
     assertEquals(Double.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeAll(new double[] { 1, 2, 3, 4, 5 }, 0, 2, 4); 
     assertTrue(Arrays.equals(new double[] { 2, 4 }, array)); 
     assertEquals(Double.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeAll(new double[] { 1, 2, 3, 4, 5, 6, 7 }, 1, 3, 5); 
     assertTrue(Arrays.equals(new double[] { 1, 3, 5, 7 }, array)); 
     assertEquals(Double.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeAll(new double[] { 1, 2, 3, 4, 5, 6, 7 }, 0, 2, 4, 6); 
     assertTrue(Arrays.equals(new double[] { 2, 4, 6 }, array)); 
     assertEquals(Double.TYPE, array.getClass().getComponentType()); 
 }
@Test
public void testRemoveAllDoubleArray9425() { 
     double[] array; 
     array = ArrayUtils.removeAll(new double[] { 1 }, 0); 
     assertTrue(Arrays.equals(ArrayUtils.EMPTY_DOUBLE_ARRAY, array)); 
     assertEquals(Double.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeAll(new double[] { 1, 2 }, 0); 
     assertTrue(Arrays.equals(new double[] { 2 }, array)); 
     assertEquals(Double.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeAll(new double[] { 1, 2 }, 1); 
     assertTrue(Arrays.equals(new double[] { 1 }, array)); 
     assertEquals(Double.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeAll(new double[] { 1, 2, 1 }, 1); 
     assertTrue(Arrays.equals(new double[] { 1, 1 }, array)); 
     assertEquals(Double.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeAll(new double[] { 1, 2 }, 0, 1); 
     assertTrue(Arrays.equals(ArrayUtils.EMPTY_DOUBLE_ARRAY, array)); 
     assertEquals(Double.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeAll(new double[] { 1, 2, 3 }, 0, 1); 
     assertTrue(Arrays.equals(new double[] { 3 }, array)); 
     assertEquals(Double.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeAll(new double[] { 1, 2, 3 }, 1, 2); 
     assertTrue(Arrays.equals(new double[] { 1 }, array)); 
     assertEquals(Double.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeAll(new double[] { 1, 2, 3 }, 0, 2); 
     assertTrue(Arrays.equals(new double[] { 2 }, array)); 
     assertEquals(Double.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeAll(new double[] { 1, 2, 3, 4, 5 }, 1, 3); 
     assertTrue(Arrays.equals(new double[] { 1, 3, 5 }, array)); 
     assertEquals(Double.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeAll(new double[] { 1, 2, 3, 4, 5 }, 0, 2, 4); 
     assertTrue(Arrays.equals(new double[] { 2, 4 }, array)); 
     assertEquals(Double.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeAll(new double[] { 1, 2, 3, 4, 5, 6, 7 }, 1, 3, 5); 
     assertTrue(Arrays.equals(new double[] { 1, 3, 5, 7 }, array)); 
     assertEquals(Double.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeAll(new double[] { 1, 2, 3, 4, 5, 6, 7 }, 0, 2, 4, 6); 
     assertTrue(Arrays.equals(new double[] { 2, 4, 6 }, array)); 
     assertEquals(Double.TYPE, array.getClass().getComponentType()); 
 }
@Test
@SuppressWarnings("cast") 
 public void testRemoveElementLongArray9497() { 
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
@Test
public void testRemoveElementBooleanArray9577() { 
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
public void testRemoveAllLongArray11556() { 
         long[] array; 
         array = ArrayUtils.removeAll(new long[] { 1, 2 }, 2); 
         assertTrue(Arrays.equals(ArrayUtils.EMPTY_LONG_ARRAY, array)); 
         assertEquals(Long.TYPE, array.getClass().getComponentType()); 
         array = ArrayUtils.removeAll(new long[] { 1, 2 }, 2); 
         assertTrue(Arrays.equals(new long[] { 2 }, array)); 
         assertEquals(Long.TYPE, array.getClass().getComponentType()); 
         array = ArrayUtils.removeAll(new long[] { 1, 2, 1 }, 2); 
         assertTrue(Arrays.equals(new long[] { 1, 1 }, array)); 
         assertEquals(Long.TYPE, array.getClass().getComponentType()); 
         array = ArrayUtils.removeAll(new long[] { 1, 2, 1 }, 2); 
         assertTrue(Arrays.equals(new long[] { 1, 1 }, array)); 
         assertEquals(Long.TYPE, array.getClass().getComponentType()); 
  
         array = ArrayUtils.removeAll(new long[] { 1, 2, 3 }, 2); 
         assertTrue(Arrays.equals(new long[] { 3 }, array)); 
         assertEquals(Long.TYPE, array.getClass().getComponentType()); 
         array = ArrayUtils.removeAll(new long[] { 1, 2, 3, 1 }, 2); 
         assertTrue(Arrays.equals(new long[] { 3, 1 }, array)); 
         assertEquals(Long.TYPE, array.getClass().getComponentType()); 
     }
@Test
public void testIndexOfByteWithStartIndex11557() { 
         byte[] array = null; 
         assertEquals(-1, ArrayUtils.indexOf(array, (byte) 0, 2)); 
         array = new byte[] { 0, 1, 2, 3, 0 }; 
         assertEquals(0, ArrayUtils.indexOf(array, (byte) 0, 2)); 
         assertEquals(1, ArrayUtils.indexOf(array, (byte) 1, 2)); 
         assertEquals(2, ArrayUtils.indexOf(array, (byte) 2, 2)); 
         assertEquals(-1, ArrayUtils.indexOf(array, (byte) 3, 2)); 
         assertEquals(-1, ArrayUtils.indexOf(array, (byte) 3, -1)); 
         assertEquals(-1, ArrayUtils.indexOf(array, (byte) 99)); 
         assertEquals(4, ArrayUtils.indexOf(array, (byte) 0, 88)); 
     }
@Test
public void testRemoveAllLongArray11564() { 
         long[] array; 
         array = ArrayUtils.removeAll(new long[] { 1, 2 }, 2); 
         assertTrue(Arrays.equals(ArrayUtils.EMPTY_LONG_ARRAY, array)); 
         assertEquals(Long.TYPE, array.getClass().getComponentType()); 
         array = ArrayUtils.removeAll(new long[] { 1, 2 }, 2); 
         assertTrue(Arrays.equals(new long[] { 2 }, array)); 
         assertEquals(Long.TYPE, array.getClass().getComponentType()); 
         array = ArrayUtils.removeAll(new long[] { 1, 2, 1 }, 2); 
         assertTrue(Arrays.equals(new long[] { 1, 1 }, array)); 
         assertEquals(Long.TYPE, array.getClass().getComponentType()); 
         array = ArrayUtils.removeAll(new long[] { 1, 2, 1 }, 2); 
         assertTrue(Arrays.equals(new long[] { 1, 1 }, array)); 
         assertEquals(Long.TYPE, array.getClass().getComponentType()); 
  
         array = ArrayUtils.removeAll(new long[] { 1, 2, 3 }, 2); 
         assertTrue(Arrays.equals(new long[] { 3 }, array)); 
         assertEquals(Long.TYPE, array.getClass().getComponentType()); 
         array = ArrayUtils.removeAll(new long[] { 1, 2, 3, 1 }, 2); 
         assertTrue(Arrays.equals(new long[] { 3, 1 }, array)); 
         assertEquals(Long.TYPE, array.getClass().getComponentType()); 
     }
@Test
public void testRemoveAllBooleanArray11565() { 
         boolean[] array; 
         array = ArrayUtils.removeAll(new boolean[] { true }, new BitSet(0)); 
         assertTrue(Arrays.equals(ArrayUtils.EMPTY_BOOLEAN_ARRAY, array)); 
         assertEquals(Boolean.TYPE, array.getClass().getComponentType()); 
         array = ArrayUtils.removeAll(new boolean[] { true, false }, new BitSet(1)); 
         assertTrue(Arrays.equals(new boolean[] { false }, array)); 
         assertEquals(Boolean.TYPE, array.getClass().getComponentType()); 
         array = ArrayUtils.removeAll(new boolean[] { true, false, true }, new BitSet(2)); 
         assertTrue(Arrays.equals(new boolean[] { true, false }, array)); 
         assertEquals(Boolean.TYPE, array.getClass().getComponentType()); 
         array = ArrayUtils.removeAll(new boolean[] { true, true, false }, new BitSet(3)); 
         assertTrue(Arrays.equals(new boolean[] { false, true }, array)); 
         assertEquals(Boolean.TYPE, array.getClass().getComponentType()); 
  
         array = ArrayUtils.removeAll(new boolean[] { true, false, true }, new BitSet(1)); 
         assertTrue(Arrays.equals(ArrayUtils.EMPTY_BOOLEAN_ARRAY, array)); 
         assertEquals(Boolean.TYPE, array.getClass().getComponentType()); 
         array = ArrayUtils.removeAll(new boolean[] { true, false, true }, new BitSet(2)); 
         assertTrue(Arrays.equals(new boolean[] { true, false }, array)); 
         assertEquals(Boolean.TYPE, array.getClass().getComponentType()); 
     }
@Test
public void testIndexOfByteWithStartIndex11566() { 
         byte[] array = null; 
         assertEquals(-1, ArrayUtils.indexOf(array, (byte) 0, 2)); 
         array = new byte[] { 0, 1, 2, 3, 0 }; 
         assertEquals(0, ArrayUtils.indexOf(array, (byte) 0, 2)); 
         assertEquals(1, ArrayUtils.indexOf(array, (byte) 1, 2)); 
         assertEquals(2, ArrayUtils.indexOf(array, (byte) 2, 2)); 
         assertEquals(-1, ArrayUtils.indexOf(array, (byte) 3, 2)); 
         assertEquals(-1, ArrayUtils.indexOf(array, (byte) 3, -1)); 
         assertEquals(-1, ArrayUtils.indexOf(array, (byte) 99)); 
         assertEquals(4, ArrayUtils.indexOf(array, (byte) 0, 88)); 
     }
@Test
public void testRemoveAllLongArray11572() { 
         long[] array; 
         array = ArrayUtils.removeAll(new long[] { 1, 2 }, 2); 
         assertTrue(Arrays.equals(ArrayUtils.EMPTY_LONG_ARRAY, array)); 
         assertEquals(Long.TYPE, array.getClass().getComponentType()); 
         array = ArrayUtils.removeAll(new long[] { 1, 2 }, 2); 
         assertTrue(Arrays.equals(new long[] { 2 }, array)); 
         assertEquals(Long.TYPE, array.getClass().getComponentType()); 
         array = ArrayUtils.removeAll(new long[] { 1, 2, 1 }, 2); 
         assertTrue(Arrays.equals(new long[] { 1, 1 }, array)); 
         assertEquals(Long.TYPE, array.getClass().getComponentType()); 
         array = ArrayUtils.removeAll(new long[] { 1, 2, 1 }, 2); 
         assertTrue(Arrays.equals(new long[] { 1, 1 }, array)); 
         assertEquals(Long.TYPE, array.getClass().getComponentType()); 
  
         array = ArrayUtils.removeAll(new long[] { 1, 2, 3 }, 2); 
         assertTrue(Arrays.equals(ArrayUtils.EMPTY_LONG_ARRAY, array)); 
         assertEquals(Long.TYPE, array.getClass().getComponentType()); 
         array = ArrayUtils.removeAll(new long[] { 1, 2, 3, 1 }, 2); 
         assertTrue(Arrays.equals(new long[] { 3, 1 }, array)); 
         assertEquals(Long.TYPE, array.getClass().getComponentType()); 
     }
@Test
public void testRemoveAllLongArray11574() { 
         long[] array; 
         array = ArrayUtils.removeAll(new long[] { 1, 2 }, 2); 
         assertTrue(Arrays.equals(ArrayUtils.EMPTY_LONG_ARRAY, array)); 
         assertEquals(Long.TYPE, array.getClass().getComponentType()); 
         array = ArrayUtils.removeAll(new long[] { 1, 2 }, 2); 
         assertTrue(Arrays.equals(new long[] { 2 }, array)); 
         assertEquals(Long.TYPE, array.getClass().getComponentType()); 
         array = ArrayUtils.removeAll(new long[] { 1, 2, 1 }, 2); 
         assertTrue(Arrays.equals(new long[] { 1, 1 }, array)); 
         assertEquals(Long.TYPE, array.getClass().getComponentType()); 
         array = ArrayUtils.removeAll(new long[] { 1, 2, 1 }, 2); 
         assertTrue(Arrays.equals(new long[] { 1, 1 }, array)); 
         assertEquals(Long.TYPE, array.getClass().getComponentType()); 
  
         array = ArrayUtils.removeAll(new long[] { 1, 2, 3 }, 2); 
         assertTrue(Arrays.equals(new long[] { 3 }, array)); 
         assertEquals(Long.TYPE, array.getClass().getComponentType()); 
         array = ArrayUtils.removeAll(new long[] { 1, 2, 3, 1 }, 2); 
         assertTrue(Arrays.equals(new long[] { 3, 1 }, array)); 
         assertEquals(Long.TYPE, array.getClass().getComponentType()); 
     }
@Test
public void testIndexOfByteWithStartIndex11582() { 
         byte[] array = null; 
         assertEquals(-1, ArrayUtils.indexOf(array, (byte) 0, 2)); 
         array = new byte[] { 0, 1, 2, 3, 0 }; 
         assertEquals(0, ArrayUtils.indexOf(array, (byte) 0, 2)); 
         assertEquals(1, ArrayUtils.indexOf(array, (byte) 1, 2)); 
         assertEquals(2, ArrayUtils.indexOf(array, (byte) 2, 2)); 
         assertEquals(-1, ArrayUtils.indexOf(array, (byte) 3, 2)); 
         assertEquals(-1, ArrayUtils.indexOf(array, (byte) 3, -1)); 
         assertEquals(-1, ArrayUtils.indexOf(array, (byte) 99)); 
         assertEquals(4, ArrayUtils.indexOf(array, (byte) 0, 88)); 
     }
@Test
public void testIndexOfByteWithStartIndex11590() { 
         byte[] array = null; 
         assertEquals(-1, ArrayUtils.indexOf(array, (byte) 0, 2)); 
         array = new byte[] { 0, 1, 2, 3, 0 }; 
         assertEquals(0, ArrayUtils.indexOf(array, (byte) 0, 2)); 
         assertEquals(1, ArrayUtils.indexOf(array, (byte) 1, 2)); 
         assertEquals(2, ArrayUtils.indexOf(array, (byte) 2, 2)); 
         assertEquals(-1, ArrayUtils.indexOf(array, (byte) 3, 2)); 
         assertEquals(-1, ArrayUtils.indexOf(array, (byte) 3, -1)); 
         assertEquals(-1, ArrayUtils.indexOf(array, (byte) 99)); 
         assertEquals(4, ArrayUtils.indexOf(array, (byte) 0, 88)); 
     }
@Test
public void testRemoveAllLongArray11592() { 
         long[] array; 
         array = ArrayUtils.removeAll(new long[] { 1, 2 }, 2); 
         assertTrue(Arrays.equals(ArrayUtils.EMPTY_LONG_ARRAY, array)); 
         assertEquals(Long.TYPE, array.getClass().getComponentType()); 
         array = ArrayUtils.removeAll(new long[] { 1, 2 }, 2); 
         assertTrue(Arrays.equals(new long[] { 2 }, array)); 
         assertEquals(Long.TYPE, array.getClass().getComponentType()); 
         array = ArrayUtils.removeAll(new long[] { 1, 2, 1 }, 2); 
         assertTrue(Arrays.equals(new long[] { 1, 1 }, array)); 
         assertEquals(Long.TYPE, array.getClass().getComponentType()); 
         array = ArrayUtils.removeAll(new long[] { 1, 2, 1 }, 2); 
         assertTrue(Arrays.equals(new long[] { 1, 1 }, array)); 
         assertEquals(Long.TYPE, array.getClass().getComponentType()); 
  
         array = ArrayUtils.removeAll(new long[] { 1, 2, 3 }, 2); 
         assertTrue(Arrays.equals(new long[] { 3 }, array)); 
         assertEquals(Long.TYPE, array.getClass().getComponentType()); 
         array = ArrayUtils.removeAll(new long[] { 1, 2, 3, 1 }, 2); 
         assertTrue(Arrays.equals(new long[] { 3, 1 }, array)); 
         assertEquals(Long.TYPE, array.getClass().getComponentType()); 
     }
@Test
public void testIndexOfByteWithStartIndex11593() { 
         byte[] array = null; 
         assertEquals(-1, ArrayUtils.indexOf(array, (byte) 0, 2)); 
         array = new byte[] { 0, 1, 2, 3, 0 }; 
         assertEquals(0, ArrayUtils.indexOf(array, (byte) 0, 2)); 
         assertEquals(1, ArrayUtils.indexOf(array, (byte) 1, 2)); 
         assertEquals(2, ArrayUtils.indexOf(array, (byte) 2, 2)); 
         assertEquals(-1, ArrayUtils.indexOf(array, (byte) 3, 2)); 
         assertEquals(-1, ArrayUtils.indexOf(array, (byte) 3, -1)); 
         assertEquals(-1, ArrayUtils.indexOf(array, (byte) 99)); 
         assertEquals(4, ArrayUtils.indexOf(array, (byte) 0, 88)); 
     }
@Test
public void testIndexOfByteWithStartIndex11594() { 
         byte[] array = null; 
         assertEquals(-1, ArrayUtils.indexOf(array, (byte) 0, 2)); 
         array = new byte[] { 0, 1, 2, 3, 0 }; 
         assertEquals(0, ArrayUtils.indexOf(array, (byte) 0, 2)); 
         assertEquals(1, ArrayUtils.indexOf(array, (byte) 1, 2)); 
         assertEquals(2, ArrayUtils.indexOf(array, (byte) 2, 2)); 
         assertEquals(-1, ArrayUtils.indexOf(array, (byte) 3, 2)); 
         assertEquals(-1, ArrayUtils.indexOf(array, (byte) 3, -1)); 
         assertEquals(-1, ArrayUtils.indexOf(array, (byte) 99)); 
         assertEquals(4, ArrayUtils.indexOf(array, (byte) 0, 88)); 
     }
@Test
public void testIndexOfByteWithStartIndex11600() { 
         byte[] array = null; 
         assertEquals(-1, ArrayUtils.indexOf(array, (byte) 0, 2)); 
         array = new byte[] { 0, 1, 2, 3, 0 }; 
         assertEquals(0, ArrayUtils.indexOf(array, (byte) 0, 2)); 
         assertEquals(1, ArrayUtils.indexOf(array, (byte) 1, 2)); 
         assertEquals(2, ArrayUtils.indexOf(array, (byte) 2, 2)); 
         assertEquals(-1, ArrayUtils.indexOf(array, (byte) 3, 2)); 
         assertEquals(-1, ArrayUtils.indexOf(array, (byte) 3, -1)); 
         assertEquals(-1, ArrayUtils.indexOf(array, (byte) 99)); 
         assertEquals(4, ArrayUtils.indexOf(array, (byte) 0, 88)); 
     }
@Test
public void testRemoveAllLongArray11601() { 
         long[] array; 
         array = ArrayUtils.removeAll(new long[] { 1, 2 }, 2); 
         assertTrue(Arrays.equals(ArrayUtils.EMPTY_LONG_ARRAY, array)); 
         assertEquals(Long.TYPE, array.getClass().getComponentType()); 
         array = ArrayUtils.removeAll(new long[] { 1, 2 }, 2); 
         assertTrue(Arrays.equals(new long[] { 2 }, array)); 
         assertEquals(Long.TYPE, array.getClass().getComponentType()); 
         array = ArrayUtils.removeAll(new long[] { 1, 2, 1 }, 2); 
         assertTrue(Arrays.equals(new long[] { 1, 1 }, array)); 
         assertEquals(Long.TYPE, array.getClass().getComponentType()); 
         array = ArrayUtils.removeAll(new long[] { 1, 2, 1 }, 2); 
         assertTrue(Arrays.equals(new long[] { 1, 1 }, array)); 
         assertEquals(Long.TYPE, array.getClass().getComponentType()); 
  
         array = ArrayUtils.removeAll(new long[] { 1, 2, 3 }, 2); 
         assertTrue(Arrays.equals(new long[] { 3 }, array)); 
         assertEquals(Long.TYPE, array.getClass().getComponentType()); 
         array = ArrayUtils.removeAll(new long[] { 1, 2, 3, 1 }, 2); 
         assertTrue(Arrays.equals(new long[] { 3, 1 }, array)); 
         assertEquals(Long.TYPE, array.getClass().getComponentType()); 
     }
    

    

    

    

    

    

    

    

    

    

    

    

    

    

    

    

    

    

    

    

    

    

    

    

    

    

    

    

    

    

    

    

    

    

    

    

    

    

    

    

    

    

    

    

    

    

    

    

    

    

    

    

    

    

    

}
