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
 * This class is a Junit unit test for Seconds.
 *
 * @author Stephen Colebourne
 */
public class TestSeconds extends TestCase {
    // Test in 2002/03 as time zones are more well known
    // (before the late 90's they were all over the place)
    private static final DateTimeZone PARIS = DateTimeZone.forID("Europe/Paris");

    public static void main(String[] args) {
        junit.textui.TestRunner.run(suite());
    }

    public static TestSuite suite() {
        return new TestSuite(TestSeconds.class);
    }

    public TestSeconds(String name) {
        super(name);
    }

    protected void setUp() throws Exception {
    }

    protected void tearDown() throws Exception {
    }

    //-----------------------------------------------------------------------
public void testFactory_secondsBetween_RPartial197() { 
     LocalTime start = new LocalTime(12, 3); 
     LocalTime end1 = new LocalTime(12, 6); 
     @SuppressWarnings("deprecation") 
     TimeOfDay end2 = new TimeOfDay(12, 9); 
     assertEquals(3, Seconds.secondsBetween(start, end1).getSeconds()); 
     assertEquals(0, Seconds.secondsBetween(start, start).getSeconds()); 
     assertEquals(0, Seconds.secondsBetween(end1, end1).getSeconds()); 
     assertEquals(-3, Seconds.secondsBetween(end1, start).getSeconds()); 
     assertEquals(6, Seconds.secondsBetween(start, end2).getSeconds()); 
 }
public void testFactory_parseSeconds_String198() { 
     assertEquals(0, Seconds.parseSeconds((String) null).getSeconds()); 
     assertEquals(0, Seconds.parseSeconds("PT0H").getSeconds()); 
     assertEquals(1, Seconds.parseSeconds("PT1H").getSeconds()); 
     assertEquals(-3, Seconds.parseSeconds("PT-3H").getSeconds()); 
     assertEquals(2, Seconds.parseSeconds("P0Y0M0DT2H").getSeconds()); 
     assertEquals(2, Seconds.parseSeconds("PT0H2M").getSeconds()); 
     try { 
         Seconds.parseSeconds("P1Y1D"); 
         fail(); 
     } catch (IllegalArgumentException ex) { 
     } 
     try { 
         Seconds.parseSeconds("P1DT1H"); 
         fail(); 
     } catch (IllegalArgumentException ex) { 
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
