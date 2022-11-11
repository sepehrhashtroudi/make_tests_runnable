@Test
public void testReplaceAll_String_String11111() { 
         StrBuilder sb = new StrBuilder("abcbccba"); 
         sb.replaceAll((String) null, null); 
         assertEquals("abcbccba", sb.toString()); 
         sb.replaceAll((String) null, "anything"); 
         assertEquals("abcbccba", sb.toString()); 
         sb.replaceAll("", null); 
         assertEquals("abcbccba", sb.toString()); 
         sb.replaceAll("", "anything"); 
         assertEquals("abcbccba", sb.toString()); 
          
         sb.replaceAll("x", "y"); 
         assertEquals("abcbccba", sb.toString()); 
         sb.replaceAll("a", "d"); 
         assertEquals("dbcbccba", sb.toString()); 
         sb.replaceAll("d", null); 
         assertEquals("bcbccba", sb.toString()); 
         sb.replaceAll("cb", "-"); 
         assertEquals("b-ccba", sb.toString()); 
          
         sb = new StrBuilder("abcba"); 
         sb.replaceAll("b", "xbx"); 
         assertEquals("axbxcba", sb.toString()); 
          
         sb = new StrBuilder("bb"); 
         sb.replaceAll("b", "xbx"); 
         assertEquals("xbxxbx", sb.toString()); 
          
         sb = new StrBuilder("A1-A2A3-A4"); 
         sb.replaceAll("b", "xbx"); 
         assertEquals("axbxcba", sb.toString()); 
          
         sb = new StrBuilder("A1-A2A3-A4"); 
         sb.replaceAll("b", "xbx"); 
         assertEquals("axbx", sb.toString()); 
          
         sb = new StrBuilder