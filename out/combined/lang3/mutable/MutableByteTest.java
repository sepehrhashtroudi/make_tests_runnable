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
public void testConstructors182() { 
     assertEquals((byte) 0, new MutableByte().byteValue()); 
     assertEquals((byte) 1, new MutableByte((byte) 1).byteValue()); 
     assertEquals((byte) 2, new MutableByte(Byte.valueOf((byte) 2)).byteValue()); 
     assertEquals((byte) 3, new MutableByte(new MutableByte((byte) 3)).byteValue()); 
     assertEquals((byte) 2, new MutableByte("2").byteValue()); 
 }
@Test
public void testDecrement430() { 
     final MutableByte mutNum = new MutableByte((byte) 1); 
     mutNum.decrement(); 
     assertEquals(0, mutNum.intValue()); 
     assertEquals(0L, mutNum.longValue()); 
 }
@Test
public void testGetSet599() { 
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
 }
@Test
public void testConstructors930() { 
     assertEquals((byte) 0, new MutableByte().byteValue()); 
     assertEquals((byte) 1, new MutableByte((byte) 1).byteValue()); 
     assertEquals((byte) 2, new MutableByte(Byte.valueOf((byte) 2)).byteValue()); 
     assertEquals((byte) 3, new MutableByte(new MutableByte((byte) 3)).byteValue()); 
     assertEquals((byte) 2, new MutableByte("2").byteValue()); 
 }
@Test
public void testToByte960() { 
     assertEquals(Byte.valueOf((byte) 0), new MutableByte((byte) 0).toByte()); 
     assertEquals(Byte.valueOf((byte) 123), new MutableByte((byte) 123).toByte()); 
 }
@Test
public void testPrimitiveValues962() { 
     final MutableByte mutNum = new MutableByte((byte) 1); 
     assertEquals(1.0F, mutNum.floatValue(), 0); 
     assertEquals(1.0, mutNum.doubleValue(), 0); 
     assertEquals((byte) 1, mutNum.byteValue()); 
     assertEquals((short) 1, mutNum.shortValue()); 
     assertEquals(1, mutNum.intValue()); 
     assertEquals(1L, mutNum.longValue()); 
 }
@Test
public void testAddValuePrimitive967() { 
     final MutableByte mutNum = new MutableByte((byte) 1); 
     mutNum.add((byte) 1); 
     assertEquals((byte) 2, mutNum.byteValue()); 
 }
@Test
public void testPrimitiveValues1067() { 
     final MutableByte mutNum = new MutableByte((byte) 1); 
     assertEquals(1.0F, mutNum.floatValue(), 0); 
     assertEquals(1.0, mutNum.doubleValue(), 0); 
     assertEquals((byte) 1, mutNum.byteValue()); 
     assertEquals((short) 1, mutNum.shortValue()); 
     assertEquals(1, mutNum.intValue()); 
     assertEquals(1L, mutNum.longValue()); 
 }
@Test
public void testPrimitiveValues1071() { 
     final MutableByte mutNum = new MutableByte((byte) 1); 
     assertEquals(1.0F, mutNum.floatValue(), 0); 
     assertEquals(1.0, mutNum.doubleValue(), 0); 
     assertEquals((byte) 1, mutNum.byteValue()); 
     assertEquals((short) 1, mutNum.shortValue()); 
     assertEquals(1, mutNum.intValue()); 
     assertEquals(1L, mutNum.longValue()); 
 }
@Test
public void testGetSet1104() { 
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
 }
@Test(expected = NullPointerException.class) 
 public void testSetNull1116() { 
     final MutableByte mutNum = new MutableByte((byte) 0); 
     mutNum.setValue(null); 
 }
@Test
public void testAddValueObject1475() { 
     final MutableByte mutNum = new MutableByte((byte) 1); 
     mutNum.add(Integer.valueOf(1)); 
     assertEquals((byte) 2, mutNum.byteValue()); 
 }
@Test
public void testPrimitiveValues1505() { 
     final MutableByte mutNum = new MutableByte((byte) 1); 
     assertEquals(1.0F, mutNum.floatValue(), 0); 
     assertEquals(1.0, mutNum.doubleValue(), 0); 
     assertEquals((byte) 1, mutNum.byteValue()); 
     assertEquals((short) 1, mutNum.shortValue()); 
     assertEquals(1, mutNum.intValue()); 
     assertEquals(1L, mutNum.longValue()); 
 }
