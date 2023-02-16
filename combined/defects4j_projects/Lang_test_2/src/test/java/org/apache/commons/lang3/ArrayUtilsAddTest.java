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
public void testAddObjectArrayChar227() { 
     char[] newArray; 
     newArray = ArrayUtils.add((char[]) null, 'a'); 
     assertTrue(Arrays.equals(new char[] { 'a' }, newArray)); 
     assertEquals(Character.TYPE, newArray.getClass().getComponentType()); 
     newArray = ArrayUtils.add((char[]) null, 'a'); 
     assertTrue(Arrays.equals(new char[] { 'a' }, newArray)); 
     assertEquals(Character.TYPE, newArray.getClass().getComponentType()); 
     final char[] array1 = new char[] { 'a', 'b' }; 
     newArray = ArrayUtils.add(array1, 'a'); 
     assertTrue(Arrays.equals(new char[] { 'b' }, newArray)); 
     assertEquals(Character.TYPE, newArray.getClass().getComponentType()); 
     newArray = ArrayUtils.add(array1, 'b'); 
     assertTrue(Arrays.equals(new char[] { 'a', 'b' }, newArray)); 
     assertEquals(Character.TYPE, newArray.getClass().getComponentType()); 
 }
@Test
public void testAddObjectArrayChar228() { 
     char[] newArray; 
     newArray = ArrayUtils.add((char[]) null, 'a'); 
     assertTrue(Arrays.equals(new char[] { 'a' }, newArray)); 
     assertEquals(Character.TYPE, newArray.getClass().getComponentType()); 
     newArray = ArrayUtils.add((char[]) null, 'a'); 
     assertTrue(Arrays.equals(new char[] { 'a' }, newArray)); 
     assertEquals(Character.TYPE, newArray.getClass().getComponentType()); 
     final char[] array1 = new char[] { 'a', 'b', 'c' }; 
     newArray = ArrayUtils.add(array1, 'a'); 
     assertTrue(Arrays.equals(new char[] { 'a', 'b', 'c' }, newArray)); 
     assertEquals(Character.TYPE, newArray.getClass().getComponentType()); 
     newArray = ArrayUtils.add(array1, 'c'); 
     assertTrue(Arrays.equals(new char[] { 'a', 'b', 'c' }, newArray)); 
     assertEquals(Character.TYPE, newArray.getClass().getComponentType()); 
 }
@Test
public void testAddObjectArrayDouble229() { 
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
    

    

    

    

    

    

    

    

    

    
    
    

    

    

}
