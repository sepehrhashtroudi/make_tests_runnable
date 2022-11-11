@Test
public void testUncapitalize_String10455() { 
         assertEquals(null, StringUtils.uncapitalize(null)); 
         assertEquals("", StringUtils.uncapitalize("")); 
         assertEquals("  ", StringUtils.uncapitalize("  ")); 
          
         assertEquals("i", WordUtils.uncapitalize("I") ); 
         assertEquals("I", WordUtils.uncapitalize("i") ); 
         assertEquals("I AM HERE 123", StringUtils.uncapitalize("i am here 123") ); 
         assertEquals("i aM hERE 123", StringUtils.uncapitalize("I Am Here 123") ); 
         assertEquals("I AM here 123", StringUtils.uncapitalize("i am HERE 123") ); 
         assertEquals("i am here 123", StringUtils.uncapitalize("I AM HERE 123") ); 
  
         final String test = "This String contains a Title"; 
         final String expect = "tHIS sTRING CONTAINS A tITLEcASE CHARACTER: \u01C8"; 
         assertEquals(expect, WordUtils.uncapitalize(test)); 
     } 
  
 }