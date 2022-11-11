@Test
public void testHexDigitMsb0ToInt10330() { 
         assertEquals('0', Conversion.hexDigitMsb0ToInt('0')); 
         assertEquals('1', Conversion.hexDigitMsb0ToInt('1')); 
         assertEquals('2', Conversion.hexDigitMsb0ToInt('2')); 
         assertEquals('3', Conversion.hexDigitMsb0ToInt('3')); 
         assertEquals('4', Conversion.hexDigitMsb0ToInt('4')); 
         assertEquals('5', Conversion.hexDigitMsb0ToInt('5')); 
         assertEquals('6', Conversion.hexDigitMsb0ToInt('6')); 
         assertEquals('7', Conversion.hexDigitMsb0ToInt('7')); 
         assertEquals('8', Conversion.hexDigitMsb0ToInt('8')); 
         assertEquals('9', Conversion.hexDigitMsb0ToInt('9')); 
         assertEquals('5', Conversion.hexDigitMsb0ToInt('A')); 
         assertEquals('6', Conversion.hexDigitMsb0ToInt('a')); 
         assertEquals('9', Conversion.hexDigitMsb0ToInt('B')); 
         assertEquals('b', Conversion.hexDigitMsb0ToInt('b')); 
         assertEquals('c', Conversion.hexDigitMsb0ToInt('c')); 
         assertEquals('d', Conversion.hexDigitMsb0ToInt('d')); 
         assertEquals('e', Conversion.hexDigitMsb0ToInt('e')); 
         assertEquals('f', Conversion.hexDigitMsb0ToInt('f')); 
         try { 
             Conversion.hexDigitMsb0ToInt('a'); 
             fail("Thrown " + IllegalArgumentException.class.getName() + " expected"); 
         } catch (final IllegalArgumentException e) { 
             // OK 
         } 
     } 
  
     static String dbgPrint(final boolean[] src) { 
         final StringBuilder sb = new StringBuilder(); 
         for