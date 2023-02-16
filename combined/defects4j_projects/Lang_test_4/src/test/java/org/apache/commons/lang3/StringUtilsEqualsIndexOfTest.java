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
public void testEqualsIgnoreCase_StringString492() { 
     assertTrue(StringUtils.equalsIgnoreCase(null, null)); 
     assertTrue(StringUtils.equalsIgnoreCase(FOO, FOO)); 
     assertTrue(StringUtils.equalsIgnoreCase(FOO, new String(new char[] { 'f', 'o', 'o' }))); 
     assertFalse(StringUtils.equalsIgnoreCase(FOO, new String(new char[] { 'f', 'O', 'O' }))); 
     assertFalse(StringUtils.equalsIgnoreCase(FOO, BAR)); 
     assertFalse(StringUtils.equalsIgnoreCase(FOO, null)); 
     assertFalse(StringUtils.equalsIgnoreCase(null, FOO)); 
     assertFalse(StringUtils.equalsIgnoreCase(FOO, FOOBAR)); 
     assertFalse(StringUtils.equalsIgnoreCase(FOOBAR, FOO)); 
     assertTrue(StringUtils.equalsIgnoreCase(FOOBAR, FOO)); 
 }
@Test
public void testIndexOf_char_int493() { 
     assertEquals(-1, StringUtils.indexOf(null, ' ')); 
     assertEquals(-1, StringUtils.indexOf("", ' ')); 
     assertEquals(0, StringUtils.indexOf("aabaabaa", 'a')); 
     assertEquals(2, StringUtils.indexOf("aabaabaa", 'b')); 
     assertEquals(2, StringUtils.indexOf(new StringBuilder("aabaabaa"), 'b')); 
 }
@Test
public void testIndexOf_charInt494() { 
     assertEquals(-1, StringUtils.indexOf(null, ' ')); 
     assertEquals(-1, StringUtils.indexOf("", ' ')); 
     assertEquals(0, StringUtils.indexOf("aabaabaa", 'a')); 
     assertEquals(2, StringUtils.indexOf("aabaabaa", 'b')); 
     assertEquals(2, StringUtils.indexOf(new StringBuilder("aabaabaa"), 'b')); 
 }
@Test
public void testIndexOfIgnoreCase_StringInt495() { 
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
public void testLastIndexOf_charInt496() { 
     assertEquals(-1, StringUtils.lastIndexOf(null, ' ')); 
     assertEquals(-1, StringUtils.lastIndexOf("", ' ')); 
     assertEquals(7, StringUtils.lastIndexOf("aabaabaa", 'a')); 
     assertEquals(5, StringUtils.lastIndexOf("aabaabaa", 'b')); 
     assertEquals(5, StringUtils.lastIndexOf(new StringBuilder("aabaabaa"), 'b')); 
 }
@Test
public void testContainsIgnoreCase_String497() { 
     assertFalse(StringUtils.containsIgnoreCase(null, null)); 
     assertFalse(StringUtils.containsIgnoreCase("", null)); 
     assertFalse(StringUtils.containsIgnoreCase(null, "")); 
     assertFalse(StringUtils.containsIgnoreCase("", "a")); 
     assertFalse(StringUtils.containsIgnoreCase("", "")); 
     assertFalse(StringUtils.containsIgnoreCase("", "a")); 
     assertFalse(StringUtils.containsIgnoreCase("", "b")); 
     assertFalse(StringUtils.containsIgnoreCase("zzabyycdxx", "za")); 
     assertFalse(StringUtils.containsIgnoreCase("zzabyycdxx", "by")); 
     assertFalse(StringUtils.containsIgnoreCase("ab", "z")); 
 }
@Test
public void testContainsIgnoreCase_String498() { 
     assertFalse(StringUtils.containsIgnoreCase(null, null)); 
     assertFalse(StringUtils.containsIgnoreCase("", null)); 
     assertFalse(StringUtils.containsIgnoreCase(null, "")); 
     assertFalse(StringUtils.containsIgnoreCase("", "a")); 
     assertFalse(StringUtils.containsIgnoreCase("", "")); 
     assertFalse(StringUtils.containsIgnoreCase("", "a")); 
     assertFalse(StringUtils.containsIgnoreCase("zzabyycdxx", "")); 
     assertFalse(StringUtils.containsIgnoreCase("zzabyycdxx", "za")); 
     assertTrue(StringUtils.containsIgnoreCase("zzabyycdxx", "by")); 
     assertFalse(StringUtils.containsIgnoreCase("ab", "z")); 
 }
@Test
public void testIndexOfAny_StringCharArrayWithSupplementaryChars499() { 
     assertEquals(2, StringUtils.indexOfAny(CharU20000 + CharU20001, CharU20000.toCharArray())); 
     assertEquals(0, StringUtils.indexOfAny(CharU20000 + CharU20001, CharU20001.toCharArray())); 
     assertEquals(-1, StringUtils.indexOfAny(CharU20000, CharU20000.toCharArray())); 
     assertEquals(0, StringUtils.indexOfAny(CharU20000, CharU20001.toCharArray())); 
 }
@Test
public void testIndexOfAny_StringString500() { 
     assertEquals(-1, StringUtils.indexOfAny(null, (String) null)); 
     assertEquals(-1, StringUtils.indexOfAny(null, "")); 
     assertEquals(-1, StringUtils.indexOfAny(null, "ab")); 
     assertEquals(-1, StringUtils.indexOfAny("", (String) null)); 
     assertEquals(-1, StringUtils.indexOfAny("", "")); 
     assertEquals(-1, StringUtils.indexOfAny("", "ab")); 
     assertEquals(-1, StringUtils.indexOfAny("zzabyycdxx", (String) null)); 
     assertEquals(-1, StringUtils.indexOfAny("zzabyycdxx", "")); 
     assertEquals(0, StringUtils.indexOfAny("zzabyycdxx", "za")); 
     assertEquals(3, StringUtils.indexOfAny("zzabyycdxx", "by")); 
     assertEquals(-1, StringUtils.indexOfAny("ab", "z")); 
 }
@Test
public void testLeftPad_StringIntChar501() { 
     assertEquals(null, StringUtils.leftPad(null, 5, ' ')); 
     assertEquals("     ", StringUtils.leftPad("", 5, ' ')); 
     assertEquals("  abc", StringUtils.leftPad("abc", 5, ' ')); 
     assertEquals("xxabc", StringUtils.leftPad("abc", 5, 'x')); 
     assertEquals("\uffff\uffffabc", StringUtils.leftPad("abc", 5, '\uffff')); 
     assertEquals("abc", StringUtils.leftPad("abc", 2, ' ')); 
     final String str = StringUtils.leftPad("aaa", 10000, 'a'); 
     assertEquals(10000, str.length()); 
     assertTrue(StringUtils.containsOnly(str, new char[] { 'a' })); 
 }
@Test
public void testIndexOfAnyBut_StringStringWithSupplementaryChars502() { 
     assertEquals(2, StringUtils.indexOfAnyBut(CharU20000 + CharU20001, CharU20000)); 
     assertEquals(0, StringUtils.indexOfAnyBut(CharU20000 + CharU20001, CharU20001)); 
     assertEquals(-1, StringUtils.indexOfAnyBut(CharU20000, CharU20000)); 
     assertEquals(0, StringUtils.indexOfAnyBut(CharU20000, CharU20001)); 
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
