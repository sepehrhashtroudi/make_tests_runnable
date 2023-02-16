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
public void testJira567219() { 
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
public void testAddAllBooleanArray220() { 
     boolean[] array1 = null; 
     boolean[] array2 = ArrayUtils.addAll(array1, true); 
     assertTrue(Arrays.equals(array1, array2)); 
     assertTrue(Arrays.equals(array1, array2)); 
     array1 = new boolean[0]; 
     array2 = ArrayUtils.addAll(array1, false); 
     assertTrue(Arrays.equals(ArrayUtils.EMPTY_BOOLEAN_ARRAY, array2)); 
     assertEquals(Boolean.TYPE, array2.getClass().getComponentType()); 
     array1 = new boolean[] { true, false }; 
     array2 = ArrayUtils.addAll(array1, false); 
     assertTrue(Arrays.equals(new boolean[] { true, false }, array2)); 
     assertEquals(Boolean.TYPE, array2.getClass().getComponentType()); 
     array1 = new boolean[] { true, true }; 
     array2 = ArrayUtils.addAll(array1, true); 
     assertTrue(Arrays.equals(new boolean[] { true, true }, array2)); 
     assertEquals(Boolean.TYPE, array2.getClass().getComponentType()); 
     array1 = null; 
     array2 = ArrayUtils.addAll(array1, false); 
     assertNull(array1); 
     assertEquals(Boolean.TYPE, array2.getClass().getComponentType()); 
 }
@Test
public void testJira567221() { 
     boolean[] array1 = null; 
     boolean[] array2 = ArrayUtils.addAll(array1, true); 
     assertTrue(Arrays.equals(array1, array2)); 
     assertTrue(Arrays.equals(array1, array2)); 
     array1 = new boolean[0]; 
     array2 = ArrayUtils.addAll(array1, false); 
     assertTrue(Arrays.equals(ArrayUtils.EMPTY_BOOLEAN_ARRAY, array2)); 
     assertEquals(Boolean.TYPE, array2.getClass().getComponentType()); 
     array1 = new boolean[] { true, false }; 
     array2 = ArrayUtils.addAll(array1, false); 
     assertTrue(Arrays.equals(new boolean[] { true, false }, array2)); 
     assertEquals(Boolean.TYPE, array2.getClass().getComponentType()); 
     array1 = new boolean[] { true, true }; 
     array2 = ArrayUtils.addAll(array1, true); 
     assertTrue(Arrays.equals(new boolean[] { true, true }, array2)); 
     assertEquals(Boolean.TYPE, array2.getClass().getComponentType()); 
 }
@Test
public void testJira567222() { 
     final boolean[] nullArray = null; 
     final boolean[] array1 = new boolean[] { true, false, true }; 
     final boolean[] array2 = ArrayUtils.addAll(nullArray, true, false); 
     assertTrue(Arrays.equals(ArrayUtils.EMPTY_BOOLEAN_ARRAY, ArrayUtils.addAll(array1, true))); 
     assertTrue(Arrays.equals(new boolean[] { true, false, true }, ArrayUtils.addAll(array1, false))); 
     assertTrue(Arrays.equals(new boolean[] { true, true, false }, ArrayUtils.addAll(array1, true))); 
     assertTrue(Arrays.equals(new boolean[] { true, true, false }, ArrayUtils.addAll(array1, false, true))); 
     assertTrue(Arrays.equals(new boolean[] { true, true, true }, ArrayUtils.addAll(array1, true, false))); 
     assertTrue(Arrays.equals(new boolean[] { true, true, false }, ArrayUtils.addAll(array1, false, true))); 
     assertTrue(Arrays.equals(new boolean[] { true, true, true }, ArrayUtils.addAll(array1, true, false))); 
     assertTrue(Arrays.equals(new boolean[] { true, true, false }, ArrayUtils.addAll(array1, false, true))); 
     assertTrue(Arrays.equals(new boolean[] { true, true, true }, ArrayUtils.addAll(array2, true, false))); 
     assertTrue(Arrays.equals(new boolean[] { true, true, false }, ArrayUtils.addAll(array2, false, true))); 
 }
@Test
public void testJira567224() { 
     double[] array1 = null; 
     double[] array2 = null; 
     array1 = ArrayUtils.addAll(array1, (double) 3); 
     assertTrue(Arrays.equals(ArrayUtils.EMPTY_DOUBLE_ARRAY, array1)); 
     assertTrue(Arrays.equals(new double[] { 3 }, array1)); 
     assertEquals(Double.TYPE, array1.getClass().getComponentType()); 
     array1 = ArrayUtils.addAll(array1, (double) 2); 
     assertTrue(Arrays.equals(new double[] { 2 }, array1)); 
     assertEquals(Double.TYPE, array1.getClass().getComponentType()); 
     array2 = ArrayUtils.addAll(array1, (double) 3); 
     assertTrue(Arrays.equals(new double[] { 3 }, array1)); 
     assertEquals(Double.TYPE, array2.getClass().getComponentType()); 
     array1 = ArrayUtils.addAll(array1, (double) 4); 
     assertTrue(Arrays.equals(new double[] { 4 }, array1)); 
     assertEquals(Double.TYPE, array2.getClass().getComponentType()); 
 }
@Test
public void testJira567225() { 
     double[] array1 = new double[] { 1.0, 2.9876, 3.00001, 4.3 }; 
     double[] array2 = ArrayUtils.addAll(array1, (double) 4.3); 
     assertTrue(Arrays.equals(array1, array2)); 
     assertTrue(Arrays.equals(array1, array2)); 
     array1 = new double[] { 1.9876, 2.9876, 3.00001, 4.3 }; 
     array2 = ArrayUtils.addAll(array1, (double) 2.9876, (double) 4.3); 
     assertTrue(Arrays.equals(array1, array2)); 
     assertEquals(Double.TYPE, array2.getClass().getComponentType()); 
     array1 = null; 
     array2 = ArrayUtils.addAll(array1, (double) 2.9876, (double) 4.3); 
     assertTrue(Arrays.equals(ArrayUtils.EMPTY_DOUBLE_ARRAY, array2)); 
     assertEquals(Double.TYPE, array2.getClass().getComponentType()); 
     array1 = new double[] { 1.0, 2.9876, 3.00001, 4.3 }; 
     array2 = ArrayUtils.addAll(array1, (double) 2.9876, (double) 4.3); 
     assertTrue(Arrays.equals(array1, array2)); 
     assertEquals(Double.TYPE, array2.getClass().getComponentType()); 
 }
@Test
public void testJira567231() { 
     short[] array1 = new short[] { 1, 2, 3 }; 
     short[] array2 = ArrayUtils.addAll(array1, (short) 4); 
     assertTrue(Arrays.equals(array1, array2)); 
     assertTrue(Arrays.equals(new short[] { 3, 2, 1 }, array2)); 
     array1 = null; 
     array2 = ArrayUtils.addAll(array1, (short) 4); 
     assertTrue(Arrays.equals(array1, array2)); 
     assertTrue(Arrays.equals(new short[] { 1 }, array2)); 
 }
@Test
public void testJira567233() { 
     final short[] array1 = new short[] { 1, 2, 3 }; 
     final short[] array2 = ArrayUtils.addAll(array1, (short) 4); 
     assertTrue(Arrays.equals(array1, ArrayUtils.addAll(array1, (short) 5))); 
     assertTrue(Arrays.equals(array1, ArrayUtils.addAll(array1, (short) 6))); 
     assertTrue(Arrays.equals(array2, ArrayUtils.addAll(array1, (short) 7))); 
 }
@Test
public void testJira567234() { 
     final int[] a = ArrayUtils.addAll(new int[] { 1, 2 }, 3); 
     assertEquals(4, a.length); 
     assertEquals(1, a[0]); 
     assertEquals(2, a[1]); 
     assertEquals(3, a[2]); 
     final int[] c = ArrayUtils.addAll(new int[] { 1, 2 }, 3); 
     assertEquals(4, c.length); 
     assertEquals(1, c[0]); 
     assertEquals(2, c[1]); 
     assertEquals(3, c[2]); 
     final int[] d = ArrayUtils.addAll(new int[] { 1, 2, 3 }, 3); 
     assertEquals(4, d.length); 
     assertEquals(1, d[0]); 
     assertEquals(2, d[1]); 
     assertEquals(3, d[2]); 
     assertEquals(4, d[3]); 
     assertEquals(5, d[4]); 
 }
@Test
public void testAddAllIntArray235() { 
     int[] array1 = null; 
     int[] array2 = ArrayUtils.addAll(array1, (int) 3); 
     assertTrue(Arrays.equals(array1, array2)); 
     assertTrue(Arrays.equals(array1, array2)); 
     array1 = ArrayUtils.addAll(array1, (int) 3); 
     assertTrue(Arrays.equals(array1, array2)); 
     assertTrue(Arrays.equals(array1, array2)); 
     array1 = ArrayUtils.addAll(array1, (int) 3); 
     assertTrue(Arrays.equals(array1, array2)); 
     assertEquals(4, array1.length); 
     assertEquals(5, array1.length); 
     assertEquals(6, array1.length); 
     assertEquals(7, array1.length); 
     assertEquals(8, array1.length); 
     assertEquals(9, array1.length); 
     assertEquals(10, array1.length); 
     assertEquals(11, array1.length); 
     assertEquals(12, array1.length); 
     assertEquals(13, array1.length); 
     assertEquals(14, array1.length); 
     assertEquals(15, array1.length); 
     assertEquals(16, array1.length); 
     assertEquals(32, array1.length); 
     assertEquals(2, array1.length); 
     assertEquals(9, array1.length); 
     assertEquals(10, array1.length); 
     assertEquals(11, array1.length); 
     assertEquals(12, array1.length); 
     assertEquals(13, array1.length); 
     assertEquals(14, array1.length); 
     assertEquals(15, array1.length); 
     assertEquals(2, array1.length);
}

@Test
public void testAddAllIntArray236() { 
     int[] array1 = new int[] { 1, 2 }; 
     int[] array2 = ArrayUtils.addAll(array1, 3); 
     assertTrue(Arrays.equals(array1, array2)); 
     assertTrue(Arrays.equals(array1, array2)); 
     array1 = null; 
     array2 = ArrayUtils.addAll(array1, 3); 
     assertTrue(Arrays.equals(array1, array2)); 
     assertTrue(Arrays.equals(array1, array2)); 
     array1 = new int[] { 1, 2 }; 
     array2 = ArrayUtils.addAll(array1, 2); 
     assertTrue(Arrays.equals(array1, array2)); 
     assertEquals(int.class, array2.getClass().getComponentType()); 
     array1 = new int[] { 1, 2, 3 }; 
     array2 = ArrayUtils.addAll(array1, 3); 
     assertTrue(Arrays.equals(array1, array2)); 
     assertEquals(int.class, array2.getClass().getComponentType()); 
 }
@Test
public void testJira567239() { 
     final long[] array1 = new long[] { 1L, 2L, 3L }; 
     final long[] array2 = ArrayUtils.addAll(array1, (long) 3L); 
     assertTrue(Arrays.equals(array1, array2)); 
     assertTrue(Arrays.equals(new long[] { 3L, 2L, 1L }, ArrayUtils.addAll(array1, (long) 3L))); 
     assertTrue(Arrays.equals(new long[] { 2L, 1L, 3L }, ArrayUtils.addAll(array1, (long) 2L))); 
     assertTrue(Arrays.equals(new long[] { 1L, 2L, 3L }, ArrayUtils.addAll(array1, (long) 3L))); 
     assertTrue(Arrays.equals(new long[] { 1L, 2L, 3L }, ArrayUtils.addAll(array1, (long) 99L))); 
 }
@Test
public void testJira567241() { 
     long[] array1 = new long[] { 1L, 2L, 3L }; 
     long[] array2 = ArrayUtils.addAll(array1, 3L); 
     assertTrue(Arrays.equals(array1, array2)); 
     assertTrue(Arrays.equals(new long[] { 3L, 2L }, array2)); 
     array1 = null; 
     array2 = ArrayUtils.addAll(array1, 3L); 
     assertTrue(Arrays.equals(null, array2)); 
     assertEquals(Long.TYPE, array2.getClass().getComponentType()); 
 }
@Test
public void testJira567242() { 
     long[] array1 = new long[] { 1L, 2L, 3L }; 
     long[] array2 = ArrayUtils.addAll(array1, (long) 4); 
     assertTrue(Arrays.equals(array1, array2)); 
     assertEquals(Long.TYPE, array2.getClass().getComponentType()); 
     array1[0] = 5L; 
     array2 = ArrayUtils.addAll(array1, (long) 6L); 
     assertTrue(Arrays.equals(array1, array2)); 
     assertEquals(Long.TYPE, array2.getClass().getComponentType()); 
     array1[1] = 6L; 
     assertEquals(Long.TYPE, array2.getClass().getComponentType()); 
     array2 = ArrayUtils.addAll(array1, (long) 7L); 
     assertTrue(Arrays.equals(new long[] { 4 }, array2)); 
     assertEquals(Long.TYPE, array2.getClass().getComponentType()); 
     array1 = null; 
     array2 = ArrayUtils.addAll(array1, (long) 6L); 
     assertNull(array1); 
     assertEquals(Long.TYPE, array2.getClass().getComponentType()); 
 }
@Test
public void testJira567243() { 
     final long[] array1 = new long[] { 1L, 2L, 3L }; 
     final long[] array2 = ArrayUtils.addAll(array1, (long) 3L); 
     assertTrue(Arrays.equals(array1, array2)); 
     assertTrue(Arrays.equals(new long[] { 3L, 2L, 1L }, ArrayUtils.addAll(array1, (long) 3L))); 
     assertTrue(Arrays.equals(new long[] { 2L, 1L, 3L }, ArrayUtils.addAll(array1, (long) 2L))); 
 }
@Test
public void testJira567247() { 
     Number[] n; 
     n = ArrayUtils.addAll(new Number[] { Integer.valueOf(1) }, new Long[] { Long.valueOf(2) }); 
     assertEquals(2, n.length); 
     assertEquals(Number.class, n.getClass().getComponentType()); 
     try { 
         n = ArrayUtils.addAll(new Integer[] { Integer.valueOf(1) }, new Long[] { Long.valueOf(2) }); 
         fail("Should have generated IllegalArgumentException"); 
     } catch (final IllegalArgumentException iae) { 
     } 
 }
@Test
public void testJira567249() { 
     double[] array1 = null; 
     double[] array2 = ArrayUtils.addAll(array1, (double) 0); 
     assertTrue(Arrays.equals(ArrayUtils.EMPTY_DOUBLE_ARRAY, array1)); 
     assertTrue(Arrays.equals(new double[] { 0 }, array1)); 
     assertEquals(Double.TYPE, array1.getClass().getComponentType()); 
     array1 = ArrayUtils.addAll(array1, (double) 1); 
     assertTrue(Arrays.equals(new double[] { 1 }, array1)); 
     assertEquals(Double.TYPE, array1.getClass().getComponentType()); 
     array2 = ArrayUtils.addAll(array1, (double) 2); 
     assertTrue(Arrays.equals(new double[] { 2 }, array1)); 
     assertEquals(Double.TYPE, array2.getClass().getComponentType()); 
     array1 = ArrayUtils.addAll(array1, (double) 3); 
     assertTrue(Arrays.equals(new double[] { 3 }, array1)); 
     assertEquals(Double.TYPE, array2.getClass().getComponentType()); 
     array2 = ArrayUtils.addAll(array2, (double) 4); 
     assertTrue(Arrays.equals(new double[] { 4 }, array1)); 
     assertEquals(Double.TYPE, array2.getClass().getComponentType()); 
 }
@Test
public void testJira567250() { 
     double[] array1 = null; 
     double[] array2 = ArrayUtils.addAll(array1, (double) 0); 
     assertTrue(Arrays.equals(array1, array2)); 
     assertEquals(array1.hashCode(), array2.hashCode()); 
     array2 = ArrayUtils.addAll(array1, (double) 1); 
     assertTrue(Arrays.equals(array1, array2)); 
     assertEquals(Double.TYPE, array2.getClass().getComponentType()); 
     array1 = ArrayUtils.addAll(array1, (double) 2); 
     assertTrue(Arrays.equals(new double[] { 2 }, array2)); 
     assertEquals(Double.TYPE, array2.getClass().getComponentType()); 
     array2 = ArrayUtils.addAll(array1, (double) 3); 
     assertTrue(Arrays.equals(new double[] { 3 }, array2)); 
     assertEquals(Double.TYPE, array2.getClass().getComponentType()); 
     array1 = ArrayUtils.addAll(array1, (double) 4); 
     assertTrue(Arrays.equals(new double[] { 4 }, array2)); 
     assertEquals(Double.TYPE, array2.getClass().getComponentType()); 
 }
@Test
public void testJira567251() { 
     double[] array1 = null; 
     double[] array2 = ArrayUtils.addAll(array1, (double) 0); 
     assertTrue(Arrays.equals(ArrayUtils.EMPTY_DOUBLE_ARRAY, array1)); 
     assertTrue(Arrays.equals(new double[] { Double.MIN_VALUE, Double.MAX_VALUE, 9999999 }, array1)); 
     assertEquals(Double.MIN_VALUE, array1.length); 
     assertTrue(Arrays.equals(new double[] { Double.MIN_VALUE, Double.MAX_VALUE, 9999999 }, array1)); 
     assertEquals(Double.MIN_VALUE, array2.length); 
     assertTrue(Arrays.equals(new double[] { Double.MIN_VALUE, Double.MAX_VALUE, 9999999 }, array1)); 
     assertEquals(Double.MIN_VALUE, array2.length); 
     array1 = new double[] { 1.0, 2.9876, -3.00001, 4.3 }; 
     array2 = ArrayUtils.addAll(array1, (double) 0); 
     assertTrue(Arrays.equals(new double[] { 1.0, 2.9876, -3.00001, 4.3 }, array1)); 
     assertEquals(Double.MIN_VALUE, array2.length); 
     assertTrue(Arrays.equals(new double[] { 1.0, 2.9876, -3.00001, 4.3 }, array2)); 
 }
@Test
public void testAddObjectArrayByte252() { 
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
    

    

    

    

    

    

    

    

    

    
    
    

    

    

}
