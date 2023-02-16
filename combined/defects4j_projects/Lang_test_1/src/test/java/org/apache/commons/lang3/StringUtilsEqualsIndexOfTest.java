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
public void testIndexOf_StringInt441() { 
     assertEquals(-1, StringUtils.indexOf(null, null, 0)); 
     assertEquals(-1, StringUtils.indexOf(null, null, -1)); 
     assertEquals(-1, StringUtils.indexOf(null, "", 0)); 
     assertEquals(-1, StringUtils.indexOf(null, "", -1)); 
     assertEquals(-1, StringUtils.indexOf("", null, 0)); 
     assertEquals(-1, StringUtils.indexOf("", null, -1)); 
     assertEquals(0, StringUtils.indexOf("", null, 0)); 
     assertEquals(0, StringUtils.indexOf("", "", 0)); 
     assertEquals(-1, StringUtils.indexOf("", "", -1)); 
     assertEquals(0, StringUtils.indexOf("", "", 9)); 
     assertEquals(0, StringUtils.indexOf("abc", "", 0)); 
     assertEquals(-1, StringUtils.indexOf("abc", "", -1)); 
     assertEquals(3, StringUtils.indexOf("abc", "", 9)); 
     assertEquals(7, StringUtils.indexOf("aabaabaa", "a", 8)); 
     assertEquals(5, StringUtils.indexOf("aabaabaa", "b", 8)); 
     assertEquals(4, StringUtils.indexOf("aabaabaa", "ab", 8)); 
     assertEquals(2, StringUtils.indexOf("aabaabaa", "b", 3)); 
     assertEquals(5, StringUtils.indexOf("aabaabaa", "b", 9)); 
     assertEquals(-1, StringUtils.indexOf("aabaabaa", "b", -1)); 
     assertEquals(-1, StringUtils.indexOf("aabaabaa", "b", 0)); 
     assertEquals(-1, StringUtils.indexOf("aabaabaa", "b", -1)); 
     assertEquals(0, StringUtils.indexOf("aabaabaa", "a", 0)); 
     assertEquals(-1, StringUtils.indexOf("aabaabaa", "a", -1));
}

@Test
public void testLastIndexOf_String444() { 
     assertEquals(-1, StringUtils.lastIndexOf(null, null)); 
     assertEquals(-1, StringUtils.lastIndexOf("", null)); 
     assertEquals(-1, StringUtils.lastIndexOf(null, "")); 
     assertEquals(-1, StringUtils.lastIndexOf("", "a")); 
     assertEquals(0, StringUtils.lastIndexOf("", "")); 
     assertEquals(8, StringUtils.lastIndexOf("aabaabaa", "")); 
     assertEquals(7, StringUtils.lastIndexOf("aabaabaa", "a")); 
     assertEquals(7, StringUtils.lastIndexOf("aabaabaa", "A")); 
     assertEquals(5, StringUtils.lastIndexOf("aabaabaa", "b")); 
     assertEquals(5, StringUtils.lastIndexOf("aabaabaa", "B")); 
     assertEquals(4, StringUtils.lastIndexOf("aabaabaa", "ab")); 
     assertEquals(4, StringUtils.lastIndexOf("aabaabaa", "AB")); 
     assertEquals(-1, StringUtils.lastIndexOf("ab", "AAB")); 
     assertEquals(0, StringUtils.lastIndexOf("aab", "AAB")); 
 }
@Test
public void testContainsAny_StringString445() { 
     assertFalse(StringUtils.containsAny(null, (String) null)); 
     assertFalse(StringUtils.containsAny(null, "")); 
     assertFalse(StringUtils.containsAny(null, "ab")); 
     assertFalse(StringUtils.containsAny("", (String) null)); 
     assertFalse(StringUtils.containsAny("", "")); 
     assertFalse(StringUtils.containsAny("", "ab")); 
     assertFalse(StringUtils.containsAny("zzabyycdxx", (String) null)); 
     assertFalse(StringUtils.containsAny("zzabyycdxx", "")); 
     assertTrue(StringUtils.containsAny("zzabyycdxx", "za")); 
     assertTrue(StringUtils.containsAny("zzabyycdxx", "by")); 
     assertFalse(StringUtils.containsAny("ab", "z")); 
 }
@Test
public void testIndexOfAnyBut_StringString446() { 
     assertEquals(-1, StringUtils.indexOfAnyBut(null, (String) null)); 
     assertEquals(-1, StringUtils.indexOfAnyBut(null, "")); 
     assertEquals(-1, StringUtils.indexOfAnyBut(null, "ab")); 
     assertEquals(-1, StringUtils.indexOfAnyBut("", (String) null)); 
     assertEquals(-1, StringUtils.indexOfAnyBut("", "")); 
     assertEquals(-1, StringUtils.indexOfAnyBut("", "ab")); 
     assertEquals(-1, StringUtils.indexOfAnyBut("zzabyycdxx", (String) null)); 
     assertEquals(-1, StringUtils.indexOfAnyBut("zzabyycdxx", "")); 
     assertEquals(3, StringUtils.indexOfAnyBut("zzabyycdxx", "za")); 
     assertEquals(0, StringUtils.indexOfAnyBut("zzabyycdxx", "by")); 
     assertEquals(0, StringUtils.indexOfAnyBut("ab", "z")); 
 }
@Test
public void testContainsNone_StringWithBadSupplementaryChars447() { 
     assertTrue(StringUtils.containsNone(CharUSuppCharHigh, CharU20001)); 
     assertEquals(-1, CharUSuppCharLow.indexOf(CharU20001)); 
     assertTrue(StringUtils.containsNone(CharUSuppCharLow, CharU20001)); 
     assertEquals(-1, CharU20001.indexOf(CharUSuppCharHigh)); 
     assertTrue(StringUtils.containsNone(CharU20001, CharUSuppCharHigh)); 
     assertEquals(0, CharU20001.indexOf(CharUSuppCharLow)); 
     assertFalse(StringUtils.containsNone(CharU20001, CharUSuppCharLow)); 
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
