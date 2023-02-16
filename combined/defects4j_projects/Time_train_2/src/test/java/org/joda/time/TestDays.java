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

public void testGetMethods1229() { 
     Days test = Days.days(20); 
     assertEquals(20, test.getDays()); 
 } 


@SuppressWarnings("deprecation") 
 public void testFactory_daysBetween_RPartial_LocalDate1230() { 
     LocalDate start = new LocalDate(2006, 6, 9); 
     LocalDate end1 = new LocalDate(2006, 6, 12); 
     YearMonthDay end2 = new YearMonthDay(2006, 6, 15); 
     assertEquals(3, Days.daysBetween(start, end1).getDays()); 
     assertEquals(0, Days.daysBetween(start, start).getDays()); 
     assertEquals(0, Days.daysBetween(end1, end1).getDays()); 
     assertEquals(-3, Days.daysBetween(end1, start).getDays()); 
     assertEquals(6, Days.daysBetween(start, end2).getDays()); 
 } 


public void testPlus_int1232() { 
     Days test2 = Days.days(2); 
     Days result = test2.plus(3); 
     assertEquals(2, test2.getDays()); 
     assertEquals(5, result.getDays()); 
     assertEquals(1, Days.ONE.plus(0).getDays()); 
     try { 
         Days.MAX_VALUE.plus(1); 
         fail(); 
     } catch (ArithmeticException ex) { 
     } 
 } 


public void testSerialization1233() throws Exception { 
     Days test = Days.SEVEN; 
     ByteArrayOutputStream baos = new ByteArrayOutputStream(); 
     ObjectOutputStream oos = new ObjectOutputStream(baos); 
     oos.writeObject(test); 
     byte[] bytes = baos.toByteArray(); 
     oos.close(); 
     ByteArrayInputStream bais = new ByteArrayInputStream(bytes); 
     ObjectInputStream ois = new ObjectInputStream(bais); 
     Days result = (Days) ois.readObject(); 
     ois.close(); 
     assertSame(test, result); 
 } 


public void testFactory_days_int1234() { 
     assertSame(Days.ZERO, Days.days(0)); 
     assertSame(Days.ONE, Days.days(1)); 
     assertSame(Days.TWO, Days.days(2)); 
     assertSame(Days.THREE, Days.days(3)); 
     assertSame(Days.FOUR, Days.days(4)); 
     assertSame(Days.FIVE, Days.days(5)); 
     assertSame(Days.SIX, Days.days(6)); 
     assertSame(Days.SEVEN, Days.days(7)); 
     assertSame(Days.MAX_VALUE, Days.days(Integer.MAX_VALUE)); 
     assertSame(Days.MIN_VALUE, Days.days(Integer.MIN_VALUE)); 
     assertEquals(-1, Days.days(-1).getDays()); 
     assertEquals(8, Days.days(8).getDays()); 
 } 


public void testFactory_daysBetween_RInstant1235() { 
     DateTime start = new DateTime(2006, 6, 9, 12, 0, 0, 0, PARIS); 
     DateTime end1 = new DateTime(2006, 6, 12, 12, 0, 0, 0, PARIS); 
     DateTime end2 = new DateTime(2006, 6, 15, 18, 0, 0, 0, PARIS); 
     assertEquals(3, Days.daysBetween(start, end1).getDays()); 
     assertEquals(0, Days.daysBetween(start, start).getDays()); 
     assertEquals(0, Days.daysBetween(end1, end1).getDays()); 
     assertEquals(-3, Days.daysBetween(end1, start).getDays()); 
     assertEquals(6, Days.daysBetween(start, end2).getDays()); 
 } 


public void testFactory_daysIn_RInterval1236() { 
     DateTime start = new DateTime(2006, 6, 9, 12, 0, 0, 0, PARIS); 
     DateTime end1 = new DateTime(2006, 6, 12, 12, 0, 0, 0, PARIS); 
     DateTime end2 = new DateTime(2006, 6, 15, 18, 0, 0, 0, PARIS); 
     assertEquals(0, Days.daysIn((ReadableInterval) null).getDays()); 
     assertEquals(3, Days.daysIn(new Interval(start, end1)).getDays()); 
     assertEquals(0, Days.daysIn(new Interval(start, start)).getDays()); 
     assertEquals(0, Days.daysIn(new Interval(end1, end1)).getDays()); 
     assertEquals(6, Days.daysIn(new Interval(start, end2)).getDays()); 
 } 


