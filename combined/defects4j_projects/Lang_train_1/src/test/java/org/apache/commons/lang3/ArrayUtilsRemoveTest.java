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
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.Arrays;

import org.junit.Test;

/**
 * Tests ArrayUtils remove and removeElement methods.
 * 
 * @version $Id$
 */
public class ArrayUtilsRemoveTest {

@Test
@SuppressWarnings("cast") 
 public void testRemoveElementLongArray483() { 
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
@SuppressWarnings("cast") 
 public void testRemoveElementDoubleArray486() { 
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
@Test
public void testRemoveDoubleArray513() { 
     double[] array; 
     array = ArrayUtils.remove(new double[] { 1 }, 0); 
     assertTrue(Arrays.equals(ArrayUtils.EMPTY_DOUBLE_ARRAY, array)); 
     assertEquals(Double.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.remove(new double[] { 1, 2 }, 0); 
     assertTrue(Arrays.equals(new double[] { 2 }, array)); 
     assertEquals(Double.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.remove(new double[] { 1, 2 }, 1); 
     assertTrue(Arrays.equals(new double[] { 1 }, array)); 
     assertEquals(Double.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.remove(new double[] { 1, 2, 1 }, 1); 
     assertTrue(Arrays.equals(new double[] { 1, 1 }, array)); 
     assertEquals(Double.TYPE, array.getClass().getComponentType()); 
     try { 
         ArrayUtils.remove(new double[] { 1, 2 }, -1); 
         fail("IndexOutOfBoundsException expected"); 
     } catch (final IndexOutOfBoundsException e) { 
     } 
     try { 
         ArrayUtils.remove(new double[] { 1, 2 }, 2); 
         fail("IndexOutOfBoundsException expected"); 
     } catch (final IndexOutOfBoundsException e) { 
     } 
     try { 
         ArrayUtils.remove((double[]) null, 0); 
         fail("IndexOutOfBoundsException expected"); 
     } catch (final IndexOutOfBoundsException e) { 
     } 
 }
@Test
public void testRemoveNumberArray590() { 
     final Number[] inarray = { Integer.valueOf(1), Long.valueOf(2), Byte.valueOf((byte) 3) }; 
     assertEquals(3, inarray.length); 
     Number[] outarray; 
     outarray = ArrayUtils.remove(inarray, 1); 
     assertEquals(2, outarray.length); 
     assertEquals(Number.class, outarray.getClass().getComponentType()); 
     outarray = ArrayUtils.remove(outarray, 1); 
     assertEquals(1, outarray.length); 
     assertEquals(Number.class, outarray.getClass().getComponentType()); 
     outarray = ArrayUtils.remove(outarray, 0); 
     assertEquals(0, outarray.length); 
     assertEquals(Number.class, outarray.getClass().getComponentType()); 
 }
@Test
public void testRemoveElementObjectArray591() { 
     Object[] array; 
     array = ArrayUtils.removeElement((Object[]) null, "a"); 
     assertNull(array); 
     array = ArrayUtils.removeElement(ArrayUtils.EMPTY_OBJECT_ARRAY, "a"); 
     assertTrue(Arrays.equals(ArrayUtils.EMPTY_OBJECT_ARRAY, array)); 
     assertEquals(Object.class, array.getClass().getComponentType()); 
     array = ArrayUtils.removeElement(new Object[] { "a" }, "a"); 
     assertTrue(Arrays.equals(ArrayUtils.EMPTY_OBJECT_ARRAY, array)); 
     assertEquals(Object.class, array.getClass().getComponentType()); 
     array = ArrayUtils.removeElement(new Object[] { "a", "b" }, "a"); 
     assertTrue(Arrays.equals(new Object[] { "b" }, array)); 
     assertEquals(Object.class, array.getClass().getComponentType()); 
     array = ArrayUtils.removeElement(new Object[] { "a", "b", "a" }, "a"); 
     assertTrue(Arrays.equals(new Object[] { "b", "a" }, array)); 
     assertEquals(Object.class, array.getClass().getComponentType()); 
 }
@Test
public void testRemoveBooleanArray592() { 
     boolean[] array; 
     array = ArrayUtils.remove(new boolean[] { true }, 0); 
     assertTrue(Arrays.equals(ArrayUtils.EMPTY_BOOLEAN_ARRAY, array)); 
     assertEquals(Boolean.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.remove(new boolean[] { true, false }, 0); 
     assertTrue(Arrays.equals(new boolean[] { false }, array)); 
     assertEquals(Boolean.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.remove(new boolean[] { true, false }, 1); 
     assertTrue(Arrays.equals(new boolean[] { true }, array)); 
     assertEquals(Boolean.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.remove(new boolean[] { true, false, true }, 1); 
     assertTrue(Arrays.equals(new boolean[] { true, true }, array)); 
     assertEquals(Boolean.TYPE, array.getClass().getComponentType()); 
     try { 
         ArrayUtils.remove(new boolean[] { true, false }, -1); 
         fail("IndexOutOfBoundsException expected"); 
     } catch (final IndexOutOfBoundsException e) { 
     } 
     try { 
         ArrayUtils.remove(new boolean[] { true, false }, 2); 
         fail("IndexOutOfBoundsException expected"); 
     } catch (final IndexOutOfBoundsException e) { 
     } 
     try { 
         ArrayUtils.remove((boolean[]) null, 0); 
         fail("IndexOutOfBoundsException expected"); 
     } catch (final IndexOutOfBoundsException e) { 
     } 
 }
@Test
public void testRemoveElementBooleanArray593() { 
     boolean[] array; 
     array = ArrayUtils.removeElement((boolean[]) null, true); 
     assertNull(array); 
     array = ArrayUtils.removeElement(ArrayUtils.EMPTY_BOOLEAN_ARRAY, true); 
     assertTrue(Arrays.equals(ArrayUtils.EMPTY_BOOLEAN_ARRAY, array)); 
     assertEquals(Boolean.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeElement(new boolean[] { true }, true); 
     assertTrue(Arrays.equals(ArrayUtils.EMPTY_BOOLEAN_ARRAY, array)); 
     assertEquals(Boolean.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeElement(new boolean[] { true, false }, true); 
     assertTrue(Arrays.equals(new boolean[] { false }, array)); 
     assertEquals(Boolean.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeElement(new boolean[] { true, false, true }, true); 
     assertTrue(Arrays.equals(new boolean[] { false, true }, array)); 
     assertEquals(Boolean.TYPE, array.getClass().getComponentType()); 
 }
@Test
public void testRemoveElementByteArray594() { 
     byte[] array; 
     array = ArrayUtils.removeElement((byte[]) null, (byte) 1); 
     assertNull(array); 
     array = ArrayUtils.removeElement(ArrayUtils.EMPTY_BYTE_ARRAY, (byte) 1); 
     assertTrue(Arrays.equals(ArrayUtils.EMPTY_BYTE_ARRAY, array)); 
     assertEquals(Byte.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeElement(new byte[] { 1 }, (byte) 1); 
     assertTrue(Arrays.equals(ArrayUtils.EMPTY_BYTE_ARRAY, array)); 
     assertEquals(Byte.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeElement(new byte[] { 1, 2 }, (byte) 1); 
     assertTrue(Arrays.equals(new byte[] { 2 }, array)); 
     assertEquals(Byte.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeElement(new byte[] { 1, 2, 1 }, (byte) 1); 
     assertTrue(Arrays.equals(new byte[] { 2, 1 }, array)); 
     assertEquals(Byte.TYPE, array.getClass().getComponentType()); 
 }
@Test
public void testRemoveCharArray595() { 
     char[] array; 
     array = ArrayUtils.remove(new char[] { 'a' }, 0); 
     assertTrue(Arrays.equals(ArrayUtils.EMPTY_CHAR_ARRAY, array)); 
     assertEquals(Character.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.remove(new char[] { 'a', 'b' }, 0); 
     assertTrue(Arrays.equals(new char[] { 'b' }, array)); 
     assertEquals(Character.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.remove(new char[] { 'a', 'b' }, 1); 
     assertTrue(Arrays.equals(new char[] { 'a' }, array)); 
     assertEquals(Character.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.remove(new char[] { 'a', 'b', 'c' }, 1); 
     assertTrue(Arrays.equals(new char[] { 'a', 'c' }, array)); 
     assertEquals(Character.TYPE, array.getClass().getComponentType()); 
     try { 
         ArrayUtils.remove(new char[] { 'a', 'b' }, -1); 
         fail("IndexOutOfBoundsException expected"); 
     } catch (final IndexOutOfBoundsException e) { 
     } 
     try { 
         ArrayUtils.remove(new char[] { 'a', 'b' }, 2); 
         fail("IndexOutOfBoundsException expected"); 
     } catch (final IndexOutOfBoundsException e) { 
     } 
     try { 
         ArrayUtils.remove((char[]) null, 0); 
         fail("IndexOutOfBoundsException expected"); 
     } catch (final IndexOutOfBoundsException e) { 
     } 
 }
@Test
public void testRemoveIntArray596() { 
     int[] array; 
     array = ArrayUtils.remove(new int[] { 1 }, 0); 
     assertTrue(Arrays.equals(ArrayUtils.EMPTY_INT_ARRAY, array)); 
     assertEquals(Integer.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.remove(new int[] { 1, 2 }, 0); 
     assertTrue(Arrays.equals(new int[] { 2 }, array)); 
     assertEquals(Integer.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.remove(new int[] { 1, 2 }, 1); 
     assertTrue(Arrays.equals(new int[] { 1 }, array)); 
     assertEquals(Integer.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.remove(new int[] { 1, 2, 1 }, 1); 
     assertTrue(Arrays.equals(new int[] { 1, 1 }, array)); 
     assertEquals(Integer.TYPE, array.getClass().getComponentType()); 
     try { 
         ArrayUtils.remove(new int[] { 1, 2 }, -1); 
         fail("IndexOutOfBoundsException expected"); 
     } catch (final IndexOutOfBoundsException e) { 
     } 
     try { 
         ArrayUtils.remove(new int[] { 1, 2 }, 2); 
         fail("IndexOutOfBoundsException expected"); 
     } catch (final IndexOutOfBoundsException e) { 
     } 
     try { 
         ArrayUtils.remove((int[]) null, 0); 
         fail("IndexOutOfBoundsException expected"); 
     } catch (final IndexOutOfBoundsException e) { 
     } 
 }
@Test
public void testRemoveElementShortArray597() { 
     short[] array; 
     array = ArrayUtils.removeElement((short[]) null, (short) 1); 
     assertNull(array); 
     array = ArrayUtils.removeElement(ArrayUtils.EMPTY_SHORT_ARRAY, (short) 1); 
     assertTrue(Arrays.equals(ArrayUtils.EMPTY_SHORT_ARRAY, array)); 
     assertEquals(Short.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeElement(new short[] { 1 }, (short) 1); 
     assertTrue(Arrays.equals(ArrayUtils.EMPTY_SHORT_ARRAY, array)); 
     assertEquals(Short.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeElement(new short[] { 1, 2 }, (short) 1); 
     assertTrue(Arrays.equals(new short[] { 2 }, array)); 
     assertEquals(Short.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeElement(new short[] { 1, 2, 1 }, (short) 1); 
     assertTrue(Arrays.equals(new short[] { 2, 1 }, array)); 
     assertEquals(Short.TYPE, array.getClass().getComponentType()); 
 }
    

    

    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
