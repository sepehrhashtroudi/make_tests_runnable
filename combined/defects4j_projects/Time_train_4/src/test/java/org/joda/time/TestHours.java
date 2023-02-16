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

public void testFactory_standardHoursIn_RPeriod301() { 
     assertEquals(0, Hours.standardHoursIn((ReadablePeriod) null).getHours()); 
     assertEquals(0, Hours.standardHoursIn(Period.ZERO).getHours()); 
     assertEquals(1, Hours.standardHoursIn(new Period(0, 0, 0, 0, 1, 0, 0, 0)).getHours()); 
     assertEquals(123, Hours.standardHoursIn(Period.hours(123)).getHours()); 
     assertEquals(-987, Hours.standardHoursIn(Period.hours(-987)).getHours()); 
     assertEquals(1, Hours.standardHoursIn(Period.minutes(119)).getHours()); 
     assertEquals(2, Hours.standardHoursIn(Period.minutes(120)).getHours()); 
     assertEquals(2, Hours.standardHoursIn(Period.minutes(121)).getHours()); 
     assertEquals(48, Hours.standardHoursIn(Period.days(2)).getHours()); 
     try { 
         Hours.standardHoursIn(Period.months(1)); 
         fail(); 
     } catch (IllegalArgumentException ex) { 
     } 
 } 


public void testMultipliedBy_int458() { 
     Hours test = Hours.hours(2); 
     assertEquals(6, test.multipliedBy(3).getHours()); 
     assertEquals(2, test.getHours()); 
     assertEquals(-6, test.multipliedBy(-3).getHours()); 
     assertSame(test, test.multipliedBy(1)); 
     Hours halfMax = Hours.hours(Integer.MAX_VALUE / 2 + 1); 
     try { 
         halfMax.multipliedBy(2); 
         fail(); 
     } catch (ArithmeticException ex) { 
     } 
 } 


public void testToStandardSeconds1097() { 
     Hours test = Hours.hours(3); 
     Seconds expected = Seconds.seconds(3 * 60 * 60); 
     assertEquals(expected, test.toStandardSeconds()); 
     try { 
         Hours.MAX_VALUE.toStandardSeconds(); 
         fail(); 
     } catch (ArithmeticException ex) { 
     } 
 } 


public void testFactory_hoursBetween_RInstant1098() { 
     DateTime start = new DateTime(2006, 6, 9, 12, 0, 0, 0, PARIS); 
     DateTime end1 = new DateTime(2006, 6, 9, 15, 0, 0, 0, PARIS); 
     DateTime end2 = new DateTime(2006, 6, 9, 18, 0, 0, 0, PARIS); 
     assertEquals(3, Hours.hoursBetween(start, end1).getHours()); 
     assertEquals(0, Hours.hoursBetween(start, start).getHours()); 
     assertEquals(0, Hours.hoursBetween(end1, end1).getHours()); 
     assertEquals(-3, Hours.hoursBetween(end1, start).getHours()); 
     assertEquals(6, Hours.hoursBetween(start, end2).getHours()); 
 } 


public void testFactory_hoursBetween_RPartial1099() { 
     LocalTime start = new LocalTime(12, 0); 
     LocalTime end1 = new LocalTime(15, 0); 
     @SuppressWarnings("deprecation") 
     TimeOfDay end2 = new TimeOfDay(18, 0); 
     assertEquals(3, Hours.hoursBetween(start, end1).getHours()); 
     assertEquals(0, Hours.hoursBetween(start, start).getHours()); 
     assertEquals(0, Hours.hoursBetween(end1, end1).getHours()); 
     assertEquals(-3, Hours.hoursBetween(end1, start).getHours()); 
     assertEquals(6, Hours.hoursBetween(start, end2).getHours()); 
 } 


