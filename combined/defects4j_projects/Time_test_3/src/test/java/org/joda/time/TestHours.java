/*
 *  Copyright 2001-2013 Stephen Colebourne
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package org.joda.time;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * This class is a Junit unit test for Hours.
 *
 * @author Stephen Colebourne
 */
public class TestHours extends TestCase {
    // Test in 2002/03 as time zones are more well known
    // (before the late 90's they were all over the place)
    private static final DateTimeZone PARIS = DateTimeZone.forID("Europe/Paris");

    public static void main(String[] args) {
        junit.textui.TestRunner.run(suite());
    }

    public static TestSuite suite() {
        return new TestSuite(TestHours.class);
    }

    public TestHours(String name) {
        super(name);
    }

    protected void setUp() throws Exception {
    }

    protected void tearDown() throws Exception {
    }

    //-----------------------------------------------------------------------
public void testFactory_hoursBetween_RInstant467() { 
     DateTime start = new DateTime(2006, 6, 9, 12, 0, 0, PARIS); 
     DateTime end1 = new DateTime(2006, 6, 12, 12, 0, 0, PARIS); 
     DateTime end2 = new DateTime(2006, 6, 15, 18, 0, 0, PARIS); 
     assertEquals(3, Hours.hoursBetween(start, end1).getHours()); 
     assertEquals(0, Hours.hoursBetween(start, start).getHours()); 
     assertEquals(0, Hours.hoursBetween(end1, end1).getHours()); 
     assertEquals(-3, Hours.hoursBetween(end1, start).getHours()); 
     assertEquals(6, Hours.hoursBetween(start, end2).getHours()); 
 }
public void testFactory_hoursIn_RInterval468() { 
     DateTime start = new DateTime(2006, 6, 9, 12, 0, 0, PARIS); 
     DateTime end1 = new DateTime(2006, 6, 9, 12, 0, 0, PARIS); 
     DateTime end2 = new DateTime(2006, 6, 9, 12, 0, 0, PARIS); 
     assertEquals(0, Hours.hoursIn((ReadableInterval) null).getHours()); 
     assertEquals(3, Hours.hoursIn(new Interval(start, end1)).getHours()); 
     assertEquals(0, Hours.hoursIn(new Interval(start, start)).getHours()); 
     assertEquals(0, Hours.hoursIn(new Interval(end1, end1)).getHours()); 
     assertEquals(6, Hours.hoursIn(new Interval(start, end2)).getHours()); 
 }
public void testFactory_hoursIn_RInterval469() { 
     DateTime start = new DateTime(2006, 6, 9, 12, 0, 0, PARIS); 
     DateTime end1 = new DateTime(2006, 6, 12, 12, 0, 0, PARIS); 
     DateTime end2 = new DateTime(2006, 6, 15, 18, 0, 0, PARIS); 
     assertEquals(0, Hours.hoursIn((ReadableInterval) null).getHours()); 
     assertEquals(3, Hours.hoursIn(new Interval(start, end1)).getHours()); 
     assertEquals(0, Hours.hoursIn(new Interval(start, start)).getHours()); 
     assertEquals(0, Hours.hoursIn(new Interval(end1, end1)).getHours()); 
     assertEquals(6, Hours.hoursIn(new Interval(start, end2)).getHours()); 
 }
public void testToStandardMinutes471() { 
     Hours test = Hours.hours(3); 
     Minutes expected = Minutes.minutes(3 * 60); 
     assertEquals(expected, test.toStandardMinutes()); 
     try { 
         Hours.MAX_VALUE.toStandardMinutes(); 
         fail(); 
     } catch (ArithmeticException ex) { 
     } 
 }
public void testMinus_Hours472() { 
     Hours test2 = Hours.hours(2); 
     Hours test3 = Hours.hours(3); 
     Hours result = test2.minus(test3); 
     assertEquals(2, test2.getHours()); 
     assertEquals(3, test3.getHours()); 
     assertEquals(-1, result.getHours()); 
     assertEquals(1, Hours.ONE.minus(Hours.ZERO).getHours()); 
     assertEquals(1, Hours.ONE.minus((Hours) null).getHours()); 
     try { 
         Hours.MIN_VALUE.minus(Hours.ONE); 
         fail(); 
     } catch (ArithmeticException ex) { 
     } 
 }
public void testToString473() { 
     Hours test = Hours.hours(20); 
     assertEquals("PT20H", test.toString()); 
     test = Hours.hours(-20); 
     assertEquals("PT-20H", test.toString()); 
 }
    

    //-----------------------------------------------------------------------
    

    //-----------------------------------------------------------------------
    

    

    

    

    

    //-----------------------------------------------------------------------
    

    

    

    //-----------------------------------------------------------------------
    

    

    //-----------------------------------------------------------------------
    

    //-----------------------------------------------------------------------
    

    //-----------------------------------------------------------------------
    

    

    

    

    

    //-----------------------------------------------------------------------
    

    

    

    

    

    

    

    //-----------------------------------------------------------------------
    

}