@Test
public void testHashCode1622() { 
     final MutableByte mutNumA = new MutableByte((byte) 0); 
     final MutableByte mutNumB = new MutableByte((byte) 0); 
     final MutableByte mutNumC = new MutableByte((byte) 1); 
     assertTrue(mutNumA.hashCode() == mutNumA.hashCode()); 
     assertTrue(mutNumA.hashCode() == mutNumB.hashCode()); 
     assertFalse(mutNumA.hashCode() == mutNumC.hashCode()); 
     assertTrue(mutNumA.hashCode() == Byte.valueOf((byte) 0).hashCode()); 
 }
@Test
public void testIncrement1682() { 
     final MutableByte mutNum = new MutableByte((byte) 1); 
     mutNum.increment(); 
     assertEquals(2, mutNum.intValue()); 
     assertEquals(2L, mutNum.longValue()); 
 }
@Test
public void testPrimitiveValues1785() { 
     final MutableByte mutNum = new MutableByte((byte) 1); 
     assertEquals(1.0F, mutNum.floatValue(), 0); 
     assertEquals(1.0, mutNum.doubleValue(), 0); 
     assertEquals((byte) 1, mutNum.byteValue()); 
     assertEquals((short) 1, mutNum.shortValue()); 
     assertEquals(1, mutNum.intValue()); 
     assertEquals(1L, mutNum.longValue()); 
 }
@Test
public void testPrimitiveValues2136() { 
     final MutableByte mutNum = new MutableByte((byte) 1); 
     assertEquals(1.0F, mutNum.floatValue(), 0); 
     assertEquals(1.0, mutNum.doubleValue(), 0); 
     assertEquals((byte) 1, mutNum.byteValue()); 
     assertEquals((short) 1, mutNum.shortValue()); 
     assertEquals(1, mutNum.intValue()); 
     assertEquals(1L, mutNum.longValue()); 
 }
@Test
public void testConstructors2174() { 
     assertEquals((byte) 0, new MutableByte().byteValue()); 
     assertEquals((byte) 1, new MutableByte((byte) 1).byteValue()); 
     assertEquals((byte) 2, new MutableByte(Byte.valueOf((byte) 2)).byteValue()); 
     assertEquals((byte) 3, new MutableByte(new MutableByte((byte) 3)).byteValue()); 
     assertEquals((byte) 2, new MutableByte("2").byteValue()); 
 }
@Test
public void testGetSet2249() { 
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
 }
@Test
public void testPrimitiveValues2660() { 
     final MutableByte mutNum = new MutableByte((byte) 1); 
     assertEquals(1.0F, mutNum.floatValue(), 0); 
     assertEquals(1.0, mutNum.doubleValue(), 0); 
     assertEquals((byte) 1, mutNum.byteValue()); 
     assertEquals((short) 1, mutNum.shortValue()); 
     assertEquals(1, mutNum.intValue()); 
     assertEquals(1L, mutNum.longValue()); 
 }
@Test
public void testSubtractValuePrimitive2914() { 
     final MutableByte mutNum = new MutableByte((byte) 1); 
     mutNum.subtract((byte) 1); 
     assertEquals((byte) 0, mutNum.byteValue()); 
 }
@Test
public void testToString3159() { 
     assertEquals("0", new MutableByte((byte) 0).toString()); 
     assertEquals("10", new MutableByte((byte) 10).toString()); 
     assertEquals("-123", new MutableByte((byte) -123).toString()); 
 }
@Test
public void testConstructors3425() { 
     assertEquals((byte) 0, new MutableByte().byteValue()); 
     assertEquals((byte) 1, new MutableByte((byte) 1).byteValue()); 
     assertEquals((byte) 2, new MutableByte(Byte.valueOf((byte) 2)).byteValue()); 
     assertEquals((byte) 3, new MutableByte(new MutableByte((byte) 3)).byteValue()); 
     assertEquals((byte) 2, new MutableByte("2").byteValue()); 
 }
