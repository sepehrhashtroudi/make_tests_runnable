@Test 
 public void testChaining138() { 
     final StrTokenizer tok = new StrTokenizer(); 
     assertEquals(tok, tok.reset()); 
     assertEquals(tok, tok.reset("")); 
     assertEquals(tok, tok.reset(new char[0])); 
     assertEquals(tok, tok.setDelimiterChar(' ')); 
     assertEquals(tok, tok.setDelimiterString(" ")); 
     assertEquals(tok, tok.setDelimiterMatcher(null)); 
     assertEquals(tok, tok.setQuoteChar(' ')); 
     assertEquals(tok, tok.setQuoteMatcher(null)); 
     assertEquals(tok, tok.setIgnoredChar(' ')); 
     assertEquals(tok, tok.setIgnoredMatcher(null)); 
     assertEquals(tok, tok.setTrimmerMatcher(null)); 
     assertEquals(tok, tok.setEmptyTokenAsNull(false)); 
     assertEquals(tok, tok.setIgnoreEmptyTokens(false)); 
 } 
@Test 
 public void testIteration144() { 
     final StrTokenizer tkn = new StrTokenizer("a b c"); 
     assertFalse(tkn.hasPrevious()); 
     try { 
         tkn.previous(); 
         fail(); 
     } catch (final NoSuchElementException ex) { 
     } 
     assertTrue(tkn.hasNext()); 
     assertEquals("a", tkn.next()); 
     try { 
         tkn.remove(); 
         fail(); 
     } catch (final UnsupportedOperationException ex) { 
     } 
     try { 
         tkn.set("x"); 
         fail(); 
     } catch (final UnsupportedOperationException ex) { 
     } 
     try { 
         tkn.add("y"); 
         fail(); 
     } catch (final UnsupportedOperationException ex) { 
     } 
     assertTrue(tkn.hasPrevious()); 
     assertTrue(tkn.hasNext()); 
     assertEquals("b", tkn.next()); 
     assertTrue(tkn.hasPrevious()); 
     assertTrue(tkn.hasNext()); 
     assertEquals("c", tkn.next()); 
     assertTrue(tkn.hasPrevious()); 
     assertFalse(tkn.hasNext()); 
     try { 
         tkn.next(); 
         fail(); 
     } catch (final NoSuchElementException ex) { 
     } 
     assertTrue(tkn.hasPrevious()); 
     assertFalse(tkn.hasNext()); 
 } 
@Test 
 public void testIteration151() { 
     final StrTokenizer tkn = new StrTokenizer("a b c"); 
     assertFalse(tkn.hasPrevious()); 
     try { 
         tkn.previous(); 
         fail(); 
     } catch (final NoSuchElementException ex) { 
     } 
     assertTrue(tkn.hasNext()); 
     assertEquals("a", tkn.next()); 
     try { 
         tkn.remove(); 
         fail(); 
     } catch (final UnsupportedOperationException ex) { 
     } 
     try { 
         tkn.set("x"); 
         fail(); 
     } catch (final UnsupportedOperationException ex) { 
     } 
     try { 
         tkn.add("y"); 
         fail(); 
     } catch (final UnsupportedOperationException ex) { 
     } 
     assertTrue(tkn.hasPrevious()); 
     assertTrue(tkn.hasNext()); 
     assertEquals("b", tkn.next()); 
     assertTrue(tkn.hasPrevious()); 
     assertTrue(tkn.hasNext()); 
     assertEquals("c", tkn.next()); 
     assertTrue(tkn.hasPrevious()); 
     assertFalse(tkn.hasNext()); 
     try { 
         tkn.next(); 
         fail(); 
     } catch (final NoSuchElementException ex) { 
     } 
     assertTrue(tkn.hasPrevious()); 
     assertFalse(tkn.hasNext()); 
 } 
@Test 
 public void testGetContent595() { 
     final String input = "a   b c \"d e\" f "; 
     StrTokenizer tok = new StrTokenizer(input); 
     assertEquals(input, tok.getContent()); 
     tok = new StrTokenizer(input.toCharArray()); 
     assertEquals(input, tok.getContent()); 
     tok = new StrTokenizer(); 
     assertEquals(null, tok.getContent()); 
 } 
@Test 
 public void testIteration697() { 
     final StrTokenizer tkn = new StrTokenizer("a b c"); 
     assertFalse(tkn.hasPrevious()); 
     try { 
         tkn.previous(); 
         fail(); 
     } catch (final NoSuchElementException ex) { 
     } 
     assertTrue(tkn.hasNext()); 
     assertEquals("a", tkn.next()); 
     try { 
         tkn.remove(); 
         fail(); 
     } catch (final UnsupportedOperationException ex) { 
     } 
     try { 
         tkn.set("x"); 
         fail(); 
     } catch (final UnsupportedOperationException ex) { 
     } 
     try { 
         tkn.add("y"); 
         fail(); 
     } catch (final UnsupportedOperationException ex) { 
     } 
     assertTrue(tkn.hasPrevious()); 
     assertTrue(tkn.hasNext()); 
     assertEquals("b", tkn.next()); 
     assertTrue(tkn.hasPrevious()); 
     assertTrue(tkn.hasNext()); 
     assertEquals("c", tkn.next()); 
     assertTrue(tkn.hasPrevious()); 
     assertFalse(tkn.hasNext()); 
     try { 
         tkn.next(); 
         fail(); 
     } catch (final NoSuchElementException ex) { 
     } 
     assertTrue(tkn.hasPrevious()); 
     assertFalse(tkn.hasNext()); 
 } 
@Test 
 public void testToString782() { 
     final StrTokenizer tkn = new StrTokenizer("a b c d e"); 
     assertEquals("StrTokenizer[not tokenized yet]", tkn.toString()); 
     tkn.next(); 
     assertEquals("StrTokenizer[a, b, c, d, e]", tkn.toString()); 
 } 
@Test 
 public void testCSVSimple785() { 
     this.testCSV(CSV_SIMPLE_FIXTURE); 
 } 
@Test 
 public void testConstructor_charArray_char_char869() { 
     StrTokenizer tok = new StrTokenizer("a b".toCharArray(), ' ', '"'); 
     assertEquals(1, tok.getDelimiterMatcher().isMatch(" ".toCharArray(), 0, 0, 1)); 
     assertEquals(1, tok.getQuoteMatcher().isMatch("\"".toCharArray(), 0, 0, 1)); 
     assertEquals("a", tok.next()); 
     assertEquals("b", tok.next()); 
     assertFalse(tok.hasNext()); 
     tok = new StrTokenizer(new char[0], ' ', '"'); 
     assertFalse(tok.hasNext()); 
     tok = new StrTokenizer((char[]) null, ' ', '"'); 
     assertFalse(tok.hasNext()); 
 } 
@Test 
 public void test51398() { 
     final String input = "a;b; c;\"d;\"\"e\";f; ; ;"; 
     final StrTokenizer tok = new StrTokenizer(input); 
     tok.setDelimiterChar(';'); 
     tok.setQuoteChar('"'); 
     tok.setIgnoredMatcher(StrMatcher.trimMatcher()); 
     tok.setIgnoreEmptyTokens(false); 
     tok.setEmptyTokenAsNull(true); 
     final String[] tokens = tok.getTokenArray(); 
     final String[] expected = new String[] { "a", "b", "c", "d;\"e", "f", null, null, null }; 
     assertEquals(ArrayUtils.toString(tokens), expected.length, tokens.length); 
     for (int i = 0; i < expected.length; i++) { 
         assertTrue("token[" + i + "] was '" + tokens[i] + "' but was expected to be '" + expected[i] + "'", ObjectUtils.equals(expected[i], tokens[i])); 
     } 
 } 
@Test 
 public void testBasicIgnoreTrimmed11404() { 
     final String input = "a: bIGNOREc : "; 
     final StrTokenizer tok = new StrTokenizer(input, ':'); 
     tok.setIgnoredMatcher(StrMatcher.stringMatcher("IGNORE")); 
     tok.setTrimmerMatcher(StrMatcher.trimMatcher()); 
     tok.setIgnoreEmptyTokens(false); 
     tok.setEmptyTokenAsNull(true); 
     assertEquals("a", tok.next()); 
     assertEquals("bc", tok.next()); 
     assertEquals(null, tok.next()); 
     assertFalse(tok.hasNext()); 
 } 
@Test 
 public void testGetContent1410() { 
     final String input = "a   b c \"d e\" f "; 
     StrTokenizer tok = new StrTokenizer(input); 
     assertEquals(input, tok.getContent()); 
     tok = new StrTokenizer(input.toCharArray()); 
     assertEquals(input, tok.getContent()); 
     tok = new StrTokenizer(); 
     assertEquals(null, tok.getContent()); 
 } 
@Test 
 public void test51414() { 
     final String input = "a;b; c;\"d;\"\"e\";f; ; ;"; 
     final StrTokenizer tok = new StrTokenizer(input); 
     tok.setDelimiterChar(';'); 
     tok.setQuoteChar('"'); 
     tok.setIgnoredMatcher(StrMatcher.trimMatcher()); 
     tok.setIgnoreEmptyTokens(false); 
     tok.setEmptyTokenAsNull(true); 
     final String[] tokens = tok.getTokenArray(); 
     final String[] expected = new String[] { "a", "b", "c", "d;\"e", "f", null, null, null }; 
     assertEquals(ArrayUtils.toString(tokens), expected.length, tokens.length); 
     for (int i = 0; i < expected.length; i++) { 
         assertTrue("token[" + i + "] was '" + tokens[i] + "' but was expected to be '" + expected[i] + "'", ObjectUtils.equals(expected[i], tokens[i])); 
     } 
 } 
@Test 
 public void test51484() { 
     final String input = "a;b; c;\"d;\"\"e\";f; ; ;"; 
     final StrTokenizer tok = new StrTokenizer(input); 
     tok.setDelimiterChar(';'); 
     tok.setQuoteChar('"'); 
     tok.setIgnoredMatcher(StrMatcher.trimMatcher()); 
     tok.setIgnoreEmptyTokens(false); 
     tok.setEmptyTokenAsNull(true); 
     final String[] tokens = tok.getTokenArray(); 
     final String[] expected = new String[] { "a", "b", "c", "d;\"e", "f", null, null, null }; 
     assertEquals(ArrayUtils.toString(tokens), expected.length, tokens.length); 
     for (int i = 0; i < expected.length; i++) { 
         assertTrue("token[" + i + "] was '" + tokens[i] + "' but was expected to be '" + expected[i] + "'", ObjectUtils.equals(expected[i], tokens[i])); 
     } 
 } 
@Test 
 public void testReset_String1516() { 
     final StrTokenizer tok = new StrTokenizer("x x x"); 
     tok.reset("d e"); 
     assertEquals("d", tok.next()); 
     assertEquals("e", tok.next()); 
     assertFalse(tok.hasNext()); 
     tok.reset((String) null); 
     assertFalse(tok.hasNext()); 
 } 
@Test 
 public void testBasicIgnoreTrimmed11541() { 
     final String input = "a: bIGNOREc : "; 
     final StrTokenizer tok = new StrTokenizer(input, ':'); 
     tok.setIgnoredMatcher(StrMatcher.stringMatcher("IGNORE")); 
     tok.setTrimmerMatcher(StrMatcher.trimMatcher()); 
     tok.setIgnoreEmptyTokens(false); 
     tok.setEmptyTokenAsNull(true); 
     assertEquals("a", tok.next()); 
     assertEquals("bc", tok.next()); 
     assertEquals(null, tok.next()); 
     assertFalse(tok.hasNext()); 
 } 
@Test 
 public void testConstructor_charArray_char_char1625() { 
     StrTokenizer tok = new StrTokenizer("a b".toCharArray(), ' ', '"'); 
     assertEquals(1, tok.getDelimiterMatcher().isMatch(" ".toCharArray(), 0, 0, 1)); 
     assertEquals(1, tok.getQuoteMatcher().isMatch("\"".toCharArray(), 0, 0, 1)); 
     assertEquals("a", tok.next()); 
     assertEquals("b", tok.next()); 
     assertFalse(tok.hasNext()); 
     tok = new StrTokenizer(new char[0], ' ', '"'); 
     assertFalse(tok.hasNext()); 
     tok = new StrTokenizer((char[]) null, ' ', '"'); 
     assertFalse(tok.hasNext()); 
 } 
@Test 
 public void testBasicIgnoreTrimmed11913() { 
     final String input = "a: bIGNOREc : "; 
     final StrTokenizer tok = new StrTokenizer(input, ':'); 
     tok.setIgnoredMatcher(StrMatcher.stringMatcher("IGNORE")); 
     tok.setTrimmerMatcher(StrMatcher.trimMatcher()); 
     tok.setIgnoreEmptyTokens(false); 
     tok.setEmptyTokenAsNull(true); 
     assertEquals("a", tok.next()); 
     assertEquals("bc", tok.next()); 
     assertEquals(null, tok.next()); 
     assertFalse(tok.hasNext()); 
 } 
@Test 
 public void testCSVSimpleNeedsTrim2133() { 
     this.testCSV("   " + CSV_SIMPLE_FIXTURE); 
     this.testCSV("   \n\t  " + CSV_SIMPLE_FIXTURE); 
     this.testCSV("   \n  " + CSV_SIMPLE_FIXTURE + "\n\n\r"); 
 } 
@Test 
 public void test52284() { 
     final String input = "a;b; c;\"d;\"\"e\";f; ; ;"; 
     final StrTokenizer tok = new StrTokenizer(input); 
     tok.setDelimiterChar(';'); 
     tok.setQuoteChar('"'); 
     tok.setIgnoredMatcher(StrMatcher.trimMatcher()); 
     tok.setIgnoreEmptyTokens(false); 
     tok.setEmptyTokenAsNull(true); 
     final String[] tokens = tok.getTokenArray(); 
     final String[] expected = new String[] { "a", "b", "c", "d;\"e", "f", null, null, null }; 
     assertEquals(ArrayUtils.toString(tokens), expected.length, tokens.length); 
     for (int i = 0; i < expected.length; i++) { 
         assertTrue("token[" + i + "] was '" + tokens[i] + "' but was expected to be '" + expected[i] + "'", ObjectUtils.equals(expected[i], tokens[i])); 
     } 
 } 
@Test 
 public void testBasicQuoted52298() { 
     final String input = "a: 'b'x'c' :d"; 
     final StrTokenizer tok = new StrTokenizer(input, ':', '\''); 
     tok.setTrimmerMatcher(StrMatcher.trimMatcher()); 
     tok.setIgnoreEmptyTokens(false); 
     tok.setEmptyTokenAsNull(true); 
     assertEquals("a", tok.next()); 
     assertEquals("bxc", tok.next()); 
     assertEquals("d", tok.next()); 
     assertFalse(tok.hasNext()); 
 } 
@Test 
 public void testTokenizeSubclassInputChange2330() { 
     final StrTokenizer tkn = new StrTokenizer("a b c d e") { 
  
         @Override 
         protected List<String> tokenize(final char[] chars, final int offset, final int count) { 
             return super.tokenize("w x y z".toCharArray(), 2, 5); 
         } 
     }; 
     assertEquals("x", tkn.next()); 
     assertEquals("y", tkn.next()); 
 } 
@Test 
 public void testBasicIgnoreTrimmed12779() { 
     final String input = "a: bIGNOREc : "; 
     final StrTokenizer tok = new StrTokenizer(input, ':'); 
     tok.setIgnoredMatcher(StrMatcher.stringMatcher("IGNORE")); 
     tok.setTrimmerMatcher(StrMatcher.trimMatcher()); 
     tok.setIgnoreEmptyTokens(false); 
     tok.setEmptyTokenAsNull(true); 
     assertEquals("a", tok.next()); 
     assertEquals("bc", tok.next()); 
     assertEquals(null, tok.next()); 
     assertFalse(tok.hasNext()); 
 } 
@Test 
 public void testBasicQuoted52864() { 
     final String input = "a: 'b'x'c' :d"; 
     final StrTokenizer tok = new StrTokenizer(input, ':', '\''); 
     tok.setTrimmerMatcher(StrMatcher.trimMatcher()); 
     tok.setIgnoreEmptyTokens(false); 
     tok.setEmptyTokenAsNull(true); 
     assertEquals("a", tok.next()); 
     assertEquals("bxc", tok.next()); 
     assertEquals("d", tok.next()); 
     assertFalse(tok.hasNext()); 
 } 
@Test 
 public void testListArray2932() { 
     final String input = "a  b c"; 
     final StrTokenizer tok = new StrTokenizer(input); 
     final String[] array = tok.getTokenArray(); 
     final List<?> list = tok.getTokenList(); 
     assertEquals(Arrays.asList(array), list); 
     assertEquals(3, list.size()); 
 } 
@Test 
 public void testToString2995() { 
     final StrTokenizer tkn = new StrTokenizer("a b c d e"); 
     assertEquals("StrTokenizer[not tokenized yet]", tkn.toString()); 
     tkn.next(); 
     assertEquals("StrTokenizer[a, b, c, d, e]", tkn.toString()); 
 } 
@Test 
 public void testBasicIgnoreTrimmed13000() { 
     final String input = "a: bIGNOREc : "; 
     final StrTokenizer tok = new StrTokenizer(input, ':'); 
     tok.setIgnoredMatcher(StrMatcher.stringMatcher("IGNORE")); 
     tok.setTrimmerMatcher(StrMatcher.trimMatcher()); 
     tok.setIgnoreEmptyTokens(false); 
     tok.setEmptyTokenAsNull(true); 
     assertEquals("a", tok.next()); 
     assertEquals("bc", tok.next()); 
     assertEquals(null, tok.next()); 
     assertFalse(tok.hasNext()); 
 } 
@Test 
 public void test53030() { 
     final String input = "a;b; c;\"d;\"\"e\";f; ; ;"; 
     final StrTokenizer tok = new StrTokenizer(input); 
     tok.setDelimiterChar(';'); 
     tok.setQuoteChar('"'); 
     tok.setIgnoredMatcher(StrMatcher.trimMatcher()); 
     tok.setIgnoreEmptyTokens(false); 
     tok.setEmptyTokenAsNull(true); 
     final String[] tokens = tok.getTokenArray(); 
     final String[] expected = new String[] { "a", "b", "c", "d;\"e", "f", null, null, null }; 
     assertEquals(ArrayUtils.toString(tokens), expected.length, tokens.length); 
     for (int i = 0; i < expected.length; i++) { 
         assertTrue("token[" + i + "] was '" + tokens[i] + "' but was expected to be '" + expected[i] + "'", ObjectUtils.equals(expected[i], tokens[i])); 
     } 
 } 
@Test 
 public void testListArray3580() { 
     final String input = "a  b c"; 
     final StrTokenizer tok = new StrTokenizer(input); 
     final String[] array = tok.getTokenArray(); 
     final List<?> list = tok.getTokenList(); 
     assertEquals(Arrays.asList(array), list); 
     assertEquals(3, list.size()); 
 } 
@Test 
 public void testCSVSimpleNeedsTrim3628() { 
     this.testCSV("   " + CSV_SIMPLE_FIXTURE); 
     this.testCSV("   \n\t  " + CSV_SIMPLE_FIXTURE); 
     this.testCSV("   \n  " + CSV_SIMPLE_FIXTURE + "\n\n\r"); 
 } 
@Test 
 public void testToString3745() { 
     final StrTokenizer tkn = new StrTokenizer("a b c d e"); 
     assertEquals("StrTokenizer[not tokenized yet]", tkn.toString()); 
     tkn.next(); 
     assertEquals("StrTokenizer[a, b, c, d, e]", tkn.toString()); 
 } 
@Test 
 public void testConstructor_charArray_char_char3776() { 
     StrTokenizer tok = new StrTokenizer("a b".toCharArray(), ' ', '"'); 
     assertEquals(1, tok.getDelimiterMatcher().isMatch(" ".toCharArray(), 0, 0, 1)); 
     assertEquals(1, tok.getQuoteMatcher().isMatch("\"".toCharArray(), 0, 0, 1)); 
     assertEquals("a", tok.next()); 
     assertEquals("b", tok.next()); 
     assertFalse(tok.hasNext()); 
     tok = new StrTokenizer(new char[0], ' ', '"'); 
     assertFalse(tok.hasNext()); 
     tok = new StrTokenizer((char[]) null, ' ', '"'); 
     assertFalse(tok.hasNext()); 
 } 
@Test 
 public void testChaining3859() { 
     final StrTokenizer tok = new StrTokenizer(); 
     assertEquals(tok, tok.reset()); 
     assertEquals(tok, tok.reset("")); 
     assertEquals(tok, tok.reset(new char[0])); 
     assertEquals(tok, tok.setDelimiterChar(' ')); 
     assertEquals(tok, tok.setDelimiterString(" ")); 
     assertEquals(tok, tok.setDelimiterMatcher(null)); 
     assertEquals(tok, tok.setQuoteChar(' ')); 
     assertEquals(tok, tok.setQuoteMatcher(null)); 
     assertEquals(tok, tok.setIgnoredChar(' ')); 
     assertEquals(tok, tok.setIgnoredMatcher(null)); 
     assertEquals(tok, tok.setTrimmerMatcher(null)); 
     assertEquals(tok, tok.setEmptyTokenAsNull(false)); 
     assertEquals(tok, tok.setIgnoreEmptyTokens(false)); 
 } 
@Test 
 public void testCSVSimpleNeedsTrim3886() { 
     this.testCSV("   " + CSV_SIMPLE_FIXTURE); 
     this.testCSV("   \n\t  " + CSV_SIMPLE_FIXTURE); 
     this.testCSV("   \n  " + CSV_SIMPLE_FIXTURE + "\n\n\r"); 
 } 
@Test 
 public void testIteration4088() { 
     final StrTokenizer tkn = new StrTokenizer("a b c"); 
     assertFalse(tkn.hasPrevious()); 
     try { 
         tkn.previous(); 
         fail(); 
     } catch (final NoSuchElementException ex) { 
     } 
     assertTrue(tkn.hasNext()); 
     assertEquals("a", tkn.next()); 
     try { 
         tkn.remove(); 
         fail(); 
     } catch (final UnsupportedOperationException ex) { 
     } 
     try { 
         tkn.set("x"); 
         fail(); 
     } catch (final UnsupportedOperationException ex) { 
     } 
     try { 
         tkn.add("y"); 
         fail(); 
     } catch (final UnsupportedOperationException ex) { 
     } 
     assertTrue(tkn.hasPrevious()); 
     assertTrue(tkn.hasNext()); 
     assertEquals("b", tkn.next()); 
     assertTrue(tkn.hasPrevious()); 
     assertTrue(tkn.hasNext()); 
     assertEquals("c", tkn.next()); 
     assertTrue(tkn.hasPrevious()); 
     assertFalse(tkn.hasNext()); 
     try { 
         tkn.next(); 
         fail(); 
     } catch (final NoSuchElementException ex) { 
     } 
     assertTrue(tkn.hasPrevious()); 
     assertFalse(tkn.hasNext()); 
 } 
@Test 
 public void testConstructor_charArray_char_char4166() { 
     StrTokenizer tok = new StrTokenizer("a b".toCharArray(), ' ', '"'); 
     assertEquals(1, tok.getDelimiterMatcher().isMatch(" ".toCharArray(), 0, 0, 1)); 
     assertEquals(1, tok.getQuoteMatcher().isMatch("\"".toCharArray(), 0, 0, 1)); 
     assertEquals("a", tok.next()); 
     assertEquals("b", tok.next()); 
     assertFalse(tok.hasNext()); 
     tok = new StrTokenizer(new char[0], ' ', '"'); 
     assertFalse(tok.hasNext()); 
     tok = new StrTokenizer((char[]) null, ' ', '"'); 
     assertFalse(tok.hasNext()); 
 } 
@Test 
 public void testIteration4311() { 
     final StrTokenizer tkn = new StrTokenizer("a b c"); 
     assertFalse(tkn.hasPrevious()); 
     try { 
         tkn.previous(); 
         fail(); 
     } catch (final NoSuchElementException ex) { 
     } 
     assertTrue(tkn.hasNext()); 
     assertEquals("a", tkn.next()); 
     try { 
         tkn.remove(); 
         fail(); 
     } catch (final UnsupportedOperationException ex) { 
     } 
     try { 
         tkn.set("x"); 
         fail(); 
     } catch (final UnsupportedOperationException ex) { 
     } 
     try { 
         tkn.add("y"); 
         fail(); 
     } catch (final UnsupportedOperationException ex) { 
     } 
     assertTrue(tkn.hasPrevious()); 
     assertTrue(tkn.hasNext()); 
     assertEquals("b", tkn.next()); 
     assertTrue(tkn.hasPrevious()); 
     assertTrue(tkn.hasNext()); 
     assertEquals("c", tkn.next()); 
     assertTrue(tkn.hasPrevious()); 
     assertFalse(tkn.hasNext()); 
     try { 
         tkn.next(); 
         fail(); 
     } catch (final NoSuchElementException ex) { 
     } 
     assertTrue(tkn.hasPrevious()); 
     assertFalse(tkn.hasNext()); 
 } 
