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
public void testEqualsHashcode7() { 
         final Range<Integer> ri1 = Range.is(10); 
         final Range<Integer> ri2 = Range.is(10); 
         assertEquals(ri1, ri2); 
         assertEquals(ri1.hashCode(), ri2.hashCode()); 
         ri1.hashCode(); 
         ri2.hashCode(); 
     }
@Test
public void testIsWithCompare43() { 
         final Comparator<Integer> c = new Comparator<Integer>(){ 
             @Override 
             public int compare(final Integer o1, final Integer o2) { 
                 return 0; // all integers are equal 
             } 
         }; 
         Range<Integer> ri = Range.is(10); 
         assertFalse("should not contain null",ri.contains(null)); 
         assertTrue("should contain 10",ri.contains(10)); 
         ri = Range.is(10,c); 
         assertFalse("should not contain null",ri.contains(null)); 
         assertTrue("should contain 10",ri.contains(10)); 
     }
@Test
public void testEqualsHashcode366() { 
         final Range<Integer> ri1 = Range.is(10); 
         final Range<Integer> ri2 = Range.is(10); 
         assertEquals(ri1, ri2); 
         assertEquals(ri1.hashCode(), ri2.hashCode()); 
         ri1.hashCode(); 
         ri2.hashCode(); 
         assertFalse(ri1.equals(ri2)); 
     }
@Test
public void testEqualsHashcode367() { 
         final Range<Integer> ri1 = Range.is(10); 
         final Range<Integer> ri2 = Range.is(10); 
         assertEquals(ri1, ri2); 
         assertEquals(ri1.hashCode(), ri2.hashCode()); 
         ri1.hashCode(); 
         ri2.hashCode(); 
     }
@Test
public void testHashCode368() { 
         Range<Integer> ri = Range.is(10);
         assertEquals(ri.hashCode(), ri.hashCode()); 
          
         ri = Range.is(5); 
         assertEquals(ri.hashCode(), ri.hashCode()); 
     }
@Test
public void testEqualsHashcode369() { 
         final Range<Integer> ri1 = Range.is(10); 
         final Range<Integer> ri2 = Range.is(10); 
         assertEquals(ri1, ri2); 
         assertEquals(ri1.hashCode(), ri2.hashCode()); 
         ri1.hashCode(); 
         ri2.hashCode(); 
         assertFalse(ri1.equals(ri2)); 
     }
@Test
public void testEqualsHashcode370() { 
         final Range<Integer> ri1 = Range.is(10); 
         final Range<Integer> ri2 = Range.is(10); 
         assertEquals(ri1, ri2); 
         assertEquals(ri1.hashCode(), ri2.hashCode()); 
         ri1.hashCode(); 
         ri2.hashCode(); 
         assertFalse(ri1.equals(ri2)); 
     }
@Test
public void testHashCode371() { 
          Range<Integer> ri = Range.is(10);
         assertEquals(ri.hashCode(), ri.hashCode()); 
          
         ri = Range.is(5); 
         assertEquals(ri.hashCode(), ri.hashCode()); 
     }
@Test
public void testEqualsHashcode372() { 
         final Range<Integer> ri1 = Range.is(10); 
         final Range<Integer> ri2 = Range.is(10); 
         assertEquals(ri1, ri2); 
         assertEquals(ri1.hashCode(), ri2.hashCode()); 
         ri1.hashCode(); 
         ri2.hashCode(); 
         assertFalse(ri1.equals(ri2)); 
     }
@Test
public void testHashCode373() { 
          Range<Integer> ri = Range.is(10);
         assertEquals(ri.hashCode(), ri.hashCode()); 
          
         ri = Range.is(5); 
         assertEquals(ri.hashCode(), ri.hashCode()); 
     }
@Test
public void testIsBeforeRange1564() { 
         assertFalse(intRange.isBeforeRange(null)); 
          
         assertTrue(intRange.isBeforeRange(Range.between(5, 9))); 
         assertFalse(intRange.isBeforeRange(Range.between(5, 10))); 
         assertFalse(intRange.isBeforeRange(Range.between(5, 20))); 
         assertFalse(intRange.isBeforeRange(Range.between(5, 25))); 
     }
@Test
public void testIsWithCompare1565() { 
         final Comparator<Integer> c = new Comparator<Integer>(){ 
             @Override 
             public int compare(final Integer o1, final Integer o2) { 
                 return 0; // all integers are equal 
             } 
         }; 
         Range<Integer> ri = Range.is(10); 
         assertFalse("should not contain null",ri.contains(null)); 
         assertTrue("should contain 10",ri.contains(10)); 
         ri = Range.is(10,c); 
         assertFalse("should not contain null",ri.contains(null)); 
         assertTrue("should contain 10",ri.contains(10)); 
     }
