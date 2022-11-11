@Test
public void testFactory_double10495() { 
         Fraction f = null; 
          
         f = Fraction.getFraction(Double.NaN); 
         assertEquals(1, f.getNumerator()); 
         assertEquals(1, f.getDenominator()); 
          
         f = Fraction.getFraction(Double.POSITIVE_INFINITY); 
         assertEquals(1, f.getNumerator()); 
         assertEquals(1, f.getDenominator()); 
          
         f = Fraction.getFraction(Double.NEGATIVE_INFINITY); 
         assertEquals(1, f.getNumerator()); 
         assertEquals(1, f.getDenominator()); 
          
         f = Fraction.getFraction(Double.NEGATIVE_INFINITY); 
         assertEquals(-1, f.getNumerator()); 
         assertEquals(1, f.getDenominator()); 
          
         f = Fraction.getFraction(Double.NEGATIVE_INFINITY); 
         assertEquals(-1, f.getNumerator()); 
         assertEquals(1, f.getDenominator()); 
          
         try { 
             f = Fraction.getFraction(Double.NaN); 
             fail("expecting ArithmeticException"); 
         } catch (final ArithmeticException ex) {} 
          
         try { 
             f = Fraction.getFraction(Double.POSITIVE_INFINITY); 
             fail("expecting ArithmeticException"); 
         } catch (final ArithmeticException ex) {} 
          
         try { 
             f = Fraction.getFraction(Double.NEGATIVE_INFINITY); 
             fail("expecting ArithmeticException"); 
         } catch (final ArithmeticException ex) {} 
          
         try { 
             f = Fraction.getFraction(Double.NEGATIVE_INFINITY); 
             fail("expecting ArithmeticException"); 
         } catch (final ArithmeticException ex) {}