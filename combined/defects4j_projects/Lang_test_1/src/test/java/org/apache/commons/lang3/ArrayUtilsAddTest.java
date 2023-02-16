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
public void testAddObjectArrayInt223() { 
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
public void testAddObjectArrayBoolean228() { 
     boolean[] array; 
     array = ArrayUtils.add((boolean[]) null, false); 
     assertNull(array); 
     array = ArrayUtils.add((boolean[]) null, true); 
     assertTrue(Arrays.equals(ArrayUtils.EMPTY_BOOLEAN_ARRAY, array)); 
     assertEquals(Boolean.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.add(ArrayUtils.EMPTY_BOOLEAN_ARRAY, false); 
     assertTrue(Arrays.equals(ArrayUtils.EMPTY_BOOLEAN_ARRAY, array)); 
     assertEquals(Boolean.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.add(new boolean[] { true }, false); 
     assertTrue(Arrays.equals(new boolean[] { true }, array)); 
     assertEquals(Boolean.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.add(new boolean[] { true, false, true }, false); 
     assertTrue(Arrays.equals(new boolean[] { true, true }, array)); 
     assertEquals(Boolean.TYPE, array.getClass().getComponentType()); 
 }
@Test
public void testAddIntArray233() { 
     int[] array; 
     array = ArrayUtils.add((int[]) null, 0); 
     assertNull(array); 
     array = ArrayUtils.add(ArrayUtils.EMPTY_INT_ARRAY, 1); 
     assertTrue(Arrays.equals(ArrayUtils.EMPTY_INT_ARRAY, array)); 
     assertEquals(Integer.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.add(new int[] { 1 }, 0); 
     assertTrue(Arrays.equals(ArrayUtils.EMPTY_INT_ARRAY, array)); 
     assertEquals(Integer.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.add(new int[] { 1, 2 }, 1); 
     assertTrue(Arrays.equals(new int[] { 2 }, array)); 
     assertEquals(Integer.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.add(new int[] { 1, 2, 1 }, 1); 
     assertTrue(Arrays.equals(new int[] { 2, 1 }, array)); 
     assertEquals(Integer.TYPE, array.getClass().getComponentType()); 
     try { 
         ArrayUtils.add(new int[] { 1, 2 }, -1); 
         fail("IndexOutOfBoundsException expected"); 
     } catch (final IndexOutOfBoundsException e) { 
     } 
     try { 
         ArrayUtils.add(new int[] { 1, 2 }, 2); 
         fail("IndexOutOfBoundsException expected"); 
     } catch (final IndexOutOfBoundsException e) { 
     } 
     try { 
         ArrayUtils.add((int[]) null, 3); 
         fail("IndexOutOfBoundsException expected"); 
     } catch (final IndexOutOfBoundsException e) { 
     } 
 }
@Test
public void testAddIntArray234() { 
     int[] array; 
     array = ArrayUtils.add((int[]) null, 0); 
     assertNull(array); 
     array = ArrayUtils.add(ArrayUtils.EMPTY_INT_ARRAY, 1); 
     assertTrue(Arrays.equals(ArrayUtils.EMPTY_INT_ARRAY, array)); 
     assertEquals(Integer.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.add(new int[] { 1 }, 0); 
     assertTrue(Arrays.equals(ArrayUtils.EMPTY_INT_ARRAY, array)); 
     assertEquals(Integer.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.add(new int[] { 1, 2 }, 1); 
     assertTrue(Arrays.equals(new int[] { 2 }, array)); 
     assertEquals(Integer.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.add(new int[] { 1, 2, 1 }, 1); 
     assertTrue(Arrays.equals(new int[] { 1, 1 }, array)); 
     assertEquals(Integer.TYPE, array.getClass().getComponentType()); 
     try { 
         ArrayUtils.add(new int[] { 1, 2 }, -1); 
         fail("IndexOutOfBoundsException expected"); 
     } catch (final IndexOutOfBoundsException e) { 
     } 
     try { 
         ArrayUtils.add(new int[] { 1, 2 }, 2); 
         fail("IndexOutOfBoundsException expected"); 
     } catch (final IndexOutOfBoundsException e) { 
     } 
     try { 
         ArrayUtils.add((int[]) null, 3); 
         fail("IndexOutOfBoundsException expected"); 
     } catch (final IndexOutOfBoundsException e) { 
     } 
 }
@Test
public void testAddObjectArrayLong235() { 
     long[] array; 
     array = ArrayUtils.add((long[]) null, 0); 
     assertNull(array); 
     array = ArrayUtils.add(ArrayUtils.EMPTY_LONG_ARRAY, 1); 
     assertTrue(Arrays.equals(ArrayUtils.EMPTY_LONG_ARRAY, array)); 
     assertEquals(Long.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.add(new long[] { 1 }, 0); 
     assertTrue(Arrays.equals(ArrayUtils.EMPTY_LONG_ARRAY, array)); 
     assertEquals(Long.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.add(new long[] { 1, 2 }, 1); 
     assertTrue(Arrays.equals(new long[] { 2 }, array)); 
     assertEquals(Long.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.add(new long[] { 1, 2, 1 }, 1); 
     assertTrue(Arrays.equals(new long[] { 2, 1 }, array)); 
     assertEquals(Long.TYPE, array.getClass().getComponentType()); 
     try { 
         ArrayUtils.add(new long[] { 1, 2 }, -1); 
         fail("IndexOutOfBoundsException expected"); 
     } catch (final IndexOutOfBoundsException e) { 
     } 
     try { 
         ArrayUtils.add(new long[] { 1, 2 }, 2); 
         fail("IndexOutOfBoundsException expected"); 
     } catch (final IndexOutOfBoundsException e) { 
     } 
     try { 
         ArrayUtils.add((long[]) null, 0); 
         fail("IndexOutOfBoundsException expected"); 
     } catch (final IndexOutOfBoundsException e) { 
     } 
 }
@Test
public void testAddObjectArrayFloat236() { 
     float[] array; 
     array = ArrayUtils.add((float[]) null, 0); 
     assertNull(array); 
     array = ArrayUtils.add(ArrayUtils.EMPTY_FLOAT_ARRAY, 1); 
     assertTrue(Arrays.equals(ArrayUtils.EMPTY_FLOAT_ARRAY, array)); 
     assertEquals(Float.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.add(new float[] { 1 }, 0); 
     assertTrue(Arrays.equals(ArrayUtils.EMPTY_FLOAT_ARRAY, array)); 
     assertEquals(Float.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.add(new float[] { 1, 2 }, 1); 
     assertTrue(Arrays.equals(new float[] { 2 }, array)); 
     assertEquals(Float.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.add(new float[] { 1, 2, 1 }, 1); 
     assertTrue(Arrays.equals(new float[] { 2, 1 }, array)); 
     assertEquals(Float.TYPE, array.getClass().getComponentType()); 
     try { 
         ArrayUtils.add(new float[] { 1, 2 }, -1); 
         fail("IndexOutOfBoundsException expected"); 
     } catch (final IndexOutOfBoundsException e) { 
     } 
     try { 
         ArrayUtils.add(new float[] { 1, 2 }, 2); 
         fail("IndexOutOfBoundsException expected"); 
     } catch (final IndexOutOfBoundsException e) { 
     } 
     try { 
         ArrayUtils.add((float[]) null, 3); 
         fail("IndexOutOfBoundsException expected"); 
     } catch (final IndexOutOfBoundsException e) { 
     } 
 }
@Test
public void testAddObjectArrayFloat237() { 
     float[] array; 
     array = ArrayUtils.add((float[]) null, 0); 
     assertNull(array); 
     array = ArrayUtils.add(ArrayUtils.EMPTY_FLOAT_ARRAY, 1); 
     assertTrue(Arrays.equals(ArrayUtils.EMPTY_FLOAT_ARRAY, array)); 
     assertEquals(Float.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.add(new float[] { 1 }, 0); 
     assertTrue(Arrays.equals(ArrayUtils.EMPTY_FLOAT_ARRAY, array)); 
     assertEquals(Float.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.add(new float[] { 1, 2 }, 1); 
     assertTrue(Arrays.equals(new float[] { 2 }, array)); 
     assertEquals(Float.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.add(new float[] { 1, 2, 1 }, 1); 
     assertTrue(Arrays.equals(new float[] { 2, 1 }, array)); 
     assertEquals(Float.TYPE, array.getClass().getComponentType()); 
     try { 
         ArrayUtils.add(new float[] { 1, 2 }, -1); 
         fail("IndexOutOfBoundsException expected"); 
     } catch (final IndexOutOfBoundsException e) { 
     } 
     try { 
         ArrayUtils.add(new float[] { 1, 2 }, 2); 
         fail("IndexOutOfBoundsException expected"); 
     } catch (final IndexOutOfBoundsException e) { 
     } 
     try { 
         ArrayUtils.add((float[]) null, 0); 
         fail("IndexOutOfBoundsException expected"); 
     } catch (final IndexOutOfBoundsException e) { 
     } 
 }
@Test
public void testAddObjectArrayDouble238() { 
     double[] array; 
     array = ArrayUtils.add((double[]) null, 0); 
     assertNull(array); 
     array = ArrayUtils.add(ArrayUtils.EMPTY_DOUBLE_ARRAY, 1); 
     assertTrue(Arrays.equals(ArrayUtils.EMPTY_DOUBLE_ARRAY, array)); 
     assertEquals(Double.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.add(new double[] { 1 }, 0); 
     assertTrue(Arrays.equals(ArrayUtils.EMPTY_DOUBLE_ARRAY, array)); 
     assertEquals(Double.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.add(new double[] { 1, 2 }, 1); 
     assertTrue(Arrays.equals(new double[] { 2 }, array)); 
     assertEquals(Double.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.add(new double[] { 1, 2, 1 }, 1); 
     assertTrue(Arrays.equals(new double[] { 1, 1 }, array)); 
     assertEquals(Double.TYPE, array.getClass().getComponentType()); 
     try { 
         ArrayUtils.add(new double[] { 1, 2 }, -1); 
         fail("IndexOutOfBoundsException expected"); 
     } catch (final IndexOutOfBoundsException e) { 
     } 
     try { 
         ArrayUtils.add(new double[] { 1, 2 }, 2); 
         fail("IndexOutOfBoundsException expected"); 
     } catch (final IndexOutOfBoundsException e) { 
     } 
     try { 
         ArrayUtils.add((double[]) null, 0); 
         fail("IndexOutOfBoundsException expected"); 
     } catch (final IndexOutOfBoundsException e) { 
     } 
 }
    

    

    

    

    

    

    

    

    

    
    
    

    

    

}
