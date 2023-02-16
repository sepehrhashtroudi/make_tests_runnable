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
package org.apache.commons.lang3.mutable;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * JUnit tests.
 * 
 * @version $Id$
 * @see MutableShort
 */
public class MutableShortTest {

    // ----------------------------------------------------------------
@Test
public void testEquals469() { 
     final MutableShort mutNumA = new MutableShort((short) 0); 
     final MutableShort mutNumB = new MutableShort((short) 0); 
     final MutableShort mutNumC = new MutableShort((short) 1); 
     assertTrue(mutNumA.equals(mutNumA)); 
     assertTrue(mutNumA.equals(mutNumB)); 
     assertTrue(mutNumB.equals(mutNumA)); 
     assertTrue(mutNumB.equals(mutNumB)); 
     assertFalse(mutNumA.equals(mutNumC)); 
     assertFalse(mutNumB.equals(mutNumC)); 
     assertTrue(mutNumC.equals(mutNumC)); 
     assertFalse(mutNumA.equals(null)); 
     assertFalse(mutNumA.equals(Short.valueOf((short) 0))); 
     assertFalse(mutNumA.equals("0")); 
 }
@Test
public void testGetSet470() { 
     final MutableShort mutNum = new MutableShort((short) 0); 
     assertEquals((short) 0, new MutableShort().shortValue()); 
     assertEquals(Short.valueOf((short) 0), new MutableShort().getValue()); 
     mutNum.setValue((short) 1); 
     assertEquals((short) 1, mutNum.shortValue()); 
     assertEquals(Short.valueOf((short) 1), mutNum.getValue()); 
     mutNum.setValue(Short.valueOf((short) 2)); 
     assertEquals((short) 2, mutNum.shortValue()); 
     assertEquals(Short.valueOf((short) 2), mutNum.getValue()); 
     mutNum.setValue(new MutableShort((short) 3)); 
     assertEquals((short) 3, mutNum.shortValue()); 
     assertEquals(Short.valueOf((short) 3), mutNum.getValue()); 
     try { 
         mutNum.setValue(null); 
         fail(); 
     } catch (final NullPointerException ex) { 
     } 
 }
@Test
public void testAddValuePrimitive472() { 
     final MutableShort mutNum = new MutableShort((short) 1); 
     mutNum.add((short) 1); 
     assertEquals((short) 2, mutNum.shortValue()); 
 }
@Test
public void testAddValueObject473() { 
     final MutableShort mutNum = new MutableShort((short) 1); 
     mutNum.add(Short.valueOf((short) 1)); 
     assertEquals((short) 2, mutNum.shortValue()); 
 }
@Test
public void testDecrement474() { 
     final MutableShort mutNum = new MutableShort((short) 1); 
     mutNum.decrement(); 
     assertEquals(0, mutNum.intValue()); 
     assertEquals(0L, mutNum.longValue()); 
 }
@Test
public void testIncrement475() { 
     final MutableShort mutNum = new MutableShort((short) 1); 
     mutNum.increment(); 
     assertEquals(2, mutNum.intValue()); 
     assertEquals(2L, mutNum.longValue()); 
 }
@Test
public void testPrimitiveValues476() { 
     final MutableShort mutNum = new MutableShort((short) 1); 
     assertEquals(1.0F, mutNum.floatValue(), 0); 
     assertEquals(1.0, mutNum.doubleValue(), 0); 
     assertEquals((short) 1, mutNum.shortValue()); 
     assertEquals(1L, mutNum.longValue()); 
 }
    

    

    

    

    

    

    

    

    

    

    

    

    

    

}