@Test 
 public void testGetContent4362() { 
     final String input = "a   b c \"d e\" f "; 
     StrTokenizer tok = new StrTokenizer(input); 
     assertEquals(input, tok.getContent()); 
     tok = new StrTokenizer(input.toCharArray()); 
     assertEquals(input, tok.getContent()); 
     tok = new StrTokenizer(); 
     assertEquals(null, tok.getContent()); 
 } 
@Test 
 public void testListArray4579() { 
     final String input = "a  b c"; 
     final StrTokenizer tok = new StrTokenizer(input); 
     final String[] array = tok.getTokenArray(); 
     final List<?> list = tok.getTokenList(); 
     assertEquals(Arrays.asList(array), list); 
     assertEquals(3, list.size()); 
 } 
@Test 
 public void testCloneNotSupportedException4635() { 
     final Object notCloned = new StrTokenizer() { 
  
         @Override 
         Object cloneReset() throws CloneNotSupportedException { 
             throw new CloneNotSupportedException("test"); 
         } 
     }.clone(); 
     assertNull(notCloned); 
 } 
@Test 
 public void testGetContent4636() { 
     final String input = "a   b c \"d e\" f "; 
     StrTokenizer tok = new StrTokenizer(input); 
     assertEquals(input, tok.getContent()); 
     tok = new StrTokenizer(input.toCharArray()); 
     assertEquals(input, tok.getContent()); 
     tok = new StrTokenizer(); 
     assertEquals(null, tok.getContent()); 
 } 
@Test 
 public void testCSVSimple4731() { 
     this.testCSV(CSV_SIMPLE_FIXTURE); 
 } 
@Test 
 public void testGetContent4744() { 
     final String input = "a   b c \"d e\" f "; 
     StrTokenizer tok = new StrTokenizer(input); 
     assertEquals(input, tok.getContent()); 
     tok = new StrTokenizer(input.toCharArray()); 
     assertEquals(input, tok.getContent()); 
     tok = new StrTokenizer(); 
     assertEquals(null, tok.getContent()); 
 } 
@Test 
 public void testConstructor_String4777() { 
     StrTokenizer tok = new StrTokenizer("a b"); 
     assertEquals("a", tok.next()); 
     assertEquals("b", tok.next()); 
     assertFalse(tok.hasNext()); 
     tok = new StrTokenizer(""); 
     assertFalse(tok.hasNext()); 
     tok = new StrTokenizer((String) null); 
     assertFalse(tok.hasNext()); 
 } 
@Test 
 public void testTokenizeSubclassInputChange4799() { 
     final StrTokenizer tkn = new StrTokenizer("a b c d e") { 
  
         @Override 
         protected List<String> tokenize(final char[] chars, final int offset, final int count) { 
             return super.tokenize("w x y z".toCharArray(), 2, 5); 
         } 
     }; 
     assertEquals("x", tkn.next()); 
     assertEquals("y", tkn.next()); 
 } 
@Test 
 public void testChaining5053() { 
     final StrTokenizer tok = new StrTokenizer(); 
     assertEquals(tok, tok.reset()); 
     assertEquals(tok, tok.reset("")); 
     assertEquals(tok, tok.reset(new char[0])); 
     assertEquals(tok, tok.setDelimiterChar(' ')); 
     assertEquals(tok, tok.setDelimiterString(" ")); 
     assertEquals(tok, tok.setDelimiterMatcher(null)); 
     assertEquals(tok, tok.setQuoteChar(' ')); 
     assertEquals(tok, tok.setQuoteMatcher(null)); 
     assertEquals(tok, tok.setIgnoredChar(' ')); 
     assertEquals(tok, tok.setIgnoredMatcher(null)); 
     assertEquals(tok, tok.setTrimmerMatcher(null)); 
     assertEquals(tok, tok.setEmptyTokenAsNull(false)); 
     assertEquals(tok, tok.setIgnoreEmptyTokens(false)); 
 } 
@Test 
 public void testGetContent5062() { 
     final String input = "a   b c \"d e\" f "; 
     StrTokenizer tok = new StrTokenizer(input); 
     assertEquals(input, tok.getContent()); 
     tok = new StrTokenizer(input.toCharArray()); 
     assertEquals(input, tok.getContent()); 
     tok = new StrTokenizer(); 
     assertEquals(null, tok.getContent()); 
 } 
@Test 
 public void testIteration5358() { 
     final StrTokenizer tkn = new StrTokenizer("a b c"); 
     assertFalse(tkn.hasPrevious()); 
     try { 
         tkn.previous(); 
         fail(); 
     } catch (final NoSuchElementException ex) { 
     } 
     assertTrue(tkn.hasNext()); 
     assertEquals("a", tkn.next()); 
     try { 
         tkn.remove(); 
         fail(); 
     } catch (final UnsupportedOperationException ex) { 
     } 
     try { 
         tkn.set("x"); 
         fail(); 
     } catch (final UnsupportedOperationException ex) { 
     } 
     try { 
         tkn.add("y"); 
         fail(); 
     } catch (final UnsupportedOperationException ex) { 
     } 
     assertTrue(tkn.hasPrevious()); 
     assertTrue(tkn.hasNext()); 
     assertEquals("b", tkn.next()); 
     assertTrue(tkn.hasPrevious()); 
     assertTrue(tkn.hasNext()); 
     assertEquals("c", tkn.next()); 
     assertTrue(tkn.hasPrevious()); 
     assertFalse(tkn.hasNext()); 
     try { 
         tkn.next(); 
         fail(); 
     } catch (final NoSuchElementException ex) { 
     } 
     assertTrue(tkn.hasPrevious()); 
     assertFalse(tkn.hasNext()); 
 } 
@Test 
 public void test55518() { 
     final String input = "a;b; c;\"d;\"\"e\";f; ; ;"; 
     final StrTokenizer tok = new StrTokenizer(input); 
     tok.setDelimiterChar(';'); 
     tok.setQuoteChar('"'); 
     tok.setIgnoredMatcher(StrMatcher.trimMatcher()); 
     tok.setIgnoreEmptyTokens(false); 
     tok.setEmptyTokenAsNull(true); 
     final String[] tokens = tok.getTokenArray(); 
     final String[] expected = new String[] { "a", "b", "c", "d;\"e", "f", null, null, null }; 
     assertEquals(ArrayUtils.toString(tokens), expected.length, tokens.length); 
     for (int i = 0; i < expected.length; i++) { 
         assertTrue("token[" + i + "] was '" + tokens[i] + "' but was expected to be '" + expected[i] + "'", ObjectUtils.equals(expected[i], tokens[i])); 
     } 
 } 
@Test 
 public void testGetContent5691() { 
     final String input = "a   b c \"d e\" f "; 
     StrTokenizer tok = new StrTokenizer(input); 
     assertEquals(input, tok.getContent()); 
     tok = new StrTokenizer(input.toCharArray()); 
     assertEquals(input, tok.getContent()); 
     tok = new StrTokenizer(); 
     assertEquals(null, tok.getContent()); 
 } 
@Test 
 public void testGetContent6079() { 
     final String input = "a   b c \"d e\" f "; 
     StrTokenizer tok = new StrTokenizer(input); 
     assertEquals(input, tok.getContent()); 
     tok = new StrTokenizer(input.toCharArray()); 
     assertEquals(input, tok.getContent()); 
     tok = new StrTokenizer(); 
     assertEquals(null, tok.getContent()); 
 } 
@Test 
 public void testBasicIgnoreTrimmed16818() { 
     final String input = "a: bIGNOREc : "; 
     final StrTokenizer tok = new StrTokenizer(input, ':'); 
     tok.setIgnoredMatcher(StrMatcher.stringMatcher("IGNORE")); 
     tok.setTrimmerMatcher(StrMatcher.trimMatcher()); 
     tok.setIgnoreEmptyTokens(false); 
     tok.setEmptyTokenAsNull(true); 
     assertEquals("a", tok.next()); 
     assertEquals("bc", tok.next()); 
     assertEquals(null, tok.next()); 
     assertFalse(tok.hasNext()); 
 } 
@Test 
 public void testCSVSimpleNeedsTrim6898() { 
     this.testCSV("   " + CSV_SIMPLE_FIXTURE); 
     this.testCSV("   \n\t  " + CSV_SIMPLE_FIXTURE); 
     this.testCSV("   \n  " + CSV_SIMPLE_FIXTURE + "\n\n\r"); 
 } 
@Test 
 public void testConstructor_charArray_char_char6929() { 
     StrTokenizer tok = new StrTokenizer("a b".toCharArray(), ' ', '"'); 
     assertEquals(1, tok.getDelimiterMatcher().isMatch(" ".toCharArray(), 0, 0, 1)); 
     assertEquals(1, tok.getQuoteMatcher().isMatch("\"".toCharArray(), 0, 0, 1)); 
     assertEquals("a", tok.next()); 
     assertEquals("b", tok.next()); 
     assertFalse(tok.hasNext()); 
     tok = new StrTokenizer(new char[0], ' ', '"'); 
     assertFalse(tok.hasNext()); 
     tok = new StrTokenizer((char[]) null, ' ', '"'); 
     assertFalse(tok.hasNext()); 
 } 
@Test 
 public void test57071() { 
     final String input = "a;b; c;\"d;\"\"e\";f; ; ;"; 
     final StrTokenizer tok = new StrTokenizer(input); 
     tok.setDelimiterChar(';'); 
     tok.setQuoteChar('"'); 
     tok.setIgnoredMatcher(StrMatcher.trimMatcher()); 
     tok.setIgnoreEmptyTokens(false); 
     tok.setEmptyTokenAsNull(true); 
     final String[] tokens = tok.getTokenArray(); 
     final String[] expected = new String[] { "a", "b", "c", "d;\"e", "f", null, null, null }; 
     assertEquals(ArrayUtils.toString(tokens), expected.length, tokens.length); 
     for (int i = 0; i < expected.length; i++) { 
         assertTrue("token[" + i + "] was '" + tokens[i] + "' but was expected to be '" + expected[i] + "'", ObjectUtils.equals(expected[i], tokens[i])); 
     } 
 } 
@Test 
 public void testConstructor_charArray_char_char7366() { 
     StrTokenizer tok = new StrTokenizer("a b".toCharArray(), ' ', '"'); 
     assertEquals(1, tok.getDelimiterMatcher().isMatch(" ".toCharArray(), 0, 0, 1)); 
     assertEquals(1, tok.getQuoteMatcher().isMatch("\"".toCharArray(), 0, 0, 1)); 
     assertEquals("a", tok.next()); 
     assertEquals("b", tok.next()); 
     assertFalse(tok.hasNext()); 
     tok = new StrTokenizer(new char[0], ' ', '"'); 
     assertFalse(tok.hasNext()); 
     tok = new StrTokenizer((char[]) null, ' ', '"'); 
     assertFalse(tok.hasNext()); 
 } 
@Test 
 public void testCSVSimple7394() { 
     this.testCSV(CSV_SIMPLE_FIXTURE); 
 } 
@Test 
 public void testIteration7484() { 
     final StrTokenizer tkn = new StrTokenizer("a b c"); 
     assertFalse(tkn.hasPrevious()); 
     try { 
         tkn.previous(); 
         fail(); 
     } catch (final NoSuchElementException ex) { 
     } 
     assertTrue(tkn.hasNext()); 
     assertEquals("a", tkn.next()); 
     try { 
         tkn.remove(); 
         fail(); 
     } catch (final UnsupportedOperationException ex) { 
     } 
     try { 
         tkn.set("x"); 
         fail(); 
     } catch (final UnsupportedOperationException ex) { 
     } 
     try { 
         tkn.add("y"); 
         fail(); 
     } catch (final UnsupportedOperationException ex) { 
     } 
     assertTrue(tkn.hasPrevious()); 
     assertTrue(tkn.hasNext()); 
     assertEquals("b", tkn.next()); 
     assertTrue(tkn.hasPrevious()); 
     assertTrue(tkn.hasNext()); 
     assertEquals("c", tkn.next()); 
     assertTrue(tkn.hasPrevious()); 
     assertFalse(tkn.hasNext()); 
     try { 
         tkn.next(); 
         fail(); 
     } catch (final NoSuchElementException ex) { 
     } 
     assertTrue(tkn.hasPrevious()); 
     assertFalse(tkn.hasNext()); 
 } 
@Test 
 public void test67673() { 
     final String input = "a;b; c;\"d;\"\"e\";f; ; ;"; 
     final StrTokenizer tok = new StrTokenizer(input); 
     tok.setDelimiterChar(';'); 
     tok.setQuoteChar('"'); 
     tok.setIgnoredMatcher(StrMatcher.trimMatcher()); 
     tok.setIgnoreEmptyTokens(false); 
     final String[] tokens = tok.getTokenArray(); 
     final String[] expected = new String[] { "a", "b", " c", "d;\"e", "f", null, null, null }; 
     int nextCount = 0; 
     while (tok.hasNext()) { 
         tok.next(); 
         nextCount++; 
     } 
     int prevCount = 0; 
     while (tok.hasPrevious()) { 
         tok.previous(); 
         prevCount++; 
     } 
     assertEquals(ArrayUtils.toString(tokens), expected.length, tokens.length); 
     assertTrue("could not cycle through entire token list" + " using the 'hasNext' and 'next' methods", nextCount == expected.length); 
     assertTrue("could not cycle through entire token list" + " using the 'hasPrevious' and 'previous' methods", prevCount == expected.length); 
 } 
@Test 
 public void testChaining7793() { 
     final StrTokenizer tok = new StrTokenizer(); 
     assertEquals(tok, tok.reset()); 
     assertEquals(tok, tok.reset("")); 
     assertEquals(tok, tok.reset(new char[0])); 
     assertEquals(tok, tok.setDelimiterChar(' ')); 
     assertEquals(tok, tok.setDelimiterString(" ")); 
     assertEquals(tok, tok.setDelimiterMatcher(null)); 
     assertEquals(tok, tok.setQuoteChar(' ')); 
     assertEquals(tok, tok.setQuoteMatcher(null)); 
     assertEquals(tok, tok.setIgnoredChar(' ')); 
     assertEquals(tok, tok.setIgnoredMatcher(null)); 
     assertEquals(tok, tok.setTrimmerMatcher(null)); 
     assertEquals(tok, tok.setEmptyTokenAsNull(false)); 
     assertEquals(tok, tok.setIgnoreEmptyTokens(false)); 
 } 
@Test 
 public void testBasicIgnoreTrimmed17810() { 
     final String input = "a: bIGNOREc : "; 
     final StrTokenizer tok = new StrTokenizer(input, ':'); 
     tok.setIgnoredMatcher(StrMatcher.stringMatcher("IGNORE")); 
     tok.setTrimmerMatcher(StrMatcher.trimMatcher()); 
     tok.setIgnoreEmptyTokens(false); 
     tok.setEmptyTokenAsNull(true); 
     assertEquals("a", tok.next()); 
     assertEquals("bc", tok.next()); 
     assertEquals(null, tok.next()); 
     assertFalse(tok.hasNext()); 
 } 
@Test 
 public void testIteration7822() { 
     final StrTokenizer tkn = new StrTokenizer("a b c"); 
     assertFalse(tkn.hasPrevious()); 
     try { 
         tkn.previous(); 
         fail(); 
     } catch (final NoSuchElementException ex) { 
     } 
     assertTrue(tkn.hasNext()); 
     assertEquals("a", tkn.next()); 
     try { 
         tkn.remove(); 
         fail(); 
     } catch (final UnsupportedOperationException ex) { 
     } 
     try { 
         tkn.set("x"); 
         fail(); 
     } catch (final UnsupportedOperationException ex) { 
     } 
     try { 
         tkn.add("y"); 
         fail(); 
     } catch (final UnsupportedOperationException ex) { 
     } 
     assertTrue(tkn.hasPrevious()); 
     assertTrue(tkn.hasNext()); 
     assertEquals("b", tkn.next()); 
     assertTrue(tkn.hasPrevious()); 
     assertTrue(tkn.hasNext()); 
     assertEquals("c", tkn.next()); 
     assertTrue(tkn.hasPrevious()); 
     assertFalse(tkn.hasNext()); 
     try { 
         tkn.next(); 
         fail(); 
     } catch (final NoSuchElementException ex) { 
     } 
     assertTrue(tkn.hasPrevious()); 
     assertFalse(tkn.hasNext()); 
 } 
@Test 
 public void testCloneReset8050() { 
     final char[] input = new char[] { 'a' }; 
     final StrTokenizer tokenizer = new StrTokenizer(input); 
     assertEquals("a", tokenizer.nextToken()); 
     tokenizer.reset(input); 
     assertEquals("a", tokenizer.nextToken()); 
     final StrTokenizer clonedTokenizer = (StrTokenizer) tokenizer.clone(); 
     input[0] = 'b'; 
     tokenizer.reset(input); 
     assertEquals("b", tokenizer.nextToken()); 
     assertEquals("a", clonedTokenizer.nextToken()); 
 } 
@Test 
 public void testGetContent8091() { 
     final String input = "a   b c \"d e\" f "; 
     StrTokenizer tok = new StrTokenizer(input); 
     assertEquals(input, tok.getContent()); 
     tok = new StrTokenizer(input.toCharArray()); 
     assertEquals(input, tok.getContent()); 
     tok = new StrTokenizer(); 
     assertEquals(null, tok.getContent()); 
 } 
@Test 
 public void testBasicIgnoreTrimmed18107() { 
     final String input = "a: bIGNOREc : "; 
     final StrTokenizer tok = new StrTokenizer(input, ':'); 
     tok.setIgnoredMatcher(StrMatcher.stringMatcher("IGNORE")); 
     tok.setTrimmerMatcher(StrMatcher.trimMatcher()); 
     tok.setIgnoreEmptyTokens(false); 
     tok.setEmptyTokenAsNull(true); 
     assertEquals("a", tok.next()); 
     assertEquals("bc", tok.next()); 
     assertEquals(null, tok.next()); 
     assertFalse(tok.hasNext()); 
 } 
@Test 
 public void test58159() { 
     final String input = "a;b; c;\"d;\"\"e\";f; ; ;"; 
     final StrTokenizer tok = new StrTokenizer(input); 
     tok.setDelimiterChar(';'); 
     tok.setQuoteChar('"'); 
     tok.setIgnoredMatcher(StrMatcher.trimMatcher()); 
     tok.setIgnoreEmptyTokens(false); 
     tok.setEmptyTokenAsNull(true); 
     final String[] tokens = tok.getTokenArray(); 
     final String[] expected = new String[] { "a", "b", "c", "d;\"e", "f", null, null, null }; 
     assertEquals(ArrayUtils.toString(tokens), expected.length, tokens.length); 
     for (int i = 0; i < expected.length; i++) { 
         assertTrue("token[" + i + "] was '" + tokens[i] + "' but was expected to be '" + expected[i] + "'", ObjectUtils.equals(expected[i], tokens[i])); 
     } 
 } 
@Test 
 public void testListArray8557() { 
     final String input = "a  b c"; 
     final StrTokenizer tok = new StrTokenizer(input); 
     final String[] array = tok.getTokenArray(); 
     final List<?> list = tok.getTokenList(); 
     assertEquals(Arrays.asList(array), list); 
     assertEquals(3, list.size()); 
 } 
@Test 
 public void testGetContent8569() { 
     final String input = "a   b c \"d e\" f "; 
     StrTokenizer tok = new StrTokenizer(input); 
     assertEquals(input, tok.getContent()); 
     tok = new StrTokenizer(input.toCharArray()); 
     assertEquals(input, tok.getContent()); 
     tok = new StrTokenizer(); 
     assertEquals(null, tok.getContent()); 
 } 
@Test 
 public void testIteration8639() { 
     final StrTokenizer tkn = new StrTokenizer("a b c"); 
     assertFalse(tkn.hasPrevious()); 
     try { 
         tkn.previous(); 
         fail(); 
     } catch (final NoSuchElementException ex) { 
     } 
     assertTrue(tkn.hasNext()); 
     assertEquals("a", tkn.next()); 
     try { 
         tkn.remove(); 
         fail(); 
     } catch (final UnsupportedOperationException ex) { 
     } 
     try { 
         tkn.set("x"); 
         fail(); 
     } catch (final UnsupportedOperationException ex) { 
     } 
     try { 
         tkn.add("y"); 
         fail(); 
     } catch (final UnsupportedOperationException ex) { 
     } 
     assertTrue(tkn.hasPrevious()); 
     assertTrue(tkn.hasNext()); 
     assertEquals("b", tkn.next()); 
     assertTrue(tkn.hasPrevious()); 
     assertTrue(tkn.hasNext()); 
     assertEquals("c", tkn.next()); 
     assertTrue(tkn.hasPrevious()); 
     assertFalse(tkn.hasNext()); 
     try { 
         tkn.next(); 
         fail(); 
     } catch (final NoSuchElementException ex) { 
     } 
     assertTrue(tkn.hasPrevious()); 
     assertFalse(tkn.hasNext()); 
 } 
@Test 
 public void testToString8701() { 
     final StrTokenizer tkn = new StrTokenizer("a b c d e"); 
     assertEquals("StrTokenizer[not tokenized yet]", tkn.toString()); 
     tkn.next(); 
     assertEquals("StrTokenizer[a, b, c, d, e]", tkn.toString()); 
 } 
@Test 
 public void testListArray8793() { 
     final String input = "a  b c"; 
     final StrTokenizer tok = new StrTokenizer(input); 
     final String[] array = tok.getTokenArray(); 
     final List<?> list = tok.getTokenList(); 
     assertEquals(Arrays.asList(array), list); 
     assertEquals(3, list.size()); 
 } 
@Test 
 public void testListArray8795() { 
     final String input = "a  b c"; 
     final StrTokenizer tok = new StrTokenizer(input); 
     final String[] array = tok.getTokenArray(); 
     final List<?> list = tok.getTokenList(); 
     assertEquals(Arrays.asList(array), list); 
     assertEquals(3, list.size()); 
 } 
@Test 
 public void testChaining8840() { 
     final StrTokenizer tok = new StrTokenizer(); 
     assertEquals(tok, tok.reset()); 
     assertEquals(tok, tok.reset("")); 
     assertEquals(tok, tok.reset(new char[0])); 
     assertEquals(tok, tok.setDelimiterChar(' ')); 
     assertEquals(tok, tok.setDelimiterString(" ")); 
     assertEquals(tok, tok.setDelimiterMatcher(null)); 
     assertEquals(tok, tok.setQuoteChar(' ')); 
     assertEquals(tok, tok.setQuoteMatcher(null)); 
     assertEquals(tok, tok.setIgnoredChar(' ')); 
     assertEquals(tok, tok.setIgnoredMatcher(null)); 
     assertEquals(tok, tok.setTrimmerMatcher(null)); 
     assertEquals(tok, tok.setEmptyTokenAsNull(false)); 
     assertEquals(tok, tok.setIgnoreEmptyTokens(false)); 
 } 
@Test 
 public void testCSVSimple9085() { 
     this.testCSV(CSV_SIMPLE_FIXTURE); 
 } 
@Test 
 public void testBasicQuoted59167() { 
     final String input = "a: 'b'x'c' :d"; 
     final StrTokenizer tok = new StrTokenizer(input, ':', '\''); 
     tok.setTrimmerMatcher(StrMatcher.trimMatcher()); 
     tok.setIgnoreEmptyTokens(false); 
     tok.setEmptyTokenAsNull(true); 
     assertEquals("a", tok.next()); 
     assertEquals("bxc", tok.next()); 
     assertEquals("d", tok.next()); 
     assertFalse(tok.hasNext()); 
 } 
@Test 
 public void testListArray9400() { 
     final String input = "a  b c"; 
     final StrTokenizer tok = new StrTokenizer(input); 
     final String[] array = tok.getTokenArray(); 
     final List<?> list = tok.getTokenList(); 
     assertEquals(Arrays.asList(array), list); 
     assertEquals(3, list.size()); 
 } 
