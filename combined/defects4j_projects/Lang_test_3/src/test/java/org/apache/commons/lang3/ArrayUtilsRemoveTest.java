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
public void testRemoveElementObjectArray311() { 
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
public void testRemoveElementBooleanArray312() { 
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
    

    

    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
