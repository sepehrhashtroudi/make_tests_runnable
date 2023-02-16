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
 * @see MutableInt
 */
public class MutableIntTest {

    // ----------------------------------------------------------------
@Test
public void testConstructors427() { 
     assertEquals(0, new MutableInt().intValue()); 
     assertEquals(1, new MutableInt(1).intValue()); 
     assertEquals(2, new MutableInt(Integer.valueOf(2)).intValue()); 
     assertEquals(3, new MutableInt(new MutableLong(3)).intValue()); 
     assertEquals(2, new MutableInt("2").intValue()); 
 }
@Test
public void testAddValueObject428() { 
     final MutableInt mutNum = new MutableInt(1); 
     mutNum.add(Integer.valueOf(1)); 
     assertEquals(2, mutNum.intValue()); 
     assertEquals(2L, mutNum.longValue()); 
 }
@Test
public void testIncrement429() { 
     final MutableInt mutNum = new MutableInt(1); 
     mutNum.increment(); 
     assertEquals(2, mutNum.intValue()); 
     assertEquals(2L, mutNum.longValue()); 
 }
@Test
public void testToInteger430() { 
     assertEquals(Integer.valueOf(0), new MutableInt(0).toInteger()); 
     assertEquals(Integer.valueOf(123), new MutableInt(123).toInteger()); 
 }
@Test
public void testEquals431() { 
     final MutableInt mutNumA = new MutableInt(0); 
     final MutableInt mutNumB = new MutableInt(0); 
     final MutableInt mutNumC = new MutableInt(1); 
     assertTrue(mutNumA.equals(mutNumA)); 
     assertTrue(mutNumA.equals(mutNumB)); 
     assertTrue(mutNumB.equals(mutNumA)); 
     assertTrue(mutNumB.equals(mutNumB)); 
     assertFalse(mutNumA.equals(mutNumC)); 
     assertFalse(mutNumB.equals(mutNumC)); 
     assertTrue(mutNumC.equals(mutNumC)); 
     assertFalse(mutNumA.equals(null)); 
     assertFalse(mutNumA.equals(Integer.valueOf(0))); 
     assertFalse(mutNumA.equals("0")); 
 }
@Test(expected = NullPointerException.class) 
 public void testCompareToNull432() { 
     final MutableInt mutNum = new MutableInt(0); 
     mutNum.compareTo(null); 
 }
@Test
public void testCompareTo433() { 
     final MutableInt mutNum = new MutableInt(0); 
     assertEquals(0, mutNum.compareTo(new MutableInt(0))); 
     assertEquals(+1, mutNum.compareTo(new MutableInt(-1))); 
     assertEquals(-1, mutNum.compareTo(new MutableInt(1))); 
 }
    

    

    

    

    

    /**
     * @param numA must not be a 0 Integer; must not equal numC.
     * @param numB must equal numA; must not equal numC.
     * @param numC must not equal numA; must not equal numC.
     */
    void testEquals(final Number numA, final Number numB, final Number numC) {
        assertTrue(numA.equals(numA));
        assertTrue(numA.equals(numB));
        assertTrue(numB.equals(numA));
        assertTrue(numB.equals(numB));
        assertFalse(numA.equals(numC));
        assertFalse(numB.equals(numC));
        assertTrue(numC.equals(numC));
        assertFalse(numA.equals(null));
        assertFalse(numA.equals(Integer.valueOf(0)));
        assertFalse(numA.equals("0"));
    }

    

    

    

    

    

    

    

    

    

    

    

    

}
