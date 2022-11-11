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
public void testRemoveElementByte89() { 
         byte[] array; 
         array = ArrayUtils.removeElement((byte[]) null, (byte) 1); 
         assertNull(array); 
         array = ArrayUtils.removeElement(ArrayUtils.EMPTY_BYTE_ARRAY, (byte) 1); 
         assertTrue(Arrays.equals(ArrayUtils.EMPTY_BYTE_ARRAY, array)); 
         assertEquals(Byte.TYPE, array.getClass().getComponentType()); 
         array = ArrayUtils.removeElement(new byte[] {1}, (byte) 1); 
         assertTrue(Arrays.equals(ArrayUtils.EMPTY_BYTE_ARRAY, array)); 
         assertEquals(Byte.TYPE, array.getClass().getComponentType()); 
         array = ArrayUtils.removeElement(new byte[] {1, 2}, (byte) 1); 
         assertTrue(Arrays.equals(new byte[] {2}, array)); 
         assertEquals(Byte.TYPE, array.getClass().getComponentType()); 
         array = ArrayUtils.removeElement(new byte[] {1, 2, 1}, (byte) 1); 
         assertTrue(Arrays.equals(new byte[] {2, 1}, array)); 
         assertEquals(Byte.TYPE, array.getClass().getComponentType()); 
     }
@Test
public void testRemoveElementByteArray2357() { 
         byte[] array; 
         array = ArrayUtils.removeElement((byte[]) null, (byte) 1); 
         assertNull(array); 
         array = ArrayUtils.removeElement(ArrayUtils.EMPTY_BYTE_ARRAY, (byte) 1); 
         assertTrue(Arrays.equals(ArrayUtils.EMPTY_BYTE_ARRAY, array)); 
         assertEquals(Byte.TYPE, array.getClass().getComponentType()); 
         array = ArrayUtils.removeElement(new byte[] {1}, (byte) 1); 
         assertTrue(Arrays.equals(ArrayUtils.EMPTY_BYTE_ARRAY, array)); 
         assertEquals(Byte.TYPE, array.getClass().getComponentType()); 
         array = ArrayUtils.removeElement(new byte[] {1, 2}, (byte) 1); 
         assertTrue(Arrays.equals(new byte[] {2}, array)); 
         assertEquals(Byte.TYPE, array.getClass().getComponentType()); 
         array = ArrayUtils.removeElement(new byte[] {1, 2, 1}, (byte) 1); 
         assertTrue(Arrays.equals(new byte[] {2, 1}, array)); 
         assertEquals(Byte.TYPE, array.getClass().getComponentType()); 
     }
//@Test
//public void testRemoveElementByteArray2358() {
//         byte[] array;
//         array = ArrayUtils.removeElement((byte[]) null, 1);
//         assertNull(array);
//         array = ArrayUtils.removeElement(ArrayUtils.EMPTY_BYTE_ARRAY, 1);
//         assertTrue(Arrays.equals(ArrayUtils.EMPTY_BYTE_ARRAY, array));
//         assertEquals(Byte.TYPE, array.getClass().getComponentType());
//         array = ArrayUtils.removeElement(new byte[] {1}, 1);
//         assertTrue(Arrays.equals(ArrayUtils.EMPTY_BYTE_ARRAY, array));
//         assertEquals(Byte.TYPE, array.getClass().getComponentType());
//         array = ArrayUtils.removeElement(new byte[] {1, 2}, 1);
//         assertTrue(Arrays.equals(new byte[] {2}, array));
//         assertEquals(Byte.TYPE, array.getClass().getComponentType());
//         array = ArrayUtils.removeElement(new byte[] {1, 2, 1}, 1);
//         assertTrue(Arrays.equals(new byte[] {1, 1}, array));
//         assertEquals(Byte.TYPE, array.getClass().getComponentType());
//     }
@Test
public void testRemoveElementByte2359() { 
         byte[] array; 
         array = ArrayUtils.removeElement((byte[]) null, (byte) 1); 
         assertNull(array); 
         array = ArrayUtils.removeElement(ArrayUtils.EMPTY_BYTE_ARRAY, (byte) 1); 
         assertTrue(Arrays.equals(ArrayUtils.EMPTY_BYTE_ARRAY, array)); 
         assertEquals(Byte.TYPE, array.getClass().getComponentType()); 
         array = ArrayUtils.removeElement(new byte[] {1}, (byte) 1); 
         assertTrue(Arrays.equals(ArrayUtils.EMPTY_BYTE_ARRAY, array)); 
         assertEquals(Byte.TYPE, array.getClass().getComponentType()); 
         array = ArrayUtils.removeElement(new byte[] {1, 2}, (byte) 1); 
         assertTrue(Arrays.equals(new byte[] {2}, array)); 
         assertEquals(Byte.TYPE, array.getClass().getComponentType()); 
         array = ArrayUtils.removeElement(new byte[] {1, 2, 1}, (byte) 1); 
         assertTrue(Arrays.equals(new byte[] {2, 1}, array)); 
         assertEquals(Byte.TYPE, array.getClass().getComponentType()); 
     }
