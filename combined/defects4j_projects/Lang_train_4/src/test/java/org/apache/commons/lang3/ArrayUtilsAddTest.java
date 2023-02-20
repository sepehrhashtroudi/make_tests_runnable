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
public void testJira567591() { 
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
public void testAddObjectArrayObject592() { 
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
public void testLANG571593() { 
     final String[] stringArray = null; 
     final String aString = null; 
     try { 
         @SuppressWarnings("unused") 
         final String[] sa = ArrayUtils.add(stringArray, aString); 
         fail("Should have caused IllegalArgumentException"); 
     } catch (final IllegalArgumentException iae) { 
     } 
     try { 
         @SuppressWarnings("unused") 
         final String[] sa = ArrayUtils.add(stringArray, 0, aString); 
         fail("Should have caused IllegalArgumentException"); 
     } catch (final IllegalArgumentException iae) { 
     } 
 }
@Test
public void testAddObjectArrayBoolean594() { 
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
public void testAddObjectArrayChar595() { 
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
public void testAddObjectArrayDouble596() { 
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
public void testAddObjectArrayFloat597() { 
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
public void testAddObjectArrayInt598() { 
     int[] newArray; 
     newArray = ArrayUtils.add((int[]) null, 0); 
     assertTrue(Arrays.equals(new int[] { 0 }, newArray)); 
     assertEquals(Integer.TYPE, newArray.getClass().getComponentType()); 
     newArray = ArrayUtils.add((int[]) null, 1); 
     assertTrue(Arrays.equals(new int[] { 1 }, newArray)); 
     assertEquals(Integer.TYPE, newArray.getClass().getComponentType()); 
     final int[] array1 = new int[] { 1, 2, 3 }; 
     newArray = ArrayUtils.add(array1, 0); 
     assertTrue(Arrays.equals(new int[] { 1, 2, 3, 0 }, newArray)); 
     assertEquals(Integer.TYPE, newArray.getClass().getComponentType()); 
     newArray = ArrayUtils.add(array1, 4); 
     assertTrue(Arrays.equals(new int[] { 1, 2, 3, 4 }, newArray)); 
     assertEquals(Integer.TYPE, newArray.getClass().getComponentType()); 
 }
@Test
public void testAddObjectArrayLong599() { 
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
public void testAddObjectArrayShort600() { 
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
@Test
public void testAddObjectAtIndex601() { 
     Object[] newArray; 
     newArray = ArrayUtils.add((Object[]) null, 0, "a"); 
     assertTrue(Arrays.equals(new String[] { "a" }, newArray)); 
     assertTrue(Arrays.equals(new Object[] { "a" }, newArray)); 
     assertEquals(String.class, newArray.getClass().getComponentType()); 
     final String[] stringArray1 = new String[] { "a", "b", "c" }; 
     newArray = ArrayUtils.add(stringArray1, 0, null); 
     assertTrue(Arrays.equals(new String[] { null, "a", "b", "c" }, newArray)); 
     assertEquals(String.class, newArray.getClass().getComponentType()); 
     newArray = ArrayUtils.add(stringArray1, 1, null); 
     assertTrue(Arrays.equals(new String[] { "a", null, "b", "c" }, newArray)); 
     assertEquals(String.class, newArray.getClass().getComponentType()); 
     newArray = ArrayUtils.add(stringArray1, 3, null); 
     assertTrue(Arrays.equals(new String[] { "a", "b", "c", null }, newArray)); 
     assertEquals(String.class, newArray.getClass().getComponentType()); 
     newArray = ArrayUtils.add(stringArray1, 3, "d"); 
     assertTrue(Arrays.equals(new String[] { "a", "b", "c", "d" }, newArray)); 
     assertEquals(String.class, newArray.getClass().getComponentType()); 
     assertEquals(String.class, newArray.getClass().getComponentType()); 
     final Object[] o = new Object[] { "1", "2", "4" }; 
     final Object[] result = ArrayUtils.add(o, 2, "3"); 
     final Object[] result2 = ArrayUtils.add(o, 3, "5"); 
     assertNotNull(result); 
     assertEquals(4, result.length); 
     assertEquals("1", result[0]); 
     assertEquals("2", result[1]); 
     assertEquals("3", result[2]); 
     assertEquals("4", result[3]); 
     assertNotNull(result2); 
     assertEquals(4, result2.length); 
     assertEquals("1", result2[0]); 
     assertEquals("2", result2[1]); 
     assertEquals("4", result2[2]); 
     assertEquals("5", result2[3]); 
     boolean[] booleanArray = ArrayUtils.add(null, 0, true); 
     assertTrue(Arrays.equals(new boolean[] { true }, booleanArray)); 
     try { 
         booleanArray = ArrayUtils.add(null, -1, true); 
     } catch (final IndexOutOfBoundsException e) { 
         assertEquals("Index: -1, Length: 0", e.getMessage()); 
     } 
     booleanArray = ArrayUtils.add(new boolean[] { true }, 0, false); 
     assertTrue(Arrays.equals(new boolean[] { false, true }, booleanArray)); 
     booleanArray = ArrayUtils.add(new boolean[] { false }, 1, true); 
     assertTrue(Arrays.equals(new boolean[] { false, true }, booleanArray)); 
     booleanArray = ArrayUtils.add(new boolean[] { true, false }, 1, true); 
     assertTrue(Arrays.equals(new boolean[] { true, true, false }, booleanArray)); 
     try { 
         booleanArray = ArrayUtils.add(new boolean[] { true, false }, 4, true); 
     } catch (final IndexOutOfBoundsException e) { 
         assertEquals("Index: 4, Length: 2", e.getMessage()); 
     } 
     try { 
         booleanArray = ArrayUtils.add(new boolean[] { true, false }, -1, true); 
     } catch (final IndexOutOfBoundsException e) { 
         assertEquals("Index: -1, Length: 2", e.getMessage()); 
     } 
     char[] charArray = ArrayUtils.add((char[]) null, 0, 'a'); 
     assertTrue(Arrays.equals(new char[] { 'a' }, charArray)); 
     try { 
         charArray = ArrayUtils.add((char[]) null, -1, 'a'); 
     } catch (final IndexOutOfBoundsException e) { 
         assertEquals("Index: -1, Length: 0", e.getMessage()); 
     } 
     charArray = ArrayUtils.add(new char[] { 'a' }, 0, 'b'); 
     assertTrue(Arrays.equals(new char[] { 'b', 'a' }, charArray)); 
     charArray = ArrayUtils.add(new char[] { 'a', 'b' }, 0, 'c'); 
     assertTrue(Arrays.equals(new char[] { 'c', 'a', 'b' }, charArray)); 
     charArray = ArrayUtils.add(new char[] { 'a', 'b' }, 1, 'k'); 
     assertTrue(Arrays.equals(new char[] { 'a', 'k', 'b' }, charArray)); 
     charArray = ArrayUtils.add(new char[] { 'a', 'b', 'c' }, 1, 't'); 
     assertTrue(Arrays.equals(new char[] { 'a', 't', 'b', 'c' }, charArray)); 
     try { 
         charArray = ArrayUtils.add(new char[] { 'a', 'b' }, 4, 'c'); 
     } catch (final IndexOutOfBoundsException e) { 
         assertEquals("Index: 4, Length: 2", e.getMessage()); 
     } 
     try { 
         charArray = ArrayUtils.add(new char[] { 'a', 'b' }, -1, 'c'); 
     } catch (final IndexOutOfBoundsException e) { 
         assertEquals("Index: -1, Length: 2", e.getMessage()); 
     } 
     short[] shortArray = ArrayUtils.add(new short[] { 1 }, 0, (short) 2); 
     assertTrue(Arrays.equals(new short[] { 2, 1 }, shortArray)); 
     try { 
         shortArray = ArrayUtils.add((short[]) null, -1, (short) 2); 
     } catch (final IndexOutOfBoundsException e) { 
         assertEquals("Index: -1, Length: 0", e.getMessage()); 
     } 
     shortArray = ArrayUtils.add(new short[] { 2, 6 }, 2, (short) 10); 
     assertTrue(Arrays.equals(new short[] { 2, 6, 10 }, shortArray)); 
     shortArray = ArrayUtils.add(new short[] { 2, 6 }, 0, (short) -4); 
     assertTrue(Arrays.equals(new short[] { -4, 2, 6 }, shortArray)); 
     shortArray = ArrayUtils.add(new short[] { 2, 6, 3 }, 2, (short) 1); 
     assertTrue(Arrays.equals(new short[] { 2, 6, 1, 3 }, shortArray)); 
     try { 
         shortArray = ArrayUtils.add(new short[] { 2, 6 }, 4, (short) 10); 
     } catch (final IndexOutOfBoundsException e) { 
         assertEquals("Index: 4, Length: 2", e.getMessage()); 
     } 
     try { 
         shortArray = ArrayUtils.add(new short[] { 2, 6 }, -1, (short) 10); 
     } catch (final IndexOutOfBoundsException e) { 
         assertEquals("Index: -1, Length: 2", e.getMessage()); 
     } 
     byte[] byteArray = ArrayUtils.add(new byte[] { 1 }, 0, (byte) 2); 
     assertTrue(Arrays.equals(new byte[] { 2, 1 }, byteArray)); 
     try { 
         byteArray = ArrayUtils.add((byte[]) null, -1, (byte) 2); 
     } catch (final IndexOutOfBoundsException e) { 
         assertEquals("Index: -1, Length: 0", e.getMessage()); 
     } 
     byteArray = ArrayUtils.add(new byte[] { 2, 6 }, 2, (byte) 3); 
     assertTrue(Arrays.equals(new byte[] { 2, 6, 3 }, byteArray)); 
     byteArray = ArrayUtils.add(new byte[] { 2, 6 }, 0, (byte) 1); 
     assertTrue(Arrays.equals(new byte[] { 1, 2, 6 }, byteArray)); 
     byteArray = ArrayUtils.add(new byte[] { 2, 6, 3 }, 2, (byte) 1); 
     assertTrue(Arrays.equals(new byte[] { 2, 6, 1, 3 }, byteArray)); 
     try { 
         byteArray = ArrayUtils.add(new byte[] { 2, 6 }, 4, (byte) 3); 
     } catch (final IndexOutOfBoundsException e) { 
         assertEquals("Index: 4, Length: 2", e.getMessage()); 
     } 
     try { 
         byteArray = ArrayUtils.add(new byte[] { 2, 6 }, -1, (byte) 3); 
     } catch (final IndexOutOfBoundsException e) { 
         assertEquals("Index: -1, Length: 2", e.getMessage()); 
     } 
     int[] intArray = ArrayUtils.add(new int[] { 1 }, 0, 2); 
     assertTrue(Arrays.equals(new int[] { 2, 1 }, intArray)); 
     try { 
         intArray = ArrayUtils.add((int[]) null, -1, 2); 
     } catch (final IndexOutOfBoundsException e) { 
         assertEquals("Index: -1, Length: 0", e.getMessage()); 
     } 
     intArray = ArrayUtils.add(new int[] { 2, 6 }, 2, 10); 
     assertTrue(Arrays.equals(new int[] { 2, 6, 10 }, intArray)); 
     intArray = ArrayUtils.add(new int[] { 2, 6 }, 0, -4); 
     assertTrue(Arrays.equals(new int[] { -4, 2, 6 }, intArray)); 
     intArray = ArrayUtils.add(new int[] { 2, 6, 3 }, 2, 1); 
     assertTrue(Arrays.equals(new int[] { 2, 6, 1, 3 }, intArray)); 
     try { 
         intArray = ArrayUtils.add(new int[] { 2, 6 }, 4, 10); 
     } catch (final IndexOutOfBoundsException e) { 
         assertEquals("Index: 4, Length: 2", e.getMessage()); 
     } 
     try { 
         intArray = ArrayUtils.add(new int[] { 2, 6 }, -1, 10); 
     } catch (final IndexOutOfBoundsException e) { 
         assertEquals("Index: -1, Length: 2", e.getMessage()); 
     } 
     long[] longArray = ArrayUtils.add(new long[] { 1L }, 0, 2L); 
     assertTrue(Arrays.equals(new long[] { 2L, 1L }, longArray)); 
     try { 
         longArray = ArrayUtils.add((long[]) null, -1, 2L); 
     } catch (final IndexOutOfBoundsException e) { 
         assertEquals("Index: -1, Length: 0", e.getMessage()); 
     } 
     longArray = ArrayUtils.add(new long[] { 2L, 6L }, 2, 10L); 
     assertTrue(Arrays.equals(new long[] { 2L, 6L, 10L }, longArray)); 
     longArray = ArrayUtils.add(new long[] { 2L, 6L }, 0, -4L); 
     assertTrue(Arrays.equals(new long[] { -4L, 2L, 6L }, longArray)); 
     longArray = ArrayUtils.add(new long[] { 2L, 6L, 3L }, 2, 1L); 
     assertTrue(Arrays.equals(new long[] { 2L, 6L, 1L, 3L }, longArray)); 
     try { 
         longArray = ArrayUtils.add(new long[] { 2L, 6L }, 4, 10L); 
     } catch (final IndexOutOfBoundsException e) { 
         assertEquals("Index: 4, Length: 2", e.getMessage()); 
     } 
     try { 
         longArray = ArrayUtils.add(new long[] { 2L, 6L }, -1, 10L); 
     } catch (final IndexOutOfBoundsException e) { 
         assertEquals("Index: -1, Length: 2", e.getMessage()); 
     } 
     float[] floatArray = ArrayUtils.add(new float[] { 1.1f }, 0, 2.2f); 
     assertTrue(Arrays.equals(new float[] { 2.2f, 1.1f }, floatArray)); 
     try { 
         floatArray = ArrayUtils.add((float[]) null, -1, 2.2f); 
     } catch (final IndexOutOfBoundsException e) { 
         assertEquals("Index: -1, Length: 0", e.getMessage()); 
     } 
     floatArray = ArrayUtils.add(new float[] { 2.3f, 6.4f }, 2, 10.5f); 
     assertTrue(Arrays.equals(new float[] { 2.3f, 6.4f, 10.5f }, floatArray)); 
     floatArray = ArrayUtils.add(new float[] { 2.6f, 6.7f }, 0, -4.8f); 
     assertTrue(Arrays.equals(new float[] { -4.8f, 2.6f, 6.7f }, floatArray)); 
     floatArray = ArrayUtils.add(new float[] { 2.9f, 6.0f, 0.3f }, 2, 1.0f); 
     assertTrue(Arrays.equals(new float[] { 2.9f, 6.0f, 1.0f, 0.3f }, floatArray)); 
     try { 
         floatArray = ArrayUtils.add(new float[] { 2.3f, 6.4f }, 4, 10.5f); 
     } catch (final IndexOutOfBoundsException e) { 
         assertEquals("Index: 4, Length: 2", e.getMessage()); 
     } 
     try { 
         floatArray = ArrayUtils.add(new float[] { 2.3f, 6.4f }, -1, 10.5f); 
     } catch (final IndexOutOfBoundsException e) { 
         assertEquals("Index: -1, Length: 2", e.getMessage()); 
     } 
     double[] doubleArray = ArrayUtils.add(new double[] { 1.1 }, 0, 2.2); 
     assertTrue(Arrays.equals(new double[] { 2.2, 1.1 }, doubleArray)); 
     try { 
         doubleArray = ArrayUtils.add((double[]) null, -1, 2.2); 
     } catch (final IndexOutOfBoundsException e) { 
         assertEquals("Index: -1, Length: 0", e.getMessage()); 
     } 
     doubleArray = ArrayUtils.add(new double[] { 2.3, 6.4 }, 2, 10.5); 
     assertTrue(Arrays.equals(new double[] { 2.3, 6.4, 10.5 }, doubleArray)); 
     doubleArray = ArrayUtils.add(new double[] { 2.6, 6.7 }, 0, -4.8); 
     assertTrue(Arrays.equals(new double[] { -4.8, 2.6, 6.7 }, doubleArray)); 
     doubleArray = ArrayUtils.add(new double[] { 2.9, 6.0, 0.3 }, 2, 1.0); 
     assertTrue(Arrays.equals(new double[] { 2.9, 6.0, 1.0, 0.3 }, doubleArray)); 
     try { 
         doubleArray = ArrayUtils.add(new double[] { 2.3, 6.4 }, 4, 10.5); 
     } catch (final IndexOutOfBoundsException e) { 
         assertEquals("Index: 4, Length: 2", e.getMessage()); 
     } 
     try { 
         doubleArray = ArrayUtils.add(new double[] { 2.3, 6.4 }, -1, 10.5); 
     } catch (final IndexOutOfBoundsException e) { 
         assertEquals("Index: -1, Length: 2", e.getMessage()); 
     } 
 }
    

    

    

    

    

    

    

    

    

    
    
    

    

    

}
