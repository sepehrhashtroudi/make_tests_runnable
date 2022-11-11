@Test
public void testStripEnd_StringString11401() { 
         // null stripEnd 
         assertEquals(null, StringUtils.stripEnd(null, null)); 
         assertEquals("", StringUtils.stripEnd("", null)); 
         assertEquals("", StringUtils.stripEnd("", "")); 
         assertEquals("  ", StringUtils.stripEnd("  ", null)); 
          
         // "" stripEnd 
         assertEquals(null, StringUtils.stripEnd(null, "")); 
         assertEquals("", StringUtils.stripEnd("", "")); 
         assertEquals("  ", StringUtils.stripEnd("  ", "")); 
         assertEquals("  ", StringUtils.stripEnd("  ", "")); 
          
         // "ab" stripEnd 
         assertEquals(null, StringUtils.stripEnd(null, "ab")); 
         assertEquals("", StringUtils.stripEnd("", "ab")); 
         assertEquals("  ", StringUtils.stripEnd("  ", "ab")); 
         assertEquals("  abc  ", StringUtils.stripEnd("  abc  ", "ab")); 
          
         // "ab" stripEnd 
         assertEquals(null, StringUtils.stripEnd(null, "ab")); 
         assertEquals("", StringUtils.stripEnd("", "ab")); 
         assertEquals("  abc  ", StringUtils.stripEnd("  abc  ", "ab")); 
         assertEquals("  abc  ", StringUtils.stripEnd("  abc  ", "ab")); 
          
         // "ab" stripEnd 
         assertEquals(null, StringUtils.stripEnd(null, "ab")); 
         assertEquals("", StringUtils.stripEnd("  abc  ", "ab")); 
         assertEquals("  abc  ", StringUtils.stripEnd("  abc  ", "ab")); 
          
         // "ab" stripEnd 
         assertEquals("", StringUtils.stripEnd("  abc  ", "ab")); 
         assertEquals("  abc  ", StringUtils.strip