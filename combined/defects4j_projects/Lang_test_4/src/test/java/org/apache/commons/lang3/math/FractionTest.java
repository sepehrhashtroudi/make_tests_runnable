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
public void testHashCode101() { 
     final Fraction f1 = Fraction.getFraction(3, 5); 
     Fraction f2 = Fraction.getFraction(3, 5); 
     assertTrue(f1.hashCode() == f2.hashCode()); 
     f2 = Fraction.getFraction(2, 5); 
     assertTrue(f1.hashCode() != f2.hashCode()); 
     f2 = Fraction.getFraction(6, 10); 
     assertTrue(f1.hashCode() != f2.hashCode()); 
 }
@Test
public void testToProperString102() { 
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
public void testAdd112() { 
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
     f2 = Fraction.getFraction(-4, 5); 
     f = f1.add(f2); 
     assertEquals(-1, f.getNumerator()); 
     assertEquals(5, f.getDenominator()); 
     f1 = Fraction.getFraction(-3, 5); 
     f2 = Fraction.getFraction(-2, 5); 
     f = f1.add(f2); 
     assertEquals(6, f.getNumerator()); 
     assertEquals(5, f.getDenominator()); 
     f1 = Fraction.getFraction(-3, 5); 
     f2 = Fraction.getFraction(-2, 5); 
     f = f1.add(f2); 
     assertEquals(-6, f.getNumerator()); 
     assertEquals(5, f.getDenominator()); 
     f1 = Fraction.getFraction(-1, 5); 
     f2 = Fraction.getFraction(-1, 5); 
     f = f1.add(f2); 
     assertSame(Fraction.ZERO, f);
}

    

    

    
    

    

    
    
    
    

    

    

    
            
    
    
    
    
    
    
    
    
    
    
    
    
    
            
    
            
    
            
    
            
    
    
    
    
    
    
    
    
    
}
