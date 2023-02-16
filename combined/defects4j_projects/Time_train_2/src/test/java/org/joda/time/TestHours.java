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

public void testFactory_standardHoursIn_RPeriod270() { 
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


public void testMultipliedBy_int422() { 
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


public void testToStandardSeconds1066() { 
     Hours test = Hours.hours(3); 
     Seconds expected = Seconds.seconds(3 * 60 * 60); 
     assertEquals(expected, test.toStandardSeconds()); 
     try { 
         Hours.MAX_VALUE.toStandardSeconds(); 
         fail(); 
     } catch (ArithmeticException ex) { 
     } 
 } 


public void testFactory_hours_int1067() { 
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


public void testFactory_hoursBetween_RInstant1068() { 
     DateTime start = new DateTime(2006, 6, 9, 12, 0, 0, 0, PARIS); 
     DateTime end1 = new DateTime(2006, 6, 9, 15, 0, 0, 0, PARIS); 
     DateTime end2 = new DateTime(2006, 6, 9, 18, 0, 0, 0, PARIS); 
     assertEquals(3, Hours.hoursBetween(start, end1).getHours()); 
     assertEquals(0, Hours.hoursBetween(start, start).getHours()); 
     assertEquals(0, Hours.hoursBetween(end1, end1).getHours()); 
     assertEquals(-3, Hours.hoursBetween(end1, start).getHours()); 
     assertEquals(6, Hours.hoursBetween(start, end2).getHours()); 
 } 


public void testFactory_hoursIn_RInterval1069() { 
     DateTime start = new DateTime(2006, 6, 9, 12, 0, 0, 0, PARIS); 
     DateTime end1 = new DateTime(2006, 6, 9, 15, 0, 0, 0, PARIS); 
     DateTime end2 = new DateTime(2006, 6, 9, 18, 0, 0, 0, PARIS); 
     assertEquals(0, Hours.hoursIn((ReadableInterval) null).getHours()); 
     assertEquals(3, Hours.hoursIn(new Interval(start, end1)).getHours()); 
     assertEquals(0, Hours.hoursIn(new Interval(start, start)).getHours()); 
     assertEquals(0, Hours.hoursIn(new Interval(end1, end1)).getHours()); 
     assertEquals(6, Hours.hoursIn(new Interval(start, end2)).getHours()); 
 } 


public void testFactory_parseHours_String1071() { 
     assertEquals(0, Hours.parseHours((String) null).getHours()); 
     assertEquals(0, Hours.parseHours("PT0H").getHours()); 
     assertEquals(1, Hours.parseHours("PT1H").getHours()); 
     assertEquals(-3, Hours.parseHours("PT-3H").getHours()); 
     assertEquals(2, Hours.parseHours("P0Y0M0DT2H").getHours()); 
     assertEquals(2, Hours.parseHours("PT2H0M").getHours()); 
     try { 
         Hours.parseHours("P1Y1D"); 
         fail(); 
     } catch (IllegalArgumentException ex) { 
     } 
     try { 
         Hours.parseHours("P1DT1H"); 
         fail(); 
     } catch (IllegalArgumentException ex) { 
     } 
 } 


public void testSerialization1072() throws Exception { 
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


public void testGetFieldType1073() { 
     Hours test = Hours.hours(20); 
     assertEquals(DurationFieldType.hours(), test.getFieldType()); 
 } 


public void testToStandardWeeks1074() { 
     Hours test = Hours.hours(24 * 7 * 2); 
     Weeks expected = Weeks.weeks(2); 
     assertEquals(expected, test.toStandardWeeks()); 
 } 


public void testToStandardMinutes1075() { 
     Hours test = Hours.hours(3); 
     Minutes expected = Minutes.minutes(3 * 60); 
     assertEquals(expected, test.toStandardMinutes()); 
     try { 
         Hours.MAX_VALUE.toStandardMinutes(); 
         fail(); 
     } catch (ArithmeticException ex) { 
     } 
 } 


public void testGetMethods1076() { 
     Hours test = Hours.hours(20); 
     assertEquals(20, test.getHours()); 
 } 


public void testPlus_int1077() { 
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


public void testPlus_Hours1078() { 
     Hours test2 = Hours.hours(2); 
     Hours test3 = Hours.hours(3); 
     Hours result = test2.plus(test3); 
     assertEquals(2, test2.getHours()); 
     assertEquals(3, test3.getHours()); 
     assertEquals(5, result.getHours()); 
     assertEquals(1, Hours.ONE.plus(Hours.ZERO).getHours()); 
     assertEquals(1, Hours.ONE.plus((Hours) null).getHours()); 
     try { 
         Hours.MAX_VALUE.plus(Hours.ONE); 
         fail(); 
     } catch (ArithmeticException ex) { 
     } 
 } 


public void testMinus_int1079() { 
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


public void testMinus_Hours1080() { 
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


public void testDividedBy_int1081() { 
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


public void testNegated1082() { 
     Hours test = Hours.hours(12); 
     assertEquals(-12, test.negated().getHours()); 
     assertEquals(12, test.getHours()); 
     try { 
         Hours.MIN_VALUE.negated(); 
         fail(); 
     } catch (ArithmeticException ex) { 
     } 
 } 


public void testIsLessThan1083() { 
     assertEquals(false, Hours.THREE.isLessThan(Hours.TWO)); 
     assertEquals(false, Hours.THREE.isLessThan(Hours.THREE)); 
     assertEquals(true, Hours.TWO.isLessThan(Hours.THREE)); 
     assertEquals(false, Hours.ONE.isLessThan(null)); 
     assertEquals(true, Hours.hours(-1).isLessThan(null)); 
 } 


public void testToString1084() { 
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