@Test
public void testConstructors3510() { 
     assertEquals((byte) 0, new MutableByte().byteValue()); 
     assertEquals((byte) 1, new MutableByte((byte) 1).byteValue()); 
     assertEquals((byte) 2, new MutableByte(Byte.valueOf((byte) 2)).byteValue()); 
     assertEquals((byte) 3, new MutableByte(new MutableByte((byte) 3)).byteValue()); 
     assertEquals((byte) 2, new MutableByte("2").byteValue()); 
 }
@Test
public void testPrimitiveValues3552() { 
     final MutableByte mutNum = new MutableByte((byte) 1); 
     assertEquals(1.0F, mutNum.floatValue(), 0); 
     assertEquals(1.0, mutNum.doubleValue(), 0); 
     assertEquals((byte) 1, mutNum.byteValue()); 
     assertEquals((short) 1, mutNum.shortValue()); 
     assertEquals(1, mutNum.intValue()); 
     assertEquals(1L, mutNum.longValue()); 
 }
@Test
public void testSubtractValuePrimitive3839() { 
     final MutableByte mutNum = new MutableByte((byte) 1); 
     mutNum.subtract((byte) 1); 
     assertEquals((byte) 0, mutNum.byteValue()); 
 }
@Test
public void testPrimitiveValues4072() { 
     final MutableByte mutNum = new MutableByte((byte) 1); 
     assertEquals(1.0F, mutNum.floatValue(), 0); 
     assertEquals(1.0, mutNum.doubleValue(), 0); 
     assertEquals((byte) 1, mutNum.byteValue()); 
     assertEquals((short) 1, mutNum.shortValue()); 
     assertEquals(1, mutNum.intValue()); 
     assertEquals(1L, mutNum.longValue()); 
 }
@Test
public void testPrimitiveValues4277() { 
     final MutableByte mutNum = new MutableByte((byte) 1); 
     assertEquals(1.0F, mutNum.floatValue(), 0); 
     assertEquals(1.0, mutNum.doubleValue(), 0); 
     assertEquals((byte) 1, mutNum.byteValue()); 
     assertEquals((short) 1, mutNum.shortValue()); 
     assertEquals(1, mutNum.intValue()); 
     assertEquals(1L, mutNum.longValue()); 
 }
@Test
public void testHashCode4487() { 
     final MutableByte mutNumA = new MutableByte((byte) 0); 
     final MutableByte mutNumB = new MutableByte((byte) 0); 
     final MutableByte mutNumC = new MutableByte((byte) 1); 
     assertTrue(mutNumA.hashCode() == mutNumA.hashCode()); 
     assertTrue(mutNumA.hashCode() == mutNumB.hashCode()); 
     assertFalse(mutNumA.hashCode() == mutNumC.hashCode()); 
     assertTrue(mutNumA.hashCode() == Byte.valueOf((byte) 0).hashCode()); 
 }
@Test
public void testPrimitiveValues4703() { 
     final MutableByte mutNum = new MutableByte((byte) 1); 
     assertEquals(1.0F, mutNum.floatValue(), 0); 
     assertEquals(1.0, mutNum.doubleValue(), 0); 
     assertEquals((byte) 1, mutNum.byteValue()); 
     assertEquals((short) 1, mutNum.shortValue()); 
     assertEquals(1, mutNum.intValue()); 
     assertEquals(1L, mutNum.longValue()); 
 }
@Test
public void testGetSet4712() { 
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
 }
@Test
public void testPrimitiveValues4960() { 
     final MutableByte mutNum = new MutableByte((byte) 1); 
     assertEquals(1.0F, mutNum.floatValue(), 0); 
     assertEquals(1.0, mutNum.doubleValue(), 0); 
     assertEquals((byte) 1, mutNum.byteValue()); 
     assertEquals((short) 1, mutNum.shortValue()); 
     assertEquals(1, mutNum.intValue()); 
     assertEquals(1L, mutNum.longValue()); 
 }
@Test
public void testAddValuePrimitive5218() { 
     final MutableByte mutNum = new MutableByte((byte) 1); 
     mutNum.add((byte) 1); 
     assertEquals((byte) 2, mutNum.byteValue()); 
 }
