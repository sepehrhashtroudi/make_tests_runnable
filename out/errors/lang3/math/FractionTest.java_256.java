@Test
public void testFactory_double10530() { 
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
          
         // normal 
         f = Fraction.getFraction(3d); 
         assertEquals(3, f.getNumerator()); 
         assertEquals(2, f.getDenominator()); 
          
         // negatives 
         try { 
             f = Fraction.getFraction(Double.MIN_VALUE); 
             fail("expecting ArithmeticException"); 
         } catch (final ArithmeticException ex) {} 
  
         try { 
             f = Fraction.getFraction(Double.MAX_VALUE); 
             fail("expecting ArithmeticException"); 
         } catch (final ArithmeticException ex) {} 
  
         try { 
             f = Fraction.getFraction(1d); 
             fail("expecting ArithmeticException"); 
         } catch (final ArithmeticException ex) {} 
          
         // negatives 
         f = Fraction.getFraction(-1d); 
         assertEquals(-16, f.getNumerator()); 
         assertEquals(1, f.getDenominator()); 
          
         try { 
             f = Fraction.getFraction(1d); 
             fail("expecting ArithmeticException"); 
         } catch (final ArithmeticException ex) {} [