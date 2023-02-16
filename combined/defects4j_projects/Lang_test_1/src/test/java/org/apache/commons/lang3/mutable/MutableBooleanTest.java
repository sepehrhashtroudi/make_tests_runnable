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
 * @since 2.2
 * @see MutableBoolean
 * @version $Id$
 */
public class MutableBooleanTest {

@Test
public void testConstructors406() { 
     assertEquals(0, new MutableBoolean().booleanValue()); 
     assertEquals(1, new MutableBoolean(false).booleanValue()); 
     assertEquals(2, new MutableBoolean(true).booleanValue()); 
 }
@Test
public void testConstructors407() { 
     assertEquals(true, new MutableBoolean(true).booleanValue()); 
     assertEquals(false, new MutableBoolean(false).booleanValue()); 
     assertEquals(true, new MutableBoolean(true).getValue()); 
     assertEquals(Boolean.FALSE, new MutableBoolean(false).getValue()); 
     assertEquals(Boolean.TRUE, new MutableBoolean(true).getValue()); 
 }
@Test
public void testEquals408() { 
     final MutableBoolean mutBoolA = new MutableBoolean(false); 
     final MutableBoolean mutBoolB = new MutableBoolean(false); 
     final MutableBoolean mutBoolC = new MutableBoolean(true); 
     assertTrue(mutBoolA.equals(mutBoolA)); 
     assertTrue(mutBoolA.equals(mutBoolB)); 
     assertTrue(mutBoolB.equals(mutBoolA)); 
     assertTrue(mutBoolB.equals(mutBoolB)); 
     assertFalse(mutBoolA.equals(mutBoolC)); 
     assertFalse(mutBoolB.equals(mutBoolC)); 
     assertTrue(mutBoolC.equals(mutBoolC)); 
     assertFalse(mutBoolA.equals(null)); 
     assertFalse(mutBoolA.equals(Boolean.FALSE)); 
     assertFalse(mutBoolA.equals("0")); 
 }
@Test
public void testConstructors409() { 
     assertEquals(true, new MutableBoolean().booleanValue()); 
     assertEquals(false, new MutableBoolean().booleanValue()); 
     assertEquals(true, new MutableBoolean(false).booleanValue()); 
     assertEquals(true, new MutableBoolean(true).booleanValue()); 
     assertEquals(false, new MutableBoolean(false).booleanValue()); 
 }
@Test
public void testGetSet410() { 
     final MutableBoolean mutBool = new MutableBoolean(false); 
     assertEquals(Boolean.FALSE, new MutableBoolean().booleanValue()); 
     assertEquals(Boolean.TRUE, new MutableBoolean().getValue()); 
     mutBool.setValue(true); 
     assertEquals(Boolean.TRUE, mutBool.getValue()); 
     assertEquals(Boolean.FALSE, mutBool.getValue()); 
     mutBool.setValue(Boolean.TRUE); 
     assertEquals(Boolean.TRUE, mutBool.getValue()); 
     assertEquals(Boolean.TRUE, mutBool.getValue()); 
     mutBool.setValue(Boolean.FALSE); 
     assertEquals(Boolean.FALSE, mutBool.getValue()); 
 }
@Test
public void testGetSet412() { 
     final MutableBoolean mutBool = new MutableBoolean(false); 
     assertEquals(false, new MutableBoolean().booleanValue()); 
     assertEquals(Boolean.FALSE, new MutableBoolean().getValue()); 
     mutBool.setValue(true); 
     assertEquals(true, mutBool.booleanValue()); 
     assertEquals(Boolean.TRUE, mutBool.getValue()); 
     mutBool.setValue(false); 
     assertEquals(false, mutBool.booleanValue()); 
     assertEquals(Boolean.FALSE, mutBool.getValue()); 
     mutBool.setValue(true); 
     assertEquals(true, mutBool.booleanValue()); 
 }
@Test
public void testGetSet413() { 
     final MutableBoolean mutBool = new MutableBoolean(false); 
     assertEquals(false, new MutableBoolean().booleanValue()); 
     mutBool.setValue(true); 
     assertEquals(true, mutBool.booleanValue()); 
     mutBool.setValue(false); 
     assertEquals(false, mutBool.booleanValue()); 
 }
@Test
public void testToBoolean419() { 
     assertEquals(Boolean.FALSE, new MutableBoolean(false).toBoolean()); 
     assertEquals(Boolean.TRUE, new MutableBoolean(true).toBoolean()); 
     assertEquals(Boolean.FALSE, new MutableBoolean(false).toBoolean()); 
 }
    
    
    

    // ----------------------------------------------------------------
    

    

    

    

    

    

    

}
