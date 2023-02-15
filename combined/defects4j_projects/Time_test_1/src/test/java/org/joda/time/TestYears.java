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
 * This class is a Junit unit test for Years.
 *
 * @author Stephen Colebourne
 */
public class TestYears extends TestCase {
    // Test in 2002/03 as time zones are more well known
    // (before the late 90's they were all over the place)
    private static final DateTimeZone PARIS = DateTimeZone.forID("Europe/Paris");

    public static void main(String[] args) {
        junit.textui.TestRunner.run(suite());
    }

    public static TestSuite suite() {
        return new TestSuite(TestYears.class);
    }

    public TestYears(String name) {
        super(name);
    }

    protected void setUp() throws Exception {
    }

    protected void tearDown() throws Exception {
    }

    //-----------------------------------------------------------------------
public void testFactory_parseYears_String281() { 
     assertEquals(0, Years.parseYears((String) null).getYears()); 
     assertEquals(0, Years.parseYears("P0M").getYears()); 
     assertEquals(1, Years.parseYears("P1M").getYears()); 
     assertEquals(-3, Years.parseYears("P-3M").getYears()); 
     assertEquals(2, Years.parseYears("P0Y2M").getYears()); 
     assertEquals(2, Years.parseYears("P2MT0H0M").getYears()); 
     try { 
         Years.parseYears("P1Y1D"); 
         fail(); 
     } catch (IllegalArgumentException ex) { 
     } 
     try { 
         Years.parseYears("P1MT1H"); 
         fail(); 
     } catch (IllegalArgumentException ex) { 
     } 
 }
public void testFactory_yearsBetween_RInstant282() { 
     DateTime start = new DateTime(2006, 6, 9, 12, 0, 0, 0, PARIS); 
     DateTime end1 = new DateTime(2009, 6, 9, 12, 0, 0, 0, PARIS); 
     DateTime end2 = new DateTime(2012, 6, 9, 12, 0, 0, 0, PARIS); 
     assertEquals(3, Years.yearsBetween(start, end1).getYears()); 
     assertEquals(0, Years.yearsBetween(start, start).getYears()); 
     assertEquals(0, Years.yearsBetween(end1, end1).getYears()); 
     assertEquals(-3, Years.yearsBetween(end1, start).getYears()); 
     assertEquals(6, Years.yearsBetween(start, end2).getYears()); 
 }
public void testFactory_parseYears_String283() { 
     assertEquals(0, Years.parseYears((String) null).getYears()); 
     assertEquals(0, Years.parseYears("P0Y0M").getYears()); 
     assertEquals(1, Years.parseYears("P1Y1M").getYears()); 
     assertEquals(-3, Years.parseYears("P-3M").getYears()); 
     assertEquals(2, Years.parseYears("P0Y2M").getYears()); 
     assertEquals(2, Years.parseYears("P2MT0H0M").getYears()); 
     try { 
         Years.parseYears("P1Y1D"); 
         fail(); 
     } catch (IllegalArgumentException ex) { 
     } 
     try { 
         Years.parseYears("P1MT1H"); 
         fail(); 
     } catch (IllegalArgumentException ex) { 
     } 
 }
public void testMultipliedBy_int284() { 
     Years test = Years.years(2); 
     assertEquals(6, test.multipliedBy(3).getYears()); 
     assertEquals(2, test.getYears()); 
     assertEquals(-6, test.multipliedBy(-3).getYears()); 
     assertSame(test, test.multipliedBy(1)); 
     Years halfMax = Years.years(Integer.MAX_VALUE / 2 + 1); 
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
    

}
