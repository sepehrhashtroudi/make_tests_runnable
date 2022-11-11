@Test
public void testStripStart_StringString11406() { 
         // null stripStart 
         assertEquals(null, StringUtils.stripStart(null, null)); 
         assertEquals("", StringUtils.stripStart("", null)); 
         assertEquals("", StringUtils.stripStart("", "")); 
         assertEquals("", StringUtils.stripStart("  ", null)); 
         assertEquals(StringUtilsTest.NON_WHITESPACE,  
             StringUtils.stripStart(StringUtilsTest.WHITESPACE, "")); 
          
         // "" stripStart 
         assertEquals(null, StringUtils.stripStart(null, "")); 
         assertEquals("", StringUtils.stripStart("", "")); 
         assertEquals("", StringUtils.stripStart("", "")); 
         assertEquals("  ", StringUtils.stripStart("  ", "")); 
          
         // " " stripStart 
         assertEquals(null, StringUtils.stripStart(null, " ")); 
         assertEquals("", StringUtils.stripStart("", " ")); 
         assertEquals("", StringUtils.stripStart("  ", " ")); 
         assertEquals("abc  ", StringUtils.stripStart("  abc  ", " ")); 
          
         // "ab" stripStart 
         assertEquals(null, StringUtils.stripStart(null, "ab")); 
         assertEquals("", StringUtils.stripStart("", "ab")); 
         assertEquals("", StringUtils.stripStart("  abc  ", "ab")); 
         assertEquals("ab", StringUtils.stripStart("  abc  ", "ab")); 
          
         // "ab" stripStart 
         assertEquals(null, StringUtils.stripStart(null, "ab")); 
         assertEquals("", StringUtils.stripStart("  abc  ", "ab")); 
         assertEquals("", StringUtils.stripStart("  abc  ", "ab")); 
         assertEquals("", StringUtils.stripStart("  abc  ", "ab")); 
          
         // "ab" strip