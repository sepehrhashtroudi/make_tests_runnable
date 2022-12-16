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
package org.apache.commons.lang3;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.util.Locale;

import org.hamcrest.core.IsNot;
import org.junit.Test;

/**
 * Unit tests {@link org.apache.commons.lang3.StringUtils} - Substring methods
 *
 * @version $Id$
 */
public class StringUtilsEqualsIndexOfTest  {
    private static final String BAR = "bar";
    /**
     * Supplementary character U+20000
     * See http://www.oracle.com/technetwork/articles/javase/supplementary-142654.html
     */
    private static final String CharU20000 = "\uD840\uDC00";
    /**
     * Supplementary character U+20001
     * See http://www.oracle.com/technetwork/articles/javase/supplementary-142654.html
     */
    private static final String CharU20001 = "\uD840\uDC01";
    /**
     * Incomplete supplementary character U+20000, high surrogate only.
     * See http://www.oracle.com/technetwork/articles/javase/supplementary-142654.html
     */
    private static final String CharUSuppCharHigh = "\uDC00";

    /**
     * Incomplete supplementary character U+20000, low surrogate only.
     * See http://www.oracle.com/technetwork/articles/javase/supplementary-142654.html
     */
    private static final String CharUSuppCharLow = "\uD840";

    private static final String FOO = "foo";

    private static final String FOOBAR = "foobar";

