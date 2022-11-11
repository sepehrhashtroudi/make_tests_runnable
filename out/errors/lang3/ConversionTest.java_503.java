@Test
public void testHexDigitMsb0ToBinary10325() { 
         assertBinaryEquals( 
             new boolean[]{false, false, false, false}, Conversion.hexDigitMsb0ToBinary('0')); 
         assertBinaryEquals( 
             new boolean[]{true, false, false, false}, Conversion.hexDigitMsb0ToBinary('1')); 
         assertBinaryEquals( 
             new boolean[]{false, true, false, false}, Conversion.hexDigitMsb0ToBinary('2')); 
         assertBinaryEquals( 
             new boolean[]{true, true, false, false}, Conversion.hexDigitMsb0ToBinary('3')); 
         assertBinaryEquals( 
             new boolean[]{false, false, true, false}, Conversion.hexDigitMsb0ToBinary('4')); 
         assertBinaryEquals( 
             new boolean[]{true, false, true, false}, Conversion.hexDigitMsb0ToBinary('5')); 
         assertBinaryEquals( 
             new boolean[]{false, true, true, false}, Conversion.hexDigitMsb0ToBinary('6')); 
         assertBinaryEquals( 
             new boolean[]{true, true, true, false}, Conversion.hexDigitMsb0ToBinary('7')); 
         assertBinaryEquals( 
             new boolean[]{false, false, false, true}, Conversion.hexDigitMsb0ToBinary('8')); 
         assertBinaryEquals( 
             new boolean[]{true, false, false, true}, Conversion.hexDigitMsb0ToBinary('9')); 
         assertBinaryEquals( 
             new boolean[]{false, true, false, true}, Conversion.hexDigitMsb0ToBinary('A')); 
         assertBinaryEquals( 
             new boolean[]{false, true, false, true}, Conversion.hexDigitMsb0ToBinary('a')); 
         assertBinaryEquals( 
             new boolean[]{true, true, false, true}, Conversion.hexDigitMsb0ToBinary('B')