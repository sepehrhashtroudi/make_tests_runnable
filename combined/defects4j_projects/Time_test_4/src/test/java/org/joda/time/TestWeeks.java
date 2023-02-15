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
public void testMinus_Weeks216() { 
     Weeks test2 = Weeks.weeks(2); 
     Weeks test3 = Weeks.weeks(3); 
     Weeks result = test2.minus(test3); 
     assertEquals(2, test2.getWeeks()); 
     assertEquals(3, test3.getWeeks()); 
     assertEquals(-1, result.getWeeks()); 
     assertEquals(1, Weeks.ONE.minus(Weeks.ZERO).getWeeks()); 
     assertEquals(1, Weeks.ONE.minus((Weeks) null).getWeeks()); 
     try { 
         Weeks.MIN_VALUE.minus(Weeks.ONE); 
         fail(); 
     } catch (ArithmeticException ex) { 
     } 
 }
public void testDividedBy_int217() { 
     Weeks test = Weeks.weeks(12); 
     assertEquals(6, test.dividedBy(2).getWeeks()); 
     assertEquals(12, test.getWeeks()); 
     assertEquals(4, test.dividedBy(3).getWeeks()); 
     assertEquals(3, test.dividedBy(4).getWeeks()); 
     assertEquals(2, test.dividedBy(5).getWeeks()); 
     assertEquals(2, test.dividedBy(6).getWeeks()); 
     assertSame(test, test.dividedBy(1)); 
     try { 
         Weeks.ONE.dividedBy(0); 
         fail(); 
     } catch (ArithmeticException ex) { 
     } 
 }
public void testIsLessThan218() { 
     assertEquals(false, Weeks.THREE.isLessThan(Weeks.TWO)); 
     assertEquals(false, Weeks.THREE.isLessThan(Weeks.THREE)); 
     assertEquals(true, Weeks.TWO.isLessThan(Weeks.THREE)); 
     assertEquals(false, Weeks.ONE.isLessThan(null)); 
     assertEquals(true, Weeks.weeks(-1).isLessThan(null)); 
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
