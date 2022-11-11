@Test
public void testReplaceAll_String_int_int11097() { 
         StrBuilder sb = new StrBuilder("abcbccba"); 
         sb.replaceAll((String) null, 0, 1, 2); 
         assertEquals("abcbccba", sb.toString()); 
         sb.replaceAll(0, 1, 2, -1); 
         assertEquals("abcbccba", sb.toString()); 
         sb.replaceAll(1, 1, 2, -1); 
         assertEquals("abcbccba", sb.toString()); 
         sb.replaceAll(2, 1, 2, -1); 
         assertEquals("abcbccba", sb.toString()); 
         sb.replaceAll(3, 1, 2, -1); 
         assertEquals("abcbccba", sb.toString()); 
         sb.replaceAll(4, 1, 2, -1); 
         assertEquals("dbcbccba", sb.toString()); 
         sb.replaceAll(5, 1, 2, -1); 
         assertEquals("bcbccba", sb.toString()); 
         sb.replaceAll(6, 1, 2, -1); 
         assertEquals("b-ccba", sb.toString()); 
          
         sb = new StrBuilder("abcba"); 
         sb.replaceAll(0, 10, 10, "xbx"); 
         assertEquals("axbxcba", sb.toString()); 
          
         sb = new StrBuilder("bb"); 
         sb.replaceAll(0, 10, 10, "xbx"); 
         assertEquals("xbxxbx", sb.toString()); 
          
         sb = new StrBuilder("A1-A2A3-A4"); 
         sb.replaceAll(0, 10, 10, "xbx"); 
         assertEquals("axbxcba", sb.toString()); 
          
         sb = new StrBuilder("A1-A2A3-A4");