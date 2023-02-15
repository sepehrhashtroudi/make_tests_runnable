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
public void testToStandardSeconds194() { 
     Period test = new Period(0, 0, 0, 0, 0, 0, 7, 8); 
     assertEquals(7, test.toStandardSeconds().getSeconds()); 
     test = new Period(0, 0, 0, 0, 0, 1, 3, 0); 
     assertEquals(63, test.toStandardSeconds().getSeconds()); 
     test = new Period(0, 0, 0, 0, 0, 0, 0, 1000); 
     assertEquals(1, test.toStandardSeconds().getSeconds()); 
     test = new Period(0, 0, 0, 0, 0, 0, Integer.MAX_VALUE, 0); 
     assertEquals(Integer.MAX_VALUE, test.toStandardSeconds().getSeconds()); 
     test = new Period(0, 0, 0, 0, 0, 0, 20, Integer.MAX_VALUE); 
     long expected = 20; 
     expected += ((long) Integer.MAX_VALUE) / DateTimeConstants.MILLIS_PER_SECOND; 
     assertEquals(expected, test.toStandardSeconds().getSeconds()); 
     test = new Period(0, 0, 0, 0, 0, 0, Integer.MAX_VALUE, 1000); 
     try { 
         test.toStandardSeconds(); 
         fail(); 
     } catch (ArithmeticException ex) { 
     } 
 }
public void testToStandardSeconds195() { 
     Weeks test = Weeks.weeks(2); 
     Seconds expected = Seconds.seconds(2 * 7 * 24 * 60 * 60); 
     assertEquals(expected, test.toStandardSeconds()); 
     try { 
         Weeks.MAX_VALUE.toStandardSeconds(); 
         fail(); 
     } catch (ArithmeticException ex) { 
     } 
 }
public void testSerialization196() throws Exception { 
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
public void testToStandardDays197() { 
     Seconds test = Seconds.seconds(60 * 60 * 24 * 2); 
     Days expected = Days.days(2); 
     assertEquals(expected, test.toStandardDays()); 
 }
public void testToStandardHours198() { 
     Seconds test = Seconds.seconds(60 * 60 * 24 * 2); 
     Hours expected = Hours.hours(2); 
     assertEquals(expected, test.toStandardHours()); 
 }
public void testToStandardHours199() { 
     Seconds test = Seconds.seconds(60 * 60 * 24 * 7 * 2); 
     Hours expected = Hours.hours(2); 
     assertEquals(expected, test.toStandardHours()); 
 }
public void testToStandardMinutes200() { 
     Seconds test = Seconds.seconds(60 * 60 * 24 * 2); 
     Minutes expected = Minutes.minutes(2); 
     assertEquals(expected, test.toStandardMinutes()); 
 }
public void testToStandardMinutes201() { 
     Seconds test = Seconds.seconds(60 * 60 * 24 * 2); 
     Minutes expected = Minutes.minutes(2 * 24 * 60); 
     assertEquals(expected, test.toStandardMinutes()); 
 }
public void testToStandardDuration202() { 
     Seconds test = Seconds.seconds(20); 
     Duration expected = new Duration(20L * DateTimeConstants.MILLIS_PER_SECOND); 
     assertEquals(expected, test.toStandardDuration()); 
     expected = new Duration(((long) Integer.MAX_VALUE) * DateTimeConstants.MILLIS_PER_SECOND); 
     assertEquals(expected, Seconds.MAX_VALUE.toStandardDuration()); 
 }
public void testPlus_Seconds203() { 
     Seconds test2 = Seconds.seconds(2); 
     Seconds test3 = Seconds.seconds(3); 
     Seconds result = test2.plus(test3); 
     assertEquals(2, test2.getSeconds()); 
     assertEquals(3, test3.getSeconds()); 
     assertEquals(5, result.getSeconds()); 
     assertEquals(1, Seconds.ONE.plus(Seconds.ZERO).getSeconds()); 
     assertEquals(1, Seconds.ONE.plus((Seconds) null).getSeconds()); 
     try { 
         Seconds.MAX_VALUE.plus(Seconds.ONE); 
         fail(); 
     } catch (ArithmeticException ex) { 
     } 
 }
public void testMultipliedBy_int204() { 
     Seconds test = Seconds.seconds(2); 
     assertEquals(6, test.multipliedBy(3).getSeconds()); 
     assertEquals(2, test.getSeconds()); 
     assertEquals(-6, test.multipliedBy(-3).getSeconds()); 
     assertSame(test, test.multipliedBy(1)); 
     Seconds halfMax = Seconds.seconds(Integer.MAX_VALUE / 2 + 1); 
     try { 
         halfMax.multipliedBy(2); 
         fail(); 
     } catch (ArithmeticException ex) { 
     } 
 }
public void testDividedBy_int205() { 
     Seconds test = Seconds.seconds(12); 
     assertEquals(6, test.dividedBy(2).getSeconds()); 
     assertEquals(12, test.getSeconds()); 
     assertEquals(4, test.dividedBy(3).getSeconds()); 
     assertEquals(3, test.dividedBy(4).getSeconds()); 
     assertEquals(2, test.dividedBy(5).getSeconds()); 
     assertEquals(2, test.dividedBy(6).getSeconds()); 
     assertSame(test, test.dividedBy(1)); 
     try { 
         Seconds.ONE.dividedBy(0); 
         fail(); 
     } catch (ArithmeticException ex) { 
     } 
 }
public void testNegated206() { 
     Seconds test = Seconds.seconds(12); 
     assertEquals(-12, test.negated().getSeconds()); 
     assertEquals(12, test.getSeconds()); 
     try { 
         Seconds.MIN_VALUE.negated(); 
         fail(); 
     } catch (ArithmeticException ex) { 
     } 
 }
public void testIsGreaterThan207() { 
     assertEquals(true, Seconds.THREE.isGreaterThan(Seconds.TWO)); 
     assertEquals(false, Seconds.THREE.isGreaterThan(Seconds.THREE)); 
     assertEquals(false, Seconds.TWO.isGreaterThan(Seconds.THREE)); 
     assertEquals(true, Seconds.ONE.isGreaterThan(null)); 
     assertEquals(false, Seconds.seconds(-1).isGreaterThan(null)); 
 }
public void testMultipliedBy_int332() { 
     Minutes test = Minutes.minutes(2); 
     assertEquals(6, test.multipliedBy(3).getMinutes()); 
     assertEquals(2, test.getMinutes()); 
     assertEquals(-6, test.multipliedBy(-3).getMinutes()); 
     assertSame(test, test.multipliedBy(1)); 
     Minutes halfMax = Minutes.minutes(Integer.MAX_VALUE / 2 + 1); 
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
