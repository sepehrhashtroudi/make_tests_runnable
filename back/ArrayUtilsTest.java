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
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.Date;
import java.util.Map;

import org.junit.Test;

/**
 * Unit tests {@link org.apache.commons.lang3.ArrayUtils}.
 *
 * @version $Id$
 */
public class ArrayUtilsTest  {

    //-----------------------------------------------------------------------
@Test
public void testNullToEmptyFloatObject19() { 
         // Test null handling 
         assertArrayEquals(ArrayUtils.EMPTY_FLOAT_OBJECT_ARRAY, ArrayUtils.nullToEmpty((Float[]) null)); 
         // Test valid array handling 
         final Float[] original = new Float[] {0f, 0f}; 
         assertArrayEquals(original, ArrayUtils.nullToEmpty(original)); 
         // Test empty array handling 
         final Float[] empty = new Float[]{}; 
         final Float[] result = ArrayUtils.nullToEmpty(empty); 
         assertArrayEquals(ArrayUtils.EMPTY_FLOAT_OBJECT_ARRAY, result); 
         assertTrue(empty != result); 
     }
@Test
public void testIndexOfWithStartIndex47() { 
         final Object[] array = new Object[] { "0", "1", "2", "3", null, "0" }; 
         assertEquals(-1, ArrayUtils.indexOf(null, null, 2)); 
         assertEquals(-1, ArrayUtils.indexOf(null, "0", 2)); 
         assertEquals(0, ArrayUtils.indexOf(array, "0", 2)); 
         assertEquals(1, ArrayUtils.indexOf(array, "1", 2)); 
         assertEquals(2, ArrayUtils.indexOf(array, "2", 2)); 
         assertEquals(-1, ArrayUtils.indexOf(array, "3", 2)); 
         assertEquals(-1, ArrayUtils.indexOf(array, "3", -1)); 
         assertEquals(4, ArrayUtils.indexOf(array, null, 5)); 
         assertEquals(-1, ArrayUtils.indexOf(array, null, 2)); 
         assertEquals(-1, ArrayUtils.indexOf(array, "notInArray", 5)); 
          
         assertEquals(-1, ArrayUtils.indexOf(array, null, -1)); 
         assertEquals(-1, ArrayUtils.indexOf(array, "0", 88)); 
     }
@Test
public void testLastIndexOfBooleanWithStartIndex126() { 
         boolean[] array = null; 
         assertEquals(-1, ArrayUtils.lastIndexOf(array, true, 2)); 
         array = new boolean[] { true, true, false, true }; 
         assertEquals(0, ArrayUtils.lastIndexOf(array, true, 2)); 
         assertEquals(1, ArrayUtils.lastIndexOf(array, false, 1)); 
         array = new boolean[] { true, true, false, true }; 
         assertEquals(4, ArrayUtils.lastIndexOf(array, true, 2)); 
         assertEquals(-1, ArrayUtils.lastIndexOf(array, false, -1)); 
         assertEquals(-1, ArrayUtils.lastIndexOf(array, false, 88)); 
     }
@Test
public void testNullToEmptyFloatObject807() { 
         // Test null handling 
         assertArrayEquals(ArrayUtils.EMPTY_FLOAT_OBJECT_ARRAY, ArrayUtils.nullToEmpty((Float[]) null)); 
         // Test valid array handling 
         final Float[] original = new Float[] {Float.valueOf(Float.MIN_VALUE),  
                 Float.valueOf(Float.MAX_VALUE), Float.valueOf(9999999)}; 
         assertArrayEquals(original, ArrayUtils.nullToEmpty(original)); 
         // Test empty array handling 
         final Float[] empty = new Float[]{}; 
         final Float[] result = ArrayUtils.nullToEmpty(empty); 
         assertArrayEquals(ArrayUtils.EMPTY_FLOAT_OBJECT_ARRAY, result); 
         assertTrue(empty != result); 
     }
@Test
public void testNullToEmptyFloatObject808() { 
         // Test null handling 
         assertArrayEquals(ArrayUtils.EMPTY_FLOAT_OBJECT_ARRAY, ArrayUtils.nullToEmpty((Float[]) null)); 
         // Test valid array handling 
         final Float[] original = new Float[] {Float.valueOf(Float.MIN_VALUE),  
                 Float.valueOf(Float.MAX_VALUE), Float.valueOf(9999999)}; 
         assertArrayEquals(original, ArrayUtils.nullToEmpty(original)); 
         // Test empty array handling 
         final Float[] empty = new Float[]{}; 
         final Float[] result = ArrayUtils.nullToEmpty(empty); 
         assertArrayEquals(ArrayUtils.EMPTY_FLOAT_OBJECT_ARRAY, result); 
         assertTrue(empty != result); 
     }
@Test
public void testNullToEmptyFloatObject809() { 
         // Test null handling 
         assertArrayEquals(ArrayUtils.EMPTY_FLOAT_OBJECT_ARRAY, ArrayUtils.nullToEmpty((Float[]) null)); 
         // Test valid array handling 
         final Float[] original = new Float[] {Float.valueOf(Float.MIN_VALUE),  
                 Float.valueOf(Float.MAX_VALUE), Float.valueOf(9999999)}; 
         assertArrayEquals(original, ArrayUtils.nullToEmpty(original)); 
         // Test empty array handling 
         final Float[] empty = new Float[]{}; 
         final Float[] result = ArrayUtils.nullToEmpty(empty); 
         assertArrayEquals(ArrayUtils.EMPTY_FLOAT_OBJECT_ARRAY, result); 
         assertTrue(empty != result); 
     }
@Test
public void testToObject_object1441() { 
         final Object[] obj = new Object[] { "0", "1", "2", "3", null, "0" }; 
         final Map<Object, Object> map = ArrayUtils.toMap(obj); 
         assertEquals(3, map.size()); 
         assertEquals("0", map.get("0")); 
         assertEquals("1", map.get("1")); 
         assertEquals("2", map.get("2")); 
         assertEquals(null, map.get("3")); 
     }
//@Test
//public void testToObject_object1446() {
//         final Object[] b = null;
//         assertEquals(null, ArrayUtils.toMap(b));
//
//         assertSame(null, ArrayUtils.toMap(new Object[0]));
//
//         assertTrue(Arrays.equals(
//             new HashMap<Object, Object>(),
//             ArrayUtils.toMap(new Object[] {Boolean.TRUE, Boolean.FALSE}))
//         );
//         assertTrue(Arrays.equals(
//             new HashMap<Object, Object>(),
//             ArrayUtils.toMap(new Object[] {Boolean.TRUE, null, Boolean.FALSE}))
//         );
//         assertTrue(Arrays.equals(
//             new HashMap<Object, Object>(),
//             ArrayUtils.toMap(new Object[] {Boolean.TRUE, null, Boolean.FALSE}))
//         );
//     }
@Test
public void testToObject_object1450() { 
         final Object[] obj = new Object[] { "0", "1", "2", "3", null, "0" }; 
         final Map<Object, Object> map = ArrayUtils.toMap(obj); 
         assertEquals(4, map.size()); 
         assertEquals("0", map.get("0")); 
         assertEquals("1", map.get("1")); 
         assertEquals("2", map.get("2")); 
         assertEquals(null, map.get("3")); 
         assertEquals("3", map.get("3")); 
     }
//@Test
//public void testToObject_object1451() {
//         final Object[] b = null;
//         assertEquals(null, ArrayUtils.toMap(b));
//
//         assertSame(null, ArrayUtils.toMap(new Object[0]));
//
//         assertTrue(Arrays.equals(
//             new HashMap<Object, Object>(),
//             ArrayUtils.toMap(new Object[] {Boolean.TRUE, Boolean.FALSE}))
//         );
//         assertTrue(Arrays.equals(
//             new HashMap<Object, Object>(),
//             ArrayUtils.toMap(new Object[] {Boolean.TRUE, null, Boolean.FALSE}))
//         );
//         assertTrue(Arrays.equals(
//             new HashMap<Object, Object>(),
//             ArrayUtils.toMap(new Object[] {Boolean.TRUE, null, Boolean.FALSE}))
//         );
//     }
@Test
public void testIndexOfWithStartIndex1685() { 
         final Object[] array = new Object[] { "0", "1", "2", "3", null, "0" }; 
         assertEquals(-1, ArrayUtils.indexOf(null, null, 2)); 
         assertEquals(-1, ArrayUtils.indexOf(null, "0", 2)); 
         assertEquals(0, ArrayUtils.indexOf(array, "0", 2)); 
         assertEquals(1, ArrayUtils.indexOf(array, "1", 2)); 
         assertEquals(2, ArrayUtils.indexOf(array, "2", 2)); 
         assertEquals(-1, ArrayUtils.indexOf(array, "3", 2)); 
         assertEquals(-1, ArrayUtils.indexOf(array, "3", -1)); 
         assertEquals(4, ArrayUtils.indexOf(array, null, 5)); 
         assertEquals(-1, ArrayUtils.indexOf(array, null, 2)); 
         assertEquals(-1, ArrayUtils.indexOf(array, "notInArray", 5)); 
          
         assertEquals(-1, ArrayUtils.indexOf(array, null, -1)); 
         assertEquals(5, ArrayUtils.indexOf(array, "0", 88)); 
     }
@Test
public void testIndexOfWithStartIndex1686() { 
         final Object[] array = new Object[] { "0", "1", "2", "3", null, "0" }; 
         assertEquals(-1, ArrayUtils.indexOf(null, null, 2)); 
         assertEquals(-1, ArrayUtils.indexOf(null, "0", 2)); 
         assertEquals(0, ArrayUtils.indexOf(array, "0", 2)); 
         assertEquals(1, ArrayUtils.indexOf(array, "1", 2)); 
         assertEquals(2, ArrayUtils.indexOf(array, "2", 2)); 
         assertEquals(-1, ArrayUtils.indexOf(array, "3", 2)); 
         assertEquals(-1, ArrayUtils.indexOf(array, "3", -1)); 
         assertEquals(4, ArrayUtils.indexOf(array, null, 5)); 
         assertEquals(-1, ArrayUtils.indexOf(array, null, 2)); 
         assertEquals(-1, ArrayUtils.indexOf(array, "notInArray", 5)); 
          
         assertEquals(-1, ArrayUtils.indexOf(null, null, -1)); 
         assertEquals(-1, ArrayUtils.indexOf(array, "0", 88)); 
     }
@Test
public void testIndexOfWithStartIndex1687() { 
         final Object[] array = new Object[] { "0", "1", "2", "3", null, "0" }; 
         assertEquals(-1, ArrayUtils.indexOf(null, null, 2)); 
         assertEquals(-1, ArrayUtils.indexOf(null, "0", 2)); 
         assertEquals(0, ArrayUtils.indexOf(array, "0", 2)); 
         assertEquals(1, ArrayUtils.indexOf(array, "1", 2)); 
         assertEquals(2, ArrayUtils.indexOf(array, "2", 2)); 
         assertEquals(-1, ArrayUtils.indexOf(array, "3", 2)); 
         assertEquals(-1, ArrayUtils.indexOf(array, "3", -1)); 
         assertEquals(4, ArrayUtils.indexOf(array, null, 5)); 
         assertEquals(-1, ArrayUtils.indexOf(array, null, 2)); 
         assertEquals(-1, ArrayUtils.indexOf(array, "notInArray", 5)); 
          
         assertEquals(-1, ArrayUtils.indexOf(array, null, -1)); 
         assertEquals(5, ArrayUtils.indexOf(array, "0", 88)); 
     }
@Test
public void testIndexOfWithStartIndex1688() { 
         final Object[] array = new Object[] { "0", "1", "2", "3", null, "0" }; 
         assertEquals(-1, ArrayUtils.indexOf(null, null, 2)); 
         assertEquals(-1, ArrayUtils.indexOf(null, "0", 2)); 
         assertEquals(0, ArrayUtils.indexOf(array, "0", 2)); 
         assertEquals(1, ArrayUtils.indexOf(array, "1", 2)); 
         assertEquals(2, ArrayUtils.indexOf(array, "2", 2)); 
         assertEquals(-1, ArrayUtils.indexOf(array, "3", 2)); 
         assertEquals(-1, ArrayUtils.indexOf(array, "3", -1)); 
         assertEquals(4, ArrayUtils.indexOf(array, null, 5)); 
         assertEquals(-1, ArrayUtils.indexOf(array, null, 2)); 
         assertEquals(-1, ArrayUtils.indexOf(array, "notInArray", 5)); 
          
         assertEquals(-1, ArrayUtils.indexOf(array, null, -1)); 
         assertEquals(-1, ArrayUtils.indexOf(array, "0", 88)); 
     }
@Test
@SuppressWarnings("cast") 
     public void testRemoveElementBooleanArray1689() { 
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
public void testIndexOfWithStartIndex1690() { 
         final Object[] array = new Object[] { "0", "1", "2", "3", null, "0" }; 
         assertEquals(-1, ArrayUtils.indexOf(null, null, 2)); 
         assertEquals(-1, ArrayUtils.indexOf(null, "0", 2)); 
         assertEquals(0, ArrayUtils.indexOf(array, "0", 2)); 
         assertEquals(1, ArrayUtils.indexOf(array, "1", 2)); 
         assertEquals(2, ArrayUtils.indexOf(array, "2", 2)); 
         assertEquals(-1, ArrayUtils.indexOf(array, "3", 2)); 
         assertEquals(-1, ArrayUtils.indexOf(array, "3", -1)); 
         assertEquals(4, ArrayUtils.indexOf(array, null, 5)); 
         assertEquals(-1, ArrayUtils.indexOf(array, null, 2)); 
         assertEquals(-1, ArrayUtils.indexOf(array, "notInArray", 5)); 
          
         assertEquals(-1, ArrayUtils.indexOf(array, null, -1)); 
         assertEquals(5, ArrayUtils.indexOf(array, "0", 88)); 
     }
@Test
public void testIndexOfWithStartIndex1691() { 
         final Object[] array = new Object[] { "0", "1", "2", "3", null, "0" }; 
         assertEquals(-1, ArrayUtils.indexOf(null, null, 2)); 
         assertEquals(-1, ArrayUtils.indexOf(null, "0", 2)); 
         assertEquals(0, ArrayUtils.indexOf(array, "0", 2)); 
         assertEquals(1, ArrayUtils.indexOf(array, "1", 2)); 
         assertEquals(2, ArrayUtils.indexOf(array, "2", 2)); 
         assertEquals(-1, ArrayUtils.indexOf(array, "3", 2)); 
         assertEquals(-1, ArrayUtils.indexOf(array, "3", -1)); 
         assertEquals(4, ArrayUtils.indexOf(array, null, 5)); 
         assertEquals(-1, ArrayUtils.indexOf(array, null, 2)); 
         assertEquals(-1, ArrayUtils.indexOf(array, "notInArray", 5)); 
          
         assertEquals(-1, ArrayUtils.indexOf(array, null, -1)); 
         assertEquals(-1, ArrayUtils.indexOf(array, "0", 88)); 
     }
@Test
public void testIndexOfWithStartIndex1692() { 
         final Object[] array = new Object[] { "0", "1", "2", "3", null, "0" }; 
         assertEquals(-1, ArrayUtils.indexOf(null, null, 2)); 
         assertEquals(-1, ArrayUtils.indexOf(null, "0", 2)); 
         assertEquals(0, ArrayUtils.indexOf(array, "0", 2)); 
         assertEquals(1, ArrayUtils.indexOf(array, "1", 2)); 
         assertEquals(2, ArrayUtils.indexOf(array, "2", 2)); 
         assertEquals(-1, ArrayUtils.indexOf(array, "3", 2)); 
         assertEquals(-1, ArrayUtils.indexOf(array, "3", -1)); 
         assertEquals(4, ArrayUtils.indexOf(array, null, 5)); 
         assertEquals(-1, ArrayUtils.indexOf(array, null, 2)); 
         assertEquals(-1, ArrayUtils.indexOf(array, "notInArray", 5)); 
          
         assertEquals(-1, ArrayUtils.indexOf(array, null, -1)); 
         assertEquals(-1, ArrayUtils.indexOf(array, "0", 88)); 
     }
@Test
public void testIndexOfWithStartIndex1693() { 
         final Object[] array = new Object[] { "0", "1", "2", "3", null, "0" }; 
         assertEquals(-1, ArrayUtils.indexOf(null, null, 2)); 
         assertEquals(-1, ArrayUtils.indexOf(null, "0", 2)); 
         assertEquals(0, ArrayUtils.indexOf(array, "0", 2)); 
         assertEquals(1, ArrayUtils.indexOf(array, "1", 2)); 
         assertEquals(2, ArrayUtils.indexOf(array, "2", 2)); 
         assertEquals(-1, ArrayUtils.indexOf(array, "3", 2)); 
         assertEquals(-1, ArrayUtils.indexOf(array, "3", -1)); 
         assertEquals(4, ArrayUtils.indexOf(array, null, 5)); 
         assertEquals(-1, ArrayUtils.indexOf(array, null, 2)); 
         assertEquals(-1, ArrayUtils.indexOf(array, "notInArray", 5)); 
          
         assertEquals(-1, ArrayUtils.indexOf(array, null, -1)); 
         assertEquals(-1, ArrayUtils.indexOf(array, "0", 88)); 
     }
@Test
public void testIndexOfWithStartIndex1694() { 
         final Object[] array = new Object[] { "0", "1", "2", "3", null, "0" }; 
         assertEquals(-1, ArrayUtils.indexOf(null, null, 2)); 
         assertEquals(-1, ArrayUtils.indexOf(null, "0", 2)); 
         assertEquals(0, ArrayUtils.indexOf(array, "0", 2)); 
         assertEquals(1, ArrayUtils.indexOf(array, "1", 2)); 
         assertEquals(2, ArrayUtils.indexOf(array, "2", 2)); 
         assertEquals(-1, ArrayUtils.indexOf(array, "3", 2)); 
         assertEquals(-1, ArrayUtils.indexOf(array, "3", -1)); 
         assertEquals(4, ArrayUtils.indexOf(array, null, 5)); 
         assertEquals(-1, ArrayUtils.indexOf(array, null, 2)); 
         assertEquals(-1, ArrayUtils.indexOf(array, "notInArray", 5)); 
          
         assertEquals(-1, ArrayUtils.indexOf(array, null, -1)); 
         assertEquals(-1, ArrayUtils.indexOf(array, "0", 88)); 
     }
@Test
public void testIndexOfWithStartIndex1695() { 
         final Object[] array = new Object[] { "0", "1", "2", "3", null, "0" }; 
         assertEquals(-1, ArrayUtils.indexOf(null, null, 2)); 
         assertEquals(-1, ArrayUtils.indexOf(null, "0", 2)); 
         assertEquals(0, ArrayUtils.indexOf(array, "0", 2)); 
         assertEquals(1, ArrayUtils.indexOf(array, "1", 2)); 
         assertEquals(2, ArrayUtils.indexOf(array, "2", 2)); 
         assertEquals(-1, ArrayUtils.indexOf(array, "3", 2)); 
         assertEquals(-1, ArrayUtils.indexOf(array, "3", -1)); 
         assertEquals(4, ArrayUtils.indexOf(array, null, 5)); 
         assertEquals(-1, ArrayUtils.indexOf(array, null, 2)); 
         assertEquals(-1, ArrayUtils.indexOf(array, "notInArray", 5)); 
          
         assertEquals(-1, ArrayUtils.indexOf(array, null, -1)); 
         assertEquals(-1, ArrayUtils.indexOf(array, "0", 88)); 
     }
@Test
public void testIndexOfWithStartIndex1696() { 
         final Object[] array = new Object[] { "0", "1", "2", "3", null, "0" }; 
         assertEquals(-1, ArrayUtils.indexOf(null, null, 2)); 
         assertEquals(-1, ArrayUtils.indexOf(null, "0", 2)); 
         assertEquals(0, ArrayUtils.indexOf(array, "0", 2)); 
         assertEquals(1, ArrayUtils.indexOf(array, "1", 2)); 
         assertEquals(2, ArrayUtils.indexOf(array, "2", 2)); 
         assertEquals(-1, ArrayUtils.indexOf(array, "3", 2)); 
         assertEquals(-1, ArrayUtils.indexOf(array, "3", -1)); 
         assertEquals(4, ArrayUtils.indexOf(array, null, 5)); 
         assertEquals(-1, ArrayUtils.indexOf(array, null, 2)); 
         assertEquals(-1, ArrayUtils.indexOf(array, "notInArray", 5)); 
          
         assertEquals(-1, ArrayUtils.indexOf(array, null, -1)); 
         assertEquals(5, ArrayUtils.indexOf(array, "0", 88)); 
     }
@Test
public void testIndexOfWithStartIndex1697() { 
         final Object[] array = new Object[] { "0", "1", "2", "3", null, "0" }; 
         assertEquals(-1, ArrayUtils.indexOf(null, null, 2)); 
         assertEquals(-1, ArrayUtils.indexOf(null, "0", 2)); 
         assertEquals(0, ArrayUtils.indexOf(array, "0", 2)); 
         assertEquals(1, ArrayUtils.indexOf(array, "1", 2)); 
         assertEquals(2, ArrayUtils.indexOf(array, "2", 2)); 
         assertEquals(-1, ArrayUtils.indexOf(array, "3", 2)); 
         assertEquals(-1, ArrayUtils.indexOf(array, "3", -1)); 
         assertEquals(4, ArrayUtils.indexOf(array, null, 5)); 
         assertEquals(-1, ArrayUtils.indexOf(array, null, 2)); 
         assertEquals(-1, ArrayUtils.indexOf(array, "notInArray", 5)); 
          
         assertEquals(-1, ArrayUtils.indexOf(array, null, -1)); 
         assertEquals(-1, ArrayUtils.indexOf(array, "0", 88)); 
     }
@Test
@SuppressWarnings("cast") 
     public void testRemoveElementBooleanArray1698() { 
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
public void testLastIndexOfBooleanWithStartIndex3019() { 
         boolean[] array = null; 
         assertEquals(-1, ArrayUtils.lastIndexOf(array, true, 2)); 
         array = new boolean[0]; 
         assertEquals(-1, ArrayUtils.lastIndexOf(array, true, 2)); 
         array = new boolean[] { true, false, true }; 
         assertEquals(0, ArrayUtils.lastIndexOf(array, false, 2)); 
         assertEquals(1, ArrayUtils.lastIndexOf(array, true, -1)); 
         assertEquals(2, ArrayUtils.lastIndexOf(array, false, 2)); 
         assertEquals(-1, ArrayUtils.lastIndexOf(array, false, -1)); 
         assertEquals(-1, ArrayUtils.lastIndexOf(array, true, 88)); 
     }
@Test
public void testLastIndexOfBooleanWithStartIndex3020() { 
         boolean[] array = null; 
         assertEquals(-1, ArrayUtils.lastIndexOf(array, true, 2)); 
         array = new boolean[0]; 
         assertEquals(-1, ArrayUtils.lastIndexOf(array, true, 2)); 
         array = new boolean[] { true, false, true }; 
         assertEquals(0, ArrayUtils.lastIndexOf(array, false, 2)); 
         array = new boolean[] { true, true, false }; 
         assertEquals(1, ArrayUtils.lastIndexOf(array, true, 2)); 
         assertEquals(2, ArrayUtils.lastIndexOf(array, false, -1)); 
         assertEquals(-1, ArrayUtils.lastIndexOf(array, false, 88)); 
     }
@Test
public void testLastIndexOfBooleanWithStartIndex3021() { 
         boolean[] array = null; 
         assertEquals(-1, ArrayUtils.lastIndexOf(array, true, 2)); 
         array = new boolean[0]; 
         assertEquals(-1, ArrayUtils.lastIndexOf(array, true, 2)); 
         array = new boolean[] { true, false, true }; 
         assertEquals(0, ArrayUtils.lastIndexOf(array, false, 2)); 
         array = new boolean[] { true, true, false }; 
         assertEquals(1, ArrayUtils.lastIndexOf(array, true, 2)); 
         assertEquals(2, ArrayUtils.lastIndexOf(array, false, -1)); 
         assertEquals(-1, ArrayUtils.lastIndexOf(array, false, 2)); 
         assertEquals(-1, ArrayUtils.lastIndexOf(array, false, -1)); 
         assertEquals(-1, ArrayUtils.lastIndexOf(array, true, 88)); 
     }
@Test
public void testLastIndexOfBooleanWithStartIndex3022() { 
         boolean[] array = null; 
         assertEquals(-1, ArrayUtils.lastIndexOf(array, true, 2)); 
         array = new boolean[] { true, true, false, true }; 
         assertEquals(0, ArrayUtils.lastIndexOf(array, true, 2)); 
         assertEquals(1, ArrayUtils.lastIndexOf(array, false, 2)); 
         array = new boolean[] { true, true, false, true }; 
         assertEquals(4, ArrayUtils.lastIndexOf(array, true, 2)); 
         assertEquals(2, ArrayUtils.lastIndexOf(array, false, 2)); 
         assertEquals(-1, ArrayUtils.lastIndexOf(array, false, -1)); 
         assertEquals(-1, ArrayUtils.lastIndexOf(array, false, -1)); 
     }
@Test
public void testLastIndexOfBooleanWithStartIndex3023() { 
         boolean[] array = null; 
         assertEquals(-1, ArrayUtils.lastIndexOf(array, true, 2)); 
         array = new boolean[0]; 
         assertEquals(-1, ArrayUtils.lastIndexOf(array, true, 2)); 
         array = new boolean[] { true, false, true }; 
         assertEquals(0, ArrayUtils.lastIndexOf(array, false, 2)); 
         array = new boolean[] { true, true, false }; 
         assertEquals(1, ArrayUtils.lastIndexOf(array, true, 2)); 
         assertEquals(2, ArrayUtils.lastIndexOf(array, false, -1)); 
         assertEquals(-1, ArrayUtils.lastIndexOf(array, false, 88)); 
     }
@Test
public void testLastIndexOfBooleanWithStartIndex3024() { 
         boolean[] array = null; 
         assertEquals(-1, ArrayUtils.lastIndexOf(array, true, 2)); 
         array = new boolean[] { true, true, false, true }; 
         assertEquals(0, ArrayUtils.lastIndexOf(array, true, 2)); 
         assertEquals(1, ArrayUtils.lastIndexOf(array, false, 1)); 
         array = new boolean[] { true, true, false, true }; 
         assertEquals(2, ArrayUtils.lastIndexOf(array, true, 2)); 
         assertEquals(-1, ArrayUtils.lastIndexOf(array, false, -1)); 
         assertEquals(-1, ArrayUtils.lastIndexOf(array, false, 88)); 
     }
@Test
public void testLastIndexOfBooleanWithStartIndex3025() { 
         boolean[] array = null; 
         assertEquals(-1, ArrayUtils.lastIndexOf(array, true, 2)); 
         array = new boolean[] { true, true, false, true }; 
         assertEquals(0, ArrayUtils.lastIndexOf(array, true, 2)); 
         assertEquals(1, ArrayUtils.lastIndexOf(array, false, 2)); 
         array = new boolean[] { true, true, false, true }; 
         assertEquals(4, ArrayUtils.lastIndexOf(array, true, 2)); 
         assertEquals(2, ArrayUtils.lastIndexOf(array, false, 2)); 
         assertEquals(-1, ArrayUtils.lastIndexOf(array, false, -1)); 
         assertEquals(-1, ArrayUtils.lastIndexOf(array, false, -1)); 
     }
@Test
public void testLastIndexOfBooleanWithStartIndex3026() { 
         boolean[] array = null; 
         assertEquals(-1, ArrayUtils.lastIndexOf(array, true, 2)); 
         array = new boolean[] { true, true, false, true }; 
         assertEquals(0, ArrayUtils.lastIndexOf(array, true, 2)); 
         assertEquals(1, ArrayUtils.lastIndexOf(array, false, 1)); 
         array = new boolean[] { true, true, false, true }; 
         assertEquals(4, ArrayUtils.lastIndexOf(array, true, 2)); 
         assertEquals(-1, ArrayUtils.lastIndexOf(array, false, -1)); 
         assertEquals(-1, ArrayUtils.lastIndexOf(array, false, 88)); 
     }
@Test
public void testLastIndexOfBooleanWithStartIndex3027() { 
         boolean[] array = null; 
         assertEquals(-1, ArrayUtils.lastIndexOf(array, true, 2)); 
         array = new boolean[] { true, true, false, true }; 
         assertEquals(0, ArrayUtils.lastIndexOf(array, true, 2)); 
         assertEquals(1, ArrayUtils.lastIndexOf(array, false, 1)); 
         array = new boolean[] { true, true, false, true }; 
         assertEquals(4, ArrayUtils.lastIndexOf(array, true, 2)); 
         assertEquals(-1, ArrayUtils.lastIndexOf(array, false, -1)); 
         assertEquals(-1, ArrayUtils.lastIndexOf(array, false, 88)); 
     }
@Test
public void testLastIndexOfBooleanWithStartIndex3028() { 
         boolean[] array = null; 
         assertEquals(-1, ArrayUtils.lastIndexOf(array, true, 2)); 
         array = new boolean[] { true, true, false, true }; 
         assertEquals(0, ArrayUtils.lastIndexOf(array, true, 2)); 
         assertEquals(1, ArrayUtils.lastIndexOf(array, false, 1)); 
         array = new boolean[] { true, true, false, true }; 
         assertEquals(2, ArrayUtils.lastIndexOf(array, true, 2)); 
         assertEquals(-1, ArrayUtils.lastIndexOf(array, false, -1)); 
         assertEquals(-1, ArrayUtils.lastIndexOf(array, false, 88)); 
     }
@Test
public void testLastIndexOfBooleanWithStartIndex3029() { 
         boolean[] array = null; 
         assertEquals(-1, ArrayUtils.lastIndexOf(array, true, 2)); 
         array = new boolean[] { true, true, false, true }; 
         assertEquals(0, ArrayUtils.lastIndexOf(array, true, 2)); 
         assertEquals(1, ArrayUtils.lastIndexOf(array, false, 1)); 
         array = new boolean[] { true, true, false, true }; 
         assertEquals(4, ArrayUtils.lastIndexOf(array, true, 2)); 
         assertEquals(-1, ArrayUtils.lastIndexOf(array, false, -1)); 
         assertEquals(-1, ArrayUtils.lastIndexOf(array, false, 88)); 
     }
    
    
    //-----------------------------------------------------------------------
    

    //-----------------------------------------------------------------------
    

    //-----------------------------------------------------------------------
    private void assertIsEquals(final Object array1, final Object array2, final Object array3) {
        assertTrue(ArrayUtils.isEquals(array1, array1));
        assertTrue(ArrayUtils.isEquals(array2, array2));
        assertTrue(ArrayUtils.isEquals(array3, array3));
        assertFalse(ArrayUtils.isEquals(array1, array2));
        assertFalse(ArrayUtils.isEquals(array2, array1));
        assertFalse(ArrayUtils.isEquals(array1, array3));
        assertFalse(ArrayUtils.isEquals(array3, array1));
        assertFalse(ArrayUtils.isEquals(array1, array2));
        assertFalse(ArrayUtils.isEquals(array2, array1));
    }

    
    
    //-----------------------------------------------------------------------
    /**
     * Tests generic array creation with parameters of same type.
     */
    

    /**
     * Tests generic array creation with general return type.
     */
    

    /**
     * Tests generic array creation with parameters of common base type.
     */
    

    /**
     * Tests generic array creation with generic type.
     */
    

    /**
     * Tests generic empty array creation with generic type.
     */
    

    /**
     * Tests indirect generic empty array creation with generic type.
     */
    

    private static <T> T[] toArrayPropagatingType(final T... items)
    {
        return ArrayUtils.toArray(items);
    }
    
    //-----------------------------------------------------------------------
    

    //-----------------------------------------------------------------------
    

    
    
    
    
    
    
    
    
    
    
    
    
    
    
    

    //-----------------------------------------------------------------------

    
    
    
    
    
    
    
    
    
    
    
    
    
    
    

    

    

    
    
    
    
    
    
    
    
    
    
    
    
    
    
    

    //-----------------------------------------------------------------------

    

    

    

    

    

    

    

    

    
    
    //-----------------------------------------------------------------------
    

    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    //-----------------------------------------------------------------------
    
    
    //-----------------------------------------------------------------------
    

    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    //-----------------------------------------------------------------------
    

    

    

    

    
    
    //-----------------------------------------------------------------------
    

    

    

    

    
    
    //-----------------------------------------------------------------------
    

    

    

    

    
    
    //-----------------------------------------------------------------------
    

    

    

    

    
    
    //-----------------------------------------------------------------------
    

    

    

    

    
    
    //-----------------------------------------------------------------------
    

    

    

    

    
    
    //-----------------------------------------------------------------------
    

    

    
    
    

    

    

    

    

    

    
    
    //-----------------------------------------------------------------------
    

    

    

    

    
    
    //-----------------------------------------------------------------------
    

    

    

    

    
    
    // testToPrimitive/Object for boolean
    //  -----------------------------------------------------------------------
    

    

    

    // testToPrimitive/Object for byte
    //  -----------------------------------------------------------------------
    

    

    
    
    // testToPrimitive/Object for byte
    //  -----------------------------------------------------------------------
    

    

    

    // testToPrimitive/Object for short
    //  -----------------------------------------------------------------------
    

    

    

    //  testToPrimitive/Object for int
    //  -----------------------------------------------------------------------
     

     
     
    

    

    //  testToPrimitive/Object for long
    //  -----------------------------------------------------------------------
     

     
     
    

    //  testToPrimitive/Object for float
    //  -----------------------------------------------------------------------
     

     
     
    

    //  testToPrimitive/Object for double
    //  -----------------------------------------------------------------------
     

     
     
    

    //-----------------------------------------------------------------------
    /**
     * Test for {@link ArrayUtils#isEmpty(java.lang.Object[])}.
     */
    

    /**
     * Tests for {@link ArrayUtils#isEmpty(long[])},
     * {@link ArrayUtils#isEmpty(int[])},
     * {@link ArrayUtils#isEmpty(short[])},
     * {@link ArrayUtils#isEmpty(char[])},
     * {@link ArrayUtils#isEmpty(byte[])},
     * {@link ArrayUtils#isEmpty(double[])},
     * {@link ArrayUtils#isEmpty(float[])} and
     * {@link ArrayUtils#isEmpty(boolean[])}.
     */
    
    
   /**
     * Test for {@link ArrayUtils#isNotEmpty(java.lang.Object[])}.
     */
    

   /**
     * Tests for {@link ArrayUtils#isNotEmpty(long[])},
     * {@link ArrayUtils#isNotEmpty(int[])},
     * {@link ArrayUtils#isNotEmpty(short[])},
     * {@link ArrayUtils#isNotEmpty(char[])},
     * {@link ArrayUtils#isNotEmpty(byte[])},
     * {@link ArrayUtils#isNotEmpty(double[])},
     * {@link ArrayUtils#isNotEmpty(float[])} and
     * {@link ArrayUtils#isNotEmpty(boolean[])}.
     */
    
    // ------------------------------------------------------------------------
    

}
