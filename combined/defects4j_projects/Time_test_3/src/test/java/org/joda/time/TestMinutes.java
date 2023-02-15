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
public void testFactory_parseMinutes_String377() { 
     assertEquals(0, Minutes.parseMinutes((String) null).getMinutes()); 
     assertEquals(0, Minutes.parseMinutes("PT0M").getMinutes()); 
     assertEquals(1, Minutes.parseMinutes("PT1M").getMinutes()); 
     assertEquals(-3, Minutes.parseMinutes("PT-3M").getMinutes()); 
     assertEquals(2, Minutes.parseMinutes("P0Y0M0DT2M").getMinutes()); 
     assertEquals(2, Minutes.parseMinutes("PT0H2M").getMinutes()); 
     try { 
         Minutes.parseMinutes("P1Y1D"); 
         fail(); 
     } catch (IllegalArgumentException ex) { 
     } 
     try { 
         Minutes.parseMinutes("P1DT1M"); 
         fail(); 
     } catch (IllegalArgumentException ex) { 
     } 
 }
public void testToStandardMinutes378() { 
     Seconds test = Seconds.seconds(60 * 2); 
     Minutes expected = Minutes.minutes(2); 
     assertEquals(expected, test.toStandardMinutes()); 
 }
public void testFactory_minutesBetween_RInstant379() { 
     DateTime start = new DateTime(2006, 6, 9, 12, 3, 0, 0, PARIS); 
     DateTime end1 = new DateTime(2006, 6, 9, 12, 6, 0, 0, PARIS); 
     DateTime end2 = new DateTime(2006, 6, 9, 12, 9, 0, 0, PARIS); 
     assertEquals(3, Minutes.minutesBetween(start, end1).getMinutes()); 
     assertEquals(0, Minutes.minutesBetween(start, start).getMinutes()); 
     assertEquals(0, Minutes.minutesBetween(end1, end1).getMinutes()); 
     assertEquals(-3, Minutes.minutesBetween(end1, start).getMinutes()); 
     assertEquals(6, Minutes.minutesBetween(start, end2).getMinutes()); 
 }
public void testToStandardSeconds380() { 
     Minutes test = Minutes.minutes(2); 
     Seconds expected = Seconds.seconds(2 * 60 * 60); 
     assertEquals(expected, test.toStandardSeconds()); 
     try { 
         Minutes.MAX_VALUE.toStandardSeconds(); 
         fail(); 
     } catch (ArithmeticException ex) { 
     } 
 }
public void testToStandardSeconds381() { 
     Minutes test = Minutes.minutes(2); 
     Seconds expected = Seconds.seconds(2 * 60); 
     assertEquals(expected, test.toStandardSeconds()); 
     try { 
         Minutes.MAX_VALUE.toStandardSeconds(); 
         fail(); 
     } catch (ArithmeticException ex) { 
     } 
 }
public void testIsLessThan382() { 
     assertEquals(false, Minutes.THREE.isLessThan(Minutes.TWO)); 
     assertEquals(false, Minutes.THREE.isLessThan(Minutes.THREE)); 
     assertEquals(true, Minutes.TWO.isLessThan(Minutes.THREE)); 
     assertEquals(false, Minutes.ONE.isLessThan(null)); 
     assertEquals(true, Minutes.minutes(-1).isLessThan(null)); 
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