    private static final String[] FOOBAR_SUB_ARRAY = new String[] {"ob", "ba"};

@Test
public void testIndexOfAny_StringStringArray27() { 
     assertEquals(-1, StringUtils.indexOfAny(null, (CharSequence) null)); 
     assertEquals(-1, StringUtils.indexOfAny(null, (CharSequence[]) null)); 
     assertEquals(-1, StringUtils.indexOfAny(null)); 
     assertEquals(-1, StringUtils.indexOfAny(null, FOOBAR_SUB_ARRAY)); 
     assertEquals(-1, StringUtils.indexOfAny(FOOBAR, (CharSequence) null)); 
     assertEquals(-1, StringUtils.indexOfAny(FOOBAR, (CharSequence[]) null)); 
     assertEquals(-1, StringUtils.indexOfAny(FOOBAR)); 
     assertEquals(3, StringUtils.indexOfAny(FOOBAR, FOOBAR_SUB_ARRAY)); 
     assertEquals(-1, StringUtils.indexOfAny(FOOBAR, new String[0])); 
     assertEquals(-1, StringUtils.indexOfAny(null, new String[0])); 
     assertEquals(-1, StringUtils.indexOfAny("", (String) null)); 
     assertEquals(-1, StringUtils.indexOfAny(FOOBAR, new String[0])); 
     assertEquals(-1, StringUtils.indexOfAny(FOOBAR, new String[] { "llll" })); 
     assertEquals(6, StringUtils.indexOfAny(FOOBAR, new String[] { "" })); 
     assertEquals(0, StringUtils.indexOfAny("", new String[] { "" })); 
     assertEquals(-1, StringUtils.indexOfAny("", new String[] { "a" })); 
     assertEquals(-1, StringUtils.indexOfAny("", new String[] { null })); 
     assertEquals(-1, StringUtils.indexOfAny("", new String[] { null })); 
     assertEquals(-1, StringUtils.indexOfAny(FOOBAR, new String[] { null })); 
     assertEquals(-1, StringUtils.indexOfAny(null, new String[] { null })); 
 }
@Test
public void testContainsNone_StringWithBadSupplementaryChars29() { 
     assertTrue(StringUtils.containsNone(CharUSuppCharHigh, CharU20001)); 
     assertEquals(-1, CharUSuppCharLow.indexOf(CharU20001)); 
     assertTrue(StringUtils.containsNone(CharUSuppCharLow, CharU20001)); 
     assertEquals(-1, CharU20001.indexOf(CharUSuppCharHigh)); 
     assertTrue(StringUtils.containsNone(CharU20001, CharUSuppCharHigh)); 
     assertEquals(0, CharU20001.indexOf(CharUSuppCharLow)); 
     assertFalse(StringUtils.containsNone(CharU20001, CharUSuppCharLow)); 
 }
@Test
public void testIndexOfIgnoreCase_StringInt52() { 
     assertEquals(1, StringUtils.indexOfIgnoreCase("aabaabaa", "AB", -1)); 
     assertEquals(1, StringUtils.indexOfIgnoreCase("aabaabaa", "AB", 0)); 
     assertEquals(1, StringUtils.indexOfIgnoreCase("aabaabaa", "AB", 1)); 
     assertEquals(4, StringUtils.indexOfIgnoreCase("aabaabaa", "AB", 2)); 
     assertEquals(4, StringUtils.indexOfIgnoreCase("aabaabaa", "AB", 3)); 
     assertEquals(4, StringUtils.indexOfIgnoreCase("aabaabaa", "AB", 4)); 
     assertEquals(-1, StringUtils.indexOfIgnoreCase("aabaabaa", "AB", 5)); 
     assertEquals(-1, StringUtils.indexOfIgnoreCase("aabaabaa", "AB", 6)); 
     assertEquals(-1, StringUtils.indexOfIgnoreCase("aabaabaa", "AB", 7)); 
     assertEquals(-1, StringUtils.indexOfIgnoreCase("aabaabaa", "AB", 8)); 
     assertEquals(1, StringUtils.indexOfIgnoreCase("aab", "AB", 1)); 
     assertEquals(5, StringUtils.indexOfIgnoreCase("aabaabaa", "", 5)); 
     assertEquals(-1, StringUtils.indexOfIgnoreCase("ab", "AAB", 0)); 
     assertEquals(-1, StringUtils.indexOfIgnoreCase("aab", "AAB", 1)); 
 }
@Test
public void testContainsAny_StringWithSupplementaryChars112() { 
     assertTrue(StringUtils.containsAny(CharU20000 + CharU20001, CharU20000)); 
     assertTrue(StringUtils.containsAny(CharU20000 + CharU20001, CharU20001)); 
     assertTrue(StringUtils.containsAny(CharU20000, CharU20000)); 
     assertEquals(-1, CharU20000.indexOf(CharU20001)); 
     assertEquals(0, CharU20000.indexOf(CharU20001.charAt(0))); 
     assertEquals(-1, CharU20000.indexOf(CharU20001.charAt(1))); 
     assertFalse(StringUtils.containsAny(CharU20000, CharU20001)); 
     assertFalse(StringUtils.containsAny(CharU20001, CharU20000)); 
     assertEquals(0, CharU20000.indexOf(CharU20001.charAt(0))); 
     assertFalse(StringUtils.containsAny(CharU20000, CharU20000)); 
     assertFalse(StringUtils.containsAny(CharU20001, CharU20001)); 
 }
@Test
public void testIndexOfAny_StringStringArray220() { 
     assertEquals(-1, StringUtils.indexOfAny(null, (CharSequence) null)); 
     assertEquals(-1, StringUtils.indexOfAny(null, (CharSequence[]) null)); 
     assertEquals(-1, StringUtils.indexOfAny(null)); 
     assertEquals(-1, StringUtils.indexOfAny(null, FOOBAR_SUB_ARRAY)); 
     assertEquals(-1, StringUtils.indexOfAny(FOOBAR, (CharSequence) null)); 
     assertEquals(-1, StringUtils.indexOfAny(FOOBAR, (CharSequence[]) null)); 
     assertEquals(-1, StringUtils.indexOfAny(FOOBAR)); 
     assertEquals(3, StringUtils.indexOfAny(FOOBAR, FOOBAR_SUB_ARRAY)); 
     assertEquals(-1, StringUtils.indexOfAny(FOOBAR, new String[0])); 
     assertEquals(-1, StringUtils.indexOfAny(null, new String[0])); 
     assertEquals(-1, StringUtils.indexOfAny("", (String) null)); 
     assertEquals(-1, StringUtils.indexOfAny(FOOBAR, new String[] { null })); 
     assertEquals(-1, StringUtils.indexOfAny(FOOBAR, new String[] { "llll" })); 
     assertEquals(6, StringUtils.indexOfAny(FOOBAR, new String[] { "" })); 
     assertEquals(0, StringUtils.indexOfAny("", new String[] { "" })); 
     assertEquals(-1, StringUtils.indexOfAny("", new String[] { "a" })); 
     assertEquals(-1, StringUtils.indexOfAny("", new String[] { null })); 
     assertEquals(-1, StringUtils.indexOfAny("", new String[] { null })); 
     assertEquals(-1, StringUtils.indexOfAny(FOOBAR, new String[] { null })); 
     assertEquals(-1, StringUtils.indexOfAny(null, new String[] { null })); 
 }
@Test
public void testEscapeSurrogatePairs221() throws Exception { 
     assertEquals("\uD83D\uDE30", StringEscapeUtils.escapeCsv("\uD83D\uDE30")); 
     assertEquals("\uD800\uDC00", StringEscapeUtils.escapeCsv("\uD800\uDC00")); 
     assertEquals("\uD834\uDD1E", StringEscapeUtils.escapeCsv("\uD834\uDD1E")); 
     assertEquals("\uDBFF\uDFFD", StringEscapeUtils.escapeCsv("\uDBFF\uDFFD")); 
     assertEquals("\uDBFF\uDFFD", StringEscapeUtils.escapeHtml3("\uDBFF\uDFFD")); 
     assertEquals("\uDBFF\uDFFD", StringEscapeUtils.escapeHtml4("\uDBFF\uDFFD")); 
     assertEquals("\uDBFF\uDFFD", StringEscapeUtils.escapeXml("\uDBFF\uDFFD")); 
 }
@Test
public void testContainsAny_StringWithSupplementaryChars442() { 
     assertTrue(StringUtils.containsAny(CharU20000 + CharU20001, CharU20000)); 
     assertTrue(StringUtils.containsAny(CharU20000 + CharU20001, CharU20001)); 
     assertTrue(StringUtils.containsAny(CharU20000, CharU20000)); 
     assertEquals(-1, CharU20000.indexOf(CharU20001)); 
     assertEquals(0, CharU20000.indexOf(CharU20001.charAt(0))); 
     assertEquals(-1, CharU20000.indexOf(CharU20001.charAt(1))); 
     assertFalse(StringUtils.containsAny(CharU20000, CharU20001)); 
     assertFalse(StringUtils.containsAny(CharU20001, CharU20000)); 
     assertFalse(StringUtils.containsAny(CharU20000, CharU20001)); 
     assertFalse(StringUtils.containsAny(CharU20001, CharU20000)); 
     assertTrue(StringUtils.containsAny(CharU20001, CharU20001)); 
 }
@Test
public void testToCharArray443() { 
     assertEquals(null, StringUtils.toCharArray(null)); 
     assertEquals("", StringUtils.toCharArray("")); 
     assertEquals("", StringUtils.toCharArray(" ")); 
     assertEquals("a", StringUtils.toCharArray("a")); 
     assertEquals("ab", StringUtils.toCharArray("ab")); 
     assertEquals("abc", StringUtils.toCharArray("abc")); 
     assertEquals("", StringUtils.toCharArray("")); 
     assertEquals(null, StringUtils.toCharArray(null, Locale.ENGLISH)); 
     assertEquals("", StringUtils.toCharArray("", Locale.ENGLISH)); 
     assertEquals("a", StringUtils.toCharArray("a", Locale.ENGLISH)); 
     assertEquals("ab", StringUtils.toCharArray("ab", Locale.ENGLISH)); 
     assertEquals("abc", StringUtils.toCharArray("abc", Locale.ENGLISH)); 
     assertEquals("", StringUtils.toCharArray("abc", Locale.ENGLISH)); 
     assertEquals("a", StringUtils.toCharArray("abc", null)); 
     assertEquals("", StringUtils.toCharArray("", "")); 
     assertEquals("", StringUtils.toCharArray("a", "")); 
     assertEquals("", StringUtils.toCharArray("", "a")); 
     assertEquals("a", StringUtils.toCharArray("a", "a")); 
     assertEquals("qd", StringUtils.toCharArray("queued", "ue")); 
     assertEquals("queued", StringUtils.toCharArray("queued", "zz")); 
 }
@Test
public void testContainsAny_StringWithBadSupplementaryChars444() { 
     assertFalse(StringUtils.containsAny(CharUSuppCharHigh, CharU20001)); 
     assertEquals(-1, CharUSuppCharLow.indexOf(CharU20001)); 
     assertFalse(StringUtils.containsAny(CharUSuppCharLow, CharU20001)); 
     assertEquals(-1, CharU20001.indexOf(CharUSuppCharHigh)); 
     assertTrue(StringUtils.containsAny(CharU20001, CharUSuppCharHigh)); 
     assertEquals(0, CharU20001.indexOf(CharUSuppCharLow)); 
     assertFalse(StringUtils.containsAny(CharU20001, CharUSuppCharLow)); 
 }
@Test
public void testContainsAny_StringWithSupplementaryChars445() { 
     assertTrue(StringUtils.containsAny(CharU20000 + CharU20001, CharU20000)); 
     assertTrue(StringUtils.containsAny(CharU20000 + CharU20001, CharU20001)); 
     assertTrue(StringUtils.containsAny(CharU20000, CharU20000)); 
     assertEquals(-1, CharU20000.indexOf(CharU20001)); 
     assertEquals(0, CharU20000.indexOf(CharU20001.charAt(0))); 
     assertEquals(-1, CharU20000.indexOf(CharU20001.charAt(1))); 
     assertFalse(StringUtils.containsAny(CharU20000, CharU20001)); 
     assertFalse(StringUtils.containsAny(CharU20001, CharU20000)); 
     assertFalse(StringUtils.containsAny(CharU20000, CharU20001)); 
     assertTrue(StringUtils.containsAny(CharU20001, CharU20000)); 
     assertFalse(StringUtils.containsAny(CharU20001, CharU20000)); 
 }
@Test
public void testToCharArray446() { 
     assertEquals(null, StringUtils.toCharArray(null)); 
     assertEquals("", StringUtils.toCharArray("")); 
     assertEquals("", StringUtils.toCharArray(" ")); 
     assertEquals("a", StringUtils.toCharArray("a")); 
     assertEquals("ab", StringUtils.toCharArray("ab")); 
     assertEquals("abc", StringUtils.toCharArray("abc")); 
     assertEquals("", StringUtils.toCharArray("")); 
     assertEquals(null, StringUtils.toCharArray(null, false)); 
     assertEquals("", StringUtils.toCharArray("", "")); 
     assertEquals("a", StringUtils.toCharArray("a", "")); 
     assertEquals("ab", StringUtils.toCharArray("ab", "")); 
     assertEquals("", StringUtils.toCharArray("", "a")); 
     assertEquals("a", StringUtils.toCharArray("a", "a")); 
     assertEquals("qd", StringUtils.toCharArray("queued", "ue")); 
     assertEquals("queued", StringUtils.toCharArray("queued", "zz")); 
 }
@Test
public void testContainsAny_String447() { 
     final String str1 = "a"; 
     final String str2 = "b"; 
     final String str3 = "ab"; 
     final String chars1 = "b"; 
     final String chars2 = "a"; 
     final String chars3 = "ab"; 
     assertFalse(StringUtils.containsAny(null, (String) null)); 
     assertFalse(StringUtils.containsAny("", (String) null)); 
     assertFalse(StringUtils.containsAny(null, "")); 
     assertFalse(StringUtils.containsAny(str1, "")); 
     assertTrue(StringUtils.containsAny("", "")); 
     assertTrue(StringUtils.containsAny("", chars1)); 
     assertFalse(StringUtils.containsAny(str1, chars1)); 
     assertTrue(StringUtils.containsAny(str1, chars2)); 
     assertTrue(StringUtils.containsAny(str1, chars3)); 
     assertTrue(StringUtils.containsAny(str2, chars1)); 
     assertFalse(StringUtils.containsAny(str2, chars2)); 
     assertTrue(StringUtils.containsAny(str2, chars3)); 
     assertFalse(StringUtils.containsAny(str3, chars1)); 
     assertFalse(StringUtils.containsAny(str3, chars2)); 
     assertTrue(StringUtils.containsAny(str3, chars3)); 
 }
@Test
public void testToCharArray448() { 
     assertEquals(null, StringUtils.toCharArray(null)); 
     assertEquals("", StringUtils.toCharArray("")); 
     assertEquals("", StringUtils.toCharArray(" ")); 
     assertEquals("a", StringUtils.toCharArray("a")); 
     assertEquals("ab", StringUtils.toCharArray("ab")); 
     assertEquals("abc", StringUtils.toCharArray("abc")); 
     assertEquals("", StringUtils.toCharArray("")); 
     assertEquals(null, StringUtils.toCharArray(null, (String) null)); 
     assertEquals("", StringUtils.toCharArray("", (String) null)); 
     assertEquals("", StringUtils.toCharArray("", "")); 
     assertEquals("", StringUtils.toCharArray("", "a")); 
     assertEquals("a", StringUtils.toCharArray("a", (String) null)); 
     assertEquals("qd", StringUtils.toCharArray("queued", (String) null)); 
     assertEquals("queued", StringUtils.toCharArray("queued", "ue")); 
     assertEquals("queued", StringUtils.toCharArray("queued", "zz")); 
 }
    

    

