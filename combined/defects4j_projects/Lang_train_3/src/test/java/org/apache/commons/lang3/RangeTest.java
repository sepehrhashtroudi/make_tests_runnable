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
public void testIsWithCompare806() { 
     final Comparator<Integer> c = new Comparator<Integer>() { 
  
         @Override 
         public int compare(final Integer o1, final Integer o2) { 
             return 0; 
         } 
     }; 
     Range<Integer> ri = Range.is(10); 
     assertFalse("should not contain null", ri.contains(null)); 
     assertTrue("should contain 10", ri.contains(10)); 
     assertFalse("should not contain 11", ri.contains(11)); 
     ri = Range.is(10, c); 
     assertFalse("should not contain null", ri.contains(null)); 
     assertTrue("should contain 10", ri.contains(10)); 
     assertTrue("should contain 11", ri.contains(11)); 
 }
@Test
public void testToString807() { 
     assertNotNull(byteRange.toString()); 
     final String str = intRange.toString(); 
     assertEquals("[10..20]", str); 
     assertEquals("[-20..-10]", Range.between(-20, -10).toString()); 
 } 
@SuppressWarnings({ "rawtypes", "unchecked" })
@Test
public void testComparableConstructors808() { 
     final Comparable c = new Comparable() { 
  
         @Override 
         public int compareTo(final Object other) { 
             return 1; 
         } 
     }; 
     final Range r1 = Range.is(c); 
     final Range r2 = Range.between(c, c); 
     assertEquals(true, r1.isNaturalOrdering()); 
     assertEquals(true, r2.isNaturalOrdering()); 
 }
@Test
public void testGetMaximum809() { 
     assertEquals(20, (int) intRange.getMaximum()); 
     assertEquals(20L, (long) longRange.getMaximum()); 
     assertEquals(20f, floatRange.getMaximum(), 0.00001f); 
     assertEquals(20d, doubleRange.getMaximum(), 0.00001d); 
 }
@Test
public void testIntersectionWith810() { 
     assertSame(intRange, intRange.intersectionWith(intRange)); 
     assertSame(byteRange, byteRange.intersectionWith(byteRange)); 
     assertSame(longRange, longRange.intersectionWith(longRange)); 
     assertSame(floatRange, floatRange.intersectionWith(floatRange)); 
     assertSame(doubleRange, doubleRange.intersectionWith(doubleRange)); 
     assertEquals(Range.between(10, 15), intRange.intersectionWith(Range.between(5, 15))); 
 }
@Test
public void testContains811() { 
     assertFalse(intRange.contains(null)); 
     assertFalse(intRange.contains(5)); 
     assertTrue(intRange.contains(10)); 
     assertTrue(intRange.contains(15)); 
     assertTrue(intRange.contains(20)); 
     assertFalse(intRange.contains(25)); 
 }
@Test
public void testIsAfter812() { 
     assertFalse(intRange.isAfter(null)); 
     assertTrue(intRange.isAfter(5)); 
     assertFalse(intRange.isAfter(10)); 
     assertFalse(intRange.isAfter(15)); 
     assertFalse(intRange.isAfter(20)); 
     assertFalse(intRange.isAfter(25)); 
 }
@Test
public void testIsStartedBy813() { 
     assertFalse(intRange.isStartedBy(null)); 
     assertFalse(intRange.isStartedBy(5)); 
     assertTrue(intRange.isStartedBy(10)); 
     assertFalse(intRange.isStartedBy(15)); 
     assertFalse(intRange.isStartedBy(20)); 
     assertFalse(intRange.isStartedBy(25)); 
 }
@Test
public void testIsEndedBy814() { 
     assertFalse(intRange.isEndedBy(null)); 
     assertFalse(intRange.isEndedBy(5)); 
     assertFalse(intRange.isEndedBy(10)); 
     assertFalse(intRange.isEndedBy(15)); 
     assertTrue(intRange.isEndedBy(20)); 
     assertFalse(intRange.isEndedBy(25)); 
 }
@Test
public void testIsBefore815() { 
     assertFalse(intRange.isBefore(null)); 
     assertFalse(intRange.isBefore(5)); 
     assertFalse(intRange.isBefore(10)); 
     assertFalse(intRange.isBefore(15)); 
     assertFalse(intRange.isBefore(20)); 
     assertTrue(intRange.isBefore(25)); 
 }
@Test
public void testElementCompareTo816() { 
     try { 
         intRange.elementCompareTo(null); 
         fail("NullPointerException should have been thrown"); 
     } catch (final NullPointerException npe) { 
     } 
     assertEquals(-1, intRange.elementCompareTo(5)); 
     assertEquals(0, intRange.elementCompareTo(10)); 
     assertEquals(0, intRange.elementCompareTo(15)); 
     assertEquals(0, intRange.elementCompareTo(20)); 
     assertEquals(1, intRange.elementCompareTo(25)); 
 }
@Test
public void testContainsRange817() { 
     assertFalse(intRange.containsRange(null)); 
     assertTrue(intRange.containsRange(Range.between(12, 18))); 
     assertFalse(intRange.containsRange(Range.between(32, 45))); 
     assertFalse(intRange.containsRange(Range.between(2, 8))); 
     assertTrue(intRange.containsRange(Range.between(10, 20))); 
     assertFalse(intRange.containsRange(Range.between(9, 14))); 
     assertFalse(intRange.containsRange(Range.between(16, 21))); 
     assertTrue(intRange.containsRange(Range.between(10, 19))); 
     assertFalse(intRange.containsRange(Range.between(10, 21))); 
     assertTrue(intRange.containsRange(Range.between(11, 20))); 
     assertFalse(intRange.containsRange(Range.between(9, 20))); 
     assertFalse(intRange.containsRange(Range.between(-11, -18))); 
 }
@Test(expected = IllegalArgumentException.class) 
 public void testIntersectionWithNull818() { 
     intRange.intersectionWith(null); 
 }
@Test
public void testIsBeforeRange819() { 
     assertFalse(intRange.isBeforeRange(null)); 
     assertFalse(intRange.isBeforeRange(Range.between(5, 9))); 
     assertFalse(intRange.isBeforeRange(Range.between(5, 10))); 
     assertFalse(intRange.isBeforeRange(Range.between(5, 20))); 
     assertFalse(intRange.isBeforeRange(Range.between(5, 25))); 
     assertFalse(intRange.isBeforeRange(Range.between(15, 25))); 
     assertTrue(intRange.isBeforeRange(Range.between(21, 25))); 
     assertFalse(intRange.isBeforeRange(Range.between(10, 20))); 
 }
@Test
public void testHashCode820() { 
     assertEquals(byteRange.hashCode(), byteRange2.hashCode()); 
     assertFalse(byteRange.hashCode() == byteRange3.hashCode()); 
     assertEquals(intRange.hashCode(), intRange.hashCode()); 
     assertTrue(intRange.hashCode() != 0); 
 }
@Test
public void testToStringFormat821() { 
     final String str = intRange.toString("From %1$s to %2$s"); 
     assertEquals("From 10 to 20", str); 
 }
    

    

    

    //-----------------------------------------------------------------------
    

    //-----------------------------------------------------------------------
    

    

    

    

    //-----------------------------------------------------------------------
    

    

    

    

    

    

    

    

    //-----------------------------------------------------------------------
    

    

    

    

    

    

    

    //-----------------------------------------------------------------------
    

}
