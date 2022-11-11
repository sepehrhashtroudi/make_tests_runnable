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
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;

import org.junit.Test;

/**
 * Tests ArrayUtils remove and removeElement methods.
 * 
 * @version $Id$
 */
public class ArrayUtilsRemoveMultipleTest {

@Test
public void testRemoveElementBooleanArray10() { 
         boolean[] array; 
         array = ArrayUtils.removeElement((boolean[]) null, true); 
         assertNull(array); 
         array = ArrayUtils.removeElement(ArrayUtils.EMPTY_BOOLEAN_ARRAY, true); 
         assertTrue(Arrays.equals(ArrayUtils.EMPTY_BOOLEAN_ARRAY, array)); 
         assertEquals(Boolean.TYPE, array.getClass().getComponentType()); 
         array = ArrayUtils.removeElement(new boolean[] {true}, true); 
         assertTrue(Arrays.equals(ArrayUtils.EMPTY_BOOLEAN_ARRAY, array)); 
         assertEquals(Boolean.TYPE, array.getClass().getComponentType()); 
         array = ArrayUtils.removeElement(new boolean[] {true, false}, true); 
         assertTrue(Arrays.equals(new boolean[] {false}, array)); 
         assertEquals(Boolean.TYPE, array.getClass().getComponentType()); 
         array = ArrayUtils.removeElement(new boolean[] {true, false, true}, true); 
         assertTrue(Arrays.equals(new boolean[] {false, true}, array)); 
         assertEquals(Boolean.TYPE, array.getClass().getComponentType()); 
     }
@Test
public void testRemoveAllLongArray1989() { 
         long[] array; 
         array = ArrayUtils.removeAll(new long[] { 1, 2 }, 2); 
         assertTrue(Arrays.equals(ArrayUtils.EMPTY_LONG_ARRAY, array)); 
         assertEquals(Long.TYPE, array.getClass().getComponentType()); 
         array = ArrayUtils.removeAll(new long[] { 1, 2 }, 2); 
         assertTrue(Arrays.equals(new long[] { 2 }, array)); 
         assertEquals(Long.TYPE, array.getClass().getComponentType()); 
         array = ArrayUtils.removeAll(new long[] { 1, 2, 1 }, 2); 
         assertTrue(Arrays.equals(new long[] { 1, 1 }, array)); 
         assertEquals(Long.TYPE, array.getClass().getComponentType()); 
         array = ArrayUtils.removeAll(new long[] { 1, 2, 1 }, 2); 
         assertTrue(Arrays.equals(new long[] { 1, 1 }, array)); 
         assertEquals(Long.TYPE, array.getClass().getComponentType()); 
  
         array = ArrayUtils.removeAll(new long[] { 1, 2, 3 }, 2); 
         assertTrue(Arrays.equals(new long[] { 3 }, array)); 
         assertEquals(Long.TYPE, array.getClass().getComponentType()); 
         array = ArrayUtils.removeAll(new long[] { 1, 2, 3, 1 }, 2); 
         assertTrue(Arrays.equals(new long[] { 3, 1 }, array)); 
         assertEquals(Long.TYPE, array.getClass().getComponentType()); 
     }
@Test
public void testIndexOfByteWithStartIndex1990() { 
         byte[] array = null; 
         assertEquals(-1, ArrayUtils.indexOf(array, (byte) 0, 2)); 
         array = new byte[] { 0, 1, 2, 3, 0 }; 
         assertEquals(0, ArrayUtils.indexOf(array, (byte) 0, 2)); 
         assertEquals(1, ArrayUtils.indexOf(array, (byte) 1, 2)); 
         assertEquals(2, ArrayUtils.indexOf(array, (byte) 2, 2)); 
         assertEquals(-1, ArrayUtils.indexOf(array, (byte) 3, 2)); 
         assertEquals(-1, ArrayUtils.indexOf(array, (byte) 3, -1)); 
         assertEquals(-1, ArrayUtils.indexOf(array, (byte) 99)); 
         assertEquals(4, ArrayUtils.indexOf(array, (byte) 0, 88)); 
     }
@Test
public void testRemoveAllLongArray1997() { 
         long[] array; 
         array = ArrayUtils.removeAll(new long[] { 1, 2 }, 2); 
         assertTrue(Arrays.equals(ArrayUtils.EMPTY_LONG_ARRAY, array)); 
         assertEquals(Long.TYPE, array.getClass().getComponentType()); 
         array = ArrayUtils.removeAll(new long[] { 1, 2 }, 2); 
         assertTrue(Arrays.equals(new long[] { 2 }, array)); 
         assertEquals(Long.TYPE, array.getClass().getComponentType()); 
         array = ArrayUtils.removeAll(new long[] { 1, 2, 1 }, 2); 
         assertTrue(Arrays.equals(new long[] { 1, 1 }, array)); 
         assertEquals(Long.TYPE, array.getClass().getComponentType()); 
         array = ArrayUtils.removeAll(new long[] { 1, 2, 1 }, 2); 
         assertTrue(Arrays.equals(new long[] { 1, 1 }, array)); 
         assertEquals(Long.TYPE, array.getClass().getComponentType()); 
  
         array = ArrayUtils.removeAll(new long[] { 1, 2, 3 }, 2); 
         assertTrue(Arrays.equals(new long[] { 3 }, array)); 
         assertEquals(Long.TYPE, array.getClass().getComponentType()); 
         array = ArrayUtils.removeAll(new long[] { 1, 2, 3, 1 }, 2); 
         assertTrue(Arrays.equals(new long[] { 3, 1 }, array)); 
         assertEquals(Long.TYPE, array.getClass().getComponentType()); 
     }
//@Test
//public void testRemoveAllBooleanArray1998() {
//         boolean[] array;
//         array = ArrayUtils.removeAll(new boolean[] { true }, new BitSet(0));
//         assertTrue(Arrays.equals(ArrayUtils.EMPTY_BOOLEAN_ARRAY, array));
//         assertEquals(Boolean.TYPE, array.getClass().getComponentType());
//         array = ArrayUtils.removeAll(new boolean[] { true, false }, new BitSet(1));
//         assertTrue(Arrays.equals(new boolean[] { false }, array));
//         assertEquals(Boolean.TYPE, array.getClass().getComponentType());
//         array = ArrayUtils.removeAll(new boolean[] { true, false, true }, new BitSet(2));
//         assertTrue(Arrays.equals(new boolean[] { true, false }, array));
//         assertEquals(Boolean.TYPE, array.getClass().getComponentType());
//         array = ArrayUtils.removeAll(new boolean[] { true, true, false }, new BitSet(3));
//         assertTrue(Arrays.equals(new boolean[] { false, true }, array));
//         assertEquals(Boolean.TYPE, array.getClass().getComponentType());
//
//         array = ArrayUtils.removeAll(new boolean[] { true, false, true }, new BitSet(1));
//         assertTrue(Arrays.equals(ArrayUtils.EMPTY_BOOLEAN_ARRAY, array));
//         assertEquals(Boolean.TYPE, array.getClass().getComponentType());
//         array = ArrayUtils.removeAll(new boolean[] { true, false, true }, new BitSet(2));
//         assertTrue(Arrays.equals(new boolean[] { true, false }, array));
//         assertEquals(Boolean.TYPE, array.getClass().getComponentType());
//     }
@Test
public void testIndexOfByteWithStartIndex1999() { 
         byte[] array = null; 
         assertEquals(-1, ArrayUtils.indexOf(array, (byte) 0, 2)); 
         array = new byte[] { 0, 1, 2, 3, 0 }; 
         assertEquals(0, ArrayUtils.indexOf(array, (byte) 0, 2)); 
         assertEquals(1, ArrayUtils.indexOf(array, (byte) 1, 2)); 
         assertEquals(2, ArrayUtils.indexOf(array, (byte) 2, 2)); 
         assertEquals(-1, ArrayUtils.indexOf(array, (byte) 3, 2)); 
         assertEquals(-1, ArrayUtils.indexOf(array, (byte) 3, -1)); 
         assertEquals(-1, ArrayUtils.indexOf(array, (byte) 99)); 
         assertEquals(4, ArrayUtils.indexOf(array, (byte) 0, 88)); 
     }
@Test
public void testRemoveAllLongArray2005() { 
         long[] array; 
         array = ArrayUtils.removeAll(new long[] { 1, 2 }, 2); 
         assertTrue(Arrays.equals(ArrayUtils.EMPTY_LONG_ARRAY, array)); 
         assertEquals(Long.TYPE, array.getClass().getComponentType()); 
         array = ArrayUtils.removeAll(new long[] { 1, 2 }, 2); 
         assertTrue(Arrays.equals(new long[] { 2 }, array)); 
         assertEquals(Long.TYPE, array.getClass().getComponentType()); 
         array = ArrayUtils.removeAll(new long[] { 1, 2, 1 }, 2); 
         assertTrue(Arrays.equals(new long[] { 1, 1 }, array)); 
         assertEquals(Long.TYPE, array.getClass().getComponentType()); 
         array = ArrayUtils.removeAll(new long[] { 1, 2, 1 }, 2); 
         assertTrue(Arrays.equals(new long[] { 1, 1 }, array)); 
         assertEquals(Long.TYPE, array.getClass().getComponentType()); 
  
         array = ArrayUtils.removeAll(new long[] { 1, 2, 3 }, 2); 
         assertTrue(Arrays.equals(ArrayUtils.EMPTY_LONG_ARRAY, array)); 
         assertEquals(Long.TYPE, array.getClass().getComponentType()); 
         array = ArrayUtils.removeAll(new long[] { 1, 2, 3, 1 }, 2); 
         assertTrue(Arrays.equals(new long[] { 3, 1 }, array)); 
         assertEquals(Long.TYPE, array.getClass().getComponentType()); 
     }
@Test
public void testRemoveAllLongArray2007() { 
         long[] array; 
         array = ArrayUtils.removeAll(new long[] { 1, 2 }, 2); 
         assertTrue(Arrays.equals(ArrayUtils.EMPTY_LONG_ARRAY, array)); 
         assertEquals(Long.TYPE, array.getClass().getComponentType()); 
         array = ArrayUtils.removeAll(new long[] { 1, 2 }, 2); 
         assertTrue(Arrays.equals(new long[] { 2 }, array)); 
         assertEquals(Long.TYPE, array.getClass().getComponentType()); 
         array = ArrayUtils.removeAll(new long[] { 1, 2, 1 }, 2); 
         assertTrue(Arrays.equals(new long[] { 1, 1 }, array)); 
         assertEquals(Long.TYPE, array.getClass().getComponentType()); 
         array = ArrayUtils.removeAll(new long[] { 1, 2, 1 }, 2); 
         assertTrue(Arrays.equals(new long[] { 1, 1 }, array)); 
         assertEquals(Long.TYPE, array.getClass().getComponentType()); 
  
         array = ArrayUtils.removeAll(new long[] { 1, 2, 3 }, 2); 
         assertTrue(Arrays.equals(new long[] { 3 }, array)); 
         assertEquals(Long.TYPE, array.getClass().getComponentType()); 
         array = ArrayUtils.removeAll(new long[] { 1, 2, 3, 1 }, 2); 
         assertTrue(Arrays.equals(new long[] { 3, 1 }, array)); 
         assertEquals(Long.TYPE, array.getClass().getComponentType()); 
     }
@Test
public void testIndexOfByteWithStartIndex2015() { 
         byte[] array = null; 
         assertEquals(-1, ArrayUtils.indexOf(array, (byte) 0, 2)); 
         array = new byte[] { 0, 1, 2, 3, 0 }; 
         assertEquals(0, ArrayUtils.indexOf(array, (byte) 0, 2)); 
         assertEquals(1, ArrayUtils.indexOf(array, (byte) 1, 2)); 
         assertEquals(2, ArrayUtils.indexOf(array, (byte) 2, 2)); 
         assertEquals(-1, ArrayUtils.indexOf(array, (byte) 3, 2)); 
         assertEquals(-1, ArrayUtils.indexOf(array, (byte) 3, -1)); 
         assertEquals(-1, ArrayUtils.indexOf(array, (byte) 99)); 
         assertEquals(4, ArrayUtils.indexOf(array, (byte) 0, 88)); 
     }
@Test
public void testIndexOfByteWithStartIndex2023() { 
         byte[] array = null; 
         assertEquals(-1, ArrayUtils.indexOf(array, (byte) 0, 2)); 
         array = new byte[] { 0, 1, 2, 3, 0 }; 
         assertEquals(0, ArrayUtils.indexOf(array, (byte) 0, 2)); 
         assertEquals(1, ArrayUtils.indexOf(array, (byte) 1, 2)); 
         assertEquals(2, ArrayUtils.indexOf(array, (byte) 2, 2)); 
         assertEquals(-1, ArrayUtils.indexOf(array, (byte) 3, 2)); 
         assertEquals(-1, ArrayUtils.indexOf(array, (byte) 3, -1)); 
         assertEquals(-1, ArrayUtils.indexOf(array, (byte) 99)); 
         assertEquals(4, ArrayUtils.indexOf(array, (byte) 0, 88)); 
     }
@Test
public void testRemoveAllLongArray2025() { 
         long[] array; 
         array = ArrayUtils.removeAll(new long[] { 1, 2 }, 2); 
         assertTrue(Arrays.equals(ArrayUtils.EMPTY_LONG_ARRAY, array)); 
         assertEquals(Long.TYPE, array.getClass().getComponentType()); 
         array = ArrayUtils.removeAll(new long[] { 1, 2 }, 2); 
         assertTrue(Arrays.equals(new long[] { 2 }, array)); 
         assertEquals(Long.TYPE, array.getClass().getComponentType()); 
         array = ArrayUtils.removeAll(new long[] { 1, 2, 1 }, 2); 
         assertTrue(Arrays.equals(new long[] { 1, 1 }, array)); 
         assertEquals(Long.TYPE, array.getClass().getComponentType()); 
         array = ArrayUtils.removeAll(new long[] { 1, 2, 1 }, 2); 
         assertTrue(Arrays.equals(new long[] { 1, 1 }, array)); 
         assertEquals(Long.TYPE, array.getClass().getComponentType()); 
  
         array = ArrayUtils.removeAll(new long[] { 1, 2, 3 }, 2); 
         assertTrue(Arrays.equals(new long[] { 3 }, array)); 
         assertEquals(Long.TYPE, array.getClass().getComponentType()); 
         array = ArrayUtils.removeAll(new long[] { 1, 2, 3, 1 }, 2); 
         assertTrue(Arrays.equals(new long[] { 3, 1 }, array)); 
         assertEquals(Long.TYPE, array.getClass().getComponentType()); 
     }
@Test
public void testIndexOfByteWithStartIndex2026() { 
         byte[] array = null; 
         assertEquals(-1, ArrayUtils.indexOf(array, (byte) 0, 2)); 
         array = new byte[] { 0, 1, 2, 3, 0 }; 
         assertEquals(0, ArrayUtils.indexOf(array, (byte) 0, 2)); 
         assertEquals(1, ArrayUtils.indexOf(array, (byte) 1, 2)); 
         assertEquals(2, ArrayUtils.indexOf(array, (byte) 2, 2)); 
         assertEquals(-1, ArrayUtils.indexOf(array, (byte) 3, 2)); 
         assertEquals(-1, ArrayUtils.indexOf(array, (byte) 3, -1)); 
         assertEquals(-1, ArrayUtils.indexOf(array, (byte) 99)); 
         assertEquals(4, ArrayUtils.indexOf(array, (byte) 0, 88)); 
     }
@Test
public void testIndexOfByteWithStartIndex2027() { 
         byte[] array = null; 
         assertEquals(-1, ArrayUtils.indexOf(array, (byte) 0, 2)); 
         array = new byte[] { 0, 1, 2, 3, 0 }; 
         assertEquals(0, ArrayUtils.indexOf(array, (byte) 0, 2)); 
         assertEquals(1, ArrayUtils.indexOf(array, (byte) 1, 2)); 
         assertEquals(2, ArrayUtils.indexOf(array, (byte) 2, 2)); 
         assertEquals(-1, ArrayUtils.indexOf(array, (byte) 3, 2)); 
         assertEquals(-1, ArrayUtils.indexOf(array, (byte) 3, -1)); 
         assertEquals(-1, ArrayUtils.indexOf(array, (byte) 99)); 
         assertEquals(4, ArrayUtils.indexOf(array, (byte) 0, 88)); 
     }
@Test
public void testIndexOfByteWithStartIndex2033() { 
         byte[] array = null; 
         assertEquals(-1, ArrayUtils.indexOf(array, (byte) 0, 2)); 
         array = new byte[] { 0, 1, 2, 3, 0 }; 
         assertEquals(0, ArrayUtils.indexOf(array, (byte) 0, 2)); 
         assertEquals(1, ArrayUtils.indexOf(array, (byte) 1, 2)); 
         assertEquals(2, ArrayUtils.indexOf(array, (byte) 2, 2)); 
         assertEquals(-1, ArrayUtils.indexOf(array, (byte) 3, 2)); 
         assertEquals(-1, ArrayUtils.indexOf(array, (byte) 3, -1)); 
         assertEquals(-1, ArrayUtils.indexOf(array, (byte) 99)); 
         assertEquals(4, ArrayUtils.indexOf(array, (byte) 0, 88)); 
     }
@Test
public void testRemoveAllLongArray2034() { 
         long[] array; 
         array = ArrayUtils.removeAll(new long[] { 1, 2 }, 2); 
         assertTrue(Arrays.equals(ArrayUtils.EMPTY_LONG_ARRAY, array)); 
         assertEquals(Long.TYPE, array.getClass().getComponentType()); 
         array = ArrayUtils.removeAll(new long[] { 1, 2 }, 2); 
         assertTrue(Arrays.equals(new long[] { 2 }, array)); 
         assertEquals(Long.TYPE, array.getClass().getComponentType()); 
         array = ArrayUtils.removeAll(new long[] { 1, 2, 1 }, 2); 
         assertTrue(Arrays.equals(new long[] { 1, 1 }, array)); 
         assertEquals(Long.TYPE, array.getClass().getComponentType()); 
         array = ArrayUtils.removeAll(new long[] { 1, 2, 1 }, 2); 
         assertTrue(Arrays.equals(new long[] { 1, 1 }, array)); 
         assertEquals(Long.TYPE, array.getClass().getComponentType()); 
  
         array = ArrayUtils.removeAll(new long[] { 1, 2, 3 }, 2); 
         assertTrue(Arrays.equals(new long[] { 3 }, array)); 
         assertEquals(Long.TYPE, array.getClass().getComponentType()); 
         array = ArrayUtils.removeAll(new long[] { 1, 2, 3, 1 }, 2); 
         assertTrue(Arrays.equals(new long[] { 3, 1 }, array)); 
         assertEquals(Long.TYPE, array.getClass().getComponentType()); 
     }
    

    

    

    

    

    

    

    

    

    

    

    

    

    

    

    

    

    

    

    

    

    

    

    

    

    

    

    

    

    

    

    

    

    

    

    

    

    

    

    

    

    

    

    

    

    

    

    

    

    

    

    

    

    

    

}
