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
public void testToMap181() { 
     final Object[] array = new Object[] { "a", "b", "c" }; 
     assertEquals("map", ArrayUtils.toMap(array)); 
     assertEquals("a", ArrayUtils.toMap(new Object[] { "a", "b", "c" })); 
     assertEquals("map", ArrayUtils.toMap(new Object[] { "a", "b", "c" })); 
     try { 
         ArrayUtils.toMap(new Object[] { "1", null }); 
         fail("IndexOutOfBoundsException expected"); 
     } catch (final IndexOutOfBoundsException e) { 
     } 
     try { 
         ArrayUtils.toMap(new Object[] { "a", "b", "c" }); 
         fail("IndexOutOfBoundsException expected"); 
     } catch (final IndexOutOfBoundsException e) { 
     } 
     try { 
         ArrayUtils.toMap(new Object[] { "1", "2", "3" }); 
         fail("IndexOutOfBoundsException expected"); 
     } catch (final IndexOutOfBoundsException e) { 
     } 
     try { 
         ArrayUtils.toMap(new Object[] { "a", "b", "c", "d" }); 
         fail("IndexOutOfBoundsException expected"); 
     } catch (final IndexOutOfBoundsException e) { 
     } 
     try { 
         ArrayUtils.toMap(new Object[] { "1", "2", "3" }); 
         fail("IndexOutOfBoundsException expected"); 
     } catch (final IndexOutOfBoundsException e) { 
     } 
     try { 
         ArrayUtils.toMap(new Object[] { "a", "b", "c", "d" }); 
         fail("IndexOutOfBoundsException expected"); 
     } catch (final IndexOutOfBoundsException e) { 
     } 
 }
@Test
public void testToMap183() { 
     final Object[] array = new Object[] { "a", "b", "c" }; 
     assertEquals("map", ArrayUtils.toMap(array)); 
     assertEquals("a", ArrayUtils.toMap(new Object[] { "a", "b", "c" }).get("a")); 
     assertEquals("b", ArrayUtils.toMap(new Object[] { "b", "c" }).get("c")); 
     try { 
         ArrayUtils.toMap(new Object[] { "1", null }); 
         fail("IndexOutOfBoundsException expected"); 
     } catch (final IndexOutOfBoundsException e) { 
     } 
     try { 
         ArrayUtils.toMap(new Object[] { "a", "b", "c" }).get("a"); 
         fail("IndexOutOfBoundsException expected"); 
     } catch (final IndexOutOfBoundsException e) { 
     } 
     try { 
         ArrayUtils.toMap(new Object[] { "1", "2", "3" }); 
         fail("IndexOutOfBoundsException expected"); 
     } catch (final IndexOutOfBoundsException e) { 
     } 
     try { 
         ArrayUtils.toMap(new Object[] { "a", "b", "c", "d" }); 
         fail("IndexOutOfBoundsException expected"); 
     } catch (final IndexOutOfBoundsException e) { 
     } 
     try { 
         ArrayUtils.toMap(new Object[] { "1", "2", "3" }); 
         fail("IndexOutOfBoundsException expected"); 
     } catch (final IndexOutOfBoundsException e) { 
     } 
 }
@Test
public void testToMap184() { 
     final Object[] array = new Object[] { "0", "1", "2", "3" }; 
     assertEquals(null, ArrayUtils.toMap(array)); 
     assertEquals("0", ArrayUtils.toMap(new Object[0])); 
     assertEquals("1", ArrayUtils.toMap(new Object[] { "0", "1", "2", "3" })); 
     assertEquals("2", ArrayUtils.toMap(new Object[] { "0", "2", "3" })); 
     assertEquals("3", ArrayUtils.toMap(new Object[] { "0", "1", "2", "3" })); 
     assertEquals("4", ArrayUtils.toMap(new Object[] { "0", "1", "2", "3" })); 
     assertEquals("5", ArrayUtils.toMap(new Object[] { "0", "2", "3" })); 
     assertEquals("6", ArrayUtils.toMap(new Object[] { "0", "1", "2", "3" })); 
     assertEquals("7", ArrayUtils.toMap(new Object[] { "0", "1", "2", "3" })); 
     assertEquals("8", ArrayUtils.toMap(new Object[] { "a", "b", "c", "d" })); 
     assertEquals("9", ArrayUtils.toMap(new Object[] { "a", "b", "c", "d" })); 
 }
