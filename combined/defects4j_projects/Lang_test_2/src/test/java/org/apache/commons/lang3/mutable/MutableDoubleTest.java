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
public void testGetSet472() { 
     final MutableDouble mutNum = new MutableDouble(0d); 
     assertEquals(0d, new MutableDouble().doubleValue(), 0.0001d); 
     assertEquals(Double.valueOf(0), new MutableDouble().getValue()); 
     mutNum.setValue(1d); 
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
 public void testConstructorNull473() { 
     new MutableDouble((Number) null); 
 }
@Test
public void testConstructors474() { 
     assertEquals(0d, new MutableDouble().doubleValue(), 0.0001d); 
     assertEquals(1d, new MutableDouble(1d).doubleValue(), 0.0001d); 
     assertEquals(2d, new MutableDouble(Double.valueOf(2d)).doubleValue(), 0.0001d); 
     assertEquals(3d, new MutableDouble(new MutableDouble(3d)).doubleValue(), 0.0001d); 
     assertEquals(2d, new MutableDouble("2.0").doubleValue(), 0.0001d); 
 }
@Test
public void testConstructors475() { 
     assertEquals(0d, new MutableDouble().doubleValue(), 0.0001d); 
     assertEquals(1d, new MutableDouble(1d).doubleValue(), 0.0001d); 
     assertEquals(2d, new MutableDouble(Double.valueOf(2d)).doubleValue(), 0.0001d); 
     assertEquals(3d, new MutableDouble(new MutableDouble(3d)).doubleValue(), 0.0001d); 
 }
@Test
public void testGetSet476() { 
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
@Test
public void testPrimitiveValues477() { 
     final MutableDouble mutNum = new MutableDouble(1.7); 
     assertEquals(1.7F, mutNum.floatValue(), 0); 
     assertEquals(1.7, mutNum.doubleValue(), 0); 
     assertEquals((byte) 1, mutNum.byteValue()); 
     assertEquals((short) 1, mutNum.shortValue()); 
     assertEquals(1, mutNum.intValue()); 
     assertEquals(1L, mutNum.longValue()); 
 }
    

    

    

    

    

    

    

    

    

    

    

    

    

    

    

    

    

    

}
