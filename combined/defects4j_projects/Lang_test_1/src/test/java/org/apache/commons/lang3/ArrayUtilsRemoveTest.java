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
public void testRemoveElementCharArray247() { 
     char[] array; 
     array = ArrayUtils.removeElement((char[]) null, (char) 1); 
     assertNull(array); 
     array = ArrayUtils.removeElement(ArrayUtils.EMPTY_CHAR_ARRAY, (char) 1); 
     assertTrue(Arrays.equals(ArrayUtils.EMPTY_CHAR_ARRAY, array)); 
     assertEquals(Character.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeElement(new char[] { 1 }, (char) 1); 
     assertTrue(Arrays.equals(ArrayUtils.EMPTY_CHAR_ARRAY, array)); 
     assertEquals(Character.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeElement(new char[] { 1, 2 }, (char) 1); 
     assertTrue(Arrays.equals(new char[] { 2 }, array)); 
     assertEquals(Character.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeElement(new char[] { 1, 2, 1 }, (char) 1); 
     assertTrue(Arrays.equals(new char[] { 2, 1 }, array)); 
     assertEquals(Character.TYPE, array.getClass().getComponentType()); 
 }
@Test
public void testRemoveFloatArray248() { 
     float[] array; 
     array = ArrayUtils.remove(new float[] { 1 }, 0); 
     assertTrue(Arrays.equals(ArrayUtils.EMPTY_FLOAT_ARRAY, array)); 
     assertEquals(Float.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.remove(new float[] { 1, 2 }, 0); 
     assertTrue(Arrays.equals(new float[] { 2 }, array)); 
     assertEquals(Float.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.remove(new float[] { 1, 2 }, 1); 
     assertTrue(Arrays.equals(new float[] { 1 }, array)); 
     assertEquals(Float.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.remove(new float[] { 1, 2, 1 }, 1); 
     assertTrue(Arrays.equals(new float[] { 1, 1 }, array)); 
     assertEquals(Float.TYPE, array.getClass().getComponentType()); 
     try { 
         ArrayUtils.remove(new float[] { 1, 2 }, -1); 
         fail("IndexOutOfBoundsException expected"); 
     } catch (final IndexOutOfBoundsException e) { 
     } 
     try { 
         ArrayUtils.remove(new float[] { 1, 2 }, 2); 
         fail("IndexOutOfBoundsException expected"); 
     } catch (final IndexOutOfBoundsException e) { 
     } 
     try { 
         ArrayUtils.remove((float[]) null, 0); 
         fail("IndexOutOfBoundsException expected"); 
     } catch (final IndexOutOfBoundsException e) { 
     } 
 }
@Test
@SuppressWarnings("cast") 
 public void testRemoveElementFloatArray249() { 
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
public void testRemoveElementIntArray250() { 
     int[] array; 
     array = ArrayUtils.removeElement((int[]) null, 1); 
     assertNull(array); 
     array = ArrayUtils.removeElement(ArrayUtils.EMPTY_INT_ARRAY, 1); 
     assertTrue(Arrays.equals(ArrayUtils.EMPTY_INT_ARRAY, array)); 
     assertEquals(Integer.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeElement(new int[] { 1 }, 1); 
     assertTrue(Arrays.equals(ArrayUtils.EMPTY_INT_ARRAY, array)); 
     assertEquals(Integer.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeElement(new int[] { 1, 2 }, 1); 
     assertTrue(Arrays.equals(new int[] { 2 }, array)); 
     assertEquals(Integer.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.removeElement(new int[] { 1, 2, 1 }, 1); 
     assertTrue(Arrays.equals(new int[] { 2, 1 }, array)); 
     assertEquals(Integer.TYPE, array.getClass().getComponentType()); 
 }
    

    

    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
