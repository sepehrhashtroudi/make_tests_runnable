@Test
public void testStripEnd_StringString11414() { 
         // null stripEnd 
         assertEquals(null, StringUtils.stripEnd(null, null)); 
         assertEquals("", StringUtils.stripEnd("", null)); 
         assertEquals("", StringUtils.stripEnd("", "")); 
         assertEquals("", StringUtils.stripEnd("  ", null)); 
         assertEquals(StringUtilsTest.NON_WHITESPACE,  
             StringUtils.stripEnd(StringUtilsTest.WHITESPACE, "")); 
          
         // "" stripEnd 
         assertEquals(null, StringUtils.stripEnd(null, "")); 
         assertEquals("", StringUtils.stripEnd("", "")); 
         assertEquals("", StringUtils.stripEnd("", "")); 
         assertEquals("  ", StringUtils.stripEnd("  ", "")); 
          
         // " " stripEnd 
         assertEquals(null, StringUtils.stripEnd(null, " ")); 
         assertEquals("", StringUtils.stripEnd("", " ")); 
         assertEquals("  ", StringUtils.stripEnd("  ", " ")); 
          
         // "ab" stripEnd 
         assertEquals(null, StringUtils.stripEnd(null, "ab")); 
         assertEquals("", StringUtils.stripEnd("", "ab")); 
         assertEquals("ab", StringUtils.stripEnd("ab", "ab")); 
         assertEquals("ab", StringUtils.stripEnd("ab", "")); 
         assertEquals("ab", StringUtils.stripEnd("ab", "ab")); 
          
         // "ab" stripEnd 
         assertEquals(null, StringUtils.stripEnd(null, "ab")); 
         assertEquals("", StringUtils.stripEnd("", "ab")); 
         assertEquals("ab", StringUtils.stripEnd("ab", "ab")); 
         assertEquals("ab", StringUtils.stripEnd("ab", "ab ")); 
          
         // "ab" stripEnd 
         assertEquals("", StringUtils.