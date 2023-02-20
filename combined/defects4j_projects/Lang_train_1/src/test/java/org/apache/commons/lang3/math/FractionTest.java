/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.apache.commons.lang3.math;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Test;

/**
 * Test cases for the {@link Fraction} class
 *
 * @version $Id$
 */
public class FractionTest  {
    
    private static final int SKIP = 500;  //53

    //--------------------------------------------------------------------------
@Test
public void testHashCode257() { 
     final Fraction f1 = Fraction.getFraction(3, 5); 
     Fraction f2 = Fraction.getFraction(3, 5); 
     assertTrue(f1.hashCode() == f2.hashCode()); 
     f2 = Fraction.getFraction(2, 5); 
     assertTrue(f1.hashCode() != f2.hashCode()); 
     f2 = Fraction.getFraction(6, 10); 
     assertTrue(f1.hashCode() != f2.hashCode()); 
 }
@Test
public void testAbs258() { 
     Fraction f = null; 
     f = Fraction.getFraction(50, 75); 
     f = f.abs(); 
     assertEquals(50, f.getNumerator()); 
     assertEquals(75, f.getDenominator()); 
     f = Fraction.getFraction(-50, 75); 
     f = f.abs(); 
     assertEquals(50, f.getNumerator()); 
     assertEquals(75, f.getDenominator()); 
     f = Fraction.getFraction(Integer.MAX_VALUE, 1); 
     f = f.abs(); 
     assertEquals(Integer.MAX_VALUE, f.getNumerator()); 
     assertEquals(1, f.getDenominator()); 
     f = Fraction.getFraction(Integer.MAX_VALUE, -1); 
     f = f.abs(); 
     assertEquals(Integer.MAX_VALUE, f.getNumerator()); 
     assertEquals(1, f.getDenominator()); 
     f = Fraction.getFraction(Integer.MIN_VALUE, 1); 
     try { 
         f = f.abs(); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
 }
@Test
public void testToProperString259() { 
     Fraction f = null; 
     f = Fraction.getFraction(3, 5); 
     final String str = f.toProperString(); 
     assertEquals("3/5", str); 
     assertSame(str, f.toProperString()); 
     f = Fraction.getFraction(7, 5); 
     assertEquals("1 2/5", f.toProperString()); 
     f = Fraction.getFraction(14, 10); 
     assertEquals("1 4/10", f.toProperString()); 
     f = Fraction.getFraction(4, 2); 
     assertEquals("2", f.toProperString()); 
     f = Fraction.getFraction(0, 2); 
     assertEquals("0", f.toProperString()); 
     f = Fraction.getFraction(2, 2); 
     assertEquals("1", f.toProperString()); 
     f = Fraction.getFraction(-7, 5); 
     assertEquals("-1 2/5", f.toProperString()); 
     f = Fraction.getFraction(Integer.MIN_VALUE, 0, 1); 
     assertEquals("-2147483648", f.toProperString()); 
     f = Fraction.getFraction(-1, 1, Integer.MAX_VALUE); 
     assertEquals("-1 1/2147483647", f.toProperString()); 
     assertEquals("-1", Fraction.getFraction(-1).toProperString()); 
 }
@Test
public void testFactory_int_int_int260() { 
     Fraction f = null; 
     f = Fraction.getFraction(0, 0, 2); 
     assertEquals(0, f.getNumerator()); 
     assertEquals(2, f.getDenominator()); 
     f = Fraction.getFraction(2, 0, 2); 
     assertEquals(4, f.getNumerator()); 
     assertEquals(2, f.getDenominator()); 
     f = Fraction.getFraction(0, 1, 2); 
     assertEquals(1, f.getNumerator()); 
     assertEquals(2, f.getDenominator()); 
     f = Fraction.getFraction(1, 1, 2); 
     assertEquals(3, f.getNumerator()); 
     assertEquals(2, f.getDenominator()); 
     try { 
         f = Fraction.getFraction(1, -6, -10); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     try { 
         f = Fraction.getFraction(1, -6, -10); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     try { 
         f = Fraction.getFraction(1, -6, -10); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     f = Fraction.getFraction(-1, 6, 10); 
     assertEquals(-16, f.getNumerator()); 
     assertEquals(10, f.getDenominator()); 
     try { 
         f = Fraction.getFraction(-1, -6, 10); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     try { 
         f = Fraction.getFraction(-1, 6, -10); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     try { 
         f = Fraction.getFraction(-1, -6, -10); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     try { 
         f = Fraction.getFraction(0, 1, 0); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     try { 
         f = Fraction.getFraction(1, 2, 0); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     try { 
         f = Fraction.getFraction(-1, -3, 0); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     try { 
         f = Fraction.getFraction(Integer.MAX_VALUE, 1, 2); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     try { 
         f = Fraction.getFraction(-Integer.MAX_VALUE, 1, 2); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     f = Fraction.getFraction(-1, 0, Integer.MAX_VALUE); 
     assertEquals(-Integer.MAX_VALUE, f.getNumerator()); 
     assertEquals(Integer.MAX_VALUE, f.getDenominator()); 
     try { 
         f = Fraction.getFraction(0, 4, Integer.MIN_VALUE); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     try { 
         f = Fraction.getFraction(1, 1, Integer.MAX_VALUE); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     try { 
         f = Fraction.getFraction(-1, 2, Integer.MAX_VALUE); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
 }
@Test
public void testReducedFactory_int_int261() { 
     Fraction f = null; 
     f = Fraction.getReducedFraction(0, 1); 
     assertEquals(0, f.getNumerator()); 
     assertEquals(1, f.getDenominator()); 
     f = Fraction.getReducedFraction(1, 1); 
     assertEquals(1, f.getNumerator()); 
     assertEquals(1, f.getDenominator()); 
     f = Fraction.getReducedFraction(2, 1); 
     assertEquals(2, f.getNumerator()); 
     assertEquals(1, f.getDenominator()); 
     f = Fraction.getReducedFraction(22, 7); 
     assertEquals(22, f.getNumerator()); 
     assertEquals(7, f.getDenominator()); 
     f = Fraction.getReducedFraction(-6, 10); 
     assertEquals(-3, f.getNumerator()); 
     assertEquals(5, f.getDenominator()); 
     f = Fraction.getReducedFraction(6, -10); 
     assertEquals(-3, f.getNumerator()); 
     assertEquals(5, f.getDenominator()); 
     f = Fraction.getReducedFraction(-6, -10); 
     assertEquals(3, f.getNumerator()); 
     assertEquals(5, f.getDenominator()); 
     try { 
         f = Fraction.getReducedFraction(1, 0); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     try { 
         f = Fraction.getReducedFraction(2, 0); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     try { 
         f = Fraction.getReducedFraction(-3, 0); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     f = Fraction.getReducedFraction(0, 2); 
     assertEquals(0, f.getNumerator()); 
     assertEquals(1, f.getDenominator()); 
     f = Fraction.getReducedFraction(2, 2); 
     assertEquals(1, f.getNumerator()); 
     assertEquals(1, f.getDenominator()); 
     f = Fraction.getReducedFraction(2, 4); 
     assertEquals(1, f.getNumerator()); 
     assertEquals(2, f.getDenominator()); 
     f = Fraction.getReducedFraction(15, 10); 
     assertEquals(3, f.getNumerator()); 
     assertEquals(2, f.getDenominator()); 
     f = Fraction.getReducedFraction(121, 22); 
     assertEquals(11, f.getNumerator()); 
     assertEquals(2, f.getDenominator()); 
     f = Fraction.getReducedFraction(-2, Integer.MIN_VALUE); 
     assertEquals(1, f.getNumerator()); 
     assertEquals(-(Integer.MIN_VALUE / 2), f.getDenominator()); 
     try { 
         f = Fraction.getReducedFraction(-7, Integer.MIN_VALUE); 
         fail("Expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     f = Fraction.getReducedFraction(Integer.MIN_VALUE, 2); 
     assertEquals(Integer.MIN_VALUE / 2, f.getNumerator()); 
     assertEquals(1, f.getDenominator()); 
 }
@Test
public void testFactory_double262() { 
     Fraction f = null; 
     try { 
         f = Fraction.getFraction(Double.NaN); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     try { 
         f = Fraction.getFraction(Double.POSITIVE_INFINITY); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     try { 
         f = Fraction.getFraction(Double.NEGATIVE_INFINITY); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     try { 
         f = Fraction.getFraction((double) Integer.MAX_VALUE + 1); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     f = Fraction.getFraction(0.0d); 
     assertEquals(0, f.getNumerator()); 
     assertEquals(1, f.getDenominator()); 
     f = Fraction.getFraction(1.0d); 
     assertEquals(1, f.getNumerator()); 
     assertEquals(1, f.getDenominator()); 
     f = Fraction.getFraction(0.5d); 
     assertEquals(1, f.getNumerator()); 
     assertEquals(2, f.getDenominator()); 
     f = Fraction.getFraction(-0.875d); 
     assertEquals(-7, f.getNumerator()); 
     assertEquals(8, f.getDenominator()); 
     f = Fraction.getFraction(1.25d); 
     assertEquals(5, f.getNumerator()); 
     assertEquals(4, f.getDenominator()); 
     f = Fraction.getFraction(0.66666d); 
     assertEquals(2, f.getNumerator()); 
     assertEquals(3, f.getDenominator()); 
     f = Fraction.getFraction(1.0d / 10001d); 
     assertEquals(0, f.getNumerator()); 
     assertEquals(1, f.getDenominator()); 
     Fraction f2 = null; 
     for (int i = 1; i <= 100; i++) { 
         for (int j = 1; j <= i; j++) { 
             try { 
                 f = Fraction.getFraction((double) j / (double) i); 
             } catch (final ArithmeticException ex) { 
                 System.err.println(j + " " + i); 
                 throw ex; 
             } 
             f2 = Fraction.getReducedFraction(j, i); 
             assertEquals(f2.getNumerator(), f.getNumerator()); 
             assertEquals(f2.getDenominator(), f.getDenominator()); 
         } 
     } 
     for (int i = 1001; i <= 10000; i += SKIP) { 
         for (int j = 1; j <= i; j++) { 
             try { 
                 f = Fraction.getFraction((double) j / (double) i); 
             } catch (final ArithmeticException ex) { 
                 System.err.println(j + " " + i); 
                 throw ex; 
             } 
             f2 = Fraction.getReducedFraction(j, i); 
             assertEquals(f2.getNumerator(), f.getNumerator()); 
             assertEquals(f2.getDenominator(), f.getDenominator()); 
         } 
     } 
 }
@Test
public void testFactory_String_proper263() { 
     Fraction f = null; 
     f = Fraction.getFraction("0 0/1"); 
     assertEquals(0, f.getNumerator()); 
     assertEquals(1, f.getDenominator()); 
     f = Fraction.getFraction("1 1/5"); 
     assertEquals(6, f.getNumerator()); 
     assertEquals(5, f.getDenominator()); 
     f = Fraction.getFraction("7 1/2"); 
     assertEquals(15, f.getNumerator()); 
     assertEquals(2, f.getDenominator()); 
     f = Fraction.getFraction("1 2/4"); 
     assertEquals(6, f.getNumerator()); 
     assertEquals(4, f.getDenominator()); 
     f = Fraction.getFraction("-7 1/2"); 
     assertEquals(-15, f.getNumerator()); 
     assertEquals(2, f.getDenominator()); 
     f = Fraction.getFraction("-1 2/4"); 
     assertEquals(-6, f.getNumerator()); 
     assertEquals(4, f.getDenominator()); 
     try { 
         f = Fraction.getFraction("2 3"); 
         fail("expecting NumberFormatException"); 
     } catch (final NumberFormatException ex) { 
     } 
     try { 
         f = Fraction.getFraction("a 3"); 
         fail("expecting NumberFormatException"); 
     } catch (final NumberFormatException ex) { 
     } 
     try { 
         f = Fraction.getFraction("2 b/4"); 
         fail("expecting NumberFormatException"); 
     } catch (final NumberFormatException ex) { 
     } 
     try { 
         f = Fraction.getFraction("2 "); 
         fail("expecting NumberFormatException"); 
     } catch (final NumberFormatException ex) { 
     } 
     try { 
         f = Fraction.getFraction(" 3"); 
         fail("expecting NumberFormatException"); 
     } catch (final NumberFormatException ex) { 
     } 
     try { 
         f = Fraction.getFraction(" "); 
         fail("expecting NumberFormatException"); 
     } catch (final NumberFormatException ex) { 
     } 
 }
@Test
public void testConversions264() { 
     Fraction f = null; 
     f = Fraction.getFraction(3, 7, 8); 
     assertEquals(3, f.intValue()); 
     assertEquals(3L, f.longValue()); 
     assertEquals(3.875f, f.floatValue(), 0.00001f); 
     assertEquals(3.875d, f.doubleValue(), 0.00001d); 
 }
@Test
public void testDivide265() { 
     Fraction f = null; 
     Fraction f1 = null; 
     Fraction f2 = null; 
     f1 = Fraction.getFraction(3, 5); 
     f2 = Fraction.getFraction(2, 5); 
     f = f1.divideBy(f2); 
     assertEquals(3, f.getNumerator()); 
     assertEquals(2, f.getDenominator()); 
     f1 = Fraction.getFraction(3, 5); 
     f2 = Fraction.ZERO; 
     try { 
         f = f1.divideBy(f2); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     f1 = Fraction.getFraction(0, 5); 
     f2 = Fraction.getFraction(2, 7); 
     f = f1.divideBy(f2); 
     assertSame(Fraction.ZERO, f); 
     f1 = Fraction.getFraction(2, 7); 
     f2 = Fraction.ONE; 
     f = f1.divideBy(f2); 
     assertEquals(2, f.getNumerator()); 
     assertEquals(7, f.getDenominator()); 
     f1 = Fraction.getFraction(1, Integer.MAX_VALUE); 
     f = f1.divideBy(f1); 
     assertEquals(1, f.getNumerator()); 
     assertEquals(1, f.getDenominator()); 
     f1 = Fraction.getFraction(Integer.MIN_VALUE, Integer.MAX_VALUE); 
     f2 = Fraction.getFraction(1, Integer.MAX_VALUE); 
     f = f1.divideBy(f2); 
     assertEquals(Integer.MIN_VALUE, f.getNumerator()); 
     assertEquals(1, f.getDenominator()); 
     try { 
         f.divideBy(null); 
         fail("IllegalArgumentException"); 
     } catch (final IllegalArgumentException ex) { 
     } 
     try { 
         f1 = Fraction.getFraction(1, Integer.MAX_VALUE); 
         f = f1.divideBy(f1.invert()); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     try { 
         f1 = Fraction.getFraction(1, -Integer.MAX_VALUE); 
         f = f1.divideBy(f1.invert()); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
 }
@Test
public void testAdd266() { 
     Fraction f = null; 
     Fraction f1 = null; 
     Fraction f2 = null; 
     f1 = Fraction.getFraction(3, 5); 
     f2 = Fraction.getFraction(1, 5); 
     f = f1.add(f2); 
     assertEquals(4, f.getNumerator()); 
     assertEquals(5, f.getDenominator()); 
     f1 = Fraction.getFraction(3, 5); 
     f2 = Fraction.getFraction(2, 5); 
     f = f1.add(f2); 
     assertEquals(1, f.getNumerator()); 
     assertEquals(1, f.getDenominator()); 
     f1 = Fraction.getFraction(3, 5); 
     f2 = Fraction.getFraction(3, 5); 
     f = f1.add(f2); 
     assertEquals(6, f.getNumerator()); 
     assertEquals(5, f.getDenominator()); 
     f1 = Fraction.getFraction(3, 5); 
     f2 = Fraction.getFraction(-4, 5); 
     f = f1.add(f2); 
     assertEquals(-1, f.getNumerator()); 
     assertEquals(5, f.getDenominator()); 
     f1 = Fraction.getFraction(Integer.MAX_VALUE - 1, 1); 
     f2 = Fraction.ONE; 
     f = f1.add(f2); 
     assertEquals(Integer.MAX_VALUE, f.getNumerator()); 
     assertEquals(1, f.getDenominator()); 
     f1 = Fraction.getFraction(3, 5); 
     f2 = Fraction.getFraction(1, 2); 
     f = f1.add(f2); 
     assertEquals(11, f.getNumerator()); 
     assertEquals(10, f.getDenominator()); 
     f1 = Fraction.getFraction(3, 8); 
     f2 = Fraction.getFraction(1, 6); 
     f = f1.add(f2); 
     assertEquals(13, f.getNumerator()); 
     assertEquals(24, f.getDenominator()); 
     f1 = Fraction.getFraction(0, 5); 
     f2 = Fraction.getFraction(1, 5); 
     f = f1.add(f2); 
     assertSame(f2, f); 
     f = f2.add(f1); 
     assertSame(f2, f); 
     f1 = Fraction.getFraction(-1, 13 * 13 * 2 * 2); 
     f2 = Fraction.getFraction(-2, 13 * 17 * 2); 
     f = f1.add(f2); 
     assertEquals(13 * 13 * 17 * 2 * 2, f.getDenominator()); 
     assertEquals(-17 - 2 * 13 * 2, f.getNumerator()); 
     try { 
         f.add(null); 
         fail("expecting IllegalArgumentException"); 
     } catch (final IllegalArgumentException ex) { 
     } 
     f1 = Fraction.getFraction(1, 32768 * 3); 
     f2 = Fraction.getFraction(1, 59049); 
     f = f1.add(f2); 
     assertEquals(52451, f.getNumerator()); 
     assertEquals(1934917632, f.getDenominator()); 
     f1 = Fraction.getFraction(Integer.MIN_VALUE, 3); 
     f2 = Fraction.ONE_THIRD; 
     f = f1.add(f2); 
     assertEquals(Integer.MIN_VALUE + 1, f.getNumerator()); 
     assertEquals(3, f.getDenominator()); 
     f1 = Fraction.getFraction(Integer.MAX_VALUE - 1, 1); 
     f2 = Fraction.ONE; 
     f = f1.add(f2); 
     assertEquals(Integer.MAX_VALUE, f.getNumerator()); 
     assertEquals(1, f.getDenominator()); 
     try { 
         f = f.add(Fraction.ONE); 
         fail("expecting ArithmeticException but got: " + f.toString()); 
     } catch (final ArithmeticException ex) { 
     } 
     f1 = Fraction.getFraction(Integer.MIN_VALUE, 5); 
     f2 = Fraction.getFraction(-1, 5); 
     try { 
         f = f1.add(f2); 
         fail("expecting ArithmeticException but got: " + f.toString()); 
     } catch (final ArithmeticException ex) { 
     } 
     try { 
         f = Fraction.getFraction(-Integer.MAX_VALUE, 1); 
         f = f.add(f); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     try { 
         f = Fraction.getFraction(-Integer.MAX_VALUE, 1); 
         f = f.add(f); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     f1 = Fraction.getFraction(3, 327680); 
     f2 = Fraction.getFraction(2, 59049); 
     try { 
         f = f1.add(f2); 
         fail("expecting ArithmeticException but got: " + f.toString()); 
     } catch (final ArithmeticException ex) { 
     } 
 }
@Test
public void testSubtract267() { 
     Fraction f = null; 
     Fraction f1 = null; 
     Fraction f2 = null; 
     f1 = Fraction.getFraction(3, 5); 
     f2 = Fraction.getFraction(1, 5); 
     f = f1.subtract(f2); 
     assertEquals(2, f.getNumerator()); 
     assertEquals(5, f.getDenominator()); 
     f1 = Fraction.getFraction(7, 5); 
     f2 = Fraction.getFraction(2, 5); 
     f = f1.subtract(f2); 
     assertEquals(1, f.getNumerator()); 
     assertEquals(1, f.getDenominator()); 
     f1 = Fraction.getFraction(3, 5); 
     f2 = Fraction.getFraction(3, 5); 
     f = f1.subtract(f2); 
     assertEquals(0, f.getNumerator()); 
     assertEquals(1, f.getDenominator()); 
     f1 = Fraction.getFraction(3, 5); 
     f2 = Fraction.getFraction(-4, 5); 
     f = f1.subtract(f2); 
     assertEquals(7, f.getNumerator()); 
     assertEquals(5, f.getDenominator()); 
     f1 = Fraction.getFraction(0, 5); 
     f2 = Fraction.getFraction(4, 5); 
     f = f1.subtract(f2); 
     assertEquals(-4, f.getNumerator()); 
     assertEquals(5, f.getDenominator()); 
     f1 = Fraction.getFraction(0, 5); 
     f2 = Fraction.getFraction(-4, 5); 
     f = f1.subtract(f2); 
     assertEquals(4, f.getNumerator()); 
     assertEquals(5, f.getDenominator()); 
     f1 = Fraction.getFraction(3, 5); 
     f2 = Fraction.getFraction(1, 2); 
     f = f1.subtract(f2); 
     assertEquals(1, f.getNumerator()); 
     assertEquals(10, f.getDenominator()); 
     f1 = Fraction.getFraction(0, 5); 
     f2 = Fraction.getFraction(1, 5); 
     f = f2.subtract(f1); 
     assertSame(f2, f); 
     try { 
         f.subtract(null); 
         fail("expecting IllegalArgumentException"); 
     } catch (final IllegalArgumentException ex) { 
     } 
     f1 = Fraction.getFraction(1, 32768 * 3); 
     f2 = Fraction.getFraction(1, 59049); 
     f = f1.subtract(f2); 
     assertEquals(-13085, f.getNumerator()); 
     assertEquals(1934917632, f.getDenominator()); 
     f1 = Fraction.getFraction(Integer.MIN_VALUE, 3); 
     f2 = Fraction.ONE_THIRD.negate(); 
     f = f1.subtract(f2); 
     assertEquals(Integer.MIN_VALUE + 1, f.getNumerator()); 
     assertEquals(3, f.getDenominator()); 
     f1 = Fraction.getFraction(Integer.MAX_VALUE, 1); 
     f2 = Fraction.ONE; 
     f = f1.subtract(f2); 
     assertEquals(Integer.MAX_VALUE - 1, f.getNumerator()); 
     assertEquals(1, f.getDenominator()); 
     try { 
         f1 = Fraction.getFraction(1, Integer.MAX_VALUE); 
         f2 = Fraction.getFraction(1, Integer.MAX_VALUE - 1); 
         f = f1.subtract(f2); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     f1 = Fraction.getFraction(Integer.MIN_VALUE, 5); 
     f2 = Fraction.getFraction(1, 5); 
     try { 
         f = f1.subtract(f2); 
         fail("expecting ArithmeticException but got: " + f.toString()); 
     } catch (final ArithmeticException ex) { 
     } 
     try { 
         f = Fraction.getFraction(Integer.MIN_VALUE, 1); 
         f = f.subtract(Fraction.ONE); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     try { 
         f = Fraction.getFraction(Integer.MAX_VALUE, 1); 
         f = f.subtract(Fraction.ONE.negate()); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     f1 = Fraction.getFraction(3, 327680); 
     f2 = Fraction.getFraction(2, 59049); 
     try { 
         f = f1.subtract(f2); 
         fail("expecting ArithmeticException but got: " + f.toString()); 
     } catch (final ArithmeticException ex) { 
     } 
 }
@Test
public void testEquals268() { 
     Fraction f1 = null; 
     Fraction f2 = null; 
     f1 = Fraction.getFraction(3, 5); 
     assertFalse(f1.equals(null)); 
     assertFalse(f1.equals(new Object())); 
     assertFalse(f1.equals(Integer.valueOf(6))); 
     f1 = Fraction.getFraction(3, 5); 
     f2 = Fraction.getFraction(2, 5); 
     assertFalse(f1.equals(f2)); 
     assertTrue(f1.equals(f1)); 
     assertTrue(f2.equals(f2)); 
     f2 = Fraction.getFraction(3, 5); 
     assertTrue(f1.equals(f2)); 
     f2 = Fraction.getFraction(6, 10); 
     assertFalse(f1.equals(f2)); 
 }
@Test
public void testToString269() { 
     Fraction f = null; 
     f = Fraction.getFraction(3, 5); 
     final String str = f.toString(); 
     assertEquals("3/5", str); 
     assertSame(str, f.toString()); 
     f = Fraction.getFraction(7, 5); 
     assertEquals("7/5", f.toString()); 
     f = Fraction.getFraction(4, 2); 
     assertEquals("4/2", f.toString()); 
     f = Fraction.getFraction(0, 2); 
     assertEquals("0/2", f.toString()); 
     f = Fraction.getFraction(2, 2); 
     assertEquals("2/2", f.toString()); 
     f = Fraction.getFraction(Integer.MIN_VALUE, 0, 1); 
     assertEquals("-2147483648/1", f.toString()); 
     f = Fraction.getFraction(-1, 1, Integer.MAX_VALUE); 
     assertEquals("-2147483648/2147483647", f.toString()); 
 }
    

    

    
    

    

    
    
    
    

    

    

    
            
    
    
    
    
    
    
    
    
    
    
    
    
    
            
    
            
    
            
    
            
    
    
    
    
    
    
    
    
    
}