@Test 
 public void test59428() { 
     final String input = "a;b; c;\"d;\"\"e\";f; ; ;"; 
     final StrTokenizer tok = new StrTokenizer(input); 
     tok.setDelimiterChar(';'); 
     tok.setQuoteChar('"'); 
     tok.setIgnoredMatcher(StrMatcher.trimMatcher()); 
     tok.setIgnoreEmptyTokens(false); 
     tok.setEmptyTokenAsNull(true); 
     final String[] tokens = tok.getTokenArray(); 
     final String[] expected = new String[] { "a", "b", "c", "d;\"e", "f", null, null, null }; 
     assertEquals(ArrayUtils.toString(tokens), expected.length, tokens.length); 
     for (int i = 0; i < expected.length; i++) { 
         assertTrue("token[" + i + "] was '" + tokens[i] + "' but was expected to be '" + expected[i] + "'", ObjectUtils.equals(expected[i], tokens[i])); 
     } 
 } 
@Test 
     public void testReset_String9573() { 
         StrTokenizer tok = new StrTokenizer("a b c"); 
         assertEquals("a", tok.next()); 
         assertEquals("b", tok.next()); 
         assertEquals(" c", tok.next()); 
          
         tok.reset("d e"); 
         assertEquals("a", tok.next()); 
         assertEquals("b", tok.next()); 
         assertEquals("c", tok.next()); 
         assertEquals("d e", tok.next()); 
          
         tok.reset("e"); 
         assertEquals("a", tok.next()); 
         assertEquals("b", tok.next()); 
         assertEquals("c", tok.next()); 
          
         tok.reset("f"); 
         assertEquals("f", tok.next()); 
         assertEquals("g", tok.next()); 
         assertEquals("h", tok.next()); 
          
         tok.reset("i"); 
         assertEquals("h", tok.next()); 
         assertEquals("i", tok.next()); 
          
         try { 
             tok.next(); 
             fail(); 
         } catch (final NoSuchElementException ex) {} 
         try { 
             tok.next(); 
             fail(); 
         } catch (final NoSuchElementException ex) {} 
         try { 
             tok.next(); 
             fail(); 
         } catch (final NoSuchElementException ex) {} 
     } 
  
     //----------------------------------------------------------------------- 

@Test 
     public void test59592() { 
  
         final String input = "a   b c \"d e\" f "; 
         final StrTokenizer tok = new StrTokenizer(input); 
         tok.setDelimiterChar(';'); 
         tok.setQuoteChar('"'); 
         tok.setIgnoredMatcher(StrMatcher.trimMatcher()); 
         tok.setIgnoreEmptyTokens(false); 
         tok.setEmptyTokenAsNull(true); 
         final String tokens[] = tok.getTokenArray(); 
         final String expected[] = new String[]{"a", "b", "c", "d", "e", "f"}; 
  
         assertEquals(ArrayUtils.toString(tokens), expected.length, tokens.length); 
         for (int i = 0; i < expected.length; i++) { 
             assertTrue("token[" + i + "] was '" + tokens[i] + "' but was expected to be '" + expected[i] + "'", 
                     ObjectUtils.equals(expected[i], tokens[i])); 
         } 
  
     } 
  

@Test 
     public void testGetContent9669() { 
         final String input = "a   b c \"d e\" f "; 
         StrTokenizer tok = new StrTokenizer(input); 
         assertEquals(input, tok.getContent()); 
          
         tok = new StrTokenizer(input.toCharArray()); 
         assertEquals(input, tok.getContent()); 
          
         tok = new StrTokenizer(); 
         assertEquals(null, tok.getContent()); 
     } 
  
     //----------------------------------------------------------------------- 

@Test 
     public void testCloneNotSupportedException9880() { 
         final String input = "a   b c \"d e\" f "; 
         final StrTokenizer tok = new StrTokenizer(input); 
         try { 
             tok.clone(); 
             fail(); 
         } catch (final CloneNotSupportedException ex) { 
             // expected 
         } 
     } 
  
     //----------------------------------------------------------------------- 

@Test 
     public void test59881() { 
  
         final String input = "a   b c \"d e\" f "; 
         final StrTokenizer tok = new StrTokenizer(input); 
         tok.setDelimiterChar(';'); 
         tok.setQuoteChar('"'); 
         tok.setIgnoredMatcher(StrMatcher.trimMatcher()); 
         tok.setIgnoreEmptyTokens(false); 
         tok.setEmptyTokenAsNull(true); 
         final String tokens[] = tok.getTokenArray(); 
         final String expected[] = new String[]{"a", "b", "c", "d", "e", "f"}; 
  
         assertEquals(ArrayUtils.toString(tokens), expected.length, tokens.length); 
         for (int i = 0; i < expected.length; i++) { 
             assertTrue("token[" + i + "] was '" + tokens[i] + "' but was expected to be '" + expected[i] + "'", 
                     ObjectUtils.equals(expected[i], tokens[i])); 
         } 
  
     } 
  

@Test 
     public void testCloneReset9882() { 
         final StrTokenizer tkn = new StrTokenizer("a b c"); 
         try { 
             tkn.reset(); 
             fail(); 
         } catch (final CloneNotSupportedException ex) {} 
         try { 
             tkn.reset(new char[0]); 
             fail(); 
         } catch (final CloneNotSupportedException ex) {} 
         try { 
             tkn.set("x"); 
             fail(); 
         } catch (final CloneNotSupportedException ex) {} 
         try { 
             tkn.set("y"); 
             fail(); 
         } catch (final CloneNotSupportedException ex) {} 
         try { 
             tkn.set("a b c"); 
             fail(); 
         } catch (final CloneNotSupportedException ex) {} 
         assertEquals("a", tkn.next()); 
         assertEquals("b", tkn.next()); 
         assertEquals("c", tkn.next()); 
          
         assertTrue(tkn.hasNext()); 
          
         assertFalse(tkn.hasPrevious()); 
         assertFalse(tkn.hasNext()); 
          
         try { 
             tkn.next(); 
             fail(); 
         } catch (final CloneNotSupportedException ex) {} 
         assertTrue(tkn.hasPrevious()); 
         assertFalse(tkn.hasNext()); 
          
         try { 
             tkn.reset("d e"); 
             fail(); 
         } catch (final CloneNotSupportedException ex) {} 
         assertTrue(tkn.hasPrevious()); 
         assertFalse(tkn.hasNext()); 
     } 
  
     //----------------------------------------------------------------------- 

@Test 
     public void testSplit_String_char_char9883() { 
         final String input = "a   b c \"d e\" f "; 
         StrTokenizer tok = new StrTokenizer(input); 
         assertEquals(Arrays.asList(tok.getTokenArray()), tok.getTokenList()); 
          
         tok = new StrTokenizer(input.toCharArray()); 
         assertEquals(Arrays.asList(tok.getTokenArray()), tok.getTokenList()); 
          
         tok = new StrTokenizer(input.toCharArray()); 
         assertEquals(Arrays.asList(tok.getTokenArray()), tok.getTokenList()); 
          
         tok = new StrTokenizer(input.toCharArray()); 
         assertEquals(Arrays.asList(tok.getTokenArray()), tok.getTokenList()); 
          
         tok = new StrTokenizer(input.toCharArray()); 
         assertEquals(Arrays.asList(tok.getTokenArray()), tok.getTokenList()); 
          
         tok = new StrTokenizer(null); 
         assertEquals(null, tok.getTokenArray()); 
     } 
  
     //----------------------------------------------------------------------- 

@Test 
     public void testGetContent9884() { 
         final String input = "a   b c \"d e\" f "; 
         StrTokenizer tok = new StrTokenizer(input); 
         assertEquals(input, tok.getContent()); 
  
         tok = new StrTokenizer(input.toCharArray()); 
         assertEquals(input, tok.getContent()); 
          
         tok = new StrTokenizer(); 
         assertEquals(input, tok.getContent()); 
          
         tok = new StrTokenizer(); 
         assertEquals(null, tok.getContent()); 
          
         tok = new StrTokenizer(); 
         assertEquals(null, tok.getContent()); 
          
         tok = new StrTokenizer(); 
         assertEquals(input, tok.getContent()); 
          
         tok = new StrTokenizer(); 
         assertEquals(input, tok.getContent()); 
          
         tok = new StrTokenizer(); 
         assertEquals(null, tok.getContent()); 
     } 
  
     //----------------------------------------------------------------------- 

@Test 
     public void testGetContent9885() { 
         final String input = "a   b c \"d e\" f "; 
         StrTokenizer tok = new StrTokenizer(input); 
         assertEquals(input, tok.getContent()); 
          
         tok = new StrTokenizer(input.toCharArray()); 
         assertEquals(input, tok.getContent()); 
          
         tok = new StrTokenizer(); 
         assertEquals(null, tok.getContent()); 
     } 
  
     //----------------------------------------------------------------------- 

@Test 
     public void testCloneReset9886() { 
         final StrTokenizer tkn = new StrTokenizer("a b c"); 
         assertFalse(tkn.hasPrevious()); 
         try { 
             tkn.previous(); 
             fail(); 
         } catch (final CloneNotSupportedException ex) {} 
         try { 
             tkn.reset(); 
             fail(); 
         } catch (final CloneNotSupportedException ex) {} 
         try { 
             tkn.remove(); 
             fail(); 
         } catch (final UnsupportedOperationException ex) {} 
         try { 
             tkn.set("x"); 
             fail(); 
         } catch (final UnsupportedOperationException ex) {} 
         try { 
             tkn.add("y"); 
             fail(); 
         } catch (final UnsupportedOperationException ex) {} 
         assertTrue(tkn.hasPrevious()); 
         assertTrue(tkn.hasNext()); 
          
         assertEquals("a", tkn.next()); 
         assertTrue(tkn.hasPrevious()); 
         assertTrue(tkn.hasNext()); 
          
         assertEquals("b", tkn.next()); 
         assertTrue(tkn.hasPrevious()); 
         assertTrue(tkn.hasNext()); 
          
         assertEquals("c", tkn.next()); 
         assertTrue(tkn.hasPrevious()); 
         assertFalse(tkn.hasNext()); 
          
         try { 
             tkn.next(); 
             fail(); 
         } catch (final CloneNotSupportedException ex) {} 
         assertTrue(tkn.hasPrevious()); 
         assertFalse(tkn.hasNext()); 
     } 
  
     //----------------------------------------------------------------------- 

@Test 
     public void testIteration9887() { 
         final StrTokenizer tkn = new StrTokenizer("a b c"); 
         assertTrue(tkn.hasNext()); 
         assertEquals("a", tkn.next()); 
         assertTrue(tkn.hasPrevious()); 
         assertEquals("b", tkn.next()); 
         assertTrue(tkn.hasPrevious()); 
          
         assertFalse(tkn.hasNext()); 
          
         try { 
             tkn.previous(); 
             fail(); 
         } catch (final NoSuchElementException ex) {} 
         try { 
             tkn.remove(); 
             fail(); 
         } catch (final UnsupportedOperationException ex) {} 
         try { 
             tkn.set("x"); 
             fail(); 
         } catch (final UnsupportedOperationException ex) {} 
         try { 
             tkn.add("y"); 
             fail(); 
         } catch (final UnsupportedOperationException ex) {} 
         assertTrue(tkn.hasNext()); 
          
         assertEquals("b", tkn.next()); 
         assertTrue(tkn.hasPrevious()); 
         assertTrue(tkn.hasNext()); 
          
         assertEquals("c", tkn.next()); 
         assertTrue(tkn.hasPrevious()); 
         assertTrue(tkn.hasNext()); 
          
         assertFalse(tkn.hasNext()); 
     } 
  
     //----------------------------------------------------------------------- 

@Test 
     public void testReset_String9888() { 
         StrTokenizer tok = new StrTokenizer("a b c"); 
         assertEquals("a", tok.next()); 
         assertEquals("b", tok.next()); 
         assertEquals(" c", tok.next()); 
          
         tok.reset("d e"); 
         assertEquals("a", tok.next()); 
         assertEquals("b", tok.next()); 
         assertEquals("c", tok.next()); 
         assertEquals("d e", tok.next()); 
          
         tok.reset("e"); 
         assertEquals("a", tok.next()); 
         assertEquals("b", tok.next()); 
         assertEquals("c", tok.next()); 
          
         tok.reset("f"); 
         assertEquals("f", tok.next()); 
         assertEquals("g", tok.next()); 
         assertEquals("h", tok.next()); 
          
         tok.reset("i"); 
         assertEquals("h", tok.next()); 
         assertEquals("i", tok.next()); 
          
         try { 
             tok.next(); 
             fail(); 
         } catch (final NoSuchElementException ex) {} 
         try { 
             tok.next(); 
             fail(); 
         } catch (final NoSuchElementException ex) {} 
         try { 
             tok.next(); 
             fail(); 
         } catch (final NoSuchElementException ex) {} 
     } 
  
     //----------------------------------------------------------------------- 

@Test 
     public void testListArray9889() { 
         final String input = "a  b c"; 
         final StrTokenizer tok = new StrTokenizer(input); 
         final String[] array = tok.getTokenArray(); 
         final List<?> tokens = tok.getTokenList(); 
          
         assertEquals(Arrays.asList(array), tokens); 
         assertEquals(3, tokens.size()); 
     } 
  
     //----------------------------------------------------------------------- 
     private void testCSV(final String data) { 
         this.testXSVAbc(StrTokenizer.getCSVInstance(data)); 
         this.testXSVAbc(StrTokenizer.getCSVInstance(data.toCharArray())); 
         this.testXSVAbc(StrTokenizer.getCSVInstance(data.toCharArray())); 
     } 
  

@Test 
     public void test59890() { 
  
         final String input = "a   b c \"d e\" f "; 
         final StrTokenizer tok = new StrTokenizer(input); 
         tok.setDelimiterChar(';'); 
         tok.setQuoteChar('"'); 
         tok.setIgnoredMatcher(StrMatcher.trimMatcher()); 
         tok.setIgnoreEmptyTokens(false); 
         tok.setEmptyTokenAsNull(true); 
         final String tokens[] = tok.getTokenArray(); 
         final String expected[] = new String[]{"a", "b", "c", "d", "e", "f"}; 
  
         assertEquals(ArrayUtils.toString(tokens), expected.length, tokens.length); 
         for (int i = 0; i < expected.length; i++) { 
             assertTrue("token[" + i + "] was '" + tokens[i] + "' but was expected to be '" + expected[i] + "'", 
                     ObjectUtils.equals(expected[i], tokens[i])); 
         } 
  
     } 
  

@Test 
     public void testIteration9891() { 
         final StrTokenizer tkn = new StrTokenizer("a b c"); 
         assertFalse(tkn.hasPrevious()); 
         try { 
             tkn.previous(); 
             fail(); 
         } catch (final NoSuchElementException ex) {} 
         try { 
             tkn.remove(); 
             fail(); 
         } catch (final UnsupportedOperationException ex) {} 
         try { 
             tkn.set("x"); 
             fail(); 
         } catch (final UnsupportedOperationException ex) {} 
         try { 
             tkn.set("y"); 
             fail(); 
         } catch (final UnsupportedOperationException ex) {} 
          
         assertTrue(tkn.hasPrevious()); 
         assertTrue(tkn.hasNext()); 
          
         assertEquals("a", tkn.next()); 
         assertTrue(tkn.hasPrevious()); 
          
         assertTrue(tkn.hasNext()); 
          
         assertEquals("b", tkn.next()); 
         assertTrue(tkn.hasPrevious()); 
         assertTrue(tkn.hasNext()); 
          
         assertEquals("c", tkn.next()); 
         assertTrue(tkn.hasPrevious()); 
          
         assertFalse(tkn.hasNext()); 
          
         try { 
             tkn.next(); 
             fail(); 
         } catch (final NoSuchElementException ex) {} 
         assertTrue(tkn.hasPrevious()); 
         assertFalse(tkn.hasNext()); 
     } 
  
     //----------------------------------------------------------------------- 

@Test 
     public void testGetContent9892() { 
         final String input = "a   b c \"d e\" f "; 
         StrTokenizer tok = new StrTokenizer(input); 
         assertEquals(input, tok.getContent()); 
          
         tok = new StrTokenizer(input.toCharArray()); 
         assertEquals(input, tok.getContent()); 
          
         tok = new StrTokenizer(); 
         assertEquals(null, tok.getContent()); 
     } 
  
     //----------------------------------------------------------------------- 

@Test 
     public void testReset_String9893() { 
         StrTokenizer tok = new StrTokenizer("a b c"); 
         tok.reset("d e"); 
         assertEquals("a", tok.next()); 
         assertEquals("b", tok.next()); 
         assertEquals("c", tok.next()); 
         assertFalse(tok.hasNext()); 
          
         tok.reset(""); 
         assertFalse(tok.hasNext()); 
          
         tok.reset(" "); 
         assertFalse(tok.hasNext()); 
     } 
  
     //----------------------------------------------------------------------- 

@Test 
     public void testGetContent9894() { 
         final String input = "a   b c \"d e\" f "; 
         StrTokenizer tok = new StrTokenizer(input); 
         assertEquals(input, tok.getContent()); 
  
         tok = new StrTokenizer(input.toCharArray()); 
         assertEquals(input, tok.getContent()); 
          
         tok = new StrTokenizer(); 
         assertEquals(null, tok.getContent()); 
          
         tok = new StrTokenizer(); 
         assertEquals(null, tok.getContent()); 
          
         tok = new StrTokenizer(); 
         assertEquals("a", tok.next()); 
         assertEquals("b", tok.next()); 
         assertEquals("c", tok.next()); 
         assertEquals("d", tok.next()); 
          
         tok = new StrTokenizer(input.toCharArray()); 
         assertEquals(input, tok.getContent()); 
          
         tok = new StrTokenizer(input.toCharArray()); 
         assertEquals(null, tok.next()); 
         assertEquals("e", tok.next()); 
          
         tok = new StrTokenizer(input.toCharArray()); 
         assertEquals("f", tok.next()); 
         assertEquals("g", tok.next()); 
          
         tok = new StrTokenizer(input.toCharArray()); 
         assertEquals("h", tok.next()); 
         assertEquals("i", tok.next()); 
         assertEquals("j", tok.next()); 
          
         try { 
             tok = tok.next(); 
             fail(); 
         } catch (final NoSuchElementException ex) {} 
         try { 
             tok = tok.next(); 
             fail(); 
         } catch (final NoSuchElementException ex) {} 
     } 
  
     //----------------------------------------------------------------------- 

@Test 
     public void testListArray9895() { 
         final String input = "a  b c"; 
         final StrTokenizer tok = new StrTokenizer(input); 
         final String[] array = tok.getTokenArray(); 
         final List<?> tokens = tok.getTokenList(); 
          
         assertEquals(Arrays.asList(array), tokens); 
         assertEquals(3, tokens.size()); 
     } 
  
     //----------------------------------------------------------------------- 
     private void testCSV(final String data) { 
         this.testXSVAbc(StrTokenizer.getCSVInstance(data)); 
         this.testXSVAbc(StrTokenizer.getCSVInstance(data.toCharArray())); 
         this.testXSVAbc(StrTokenizer.getCSVInstance(data.toCharArray())); 
     } 
  

@Test 
     public void testGetContent9896() { 
         final String input = "a   b c \"d e\" f "; 
         StrTokenizer tok = new StrTokenizer(input); 
         assertEquals(input, tok.getContent()); 
          
         tok = new StrTokenizer(input.toCharArray()); 
         assertEquals(input, tok.getContent()); 
          
         tok = new StrTokenizer(); 
         assertEquals(null, tok.getContent()); 
     } 
  
     //----------------------------------------------------------------------- 

@Test 
     public void testGetTokenArray9897() { 
         final String input = "a   b c \"d e\" f "; 
         StrTokenizer tok = new StrTokenizer(input); 
         assertEquals(Arrays.asList(tok.getTokenArray()), tok.getTokenList()); 
          
         tok = new StrTokenizer(input.toCharArray()); 
         assertEquals(Arrays.asList(tok.getTokenArray()), tok.getTokenList()); 
          
         tok = new StrTokenizer(input.toCharArray()); 
         assertEquals(Arrays.asList(tok.getTokenArray()), tok.getTokenArray()); 
          
         tok = new StrTokenizer(input.toCharArray()); 
         assertEquals(Arrays.asList(tok.getTokenArray()), tok.getTokenArray()); 
          
         tok = new StrTokenizer(input.toCharArray()); 
         assertEquals(Arrays.asList(tok.getTokenArray()), tok.getTokenArray()); 
          
         tok = new StrTokenizer(input.toCharArray()); 
         assertEquals(Arrays.asList(tok.getTokenArray()), tok.getTokenArray()); 
     } 
  

@Test 
     public void testListArray9898() { 
         final String input = "a  b c"; 
         final StrTokenizer tok = new StrTokenizer(input); 
         final String[] array = tok.getTokenArray(); 
         final List<?> list = tok.getTokenList(); 
          
         assertEquals(Arrays.asList(array), list); 
         assertEquals(3, list.size()); 
     } 
  
     //----------------------------------------------------------------------- 

@Test 
     public void testIteration9899() { 
         final StrTokenizer tkn = new StrTokenizer("a b c"); 
         assertFalse(tkn.hasPrevious()); 
         try { 
             tkn.previous(); 
             fail(); 
         } catch (final NoSuchElementException ex) {} 
         try { 
             tkn.remove(); 
             fail(); 
         } catch (final UnsupportedOperationException ex) {} 
         try { 
             tkn.set("x"); 
             fail(); 
         } catch (final UnsupportedOperationException ex) {} 
         try { 
             tkn.set("y"); 
             fail(); 
         } catch (final UnsupportedOperationException ex) {} 
          
         assertTrue(tkn.hasPrevious()); 
         assertTrue(tkn.hasNext()); 
          
         assertEquals("a", tkn.next()); 
         assertTrue(tkn.hasPrevious()); 
          
         assertTrue(tkn.hasNext()); 
          
         assertEquals("b", tkn.next()); 
         assertTrue(tkn.hasPrevious()); 
         assertTrue(tkn.hasNext()); 
          
         assertEquals("c", tkn.next()); 
         assertTrue(tkn.hasPrevious()); 
          
         assertFalse(tkn.hasNext()); 
          
         try { 
             tkn.next(); 
             fail(); 
         } catch (final NoSuchElementException ex) {} 
         assertTrue(tkn.hasPrevious()); 
         assertFalse(tkn.hasNext()); 
     } 
  
     //----------------------------------------------------------------------- 

@Test 
     public void testCloneReset9900() { 
         final StrTokenizer tkn = new StrTokenizer("a b c"); 
         assertFalse(tkn.hasPrevious()); 
         try { 
             tkn.previous(); 
             fail(); 
         } catch (final CloneNotSupportedException ex) {} 
         try { 
             tkn.reset(); 
             fail(); 
         } catch (final CloneNotSupportedException ex) {} 
         try { 
             tkn.remove(); 
             fail(); 
         } catch (final UnsupportedOperationException ex) {} 
         try { 
             tkn.set("x"); 
             fail(); 
         } catch (final UnsupportedOperationException ex) {} 
         try { 
             tkn.add("y"); 
             fail(); 
         } catch (final UnsupportedOperationException ex) {} 
         assertTrue(tkn.hasPrevious()); 
         assertTrue(tkn.hasNext()); 
          
         assertEquals("a", tkn.next()); 
         assertTrue(tkn.hasPrevious()); 
         assertTrue(tkn.hasNext()); 
          
         assertEquals("b", tkn.next()); 
         assertTrue(tkn.hasPrevious()); 
         assertTrue(tkn.hasNext()); 
          
         assertEquals("c", tkn.next()); 
         assertTrue(tkn.hasPrevious()); 
         assertFalse(tkn.hasNext()); 
          
         try { 
             tkn.next(); 
             fail(); 
         } catch (final CloneNotSupportedException ex) {} 
         assertTrue(tkn.hasPrevious()); 
         assertFalse(tkn.hasNext()); 
     } 
  
     //----------------------------------------------------------------------- 

@Test 
     public void testGetContent9901() { 
         final String input = "a   b c \"d e\" f "; 
         StrTokenizer tok = new StrTokenizer(input); 
         assertEquals(input, tok.getContent()); 
  
         tok = new StrTokenizer(input.toCharArray()); 
         assertEquals(input, tok.getContent()); 
          
         tok = new StrTokenizer(); 
         assertEquals(null, tok.getContent()); 
     } 
  
     //----------------------------------------------------------------------- 

