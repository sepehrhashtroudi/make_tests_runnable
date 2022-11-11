@Test
public void testSubtract10533() { 
         Fraction f = null; 
         Fraction f1 = null; 
         Fraction f2 = null; 
          
         f1 = Fraction.getFraction(3, 5); 
         f2 = Fraction.getFraction(1, 5); 
         f = f1.subtract(f2); 
         assertEquals(2, f.getNumerator()); 
         assertEquals(5, f.getDenominator()); 
          
         f1 = Fraction.getFraction(3, 5); 
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
         assertEquals(-6, f.getNumerator()); 
         assertEquals(5, f.getDenominator()); 
          
         f1 = Fraction.getFraction(3, 5); 
         f2 = Fraction.getFraction(-4, 5); [