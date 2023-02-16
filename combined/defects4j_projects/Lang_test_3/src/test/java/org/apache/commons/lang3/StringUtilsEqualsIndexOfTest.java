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
public void testIndexOf_charInt139() { 
     assertEquals(-1, StringUtils.indexOf(null, ' ', 0)); 
     assertEquals(-1, StringUtils.indexOf(null, ' ', -1)); 
     assertEquals(-1, StringUtils.indexOf("", ' ', 0)); 
     assertEquals(-1, StringUtils.indexOf("", ' ', -1)); 
     assertEquals(0, StringUtils.indexOf("aabaabaa", 'a', 0)); 
     assertEquals(2, StringUtils.indexOf("aabaabaa", 'b', 0)); 
     assertEquals(5, StringUtils.indexOf("aabaabaa", 'b', 3)); 
     assertEquals(-1, StringUtils.indexOf("aabaabaa", 'b', 9)); 
     assertEquals(2, StringUtils.indexOf("aabaabaa", 'b', -1)); 
     assertEquals(5, StringUtils.indexOf(new StringBuilder("aabaabaa"), 'b', 3)); 
 }
@Test
public void testLastIndexOf_char140() { 
     assertEquals(-1, StringUtils.lastIndexOf(null, ' ')); 
     assertEquals(-1, StringUtils.lastIndexOf("", ' ')); 
     assertEquals(7, StringUtils.lastIndexOf("aabaabaa", 'a')); 
     assertEquals(5, StringUtils.lastIndexOf("aabaabaa", 'b')); 
     assertEquals(5, StringUtils.lastIndexOf(new StringBuilder("aabaabaa"), 'b')); 
 }
@Test
public void testEqualsOnStrings470() { 
     assertTrue(StringUtils.equals(null, null)); 
     assertTrue(StringUtils.equals(FOO, FOO)); 
     assertTrue(StringUtils.equals(FOO, new String(new char[] { 'f', 'o', 'o' }))); 
     assertFalse(StringUtils.equals(FOO, new String(new char[] { 'f', 'O', 'O' }))); 
     assertFalse(StringUtils.equals(FOO, BAR)); 
     assertFalse(StringUtils.equals(FOO, null)); 
     assertFalse(StringUtils.equals(null, FOO)); 
     assertFalse(StringUtils.equals(FOO, FOOBAR)); 
     assertFalse(StringUtils.equals(FOOBAR, FOO)); 
 }
@Test
public void testIndexOf_char471() { 
     assertEquals(-1, StringUtils.indexOf(null, ' ')); 
     assertEquals(-1, StringUtils.indexOf("", ' ')); 
     assertEquals(0, StringUtils.indexOf("aabaabaa", 'a')); 
     assertEquals(2, StringUtils.indexOf("aabaabaa", 'b')); 
     assertEquals(5, StringUtils.indexOf("aabaabaa", 'b')); 
     assertEquals(-1, StringUtils.indexOf("aabaabaa", 'z')); 
 }
@Test
public void testLastOrdinalIndexOf472() { 
     assertEquals(-1, StringUtils.lastOrdinalIndexOf(null, "*", 42)); 
     assertEquals(-1, StringUtils.lastOrdinalIndexOf("*", null, 42)); 
     assertEquals(0, StringUtils.lastOrdinalIndexOf("", "", 42)); 
     assertEquals(7, StringUtils.lastOrdinalIndexOf("aabaabaa", "a", 1)); 
     assertEquals(6, StringUtils.lastOrdinalIndexOf("aabaabaa", "a", 2)); 
     assertEquals(5, StringUtils.lastOrdinalIndexOf("aabaabaa", "b", 1)); 
     assertEquals(2, StringUtils.lastOrdinalIndexOf("aabaabaa", "b", 2)); 
     assertEquals(4, StringUtils.lastOrdinalIndexOf("aabaabaa", "ab", 1)); 
     assertEquals(1, StringUtils.lastOrdinalIndexOf("aabaabaa", "ab", 2)); 
     assertEquals(8, StringUtils.lastOrdinalIndexOf("aabaabaa", "", 1)); 
     assertEquals(8, StringUtils.lastOrdinalIndexOf("aabaabaa", "", 2)); 
 }
@Test
public void testIndexOfIgnoreCase_String473() { 
     assertEquals(-1, StringUtils.indexOfIgnoreCase(null, null)); 
     assertEquals(-1, StringUtils.indexOfIgnoreCase(null, "")); 
     assertEquals(-1, StringUtils.indexOfIgnoreCase("", null)); 
     assertEquals(0, StringUtils.indexOfIgnoreCase("", "")); 
     assertEquals(0, StringUtils.indexOfIgnoreCase("aabaabaa", "a")); 
     assertEquals(0, StringUtils.indexOfIgnoreCase("aabaabaa", "A")); 
     assertEquals(2, StringUtils.indexOfIgnoreCase("aabaabaa", "b")); 
     assertEquals(2, StringUtils.indexOfIgnoreCase("aabaabaa", "B")); 
     assertEquals(1, StringUtils.indexOfIgnoreCase("aabaabaa", "ab")); 
     assertEquals(1, StringUtils.indexOfIgnoreCase("aabaabaa", "AB")); 
     assertEquals(0, StringUtils.indexOfIgnoreCase("aabaabaa", "")); 
 }