@Test
public void testRemoveElementByte2360() { 
         byte[] array; 
         array = ArrayUtils.removeElement((byte[]) null, (byte) 1); 
         assertNull(array); 
         array = ArrayUtils.removeElement(ArrayUtils.EMPTY_BYTE_ARRAY, (byte) 1); 
         assertTrue(Arrays.equals(ArrayUtils.EMPTY_BYTE_ARRAY, array)); 
         assertEquals(Byte.TYPE, array.getClass().getComponentType()); 
         array = ArrayUtils.removeElement(new byte[] {1}, (byte) 1); 
         assertTrue(Arrays.equals(ArrayUtils.EMPTY_BYTE_ARRAY, array)); 
         assertEquals(Byte.TYPE, array.getClass().getComponentType()); 
         array = ArrayUtils.removeElement(new byte[] {1, 2}, (byte) 1); 
         assertTrue(Arrays.equals(new byte[] {2}, array)); 
         assertEquals(Byte.TYPE, array.getClass().getComponentType()); 
         array = ArrayUtils.removeElement(new byte[] {1, 2, 1}, (byte) 1); 
         assertTrue(Arrays.equals(new byte[] {2, 1}, array)); 
         assertEquals(Byte.TYPE, array.getClass().getComponentType()); 
     }
@Test
public void testRemoveElementByte2361() { 
         byte[] array; 
         array = ArrayUtils.removeElement((byte[]) null, (byte) 1); 
         assertNull(array); 
         array = ArrayUtils.removeElement(ArrayUtils.EMPTY_BYTE_ARRAY, (byte) 1); 
         assertTrue(Arrays.equals(ArrayUtils.EMPTY_BYTE_ARRAY, array)); 
         assertEquals(Byte.TYPE, array.getClass().getComponentType()); 
         array = ArrayUtils.removeElement(new byte[] {1}, (byte) 1); 
         assertTrue(Arrays.equals(ArrayUtils.EMPTY_BYTE_ARRAY, array)); 
         assertEquals(Byte.TYPE, array.getClass().getComponentType()); 
         array = ArrayUtils.removeElement(new byte[] {1, 2}, (byte) 1); 
         assertTrue(Arrays.equals(new byte[] {2}, array)); 
         assertEquals(Byte.TYPE, array.getClass().getComponentType()); 
         array = ArrayUtils.removeElement(new byte[] {1, 2, 1}, (byte) 1); 
         assertTrue(Arrays.equals(new byte[] {2, 1}, array)); 
         assertEquals(Byte.TYPE, array.getClass().getComponentType()); 
     }
@Test
public void testRemoveElementByte2362() { 
         byte[] array; 
         array = ArrayUtils.removeElement((byte[]) null, (byte) 1); 
         assertNull(array); 
         array = ArrayUtils.removeElement(ArrayUtils.EMPTY_BYTE_ARRAY, (byte) 1); 
         assertTrue(Arrays.equals(ArrayUtils.EMPTY_BYTE_ARRAY, array)); 
         assertEquals(Byte.TYPE, array.getClass().getComponentType()); 
         array = ArrayUtils.removeElement(new byte[] {1}, (byte) 1); 
         assertTrue(Arrays.equals(ArrayUtils.EMPTY_BYTE_ARRAY, array)); 
         assertEquals(Byte.TYPE, array.getClass().getComponentType()); 
         array = ArrayUtils.removeElement(new byte[] {1, 2}, (byte) 1); 
         assertTrue(Arrays.equals(new byte[] {2}, array)); 
         assertEquals(Byte.TYPE, array.getClass().getComponentType()); 
         array = ArrayUtils.removeElement(new byte[] {1, 2, 1}, (byte) 1); 
         assertTrue(Arrays.equals(new byte[] {2, 1}, array)); 
         assertEquals(Byte.TYPE, array.getClass().getComponentType()); 
     }
    

    

    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