public void testFactory_standardDaysIn_RPeriod1237() { 
     assertEquals(0, Days.standardDaysIn((ReadablePeriod) null).getDays()); 
     assertEquals(0, Days.standardDaysIn(Period.ZERO).getDays()); 
     assertEquals(1, Days.standardDaysIn(new Period(0, 0, 0, 1, 0, 0, 0, 0)).getDays()); 
     assertEquals(123, Days.standardDaysIn(Period.days(123)).getDays()); 
     assertEquals(-987, Days.standardDaysIn(Period.days(-987)).getDays()); 
     assertEquals(1, Days.standardDaysIn(Period.hours(47)).getDays()); 
     assertEquals(2, Days.standardDaysIn(Period.hours(48)).getDays()); 
     assertEquals(2, Days.standardDaysIn(Period.hours(49)).getDays()); 
     assertEquals(14, Days.standardDaysIn(Period.weeks(2)).getDays()); 
     try { 
         Days.standardDaysIn(Period.months(1)); 
         fail(); 
     } catch (IllegalArgumentException ex) { 
     } 
 } 


public void testFactory_parseDays_String1238() { 
     assertEquals(0, Days.parseDays((String) null).getDays()); 
     assertEquals(0, Days.parseDays("P0D").getDays()); 
     assertEquals(1, Days.parseDays("P1D").getDays()); 
     assertEquals(-3, Days.parseDays("P-3D").getDays()); 
     assertEquals(2, Days.parseDays("P0Y0M2D").getDays()); 
     assertEquals(2, Days.parseDays("P2DT0H0M").getDays()); 
     try { 
         Days.parseDays("P1Y1D"); 
         fail(); 
     } catch (IllegalArgumentException ex) { 
     } 
     try { 
         Days.parseDays("P1DT1H"); 
         fail(); 
     } catch (IllegalArgumentException ex) { 
     } 
 } 


public void testToStandardWeeks1239() { 
     Days test = Days.days(14); 
     Weeks expected = Weeks.weeks(2); 
     assertEquals(expected, test.toStandardWeeks()); 
 } 


public void testToStandardMinutes1240() { 
     Days test = Days.days(2); 
     Minutes expected = Minutes.minutes(2 * 24 * 60); 
     assertEquals(expected, test.toStandardMinutes()); 
     try { 
         Days.MAX_VALUE.toStandardMinutes(); 
         fail(); 
     } catch (ArithmeticException ex) { 
     } 
 } 


public void testToStandardSeconds1241() { 
     Days test = Days.days(2); 
     Seconds expected = Seconds.seconds(2 * 24 * 60 * 60); 
     assertEquals(expected, test.toStandardSeconds()); 
     try { 
         Days.MAX_VALUE.toStandardSeconds(); 
         fail(); 
     } catch (ArithmeticException ex) { 
     } 
 } 


public void testToStandardDuration1242() { 
     Days test = Days.days(20); 
     Duration expected = new Duration(20L * DateTimeConstants.MILLIS_PER_DAY); 
     assertEquals(expected, test.toStandardDuration()); 
     expected = new Duration(((long) Integer.MAX_VALUE) * DateTimeConstants.MILLIS_PER_DAY); 
     assertEquals(expected, Days.MAX_VALUE.toStandardDuration()); 
 } 


public void testMinus_Days1243() { 
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


public void testMultipliedBy_int1244() { 
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


public void testDividedBy_int1245() { 
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


public void testNegated1246() { 
     Days test = Days.days(12); 
     assertEquals(-12, test.negated().getDays()); 
     assertEquals(12, test.getDays()); 
     try { 
         Days.MIN_VALUE.negated(); 
         fail(); 
     } catch (ArithmeticException ex) { 
     } 
 } 


public void testIsGreaterThan1247() { 
     assertEquals(true, Days.THREE.isGreaterThan(Days.TWO)); 
     assertEquals(false, Days.THREE.isGreaterThan(Days.THREE)); 
     assertEquals(false, Days.TWO.isGreaterThan(Days.THREE)); 
     assertEquals(true, Days.ONE.isGreaterThan(null)); 
     assertEquals(false, Days.days(-1).isGreaterThan(null)); 
 } 


public void testIsLessThan1248() { 
     assertEquals(false, Days.THREE.isLessThan(Days.TWO)); 
     assertEquals(false, Days.THREE.isLessThan(Days.THREE)); 
     assertEquals(true, Days.TWO.isLessThan(Days.THREE)); 
     assertEquals(false, Days.ONE.isLessThan(null)); 
     assertEquals(true, Days.days(-1).isLessThan(null)); 
 } 


public void testToString1249() { 
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
