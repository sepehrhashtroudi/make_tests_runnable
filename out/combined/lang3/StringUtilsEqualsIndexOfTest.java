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
public void testIndexOfIgnoreCase_StringInt41() { 
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
public void testContainsAny_StringWithBadSupplementaryChars164() { 
     assertFalse(StringUtils.containsAny(CharUSuppCharHigh, CharU20001)); 
     assertEquals(-1, CharUSuppCharLow.indexOf(CharU20001)); 
     assertFalse(StringUtils.containsAny(CharUSuppCharLow, CharU20001)); 
     assertFalse(StringUtils.containsAny(CharU20001, CharUSuppCharHigh)); 
     assertEquals(0, CharU20001.indexOf(CharUSuppCharLow)); 
     assertTrue(StringUtils.containsAny(CharU20001, CharUSuppCharLow)); 
 }
@Test
public void testLastIndexOfAny_StringStringArray189() { 
     assertEquals(-1, StringUtils.lastIndexOfAny(null, (CharSequence) null)); 
     assertEquals(-1, StringUtils.lastIndexOfAny(null, (CharSequence[]) null)); 
     assertEquals(-1, StringUtils.lastIndexOfAny(null)); 
     assertEquals(-1, StringUtils.lastIndexOfAny(null, FOOBAR_SUB_ARRAY)); 
     assertEquals(-1, StringUtils.lastIndexOfAny(FOOBAR, (CharSequence) null)); 
     assertEquals(-1, StringUtils.lastIndexOfAny(FOOBAR, (CharSequence[]) null)); 
     assertEquals(-1, StringUtils.lastIndexOfAny(FOOBAR)); 
     assertEquals(3, StringUtils.lastIndexOfAny(FOOBAR, FOOBAR_SUB_ARRAY)); 
     assertEquals(-1, StringUtils.lastIndexOfAny(FOOBAR, new String[0])); 
     assertEquals(-1, StringUtils.lastIndexOfAny(null, new String[0])); 
     assertEquals(-1, StringUtils.lastIndexOfAny("", new String[0])); 
     assertEquals(-1, StringUtils.lastIndexOfAny(FOOBAR, new String[] { "llll" })); 
     assertEquals(6, StringUtils.lastIndexOfAny(FOOBAR, new String[] { "" })); 
     assertEquals(0, StringUtils.lastIndexOfAny("", new String[] { "" })); 
     assertEquals(-1, StringUtils.lastIndexOfAny("", new String[] { "a" })); 
     assertEquals(-1, StringUtils.lastIndexOfAny("", new String[] { null })); 
     assertEquals(-1, StringUtils.lastIndexOfAny(FOOBAR, new String[] { null })); 
     assertEquals(-1, StringUtils.lastIndexOfAny(null, new String[] { null })); 
 }
@Test
public void testContainsAny_StringString247() { 
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
public void testLastOrdinalIndexOf251() { 
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
public void testIndexOfAnyBut_StringCharArrayWithSupplementaryChars256() { 
     assertEquals(2, StringUtils.indexOfAnyBut(CharU20000 + CharU20001, CharU20000.toCharArray())); 
     assertEquals(0, StringUtils.indexOfAnyBut(CharU20000 + CharU20001, CharU20001.toCharArray())); 
     assertEquals(-1, StringUtils.indexOfAnyBut(CharU20000, CharU20000.toCharArray())); 
     assertEquals(0, StringUtils.indexOfAnyBut(CharU20000, CharU20001.toCharArray())); 
 }
@Test
public void testIndexOfAny_StringStringWithSupplementaryChars269() { 
     assertEquals(0, StringUtils.indexOfAny(CharU20000 + CharU20001, CharU20000)); 
     assertEquals(2, StringUtils.indexOfAny(CharU20000 + CharU20001, CharU20001)); 
     assertEquals(0, StringUtils.indexOfAny(CharU20000, CharU20000)); 
     assertEquals(-1, StringUtils.indexOfAny(CharU20000, CharU20001)); 
 }
@Test
public void testIndexOfAnyBut_StringStringWithSupplementaryChars301() { 
     assertEquals(2, StringUtils.indexOfAnyBut(CharU20000 + CharU20001, CharU20000)); 
     assertEquals(0, StringUtils.indexOfAnyBut(CharU20000 + CharU20001, CharU20001)); 
     assertEquals(-1, StringUtils.indexOfAnyBut(CharU20000, CharU20000)); 
     assertEquals(0, StringUtils.indexOfAnyBut(CharU20000, CharU20001)); 
 }
@Test
public void testIndexOf_char354() { 
     assertEquals(-1, StringUtils.indexOf(null, ' ')); 
     assertEquals(-1, StringUtils.indexOf("", ' ')); 
     assertEquals(0, StringUtils.indexOf("aabaabaa", 'a')); 
     assertEquals(2, StringUtils.indexOf("aabaabaa", 'b')); 
     assertEquals(2, StringUtils.indexOf(new StringBuilder("aabaabaa"), 'b')); 
 }
@Test
public void testIndexOf_StringInt393() { 
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
public void testIndexOfIgnoreCase_StringInt446() { 
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
public void testEquals482() { 
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
public void testLastIndexOfIgnoreCase_StringInt490() { 
     assertEquals(-1, StringUtils.lastIndexOfIgnoreCase(null, null, 0)); 
     assertEquals(-1, StringUtils.lastIndexOfIgnoreCase(null, null, -1)); 
     assertEquals(-1, StringUtils.lastIndexOfIgnoreCase(null, "", 0)); 
     assertEquals(-1, StringUtils.lastIndexOfIgnoreCase(null, "", -1)); 
     assertEquals(-1, StringUtils.lastIndexOfIgnoreCase("", null, 0)); 
     assertEquals(-1, StringUtils.lastIndexOfIgnoreCase("", null, -1)); 
     assertEquals(0, StringUtils.lastIndexOfIgnoreCase("", "", 0)); 
     assertEquals(-1, StringUtils.lastIndexOfIgnoreCase("", "", -1)); 
     assertEquals(0, StringUtils.lastIndexOfIgnoreCase("", "", 9)); 
     assertEquals(0, StringUtils.lastIndexOfIgnoreCase("abc", "", 0)); 
     assertEquals(-1, StringUtils.lastIndexOfIgnoreCase("abc", "", -1)); 
     assertEquals(3, StringUtils.lastIndexOfIgnoreCase("abc", "", 9)); 
     assertEquals(7, StringUtils.lastIndexOfIgnoreCase("aabaabaa", "A", 8)); 
     assertEquals(5, StringUtils.lastIndexOfIgnoreCase("aabaabaa", "B", 8)); 
     assertEquals(4, StringUtils.lastIndexOfIgnoreCase("aabaabaa", "AB", 8)); 
     assertEquals(2, StringUtils.lastIndexOfIgnoreCase("aabaabaa", "B", 3)); 
     assertEquals(5, StringUtils.lastIndexOfIgnoreCase("aabaabaa", "B", 9)); 
     assertEquals(-1, StringUtils.lastIndexOfIgnoreCase("aabaabaa", "B", -1)); 
     assertEquals(-1, StringUtils.lastIndexOfIgnoreCase("aabaabaa", "B", 0)); 
     assertEquals(0, StringUtils.lastIndexOfIgnoreCase("aabaabaa", "A", 0)); 
     assertEquals(1, StringUtils.lastIndexOfIgnoreCase("aab", "AB", 1)); 
 }
@Test
public void testIndexOf_charInt520() { 
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
public void testOrdinalIndexOf526() { 
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
public void testContainsNone_StringWithSupplementaryChars544() { 
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
public void testLastIndexOf_StringInt548() { 
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
public void testEqualsIgnoreCase593() { 
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
public void testContainsNone_StringWithSupplementaryChars662() { 
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
public void testLastIndexOf_char669() { 
     assertEquals(-1, StringUtils.lastIndexOf(null, ' ')); 
     assertEquals(-1, StringUtils.lastIndexOf("", ' ')); 
     assertEquals(7, StringUtils.lastIndexOf("aabaabaa", 'a')); 
     assertEquals(5, StringUtils.lastIndexOf("aabaabaa", 'b')); 
     assertEquals(5, StringUtils.lastIndexOf(new StringBuilder("aabaabaa"), 'b')); 
 }
@Test
public void testIndexOf_String679() { 
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
public void testIndexOfIgnoreCase_StringInt680() { 
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
public void testIndexOfIgnoreCase_StringInt696() { 
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
public void testOrdinalIndexOf705() { 
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
public void testContainsNone_StringWithSupplementaryChars735() { 
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
public void testContainsAny_StringCharArrayWithSupplementaryChars765() { 
     assertTrue(StringUtils.containsAny(CharU20000 + CharU20001, CharU20000.toCharArray())); 
     assertTrue(StringUtils.containsAny("a" + CharU20000 + CharU20001, "a".toCharArray())); 
     assertTrue(StringUtils.containsAny(CharU20000 + "a" + CharU20001, "a".toCharArray())); 
     assertTrue(StringUtils.containsAny(CharU20000 + CharU20001 + "a", "a".toCharArray())); 
     assertTrue(StringUtils.containsAny(CharU20000 + CharU20001, CharU20001.toCharArray())); 
     assertTrue(StringUtils.containsAny(CharU20000, CharU20000.toCharArray())); 
     assertEquals(-1, CharU20000.indexOf(CharU20001)); 
     assertEquals(0, CharU20000.indexOf(CharU20001.charAt(0))); 
     assertEquals(-1, CharU20000.indexOf(CharU20001.charAt(1))); 
     assertFalse(StringUtils.containsAny(CharU20000, CharU20001.toCharArray())); 
     assertFalse(StringUtils.containsAny(CharU20001, CharU20000.toCharArray())); 
 }
@Test
public void testIndexOfAnyBut_StringString826() { 
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
public void testLastIndexOfAny_StringStringArray829() { 
     assertEquals(-1, StringUtils.lastIndexOfAny(null, (CharSequence) null)); 
     assertEquals(-1, StringUtils.lastIndexOfAny(null, (CharSequence[]) null)); 
     assertEquals(-1, StringUtils.lastIndexOfAny(null)); 
     assertEquals(-1, StringUtils.lastIndexOfAny(null, FOOBAR_SUB_ARRAY)); 
     assertEquals(-1, StringUtils.lastIndexOfAny(FOOBAR, (CharSequence) null)); 
     assertEquals(-1, StringUtils.lastIndexOfAny(FOOBAR, (CharSequence[]) null)); 
     assertEquals(-1, StringUtils.lastIndexOfAny(FOOBAR)); 
     assertEquals(3, StringUtils.lastIndexOfAny(FOOBAR, FOOBAR_SUB_ARRAY)); 
     assertEquals(-1, StringUtils.lastIndexOfAny(FOOBAR, new String[0])); 
     assertEquals(-1, StringUtils.lastIndexOfAny(null, new String[0])); 
     assertEquals(-1, StringUtils.lastIndexOfAny("", new String[0])); 
     assertEquals(-1, StringUtils.lastIndexOfAny(FOOBAR, new String[] { "llll" })); 
     assertEquals(6, StringUtils.lastIndexOfAny(FOOBAR, new String[] { "" })); 
     assertEquals(0, StringUtils.lastIndexOfAny("", new String[] { "" })); 
     assertEquals(-1, StringUtils.lastIndexOfAny("", new String[] { "a" })); 
     assertEquals(-1, StringUtils.lastIndexOfAny("", new String[] { null })); 
     assertEquals(-1, StringUtils.lastIndexOfAny(FOOBAR, new String[] { null })); 
     assertEquals(-1, StringUtils.lastIndexOfAny(null, new String[] { null })); 
 }
@Test
public void testIndexOf_char883() { 
     assertEquals(-1, StringUtils.indexOf(null, ' ')); 
     assertEquals(-1, StringUtils.indexOf("", ' ')); 
     assertEquals(0, StringUtils.indexOf("aabaabaa", 'a')); 
     assertEquals(2, StringUtils.indexOf("aabaabaa", 'b')); 
     assertEquals(2, StringUtils.indexOf(new StringBuilder("aabaabaa"), 'b')); 
 }
@Test
public void testIndexOfIgnoreCase_String928() { 
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
public void testLastIndexOfAny_StringStringArray964() { 
     assertEquals(-1, StringUtils.lastIndexOfAny(null, (CharSequence) null)); 
     assertEquals(-1, StringUtils.lastIndexOfAny(null, (CharSequence[]) null)); 
     assertEquals(-1, StringUtils.lastIndexOfAny(null)); 
     assertEquals(-1, StringUtils.lastIndexOfAny(null, FOOBAR_SUB_ARRAY)); 
     assertEquals(-1, StringUtils.lastIndexOfAny(FOOBAR, (CharSequence) null)); 
     assertEquals(-1, StringUtils.lastIndexOfAny(FOOBAR, (CharSequence[]) null)); 
     assertEquals(-1, StringUtils.lastIndexOfAny(FOOBAR)); 
     assertEquals(3, StringUtils.lastIndexOfAny(FOOBAR, FOOBAR_SUB_ARRAY)); 
     assertEquals(-1, StringUtils.lastIndexOfAny(FOOBAR, new String[0])); 
     assertEquals(-1, StringUtils.lastIndexOfAny(null, new String[0])); 
     assertEquals(-1, StringUtils.lastIndexOfAny("", new String[0])); 
     assertEquals(-1, StringUtils.lastIndexOfAny(FOOBAR, new String[] { "llll" })); 
     assertEquals(6, StringUtils.lastIndexOfAny(FOOBAR, new String[] { "" })); 
     assertEquals(0, StringUtils.lastIndexOfAny("", new String[] { "" })); 
     assertEquals(-1, StringUtils.lastIndexOfAny("", new String[] { "a" })); 
     assertEquals(-1, StringUtils.lastIndexOfAny("", new String[] { null })); 
     assertEquals(-1, StringUtils.lastIndexOfAny(FOOBAR, new String[] { null })); 
     assertEquals(-1, StringUtils.lastIndexOfAny(null, new String[] { null })); 
 }
@Test
public void testLastIndexOfIgnoreCase_StringInt981() { 
     assertEquals(-1, StringUtils.lastIndexOfIgnoreCase(null, null, 0)); 
     assertEquals(-1, StringUtils.lastIndexOfIgnoreCase(null, null, -1)); 
     assertEquals(-1, StringUtils.lastIndexOfIgnoreCase(null, "", 0)); 
     assertEquals(-1, StringUtils.lastIndexOfIgnoreCase(null, "", -1)); 
     assertEquals(-1, StringUtils.lastIndexOfIgnoreCase("", null, 0)); 
     assertEquals(-1, StringUtils.lastIndexOfIgnoreCase("", null, -1)); 
     assertEquals(0, StringUtils.lastIndexOfIgnoreCase("", "", 0)); 
     assertEquals(-1, StringUtils.lastIndexOfIgnoreCase("", "", -1)); 
     assertEquals(0, StringUtils.lastIndexOfIgnoreCase("", "", 9)); 
     assertEquals(0, StringUtils.lastIndexOfIgnoreCase("abc", "", 0)); 
     assertEquals(-1, StringUtils.lastIndexOfIgnoreCase("abc", "", -1)); 
     assertEquals(3, StringUtils.lastIndexOfIgnoreCase("abc", "", 9)); 
     assertEquals(7, StringUtils.lastIndexOfIgnoreCase("aabaabaa", "A", 8)); 
     assertEquals(5, StringUtils.lastIndexOfIgnoreCase("aabaabaa", "B", 8)); 
     assertEquals(4, StringUtils.lastIndexOfIgnoreCase("aabaabaa", "AB", 8)); 
     assertEquals(2, StringUtils.lastIndexOfIgnoreCase("aabaabaa", "B", 3)); 
     assertEquals(5, StringUtils.lastIndexOfIgnoreCase("aabaabaa", "B", 9)); 
     assertEquals(-1, StringUtils.lastIndexOfIgnoreCase("aabaabaa", "B", -1)); 
     assertEquals(-1, StringUtils.lastIndexOfIgnoreCase("aabaabaa", "B", 0)); 
     assertEquals(0, StringUtils.lastIndexOfIgnoreCase("aabaabaa", "A", 0)); 
     assertEquals(1, StringUtils.lastIndexOfIgnoreCase("aab", "AB", 1)); 
 }
@Test
public void testContainsAny_StringCharArrayWithSupplementaryChars982() { 
     assertTrue(StringUtils.containsAny(CharU20000 + CharU20001, CharU20000.toCharArray())); 
     assertTrue(StringUtils.containsAny("a" + CharU20000 + CharU20001, "a".toCharArray())); 
     assertTrue(StringUtils.containsAny(CharU20000 + "a" + CharU20001, "a".toCharArray())); 
     assertTrue(StringUtils.containsAny(CharU20000 + CharU20001 + "a", "a".toCharArray())); 
     assertTrue(StringUtils.containsAny(CharU20000 + CharU20001, CharU20001.toCharArray())); 
     assertTrue(StringUtils.containsAny(CharU20000, CharU20000.toCharArray())); 
     assertEquals(-1, CharU20000.indexOf(CharU20001)); 
     assertEquals(0, CharU20000.indexOf(CharU20001.charAt(0))); 
     assertEquals(-1, CharU20000.indexOf(CharU20001.charAt(1))); 
     assertFalse(StringUtils.containsAny(CharU20000, CharU20001.toCharArray())); 
     assertFalse(StringUtils.containsAny(CharU20001, CharU20000.toCharArray())); 
 }
@Test
public void testLastIndexOfAny_StringStringArray1009() { 
     assertEquals(-1, StringUtils.lastIndexOfAny(null, (CharSequence) null)); 
     assertEquals(-1, StringUtils.lastIndexOfAny(null, (CharSequence[]) null)); 
     assertEquals(-1, StringUtils.lastIndexOfAny(null)); 
     assertEquals(-1, StringUtils.lastIndexOfAny(null, FOOBAR_SUB_ARRAY)); 
     assertEquals(-1, StringUtils.lastIndexOfAny(FOOBAR, (CharSequence) null)); 
     assertEquals(-1, StringUtils.lastIndexOfAny(FOOBAR, (CharSequence[]) null)); 
     assertEquals(-1, StringUtils.lastIndexOfAny(FOOBAR)); 
     assertEquals(3, StringUtils.lastIndexOfAny(FOOBAR, FOOBAR_SUB_ARRAY)); 
     assertEquals(-1, StringUtils.lastIndexOfAny(FOOBAR, new String[0])); 
     assertEquals(-1, StringUtils.lastIndexOfAny(null, new String[0])); 
     assertEquals(-1, StringUtils.lastIndexOfAny("", new String[0])); 
     assertEquals(-1, StringUtils.lastIndexOfAny(FOOBAR, new String[] { "llll" })); 
     assertEquals(6, StringUtils.lastIndexOfAny(FOOBAR, new String[] { "" })); 
     assertEquals(0, StringUtils.lastIndexOfAny("", new String[] { "" })); 
     assertEquals(-1, StringUtils.lastIndexOfAny("", new String[] { "a" })); 
     assertEquals(-1, StringUtils.lastIndexOfAny("", new String[] { null })); 
     assertEquals(-1, StringUtils.lastIndexOfAny(FOOBAR, new String[] { null })); 
     assertEquals(-1, StringUtils.lastIndexOfAny(null, new String[] { null })); 
 }
@Test
public void testIndexOfAny_StringStringArray1029() { 
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
@Test
public void testLastIndexOfAny_StringStringArray1030() { 
     assertEquals(-1, StringUtils.lastIndexOfAny(null, (CharSequence) null)); 
     assertEquals(-1, StringUtils.lastIndexOfAny(null, (CharSequence[]) null)); 
     assertEquals(-1, StringUtils.lastIndexOfAny(null)); 
     assertEquals(-1, StringUtils.lastIndexOfAny(null, FOOBAR_SUB_ARRAY)); 
     assertEquals(-1, StringUtils.lastIndexOfAny(FOOBAR, (CharSequence) null)); 
     assertEquals(-1, StringUtils.lastIndexOfAny(FOOBAR, (CharSequence[]) null)); 
     assertEquals(-1, StringUtils.lastIndexOfAny(FOOBAR)); 
     assertEquals(3, StringUtils.lastIndexOfAny(FOOBAR, FOOBAR_SUB_ARRAY)); 
     assertEquals(-1, StringUtils.lastIndexOfAny(FOOBAR, new String[0])); 
     assertEquals(-1, StringUtils.lastIndexOfAny(null, new String[0])); 
     assertEquals(-1, StringUtils.lastIndexOfAny("", new String[0])); 
     assertEquals(-1, StringUtils.lastIndexOfAny(FOOBAR, new String[] { "llll" })); 
     assertEquals(6, StringUtils.lastIndexOfAny(FOOBAR, new String[] { "" })); 
     assertEquals(0, StringUtils.lastIndexOfAny("", new String[] { "" })); 
     assertEquals(-1, StringUtils.lastIndexOfAny("", new String[] { "a" })); 
     assertEquals(-1, StringUtils.lastIndexOfAny("", new String[] { null })); 
     assertEquals(-1, StringUtils.lastIndexOfAny(FOOBAR, new String[] { null })); 
     assertEquals(-1, StringUtils.lastIndexOfAny(null, new String[] { null })); 
 }
@Test
public void testEqualsIgnoreCase1098() { 
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
public void testEqualsIgnoreCase1195() { 
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
public void testIndexOfAny_StringStringWithSupplementaryChars1234() { 
     assertEquals(0, StringUtils.indexOfAny(CharU20000 + CharU20001, CharU20000)); 
     assertEquals(2, StringUtils.indexOfAny(CharU20000 + CharU20001, CharU20001)); 
     assertEquals(0, StringUtils.indexOfAny(CharU20000, CharU20000)); 
     assertEquals(-1, StringUtils.indexOfAny(CharU20000, CharU20001)); 
 }
@Test
public void testIndexOf_char1237() { 
     assertEquals(-1, StringUtils.indexOf(null, ' ')); 
     assertEquals(-1, StringUtils.indexOf("", ' ')); 
     assertEquals(0, StringUtils.indexOf("aabaabaa", 'a')); 
     assertEquals(2, StringUtils.indexOf("aabaabaa", 'b')); 
     assertEquals(2, StringUtils.indexOf(new StringBuilder("aabaabaa"), 'b')); 
 }
@Test
public void testContainsIgnoreCase_LocaleIndependence1239() { 
     final Locale orig = Locale.getDefault(); 
     final Locale[] locales = { Locale.ENGLISH, new Locale("tr"), Locale.getDefault() }; 
     final String[][] tdata = { { "i", "I" }, { "I", "i" }, { "\u03C2", "\u03C3" }, { "\u03A3", "\u03C2" }, { "\u03A3", "\u03C3" } }; 
     final String[][] fdata = { { "\u00DF", "SS" } }; 
     try { 
         for (final Locale locale : locales) { 
             Locale.setDefault(locale); 
             for (int j = 0; j < tdata.length; j++) { 
                 assertTrue(Locale.getDefault() + ": " + j + " " + tdata[j][0] + " " + tdata[j][1], StringUtils.containsIgnoreCase(tdata[j][0], tdata[j][1])); 
             } 
             for (int j = 0; j < fdata.length; j++) { 
                 assertFalse(Locale.getDefault() + ": " + j + " " + fdata[j][0] + " " + fdata[j][1], StringUtils.containsIgnoreCase(fdata[j][0], fdata[j][1])); 
             } 
         } 
     } finally { 
         Locale.setDefault(orig); 
     } 
 }
@Test
public void testContainsAny_StringWithBadSupplementaryChars1247() { 
     assertFalse(StringUtils.containsAny(CharUSuppCharHigh, CharU20001)); 
     assertEquals(-1, CharUSuppCharLow.indexOf(CharU20001)); 
     assertFalse(StringUtils.containsAny(CharUSuppCharLow, CharU20001)); 
     assertFalse(StringUtils.containsAny(CharU20001, CharUSuppCharHigh)); 
     assertEquals(0, CharU20001.indexOf(CharUSuppCharLow)); 
     assertTrue(StringUtils.containsAny(CharU20001, CharUSuppCharLow)); 
 }
@Test
public void testLastIndexOf_char1306() { 
     assertEquals(-1, StringUtils.lastIndexOf(null, ' ')); 
     assertEquals(-1, StringUtils.lastIndexOf("", ' ')); 
     assertEquals(7, StringUtils.lastIndexOf("aabaabaa", 'a')); 
     assertEquals(5, StringUtils.lastIndexOf("aabaabaa", 'b')); 
     assertEquals(5, StringUtils.lastIndexOf(new StringBuilder("aabaabaa"), 'b')); 
 }
@Test
public void testContainsOnly_CharArray1386() { 
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
public void testContainsNone_StringWithSupplementaryChars1412() { 
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
public void testIndexOfAny_StringStringWithSupplementaryChars1416() { 
     assertEquals(0, StringUtils.indexOfAny(CharU20000 + CharU20001, CharU20000)); 
     assertEquals(2, StringUtils.indexOfAny(CharU20000 + CharU20001, CharU20001)); 
     assertEquals(0, StringUtils.indexOfAny(CharU20000, CharU20000)); 
     assertEquals(-1, StringUtils.indexOfAny(CharU20000, CharU20001)); 
 }
@Test
public void testLastIndexOf_char1438() { 
     assertEquals(-1, StringUtils.lastIndexOf(null, ' ')); 
     assertEquals(-1, StringUtils.lastIndexOf("", ' ')); 
     assertEquals(7, StringUtils.lastIndexOf("aabaabaa", 'a')); 
     assertEquals(5, StringUtils.lastIndexOf("aabaabaa", 'b')); 
     assertEquals(5, StringUtils.lastIndexOf(new StringBuilder("aabaabaa"), 'b')); 
 }
@Test
public void testIndexOfAny_StringStringArray1447() { 
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
@Test
public void testOrdinalIndexOf1467() { 
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
public void testLastIndexOf_char1482() { 
     assertEquals(-1, StringUtils.lastIndexOf(null, ' ')); 
     assertEquals(-1, StringUtils.lastIndexOf("", ' ')); 
     assertEquals(7, StringUtils.lastIndexOf("aabaabaa", 'a')); 
     assertEquals(5, StringUtils.lastIndexOf("aabaabaa", 'b')); 
     assertEquals(5, StringUtils.lastIndexOf(new StringBuilder("aabaabaa"), 'b')); 
 }
@Test
public void testLastIndexOf_charInt1587() { 
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
public void testEquals1611() { 
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
public void testLastIndexOfAny_StringStringArray1664() { 
     assertEquals(-1, StringUtils.lastIndexOfAny(null, (CharSequence) null)); 
     assertEquals(-1, StringUtils.lastIndexOfAny(null, (CharSequence[]) null)); 
     assertEquals(-1, StringUtils.lastIndexOfAny(null)); 
     assertEquals(-1, StringUtils.lastIndexOfAny(null, FOOBAR_SUB_ARRAY)); 
     assertEquals(-1, StringUtils.lastIndexOfAny(FOOBAR, (CharSequence) null)); 
     assertEquals(-1, StringUtils.lastIndexOfAny(FOOBAR, (CharSequence[]) null)); 
     assertEquals(-1, StringUtils.lastIndexOfAny(FOOBAR)); 
     assertEquals(3, StringUtils.lastIndexOfAny(FOOBAR, FOOBAR_SUB_ARRAY)); 
     assertEquals(-1, StringUtils.lastIndexOfAny(FOOBAR, new String[0])); 
     assertEquals(-1, StringUtils.lastIndexOfAny(null, new String[0])); 
     assertEquals(-1, StringUtils.lastIndexOfAny("", new String[0])); 
     assertEquals(-1, StringUtils.lastIndexOfAny(FOOBAR, new String[] { "llll" })); 
     assertEquals(6, StringUtils.lastIndexOfAny(FOOBAR, new String[] { "" })); 
     assertEquals(0, StringUtils.lastIndexOfAny("", new String[] { "" })); 
     assertEquals(-1, StringUtils.lastIndexOfAny("", new String[] { "a" })); 
     assertEquals(-1, StringUtils.lastIndexOfAny("", new String[] { null })); 
     assertEquals(-1, StringUtils.lastIndexOfAny(FOOBAR, new String[] { null })); 
     assertEquals(-1, StringUtils.lastIndexOfAny(null, new String[] { null })); 
 }
@Test
public void testEqualsIgnoreCase1683() { 
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
public void testIndexOfAny_StringStringArray1692() { 
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
@Test
public void testContainsNone_String1698() { 
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
public void testIndexOf_String1713() { 
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
public void testIndexOfAny_StringStringArray1729() { 
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
@Test
public void testContainsIgnoreCase_LocaleIndependence1743() { 
     final Locale orig = Locale.getDefault(); 
     final Locale[] locales = { Locale.ENGLISH, new Locale("tr"), Locale.getDefault() }; 
     final String[][] tdata = { { "i", "I" }, { "I", "i" }, { "\u03C2", "\u03C3" }, { "\u03A3", "\u03C2" }, { "\u03A3", "\u03C3" } }; 
     final String[][] fdata = { { "\u00DF", "SS" } }; 
     try { 
         for (final Locale locale : locales) { 
             Locale.setDefault(locale); 
             for (int j = 0; j < tdata.length; j++) { 
                 assertTrue(Locale.getDefault() + ": " + j + " " + tdata[j][0] + " " + tdata[j][1], StringUtils.containsIgnoreCase(tdata[j][0], tdata[j][1])); 
             } 
             for (int j = 0; j < fdata.length; j++) { 
                 assertFalse(Locale.getDefault() + ": " + j + " " + fdata[j][0] + " " + fdata[j][1], StringUtils.containsIgnoreCase(fdata[j][0], fdata[j][1])); 
             } 
         } 
     } finally { 
         Locale.setDefault(orig); 
     } 
 }
@Test
public void testContainsNone_StringWithSupplementaryChars1870() { 
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
public void testIndexOfIgnoreCase_StringInt1900() { 
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
public void testLastIndexOf_StringInt1911() { 
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
public void testIndexOfAny_StringStringWithSupplementaryChars1916() { 
     assertEquals(0, StringUtils.indexOfAny(CharU20000 + CharU20001, CharU20000)); 
     assertEquals(2, StringUtils.indexOfAny(CharU20000 + CharU20001, CharU20001)); 
     assertEquals(0, StringUtils.indexOfAny(CharU20000, CharU20000)); 
     assertEquals(-1, StringUtils.indexOfAny(CharU20000, CharU20001)); 
 }
@Test
public void testLastIndexOf_StringInt1935() { 
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
public void testContainsAny_StringCharArrayWithSupplementaryChars1949() { 
     assertTrue(StringUtils.containsAny(CharU20000 + CharU20001, CharU20000.toCharArray())); 
     assertTrue(StringUtils.containsAny("a" + CharU20000 + CharU20001, "a".toCharArray())); 
     assertTrue(StringUtils.containsAny(CharU20000 + "a" + CharU20001, "a".toCharArray())); 
     assertTrue(StringUtils.containsAny(CharU20000 + CharU20001 + "a", "a".toCharArray())); 
     assertTrue(StringUtils.containsAny(CharU20000 + CharU20001, CharU20001.toCharArray())); 
     assertTrue(StringUtils.containsAny(CharU20000, CharU20000.toCharArray())); 
     assertEquals(-1, CharU20000.indexOf(CharU20001)); 
     assertEquals(0, CharU20000.indexOf(CharU20001.charAt(0))); 
     assertEquals(-1, CharU20000.indexOf(CharU20001.charAt(1))); 
     assertFalse(StringUtils.containsAny(CharU20000, CharU20001.toCharArray())); 
     assertFalse(StringUtils.containsAny(CharU20001, CharU20000.toCharArray())); 
 }
@Test
public void testLastIndexOfAny_StringStringArray2060() { 
     assertEquals(-1, StringUtils.lastIndexOfAny(null, (CharSequence) null)); 
     assertEquals(-1, StringUtils.lastIndexOfAny(null, (CharSequence[]) null)); 
     assertEquals(-1, StringUtils.lastIndexOfAny(null)); 
     assertEquals(-1, StringUtils.lastIndexOfAny(null, FOOBAR_SUB_ARRAY)); 
     assertEquals(-1, StringUtils.lastIndexOfAny(FOOBAR, (CharSequence) null)); 
     assertEquals(-1, StringUtils.lastIndexOfAny(FOOBAR, (CharSequence[]) null)); 
     assertEquals(-1, StringUtils.lastIndexOfAny(FOOBAR)); 
     assertEquals(3, StringUtils.lastIndexOfAny(FOOBAR, FOOBAR_SUB_ARRAY)); 
     assertEquals(-1, StringUtils.lastIndexOfAny(FOOBAR, new String[0])); 
     assertEquals(-1, StringUtils.lastIndexOfAny(null, new String[0])); 
     assertEquals(-1, StringUtils.lastIndexOfAny("", new String[0])); 
     assertEquals(-1, StringUtils.lastIndexOfAny(FOOBAR, new String[] { "llll" })); 
     assertEquals(6, StringUtils.lastIndexOfAny(FOOBAR, new String[] { "" })); 
     assertEquals(0, StringUtils.lastIndexOfAny("", new String[] { "" })); 
     assertEquals(-1, StringUtils.lastIndexOfAny("", new String[] { "a" })); 
     assertEquals(-1, StringUtils.lastIndexOfAny("", new String[] { null })); 
     assertEquals(-1, StringUtils.lastIndexOfAny(FOOBAR, new String[] { null })); 
     assertEquals(-1, StringUtils.lastIndexOfAny(null, new String[] { null })); 
 }
@Test
public void testLastOrdinalIndexOf2129() { 
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
public void testEquals2131() { 
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
public void testIndexOfAnyBut_StringStringWithSupplementaryChars2181() { 
     assertEquals(2, StringUtils.indexOfAnyBut(CharU20000 + CharU20001, CharU20000)); 
     assertEquals(0, StringUtils.indexOfAnyBut(CharU20000 + CharU20001, CharU20001)); 
     assertEquals(-1, StringUtils.indexOfAnyBut(CharU20000, CharU20000)); 
     assertEquals(0, StringUtils.indexOfAnyBut(CharU20000, CharU20001)); 
 }
@Test
public void testIndexOfIgnoreCase_StringInt2208() { 
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
public void testEquals2239() { 
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
public void testIndexOfIgnoreCase_StringInt2260() { 
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
public void testContainsOnly_CharArray2306() { 
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
public void testIndexOfAny_StringStringWithSupplementaryChars2312() { 
     assertEquals(0, StringUtils.indexOfAny(CharU20000 + CharU20001, CharU20000)); 
     assertEquals(2, StringUtils.indexOfAny(CharU20000 + CharU20001, CharU20001)); 
     assertEquals(0, StringUtils.indexOfAny(CharU20000, CharU20000)); 
     assertEquals(-1, StringUtils.indexOfAny(CharU20000, CharU20001)); 
 }
@Test
public void testOrdinalIndexOf2321() { 
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
public void testContains_Char2377() { 
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
public void testContainsOnly_String2384() { 
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
public void testContainsAny_StringCharArrayWithSupplementaryChars2432() { 
     assertTrue(StringUtils.containsAny(CharU20000 + CharU20001, CharU20000.toCharArray())); 
     assertTrue(StringUtils.containsAny("a" + CharU20000 + CharU20001, "a".toCharArray())); 
     assertTrue(StringUtils.containsAny(CharU20000 + "a" + CharU20001, "a".toCharArray())); 
     assertTrue(StringUtils.containsAny(CharU20000 + CharU20001 + "a", "a".toCharArray())); 
     assertTrue(StringUtils.containsAny(CharU20000 + CharU20001, CharU20001.toCharArray())); 
     assertTrue(StringUtils.containsAny(CharU20000, CharU20000.toCharArray())); 
     assertEquals(-1, CharU20000.indexOf(CharU20001)); 
     assertEquals(0, CharU20000.indexOf(CharU20001.charAt(0))); 
     assertEquals(-1, CharU20000.indexOf(CharU20001.charAt(1))); 
     assertFalse(StringUtils.containsAny(CharU20000, CharU20001.toCharArray())); 
     assertFalse(StringUtils.containsAny(CharU20001, CharU20000.toCharArray())); 
 }
@Test
public void testIndexOfAny_StringStringWithSupplementaryChars2450() { 
     assertEquals(0, StringUtils.indexOfAny(CharU20000 + CharU20001, CharU20000)); 
     assertEquals(2, StringUtils.indexOfAny(CharU20000 + CharU20001, CharU20001)); 
     assertEquals(0, StringUtils.indexOfAny(CharU20000, CharU20000)); 
     assertEquals(-1, StringUtils.indexOfAny(CharU20000, CharU20001)); 
 }
@Test
public void testIndexOfAny_StringStringWithSupplementaryChars2466() { 
     assertEquals(0, StringUtils.indexOfAny(CharU20000 + CharU20001, CharU20000)); 
     assertEquals(2, StringUtils.indexOfAny(CharU20000 + CharU20001, CharU20001)); 
     assertEquals(0, StringUtils.indexOfAny(CharU20000, CharU20000)); 
     assertEquals(-1, StringUtils.indexOfAny(CharU20000, CharU20001)); 
 }
@Test
public void testLastIndexOfIgnoreCase_StringInt2473() { 
     assertEquals(-1, StringUtils.lastIndexOfIgnoreCase(null, null, 0)); 
     assertEquals(-1, StringUtils.lastIndexOfIgnoreCase(null, null, -1)); 
     assertEquals(-1, StringUtils.lastIndexOfIgnoreCase(null, "", 0)); 
     assertEquals(-1, StringUtils.lastIndexOfIgnoreCase(null, "", -1)); 
     assertEquals(-1, StringUtils.lastIndexOfIgnoreCase("", null, 0)); 
     assertEquals(-1, StringUtils.lastIndexOfIgnoreCase("", null, -1)); 
     assertEquals(0, StringUtils.lastIndexOfIgnoreCase("", "", 0)); 
     assertEquals(-1, StringUtils.lastIndexOfIgnoreCase("", "", -1)); 
     assertEquals(0, StringUtils.lastIndexOfIgnoreCase("", "", 9)); 
     assertEquals(0, StringUtils.lastIndexOfIgnoreCase("abc", "", 0)); 
     assertEquals(-1, StringUtils.lastIndexOfIgnoreCase("abc", "", -1)); 
     assertEquals(3, StringUtils.lastIndexOfIgnoreCase("abc", "", 9)); 
     assertEquals(7, StringUtils.lastIndexOfIgnoreCase("aabaabaa", "A", 8)); 
     assertEquals(5, StringUtils.lastIndexOfIgnoreCase("aabaabaa", "B", 8)); 
     assertEquals(4, StringUtils.lastIndexOfIgnoreCase("aabaabaa", "AB", 8)); 
     assertEquals(2, StringUtils.lastIndexOfIgnoreCase("aabaabaa", "B", 3)); 
     assertEquals(5, StringUtils.lastIndexOfIgnoreCase("aabaabaa", "B", 9)); 
     assertEquals(-1, StringUtils.lastIndexOfIgnoreCase("aabaabaa", "B", -1)); 
     assertEquals(-1, StringUtils.lastIndexOfIgnoreCase("aabaabaa", "B", 0)); 
     assertEquals(0, StringUtils.lastIndexOfIgnoreCase("aabaabaa", "A", 0)); 
     assertEquals(1, StringUtils.lastIndexOfIgnoreCase("aab", "AB", 1)); 
 }
@Test
public void testIndexOfAny_StringStringArray2570() { 
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
@Test
public void testLastIndexOfAny_StringStringArray2624() { 
     assertEquals(-1, StringUtils.lastIndexOfAny(null, (CharSequence) null)); 
     assertEquals(-1, StringUtils.lastIndexOfAny(null, (CharSequence[]) null)); 
     assertEquals(-1, StringUtils.lastIndexOfAny(null)); 
     assertEquals(-1, StringUtils.lastIndexOfAny(null, FOOBAR_SUB_ARRAY)); 
     assertEquals(-1, StringUtils.lastIndexOfAny(FOOBAR, (CharSequence) null)); 
     assertEquals(-1, StringUtils.lastIndexOfAny(FOOBAR, (CharSequence[]) null)); 
     assertEquals(-1, StringUtils.lastIndexOfAny(FOOBAR)); 
     assertEquals(3, StringUtils.lastIndexOfAny(FOOBAR, FOOBAR_SUB_ARRAY)); 
     assertEquals(-1, StringUtils.lastIndexOfAny(FOOBAR, new String[0])); 
     assertEquals(-1, StringUtils.lastIndexOfAny(null, new String[0])); 
     assertEquals(-1, StringUtils.lastIndexOfAny("", new String[0])); 
     assertEquals(-1, StringUtils.lastIndexOfAny(FOOBAR, new String[] { "llll" })); 
     assertEquals(6, StringUtils.lastIndexOfAny(FOOBAR, new String[] { "" })); 
     assertEquals(0, StringUtils.lastIndexOfAny("", new String[] { "" })); 
     assertEquals(-1, StringUtils.lastIndexOfAny("", new String[] { "a" })); 
     assertEquals(-1, StringUtils.lastIndexOfAny("", new String[] { null })); 
     assertEquals(-1, StringUtils.lastIndexOfAny(FOOBAR, new String[] { null })); 
     assertEquals(-1, StringUtils.lastIndexOfAny(null, new String[] { null })); 
 }
@Test
public void testLastIndexOf_String2671() { 
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
public void testContainsWhitespace2698() { 
     assertFalse(StringUtils.containsWhitespace("")); 
     assertTrue(StringUtils.containsWhitespace(" ")); 
     assertFalse(StringUtils.containsWhitespace("a")); 
     assertTrue(StringUtils.containsWhitespace("a ")); 
     assertTrue(StringUtils.containsWhitespace(" a")); 
     assertTrue(StringUtils.containsWhitespace("a\t")); 
     assertTrue(StringUtils.containsWhitespace("\n")); 
 }
@Test
public void testContainsAny_StringCharArrayWithSupplementaryChars2748() { 
     assertTrue(StringUtils.containsAny(CharU20000 + CharU20001, CharU20000.toCharArray())); 
     assertTrue(StringUtils.containsAny("a" + CharU20000 + CharU20001, "a".toCharArray())); 
     assertTrue(StringUtils.containsAny(CharU20000 + "a" + CharU20001, "a".toCharArray())); 
     assertTrue(StringUtils.containsAny(CharU20000 + CharU20001 + "a", "a".toCharArray())); 
     assertTrue(StringUtils.containsAny(CharU20000 + CharU20001, CharU20001.toCharArray())); 
     assertTrue(StringUtils.containsAny(CharU20000, CharU20000.toCharArray())); 
     assertEquals(-1, CharU20000.indexOf(CharU20001)); 
     assertEquals(0, CharU20000.indexOf(CharU20001.charAt(0))); 
     assertEquals(-1, CharU20000.indexOf(CharU20001.charAt(1))); 
     assertFalse(StringUtils.containsAny(CharU20000, CharU20001.toCharArray())); 
     assertFalse(StringUtils.containsAny(CharU20001, CharU20000.toCharArray())); 
 }
@Test
public void testIndexOfAny_StringStringWithSupplementaryChars2763() { 
     assertEquals(0, StringUtils.indexOfAny(CharU20000 + CharU20001, CharU20000)); 
     assertEquals(2, StringUtils.indexOfAny(CharU20000 + CharU20001, CharU20001)); 
     assertEquals(0, StringUtils.indexOfAny(CharU20000, CharU20000)); 
     assertEquals(-1, StringUtils.indexOfAny(CharU20000, CharU20001)); 
 }
@Test
public void testLastIndexOf_char2765() { 
     assertEquals(-1, StringUtils.lastIndexOf(null, ' ')); 
     assertEquals(-1, StringUtils.lastIndexOf("", ' ')); 
     assertEquals(7, StringUtils.lastIndexOf("aabaabaa", 'a')); 
     assertEquals(5, StringUtils.lastIndexOf("aabaabaa", 'b')); 
     assertEquals(5, StringUtils.lastIndexOf(new StringBuilder("aabaabaa"), 'b')); 
 }
@Test
public void testLastIndexOfIgnoreCase_String2862() { 
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
public void testLastIndexOfIgnoreCase_String2880() { 
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
public void testContainsNone_String2977() { 
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
public void testLastIndexOf_StringInt2986() { 
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
public void testIndexOf_charInt3010() { 
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
public void testIndexOfAnyBut_StringStringWithSupplementaryChars3023() { 
     assertEquals(2, StringUtils.indexOfAnyBut(CharU20000 + CharU20001, CharU20000)); 
     assertEquals(0, StringUtils.indexOfAnyBut(CharU20000 + CharU20001, CharU20001)); 
     assertEquals(-1, StringUtils.indexOfAnyBut(CharU20000, CharU20000)); 
     assertEquals(0, StringUtils.indexOfAnyBut(CharU20000, CharU20001)); 
 }
@Test
public void testIndexOfAnyBut_StringStringWithSupplementaryChars3093() { 
     assertEquals(2, StringUtils.indexOfAnyBut(CharU20000 + CharU20001, CharU20000)); 
     assertEquals(0, StringUtils.indexOfAnyBut(CharU20000 + CharU20001, CharU20001)); 
     assertEquals(-1, StringUtils.indexOfAnyBut(CharU20000, CharU20000)); 
     assertEquals(0, StringUtils.indexOfAnyBut(CharU20000, CharU20001)); 
 }
@Test
public void testContainsOnly_String3110() { 
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
public void testContains_Char3118() { 
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
public void testContains_String3133() { 
     assertFalse(StringUtils.contains(null, null)); 
     assertFalse(StringUtils.contains(null, "")); 
     assertFalse(StringUtils.contains(null, "a")); 
     assertFalse(StringUtils.contains("", null)); 
     assertTrue(StringUtils.contains("", "")); 
     assertFalse(StringUtils.contains("", "a")); 
     assertTrue(StringUtils.contains("abc", "a")); 
     assertTrue(StringUtils.contains("abc", "b")); 
     assertTrue(StringUtils.contains("abc", "c")); 
     assertTrue(StringUtils.contains("abc", "abc")); 
     assertFalse(StringUtils.contains("abc", "z")); 
 }
@Test
public void testLastIndexOfAny_StringStringArray3197() { 
     assertEquals(-1, StringUtils.lastIndexOfAny(null, (CharSequence) null)); 
     assertEquals(-1, StringUtils.lastIndexOfAny(null, (CharSequence[]) null)); 
     assertEquals(-1, StringUtils.lastIndexOfAny(null)); 
     assertEquals(-1, StringUtils.lastIndexOfAny(null, FOOBAR_SUB_ARRAY)); 
     assertEquals(-1, StringUtils.lastIndexOfAny(FOOBAR, (CharSequence) null)); 
     assertEquals(-1, StringUtils.lastIndexOfAny(FOOBAR, (CharSequence[]) null)); 
     assertEquals(-1, StringUtils.lastIndexOfAny(FOOBAR)); 
     assertEquals(3, StringUtils.lastIndexOfAny(FOOBAR, FOOBAR_SUB_ARRAY)); 
     assertEquals(-1, StringUtils.lastIndexOfAny(FOOBAR, new String[0])); 
     assertEquals(-1, StringUtils.lastIndexOfAny(null, new String[0])); 
     assertEquals(-1, StringUtils.lastIndexOfAny("", new String[0])); 
     assertEquals(-1, StringUtils.lastIndexOfAny(FOOBAR, new String[] { "llll" })); 
     assertEquals(6, StringUtils.lastIndexOfAny(FOOBAR, new String[] { "" })); 
     assertEquals(0, StringUtils.lastIndexOfAny("", new String[] { "" })); 
     assertEquals(-1, StringUtils.lastIndexOfAny("", new String[] { "a" })); 
     assertEquals(-1, StringUtils.lastIndexOfAny("", new String[] { null })); 
     assertEquals(-1, StringUtils.lastIndexOfAny(FOOBAR, new String[] { null })); 
     assertEquals(-1, StringUtils.lastIndexOfAny(null, new String[] { null })); 
 }
@Test
public void testContainsAny_StringString3242() { 
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
public void testContains_Char3325() { 
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
public void testContains_StringWithSupplementaryChars3444() { 
     assertTrue(StringUtils.contains(CharU20000 + CharU20001, CharU20000)); 
     assertTrue(StringUtils.contains(CharU20000 + CharU20001, CharU20001)); 
     assertTrue(StringUtils.contains(CharU20000, CharU20000)); 
     assertFalse(StringUtils.contains(CharU20000, CharU20001)); 
 }
@Test
public void testLastIndexOf_char3481() { 
     assertEquals(-1, StringUtils.lastIndexOf(null, ' ')); 
     assertEquals(-1, StringUtils.lastIndexOf("", ' ')); 
     assertEquals(7, StringUtils.lastIndexOf("aabaabaa", 'a')); 
     assertEquals(5, StringUtils.lastIndexOf("aabaabaa", 'b')); 
     assertEquals(5, StringUtils.lastIndexOf(new StringBuilder("aabaabaa"), 'b')); 
 }
@Test
public void testLastIndexOf_charInt3535() { 
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
public void testIndexOf_charInt3550() { 
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
public void testLastIndexOf_char3551() { 
     assertEquals(-1, StringUtils.lastIndexOf(null, ' ')); 
     assertEquals(-1, StringUtils.lastIndexOf("", ' ')); 
     assertEquals(7, StringUtils.lastIndexOf("aabaabaa", 'a')); 
     assertEquals(5, StringUtils.lastIndexOf("aabaabaa", 'b')); 
     assertEquals(5, StringUtils.lastIndexOf(new StringBuilder("aabaabaa"), 'b')); 
 }
@Test
public void testOrdinalIndexOf3640() { 
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
public void testIndexOfAnyBut_StringCharArrayWithSupplementaryChars3658() { 
     assertEquals(2, StringUtils.indexOfAnyBut(CharU20000 + CharU20001, CharU20000.toCharArray())); 
     assertEquals(0, StringUtils.indexOfAnyBut(CharU20000 + CharU20001, CharU20001.toCharArray())); 
     assertEquals(-1, StringUtils.indexOfAnyBut(CharU20000, CharU20000.toCharArray())); 
     assertEquals(0, StringUtils.indexOfAnyBut(CharU20000, CharU20001.toCharArray())); 
 }
@Test
public void testIndexOfIgnoreCase_StringInt3718() { 
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
public void testContainsAny_StringCharArrayWithBadSupplementaryChars3774() { 
     assertFalse(StringUtils.containsAny(CharUSuppCharHigh, CharU20001.toCharArray())); 
     assertFalse(StringUtils.containsAny("abc" + CharUSuppCharHigh + "xyz", CharU20001.toCharArray())); 
     assertEquals(-1, CharUSuppCharLow.indexOf(CharU20001)); 
     assertFalse(StringUtils.containsAny(CharUSuppCharLow, CharU20001.toCharArray())); 
     assertFalse(StringUtils.containsAny(CharU20001, CharUSuppCharHigh.toCharArray())); 
     assertEquals(0, CharU20001.indexOf(CharUSuppCharLow)); 
     assertTrue(StringUtils.containsAny(CharU20001, CharUSuppCharLow.toCharArray())); 
 }
@Test
public void testContainsAny_StringCharArrayWithSupplementaryChars3782() { 
     assertTrue(StringUtils.containsAny(CharU20000 + CharU20001, CharU20000.toCharArray())); 
     assertTrue(StringUtils.containsAny("a" + CharU20000 + CharU20001, "a".toCharArray())); 
     assertTrue(StringUtils.containsAny(CharU20000 + "a" + CharU20001, "a".toCharArray())); 
     assertTrue(StringUtils.containsAny(CharU20000 + CharU20001 + "a", "a".toCharArray())); 
     assertTrue(StringUtils.containsAny(CharU20000 + CharU20001, CharU20001.toCharArray())); 
     assertTrue(StringUtils.containsAny(CharU20000, CharU20000.toCharArray())); 
     assertEquals(-1, CharU20000.indexOf(CharU20001)); 
     assertEquals(0, CharU20000.indexOf(CharU20001.charAt(0))); 
     assertEquals(-1, CharU20000.indexOf(CharU20001.charAt(1))); 
     assertFalse(StringUtils.containsAny(CharU20000, CharU20001.toCharArray())); 
     assertFalse(StringUtils.containsAny(CharU20001, CharU20000.toCharArray())); 
 }
@Test
public void testContainsWhitespace3787() { 
     assertFalse(StringUtils.containsWhitespace("")); 
     assertTrue(StringUtils.containsWhitespace(" ")); 
     assertFalse(StringUtils.containsWhitespace("a")); 
     assertTrue(StringUtils.containsWhitespace("a ")); 
     assertTrue(StringUtils.containsWhitespace(" a")); 
     assertTrue(StringUtils.containsWhitespace("a\t")); 
     assertTrue(StringUtils.containsWhitespace("\n")); 
 }
@Test
public void testIndexOfAnyBut_StringStringWithSupplementaryChars3809() { 
     assertEquals(2, StringUtils.indexOfAnyBut(CharU20000 + CharU20001, CharU20000)); 
     assertEquals(0, StringUtils.indexOfAnyBut(CharU20000 + CharU20001, CharU20001)); 
     assertEquals(-1, StringUtils.indexOfAnyBut(CharU20000, CharU20000)); 
     assertEquals(0, StringUtils.indexOfAnyBut(CharU20000, CharU20001)); 
 }
@Test
public void testOrdinalIndexOf3816() { 
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
public void testIndexOfAnyBut_StringStringWithSupplementaryChars3835() { 
     assertEquals(2, StringUtils.indexOfAnyBut(CharU20000 + CharU20001, CharU20000)); 
     assertEquals(0, StringUtils.indexOfAnyBut(CharU20000 + CharU20001, CharU20001)); 
     assertEquals(-1, StringUtils.indexOfAnyBut(CharU20000, CharU20000)); 
     assertEquals(0, StringUtils.indexOfAnyBut(CharU20000, CharU20001)); 
 }
@Test
public void testIndexOfIgnoreCase_StringInt3837() { 
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
public void testLastIndexOfIgnoreCase_StringInt3846() { 
     assertEquals(-1, StringUtils.lastIndexOfIgnoreCase(null, null, 0)); 
     assertEquals(-1, StringUtils.lastIndexOfIgnoreCase(null, null, -1)); 
     assertEquals(-1, StringUtils.lastIndexOfIgnoreCase(null, "", 0)); 
     assertEquals(-1, StringUtils.lastIndexOfIgnoreCase(null, "", -1)); 
     assertEquals(-1, StringUtils.lastIndexOfIgnoreCase("", null, 0)); 
     assertEquals(-1, StringUtils.lastIndexOfIgnoreCase("", null, -1)); 
     assertEquals(0, StringUtils.lastIndexOfIgnoreCase("", "", 0)); 
     assertEquals(-1, StringUtils.lastIndexOfIgnoreCase("", "", -1)); 
     assertEquals(0, StringUtils.lastIndexOfIgnoreCase("", "", 9)); 
     assertEquals(0, StringUtils.lastIndexOfIgnoreCase("abc", "", 0)); 
     assertEquals(-1, StringUtils.lastIndexOfIgnoreCase("abc", "", -1)); 
     assertEquals(3, StringUtils.lastIndexOfIgnoreCase("abc", "", 9)); 
     assertEquals(7, StringUtils.lastIndexOfIgnoreCase("aabaabaa", "A", 8)); 
     assertEquals(5, StringUtils.lastIndexOfIgnoreCase("aabaabaa", "B", 8)); 
     assertEquals(4, StringUtils.lastIndexOfIgnoreCase("aabaabaa", "AB", 8)); 
     assertEquals(2, StringUtils.lastIndexOfIgnoreCase("aabaabaa", "B", 3)); 
     assertEquals(5, StringUtils.lastIndexOfIgnoreCase("aabaabaa", "B", 9)); 
     assertEquals(-1, StringUtils.lastIndexOfIgnoreCase("aabaabaa", "B", -1)); 
     assertEquals(-1, StringUtils.lastIndexOfIgnoreCase("aabaabaa", "B", 0)); 
     assertEquals(0, StringUtils.lastIndexOfIgnoreCase("aabaabaa", "A", 0)); 
     assertEquals(1, StringUtils.lastIndexOfIgnoreCase("aab", "AB", 1)); 
 }
@Test
public void testLastIndexOf_StringInt3897() { 
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
public void testContainsNone_StringWithSupplementaryChars3909() { 
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
public void testOrdinalIndexOf3916() { 
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
public void testContainsAny_StringCharArrayWithSupplementaryChars3929() { 
     assertTrue(StringUtils.containsAny(CharU20000 + CharU20001, CharU20000.toCharArray())); 
     assertTrue(StringUtils.containsAny("a" + CharU20000 + CharU20001, "a".toCharArray())); 
     assertTrue(StringUtils.containsAny(CharU20000 + "a" + CharU20001, "a".toCharArray())); 
     assertTrue(StringUtils.containsAny(CharU20000 + CharU20001 + "a", "a".toCharArray())); 
     assertTrue(StringUtils.containsAny(CharU20000 + CharU20001, CharU20001.toCharArray())); 
     assertTrue(StringUtils.containsAny(CharU20000, CharU20000.toCharArray())); 
     assertEquals(-1, CharU20000.indexOf(CharU20001)); 
     assertEquals(0, CharU20000.indexOf(CharU20001.charAt(0))); 
     assertEquals(-1, CharU20000.indexOf(CharU20001.charAt(1))); 
     assertFalse(StringUtils.containsAny(CharU20000, CharU20001.toCharArray())); 
     assertFalse(StringUtils.containsAny(CharU20001, CharU20000.toCharArray())); 
 }
@Test
public void testLastIndexOfIgnoreCase_StringInt3998() { 
     assertEquals(-1, StringUtils.lastIndexOfIgnoreCase(null, null, 0)); 
     assertEquals(-1, StringUtils.lastIndexOfIgnoreCase(null, null, -1)); 
     assertEquals(-1, StringUtils.lastIndexOfIgnoreCase(null, "", 0)); 
     assertEquals(-1, StringUtils.lastIndexOfIgnoreCase(null, "", -1)); 
     assertEquals(-1, StringUtils.lastIndexOfIgnoreCase("", null, 0)); 
     assertEquals(-1, StringUtils.lastIndexOfIgnoreCase("", null, -1)); 
     assertEquals(0, StringUtils.lastIndexOfIgnoreCase("", "", 0)); 
     assertEquals(-1, StringUtils.lastIndexOfIgnoreCase("", "", -1)); 
     assertEquals(0, StringUtils.lastIndexOfIgnoreCase("", "", 9)); 
     assertEquals(0, StringUtils.lastIndexOfIgnoreCase("abc", "", 0)); 
     assertEquals(-1, StringUtils.lastIndexOfIgnoreCase("abc", "", -1)); 
     assertEquals(3, StringUtils.lastIndexOfIgnoreCase("abc", "", 9)); 
     assertEquals(7, StringUtils.lastIndexOfIgnoreCase("aabaabaa", "A", 8)); 
     assertEquals(5, StringUtils.lastIndexOfIgnoreCase("aabaabaa", "B", 8)); 
     assertEquals(4, StringUtils.lastIndexOfIgnoreCase("aabaabaa", "AB", 8)); 
     assertEquals(2, StringUtils.lastIndexOfIgnoreCase("aabaabaa", "B", 3)); 
     assertEquals(5, StringUtils.lastIndexOfIgnoreCase("aabaabaa", "B", 9)); 
     assertEquals(-1, StringUtils.lastIndexOfIgnoreCase("aabaabaa", "B", -1)); 
     assertEquals(-1, StringUtils.lastIndexOfIgnoreCase("aabaabaa", "B", 0)); 
     assertEquals(0, StringUtils.lastIndexOfIgnoreCase("aabaabaa", "A", 0)); 
     assertEquals(1, StringUtils.lastIndexOfIgnoreCase("aab", "AB", 1)); 
 }
@Test
public void testEquals4063() { 
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
public void testIndexOf_StringInt4080() { 
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
public void testIndexOfAnyBut_StringStringWithSupplementaryChars4087() { 
     assertEquals(2, StringUtils.indexOfAnyBut(CharU20000 + CharU20001, CharU20000)); 
     assertEquals(0, StringUtils.indexOfAnyBut(CharU20000 + CharU20001, CharU20001)); 
     assertEquals(-1, StringUtils.indexOfAnyBut(CharU20000, CharU20000)); 
     assertEquals(0, StringUtils.indexOfAnyBut(CharU20000, CharU20001)); 
 }
@Test
public void testIndexOfAny_StringCharArray4104() { 
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
public void testEqualsIgnoreCase4141() { 
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
public void testContainsOnly_CharArray4170() { 
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
public void testContainsAny_StringCharArrayWithSupplementaryChars4197() { 
     assertTrue(StringUtils.containsAny(CharU20000 + CharU20001, CharU20000.toCharArray())); 
     assertTrue(StringUtils.containsAny("a" + CharU20000 + CharU20001, "a".toCharArray())); 
     assertTrue(StringUtils.containsAny(CharU20000 + "a" + CharU20001, "a".toCharArray())); 
     assertTrue(StringUtils.containsAny(CharU20000 + CharU20001 + "a", "a".toCharArray())); 
     assertTrue(StringUtils.containsAny(CharU20000 + CharU20001, CharU20001.toCharArray())); 
     assertTrue(StringUtils.containsAny(CharU20000, CharU20000.toCharArray())); 
     assertEquals(-1, CharU20000.indexOf(CharU20001)); 
     assertEquals(0, CharU20000.indexOf(CharU20001.charAt(0))); 
     assertEquals(-1, CharU20000.indexOf(CharU20001.charAt(1))); 
     assertFalse(StringUtils.containsAny(CharU20000, CharU20001.toCharArray())); 
     assertFalse(StringUtils.containsAny(CharU20001, CharU20000.toCharArray())); 
 }
@Test
public void testIndexOfAny_StringStringArray4205() { 
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
@Test
public void testIndexOfAny_StringStringArray4209() { 
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
@Test
public void testContainsNone_StringWithSupplementaryChars4253() { 
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
public void testIndexOfAny_StringStringWithSupplementaryChars4281() { 
     assertEquals(0, StringUtils.indexOfAny(CharU20000 + CharU20001, CharU20000)); 
     assertEquals(2, StringUtils.indexOfAny(CharU20000 + CharU20001, CharU20001)); 
     assertEquals(0, StringUtils.indexOfAny(CharU20000, CharU20000)); 
     assertEquals(-1, StringUtils.indexOfAny(CharU20000, CharU20001)); 
 }
@Test
public void testContainsIgnoreCase_LocaleIndependence4376() { 
     final Locale orig = Locale.getDefault(); 
     final Locale[] locales = { Locale.ENGLISH, new Locale("tr"), Locale.getDefault() }; 
     final String[][] tdata = { { "i", "I" }, { "I", "i" }, { "\u03C2", "\u03C3" }, { "\u03A3", "\u03C2" }, { "\u03A3", "\u03C3" } }; 
     final String[][] fdata = { { "\u00DF", "SS" } }; 
     try { 
         for (final Locale locale : locales) { 
             Locale.setDefault(locale); 
             for (int j = 0; j < tdata.length; j++) { 
                 assertTrue(Locale.getDefault() + ": " + j + " " + tdata[j][0] + " " + tdata[j][1], StringUtils.containsIgnoreCase(tdata[j][0], tdata[j][1])); 
             } 
             for (int j = 0; j < fdata.length; j++) { 
                 assertFalse(Locale.getDefault() + ": " + j + " " + fdata[j][0] + " " + fdata[j][1], StringUtils.containsIgnoreCase(fdata[j][0], fdata[j][1])); 
             } 
         } 
     } finally { 
         Locale.setDefault(orig); 
     } 
 }
@Test
public void testOrdinalIndexOf4396() { 
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
public void testContainsNone_StringWithSupplementaryChars4519() { 
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
public void testIndexOfAny_StringStringArray4531() { 
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
@Test
public void testIndexOf_String4561() { 
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
public void testIndexOfAny_StringStringWithSupplementaryChars4577() { 
     assertEquals(0, StringUtils.indexOfAny(CharU20000 + CharU20001, CharU20000)); 
     assertEquals(2, StringUtils.indexOfAny(CharU20000 + CharU20001, CharU20001)); 
     assertEquals(0, StringUtils.indexOfAny(CharU20000, CharU20000)); 
     assertEquals(-1, StringUtils.indexOfAny(CharU20000, CharU20001)); 
 }
@Test
public void testContains_StringWithSupplementaryChars4596() { 
     assertTrue(StringUtils.contains(CharU20000 + CharU20001, CharU20000)); 
     assertTrue(StringUtils.contains(CharU20000 + CharU20001, CharU20001)); 
     assertTrue(StringUtils.contains(CharU20000, CharU20000)); 
     assertFalse(StringUtils.contains(CharU20000, CharU20001)); 
 }
@Test
public void testContainsNone_StringWithSupplementaryChars4680() { 
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
public void testEquals4745() { 
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
public void testContainsNone_StringWithSupplementaryChars4746() { 
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
public void testContainsAny_StringCharArrayWithSupplementaryChars4755() { 
     assertTrue(StringUtils.containsAny(CharU20000 + CharU20001, CharU20000.toCharArray())); 
     assertTrue(StringUtils.containsAny("a" + CharU20000 + CharU20001, "a".toCharArray())); 
     assertTrue(StringUtils.containsAny(CharU20000 + "a" + CharU20001, "a".toCharArray())); 
     assertTrue(StringUtils.containsAny(CharU20000 + CharU20001 + "a", "a".toCharArray())); 
     assertTrue(StringUtils.containsAny(CharU20000 + CharU20001, CharU20001.toCharArray())); 
     assertTrue(StringUtils.containsAny(CharU20000, CharU20000.toCharArray())); 
     assertEquals(-1, CharU20000.indexOf(CharU20001)); 
     assertEquals(0, CharU20000.indexOf(CharU20001.charAt(0))); 
     assertEquals(-1, CharU20000.indexOf(CharU20001.charAt(1))); 
     assertFalse(StringUtils.containsAny(CharU20000, CharU20001.toCharArray())); 
     assertFalse(StringUtils.containsAny(CharU20001, CharU20000.toCharArray())); 
 }
@Test
public void testLastIndexOfAny_StringStringArray4757() { 
     assertEquals(-1, StringUtils.lastIndexOfAny(null, (CharSequence) null)); 
     assertEquals(-1, StringUtils.lastIndexOfAny(null, (CharSequence[]) null)); 
     assertEquals(-1, StringUtils.lastIndexOfAny(null)); 
     assertEquals(-1, StringUtils.lastIndexOfAny(null, FOOBAR_SUB_ARRAY)); 
     assertEquals(-1, StringUtils.lastIndexOfAny(FOOBAR, (CharSequence) null)); 
     assertEquals(-1, StringUtils.lastIndexOfAny(FOOBAR, (CharSequence[]) null)); 
     assertEquals(-1, StringUtils.lastIndexOfAny(FOOBAR)); 
     assertEquals(3, StringUtils.lastIndexOfAny(FOOBAR, FOOBAR_SUB_ARRAY)); 
     assertEquals(-1, StringUtils.lastIndexOfAny(FOOBAR, new String[0])); 
     assertEquals(-1, StringUtils.lastIndexOfAny(null, new String[0])); 
     assertEquals(-1, StringUtils.lastIndexOfAny("", new String[0])); 
     assertEquals(-1, StringUtils.lastIndexOfAny(FOOBAR, new String[] { "llll" })); 
     assertEquals(6, StringUtils.lastIndexOfAny(FOOBAR, new String[] { "" })); 
     assertEquals(0, StringUtils.lastIndexOfAny("", new String[] { "" })); 
     assertEquals(-1, StringUtils.lastIndexOfAny("", new String[] { "a" })); 
     assertEquals(-1, StringUtils.lastIndexOfAny("", new String[] { null })); 
     assertEquals(-1, StringUtils.lastIndexOfAny(FOOBAR, new String[] { null })); 
     assertEquals(-1, StringUtils.lastIndexOfAny(null, new String[] { null })); 
 }
@Test
public void testLastIndexOf_char4759() { 
     assertEquals(-1, StringUtils.lastIndexOf(null, ' ')); 
     assertEquals(-1, StringUtils.lastIndexOf("", ' ')); 
     assertEquals(7, StringUtils.lastIndexOf("aabaabaa", 'a')); 
     assertEquals(5, StringUtils.lastIndexOf("aabaabaa", 'b')); 
     assertEquals(5, StringUtils.lastIndexOf(new StringBuilder("aabaabaa"), 'b')); 
 }
@Test
public void testIndexOfIgnoreCase_String4858() { 
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
public void testContainsWhitespace4926() { 
     assertFalse(StringUtils.containsWhitespace("")); 
     assertTrue(StringUtils.containsWhitespace(" ")); 
     assertFalse(StringUtils.containsWhitespace("a")); 
     assertTrue(StringUtils.containsWhitespace("a ")); 
     assertTrue(StringUtils.containsWhitespace(" a")); 
     assertTrue(StringUtils.containsWhitespace("a\t")); 
     assertTrue(StringUtils.containsWhitespace("\n")); 
 }
@Test
public void testContains_Char4957() { 
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
public void testEquals4982() { 
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
public void testIndexOfAny_StringStringArray5065() { 
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
@Test
public void testContains_Char5077() { 
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
public void testIndexOf_charInt5197() { 
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
public void testIndexOfAny_StringStringArray5219() { 
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
@Test
public void testEquals5225() { 
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
public void testContainsAny_StringString5256() { 
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
public void testLastIndexOfIgnoreCase_StringInt5308() { 
     assertEquals(-1, StringUtils.lastIndexOfIgnoreCase(null, null, 0)); 
     assertEquals(-1, StringUtils.lastIndexOfIgnoreCase(null, null, -1)); 
     assertEquals(-1, StringUtils.lastIndexOfIgnoreCase(null, "", 0)); 
     assertEquals(-1, StringUtils.lastIndexOfIgnoreCase(null, "", -1)); 
     assertEquals(-1, StringUtils.lastIndexOfIgnoreCase("", null, 0)); 
     assertEquals(-1, StringUtils.lastIndexOfIgnoreCase("", null, -1)); 
     assertEquals(0, StringUtils.lastIndexOfIgnoreCase("", "", 0)); 
     assertEquals(-1, StringUtils.lastIndexOfIgnoreCase("", "", -1)); 
     assertEquals(0, StringUtils.lastIndexOfIgnoreCase("", "", 9)); 
     assertEquals(0, StringUtils.lastIndexOfIgnoreCase("abc", "", 0)); 
     assertEquals(-1, StringUtils.lastIndexOfIgnoreCase("abc", "", -1)); 
     assertEquals(3, StringUtils.lastIndexOfIgnoreCase("abc", "", 9)); 
     assertEquals(7, StringUtils.lastIndexOfIgnoreCase("aabaabaa", "A", 8)); 
     assertEquals(5, StringUtils.lastIndexOfIgnoreCase("aabaabaa", "B", 8)); 
     assertEquals(4, StringUtils.lastIndexOfIgnoreCase("aabaabaa", "AB", 8)); 
     assertEquals(2, StringUtils.lastIndexOfIgnoreCase("aabaabaa", "B", 3)); 
     assertEquals(5, StringUtils.lastIndexOfIgnoreCase("aabaabaa", "B", 9)); 
     assertEquals(-1, StringUtils.lastIndexOfIgnoreCase("aabaabaa", "B", -1)); 
     assertEquals(-1, StringUtils.lastIndexOfIgnoreCase("aabaabaa", "B", 0)); 
     assertEquals(0, StringUtils.lastIndexOfIgnoreCase("aabaabaa", "A", 0)); 
     assertEquals(1, StringUtils.lastIndexOfIgnoreCase("aab", "AB", 1)); 
 }
@Test
public void testContainsNone_StringWithSupplementaryChars5342() { 
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
public void testIndexOfIgnoreCase_String5346() { 
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
public void testLastIndexOfAny_StringStringArray5383() { 
     assertEquals(-1, StringUtils.lastIndexOfAny(null, (CharSequence) null)); 
     assertEquals(-1, StringUtils.lastIndexOfAny(null, (CharSequence[]) null)); 
     assertEquals(-1, StringUtils.lastIndexOfAny(null)); 
     assertEquals(-1, StringUtils.lastIndexOfAny(null, FOOBAR_SUB_ARRAY)); 
     assertEquals(-1, StringUtils.lastIndexOfAny(FOOBAR, (CharSequence) null)); 
     assertEquals(-1, StringUtils.lastIndexOfAny(FOOBAR, (CharSequence[]) null)); 
     assertEquals(-1, StringUtils.lastIndexOfAny(FOOBAR)); 
     assertEquals(3, StringUtils.lastIndexOfAny(FOOBAR, FOOBAR_SUB_ARRAY)); 
     assertEquals(-1, StringUtils.lastIndexOfAny(FOOBAR, new String[0])); 
     assertEquals(-1, StringUtils.lastIndexOfAny(null, new String[0])); 
     assertEquals(-1, StringUtils.lastIndexOfAny("", new String[0])); 
     assertEquals(-1, StringUtils.lastIndexOfAny(FOOBAR, new String[] { "llll" })); 
     assertEquals(6, StringUtils.lastIndexOfAny(FOOBAR, new String[] { "" })); 
     assertEquals(0, StringUtils.lastIndexOfAny("", new String[] { "" })); 
     assertEquals(-1, StringUtils.lastIndexOfAny("", new String[] { "a" })); 
     assertEquals(-1, StringUtils.lastIndexOfAny("", new String[] { null })); 
     assertEquals(-1, StringUtils.lastIndexOfAny(FOOBAR, new String[] { null })); 
     assertEquals(-1, StringUtils.lastIndexOfAny(null, new String[] { null })); 
 }
@Test
public void testLastIndexOf_char5633() { 
     assertEquals(-1, StringUtils.lastIndexOf(null, ' ')); 
     assertEquals(-1, StringUtils.lastIndexOf("", ' ')); 
     assertEquals(7, StringUtils.lastIndexOf("aabaabaa", 'a')); 
     assertEquals(5, StringUtils.lastIndexOf("aabaabaa", 'b')); 
     assertEquals(5, StringUtils.lastIndexOf(new StringBuilder("aabaabaa"), 'b')); 
 }
@Test
public void testContainsIgnoreCase_LocaleIndependence5707() { 
     final Locale orig = Locale.getDefault(); 
     final Locale[] locales = { Locale.ENGLISH, new Locale("tr"), Locale.getDefault() }; 
     final String[][] tdata = { { "i", "I" }, { "I", "i" }, { "\u03C2", "\u03C3" }, { "\u03A3", "\u03C2" }, { "\u03A3", "\u03C3" } }; 
     final String[][] fdata = { { "\u00DF", "SS" } }; 
     try { 
         for (final Locale locale : locales) { 
             Locale.setDefault(locale); 
             for (int j = 0; j < tdata.length; j++) { 
                 assertTrue(Locale.getDefault() + ": " + j + " " + tdata[j][0] + " " + tdata[j][1], StringUtils.containsIgnoreCase(tdata[j][0], tdata[j][1])); 
             } 
             for (int j = 0; j < fdata.length; j++) { 
                 assertFalse(Locale.getDefault() + ": " + j + " " + fdata[j][0] + " " + fdata[j][1], StringUtils.containsIgnoreCase(fdata[j][0], fdata[j][1])); 
             } 
         } 
     } finally { 
         Locale.setDefault(orig); 
     } 
 }
@Test
public void testEquals5776() { 
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
public void testIndexOf_charInt5795() { 
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
public void testContainsIgnoreCase_LocaleIndependence5821() { 
     final Locale orig = Locale.getDefault(); 
     final Locale[] locales = { Locale.ENGLISH, new Locale("tr"), Locale.getDefault() }; 
     final String[][] tdata = { { "i", "I" }, { "I", "i" }, { "\u03C2", "\u03C3" }, { "\u03A3", "\u03C2" }, { "\u03A3", "\u03C3" } }; 
     final String[][] fdata = { { "\u00DF", "SS" } }; 
     try { 
         for (final Locale locale : locales) { 
             Locale.setDefault(locale); 
             for (int j = 0; j < tdata.length; j++) { 
                 assertTrue(Locale.getDefault() + ": " + j + " " + tdata[j][0] + " " + tdata[j][1], StringUtils.containsIgnoreCase(tdata[j][0], tdata[j][1])); 
             } 
             for (int j = 0; j < fdata.length; j++) { 
                 assertFalse(Locale.getDefault() + ": " + j + " " + fdata[j][0] + " " + fdata[j][1], StringUtils.containsIgnoreCase(fdata[j][0], fdata[j][1])); 
             } 
         } 
     } finally { 
         Locale.setDefault(orig); 
     } 
 }
@Test
public void testIndexOf_StringInt5872() { 
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
public void testContains_StringWithSupplementaryChars5882() { 
     assertTrue(StringUtils.contains(CharU20000 + CharU20001, CharU20000)); 
     assertTrue(StringUtils.contains(CharU20000 + CharU20001, CharU20001)); 
     assertTrue(StringUtils.contains(CharU20000, CharU20000)); 
     assertFalse(StringUtils.contains(CharU20000, CharU20001)); 
 }
@Test
public void testLastIndexOf_char5896() { 
     assertEquals(-1, StringUtils.lastIndexOf(null, ' ')); 
     assertEquals(-1, StringUtils.lastIndexOf("", ' ')); 
     assertEquals(7, StringUtils.lastIndexOf("aabaabaa", 'a')); 
     assertEquals(5, StringUtils.lastIndexOf("aabaabaa", 'b')); 
     assertEquals(5, StringUtils.lastIndexOf(new StringBuilder("aabaabaa"), 'b')); 
 }
@Test
public void testLastIndexOfIgnoreCase_String5941() { 
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
public void testLastIndexOfAny_StringStringArray5950() { 
     assertEquals(-1, StringUtils.lastIndexOfAny(null, (CharSequence) null)); 
     assertEquals(-1, StringUtils.lastIndexOfAny(null, (CharSequence[]) null)); 
     assertEquals(-1, StringUtils.lastIndexOfAny(null)); 
     assertEquals(-1, StringUtils.lastIndexOfAny(null, FOOBAR_SUB_ARRAY)); 
     assertEquals(-1, StringUtils.lastIndexOfAny(FOOBAR, (CharSequence) null)); 
     assertEquals(-1, StringUtils.lastIndexOfAny(FOOBAR, (CharSequence[]) null)); 
     assertEquals(-1, StringUtils.lastIndexOfAny(FOOBAR)); 
     assertEquals(3, StringUtils.lastIndexOfAny(FOOBAR, FOOBAR_SUB_ARRAY)); 
     assertEquals(-1, StringUtils.lastIndexOfAny(FOOBAR, new String[0])); 
     assertEquals(-1, StringUtils.lastIndexOfAny(null, new String[0])); 
     assertEquals(-1, StringUtils.lastIndexOfAny("", new String[0])); 
     assertEquals(-1, StringUtils.lastIndexOfAny(FOOBAR, new String[] { "llll" })); 
     assertEquals(6, StringUtils.lastIndexOfAny(FOOBAR, new String[] { "" })); 
     assertEquals(0, StringUtils.lastIndexOfAny("", new String[] { "" })); 
     assertEquals(-1, StringUtils.lastIndexOfAny("", new String[] { "a" })); 
     assertEquals(-1, StringUtils.lastIndexOfAny("", new String[] { null })); 
     assertEquals(-1, StringUtils.lastIndexOfAny(FOOBAR, new String[] { null })); 
     assertEquals(-1, StringUtils.lastIndexOfAny(null, new String[] { null })); 
 }
@Test
public void testContainsAny_StringCharArray6061() { 
     assertFalse(StringUtils.containsAny(null, (char[]) null)); 
     assertFalse(StringUtils.containsAny(null, new char[0])); 
     assertFalse(StringUtils.containsAny(null, new char[] { 'a', 'b' })); 
     assertFalse(StringUtils.containsAny("", (char[]) null)); 
     assertFalse(StringUtils.containsAny("", new char[0])); 
     assertFalse(StringUtils.containsAny("", new char[] { 'a', 'b' })); 
     assertFalse(StringUtils.containsAny("zzabyycdxx", (char[]) null)); 
     assertFalse(StringUtils.containsAny("zzabyycdxx", new char[0])); 
     assertTrue(StringUtils.containsAny("zzabyycdxx", new char[] { 'z', 'a' })); 
     assertTrue(StringUtils.containsAny("zzabyycdxx", new char[] { 'b', 'y' })); 
     assertFalse(StringUtils.containsAny("ab", new char[] { 'z' })); 
 }
@Test
public void testContainsIgnoreCase_LocaleIndependence6063() { 
     final Locale orig = Locale.getDefault(); 
     final Locale[] locales = { Locale.ENGLISH, new Locale("tr"), Locale.getDefault() }; 
     final String[][] tdata = { { "i", "I" }, { "I", "i" }, { "\u03C2", "\u03C3" }, { "\u03A3", "\u03C2" }, { "\u03A3", "\u03C3" } }; 
     final String[][] fdata = { { "\u00DF", "SS" } }; 
     try { 
         for (final Locale locale : locales) { 
             Locale.setDefault(locale); 
             for (int j = 0; j < tdata.length; j++) { 
                 assertTrue(Locale.getDefault() + ": " + j + " " + tdata[j][0] + " " + tdata[j][1], StringUtils.containsIgnoreCase(tdata[j][0], tdata[j][1])); 
             } 
             for (int j = 0; j < fdata.length; j++) { 
                 assertFalse(Locale.getDefault() + ": " + j + " " + fdata[j][0] + " " + fdata[j][1], StringUtils.containsIgnoreCase(fdata[j][0], fdata[j][1])); 
             } 
         } 
     } finally { 
         Locale.setDefault(orig); 
     } 
 }
@Test
public void testIndexOfAny_StringStringArray6083() { 
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
@Test
public void testContains_Char6100() { 
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
public void testIndexOfAny_StringStringArray6152() { 
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
@Test
public void testOrdinalIndexOf6166() { 
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
public void testLastIndexOf_String6181() { 
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
public void testIndexOfIgnoreCase_StringInt6202() { 
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
public void testIndexOfAny_StringStringArray6210() { 
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
@Test
public void testIndexOfAnyBut_StringString6219() { 
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
public void testOrdinalIndexOf6244() { 
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
public void testIndexOf_String6281() { 
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
public void testIndexOf_StringInt6373() { 
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
public void testLastIndexOfIgnoreCase_StringInt6375() { 
     assertEquals(-1, StringUtils.lastIndexOfIgnoreCase(null, null, 0)); 
     assertEquals(-1, StringUtils.lastIndexOfIgnoreCase(null, null, -1)); 
     assertEquals(-1, StringUtils.lastIndexOfIgnoreCase(null, "", 0)); 
     assertEquals(-1, StringUtils.lastIndexOfIgnoreCase(null, "", -1)); 
     assertEquals(-1, StringUtils.lastIndexOfIgnoreCase("", null, 0)); 
     assertEquals(-1, StringUtils.lastIndexOfIgnoreCase("", null, -1)); 
     assertEquals(0, StringUtils.lastIndexOfIgnoreCase("", "", 0)); 
     assertEquals(-1, StringUtils.lastIndexOfIgnoreCase("", "", -1)); 
     assertEquals(0, StringUtils.lastIndexOfIgnoreCase("", "", 9)); 
     assertEquals(0, StringUtils.lastIndexOfIgnoreCase("abc", "", 0)); 
     assertEquals(-1, StringUtils.lastIndexOfIgnoreCase("abc", "", -1)); 
     assertEquals(3, StringUtils.lastIndexOfIgnoreCase("abc", "", 9)); 
     assertEquals(7, StringUtils.lastIndexOfIgnoreCase("aabaabaa", "A", 8)); 
     assertEquals(5, StringUtils.lastIndexOfIgnoreCase("aabaabaa", "B", 8)); 
     assertEquals(4, StringUtils.lastIndexOfIgnoreCase("aabaabaa", "AB", 8)); 
     assertEquals(2, StringUtils.lastIndexOfIgnoreCase("aabaabaa", "B", 3)); 
     assertEquals(5, StringUtils.lastIndexOfIgnoreCase("aabaabaa", "B", 9)); 
     assertEquals(-1, StringUtils.lastIndexOfIgnoreCase("aabaabaa", "B", -1)); 
     assertEquals(-1, StringUtils.lastIndexOfIgnoreCase("aabaabaa", "B", 0)); 
     assertEquals(0, StringUtils.lastIndexOfIgnoreCase("aabaabaa", "A", 0)); 
     assertEquals(1, StringUtils.lastIndexOfIgnoreCase("aab", "AB", 1)); 
 }
@Test
public void testIndexOfAny_StringStringWithSupplementaryChars6405() { 
     assertEquals(0, StringUtils.indexOfAny(CharU20000 + CharU20001, CharU20000)); 
     assertEquals(2, StringUtils.indexOfAny(CharU20000 + CharU20001, CharU20001)); 
     assertEquals(0, StringUtils.indexOfAny(CharU20000, CharU20000)); 
     assertEquals(-1, StringUtils.indexOfAny(CharU20000, CharU20001)); 
 }
@Test
public void testLastIndexOfIgnoreCase_StringInt6445() { 
     assertEquals(-1, StringUtils.lastIndexOfIgnoreCase(null, null, 0)); 
     assertEquals(-1, StringUtils.lastIndexOfIgnoreCase(null, null, -1)); 
     assertEquals(-1, StringUtils.lastIndexOfIgnoreCase(null, "", 0)); 
     assertEquals(-1, StringUtils.lastIndexOfIgnoreCase(null, "", -1)); 
     assertEquals(-1, StringUtils.lastIndexOfIgnoreCase("", null, 0)); 
     assertEquals(-1, StringUtils.lastIndexOfIgnoreCase("", null, -1)); 
     assertEquals(0, StringUtils.lastIndexOfIgnoreCase("", "", 0)); 
     assertEquals(-1, StringUtils.lastIndexOfIgnoreCase("", "", -1)); 
     assertEquals(0, StringUtils.lastIndexOfIgnoreCase("", "", 9)); 
     assertEquals(0, StringUtils.lastIndexOfIgnoreCase("abc", "", 0)); 
     assertEquals(-1, StringUtils.lastIndexOfIgnoreCase("abc", "", -1)); 
     assertEquals(3, StringUtils.lastIndexOfIgnoreCase("abc", "", 9)); 
     assertEquals(7, StringUtils.lastIndexOfIgnoreCase("aabaabaa", "A", 8)); 
     assertEquals(5, StringUtils.lastIndexOfIgnoreCase("aabaabaa", "B", 8)); 
     assertEquals(4, StringUtils.lastIndexOfIgnoreCase("aabaabaa", "AB", 8)); 
     assertEquals(2, StringUtils.lastIndexOfIgnoreCase("aabaabaa", "B", 3)); 
     assertEquals(5, StringUtils.lastIndexOfIgnoreCase("aabaabaa", "B", 9)); 
     assertEquals(-1, StringUtils.lastIndexOfIgnoreCase("aabaabaa", "B", -1)); 
     assertEquals(-1, StringUtils.lastIndexOfIgnoreCase("aabaabaa", "B", 0)); 
     assertEquals(0, StringUtils.lastIndexOfIgnoreCase("aabaabaa", "A", 0)); 
     assertEquals(1, StringUtils.lastIndexOfIgnoreCase("aab", "AB", 1)); 
 }
@Test
public void testIndexOfAny_StringStringWithSupplementaryChars6452() { 
     assertEquals(0, StringUtils.indexOfAny(CharU20000 + CharU20001, CharU20000)); 
     assertEquals(2, StringUtils.indexOfAny(CharU20000 + CharU20001, CharU20001)); 
     assertEquals(0, StringUtils.indexOfAny(CharU20000, CharU20000)); 
     assertEquals(-1, StringUtils.indexOfAny(CharU20000, CharU20001)); 
 }
@Test
public void testEquals6458() { 
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
public void testLastIndexOf_String6493() { 
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
public void testLastIndexOf_String6495() { 
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
public void testContainsAny_StringCharArrayWithSupplementaryChars6500() { 
     assertTrue(StringUtils.containsAny(CharU20000 + CharU20001, CharU20000.toCharArray())); 
     assertTrue(StringUtils.containsAny("a" + CharU20000 + CharU20001, "a".toCharArray())); 
     assertTrue(StringUtils.containsAny(CharU20000 + "a" + CharU20001, "a".toCharArray())); 
     assertTrue(StringUtils.containsAny(CharU20000 + CharU20001 + "a", "a".toCharArray())); 
     assertTrue(StringUtils.containsAny(CharU20000 + CharU20001, CharU20001.toCharArray())); 
     assertTrue(StringUtils.containsAny(CharU20000, CharU20000.toCharArray())); 
     assertEquals(-1, CharU20000.indexOf(CharU20001)); 
     assertEquals(0, CharU20000.indexOf(CharU20001.charAt(0))); 
     assertEquals(-1, CharU20000.indexOf(CharU20001.charAt(1))); 
     assertFalse(StringUtils.containsAny(CharU20000, CharU20001.toCharArray())); 
     assertFalse(StringUtils.containsAny(CharU20001, CharU20000.toCharArray())); 
 }
@Test
public void testContainsOnly_CharArray6501() { 
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
public void testContainsAny_StringWithBadSupplementaryChars6589() { 
     assertFalse(StringUtils.containsAny(CharUSuppCharHigh, CharU20001)); 
     assertEquals(-1, CharUSuppCharLow.indexOf(CharU20001)); 
     assertFalse(StringUtils.containsAny(CharUSuppCharLow, CharU20001)); 
     assertFalse(StringUtils.containsAny(CharU20001, CharUSuppCharHigh)); 
     assertEquals(0, CharU20001.indexOf(CharUSuppCharLow)); 
     assertTrue(StringUtils.containsAny(CharU20001, CharUSuppCharLow)); 
 }
@Test
public void testLastIndexOf_char6598() { 
     assertEquals(-1, StringUtils.lastIndexOf(null, ' ')); 
     assertEquals(-1, StringUtils.lastIndexOf("", ' ')); 
     assertEquals(7, StringUtils.lastIndexOf("aabaabaa", 'a')); 
     assertEquals(5, StringUtils.lastIndexOf("aabaabaa", 'b')); 
     assertEquals(5, StringUtils.lastIndexOf(new StringBuilder("aabaabaa"), 'b')); 
 }
@Test
public void testIndexOf_charInt6602() { 
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
public void testOrdinalIndexOf6614() { 
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
public void testEquals6745() { 
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
public void testIndexOfAnyBut_StringStringWithSupplementaryChars6756() { 
     assertEquals(2, StringUtils.indexOfAnyBut(CharU20000 + CharU20001, CharU20000)); 
     assertEquals(0, StringUtils.indexOfAnyBut(CharU20000 + CharU20001, CharU20001)); 
     assertEquals(-1, StringUtils.indexOfAnyBut(CharU20000, CharU20000)); 
     assertEquals(0, StringUtils.indexOfAnyBut(CharU20000, CharU20001)); 
 }
@Test
public void testIndexOfAny_StringStringWithSupplementaryChars6803() { 
     assertEquals(0, StringUtils.indexOfAny(CharU20000 + CharU20001, CharU20000)); 
     assertEquals(2, StringUtils.indexOfAny(CharU20000 + CharU20001, CharU20001)); 
     assertEquals(0, StringUtils.indexOfAny(CharU20000, CharU20000)); 
     assertEquals(-1, StringUtils.indexOfAny(CharU20000, CharU20001)); 
 }
@Test
public void testIndexOf_charInt6841() { 
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
public void testEqualsIgnoreCase6852() { 
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
public void testContainsNone_StringWithSupplementaryChars6873() { 
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
public void testLastIndexOf_char6890() { 
     assertEquals(-1, StringUtils.lastIndexOf(null, ' ')); 
     assertEquals(-1, StringUtils.lastIndexOf("", ' ')); 
     assertEquals(7, StringUtils.lastIndexOf("aabaabaa", 'a')); 
     assertEquals(5, StringUtils.lastIndexOf("aabaabaa", 'b')); 
     assertEquals(5, StringUtils.lastIndexOf(new StringBuilder("aabaabaa"), 'b')); 
 }
@Test
public void testContainsWhitespace6937() { 
     assertFalse(StringUtils.containsWhitespace("")); 
     assertTrue(StringUtils.containsWhitespace(" ")); 
     assertFalse(StringUtils.containsWhitespace("a")); 
     assertTrue(StringUtils.containsWhitespace("a ")); 
     assertTrue(StringUtils.containsWhitespace(" a")); 
     assertTrue(StringUtils.containsWhitespace("a\t")); 
     assertTrue(StringUtils.containsWhitespace("\n")); 
 }
@Test
public void testContainsNone_StringWithSupplementaryChars6977() { 
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
public void testLastIndexOf_charInt6988() { 
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
public void testOrdinalIndexOf7072() { 
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
public void testIndexOfAnyBut_StringStringWithSupplementaryChars7135() { 
     assertEquals(2, StringUtils.indexOfAnyBut(CharU20000 + CharU20001, CharU20000)); 
     assertEquals(0, StringUtils.indexOfAnyBut(CharU20000 + CharU20001, CharU20001)); 
     assertEquals(-1, StringUtils.indexOfAnyBut(CharU20000, CharU20000)); 
     assertEquals(0, StringUtils.indexOfAnyBut(CharU20000, CharU20001)); 
 }
@Test
public void testLastIndexOfIgnoreCase_StringInt7174() { 
     assertEquals(-1, StringUtils.lastIndexOfIgnoreCase(null, null, 0)); 
     assertEquals(-1, StringUtils.lastIndexOfIgnoreCase(null, null, -1)); 
     assertEquals(-1, StringUtils.lastIndexOfIgnoreCase(null, "", 0)); 
     assertEquals(-1, StringUtils.lastIndexOfIgnoreCase(null, "", -1)); 
     assertEquals(-1, StringUtils.lastIndexOfIgnoreCase("", null, 0)); 
     assertEquals(-1, StringUtils.lastIndexOfIgnoreCase("", null, -1)); 
     assertEquals(0, StringUtils.lastIndexOfIgnoreCase("", "", 0)); 
     assertEquals(-1, StringUtils.lastIndexOfIgnoreCase("", "", -1)); 
     assertEquals(0, StringUtils.lastIndexOfIgnoreCase("", "", 9)); 
     assertEquals(0, StringUtils.lastIndexOfIgnoreCase("abc", "", 0)); 
     assertEquals(-1, StringUtils.lastIndexOfIgnoreCase("abc", "", -1)); 
     assertEquals(3, StringUtils.lastIndexOfIgnoreCase("abc", "", 9)); 
     assertEquals(7, StringUtils.lastIndexOfIgnoreCase("aabaabaa", "A", 8)); 
     assertEquals(5, StringUtils.lastIndexOfIgnoreCase("aabaabaa", "B", 8)); 
     assertEquals(4, StringUtils.lastIndexOfIgnoreCase("aabaabaa", "AB", 8)); 
     assertEquals(2, StringUtils.lastIndexOfIgnoreCase("aabaabaa", "B", 3)); 
     assertEquals(5, StringUtils.lastIndexOfIgnoreCase("aabaabaa", "B", 9)); 
     assertEquals(-1, StringUtils.lastIndexOfIgnoreCase("aabaabaa", "B", -1)); 
     assertEquals(-1, StringUtils.lastIndexOfIgnoreCase("aabaabaa", "B", 0)); 
     assertEquals(0, StringUtils.lastIndexOfIgnoreCase("aabaabaa", "A", 0)); 
     assertEquals(1, StringUtils.lastIndexOfIgnoreCase("aab", "AB", 1)); 
 }
@Test
public void testOrdinalIndexOf7203() { 
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
public void testIndexOf_charInt7217() { 
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
public void testIndexOfAnyBut_StringStringWithSupplementaryChars7266() { 
     assertEquals(2, StringUtils.indexOfAnyBut(CharU20000 + CharU20001, CharU20000)); 
     assertEquals(0, StringUtils.indexOfAnyBut(CharU20000 + CharU20001, CharU20001)); 
     assertEquals(-1, StringUtils.indexOfAnyBut(CharU20000, CharU20000)); 
     assertEquals(0, StringUtils.indexOfAnyBut(CharU20000, CharU20001)); 
 }
@Test
public void testContainsIgnoreCase_StringString7286() { 
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
public void testEquals7291() { 
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
public void testIndexOfAny_StringString7373() { 
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
public void testLastIndexOfAny_StringStringArray7392() { 
     assertEquals(-1, StringUtils.lastIndexOfAny(null, (CharSequence) null)); 
     assertEquals(-1, StringUtils.lastIndexOfAny(null, (CharSequence[]) null)); 
     assertEquals(-1, StringUtils.lastIndexOfAny(null)); 
     assertEquals(-1, StringUtils.lastIndexOfAny(null, FOOBAR_SUB_ARRAY)); 
     assertEquals(-1, StringUtils.lastIndexOfAny(FOOBAR, (CharSequence) null)); 
     assertEquals(-1, StringUtils.lastIndexOfAny(FOOBAR, (CharSequence[]) null)); 
     assertEquals(-1, StringUtils.lastIndexOfAny(FOOBAR)); 
     assertEquals(3, StringUtils.lastIndexOfAny(FOOBAR, FOOBAR_SUB_ARRAY)); 
     assertEquals(-1, StringUtils.lastIndexOfAny(FOOBAR, new String[0])); 
     assertEquals(-1, StringUtils.lastIndexOfAny(null, new String[0])); 
     assertEquals(-1, StringUtils.lastIndexOfAny("", new String[0])); 
     assertEquals(-1, StringUtils.lastIndexOfAny(FOOBAR, new String[] { "llll" })); 
     assertEquals(6, StringUtils.lastIndexOfAny(FOOBAR, new String[] { "" })); 
     assertEquals(0, StringUtils.lastIndexOfAny("", new String[] { "" })); 
     assertEquals(-1, StringUtils.lastIndexOfAny("", new String[] { "a" })); 
     assertEquals(-1, StringUtils.lastIndexOfAny("", new String[] { null })); 
     assertEquals(-1, StringUtils.lastIndexOfAny(FOOBAR, new String[] { null })); 
     assertEquals(-1, StringUtils.lastIndexOfAny(null, new String[] { null })); 
 }
@Test
public void testOrdinalIndexOf7396() { 
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
public void testLastIndexOfIgnoreCase_StringInt7425() { 
     assertEquals(-1, StringUtils.lastIndexOfIgnoreCase(null, null, 0)); 
     assertEquals(-1, StringUtils.lastIndexOfIgnoreCase(null, null, -1)); 
     assertEquals(-1, StringUtils.lastIndexOfIgnoreCase(null, "", 0)); 
     assertEquals(-1, StringUtils.lastIndexOfIgnoreCase(null, "", -1)); 
     assertEquals(-1, StringUtils.lastIndexOfIgnoreCase("", null, 0)); 
     assertEquals(-1, StringUtils.lastIndexOfIgnoreCase("", null, -1)); 
     assertEquals(0, StringUtils.lastIndexOfIgnoreCase("", "", 0)); 
     assertEquals(-1, StringUtils.lastIndexOfIgnoreCase("", "", -1)); 
     assertEquals(0, StringUtils.lastIndexOfIgnoreCase("", "", 9)); 
     assertEquals(0, StringUtils.lastIndexOfIgnoreCase("abc", "", 0)); 
     assertEquals(-1, StringUtils.lastIndexOfIgnoreCase("abc", "", -1)); 
     assertEquals(3, StringUtils.lastIndexOfIgnoreCase("abc", "", 9)); 
     assertEquals(7, StringUtils.lastIndexOfIgnoreCase("aabaabaa", "A", 8)); 
     assertEquals(5, StringUtils.lastIndexOfIgnoreCase("aabaabaa", "B", 8)); 
     assertEquals(4, StringUtils.lastIndexOfIgnoreCase("aabaabaa", "AB", 8)); 
     assertEquals(2, StringUtils.lastIndexOfIgnoreCase("aabaabaa", "B", 3)); 
     assertEquals(5, StringUtils.lastIndexOfIgnoreCase("aabaabaa", "B", 9)); 
     assertEquals(-1, StringUtils.lastIndexOfIgnoreCase("aabaabaa", "B", -1)); 
     assertEquals(-1, StringUtils.lastIndexOfIgnoreCase("aabaabaa", "B", 0)); 
     assertEquals(0, StringUtils.lastIndexOfIgnoreCase("aabaabaa", "A", 0)); 
     assertEquals(1, StringUtils.lastIndexOfIgnoreCase("aab", "AB", 1)); 
 }
@Test
public void testOrdinalIndexOf7483() { 
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
public void testIndexOfIgnoreCase_StringInt7501() { 
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
public void testIndexOfAny_StringStringWithSupplementaryChars7532() { 
     assertEquals(0, StringUtils.indexOfAny(CharU20000 + CharU20001, CharU20000)); 
     assertEquals(2, StringUtils.indexOfAny(CharU20000 + CharU20001, CharU20001)); 
     assertEquals(0, StringUtils.indexOfAny(CharU20000, CharU20000)); 
     assertEquals(-1, StringUtils.indexOfAny(CharU20000, CharU20001)); 
 }
@Test
public void testLastIndexOf_charInt7543() { 
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
public void testEquals7546() { 
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
public void testContainsAny_StringCharArrayWithSupplementaryChars7560() { 
     assertTrue(StringUtils.containsAny(CharU20000 + CharU20001, CharU20000.toCharArray())); 
     assertTrue(StringUtils.containsAny("a" + CharU20000 + CharU20001, "a".toCharArray())); 
     assertTrue(StringUtils.containsAny(CharU20000 + "a" + CharU20001, "a".toCharArray())); 
     assertTrue(StringUtils.containsAny(CharU20000 + CharU20001 + "a", "a".toCharArray())); 
     assertTrue(StringUtils.containsAny(CharU20000 + CharU20001, CharU20001.toCharArray())); 
     assertTrue(StringUtils.containsAny(CharU20000, CharU20000.toCharArray())); 
     assertEquals(-1, CharU20000.indexOf(CharU20001)); 
     assertEquals(0, CharU20000.indexOf(CharU20001.charAt(0))); 
     assertEquals(-1, CharU20000.indexOf(CharU20001.charAt(1))); 
     assertFalse(StringUtils.containsAny(CharU20000, CharU20001.toCharArray())); 
     assertFalse(StringUtils.containsAny(CharU20001, CharU20000.toCharArray())); 
 }
@Test
public void testContainsIgnoreCase_LocaleIndependence7736() { 
     final Locale orig = Locale.getDefault(); 
     final Locale[] locales = { Locale.ENGLISH, new Locale("tr"), Locale.getDefault() }; 
     final String[][] tdata = { { "i", "I" }, { "I", "i" }, { "\u03C2", "\u03C3" }, { "\u03A3", "\u03C2" }, { "\u03A3", "\u03C3" } }; 
     final String[][] fdata = { { "\u00DF", "SS" } }; 
     try { 
         for (final Locale locale : locales) { 
             Locale.setDefault(locale); 
             for (int j = 0; j < tdata.length; j++) { 
                 assertTrue(Locale.getDefault() + ": " + j + " " + tdata[j][0] + " " + tdata[j][1], StringUtils.containsIgnoreCase(tdata[j][0], tdata[j][1])); 
             } 
             for (int j = 0; j < fdata.length; j++) { 
                 assertFalse(Locale.getDefault() + ": " + j + " " + fdata[j][0] + " " + fdata[j][1], StringUtils.containsIgnoreCase(fdata[j][0], fdata[j][1])); 
             } 
         } 
     } finally { 
         Locale.setDefault(orig); 
     } 
 }
@Test
public void testContainsOnly_String7738() { 
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
public void testContainsNone_CharArrayWithBadSupplementaryChars7836() { 
     assertTrue(StringUtils.containsNone(CharUSuppCharHigh, CharU20001.toCharArray())); 
     assertEquals(-1, CharUSuppCharLow.indexOf(CharU20001)); 
     assertTrue(StringUtils.containsNone(CharUSuppCharLow, CharU20001.toCharArray())); 
     assertEquals(-1, CharU20001.indexOf(CharUSuppCharHigh)); 
     assertTrue(StringUtils.containsNone(CharU20001, CharUSuppCharHigh.toCharArray())); 
     assertEquals(0, CharU20001.indexOf(CharUSuppCharLow)); 
     assertFalse(StringUtils.containsNone(CharU20001, CharUSuppCharLow.toCharArray())); 
 }
@Test
public void testIndexOfAny_StringStringWithSupplementaryChars7840() { 
     assertEquals(0, StringUtils.indexOfAny(CharU20000 + CharU20001, CharU20000)); 
     assertEquals(2, StringUtils.indexOfAny(CharU20000 + CharU20001, CharU20001)); 
     assertEquals(0, StringUtils.indexOfAny(CharU20000, CharU20000)); 
     assertEquals(-1, StringUtils.indexOfAny(CharU20000, CharU20001)); 
 }
@Test
public void testOrdinalIndexOf7862() { 
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
public void testIndexOfAny_StringStringArray7886() { 
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
@Test
public void testLastIndexOf_StringInt7887() { 
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
public void testIndexOfAny_StringStringArray7951() { 
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
@Test
public void testIndexOfAny_StringStringWithSupplementaryChars7956() { 
     assertEquals(0, StringUtils.indexOfAny(CharU20000 + CharU20001, CharU20000)); 
     assertEquals(2, StringUtils.indexOfAny(CharU20000 + CharU20001, CharU20001)); 
     assertEquals(0, StringUtils.indexOfAny(CharU20000, CharU20000)); 
     assertEquals(-1, StringUtils.indexOfAny(CharU20000, CharU20001)); 
 }
@Test
public void testContainsNone_CharArray7999() { 
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
public void testContainsNone_StringWithSupplementaryChars8173() { 
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
public void testLastOrdinalIndexOf8210() { 
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
public void testContainsWhitespace8230() { 
     assertFalse(StringUtils.containsWhitespace("")); 
     assertTrue(StringUtils.containsWhitespace(" ")); 
     assertFalse(StringUtils.containsWhitespace("a")); 
     assertTrue(StringUtils.containsWhitespace("a ")); 
     assertTrue(StringUtils.containsWhitespace(" a")); 
     assertTrue(StringUtils.containsWhitespace("a\t")); 
     assertTrue(StringUtils.containsWhitespace("\n")); 
 }
@Test
public void testIndexOfAnyBut_StringStringWithSupplementaryChars8253() { 
     assertEquals(2, StringUtils.indexOfAnyBut(CharU20000 + CharU20001, CharU20000)); 
     assertEquals(0, StringUtils.indexOfAnyBut(CharU20000 + CharU20001, CharU20001)); 
     assertEquals(-1, StringUtils.indexOfAnyBut(CharU20000, CharU20000)); 
     assertEquals(0, StringUtils.indexOfAnyBut(CharU20000, CharU20001)); 
 }
@Test
public void testContains_Char8281() { 
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
public void testIndexOfIgnoreCase_StringInt8298() { 
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
public void testContainsWhitespace8385() { 
     assertFalse(StringUtils.containsWhitespace("")); 
     assertTrue(StringUtils.containsWhitespace(" ")); 
     assertFalse(StringUtils.containsWhitespace("a")); 
     assertTrue(StringUtils.containsWhitespace("a ")); 
     assertTrue(StringUtils.containsWhitespace(" a")); 
     assertTrue(StringUtils.containsWhitespace("a\t")); 
     assertTrue(StringUtils.containsWhitespace("\n")); 
 }
@Test
public void testEquals8419() { 
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
public void testOrdinalIndexOf8529() { 
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
public void testIndexOfAny_StringStringArray8536() { 
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
@Test
public void testContainsWhitespace8559() { 
     assertFalse(StringUtils.containsWhitespace("")); 
     assertTrue(StringUtils.containsWhitespace(" ")); 
     assertFalse(StringUtils.containsWhitespace("a")); 
     assertTrue(StringUtils.containsWhitespace("a ")); 
     assertTrue(StringUtils.containsWhitespace(" a")); 
     assertTrue(StringUtils.containsWhitespace("a\t")); 
     assertTrue(StringUtils.containsWhitespace("\n")); 
 }
@Test
public void testContainsNone_StringWithSupplementaryChars8578() { 
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
public void testEquals8593() { 
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
public void testLastIndexOf_char8609() { 
     assertEquals(-1, StringUtils.lastIndexOf(null, ' ')); 
     assertEquals(-1, StringUtils.lastIndexOf("", ' ')); 
     assertEquals(7, StringUtils.lastIndexOf("aabaabaa", 'a')); 
     assertEquals(5, StringUtils.lastIndexOf("aabaabaa", 'b')); 
     assertEquals(5, StringUtils.lastIndexOf(new StringBuilder("aabaabaa"), 'b')); 
 }
@Test
public void testIndexOfAny_StringStringWithSupplementaryChars8623() { 
     assertEquals(0, StringUtils.indexOfAny(CharU20000 + CharU20001, CharU20000)); 
     assertEquals(2, StringUtils.indexOfAny(CharU20000 + CharU20001, CharU20001)); 
     assertEquals(0, StringUtils.indexOfAny(CharU20000, CharU20000)); 
     assertEquals(-1, StringUtils.indexOfAny(CharU20000, CharU20001)); 
 }
@Test
public void testContainsAny_StringCharArrayWithSupplementaryChars8823() { 
     assertTrue(StringUtils.containsAny(CharU20000 + CharU20001, CharU20000.toCharArray())); 
     assertTrue(StringUtils.containsAny("a" + CharU20000 + CharU20001, "a".toCharArray())); 
     assertTrue(StringUtils.containsAny(CharU20000 + "a" + CharU20001, "a".toCharArray())); 
     assertTrue(StringUtils.containsAny(CharU20000 + CharU20001 + "a", "a".toCharArray())); 
     assertTrue(StringUtils.containsAny(CharU20000 + CharU20001, CharU20001.toCharArray())); 
     assertTrue(StringUtils.containsAny(CharU20000, CharU20000.toCharArray())); 
     assertEquals(-1, CharU20000.indexOf(CharU20001)); 
     assertEquals(0, CharU20000.indexOf(CharU20001.charAt(0))); 
     assertEquals(-1, CharU20000.indexOf(CharU20001.charAt(1))); 
     assertFalse(StringUtils.containsAny(CharU20000, CharU20001.toCharArray())); 
     assertFalse(StringUtils.containsAny(CharU20001, CharU20000.toCharArray())); 
 }
@Test
public void testContainsAny_StringCharArrayWithSupplementaryChars8824() { 
     assertTrue(StringUtils.containsAny(CharU20000 + CharU20001, CharU20000.toCharArray())); 
     assertTrue(StringUtils.containsAny("a" + CharU20000 + CharU20001, "a".toCharArray())); 
     assertTrue(StringUtils.containsAny(CharU20000 + "a" + CharU20001, "a".toCharArray())); 
     assertTrue(StringUtils.containsAny(CharU20000 + CharU20001 + "a", "a".toCharArray())); 
     assertTrue(StringUtils.containsAny(CharU20000 + CharU20001, CharU20001.toCharArray())); 
     assertTrue(StringUtils.containsAny(CharU20000, CharU20000.toCharArray())); 
     assertEquals(-1, CharU20000.indexOf(CharU20001)); 
     assertEquals(0, CharU20000.indexOf(CharU20001.charAt(0))); 
     assertEquals(-1, CharU20000.indexOf(CharU20001.charAt(1))); 
     assertFalse(StringUtils.containsAny(CharU20000, CharU20001.toCharArray())); 
     assertFalse(StringUtils.containsAny(CharU20001, CharU20000.toCharArray())); 
 }
@Test
public void testContainsAny_StringCharArrayWithSupplementaryChars8887() { 
     assertTrue(StringUtils.containsAny(CharU20000 + CharU20001, CharU20000.toCharArray())); 
     assertTrue(StringUtils.containsAny("a" + CharU20000 + CharU20001, "a".toCharArray())); 
     assertTrue(StringUtils.containsAny(CharU20000 + "a" + CharU20001, "a".toCharArray())); 
     assertTrue(StringUtils.containsAny(CharU20000 + CharU20001 + "a", "a".toCharArray())); 
     assertTrue(StringUtils.containsAny(CharU20000 + CharU20001, CharU20001.toCharArray())); 
     assertTrue(StringUtils.containsAny(CharU20000, CharU20000.toCharArray())); 
     assertEquals(-1, CharU20000.indexOf(CharU20001)); 
     assertEquals(0, CharU20000.indexOf(CharU20001.charAt(0))); 
     assertEquals(-1, CharU20000.indexOf(CharU20001.charAt(1))); 
     assertFalse(StringUtils.containsAny(CharU20000, CharU20001.toCharArray())); 
     assertFalse(StringUtils.containsAny(CharU20001, CharU20000.toCharArray())); 
 }
@Test
public void testEqualsIgnoreCase8919() { 
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
public void testContainsAny_StringCharArrayWithSupplementaryChars8947() { 
     assertTrue(StringUtils.containsAny(CharU20000 + CharU20001, CharU20000.toCharArray())); 
     assertTrue(StringUtils.containsAny("a" + CharU20000 + CharU20001, "a".toCharArray())); 
     assertTrue(StringUtils.containsAny(CharU20000 + "a" + CharU20001, "a".toCharArray())); 
     assertTrue(StringUtils.containsAny(CharU20000 + CharU20001 + "a", "a".toCharArray())); 
     assertTrue(StringUtils.containsAny(CharU20000 + CharU20001, CharU20001.toCharArray())); 
     assertTrue(StringUtils.containsAny(CharU20000, CharU20000.toCharArray())); 
     assertEquals(-1, CharU20000.indexOf(CharU20001)); 
     assertEquals(0, CharU20000.indexOf(CharU20001.charAt(0))); 
     assertEquals(-1, CharU20000.indexOf(CharU20001.charAt(1))); 
     assertFalse(StringUtils.containsAny(CharU20000, CharU20001.toCharArray())); 
     assertFalse(StringUtils.containsAny(CharU20001, CharU20000.toCharArray())); 
 }
@Test
public void testEquals8971() { 
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
public void testLastIndexOfIgnoreCase_StringInt8982() { 
     assertEquals(-1, StringUtils.lastIndexOfIgnoreCase(null, null, 0)); 
     assertEquals(-1, StringUtils.lastIndexOfIgnoreCase(null, null, -1)); 
     assertEquals(-1, StringUtils.lastIndexOfIgnoreCase(null, "", 0)); 
     assertEquals(-1, StringUtils.lastIndexOfIgnoreCase(null, "", -1)); 
     assertEquals(-1, StringUtils.lastIndexOfIgnoreCase("", null, 0)); 
     assertEquals(-1, StringUtils.lastIndexOfIgnoreCase("", null, -1)); 
     assertEquals(0, StringUtils.lastIndexOfIgnoreCase("", "", 0)); 
     assertEquals(-1, StringUtils.lastIndexOfIgnoreCase("", "", -1)); 
     assertEquals(0, StringUtils.lastIndexOfIgnoreCase("", "", 9)); 
     assertEquals(0, StringUtils.lastIndexOfIgnoreCase("abc", "", 0)); 
     assertEquals(-1, StringUtils.lastIndexOfIgnoreCase("abc", "", -1)); 
     assertEquals(3, StringUtils.lastIndexOfIgnoreCase("abc", "", 9)); 
     assertEquals(7, StringUtils.lastIndexOfIgnoreCase("aabaabaa", "A", 8)); 
     assertEquals(5, StringUtils.lastIndexOfIgnoreCase("aabaabaa", "B", 8)); 
     assertEquals(4, StringUtils.lastIndexOfIgnoreCase("aabaabaa", "AB", 8)); 
     assertEquals(2, StringUtils.lastIndexOfIgnoreCase("aabaabaa", "B", 3)); 
     assertEquals(5, StringUtils.lastIndexOfIgnoreCase("aabaabaa", "B", 9)); 
     assertEquals(-1, StringUtils.lastIndexOfIgnoreCase("aabaabaa", "B", -1)); 
     assertEquals(-1, StringUtils.lastIndexOfIgnoreCase("aabaabaa", "B", 0)); 
     assertEquals(0, StringUtils.lastIndexOfIgnoreCase("aabaabaa", "A", 0)); 
     assertEquals(1, StringUtils.lastIndexOfIgnoreCase("aab", "AB", 1)); 
 }
@Test
public void testIndexOfIgnoreCase_StringInt9005() { 
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
public void testIndexOfAnyBut_StringStringWithSupplementaryChars9065() { 
     assertEquals(2, StringUtils.indexOfAnyBut(CharU20000 + CharU20001, CharU20000)); 
     assertEquals(0, StringUtils.indexOfAnyBut(CharU20000 + CharU20001, CharU20001)); 
     assertEquals(-1, StringUtils.indexOfAnyBut(CharU20000, CharU20000)); 
     assertEquals(0, StringUtils.indexOfAnyBut(CharU20000, CharU20001)); 
 }
@Test
public void testIndexOf_char9075() { 
     assertEquals(-1, StringUtils.indexOf(null, ' ')); 
     assertEquals(-1, StringUtils.indexOf("", ' ')); 
     assertEquals(0, StringUtils.indexOf("aabaabaa", 'a')); 
     assertEquals(2, StringUtils.indexOf("aabaabaa", 'b')); 
     assertEquals(2, StringUtils.indexOf(new StringBuilder("aabaabaa"), 'b')); 
 }
@Test
public void testEquals9093() { 
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
public void testIndexOfAny_StringCharArray9100() { 
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
public void testContainsIgnoreCase_LocaleIndependence9101() { 
     final Locale orig = Locale.getDefault(); 
     final Locale[] locales = { Locale.ENGLISH, new Locale("tr"), Locale.getDefault() }; 
     final String[][] tdata = { { "i", "I" }, { "I", "i" }, { "\u03C2", "\u03C3" }, { "\u03A3", "\u03C2" }, { "\u03A3", "\u03C3" } }; 
     final String[][] fdata = { { "\u00DF", "SS" } }; 
     try { 
         for (final Locale locale : locales) { 
             Locale.setDefault(locale); 
             for (int j = 0; j < tdata.length; j++) { 
                 assertTrue(Locale.getDefault() + ": " + j + " " + tdata[j][0] + " " + tdata[j][1], StringUtils.containsIgnoreCase(tdata[j][0], tdata[j][1])); 
             } 
             for (int j = 0; j < fdata.length; j++) { 
                 assertFalse(Locale.getDefault() + ": " + j + " " + fdata[j][0] + " " + fdata[j][1], StringUtils.containsIgnoreCase(fdata[j][0], fdata[j][1])); 
             } 
         } 
     } finally { 
         Locale.setDefault(orig); 
     } 
 }
@Test
public void testContainsAny_StringString9103() { 
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
public void testLastIndexOfIgnoreCase_StringInt9139() { 
     assertEquals(-1, StringUtils.lastIndexOfIgnoreCase(null, null, 0)); 
     assertEquals(-1, StringUtils.lastIndexOfIgnoreCase(null, null, -1)); 
     assertEquals(-1, StringUtils.lastIndexOfIgnoreCase(null, "", 0)); 
     assertEquals(-1, StringUtils.lastIndexOfIgnoreCase(null, "", -1)); 
     assertEquals(-1, StringUtils.lastIndexOfIgnoreCase("", null, 0)); 
     assertEquals(-1, StringUtils.lastIndexOfIgnoreCase("", null, -1)); 
     assertEquals(0, StringUtils.lastIndexOfIgnoreCase("", "", 0)); 
     assertEquals(-1, StringUtils.lastIndexOfIgnoreCase("", "", -1)); 
     assertEquals(0, StringUtils.lastIndexOfIgnoreCase("", "", 9)); 
     assertEquals(0, StringUtils.lastIndexOfIgnoreCase("abc", "", 0)); 
     assertEquals(-1, StringUtils.lastIndexOfIgnoreCase("abc", "", -1)); 
     assertEquals(3, StringUtils.lastIndexOfIgnoreCase("abc", "", 9)); 
     assertEquals(7, StringUtils.lastIndexOfIgnoreCase("aabaabaa", "A", 8)); 
     assertEquals(5, StringUtils.lastIndexOfIgnoreCase("aabaabaa", "B", 8)); 
     assertEquals(4, StringUtils.lastIndexOfIgnoreCase("aabaabaa", "AB", 8)); 
     assertEquals(2, StringUtils.lastIndexOfIgnoreCase("aabaabaa", "B", 3)); 
     assertEquals(5, StringUtils.lastIndexOfIgnoreCase("aabaabaa", "B", 9)); 
     assertEquals(-1, StringUtils.lastIndexOfIgnoreCase("aabaabaa", "B", -1)); 
     assertEquals(-1, StringUtils.lastIndexOfIgnoreCase("aabaabaa", "B", 0)); 
     assertEquals(0, StringUtils.lastIndexOfIgnoreCase("aabaabaa", "A", 0)); 
     assertEquals(1, StringUtils.lastIndexOfIgnoreCase("aab", "AB", 1)); 
 }
@Test
public void testContainsNone_StringWithSupplementaryChars9172() { 
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
public void testLastIndexOf_char9183() { 
     assertEquals(-1, StringUtils.lastIndexOf(null, ' ')); 
     assertEquals(-1, StringUtils.lastIndexOf("", ' ')); 
     assertEquals(7, StringUtils.lastIndexOf("aabaabaa", 'a')); 
     assertEquals(5, StringUtils.lastIndexOf("aabaabaa", 'b')); 
     assertEquals(5, StringUtils.lastIndexOf(new StringBuilder("aabaabaa"), 'b')); 
 }
@Test
public void testContainsNone_StringWithSupplementaryChars9201() { 
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
public void testLastIndexOfAny_StringStringArray9217() { 
     assertEquals(-1, StringUtils.lastIndexOfAny(null, (CharSequence) null)); 
     assertEquals(-1, StringUtils.lastIndexOfAny(null, (CharSequence[]) null)); 
     assertEquals(-1, StringUtils.lastIndexOfAny(null)); 
     assertEquals(-1, StringUtils.lastIndexOfAny(null, FOOBAR_SUB_ARRAY)); 
     assertEquals(-1, StringUtils.lastIndexOfAny(FOOBAR, (CharSequence) null)); 
     assertEquals(-1, StringUtils.lastIndexOfAny(FOOBAR, (CharSequence[]) null)); 
     assertEquals(-1, StringUtils.lastIndexOfAny(FOOBAR)); 
     assertEquals(3, StringUtils.lastIndexOfAny(FOOBAR, FOOBAR_SUB_ARRAY)); 
     assertEquals(-1, StringUtils.lastIndexOfAny(FOOBAR, new String[0])); 
     assertEquals(-1, StringUtils.lastIndexOfAny(null, new String[0])); 
     assertEquals(-1, StringUtils.lastIndexOfAny("", new String[0])); 
     assertEquals(-1, StringUtils.lastIndexOfAny(FOOBAR, new String[] { "llll" })); 
     assertEquals(6, StringUtils.lastIndexOfAny(FOOBAR, new String[] { "" })); 
     assertEquals(0, StringUtils.lastIndexOfAny("", new String[] { "" })); 
     assertEquals(-1, StringUtils.lastIndexOfAny("", new String[] { "a" })); 
     assertEquals(-1, StringUtils.lastIndexOfAny("", new String[] { null })); 
     assertEquals(-1, StringUtils.lastIndexOfAny(FOOBAR, new String[] { null })); 
     assertEquals(-1, StringUtils.lastIndexOfAny(null, new String[] { null })); 
 }
@Test
public void testContainsWhitespace9279() { 
     assertFalse(StringUtils.containsWhitespace("")); 
     assertTrue(StringUtils.containsWhitespace(" ")); 
     assertFalse(StringUtils.containsWhitespace("a")); 
     assertTrue(StringUtils.containsWhitespace("a ")); 
     assertTrue(StringUtils.containsWhitespace(" a")); 
     assertTrue(StringUtils.containsWhitespace("a\t")); 
     assertTrue(StringUtils.containsWhitespace("\n")); 
 }
@Test
public void testEqualsIgnoreCase9324() { 
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
public void testIndexOf_charInt9354() { 
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
public void testContainsOnly_String9394() { 
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
public void testContainsAny_StringCharArrayWithSupplementaryChars9453() { 
     assertTrue(StringUtils.containsAny(CharU20000 + CharU20001, CharU20000.toCharArray())); 
     assertTrue(StringUtils.containsAny("a" + CharU20000 + CharU20001, "a".toCharArray())); 
     assertTrue(StringUtils.containsAny(CharU20000 + "a" + CharU20001, "a".toCharArray())); 
     assertTrue(StringUtils.containsAny(CharU20000 + CharU20001 + "a", "a".toCharArray())); 
     assertTrue(StringUtils.containsAny(CharU20000 + CharU20001, CharU20001.toCharArray())); 
     assertTrue(StringUtils.containsAny(CharU20000, CharU20000.toCharArray())); 
     assertEquals(-1, CharU20000.indexOf(CharU20001)); 
     assertEquals(0, CharU20000.indexOf(CharU20001.charAt(0))); 
     assertEquals(-1, CharU20000.indexOf(CharU20001.charAt(1))); 
     assertFalse(StringUtils.containsAny(CharU20000, CharU20001.toCharArray())); 
     assertFalse(StringUtils.containsAny(CharU20001, CharU20000.toCharArray())); 
 }
@Test
public void testIndexOfAnyBut_StringCharArray9462() { 
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
public void testLastIndexOfIgnoreCase_StringInt9472() { 
     assertEquals(-1, StringUtils.lastIndexOfIgnoreCase(null, null, 0)); 
     assertEquals(-1, StringUtils.lastIndexOfIgnoreCase(null, null, -1)); 
     assertEquals(-1, StringUtils.lastIndexOfIgnoreCase(null, "", 0)); 
     assertEquals(-1, StringUtils.lastIndexOfIgnoreCase(null, "", -1)); 
     assertEquals(-1, StringUtils.lastIndexOfIgnoreCase("", null, 0)); 
     assertEquals(-1, StringUtils.lastIndexOfIgnoreCase("", null, -1)); 
     assertEquals(0, StringUtils.lastIndexOfIgnoreCase("", "", 0)); 
     assertEquals(-1, StringUtils.lastIndexOfIgnoreCase("", "", -1)); 
     assertEquals(0, StringUtils.lastIndexOfIgnoreCase("", "", 9)); 
     assertEquals(0, StringUtils.lastIndexOfIgnoreCase("abc", "", 0)); 
     assertEquals(-1, StringUtils.lastIndexOfIgnoreCase("abc", "", -1)); 
     assertEquals(3, StringUtils.lastIndexOfIgnoreCase("abc", "", 9)); 
     assertEquals(7, StringUtils.lastIndexOfIgnoreCase("aabaabaa", "A", 8)); 
     assertEquals(5, StringUtils.lastIndexOfIgnoreCase("aabaabaa", "B", 8)); 
     assertEquals(4, StringUtils.lastIndexOfIgnoreCase("aabaabaa", "AB", 8)); 
     assertEquals(2, StringUtils.lastIndexOfIgnoreCase("aabaabaa", "B", 3)); 
     assertEquals(5, StringUtils.lastIndexOfIgnoreCase("aabaabaa", "B", 9)); 
     assertEquals(-1, StringUtils.lastIndexOfIgnoreCase("aabaabaa", "B", -1)); 
     assertEquals(-1, StringUtils.lastIndexOfIgnoreCase("aabaabaa", "B", 0)); 
     assertEquals(0, StringUtils.lastIndexOfIgnoreCase("aabaabaa", "A", 0)); 
     assertEquals(1, StringUtils.lastIndexOfIgnoreCase("aab", "AB", 1)); 
 }
@Test
public void testLastIndexOfIgnoreCase_String9550() { 
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
public void testContainsNone_StringWithSupplementaryChars9565() { 
     assertFalse(StringUtils.containsNone(CharU20000 + CharU20001, CharU20000)); 
     assertFalse(StringUtils.containsNone(CharU20000 + CharU20001, CharU20001)); 
     assertFalse(StringUtils.containsNone(CharU20000, CharU20000)); 
     assertEquals(-1, CharU20000.indexOf(CharU20001)); 
     assertEquals(0, CharU20000.indexOf(CharU20001.charAt(0))); 
     assertEquals(-1, CharU20000.indexOf(CharU20001.charAt(1))); 
     assertTrue(StringUtils.containsNone(CharU20000, CharU20001)); 
     assertTrue(StringUtils.containsNone(CharU20001, CharU20000)); 
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
