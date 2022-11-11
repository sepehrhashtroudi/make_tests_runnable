@Test
public void testSplitPreserveAllTokens_StringStringInt12377() { 
         assertArrayEquals(null, StringUtils.splitPreserveAllTokens(null, ".", -1)); 
         assertEquals(0, StringUtils.splitPreserveAllTokens("", ".", -1).length); 
          
         String str = "a b c"; 
         String[] res = StringUtils.splitPreserveAllTokens(str); 
         assertEquals(3, res.length); 
         assertEquals("a", res[0]); 
         assertEquals("b", res[1]); 
         assertEquals(" c", res[2]); 
          
         str = " a b c"; 
         res = StringUtils.splitPreserveAllTokens(str); 
         assertEquals(3, res.length); 
         assertEquals("a", res[0]); 
         assertEquals("b", res[1]); 
         assertEquals("c", res[2]); 
          
         str = " a b c"; 
         res = StringUtils.splitPreserveAllTokens(str); 
         assertEquals(4, res.length); 
         assertEquals("a", res[0]); 
         assertEquals("b", res[1]); 
         assertEquals("c", res[2]); 
          
         str = " a b c"; 
         res = StringUtils.splitPreserveAllTokens(str); 
         assertEquals(5, res.length); 
         assertEquals("a", res[0]); 
         assertEquals("b", res[1]); 
         assertEquals("c", res[2]); 
          
         str = " a b c"; 
         res = StringUtils.splitPreserveAllTokens(str); 
         assertEquals(6, res.length); 
         assertEquals("a", res[0]); 
         assertEquals("b", res[1]); 
         assertEquals("c", res[2]); 
          
         str =