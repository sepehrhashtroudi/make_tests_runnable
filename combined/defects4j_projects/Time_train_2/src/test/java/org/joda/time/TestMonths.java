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
 * This class is a Junit unit test for Months.
 *
 * @author Stephen Colebourne
 */
public class TestMonths extends TestCase {
    // Test in 2002/03 as time zones are more well known
    // (before the late 90's they were all over the place)
    private static final DateTimeZone PARIS = DateTimeZone.forID("Europe/Paris");

    public static void main(String[] args) {
        junit.textui.TestRunner.run(suite());
    }

    public static TestSuite suite() {
        return new TestSuite(TestMonths.class);
    }

    public TestMonths(String name) {
        super(name);
    }

    protected void setUp() throws Exception {
    }

    protected void tearDown() throws Exception {
    }

    //-----------------------------------------------------------------------

public void testFactory_parseMonths_String162() { 
     assertEquals(0, Months.parseMonths((String) null).getMonths()); 
     assertEquals(0, Months.parseMonths("P0M").getMonths()); 
     assertEquals(1, Months.parseMonths("P1M").getMonths()); 
     assertEquals(-3, Months.parseMonths("P-3M").getMonths()); 
     assertEquals(2, Months.parseMonths("P0Y2M").getMonths()); 
     assertEquals(2, Months.parseMonths("P2MT0H0M").getMonths()); 
     try { 
         Months.parseMonths("P1Y1D"); 
         fail(); 
     } catch (IllegalArgumentException ex) { 
     } 
     try { 
         Months.parseMonths("P1MT1H"); 
         fail(); 
     } catch (IllegalArgumentException ex) { 
     } 
 } 


public void testGetPeriodType283() { 
     Months test = Months.months(20); 
     assertEquals(PeriodType.months(), test.getPeriodType()); 
 } 


public void testMinus_Months284() { 
     Months test2 = Months.months(2); 
     Months test3 = Months.months(3); 
     Months result = test2.minus(test3); 
     assertEquals(2, test2.getMonths()); 
     assertEquals(3, test3.getMonths()); 
     assertEquals(-1, result.getMonths()); 
     assertEquals(1, Months.ONE.minus(Months.ZERO).getMonths()); 
     assertEquals(1, Months.ONE.minus((Months) null).getMonths()); 
     try { 
         Months.MIN_VALUE.minus(Months.ONE); 
         fail(); 
     } catch (ArithmeticException ex) { 
     } 
 } 


public void testFactory_months_int285() { 
     assertSame(Months.ZERO, Months.months(0)); 
     assertSame(Months.ONE, Months.months(1)); 
     assertSame(Months.TWO, Months.months(2)); 
     assertSame(Months.THREE, Months.months(3)); 
     assertSame(Months.FOUR, Months.months(4)); 
     assertSame(Months.FIVE, Months.months(5)); 
     assertSame(Months.SIX, Months.months(6)); 
     assertSame(Months.SEVEN, Months.months(7)); 
     assertSame(Months.EIGHT, Months.months(8)); 
     assertSame(Months.NINE, Months.months(9)); 
     assertSame(Months.TEN, Months.months(10)); 
     assertSame(Months.ELEVEN, Months.months(11)); 
     assertSame(Months.TWELVE, Months.months(12)); 
     assertSame(Months.MAX_VALUE, Months.months(Integer.MAX_VALUE)); 
     assertSame(Months.MIN_VALUE, Months.months(Integer.MIN_VALUE)); 
     assertEquals(-1, Months.months(-1).getMonths()); 
     assertEquals(13, Months.months(13).getMonths()); 
 } 


public void testPlus_Months286() { 
     Months test2 = Months.months(2); 
     Months test3 = Months.months(3); 
     Months result = test2.plus(test3); 
     assertEquals(2, test2.getMonths()); 
     assertEquals(3, test3.getMonths()); 
     assertEquals(5, result.getMonths()); 
     assertEquals(1, Months.ONE.plus(Months.ZERO).getMonths()); 
     assertEquals(1, Months.ONE.plus((Months) null).getMonths()); 
     try { 
         Months.MAX_VALUE.plus(Months.ONE); 
         fail(); 
     } catch (ArithmeticException ex) { 
     } 
 } 


public void testFactory_monthsIn_RInterval287() { 
     DateTime start = new DateTime(2006, 6, 9, 12, 0, 0, 0, PARIS); 
     DateTime end1 = new DateTime(2006, 9, 9, 12, 0, 0, 0, PARIS); 
     DateTime end2 = new DateTime(2006, 12, 9, 12, 0, 0, 0, PARIS); 
     assertEquals(0, Months.monthsIn((ReadableInterval) null).getMonths()); 
     assertEquals(3, Months.monthsIn(new Interval(start, end1)).getMonths()); 
     assertEquals(0, Months.monthsIn(new Interval(start, start)).getMonths()); 
     assertEquals(0, Months.monthsIn(new Interval(end1, end1)).getMonths()); 
     assertEquals(6, Months.monthsIn(new Interval(start, end2)).getMonths()); 
 } 


public void testFactory_monthsBetween_RInstant288() { 
     DateTime start = new DateTime(2006, 6, 9, 12, 0, 0, 0, PARIS); 
     DateTime end1 = new DateTime(2006, 9, 9, 12, 0, 0, 0, PARIS); 
     DateTime end2 = new DateTime(2006, 12, 9, 12, 0, 0, 0, PARIS); 
     assertEquals(3, Months.monthsBetween(start, end1).getMonths()); 
     assertEquals(0, Months.monthsBetween(start, start).getMonths()); 
     assertEquals(0, Months.monthsBetween(end1, end1).getMonths()); 
     assertEquals(-3, Months.monthsBetween(end1, start).getMonths()); 
     assertEquals(6, Months.monthsBetween(start, end2).getMonths()); 
 } 


public void testFactory_monthsBetween_RPartial_YearMonth289() { 
     YearMonth start1 = new YearMonth(2011, 1); 
     for (int i = 0; i < 6; i++) { 
         YearMonth start2 = new YearMonth(2011 + i, 1); 
         YearMonth end = new YearMonth(2011 + i, 3); 
         assertEquals(i * 12 + 2, Months.monthsBetween(start1, end).getMonths()); 
         assertEquals(2, Months.monthsBetween(start2, end).getMonths()); 
     } 
 } 


@SuppressWarnings("deprecation") 
 public void testFactory_monthsBetween_RPartial_LocalDate290() { 
     LocalDate start = new LocalDate(2006, 6, 9); 
     LocalDate end1 = new LocalDate(2006, 9, 9); 
     YearMonthDay end2 = new YearMonthDay(2006, 12, 9); 
     assertEquals(3, Months.monthsBetween(start, end1).getMonths()); 
     assertEquals(0, Months.monthsBetween(start, start).getMonths()); 
     assertEquals(0, Months.monthsBetween(end1, end1).getMonths()); 
     assertEquals(-3, Months.monthsBetween(end1, start).getMonths()); 
     assertEquals(6, Months.monthsBetween(start, end2).getMonths()); 
 } 


public void testMultipliedBy_int291() { 
     Months test = Months.months(2); 
     assertEquals(6, test.multipliedBy(3).getMonths()); 
     assertEquals(2, test.getMonths()); 
     assertEquals(-6, test.multipliedBy(-3).getMonths()); 
     assertSame(test, test.multipliedBy(1)); 
     Months halfMax = Months.months(Integer.MAX_VALUE / 2 + 1); 
     try { 
         halfMax.multipliedBy(2); 
         fail(); 
     } catch (ArithmeticException ex) { 
     } 
 } 


public void testNegated292() { 
     Months test = Months.months(12); 
     assertEquals(-12, test.negated().getMonths()); 
     assertEquals(12, test.getMonths()); 
     try { 
         Months.MIN_VALUE.negated(); 
         fail(); 
     } catch (ArithmeticException ex) { 
     } 
 } 


public void testIsGreaterThan293() { 
     assertEquals(true, Months.THREE.isGreaterThan(Months.TWO)); 
     assertEquals(false, Months.THREE.isGreaterThan(Months.THREE)); 
     assertEquals(false, Months.TWO.isGreaterThan(Months.THREE)); 
     assertEquals(true, Months.ONE.isGreaterThan(null)); 
     assertEquals(false, Months.months(-1).isGreaterThan(null)); 
 } 


public void testToString294() { 
     Months test = Months.months(20); 
     assertEquals("P20M", test.toString()); 
     test = Months.months(-20); 
     assertEquals("P-20M", test.toString()); 
 } 

    

    //-----------------------------------------------------------------------
    

    //-----------------------------------------------------------------------
    

    //-------------------------------------------------------------------------
    

    

    

    //-------------------------------------------------------------------------
    

    

    //-----------------------------------------------------------------------
    

    

    

    //-----------------------------------------------------------------------
    

    

    //-----------------------------------------------------------------------
    

    //-----------------------------------------------------------------------
    

    //-----------------------------------------------------------------------
    

    

    

    

    

    

    

    //-----------------------------------------------------------------------
    

}
