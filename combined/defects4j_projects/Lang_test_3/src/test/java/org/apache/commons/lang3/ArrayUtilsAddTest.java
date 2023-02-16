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
public void testLANG571301() { 
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
public void testAddObjectArrayBoolean304() { 
     boolean[] newArray; 
     newArray = ArrayUtils.add((boolean[]) null, false); 
     assertTrue(Arrays.equals(new boolean[] { false }, newArray)); 
     assertEquals(Boolean.TYPE, newArray.getClass().getComponentType()); 
     newArray = ArrayUtils.add((boolean[]) null, true); 
     assertTrue(Arrays.equals(new boolean[] { true }, newArray)); 
     assertEquals(Boolean.TYPE, newArray.getClass().getComponentType()); 
     final boolean[] array1 = new boolean[] { true, false, true }; 
     newArray = ArrayUtils.add(array1, false); 
     assertTrue(Arrays.equals(new boolean[] { true, false, true }, newArray)); 
     assertEquals(Boolean.TYPE, newArray.getClass().getComponentType()); 
     newArray = ArrayUtils.add(array1, true); 
     assertTrue(Arrays.equals(new boolean[] { true, true, false }, newArray)); 
     assertEquals(Boolean.TYPE, newArray.getClass().getComponentType()); 
 }
@Test
public void testAddObjectArrayFloat305() { 
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
public void testAddObjectArrayLong306() { 
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
public void testAddObjectArrayShort307() { 
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
