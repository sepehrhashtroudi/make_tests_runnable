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
public void testFactory_standardMinutesIn_RPeriod333() { 
     assertEquals(0, Minutes.standardMinutesIn((ReadablePeriod) null).getMinutes()); 
     assertEquals(0, Minutes.standardMinutesIn(Period.ZERO).getMinutes()); 
     assertEquals(1, Minutes.standardMinutesIn(new Period(0, 0, 0, 0, 1, 0, 0, 0)).getMinutes()); 
     assertEquals(123, Minutes.standardMinutesIn(Period.minutes(123)).getMinutes()); 
     assertEquals(-987, Minutes.standardMinutesIn(Period.minutes(-987)).getMinutes()); 
     assertEquals(1, Minutes.standardMinutesIn(Period.hours(47)).getMinutes()); 
     assertEquals(2, Minutes.standardMinutesIn(Period.hours(48)).getMinutes()); 
     assertEquals(2, Minutes.standardMinutesIn(Period.hours(49)).getMinutes()); 
     assertEquals(14, Minutes.standardMinutesIn(Period.weeks(2)).getMinutes()); 
     try { 
         Minutes.standardMinutesIn(Period.months(1)); 
         fail(); 
     } catch (IllegalArgumentException ex) { 
     } 
 }
public void testSerialization334() throws Exception { 
     Minutes test = Minutes.THREE; 
     ByteArrayOutputStream baos = new ByteArrayOutputStream(); 
     ObjectOutputStream oos = new ObjectOutputStream(baos); 
     oos.writeObject(test); 
     byte[] bytes = baos.toByteArray(); 
     oos.close(); 
     ByteArrayInputStream bais = new ByteArrayInputStream(bytes); 
     ObjectInputStream ois = new ObjectInputStream(bais); 
     Minutes result = (Minutes) ois.readObject(); 
     ois.close(); 
     assertSame(test, result); 
 }
public void testToStandardHours335() { 
     Minutes test = Minutes.minutes(60 * 24 * 2); 
     Hours expected = Hours.hours(2); 
     assertEquals(expected, test.toStandardHours()); 
 }
public void testFactory_minutesBetween_RPartial336() { 
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
public void testPlus_Minutes337() { 
     Minutes test2 = Minutes.minutes(2); 
     Minutes test3 = Minutes.minutes(3); 
     Minutes result = test2.plus(test3); 
     assertEquals(2, test2.getMinutes()); 
     assertEquals(3, test3.getMinutes()); 
     assertEquals(5, result.getMinutes()); 
     assertEquals(1, Minutes.ONE.plus(Minutes.ZERO).getMinutes()); 
     assertEquals(1, Minutes.ONE.plus((Minutes) null).getMinutes()); 
     try { 
         Minutes.MAX_VALUE.plus(Minutes.ONE); 
         fail(); 
     } catch (ArithmeticException ex) { 
     } 
 }
public void testPlus_int338() { 
     Minutes test2 = Minutes.minutes(2); 
     Minutes result = test2.plus(3); 
     assertEquals(2, test2.getMinutes()); 
     assertEquals(5, result.getMinutes()); 
     assertEquals(1, Minutes.ONE.plus(0).getMinutes()); 
     try { 
         Minutes.MAX_VALUE.plus(1); 
         fail(); 
     } catch (ArithmeticException ex) { 
     } 
 }
public void testMinus_Minutes339() { 
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
