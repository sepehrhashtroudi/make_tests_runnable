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
public void testReset_String49() { 
     final StrTokenizer tok = new StrTokenizer("x x x"); 
     tok.reset("d e"); 
     assertEquals("d", tok.next()); 
     assertEquals("e", tok.next()); 
     assertFalse(tok.hasNext()); 
     tok.reset((String) null); 
     assertFalse(tok.hasNext()); 
 }
@Test
public void testBasicQuotedTrimmed1121() { 
     final String input = "a: 'b' :"; 
     final StrTokenizer tok = new StrTokenizer(input, ':', '\''); 
     tok.setTrimmerMatcher(StrMatcher.trimMatcher()); 
     tok.setIgnoreEmptyTokens(false); 
     tok.setEmptyTokenAsNull(true); 
     assertEquals("a", tok.next()); 
     assertEquals("b", tok.next()); 
     assertEquals(null, tok.next()); 
     assertFalse(tok.hasNext()); 
 }
@Test
public void testToString142() { 
     final StrTokenizer tkn = new StrTokenizer("a b c d e"); 
     assertEquals("StrTokenizer[not tokenized yet]", tkn.toString()); 
     tkn.next(); 
     assertEquals("StrTokenizer[a, b, c, d, e]", tkn.toString()); 
 }
@Test
public void testReset_charArray170() { 
     final StrTokenizer tok = new StrTokenizer("x x x"); 
     final char[] array = new char[] { 'a', 'b', 'c' }; 
     tok.reset(array); 
     assertEquals("abc", tok.next()); 
     assertFalse(tok.hasNext()); 
     tok.reset((char[]) null); 
     assertFalse(tok.hasNext()); 
 }
@Test
public void testConstructor_charArray_char_char200() { 
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
public void testTSV237() { 
     this.testXSVAbc(StrTokenizer.getTSVInstance(TSV_SIMPLE_FIXTURE)); 
     this.testXSVAbc(StrTokenizer.getTSVInstance(TSV_SIMPLE_FIXTURE.toCharArray())); 
 }
@Test
public void testCloneReset256() { 
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
public void testGetContent314() { 
     final String input = "a   b c \"d e\" f "; 
     StrTokenizer tok = new StrTokenizer(input); 
     assertEquals(input, tok.getContent()); 
     tok = new StrTokenizer(input.toCharArray()); 
     assertEquals(input, tok.getContent()); 
     tok = new StrTokenizer(); 
     assertEquals(null, tok.getContent()); 
 }
@Test
public void testBasicIgnoreTrimmed1347() { 
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
public void test4458() { 
     final String input = "a;b; c;\"d;\"\"e\";f; ; ;"; 
     final StrTokenizer tok = new StrTokenizer(input); 
     tok.setDelimiterChar(';'); 
     tok.setQuoteChar('"'); 
     tok.setIgnoredMatcher(StrMatcher.trimMatcher()); 
     tok.setIgnoreEmptyTokens(true); 
     final String[] tokens = tok.getTokenArray(); 
     final String[] expected = new String[] { "a", "b", "c", "d;\"e", "f" }; 
     assertEquals(ArrayUtils.toString(tokens), expected.length, tokens.length); 
     for (int i = 0; i < expected.length; i++) { 
         assertTrue("token[" + i + "] was '" + tokens[i] + "' but was expected to be '" + expected[i] + "'", ObjectUtils.equals(expected[i], tokens[i])); 
     } 
 }
@Test
public void testListArray462() { 
     final String input = "a  b c"; 
     final StrTokenizer tok = new StrTokenizer(input); 
     final String[] array = tok.getTokenArray(); 
     final List<?> list = tok.getTokenList(); 
     assertEquals(Arrays.asList(array), list); 
     assertEquals(3, list.size()); 
 }
@Test
public void testIteration665() { 
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
public void testCSVSimple677() { 
     this.testCSV(CSV_SIMPLE_FIXTURE); 
 }
@Test
public void testChaining722() { 
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
public void testCloneNotSupportedException807() { 
     final Object notCloned = new StrTokenizer() { 
  
         @Override 
         Object cloneReset() throws CloneNotSupportedException { 
             throw new CloneNotSupportedException("test"); 
         } 
     }.clone(); 
     assertNull(notCloned); 
 }
@Test
public void testBasicQuoted51003() { 
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
public void test61042() { 
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
public void testTSV1409() { 
     this.testXSVAbc(StrTokenizer.getTSVInstance(TSV_SIMPLE_FIXTURE)); 
     this.testXSVAbc(StrTokenizer.getTSVInstance(TSV_SIMPLE_FIXTURE.toCharArray())); 
 }
@Test
public void test41413() { 
     final String input = "a;b; c;\"d;\"\"e\";f; ; ;"; 
     final StrTokenizer tok = new StrTokenizer(input); 
     tok.setDelimiterChar(';'); 
     tok.setQuoteChar('"'); 
     tok.setIgnoredMatcher(StrMatcher.trimMatcher()); 
     tok.setIgnoreEmptyTokens(true); 
     final String[] tokens = tok.getTokenArray(); 
     final String[] expected = new String[] { "a", "b", "c", "d;\"e", "f" }; 
     assertEquals(ArrayUtils.toString(tokens), expected.length, tokens.length); 
     for (int i = 0; i < expected.length; i++) { 
         assertTrue("token[" + i + "] was '" + tokens[i] + "' but was expected to be '" + expected[i] + "'", ObjectUtils.equals(expected[i], tokens[i])); 
     } 
 }
@Test
public void testCloneReset1704() { 
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
public void testReset_String1705() { 
     final StrTokenizer tok = new StrTokenizer("x x x"); 
     tok.reset("d e"); 
     assertEquals("d", tok.next()); 
     assertEquals("e", tok.next()); 
     assertFalse(tok.hasNext()); 
     tok.reset((String) null); 
     assertFalse(tok.hasNext()); 
 }
@Test
public void testCloneNotSupportedException1706() { 
     final Object notCloned = new StrTokenizer() { 
  
         @Override 
         Object cloneReset() throws CloneNotSupportedException { 
             throw new CloneNotSupportedException("test"); 
         } 
     }.clone(); 
     assertNull(notCloned); 
 }
@Test
public void testCSVSimple1707() { 
     this.testCSV(CSV_SIMPLE_FIXTURE); 
 }
@Test
public void test61708() { 
     final String input = "a;b; c;\"d;\"\"e\";f; ; ;"; 
     final StrTokenizer tok = new StrTokenizer(input); 
     tok.setDelimiterChar(';'); 
     tok.setQuoteChar('"'); 
     tok.setIgnoredMatcher(StrMatcher.trimMatcher()); 
     tok.setIgnoreEmptyTokens(true); 
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
public void testBasicQuotedTrimmed11709() { 
     final String input = "a: 'b' :"; 
     final StrTokenizer tok = new StrTokenizer(input, ':', '\''); 
     tok.setTrimmerMatcher(StrMatcher.trimMatcher()); 
     tok.setIgnoreEmptyTokens(false); 
     tok.setEmptyTokenAsNull(true); 
     assertEquals("a", tok.next()); 
     assertEquals("b", tok.next()); 
     assertEquals(null, tok.next()); 
     assertFalse(tok.hasNext()); 
 }
@Test
public void testIteration1710() { 
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
