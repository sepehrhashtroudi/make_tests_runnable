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
 * This class is a Junit unit test for Hours.
 *
 * @author Stephen Colebourne
 */
public class TestHours extends TestCase {
    // Test in 2002/03 as time zones are more well known
    // (before the late 90's they were all over the place)
    private static final DateTimeZone PARIS = DateTimeZone.forID("Europe/Paris");

    public static void main(String[] args) {
        junit.textui.TestRunner.run(suite());
    }

    public static TestSuite suite() {
        return new TestSuite(TestHours.class);
    }

    public TestHours(String name) {
        super(name);
    }

    protected void setUp() throws Exception {
    }

    protected void tearDown() throws Exception {
    }

    //-----------------------------------------------------------------------
public void testToStandardSeconds422() { 
     Hours test = Hours.hours(3); 
     Seconds expected = Seconds.seconds(3 * 60 * 60); 
     assertEquals(expected, test.toStandardSeconds()); 
     try { 
         Hours.MAX_VALUE.toStandardSeconds(); 
         fail(); 
     } catch (ArithmeticException ex) { 
     } 
 }
public void testPlus_int423() { 
     Hours test2 = Hours.hours(2); 
     Hours result = test2.plus(3); 
     assertEquals(2, test2.getHours()); 
     assertEquals(5, result.getHours()); 
     assertEquals(1, Hours.ONE.plus(0).getHours()); 
     try { 
         Hours.MAX_VALUE.plus(1); 
         fail(); 
     } catch (ArithmeticException ex) { 
     } 
 }
@SuppressWarnings("deprecation") 
 public void testFactory_hoursBetween_RPartial424() { 
     LocalDate start = new LocalDate(2006, 6, 9); 
     LocalDate end1 = new LocalDate(2006, 6, 12); 
     YearMonthDay end2 = new YearMonthDay(2006, 6, 15); 
     assertEquals(3, Hours.hoursBetween(start, end1).getHours()); 
     assertEquals(0, Hours.hoursBetween(start, start).getHours()); 
     assertEquals(0, Hours.hoursBetween(end1, end1).getHours()); 
     assertEquals(-3, Hours.hoursBetween(end1, start).getHours()); 
     assertEquals(6, Hours.hoursBetween(start, end2).getHours()); 
 }
public void testSerialization425() throws Exception { 
     Hours test = Hours.SEVEN; 
     ByteArrayOutputStream baos = new ByteArrayOutputStream(); 
     ObjectOutputStream oos = new ObjectOutputStream(baos); 
     oos.writeObject(test); 
     byte[] bytes = baos.toByteArray(); 
     oos.close(); 
     ByteArrayInputStream bais = new ByteArrayInputStream(bytes); 
     ObjectInputStream ois = new ObjectInputStream(bais); 
     Hours result = (Hours) ois.readObject(); 
     ois.close(); 
     assertSame(test, result); 
 }
public void testFactory_parseHours_String428() { 
     assertEquals(0, Hours.parseHours((String) null).getHours()); 
     assertEquals(0, Hours.parseHours("PT0H").getHours()); 
     assertEquals(1, Hours.parseHours("PT1H").getHours()); 
     assertEquals(-3, Hours.parseHours("PT-3H").getHours()); 
     assertEquals(2, Hours.parseHours("P0Y0M0DT2H0M").getHours()); 
     assertEquals(2, Hours.parseHours("PT0H2H0M").getHours()); 
     try { 
         Hours.parseHours("P1Y1D"); 
         fail(); 
     } catch (IllegalArgumentException ex) { 
     } 
     try { 
         Hours.parseHours("P1DT1H"); 
         fail(); 
     } catch (IllegalArgumentException ex) { 
     } 
 }
public void testPlus_Hours429() { 
     Hours test2 = Hours.hours(2); 
     Hours test3 = Hours.hours(3); 
     Hours result = test2.plus(test3); 
     assertEquals(2, test2.getHours()); 
     assertEquals(3, test3.getHours()); 
     assertEquals(5, result.getHours()); 
     assertEquals(1, Hours.ONE.plus(Hours.ZERO).getHours()); 
     assertEquals(1, Hours.ONE.plus((Hours) null).getHours()); 
     try { 
         Hours.MAX_VALUE.plus(Hours.ONE); 
         fail(); 
     } catch (ArithmeticException ex) { 
     } 
 }
public void testNegated430() { 
     Hours test = Hours.hours(12); 
     assertEquals(-12, test.negated().getHours()); 
     assertEquals(12, test.getHours()); 
     try { 
         Hours.MIN_VALUE.negated(); 
         fail(); 
     } catch (ArithmeticException ex) { 
     } 
 }
public void testIsLessThan431() { 
     assertEquals(false, Hours.THREE.isLessThan(Hours.TWO)); 
     assertEquals(false, Hours.THREE.isLessThan(Hours.THREE)); 
     assertEquals(true, Hours.TWO.isLessThan(Hours.THREE)); 
     assertEquals(false, Hours.ONE.isLessThan(null)); 
     assertEquals(true, Hours.hours(-1).isLessThan(null)); 
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
