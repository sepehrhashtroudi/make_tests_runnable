@Test
public void testSplitPreserveAllTokens_StringStringInt12383() { 
         assertArrayEquals(null, StringUtils.splitPreserveAllTokens(null, ".", -1)); 
         assertEquals(0, StringUtils.splitPreserveAllTokens("", ".", -1).length); 
  
         String str = "a b c"; 
         String[] res = StringUtils.splitPreserveAllTokens(str, ".", -1); 
         assertEquals(3, res.length); 
         assertEquals("a", res[0]); 
         assertEquals("b", res[1]); 
         assertEquals(" c", res[2]); 
          
         str = " a b c"; 
         res = StringUtils.splitPreserveAllTokens(str, ".", -1); 
         assertEquals(3, res.length); 
         assertEquals("a", res[0]); 
         assertEquals("b", res[1]); 
         assertEquals("c", res[2]); 
          
         str = " a b c"; 
         res = StringUtils.splitPreserveAllTokens(str, ".", 0); 
         assertEquals(3, res.length); 
         assertEquals("a", res[0]); 
         assertEquals("b", res[1]); 
         assertEquals("c", res[2]); 
          
         str = " a b c"; 
         res = StringUtils.splitPreserveAllTokens(str, ".", 3); 
         assertEquals(3, res.length); 
         assertEquals("a", res[0]); 
         assertEquals("b", res[1]); 
         assertEquals("c", res[2]); 
          
         str = " a b c"; 
         res = StringUtils.splitPreserveAllTokens(str, ".", 4); 
         assertEquals(4, res.length); 
         assertEquals("a", res[0]); 
         assertEquals("b", res[1]); [