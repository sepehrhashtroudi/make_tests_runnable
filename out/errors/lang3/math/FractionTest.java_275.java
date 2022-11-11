@Test
public void testFactory_double10549() { 
         Fraction f = null; 
          
         // zero 
         f = Fraction.getFraction(0d); 
         assertEquals(0, f.getNumerator()); 
         assertEquals(1, f.getDenominator()); 
          
         f = Fraction.getFraction(1d); 
         assertEquals(1, f.getNumerator()); 
         assertEquals(1, f.getDenominator()); 
          
         f = Fraction.getFraction(2d); 
         assertEquals(2, f.getNumerator()); 
         assertEquals(1, f.getDenominator()); 
          
         f = Fraction.getFraction(3d); 
         assertEquals(3, f.getNumerator()); 
         assertEquals(2, f.getDenominator()); 
          
         // normal 
         f = Fraction.getFraction(4d); 
         assertEquals(3, f.getNumerator()); 
         assertEquals(4, f.getDenominator()); 
          
         // negatives 
         try { 
             f = Fraction.getFraction(Double.NaN); 
             fail("expecting ArithmeticException"); 
         } catch (final ArithmeticException ex) {} 
  
         try { 
             f = Fraction.getFraction(1d); 
             fail("expecting ArithmeticException"); 
         } catch (final ArithmeticException ex) {} 
  
         try { 
             f = Fraction.getFraction(Double.NEGATIVE_INFINITY); 
             fail("expecting ArithmeticException"); 
         } catch (final ArithmeticException ex) {} 
          
         // negative 
         f = Fraction.getFraction(-1d); 
         assertEquals(-16, f.getNumerator()); 
         assertEquals(1, f.getDenominator());