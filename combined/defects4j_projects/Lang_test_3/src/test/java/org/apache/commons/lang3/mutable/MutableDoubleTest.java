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
public void testIncrement505() { 
     final MutableDouble mutNum = new MutableDouble(1); 
     mutNum.increment(); 
     assertEquals(2, mutNum.intValue()); 
     assertEquals(2L, mutNum.longValue()); 
 }
@Test
public void testDecrement506() { 
     final MutableDouble mutNum = new MutableDouble(1); 
     mutNum.decrement(); 
     assertEquals(0, mutNum.intValue()); 
     assertEquals(0L, mutNum.longValue()); 
 }
@Test
public void testSubtractValuePrimitive507() { 
     final MutableDouble mutNum = new MutableDouble(1); 
     mutNum.subtract(0.9d); 
     assertEquals(0.1d, mutNum.doubleValue(), 0.01d); 
 }
@Test
public void testSubtractValueObject508() { 
     final MutableDouble mutNum = new MutableDouble(1); 
     mutNum.subtract(Double.valueOf(0.9d)); 
     assertEquals(0.1d, mutNum.doubleValue(), 0.01d); 
 }
    

    

    

    

    

    

    

    

    

    

    

    

    

    

    

    

    

    

}