public void testFactory_hoursIn_RInterval1100() { 
     DateTime start = new DateTime(2006, 6, 9, 12, 0, 0, 0, PARIS); 
     DateTime end1 = new DateTime(2006, 6, 9, 15, 0, 0, 0, PARIS); 
     DateTime end2 = new DateTime(2006, 6, 9, 18, 0, 0, 0, PARIS); 
     assertEquals(0, Hours.hoursIn((ReadableInterval) null).getHours()); 
     assertEquals(3, Hours.hoursIn(new Interval(start, end1)).getHours()); 
     assertEquals(0, Hours.hoursIn(new Interval(start, start)).getHours()); 
     assertEquals(0, Hours.hoursIn(new Interval(end1, end1)).getHours()); 
     assertEquals(6, Hours.hoursIn(new Interval(start, end2)).getHours()); 
 } 


public void testSerialization1102() throws Exception { 
     Hours test = Hours.SEVEN; 
     ByteArrayOutputStream baos = new ByteArrayOutputStream(); 
     ObjectOutputStream oos = new ObjectOutputStream(baos); 
     oos.writeObject(test); 
     byte[] bytes = baos.toByteArray(); 
     oos.close(); 
     ByteArrayInputStream bais = new ByteArrayInputStream(bytes); 
     ObjectInputStream ois = new ObjectInputStream(bais); 
     Hours result = (Hours) ois.readObject(); 
     ois.close(); 
     assertSame(test, result); 
 } 


public void testGetFieldType1103() { 
     Hours test = Hours.hours(20); 
     assertEquals(DurationFieldType.hours(), test.getFieldType()); 
 } 


public void testToStandardWeeks1104() { 
     Hours test = Hours.hours(24 * 7 * 2); 
     Weeks expected = Weeks.weeks(2); 
     assertEquals(expected, test.toStandardWeeks()); 
 } 


public void testToStandardDays1105() { 
     Hours test = Hours.hours(24 * 2); 
     Days expected = Days.days(2); 
     assertEquals(expected, test.toStandardDays()); 
 } 


public void testToStandardMinutes1106() { 
     Hours test = Hours.hours(3); 
     Minutes expected = Minutes.minutes(3 * 60); 
     assertEquals(expected, test.toStandardMinutes()); 
     try { 
         Hours.MAX_VALUE.toStandardMinutes(); 
         fail(); 
     } catch (ArithmeticException ex) { 
     } 
 } 


public void testToStandardDuration1107() { 
     Hours test = Hours.hours(20); 
     Duration expected = new Duration(20L * DateTimeConstants.MILLIS_PER_HOUR); 
     assertEquals(expected, test.toStandardDuration()); 
     expected = new Duration(((long) Integer.MAX_VALUE) * DateTimeConstants.MILLIS_PER_HOUR); 
     assertEquals(expected, Hours.MAX_VALUE.toStandardDuration()); 
 } 


public void testGetMethods1108() { 
     Hours test = Hours.hours(20); 
     assertEquals(20, test.getHours()); 
 } 


public void testPlus_int1109() { 
     Hours test2 = Hours.hours(2); 
     Hours result = test2.plus(3); 
     assertEquals(2, test2.getHours()); 
     assertEquals(5, result.getHours()); 
     assertEquals(1, Hours.ONE.plus(0).getHours()); 
     try { 
         Hours.MAX_VALUE.plus(1); 
         fail(); 
     } catch (ArithmeticException ex) { 
     } 
 } 


public void testMinus_int1110() { 
     Hours test2 = Hours.hours(2); 
     Hours result = test2.minus(3); 
     assertEquals(2, test2.getHours()); 
     assertEquals(-1, result.getHours()); 
     assertEquals(1, Hours.ONE.minus(0).getHours()); 
     try { 
         Hours.MIN_VALUE.minus(1); 
         fail(); 
     } catch (ArithmeticException ex) { 
     } 
 } 


public void testMinus_Hours1111() { 
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


public void testDividedBy_int1112() { 
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


public void testIsGreaterThan1113() { 
     assertEquals(true, Hours.THREE.isGreaterThan(Hours.TWO)); 
     assertEquals(false, Hours.THREE.isGreaterThan(Hours.THREE)); 
     assertEquals(false, Hours.TWO.isGreaterThan(Hours.THREE)); 
     assertEquals(true, Hours.ONE.isGreaterThan(null)); 
     assertEquals(false, Hours.hours(-1).isGreaterThan(null)); 
 } 


public void testToString1114() { 
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