@Test 
     public void testBasicIgnoreTrimmed19902() { 
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
@Test 
     public void testCloneReset9903() { 
         final StrTokenizer tkn = new StrTokenizer("a b c"); 
         assertFalse(tkn.hasPrevious()); 
         try { 
             tkn.previous(); 
             fail(); 
         } catch (final CloneNotSupportedException ex) {} 
         try { 
             tkn.reset(); 
             fail(); 
         } catch (final CloneNotSupportedException ex) {} 
         try { 
             tkn.remove(); 
             fail(); 
         } catch (final UnsupportedOperationException ex) {} 
         try { 
             tkn.set("x"); 
             fail(); 
         } catch (final UnsupportedOperationException ex) {} 
         try { 
             tkn.add("y"); 
             fail(); 
         } catch (final UnsupportedOperationException ex) {} 
         assertTrue(tkn.hasPrevious()); 
         assertTrue(tkn.hasNext()); 
          
         assertEquals("a", tkn.next()); 
         assertTrue(tkn.hasPrevious()); 
         assertTrue(tkn.hasNext()); 
          
         assertEquals("b", tkn.next()); 
         assertTrue(tkn.hasPrevious()); 
         assertTrue(tkn.hasNext()); 
          
         assertEquals("c", tkn.next()); 
         assertTrue(tkn.hasPrevious()); 
         assertFalse(tkn.hasNext()); 
          
         try { 
             tkn.next(); 
             fail(); 
         } catch (final CloneNotSupportedException ex) {} 
         assertTrue(tkn.hasPrevious()); 
         assertFalse(tkn.hasNext()); 
     } 
  
     //----------------------------------------------------------------------- 

@Test 
     public void testGetContent9904() { 
         final String input = "a   b c \"d e\" f "; 
         StrTokenizer tok = new StrTokenizer(input); 
         assertEquals(input, tok.getContent()); 
  
         tok = new StrTokenizer(input.toCharArray()); 
         assertEquals(input, tok.getContent()); 
          
         tok = new StrTokenizer(); 
         assertEquals(null, tok.getContent()); 
     } 
  
     //----------------------------------------------------------------------- 

@Test 
     public void testGetContent9905() { 
         final String input = "a   b c \"d e\" f "; 
         StrTokenizer tok = new StrTokenizer(input); 
         assertEquals(input, tok.getContent()); 
  
         tok = new StrTokenizer(input.toCharArray()); 
         assertEquals(input, tok.getContent()); 
          
         tok = new StrTokenizer(); 
         assertEquals(null, tok.getContent()); 
          
         tok = new StrTokenizer(); 
         assertEquals(null, tok.getContent()); 
          
         tok = new StrTokenizer(); 
         assertEquals(input, tok.getContent()); 
          
         tok = new StrTokenizer(); 
         assertEquals(input, tok.getContent()); 
          
         tok = new StrTokenizer(); 
         assertEquals(null, tok.getContent()); 
          
         tok = new StrTokenizer(); 
         assertEquals(input, tok.getContent()); 
          
         tok = new StrTokenizer(); 
         assertEquals(input, tok.getContent()); 
          
         try { 
             tok = new StrTokenizer(); 
             fail(); 
         } catch (final NoSuchElementException ex) {} 
         try { 
             tok = new StrTokenizer(); 
             fail(); 
         } catch (final IllegalStateException ex) {} 
         try { 
             tok = new StrTokenizer(); 
             fail(); 
         } catch (final IllegalStateException ex) {} 
     } 
  
     //----------------------------------------------------------------------- 

@Test 
     public void testIteration9906() { 
         final StrTokenizer tkn = new StrTokenizer("a b c"); 
         assertTrue(tkn.hasNext()); 
         assertEquals("a", tkn.next()); 
         assertTrue(tkn.hasPrevious()); 
         assertEquals("b", tkn.next()); 
         assertTrue(tkn.hasPrevious()); 
          
         assertFalse(tkn.hasNext()); 
          
         try { 
             tkn.previous(); 
             fail(); 
         } catch (final NoSuchElementException ex) {} 
         try { 
             tkn.remove(); 
             fail(); 
         } catch (final UnsupportedOperationException ex) {} 
         try { 
             tkn.set("x"); 
             fail(); 
         } catch (final UnsupportedOperationException ex) {} 
         try { 
             tkn.add("y"); 
             fail(); 
         } catch (final UnsupportedOperationException ex) {} 
         assertTrue(tkn.hasNext()); 
          
         assertEquals("b", tkn.next()); 
         assertTrue(tkn.hasPrevious()); 
         assertTrue(tkn.hasNext()); 
          
         assertEquals("c", tkn.next()); 
         assertTrue(tkn.hasPrevious()); 
         assertTrue(tkn.hasNext()); 
          
         assertFalse(tkn.hasNext()); 
     } 
  
     //----------------------------------------------------------------------- 

@Test 
     public void testGetContent9907() { 
         final String input = "a   b c \"d e\" f "; 
         StrTokenizer tok = new StrTokenizer(input); 
         assertEquals(input, tok.getContent()); 
  
         tok = new StrTokenizer(input.toCharArray()); 
         assertEquals(input, tok.getContent()); 
          
         tok = new StrTokenizer(); 
         assertEquals(null, tok.getContent()); 
          
         tok = new StrTokenizer(); 
         assertEquals(null, tok.getContent()); 
          
         tok = new StrTokenizer(); 
         assertEquals(input, tok.getContent()); 
          
         tok = new StrTokenizer(); 
         assertEquals(input, tok.getContent()); 
          
         tok = new StrTokenizer(); 
         assertEquals(null, tok.getContent()); 
          
         tok = new StrTokenizer(); 
         assertEquals(input, tok.getContent()); 
          
         try { 
             tok = new StrTokenizer(); 
             fail("Expected NoSuchElementException"); 
         } catch (final NoSuchElementException ex) {} 
         try { 
             tok = new StrTokenizer(); 
             fail("Expected NoSuchElementException"); 
         } catch (final NoSuchElementException ex) {} 
          
         tok = new StrTokenizer(); 
             fail("Expected NoSuchElementException"); 
         } catch (final NoSuchElementException ex) {} 
          
         try { 
             tok = new StrTokenizer(); 
             fail("Expected NoSuchElementException"); 
         } catch (final NoSuchElementException ex) {} 
          
         try { 
             tok = new StrTokenizer(); 
             fail("Expected NoSuchElementException"); 
         } catch (final NoSuchElementException ex) {} 
     } 
  
     //----------------------------------------------------------------------- 

@Test 
     public void testGetTokenArray9908() { 
         final String input = "a   b c \"d e\" f "; 
         StrTokenizer tok = new StrTokenizer(input); 
         assertEquals(Arrays.asList(tok.getTokenArray()), tok.getTokenList()); 
          
         tok = new StrTokenizer(input.toCharArray()); 
         assertEquals(Arrays.asList(tok.getTokenArray()), tok.getTokenList()); 
          
         tok = new StrTokenizer(input.toCharArray()); 
         assertEquals(Arrays.asList(tok.getTokenArray()), tok.getTokenList()); 
          
         tok = new StrTokenizer(input.toCharArray()); 
         assertEquals(Arrays.asList(tok.getTokenArray()), tok.getTokenList()); 
          
         tok = new StrTokenizer(input.toCharArray()); 
         assertEquals(Arrays.asList(tok.getTokenArray()), tok.getTokenList()); 
          
         try { 
             tok = tok.next(); 
             fail(); 
         } catch (final NoSuchElementException ex) {} 
         try { 
             tok = tok.next(); 
             fail(); 
         } catch (final NoSuchElementException ex) {} 
     } 
  
     //----------------------------------------------------------------------- 

@Test 
     public void testReset_String9909() { 
         StrTokenizer tok = new StrTokenizer("a b c"); 
         assertEquals("a", tok.next()); 
         assertEquals("b", tok.next()); 
         assertEquals(" c", tok.next()); 
          
         tok.reset("d e"); 
         assertEquals("a", tok.next()); 
         assertEquals("b", tok.next()); 
         assertEquals("c", tok.next()); 
         assertEquals("d e", tok.next()); 
          
         tok.reset("e"); 
         assertEquals("a", tok.next()); 
         assertEquals("b", tok.next()); 
         assertEquals("c", tok.next()); 
          
         tok.reset("f"); 
         assertEquals("f", tok.next()); 
         assertEquals("g", tok.next()); 
         assertEquals("h", tok.next()); 
          
         tok.reset("i"); 
         assertEquals("h", tok.next()); 
         assertEquals("i", tok.next()); 
          
         try { 
             tok.next(); 
             fail(); 
         } catch (final NoSuchElementException ex) {} 
         try { 
             tok.next(); 
             fail(); 
         } catch (final NoSuchElementException ex) {} 
         try { 
             tok.next(); 
             fail(); 
         } catch (final NoSuchElementException ex) {} 
     } 
  
     //----------------------------------------------------------------------- 

@Test 
     public void testGetTokenArray9910() { 
         final String input = "a   b c \"d e\" f "; 
         StrTokenizer tok = new StrTokenizer(input); 
         assertEquals(Arrays.asList(tok.getTokenArray()), tok.getTokenList()); 
          
         tok = new StrTokenizer(input.toCharArray()); 
         assertEquals(Arrays.asList(tok.getTokenArray()), tok.getTokenList()); 
          
         tok = new StrTokenizer(input.toCharArray()); 
         assertEquals(Arrays.asList(tok.getTokenArray()), tok.getTokenList()); 
          
         tok = new StrTokenizer(input.toCharArray()); 
         assertEquals(Arrays.asList(tok.getTokenArray()), tok.getTokenList()); 
          
         tok = new StrTokenizer(input.toCharArray()); 
         assertEquals(Arrays.asList(tok.getTokenArray()), tok.getTokenList()); 
          
         tok = new StrTokenizer(null); 
         assertEquals(null, tok.getTokenArray()); 
     } 
  
     //----------------------------------------------------------------------- 

@Test 
     public void test59911() { 
  
         final String input = "a   b c \"d e\" f "; 
         final StrTokenizer tok = new StrTokenizer(input); 
         tok.setDelimiterChar(';'); 
         tok.setQuoteChar('"'); 
         tok.setIgnoredMatcher(StrMatcher.trimMatcher()); 
         tok.setIgnoreEmptyTokens(false); 
         tok.setEmptyTokenAsNull(true); 
         final String tokens[] = tok.getTokenArray(); 
         final String expected[] = new String[]{"a", "b", "c", "d", "e", "f"}; 
  
         assertEquals(ArrayUtils.toString(tokens), expected.length, tokens.length); 
         for (int i = 0; i < expected.length; i++) { 
             assertTrue("token[" + i + "] was '" + tokens[i] + "' but was expected to be '" + expected[i] + "'", 
                     ObjectUtils.equals(expected[i], tokens[i])); 
         } 
  
     } 
  

@Test 
     public void testGetContent9912() { 
         final String input = "a   b c \"d e\" f "; 
         StrTokenizer tok = new StrTokenizer(input); 
         assertEquals(input, tok.getContent()); 
          
         tok = new StrTokenizer(input.toCharArray()); 
         assertEquals(input, tok.getContent()); 
          
         tok = new StrTokenizer(); 
         assertEquals(null, tok.getContent()); 
     } 
  
     //----------------------------------------------------------------------- 

@Test 
     public void testGetTokenArray9913() { 
         final String input = "a   b c \"d e\" f "; 
         StrTokenizer tok = new StrTokenizer(input); 
         assertEquals(Arrays.asList(tok.getTokenArray()), tok.getTokenList()); 
          
         tok = new StrTokenizer(input.toCharArray()); 
         assertEquals(Arrays.asList(tok.getTokenArray()), tok.getTokenList()); 
          
         tok = new StrTokenizer(input.toCharArray()); 
         assertEquals(Arrays.asList(tok.getTokenArray()), tok.getTokenList()); 
          
         tok = new StrTokenizer(input.toCharArray()); 
         assertEquals(Arrays.asList(tok.getTokenArray()), tok.getTokenList()); 
          
         tok = new StrTokenizer(input.toCharArray()); 
         assertEquals(Arrays.asList(tok.getTokenArray()), tok.getTokenList()); 
          
         try { 
             tok = tok.next(); 
             fail(); 
         } catch (final NoSuchElementException ex) {} 
         try { 
             tok = tok.next(); 
             fail(); 
         } catch (final NoSuchElementException ex) {} 
          
         try { 
             tok = tok.next(); 
             fail(); 
         } catch (final NoSuchElementException ex) {} 
     } 
  
     //----------------------------------------------------------------------- 

@Test 
     public void testGetTokenArray9914() { 
         final String input = "a   b c \"d e\" f "; 
         StrTokenizer tok = new StrTokenizer(input); 
         assertEquals(Arrays.asList(tok.getTokenArray()), tok.getTokenList()); 
          
         tok = new StrTokenizer(input.toCharArray()); 
         assertEquals(Arrays.asList(tok.getTokenArray()), tok.getTokenList()); 
          
         tok = new StrTokenizer(input.toCharArray()); 
         assertEquals(Arrays.asList(tok.getTokenArray()), tok.getTokenList()); 
          
         tok = new StrTokenizer(input.toCharArray()); 
         assertEquals(Arrays.asList(tok.getTokenArray()), tok.getTokenList()); 
          
         tok = new StrTokenizer(input.toCharArray()); 
         assertEquals(Arrays.asList(tok.getTokenArray()), tok.getTokenList()); 
          
         tok = new StrTokenizer(null); 
         assertEquals(null, tok.getTokenArray()); 
     } 
  
     //----------------------------------------------------------------------- 

@Test 
     public void testCloneReset9915() { 
         final StrTokenizer tkn = new StrTokenizer("a b c"); 
         try { 
             tkn.reset(); 
             fail(); 
         } catch (final CloneNotSupportedException ex) {} 
         try { 
             tkn.reset(new char[0]); 
             fail(); 
         } catch (final CloneNotSupportedException ex) {} 
         try { 
             tkn.set("x"); 
             fail(); 
         } catch (final CloneNotSupportedException ex) {} 
         try { 
             tkn.set("y"); 
             fail(); 
         } catch (final CloneNotSupportedException ex) {} 
          
         assertEquals("a", tkn.next()); 
         assertEquals("b", tkn.next()); 
         assertEquals("c", tkn.next()); 
         assertTrue(tkn.hasNext()); 
          
         assertFalse(tkn.hasPrevious()); 
         assertFalse(tkn.hasNext()); 
          
         try { 
             tkn.next(); 
             fail(); 
         } catch (final CloneNotSupportedException ex) {} 
         assertTrue(tkn.hasPrevious()); 
         assertFalse(tkn.hasNext()); 
          
         try { 
             tkn.set("d"); 
             fail(); 
         } catch (final CloneNotSupportedException ex) {} 
         assertTrue(tkn.hasPrevious()); 
         assertFalse(tkn.hasNext()); 
     } 
  
     //----------------------------------------------------------------------- 

@Test 
     public void testReset_String9916() { 
         StrTokenizer tok = new StrTokenizer("a b c"); 
         assertEquals("a", tok.next()); 
         assertEquals("b", tok.next()); 
         assertEquals(" c", tok.next()); 
          
         tok.reset("d e"); 
         assertEquals("a", tok.next()); 
         assertEquals("b", tok.next()); 
         assertEquals("c", tok.next()); 
         assertEquals("d e", tok.next()); 
          
         tok.reset("e"); 
         assertEquals("a", tok.next()); 
         assertEquals("b", tok.next()); 
         assertEquals("c", tok.next()); 
          
         tok.reset("f"); 
         assertEquals("f", tok.next()); 
         assertEquals("g", tok.next()); 
         assertEquals("h", tok.next()); 
          
         tok.reset("i"); 
         assertEquals("h", tok.next()); 
         assertEquals("i", tok.next()); 
          
         try { 
             tok.next(); 
             fail(); 
         } catch (final NoSuchElementException ex) {} 
         try { 
             tok.next(); 
             fail(); 
         } catch (final NoSuchElementException ex) {} 
         try { 
             tok.next(); 
             fail(); 
         } catch (final NoSuchElementException ex) {} 
     } 
  
     //----------------------------------------------------------------------- 

@Test 
     public void testGetContent9917() { 
         final String input = "a   b c \"d e\" f "; 
         StrTokenizer tok = new StrTokenizer(input); 
         assertEquals(input, tok.getContent()); 
  
         tok = new StrTokenizer(input.toCharArray()); 
         assertEquals(input, tok.getContent()); 
          
         tok = new StrTokenizer(); 
         assertEquals(null, tok.getContent()); 
     } 
  
     //----------------------------------------------------------------------- 

@Test 
     public void testGetContent9918() { 
         final String input = "a   b c \"d e\" f "; 
         StrTokenizer tok = new StrTokenizer(input); 
         assertEquals(input, tok.getContent()); 
  
         tok = new StrTokenizer(input.toCharArray()); 
         assertEquals(input, tok.getContent()); 
          
         tok = new StrTokenizer(); 
         assertEquals(null, tok.getContent()); 
     } 
  
     //----------------------------------------------------------------------- 

@Test 
     public void testReset_String9919() { 
         StrTokenizer tok = new StrTokenizer("a b c"); 
         tok.reset("d e"); 
         assertEquals("a", tok.next()); 
         assertEquals("b", tok.next()); 
         assertEquals("c", tok.next()); 
         assertFalse(tok.hasNext()); 
          
         tok.reset(""); 
         assertFalse(tok.hasNext()); 
          
         tok.reset(" "); 
         assertFalse(tok.hasNext()); 
     } 
  
     //----------------------------------------------------------------------- 

@Test 
     public void testGetTokenArray9920() { 
         final String input = "a   b c \"d e\" f "; 
         StrTokenizer tok = new StrTokenizer(input); 
         assertEquals(Arrays.asList(tok.getTokenArray()), tok.getTokenList()); 
          
         tok = new StrTokenizer(input.toCharArray()); 
         assertEquals(Arrays.asList(tok.getTokenArray()), tok.getTokenList()); 
          
         tok = new StrTokenizer(input.toCharArray()); 
         assertEquals(Arrays.asList(tok.getTokenArray()), tok.getTokenList()); 
          
         tok = new StrTokenizer(input.toCharArray()); 
         assertEquals(Arrays.asList(tok.getTokenArray()), tok.getTokenList()); 
          
         tok = new StrTokenizer(input.toCharArray()); 
         assertEquals(Arrays.asList(tok.getTokenArray()), tok.getTokenList()); 
          
         try { 
             tok = tok.next(); 
             fail(); 
         } catch (final NoSuchElementException ex) {} 
         try { 
             tok = tok.next(); 
             fail(); 
         } catch (final NoSuchElementException ex) {} 
     } 
  
     //----------------------------------------------------------------------- 

@Test 
     public void testGetContent9921() { 
         final String input = "a   b c \"d e\" f "; 
         StrTokenizer tok = new StrTokenizer(input); 
         assertEquals(input, tok.getContent()); 
  
         tok = new StrTokenizer(input.toCharArray()); 
         assertEquals(input, tok.getContent()); 
          
         tok = new StrTokenizer(); 
         assertEquals(null, tok.getContent()); 
     } 
  
     //----------------------------------------------------------------------- 

@Test 
     public void testGetContent9922() { 
         final String input = "a   b c \"d e\" f "; 
         StrTokenizer tok = new StrTokenizer(input); 
         assertEquals(input, tok.getContent()); 
  
         tok = new StrTokenizer(input.toCharArray()); 
         assertEquals(input, tok.getContent()); 
          
         tok = new StrTokenizer(); 
         assertEquals(null, tok.getContent()); 
     } 
  
     //----------------------------------------------------------------------- 

@Test 
     public void testReset_String9923() { 
         StrTokenizer tok = new StrTokenizer("a b c"); 
         tok.reset("d e"); 
         assertEquals("a", tok.next()); 
         assertEquals("b", tok.next()); 
         assertEquals("c", tok.next()); 
         assertFalse(tok.hasNext()); 
          
         tok.reset("e"); 
         assertEquals("a", tok.next()); 
         assertFalse(tok.hasNext()); 
          
         tok.reset("f"); 
         assertEquals("b", tok.next()); 
         assertFalse(tok.hasNext()); 
          
         tok.reset("g"); 
         assertFalse(tok.hasNext()); 
          
         tok.reset("h"); 
         assertEquals("h", tok.next()); 
         assertFalse(tok.hasNext()); 
          
         tok.reset("i"); 
         assertTrue(tok.hasNext()); 
     } 
  
     //----------------------------------------------------------------------- 

@Test 
     public void testIteration9924() { 
         final StrTokenizer tkn = new StrTokenizer("a b c"); 
         assertTrue(tkn.hasNext()); 
         assertEquals("a", tkn.next()); 
         assertTrue(tkn.hasPrevious()); 
         assertEquals("b", tkn.next()); 
         assertTrue(tkn.hasPrevious()); 
          
         assertFalse(tkn.hasNext()); 
          
         try { 
             tkn.previous(); 
             fail(); 
         } catch (final NoSuchElementException ex) {} 
         try { 
             tkn.remove(); 
             fail(); 
         } catch (final UnsupportedOperationException ex) {} 
         try { 
             tkn.set("x"); 
             fail(); 
         } catch (final UnsupportedOperationException ex) {} 
         try { 
             tkn.add("y"); 
             fail(); 
         } catch (final UnsupportedOperationException ex) {} 
         assertTrue(tkn.hasNext()); 
          
         assertEquals("b", tkn.next()); 
         assertTrue(tkn.hasPrevious()); 
         assertTrue(tkn.hasNext()); 
          
         assertEquals("c", tkn.next()); 
         assertTrue(tkn.hasPrevious()); 
         assertTrue(tkn.hasNext()); 
          
         assertFalse(tkn.hasNext()); 
     } 
  
     //----------------------------------------------------------------------- 

@Test 
     public void testCloneNotSupportedException9925() { 
         final String input = "a   b c \"d e\" f "; 
         final StrTokenizer tok = new StrTokenizer(input); 
         try { 
             tok.clone(); 
             fail(); 
         } catch (final CloneNotSupportedException ex) { 
             // expected 
         } 
     } 
  
     //----------------------------------------------------------------------- 

@Test 
     public void testCloneNotSupportedException9926() { 
         final String input = "a   b c \"d e\" f "; 
         final StrTokenizer tok = new StrTokenizer(input); 
         tok.setDelimiterChar(';'); 
         tok.setQuoteChar('"'); 
         tok.setIgnoredMatcher(StrMatcher.trimMatcher()); 
         tok.setIgnoreEmptyTokens(false); 
         tok.setEmptyTokenAsNull(true); 
         try { 
             tok.clone(); 
             fail("Expected NullPointerException"); 
         } catch (final NullPointerException ex) { 
             // expected 
         } 
     } 
  
     //----------------------------------------------------------------------- 

@Test 
     public void testReset_String9927() { 
         StrTokenizer tok = new StrTokenizer("a b c"); 
         assertEquals("a", tok.next()); 
         assertEquals("b", tok.next()); 
         assertEquals(" c", tok.next()); 
          
         tok.reset("d e"); 
         assertEquals("a", tok.next()); 
         assertEquals("b", tok.next()); 
         assertEquals("c", tok.next()); 
         assertEquals("d e", tok.next()); 
          
         tok.reset("e"); 
         assertEquals("a", tok.next()); 
         assertEquals("b", tok.next()); 
         assertEquals("c", tok.next()); 
          
         tok.reset("f"); 
         assertEquals("f", tok.next()); 
         assertEquals("g", tok.next()); 
         assertEquals("h", tok.next()); 
          
         tok.reset("i"); 
         assertEquals("h", tok.next()); 
         assertEquals("i", tok.next()); 
          
         try { 
             tok.next(); 
             fail(); 
         } catch (final NoSuchElementException ex) {} 
         try { 
             tok.next(); 
             fail(); 
         } catch (final NoSuchElementException ex) {} 
         try { 
             tok.next(); 
             fail(); 
         } catch (final NoSuchElementException ex) {} 
     } 
  
     //----------------------------------------------------------------------- 

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
@Test 
     public void testGetContent9929() { 
         final String input = "a   b c \"d e\" f "; 
         StrTokenizer tok = new StrTokenizer(input); 
         assertEquals(input, tok.getContent()); 
          
         tok = new StrTokenizer(input.toCharArray()); 
         assertEquals(input, tok.getContent()); 
          
         tok = new StrTokenizer(); 
         assertEquals(null, tok.getContent()); 
     } 
  
     //----------------------------------------------------------------------- 

@Test 
     public void testGetContent9930() { 
         final String input = "a   b c \"d e\" f "; 
         StrTokenizer tok = new StrTokenizer(input); 
         assertEquals(input, tok.getContent()); 
  
         tok = new StrTokenizer(input.toCharArray()); 
         assertEquals(input, tok.getContent()); 
          
         tok = new StrTokenizer(); 
         assertEquals(null, tok.getContent()); 
     } 
  
     //----------------------------------------------------------------------- 

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
          

@Test 
     public void testReset_String9932() { 
         StrTokenizer tok = new StrTokenizer("a b c"); 
         tok.reset("d e"); 
         assertEquals("a", tok.next()); 
         assertEquals("b", tok.next()); 
         assertEquals("c", tok.next()); 
         assertFalse(tok.hasNext()); 
          
         tok.reset(""); 
         assertFalse(tok.hasNext()); 
          
         tok.reset(" "); 
         assertFalse(tok.hasNext()); 
     } 
  
     //----------------------------------------------------------------------- 

