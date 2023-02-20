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
public void testIndexOf_charInt258() { 
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
public void testOrdinalIndexOf259() { 
     assertEquals(-1, StringUtils.ordinalIndexOf(null, null, Integer.MIN_VALUE)); 
     assertEquals(-1, StringUtils.ordinalIndexOf("", null, Integer.MIN_VALUE)); 
     assertEquals(-1, StringUtils.ordinalIndexOf("", "", Integer.MIN_VALUE)); 
     assertEquals(-1, StringUtils.ordinalIndexOf("aabaabaa", "a", Integer.MIN_VALUE)); 
     assertEquals(-1, StringUtils.ordinalIndexOf("aabaabaa", "b", Integer.MIN_VALUE)); 
     assertEquals(-1, StringUtils.ordinalIndexOf("aabaabaa", "ab", Integer.MIN_VALUE)); 
     assertEquals(-1, StringUtils.ordinalIndexOf("aabaabaa", "", Integer.MIN_VALUE)); 
     assertEquals(-1, StringUtils.ordinalIndexOf(null, null, -1)); 
     assertEquals(-1, StringUtils.ordinalIndexOf("", null, -1)); 
     assertEquals(-1, StringUtils.ordinalIndexOf("", "", -1)); 
     assertEquals(-1, StringUtils.ordinalIndexOf("aabaabaa", "a", -1)); 
     assertEquals(-1, StringUtils.ordinalIndexOf("aabaabaa", "b", -1)); 
     assertEquals(-1, StringUtils.ordinalIndexOf("aabaabaa", "ab", -1)); 
     assertEquals(-1, StringUtils.ordinalIndexOf("aabaabaa", "", -1)); 
     assertEquals(-1, StringUtils.ordinalIndexOf(null, null, 0)); 
     assertEquals(-1, StringUtils.ordinalIndexOf("", null, 0)); 
     assertEquals(-1, StringUtils.ordinalIndexOf("", "", 0)); 
     assertEquals(-1, StringUtils.ordinalIndexOf("aabaabaa", "a", 0)); 
     assertEquals(-1, StringUtils.ordinalIndexOf("aabaabaa", "b", 0)); 
     assertEquals(-1, StringUtils.ordinalIndexOf("aabaabaa", "ab", 0)); 
     assertEquals(-1, StringUtils.ordinalIndexOf("aabaabaa", "", 0)); 
     assertEquals(-1, StringUtils.ordinalIndexOf(null, null, 1)); 
     assertEquals(-1, StringUtils.ordinalIndexOf("", null, 1)); 
     assertEquals(0, StringUtils.ordinalIndexOf("", "", 1)); 
     assertEquals(0, StringUtils.ordinalIndexOf("aabaabaa", "a", 1)); 
     assertEquals(2, StringUtils.ordinalIndexOf("aabaabaa", "b", 1)); 
     assertEquals(1, StringUtils.ordinalIndexOf("aabaabaa", "ab", 1)); 
     assertEquals(0, StringUtils.ordinalIndexOf("aabaabaa", "", 1)); 
     assertEquals(-1, StringUtils.ordinalIndexOf(null, null, 2)); 
     assertEquals(-1, StringUtils.ordinalIndexOf("", null, 2)); 
     assertEquals(0, StringUtils.ordinalIndexOf("", "", 2)); 
     assertEquals(1, StringUtils.ordinalIndexOf("aabaabaa", "a", 2)); 
     assertEquals(5, StringUtils.ordinalIndexOf("aabaabaa", "b", 2)); 
     assertEquals(4, StringUtils.ordinalIndexOf("aabaabaa", "ab", 2)); 
     assertEquals(0, StringUtils.ordinalIndexOf("aabaabaa", "", 2)); 
     assertEquals(-1, StringUtils.ordinalIndexOf(null, null, Integer.MAX_VALUE)); 
     assertEquals(-1, StringUtils.ordinalIndexOf("", null, Integer.MAX_VALUE)); 
     assertEquals(0, StringUtils.ordinalIndexOf("", "", Integer.MAX_VALUE)); 
     assertEquals(-1, StringUtils.ordinalIndexOf("aabaabaa", "a", Integer.MAX_VALUE)); 
     assertEquals(-1, StringUtils.ordinalIndexOf("aabaabaa", "b", Integer.MAX_VALUE)); 
     assertEquals(-1, StringUtils.ordinalIndexOf("aabaabaa", "ab", Integer.MAX_VALUE)); 
     assertEquals(0, StringUtils.ordinalIndexOf("aabaabaa", "", Integer.MAX_VALUE)); 
     assertEquals(-1, StringUtils.ordinalIndexOf("aaaaaaaaa", "a", 0)); 
     assertEquals(0, StringUtils.ordinalIndexOf("aaaaaaaaa", "a", 1)); 
     assertEquals(1, StringUtils.ordinalIndexOf("aaaaaaaaa", "a", 2)); 
     assertEquals(2, StringUtils.ordinalIndexOf("aaaaaaaaa", "a", 3)); 
     assertEquals(3, StringUtils.ordinalIndexOf("aaaaaaaaa", "a", 4)); 
     assertEquals(4, StringUtils.ordinalIndexOf("aaaaaaaaa", "a", 5)); 
     assertEquals(5, StringUtils.ordinalIndexOf("aaaaaaaaa", "a", 6)); 
     assertEquals(6, StringUtils.ordinalIndexOf("aaaaaaaaa", "a", 7)); 
     assertEquals(7, StringUtils.ordinalIndexOf("aaaaaaaaa", "a", 8)); 
     assertEquals(8, StringUtils.ordinalIndexOf("aaaaaaaaa", "a", 9)); 
     assertEquals(-1, StringUtils.ordinalIndexOf("aaaaaaaaa", "a", 10)); 
 }
@Test
public void testLastIndexOf_char260() { 
     assertEquals(-1, StringUtils.lastIndexOf(null, ' ')); 
     assertEquals(-1, StringUtils.lastIndexOf("", ' ')); 
     assertEquals(7, StringUtils.lastIndexOf("aabaabaa", 'a')); 
     assertEquals(5, StringUtils.lastIndexOf("aabaabaa", 'b')); 
     assertEquals(5, StringUtils.lastIndexOf(new StringBuilder("aabaabaa"), 'b')); 
 }
@Test
public void testLastIndexOf_StringInt261() { 
     assertEquals(-1, StringUtils.lastIndexOf(null, null, 0)); 
     assertEquals(-1, StringUtils.lastIndexOf(null, null, -1)); 
     assertEquals(-1, StringUtils.lastIndexOf(null, "", 0)); 
     assertEquals(-1, StringUtils.lastIndexOf(null, "", -1)); 
     assertEquals(-1, StringUtils.lastIndexOf("", null, 0)); 
     assertEquals(-1, StringUtils.lastIndexOf("", null, -1)); 
     assertEquals(0, StringUtils.lastIndexOf("", "", 0)); 
     assertEquals(-1, StringUtils.lastIndexOf("", "", -1)); 
     assertEquals(0, StringUtils.lastIndexOf("", "", 9)); 
     assertEquals(0, StringUtils.lastIndexOf("abc", "", 0)); 
     assertEquals(-1, StringUtils.lastIndexOf("abc", "", -1)); 
     assertEquals(3, StringUtils.lastIndexOf("abc", "", 9)); 
     assertEquals(7, StringUtils.lastIndexOf("aabaabaa", "a", 8)); 
     assertEquals(5, StringUtils.lastIndexOf("aabaabaa", "b", 8)); 
     assertEquals(4, StringUtils.lastIndexOf("aabaabaa", "ab", 8)); 
     assertEquals(2, StringUtils.lastIndexOf("aabaabaa", "b", 3)); 
     assertEquals(5, StringUtils.lastIndexOf("aabaabaa", "b", 9)); 
     assertEquals(-1, StringUtils.lastIndexOf("aabaabaa", "b", -1)); 
     assertEquals(-1, StringUtils.lastIndexOf("aabaabaa", "b", 0)); 
     assertEquals(0, StringUtils.lastIndexOf("aabaabaa", "a", 0)); 
     assertEquals(-1, StringUtils.lastIndexOf("aabaabaa", "a", -1)); 
     assertEquals(7, StringUtils.lastIndexOf("12345678", "8", 9)); 
     assertEquals(7, StringUtils.lastIndexOf("12345678", "8", 8)); 
     assertEquals(7, StringUtils.lastIndexOf("12345678", "8", 7)); 
     assertEquals(-1, StringUtils.lastIndexOf("12345678", "8", 6)); 
     assertEquals(-1, StringUtils.lastIndexOf("aabaabaa", "b", 1)); 
     assertEquals(2, StringUtils.lastIndexOf("aabaabaa", "b", 2)); 
     assertEquals(2, StringUtils.lastIndexOf("aabaabaa", "ba", 2)); 
     assertEquals(2, StringUtils.lastIndexOf("aabaabaa", "ba", 3)); 
     assertEquals(2, StringUtils.lastIndexOf(new StringBuilder("aabaabaa"), "b", 3)); 
 }
@Test
public void testContainsAny_StringString262() { 
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
public void testEquals989() { 
     final CharSequence fooCs = FOO, barCs = BAR, foobarCs = FOOBAR; 
     assertTrue(StringUtils.equals(null, null)); 
     assertTrue(StringUtils.equals(fooCs, fooCs)); 
     assertTrue(StringUtils.equals(fooCs, new StringBuilder(FOO))); 
     assertTrue(StringUtils.equals(fooCs, new String(new char[] { 'f', 'o', 'o' }))); 
     assertTrue(StringUtils.equals(fooCs, new CustomCharSequence(FOO))); 
     assertTrue(StringUtils.equals(new CustomCharSequence(FOO), fooCs)); 
     assertFalse(StringUtils.equals(fooCs, new String(new char[] { 'f', 'O', 'O' }))); 
     assertFalse(StringUtils.equals(fooCs, barCs)); 
     assertFalse(StringUtils.equals(fooCs, null)); 
     assertFalse(StringUtils.equals(null, fooCs)); 
     assertFalse(StringUtils.equals(fooCs, foobarCs)); 
     assertFalse(StringUtils.equals(foobarCs, fooCs)); 
 }
@Test
public void testEqualsIgnoreCase990() { 
     assertTrue(StringUtils.equalsIgnoreCase(null, null)); 
     assertTrue(StringUtils.equalsIgnoreCase(FOO, FOO)); 
     assertTrue(StringUtils.equalsIgnoreCase(FOO, new String(new char[] { 'f', 'o', 'o' }))); 
     assertTrue(StringUtils.equalsIgnoreCase(FOO, new String(new char[] { 'f', 'O', 'O' }))); 
     assertFalse(StringUtils.equalsIgnoreCase(FOO, BAR)); 
     assertFalse(StringUtils.equalsIgnoreCase(FOO, null)); 
     assertFalse(StringUtils.equalsIgnoreCase(null, FOO)); 
     assertTrue(StringUtils.equalsIgnoreCase("", "")); 
     assertFalse(StringUtils.equalsIgnoreCase("abcd", "abcd ")); 
 }
@Test
public void testIndexOf_char991() { 
     assertEquals(-1, StringUtils.indexOf(null, ' ')); 
     assertEquals(-1, StringUtils.indexOf("", ' ')); 
     assertEquals(0, StringUtils.indexOf("aabaabaa", 'a')); 
     assertEquals(2, StringUtils.indexOf("aabaabaa", 'b')); 
     assertEquals(2, StringUtils.indexOf(new StringBuilder("aabaabaa"), 'b')); 
 }
@Test
public void testIndexOf_String992() { 
     assertEquals(-1, StringUtils.indexOf(null, null)); 
     assertEquals(-1, StringUtils.indexOf("", null)); 
     assertEquals(0, StringUtils.indexOf("", "")); 
     assertEquals(0, StringUtils.indexOf("aabaabaa", "a")); 
     assertEquals(2, StringUtils.indexOf("aabaabaa", "b")); 
     assertEquals(1, StringUtils.indexOf("aabaabaa", "ab")); 
     assertEquals(0, StringUtils.indexOf("aabaabaa", "")); 
     assertEquals(2, StringUtils.indexOf(new StringBuilder("aabaabaa"), "b")); 
 }
@Test
public void testIndexOf_StringInt993() { 
     assertEquals(-1, StringUtils.indexOf(null, null, 0)); 
     assertEquals(-1, StringUtils.indexOf(null, null, -1)); 
     assertEquals(-1, StringUtils.indexOf(null, "", 0)); 
     assertEquals(-1, StringUtils.indexOf(null, "", -1)); 
     assertEquals(-1, StringUtils.indexOf("", null, 0)); 
     assertEquals(-1, StringUtils.indexOf("", null, -1)); 
     assertEquals(0, StringUtils.indexOf("", "", 0)); 
     assertEquals(0, StringUtils.indexOf("", "", -1)); 
     assertEquals(0, StringUtils.indexOf("", "", 9)); 
     assertEquals(0, StringUtils.indexOf("abc", "", 0)); 
     assertEquals(0, StringUtils.indexOf("abc", "", -1)); 
     assertEquals(3, StringUtils.indexOf("abc", "", 9)); 
     assertEquals(3, StringUtils.indexOf("abc", "", 3)); 
     assertEquals(0, StringUtils.indexOf("aabaabaa", "a", 0)); 
     assertEquals(2, StringUtils.indexOf("aabaabaa", "b", 0)); 
     assertEquals(1, StringUtils.indexOf("aabaabaa", "ab", 0)); 
     assertEquals(5, StringUtils.indexOf("aabaabaa", "b", 3)); 
     assertEquals(-1, StringUtils.indexOf("aabaabaa", "b", 9)); 
     assertEquals(2, StringUtils.indexOf("aabaabaa", "b", -1)); 
     assertEquals(2, StringUtils.indexOf("aabaabaa", "", 2)); 
     assertEquals(7, StringUtils.indexOf("12345678", "8", 5)); 
     assertEquals(7, StringUtils.indexOf("12345678", "8", 6)); 
     assertEquals(7, StringUtils.indexOf("12345678", "8", 7)); 
     assertEquals(-1, StringUtils.indexOf("12345678", "8", 8)); 
     assertEquals(5, StringUtils.indexOf(new StringBuilder("aabaabaa"), "b", 3)); 
 }
@Test
public void testIndexOfIgnoreCase_String994() { 
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
public void testIndexOfIgnoreCase_StringInt995() { 
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
public void testLastIndexOf_charInt996() { 
     assertEquals(-1, StringUtils.lastIndexOf(null, ' ', 0)); 
     assertEquals(-1, StringUtils.lastIndexOf(null, ' ', -1)); 
     assertEquals(-1, StringUtils.lastIndexOf("", ' ', 0)); 
     assertEquals(-1, StringUtils.lastIndexOf("", ' ', -1)); 
     assertEquals(7, StringUtils.lastIndexOf("aabaabaa", 'a', 8)); 
     assertEquals(5, StringUtils.lastIndexOf("aabaabaa", 'b', 8)); 
     assertEquals(2, StringUtils.lastIndexOf("aabaabaa", 'b', 3)); 
     assertEquals(5, StringUtils.lastIndexOf("aabaabaa", 'b', 9)); 
     assertEquals(-1, StringUtils.lastIndexOf("aabaabaa", 'b', -1)); 
     assertEquals(0, StringUtils.lastIndexOf("aabaabaa", 'a', 0)); 
     assertEquals(2, StringUtils.lastIndexOf(new StringBuilder("aabaabaa"), 'b', 2)); 
 }
@Test
public void testLastIndexOf_String997() { 
     assertEquals(-1, StringUtils.lastIndexOf(null, null)); 
     assertEquals(-1, StringUtils.lastIndexOf("", null)); 
     assertEquals(-1, StringUtils.lastIndexOf("", "a")); 
     assertEquals(0, StringUtils.lastIndexOf("", "")); 
     assertEquals(8, StringUtils.lastIndexOf("aabaabaa", "")); 
     assertEquals(7, StringUtils.lastIndexOf("aabaabaa", "a")); 
     assertEquals(5, StringUtils.lastIndexOf("aabaabaa", "b")); 
     assertEquals(4, StringUtils.lastIndexOf("aabaabaa", "ab")); 
     assertEquals(4, StringUtils.lastIndexOf(new StringBuilder("aabaabaa"), "ab")); 
 }
@Test
public void testLastIndexOfIgnoreCase_String998() { 
     assertEquals(-1, StringUtils.lastIndexOfIgnoreCase(null, null)); 
     assertEquals(-1, StringUtils.lastIndexOfIgnoreCase("", null)); 
     assertEquals(-1, StringUtils.lastIndexOfIgnoreCase(null, "")); 
     assertEquals(-1, StringUtils.lastIndexOfIgnoreCase("", "a")); 
     assertEquals(0, StringUtils.lastIndexOfIgnoreCase("", "")); 
     assertEquals(8, StringUtils.lastIndexOfIgnoreCase("aabaabaa", "")); 
     assertEquals(7, StringUtils.lastIndexOfIgnoreCase("aabaabaa", "a")); 
     assertEquals(7, StringUtils.lastIndexOfIgnoreCase("aabaabaa", "A")); 
     assertEquals(5, StringUtils.lastIndexOfIgnoreCase("aabaabaa", "b")); 
     assertEquals(5, StringUtils.lastIndexOfIgnoreCase("aabaabaa", "B")); 
     assertEquals(4, StringUtils.lastIndexOfIgnoreCase("aabaabaa", "ab")); 
     assertEquals(4, StringUtils.lastIndexOfIgnoreCase("aabaabaa", "AB")); 
     assertEquals(-1, StringUtils.lastIndexOfIgnoreCase("ab", "AAB")); 
     assertEquals(0, StringUtils.lastIndexOfIgnoreCase("aab", "AAB")); 
 }
@Test
public void testContains_Char999() { 
     assertFalse(StringUtils.contains(null, ' ')); 
     assertFalse(StringUtils.contains("", ' ')); 
     assertFalse(StringUtils.contains("", null)); 
     assertFalse(StringUtils.contains(null, null)); 
     assertTrue(StringUtils.contains("abc", 'a')); 
     assertTrue(StringUtils.contains("abc", 'b')); 
     assertTrue(StringUtils.contains("abc", 'c')); 
     assertFalse(StringUtils.contains("abc", 'z')); 
 }
@Test
public void testContainsIgnoreCase_StringString1000() { 
     assertFalse(StringUtils.containsIgnoreCase(null, null)); 
     assertFalse(StringUtils.containsIgnoreCase(null, "")); 
     assertFalse(StringUtils.containsIgnoreCase(null, "a")); 
     assertFalse(StringUtils.containsIgnoreCase(null, "abc")); 
     assertFalse(StringUtils.containsIgnoreCase("", null)); 
     assertFalse(StringUtils.containsIgnoreCase("a", null)); 
     assertFalse(StringUtils.containsIgnoreCase("abc", null)); 
     assertTrue(StringUtils.containsIgnoreCase("", "")); 
     assertTrue(StringUtils.containsIgnoreCase("a", "")); 
     assertTrue(StringUtils.containsIgnoreCase("abc", "")); 
     assertFalse(StringUtils.containsIgnoreCase("", "a")); 
     assertTrue(StringUtils.containsIgnoreCase("a", "a")); 
     assertTrue(StringUtils.containsIgnoreCase("abc", "a")); 
     assertFalse(StringUtils.containsIgnoreCase("", "A")); 
     assertTrue(StringUtils.containsIgnoreCase("a", "A")); 
     assertTrue(StringUtils.containsIgnoreCase("abc", "A")); 
     assertFalse(StringUtils.containsIgnoreCase("", "abc")); 
     assertFalse(StringUtils.containsIgnoreCase("a", "abc")); 
     assertTrue(StringUtils.containsIgnoreCase("xabcz", "abc")); 
     assertFalse(StringUtils.containsIgnoreCase("", "ABC")); 
     assertFalse(StringUtils.containsIgnoreCase("a", "ABC")); 
     assertTrue(StringUtils.containsIgnoreCase("xabcz", "ABC")); 
 }
@Test
public void testIndexOfAny_StringStringWithSupplementaryChars1001() { 
     assertEquals(0, StringUtils.indexOfAny(CharU20000 + CharU20001, CharU20000)); 
     assertEquals(2, StringUtils.indexOfAny(CharU20000 + CharU20001, CharU20001)); 
     assertEquals(0, StringUtils.indexOfAny(CharU20000, CharU20000)); 
     assertEquals(-1, StringUtils.indexOfAny(CharU20000, CharU20001)); 
 }
@Test
public void testIndexOfAny_StringCharArray1002() { 
     assertEquals(-1, StringUtils.indexOfAny(null, (char[]) null)); 
     assertEquals(-1, StringUtils.indexOfAny(null, new char[0])); 
     assertEquals(-1, StringUtils.indexOfAny(null, new char[] { 'a', 'b' })); 
     assertEquals(-1, StringUtils.indexOfAny("", (char[]) null)); 
     assertEquals(-1, StringUtils.indexOfAny("", new char[0])); 
     assertEquals(-1, StringUtils.indexOfAny("", new char[] { 'a', 'b' })); 
     assertEquals(-1, StringUtils.indexOfAny("zzabyycdxx", (char[]) null)); 
     assertEquals(-1, StringUtils.indexOfAny("zzabyycdxx", new char[0])); 
     assertEquals(0, StringUtils.indexOfAny("zzabyycdxx", new char[] { 'z', 'a' })); 
     assertEquals(3, StringUtils.indexOfAny("zzabyycdxx", new char[] { 'b', 'y' })); 
     assertEquals(-1, StringUtils.indexOfAny("ab", new char[] { 'z' })); 
 }
@Test
public void testIndexOfAny_StringString1003() { 
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
public void testContainsAny_StringCharArrayWithBadSupplementaryChars1004() { 
     assertFalse(StringUtils.containsAny(CharUSuppCharHigh, CharU20001.toCharArray())); 
     assertFalse(StringUtils.containsAny("abc" + CharUSuppCharHigh + "xyz", CharU20001.toCharArray())); 
     assertEquals(-1, CharUSuppCharLow.indexOf(CharU20001)); 
     assertFalse(StringUtils.containsAny(CharUSuppCharLow, CharU20001.toCharArray())); 
     assertFalse(StringUtils.containsAny(CharU20001, CharUSuppCharHigh.toCharArray())); 
     assertEquals(0, CharU20001.indexOf(CharUSuppCharLow)); 
     assertTrue(StringUtils.containsAny(CharU20001, CharUSuppCharLow.toCharArray())); 
 }
@Test
public void testContainsAny_StringWithSupplementaryChars1005() { 
     assertTrue(StringUtils.containsAny(CharU20000 + CharU20001, CharU20000)); 
     assertTrue(StringUtils.containsAny(CharU20000 + CharU20001, CharU20001)); 
     assertTrue(StringUtils.containsAny(CharU20000, CharU20000)); 
     assertEquals(-1, CharU20000.indexOf(CharU20001)); 
     assertEquals(0, CharU20000.indexOf(CharU20001.charAt(0))); 
     assertEquals(-1, CharU20000.indexOf(CharU20001.charAt(1))); 
     assertFalse(StringUtils.containsAny(CharU20000, CharU20001)); 
     assertFalse(StringUtils.containsAny(CharU20001, CharU20000)); 
 }
@Test
public void testIndexOfAnyBut_StringCharArray1007() { 
     assertEquals(-1, StringUtils.indexOfAnyBut(null, (char[]) null)); 
     assertEquals(-1, StringUtils.indexOfAnyBut(null, new char[0])); 
     assertEquals(-1, StringUtils.indexOfAnyBut(null, new char[] { 'a', 'b' })); 
     assertEquals(-1, StringUtils.indexOfAnyBut("", (char[]) null)); 
     assertEquals(-1, StringUtils.indexOfAnyBut("", new char[0])); 
     assertEquals(-1, StringUtils.indexOfAnyBut("", new char[] { 'a', 'b' })); 
     assertEquals(-1, StringUtils.indexOfAnyBut("zzabyycdxx", (char[]) null)); 
     assertEquals(-1, StringUtils.indexOfAnyBut("zzabyycdxx", new char[0])); 
     assertEquals(3, StringUtils.indexOfAnyBut("zzabyycdxx", new char[] { 'z', 'a' })); 
     assertEquals(0, StringUtils.indexOfAnyBut("zzabyycdxx", new char[] { 'b', 'y' })); 
     assertEquals(-1, StringUtils.indexOfAnyBut("aba", new char[] { 'a', 'b' })); 
     assertEquals(0, StringUtils.indexOfAnyBut("aba", new char[] { 'z' })); 
 }
@Test
public void testContainsOnly_String1008() { 
     final String str1 = "a"; 
     final String str2 = "b"; 
     final String str3 = "ab"; 
     final String chars1 = "b"; 
     final String chars2 = "a"; 
     final String chars3 = "ab"; 
     assertFalse(StringUtils.containsOnly(null, (String) null)); 
     assertFalse(StringUtils.containsOnly("", (String) null)); 
     assertFalse(StringUtils.containsOnly(null, "")); 
     assertFalse(StringUtils.containsOnly(str1, "")); 
     assertTrue(StringUtils.containsOnly("", "")); 
     assertTrue(StringUtils.containsOnly("", chars1)); 
     assertFalse(StringUtils.containsOnly(str1, chars1)); 
     assertTrue(StringUtils.containsOnly(str1, chars2)); 
     assertTrue(StringUtils.containsOnly(str1, chars3)); 
     assertTrue(StringUtils.containsOnly(str2, chars1)); 
     assertFalse(StringUtils.containsOnly(str2, chars2)); 
     assertTrue(StringUtils.containsOnly(str2, chars3)); 
     assertFalse(StringUtils.containsOnly(str3, chars1)); 
     assertFalse(StringUtils.containsOnly(str3, chars2)); 
     assertTrue(StringUtils.containsOnly(str3, chars3)); 
 }
@Test
public void testIndexOfAnyBut_StringStringWithSupplementaryChars1009() { 
     assertEquals(2, StringUtils.indexOfAnyBut(CharU20000 + CharU20001, CharU20000)); 
     assertEquals(0, StringUtils.indexOfAnyBut(CharU20000 + CharU20001, CharU20001)); 
     assertEquals(-1, StringUtils.indexOfAnyBut(CharU20000, CharU20000)); 
     assertEquals(0, StringUtils.indexOfAnyBut(CharU20000, CharU20001)); 
 }
@Test
public void testIndexOfAnyBut_StringString1010() { 
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
public void testContainsOnly_CharArray1011() { 
     final String str1 = "a"; 
     final String str2 = "b"; 
     final String str3 = "ab"; 
     final char[] chars1 = { 'b' }; 
     final char[] chars2 = { 'a' }; 
     final char[] chars3 = { 'a', 'b' }; 
     final char[] emptyChars = new char[0]; 
     assertFalse(StringUtils.containsOnly(null, (char[]) null)); 
     assertFalse(StringUtils.containsOnly("", (char[]) null)); 
     assertFalse(StringUtils.containsOnly(null, emptyChars)); 
     assertFalse(StringUtils.containsOnly(str1, emptyChars)); 
     assertTrue(StringUtils.containsOnly("", emptyChars)); 
     assertTrue(StringUtils.containsOnly("", chars1)); 
     assertFalse(StringUtils.containsOnly(str1, chars1)); 
     assertTrue(StringUtils.containsOnly(str1, chars2)); 
     assertTrue(StringUtils.containsOnly(str1, chars3)); 
     assertTrue(StringUtils.containsOnly(str2, chars1)); 
     assertFalse(StringUtils.containsOnly(str2, chars2)); 
     assertTrue(StringUtils.containsOnly(str2, chars3)); 
     assertFalse(StringUtils.containsOnly(str3, chars1)); 
     assertFalse(StringUtils.containsOnly(str3, chars2)); 
     assertTrue(StringUtils.containsOnly(str3, chars3)); 
 }
@Test
public void testContainsNone_CharArray1012() { 
     final String str1 = "a"; 
     final String str2 = "b"; 
     final String str3 = "ab."; 
     final char[] chars1 = { 'b' }; 
     final char[] chars2 = { '.' }; 
     final char[] chars3 = { 'c', 'd' }; 
     final char[] emptyChars = new char[0]; 
     assertTrue(StringUtils.containsNone(null, (char[]) null)); 
     assertTrue(StringUtils.containsNone("", (char[]) null)); 
     assertTrue(StringUtils.containsNone(null, emptyChars)); 
     assertTrue(StringUtils.containsNone(str1, emptyChars)); 
     assertTrue(StringUtils.containsNone("", emptyChars)); 
     assertTrue(StringUtils.containsNone("", chars1)); 
     assertTrue(StringUtils.containsNone(str1, chars1)); 
     assertTrue(StringUtils.containsNone(str1, chars2)); 
     assertTrue(StringUtils.containsNone(str1, chars3)); 
     assertFalse(StringUtils.containsNone(str2, chars1)); 
     assertTrue(StringUtils.containsNone(str2, chars2)); 
     assertTrue(StringUtils.containsNone(str2, chars3)); 
     assertFalse(StringUtils.containsNone(str3, chars1)); 
     assertFalse(StringUtils.containsNone(str3, chars2)); 
     assertTrue(StringUtils.containsNone(str3, chars3)); 
 }
@Test
public void testContainsNone_StringWithBadSupplementaryChars1013() { 
     assertTrue(StringUtils.containsNone(CharUSuppCharHigh, CharU20001)); 
     assertEquals(-1, CharUSuppCharLow.indexOf(CharU20001)); 
     assertTrue(StringUtils.containsNone(CharUSuppCharLow, CharU20001)); 
     assertEquals(-1, CharU20001.indexOf(CharUSuppCharHigh)); 
     assertTrue(StringUtils.containsNone(CharU20001, CharUSuppCharHigh)); 
     assertEquals(0, CharU20001.indexOf(CharUSuppCharLow)); 
     assertFalse(StringUtils.containsNone(CharU20001, CharUSuppCharLow)); 
 }
@Test
public void testContainsNone_StringWithSupplementaryChars1014() { 
     assertFalse(StringUtils.containsNone(CharU20000 + CharU20001, CharU20000)); 
     assertFalse(StringUtils.containsNone(CharU20000 + CharU20001, CharU20001)); 
     assertFalse(StringUtils.containsNone(CharU20000, CharU20000)); 
     assertEquals(-1, CharU20000.indexOf(CharU20001)); 
     assertEquals(0, CharU20000.indexOf(CharU20001.charAt(0))); 
     assertEquals(-1, CharU20000.indexOf(CharU20001.charAt(1))); 
     assertTrue(StringUtils.containsNone(CharU20000, CharU20001)); 
     assertTrue(StringUtils.containsNone(CharU20001, CharU20000)); 
 }
@Test
public void testContainsNone_String1015() { 
     final String str1 = "a"; 
     final String str2 = "b"; 
     final String str3 = "ab."; 
     final String chars1 = "b"; 
     final String chars2 = "."; 
     final String chars3 = "cd"; 
     assertTrue(StringUtils.containsNone(null, (String) null)); 
     assertTrue(StringUtils.containsNone("", (String) null)); 
     assertTrue(StringUtils.containsNone(null, "")); 
     assertTrue(StringUtils.containsNone(str1, "")); 
     assertTrue(StringUtils.containsNone("", "")); 
     assertTrue(StringUtils.containsNone("", chars1)); 
     assertTrue(StringUtils.containsNone(str1, chars1)); 
     assertTrue(StringUtils.containsNone(str1, chars2)); 
     assertTrue(StringUtils.containsNone(str1, chars3)); 
     assertFalse(StringUtils.containsNone(str2, chars1)); 
     assertTrue(StringUtils.containsNone(str2, chars2)); 
     assertTrue(StringUtils.containsNone(str2, chars3)); 
     assertFalse(StringUtils.containsNone(str3, chars1)); 
     assertFalse(StringUtils.containsNone(str3, chars2)); 
     assertTrue(StringUtils.containsNone(str3, chars3)); 
 }
@Test
public void testIndexOfAny_StringStringArray1016() { 
     assertEquals(-1, StringUtils.indexOfAny(null, (String[]) null)); 
     assertEquals(-1, StringUtils.indexOfAny(null, FOOBAR_SUB_ARRAY)); 
     assertEquals(-1, StringUtils.indexOfAny(FOOBAR, (String[]) null)); 
     assertEquals(2, StringUtils.indexOfAny(FOOBAR, FOOBAR_SUB_ARRAY)); 
     assertEquals(-1, StringUtils.indexOfAny(FOOBAR, new String[0])); 
     assertEquals(-1, StringUtils.indexOfAny(null, new String[0])); 
     assertEquals(-1, StringUtils.indexOfAny("", new String[0])); 
     assertEquals(-1, StringUtils.indexOfAny(FOOBAR, new String[] { "llll" })); 
     assertEquals(0, StringUtils.indexOfAny(FOOBAR, new String[] { "" })); 
     assertEquals(0, StringUtils.indexOfAny("", new String[] { "" })); 
     assertEquals(-1, StringUtils.indexOfAny("", new String[] { "a" })); 
     assertEquals(-1, StringUtils.indexOfAny("", new String[] { null })); 
     assertEquals(-1, StringUtils.indexOfAny(FOOBAR, new String[] { null })); 
     assertEquals(-1, StringUtils.indexOfAny(null, new String[] { null })); 
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
