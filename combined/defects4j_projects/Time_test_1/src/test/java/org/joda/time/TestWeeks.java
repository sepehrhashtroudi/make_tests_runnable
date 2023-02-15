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
public void testToStandardMinutes207() { 
     Seconds test = Seconds.seconds(60 * 2); 
     Minutes expected = Minutes.minutes(2); 
     assertEquals(expected, test.toStandardMinutes()); 
     try { 
         Seconds.MAX_VALUE.toStandardMinutes(); 
         fail(); 
     } catch (ArithmeticException ex) { 
     } 
 }
public void testToStandardSeconds217() { 
     Weeks test = Weeks.weeks(2); 
     Seconds expected = Seconds.seconds(2 * 7 * 24 * 60); 
     assertEquals(expected, test.toStandardSeconds()); 
     try { 
         Weeks.MAX_VALUE.toStandardSeconds(); 
         fail(); 
     } catch (ArithmeticException ex) { 
     } 
 }
public void testToStandardDuration218() { 
     Weeks test = Weeks.weeks(20); 
     Duration expected = new Duration(20L * DateTimeConstants.MILLIS_PER_WEEK); 
     assertEquals(expected, test.toStandardDuration()); 
     expected = new Duration(((long) Integer.MAX_VALUE) * DateTimeConstants.MILLIS_PER_WEEK); 
     assertEquals(expected, Weeks.MAX_VALUE.toStandardDuration()); 
 }
public void testMultipliedBy_int219() { 
     Weeks test = Weeks.weeks(2); 
     assertEquals(6, test.multipliedBy(3).getWeeks()); 
     assertEquals(2, test.getWeeks()); 
     assertEquals(-6, test.multipliedBy(-3).getWeeks()); 
     assertSame(test, test.multipliedBy(1)); 
     Weeks halfMax = Weeks.weeks(Integer.MAX_VALUE / 2 + 1); 
     try { 
         halfMax.multipliedBy(2); 
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
