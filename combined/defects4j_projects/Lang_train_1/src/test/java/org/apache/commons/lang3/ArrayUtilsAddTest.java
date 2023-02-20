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
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.Arrays;

import org.junit.Test;

/**
 * Tests ArrayUtils add methods.
 *
 * @version $Id$
 */
public class ArrayUtilsAddTest {

@Test
public void testJira567580() { 
     Number[] n; 
     n = ArrayUtils.addAll(new Number[] { Integer.valueOf(1) }, new Long[] { Long.valueOf(2) }); 
     assertEquals(2, n.length); 
     assertEquals(Number.class, n.getClass().getComponentType()); 
     try { 
         n = ArrayUtils.addAll(new Integer[] { Integer.valueOf(1) }, new Long[] { Long.valueOf(2) }); 
         fail("Should have generated IllegalArgumentException"); 
     } catch (final IllegalArgumentException expected) { 
     } 
 }
@Test
public void testAddObjectArrayToObjectArray581() { 
     assertNull(ArrayUtils.addAll((Object[]) null, (Object[]) null)); 
     Object[] newArray; 
     final String[] stringArray1 = new String[] { "a", "b", "c" }; 
     final String[] stringArray2 = new String[] { "1", "2", "3" }; 
     newArray = ArrayUtils.addAll(stringArray1, (String[]) null); 
     assertNotSame(stringArray1, newArray); 
     assertTrue(Arrays.equals(stringArray1, newArray)); 
     assertTrue(Arrays.equals(new String[] { "a", "b", "c" }, newArray)); 
     assertEquals(String.class, newArray.getClass().getComponentType()); 
     newArray = ArrayUtils.addAll(null, stringArray2); 
     assertNotSame(stringArray2, newArray); 
     assertTrue(Arrays.equals(stringArray2, newArray)); 
     assertTrue(Arrays.equals(new String[] { "1", "2", "3" }, newArray)); 
     assertEquals(String.class, newArray.getClass().getComponentType()); 
     newArray = ArrayUtils.addAll(stringArray1, stringArray2); 
     assertTrue(Arrays.equals(new String[] { "a", "b", "c", "1", "2", "3" }, newArray)); 
     assertEquals(String.class, newArray.getClass().getComponentType()); 
     newArray = ArrayUtils.addAll(ArrayUtils.EMPTY_STRING_ARRAY, (String[]) null); 
     assertTrue(Arrays.equals(ArrayUtils.EMPTY_STRING_ARRAY, newArray)); 
     assertTrue(Arrays.equals(new String[] {}, newArray)); 
     assertEquals(String.class, newArray.getClass().getComponentType()); 
     newArray = ArrayUtils.addAll(null, ArrayUtils.EMPTY_STRING_ARRAY); 
     assertTrue(Arrays.equals(ArrayUtils.EMPTY_STRING_ARRAY, newArray)); 
     assertTrue(Arrays.equals(new String[] {}, newArray)); 
     assertEquals(String.class, newArray.getClass().getComponentType()); 
     newArray = ArrayUtils.addAll(ArrayUtils.EMPTY_STRING_ARRAY, ArrayUtils.EMPTY_STRING_ARRAY); 
     assertTrue(Arrays.equals(ArrayUtils.EMPTY_STRING_ARRAY, newArray)); 
     assertTrue(Arrays.equals(new String[] {}, newArray)); 
     assertEquals(String.class, newArray.getClass().getComponentType()); 
     final String[] stringArrayNull = new String[] { null }; 
     newArray = ArrayUtils.addAll(stringArrayNull, stringArrayNull); 
     assertTrue(Arrays.equals(new String[] { null, null }, newArray)); 
     assertEquals(String.class, newArray.getClass().getComponentType()); 
     assertTrue(Arrays.equals(new boolean[] { true, false, false, true }, ArrayUtils.addAll(new boolean[] { true, false }, new boolean[] { false, true }))); 
     assertTrue(Arrays.equals(new boolean[] { false, true }, ArrayUtils.addAll(null, new boolean[] { false, true }))); 
     assertTrue(Arrays.equals(new boolean[] { true, false }, ArrayUtils.addAll(new boolean[] { true, false }, null))); 
     assertTrue(Arrays.equals(new char[] { 'a', 'b', 'c', 'd' }, ArrayUtils.addAll(new char[] { 'a', 'b' }, new char[] { 'c', 'd' }))); 
     assertTrue(Arrays.equals(new char[] { 'c', 'd' }, ArrayUtils.addAll(null, new char[] { 'c', 'd' }))); 
     assertTrue(Arrays.equals(new char[] { 'a', 'b' }, ArrayUtils.addAll(new char[] { 'a', 'b' }, null))); 
     assertTrue(Arrays.equals(new byte[] { (byte) 0, (byte) 1, (byte) 2, (byte) 3 }, ArrayUtils.addAll(new byte[] { (byte) 0, (byte) 1 }, new byte[] { (byte) 2, (byte) 3 }))); 
     assertTrue(Arrays.equals(new byte[] { (byte) 2, (byte) 3 }, ArrayUtils.addAll(null, new byte[] { (byte) 2, (byte) 3 }))); 
     assertTrue(Arrays.equals(new byte[] { (byte) 0, (byte) 1 }, ArrayUtils.addAll(new byte[] { (byte) 0, (byte) 1 }, null))); 
     assertTrue(Arrays.equals(new short[] { (short) 10, (short) 20, (short) 30, (short) 40 }, ArrayUtils.addAll(new short[] { (short) 10, (short) 20 }, new short[] { (short) 30, (short) 40 }))); 
     assertTrue(Arrays.equals(new short[] { (short) 30, (short) 40 }, ArrayUtils.addAll(null, new short[] { (short) 30, (short) 40 }))); 
     assertTrue(Arrays.equals(new short[] { (short) 10, (short) 20 }, ArrayUtils.addAll(new short[] { (short) 10, (short) 20 }, null))); 
     assertTrue(Arrays.equals(new int[] { 1, 1000, -1000, -1 }, ArrayUtils.addAll(new int[] { 1, 1000 }, new int[] { -1000, -1 }))); 
     assertTrue(Arrays.equals(new int[] { -1000, -1 }, ArrayUtils.addAll(null, new int[] { -1000, -1 }))); 
     assertTrue(Arrays.equals(new int[] { 1, 1000 }, ArrayUtils.addAll(new int[] { 1, 1000 }, null))); 
     assertTrue(Arrays.equals(new long[] { 1L, -1L, 1000L, -1000L }, ArrayUtils.addAll(new long[] { 1L, -1L }, new long[] { 1000L, -1000L }))); 
     assertTrue(Arrays.equals(new long[] { 1000L, -1000L }, ArrayUtils.addAll(null, new long[] { 1000L, -1000L }))); 
     assertTrue(Arrays.equals(new long[] { 1L, -1L }, ArrayUtils.addAll(new long[] { 1L, -1L }, null))); 
     assertTrue(Arrays.equals(new float[] { 10.5f, 10.1f, 1.6f, 0.01f }, ArrayUtils.addAll(new float[] { 10.5f, 10.1f }, new float[] { 1.6f, 0.01f }))); 
     assertTrue(Arrays.equals(new float[] { 1.6f, 0.01f }, ArrayUtils.addAll(null, new float[] { 1.6f, 0.01f }))); 
     assertTrue(Arrays.equals(new float[] { 10.5f, 10.1f }, ArrayUtils.addAll(new float[] { 10.5f, 10.1f }, null))); 
     assertTrue(Arrays.equals(new double[] { Math.PI, -Math.PI, 0, 9.99 }, ArrayUtils.addAll(new double[] { Math.PI, -Math.PI }, new double[] { 0, 9.99 }))); 
     assertTrue(Arrays.equals(new double[] { 0, 9.99 }, ArrayUtils.addAll(null, new double[] { 0, 9.99 }))); 
     assertTrue(Arrays.equals(new double[] { Math.PI, -Math.PI }, ArrayUtils.addAll(new double[] { Math.PI, -Math.PI }, null))); 
 }
@Test
public void testAddObjectArrayObject582() { 
     Object[] newArray; 
     newArray = ArrayUtils.add((Object[]) null, "a"); 
     assertTrue(Arrays.equals(new String[] { "a" }, newArray)); 
     assertTrue(Arrays.equals(new Object[] { "a" }, newArray)); 
     assertEquals(String.class, newArray.getClass().getComponentType()); 
     final String[] newStringArray = ArrayUtils.add(null, "a"); 
     assertTrue(Arrays.equals(new String[] { "a" }, newStringArray)); 
     assertTrue(Arrays.equals(new Object[] { "a" }, newStringArray)); 
     assertEquals(String.class, newStringArray.getClass().getComponentType()); 
     final String[] stringArray1 = new String[] { "a", "b", "c" }; 
     newArray = ArrayUtils.add(stringArray1, null); 
     assertTrue(Arrays.equals(new String[] { "a", "b", "c", null }, newArray)); 
     assertEquals(String.class, newArray.getClass().getComponentType()); 
     newArray = ArrayUtils.add(stringArray1, "d"); 
     assertTrue(Arrays.equals(new String[] { "a", "b", "c", "d" }, newArray)); 
     assertEquals(String.class, newArray.getClass().getComponentType()); 
     Number[] numberArray1 = new Number[] { Integer.valueOf(1), Double.valueOf(2) }; 
     newArray = ArrayUtils.add(numberArray1, Float.valueOf(3)); 
     assertTrue(Arrays.equals(new Number[] { Integer.valueOf(1), Double.valueOf(2), Float.valueOf(3) }, newArray)); 
     assertEquals(Number.class, newArray.getClass().getComponentType()); 
     numberArray1 = null; 
     newArray = ArrayUtils.add(numberArray1, Float.valueOf(3)); 
     assertTrue(Arrays.equals(new Float[] { Float.valueOf(3) }, newArray)); 
     assertEquals(Float.class, newArray.getClass().getComponentType()); 
 }
@Test
public void testAddObjectArrayBoolean583() { 
     boolean[] newArray; 
     newArray = ArrayUtils.add((boolean[]) null, false); 
     assertTrue(Arrays.equals(new boolean[] { false }, newArray)); 
     assertEquals(Boolean.TYPE, newArray.getClass().getComponentType()); 
     newArray = ArrayUtils.add((boolean[]) null, true); 
     assertTrue(Arrays.equals(new boolean[] { true }, newArray)); 
     assertEquals(Boolean.TYPE, newArray.getClass().getComponentType()); 
     final boolean[] array1 = new boolean[] { true, false, true }; 
     newArray = ArrayUtils.add(array1, false); 
     assertTrue(Arrays.equals(new boolean[] { true, false, true, false }, newArray)); 
     assertEquals(Boolean.TYPE, newArray.getClass().getComponentType()); 
 }
@Test
public void testAddObjectArrayByte584() { 
     byte[] newArray; 
     newArray = ArrayUtils.add((byte[]) null, (byte) 0); 
     assertTrue(Arrays.equals(new byte[] { 0 }, newArray)); 
     assertEquals(Byte.TYPE, newArray.getClass().getComponentType()); 
     newArray = ArrayUtils.add((byte[]) null, (byte) 1); 
     assertTrue(Arrays.equals(new byte[] { 1 }, newArray)); 
     assertEquals(Byte.TYPE, newArray.getClass().getComponentType()); 
     final byte[] array1 = new byte[] { 1, 2, 3 }; 
     newArray = ArrayUtils.add(array1, (byte) 0); 
     assertTrue(Arrays.equals(new byte[] { 1, 2, 3, 0 }, newArray)); 
     assertEquals(Byte.TYPE, newArray.getClass().getComponentType()); 
     newArray = ArrayUtils.add(array1, (byte) 4); 
     assertTrue(Arrays.equals(new byte[] { 1, 2, 3, 4 }, newArray)); 
     assertEquals(Byte.TYPE, newArray.getClass().getComponentType()); 
 }
@Test
public void testAddObjectArrayChar585() { 
     char[] newArray; 
     newArray = ArrayUtils.add((char[]) null, (char) 0); 
     assertTrue(Arrays.equals(new char[] { 0 }, newArray)); 
     assertEquals(Character.TYPE, newArray.getClass().getComponentType()); 
     newArray = ArrayUtils.add((char[]) null, (char) 1); 
     assertTrue(Arrays.equals(new char[] { 1 }, newArray)); 
     assertEquals(Character.TYPE, newArray.getClass().getComponentType()); 
     final char[] array1 = new char[] { 1, 2, 3 }; 
     newArray = ArrayUtils.add(array1, (char) 0); 
     assertTrue(Arrays.equals(new char[] { 1, 2, 3, 0 }, newArray)); 
     assertEquals(Character.TYPE, newArray.getClass().getComponentType()); 
     newArray = ArrayUtils.add(array1, (char) 4); 
     assertTrue(Arrays.equals(new char[] { 1, 2, 3, 4 }, newArray)); 
     assertEquals(Character.TYPE, newArray.getClass().getComponentType()); 
 }
@Test
public void testAddObjectArrayDouble586() { 
     double[] newArray; 
     newArray = ArrayUtils.add((double[]) null, 0); 
     assertTrue(Arrays.equals(new double[] { 0 }, newArray)); 
     assertEquals(Double.TYPE, newArray.getClass().getComponentType()); 
     newArray = ArrayUtils.add((double[]) null, 1); 
     assertTrue(Arrays.equals(new double[] { 1 }, newArray)); 
     assertEquals(Double.TYPE, newArray.getClass().getComponentType()); 
     final double[] array1 = new double[] { 1, 2, 3 }; 
     newArray = ArrayUtils.add(array1, 0); 
     assertTrue(Arrays.equals(new double[] { 1, 2, 3, 0 }, newArray)); 
     assertEquals(Double.TYPE, newArray.getClass().getComponentType()); 
     newArray = ArrayUtils.add(array1, 4); 
     assertTrue(Arrays.equals(new double[] { 1, 2, 3, 4 }, newArray)); 
     assertEquals(Double.TYPE, newArray.getClass().getComponentType()); 
 }
@Test
public void testAddObjectArrayFloat587() { 
     float[] newArray; 
     newArray = ArrayUtils.add((float[]) null, 0); 
     assertTrue(Arrays.equals(new float[] { 0 }, newArray)); 
     assertEquals(Float.TYPE, newArray.getClass().getComponentType()); 
     newArray = ArrayUtils.add((float[]) null, 1); 
     assertTrue(Arrays.equals(new float[] { 1 }, newArray)); 
     assertEquals(Float.TYPE, newArray.getClass().getComponentType()); 
     final float[] array1 = new float[] { 1, 2, 3 }; 
     newArray = ArrayUtils.add(array1, 0); 
     assertTrue(Arrays.equals(new float[] { 1, 2, 3, 0 }, newArray)); 
     assertEquals(Float.TYPE, newArray.getClass().getComponentType()); 
     newArray = ArrayUtils.add(array1, 4); 
     assertTrue(Arrays.equals(new float[] { 1, 2, 3, 4 }, newArray)); 
     assertEquals(Float.TYPE, newArray.getClass().getComponentType()); 
 }
@Test
public void testAddObjectArrayLong588() { 
     long[] newArray; 
     newArray = ArrayUtils.add((long[]) null, 0); 
     assertTrue(Arrays.equals(new long[] { 0 }, newArray)); 
     assertEquals(Long.TYPE, newArray.getClass().getComponentType()); 
     newArray = ArrayUtils.add((long[]) null, 1); 
     assertTrue(Arrays.equals(new long[] { 1 }, newArray)); 
     assertEquals(Long.TYPE, newArray.getClass().getComponentType()); 
     final long[] array1 = new long[] { 1, 2, 3 }; 
     newArray = ArrayUtils.add(array1, 0); 
     assertTrue(Arrays.equals(new long[] { 1, 2, 3, 0 }, newArray)); 
     assertEquals(Long.TYPE, newArray.getClass().getComponentType()); 
     newArray = ArrayUtils.add(array1, 4); 
     assertTrue(Arrays.equals(new long[] { 1, 2, 3, 4 }, newArray)); 
     assertEquals(Long.TYPE, newArray.getClass().getComponentType()); 
 }
@Test
public void testAddObjectArrayShort589() { 
     short[] newArray; 
     newArray = ArrayUtils.add((short[]) null, (short) 0); 
     assertTrue(Arrays.equals(new short[] { 0 }, newArray)); 
     assertEquals(Short.TYPE, newArray.getClass().getComponentType()); 
     newArray = ArrayUtils.add((short[]) null, (short) 1); 
     assertTrue(Arrays.equals(new short[] { 1 }, newArray)); 
     assertEquals(Short.TYPE, newArray.getClass().getComponentType()); 
     final short[] array1 = new short[] { 1, 2, 3 }; 
     newArray = ArrayUtils.add(array1, (short) 0); 
     assertTrue(Arrays.equals(new short[] { 1, 2, 3, 0 }, newArray)); 
     assertEquals(Short.TYPE, newArray.getClass().getComponentType()); 
     newArray = ArrayUtils.add(array1, (short) 4); 
     assertTrue(Arrays.equals(new short[] { 1, 2, 3, 4 }, newArray)); 
     assertEquals(Short.TYPE, newArray.getClass().getComponentType()); 
 }
    

    

    

    

    

    

    

    

    

    
    
    

    

    

}
