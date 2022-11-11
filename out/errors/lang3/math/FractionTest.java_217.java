@Test
public void testReducedFactory_int_int10491() { 
         Fraction f = null; 
          
         // zero 
         f = Fraction.getReducedFraction(0, 1); 
         assertEquals(0, f.getNumerator()); 
         assertEquals(1, f.getDenominator()); 
          
         f = Fraction.getReducedFraction(1, 1); 
         assertEquals(1, f.getNumerator()); 
         assertEquals(1, f.getDenominator()); 
          
         f = Fraction.getReducedFraction(2, 1); 
         assertEquals(2, f.getNumerator()); 
         assertEquals(1, f.getDenominator()); 
          
         // normal 
         f = Fraction.getReducedFraction(3, 1); 
         assertEquals(3, f.getNumerator()); 
         assertEquals(1, f.getDenominator()); 
          
         // negatives 
         f = Fraction.getReducedFraction(-6, 10); 
         assertEquals(-3, f.getNumerator()); 
         assertEquals(5, f.getDenominator()); 
          
         try { 
             f = Fraction.getReducedFraction(1, -6); 
             fail("expecting ArithmeticException"); 
         } catch (final ArithmeticException ex) {} 
  
         try { 
             f = Fraction.getReducedFraction(Integer.MIN_VALUE, 1); 
             fail("expecting ArithmeticException"); 
         } catch (final ArithmeticException ex) {} 
  
         try { 
             f = Fraction.