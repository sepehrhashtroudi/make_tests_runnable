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
public void testConstructors121() { 
     assertEquals((byte) 0, new MutableByte().byteValue()); 
     assertEquals((byte) 1, new MutableByte((byte) 1).byteValue()); 
     assertEquals((byte) 2, new MutableByte(Byte.valueOf((byte) 2)).byteValue()); 
     assertEquals((byte) 3, new MutableByte(new MutableByte((byte) 3)).byteValue()); 
     assertEquals((byte) 2, new MutableByte("2").byteValue()); 
 }
@Test
public void testGetSet122() { 
     final MutableByte mutNum = new MutableByte((byte) 0); 
     assertEquals((byte) 0, new MutableByte().byteValue()); 
     assertEquals(Byte.valueOf((byte) 0), new MutableByte().getValue()); 
     mutNum.setValue((byte) 1); 
     assertEquals((byte) 1, mutNum.byteValue()); 
     assertEquals(Byte.valueOf((byte) 1), mutNum.getValue()); 
     mutNum.setValue(Byte.valueOf((byte) 2)); 
     assertEquals((byte) 2, mutNum.byteValue()); 
     assertEquals(Byte.valueOf((byte) 2), mutNum.getValue()); 
     mutNum.setValue(new MutableByte((byte) 3)); 
     assertEquals((byte) 3, mutNum.byteValue()); 
     assertEquals(Byte.valueOf((byte) 3), mutNum.getValue()); 
     try { 
         mutNum.setValue(null); 
         fail(); 
     } catch (final NullPointerException ex) { 
     } 
 }
@Test
public void testGetSet123() { 
     final MutableByte mutNum = new MutableByte((byte) 0); 
     assertEquals((byte) 0, new MutableByte().byteValue()); 
     mutNum.setValue((byte) 1); 
     assertEquals((byte) 1, mutNum.byteValue()); 
     mutNum.setValue(Byte.valueOf((byte) 2)); 
     assertEquals((byte) 2, mutNum.byteValue()); 
     mutNum.setValue(new MutableByte((byte) 3)); 
     assertEquals((byte) 3, mutNum.byteValue()); 
     assertEquals(Byte.valueOf((byte) 3), mutNum.getValue()); 
 }
@Test
public void testGetSet124() { 
     final MutableByte mutNum = new MutableByte((byte) 0); 
     assertEquals((byte) 0, new MutableByte().byteValue()); 
     mutNum.setValue((byte) 1); 
     assertEquals((byte) 1, mutNum.byteValue()); 
     mutNum.setValue(Byte.valueOf((byte) 2)); 
     assertEquals((byte) 2, mutNum.byteValue()); 
     mutNum.setValue(new MutableByte((byte) 3)); 
     assertEquals((byte) 3, mutNum.byteValue()); 
     assertEquals(Byte.valueOf((byte) 3), mutNum.getValue()); 
     mutNum.setValue(new MutableByte((byte) 2)); 
     assertEquals((byte) 2, mutNum.byteValue()); 
     assertEquals((byte) 2, mutNum.byteValue()); 
     try { 
         mutNum.setValue(null); 
         fail(); 
     } catch (final NullPointerException ex) { 
     } 
 }
@Test
public void testIncrement125() { 
     final MutableByte mutNum = new MutableByte((byte) 1); 
     mutNum.increment(); 
     assertEquals(2, mutNum.intValue()); 
     assertEquals(2L, mutNum.longValue()); 
 }
@Test
public void testSubtractValueObject126() { 
     final MutableByte mutNum = new MutableByte((byte) 1); 
     mutNum.subtract(Integer.valueOf(1)); 
     assertEquals((byte) 0, mutNum.byteValue()); 
 }
@Test
public void testToString127() { 
     assertEquals("0", new MutableByte((byte) 0).toString()); 
     assertEquals("10", new MutableByte((byte) 10).toString()); 
     assertEquals("-123", new MutableByte((byte) -123).toString()); 
 }
@Test
public void testCompareTo128() { 
     final MutableByte mutNum = new MutableByte((byte) 0); 
     assertEquals((byte) 0, mutNum.compareTo(new MutableByte((byte) 0))); 
     assertEquals((byte) +1, mutNum.compareTo(new MutableByte((byte) -1))); 
     assertEquals((byte) -1, mutNum.compareTo(new MutableByte((byte) 1))); 
 }
    

    

    

    

    

    

    

    

    

    

    

    

    

    

    

    

    

}