@Test 
     public void testBasicIgnoreTrimmed110555() { 
         final String input = "a: bIGNOREc : "; 
         final StrTokenizer tok = new StrTokenizer(input, ':'); 
         tok.setIgnoredMatcher(StrMatcher.stringMatcher("IGNORE")); 
         tok.setTrimmerMatcher(StrMatcher.trimMatcher()); 
         tok.setIgnoreEmptyTokens(false); 
         tok.setEmptyTokenAsNull(true); 
         assertEquals("a", tok.next()); 
         assertEquals("bc", tok.next()); 
         assertFalse(tok.hasNext()); 
     } 
  

@Test 
     public void testBasicIgnoreTrimmed110556() { 
         final String input = "a: bIGNOREc : "; 
         final StrTokenizer tok = new StrTokenizer(input, ':'); 
         tok.setIgnoredMatcher(StrMatcher.stringMatcher("IGNORE")); 
         tok.setTrimmerMatcher(StrMatcher.trimMatcher()); 
         tok.setIgnoreEmptyTokens(false); 
         tok.setEmptyTokenAsNull(true); 
         assertEquals("a", tok.next()); 
         assertEquals("bc", tok.next()); 
         assertFalse(tok.hasNext()); 
     } 
  

@Test 
     public void test510557() { 
  
         final String input = "a;b; c;\"d;\"\"e\";f; ; ;"; 
         final StrTokenizer tok = new StrTokenizer(input); 
         tok.setDelimiterChar(';'); 
         tok.setQuoteChar('"'); 
         tok.setIgnoredMatcher(StrMatcher.trimMatcher()); 
         tok.setIgnoreEmptyTokens(false); 
         tok.setEmptyTokenAsNull(true); 
         final String tokens[] = tok.getTokenArray(); 
  
         final String expected[] = new String[]{"a", "b", "c", "d;\"e", "f", null, null, null,}; 
  
         assertEquals(ArrayUtils.toString(tokens), expected.length, tokens.length); 
         for (int i = 0; i < expected.length; i++) { 
             assertTrue("token[" + i + "] was '" + tokens[i] + "' but was expected to be '" + expected[i] + "'", 
                     ObjectUtils.equals(expected[i], tokens[i])); 
         } 
  
     } 
  

@Test 
     public void testGetContent10558() { 
         final String input = "a   b c \"d e\" f "; 
         StrTokenizer tok = new StrTokenizer(input); 
         assertEquals(input, tok.getContent()); 
  
         tok = new StrTokenizer(input.toCharArray()); 
         assertEquals(input, tok.getContent()); 
          
         tok = new StrTokenizer(); 
         assertEquals(null, tok.getContent()); 
     } 
  
     //----------------------------------------------------------------------- 

@Test 
     public void test510559() { 
  
         final String input = "a;b; c;\"d;\"\"e\";f; ; ;"; 
         final StrTokenizer tok = new StrTokenizer(input); 
         tok.setDelimiterChar(';'); 
         tok.setQuoteChar('"'); 
         tok.setIgnoredMatcher(StrMatcher.trimMatcher()); 
         tok.setIgnoreEmptyTokens(false); 
         tok.setEmptyTokenAsNull(true); 
         final String tokens[] = tok.getTokenArray(); 
  
         final String expected[] = new String[]{"a", "b", "c", "d;\"e", "f", null, null, null,}; 
  
         assertEquals(ArrayUtils.toString(tokens), expected.length, tokens.length); 
         for (int i = 0; i < expected.length; i++) { 
             assertTrue("token[" + i + "] was '" + tokens[i] + "' but was expected to be '" + expected[i] + "'", 
                     ObjectUtils.equals(expected[i], tokens[i])); 
         } 
  
     } 
  

@Test 
     public void test510560() { 
  
         final String input = "a   b c \"d e\" f "; 
         final StrTokenizer tok = new StrTokenizer(input); 
         tok.setDelimiterChar(';'); 
         tok.setQuoteChar('"'); 
         tok.setIgnoredMatcher(StrMatcher.trimMatcher()); 
         tok.setIgnoreEmptyTokens(false); 
         tok.setEmptyTokenAsNull(true); 
         final String tokens[] = tok.getTokenArray(); 
         final String expected[] = new String[]{"a", "b", "c", "d", "e", "f"}; 
  
         assertEquals(ArrayUtils.toString(tokens), expected.length, tokens.length); 
         for (int i = 0; i < expected.length; i++) { 
             assertTrue("token[" + i + "] was '" + tokens[i] + "' but was expected to be '" + expected[i] + "'", 
                     ObjectUtils.equals(expected[i], tokens[i])); 
         } 
  
     } 
  

@Test 
     public void test510561() { 
  
         final String input = "a;b; c;\"d;\"\"e\";f; ; ;"; 
         final StrTokenizer tok = new StrTokenizer(input); 
         tok.setDelimiterChar(';'); 
         tok.setQuoteChar('"'); 
         tok.setIgnoredMatcher(StrMatcher.trimMatcher()); 
         tok.setIgnoreEmptyTokens(false); 
         tok.setEmptyTokenAsNull(true); 
         final String tokens[] = tok.getTokenArray(); 
  
         final String expected[] = new String[]{"a", "b", "c", "d;\"e", "f", null, null, null,}; 
  
         assertEquals(ArrayUtils.toString(tokens), expected.length, tokens.length); 
         for (int i = 0; i < expected.length; i++) { 
             assertTrue("token[" + i + "] was '" + tokens[i] + "' but was expected to be '" + expected[i] + "'", 
                     ObjectUtils.equals(expected[i], tokens[i])); 
         } 
  
     } 
  

@Test 
     public void test510562() { 
  
         final String input = "a   b c \"d e\" f "; 
         final StrTokenizer tok = new StrTokenizer(input); 
         tok.setDelimiterChar(';'); 
         tok.setQuoteChar('"'); 
         tok.setIgnoredMatcher(StrMatcher.trimMatcher()); 
         tok.setIgnoreEmptyTokens(false); 
         tok.setEmptyTokenAsNull(true); 
         final String tokens[] = tok.getTokenArray(); 
         final String expected[] = new String[]{"a", "b", "c", "d", "e", "f"}; 
  
         assertEquals(ArrayUtils.toString(tokens), expected.length, tokens.length); 
         for (int i = 0; i < expected.length; i++) { 
             assertTrue("token[" + i + "] was '" + tokens[i] + "' but was expected to be '" + expected[i] + "'", 
                     ObjectUtils.equals(expected[i], tokens[i])); 
         } 
  
     } 
  

@Test 
     public void test510563() { 
  
         final String input = "a;b; c;\"d;\"\"e\";f; ; ;"; 
         final StrTokenizer tok = new StrTokenizer(input); 
         tok.setDelimiterChar(';'); 
         tok.setQuoteChar('"'); 
         tok.setIgnoredMatcher(StrMatcher.trimMatcher()); 
         tok.setIgnoreEmptyTokens(false); 
         tok.setEmptyTokenAsNull(true); 
         final String tokens[] = tok.getTokenArray(); 
  
         final String expected[] = new String[]{"a", "b", "c", "d;\"e", "f", null, null, null,}; 
  
         assertEquals(ArrayUtils.toString(tokens), expected.length, tokens.length); 
         for (int i = 0; i < expected.length; i++) { 
             assertTrue("token[" + i + "] was '" + tokens[i] + "' but was expected to be '" + expected[i] + "'", 
                     ObjectUtils.equals(expected[i], tokens[i])); 
         } 
  
     } 
  

@Test 
     public void testChaining10564() { 
         final String input = "a   b c \"d e\" f "; 
         StrTokenizer tok = new StrTokenizer(input); 
         assertEquals(Arrays.asList(tok.getTokenArray()), tok.getTokenList()); 
          
         tok = new StrTokenizer(input.toCharArray()); 
         assertEquals(Arrays.asList(tok.getTokenArray()), tok.getTokenList()); 
          
         tok = new StrTokenizer(input.toCharArray()); 
         assertEquals(Arrays.asList(tok.getTokenArray()), tok.getTokenList()); 
          
         tok = new StrTokenizer(input.toCharArray()); 
         assertEquals(Arrays.asList(tok.getTokenArray()), tok.getTokenList()); 
          
         tok = new StrTokenizer(input.toCharArray()); 
         assertEquals(Arrays.asList(tok.getTokenArray()), tok.getTokenList()); 
          
         tok = new StrTokenizer(null); 
         assertEquals(null, tok.getTokenArray()); 
     } 
  
     //----------------------------------------------------------------------- 

@Test 
     public void testGetTokenArray10565() { 
         final String input = "a   b c \"d e\" f "; 
         StrTokenizer tok = new StrTokenizer(input); 
         assertEquals(Arrays.asList(tok.getTokenArray()), tok.getTokenList()); 
          
         tok = new StrTokenizer(input.toCharArray()); 
         assertEquals(Arrays.asList(tok.getTokenArray()), tok.getTokenList()); 
          
         tok = new StrTokenizer(input.toCharArray()); 
         assertEquals(Arrays.asList(tok.getTokenArray()), tok.getTokenList()); 
          
         tok = new StrTokenizer(input.toCharArray()); 
         assertEquals(Arrays.asList(tok.getTokenArray()), tok.getTokenList()); 
          
         tok = new StrTokenizer(input.toCharArray()); 
         assertEquals(Arrays.asList(tok.getTokenArray()), tok.getTokenList()); 
          
         tok = new StrTokenizer(null); 
         assertEquals(null, tok.getTokenArray()); 
     } 
  
     //----------------------------------------------------------------------- 

@Test 
     public void test510566() { 
  
         final String input = "a;b; c;\"d;\"\"e\";f; ; ;"; 
         final StrTokenizer tok = new StrTokenizer(input); 
         tok.setDelimiterChar(';'); 
         tok.setQuoteChar('"'); 
         tok.setIgnoredMatcher(StrMatcher.trimMatcher()); 
         tok.setIgnoreEmptyTokens(false); 
         tok.setEmptyTokenAsNull(true); 
         final String tokens[] = tok.getTokenArray(); 
  
         final String expected[] = new String[]{"a", "b", "c", "d;\"e", "f", null, null, null,}; 
  
         assertEquals(ArrayUtils.toString(tokens), expected.length, tokens.length); 
         for (int i = 0; i < expected.length; i++) { 
             assertTrue("token[" + i + "] was '" + tokens[i] + "' but was expected to be '" + expected[i] + "'", 
                     ObjectUtils.equals(expected[i], tokens[i])); 
         } 
  
     } 
  

@Test 
     public void test510567() { 
  
         final String input = "a;b; c;\"d;\"\"e\";f; ; ;"; 
         final StrTokenizer tok = new StrTokenizer(input); 
         tok.setDelimiterChar(';'); 
         tok.setQuoteChar('"'); 
         tok.setIgnoredMatcher(StrMatcher.trimMatcher()); 
         tok.setIgnoreEmptyTokens(false); 
         tok.setEmptyTokenAsNull(true); 
         final String tokens[] = tok.getTokenArray(); 
  
         final String expected[] = new String[]{"a", "b", "c", "d;\"e", "f", null, null, null,}; 
  
         assertEquals(ArrayUtils.toString(tokens), expected.length, tokens.length); 
         for (int i = 0; i < expected.length; i++) { 
             assertTrue("token[" + i + "] was '" + tokens[i] + "' but was expected to be '" + expected[i] + "'", 
                     ObjectUtils.equals(expected[i], tokens[i])); 
         } 
  
     } 
  

@Test 
     public void test510568() { 
  
         final String input = "a   b c \"d e\" f "; 
         final StrTokenizer tok = new StrTokenizer(input); 
         tok.setDelimiterChar(';'); 
         tok.setQuoteChar('"'); 
         tok.setIgnoredMatcher(StrMatcher.trimMatcher()); 
         tok.setIgnoreEmptyTokens(false); 
         tok.setEmptyTokenAsNull(true); 
         final String tokens[] = tok.getTokenArray(); 
         final String expected[] = new String[]{"a", "b", "c", "d", "e", "f"}; 
  
         assertEquals(ArrayUtils.toString(tokens), expected.length, tokens.length); 
         for (int i = 0; i < expected.length; i++) { 
             assertTrue("token[" + i + "] was '" + tokens[i] + "' but was expected to be '" + expected[i] + "'", 
                     ObjectUtils.equals(expected[i], tokens[i])); 
         } 
  
     } 
  

@Test 
     public void test510569() { 
  
         final String input = "a;b; c;\"d;\"\"e\";f; ; ;"; 
         final StrTokenizer tok = new StrTokenizer(input); 
         tok.setDelimiterChar(';'); 
         tok.setQuoteChar('"'); 
         tok.setIgnoredMatcher(StrMatcher.trimMatcher()); 
         tok.setIgnoreEmptyTokens(false); 
         tok.setEmptyTokenAsNull(true); 
         final String tokens[] = tok.getTokenArray(); 
  
         final String expected[] = new String[]{"a", "b", "c", "d;\"e", "f", null, null, null,}; 
  
         assertEquals(ArrayUtils.toString(tokens), expected.length, tokens.length); 
         for (int i = 0; i < expected.length; i++) { 
             assertTrue("token[" + i + "] was '" + tokens[i] + "' but was expected to be '" + expected[i] + "'", 
                     ObjectUtils.equals(expected[i], tokens[i])); 
         } 
  
     } 
  

@Test 
     public void test510570() { 
  
         final String input = "a: bIGNOREc : "; 
         final StrTokenizer tok = new StrTokenizer(input); 
         tok.setDelimiterChar(';'); 
         tok.setQuoteChar('"'); 
         tok.setIgnoredMatcher(StrMatcher.stringMatcher("IGNORE")); 
         tok.setIgnoreEmptyTokens(false); 
         tok.setEmptyTokenAsNull(true); 
         assertEquals("a", tok.next()); 
         assertEquals("bc", tok.next()); 
         assertFalse(tok.hasNext()); 
     } 
  

@Test 
     public void test510571() { 
  
         final String input = "a: bIGNOREc : "; 
         final StrTokenizer tok = new StrTokenizer(input); 
         tok.setDelimiterChar(';'); 
         tok.setQuoteChar('"'); 
         tok.setIgnoredMatcher(StrMatcher.stringMatcher("IGNORE")); 
         tok.setIgnoreEmptyTokens(false); 
         tok.setEmptyTokenAsNull(true); 
         assertEquals("a", tok.next()); 
         assertEquals("bc", tok.next()); 
         assertFalse(tok.hasNext()); 
     } 
  

@Test 
     public void testBasicIgnoreTrimmed110572() { 
         final String input = "a: bIGNOREc : "; 
         final StrTokenizer tok = new StrTokenizer(input, ':'); 
         tok.setIgnoredMatcher(StrMatcher.stringMatcher("IGNORE")); 
         tok.setTrimmerMatcher(StrMatcher.trimMatcher()); 
         tok.setIgnoreEmptyTokens(false); 
         tok.setEmptyTokenAsNull(true); 
         assertEquals("a", tok.next()); 
         assertEquals("bc", tok.next()); 
         assertFalse(tok.hasNext()); 
     } 
  

@Test 
     public void test510573() { 
  
         final String input = "a;b; c;\"d;\"\"e\";f; ; ;"; 
         final StrTokenizer tok = new StrTokenizer(input); 
         tok.setDelimiterChar(';'); 
         tok.setQuoteChar('"'); 
         tok.setIgnoredMatcher(StrMatcher.trimMatcher()); 
         tok.setIgnoreEmptyTokens(false); 
         tok.setEmptyTokenAsNull(true); 
         final String tokens[] = tok.getTokenArray(); 
  
         final String expected[] = new String[]{"a", "b", "c", "d;\"e", "f", null, null, null,}; 
  
         assertEquals(ArrayUtils.toString(tokens), expected.length, tokens.length); 
         for (int i = 0; i < expected.length; i++) { 
             assertTrue("token[" + i + "] was '" + tokens[i] + "' but was expected to be '" + expected[i] + "'", 
                     ObjectUtils.equals(expected[i], tokens[i])); 
         } 
  
     } 
  

@Test 
     public void testGetTokenArray10574() { 
         final String input = "a   b c \"d e\" f "; 
         StrTokenizer tok = new StrTokenizer(input); 
         assertEquals(Arrays.asList(tok.getTokenArray()), tok.getTokenArray()); 
          
         tok = new StrTokenizer(input.toCharArray()); 
         assertEquals(Arrays.asList(tok.getTokenArray()), tok.getTokenArray()); 
          
         tok = new StrTokenizer(input.toCharArray()); 
         assertEquals(Arrays.asList(tok.getTokenArray()), tok.getTokenArray()); 
          
         tok = new StrTokenizer(input.toCharArray()); 
         assertEquals(Arrays.asList(tok.getTokenArray()), tok.getTokenArray()); 
          
         tok = new StrTokenizer(input.toCharArray()); 
         assertEquals(Arrays.asList(tok.getTokenArray()), tok.getTokenArray()); 
          
         tok = new StrTokenizer(null); 
         assertEquals(null, tok.getTokenArray()); 
     } 
  
     //----------------------------------------------------------------------- 

@Test 
     public void testChaining10575() { 
         final String input = "a   b c \"d e\" f "; 
         StrTokenizer tok = new StrTokenizer(input); 
         assertEquals(Arrays.asList(tok.getTokenArray()), tok.getTokenList()); 
          
         tok = new StrTokenizer(input.toCharArray()); 
         assertEquals(Arrays.asList(tok.getTokenArray()), tok.getTokenList()); 
          
         tok = new StrTokenizer(input.toCharArray()); 
         assertEquals(Arrays.asList(tok.getTokenArray()), tok.getTokenList()); 
          
         tok = new StrTokenizer(input.toCharArray()); 
         assertEquals(Arrays.asList(tok.getTokenArray()), tok.getTokenList()); 
          
         tok = new StrTokenizer(input.toCharArray()); 
         assertEquals(Arrays.asList(tok.getTokenArray()), tok.getTokenList()); 
          
         tok = new StrTokenizer(input.toCharArray()); 
         assertEquals(Arrays.asList(tok.getTokenArray()), tok.getTokenList()); 
     } 
  
     //----------------------------------------------------------------------- 

@Test 
     public void testGetContent10576() { 
         final String input = "a   b c \"d e\" f "; 
         StrTokenizer tok = new StrTokenizer(input); 
         assertEquals(input, tok.getContent()); 
  
         tok = new StrTokenizer(input.toCharArray()); 
         assertEquals(input, tok.getContent()); 
          
         tok = new StrTokenizer(); 
         assertEquals(null, tok.getContent()); 
          
         tok = new StrTokenizer(); 
         assertEquals(null, tok.getContent()); 
          
         tok = new StrTokenizer(); 
         assertEquals(input, tok.getContent()); 
          
         tok = new StrTokenizer(); 
         assertEquals(input, tok.getContent()); 
          
         tok = new StrTokenizer(); 
         assertEquals(null, tok.getContent()); 
     } 
  
     //----------------------------------------------------------------------- 

@Test 
     public void testGetContent10577() { 
         final String input = "a   b c \"d e\" f "; 
         StrTokenizer tok = new StrTokenizer(input); 
         assertEquals(input, tok.getContent()); 
  
         tok = new StrTokenizer(input.toCharArray()); 
         assertEquals(input, tok.getContent()); 
          
         tok = new StrTokenizer(); 
         assertEquals(null, tok.getContent()); 
     } 
  
     //----------------------------------------------------------------------- 

@Test 
     public void testGetContent10578() { 
         final String input = "a   b c \"d e\" f "; 
         StrTokenizer tok = new StrTokenizer(input); 
         assertEquals(input, tok.getContent()); 
  
         tok = new StrTokenizer(input.toCharArray()); 
         assertEquals(input, tok.getContent()); 
          
         tok = new StrTokenizer(); 
         assertEquals(null, tok.getContent()); 
          
         tok = new StrTokenizer(); 
         assertEquals(null, tok.getContent()); 
          
         tok = new StrTokenizer(); 
         assertEquals(input, tok.getContent()); 
          
         tok = new StrTokenizer(); 
         assertEquals(input, tok.getContent()); 
          
         tok = new StrTokenizer(); 
         assertEquals(null, tok.getContent()); 
          
         tok = new StrTokenizer(); 
         assertEquals(input, tok.getContent()); 
          
         tok = new StrTokenizer(); 
         assertEquals(input, tok.getContent()); 
          
         tok = new StrTokenizer(); 
         assertEquals(null, tok.getContent()); 
     } 
  
     //----------------------------------------------------------------------- 

@Test 
     public void testBasicIgnoreTrimmed110579() { 
         final String input = "a: bIGNOREc : "; 
         final StrTokenizer tok = new StrTokenizer(input, ':'); 
         tok.setIgnoredMatcher(StrMatcher.stringMatcher("IGNORE")); 
         tok.setTrimmerMatcher(StrMatcher.trimMatcher()); 
         tok.setIgnoreEmptyTokens(false); 
         tok.setEmptyTokenAsNull(true); 
         assertEquals("a", tok.next()); 
         assertEquals("bc", tok.next()); 
         assertFalse(tok.hasNext()); 
     } 
  

@Test 
     public void testChaining10580() { 
         final String input = "a   b c \"d e\" f "; 
         StrTokenizer tok = new StrTokenizer(input); 
         assertEquals(Arrays.asList(tok.getTokenArray()), tok.getTokenList()); 
          
         tok = new StrTokenizer(input.toCharArray()); 
         assertEquals(Arrays.asList(tok.getTokenArray()), tok.getTokenList()); 
          
         tok = new StrTokenizer(input.toCharArray()); 
         assertEquals(Arrays.asList(tok.getTokenArray()), tok.getTokenList()); 
          
         tok = new StrTokenizer(input.toCharArray()); 
         assertEquals(Arrays.asList(tok.getTokenArray()), tok.getTokenList()); 
          
         tok = new StrTokenizer(input.toCharArray()); 
         assertEquals(Arrays.asList(tok.getTokenArray()), tok.getTokenList()); 
          
         tok = new StrTokenizer(null); 
         assertEquals(null, tok.getTokenArray()); 
     } 
  
     //----------------------------------------------------------------------- 

@Test 
     public void testGetContent10581() { 
         final String input = "a   b c \"d e\" f "; 
         StrTokenizer tok = new StrTokenizer(input); 
         assertEquals(input, tok.getContent()); 
          
         tok = new StrTokenizer(input.toCharArray()); 
         assertEquals(input, tok.getContent()); 
          
         tok = new StrTokenizer(); 
         assertEquals(null, tok.getContent()); 
          
         tok = new StrTokenizer(); 
         assertEquals(null, tok.getContent()); 
          
         tok = new StrTokenizer(); 
         assertEquals(input, tok.getContent()); 
          
         tok = new StrTokenizer(); 
         assertEquals(input, tok.getContent()); 
          
         tok = new StrTokenizer(); 
         assertEquals(null, tok.getContent()); 
     } 
  
     //----------------------------------------------------------------------- 

@Test 
     public void testGetContent10582() { 
         final String input = "a   b c \"d e\" f "; 
         StrTokenizer tok = new StrTokenizer(input); 
         assertEquals(input, tok.getContent()); 
  
         tok = new StrTokenizer(input.toCharArray()); 
         assertEquals(input, tok.getContent()); 
          
         tok = new StrTokenizer(); 
         assertEquals(null, tok.getContent()); 
     } 
  
     //----------------------------------------------------------------------- 

@Test 
     public void test510583() { 
  
         final String input = "a;b; c;\"d;\"\"e\";f; ; ;"; 
         final StrTokenizer tok = new StrTokenizer(input); 
         tok.setDelimiterChar(';'); 
         tok.setQuoteChar('"'); 
         tok.setIgnoredMatcher(StrMatcher.trimMatcher()); 
         tok.setIgnoreEmptyTokens(false); 
         tok.setEmptyTokenAsNull(true); 
         final String tokens[] = tok.getTokenArray(); 
  
         final String expected[] = new String[]{"a", "b", "c", "d;\"e", "f", null, null, null,}; 
  
         assertEquals(ArrayUtils.toString(tokens), expected.length, tokens.length); 
         for (int i = 0; i < expected.length; i++) { 
             assertTrue("token[" + i + "] was '" + tokens[i] + "' but was expected to be '" + expected[i] + "'", 
                     ObjectUtils.equals(expected[i], tokens[i])); 
         } 
  
     } 
  

