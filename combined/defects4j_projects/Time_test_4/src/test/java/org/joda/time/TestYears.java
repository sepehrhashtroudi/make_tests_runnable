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
public void testMinus_Years263() { 
     Years test2 = Years.years(2); 
     Years test3 = Years.years(3); 
     Years result = test2.minus(test3); 
     assertEquals(2, test2.getYears()); 
     assertEquals(3, test3.getYears()); 
     assertEquals(-1, result.getYears()); 
     assertEquals(1, Years.ONE.minus(Years.ZERO).getYears()); 
     assertEquals(1, Years.ONE.minus((Years) null).getYears()); 
     try { 
         Years.MIN_VALUE.minus(Years.ONE); 
         fail(); 
     } catch (ArithmeticException ex) { 
     } 
 }
public void testDividedBy_int264() { 
     Years test = Years.years(12); 
     assertEquals(6, test.dividedBy(2).getYears()); 
     assertEquals(12, test.getYears()); 
     assertEquals(4, test.dividedBy(3).getYears()); 
     assertEquals(3, test.dividedBy(4).getYears()); 
     assertEquals(2, test.dividedBy(5).getYears()); 
     assertEquals(2, test.dividedBy(6).getYears()); 
     assertSame(test, test.dividedBy(1)); 
     try { 
         Years.ONE.dividedBy(0); 
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
