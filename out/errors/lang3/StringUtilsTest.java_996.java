@Test
public void testGetLevenshteinDistance_StringStringInt11906() { 
         // empty strings 
         assertEquals(0, StringUtils.getLevenshteinDistance("", "", 0)); 
         assertEquals(7, StringUtils.getLevenshteinDistance("aaapppp", "", 8)); 
         assertEquals(7, StringUtils.getLevenshteinDistance("aaapppp", "", 7)); 
         assertEquals(-1, StringUtils.getLevenshteinDistance("aaapppp", "", 6)); 
  
         // unequal strings, zero length 
         assertEquals(-1, StringUtils.getLevenshteinDistance("b", "a", 0)); 
         assertEquals(-1, StringUtils.getLevenshteinDistance("a", "b", 0)); 
      
         // equal strings 
         assertEquals(0, StringUtils.getLevenshteinDistance("aa", "aa", 0)); 
         assertEquals(0, StringUtils.getLevenshteinDistance("aa", "aa", 2)); 
  
         // same length 
         assertEquals(-1, StringUtils.getLevenshteinDistance("aaa", "bbb", 0)); 
         assertEquals(3, StringUtils.getLevenshteinDistance("aaa", "bbb", 3)); 
      
         // big stripe 
         assertEquals(6, StringUtils.getLevenshteinDistance("aaaaaa", "b", 10)); 
  
         // distance less than threshold 
         assertEquals(7, StringUtils.getLevenshteinDistance("aaapppp", "b", 8)); 
         assertEquals(3, StringUtils.getLevenshteinDistance("a", "bbb", 4)); 
      
         // distance equal to threshold 
         assertEquals(7, StringUtils.getLevenshteinDistance("aaapppp", "b", 7)); 
         assertEquals(3, StringUtils.getLevenshteinDistance("a", "bbb", 3)); 
  
         // distance greater than threshold 
         assertEquals(-1, StringUtils.getLevenshteinDistance("