@Test
public void testLastIndexOf_StringInt474() { 
     assertEquals(-1, StringUtils.lastIndexOf(null, null, 0)); 
     assertEquals(-1, StringUtils.lastIndexOf(null, null, -1)); 
     assertEquals(-1, StringUtils.lastIndexOf(null, "", 0)); 
     assertEquals(-1, StringUtils.lastIndexOf(null, "", -1)); 
     assertEquals(-1, StringUtils.lastIndexOf("", null, 0)); 
     assertEquals(-1, StringUtils.lastIndexOf("", null, -1)); 
     assertEquals(0, StringUtils.lastIndexOf("", "", 0)); 
     assertEquals(8, StringUtils.lastIndexOf("", "", -1)); 
     assertEquals(7, StringUtils.lastIndexOf("aabaabaa", "", 8)); 
     assertEquals(7, StringUtils.lastIndexOf("aabaabaa", "", 7)); 
     assertEquals(5, StringUtils.lastIndexOf("aabaabaa", "", 6)); 
     assertEquals(5, StringUtils.lastIndexOf("aabaabaa", "", 8)); 
     assertEquals(-1, StringUtils.lastIndexOf("aabaabaa", "", 9)); 
     assertEquals(-1, StringUtils.lastIndexOf("aabaabaa", "", -1)); 
     assertEquals(0, StringUtils.lastIndexOf("aabaabaa", "", 0)); 
     assertEquals(2, StringUtils.lastIndexOf("aabaabaa", "", 2)); 
     assertEquals(5, StringUtils.lastIndexOf("aabaabaa", "", 3)); 
     assertEquals(-1, StringUtils.lastIndexOf("aabaabaa", "", 4)); 
     assertEquals(-1, StringUtils.lastIndexOf("aabaabaa", "", 5)); 
     assertEquals(-1, StringUtils.lastIndexOf("aabaabaa", "", 6)); 
     assertEquals(-1, StringUtils.lastIndexOf("aabaabaa", "", 7)); 
     assertEquals(-1, StringUtils.lastIndexOf("aabaabaa", "", 8));
}

@Test
public void testLastIndexOf_StringInt475() { 
     assertEquals(-1, StringUtils.lastIndexOf(null, null, 0)); 
     assertEquals(-1, StringUtils.lastIndexOf(null, null, -1)); 
     assertEquals(-1, StringUtils.lastIndexOf(null, "", 0)); 
     assertEquals(-1, StringUtils.lastIndexOf(null, "", -1)); 
     assertEquals(-1, StringUtils.lastIndexOf("", null, 0)); 
     assertEquals(-1, StringUtils.lastIndexOf("", null, -1)); 
     assertEquals(0, StringUtils.lastIndexOf("", "", 0)); 
     assertEquals(8, StringUtils.lastIndexOf("", "", -1)); 
     assertEquals(7, StringUtils.lastIndexOf("aabaabaa", "", 8)); 
     assertEquals(5, StringUtils.lastIndexOf("aabaabaa", "", 7)); 
     assertEquals(5, StringUtils.lastIndexOf("aabaabaa", "", 8)); 
     assertEquals(-1, StringUtils.lastIndexOf("aabaabaa", "", 9)); 
     assertEquals(-1, StringUtils.lastIndexOf("aabaabaa", "", -1)); 
     assertEquals(0, StringUtils.lastIndexOf("aabaabaa", "", 0)); 
     assertEquals(2, StringUtils.lastIndexOf("aabaabaa", "", 2)); 
     assertEquals(5, StringUtils.lastIndexOf("aabaabaa", "", 3)); 
     assertEquals(-1, StringUtils.lastIndexOf("aabaabaa", "", 4)); 
     assertEquals(-1, StringUtils.lastIndexOf("aabaabaa", "", 5)); 
     assertEquals(-1, StringUtils.lastIndexOf("aabaabaa", "", 6)); 
     assertEquals(-1, StringUtils.lastIndexOf("aabaabaa", "", 7)); 
     assertEquals(-1, StringUtils.lastIndexOf("aabaabaa", "", 8)); 
     assertEquals(-1, StringUtils.lastIndexOf("aabaabaa", "", 9));
}

@Test
public void testContainsAny_StringCharArrayWithBadSupplementaryChars476() { 
     assertFalse(StringUtils.containsAny(CharUSuppCharHigh, CharU20001.toCharArray())); 
     assertFalse(StringUtils.containsAny("abc" + CharUSuppCharHigh + "xyz", CharU20001.toCharArray())); 
     assertEquals(-1, CharUSuppCharLow.indexOf(CharU20001)); 
     assertFalse(StringUtils.containsAny(CharUSuppCharLow, CharU20001.toCharArray())); 
     assertFalse(StringUtils.containsAny(CharU20001, CharUSuppCharHigh.toCharArray())); 
     assertEquals(0, CharU20001.indexOf(CharUSuppCharLow)); 
     assertTrue(StringUtils.containsAny(CharU20001, CharUSuppCharLow.toCharArray())); 
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
