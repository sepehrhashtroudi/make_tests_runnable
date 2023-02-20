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
@Test(expected = NullPointerException.class) 
 public void testConstructorNull164() { 
     new MutableFloat((Number) null); 
 }
@Test
public void testConstructors165() { 
     assertEquals(0f, new MutableFloat().floatValue(), 0.0001f); 
     assertEquals(1f, new MutableFloat(1f).floatValue(), 0.0001f); 
     assertEquals(2f, new MutableFloat(Float.valueOf(2f)).floatValue(), 0.0001f); 
     assertEquals(3f, new MutableFloat(new MutableFloat(3f)).floatValue(), 0.0001f); 
     assertEquals(2f, new MutableFloat("2.0").floatValue(), 0.0001f); 
 }
@Test
public void testAddValuePrimitive166() { 
     final MutableFloat mutNum = new MutableFloat(1); 
     mutNum.add(1.1f); 
     assertEquals(2.1f, mutNum.floatValue(), 0.01f); 
 }
@Test
public void testAddValueObject167() { 
     final MutableFloat mutNum = new MutableFloat(1); 
     mutNum.add(Float.valueOf(1.1f)); 
     assertEquals(2.1f, mutNum.floatValue(), 0.01f); 
 }
@Test
public void testToFloat168() { 
     assertEquals(Float.valueOf(0f), new MutableFloat(0f).toFloat()); 
     assertEquals(Float.valueOf(12.3f), new MutableFloat(12.3f).toFloat()); 
 }
@Test
public void testEquals169() { 
     final MutableFloat mutNumA = new MutableFloat(0f); 
     final MutableFloat mutNumB = new MutableFloat(0f); 
     final MutableFloat mutNumC = new MutableFloat(1f); 
     assertTrue(mutNumA.equals(mutNumA)); 
     assertTrue(mutNumA.equals(mutNumB)); 
     assertTrue(mutNumB.equals(mutNumA)); 
     assertTrue(mutNumB.equals(mutNumB)); 
     assertFalse(mutNumA.equals(mutNumC)); 
     assertFalse(mutNumB.equals(mutNumC)); 
     assertTrue(mutNumC.equals(mutNumC)); 
     assertFalse(mutNumA.equals(null)); 
     assertFalse(mutNumA.equals(Float.valueOf(0f))); 
     assertFalse(mutNumA.equals("0")); 
 }
@Test
public void testHashCode170() { 
     final MutableFloat mutNumA = new MutableFloat(0f); 
     final MutableFloat mutNumB = new MutableFloat(0f); 
     final MutableFloat mutNumC = new MutableFloat(1f); 
     assertTrue(mutNumA.hashCode() == mutNumA.hashCode()); 
     assertTrue(mutNumA.hashCode() == mutNumB.hashCode()); 
     assertFalse(mutNumA.hashCode() == mutNumC.hashCode()); 
     assertTrue(mutNumA.hashCode() == Float.valueOf(0f).hashCode()); 
 }
@Test
public void testCompareTo171() { 
     final MutableFloat mutNum = new MutableFloat(0f); 
     assertEquals(0, mutNum.compareTo(new MutableFloat(0f))); 
     assertEquals(+1, mutNum.compareTo(new MutableFloat(-1f))); 
     assertEquals(-1, mutNum.compareTo(new MutableFloat(1f))); 
 }
@Test
public void testToString172() { 
     assertEquals("0.0", new MutableFloat(0f).toString()); 
     assertEquals("10.0", new MutableFloat(10f).toString()); 
     assertEquals("-123.0", new MutableFloat(-123f).toString()); 
 }
    

    

    

    

    

    

    

    

    

    

    

    

    

    

    

    

    

    

}