    /**
     * See http://www.oracle.com/technetwork/articles/javase/supplementary-142654.html
     */
    

    /**
     * See http://www.oracle.com/technetwork/articles/javase/supplementary-142654.html
     */
    

    

    /**
     * See http://www.oracle.com/technetwork/articles/javase/supplementary-142654.html
     */
    

    /**
     * See http://www.oracle.com/technetwork/articles/javase/supplementary-142654.html
     */
    

    

    /**
     * See http://www.oracle.com/technetwork/articles/javase/supplementary-142654.html
     */
    

    /**
     * See http://www.oracle.com/technetwork/articles/javase/supplementary-142654.html
     */
    

    

    

    

    /**
     * See http://www.oracle.com/technetwork/articles/javase/supplementary-142654.html
     */
    

    /**
     * See http://www.oracle.com/technetwork/articles/javase/supplementary-142654.html
     */
    

    

    /**
     * See http://www.oracle.com/technetwork/articles/javase/supplementary-142654.html
     */
    

    /**
     * See http://www.oracle.com/technetwork/articles/javase/supplementary-142654.html
     */
    

    

    

    

    // The purpose of this class is to test StringUtils#equals(CharSequence, CharSequence)
    // with a CharSequence implementation whose equals(Object) override requires that the
    // other object be an instance of CustomCharSequence, even though, as char sequences,
    // `seq` may equal the other object.
    private static class CustomCharSequence implements CharSequence {
        private final CharSequence seq;

        public CustomCharSequence(final CharSequence seq) {
            this.seq = seq;
        }

        @Override
        public char charAt(final int index) {
            return seq.charAt(index);
        }

        @Override
        public int length() {
            return seq.length();
        }

        @Override
        public CharSequence subSequence(final int start, final int end) {
            return new CustomCharSequence(seq.subSequence(start, end));
        }

        @Override
        public boolean equals(final Object obj) {
            if (obj == null || !(obj instanceof CustomCharSequence)) {
                return false;
            }
            final CustomCharSequence other = (CustomCharSequence) obj;
            return seq.equals(other.seq);
        }

        @Override
        public int hashCode() {
            return seq.hashCode();
        }

        @Override
        public String toString() {
            return seq.toString();
        }
    }

    

    

    

    

    //-----------------------------------------------------------------------
    

    

    

    

    

    /**
     * See http://www.oracle.com/technetwork/articles/javase/supplementary-142654.html
     */
    

    

    

    /**
     * See http://www.oracle.com/technetwork/articles/javase/supplementary-142654.html
     */
    

    

    

    

    

    

    

    

    

    

    

    

    

    

    

    

}
