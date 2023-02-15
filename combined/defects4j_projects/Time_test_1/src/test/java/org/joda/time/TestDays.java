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
public void testGetMethods615() { 
     Days test = Days.days(20); 
     assertEquals(20, test.getDays()); 
 }
public void testPlus_Days617() { 
     Days test2 = Days.days(2); 
     Days test3 = Days.days(3); 
     Days result = test2.plus(test3); 
     assertEquals(2, test2.getDays()); 
     assertEquals(3, test3.getDays()); 
     assertEquals(5, result.getDays()); 
     assertEquals(1, Days.ONE.plus(Days.ZERO).getDays()); 
     assertEquals(1, Days.ONE.plus((Days) null).getDays()); 
     try { 
         Days.MAX_VALUE.plus(Days.ONE); 
         fail(); 
     } catch (ArithmeticException ex) { 
     } 
 }
@SuppressWarnings("deprecation") 
 public void testFactory_daysBetween_RPartial619() { 
     LocalDate start = new LocalDate(2006, 6, 9); 
     LocalDate end1 = new LocalDate(2006, 6, 12); 
     YearMonthDay end2 = new YearMonthDay(2006, 6, 15); 
     assertEquals(3, Days.daysBetween(start, end1).getDays()); 
     assertEquals(0, Days.daysBetween(start, start).getDays()); 
     assertEquals(0, Days.daysBetween(end1, end1).getDays()); 
     assertEquals(-3, Days.daysBetween(end1, start).getDays()); 
     assertEquals(6, Days.daysBetween(start, end2).getDays()); 
 }
public void testFactory_daysBetween_RPartial620() { 
     LocalDate start = new LocalDate(2006, 6, 9); 
     LocalDate end1 = new LocalDate(2006, 6, 12); 
     YearMonthDay end2 = new YearMonthDay(2006, 6, 15); 
     assertEquals(3, Days.daysBetween(start, end1).getDays()); 
     assertEquals(0, Days.daysBetween(start, start).getDays()); 
     assertEquals(0, Days.daysBetween(end1, end1).getDays()); 
     assertEquals(-3, Days.daysBetween(end1, start).getDays()); 
     assertEquals(6, Days.daysBetween(start, end2).getDays()); 
 }
public void testToStandardDays621() { 
     Weeks test = Weeks.weeks(2); 
     Days expected = Days.days(14); 
     assertEquals(expected, test.toStandardDays()); 
     try { 
         Weeks.MAX_VALUE.toStandardDays(); 
         fail(); 
     } catch (ArithmeticException ex) { 
     } 
 }
public void testToStandardSeconds622() { 
     Days test = Days.days(2); 
     Seconds expected = Seconds.seconds(2 * 24 * 60); 
     assertEquals(expected, test.toStandardSeconds()); 
     try { 
         Days.MAX_VALUE.toStandardSeconds(); 
         fail(); 
     } catch (ArithmeticException ex) { 
     } 
 }
public void testMinus_Days623() { 
     Days test2 = Days.days(2); 
     Days test3 = Days.days(3); 
     Days result = test2.minus(test3); 
     assertEquals(2, test2.getDays()); 
     assertEquals(3, test3.getDays()); 
     assertEquals(-1, result.getDays()); 
     assertEquals(1, Days.ONE.minus(Days.ZERO).getDays()); 
     assertEquals(1, Days.ONE.minus((Days) null).getDays()); 
     try { 
         Days.MIN_VALUE.minus(Days.ONE); 
         fail(); 
     } catch (ArithmeticException ex) { 
     } 
 }
public void testDividedBy_int624() { 
     Days test = Days.days(12); 
     assertEquals(6, test.dividedBy(2).getDays()); 
     assertEquals(12, test.getDays()); 
     assertEquals(4, test.dividedBy(3).getDays()); 
     assertEquals(3, test.dividedBy(4).getDays()); 
     assertEquals(2, test.dividedBy(5).getDays()); 
     assertEquals(2, test.dividedBy(6).getDays()); 
     assertSame(test, test.dividedBy(1)); 
     try { 
         Days.ONE.dividedBy(0); 
         fail(); 
     } catch (ArithmeticException ex) { 
     } 
 }
public void testToString625() { 
     Days test = Days.days(20); 
     assertEquals("P20D", test.toString()); 
     test = Days.days(-20); 
     assertEquals("P-20D", test.toString()); 
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