@Test 
     public void testGetContent10584() { 
         final String input = "a   b c \"d e\" f "; 
         StrTokenizer tok = new StrTokenizer(input); 
         assertEquals(input, tok.getContent()); 
  
         tok = new StrTokenizer(input.toCharArray()); 
         assertEquals(input, tok.getContent()); 
          
         tok = new StrTokenizer(); 
         assertEquals(null, tok.getContent()); 
     } 
  
     //----------------------------------------------------------------------- 

@Test 
     public void test510585() { 
  
         final String input = "a;b; c;\"d;\"\"e\";f; ; ;"; 
         final StrTokenizer tok = new StrTokenizer(input); 
         tok.setDelimiterChar(';'); 
         tok.setQuoteChar('"'); 
         tok.setIgnoredMatcher(StrMatcher.trimMatcher()); 
         tok.setIgnoreEmptyTokens(false); 
         tok.setEmptyTokenAsNull(true); 
         final String tokens[] = tok.getTokenArray(); 
  
         final String expected[] = new String[]{"a", "b", "c", "d;\"e", "f", null, null, null,}; 
  
         assertEquals(ArrayUtils.toString(tokens), expected.length, tokens.length); 
         for (int i = 0; i < expected.length; i++) { 
             assertTrue("token[" + i + "] was '" + tokens[i] + "' but was expected to be '" + expected[i] + "'", 
                     ObjectUtils.equals(expected[i], tokens[i])); 
         } 
  
     } 
  

@Test 
     public void testChaining10586() { 
         final String input = "a   b c \"d e\" f "; 
         StrTokenizer tok = new StrTokenizer(input); 
         assertEquals(Arrays.asList(tok.getTokenArray()), tok.getTokenList()); 
          
         tok = new StrTokenizer(input.toCharArray()); 
         assertEquals(Arrays.asList(tok.getTokenArray()), tok.getTokenList()); 
          
         tok = new StrTokenizer(input.toCharArray()); 
         assertEquals(Arrays.asList(tok.getTokenArray()), tok.getTokenList()); 
          
         tok = new StrTokenizer(input.toCharArray()); 
         assertEquals(Arrays.asList(tok.getTokenArray()), tok.getTokenList()); 
          
         tok = new StrTokenizer(input.toCharArray()); 
         assertEquals(Arrays.asList(tok.getTokenArray()), tok.getTokenList()); 
          
         tok = new StrTokenizer(input.toCharArray()); 
         assertEquals(Arrays.asList(tok.getTokenArray()), tok.getTokenList()); 
     } 
  
     //----------------------------------------------------------------------- 

@Test 
     public void testGetContent10587() { 
         final String input = "a   b c \"d e\" f "; 
         StrTokenizer tok = new StrTokenizer(input); 
         assertEquals(input, tok.getContent()); 
          
         tok = new StrTokenizer(input.toCharArray()); 
         assertEquals(input, tok.getContent()); 
          
         tok = new StrTokenizer(); 
         assertEquals(null, tok.getContent()); 
          
         tok = new StrTokenizer(); 
         assertEquals(null, tok.getContent()); 
          
         tok = new StrTokenizer(); 
         assertEquals(input, tok.getContent()); 
          
         tok = new StrTokenizer(); 
         assertEquals(input, tok.getContent()); 
          
         tok = new StrTokenizer(); 
         assertEquals(null, tok.getContent()); 
          
         tok = new StrTokenizer(); 
         assertEquals(input, tok.getContent()); 
          
         tok = new StrTokenizer(); 
         assertEquals(input, tok.getContent()); 
          
         tok = new StrTokenizer(); 
         assertEquals(null, tok.getContent()); 
     } 
  
     //----------------------------------------------------------------------- 

@Test 
     public void test510588() { 
  
         final String input = "a   b c \"d e\" f "; 
         final StrTokenizer tok = new StrTokenizer(input); 
         tok.setDelimiterChar(';'); 
         tok.setQuoteChar('"'); 
         tok.setIgnoredMatcher(StrMatcher.trimMatcher()); 
         tok.setIgnoreEmptyTokens(false); 
         tok.setEmptyTokenAsNull(true); 
         final String tokens[] = tok.getTokenArray(); 
         final String expected[] = new String[]{"a", "b", "c", "d", "e", "f"}; 
  
         assertEquals(ArrayUtils.toString(tokens), expected.length, tokens.length); 
         for (int i = 0; i < expected.length; i++) { 
             assertTrue("token[" + i + "] was '" + tokens[i] + "' but was expected to be '" + expected[i] + "'", 
                     ObjectUtils.equals(expected[i], tokens[i])); 
         } 
  
     } 
  

@Test 
     public void testListArray10589() { 
         final String input = "a  b c"; 
         final StrTokenizer tok = new StrTokenizer(input); 
         final String[] array = tok.getTokenArray(); 
         final List<?> list = tok.getTokenList(); 
          
         assertEquals(Arrays.asList(array), list); 
         assertEquals(3, list.size()); 
     } 
  
     //----------------------------------------------------------------------- 

@Test 
     public void testListArray10590() { 
         final String input = "a  b c"; 
         final StrTokenizer tok = new StrTokenizer(input); 
         final String[] array = tok.getTokenArray(); 
         final List<?> list = tok.getTokenList(); 
          
         assertEquals(Arrays.asList(array), list); 
         assertEquals(3, list.size()); 
     } 
  
     //----------------------------------------------------------------------- 

@Test 
     public void testBasicIgnoreTrimmed110591() { 
         final String input = "a: bIGNOREc : "; 
         final StrTokenizer tok = new StrTokenizer(input, ':'); 
         tok.setIgnoredMatcher(StrMatcher.stringMatcher("IGNORE")); 
         tok.setTrimmerMatcher(StrMatcher.trimMatcher()); 
         tok.setIgnoreEmptyTokens(false); 
         tok.setEmptyTokenAsNull(true); 
         assertEquals("a", tok.next()); 
         assertEquals("bc", tok.next()); 
         assertFalse(tok.hasNext()); 
     } 
  

@Test 
     public void testChaining10592() { 
         final String input = "a   b c \"d e\" f "; 
         StrTokenizer tok = new StrTokenizer(input); 
         assertEquals(Arrays.asList(tok.getTokenArray()), tok.getTokenList()); 
          
         tok = new StrTokenizer(input.toCharArray()); 
         assertEquals(Arrays.asList(tok.getTokenArray()), tok.getTokenList()); 
          
         tok = new StrTokenizer(input.toCharArray()); 
         assertEquals(Arrays.asList(tok.getTokenArray()), tok.getTokenList()); 
          
         tok = new StrTokenizer(input.toCharArray()); 
         assertEquals(Arrays.asList(tok.getTokenArray()), tok.getTokenList()); 
          
         tok = new StrTokenizer(input.toCharArray()); 
         assertEquals(Arrays.asList(tok.getTokenArray()), tok.getTokenList()); 
     } 
  
     //----------------------------------------------------------------------- 

@Test 
     public void test510593() { 
  
         final String input = "a;b; c;\"d;\"\"e\";f; ; ;"; 
         final StrTokenizer tok = new StrTokenizer(input); 
         tok.setDelimiterChar(';'); 
         tok.setQuoteChar('"'); 
         tok.setIgnoredMatcher(StrMatcher.trimMatcher()); 
         tok.setIgnoreEmptyTokens(false); 
         tok.setEmptyTokenAsNull(true); 
         final String tokens[] = tok.getTokenArray(); 
  
         final String expected[] = new String[]{"a", "b", "c", "d;\"e", "f", null, null, null,}; 
  
         assertEquals(ArrayUtils.toString(tokens), expected.length, tokens.length); 
         for (int i = 0; i < expected.length; i++) { 
             assertTrue("token[" + i + "] was '" + tokens[i] + "' but was expected to be '" + expected[i] + "'", 
                     ObjectUtils.equals(expected[i], tokens[i])); 
         } 
  
     } 
  

@Test 
     public void testGetContent10594() { 
         final String input = "a   b c \"d e\" f "; 
         StrTokenizer tok = new StrTokenizer(input); 
         assertEquals(input, tok.getContent()); 
  
         tok = new StrTokenizer(input.toCharArray()); 
         assertEquals(input, tok.getContent()); 
          
         tok = new StrTokenizer(); 
         assertEquals(null, tok.getContent()); 
     } 
  
     //----------------------------------------------------------------------- 

@Test 
     public void testGetTokenArray10595() { 
         final String input = "a   b c \"d e\" f "; 
         StrTokenizer tok = new StrTokenizer(input); 
         assertEquals(Arrays.asList(tok.getTokenArray()), tok.getTokenArray()); 
          
         tok = new StrTokenizer(input.toCharArray()); 
         assertEquals(Arrays.asList(tok.getTokenArray()), tok.getTokenArray()); 
          
         tok = new StrTokenizer(input.toCharArray()); 
         assertEquals(Arrays.asList(tok.getTokenArray()), tok.getTokenArray()); 
          
         tok = new StrTokenizer(input.toCharArray()); 
         assertEquals(Arrays.asList(tok.getTokenArray()), tok.getTokenArray()); 
          
         tok = new StrTokenizer(input.toCharArray()); 
         assertEquals(Arrays.asList(tok.getTokenArray()), tok.getTokenArray()); 
          
         tok = new StrTokenizer(null); 
         assertEquals(null, tok.getTokenArray()); 
     } 
  
     //----------------------------------------------------------------------- 

@Test 
     public void test510596() { 
  
         final String input = "a;b; c;\"d;\"\"e\";f; ; ;"; 
         final StrTokenizer tok = new StrTokenizer(input); 
         tok.setDelimiterChar(';'); 
         tok.setQuoteChar('"'); 
         tok.setIgnoredMatcher(StrMatcher.trimMatcher()); 
         tok.setIgnoreEmptyTokens(false); 
         tok.setEmptyTokenAsNull(true); 
         final String tokens[] = tok.getTokenArray(); 
  
         final String expected[] = new String[]{"a", "b", "c", "d;\"e", "f", null, null, null,}; 
  
         assertEquals(ArrayUtils.toString(tokens), expected.length, tokens.length); 
         for (int i = 0; i < expected.length; i++) { 
             assertTrue("token[" + i + "] was '" + tokens[i] + "' but was expected to be '" + expected[i] + "'", 
                     ObjectUtils.equals(expected[i], tokens[i])); 
         } 
  
     } 
  

@Test 
     public void testGetTokenArray10597() { 
         final String input = "a   b c \"d e\" f "; 
         StrTokenizer tok = new StrTokenizer(input); 
         assertEquals(Arrays.asList(tok.getTokenArray()), tok.getTokenList()); 
          
         tok = new StrTokenizer(input.toCharArray()); 
         assertEquals(Arrays.asList(tok.getTokenArray()), tok.getTokenList()); 
          
         tok = new StrTokenizer(input.toCharArray()); 
         assertEquals(Arrays.asList(tok.getTokenArray()), tok.getTokenList()); 
          
         tok = new StrTokenizer(input.toCharArray()); 
         assertEquals(Arrays.asList(tok.getTokenArray()), tok.getTokenList()); 
          
         tok = new StrTokenizer(input.toCharArray()); 
         assertEquals(Arrays.asList(tok.getTokenArray()), tok.getTokenList()); 
          
         tok = new StrTokenizer(null); 
         assertEquals(null, tok.getTokenArray()); 
     } 
  
     //----------------------------------------------------------------------- 

@Test 
     public void testChaining10598() { 
         final StrTokenizer tok = new StrTokenizer(); 
         assertEquals(tok, tok.reset()); 
         assertEquals(tok, tok.reset("")); 
         assertEquals(tok, tok.setDelimiterMatcher(null)); 
         assertEquals(tok, tok.setQuoteMatcher(null)); 
         assertEquals(tok, tok.setIgnoredMatcher(null)); 
         assertEquals(tok, tok.setTrimmerMatcher(null)); 
         assertEquals(tok, tok.setIgnoreEmptyTokens(false)); 
         assertEquals(tok, tok.setEmptyTokenAsNull(true)); 
         assertEquals(tok, tok.setIgnoreEmptyTokens(false)); 
         assertEquals(tok, tok.setIgnoreEmptyTokens(true)); 
     } 
  
     //----------------------------------------------------------------------- 

@Test 
     public void testGetContent10599() { 
         final String input = "a   b c \"d e\" f "; 
         StrTokenizer tok = new StrTokenizer(input); 
         assertEquals(input, tok.getContent()); 
  
         tok = new StrTokenizer(input.toCharArray()); 
         assertEquals(input, tok.getContent()); 
          
         tok = new StrTokenizer(); 
         assertEquals(null, tok.getContent()); 
     } 
  
     //----------------------------------------------------------------------- 

@Test 
     public void test510600() { 
  
         final String input = "a;b; c;\"d;\"\"e\";f; ; ;"; 
         final StrTokenizer tok = new StrTokenizer(input); 
         tok.setDelimiterChar(';'); 
         tok.setQuoteChar('"'); 
         tok.setIgnoredMatcher(StrMatcher.trimMatcher()); 
         tok.setIgnoreEmptyTokens(false); 
         tok.setEmptyTokenAsNull(true); 
         final String tokens[] = tok.getTokenArray(); 
  
         final String expected[] = new String[]{"a", "b", "c", "d;\"e", "f", null, null, null,}; 
  
         assertEquals(ArrayUtils.toString(tokens), expected.length, tokens.length); 
         for (int i = 0; i < expected.length; i++) { 
             assertTrue("token[" + i + "] was '" + tokens[i] + "' but was expected to be '" + expected[i] + "'", 
                     ObjectUtils.equals(expected[i], tokens[i])); 
         } 
  
     } 
  

@Test 
     public void test510601() { 
  
         final String input = "a;b; c;\"d;\"\"e\";f; ; ;"; 
         final StrTokenizer tok = new StrTokenizer(input); 
         tok.setDelimiterChar(';'); 
         tok.setQuoteChar('"'); 
         tok.setIgnoredMatcher(StrMatcher.trimMatcher()); 
         tok.setIgnoreEmptyTokens(false); 
         tok.setEmptyTokenAsNull(true); 
         final String tokens[] = tok.getTokenArray(); 
  
         final String expected[] = new String[]{"a", "b", "c", "d;\"e", "f", null, null, null,}; 
  
         assertEquals(ArrayUtils.toString(tokens), expected.length, tokens.length); 
         for (int i = 0; i < expected.length; i++) { 
             assertTrue("token[" + i + "] was '" + tokens[i] + "' but was expected to be '" + expected[i] + "'", 
                     ObjectUtils.equals(expected[i], tokens[i])); 
         } 
  
     } 
  

@Test 
     public void test510602() { 
  
         final String input = "a;b; c;\"d;\"\"e\";f; ; ;"; 
         final StrTokenizer tok = new StrTokenizer(input); 
         tok.setDelimiterChar(';'); 
         tok.setQuoteChar('"'); 
         tok.setIgnoredMatcher(StrMatcher.trimMatcher()); 
         tok.setIgnoreEmptyTokens(false); 
         tok.setEmptyTokenAsNull(true); 
         final String tokens[] = tok.getTokenArray(); 
  
         final String expected[] = new String[]{"a", "b", "c", "d;\"e", "f", null, null, null,}; 
  
         assertEquals(ArrayUtils.toString(tokens), expected.length, tokens.length); 
         for (int i = 0; i < expected.length; i++) { 
             assertTrue("token[" + i + "] was '" + tokens[i] + "' but was expected to be '" + expected[i] + "'", 
                     ObjectUtils.equals(expected[i], tokens[i])); 
         } 
  
     } 
  

@Test 
     public void testGetContent10603() { 
         final String input = "a   b c \"d e\" f "; 
         StrTokenizer tok = new StrTokenizer(input); 
         assertEquals(input, tok.getContent()); 
          
         tok = new StrTokenizer(input.toCharArray()); 
         assertEquals(input, tok.getContent()); 
          
         tok = new StrTokenizer(); 
         assertEquals(null, tok.getContent()); 
          
         tok = new StrTokenizer(); 
         assertEquals(null, tok.getContent()); 
          
         tok = new StrTokenizer(); 
         assertEquals(input, tok.getContent()); 
          
         tok = new StrTokenizer(); 
         assertEquals(null, tok.getContent()); 
          
         tok = new StrTokenizer(); 
         assertEquals("a", tok.getContent()); 
          
         tok = new StrTokenizer(); 
         assertEquals("b", tok.getContent()); 
         tok = new StrTokenizer(); 
         assertEquals("c", tok.getContent()); 
          
         tok = new StrTokenizer(); 
         assertEquals("d", tok.getContent()); 
          
         tok = new StrTokenizer(); 
         assertEquals("e", tok.getContent()); 
          
         tok = new StrTokenizer(); 
         assertEquals("f", tok.getContent()); 
          
         tok = new StrTokenizer(); 
         assertEquals("g", tok.getContent()); 
          
         tok = new StrTokenizer(); 
         assertEquals("h", tok.getContent()); 
     } 
  
     //----------------------------------------------------------------------- 

@Test 
     public void testChaining10604() { 
         final String input = "a   b c \"d e\" f "; 
         StrTokenizer tok = new StrTokenizer(input); 
         assertEquals(Arrays.asList(tok.getTokenArray()), tok.getTokenList()); 
          
         tok = new StrTokenizer(input.toCharArray()); 
         assertEquals(Arrays.asList(tok.getTokenArray()), tok.getTokenList()); 
          
         tok = new StrTokenizer(input.toCharArray()); 
         assertEquals(Arrays.asList(tok.getTokenArray()), tok.getTokenList()); 
          
         tok = new StrTokenizer(input.toCharArray()); 
         assertEquals(Arrays.asList(tok.getTokenArray()), tok.getTokenList()); 
          
         tok = new StrTokenizer(input.toCharArray()); 
         assertEquals(Arrays.asList(tok.getTokenArray()), tok.getTokenList()); 
     } 
  
     //----------------------------------------------------------------------- 

@Test 
     public void test510605() { 
  
         final String input = "a;b; c;\"d;\"\"e\";f; ; ;"; 
         final StrTokenizer tok = new StrTokenizer(input); 
         tok.setDelimiterChar(';'); 
         tok.setQuoteChar('"'); 
         tok.setIgnoredMatcher(StrMatcher.trimMatcher()); 
         tok.setIgnoreEmptyTokens(false); 
         tok.setEmptyTokenAsNull(true); 
         final String tokens[] = tok.getTokenArray(); 
  
         final String expected[] = new String[]{"a", "b", "c", "d;\"e", "f", null, null, null,}; 
  
         assertEquals(ArrayUtils.toString(tokens), expected.length, tokens.length); 
         for (int i = 0; i < expected.length; i++) { 
             assertTrue("token[" + i + "] was '" + tokens[i] + "' but was expected to be '" + expected[i] + "'", 
                     ObjectUtils.equals(expected[i], tokens[i])); 
         } 
  
     } 
  

@Test 
     public void testGetContent10606() { 
         final String input = "a   b c \"d e\" f "; 
         StrTokenizer tok = new StrTokenizer(input); 
         assertEquals(input, tok.getContent()); 
          
         tok = new StrTokenizer(input.toCharArray()); 
         assertEquals(input, tok.getContent()); 
          
         tok = new StrTokenizer(); 
         assertEquals(null, tok.getContent()); 
          
         tok = new StrTokenizer(); 
         assertEquals(null, tok.getContent()); 
          
         tok = new StrTokenizer(); 
         assertEquals(input, tok.getContent()); 
          
         tok = new StrTokenizer(); 
         assertEquals(input, tok.getContent()); 
          
         tok = new StrTokenizer(); 
         assertEquals(null, tok.getContent()); 
     } 
  
     //----------------------------------------------------------------------- 

@Test 
     public void test510607() { 
  
         final String input = "a;b; c;\"d;\"\"e\";f; ; ;"; 
         final StrTokenizer tok = new StrTokenizer(input); 
         tok.setDelimiterChar(';'); 
         tok.setQuoteChar('"'); 
         tok.setIgnoredMatcher(StrMatcher.trimMatcher()); 
         tok.setIgnoreEmptyTokens(false); 
         tok.setEmptyTokenAsNull(true); 
         final String tokens[] = tok.getTokenArray(); 
  
         final String expected[] = new String[]{"a", "b", "c", "d;\"e", "f", null, null, null,}; 
  
         assertEquals(ArrayUtils.toString(tokens), expected.length, tokens.length); 
         for (int i = 0; i < expected.length; i++) { 
             assertTrue("token[" + i + "] was '" + tokens[i] + "' but was expected to be '" + expected[i] + "'", 
                     ObjectUtils.equals(expected[i], tokens[i])); 
         } 
  
     } 
  

@Test 
     public void testListArray10608() { 
         final String input = "a  b c"; 
         final StrTokenizer tok = new StrTokenizer(input); 
         final String[] array = tok.getTokenArray(); 
         final List<?> list = tok.getTokenList(); 
          
         assertEquals(Arrays.asList(array), list); 
         assertEquals(3, list.size()); 
     } 
  
     //----------------------------------------------------------------------- 

@Test 
     public void test510609() { 
  
         final String input = "a;b; c;\"d;\"\"e\";f; ; ;"; 
         final StrTokenizer tok = new StrTokenizer(input); 
         tok.setDelimiterChar(';'); 
         tok.setQuoteChar('"'); 
         tok.setIgnoredMatcher(StrMatcher.trimMatcher()); 
         tok.setIgnoreEmptyTokens(false); 
         tok.setEmptyTokenAsNull(true); 
         final String tokens[] = tok.getTokenArray(); 
  
         final String expected[] = new String[]{"a", "b", "c", "d;\"e", "f", null, null, null,}; 
  
         assertEquals(ArrayUtils.toString(tokens), expected.length, tokens.length); 
         for (int i = 0; i < expected.length; i++) { 
             assertTrue("token[" + i + "] was '" + tokens[i] + "' but was expected to be '" + expected[i] + "'", 
                     ObjectUtils.equals(expected[i], tokens[i])); 
         } 
  
     } 
  

@Test 
     public void test510610() { 
  
         final String input = "a   b c \"d e\" f "; 
         final StrTokenizer tok = new StrTokenizer(input); 
         tok.setDelimiterChar(';'); 
         tok.setQuoteChar('"'); 
         tok.setIgnoredMatcher(StrMatcher.trimMatcher()); 
         tok.setIgnoreEmptyTokens(false); 
         tok.setEmptyTokenAsNull(true); 
         final String tokens[] = tok.getTokenArray(); 
         final String expected[] = new String[]{"a", "b", "c", "d", "e", "f"}; 
  
         assertEquals(ArrayUtils.toString(tokens), expected.length, tokens.length); 
         for (int i = 0; i < expected.length; i++) { 
             assertTrue("token[" + i + "] was '" + tokens[i] + "' but was expected to be '" + expected[i] + "'", 
                     ObjectUtils.equals(expected[i], tokens[i])); 
         } 
  
     } 
  

@Test 
     public void test510611() { 
  
         final String input = "a;b; c;\"d;\"\"e\";f; ; ;"; 
         final StrTokenizer tok = new StrTokenizer(input); 
         tok.setDelimiterChar(';'); 
         tok.setQuoteChar('"'); 
         tok.setIgnoredMatcher(StrMatcher.trimMatcher()); 
         tok.setIgnoreEmptyTokens(false); 
         tok.setEmptyTokenAsNull(true); 
         final String tokens[] = tok.getTokenArray(); 
  
         final String expected[] = new String[]{"a", "b", "c", "d;\"e", "f", null, null, null,}; 
  
         assertEquals(ArrayUtils.toString(tokens), expected.length, tokens.length); 
         for (int i = 0; i < expected.length; i++) { 
             assertTrue("token[" + i + "] was '" + tokens[i] + "' but was expected to be '" + expected[i] + "'", 
                     ObjectUtils.equals(expected[i], tokens[i])); 
         } 
  
     } 
  

@Test 
     public void test510612() { 
  
         final String input = "a: bIGNOREc : "; 
         final StrTokenizer tok = new StrTokenizer(input); 
         tok.setDelimiterChar(';'); 
         tok.setQuoteChar('"'); 
         tok.setIgnoredMatcher(StrMatcher.stringMatcher("IGNORE")); 
         tok.setIgnoreEmptyTokens(false); 
         tok.setEmptyTokenAsNull(true); 
         assertEquals("a", tok.next()); 
         assertEquals("bc", tok.next()); 
         assertFalse(tok.hasNext()); 
     } 
  

