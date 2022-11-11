@Test
public void testSplit_StringStringInt12371() { 
         assertArrayEquals(null, StringUtils.split(null, ".", -1)); 
         assertEquals(0, StringUtils.split("", ".", -1).length); 
  
         String str = "a.b.. c"; 
         String[] res = StringUtils.split(str, ".", -1); 
         assertEquals(3, res.length); 
         assertEquals("a", res[0]); 
         assertEquals("b", res[1]); 
         assertEquals(" c", res[2]); 
              
         str = ".a."; 
         res = StringUtils.split(str, ".", -1); 
         assertEquals(1, res.length); 
         assertEquals("a", res[0]); 
          
         str = "a b c"; 
         res = StringUtils.split(str,' '); 
         assertEquals(3, res.length); 
         assertEquals("a", res[0]); 
         assertEquals("b", res[1]); 
         assertEquals("c", res[2]); 
          
         str = "a b c"; 
         res = StringUtils.split(str,' '); 
         assertEquals(3, res.length); 
         assertEquals("a", res[0]); 
         assertEquals("b", res[1]); 
         assertEquals("c", res[2]); 
          
         str = "a b c"; 
         res = StringUtils.split(str,' '); 
         assertEquals(4, res.length); 
         assertEquals("a", res[0]); 
         assertEquals("b", res[1]); 
         assertEquals("c", res[2]); 
          
         str = "a b c"; 
         res = StringUtils.split(str,' '); 
         assertEquals(5, res.length); 
         assertEquals("a", res[0]);