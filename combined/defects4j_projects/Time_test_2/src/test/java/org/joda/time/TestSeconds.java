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
public void testSerialization226() throws Exception { 
     Seconds test = Seconds.THREE; 
     ByteArrayOutputStream baos = new ByteArrayOutputStream(); 
     ObjectOutputStream oos = new ObjectOutputStream(baos); 
     oos.writeObject(test); 
     byte[] bytes = baos.toByteArray(); 
     oos.close(); 
     ByteArrayInputStream bais = new ByteArrayInputStream(bytes); 
     ObjectInputStream ois = new ObjectInputStream(bais); 
     Seconds result = (Seconds) ois.readObject(); 
     ois.close(); 
     assertSame(test, result); 
 }
public void testFactory_secondsBetween_RInstant227() { 
     DateTime start = new DateTime(2006, 6, 9, 12, 0, 3, 0, PARIS); 
     DateTime end1 = new DateTime(2006, 6, 9, 12, 0, 6, 0, PARIS); 
     DateTime end2 = new DateTime(2006, 6, 9, 12, 0, 9, 0, PARIS); 
     assertEquals(3, Seconds.secondsBetween(start, end1).getSeconds()); 
     assertEquals(0, Seconds.secondsBetween(start, start).getSeconds()); 
     assertEquals(0, Seconds.secondsBetween(end1, end1).getSeconds()); 
     assertEquals(-3, Seconds.secondsBetween(end1, start).getSeconds()); 
     assertEquals(6, Seconds.secondsBetween(start, end2).getSeconds()); 
 }
public void testToStandardWeeks228() { 
     Seconds test = Seconds.seconds(60 * 60 * 2); 
     Weeks expected = Weeks.weeks(2); 
     assertEquals(expected, test.toStandardWeeks()); 
 }
public void testMinus_int229() { 
     Seconds test2 = Seconds.seconds(2); 
     Seconds result = test2.minus(3); 
     assertEquals(2, test2.getSeconds()); 
     assertEquals(-1, result.getSeconds()); 
     assertEquals(1, Seconds.ONE.minus(0).getSeconds()); 
     try { 
         Seconds.MIN_VALUE.minus(1); 
         fail(); 
     } catch (ArithmeticException ex) { 
     } 
 }
public void testMinus_Seconds230() { 
     Seconds test2 = Seconds.seconds(2); 
     Seconds test3 = Seconds.seconds(3); 
     Seconds result = test2.minus(test3); 
     assertEquals(2, test2.getSeconds()); 
     assertEquals(3, test3.getSeconds()); 
     assertEquals(-1, result.getSeconds()); 
     assertEquals(1, Seconds.ONE.minus(Seconds.ZERO).getSeconds()); 
     assertEquals(1, Seconds.ONE.minus((Seconds) null).getSeconds()); 
     try { 
         Seconds.MIN_VALUE.minus(Seconds.ONE); 
         fail(); 
     } catch (ArithmeticException ex) { 
     } 
 }
public void testIsLessThan231() { 
     assertEquals(false, Seconds.THREE.isLessThan(Seconds.TWO)); 
     assertEquals(false, Seconds.THREE.isLessThan(Seconds.THREE)); 
     assertEquals(true, Seconds.TWO.isLessThan(Seconds.THREE)); 
     assertEquals(false, Seconds.ONE.isLessThan(null)); 
     assertEquals(true, Seconds.seconds(-1).isLessThan(null)); 
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
