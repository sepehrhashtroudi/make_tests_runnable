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
public void testFactory_standardHoursIn_RPeriod506() { 
     assertEquals(0, Hours.standardHoursIn((ReadablePeriod) null).getHours()); 
     assertEquals(0, Hours.standardHoursIn(Period.ZERO).getHours()); 
     assertEquals(1, Hours.standardHoursIn(new Period(0, 0, 0, 0, 0, 1, 0, 0)).getHours()); 
     assertEquals(123, Hours.standardHoursIn(Period.hours(123)).getHours()); 
     assertEquals(-987, Hours.standardHoursIn(Period.hours(-987)).getHours()); 
     assertEquals(1, Hours.standardHoursIn(Period.seconds(119)).getHours()); 
     assertEquals(2, Hours.standardHoursIn(Period.seconds(120)).getHours()); 
     assertEquals(2, Hours.standardHoursIn(Period.seconds(121)).getHours()); 
     assertEquals(120, Hours.standardHoursIn(Period.hours(121)).getHours()); 
     try { 
         Hours.standardHoursIn(Period.months(1)); 
         fail(); 
     } catch (IllegalArgumentException ex) { 
     } 
 }
public void testToStandardHours507() { 
     Weeks test = Weeks.weeks(2); 
     Hours expected = Hours.hours(2 * 7 * 24); 
     assertEquals(expected, test.toStandardHours()); 
     try { 
         Weeks.MAX_VALUE.toStandardHours(); 
         fail(); 
     } catch (ArithmeticException ex) { 
     } 
 }
public void testToStandardWeeks508() { 
     Hours test = Hours.hours(24 * 2); 
     Weeks expected = Weeks.weeks(2); 
     assertEquals(expected, test.toStandardWeeks()); 
 }
public void testToStandardSeconds509() { 
     Hours test = Hours.hours(3); 
     Seconds expected = Seconds.seconds(3 * 60); 
     assertEquals(expected, test.toStandardSeconds()); 
     try { 
         Hours.MAX_VALUE.toStandardSeconds(); 
         fail(); 
     } catch (ArithmeticException ex) { 
     } 
 }
public void testDividedBy_int510() { 
     Hours test = Hours.hours(12); 
     assertEquals(6, test.dividedBy(2).getHours()); 
     assertEquals(12, test.getHours()); 
     assertEquals(4, test.dividedBy(3).getHours()); 
     assertEquals(3, test.dividedBy(4).getHours()); 
     assertEquals(2, test.dividedBy(5).getHours()); 
     assertEquals(2, test.dividedBy(6).getHours()); 
     assertSame(test, test.dividedBy(1)); 
     try { 
         Hours.ONE.dividedBy(0); 
         fail(); 
     } catch (ArithmeticException ex) { 
     } 
 }
public void testToString588() { 
     Period test = new Period(1, 0, 0, 4, 5, 6, 7, 8, PeriodType.yearDayTime()); 
     assertEquals("1 year, 2 months, 3 weeks, 4 days, 5 hours, 6 minutes, 7 seconds and 8 milliseconds", test.toString()); 
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
