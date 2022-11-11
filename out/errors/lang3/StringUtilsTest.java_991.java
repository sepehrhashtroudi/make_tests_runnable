@Test
public void testGetLevenshteinDistance_StringString11901() { 
         // empty strings 
         assertEquals(0, StringUtils.getLevenshteinDistance("", "")); 
         assertEquals(7, StringUtils.getLevenshteinDistance("aaapppp", "")); 
         assertEquals(7, StringUtils.getLevenshteinDistance("aaapppp", "b")); 
         assertEquals(8, StringUtils.getLevenshteinDistance("aaapppp", "aa")); 
  
         // unequal strings, zero length 
         assertEquals(-1, StringUtils.getLevenshteinDistance("b", "a")); 
         assertEquals(-1, StringUtils.getLevenshteinDistance("a", "b")); 
      
         // equal strings 
         assertEquals(0, StringUtils.getLevenshteinDistance("aa", "aa")); 
         assertEquals(0, StringUtils.getLevenshteinDistance("aa", "aa")); 
  
         // same length 
         assertEquals(-1, StringUtils.getLevenshteinDistance("aaa", "bbb")); 
         assertEquals(-1, StringUtils.getLevenshteinDistance("aaa", "bbb")); 
      
         // big stripe 
         assertEquals(6, StringUtils.getLevenshteinDistance("aaaaaa", "b")); 
  
         // distance less than distance 
         assertEquals(7, StringUtils.getLevenshteinDistance("aaapppp", "b")); 
         assertEquals(3, StringUtils.getLevenshteinDistance("a", "bbb")); 
         assertEquals(3, StringUtils.getLevenshteinDistance("a", "bbb")); 
  
         // distance equal to distance 
         assertEquals(7, StringUtils.getLevenshteinDistance("aaapppp", "b")); 
         assertEquals(7, StringUtils.getLevenshteinDistance("aaapppp", "b")); 
         assertEquals(3, StringUtils.getLevenshteinDistance("