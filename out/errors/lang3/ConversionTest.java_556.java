@Test
public void testBinaryToHexDigitMsb0_4bits10696() { 
         assertEquals( 
             '0', Conversion.binaryToHexDigitMsb0_4bits(new boolean[]{false, false, false, false})); 
         assertEquals( 
             '1', Conversion.binaryToHexDigitMsb0_4bits(new boolean[]{false, false, false, true})); 
         assertEquals( 
             '2', Conversion.binaryToHexDigitMsb0_4bits(new boolean[]{false, false, true, false})); 
         assertEquals( 
             '3', Conversion.binaryToHexDigitMsb0_4bits(new boolean[]{false, false, true, true})); 
         assertEquals( 
             '4', Conversion.binaryToHexDigitMsb0_4bits(new boolean[]{false, true, false, false})); 
         assertEquals( 
             '5', Conversion.binaryToHexDigitMsb0_4bits(new boolean[]{false, true, false, true})); 
         assertEquals( 
             '6', Conversion.binaryToHexDigitMsb0_4bits(new boolean[]{false, true, true, false})); 
         assertEquals( 
             '7', Conversion.binaryToHexDigitMsb0_4bits(new boolean[]{false, true, true, true})); 
         assertEquals( 
             '8', Conversion.binaryToHexDigitMsb0_4bits(new boolean[]{true, false, false, false})); 
         assertEquals( 
             '9', Conversion.binaryToHexDigitMsb0_4bits(new boolean[]{true, false, false, true})); 
         assertEquals( 
             'a', Conversion.binaryToHexDigitMsb0_4bits(new boolean[]{true, false, true, false})); 
         assertEquals( 
             'b', Conversion.binaryToHexDigitMsb0_4bits(new boolean[]{true, false, true,