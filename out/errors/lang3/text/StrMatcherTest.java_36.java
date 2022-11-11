@Test
public void testReplaceFirst_StrMatcher_String11371() { 
         StrBuilder sb = new StrBuilder("abcbccba"); 
         sb.replaceFirst((StrMatcher) null, null); 
         assertEquals("abcbccba", sb.toString()); 
         sb.replaceFirst((StrMatcher) null, "anything"); 
         assertEquals("abcbccba", sb.toString()); 
         sb.replaceFirst(StrMatcher.noneMatcher(), null); 
         assertEquals("abcbccba", sb.toString()); 
         sb.replaceFirst(StrMatcher.noneMatcher(), "anything"); 
         assertEquals("abcbccba", sb.toString()); 
          
         sb.replaceFirst(StrMatcher.charMatcher('x'), "y"); 
         assertEquals("abcbccba", sb.toString()); 
         sb.replaceFirst(StrMatcher.charMatcher('a'), "d"); 
         assertEquals("dbcbccba", sb.toString()); 
         sb.replaceFirst(StrMatcher.charMatcher('d'), null); 
         assertEquals("bcbccba", sb.toString()); 
         sb.replaceFirst(StrMatcher.stringMatcher("cb"), "-"); 
         assertEquals("b-ccba", sb.toString()); 
          
         sb = new StrBuilder("abcba"); 
         sb.replaceFirst(StrMatcher.charMatcher('b'), "xbx"); 
         assertEquals("axbxcba", sb.toString()); 
          
         sb = new StrBuilder("bb"); 
         sb.replaceFirst(StrMatcher.charMatcher('b'), "xbx"); 
         assertEquals("xbxb", sb.toString()); 
          
         sb = new StrBuilder("A1-A2A3-A4"); 
         sb.replaceFirst(A_NUMBER_MATCHER, "***"); 
         assertEquals("***-A2A3-A4", sb.toString()); 
     } 
  [EOL