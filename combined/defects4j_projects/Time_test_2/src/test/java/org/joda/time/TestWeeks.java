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
public void testFactory_weeks_int240() { 
     assertSame(Weeks.ZERO, Weeks.weeks(0)); 
     assertSame(Weeks.ONE, Weeks.weeks(1)); 
     assertSame(Weeks.TWO, Weeks.weeks(2)); 
     assertSame(Weeks.THREE, Weeks.weeks(3)); 
     assertSame(Weeks.MAX_VALUE, Weeks.weeks(Integer.MAX_VALUE)); 
     assertSame(Weeks.MIN_VALUE, Weeks.weeks(Integer.MIN_VALUE)); 
     assertEquals(-1, Weeks.weeks(-1).getWeeks()); 
     assertEquals(4, Weeks.weeks(4).getWeeks()); 
 }
public void testMinus_int241() { 
     Weeks test2 = Weeks.weeks(2); 
     Weeks result = test2.minus(3); 
     assertEquals(2, test2.getWeeks()); 
     assertEquals(-1, result.getWeeks()); 
     assertEquals(1, Weeks.ONE.minus(0).getWeeks()); 
     try { 
         Weeks.MIN_VALUE.minus(1); 
         fail(); 
     } catch (ArithmeticException ex) { 
     } 
 }
public void testFactory_weeksBetween_RInstant242() { 
     DateTime start = new DateTime(2006, 6, 9, 12, 0, 0, 0, PARIS); 
     DateTime end1 = new DateTime(2006, 6, 30, 12, 0, 0, 0, PARIS); 
     DateTime end2 = new DateTime(2006, 7, 21, 12, 0, 0, 0, PARIS); 
     assertEquals(3, Weeks.weeksBetween(start, end1).getWeeks()); 
     assertEquals(0, Weeks.weeksBetween(start, start).getWeeks()); 
     assertEquals(0, Weeks.weeksBetween(end1, end1).getWeeks()); 
     assertEquals(-3, Weeks.weeksBetween(end1, start).getWeeks()); 
     assertEquals(6, Weeks.weeksBetween(start, end2).getWeeks()); 
 }
public void testFactory_parseWeeks_String244() { 
     assertEquals(0, Weeks.parseWeeks((String) null).getWeeks()); 
     assertEquals(0, Weeks.parseWeeks("P0W").getWeeks()); 
     assertEquals(1, Weeks.parseWeeks("P1W").getWeeks()); 
     assertEquals(-3, Weeks.parseWeeks("P-3W").getWeeks()); 
     assertEquals(2, Weeks.parseWeeks("P0Y0M2W").getWeeks()); 
     assertEquals(2, Weeks.parseWeeks("P2W0M").getWeeks()); 
     assertEquals(14, Weeks.parseWeeks("P14W").getWeeks()); 
     try { 
         Weeks.parseWeeks("P1Y1D"); 
         fail(); 
     } catch (IllegalArgumentException ex) { 
     } 
     try { 
         Weeks.parseWeeks("P1DT1S"); 
         fail(); 
     } catch (IllegalArgumentException ex) { 
     } 
 }
public void testSerialization246() throws Exception { 
     Weeks test = Weeks.THREE; 
     ByteArrayOutputStream baos = new ByteArrayOutputStream(); 
     ObjectOutputStream oos = new ObjectOutputStream(baos); 
     oos.writeObject(test); 
     byte[] bytes = baos.toByteArray(); 
     oos.close(); 
     ByteArrayInputStream bais = new ByteArrayInputStream(bytes); 
     ObjectInputStream ois = new ObjectInputStream(bais); 
     Weeks result = (Weeks) ois.readObject(); 
     ois.close(); 
     assertSame(test, result); 
 }
public void testFactory_weeksBetween_RPartial247() { 
     LocalDate start = new LocalDate(2006, 6, 9); 
     LocalDate end1 = new LocalDate(2006, 6, 30); 
     YearMonthDay end2 = new YearMonthDay(2006, 7, 21); 
     assertEquals(3, Weeks.weeksBetween(start, end1).getWeeks()); 
     assertEquals(0, Weeks.weeksBetween(start, start).getWeeks()); 
     assertEquals(0, Weeks.weeksBetween(end1, end1).getWeeks()); 
     assertEquals(-3, Weeks.weeksBetween(end1, start).getWeeks()); 
     assertEquals(6, Weeks.weeksBetween(start, end2).getWeeks()); 
 }
public void testToStandardHours248() { 
     Weeks test = Weeks.weeks(2); 
     Hours expected = Hours.hours(2 * 7 * 24 * 60 * 60); 
     assertEquals(expected, test.toStandardHours()); 
     try { 
         Weeks.MAX_VALUE.toStandardHours(); 
         fail(); 
     } catch (ArithmeticException ex) { 
     } 
 }
public void testFactory_hours_int452() { 
     assertSame(Hours.ZERO, Hours.hours(0)); 
     assertSame(Hours.ONE, Hours.hours(1)); 
     assertSame(Hours.TWO, Hours.hours(2)); 
     assertSame(Hours.THREE, Hours.hours(3)); 
     assertSame(Hours.FOUR, Hours.hours(4)); 
     assertSame(Hours.FIVE, Hours.hours(5)); 
     assertSame(Hours.SIX, Hours.hours(6)); 
     assertSame(Hours.SEVEN, Hours.hours(7)); 
     assertSame(Hours.EIGHT, Hours.hours(8)); 
     assertSame(Hours.MAX_VALUE, Hours.hours(Integer.MAX_VALUE)); 
     assertSame(Hours.MIN_VALUE, Hours.hours(Integer.MIN_VALUE)); 
     assertEquals(-1, Hours.hours(-1).getHours()); 
     assertEquals(9, Hours.hours(9).getHours()); 
 }
public void testGetMethods453() { 
     Hours test = Hours.hours(20); 
     assertEquals(20, test.getHours()); 
 }
public void testGetPeriodType455() { 
     Hours test = Hours.hours(20); 
     PeriodType type = test.getPeriodType(); 
     assertEquals(PeriodType.hours(), type); 
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