@Test
public void testIsWithCompare1566(){ 
         final Comparator<Integer> c = new Comparator<Integer>(){ 
             @Override 
             public int compare(final Integer o1, final Integer o2) { 
                 return 0; // all integers are equal 
             } 
         }; 
         Range<Integer> ri = Range.is(10); 
         assertFalse("should not contain null",ri.contains(null)); 
         assertTrue("should contain 10",ri.contains(10)); 
         ri = Range.is(10,c); 
         assertFalse("should not contain null",ri.contains(null)); 
         assertTrue("should contain 10",ri.contains(10)); 
     }
@Test
public void testIsBeforeRange1567() { 
         assertFalse(intRange.isBeforeRange(null)); 
          
         assertTrue(intRange.isBeforeRange(Range.between(5, 9))); 
         assertFalse(intRange.isBeforeRange(Range.between(5, 10))); 
         assertFalse(intRange.isBeforeRange(Range.between(5, 20))); 
         assertFalse(intRange.isBeforeRange(Range.between(5, 25))); 
     }
@Test
public void testIsWithCompare1568() { 
         final Comparator<Integer> c = new Comparator<Integer>(){ 
             @Override 
             public int compare(final Integer o1, final Integer o2) { 
                 return 0; // all integers are equal 
             } 
         }; 
         Range<Integer> ri = Range.is(10); 
         assertFalse("should not contain null",ri.contains(null)); 
         assertTrue("should contain 10",ri.contains(10)); 
         ri = Range.is(10,c); 
         assertFalse("should not contain null",ri.contains(null)); 
         assertTrue("should contain 10",ri.contains(10)); 
     }
@Test
public void testIsBeforeRange1569() { 
         assertFalse(intRange.isBeforeRange(null)); 
          
         assertTrue(intRange.isBeforeRange(Range.between(5, 9))); 
         assertFalse(intRange.isBeforeRange(Range.between(5, 10))); 
         assertFalse(intRange.isBeforeRange(Range.between(5, 20))); 
         assertFalse(intRange.isBeforeRange(Range.between(5, 25))); 
     }
@Test
public void testIsWithCompare1570() { 
         final Comparator<Integer> c = new Comparator<Integer>(){ 
             @Override 
             public int compare(final Integer o1, final Integer o2) { 
                 return 0; // all integers are equal 
             } 
         }; 
         Range<Integer> ri = Range.is(10); 
         assertFalse("should not contain null",ri.contains(null)); 
         assertTrue("should contain 10",ri.contains(10)); 
         ri = Range.is(10,c); 
         assertFalse("should not contain null",ri.contains(null)); 
         assertTrue("should contain 10",ri.contains(10)); 
     }
@Test
public void testIsBeforeRange1571() { 
         assertFalse(intRange.isBeforeRange(null)); 
          
         assertTrue(intRange.isBeforeRange(Range.between(5, 9))); 
         assertFalse(intRange.isBeforeRange(Range.between(5, 10))); 
         assertFalse(intRange.isBeforeRange(Range.between(5, 20))); 
         assertFalse(intRange.isBeforeRange(Range.between(5, 25))); 
     }
@Test
public void testIsWithCompare1572() { 
         final Comparator<Integer> c = new Comparator<Integer>(){ 
             @Override 
             public int compare(final Integer o1, final Integer o2) { 
                 return 0; // all integers are equal 
             } 
         }; 
         Range<Integer> ri = Range.is(10); 
         assertFalse("should not contain null",ri.contains(null)); 
         assertTrue("should contain 10",ri.contains(10)); 
         ri = Range.is(10,c); 
         assertFalse("should not contain null",ri.contains(null)); 
         assertTrue("should contain 10",ri.contains(10)); 
     }
@Test
public void testIsWithCompare1573(){ 
         final Comparator<Integer> c = new Comparator<Integer>(){ 
             @Override 
             public int compare(final Integer o1, final Integer o2) { 
                 return 0; // all integers are equal 
             } 
         }; 
         Range<Integer> ri = Range.is(10); 
         assertFalse("should not contain null",ri.contains(null)); 
         assertTrue("should contain 10",ri.contains(10)); 
         ri = Range.is(10,c); 
         assertFalse("should not contain null",ri.contains(null)); 
         assertTrue("should contain 10",ri.contains(10)); 
     }
@Test
public void testIsWithCompare1574() { 
         final Comparator<Integer> c = new Comparator<Integer>(){ 
             @Override 
             public int compare(final Integer o1, final Integer o2) { 
                 return 0; // all integers are equal 
             } 
         }; 
         Range<Integer> ri = Range.is(10); 
         assertFalse("should not contain null",ri.contains(null)); 
         assertTrue("should contain 10",ri.contains(10)); 
         ri = Range.is(10,c); 
         assertFalse("should not contain null",ri.contains(null)); 
         assertTrue("should contain 10",ri.contains(10)); 
     }
