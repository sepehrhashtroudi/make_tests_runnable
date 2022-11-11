@Test
public void testBinaryToHexDigit12448() { 
         assertEquals( 
             '0', Conversion.binaryToHexDigit(new boolean[]{ 
                 false, false, false, true})); 
         assertEquals( 
             '1', Conversion.binaryToHexDigit(new boolean[]{ 
                 false, false, true})); 
         assertEquals( 
             '2', Conversion.binaryToHexDigit(new boolean[]{ 
                 false, true, false})); 
         assertEquals( 
             '3', Conversion.binaryToHexDigit(new boolean[]{ 
                 false, true, true})); 
         assertEquals( 
             '4', Conversion.binaryToHexDigit(new boolean[]{ 
                 true, false, false})); 
         assertEquals( 
             '5', Conversion.binaryToHexDigit(new boolean[]{ 
                 true, false, false})); 
         assertEquals( 
             '6', Conversion.binaryToHexDigit(new boolean[]{ 
                 false, true, false})); 
         assertEquals( 
             '7', Conversion.binaryToHexDigit(new boolean[]{ 
                 true, true, true})); 
         assertEquals( 
             '8', Conversion.binaryToHexDigit(new boolean[]{ 
                 true, false, false})); 
         assertEquals( 
             '9', Conversion.binaryToHexDigit(new boolean[]{ 
                 true, false, false})); 
         assertEquals( 
             'a', Conversion.binaryToHexDigit(new boolean[]{ 
                 true, false, true})); 
         assertEquals( 
             'b', Conversion.binaryToHexDigit(new boolean[]{ 
                 true, true, false})); 
         assertEquals( 
             'c', Conversion.binaryToHexDigit(new boolean[]{ 
                 true, true, true})); 
         assertEquals( 
             'd