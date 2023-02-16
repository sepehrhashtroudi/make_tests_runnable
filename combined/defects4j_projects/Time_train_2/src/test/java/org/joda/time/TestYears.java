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

public void testFactory_parseYears_String661() { 
     assertEquals(0, Years.parseYears((String) null).getYears()); 
     assertEquals(0, Years.parseYears("P0Y").getYears()); 
     assertEquals(1, Years.parseYears("P1Y").getYears()); 
     assertEquals(-3, Years.parseYears("P-3Y").getYears()); 
     assertEquals(2, Years.parseYears("P2Y0M").getYears()); 
     assertEquals(2, Years.parseYears("P2YT0H0M").getYears()); 
     try { 
         Years.parseYears("P1M1D"); 
         fail(); 
     } catch (IllegalArgumentException ex) { 
     } 
     try { 
         Years.parseYears("P1YT1H"); 
         fail(); 
     } catch (IllegalArgumentException ex) { 
     } 
 } 


public void testMultipliedBy_int662() { 
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


public void testFactory_yearsIn_RInterval663() { 
     DateTime start = new DateTime(2006, 6, 9, 12, 0, 0, 0, PARIS); 
     DateTime end1 = new DateTime(2009, 6, 9, 12, 0, 0, 0, PARIS); 
     DateTime end2 = new DateTime(2012, 6, 9, 12, 0, 0, 0, PARIS); 
     assertEquals(0, Years.yearsIn((ReadableInterval) null).getYears()); 
     assertEquals(3, Years.yearsIn(new Interval(start, end1)).getYears()); 
     assertEquals(0, Years.yearsIn(new Interval(start, start)).getYears()); 
     assertEquals(0, Years.yearsIn(new Interval(end1, end1)).getYears()); 
     assertEquals(6, Years.yearsIn(new Interval(start, end2)).getYears()); 
 } 


public void testSerialization665() throws Exception { 
     Years test = Years.THREE; 
     ByteArrayOutputStream baos = new ByteArrayOutputStream(); 
     ObjectOutputStream oos = new ObjectOutputStream(baos); 
     oos.writeObject(test); 
     byte[] bytes = baos.toByteArray(); 
     oos.close(); 
     ByteArrayInputStream bais = new ByteArrayInputStream(bytes); 
     ObjectInputStream ois = new ObjectInputStream(bais); 
     Years result = (Years) ois.readObject(); 
     ois.close(); 
     assertSame(test, result); 
 } 


public void testGetFieldType666() { 
     Years test = Years.years(20); 
     assertEquals(DurationFieldType.years(), test.getFieldType()); 
 } 


public void testGetPeriodType667() { 
     Years test = Years.years(20); 
     assertEquals(PeriodType.years(), test.getPeriodType()); 
 } 


public void testPlus_Years668() { 
     Years test2 = Years.years(2); 
     Years test3 = Years.years(3); 
     Years result = test2.plus(test3); 
     assertEquals(2, test2.getYears()); 
     assertEquals(3, test3.getYears()); 
     assertEquals(5, result.getYears()); 
     assertEquals(1, Years.ONE.plus(Years.ZERO).getYears()); 
     assertEquals(1, Years.ONE.plus((Years) null).getYears()); 
     try { 
         Years.MAX_VALUE.plus(Years.ONE); 
         fail(); 
     } catch (ArithmeticException ex) { 
     } 
 } 


public void testMinus_int669() { 
     Years test2 = Years.years(2); 
     Years result = test2.minus(3); 
     assertEquals(2, test2.getYears()); 
     assertEquals(-1, result.getYears()); 
     assertEquals(1, Years.ONE.minus(0).getYears()); 
     try { 
         Years.MIN_VALUE.minus(1); 
         fail(); 
     } catch (ArithmeticException ex) { 
     } 
 } 


public void testMinus_Years670() { 
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


public void testDividedBy_int671() { 
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