//@Test
//public void testCompareObject1575() {
//         final Object o1 = new Object();
//         final Object o2 = new Object();
//         final Comparator<Object> c = new Comparator<Object>(){
//             @Override
//             public int compare(final Object o1, final Object o2) {
//                 return 0; // all integers are equal
//             }
//         };
//         Range<Object> ri = Range.is(o1);
//         assertEquals(-1, ri.compare(o1, o1));
//         assertEquals(0, ri.compare(o1, o2));
//
//         ri = Range.is(null);
//         assertEquals(-1, ri.compare(null, o1));
//         assertEquals(-1, ri.compare(null, o2));
//     }
//@Test
//public void testCompare1576() {
//         final Comparator<Integer> c = new Comparator<Integer>(){
//             @Override
//             public int compare(final Integer o1, final Integer o2) {
//                 return 0; // all integers are equal
//             }
//         };
//         Range<Integer> ri = Range.is(10);
//         assertEquals(-1, ri.compare(null, null));
//         assertEquals(-1, ri.compare(null, "Ni!"));
//
//         ri = Range.is(10,c);
//         assertEquals(0, ri.compare(null, "Ni!"));
//         assertEquals(+1, ri.compare("Ni!"));
//     }
@Test
public void testIsBeforeRange1577() { 
         assertFalse(intRange.isBeforeRange(null)); 
          
         assertTrue(intRange.isBeforeRange(Range.between(5, 9))); 
         assertFalse(intRange.isBeforeRange(Range.between(5, 10))); 
         assertFalse(intRange.isBeforeRange(Range.between(5, 20))); 
         assertFalse(intRange.isBeforeRange(Range.between(5, 25))); 
     }
@Test
public void testBetween1578() { 
         final Integer low = Integer.valueOf(10); 
         final Integer mid = Integer.valueOf(11); 
         final Integer high = Integer.valueOf(12); 
          Range<Integer> ri = Range.between(low, mid);
         assertFalse("should not contain null",ri.contains(null)); 
         assertTrue("should contain 0",ri.contains(0)); 
         assertTrue("should contain 1",ri.contains(1)); 
         assertTrue("should contain 2",ri.contains(2)); 
          
         ri = Range.between(low, mid); 
         assertFalse("should not contain null",ri.contains(null)); 
         assertTrue("should contain 0",ri.contains(0)); 
         assertTrue("should contain 1",ri.contains(1)); 
     }
@Test
public void testIsWithCompare1579() { 
         final Comparator<Integer> c = new Comparator<Integer>(){ 
             @Override 
             public int compare(final Integer o1, final Integer o2) { 
                 return 0; // all integers are equal 
             } 
         }; 
         Range<Integer> ri = Range.is(10); 
         assertFalse("should not contain null",ri.contains(null)); 
         assertTrue("should contain 10",ri.contains(10)); 
         ri = Range.is(10,c); 
         assertFalse("should not contain null",ri.contains(null)); 
         assertTrue("should contain 10",ri.contains(10)); 
     }
@Test
public void testIsBeforeRange1580() { 
         assertFalse(intRange.isBeforeRange(null)); 
          
         assertTrue(intRange.isBeforeRange(Range.between(5, 9))); 
         assertFalse(intRange.isBeforeRange(Range.between(5, 10))); 
         assertFalse(intRange.isBeforeRange(Range.between(5, 20))); 
         assertFalse(intRange.isBeforeRange(Range.between(5, 25))); 
     }
@Test
public void testIsWithCompare1581() { 
         final Comparator<Integer> c = new Comparator<Integer>(){ 
             @Override 
             public int compare(final Integer o1, final Integer o2) { 
                 return 0; // all integers are equal 
             } 
         }; 
         Range<Integer> ri = Range.is(10); 
         assertFalse("should not contain null",ri.contains(null)); 
         assertTrue("should contain 10",ri.contains(10)); 
         ri = Range.is(10,c); 
         assertFalse("should not contain null",ri.contains(null)); 
         assertTrue("should contain 10",ri.contains(10)); 
     }
@Test
public void testIsWithCompare1582(){ 
         final Comparator<Integer> c = new Comparator<Integer>(){ 
             @Override 
             public int compare(final Integer o1, final Integer o2) { 
                 return 0; // all integers are equal 
             } 
         }; 
         Range<Integer> ri = Range.is(10); 
         assertFalse("should not contain null",ri.contains(null)); 
         assertTrue("should contain 10",ri.contains(10)); 
         ri = Range.is(10,c); 
         assertFalse("should not contain null",ri.contains(null)); 
         assertTrue("should contain 10",ri.contains(10)); 
     }
@Test
public void testIsBeforeRange1583() { 
         assertFalse(intRange.isBeforeRange(null)); 
          
         assertTrue(intRange.isBeforeRange(Range.between(5, 9))); 
         assertFalse(intRange.isBeforeRange(Range.between(5, 10))); 
         assertFalse(intRange.isBeforeRange(Range.between(5, 20))); 
         assertFalse(intRange.isBeforeRange(Range.between(5, 25))); 
     }
    

    

    

    //-----------------------------------------------------------------------
    

    //-----------------------------------------------------------------------
    

    

    

    

    //-----------------------------------------------------------------------
    

    

    

    

    

    

    

    

    //-----------------------------------------------------------------------
    

    

    

    

    

    

    

    //-----------------------------------------------------------------------
    

}
