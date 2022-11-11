@Test
public void testCapitalize_String10468() { 
         assertEquals(null, StringUtils.capitalize(null)); 
         assertEquals("", StringUtils.capitalize("")); 
         assertEquals("  ", StringUtils.capitalize("  ")); 
          
         assertEquals("i", WordUtils.capitalize("I") ); 
         assertEquals("I", WordUtils.capitalize("i") ); 
         assertEquals("I AM HERE 123", StringUtils.capitalize("i am here 123") ); 
         assertEquals("i aM hERE 123", StringUtils.capitalize("I Am Here 123") ); 
         assertEquals("I AM here 123", StringUtils.capitalize("i am HERE 123") ); 
         assertEquals("i am here 123", StringUtils.capitalize("I AM HERE 123") ); 
  
         final String test = "This String contains a TitleCase character: \u01C8"; 
         final String expect = "tHIS sTRING CONTAINS A tITLEcASE CHARACTER: \u01C9"; 
         assertEquals(expect, WordUtils.capitalize(test)); 
     } 
  
 }