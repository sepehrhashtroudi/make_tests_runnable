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
 * @see MutableByte
 */
public class MutableByteTest {

    // ----------------------------------------------------------------
@Test
public void testDecrement188() { 
     final MutableByte mutNum = new MutableByte((byte) 1); 
     mutNum.decrement(); 
     assertEquals(0, mutNum.intValue()); 
     assertEquals(0L, mutNum.longValue()); 
 }
@Test
public void testAddValuePrimitive189() { 
     final MutableByte mutNum = new MutableByte((byte) 1); 
     mutNum.add((byte) 1); 
     assertEquals((byte) 2, mutNum.byteValue()); 
 }
@Test
public void testPrimitiveValues190() { 
     final MutableByte mutNum = new MutableByte((byte) 1); 
     assertEquals(1.0F, mutNum.floatValue(), 0); 
     assertEquals(1.0, mutNum.doubleValue(), 0); 
     assertEquals((byte) 1, mutNum.byteValue()); 
     assertEquals((short) 1, mutNum.shortValue()); 
     assertEquals(1, mutNum.intValue()); 
     assertEquals(1L, mutNum.longValue()); 
 }
@Test
public void testIncrement191() { 
     final MutableByte mutNum = new MutableByte((byte) 1); 
     mutNum.increment(); 
     assertEquals(2, mutNum.intValue()); 
     assertEquals(2L, mutNum.longValue()); 
 }
    

    

    

    

    

    

    

    

    

    

    

    

    

    

    

    

    

}
