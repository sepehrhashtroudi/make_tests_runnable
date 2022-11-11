@Test
public void testSamePrefixAndSuffix12052() { 
         final Map<String, String> map = new HashMap<String, String>(); 
         map.put("greeting", "Hello"); 
         map.put(" there ", "XXX"); 
         map.put("name", "commons"); 
         assertEquals("Hi commons!", StrSubstitutor.replace("Hi @name@!", map, "@", "@")); 
         assertEquals("Hello there commons!", StrSubstitutor.replace("@greeting@ there @name@!", map, "@", "@")); 
     } 
  
     //----------------------------------------------------------------------- 
     private void doTestReplace(final String expectedResult, final String replaceTemplate, final boolean substring) { 
         final String expectedShortResult = expectedResult.substring(1, expectedResult.length() - 1); 
         final StrSubstitutor sub = new StrSubstitutor(values); 
  
         // replace using String 
         assertEquals(expectedResult, sub.replace(replaceTemplate)); 
         if (substring) { 
             assertEquals(expectedShortResult, sub.replace(replaceTemplate, 1, replaceTemplate.length() - 2)); 
         } 
  
         // replace using char[] 
         final char[] chars = replaceTemplate.toCharArray(); 
         assertEquals(expectedResult, sub.replace(chars)); 
         if (substring) { 
             assertEquals(expectedShortResult, sub.replace(chars, 1, chars.length - 2)); 
         } 
  
         // replace using StringBuffer 
         StringBuffer buf = new StringBuffer(replaceTemplate); 
         assertEquals(expectedResult, sub.replace(buf)); 
         if (substring) { 
             assertEquals(expectedShortResult, sub.replace(buf, 1, buf.length() - 2)); 
         } 
  
         // replace using StringBuilder 
         StringBuilder builder = new StringBuilder(replaceTemplate); 
         assertEquals(