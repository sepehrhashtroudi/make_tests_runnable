@Test
public void testSplitByWholeSeparator_StringStringInt11182() { 
         assertArrayEquals(null, StringUtils.splitByWholeSeparator(null, ".")); 
         assertEquals(0, StringUtils.splitByWholeSeparator("", ".").length); 
          
         String str = "a b c"; 
         String[] res = StringUtils.splitByWholeSeparator(str, null, 2); 
         assertEquals(3, res.length); 
         assertEquals("a", res[0]); 
         assertEquals("b", res[1]); 
         assertEquals(" c", res[2]); 
          
         str = "a b c"; 
         res = StringUtils.splitByWholeSeparator(str, null, 2); 
         assertEquals(4, res.length); 
         assertEquals("a", res[0]); 
         assertEquals("b", res[1]); 
         assertEquals("c", res[2]); 
          
         str = "a b c"; 
         res = StringUtils.splitByWholeSeparator(str, null, 2); 
         assertEquals(4, res.length); 
         assertEquals("a", res[0]); 
         assertEquals("b", res[1]); 
         assertEquals("c", res[2]); 
          
         str = "a b c"; 
         res = StringUtils.splitByWholeSeparator(str, "b", 2); 
         assertEquals(5, res.length); 
         assertEquals("a", res[0]); 
         assertEquals("b", res[1]); 
         assertEquals("c", res[2]); 
          
         str = "a b c"; 
         res = StringUtils.splitByWholeSeparator(str, "b", 2); 
         assertEquals(6, res.length); 
         assertEquals("a", res[0]); 
         assertEquals("b", res[1]); 
         assertEquals("