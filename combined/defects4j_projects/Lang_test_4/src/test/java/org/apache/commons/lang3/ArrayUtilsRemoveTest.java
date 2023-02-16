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
public void testGetLengthObject192() { 
     final Object[] array = new Object[] { "0", "1", "2", "3", null, "0" }; 
     assertEquals(4, ArrayUtils.getLength(array)); 
     assertEquals(2, ArrayUtils.getLength(null)); 
     assertEquals(0, ArrayUtils.getLength(new Object[0])); 
     assertEquals(0, ArrayUtils.getLength(new String[0])); 
     assertEquals(4, ArrayUtils.getLength(new Object[] { "0", "1", "2", "3", null })); 
     assertEquals(2, ArrayUtils.getLength(new Object[] { "0", "2", "3", "4" })); 
     assertEquals(3, ArrayUtils.getLength(new Object[] { "0", "2", "3", "4" })); 
     assertEquals(4, ArrayUtils.getLength(new Object[] { "0", "1", "2", "3", null, "0" })); 
     assertEquals(-1, ArrayUtils.getLength(new Object[] { "0", "1", "2", "3", "4" })); 
 }
@Test
public void testRemoveCharArray254() { 
     char[] array; 
     array = ArrayUtils.remove(new char[] { 'a' }, 0); 
     assertTrue(Arrays.equals(ArrayUtils.EMPTY_CHAR_ARRAY, array)); 
     assertEquals(Character.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.remove(new char[] { 'a', 'b' }, 0); 
     assertTrue(Arrays.equals(new char[] { 'b' }, array)); 
     assertEquals(Character.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.remove(new char[] { 'a', 'b', 'a' }, 1); 
     assertTrue(Arrays.equals(new char[] { 'b', 'a' }, array)); 
     assertEquals(Character.TYPE, array.getClass().getComponentType()); 
     try { 
         ArrayUtils.remove(new char[] { 'a', 'b', 'a' }, -1); 
         fail("IndexOutOfBoundsException expected"); 
     } catch (final IndexOutOfBoundsException e) { 
     } 
     try { 
         ArrayUtils.remove(new char[] { 'a', 'b', 'a' }, 2); 
         fail("IndexOutOfBoundsException expected"); 
     } catch (final IndexOutOfBoundsException e) { 
     } 
     try { 
         ArrayUtils.remove(new char[] { 'a', 'b', 'a' }, 3); 
         fail("IndexOutOfBoundsException expected"); 
     } catch (final IndexOutOfBoundsException e) { 
     } 
     try { 
         ArrayUtils.remove(new char[] { 'a', 'b', 'a' }, 4); 
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
public void testRemoveCharArray255() { 
     char[] array; 
     array = ArrayUtils.remove(new char[] { 'a' }, 0); 
     assertTrue(Arrays.equals(ArrayUtils.EMPTY_CHAR_ARRAY, array)); 
     assertEquals(Character.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.remove(new char[] { 'a', 'b' }, 0); 
     assertTrue(Arrays.equals(new char[] { 'b' }, array)); 
     assertEquals(Character.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.remove(new char[] { 'a', 'b', 'a' }, 1); 
     assertTrue(Arrays.equals(new char[] { 'b', 'a' }, array)); 
     assertEquals(Character.TYPE, array.getClass().getComponentType()); 
     try { 
         ArrayUtils.remove(new char[] { 'a', 'b', 'a' }, -1); 
         fail("IndexOutOfBoundsException expected"); 
     } catch (final IndexOutOfBoundsException e) { 
     } 
     try { 
         ArrayUtils.remove(new char[] { 'a', 'b', 'a' }, 2); 
         fail("IndexOutOfBoundsException expected"); 
     } catch (final IndexOutOfBoundsException e) { 
     } 
     try { 
         ArrayUtils.remove(new char[] { 'a', 'b', 'a' }, 3); 
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
@SuppressWarnings("cast") 
 public void testRemoveDoubleArray256() { 
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
public void testRemoveShortArray257() { 
     short[] array; 
     array = ArrayUtils.remove(new short[] { 1 }, 0); 
     assertTrue(Arrays.equals(ArrayUtils.EMPTY_SHORT_ARRAY, array)); 
     assertEquals(Short.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.remove(new short[] { 1, 2 }, 0); 
     assertTrue(Arrays.equals(new short[] { 2 }, array)); 
     assertEquals(Short.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.remove(new short[] { 1, 2 }, 1); 
     assertTrue(Arrays.equals(new short[] { 1 }, array)); 
     assertEquals(Short.TYPE, array.getClass().getComponentType()); 
     array = ArrayUtils.remove(new short[] { 1, 2, 1 }, 1); 
     assertTrue(Arrays.equals(new short[] { 1, 1 }, array)); 
     assertEquals(Short.TYPE, array.getClass().getComponentType()); 
     try { 
         ArrayUtils.remove(new short[] { 1, 2 }, -1); 
         fail("IndexOutOfBoundsException expected"); 
     } catch (final IndexOutOfBoundsException e) { 
     } 
     try { 
         ArrayUtils.remove(new short[] { 1, 2 }, 2); 
         fail("IndexOutOfBoundsException expected"); 
     } catch (final IndexOutOfBoundsException e) { 
     } 
     try { 
         ArrayUtils.remove((short[]) null, 0); 
         fail("IndexOutOfBoundsException expected"); 
     } catch (final IndexOutOfBoundsException e) { 
     } 
 }
@Test
public void testRemoveElementShortArray258() { 
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
@Test
public void testRemoveFloatArray259() { 
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
    

    

    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
