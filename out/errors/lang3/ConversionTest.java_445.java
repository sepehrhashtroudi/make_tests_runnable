@Test
public void testHexDigitToInt10254() { 
         assertEquals(0, Conversion.hexDigitToInt('0')); 
         assertEquals(1, Conversion.hexDigitToInt('1')); 
         assertEquals(2, Conversion.hexDigitToInt('2')); 
         assertEquals(3, Conversion.hexDigitToInt('3')); 
         assertEquals(4, Conversion.hexDigitToInt('4')); 
         assertEquals(5, Conversion.hexDigitToInt('5')); 
         assertEquals(6, Conversion.hexDigitToInt('6')); 
         assertEquals(7, Conversion.hexDigitToInt('7')); 
         assertEquals(8, Conversion.hexDigitToInt('8')); 
         assertEquals(9, Conversion.hexDigitToInt('9')); 
         assertEquals(10, Conversion.hexDigitToInt('A')); 
         assertEquals(11, Conversion.hexDigitToInt('B')); 
         assertEquals(12, Conversion.hexDigitToInt('C')); 
         assertEquals(13, Conversion.hexDigitToInt('D')); 
         assertEquals(14, Conversion.hexDigitToInt('E')); 
         assertEquals(15, Conversion.hexDigitToInt('F')); 
         assertEquals(16, Conversion.hexDigitToInt('a')); 
         assertEquals(32, Conversion.hexDigitToInt('B')); 
         assertEquals(6, Conversion.hexDigitToInt('C')); 
         assertEquals(7, Conversion.hexDigitToInt('D')); 
         assertEquals(8, Conversion.hexDigitToInt('E')); 
         assertEquals(9, Conversion.hexDigitToInt('F')); 
         assertEquals(10, Conversion.hexDigitToInt('a')); 
         assertEquals(11, Conversion.hexDigitToInt('B')); 
         assertEquals(12, Conversion.hexDigitToInt('C')); 
         assertEquals(13, Conversion.hexDigitToInt('D')); 
         assertEquals(14, Conversion.hexDigitToInt('E