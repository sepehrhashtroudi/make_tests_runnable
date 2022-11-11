@Test
public void testSplitPreserveAllTokens_StringStringInt12405() { 
         assertArrayEquals(null, StringUtils.splitPreserveAllTokens(null, ".")); 
         assertEquals(0, StringUtils.splitPreserveAllTokens("", ".").length); 
          
         String str = "a.b.. c"; 
         String[] res = StringUtils.splitPreserveAllTokens(str, "."); 
         assertEquals(3, res.length); 
         assertEquals("a", res[0]); 
         assertEquals("b", res[1]); 
         assertEquals(" c", res[2]); 
          
         str = ".a."; 
         res = StringUtils.splitPreserveAllTokens(str, "."); 
         assertEquals(1, res.length); 
         assertEquals("a", res[0]); 
          
         str = "a b c"; 
         res = StringUtils.splitPreserveAllTokens(str,' '); 
         assertEquals(3, res.length); 
         assertEquals("a", res[0]); 
         assertEquals("b", res[1]); 
         assertEquals("c", res[2]); 
          
         str = " a b c"; 
         res = StringUtils.splitPreserveAllTokens(str,' '); 
         assertEquals(4, res.length); 
         assertEquals("a", res[0]); 
         assertEquals("b", res[1]); 
         assertEquals("c", res[2]); 
          
         str = " a b c"; 
         res = StringUtils.splitPreserveAllTokens(str,' '); 
         assertEquals(5, res.length); 
         assertEquals("a", res[0]); 
         assertEquals("b", res[1]); 
         assertEquals("c", res[2]); 
          
         str = " a b c"; 
         res = StringUtils.splitPreserveAllTokens(str,' '); [EOL