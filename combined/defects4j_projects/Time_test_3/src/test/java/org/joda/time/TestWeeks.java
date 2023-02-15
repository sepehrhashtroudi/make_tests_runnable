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
 * This class is a Junit unit test for Weeks.
 *
 * @author Stephen Colebourne
 */
public class TestWeeks extends TestCase {
    // Test in 2002/03 as time zones are more well known
    // (before the late 90's they were all over the place)
    private static final DateTimeZone PARIS = DateTimeZone.forID("Europe/Paris");

    public static void main(String[] args) {
        junit.textui.TestRunner.run(suite());
    }

    public static TestSuite suite() {
        return new TestSuite(TestWeeks.class);
    }

    public TestWeeks(String name) {
        super(name);
    }

    protected void setUp() throws Exception {
    }

    protected void tearDown() throws Exception {
    }

    //-----------------------------------------------------------------------
public void testFactory_standardWeeksIn_RPeriod216() { 
     assertEquals(0, Weeks.standardWeeksIn((ReadablePeriod) null).getWeeks()); 
     assertEquals(0, Weeks.standardWeeksIn(Period.ZERO).getWeeks()); 
     assertEquals(1, Weeks.standardWeeksIn(new Period(0, 0, 0, 0, 1, 0, 0, 0)).getWeeks()); 
     assertEquals(123, Weeks.standardWeeksIn(Period.hours(123)).getWeeks()); 
     assertEquals(-987, Weeks.standardWeeksIn(Period.hours(-987)).getWeeks()); 
     assertEquals(1, Weeks.standardWeeksIn(Period.minutes(119)).getWeeks()); 
     assertEquals(2, Weeks.standardWeeksIn(Period.minutes(120)).getWeeks()); 
     assertEquals(2, Weeks.standardWeeksIn(Period.minutes(121)).getWeeks()); 
     assertEquals(120, Weeks.standardWeeksIn(Period.hours(2)).getWeeks()); 
     try { 
         Weeks.standardWeeksIn(Period.months(1)); 
         fail(); 
     } catch (IllegalArgumentException ex) { 
     } 
 }
public void testToStandardDays217() { 
     Weeks test = Weeks.weeks(2); 
     Days expected = Days.days(2 * 7 * 24 * 60 * 60); 
     assertEquals(expected, test.toStandardDays()); 
     try { 
         Weeks.MAX_VALUE.toStandardDays(); 
         fail(); 
     } catch (ArithmeticException ex) { 
     } 
 }
public void testNegated218() { 
     Weeks test = Weeks.weeks(12); 
     assertEquals(-12, test.negated().getWeeks()); 
     assertEquals(12, test.getWeeks()); 
     try { 
         Weeks.MIN_VALUE.negated(); 
         fail(); 
     } catch (ArithmeticException ex) { 
     } 
 }
public void testIsGreaterThan219() { 
     assertEquals(true, Weeks.THREE.isGreaterThan(Weeks.TWO)); 
     assertEquals(false, Weeks.THREE.isGreaterThan(Weeks.THREE)); 
     assertEquals(false, Weeks.TWO.isGreaterThan(Weeks.THREE)); 
     assertEquals(true, Weeks.ONE.isGreaterThan(null)); 
     assertEquals(false, Weeks.weeks(-1).isGreaterThan(null)); 
 }
public void testGetPeriodType533() { 
     Days test = Days.days(20); 
     assertEquals(PeriodType.days(), test.getPeriodType()); 
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
