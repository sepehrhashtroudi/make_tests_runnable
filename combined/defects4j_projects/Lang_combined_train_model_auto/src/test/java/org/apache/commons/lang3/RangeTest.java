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
public void testIsAfter193() { 
     assertFalse(intRange.isAfter(null)); 
     assertTrue(intRange.isAfter(5)); 
     assertFalse(intRange.isAfter(10)); 
     assertFalse(intRange.isAfter(15)); 
     assertFalse(intRange.isAfter(20)); 
     assertFalse(intRange.isAfter(25)); 
 }
@Test
public void testElementCompareTo298() { 
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
public void testIntersectionWith318() { 
     assertSame(intRange, intRange.intersectionWith(intRange)); 
     assertSame(byteRange, byteRange.intersectionWith(byteRange)); 
     assertSame(longRange, longRange.intersectionWith(longRange)); 
     assertSame(floatRange, floatRange.intersectionWith(floatRange)); 
     assertSame(doubleRange, doubleRange.intersectionWith(doubleRange)); 
     assertEquals(Range.between(10, 15), intRange.intersectionWith(Range.between(5, 15))); 
 }
@Test
public void testIsAfterRange319() { 
     assertFalse(intRange.isAfterRange(null)); 
     assertTrue(intRange.isAfterRange(Range.between(5, 9))); 
     assertFalse(intRange.isAfterRange(Range.between(5, 10))); 
     assertFalse(intRange.isAfterRange(Range.between(5, 20))); 
     assertFalse(intRange.isAfterRange(Range.between(5, 25))); 
     assertFalse(intRange.isAfterRange(Range.between(15, 25))); 
     assertFalse(intRange.isAfterRange(Range.between(21, 25))); 
     assertFalse(intRange.isAfterRange(Range.between(10, 20))); 
 }
@Test
public void testContainsRange325() { 
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
 public void testIntersectionWithNull350() { 
     intRange.intersectionWith(null); 
 }
@Test
public void testIsStartedBy491() { 
     assertFalse(intRange.isStartedBy(null)); 
     assertFalse(intRange.isStartedBy(5)); 
     assertTrue(intRange.isStartedBy(10)); 
     assertFalse(intRange.isStartedBy(15)); 
     assertFalse(intRange.isStartedBy(20)); 
     assertFalse(intRange.isStartedBy(25)); 
 }
@Test
public void testGetMaximum525() { 
     assertEquals(20, (int) intRange.getMaximum()); 
     assertEquals(20L, (long) longRange.getMaximum()); 
     assertEquals(20f, floatRange.getMaximum(), 0.00001f); 
     assertEquals(20d, doubleRange.getMaximum(), 0.00001d); 
 }
@Test
public void testIsEndedBy530() { 
     assertFalse(intRange.isEndedBy(null)); 
     assertFalse(intRange.isEndedBy(5)); 
     assertFalse(intRange.isEndedBy(10)); 
     assertFalse(intRange.isEndedBy(15)); 
     assertTrue(intRange.isEndedBy(20)); 
     assertFalse(intRange.isEndedBy(25)); 
 }
@Test
public void testHashCode533() { 
     assertEquals(byteRange.hashCode(), byteRange2.hashCode()); 
     assertFalse(byteRange.hashCode() == byteRange3.hashCode()); 
     assertEquals(intRange.hashCode(), intRange.hashCode()); 
     assertTrue(intRange.hashCode() != 0); 
 }
@Test
public void testContains567() { 
     assertFalse(intRange.contains(null)); 
     assertFalse(intRange.contains(5)); 
     assertTrue(intRange.contains(10)); 
     assertTrue(intRange.contains(15)); 
     assertTrue(intRange.contains(20)); 
     assertFalse(intRange.contains(25)); 
 }
@Test
public void testIsWithCompare655() { 
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
public void testComparableConstructors1051() { 
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
public void testEqualsObject1069() { 
     assertEquals(byteRange, byteRange); 
     assertEquals(byteRange, byteRange2); 
     assertEquals(byteRange2, byteRange2); 
     assertTrue(byteRange.equals(byteRange)); 
     assertTrue(byteRange2.equals(byteRange2)); 
     assertTrue(byteRange3.equals(byteRange3)); 
     assertFalse(byteRange2.equals(byteRange3)); 
     assertFalse(byteRange2.equals(null)); 
     assertFalse(byteRange2.equals("Ni!")); 
 }
@Test
public void testToStringFormat1150() { 
     final String str = intRange.toString("From %1$s to %2$s"); 
     assertEquals("From 10 to 20", str); 
 }
@Test
public void testGetMinimum1307() { 
     assertEquals(10, (int) intRange.getMinimum()); 
     assertEquals(10L, (long) longRange.getMinimum()); 
     assertEquals(10f, floatRange.getMinimum(), 0.00001f); 
     assertEquals(10d, doubleRange.getMinimum(), 0.00001d); 
 }
@Test
public void testBetween1415() { 
     final Comparator<Integer> c = new Comparator<Integer>() { 
  
         @Override 
         public int compare(final Integer o1, final Integer o2) { 
             return 0; 
         } 
     }; 
     Range<Integer> ri = Range.between(10, 20); 
     assertFalse("should not contain null", ri.contains(null)); 
     assertTrue("should contain 10", ri.contains(10)); 
     assertFalse("should not contain 11", ri.contains(11)); 
     ri = Range.between(10, 20); 
     assertFalse("should not contain null", ri.contains(null)); 
     assertTrue("should contain 10", ri.contains(10)); 
     assertTrue("should contain 11", ri.contains(11)); 
 }
@Test
public void testIsBeforeRange1438() { 
     assertFalse(intRange.isBeforeRange(null)); 
     assertTrue(intRange.isBeforeRange(Range.between(12, 18))); 
     assertFalse(intRange.isBeforeRange(Range.between(32, 45))); 
     assertFalse(intRange.isBeforeRange(Range.between(2, 8))); 
     assertFalse(intRange.isBeforeRange(Range.between(10, 20))); 
     assertFalse(intRange.isBeforeRange(Range.between(9, 14))); 
     assertFalse(intRange.isBeforeRange(Range.between(16, 21))); 
     assertFalse(intRange.isBeforeRange(Range.between(10, 19))); 
     assertTrue(intRange.isBeforeRange(Range.between(10, 21))); 
     assertFalse(intRange.isBeforeRange(Range.between(11, 20))); 
     assertFalse(intRange.isBeforeRange(Range.between(9, 20))); 
     assertFalse(intRange.isBeforeRange(Range.between(-11, -18))); 
 }
@Test
public void testComparableConstructors1721() { 
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
public void testBetween1722() { 
     assertEquals(Range.between(12, 18), Range.between(12, 18)); 
     assertEquals(Range.between(10, 20), Range.between(10, 20)); 
     assertEquals(Range.between(15, 25), Range.between(15, 25)); 
     assertEquals(Range.between(20, 25), Range.between(20, 25)); 
     assertEquals(Range.between(15, 25), Range.between(15, 25)); 
     assertEquals(Range.between(21, 25), Range.between(21, 25)); 
     assertEquals(Range.between(10, 20), Range.between(10, 20)); 
 }
@Test
public void testFormatDurationWords1723() { 
     assertEquals("between(50 seconds, 75 seconds)", intRange.toString("50 seconds")); 
     assertEquals("between(50 seconds, 75 seconds)", longRange.toString("50 seconds")); 
     assertEquals("between(50 seconds, 75 seconds)", floatRange.toString("50 seconds")); 
     assertEquals("between(50 seconds, 75 seconds)", doubleRange.toString("50 seconds")); 
     assertEquals("between(50 seconds, 75 seconds)", floatRange.toString("50 seconds")); 
     assertEquals("between(50 seconds, 75 seconds)", doubleRange.toString("50 seconds")); 
 }
@Test
public void testFormatDurationWords1725() { 
     assertEquals("between(50 seconds, 75 seconds)", intRange.toString("yyyy-MM-dd hh a mm:ss")); 
     assertEquals("between(50 seconds, 75 seconds)", longRange.toString("yyyy-MM-dd KK a mm:ss")); 
     assertEquals("between(50 seconds, 75 seconds)", floatRange.toString("50 seconds")); 
     assertEquals("between(50 seconds, 75 seconds)", doubleRange.toString("50 seconds")); 
     assertEquals("between(50 seconds, 75 seconds)", floatRange.toString("50 seconds")); 
     assertEquals("between(50 seconds, 75 seconds)", doubleRange.toString("50 seconds")); 
 }
    

    

    

    //-----------------------------------------------------------------------
    

    //-----------------------------------------------------------------------
    

    

    

    

    //-----------------------------------------------------------------------
    

    

    

    

    

    

    

    

    //-----------------------------------------------------------------------
    

    

    

    

    

    

    

    //-----------------------------------------------------------------------
    

}
