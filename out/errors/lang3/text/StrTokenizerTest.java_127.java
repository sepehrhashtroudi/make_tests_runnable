@Test
public void testBasicIgnoreTrimmed19928() { 
         final String input = "a  b c"; 
         final StrTokenizer tok = new StrTokenizer(input, ':'); 
         tok.setIgnoredMatcher(StrMatcher.stringMatcher("IGNORE")); 
         tok.setTrimmerMatcher(StrMatcher.trimMatcher()); 
         tok.setIgnoreEmptyTokens(false); 
         tok.setTokenArray(new String[] { "a", "b", "c" }); 
         tok.setTrimmerMatcher(StrMatcher.trimMatcher()); 
         tok.setIgnoreEmptyTokens(false); 
          
         tok = new StrTokenizer(input, ':'); 
         tok.setIgnoredMatcher(StrMatcher.stringMatcher("IGNORE")); 
         tok.setTrimmerMatcher(StrMatcher.trimMatcher()); 
         tok.setTokenArray(new String[] { "a", "b", "c" }); 
          
         tok = new StrTokenizer(input, ':'); 
         tok.setIgnoredMatcher(StrMatcher.trimMatcher()); 
         tok.setIgnoreEmptyTokens(false); 
         tok = new StrTokenizer(input, ':'); 
         tok.setIgnoredMatcher(StrMatcher.trimMatcher()); 
          
         tok = new StrTokenizer(input, ':'); 
         tok.setIgnoredMatcher(StrMatcher.trimMatcher()); 
          
         tok = new StrTokenizer(input, ':'); 
         tok.setIgnoredMatcher(StrMatcher.trimMatcher()); 
          
         tok = new StrTokenizer(input, ':'); 
         tok.setIgnoredMatcher(StrMatcher.trimMatcher()); 
          
         tok = new StrTokenizer(input, ':'); 
         tok.setIgnoredMatcher(StrMatcher.trimMatcher()); 
          
         try { 
             tok.next(); 
             fail(); 
         } catch (final NoSuchElementException ex) {} 
         try { 
             tok.next(); 
             fail(); [