@Test
public void testConstructors5694() { 
     assertEquals((byte) 0, new MutableByte().byteValue()); 
     assertEquals((byte) 1, new MutableByte((byte) 1).byteValue()); 
     assertEquals((byte) 2, new MutableByte(Byte.valueOf((byte) 2)).byteValue()); 
     assertEquals((byte) 3, new MutableByte(new MutableByte((byte) 3)).byteValue()); 
     assertEquals((byte) 2, new MutableByte("2").byteValue()); 
 }
@Test
public void testSubtractValueObject5945() { 
     final MutableByte mutNum = new MutableByte((byte) 1); 
     mutNum.subtract(Integer.valueOf(1)); 
     assertEquals((byte) 0, mutNum.byteValue()); 
 }
@Test
public void testEquals5990() { 
     final MutableByte mutNumA = new MutableByte((byte) 0); 
     final MutableByte mutNumB = new MutableByte((byte) 0); 
     final MutableByte mutNumC = new MutableByte((byte) 1); 
     assertTrue(mutNumA.equals(mutNumA)); 
     assertTrue(mutNumA.equals(mutNumB)); 
     assertTrue(mutNumB.equals(mutNumA)); 
     assertTrue(mutNumB.equals(mutNumB)); 
     assertFalse(mutNumA.equals(mutNumC)); 
     assertFalse(mutNumB.equals(mutNumC)); 
     assertTrue(mutNumC.equals(mutNumC)); 
     assertFalse(mutNumA.equals(null)); 
     assertFalse(mutNumA.equals(Byte.valueOf((byte) 0))); 
     assertFalse(mutNumA.equals("0")); 
 }
@Test
public void testSubtractValueObject6343() { 
     final MutableByte mutNum = new MutableByte((byte) 1); 
     mutNum.subtract(Integer.valueOf(1)); 
     assertEquals((byte) 0, mutNum.byteValue()); 
 }
@Test
public void testCompareTo6488() { 
     final MutableByte mutNum = new MutableByte((byte) 0); 
     assertEquals((byte) 0, mutNum.compareTo(new MutableByte((byte) 0))); 
     assertEquals((byte) +1, mutNum.compareTo(new MutableByte((byte) -1))); 
     assertEquals((byte) -1, mutNum.compareTo(new MutableByte((byte) 1))); 
 }
@Test
public void testEquals6546() { 
     final MutableByte mutNumA = new MutableByte((byte) 0); 
     final MutableByte mutNumB = new MutableByte((byte) 0); 
     final MutableByte mutNumC = new MutableByte((byte) 1); 
     assertTrue(mutNumA.equals(mutNumA)); 
     assertTrue(mutNumA.equals(mutNumB)); 
     assertTrue(mutNumB.equals(mutNumA)); 
     assertTrue(mutNumB.equals(mutNumB)); 
     assertFalse(mutNumA.equals(mutNumC)); 
     assertFalse(mutNumB.equals(mutNumC)); 
     assertTrue(mutNumC.equals(mutNumC)); 
     assertFalse(mutNumA.equals(null)); 
     assertFalse(mutNumA.equals(Byte.valueOf((byte) 0))); 
     assertFalse(mutNumA.equals("0")); 
 }
@Test
public void testEquals6897() { 
     final MutableByte mutNumA = new MutableByte((byte) 0); 
     final MutableByte mutNumB = new MutableByte((byte) 0); 
     final MutableByte mutNumC = new MutableByte((byte) 1); 
     assertTrue(mutNumA.equals(mutNumA)); 
     assertTrue(mutNumA.equals(mutNumB)); 
     assertTrue(mutNumB.equals(mutNumA)); 
     assertTrue(mutNumB.equals(mutNumB)); 
     assertFalse(mutNumA.equals(mutNumC)); 
     assertFalse(mutNumB.equals(mutNumC)); 
     assertTrue(mutNumC.equals(mutNumC)); 
     assertFalse(mutNumA.equals(null)); 
     assertFalse(mutNumA.equals(Byte.valueOf((byte) 0))); 
     assertFalse(mutNumA.equals("0")); 
 }
@Test
public void testDecrement6971() { 
     final MutableByte mutNum = new MutableByte((byte) 1); 
     mutNum.decrement(); 
     assertEquals(0, mutNum.intValue()); 
     assertEquals(0L, mutNum.longValue()); 
 }
