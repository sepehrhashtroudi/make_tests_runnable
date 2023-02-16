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
 * @see MutableFloat
 */
public class MutableFloatTest {

    // ----------------------------------------------------------------
@Test
public void testConstructors50() { 
     assertEquals(0f, new MutableFloat().floatValue(), 0.0001f); 
     assertEquals(1f, new MutableFloat(1f).floatValue(), 0.0001f); 
     assertEquals(2f, new MutableFloat(Float.valueOf(2f)).floatValue(), 0.0001f); 
     assertEquals(3f, new MutableFloat(new MutableFloat(3f)).floatValue(), 0.0001f); 
     assertEquals(2f, new MutableFloat("2.0").floatValue(), 0.0001f); 
 }
@Test
public void testConstructors51() { 
     assertEquals(0f, new MutableFloat(0f).floatValue(), 0.0001f); 
     assertEquals(1f, new MutableFloat(1f).floatValue(), 0.0001f); 
     assertEquals(2f, new MutableFloat(Float.valueOf(2f)).floatValue(), 0.0001f); 
     assertEquals(3f, new MutableFloat(new MutableFloat(3f)).floatValue(), 0.0001f); 
     assertEquals(2f, new MutableFloat("2.0").floatValue(), 0.0001f); 
 }
@Test
public void testGetSet52() { 
     final MutableFloat mutNum = new MutableFloat(0f); 
     assertEquals(0f, new MutableFloat().floatValue(), 0.0001f); 
     assertEquals(Float.valueOf(0), new MutableFloat().getValue()); 
     mutNum.setValue(1); 
     assertEquals(1f, mutNum.floatValue(), 0.0001f); 
     assertEquals(Float.valueOf(1f), mutNum.getValue()); 
     mutNum.setValue(Float.valueOf(2f)); 
     assertEquals(2f, mutNum.floatValue(), 0.0001f); 
     assertEquals(Float.valueOf(2f), mutNum.getValue()); 
     mutNum.setValue(new MutableFloat(3f)); 
     assertEquals(3f, mutNum.floatValue(), 0.0001f); 
     assertEquals(Float.valueOf(3f), mutNum.getValue()); 
 }
@Test
public void testNanInfinite53() { 
     MutableFloat mutNum = new MutableFloat(Float.NaN); 
     assertTrue(mutNum.isNaN()); 
     mutNum = new MutableFloat(Float.POSITIVE_INFINITY); 
     assertTrue(mutNum.isInfinite()); 
     mutNum = new MutableFloat(Float.NEGATIVE_INFINITY); 
     assertTrue(mutNum.isInfinite()); 
 }
@Test
public void testIncrement54() { 
     final MutableFloat mutNum = new MutableFloat(1); 
     mutNum.increment(); 
     assertEquals(2, mutNum.intValue()); 
     assertEquals(2L, mutNum.longValue()); 
 }
@Test
public void testDecrement55() { 
     final MutableFloat mutNum = new MutableFloat(1); 
     mutNum.decrement(); 
     assertEquals(0, mutNum.intValue()); 
     assertEquals(0L, mutNum.longValue()); 
 }
@Test
public void testSubtractValuePrimitive56() { 
     final MutableFloat mutNum = new MutableFloat(1); 
     mutNum.subtract(1.1f); 
     assertEquals(0.1f, mutNum.floatValue(), 0.01f); 
 }
@Test
public void testSubtractValueObject57() { 
     final MutableFloat mutNum = new MutableFloat(1); 
     mutNum.subtract(Float.valueOf(1.1f)); 
     assertEquals(0.1f, mutNum.floatValue(), 0.01f); 
 }
    

    

    

    

    

    

    

    

    

    

    

    

    

    

    

    

    

    

}
