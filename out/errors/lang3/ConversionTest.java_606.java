@Test
public void testBinaryToHexDigit12462() { 
         assertEquals( 
             '0', Conversion.binaryToHexDigit(new boolean[]{false, false, false, false})); 
         assertEquals( 
             '1', Conversion.binaryToHexDigit(new boolean[]{false, false, false, true})); 
         assertEquals( 
             '2', Conversion.binaryToHexDigit(new boolean[]{false, false, true, false})); 
         assertEquals( 
             '3', Conversion.binaryToHexDigit(new boolean[]{false, false, true, true})); 
         assertEquals( 
             '4', Conversion.binaryToHexDigit(new boolean[]{false, true, false, false})); 
         assertEquals( 
             '5', Conversion.binaryToHexDigit(new boolean[]{false, true, false, true})); 
         assertEquals( 
             '6', Conversion.binaryToHexDigit(new boolean[]{false, true, true, false})); 
         assertEquals( 
             '7', Conversion.binaryToHexDigit(new boolean[]{false, true, true, true})); 
         assertEquals( 
             '8', Conversion.binaryToHexDigit(new boolean[]{true, false, false, false})); 
         assertEquals( 
             '9', Conversion.binaryToHexDigit(new boolean[]{true, false, false, false})); 
         assertEquals( 
             'a', Conversion.binaryToHexDigit(new boolean[]{true, false, true, false})); 
         assertEquals( 
             'b', Conversion.binaryToHexDigit(new boolean[]{true, false, true, true})); 
         assertEquals( 
             'c', Conversion.binaryToHex