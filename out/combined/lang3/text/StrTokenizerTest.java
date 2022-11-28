/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.commons.lang3.text;

import org.junit.Test;
import static org.junit.Assert.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.ObjectUtils;

/**
 * Unit test for Tokenizer.
 * 
 */
public class StrTokenizerTest {

    private static final String CSV_SIMPLE_FIXTURE = "A,b,c";

    private static final String TSV_SIMPLE_FIXTURE = "A\tb\tc";

    private void checkClone(final StrTokenizer tokenizer) {
        assertFalse(StrTokenizer.getCSVInstance() == tokenizer);
        assertFalse(StrTokenizer.getTSVInstance() == tokenizer);
    }

    // -----------------------------------------------------------------------
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
    

    

    

    

    

    

    

    

    

    

    

    

    

    

    

    

    

    

    

    

    

    

    

    

    

    

    

    

    

    

    

    //-----------------------------------------------------------------------
    

    //-----------------------------------------------------------------------
    private void testCSV(final String data) {
        this.testXSVAbc(StrTokenizer.getCSVInstance(data));
        this.testXSVAbc(StrTokenizer.getCSVInstance(data.toCharArray()));
    }

    

    

    

    void testEmpty(final StrTokenizer tokenizer) {
        this.checkClone(tokenizer);
        assertFalse(tokenizer.hasNext());
        assertFalse(tokenizer.hasPrevious());
        assertEquals(null, tokenizer.nextToken());
        assertEquals(0, tokenizer.size());
        try {
            tokenizer.next();
            fail();
        } catch (final NoSuchElementException ex) {}
    }

    

    //-----------------------------------------------------------------------
    

    /**
     * Tests that the {@link StrTokenizer#clone()} clone method catches {@link CloneNotSupportedException} and returns
     * <code>null</code>.
     */
    

    

    
  
    // -----------------------------------------------------------------------
    

    //-----------------------------------------------------------------------
    

    //-----------------------------------------------------------------------
    

    //-----------------------------------------------------------------------
    

    //-----------------------------------------------------------------------
    

    //-----------------------------------------------------------------------
    

    //-----------------------------------------------------------------------
    

    //-----------------------------------------------------------------------
    

    //-----------------------------------------------------------------------
    

    //-----------------------------------------------------------------------
    

    

    void testXSVAbc(final StrTokenizer tokenizer) {
        this.checkClone(tokenizer);
        assertEquals(-1, tokenizer.previousIndex());
        assertEquals(0, tokenizer.nextIndex());
        assertEquals(null, tokenizer.previousToken());
        assertEquals("A", tokenizer.nextToken());
        assertEquals(1, tokenizer.nextIndex());
        assertEquals("b", tokenizer.nextToken());
        assertEquals(2, tokenizer.nextIndex());
        assertEquals("c", tokenizer.nextToken());
        assertEquals(3, tokenizer.nextIndex());
        assertEquals(null, tokenizer.nextToken());
        assertEquals(3, tokenizer.nextIndex());
        assertEquals("c", tokenizer.previousToken());
        assertEquals(2, tokenizer.nextIndex());
        assertEquals("b", tokenizer.previousToken());
        assertEquals(1, tokenizer.nextIndex());
        assertEquals("A", tokenizer.previousToken());
        assertEquals(0, tokenizer.nextIndex());
        assertEquals(null, tokenizer.previousToken());
        assertEquals(0, tokenizer.nextIndex());
        assertEquals(-1, tokenizer.previousIndex());
        assertEquals(3, tokenizer.size());
    }

    

    //-----------------------------------------------------------------------
    

    //-----------------------------------------------------------------------
    

    //-----------------------------------------------------------------------
    

}
