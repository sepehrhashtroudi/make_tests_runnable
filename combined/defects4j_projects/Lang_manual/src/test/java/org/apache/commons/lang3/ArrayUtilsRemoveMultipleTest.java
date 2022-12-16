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
public void testRemoveElementShortArray22() { 
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
     array =
@Test
public void testRemoveElementByteArray78() { 
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
     array = ArrayUtils.removeElements((byte[]) null, (byte) 1, (byte) 1); 
     assertNull(array); 
     array = ArrayUtils.removeElements(ArrayUtils.EMPTY_BYTE_ARRAY, (byte) 1, (byte) 1); 
     assertTrue(Arrays.equals(ArrayUtils.EMPTY_BYTE_ARRAY, array)); 
     assertEquals(Byte.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeElements(new byte[] { 1 }, (byte) 1, (byte) 1); 
     assertTrue(Arrays.equals(ArrayUtils.EMPTY_BYTE_ARRAY, array)); 
     assertEquals(Byte.TYPE, array.getClass().getComponentType()); 
     array =
@Test
public void testRemoveElementCharArray108() { 
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
     array = ArrayUtils.removeElements(new char[] { 'a', 'b' }, 'a'); 
     assertTrue(Arrays.equals(new char[] { 'b' }, array)); 
     assertEquals(Character.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeElements((char[]) null, 'a', 'b'); 
     assertNull(array); 
     array = ArrayUtils.removeElements(ArrayUtils.EMPTY_CHAR_ARRAY, 'a', 'b'); 
     assertTrue(Arrays.equals(ArrayUtils.EMPTY_CHAR_ARRAY, array)); 
     assertEquals(Character.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeElements(new char[] { 'a' }, 'a', 'b'); 
     assertTrue(Arrays.equals(ArrayUtils.EMPTY_CHAR_ARRAY, array)); 
     assertEquals(Character.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeElements(new char[] { 'a', 'b'
@Test(expected = IndexOutOfBoundsException.class) 
 public void testRemoveAllFloatArrayNegativeIndex128() { 
     ArrayUtils.removeAll(new float[] { 1, 2 }, -1); 
 }
@Test(expected = IndexOutOfBoundsException.class) 
 public void testRemoveAllDoubleArrayNegativeIndex504() { 
     ArrayUtils.removeAll(new double[] { 1, 2 }, -1); 
 }
@Test
public void testRemoveAllObjectArray505() { 
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
     array = ArrayUtils.removeAll(new Object[] { "a", "d" }, 0, 3); 
     assertArrayEquals(new Object[] { "b", "c" }, array); 
     assertEquals(Object.class, array.getClass().getComponentType()); 
     array = ArrayUtils.removeAll(new Object[] { "a", "d" }, 1, 2); 
     assertArrayEquals(new Object[] { "c" }, array); 
     assertEquals(Object.class, array.getClass().getComponentType()); 
     array = ArrayUtils.removeAll(new Object[] { "a", "b", "c", "d" }, 0, 1, 3); 
     assertArrayEquals(new Object[] { "c" }, array); 
     assertEquals(Object.class, array.getClass().getComponentType()); 
     array = ArrayUtils.removeAll(new Object[] {
@Test
public void testRemoveAllDoubleArrayRemoveNone506() { 
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
     assertTrue(Arrays.equals(new double[] { 2 }, array
    

    

    

    

    

    

    

    

    

    

    

    

    

    

    

    

    

    

    

    

    

    

    

    

    

    

    

    

    

    

    

    

    

    

    

    

    

    

    

    

    

    

    

    

    

    

    

    

    

    

    

    

    

    

    

}
