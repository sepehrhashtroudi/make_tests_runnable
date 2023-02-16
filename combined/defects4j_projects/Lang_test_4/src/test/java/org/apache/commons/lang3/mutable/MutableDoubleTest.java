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
public void testAddValueObject579() { 
     final MutableDouble mutNum = new MutableDouble(1); 
     mutNum.add(Double.valueOf(1.1d)); 
     assertEquals(2.1d, mutNum.doubleValue(), 0.01d); 
 }
@Test
public void testConstructors580() { 
     assertEquals(0d, new MutableDouble().doubleValue(), 0.0001d); 
     assertEquals(1d, new MutableDouble(1d).doubleValue(), 0.0001d); 
     assertEquals(2d, new MutableDouble(Double.valueOf(2d)).doubleValue(), 0.0001d); 
     assertEquals(3d, new MutableDouble(new MutableDouble(3d)).doubleValue(), 0.0001d); 
     assertEquals(2d, new MutableDouble("2.0").doubleValue(), 0.0001d); 
 }
@Test
public void testToDouble581() { 
     assertEquals(Double.valueOf(0d), new MutableDouble(0d).toDouble()); 
     assertEquals(Double.valueOf(12.3d), new MutableDouble(12.3d).toDouble()); 
 }
@Test
public void testEquals582() { 
     final MutableDouble mutNumA = new MutableDouble(0d); 
     final MutableDouble mutNumB = new MutableDouble(0d); 
     final MutableDouble mutNumC = new MutableDouble(1d); 
     assertTrue(mutNumA.equals(mutNumA)); 
     assertTrue(mutNumA.equals(mutNumB)); 
     assertTrue(mutNumB.equals(mutNumA)); 
     assertTrue(mutNumB.equals(mutNumB)); 
     assertFalse(mutNumA.equals(mutNumC)); 
     assertFalse(mutNumB.equals(mutNumC)); 
     assertTrue(mutNumC.equals(mutNumC)); 
     assertFalse(mutNumA.equals(null)); 
     assertFalse(mutNumA.equals(Double.valueOf(0d))); 
     assertFalse(mutNumA.equals("0")); 
 }
@Test
public void testToString583() { 
     assertEquals("0.0", new MutableDouble(0d).toString()); 
     assertEquals("10.0", new MutableDouble(10d).toString()); 
     assertEquals("-123.0", new MutableDouble(-123d).toString()); 
 }
    

    

    

    

    

    

    

    

    

    

    

    

    

    

    

    

    

    

}