@Test
public void testToMap185() { 
     final Object[] array = new Object[] { "0", "1", "2", "3" }; 
     assertEquals(null, ArrayUtils.toMap(array)); 
     assertEquals("0", ArrayUtils.toMap(new Object[] { "0", "1", "2", "3" }).get("0")); 
     assertEquals("1", ArrayUtils.toMap(new Object[] { "0", "1", "2", "3" }).get("1")); 
     assertEquals("2", ArrayUtils.toMap(new Object[] { "0", "2", "3" }).get("2")); 
 }
@Test
public void testToMap187() { 
     final Map<Object, Object> map = ArrayUtils.toMap(new Object[0]); 
     assertEquals("0", map.get("0")); 
     assertEquals("1", map.get("1")); 
     assertEquals("2", map.get("2")); 
     assertEquals("3", map.get("3")); 
     assertEquals("4", map.get("4")); 
     assertEquals("5", map.get("5")); 
     assertEquals("6", map.get("6")); 
     assertEquals("7", map.get("7")); 
     assertEquals("8", map.get("8")); 
     assertEquals("9", map.get("9")); 
     assertEquals("a", map.get("A")); 
     assertEquals("B", map.get("B")); 
     assertEquals("c", map.get("C")); 
     assertEquals("d", map.get("D")); 
     assertEquals("e", map.get("E")); 
     assertEquals("f", map.get("F")); 
     assertEquals("1", map.get("1")); 
     assertEquals("2", map.get("2")); 
     assertEquals("3", map.get("3")); 
     assertEquals("4", map.get("4")); 
     assertEquals("5", map.get("5")); 
     assertEquals("6", map.get("6")); 
     assertEquals("7", map.get("7")); 
     assertEquals("8", map.get("8")); 
     assertEquals("9", map.get("9")); 
     assertEquals("a", map.get("A")); 
     assertEquals("a", map.get("A")); 
     assertEquals("b", map.get("B")); 
     assertEquals("b", map.get("B"));
}

@Test
public void testToObjectArray189() { 
     final Object[] array = new Object[] { "a", "b", "c" }; 
     assertEquals("map", ArrayUtils.toMap(array)); 
     assertEquals("a", ArrayUtils.toMap(new Object[] { "a", "b", "c" }).get("a")); 
     assertEquals("b", ArrayUtils.toMap(new Object[] { "b", "c" }).get("c")); 
     try { 
         ArrayUtils.toMap(new Object[] { "1", null }); 
         fail("IndexOutOfBoundsException expected"); 
     } catch (final IndexOutOfBoundsException e) { 
     } 
     try { 
         ArrayUtils.toMap(new Object[] { "a", "b", "c" }).get("a"); 
         fail("IndexOutOfBoundsException expected"); 
     } catch (final IndexOutOfBoundsException e) { 
     } 
     try { 
         ArrayUtils.toMap(new Object[] { "1", "2", "3" }); 
         fail("IndexOutOfBoundsException expected"); 
     } catch (final IndexOutOfBoundsException e) { 
     } 
     try { 
         ArrayUtils.toMap(new Object[] { "a", "b", "c", "d" }); 
         fail("IndexOutOfBoundsException expected"); 
     } catch (final IndexOutOfBoundsException e) { 
     } 
     try { 
         ArrayUtils.toMap(new Object[] { "1", "2", "3" }); 
         fail("IndexOutOfBoundsException expected"); 
     } catch (final IndexOutOfBoundsException e) { 
     } 
 }