@Test
public void testConstructors7247() { 
     assertEquals((byte) 0, new MutableByte().byteValue()); 
     assertEquals((byte) 1, new MutableByte((byte) 1).byteValue()); 
     assertEquals((byte) 2, new MutableByte(Byte.valueOf((byte) 2)).byteValue()); 
     assertEquals((byte) 3, new MutableByte(new MutableByte((byte) 3)).byteValue()); 
     assertEquals((byte) 2, new MutableByte("2").byteValue()); 
 }
@Test(expected = NullPointerException.class) 
 public void testSetNull7264() { 
     final MutableByte mutNum = new MutableByte((byte) 0); 
     mutNum.setValue(null); 
 }
@Test
public void testToByte7436() { 
     assertEquals(Byte.valueOf((byte) 0), new MutableByte((byte) 0).toByte()); 
     assertEquals(Byte.valueOf((byte) 123), new MutableByte((byte) 123).toByte()); 
 }
@Test(expected = NullPointerException.class) 
 public void testCompareToNull8047() { 
     final MutableByte mutNum = new MutableByte((byte) 0); 
     mutNum.compareTo(null); 
 }
@Test
public void testAddValueObject8388() { 
     final MutableByte mutNum = new MutableByte((byte) 1); 
     mutNum.add(Integer.valueOf(1)); 
     assertEquals((byte) 2, mutNum.byteValue()); 
 }
@Test
public void testEquals8390() { 
     final MutableByte mutNumA = new MutableByte((byte) 0); 
     final MutableByte mutNumB = new MutableByte((byte) 0); 
     final MutableByte mutNumC = new MutableByte((byte) 1); 
     assertTrue(mutNumA.equals(mutNumA)); 
     assertTrue(mutNumA.equals(mutNumB)); 
     assertTrue(mutNumB.equals(mutNumA)); 
     assertTrue(mutNumB.equals(mutNumB)); 
     assertFalse(mutNumA.equals(mutNumC)); 
     assertFalse(mutNumB.equals(mutNumC)); 
     assertTrue(mutNumC.equals(mutNumC)); 
     assertFalse(mutNumA.equals(null)); 
     assertFalse(mutNumA.equals(Byte.valueOf((byte) 0))); 
     assertFalse(mutNumA.equals("0")); 
 }
@Test(expected = NullPointerException.class) 
 public void testCompareToNull8433() { 
     final MutableByte mutNum = new MutableByte((byte) 0); 
     mutNum.compareTo(null); 
 }
@Test
public void testPrimitiveValues8551() { 
     final MutableByte mutNum = new MutableByte((byte) 1); 
     assertEquals(1.0F, mutNum.floatValue(), 0); 
     assertEquals(1.0, mutNum.doubleValue(), 0); 
     assertEquals((byte) 1, mutNum.byteValue()); 
     assertEquals((short) 1, mutNum.shortValue()); 
     assertEquals(1, mutNum.intValue()); 
     assertEquals(1L, mutNum.longValue()); 
 }
@Test
public void testIncrement9413() { 
     final MutableByte mutNum = new MutableByte((byte) 1); 
     mutNum.increment(); 
     assertEquals(2, mutNum.intValue()); 
     assertEquals(2L, mutNum.longValue()); 
 }
@Test
public void testConstructors9458() { 
     assertEquals((byte) 0, new MutableByte().byteValue()); 
     assertEquals((byte) 1, new MutableByte((byte) 1).byteValue()); 
     assertEquals((byte) 2, new MutableByte(Byte.valueOf((byte) 2)).byteValue()); 
     assertEquals((byte) 3, new MutableByte(new MutableByte((byte) 3)).byteValue()); 
     assertEquals((byte) 2, new MutableByte("2").byteValue()); 
 }
@Test
public void testToString9534() { 
     assertEquals("0", new MutableByte((byte) 0).toString()); 
     assertEquals("10", new MutableByte((byte) 10).toString()); 
     assertEquals("-123", new MutableByte((byte) -123).toString()); 
 }
    

    

    

    

    

    

    

    

    

    

    

    

    

    

    

    

    

}
