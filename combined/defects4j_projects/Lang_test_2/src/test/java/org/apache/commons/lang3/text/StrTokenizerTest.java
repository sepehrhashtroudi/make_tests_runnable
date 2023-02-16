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
public void testBasicQuotedTrimmed1120() { 
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
public void testTSVEmpty121() { 
     this.testEmpty(StrTokenizer.getCSVInstance()); 
     this.testEmpty(StrTokenizer.getCSVInstance("")); 
 }
@Test
public void testCloneOfStringArray124() { 
     final String input = "a;b; c;\"d;\"\"e\";f; ;"; 
     final StrTokenizer tokenizer = new StrTokenizer(input); 
     tokenizer.setDelimiterChar(';'); 
     tokenizer.setQuoteChar('"'); 
     tokenizer.setIgnoredMatcher(StrMatcher.trimMatcher()); 
     tokenizer.setIgnoreEmptyTokens(true); 
     final String[] tokens = tokenizer.getTokenArray(); 
     final String[] expected = new String[] { "a", "b", "c", "d;\"e", "f" }; 
     assertEquals(ArrayUtils.toString(tokens), expected.length, tokens.length); 
     for (int i = 0; i < expected.length; i++) { 
         assertTrue("token[" + i + "] was '" + tokens[i] + "' but was expected to be '" + expected[i] + "'", ObjectUtils.equals(expected[i], tokens[i])); 
     } 
 }
@Test
public void testToString125() { 
     final String input = "a;b; c;\"d;\"\"e\";f; ;"; 
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
