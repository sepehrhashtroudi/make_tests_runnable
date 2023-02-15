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
public void testFactory_daysIn_RInterval508() { 
     DateTime start = new DateTime(2006, 6, 9, 12, 0, 0, 0, PARIS); 
     DateTime end1 = new DateTime(2006, 6, 12, 12, 0, 0, 0, PARIS); 
     DateTime end2 = new DateTime(2006, 6, 15, 18, 0, 0, 0, PARIS); 
     assertEquals(0, Days.daysIn((ReadableInterval) null).getDays()); 
     assertEquals(3, Days.daysIn(new Interval(start, end1)).getDays()); 
     assertEquals(0, Days.daysIn(new Interval(start, start)).getDays()); 
     assertEquals(0, Days.daysIn(new Interval(end1, end1)).getDays()); 
     assertEquals(6, Days.daysIn(new Interval(start, end2)).getDays()); 
 }
public void testMinus_int509() { 
     Days test2 = Days.days(2); 
     Days result = test2.minus(3); 
     assertEquals(2, test2.getDays()); 
     assertEquals(-1, result.getDays()); 
     assertEquals(1, Days.ONE.minus(0).getDays()); 
     try { 
         Days.MIN_VALUE.minus(1); 
         fail(); 
     } catch (ArithmeticException ex) { 
     } 
 }
public void testMinus_Days510() { 
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
