@Test
public void testFactory_double10498() { 
         Fraction f = null; 
          
         // zero 
         f = Fraction.getFraction(0.0); 
         assertEquals(0, f.getNumerator()); 
         assertEquals(1, f.getDenominator()); 
          
         f = Fraction.getFraction(1.0); 
         assertEquals(1, f.getNumerator()); 
         assertEquals(1, f.getDenominator()); 
          
         f = Fraction.getFraction(2.0); 
         assertEquals(2, f.getNumerator()); 
         assertEquals(1, f.getDenominator()); 
          
         f = Fraction.getFraction(3.0); 
         assertEquals(3, f.getNumerator()); 
         assertEquals(2, f.getDenominator()); 
          
         // normal 
         f = Fraction.getFraction(4.0); 
         assertEquals(3, f.getNumerator()); 
         assertEquals(4, f.getDenominator()); 
          
         // negatives 
         try { 
             f = Fraction.getFraction(Double.NaN); 
             fail("expecting ArithmeticException"); 
         } catch (final ArithmeticException ex) {} 
  
         try { 
             f = Fraction.getFraction(1.0); 
             fail("expecting ArithmeticException"); 
         } catch (final ArithmeticException ex) {} 
  
         try { 
             f = Fraction.getFraction(Double.NaN); 
             fail("expecting ArithmeticException"); 
         } catch (final ArithmeticException ex) {} 
          
         // negative 
         f = Fraction.getFraction(-1.0); 
             fail("expecting ArithmeticException"); 
         } catch (final ArithmeticException ex) {} 
  [