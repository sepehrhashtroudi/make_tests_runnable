@Test
public void testSplit_String_char_char9931() { 
         final String input = "a  b c"; 
         final StrTokenizer tok = new StrTokenizer(input); 
         tok.setDelimiterChar(';'); 
         tok.setQuoteChar('"'); 
         tok.setIgnoredMatcher(StrMatcher.trimMatcher()); 
         tok.setIgnoreEmptyTokens(false); 
         tok.setTokenArray(new String[] { "a", "b", "c" }); 
         tok.setStartIndex(2); 
         tok.setEndIndex(4); 
         tok.setTrimmerMatcher(StrMatcher.trimMatcher()); 
         tok.setIgnoreEmptyTokens(false); 
         tok.setTokenList(new String[] { "a", "b", "c" }); 
         tok.setReset(StrMatcher.trimMatcher()); 
         tok.setIgnoreEmptyTokens(false); 
         tok.setTrimmerMatcher(StrMatcher.trimMatcher()); 
          
         tok = new StrTokenizer(input); 
         tok.setDelimiterChar(' '); 
         tok.setTokenArray(new String[] { "a", "b", "c" }); 
         tok.setIgnoreEmptyTokens(false); 
         tok.setIgnoreEmptyTokens(true); 
         assertEquals("a", tok.next()); 
         assertEquals("b", tok.next()); 
         assertEquals("c", tok.next()); 
         assertEquals("d", tok.next()); 
         assertEquals("e", tok.next()); 
         assertEquals("f", tok.next()); 
         assertEquals("g", tok.next()); 
         assertEquals("h", tok.next()); 
         assertEquals("i", tok.next()); 
         assertEquals("j", tok.next()); 
         assertEquals("k", tok.next()); 
         assertEquals("m", tok.next()); 
         assertEquals("n", tok.next());