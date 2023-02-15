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
 * This class is a Junit unit test for Minutes.
 *
 * @author Stephen Colebourne
 */
public class TestMinutes extends TestCase {
    // Test in 2002/03 as time zones are more well known
    // (before the late 90's they were all over the place)
    private static final DateTimeZone PARIS = DateTimeZone.forID("Europe/Paris");

    public static void main(String[] args) {
        junit.textui.TestRunner.run(suite());
    }

    public static TestSuite suite() {
        return new TestSuite(TestMinutes.class);
    }

    public TestMinutes(String name) {
        super(name);
    }

    protected void setUp() throws Exception {
    }

    protected void tearDown() throws Exception {
    }

    //-----------------------------------------------------------------------
public void testToStandardMinutes319() { 
     Duration test = new Duration(0L); 
     assertEquals(Minutes.minutes(0), test.toStandardMinutes()); 
     test = new Duration(1L); 
     assertEquals(Minutes.minutes(0), test.toStandardMinutes()); 
     test = new Duration(60000L - 1); 
     assertEquals(Minutes.minutes(0), test.toStandardMinutes()); 
     test = new Duration(60000L); 
     assertEquals(Minutes.minutes(1), test.toStandardMinutes()); 
     test = new Duration(60000L + 1); 
     assertEquals(Minutes.minutes(1), test.toStandardMinutes()); 
     test = new Duration(2 * 60000L - 1); 
     assertEquals(Minutes.minutes(1), test.toStandardMinutes()); 
     test = new Duration(2 * 60000L); 
     assertEquals(Minutes.minutes(2), test.toStandardMinutes()); 
     test = new Duration(-1L); 
     assertEquals(Minutes.minutes(0), test.toStandardMinutes()); 
     test = new Duration(-60000L + 1); 
     assertEquals(Minutes.minutes(0), test.toStandardMinutes()); 
     test = new Duration(-60000L); 
     assertEquals(Minutes.minutes(-1), test.toStandardMinutes()); 
 }
public void testFactory_minutesIn_RInterval430() { 
     DateTime start = new DateTime(2006, 6, 9, 12, 3, 0, 0, PARIS); 
     DateTime end1 = new DateTime(2006, 6, 9, 12, 6, 0, 0, PARIS); 
     DateTime end2 = new DateTime(2006, 6, 9, 12, 9, 0, 0, PARIS); 
     assertEquals(0, Minutes.minutesIn((ReadableInterval) null).getMinutes()); 
     assertEquals(3, Minutes.minutesIn(new Interval(start, end1)).getMinutes()); 
     assertEquals(0, Minutes.minutesIn(new Interval(start, start)).getMinutes()); 
     assertEquals(0, Minutes.minutesIn(new Interval(end1, end1)).getMinutes()); 
     assertEquals(6, Minutes.minutesIn(new Interval(start, end2)).getMinutes()); 
 }
public void testFactory_minutesBetween_RPartial431() { 
     LocalTime start = new LocalTime(12, 3); 
     LocalTime end1 = new LocalTime(12, 6); 
     @SuppressWarnings("deprecation") 
     TimeOfDay end2 = new TimeOfDay(12, 9); 
     assertEquals(3, Minutes.minutesBetween(start, end1).getMinutes()); 
     assertEquals(0, Minutes.minutesBetween(start, start).getMinutes()); 
     assertEquals(0, Minutes.minutesBetween(end1, end1).getMinutes()); 
     assertEquals(-3, Minutes.minutesBetween(end1, start).getMinutes()); 
     assertEquals(6, Minutes.minutesBetween(start, end2).getMinutes()); 
 }
public void testToStandardDuration432() { 
     Minutes test = Minutes.minutes(20); 
     Duration expected = new Duration(20L * DateTimeConstants.MILLIS_PER_MINUTE); 
     assertEquals(expected, test.toStandardDuration()); 
     expected = new Duration(((long) Integer.MAX_VALUE) * DateTimeConstants.MILLIS_PER_MINUTE); 
     assertEquals(expected, Minutes.MAX_VALUE.toStandardDuration()); 
 }
public void testDividedBy_int433() { 
     Minutes test = Minutes.minutes(12); 
     assertEquals(6, test.dividedBy(2).getMinutes()); 
     assertEquals(12, test.getMinutes()); 
     assertEquals(4, test.dividedBy(3).getMinutes()); 
     assertEquals(3, test.dividedBy(4).getMinutes()); 
     assertEquals(2, test.dividedBy(5).getMinutes()); 
     assertEquals(2, test.dividedBy(6).getMinutes()); 
     assertSame(test, test.dividedBy(1)); 
     try { 
         Minutes.ONE.dividedBy(0); 
         fail(); 
     } catch (ArithmeticException ex) { 
     } 
 }
public void testNegated434() { 
     Minutes test = Minutes.minutes(12); 
     assertEquals(-12, test.negated().getMinutes()); 
     assertEquals(12, test.getMinutes()); 
     try { 
         Minutes.MIN_VALUE.negated(); 
         fail(); 
     } catch (ArithmeticException ex) { 
     } 
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
