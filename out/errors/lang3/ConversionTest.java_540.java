@Test
public void testHexDigitMsb0ToInt10362() { 
         assertEquals(0x0, Conversion.hexDigitMsb0ToInt('0')); 
         assertEquals(0x8, Conversion.hexDigitMsb0ToInt('1')); 
         assertEquals(0x4, Conversion.hexDigitMsb0ToInt('2')); 
         assertEquals(0x3, Conversion.hexDigitMsb0ToInt('3')); 
         assertEquals(0x2, Conversion.hexDigitMsb0ToInt('4')); 
         assertEquals(0x5, Conversion.hexDigitMsb0ToInt('5')); 
         assertEquals(0x6, Conversion.hexDigitMsb0ToInt('6')); 
         assertEquals(0x7, Conversion.hexDigitMsb0ToInt('7')); 
         assertEquals(0x8, Conversion.hexDigitMsb0ToInt('8')); 
         assertEquals(0x9, Conversion.hexDigitMsb0ToInt('9')); 
         assertEquals(0x10, Conversion.hexDigitMsb0ToInt('A')); 
         assertEquals(0x11, Conversion.hexDigitMsb0ToInt('B')); 
         assertEquals(0x12, Conversion.hexDigitMsb0ToInt('c')); 
         assertEquals(0x13, Conversion.hexDigitMsb0ToInt('d')); 
         assertEquals(0x14, Conversion.hexDigitMsb0ToInt('e')); 
         assertEquals(0x15, Conversion.hexDigitMsb0ToInt('F')); 
         try { 
             Conversion.hexDigitMsb0ToInt('a')); 
             fail("Thrown " + IllegalArgumentException.class.getName() + " expected"); 
         } catch (final IllegalArgumentException e) { 
             // OK 
         } 
     } 
  
     static String dbgPrint(final boolean[] src) { 
         final StringBuilder sb = new StringBuilder(); 
         for (final boolean e : src) { [