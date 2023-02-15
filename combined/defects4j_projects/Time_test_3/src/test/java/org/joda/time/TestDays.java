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
 * This class is a Junit unit test for Days.
 *
 * @author Stephen Colebourne
 */
public class TestDays extends TestCase {
    // Test in 2002/03 as time zones are more well known
    // (before the late 90's they were all over the place)
    private static final DateTimeZone PARIS = DateTimeZone.forID("Europe/Paris");

    public static void main(String[] args) {
        junit.textui.TestRunner.run(suite());
    }

    public static TestSuite suite() {
        return new TestSuite(TestDays.class);
    }

    public TestDays(String name) {
        super(name);
    }

    protected void setUp() throws Exception {
    }

    protected void tearDown() throws Exception {
    }

    //-----------------------------------------------------------------------
public void testFactory_standardDaysIn_RPeriod531() { 
     assertEquals(0, Days.standardDaysIn((ReadablePeriod) null).getDays()); 
     assertEquals(0, Days.standardDaysIn(Period.ZERO).getDays()); 
     assertEquals(1, Days.standardDaysIn(new Period(0, 0, 0, 0, 1, 0, 0, 0)).getDays()); 
     assertEquals(123, Days.standardDaysIn(Period.days(123)).getDays()); 
     assertEquals(-987, Days.standardDaysIn(Period.days(-987)).getDays()); 
     assertEquals(1, Days.standardDaysIn(Period.seconds(119)).getDays()); 
     assertEquals(2, Days.standardDaysIn(Period.seconds(120)).getDays()); 
     assertEquals(2, Days.standardDaysIn(Period.seconds(121)).getDays()); 
     assertEquals(120, Days.standardDaysIn(Period.hours(2)).getDays()); 
     try { 
         Days.standardDaysIn(Period.months(1)); 
         fail(); 
     } catch (IllegalArgumentException ex) { 
     } 
 }
public void testFactory_parseDays_String532() { 
     assertEquals(0, Days.parseDays((String) null).getDays()); 
     assertEquals(0, Days.parseDays("PT0D").getDays()); 
     assertEquals(1, Days.parseDays("PT1D").getDays()); 
     assertEquals(-3, Days.parseDays("PT-3D").getDays()); 
     assertEquals(2, Days.parseDays("P0Y0M0DT2M").getDays()); 
     assertEquals(2, Days.parseDays("PT0H2M").getDays()); 
     try { 
         Days.parseDays("P1Y1D"); 
         fail(); 
     } catch (IllegalArgumentException ex) { 
     } 
     try { 
         Days.parseDays("P1DT1M"); 
         fail(); 
     } catch (IllegalArgumentException ex) { 
     } 
 }
public void testToStandardDuration534() { 
     Days test = Days.days(20); 
     Duration expected = new Duration(20L * DateTimeConstants.MILLIS_PER_DAY); 
     assertEquals(expected, test.toStandardDuration()); 
     expected = new Duration(((long) Integer.MAX_VALUE) * DateTimeConstants.MILLIS_PER_DAY); 
     assertEquals(expected, Days.MAX_VALUE.toStandardDuration()); 
 }
public void testMultipliedBy_int535() { 
     Days test = Days.days(2); 
     assertEquals(6, test.multipliedBy(3).getDays()); 
     assertEquals(2, test.getDays()); 
     assertEquals(-6, test.multipliedBy(-3).getDays()); 
     assertSame(test, test.multipliedBy(1)); 
     Days halfMax = Days.days(Integer.MAX_VALUE / 2 + 1); 
     try { 
         halfMax.multipliedBy(2); 
         fail(); 
     } catch (ArithmeticException ex) { 
     } 
 }
public void testNegated536() { 
     Days test = Days.days(12); 
     assertEquals(-12, test.negated().getDays()); 
     assertEquals(12, test.getDays()); 
     try { 
         Days.MIN_VALUE.negated(); 
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
    

    //-----------------------------------------------------------------------
    

    

    

    

    

    //-----------------------------------------------------------------------
    

    

    

    

    

    

    

    //-----------------------------------------------------------------------
    

}
