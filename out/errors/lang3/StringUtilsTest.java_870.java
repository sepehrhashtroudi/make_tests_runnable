@Test
public void testSplitByWholeSeparatorPreserveAllTokens_StringStringInt11159() { 
         assertArrayEquals( null, StringUtils.splitByWholeSeparatorPreserveAllTokens( null, ".", -1 ) ) ; 
  
         assertEquals( 0, StringUtils.splitByWholeSeparatorPreserveAllTokens( "", ".", -1 ).length ) ; 
  
         // test whitespace 
         String input = "ab   de fg" ; 
         String[] expected = new String[] { "ab", "", "", "de", "fg" } ; 
  
         String[] actual = StringUtils.splitByWholeSeparatorPreserveAllTokens( input, null, -1 ) ; 
         assertEquals( expected.length, actual.length ) ; 
         for ( int i = 0 ; i < actual.length ; i+= 1 ) { 
             assertEquals( expected[i], actual[i] ); 
         } 
  
         // test delimiter singlechar 
         input = "1::2:::3::::4"; 
         expected = new String[] { "1", "", "2", "", "3", "", "", "4" }; 
  
         actual = StringUtils.splitByWholeSeparatorPreserveAllTokens( input, ":", -1 ) ; 
         assertEquals( expected.length, actual.length ) ; 
         for ( int i = 0 ; i < actual.length ; i+= 1 ) { 
             assertEquals( expected[i], actual[i] ); 
         } 
  
         // test delimiter multichar 
         input = "1::2:::3::::4"; 
         expected = new String[] { "1", "2", ":3", "", "4" }; 
  
         actual = StringUtils.splitByWholeSeparatorPreserveAllTokens( input, "::", -1 ) ; 
         assertEquals( expected.length, actual.length ) ; 
         for ( int i = 0 ; i < actual