@Test 
     public void test510613() { 
  
         final String input = "a;b; c;\"d;\"\"e\";f; ; ;"; 
         final StrTokenizer tok = new StrTokenizer(input); 
         tok.setDelimiterChar(';'); 
         tok.setQuoteChar('"'); 
         tok.setIgnoredMatcher(StrMatcher.trimMatcher()); 
         tok.setIgnoreEmptyTokens(false); 
         tok.setEmptyTokenAsNull(true); 
         final String tokens[] = tok.getTokenArray(); 
  
         final String expected[] = new String[]{"a", "b", "c", "d;\"e", "f", null, null, null,}; 
  
         assertEquals(ArrayUtils.toString(tokens), expected.length, tokens.length); 
         for (int i = 0; i < expected.length; i++) { 
             assertTrue("token[" + i + "] was '" + tokens[i] + "' but was expected to be '" + expected[i] + "'", 
                     ObjectUtils.equals(expected[i], tokens[i])); 
         } 
  
     } 
  

@Test 
     public void testGetContent10614() { 
         final String input = "a   b c \"d e\" f "; 
         StrTokenizer tok = new StrTokenizer(input); 
         assertEquals(input, tok.getContent()); 
          
         tok = new StrTokenizer(input.toCharArray()); 
         assertEquals(input, tok.getContent()); 
          
         tok = new StrTokenizer(); 
         assertEquals(null, tok.getContent()); 
          
         tok = new StrTokenizer(); 
         assertEquals(null, tok.getContent()); 
          
         tok = new StrTokenizer(); 
         assertEquals(input, tok.getContent()); 
          
         tok = new StrTokenizer(); 
         assertEquals(input, tok.getContent()); 
          
         tok = new StrTokenizer(); 
         assertEquals(null, tok.getContent()); 
     } 
  
     //----------------------------------------------------------------------- 

@Test 
     public void testListArray10615() { 
         final String input = "a  b c"; 
         final StrTokenizer tok = new StrTokenizer(input); 
         final String[] array = tok.getTokenArray(); 
         final List<?> list = tok.getTokenList(); 
          
         assertEquals(Arrays.asList(array), list); 
         assertEquals(3, list.size()); 
     } 
  
     //----------------------------------------------------------------------- 

@Test 
     public void testBasicIgnoreTrimmed110616() { 
         final String input = "a: bIGNOREc : "; 
         final StrTokenizer tok = new StrTokenizer(input, ':'); 
         tok.setIgnoredMatcher(StrMatcher.stringMatcher("IGNORE")); 
         tok.setTrimmerMatcher(StrMatcher.trimMatcher()); 
         tok.setIgnoreEmptyTokens(false); 
         tok.setEmptyTokenAsNull(true); 
         assertEquals("a", tok.next()); 
         assertEquals("bc", tok.next()); 
         assertEquals(null, tok.next()); 
         assertFalse(tok.hasNext()); 
     } 
  

@Test 
     public void testChaining10617() { 
         final StrTokenizer tkn = new StrTokenizer("a b c"); 
         assertFalse(tkn.hasPrevious()); 
         try { 
             tkn.previous(); 
             fail(); 
         } catch (final NoSuchElementException ex) {} 
         assertTrue(tkn.hasNext()); 
          
         assertEquals("a", tkn.next()); 
         try { 
             tkn.remove(); 
             fail(); 
         } catch (final UnsupportedOperationException ex) {} 
         try { 
             tkn.set("x"); 
             fail(); 
         } catch (final UnsupportedOperationException ex) {} 
         try { 
             tkn.add("y"); 
             fail(); 
         } catch (final UnsupportedOperationException ex) {} 
         assertTrue(tkn.hasPrevious()); 
         assertTrue(tkn.hasNext()); 
          
         assertEquals("b", tkn.next()); 
         assertTrue(tkn.hasPrevious()); 
         assertTrue(tkn.hasNext()); 
          
         assertEquals("c", tkn.next()); 
         assertTrue(tkn.hasPrevious()); 
         assertTrue(tkn.hasNext()); 
          
         assertEquals("d", tkn.next()); 
         assertTrue(tkn.hasPrevious()); 
         assertFalse(tkn.hasNext()); 
          
         try { 
             tkn.next(); 
             fail(); 
         } catch (final NoSuchElementException ex) {} 
         assertTrue(tkn.hasPrevious()); 
         assertFalse(tkn.hasNext()); 
     } 
  
     //----------------------------------------------------------------------- 

@Test 
     public void testGetTokenArray10618() { 
         final String input = "a   b c \"d e\" f "; 
         StrTokenizer tok = new StrTokenizer(input); 
         assertEquals(Arrays.asList(tok.getTokenArray()), tok.getTokenArray()); 
          
         tok = new StrTokenizer(input.toCharArray()); 
         assertEquals(Arrays.asList(tok.getTokenArray()), tok.getTokenArray()); 
          
         tok = new StrTokenizer(input.toCharArray()); 
         assertEquals(Arrays.asList(tok.getTokenArray()), tok.getTokenArray()); 
          
         tok = new StrTokenizer(input.toCharArray()); 
         assertEquals(Arrays.asList(tok.getTokenArray()), tok.getTokenArray()); 
          
         tok = new StrTokenizer(input.toCharArray()); 
         assertEquals(Arrays.asList(tok.getTokenArray()), tok.getTokenArray()); 
          
         tok = new StrTokenizer(null); 
         assertEquals(null, tok.getTokenArray()); 
     } 
  
     //----------------------------------------------------------------------- 

@Test 
     public void test510619() { 
  
         final String input = "a;b; c;\"d;\"\"e\";f; ; ;"; 
         final StrTokenizer tok = new StrTokenizer(input); 
         tok.setDelimiterChar(';'); 
         tok.setQuoteChar('"'); 
         tok.setIgnoredMatcher(StrMatcher.trimMatcher()); 
         tok.setIgnoreEmptyTokens(false); 
         tok.setEmptyTokenAsNull(true); 
         final String tokens[] = tok.getTokenArray(); 
  
         final String expected[] = new String[]{"a", "b", "c", "d;\"e", "f", null, null, null,}; 
  
         assertEquals(ArrayUtils.toString(tokens), expected.length, tokens.length); 
         for (int i = 0; i < expected.length; i++) { 
             assertTrue("token[" + i + "] was '" + tokens[i] + "' but was expected to be '" + expected[i] + "'", 
                     ObjectUtils.equals(expected[i], tokens[i])); 
         } 
  
     } 
  

@Test 
     public void testGetContent10620() { 
         final String input = "a   b c \"d e\" f "; 
         StrTokenizer tok = new StrTokenizer(input); 
         assertEquals(input, tok.getContent()); 
          
         tok = new StrTokenizer(input.toCharArray()); 
         assertEquals(input, tok.getContent()); 
          
         tok = new StrTokenizer(); 
         assertEquals(null, tok.getContent()); 
          
         tok = new StrTokenizer(); 
         assertEquals(null, tok.getContent()); 
          
         tok = new StrTokenizer(); 
         assertEquals(input, tok.getContent()); 
          
         tok = new StrTokenizer(); 
         assertEquals(input, tok.getContent()); 
          
         tok = new StrTokenizer(); 
         assertEquals(null, tok.getContent()); 
     } 
  
     //----------------------------------------------------------------------- 

@Test 
     public void test510621() { 
  
         final String input = "a;b; c;\"d;\"\"e\";f; ; ;"; 
         final StrTokenizer tok = new StrTokenizer(input); 
         tok.setDelimiterChar(';'); 
         tok.setQuoteChar('"'); 
         tok.setIgnoredMatcher(StrMatcher.trimMatcher()); 
         tok.setIgnoreEmptyTokens(false); 
         tok.setEmptyTokenAsNull(true); 
         final String tokens[] = tok.getTokenArray(); 
  
         final String expected[] = new String[]{"a", "b", "c", "d;\"e", "f", null, null, null,}; 
  
         assertEquals(ArrayUtils.toString(tokens), expected.length, tokens.length); 
         for (int i = 0; i < expected.length; i++) { 
             assertTrue("token[" + i + "] was '" + tokens[i] + "' but was expected to be '" + expected[i] + "'", 
                     ObjectUtils.equals(expected[i], tokens[i])); 
         } 
  
     } 
  

@Test 
     public void testGetContent10622() { 
         final String input = "a   b c \"d e\" f "; 
         StrTokenizer tok = new StrTokenizer(input); 
         assertEquals(input, tok.getContent()); 
  
         tok = new StrTokenizer(input.toCharArray()); 
         assertEquals(input, tok.getContent()); 
          
         tok = new StrTokenizer(); 
         assertEquals(null, tok.getContent()); 
     } 
  
     //----------------------------------------------------------------------- 

@Test 
     public void test510623() { 
  
         final String input = "a;b; c;\"d;\"\"e\";f; ; ;"; 
         final StrTokenizer tok = new StrTokenizer(input); 
         tok.setDelimiterChar(';'); 
         tok.setQuoteChar('"'); 
         tok.setIgnoredMatcher(StrMatcher.trimMatcher()); 
         tok.setIgnoreEmptyTokens(false); 
         tok.setEmptyTokenAsNull(true); 
         final String tokens[] = tok.getTokenArray(); 
  
         final String expected[] = new String[]{"a", "b", "c", "d;\"e", "f", null, null, null,}; 
  
         assertEquals(ArrayUtils.toString(tokens), expected.length, tokens.length); 
         for (int i = 0; i < expected.length; i++) { 
             assertTrue("token[" + i + "] was '" + tokens[i] + "' but was expected to be '" + expected[i] + "'", 
                     ObjectUtils.equals(expected[i], tokens[i])); 
         } 
  
     } 
  

@Test 
     public void testGetContent10624() { 
         final String input = "a   b c \"d e\" f "; 
         StrTokenizer tok = new StrTokenizer(input); 
         assertEquals(input, tok.getContent()); 
  
         tok = new StrTokenizer(input.toCharArray()); 
         assertEquals(input, tok.getContent()); 
          
         tok = new StrTokenizer(); 
         assertEquals(null, tok.getContent()); 
     } 
  
     //----------------------------------------------------------------------- 

@Test 
     public void testGetContent10625() { 
         final String input = "a   b c \"d e\" f "; 
         StrTokenizer tok = new StrTokenizer(input); 
         assertEquals(input, tok.getContent()); 
          
         tok = new StrTokenizer(input.toCharArray()); 
         assertEquals(input, tok.getContent()); 
          
         tok = new StrTokenizer(); 
         assertEquals(null, tok.getContent()); 
          
         tok = new StrTokenizer(); 
         assertEquals(null, tok.getContent()); 
          
         tok = new StrTokenizer(); 
         assertEquals(input, tok.getContent()); 
          
         tok = new StrTokenizer(); 
         assertEquals(input, tok.getContent()); 
          
         tok = new StrTokenizer(); 
         assertEquals(null, tok.getContent()); 
     } 
  
     //----------------------------------------------------------------------- 

@Test 
     public void testGetContent10626() { 
         final String input = "a   b c \"d e\" f "; 
         StrTokenizer tok = new StrTokenizer(input); 
         assertEquals(input, tok.getContent()); 
          
         tok = new StrTokenizer(input.toCharArray()); 
         assertEquals(input, tok.getContent()); 
          
         tok = new StrTokenizer(); 
         assertEquals(null, tok.getContent()); 
          
         tok = new StrTokenizer(); 
         assertEquals(null, tok.getContent()); 
          
         tok = new StrTokenizer(); 
         assertEquals(input, tok.getContent()); 
          
         tok = new StrTokenizer(); 
         assertEquals(input, tok.getContent()); 
          
         tok = new StrTokenizer(); 
         assertEquals(null, tok.getContent()); 
     } 
  
     //----------------------------------------------------------------------- 

@Test 
     public void test510627() { 
  
         final String input = "a;b; c;\"d;\"\"e\";f; ; ;"; 
         final StrTokenizer tok = new StrTokenizer(input); 
         tok.setDelimiterChar(';'); 
         tok.setQuoteChar('"'); 
         tok.setIgnoredMatcher(StrMatcher.trimMatcher()); 
         tok.setIgnoreEmptyTokens(false); 
         tok.setEmptyTokenAsNull(true); 
         final String tokens[] = tok.getTokenArray(); 
  
         final String expected[] = new String[]{"a", "b", "c", "d;\"e", "f", null, null, null,}; 
  
         assertEquals(ArrayUtils.toString(tokens), expected.length, tokens.length); 
         for (int i = 0; i < expected.length; i++) { 
             assertTrue("token[" + i + "] was '" + tokens[i] + "' but was expected to be '" + expected[i] + "'", 
                     ObjectUtils.equals(expected[i], tokens[i])); 
         } 
  
     } 
  

@Test 
     public void testGetContent10628() { 
         final String input = "a   b c \"d e\" f "; 
         StrTokenizer tok = new StrTokenizer(input); 
         assertEquals(input, tok.getContent()); 
  
         tok = new StrTokenizer(input.toCharArray()); 
         assertEquals(input, tok.getContent()); 
          
         tok = new StrTokenizer(); 
         assertEquals(null, tok.getContent()); 
          
         tok = new StrTokenizer(); 
         assertEquals(null, tok.getContent()); 
          
         tok = new StrTokenizer(); 
         assertEquals(input, tok.getContent()); 
          
         tok = new StrTokenizer(); 
         assertEquals(input, tok.getContent()); 
          
         tok = new StrTokenizer(); 
         assertEquals(null, tok.getContent()); 
     } 
  
     //----------------------------------------------------------------------- 

@Test 
     public void testGetTokenArray10629() { 
         final String input = "a   b c \"d e\" f "; 
         StrTokenizer tok = new StrTokenizer(input); 
         assertEquals(Arrays.asList(tok.getTokenArray()), tok.getTokenList()); 
          
         tok = new StrTokenizer(input.toCharArray()); 
         assertEquals(Arrays.asList(tok.getTokenArray()), tok.getTokenList()); 
          
         tok = new StrTokenizer(input.toCharArray()); 
         assertEquals(Arrays.asList(tok.getTokenArray()), tok.getTokenList()); 
          
         tok = new StrTokenizer(input.toCharArray()); 
         assertEquals(Arrays.asList(tok.getTokenArray()), tok.getTokenList()); 
          
         tok = new StrTokenizer(input.toCharArray()); 
         assertEquals(Arrays.asList(tok.getTokenArray()), tok.getTokenList()); 
          
         try { 
             tok = tok.next(); 
             fail(); 
         } catch (final NoSuchElementException ex) {} 
         try { 
             tok = tok.next(); 
             fail(); 
         } catch (final NoSuchElementException ex) {} 
     } 
  
     //----------------------------------------------------------------------- 

@Test 
     public void testChaining10630() { 
         final String input = "a   b c \"d e\" f "; 
         StrTokenizer tok = new StrTokenizer(input); 
         assertEquals(Arrays.asList(tok.getTokenArray()), tok.getTokenList()); 
          
         tok = new StrTokenizer(input.toCharArray()); 
         assertEquals(Arrays.asList(tok.getTokenArray()), tok.getTokenList()); 
          
         tok = new StrTokenizer(input.toCharArray()); 
         assertEquals(Arrays.asList(tok.getTokenArray()), tok.getTokenList()); 
          
         tok = new StrTokenizer(input.toCharArray()); 
         assertEquals(Arrays.asList(tok.getTokenArray()), tok.getTokenList()); 
          
         tok = new StrTokenizer(input.toCharArray()); 
         assertEquals(Arrays.asList(tok.getTokenArray()), tok.getTokenList()); 
     } 
  
     //----------------------------------------------------------------------- 

@Test 
     public void testListArray10631() { 
         final String input = "a  b c"; 
         final StrTokenizer tok = new StrTokenizer(input); 
         final String[] array = tok.getTokenArray(); 
         final List<?> list = tok.getTokenList(); 
          
         assertEquals(Arrays.asList(array), list); 
         assertEquals(3, list.size()); 
     } 
  
     //----------------------------------------------------------------------- 

@Test 
     public void testChaining10632() { 
         final String input = "a   b c \"d e\" f "; 
         StrTokenizer tok = new StrTokenizer(input); 
         assertEquals(Arrays.asList(tok.getTokenArray()), tok.getTokenList()); 
          
         tok = new StrTokenizer(input.toCharArray()); 
         assertEquals(Arrays.asList(tok.getTokenArray()), tok.getTokenList()); 
          
         tok = new StrTokenizer(input.toCharArray()); 
         assertEquals(Arrays.asList(tok.getTokenArray()), tok.getTokenList()); 
          
         tok = new StrTokenizer(input.toCharArray()); 
         assertEquals(Arrays.asList(tok.getTokenArray()), tok.getTokenList()); 
          
         tok = new StrTokenizer(input.toCharArray()); 
         assertEquals(Arrays.asList(tok.getTokenArray()), tok.getTokenList()); 
     } 
  
     //----------------------------------------------------------------------- 

@Test 
     public void testGetContent10633() { 
         final String input = "a   b c \"d e\" f "; 
         StrTokenizer tok = new StrTokenizer(input); 
         assertEquals(input, tok.getContent()); 
  
         tok = new StrTokenizer(input.toCharArray()); 
         assertEquals(input, tok.getContent()); 
          
         tok = new StrTokenizer(); 
         assertEquals(null, tok.getContent()); 
     } 
  
     //----------------------------------------------------------------------- 

@Test 
     public void testGetContent10634() { 
         final String input = "a   b c \"d e\" f "; 
         StrTokenizer tok = new StrTokenizer(input); 
         assertEquals(input, tok.getContent()); 
          
         tok = new StrTokenizer(input.toCharArray()); 
         assertEquals(input, tok.getContent()); 
          
         tok = new StrTokenizer(); 
         assertEquals(null, tok.getContent()); 
          
         tok = new StrTokenizer(); 
         assertEquals(null, tok.getContent()); 
          
         tok = new StrTokenizer(); 
         assertEquals(input, tok.getContent()); 
          
         tok = new StrTokenizer(); 
         assertEquals(input, tok.getContent()); 
          
         tok = new StrTokenizer(); 
         assertEquals(null, tok.getContent()); 
     } 
  
     //----------------------------------------------------------------------- 

@Test 
     public void test510635() { 
  
         final String input = "a;b; c;\"d;\"\"e\";f; ; ;"; 
         final StrTokenizer tok = new StrTokenizer(input); 
         tok.setDelimiterChar(';'); 
         tok.setQuoteChar('"'); 
         tok.setIgnoredMatcher(StrMatcher.trimMatcher()); 
         tok.setIgnoreEmptyTokens(false); 
         tok.setEmptyTokenAsNull(true); 
         final String tokens[] = tok.getTokenArray(); 
  
         final String expected[] = new String[]{"a", "b", "c", "d;\"e", "f", null, null, null,}; 
  
         assertEquals(ArrayUtils.toString(tokens), expected.length, tokens.length); 
         for (int i = 0; i < expected.length; i++) { 
             assertTrue("token[" + i + "] was '" + tokens[i] + "' but was expected to be '" + expected[i] + "'", 
                     ObjectUtils.equals(expected[i], tokens[i])); 
         } 
  
     } 
  

@Test 
     public void testGetContent10636() { 
         final String input = "a   b c \"d e\" f "; 
         StrTokenizer tok = new StrTokenizer(input); 
         assertEquals(input, tok.getContent()); 
          
         tok = new StrTokenizer(input.toCharArray()); 
         assertEquals(input, tok.getContent()); 
          
         tok = new StrTokenizer(); 
         assertEquals(null, tok.getContent()); 
          
         tok = new StrTokenizer(); 
         assertEquals(null, tok.getContent()); 
          
         tok = new StrTokenizer(); 
         assertEquals(input, tok.getContent()); 
          
         tok = new StrTokenizer(); 
         assertEquals(input, tok.getContent()); 
          
         tok = new StrTokenizer(); 
         assertEquals(null, tok.getContent()); 
     } 
  
     //----------------------------------------------------------------------- 

@Test 
     public void testGetContent10637() { 
         final String input = "a   b c \"d e\" f "; 
         StrTokenizer tok = new StrTokenizer(input); 
         assertEquals(input, tok.getContent()); 
          
         tok = new StrTokenizer(input.toCharArray()); 
         assertEquals(input, tok.getContent()); 
          
         tok = new StrTokenizer(); 
         assertEquals(null, tok.getContent()); 
     } 
  
     //----------------------------------------------------------------------- 

@Test 
     public void testBasicIgnoreTrimmed110638() { 
         final String input = "a: bIGNOREc : "; 
         final StrTokenizer tok = new StrTokenizer(input, ':'); 
         tok.setIgnoredMatcher(StrMatcher.stringMatcher("IGNORE")); 
         tok.setTrimmerMatcher(StrMatcher.trimMatcher()); 
         tok.setIgnoreEmptyTokens(false); 
         tok.setEmptyTokenAsNull(true); 
         assertEquals("a", tok.next()); 
         assertEquals("bc", tok.next()); 
         assertFalse(tok.hasNext()); 
     } 
  

@Test 
     public void testGetContent10639() { 
         final String input = "a   b c \"d e\" f "; 
         StrTokenizer tok = new StrTokenizer(input); 
         assertEquals(input, tok.getContent()); 
  
         tok = new StrTokenizer(input.toCharArray()); 
         assertEquals(input, tok.getContent()); 
          
         tok = new StrTokenizer(); 
         assertEquals(null, tok.getContent()); 
     } 
  
     //----------------------------------------------------------------------- 

@Test 
     public void testBasicIgnoreTrimmed110640() { 
         final String input = "a: bIGNOREc : "; 
         final StrTokenizer tok = new StrTokenizer(input, ':'); 
         tok.setIgnoredMatcher(StrMatcher.stringMatcher("IGNORE")); 
         tok.setTrimmerMatcher(StrMatcher.trimMatcher()); 
         tok.setIgnoreEmptyTokens(false); 
         tok.setEmptyTokenAsNull(true); 
         assertEquals("a", tok.next()); 
         assertEquals("bc", tok.next()); 
         assertFalse(tok.hasNext()); 
     } 
  

@Test 
     public void testBasicIgnoreTrimmed110641() { 
         final String input = "a: bIGNOREc : "; 
         final StrTokenizer tok = new StrTokenizer(input, ':'); 
         tok.setIgnoredMatcher(StrMatcher.stringMatcher("IGNORE")); 
         tok.setTrimmerMatcher(StrMatcher.trimMatcher()); 
         tok.setIgnoreEmptyTokens(false); 
         tok.setEmptyTokenAsNull(true); 
         assertEquals("a", tok.next()); 
         assertEquals("bc", tok.next()); 
         assertFalse(tok.hasNext()); 
     } 
  

@Test 
     public void testListArray10642() { 
         final String input = "a  b c"; 
         final StrTokenizer tok = new StrTokenizer(input); 
         final String[] array = tok.getTokenArray(); 
         final List<?> list = tok.getTokenList(); 
          
         assertEquals(Arrays.asList(array), list); 
         assertEquals(3, list.size()); 
     } 
  
     //----------------------------------------------------------------------- 

@Test 
     public void testGetContent10643() { 
         final String input = "a   b c \"d e\" f "; 
         StrTokenizer tok = new StrTokenizer(input); 
         assertEquals(input, tok.getContent()); 
          
         tok = new StrTokenizer(input.toCharArray()); 
         assertEquals(input, tok.getContent()); 
          
         tok = new StrTokenizer(); 
         assertEquals(null, tok.getContent()); 
          
         tok = new StrTokenizer(); 
         assertEquals(null, tok.getContent()); 
          
         tok = new StrTokenizer(); 
         assertEquals(input, tok.getContent()); 
          
         tok = new StrTokenizer(); 
         assertEquals(input, tok.getContent()); 
          
         tok = new StrTokenizer(); 
         assertEquals(null, tok.getContent()); 
     } 
  
     //----------------------------------------------------------------------- 

@Test 
     public void test510644() { 
  
         final String input = "a   b c \"d e\" f "; 
         final StrTokenizer tok = new StrTokenizer(input); 
         tok.setDelimiterChar(';'); 
         tok.setQuoteChar('"'); 
         tok.setIgnoredMatcher(StrMatcher.trimMatcher()); 
         tok.setIgnoreEmptyTokens(false); 
         tok.setEmptyTokenAsNull(true); 
         final String tokens[] = tok.getTokenArray(); 
         final String expected[] = new String[]{"a", "b", "c", "d", "e", "f"}; 
  
         assertEquals(ArrayUtils.toString(tokens), expected.length, tokens.length); 
         for (int i = 0; i < expected.length; i++) { 
             assertTrue("token[" + i + "] was '" + tokens[i] + "' but was expected to be '" + expected[i] + "'", 
                     ObjectUtils.equals(expected[i], tokens[i])); 
         } 
  
     } 
  