@Test
public void testToMap190() { 
     final Object[] array = new Object[] { "a", "b", "c" }; 
     assertEquals("map", ArrayUtils.toMap(array)); 
     assertEquals("a", ArrayUtils.toMap(new Object[] { "a", "b", "c" })); 
     assertEquals("map", ArrayUtils.toMap(new Object[] { "a", "b", "c" })); 
     try { 
         ArrayUtils.toMap(new Object[] { "1", null }); 
         fail("Should have caused IllegalArgumentException"); 
     } catch (final IllegalArgumentException iae) { 
     } 
     try { 
         ArrayUtils.toMap(new Object[] { "a", "b", "c" }); 
         fail("Should have caused IllegalArgumentException"); 
     } catch (final IllegalArgumentException iae) { 
     } 
     try { 
         ArrayUtils.toMap(new Object[] { "1", "2", "3" }); 
         fail("Should have caused IllegalArgumentException"); 
     } catch (final IllegalArgumentException iae) { 
     } 
     try { 
         ArrayUtils.toMap(new Object[] { "a", "b", "c", "d" }); 
         fail("Should have caused IllegalArgumentException"); 
     } catch (final IllegalArgumentException iae) { 
     } 
     try { 
         ArrayUtils.toMap(new Object[] { "1", "2", "3" }); 
         fail("Should have caused IllegalArgumentException"); 
     } catch (final IllegalArgumentException iae) { 
     } 
 }
@Test
public void testToArray_Object191() { 
     Object[] array; 
     array = ArrayUtils.toArray((Object[]) null); 
     assertNull(array); 
     array = ArrayUtils.toArray(new Object[0]); 
     assertTrue(Arrays.equals(ArrayUtils.EMPTY_OBJECT_ARRAY, array)); 
     assertEquals(Object.class, array.getClass().getComponentType()); 
     array = ArrayUtils.toArray(new Object[] { "a", "b" }); 
     assertTrue(Arrays.equals(new Object[] { "a" }, array)); 
     assertEquals(Object.class, array.getClass().getComponentType()); 
     array = ArrayUtils.toArray(new Object[] { "a", "b", "c" }); 
     assertTrue(Arrays.equals(new Object[] { "a", "b", "c" }, array)); 
     assertEquals(Object.class, array.getClass().getComponentType()); 
 }
@Test
public void testToArray_Object192() { 
     Object[] array; 
     array = ArrayUtils.toArray((Object[]) null); 
     assertNull(array); 
     array = ArrayUtils.toArray(ArrayUtils.EMPTY_OBJECT_ARRAY); 
     assertTrue(Arrays.equals(ArrayUtils.EMPTY_OBJECT_ARRAY, array)); 
     assertEquals(Object.class, array.getClass().getComponentType()); 
     array = ArrayUtils.toArray(new Object[] { "a", "b", "c" }); 
     assertTrue(Arrays.equals(ArrayUtils.EMPTY_OBJECT_ARRAY, array)); 
     assertEquals(Object.class, array.getClass().getComponentType()); 
     array = ArrayUtils.toArray(new Object[] { "a", "b", "c" }); 
     assertTrue(Arrays.equals(new Object[] { "a", "b", "c" }, array)); 
     assertEquals(Object.class, array.getClass().getComponentType()); 
 }
