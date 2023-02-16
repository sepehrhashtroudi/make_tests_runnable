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
public void testAbs79() { 
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
public void testFactory_double83() { 
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
     try { 
         f = Fraction.getFraction(Double.MAX_VALUE); 
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
}

@Test
public void testFactory_double84() { 
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
     try { 
         f = Fraction.getFraction(0.0d); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
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
}

@Test
public void testCompareTo91() { 
     Fraction f1 = null; 
     Fraction f2 = null; 
     f1 = Fraction.getFraction(3, 5); 
     assertEquals(0, f1.compareTo(f1)); 
     assertEquals(+1, f1.compareTo(f2)); 
     f2 = Fraction.getFraction(2, 5); 
     assertEquals(+1, f1.compareTo(f2)); 
     f2 = Fraction.getFraction(4, 2); 
     assertEquals(0, f1.compareTo(f1)); 
     assertEquals(+1, f1.compareTo(f2)); 
     f2 = Fraction.getFraction(0, 2); 
     assertEquals(0, f1.compareTo(f2)); 
     f2 = Fraction.getFraction(2, 2); 
     assertEquals(1, f1.compareTo(f1)); 
     f2 = Fraction.getFraction(1, 2); 
     assertEquals(1, f1.compareTo(f2)); 
     f2 = Fraction.getFraction(2, 2); 
     assertEquals(2, f1.compareTo(f2)); 
     f2 = Fraction.getFraction(-4, 2); 
     assertEquals(-1, f1.compareTo(f2)); 
     f2 = Fraction.getFraction(Integer.MIN_VALUE, 0, 1); 
     assertEquals(-1, f1.compareTo(f2)); 
     f2 = Fraction.getFraction(-1, 1, Integer.MAX_VALUE); 
     assertEquals(Integer.MIN_VALUE, f1.compareTo(f2)); 
 }
@Test
public void testCompareTo92() { 
     Fraction f1 = null; 
     Fraction f2 = null; 
     f1 = Fraction.getFraction(3, 5); 
     assertEquals(0, f1.compareTo(f1)); 
     assertEquals(+1, f1.compareTo(f2)); 
     f2 = Fraction.getFraction(2, 5); 
     assertEquals(+1, f1.compareTo(f2)); 
     f2 = Fraction.getFraction(6, 10); 
     assertEquals(0, f1.compareTo(f1)); 
     assertEquals(+1, f1.compareTo(f2)); 
     f2 = Fraction.getFraction(4, 10); 
     assertEquals(+1, f1.compareTo(f2)); 
     f2 = Fraction.getFraction(0, 2); 
     assertEquals(0, f1.compareTo(f2)); 
     f2 = Fraction.getFraction(2, 2); 
     assertEquals(-1, f1.compareTo(f2)); 
     f2 = Fraction.getFraction(-4, 10); 
     assertEquals(-1, f1.compareTo(f2)); 
     f2 = Fraction.getFraction(Integer.MAX_VALUE - 1, 1); 
     assertEquals(Integer.MAX_VALUE, f1.compareTo(f2)); 
 }
    

    

    
    

    

    
    
    
    

    

    

    
            
    
    
    
    
    
    
    
    
    
    
    
    
    
            
    
            
    
            
    
            
    
    
    
    
    
    
    
    
    
}
