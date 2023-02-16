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

package org.apache.commons.lang3;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.Comparator;

import org.junit.Before;
import org.junit.Test;

/**
 * <p>
 * Tests the methods in the {@link org.apache.commons.lang3.Range} class.
 * </p>
 * 
 * @version $Id$
 */
@SuppressWarnings("boxing")
public class RangeTest {

    private Range<Byte> byteRange;
    private Range<Byte> byteRange2;
    private Range<Byte> byteRange3;

    private Range<Integer> intRange;
    private Range<Long> longRange;
    private Range<Float> floatRange;
    private Range<Double> doubleRange;

    @SuppressWarnings("cast") // intRange
    @Before
    public void setUp() {
        byteRange   = Range.between((byte) 0, (byte) 5);
        byteRange2  = Range.between((byte) 0, (byte) 5);
        byteRange3  = Range.between((byte) 0, (byte) 10);

        intRange    = Range.between((int) 10, (int) 20);
        longRange   = Range.between((long) 10, (long) 20);
        floatRange  = Range.between((float) 10, (float) 20);
        doubleRange = Range.between((double) 10, (double) 20);
    }

    //-----------------------------------------------------------------------
@Test
public void testContains345() { 
     assertFalse(intRange.contains(null)); 
     assertFalse(intRange.contains(5)); 
     assertTrue(intRange.contains(10)); 
     assertFalse(intRange.contains(15)); 
     assertFalse(intRange.contains(20)); 
     assertFalse(intRange.contains(25)); 
 }
@Test
public void testContains346() { 
     assertFalse(intRange.contains(null)); 
     assertFalse(intRange.contains(5)); 
     assertFalse(intRange.contains(10)); 
     assertFalse(intRange.contains(15)); 
     assertTrue(intRange.contains(20)); 
     assertFalse(intRange.contains(25)); 
 }
@Test
public void testIsBefore347() { 
     assertFalse(intRange.isBefore(null)); 
     assertFalse(intRange.isBefore(5)); 
     assertFalse(intRange.isBefore(10)); 
     assertFalse(intRange.isBefore(15)); 
     assertTrue(intRange.isBefore(20)); 
     assertFalse(intRange.isBefore(25)); 
 }
@Test
public void testContainsRange348() { 
     assertFalse(intRange.containsRange(null)); 
     assertFalse(intRange.containsRange(Range.between(5, 9))); 
     assertFalse(intRange.containsRange(Range.between(5, 10))); 
     assertFalse(intRange.containsRange(Range.between(5, 20))); 
     assertFalse(intRange.containsRange(Range.between(5, 25))); 
     assertFalse(intRange.containsRange(Range.between(15, 25))); 
     assertTrue(intRange.containsRange(Range.between(21, 25))); 
     assertFalse(intRange.containsRange(Range.between(10, 20))); 
 }
@Test
public void testToString349() { 
     assertNotNull(byteRange.toString()); 
     final String str = intRange.toString(); 
     assertEquals("[10..20]", str); 
     assertEquals("[-20..-10]", Range.between(-20, -10).toString()); 
 }
    

    

    

    //-----------------------------------------------------------------------
    

    //-----------------------------------------------------------------------
    

    

    

    

    //-----------------------------------------------------------------------
    

    

    

    

    

    

    

    

    //-----------------------------------------------------------------------
    

    

    

    

    

    

    

    //-----------------------------------------------------------------------
    

}
