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
 * @see MutableDouble
 */
public class MutableDoubleTest {

    // ----------------------------------------------------------------
@Test
public void testConstructors1100() { 
     assertEquals(0d, new MutableDouble().doubleValue(), 0.0001d); 
     assertEquals(1d, new MutableDouble(1d).doubleValue(), 0.0001d); 
     assertEquals(2d, new MutableDouble(Double.valueOf(2d)).doubleValue(), 0.0001d); 
     assertEquals(3d, new MutableDouble(new MutableDouble(3d)).doubleValue(), 0.0001d); 
     assertEquals(2d, new MutableDouble("2.0").doubleValue(), 0.0001d); 
 }
@Test
public void testGetSet1101() { 
     final MutableDouble mutNum = new MutableDouble(0d); 
     assertEquals(0d, new MutableDouble().doubleValue(), 0.0001d); 
     assertEquals(Double.valueOf(0), new MutableDouble().getValue()); 
     mutNum.setValue(1); 
     assertEquals(1d, mutNum.doubleValue(), 0.0001d); 
     assertEquals(Double.valueOf(1d), mutNum.getValue()); 
     mutNum.setValue(Double.valueOf(2d)); 
     assertEquals(2d, mutNum.doubleValue(), 0.0001d); 
     assertEquals(Double.valueOf(2d), mutNum.getValue()); 
     mutNum.setValue(new MutableDouble(3d)); 
     assertEquals(3d, mutNum.doubleValue(), 0.0001d); 
     assertEquals(Double.valueOf(3d), mutNum.getValue()); 
 }
@Test(expected = NullPointerException.class) 
 public void testSetNull1102() { 
     final MutableDouble mutNum = new MutableDouble(0d); 
     mutNum.setValue(null); 
 }
@Test
public void testNanInfinite1103() { 
     MutableDouble mutNum = new MutableDouble(Double.NaN); 
     assertTrue(mutNum.isNaN()); 
     mutNum = new MutableDouble(Double.POSITIVE_INFINITY); 
     assertTrue(mutNum.isInfinite()); 
     mutNum = new MutableDouble(Double.NEGATIVE_INFINITY); 
     assertTrue(mutNum.isInfinite()); 
 }
@Test
public void testIncrement1104() { 
     final MutableDouble mutNum = new MutableDouble(1); 
     mutNum.increment(); 
     assertEquals(2, mutNum.intValue()); 
     assertEquals(2L, mutNum.longValue()); 
 }
@Test
public void testDecrement1105() { 
     final MutableDouble mutNum = new MutableDouble(1); 
     mutNum.decrement(); 
     assertEquals(0, mutNum.intValue()); 
     assertEquals(0L, mutNum.longValue()); 
 }
@Test
public void testAddValuePrimitive1106() { 
     final MutableDouble mutNum = new MutableDouble(1); 
     mutNum.add(1.1d); 
     assertEquals(2.1d, mutNum.doubleValue(), 0.01d); 
 }
@Test
public void testSubtractValuePrimitive1107() { 
     final MutableDouble mutNum = new MutableDouble(1); 
     mutNum.subtract(0.9d); 
     assertEquals(0.1d, mutNum.doubleValue(), 0.01d); 
 }
@Test
public void testSubtractValueObject1108() { 
     final MutableDouble mutNum = new MutableDouble(1); 
     mutNum.subtract(Double.valueOf(0.9d)); 
     assertEquals(0.1d, mutNum.doubleValue(), 0.01d); 
 }
@Test
public void testHashCode1109() { 
     final MutableDouble mutNumA = new MutableDouble(0d); 
     final MutableDouble mutNumB = new MutableDouble(0d); 
     final MutableDouble mutNumC = new MutableDouble(1d); 
     assertTrue(mutNumA.hashCode() == mutNumA.hashCode()); 
     assertTrue(mutNumA.hashCode() == mutNumB.hashCode()); 
     assertFalse(mutNumA.hashCode() == mutNumC.hashCode()); 
     assertTrue(mutNumA.hashCode() == Double.valueOf(0d).hashCode()); 
 }
@Test
public void testCompareTo1110() { 
     final MutableDouble mutNum = new MutableDouble(0d); 
     assertEquals(0, mutNum.compareTo(new MutableDouble(0d))); 
     assertEquals(+1, mutNum.compareTo(new MutableDouble(-1d))); 
     assertEquals(-1, mutNum.compareTo(new MutableDouble(1d))); 
 }
    

    

    

    

    

    

    

    

    

    

    

    

    

    

    

    

    

    

}
