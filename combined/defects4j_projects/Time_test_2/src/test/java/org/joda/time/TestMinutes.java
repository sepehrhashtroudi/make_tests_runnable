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
public void testIsLessThan381() { 
     assertEquals(false, Minutes.THREE.isLessThan(Minutes.TWO)); 
     assertEquals(false, Minutes.THREE.isLessThan(Minutes.THREE)); 
     assertEquals(true, Minutes.TWO.isLessThan(Minutes.THREE)); 
     assertEquals(false, Minutes.ONE.isLessThan(null)); 
     assertEquals(true, Minutes.minutes(-1).isLessThan(null)); 
 }
public void testMinus_int382() { 
     Minutes test2 = Minutes.minutes(2); 
     Minutes result = test2.minus(3); 
     assertEquals(2, test2.getMinutes()); 
     assertEquals(-1, result.getMinutes()); 
     assertEquals(1, Minutes.ONE.minus(0).getMinutes()); 
     try { 
         Minutes.MIN_VALUE.minus(1); 
         fail(); 
     } catch (ArithmeticException ex) { 
     } 
 }
public void testFactory_minutes_int383() { 
     assertSame(Minutes.ZERO, Minutes.minutes(0)); 
     assertSame(Minutes.ONE, Minutes.minutes(1)); 
     assertSame(Minutes.TWO, Minutes.minutes(2)); 
     assertSame(Minutes.THREE, Minutes.minutes(3)); 
     assertSame(Minutes.MAX_VALUE, Minutes.minutes(Integer.MAX_VALUE)); 
     assertSame(Minutes.MIN_VALUE, Minutes.minutes(Integer.MIN_VALUE)); 
     assertEquals(-1, Minutes.minutes(-1).getMinutes()); 
     assertEquals(4, Minutes.minutes(4).getMinutes()); 
 }
public void testFactory_minutesBetween_RPartial384() { 
     LocalTime start = new LocalTime(12, 0, 3); 
     LocalTime end1 = new LocalTime(12, 0, 6); 
     @SuppressWarnings("deprecation") 
     TimeOfDay end2 = new TimeOfDay(12, 0, 9); 
     assertEquals(3, Minutes.minutesBetween(start, end1).getMinutes()); 
     assertEquals(0, Minutes.minutesBetween(start, start).getMinutes()); 
     assertEquals(0, Minutes.minutesBetween(end1, end1).getMinutes()); 
     assertEquals(-3, Minutes.minutesBetween(end1, start).getMinutes()); 
     assertEquals(6, Minutes.minutesBetween(start, end2).getMinutes()); 
 }
public void testFactory_parseMinutes_String385() { 
     assertEquals(0, Minutes.parseMinutes((String) null).getMinutes()); 
     assertEquals(0, Minutes.parseMinutes("PT0M").getMinutes()); 
     assertEquals(1, Minutes.parseMinutes("PT1S").getMinutes()); 
     assertEquals(-3, Minutes.parseMinutes("PT-3S").getMinutes()); 
     assertEquals(2, Minutes.parseMinutes("P0Y0M0DT2S").getMinutes()); 
     assertEquals(2, Minutes.parseMinutes("PT0H2S").getMinutes()); 
     try { 
         Minutes.parseMinutes("P1Y1D"); 
         fail(); 
     } catch (IllegalArgumentException ex) { 
     } 
     try { 
         Minutes.parseMinutes("P1DT1S"); 
         fail(); 
     } catch (IllegalArgumentException ex) { 
     } 
 }
public void testFactory_parseMinutes_String386() { 
     assertEquals(0, Minutes.parseMinutes((String) null).getMinutes()); 
     assertEquals(0, Minutes.parseMinutes("PT0M").getMinutes()); 
     assertEquals(1, Minutes.parseMinutes("PT1M").getMinutes()); 
     assertEquals(-3, Minutes.parseMinutes("PT-3M").getMinutes()); 
     assertEquals(2, Minutes.parseMinutes("P0Y2M").getMinutes()); 
     assertEquals(2, Minutes.parseMinutes("PT0H2M").getMinutes()); 
     try { 
         Minutes.parseMinutes("P1Y1D"); 
         fail(); 
     } catch (IllegalArgumentException ex) { 
     } 
     try { 
         Minutes.parseMinutes("P1DT1H"); 
         fail(); 
     } catch (IllegalArgumentException ex) { 
     } 
 }
public void testFactory_minutesBetween_RPartial387() { 
     LocalDate start = new LocalDate(2006, 6, 9); 
     LocalDate end1 = new LocalDate(2006, 6, 12); 
     YearMonthDay end2 = new YearMonthDay(2006, 6, 15); 
     assertEquals(3, Minutes.minutesBetween(start, end1).getMinutes()); 
     assertEquals(0, Minutes.minutesBetween(start, start).getMinutes()); 
     assertEquals(0, Minutes.minutesBetween(end1, end1).getMinutes()); 
     assertEquals(-3, Minutes.minutesBetween(end1, start).getMinutes()); 
     assertEquals(6, Minutes.minutesBetween(start, end2).getMinutes()); 
 }
public void testGetFieldType388() { 
     Minutes test = Minutes.minutes(20); 
     assertEquals(DurationFieldType.minutes(), test.getFieldType()); 
 }
public void testToStandardWeeks389() { 
     Minutes test = Minutes.minutes(3 * 7 * 2); 
     Weeks expected = Weeks.weeks(2); 
     assertEquals(expected, test.toStandardWeeks()); 
 }
public void testMinus_Minutes390() { 
     Minutes test2 = Minutes.minutes(2); 
     Minutes test3 = Minutes.minutes(3); 
     Minutes result = test2.minus(test3); 
     assertEquals(2, test2.getMinutes()); 
     assertEquals(3, test3.getMinutes()); 
     assertEquals(-1, result.getMinutes()); 
     assertEquals(1, Minutes.ONE.minus(Minutes.ZERO).getMinutes()); 
     assertEquals(1, Minutes.ONE.minus((Minutes) null).getMinutes()); 
     try { 
         Minutes.MIN_VALUE.minus(Minutes.ONE); 
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
