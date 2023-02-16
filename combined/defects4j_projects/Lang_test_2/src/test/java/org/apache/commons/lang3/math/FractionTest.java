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
public void testFactory_String_double112() { 
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
public void testPow115() { 
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
public void testToString117() { 
     Fraction f = null; 
     f = Fraction.getFraction(3, 5); 
     final String str = f.toString(); 
     assertEquals("3/5", str); 
     assertSame(str, f.toString()); 
     f = Fraction.getFraction(7, 5); 
     assertEquals("1 2/5", f.toString()); 
     f = Fraction.getFraction(14, 10); 
     assertEquals("1 4/10", f.toString()); 
     f = Fraction.getFraction(4, 2); 
     assertEquals("2", f.toString()); 
     f = Fraction.getFraction(0, 2); 
     assertEquals("0", f.toString()); 
     f = Fraction.getFraction(2, 2); 
     assertEquals("1", f.toString()); 
     f = Fraction.getFraction(-7, 5); 
     assertEquals("-1 2/5", f.toString()); 
     f = Fraction.getFraction(Integer.MIN_VALUE, 0, 1); 
     assertEquals("-2147483648", f.toString()); 
     f = Fraction.getFraction(-1, 1, Integer.MAX_VALUE); 
     assertEquals("-1 1/2147483647", f.toString()); 
     assertEquals("-1", Fraction.getFraction(-1, -1, Integer.MAX_VALUE).toString()); 
 }
    

    

    
    

    

    
    
    
    

    

    

    
            
    
    
    
    
    
    
    
    
    
    
    
    
    
            
    
            
    
            
    
            
    
    
    
    
    
    
    
    
    
}