@Test
@SuppressWarnings("cast") 
 public void testRemoveElementFloatArray193() { 
     float[] array; 
     array = ArrayUtils.removeElement((float[]) null, (float) 1); 
     assertNull(array); 
     array = ArrayUtils.removeElement(ArrayUtils.EMPTY_FLOAT_ARRAY, (float) 1); 
     assertTrue(Arrays.equals(ArrayUtils.EMPTY_FLOAT_ARRAY, array)); 
     assertEquals(Float.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeElement(new float[] { 1 }, (float) 1); 
     assertTrue(Arrays.equals(ArrayUtils.EMPTY_FLOAT_ARRAY, array)); 
     assertEquals(Float.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeElement(new float[] { 1, 2 }, (float) 1); 
     assertTrue(Arrays.equals(new float[] { 2 }, array)); 
     assertEquals(Float.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeElement(new float[] { 1, 2, 1 }, (float) 1); 
     assertTrue(Arrays.equals(new float[] { 2, 1 }, array)); 
     assertEquals(Float.TYPE, array.getClass().getComponentType()); 
 }
@Test
public void testNullToEmptyShort194() { 
     assertEquals(ArrayUtils.EMPTY_SHORT_ARRAY, ArrayUtils.nullToEmpty((short[]) null)); 
     final short[] original = new short[] { 1, 2 }; 
     assertEquals(original, ArrayUtils.nullToEmpty(original)); 
     final short[] empty = new short[] {}; 
     final short[] result = ArrayUtils.nullToEmpty(empty); 
     assertEquals(ArrayUtils.EMPTY_SHORT_ARRAY, result); 
     assertTrue(empty != result); 
 }
@Test
public void testNullToEmptyBooleanObject195() { 
     assertArrayEquals(ArrayUtils.EMPTY_BOOLEAN_OBJECT_ARRAY, ArrayUtils.nullToEmpty((Boolean[]) null)); 
     final Boolean[] original = new Boolean[] { true, false }; 
     assertArrayEquals(original, ArrayUtils.nullToEmpty(original)); 
     final Boolean[] empty = new Boolean[] {}; 
     final Boolean[] result = ArrayUtils.nullToEmpty(empty); 
     assertArrayEquals(ArrayUtils.EMPTY_BOOLEAN_OBJECT_ARRAY, result); 
     assertTrue(empty != result); 
 }
@Test
public void testSameLengthByte197() { 
     final byte[] nullArray = null; 
     final byte[] emptyArray = new byte[0]; 
     final byte[] oneArray = new byte[] { 4 }; 
     final byte[] twoArray = new byte[] { 6, 8 }; 
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
public void testSameLengthDouble198() { 
     final double[] nullArray = null; 
     final double[] emptyArray = new double[0]; 
     final double[] oneArray = new double[] { 0L }; 
     final double[] twoArray = new double[] { 0L, 76L }; 
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
public void testSameLengthFloat199() { 
     final float[] nullArray = null; 
     final float[] emptyArray = new float[0]; 
     final float[] oneArray = new float[] { 4.3f }; 
     final float[] twoArray = new float[] { 6.7f }; 
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
public void testReverseInt200() { 
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
public void testIndexOf201() { 
     final Object[] array = new Object[] { "0", "1", "2", "3", null, "0" }; 
     assertEquals(-1, ArrayUtils.indexOf(null, null)); 
     assertEquals(-1, ArrayUtils.indexOf(null, "0")); 
     assertEquals(0, ArrayUtils.indexOf(array, "0")); 
     assertEquals(1, ArrayUtils.indexOf(array, "1")); 
     assertEquals(2, ArrayUtils.indexOf(array, "2")); 
     assertEquals(3, ArrayUtils.indexOf(array, "3")); 
     assertEquals(4, ArrayUtils.indexOf(array, null)); 
     assertEquals(-1, ArrayUtils.indexOf(array, "notInArray")); 
 }
@Test
public void testIndexOf202() { 
     final Object[] array = new Object[] { "0", "1", "2", "3", null, "0" }; 
     assertEquals(-1, ArrayUtils.indexOf(null, null)); 
     assertEquals(-1, ArrayUtils.indexOf(null, "0")); 
     assertEquals(5, ArrayUtils.indexOf(array, "0")); 
     assertEquals(1, ArrayUtils.indexOf(array, "1")); 
     assertEquals(2, ArrayUtils.indexOf(array, "2")); 
     assertEquals(3, ArrayUtils.indexOf(array, "3")); 
     assertEquals(4, ArrayUtils.indexOf(array, null)); 
     assertEquals(-1, ArrayUtils.indexOf(array, "notInArray")); 
 }
@Test
public void testLastIndexOfShortWithStartIndex203() { 
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
public void testContainsShort204() { 
     short[] array = null; 
     assertFalse(ArrayUtils.contains(array, (short) 1)); 
     array = new short[] { 0, 1, 2, 3, 0 }; 
     assertTrue(ArrayUtils.contains(array, (short) 0)); 
     assertTrue(ArrayUtils.contains(array, (short) 1)); 
     assertTrue(ArrayUtils.contains(array, (short) 2)); 
     assertTrue(ArrayUtils.contains(array, (short) 3)); 
     assertFalse(ArrayUtils.contains(array, (short) 99)); 
 }
@SuppressWarnings("cast")
@Test
public void testContainsShort205() { 
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
public void testContainsChar206() { 
     char[] array = null; 
     assertFalse(ArrayUtils.contains(array, 'a')); 
     array = new char[] { 'a', 'b', 'c', 'd', 'a' }; 
     assertTrue(ArrayUtils.contains(array, 'a')); 
     assertTrue(ArrayUtils.contains(array, 'b')); 
     assertTrue(ArrayUtils.contains(array, 'c')); 
     assertFalse(ArrayUtils.contains(array, 'd')); 
 }
@SuppressWarnings("cast")
@Test
public void testContainsChar207() { 
     char[] array = null; 
     assertFalse(ArrayUtils.contains(array, 'a')); 
     array = new char[] { 'a', 'b', 'c', 'd', 'a' }; 
     assertTrue(ArrayUtils.contains(array, 'a')); 
     assertTrue(ArrayUtils.contains(array, 'b')); 
     assertTrue(ArrayUtils.contains(array, 'c')); 
     assertFalse(ArrayUtils.contains(array, 'd')); 
 }
@Test
public void testIndexOfByte208() { 
     byte[] array = null; 
     assertEquals(-1, ArrayUtils.indexOf(array, (byte) 0)); 
     array = new byte[] { 0, 1, 2, 3, 0 }; 
     assertEquals(0, ArrayUtils.indexOf(array, (byte) 0)); 
     assertEquals(1, ArrayUtils.indexOf(array, (byte) 1)); 
     assertEquals(2, ArrayUtils.indexOf(array, (byte) 2)); 
     assertEquals(3, ArrayUtils.indexOf(array, (byte) 3)); 
     assertEquals(-1, ArrayUtils.indexOf(array, (byte) 99)); 
 }
@SuppressWarnings("cast")
@Test
public void testRemoveElementDoubleArray209() { 
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
public void testIndexOfDoubleWithStartIndexTolerance210() { 
     double[] array = null; 
     assertEquals(-1, ArrayUtils.indexOf(array, (double) 0, 2, (double) 0)); 
     array = new double[0]; 
     assertEquals(-1, ArrayUtils.indexOf(array, (double) 0, 2, (double) 0)); 
     array = new double[] { (double) 3 }; 
     assertEquals(-1, ArrayUtils.indexOf(array, (double) 1, 0, (double) 0)); 
     array = new double[] { 0, 1, 2, 3, 0 }; 
     assertEquals(4, ArrayUtils.indexOf(array, (double) 0, 99, (double) 0.3)); 
     assertEquals(0, ArrayUtils.indexOf(array, (double) 0, 3, (double) 0.3)); 
     assertEquals(2, ArrayUtils.indexOf(array, (double) 2.2, 3, (double) 0.35)); 
     assertEquals(3, ArrayUtils.indexOf(array, (double) 4.15, array.length, (double) 2.0)); 
     assertEquals(1, ArrayUtils.indexOf(array, (double) 1.00001324, array.length, (double) 0.0001)); 
     assertEquals(-1, ArrayUtils.indexOf(array, (double) 4.15, -200, (double) 2.0)); 
 }
@Test
public void testLastIndexOfBooleanWithStartIndex211() { 
     boolean[] array = null; 
     assertEquals(-1, ArrayUtils.lastIndexOf(array, true, 2)); 
     array = new boolean[] { true, false, true }; 
     assertEquals(0, ArrayUtils.lastIndexOf(array, true, 2)); 
     assertEquals(1, ArrayUtils.lastIndexOf(array, true, 2)); 
     assertEquals(2, ArrayUtils.lastIndexOf(array, false, 2)); 
     assertEquals(-1, ArrayUtils.lastIndexOf(array, true, -1)); 
     assertEquals(-1, ArrayUtils.lastIndexOf(array, false, -1)); 
     assertEquals(-1, ArrayUtils.lastIndexOf(array, true, 99)); 
     assertEquals(4, ArrayUtils.lastIndexOf(array, false, 0)); 
     assertEquals(-1, ArrayUtils.lastIndexOf(array, false, 6)); 
 }
@SuppressWarnings("cast")
@Test
public void testLastIndexOfBooleanWithStartIndex213() { 
     boolean[] array = null; 
     assertEquals(-1, ArrayUtils.lastIndexOf(array, true, 2)); 
     array = new boolean[0]; 
     assertEquals(-1, ArrayUtils.lastIndexOf(array, true, 2)); 
     array = new boolean[] { true, false, true }; 
     assertEquals(0, ArrayUtils.lastIndexOf(array, true, 2)); 
     assertEquals(1, ArrayUtils.lastIndexOf(array, true, 2)); 
     assertEquals(2, ArrayUtils.lastIndexOf(array, false, 2)); 
     assertEquals(-1, ArrayUtils.lastIndexOf(array, true, -1)); 
     assertEquals(-1, ArrayUtils.lastIndexOf(array, false, -1)); 
     assertEquals(-1, ArrayUtils.lastIndexOf(array, true, 99)); 
     assertEquals(4, ArrayUtils.lastIndexOf(array, false, 88)); 
 }
@SuppressWarnings("cast")
@Test
public void testLastIndexOfBooleanWithStartIndex214() { 
     boolean[] array = null; 
     assertEquals(-1, ArrayUtils.lastIndexOf(array, true, 2)); 
     array = new boolean[0]; 
     assertEquals(-1, ArrayUtils.lastIndexOf(array, true, 2)); 
     array = new boolean[] { true, false, true }; 
     assertEquals(4, ArrayUtils.lastIndexOf(array, true, 2)); 
     assertEquals(-1, ArrayUtils.lastIndexOf(array, false, 2)); 
     assertEquals(2, ArrayUtils.lastIndexOf(array, true, 2)); 
     assertEquals(-1, ArrayUtils.lastIndexOf(array, false, -1)); 
     assertEquals(-1, ArrayUtils.lastIndexOf(array, true, 99)); 
     assertEquals(4, ArrayUtils.lastIndexOf(array, false, 0)); 
     assertEquals(-1, ArrayUtils.lastIndexOf(array, true, 6)); 
 }
@SuppressWarnings("cast")
@Test
public void testLastIndexOfBooleanWithStartIndex215() { 
     boolean[] array = null; 
     assertEquals(-1, ArrayUtils.lastIndexOf(array, true, 2)); 
     array = new boolean[0]; 
     assertEquals(-1, ArrayUtils.lastIndexOf(array, true, 2)); 
     array = new boolean[] { true, false, true }; 
     assertEquals(0, ArrayUtils.lastIndexOf(array, true, 2)); 
     assertEquals(1, ArrayUtils.lastIndexOf(array, true, 2)); 
     assertEquals(2, ArrayUtils.lastIndexOf(array, true, 2)); 
     assertEquals(-1, ArrayUtils.lastIndexOf(array, false, 2)); 
     assertEquals(-1, ArrayUtils.lastIndexOf(array, true, -1)); 
     assertEquals(-1, ArrayUtils.lastIndexOf(array, false, -1)); 
     assertEquals(-1, ArrayUtils.lastIndexOf(array, true, 99)); 
     assertEquals(4, ArrayUtils.lastIndexOf(array, false, 88)); 
 }
@SuppressWarnings("cast")
@Test
public void testLastIndexOfBooleanWithStartIndex216() { 
     boolean[] array = null; 
     assertEquals(-1, ArrayUtils.lastIndexOf(array, true, 2)); 
     array = new boolean[0]; 
     assertEquals(-1, ArrayUtils.lastIndexOf(array, true, 2)); 
     array = new boolean[] { true, false, true }; 
     assertEquals(4, ArrayUtils.lastIndexOf(array, true, 2)); 
     assertEquals(-1, ArrayUtils.lastIndexOf(array, false, 2)); 
     assertEquals(2, ArrayUtils.lastIndexOf(array, true, -1)); 
     assertEquals(-1, ArrayUtils.lastIndexOf(array, false, -2)); 
     assertEquals(-1, ArrayUtils.lastIndexOf(array, true, 99)); 
     assertEquals(4, ArrayUtils.lastIndexOf(array, false, 88)); 
 }
@SuppressWarnings("cast")
@Test
public void testLastIndexOfBooleanWithStartIndex217() { 
     boolean[] array = null; 
     assertEquals(-1, ArrayUtils.lastIndexOf(array, true, 2)); 
     array = new boolean[0]; 
     assertEquals(-1, ArrayUtils.lastIndexOf(array, true, 2)); 
     array = new boolean[] { true, false, true }; 
     assertEquals(4, ArrayUtils.lastIndexOf(array, true, 2)); 
     assertEquals(-1, ArrayUtils.lastIndexOf(array, false, 2)); 
     assertEquals(2, ArrayUtils.lastIndexOf(array, true, -1)); 
     assertEquals(-1, ArrayUtils.lastIndexOf(array, false, -2)); 
     assertEquals(-1, ArrayUtils.lastIndexOf(array, true, 99)); 
     assertEquals(4, ArrayUtils.lastIndexOf(array, false, 0)); 
     assertEquals(-1, ArrayUtils.lastIndexOf(array, true, 6)); 
 }
@Test
public void testToPrimitive_char218() { 
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
public void testToObject_char219() { 
     final char[] b = null; 
     assertArrayEquals(null, ArrayUtils.toObject(b)); 
     assertSame(ArrayUtils.EMPTY_CHARACTER_OBJECT_ARRAY, ArrayUtils.toObject(new char[0])); 
     assertTrue(Arrays.equals(new Character[] { Character.valueOf(Character.MIN_VALUE), Character.valueOf(Character.MAX_VALUE), Character.valueOf('0') }, ArrayUtils.toObject(new char[] { Character.MIN_VALUE, Character.MAX_VALUE, '0' }))); 
 }
@Test
public void testToPrimitive_byte220() { 
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
public void testToPrimitive_double_double221() { 
     final Double[] l = null; 
     assertEquals(null, ArrayUtils.toPrimitive(l, Double.MIN_VALUE)); 
     assertSame(ArrayUtils.EMPTY_DOUBLE_ARRAY, ArrayUtils.toPrimitive(new Double[0], 1)); 
     assertTrue(Arrays.equals(new double[] { Double.MIN_VALUE, Double.MAX_VALUE, 9999999 }, ArrayUtils.toPrimitive(new Double[] { Double.valueOf(Double.MIN_VALUE), Double.valueOf(Double.MAX_VALUE), Double.valueOf(9999999) }, 1))); 
     assertTrue(Arrays.equals(new double[] { Double.MIN_VALUE, Double.MAX_VALUE, 9999999 }, ArrayUtils.toPrimitive(new Double[] { Double.valueOf(Double.MIN_VALUE), null, Double.valueOf(9999999) }, Double.MAX_VALUE))); 
 }
@Test
public void testToObject_double222() { 
     final double[] b = null; 
     assertArrayEquals(null, ArrayUtils.toObject(b)); 
     assertSame(ArrayUtils.EMPTY_DOUBLE_OBJECT_ARRAY, ArrayUtils.toObject(new double[0])); 
     assertTrue(Arrays.equals(new Double[] { Double.valueOf(Double.MIN_VALUE), Double.valueOf(Double.MAX_VALUE), Double.valueOf(9999999) }, ArrayUtils.toObject(new double[] { Double.MIN_VALUE, Double.MAX_VALUE, 9999999 }))); 
 }
@Test
public void testToObject_float223() { 
     final float[] b = null; 
     assertArrayEquals(null, ArrayUtils.toObject(b)); 
     assertSame(ArrayUtils.EMPTY_FLOAT_OBJECT_ARRAY, ArrayUtils.toObject(new float[0])); 
     assertTrue(Arrays.equals(new Float[] { Float.valueOf(Float.MIN_VALUE), Float.valueOf(Float.MAX_VALUE), Float.valueOf(9999999) }, ArrayUtils.toObject(new float[] { Float.MIN_VALUE, Float.MAX_VALUE, 9999999 }))); 
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
