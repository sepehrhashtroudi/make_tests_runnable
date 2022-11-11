@Test
public void testFactory_String_proper10535() { 
         Fraction f = null; 
          
         f = Fraction.getFraction("0 0/1"); 
         assertEquals(0, f.getNumerator()); 
         assertEquals(1, f.getDenominator()); 
          
         f = Fraction.getFraction("1 1/5"); 
         assertEquals(6, f.getNumerator()); 
         assertEquals(5, f.getDenominator()); 
          
         f = Fraction.getFraction("7 1/2"); 
         assertEquals(15, f.getNumerator()); 
         assertEquals(2, f.getDenominator()); 
          
         f = Fraction.getFraction("1 2/4"); 
         assertEquals(6, f.getNumerator()); 
         assertEquals(4, f.getDenominator()); 
          
         f = Fraction.getFraction("-7 1/2"); 
         assertEquals(-15, f.getNumerator()); 
         assertEquals(2, f.getDenominator()); 
          
         try { 
             f = Fraction.getFraction("2 3/4"); 
             fail("expecting NumberFormatException"); 
         } catch (final NumberFormatException ex) {} 
          
         try { 
             f = Fraction.getFraction("a 3"); 
             fail("expecting NumberFormatException"); 
         } catch (final NumberFormatException ex) {} 
          
         try { 
             f = Fraction.getFraction("2 b/4"); 
             fail("expecting NumberFormatException"); 
         } catch (final NumberFormatException ex) {} 
          
         try { 
             f = Fraction.getFraction