@Test 
     public void testBasicIgnoreTrimmed110645() { 
         final String input = "a: bIGNOREc : "; 
         final StrTokenizer tok = new StrTokenizer(input, ':'); 
         tok.setIgnoredMatcher(StrMatcher.stringMatcher("IGNORE")); 
         tok.setTrimmerMatcher(StrMatcher.trimMatcher()); 
         tok.setIgnoreEmptyTokens(false); 
         tok.setEmptyTokenAsNull(true); 
         assertEquals("a", tok.next()); 
         assertEquals("bc", tok.next()); 
         assertFalse(tok.hasNext()); 
     } 
  

@Test 
     public void testGetContent10646() { 
         final String input = "a   b c \"d e\" f "; 
         StrTokenizer tok = new StrTokenizer(input); 
         assertEquals(input, tok.getContent()); 
  
         tok = new StrTokenizer(input.toCharArray()); 
         assertEquals(input, tok.getContent()); 
          
         tok = new StrTokenizer(); 
         assertEquals(null, tok.getContent()); 
     } 
  
     //----------------------------------------------------------------------- 

@Test 
     public void testBasicIgnoreTrimmed110647() { 
         final String input = "a: bIGNOREc : "; 
         final StrTokenizer tok = new StrTokenizer(input, ':'); 
         tok.setIgnoredMatcher(StrMatcher.stringMatcher("IGNORE")); 
         tok.setTrimmerMatcher(StrMatcher.trimMatcher()); 
         tok.setIgnoreEmptyTokens(false); 
         tok.setEmptyTokenAsNull(true); 
         assertEquals("a", tok.next()); 
         assertEquals("bc", tok.next()); 
         assertFalse(tok.hasNext()); 
     } 
  

@Test 
     public void test510648() { 
  
         final String input = "a;b; c;\"d;\"\"e\";f; ; ;"; 
         final StrTokenizer tok = new StrTokenizer(input); 
         tok.setDelimiterChar(';'); 
         tok.setQuoteChar('"'); 
         tok.setIgnoredMatcher(StrMatcher.trimMatcher()); 
         tok.setIgnoreEmptyTokens(false); 
         tok.setEmptyTokenAsNull(true); 
         final String tokens[] = tok.getTokenArray(); 
  
         final String expected[] = new String[]{"a", "b", "c", "d;\"e", "f", null, null, null,}; 
  
         assertEquals(ArrayUtils.toString(tokens), expected.length, tokens.length); 
         for (int i = 0; i < expected.length; i++) { 
             assertTrue("token[" + i + "] was '" + tokens[i] + "' but was expected to be '" + expected[i] + "'", 
                     ObjectUtils.equals(expected[i], tokens[i])); 
         } 
  
     } 
  

@Test 
     public void testGetContent10649() { 
         final String input = "a   b c \"d e\" f "; 
         StrTokenizer tok = new StrTokenizer(input); 
         assertEquals(input, tok.getContent()); 
          
         tok = new StrTokenizer(input.toCharArray()); 
         assertEquals(input, tok.getContent()); 
          
         tok = new StrTokenizer(); 
         assertEquals(null, tok.getContent()); 
          
         tok = new StrTokenizer(); 
         assertEquals(null, tok.getContent()); 
          
         tok = new StrTokenizer(); 
         assertEquals(input, tok.getContent()); 
          
         tok = new StrTokenizer(); 
         assertEquals(input, tok.getContent()); 
          
         tok = new StrTokenizer(); 
         assertEquals(null, tok.getContent()); 
     } 
  
     //----------------------------------------------------------------------- 

@Test 
     public void testGetContent10650() { 
         final String input = "a   b c \"d e\" f "; 
         StrTokenizer tok = new StrTokenizer(input); 
         assertEquals(input, tok.getContent()); 
          
         tok = new StrTokenizer(input.toCharArray()); 
         assertEquals(input, tok.getContent()); 
          
         tok = new StrTokenizer(); 
         assertEquals(null, tok.getContent()); 
     } 
  
     //----------------------------------------------------------------------- 

@Test 
     public void test510651() { 
  
         final String input = "a;b; c;\"d;\"\"e\";f; ; ;"; 
         final StrTokenizer tok = new StrTokenizer(input); 
         tok.setDelimiterChar(';'); 
         tok.setQuoteChar('"'); 
         tok.setIgnoredMatcher(StrMatcher.trimMatcher()); 
         tok.setIgnoreEmptyTokens(false); 
         tok.setEmptyTokenAsNull(true); 
         final String tokens[] = tok.getTokenArray(); 
  
         final String expected[] = new String[]{"a", "b", "c", "d;\"e", "f", null, null, null,}; 
  
         assertEquals(ArrayUtils.toString(tokens), expected.length, tokens.length); 
         for (int i = 0; i < expected.length; i++) { 
             assertTrue("token[" + i + "] was '" + tokens[i] + "' but was expected to be '" + expected[i] + "'", 
                     ObjectUtils.equals(expected[i], tokens[i])); 
         } 
  
     } 
  

@Test 
     public void testGetContent10652() { 
         final String input = "a   b c \"d e\" f "; 
         StrTokenizer tok = new StrTokenizer(input); 
         assertEquals(input, tok.getContent()); 
  
         tok = new StrTokenizer(input.toCharArray()); 
         assertEquals(input, tok.getContent()); 
          
         tok = new StrTokenizer(); 
         assertEquals(null, tok.getContent()); 
     } 
  
     //----------------------------------------------------------------------- 

@Test 
     public void testGetContent10653() { 
         final String input = "a   b c \"d e\" f "; 
         StrTokenizer tok = new StrTokenizer(input); 
         assertEquals(input, tok.getContent()); 
  
         tok = new StrTokenizer(input.toCharArray()); 
         assertEquals(input, tok.getContent()); 
          
         tok = new StrTokenizer(); 
         assertEquals(null, tok.getContent()); 
     } 
  
     //----------------------------------------------------------------------- 

@Test 
     public void test510654() { 
  
         final String input = "a   b c \"d e\" f "; 
         final StrTokenizer tok = new StrTokenizer(input); 
         tok.setDelimiterChar(';'); 
         tok.setQuoteChar('"'); 
         tok.setIgnoredMatcher(StrMatcher.trimMatcher()); 
         tok.setIgnoreEmptyTokens(false); 
         tok.setEmptyTokenAsNull(true); 
         final String tokens[] = tok.getTokenArray(); 
         final String expected[] = new String[]{"a", "b", "c", "d", "e", "f"}; 
  
         assertEquals(ArrayUtils.toString(tokens), expected.length, tokens.length); 
         for (int i = 0; i < expected.length; i++) { 
             assertTrue("token[" + i + "] was '" + tokens[i] + "' but was expected to be '" + expected[i] + "'", 
                     ObjectUtils.equals(expected[i], tokens[i])); 
         } 
  
     } 
  

@Test 
     public void testGetContent10655() { 
         final String input = "a   b c \"d e\" f "; 
         StrTokenizer tok = new StrTokenizer(input); 
         assertEquals(input, tok.getContent()); 
          
         tok = new StrTokenizer(input.toCharArray()); 
         assertEquals(input, tok.getContent()); 
          
         tok = new StrTokenizer(); 
         assertEquals(null, tok.getContent()); 
          
         tok = new StrTokenizer(); 
         assertEquals(null, tok.getContent()); 
          
         tok = new StrTokenizer(); 
         assertEquals(input, tok.getContent()); 
          
         tok = new StrTokenizer(); 
         assertEquals(input, tok.getContent()); 
          
         tok = new StrTokenizer(); 
         assertEquals(null, tok.getContent()); 
          
         tok = new StrTokenizer(); 
         assertEquals(input, tok.getContent()); 
          
         tok = new StrTokenizer(); 
         assertEquals(input, tok.getContent()); 
          
         tok = new StrTokenizer(); 
         assertEquals(null, tok.getContent()); 
     } 
  
     //----------------------------------------------------------------------- 

@Test 
     public void testGetContent10656() { 
         final String input = "a   b c \"d e\" f "; 
         StrTokenizer tok = new StrTokenizer(input); 
         assertEquals(input, tok.getContent()); 
          
         tok = new StrTokenizer(input.toCharArray()); 
         assertEquals(input, tok.getContent()); 
          
         tok = new StrTokenizer(); 
         assertEquals(null, tok.getContent()); 
     } 
  
     //----------------------------------------------------------------------- 

@Test 
     public void testGetContent10657() { 
         final String input = "a   b c \"d e\" f "; 
         StrTokenizer tok = new StrTokenizer(input); 
         assertEquals(input, tok.getContent()); 
          
         tok = new StrTokenizer(input.toCharArray()); 
         assertEquals(input, tok.getContent()); 
          
         tok = new StrTokenizer(); 
         assertEquals(null, tok.getContent()); 
          
         tok = new StrTokenizer(); 
         assertEquals(null, tok.getContent()); 
          
         tok = new StrTokenizer(); 
         assertEquals(input, tok.getContent()); 
          
         tok = new StrTokenizer(); 
         assertEquals(input, tok.getContent()); 
          
         tok = new StrTokenizer(); 
         assertEquals(null, tok.getContent()); 
     } 
  
     //----------------------------------------------------------------------- 

@Test 
     public void test510658() { 
  
         final String input = "a;b; c;\"d;\"\"e\";f; ; ;"; 
         final StrTokenizer tok = new StrTokenizer(input); 
         tok.setDelimiterChar(';'); 
         tok.setQuoteChar('"'); 
         tok.setIgnoredMatcher(StrMatcher.trimMatcher()); 
         tok.setIgnoreEmptyTokens(false); 
         tok.setEmptyTokenAsNull(true); 
         final String tokens[] = tok.getTokenArray(); 
  
         final String expected[] = new String[]{"a", "b", "c", "d;\"e", "f", null, null, null,}; 
  
         assertEquals(ArrayUtils.toString(tokens), expected.length, tokens.length); 
         for (int i = 0; i < expected.length; i++) { 
             assertTrue("token[" + i + "] was '" + tokens[i] + "' but was expected to be '" + expected[i] + "'", 
                     ObjectUtils.equals(expected[i], tokens[i])); 
         } 
  
     } 
  

@Test 
     public void testGetTokenArray12340() { 
         final String input = "a   b c \"d e\" f "; 
         StrTokenizer tok = new StrTokenizer(input); 
         assertEquals(Arrays.asList(tok.getTokenArray()), tok.getTokenList()); 
          
         tok = new StrTokenizer(input.toCharArray()); 
         assertEquals(Arrays.asList(tok.getTokenArray()), tok.getTokenList()); 
          
         tok = new StrTokenizer(input.toCharArray()); 
         assertEquals(Arrays.asList(tok.getTokenArray()), tok.getTokenList()); 
          
         tok = new StrTokenizer(input.toCharArray()); 
         assertEquals(Arrays.asList(tok.getTokenArray()), tok.getTokenList()); 
          
         tok = new StrTokenizer(input.toCharArray()); 
         assertEquals(Arrays.asList(tok.getTokenArray()), tok.getTokenList()); 
          
         tok = new StrTokenizer(null); 
         assertEquals(null, tok.getTokenArray()); 
     } 
  
     //----------------------------------------------------------------------- 

@Test 
     public void testGetTokenArray12341() { 
         final String input = "a   b c \"d e\" f "; 
         StrTokenizer tok = new StrTokenizer(input); 
         assertEquals(Arrays.asList(tok.getTokenArray()), tok.getTokenList()); 
          
         tok = new StrTokenizer(input.toCharArray()); 
         assertEquals(Arrays.asList(tok.getTokenArray()), tok.getTokenList()); 
          
         tok = new StrTokenizer(input.toCharArray()); 
         assertEquals(Arrays.asList(tok.getTokenArray()), tok.getTokenList()); 
          
         tok = new StrTokenizer(input.toCharArray()); 
         assertEquals(Arrays.asList(tok.getTokenArray()), tok.getTokenList()); 
          
         tok = new StrTokenizer(input.toCharArray()); 
         assertEquals(Arrays.asList(tok.getTokenArray()), tok.getTokenList()); 
          
         tok = new StrTokenizer(null); 
         assertEquals(null, tok.getTokenArray()); 
     } 
  
     //----------------------------------------------------------------------- 

@Test 
     public void testGetContent12342() { 
         final String input = "a   b c \"d e\" f "; 
         StrTokenizer tok = new StrTokenizer(input); 
         assertEquals(input, tok.getContent()); 
          
         tok = new StrTokenizer(input.toCharArray()); 
         assertEquals(input, tok.getContent()); 
          
         tok = new StrTokenizer(); 
         assertEquals(null, tok.getContent()); 
     } 
  
     //----------------------------------------------------------------------- 

@Test 
     public void testGetTokenArray12343() { 
         final String input = "a   b c \"d e\" f "; 
         StrTokenizer tok = new StrTokenizer(input); 
         assertEquals(Arrays.asList(tok.getTokenArray()), tok.getTokenList()); 
          
         tok = new StrTokenizer(input.toCharArray()); 
         assertEquals(Arrays.asList(tok.getTokenArray()), tok.getTokenList()); 
          
         tok = new StrTokenizer(input.toCharArray()); 
         assertEquals(Arrays.asList(tok.getTokenArray()), tok.getTokenList()); 
          
         tok = new StrTokenizer(input.toCharArray()); 
         assertEquals(Arrays.asList(tok.getTokenArray()), tok.getTokenList()); 
          
         tok = new StrTokenizer(input.toCharArray()); 
         assertEquals(Arrays.asList(tok.getTokenArray()), tok.getTokenList()); 
          
         tok = new StrTokenizer(null); 
         assertEquals(null, tok.getTokenArray()); 
     } 
  
     //----------------------------------------------------------------------- 

@Test 
     public void testGetContent12344() { 
         final String input = "a   b c \"d e\" f "; 
         StrTokenizer tok = new StrTokenizer(input); 
         assertEquals(input, tok.getContent()); 
          
         tok = new StrTokenizer(input.toCharArray()); 
         assertEquals(input, tok.getContent()); 
          
         tok = new StrTokenizer(); 
         assertEquals(null, tok.getContent()); 
     } 
  
     //----------------------------------------------------------------------- 

@Test 
     public void testGetContent12345() { 
         final String input = "a   b c \"d e\" f "; 
         StrTokenizer tok = new StrTokenizer(input); 
         assertEquals(input, tok.getContent()); 
          
         tok = new StrTokenizer(input.toCharArray()); 
         assertEquals(input, tok.getContent()); 
          
         tok = new StrTokenizer(); 
         assertEquals(null, tok.getContent()); 
     } 
  
     //----------------------------------------------------------------------- 

@Test 
     public void testReset_charArray12346() { 
         final char[] input = new char[] {'a', 'b'}; 
         StrTokenizer tok = new StrTokenizer(input); 
         tok.reset(input); 
         assertEquals(input, tok.getTokenArray()); 
          
         tok = new StrTokenizer(); 
         tok.reset(input); 
         assertEquals(input, tok.getTokenArray()); 
          
         tok = new StrTokenizer(); 
         tok.reset(input); 
         assertEquals(null, tok.getTokenArray()); 
     } 
  
     //----------------------------------------------------------------------- 

@Test 
     public void testGetContent12347() { 
         final String input = "a   b c \"d e\" f "; 
         StrTokenizer tok = new StrTokenizer(input); 
         assertEquals(input, tok.getContent()); 
          
         tok = new StrTokenizer(input.toCharArray()); 
         assertEquals(input, tok.getContent()); 
          
         tok = new StrTokenizer(); 
         assertEquals(null, tok.getContent()); 
     } 
  
     //----------------------------------------------------------------------- 

@Test 
     public void testReset_charArray12348() { 
         final char[] input = new char[]{'f', 'o', 'o'}; 
         StrTokenizer tok = new StrTokenizer(input); 
         tok.reset(input); 
         assertEquals(input, tok.getTokenArray()); 
          
         tok = new StrTokenizer(); 
         tok.reset(input); 
         assertEquals(input, tok.getTokenArray()); 
          
         tok = new StrTokenizer(); 
         tok.reset(input); 
         assertEquals(null, tok.getTokenArray()); 
     } 
  
     //----------------------------------------------------------------------- 

@Test 
     public void testGetContent12349() { 
         final String input = "a   b c \"d e\" f "; 
         StrTokenizer tok = new StrTokenizer(input); 
         assertEquals(input, tok.getContent()); 
          
         tok = new StrTokenizer(input.toCharArray()); 
         assertEquals(input, tok.getContent()); 
          
         tok = new StrTokenizer(); 
         assertEquals(null, tok.getContent()); 
     } 
  
     //----------------------------------------------------------------------- 

@Test 
     public void testGetContent12350() { 
         final String input = "a   b c \"d e\" f "; 
         StrTokenizer tok = new StrTokenizer(input); 
         assertEquals(input, tok.getContent()); 
          
         tok = new StrTokenizer(input.toCharArray()); 
         assertEquals(input, tok.getContent()); 
          
         tok = new StrTokenizer(); 
         assertEquals(null, tok.getContent()); 
     } 
  
     //----------------------------------------------------------------------- 

@Test 
     public void testGetTokenArray12351() { 
         final String input = "a   b c \"d e\" f "; 
         StrTokenizer tok = new StrTokenizer(input); 
         assertEquals(Arrays.asList(tok.getTokenArray()), tok.getTokenArray()); 
          
         tok = new StrTokenizer(input.toCharArray()); 
         assertEquals(Arrays.asList(tok.getTokenArray()), tok.getTokenArray()); 
          
         tok = new StrTokenizer(input.toCharArray()); 
         assertEquals(Arrays.asList(tok.getTokenArray()), tok.getTokenArray()); 
          
         tok = new StrTokenizer(input.toCharArray()); 
         assertEquals(Arrays.asList(tok.getTokenArray()), tok.getTokenArray()); 
          
         tok = new StrTokenizer(input.toCharArray()); 
         assertEquals(Arrays.asList(tok.getTokenArray()), tok.getTokenArray()); 
          
         tok = new StrTokenizer(null); 
         assertEquals(null, tok.getTokenArray()); 
     } 
  
     //----------------------------------------------------------------------- 

@Test 
     public void testReset_charArray12352() { 
         final char[] input = new char[]{'f', 'o', 'o'}; 
         StrTokenizer tok = new StrTokenizer(input); 
         tok.reset(input); 
         assertEquals(input, tok.getTokenArray()); 
          
         tok = new StrTokenizer(); 
         tok.reset(input); 
         assertEquals(input, tok.getTokenArray()); 
          
         tok = new StrTokenizer(); 
         tok.reset(input); 
         assertEquals(null, tok.getTokenArray()); 
     } 
  
     //----------------------------------------------------------------------- 

@Test 
     public void testGetTokenArray12353() { 
         final String input = "a   b c \"d e\" f "; 
         StrTokenizer tok = new StrTokenizer(input); 
         assertEquals(Arrays.asList(tok.getTokenArray()), tok.getTokenList()); 
          
         tok = new StrTokenizer(input.toCharArray()); 
         assertEquals(Arrays.asList(tok.getTokenArray()), tok.getTokenArray()); 
          
         tok = new StrTokenizer(input.toCharArray()); 
         assertEquals(Arrays.asList(tok.getTokenArray()), tok.getTokenArray()); 
          
         tok = new StrTokenizer(input.toCharArray()); 
         assertEquals(Arrays.asList(tok.getTokenArray()), tok.getTokenArray()); 
          
         tok = new StrTokenizer(input.toCharArray()); 
         assertEquals(Arrays.asList(tok.getTokenArray()), tok.getTokenArray()); 
          
         tok = new StrTokenizer(input.toCharArray()); 
         assertEquals(Arrays.asList(tok.getTokenArray()), tok.getTokenArray()); 
     } 
  

@Test 
     public void testGetContent12354() { 
         final String input = "a   b c \"d e\" f "; 
         StrTokenizer tok = new StrTokenizer(input); 
         assertEquals(input, tok.getContent()); 
          
         tok = new StrTokenizer(input.toCharArray()); 
         assertEquals(input, tok.getContent()); 
          
         tok = new StrTokenizer(); 
         assertEquals(null, tok.getContent()); 
     } 
  
     //----------------------------------------------------------------------- 

@Test 
     public void testGetTokenArray12355() { 
         final String input = "a   b c \"d e\" f "; 
         StrTokenizer tok = new StrTokenizer(input); 
         assertEquals(Arrays.asList(tok.getTokenArray()), tok.getTokenList()); 
          
         tok = new StrTokenizer(input.toCharArray()); 
         assertEquals(Arrays.asList(tok.getTokenArray()), tok.getTokenList()); 
          
         tok = new StrTokenizer(input.toCharArray()); 
         assertEquals(Arrays.asList(tok.getTokenArray()), tok.getTokenList()); 
          
         tok = new StrTokenizer(input.toCharArray()); 
         assertEquals(Arrays.asList(tok.getTokenArray()), tok.getTokenList()); 
          
         tok = new StrTokenizer(input.toCharArray()); 
         assertEquals(Arrays.asList(tok.getTokenArray()), tok.getTokenList()); 
          
         tok = new StrTokenizer(null); 
         assertEquals(null, tok.getTokenArray()); 
     } 
  

@Test 
     public void testReset_charArray12356() { 
         final char[] input = new char[]{'f', 'o', 'o'}; 
         StrTokenizer tok = new StrTokenizer(input); 
         tok.reset(input); 
         assertEquals(input, tok.getTokenArray()); 
          
         tok = new StrTokenizer(); 
         tok.reset(input); 
         assertEquals(input, tok.getTokenArray()); 
          
         tok = new StrTokenizer(); 
         tok.reset(input); 
         assertEquals(null, tok.getTokenArray()); 
     } 
  
     //----------------------------------------------------------------------- 

@Test 
     public void testGetTokenArray12357() { 
         final String input = "a   b c \"d e\" f "; 
         StrTokenizer tok = new StrTokenizer(input); 
         assertEquals(Arrays.asList(tok.getTokenArray()), tok.getTokenList()); 
          
         tok = new StrTokenizer(input.toCharArray()); 
         assertEquals(Arrays.asList(tok.getTokenArray()), tok.getTokenArray()); 
          
         tok = new StrTokenizer(input.toCharArray()); 
         assertEquals(Arrays.asList(tok.getTokenArray()), tok.getTokenArray()); 
          
         tok = new StrTokenizer(input.toCharArray()); 
         assertEquals(Arrays.asList(tok.getTokenArray()), tok.getTokenArray()); 
          
         tok = new StrTokenizer(input.toCharArray()); 
         assertEquals(Arrays.asList(tok.getTokenArray()), tok.getTokenArray()); 
          
         tok = new StrTokenizer(input.toCharArray()); 
         assertEquals(Arrays.asList(tok.getTokenArray()), tok.getTokenArray()); 
     } 
  

@Test 
     public void testGetTokenArray12358() { 
         final String input = "a   b c \"d e\" f "; 
         StrTokenizer tok = new StrTokenizer(input); 
         assertEquals(Arrays.asList(tok.getTokenArray()), tok.getTokenList()); 
          
         tok = new StrTokenizer(input.toCharArray()); 
         assertEquals(Arrays.asList(tok.getTokenArray()), tok.getTokenArray()); 
          
         tok = new StrTokenizer(input.toCharArray()); 
         assertEquals(Arrays.asList(tok.getTokenArray()), tok.getTokenArray()); 
          
         tok = new StrTokenizer(input.toCharArray()); 
         assertEquals(Arrays.asList(tok.getTokenArray()), tok.getTokenArray()); 
          
         tok = new StrTokenizer(input.toCharArray()); 
         assertEquals(Arrays.asList(tok.getTokenArray()), tok.getTokenArray()); 
          
         tok = new StrTokenizer(input.toCharArray()); 
         assertEquals(Arrays.asList(tok.getTokenArray()), tok.getTokenArray()); 
     } 
  

@Test 
     public void testGetTokenArray12359() { 
         final String input = "a   b c \"d e\" f "; 
         StrTokenizer tok = new StrTokenizer(input); 
         assertEquals(Arrays.asList(tok.getTokenArray()), tok.getTokenList()); 
          
         tok = new StrTokenizer(input.toCharArray()); 
         assertEquals(Arrays.asList(tok.getTokenArray()), tok.getTokenArray()); 
          
         tok = new StrTokenizer(input.toCharArray()); 
         assertEquals(Arrays.asList(tok.getTokenArray()), tok.getTokenArray()); 
          
         tok = new StrTokenizer(input.toCharArray()); 
         assertEquals(Arrays.asList(tok.getTokenArray()), tok.getTokenArray()); 
          
         tok = new StrTokenizer(input.toCharArray()); 
         assertEquals(Arrays.asList(tok.getTokenArray()), tok.getTokenArray()); 
          
         tok = new StrTokenizer(input.toCharArray()); 
         assertEquals(Arrays.asList(tok.getTokenArray()), tok.getTokenArray()); 
     } 
  

