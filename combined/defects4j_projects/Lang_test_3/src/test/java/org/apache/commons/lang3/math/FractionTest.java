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
public void testAbs128() { 
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
public void testToProperString129() { 
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
public void testFactory_String_double130() { 
     Fraction f = null; 
     f = Fraction.getFraction("0.0"); 
     assertEquals(0, f.getNumerator()); 
     assertEquals(1, f.getDenominator()); 
     f = Fraction.getFraction("0.2"); 
     assertEquals(1, f.getNumerator()); 
     assertEquals(5, f.getDenominator()); 
     f = Fraction.getFraction("0.5"); 
     assertEquals(1, f.getNumerator()); 
     assertEquals(2, f.getDenominator()); 
     f = Fraction.getFraction("0.66666"); 
     assertEquals(2, f.getNumerator()); 
     assertEquals(3, f.getDenominator()); 
     try { 
         f = Fraction.getFraction("2.3R"); 
         fail("Expecting NumberFormatException"); 
     } catch (final NumberFormatException ex) { 
     } 
     try { 
         f = Fraction.getFraction("2147483648"); 
         fail("Expecting NumberFormatException"); 
     } catch (final NumberFormatException ex) { 
     } 
     try { 
         f = Fraction.getFraction("."); 
         fail("Expecting NumberFormatException"); 
     } catch (final NumberFormatException ex) { 
     } 
 }
@Test
public void testPow131() { 
     Fraction f = null; 
     f = Fraction.getFraction(3, 5); 
     assertEquals(Fraction.ONE, f.pow(0)); 
     f = Fraction.getFraction(3, 5); 
     assertSame(f, f.pow(1)); 
     assertEquals(f, f.pow(1)); 
     f = Fraction.getFraction(3, 5); 
     f = f.pow(2); 
     assertEquals(9, f.getNumerator()); 
     assertEquals(25, f.getDenominator()); 
     f = Fraction.getFraction(3, 5); 
     f = f.pow(3); 
     assertEquals(27, f.getNumerator()); 
     assertEquals(125, f.getDenominator()); 
     f = Fraction.getFraction(3, 5); 
     f = f.pow(-1); 
     assertEquals(5, f.getNumerator()); 
     assertEquals(3, f.getDenominator()); 
     f = Fraction.getFraction(3, 5); 
     f = f.pow(-2); 
     assertEquals(25, f.getNumerator()); 
     assertEquals(9, f.getDenominator()); 
     f = Fraction.getFraction(6, 10); 
     assertEquals(Fraction.ONE, f.pow(0)); 
     f = Fraction.getFraction(6, 10); 
     assertEquals(f, f.pow(1)); 
     assertFalse(f.pow(1).equals(Fraction.getFraction(3, 5))); 
     f = Fraction.getFraction(6, 10); 
     f = f.pow(2); 
     assertEquals(9, f.getNumerator()); 
     assertEquals(25, f.getDenominator()); 
     f = Fraction.getFraction(6, 10);
}

@Test
public void testInvert132() { 
     Fraction f = null; 
     f = Fraction.getFraction(50, 75); 
     f = f.invert(); 
     assertEquals(75, f.getNumerator()); 
     assertEquals(50, f.getDenominator()); 
     f = Fraction.getFraction(-50, 75); 
     f = f.invert(); 
     assertEquals(50, f.getNumerator()); 
     assertEquals(75, f.getDenominator()); 
     f = Fraction.getFraction(Integer.MAX_VALUE, 1); 
     f = f.invert(); 
     assertEquals(Integer.MAX_VALUE, f.getNumerator()); 
     assertEquals(1, f.getDenominator()); 
     f = Fraction.getFraction(Integer.MAX_VALUE, -1); 
     f = f.invert(); 
     assertEquals(Integer.MAX_VALUE, f.getNumerator()); 
     assertEquals(1, f.getDenominator()); 
     f = Fraction.getFraction(Integer.MIN_VALUE, 1); 
     try { 
         f = f.invert(); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
 }
@Test
public void testReduce133() { 
     Fraction f = null; 
     f = Fraction.getFraction(50, 75); 
     Fraction result = f.reduce(); 
     assertEquals(2, result.getNumerator()); 
     assertEquals(3, result.getDenominator()); 
     f = Fraction.getFraction(-2, -3); 
     result = f.reduce(); 
     assertEquals(2, result.getNumerator()); 
     assertEquals(3, result.getDenominator()); 
     f = Fraction.getFraction(2, -3); 
     result = f.reduce(); 
     assertEquals(-2, result.getNumerator()); 
     assertEquals(3, result.getDenominator()); 
     f = Fraction.getFraction(-2, 3); 
     result = f.reduce(); 
     assertEquals(-2, result.getNumerator()); 
     assertEquals(3, result.getDenominator()); 
     assertSame(f, result); 
     f = Fraction.getFraction(2, 3); 
     result = f.reduce(); 
     assertEquals(2, result.getNumerator()); 
     assertEquals(3, result.getDenominator()); 
     assertSame(f, result); 
     f = Fraction.getFraction(0, 1); 
     result = f.reduce(); 
     assertEquals(0, result.getNumerator()); 
     assertEquals(1, result.getDenominator()); 
     assertSame(f, result); 
     f = Fraction.getFraction(0, 100); 
     result = f.reduce(); 
     assertEquals(0, result.getNumerator()); 
     assertEquals(1, result.getDenominator()); 
     assertSame(result, Fraction.ZERO); 
     f = Fraction.getFraction(Integer.MIN_VALUE, 2); 
     result = f.reduce();
}

@Test
public void testHashCode137() { 
     Fraction f1 = null; 
     Fraction f2 = null; 
     f1 = Fraction.getFraction(3, 5); 
     assertEquals(f1.hashCode(), f2.hashCode()); 
     f1 = Fraction.getFraction(3, 5); 
     f2 = Fraction.getFraction(2, 5); 
     assertTrue(f1.hashCode() == f2.hashCode()); 
     f1 = Fraction.getFraction(3, 5); 
     f2 = Fraction.getFraction(3, 5); 
     assertFalse(f1.hashCode() == f2.hashCode()); 
     f2 = Fraction.getFraction(6, 10); 
     assertTrue(f1.hashCode() == f2.hashCode()); 
     f2 = Fraction.getFraction(-6, 10); 
     assertTrue(f1.hashCode() == f2.hashCode()); 
 }
    

    

    
    

    

    
    
    
    

    

    

    
            
    
    
    
    
    
    
    
    
    
    
    
    
    
            
    
            
    
            
    
            
    
    
    
    
    
    
    
    
    
}
