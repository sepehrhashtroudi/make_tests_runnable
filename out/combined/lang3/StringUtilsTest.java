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

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.nio.CharBuffer;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.Locale;

import org.apache.commons.lang3.text.WordUtils;
import org.junit.Test;

/**
 * Unit tests {@link org.apache.commons.lang3.StringUtils}.
 *
 * @version $Id$
 */
public class StringUtilsTest {
    
    static final String WHITESPACE;
    static final String NON_WHITESPACE;
    static final String TRIMMABLE;
    static final String NON_TRIMMABLE;
    static {
        String ws = "";
        String nws = "";
        String tr = "";
        String ntr = "";
        for (int i = 0; i < Character.MAX_VALUE; i++) {
            if (Character.isWhitespace((char) i)) {
                ws += String.valueOf((char) i);
                if (i > 32) {
                    ntr += String.valueOf((char) i);
                }
            } else if (i < 40) {
                nws += String.valueOf((char) i);
            }
        }
        for (int i = 0; i <= 32; i++) {
            tr += String.valueOf((char) i);
        }
        WHITESPACE = ws;
        NON_WHITESPACE = nws;
        TRIMMABLE = tr;
        NON_TRIMMABLE = ntr;
    }

    private static final String[] ARRAY_LIST = { "foo", "bar", "baz" };
    private static final String[] EMPTY_ARRAY_LIST = {};
    private static final String[] NULL_ARRAY_LIST = {null};
    private static final Object[] NULL_TO_STRING_LIST = {
        new Object(){
            @Override
            public String toString() {
                return null;
            }
        }
    };
    private static final String[] MIXED_ARRAY_LIST = {null, "", "foo"};
    private static final Object[] MIXED_TYPE_LIST = {"foo", Long.valueOf(2L)};
    private static final long[] LONG_PRIM_LIST = {1, 2};
    private static final int[] INT_PRIM_LIST = {1, 2};
    private static final byte[] BYTE_PRIM_LIST = {1, 2};
    private static final short[] SHORT_PRIM_LIST = {1, 2};
    private static final char[] CHAR_PRIM_LIST = {'1', '2'};
    private static final float[] FLOAT_PRIM_LIST = {1, 2};
    private static final double[] DOUBLE_PRIM_LIST = {1, 2};

    private static final String SEPARATOR = ",";
    private static final char   SEPARATOR_CHAR = ';';

    private static final String TEXT_LIST = "foo,bar,baz";
    private static final String TEXT_LIST_CHAR = "foo;bar;baz";
    private static final String TEXT_LIST_NOSEP = "foobarbaz";

    private static final String FOO_UNCAP = "foo";
    private static final String FOO_CAP = "Foo";

    private static final String SENTENCE_UNCAP = "foo bar baz";
    private static final String SENTENCE_CAP = "Foo Bar Baz";

    //-----------------------------------------------------------------------
@Test
public void testAbbreviateMiddle11() { 
     assertNull(StringUtils.abbreviateMiddle(null, null, 0)); 
     assertEquals("abc", StringUtils.abbreviateMiddle("abc", null, 0)); 
     assertEquals("abc", StringUtils.abbreviateMiddle("abc", ".", 0)); 
     assertEquals("abc", StringUtils.abbreviateMiddle("abc", ".", 3)); 
     assertEquals("ab.f", StringUtils.abbreviateMiddle("abcdef", ".", 4)); 
     assertEquals("A very long text with un...f the text is complete.", StringUtils.abbreviateMiddle("A very long text with unimportant stuff in the middle but interesting start and " + "end to see if the text is complete.", "...", 50)); 
     final String longText = "Start text" + StringUtils.repeat("x", 10000) + "Close text"; 
     assertEquals("Start text->Close text", StringUtils.abbreviateMiddle(longText, "->", 22)); 
     assertEquals("abc", StringUtils.abbreviateMiddle("abc", ".", -1)); 
     assertEquals("abc", StringUtils.abbreviateMiddle("abc", ".", 1)); 
     assertEquals("abc", StringUtils.abbreviateMiddle("abc", ".", 2)); 
     assertEquals("a", StringUtils.abbreviateMiddle("a", ".", 1)); 
     assertEquals("a.d", StringUtils.abbreviateMiddle("abcd", ".", 3)); 
     assertEquals("a..f", StringUtils.abbreviateMiddle("abcdef", "..", 4)); 
     assertEquals("ab.ef", StringUtils.abbreviateMiddle("abcdef", ".", 5)); 
 }
@Test
public void testChop32() { 
     final String[][] chopCases = { { FOO_UNCAP + "\r\n", FOO_UNCAP }, { FOO_UNCAP + "\n", FOO_UNCAP }, { FOO_UNCAP + "\r", FOO_UNCAP }, { FOO_UNCAP + " \r", FOO_UNCAP + " " }, { "foo", "fo" }, { "foo\nfoo", "foo\nfo" }, { "\n", "" }, { "\r", "" }, { "\r\n", "" }, { null, null }, { "", "" }, { "a", "" } }; 
     for (final String[] chopCase : chopCases) { 
         final String original = chopCase[0]; 
         final String expectedResult = chopCase[1]; 
         assertEquals("chop(String) failed", expectedResult, StringUtils.chop(original)); 
     } 
 }
@Test
public void testRepeat_StringInt48() { 
     assertEquals(null, StringUtils.repeat(null, 2)); 
     assertEquals("", StringUtils.repeat("ab", 0)); 
     assertEquals("", StringUtils.repeat("", 3)); 
     assertEquals("aaa", StringUtils.repeat("a", 3)); 
     assertEquals("ababab", StringUtils.repeat("ab", 3)); 
     assertEquals("abcabcabc", StringUtils.repeat("abc", 3)); 
     final String str = StringUtils.repeat("a", 10000); 
     assertEquals(10000, str.length()); 
     assertTrue(StringUtils.containsOnly(str, new char[] { 'a' })); 
 }
@Test
public void testSplit_StringString_StringStringInt50() { 
     assertArrayEquals(null, StringUtils.split(null, ".")); 
     assertArrayEquals(null, StringUtils.split(null, ".", 3)); 
     assertEquals(0, StringUtils.split("", ".").length); 
     assertEquals(0, StringUtils.split("", ".", 3).length); 
     innerTestSplit('.', ".", ' '); 
     innerTestSplit('.', ".", ','); 
     innerTestSplit('.', ".,", 'x'); 
     for (int i = 0; i < WHITESPACE.length(); i++) { 
         for (int j = 0; j < NON_WHITESPACE.length(); j++) { 
             innerTestSplit(WHITESPACE.charAt(i), null, NON_WHITESPACE.charAt(j)); 
             innerTestSplit(WHITESPACE.charAt(i), String.valueOf(WHITESPACE.charAt(i)), NON_WHITESPACE.charAt(j)); 
         } 
     } 
     String[] results; 
     final String[] expectedResults = { "ab", "de fg" }; 
     results = StringUtils.split("ab   de fg", null, 2); 
     assertEquals(expectedResults.length, results.length); 
     for (int i = 0; i < expectedResults.length; i++) { 
         assertEquals(expectedResults[i], results[i]); 
     } 
     final String[] expectedResults2 = { "ab", "cd:ef" }; 
     results = StringUtils.split("ab:cd:ef", ":", 2); 
     assertEquals(expectedResults2.length, results.length); 
     for (int i = 0; i < expectedResults2.length; i++) { 
         assertEquals(expectedResults2[i], results[i]); 
     } 
 }
@Test
public void testGetLevenshteinDistance_StringStringInt65() { 
     assertEquals(0, StringUtils.getLevenshteinDistance("", "", 0)); 
     assertEquals(7, StringUtils.getLevenshteinDistance("aaapppp", "", 8)); 
     assertEquals(7, StringUtils.getLevenshteinDistance("aaapppp", "", 7)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("aaapppp", "", 6)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("b", "a", 0)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("a", "b", 0)); 
     assertEquals(0, StringUtils.getLevenshteinDistance("aa", "aa", 0)); 
     assertEquals(0, StringUtils.getLevenshteinDistance("aa", "aa", 2)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("aaa", "bbb", 2)); 
     assertEquals(3, StringUtils.getLevenshteinDistance("aaa", "bbb", 3)); 
     assertEquals(6, StringUtils.getLevenshteinDistance("aaaaaa", "b", 10)); 
     assertEquals(7, StringUtils.getLevenshteinDistance("aaapppp", "b", 8)); 
     assertEquals(3, StringUtils.getLevenshteinDistance("a", "bbb", 4)); 
     assertEquals(7, StringUtils.getLevenshteinDistance("aaapppp", "b", 7)); 
     assertEquals(3, StringUtils.getLevenshteinDistance("a", "bbb", 3)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("a", "bbb", 2)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("bbb", "a", 2)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("aaapppp", "b", 6)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("a", "bbb", 1)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("bbb", "a", 1)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("12345", "1234567", 1)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("1234567", "12345", 1)); 
     assertEquals(1, StringUtils.getLevenshteinDistance("frog", "fog", 1)); 
     assertEquals(3, StringUtils.getLevenshteinDistance("fly", "ant", 3)); 
     assertEquals(7, StringUtils.getLevenshteinDistance("elephant", "hippo", 7)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("elephant", "hippo", 6)); 
     assertEquals(7, StringUtils.getLevenshteinDistance("hippo", "elephant", 7)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("hippo", "elephant", 6)); 
     assertEquals(8, StringUtils.getLevenshteinDistance("hippo", "zzzzzzzz", 8)); 
     assertEquals(8, StringUtils.getLevenshteinDistance("zzzzzzzz", "hippo", 8)); 
     assertEquals(1, StringUtils.getLevenshteinDistance("hello", "hallo", 1)); 
     try { 
         @SuppressWarnings("unused") 
         final int d = StringUtils.getLevenshteinDistance("a", null, 0); 
         fail("expecting IllegalArgumentException"); 
     } catch (final IllegalArgumentException ex) { 
     } 
     try { 
         @SuppressWarnings("unused") 
         final int d = StringUtils.getLevenshteinDistance(null, "a", 0); 
         fail("expecting IllegalArgumentException"); 
     } catch (final IllegalArgumentException ex) { 
     } 
     try { 
         @SuppressWarnings("unused") 
         final int d = StringUtils.getLevenshteinDistance("a", "a", -1); 
         fail("expecting IllegalArgumentException"); 
     } catch (final IllegalArgumentException ex) { 
     } 
 }
@Test
public void testRepeat_StringInt66() { 
     assertEquals(null, StringUtils.repeat(null, 2)); 
     assertEquals("", StringUtils.repeat("ab", 0)); 
     assertEquals("", StringUtils.repeat("", 3)); 
     assertEquals("aaa", StringUtils.repeat("a", 3)); 
     assertEquals("ababab", StringUtils.repeat("ab", 3)); 
     assertEquals("abcabcabc", StringUtils.repeat("abc", 3)); 
     final String str = StringUtils.repeat("a", 10000); 
     assertEquals(10000, str.length()); 
     assertTrue(StringUtils.containsOnly(str, new char[] { 'a' })); 
 }
@Test
public void testRepeat_StringInt71() { 
     assertEquals(null, StringUtils.repeat(null, 2)); 
     assertEquals("", StringUtils.repeat("ab", 0)); 
     assertEquals("", StringUtils.repeat("", 3)); 
     assertEquals("aaa", StringUtils.repeat("a", 3)); 
     assertEquals("ababab", StringUtils.repeat("ab", 3)); 
     assertEquals("abcabcabc", StringUtils.repeat("abc", 3)); 
     final String str = StringUtils.repeat("a", 10000); 
     assertEquals(10000, str.length()); 
     assertTrue(StringUtils.containsOnly(str, new char[] { 'a' })); 
 }
@Test
public void testJoin_IteratorChar82() { 
     assertEquals(null, StringUtils.join((Iterator<?>) null, ',')); 
     assertEquals(TEXT_LIST_CHAR, StringUtils.join(Arrays.asList(ARRAY_LIST).iterator(), SEPARATOR_CHAR)); 
     assertEquals("", StringUtils.join(Arrays.asList(NULL_ARRAY_LIST).iterator(), SEPARATOR_CHAR)); 
     assertEquals("", StringUtils.join(Arrays.asList(EMPTY_ARRAY_LIST).iterator(), SEPARATOR_CHAR)); 
     assertEquals("foo", StringUtils.join(Collections.singleton("foo").iterator(), 'x')); 
 }
@Test
public void testSplitByWholeSeparatorPreserveAllTokens_StringStringInt89() { 
     assertArrayEquals(null, StringUtils.splitByWholeSeparatorPreserveAllTokens(null, ".", -1)); 
     assertEquals(0, StringUtils.splitByWholeSeparatorPreserveAllTokens("", ".", -1).length); 
     String input = "ab   de fg"; 
     String[] expected = new String[] { "ab", "", "", "de", "fg" }; 
     String[] actual = StringUtils.splitByWholeSeparatorPreserveAllTokens(input, null, -1); 
     assertEquals(expected.length, actual.length); 
     for (int i = 0; i < actual.length; i += 1) { 
         assertEquals(expected[i], actual[i]); 
     } 
     input = "1::2:::3::::4"; 
     expected = new String[] { "1", "", "2", "", "", "3", "", "", "", "4" }; 
     actual = StringUtils.splitByWholeSeparatorPreserveAllTokens(input, ":", -1); 
     assertEquals(expected.length, actual.length); 
     for (int i = 0; i < actual.length; i += 1) { 
         assertEquals(expected[i], actual[i]); 
     } 
     input = "1::2:::3::::4"; 
     expected = new String[] { "1", "2", ":3", "", "4" }; 
     actual = StringUtils.splitByWholeSeparatorPreserveAllTokens(input, "::", -1); 
     assertEquals(expected.length, actual.length); 
     for (int i = 0; i < actual.length; i += 1) { 
         assertEquals(expected[i], actual[i]); 
     } 
     input = "1::2::3:4"; 
     expected = new String[] { "1", "", "2", ":3:4" }; 
     actual = StringUtils.splitByWholeSeparatorPreserveAllTokens(input, ":", 4); 
     assertEquals(expected.length, actual.length); 
     for (int i = 0; i < actual.length; i += 1) { 
         assertEquals(expected[i], actual[i]); 
     } 
 }
@Test
public void testEscapeSurrogatePairsLang85894() throws Exception { 
     assertEquals("\\uDBFF\\uDFFD", StringEscapeUtils.escapeJava("\uDBFF\uDFFD")); 
     assertEquals("\\uDBFF\\uDFFD", StringEscapeUtils.escapeEcmaScript("\uDBFF\uDFFD")); 
 }
@Test
public void testRepeat_StringInt104() { 
     assertEquals(null, StringUtils.repeat(null, 2)); 
     assertEquals("", StringUtils.repeat("ab", 0)); 
     assertEquals("", StringUtils.repeat("", 3)); 
     assertEquals("aaa", StringUtils.repeat("a", 3)); 
     assertEquals("ababab", StringUtils.repeat("ab", 3)); 
     assertEquals("abcabcabc", StringUtils.repeat("abc", 3)); 
     final String str = StringUtils.repeat("a", 10000); 
     assertEquals(10000, str.length()); 
     assertTrue(StringUtils.containsOnly(str, new char[] { 'a' })); 
 }
@Test
public void testSplit_StringChar127() { 
     assertArrayEquals(null, StringUtils.split(null, '.')); 
     assertEquals(0, StringUtils.split("", '.').length); 
     String str = "a.b.. c"; 
     String[] res = StringUtils.split(str, '.'); 
     assertEquals(3, res.length); 
     assertEquals("a", res[0]); 
     assertEquals("b", res[1]); 
     assertEquals(" c", res[2]); 
     str = ".a."; 
     res = StringUtils.split(str, '.'); 
     assertEquals(1, res.length); 
     assertEquals("a", res[0]); 
     str = "a b c"; 
     res = StringUtils.split(str, ' '); 
     assertEquals(3, res.length); 
     assertEquals("a", res[0]); 
     assertEquals("b", res[1]); 
     assertEquals("c", res[2]); 
 }
@Test
public void testReplace_StringStringStringInt140() { 
     assertEquals(null, StringUtils.replace(null, null, null, 2)); 
     assertEquals(null, StringUtils.replace(null, null, "any", 2)); 
     assertEquals(null, StringUtils.replace(null, "any", null, 2)); 
     assertEquals(null, StringUtils.replace(null, "any", "any", 2)); 
     assertEquals("", StringUtils.replace("", null, null, 2)); 
     assertEquals("", StringUtils.replace("", null, "any", 2)); 
     assertEquals("", StringUtils.replace("", "any", null, 2)); 
     assertEquals("", StringUtils.replace("", "any", "any", 2)); 
     final String str = new String(new char[] { 'o', 'o', 'f', 'o', 'o' }); 
     assertSame(str, StringUtils.replace(str, "x", "", -1)); 
     assertEquals("f", StringUtils.replace("oofoo", "o", "", -1)); 
     assertEquals("oofoo", StringUtils.replace("oofoo", "o", "", 0)); 
     assertEquals("ofoo", StringUtils.replace("oofoo", "o", "", 1)); 
     assertEquals("foo", StringUtils.replace("oofoo", "o", "", 2)); 
     assertEquals("fo", StringUtils.replace("oofoo", "o", "", 3)); 
     assertEquals("f", StringUtils.replace("oofoo", "o", "", 4)); 
     assertEquals("f", StringUtils.replace("oofoo", "o", "", -5)); 
     assertEquals("f", StringUtils.replace("oofoo", "o", "", 1000)); 
 }
@Test
public void testRepeat_StringInt142() { 
     assertEquals(null, StringUtils.repeat(null, 2)); 
     assertEquals("", StringUtils.repeat("ab", 0)); 
     assertEquals("", StringUtils.repeat("", 3)); 
     assertEquals("aaa", StringUtils.repeat("a", 3)); 
     assertEquals("ababab", StringUtils.repeat("ab", 3)); 
     assertEquals("abcabcabc", StringUtils.repeat("abc", 3)); 
     final String str = StringUtils.repeat("a", 10000); 
     assertEquals(10000, str.length()); 
     assertTrue(StringUtils.containsOnly(str, new char[] { 'a' })); 
 }
@Test
public void testCenter_StringIntChar153() { 
     assertEquals(null, StringUtils.center(null, -1, ' ')); 
     assertEquals(null, StringUtils.center(null, 4, ' ')); 
     assertEquals("    ", StringUtils.center("", 4, ' ')); 
     assertEquals("ab", StringUtils.center("ab", 0, ' ')); 
     assertEquals("ab", StringUtils.center("ab", -1, ' ')); 
     assertEquals("ab", StringUtils.center("ab", 1, ' ')); 
     assertEquals("    ", StringUtils.center("", 4, ' ')); 
     assertEquals(" ab ", StringUtils.center("ab", 4, ' ')); 
     assertEquals("abcd", StringUtils.center("abcd", 2, ' ')); 
     assertEquals(" a  ", StringUtils.center("a", 4, ' ')); 
     assertEquals("  a  ", StringUtils.center("a", 5, ' ')); 
     assertEquals("xxaxx", StringUtils.center("a", 5, 'x')); 
 }
@Test
public void testChop177() { 
     final String[][] chopCases = { { FOO_UNCAP + "\r\n", FOO_UNCAP }, { FOO_UNCAP + "\n", FOO_UNCAP }, { FOO_UNCAP + "\r", FOO_UNCAP }, { FOO_UNCAP + " \r", FOO_UNCAP + " " }, { "foo", "fo" }, { "foo\nfoo", "foo\nfo" }, { "\n", "" }, { "\r", "" }, { "\r\n", "" }, { null, null }, { "", "" }, { "a", "" } }; 
     for (final String[] chopCase : chopCases) { 
         final String original = chopCase[0]; 
         final String expectedResult = chopCase[1]; 
         assertEquals("chop(String) failed", expectedResult, StringUtils.chop(original)); 
     } 
 }
@Test
public void testJoin_ArrayOfLongs179() { 
     assertEquals(null, StringUtils.join((long[]) null, ',')); 
     assertEquals("1;2", StringUtils.join(LONG_PRIM_LIST, SEPARATOR_CHAR)); 
     assertEquals("2", StringUtils.join(LONG_PRIM_LIST, SEPARATOR_CHAR, 1, 2)); 
 }
@Test
public void testEscapeSurrogatePairsLang858184() throws Exception { 
     assertEquals("\\uDBFF\\uDFFD", StringEscapeUtils.escapeJava("\uDBFF\uDFFD")); 
     assertEquals("\\uDBFF\\uDFFD", StringEscapeUtils.escapeEcmaScript("\uDBFF\uDFFD")); 
 }
@Test
public void testJoin_ArrayCharSeparator200() { 
     assertEquals(null, StringUtils.join((Object[]) null, ',')); 
     assertEquals(TEXT_LIST_CHAR, StringUtils.join(ARRAY_LIST, SEPARATOR_CHAR)); 
     assertEquals("", StringUtils.join(EMPTY_ARRAY_LIST, SEPARATOR_CHAR)); 
     assertEquals(";;foo", StringUtils.join(MIXED_ARRAY_LIST, SEPARATOR_CHAR)); 
     assertEquals("foo;2", StringUtils.join(MIXED_TYPE_LIST, SEPARATOR_CHAR)); 
     assertEquals("/", StringUtils.join(MIXED_ARRAY_LIST, '/', 0, MIXED_ARRAY_LIST.length - 1)); 
     assertEquals("foo", StringUtils.join(MIXED_TYPE_LIST, '/', 0, 1)); 
     assertEquals("null", StringUtils.join(NULL_TO_STRING_LIST, '/', 0, 1)); 
     assertEquals("foo/2", StringUtils.join(MIXED_TYPE_LIST, '/', 0, 2)); 
     assertEquals("2", StringUtils.join(MIXED_TYPE_LIST, '/', 1, 2)); 
     assertEquals("", StringUtils.join(MIXED_TYPE_LIST, '/', 2, 1)); 
 }
@Test
public void testReplace_StringStringStringInt208() { 
     assertEquals(null, StringUtils.replace(null, null, null, 2)); 
     assertEquals(null, StringUtils.replace(null, null, "any", 2)); 
     assertEquals(null, StringUtils.replace(null, "any", null, 2)); 
     assertEquals(null, StringUtils.replace(null, "any", "any", 2)); 
     assertEquals("", StringUtils.replace("", null, null, 2)); 
     assertEquals("", StringUtils.replace("", null, "any", 2)); 
     assertEquals("", StringUtils.replace("", "any", null, 2)); 
     assertEquals("", StringUtils.replace("", "any", "any", 2)); 
     final String str = new String(new char[] { 'o', 'o', 'f', 'o', 'o' }); 
     assertSame(str, StringUtils.replace(str, "x", "", -1)); 
     assertEquals("f", StringUtils.replace("oofoo", "o", "", -1)); 
     assertEquals("oofoo", StringUtils.replace("oofoo", "o", "", 0)); 
     assertEquals("ofoo", StringUtils.replace("oofoo", "o", "", 1)); 
     assertEquals("foo", StringUtils.replace("oofoo", "o", "", 2)); 
     assertEquals("fo", StringUtils.replace("oofoo", "o", "", 3)); 
     assertEquals("f", StringUtils.replace("oofoo", "o", "", 4)); 
     assertEquals("f", StringUtils.replace("oofoo", "o", "", -5)); 
     assertEquals("f", StringUtils.replace("oofoo", "o", "", 1000)); 
 }
@Test
public void testRemovePattern212() { 
     assertEquals("", StringUtils.removePattern("<A>x\\ny</A>", "<A>.*</A>")); 
 }
@Test
public void testReplace_StringStringArrayStringArray244() { 
     assertNull(StringUtils.replaceEach(null, new String[] { "a" }, new String[] { "b" })); 
     assertEquals(StringUtils.replaceEach("", new String[] { "a" }, new String[] { "b" }), ""); 
     assertEquals(StringUtils.replaceEach("aba", null, null), "aba"); 
     assertEquals(StringUtils.replaceEach("aba", new String[0], null), "aba"); 
     assertEquals(StringUtils.replaceEach("aba", null, new String[0]), "aba"); 
     assertEquals(StringUtils.replaceEach("aba", new String[] { "a" }, null), "aba"); 
     assertEquals(StringUtils.replaceEach("aba", new String[] { "a" }, new String[] { "" }), "b"); 
     assertEquals(StringUtils.replaceEach("aba", new String[] { null }, new String[] { "a" }), "aba"); 
     assertEquals(StringUtils.replaceEach("abcde", new String[] { "ab", "d" }, new String[] { "w", "t" }), "wcte"); 
     assertEquals(StringUtils.replaceEach("abcde", new String[] { "ab", "d" }, new String[] { "d", "t" }), "dcte"); 
     assertEquals("bcc", StringUtils.replaceEach("abc", new String[] { "a", "b" }, new String[] { "b", "c" })); 
     assertEquals("q651.506bera", StringUtils.replaceEach("d216.102oren", new String[] { "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "1", "2", "3", "4", "5", "6", "7", "8", "9" }, new String[] { "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z", "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "5", "6", "7", "8", "9", "1", "2", "3", "4" })); 
     assertEquals(StringUtils.replaceEach("aba", new String[] { "a" }, new String[] { null }), "aba"); 
     assertEquals(StringUtils.replaceEach("aba", new String[] { "a", "b" }, new String[] { "c", null }), "cbc"); 
 }
@Test
public void testJoin_IterableString266() { 
     assertEquals(null, StringUtils.join((Iterable<?>) null, null)); 
     assertEquals(TEXT_LIST_NOSEP, StringUtils.join(Arrays.asList(ARRAY_LIST), null)); 
     assertEquals(TEXT_LIST_NOSEP, StringUtils.join(Arrays.asList(ARRAY_LIST), "")); 
     assertEquals("foo", StringUtils.join(Collections.singleton("foo"), "x")); 
     assertEquals("foo", StringUtils.join(Collections.singleton("foo"), null)); 
     assertEquals("", StringUtils.join(Arrays.asList(NULL_ARRAY_LIST), null)); 
     assertEquals("", StringUtils.join(Arrays.asList(EMPTY_ARRAY_LIST), null)); 
     assertEquals("", StringUtils.join(Arrays.asList(EMPTY_ARRAY_LIST), "")); 
     assertEquals("", StringUtils.join(Arrays.asList(EMPTY_ARRAY_LIST), SEPARATOR)); 
     assertEquals(TEXT_LIST, StringUtils.join(Arrays.asList(ARRAY_LIST), SEPARATOR)); 
 }
@Test
public void testJoin_ArrayOfShorts270() { 
     assertEquals(null, StringUtils.join((short[]) null, ',')); 
     assertEquals("1;2", StringUtils.join(SHORT_PRIM_LIST, SEPARATOR_CHAR)); 
     assertEquals("2", StringUtils.join(SHORT_PRIM_LIST, SEPARATOR_CHAR, 1, 2)); 
 }
@Test
public void testSplitByCharacterType278() { 
     assertNull(StringUtils.splitByCharacterType(null)); 
     assertEquals(0, StringUtils.splitByCharacterType("").length); 
     assertTrue(ArrayUtils.isEquals(new String[] { "ab", " ", "de", " ", "fg" }, StringUtils.splitByCharacterType("ab de fg"))); 
     assertTrue(ArrayUtils.isEquals(new String[] { "ab", "   ", "de", " ", "fg" }, StringUtils.splitByCharacterType("ab   de fg"))); 
     assertTrue(ArrayUtils.isEquals(new String[] { "ab", ":", "cd", ":", "ef" }, StringUtils.splitByCharacterType("ab:cd:ef"))); 
     assertTrue(ArrayUtils.isEquals(new String[] { "number", "5" }, StringUtils.splitByCharacterType("number5"))); 
     assertTrue(ArrayUtils.isEquals(new String[] { "foo", "B", "ar" }, StringUtils.splitByCharacterType("fooBar"))); 
     assertTrue(ArrayUtils.isEquals(new String[] { "foo", "200", "B", "ar" }, StringUtils.splitByCharacterType("foo200Bar"))); 
     assertTrue(ArrayUtils.isEquals(new String[] { "ASFR", "ules" }, StringUtils.splitByCharacterType("ASFRules"))); 
 }
@Test
public void testSplitByCharacterTypeCamelCase287() { 
     assertNull(StringUtils.splitByCharacterTypeCamelCase(null)); 
     assertEquals(0, StringUtils.splitByCharacterTypeCamelCase("").length); 
     assertTrue(ArrayUtils.isEquals(new String[] { "ab", " ", "de", " ", "fg" }, StringUtils.splitByCharacterTypeCamelCase("ab de fg"))); 
     assertTrue(ArrayUtils.isEquals(new String[] { "ab", "   ", "de", " ", "fg" }, StringUtils.splitByCharacterTypeCamelCase("ab   de fg"))); 
     assertTrue(ArrayUtils.isEquals(new String[] { "ab", ":", "cd", ":", "ef" }, StringUtils.splitByCharacterTypeCamelCase("ab:cd:ef"))); 
     assertTrue(ArrayUtils.isEquals(new String[] { "number", "5" }, StringUtils.splitByCharacterTypeCamelCase("number5"))); 
     assertTrue(ArrayUtils.isEquals(new String[] { "foo", "Bar" }, StringUtils.splitByCharacterTypeCamelCase("fooBar"))); 
     assertTrue(ArrayUtils.isEquals(new String[] { "foo", "200", "Bar" }, StringUtils.splitByCharacterTypeCamelCase("foo200Bar"))); 
     assertTrue(ArrayUtils.isEquals(new String[] { "ASF", "Rules" }, StringUtils.splitByCharacterTypeCamelCase("ASFRules"))); 
 }
@Test
public void testJoin_ArrayOfShorts292() { 
     assertEquals(null, StringUtils.join((short[]) null, ',')); 
     assertEquals("1;2", StringUtils.join(SHORT_PRIM_LIST, SEPARATOR_CHAR)); 
     assertEquals("2", StringUtils.join(SHORT_PRIM_LIST, SEPARATOR_CHAR, 1, 2)); 
 }
@Test
public void testJoin_ArrayOfShorts317() { 
     assertEquals(null, StringUtils.join((short[]) null, ',')); 
     assertEquals("1;2", StringUtils.join(SHORT_PRIM_LIST, SEPARATOR_CHAR)); 
     assertEquals("2", StringUtils.join(SHORT_PRIM_LIST, SEPARATOR_CHAR, 1, 2)); 
 }
@Test
public void testReplaceChars_StringStringString325() { 
     assertEquals(null, StringUtils.replaceChars(null, null, null)); 
     assertEquals(null, StringUtils.replaceChars(null, "", null)); 
     assertEquals(null, StringUtils.replaceChars(null, "a", null)); 
     assertEquals(null, StringUtils.replaceChars(null, null, "")); 
     assertEquals(null, StringUtils.replaceChars(null, null, "x")); 
     assertEquals("", StringUtils.replaceChars("", null, null)); 
     assertEquals("", StringUtils.replaceChars("", "", null)); 
     assertEquals("", StringUtils.replaceChars("", "a", null)); 
     assertEquals("", StringUtils.replaceChars("", null, "")); 
     assertEquals("", StringUtils.replaceChars("", null, "x")); 
     assertEquals("abc", StringUtils.replaceChars("abc", null, null)); 
     assertEquals("abc", StringUtils.replaceChars("abc", null, "")); 
     assertEquals("abc", StringUtils.replaceChars("abc", null, "x")); 
     assertEquals("abc", StringUtils.replaceChars("abc", "", null)); 
     assertEquals("abc", StringUtils.replaceChars("abc", "", "")); 
     assertEquals("abc", StringUtils.replaceChars("abc", "", "x")); 
     assertEquals("ac", StringUtils.replaceChars("abc", "b", null)); 
     assertEquals("ac", StringUtils.replaceChars("abc", "b", "")); 
     assertEquals("axc", StringUtils.replaceChars("abc", "b", "x")); 
     assertEquals("ayzya", StringUtils.replaceChars("abcba", "bc", "yz")); 
     assertEquals("ayya", StringUtils.replaceChars("abcba", "bc", "y")); 
     assertEquals("ayzya", StringUtils.replaceChars("abcba", "bc", "yzx")); 
     assertEquals("abcba", StringUtils.replaceChars("abcba", "z", "w")); 
     assertSame("abcba", StringUtils.replaceChars("abcba", "z", "w")); 
     assertEquals("jelly", StringUtils.replaceChars("hello", "ho", "jy")); 
     assertEquals("ayzya", StringUtils.replaceChars("abcba", "bc", "yz")); 
     assertEquals("ayya", StringUtils.replaceChars("abcba", "bc", "y")); 
     assertEquals("ayzya", StringUtils.replaceChars("abcba", "bc", "yzx")); 
     assertEquals("bcc", StringUtils.replaceChars("abc", "ab", "bc")); 
     assertEquals("q651.506bera", StringUtils.replaceChars("d216.102oren", "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ123456789", "nopqrstuvwxyzabcdefghijklmNOPQRSTUVWXYZABCDEFGHIJKLM567891234")); 
 }
@Test
public void testReplace_StringStringArrayStringArray342() { 
     assertNull(StringUtils.replaceEach(null, new String[] { "a" }, new String[] { "b" })); 
     assertEquals(StringUtils.replaceEach("", new String[] { "a" }, new String[] { "b" }), ""); 
     assertEquals(StringUtils.replaceEach("aba", null, null), "aba"); 
     assertEquals(StringUtils.replaceEach("aba", new String[0], null), "aba"); 
     assertEquals(StringUtils.replaceEach("aba", null, new String[0]), "aba"); 
     assertEquals(StringUtils.replaceEach("aba", new String[] { "a" }, null), "aba"); 
     assertEquals(StringUtils.replaceEach("aba", new String[] { "a" }, new String[] { "" }), "b"); 
     assertEquals(StringUtils.replaceEach("aba", new String[] { null }, new String[] { "a" }), "aba"); 
     assertEquals(StringUtils.replaceEach("abcde", new String[] { "ab", "d" }, new String[] { "w", "t" }), "wcte"); 
     assertEquals(StringUtils.replaceEach("abcde", new String[] { "ab", "d" }, new String[] { "d", "t" }), "dcte"); 
     assertEquals("bcc", StringUtils.replaceEach("abc", new String[] { "a", "b" }, new String[] { "b", "c" })); 
     assertEquals("q651.506bera", StringUtils.replaceEach("d216.102oren", new String[] { "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "1", "2", "3", "4", "5", "6", "7", "8", "9" }, new String[] { "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z", "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "5", "6", "7", "8", "9", "1", "2", "3", "4" })); 
     assertEquals(StringUtils.replaceEach("aba", new String[] { "a" }, new String[] { null }), "aba"); 
     assertEquals(StringUtils.replaceEach("aba", new String[] { "a", "b" }, new String[] { "c", null }), "cbc"); 
 }
@Test
public void testJoin_IterableString347() { 
     assertEquals(null, StringUtils.join((Iterable<?>) null, null)); 
     assertEquals(TEXT_LIST_NOSEP, StringUtils.join(Arrays.asList(ARRAY_LIST), null)); 
     assertEquals(TEXT_LIST_NOSEP, StringUtils.join(Arrays.asList(ARRAY_LIST), "")); 
     assertEquals("foo", StringUtils.join(Collections.singleton("foo"), "x")); 
     assertEquals("foo", StringUtils.join(Collections.singleton("foo"), null)); 
     assertEquals("", StringUtils.join(Arrays.asList(NULL_ARRAY_LIST), null)); 
     assertEquals("", StringUtils.join(Arrays.asList(EMPTY_ARRAY_LIST), null)); 
     assertEquals("", StringUtils.join(Arrays.asList(EMPTY_ARRAY_LIST), "")); 
     assertEquals("", StringUtils.join(Arrays.asList(EMPTY_ARRAY_LIST), SEPARATOR)); 
     assertEquals(TEXT_LIST, StringUtils.join(Arrays.asList(ARRAY_LIST), SEPARATOR)); 
 }
@Test
public void testSwapCase_String394() { 
     assertEquals(null, StringUtils.swapCase(null)); 
     assertEquals("", StringUtils.swapCase("")); 
     assertEquals("  ", StringUtils.swapCase("  ")); 
     assertEquals("i", WordUtils.swapCase("I")); 
     assertEquals("I", WordUtils.swapCase("i")); 
     assertEquals("I AM HERE 123", StringUtils.swapCase("i am here 123")); 
     assertEquals("i aM hERE 123", StringUtils.swapCase("I Am Here 123")); 
     assertEquals("I AM here 123", StringUtils.swapCase("i am HERE 123")); 
     assertEquals("i am here 123", StringUtils.swapCase("I AM HERE 123")); 
     final String test = "This String contains a TitleCase character: \u01C8"; 
     final String expect = "tHIS sTRING CONTAINS A tITLEcASE CHARACTER: \u01C9"; 
     assertEquals(expect, WordUtils.swapCase(test)); 
 }
@Test
public void testRemove_String409() { 
     assertEquals(null, StringUtils.remove(null, null)); 
     assertEquals(null, StringUtils.remove(null, "")); 
     assertEquals(null, StringUtils.remove(null, "a")); 
     assertEquals("", StringUtils.remove("", null)); 
     assertEquals("", StringUtils.remove("", "")); 
     assertEquals("", StringUtils.remove("", "a")); 
     assertEquals(null, StringUtils.remove(null, null)); 
     assertEquals("", StringUtils.remove("", null)); 
     assertEquals("a", StringUtils.remove("a", null)); 
     assertEquals(null, StringUtils.remove(null, "")); 
     assertEquals("", StringUtils.remove("", "")); 
     assertEquals("a", StringUtils.remove("a", "")); 
     assertEquals("qd", StringUtils.remove("queued", "ue")); 
     assertEquals("queued", StringUtils.remove("queued", "zz")); 
 }
@Test
public void testJoin_ArrayOfLongs417() { 
     assertEquals(null, StringUtils.join((long[]) null, ',')); 
     assertEquals("1;2", StringUtils.join(LONG_PRIM_LIST, SEPARATOR_CHAR)); 
     assertEquals("2", StringUtils.join(LONG_PRIM_LIST, SEPARATOR_CHAR, 1, 2)); 
 }
@Test
public void testRemoveStart426() { 
     assertNull(StringUtils.removeStart(null, null)); 
     assertNull(StringUtils.removeStart(null, "")); 
     assertNull(StringUtils.removeStart(null, "a")); 
     assertEquals(StringUtils.removeStart("", null), ""); 
     assertEquals(StringUtils.removeStart("", ""), ""); 
     assertEquals(StringUtils.removeStart("", "a"), ""); 
     assertEquals(StringUtils.removeStart("www.domain.com", "www."), "domain.com"); 
     assertEquals(StringUtils.removeStart("domain.com", "www."), "domain.com"); 
     assertEquals(StringUtils.removeStart("domain.com", ""), "domain.com"); 
     assertEquals(StringUtils.removeStart("domain.com", null), "domain.com"); 
 }
@Test
public void testAbbreviate_StringIntInt427() { 
     assertEquals(null, StringUtils.abbreviate(null, 10, 12)); 
     assertEquals("", StringUtils.abbreviate("", 0, 10)); 
     assertEquals("", StringUtils.abbreviate("", 2, 10)); 
     try { 
         @SuppressWarnings("unused") 
         final String res = StringUtils.abbreviate("abcdefghij", 0, 3); 
         fail("StringUtils.abbreviate expecting IllegalArgumentException"); 
     } catch (final IllegalArgumentException ex) { 
     } 
     try { 
         @SuppressWarnings("unused") 
         final String res = StringUtils.abbreviate("abcdefghij", 5, 6); 
         fail("StringUtils.abbreviate expecting IllegalArgumentException"); 
     } catch (final IllegalArgumentException ex) { 
     } 
     final String raspberry = "raspberry peach"; 
     assertEquals("raspberry peach", StringUtils.abbreviate(raspberry, 11, 15)); 
     assertEquals(null, StringUtils.abbreviate(null, 7, 14)); 
     assertAbbreviateWithOffset("abcdefg...", -1, 10); 
     assertAbbreviateWithOffset("abcdefg...", 0, 10); 
     assertAbbreviateWithOffset("abcdefg...", 1, 10); 
     assertAbbreviateWithOffset("abcdefg...", 2, 10); 
     assertAbbreviateWithOffset("abcdefg...", 3, 10); 
     assertAbbreviateWithOffset("abcdefg...", 4, 10); 
     assertAbbreviateWithOffset("...fghi...", 5, 10); 
     assertAbbreviateWithOffset("...ghij...", 6, 10); 
     assertAbbreviateWithOffset("...hijk...", 7, 10); 
     assertAbbreviateWithOffset("...ijklmno", 8, 10); 
     assertAbbreviateWithOffset("...ijklmno", 9, 10); 
     assertAbbreviateWithOffset("...ijklmno", 10, 10); 
     assertAbbreviateWithOffset("...ijklmno", 10, 10); 
     assertAbbreviateWithOffset("...ijklmno", 11, 10); 
     assertAbbreviateWithOffset("...ijklmno", 12, 10); 
     assertAbbreviateWithOffset("...ijklmno", 13, 10); 
     assertAbbreviateWithOffset("...ijklmno", 14, 10); 
     assertAbbreviateWithOffset("...ijklmno", 15, 10); 
     assertAbbreviateWithOffset("...ijklmno", 16, 10); 
     assertAbbreviateWithOffset("...ijklmno", Integer.MAX_VALUE, 10); 
 }
@Test
public void testReplace_StringStringArrayStringArray445() { 
     assertNull(StringUtils.replaceEach(null, new String[] { "a" }, new String[] { "b" })); 
     assertEquals(StringUtils.replaceEach("", new String[] { "a" }, new String[] { "b" }), ""); 
     assertEquals(StringUtils.replaceEach("aba", null, null), "aba"); 
     assertEquals(StringUtils.replaceEach("aba", new String[0], null), "aba"); 
     assertEquals(StringUtils.replaceEach("aba", null, new String[0]), "aba"); 
     assertEquals(StringUtils.replaceEach("aba", new String[] { "a" }, null), "aba"); 
     assertEquals(StringUtils.replaceEach("aba", new String[] { "a" }, new String[] { "" }), "b"); 
     assertEquals(StringUtils.replaceEach("aba", new String[] { null }, new String[] { "a" }), "aba"); 
     assertEquals(StringUtils.replaceEach("abcde", new String[] { "ab", "d" }, new String[] { "w", "t" }), "wcte"); 
     assertEquals(StringUtils.replaceEach("abcde", new String[] { "ab", "d" }, new String[] { "d", "t" }), "dcte"); 
     assertEquals("bcc", StringUtils.replaceEach("abc", new String[] { "a", "b" }, new String[] { "b", "c" })); 
     assertEquals("q651.506bera", StringUtils.replaceEach("d216.102oren", new String[] { "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "1", "2", "3", "4", "5", "6", "7", "8", "9" }, new String[] { "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z", "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "5", "6", "7", "8", "9", "1", "2", "3", "4" })); 
     assertEquals(StringUtils.replaceEach("aba", new String[] { "a" }, new String[] { null }), "aba"); 
     assertEquals(StringUtils.replaceEach("aba", new String[] { "a", "b" }, new String[] { "c", null }), "cbc"); 
 }
@Test
public void testJoin_ArrayOfChars457() { 
     assertEquals(null, StringUtils.join((char[]) null, ',')); 
     assertEquals("1;2", StringUtils.join(CHAR_PRIM_LIST, SEPARATOR_CHAR)); 
     assertEquals("2", StringUtils.join(CHAR_PRIM_LIST, SEPARATOR_CHAR, 1, 2)); 
 }
@Test
public void testSwapCase_String463() { 
     assertEquals(null, StringUtils.swapCase(null)); 
     assertEquals("", StringUtils.swapCase("")); 
     assertEquals("  ", StringUtils.swapCase("  ")); 
     assertEquals("i", WordUtils.swapCase("I")); 
     assertEquals("I", WordUtils.swapCase("i")); 
     assertEquals("I AM HERE 123", StringUtils.swapCase("i am here 123")); 
     assertEquals("i aM hERE 123", StringUtils.swapCase("I Am Here 123")); 
     assertEquals("I AM here 123", StringUtils.swapCase("i am HERE 123")); 
     assertEquals("i am here 123", StringUtils.swapCase("I AM HERE 123")); 
     final String test = "This String contains a TitleCase character: \u01C8"; 
     final String expect = "tHIS sTRING CONTAINS A tITLEcASE CHARACTER: \u01C9"; 
     assertEquals(expect, WordUtils.swapCase(test)); 
 }
@Test
public void testRightPad_StringInt477() { 
     assertEquals(null, StringUtils.rightPad(null, 5)); 
     assertEquals("     ", StringUtils.rightPad("", 5)); 
     assertEquals("abc  ", StringUtils.rightPad("abc", 5)); 
     assertEquals("abc", StringUtils.rightPad("abc", 2)); 
     assertEquals("abc", StringUtils.rightPad("abc", -1)); 
 }
@Test
public void testSplitPreserveAllTokens_String493() { 
     assertArrayEquals(null, StringUtils.splitPreserveAllTokens(null)); 
     assertEquals(0, StringUtils.splitPreserveAllTokens("").length); 
     String str = "abc def"; 
     String[] res = StringUtils.splitPreserveAllTokens(str); 
     assertEquals(2, res.length); 
     assertEquals("abc", res[0]); 
     assertEquals("def", res[1]); 
     str = "abc  def"; 
     res = StringUtils.splitPreserveAllTokens(str); 
     assertEquals(3, res.length); 
     assertEquals("abc", res[0]); 
     assertEquals("", res[1]); 
     assertEquals("def", res[2]); 
     str = " abc "; 
     res = StringUtils.splitPreserveAllTokens(str); 
     assertEquals(3, res.length); 
     assertEquals("", res[0]); 
     assertEquals("abc", res[1]); 
     assertEquals("", res[2]); 
     str = "a b .c"; 
     res = StringUtils.splitPreserveAllTokens(str); 
     assertEquals(3, res.length); 
     assertEquals("a", res[0]); 
     assertEquals("b", res[1]); 
     assertEquals(".c", res[2]); 
     str = " a b .c"; 
     res = StringUtils.splitPreserveAllTokens(str); 
     assertEquals(4, res.length); 
     assertEquals("", res[0]); 
     assertEquals("a", res[1]); 
     assertEquals("b", res[2]); 
     assertEquals(".c", res[3]); 
     str = "a  b  .c"; 
     res = StringUtils.splitPreserveAllTokens(str); 
     assertEquals(5, res.length); 
     assertEquals("a", res[0]); 
     assertEquals("", res[1]); 
     assertEquals("b", res[2]); 
     assertEquals("", res[3]); 
     assertEquals(".c", res[4]); 
     str = " a  "; 
     res = StringUtils.splitPreserveAllTokens(str); 
     assertEquals(4, res.length); 
     assertEquals("", res[0]); 
     assertEquals("a", res[1]); 
     assertEquals("", res[2]); 
     assertEquals("", res[3]); 
     str = " a  b"; 
     res = StringUtils.splitPreserveAllTokens(str); 
     assertEquals(4, res.length); 
     assertEquals("", res[0]); 
     assertEquals("a", res[1]); 
     assertEquals("", res[2]); 
     assertEquals("b", res[3]); 
     str = "a" + WHITESPACE + "b" + NON_WHITESPACE + "c"; 
     res = StringUtils.splitPreserveAllTokens(str); 
     assertEquals(WHITESPACE.length() + 1, res.length); 
     assertEquals("a", res[0]); 
     for (int i = 1; i < WHITESPACE.length() - 1; i++) { 
         assertEquals("", res[i]); 
     } 
     assertEquals("b" + NON_WHITESPACE + "c", res[WHITESPACE.length()]); 
 }
@Test
public void testGetCommonPrefix_StringArray502() { 
     assertEquals("", StringUtils.getCommonPrefix((String[]) null)); 
     assertEquals("", StringUtils.getCommonPrefix()); 
     assertEquals("abc", StringUtils.getCommonPrefix("abc")); 
     assertEquals("", StringUtils.getCommonPrefix(null, null)); 
     assertEquals("", StringUtils.getCommonPrefix("", "")); 
     assertEquals("", StringUtils.getCommonPrefix("", null)); 
     assertEquals("", StringUtils.getCommonPrefix("abc", null, null)); 
     assertEquals("", StringUtils.getCommonPrefix(null, null, "abc")); 
     assertEquals("", StringUtils.getCommonPrefix("", "abc")); 
     assertEquals("", StringUtils.getCommonPrefix("abc", "")); 
     assertEquals("abc", StringUtils.getCommonPrefix("abc", "abc")); 
     assertEquals("a", StringUtils.getCommonPrefix("abc", "a")); 
     assertEquals("ab", StringUtils.getCommonPrefix("ab", "abxyz")); 
     assertEquals("ab", StringUtils.getCommonPrefix("abcde", "abxyz")); 
     assertEquals("", StringUtils.getCommonPrefix("abcde", "xyz")); 
     assertEquals("", StringUtils.getCommonPrefix("xyz", "abcde")); 
     assertEquals("i am a ", StringUtils.getCommonPrefix("i am a machine", "i am a robot")); 
 }
@Test
public void testRepeat_StringInt507() { 
     assertEquals(null, StringUtils.repeat(null, 2)); 
     assertEquals("", StringUtils.repeat("ab", 0)); 
     assertEquals("", StringUtils.repeat("", 3)); 
     assertEquals("aaa", StringUtils.repeat("a", 3)); 
     assertEquals("ababab", StringUtils.repeat("ab", 3)); 
     assertEquals("abcabcabc", StringUtils.repeat("abc", 3)); 
     final String str = StringUtils.repeat("a", 10000); 
     assertEquals(10000, str.length()); 
     assertTrue(StringUtils.containsOnly(str, new char[] { 'a' })); 
 }
@Test
public void testReplace_StringStringArrayStringArrayBoolean518() { 
     assertNull(StringUtils.replaceEachRepeatedly(null, new String[] { "a" }, new String[] { "b" })); 
     assertEquals(StringUtils.replaceEachRepeatedly("", new String[] { "a" }, new String[] { "b" }), ""); 
     assertEquals(StringUtils.replaceEachRepeatedly("aba", null, null), "aba"); 
     assertEquals(StringUtils.replaceEachRepeatedly("aba", new String[0], null), "aba"); 
     assertEquals(StringUtils.replaceEachRepeatedly("aba", null, new String[0]), "aba"); 
     assertEquals(StringUtils.replaceEachRepeatedly("aba", new String[0], null), "aba"); 
     assertEquals(StringUtils.replaceEachRepeatedly("aba", new String[] { "a" }, new String[] { "" }), "b"); 
     assertEquals(StringUtils.replaceEachRepeatedly("aba", new String[] { null }, new String[] { "a" }), "aba"); 
     assertEquals(StringUtils.replaceEachRepeatedly("abcde", new String[] { "ab", "d" }, new String[] { "w", "t" }), "wcte"); 
     assertEquals(StringUtils.replaceEachRepeatedly("abcde", new String[] { "ab", "d" }, new String[] { "d", "t" }), "tcte"); 
     try { 
         StringUtils.replaceEachRepeatedly("abcde", new String[] { "ab", "d" }, new String[] { "d", "ab" }); 
         fail("Should be a circular reference"); 
     } catch (final IllegalStateException e) { 
     } 
 }
@Test
public void testIsAllLowerCase537() { 
     assertFalse(StringUtils.isAllLowerCase(null)); 
     assertFalse(StringUtils.isAllLowerCase(StringUtils.EMPTY)); 
     assertTrue(StringUtils.isAllLowerCase("abc")); 
     assertFalse(StringUtils.isAllLowerCase("abc ")); 
     assertFalse(StringUtils.isAllLowerCase("abC")); 
 }
@Test
public void testJoin_ArrayOfFloats545() { 
     assertEquals(null, StringUtils.join((float[]) null, ',')); 
     assertEquals("1.0;2.0", StringUtils.join(FLOAT_PRIM_LIST, SEPARATOR_CHAR)); 
     assertEquals("2.0", StringUtils.join(FLOAT_PRIM_LIST, SEPARATOR_CHAR, 1, 2)); 
 }
@Test
public void testPrependIfMissingIgnoreCase549() { 
     assertEquals("prependIfMissingIgnoreCase(null,null)", null, StringUtils.prependIfMissingIgnoreCase(null, null)); 
     assertEquals("prependIfMissingIgnoreCase(abc,null)", "abc", StringUtils.prependIfMissingIgnoreCase("abc", null)); 
     assertEquals("prependIfMissingIgnoreCase(\"\",xyz)", "xyz", StringUtils.prependIfMissingIgnoreCase("", "xyz")); 
     assertEquals("prependIfMissingIgnoreCase(abc,xyz)", "xyzabc", StringUtils.prependIfMissingIgnoreCase("abc", "xyz")); 
     assertEquals("prependIfMissingIgnoreCase(xyzabc,xyz)", "xyzabc", StringUtils.prependIfMissingIgnoreCase("xyzabc", "xyz")); 
     assertEquals("prependIfMissingIgnoreCase(XYZabc,xyz)", "XYZabc", StringUtils.prependIfMissingIgnoreCase("XYZabc", "xyz")); 
     assertEquals("prependIfMissingIgnoreCase(null,null null)", null, StringUtils.prependIfMissingIgnoreCase(null, null, (CharSequence[]) null)); 
     assertEquals("prependIfMissingIgnoreCase(abc,null,null)", "abc", StringUtils.prependIfMissingIgnoreCase("abc", null, (CharSequence[]) null)); 
     assertEquals("prependIfMissingIgnoreCase(\"\",xyz,null)", "xyz", StringUtils.prependIfMissingIgnoreCase("", "xyz", (CharSequence[]) null)); 
     assertEquals("prependIfMissingIgnoreCase(abc,xyz,{null})", "xyzabc", StringUtils.prependIfMissingIgnoreCase("abc", "xyz", new CharSequence[] { null })); 
     assertEquals("prependIfMissingIgnoreCase(abc,xyz,\"\")", "abc", StringUtils.prependIfMissingIgnoreCase("abc", "xyz", "")); 
     assertEquals("prependIfMissingIgnoreCase(abc,xyz,mno)", "xyzabc", StringUtils.prependIfMissingIgnoreCase("abc", "xyz", "mno")); 
     assertEquals("prependIfMissingIgnoreCase(xyzabc,xyz,mno)", "xyzabc", StringUtils.prependIfMissingIgnoreCase("xyzabc", "xyz", "mno")); 
     assertEquals("prependIfMissingIgnoreCase(mnoabc,xyz,mno)", "mnoabc", StringUtils.prependIfMissingIgnoreCase("mnoabc", "xyz", "mno")); 
     assertEquals("prependIfMissingIgnoreCase(XYZabc,xyz,mno)", "XYZabc", StringUtils.prependIfMissingIgnoreCase("XYZabc", "xyz", "mno")); 
     assertEquals("prependIfMissingIgnoreCase(MNOabc,xyz,mno)", "MNOabc", StringUtils.prependIfMissingIgnoreCase("MNOabc", "xyz", "mno")); 
 }
@Test
public void testIsAllLowerCase576() { 
     assertFalse(StringUtils.isAllLowerCase(null)); 
     assertFalse(StringUtils.isAllLowerCase(StringUtils.EMPTY)); 
     assertTrue(StringUtils.isAllLowerCase("abc")); 
     assertFalse(StringUtils.isAllLowerCase("abc ")); 
     assertFalse(StringUtils.isAllLowerCase("abC")); 
 }
@Test
public void testRepeat_StringStringInt581() { 
     assertEquals(null, StringUtils.repeat(null, null, 2)); 
     assertEquals(null, StringUtils.repeat(null, "x", 2)); 
     assertEquals("", StringUtils.repeat("", null, 2)); 
     assertEquals("", StringUtils.repeat("ab", "", 0)); 
     assertEquals("", StringUtils.repeat("", "", 2)); 
     assertEquals("xx", StringUtils.repeat("", "x", 3)); 
     assertEquals("?, ?, ?", StringUtils.repeat("?", ", ", 3)); 
 }
@Test
public void testGetCommonPrefix_StringArray582() { 
     assertEquals("", StringUtils.getCommonPrefix((String[]) null)); 
     assertEquals("", StringUtils.getCommonPrefix()); 
     assertEquals("abc", StringUtils.getCommonPrefix("abc")); 
     assertEquals("", StringUtils.getCommonPrefix(null, null)); 
     assertEquals("", StringUtils.getCommonPrefix("", "")); 
     assertEquals("", StringUtils.getCommonPrefix("", null)); 
     assertEquals("", StringUtils.getCommonPrefix("abc", null, null)); 
     assertEquals("", StringUtils.getCommonPrefix(null, null, "abc")); 
     assertEquals("", StringUtils.getCommonPrefix("", "abc")); 
     assertEquals("", StringUtils.getCommonPrefix("abc", "")); 
     assertEquals("abc", StringUtils.getCommonPrefix("abc", "abc")); 
     assertEquals("a", StringUtils.getCommonPrefix("abc", "a")); 
     assertEquals("ab", StringUtils.getCommonPrefix("ab", "abxyz")); 
     assertEquals("ab", StringUtils.getCommonPrefix("abcde", "abxyz")); 
     assertEquals("", StringUtils.getCommonPrefix("abcde", "xyz")); 
     assertEquals("", StringUtils.getCommonPrefix("xyz", "abcde")); 
     assertEquals("i am a ", StringUtils.getCommonPrefix("i am a machine", "i am a robot")); 
 }
@Test
public void testSplitByWholeSeparatorPreserveAllTokens_StringStringInt589() { 
     assertArrayEquals(null, StringUtils.splitByWholeSeparatorPreserveAllTokens(null, ".", -1)); 
     assertEquals(0, StringUtils.splitByWholeSeparatorPreserveAllTokens("", ".", -1).length); 
     String input = "ab   de fg"; 
     String[] expected = new String[] { "ab", "", "", "de", "fg" }; 
     String[] actual = StringUtils.splitByWholeSeparatorPreserveAllTokens(input, null, -1); 
     assertEquals(expected.length, actual.length); 
     for (int i = 0; i < actual.length; i += 1) { 
         assertEquals(expected[i], actual[i]); 
     } 
     input = "1::2:::3::::4"; 
     expected = new String[] { "1", "", "2", "", "", "3", "", "", "", "4" }; 
     actual = StringUtils.splitByWholeSeparatorPreserveAllTokens(input, ":", -1); 
     assertEquals(expected.length, actual.length); 
     for (int i = 0; i < actual.length; i += 1) { 
         assertEquals(expected[i], actual[i]); 
     } 
     input = "1::2:::3::::4"; 
     expected = new String[] { "1", "2", ":3", "", "4" }; 
     actual = StringUtils.splitByWholeSeparatorPreserveAllTokens(input, "::", -1); 
     assertEquals(expected.length, actual.length); 
     for (int i = 0; i < actual.length; i += 1) { 
         assertEquals(expected[i], actual[i]); 
     } 
     input = "1::2::3:4"; 
     expected = new String[] { "1", "", "2", ":3:4" }; 
     actual = StringUtils.splitByWholeSeparatorPreserveAllTokens(input, ":", 4); 
     assertEquals(expected.length, actual.length); 
     for (int i = 0; i < actual.length; i += 1) { 
         assertEquals(expected[i], actual[i]); 
     } 
 }
@Test
public void testRemoveStartIgnoreCase605() { 
     assertNull("removeStartIgnoreCase(null, null)", StringUtils.removeStartIgnoreCase(null, null)); 
     assertNull("removeStartIgnoreCase(null, \"\")", StringUtils.removeStartIgnoreCase(null, "")); 
     assertNull("removeStartIgnoreCase(null, \"a\")", StringUtils.removeStartIgnoreCase(null, "a")); 
     assertEquals("removeStartIgnoreCase(\"\", null)", StringUtils.removeStartIgnoreCase("", null), ""); 
     assertEquals("removeStartIgnoreCase(\"\", \"\")", StringUtils.removeStartIgnoreCase("", ""), ""); 
     assertEquals("removeStartIgnoreCase(\"\", \"a\")", StringUtils.removeStartIgnoreCase("", "a"), ""); 
     assertEquals("removeStartIgnoreCase(\"www.domain.com\", \"www.\")", StringUtils.removeStartIgnoreCase("www.domain.com", "www."), "domain.com"); 
     assertEquals("removeStartIgnoreCase(\"domain.com\", \"www.\")", StringUtils.removeStartIgnoreCase("domain.com", "www."), "domain.com"); 
     assertEquals("removeStartIgnoreCase(\"domain.com\", \"\")", StringUtils.removeStartIgnoreCase("domain.com", ""), "domain.com"); 
     assertEquals("removeStartIgnoreCase(\"domain.com\", null)", StringUtils.removeStartIgnoreCase("domain.com", null), "domain.com"); 
     assertEquals("removeStartIgnoreCase(\"www.domain.com\", \"WWW.\")", StringUtils.removeStartIgnoreCase("www.domain.com", "WWW."), "domain.com"); 
 }
@Test
public void testRemove_char607() { 
     assertEquals(null, StringUtils.remove(null, 'a')); 
     assertEquals(null, StringUtils.remove(null, 'a')); 
     assertEquals(null, StringUtils.remove(null, 'a')); 
     assertEquals("", StringUtils.remove("", 'a')); 
     assertEquals("", StringUtils.remove("", 'a')); 
     assertEquals("", StringUtils.remove("", 'a')); 
     assertEquals("qeed", StringUtils.remove("queued", 'u')); 
     assertEquals("queued", StringUtils.remove("queued", 'z')); 
 }
@Test
public void testJoin_ArrayOfBytes618() { 
     assertEquals(null, StringUtils.join((byte[]) null, ',')); 
     assertEquals("1;2", StringUtils.join(BYTE_PRIM_LIST, SEPARATOR_CHAR)); 
     assertEquals("2", StringUtils.join(BYTE_PRIM_LIST, SEPARATOR_CHAR, 1, 2)); 
 }
@Test
public void testDefaultIfBlank_StringBuffers624() { 
     assertEquals("NULL", StringUtils.defaultIfBlank(new StringBuffer(""), new StringBuffer("NULL")).toString()); 
     assertEquals("NULL", StringUtils.defaultIfBlank(new StringBuffer(" "), new StringBuffer("NULL")).toString()); 
     assertEquals("abc", StringUtils.defaultIfBlank(new StringBuffer("abc"), new StringBuffer("NULL")).toString()); 
     assertNull(StringUtils.defaultIfBlank(new StringBuffer(""), null)); 
     final StringBuffer s = StringUtils.defaultIfBlank(new StringBuffer("abc"), new StringBuffer("NULL")); 
     assertEquals("abc", s.toString()); 
 }
@Test
public void testJoin_ArrayOfChars639() { 
     assertEquals(null, StringUtils.join((char[]) null, ',')); 
     assertEquals("1;2", StringUtils.join(CHAR_PRIM_LIST, SEPARATOR_CHAR)); 
     assertEquals("2", StringUtils.join(CHAR_PRIM_LIST, SEPARATOR_CHAR, 1, 2)); 
 }
@Test
public void testJoin_ArrayOfChars648() { 
     assertEquals(null, StringUtils.join((char[]) null, ',')); 
     assertEquals("1;2", StringUtils.join(CHAR_PRIM_LIST, SEPARATOR_CHAR)); 
     assertEquals("2", StringUtils.join(CHAR_PRIM_LIST, SEPARATOR_CHAR, 1, 2)); 
 }
@Test
public void testReverse_String655() { 
     assertEquals(null, StringUtils.reverse(null)); 
     assertEquals("", StringUtils.reverse("")); 
     assertEquals("sdrawkcab", StringUtils.reverse("backwards")); 
 }
@Test
public void testReplace_StringStringStringInt667() { 
     assertEquals(null, StringUtils.replace(null, null, null, 2)); 
     assertEquals(null, StringUtils.replace(null, null, "any", 2)); 
     assertEquals(null, StringUtils.replace(null, "any", null, 2)); 
     assertEquals(null, StringUtils.replace(null, "any", "any", 2)); 
     assertEquals("", StringUtils.replace("", null, null, 2)); 
     assertEquals("", StringUtils.replace("", null, "any", 2)); 
     assertEquals("", StringUtils.replace("", "any", null, 2)); 
     assertEquals("", StringUtils.replace("", "any", "any", 2)); 
     final String str = new String(new char[] { 'o', 'o', 'f', 'o', 'o' }); 
     assertSame(str, StringUtils.replace(str, "x", "", -1)); 
     assertEquals("f", StringUtils.replace("oofoo", "o", "", -1)); 
     assertEquals("oofoo", StringUtils.replace("oofoo", "o", "", 0)); 
     assertEquals("ofoo", StringUtils.replace("oofoo", "o", "", 1)); 
     assertEquals("foo", StringUtils.replace("oofoo", "o", "", 2)); 
     assertEquals("fo", StringUtils.replace("oofoo", "o", "", 3)); 
     assertEquals("f", StringUtils.replace("oofoo", "o", "", 4)); 
     assertEquals("f", StringUtils.replace("oofoo", "o", "", -5)); 
     assertEquals("f", StringUtils.replace("oofoo", "o", "", 1000)); 
 }
@Test
public void testEscapeSurrogatePairsLang858673() throws Exception { 
     assertEquals("\\uDBFF\\uDFFD", StringEscapeUtils.escapeJava("\uDBFF\uDFFD")); 
     assertEquals("\\uDBFF\\uDFFD", StringEscapeUtils.escapeEcmaScript("\uDBFF\uDFFD")); 
 }
@Test
public void testSwapCase_String685() { 
     assertEquals(null, StringUtils.swapCase(null)); 
     assertEquals("", StringUtils.swapCase("")); 
     assertEquals("  ", StringUtils.swapCase("  ")); 
     assertEquals("i", WordUtils.swapCase("I")); 
     assertEquals("I", WordUtils.swapCase("i")); 
     assertEquals("I AM HERE 123", StringUtils.swapCase("i am here 123")); 
     assertEquals("i aM hERE 123", StringUtils.swapCase("I Am Here 123")); 
     assertEquals("I AM here 123", StringUtils.swapCase("i am HERE 123")); 
     assertEquals("i am here 123", StringUtils.swapCase("I AM HERE 123")); 
     final String test = "This String contains a TitleCase character: \u01C8"; 
     final String expect = "tHIS sTRING CONTAINS A tITLEcASE CHARACTER: \u01C9"; 
     assertEquals(expect, WordUtils.swapCase(test)); 
 }
@Test
public void testReplace_StringStringArrayStringArrayBoolean687() { 
     assertNull(StringUtils.replaceEachRepeatedly(null, new String[] { "a" }, new String[] { "b" })); 
     assertEquals(StringUtils.replaceEachRepeatedly("", new String[] { "a" }, new String[] { "b" }), ""); 
     assertEquals(StringUtils.replaceEachRepeatedly("aba", null, null), "aba"); 
     assertEquals(StringUtils.replaceEachRepeatedly("aba", new String[0], null), "aba"); 
     assertEquals(StringUtils.replaceEachRepeatedly("aba", null, new String[0]), "aba"); 
     assertEquals(StringUtils.replaceEachRepeatedly("aba", new String[0], null), "aba"); 
     assertEquals(StringUtils.replaceEachRepeatedly("aba", new String[] { "a" }, new String[] { "" }), "b"); 
     assertEquals(StringUtils.replaceEachRepeatedly("aba", new String[] { null }, new String[] { "a" }), "aba"); 
     assertEquals(StringUtils.replaceEachRepeatedly("abcde", new String[] { "ab", "d" }, new String[] { "w", "t" }), "wcte"); 
     assertEquals(StringUtils.replaceEachRepeatedly("abcde", new String[] { "ab", "d" }, new String[] { "d", "t" }), "tcte"); 
     try { 
         StringUtils.replaceEachRepeatedly("abcde", new String[] { "ab", "d" }, new String[] { "d", "ab" }); 
         fail("Should be a circular reference"); 
     } catch (final IllegalStateException e) { 
     } 
 }
@Test
public void testJoin_ArrayOfChars692() { 
     assertEquals(null, StringUtils.join((char[]) null, ',')); 
     assertEquals("1;2", StringUtils.join(CHAR_PRIM_LIST, SEPARATOR_CHAR)); 
     assertEquals("2", StringUtils.join(CHAR_PRIM_LIST, SEPARATOR_CHAR, 1, 2)); 
 }
@Test
public void testJoin_IterableString704() { 
     assertEquals(null, StringUtils.join((Iterable<?>) null, null)); 
     assertEquals(TEXT_LIST_NOSEP, StringUtils.join(Arrays.asList(ARRAY_LIST), null)); 
     assertEquals(TEXT_LIST_NOSEP, StringUtils.join(Arrays.asList(ARRAY_LIST), "")); 
     assertEquals("foo", StringUtils.join(Collections.singleton("foo"), "x")); 
     assertEquals("foo", StringUtils.join(Collections.singleton("foo"), null)); 
     assertEquals("", StringUtils.join(Arrays.asList(NULL_ARRAY_LIST), null)); 
     assertEquals("", StringUtils.join(Arrays.asList(EMPTY_ARRAY_LIST), null)); 
     assertEquals("", StringUtils.join(Arrays.asList(EMPTY_ARRAY_LIST), "")); 
     assertEquals("", StringUtils.join(Arrays.asList(EMPTY_ARRAY_LIST), SEPARATOR)); 
     assertEquals(TEXT_LIST, StringUtils.join(Arrays.asList(ARRAY_LIST), SEPARATOR)); 
 }
@Test
public void testJoin_IterableChar719() { 
     assertEquals(null, StringUtils.join((Iterable<?>) null, ',')); 
     assertEquals(TEXT_LIST_CHAR, StringUtils.join(Arrays.asList(ARRAY_LIST), SEPARATOR_CHAR)); 
     assertEquals("", StringUtils.join(Arrays.asList(NULL_ARRAY_LIST), SEPARATOR_CHAR)); 
     assertEquals("", StringUtils.join(Arrays.asList(EMPTY_ARRAY_LIST), SEPARATOR_CHAR)); 
     assertEquals("foo", StringUtils.join(Collections.singleton("foo"), 'x')); 
 }
@Test
public void testEscapeSurrogatePairs743() throws Exception { 
     assertEquals("\uD83D\uDE30", StringEscapeUtils.escapeCsv("\uD83D\uDE30")); 
     assertEquals("\uD800\uDC00", StringEscapeUtils.escapeCsv("\uD800\uDC00")); 
     assertEquals("\uD834\uDD1E", StringEscapeUtils.escapeCsv("\uD834\uDD1E")); 
     assertEquals("\uDBFF\uDFFD", StringEscapeUtils.escapeCsv("\uDBFF\uDFFD")); 
     assertEquals("\uDBFF\uDFFD", StringEscapeUtils.escapeHtml3("\uDBFF\uDFFD")); 
     assertEquals("\uDBFF\uDFFD", StringEscapeUtils.escapeHtml4("\uDBFF\uDFFD")); 
     assertEquals("\uDBFF\uDFFD", StringEscapeUtils.escapeXml("\uDBFF\uDFFD")); 
 } 
@SuppressWarnings("deprecation")
@Test
public void testChomp747() { 
     final String[][] chompCases = { { FOO_UNCAP + "\r\n", FOO_UNCAP }, { FOO_UNCAP + "\n", FOO_UNCAP }, { FOO_UNCAP + "\r", FOO_UNCAP }, { FOO_UNCAP + " \r", FOO_UNCAP + " " }, { FOO_UNCAP, FOO_UNCAP }, { FOO_UNCAP + "\n\n", FOO_UNCAP + "\n" }, { FOO_UNCAP + "\r\n\r\n", FOO_UNCAP + "\r\n" }, { "foo\nfoo", "foo\nfoo" }, { "foo\n\rfoo", "foo\n\rfoo" }, { "\n", "" }, { "\r", "" }, { "a", "a" }, { "\r\n", "" }, { "", "" }, { null, null }, { FOO_UNCAP + "\n\r", FOO_UNCAP + "\n" } }; 
     for (final String[] chompCase : chompCases) { 
         final String original = chompCase[0]; 
         final String expectedResult = chompCase[1]; 
         assertEquals("chomp(String) failed", expectedResult, StringUtils.chomp(original)); 
     } 
     assertEquals("chomp(String, String) failed", "foo", StringUtils.chomp("foobar", "bar")); 
     assertEquals("chomp(String, String) failed", "foobar", StringUtils.chomp("foobar", "baz")); 
     assertEquals("chomp(String, String) failed", "foo", StringUtils.chomp("foo", "foooo")); 
     assertEquals("chomp(String, String) failed", "foobar", StringUtils.chomp("foobar", "")); 
     assertEquals("chomp(String, String) failed", "foobar", StringUtils.chomp("foobar", null)); 
     assertEquals("chomp(String, String) failed", "", StringUtils.chomp("", "foo")); 
     assertEquals("chomp(String, String) failed", "", StringUtils.chomp("", null)); 
     assertEquals("chomp(String, String) failed", "", StringUtils.chomp("", "")); 
     assertEquals("chomp(String, String) failed", null, StringUtils.chomp(null, "foo")); 
     assertEquals("chomp(String, String) failed", null, StringUtils.chomp(null, null)); 
     assertEquals("chomp(String, String) failed", null, StringUtils.chomp(null, "")); 
     assertEquals("chomp(String, String) failed", "", StringUtils.chomp("foo", "foo")); 
     assertEquals("chomp(String, String) failed", " ", StringUtils.chomp(" foo", "foo")); 
     assertEquals("chomp(String, String) failed", "foo ", StringUtils.chomp("foo ", "foo")); 
 }
@Test
public void testReplace_StringStringArrayStringArray758() { 
     assertNull(StringUtils.replaceEach(null, new String[] { "a" }, new String[] { "b" })); 
     assertEquals(StringUtils.replaceEach("", new String[] { "a" }, new String[] { "b" }), ""); 
     assertEquals(StringUtils.replaceEach("aba", null, null), "aba"); 
     assertEquals(StringUtils.replaceEach("aba", new String[0], null), "aba"); 
     assertEquals(StringUtils.replaceEach("aba", null, new String[0]), "aba"); 
     assertEquals(StringUtils.replaceEach("aba", new String[] { "a" }, null), "aba"); 
     assertEquals(StringUtils.replaceEach("aba", new String[] { "a" }, new String[] { "" }), "b"); 
     assertEquals(StringUtils.replaceEach("aba", new String[] { null }, new String[] { "a" }), "aba"); 
     assertEquals(StringUtils.replaceEach("abcde", new String[] { "ab", "d" }, new String[] { "w", "t" }), "wcte"); 
     assertEquals(StringUtils.replaceEach("abcde", new String[] { "ab", "d" }, new String[] { "d", "t" }), "dcte"); 
     assertEquals("bcc", StringUtils.replaceEach("abc", new String[] { "a", "b" }, new String[] { "b", "c" })); 
     assertEquals("q651.506bera", StringUtils.replaceEach("d216.102oren", new String[] { "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "1", "2", "3", "4", "5", "6", "7", "8", "9" }, new String[] { "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z", "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "5", "6", "7", "8", "9", "1", "2", "3", "4" })); 
     assertEquals(StringUtils.replaceEach("aba", new String[] { "a" }, new String[] { null }), "aba"); 
     assertEquals(StringUtils.replaceEach("aba", new String[] { "a", "b" }, new String[] { "c", null }), "cbc"); 
 }
@Test
public void testAbbreviate_StringIntInt760() { 
     assertEquals(null, StringUtils.abbreviate(null, 10, 12)); 
     assertEquals("", StringUtils.abbreviate("", 0, 10)); 
     assertEquals("", StringUtils.abbreviate("", 2, 10)); 
     try { 
         @SuppressWarnings("unused") 
         final String res = StringUtils.abbreviate("abcdefghij", 0, 3); 
         fail("StringUtils.abbreviate expecting IllegalArgumentException"); 
     } catch (final IllegalArgumentException ex) { 
     } 
     try { 
         @SuppressWarnings("unused") 
         final String res = StringUtils.abbreviate("abcdefghij", 5, 6); 
         fail("StringUtils.abbreviate expecting IllegalArgumentException"); 
     } catch (final IllegalArgumentException ex) { 
     } 
     final String raspberry = "raspberry peach"; 
     assertEquals("raspberry peach", StringUtils.abbreviate(raspberry, 11, 15)); 
     assertEquals(null, StringUtils.abbreviate(null, 7, 14)); 
     assertAbbreviateWithOffset("abcdefg...", -1, 10); 
     assertAbbreviateWithOffset("abcdefg...", 0, 10); 
     assertAbbreviateWithOffset("abcdefg...", 1, 10); 
     assertAbbreviateWithOffset("abcdefg...", 2, 10); 
     assertAbbreviateWithOffset("abcdefg...", 3, 10); 
     assertAbbreviateWithOffset("abcdefg...", 4, 10); 
     assertAbbreviateWithOffset("...fghi...", 5, 10); 
     assertAbbreviateWithOffset("...ghij...", 6, 10); 
     assertAbbreviateWithOffset("...hijk...", 7, 10); 
     assertAbbreviateWithOffset("...ijklmno", 8, 10); 
     assertAbbreviateWithOffset("...ijklmno", 9, 10); 
     assertAbbreviateWithOffset("...ijklmno", 10, 10); 
     assertAbbreviateWithOffset("...ijklmno", 10, 10); 
     assertAbbreviateWithOffset("...ijklmno", 11, 10); 
     assertAbbreviateWithOffset("...ijklmno", 12, 10); 
     assertAbbreviateWithOffset("...ijklmno", 13, 10); 
     assertAbbreviateWithOffset("...ijklmno", 14, 10); 
     assertAbbreviateWithOffset("...ijklmno", 15, 10); 
     assertAbbreviateWithOffset("...ijklmno", 16, 10); 
     assertAbbreviateWithOffset("...ijklmno", Integer.MAX_VALUE, 10); 
 }
@Test
public void testReplace_StringStringArrayStringArray787() { 
     assertNull(StringUtils.replaceEach(null, new String[] { "a" }, new String[] { "b" })); 
     assertEquals(StringUtils.replaceEach("", new String[] { "a" }, new String[] { "b" }), ""); 
     assertEquals(StringUtils.replaceEach("aba", null, null), "aba"); 
     assertEquals(StringUtils.replaceEach("aba", new String[0], null), "aba"); 
     assertEquals(StringUtils.replaceEach("aba", null, new String[0]), "aba"); 
     assertEquals(StringUtils.replaceEach("aba", new String[] { "a" }, null), "aba"); 
     assertEquals(StringUtils.replaceEach("aba", new String[] { "a" }, new String[] { "" }), "b"); 
     assertEquals(StringUtils.replaceEach("aba", new String[] { null }, new String[] { "a" }), "aba"); 
     assertEquals(StringUtils.replaceEach("abcde", new String[] { "ab", "d" }, new String[] { "w", "t" }), "wcte"); 
     assertEquals(StringUtils.replaceEach("abcde", new String[] { "ab", "d" }, new String[] { "d", "t" }), "dcte"); 
     assertEquals("bcc", StringUtils.replaceEach("abc", new String[] { "a", "b" }, new String[] { "b", "c" })); 
     assertEquals("q651.506bera", StringUtils.replaceEach("d216.102oren", new String[] { "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "1", "2", "3", "4", "5", "6", "7", "8", "9" }, new String[] { "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z", "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "5", "6", "7", "8", "9", "1", "2", "3", "4" })); 
     assertEquals(StringUtils.replaceEach("aba", new String[] { "a" }, new String[] { null }), "aba"); 
     assertEquals(StringUtils.replaceEach("aba", new String[] { "a", "b" }, new String[] { "c", null }), "cbc"); 
 }
@Test
public void testLeftPad_StringInt793() { 
     assertEquals(null, StringUtils.leftPad(null, 5)); 
     assertEquals("     ", StringUtils.leftPad("", 5)); 
     assertEquals("  abc", StringUtils.leftPad("abc", 5)); 
     assertEquals("abc", StringUtils.leftPad("abc", 2)); 
 }
@Test
public void testSplitByCharacterType794() { 
     assertNull(StringUtils.splitByCharacterType(null)); 
     assertEquals(0, StringUtils.splitByCharacterType("").length); 
     assertTrue(ArrayUtils.isEquals(new String[] { "ab", " ", "de", " ", "fg" }, StringUtils.splitByCharacterType("ab de fg"))); 
     assertTrue(ArrayUtils.isEquals(new String[] { "ab", "   ", "de", " ", "fg" }, StringUtils.splitByCharacterType("ab   de fg"))); 
     assertTrue(ArrayUtils.isEquals(new String[] { "ab", ":", "cd", ":", "ef" }, StringUtils.splitByCharacterType("ab:cd:ef"))); 
     assertTrue(ArrayUtils.isEquals(new String[] { "number", "5" }, StringUtils.splitByCharacterType("number5"))); 
     assertTrue(ArrayUtils.isEquals(new String[] { "foo", "B", "ar" }, StringUtils.splitByCharacterType("fooBar"))); 
     assertTrue(ArrayUtils.isEquals(new String[] { "foo", "200", "B", "ar" }, StringUtils.splitByCharacterType("foo200Bar"))); 
     assertTrue(ArrayUtils.isEquals(new String[] { "ASFR", "ules" }, StringUtils.splitByCharacterType("ASFRules"))); 
 }
@Test
public void testRepeat_StringInt821() { 
     assertEquals(null, StringUtils.repeat(null, 2)); 
     assertEquals("", StringUtils.repeat("ab", 0)); 
     assertEquals("", StringUtils.repeat("", 3)); 
     assertEquals("aaa", StringUtils.repeat("a", 3)); 
     assertEquals("ababab", StringUtils.repeat("ab", 3)); 
     assertEquals("abcabcabc", StringUtils.repeat("abc", 3)); 
     final String str = StringUtils.repeat("a", 10000); 
     assertEquals(10000, str.length()); 
     assertTrue(StringUtils.containsOnly(str, new char[] { 'a' })); 
 }
@Test
public void testReplace_StringStringArrayStringArray833() { 
     assertNull(StringUtils.replaceEach(null, new String[] { "a" }, new String[] { "b" })); 
     assertEquals(StringUtils.replaceEach("", new String[] { "a" }, new String[] { "b" }), ""); 
     assertEquals(StringUtils.replaceEach("aba", null, null), "aba"); 
     assertEquals(StringUtils.replaceEach("aba", new String[0], null), "aba"); 
     assertEquals(StringUtils.replaceEach("aba", null, new String[0]), "aba"); 
     assertEquals(StringUtils.replaceEach("aba", new String[] { "a" }, null), "aba"); 
     assertEquals(StringUtils.replaceEach("aba", new String[] { "a" }, new String[] { "" }), "b"); 
     assertEquals(StringUtils.replaceEach("aba", new String[] { null }, new String[] { "a" }), "aba"); 
     assertEquals(StringUtils.replaceEach("abcde", new String[] { "ab", "d" }, new String[] { "w", "t" }), "wcte"); 
     assertEquals(StringUtils.replaceEach("abcde", new String[] { "ab", "d" }, new String[] { "d", "t" }), "dcte"); 
     assertEquals("bcc", StringUtils.replaceEach("abc", new String[] { "a", "b" }, new String[] { "b", "c" })); 
     assertEquals("q651.506bera", StringUtils.replaceEach("d216.102oren", new String[] { "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "1", "2", "3", "4", "5", "6", "7", "8", "9" }, new String[] { "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z", "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "5", "6", "7", "8", "9", "1", "2", "3", "4" })); 
     assertEquals(StringUtils.replaceEach("aba", new String[] { "a" }, new String[] { null }), "aba"); 
     assertEquals(StringUtils.replaceEach("aba", new String[] { "a", "b" }, new String[] { "c", null }), "cbc"); 
 }
@Test
public void testSplitByCharacterTypeCamelCase858() { 
     assertNull(StringUtils.splitByCharacterTypeCamelCase(null)); 
     assertEquals(0, StringUtils.splitByCharacterTypeCamelCase("").length); 
     assertTrue(ArrayUtils.isEquals(new String[] { "ab", " ", "de", " ", "fg" }, StringUtils.splitByCharacterTypeCamelCase("ab de fg"))); 
     assertTrue(ArrayUtils.isEquals(new String[] { "ab", "   ", "de", " ", "fg" }, StringUtils.splitByCharacterTypeCamelCase("ab   de fg"))); 
     assertTrue(ArrayUtils.isEquals(new String[] { "ab", ":", "cd", ":", "ef" }, StringUtils.splitByCharacterTypeCamelCase("ab:cd:ef"))); 
     assertTrue(ArrayUtils.isEquals(new String[] { "number", "5" }, StringUtils.splitByCharacterTypeCamelCase("number5"))); 
     assertTrue(ArrayUtils.isEquals(new String[] { "foo", "Bar" }, StringUtils.splitByCharacterTypeCamelCase("fooBar"))); 
     assertTrue(ArrayUtils.isEquals(new String[] { "foo", "200", "Bar" }, StringUtils.splitByCharacterTypeCamelCase("foo200Bar"))); 
     assertTrue(ArrayUtils.isEquals(new String[] { "ASF", "Rules" }, StringUtils.splitByCharacterTypeCamelCase("ASFRules"))); 
 }
@Test
public void testEscapeSurrogatePairsLang858860() throws Exception { 
     assertEquals("\\uDBFF\\uDFFD", StringEscapeUtils.escapeJava("\uDBFF\uDFFD")); 
     assertEquals("\\uDBFF\\uDFFD", StringEscapeUtils.escapeEcmaScript("\uDBFF\uDFFD")); 
 }
@Test
public void testReplace_StringStringArrayStringArray862() { 
     assertNull(StringUtils.replaceEach(null, new String[] { "a" }, new String[] { "b" })); 
     assertEquals(StringUtils.replaceEach("", new String[] { "a" }, new String[] { "b" }), ""); 
     assertEquals(StringUtils.replaceEach("aba", null, null), "aba"); 
     assertEquals(StringUtils.replaceEach("aba", new String[0], null), "aba"); 
     assertEquals(StringUtils.replaceEach("aba", null, new String[0]), "aba"); 
     assertEquals(StringUtils.replaceEach("aba", new String[] { "a" }, null), "aba"); 
     assertEquals(StringUtils.replaceEach("aba", new String[] { "a" }, new String[] { "" }), "b"); 
     assertEquals(StringUtils.replaceEach("aba", new String[] { null }, new String[] { "a" }), "aba"); 
     assertEquals(StringUtils.replaceEach("abcde", new String[] { "ab", "d" }, new String[] { "w", "t" }), "wcte"); 
     assertEquals(StringUtils.replaceEach("abcde", new String[] { "ab", "d" }, new String[] { "d", "t" }), "dcte"); 
     assertEquals("bcc", StringUtils.replaceEach("abc", new String[] { "a", "b" }, new String[] { "b", "c" })); 
     assertEquals("q651.506bera", StringUtils.replaceEach("d216.102oren", new String[] { "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "1", "2", "3", "4", "5", "6", "7", "8", "9" }, new String[] { "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z", "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "5", "6", "7", "8", "9", "1", "2", "3", "4" })); 
     assertEquals(StringUtils.replaceEach("aba", new String[] { "a" }, new String[] { null }), "aba"); 
     assertEquals(StringUtils.replaceEach("aba", new String[] { "a", "b" }, new String[] { "c", null }), "cbc"); 
 }
@Test
public void testEscapeSurrogatePairsLang858863() throws Exception { 
     assertEquals("\\uDBFF\\uDFFD", StringEscapeUtils.escapeJava("\uDBFF\uDFFD")); 
     assertEquals("\\uDBFF\\uDFFD", StringEscapeUtils.escapeEcmaScript("\uDBFF\uDFFD")); 
 }
@Test
public void testRepeat_StringStringInt887() { 
     assertEquals(null, StringUtils.repeat(null, null, 2)); 
     assertEquals(null, StringUtils.repeat(null, "x", 2)); 
     assertEquals("", StringUtils.repeat("", null, 2)); 
     assertEquals("", StringUtils.repeat("ab", "", 0)); 
     assertEquals("", StringUtils.repeat("", "", 2)); 
     assertEquals("xx", StringUtils.repeat("", "x", 3)); 
     assertEquals("?, ?, ?", StringUtils.repeat("?", ", ", 3)); 
 }
@Test
public void testGetLevenshteinDistance_StringStringInt888() { 
     assertEquals(0, StringUtils.getLevenshteinDistance("", "", 0)); 
     assertEquals(7, StringUtils.getLevenshteinDistance("aaapppp", "", 8)); 
     assertEquals(7, StringUtils.getLevenshteinDistance("aaapppp", "", 7)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("aaapppp", "", 6)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("b", "a", 0)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("a", "b", 0)); 
     assertEquals(0, StringUtils.getLevenshteinDistance("aa", "aa", 0)); 
     assertEquals(0, StringUtils.getLevenshteinDistance("aa", "aa", 2)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("aaa", "bbb", 2)); 
     assertEquals(3, StringUtils.getLevenshteinDistance("aaa", "bbb", 3)); 
     assertEquals(6, StringUtils.getLevenshteinDistance("aaaaaa", "b", 10)); 
     assertEquals(7, StringUtils.getLevenshteinDistance("aaapppp", "b", 8)); 
     assertEquals(3, StringUtils.getLevenshteinDistance("a", "bbb", 4)); 
     assertEquals(7, StringUtils.getLevenshteinDistance("aaapppp", "b", 7)); 
     assertEquals(3, StringUtils.getLevenshteinDistance("a", "bbb", 3)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("a", "bbb", 2)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("bbb", "a", 2)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("aaapppp", "b", 6)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("a", "bbb", 1)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("bbb", "a", 1)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("12345", "1234567", 1)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("1234567", "12345", 1)); 
     assertEquals(1, StringUtils.getLevenshteinDistance("frog", "fog", 1)); 
     assertEquals(3, StringUtils.getLevenshteinDistance("fly", "ant", 3)); 
     assertEquals(7, StringUtils.getLevenshteinDistance("elephant", "hippo", 7)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("elephant", "hippo", 6)); 
     assertEquals(7, StringUtils.getLevenshteinDistance("hippo", "elephant", 7)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("hippo", "elephant", 6)); 
     assertEquals(8, StringUtils.getLevenshteinDistance("hippo", "zzzzzzzz", 8)); 
     assertEquals(8, StringUtils.getLevenshteinDistance("zzzzzzzz", "hippo", 8)); 
     assertEquals(1, StringUtils.getLevenshteinDistance("hello", "hallo", 1)); 
     try { 
         @SuppressWarnings("unused") 
         final int d = StringUtils.getLevenshteinDistance("a", null, 0); 
         fail("expecting IllegalArgumentException"); 
     } catch (final IllegalArgumentException ex) { 
     } 
     try { 
         @SuppressWarnings("unused") 
         final int d = StringUtils.getLevenshteinDistance(null, "a", 0); 
         fail("expecting IllegalArgumentException"); 
     } catch (final IllegalArgumentException ex) { 
     } 
     try { 
         @SuppressWarnings("unused") 
         final int d = StringUtils.getLevenshteinDistance("a", "a", -1); 
         fail("expecting IllegalArgumentException"); 
     } catch (final IllegalArgumentException ex) { 
     } 
 }
@Test
public void testAbbreviateMiddle921() { 
     assertNull(StringUtils.abbreviateMiddle(null, null, 0)); 
     assertEquals("abc", StringUtils.abbreviateMiddle("abc", null, 0)); 
     assertEquals("abc", StringUtils.abbreviateMiddle("abc", ".", 0)); 
     assertEquals("abc", StringUtils.abbreviateMiddle("abc", ".", 3)); 
     assertEquals("ab.f", StringUtils.abbreviateMiddle("abcdef", ".", 4)); 
     assertEquals("A very long text with un...f the text is complete.", StringUtils.abbreviateMiddle("A very long text with unimportant stuff in the middle but interesting start and " + "end to see if the text is complete.", "...", 50)); 
     final String longText = "Start text" + StringUtils.repeat("x", 10000) + "Close text"; 
     assertEquals("Start text->Close text", StringUtils.abbreviateMiddle(longText, "->", 22)); 
     assertEquals("abc", StringUtils.abbreviateMiddle("abc", ".", -1)); 
     assertEquals("abc", StringUtils.abbreviateMiddle("abc", ".", 1)); 
     assertEquals("abc", StringUtils.abbreviateMiddle("abc", ".", 2)); 
     assertEquals("a", StringUtils.abbreviateMiddle("a", ".", 1)); 
     assertEquals("a.d", StringUtils.abbreviateMiddle("abcd", ".", 3)); 
     assertEquals("a..f", StringUtils.abbreviateMiddle("abcdef", "..", 4)); 
     assertEquals("ab.ef", StringUtils.abbreviateMiddle("abcdef", ".", 5)); 
 }
@Test
public void testCenter_StringIntChar944() { 
     assertEquals(null, StringUtils.center(null, -1, ' ')); 
     assertEquals(null, StringUtils.center(null, 4, ' ')); 
     assertEquals("    ", StringUtils.center("", 4, ' ')); 
     assertEquals("ab", StringUtils.center("ab", 0, ' ')); 
     assertEquals("ab", StringUtils.center("ab", -1, ' ')); 
     assertEquals("ab", StringUtils.center("ab", 1, ' ')); 
     assertEquals("    ", StringUtils.center("", 4, ' ')); 
     assertEquals(" ab ", StringUtils.center("ab", 4, ' ')); 
     assertEquals("abcd", StringUtils.center("abcd", 2, ' ')); 
     assertEquals(" a  ", StringUtils.center("a", 4, ' ')); 
     assertEquals("  a  ", StringUtils.center("a", 5, ' ')); 
     assertEquals("xxaxx", StringUtils.center("a", 5, 'x')); 
 }
@Test
public void testRepeat_StringInt945() { 
     assertEquals(null, StringUtils.repeat(null, 2)); 
     assertEquals("", StringUtils.repeat("ab", 0)); 
     assertEquals("", StringUtils.repeat("", 3)); 
     assertEquals("aaa", StringUtils.repeat("a", 3)); 
     assertEquals("ababab", StringUtils.repeat("ab", 3)); 
     assertEquals("abcabcabc", StringUtils.repeat("abc", 3)); 
     final String str = StringUtils.repeat("a", 10000); 
     assertEquals(10000, str.length()); 
     assertTrue(StringUtils.containsOnly(str, new char[] { 'a' })); 
 }
@Test
public void testAbbreviate_StringIntInt948() { 
     assertEquals(null, StringUtils.abbreviate(null, 10, 12)); 
     assertEquals("", StringUtils.abbreviate("", 0, 10)); 
     assertEquals("", StringUtils.abbreviate("", 2, 10)); 
     try { 
         @SuppressWarnings("unused") 
         final String res = StringUtils.abbreviate("abcdefghij", 0, 3); 
         fail("StringUtils.abbreviate expecting IllegalArgumentException"); 
     } catch (final IllegalArgumentException ex) { 
     } 
     try { 
         @SuppressWarnings("unused") 
         final String res = StringUtils.abbreviate("abcdefghij", 5, 6); 
         fail("StringUtils.abbreviate expecting IllegalArgumentException"); 
     } catch (final IllegalArgumentException ex) { 
     } 
     final String raspberry = "raspberry peach"; 
     assertEquals("raspberry peach", StringUtils.abbreviate(raspberry, 11, 15)); 
     assertEquals(null, StringUtils.abbreviate(null, 7, 14)); 
     assertAbbreviateWithOffset("abcdefg...", -1, 10); 
     assertAbbreviateWithOffset("abcdefg...", 0, 10); 
     assertAbbreviateWithOffset("abcdefg...", 1, 10); 
     assertAbbreviateWithOffset("abcdefg...", 2, 10); 
     assertAbbreviateWithOffset("abcdefg...", 3, 10); 
     assertAbbreviateWithOffset("abcdefg...", 4, 10); 
     assertAbbreviateWithOffset("...fghi...", 5, 10); 
     assertAbbreviateWithOffset("...ghij...", 6, 10); 
     assertAbbreviateWithOffset("...hijk...", 7, 10); 
     assertAbbreviateWithOffset("...ijklmno", 8, 10); 
     assertAbbreviateWithOffset("...ijklmno", 9, 10); 
     assertAbbreviateWithOffset("...ijklmno", 10, 10); 
     assertAbbreviateWithOffset("...ijklmno", 10, 10); 
     assertAbbreviateWithOffset("...ijklmno", 11, 10); 
     assertAbbreviateWithOffset("...ijklmno", 12, 10); 
     assertAbbreviateWithOffset("...ijklmno", 13, 10); 
     assertAbbreviateWithOffset("...ijklmno", 14, 10); 
     assertAbbreviateWithOffset("...ijklmno", 15, 10); 
     assertAbbreviateWithOffset("...ijklmno", 16, 10); 
     assertAbbreviateWithOffset("...ijklmno", Integer.MAX_VALUE, 10); 
 }
@Test
public void testLang623955() { 
     assertEquals("t", StringUtils.replaceChars("\u00DE", '\u00DE', 't')); 
     assertEquals("t", StringUtils.replaceChars("\u00FE", '\u00FE', 't')); 
 }
@Test
public void testJoin_ArrayOfShorts971() { 
     assertEquals(null, StringUtils.join((short[]) null, ',')); 
     assertEquals("1;2", StringUtils.join(SHORT_PRIM_LIST, SEPARATOR_CHAR)); 
     assertEquals("2", StringUtils.join(SHORT_PRIM_LIST, SEPARATOR_CHAR, 1, 2)); 
 }
@Test
public void testJoin_ArrayOfLongs987() { 
     assertEquals(null, StringUtils.join((long[]) null, ',')); 
     assertEquals("1;2", StringUtils.join(LONG_PRIM_LIST, SEPARATOR_CHAR)); 
     assertEquals("2", StringUtils.join(LONG_PRIM_LIST, SEPARATOR_CHAR, 1, 2)); 
 }
@Test
public void testJoin_IterableChar989() { 
     assertEquals(null, StringUtils.join((Iterable<?>) null, ',')); 
     assertEquals(TEXT_LIST_CHAR, StringUtils.join(Arrays.asList(ARRAY_LIST), SEPARATOR_CHAR)); 
     assertEquals("", StringUtils.join(Arrays.asList(NULL_ARRAY_LIST), SEPARATOR_CHAR)); 
     assertEquals("", StringUtils.join(Arrays.asList(EMPTY_ARRAY_LIST), SEPARATOR_CHAR)); 
     assertEquals("foo", StringUtils.join(Collections.singleton("foo"), 'x')); 
 }
@Test
public void testGetCommonPrefix_StringArray1002() { 
     assertEquals("", StringUtils.getCommonPrefix((String[]) null)); 
     assertEquals("", StringUtils.getCommonPrefix()); 
     assertEquals("abc", StringUtils.getCommonPrefix("abc")); 
     assertEquals("", StringUtils.getCommonPrefix(null, null)); 
     assertEquals("", StringUtils.getCommonPrefix("", "")); 
     assertEquals("", StringUtils.getCommonPrefix("", null)); 
     assertEquals("", StringUtils.getCommonPrefix("abc", null, null)); 
     assertEquals("", StringUtils.getCommonPrefix(null, null, "abc")); 
     assertEquals("", StringUtils.getCommonPrefix("", "abc")); 
     assertEquals("", StringUtils.getCommonPrefix("abc", "")); 
     assertEquals("abc", StringUtils.getCommonPrefix("abc", "abc")); 
     assertEquals("a", StringUtils.getCommonPrefix("abc", "a")); 
     assertEquals("ab", StringUtils.getCommonPrefix("ab", "abxyz")); 
     assertEquals("ab", StringUtils.getCommonPrefix("abcde", "abxyz")); 
     assertEquals("", StringUtils.getCommonPrefix("abcde", "xyz")); 
     assertEquals("", StringUtils.getCommonPrefix("xyz", "abcde")); 
     assertEquals("i am a ", StringUtils.getCommonPrefix("i am a machine", "i am a robot")); 
 }
@Test
public void testCenter_StringIntChar1022() { 
     assertEquals(null, StringUtils.center(null, -1, ' ')); 
     assertEquals(null, StringUtils.center(null, 4, ' ')); 
     assertEquals("    ", StringUtils.center("", 4, ' ')); 
     assertEquals("ab", StringUtils.center("ab", 0, ' ')); 
     assertEquals("ab", StringUtils.center("ab", -1, ' ')); 
     assertEquals("ab", StringUtils.center("ab", 1, ' ')); 
     assertEquals("    ", StringUtils.center("", 4, ' ')); 
     assertEquals(" ab ", StringUtils.center("ab", 4, ' ')); 
     assertEquals("abcd", StringUtils.center("abcd", 2, ' ')); 
     assertEquals(" a  ", StringUtils.center("a", 4, ' ')); 
     assertEquals("  a  ", StringUtils.center("a", 5, ' ')); 
     assertEquals("xxaxx", StringUtils.center("a", 5, 'x')); 
 }
@Test
public void testReplace_StringStringArrayStringArray1033() { 
     assertNull(StringUtils.replaceEach(null, new String[] { "a" }, new String[] { "b" })); 
     assertEquals(StringUtils.replaceEach("", new String[] { "a" }, new String[] { "b" }), ""); 
     assertEquals(StringUtils.replaceEach("aba", null, null), "aba"); 
     assertEquals(StringUtils.replaceEach("aba", new String[0], null), "aba"); 
     assertEquals(StringUtils.replaceEach("aba", null, new String[0]), "aba"); 
     assertEquals(StringUtils.replaceEach("aba", new String[] { "a" }, null), "aba"); 
     assertEquals(StringUtils.replaceEach("aba", new String[] { "a" }, new String[] { "" }), "b"); 
     assertEquals(StringUtils.replaceEach("aba", new String[] { null }, new String[] { "a" }), "aba"); 
     assertEquals(StringUtils.replaceEach("abcde", new String[] { "ab", "d" }, new String[] { "w", "t" }), "wcte"); 
     assertEquals(StringUtils.replaceEach("abcde", new String[] { "ab", "d" }, new String[] { "d", "t" }), "dcte"); 
     assertEquals("bcc", StringUtils.replaceEach("abc", new String[] { "a", "b" }, new String[] { "b", "c" })); 
     assertEquals("q651.506bera", StringUtils.replaceEach("d216.102oren", new String[] { "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "1", "2", "3", "4", "5", "6", "7", "8", "9" }, new String[] { "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z", "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "5", "6", "7", "8", "9", "1", "2", "3", "4" })); 
     assertEquals(StringUtils.replaceEach("aba", new String[] { "a" }, new String[] { null }), "aba"); 
     assertEquals(StringUtils.replaceEach("aba", new String[] { "a", "b" }, new String[] { "c", null }), "cbc"); 
 } 
@SuppressWarnings("deprecation")
@Test
public void testChomp1036() { 
     final String[][] chompCases = { { FOO_UNCAP + "\r\n", FOO_UNCAP }, { FOO_UNCAP + "\n", FOO_UNCAP }, { FOO_UNCAP + "\r", FOO_UNCAP }, { FOO_UNCAP + " \r", FOO_UNCAP + " " }, { FOO_UNCAP, FOO_UNCAP }, { FOO_UNCAP + "\n\n", FOO_UNCAP + "\n" }, { FOO_UNCAP + "\r\n\r\n", FOO_UNCAP + "\r\n" }, { "foo\nfoo", "foo\nfoo" }, { "foo\n\rfoo", "foo\n\rfoo" }, { "\n", "" }, { "\r", "" }, { "a", "a" }, { "\r\n", "" }, { "", "" }, { null, null }, { FOO_UNCAP + "\n\r", FOO_UNCAP + "\n" } }; 
     for (final String[] chompCase : chompCases) { 
         final String original = chompCase[0]; 
         final String expectedResult = chompCase[1]; 
         assertEquals("chomp(String) failed", expectedResult, StringUtils.chomp(original)); 
     } 
     assertEquals("chomp(String, String) failed", "foo", StringUtils.chomp("foobar", "bar")); 
     assertEquals("chomp(String, String) failed", "foobar", StringUtils.chomp("foobar", "baz")); 
     assertEquals("chomp(String, String) failed", "foo", StringUtils.chomp("foo", "foooo")); 
     assertEquals("chomp(String, String) failed", "foobar", StringUtils.chomp("foobar", "")); 
     assertEquals("chomp(String, String) failed", "foobar", StringUtils.chomp("foobar", null)); 
     assertEquals("chomp(String, String) failed", "", StringUtils.chomp("", "foo")); 
     assertEquals("chomp(String, String) failed", "", StringUtils.chomp("", null)); 
     assertEquals("chomp(String, String) failed", "", StringUtils.chomp("", "")); 
     assertEquals("chomp(String, String) failed", null, StringUtils.chomp(null, "foo")); 
     assertEquals("chomp(String, String) failed", null, StringUtils.chomp(null, null)); 
     assertEquals("chomp(String, String) failed", null, StringUtils.chomp(null, "")); 
     assertEquals("chomp(String, String) failed", "", StringUtils.chomp("foo", "foo")); 
     assertEquals("chomp(String, String) failed", " ", StringUtils.chomp(" foo", "foo")); 
     assertEquals("chomp(String, String) failed", "foo ", StringUtils.chomp("foo ", "foo")); 
 }
@Test
public void testDifference_StringString1059() { 
     assertEquals(null, StringUtils.difference(null, null)); 
     assertEquals("", StringUtils.difference("", "")); 
     assertEquals("abc", StringUtils.difference("", "abc")); 
     assertEquals("", StringUtils.difference("abc", "")); 
     assertEquals("i am a robot", StringUtils.difference(null, "i am a robot")); 
     assertEquals("i am a machine", StringUtils.difference("i am a machine", null)); 
     assertEquals("robot", StringUtils.difference("i am a machine", "i am a robot")); 
     assertEquals("", StringUtils.difference("abc", "abc")); 
     assertEquals("you are a robot", StringUtils.difference("i am a robot", "you are a robot")); 
 }
@Test
public void testSplitByCharacterType1065() { 
     assertNull(StringUtils.splitByCharacterType(null)); 
     assertEquals(0, StringUtils.splitByCharacterType("").length); 
     assertTrue(ArrayUtils.isEquals(new String[] { "ab", " ", "de", " ", "fg" }, StringUtils.splitByCharacterType("ab de fg"))); 
     assertTrue(ArrayUtils.isEquals(new String[] { "ab", "   ", "de", " ", "fg" }, StringUtils.splitByCharacterType("ab   de fg"))); 
     assertTrue(ArrayUtils.isEquals(new String[] { "ab", ":", "cd", ":", "ef" }, StringUtils.splitByCharacterType("ab:cd:ef"))); 
     assertTrue(ArrayUtils.isEquals(new String[] { "number", "5" }, StringUtils.splitByCharacterType("number5"))); 
     assertTrue(ArrayUtils.isEquals(new String[] { "foo", "B", "ar" }, StringUtils.splitByCharacterType("fooBar"))); 
     assertTrue(ArrayUtils.isEquals(new String[] { "foo", "200", "B", "ar" }, StringUtils.splitByCharacterType("foo200Bar"))); 
     assertTrue(ArrayUtils.isEquals(new String[] { "ASFR", "ules" }, StringUtils.splitByCharacterType("ASFRules"))); 
 }
@Test
public void testReplaceChars_StringStringString1081() { 
     assertEquals(null, StringUtils.replaceChars(null, null, null)); 
     assertEquals(null, StringUtils.replaceChars(null, "", null)); 
     assertEquals(null, StringUtils.replaceChars(null, "a", null)); 
     assertEquals(null, StringUtils.replaceChars(null, null, "")); 
     assertEquals(null, StringUtils.replaceChars(null, null, "x")); 
     assertEquals("", StringUtils.replaceChars("", null, null)); 
     assertEquals("", StringUtils.replaceChars("", "", null)); 
     assertEquals("", StringUtils.replaceChars("", "a", null)); 
     assertEquals("", StringUtils.replaceChars("", null, "")); 
     assertEquals("", StringUtils.replaceChars("", null, "x")); 
     assertEquals("abc", StringUtils.replaceChars("abc", null, null)); 
     assertEquals("abc", StringUtils.replaceChars("abc", null, "")); 
     assertEquals("abc", StringUtils.replaceChars("abc", null, "x")); 
     assertEquals("abc", StringUtils.replaceChars("abc", "", null)); 
     assertEquals("abc", StringUtils.replaceChars("abc", "", "")); 
     assertEquals("abc", StringUtils.replaceChars("abc", "", "x")); 
     assertEquals("ac", StringUtils.replaceChars("abc", "b", null)); 
     assertEquals("ac", StringUtils.replaceChars("abc", "b", "")); 
     assertEquals("axc", StringUtils.replaceChars("abc", "b", "x")); 
     assertEquals("ayzya", StringUtils.replaceChars("abcba", "bc", "yz")); 
     assertEquals("ayya", StringUtils.replaceChars("abcba", "bc", "y")); 
     assertEquals("ayzya", StringUtils.replaceChars("abcba", "bc", "yzx")); 
     assertEquals("abcba", StringUtils.replaceChars("abcba", "z", "w")); 
     assertSame("abcba", StringUtils.replaceChars("abcba", "z", "w")); 
     assertEquals("jelly", StringUtils.replaceChars("hello", "ho", "jy")); 
     assertEquals("ayzya", StringUtils.replaceChars("abcba", "bc", "yz")); 
     assertEquals("ayya", StringUtils.replaceChars("abcba", "bc", "y")); 
     assertEquals("ayzya", StringUtils.replaceChars("abcba", "bc", "yzx")); 
     assertEquals("bcc", StringUtils.replaceChars("abc", "ab", "bc")); 
     assertEquals("q651.506bera", StringUtils.replaceChars("d216.102oren", "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ123456789", "nopqrstuvwxyzabcdefghijklmNOPQRSTUVWXYZABCDEFGHIJKLM567891234")); 
 }
@Test
public void testJoin_ArrayOfBytes1113() { 
     assertEquals(null, StringUtils.join((byte[]) null, ',')); 
     assertEquals("1;2", StringUtils.join(BYTE_PRIM_LIST, SEPARATOR_CHAR)); 
     assertEquals("2", StringUtils.join(BYTE_PRIM_LIST, SEPARATOR_CHAR, 1, 2)); 
 }
@Test
public void testRepeat_StringStringInt1136() { 
     assertEquals(null, StringUtils.repeat(null, null, 2)); 
     assertEquals(null, StringUtils.repeat(null, "x", 2)); 
     assertEquals("", StringUtils.repeat("", null, 2)); 
     assertEquals("", StringUtils.repeat("ab", "", 0)); 
     assertEquals("", StringUtils.repeat("", "", 2)); 
     assertEquals("xx", StringUtils.repeat("", "x", 3)); 
     assertEquals("?, ?, ?", StringUtils.repeat("?", ", ", 3)); 
 }
@Test
public void testSplit_StringChar1145() { 
     assertArrayEquals(null, StringUtils.split(null, '.')); 
     assertEquals(0, StringUtils.split("", '.').length); 
     String str = "a.b.. c"; 
     String[] res = StringUtils.split(str, '.'); 
     assertEquals(3, res.length); 
     assertEquals("a", res[0]); 
     assertEquals("b", res[1]); 
     assertEquals(" c", res[2]); 
     str = ".a."; 
     res = StringUtils.split(str, '.'); 
     assertEquals(1, res.length); 
     assertEquals("a", res[0]); 
     str = "a b c"; 
     res = StringUtils.split(str, ' '); 
     assertEquals(3, res.length); 
     assertEquals("a", res[0]); 
     assertEquals("b", res[1]); 
     assertEquals("c", res[2]); 
 }
@Test
public void testGetLevenshteinDistance_StringStringInt1153() { 
     assertEquals(0, StringUtils.getLevenshteinDistance("", "", 0)); 
     assertEquals(7, StringUtils.getLevenshteinDistance("aaapppp", "", 8)); 
     assertEquals(7, StringUtils.getLevenshteinDistance("aaapppp", "", 7)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("aaapppp", "", 6)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("b", "a", 0)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("a", "b", 0)); 
     assertEquals(0, StringUtils.getLevenshteinDistance("aa", "aa", 0)); 
     assertEquals(0, StringUtils.getLevenshteinDistance("aa", "aa", 2)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("aaa", "bbb", 2)); 
     assertEquals(3, StringUtils.getLevenshteinDistance("aaa", "bbb", 3)); 
     assertEquals(6, StringUtils.getLevenshteinDistance("aaaaaa", "b", 10)); 
     assertEquals(7, StringUtils.getLevenshteinDistance("aaapppp", "b", 8)); 
     assertEquals(3, StringUtils.getLevenshteinDistance("a", "bbb", 4)); 
     assertEquals(7, StringUtils.getLevenshteinDistance("aaapppp", "b", 7)); 
     assertEquals(3, StringUtils.getLevenshteinDistance("a", "bbb", 3)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("a", "bbb", 2)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("bbb", "a", 2)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("aaapppp", "b", 6)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("a", "bbb", 1)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("bbb", "a", 1)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("12345", "1234567", 1)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("1234567", "12345", 1)); 
     assertEquals(1, StringUtils.getLevenshteinDistance("frog", "fog", 1)); 
     assertEquals(3, StringUtils.getLevenshteinDistance("fly", "ant", 3)); 
     assertEquals(7, StringUtils.getLevenshteinDistance("elephant", "hippo", 7)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("elephant", "hippo", 6)); 
     assertEquals(7, StringUtils.getLevenshteinDistance("hippo", "elephant", 7)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("hippo", "elephant", 6)); 
     assertEquals(8, StringUtils.getLevenshteinDistance("hippo", "zzzzzzzz", 8)); 
     assertEquals(8, StringUtils.getLevenshteinDistance("zzzzzzzz", "hippo", 8)); 
     assertEquals(1, StringUtils.getLevenshteinDistance("hello", "hallo", 1)); 
     try { 
         @SuppressWarnings("unused") 
         final int d = StringUtils.getLevenshteinDistance("a", null, 0); 
         fail("expecting IllegalArgumentException"); 
     } catch (final IllegalArgumentException ex) { 
     } 
     try { 
         @SuppressWarnings("unused") 
         final int d = StringUtils.getLevenshteinDistance(null, "a", 0); 
         fail("expecting IllegalArgumentException"); 
     } catch (final IllegalArgumentException ex) { 
     } 
     try { 
         @SuppressWarnings("unused") 
         final int d = StringUtils.getLevenshteinDistance("a", "a", -1); 
         fail("expecting IllegalArgumentException"); 
     } catch (final IllegalArgumentException ex) { 
     } 
 }
@Test
public void testReplace_StringStringArrayStringArrayBoolean1162() { 
     assertNull(StringUtils.replaceEachRepeatedly(null, new String[] { "a" }, new String[] { "b" })); 
     assertEquals(StringUtils.replaceEachRepeatedly("", new String[] { "a" }, new String[] { "b" }), ""); 
     assertEquals(StringUtils.replaceEachRepeatedly("aba", null, null), "aba"); 
     assertEquals(StringUtils.replaceEachRepeatedly("aba", new String[0], null), "aba"); 
     assertEquals(StringUtils.replaceEachRepeatedly("aba", null, new String[0]), "aba"); 
     assertEquals(StringUtils.replaceEachRepeatedly("aba", new String[0], null), "aba"); 
     assertEquals(StringUtils.replaceEachRepeatedly("aba", new String[] { "a" }, new String[] { "" }), "b"); 
     assertEquals(StringUtils.replaceEachRepeatedly("aba", new String[] { null }, new String[] { "a" }), "aba"); 
     assertEquals(StringUtils.replaceEachRepeatedly("abcde", new String[] { "ab", "d" }, new String[] { "w", "t" }), "wcte"); 
     assertEquals(StringUtils.replaceEachRepeatedly("abcde", new String[] { "ab", "d" }, new String[] { "d", "t" }), "tcte"); 
     try { 
         StringUtils.replaceEachRepeatedly("abcde", new String[] { "ab", "d" }, new String[] { "d", "ab" }); 
         fail("Should be a circular reference"); 
     } catch (final IllegalStateException e) { 
     } 
 }
@Test
public void testJoin_ArrayCharSeparator1169() { 
     assertEquals(null, StringUtils.join((Object[]) null, ',')); 
     assertEquals(TEXT_LIST_CHAR, StringUtils.join(ARRAY_LIST, SEPARATOR_CHAR)); 
     assertEquals("", StringUtils.join(EMPTY_ARRAY_LIST, SEPARATOR_CHAR)); 
     assertEquals(";;foo", StringUtils.join(MIXED_ARRAY_LIST, SEPARATOR_CHAR)); 
     assertEquals("foo;2", StringUtils.join(MIXED_TYPE_LIST, SEPARATOR_CHAR)); 
     assertEquals("/", StringUtils.join(MIXED_ARRAY_LIST, '/', 0, MIXED_ARRAY_LIST.length - 1)); 
     assertEquals("foo", StringUtils.join(MIXED_TYPE_LIST, '/', 0, 1)); 
     assertEquals("null", StringUtils.join(NULL_TO_STRING_LIST, '/', 0, 1)); 
     assertEquals("foo/2", StringUtils.join(MIXED_TYPE_LIST, '/', 0, 2)); 
     assertEquals("2", StringUtils.join(MIXED_TYPE_LIST, '/', 1, 2)); 
     assertEquals("", StringUtils.join(MIXED_TYPE_LIST, '/', 2, 1)); 
 }
@Test
public void testReverseDelimited_StringChar1184() { 
     assertEquals(null, StringUtils.reverseDelimited(null, '.')); 
     assertEquals("", StringUtils.reverseDelimited("", '.')); 
     assertEquals("c.b.a", StringUtils.reverseDelimited("a.b.c", '.')); 
     assertEquals("a b c", StringUtils.reverseDelimited("a b c", '.')); 
     assertEquals("", StringUtils.reverseDelimited("", '.')); 
 }
@Test
public void testGetLevenshteinDistance_StringStringInt1194() { 
     assertEquals(0, StringUtils.getLevenshteinDistance("", "", 0)); 
     assertEquals(7, StringUtils.getLevenshteinDistance("aaapppp", "", 8)); 
     assertEquals(7, StringUtils.getLevenshteinDistance("aaapppp", "", 7)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("aaapppp", "", 6)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("b", "a", 0)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("a", "b", 0)); 
     assertEquals(0, StringUtils.getLevenshteinDistance("aa", "aa", 0)); 
     assertEquals(0, StringUtils.getLevenshteinDistance("aa", "aa", 2)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("aaa", "bbb", 2)); 
     assertEquals(3, StringUtils.getLevenshteinDistance("aaa", "bbb", 3)); 
     assertEquals(6, StringUtils.getLevenshteinDistance("aaaaaa", "b", 10)); 
     assertEquals(7, StringUtils.getLevenshteinDistance("aaapppp", "b", 8)); 
     assertEquals(3, StringUtils.getLevenshteinDistance("a", "bbb", 4)); 
     assertEquals(7, StringUtils.getLevenshteinDistance("aaapppp", "b", 7)); 
     assertEquals(3, StringUtils.getLevenshteinDistance("a", "bbb", 3)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("a", "bbb", 2)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("bbb", "a", 2)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("aaapppp", "b", 6)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("a", "bbb", 1)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("bbb", "a", 1)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("12345", "1234567", 1)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("1234567", "12345", 1)); 
     assertEquals(1, StringUtils.getLevenshteinDistance("frog", "fog", 1)); 
     assertEquals(3, StringUtils.getLevenshteinDistance("fly", "ant", 3)); 
     assertEquals(7, StringUtils.getLevenshteinDistance("elephant", "hippo", 7)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("elephant", "hippo", 6)); 
     assertEquals(7, StringUtils.getLevenshteinDistance("hippo", "elephant", 7)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("hippo", "elephant", 6)); 
     assertEquals(8, StringUtils.getLevenshteinDistance("hippo", "zzzzzzzz", 8)); 
     assertEquals(8, StringUtils.getLevenshteinDistance("zzzzzzzz", "hippo", 8)); 
     assertEquals(1, StringUtils.getLevenshteinDistance("hello", "hallo", 1)); 
     try { 
         @SuppressWarnings("unused") 
         final int d = StringUtils.getLevenshteinDistance("a", null, 0); 
         fail("expecting IllegalArgumentException"); 
     } catch (final IllegalArgumentException ex) { 
     } 
     try { 
         @SuppressWarnings("unused") 
         final int d = StringUtils.getLevenshteinDistance(null, "a", 0); 
         fail("expecting IllegalArgumentException"); 
     } catch (final IllegalArgumentException ex) { 
     } 
     try { 
         @SuppressWarnings("unused") 
         final int d = StringUtils.getLevenshteinDistance("a", "a", -1); 
         fail("expecting IllegalArgumentException"); 
     } catch (final IllegalArgumentException ex) { 
     } 
 }
@Test
public void testReverseDelimited_StringChar1207() { 
     assertEquals(null, StringUtils.reverseDelimited(null, '.')); 
     assertEquals("", StringUtils.reverseDelimited("", '.')); 
     assertEquals("c.b.a", StringUtils.reverseDelimited("a.b.c", '.')); 
     assertEquals("a b c", StringUtils.reverseDelimited("a b c", '.')); 
     assertEquals("", StringUtils.reverseDelimited("", '.')); 
 }
@Test
public void testDifference_StringString1235() { 
     assertEquals(null, StringUtils.difference(null, null)); 
     assertEquals("", StringUtils.difference("", "")); 
     assertEquals("abc", StringUtils.difference("", "abc")); 
     assertEquals("", StringUtils.difference("abc", "")); 
     assertEquals("i am a robot", StringUtils.difference(null, "i am a robot")); 
     assertEquals("i am a machine", StringUtils.difference("i am a machine", null)); 
     assertEquals("robot", StringUtils.difference("i am a machine", "i am a robot")); 
     assertEquals("", StringUtils.difference("abc", "abc")); 
     assertEquals("you are a robot", StringUtils.difference("i am a robot", "you are a robot")); 
 }
@Test
public void testEscapeSurrogatePairs1252() throws Exception { 
     assertEquals("\uD83D\uDE30", StringEscapeUtils.escapeCsv("\uD83D\uDE30")); 
     assertEquals("\uD800\uDC00", StringEscapeUtils.escapeCsv("\uD800\uDC00")); 
     assertEquals("\uD834\uDD1E", StringEscapeUtils.escapeCsv("\uD834\uDD1E")); 
     assertEquals("\uDBFF\uDFFD", StringEscapeUtils.escapeCsv("\uDBFF\uDFFD")); 
     assertEquals("\uDBFF\uDFFD", StringEscapeUtils.escapeHtml3("\uDBFF\uDFFD")); 
     assertEquals("\uDBFF\uDFFD", StringEscapeUtils.escapeHtml4("\uDBFF\uDFFD")); 
     assertEquals("\uDBFF\uDFFD", StringEscapeUtils.escapeXml("\uDBFF\uDFFD")); 
 }
@Test
public void testGetCommonPrefix_StringArray1254() { 
     assertEquals("", StringUtils.getCommonPrefix((String[]) null)); 
     assertEquals("", StringUtils.getCommonPrefix()); 
     assertEquals("abc", StringUtils.getCommonPrefix("abc")); 
     assertEquals("", StringUtils.getCommonPrefix(null, null)); 
     assertEquals("", StringUtils.getCommonPrefix("", "")); 
     assertEquals("", StringUtils.getCommonPrefix("", null)); 
     assertEquals("", StringUtils.getCommonPrefix("abc", null, null)); 
     assertEquals("", StringUtils.getCommonPrefix(null, null, "abc")); 
     assertEquals("", StringUtils.getCommonPrefix("", "abc")); 
     assertEquals("", StringUtils.getCommonPrefix("abc", "")); 
     assertEquals("abc", StringUtils.getCommonPrefix("abc", "abc")); 
     assertEquals("a", StringUtils.getCommonPrefix("abc", "a")); 
     assertEquals("ab", StringUtils.getCommonPrefix("ab", "abxyz")); 
     assertEquals("ab", StringUtils.getCommonPrefix("abcde", "abxyz")); 
     assertEquals("", StringUtils.getCommonPrefix("abcde", "xyz")); 
     assertEquals("", StringUtils.getCommonPrefix("xyz", "abcde")); 
     assertEquals("i am a ", StringUtils.getCommonPrefix("i am a machine", "i am a robot")); 
 }
@Test
public void testReplaceChars_StringStringString1260() { 
     assertEquals(null, StringUtils.replaceChars(null, null, null)); 
     assertEquals(null, StringUtils.replaceChars(null, "", null)); 
     assertEquals(null, StringUtils.replaceChars(null, "a", null)); 
     assertEquals(null, StringUtils.replaceChars(null, null, "")); 
     assertEquals(null, StringUtils.replaceChars(null, null, "x")); 
     assertEquals("", StringUtils.replaceChars("", null, null)); 
     assertEquals("", StringUtils.replaceChars("", "", null)); 
     assertEquals("", StringUtils.replaceChars("", "a", null)); 
     assertEquals("", StringUtils.replaceChars("", null, "")); 
     assertEquals("", StringUtils.replaceChars("", null, "x")); 
     assertEquals("abc", StringUtils.replaceChars("abc", null, null)); 
     assertEquals("abc", StringUtils.replaceChars("abc", null, "")); 
     assertEquals("abc", StringUtils.replaceChars("abc", null, "x")); 
     assertEquals("abc", StringUtils.replaceChars("abc", "", null)); 
     assertEquals("abc", StringUtils.replaceChars("abc", "", "")); 
     assertEquals("abc", StringUtils.replaceChars("abc", "", "x")); 
     assertEquals("ac", StringUtils.replaceChars("abc", "b", null)); 
     assertEquals("ac", StringUtils.replaceChars("abc", "b", "")); 
     assertEquals("axc", StringUtils.replaceChars("abc", "b", "x")); 
     assertEquals("ayzya", StringUtils.replaceChars("abcba", "bc", "yz")); 
     assertEquals("ayya", StringUtils.replaceChars("abcba", "bc", "y")); 
     assertEquals("ayzya", StringUtils.replaceChars("abcba", "bc", "yzx")); 
     assertEquals("abcba", StringUtils.replaceChars("abcba", "z", "w")); 
     assertSame("abcba", StringUtils.replaceChars("abcba", "z", "w")); 
     assertEquals("jelly", StringUtils.replaceChars("hello", "ho", "jy")); 
     assertEquals("ayzya", StringUtils.replaceChars("abcba", "bc", "yz")); 
     assertEquals("ayya", StringUtils.replaceChars("abcba", "bc", "y")); 
     assertEquals("ayzya", StringUtils.replaceChars("abcba", "bc", "yzx")); 
     assertEquals("bcc", StringUtils.replaceChars("abc", "ab", "bc")); 
     assertEquals("q651.506bera", StringUtils.replaceChars("d216.102oren", "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ123456789", "nopqrstuvwxyzabcdefghijklmNOPQRSTUVWXYZABCDEFGHIJKLM567891234")); 
 }
@Test
public void testRemoveStartIgnoreCase1272() { 
     assertNull("removeStartIgnoreCase(null, null)", StringUtils.removeStartIgnoreCase(null, null)); 
     assertNull("removeStartIgnoreCase(null, \"\")", StringUtils.removeStartIgnoreCase(null, "")); 
     assertNull("removeStartIgnoreCase(null, \"a\")", StringUtils.removeStartIgnoreCase(null, "a")); 
     assertEquals("removeStartIgnoreCase(\"\", null)", StringUtils.removeStartIgnoreCase("", null), ""); 
     assertEquals("removeStartIgnoreCase(\"\", \"\")", StringUtils.removeStartIgnoreCase("", ""), ""); 
     assertEquals("removeStartIgnoreCase(\"\", \"a\")", StringUtils.removeStartIgnoreCase("", "a"), ""); 
     assertEquals("removeStartIgnoreCase(\"www.domain.com\", \"www.\")", StringUtils.removeStartIgnoreCase("www.domain.com", "www."), "domain.com"); 
     assertEquals("removeStartIgnoreCase(\"domain.com\", \"www.\")", StringUtils.removeStartIgnoreCase("domain.com", "www."), "domain.com"); 
     assertEquals("removeStartIgnoreCase(\"domain.com\", \"\")", StringUtils.removeStartIgnoreCase("domain.com", ""), "domain.com"); 
     assertEquals("removeStartIgnoreCase(\"domain.com\", null)", StringUtils.removeStartIgnoreCase("domain.com", null), "domain.com"); 
     assertEquals("removeStartIgnoreCase(\"www.domain.com\", \"WWW.\")", StringUtils.removeStartIgnoreCase("www.domain.com", "WWW."), "domain.com"); 
 }
@Test
public void testSplitByWholeSeparatorPreserveAllTokens_StringStringInt1274() { 
     assertArrayEquals(null, StringUtils.splitByWholeSeparatorPreserveAllTokens(null, ".", -1)); 
     assertEquals(0, StringUtils.splitByWholeSeparatorPreserveAllTokens("", ".", -1).length); 
     String input = "ab   de fg"; 
     String[] expected = new String[] { "ab", "", "", "de", "fg" }; 
     String[] actual = StringUtils.splitByWholeSeparatorPreserveAllTokens(input, null, -1); 
     assertEquals(expected.length, actual.length); 
     for (int i = 0; i < actual.length; i += 1) { 
         assertEquals(expected[i], actual[i]); 
     } 
     input = "1::2:::3::::4"; 
     expected = new String[] { "1", "", "2", "", "", "3", "", "", "", "4" }; 
     actual = StringUtils.splitByWholeSeparatorPreserveAllTokens(input, ":", -1); 
     assertEquals(expected.length, actual.length); 
     for (int i = 0; i < actual.length; i += 1) { 
         assertEquals(expected[i], actual[i]); 
     } 
     input = "1::2:::3::::4"; 
     expected = new String[] { "1", "2", ":3", "", "4" }; 
     actual = StringUtils.splitByWholeSeparatorPreserveAllTokens(input, "::", -1); 
     assertEquals(expected.length, actual.length); 
     for (int i = 0; i < actual.length; i += 1) { 
         assertEquals(expected[i], actual[i]); 
     } 
     input = "1::2::3:4"; 
     expected = new String[] { "1", "", "2", ":3:4" }; 
     actual = StringUtils.splitByWholeSeparatorPreserveAllTokens(input, ":", 4); 
     assertEquals(expected.length, actual.length); 
     for (int i = 0; i < actual.length; i += 1) { 
         assertEquals(expected[i], actual[i]); 
     } 
 }
@Test
public void testJoin_IteratorChar1277() { 
     assertEquals(null, StringUtils.join((Iterator<?>) null, ',')); 
     assertEquals(TEXT_LIST_CHAR, StringUtils.join(Arrays.asList(ARRAY_LIST).iterator(), SEPARATOR_CHAR)); 
     assertEquals("", StringUtils.join(Arrays.asList(NULL_ARRAY_LIST).iterator(), SEPARATOR_CHAR)); 
     assertEquals("", StringUtils.join(Arrays.asList(EMPTY_ARRAY_LIST).iterator(), SEPARATOR_CHAR)); 
     assertEquals("foo", StringUtils.join(Collections.singleton("foo").iterator(), 'x')); 
 }
@Test
public void testGetCommonPrefix_StringArray1279() { 
     assertEquals("", StringUtils.getCommonPrefix((String[]) null)); 
     assertEquals("", StringUtils.getCommonPrefix()); 
     assertEquals("abc", StringUtils.getCommonPrefix("abc")); 
     assertEquals("", StringUtils.getCommonPrefix(null, null)); 
     assertEquals("", StringUtils.getCommonPrefix("", "")); 
     assertEquals("", StringUtils.getCommonPrefix("", null)); 
     assertEquals("", StringUtils.getCommonPrefix("abc", null, null)); 
     assertEquals("", StringUtils.getCommonPrefix(null, null, "abc")); 
     assertEquals("", StringUtils.getCommonPrefix("", "abc")); 
     assertEquals("", StringUtils.getCommonPrefix("abc", "")); 
     assertEquals("abc", StringUtils.getCommonPrefix("abc", "abc")); 
     assertEquals("a", StringUtils.getCommonPrefix("abc", "a")); 
     assertEquals("ab", StringUtils.getCommonPrefix("ab", "abxyz")); 
     assertEquals("ab", StringUtils.getCommonPrefix("abcde", "abxyz")); 
     assertEquals("", StringUtils.getCommonPrefix("abcde", "xyz")); 
     assertEquals("", StringUtils.getCommonPrefix("xyz", "abcde")); 
     assertEquals("i am a ", StringUtils.getCommonPrefix("i am a machine", "i am a robot")); 
 }
@Test
public void testReplace_StringStringArrayStringArrayBoolean1304() { 
     assertNull(StringUtils.replaceEachRepeatedly(null, new String[] { "a" }, new String[] { "b" })); 
     assertEquals(StringUtils.replaceEachRepeatedly("", new String[] { "a" }, new String[] { "b" }), ""); 
     assertEquals(StringUtils.replaceEachRepeatedly("aba", null, null), "aba"); 
     assertEquals(StringUtils.replaceEachRepeatedly("aba", new String[0], null), "aba"); 
     assertEquals(StringUtils.replaceEachRepeatedly("aba", null, new String[0]), "aba"); 
     assertEquals(StringUtils.replaceEachRepeatedly("aba", new String[0], null), "aba"); 
     assertEquals(StringUtils.replaceEachRepeatedly("aba", new String[] { "a" }, new String[] { "" }), "b"); 
     assertEquals(StringUtils.replaceEachRepeatedly("aba", new String[] { null }, new String[] { "a" }), "aba"); 
     assertEquals(StringUtils.replaceEachRepeatedly("abcde", new String[] { "ab", "d" }, new String[] { "w", "t" }), "wcte"); 
     assertEquals(StringUtils.replaceEachRepeatedly("abcde", new String[] { "ab", "d" }, new String[] { "d", "t" }), "tcte"); 
     try { 
         StringUtils.replaceEachRepeatedly("abcde", new String[] { "ab", "d" }, new String[] { "d", "ab" }); 
         fail("Should be a circular reference"); 
     } catch (final IllegalStateException e) { 
     } 
 }
@Test
public void testSplitByCharacterType1310() { 
     assertNull(StringUtils.splitByCharacterType(null)); 
     assertEquals(0, StringUtils.splitByCharacterType("").length); 
     assertTrue(ArrayUtils.isEquals(new String[] { "ab", " ", "de", " ", "fg" }, StringUtils.splitByCharacterType("ab de fg"))); 
     assertTrue(ArrayUtils.isEquals(new String[] { "ab", "   ", "de", " ", "fg" }, StringUtils.splitByCharacterType("ab   de fg"))); 
     assertTrue(ArrayUtils.isEquals(new String[] { "ab", ":", "cd", ":", "ef" }, StringUtils.splitByCharacterType("ab:cd:ef"))); 
     assertTrue(ArrayUtils.isEquals(new String[] { "number", "5" }, StringUtils.splitByCharacterType("number5"))); 
     assertTrue(ArrayUtils.isEquals(new String[] { "foo", "B", "ar" }, StringUtils.splitByCharacterType("fooBar"))); 
     assertTrue(ArrayUtils.isEquals(new String[] { "foo", "200", "B", "ar" }, StringUtils.splitByCharacterType("foo200Bar"))); 
     assertTrue(ArrayUtils.isEquals(new String[] { "ASFR", "ules" }, StringUtils.splitByCharacterType("ASFRules"))); 
 }
@Test
public void testReplace_StringStringArrayStringArray1317() { 
     assertNull(StringUtils.replaceEach(null, new String[] { "a" }, new String[] { "b" })); 
     assertEquals(StringUtils.replaceEach("", new String[] { "a" }, new String[] { "b" }), ""); 
     assertEquals(StringUtils.replaceEach("aba", null, null), "aba"); 
     assertEquals(StringUtils.replaceEach("aba", new String[0], null), "aba"); 
     assertEquals(StringUtils.replaceEach("aba", null, new String[0]), "aba"); 
     assertEquals(StringUtils.replaceEach("aba", new String[] { "a" }, null), "aba"); 
     assertEquals(StringUtils.replaceEach("aba", new String[] { "a" }, new String[] { "" }), "b"); 
     assertEquals(StringUtils.replaceEach("aba", new String[] { null }, new String[] { "a" }), "aba"); 
     assertEquals(StringUtils.replaceEach("abcde", new String[] { "ab", "d" }, new String[] { "w", "t" }), "wcte"); 
     assertEquals(StringUtils.replaceEach("abcde", new String[] { "ab", "d" }, new String[] { "d", "t" }), "dcte"); 
     assertEquals("bcc", StringUtils.replaceEach("abc", new String[] { "a", "b" }, new String[] { "b", "c" })); 
     assertEquals("q651.506bera", StringUtils.replaceEach("d216.102oren", new String[] { "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "1", "2", "3", "4", "5", "6", "7", "8", "9" }, new String[] { "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z", "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "5", "6", "7", "8", "9", "1", "2", "3", "4" })); 
     assertEquals(StringUtils.replaceEach("aba", new String[] { "a" }, new String[] { null }), "aba"); 
     assertEquals(StringUtils.replaceEach("aba", new String[] { "a", "b" }, new String[] { "c", null }), "cbc"); 
 }
@Test
public void testJoin_ArrayOfLongs1327() { 
     assertEquals(null, StringUtils.join((long[]) null, ',')); 
     assertEquals("1;2", StringUtils.join(LONG_PRIM_LIST, SEPARATOR_CHAR)); 
     assertEquals("2", StringUtils.join(LONG_PRIM_LIST, SEPARATOR_CHAR, 1, 2)); 
 }
@Test
public void testReplace_StringStringArrayStringArray1355() { 
     assertNull(StringUtils.replaceEach(null, new String[] { "a" }, new String[] { "b" })); 
     assertEquals(StringUtils.replaceEach("", new String[] { "a" }, new String[] { "b" }), ""); 
     assertEquals(StringUtils.replaceEach("aba", null, null), "aba"); 
     assertEquals(StringUtils.replaceEach("aba", new String[0], null), "aba"); 
     assertEquals(StringUtils.replaceEach("aba", null, new String[0]), "aba"); 
     assertEquals(StringUtils.replaceEach("aba", new String[] { "a" }, null), "aba"); 
     assertEquals(StringUtils.replaceEach("aba", new String[] { "a" }, new String[] { "" }), "b"); 
     assertEquals(StringUtils.replaceEach("aba", new String[] { null }, new String[] { "a" }), "aba"); 
     assertEquals(StringUtils.replaceEach("abcde", new String[] { "ab", "d" }, new String[] { "w", "t" }), "wcte"); 
     assertEquals(StringUtils.replaceEach("abcde", new String[] { "ab", "d" }, new String[] { "d", "t" }), "dcte"); 
     assertEquals("bcc", StringUtils.replaceEach("abc", new String[] { "a", "b" }, new String[] { "b", "c" })); 
     assertEquals("q651.506bera", StringUtils.replaceEach("d216.102oren", new String[] { "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "1", "2", "3", "4", "5", "6", "7", "8", "9" }, new String[] { "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z", "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "5", "6", "7", "8", "9", "1", "2", "3", "4" })); 
     assertEquals(StringUtils.replaceEach("aba", new String[] { "a" }, new String[] { null }), "aba"); 
     assertEquals(StringUtils.replaceEach("aba", new String[] { "a", "b" }, new String[] { "c", null }), "cbc"); 
 }
@Test
public void testSplit_StringChar1369() { 
     assertArrayEquals(null, StringUtils.split(null, '.')); 
     assertEquals(0, StringUtils.split("", '.').length); 
     String str = "a.b.. c"; 
     String[] res = StringUtils.split(str, '.'); 
     assertEquals(3, res.length); 
     assertEquals("a", res[0]); 
     assertEquals("b", res[1]); 
     assertEquals(" c", res[2]); 
     str = ".a."; 
     res = StringUtils.split(str, '.'); 
     assertEquals(1, res.length); 
     assertEquals("a", res[0]); 
     str = "a b c"; 
     res = StringUtils.split(str, ' '); 
     assertEquals(3, res.length); 
     assertEquals("a", res[0]); 
     assertEquals("b", res[1]); 
     assertEquals("c", res[2]); 
 }
@Test
public void testReplaceChars_StringStringString1393() { 
     assertEquals(null, StringUtils.replaceChars(null, null, null)); 
     assertEquals(null, StringUtils.replaceChars(null, "", null)); 
     assertEquals(null, StringUtils.replaceChars(null, "a", null)); 
     assertEquals(null, StringUtils.replaceChars(null, null, "")); 
     assertEquals(null, StringUtils.replaceChars(null, null, "x")); 
     assertEquals("", StringUtils.replaceChars("", null, null)); 
     assertEquals("", StringUtils.replaceChars("", "", null)); 
     assertEquals("", StringUtils.replaceChars("", "a", null)); 
     assertEquals("", StringUtils.replaceChars("", null, "")); 
     assertEquals("", StringUtils.replaceChars("", null, "x")); 
     assertEquals("abc", StringUtils.replaceChars("abc", null, null)); 
     assertEquals("abc", StringUtils.replaceChars("abc", null, "")); 
     assertEquals("abc", StringUtils.replaceChars("abc", null, "x")); 
     assertEquals("abc", StringUtils.replaceChars("abc", "", null)); 
     assertEquals("abc", StringUtils.replaceChars("abc", "", "")); 
     assertEquals("abc", StringUtils.replaceChars("abc", "", "x")); 
     assertEquals("ac", StringUtils.replaceChars("abc", "b", null)); 
     assertEquals("ac", StringUtils.replaceChars("abc", "b", "")); 
     assertEquals("axc", StringUtils.replaceChars("abc", "b", "x")); 
     assertEquals("ayzya", StringUtils.replaceChars("abcba", "bc", "yz")); 
     assertEquals("ayya", StringUtils.replaceChars("abcba", "bc", "y")); 
     assertEquals("ayzya", StringUtils.replaceChars("abcba", "bc", "yzx")); 
     assertEquals("abcba", StringUtils.replaceChars("abcba", "z", "w")); 
     assertSame("abcba", StringUtils.replaceChars("abcba", "z", "w")); 
     assertEquals("jelly", StringUtils.replaceChars("hello", "ho", "jy")); 
     assertEquals("ayzya", StringUtils.replaceChars("abcba", "bc", "yz")); 
     assertEquals("ayya", StringUtils.replaceChars("abcba", "bc", "y")); 
     assertEquals("ayzya", StringUtils.replaceChars("abcba", "bc", "yzx")); 
     assertEquals("bcc", StringUtils.replaceChars("abc", "ab", "bc")); 
     assertEquals("q651.506bera", StringUtils.replaceChars("d216.102oren", "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ123456789", "nopqrstuvwxyzabcdefghijklmNOPQRSTUVWXYZABCDEFGHIJKLM567891234")); 
 }
@Test
public void testChop1408() { 
     final String[][] chopCases = { { FOO_UNCAP + "\r\n", FOO_UNCAP }, { FOO_UNCAP + "\n", FOO_UNCAP }, { FOO_UNCAP + "\r", FOO_UNCAP }, { FOO_UNCAP + " \r", FOO_UNCAP + " " }, { "foo", "fo" }, { "foo\nfoo", "foo\nfo" }, { "\n", "" }, { "\r", "" }, { "\r\n", "" }, { null, null }, { "", "" }, { "a", "" } }; 
     for (final String[] chopCase : chopCases) { 
         final String original = chopCase[0]; 
         final String expectedResult = chopCase[1]; 
         assertEquals("chop(String) failed", expectedResult, StringUtils.chop(original)); 
     } 
 }
@Test
public void testCenter_StringInt1459() { 
     assertEquals(null, StringUtils.center(null, -1)); 
     assertEquals(null, StringUtils.center(null, 4)); 
     assertEquals("    ", StringUtils.center("", 4)); 
     assertEquals("ab", StringUtils.center("ab", 0)); 
     assertEquals("ab", StringUtils.center("ab", -1)); 
     assertEquals("ab", StringUtils.center("ab", 1)); 
     assertEquals("    ", StringUtils.center("", 4)); 
     assertEquals(" ab ", StringUtils.center("ab", 4)); 
     assertEquals("abcd", StringUtils.center("abcd", 2)); 
     assertEquals(" a  ", StringUtils.center("a", 4)); 
     assertEquals("  a  ", StringUtils.center("a", 5)); 
 }
@Test
public void testOverlay_StringStringIntInt1460() { 
     assertEquals(null, StringUtils.overlay(null, null, 2, 4)); 
     assertEquals(null, StringUtils.overlay(null, null, -2, -4)); 
     assertEquals("", StringUtils.overlay("", null, 0, 0)); 
     assertEquals("", StringUtils.overlay("", "", 0, 0)); 
     assertEquals("zzzz", StringUtils.overlay("", "zzzz", 0, 0)); 
     assertEquals("zzzz", StringUtils.overlay("", "zzzz", 2, 4)); 
     assertEquals("zzzz", StringUtils.overlay("", "zzzz", -2, -4)); 
     assertEquals("abef", StringUtils.overlay("abcdef", null, 2, 4)); 
     assertEquals("abef", StringUtils.overlay("abcdef", null, 4, 2)); 
     assertEquals("abef", StringUtils.overlay("abcdef", "", 2, 4)); 
     assertEquals("abef", StringUtils.overlay("abcdef", "", 4, 2)); 
     assertEquals("abzzzzef", StringUtils.overlay("abcdef", "zzzz", 2, 4)); 
     assertEquals("abzzzzef", StringUtils.overlay("abcdef", "zzzz", 4, 2)); 
     assertEquals("zzzzef", StringUtils.overlay("abcdef", "zzzz", -1, 4)); 
     assertEquals("zzzzef", StringUtils.overlay("abcdef", "zzzz", 4, -1)); 
     assertEquals("zzzzabcdef", StringUtils.overlay("abcdef", "zzzz", -2, -1)); 
     assertEquals("zzzzabcdef", StringUtils.overlay("abcdef", "zzzz", -1, -2)); 
     assertEquals("abcdzzzz", StringUtils.overlay("abcdef", "zzzz", 4, 10)); 
     assertEquals("abcdzzzz", StringUtils.overlay("abcdef", "zzzz", 10, 4)); 
     assertEquals("abcdefzzzz", StringUtils.overlay("abcdef", "zzzz", 8, 10)); 
     assertEquals("abcdefzzzz", StringUtils.overlay("abcdef", "zzzz", 10, 8)); 
 }
@Test
public void testJoin_ArrayOfShorts1465() { 
     assertEquals(null, StringUtils.join((short[]) null, ',')); 
     assertEquals("1;2", StringUtils.join(SHORT_PRIM_LIST, SEPARATOR_CHAR)); 
     assertEquals("2", StringUtils.join(SHORT_PRIM_LIST, SEPARATOR_CHAR, 1, 2)); 
 }
@Test
public void testJoin_IterableString1490() { 
     assertEquals(null, StringUtils.join((Iterable<?>) null, null)); 
     assertEquals(TEXT_LIST_NOSEP, StringUtils.join(Arrays.asList(ARRAY_LIST), null)); 
     assertEquals(TEXT_LIST_NOSEP, StringUtils.join(Arrays.asList(ARRAY_LIST), "")); 
     assertEquals("foo", StringUtils.join(Collections.singleton("foo"), "x")); 
     assertEquals("foo", StringUtils.join(Collections.singleton("foo"), null)); 
     assertEquals("", StringUtils.join(Arrays.asList(NULL_ARRAY_LIST), null)); 
     assertEquals("", StringUtils.join(Arrays.asList(EMPTY_ARRAY_LIST), null)); 
     assertEquals("", StringUtils.join(Arrays.asList(EMPTY_ARRAY_LIST), "")); 
     assertEquals("", StringUtils.join(Arrays.asList(EMPTY_ARRAY_LIST), SEPARATOR)); 
     assertEquals(TEXT_LIST, StringUtils.join(Arrays.asList(ARRAY_LIST), SEPARATOR)); 
 }
@Test
public void testDefaultIfBlank_StringBuffers1491() { 
     assertEquals("NULL", StringUtils.defaultIfBlank(new StringBuffer(""), new StringBuffer("NULL")).toString()); 
     assertEquals("NULL", StringUtils.defaultIfBlank(new StringBuffer(" "), new StringBuffer("NULL")).toString()); 
     assertEquals("abc", StringUtils.defaultIfBlank(new StringBuffer("abc"), new StringBuffer("NULL")).toString()); 
     assertNull(StringUtils.defaultIfBlank(new StringBuffer(""), null)); 
     final StringBuffer s = StringUtils.defaultIfBlank(new StringBuffer("abc"), new StringBuffer("NULL")); 
     assertEquals("abc", s.toString()); 
 }
@Test
public void testEscapeSurrogatePairsLang8581502() throws Exception { 
     assertEquals("\\uDBFF\\uDFFD", StringEscapeUtils.escapeJava("\uDBFF\uDFFD")); 
     assertEquals("\\uDBFF\\uDFFD", StringEscapeUtils.escapeEcmaScript("\uDBFF\uDFFD")); 
 }
@Test
public void testDeleteWhitespace_String1503() { 
     assertEquals(null, StringUtils.deleteWhitespace(null)); 
     assertEquals("", StringUtils.deleteWhitespace("")); 
     assertEquals("", StringUtils.deleteWhitespace("  \u000C  \t\t\u001F\n\n \u000B  ")); 
     assertEquals("", StringUtils.deleteWhitespace(StringUtilsTest.WHITESPACE)); 
     assertEquals(StringUtilsTest.NON_WHITESPACE, StringUtils.deleteWhitespace(StringUtilsTest.NON_WHITESPACE)); 
     assertEquals("\u00A0\u202F", StringUtils.deleteWhitespace("  \u00A0  \t\t\n\n \u202F  ")); 
     assertEquals("\u00A0\u202F", StringUtils.deleteWhitespace("\u00A0\u202F")); 
     assertEquals("test", StringUtils.deleteWhitespace("\u000Bt  \t\n\u0009e\rs\n\n   \tt")); 
 }
@Test
public void testAbbreviate_StringIntInt1515() { 
     assertEquals(null, StringUtils.abbreviate(null, 10, 12)); 
     assertEquals("", StringUtils.abbreviate("", 0, 10)); 
     assertEquals("", StringUtils.abbreviate("", 2, 10)); 
     try { 
         @SuppressWarnings("unused") 
         final String res = StringUtils.abbreviate("abcdefghij", 0, 3); 
         fail("StringUtils.abbreviate expecting IllegalArgumentException"); 
     } catch (final IllegalArgumentException ex) { 
     } 
     try { 
         @SuppressWarnings("unused") 
         final String res = StringUtils.abbreviate("abcdefghij", 5, 6); 
         fail("StringUtils.abbreviate expecting IllegalArgumentException"); 
     } catch (final IllegalArgumentException ex) { 
     } 
     final String raspberry = "raspberry peach"; 
     assertEquals("raspberry peach", StringUtils.abbreviate(raspberry, 11, 15)); 
     assertEquals(null, StringUtils.abbreviate(null, 7, 14)); 
     assertAbbreviateWithOffset("abcdefg...", -1, 10); 
     assertAbbreviateWithOffset("abcdefg...", 0, 10); 
     assertAbbreviateWithOffset("abcdefg...", 1, 10); 
     assertAbbreviateWithOffset("abcdefg...", 2, 10); 
     assertAbbreviateWithOffset("abcdefg...", 3, 10); 
     assertAbbreviateWithOffset("abcdefg...", 4, 10); 
     assertAbbreviateWithOffset("...fghi...", 5, 10); 
     assertAbbreviateWithOffset("...ghij...", 6, 10); 
     assertAbbreviateWithOffset("...hijk...", 7, 10); 
     assertAbbreviateWithOffset("...ijklmno", 8, 10); 
     assertAbbreviateWithOffset("...ijklmno", 9, 10); 
     assertAbbreviateWithOffset("...ijklmno", 10, 10); 
     assertAbbreviateWithOffset("...ijklmno", 10, 10); 
     assertAbbreviateWithOffset("...ijklmno", 11, 10); 
     assertAbbreviateWithOffset("...ijklmno", 12, 10); 
     assertAbbreviateWithOffset("...ijklmno", 13, 10); 
     assertAbbreviateWithOffset("...ijklmno", 14, 10); 
     assertAbbreviateWithOffset("...ijklmno", 15, 10); 
     assertAbbreviateWithOffset("...ijklmno", 16, 10); 
     assertAbbreviateWithOffset("...ijklmno", Integer.MAX_VALUE, 10); 
 }
@Test
public void testGetLevenshteinDistance_StringStringInt1542() { 
     assertEquals(0, StringUtils.getLevenshteinDistance("", "", 0)); 
     assertEquals(7, StringUtils.getLevenshteinDistance("aaapppp", "", 8)); 
     assertEquals(7, StringUtils.getLevenshteinDistance("aaapppp", "", 7)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("aaapppp", "", 6)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("b", "a", 0)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("a", "b", 0)); 
     assertEquals(0, StringUtils.getLevenshteinDistance("aa", "aa", 0)); 
     assertEquals(0, StringUtils.getLevenshteinDistance("aa", "aa", 2)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("aaa", "bbb", 2)); 
     assertEquals(3, StringUtils.getLevenshteinDistance("aaa", "bbb", 3)); 
     assertEquals(6, StringUtils.getLevenshteinDistance("aaaaaa", "b", 10)); 
     assertEquals(7, StringUtils.getLevenshteinDistance("aaapppp", "b", 8)); 
     assertEquals(3, StringUtils.getLevenshteinDistance("a", "bbb", 4)); 
     assertEquals(7, StringUtils.getLevenshteinDistance("aaapppp", "b", 7)); 
     assertEquals(3, StringUtils.getLevenshteinDistance("a", "bbb", 3)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("a", "bbb", 2)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("bbb", "a", 2)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("aaapppp", "b", 6)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("a", "bbb", 1)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("bbb", "a", 1)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("12345", "1234567", 1)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("1234567", "12345", 1)); 
     assertEquals(1, StringUtils.getLevenshteinDistance("frog", "fog", 1)); 
     assertEquals(3, StringUtils.getLevenshteinDistance("fly", "ant", 3)); 
     assertEquals(7, StringUtils.getLevenshteinDistance("elephant", "hippo", 7)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("elephant", "hippo", 6)); 
     assertEquals(7, StringUtils.getLevenshteinDistance("hippo", "elephant", 7)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("hippo", "elephant", 6)); 
     assertEquals(8, StringUtils.getLevenshteinDistance("hippo", "zzzzzzzz", 8)); 
     assertEquals(8, StringUtils.getLevenshteinDistance("zzzzzzzz", "hippo", 8)); 
     assertEquals(1, StringUtils.getLevenshteinDistance("hello", "hallo", 1)); 
     try { 
         @SuppressWarnings("unused") 
         final int d = StringUtils.getLevenshteinDistance("a", null, 0); 
         fail("expecting IllegalArgumentException"); 
     } catch (final IllegalArgumentException ex) { 
     } 
     try { 
         @SuppressWarnings("unused") 
         final int d = StringUtils.getLevenshteinDistance(null, "a", 0); 
         fail("expecting IllegalArgumentException"); 
     } catch (final IllegalArgumentException ex) { 
     } 
     try { 
         @SuppressWarnings("unused") 
         final int d = StringUtils.getLevenshteinDistance("a", "a", -1); 
         fail("expecting IllegalArgumentException"); 
     } catch (final IllegalArgumentException ex) { 
     } 
 }
@Test
public void testEscapeSurrogatePairs1547() throws Exception { 
     assertEquals("\uD83D\uDE30", StringEscapeUtils.escapeCsv("\uD83D\uDE30")); 
     assertEquals("\uD800\uDC00", StringEscapeUtils.escapeCsv("\uD800\uDC00")); 
     assertEquals("\uD834\uDD1E", StringEscapeUtils.escapeCsv("\uD834\uDD1E")); 
     assertEquals("\uDBFF\uDFFD", StringEscapeUtils.escapeCsv("\uDBFF\uDFFD")); 
     assertEquals("\uDBFF\uDFFD", StringEscapeUtils.escapeHtml3("\uDBFF\uDFFD")); 
     assertEquals("\uDBFF\uDFFD", StringEscapeUtils.escapeHtml4("\uDBFF\uDFFD")); 
     assertEquals("\uDBFF\uDFFD", StringEscapeUtils.escapeXml("\uDBFF\uDFFD")); 
 }
@Test
public void testJoin_ArrayOfBytes1551() { 
     assertEquals(null, StringUtils.join((byte[]) null, ',')); 
     assertEquals("1;2", StringUtils.join(BYTE_PRIM_LIST, SEPARATOR_CHAR)); 
     assertEquals("2", StringUtils.join(BYTE_PRIM_LIST, SEPARATOR_CHAR, 1, 2)); 
 }
@Test
public void testDefaultIfBlank_StringBuffers1574() { 
     assertEquals("NULL", StringUtils.defaultIfBlank(new StringBuffer(""), new StringBuffer("NULL")).toString()); 
     assertEquals("NULL", StringUtils.defaultIfBlank(new StringBuffer(" "), new StringBuffer("NULL")).toString()); 
     assertEquals("abc", StringUtils.defaultIfBlank(new StringBuffer("abc"), new StringBuffer("NULL")).toString()); 
     assertNull(StringUtils.defaultIfBlank(new StringBuffer(""), null)); 
     final StringBuffer s = StringUtils.defaultIfBlank(new StringBuffer("abc"), new StringBuffer("NULL")); 
     assertEquals("abc", s.toString()); 
 }
@Test
public void testGetLevenshteinDistance_StringStringInt1578() { 
     assertEquals(0, StringUtils.getLevenshteinDistance("", "", 0)); 
     assertEquals(7, StringUtils.getLevenshteinDistance("aaapppp", "", 8)); 
     assertEquals(7, StringUtils.getLevenshteinDistance("aaapppp", "", 7)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("aaapppp", "", 6)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("b", "a", 0)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("a", "b", 0)); 
     assertEquals(0, StringUtils.getLevenshteinDistance("aa", "aa", 0)); 
     assertEquals(0, StringUtils.getLevenshteinDistance("aa", "aa", 2)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("aaa", "bbb", 2)); 
     assertEquals(3, StringUtils.getLevenshteinDistance("aaa", "bbb", 3)); 
     assertEquals(6, StringUtils.getLevenshteinDistance("aaaaaa", "b", 10)); 
     assertEquals(7, StringUtils.getLevenshteinDistance("aaapppp", "b", 8)); 
     assertEquals(3, StringUtils.getLevenshteinDistance("a", "bbb", 4)); 
     assertEquals(7, StringUtils.getLevenshteinDistance("aaapppp", "b", 7)); 
     assertEquals(3, StringUtils.getLevenshteinDistance("a", "bbb", 3)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("a", "bbb", 2)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("bbb", "a", 2)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("aaapppp", "b", 6)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("a", "bbb", 1)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("bbb", "a", 1)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("12345", "1234567", 1)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("1234567", "12345", 1)); 
     assertEquals(1, StringUtils.getLevenshteinDistance("frog", "fog", 1)); 
     assertEquals(3, StringUtils.getLevenshteinDistance("fly", "ant", 3)); 
     assertEquals(7, StringUtils.getLevenshteinDistance("elephant", "hippo", 7)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("elephant", "hippo", 6)); 
     assertEquals(7, StringUtils.getLevenshteinDistance("hippo", "elephant", 7)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("hippo", "elephant", 6)); 
     assertEquals(8, StringUtils.getLevenshteinDistance("hippo", "zzzzzzzz", 8)); 
     assertEquals(8, StringUtils.getLevenshteinDistance("zzzzzzzz", "hippo", 8)); 
     assertEquals(1, StringUtils.getLevenshteinDistance("hello", "hallo", 1)); 
     try { 
         @SuppressWarnings("unused") 
         final int d = StringUtils.getLevenshteinDistance("a", null, 0); 
         fail("expecting IllegalArgumentException"); 
     } catch (final IllegalArgumentException ex) { 
     } 
     try { 
         @SuppressWarnings("unused") 
         final int d = StringUtils.getLevenshteinDistance(null, "a", 0); 
         fail("expecting IllegalArgumentException"); 
     } catch (final IllegalArgumentException ex) { 
     } 
     try { 
         @SuppressWarnings("unused") 
         final int d = StringUtils.getLevenshteinDistance("a", "a", -1); 
         fail("expecting IllegalArgumentException"); 
     } catch (final IllegalArgumentException ex) { 
     } 
 }
@Test
public void testAbbreviateMiddle1580() { 
     assertNull(StringUtils.abbreviateMiddle(null, null, 0)); 
     assertEquals("abc", StringUtils.abbreviateMiddle("abc", null, 0)); 
     assertEquals("abc", StringUtils.abbreviateMiddle("abc", ".", 0)); 
     assertEquals("abc", StringUtils.abbreviateMiddle("abc", ".", 3)); 
     assertEquals("ab.f", StringUtils.abbreviateMiddle("abcdef", ".", 4)); 
     assertEquals("A very long text with un...f the text is complete.", StringUtils.abbreviateMiddle("A very long text with unimportant stuff in the middle but interesting start and " + "end to see if the text is complete.", "...", 50)); 
     final String longText = "Start text" + StringUtils.repeat("x", 10000) + "Close text"; 
     assertEquals("Start text->Close text", StringUtils.abbreviateMiddle(longText, "->", 22)); 
     assertEquals("abc", StringUtils.abbreviateMiddle("abc", ".", -1)); 
     assertEquals("abc", StringUtils.abbreviateMiddle("abc", ".", 1)); 
     assertEquals("abc", StringUtils.abbreviateMiddle("abc", ".", 2)); 
     assertEquals("a", StringUtils.abbreviateMiddle("a", ".", 1)); 
     assertEquals("a.d", StringUtils.abbreviateMiddle("abcd", ".", 3)); 
     assertEquals("a..f", StringUtils.abbreviateMiddle("abcdef", "..", 4)); 
     assertEquals("ab.ef", StringUtils.abbreviateMiddle("abcdef", ".", 5)); 
 }
@Test
public void testGetCommonPrefix_StringArray1588() { 
     assertEquals("", StringUtils.getCommonPrefix((String[]) null)); 
     assertEquals("", StringUtils.getCommonPrefix()); 
     assertEquals("abc", StringUtils.getCommonPrefix("abc")); 
     assertEquals("", StringUtils.getCommonPrefix(null, null)); 
     assertEquals("", StringUtils.getCommonPrefix("", "")); 
     assertEquals("", StringUtils.getCommonPrefix("", null)); 
     assertEquals("", StringUtils.getCommonPrefix("abc", null, null)); 
     assertEquals("", StringUtils.getCommonPrefix(null, null, "abc")); 
     assertEquals("", StringUtils.getCommonPrefix("", "abc")); 
     assertEquals("", StringUtils.getCommonPrefix("abc", "")); 
     assertEquals("abc", StringUtils.getCommonPrefix("abc", "abc")); 
     assertEquals("a", StringUtils.getCommonPrefix("abc", "a")); 
     assertEquals("ab", StringUtils.getCommonPrefix("ab", "abxyz")); 
     assertEquals("ab", StringUtils.getCommonPrefix("abcde", "abxyz")); 
     assertEquals("", StringUtils.getCommonPrefix("abcde", "xyz")); 
     assertEquals("", StringUtils.getCommonPrefix("xyz", "abcde")); 
     assertEquals("i am a ", StringUtils.getCommonPrefix("i am a machine", "i am a robot")); 
 }
@Test
public void testSwapCase_String1617() { 
     assertEquals(null, StringUtils.swapCase(null)); 
     assertEquals("", StringUtils.swapCase("")); 
     assertEquals("  ", StringUtils.swapCase("  ")); 
     assertEquals("i", WordUtils.swapCase("I")); 
     assertEquals("I", WordUtils.swapCase("i")); 
     assertEquals("I AM HERE 123", StringUtils.swapCase("i am here 123")); 
     assertEquals("i aM hERE 123", StringUtils.swapCase("I Am Here 123")); 
     assertEquals("I AM here 123", StringUtils.swapCase("i am HERE 123")); 
     assertEquals("i am here 123", StringUtils.swapCase("I AM HERE 123")); 
     final String test = "This String contains a TitleCase character: \u01C8"; 
     final String expect = "tHIS sTRING CONTAINS A tITLEcASE CHARACTER: \u01C9"; 
     assertEquals(expect, WordUtils.swapCase(test)); 
 }
@Test
public void testReplace_StringStringArrayStringArray1621() { 
     assertNull(StringUtils.replaceEach(null, new String[] { "a" }, new String[] { "b" })); 
     assertEquals(StringUtils.replaceEach("", new String[] { "a" }, new String[] { "b" }), ""); 
     assertEquals(StringUtils.replaceEach("aba", null, null), "aba"); 
     assertEquals(StringUtils.replaceEach("aba", new String[0], null), "aba"); 
     assertEquals(StringUtils.replaceEach("aba", null, new String[0]), "aba"); 
     assertEquals(StringUtils.replaceEach("aba", new String[] { "a" }, null), "aba"); 
     assertEquals(StringUtils.replaceEach("aba", new String[] { "a" }, new String[] { "" }), "b"); 
     assertEquals(StringUtils.replaceEach("aba", new String[] { null }, new String[] { "a" }), "aba"); 
     assertEquals(StringUtils.replaceEach("abcde", new String[] { "ab", "d" }, new String[] { "w", "t" }), "wcte"); 
     assertEquals(StringUtils.replaceEach("abcde", new String[] { "ab", "d" }, new String[] { "d", "t" }), "dcte"); 
     assertEquals("bcc", StringUtils.replaceEach("abc", new String[] { "a", "b" }, new String[] { "b", "c" })); 
     assertEquals("q651.506bera", StringUtils.replaceEach("d216.102oren", new String[] { "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "1", "2", "3", "4", "5", "6", "7", "8", "9" }, new String[] { "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z", "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "5", "6", "7", "8", "9", "1", "2", "3", "4" })); 
     assertEquals(StringUtils.replaceEach("aba", new String[] { "a" }, new String[] { null }), "aba"); 
     assertEquals(StringUtils.replaceEach("aba", new String[] { "a", "b" }, new String[] { "c", null }), "cbc"); 
 }
@Test
public void testAbbreviateMiddle1628() { 
     assertNull(StringUtils.abbreviateMiddle(null, null, 0)); 
     assertEquals("abc", StringUtils.abbreviateMiddle("abc", null, 0)); 
     assertEquals("abc", StringUtils.abbreviateMiddle("abc", ".", 0)); 
     assertEquals("abc", StringUtils.abbreviateMiddle("abc", ".", 3)); 
     assertEquals("ab.f", StringUtils.abbreviateMiddle("abcdef", ".", 4)); 
     assertEquals("A very long text with un...f the text is complete.", StringUtils.abbreviateMiddle("A very long text with unimportant stuff in the middle but interesting start and " + "end to see if the text is complete.", "...", 50)); 
     final String longText = "Start text" + StringUtils.repeat("x", 10000) + "Close text"; 
     assertEquals("Start text->Close text", StringUtils.abbreviateMiddle(longText, "->", 22)); 
     assertEquals("abc", StringUtils.abbreviateMiddle("abc", ".", -1)); 
     assertEquals("abc", StringUtils.abbreviateMiddle("abc", ".", 1)); 
     assertEquals("abc", StringUtils.abbreviateMiddle("abc", ".", 2)); 
     assertEquals("a", StringUtils.abbreviateMiddle("a", ".", 1)); 
     assertEquals("a.d", StringUtils.abbreviateMiddle("abcd", ".", 3)); 
     assertEquals("a..f", StringUtils.abbreviateMiddle("abcdef", "..", 4)); 
     assertEquals("ab.ef", StringUtils.abbreviateMiddle("abcdef", ".", 5)); 
 }
@Test
public void testNormalizeSpace1637() { 
     assertEquals(null, StringUtils.normalizeSpace(null)); 
     assertEquals("", StringUtils.normalizeSpace("")); 
     assertEquals("", StringUtils.normalizeSpace(" ")); 
     assertEquals("", StringUtils.normalizeSpace("\t")); 
     assertEquals("", StringUtils.normalizeSpace("\n")); 
     assertEquals("", StringUtils.normalizeSpace("\u0009")); 
     assertEquals("", StringUtils.normalizeSpace("\u000B")); 
     assertEquals("", StringUtils.normalizeSpace("\u000C")); 
     assertEquals("", StringUtils.normalizeSpace("\u001C")); 
     assertEquals("", StringUtils.normalizeSpace("\u001D")); 
     assertEquals("", StringUtils.normalizeSpace("\u001E")); 
     assertEquals("", StringUtils.normalizeSpace("\u001F")); 
     assertEquals("", StringUtils.normalizeSpace("\f")); 
     assertEquals("", StringUtils.normalizeSpace("\r")); 
     assertEquals("a", StringUtils.normalizeSpace("  a  ")); 
     assertEquals("a b c", StringUtils.normalizeSpace("  a  b   c  ")); 
     assertEquals("a b c", StringUtils.normalizeSpace("a\t\f\r  b\u000B   c\n")); 
 }
@Test
public void testRepeat_StringInt1659() { 
     assertEquals(null, StringUtils.repeat(null, 2)); 
     assertEquals("", StringUtils.repeat("ab", 0)); 
     assertEquals("", StringUtils.repeat("", 3)); 
     assertEquals("aaa", StringUtils.repeat("a", 3)); 
     assertEquals("ababab", StringUtils.repeat("ab", 3)); 
     assertEquals("abcabcabc", StringUtils.repeat("abc", 3)); 
     final String str = StringUtils.repeat("a", 10000); 
     assertEquals(10000, str.length()); 
     assertTrue(StringUtils.containsOnly(str, new char[] { 'a' })); 
 }
@Test
public void testJoin_ArrayCharSeparator1667() { 
     assertEquals(null, StringUtils.join((Object[]) null, ',')); 
     assertEquals(TEXT_LIST_CHAR, StringUtils.join(ARRAY_LIST, SEPARATOR_CHAR)); 
     assertEquals("", StringUtils.join(EMPTY_ARRAY_LIST, SEPARATOR_CHAR)); 
     assertEquals(";;foo", StringUtils.join(MIXED_ARRAY_LIST, SEPARATOR_CHAR)); 
     assertEquals("foo;2", StringUtils.join(MIXED_TYPE_LIST, SEPARATOR_CHAR)); 
     assertEquals("/", StringUtils.join(MIXED_ARRAY_LIST, '/', 0, MIXED_ARRAY_LIST.length - 1)); 
     assertEquals("foo", StringUtils.join(MIXED_TYPE_LIST, '/', 0, 1)); 
     assertEquals("null", StringUtils.join(NULL_TO_STRING_LIST, '/', 0, 1)); 
     assertEquals("foo/2", StringUtils.join(MIXED_TYPE_LIST, '/', 0, 2)); 
     assertEquals("2", StringUtils.join(MIXED_TYPE_LIST, '/', 1, 2)); 
     assertEquals("", StringUtils.join(MIXED_TYPE_LIST, '/', 2, 1)); 
 }
@Test
public void testDifference_StringString1674() { 
     assertEquals(null, StringUtils.difference(null, null)); 
     assertEquals("", StringUtils.difference("", "")); 
     assertEquals("abc", StringUtils.difference("", "abc")); 
     assertEquals("", StringUtils.difference("abc", "")); 
     assertEquals("i am a robot", StringUtils.difference(null, "i am a robot")); 
     assertEquals("i am a machine", StringUtils.difference("i am a machine", null)); 
     assertEquals("robot", StringUtils.difference("i am a machine", "i am a robot")); 
     assertEquals("", StringUtils.difference("abc", "abc")); 
     assertEquals("you are a robot", StringUtils.difference("i am a robot", "you are a robot")); 
 }
@Test
public void testGetCommonPrefix_StringArray1676() { 
     assertEquals("", StringUtils.getCommonPrefix((String[]) null)); 
     assertEquals("", StringUtils.getCommonPrefix()); 
     assertEquals("abc", StringUtils.getCommonPrefix("abc")); 
     assertEquals("", StringUtils.getCommonPrefix(null, null)); 
     assertEquals("", StringUtils.getCommonPrefix("", "")); 
     assertEquals("", StringUtils.getCommonPrefix("", null)); 
     assertEquals("", StringUtils.getCommonPrefix("abc", null, null)); 
     assertEquals("", StringUtils.getCommonPrefix(null, null, "abc")); 
     assertEquals("", StringUtils.getCommonPrefix("", "abc")); 
     assertEquals("", StringUtils.getCommonPrefix("abc", "")); 
     assertEquals("abc", StringUtils.getCommonPrefix("abc", "abc")); 
     assertEquals("a", StringUtils.getCommonPrefix("abc", "a")); 
     assertEquals("ab", StringUtils.getCommonPrefix("ab", "abxyz")); 
     assertEquals("ab", StringUtils.getCommonPrefix("abcde", "abxyz")); 
     assertEquals("", StringUtils.getCommonPrefix("abcde", "xyz")); 
     assertEquals("", StringUtils.getCommonPrefix("xyz", "abcde")); 
     assertEquals("i am a ", StringUtils.getCommonPrefix("i am a machine", "i am a robot")); 
 }
@Test
public void testSwapCase_String1693() { 
     assertEquals(null, StringUtils.swapCase(null)); 
     assertEquals("", StringUtils.swapCase("")); 
     assertEquals("  ", StringUtils.swapCase("  ")); 
     assertEquals("i", WordUtils.swapCase("I")); 
     assertEquals("I", WordUtils.swapCase("i")); 
     assertEquals("I AM HERE 123", StringUtils.swapCase("i am here 123")); 
     assertEquals("i aM hERE 123", StringUtils.swapCase("I Am Here 123")); 
     assertEquals("I AM here 123", StringUtils.swapCase("i am HERE 123")); 
     assertEquals("i am here 123", StringUtils.swapCase("I AM HERE 123")); 
     final String test = "This String contains a TitleCase character: \u01C8"; 
     final String expect = "tHIS sTRING CONTAINS A tITLEcASE CHARACTER: \u01C9"; 
     assertEquals(expect, WordUtils.swapCase(test)); 
 }
@Test
public void testGetLevenshteinDistance_StringStringInt1695() { 
     assertEquals(0, StringUtils.getLevenshteinDistance("", "", 0)); 
     assertEquals(7, StringUtils.getLevenshteinDistance("aaapppp", "", 8)); 
     assertEquals(7, StringUtils.getLevenshteinDistance("aaapppp", "", 7)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("aaapppp", "", 6)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("b", "a", 0)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("a", "b", 0)); 
     assertEquals(0, StringUtils.getLevenshteinDistance("aa", "aa", 0)); 
     assertEquals(0, StringUtils.getLevenshteinDistance("aa", "aa", 2)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("aaa", "bbb", 2)); 
     assertEquals(3, StringUtils.getLevenshteinDistance("aaa", "bbb", 3)); 
     assertEquals(6, StringUtils.getLevenshteinDistance("aaaaaa", "b", 10)); 
     assertEquals(7, StringUtils.getLevenshteinDistance("aaapppp", "b", 8)); 
     assertEquals(3, StringUtils.getLevenshteinDistance("a", "bbb", 4)); 
     assertEquals(7, StringUtils.getLevenshteinDistance("aaapppp", "b", 7)); 
     assertEquals(3, StringUtils.getLevenshteinDistance("a", "bbb", 3)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("a", "bbb", 2)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("bbb", "a", 2)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("aaapppp", "b", 6)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("a", "bbb", 1)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("bbb", "a", 1)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("12345", "1234567", 1)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("1234567", "12345", 1)); 
     assertEquals(1, StringUtils.getLevenshteinDistance("frog", "fog", 1)); 
     assertEquals(3, StringUtils.getLevenshteinDistance("fly", "ant", 3)); 
     assertEquals(7, StringUtils.getLevenshteinDistance("elephant", "hippo", 7)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("elephant", "hippo", 6)); 
     assertEquals(7, StringUtils.getLevenshteinDistance("hippo", "elephant", 7)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("hippo", "elephant", 6)); 
     assertEquals(8, StringUtils.getLevenshteinDistance("hippo", "zzzzzzzz", 8)); 
     assertEquals(8, StringUtils.getLevenshteinDistance("zzzzzzzz", "hippo", 8)); 
     assertEquals(1, StringUtils.getLevenshteinDistance("hello", "hallo", 1)); 
     try { 
         @SuppressWarnings("unused") 
         final int d = StringUtils.getLevenshteinDistance("a", null, 0); 
         fail("expecting IllegalArgumentException"); 
     } catch (final IllegalArgumentException ex) { 
     } 
     try { 
         @SuppressWarnings("unused") 
         final int d = StringUtils.getLevenshteinDistance(null, "a", 0); 
         fail("expecting IllegalArgumentException"); 
     } catch (final IllegalArgumentException ex) { 
     } 
     try { 
         @SuppressWarnings("unused") 
         final int d = StringUtils.getLevenshteinDistance("a", "a", -1); 
         fail("expecting IllegalArgumentException"); 
     } catch (final IllegalArgumentException ex) { 
     } 
 }
@Test
public void testEscapeSurrogatePairsLang8581700() throws Exception { 
     assertEquals("\\uDBFF\\uDFFD", StringEscapeUtils.escapeJava("\uDBFF\uDFFD")); 
     assertEquals("\\uDBFF\\uDFFD", StringEscapeUtils.escapeEcmaScript("\uDBFF\uDFFD")); 
 }
@Test
public void testGetLevenshteinDistance_StringStringInt1736() { 
     assertEquals(0, StringUtils.getLevenshteinDistance("", "", 0)); 
     assertEquals(7, StringUtils.getLevenshteinDistance("aaapppp", "", 8)); 
     assertEquals(7, StringUtils.getLevenshteinDistance("aaapppp", "", 7)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("aaapppp", "", 6)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("b", "a", 0)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("a", "b", 0)); 
     assertEquals(0, StringUtils.getLevenshteinDistance("aa", "aa", 0)); 
     assertEquals(0, StringUtils.getLevenshteinDistance("aa", "aa", 2)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("aaa", "bbb", 2)); 
     assertEquals(3, StringUtils.getLevenshteinDistance("aaa", "bbb", 3)); 
     assertEquals(6, StringUtils.getLevenshteinDistance("aaaaaa", "b", 10)); 
     assertEquals(7, StringUtils.getLevenshteinDistance("aaapppp", "b", 8)); 
     assertEquals(3, StringUtils.getLevenshteinDistance("a", "bbb", 4)); 
     assertEquals(7, StringUtils.getLevenshteinDistance("aaapppp", "b", 7)); 
     assertEquals(3, StringUtils.getLevenshteinDistance("a", "bbb", 3)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("a", "bbb", 2)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("bbb", "a", 2)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("aaapppp", "b", 6)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("a", "bbb", 1)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("bbb", "a", 1)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("12345", "1234567", 1)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("1234567", "12345", 1)); 
     assertEquals(1, StringUtils.getLevenshteinDistance("frog", "fog", 1)); 
     assertEquals(3, StringUtils.getLevenshteinDistance("fly", "ant", 3)); 
     assertEquals(7, StringUtils.getLevenshteinDistance("elephant", "hippo", 7)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("elephant", "hippo", 6)); 
     assertEquals(7, StringUtils.getLevenshteinDistance("hippo", "elephant", 7)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("hippo", "elephant", 6)); 
     assertEquals(8, StringUtils.getLevenshteinDistance("hippo", "zzzzzzzz", 8)); 
     assertEquals(8, StringUtils.getLevenshteinDistance("zzzzzzzz", "hippo", 8)); 
     assertEquals(1, StringUtils.getLevenshteinDistance("hello", "hallo", 1)); 
     try { 
         @SuppressWarnings("unused") 
         final int d = StringUtils.getLevenshteinDistance("a", null, 0); 
         fail("expecting IllegalArgumentException"); 
     } catch (final IllegalArgumentException ex) { 
     } 
     try { 
         @SuppressWarnings("unused") 
         final int d = StringUtils.getLevenshteinDistance(null, "a", 0); 
         fail("expecting IllegalArgumentException"); 
     } catch (final IllegalArgumentException ex) { 
     } 
     try { 
         @SuppressWarnings("unused") 
         final int d = StringUtils.getLevenshteinDistance("a", "a", -1); 
         fail("expecting IllegalArgumentException"); 
     } catch (final IllegalArgumentException ex) { 
     } 
 }
@Test
public void testSplitByCharacterType1766() { 
     assertNull(StringUtils.splitByCharacterType(null)); 
     assertEquals(0, StringUtils.splitByCharacterType("").length); 
     assertTrue(ArrayUtils.isEquals(new String[] { "ab", " ", "de", " ", "fg" }, StringUtils.splitByCharacterType("ab de fg"))); 
     assertTrue(ArrayUtils.isEquals(new String[] { "ab", "   ", "de", " ", "fg" }, StringUtils.splitByCharacterType("ab   de fg"))); 
     assertTrue(ArrayUtils.isEquals(new String[] { "ab", ":", "cd", ":", "ef" }, StringUtils.splitByCharacterType("ab:cd:ef"))); 
     assertTrue(ArrayUtils.isEquals(new String[] { "number", "5" }, StringUtils.splitByCharacterType("number5"))); 
     assertTrue(ArrayUtils.isEquals(new String[] { "foo", "B", "ar" }, StringUtils.splitByCharacterType("fooBar"))); 
     assertTrue(ArrayUtils.isEquals(new String[] { "foo", "200", "B", "ar" }, StringUtils.splitByCharacterType("foo200Bar"))); 
     assertTrue(ArrayUtils.isEquals(new String[] { "ASFR", "ules" }, StringUtils.splitByCharacterType("ASFRules"))); 
 }
@Test
public void testJoin_ArrayOfLongs1771() { 
     assertEquals(null, StringUtils.join((long[]) null, ',')); 
     assertEquals("1;2", StringUtils.join(LONG_PRIM_LIST, SEPARATOR_CHAR)); 
     assertEquals("2", StringUtils.join(LONG_PRIM_LIST, SEPARATOR_CHAR, 1, 2)); 
 } 
@SuppressWarnings("deprecation")
@Test
public void testChomp1787() { 
     final String[][] chompCases = { { FOO_UNCAP + "\r\n", FOO_UNCAP }, { FOO_UNCAP + "\n", FOO_UNCAP }, { FOO_UNCAP + "\r", FOO_UNCAP }, { FOO_UNCAP + " \r", FOO_UNCAP + " " }, { FOO_UNCAP, FOO_UNCAP }, { FOO_UNCAP + "\n\n", FOO_UNCAP + "\n" }, { FOO_UNCAP + "\r\n\r\n", FOO_UNCAP + "\r\n" }, { "foo\nfoo", "foo\nfoo" }, { "foo\n\rfoo", "foo\n\rfoo" }, { "\n", "" }, { "\r", "" }, { "a", "a" }, { "\r\n", "" }, { "", "" }, { null, null }, { FOO_UNCAP + "\n\r", FOO_UNCAP + "\n" } }; 
     for (final String[] chompCase : chompCases) { 
         final String original = chompCase[0]; 
         final String expectedResult = chompCase[1]; 
         assertEquals("chomp(String) failed", expectedResult, StringUtils.chomp(original)); 
     } 
     assertEquals("chomp(String, String) failed", "foo", StringUtils.chomp("foobar", "bar")); 
     assertEquals("chomp(String, String) failed", "foobar", StringUtils.chomp("foobar", "baz")); 
     assertEquals("chomp(String, String) failed", "foo", StringUtils.chomp("foo", "foooo")); 
     assertEquals("chomp(String, String) failed", "foobar", StringUtils.chomp("foobar", "")); 
     assertEquals("chomp(String, String) failed", "foobar", StringUtils.chomp("foobar", null)); 
     assertEquals("chomp(String, String) failed", "", StringUtils.chomp("", "foo")); 
     assertEquals("chomp(String, String) failed", "", StringUtils.chomp("", null)); 
     assertEquals("chomp(String, String) failed", "", StringUtils.chomp("", "")); 
     assertEquals("chomp(String, String) failed", null, StringUtils.chomp(null, "foo")); 
     assertEquals("chomp(String, String) failed", null, StringUtils.chomp(null, null)); 
     assertEquals("chomp(String, String) failed", null, StringUtils.chomp(null, "")); 
     assertEquals("chomp(String, String) failed", "", StringUtils.chomp("foo", "foo")); 
     assertEquals("chomp(String, String) failed", " ", StringUtils.chomp(" foo", "foo")); 
     assertEquals("chomp(String, String) failed", "foo ", StringUtils.chomp("foo ", "foo")); 
 }
@Test
public void testReplace_StringStringArrayStringArray1793() { 
     assertNull(StringUtils.replaceEach(null, new String[] { "a" }, new String[] { "b" })); 
     assertEquals(StringUtils.replaceEach("", new String[] { "a" }, new String[] { "b" }), ""); 
     assertEquals(StringUtils.replaceEach("aba", null, null), "aba"); 
     assertEquals(StringUtils.replaceEach("aba", new String[0], null), "aba"); 
     assertEquals(StringUtils.replaceEach("aba", null, new String[0]), "aba"); 
     assertEquals(StringUtils.replaceEach("aba", new String[] { "a" }, null), "aba"); 
     assertEquals(StringUtils.replaceEach("aba", new String[] { "a" }, new String[] { "" }), "b"); 
     assertEquals(StringUtils.replaceEach("aba", new String[] { null }, new String[] { "a" }), "aba"); 
     assertEquals(StringUtils.replaceEach("abcde", new String[] { "ab", "d" }, new String[] { "w", "t" }), "wcte"); 
     assertEquals(StringUtils.replaceEach("abcde", new String[] { "ab", "d" }, new String[] { "d", "t" }), "dcte"); 
     assertEquals("bcc", StringUtils.replaceEach("abc", new String[] { "a", "b" }, new String[] { "b", "c" })); 
     assertEquals("q651.506bera", StringUtils.replaceEach("d216.102oren", new String[] { "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "1", "2", "3", "4", "5", "6", "7", "8", "9" }, new String[] { "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z", "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "5", "6", "7", "8", "9", "1", "2", "3", "4" })); 
     assertEquals(StringUtils.replaceEach("aba", new String[] { "a" }, new String[] { null }), "aba"); 
     assertEquals(StringUtils.replaceEach("aba", new String[] { "a", "b" }, new String[] { "c", null }), "cbc"); 
 }
@Test
public void testSplit_StringChar1794() { 
     assertArrayEquals(null, StringUtils.split(null, '.')); 
     assertEquals(0, StringUtils.split("", '.').length); 
     String str = "a.b.. c"; 
     String[] res = StringUtils.split(str, '.'); 
     assertEquals(3, res.length); 
     assertEquals("a", res[0]); 
     assertEquals("b", res[1]); 
     assertEquals(" c", res[2]); 
     str = ".a."; 
     res = StringUtils.split(str, '.'); 
     assertEquals(1, res.length); 
     assertEquals("a", res[0]); 
     str = "a b c"; 
     res = StringUtils.split(str, ' '); 
     assertEquals(3, res.length); 
     assertEquals("a", res[0]); 
     assertEquals("b", res[1]); 
     assertEquals("c", res[2]); 
 }
@Test
public void testRemoveEndIgnoreCase1798() { 
     assertNull("removeEndIgnoreCase(null, null)", StringUtils.removeEndIgnoreCase(null, null)); 
     assertNull("removeEndIgnoreCase(null, \"\")", StringUtils.removeEndIgnoreCase(null, "")); 
     assertNull("removeEndIgnoreCase(null, \"a\")", StringUtils.removeEndIgnoreCase(null, "a")); 
     assertEquals("removeEndIgnoreCase(\"\", null)", StringUtils.removeEndIgnoreCase("", null), ""); 
     assertEquals("removeEndIgnoreCase(\"\", \"\")", StringUtils.removeEndIgnoreCase("", ""), ""); 
     assertEquals("removeEndIgnoreCase(\"\", \"a\")", StringUtils.removeEndIgnoreCase("", "a"), ""); 
     assertEquals("removeEndIgnoreCase(\"www.domain.com.\", \".com\")", StringUtils.removeEndIgnoreCase("www.domain.com.", ".com"), "www.domain.com."); 
     assertEquals("removeEndIgnoreCase(\"www.domain.com\", \".com\")", StringUtils.removeEndIgnoreCase("www.domain.com", ".com"), "www.domain"); 
     assertEquals("removeEndIgnoreCase(\"www.domain\", \".com\")", StringUtils.removeEndIgnoreCase("www.domain", ".com"), "www.domain"); 
     assertEquals("removeEndIgnoreCase(\"domain.com\", \"\")", StringUtils.removeEndIgnoreCase("domain.com", ""), "domain.com"); 
     assertEquals("removeEndIgnoreCase(\"domain.com\", null)", StringUtils.removeEndIgnoreCase("domain.com", null), "domain.com"); 
     assertEquals("removeEndIgnoreCase(\"www.domain.com\", \".COM\")", StringUtils.removeEndIgnoreCase("www.domain.com", ".COM"), "www.domain"); 
     assertEquals("removeEndIgnoreCase(\"www.domain.COM\", \".com\")", StringUtils.removeEndIgnoreCase("www.domain.COM", ".com"), "www.domain"); 
 }
@Test
public void testSplit_String1814() { 
     assertArrayEquals(null, StringUtils.split(null)); 
     assertEquals(0, StringUtils.split("").length); 
     String str = "a b  .c"; 
     String[] res = StringUtils.split(str); 
     assertEquals(3, res.length); 
     assertEquals("a", res[0]); 
     assertEquals("b", res[1]); 
     assertEquals(".c", res[2]); 
     str = " a "; 
     res = StringUtils.split(str); 
     assertEquals(1, res.length); 
     assertEquals("a", res[0]); 
     str = "a" + WHITESPACE + "b" + NON_WHITESPACE + "c"; 
     res = StringUtils.split(str); 
     assertEquals(2, res.length); 
     assertEquals("a", res[0]); 
     assertEquals("b" + NON_WHITESPACE + "c", res[1]); 
 }
@Test
public void testRemoveEndIgnoreCase1841() { 
     assertNull("removeEndIgnoreCase(null, null)", StringUtils.removeEndIgnoreCase(null, null)); 
     assertNull("removeEndIgnoreCase(null, \"\")", StringUtils.removeEndIgnoreCase(null, "")); 
     assertNull("removeEndIgnoreCase(null, \"a\")", StringUtils.removeEndIgnoreCase(null, "a")); 
     assertEquals("removeEndIgnoreCase(\"\", null)", StringUtils.removeEndIgnoreCase("", null), ""); 
     assertEquals("removeEndIgnoreCase(\"\", \"\")", StringUtils.removeEndIgnoreCase("", ""), ""); 
     assertEquals("removeEndIgnoreCase(\"\", \"a\")", StringUtils.removeEndIgnoreCase("", "a"), ""); 
     assertEquals("removeEndIgnoreCase(\"www.domain.com.\", \".com\")", StringUtils.removeEndIgnoreCase("www.domain.com.", ".com"), "www.domain.com."); 
     assertEquals("removeEndIgnoreCase(\"www.domain.com\", \".com\")", StringUtils.removeEndIgnoreCase("www.domain.com", ".com"), "www.domain"); 
     assertEquals("removeEndIgnoreCase(\"www.domain\", \".com\")", StringUtils.removeEndIgnoreCase("www.domain", ".com"), "www.domain"); 
     assertEquals("removeEndIgnoreCase(\"domain.com\", \"\")", StringUtils.removeEndIgnoreCase("domain.com", ""), "domain.com"); 
     assertEquals("removeEndIgnoreCase(\"domain.com\", null)", StringUtils.removeEndIgnoreCase("domain.com", null), "domain.com"); 
     assertEquals("removeEndIgnoreCase(\"www.domain.com\", \".COM\")", StringUtils.removeEndIgnoreCase("www.domain.com", ".COM"), "www.domain"); 
     assertEquals("removeEndIgnoreCase(\"www.domain.COM\", \".com\")", StringUtils.removeEndIgnoreCase("www.domain.COM", ".com"), "www.domain"); 
 }
@Test
public void testDeleteWhitespace_String1858() { 
     assertEquals(null, StringUtils.deleteWhitespace(null)); 
     assertEquals("", StringUtils.deleteWhitespace("")); 
     assertEquals("", StringUtils.deleteWhitespace("  \u000C  \t\t\u001F\n\n \u000B  ")); 
     assertEquals("", StringUtils.deleteWhitespace(StringUtilsTest.WHITESPACE)); 
     assertEquals(StringUtilsTest.NON_WHITESPACE, StringUtils.deleteWhitespace(StringUtilsTest.NON_WHITESPACE)); 
     assertEquals("\u00A0\u202F", StringUtils.deleteWhitespace("  \u00A0  \t\t\n\n \u202F  ")); 
     assertEquals("\u00A0\u202F", StringUtils.deleteWhitespace("\u00A0\u202F")); 
     assertEquals("test", StringUtils.deleteWhitespace("\u000Bt  \t\n\u0009e\rs\n\n   \tt")); 
 }
@Test
public void testGetCommonPrefix_StringArray1866() { 
     assertEquals("", StringUtils.getCommonPrefix((String[]) null)); 
     assertEquals("", StringUtils.getCommonPrefix()); 
     assertEquals("abc", StringUtils.getCommonPrefix("abc")); 
     assertEquals("", StringUtils.getCommonPrefix(null, null)); 
     assertEquals("", StringUtils.getCommonPrefix("", "")); 
     assertEquals("", StringUtils.getCommonPrefix("", null)); 
     assertEquals("", StringUtils.getCommonPrefix("abc", null, null)); 
     assertEquals("", StringUtils.getCommonPrefix(null, null, "abc")); 
     assertEquals("", StringUtils.getCommonPrefix("", "abc")); 
     assertEquals("", StringUtils.getCommonPrefix("abc", "")); 
     assertEquals("abc", StringUtils.getCommonPrefix("abc", "abc")); 
     assertEquals("a", StringUtils.getCommonPrefix("abc", "a")); 
     assertEquals("ab", StringUtils.getCommonPrefix("ab", "abxyz")); 
     assertEquals("ab", StringUtils.getCommonPrefix("abcde", "abxyz")); 
     assertEquals("", StringUtils.getCommonPrefix("abcde", "xyz")); 
     assertEquals("", StringUtils.getCommonPrefix("xyz", "abcde")); 
     assertEquals("i am a ", StringUtils.getCommonPrefix("i am a machine", "i am a robot")); 
 }
@Test
public void testGetLevenshteinDistance_StringStringInt1876() { 
     assertEquals(0, StringUtils.getLevenshteinDistance("", "", 0)); 
     assertEquals(7, StringUtils.getLevenshteinDistance("aaapppp", "", 8)); 
     assertEquals(7, StringUtils.getLevenshteinDistance("aaapppp", "", 7)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("aaapppp", "", 6)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("b", "a", 0)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("a", "b", 0)); 
     assertEquals(0, StringUtils.getLevenshteinDistance("aa", "aa", 0)); 
     assertEquals(0, StringUtils.getLevenshteinDistance("aa", "aa", 2)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("aaa", "bbb", 2)); 
     assertEquals(3, StringUtils.getLevenshteinDistance("aaa", "bbb", 3)); 
     assertEquals(6, StringUtils.getLevenshteinDistance("aaaaaa", "b", 10)); 
     assertEquals(7, StringUtils.getLevenshteinDistance("aaapppp", "b", 8)); 
     assertEquals(3, StringUtils.getLevenshteinDistance("a", "bbb", 4)); 
     assertEquals(7, StringUtils.getLevenshteinDistance("aaapppp", "b", 7)); 
     assertEquals(3, StringUtils.getLevenshteinDistance("a", "bbb", 3)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("a", "bbb", 2)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("bbb", "a", 2)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("aaapppp", "b", 6)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("a", "bbb", 1)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("bbb", "a", 1)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("12345", "1234567", 1)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("1234567", "12345", 1)); 
     assertEquals(1, StringUtils.getLevenshteinDistance("frog", "fog", 1)); 
     assertEquals(3, StringUtils.getLevenshteinDistance("fly", "ant", 3)); 
     assertEquals(7, StringUtils.getLevenshteinDistance("elephant", "hippo", 7)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("elephant", "hippo", 6)); 
     assertEquals(7, StringUtils.getLevenshteinDistance("hippo", "elephant", 7)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("hippo", "elephant", 6)); 
     assertEquals(8, StringUtils.getLevenshteinDistance("hippo", "zzzzzzzz", 8)); 
     assertEquals(8, StringUtils.getLevenshteinDistance("zzzzzzzz", "hippo", 8)); 
     assertEquals(1, StringUtils.getLevenshteinDistance("hello", "hallo", 1)); 
     try { 
         @SuppressWarnings("unused") 
         final int d = StringUtils.getLevenshteinDistance("a", null, 0); 
         fail("expecting IllegalArgumentException"); 
     } catch (final IllegalArgumentException ex) { 
     } 
     try { 
         @SuppressWarnings("unused") 
         final int d = StringUtils.getLevenshteinDistance(null, "a", 0); 
         fail("expecting IllegalArgumentException"); 
     } catch (final IllegalArgumentException ex) { 
     } 
     try { 
         @SuppressWarnings("unused") 
         final int d = StringUtils.getLevenshteinDistance("a", "a", -1); 
         fail("expecting IllegalArgumentException"); 
     } catch (final IllegalArgumentException ex) { 
     } 
 }
@Test
public void testEscapeSurrogatePairs1899() throws Exception { 
     assertEquals("\uD83D\uDE30", StringEscapeUtils.escapeCsv("\uD83D\uDE30")); 
     assertEquals("\uD800\uDC00", StringEscapeUtils.escapeCsv("\uD800\uDC00")); 
     assertEquals("\uD834\uDD1E", StringEscapeUtils.escapeCsv("\uD834\uDD1E")); 
     assertEquals("\uDBFF\uDFFD", StringEscapeUtils.escapeCsv("\uDBFF\uDFFD")); 
     assertEquals("\uDBFF\uDFFD", StringEscapeUtils.escapeHtml3("\uDBFF\uDFFD")); 
     assertEquals("\uDBFF\uDFFD", StringEscapeUtils.escapeHtml4("\uDBFF\uDFFD")); 
     assertEquals("\uDBFF\uDFFD", StringEscapeUtils.escapeXml("\uDBFF\uDFFD")); 
 }
@Test
public void testGetLevenshteinDistance_StringStringInt1904() { 
     assertEquals(0, StringUtils.getLevenshteinDistance("", "", 0)); 
     assertEquals(7, StringUtils.getLevenshteinDistance("aaapppp", "", 8)); 
     assertEquals(7, StringUtils.getLevenshteinDistance("aaapppp", "", 7)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("aaapppp", "", 6)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("b", "a", 0)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("a", "b", 0)); 
     assertEquals(0, StringUtils.getLevenshteinDistance("aa", "aa", 0)); 
     assertEquals(0, StringUtils.getLevenshteinDistance("aa", "aa", 2)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("aaa", "bbb", 2)); 
     assertEquals(3, StringUtils.getLevenshteinDistance("aaa", "bbb", 3)); 
     assertEquals(6, StringUtils.getLevenshteinDistance("aaaaaa", "b", 10)); 
     assertEquals(7, StringUtils.getLevenshteinDistance("aaapppp", "b", 8)); 
     assertEquals(3, StringUtils.getLevenshteinDistance("a", "bbb", 4)); 
     assertEquals(7, StringUtils.getLevenshteinDistance("aaapppp", "b", 7)); 
     assertEquals(3, StringUtils.getLevenshteinDistance("a", "bbb", 3)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("a", "bbb", 2)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("bbb", "a", 2)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("aaapppp", "b", 6)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("a", "bbb", 1)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("bbb", "a", 1)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("12345", "1234567", 1)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("1234567", "12345", 1)); 
     assertEquals(1, StringUtils.getLevenshteinDistance("frog", "fog", 1)); 
     assertEquals(3, StringUtils.getLevenshteinDistance("fly", "ant", 3)); 
     assertEquals(7, StringUtils.getLevenshteinDistance("elephant", "hippo", 7)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("elephant", "hippo", 6)); 
     assertEquals(7, StringUtils.getLevenshteinDistance("hippo", "elephant", 7)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("hippo", "elephant", 6)); 
     assertEquals(8, StringUtils.getLevenshteinDistance("hippo", "zzzzzzzz", 8)); 
     assertEquals(8, StringUtils.getLevenshteinDistance("zzzzzzzz", "hippo", 8)); 
     assertEquals(1, StringUtils.getLevenshteinDistance("hello", "hallo", 1)); 
     try { 
         @SuppressWarnings("unused") 
         final int d = StringUtils.getLevenshteinDistance("a", null, 0); 
         fail("expecting IllegalArgumentException"); 
     } catch (final IllegalArgumentException ex) { 
     } 
     try { 
         @SuppressWarnings("unused") 
         final int d = StringUtils.getLevenshteinDistance(null, "a", 0); 
         fail("expecting IllegalArgumentException"); 
     } catch (final IllegalArgumentException ex) { 
     } 
     try { 
         @SuppressWarnings("unused") 
         final int d = StringUtils.getLevenshteinDistance("a", "a", -1); 
         fail("expecting IllegalArgumentException"); 
     } catch (final IllegalArgumentException ex) { 
     } 
 }
@Test
public void testEscapeSurrogatePairsLang8581914() throws Exception { 
     assertEquals("\\uDBFF\\uDFFD", StringEscapeUtils.escapeJava("\uDBFF\uDFFD")); 
     assertEquals("\\uDBFF\\uDFFD", StringEscapeUtils.escapeEcmaScript("\uDBFF\uDFFD")); 
 }
@Test
public void testRemoveEndIgnoreCase1945() { 
     assertNull("removeEndIgnoreCase(null, null)", StringUtils.removeEndIgnoreCase(null, null)); 
     assertNull("removeEndIgnoreCase(null, \"\")", StringUtils.removeEndIgnoreCase(null, "")); 
     assertNull("removeEndIgnoreCase(null, \"a\")", StringUtils.removeEndIgnoreCase(null, "a")); 
     assertEquals("removeEndIgnoreCase(\"\", null)", StringUtils.removeEndIgnoreCase("", null), ""); 
     assertEquals("removeEndIgnoreCase(\"\", \"\")", StringUtils.removeEndIgnoreCase("", ""), ""); 
     assertEquals("removeEndIgnoreCase(\"\", \"a\")", StringUtils.removeEndIgnoreCase("", "a"), ""); 
     assertEquals("removeEndIgnoreCase(\"www.domain.com.\", \".com\")", StringUtils.removeEndIgnoreCase("www.domain.com.", ".com"), "www.domain.com."); 
     assertEquals("removeEndIgnoreCase(\"www.domain.com\", \".com\")", StringUtils.removeEndIgnoreCase("www.domain.com", ".com"), "www.domain"); 
     assertEquals("removeEndIgnoreCase(\"www.domain\", \".com\")", StringUtils.removeEndIgnoreCase("www.domain", ".com"), "www.domain"); 
     assertEquals("removeEndIgnoreCase(\"domain.com\", \"\")", StringUtils.removeEndIgnoreCase("domain.com", ""), "domain.com"); 
     assertEquals("removeEndIgnoreCase(\"domain.com\", null)", StringUtils.removeEndIgnoreCase("domain.com", null), "domain.com"); 
     assertEquals("removeEndIgnoreCase(\"www.domain.com\", \".COM\")", StringUtils.removeEndIgnoreCase("www.domain.com", ".COM"), "www.domain"); 
     assertEquals("removeEndIgnoreCase(\"www.domain.COM\", \".com\")", StringUtils.removeEndIgnoreCase("www.domain.COM", ".com"), "www.domain"); 
 }
@Test
public void testSplitByCharacterType1965() { 
     assertNull(StringUtils.splitByCharacterType(null)); 
     assertEquals(0, StringUtils.splitByCharacterType("").length); 
     assertTrue(ArrayUtils.isEquals(new String[] { "ab", " ", "de", " ", "fg" }, StringUtils.splitByCharacterType("ab de fg"))); 
     assertTrue(ArrayUtils.isEquals(new String[] { "ab", "   ", "de", " ", "fg" }, StringUtils.splitByCharacterType("ab   de fg"))); 
     assertTrue(ArrayUtils.isEquals(new String[] { "ab", ":", "cd", ":", "ef" }, StringUtils.splitByCharacterType("ab:cd:ef"))); 
     assertTrue(ArrayUtils.isEquals(new String[] { "number", "5" }, StringUtils.splitByCharacterType("number5"))); 
     assertTrue(ArrayUtils.isEquals(new String[] { "foo", "B", "ar" }, StringUtils.splitByCharacterType("fooBar"))); 
     assertTrue(ArrayUtils.isEquals(new String[] { "foo", "200", "B", "ar" }, StringUtils.splitByCharacterType("foo200Bar"))); 
     assertTrue(ArrayUtils.isEquals(new String[] { "ASFR", "ules" }, StringUtils.splitByCharacterType("ASFRules"))); 
 }
@Test
public void testAbbreviate_StringIntInt1966() { 
     assertEquals(null, StringUtils.abbreviate(null, 10, 12)); 
     assertEquals("", StringUtils.abbreviate("", 0, 10)); 
     assertEquals("", StringUtils.abbreviate("", 2, 10)); 
     try { 
         @SuppressWarnings("unused") 
         final String res = StringUtils.abbreviate("abcdefghij", 0, 3); 
         fail("StringUtils.abbreviate expecting IllegalArgumentException"); 
     } catch (final IllegalArgumentException ex) { 
     } 
     try { 
         @SuppressWarnings("unused") 
         final String res = StringUtils.abbreviate("abcdefghij", 5, 6); 
         fail("StringUtils.abbreviate expecting IllegalArgumentException"); 
     } catch (final IllegalArgumentException ex) { 
     } 
     final String raspberry = "raspberry peach"; 
     assertEquals("raspberry peach", StringUtils.abbreviate(raspberry, 11, 15)); 
     assertEquals(null, StringUtils.abbreviate(null, 7, 14)); 
     assertAbbreviateWithOffset("abcdefg...", -1, 10); 
     assertAbbreviateWithOffset("abcdefg...", 0, 10); 
     assertAbbreviateWithOffset("abcdefg...", 1, 10); 
     assertAbbreviateWithOffset("abcdefg...", 2, 10); 
     assertAbbreviateWithOffset("abcdefg...", 3, 10); 
     assertAbbreviateWithOffset("abcdefg...", 4, 10); 
     assertAbbreviateWithOffset("...fghi...", 5, 10); 
     assertAbbreviateWithOffset("...ghij...", 6, 10); 
     assertAbbreviateWithOffset("...hijk...", 7, 10); 
     assertAbbreviateWithOffset("...ijklmno", 8, 10); 
     assertAbbreviateWithOffset("...ijklmno", 9, 10); 
     assertAbbreviateWithOffset("...ijklmno", 10, 10); 
     assertAbbreviateWithOffset("...ijklmno", 10, 10); 
     assertAbbreviateWithOffset("...ijklmno", 11, 10); 
     assertAbbreviateWithOffset("...ijklmno", 12, 10); 
     assertAbbreviateWithOffset("...ijklmno", 13, 10); 
     assertAbbreviateWithOffset("...ijklmno", 14, 10); 
     assertAbbreviateWithOffset("...ijklmno", 15, 10); 
     assertAbbreviateWithOffset("...ijklmno", 16, 10); 
     assertAbbreviateWithOffset("...ijklmno", Integer.MAX_VALUE, 10); 
 }
@Test
public void testJoin_ArrayOfFloats1996() { 
     assertEquals(null, StringUtils.join((float[]) null, ',')); 
     assertEquals("1.0;2.0", StringUtils.join(FLOAT_PRIM_LIST, SEPARATOR_CHAR)); 
     assertEquals("2.0", StringUtils.join(FLOAT_PRIM_LIST, SEPARATOR_CHAR, 1, 2)); 
 }
@Test
public void testEscapeSurrogatePairsLang8582007() throws Exception { 
     assertEquals("\\uDBFF\\uDFFD", StringEscapeUtils.escapeJava("\uDBFF\uDFFD")); 
     assertEquals("\\uDBFF\\uDFFD", StringEscapeUtils.escapeEcmaScript("\uDBFF\uDFFD")); 
 }
@Test
public void testAbbreviate_StringIntInt2037() { 
     assertEquals(null, StringUtils.abbreviate(null, 10, 12)); 
     assertEquals("", StringUtils.abbreviate("", 0, 10)); 
     assertEquals("", StringUtils.abbreviate("", 2, 10)); 
     try { 
         @SuppressWarnings("unused") 
         final String res = StringUtils.abbreviate("abcdefghij", 0, 3); 
         fail("StringUtils.abbreviate expecting IllegalArgumentException"); 
     } catch (final IllegalArgumentException ex) { 
     } 
     try { 
         @SuppressWarnings("unused") 
         final String res = StringUtils.abbreviate("abcdefghij", 5, 6); 
         fail("StringUtils.abbreviate expecting IllegalArgumentException"); 
     } catch (final IllegalArgumentException ex) { 
     } 
     final String raspberry = "raspberry peach"; 
     assertEquals("raspberry peach", StringUtils.abbreviate(raspberry, 11, 15)); 
     assertEquals(null, StringUtils.abbreviate(null, 7, 14)); 
     assertAbbreviateWithOffset("abcdefg...", -1, 10); 
     assertAbbreviateWithOffset("abcdefg...", 0, 10); 
     assertAbbreviateWithOffset("abcdefg...", 1, 10); 
     assertAbbreviateWithOffset("abcdefg...", 2, 10); 
     assertAbbreviateWithOffset("abcdefg...", 3, 10); 
     assertAbbreviateWithOffset("abcdefg...", 4, 10); 
     assertAbbreviateWithOffset("...fghi...", 5, 10); 
     assertAbbreviateWithOffset("...ghij...", 6, 10); 
     assertAbbreviateWithOffset("...hijk...", 7, 10); 
     assertAbbreviateWithOffset("...ijklmno", 8, 10); 
     assertAbbreviateWithOffset("...ijklmno", 9, 10); 
     assertAbbreviateWithOffset("...ijklmno", 10, 10); 
     assertAbbreviateWithOffset("...ijklmno", 10, 10); 
     assertAbbreviateWithOffset("...ijklmno", 11, 10); 
     assertAbbreviateWithOffset("...ijklmno", 12, 10); 
     assertAbbreviateWithOffset("...ijklmno", 13, 10); 
     assertAbbreviateWithOffset("...ijklmno", 14, 10); 
     assertAbbreviateWithOffset("...ijklmno", 15, 10); 
     assertAbbreviateWithOffset("...ijklmno", 16, 10); 
     assertAbbreviateWithOffset("...ijklmno", Integer.MAX_VALUE, 10); 
 }
@Test
public void testJoin_IteratorChar2038() { 
     assertEquals(null, StringUtils.join((Iterator<?>) null, ',')); 
     assertEquals(TEXT_LIST_CHAR, StringUtils.join(Arrays.asList(ARRAY_LIST).iterator(), SEPARATOR_CHAR)); 
     assertEquals("", StringUtils.join(Arrays.asList(NULL_ARRAY_LIST).iterator(), SEPARATOR_CHAR)); 
     assertEquals("", StringUtils.join(Arrays.asList(EMPTY_ARRAY_LIST).iterator(), SEPARATOR_CHAR)); 
     assertEquals("foo", StringUtils.join(Collections.singleton("foo").iterator(), 'x')); 
 }
@Test
public void testEscapeSurrogatePairs2049() throws Exception { 
     assertEquals("\uD83D\uDE30", StringEscapeUtils.escapeCsv("\uD83D\uDE30")); 
     assertEquals("\uD800\uDC00", StringEscapeUtils.escapeCsv("\uD800\uDC00")); 
     assertEquals("\uD834\uDD1E", StringEscapeUtils.escapeCsv("\uD834\uDD1E")); 
     assertEquals("\uDBFF\uDFFD", StringEscapeUtils.escapeCsv("\uDBFF\uDFFD")); 
     assertEquals("\uDBFF\uDFFD", StringEscapeUtils.escapeHtml3("\uDBFF\uDFFD")); 
     assertEquals("\uDBFF\uDFFD", StringEscapeUtils.escapeHtml4("\uDBFF\uDFFD")); 
     assertEquals("\uDBFF\uDFFD", StringEscapeUtils.escapeXml("\uDBFF\uDFFD")); 
 }
@Test
public void testGetLevenshteinDistance_StringStringInt2053() { 
     assertEquals(0, StringUtils.getLevenshteinDistance("", "", 0)); 
     assertEquals(7, StringUtils.getLevenshteinDistance("aaapppp", "", 8)); 
     assertEquals(7, StringUtils.getLevenshteinDistance("aaapppp", "", 7)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("aaapppp", "", 6)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("b", "a", 0)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("a", "b", 0)); 
     assertEquals(0, StringUtils.getLevenshteinDistance("aa", "aa", 0)); 
     assertEquals(0, StringUtils.getLevenshteinDistance("aa", "aa", 2)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("aaa", "bbb", 2)); 
     assertEquals(3, StringUtils.getLevenshteinDistance("aaa", "bbb", 3)); 
     assertEquals(6, StringUtils.getLevenshteinDistance("aaaaaa", "b", 10)); 
     assertEquals(7, StringUtils.getLevenshteinDistance("aaapppp", "b", 8)); 
     assertEquals(3, StringUtils.getLevenshteinDistance("a", "bbb", 4)); 
     assertEquals(7, StringUtils.getLevenshteinDistance("aaapppp", "b", 7)); 
     assertEquals(3, StringUtils.getLevenshteinDistance("a", "bbb", 3)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("a", "bbb", 2)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("bbb", "a", 2)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("aaapppp", "b", 6)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("a", "bbb", 1)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("bbb", "a", 1)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("12345", "1234567", 1)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("1234567", "12345", 1)); 
     assertEquals(1, StringUtils.getLevenshteinDistance("frog", "fog", 1)); 
     assertEquals(3, StringUtils.getLevenshteinDistance("fly", "ant", 3)); 
     assertEquals(7, StringUtils.getLevenshteinDistance("elephant", "hippo", 7)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("elephant", "hippo", 6)); 
     assertEquals(7, StringUtils.getLevenshteinDistance("hippo", "elephant", 7)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("hippo", "elephant", 6)); 
     assertEquals(8, StringUtils.getLevenshteinDistance("hippo", "zzzzzzzz", 8)); 
     assertEquals(8, StringUtils.getLevenshteinDistance("zzzzzzzz", "hippo", 8)); 
     assertEquals(1, StringUtils.getLevenshteinDistance("hello", "hallo", 1)); 
     try { 
         @SuppressWarnings("unused") 
         final int d = StringUtils.getLevenshteinDistance("a", null, 0); 
         fail("expecting IllegalArgumentException"); 
     } catch (final IllegalArgumentException ex) { 
     } 
     try { 
         @SuppressWarnings("unused") 
         final int d = StringUtils.getLevenshteinDistance(null, "a", 0); 
         fail("expecting IllegalArgumentException"); 
     } catch (final IllegalArgumentException ex) { 
     } 
     try { 
         @SuppressWarnings("unused") 
         final int d = StringUtils.getLevenshteinDistance("a", "a", -1); 
         fail("expecting IllegalArgumentException"); 
     } catch (final IllegalArgumentException ex) { 
     } 
 }
@Test
public void testReplaceChars_StringStringString2069() { 
     assertEquals(null, StringUtils.replaceChars(null, null, null)); 
     assertEquals(null, StringUtils.replaceChars(null, "", null)); 
     assertEquals(null, StringUtils.replaceChars(null, "a", null)); 
     assertEquals(null, StringUtils.replaceChars(null, null, "")); 
     assertEquals(null, StringUtils.replaceChars(null, null, "x")); 
     assertEquals("", StringUtils.replaceChars("", null, null)); 
     assertEquals("", StringUtils.replaceChars("", "", null)); 
     assertEquals("", StringUtils.replaceChars("", "a", null)); 
     assertEquals("", StringUtils.replaceChars("", null, "")); 
     assertEquals("", StringUtils.replaceChars("", null, "x")); 
     assertEquals("abc", StringUtils.replaceChars("abc", null, null)); 
     assertEquals("abc", StringUtils.replaceChars("abc", null, "")); 
     assertEquals("abc", StringUtils.replaceChars("abc", null, "x")); 
     assertEquals("abc", StringUtils.replaceChars("abc", "", null)); 
     assertEquals("abc", StringUtils.replaceChars("abc", "", "")); 
     assertEquals("abc", StringUtils.replaceChars("abc", "", "x")); 
     assertEquals("ac", StringUtils.replaceChars("abc", "b", null)); 
     assertEquals("ac", StringUtils.replaceChars("abc", "b", "")); 
     assertEquals("axc", StringUtils.replaceChars("abc", "b", "x")); 
     assertEquals("ayzya", StringUtils.replaceChars("abcba", "bc", "yz")); 
     assertEquals("ayya", StringUtils.replaceChars("abcba", "bc", "y")); 
     assertEquals("ayzya", StringUtils.replaceChars("abcba", "bc", "yzx")); 
     assertEquals("abcba", StringUtils.replaceChars("abcba", "z", "w")); 
     assertSame("abcba", StringUtils.replaceChars("abcba", "z", "w")); 
     assertEquals("jelly", StringUtils.replaceChars("hello", "ho", "jy")); 
     assertEquals("ayzya", StringUtils.replaceChars("abcba", "bc", "yz")); 
     assertEquals("ayya", StringUtils.replaceChars("abcba", "bc", "y")); 
     assertEquals("ayzya", StringUtils.replaceChars("abcba", "bc", "yzx")); 
     assertEquals("bcc", StringUtils.replaceChars("abc", "ab", "bc")); 
     assertEquals("q651.506bera", StringUtils.replaceChars("d216.102oren", "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ123456789", "nopqrstuvwxyzabcdefghijklmNOPQRSTUVWXYZABCDEFGHIJKLM567891234")); 
 }
@Test
public void testAbbreviate_StringIntInt2078() { 
     assertEquals(null, StringUtils.abbreviate(null, 10, 12)); 
     assertEquals("", StringUtils.abbreviate("", 0, 10)); 
     assertEquals("", StringUtils.abbreviate("", 2, 10)); 
     try { 
         @SuppressWarnings("unused") 
         final String res = StringUtils.abbreviate("abcdefghij", 0, 3); 
         fail("StringUtils.abbreviate expecting IllegalArgumentException"); 
     } catch (final IllegalArgumentException ex) { 
     } 
     try { 
         @SuppressWarnings("unused") 
         final String res = StringUtils.abbreviate("abcdefghij", 5, 6); 
         fail("StringUtils.abbreviate expecting IllegalArgumentException"); 
     } catch (final IllegalArgumentException ex) { 
     } 
     final String raspberry = "raspberry peach"; 
     assertEquals("raspberry peach", StringUtils.abbreviate(raspberry, 11, 15)); 
     assertEquals(null, StringUtils.abbreviate(null, 7, 14)); 
     assertAbbreviateWithOffset("abcdefg...", -1, 10); 
     assertAbbreviateWithOffset("abcdefg...", 0, 10); 
     assertAbbreviateWithOffset("abcdefg...", 1, 10); 
     assertAbbreviateWithOffset("abcdefg...", 2, 10); 
     assertAbbreviateWithOffset("abcdefg...", 3, 10); 
     assertAbbreviateWithOffset("abcdefg...", 4, 10); 
     assertAbbreviateWithOffset("...fghi...", 5, 10); 
     assertAbbreviateWithOffset("...ghij...", 6, 10); 
     assertAbbreviateWithOffset("...hijk...", 7, 10); 
     assertAbbreviateWithOffset("...ijklmno", 8, 10); 
     assertAbbreviateWithOffset("...ijklmno", 9, 10); 
     assertAbbreviateWithOffset("...ijklmno", 10, 10); 
     assertAbbreviateWithOffset("...ijklmno", 10, 10); 
     assertAbbreviateWithOffset("...ijklmno", 11, 10); 
     assertAbbreviateWithOffset("...ijklmno", 12, 10); 
     assertAbbreviateWithOffset("...ijklmno", 13, 10); 
     assertAbbreviateWithOffset("...ijklmno", 14, 10); 
     assertAbbreviateWithOffset("...ijklmno", 15, 10); 
     assertAbbreviateWithOffset("...ijklmno", 16, 10); 
     assertAbbreviateWithOffset("...ijklmno", Integer.MAX_VALUE, 10); 
 }
@Test
public void testRightPad_StringIntChar2082() { 
     assertEquals(null, StringUtils.rightPad(null, 5, ' ')); 
     assertEquals("     ", StringUtils.rightPad("", 5, ' ')); 
     assertEquals("abc  ", StringUtils.rightPad("abc", 5, ' ')); 
     assertEquals("abc", StringUtils.rightPad("abc", 2, ' ')); 
     assertEquals("abc", StringUtils.rightPad("abc", -1, ' ')); 
     assertEquals("abcxx", StringUtils.rightPad("abc", 5, 'x')); 
     final String str = StringUtils.rightPad("aaa", 10000, 'a'); 
     assertEquals(10000, str.length()); 
     assertTrue(StringUtils.containsOnly(str, new char[] { 'a' })); 
 }
@Test
public void testRepeat_StringInt2086() { 
     assertEquals(null, StringUtils.repeat(null, 2)); 
     assertEquals("", StringUtils.repeat("ab", 0)); 
     assertEquals("", StringUtils.repeat("", 3)); 
     assertEquals("aaa", StringUtils.repeat("a", 3)); 
     assertEquals("ababab", StringUtils.repeat("ab", 3)); 
     assertEquals("abcabcabc", StringUtils.repeat("abc", 3)); 
     final String str = StringUtils.repeat("a", 10000); 
     assertEquals(10000, str.length()); 
     assertTrue(StringUtils.containsOnly(str, new char[] { 'a' })); 
 }
@Test
public void testGetCommonPrefix_StringArray2110() { 
     assertEquals("", StringUtils.getCommonPrefix((String[]) null)); 
     assertEquals("", StringUtils.getCommonPrefix()); 
     assertEquals("abc", StringUtils.getCommonPrefix("abc")); 
     assertEquals("", StringUtils.getCommonPrefix(null, null)); 
     assertEquals("", StringUtils.getCommonPrefix("", "")); 
     assertEquals("", StringUtils.getCommonPrefix("", null)); 
     assertEquals("", StringUtils.getCommonPrefix("abc", null, null)); 
     assertEquals("", StringUtils.getCommonPrefix(null, null, "abc")); 
     assertEquals("", StringUtils.getCommonPrefix("", "abc")); 
     assertEquals("", StringUtils.getCommonPrefix("abc", "")); 
     assertEquals("abc", StringUtils.getCommonPrefix("abc", "abc")); 
     assertEquals("a", StringUtils.getCommonPrefix("abc", "a")); 
     assertEquals("ab", StringUtils.getCommonPrefix("ab", "abxyz")); 
     assertEquals("ab", StringUtils.getCommonPrefix("abcde", "abxyz")); 
     assertEquals("", StringUtils.getCommonPrefix("abcde", "xyz")); 
     assertEquals("", StringUtils.getCommonPrefix("xyz", "abcde")); 
     assertEquals("i am a ", StringUtils.getCommonPrefix("i am a machine", "i am a robot")); 
 }
@Test
public void testGetLevenshteinDistance_StringStringInt2155() { 
     assertEquals(0, StringUtils.getLevenshteinDistance("", "", 0)); 
     assertEquals(7, StringUtils.getLevenshteinDistance("aaapppp", "", 8)); 
     assertEquals(7, StringUtils.getLevenshteinDistance("aaapppp", "", 7)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("aaapppp", "", 6)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("b", "a", 0)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("a", "b", 0)); 
     assertEquals(0, StringUtils.getLevenshteinDistance("aa", "aa", 0)); 
     assertEquals(0, StringUtils.getLevenshteinDistance("aa", "aa", 2)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("aaa", "bbb", 2)); 
     assertEquals(3, StringUtils.getLevenshteinDistance("aaa", "bbb", 3)); 
     assertEquals(6, StringUtils.getLevenshteinDistance("aaaaaa", "b", 10)); 
     assertEquals(7, StringUtils.getLevenshteinDistance("aaapppp", "b", 8)); 
     assertEquals(3, StringUtils.getLevenshteinDistance("a", "bbb", 4)); 
     assertEquals(7, StringUtils.getLevenshteinDistance("aaapppp", "b", 7)); 
     assertEquals(3, StringUtils.getLevenshteinDistance("a", "bbb", 3)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("a", "bbb", 2)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("bbb", "a", 2)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("aaapppp", "b", 6)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("a", "bbb", 1)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("bbb", "a", 1)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("12345", "1234567", 1)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("1234567", "12345", 1)); 
     assertEquals(1, StringUtils.getLevenshteinDistance("frog", "fog", 1)); 
     assertEquals(3, StringUtils.getLevenshteinDistance("fly", "ant", 3)); 
     assertEquals(7, StringUtils.getLevenshteinDistance("elephant", "hippo", 7)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("elephant", "hippo", 6)); 
     assertEquals(7, StringUtils.getLevenshteinDistance("hippo", "elephant", 7)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("hippo", "elephant", 6)); 
     assertEquals(8, StringUtils.getLevenshteinDistance("hippo", "zzzzzzzz", 8)); 
     assertEquals(8, StringUtils.getLevenshteinDistance("zzzzzzzz", "hippo", 8)); 
     assertEquals(1, StringUtils.getLevenshteinDistance("hello", "hallo", 1)); 
     try { 
         @SuppressWarnings("unused") 
         final int d = StringUtils.getLevenshteinDistance("a", null, 0); 
         fail("expecting IllegalArgumentException"); 
     } catch (final IllegalArgumentException ex) { 
     } 
     try { 
         @SuppressWarnings("unused") 
         final int d = StringUtils.getLevenshteinDistance(null, "a", 0); 
         fail("expecting IllegalArgumentException"); 
     } catch (final IllegalArgumentException ex) { 
     } 
     try { 
         @SuppressWarnings("unused") 
         final int d = StringUtils.getLevenshteinDistance("a", "a", -1); 
         fail("expecting IllegalArgumentException"); 
     } catch (final IllegalArgumentException ex) { 
     } 
 }
@Test
public void testRightPad_StringIntChar2156() { 
     assertEquals(null, StringUtils.rightPad(null, 5, ' ')); 
     assertEquals("     ", StringUtils.rightPad("", 5, ' ')); 
     assertEquals("abc  ", StringUtils.rightPad("abc", 5, ' ')); 
     assertEquals("abc", StringUtils.rightPad("abc", 2, ' ')); 
     assertEquals("abc", StringUtils.rightPad("abc", -1, ' ')); 
     assertEquals("abcxx", StringUtils.rightPad("abc", 5, 'x')); 
     final String str = StringUtils.rightPad("aaa", 10000, 'a'); 
     assertEquals(10000, str.length()); 
     assertTrue(StringUtils.containsOnly(str, new char[] { 'a' })); 
 }
@Test
public void testReplace_StringStringArrayStringArray2160() { 
     assertNull(StringUtils.replaceEach(null, new String[] { "a" }, new String[] { "b" })); 
     assertEquals(StringUtils.replaceEach("", new String[] { "a" }, new String[] { "b" }), ""); 
     assertEquals(StringUtils.replaceEach("aba", null, null), "aba"); 
     assertEquals(StringUtils.replaceEach("aba", new String[0], null), "aba"); 
     assertEquals(StringUtils.replaceEach("aba", null, new String[0]), "aba"); 
     assertEquals(StringUtils.replaceEach("aba", new String[] { "a" }, null), "aba"); 
     assertEquals(StringUtils.replaceEach("aba", new String[] { "a" }, new String[] { "" }), "b"); 
     assertEquals(StringUtils.replaceEach("aba", new String[] { null }, new String[] { "a" }), "aba"); 
     assertEquals(StringUtils.replaceEach("abcde", new String[] { "ab", "d" }, new String[] { "w", "t" }), "wcte"); 
     assertEquals(StringUtils.replaceEach("abcde", new String[] { "ab", "d" }, new String[] { "d", "t" }), "dcte"); 
     assertEquals("bcc", StringUtils.replaceEach("abc", new String[] { "a", "b" }, new String[] { "b", "c" })); 
     assertEquals("q651.506bera", StringUtils.replaceEach("d216.102oren", new String[] { "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "1", "2", "3", "4", "5", "6", "7", "8", "9" }, new String[] { "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z", "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "5", "6", "7", "8", "9", "1", "2", "3", "4" })); 
     assertEquals(StringUtils.replaceEach("aba", new String[] { "a" }, new String[] { null }), "aba"); 
     assertEquals(StringUtils.replaceEach("aba", new String[] { "a", "b" }, new String[] { "c", null }), "cbc"); 
 }
@Test
public void testEscapeSurrogatePairsLang8582162() throws Exception { 
     assertEquals("\\uDBFF\\uDFFD", StringEscapeUtils.escapeJava("\uDBFF\uDFFD")); 
     assertEquals("\\uDBFF\\uDFFD", StringEscapeUtils.escapeEcmaScript("\uDBFF\uDFFD")); 
 }
@Test
public void testReplace_StringStringArrayStringArray2190() { 
     assertNull(StringUtils.replaceEach(null, new String[] { "a" }, new String[] { "b" })); 
     assertEquals(StringUtils.replaceEach("", new String[] { "a" }, new String[] { "b" }), ""); 
     assertEquals(StringUtils.replaceEach("aba", null, null), "aba"); 
     assertEquals(StringUtils.replaceEach("aba", new String[0], null), "aba"); 
     assertEquals(StringUtils.replaceEach("aba", null, new String[0]), "aba"); 
     assertEquals(StringUtils.replaceEach("aba", new String[] { "a" }, null), "aba"); 
     assertEquals(StringUtils.replaceEach("aba", new String[] { "a" }, new String[] { "" }), "b"); 
     assertEquals(StringUtils.replaceEach("aba", new String[] { null }, new String[] { "a" }), "aba"); 
     assertEquals(StringUtils.replaceEach("abcde", new String[] { "ab", "d" }, new String[] { "w", "t" }), "wcte"); 
     assertEquals(StringUtils.replaceEach("abcde", new String[] { "ab", "d" }, new String[] { "d", "t" }), "dcte"); 
     assertEquals("bcc", StringUtils.replaceEach("abc", new String[] { "a", "b" }, new String[] { "b", "c" })); 
     assertEquals("q651.506bera", StringUtils.replaceEach("d216.102oren", new String[] { "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "1", "2", "3", "4", "5", "6", "7", "8", "9" }, new String[] { "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z", "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "5", "6", "7", "8", "9", "1", "2", "3", "4" })); 
     assertEquals(StringUtils.replaceEach("aba", new String[] { "a" }, new String[] { null }), "aba"); 
     assertEquals(StringUtils.replaceEach("aba", new String[] { "a", "b" }, new String[] { "c", null }), "cbc"); 
 }
@Test
public void testReplace_StringStringString2212() { 
     assertEquals(null, StringUtils.replace(null, null, null)); 
     assertEquals(null, StringUtils.replace(null, null, "any")); 
     assertEquals(null, StringUtils.replace(null, "any", null)); 
     assertEquals(null, StringUtils.replace(null, "any", "any")); 
     assertEquals("", StringUtils.replace("", null, null)); 
     assertEquals("", StringUtils.replace("", null, "any")); 
     assertEquals("", StringUtils.replace("", "any", null)); 
     assertEquals("", StringUtils.replace("", "any", "any")); 
     assertEquals("FOO", StringUtils.replace("FOO", "", "any")); 
     assertEquals("FOO", StringUtils.replace("FOO", null, "any")); 
     assertEquals("FOO", StringUtils.replace("FOO", "F", null)); 
     assertEquals("FOO", StringUtils.replace("FOO", null, null)); 
     assertEquals("", StringUtils.replace("foofoofoo", "foo", "")); 
     assertEquals("barbarbar", StringUtils.replace("foofoofoo", "foo", "bar")); 
     assertEquals("farfarfar", StringUtils.replace("foofoofoo", "oo", "ar")); 
 }
@Test
public void testRemoveEndIgnoreCase2219() { 
     assertNull("removeEndIgnoreCase(null, null)", StringUtils.removeEndIgnoreCase(null, null)); 
     assertNull("removeEndIgnoreCase(null, \"\")", StringUtils.removeEndIgnoreCase(null, "")); 
     assertNull("removeEndIgnoreCase(null, \"a\")", StringUtils.removeEndIgnoreCase(null, "a")); 
     assertEquals("removeEndIgnoreCase(\"\", null)", StringUtils.removeEndIgnoreCase("", null), ""); 
     assertEquals("removeEndIgnoreCase(\"\", \"\")", StringUtils.removeEndIgnoreCase("", ""), ""); 
     assertEquals("removeEndIgnoreCase(\"\", \"a\")", StringUtils.removeEndIgnoreCase("", "a"), ""); 
     assertEquals("removeEndIgnoreCase(\"www.domain.com.\", \".com\")", StringUtils.removeEndIgnoreCase("www.domain.com.", ".com"), "www.domain.com."); 
     assertEquals("removeEndIgnoreCase(\"www.domain.com\", \".com\")", StringUtils.removeEndIgnoreCase("www.domain.com", ".com"), "www.domain"); 
     assertEquals("removeEndIgnoreCase(\"www.domain\", \".com\")", StringUtils.removeEndIgnoreCase("www.domain", ".com"), "www.domain"); 
     assertEquals("removeEndIgnoreCase(\"domain.com\", \"\")", StringUtils.removeEndIgnoreCase("domain.com", ""), "domain.com"); 
     assertEquals("removeEndIgnoreCase(\"domain.com\", null)", StringUtils.removeEndIgnoreCase("domain.com", null), "domain.com"); 
     assertEquals("removeEndIgnoreCase(\"www.domain.com\", \".COM\")", StringUtils.removeEndIgnoreCase("www.domain.com", ".COM"), "www.domain"); 
     assertEquals("removeEndIgnoreCase(\"www.domain.COM\", \".com\")", StringUtils.removeEndIgnoreCase("www.domain.COM", ".com"), "www.domain"); 
 }
@Test
public void testSplit_StringChar2224() { 
     assertArrayEquals(null, StringUtils.split(null, '.')); 
     assertEquals(0, StringUtils.split("", '.').length); 
     String str = "a.b.. c"; 
     String[] res = StringUtils.split(str, '.'); 
     assertEquals(3, res.length); 
     assertEquals("a", res[0]); 
     assertEquals("b", res[1]); 
     assertEquals(" c", res[2]); 
     str = ".a."; 
     res = StringUtils.split(str, '.'); 
     assertEquals(1, res.length); 
     assertEquals("a", res[0]); 
     str = "a b c"; 
     res = StringUtils.split(str, ' '); 
     assertEquals(3, res.length); 
     assertEquals("a", res[0]); 
     assertEquals("b", res[1]); 
     assertEquals("c", res[2]); 
 }
@Test
public void testGetLevenshteinDistance_StringStringInt2237() { 
     assertEquals(0, StringUtils.getLevenshteinDistance("", "", 0)); 
     assertEquals(7, StringUtils.getLevenshteinDistance("aaapppp", "", 8)); 
     assertEquals(7, StringUtils.getLevenshteinDistance("aaapppp", "", 7)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("aaapppp", "", 6)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("b", "a", 0)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("a", "b", 0)); 
     assertEquals(0, StringUtils.getLevenshteinDistance("aa", "aa", 0)); 
     assertEquals(0, StringUtils.getLevenshteinDistance("aa", "aa", 2)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("aaa", "bbb", 2)); 
     assertEquals(3, StringUtils.getLevenshteinDistance("aaa", "bbb", 3)); 
     assertEquals(6, StringUtils.getLevenshteinDistance("aaaaaa", "b", 10)); 
     assertEquals(7, StringUtils.getLevenshteinDistance("aaapppp", "b", 8)); 
     assertEquals(3, StringUtils.getLevenshteinDistance("a", "bbb", 4)); 
     assertEquals(7, StringUtils.getLevenshteinDistance("aaapppp", "b", 7)); 
     assertEquals(3, StringUtils.getLevenshteinDistance("a", "bbb", 3)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("a", "bbb", 2)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("bbb", "a", 2)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("aaapppp", "b", 6)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("a", "bbb", 1)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("bbb", "a", 1)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("12345", "1234567", 1)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("1234567", "12345", 1)); 
     assertEquals(1, StringUtils.getLevenshteinDistance("frog", "fog", 1)); 
     assertEquals(3, StringUtils.getLevenshteinDistance("fly", "ant", 3)); 
     assertEquals(7, StringUtils.getLevenshteinDistance("elephant", "hippo", 7)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("elephant", "hippo", 6)); 
     assertEquals(7, StringUtils.getLevenshteinDistance("hippo", "elephant", 7)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("hippo", "elephant", 6)); 
     assertEquals(8, StringUtils.getLevenshteinDistance("hippo", "zzzzzzzz", 8)); 
     assertEquals(8, StringUtils.getLevenshteinDistance("zzzzzzzz", "hippo", 8)); 
     assertEquals(1, StringUtils.getLevenshteinDistance("hello", "hallo", 1)); 
     try { 
         @SuppressWarnings("unused") 
         final int d = StringUtils.getLevenshteinDistance("a", null, 0); 
         fail("expecting IllegalArgumentException"); 
     } catch (final IllegalArgumentException ex) { 
     } 
     try { 
         @SuppressWarnings("unused") 
         final int d = StringUtils.getLevenshteinDistance(null, "a", 0); 
         fail("expecting IllegalArgumentException"); 
     } catch (final IllegalArgumentException ex) { 
     } 
     try { 
         @SuppressWarnings("unused") 
         final int d = StringUtils.getLevenshteinDistance("a", "a", -1); 
         fail("expecting IllegalArgumentException"); 
     } catch (final IllegalArgumentException ex) { 
     } 
 }
@Test
public void testPrependIfMissingIgnoreCase2246() { 
     assertEquals("prependIfMissingIgnoreCase(null,null)", null, StringUtils.prependIfMissingIgnoreCase(null, null)); 
     assertEquals("prependIfMissingIgnoreCase(abc,null)", "abc", StringUtils.prependIfMissingIgnoreCase("abc", null)); 
     assertEquals("prependIfMissingIgnoreCase(\"\",xyz)", "xyz", StringUtils.prependIfMissingIgnoreCase("", "xyz")); 
     assertEquals("prependIfMissingIgnoreCase(abc,xyz)", "xyzabc", StringUtils.prependIfMissingIgnoreCase("abc", "xyz")); 
     assertEquals("prependIfMissingIgnoreCase(xyzabc,xyz)", "xyzabc", StringUtils.prependIfMissingIgnoreCase("xyzabc", "xyz")); 
     assertEquals("prependIfMissingIgnoreCase(XYZabc,xyz)", "XYZabc", StringUtils.prependIfMissingIgnoreCase("XYZabc", "xyz")); 
     assertEquals("prependIfMissingIgnoreCase(null,null null)", null, StringUtils.prependIfMissingIgnoreCase(null, null, (CharSequence[]) null)); 
     assertEquals("prependIfMissingIgnoreCase(abc,null,null)", "abc", StringUtils.prependIfMissingIgnoreCase("abc", null, (CharSequence[]) null)); 
     assertEquals("prependIfMissingIgnoreCase(\"\",xyz,null)", "xyz", StringUtils.prependIfMissingIgnoreCase("", "xyz", (CharSequence[]) null)); 
     assertEquals("prependIfMissingIgnoreCase(abc,xyz,{null})", "xyzabc", StringUtils.prependIfMissingIgnoreCase("abc", "xyz", new CharSequence[] { null })); 
     assertEquals("prependIfMissingIgnoreCase(abc,xyz,\"\")", "abc", StringUtils.prependIfMissingIgnoreCase("abc", "xyz", "")); 
     assertEquals("prependIfMissingIgnoreCase(abc,xyz,mno)", "xyzabc", StringUtils.prependIfMissingIgnoreCase("abc", "xyz", "mno")); 
     assertEquals("prependIfMissingIgnoreCase(xyzabc,xyz,mno)", "xyzabc", StringUtils.prependIfMissingIgnoreCase("xyzabc", "xyz", "mno")); 
     assertEquals("prependIfMissingIgnoreCase(mnoabc,xyz,mno)", "mnoabc", StringUtils.prependIfMissingIgnoreCase("mnoabc", "xyz", "mno")); 
     assertEquals("prependIfMissingIgnoreCase(XYZabc,xyz,mno)", "XYZabc", StringUtils.prependIfMissingIgnoreCase("XYZabc", "xyz", "mno")); 
     assertEquals("prependIfMissingIgnoreCase(MNOabc,xyz,mno)", "MNOabc", StringUtils.prependIfMissingIgnoreCase("MNOabc", "xyz", "mno")); 
 }
@Test
public void testRepeat_StringInt2300() { 
     assertEquals(null, StringUtils.repeat(null, 2)); 
     assertEquals("", StringUtils.repeat("ab", 0)); 
     assertEquals("", StringUtils.repeat("", 3)); 
     assertEquals("aaa", StringUtils.repeat("a", 3)); 
     assertEquals("ababab", StringUtils.repeat("ab", 3)); 
     assertEquals("abcabcabc", StringUtils.repeat("abc", 3)); 
     final String str = StringUtils.repeat("a", 10000); 
     assertEquals(10000, str.length()); 
     assertTrue(StringUtils.containsOnly(str, new char[] { 'a' })); 
 }
@Test
public void testReplace_StringStringArrayStringArray2314() { 
     assertNull(StringUtils.replaceEach(null, new String[] { "a" }, new String[] { "b" })); 
     assertEquals(StringUtils.replaceEach("", new String[] { "a" }, new String[] { "b" }), ""); 
     assertEquals(StringUtils.replaceEach("aba", null, null), "aba"); 
     assertEquals(StringUtils.replaceEach("aba", new String[0], null), "aba"); 
     assertEquals(StringUtils.replaceEach("aba", null, new String[0]), "aba"); 
     assertEquals(StringUtils.replaceEach("aba", new String[] { "a" }, null), "aba"); 
     assertEquals(StringUtils.replaceEach("aba", new String[] { "a" }, new String[] { "" }), "b"); 
     assertEquals(StringUtils.replaceEach("aba", new String[] { null }, new String[] { "a" }), "aba"); 
     assertEquals(StringUtils.replaceEach("abcde", new String[] { "ab", "d" }, new String[] { "w", "t" }), "wcte"); 
     assertEquals(StringUtils.replaceEach("abcde", new String[] { "ab", "d" }, new String[] { "d", "t" }), "dcte"); 
     assertEquals("bcc", StringUtils.replaceEach("abc", new String[] { "a", "b" }, new String[] { "b", "c" })); 
     assertEquals("q651.506bera", StringUtils.replaceEach("d216.102oren", new String[] { "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "1", "2", "3", "4", "5", "6", "7", "8", "9" }, new String[] { "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z", "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "5", "6", "7", "8", "9", "1", "2", "3", "4" })); 
     assertEquals(StringUtils.replaceEach("aba", new String[] { "a" }, new String[] { null }), "aba"); 
     assertEquals(StringUtils.replaceEach("aba", new String[] { "a", "b" }, new String[] { "c", null }), "cbc"); 
 }
@Test
public void testGetCommonPrefix_StringArray2318() { 
     assertEquals("", StringUtils.getCommonPrefix((String[]) null)); 
     assertEquals("", StringUtils.getCommonPrefix()); 
     assertEquals("abc", StringUtils.getCommonPrefix("abc")); 
     assertEquals("", StringUtils.getCommonPrefix(null, null)); 
     assertEquals("", StringUtils.getCommonPrefix("", "")); 
     assertEquals("", StringUtils.getCommonPrefix("", null)); 
     assertEquals("", StringUtils.getCommonPrefix("abc", null, null)); 
     assertEquals("", StringUtils.getCommonPrefix(null, null, "abc")); 
     assertEquals("", StringUtils.getCommonPrefix("", "abc")); 
     assertEquals("", StringUtils.getCommonPrefix("abc", "")); 
     assertEquals("abc", StringUtils.getCommonPrefix("abc", "abc")); 
     assertEquals("a", StringUtils.getCommonPrefix("abc", "a")); 
     assertEquals("ab", StringUtils.getCommonPrefix("ab", "abxyz")); 
     assertEquals("ab", StringUtils.getCommonPrefix("abcde", "abxyz")); 
     assertEquals("", StringUtils.getCommonPrefix("abcde", "xyz")); 
     assertEquals("", StringUtils.getCommonPrefix("xyz", "abcde")); 
     assertEquals("i am a ", StringUtils.getCommonPrefix("i am a machine", "i am a robot")); 
 }
@Test
public void testEscapeSurrogatePairsLang8582340() throws Exception { 
     assertEquals("\\uDBFF\\uDFFD", StringEscapeUtils.escapeJava("\uDBFF\uDFFD")); 
     assertEquals("\\uDBFF\\uDFFD", StringEscapeUtils.escapeEcmaScript("\uDBFF\uDFFD")); 
 }
@Test
public void testSplit_StringChar2353() { 
     assertArrayEquals(null, StringUtils.split(null, '.')); 
     assertEquals(0, StringUtils.split("", '.').length); 
     String str = "a.b.. c"; 
     String[] res = StringUtils.split(str, '.'); 
     assertEquals(3, res.length); 
     assertEquals("a", res[0]); 
     assertEquals("b", res[1]); 
     assertEquals(" c", res[2]); 
     str = ".a."; 
     res = StringUtils.split(str, '.'); 
     assertEquals(1, res.length); 
     assertEquals("a", res[0]); 
     str = "a b c"; 
     res = StringUtils.split(str, ' '); 
     assertEquals(3, res.length); 
     assertEquals("a", res[0]); 
     assertEquals("b", res[1]); 
     assertEquals("c", res[2]); 
 }
@Test
public void testReverseDelimited_StringChar2373() { 
     assertEquals(null, StringUtils.reverseDelimited(null, '.')); 
     assertEquals("", StringUtils.reverseDelimited("", '.')); 
     assertEquals("c.b.a", StringUtils.reverseDelimited("a.b.c", '.')); 
     assertEquals("a b c", StringUtils.reverseDelimited("a b c", '.')); 
     assertEquals("", StringUtils.reverseDelimited("", '.')); 
 }
@Test
public void testEscapeSurrogatePairs2379() throws Exception { 
     assertEquals("\uD83D\uDE30", StringEscapeUtils.escapeCsv("\uD83D\uDE30")); 
     assertEquals("\uD800\uDC00", StringEscapeUtils.escapeCsv("\uD800\uDC00")); 
     assertEquals("\uD834\uDD1E", StringEscapeUtils.escapeCsv("\uD834\uDD1E")); 
     assertEquals("\uDBFF\uDFFD", StringEscapeUtils.escapeCsv("\uDBFF\uDFFD")); 
     assertEquals("\uDBFF\uDFFD", StringEscapeUtils.escapeHtml3("\uDBFF\uDFFD")); 
     assertEquals("\uDBFF\uDFFD", StringEscapeUtils.escapeHtml4("\uDBFF\uDFFD")); 
     assertEquals("\uDBFF\uDFFD", StringEscapeUtils.escapeXml("\uDBFF\uDFFD")); 
 }
@Test
public void testDeleteWhitespace_String2394() { 
     assertEquals(null, StringUtils.deleteWhitespace(null)); 
     assertEquals("", StringUtils.deleteWhitespace("")); 
     assertEquals("", StringUtils.deleteWhitespace("  \u000C  \t\t\u001F\n\n \u000B  ")); 
     assertEquals("", StringUtils.deleteWhitespace(StringUtilsTest.WHITESPACE)); 
     assertEquals(StringUtilsTest.NON_WHITESPACE, StringUtils.deleteWhitespace(StringUtilsTest.NON_WHITESPACE)); 
     assertEquals("\u00A0\u202F", StringUtils.deleteWhitespace("  \u00A0  \t\t\n\n \u202F  ")); 
     assertEquals("\u00A0\u202F", StringUtils.deleteWhitespace("\u00A0\u202F")); 
     assertEquals("test", StringUtils.deleteWhitespace("\u000Bt  \t\n\u0009e\rs\n\n   \tt")); 
 }
@Test
public void testReplaceChars_StringStringString2406() { 
     assertEquals(null, StringUtils.replaceChars(null, null, null)); 
     assertEquals(null, StringUtils.replaceChars(null, "", null)); 
     assertEquals(null, StringUtils.replaceChars(null, "a", null)); 
     assertEquals(null, StringUtils.replaceChars(null, null, "")); 
     assertEquals(null, StringUtils.replaceChars(null, null, "x")); 
     assertEquals("", StringUtils.replaceChars("", null, null)); 
     assertEquals("", StringUtils.replaceChars("", "", null)); 
     assertEquals("", StringUtils.replaceChars("", "a", null)); 
     assertEquals("", StringUtils.replaceChars("", null, "")); 
     assertEquals("", StringUtils.replaceChars("", null, "x")); 
     assertEquals("abc", StringUtils.replaceChars("abc", null, null)); 
     assertEquals("abc", StringUtils.replaceChars("abc", null, "")); 
     assertEquals("abc", StringUtils.replaceChars("abc", null, "x")); 
     assertEquals("abc", StringUtils.replaceChars("abc", "", null)); 
     assertEquals("abc", StringUtils.replaceChars("abc", "", "")); 
     assertEquals("abc", StringUtils.replaceChars("abc", "", "x")); 
     assertEquals("ac", StringUtils.replaceChars("abc", "b", null)); 
     assertEquals("ac", StringUtils.replaceChars("abc", "b", "")); 
     assertEquals("axc", StringUtils.replaceChars("abc", "b", "x")); 
     assertEquals("ayzya", StringUtils.replaceChars("abcba", "bc", "yz")); 
     assertEquals("ayya", StringUtils.replaceChars("abcba", "bc", "y")); 
     assertEquals("ayzya", StringUtils.replaceChars("abcba", "bc", "yzx")); 
     assertEquals("abcba", StringUtils.replaceChars("abcba", "z", "w")); 
     assertSame("abcba", StringUtils.replaceChars("abcba", "z", "w")); 
     assertEquals("jelly", StringUtils.replaceChars("hello", "ho", "jy")); 
     assertEquals("ayzya", StringUtils.replaceChars("abcba", "bc", "yz")); 
     assertEquals("ayya", StringUtils.replaceChars("abcba", "bc", "y")); 
     assertEquals("ayzya", StringUtils.replaceChars("abcba", "bc", "yzx")); 
     assertEquals("bcc", StringUtils.replaceChars("abc", "ab", "bc")); 
     assertEquals("q651.506bera", StringUtils.replaceChars("d216.102oren", "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ123456789", "nopqrstuvwxyzabcdefghijklmNOPQRSTUVWXYZABCDEFGHIJKLM567891234")); 
 }
@Test
public void testOverlay_StringStringIntInt2420() { 
     assertEquals(null, StringUtils.overlay(null, null, 2, 4)); 
     assertEquals(null, StringUtils.overlay(null, null, -2, -4)); 
     assertEquals("", StringUtils.overlay("", null, 0, 0)); 
     assertEquals("", StringUtils.overlay("", "", 0, 0)); 
     assertEquals("zzzz", StringUtils.overlay("", "zzzz", 0, 0)); 
     assertEquals("zzzz", StringUtils.overlay("", "zzzz", 2, 4)); 
     assertEquals("zzzz", StringUtils.overlay("", "zzzz", -2, -4)); 
     assertEquals("abef", StringUtils.overlay("abcdef", null, 2, 4)); 
     assertEquals("abef", StringUtils.overlay("abcdef", null, 4, 2)); 
     assertEquals("abef", StringUtils.overlay("abcdef", "", 2, 4)); 
     assertEquals("abef", StringUtils.overlay("abcdef", "", 4, 2)); 
     assertEquals("abzzzzef", StringUtils.overlay("abcdef", "zzzz", 2, 4)); 
     assertEquals("abzzzzef", StringUtils.overlay("abcdef", "zzzz", 4, 2)); 
     assertEquals("zzzzef", StringUtils.overlay("abcdef", "zzzz", -1, 4)); 
     assertEquals("zzzzef", StringUtils.overlay("abcdef", "zzzz", 4, -1)); 
     assertEquals("zzzzabcdef", StringUtils.overlay("abcdef", "zzzz", -2, -1)); 
     assertEquals("zzzzabcdef", StringUtils.overlay("abcdef", "zzzz", -1, -2)); 
     assertEquals("abcdzzzz", StringUtils.overlay("abcdef", "zzzz", 4, 10)); 
     assertEquals("abcdzzzz", StringUtils.overlay("abcdef", "zzzz", 10, 4)); 
     assertEquals("abcdefzzzz", StringUtils.overlay("abcdef", "zzzz", 8, 10)); 
     assertEquals("abcdefzzzz", StringUtils.overlay("abcdef", "zzzz", 10, 8)); 
 }
@Test
public void testEscapeSurrogatePairsLang8582423() throws Exception { 
     assertEquals("\\uDBFF\\uDFFD", StringEscapeUtils.escapeJava("\uDBFF\uDFFD")); 
     assertEquals("\\uDBFF\\uDFFD", StringEscapeUtils.escapeEcmaScript("\uDBFF\uDFFD")); 
 }
@Test
public void testGetLevenshteinDistance_StringStringInt2443() { 
     assertEquals(0, StringUtils.getLevenshteinDistance("", "", 0)); 
     assertEquals(7, StringUtils.getLevenshteinDistance("aaapppp", "", 8)); 
     assertEquals(7, StringUtils.getLevenshteinDistance("aaapppp", "", 7)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("aaapppp", "", 6)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("b", "a", 0)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("a", "b", 0)); 
     assertEquals(0, StringUtils.getLevenshteinDistance("aa", "aa", 0)); 
     assertEquals(0, StringUtils.getLevenshteinDistance("aa", "aa", 2)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("aaa", "bbb", 2)); 
     assertEquals(3, StringUtils.getLevenshteinDistance("aaa", "bbb", 3)); 
     assertEquals(6, StringUtils.getLevenshteinDistance("aaaaaa", "b", 10)); 
     assertEquals(7, StringUtils.getLevenshteinDistance("aaapppp", "b", 8)); 
     assertEquals(3, StringUtils.getLevenshteinDistance("a", "bbb", 4)); 
     assertEquals(7, StringUtils.getLevenshteinDistance("aaapppp", "b", 7)); 
     assertEquals(3, StringUtils.getLevenshteinDistance("a", "bbb", 3)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("a", "bbb", 2)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("bbb", "a", 2)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("aaapppp", "b", 6)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("a", "bbb", 1)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("bbb", "a", 1)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("12345", "1234567", 1)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("1234567", "12345", 1)); 
     assertEquals(1, StringUtils.getLevenshteinDistance("frog", "fog", 1)); 
     assertEquals(3, StringUtils.getLevenshteinDistance("fly", "ant", 3)); 
     assertEquals(7, StringUtils.getLevenshteinDistance("elephant", "hippo", 7)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("elephant", "hippo", 6)); 
     assertEquals(7, StringUtils.getLevenshteinDistance("hippo", "elephant", 7)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("hippo", "elephant", 6)); 
     assertEquals(8, StringUtils.getLevenshteinDistance("hippo", "zzzzzzzz", 8)); 
     assertEquals(8, StringUtils.getLevenshteinDistance("zzzzzzzz", "hippo", 8)); 
     assertEquals(1, StringUtils.getLevenshteinDistance("hello", "hallo", 1)); 
     try { 
         @SuppressWarnings("unused") 
         final int d = StringUtils.getLevenshteinDistance("a", null, 0); 
         fail("expecting IllegalArgumentException"); 
     } catch (final IllegalArgumentException ex) { 
     } 
     try { 
         @SuppressWarnings("unused") 
         final int d = StringUtils.getLevenshteinDistance(null, "a", 0); 
         fail("expecting IllegalArgumentException"); 
     } catch (final IllegalArgumentException ex) { 
     } 
     try { 
         @SuppressWarnings("unused") 
         final int d = StringUtils.getLevenshteinDistance("a", "a", -1); 
         fail("expecting IllegalArgumentException"); 
     } catch (final IllegalArgumentException ex) { 
     } 
 }
@Test
public void testReplace_StringStringStringInt2461() { 
     assertEquals(null, StringUtils.replace(null, null, null, 2)); 
     assertEquals(null, StringUtils.replace(null, null, "any", 2)); 
     assertEquals(null, StringUtils.replace(null, "any", null, 2)); 
     assertEquals(null, StringUtils.replace(null, "any", "any", 2)); 
     assertEquals("", StringUtils.replace("", null, null, 2)); 
     assertEquals("", StringUtils.replace("", null, "any", 2)); 
     assertEquals("", StringUtils.replace("", "any", null, 2)); 
     assertEquals("", StringUtils.replace("", "any", "any", 2)); 
     final String str = new String(new char[] { 'o', 'o', 'f', 'o', 'o' }); 
     assertSame(str, StringUtils.replace(str, "x", "", -1)); 
     assertEquals("f", StringUtils.replace("oofoo", "o", "", -1)); 
     assertEquals("oofoo", StringUtils.replace("oofoo", "o", "", 0)); 
     assertEquals("ofoo", StringUtils.replace("oofoo", "o", "", 1)); 
     assertEquals("foo", StringUtils.replace("oofoo", "o", "", 2)); 
     assertEquals("fo", StringUtils.replace("oofoo", "o", "", 3)); 
     assertEquals("f", StringUtils.replace("oofoo", "o", "", 4)); 
     assertEquals("f", StringUtils.replace("oofoo", "o", "", -5)); 
     assertEquals("f", StringUtils.replace("oofoo", "o", "", 1000)); 
 }
@Test
public void testRepeat_StringInt2498() { 
     assertEquals(null, StringUtils.repeat(null, 2)); 
     assertEquals("", StringUtils.repeat("ab", 0)); 
     assertEquals("", StringUtils.repeat("", 3)); 
     assertEquals("aaa", StringUtils.repeat("a", 3)); 
     assertEquals("ababab", StringUtils.repeat("ab", 3)); 
     assertEquals("abcabcabc", StringUtils.repeat("abc", 3)); 
     final String str = StringUtils.repeat("a", 10000); 
     assertEquals(10000, str.length()); 
     assertTrue(StringUtils.containsOnly(str, new char[] { 'a' })); 
 }
@Test
public void testChop2522() { 
     final String[][] chopCases = { { FOO_UNCAP + "\r\n", FOO_UNCAP }, { FOO_UNCAP + "\n", FOO_UNCAP }, { FOO_UNCAP + "\r", FOO_UNCAP }, { FOO_UNCAP + " \r", FOO_UNCAP + " " }, { "foo", "fo" }, { "foo\nfoo", "foo\nfo" }, { "\n", "" }, { "\r", "" }, { "\r\n", "" }, { null, null }, { "", "" }, { "a", "" } }; 
     for (final String[] chopCase : chopCases) { 
         final String original = chopCase[0]; 
         final String expectedResult = chopCase[1]; 
         assertEquals("chop(String) failed", expectedResult, StringUtils.chop(original)); 
     } 
 }
@Test
public void testPrependIfMissingIgnoreCase2527() { 
     assertEquals("prependIfMissingIgnoreCase(null,null)", null, StringUtils.prependIfMissingIgnoreCase(null, null)); 
     assertEquals("prependIfMissingIgnoreCase(abc,null)", "abc", StringUtils.prependIfMissingIgnoreCase("abc", null)); 
     assertEquals("prependIfMissingIgnoreCase(\"\",xyz)", "xyz", StringUtils.prependIfMissingIgnoreCase("", "xyz")); 
     assertEquals("prependIfMissingIgnoreCase(abc,xyz)", "xyzabc", StringUtils.prependIfMissingIgnoreCase("abc", "xyz")); 
     assertEquals("prependIfMissingIgnoreCase(xyzabc,xyz)", "xyzabc", StringUtils.prependIfMissingIgnoreCase("xyzabc", "xyz")); 
     assertEquals("prependIfMissingIgnoreCase(XYZabc,xyz)", "XYZabc", StringUtils.prependIfMissingIgnoreCase("XYZabc", "xyz")); 
     assertEquals("prependIfMissingIgnoreCase(null,null null)", null, StringUtils.prependIfMissingIgnoreCase(null, null, (CharSequence[]) null)); 
     assertEquals("prependIfMissingIgnoreCase(abc,null,null)", "abc", StringUtils.prependIfMissingIgnoreCase("abc", null, (CharSequence[]) null)); 
     assertEquals("prependIfMissingIgnoreCase(\"\",xyz,null)", "xyz", StringUtils.prependIfMissingIgnoreCase("", "xyz", (CharSequence[]) null)); 
     assertEquals("prependIfMissingIgnoreCase(abc,xyz,{null})", "xyzabc", StringUtils.prependIfMissingIgnoreCase("abc", "xyz", new CharSequence[] { null })); 
     assertEquals("prependIfMissingIgnoreCase(abc,xyz,\"\")", "abc", StringUtils.prependIfMissingIgnoreCase("abc", "xyz", "")); 
     assertEquals("prependIfMissingIgnoreCase(abc,xyz,mno)", "xyzabc", StringUtils.prependIfMissingIgnoreCase("abc", "xyz", "mno")); 
     assertEquals("prependIfMissingIgnoreCase(xyzabc,xyz,mno)", "xyzabc", StringUtils.prependIfMissingIgnoreCase("xyzabc", "xyz", "mno")); 
     assertEquals("prependIfMissingIgnoreCase(mnoabc,xyz,mno)", "mnoabc", StringUtils.prependIfMissingIgnoreCase("mnoabc", "xyz", "mno")); 
     assertEquals("prependIfMissingIgnoreCase(XYZabc,xyz,mno)", "XYZabc", StringUtils.prependIfMissingIgnoreCase("XYZabc", "xyz", "mno")); 
     assertEquals("prependIfMissingIgnoreCase(MNOabc,xyz,mno)", "MNOabc", StringUtils.prependIfMissingIgnoreCase("MNOabc", "xyz", "mno")); 
 }
@Test
public void testJoin_ArrayOfBytes2533() { 
     assertEquals(null, StringUtils.join((byte[]) null, ',')); 
     assertEquals("1;2", StringUtils.join(BYTE_PRIM_LIST, SEPARATOR_CHAR)); 
     assertEquals("2", StringUtils.join(BYTE_PRIM_LIST, SEPARATOR_CHAR, 1, 2)); 
 }
@Test
public void testJoin_IterableString2547() { 
     assertEquals(null, StringUtils.join((Iterable<?>) null, null)); 
     assertEquals(TEXT_LIST_NOSEP, StringUtils.join(Arrays.asList(ARRAY_LIST), null)); 
     assertEquals(TEXT_LIST_NOSEP, StringUtils.join(Arrays.asList(ARRAY_LIST), "")); 
     assertEquals("foo", StringUtils.join(Collections.singleton("foo"), "x")); 
     assertEquals("foo", StringUtils.join(Collections.singleton("foo"), null)); 
     assertEquals("", StringUtils.join(Arrays.asList(NULL_ARRAY_LIST), null)); 
     assertEquals("", StringUtils.join(Arrays.asList(EMPTY_ARRAY_LIST), null)); 
     assertEquals("", StringUtils.join(Arrays.asList(EMPTY_ARRAY_LIST), "")); 
     assertEquals("", StringUtils.join(Arrays.asList(EMPTY_ARRAY_LIST), SEPARATOR)); 
     assertEquals(TEXT_LIST, StringUtils.join(Arrays.asList(ARRAY_LIST), SEPARATOR)); 
 }
@Test
public void testSwapCase_String2554() { 
     assertEquals(null, StringUtils.swapCase(null)); 
     assertEquals("", StringUtils.swapCase("")); 
     assertEquals("  ", StringUtils.swapCase("  ")); 
     assertEquals("i", WordUtils.swapCase("I")); 
     assertEquals("I", WordUtils.swapCase("i")); 
     assertEquals("I AM HERE 123", StringUtils.swapCase("i am here 123")); 
     assertEquals("i aM hERE 123", StringUtils.swapCase("I Am Here 123")); 
     assertEquals("I AM here 123", StringUtils.swapCase("i am HERE 123")); 
     assertEquals("i am here 123", StringUtils.swapCase("I AM HERE 123")); 
     final String test = "This String contains a TitleCase character: \u01C8"; 
     final String expect = "tHIS sTRING CONTAINS A tITLEcASE CHARACTER: \u01C9"; 
     assertEquals(expect, WordUtils.swapCase(test)); 
 }
@Test
public void testReplace_StringStringArrayStringArrayBoolean2559() { 
     assertNull(StringUtils.replaceEachRepeatedly(null, new String[] { "a" }, new String[] { "b" })); 
     assertEquals(StringUtils.replaceEachRepeatedly("", new String[] { "a" }, new String[] { "b" }), ""); 
     assertEquals(StringUtils.replaceEachRepeatedly("aba", null, null), "aba"); 
     assertEquals(StringUtils.replaceEachRepeatedly("aba", new String[0], null), "aba"); 
     assertEquals(StringUtils.replaceEachRepeatedly("aba", null, new String[0]), "aba"); 
     assertEquals(StringUtils.replaceEachRepeatedly("aba", new String[0], null), "aba"); 
     assertEquals(StringUtils.replaceEachRepeatedly("aba", new String[] { "a" }, new String[] { "" }), "b"); 
     assertEquals(StringUtils.replaceEachRepeatedly("aba", new String[] { null }, new String[] { "a" }), "aba"); 
     assertEquals(StringUtils.replaceEachRepeatedly("abcde", new String[] { "ab", "d" }, new String[] { "w", "t" }), "wcte"); 
     assertEquals(StringUtils.replaceEachRepeatedly("abcde", new String[] { "ab", "d" }, new String[] { "d", "t" }), "tcte"); 
     try { 
         StringUtils.replaceEachRepeatedly("abcde", new String[] { "ab", "d" }, new String[] { "d", "ab" }); 
         fail("Should be a circular reference"); 
     } catch (final IllegalStateException e) { 
     } 
 }
@Test
public void testSplitByCharacterType2564() { 
     assertNull(StringUtils.splitByCharacterType(null)); 
     assertEquals(0, StringUtils.splitByCharacterType("").length); 
     assertTrue(ArrayUtils.isEquals(new String[] { "ab", " ", "de", " ", "fg" }, StringUtils.splitByCharacterType("ab de fg"))); 
     assertTrue(ArrayUtils.isEquals(new String[] { "ab", "   ", "de", " ", "fg" }, StringUtils.splitByCharacterType("ab   de fg"))); 
     assertTrue(ArrayUtils.isEquals(new String[] { "ab", ":", "cd", ":", "ef" }, StringUtils.splitByCharacterType("ab:cd:ef"))); 
     assertTrue(ArrayUtils.isEquals(new String[] { "number", "5" }, StringUtils.splitByCharacterType("number5"))); 
     assertTrue(ArrayUtils.isEquals(new String[] { "foo", "B", "ar" }, StringUtils.splitByCharacterType("fooBar"))); 
     assertTrue(ArrayUtils.isEquals(new String[] { "foo", "200", "B", "ar" }, StringUtils.splitByCharacterType("foo200Bar"))); 
     assertTrue(ArrayUtils.isEquals(new String[] { "ASFR", "ules" }, StringUtils.splitByCharacterType("ASFRules"))); 
 }
@Test
public void testAbbreviateMiddle2578() { 
     assertNull(StringUtils.abbreviateMiddle(null, null, 0)); 
     assertEquals("abc", StringUtils.abbreviateMiddle("abc", null, 0)); 
     assertEquals("abc", StringUtils.abbreviateMiddle("abc", ".", 0)); 
     assertEquals("abc", StringUtils.abbreviateMiddle("abc", ".", 3)); 
     assertEquals("ab.f", StringUtils.abbreviateMiddle("abcdef", ".", 4)); 
     assertEquals("A very long text with un...f the text is complete.", StringUtils.abbreviateMiddle("A very long text with unimportant stuff in the middle but interesting start and " + "end to see if the text is complete.", "...", 50)); 
     final String longText = "Start text" + StringUtils.repeat("x", 10000) + "Close text"; 
     assertEquals("Start text->Close text", StringUtils.abbreviateMiddle(longText, "->", 22)); 
     assertEquals("abc", StringUtils.abbreviateMiddle("abc", ".", -1)); 
     assertEquals("abc", StringUtils.abbreviateMiddle("abc", ".", 1)); 
     assertEquals("abc", StringUtils.abbreviateMiddle("abc", ".", 2)); 
     assertEquals("a", StringUtils.abbreviateMiddle("a", ".", 1)); 
     assertEquals("a.d", StringUtils.abbreviateMiddle("abcd", ".", 3)); 
     assertEquals("a..f", StringUtils.abbreviateMiddle("abcdef", "..", 4)); 
     assertEquals("ab.ef", StringUtils.abbreviateMiddle("abcdef", ".", 5)); 
 }
@Test
public void testReplaceChars_StringStringString2593() { 
     assertEquals(null, StringUtils.replaceChars(null, null, null)); 
     assertEquals(null, StringUtils.replaceChars(null, "", null)); 
     assertEquals(null, StringUtils.replaceChars(null, "a", null)); 
     assertEquals(null, StringUtils.replaceChars(null, null, "")); 
     assertEquals(null, StringUtils.replaceChars(null, null, "x")); 
     assertEquals("", StringUtils.replaceChars("", null, null)); 
     assertEquals("", StringUtils.replaceChars("", "", null)); 
     assertEquals("", StringUtils.replaceChars("", "a", null)); 
     assertEquals("", StringUtils.replaceChars("", null, "")); 
     assertEquals("", StringUtils.replaceChars("", null, "x")); 
     assertEquals("abc", StringUtils.replaceChars("abc", null, null)); 
     assertEquals("abc", StringUtils.replaceChars("abc", null, "")); 
     assertEquals("abc", StringUtils.replaceChars("abc", null, "x")); 
     assertEquals("abc", StringUtils.replaceChars("abc", "", null)); 
     assertEquals("abc", StringUtils.replaceChars("abc", "", "")); 
     assertEquals("abc", StringUtils.replaceChars("abc", "", "x")); 
     assertEquals("ac", StringUtils.replaceChars("abc", "b", null)); 
     assertEquals("ac", StringUtils.replaceChars("abc", "b", "")); 
     assertEquals("axc", StringUtils.replaceChars("abc", "b", "x")); 
     assertEquals("ayzya", StringUtils.replaceChars("abcba", "bc", "yz")); 
     assertEquals("ayya", StringUtils.replaceChars("abcba", "bc", "y")); 
     assertEquals("ayzya", StringUtils.replaceChars("abcba", "bc", "yzx")); 
     assertEquals("abcba", StringUtils.replaceChars("abcba", "z", "w")); 
     assertSame("abcba", StringUtils.replaceChars("abcba", "z", "w")); 
     assertEquals("jelly", StringUtils.replaceChars("hello", "ho", "jy")); 
     assertEquals("ayzya", StringUtils.replaceChars("abcba", "bc", "yz")); 
     assertEquals("ayya", StringUtils.replaceChars("abcba", "bc", "y")); 
     assertEquals("ayzya", StringUtils.replaceChars("abcba", "bc", "yzx")); 
     assertEquals("bcc", StringUtils.replaceChars("abc", "ab", "bc")); 
     assertEquals("q651.506bera", StringUtils.replaceChars("d216.102oren", "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ123456789", "nopqrstuvwxyzabcdefghijklmNOPQRSTUVWXYZABCDEFGHIJKLM567891234")); 
 }
@Test
public void testEscapeSurrogatePairs2595() throws Exception { 
     assertEquals("\uD83D\uDE30", StringEscapeUtils.escapeCsv("\uD83D\uDE30")); 
     assertEquals("\uD800\uDC00", StringEscapeUtils.escapeCsv("\uD800\uDC00")); 
     assertEquals("\uD834\uDD1E", StringEscapeUtils.escapeCsv("\uD834\uDD1E")); 
     assertEquals("\uDBFF\uDFFD", StringEscapeUtils.escapeCsv("\uDBFF\uDFFD")); 
     assertEquals("\uDBFF\uDFFD", StringEscapeUtils.escapeHtml3("\uDBFF\uDFFD")); 
     assertEquals("\uDBFF\uDFFD", StringEscapeUtils.escapeHtml4("\uDBFF\uDFFD")); 
     assertEquals("\uDBFF\uDFFD", StringEscapeUtils.escapeXml("\uDBFF\uDFFD")); 
 }
@Test
public void testSplitByWholeString_StringStringBooleanInt2598() { 
     assertArrayEquals(null, StringUtils.splitByWholeSeparator(null, ".", 3)); 
     assertEquals(0, StringUtils.splitByWholeSeparator("", ".", 3).length); 
     final String stringToSplitOnNulls = "ab   de fg"; 
     final String[] splitOnNullExpectedResults = { "ab", "de fg" }; 
     final String[] splitOnNullResults = StringUtils.splitByWholeSeparator(stringToSplitOnNulls, null, 2); 
     assertEquals(splitOnNullExpectedResults.length, splitOnNullResults.length); 
     for (int i = 0; i < splitOnNullExpectedResults.length; i += 1) { 
         assertEquals(splitOnNullExpectedResults[i], splitOnNullResults[i]); 
     } 
     final String stringToSplitOnCharactersAndString = "abstemiouslyaeiouyabstemiouslyaeiouyabstemiously"; 
     final String[] splitOnStringExpectedResults = { "abstemiously", "abstemiouslyaeiouyabstemiously" }; 
     final String[] splitOnStringResults = StringUtils.splitByWholeSeparator(stringToSplitOnCharactersAndString, "aeiouy", 2); 
     assertEquals(splitOnStringExpectedResults.length, splitOnStringResults.length); 
     for (int i = 0; i < splitOnStringExpectedResults.length; i++) { 
         assertEquals(splitOnStringExpectedResults[i], splitOnStringResults[i]); 
     } 
 }
@Test
public void testJoin_IterableString2600() { 
     assertEquals(null, StringUtils.join((Iterable<?>) null, null)); 
     assertEquals(TEXT_LIST_NOSEP, StringUtils.join(Arrays.asList(ARRAY_LIST), null)); 
     assertEquals(TEXT_LIST_NOSEP, StringUtils.join(Arrays.asList(ARRAY_LIST), "")); 
     assertEquals("foo", StringUtils.join(Collections.singleton("foo"), "x")); 
     assertEquals("foo", StringUtils.join(Collections.singleton("foo"), null)); 
     assertEquals("", StringUtils.join(Arrays.asList(NULL_ARRAY_LIST), null)); 
     assertEquals("", StringUtils.join(Arrays.asList(EMPTY_ARRAY_LIST), null)); 
     assertEquals("", StringUtils.join(Arrays.asList(EMPTY_ARRAY_LIST), "")); 
     assertEquals("", StringUtils.join(Arrays.asList(EMPTY_ARRAY_LIST), SEPARATOR)); 
     assertEquals(TEXT_LIST, StringUtils.join(Arrays.asList(ARRAY_LIST), SEPARATOR)); 
 }
@Test
public void testSplitPreserveAllTokens_StringChar2608() { 
     assertArrayEquals(null, StringUtils.splitPreserveAllTokens(null, '.')); 
     assertEquals(0, StringUtils.splitPreserveAllTokens("", '.').length); 
     String str = "a.b. c"; 
     String[] res = StringUtils.splitPreserveAllTokens(str, '.'); 
     assertEquals(3, res.length); 
     assertEquals("a", res[0]); 
     assertEquals("b", res[1]); 
     assertEquals(" c", res[2]); 
     str = "a.b.. c"; 
     res = StringUtils.splitPreserveAllTokens(str, '.'); 
     assertEquals(4, res.length); 
     assertEquals("a", res[0]); 
     assertEquals("b", res[1]); 
     assertEquals("", res[2]); 
     assertEquals(" c", res[3]); 
     str = ".a."; 
     res = StringUtils.splitPreserveAllTokens(str, '.'); 
     assertEquals(3, res.length); 
     assertEquals("", res[0]); 
     assertEquals("a", res[1]); 
     assertEquals("", res[2]); 
     str = ".a.."; 
     res = StringUtils.splitPreserveAllTokens(str, '.'); 
     assertEquals(4, res.length); 
     assertEquals("", res[0]); 
     assertEquals("a", res[1]); 
     assertEquals("", res[2]); 
     assertEquals("", res[3]); 
     str = "..a."; 
     res = StringUtils.splitPreserveAllTokens(str, '.'); 
     assertEquals(4, res.length); 
     assertEquals("", res[0]); 
     assertEquals("", res[1]); 
     assertEquals("a", res[2]); 
     assertEquals("", res[3]); 
     str = "..a"; 
     res = StringUtils.splitPreserveAllTokens(str, '.'); 
     assertEquals(3, res.length); 
     assertEquals("", res[0]); 
     assertEquals("", res[1]); 
     assertEquals("a", res[2]); 
     str = "a b c"; 
     res = StringUtils.splitPreserveAllTokens(str, ' '); 
     assertEquals(3, res.length); 
     assertEquals("a", res[0]); 
     assertEquals("b", res[1]); 
     assertEquals("c", res[2]); 
     str = "a  b  c"; 
     res = StringUtils.splitPreserveAllTokens(str, ' '); 
     assertEquals(5, res.length); 
     assertEquals("a", res[0]); 
     assertEquals("", res[1]); 
     assertEquals("b", res[2]); 
     assertEquals("", res[3]); 
     assertEquals("c", res[4]); 
     str = " a b c"; 
     res = StringUtils.splitPreserveAllTokens(str, ' '); 
     assertEquals(4, res.length); 
     assertEquals("", res[0]); 
     assertEquals("a", res[1]); 
     assertEquals("b", res[2]); 
     assertEquals("c", res[3]); 
     str = "  a b c"; 
     res = StringUtils.splitPreserveAllTokens(str, ' '); 
     assertEquals(5, res.length); 
     assertEquals("", res[0]); 
     assertEquals("", res[1]); 
     assertEquals("a", res[2]); 
     assertEquals("b", res[3]); 
     assertEquals("c", res[4]); 
     str = "a b c "; 
     res = StringUtils.splitPreserveAllTokens(str, ' '); 
     assertEquals(4, res.length); 
     assertEquals("a", res[0]); 
     assertEquals("b", res[1]); 
     assertEquals("c", res[2]); 
     assertEquals("", res[3]); 
     str = "a b c  "; 
     res = StringUtils.splitPreserveAllTokens(str, ' '); 
     assertEquals(5, res.length); 
     assertEquals("a", res[0]); 
     assertEquals("b", res[1]); 
     assertEquals("c", res[2]); 
     assertEquals("", res[3]); 
     assertEquals("", res[3]); 
     { 
         String[] results; 
         final String[] expectedResults = { "a", "", "b", "c" }; 
         results = StringUtils.splitPreserveAllTokens("a..b.c", '.'); 
         assertEquals(expectedResults.length, results.length); 
         for (int i = 0; i < expectedResults.length; i++) { 
             assertEquals(expectedResults[i], results[i]); 
         } 
     } 
 }
@Test
public void testCenter_StringIntChar2613() { 
     assertEquals(null, StringUtils.center(null, -1, ' ')); 
     assertEquals(null, StringUtils.center(null, 4, ' ')); 
     assertEquals("    ", StringUtils.center("", 4, ' ')); 
     assertEquals("ab", StringUtils.center("ab", 0, ' ')); 
     assertEquals("ab", StringUtils.center("ab", -1, ' ')); 
     assertEquals("ab", StringUtils.center("ab", 1, ' ')); 
     assertEquals("    ", StringUtils.center("", 4, ' ')); 
     assertEquals(" ab ", StringUtils.center("ab", 4, ' ')); 
     assertEquals("abcd", StringUtils.center("abcd", 2, ' ')); 
     assertEquals(" a  ", StringUtils.center("a", 4, ' ')); 
     assertEquals("  a  ", StringUtils.center("a", 5, ' ')); 
     assertEquals("xxaxx", StringUtils.center("a", 5, 'x')); 
 }
@Test
public void testEscapeSurrogatePairsLang8582614() throws Exception { 
     assertEquals("\\uDBFF\\uDFFD", StringEscapeUtils.escapeJava("\uDBFF\uDFFD")); 
     assertEquals("\\uDBFF\\uDFFD", StringEscapeUtils.escapeEcmaScript("\uDBFF\uDFFD")); 
 }
@Test
public void testPrependIfMissingIgnoreCase2615() { 
     assertEquals("prependIfMissingIgnoreCase(null,null)", null, StringUtils.prependIfMissingIgnoreCase(null, null)); 
     assertEquals("prependIfMissingIgnoreCase(abc,null)", "abc", StringUtils.prependIfMissingIgnoreCase("abc", null)); 
     assertEquals("prependIfMissingIgnoreCase(\"\",xyz)", "xyz", StringUtils.prependIfMissingIgnoreCase("", "xyz")); 
     assertEquals("prependIfMissingIgnoreCase(abc,xyz)", "xyzabc", StringUtils.prependIfMissingIgnoreCase("abc", "xyz")); 
     assertEquals("prependIfMissingIgnoreCase(xyzabc,xyz)", "xyzabc", StringUtils.prependIfMissingIgnoreCase("xyzabc", "xyz")); 
     assertEquals("prependIfMissingIgnoreCase(XYZabc,xyz)", "XYZabc", StringUtils.prependIfMissingIgnoreCase("XYZabc", "xyz")); 
     assertEquals("prependIfMissingIgnoreCase(null,null null)", null, StringUtils.prependIfMissingIgnoreCase(null, null, (CharSequence[]) null)); 
     assertEquals("prependIfMissingIgnoreCase(abc,null,null)", "abc", StringUtils.prependIfMissingIgnoreCase("abc", null, (CharSequence[]) null)); 
     assertEquals("prependIfMissingIgnoreCase(\"\",xyz,null)", "xyz", StringUtils.prependIfMissingIgnoreCase("", "xyz", (CharSequence[]) null)); 
     assertEquals("prependIfMissingIgnoreCase(abc,xyz,{null})", "xyzabc", StringUtils.prependIfMissingIgnoreCase("abc", "xyz", new CharSequence[] { null })); 
     assertEquals("prependIfMissingIgnoreCase(abc,xyz,\"\")", "abc", StringUtils.prependIfMissingIgnoreCase("abc", "xyz", "")); 
     assertEquals("prependIfMissingIgnoreCase(abc,xyz,mno)", "xyzabc", StringUtils.prependIfMissingIgnoreCase("abc", "xyz", "mno")); 
     assertEquals("prependIfMissingIgnoreCase(xyzabc,xyz,mno)", "xyzabc", StringUtils.prependIfMissingIgnoreCase("xyzabc", "xyz", "mno")); 
     assertEquals("prependIfMissingIgnoreCase(mnoabc,xyz,mno)", "mnoabc", StringUtils.prependIfMissingIgnoreCase("mnoabc", "xyz", "mno")); 
     assertEquals("prependIfMissingIgnoreCase(XYZabc,xyz,mno)", "XYZabc", StringUtils.prependIfMissingIgnoreCase("XYZabc", "xyz", "mno")); 
     assertEquals("prependIfMissingIgnoreCase(MNOabc,xyz,mno)", "MNOabc", StringUtils.prependIfMissingIgnoreCase("MNOabc", "xyz", "mno")); 
 }
@Test
public void testDefault_String2625() { 
     assertEquals("", StringUtils.defaultString(null)); 
     assertEquals("", StringUtils.defaultString("")); 
     assertEquals("abc", StringUtils.defaultString("abc")); 
 }
@Test
public void testGetCommonPrefix_StringArray2651() { 
     assertEquals("", StringUtils.getCommonPrefix((String[]) null)); 
     assertEquals("", StringUtils.getCommonPrefix()); 
     assertEquals("abc", StringUtils.getCommonPrefix("abc")); 
     assertEquals("", StringUtils.getCommonPrefix(null, null)); 
     assertEquals("", StringUtils.getCommonPrefix("", "")); 
     assertEquals("", StringUtils.getCommonPrefix("", null)); 
     assertEquals("", StringUtils.getCommonPrefix("abc", null, null)); 
     assertEquals("", StringUtils.getCommonPrefix(null, null, "abc")); 
     assertEquals("", StringUtils.getCommonPrefix("", "abc")); 
     assertEquals("", StringUtils.getCommonPrefix("abc", "")); 
     assertEquals("abc", StringUtils.getCommonPrefix("abc", "abc")); 
     assertEquals("a", StringUtils.getCommonPrefix("abc", "a")); 
     assertEquals("ab", StringUtils.getCommonPrefix("ab", "abxyz")); 
     assertEquals("ab", StringUtils.getCommonPrefix("abcde", "abxyz")); 
     assertEquals("", StringUtils.getCommonPrefix("abcde", "xyz")); 
     assertEquals("", StringUtils.getCommonPrefix("xyz", "abcde")); 
     assertEquals("i am a ", StringUtils.getCommonPrefix("i am a machine", "i am a robot")); 
 }
@Test
public void testReplace_StringStringStringInt2652() { 
     assertEquals(null, StringUtils.replace(null, null, null, 2)); 
     assertEquals(null, StringUtils.replace(null, null, "any", 2)); 
     assertEquals(null, StringUtils.replace(null, "any", null, 2)); 
     assertEquals(null, StringUtils.replace(null, "any", "any", 2)); 
     assertEquals("", StringUtils.replace("", null, null, 2)); 
     assertEquals("", StringUtils.replace("", null, "any", 2)); 
     assertEquals("", StringUtils.replace("", "any", null, 2)); 
     assertEquals("", StringUtils.replace("", "any", "any", 2)); 
     final String str = new String(new char[] { 'o', 'o', 'f', 'o', 'o' }); 
     assertSame(str, StringUtils.replace(str, "x", "", -1)); 
     assertEquals("f", StringUtils.replace("oofoo", "o", "", -1)); 
     assertEquals("oofoo", StringUtils.replace("oofoo", "o", "", 0)); 
     assertEquals("ofoo", StringUtils.replace("oofoo", "o", "", 1)); 
     assertEquals("foo", StringUtils.replace("oofoo", "o", "", 2)); 
     assertEquals("fo", StringUtils.replace("oofoo", "o", "", 3)); 
     assertEquals("f", StringUtils.replace("oofoo", "o", "", 4)); 
     assertEquals("f", StringUtils.replace("oofoo", "o", "", -5)); 
     assertEquals("f", StringUtils.replace("oofoo", "o", "", 1000)); 
 }
@Test
public void testReplace_StringStringArrayStringArray2658() { 
     assertNull(StringUtils.replaceEach(null, new String[] { "a" }, new String[] { "b" })); 
     assertEquals(StringUtils.replaceEach("", new String[] { "a" }, new String[] { "b" }), ""); 
     assertEquals(StringUtils.replaceEach("aba", null, null), "aba"); 
     assertEquals(StringUtils.replaceEach("aba", new String[0], null), "aba"); 
     assertEquals(StringUtils.replaceEach("aba", null, new String[0]), "aba"); 
     assertEquals(StringUtils.replaceEach("aba", new String[] { "a" }, null), "aba"); 
     assertEquals(StringUtils.replaceEach("aba", new String[] { "a" }, new String[] { "" }), "b"); 
     assertEquals(StringUtils.replaceEach("aba", new String[] { null }, new String[] { "a" }), "aba"); 
     assertEquals(StringUtils.replaceEach("abcde", new String[] { "ab", "d" }, new String[] { "w", "t" }), "wcte"); 
     assertEquals(StringUtils.replaceEach("abcde", new String[] { "ab", "d" }, new String[] { "d", "t" }), "dcte"); 
     assertEquals("bcc", StringUtils.replaceEach("abc", new String[] { "a", "b" }, new String[] { "b", "c" })); 
     assertEquals("q651.506bera", StringUtils.replaceEach("d216.102oren", new String[] { "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "1", "2", "3", "4", "5", "6", "7", "8", "9" }, new String[] { "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z", "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "5", "6", "7", "8", "9", "1", "2", "3", "4" })); 
     assertEquals(StringUtils.replaceEach("aba", new String[] { "a" }, new String[] { null }), "aba"); 
     assertEquals(StringUtils.replaceEach("aba", new String[] { "a", "b" }, new String[] { "c", null }), "cbc"); 
 }
@Test
public void testDeleteWhitespace_String2670() { 
     assertEquals(null, StringUtils.deleteWhitespace(null)); 
     assertEquals("", StringUtils.deleteWhitespace("")); 
     assertEquals("", StringUtils.deleteWhitespace("  \u000C  \t\t\u001F\n\n \u000B  ")); 
     assertEquals("", StringUtils.deleteWhitespace(StringUtilsTest.WHITESPACE)); 
     assertEquals(StringUtilsTest.NON_WHITESPACE, StringUtils.deleteWhitespace(StringUtilsTest.NON_WHITESPACE)); 
     assertEquals("\u00A0\u202F", StringUtils.deleteWhitespace("  \u00A0  \t\t\n\n \u202F  ")); 
     assertEquals("\u00A0\u202F", StringUtils.deleteWhitespace("\u00A0\u202F")); 
     assertEquals("test", StringUtils.deleteWhitespace("\u000Bt  \t\n\u0009e\rs\n\n   \tt")); 
 }
@Test
public void testJoin_ArrayOfBytes2687() { 
     assertEquals(null, StringUtils.join((byte[]) null, ',')); 
     assertEquals("1;2", StringUtils.join(BYTE_PRIM_LIST, SEPARATOR_CHAR)); 
     assertEquals("2", StringUtils.join(BYTE_PRIM_LIST, SEPARATOR_CHAR, 1, 2)); 
 }
@Test
public void testOverlay_StringStringIntInt2689() { 
     assertEquals(null, StringUtils.overlay(null, null, 2, 4)); 
     assertEquals(null, StringUtils.overlay(null, null, -2, -4)); 
     assertEquals("", StringUtils.overlay("", null, 0, 0)); 
     assertEquals("", StringUtils.overlay("", "", 0, 0)); 
     assertEquals("zzzz", StringUtils.overlay("", "zzzz", 0, 0)); 
     assertEquals("zzzz", StringUtils.overlay("", "zzzz", 2, 4)); 
     assertEquals("zzzz", StringUtils.overlay("", "zzzz", -2, -4)); 
     assertEquals("abef", StringUtils.overlay("abcdef", null, 2, 4)); 
     assertEquals("abef", StringUtils.overlay("abcdef", null, 4, 2)); 
     assertEquals("abef", StringUtils.overlay("abcdef", "", 2, 4)); 
     assertEquals("abef", StringUtils.overlay("abcdef", "", 4, 2)); 
     assertEquals("abzzzzef", StringUtils.overlay("abcdef", "zzzz", 2, 4)); 
     assertEquals("abzzzzef", StringUtils.overlay("abcdef", "zzzz", 4, 2)); 
     assertEquals("zzzzef", StringUtils.overlay("abcdef", "zzzz", -1, 4)); 
     assertEquals("zzzzef", StringUtils.overlay("abcdef", "zzzz", 4, -1)); 
     assertEquals("zzzzabcdef", StringUtils.overlay("abcdef", "zzzz", -2, -1)); 
     assertEquals("zzzzabcdef", StringUtils.overlay("abcdef", "zzzz", -1, -2)); 
     assertEquals("abcdzzzz", StringUtils.overlay("abcdef", "zzzz", 4, 10)); 
     assertEquals("abcdzzzz", StringUtils.overlay("abcdef", "zzzz", 10, 4)); 
     assertEquals("abcdefzzzz", StringUtils.overlay("abcdef", "zzzz", 8, 10)); 
     assertEquals("abcdefzzzz", StringUtils.overlay("abcdef", "zzzz", 10, 8)); 
 }
@Test
public void testReplace_StringStringArrayStringArray2706() { 
     assertNull(StringUtils.replaceEach(null, new String[] { "a" }, new String[] { "b" })); 
     assertEquals(StringUtils.replaceEach("", new String[] { "a" }, new String[] { "b" }), ""); 
     assertEquals(StringUtils.replaceEach("aba", null, null), "aba"); 
     assertEquals(StringUtils.replaceEach("aba", new String[0], null), "aba"); 
     assertEquals(StringUtils.replaceEach("aba", null, new String[0]), "aba"); 
     assertEquals(StringUtils.replaceEach("aba", new String[] { "a" }, null), "aba"); 
     assertEquals(StringUtils.replaceEach("aba", new String[] { "a" }, new String[] { "" }), "b"); 
     assertEquals(StringUtils.replaceEach("aba", new String[] { null }, new String[] { "a" }), "aba"); 
     assertEquals(StringUtils.replaceEach("abcde", new String[] { "ab", "d" }, new String[] { "w", "t" }), "wcte"); 
     assertEquals(StringUtils.replaceEach("abcde", new String[] { "ab", "d" }, new String[] { "d", "t" }), "dcte"); 
     assertEquals("bcc", StringUtils.replaceEach("abc", new String[] { "a", "b" }, new String[] { "b", "c" })); 
     assertEquals("q651.506bera", StringUtils.replaceEach("d216.102oren", new String[] { "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "1", "2", "3", "4", "5", "6", "7", "8", "9" }, new String[] { "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z", "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "5", "6", "7", "8", "9", "1", "2", "3", "4" })); 
     assertEquals(StringUtils.replaceEach("aba", new String[] { "a" }, new String[] { null }), "aba"); 
     assertEquals(StringUtils.replaceEach("aba", new String[] { "a", "b" }, new String[] { "c", null }), "cbc"); 
 }
@Test
public void testRemoveStart2732() { 
     assertNull(StringUtils.removeStart(null, null)); 
     assertNull(StringUtils.removeStart(null, "")); 
     assertNull(StringUtils.removeStart(null, "a")); 
     assertEquals(StringUtils.removeStart("", null), ""); 
     assertEquals(StringUtils.removeStart("", ""), ""); 
     assertEquals(StringUtils.removeStart("", "a"), ""); 
     assertEquals(StringUtils.removeStart("www.domain.com", "www."), "domain.com"); 
     assertEquals(StringUtils.removeStart("domain.com", "www."), "domain.com"); 
     assertEquals(StringUtils.removeStart("domain.com", ""), "domain.com"); 
     assertEquals(StringUtils.removeStart("domain.com", null), "domain.com"); 
 }
@Test
public void testJoin_ArrayCharSeparator2733() { 
     assertEquals(null, StringUtils.join((Object[]) null, ',')); 
     assertEquals(TEXT_LIST_CHAR, StringUtils.join(ARRAY_LIST, SEPARATOR_CHAR)); 
     assertEquals("", StringUtils.join(EMPTY_ARRAY_LIST, SEPARATOR_CHAR)); 
     assertEquals(";;foo", StringUtils.join(MIXED_ARRAY_LIST, SEPARATOR_CHAR)); 
     assertEquals("foo;2", StringUtils.join(MIXED_TYPE_LIST, SEPARATOR_CHAR)); 
     assertEquals("/", StringUtils.join(MIXED_ARRAY_LIST, '/', 0, MIXED_ARRAY_LIST.length - 1)); 
     assertEquals("foo", StringUtils.join(MIXED_TYPE_LIST, '/', 0, 1)); 
     assertEquals("null", StringUtils.join(NULL_TO_STRING_LIST, '/', 0, 1)); 
     assertEquals("foo/2", StringUtils.join(MIXED_TYPE_LIST, '/', 0, 2)); 
     assertEquals("2", StringUtils.join(MIXED_TYPE_LIST, '/', 1, 2)); 
     assertEquals("", StringUtils.join(MIXED_TYPE_LIST, '/', 2, 1)); 
 }
@Test
public void testRemoveStart2766() { 
     assertNull(StringUtils.removeStart(null, null)); 
     assertNull(StringUtils.removeStart(null, "")); 
     assertNull(StringUtils.removeStart(null, "a")); 
     assertEquals(StringUtils.removeStart("", null), ""); 
     assertEquals(StringUtils.removeStart("", ""), ""); 
     assertEquals(StringUtils.removeStart("", "a"), ""); 
     assertEquals(StringUtils.removeStart("www.domain.com", "www."), "domain.com"); 
     assertEquals(StringUtils.removeStart("domain.com", "www."), "domain.com"); 
     assertEquals(StringUtils.removeStart("domain.com", ""), "domain.com"); 
     assertEquals(StringUtils.removeStart("domain.com", null), "domain.com"); 
 }
@Test
public void testDifference_StringString2770() { 
     assertEquals(null, StringUtils.difference(null, null)); 
     assertEquals("", StringUtils.difference("", "")); 
     assertEquals("abc", StringUtils.difference("", "abc")); 
     assertEquals("", StringUtils.difference("abc", "")); 
     assertEquals("i am a robot", StringUtils.difference(null, "i am a robot")); 
     assertEquals("i am a machine", StringUtils.difference("i am a machine", null)); 
     assertEquals("robot", StringUtils.difference("i am a machine", "i am a robot")); 
     assertEquals("", StringUtils.difference("abc", "abc")); 
     assertEquals("you are a robot", StringUtils.difference("i am a robot", "you are a robot")); 
 }
@Test
public void testSplit_StringChar2772() { 
     assertArrayEquals(null, StringUtils.split(null, '.')); 
     assertEquals(0, StringUtils.split("", '.').length); 
     String str = "a.b.. c"; 
     String[] res = StringUtils.split(str, '.'); 
     assertEquals(3, res.length); 
     assertEquals("a", res[0]); 
     assertEquals("b", res[1]); 
     assertEquals(" c", res[2]); 
     str = ".a."; 
     res = StringUtils.split(str, '.'); 
     assertEquals(1, res.length); 
     assertEquals("a", res[0]); 
     str = "a b c"; 
     res = StringUtils.split(str, ' '); 
     assertEquals(3, res.length); 
     assertEquals("a", res[0]); 
     assertEquals("b", res[1]); 
     assertEquals("c", res[2]); 
 } 
@SuppressWarnings("deprecation")
@Test
public void testChomp2778() { 
     final String[][] chompCases = { { FOO_UNCAP + "\r\n", FOO_UNCAP }, { FOO_UNCAP + "\n", FOO_UNCAP }, { FOO_UNCAP + "\r", FOO_UNCAP }, { FOO_UNCAP + " \r", FOO_UNCAP + " " }, { FOO_UNCAP, FOO_UNCAP }, { FOO_UNCAP + "\n\n", FOO_UNCAP + "\n" }, { FOO_UNCAP + "\r\n\r\n", FOO_UNCAP + "\r\n" }, { "foo\nfoo", "foo\nfoo" }, { "foo\n\rfoo", "foo\n\rfoo" }, { "\n", "" }, { "\r", "" }, { "a", "a" }, { "\r\n", "" }, { "", "" }, { null, null }, { FOO_UNCAP + "\n\r", FOO_UNCAP + "\n" } }; 
     for (final String[] chompCase : chompCases) { 
         final String original = chompCase[0]; 
         final String expectedResult = chompCase[1]; 
         assertEquals("chomp(String) failed", expectedResult, StringUtils.chomp(original)); 
     } 
     assertEquals("chomp(String, String) failed", "foo", StringUtils.chomp("foobar", "bar")); 
     assertEquals("chomp(String, String) failed", "foobar", StringUtils.chomp("foobar", "baz")); 
     assertEquals("chomp(String, String) failed", "foo", StringUtils.chomp("foo", "foooo")); 
     assertEquals("chomp(String, String) failed", "foobar", StringUtils.chomp("foobar", "")); 
     assertEquals("chomp(String, String) failed", "foobar", StringUtils.chomp("foobar", null)); 
     assertEquals("chomp(String, String) failed", "", StringUtils.chomp("", "foo")); 
     assertEquals("chomp(String, String) failed", "", StringUtils.chomp("", null)); 
     assertEquals("chomp(String, String) failed", "", StringUtils.chomp("", "")); 
     assertEquals("chomp(String, String) failed", null, StringUtils.chomp(null, "foo")); 
     assertEquals("chomp(String, String) failed", null, StringUtils.chomp(null, null)); 
     assertEquals("chomp(String, String) failed", null, StringUtils.chomp(null, "")); 
     assertEquals("chomp(String, String) failed", "", StringUtils.chomp("foo", "foo")); 
     assertEquals("chomp(String, String) failed", " ", StringUtils.chomp(" foo", "foo")); 
     assertEquals("chomp(String, String) failed", "foo ", StringUtils.chomp("foo ", "foo")); 
 }
@Test
public void testGetCommonPrefix_StringArray2791() { 
     assertEquals("", StringUtils.getCommonPrefix((String[]) null)); 
     assertEquals("", StringUtils.getCommonPrefix()); 
     assertEquals("abc", StringUtils.getCommonPrefix("abc")); 
     assertEquals("", StringUtils.getCommonPrefix(null, null)); 
     assertEquals("", StringUtils.getCommonPrefix("", "")); 
     assertEquals("", StringUtils.getCommonPrefix("", null)); 
     assertEquals("", StringUtils.getCommonPrefix("abc", null, null)); 
     assertEquals("", StringUtils.getCommonPrefix(null, null, "abc")); 
     assertEquals("", StringUtils.getCommonPrefix("", "abc")); 
     assertEquals("", StringUtils.getCommonPrefix("abc", "")); 
     assertEquals("abc", StringUtils.getCommonPrefix("abc", "abc")); 
     assertEquals("a", StringUtils.getCommonPrefix("abc", "a")); 
     assertEquals("ab", StringUtils.getCommonPrefix("ab", "abxyz")); 
     assertEquals("ab", StringUtils.getCommonPrefix("abcde", "abxyz")); 
     assertEquals("", StringUtils.getCommonPrefix("abcde", "xyz")); 
     assertEquals("", StringUtils.getCommonPrefix("xyz", "abcde")); 
     assertEquals("i am a ", StringUtils.getCommonPrefix("i am a machine", "i am a robot")); 
 }
@Test
public void testRepeat_StringInt2807() { 
     assertEquals(null, StringUtils.repeat(null, 2)); 
     assertEquals("", StringUtils.repeat("ab", 0)); 
     assertEquals("", StringUtils.repeat("", 3)); 
     assertEquals("aaa", StringUtils.repeat("a", 3)); 
     assertEquals("ababab", StringUtils.repeat("ab", 3)); 
     assertEquals("abcabcabc", StringUtils.repeat("abc", 3)); 
     final String str = StringUtils.repeat("a", 10000); 
     assertEquals(10000, str.length()); 
     assertTrue(StringUtils.containsOnly(str, new char[] { 'a' })); 
 }
@Test
public void testLeftPad_StringIntChar2809() { 
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
public void testAbbreviate_StringIntInt2818() { 
     assertEquals(null, StringUtils.abbreviate(null, 10, 12)); 
     assertEquals("", StringUtils.abbreviate("", 0, 10)); 
     assertEquals("", StringUtils.abbreviate("", 2, 10)); 
     try { 
         @SuppressWarnings("unused") 
         final String res = StringUtils.abbreviate("abcdefghij", 0, 3); 
         fail("StringUtils.abbreviate expecting IllegalArgumentException"); 
     } catch (final IllegalArgumentException ex) { 
     } 
     try { 
         @SuppressWarnings("unused") 
         final String res = StringUtils.abbreviate("abcdefghij", 5, 6); 
         fail("StringUtils.abbreviate expecting IllegalArgumentException"); 
     } catch (final IllegalArgumentException ex) { 
     } 
     final String raspberry = "raspberry peach"; 
     assertEquals("raspberry peach", StringUtils.abbreviate(raspberry, 11, 15)); 
     assertEquals(null, StringUtils.abbreviate(null, 7, 14)); 
     assertAbbreviateWithOffset("abcdefg...", -1, 10); 
     assertAbbreviateWithOffset("abcdefg...", 0, 10); 
     assertAbbreviateWithOffset("abcdefg...", 1, 10); 
     assertAbbreviateWithOffset("abcdefg...", 2, 10); 
     assertAbbreviateWithOffset("abcdefg...", 3, 10); 
     assertAbbreviateWithOffset("abcdefg...", 4, 10); 
     assertAbbreviateWithOffset("...fghi...", 5, 10); 
     assertAbbreviateWithOffset("...ghij...", 6, 10); 
     assertAbbreviateWithOffset("...hijk...", 7, 10); 
     assertAbbreviateWithOffset("...ijklmno", 8, 10); 
     assertAbbreviateWithOffset("...ijklmno", 9, 10); 
     assertAbbreviateWithOffset("...ijklmno", 10, 10); 
     assertAbbreviateWithOffset("...ijklmno", 10, 10); 
     assertAbbreviateWithOffset("...ijklmno", 11, 10); 
     assertAbbreviateWithOffset("...ijklmno", 12, 10); 
     assertAbbreviateWithOffset("...ijklmno", 13, 10); 
     assertAbbreviateWithOffset("...ijklmno", 14, 10); 
     assertAbbreviateWithOffset("...ijklmno", 15, 10); 
     assertAbbreviateWithOffset("...ijklmno", 16, 10); 
     assertAbbreviateWithOffset("...ijklmno", Integer.MAX_VALUE, 10); 
 }
@Test
public void testReplace_StringStringArrayStringArray2823() { 
     assertNull(StringUtils.replaceEach(null, new String[] { "a" }, new String[] { "b" })); 
     assertEquals(StringUtils.replaceEach("", new String[] { "a" }, new String[] { "b" }), ""); 
     assertEquals(StringUtils.replaceEach("aba", null, null), "aba"); 
     assertEquals(StringUtils.replaceEach("aba", new String[0], null), "aba"); 
     assertEquals(StringUtils.replaceEach("aba", null, new String[0]), "aba"); 
     assertEquals(StringUtils.replaceEach("aba", new String[] { "a" }, null), "aba"); 
     assertEquals(StringUtils.replaceEach("aba", new String[] { "a" }, new String[] { "" }), "b"); 
     assertEquals(StringUtils.replaceEach("aba", new String[] { null }, new String[] { "a" }), "aba"); 
     assertEquals(StringUtils.replaceEach("abcde", new String[] { "ab", "d" }, new String[] { "w", "t" }), "wcte"); 
     assertEquals(StringUtils.replaceEach("abcde", new String[] { "ab", "d" }, new String[] { "d", "t" }), "dcte"); 
     assertEquals("bcc", StringUtils.replaceEach("abc", new String[] { "a", "b" }, new String[] { "b", "c" })); 
     assertEquals("q651.506bera", StringUtils.replaceEach("d216.102oren", new String[] { "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "1", "2", "3", "4", "5", "6", "7", "8", "9" }, new String[] { "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z", "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "5", "6", "7", "8", "9", "1", "2", "3", "4" })); 
     assertEquals(StringUtils.replaceEach("aba", new String[] { "a" }, new String[] { null }), "aba"); 
     assertEquals(StringUtils.replaceEach("aba", new String[] { "a", "b" }, new String[] { "c", null }), "cbc"); 
 }
@Test
public void testReplaceOnce_StringStringString2830() { 
     assertEquals(null, StringUtils.replaceOnce(null, null, null)); 
     assertEquals(null, StringUtils.replaceOnce(null, null, "any")); 
     assertEquals(null, StringUtils.replaceOnce(null, "any", null)); 
     assertEquals(null, StringUtils.replaceOnce(null, "any", "any")); 
     assertEquals("", StringUtils.replaceOnce("", null, null)); 
     assertEquals("", StringUtils.replaceOnce("", null, "any")); 
     assertEquals("", StringUtils.replaceOnce("", "any", null)); 
     assertEquals("", StringUtils.replaceOnce("", "any", "any")); 
     assertEquals("FOO", StringUtils.replaceOnce("FOO", "", "any")); 
     assertEquals("FOO", StringUtils.replaceOnce("FOO", null, "any")); 
     assertEquals("FOO", StringUtils.replaceOnce("FOO", "F", null)); 
     assertEquals("FOO", StringUtils.replaceOnce("FOO", null, null)); 
     assertEquals("foofoo", StringUtils.replaceOnce("foofoofoo", "foo", "")); 
 }
@Test
public void testReplace_StringStringArrayStringArray2851() { 
     assertNull(StringUtils.replaceEach(null, new String[] { "a" }, new String[] { "b" })); 
     assertEquals(StringUtils.replaceEach("", new String[] { "a" }, new String[] { "b" }), ""); 
     assertEquals(StringUtils.replaceEach("aba", null, null), "aba"); 
     assertEquals(StringUtils.replaceEach("aba", new String[0], null), "aba"); 
     assertEquals(StringUtils.replaceEach("aba", null, new String[0]), "aba"); 
     assertEquals(StringUtils.replaceEach("aba", new String[] { "a" }, null), "aba"); 
     assertEquals(StringUtils.replaceEach("aba", new String[] { "a" }, new String[] { "" }), "b"); 
     assertEquals(StringUtils.replaceEach("aba", new String[] { null }, new String[] { "a" }), "aba"); 
     assertEquals(StringUtils.replaceEach("abcde", new String[] { "ab", "d" }, new String[] { "w", "t" }), "wcte"); 
     assertEquals(StringUtils.replaceEach("abcde", new String[] { "ab", "d" }, new String[] { "d", "t" }), "dcte"); 
     assertEquals("bcc", StringUtils.replaceEach("abc", new String[] { "a", "b" }, new String[] { "b", "c" })); 
     assertEquals("q651.506bera", StringUtils.replaceEach("d216.102oren", new String[] { "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "1", "2", "3", "4", "5", "6", "7", "8", "9" }, new String[] { "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z", "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "5", "6", "7", "8", "9", "1", "2", "3", "4" })); 
     assertEquals(StringUtils.replaceEach("aba", new String[] { "a" }, new String[] { null }), "aba"); 
     assertEquals(StringUtils.replaceEach("aba", new String[] { "a", "b" }, new String[] { "c", null }), "cbc"); 
 }
@Test
public void testGetCommonPrefix_StringArray2854() { 
     assertEquals("", StringUtils.getCommonPrefix((String[]) null)); 
     assertEquals("", StringUtils.getCommonPrefix()); 
     assertEquals("abc", StringUtils.getCommonPrefix("abc")); 
     assertEquals("", StringUtils.getCommonPrefix(null, null)); 
     assertEquals("", StringUtils.getCommonPrefix("", "")); 
     assertEquals("", StringUtils.getCommonPrefix("", null)); 
     assertEquals("", StringUtils.getCommonPrefix("abc", null, null)); 
     assertEquals("", StringUtils.getCommonPrefix(null, null, "abc")); 
     assertEquals("", StringUtils.getCommonPrefix("", "abc")); 
     assertEquals("", StringUtils.getCommonPrefix("abc", "")); 
     assertEquals("abc", StringUtils.getCommonPrefix("abc", "abc")); 
     assertEquals("a", StringUtils.getCommonPrefix("abc", "a")); 
     assertEquals("ab", StringUtils.getCommonPrefix("ab", "abxyz")); 
     assertEquals("ab", StringUtils.getCommonPrefix("abcde", "abxyz")); 
     assertEquals("", StringUtils.getCommonPrefix("abcde", "xyz")); 
     assertEquals("", StringUtils.getCommonPrefix("xyz", "abcde")); 
     assertEquals("i am a ", StringUtils.getCommonPrefix("i am a machine", "i am a robot")); 
 }
@Test
public void testSplit_StringChar2857() { 
     assertArrayEquals(null, StringUtils.split(null, '.')); 
     assertEquals(0, StringUtils.split("", '.').length); 
     String str = "a.b.. c"; 
     String[] res = StringUtils.split(str, '.'); 
     assertEquals(3, res.length); 
     assertEquals("a", res[0]); 
     assertEquals("b", res[1]); 
     assertEquals(" c", res[2]); 
     str = ".a."; 
     res = StringUtils.split(str, '.'); 
     assertEquals(1, res.length); 
     assertEquals("a", res[0]); 
     str = "a b c"; 
     res = StringUtils.split(str, ' '); 
     assertEquals(3, res.length); 
     assertEquals("a", res[0]); 
     assertEquals("b", res[1]); 
     assertEquals("c", res[2]); 
 }
@Test
public void testReplace_StringStringArrayStringArray2859() { 
     assertNull(StringUtils.replaceEach(null, new String[] { "a" }, new String[] { "b" })); 
     assertEquals(StringUtils.replaceEach("", new String[] { "a" }, new String[] { "b" }), ""); 
     assertEquals(StringUtils.replaceEach("aba", null, null), "aba"); 
     assertEquals(StringUtils.replaceEach("aba", new String[0], null), "aba"); 
     assertEquals(StringUtils.replaceEach("aba", null, new String[0]), "aba"); 
     assertEquals(StringUtils.replaceEach("aba", new String[] { "a" }, null), "aba"); 
     assertEquals(StringUtils.replaceEach("aba", new String[] { "a" }, new String[] { "" }), "b"); 
     assertEquals(StringUtils.replaceEach("aba", new String[] { null }, new String[] { "a" }), "aba"); 
     assertEquals(StringUtils.replaceEach("abcde", new String[] { "ab", "d" }, new String[] { "w", "t" }), "wcte"); 
     assertEquals(StringUtils.replaceEach("abcde", new String[] { "ab", "d" }, new String[] { "d", "t" }), "dcte"); 
     assertEquals("bcc", StringUtils.replaceEach("abc", new String[] { "a", "b" }, new String[] { "b", "c" })); 
     assertEquals("q651.506bera", StringUtils.replaceEach("d216.102oren", new String[] { "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "1", "2", "3", "4", "5", "6", "7", "8", "9" }, new String[] { "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z", "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "5", "6", "7", "8", "9", "1", "2", "3", "4" })); 
     assertEquals(StringUtils.replaceEach("aba", new String[] { "a" }, new String[] { null }), "aba"); 
     assertEquals(StringUtils.replaceEach("aba", new String[] { "a", "b" }, new String[] { "c", null }), "cbc"); 
 }
@Test
public void testEscapeSurrogatePairsLang8582867() throws Exception { 
     assertEquals("\\uDBFF\\uDFFD", StringEscapeUtils.escapeJava("\uDBFF\uDFFD")); 
     assertEquals("\\uDBFF\\uDFFD", StringEscapeUtils.escapeEcmaScript("\uDBFF\uDFFD")); 
 } 
@SuppressWarnings("deprecation")
@Test
public void testChomp2876() { 
     final String[][] chompCases = { { FOO_UNCAP + "\r\n", FOO_UNCAP }, { FOO_UNCAP + "\n", FOO_UNCAP }, { FOO_UNCAP + "\r", FOO_UNCAP }, { FOO_UNCAP + " \r", FOO_UNCAP + " " }, { FOO_UNCAP, FOO_UNCAP }, { FOO_UNCAP + "\n\n", FOO_UNCAP + "\n" }, { FOO_UNCAP + "\r\n\r\n", FOO_UNCAP + "\r\n" }, { "foo\nfoo", "foo\nfoo" }, { "foo\n\rfoo", "foo\n\rfoo" }, { "\n", "" }, { "\r", "" }, { "a", "a" }, { "\r\n", "" }, { "", "" }, { null, null }, { FOO_UNCAP + "\n\r", FOO_UNCAP + "\n" } }; 
     for (final String[] chompCase : chompCases) { 
         final String original = chompCase[0]; 
         final String expectedResult = chompCase[1]; 
         assertEquals("chomp(String) failed", expectedResult, StringUtils.chomp(original)); 
     } 
     assertEquals("chomp(String, String) failed", "foo", StringUtils.chomp("foobar", "bar")); 
     assertEquals("chomp(String, String) failed", "foobar", StringUtils.chomp("foobar", "baz")); 
     assertEquals("chomp(String, String) failed", "foo", StringUtils.chomp("foo", "foooo")); 
     assertEquals("chomp(String, String) failed", "foobar", StringUtils.chomp("foobar", "")); 
     assertEquals("chomp(String, String) failed", "foobar", StringUtils.chomp("foobar", null)); 
     assertEquals("chomp(String, String) failed", "", StringUtils.chomp("", "foo")); 
     assertEquals("chomp(String, String) failed", "", StringUtils.chomp("", null)); 
     assertEquals("chomp(String, String) failed", "", StringUtils.chomp("", "")); 
     assertEquals("chomp(String, String) failed", null, StringUtils.chomp(null, "foo")); 
     assertEquals("chomp(String, String) failed", null, StringUtils.chomp(null, null)); 
     assertEquals("chomp(String, String) failed", null, StringUtils.chomp(null, "")); 
     assertEquals("chomp(String, String) failed", "", StringUtils.chomp("foo", "foo")); 
     assertEquals("chomp(String, String) failed", " ", StringUtils.chomp(" foo", "foo")); 
     assertEquals("chomp(String, String) failed", "foo ", StringUtils.chomp("foo ", "foo")); 
 }
@Test
public void testReplace_StringStringArrayStringArray2877() { 
     assertNull(StringUtils.replaceEach(null, new String[] { "a" }, new String[] { "b" })); 
     assertEquals(StringUtils.replaceEach("", new String[] { "a" }, new String[] { "b" }), ""); 
     assertEquals(StringUtils.replaceEach("aba", null, null), "aba"); 
     assertEquals(StringUtils.replaceEach("aba", new String[0], null), "aba"); 
     assertEquals(StringUtils.replaceEach("aba", null, new String[0]), "aba"); 
     assertEquals(StringUtils.replaceEach("aba", new String[] { "a" }, null), "aba"); 
     assertEquals(StringUtils.replaceEach("aba", new String[] { "a" }, new String[] { "" }), "b"); 
     assertEquals(StringUtils.replaceEach("aba", new String[] { null }, new String[] { "a" }), "aba"); 
     assertEquals(StringUtils.replaceEach("abcde", new String[] { "ab", "d" }, new String[] { "w", "t" }), "wcte"); 
     assertEquals(StringUtils.replaceEach("abcde", new String[] { "ab", "d" }, new String[] { "d", "t" }), "dcte"); 
     assertEquals("bcc", StringUtils.replaceEach("abc", new String[] { "a", "b" }, new String[] { "b", "c" })); 
     assertEquals("q651.506bera", StringUtils.replaceEach("d216.102oren", new String[] { "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "1", "2", "3", "4", "5", "6", "7", "8", "9" }, new String[] { "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z", "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "5", "6", "7", "8", "9", "1", "2", "3", "4" })); 
     assertEquals(StringUtils.replaceEach("aba", new String[] { "a" }, new String[] { null }), "aba"); 
     assertEquals(StringUtils.replaceEach("aba", new String[] { "a", "b" }, new String[] { "c", null }), "cbc"); 
 }
@Test
public void testRepeat_StringInt2924() { 
     assertEquals(null, StringUtils.repeat(null, 2)); 
     assertEquals("", StringUtils.repeat("ab", 0)); 
     assertEquals("", StringUtils.repeat("", 3)); 
     assertEquals("aaa", StringUtils.repeat("a", 3)); 
     assertEquals("ababab", StringUtils.repeat("ab", 3)); 
     assertEquals("abcabcabc", StringUtils.repeat("abc", 3)); 
     final String str = StringUtils.repeat("a", 10000); 
     assertEquals(10000, str.length()); 
     assertTrue(StringUtils.containsOnly(str, new char[] { 'a' })); 
 }
@Test
public void testRepeat_StringStringInt2951() { 
     assertEquals(null, StringUtils.repeat(null, null, 2)); 
     assertEquals(null, StringUtils.repeat(null, "x", 2)); 
     assertEquals("", StringUtils.repeat("", null, 2)); 
     assertEquals("", StringUtils.repeat("ab", "", 0)); 
     assertEquals("", StringUtils.repeat("", "", 2)); 
     assertEquals("xx", StringUtils.repeat("", "x", 3)); 
     assertEquals("?, ?, ?", StringUtils.repeat("?", ", ", 3)); 
 }
@Test
public void testJoin_ArrayOfChars2958() { 
     assertEquals(null, StringUtils.join((char[]) null, ',')); 
     assertEquals("1;2", StringUtils.join(CHAR_PRIM_LIST, SEPARATOR_CHAR)); 
     assertEquals("2", StringUtils.join(CHAR_PRIM_LIST, SEPARATOR_CHAR, 1, 2)); 
 }
@Test
public void testSwapCase_String2961() { 
     assertEquals(null, StringUtils.swapCase(null)); 
     assertEquals("", StringUtils.swapCase("")); 
     assertEquals("  ", StringUtils.swapCase("  ")); 
     assertEquals("i", WordUtils.swapCase("I")); 
     assertEquals("I", WordUtils.swapCase("i")); 
     assertEquals("I AM HERE 123", StringUtils.swapCase("i am here 123")); 
     assertEquals("i aM hERE 123", StringUtils.swapCase("I Am Here 123")); 
     assertEquals("I AM here 123", StringUtils.swapCase("i am HERE 123")); 
     assertEquals("i am here 123", StringUtils.swapCase("I AM HERE 123")); 
     final String test = "This String contains a TitleCase character: \u01C8"; 
     final String expect = "tHIS sTRING CONTAINS A tITLEcASE CHARACTER: \u01C9"; 
     assertEquals(expect, WordUtils.swapCase(test)); 
 }
@Test
public void testJoin_IterableChar2978() { 
     assertEquals(null, StringUtils.join((Iterable<?>) null, ',')); 
     assertEquals(TEXT_LIST_CHAR, StringUtils.join(Arrays.asList(ARRAY_LIST), SEPARATOR_CHAR)); 
     assertEquals("", StringUtils.join(Arrays.asList(NULL_ARRAY_LIST), SEPARATOR_CHAR)); 
     assertEquals("", StringUtils.join(Arrays.asList(EMPTY_ARRAY_LIST), SEPARATOR_CHAR)); 
     assertEquals("foo", StringUtils.join(Collections.singleton("foo"), 'x')); 
 }
@Test
public void testIsAllLowerCase2979() { 
     assertFalse(StringUtils.isAllLowerCase(null)); 
     assertFalse(StringUtils.isAllLowerCase(StringUtils.EMPTY)); 
     assertTrue(StringUtils.isAllLowerCase("abc")); 
     assertFalse(StringUtils.isAllLowerCase("abc ")); 
     assertFalse(StringUtils.isAllLowerCase("abC")); 
 }
@Test
public void testAbbreviate_StringIntInt2991() { 
     assertEquals(null, StringUtils.abbreviate(null, 10, 12)); 
     assertEquals("", StringUtils.abbreviate("", 0, 10)); 
     assertEquals("", StringUtils.abbreviate("", 2, 10)); 
     try { 
         @SuppressWarnings("unused") 
         final String res = StringUtils.abbreviate("abcdefghij", 0, 3); 
         fail("StringUtils.abbreviate expecting IllegalArgumentException"); 
     } catch (final IllegalArgumentException ex) { 
     } 
     try { 
         @SuppressWarnings("unused") 
         final String res = StringUtils.abbreviate("abcdefghij", 5, 6); 
         fail("StringUtils.abbreviate expecting IllegalArgumentException"); 
     } catch (final IllegalArgumentException ex) { 
     } 
     final String raspberry = "raspberry peach"; 
     assertEquals("raspberry peach", StringUtils.abbreviate(raspberry, 11, 15)); 
     assertEquals(null, StringUtils.abbreviate(null, 7, 14)); 
     assertAbbreviateWithOffset("abcdefg...", -1, 10); 
     assertAbbreviateWithOffset("abcdefg...", 0, 10); 
     assertAbbreviateWithOffset("abcdefg...", 1, 10); 
     assertAbbreviateWithOffset("abcdefg...", 2, 10); 
     assertAbbreviateWithOffset("abcdefg...", 3, 10); 
     assertAbbreviateWithOffset("abcdefg...", 4, 10); 
     assertAbbreviateWithOffset("...fghi...", 5, 10); 
     assertAbbreviateWithOffset("...ghij...", 6, 10); 
     assertAbbreviateWithOffset("...hijk...", 7, 10); 
     assertAbbreviateWithOffset("...ijklmno", 8, 10); 
     assertAbbreviateWithOffset("...ijklmno", 9, 10); 
     assertAbbreviateWithOffset("...ijklmno", 10, 10); 
     assertAbbreviateWithOffset("...ijklmno", 10, 10); 
     assertAbbreviateWithOffset("...ijklmno", 11, 10); 
     assertAbbreviateWithOffset("...ijklmno", 12, 10); 
     assertAbbreviateWithOffset("...ijklmno", 13, 10); 
     assertAbbreviateWithOffset("...ijklmno", 14, 10); 
     assertAbbreviateWithOffset("...ijklmno", 15, 10); 
     assertAbbreviateWithOffset("...ijklmno", 16, 10); 
     assertAbbreviateWithOffset("...ijklmno", Integer.MAX_VALUE, 10); 
 }
@Test
public void testReplace_StringStringStringInt2993() { 
     assertEquals(null, StringUtils.replace(null, null, null, 2)); 
     assertEquals(null, StringUtils.replace(null, null, "any", 2)); 
     assertEquals(null, StringUtils.replace(null, "any", null, 2)); 
     assertEquals(null, StringUtils.replace(null, "any", "any", 2)); 
     assertEquals("", StringUtils.replace("", null, null, 2)); 
     assertEquals("", StringUtils.replace("", null, "any", 2)); 
     assertEquals("", StringUtils.replace("", "any", null, 2)); 
     assertEquals("", StringUtils.replace("", "any", "any", 2)); 
     final String str = new String(new char[] { 'o', 'o', 'f', 'o', 'o' }); 
     assertSame(str, StringUtils.replace(str, "x", "", -1)); 
     assertEquals("f", StringUtils.replace("oofoo", "o", "", -1)); 
     assertEquals("oofoo", StringUtils.replace("oofoo", "o", "", 0)); 
     assertEquals("ofoo", StringUtils.replace("oofoo", "o", "", 1)); 
     assertEquals("foo", StringUtils.replace("oofoo", "o", "", 2)); 
     assertEquals("fo", StringUtils.replace("oofoo", "o", "", 3)); 
     assertEquals("f", StringUtils.replace("oofoo", "o", "", 4)); 
     assertEquals("f", StringUtils.replace("oofoo", "o", "", -5)); 
     assertEquals("f", StringUtils.replace("oofoo", "o", "", 1000)); 
 }
@Test
public void testRemoveStart3001() { 
     assertNull(StringUtils.removeStart(null, null)); 
     assertNull(StringUtils.removeStart(null, "")); 
     assertNull(StringUtils.removeStart(null, "a")); 
     assertEquals(StringUtils.removeStart("", null), ""); 
     assertEquals(StringUtils.removeStart("", ""), ""); 
     assertEquals(StringUtils.removeStart("", "a"), ""); 
     assertEquals(StringUtils.removeStart("www.domain.com", "www."), "domain.com"); 
     assertEquals(StringUtils.removeStart("domain.com", "www."), "domain.com"); 
     assertEquals(StringUtils.removeStart("domain.com", ""), "domain.com"); 
     assertEquals(StringUtils.removeStart("domain.com", null), "domain.com"); 
 }
@Test
public void testReplaceOnce_StringStringString3004() { 
     assertEquals(null, StringUtils.replaceOnce(null, null, null)); 
     assertEquals(null, StringUtils.replaceOnce(null, null, "any")); 
     assertEquals(null, StringUtils.replaceOnce(null, "any", null)); 
     assertEquals(null, StringUtils.replaceOnce(null, "any", "any")); 
     assertEquals("", StringUtils.replaceOnce("", null, null)); 
     assertEquals("", StringUtils.replaceOnce("", null, "any")); 
     assertEquals("", StringUtils.replaceOnce("", "any", null)); 
     assertEquals("", StringUtils.replaceOnce("", "any", "any")); 
     assertEquals("FOO", StringUtils.replaceOnce("FOO", "", "any")); 
     assertEquals("FOO", StringUtils.replaceOnce("FOO", null, "any")); 
     assertEquals("FOO", StringUtils.replaceOnce("FOO", "F", null)); 
     assertEquals("FOO", StringUtils.replaceOnce("FOO", null, null)); 
     assertEquals("foofoo", StringUtils.replaceOnce("foofoofoo", "foo", "")); 
 }
@Test
public void testJoin_IteratorChar3008() { 
     assertEquals(null, StringUtils.join((Iterator<?>) null, ',')); 
     assertEquals(TEXT_LIST_CHAR, StringUtils.join(Arrays.asList(ARRAY_LIST).iterator(), SEPARATOR_CHAR)); 
     assertEquals("", StringUtils.join(Arrays.asList(NULL_ARRAY_LIST).iterator(), SEPARATOR_CHAR)); 
     assertEquals("", StringUtils.join(Arrays.asList(EMPTY_ARRAY_LIST).iterator(), SEPARATOR_CHAR)); 
     assertEquals("foo", StringUtils.join(Collections.singleton("foo").iterator(), 'x')); 
 }
@Test
public void testRemoveStart3014() { 
     assertNull(StringUtils.removeStart(null, null)); 
     assertNull(StringUtils.removeStart(null, "")); 
     assertNull(StringUtils.removeStart(null, "a")); 
     assertEquals(StringUtils.removeStart("", null), ""); 
     assertEquals(StringUtils.removeStart("", ""), ""); 
     assertEquals(StringUtils.removeStart("", "a"), ""); 
     assertEquals(StringUtils.removeStart("www.domain.com", "www."), "domain.com"); 
     assertEquals(StringUtils.removeStart("domain.com", "www."), "domain.com"); 
     assertEquals(StringUtils.removeStart("domain.com", ""), "domain.com"); 
     assertEquals(StringUtils.removeStart("domain.com", null), "domain.com"); 
 } 
@SuppressWarnings("deprecation")
@Test
public void testChomp3034() { 
     final String[][] chompCases = { { FOO_UNCAP + "\r\n", FOO_UNCAP }, { FOO_UNCAP + "\n", FOO_UNCAP }, { FOO_UNCAP + "\r", FOO_UNCAP }, { FOO_UNCAP + " \r", FOO_UNCAP + " " }, { FOO_UNCAP, FOO_UNCAP }, { FOO_UNCAP + "\n\n", FOO_UNCAP + "\n" }, { FOO_UNCAP + "\r\n\r\n", FOO_UNCAP + "\r\n" }, { "foo\nfoo", "foo\nfoo" }, { "foo\n\rfoo", "foo\n\rfoo" }, { "\n", "" }, { "\r", "" }, { "a", "a" }, { "\r\n", "" }, { "", "" }, { null, null }, { FOO_UNCAP + "\n\r", FOO_UNCAP + "\n" } }; 
     for (final String[] chompCase : chompCases) { 
         final String original = chompCase[0]; 
         final String expectedResult = chompCase[1]; 
         assertEquals("chomp(String) failed", expectedResult, StringUtils.chomp(original)); 
     } 
     assertEquals("chomp(String, String) failed", "foo", StringUtils.chomp("foobar", "bar")); 
     assertEquals("chomp(String, String) failed", "foobar", StringUtils.chomp("foobar", "baz")); 
     assertEquals("chomp(String, String) failed", "foo", StringUtils.chomp("foo", "foooo")); 
     assertEquals("chomp(String, String) failed", "foobar", StringUtils.chomp("foobar", "")); 
     assertEquals("chomp(String, String) failed", "foobar", StringUtils.chomp("foobar", null)); 
     assertEquals("chomp(String, String) failed", "", StringUtils.chomp("", "foo")); 
     assertEquals("chomp(String, String) failed", "", StringUtils.chomp("", null)); 
     assertEquals("chomp(String, String) failed", "", StringUtils.chomp("", "")); 
     assertEquals("chomp(String, String) failed", null, StringUtils.chomp(null, "foo")); 
     assertEquals("chomp(String, String) failed", null, StringUtils.chomp(null, null)); 
     assertEquals("chomp(String, String) failed", null, StringUtils.chomp(null, "")); 
     assertEquals("chomp(String, String) failed", "", StringUtils.chomp("foo", "foo")); 
     assertEquals("chomp(String, String) failed", " ", StringUtils.chomp(" foo", "foo")); 
     assertEquals("chomp(String, String) failed", "foo ", StringUtils.chomp("foo ", "foo")); 
 }
@Test
public void testSplitByCharacterType3035() { 
     assertNull(StringUtils.splitByCharacterType(null)); 
     assertEquals(0, StringUtils.splitByCharacterType("").length); 
     assertTrue(ArrayUtils.isEquals(new String[] { "ab", " ", "de", " ", "fg" }, StringUtils.splitByCharacterType("ab de fg"))); 
     assertTrue(ArrayUtils.isEquals(new String[] { "ab", "   ", "de", " ", "fg" }, StringUtils.splitByCharacterType("ab   de fg"))); 
     assertTrue(ArrayUtils.isEquals(new String[] { "ab", ":", "cd", ":", "ef" }, StringUtils.splitByCharacterType("ab:cd:ef"))); 
     assertTrue(ArrayUtils.isEquals(new String[] { "number", "5" }, StringUtils.splitByCharacterType("number5"))); 
     assertTrue(ArrayUtils.isEquals(new String[] { "foo", "B", "ar" }, StringUtils.splitByCharacterType("fooBar"))); 
     assertTrue(ArrayUtils.isEquals(new String[] { "foo", "200", "B", "ar" }, StringUtils.splitByCharacterType("foo200Bar"))); 
     assertTrue(ArrayUtils.isEquals(new String[] { "ASFR", "ules" }, StringUtils.splitByCharacterType("ASFRules"))); 
 }
@Test
public void testJoin_ArrayOfLongs3042() { 
     assertEquals(null, StringUtils.join((long[]) null, ',')); 
     assertEquals("1;2", StringUtils.join(LONG_PRIM_LIST, SEPARATOR_CHAR)); 
     assertEquals("2", StringUtils.join(LONG_PRIM_LIST, SEPARATOR_CHAR, 1, 2)); 
 }
@Test
public void testAbbreviate_StringIntInt3046() { 
     assertEquals(null, StringUtils.abbreviate(null, 10, 12)); 
     assertEquals("", StringUtils.abbreviate("", 0, 10)); 
     assertEquals("", StringUtils.abbreviate("", 2, 10)); 
     try { 
         @SuppressWarnings("unused") 
         final String res = StringUtils.abbreviate("abcdefghij", 0, 3); 
         fail("StringUtils.abbreviate expecting IllegalArgumentException"); 
     } catch (final IllegalArgumentException ex) { 
     } 
     try { 
         @SuppressWarnings("unused") 
         final String res = StringUtils.abbreviate("abcdefghij", 5, 6); 
         fail("StringUtils.abbreviate expecting IllegalArgumentException"); 
     } catch (final IllegalArgumentException ex) { 
     } 
     final String raspberry = "raspberry peach"; 
     assertEquals("raspberry peach", StringUtils.abbreviate(raspberry, 11, 15)); 
     assertEquals(null, StringUtils.abbreviate(null, 7, 14)); 
     assertAbbreviateWithOffset("abcdefg...", -1, 10); 
     assertAbbreviateWithOffset("abcdefg...", 0, 10); 
     assertAbbreviateWithOffset("abcdefg...", 1, 10); 
     assertAbbreviateWithOffset("abcdefg...", 2, 10); 
     assertAbbreviateWithOffset("abcdefg...", 3, 10); 
     assertAbbreviateWithOffset("abcdefg...", 4, 10); 
     assertAbbreviateWithOffset("...fghi...", 5, 10); 
     assertAbbreviateWithOffset("...ghij...", 6, 10); 
     assertAbbreviateWithOffset("...hijk...", 7, 10); 
     assertAbbreviateWithOffset("...ijklmno", 8, 10); 
     assertAbbreviateWithOffset("...ijklmno", 9, 10); 
     assertAbbreviateWithOffset("...ijklmno", 10, 10); 
     assertAbbreviateWithOffset("...ijklmno", 10, 10); 
     assertAbbreviateWithOffset("...ijklmno", 11, 10); 
     assertAbbreviateWithOffset("...ijklmno", 12, 10); 
     assertAbbreviateWithOffset("...ijklmno", 13, 10); 
     assertAbbreviateWithOffset("...ijklmno", 14, 10); 
     assertAbbreviateWithOffset("...ijklmno", 15, 10); 
     assertAbbreviateWithOffset("...ijklmno", 16, 10); 
     assertAbbreviateWithOffset("...ijklmno", Integer.MAX_VALUE, 10); 
 }
@Test
public void testRemoveEndIgnoreCase3051() { 
     assertNull("removeEndIgnoreCase(null, null)", StringUtils.removeEndIgnoreCase(null, null)); 
     assertNull("removeEndIgnoreCase(null, \"\")", StringUtils.removeEndIgnoreCase(null, "")); 
     assertNull("removeEndIgnoreCase(null, \"a\")", StringUtils.removeEndIgnoreCase(null, "a")); 
     assertEquals("removeEndIgnoreCase(\"\", null)", StringUtils.removeEndIgnoreCase("", null), ""); 
     assertEquals("removeEndIgnoreCase(\"\", \"\")", StringUtils.removeEndIgnoreCase("", ""), ""); 
     assertEquals("removeEndIgnoreCase(\"\", \"a\")", StringUtils.removeEndIgnoreCase("", "a"), ""); 
     assertEquals("removeEndIgnoreCase(\"www.domain.com.\", \".com\")", StringUtils.removeEndIgnoreCase("www.domain.com.", ".com"), "www.domain.com."); 
     assertEquals("removeEndIgnoreCase(\"www.domain.com\", \".com\")", StringUtils.removeEndIgnoreCase("www.domain.com", ".com"), "www.domain"); 
     assertEquals("removeEndIgnoreCase(\"www.domain\", \".com\")", StringUtils.removeEndIgnoreCase("www.domain", ".com"), "www.domain"); 
     assertEquals("removeEndIgnoreCase(\"domain.com\", \"\")", StringUtils.removeEndIgnoreCase("domain.com", ""), "domain.com"); 
     assertEquals("removeEndIgnoreCase(\"domain.com\", null)", StringUtils.removeEndIgnoreCase("domain.com", null), "domain.com"); 
     assertEquals("removeEndIgnoreCase(\"www.domain.com\", \".COM\")", StringUtils.removeEndIgnoreCase("www.domain.com", ".COM"), "www.domain"); 
     assertEquals("removeEndIgnoreCase(\"www.domain.COM\", \".com\")", StringUtils.removeEndIgnoreCase("www.domain.COM", ".com"), "www.domain"); 
 }
@Test
public void testOverlay_StringStringIntInt3052() { 
     assertEquals(null, StringUtils.overlay(null, null, 2, 4)); 
     assertEquals(null, StringUtils.overlay(null, null, -2, -4)); 
     assertEquals("", StringUtils.overlay("", null, 0, 0)); 
     assertEquals("", StringUtils.overlay("", "", 0, 0)); 
     assertEquals("zzzz", StringUtils.overlay("", "zzzz", 0, 0)); 
     assertEquals("zzzz", StringUtils.overlay("", "zzzz", 2, 4)); 
     assertEquals("zzzz", StringUtils.overlay("", "zzzz", -2, -4)); 
     assertEquals("abef", StringUtils.overlay("abcdef", null, 2, 4)); 
     assertEquals("abef", StringUtils.overlay("abcdef", null, 4, 2)); 
     assertEquals("abef", StringUtils.overlay("abcdef", "", 2, 4)); 
     assertEquals("abef", StringUtils.overlay("abcdef", "", 4, 2)); 
     assertEquals("abzzzzef", StringUtils.overlay("abcdef", "zzzz", 2, 4)); 
     assertEquals("abzzzzef", StringUtils.overlay("abcdef", "zzzz", 4, 2)); 
     assertEquals("zzzzef", StringUtils.overlay("abcdef", "zzzz", -1, 4)); 
     assertEquals("zzzzef", StringUtils.overlay("abcdef", "zzzz", 4, -1)); 
     assertEquals("zzzzabcdef", StringUtils.overlay("abcdef", "zzzz", -2, -1)); 
     assertEquals("zzzzabcdef", StringUtils.overlay("abcdef", "zzzz", -1, -2)); 
     assertEquals("abcdzzzz", StringUtils.overlay("abcdef", "zzzz", 4, 10)); 
     assertEquals("abcdzzzz", StringUtils.overlay("abcdef", "zzzz", 10, 4)); 
     assertEquals("abcdefzzzz", StringUtils.overlay("abcdef", "zzzz", 8, 10)); 
     assertEquals("abcdefzzzz", StringUtils.overlay("abcdef", "zzzz", 10, 8)); 
 }
@Test
public void testOverlay_StringStringIntInt3055() { 
     assertEquals(null, StringUtils.overlay(null, null, 2, 4)); 
     assertEquals(null, StringUtils.overlay(null, null, -2, -4)); 
     assertEquals("", StringUtils.overlay("", null, 0, 0)); 
     assertEquals("", StringUtils.overlay("", "", 0, 0)); 
     assertEquals("zzzz", StringUtils.overlay("", "zzzz", 0, 0)); 
     assertEquals("zzzz", StringUtils.overlay("", "zzzz", 2, 4)); 
     assertEquals("zzzz", StringUtils.overlay("", "zzzz", -2, -4)); 
     assertEquals("abef", StringUtils.overlay("abcdef", null, 2, 4)); 
     assertEquals("abef", StringUtils.overlay("abcdef", null, 4, 2)); 
     assertEquals("abef", StringUtils.overlay("abcdef", "", 2, 4)); 
     assertEquals("abef", StringUtils.overlay("abcdef", "", 4, 2)); 
     assertEquals("abzzzzef", StringUtils.overlay("abcdef", "zzzz", 2, 4)); 
     assertEquals("abzzzzef", StringUtils.overlay("abcdef", "zzzz", 4, 2)); 
     assertEquals("zzzzef", StringUtils.overlay("abcdef", "zzzz", -1, 4)); 
     assertEquals("zzzzef", StringUtils.overlay("abcdef", "zzzz", 4, -1)); 
     assertEquals("zzzzabcdef", StringUtils.overlay("abcdef", "zzzz", -2, -1)); 
     assertEquals("zzzzabcdef", StringUtils.overlay("abcdef", "zzzz", -1, -2)); 
     assertEquals("abcdzzzz", StringUtils.overlay("abcdef", "zzzz", 4, 10)); 
     assertEquals("abcdzzzz", StringUtils.overlay("abcdef", "zzzz", 10, 4)); 
     assertEquals("abcdefzzzz", StringUtils.overlay("abcdef", "zzzz", 8, 10)); 
     assertEquals("abcdefzzzz", StringUtils.overlay("abcdef", "zzzz", 10, 8)); 
 }
@Test
public void testAbbreviateMiddle3077() { 
     assertNull(StringUtils.abbreviateMiddle(null, null, 0)); 
     assertEquals("abc", StringUtils.abbreviateMiddle("abc", null, 0)); 
     assertEquals("abc", StringUtils.abbreviateMiddle("abc", ".", 0)); 
     assertEquals("abc", StringUtils.abbreviateMiddle("abc", ".", 3)); 
     assertEquals("ab.f", StringUtils.abbreviateMiddle("abcdef", ".", 4)); 
     assertEquals("A very long text with un...f the text is complete.", StringUtils.abbreviateMiddle("A very long text with unimportant stuff in the middle but interesting start and " + "end to see if the text is complete.", "...", 50)); 
     final String longText = "Start text" + StringUtils.repeat("x", 10000) + "Close text"; 
     assertEquals("Start text->Close text", StringUtils.abbreviateMiddle(longText, "->", 22)); 
     assertEquals("abc", StringUtils.abbreviateMiddle("abc", ".", -1)); 
     assertEquals("abc", StringUtils.abbreviateMiddle("abc", ".", 1)); 
     assertEquals("abc", StringUtils.abbreviateMiddle("abc", ".", 2)); 
     assertEquals("a", StringUtils.abbreviateMiddle("a", ".", 1)); 
     assertEquals("a.d", StringUtils.abbreviateMiddle("abcd", ".", 3)); 
     assertEquals("a..f", StringUtils.abbreviateMiddle("abcdef", "..", 4)); 
     assertEquals("ab.ef", StringUtils.abbreviateMiddle("abcdef", ".", 5)); 
 } 
@SuppressWarnings("deprecation")
@Test
public void testChomp3087() { 
     final String[][] chompCases = { { FOO_UNCAP + "\r\n", FOO_UNCAP }, { FOO_UNCAP + "\n", FOO_UNCAP }, { FOO_UNCAP + "\r", FOO_UNCAP }, { FOO_UNCAP + " \r", FOO_UNCAP + " " }, { FOO_UNCAP, FOO_UNCAP }, { FOO_UNCAP + "\n\n", FOO_UNCAP + "\n" }, { FOO_UNCAP + "\r\n\r\n", FOO_UNCAP + "\r\n" }, { "foo\nfoo", "foo\nfoo" }, { "foo\n\rfoo", "foo\n\rfoo" }, { "\n", "" }, { "\r", "" }, { "a", "a" }, { "\r\n", "" }, { "", "" }, { null, null }, { FOO_UNCAP + "\n\r", FOO_UNCAP + "\n" } }; 
     for (final String[] chompCase : chompCases) { 
         final String original = chompCase[0]; 
         final String expectedResult = chompCase[1]; 
         assertEquals("chomp(String) failed", expectedResult, StringUtils.chomp(original)); 
     } 
     assertEquals("chomp(String, String) failed", "foo", StringUtils.chomp("foobar", "bar")); 
     assertEquals("chomp(String, String) failed", "foobar", StringUtils.chomp("foobar", "baz")); 
     assertEquals("chomp(String, String) failed", "foo", StringUtils.chomp("foo", "foooo")); 
     assertEquals("chomp(String, String) failed", "foobar", StringUtils.chomp("foobar", "")); 
     assertEquals("chomp(String, String) failed", "foobar", StringUtils.chomp("foobar", null)); 
     assertEquals("chomp(String, String) failed", "", StringUtils.chomp("", "foo")); 
     assertEquals("chomp(String, String) failed", "", StringUtils.chomp("", null)); 
     assertEquals("chomp(String, String) failed", "", StringUtils.chomp("", "")); 
     assertEquals("chomp(String, String) failed", null, StringUtils.chomp(null, "foo")); 
     assertEquals("chomp(String, String) failed", null, StringUtils.chomp(null, null)); 
     assertEquals("chomp(String, String) failed", null, StringUtils.chomp(null, "")); 
     assertEquals("chomp(String, String) failed", "", StringUtils.chomp("foo", "foo")); 
     assertEquals("chomp(String, String) failed", " ", StringUtils.chomp(" foo", "foo")); 
     assertEquals("chomp(String, String) failed", "foo ", StringUtils.chomp("foo ", "foo")); 
 }
@Test
public void testReplaceChars_StringStringString3089() { 
     assertEquals(null, StringUtils.replaceChars(null, null, null)); 
     assertEquals(null, StringUtils.replaceChars(null, "", null)); 
     assertEquals(null, StringUtils.replaceChars(null, "a", null)); 
     assertEquals(null, StringUtils.replaceChars(null, null, "")); 
     assertEquals(null, StringUtils.replaceChars(null, null, "x")); 
     assertEquals("", StringUtils.replaceChars("", null, null)); 
     assertEquals("", StringUtils.replaceChars("", "", null)); 
     assertEquals("", StringUtils.replaceChars("", "a", null)); 
     assertEquals("", StringUtils.replaceChars("", null, "")); 
     assertEquals("", StringUtils.replaceChars("", null, "x")); 
     assertEquals("abc", StringUtils.replaceChars("abc", null, null)); 
     assertEquals("abc", StringUtils.replaceChars("abc", null, "")); 
     assertEquals("abc", StringUtils.replaceChars("abc", null, "x")); 
     assertEquals("abc", StringUtils.replaceChars("abc", "", null)); 
     assertEquals("abc", StringUtils.replaceChars("abc", "", "")); 
     assertEquals("abc", StringUtils.replaceChars("abc", "", "x")); 
     assertEquals("ac", StringUtils.replaceChars("abc", "b", null)); 
     assertEquals("ac", StringUtils.replaceChars("abc", "b", "")); 
     assertEquals("axc", StringUtils.replaceChars("abc", "b", "x")); 
     assertEquals("ayzya", StringUtils.replaceChars("abcba", "bc", "yz")); 
     assertEquals("ayya", StringUtils.replaceChars("abcba", "bc", "y")); 
     assertEquals("ayzya", StringUtils.replaceChars("abcba", "bc", "yzx")); 
     assertEquals("abcba", StringUtils.replaceChars("abcba", "z", "w")); 
     assertSame("abcba", StringUtils.replaceChars("abcba", "z", "w")); 
     assertEquals("jelly", StringUtils.replaceChars("hello", "ho", "jy")); 
     assertEquals("ayzya", StringUtils.replaceChars("abcba", "bc", "yz")); 
     assertEquals("ayya", StringUtils.replaceChars("abcba", "bc", "y")); 
     assertEquals("ayzya", StringUtils.replaceChars("abcba", "bc", "yzx")); 
     assertEquals("bcc", StringUtils.replaceChars("abc", "ab", "bc")); 
     assertEquals("q651.506bera", StringUtils.replaceChars("d216.102oren", "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ123456789", "nopqrstuvwxyzabcdefghijklmNOPQRSTUVWXYZABCDEFGHIJKLM567891234")); 
 }
@Test
public void testGetCommonPrefix_StringArray3095() { 
     assertEquals("", StringUtils.getCommonPrefix((String[]) null)); 
     assertEquals("", StringUtils.getCommonPrefix()); 
     assertEquals("abc", StringUtils.getCommonPrefix("abc")); 
     assertEquals("", StringUtils.getCommonPrefix(null, null)); 
     assertEquals("", StringUtils.getCommonPrefix("", "")); 
     assertEquals("", StringUtils.getCommonPrefix("", null)); 
     assertEquals("", StringUtils.getCommonPrefix("abc", null, null)); 
     assertEquals("", StringUtils.getCommonPrefix(null, null, "abc")); 
     assertEquals("", StringUtils.getCommonPrefix("", "abc")); 
     assertEquals("", StringUtils.getCommonPrefix("abc", "")); 
     assertEquals("abc", StringUtils.getCommonPrefix("abc", "abc")); 
     assertEquals("a", StringUtils.getCommonPrefix("abc", "a")); 
     assertEquals("ab", StringUtils.getCommonPrefix("ab", "abxyz")); 
     assertEquals("ab", StringUtils.getCommonPrefix("abcde", "abxyz")); 
     assertEquals("", StringUtils.getCommonPrefix("abcde", "xyz")); 
     assertEquals("", StringUtils.getCommonPrefix("xyz", "abcde")); 
     assertEquals("i am a ", StringUtils.getCommonPrefix("i am a machine", "i am a robot")); 
 }
@Test
public void testReplace_StringStringArrayStringArray3103() { 
     assertNull(StringUtils.replaceEach(null, new String[] { "a" }, new String[] { "b" })); 
     assertEquals(StringUtils.replaceEach("", new String[] { "a" }, new String[] { "b" }), ""); 
     assertEquals(StringUtils.replaceEach("aba", null, null), "aba"); 
     assertEquals(StringUtils.replaceEach("aba", new String[0], null), "aba"); 
     assertEquals(StringUtils.replaceEach("aba", null, new String[0]), "aba"); 
     assertEquals(StringUtils.replaceEach("aba", new String[] { "a" }, null), "aba"); 
     assertEquals(StringUtils.replaceEach("aba", new String[] { "a" }, new String[] { "" }), "b"); 
     assertEquals(StringUtils.replaceEach("aba", new String[] { null }, new String[] { "a" }), "aba"); 
     assertEquals(StringUtils.replaceEach("abcde", new String[] { "ab", "d" }, new String[] { "w", "t" }), "wcte"); 
     assertEquals(StringUtils.replaceEach("abcde", new String[] { "ab", "d" }, new String[] { "d", "t" }), "dcte"); 
     assertEquals("bcc", StringUtils.replaceEach("abc", new String[] { "a", "b" }, new String[] { "b", "c" })); 
     assertEquals("q651.506bera", StringUtils.replaceEach("d216.102oren", new String[] { "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "1", "2", "3", "4", "5", "6", "7", "8", "9" }, new String[] { "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z", "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "5", "6", "7", "8", "9", "1", "2", "3", "4" })); 
     assertEquals(StringUtils.replaceEach("aba", new String[] { "a" }, new String[] { null }), "aba"); 
     assertEquals(StringUtils.replaceEach("aba", new String[] { "a", "b" }, new String[] { "c", null }), "cbc"); 
 }
@Test
public void testGetLevenshteinDistance_StringStringInt3106() { 
     assertEquals(0, StringUtils.getLevenshteinDistance("", "", 0)); 
     assertEquals(7, StringUtils.getLevenshteinDistance("aaapppp", "", 8)); 
     assertEquals(7, StringUtils.getLevenshteinDistance("aaapppp", "", 7)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("aaapppp", "", 6)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("b", "a", 0)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("a", "b", 0)); 
     assertEquals(0, StringUtils.getLevenshteinDistance("aa", "aa", 0)); 
     assertEquals(0, StringUtils.getLevenshteinDistance("aa", "aa", 2)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("aaa", "bbb", 2)); 
     assertEquals(3, StringUtils.getLevenshteinDistance("aaa", "bbb", 3)); 
     assertEquals(6, StringUtils.getLevenshteinDistance("aaaaaa", "b", 10)); 
     assertEquals(7, StringUtils.getLevenshteinDistance("aaapppp", "b", 8)); 
     assertEquals(3, StringUtils.getLevenshteinDistance("a", "bbb", 4)); 
     assertEquals(7, StringUtils.getLevenshteinDistance("aaapppp", "b", 7)); 
     assertEquals(3, StringUtils.getLevenshteinDistance("a", "bbb", 3)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("a", "bbb", 2)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("bbb", "a", 2)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("aaapppp", "b", 6)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("a", "bbb", 1)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("bbb", "a", 1)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("12345", "1234567", 1)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("1234567", "12345", 1)); 
     assertEquals(1, StringUtils.getLevenshteinDistance("frog", "fog", 1)); 
     assertEquals(3, StringUtils.getLevenshteinDistance("fly", "ant", 3)); 
     assertEquals(7, StringUtils.getLevenshteinDistance("elephant", "hippo", 7)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("elephant", "hippo", 6)); 
     assertEquals(7, StringUtils.getLevenshteinDistance("hippo", "elephant", 7)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("hippo", "elephant", 6)); 
     assertEquals(8, StringUtils.getLevenshteinDistance("hippo", "zzzzzzzz", 8)); 
     assertEquals(8, StringUtils.getLevenshteinDistance("zzzzzzzz", "hippo", 8)); 
     assertEquals(1, StringUtils.getLevenshteinDistance("hello", "hallo", 1)); 
     try { 
         @SuppressWarnings("unused") 
         final int d = StringUtils.getLevenshteinDistance("a", null, 0); 
         fail("expecting IllegalArgumentException"); 
     } catch (final IllegalArgumentException ex) { 
     } 
     try { 
         @SuppressWarnings("unused") 
         final int d = StringUtils.getLevenshteinDistance(null, "a", 0); 
         fail("expecting IllegalArgumentException"); 
     } catch (final IllegalArgumentException ex) { 
     } 
     try { 
         @SuppressWarnings("unused") 
         final int d = StringUtils.getLevenshteinDistance("a", "a", -1); 
         fail("expecting IllegalArgumentException"); 
     } catch (final IllegalArgumentException ex) { 
     } 
 }
@Test
public void testJoin_ArrayOfLongs3112() { 
     assertEquals(null, StringUtils.join((long[]) null, ',')); 
     assertEquals("1;2", StringUtils.join(LONG_PRIM_LIST, SEPARATOR_CHAR)); 
     assertEquals("2", StringUtils.join(LONG_PRIM_LIST, SEPARATOR_CHAR, 1, 2)); 
 }
@Test
public void testJoin_ArrayOfFloats3123() { 
     assertEquals(null, StringUtils.join((float[]) null, ',')); 
     assertEquals("1.0;2.0", StringUtils.join(FLOAT_PRIM_LIST, SEPARATOR_CHAR)); 
     assertEquals("2.0", StringUtils.join(FLOAT_PRIM_LIST, SEPARATOR_CHAR, 1, 2)); 
 }
@Test
public void testRepeat_StringInt3125() { 
     assertEquals(null, StringUtils.repeat(null, 2)); 
     assertEquals("", StringUtils.repeat("ab", 0)); 
     assertEquals("", StringUtils.repeat("", 3)); 
     assertEquals("aaa", StringUtils.repeat("a", 3)); 
     assertEquals("ababab", StringUtils.repeat("ab", 3)); 
     assertEquals("abcabcabc", StringUtils.repeat("abc", 3)); 
     final String str = StringUtils.repeat("a", 10000); 
     assertEquals(10000, str.length()); 
     assertTrue(StringUtils.containsOnly(str, new char[] { 'a' })); 
 }
@Test
public void testIsAllUpperCase3137() { 
     assertFalse(StringUtils.isAllUpperCase(null)); 
     assertFalse(StringUtils.isAllUpperCase(StringUtils.EMPTY)); 
     assertTrue(StringUtils.isAllUpperCase("ABC")); 
     assertFalse(StringUtils.isAllUpperCase("ABC ")); 
     assertFalse(StringUtils.isAllUpperCase("aBC")); 
 }
@Test
public void testRepeat_StringInt3153() { 
     assertEquals(null, StringUtils.repeat(null, 2)); 
     assertEquals("", StringUtils.repeat("ab", 0)); 
     assertEquals("", StringUtils.repeat("", 3)); 
     assertEquals("aaa", StringUtils.repeat("a", 3)); 
     assertEquals("ababab", StringUtils.repeat("ab", 3)); 
     assertEquals("abcabcabc", StringUtils.repeat("abc", 3)); 
     final String str = StringUtils.repeat("a", 10000); 
     assertEquals(10000, str.length()); 
     assertTrue(StringUtils.containsOnly(str, new char[] { 'a' })); 
 }
@Test
public void testReplaceChars_StringStringString3163() { 
     assertEquals(null, StringUtils.replaceChars(null, null, null)); 
     assertEquals(null, StringUtils.replaceChars(null, "", null)); 
     assertEquals(null, StringUtils.replaceChars(null, "a", null)); 
     assertEquals(null, StringUtils.replaceChars(null, null, "")); 
     assertEquals(null, StringUtils.replaceChars(null, null, "x")); 
     assertEquals("", StringUtils.replaceChars("", null, null)); 
     assertEquals("", StringUtils.replaceChars("", "", null)); 
     assertEquals("", StringUtils.replaceChars("", "a", null)); 
     assertEquals("", StringUtils.replaceChars("", null, "")); 
     assertEquals("", StringUtils.replaceChars("", null, "x")); 
     assertEquals("abc", StringUtils.replaceChars("abc", null, null)); 
     assertEquals("abc", StringUtils.replaceChars("abc", null, "")); 
     assertEquals("abc", StringUtils.replaceChars("abc", null, "x")); 
     assertEquals("abc", StringUtils.replaceChars("abc", "", null)); 
     assertEquals("abc", StringUtils.replaceChars("abc", "", "")); 
     assertEquals("abc", StringUtils.replaceChars("abc", "", "x")); 
     assertEquals("ac", StringUtils.replaceChars("abc", "b", null)); 
     assertEquals("ac", StringUtils.replaceChars("abc", "b", "")); 
     assertEquals("axc", StringUtils.replaceChars("abc", "b", "x")); 
     assertEquals("ayzya", StringUtils.replaceChars("abcba", "bc", "yz")); 
     assertEquals("ayya", StringUtils.replaceChars("abcba", "bc", "y")); 
     assertEquals("ayzya", StringUtils.replaceChars("abcba", "bc", "yzx")); 
     assertEquals("abcba", StringUtils.replaceChars("abcba", "z", "w")); 
     assertSame("abcba", StringUtils.replaceChars("abcba", "z", "w")); 
     assertEquals("jelly", StringUtils.replaceChars("hello", "ho", "jy")); 
     assertEquals("ayzya", StringUtils.replaceChars("abcba", "bc", "yz")); 
     assertEquals("ayya", StringUtils.replaceChars("abcba", "bc", "y")); 
     assertEquals("ayzya", StringUtils.replaceChars("abcba", "bc", "yzx")); 
     assertEquals("bcc", StringUtils.replaceChars("abc", "ab", "bc")); 
     assertEquals("q651.506bera", StringUtils.replaceChars("d216.102oren", "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ123456789", "nopqrstuvwxyzabcdefghijklmNOPQRSTUVWXYZABCDEFGHIJKLM567891234")); 
 }
@Test
public void testReplace_StringStringArrayStringArray3166() { 
     assertNull(StringUtils.replaceEach(null, new String[] { "a" }, new String[] { "b" })); 
     assertEquals(StringUtils.replaceEach("", new String[] { "a" }, new String[] { "b" }), ""); 
     assertEquals(StringUtils.replaceEach("aba", null, null), "aba"); 
     assertEquals(StringUtils.replaceEach("aba", new String[0], null), "aba"); 
     assertEquals(StringUtils.replaceEach("aba", null, new String[0]), "aba"); 
     assertEquals(StringUtils.replaceEach("aba", new String[] { "a" }, null), "aba"); 
     assertEquals(StringUtils.replaceEach("aba", new String[] { "a" }, new String[] { "" }), "b"); 
     assertEquals(StringUtils.replaceEach("aba", new String[] { null }, new String[] { "a" }), "aba"); 
     assertEquals(StringUtils.replaceEach("abcde", new String[] { "ab", "d" }, new String[] { "w", "t" }), "wcte"); 
     assertEquals(StringUtils.replaceEach("abcde", new String[] { "ab", "d" }, new String[] { "d", "t" }), "dcte"); 
     assertEquals("bcc", StringUtils.replaceEach("abc", new String[] { "a", "b" }, new String[] { "b", "c" })); 
     assertEquals("q651.506bera", StringUtils.replaceEach("d216.102oren", new String[] { "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "1", "2", "3", "4", "5", "6", "7", "8", "9" }, new String[] { "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z", "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "5", "6", "7", "8", "9", "1", "2", "3", "4" })); 
     assertEquals(StringUtils.replaceEach("aba", new String[] { "a" }, new String[] { null }), "aba"); 
     assertEquals(StringUtils.replaceEach("aba", new String[] { "a", "b" }, new String[] { "c", null }), "cbc"); 
 }
@Test
public void testOverlay_StringStringIntInt3187() { 
     assertEquals(null, StringUtils.overlay(null, null, 2, 4)); 
     assertEquals(null, StringUtils.overlay(null, null, -2, -4)); 
     assertEquals("", StringUtils.overlay("", null, 0, 0)); 
     assertEquals("", StringUtils.overlay("", "", 0, 0)); 
     assertEquals("zzzz", StringUtils.overlay("", "zzzz", 0, 0)); 
     assertEquals("zzzz", StringUtils.overlay("", "zzzz", 2, 4)); 
     assertEquals("zzzz", StringUtils.overlay("", "zzzz", -2, -4)); 
     assertEquals("abef", StringUtils.overlay("abcdef", null, 2, 4)); 
     assertEquals("abef", StringUtils.overlay("abcdef", null, 4, 2)); 
     assertEquals("abef", StringUtils.overlay("abcdef", "", 2, 4)); 
     assertEquals("abef", StringUtils.overlay("abcdef", "", 4, 2)); 
     assertEquals("abzzzzef", StringUtils.overlay("abcdef", "zzzz", 2, 4)); 
     assertEquals("abzzzzef", StringUtils.overlay("abcdef", "zzzz", 4, 2)); 
     assertEquals("zzzzef", StringUtils.overlay("abcdef", "zzzz", -1, 4)); 
     assertEquals("zzzzef", StringUtils.overlay("abcdef", "zzzz", 4, -1)); 
     assertEquals("zzzzabcdef", StringUtils.overlay("abcdef", "zzzz", -2, -1)); 
     assertEquals("zzzzabcdef", StringUtils.overlay("abcdef", "zzzz", -1, -2)); 
     assertEquals("abcdzzzz", StringUtils.overlay("abcdef", "zzzz", 4, 10)); 
     assertEquals("abcdzzzz", StringUtils.overlay("abcdef", "zzzz", 10, 4)); 
     assertEquals("abcdefzzzz", StringUtils.overlay("abcdef", "zzzz", 8, 10)); 
     assertEquals("abcdefzzzz", StringUtils.overlay("abcdef", "zzzz", 10, 8)); 
 }
@Test
public void testChop3189() { 
     final String[][] chopCases = { { FOO_UNCAP + "\r\n", FOO_UNCAP }, { FOO_UNCAP + "\n", FOO_UNCAP }, { FOO_UNCAP + "\r", FOO_UNCAP }, { FOO_UNCAP + " \r", FOO_UNCAP + " " }, { "foo", "fo" }, { "foo\nfoo", "foo\nfo" }, { "\n", "" }, { "\r", "" }, { "\r\n", "" }, { null, null }, { "", "" }, { "a", "" } }; 
     for (final String[] chopCase : chopCases) { 
         final String original = chopCase[0]; 
         final String expectedResult = chopCase[1]; 
         assertEquals("chop(String) failed", expectedResult, StringUtils.chop(original)); 
     } 
 }
@Test
public void testSplitByCharacterType3193() { 
     assertNull(StringUtils.splitByCharacterType(null)); 
     assertEquals(0, StringUtils.splitByCharacterType("").length); 
     assertTrue(ArrayUtils.isEquals(new String[] { "ab", " ", "de", " ", "fg" }, StringUtils.splitByCharacterType("ab de fg"))); 
     assertTrue(ArrayUtils.isEquals(new String[] { "ab", "   ", "de", " ", "fg" }, StringUtils.splitByCharacterType("ab   de fg"))); 
     assertTrue(ArrayUtils.isEquals(new String[] { "ab", ":", "cd", ":", "ef" }, StringUtils.splitByCharacterType("ab:cd:ef"))); 
     assertTrue(ArrayUtils.isEquals(new String[] { "number", "5" }, StringUtils.splitByCharacterType("number5"))); 
     assertTrue(ArrayUtils.isEquals(new String[] { "foo", "B", "ar" }, StringUtils.splitByCharacterType("fooBar"))); 
     assertTrue(ArrayUtils.isEquals(new String[] { "foo", "200", "B", "ar" }, StringUtils.splitByCharacterType("foo200Bar"))); 
     assertTrue(ArrayUtils.isEquals(new String[] { "ASFR", "ules" }, StringUtils.splitByCharacterType("ASFRules"))); 
 }
@Test
public void testRepeat_StringInt3199() { 
     assertEquals(null, StringUtils.repeat(null, 2)); 
     assertEquals("", StringUtils.repeat("ab", 0)); 
     assertEquals("", StringUtils.repeat("", 3)); 
     assertEquals("aaa", StringUtils.repeat("a", 3)); 
     assertEquals("ababab", StringUtils.repeat("ab", 3)); 
     assertEquals("abcabcabc", StringUtils.repeat("abc", 3)); 
     final String str = StringUtils.repeat("a", 10000); 
     assertEquals(10000, str.length()); 
     assertTrue(StringUtils.containsOnly(str, new char[] { 'a' })); 
 }
@Test
public void testJoin_ArrayOfBytes3201() { 
     assertEquals(null, StringUtils.join((byte[]) null, ',')); 
     assertEquals("1;2", StringUtils.join(BYTE_PRIM_LIST, SEPARATOR_CHAR)); 
     assertEquals("2", StringUtils.join(BYTE_PRIM_LIST, SEPARATOR_CHAR, 1, 2)); 
 }
@Test
public void testReplaceChars_StringStringString3202() { 
     assertEquals(null, StringUtils.replaceChars(null, null, null)); 
     assertEquals(null, StringUtils.replaceChars(null, "", null)); 
     assertEquals(null, StringUtils.replaceChars(null, "a", null)); 
     assertEquals(null, StringUtils.replaceChars(null, null, "")); 
     assertEquals(null, StringUtils.replaceChars(null, null, "x")); 
     assertEquals("", StringUtils.replaceChars("", null, null)); 
     assertEquals("", StringUtils.replaceChars("", "", null)); 
     assertEquals("", StringUtils.replaceChars("", "a", null)); 
     assertEquals("", StringUtils.replaceChars("", null, "")); 
     assertEquals("", StringUtils.replaceChars("", null, "x")); 
     assertEquals("abc", StringUtils.replaceChars("abc", null, null)); 
     assertEquals("abc", StringUtils.replaceChars("abc", null, "")); 
     assertEquals("abc", StringUtils.replaceChars("abc", null, "x")); 
     assertEquals("abc", StringUtils.replaceChars("abc", "", null)); 
     assertEquals("abc", StringUtils.replaceChars("abc", "", "")); 
     assertEquals("abc", StringUtils.replaceChars("abc", "", "x")); 
     assertEquals("ac", StringUtils.replaceChars("abc", "b", null)); 
     assertEquals("ac", StringUtils.replaceChars("abc", "b", "")); 
     assertEquals("axc", StringUtils.replaceChars("abc", "b", "x")); 
     assertEquals("ayzya", StringUtils.replaceChars("abcba", "bc", "yz")); 
     assertEquals("ayya", StringUtils.replaceChars("abcba", "bc", "y")); 
     assertEquals("ayzya", StringUtils.replaceChars("abcba", "bc", "yzx")); 
     assertEquals("abcba", StringUtils.replaceChars("abcba", "z", "w")); 
     assertSame("abcba", StringUtils.replaceChars("abcba", "z", "w")); 
     assertEquals("jelly", StringUtils.replaceChars("hello", "ho", "jy")); 
     assertEquals("ayzya", StringUtils.replaceChars("abcba", "bc", "yz")); 
     assertEquals("ayya", StringUtils.replaceChars("abcba", "bc", "y")); 
     assertEquals("ayzya", StringUtils.replaceChars("abcba", "bc", "yzx")); 
     assertEquals("bcc", StringUtils.replaceChars("abc", "ab", "bc")); 
     assertEquals("q651.506bera", StringUtils.replaceChars("d216.102oren", "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ123456789", "nopqrstuvwxyzabcdefghijklmNOPQRSTUVWXYZABCDEFGHIJKLM567891234")); 
 }
@Test
public void testCenter_StringIntChar3206() { 
     assertEquals(null, StringUtils.center(null, -1, ' ')); 
     assertEquals(null, StringUtils.center(null, 4, ' ')); 
     assertEquals("    ", StringUtils.center("", 4, ' ')); 
     assertEquals("ab", StringUtils.center("ab", 0, ' ')); 
     assertEquals("ab", StringUtils.center("ab", -1, ' ')); 
     assertEquals("ab", StringUtils.center("ab", 1, ' ')); 
     assertEquals("    ", StringUtils.center("", 4, ' ')); 
     assertEquals(" ab ", StringUtils.center("ab", 4, ' ')); 
     assertEquals("abcd", StringUtils.center("abcd", 2, ' ')); 
     assertEquals(" a  ", StringUtils.center("a", 4, ' ')); 
     assertEquals("  a  ", StringUtils.center("a", 5, ' ')); 
     assertEquals("xxaxx", StringUtils.center("a", 5, 'x')); 
 }
@Test
public void testDifference_StringString3215() { 
     assertEquals(null, StringUtils.difference(null, null)); 
     assertEquals("", StringUtils.difference("", "")); 
     assertEquals("abc", StringUtils.difference("", "abc")); 
     assertEquals("", StringUtils.difference("abc", "")); 
     assertEquals("i am a robot", StringUtils.difference(null, "i am a robot")); 
     assertEquals("i am a machine", StringUtils.difference("i am a machine", null)); 
     assertEquals("robot", StringUtils.difference("i am a machine", "i am a robot")); 
     assertEquals("", StringUtils.difference("abc", "abc")); 
     assertEquals("you are a robot", StringUtils.difference("i am a robot", "you are a robot")); 
 }
@Test
public void testReverseDelimited_StringChar3235() { 
     assertEquals(null, StringUtils.reverseDelimited(null, '.')); 
     assertEquals("", StringUtils.reverseDelimited("", '.')); 
     assertEquals("c.b.a", StringUtils.reverseDelimited("a.b.c", '.')); 
     assertEquals("a b c", StringUtils.reverseDelimited("a b c", '.')); 
     assertEquals("", StringUtils.reverseDelimited("", '.')); 
 }
@Test
public void testReplaceChars_StringStringString3240() { 
     assertEquals(null, StringUtils.replaceChars(null, null, null)); 
     assertEquals(null, StringUtils.replaceChars(null, "", null)); 
     assertEquals(null, StringUtils.replaceChars(null, "a", null)); 
     assertEquals(null, StringUtils.replaceChars(null, null, "")); 
     assertEquals(null, StringUtils.replaceChars(null, null, "x")); 
     assertEquals("", StringUtils.replaceChars("", null, null)); 
     assertEquals("", StringUtils.replaceChars("", "", null)); 
     assertEquals("", StringUtils.replaceChars("", "a", null)); 
     assertEquals("", StringUtils.replaceChars("", null, "")); 
     assertEquals("", StringUtils.replaceChars("", null, "x")); 
     assertEquals("abc", StringUtils.replaceChars("abc", null, null)); 
     assertEquals("abc", StringUtils.replaceChars("abc", null, "")); 
     assertEquals("abc", StringUtils.replaceChars("abc", null, "x")); 
     assertEquals("abc", StringUtils.replaceChars("abc", "", null)); 
     assertEquals("abc", StringUtils.replaceChars("abc", "", "")); 
     assertEquals("abc", StringUtils.replaceChars("abc", "", "x")); 
     assertEquals("ac", StringUtils.replaceChars("abc", "b", null)); 
     assertEquals("ac", StringUtils.replaceChars("abc", "b", "")); 
     assertEquals("axc", StringUtils.replaceChars("abc", "b", "x")); 
     assertEquals("ayzya", StringUtils.replaceChars("abcba", "bc", "yz")); 
     assertEquals("ayya", StringUtils.replaceChars("abcba", "bc", "y")); 
     assertEquals("ayzya", StringUtils.replaceChars("abcba", "bc", "yzx")); 
     assertEquals("abcba", StringUtils.replaceChars("abcba", "z", "w")); 
     assertSame("abcba", StringUtils.replaceChars("abcba", "z", "w")); 
     assertEquals("jelly", StringUtils.replaceChars("hello", "ho", "jy")); 
     assertEquals("ayzya", StringUtils.replaceChars("abcba", "bc", "yz")); 
     assertEquals("ayya", StringUtils.replaceChars("abcba", "bc", "y")); 
     assertEquals("ayzya", StringUtils.replaceChars("abcba", "bc", "yzx")); 
     assertEquals("bcc", StringUtils.replaceChars("abc", "ab", "bc")); 
     assertEquals("q651.506bera", StringUtils.replaceChars("d216.102oren", "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ123456789", "nopqrstuvwxyzabcdefghijklmNOPQRSTUVWXYZABCDEFGHIJKLM567891234")); 
 }
@Test
public void testDefault_String3280() { 
     assertEquals("", StringUtils.defaultString(null)); 
     assertEquals("", StringUtils.defaultString("")); 
     assertEquals("abc", StringUtils.defaultString("abc")); 
 }
@Test
public void testSplitByWholeString_StringStringBooleanInt3292() { 
     assertArrayEquals(null, StringUtils.splitByWholeSeparator(null, ".", 3)); 
     assertEquals(0, StringUtils.splitByWholeSeparator("", ".", 3).length); 
     final String stringToSplitOnNulls = "ab   de fg"; 
     final String[] splitOnNullExpectedResults = { "ab", "de fg" }; 
     final String[] splitOnNullResults = StringUtils.splitByWholeSeparator(stringToSplitOnNulls, null, 2); 
     assertEquals(splitOnNullExpectedResults.length, splitOnNullResults.length); 
     for (int i = 0; i < splitOnNullExpectedResults.length; i += 1) { 
         assertEquals(splitOnNullExpectedResults[i], splitOnNullResults[i]); 
     } 
     final String stringToSplitOnCharactersAndString = "abstemiouslyaeiouyabstemiouslyaeiouyabstemiously"; 
     final String[] splitOnStringExpectedResults = { "abstemiously", "abstemiouslyaeiouyabstemiously" }; 
     final String[] splitOnStringResults = StringUtils.splitByWholeSeparator(stringToSplitOnCharactersAndString, "aeiouy", 2); 
     assertEquals(splitOnStringExpectedResults.length, splitOnStringResults.length); 
     for (int i = 0; i < splitOnStringExpectedResults.length; i++) { 
         assertEquals(splitOnStringExpectedResults[i], splitOnStringResults[i]); 
     } 
 }
@Test
public void testReplace_StringStringStringInt3294() { 
     assertEquals(null, StringUtils.replace(null, null, null, 2)); 
     assertEquals(null, StringUtils.replace(null, null, "any", 2)); 
     assertEquals(null, StringUtils.replace(null, "any", null, 2)); 
     assertEquals(null, StringUtils.replace(null, "any", "any", 2)); 
     assertEquals("", StringUtils.replace("", null, null, 2)); 
     assertEquals("", StringUtils.replace("", null, "any", 2)); 
     assertEquals("", StringUtils.replace("", "any", null, 2)); 
     assertEquals("", StringUtils.replace("", "any", "any", 2)); 
     final String str = new String(new char[] { 'o', 'o', 'f', 'o', 'o' }); 
     assertSame(str, StringUtils.replace(str, "x", "", -1)); 
     assertEquals("f", StringUtils.replace("oofoo", "o", "", -1)); 
     assertEquals("oofoo", StringUtils.replace("oofoo", "o", "", 0)); 
     assertEquals("ofoo", StringUtils.replace("oofoo", "o", "", 1)); 
     assertEquals("foo", StringUtils.replace("oofoo", "o", "", 2)); 
     assertEquals("fo", StringUtils.replace("oofoo", "o", "", 3)); 
     assertEquals("f", StringUtils.replace("oofoo", "o", "", 4)); 
     assertEquals("f", StringUtils.replace("oofoo", "o", "", -5)); 
     assertEquals("f", StringUtils.replace("oofoo", "o", "", 1000)); 
 }
@Test
public void testSplit_StringChar3328() { 
     assertArrayEquals(null, StringUtils.split(null, '.')); 
     assertEquals(0, StringUtils.split("", '.').length); 
     String str = "a.b.. c"; 
     String[] res = StringUtils.split(str, '.'); 
     assertEquals(3, res.length); 
     assertEquals("a", res[0]); 
     assertEquals("b", res[1]); 
     assertEquals(" c", res[2]); 
     str = ".a."; 
     res = StringUtils.split(str, '.'); 
     assertEquals(1, res.length); 
     assertEquals("a", res[0]); 
     str = "a b c"; 
     res = StringUtils.split(str, ' '); 
     assertEquals(3, res.length); 
     assertEquals("a", res[0]); 
     assertEquals("b", res[1]); 
     assertEquals("c", res[2]); 
 }
@Test
public void testEscapeSurrogatePairsLang8583343() throws Exception { 
     assertEquals("\\uDBFF\\uDFFD", StringEscapeUtils.escapeJava("\uDBFF\uDFFD")); 
     assertEquals("\\uDBFF\\uDFFD", StringEscapeUtils.escapeEcmaScript("\uDBFF\uDFFD")); 
 }
@Test
public void testChop3346() { 
     final String[][] chopCases = { { FOO_UNCAP + "\r\n", FOO_UNCAP }, { FOO_UNCAP + "\n", FOO_UNCAP }, { FOO_UNCAP + "\r", FOO_UNCAP }, { FOO_UNCAP + " \r", FOO_UNCAP + " " }, { "foo", "fo" }, { "foo\nfoo", "foo\nfo" }, { "\n", "" }, { "\r", "" }, { "\r\n", "" }, { null, null }, { "", "" }, { "a", "" } }; 
     for (final String[] chopCase : chopCases) { 
         final String original = chopCase[0]; 
         final String expectedResult = chopCase[1]; 
         assertEquals("chop(String) failed", expectedResult, StringUtils.chop(original)); 
     } 
 }
@Test
public void testSplitByWholeSeparatorPreserveAllTokens_StringStringInt3350() { 
     assertArrayEquals(null, StringUtils.splitByWholeSeparatorPreserveAllTokens(null, ".", -1)); 
     assertEquals(0, StringUtils.splitByWholeSeparatorPreserveAllTokens("", ".", -1).length); 
     String input = "ab   de fg"; 
     String[] expected = new String[] { "ab", "", "", "de", "fg" }; 
     String[] actual = StringUtils.splitByWholeSeparatorPreserveAllTokens(input, null, -1); 
     assertEquals(expected.length, actual.length); 
     for (int i = 0; i < actual.length; i += 1) { 
         assertEquals(expected[i], actual[i]); 
     } 
     input = "1::2:::3::::4"; 
     expected = new String[] { "1", "", "2", "", "", "3", "", "", "", "4" }; 
     actual = StringUtils.splitByWholeSeparatorPreserveAllTokens(input, ":", -1); 
     assertEquals(expected.length, actual.length); 
     for (int i = 0; i < actual.length; i += 1) { 
         assertEquals(expected[i], actual[i]); 
     } 
     input = "1::2:::3::::4"; 
     expected = new String[] { "1", "2", ":3", "", "4" }; 
     actual = StringUtils.splitByWholeSeparatorPreserveAllTokens(input, "::", -1); 
     assertEquals(expected.length, actual.length); 
     for (int i = 0; i < actual.length; i += 1) { 
         assertEquals(expected[i], actual[i]); 
     } 
     input = "1::2::3:4"; 
     expected = new String[] { "1", "", "2", ":3:4" }; 
     actual = StringUtils.splitByWholeSeparatorPreserveAllTokens(input, ":", 4); 
     assertEquals(expected.length, actual.length); 
     for (int i = 0; i < actual.length; i += 1) { 
         assertEquals(expected[i], actual[i]); 
     } 
 }
@Test
public void testSplitByWholeString_StringStringBooleanInt3351() { 
     assertArrayEquals(null, StringUtils.splitByWholeSeparator(null, ".", 3)); 
     assertEquals(0, StringUtils.splitByWholeSeparator("", ".", 3).length); 
     final String stringToSplitOnNulls = "ab   de fg"; 
     final String[] splitOnNullExpectedResults = { "ab", "de fg" }; 
     final String[] splitOnNullResults = StringUtils.splitByWholeSeparator(stringToSplitOnNulls, null, 2); 
     assertEquals(splitOnNullExpectedResults.length, splitOnNullResults.length); 
     for (int i = 0; i < splitOnNullExpectedResults.length; i += 1) { 
         assertEquals(splitOnNullExpectedResults[i], splitOnNullResults[i]); 
     } 
     final String stringToSplitOnCharactersAndString = "abstemiouslyaeiouyabstemiouslyaeiouyabstemiously"; 
     final String[] splitOnStringExpectedResults = { "abstemiously", "abstemiouslyaeiouyabstemiously" }; 
     final String[] splitOnStringResults = StringUtils.splitByWholeSeparator(stringToSplitOnCharactersAndString, "aeiouy", 2); 
     assertEquals(splitOnStringExpectedResults.length, splitOnStringResults.length); 
     for (int i = 0; i < splitOnStringExpectedResults.length; i++) { 
         assertEquals(splitOnStringExpectedResults[i], splitOnStringResults[i]); 
     } 
 }
@Test
public void testJoin_ArrayOfBytes3366() { 
     assertEquals(null, StringUtils.join((byte[]) null, ',')); 
     assertEquals("1;2", StringUtils.join(BYTE_PRIM_LIST, SEPARATOR_CHAR)); 
     assertEquals("2", StringUtils.join(BYTE_PRIM_LIST, SEPARATOR_CHAR, 1, 2)); 
 }
@Test
public void testReplace_StringStringArrayStringArray3380() { 
     assertNull(StringUtils.replaceEach(null, new String[] { "a" }, new String[] { "b" })); 
     assertEquals(StringUtils.replaceEach("", new String[] { "a" }, new String[] { "b" }), ""); 
     assertEquals(StringUtils.replaceEach("aba", null, null), "aba"); 
     assertEquals(StringUtils.replaceEach("aba", new String[0], null), "aba"); 
     assertEquals(StringUtils.replaceEach("aba", null, new String[0]), "aba"); 
     assertEquals(StringUtils.replaceEach("aba", new String[] { "a" }, null), "aba"); 
     assertEquals(StringUtils.replaceEach("aba", new String[] { "a" }, new String[] { "" }), "b"); 
     assertEquals(StringUtils.replaceEach("aba", new String[] { null }, new String[] { "a" }), "aba"); 
     assertEquals(StringUtils.replaceEach("abcde", new String[] { "ab", "d" }, new String[] { "w", "t" }), "wcte"); 
     assertEquals(StringUtils.replaceEach("abcde", new String[] { "ab", "d" }, new String[] { "d", "t" }), "dcte"); 
     assertEquals("bcc", StringUtils.replaceEach("abc", new String[] { "a", "b" }, new String[] { "b", "c" })); 
     assertEquals("q651.506bera", StringUtils.replaceEach("d216.102oren", new String[] { "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "1", "2", "3", "4", "5", "6", "7", "8", "9" }, new String[] { "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z", "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "5", "6", "7", "8", "9", "1", "2", "3", "4" })); 
     assertEquals(StringUtils.replaceEach("aba", new String[] { "a" }, new String[] { null }), "aba"); 
     assertEquals(StringUtils.replaceEach("aba", new String[] { "a", "b" }, new String[] { "c", null }), "cbc"); 
 }
@Test
public void testJoin_ArrayOfLongs3384() { 
     assertEquals(null, StringUtils.join((long[]) null, ',')); 
     assertEquals("1;2", StringUtils.join(LONG_PRIM_LIST, SEPARATOR_CHAR)); 
     assertEquals("2", StringUtils.join(LONG_PRIM_LIST, SEPARATOR_CHAR, 1, 2)); 
 }
@Test
public void testAbbreviate_StringIntInt3409() { 
     assertEquals(null, StringUtils.abbreviate(null, 10, 12)); 
     assertEquals("", StringUtils.abbreviate("", 0, 10)); 
     assertEquals("", StringUtils.abbreviate("", 2, 10)); 
     try { 
         @SuppressWarnings("unused") 
         final String res = StringUtils.abbreviate("abcdefghij", 0, 3); 
         fail("StringUtils.abbreviate expecting IllegalArgumentException"); 
     } catch (final IllegalArgumentException ex) { 
     } 
     try { 
         @SuppressWarnings("unused") 
         final String res = StringUtils.abbreviate("abcdefghij", 5, 6); 
         fail("StringUtils.abbreviate expecting IllegalArgumentException"); 
     } catch (final IllegalArgumentException ex) { 
     } 
     final String raspberry = "raspberry peach"; 
     assertEquals("raspberry peach", StringUtils.abbreviate(raspberry, 11, 15)); 
     assertEquals(null, StringUtils.abbreviate(null, 7, 14)); 
     assertAbbreviateWithOffset("abcdefg...", -1, 10); 
     assertAbbreviateWithOffset("abcdefg...", 0, 10); 
     assertAbbreviateWithOffset("abcdefg...", 1, 10); 
     assertAbbreviateWithOffset("abcdefg...", 2, 10); 
     assertAbbreviateWithOffset("abcdefg...", 3, 10); 
     assertAbbreviateWithOffset("abcdefg...", 4, 10); 
     assertAbbreviateWithOffset("...fghi...", 5, 10); 
     assertAbbreviateWithOffset("...ghij...", 6, 10); 
     assertAbbreviateWithOffset("...hijk...", 7, 10); 
     assertAbbreviateWithOffset("...ijklmno", 8, 10); 
     assertAbbreviateWithOffset("...ijklmno", 9, 10); 
     assertAbbreviateWithOffset("...ijklmno", 10, 10); 
     assertAbbreviateWithOffset("...ijklmno", 10, 10); 
     assertAbbreviateWithOffset("...ijklmno", 11, 10); 
     assertAbbreviateWithOffset("...ijklmno", 12, 10); 
     assertAbbreviateWithOffset("...ijklmno", 13, 10); 
     assertAbbreviateWithOffset("...ijklmno", 14, 10); 
     assertAbbreviateWithOffset("...ijklmno", 15, 10); 
     assertAbbreviateWithOffset("...ijklmno", 16, 10); 
     assertAbbreviateWithOffset("...ijklmno", Integer.MAX_VALUE, 10); 
 }
@Test
public void testAbbreviateMiddle3412() { 
     assertNull(StringUtils.abbreviateMiddle(null, null, 0)); 
     assertEquals("abc", StringUtils.abbreviateMiddle("abc", null, 0)); 
     assertEquals("abc", StringUtils.abbreviateMiddle("abc", ".", 0)); 
     assertEquals("abc", StringUtils.abbreviateMiddle("abc", ".", 3)); 
     assertEquals("ab.f", StringUtils.abbreviateMiddle("abcdef", ".", 4)); 
     assertEquals("A very long text with un...f the text is complete.", StringUtils.abbreviateMiddle("A very long text with unimportant stuff in the middle but interesting start and " + "end to see if the text is complete.", "...", 50)); 
     final String longText = "Start text" + StringUtils.repeat("x", 10000) + "Close text"; 
     assertEquals("Start text->Close text", StringUtils.abbreviateMiddle(longText, "->", 22)); 
     assertEquals("abc", StringUtils.abbreviateMiddle("abc", ".", -1)); 
     assertEquals("abc", StringUtils.abbreviateMiddle("abc", ".", 1)); 
     assertEquals("abc", StringUtils.abbreviateMiddle("abc", ".", 2)); 
     assertEquals("a", StringUtils.abbreviateMiddle("a", ".", 1)); 
     assertEquals("a.d", StringUtils.abbreviateMiddle("abcd", ".", 3)); 
     assertEquals("a..f", StringUtils.abbreviateMiddle("abcdef", "..", 4)); 
     assertEquals("ab.ef", StringUtils.abbreviateMiddle("abcdef", ".", 5)); 
 }
@Test
public void testReplace_StringStringStringInt3426() { 
     assertEquals(null, StringUtils.replace(null, null, null, 2)); 
     assertEquals(null, StringUtils.replace(null, null, "any", 2)); 
     assertEquals(null, StringUtils.replace(null, "any", null, 2)); 
     assertEquals(null, StringUtils.replace(null, "any", "any", 2)); 
     assertEquals("", StringUtils.replace("", null, null, 2)); 
     assertEquals("", StringUtils.replace("", null, "any", 2)); 
     assertEquals("", StringUtils.replace("", "any", null, 2)); 
     assertEquals("", StringUtils.replace("", "any", "any", 2)); 
     final String str = new String(new char[] { 'o', 'o', 'f', 'o', 'o' }); 
     assertSame(str, StringUtils.replace(str, "x", "", -1)); 
     assertEquals("f", StringUtils.replace("oofoo", "o", "", -1)); 
     assertEquals("oofoo", StringUtils.replace("oofoo", "o", "", 0)); 
     assertEquals("ofoo", StringUtils.replace("oofoo", "o", "", 1)); 
     assertEquals("foo", StringUtils.replace("oofoo", "o", "", 2)); 
     assertEquals("fo", StringUtils.replace("oofoo", "o", "", 3)); 
     assertEquals("f", StringUtils.replace("oofoo", "o", "", 4)); 
     assertEquals("f", StringUtils.replace("oofoo", "o", "", -5)); 
     assertEquals("f", StringUtils.replace("oofoo", "o", "", 1000)); 
 }
@Test
public void testDifference_StringString3428() { 
     assertEquals(null, StringUtils.difference(null, null)); 
     assertEquals("", StringUtils.difference("", "")); 
     assertEquals("abc", StringUtils.difference("", "abc")); 
     assertEquals("", StringUtils.difference("abc", "")); 
     assertEquals("i am a robot", StringUtils.difference(null, "i am a robot")); 
     assertEquals("i am a machine", StringUtils.difference("i am a machine", null)); 
     assertEquals("robot", StringUtils.difference("i am a machine", "i am a robot")); 
     assertEquals("", StringUtils.difference("abc", "abc")); 
     assertEquals("you are a robot", StringUtils.difference("i am a robot", "you are a robot")); 
 }
@Test
public void testSplit_StringChar3431() { 
     assertArrayEquals(null, StringUtils.split(null, '.')); 
     assertEquals(0, StringUtils.split("", '.').length); 
     String str = "a.b.. c"; 
     String[] res = StringUtils.split(str, '.'); 
     assertEquals(3, res.length); 
     assertEquals("a", res[0]); 
     assertEquals("b", res[1]); 
     assertEquals(" c", res[2]); 
     str = ".a."; 
     res = StringUtils.split(str, '.'); 
     assertEquals(1, res.length); 
     assertEquals("a", res[0]); 
     str = "a b c"; 
     res = StringUtils.split(str, ' '); 
     assertEquals(3, res.length); 
     assertEquals("a", res[0]); 
     assertEquals("b", res[1]); 
     assertEquals("c", res[2]); 
 }
@Test
public void testRepeat_StringInt3451() { 
     assertEquals(null, StringUtils.repeat(null, 2)); 
     assertEquals("", StringUtils.repeat("ab", 0)); 
     assertEquals("", StringUtils.repeat("", 3)); 
     assertEquals("aaa", StringUtils.repeat("a", 3)); 
     assertEquals("ababab", StringUtils.repeat("ab", 3)); 
     assertEquals("abcabcabc", StringUtils.repeat("abc", 3)); 
     final String str = StringUtils.repeat("a", 10000); 
     assertEquals(10000, str.length()); 
     assertTrue(StringUtils.containsOnly(str, new char[] { 'a' })); 
 }
@Test
public void testSplit_StringChar3456() { 
     assertArrayEquals(null, StringUtils.split(null, '.')); 
     assertEquals(0, StringUtils.split("", '.').length); 
     String str = "a.b.. c"; 
     String[] res = StringUtils.split(str, '.'); 
     assertEquals(3, res.length); 
     assertEquals("a", res[0]); 
     assertEquals("b", res[1]); 
     assertEquals(" c", res[2]); 
     str = ".a."; 
     res = StringUtils.split(str, '.'); 
     assertEquals(1, res.length); 
     assertEquals("a", res[0]); 
     str = "a b c"; 
     res = StringUtils.split(str, ' '); 
     assertEquals(3, res.length); 
     assertEquals("a", res[0]); 
     assertEquals("b", res[1]); 
     assertEquals("c", res[2]); 
 }
@Test
public void testOverlay_StringStringIntInt3472() { 
     assertEquals(null, StringUtils.overlay(null, null, 2, 4)); 
     assertEquals(null, StringUtils.overlay(null, null, -2, -4)); 
     assertEquals("", StringUtils.overlay("", null, 0, 0)); 
     assertEquals("", StringUtils.overlay("", "", 0, 0)); 
     assertEquals("zzzz", StringUtils.overlay("", "zzzz", 0, 0)); 
     assertEquals("zzzz", StringUtils.overlay("", "zzzz", 2, 4)); 
     assertEquals("zzzz", StringUtils.overlay("", "zzzz", -2, -4)); 
     assertEquals("abef", StringUtils.overlay("abcdef", null, 2, 4)); 
     assertEquals("abef", StringUtils.overlay("abcdef", null, 4, 2)); 
     assertEquals("abef", StringUtils.overlay("abcdef", "", 2, 4)); 
     assertEquals("abef", StringUtils.overlay("abcdef", "", 4, 2)); 
     assertEquals("abzzzzef", StringUtils.overlay("abcdef", "zzzz", 2, 4)); 
     assertEquals("abzzzzef", StringUtils.overlay("abcdef", "zzzz", 4, 2)); 
     assertEquals("zzzzef", StringUtils.overlay("abcdef", "zzzz", -1, 4)); 
     assertEquals("zzzzef", StringUtils.overlay("abcdef", "zzzz", 4, -1)); 
     assertEquals("zzzzabcdef", StringUtils.overlay("abcdef", "zzzz", -2, -1)); 
     assertEquals("zzzzabcdef", StringUtils.overlay("abcdef", "zzzz", -1, -2)); 
     assertEquals("abcdzzzz", StringUtils.overlay("abcdef", "zzzz", 4, 10)); 
     assertEquals("abcdzzzz", StringUtils.overlay("abcdef", "zzzz", 10, 4)); 
     assertEquals("abcdefzzzz", StringUtils.overlay("abcdef", "zzzz", 8, 10)); 
     assertEquals("abcdefzzzz", StringUtils.overlay("abcdef", "zzzz", 10, 8)); 
 }
@Test
public void testGetLevenshteinDistance_StringStringInt3479() { 
     assertEquals(0, StringUtils.getLevenshteinDistance("", "", 0)); 
     assertEquals(7, StringUtils.getLevenshteinDistance("aaapppp", "", 8)); 
     assertEquals(7, StringUtils.getLevenshteinDistance("aaapppp", "", 7)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("aaapppp", "", 6)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("b", "a", 0)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("a", "b", 0)); 
     assertEquals(0, StringUtils.getLevenshteinDistance("aa", "aa", 0)); 
     assertEquals(0, StringUtils.getLevenshteinDistance("aa", "aa", 2)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("aaa", "bbb", 2)); 
     assertEquals(3, StringUtils.getLevenshteinDistance("aaa", "bbb", 3)); 
     assertEquals(6, StringUtils.getLevenshteinDistance("aaaaaa", "b", 10)); 
     assertEquals(7, StringUtils.getLevenshteinDistance("aaapppp", "b", 8)); 
     assertEquals(3, StringUtils.getLevenshteinDistance("a", "bbb", 4)); 
     assertEquals(7, StringUtils.getLevenshteinDistance("aaapppp", "b", 7)); 
     assertEquals(3, StringUtils.getLevenshteinDistance("a", "bbb", 3)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("a", "bbb", 2)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("bbb", "a", 2)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("aaapppp", "b", 6)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("a", "bbb", 1)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("bbb", "a", 1)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("12345", "1234567", 1)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("1234567", "12345", 1)); 
     assertEquals(1, StringUtils.getLevenshteinDistance("frog", "fog", 1)); 
     assertEquals(3, StringUtils.getLevenshteinDistance("fly", "ant", 3)); 
     assertEquals(7, StringUtils.getLevenshteinDistance("elephant", "hippo", 7)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("elephant", "hippo", 6)); 
     assertEquals(7, StringUtils.getLevenshteinDistance("hippo", "elephant", 7)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("hippo", "elephant", 6)); 
     assertEquals(8, StringUtils.getLevenshteinDistance("hippo", "zzzzzzzz", 8)); 
     assertEquals(8, StringUtils.getLevenshteinDistance("zzzzzzzz", "hippo", 8)); 
     assertEquals(1, StringUtils.getLevenshteinDistance("hello", "hallo", 1)); 
     try { 
         @SuppressWarnings("unused") 
         final int d = StringUtils.getLevenshteinDistance("a", null, 0); 
         fail("expecting IllegalArgumentException"); 
     } catch (final IllegalArgumentException ex) { 
     } 
     try { 
         @SuppressWarnings("unused") 
         final int d = StringUtils.getLevenshteinDistance(null, "a", 0); 
         fail("expecting IllegalArgumentException"); 
     } catch (final IllegalArgumentException ex) { 
     } 
     try { 
         @SuppressWarnings("unused") 
         final int d = StringUtils.getLevenshteinDistance("a", "a", -1); 
         fail("expecting IllegalArgumentException"); 
     } catch (final IllegalArgumentException ex) { 
     } 
 }
@Test
public void testGetCommonPrefix_StringArray3498() { 
     assertEquals("", StringUtils.getCommonPrefix((String[]) null)); 
     assertEquals("", StringUtils.getCommonPrefix()); 
     assertEquals("abc", StringUtils.getCommonPrefix("abc")); 
     assertEquals("", StringUtils.getCommonPrefix(null, null)); 
     assertEquals("", StringUtils.getCommonPrefix("", "")); 
     assertEquals("", StringUtils.getCommonPrefix("", null)); 
     assertEquals("", StringUtils.getCommonPrefix("abc", null, null)); 
     assertEquals("", StringUtils.getCommonPrefix(null, null, "abc")); 
     assertEquals("", StringUtils.getCommonPrefix("", "abc")); 
     assertEquals("", StringUtils.getCommonPrefix("abc", "")); 
     assertEquals("abc", StringUtils.getCommonPrefix("abc", "abc")); 
     assertEquals("a", StringUtils.getCommonPrefix("abc", "a")); 
     assertEquals("ab", StringUtils.getCommonPrefix("ab", "abxyz")); 
     assertEquals("ab", StringUtils.getCommonPrefix("abcde", "abxyz")); 
     assertEquals("", StringUtils.getCommonPrefix("abcde", "xyz")); 
     assertEquals("", StringUtils.getCommonPrefix("xyz", "abcde")); 
     assertEquals("i am a ", StringUtils.getCommonPrefix("i am a machine", "i am a robot")); 
 }
@Test
public void testSplit_StringChar3517() { 
     assertArrayEquals(null, StringUtils.split(null, '.')); 
     assertEquals(0, StringUtils.split("", '.').length); 
     String str = "a.b.. c"; 
     String[] res = StringUtils.split(str, '.'); 
     assertEquals(3, res.length); 
     assertEquals("a", res[0]); 
     assertEquals("b", res[1]); 
     assertEquals(" c", res[2]); 
     str = ".a."; 
     res = StringUtils.split(str, '.'); 
     assertEquals(1, res.length); 
     assertEquals("a", res[0]); 
     str = "a b c"; 
     res = StringUtils.split(str, ' '); 
     assertEquals(3, res.length); 
     assertEquals("a", res[0]); 
     assertEquals("b", res[1]); 
     assertEquals("c", res[2]); 
 }
@Test
public void testGetLevenshteinDistance_StringStringInt3522() { 
     assertEquals(0, StringUtils.getLevenshteinDistance("", "", 0)); 
     assertEquals(7, StringUtils.getLevenshteinDistance("aaapppp", "", 8)); 
     assertEquals(7, StringUtils.getLevenshteinDistance("aaapppp", "", 7)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("aaapppp", "", 6)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("b", "a", 0)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("a", "b", 0)); 
     assertEquals(0, StringUtils.getLevenshteinDistance("aa", "aa", 0)); 
     assertEquals(0, StringUtils.getLevenshteinDistance("aa", "aa", 2)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("aaa", "bbb", 2)); 
     assertEquals(3, StringUtils.getLevenshteinDistance("aaa", "bbb", 3)); 
     assertEquals(6, StringUtils.getLevenshteinDistance("aaaaaa", "b", 10)); 
     assertEquals(7, StringUtils.getLevenshteinDistance("aaapppp", "b", 8)); 
     assertEquals(3, StringUtils.getLevenshteinDistance("a", "bbb", 4)); 
     assertEquals(7, StringUtils.getLevenshteinDistance("aaapppp", "b", 7)); 
     assertEquals(3, StringUtils.getLevenshteinDistance("a", "bbb", 3)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("a", "bbb", 2)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("bbb", "a", 2)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("aaapppp", "b", 6)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("a", "bbb", 1)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("bbb", "a", 1)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("12345", "1234567", 1)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("1234567", "12345", 1)); 
     assertEquals(1, StringUtils.getLevenshteinDistance("frog", "fog", 1)); 
     assertEquals(3, StringUtils.getLevenshteinDistance("fly", "ant", 3)); 
     assertEquals(7, StringUtils.getLevenshteinDistance("elephant", "hippo", 7)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("elephant", "hippo", 6)); 
     assertEquals(7, StringUtils.getLevenshteinDistance("hippo", "elephant", 7)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("hippo", "elephant", 6)); 
     assertEquals(8, StringUtils.getLevenshteinDistance("hippo", "zzzzzzzz", 8)); 
     assertEquals(8, StringUtils.getLevenshteinDistance("zzzzzzzz", "hippo", 8)); 
     assertEquals(1, StringUtils.getLevenshteinDistance("hello", "hallo", 1)); 
     try { 
         @SuppressWarnings("unused") 
         final int d = StringUtils.getLevenshteinDistance("a", null, 0); 
         fail("expecting IllegalArgumentException"); 
     } catch (final IllegalArgumentException ex) { 
     } 
     try { 
         @SuppressWarnings("unused") 
         final int d = StringUtils.getLevenshteinDistance(null, "a", 0); 
         fail("expecting IllegalArgumentException"); 
     } catch (final IllegalArgumentException ex) { 
     } 
     try { 
         @SuppressWarnings("unused") 
         final int d = StringUtils.getLevenshteinDistance("a", "a", -1); 
         fail("expecting IllegalArgumentException"); 
     } catch (final IllegalArgumentException ex) { 
     } 
 }
@Test
public void testJoin_IteratorChar3524() { 
     assertEquals(null, StringUtils.join((Iterator<?>) null, ',')); 
     assertEquals(TEXT_LIST_CHAR, StringUtils.join(Arrays.asList(ARRAY_LIST).iterator(), SEPARATOR_CHAR)); 
     assertEquals("", StringUtils.join(Arrays.asList(NULL_ARRAY_LIST).iterator(), SEPARATOR_CHAR)); 
     assertEquals("", StringUtils.join(Arrays.asList(EMPTY_ARRAY_LIST).iterator(), SEPARATOR_CHAR)); 
     assertEquals("foo", StringUtils.join(Collections.singleton("foo").iterator(), 'x')); 
 }
@Test
public void testPrependIfMissingIgnoreCase3541() { 
     assertEquals("prependIfMissingIgnoreCase(null,null)", null, StringUtils.prependIfMissingIgnoreCase(null, null)); 
     assertEquals("prependIfMissingIgnoreCase(abc,null)", "abc", StringUtils.prependIfMissingIgnoreCase("abc", null)); 
     assertEquals("prependIfMissingIgnoreCase(\"\",xyz)", "xyz", StringUtils.prependIfMissingIgnoreCase("", "xyz")); 
     assertEquals("prependIfMissingIgnoreCase(abc,xyz)", "xyzabc", StringUtils.prependIfMissingIgnoreCase("abc", "xyz")); 
     assertEquals("prependIfMissingIgnoreCase(xyzabc,xyz)", "xyzabc", StringUtils.prependIfMissingIgnoreCase("xyzabc", "xyz")); 
     assertEquals("prependIfMissingIgnoreCase(XYZabc,xyz)", "XYZabc", StringUtils.prependIfMissingIgnoreCase("XYZabc", "xyz")); 
     assertEquals("prependIfMissingIgnoreCase(null,null null)", null, StringUtils.prependIfMissingIgnoreCase(null, null, (CharSequence[]) null)); 
     assertEquals("prependIfMissingIgnoreCase(abc,null,null)", "abc", StringUtils.prependIfMissingIgnoreCase("abc", null, (CharSequence[]) null)); 
     assertEquals("prependIfMissingIgnoreCase(\"\",xyz,null)", "xyz", StringUtils.prependIfMissingIgnoreCase("", "xyz", (CharSequence[]) null)); 
     assertEquals("prependIfMissingIgnoreCase(abc,xyz,{null})", "xyzabc", StringUtils.prependIfMissingIgnoreCase("abc", "xyz", new CharSequence[] { null })); 
     assertEquals("prependIfMissingIgnoreCase(abc,xyz,\"\")", "abc", StringUtils.prependIfMissingIgnoreCase("abc", "xyz", "")); 
     assertEquals("prependIfMissingIgnoreCase(abc,xyz,mno)", "xyzabc", StringUtils.prependIfMissingIgnoreCase("abc", "xyz", "mno")); 
     assertEquals("prependIfMissingIgnoreCase(xyzabc,xyz,mno)", "xyzabc", StringUtils.prependIfMissingIgnoreCase("xyzabc", "xyz", "mno")); 
     assertEquals("prependIfMissingIgnoreCase(mnoabc,xyz,mno)", "mnoabc", StringUtils.prependIfMissingIgnoreCase("mnoabc", "xyz", "mno")); 
     assertEquals("prependIfMissingIgnoreCase(XYZabc,xyz,mno)", "XYZabc", StringUtils.prependIfMissingIgnoreCase("XYZabc", "xyz", "mno")); 
     assertEquals("prependIfMissingIgnoreCase(MNOabc,xyz,mno)", "MNOabc", StringUtils.prependIfMissingIgnoreCase("MNOabc", "xyz", "mno")); 
 }
@Test
public void testGetLevenshteinDistance_StringStringInt3561() { 
     assertEquals(0, StringUtils.getLevenshteinDistance("", "", 0)); 
     assertEquals(7, StringUtils.getLevenshteinDistance("aaapppp", "", 8)); 
     assertEquals(7, StringUtils.getLevenshteinDistance("aaapppp", "", 7)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("aaapppp", "", 6)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("b", "a", 0)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("a", "b", 0)); 
     assertEquals(0, StringUtils.getLevenshteinDistance("aa", "aa", 0)); 
     assertEquals(0, StringUtils.getLevenshteinDistance("aa", "aa", 2)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("aaa", "bbb", 2)); 
     assertEquals(3, StringUtils.getLevenshteinDistance("aaa", "bbb", 3)); 
     assertEquals(6, StringUtils.getLevenshteinDistance("aaaaaa", "b", 10)); 
     assertEquals(7, StringUtils.getLevenshteinDistance("aaapppp", "b", 8)); 
     assertEquals(3, StringUtils.getLevenshteinDistance("a", "bbb", 4)); 
     assertEquals(7, StringUtils.getLevenshteinDistance("aaapppp", "b", 7)); 
     assertEquals(3, StringUtils.getLevenshteinDistance("a", "bbb", 3)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("a", "bbb", 2)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("bbb", "a", 2)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("aaapppp", "b", 6)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("a", "bbb", 1)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("bbb", "a", 1)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("12345", "1234567", 1)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("1234567", "12345", 1)); 
     assertEquals(1, StringUtils.getLevenshteinDistance("frog", "fog", 1)); 
     assertEquals(3, StringUtils.getLevenshteinDistance("fly", "ant", 3)); 
     assertEquals(7, StringUtils.getLevenshteinDistance("elephant", "hippo", 7)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("elephant", "hippo", 6)); 
     assertEquals(7, StringUtils.getLevenshteinDistance("hippo", "elephant", 7)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("hippo", "elephant", 6)); 
     assertEquals(8, StringUtils.getLevenshteinDistance("hippo", "zzzzzzzz", 8)); 
     assertEquals(8, StringUtils.getLevenshteinDistance("zzzzzzzz", "hippo", 8)); 
     assertEquals(1, StringUtils.getLevenshteinDistance("hello", "hallo", 1)); 
     try { 
         @SuppressWarnings("unused") 
         final int d = StringUtils.getLevenshteinDistance("a", null, 0); 
         fail("expecting IllegalArgumentException"); 
     } catch (final IllegalArgumentException ex) { 
     } 
     try { 
         @SuppressWarnings("unused") 
         final int d = StringUtils.getLevenshteinDistance(null, "a", 0); 
         fail("expecting IllegalArgumentException"); 
     } catch (final IllegalArgumentException ex) { 
     } 
     try { 
         @SuppressWarnings("unused") 
         final int d = StringUtils.getLevenshteinDistance("a", "a", -1); 
         fail("expecting IllegalArgumentException"); 
     } catch (final IllegalArgumentException ex) { 
     } 
 }
@Test
public void testIsAllUpperCase3564() { 
     assertFalse(StringUtils.isAllUpperCase(null)); 
     assertFalse(StringUtils.isAllUpperCase(StringUtils.EMPTY)); 
     assertTrue(StringUtils.isAllUpperCase("ABC")); 
     assertFalse(StringUtils.isAllUpperCase("ABC ")); 
     assertFalse(StringUtils.isAllUpperCase("aBC")); 
 }
@Test
public void testGetLevenshteinDistance_StringStringInt3575() { 
     assertEquals(0, StringUtils.getLevenshteinDistance("", "", 0)); 
     assertEquals(7, StringUtils.getLevenshteinDistance("aaapppp", "", 8)); 
     assertEquals(7, StringUtils.getLevenshteinDistance("aaapppp", "", 7)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("aaapppp", "", 6)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("b", "a", 0)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("a", "b", 0)); 
     assertEquals(0, StringUtils.getLevenshteinDistance("aa", "aa", 0)); 
     assertEquals(0, StringUtils.getLevenshteinDistance("aa", "aa", 2)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("aaa", "bbb", 2)); 
     assertEquals(3, StringUtils.getLevenshteinDistance("aaa", "bbb", 3)); 
     assertEquals(6, StringUtils.getLevenshteinDistance("aaaaaa", "b", 10)); 
     assertEquals(7, StringUtils.getLevenshteinDistance("aaapppp", "b", 8)); 
     assertEquals(3, StringUtils.getLevenshteinDistance("a", "bbb", 4)); 
     assertEquals(7, StringUtils.getLevenshteinDistance("aaapppp", "b", 7)); 
     assertEquals(3, StringUtils.getLevenshteinDistance("a", "bbb", 3)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("a", "bbb", 2)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("bbb", "a", 2)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("aaapppp", "b", 6)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("a", "bbb", 1)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("bbb", "a", 1)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("12345", "1234567", 1)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("1234567", "12345", 1)); 
     assertEquals(1, StringUtils.getLevenshteinDistance("frog", "fog", 1)); 
     assertEquals(3, StringUtils.getLevenshteinDistance("fly", "ant", 3)); 
     assertEquals(7, StringUtils.getLevenshteinDistance("elephant", "hippo", 7)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("elephant", "hippo", 6)); 
     assertEquals(7, StringUtils.getLevenshteinDistance("hippo", "elephant", 7)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("hippo", "elephant", 6)); 
     assertEquals(8, StringUtils.getLevenshteinDistance("hippo", "zzzzzzzz", 8)); 
     assertEquals(8, StringUtils.getLevenshteinDistance("zzzzzzzz", "hippo", 8)); 
     assertEquals(1, StringUtils.getLevenshteinDistance("hello", "hallo", 1)); 
     try { 
         @SuppressWarnings("unused") 
         final int d = StringUtils.getLevenshteinDistance("a", null, 0); 
         fail("expecting IllegalArgumentException"); 
     } catch (final IllegalArgumentException ex) { 
     } 
     try { 
         @SuppressWarnings("unused") 
         final int d = StringUtils.getLevenshteinDistance(null, "a", 0); 
         fail("expecting IllegalArgumentException"); 
     } catch (final IllegalArgumentException ex) { 
     } 
     try { 
         @SuppressWarnings("unused") 
         final int d = StringUtils.getLevenshteinDistance("a", "a", -1); 
         fail("expecting IllegalArgumentException"); 
     } catch (final IllegalArgumentException ex) { 
     } 
 }
@Test
public void testReplace_StringStringStringInt3577() { 
     assertEquals(null, StringUtils.replace(null, null, null, 2)); 
     assertEquals(null, StringUtils.replace(null, null, "any", 2)); 
     assertEquals(null, StringUtils.replace(null, "any", null, 2)); 
     assertEquals(null, StringUtils.replace(null, "any", "any", 2)); 
     assertEquals("", StringUtils.replace("", null, null, 2)); 
     assertEquals("", StringUtils.replace("", null, "any", 2)); 
     assertEquals("", StringUtils.replace("", "any", null, 2)); 
     assertEquals("", StringUtils.replace("", "any", "any", 2)); 
     final String str = new String(new char[] { 'o', 'o', 'f', 'o', 'o' }); 
     assertSame(str, StringUtils.replace(str, "x", "", -1)); 
     assertEquals("f", StringUtils.replace("oofoo", "o", "", -1)); 
     assertEquals("oofoo", StringUtils.replace("oofoo", "o", "", 0)); 
     assertEquals("ofoo", StringUtils.replace("oofoo", "o", "", 1)); 
     assertEquals("foo", StringUtils.replace("oofoo", "o", "", 2)); 
     assertEquals("fo", StringUtils.replace("oofoo", "o", "", 3)); 
     assertEquals("f", StringUtils.replace("oofoo", "o", "", 4)); 
     assertEquals("f", StringUtils.replace("oofoo", "o", "", -5)); 
     assertEquals("f", StringUtils.replace("oofoo", "o", "", 1000)); 
 }
@Test
public void testReplaceChars_StringStringString3579() { 
     assertEquals(null, StringUtils.replaceChars(null, null, null)); 
     assertEquals(null, StringUtils.replaceChars(null, "", null)); 
     assertEquals(null, StringUtils.replaceChars(null, "a", null)); 
     assertEquals(null, StringUtils.replaceChars(null, null, "")); 
     assertEquals(null, StringUtils.replaceChars(null, null, "x")); 
     assertEquals("", StringUtils.replaceChars("", null, null)); 
     assertEquals("", StringUtils.replaceChars("", "", null)); 
     assertEquals("", StringUtils.replaceChars("", "a", null)); 
     assertEquals("", StringUtils.replaceChars("", null, "")); 
     assertEquals("", StringUtils.replaceChars("", null, "x")); 
     assertEquals("abc", StringUtils.replaceChars("abc", null, null)); 
     assertEquals("abc", StringUtils.replaceChars("abc", null, "")); 
     assertEquals("abc", StringUtils.replaceChars("abc", null, "x")); 
     assertEquals("abc", StringUtils.replaceChars("abc", "", null)); 
     assertEquals("abc", StringUtils.replaceChars("abc", "", "")); 
     assertEquals("abc", StringUtils.replaceChars("abc", "", "x")); 
     assertEquals("ac", StringUtils.replaceChars("abc", "b", null)); 
     assertEquals("ac", StringUtils.replaceChars("abc", "b", "")); 
     assertEquals("axc", StringUtils.replaceChars("abc", "b", "x")); 
     assertEquals("ayzya", StringUtils.replaceChars("abcba", "bc", "yz")); 
     assertEquals("ayya", StringUtils.replaceChars("abcba", "bc", "y")); 
     assertEquals("ayzya", StringUtils.replaceChars("abcba", "bc", "yzx")); 
     assertEquals("abcba", StringUtils.replaceChars("abcba", "z", "w")); 
     assertSame("abcba", StringUtils.replaceChars("abcba", "z", "w")); 
     assertEquals("jelly", StringUtils.replaceChars("hello", "ho", "jy")); 
     assertEquals("ayzya", StringUtils.replaceChars("abcba", "bc", "yz")); 
     assertEquals("ayya", StringUtils.replaceChars("abcba", "bc", "y")); 
     assertEquals("ayzya", StringUtils.replaceChars("abcba", "bc", "yzx")); 
     assertEquals("bcc", StringUtils.replaceChars("abc", "ab", "bc")); 
     assertEquals("q651.506bera", StringUtils.replaceChars("d216.102oren", "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ123456789", "nopqrstuvwxyzabcdefghijklmNOPQRSTUVWXYZABCDEFGHIJKLM567891234")); 
 }
@Test
public void testSplit_StringChar3583() { 
     assertArrayEquals(null, StringUtils.split(null, '.')); 
     assertEquals(0, StringUtils.split("", '.').length); 
     String str = "a.b.. c"; 
     String[] res = StringUtils.split(str, '.'); 
     assertEquals(3, res.length); 
     assertEquals("a", res[0]); 
     assertEquals("b", res[1]); 
     assertEquals(" c", res[2]); 
     str = ".a."; 
     res = StringUtils.split(str, '.'); 
     assertEquals(1, res.length); 
     assertEquals("a", res[0]); 
     str = "a b c"; 
     res = StringUtils.split(str, ' '); 
     assertEquals(3, res.length); 
     assertEquals("a", res[0]); 
     assertEquals("b", res[1]); 
     assertEquals("c", res[2]); 
 }
@Test
public void testJoin_IteratorString3602() { 
     assertEquals(null, StringUtils.join((Iterator<?>) null, null)); 
     assertEquals(TEXT_LIST_NOSEP, StringUtils.join(Arrays.asList(ARRAY_LIST).iterator(), null)); 
     assertEquals(TEXT_LIST_NOSEP, StringUtils.join(Arrays.asList(ARRAY_LIST).iterator(), "")); 
     assertEquals("foo", StringUtils.join(Collections.singleton("foo").iterator(), "x")); 
     assertEquals("foo", StringUtils.join(Collections.singleton("foo").iterator(), null)); 
     assertEquals("", StringUtils.join(Arrays.asList(NULL_ARRAY_LIST).iterator(), null)); 
     assertEquals("", StringUtils.join(Arrays.asList(EMPTY_ARRAY_LIST).iterator(), null)); 
     assertEquals("", StringUtils.join(Arrays.asList(EMPTY_ARRAY_LIST).iterator(), "")); 
     assertEquals("", StringUtils.join(Arrays.asList(EMPTY_ARRAY_LIST).iterator(), SEPARATOR)); 
     assertEquals(TEXT_LIST, StringUtils.join(Arrays.asList(ARRAY_LIST).iterator(), SEPARATOR)); 
 }
@Test
public void testPrependIfMissing3608() { 
     assertEquals("prependIfMissing(null,null)", null, StringUtils.prependIfMissing(null, null)); 
     assertEquals("prependIfMissing(abc,null)", "abc", StringUtils.prependIfMissing("abc", null)); 
     assertEquals("prependIfMissing(\"\",xyz)", "xyz", StringUtils.prependIfMissing("", "xyz")); 
     assertEquals("prependIfMissing(abc,xyz)", "xyzabc", StringUtils.prependIfMissing("abc", "xyz")); 
     assertEquals("prependIfMissing(xyzabc,xyz)", "xyzabc", StringUtils.prependIfMissing("xyzabc", "xyz")); 
     assertEquals("prependIfMissing(XYZabc,xyz)", "xyzXYZabc", StringUtils.prependIfMissing("XYZabc", "xyz")); 
     assertEquals("prependIfMissing(null,null null)", null, StringUtils.prependIfMissing(null, null, (CharSequence[]) null)); 
     assertEquals("prependIfMissing(abc,null,null)", "abc", StringUtils.prependIfMissing("abc", null, (CharSequence[]) null)); 
     assertEquals("prependIfMissing(\"\",xyz,null)", "xyz", StringUtils.prependIfMissing("", "xyz", (CharSequence[]) null)); 
     assertEquals("prependIfMissing(abc,xyz,{null})", "xyzabc", StringUtils.prependIfMissing("abc", "xyz", new CharSequence[] { null })); 
     assertEquals("prependIfMissing(abc,xyz,\"\")", "abc", StringUtils.prependIfMissing("abc", "xyz", "")); 
     assertEquals("prependIfMissing(abc,xyz,mno)", "xyzabc", StringUtils.prependIfMissing("abc", "xyz", "mno")); 
     assertEquals("prependIfMissing(xyzabc,xyz,mno)", "xyzabc", StringUtils.prependIfMissing("xyzabc", "xyz", "mno")); 
     assertEquals("prependIfMissing(mnoabc,xyz,mno)", "mnoabc", StringUtils.prependIfMissing("mnoabc", "xyz", "mno")); 
     assertEquals("prependIfMissing(XYZabc,xyz,mno)", "xyzXYZabc", StringUtils.prependIfMissing("XYZabc", "xyz", "mno")); 
     assertEquals("prependIfMissing(MNOabc,xyz,mno)", "xyzMNOabc", StringUtils.prependIfMissing("MNOabc", "xyz", "mno")); 
 }
@Test
public void testRepeat_StringInt3624() { 
     assertEquals(null, StringUtils.repeat(null, 2)); 
     assertEquals("", StringUtils.repeat("ab", 0)); 
     assertEquals("", StringUtils.repeat("", 3)); 
     assertEquals("aaa", StringUtils.repeat("a", 3)); 
     assertEquals("ababab", StringUtils.repeat("ab", 3)); 
     assertEquals("abcabcabc", StringUtils.repeat("abc", 3)); 
     final String str = StringUtils.repeat("a", 10000); 
     assertEquals(10000, str.length()); 
     assertTrue(StringUtils.containsOnly(str, new char[] { 'a' })); 
 }
@Test
public void testJoin_ArrayOfShorts3634() { 
     assertEquals(null, StringUtils.join((short[]) null, ',')); 
     assertEquals("1;2", StringUtils.join(SHORT_PRIM_LIST, SEPARATOR_CHAR)); 
     assertEquals("2", StringUtils.join(SHORT_PRIM_LIST, SEPARATOR_CHAR, 1, 2)); 
 }
@Test
public void testAbbreviateMiddle3643() { 
     assertNull(StringUtils.abbreviateMiddle(null, null, 0)); 
     assertEquals("abc", StringUtils.abbreviateMiddle("abc", null, 0)); 
     assertEquals("abc", StringUtils.abbreviateMiddle("abc", ".", 0)); 
     assertEquals("abc", StringUtils.abbreviateMiddle("abc", ".", 3)); 
     assertEquals("ab.f", StringUtils.abbreviateMiddle("abcdef", ".", 4)); 
     assertEquals("A very long text with un...f the text is complete.", StringUtils.abbreviateMiddle("A very long text with unimportant stuff in the middle but interesting start and " + "end to see if the text is complete.", "...", 50)); 
     final String longText = "Start text" + StringUtils.repeat("x", 10000) + "Close text"; 
     assertEquals("Start text->Close text", StringUtils.abbreviateMiddle(longText, "->", 22)); 
     assertEquals("abc", StringUtils.abbreviateMiddle("abc", ".", -1)); 
     assertEquals("abc", StringUtils.abbreviateMiddle("abc", ".", 1)); 
     assertEquals("abc", StringUtils.abbreviateMiddle("abc", ".", 2)); 
     assertEquals("a", StringUtils.abbreviateMiddle("a", ".", 1)); 
     assertEquals("a.d", StringUtils.abbreviateMiddle("abcd", ".", 3)); 
     assertEquals("a..f", StringUtils.abbreviateMiddle("abcdef", "..", 4)); 
     assertEquals("ab.ef", StringUtils.abbreviateMiddle("abcdef", ".", 5)); 
 }
@Test
public void testGetLevenshteinDistance_StringStringInt3713() { 
     assertEquals(0, StringUtils.getLevenshteinDistance("", "", 0)); 
     assertEquals(7, StringUtils.getLevenshteinDistance("aaapppp", "", 8)); 
     assertEquals(7, StringUtils.getLevenshteinDistance("aaapppp", "", 7)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("aaapppp", "", 6)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("b", "a", 0)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("a", "b", 0)); 
     assertEquals(0, StringUtils.getLevenshteinDistance("aa", "aa", 0)); 
     assertEquals(0, StringUtils.getLevenshteinDistance("aa", "aa", 2)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("aaa", "bbb", 2)); 
     assertEquals(3, StringUtils.getLevenshteinDistance("aaa", "bbb", 3)); 
     assertEquals(6, StringUtils.getLevenshteinDistance("aaaaaa", "b", 10)); 
     assertEquals(7, StringUtils.getLevenshteinDistance("aaapppp", "b", 8)); 
     assertEquals(3, StringUtils.getLevenshteinDistance("a", "bbb", 4)); 
     assertEquals(7, StringUtils.getLevenshteinDistance("aaapppp", "b", 7)); 
     assertEquals(3, StringUtils.getLevenshteinDistance("a", "bbb", 3)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("a", "bbb", 2)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("bbb", "a", 2)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("aaapppp", "b", 6)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("a", "bbb", 1)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("bbb", "a", 1)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("12345", "1234567", 1)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("1234567", "12345", 1)); 
     assertEquals(1, StringUtils.getLevenshteinDistance("frog", "fog", 1)); 
     assertEquals(3, StringUtils.getLevenshteinDistance("fly", "ant", 3)); 
     assertEquals(7, StringUtils.getLevenshteinDistance("elephant", "hippo", 7)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("elephant", "hippo", 6)); 
     assertEquals(7, StringUtils.getLevenshteinDistance("hippo", "elephant", 7)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("hippo", "elephant", 6)); 
     assertEquals(8, StringUtils.getLevenshteinDistance("hippo", "zzzzzzzz", 8)); 
     assertEquals(8, StringUtils.getLevenshteinDistance("zzzzzzzz", "hippo", 8)); 
     assertEquals(1, StringUtils.getLevenshteinDistance("hello", "hallo", 1)); 
     try { 
         @SuppressWarnings("unused") 
         final int d = StringUtils.getLevenshteinDistance("a", null, 0); 
         fail("expecting IllegalArgumentException"); 
     } catch (final IllegalArgumentException ex) { 
     } 
     try { 
         @SuppressWarnings("unused") 
         final int d = StringUtils.getLevenshteinDistance(null, "a", 0); 
         fail("expecting IllegalArgumentException"); 
     } catch (final IllegalArgumentException ex) { 
     } 
     try { 
         @SuppressWarnings("unused") 
         final int d = StringUtils.getLevenshteinDistance("a", "a", -1); 
         fail("expecting IllegalArgumentException"); 
     } catch (final IllegalArgumentException ex) { 
     } 
 }
@Test
public void testAbbreviateMiddle3717() { 
     assertNull(StringUtils.abbreviateMiddle(null, null, 0)); 
     assertEquals("abc", StringUtils.abbreviateMiddle("abc", null, 0)); 
     assertEquals("abc", StringUtils.abbreviateMiddle("abc", ".", 0)); 
     assertEquals("abc", StringUtils.abbreviateMiddle("abc", ".", 3)); 
     assertEquals("ab.f", StringUtils.abbreviateMiddle("abcdef", ".", 4)); 
     assertEquals("A very long text with un...f the text is complete.", StringUtils.abbreviateMiddle("A very long text with unimportant stuff in the middle but interesting start and " + "end to see if the text is complete.", "...", 50)); 
     final String longText = "Start text" + StringUtils.repeat("x", 10000) + "Close text"; 
     assertEquals("Start text->Close text", StringUtils.abbreviateMiddle(longText, "->", 22)); 
     assertEquals("abc", StringUtils.abbreviateMiddle("abc", ".", -1)); 
     assertEquals("abc", StringUtils.abbreviateMiddle("abc", ".", 1)); 
     assertEquals("abc", StringUtils.abbreviateMiddle("abc", ".", 2)); 
     assertEquals("a", StringUtils.abbreviateMiddle("a", ".", 1)); 
     assertEquals("a.d", StringUtils.abbreviateMiddle("abcd", ".", 3)); 
     assertEquals("a..f", StringUtils.abbreviateMiddle("abcdef", "..", 4)); 
     assertEquals("ab.ef", StringUtils.abbreviateMiddle("abcdef", ".", 5)); 
 }
@Test
public void testJoin_ArrayCharSeparator3734() { 
     assertEquals(null, StringUtils.join((Object[]) null, ',')); 
     assertEquals(TEXT_LIST_CHAR, StringUtils.join(ARRAY_LIST, SEPARATOR_CHAR)); 
     assertEquals("", StringUtils.join(EMPTY_ARRAY_LIST, SEPARATOR_CHAR)); 
     assertEquals(";;foo", StringUtils.join(MIXED_ARRAY_LIST, SEPARATOR_CHAR)); 
     assertEquals("foo;2", StringUtils.join(MIXED_TYPE_LIST, SEPARATOR_CHAR)); 
     assertEquals("/", StringUtils.join(MIXED_ARRAY_LIST, '/', 0, MIXED_ARRAY_LIST.length - 1)); 
     assertEquals("foo", StringUtils.join(MIXED_TYPE_LIST, '/', 0, 1)); 
     assertEquals("null", StringUtils.join(NULL_TO_STRING_LIST, '/', 0, 1)); 
     assertEquals("foo/2", StringUtils.join(MIXED_TYPE_LIST, '/', 0, 2)); 
     assertEquals("2", StringUtils.join(MIXED_TYPE_LIST, '/', 1, 2)); 
     assertEquals("", StringUtils.join(MIXED_TYPE_LIST, '/', 2, 1)); 
 }
@Test
public void testSplitByCharacterType3741() { 
     assertNull(StringUtils.splitByCharacterType(null)); 
     assertEquals(0, StringUtils.splitByCharacterType("").length); 
     assertTrue(ArrayUtils.isEquals(new String[] { "ab", " ", "de", " ", "fg" }, StringUtils.splitByCharacterType("ab de fg"))); 
     assertTrue(ArrayUtils.isEquals(new String[] { "ab", "   ", "de", " ", "fg" }, StringUtils.splitByCharacterType("ab   de fg"))); 
     assertTrue(ArrayUtils.isEquals(new String[] { "ab", ":", "cd", ":", "ef" }, StringUtils.splitByCharacterType("ab:cd:ef"))); 
     assertTrue(ArrayUtils.isEquals(new String[] { "number", "5" }, StringUtils.splitByCharacterType("number5"))); 
     assertTrue(ArrayUtils.isEquals(new String[] { "foo", "B", "ar" }, StringUtils.splitByCharacterType("fooBar"))); 
     assertTrue(ArrayUtils.isEquals(new String[] { "foo", "200", "B", "ar" }, StringUtils.splitByCharacterType("foo200Bar"))); 
     assertTrue(ArrayUtils.isEquals(new String[] { "ASFR", "ules" }, StringUtils.splitByCharacterType("ASFRules"))); 
 }
@Test
public void testJoin_IterableString3761() { 
     assertEquals(null, StringUtils.join((Iterable<?>) null, null)); 
     assertEquals(TEXT_LIST_NOSEP, StringUtils.join(Arrays.asList(ARRAY_LIST), null)); 
     assertEquals(TEXT_LIST_NOSEP, StringUtils.join(Arrays.asList(ARRAY_LIST), "")); 
     assertEquals("foo", StringUtils.join(Collections.singleton("foo"), "x")); 
     assertEquals("foo", StringUtils.join(Collections.singleton("foo"), null)); 
     assertEquals("", StringUtils.join(Arrays.asList(NULL_ARRAY_LIST), null)); 
     assertEquals("", StringUtils.join(Arrays.asList(EMPTY_ARRAY_LIST), null)); 
     assertEquals("", StringUtils.join(Arrays.asList(EMPTY_ARRAY_LIST), "")); 
     assertEquals("", StringUtils.join(Arrays.asList(EMPTY_ARRAY_LIST), SEPARATOR)); 
     assertEquals(TEXT_LIST, StringUtils.join(Arrays.asList(ARRAY_LIST), SEPARATOR)); 
 }
@Test
public void testOverlay_StringStringIntInt3762() { 
     assertEquals(null, StringUtils.overlay(null, null, 2, 4)); 
     assertEquals(null, StringUtils.overlay(null, null, -2, -4)); 
     assertEquals("", StringUtils.overlay("", null, 0, 0)); 
     assertEquals("", StringUtils.overlay("", "", 0, 0)); 
     assertEquals("zzzz", StringUtils.overlay("", "zzzz", 0, 0)); 
     assertEquals("zzzz", StringUtils.overlay("", "zzzz", 2, 4)); 
     assertEquals("zzzz", StringUtils.overlay("", "zzzz", -2, -4)); 
     assertEquals("abef", StringUtils.overlay("abcdef", null, 2, 4)); 
     assertEquals("abef", StringUtils.overlay("abcdef", null, 4, 2)); 
     assertEquals("abef", StringUtils.overlay("abcdef", "", 2, 4)); 
     assertEquals("abef", StringUtils.overlay("abcdef", "", 4, 2)); 
     assertEquals("abzzzzef", StringUtils.overlay("abcdef", "zzzz", 2, 4)); 
     assertEquals("abzzzzef", StringUtils.overlay("abcdef", "zzzz", 4, 2)); 
     assertEquals("zzzzef", StringUtils.overlay("abcdef", "zzzz", -1, 4)); 
     assertEquals("zzzzef", StringUtils.overlay("abcdef", "zzzz", 4, -1)); 
     assertEquals("zzzzabcdef", StringUtils.overlay("abcdef", "zzzz", -2, -1)); 
     assertEquals("zzzzabcdef", StringUtils.overlay("abcdef", "zzzz", -1, -2)); 
     assertEquals("abcdzzzz", StringUtils.overlay("abcdef", "zzzz", 4, 10)); 
     assertEquals("abcdzzzz", StringUtils.overlay("abcdef", "zzzz", 10, 4)); 
     assertEquals("abcdefzzzz", StringUtils.overlay("abcdef", "zzzz", 8, 10)); 
     assertEquals("abcdefzzzz", StringUtils.overlay("abcdef", "zzzz", 10, 8)); 
 }
@Test
public void testRepeat_StringInt3771() { 
     assertEquals(null, StringUtils.repeat(null, 2)); 
     assertEquals("", StringUtils.repeat("ab", 0)); 
     assertEquals("", StringUtils.repeat("", 3)); 
     assertEquals("aaa", StringUtils.repeat("a", 3)); 
     assertEquals("ababab", StringUtils.repeat("ab", 3)); 
     assertEquals("abcabcabc", StringUtils.repeat("abc", 3)); 
     final String str = StringUtils.repeat("a", 10000); 
     assertEquals(10000, str.length()); 
     assertTrue(StringUtils.containsOnly(str, new char[] { 'a' })); 
 }
@Test
public void testGetCommonPrefix_StringArray3778() { 
     assertEquals("", StringUtils.getCommonPrefix((String[]) null)); 
     assertEquals("", StringUtils.getCommonPrefix()); 
     assertEquals("abc", StringUtils.getCommonPrefix("abc")); 
     assertEquals("", StringUtils.getCommonPrefix(null, null)); 
     assertEquals("", StringUtils.getCommonPrefix("", "")); 
     assertEquals("", StringUtils.getCommonPrefix("", null)); 
     assertEquals("", StringUtils.getCommonPrefix("abc", null, null)); 
     assertEquals("", StringUtils.getCommonPrefix(null, null, "abc")); 
     assertEquals("", StringUtils.getCommonPrefix("", "abc")); 
     assertEquals("", StringUtils.getCommonPrefix("abc", "")); 
     assertEquals("abc", StringUtils.getCommonPrefix("abc", "abc")); 
     assertEquals("a", StringUtils.getCommonPrefix("abc", "a")); 
     assertEquals("ab", StringUtils.getCommonPrefix("ab", "abxyz")); 
     assertEquals("ab", StringUtils.getCommonPrefix("abcde", "abxyz")); 
     assertEquals("", StringUtils.getCommonPrefix("abcde", "xyz")); 
     assertEquals("", StringUtils.getCommonPrefix("xyz", "abcde")); 
     assertEquals("i am a ", StringUtils.getCommonPrefix("i am a machine", "i am a robot")); 
 }
@Test
public void testGetLevenshteinDistance_StringStringInt3781() { 
     assertEquals(0, StringUtils.getLevenshteinDistance("", "", 0)); 
     assertEquals(7, StringUtils.getLevenshteinDistance("aaapppp", "", 8)); 
     assertEquals(7, StringUtils.getLevenshteinDistance("aaapppp", "", 7)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("aaapppp", "", 6)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("b", "a", 0)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("a", "b", 0)); 
     assertEquals(0, StringUtils.getLevenshteinDistance("aa", "aa", 0)); 
     assertEquals(0, StringUtils.getLevenshteinDistance("aa", "aa", 2)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("aaa", "bbb", 2)); 
     assertEquals(3, StringUtils.getLevenshteinDistance("aaa", "bbb", 3)); 
     assertEquals(6, StringUtils.getLevenshteinDistance("aaaaaa", "b", 10)); 
     assertEquals(7, StringUtils.getLevenshteinDistance("aaapppp", "b", 8)); 
     assertEquals(3, StringUtils.getLevenshteinDistance("a", "bbb", 4)); 
     assertEquals(7, StringUtils.getLevenshteinDistance("aaapppp", "b", 7)); 
     assertEquals(3, StringUtils.getLevenshteinDistance("a", "bbb", 3)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("a", "bbb", 2)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("bbb", "a", 2)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("aaapppp", "b", 6)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("a", "bbb", 1)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("bbb", "a", 1)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("12345", "1234567", 1)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("1234567", "12345", 1)); 
     assertEquals(1, StringUtils.getLevenshteinDistance("frog", "fog", 1)); 
     assertEquals(3, StringUtils.getLevenshteinDistance("fly", "ant", 3)); 
     assertEquals(7, StringUtils.getLevenshteinDistance("elephant", "hippo", 7)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("elephant", "hippo", 6)); 
     assertEquals(7, StringUtils.getLevenshteinDistance("hippo", "elephant", 7)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("hippo", "elephant", 6)); 
     assertEquals(8, StringUtils.getLevenshteinDistance("hippo", "zzzzzzzz", 8)); 
     assertEquals(8, StringUtils.getLevenshteinDistance("zzzzzzzz", "hippo", 8)); 
     assertEquals(1, StringUtils.getLevenshteinDistance("hello", "hallo", 1)); 
     try { 
         @SuppressWarnings("unused") 
         final int d = StringUtils.getLevenshteinDistance("a", null, 0); 
         fail("expecting IllegalArgumentException"); 
     } catch (final IllegalArgumentException ex) { 
     } 
     try { 
         @SuppressWarnings("unused") 
         final int d = StringUtils.getLevenshteinDistance(null, "a", 0); 
         fail("expecting IllegalArgumentException"); 
     } catch (final IllegalArgumentException ex) { 
     } 
     try { 
         @SuppressWarnings("unused") 
         final int d = StringUtils.getLevenshteinDistance("a", "a", -1); 
         fail("expecting IllegalArgumentException"); 
     } catch (final IllegalArgumentException ex) { 
     } 
 }
@Test
public void testGetCommonPrefix_StringArray3788() { 
     assertEquals("", StringUtils.getCommonPrefix((String[]) null)); 
     assertEquals("", StringUtils.getCommonPrefix()); 
     assertEquals("abc", StringUtils.getCommonPrefix("abc")); 
     assertEquals("", StringUtils.getCommonPrefix(null, null)); 
     assertEquals("", StringUtils.getCommonPrefix("", "")); 
     assertEquals("", StringUtils.getCommonPrefix("", null)); 
     assertEquals("", StringUtils.getCommonPrefix("abc", null, null)); 
     assertEquals("", StringUtils.getCommonPrefix(null, null, "abc")); 
     assertEquals("", StringUtils.getCommonPrefix("", "abc")); 
     assertEquals("", StringUtils.getCommonPrefix("abc", "")); 
     assertEquals("abc", StringUtils.getCommonPrefix("abc", "abc")); 
     assertEquals("a", StringUtils.getCommonPrefix("abc", "a")); 
     assertEquals("ab", StringUtils.getCommonPrefix("ab", "abxyz")); 
     assertEquals("ab", StringUtils.getCommonPrefix("abcde", "abxyz")); 
     assertEquals("", StringUtils.getCommonPrefix("abcde", "xyz")); 
     assertEquals("", StringUtils.getCommonPrefix("xyz", "abcde")); 
     assertEquals("i am a ", StringUtils.getCommonPrefix("i am a machine", "i am a robot")); 
 }
@Test
public void testAbbreviateMiddle3794() { 
     assertNull(StringUtils.abbreviateMiddle(null, null, 0)); 
     assertEquals("abc", StringUtils.abbreviateMiddle("abc", null, 0)); 
     assertEquals("abc", StringUtils.abbreviateMiddle("abc", ".", 0)); 
     assertEquals("abc", StringUtils.abbreviateMiddle("abc", ".", 3)); 
     assertEquals("ab.f", StringUtils.abbreviateMiddle("abcdef", ".", 4)); 
     assertEquals("A very long text with un...f the text is complete.", StringUtils.abbreviateMiddle("A very long text with unimportant stuff in the middle but interesting start and " + "end to see if the text is complete.", "...", 50)); 
     final String longText = "Start text" + StringUtils.repeat("x", 10000) + "Close text"; 
     assertEquals("Start text->Close text", StringUtils.abbreviateMiddle(longText, "->", 22)); 
     assertEquals("abc", StringUtils.abbreviateMiddle("abc", ".", -1)); 
     assertEquals("abc", StringUtils.abbreviateMiddle("abc", ".", 1)); 
     assertEquals("abc", StringUtils.abbreviateMiddle("abc", ".", 2)); 
     assertEquals("a", StringUtils.abbreviateMiddle("a", ".", 1)); 
     assertEquals("a.d", StringUtils.abbreviateMiddle("abcd", ".", 3)); 
     assertEquals("a..f", StringUtils.abbreviateMiddle("abcdef", "..", 4)); 
     assertEquals("ab.ef", StringUtils.abbreviateMiddle("abcdef", ".", 5)); 
 }
@Test
public void testSwapCase_String3812() { 
     assertEquals(null, StringUtils.swapCase(null)); 
     assertEquals("", StringUtils.swapCase("")); 
     assertEquals("  ", StringUtils.swapCase("  ")); 
     assertEquals("i", WordUtils.swapCase("I")); 
     assertEquals("I", WordUtils.swapCase("i")); 
     assertEquals("I AM HERE 123", StringUtils.swapCase("i am here 123")); 
     assertEquals("i aM hERE 123", StringUtils.swapCase("I Am Here 123")); 
     assertEquals("I AM here 123", StringUtils.swapCase("i am HERE 123")); 
     assertEquals("i am here 123", StringUtils.swapCase("I AM HERE 123")); 
     final String test = "This String contains a TitleCase character: \u01C8"; 
     final String expect = "tHIS sTRING CONTAINS A tITLEcASE CHARACTER: \u01C9"; 
     assertEquals(expect, WordUtils.swapCase(test)); 
 }
@Test
public void testReplace_StringStringArrayStringArray3818() { 
     assertNull(StringUtils.replaceEach(null, new String[] { "a" }, new String[] { "b" })); 
     assertEquals(StringUtils.replaceEach("", new String[] { "a" }, new String[] { "b" }), ""); 
     assertEquals(StringUtils.replaceEach("aba", null, null), "aba"); 
     assertEquals(StringUtils.replaceEach("aba", new String[0], null), "aba"); 
     assertEquals(StringUtils.replaceEach("aba", null, new String[0]), "aba"); 
     assertEquals(StringUtils.replaceEach("aba", new String[] { "a" }, null), "aba"); 
     assertEquals(StringUtils.replaceEach("aba", new String[] { "a" }, new String[] { "" }), "b"); 
     assertEquals(StringUtils.replaceEach("aba", new String[] { null }, new String[] { "a" }), "aba"); 
     assertEquals(StringUtils.replaceEach("abcde", new String[] { "ab", "d" }, new String[] { "w", "t" }), "wcte"); 
     assertEquals(StringUtils.replaceEach("abcde", new String[] { "ab", "d" }, new String[] { "d", "t" }), "dcte"); 
     assertEquals("bcc", StringUtils.replaceEach("abc", new String[] { "a", "b" }, new String[] { "b", "c" })); 
     assertEquals("q651.506bera", StringUtils.replaceEach("d216.102oren", new String[] { "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "1", "2", "3", "4", "5", "6", "7", "8", "9" }, new String[] { "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z", "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "5", "6", "7", "8", "9", "1", "2", "3", "4" })); 
     assertEquals(StringUtils.replaceEach("aba", new String[] { "a" }, new String[] { null }), "aba"); 
     assertEquals(StringUtils.replaceEach("aba", new String[] { "a", "b" }, new String[] { "c", null }), "cbc"); 
 }
@Test
public void testIsAllLowerCase3844() { 
     assertFalse(StringUtils.isAllLowerCase(null)); 
     assertFalse(StringUtils.isAllLowerCase(StringUtils.EMPTY)); 
     assertTrue(StringUtils.isAllLowerCase("abc")); 
     assertFalse(StringUtils.isAllLowerCase("abc ")); 
     assertFalse(StringUtils.isAllLowerCase("abC")); 
 }
@Test
public void testEscapeSurrogatePairsLang8583852() throws Exception { 
     assertEquals("\\uDBFF\\uDFFD", StringEscapeUtils.escapeJava("\uDBFF\uDFFD")); 
     assertEquals("\\uDBFF\\uDFFD", StringEscapeUtils.escapeEcmaScript("\uDBFF\uDFFD")); 
 }
@Test
public void testJoin_ArrayOfBytes3855() { 
     assertEquals(null, StringUtils.join((byte[]) null, ',')); 
     assertEquals("1;2", StringUtils.join(BYTE_PRIM_LIST, SEPARATOR_CHAR)); 
     assertEquals("2", StringUtils.join(BYTE_PRIM_LIST, SEPARATOR_CHAR, 1, 2)); 
 }
@Test
public void testDifference_StringString3873() { 
     assertEquals(null, StringUtils.difference(null, null)); 
     assertEquals("", StringUtils.difference("", "")); 
     assertEquals("abc", StringUtils.difference("", "abc")); 
     assertEquals("", StringUtils.difference("abc", "")); 
     assertEquals("i am a robot", StringUtils.difference(null, "i am a robot")); 
     assertEquals("i am a machine", StringUtils.difference("i am a machine", null)); 
     assertEquals("robot", StringUtils.difference("i am a machine", "i am a robot")); 
     assertEquals("", StringUtils.difference("abc", "abc")); 
     assertEquals("you are a robot", StringUtils.difference("i am a robot", "you are a robot")); 
 }
@Test
public void testSplitByWholeString_StringStringBooleanInt3874() { 
     assertArrayEquals(null, StringUtils.splitByWholeSeparator(null, ".", 3)); 
     assertEquals(0, StringUtils.splitByWholeSeparator("", ".", 3).length); 
     final String stringToSplitOnNulls = "ab   de fg"; 
     final String[] splitOnNullExpectedResults = { "ab", "de fg" }; 
     final String[] splitOnNullResults = StringUtils.splitByWholeSeparator(stringToSplitOnNulls, null, 2); 
     assertEquals(splitOnNullExpectedResults.length, splitOnNullResults.length); 
     for (int i = 0; i < splitOnNullExpectedResults.length; i += 1) { 
         assertEquals(splitOnNullExpectedResults[i], splitOnNullResults[i]); 
     } 
     final String stringToSplitOnCharactersAndString = "abstemiouslyaeiouyabstemiouslyaeiouyabstemiously"; 
     final String[] splitOnStringExpectedResults = { "abstemiously", "abstemiouslyaeiouyabstemiously" }; 
     final String[] splitOnStringResults = StringUtils.splitByWholeSeparator(stringToSplitOnCharactersAndString, "aeiouy", 2); 
     assertEquals(splitOnStringExpectedResults.length, splitOnStringResults.length); 
     for (int i = 0; i < splitOnStringExpectedResults.length; i++) { 
         assertEquals(splitOnStringExpectedResults[i], splitOnStringResults[i]); 
     } 
 }
@Test
public void testRepeat_StringInt3875() { 
     assertEquals(null, StringUtils.repeat(null, 2)); 
     assertEquals("", StringUtils.repeat("ab", 0)); 
     assertEquals("", StringUtils.repeat("", 3)); 
     assertEquals("aaa", StringUtils.repeat("a", 3)); 
     assertEquals("ababab", StringUtils.repeat("ab", 3)); 
     assertEquals("abcabcabc", StringUtils.repeat("abc", 3)); 
     final String str = StringUtils.repeat("a", 10000); 
     assertEquals(10000, str.length()); 
     assertTrue(StringUtils.containsOnly(str, new char[] { 'a' })); 
 }
@Test
public void testRepeat_StringInt3880() { 
     assertEquals(null, StringUtils.repeat(null, 2)); 
     assertEquals("", StringUtils.repeat("ab", 0)); 
     assertEquals("", StringUtils.repeat("", 3)); 
     assertEquals("aaa", StringUtils.repeat("a", 3)); 
     assertEquals("ababab", StringUtils.repeat("ab", 3)); 
     assertEquals("abcabcabc", StringUtils.repeat("abc", 3)); 
     final String str = StringUtils.repeat("a", 10000); 
     assertEquals(10000, str.length()); 
     assertTrue(StringUtils.containsOnly(str, new char[] { 'a' })); 
 }
@Test
public void testGetCommonPrefix_StringArray3900() { 
     assertEquals("", StringUtils.getCommonPrefix((String[]) null)); 
     assertEquals("", StringUtils.getCommonPrefix()); 
     assertEquals("abc", StringUtils.getCommonPrefix("abc")); 
     assertEquals("", StringUtils.getCommonPrefix(null, null)); 
     assertEquals("", StringUtils.getCommonPrefix("", "")); 
     assertEquals("", StringUtils.getCommonPrefix("", null)); 
     assertEquals("", StringUtils.getCommonPrefix("abc", null, null)); 
     assertEquals("", StringUtils.getCommonPrefix(null, null, "abc")); 
     assertEquals("", StringUtils.getCommonPrefix("", "abc")); 
     assertEquals("", StringUtils.getCommonPrefix("abc", "")); 
     assertEquals("abc", StringUtils.getCommonPrefix("abc", "abc")); 
     assertEquals("a", StringUtils.getCommonPrefix("abc", "a")); 
     assertEquals("ab", StringUtils.getCommonPrefix("ab", "abxyz")); 
     assertEquals("ab", StringUtils.getCommonPrefix("abcde", "abxyz")); 
     assertEquals("", StringUtils.getCommonPrefix("abcde", "xyz")); 
     assertEquals("", StringUtils.getCommonPrefix("xyz", "abcde")); 
     assertEquals("i am a ", StringUtils.getCommonPrefix("i am a machine", "i am a robot")); 
 }
@Test
public void testJoin_IterableString3906() { 
     assertEquals(null, StringUtils.join((Iterable<?>) null, null)); 
     assertEquals(TEXT_LIST_NOSEP, StringUtils.join(Arrays.asList(ARRAY_LIST), null)); 
     assertEquals(TEXT_LIST_NOSEP, StringUtils.join(Arrays.asList(ARRAY_LIST), "")); 
     assertEquals("foo", StringUtils.join(Collections.singleton("foo"), "x")); 
     assertEquals("foo", StringUtils.join(Collections.singleton("foo"), null)); 
     assertEquals("", StringUtils.join(Arrays.asList(NULL_ARRAY_LIST), null)); 
     assertEquals("", StringUtils.join(Arrays.asList(EMPTY_ARRAY_LIST), null)); 
     assertEquals("", StringUtils.join(Arrays.asList(EMPTY_ARRAY_LIST), "")); 
     assertEquals("", StringUtils.join(Arrays.asList(EMPTY_ARRAY_LIST), SEPARATOR)); 
     assertEquals(TEXT_LIST, StringUtils.join(Arrays.asList(ARRAY_LIST), SEPARATOR)); 
 }
@Test
public void testJoin_IterableChar3922() { 
     assertEquals(null, StringUtils.join((Iterable<?>) null, ',')); 
     assertEquals(TEXT_LIST_CHAR, StringUtils.join(Arrays.asList(ARRAY_LIST), SEPARATOR_CHAR)); 
     assertEquals("", StringUtils.join(Arrays.asList(NULL_ARRAY_LIST), SEPARATOR_CHAR)); 
     assertEquals("", StringUtils.join(Arrays.asList(EMPTY_ARRAY_LIST), SEPARATOR_CHAR)); 
     assertEquals("foo", StringUtils.join(Collections.singleton("foo"), 'x')); 
 }
@Test
public void testNormalizeSpace3927() { 
     assertEquals(null, StringUtils.normalizeSpace(null)); 
     assertEquals("", StringUtils.normalizeSpace("")); 
     assertEquals("", StringUtils.normalizeSpace(" ")); 
     assertEquals("", StringUtils.normalizeSpace("\t")); 
     assertEquals("", StringUtils.normalizeSpace("\n")); 
     assertEquals("", StringUtils.normalizeSpace("\u0009")); 
     assertEquals("", StringUtils.normalizeSpace("\u000B")); 
     assertEquals("", StringUtils.normalizeSpace("\u000C")); 
     assertEquals("", StringUtils.normalizeSpace("\u001C")); 
     assertEquals("", StringUtils.normalizeSpace("\u001D")); 
     assertEquals("", StringUtils.normalizeSpace("\u001E")); 
     assertEquals("", StringUtils.normalizeSpace("\u001F")); 
     assertEquals("", StringUtils.normalizeSpace("\f")); 
     assertEquals("", StringUtils.normalizeSpace("\r")); 
     assertEquals("a", StringUtils.normalizeSpace("  a  ")); 
     assertEquals("a b c", StringUtils.normalizeSpace("  a  b   c  ")); 
     assertEquals("a b c", StringUtils.normalizeSpace("a\t\f\r  b\u000B   c\n")); 
 }
@Test
public void testRepeat_StringInt3940() { 
     assertEquals(null, StringUtils.repeat(null, 2)); 
     assertEquals("", StringUtils.repeat("ab", 0)); 
     assertEquals("", StringUtils.repeat("", 3)); 
     assertEquals("aaa", StringUtils.repeat("a", 3)); 
     assertEquals("ababab", StringUtils.repeat("ab", 3)); 
     assertEquals("abcabcabc", StringUtils.repeat("abc", 3)); 
     final String str = StringUtils.repeat("a", 10000); 
     assertEquals(10000, str.length()); 
     assertTrue(StringUtils.containsOnly(str, new char[] { 'a' })); 
 }
@Test
public void testSplit_String3981() { 
     assertArrayEquals(null, StringUtils.split(null)); 
     assertEquals(0, StringUtils.split("").length); 
     String str = "a b  .c"; 
     String[] res = StringUtils.split(str); 
     assertEquals(3, res.length); 
     assertEquals("a", res[0]); 
     assertEquals("b", res[1]); 
     assertEquals(".c", res[2]); 
     str = " a "; 
     res = StringUtils.split(str); 
     assertEquals(1, res.length); 
     assertEquals("a", res[0]); 
     str = "a" + WHITESPACE + "b" + NON_WHITESPACE + "c"; 
     res = StringUtils.split(str); 
     assertEquals(2, res.length); 
     assertEquals("a", res[0]); 
     assertEquals("b" + NON_WHITESPACE + "c", res[1]); 
 }
@Test
public void testRemoveStartIgnoreCase4005() { 
     assertNull("removeStartIgnoreCase(null, null)", StringUtils.removeStartIgnoreCase(null, null)); 
     assertNull("removeStartIgnoreCase(null, \"\")", StringUtils.removeStartIgnoreCase(null, "")); 
     assertNull("removeStartIgnoreCase(null, \"a\")", StringUtils.removeStartIgnoreCase(null, "a")); 
     assertEquals("removeStartIgnoreCase(\"\", null)", StringUtils.removeStartIgnoreCase("", null), ""); 
     assertEquals("removeStartIgnoreCase(\"\", \"\")", StringUtils.removeStartIgnoreCase("", ""), ""); 
     assertEquals("removeStartIgnoreCase(\"\", \"a\")", StringUtils.removeStartIgnoreCase("", "a"), ""); 
     assertEquals("removeStartIgnoreCase(\"www.domain.com\", \"www.\")", StringUtils.removeStartIgnoreCase("www.domain.com", "www."), "domain.com"); 
     assertEquals("removeStartIgnoreCase(\"domain.com\", \"www.\")", StringUtils.removeStartIgnoreCase("domain.com", "www."), "domain.com"); 
     assertEquals("removeStartIgnoreCase(\"domain.com\", \"\")", StringUtils.removeStartIgnoreCase("domain.com", ""), "domain.com"); 
     assertEquals("removeStartIgnoreCase(\"domain.com\", null)", StringUtils.removeStartIgnoreCase("domain.com", null), "domain.com"); 
     assertEquals("removeStartIgnoreCase(\"www.domain.com\", \"WWW.\")", StringUtils.removeStartIgnoreCase("www.domain.com", "WWW."), "domain.com"); 
 }
@Test
public void testJoin_IterableString4007() { 
     assertEquals(null, StringUtils.join((Iterable<?>) null, null)); 
     assertEquals(TEXT_LIST_NOSEP, StringUtils.join(Arrays.asList(ARRAY_LIST), null)); 
     assertEquals(TEXT_LIST_NOSEP, StringUtils.join(Arrays.asList(ARRAY_LIST), "")); 
     assertEquals("foo", StringUtils.join(Collections.singleton("foo"), "x")); 
     assertEquals("foo", StringUtils.join(Collections.singleton("foo"), null)); 
     assertEquals("", StringUtils.join(Arrays.asList(NULL_ARRAY_LIST), null)); 
     assertEquals("", StringUtils.join(Arrays.asList(EMPTY_ARRAY_LIST), null)); 
     assertEquals("", StringUtils.join(Arrays.asList(EMPTY_ARRAY_LIST), "")); 
     assertEquals("", StringUtils.join(Arrays.asList(EMPTY_ARRAY_LIST), SEPARATOR)); 
     assertEquals(TEXT_LIST, StringUtils.join(Arrays.asList(ARRAY_LIST), SEPARATOR)); 
 }
@Test
public void testRemove_char4023() { 
     assertEquals(null, StringUtils.remove(null, 'a')); 
     assertEquals(null, StringUtils.remove(null, 'a')); 
     assertEquals(null, StringUtils.remove(null, 'a')); 
     assertEquals("", StringUtils.remove("", 'a')); 
     assertEquals("", StringUtils.remove("", 'a')); 
     assertEquals("", StringUtils.remove("", 'a')); 
     assertEquals("qeed", StringUtils.remove("queued", 'u')); 
     assertEquals("queued", StringUtils.remove("queued", 'z')); 
 }
@Test
public void testReplaceChars_StringStringString4024() { 
     assertEquals(null, StringUtils.replaceChars(null, null, null)); 
     assertEquals(null, StringUtils.replaceChars(null, "", null)); 
     assertEquals(null, StringUtils.replaceChars(null, "a", null)); 
     assertEquals(null, StringUtils.replaceChars(null, null, "")); 
     assertEquals(null, StringUtils.replaceChars(null, null, "x")); 
     assertEquals("", StringUtils.replaceChars("", null, null)); 
     assertEquals("", StringUtils.replaceChars("", "", null)); 
     assertEquals("", StringUtils.replaceChars("", "a", null)); 
     assertEquals("", StringUtils.replaceChars("", null, "")); 
     assertEquals("", StringUtils.replaceChars("", null, "x")); 
     assertEquals("abc", StringUtils.replaceChars("abc", null, null)); 
     assertEquals("abc", StringUtils.replaceChars("abc", null, "")); 
     assertEquals("abc", StringUtils.replaceChars("abc", null, "x")); 
     assertEquals("abc", StringUtils.replaceChars("abc", "", null)); 
     assertEquals("abc", StringUtils.replaceChars("abc", "", "")); 
     assertEquals("abc", StringUtils.replaceChars("abc", "", "x")); 
     assertEquals("ac", StringUtils.replaceChars("abc", "b", null)); 
     assertEquals("ac", StringUtils.replaceChars("abc", "b", "")); 
     assertEquals("axc", StringUtils.replaceChars("abc", "b", "x")); 
     assertEquals("ayzya", StringUtils.replaceChars("abcba", "bc", "yz")); 
     assertEquals("ayya", StringUtils.replaceChars("abcba", "bc", "y")); 
     assertEquals("ayzya", StringUtils.replaceChars("abcba", "bc", "yzx")); 
     assertEquals("abcba", StringUtils.replaceChars("abcba", "z", "w")); 
     assertSame("abcba", StringUtils.replaceChars("abcba", "z", "w")); 
     assertEquals("jelly", StringUtils.replaceChars("hello", "ho", "jy")); 
     assertEquals("ayzya", StringUtils.replaceChars("abcba", "bc", "yz")); 
     assertEquals("ayya", StringUtils.replaceChars("abcba", "bc", "y")); 
     assertEquals("ayzya", StringUtils.replaceChars("abcba", "bc", "yzx")); 
     assertEquals("bcc", StringUtils.replaceChars("abc", "ab", "bc")); 
     assertEquals("q651.506bera", StringUtils.replaceChars("d216.102oren", "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ123456789", "nopqrstuvwxyzabcdefghijklmNOPQRSTUVWXYZABCDEFGHIJKLM567891234")); 
 }
@Test
public void testSplitByCharacterType4027() { 
     assertNull(StringUtils.splitByCharacterType(null)); 
     assertEquals(0, StringUtils.splitByCharacterType("").length); 
     assertTrue(ArrayUtils.isEquals(new String[] { "ab", " ", "de", " ", "fg" }, StringUtils.splitByCharacterType("ab de fg"))); 
     assertTrue(ArrayUtils.isEquals(new String[] { "ab", "   ", "de", " ", "fg" }, StringUtils.splitByCharacterType("ab   de fg"))); 
     assertTrue(ArrayUtils.isEquals(new String[] { "ab", ":", "cd", ":", "ef" }, StringUtils.splitByCharacterType("ab:cd:ef"))); 
     assertTrue(ArrayUtils.isEquals(new String[] { "number", "5" }, StringUtils.splitByCharacterType("number5"))); 
     assertTrue(ArrayUtils.isEquals(new String[] { "foo", "B", "ar" }, StringUtils.splitByCharacterType("fooBar"))); 
     assertTrue(ArrayUtils.isEquals(new String[] { "foo", "200", "B", "ar" }, StringUtils.splitByCharacterType("foo200Bar"))); 
     assertTrue(ArrayUtils.isEquals(new String[] { "ASFR", "ules" }, StringUtils.splitByCharacterType("ASFRules"))); 
 }
@Test
public void testDefaultIfBlank_StringBuffers4028() { 
     assertEquals("NULL", StringUtils.defaultIfBlank(new StringBuffer(""), new StringBuffer("NULL")).toString()); 
     assertEquals("NULL", StringUtils.defaultIfBlank(new StringBuffer(" "), new StringBuffer("NULL")).toString()); 
     assertEquals("abc", StringUtils.defaultIfBlank(new StringBuffer("abc"), new StringBuffer("NULL")).toString()); 
     assertNull(StringUtils.defaultIfBlank(new StringBuffer(""), null)); 
     final StringBuffer s = StringUtils.defaultIfBlank(new StringBuffer("abc"), new StringBuffer("NULL")); 
     assertEquals("abc", s.toString()); 
 }
@Test
public void testDefaultIfEmpty_StringBuffers4042() { 
     assertEquals("NULL", StringUtils.defaultIfEmpty(new StringBuffer(""), new StringBuffer("NULL")).toString()); 
     assertEquals("abc", StringUtils.defaultIfEmpty(new StringBuffer("abc"), new StringBuffer("NULL")).toString()); 
     assertNull(StringUtils.defaultIfEmpty(new StringBuffer(""), null)); 
     final StringBuffer s = StringUtils.defaultIfEmpty(new StringBuffer("abc"), new StringBuffer("NULL")); 
     assertEquals("abc", s.toString()); 
 }
@Test
public void testRepeat_StringStringInt4071() { 
     assertEquals(null, StringUtils.repeat(null, null, 2)); 
     assertEquals(null, StringUtils.repeat(null, "x", 2)); 
     assertEquals("", StringUtils.repeat("", null, 2)); 
     assertEquals("", StringUtils.repeat("ab", "", 0)); 
     assertEquals("", StringUtils.repeat("", "", 2)); 
     assertEquals("xx", StringUtils.repeat("", "x", 3)); 
     assertEquals("?, ?, ?", StringUtils.repeat("?", ", ", 3)); 
 } 
@SuppressWarnings("deprecation")
@Test
public void testChomp4076() { 
     final String[][] chompCases = { { FOO_UNCAP + "\r\n", FOO_UNCAP }, { FOO_UNCAP + "\n", FOO_UNCAP }, { FOO_UNCAP + "\r", FOO_UNCAP }, { FOO_UNCAP + " \r", FOO_UNCAP + " " }, { FOO_UNCAP, FOO_UNCAP }, { FOO_UNCAP + "\n\n", FOO_UNCAP + "\n" }, { FOO_UNCAP + "\r\n\r\n", FOO_UNCAP + "\r\n" }, { "foo\nfoo", "foo\nfoo" }, { "foo\n\rfoo", "foo\n\rfoo" }, { "\n", "" }, { "\r", "" }, { "a", "a" }, { "\r\n", "" }, { "", "" }, { null, null }, { FOO_UNCAP + "\n\r", FOO_UNCAP + "\n" } }; 
     for (final String[] chompCase : chompCases) { 
         final String original = chompCase[0]; 
         final String expectedResult = chompCase[1]; 
         assertEquals("chomp(String) failed", expectedResult, StringUtils.chomp(original)); 
     } 
     assertEquals("chomp(String, String) failed", "foo", StringUtils.chomp("foobar", "bar")); 
     assertEquals("chomp(String, String) failed", "foobar", StringUtils.chomp("foobar", "baz")); 
     assertEquals("chomp(String, String) failed", "foo", StringUtils.chomp("foo", "foooo")); 
     assertEquals("chomp(String, String) failed", "foobar", StringUtils.chomp("foobar", "")); 
     assertEquals("chomp(String, String) failed", "foobar", StringUtils.chomp("foobar", null)); 
     assertEquals("chomp(String, String) failed", "", StringUtils.chomp("", "foo")); 
     assertEquals("chomp(String, String) failed", "", StringUtils.chomp("", null)); 
     assertEquals("chomp(String, String) failed", "", StringUtils.chomp("", "")); 
     assertEquals("chomp(String, String) failed", null, StringUtils.chomp(null, "foo")); 
     assertEquals("chomp(String, String) failed", null, StringUtils.chomp(null, null)); 
     assertEquals("chomp(String, String) failed", null, StringUtils.chomp(null, "")); 
     assertEquals("chomp(String, String) failed", "", StringUtils.chomp("foo", "foo")); 
     assertEquals("chomp(String, String) failed", " ", StringUtils.chomp(" foo", "foo")); 
     assertEquals("chomp(String, String) failed", "foo ", StringUtils.chomp("foo ", "foo")); 
 }
@Test
public void testReplace_StringStringStringInt4084() { 
     assertEquals(null, StringUtils.replace(null, null, null, 2)); 
     assertEquals(null, StringUtils.replace(null, null, "any", 2)); 
     assertEquals(null, StringUtils.replace(null, "any", null, 2)); 
     assertEquals(null, StringUtils.replace(null, "any", "any", 2)); 
     assertEquals("", StringUtils.replace("", null, null, 2)); 
     assertEquals("", StringUtils.replace("", null, "any", 2)); 
     assertEquals("", StringUtils.replace("", "any", null, 2)); 
     assertEquals("", StringUtils.replace("", "any", "any", 2)); 
     final String str = new String(new char[] { 'o', 'o', 'f', 'o', 'o' }); 
     assertSame(str, StringUtils.replace(str, "x", "", -1)); 
     assertEquals("f", StringUtils.replace("oofoo", "o", "", -1)); 
     assertEquals("oofoo", StringUtils.replace("oofoo", "o", "", 0)); 
     assertEquals("ofoo", StringUtils.replace("oofoo", "o", "", 1)); 
     assertEquals("foo", StringUtils.replace("oofoo", "o", "", 2)); 
     assertEquals("fo", StringUtils.replace("oofoo", "o", "", 3)); 
     assertEquals("f", StringUtils.replace("oofoo", "o", "", 4)); 
     assertEquals("f", StringUtils.replace("oofoo", "o", "", -5)); 
     assertEquals("f", StringUtils.replace("oofoo", "o", "", 1000)); 
 }
@Test
public void testReplace_StringStringArrayStringArray4144() { 
     assertNull(StringUtils.replaceEach(null, new String[] { "a" }, new String[] { "b" })); 
     assertEquals(StringUtils.replaceEach("", new String[] { "a" }, new String[] { "b" }), ""); 
     assertEquals(StringUtils.replaceEach("aba", null, null), "aba"); 
     assertEquals(StringUtils.replaceEach("aba", new String[0], null), "aba"); 
     assertEquals(StringUtils.replaceEach("aba", null, new String[0]), "aba"); 
     assertEquals(StringUtils.replaceEach("aba", new String[] { "a" }, null), "aba"); 
     assertEquals(StringUtils.replaceEach("aba", new String[] { "a" }, new String[] { "" }), "b"); 
     assertEquals(StringUtils.replaceEach("aba", new String[] { null }, new String[] { "a" }), "aba"); 
     assertEquals(StringUtils.replaceEach("abcde", new String[] { "ab", "d" }, new String[] { "w", "t" }), "wcte"); 
     assertEquals(StringUtils.replaceEach("abcde", new String[] { "ab", "d" }, new String[] { "d", "t" }), "dcte"); 
     assertEquals("bcc", StringUtils.replaceEach("abc", new String[] { "a", "b" }, new String[] { "b", "c" })); 
     assertEquals("q651.506bera", StringUtils.replaceEach("d216.102oren", new String[] { "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "1", "2", "3", "4", "5", "6", "7", "8", "9" }, new String[] { "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z", "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "5", "6", "7", "8", "9", "1", "2", "3", "4" })); 
     assertEquals(StringUtils.replaceEach("aba", new String[] { "a" }, new String[] { null }), "aba"); 
     assertEquals(StringUtils.replaceEach("aba", new String[] { "a", "b" }, new String[] { "c", null }), "cbc"); 
 }
@Test
public void testReverseDelimited_StringChar4155() { 
     assertEquals(null, StringUtils.reverseDelimited(null, '.')); 
     assertEquals("", StringUtils.reverseDelimited("", '.')); 
     assertEquals("c.b.a", StringUtils.reverseDelimited("a.b.c", '.')); 
     assertEquals("a b c", StringUtils.reverseDelimited("a b c", '.')); 
     assertEquals("", StringUtils.reverseDelimited("", '.')); 
 }
@Test
public void testReplace_StringStringArrayStringArray4161() { 
     assertNull(StringUtils.replaceEach(null, new String[] { "a" }, new String[] { "b" })); 
     assertEquals(StringUtils.replaceEach("", new String[] { "a" }, new String[] { "b" }), ""); 
     assertEquals(StringUtils.replaceEach("aba", null, null), "aba"); 
     assertEquals(StringUtils.replaceEach("aba", new String[0], null), "aba"); 
     assertEquals(StringUtils.replaceEach("aba", null, new String[0]), "aba"); 
     assertEquals(StringUtils.replaceEach("aba", new String[] { "a" }, null), "aba"); 
     assertEquals(StringUtils.replaceEach("aba", new String[] { "a" }, new String[] { "" }), "b"); 
     assertEquals(StringUtils.replaceEach("aba", new String[] { null }, new String[] { "a" }), "aba"); 
     assertEquals(StringUtils.replaceEach("abcde", new String[] { "ab", "d" }, new String[] { "w", "t" }), "wcte"); 
     assertEquals(StringUtils.replaceEach("abcde", new String[] { "ab", "d" }, new String[] { "d", "t" }), "dcte"); 
     assertEquals("bcc", StringUtils.replaceEach("abc", new String[] { "a", "b" }, new String[] { "b", "c" })); 
     assertEquals("q651.506bera", StringUtils.replaceEach("d216.102oren", new String[] { "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "1", "2", "3", "4", "5", "6", "7", "8", "9" }, new String[] { "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z", "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "5", "6", "7", "8", "9", "1", "2", "3", "4" })); 
     assertEquals(StringUtils.replaceEach("aba", new String[] { "a" }, new String[] { null }), "aba"); 
     assertEquals(StringUtils.replaceEach("aba", new String[] { "a", "b" }, new String[] { "c", null }), "cbc"); 
 }
@Test
public void testDifference_StringString4163() { 
     assertEquals(null, StringUtils.difference(null, null)); 
     assertEquals("", StringUtils.difference("", "")); 
     assertEquals("abc", StringUtils.difference("", "abc")); 
     assertEquals("", StringUtils.difference("abc", "")); 
     assertEquals("i am a robot", StringUtils.difference(null, "i am a robot")); 
     assertEquals("i am a machine", StringUtils.difference("i am a machine", null)); 
     assertEquals("robot", StringUtils.difference("i am a machine", "i am a robot")); 
     assertEquals("", StringUtils.difference("abc", "abc")); 
     assertEquals("you are a robot", StringUtils.difference("i am a robot", "you are a robot")); 
 }
@Test
public void testSplitByCharacterType4165() { 
     assertNull(StringUtils.splitByCharacterType(null)); 
     assertEquals(0, StringUtils.splitByCharacterType("").length); 
     assertTrue(ArrayUtils.isEquals(new String[] { "ab", " ", "de", " ", "fg" }, StringUtils.splitByCharacterType("ab de fg"))); 
     assertTrue(ArrayUtils.isEquals(new String[] { "ab", "   ", "de", " ", "fg" }, StringUtils.splitByCharacterType("ab   de fg"))); 
     assertTrue(ArrayUtils.isEquals(new String[] { "ab", ":", "cd", ":", "ef" }, StringUtils.splitByCharacterType("ab:cd:ef"))); 
     assertTrue(ArrayUtils.isEquals(new String[] { "number", "5" }, StringUtils.splitByCharacterType("number5"))); 
     assertTrue(ArrayUtils.isEquals(new String[] { "foo", "B", "ar" }, StringUtils.splitByCharacterType("fooBar"))); 
     assertTrue(ArrayUtils.isEquals(new String[] { "foo", "200", "B", "ar" }, StringUtils.splitByCharacterType("foo200Bar"))); 
     assertTrue(ArrayUtils.isEquals(new String[] { "ASFR", "ules" }, StringUtils.splitByCharacterType("ASFRules"))); 
 }
@Test
public void testJoin_ArrayCharSeparator4211() { 
     assertEquals(null, StringUtils.join((Object[]) null, ',')); 
     assertEquals(TEXT_LIST_CHAR, StringUtils.join(ARRAY_LIST, SEPARATOR_CHAR)); 
     assertEquals("", StringUtils.join(EMPTY_ARRAY_LIST, SEPARATOR_CHAR)); 
     assertEquals(";;foo", StringUtils.join(MIXED_ARRAY_LIST, SEPARATOR_CHAR)); 
     assertEquals("foo;2", StringUtils.join(MIXED_TYPE_LIST, SEPARATOR_CHAR)); 
     assertEquals("/", StringUtils.join(MIXED_ARRAY_LIST, '/', 0, MIXED_ARRAY_LIST.length - 1)); 
     assertEquals("foo", StringUtils.join(MIXED_TYPE_LIST, '/', 0, 1)); 
     assertEquals("null", StringUtils.join(NULL_TO_STRING_LIST, '/', 0, 1)); 
     assertEquals("foo/2", StringUtils.join(MIXED_TYPE_LIST, '/', 0, 2)); 
     assertEquals("2", StringUtils.join(MIXED_TYPE_LIST, '/', 1, 2)); 
     assertEquals("", StringUtils.join(MIXED_TYPE_LIST, '/', 2, 1)); 
 }
@Test
public void testEscapeSurrogatePairs4213() throws Exception { 
     assertEquals("\uD83D\uDE30", StringEscapeUtils.escapeCsv("\uD83D\uDE30")); 
     assertEquals("\uD800\uDC00", StringEscapeUtils.escapeCsv("\uD800\uDC00")); 
     assertEquals("\uD834\uDD1E", StringEscapeUtils.escapeCsv("\uD834\uDD1E")); 
     assertEquals("\uDBFF\uDFFD", StringEscapeUtils.escapeCsv("\uDBFF\uDFFD")); 
     assertEquals("\uDBFF\uDFFD", StringEscapeUtils.escapeHtml3("\uDBFF\uDFFD")); 
     assertEquals("\uDBFF\uDFFD", StringEscapeUtils.escapeHtml4("\uDBFF\uDFFD")); 
     assertEquals("\uDBFF\uDFFD", StringEscapeUtils.escapeXml("\uDBFF\uDFFD")); 
 } 
@SuppressWarnings("deprecation")
@Test
public void testChomp4221() { 
     final String[][] chompCases = { { FOO_UNCAP + "\r\n", FOO_UNCAP }, { FOO_UNCAP + "\n", FOO_UNCAP }, { FOO_UNCAP + "\r", FOO_UNCAP }, { FOO_UNCAP + " \r", FOO_UNCAP + " " }, { FOO_UNCAP, FOO_UNCAP }, { FOO_UNCAP + "\n\n", FOO_UNCAP + "\n" }, { FOO_UNCAP + "\r\n\r\n", FOO_UNCAP + "\r\n" }, { "foo\nfoo", "foo\nfoo" }, { "foo\n\rfoo", "foo\n\rfoo" }, { "\n", "" }, { "\r", "" }, { "a", "a" }, { "\r\n", "" }, { "", "" }, { null, null }, { FOO_UNCAP + "\n\r", FOO_UNCAP + "\n" } }; 
     for (final String[] chompCase : chompCases) { 
         final String original = chompCase[0]; 
         final String expectedResult = chompCase[1]; 
         assertEquals("chomp(String) failed", expectedResult, StringUtils.chomp(original)); 
     } 
     assertEquals("chomp(String, String) failed", "foo", StringUtils.chomp("foobar", "bar")); 
     assertEquals("chomp(String, String) failed", "foobar", StringUtils.chomp("foobar", "baz")); 
     assertEquals("chomp(String, String) failed", "foo", StringUtils.chomp("foo", "foooo")); 
     assertEquals("chomp(String, String) failed", "foobar", StringUtils.chomp("foobar", "")); 
     assertEquals("chomp(String, String) failed", "foobar", StringUtils.chomp("foobar", null)); 
     assertEquals("chomp(String, String) failed", "", StringUtils.chomp("", "foo")); 
     assertEquals("chomp(String, String) failed", "", StringUtils.chomp("", null)); 
     assertEquals("chomp(String, String) failed", "", StringUtils.chomp("", "")); 
     assertEquals("chomp(String, String) failed", null, StringUtils.chomp(null, "foo")); 
     assertEquals("chomp(String, String) failed", null, StringUtils.chomp(null, null)); 
     assertEquals("chomp(String, String) failed", null, StringUtils.chomp(null, "")); 
     assertEquals("chomp(String, String) failed", "", StringUtils.chomp("foo", "foo")); 
     assertEquals("chomp(String, String) failed", " ", StringUtils.chomp(" foo", "foo")); 
     assertEquals("chomp(String, String) failed", "foo ", StringUtils.chomp("foo ", "foo")); 
 }
@Test
public void testReplace_StringStringArrayStringArray4234() { 
     assertNull(StringUtils.replaceEach(null, new String[] { "a" }, new String[] { "b" })); 
     assertEquals(StringUtils.replaceEach("", new String[] { "a" }, new String[] { "b" }), ""); 
     assertEquals(StringUtils.replaceEach("aba", null, null), "aba"); 
     assertEquals(StringUtils.replaceEach("aba", new String[0], null), "aba"); 
     assertEquals(StringUtils.replaceEach("aba", null, new String[0]), "aba"); 
     assertEquals(StringUtils.replaceEach("aba", new String[] { "a" }, null), "aba"); 
     assertEquals(StringUtils.replaceEach("aba", new String[] { "a" }, new String[] { "" }), "b"); 
     assertEquals(StringUtils.replaceEach("aba", new String[] { null }, new String[] { "a" }), "aba"); 
     assertEquals(StringUtils.replaceEach("abcde", new String[] { "ab", "d" }, new String[] { "w", "t" }), "wcte"); 
     assertEquals(StringUtils.replaceEach("abcde", new String[] { "ab", "d" }, new String[] { "d", "t" }), "dcte"); 
     assertEquals("bcc", StringUtils.replaceEach("abc", new String[] { "a", "b" }, new String[] { "b", "c" })); 
     assertEquals("q651.506bera", StringUtils.replaceEach("d216.102oren", new String[] { "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "1", "2", "3", "4", "5", "6", "7", "8", "9" }, new String[] { "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z", "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "5", "6", "7", "8", "9", "1", "2", "3", "4" })); 
     assertEquals(StringUtils.replaceEach("aba", new String[] { "a" }, new String[] { null }), "aba"); 
     assertEquals(StringUtils.replaceEach("aba", new String[] { "a", "b" }, new String[] { "c", null }), "cbc"); 
 }
@Test
public void testJoin_IterableString4238() { 
     assertEquals(null, StringUtils.join((Iterable<?>) null, null)); 
     assertEquals(TEXT_LIST_NOSEP, StringUtils.join(Arrays.asList(ARRAY_LIST), null)); 
     assertEquals(TEXT_LIST_NOSEP, StringUtils.join(Arrays.asList(ARRAY_LIST), "")); 
     assertEquals("foo", StringUtils.join(Collections.singleton("foo"), "x")); 
     assertEquals("foo", StringUtils.join(Collections.singleton("foo"), null)); 
     assertEquals("", StringUtils.join(Arrays.asList(NULL_ARRAY_LIST), null)); 
     assertEquals("", StringUtils.join(Arrays.asList(EMPTY_ARRAY_LIST), null)); 
     assertEquals("", StringUtils.join(Arrays.asList(EMPTY_ARRAY_LIST), "")); 
     assertEquals("", StringUtils.join(Arrays.asList(EMPTY_ARRAY_LIST), SEPARATOR)); 
     assertEquals(TEXT_LIST, StringUtils.join(Arrays.asList(ARRAY_LIST), SEPARATOR)); 
 }
@Test
public void testRepeat_StringInt4242() { 
     assertEquals(null, StringUtils.repeat(null, 2)); 
     assertEquals("", StringUtils.repeat("ab", 0)); 
     assertEquals("", StringUtils.repeat("", 3)); 
     assertEquals("aaa", StringUtils.repeat("a", 3)); 
     assertEquals("ababab", StringUtils.repeat("ab", 3)); 
     assertEquals("abcabcabc", StringUtils.repeat("abc", 3)); 
     final String str = StringUtils.repeat("a", 10000); 
     assertEquals(10000, str.length()); 
     assertTrue(StringUtils.containsOnly(str, new char[] { 'a' })); 
 }
@Test
public void testDifference_StringString4272() { 
     assertEquals(null, StringUtils.difference(null, null)); 
     assertEquals("", StringUtils.difference("", "")); 
     assertEquals("abc", StringUtils.difference("", "abc")); 
     assertEquals("", StringUtils.difference("abc", "")); 
     assertEquals("i am a robot", StringUtils.difference(null, "i am a robot")); 
     assertEquals("i am a machine", StringUtils.difference("i am a machine", null)); 
     assertEquals("robot", StringUtils.difference("i am a machine", "i am a robot")); 
     assertEquals("", StringUtils.difference("abc", "abc")); 
     assertEquals("you are a robot", StringUtils.difference("i am a robot", "you are a robot")); 
 }
@Test
public void testSplitByCharacterType4274() { 
     assertNull(StringUtils.splitByCharacterType(null)); 
     assertEquals(0, StringUtils.splitByCharacterType("").length); 
     assertTrue(ArrayUtils.isEquals(new String[] { "ab", " ", "de", " ", "fg" }, StringUtils.splitByCharacterType("ab de fg"))); 
     assertTrue(ArrayUtils.isEquals(new String[] { "ab", "   ", "de", " ", "fg" }, StringUtils.splitByCharacterType("ab   de fg"))); 
     assertTrue(ArrayUtils.isEquals(new String[] { "ab", ":", "cd", ":", "ef" }, StringUtils.splitByCharacterType("ab:cd:ef"))); 
     assertTrue(ArrayUtils.isEquals(new String[] { "number", "5" }, StringUtils.splitByCharacterType("number5"))); 
     assertTrue(ArrayUtils.isEquals(new String[] { "foo", "B", "ar" }, StringUtils.splitByCharacterType("fooBar"))); 
     assertTrue(ArrayUtils.isEquals(new String[] { "foo", "200", "B", "ar" }, StringUtils.splitByCharacterType("foo200Bar"))); 
     assertTrue(ArrayUtils.isEquals(new String[] { "ASFR", "ules" }, StringUtils.splitByCharacterType("ASFRules"))); 
 }
@Test
public void testEscapeSurrogatePairsLang8584275() throws Exception { 
     assertEquals("\\uDBFF\\uDFFD", StringEscapeUtils.escapeJava("\uDBFF\uDFFD")); 
     assertEquals("\\uDBFF\\uDFFD", StringEscapeUtils.escapeEcmaScript("\uDBFF\uDFFD")); 
 }
@Test
public void testJoin_IterableString4289() { 
     assertEquals(null, StringUtils.join((Iterable<?>) null, null)); 
     assertEquals(TEXT_LIST_NOSEP, StringUtils.join(Arrays.asList(ARRAY_LIST), null)); 
     assertEquals(TEXT_LIST_NOSEP, StringUtils.join(Arrays.asList(ARRAY_LIST), "")); 
     assertEquals("foo", StringUtils.join(Collections.singleton("foo"), "x")); 
     assertEquals("foo", StringUtils.join(Collections.singleton("foo"), null)); 
     assertEquals("", StringUtils.join(Arrays.asList(NULL_ARRAY_LIST), null)); 
     assertEquals("", StringUtils.join(Arrays.asList(EMPTY_ARRAY_LIST), null)); 
     assertEquals("", StringUtils.join(Arrays.asList(EMPTY_ARRAY_LIST), "")); 
     assertEquals("", StringUtils.join(Arrays.asList(EMPTY_ARRAY_LIST), SEPARATOR)); 
     assertEquals(TEXT_LIST, StringUtils.join(Arrays.asList(ARRAY_LIST), SEPARATOR)); 
 }
@Test
public void testIsAllLowerCase4324() { 
     assertFalse(StringUtils.isAllLowerCase(null)); 
     assertFalse(StringUtils.isAllLowerCase(StringUtils.EMPTY)); 
     assertTrue(StringUtils.isAllLowerCase("abc")); 
     assertFalse(StringUtils.isAllLowerCase("abc ")); 
     assertFalse(StringUtils.isAllLowerCase("abC")); 
 }
@Test
public void testCenter_StringIntChar4349() { 
     assertEquals(null, StringUtils.center(null, -1, ' ')); 
     assertEquals(null, StringUtils.center(null, 4, ' ')); 
     assertEquals("    ", StringUtils.center("", 4, ' ')); 
     assertEquals("ab", StringUtils.center("ab", 0, ' ')); 
     assertEquals("ab", StringUtils.center("ab", -1, ' ')); 
     assertEquals("ab", StringUtils.center("ab", 1, ' ')); 
     assertEquals("    ", StringUtils.center("", 4, ' ')); 
     assertEquals(" ab ", StringUtils.center("ab", 4, ' ')); 
     assertEquals("abcd", StringUtils.center("abcd", 2, ' ')); 
     assertEquals(" a  ", StringUtils.center("a", 4, ' ')); 
     assertEquals("  a  ", StringUtils.center("a", 5, ' ')); 
     assertEquals("xxaxx", StringUtils.center("a", 5, 'x')); 
 }
@Test
public void testOverlay_StringStringIntInt4375() { 
     assertEquals(null, StringUtils.overlay(null, null, 2, 4)); 
     assertEquals(null, StringUtils.overlay(null, null, -2, -4)); 
     assertEquals("", StringUtils.overlay("", null, 0, 0)); 
     assertEquals("", StringUtils.overlay("", "", 0, 0)); 
     assertEquals("zzzz", StringUtils.overlay("", "zzzz", 0, 0)); 
     assertEquals("zzzz", StringUtils.overlay("", "zzzz", 2, 4)); 
     assertEquals("zzzz", StringUtils.overlay("", "zzzz", -2, -4)); 
     assertEquals("abef", StringUtils.overlay("abcdef", null, 2, 4)); 
     assertEquals("abef", StringUtils.overlay("abcdef", null, 4, 2)); 
     assertEquals("abef", StringUtils.overlay("abcdef", "", 2, 4)); 
     assertEquals("abef", StringUtils.overlay("abcdef", "", 4, 2)); 
     assertEquals("abzzzzef", StringUtils.overlay("abcdef", "zzzz", 2, 4)); 
     assertEquals("abzzzzef", StringUtils.overlay("abcdef", "zzzz", 4, 2)); 
     assertEquals("zzzzef", StringUtils.overlay("abcdef", "zzzz", -1, 4)); 
     assertEquals("zzzzef", StringUtils.overlay("abcdef", "zzzz", 4, -1)); 
     assertEquals("zzzzabcdef", StringUtils.overlay("abcdef", "zzzz", -2, -1)); 
     assertEquals("zzzzabcdef", StringUtils.overlay("abcdef", "zzzz", -1, -2)); 
     assertEquals("abcdzzzz", StringUtils.overlay("abcdef", "zzzz", 4, 10)); 
     assertEquals("abcdzzzz", StringUtils.overlay("abcdef", "zzzz", 10, 4)); 
     assertEquals("abcdefzzzz", StringUtils.overlay("abcdef", "zzzz", 8, 10)); 
     assertEquals("abcdefzzzz", StringUtils.overlay("abcdef", "zzzz", 10, 8)); 
 }
@Test
public void testReplaceChars_StringStringString4384() { 
     assertEquals(null, StringUtils.replaceChars(null, null, null)); 
     assertEquals(null, StringUtils.replaceChars(null, "", null)); 
     assertEquals(null, StringUtils.replaceChars(null, "a", null)); 
     assertEquals(null, StringUtils.replaceChars(null, null, "")); 
     assertEquals(null, StringUtils.replaceChars(null, null, "x")); 
     assertEquals("", StringUtils.replaceChars("", null, null)); 
     assertEquals("", StringUtils.replaceChars("", "", null)); 
     assertEquals("", StringUtils.replaceChars("", "a", null)); 
     assertEquals("", StringUtils.replaceChars("", null, "")); 
     assertEquals("", StringUtils.replaceChars("", null, "x")); 
     assertEquals("abc", StringUtils.replaceChars("abc", null, null)); 
     assertEquals("abc", StringUtils.replaceChars("abc", null, "")); 
     assertEquals("abc", StringUtils.replaceChars("abc", null, "x")); 
     assertEquals("abc", StringUtils.replaceChars("abc", "", null)); 
     assertEquals("abc", StringUtils.replaceChars("abc", "", "")); 
     assertEquals("abc", StringUtils.replaceChars("abc", "", "x")); 
     assertEquals("ac", StringUtils.replaceChars("abc", "b", null)); 
     assertEquals("ac", StringUtils.replaceChars("abc", "b", "")); 
     assertEquals("axc", StringUtils.replaceChars("abc", "b", "x")); 
     assertEquals("ayzya", StringUtils.replaceChars("abcba", "bc", "yz")); 
     assertEquals("ayya", StringUtils.replaceChars("abcba", "bc", "y")); 
     assertEquals("ayzya", StringUtils.replaceChars("abcba", "bc", "yzx")); 
     assertEquals("abcba", StringUtils.replaceChars("abcba", "z", "w")); 
     assertSame("abcba", StringUtils.replaceChars("abcba", "z", "w")); 
     assertEquals("jelly", StringUtils.replaceChars("hello", "ho", "jy")); 
     assertEquals("ayzya", StringUtils.replaceChars("abcba", "bc", "yz")); 
     assertEquals("ayya", StringUtils.replaceChars("abcba", "bc", "y")); 
     assertEquals("ayzya", StringUtils.replaceChars("abcba", "bc", "yzx")); 
     assertEquals("bcc", StringUtils.replaceChars("abc", "ab", "bc")); 
     assertEquals("q651.506bera", StringUtils.replaceChars("d216.102oren", "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ123456789", "nopqrstuvwxyzabcdefghijklmNOPQRSTUVWXYZABCDEFGHIJKLM567891234")); 
 }
@Test
public void testRepeat_StringInt4395() { 
     assertEquals(null, StringUtils.repeat(null, 2)); 
     assertEquals("", StringUtils.repeat("ab", 0)); 
     assertEquals("", StringUtils.repeat("", 3)); 
     assertEquals("aaa", StringUtils.repeat("a", 3)); 
     assertEquals("ababab", StringUtils.repeat("ab", 3)); 
     assertEquals("abcabcabc", StringUtils.repeat("abc", 3)); 
     final String str = StringUtils.repeat("a", 10000); 
     assertEquals(10000, str.length()); 
     assertTrue(StringUtils.containsOnly(str, new char[] { 'a' })); 
 }
@Test
public void testOverlay_StringStringIntInt4397() { 
     assertEquals(null, StringUtils.overlay(null, null, 2, 4)); 
     assertEquals(null, StringUtils.overlay(null, null, -2, -4)); 
     assertEquals("", StringUtils.overlay("", null, 0, 0)); 
     assertEquals("", StringUtils.overlay("", "", 0, 0)); 
     assertEquals("zzzz", StringUtils.overlay("", "zzzz", 0, 0)); 
     assertEquals("zzzz", StringUtils.overlay("", "zzzz", 2, 4)); 
     assertEquals("zzzz", StringUtils.overlay("", "zzzz", -2, -4)); 
     assertEquals("abef", StringUtils.overlay("abcdef", null, 2, 4)); 
     assertEquals("abef", StringUtils.overlay("abcdef", null, 4, 2)); 
     assertEquals("abef", StringUtils.overlay("abcdef", "", 2, 4)); 
     assertEquals("abef", StringUtils.overlay("abcdef", "", 4, 2)); 
     assertEquals("abzzzzef", StringUtils.overlay("abcdef", "zzzz", 2, 4)); 
     assertEquals("abzzzzef", StringUtils.overlay("abcdef", "zzzz", 4, 2)); 
     assertEquals("zzzzef", StringUtils.overlay("abcdef", "zzzz", -1, 4)); 
     assertEquals("zzzzef", StringUtils.overlay("abcdef", "zzzz", 4, -1)); 
     assertEquals("zzzzabcdef", StringUtils.overlay("abcdef", "zzzz", -2, -1)); 
     assertEquals("zzzzabcdef", StringUtils.overlay("abcdef", "zzzz", -1, -2)); 
     assertEquals("abcdzzzz", StringUtils.overlay("abcdef", "zzzz", 4, 10)); 
     assertEquals("abcdzzzz", StringUtils.overlay("abcdef", "zzzz", 10, 4)); 
     assertEquals("abcdefzzzz", StringUtils.overlay("abcdef", "zzzz", 8, 10)); 
     assertEquals("abcdefzzzz", StringUtils.overlay("abcdef", "zzzz", 10, 8)); 
 }
@Test
public void testRemove_String4410() { 
     assertEquals(null, StringUtils.remove(null, null)); 
     assertEquals(null, StringUtils.remove(null, "")); 
     assertEquals(null, StringUtils.remove(null, "a")); 
     assertEquals("", StringUtils.remove("", null)); 
     assertEquals("", StringUtils.remove("", "")); 
     assertEquals("", StringUtils.remove("", "a")); 
     assertEquals(null, StringUtils.remove(null, null)); 
     assertEquals("", StringUtils.remove("", null)); 
     assertEquals("a", StringUtils.remove("a", null)); 
     assertEquals(null, StringUtils.remove(null, "")); 
     assertEquals("", StringUtils.remove("", "")); 
     assertEquals("a", StringUtils.remove("a", "")); 
     assertEquals("qd", StringUtils.remove("queued", "ue")); 
     assertEquals("queued", StringUtils.remove("queued", "zz")); 
 }
@Test
public void testGetLevenshteinDistance_StringStringInt4425() { 
     assertEquals(0, StringUtils.getLevenshteinDistance("", "", 0)); 
     assertEquals(7, StringUtils.getLevenshteinDistance("aaapppp", "", 8)); 
     assertEquals(7, StringUtils.getLevenshteinDistance("aaapppp", "", 7)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("aaapppp", "", 6)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("b", "a", 0)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("a", "b", 0)); 
     assertEquals(0, StringUtils.getLevenshteinDistance("aa", "aa", 0)); 
     assertEquals(0, StringUtils.getLevenshteinDistance("aa", "aa", 2)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("aaa", "bbb", 2)); 
     assertEquals(3, StringUtils.getLevenshteinDistance("aaa", "bbb", 3)); 
     assertEquals(6, StringUtils.getLevenshteinDistance("aaaaaa", "b", 10)); 
     assertEquals(7, StringUtils.getLevenshteinDistance("aaapppp", "b", 8)); 
     assertEquals(3, StringUtils.getLevenshteinDistance("a", "bbb", 4)); 
     assertEquals(7, StringUtils.getLevenshteinDistance("aaapppp", "b", 7)); 
     assertEquals(3, StringUtils.getLevenshteinDistance("a", "bbb", 3)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("a", "bbb", 2)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("bbb", "a", 2)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("aaapppp", "b", 6)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("a", "bbb", 1)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("bbb", "a", 1)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("12345", "1234567", 1)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("1234567", "12345", 1)); 
     assertEquals(1, StringUtils.getLevenshteinDistance("frog", "fog", 1)); 
     assertEquals(3, StringUtils.getLevenshteinDistance("fly", "ant", 3)); 
     assertEquals(7, StringUtils.getLevenshteinDistance("elephant", "hippo", 7)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("elephant", "hippo", 6)); 
     assertEquals(7, StringUtils.getLevenshteinDistance("hippo", "elephant", 7)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("hippo", "elephant", 6)); 
     assertEquals(8, StringUtils.getLevenshteinDistance("hippo", "zzzzzzzz", 8)); 
     assertEquals(8, StringUtils.getLevenshteinDistance("zzzzzzzz", "hippo", 8)); 
     assertEquals(1, StringUtils.getLevenshteinDistance("hello", "hallo", 1)); 
     try { 
         @SuppressWarnings("unused") 
         final int d = StringUtils.getLevenshteinDistance("a", null, 0); 
         fail("expecting IllegalArgumentException"); 
     } catch (final IllegalArgumentException ex) { 
     } 
     try { 
         @SuppressWarnings("unused") 
         final int d = StringUtils.getLevenshteinDistance(null, "a", 0); 
         fail("expecting IllegalArgumentException"); 
     } catch (final IllegalArgumentException ex) { 
     } 
     try { 
         @SuppressWarnings("unused") 
         final int d = StringUtils.getLevenshteinDistance("a", "a", -1); 
         fail("expecting IllegalArgumentException"); 
     } catch (final IllegalArgumentException ex) { 
     } 
 }
@Test
public void testSplitPreserveAllTokens_StringChar4431() { 
     assertArrayEquals(null, StringUtils.splitPreserveAllTokens(null, '.')); 
     assertEquals(0, StringUtils.splitPreserveAllTokens("", '.').length); 
     String str = "a.b. c"; 
     String[] res = StringUtils.splitPreserveAllTokens(str, '.'); 
     assertEquals(3, res.length); 
     assertEquals("a", res[0]); 
     assertEquals("b", res[1]); 
     assertEquals(" c", res[2]); 
     str = "a.b.. c"; 
     res = StringUtils.splitPreserveAllTokens(str, '.'); 
     assertEquals(4, res.length); 
     assertEquals("a", res[0]); 
     assertEquals("b", res[1]); 
     assertEquals("", res[2]); 
     assertEquals(" c", res[3]); 
     str = ".a."; 
     res = StringUtils.splitPreserveAllTokens(str, '.'); 
     assertEquals(3, res.length); 
     assertEquals("", res[0]); 
     assertEquals("a", res[1]); 
     assertEquals("", res[2]); 
     str = ".a.."; 
     res = StringUtils.splitPreserveAllTokens(str, '.'); 
     assertEquals(4, res.length); 
     assertEquals("", res[0]); 
     assertEquals("a", res[1]); 
     assertEquals("", res[2]); 
     assertEquals("", res[3]); 
     str = "..a."; 
     res = StringUtils.splitPreserveAllTokens(str, '.'); 
     assertEquals(4, res.length); 
     assertEquals("", res[0]); 
     assertEquals("", res[1]); 
     assertEquals("a", res[2]); 
     assertEquals("", res[3]); 
     str = "..a"; 
     res = StringUtils.splitPreserveAllTokens(str, '.'); 
     assertEquals(3, res.length); 
     assertEquals("", res[0]); 
     assertEquals("", res[1]); 
     assertEquals("a", res[2]); 
     str = "a b c"; 
     res = StringUtils.splitPreserveAllTokens(str, ' '); 
     assertEquals(3, res.length); 
     assertEquals("a", res[0]); 
     assertEquals("b", res[1]); 
     assertEquals("c", res[2]); 
     str = "a  b  c"; 
     res = StringUtils.splitPreserveAllTokens(str, ' '); 
     assertEquals(5, res.length); 
     assertEquals("a", res[0]); 
     assertEquals("", res[1]); 
     assertEquals("b", res[2]); 
     assertEquals("", res[3]); 
     assertEquals("c", res[4]); 
     str = " a b c"; 
     res = StringUtils.splitPreserveAllTokens(str, ' '); 
     assertEquals(4, res.length); 
     assertEquals("", res[0]); 
     assertEquals("a", res[1]); 
     assertEquals("b", res[2]); 
     assertEquals("c", res[3]); 
     str = "  a b c"; 
     res = StringUtils.splitPreserveAllTokens(str, ' '); 
     assertEquals(5, res.length); 
     assertEquals("", res[0]); 
     assertEquals("", res[1]); 
     assertEquals("a", res[2]); 
     assertEquals("b", res[3]); 
     assertEquals("c", res[4]); 
     str = "a b c "; 
     res = StringUtils.splitPreserveAllTokens(str, ' '); 
     assertEquals(4, res.length); 
     assertEquals("a", res[0]); 
     assertEquals("b", res[1]); 
     assertEquals("c", res[2]); 
     assertEquals("", res[3]); 
     str = "a b c  "; 
     res = StringUtils.splitPreserveAllTokens(str, ' '); 
     assertEquals(5, res.length); 
     assertEquals("a", res[0]); 
     assertEquals("b", res[1]); 
     assertEquals("c", res[2]); 
     assertEquals("", res[3]); 
     assertEquals("", res[3]); 
     { 
         String[] results; 
         final String[] expectedResults = { "a", "", "b", "c" }; 
         results = StringUtils.splitPreserveAllTokens("a..b.c", '.'); 
         assertEquals(expectedResults.length, results.length); 
         for (int i = 0; i < expectedResults.length; i++) { 
             assertEquals(expectedResults[i], results[i]); 
         } 
     } 
 }
@Test
public void testRepeat_StringInt4448() { 
     assertEquals(null, StringUtils.repeat(null, 2)); 
     assertEquals("", StringUtils.repeat("ab", 0)); 
     assertEquals("", StringUtils.repeat("", 3)); 
     assertEquals("aaa", StringUtils.repeat("a", 3)); 
     assertEquals("ababab", StringUtils.repeat("ab", 3)); 
     assertEquals("abcabcabc", StringUtils.repeat("abc", 3)); 
     final String str = StringUtils.repeat("a", 10000); 
     assertEquals(10000, str.length()); 
     assertTrue(StringUtils.containsOnly(str, new char[] { 'a' })); 
 }
@Test
public void testEscapeSurrogatePairsLang8584459() throws Exception { 
     assertEquals("\\uDBFF\\uDFFD", StringEscapeUtils.escapeJava("\uDBFF\uDFFD")); 
     assertEquals("\\uDBFF\\uDFFD", StringEscapeUtils.escapeEcmaScript("\uDBFF\uDFFD")); 
 }
@Test
public void testReplace_StringStringArrayStringArray4462() { 
     assertNull(StringUtils.replaceEach(null, new String[] { "a" }, new String[] { "b" })); 
     assertEquals(StringUtils.replaceEach("", new String[] { "a" }, new String[] { "b" }), ""); 
     assertEquals(StringUtils.replaceEach("aba", null, null), "aba"); 
     assertEquals(StringUtils.replaceEach("aba", new String[0], null), "aba"); 
     assertEquals(StringUtils.replaceEach("aba", null, new String[0]), "aba"); 
     assertEquals(StringUtils.replaceEach("aba", new String[] { "a" }, null), "aba"); 
     assertEquals(StringUtils.replaceEach("aba", new String[] { "a" }, new String[] { "" }), "b"); 
     assertEquals(StringUtils.replaceEach("aba", new String[] { null }, new String[] { "a" }), "aba"); 
     assertEquals(StringUtils.replaceEach("abcde", new String[] { "ab", "d" }, new String[] { "w", "t" }), "wcte"); 
     assertEquals(StringUtils.replaceEach("abcde", new String[] { "ab", "d" }, new String[] { "d", "t" }), "dcte"); 
     assertEquals("bcc", StringUtils.replaceEach("abc", new String[] { "a", "b" }, new String[] { "b", "c" })); 
     assertEquals("q651.506bera", StringUtils.replaceEach("d216.102oren", new String[] { "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "1", "2", "3", "4", "5", "6", "7", "8", "9" }, new String[] { "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z", "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "5", "6", "7", "8", "9", "1", "2", "3", "4" })); 
     assertEquals(StringUtils.replaceEach("aba", new String[] { "a" }, new String[] { null }), "aba"); 
     assertEquals(StringUtils.replaceEach("aba", new String[] { "a", "b" }, new String[] { "c", null }), "cbc"); 
 }
@Test
public void testJoin_IteratorChar4485() { 
     assertEquals(null, StringUtils.join((Iterator<?>) null, ',')); 
     assertEquals(TEXT_LIST_CHAR, StringUtils.join(Arrays.asList(ARRAY_LIST).iterator(), SEPARATOR_CHAR)); 
     assertEquals("", StringUtils.join(Arrays.asList(NULL_ARRAY_LIST).iterator(), SEPARATOR_CHAR)); 
     assertEquals("", StringUtils.join(Arrays.asList(EMPTY_ARRAY_LIST).iterator(), SEPARATOR_CHAR)); 
     assertEquals("foo", StringUtils.join(Collections.singleton("foo").iterator(), 'x')); 
 }
@Test
public void testEscapeSurrogatePairs4498() throws Exception { 
     assertEquals("\uD83D\uDE30", StringEscapeUtils.escapeCsv("\uD83D\uDE30")); 
     assertEquals("\uD800\uDC00", StringEscapeUtils.escapeCsv("\uD800\uDC00")); 
     assertEquals("\uD834\uDD1E", StringEscapeUtils.escapeCsv("\uD834\uDD1E")); 
     assertEquals("\uDBFF\uDFFD", StringEscapeUtils.escapeCsv("\uDBFF\uDFFD")); 
     assertEquals("\uDBFF\uDFFD", StringEscapeUtils.escapeHtml3("\uDBFF\uDFFD")); 
     assertEquals("\uDBFF\uDFFD", StringEscapeUtils.escapeHtml4("\uDBFF\uDFFD")); 
     assertEquals("\uDBFF\uDFFD", StringEscapeUtils.escapeXml("\uDBFF\uDFFD")); 
 }
@Test
public void testJoin_ArrayCharSeparator4511() { 
     assertEquals(null, StringUtils.join((Object[]) null, ',')); 
     assertEquals(TEXT_LIST_CHAR, StringUtils.join(ARRAY_LIST, SEPARATOR_CHAR)); 
     assertEquals("", StringUtils.join(EMPTY_ARRAY_LIST, SEPARATOR_CHAR)); 
     assertEquals(";;foo", StringUtils.join(MIXED_ARRAY_LIST, SEPARATOR_CHAR)); 
     assertEquals("foo;2", StringUtils.join(MIXED_TYPE_LIST, SEPARATOR_CHAR)); 
     assertEquals("/", StringUtils.join(MIXED_ARRAY_LIST, '/', 0, MIXED_ARRAY_LIST.length - 1)); 
     assertEquals("foo", StringUtils.join(MIXED_TYPE_LIST, '/', 0, 1)); 
     assertEquals("null", StringUtils.join(NULL_TO_STRING_LIST, '/', 0, 1)); 
     assertEquals("foo/2", StringUtils.join(MIXED_TYPE_LIST, '/', 0, 2)); 
     assertEquals("2", StringUtils.join(MIXED_TYPE_LIST, '/', 1, 2)); 
     assertEquals("", StringUtils.join(MIXED_TYPE_LIST, '/', 2, 1)); 
 }
@Test
public void testRepeat_StringInt4540() { 
     assertEquals(null, StringUtils.repeat(null, 2)); 
     assertEquals("", StringUtils.repeat("ab", 0)); 
     assertEquals("", StringUtils.repeat("", 3)); 
     assertEquals("aaa", StringUtils.repeat("a", 3)); 
     assertEquals("ababab", StringUtils.repeat("ab", 3)); 
     assertEquals("abcabcabc", StringUtils.repeat("abc", 3)); 
     final String str = StringUtils.repeat("a", 10000); 
     assertEquals(10000, str.length()); 
     assertTrue(StringUtils.containsOnly(str, new char[] { 'a' })); 
 }
@Test
public void testRepeat_StringStringInt4545() { 
     assertEquals(null, StringUtils.repeat(null, null, 2)); 
     assertEquals(null, StringUtils.repeat(null, "x", 2)); 
     assertEquals("", StringUtils.repeat("", null, 2)); 
     assertEquals("", StringUtils.repeat("ab", "", 0)); 
     assertEquals("", StringUtils.repeat("", "", 2)); 
     assertEquals("xx", StringUtils.repeat("", "x", 3)); 
     assertEquals("?, ?, ?", StringUtils.repeat("?", ", ", 3)); 
 }
@Test
public void testJoin_ArrayOfBytes4547() { 
     assertEquals(null, StringUtils.join((byte[]) null, ',')); 
     assertEquals("1;2", StringUtils.join(BYTE_PRIM_LIST, SEPARATOR_CHAR)); 
     assertEquals("2", StringUtils.join(BYTE_PRIM_LIST, SEPARATOR_CHAR, 1, 2)); 
 }
@Test
public void testRemove_char4574() { 
     assertEquals(null, StringUtils.remove(null, 'a')); 
     assertEquals(null, StringUtils.remove(null, 'a')); 
     assertEquals(null, StringUtils.remove(null, 'a')); 
     assertEquals("", StringUtils.remove("", 'a')); 
     assertEquals("", StringUtils.remove("", 'a')); 
     assertEquals("", StringUtils.remove("", 'a')); 
     assertEquals("qeed", StringUtils.remove("queued", 'u')); 
     assertEquals("queued", StringUtils.remove("queued", 'z')); 
 }
@Test
public void testIsAllUpperCase4610() { 
     assertFalse(StringUtils.isAllUpperCase(null)); 
     assertFalse(StringUtils.isAllUpperCase(StringUtils.EMPTY)); 
     assertTrue(StringUtils.isAllUpperCase("ABC")); 
     assertFalse(StringUtils.isAllUpperCase("ABC ")); 
     assertFalse(StringUtils.isAllUpperCase("aBC")); 
 }
@Test
public void testAbbreviate_StringIntInt4620() { 
     assertEquals(null, StringUtils.abbreviate(null, 10, 12)); 
     assertEquals("", StringUtils.abbreviate("", 0, 10)); 
     assertEquals("", StringUtils.abbreviate("", 2, 10)); 
     try { 
         @SuppressWarnings("unused") 
         final String res = StringUtils.abbreviate("abcdefghij", 0, 3); 
         fail("StringUtils.abbreviate expecting IllegalArgumentException"); 
     } catch (final IllegalArgumentException ex) { 
     } 
     try { 
         @SuppressWarnings("unused") 
         final String res = StringUtils.abbreviate("abcdefghij", 5, 6); 
         fail("StringUtils.abbreviate expecting IllegalArgumentException"); 
     } catch (final IllegalArgumentException ex) { 
     } 
     final String raspberry = "raspberry peach"; 
     assertEquals("raspberry peach", StringUtils.abbreviate(raspberry, 11, 15)); 
     assertEquals(null, StringUtils.abbreviate(null, 7, 14)); 
     assertAbbreviateWithOffset("abcdefg...", -1, 10); 
     assertAbbreviateWithOffset("abcdefg...", 0, 10); 
     assertAbbreviateWithOffset("abcdefg...", 1, 10); 
     assertAbbreviateWithOffset("abcdefg...", 2, 10); 
     assertAbbreviateWithOffset("abcdefg...", 3, 10); 
     assertAbbreviateWithOffset("abcdefg...", 4, 10); 
     assertAbbreviateWithOffset("...fghi...", 5, 10); 
     assertAbbreviateWithOffset("...ghij...", 6, 10); 
     assertAbbreviateWithOffset("...hijk...", 7, 10); 
     assertAbbreviateWithOffset("...ijklmno", 8, 10); 
     assertAbbreviateWithOffset("...ijklmno", 9, 10); 
     assertAbbreviateWithOffset("...ijklmno", 10, 10); 
     assertAbbreviateWithOffset("...ijklmno", 10, 10); 
     assertAbbreviateWithOffset("...ijklmno", 11, 10); 
     assertAbbreviateWithOffset("...ijklmno", 12, 10); 
     assertAbbreviateWithOffset("...ijklmno", 13, 10); 
     assertAbbreviateWithOffset("...ijklmno", 14, 10); 
     assertAbbreviateWithOffset("...ijklmno", 15, 10); 
     assertAbbreviateWithOffset("...ijklmno", 16, 10); 
     assertAbbreviateWithOffset("...ijklmno", Integer.MAX_VALUE, 10); 
 }
@Test
public void testRepeat_StringInt4628() { 
     assertEquals(null, StringUtils.repeat(null, 2)); 
     assertEquals("", StringUtils.repeat("ab", 0)); 
     assertEquals("", StringUtils.repeat("", 3)); 
     assertEquals("aaa", StringUtils.repeat("a", 3)); 
     assertEquals("ababab", StringUtils.repeat("ab", 3)); 
     assertEquals("abcabcabc", StringUtils.repeat("abc", 3)); 
     final String str = StringUtils.repeat("a", 10000); 
     assertEquals(10000, str.length()); 
     assertTrue(StringUtils.containsOnly(str, new char[] { 'a' })); 
 }
@Test
public void testEscapeSurrogatePairsLang8584637() throws Exception { 
     assertEquals("\\uDBFF\\uDFFD", StringEscapeUtils.escapeJava("\uDBFF\uDFFD")); 
     assertEquals("\\uDBFF\\uDFFD", StringEscapeUtils.escapeEcmaScript("\uDBFF\uDFFD")); 
 }
@Test
public void testIsAllLowerCase4640() { 
     assertFalse(StringUtils.isAllLowerCase(null)); 
     assertFalse(StringUtils.isAllLowerCase(StringUtils.EMPTY)); 
     assertTrue(StringUtils.isAllLowerCase("abc")); 
     assertFalse(StringUtils.isAllLowerCase("abc ")); 
     assertFalse(StringUtils.isAllLowerCase("abC")); 
 }
@Test
public void testJoin_ArrayOfChars4647() { 
     assertEquals(null, StringUtils.join((char[]) null, ',')); 
     assertEquals("1;2", StringUtils.join(CHAR_PRIM_LIST, SEPARATOR_CHAR)); 
     assertEquals("2", StringUtils.join(CHAR_PRIM_LIST, SEPARATOR_CHAR, 1, 2)); 
 }
@Test
public void testLengthStringBuilder4650() { 
     assertEquals(0, StringUtils.length(new StringBuilder(""))); 
     assertEquals(0, StringUtils.length(new StringBuilder(StringUtils.EMPTY))); 
     assertEquals(1, StringUtils.length(new StringBuilder("A"))); 
     assertEquals(1, StringUtils.length(new StringBuilder(" "))); 
     assertEquals(8, StringUtils.length(new StringBuilder("ABCDEFGH"))); 
 }
@Test
public void testSplit_StringChar4651() { 
     assertArrayEquals(null, StringUtils.split(null, '.')); 
     assertEquals(0, StringUtils.split("", '.').length); 
     String str = "a.b.. c"; 
     String[] res = StringUtils.split(str, '.'); 
     assertEquals(3, res.length); 
     assertEquals("a", res[0]); 
     assertEquals("b", res[1]); 
     assertEquals(" c", res[2]); 
     str = ".a."; 
     res = StringUtils.split(str, '.'); 
     assertEquals(1, res.length); 
     assertEquals("a", res[0]); 
     str = "a b c"; 
     res = StringUtils.split(str, ' '); 
     assertEquals(3, res.length); 
     assertEquals("a", res[0]); 
     assertEquals("b", res[1]); 
     assertEquals("c", res[2]); 
 }
@Test
public void testEscapeSurrogatePairs4658() throws Exception { 
     assertEquals("\uD83D\uDE30", StringEscapeUtils.escapeCsv("\uD83D\uDE30")); 
     assertEquals("\uD800\uDC00", StringEscapeUtils.escapeCsv("\uD800\uDC00")); 
     assertEquals("\uD834\uDD1E", StringEscapeUtils.escapeCsv("\uD834\uDD1E")); 
     assertEquals("\uDBFF\uDFFD", StringEscapeUtils.escapeCsv("\uDBFF\uDFFD")); 
     assertEquals("\uDBFF\uDFFD", StringEscapeUtils.escapeHtml3("\uDBFF\uDFFD")); 
     assertEquals("\uDBFF\uDFFD", StringEscapeUtils.escapeHtml4("\uDBFF\uDFFD")); 
     assertEquals("\uDBFF\uDFFD", StringEscapeUtils.escapeXml("\uDBFF\uDFFD")); 
 }
@Test
public void testRemove_char4700() { 
     assertEquals(null, StringUtils.remove(null, 'a')); 
     assertEquals(null, StringUtils.remove(null, 'a')); 
     assertEquals(null, StringUtils.remove(null, 'a')); 
     assertEquals("", StringUtils.remove("", 'a')); 
     assertEquals("", StringUtils.remove("", 'a')); 
     assertEquals("", StringUtils.remove("", 'a')); 
     assertEquals("qeed", StringUtils.remove("queued", 'u')); 
     assertEquals("queued", StringUtils.remove("queued", 'z')); 
 }
@Test
public void testDifference_StringString4733() { 
     assertEquals(null, StringUtils.difference(null, null)); 
     assertEquals("", StringUtils.difference("", "")); 
     assertEquals("abc", StringUtils.difference("", "abc")); 
     assertEquals("", StringUtils.difference("abc", "")); 
     assertEquals("i am a robot", StringUtils.difference(null, "i am a robot")); 
     assertEquals("i am a machine", StringUtils.difference("i am a machine", null)); 
     assertEquals("robot", StringUtils.difference("i am a machine", "i am a robot")); 
     assertEquals("", StringUtils.difference("abc", "abc")); 
     assertEquals("you are a robot", StringUtils.difference("i am a robot", "you are a robot")); 
 }
@Test
public void testCenter_StringIntChar4766() { 
     assertEquals(null, StringUtils.center(null, -1, ' ')); 
     assertEquals(null, StringUtils.center(null, 4, ' ')); 
     assertEquals("    ", StringUtils.center("", 4, ' ')); 
     assertEquals("ab", StringUtils.center("ab", 0, ' ')); 
     assertEquals("ab", StringUtils.center("ab", -1, ' ')); 
     assertEquals("ab", StringUtils.center("ab", 1, ' ')); 
     assertEquals("    ", StringUtils.center("", 4, ' ')); 
     assertEquals(" ab ", StringUtils.center("ab", 4, ' ')); 
     assertEquals("abcd", StringUtils.center("abcd", 2, ' ')); 
     assertEquals(" a  ", StringUtils.center("a", 4, ' ')); 
     assertEquals("  a  ", StringUtils.center("a", 5, ' ')); 
     assertEquals("xxaxx", StringUtils.center("a", 5, 'x')); 
 }
@Test
public void testIsAllUpperCase4774() { 
     assertFalse(StringUtils.isAllUpperCase(null)); 
     assertFalse(StringUtils.isAllUpperCase(StringUtils.EMPTY)); 
     assertTrue(StringUtils.isAllUpperCase("ABC")); 
     assertFalse(StringUtils.isAllUpperCase("ABC ")); 
     assertFalse(StringUtils.isAllUpperCase("aBC")); 
 }
@Test
public void testAbbreviate_StringIntInt4782() { 
     assertEquals(null, StringUtils.abbreviate(null, 10, 12)); 
     assertEquals("", StringUtils.abbreviate("", 0, 10)); 
     assertEquals("", StringUtils.abbreviate("", 2, 10)); 
     try { 
         @SuppressWarnings("unused") 
         final String res = StringUtils.abbreviate("abcdefghij", 0, 3); 
         fail("StringUtils.abbreviate expecting IllegalArgumentException"); 
     } catch (final IllegalArgumentException ex) { 
     } 
     try { 
         @SuppressWarnings("unused") 
         final String res = StringUtils.abbreviate("abcdefghij", 5, 6); 
         fail("StringUtils.abbreviate expecting IllegalArgumentException"); 
     } catch (final IllegalArgumentException ex) { 
     } 
     final String raspberry = "raspberry peach"; 
     assertEquals("raspberry peach", StringUtils.abbreviate(raspberry, 11, 15)); 
     assertEquals(null, StringUtils.abbreviate(null, 7, 14)); 
     assertAbbreviateWithOffset("abcdefg...", -1, 10); 
     assertAbbreviateWithOffset("abcdefg...", 0, 10); 
     assertAbbreviateWithOffset("abcdefg...", 1, 10); 
     assertAbbreviateWithOffset("abcdefg...", 2, 10); 
     assertAbbreviateWithOffset("abcdefg...", 3, 10); 
     assertAbbreviateWithOffset("abcdefg...", 4, 10); 
     assertAbbreviateWithOffset("...fghi...", 5, 10); 
     assertAbbreviateWithOffset("...ghij...", 6, 10); 
     assertAbbreviateWithOffset("...hijk...", 7, 10); 
     assertAbbreviateWithOffset("...ijklmno", 8, 10); 
     assertAbbreviateWithOffset("...ijklmno", 9, 10); 
     assertAbbreviateWithOffset("...ijklmno", 10, 10); 
     assertAbbreviateWithOffset("...ijklmno", 10, 10); 
     assertAbbreviateWithOffset("...ijklmno", 11, 10); 
     assertAbbreviateWithOffset("...ijklmno", 12, 10); 
     assertAbbreviateWithOffset("...ijklmno", 13, 10); 
     assertAbbreviateWithOffset("...ijklmno", 14, 10); 
     assertAbbreviateWithOffset("...ijklmno", 15, 10); 
     assertAbbreviateWithOffset("...ijklmno", 16, 10); 
     assertAbbreviateWithOffset("...ijklmno", Integer.MAX_VALUE, 10); 
 }
@Test
public void testJoin_ArrayOfLongs4786() { 
     assertEquals(null, StringUtils.join((long[]) null, ',')); 
     assertEquals("1;2", StringUtils.join(LONG_PRIM_LIST, SEPARATOR_CHAR)); 
     assertEquals("2", StringUtils.join(LONG_PRIM_LIST, SEPARATOR_CHAR, 1, 2)); 
 }
@Test
public void testOverlay_StringStringIntInt4806() { 
     assertEquals(null, StringUtils.overlay(null, null, 2, 4)); 
     assertEquals(null, StringUtils.overlay(null, null, -2, -4)); 
     assertEquals("", StringUtils.overlay("", null, 0, 0)); 
     assertEquals("", StringUtils.overlay("", "", 0, 0)); 
     assertEquals("zzzz", StringUtils.overlay("", "zzzz", 0, 0)); 
     assertEquals("zzzz", StringUtils.overlay("", "zzzz", 2, 4)); 
     assertEquals("zzzz", StringUtils.overlay("", "zzzz", -2, -4)); 
     assertEquals("abef", StringUtils.overlay("abcdef", null, 2, 4)); 
     assertEquals("abef", StringUtils.overlay("abcdef", null, 4, 2)); 
     assertEquals("abef", StringUtils.overlay("abcdef", "", 2, 4)); 
     assertEquals("abef", StringUtils.overlay("abcdef", "", 4, 2)); 
     assertEquals("abzzzzef", StringUtils.overlay("abcdef", "zzzz", 2, 4)); 
     assertEquals("abzzzzef", StringUtils.overlay("abcdef", "zzzz", 4, 2)); 
     assertEquals("zzzzef", StringUtils.overlay("abcdef", "zzzz", -1, 4)); 
     assertEquals("zzzzef", StringUtils.overlay("abcdef", "zzzz", 4, -1)); 
     assertEquals("zzzzabcdef", StringUtils.overlay("abcdef", "zzzz", -2, -1)); 
     assertEquals("zzzzabcdef", StringUtils.overlay("abcdef", "zzzz", -1, -2)); 
     assertEquals("abcdzzzz", StringUtils.overlay("abcdef", "zzzz", 4, 10)); 
     assertEquals("abcdzzzz", StringUtils.overlay("abcdef", "zzzz", 10, 4)); 
     assertEquals("abcdefzzzz", StringUtils.overlay("abcdef", "zzzz", 8, 10)); 
     assertEquals("abcdefzzzz", StringUtils.overlay("abcdef", "zzzz", 10, 8)); 
 }
@Test
public void testJoin_IteratorChar4809() { 
     assertEquals(null, StringUtils.join((Iterator<?>) null, ',')); 
     assertEquals(TEXT_LIST_CHAR, StringUtils.join(Arrays.asList(ARRAY_LIST).iterator(), SEPARATOR_CHAR)); 
     assertEquals("", StringUtils.join(Arrays.asList(NULL_ARRAY_LIST).iterator(), SEPARATOR_CHAR)); 
     assertEquals("", StringUtils.join(Arrays.asList(EMPTY_ARRAY_LIST).iterator(), SEPARATOR_CHAR)); 
     assertEquals("foo", StringUtils.join(Collections.singleton("foo").iterator(), 'x')); 
 }
@Test
public void testEscapeSurrogatePairsLang8584821() throws Exception { 
     assertEquals("\\uDBFF\\uDFFD", StringEscapeUtils.escapeJava("\uDBFF\uDFFD")); 
     assertEquals("\\uDBFF\\uDFFD", StringEscapeUtils.escapeEcmaScript("\uDBFF\uDFFD")); 
 }
@Test
public void testGetCommonPrefix_StringArray4831() { 
     assertEquals("", StringUtils.getCommonPrefix((String[]) null)); 
     assertEquals("", StringUtils.getCommonPrefix()); 
     assertEquals("abc", StringUtils.getCommonPrefix("abc")); 
     assertEquals("", StringUtils.getCommonPrefix(null, null)); 
     assertEquals("", StringUtils.getCommonPrefix("", "")); 
     assertEquals("", StringUtils.getCommonPrefix("", null)); 
     assertEquals("", StringUtils.getCommonPrefix("abc", null, null)); 
     assertEquals("", StringUtils.getCommonPrefix(null, null, "abc")); 
     assertEquals("", StringUtils.getCommonPrefix("", "abc")); 
     assertEquals("", StringUtils.getCommonPrefix("abc", "")); 
     assertEquals("abc", StringUtils.getCommonPrefix("abc", "abc")); 
     assertEquals("a", StringUtils.getCommonPrefix("abc", "a")); 
     assertEquals("ab", StringUtils.getCommonPrefix("ab", "abxyz")); 
     assertEquals("ab", StringUtils.getCommonPrefix("abcde", "abxyz")); 
     assertEquals("", StringUtils.getCommonPrefix("abcde", "xyz")); 
     assertEquals("", StringUtils.getCommonPrefix("xyz", "abcde")); 
     assertEquals("i am a ", StringUtils.getCommonPrefix("i am a machine", "i am a robot")); 
 }
@Test
public void testJoin_ArrayCharSeparator4841() { 
     assertEquals(null, StringUtils.join((Object[]) null, ',')); 
     assertEquals(TEXT_LIST_CHAR, StringUtils.join(ARRAY_LIST, SEPARATOR_CHAR)); 
     assertEquals("", StringUtils.join(EMPTY_ARRAY_LIST, SEPARATOR_CHAR)); 
     assertEquals(";;foo", StringUtils.join(MIXED_ARRAY_LIST, SEPARATOR_CHAR)); 
     assertEquals("foo;2", StringUtils.join(MIXED_TYPE_LIST, SEPARATOR_CHAR)); 
     assertEquals("/", StringUtils.join(MIXED_ARRAY_LIST, '/', 0, MIXED_ARRAY_LIST.length - 1)); 
     assertEquals("foo", StringUtils.join(MIXED_TYPE_LIST, '/', 0, 1)); 
     assertEquals("null", StringUtils.join(NULL_TO_STRING_LIST, '/', 0, 1)); 
     assertEquals("foo/2", StringUtils.join(MIXED_TYPE_LIST, '/', 0, 2)); 
     assertEquals("2", StringUtils.join(MIXED_TYPE_LIST, '/', 1, 2)); 
     assertEquals("", StringUtils.join(MIXED_TYPE_LIST, '/', 2, 1)); 
 }
@Test
public void testSplit_StringChar4847() { 
     assertArrayEquals(null, StringUtils.split(null, '.')); 
     assertEquals(0, StringUtils.split("", '.').length); 
     String str = "a.b.. c"; 
     String[] res = StringUtils.split(str, '.'); 
     assertEquals(3, res.length); 
     assertEquals("a", res[0]); 
     assertEquals("b", res[1]); 
     assertEquals(" c", res[2]); 
     str = ".a."; 
     res = StringUtils.split(str, '.'); 
     assertEquals(1, res.length); 
     assertEquals("a", res[0]); 
     str = "a b c"; 
     res = StringUtils.split(str, ' '); 
     assertEquals(3, res.length); 
     assertEquals("a", res[0]); 
     assertEquals("b", res[1]); 
     assertEquals("c", res[2]); 
 }
@Test
public void testJoin_ArrayOfChars4881() { 
     assertEquals(null, StringUtils.join((char[]) null, ',')); 
     assertEquals("1;2", StringUtils.join(CHAR_PRIM_LIST, SEPARATOR_CHAR)); 
     assertEquals("2", StringUtils.join(CHAR_PRIM_LIST, SEPARATOR_CHAR, 1, 2)); 
 }
@Test
public void testRemove_String4883() { 
     assertEquals(null, StringUtils.remove(null, null)); 
     assertEquals(null, StringUtils.remove(null, "")); 
     assertEquals(null, StringUtils.remove(null, "a")); 
     assertEquals("", StringUtils.remove("", null)); 
     assertEquals("", StringUtils.remove("", "")); 
     assertEquals("", StringUtils.remove("", "a")); 
     assertEquals(null, StringUtils.remove(null, null)); 
     assertEquals("", StringUtils.remove("", null)); 
     assertEquals("a", StringUtils.remove("a", null)); 
     assertEquals(null, StringUtils.remove(null, "")); 
     assertEquals("", StringUtils.remove("", "")); 
     assertEquals("a", StringUtils.remove("a", "")); 
     assertEquals("qd", StringUtils.remove("queued", "ue")); 
     assertEquals("queued", StringUtils.remove("queued", "zz")); 
 }
@Test
public void testRemove_char4884() { 
     assertEquals(null, StringUtils.remove(null, 'a')); 
     assertEquals(null, StringUtils.remove(null, 'a')); 
     assertEquals(null, StringUtils.remove(null, 'a')); 
     assertEquals("", StringUtils.remove("", 'a')); 
     assertEquals("", StringUtils.remove("", 'a')); 
     assertEquals("", StringUtils.remove("", 'a')); 
     assertEquals("qeed", StringUtils.remove("queued", 'u')); 
     assertEquals("queued", StringUtils.remove("queued", 'z')); 
 }
@Test
public void testJoin_IteratorChar4888() { 
     assertEquals(null, StringUtils.join((Iterator<?>) null, ',')); 
     assertEquals(TEXT_LIST_CHAR, StringUtils.join(Arrays.asList(ARRAY_LIST).iterator(), SEPARATOR_CHAR)); 
     assertEquals("", StringUtils.join(Arrays.asList(NULL_ARRAY_LIST).iterator(), SEPARATOR_CHAR)); 
     assertEquals("", StringUtils.join(Arrays.asList(EMPTY_ARRAY_LIST).iterator(), SEPARATOR_CHAR)); 
     assertEquals("foo", StringUtils.join(Collections.singleton("foo").iterator(), 'x')); 
 }
@Test
public void testCenter_StringIntChar4891() { 
     assertEquals(null, StringUtils.center(null, -1, ' ')); 
     assertEquals(null, StringUtils.center(null, 4, ' ')); 
     assertEquals("    ", StringUtils.center("", 4, ' ')); 
     assertEquals("ab", StringUtils.center("ab", 0, ' ')); 
     assertEquals("ab", StringUtils.center("ab", -1, ' ')); 
     assertEquals("ab", StringUtils.center("ab", 1, ' ')); 
     assertEquals("    ", StringUtils.center("", 4, ' ')); 
     assertEquals(" ab ", StringUtils.center("ab", 4, ' ')); 
     assertEquals("abcd", StringUtils.center("abcd", 2, ' ')); 
     assertEquals(" a  ", StringUtils.center("a", 4, ' ')); 
     assertEquals("  a  ", StringUtils.center("a", 5, ' ')); 
     assertEquals("xxaxx", StringUtils.center("a", 5, 'x')); 
 }
@Test
public void testRepeat_StringInt4900() { 
     assertEquals(null, StringUtils.repeat(null, 2)); 
     assertEquals("", StringUtils.repeat("ab", 0)); 
     assertEquals("", StringUtils.repeat("", 3)); 
     assertEquals("aaa", StringUtils.repeat("a", 3)); 
     assertEquals("ababab", StringUtils.repeat("ab", 3)); 
     assertEquals("abcabcabc", StringUtils.repeat("abc", 3)); 
     final String str = StringUtils.repeat("a", 10000); 
     assertEquals(10000, str.length()); 
     assertTrue(StringUtils.containsOnly(str, new char[] { 'a' })); 
 }
@Test
public void testEscapeSurrogatePairsLang8584920() throws Exception { 
     assertEquals("\\uDBFF\\uDFFD", StringEscapeUtils.escapeJava("\uDBFF\uDFFD")); 
     assertEquals("\\uDBFF\\uDFFD", StringEscapeUtils.escapeEcmaScript("\uDBFF\uDFFD")); 
 }
@Test
public void testNormalizeSpace4930() { 
     assertEquals(null, StringUtils.normalizeSpace(null)); 
     assertEquals("", StringUtils.normalizeSpace("")); 
     assertEquals("", StringUtils.normalizeSpace(" ")); 
     assertEquals("", StringUtils.normalizeSpace("\t")); 
     assertEquals("", StringUtils.normalizeSpace("\n")); 
     assertEquals("", StringUtils.normalizeSpace("\u0009")); 
     assertEquals("", StringUtils.normalizeSpace("\u000B")); 
     assertEquals("", StringUtils.normalizeSpace("\u000C")); 
     assertEquals("", StringUtils.normalizeSpace("\u001C")); 
     assertEquals("", StringUtils.normalizeSpace("\u001D")); 
     assertEquals("", StringUtils.normalizeSpace("\u001E")); 
     assertEquals("", StringUtils.normalizeSpace("\u001F")); 
     assertEquals("", StringUtils.normalizeSpace("\f")); 
     assertEquals("", StringUtils.normalizeSpace("\r")); 
     assertEquals("a", StringUtils.normalizeSpace("  a  ")); 
     assertEquals("a b c", StringUtils.normalizeSpace("  a  b   c  ")); 
     assertEquals("a b c", StringUtils.normalizeSpace("a\t\f\r  b\u000B   c\n")); 
 }
@Test
public void testSplitByCharacterType4951() { 
     assertNull(StringUtils.splitByCharacterType(null)); 
     assertEquals(0, StringUtils.splitByCharacterType("").length); 
     assertTrue(ArrayUtils.isEquals(new String[] { "ab", " ", "de", " ", "fg" }, StringUtils.splitByCharacterType("ab de fg"))); 
     assertTrue(ArrayUtils.isEquals(new String[] { "ab", "   ", "de", " ", "fg" }, StringUtils.splitByCharacterType("ab   de fg"))); 
     assertTrue(ArrayUtils.isEquals(new String[] { "ab", ":", "cd", ":", "ef" }, StringUtils.splitByCharacterType("ab:cd:ef"))); 
     assertTrue(ArrayUtils.isEquals(new String[] { "number", "5" }, StringUtils.splitByCharacterType("number5"))); 
     assertTrue(ArrayUtils.isEquals(new String[] { "foo", "B", "ar" }, StringUtils.splitByCharacterType("fooBar"))); 
     assertTrue(ArrayUtils.isEquals(new String[] { "foo", "200", "B", "ar" }, StringUtils.splitByCharacterType("foo200Bar"))); 
     assertTrue(ArrayUtils.isEquals(new String[] { "ASFR", "ules" }, StringUtils.splitByCharacterType("ASFRules"))); 
 }
@Test
public void testEscapeSurrogatePairs4965() throws Exception { 
     assertEquals("\uD83D\uDE30", StringEscapeUtils.escapeCsv("\uD83D\uDE30")); 
     assertEquals("\uD800\uDC00", StringEscapeUtils.escapeCsv("\uD800\uDC00")); 
     assertEquals("\uD834\uDD1E", StringEscapeUtils.escapeCsv("\uD834\uDD1E")); 
     assertEquals("\uDBFF\uDFFD", StringEscapeUtils.escapeCsv("\uDBFF\uDFFD")); 
     assertEquals("\uDBFF\uDFFD", StringEscapeUtils.escapeHtml3("\uDBFF\uDFFD")); 
     assertEquals("\uDBFF\uDFFD", StringEscapeUtils.escapeHtml4("\uDBFF\uDFFD")); 
     assertEquals("\uDBFF\uDFFD", StringEscapeUtils.escapeXml("\uDBFF\uDFFD")); 
 }
@Test
public void testJoin_ArrayCharSeparator4987() { 
     assertEquals(null, StringUtils.join((Object[]) null, ',')); 
     assertEquals(TEXT_LIST_CHAR, StringUtils.join(ARRAY_LIST, SEPARATOR_CHAR)); 
     assertEquals("", StringUtils.join(EMPTY_ARRAY_LIST, SEPARATOR_CHAR)); 
     assertEquals(";;foo", StringUtils.join(MIXED_ARRAY_LIST, SEPARATOR_CHAR)); 
     assertEquals("foo;2", StringUtils.join(MIXED_TYPE_LIST, SEPARATOR_CHAR)); 
     assertEquals("/", StringUtils.join(MIXED_ARRAY_LIST, '/', 0, MIXED_ARRAY_LIST.length - 1)); 
     assertEquals("foo", StringUtils.join(MIXED_TYPE_LIST, '/', 0, 1)); 
     assertEquals("null", StringUtils.join(NULL_TO_STRING_LIST, '/', 0, 1)); 
     assertEquals("foo/2", StringUtils.join(MIXED_TYPE_LIST, '/', 0, 2)); 
     assertEquals("2", StringUtils.join(MIXED_TYPE_LIST, '/', 1, 2)); 
     assertEquals("", StringUtils.join(MIXED_TYPE_LIST, '/', 2, 1)); 
 }
@Test
public void testSplitByCharacterTypeCamelCase4992() { 
     assertNull(StringUtils.splitByCharacterTypeCamelCase(null)); 
     assertEquals(0, StringUtils.splitByCharacterTypeCamelCase("").length); 
     assertTrue(ArrayUtils.isEquals(new String[] { "ab", " ", "de", " ", "fg" }, StringUtils.splitByCharacterTypeCamelCase("ab de fg"))); 
     assertTrue(ArrayUtils.isEquals(new String[] { "ab", "   ", "de", " ", "fg" }, StringUtils.splitByCharacterTypeCamelCase("ab   de fg"))); 
     assertTrue(ArrayUtils.isEquals(new String[] { "ab", ":", "cd", ":", "ef" }, StringUtils.splitByCharacterTypeCamelCase("ab:cd:ef"))); 
     assertTrue(ArrayUtils.isEquals(new String[] { "number", "5" }, StringUtils.splitByCharacterTypeCamelCase("number5"))); 
     assertTrue(ArrayUtils.isEquals(new String[] { "foo", "Bar" }, StringUtils.splitByCharacterTypeCamelCase("fooBar"))); 
     assertTrue(ArrayUtils.isEquals(new String[] { "foo", "200", "Bar" }, StringUtils.splitByCharacterTypeCamelCase("foo200Bar"))); 
     assertTrue(ArrayUtils.isEquals(new String[] { "ASF", "Rules" }, StringUtils.splitByCharacterTypeCamelCase("ASFRules"))); 
 }
@Test
public void testJoin_IterableString5000() { 
     assertEquals(null, StringUtils.join((Iterable<?>) null, null)); 
     assertEquals(TEXT_LIST_NOSEP, StringUtils.join(Arrays.asList(ARRAY_LIST), null)); 
     assertEquals(TEXT_LIST_NOSEP, StringUtils.join(Arrays.asList(ARRAY_LIST), "")); 
     assertEquals("foo", StringUtils.join(Collections.singleton("foo"), "x")); 
     assertEquals("foo", StringUtils.join(Collections.singleton("foo"), null)); 
     assertEquals("", StringUtils.join(Arrays.asList(NULL_ARRAY_LIST), null)); 
     assertEquals("", StringUtils.join(Arrays.asList(EMPTY_ARRAY_LIST), null)); 
     assertEquals("", StringUtils.join(Arrays.asList(EMPTY_ARRAY_LIST), "")); 
     assertEquals("", StringUtils.join(Arrays.asList(EMPTY_ARRAY_LIST), SEPARATOR)); 
     assertEquals(TEXT_LIST, StringUtils.join(Arrays.asList(ARRAY_LIST), SEPARATOR)); 
 } 
@SuppressWarnings("deprecation")
@Test
public void testChomp5014() { 
     final String[][] chompCases = { { FOO_UNCAP + "\r\n", FOO_UNCAP }, { FOO_UNCAP + "\n", FOO_UNCAP }, { FOO_UNCAP + "\r", FOO_UNCAP }, { FOO_UNCAP + " \r", FOO_UNCAP + " " }, { FOO_UNCAP, FOO_UNCAP }, { FOO_UNCAP + "\n\n", FOO_UNCAP + "\n" }, { FOO_UNCAP + "\r\n\r\n", FOO_UNCAP + "\r\n" }, { "foo\nfoo", "foo\nfoo" }, { "foo\n\rfoo", "foo\n\rfoo" }, { "\n", "" }, { "\r", "" }, { "a", "a" }, { "\r\n", "" }, { "", "" }, { null, null }, { FOO_UNCAP + "\n\r", FOO_UNCAP + "\n" } }; 
     for (final String[] chompCase : chompCases) { 
         final String original = chompCase[0]; 
         final String expectedResult = chompCase[1]; 
         assertEquals("chomp(String) failed", expectedResult, StringUtils.chomp(original)); 
     } 
     assertEquals("chomp(String, String) failed", "foo", StringUtils.chomp("foobar", "bar")); 
     assertEquals("chomp(String, String) failed", "foobar", StringUtils.chomp("foobar", "baz")); 
     assertEquals("chomp(String, String) failed", "foo", StringUtils.chomp("foo", "foooo")); 
     assertEquals("chomp(String, String) failed", "foobar", StringUtils.chomp("foobar", "")); 
     assertEquals("chomp(String, String) failed", "foobar", StringUtils.chomp("foobar", null)); 
     assertEquals("chomp(String, String) failed", "", StringUtils.chomp("", "foo")); 
     assertEquals("chomp(String, String) failed", "", StringUtils.chomp("", null)); 
     assertEquals("chomp(String, String) failed", "", StringUtils.chomp("", "")); 
     assertEquals("chomp(String, String) failed", null, StringUtils.chomp(null, "foo")); 
     assertEquals("chomp(String, String) failed", null, StringUtils.chomp(null, null)); 
     assertEquals("chomp(String, String) failed", null, StringUtils.chomp(null, "")); 
     assertEquals("chomp(String, String) failed", "", StringUtils.chomp("foo", "foo")); 
     assertEquals("chomp(String, String) failed", " ", StringUtils.chomp(" foo", "foo")); 
     assertEquals("chomp(String, String) failed", "foo ", StringUtils.chomp("foo ", "foo")); 
 }
@Test
public void testDefaultIfBlank_StringBuffers5023() { 
     assertEquals("NULL", StringUtils.defaultIfBlank(new StringBuffer(""), new StringBuffer("NULL")).toString()); 
     assertEquals("NULL", StringUtils.defaultIfBlank(new StringBuffer(" "), new StringBuffer("NULL")).toString()); 
     assertEquals("abc", StringUtils.defaultIfBlank(new StringBuffer("abc"), new StringBuffer("NULL")).toString()); 
     assertNull(StringUtils.defaultIfBlank(new StringBuffer(""), null)); 
     final StringBuffer s = StringUtils.defaultIfBlank(new StringBuffer("abc"), new StringBuffer("NULL")); 
     assertEquals("abc", s.toString()); 
 }
@Test
public void testJoin_ArrayOfChars5037() { 
     assertEquals(null, StringUtils.join((char[]) null, ',')); 
     assertEquals("1;2", StringUtils.join(CHAR_PRIM_LIST, SEPARATOR_CHAR)); 
     assertEquals("2", StringUtils.join(CHAR_PRIM_LIST, SEPARATOR_CHAR, 1, 2)); 
 }
@Test
public void testRepeat_StringInt5072() { 
     assertEquals(null, StringUtils.repeat(null, 2)); 
     assertEquals("", StringUtils.repeat("ab", 0)); 
     assertEquals("", StringUtils.repeat("", 3)); 
     assertEquals("aaa", StringUtils.repeat("a", 3)); 
     assertEquals("ababab", StringUtils.repeat("ab", 3)); 
     assertEquals("abcabcabc", StringUtils.repeat("abc", 3)); 
     final String str = StringUtils.repeat("a", 10000); 
     assertEquals(10000, str.length()); 
     assertTrue(StringUtils.containsOnly(str, new char[] { 'a' })); 
 }
@Test
public void testJoin_IteratorChar5079() { 
     assertEquals(null, StringUtils.join((Iterator<?>) null, ',')); 
     assertEquals(TEXT_LIST_CHAR, StringUtils.join(Arrays.asList(ARRAY_LIST).iterator(), SEPARATOR_CHAR)); 
     assertEquals("", StringUtils.join(Arrays.asList(NULL_ARRAY_LIST).iterator(), SEPARATOR_CHAR)); 
     assertEquals("", StringUtils.join(Arrays.asList(EMPTY_ARRAY_LIST).iterator(), SEPARATOR_CHAR)); 
     assertEquals("foo", StringUtils.join(Collections.singleton("foo").iterator(), 'x')); 
 }
@Test
public void testPrependIfMissingIgnoreCase5080() { 
     assertEquals("prependIfMissingIgnoreCase(null,null)", null, StringUtils.prependIfMissingIgnoreCase(null, null)); 
     assertEquals("prependIfMissingIgnoreCase(abc,null)", "abc", StringUtils.prependIfMissingIgnoreCase("abc", null)); 
     assertEquals("prependIfMissingIgnoreCase(\"\",xyz)", "xyz", StringUtils.prependIfMissingIgnoreCase("", "xyz")); 
     assertEquals("prependIfMissingIgnoreCase(abc,xyz)", "xyzabc", StringUtils.prependIfMissingIgnoreCase("abc", "xyz")); 
     assertEquals("prependIfMissingIgnoreCase(xyzabc,xyz)", "xyzabc", StringUtils.prependIfMissingIgnoreCase("xyzabc", "xyz")); 
     assertEquals("prependIfMissingIgnoreCase(XYZabc,xyz)", "XYZabc", StringUtils.prependIfMissingIgnoreCase("XYZabc", "xyz")); 
     assertEquals("prependIfMissingIgnoreCase(null,null null)", null, StringUtils.prependIfMissingIgnoreCase(null, null, (CharSequence[]) null)); 
     assertEquals("prependIfMissingIgnoreCase(abc,null,null)", "abc", StringUtils.prependIfMissingIgnoreCase("abc", null, (CharSequence[]) null)); 
     assertEquals("prependIfMissingIgnoreCase(\"\",xyz,null)", "xyz", StringUtils.prependIfMissingIgnoreCase("", "xyz", (CharSequence[]) null)); 
     assertEquals("prependIfMissingIgnoreCase(abc,xyz,{null})", "xyzabc", StringUtils.prependIfMissingIgnoreCase("abc", "xyz", new CharSequence[] { null })); 
     assertEquals("prependIfMissingIgnoreCase(abc,xyz,\"\")", "abc", StringUtils.prependIfMissingIgnoreCase("abc", "xyz", "")); 
     assertEquals("prependIfMissingIgnoreCase(abc,xyz,mno)", "xyzabc", StringUtils.prependIfMissingIgnoreCase("abc", "xyz", "mno")); 
     assertEquals("prependIfMissingIgnoreCase(xyzabc,xyz,mno)", "xyzabc", StringUtils.prependIfMissingIgnoreCase("xyzabc", "xyz", "mno")); 
     assertEquals("prependIfMissingIgnoreCase(mnoabc,xyz,mno)", "mnoabc", StringUtils.prependIfMissingIgnoreCase("mnoabc", "xyz", "mno")); 
     assertEquals("prependIfMissingIgnoreCase(XYZabc,xyz,mno)", "XYZabc", StringUtils.prependIfMissingIgnoreCase("XYZabc", "xyz", "mno")); 
     assertEquals("prependIfMissingIgnoreCase(MNOabc,xyz,mno)", "MNOabc", StringUtils.prependIfMissingIgnoreCase("MNOabc", "xyz", "mno")); 
 }
@Test
public void testJoin_IteratorChar5089() { 
     assertEquals(null, StringUtils.join((Iterator<?>) null, ',')); 
     assertEquals(TEXT_LIST_CHAR, StringUtils.join(Arrays.asList(ARRAY_LIST).iterator(), SEPARATOR_CHAR)); 
     assertEquals("", StringUtils.join(Arrays.asList(NULL_ARRAY_LIST).iterator(), SEPARATOR_CHAR)); 
     assertEquals("", StringUtils.join(Arrays.asList(EMPTY_ARRAY_LIST).iterator(), SEPARATOR_CHAR)); 
     assertEquals("foo", StringUtils.join(Collections.singleton("foo").iterator(), 'x')); 
 }
@Test
public void testRepeat_StringStringInt5091() { 
     assertEquals(null, StringUtils.repeat(null, null, 2)); 
     assertEquals(null, StringUtils.repeat(null, "x", 2)); 
     assertEquals("", StringUtils.repeat("", null, 2)); 
     assertEquals("", StringUtils.repeat("ab", "", 0)); 
     assertEquals("", StringUtils.repeat("", "", 2)); 
     assertEquals("xx", StringUtils.repeat("", "x", 3)); 
     assertEquals("?, ?, ?", StringUtils.repeat("?", ", ", 3)); 
 }
@Test
public void testGetLevenshteinDistance_StringStringInt5098() { 
     assertEquals(0, StringUtils.getLevenshteinDistance("", "", 0)); 
     assertEquals(7, StringUtils.getLevenshteinDistance("aaapppp", "", 8)); 
     assertEquals(7, StringUtils.getLevenshteinDistance("aaapppp", "", 7)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("aaapppp", "", 6)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("b", "a", 0)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("a", "b", 0)); 
     assertEquals(0, StringUtils.getLevenshteinDistance("aa", "aa", 0)); 
     assertEquals(0, StringUtils.getLevenshteinDistance("aa", "aa", 2)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("aaa", "bbb", 2)); 
     assertEquals(3, StringUtils.getLevenshteinDistance("aaa", "bbb", 3)); 
     assertEquals(6, StringUtils.getLevenshteinDistance("aaaaaa", "b", 10)); 
     assertEquals(7, StringUtils.getLevenshteinDistance("aaapppp", "b", 8)); 
     assertEquals(3, StringUtils.getLevenshteinDistance("a", "bbb", 4)); 
     assertEquals(7, StringUtils.getLevenshteinDistance("aaapppp", "b", 7)); 
     assertEquals(3, StringUtils.getLevenshteinDistance("a", "bbb", 3)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("a", "bbb", 2)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("bbb", "a", 2)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("aaapppp", "b", 6)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("a", "bbb", 1)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("bbb", "a", 1)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("12345", "1234567", 1)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("1234567", "12345", 1)); 
     assertEquals(1, StringUtils.getLevenshteinDistance("frog", "fog", 1)); 
     assertEquals(3, StringUtils.getLevenshteinDistance("fly", "ant", 3)); 
     assertEquals(7, StringUtils.getLevenshteinDistance("elephant", "hippo", 7)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("elephant", "hippo", 6)); 
     assertEquals(7, StringUtils.getLevenshteinDistance("hippo", "elephant", 7)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("hippo", "elephant", 6)); 
     assertEquals(8, StringUtils.getLevenshteinDistance("hippo", "zzzzzzzz", 8)); 
     assertEquals(8, StringUtils.getLevenshteinDistance("zzzzzzzz", "hippo", 8)); 
     assertEquals(1, StringUtils.getLevenshteinDistance("hello", "hallo", 1)); 
     try { 
         @SuppressWarnings("unused") 
         final int d = StringUtils.getLevenshteinDistance("a", null, 0); 
         fail("expecting IllegalArgumentException"); 
     } catch (final IllegalArgumentException ex) { 
     } 
     try { 
         @SuppressWarnings("unused") 
         final int d = StringUtils.getLevenshteinDistance(null, "a", 0); 
         fail("expecting IllegalArgumentException"); 
     } catch (final IllegalArgumentException ex) { 
     } 
     try { 
         @SuppressWarnings("unused") 
         final int d = StringUtils.getLevenshteinDistance("a", "a", -1); 
         fail("expecting IllegalArgumentException"); 
     } catch (final IllegalArgumentException ex) { 
     } 
 }
@Test
public void testJoin_IterableString5127() { 
     assertEquals(null, StringUtils.join((Iterable<?>) null, null)); 
     assertEquals(TEXT_LIST_NOSEP, StringUtils.join(Arrays.asList(ARRAY_LIST), null)); 
     assertEquals(TEXT_LIST_NOSEP, StringUtils.join(Arrays.asList(ARRAY_LIST), "")); 
     assertEquals("foo", StringUtils.join(Collections.singleton("foo"), "x")); 
     assertEquals("foo", StringUtils.join(Collections.singleton("foo"), null)); 
     assertEquals("", StringUtils.join(Arrays.asList(NULL_ARRAY_LIST), null)); 
     assertEquals("", StringUtils.join(Arrays.asList(EMPTY_ARRAY_LIST), null)); 
     assertEquals("", StringUtils.join(Arrays.asList(EMPTY_ARRAY_LIST), "")); 
     assertEquals("", StringUtils.join(Arrays.asList(EMPTY_ARRAY_LIST), SEPARATOR)); 
     assertEquals(TEXT_LIST, StringUtils.join(Arrays.asList(ARRAY_LIST), SEPARATOR)); 
 }
@Test
public void testDifference_StringString5132() { 
     assertEquals(null, StringUtils.difference(null, null)); 
     assertEquals("", StringUtils.difference("", "")); 
     assertEquals("abc", StringUtils.difference("", "abc")); 
     assertEquals("", StringUtils.difference("abc", "")); 
     assertEquals("i am a robot", StringUtils.difference(null, "i am a robot")); 
     assertEquals("i am a machine", StringUtils.difference("i am a machine", null)); 
     assertEquals("robot", StringUtils.difference("i am a machine", "i am a robot")); 
     assertEquals("", StringUtils.difference("abc", "abc")); 
     assertEquals("you are a robot", StringUtils.difference("i am a robot", "you are a robot")); 
 }
@Test
public void testReplace_StringStringStringInt5150() { 
     assertEquals(null, StringUtils.replace(null, null, null, 2)); 
     assertEquals(null, StringUtils.replace(null, null, "any", 2)); 
     assertEquals(null, StringUtils.replace(null, "any", null, 2)); 
     assertEquals(null, StringUtils.replace(null, "any", "any", 2)); 
     assertEquals("", StringUtils.replace("", null, null, 2)); 
     assertEquals("", StringUtils.replace("", null, "any", 2)); 
     assertEquals("", StringUtils.replace("", "any", null, 2)); 
     assertEquals("", StringUtils.replace("", "any", "any", 2)); 
     final String str = new String(new char[] { 'o', 'o', 'f', 'o', 'o' }); 
     assertSame(str, StringUtils.replace(str, "x", "", -1)); 
     assertEquals("f", StringUtils.replace("oofoo", "o", "", -1)); 
     assertEquals("oofoo", StringUtils.replace("oofoo", "o", "", 0)); 
     assertEquals("ofoo", StringUtils.replace("oofoo", "o", "", 1)); 
     assertEquals("foo", StringUtils.replace("oofoo", "o", "", 2)); 
     assertEquals("fo", StringUtils.replace("oofoo", "o", "", 3)); 
     assertEquals("f", StringUtils.replace("oofoo", "o", "", 4)); 
     assertEquals("f", StringUtils.replace("oofoo", "o", "", -5)); 
     assertEquals("f", StringUtils.replace("oofoo", "o", "", 1000)); 
 }
@Test
public void testJoin_ArrayOfChars5154() { 
     assertEquals(null, StringUtils.join((char[]) null, ',')); 
     assertEquals("1;2", StringUtils.join(CHAR_PRIM_LIST, SEPARATOR_CHAR)); 
     assertEquals("2", StringUtils.join(CHAR_PRIM_LIST, SEPARATOR_CHAR, 1, 2)); 
 }
@Test
public void testJoin_ArrayOfFloats5167() { 
     assertEquals(null, StringUtils.join((float[]) null, ',')); 
     assertEquals("1.0;2.0", StringUtils.join(FLOAT_PRIM_LIST, SEPARATOR_CHAR)); 
     assertEquals("2.0", StringUtils.join(FLOAT_PRIM_LIST, SEPARATOR_CHAR, 1, 2)); 
 }
@Test
public void testAbbreviate_StringIntInt5179() { 
     assertEquals(null, StringUtils.abbreviate(null, 10, 12)); 
     assertEquals("", StringUtils.abbreviate("", 0, 10)); 
     assertEquals("", StringUtils.abbreviate("", 2, 10)); 
     try { 
         @SuppressWarnings("unused") 
         final String res = StringUtils.abbreviate("abcdefghij", 0, 3); 
         fail("StringUtils.abbreviate expecting IllegalArgumentException"); 
     } catch (final IllegalArgumentException ex) { 
     } 
     try { 
         @SuppressWarnings("unused") 
         final String res = StringUtils.abbreviate("abcdefghij", 5, 6); 
         fail("StringUtils.abbreviate expecting IllegalArgumentException"); 
     } catch (final IllegalArgumentException ex) { 
     } 
     final String raspberry = "raspberry peach"; 
     assertEquals("raspberry peach", StringUtils.abbreviate(raspberry, 11, 15)); 
     assertEquals(null, StringUtils.abbreviate(null, 7, 14)); 
     assertAbbreviateWithOffset("abcdefg...", -1, 10); 
     assertAbbreviateWithOffset("abcdefg...", 0, 10); 
     assertAbbreviateWithOffset("abcdefg...", 1, 10); 
     assertAbbreviateWithOffset("abcdefg...", 2, 10); 
     assertAbbreviateWithOffset("abcdefg...", 3, 10); 
     assertAbbreviateWithOffset("abcdefg...", 4, 10); 
     assertAbbreviateWithOffset("...fghi...", 5, 10); 
     assertAbbreviateWithOffset("...ghij...", 6, 10); 
     assertAbbreviateWithOffset("...hijk...", 7, 10); 
     assertAbbreviateWithOffset("...ijklmno", 8, 10); 
     assertAbbreviateWithOffset("...ijklmno", 9, 10); 
     assertAbbreviateWithOffset("...ijklmno", 10, 10); 
     assertAbbreviateWithOffset("...ijklmno", 10, 10); 
     assertAbbreviateWithOffset("...ijklmno", 11, 10); 
     assertAbbreviateWithOffset("...ijklmno", 12, 10); 
     assertAbbreviateWithOffset("...ijklmno", 13, 10); 
     assertAbbreviateWithOffset("...ijklmno", 14, 10); 
     assertAbbreviateWithOffset("...ijklmno", 15, 10); 
     assertAbbreviateWithOffset("...ijklmno", 16, 10); 
     assertAbbreviateWithOffset("...ijklmno", Integer.MAX_VALUE, 10); 
 }
@Test
public void testSplit_StringChar5182() { 
     assertArrayEquals(null, StringUtils.split(null, '.')); 
     assertEquals(0, StringUtils.split("", '.').length); 
     String str = "a.b.. c"; 
     String[] res = StringUtils.split(str, '.'); 
     assertEquals(3, res.length); 
     assertEquals("a", res[0]); 
     assertEquals("b", res[1]); 
     assertEquals(" c", res[2]); 
     str = ".a."; 
     res = StringUtils.split(str, '.'); 
     assertEquals(1, res.length); 
     assertEquals("a", res[0]); 
     str = "a b c"; 
     res = StringUtils.split(str, ' '); 
     assertEquals(3, res.length); 
     assertEquals("a", res[0]); 
     assertEquals("b", res[1]); 
     assertEquals("c", res[2]); 
 }
@Test
public void testDeleteWhitespace_String5183() { 
     assertEquals(null, StringUtils.deleteWhitespace(null)); 
     assertEquals("", StringUtils.deleteWhitespace("")); 
     assertEquals("", StringUtils.deleteWhitespace("  \u000C  \t\t\u001F\n\n \u000B  ")); 
     assertEquals("", StringUtils.deleteWhitespace(StringUtilsTest.WHITESPACE)); 
     assertEquals(StringUtilsTest.NON_WHITESPACE, StringUtils.deleteWhitespace(StringUtilsTest.NON_WHITESPACE)); 
     assertEquals("\u00A0\u202F", StringUtils.deleteWhitespace("  \u00A0  \t\t\n\n \u202F  ")); 
     assertEquals("\u00A0\u202F", StringUtils.deleteWhitespace("\u00A0\u202F")); 
     assertEquals("test", StringUtils.deleteWhitespace("\u000Bt  \t\n\u0009e\rs\n\n   \tt")); 
 }
@Test
public void testRepeat_StringInt5204() { 
     assertEquals(null, StringUtils.repeat(null, 2)); 
     assertEquals("", StringUtils.repeat("ab", 0)); 
     assertEquals("", StringUtils.repeat("", 3)); 
     assertEquals("aaa", StringUtils.repeat("a", 3)); 
     assertEquals("ababab", StringUtils.repeat("ab", 3)); 
     assertEquals("abcabcabc", StringUtils.repeat("abc", 3)); 
     final String str = StringUtils.repeat("a", 10000); 
     assertEquals(10000, str.length()); 
     assertTrue(StringUtils.containsOnly(str, new char[] { 'a' })); 
 }
@Test
public void testReplace_StringStringArrayStringArray5228() { 
     assertNull(StringUtils.replaceEach(null, new String[] { "a" }, new String[] { "b" })); 
     assertEquals(StringUtils.replaceEach("", new String[] { "a" }, new String[] { "b" }), ""); 
     assertEquals(StringUtils.replaceEach("aba", null, null), "aba"); 
     assertEquals(StringUtils.replaceEach("aba", new String[0], null), "aba"); 
     assertEquals(StringUtils.replaceEach("aba", null, new String[0]), "aba"); 
     assertEquals(StringUtils.replaceEach("aba", new String[] { "a" }, null), "aba"); 
     assertEquals(StringUtils.replaceEach("aba", new String[] { "a" }, new String[] { "" }), "b"); 
     assertEquals(StringUtils.replaceEach("aba", new String[] { null }, new String[] { "a" }), "aba"); 
     assertEquals(StringUtils.replaceEach("abcde", new String[] { "ab", "d" }, new String[] { "w", "t" }), "wcte"); 
     assertEquals(StringUtils.replaceEach("abcde", new String[] { "ab", "d" }, new String[] { "d", "t" }), "dcte"); 
     assertEquals("bcc", StringUtils.replaceEach("abc", new String[] { "a", "b" }, new String[] { "b", "c" })); 
     assertEquals("q651.506bera", StringUtils.replaceEach("d216.102oren", new String[] { "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "1", "2", "3", "4", "5", "6", "7", "8", "9" }, new String[] { "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z", "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "5", "6", "7", "8", "9", "1", "2", "3", "4" })); 
     assertEquals(StringUtils.replaceEach("aba", new String[] { "a" }, new String[] { null }), "aba"); 
     assertEquals(StringUtils.replaceEach("aba", new String[] { "a", "b" }, new String[] { "c", null }), "cbc"); 
 }
@Test
public void testPrependIfMissingIgnoreCase5232() { 
     assertEquals("prependIfMissingIgnoreCase(null,null)", null, StringUtils.prependIfMissingIgnoreCase(null, null)); 
     assertEquals("prependIfMissingIgnoreCase(abc,null)", "abc", StringUtils.prependIfMissingIgnoreCase("abc", null)); 
     assertEquals("prependIfMissingIgnoreCase(\"\",xyz)", "xyz", StringUtils.prependIfMissingIgnoreCase("", "xyz")); 
     assertEquals("prependIfMissingIgnoreCase(abc,xyz)", "xyzabc", StringUtils.prependIfMissingIgnoreCase("abc", "xyz")); 
     assertEquals("prependIfMissingIgnoreCase(xyzabc,xyz)", "xyzabc", StringUtils.prependIfMissingIgnoreCase("xyzabc", "xyz")); 
     assertEquals("prependIfMissingIgnoreCase(XYZabc,xyz)", "XYZabc", StringUtils.prependIfMissingIgnoreCase("XYZabc", "xyz")); 
     assertEquals("prependIfMissingIgnoreCase(null,null null)", null, StringUtils.prependIfMissingIgnoreCase(null, null, (CharSequence[]) null)); 
     assertEquals("prependIfMissingIgnoreCase(abc,null,null)", "abc", StringUtils.prependIfMissingIgnoreCase("abc", null, (CharSequence[]) null)); 
     assertEquals("prependIfMissingIgnoreCase(\"\",xyz,null)", "xyz", StringUtils.prependIfMissingIgnoreCase("", "xyz", (CharSequence[]) null)); 
     assertEquals("prependIfMissingIgnoreCase(abc,xyz,{null})", "xyzabc", StringUtils.prependIfMissingIgnoreCase("abc", "xyz", new CharSequence[] { null })); 
     assertEquals("prependIfMissingIgnoreCase(abc,xyz,\"\")", "abc", StringUtils.prependIfMissingIgnoreCase("abc", "xyz", "")); 
     assertEquals("prependIfMissingIgnoreCase(abc,xyz,mno)", "xyzabc", StringUtils.prependIfMissingIgnoreCase("abc", "xyz", "mno")); 
     assertEquals("prependIfMissingIgnoreCase(xyzabc,xyz,mno)", "xyzabc", StringUtils.prependIfMissingIgnoreCase("xyzabc", "xyz", "mno")); 
     assertEquals("prependIfMissingIgnoreCase(mnoabc,xyz,mno)", "mnoabc", StringUtils.prependIfMissingIgnoreCase("mnoabc", "xyz", "mno")); 
     assertEquals("prependIfMissingIgnoreCase(XYZabc,xyz,mno)", "XYZabc", StringUtils.prependIfMissingIgnoreCase("XYZabc", "xyz", "mno")); 
     assertEquals("prependIfMissingIgnoreCase(MNOabc,xyz,mno)", "MNOabc", StringUtils.prependIfMissingIgnoreCase("MNOabc", "xyz", "mno")); 
 }
@Test
public void testJoin_ArrayOfShorts5233() { 
     assertEquals(null, StringUtils.join((short[]) null, ',')); 
     assertEquals("1;2", StringUtils.join(SHORT_PRIM_LIST, SEPARATOR_CHAR)); 
     assertEquals("2", StringUtils.join(SHORT_PRIM_LIST, SEPARATOR_CHAR, 1, 2)); 
 }
@Test
public void testReplace_StringStringArrayStringArray5235() { 
     assertNull(StringUtils.replaceEach(null, new String[] { "a" }, new String[] { "b" })); 
     assertEquals(StringUtils.replaceEach("", new String[] { "a" }, new String[] { "b" }), ""); 
     assertEquals(StringUtils.replaceEach("aba", null, null), "aba"); 
     assertEquals(StringUtils.replaceEach("aba", new String[0], null), "aba"); 
     assertEquals(StringUtils.replaceEach("aba", null, new String[0]), "aba"); 
     assertEquals(StringUtils.replaceEach("aba", new String[] { "a" }, null), "aba"); 
     assertEquals(StringUtils.replaceEach("aba", new String[] { "a" }, new String[] { "" }), "b"); 
     assertEquals(StringUtils.replaceEach("aba", new String[] { null }, new String[] { "a" }), "aba"); 
     assertEquals(StringUtils.replaceEach("abcde", new String[] { "ab", "d" }, new String[] { "w", "t" }), "wcte"); 
     assertEquals(StringUtils.replaceEach("abcde", new String[] { "ab", "d" }, new String[] { "d", "t" }), "dcte"); 
     assertEquals("bcc", StringUtils.replaceEach("abc", new String[] { "a", "b" }, new String[] { "b", "c" })); 
     assertEquals("q651.506bera", StringUtils.replaceEach("d216.102oren", new String[] { "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "1", "2", "3", "4", "5", "6", "7", "8", "9" }, new String[] { "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z", "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "5", "6", "7", "8", "9", "1", "2", "3", "4" })); 
     assertEquals(StringUtils.replaceEach("aba", new String[] { "a" }, new String[] { null }), "aba"); 
     assertEquals(StringUtils.replaceEach("aba", new String[] { "a", "b" }, new String[] { "c", null }), "cbc"); 
 }
@Test
public void testEscapeSurrogatePairs5238() throws Exception { 
     assertEquals("\uD83D\uDE30", StringEscapeUtils.escapeCsv("\uD83D\uDE30")); 
     assertEquals("\uD800\uDC00", StringEscapeUtils.escapeCsv("\uD800\uDC00")); 
     assertEquals("\uD834\uDD1E", StringEscapeUtils.escapeCsv("\uD834\uDD1E")); 
     assertEquals("\uDBFF\uDFFD", StringEscapeUtils.escapeCsv("\uDBFF\uDFFD")); 
     assertEquals("\uDBFF\uDFFD", StringEscapeUtils.escapeHtml3("\uDBFF\uDFFD")); 
     assertEquals("\uDBFF\uDFFD", StringEscapeUtils.escapeHtml4("\uDBFF\uDFFD")); 
     assertEquals("\uDBFF\uDFFD", StringEscapeUtils.escapeXml("\uDBFF\uDFFD")); 
 }
@Test
public void testReplaceChars_StringStringString5252() { 
     assertEquals(null, StringUtils.replaceChars(null, null, null)); 
     assertEquals(null, StringUtils.replaceChars(null, "", null)); 
     assertEquals(null, StringUtils.replaceChars(null, "a", null)); 
     assertEquals(null, StringUtils.replaceChars(null, null, "")); 
     assertEquals(null, StringUtils.replaceChars(null, null, "x")); 
     assertEquals("", StringUtils.replaceChars("", null, null)); 
     assertEquals("", StringUtils.replaceChars("", "", null)); 
     assertEquals("", StringUtils.replaceChars("", "a", null)); 
     assertEquals("", StringUtils.replaceChars("", null, "")); 
     assertEquals("", StringUtils.replaceChars("", null, "x")); 
     assertEquals("abc", StringUtils.replaceChars("abc", null, null)); 
     assertEquals("abc", StringUtils.replaceChars("abc", null, "")); 
     assertEquals("abc", StringUtils.replaceChars("abc", null, "x")); 
     assertEquals("abc", StringUtils.replaceChars("abc", "", null)); 
     assertEquals("abc", StringUtils.replaceChars("abc", "", "")); 
     assertEquals("abc", StringUtils.replaceChars("abc", "", "x")); 
     assertEquals("ac", StringUtils.replaceChars("abc", "b", null)); 
     assertEquals("ac", StringUtils.replaceChars("abc", "b", "")); 
     assertEquals("axc", StringUtils.replaceChars("abc", "b", "x")); 
     assertEquals("ayzya", StringUtils.replaceChars("abcba", "bc", "yz")); 
     assertEquals("ayya", StringUtils.replaceChars("abcba", "bc", "y")); 
     assertEquals("ayzya", StringUtils.replaceChars("abcba", "bc", "yzx")); 
     assertEquals("abcba", StringUtils.replaceChars("abcba", "z", "w")); 
     assertSame("abcba", StringUtils.replaceChars("abcba", "z", "w")); 
     assertEquals("jelly", StringUtils.replaceChars("hello", "ho", "jy")); 
     assertEquals("ayzya", StringUtils.replaceChars("abcba", "bc", "yz")); 
     assertEquals("ayya", StringUtils.replaceChars("abcba", "bc", "y")); 
     assertEquals("ayzya", StringUtils.replaceChars("abcba", "bc", "yzx")); 
     assertEquals("bcc", StringUtils.replaceChars("abc", "ab", "bc")); 
     assertEquals("q651.506bera", StringUtils.replaceChars("d216.102oren", "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ123456789", "nopqrstuvwxyzabcdefghijklmNOPQRSTUVWXYZABCDEFGHIJKLM567891234")); 
 }
@Test
public void testCenter_StringIntChar5258() { 
     assertEquals(null, StringUtils.center(null, -1, ' ')); 
     assertEquals(null, StringUtils.center(null, 4, ' ')); 
     assertEquals("    ", StringUtils.center("", 4, ' ')); 
     assertEquals("ab", StringUtils.center("ab", 0, ' ')); 
     assertEquals("ab", StringUtils.center("ab", -1, ' ')); 
     assertEquals("ab", StringUtils.center("ab", 1, ' ')); 
     assertEquals("    ", StringUtils.center("", 4, ' ')); 
     assertEquals(" ab ", StringUtils.center("ab", 4, ' ')); 
     assertEquals("abcd", StringUtils.center("abcd", 2, ' ')); 
     assertEquals(" a  ", StringUtils.center("a", 4, ' ')); 
     assertEquals("  a  ", StringUtils.center("a", 5, ' ')); 
     assertEquals("xxaxx", StringUtils.center("a", 5, 'x')); 
 }
@Test
public void testSwapCase_String5264() { 
     assertEquals(null, StringUtils.swapCase(null)); 
     assertEquals("", StringUtils.swapCase("")); 
     assertEquals("  ", StringUtils.swapCase("  ")); 
     assertEquals("i", WordUtils.swapCase("I")); 
     assertEquals("I", WordUtils.swapCase("i")); 
     assertEquals("I AM HERE 123", StringUtils.swapCase("i am here 123")); 
     assertEquals("i aM hERE 123", StringUtils.swapCase("I Am Here 123")); 
     assertEquals("I AM here 123", StringUtils.swapCase("i am HERE 123")); 
     assertEquals("i am here 123", StringUtils.swapCase("I AM HERE 123")); 
     final String test = "This String contains a TitleCase character: \u01C8"; 
     final String expect = "tHIS sTRING CONTAINS A tITLEcASE CHARACTER: \u01C9"; 
     assertEquals(expect, WordUtils.swapCase(test)); 
 }
@Test
public void testReplace_StringStringStringInt5269() { 
     assertEquals(null, StringUtils.replace(null, null, null, 2)); 
     assertEquals(null, StringUtils.replace(null, null, "any", 2)); 
     assertEquals(null, StringUtils.replace(null, "any", null, 2)); 
     assertEquals(null, StringUtils.replace(null, "any", "any", 2)); 
     assertEquals("", StringUtils.replace("", null, null, 2)); 
     assertEquals("", StringUtils.replace("", null, "any", 2)); 
     assertEquals("", StringUtils.replace("", "any", null, 2)); 
     assertEquals("", StringUtils.replace("", "any", "any", 2)); 
     final String str = new String(new char[] { 'o', 'o', 'f', 'o', 'o' }); 
     assertSame(str, StringUtils.replace(str, "x", "", -1)); 
     assertEquals("f", StringUtils.replace("oofoo", "o", "", -1)); 
     assertEquals("oofoo", StringUtils.replace("oofoo", "o", "", 0)); 
     assertEquals("ofoo", StringUtils.replace("oofoo", "o", "", 1)); 
     assertEquals("foo", StringUtils.replace("oofoo", "o", "", 2)); 
     assertEquals("fo", StringUtils.replace("oofoo", "o", "", 3)); 
     assertEquals("f", StringUtils.replace("oofoo", "o", "", 4)); 
     assertEquals("f", StringUtils.replace("oofoo", "o", "", -5)); 
     assertEquals("f", StringUtils.replace("oofoo", "o", "", 1000)); 
 }
@Test
public void testCenter_StringIntChar5282() { 
     assertEquals(null, StringUtils.center(null, -1, ' ')); 
     assertEquals(null, StringUtils.center(null, 4, ' ')); 
     assertEquals("    ", StringUtils.center("", 4, ' ')); 
     assertEquals("ab", StringUtils.center("ab", 0, ' ')); 
     assertEquals("ab", StringUtils.center("ab", -1, ' ')); 
     assertEquals("ab", StringUtils.center("ab", 1, ' ')); 
     assertEquals("    ", StringUtils.center("", 4, ' ')); 
     assertEquals(" ab ", StringUtils.center("ab", 4, ' ')); 
     assertEquals("abcd", StringUtils.center("abcd", 2, ' ')); 
     assertEquals(" a  ", StringUtils.center("a", 4, ' ')); 
     assertEquals("  a  ", StringUtils.center("a", 5, ' ')); 
     assertEquals("xxaxx", StringUtils.center("a", 5, 'x')); 
 }
@Test
public void testLang6235296() { 
     assertEquals("t", StringUtils.replaceChars("\u00DE", '\u00DE', 't')); 
     assertEquals("t", StringUtils.replaceChars("\u00FE", '\u00FE', 't')); 
 }
@Test
public void testJoin_ArrayOfBytes5305() { 
     assertEquals(null, StringUtils.join((byte[]) null, ',')); 
     assertEquals("1;2", StringUtils.join(BYTE_PRIM_LIST, SEPARATOR_CHAR)); 
     assertEquals("2", StringUtils.join(BYTE_PRIM_LIST, SEPARATOR_CHAR, 1, 2)); 
 }
@Test
public void testUnescapeSurrogatePairs5344() throws Exception { 
     assertEquals("\uD83D\uDE30", StringEscapeUtils.unescapeCsv("\uD83D\uDE30")); 
     assertEquals("\uD800\uDC00", StringEscapeUtils.unescapeCsv("\uD800\uDC00")); 
     assertEquals("\uD834\uDD1E", StringEscapeUtils.unescapeCsv("\uD834\uDD1E")); 
     assertEquals("\uDBFF\uDFFD", StringEscapeUtils.unescapeCsv("\uDBFF\uDFFD")); 
     assertEquals("\uDBFF\uDFFD", StringEscapeUtils.unescapeHtml3("\uDBFF\uDFFD")); 
     assertEquals("\uDBFF\uDFFD", StringEscapeUtils.unescapeHtml4("\uDBFF\uDFFD")); 
 }
@Test
public void testJoin_ArrayCharSeparator5349() { 
     assertEquals(null, StringUtils.join((Object[]) null, ',')); 
     assertEquals(TEXT_LIST_CHAR, StringUtils.join(ARRAY_LIST, SEPARATOR_CHAR)); 
     assertEquals("", StringUtils.join(EMPTY_ARRAY_LIST, SEPARATOR_CHAR)); 
     assertEquals(";;foo", StringUtils.join(MIXED_ARRAY_LIST, SEPARATOR_CHAR)); 
     assertEquals("foo;2", StringUtils.join(MIXED_TYPE_LIST, SEPARATOR_CHAR)); 
     assertEquals("/", StringUtils.join(MIXED_ARRAY_LIST, '/', 0, MIXED_ARRAY_LIST.length - 1)); 
     assertEquals("foo", StringUtils.join(MIXED_TYPE_LIST, '/', 0, 1)); 
     assertEquals("null", StringUtils.join(NULL_TO_STRING_LIST, '/', 0, 1)); 
     assertEquals("foo/2", StringUtils.join(MIXED_TYPE_LIST, '/', 0, 2)); 
     assertEquals("2", StringUtils.join(MIXED_TYPE_LIST, '/', 1, 2)); 
     assertEquals("", StringUtils.join(MIXED_TYPE_LIST, '/', 2, 1)); 
 }
@Test
public void testReplace_StringStringArrayStringArray5354() { 
     assertNull(StringUtils.replaceEach(null, new String[] { "a" }, new String[] { "b" })); 
     assertEquals(StringUtils.replaceEach("", new String[] { "a" }, new String[] { "b" }), ""); 
     assertEquals(StringUtils.replaceEach("aba", null, null), "aba"); 
     assertEquals(StringUtils.replaceEach("aba", new String[0], null), "aba"); 
     assertEquals(StringUtils.replaceEach("aba", null, new String[0]), "aba"); 
     assertEquals(StringUtils.replaceEach("aba", new String[] { "a" }, null), "aba"); 
     assertEquals(StringUtils.replaceEach("aba", new String[] { "a" }, new String[] { "" }), "b"); 
     assertEquals(StringUtils.replaceEach("aba", new String[] { null }, new String[] { "a" }), "aba"); 
     assertEquals(StringUtils.replaceEach("abcde", new String[] { "ab", "d" }, new String[] { "w", "t" }), "wcte"); 
     assertEquals(StringUtils.replaceEach("abcde", new String[] { "ab", "d" }, new String[] { "d", "t" }), "dcte"); 
     assertEquals("bcc", StringUtils.replaceEach("abc", new String[] { "a", "b" }, new String[] { "b", "c" })); 
     assertEquals("q651.506bera", StringUtils.replaceEach("d216.102oren", new String[] { "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "1", "2", "3", "4", "5", "6", "7", "8", "9" }, new String[] { "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z", "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "5", "6", "7", "8", "9", "1", "2", "3", "4" })); 
     assertEquals(StringUtils.replaceEach("aba", new String[] { "a" }, new String[] { null }), "aba"); 
     assertEquals(StringUtils.replaceEach("aba", new String[] { "a", "b" }, new String[] { "c", null }), "cbc"); 
 }
@Test
public void testJoin_ArrayOfShorts5363() { 
     assertEquals(null, StringUtils.join((short[]) null, ',')); 
     assertEquals("1;2", StringUtils.join(SHORT_PRIM_LIST, SEPARATOR_CHAR)); 
     assertEquals("2", StringUtils.join(SHORT_PRIM_LIST, SEPARATOR_CHAR, 1, 2)); 
 }
@Test
public void testSplit_StringChar5367() { 
     assertArrayEquals(null, StringUtils.split(null, '.')); 
     assertEquals(0, StringUtils.split("", '.').length); 
     String str = "a.b.. c"; 
     String[] res = StringUtils.split(str, '.'); 
     assertEquals(3, res.length); 
     assertEquals("a", res[0]); 
     assertEquals("b", res[1]); 
     assertEquals(" c", res[2]); 
     str = ".a."; 
     res = StringUtils.split(str, '.'); 
     assertEquals(1, res.length); 
     assertEquals("a", res[0]); 
     str = "a b c"; 
     res = StringUtils.split(str, ' '); 
     assertEquals(3, res.length); 
     assertEquals("a", res[0]); 
     assertEquals("b", res[1]); 
     assertEquals("c", res[2]); 
 }
@Test
public void testOverlay_StringStringIntInt5378() { 
     assertEquals(null, StringUtils.overlay(null, null, 2, 4)); 
     assertEquals(null, StringUtils.overlay(null, null, -2, -4)); 
     assertEquals("", StringUtils.overlay("", null, 0, 0)); 
     assertEquals("", StringUtils.overlay("", "", 0, 0)); 
     assertEquals("zzzz", StringUtils.overlay("", "zzzz", 0, 0)); 
     assertEquals("zzzz", StringUtils.overlay("", "zzzz", 2, 4)); 
     assertEquals("zzzz", StringUtils.overlay("", "zzzz", -2, -4)); 
     assertEquals("abef", StringUtils.overlay("abcdef", null, 2, 4)); 
     assertEquals("abef", StringUtils.overlay("abcdef", null, 4, 2)); 
     assertEquals("abef", StringUtils.overlay("abcdef", "", 2, 4)); 
     assertEquals("abef", StringUtils.overlay("abcdef", "", 4, 2)); 
     assertEquals("abzzzzef", StringUtils.overlay("abcdef", "zzzz", 2, 4)); 
     assertEquals("abzzzzef", StringUtils.overlay("abcdef", "zzzz", 4, 2)); 
     assertEquals("zzzzef", StringUtils.overlay("abcdef", "zzzz", -1, 4)); 
     assertEquals("zzzzef", StringUtils.overlay("abcdef", "zzzz", 4, -1)); 
     assertEquals("zzzzabcdef", StringUtils.overlay("abcdef", "zzzz", -2, -1)); 
     assertEquals("zzzzabcdef", StringUtils.overlay("abcdef", "zzzz", -1, -2)); 
     assertEquals("abcdzzzz", StringUtils.overlay("abcdef", "zzzz", 4, 10)); 
     assertEquals("abcdzzzz", StringUtils.overlay("abcdef", "zzzz", 10, 4)); 
     assertEquals("abcdefzzzz", StringUtils.overlay("abcdef", "zzzz", 8, 10)); 
     assertEquals("abcdefzzzz", StringUtils.overlay("abcdef", "zzzz", 10, 8)); 
 }
@Test
public void testSplitByCharacterTypeCamelCase5399() { 
     assertNull(StringUtils.splitByCharacterTypeCamelCase(null)); 
     assertEquals(0, StringUtils.splitByCharacterTypeCamelCase("").length); 
     assertTrue(ArrayUtils.isEquals(new String[] { "ab", " ", "de", " ", "fg" }, StringUtils.splitByCharacterTypeCamelCase("ab de fg"))); 
     assertTrue(ArrayUtils.isEquals(new String[] { "ab", "   ", "de", " ", "fg" }, StringUtils.splitByCharacterTypeCamelCase("ab   de fg"))); 
     assertTrue(ArrayUtils.isEquals(new String[] { "ab", ":", "cd", ":", "ef" }, StringUtils.splitByCharacterTypeCamelCase("ab:cd:ef"))); 
     assertTrue(ArrayUtils.isEquals(new String[] { "number", "5" }, StringUtils.splitByCharacterTypeCamelCase("number5"))); 
     assertTrue(ArrayUtils.isEquals(new String[] { "foo", "Bar" }, StringUtils.splitByCharacterTypeCamelCase("fooBar"))); 
     assertTrue(ArrayUtils.isEquals(new String[] { "foo", "200", "Bar" }, StringUtils.splitByCharacterTypeCamelCase("foo200Bar"))); 
     assertTrue(ArrayUtils.isEquals(new String[] { "ASF", "Rules" }, StringUtils.splitByCharacterTypeCamelCase("ASFRules"))); 
 }
@Test
public void testJoin_ArrayOfShorts5412() { 
     assertEquals(null, StringUtils.join((short[]) null, ',')); 
     assertEquals("1;2", StringUtils.join(SHORT_PRIM_LIST, SEPARATOR_CHAR)); 
     assertEquals("2", StringUtils.join(SHORT_PRIM_LIST, SEPARATOR_CHAR, 1, 2)); 
 }
@Test
public void testGetLevenshteinDistance_StringStringInt5483() { 
     assertEquals(0, StringUtils.getLevenshteinDistance("", "", 0)); 
     assertEquals(7, StringUtils.getLevenshteinDistance("aaapppp", "", 8)); 
     assertEquals(7, StringUtils.getLevenshteinDistance("aaapppp", "", 7)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("aaapppp", "", 6)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("b", "a", 0)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("a", "b", 0)); 
     assertEquals(0, StringUtils.getLevenshteinDistance("aa", "aa", 0)); 
     assertEquals(0, StringUtils.getLevenshteinDistance("aa", "aa", 2)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("aaa", "bbb", 2)); 
     assertEquals(3, StringUtils.getLevenshteinDistance("aaa", "bbb", 3)); 
     assertEquals(6, StringUtils.getLevenshteinDistance("aaaaaa", "b", 10)); 
     assertEquals(7, StringUtils.getLevenshteinDistance("aaapppp", "b", 8)); 
     assertEquals(3, StringUtils.getLevenshteinDistance("a", "bbb", 4)); 
     assertEquals(7, StringUtils.getLevenshteinDistance("aaapppp", "b", 7)); 
     assertEquals(3, StringUtils.getLevenshteinDistance("a", "bbb", 3)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("a", "bbb", 2)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("bbb", "a", 2)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("aaapppp", "b", 6)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("a", "bbb", 1)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("bbb", "a", 1)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("12345", "1234567", 1)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("1234567", "12345", 1)); 
     assertEquals(1, StringUtils.getLevenshteinDistance("frog", "fog", 1)); 
     assertEquals(3, StringUtils.getLevenshteinDistance("fly", "ant", 3)); 
     assertEquals(7, StringUtils.getLevenshteinDistance("elephant", "hippo", 7)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("elephant", "hippo", 6)); 
     assertEquals(7, StringUtils.getLevenshteinDistance("hippo", "elephant", 7)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("hippo", "elephant", 6)); 
     assertEquals(8, StringUtils.getLevenshteinDistance("hippo", "zzzzzzzz", 8)); 
     assertEquals(8, StringUtils.getLevenshteinDistance("zzzzzzzz", "hippo", 8)); 
     assertEquals(1, StringUtils.getLevenshteinDistance("hello", "hallo", 1)); 
     try { 
         @SuppressWarnings("unused") 
         final int d = StringUtils.getLevenshteinDistance("a", null, 0); 
         fail("expecting IllegalArgumentException"); 
     } catch (final IllegalArgumentException ex) { 
     } 
     try { 
         @SuppressWarnings("unused") 
         final int d = StringUtils.getLevenshteinDistance(null, "a", 0); 
         fail("expecting IllegalArgumentException"); 
     } catch (final IllegalArgumentException ex) { 
     } 
     try { 
         @SuppressWarnings("unused") 
         final int d = StringUtils.getLevenshteinDistance("a", "a", -1); 
         fail("expecting IllegalArgumentException"); 
     } catch (final IllegalArgumentException ex) { 
     } 
 }
@Test
public void testJoin_ArrayCharSeparator5487() { 
     assertEquals(null, StringUtils.join((Object[]) null, ',')); 
     assertEquals(TEXT_LIST_CHAR, StringUtils.join(ARRAY_LIST, SEPARATOR_CHAR)); 
     assertEquals("", StringUtils.join(EMPTY_ARRAY_LIST, SEPARATOR_CHAR)); 
     assertEquals(";;foo", StringUtils.join(MIXED_ARRAY_LIST, SEPARATOR_CHAR)); 
     assertEquals("foo;2", StringUtils.join(MIXED_TYPE_LIST, SEPARATOR_CHAR)); 
     assertEquals("/", StringUtils.join(MIXED_ARRAY_LIST, '/', 0, MIXED_ARRAY_LIST.length - 1)); 
     assertEquals("foo", StringUtils.join(MIXED_TYPE_LIST, '/', 0, 1)); 
     assertEquals("null", StringUtils.join(NULL_TO_STRING_LIST, '/', 0, 1)); 
     assertEquals("foo/2", StringUtils.join(MIXED_TYPE_LIST, '/', 0, 2)); 
     assertEquals("2", StringUtils.join(MIXED_TYPE_LIST, '/', 1, 2)); 
     assertEquals("", StringUtils.join(MIXED_TYPE_LIST, '/', 2, 1)); 
 }
@Test
public void testCenter_StringInt5516() { 
     assertEquals(null, StringUtils.center(null, -1)); 
     assertEquals(null, StringUtils.center(null, 4)); 
     assertEquals("    ", StringUtils.center("", 4)); 
     assertEquals("ab", StringUtils.center("ab", 0)); 
     assertEquals("ab", StringUtils.center("ab", -1)); 
     assertEquals("ab", StringUtils.center("ab", 1)); 
     assertEquals("    ", StringUtils.center("", 4)); 
     assertEquals(" ab ", StringUtils.center("ab", 4)); 
     assertEquals("abcd", StringUtils.center("abcd", 2)); 
     assertEquals(" a  ", StringUtils.center("a", 4)); 
     assertEquals("  a  ", StringUtils.center("a", 5)); 
 }
@Test
public void testDifference_StringString5519() { 
     assertEquals(null, StringUtils.difference(null, null)); 
     assertEquals("", StringUtils.difference("", "")); 
     assertEquals("abc", StringUtils.difference("", "abc")); 
     assertEquals("", StringUtils.difference("abc", "")); 
     assertEquals("i am a robot", StringUtils.difference(null, "i am a robot")); 
     assertEquals("i am a machine", StringUtils.difference("i am a machine", null)); 
     assertEquals("robot", StringUtils.difference("i am a machine", "i am a robot")); 
     assertEquals("", StringUtils.difference("abc", "abc")); 
     assertEquals("you are a robot", StringUtils.difference("i am a robot", "you are a robot")); 
 }
@Test
public void testPrependIfMissingIgnoreCase5531() { 
     assertEquals("prependIfMissingIgnoreCase(null,null)", null, StringUtils.prependIfMissingIgnoreCase(null, null)); 
     assertEquals("prependIfMissingIgnoreCase(abc,null)", "abc", StringUtils.prependIfMissingIgnoreCase("abc", null)); 
     assertEquals("prependIfMissingIgnoreCase(\"\",xyz)", "xyz", StringUtils.prependIfMissingIgnoreCase("", "xyz")); 
     assertEquals("prependIfMissingIgnoreCase(abc,xyz)", "xyzabc", StringUtils.prependIfMissingIgnoreCase("abc", "xyz")); 
     assertEquals("prependIfMissingIgnoreCase(xyzabc,xyz)", "xyzabc", StringUtils.prependIfMissingIgnoreCase("xyzabc", "xyz")); 
     assertEquals("prependIfMissingIgnoreCase(XYZabc,xyz)", "XYZabc", StringUtils.prependIfMissingIgnoreCase("XYZabc", "xyz")); 
     assertEquals("prependIfMissingIgnoreCase(null,null null)", null, StringUtils.prependIfMissingIgnoreCase(null, null, (CharSequence[]) null)); 
     assertEquals("prependIfMissingIgnoreCase(abc,null,null)", "abc", StringUtils.prependIfMissingIgnoreCase("abc", null, (CharSequence[]) null)); 
     assertEquals("prependIfMissingIgnoreCase(\"\",xyz,null)", "xyz", StringUtils.prependIfMissingIgnoreCase("", "xyz", (CharSequence[]) null)); 
     assertEquals("prependIfMissingIgnoreCase(abc,xyz,{null})", "xyzabc", StringUtils.prependIfMissingIgnoreCase("abc", "xyz", new CharSequence[] { null })); 
     assertEquals("prependIfMissingIgnoreCase(abc,xyz,\"\")", "abc", StringUtils.prependIfMissingIgnoreCase("abc", "xyz", "")); 
     assertEquals("prependIfMissingIgnoreCase(abc,xyz,mno)", "xyzabc", StringUtils.prependIfMissingIgnoreCase("abc", "xyz", "mno")); 
     assertEquals("prependIfMissingIgnoreCase(xyzabc,xyz,mno)", "xyzabc", StringUtils.prependIfMissingIgnoreCase("xyzabc", "xyz", "mno")); 
     assertEquals("prependIfMissingIgnoreCase(mnoabc,xyz,mno)", "mnoabc", StringUtils.prependIfMissingIgnoreCase("mnoabc", "xyz", "mno")); 
     assertEquals("prependIfMissingIgnoreCase(XYZabc,xyz,mno)", "XYZabc", StringUtils.prependIfMissingIgnoreCase("XYZabc", "xyz", "mno")); 
     assertEquals("prependIfMissingIgnoreCase(MNOabc,xyz,mno)", "MNOabc", StringUtils.prependIfMissingIgnoreCase("MNOabc", "xyz", "mno")); 
 } 
@SuppressWarnings("deprecation")
@Test
public void testChomp5537() { 
     final String[][] chompCases = { { FOO_UNCAP + "\r\n", FOO_UNCAP }, { FOO_UNCAP + "\n", FOO_UNCAP }, { FOO_UNCAP + "\r", FOO_UNCAP }, { FOO_UNCAP + " \r", FOO_UNCAP + " " }, { FOO_UNCAP, FOO_UNCAP }, { FOO_UNCAP + "\n\n", FOO_UNCAP + "\n" }, { FOO_UNCAP + "\r\n\r\n", FOO_UNCAP + "\r\n" }, { "foo\nfoo", "foo\nfoo" }, { "foo\n\rfoo", "foo\n\rfoo" }, { "\n", "" }, { "\r", "" }, { "a", "a" }, { "\r\n", "" }, { "", "" }, { null, null }, { FOO_UNCAP + "\n\r", FOO_UNCAP + "\n" } }; 
     for (final String[] chompCase : chompCases) { 
         final String original = chompCase[0]; 
         final String expectedResult = chompCase[1]; 
         assertEquals("chomp(String) failed", expectedResult, StringUtils.chomp(original)); 
     } 
     assertEquals("chomp(String, String) failed", "foo", StringUtils.chomp("foobar", "bar")); 
     assertEquals("chomp(String, String) failed", "foobar", StringUtils.chomp("foobar", "baz")); 
     assertEquals("chomp(String, String) failed", "foo", StringUtils.chomp("foo", "foooo")); 
     assertEquals("chomp(String, String) failed", "foobar", StringUtils.chomp("foobar", "")); 
     assertEquals("chomp(String, String) failed", "foobar", StringUtils.chomp("foobar", null)); 
     assertEquals("chomp(String, String) failed", "", StringUtils.chomp("", "foo")); 
     assertEquals("chomp(String, String) failed", "", StringUtils.chomp("", null)); 
     assertEquals("chomp(String, String) failed", "", StringUtils.chomp("", "")); 
     assertEquals("chomp(String, String) failed", null, StringUtils.chomp(null, "foo")); 
     assertEquals("chomp(String, String) failed", null, StringUtils.chomp(null, null)); 
     assertEquals("chomp(String, String) failed", null, StringUtils.chomp(null, "")); 
     assertEquals("chomp(String, String) failed", "", StringUtils.chomp("foo", "foo")); 
     assertEquals("chomp(String, String) failed", " ", StringUtils.chomp(" foo", "foo")); 
     assertEquals("chomp(String, String) failed", "foo ", StringUtils.chomp("foo ", "foo")); 
 }
@Test
public void testGetCommonPrefix_StringArray5543() { 
     assertEquals("", StringUtils.getCommonPrefix((String[]) null)); 
     assertEquals("", StringUtils.getCommonPrefix()); 
     assertEquals("abc", StringUtils.getCommonPrefix("abc")); 
     assertEquals("", StringUtils.getCommonPrefix(null, null)); 
     assertEquals("", StringUtils.getCommonPrefix("", "")); 
     assertEquals("", StringUtils.getCommonPrefix("", null)); 
     assertEquals("", StringUtils.getCommonPrefix("abc", null, null)); 
     assertEquals("", StringUtils.getCommonPrefix(null, null, "abc")); 
     assertEquals("", StringUtils.getCommonPrefix("", "abc")); 
     assertEquals("", StringUtils.getCommonPrefix("abc", "")); 
     assertEquals("abc", StringUtils.getCommonPrefix("abc", "abc")); 
     assertEquals("a", StringUtils.getCommonPrefix("abc", "a")); 
     assertEquals("ab", StringUtils.getCommonPrefix("ab", "abxyz")); 
     assertEquals("ab", StringUtils.getCommonPrefix("abcde", "abxyz")); 
     assertEquals("", StringUtils.getCommonPrefix("abcde", "xyz")); 
     assertEquals("", StringUtils.getCommonPrefix("xyz", "abcde")); 
     assertEquals("i am a ", StringUtils.getCommonPrefix("i am a machine", "i am a robot")); 
 }
@Test
public void testDeleteWhitespace_String5546() { 
     assertEquals(null, StringUtils.deleteWhitespace(null)); 
     assertEquals("", StringUtils.deleteWhitespace("")); 
     assertEquals("", StringUtils.deleteWhitespace("  \u000C  \t\t\u001F\n\n \u000B  ")); 
     assertEquals("", StringUtils.deleteWhitespace(StringUtilsTest.WHITESPACE)); 
     assertEquals(StringUtilsTest.NON_WHITESPACE, StringUtils.deleteWhitespace(StringUtilsTest.NON_WHITESPACE)); 
     assertEquals("\u00A0\u202F", StringUtils.deleteWhitespace("  \u00A0  \t\t\n\n \u202F  ")); 
     assertEquals("\u00A0\u202F", StringUtils.deleteWhitespace("\u00A0\u202F")); 
     assertEquals("test", StringUtils.deleteWhitespace("\u000Bt  \t\n\u0009e\rs\n\n   \tt")); 
 }
@Test
public void testReplaceChars_StringStringString5572() { 
     assertEquals(null, StringUtils.replaceChars(null, null, null)); 
     assertEquals(null, StringUtils.replaceChars(null, "", null)); 
     assertEquals(null, StringUtils.replaceChars(null, "a", null)); 
     assertEquals(null, StringUtils.replaceChars(null, null, "")); 
     assertEquals(null, StringUtils.replaceChars(null, null, "x")); 
     assertEquals("", StringUtils.replaceChars("", null, null)); 
     assertEquals("", StringUtils.replaceChars("", "", null)); 
     assertEquals("", StringUtils.replaceChars("", "a", null)); 
     assertEquals("", StringUtils.replaceChars("", null, "")); 
     assertEquals("", StringUtils.replaceChars("", null, "x")); 
     assertEquals("abc", StringUtils.replaceChars("abc", null, null)); 
     assertEquals("abc", StringUtils.replaceChars("abc", null, "")); 
     assertEquals("abc", StringUtils.replaceChars("abc", null, "x")); 
     assertEquals("abc", StringUtils.replaceChars("abc", "", null)); 
     assertEquals("abc", StringUtils.replaceChars("abc", "", "")); 
     assertEquals("abc", StringUtils.replaceChars("abc", "", "x")); 
     assertEquals("ac", StringUtils.replaceChars("abc", "b", null)); 
     assertEquals("ac", StringUtils.replaceChars("abc", "b", "")); 
     assertEquals("axc", StringUtils.replaceChars("abc", "b", "x")); 
     assertEquals("ayzya", StringUtils.replaceChars("abcba", "bc", "yz")); 
     assertEquals("ayya", StringUtils.replaceChars("abcba", "bc", "y")); 
     assertEquals("ayzya", StringUtils.replaceChars("abcba", "bc", "yzx")); 
     assertEquals("abcba", StringUtils.replaceChars("abcba", "z", "w")); 
     assertSame("abcba", StringUtils.replaceChars("abcba", "z", "w")); 
     assertEquals("jelly", StringUtils.replaceChars("hello", "ho", "jy")); 
     assertEquals("ayzya", StringUtils.replaceChars("abcba", "bc", "yz")); 
     assertEquals("ayya", StringUtils.replaceChars("abcba", "bc", "y")); 
     assertEquals("ayzya", StringUtils.replaceChars("abcba", "bc", "yzx")); 
     assertEquals("bcc", StringUtils.replaceChars("abc", "ab", "bc")); 
     assertEquals("q651.506bera", StringUtils.replaceChars("d216.102oren", "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ123456789", "nopqrstuvwxyzabcdefghijklmNOPQRSTUVWXYZABCDEFGHIJKLM567891234")); 
 }
@Test
public void testJoin_IteratorChar5582() { 
     assertEquals(null, StringUtils.join((Iterator<?>) null, ',')); 
     assertEquals(TEXT_LIST_CHAR, StringUtils.join(Arrays.asList(ARRAY_LIST).iterator(), SEPARATOR_CHAR)); 
     assertEquals("", StringUtils.join(Arrays.asList(NULL_ARRAY_LIST).iterator(), SEPARATOR_CHAR)); 
     assertEquals("", StringUtils.join(Arrays.asList(EMPTY_ARRAY_LIST).iterator(), SEPARATOR_CHAR)); 
     assertEquals("foo", StringUtils.join(Collections.singleton("foo").iterator(), 'x')); 
 }
@Test
public void testSplitByCharacterType5586() { 
     assertNull(StringUtils.splitByCharacterType(null)); 
     assertEquals(0, StringUtils.splitByCharacterType("").length); 
     assertTrue(ArrayUtils.isEquals(new String[] { "ab", " ", "de", " ", "fg" }, StringUtils.splitByCharacterType("ab de fg"))); 
     assertTrue(ArrayUtils.isEquals(new String[] { "ab", "   ", "de", " ", "fg" }, StringUtils.splitByCharacterType("ab   de fg"))); 
     assertTrue(ArrayUtils.isEquals(new String[] { "ab", ":", "cd", ":", "ef" }, StringUtils.splitByCharacterType("ab:cd:ef"))); 
     assertTrue(ArrayUtils.isEquals(new String[] { "number", "5" }, StringUtils.splitByCharacterType("number5"))); 
     assertTrue(ArrayUtils.isEquals(new String[] { "foo", "B", "ar" }, StringUtils.splitByCharacterType("fooBar"))); 
     assertTrue(ArrayUtils.isEquals(new String[] { "foo", "200", "B", "ar" }, StringUtils.splitByCharacterType("foo200Bar"))); 
     assertTrue(ArrayUtils.isEquals(new String[] { "ASFR", "ules" }, StringUtils.splitByCharacterType("ASFRules"))); 
 }
@Test
public void testRemove_char5615() { 
     assertEquals(null, StringUtils.remove(null, 'a')); 
     assertEquals(null, StringUtils.remove(null, 'a')); 
     assertEquals(null, StringUtils.remove(null, 'a')); 
     assertEquals("", StringUtils.remove("", 'a')); 
     assertEquals("", StringUtils.remove("", 'a')); 
     assertEquals("", StringUtils.remove("", 'a')); 
     assertEquals("qeed", StringUtils.remove("queued", 'u')); 
     assertEquals("queued", StringUtils.remove("queued", 'z')); 
 }
@Test
public void testSplit_StringChar5650() { 
     assertArrayEquals(null, StringUtils.split(null, '.')); 
     assertEquals(0, StringUtils.split("", '.').length); 
     String str = "a.b.. c"; 
     String[] res = StringUtils.split(str, '.'); 
     assertEquals(3, res.length); 
     assertEquals("a", res[0]); 
     assertEquals("b", res[1]); 
     assertEquals(" c", res[2]); 
     str = ".a."; 
     res = StringUtils.split(str, '.'); 
     assertEquals(1, res.length); 
     assertEquals("a", res[0]); 
     str = "a b c"; 
     res = StringUtils.split(str, ' '); 
     assertEquals(3, res.length); 
     assertEquals("a", res[0]); 
     assertEquals("b", res[1]); 
     assertEquals("c", res[2]); 
 }
@Test
public void testSplitByCharacterTypeCamelCase5655() { 
     assertNull(StringUtils.splitByCharacterTypeCamelCase(null)); 
     assertEquals(0, StringUtils.splitByCharacterTypeCamelCase("").length); 
     assertTrue(ArrayUtils.isEquals(new String[] { "ab", " ", "de", " ", "fg" }, StringUtils.splitByCharacterTypeCamelCase("ab de fg"))); 
     assertTrue(ArrayUtils.isEquals(new String[] { "ab", "   ", "de", " ", "fg" }, StringUtils.splitByCharacterTypeCamelCase("ab   de fg"))); 
     assertTrue(ArrayUtils.isEquals(new String[] { "ab", ":", "cd", ":", "ef" }, StringUtils.splitByCharacterTypeCamelCase("ab:cd:ef"))); 
     assertTrue(ArrayUtils.isEquals(new String[] { "number", "5" }, StringUtils.splitByCharacterTypeCamelCase("number5"))); 
     assertTrue(ArrayUtils.isEquals(new String[] { "foo", "Bar" }, StringUtils.splitByCharacterTypeCamelCase("fooBar"))); 
     assertTrue(ArrayUtils.isEquals(new String[] { "foo", "200", "Bar" }, StringUtils.splitByCharacterTypeCamelCase("foo200Bar"))); 
     assertTrue(ArrayUtils.isEquals(new String[] { "ASF", "Rules" }, StringUtils.splitByCharacterTypeCamelCase("ASFRules"))); 
 }
@Test
public void testEscapeSurrogatePairs5668() throws Exception { 
     assertEquals("\uD83D\uDE30", StringEscapeUtils.escapeCsv("\uD83D\uDE30")); 
     assertEquals("\uD800\uDC00", StringEscapeUtils.escapeCsv("\uD800\uDC00")); 
     assertEquals("\uD834\uDD1E", StringEscapeUtils.escapeCsv("\uD834\uDD1E")); 
     assertEquals("\uDBFF\uDFFD", StringEscapeUtils.escapeCsv("\uDBFF\uDFFD")); 
     assertEquals("\uDBFF\uDFFD", StringEscapeUtils.escapeHtml3("\uDBFF\uDFFD")); 
     assertEquals("\uDBFF\uDFFD", StringEscapeUtils.escapeHtml4("\uDBFF\uDFFD")); 
     assertEquals("\uDBFF\uDFFD", StringEscapeUtils.escapeXml("\uDBFF\uDFFD")); 
 }
@Test
public void testIsAllUpperCase5693() { 
     assertFalse(StringUtils.isAllUpperCase(null)); 
     assertFalse(StringUtils.isAllUpperCase(StringUtils.EMPTY)); 
     assertTrue(StringUtils.isAllUpperCase("ABC")); 
     assertFalse(StringUtils.isAllUpperCase("ABC ")); 
     assertFalse(StringUtils.isAllUpperCase("aBC")); 
 }
@Test
public void testReverse_String5704() { 
     assertEquals(null, StringUtils.reverse(null)); 
     assertEquals("", StringUtils.reverse("")); 
     assertEquals("sdrawkcab", StringUtils.reverse("backwards")); 
 }
@Test
public void testIsAllLowerCase5731() { 
     assertFalse(StringUtils.isAllLowerCase(null)); 
     assertFalse(StringUtils.isAllLowerCase(StringUtils.EMPTY)); 
     assertTrue(StringUtils.isAllLowerCase("abc")); 
     assertFalse(StringUtils.isAllLowerCase("abc ")); 
     assertFalse(StringUtils.isAllLowerCase("abC")); 
 }
@Test
public void testEscapeSurrogatePairsLang8585736() throws Exception { 
     assertEquals("\\uDBFF\\uDFFD", StringEscapeUtils.escapeJava("\uDBFF\uDFFD")); 
     assertEquals("\\uDBFF\\uDFFD", StringEscapeUtils.escapeEcmaScript("\uDBFF\uDFFD")); 
 }
@Test
public void testJoin_ArrayCharSeparator5755() { 
     assertEquals(null, StringUtils.join((Object[]) null, ',')); 
     assertEquals(TEXT_LIST_CHAR, StringUtils.join(ARRAY_LIST, SEPARATOR_CHAR)); 
     assertEquals("", StringUtils.join(EMPTY_ARRAY_LIST, SEPARATOR_CHAR)); 
     assertEquals(";;foo", StringUtils.join(MIXED_ARRAY_LIST, SEPARATOR_CHAR)); 
     assertEquals("foo;2", StringUtils.join(MIXED_TYPE_LIST, SEPARATOR_CHAR)); 
     assertEquals("/", StringUtils.join(MIXED_ARRAY_LIST, '/', 0, MIXED_ARRAY_LIST.length - 1)); 
     assertEquals("foo", StringUtils.join(MIXED_TYPE_LIST, '/', 0, 1)); 
     assertEquals("null", StringUtils.join(NULL_TO_STRING_LIST, '/', 0, 1)); 
     assertEquals("foo/2", StringUtils.join(MIXED_TYPE_LIST, '/', 0, 2)); 
     assertEquals("2", StringUtils.join(MIXED_TYPE_LIST, '/', 1, 2)); 
     assertEquals("", StringUtils.join(MIXED_TYPE_LIST, '/', 2, 1)); 
 }
@Test
public void testJoin_ArrayOfLongs5757() { 
     assertEquals(null, StringUtils.join((long[]) null, ',')); 
     assertEquals("1;2", StringUtils.join(LONG_PRIM_LIST, SEPARATOR_CHAR)); 
     assertEquals("2", StringUtils.join(LONG_PRIM_LIST, SEPARATOR_CHAR, 1, 2)); 
 }
@Test
public void testChop5765() { 
     final String[][] chopCases = { { FOO_UNCAP + "\r\n", FOO_UNCAP }, { FOO_UNCAP + "\n", FOO_UNCAP }, { FOO_UNCAP + "\r", FOO_UNCAP }, { FOO_UNCAP + " \r", FOO_UNCAP + " " }, { "foo", "fo" }, { "foo\nfoo", "foo\nfo" }, { "\n", "" }, { "\r", "" }, { "\r\n", "" }, { null, null }, { "", "" }, { "a", "" } }; 
     for (final String[] chopCase : chopCases) { 
         final String original = chopCase[0]; 
         final String expectedResult = chopCase[1]; 
         assertEquals("chop(String) failed", expectedResult, StringUtils.chop(original)); 
     } 
 }
@Test
public void testReverseDelimited_StringChar5766() { 
     assertEquals(null, StringUtils.reverseDelimited(null, '.')); 
     assertEquals("", StringUtils.reverseDelimited("", '.')); 
     assertEquals("c.b.a", StringUtils.reverseDelimited("a.b.c", '.')); 
     assertEquals("a b c", StringUtils.reverseDelimited("a b c", '.')); 
     assertEquals("", StringUtils.reverseDelimited("", '.')); 
 }
@Test
public void testReplace_StringStringArrayStringArray5768() { 
     assertNull(StringUtils.replaceEach(null, new String[] { "a" }, new String[] { "b" })); 
     assertEquals(StringUtils.replaceEach("", new String[] { "a" }, new String[] { "b" }), ""); 
     assertEquals(StringUtils.replaceEach("aba", null, null), "aba"); 
     assertEquals(StringUtils.replaceEach("aba", new String[0], null), "aba"); 
     assertEquals(StringUtils.replaceEach("aba", null, new String[0]), "aba"); 
     assertEquals(StringUtils.replaceEach("aba", new String[] { "a" }, null), "aba"); 
     assertEquals(StringUtils.replaceEach("aba", new String[] { "a" }, new String[] { "" }), "b"); 
     assertEquals(StringUtils.replaceEach("aba", new String[] { null }, new String[] { "a" }), "aba"); 
     assertEquals(StringUtils.replaceEach("abcde", new String[] { "ab", "d" }, new String[] { "w", "t" }), "wcte"); 
     assertEquals(StringUtils.replaceEach("abcde", new String[] { "ab", "d" }, new String[] { "d", "t" }), "dcte"); 
     assertEquals("bcc", StringUtils.replaceEach("abc", new String[] { "a", "b" }, new String[] { "b", "c" })); 
     assertEquals("q651.506bera", StringUtils.replaceEach("d216.102oren", new String[] { "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "1", "2", "3", "4", "5", "6", "7", "8", "9" }, new String[] { "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z", "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "5", "6", "7", "8", "9", "1", "2", "3", "4" })); 
     assertEquals(StringUtils.replaceEach("aba", new String[] { "a" }, new String[] { null }), "aba"); 
     assertEquals(StringUtils.replaceEach("aba", new String[] { "a", "b" }, new String[] { "c", null }), "cbc"); 
 }
@Test
public void testEscapeSurrogatePairsLang8585771() throws Exception { 
     assertEquals("\\uDBFF\\uDFFD", StringEscapeUtils.escapeJava("\uDBFF\uDFFD")); 
     assertEquals("\\uDBFF\\uDFFD", StringEscapeUtils.escapeEcmaScript("\uDBFF\uDFFD")); 
 }
@Test
public void testEscapeSurrogatePairsLang8585773() throws Exception { 
     assertEquals("\\uDBFF\\uDFFD", StringEscapeUtils.escapeJava("\uDBFF\uDFFD")); 
     assertEquals("\\uDBFF\\uDFFD", StringEscapeUtils.escapeEcmaScript("\uDBFF\uDFFD")); 
 }
@Test
public void testAbbreviate_StringIntInt5777() { 
     assertEquals(null, StringUtils.abbreviate(null, 10, 12)); 
     assertEquals("", StringUtils.abbreviate("", 0, 10)); 
     assertEquals("", StringUtils.abbreviate("", 2, 10)); 
     try { 
         @SuppressWarnings("unused") 
         final String res = StringUtils.abbreviate("abcdefghij", 0, 3); 
         fail("StringUtils.abbreviate expecting IllegalArgumentException"); 
     } catch (final IllegalArgumentException ex) { 
     } 
     try { 
         @SuppressWarnings("unused") 
         final String res = StringUtils.abbreviate("abcdefghij", 5, 6); 
         fail("StringUtils.abbreviate expecting IllegalArgumentException"); 
     } catch (final IllegalArgumentException ex) { 
     } 
     final String raspberry = "raspberry peach"; 
     assertEquals("raspberry peach", StringUtils.abbreviate(raspberry, 11, 15)); 
     assertEquals(null, StringUtils.abbreviate(null, 7, 14)); 
     assertAbbreviateWithOffset("abcdefg...", -1, 10); 
     assertAbbreviateWithOffset("abcdefg...", 0, 10); 
     assertAbbreviateWithOffset("abcdefg...", 1, 10); 
     assertAbbreviateWithOffset("abcdefg...", 2, 10); 
     assertAbbreviateWithOffset("abcdefg...", 3, 10); 
     assertAbbreviateWithOffset("abcdefg...", 4, 10); 
     assertAbbreviateWithOffset("...fghi...", 5, 10); 
     assertAbbreviateWithOffset("...ghij...", 6, 10); 
     assertAbbreviateWithOffset("...hijk...", 7, 10); 
     assertAbbreviateWithOffset("...ijklmno", 8, 10); 
     assertAbbreviateWithOffset("...ijklmno", 9, 10); 
     assertAbbreviateWithOffset("...ijklmno", 10, 10); 
     assertAbbreviateWithOffset("...ijklmno", 10, 10); 
     assertAbbreviateWithOffset("...ijklmno", 11, 10); 
     assertAbbreviateWithOffset("...ijklmno", 12, 10); 
     assertAbbreviateWithOffset("...ijklmno", 13, 10); 
     assertAbbreviateWithOffset("...ijklmno", 14, 10); 
     assertAbbreviateWithOffset("...ijklmno", 15, 10); 
     assertAbbreviateWithOffset("...ijklmno", 16, 10); 
     assertAbbreviateWithOffset("...ijklmno", Integer.MAX_VALUE, 10); 
 }
@Test
public void testCenter_StringIntChar5781() { 
     assertEquals(null, StringUtils.center(null, -1, ' ')); 
     assertEquals(null, StringUtils.center(null, 4, ' ')); 
     assertEquals("    ", StringUtils.center("", 4, ' ')); 
     assertEquals("ab", StringUtils.center("ab", 0, ' ')); 
     assertEquals("ab", StringUtils.center("ab", -1, ' ')); 
     assertEquals("ab", StringUtils.center("ab", 1, ' ')); 
     assertEquals("    ", StringUtils.center("", 4, ' ')); 
     assertEquals(" ab ", StringUtils.center("ab", 4, ' ')); 
     assertEquals("abcd", StringUtils.center("abcd", 2, ' ')); 
     assertEquals(" a  ", StringUtils.center("a", 4, ' ')); 
     assertEquals("  a  ", StringUtils.center("a", 5, ' ')); 
     assertEquals("xxaxx", StringUtils.center("a", 5, 'x')); 
 } 
@SuppressWarnings("deprecation")
@Test
public void testChomp5813() { 
     final String[][] chompCases = { { FOO_UNCAP + "\r\n", FOO_UNCAP }, { FOO_UNCAP + "\n", FOO_UNCAP }, { FOO_UNCAP + "\r", FOO_UNCAP }, { FOO_UNCAP + " \r", FOO_UNCAP + " " }, { FOO_UNCAP, FOO_UNCAP }, { FOO_UNCAP + "\n\n", FOO_UNCAP + "\n" }, { FOO_UNCAP + "\r\n\r\n", FOO_UNCAP + "\r\n" }, { "foo\nfoo", "foo\nfoo" }, { "foo\n\rfoo", "foo\n\rfoo" }, { "\n", "" }, { "\r", "" }, { "a", "a" }, { "\r\n", "" }, { "", "" }, { null, null }, { FOO_UNCAP + "\n\r", FOO_UNCAP + "\n" } }; 
     for (final String[] chompCase : chompCases) { 
         final String original = chompCase[0]; 
         final String expectedResult = chompCase[1]; 
         assertEquals("chomp(String) failed", expectedResult, StringUtils.chomp(original)); 
     } 
     assertEquals("chomp(String, String) failed", "foo", StringUtils.chomp("foobar", "bar")); 
     assertEquals("chomp(String, String) failed", "foobar", StringUtils.chomp("foobar", "baz")); 
     assertEquals("chomp(String, String) failed", "foo", StringUtils.chomp("foo", "foooo")); 
     assertEquals("chomp(String, String) failed", "foobar", StringUtils.chomp("foobar", "")); 
     assertEquals("chomp(String, String) failed", "foobar", StringUtils.chomp("foobar", null)); 
     assertEquals("chomp(String, String) failed", "", StringUtils.chomp("", "foo")); 
     assertEquals("chomp(String, String) failed", "", StringUtils.chomp("", null)); 
     assertEquals("chomp(String, String) failed", "", StringUtils.chomp("", "")); 
     assertEquals("chomp(String, String) failed", null, StringUtils.chomp(null, "foo")); 
     assertEquals("chomp(String, String) failed", null, StringUtils.chomp(null, null)); 
     assertEquals("chomp(String, String) failed", null, StringUtils.chomp(null, "")); 
     assertEquals("chomp(String, String) failed", "", StringUtils.chomp("foo", "foo")); 
     assertEquals("chomp(String, String) failed", " ", StringUtils.chomp(" foo", "foo")); 
     assertEquals("chomp(String, String) failed", "foo ", StringUtils.chomp("foo ", "foo")); 
 }
@Test
public void testDeleteWhitespace_String5856() { 
     assertEquals(null, StringUtils.deleteWhitespace(null)); 
     assertEquals("", StringUtils.deleteWhitespace("")); 
     assertEquals("", StringUtils.deleteWhitespace("  \u000C  \t\t\u001F\n\n \u000B  ")); 
     assertEquals("", StringUtils.deleteWhitespace(StringUtilsTest.WHITESPACE)); 
     assertEquals(StringUtilsTest.NON_WHITESPACE, StringUtils.deleteWhitespace(StringUtilsTest.NON_WHITESPACE)); 
     assertEquals("\u00A0\u202F", StringUtils.deleteWhitespace("  \u00A0  \t\t\n\n \u202F  ")); 
     assertEquals("\u00A0\u202F", StringUtils.deleteWhitespace("\u00A0\u202F")); 
     assertEquals("test", StringUtils.deleteWhitespace("\u000Bt  \t\n\u0009e\rs\n\n   \tt")); 
 }
@Test
public void testReplace_StringStringArrayStringArray5875() { 
     assertNull(StringUtils.replaceEach(null, new String[] { "a" }, new String[] { "b" })); 
     assertEquals(StringUtils.replaceEach("", new String[] { "a" }, new String[] { "b" }), ""); 
     assertEquals(StringUtils.replaceEach("aba", null, null), "aba"); 
     assertEquals(StringUtils.replaceEach("aba", new String[0], null), "aba"); 
     assertEquals(StringUtils.replaceEach("aba", null, new String[0]), "aba"); 
     assertEquals(StringUtils.replaceEach("aba", new String[] { "a" }, null), "aba"); 
     assertEquals(StringUtils.replaceEach("aba", new String[] { "a" }, new String[] { "" }), "b"); 
     assertEquals(StringUtils.replaceEach("aba", new String[] { null }, new String[] { "a" }), "aba"); 
     assertEquals(StringUtils.replaceEach("abcde", new String[] { "ab", "d" }, new String[] { "w", "t" }), "wcte"); 
     assertEquals(StringUtils.replaceEach("abcde", new String[] { "ab", "d" }, new String[] { "d", "t" }), "dcte"); 
     assertEquals("bcc", StringUtils.replaceEach("abc", new String[] { "a", "b" }, new String[] { "b", "c" })); 
     assertEquals("q651.506bera", StringUtils.replaceEach("d216.102oren", new String[] { "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "1", "2", "3", "4", "5", "6", "7", "8", "9" }, new String[] { "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z", "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "5", "6", "7", "8", "9", "1", "2", "3", "4" })); 
     assertEquals(StringUtils.replaceEach("aba", new String[] { "a" }, new String[] { null }), "aba"); 
     assertEquals(StringUtils.replaceEach("aba", new String[] { "a", "b" }, new String[] { "c", null }), "cbc"); 
 }
@Test
public void testOverlay_StringStringIntInt5876() { 
     assertEquals(null, StringUtils.overlay(null, null, 2, 4)); 
     assertEquals(null, StringUtils.overlay(null, null, -2, -4)); 
     assertEquals("", StringUtils.overlay("", null, 0, 0)); 
     assertEquals("", StringUtils.overlay("", "", 0, 0)); 
     assertEquals("zzzz", StringUtils.overlay("", "zzzz", 0, 0)); 
     assertEquals("zzzz", StringUtils.overlay("", "zzzz", 2, 4)); 
     assertEquals("zzzz", StringUtils.overlay("", "zzzz", -2, -4)); 
     assertEquals("abef", StringUtils.overlay("abcdef", null, 2, 4)); 
     assertEquals("abef", StringUtils.overlay("abcdef", null, 4, 2)); 
     assertEquals("abef", StringUtils.overlay("abcdef", "", 2, 4)); 
     assertEquals("abef", StringUtils.overlay("abcdef", "", 4, 2)); 
     assertEquals("abzzzzef", StringUtils.overlay("abcdef", "zzzz", 2, 4)); 
     assertEquals("abzzzzef", StringUtils.overlay("abcdef", "zzzz", 4, 2)); 
     assertEquals("zzzzef", StringUtils.overlay("abcdef", "zzzz", -1, 4)); 
     assertEquals("zzzzef", StringUtils.overlay("abcdef", "zzzz", 4, -1)); 
     assertEquals("zzzzabcdef", StringUtils.overlay("abcdef", "zzzz", -2, -1)); 
     assertEquals("zzzzabcdef", StringUtils.overlay("abcdef", "zzzz", -1, -2)); 
     assertEquals("abcdzzzz", StringUtils.overlay("abcdef", "zzzz", 4, 10)); 
     assertEquals("abcdzzzz", StringUtils.overlay("abcdef", "zzzz", 10, 4)); 
     assertEquals("abcdefzzzz", StringUtils.overlay("abcdef", "zzzz", 8, 10)); 
     assertEquals("abcdefzzzz", StringUtils.overlay("abcdef", "zzzz", 10, 8)); 
 }
@Test
public void testDifferenceAt_StringString5879() { 
     assertEquals(-1, StringUtils.indexOfDifference(null, null)); 
     assertEquals(0, StringUtils.indexOfDifference(null, "i am a robot")); 
     assertEquals(-1, StringUtils.indexOfDifference("", "")); 
     assertEquals(0, StringUtils.indexOfDifference("", "abc")); 
     assertEquals(0, StringUtils.indexOfDifference("abc", "")); 
     assertEquals(0, StringUtils.indexOfDifference("i am a machine", null)); 
     assertEquals(7, StringUtils.indexOfDifference("i am a machine", "i am a robot")); 
     assertEquals(-1, StringUtils.indexOfDifference("foo", "foo")); 
     assertEquals(0, StringUtils.indexOfDifference("i am a robot", "you are a robot")); 
 }
@Test
public void testReplaceChars_StringCharChar5912() { 
     assertEquals(null, StringUtils.replaceChars(null, 'b', 'z')); 
     assertEquals("", StringUtils.replaceChars("", 'b', 'z')); 
     assertEquals("azcza", StringUtils.replaceChars("abcba", 'b', 'z')); 
     assertEquals("abcba", StringUtils.replaceChars("abcba", 'x', 'z')); 
 }
@Test
public void testGetCommonPrefix_StringArray5934() { 
     assertEquals("", StringUtils.getCommonPrefix((String[]) null)); 
     assertEquals("", StringUtils.getCommonPrefix()); 
     assertEquals("abc", StringUtils.getCommonPrefix("abc")); 
     assertEquals("", StringUtils.getCommonPrefix(null, null)); 
     assertEquals("", StringUtils.getCommonPrefix("", "")); 
     assertEquals("", StringUtils.getCommonPrefix("", null)); 
     assertEquals("", StringUtils.getCommonPrefix("abc", null, null)); 
     assertEquals("", StringUtils.getCommonPrefix(null, null, "abc")); 
     assertEquals("", StringUtils.getCommonPrefix("", "abc")); 
     assertEquals("", StringUtils.getCommonPrefix("abc", "")); 
     assertEquals("abc", StringUtils.getCommonPrefix("abc", "abc")); 
     assertEquals("a", StringUtils.getCommonPrefix("abc", "a")); 
     assertEquals("ab", StringUtils.getCommonPrefix("ab", "abxyz")); 
     assertEquals("ab", StringUtils.getCommonPrefix("abcde", "abxyz")); 
     assertEquals("", StringUtils.getCommonPrefix("abcde", "xyz")); 
     assertEquals("", StringUtils.getCommonPrefix("xyz", "abcde")); 
     assertEquals("i am a ", StringUtils.getCommonPrefix("i am a machine", "i am a robot")); 
 }
@Test
public void testEscapeSurrogatePairs5938() throws Exception { 
     assertEquals("\uD83D\uDE30", StringEscapeUtils.escapeCsv("\uD83D\uDE30")); 
     assertEquals("\uD800\uDC00", StringEscapeUtils.escapeCsv("\uD800\uDC00")); 
     assertEquals("\uD834\uDD1E", StringEscapeUtils.escapeCsv("\uD834\uDD1E")); 
     assertEquals("\uDBFF\uDFFD", StringEscapeUtils.escapeCsv("\uDBFF\uDFFD")); 
     assertEquals("\uDBFF\uDFFD", StringEscapeUtils.escapeHtml3("\uDBFF\uDFFD")); 
     assertEquals("\uDBFF\uDFFD", StringEscapeUtils.escapeHtml4("\uDBFF\uDFFD")); 
     assertEquals("\uDBFF\uDFFD", StringEscapeUtils.escapeXml("\uDBFF\uDFFD")); 
 }
@Test
public void testJoin_ArrayOfBytes5967() { 
     assertEquals(null, StringUtils.join((byte[]) null, ',')); 
     assertEquals("1;2", StringUtils.join(BYTE_PRIM_LIST, SEPARATOR_CHAR)); 
     assertEquals("2", StringUtils.join(BYTE_PRIM_LIST, SEPARATOR_CHAR, 1, 2)); 
 }
@Test
public void testReplaceChars_StringStringString5998() { 
     assertEquals(null, StringUtils.replaceChars(null, null, null)); 
     assertEquals(null, StringUtils.replaceChars(null, "", null)); 
     assertEquals(null, StringUtils.replaceChars(null, "a", null)); 
     assertEquals(null, StringUtils.replaceChars(null, null, "")); 
     assertEquals(null, StringUtils.replaceChars(null, null, "x")); 
     assertEquals("", StringUtils.replaceChars("", null, null)); 
     assertEquals("", StringUtils.replaceChars("", "", null)); 
     assertEquals("", StringUtils.replaceChars("", "a", null)); 
     assertEquals("", StringUtils.replaceChars("", null, "")); 
     assertEquals("", StringUtils.replaceChars("", null, "x")); 
     assertEquals("abc", StringUtils.replaceChars("abc", null, null)); 
     assertEquals("abc", StringUtils.replaceChars("abc", null, "")); 
     assertEquals("abc", StringUtils.replaceChars("abc", null, "x")); 
     assertEquals("abc", StringUtils.replaceChars("abc", "", null)); 
     assertEquals("abc", StringUtils.replaceChars("abc", "", "")); 
     assertEquals("abc", StringUtils.replaceChars("abc", "", "x")); 
     assertEquals("ac", StringUtils.replaceChars("abc", "b", null)); 
     assertEquals("ac", StringUtils.replaceChars("abc", "b", "")); 
     assertEquals("axc", StringUtils.replaceChars("abc", "b", "x")); 
     assertEquals("ayzya", StringUtils.replaceChars("abcba", "bc", "yz")); 
     assertEquals("ayya", StringUtils.replaceChars("abcba", "bc", "y")); 
     assertEquals("ayzya", StringUtils.replaceChars("abcba", "bc", "yzx")); 
     assertEquals("abcba", StringUtils.replaceChars("abcba", "z", "w")); 
     assertSame("abcba", StringUtils.replaceChars("abcba", "z", "w")); 
     assertEquals("jelly", StringUtils.replaceChars("hello", "ho", "jy")); 
     assertEquals("ayzya", StringUtils.replaceChars("abcba", "bc", "yz")); 
     assertEquals("ayya", StringUtils.replaceChars("abcba", "bc", "y")); 
     assertEquals("ayzya", StringUtils.replaceChars("abcba", "bc", "yzx")); 
     assertEquals("bcc", StringUtils.replaceChars("abc", "ab", "bc")); 
     assertEquals("q651.506bera", StringUtils.replaceChars("d216.102oren", "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ123456789", "nopqrstuvwxyzabcdefghijklmNOPQRSTUVWXYZABCDEFGHIJKLM567891234")); 
 }
@Test
public void testRepeat_StringStringInt6014() { 
     assertEquals(null, StringUtils.repeat(null, null, 2)); 
     assertEquals(null, StringUtils.repeat(null, "x", 2)); 
     assertEquals("", StringUtils.repeat("", null, 2)); 
     assertEquals("", StringUtils.repeat("ab", "", 0)); 
     assertEquals("", StringUtils.repeat("", "", 2)); 
     assertEquals("xx", StringUtils.repeat("", "x", 3)); 
     assertEquals("?, ?, ?", StringUtils.repeat("?", ", ", 3)); 
 }
@Test
public void testRepeat_StringInt6023() { 
     assertEquals(null, StringUtils.repeat(null, 2)); 
     assertEquals("", StringUtils.repeat("ab", 0)); 
     assertEquals("", StringUtils.repeat("", 3)); 
     assertEquals("aaa", StringUtils.repeat("a", 3)); 
     assertEquals("ababab", StringUtils.repeat("ab", 3)); 
     assertEquals("abcabcabc", StringUtils.repeat("abc", 3)); 
     final String str = StringUtils.repeat("a", 10000); 
     assertEquals(10000, str.length()); 
     assertTrue(StringUtils.containsOnly(str, new char[] { 'a' })); 
 }
@Test
public void testGetCommonPrefix_StringArray6045() { 
     assertEquals("", StringUtils.getCommonPrefix((String[]) null)); 
     assertEquals("", StringUtils.getCommonPrefix()); 
     assertEquals("abc", StringUtils.getCommonPrefix("abc")); 
     assertEquals("", StringUtils.getCommonPrefix(null, null)); 
     assertEquals("", StringUtils.getCommonPrefix("", "")); 
     assertEquals("", StringUtils.getCommonPrefix("", null)); 
     assertEquals("", StringUtils.getCommonPrefix("abc", null, null)); 
     assertEquals("", StringUtils.getCommonPrefix(null, null, "abc")); 
     assertEquals("", StringUtils.getCommonPrefix("", "abc")); 
     assertEquals("", StringUtils.getCommonPrefix("abc", "")); 
     assertEquals("abc", StringUtils.getCommonPrefix("abc", "abc")); 
     assertEquals("a", StringUtils.getCommonPrefix("abc", "a")); 
     assertEquals("ab", StringUtils.getCommonPrefix("ab", "abxyz")); 
     assertEquals("ab", StringUtils.getCommonPrefix("abcde", "abxyz")); 
     assertEquals("", StringUtils.getCommonPrefix("abcde", "xyz")); 
     assertEquals("", StringUtils.getCommonPrefix("xyz", "abcde")); 
     assertEquals("i am a ", StringUtils.getCommonPrefix("i am a machine", "i am a robot")); 
 }
@Test
public void testUnescapeSurrogatePairs6050() throws Exception { 
     assertEquals("\uD83D\uDE30", StringEscapeUtils.unescapeCsv("\uD83D\uDE30")); 
     assertEquals("\uD800\uDC00", StringEscapeUtils.unescapeCsv("\uD800\uDC00")); 
     assertEquals("\uD834\uDD1E", StringEscapeUtils.unescapeCsv("\uD834\uDD1E")); 
     assertEquals("\uDBFF\uDFFD", StringEscapeUtils.unescapeCsv("\uDBFF\uDFFD")); 
     assertEquals("\uDBFF\uDFFD", StringEscapeUtils.unescapeHtml3("\uDBFF\uDFFD")); 
     assertEquals("\uDBFF\uDFFD", StringEscapeUtils.unescapeHtml4("\uDBFF\uDFFD")); 
 }
@Test
public void testRemoveStartIgnoreCase6062() { 
     assertNull("removeStartIgnoreCase(null, null)", StringUtils.removeStartIgnoreCase(null, null)); 
     assertNull("removeStartIgnoreCase(null, \"\")", StringUtils.removeStartIgnoreCase(null, "")); 
     assertNull("removeStartIgnoreCase(null, \"a\")", StringUtils.removeStartIgnoreCase(null, "a")); 
     assertEquals("removeStartIgnoreCase(\"\", null)", StringUtils.removeStartIgnoreCase("", null), ""); 
     assertEquals("removeStartIgnoreCase(\"\", \"\")", StringUtils.removeStartIgnoreCase("", ""), ""); 
     assertEquals("removeStartIgnoreCase(\"\", \"a\")", StringUtils.removeStartIgnoreCase("", "a"), ""); 
     assertEquals("removeStartIgnoreCase(\"www.domain.com\", \"www.\")", StringUtils.removeStartIgnoreCase("www.domain.com", "www."), "domain.com"); 
     assertEquals("removeStartIgnoreCase(\"domain.com\", \"www.\")", StringUtils.removeStartIgnoreCase("domain.com", "www."), "domain.com"); 
     assertEquals("removeStartIgnoreCase(\"domain.com\", \"\")", StringUtils.removeStartIgnoreCase("domain.com", ""), "domain.com"); 
     assertEquals("removeStartIgnoreCase(\"domain.com\", null)", StringUtils.removeStartIgnoreCase("domain.com", null), "domain.com"); 
     assertEquals("removeStartIgnoreCase(\"www.domain.com\", \"WWW.\")", StringUtils.removeStartIgnoreCase("www.domain.com", "WWW."), "domain.com"); 
 }
@Test
public void testSplitByCharacterType6064() { 
     assertNull(StringUtils.splitByCharacterType(null)); 
     assertEquals(0, StringUtils.splitByCharacterType("").length); 
     assertTrue(ArrayUtils.isEquals(new String[] { "ab", " ", "de", " ", "fg" }, StringUtils.splitByCharacterType("ab de fg"))); 
     assertTrue(ArrayUtils.isEquals(new String[] { "ab", "   ", "de", " ", "fg" }, StringUtils.splitByCharacterType("ab   de fg"))); 
     assertTrue(ArrayUtils.isEquals(new String[] { "ab", ":", "cd", ":", "ef" }, StringUtils.splitByCharacterType("ab:cd:ef"))); 
     assertTrue(ArrayUtils.isEquals(new String[] { "number", "5" }, StringUtils.splitByCharacterType("number5"))); 
     assertTrue(ArrayUtils.isEquals(new String[] { "foo", "B", "ar" }, StringUtils.splitByCharacterType("fooBar"))); 
     assertTrue(ArrayUtils.isEquals(new String[] { "foo", "200", "B", "ar" }, StringUtils.splitByCharacterType("foo200Bar"))); 
     assertTrue(ArrayUtils.isEquals(new String[] { "ASFR", "ules" }, StringUtils.splitByCharacterType("ASFRules"))); 
 }
@Test
public void testRemoveEndIgnoreCase6070() { 
     assertNull("removeEndIgnoreCase(null, null)", StringUtils.removeEndIgnoreCase(null, null)); 
     assertNull("removeEndIgnoreCase(null, \"\")", StringUtils.removeEndIgnoreCase(null, "")); 
     assertNull("removeEndIgnoreCase(null, \"a\")", StringUtils.removeEndIgnoreCase(null, "a")); 
     assertEquals("removeEndIgnoreCase(\"\", null)", StringUtils.removeEndIgnoreCase("", null), ""); 
     assertEquals("removeEndIgnoreCase(\"\", \"\")", StringUtils.removeEndIgnoreCase("", ""), ""); 
     assertEquals("removeEndIgnoreCase(\"\", \"a\")", StringUtils.removeEndIgnoreCase("", "a"), ""); 
     assertEquals("removeEndIgnoreCase(\"www.domain.com.\", \".com\")", StringUtils.removeEndIgnoreCase("www.domain.com.", ".com"), "www.domain.com."); 
     assertEquals("removeEndIgnoreCase(\"www.domain.com\", \".com\")", StringUtils.removeEndIgnoreCase("www.domain.com", ".com"), "www.domain"); 
     assertEquals("removeEndIgnoreCase(\"www.domain\", \".com\")", StringUtils.removeEndIgnoreCase("www.domain", ".com"), "www.domain"); 
     assertEquals("removeEndIgnoreCase(\"domain.com\", \"\")", StringUtils.removeEndIgnoreCase("domain.com", ""), "domain.com"); 
     assertEquals("removeEndIgnoreCase(\"domain.com\", null)", StringUtils.removeEndIgnoreCase("domain.com", null), "domain.com"); 
     assertEquals("removeEndIgnoreCase(\"www.domain.com\", \".COM\")", StringUtils.removeEndIgnoreCase("www.domain.com", ".COM"), "www.domain"); 
     assertEquals("removeEndIgnoreCase(\"www.domain.COM\", \".com\")", StringUtils.removeEndIgnoreCase("www.domain.COM", ".com"), "www.domain"); 
 }
@Test
public void testReplaceChars_StringStringString6081() { 
     assertEquals(null, StringUtils.replaceChars(null, null, null)); 
     assertEquals(null, StringUtils.replaceChars(null, "", null)); 
     assertEquals(null, StringUtils.replaceChars(null, "a", null)); 
     assertEquals(null, StringUtils.replaceChars(null, null, "")); 
     assertEquals(null, StringUtils.replaceChars(null, null, "x")); 
     assertEquals("", StringUtils.replaceChars("", null, null)); 
     assertEquals("", StringUtils.replaceChars("", "", null)); 
     assertEquals("", StringUtils.replaceChars("", "a", null)); 
     assertEquals("", StringUtils.replaceChars("", null, "")); 
     assertEquals("", StringUtils.replaceChars("", null, "x")); 
     assertEquals("abc", StringUtils.replaceChars("abc", null, null)); 
     assertEquals("abc", StringUtils.replaceChars("abc", null, "")); 
     assertEquals("abc", StringUtils.replaceChars("abc", null, "x")); 
     assertEquals("abc", StringUtils.replaceChars("abc", "", null)); 
     assertEquals("abc", StringUtils.replaceChars("abc", "", "")); 
     assertEquals("abc", StringUtils.replaceChars("abc", "", "x")); 
     assertEquals("ac", StringUtils.replaceChars("abc", "b", null)); 
     assertEquals("ac", StringUtils.replaceChars("abc", "b", "")); 
     assertEquals("axc", StringUtils.replaceChars("abc", "b", "x")); 
     assertEquals("ayzya", StringUtils.replaceChars("abcba", "bc", "yz")); 
     assertEquals("ayya", StringUtils.replaceChars("abcba", "bc", "y")); 
     assertEquals("ayzya", StringUtils.replaceChars("abcba", "bc", "yzx")); 
     assertEquals("abcba", StringUtils.replaceChars("abcba", "z", "w")); 
     assertSame("abcba", StringUtils.replaceChars("abcba", "z", "w")); 
     assertEquals("jelly", StringUtils.replaceChars("hello", "ho", "jy")); 
     assertEquals("ayzya", StringUtils.replaceChars("abcba", "bc", "yz")); 
     assertEquals("ayya", StringUtils.replaceChars("abcba", "bc", "y")); 
     assertEquals("ayzya", StringUtils.replaceChars("abcba", "bc", "yzx")); 
     assertEquals("bcc", StringUtils.replaceChars("abc", "ab", "bc")); 
     assertEquals("q651.506bera", StringUtils.replaceChars("d216.102oren", "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ123456789", "nopqrstuvwxyzabcdefghijklmNOPQRSTUVWXYZABCDEFGHIJKLM567891234")); 
 }
@Test
public void testJoin_ArrayCharSeparator6098() { 
     assertEquals(null, StringUtils.join((Object[]) null, ',')); 
     assertEquals(TEXT_LIST_CHAR, StringUtils.join(ARRAY_LIST, SEPARATOR_CHAR)); 
     assertEquals("", StringUtils.join(EMPTY_ARRAY_LIST, SEPARATOR_CHAR)); 
     assertEquals(";;foo", StringUtils.join(MIXED_ARRAY_LIST, SEPARATOR_CHAR)); 
     assertEquals("foo;2", StringUtils.join(MIXED_TYPE_LIST, SEPARATOR_CHAR)); 
     assertEquals("/", StringUtils.join(MIXED_ARRAY_LIST, '/', 0, MIXED_ARRAY_LIST.length - 1)); 
     assertEquals("foo", StringUtils.join(MIXED_TYPE_LIST, '/', 0, 1)); 
     assertEquals("null", StringUtils.join(NULL_TO_STRING_LIST, '/', 0, 1)); 
     assertEquals("foo/2", StringUtils.join(MIXED_TYPE_LIST, '/', 0, 2)); 
     assertEquals("2", StringUtils.join(MIXED_TYPE_LIST, '/', 1, 2)); 
     assertEquals("", StringUtils.join(MIXED_TYPE_LIST, '/', 2, 1)); 
 }
@Test
public void testGetLevenshteinDistance_StringStringInt6107() { 
     assertEquals(0, StringUtils.getLevenshteinDistance("", "", 0)); 
     assertEquals(7, StringUtils.getLevenshteinDistance("aaapppp", "", 8)); 
     assertEquals(7, StringUtils.getLevenshteinDistance("aaapppp", "", 7)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("aaapppp", "", 6)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("b", "a", 0)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("a", "b", 0)); 
     assertEquals(0, StringUtils.getLevenshteinDistance("aa", "aa", 0)); 
     assertEquals(0, StringUtils.getLevenshteinDistance("aa", "aa", 2)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("aaa", "bbb", 2)); 
     assertEquals(3, StringUtils.getLevenshteinDistance("aaa", "bbb", 3)); 
     assertEquals(6, StringUtils.getLevenshteinDistance("aaaaaa", "b", 10)); 
     assertEquals(7, StringUtils.getLevenshteinDistance("aaapppp", "b", 8)); 
     assertEquals(3, StringUtils.getLevenshteinDistance("a", "bbb", 4)); 
     assertEquals(7, StringUtils.getLevenshteinDistance("aaapppp", "b", 7)); 
     assertEquals(3, StringUtils.getLevenshteinDistance("a", "bbb", 3)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("a", "bbb", 2)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("bbb", "a", 2)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("aaapppp", "b", 6)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("a", "bbb", 1)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("bbb", "a", 1)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("12345", "1234567", 1)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("1234567", "12345", 1)); 
     assertEquals(1, StringUtils.getLevenshteinDistance("frog", "fog", 1)); 
     assertEquals(3, StringUtils.getLevenshteinDistance("fly", "ant", 3)); 
     assertEquals(7, StringUtils.getLevenshteinDistance("elephant", "hippo", 7)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("elephant", "hippo", 6)); 
     assertEquals(7, StringUtils.getLevenshteinDistance("hippo", "elephant", 7)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("hippo", "elephant", 6)); 
     assertEquals(8, StringUtils.getLevenshteinDistance("hippo", "zzzzzzzz", 8)); 
     assertEquals(8, StringUtils.getLevenshteinDistance("zzzzzzzz", "hippo", 8)); 
     assertEquals(1, StringUtils.getLevenshteinDistance("hello", "hallo", 1)); 
     try { 
         @SuppressWarnings("unused") 
         final int d = StringUtils.getLevenshteinDistance("a", null, 0); 
         fail("expecting IllegalArgumentException"); 
     } catch (final IllegalArgumentException ex) { 
     } 
     try { 
         @SuppressWarnings("unused") 
         final int d = StringUtils.getLevenshteinDistance(null, "a", 0); 
         fail("expecting IllegalArgumentException"); 
     } catch (final IllegalArgumentException ex) { 
     } 
     try { 
         @SuppressWarnings("unused") 
         final int d = StringUtils.getLevenshteinDistance("a", "a", -1); 
         fail("expecting IllegalArgumentException"); 
     } catch (final IllegalArgumentException ex) { 
     } 
 }
@Test
public void testJoin_ArrayCharSeparator6109() { 
     assertEquals(null, StringUtils.join((Object[]) null, ',')); 
     assertEquals(TEXT_LIST_CHAR, StringUtils.join(ARRAY_LIST, SEPARATOR_CHAR)); 
     assertEquals("", StringUtils.join(EMPTY_ARRAY_LIST, SEPARATOR_CHAR)); 
     assertEquals(";;foo", StringUtils.join(MIXED_ARRAY_LIST, SEPARATOR_CHAR)); 
     assertEquals("foo;2", StringUtils.join(MIXED_TYPE_LIST, SEPARATOR_CHAR)); 
     assertEquals("/", StringUtils.join(MIXED_ARRAY_LIST, '/', 0, MIXED_ARRAY_LIST.length - 1)); 
     assertEquals("foo", StringUtils.join(MIXED_TYPE_LIST, '/', 0, 1)); 
     assertEquals("null", StringUtils.join(NULL_TO_STRING_LIST, '/', 0, 1)); 
     assertEquals("foo/2", StringUtils.join(MIXED_TYPE_LIST, '/', 0, 2)); 
     assertEquals("2", StringUtils.join(MIXED_TYPE_LIST, '/', 1, 2)); 
     assertEquals("", StringUtils.join(MIXED_TYPE_LIST, '/', 2, 1)); 
 }
@Test
public void testGetLevenshteinDistance_StringStringInt6125() { 
     assertEquals(0, StringUtils.getLevenshteinDistance("", "", 0)); 
     assertEquals(7, StringUtils.getLevenshteinDistance("aaapppp", "", 8)); 
     assertEquals(7, StringUtils.getLevenshteinDistance("aaapppp", "", 7)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("aaapppp", "", 6)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("b", "a", 0)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("a", "b", 0)); 
     assertEquals(0, StringUtils.getLevenshteinDistance("aa", "aa", 0)); 
     assertEquals(0, StringUtils.getLevenshteinDistance("aa", "aa", 2)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("aaa", "bbb", 2)); 
     assertEquals(3, StringUtils.getLevenshteinDistance("aaa", "bbb", 3)); 
     assertEquals(6, StringUtils.getLevenshteinDistance("aaaaaa", "b", 10)); 
     assertEquals(7, StringUtils.getLevenshteinDistance("aaapppp", "b", 8)); 
     assertEquals(3, StringUtils.getLevenshteinDistance("a", "bbb", 4)); 
     assertEquals(7, StringUtils.getLevenshteinDistance("aaapppp", "b", 7)); 
     assertEquals(3, StringUtils.getLevenshteinDistance("a", "bbb", 3)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("a", "bbb", 2)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("bbb", "a", 2)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("aaapppp", "b", 6)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("a", "bbb", 1)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("bbb", "a", 1)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("12345", "1234567", 1)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("1234567", "12345", 1)); 
     assertEquals(1, StringUtils.getLevenshteinDistance("frog", "fog", 1)); 
     assertEquals(3, StringUtils.getLevenshteinDistance("fly", "ant", 3)); 
     assertEquals(7, StringUtils.getLevenshteinDistance("elephant", "hippo", 7)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("elephant", "hippo", 6)); 
     assertEquals(7, StringUtils.getLevenshteinDistance("hippo", "elephant", 7)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("hippo", "elephant", 6)); 
     assertEquals(8, StringUtils.getLevenshteinDistance("hippo", "zzzzzzzz", 8)); 
     assertEquals(8, StringUtils.getLevenshteinDistance("zzzzzzzz", "hippo", 8)); 
     assertEquals(1, StringUtils.getLevenshteinDistance("hello", "hallo", 1)); 
     try { 
         @SuppressWarnings("unused") 
         final int d = StringUtils.getLevenshteinDistance("a", null, 0); 
         fail("expecting IllegalArgumentException"); 
     } catch (final IllegalArgumentException ex) { 
     } 
     try { 
         @SuppressWarnings("unused") 
         final int d = StringUtils.getLevenshteinDistance(null, "a", 0); 
         fail("expecting IllegalArgumentException"); 
     } catch (final IllegalArgumentException ex) { 
     } 
     try { 
         @SuppressWarnings("unused") 
         final int d = StringUtils.getLevenshteinDistance("a", "a", -1); 
         fail("expecting IllegalArgumentException"); 
     } catch (final IllegalArgumentException ex) { 
     } 
 }
@Test
public void testRepeat_StringInt6160() { 
     assertEquals(null, StringUtils.repeat(null, 2)); 
     assertEquals("", StringUtils.repeat("ab", 0)); 
     assertEquals("", StringUtils.repeat("", 3)); 
     assertEquals("aaa", StringUtils.repeat("a", 3)); 
     assertEquals("ababab", StringUtils.repeat("ab", 3)); 
     assertEquals("abcabcabc", StringUtils.repeat("abc", 3)); 
     final String str = StringUtils.repeat("a", 10000); 
     assertEquals(10000, str.length()); 
     assertTrue(StringUtils.containsOnly(str, new char[] { 'a' })); 
 }
@Test
public void testRepeat_StringInt6170() { 
     assertEquals(null, StringUtils.repeat(null, 2)); 
     assertEquals("", StringUtils.repeat("ab", 0)); 
     assertEquals("", StringUtils.repeat("", 3)); 
     assertEquals("aaa", StringUtils.repeat("a", 3)); 
     assertEquals("ababab", StringUtils.repeat("ab", 3)); 
     assertEquals("abcabcabc", StringUtils.repeat("abc", 3)); 
     final String str = StringUtils.repeat("a", 10000); 
     assertEquals(10000, str.length()); 
     assertTrue(StringUtils.containsOnly(str, new char[] { 'a' })); 
 }
@Test
public void testSwapCase_String6173() { 
     assertEquals(null, StringUtils.swapCase(null)); 
     assertEquals("", StringUtils.swapCase("")); 
     assertEquals("  ", StringUtils.swapCase("  ")); 
     assertEquals("i", WordUtils.swapCase("I")); 
     assertEquals("I", WordUtils.swapCase("i")); 
     assertEquals("I AM HERE 123", StringUtils.swapCase("i am here 123")); 
     assertEquals("i aM hERE 123", StringUtils.swapCase("I Am Here 123")); 
     assertEquals("I AM here 123", StringUtils.swapCase("i am HERE 123")); 
     assertEquals("i am here 123", StringUtils.swapCase("I AM HERE 123")); 
     final String test = "This String contains a TitleCase character: \u01C8"; 
     final String expect = "tHIS sTRING CONTAINS A tITLEcASE CHARACTER: \u01C9"; 
     assertEquals(expect, WordUtils.swapCase(test)); 
 }
@Test
public void testDifference_StringString6194() { 
     assertEquals(null, StringUtils.difference(null, null)); 
     assertEquals("", StringUtils.difference("", "")); 
     assertEquals("abc", StringUtils.difference("", "abc")); 
     assertEquals("", StringUtils.difference("abc", "")); 
     assertEquals("i am a robot", StringUtils.difference(null, "i am a robot")); 
     assertEquals("i am a machine", StringUtils.difference("i am a machine", null)); 
     assertEquals("robot", StringUtils.difference("i am a machine", "i am a robot")); 
     assertEquals("", StringUtils.difference("abc", "abc")); 
     assertEquals("you are a robot", StringUtils.difference("i am a robot", "you are a robot")); 
 }
@Test
public void testOverlay_StringStringIntInt6199() { 
     assertEquals(null, StringUtils.overlay(null, null, 2, 4)); 
     assertEquals(null, StringUtils.overlay(null, null, -2, -4)); 
     assertEquals("", StringUtils.overlay("", null, 0, 0)); 
     assertEquals("", StringUtils.overlay("", "", 0, 0)); 
     assertEquals("zzzz", StringUtils.overlay("", "zzzz", 0, 0)); 
     assertEquals("zzzz", StringUtils.overlay("", "zzzz", 2, 4)); 
     assertEquals("zzzz", StringUtils.overlay("", "zzzz", -2, -4)); 
     assertEquals("abef", StringUtils.overlay("abcdef", null, 2, 4)); 
     assertEquals("abef", StringUtils.overlay("abcdef", null, 4, 2)); 
     assertEquals("abef", StringUtils.overlay("abcdef", "", 2, 4)); 
     assertEquals("abef", StringUtils.overlay("abcdef", "", 4, 2)); 
     assertEquals("abzzzzef", StringUtils.overlay("abcdef", "zzzz", 2, 4)); 
     assertEquals("abzzzzef", StringUtils.overlay("abcdef", "zzzz", 4, 2)); 
     assertEquals("zzzzef", StringUtils.overlay("abcdef", "zzzz", -1, 4)); 
     assertEquals("zzzzef", StringUtils.overlay("abcdef", "zzzz", 4, -1)); 
     assertEquals("zzzzabcdef", StringUtils.overlay("abcdef", "zzzz", -2, -1)); 
     assertEquals("zzzzabcdef", StringUtils.overlay("abcdef", "zzzz", -1, -2)); 
     assertEquals("abcdzzzz", StringUtils.overlay("abcdef", "zzzz", 4, 10)); 
     assertEquals("abcdzzzz", StringUtils.overlay("abcdef", "zzzz", 10, 4)); 
     assertEquals("abcdefzzzz", StringUtils.overlay("abcdef", "zzzz", 8, 10)); 
     assertEquals("abcdefzzzz", StringUtils.overlay("abcdef", "zzzz", 10, 8)); 
 }
@Test
public void testGetLevenshteinDistance_StringStringInt6228() { 
     assertEquals(0, StringUtils.getLevenshteinDistance("", "", 0)); 
     assertEquals(7, StringUtils.getLevenshteinDistance("aaapppp", "", 8)); 
     assertEquals(7, StringUtils.getLevenshteinDistance("aaapppp", "", 7)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("aaapppp", "", 6)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("b", "a", 0)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("a", "b", 0)); 
     assertEquals(0, StringUtils.getLevenshteinDistance("aa", "aa", 0)); 
     assertEquals(0, StringUtils.getLevenshteinDistance("aa", "aa", 2)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("aaa", "bbb", 2)); 
     assertEquals(3, StringUtils.getLevenshteinDistance("aaa", "bbb", 3)); 
     assertEquals(6, StringUtils.getLevenshteinDistance("aaaaaa", "b", 10)); 
     assertEquals(7, StringUtils.getLevenshteinDistance("aaapppp", "b", 8)); 
     assertEquals(3, StringUtils.getLevenshteinDistance("a", "bbb", 4)); 
     assertEquals(7, StringUtils.getLevenshteinDistance("aaapppp", "b", 7)); 
     assertEquals(3, StringUtils.getLevenshteinDistance("a", "bbb", 3)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("a", "bbb", 2)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("bbb", "a", 2)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("aaapppp", "b", 6)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("a", "bbb", 1)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("bbb", "a", 1)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("12345", "1234567", 1)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("1234567", "12345", 1)); 
     assertEquals(1, StringUtils.getLevenshteinDistance("frog", "fog", 1)); 
     assertEquals(3, StringUtils.getLevenshteinDistance("fly", "ant", 3)); 
     assertEquals(7, StringUtils.getLevenshteinDistance("elephant", "hippo", 7)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("elephant", "hippo", 6)); 
     assertEquals(7, StringUtils.getLevenshteinDistance("hippo", "elephant", 7)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("hippo", "elephant", 6)); 
     assertEquals(8, StringUtils.getLevenshteinDistance("hippo", "zzzzzzzz", 8)); 
     assertEquals(8, StringUtils.getLevenshteinDistance("zzzzzzzz", "hippo", 8)); 
     assertEquals(1, StringUtils.getLevenshteinDistance("hello", "hallo", 1)); 
     try { 
         @SuppressWarnings("unused") 
         final int d = StringUtils.getLevenshteinDistance("a", null, 0); 
         fail("expecting IllegalArgumentException"); 
     } catch (final IllegalArgumentException ex) { 
     } 
     try { 
         @SuppressWarnings("unused") 
         final int d = StringUtils.getLevenshteinDistance(null, "a", 0); 
         fail("expecting IllegalArgumentException"); 
     } catch (final IllegalArgumentException ex) { 
     } 
     try { 
         @SuppressWarnings("unused") 
         final int d = StringUtils.getLevenshteinDistance("a", "a", -1); 
         fail("expecting IllegalArgumentException"); 
     } catch (final IllegalArgumentException ex) { 
     } 
 }
@Test
public void testReplace_StringStringArrayStringArray6243() { 
     assertNull(StringUtils.replaceEach(null, new String[] { "a" }, new String[] { "b" })); 
     assertEquals(StringUtils.replaceEach("", new String[] { "a" }, new String[] { "b" }), ""); 
     assertEquals(StringUtils.replaceEach("aba", null, null), "aba"); 
     assertEquals(StringUtils.replaceEach("aba", new String[0], null), "aba"); 
     assertEquals(StringUtils.replaceEach("aba", null, new String[0]), "aba"); 
     assertEquals(StringUtils.replaceEach("aba", new String[] { "a" }, null), "aba"); 
     assertEquals(StringUtils.replaceEach("aba", new String[] { "a" }, new String[] { "" }), "b"); 
     assertEquals(StringUtils.replaceEach("aba", new String[] { null }, new String[] { "a" }), "aba"); 
     assertEquals(StringUtils.replaceEach("abcde", new String[] { "ab", "d" }, new String[] { "w", "t" }), "wcte"); 
     assertEquals(StringUtils.replaceEach("abcde", new String[] { "ab", "d" }, new String[] { "d", "t" }), "dcte"); 
     assertEquals("bcc", StringUtils.replaceEach("abc", new String[] { "a", "b" }, new String[] { "b", "c" })); 
     assertEquals("q651.506bera", StringUtils.replaceEach("d216.102oren", new String[] { "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "1", "2", "3", "4", "5", "6", "7", "8", "9" }, new String[] { "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z", "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "5", "6", "7", "8", "9", "1", "2", "3", "4" })); 
     assertEquals(StringUtils.replaceEach("aba", new String[] { "a" }, new String[] { null }), "aba"); 
     assertEquals(StringUtils.replaceEach("aba", new String[] { "a", "b" }, new String[] { "c", null }), "cbc"); 
 }
@Test
public void testReplacePattern6250() { 
     assertEquals("X", StringUtils.replacePattern("<A>\nxy\n</A>", "<A>.*</A>", "X")); 
 }
@Test
public void testSplitPreserveAllTokens_String6253() { 
     assertArrayEquals(null, StringUtils.splitPreserveAllTokens(null)); 
     assertEquals(0, StringUtils.splitPreserveAllTokens("").length); 
     String str = "abc def"; 
     String[] res = StringUtils.splitPreserveAllTokens(str); 
     assertEquals(2, res.length); 
     assertEquals("abc", res[0]); 
     assertEquals("def", res[1]); 
     str = "abc  def"; 
     res = StringUtils.splitPreserveAllTokens(str); 
     assertEquals(3, res.length); 
     assertEquals("abc", res[0]); 
     assertEquals("", res[1]); 
     assertEquals("def", res[2]); 
     str = " abc "; 
     res = StringUtils.splitPreserveAllTokens(str); 
     assertEquals(3, res.length); 
     assertEquals("", res[0]); 
     assertEquals("abc", res[1]); 
     assertEquals("", res[2]); 
     str = "a b .c"; 
     res = StringUtils.splitPreserveAllTokens(str); 
     assertEquals(3, res.length); 
     assertEquals("a", res[0]); 
     assertEquals("b", res[1]); 
     assertEquals(".c", res[2]); 
     str = " a b .c"; 
     res = StringUtils.splitPreserveAllTokens(str); 
     assertEquals(4, res.length); 
     assertEquals("", res[0]); 
     assertEquals("a", res[1]); 
     assertEquals("b", res[2]); 
     assertEquals(".c", res[3]); 
     str = "a  b  .c"; 
     res = StringUtils.splitPreserveAllTokens(str); 
     assertEquals(5, res.length); 
     assertEquals("a", res[0]); 
     assertEquals("", res[1]); 
     assertEquals("b", res[2]); 
     assertEquals("", res[3]); 
     assertEquals(".c", res[4]); 
     str = " a  "; 
     res = StringUtils.splitPreserveAllTokens(str); 
     assertEquals(4, res.length); 
     assertEquals("", res[0]); 
     assertEquals("a", res[1]); 
     assertEquals("", res[2]); 
     assertEquals("", res[3]); 
     str = " a  b"; 
     res = StringUtils.splitPreserveAllTokens(str); 
     assertEquals(4, res.length); 
     assertEquals("", res[0]); 
     assertEquals("a", res[1]); 
     assertEquals("", res[2]); 
     assertEquals("b", res[3]); 
     str = "a" + WHITESPACE + "b" + NON_WHITESPACE + "c"; 
     res = StringUtils.splitPreserveAllTokens(str); 
     assertEquals(WHITESPACE.length() + 1, res.length); 
     assertEquals("a", res[0]); 
     for (int i = 1; i < WHITESPACE.length() - 1; i++) { 
         assertEquals("", res[i]); 
     } 
     assertEquals("b" + NON_WHITESPACE + "c", res[WHITESPACE.length()]); 
 }
@Test
public void testJoin_IteratorChar6260() { 
     assertEquals(null, StringUtils.join((Iterator<?>) null, ',')); 
     assertEquals(TEXT_LIST_CHAR, StringUtils.join(Arrays.asList(ARRAY_LIST).iterator(), SEPARATOR_CHAR)); 
     assertEquals("", StringUtils.join(Arrays.asList(NULL_ARRAY_LIST).iterator(), SEPARATOR_CHAR)); 
     assertEquals("", StringUtils.join(Arrays.asList(EMPTY_ARRAY_LIST).iterator(), SEPARATOR_CHAR)); 
     assertEquals("foo", StringUtils.join(Collections.singleton("foo").iterator(), 'x')); 
 }
@Test
public void testJoin_IterableString6280() { 
     assertEquals(null, StringUtils.join((Iterable<?>) null, null)); 
     assertEquals(TEXT_LIST_NOSEP, StringUtils.join(Arrays.asList(ARRAY_LIST), null)); 
     assertEquals(TEXT_LIST_NOSEP, StringUtils.join(Arrays.asList(ARRAY_LIST), "")); 
     assertEquals("foo", StringUtils.join(Collections.singleton("foo"), "x")); 
     assertEquals("foo", StringUtils.join(Collections.singleton("foo"), null)); 
     assertEquals("", StringUtils.join(Arrays.asList(NULL_ARRAY_LIST), null)); 
     assertEquals("", StringUtils.join(Arrays.asList(EMPTY_ARRAY_LIST), null)); 
     assertEquals("", StringUtils.join(Arrays.asList(EMPTY_ARRAY_LIST), "")); 
     assertEquals("", StringUtils.join(Arrays.asList(EMPTY_ARRAY_LIST), SEPARATOR)); 
     assertEquals(TEXT_LIST, StringUtils.join(Arrays.asList(ARRAY_LIST), SEPARATOR)); 
 }
@Test
public void testEscapeSurrogatePairs6285() throws Exception { 
     assertEquals("\uD83D\uDE30", StringEscapeUtils.escapeCsv("\uD83D\uDE30")); 
     assertEquals("\uD800\uDC00", StringEscapeUtils.escapeCsv("\uD800\uDC00")); 
     assertEquals("\uD834\uDD1E", StringEscapeUtils.escapeCsv("\uD834\uDD1E")); 
     assertEquals("\uDBFF\uDFFD", StringEscapeUtils.escapeCsv("\uDBFF\uDFFD")); 
     assertEquals("\uDBFF\uDFFD", StringEscapeUtils.escapeHtml3("\uDBFF\uDFFD")); 
     assertEquals("\uDBFF\uDFFD", StringEscapeUtils.escapeHtml4("\uDBFF\uDFFD")); 
     assertEquals("\uDBFF\uDFFD", StringEscapeUtils.escapeXml("\uDBFF\uDFFD")); 
 }
@Test
public void testRemoveStartIgnoreCase6292() { 
     assertNull("removeStartIgnoreCase(null, null)", StringUtils.removeStartIgnoreCase(null, null)); 
     assertNull("removeStartIgnoreCase(null, \"\")", StringUtils.removeStartIgnoreCase(null, "")); 
     assertNull("removeStartIgnoreCase(null, \"a\")", StringUtils.removeStartIgnoreCase(null, "a")); 
     assertEquals("removeStartIgnoreCase(\"\", null)", StringUtils.removeStartIgnoreCase("", null), ""); 
     assertEquals("removeStartIgnoreCase(\"\", \"\")", StringUtils.removeStartIgnoreCase("", ""), ""); 
     assertEquals("removeStartIgnoreCase(\"\", \"a\")", StringUtils.removeStartIgnoreCase("", "a"), ""); 
     assertEquals("removeStartIgnoreCase(\"www.domain.com\", \"www.\")", StringUtils.removeStartIgnoreCase("www.domain.com", "www."), "domain.com"); 
     assertEquals("removeStartIgnoreCase(\"domain.com\", \"www.\")", StringUtils.removeStartIgnoreCase("domain.com", "www."), "domain.com"); 
     assertEquals("removeStartIgnoreCase(\"domain.com\", \"\")", StringUtils.removeStartIgnoreCase("domain.com", ""), "domain.com"); 
     assertEquals("removeStartIgnoreCase(\"domain.com\", null)", StringUtils.removeStartIgnoreCase("domain.com", null), "domain.com"); 
     assertEquals("removeStartIgnoreCase(\"www.domain.com\", \"WWW.\")", StringUtils.removeStartIgnoreCase("www.domain.com", "WWW."), "domain.com"); 
 }
@Test
public void testAbbreviateMiddle6306() { 
     assertNull(StringUtils.abbreviateMiddle(null, null, 0)); 
     assertEquals("abc", StringUtils.abbreviateMiddle("abc", null, 0)); 
     assertEquals("abc", StringUtils.abbreviateMiddle("abc", ".", 0)); 
     assertEquals("abc", StringUtils.abbreviateMiddle("abc", ".", 3)); 
     assertEquals("ab.f", StringUtils.abbreviateMiddle("abcdef", ".", 4)); 
     assertEquals("A very long text with un...f the text is complete.", StringUtils.abbreviateMiddle("A very long text with unimportant stuff in the middle but interesting start and " + "end to see if the text is complete.", "...", 50)); 
     final String longText = "Start text" + StringUtils.repeat("x", 10000) + "Close text"; 
     assertEquals("Start text->Close text", StringUtils.abbreviateMiddle(longText, "->", 22)); 
     assertEquals("abc", StringUtils.abbreviateMiddle("abc", ".", -1)); 
     assertEquals("abc", StringUtils.abbreviateMiddle("abc", ".", 1)); 
     assertEquals("abc", StringUtils.abbreviateMiddle("abc", ".", 2)); 
     assertEquals("a", StringUtils.abbreviateMiddle("a", ".", 1)); 
     assertEquals("a.d", StringUtils.abbreviateMiddle("abcd", ".", 3)); 
     assertEquals("a..f", StringUtils.abbreviateMiddle("abcdef", "..", 4)); 
     assertEquals("ab.ef", StringUtils.abbreviateMiddle("abcdef", ".", 5)); 
 }
@Test
public void testConstructor6312() { 
     assertNotNull(new StringUtils()); 
     final Constructor<?>[] cons = StringUtils.class.getDeclaredConstructors(); 
     assertEquals(1, cons.length); 
     assertTrue(Modifier.isPublic(cons[0].getModifiers())); 
     assertTrue(Modifier.isPublic(StringUtils.class.getModifiers())); 
     assertFalse(Modifier.isFinal(StringUtils.class.getModifiers())); 
 }
@Test
public void testCenter_StringIntChar6319() { 
     assertEquals(null, StringUtils.center(null, -1, ' ')); 
     assertEquals(null, StringUtils.center(null, 4, ' ')); 
     assertEquals("    ", StringUtils.center("", 4, ' ')); 
     assertEquals("ab", StringUtils.center("ab", 0, ' ')); 
     assertEquals("ab", StringUtils.center("ab", -1, ' ')); 
     assertEquals("ab", StringUtils.center("ab", 1, ' ')); 
     assertEquals("    ", StringUtils.center("", 4, ' ')); 
     assertEquals(" ab ", StringUtils.center("ab", 4, ' ')); 
     assertEquals("abcd", StringUtils.center("abcd", 2, ' ')); 
     assertEquals(" a  ", StringUtils.center("a", 4, ' ')); 
     assertEquals("  a  ", StringUtils.center("a", 5, ' ')); 
     assertEquals("xxaxx", StringUtils.center("a", 5, 'x')); 
 } 
@SuppressWarnings("deprecation")
@Test
public void testChomp6327() { 
     final String[][] chompCases = { { FOO_UNCAP + "\r\n", FOO_UNCAP }, { FOO_UNCAP + "\n", FOO_UNCAP }, { FOO_UNCAP + "\r", FOO_UNCAP }, { FOO_UNCAP + " \r", FOO_UNCAP + " " }, { FOO_UNCAP, FOO_UNCAP }, { FOO_UNCAP + "\n\n", FOO_UNCAP + "\n" }, { FOO_UNCAP + "\r\n\r\n", FOO_UNCAP + "\r\n" }, { "foo\nfoo", "foo\nfoo" }, { "foo\n\rfoo", "foo\n\rfoo" }, { "\n", "" }, { "\r", "" }, { "a", "a" }, { "\r\n", "" }, { "", "" }, { null, null }, { FOO_UNCAP + "\n\r", FOO_UNCAP + "\n" } }; 
     for (final String[] chompCase : chompCases) { 
         final String original = chompCase[0]; 
         final String expectedResult = chompCase[1]; 
         assertEquals("chomp(String) failed", expectedResult, StringUtils.chomp(original)); 
     } 
     assertEquals("chomp(String, String) failed", "foo", StringUtils.chomp("foobar", "bar")); 
     assertEquals("chomp(String, String) failed", "foobar", StringUtils.chomp("foobar", "baz")); 
     assertEquals("chomp(String, String) failed", "foo", StringUtils.chomp("foo", "foooo")); 
     assertEquals("chomp(String, String) failed", "foobar", StringUtils.chomp("foobar", "")); 
     assertEquals("chomp(String, String) failed", "foobar", StringUtils.chomp("foobar", null)); 
     assertEquals("chomp(String, String) failed", "", StringUtils.chomp("", "foo")); 
     assertEquals("chomp(String, String) failed", "", StringUtils.chomp("", null)); 
     assertEquals("chomp(String, String) failed", "", StringUtils.chomp("", "")); 
     assertEquals("chomp(String, String) failed", null, StringUtils.chomp(null, "foo")); 
     assertEquals("chomp(String, String) failed", null, StringUtils.chomp(null, null)); 
     assertEquals("chomp(String, String) failed", null, StringUtils.chomp(null, "")); 
     assertEquals("chomp(String, String) failed", "", StringUtils.chomp("foo", "foo")); 
     assertEquals("chomp(String, String) failed", " ", StringUtils.chomp(" foo", "foo")); 
     assertEquals("chomp(String, String) failed", "foo ", StringUtils.chomp("foo ", "foo")); 
 }
@Test
public void testRepeat_StringInt6342() { 
     assertEquals(null, StringUtils.repeat(null, 2)); 
     assertEquals("", StringUtils.repeat("ab", 0)); 
     assertEquals("", StringUtils.repeat("", 3)); 
     assertEquals("aaa", StringUtils.repeat("a", 3)); 
     assertEquals("ababab", StringUtils.repeat("ab", 3)); 
     assertEquals("abcabcabc", StringUtils.repeat("abc", 3)); 
     final String str = StringUtils.repeat("a", 10000); 
     assertEquals(10000, str.length()); 
     assertTrue(StringUtils.containsOnly(str, new char[] { 'a' })); 
 }
@Test
public void testGetCommonPrefix_StringArray6348() { 
     assertEquals("", StringUtils.getCommonPrefix((String[]) null)); 
     assertEquals("", StringUtils.getCommonPrefix()); 
     assertEquals("abc", StringUtils.getCommonPrefix("abc")); 
     assertEquals("", StringUtils.getCommonPrefix(null, null)); 
     assertEquals("", StringUtils.getCommonPrefix("", "")); 
     assertEquals("", StringUtils.getCommonPrefix("", null)); 
     assertEquals("", StringUtils.getCommonPrefix("abc", null, null)); 
     assertEquals("", StringUtils.getCommonPrefix(null, null, "abc")); 
     assertEquals("", StringUtils.getCommonPrefix("", "abc")); 
     assertEquals("", StringUtils.getCommonPrefix("abc", "")); 
     assertEquals("abc", StringUtils.getCommonPrefix("abc", "abc")); 
     assertEquals("a", StringUtils.getCommonPrefix("abc", "a")); 
     assertEquals("ab", StringUtils.getCommonPrefix("ab", "abxyz")); 
     assertEquals("ab", StringUtils.getCommonPrefix("abcde", "abxyz")); 
     assertEquals("", StringUtils.getCommonPrefix("abcde", "xyz")); 
     assertEquals("", StringUtils.getCommonPrefix("xyz", "abcde")); 
     assertEquals("i am a ", StringUtils.getCommonPrefix("i am a machine", "i am a robot")); 
 }
@Test
public void testLengthStringBuilder6350() { 
     assertEquals(0, StringUtils.length(new StringBuilder(""))); 
     assertEquals(0, StringUtils.length(new StringBuilder(StringUtils.EMPTY))); 
     assertEquals(1, StringUtils.length(new StringBuilder("A"))); 
     assertEquals(1, StringUtils.length(new StringBuilder(" "))); 
     assertEquals(8, StringUtils.length(new StringBuilder("ABCDEFGH"))); 
 }
@Test
public void testLeftPad_StringIntString6363() { 
     assertEquals(null, StringUtils.leftPad(null, 5, "-+")); 
     assertEquals(null, StringUtils.leftPad(null, 5, null)); 
     assertEquals("     ", StringUtils.leftPad("", 5, " ")); 
     assertEquals("-+-+abc", StringUtils.leftPad("abc", 7, "-+")); 
     assertEquals("-+~abc", StringUtils.leftPad("abc", 6, "-+~")); 
     assertEquals("-+abc", StringUtils.leftPad("abc", 5, "-+~")); 
     assertEquals("abc", StringUtils.leftPad("abc", 2, " ")); 
     assertEquals("abc", StringUtils.leftPad("abc", -1, " ")); 
     assertEquals("  abc", StringUtils.leftPad("abc", 5, null)); 
     assertEquals("  abc", StringUtils.leftPad("abc", 5, "")); 
 }
@Test
public void testGetLevenshteinDistance_StringStringInt6364() { 
     assertEquals(0, StringUtils.getLevenshteinDistance("", "", 0)); 
     assertEquals(7, StringUtils.getLevenshteinDistance("aaapppp", "", 8)); 
     assertEquals(7, StringUtils.getLevenshteinDistance("aaapppp", "", 7)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("aaapppp", "", 6)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("b", "a", 0)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("a", "b", 0)); 
     assertEquals(0, StringUtils.getLevenshteinDistance("aa", "aa", 0)); 
     assertEquals(0, StringUtils.getLevenshteinDistance("aa", "aa", 2)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("aaa", "bbb", 2)); 
     assertEquals(3, StringUtils.getLevenshteinDistance("aaa", "bbb", 3)); 
     assertEquals(6, StringUtils.getLevenshteinDistance("aaaaaa", "b", 10)); 
     assertEquals(7, StringUtils.getLevenshteinDistance("aaapppp", "b", 8)); 
     assertEquals(3, StringUtils.getLevenshteinDistance("a", "bbb", 4)); 
     assertEquals(7, StringUtils.getLevenshteinDistance("aaapppp", "b", 7)); 
     assertEquals(3, StringUtils.getLevenshteinDistance("a", "bbb", 3)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("a", "bbb", 2)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("bbb", "a", 2)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("aaapppp", "b", 6)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("a", "bbb", 1)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("bbb", "a", 1)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("12345", "1234567", 1)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("1234567", "12345", 1)); 
     assertEquals(1, StringUtils.getLevenshteinDistance("frog", "fog", 1)); 
     assertEquals(3, StringUtils.getLevenshteinDistance("fly", "ant", 3)); 
     assertEquals(7, StringUtils.getLevenshteinDistance("elephant", "hippo", 7)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("elephant", "hippo", 6)); 
     assertEquals(7, StringUtils.getLevenshteinDistance("hippo", "elephant", 7)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("hippo", "elephant", 6)); 
     assertEquals(8, StringUtils.getLevenshteinDistance("hippo", "zzzzzzzz", 8)); 
     assertEquals(8, StringUtils.getLevenshteinDistance("zzzzzzzz", "hippo", 8)); 
     assertEquals(1, StringUtils.getLevenshteinDistance("hello", "hallo", 1)); 
     try { 
         @SuppressWarnings("unused") 
         final int d = StringUtils.getLevenshteinDistance("a", null, 0); 
         fail("expecting IllegalArgumentException"); 
     } catch (final IllegalArgumentException ex) { 
     } 
     try { 
         @SuppressWarnings("unused") 
         final int d = StringUtils.getLevenshteinDistance(null, "a", 0); 
         fail("expecting IllegalArgumentException"); 
     } catch (final IllegalArgumentException ex) { 
     } 
     try { 
         @SuppressWarnings("unused") 
         final int d = StringUtils.getLevenshteinDistance("a", "a", -1); 
         fail("expecting IllegalArgumentException"); 
     } catch (final IllegalArgumentException ex) { 
     } 
 }
@Test
public void testGetLevenshteinDistance_StringStringInt6388() { 
     assertEquals(0, StringUtils.getLevenshteinDistance("", "", 0)); 
     assertEquals(7, StringUtils.getLevenshteinDistance("aaapppp", "", 8)); 
     assertEquals(7, StringUtils.getLevenshteinDistance("aaapppp", "", 7)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("aaapppp", "", 6)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("b", "a", 0)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("a", "b", 0)); 
     assertEquals(0, StringUtils.getLevenshteinDistance("aa", "aa", 0)); 
     assertEquals(0, StringUtils.getLevenshteinDistance("aa", "aa", 2)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("aaa", "bbb", 2)); 
     assertEquals(3, StringUtils.getLevenshteinDistance("aaa", "bbb", 3)); 
     assertEquals(6, StringUtils.getLevenshteinDistance("aaaaaa", "b", 10)); 
     assertEquals(7, StringUtils.getLevenshteinDistance("aaapppp", "b", 8)); 
     assertEquals(3, StringUtils.getLevenshteinDistance("a", "bbb", 4)); 
     assertEquals(7, StringUtils.getLevenshteinDistance("aaapppp", "b", 7)); 
     assertEquals(3, StringUtils.getLevenshteinDistance("a", "bbb", 3)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("a", "bbb", 2)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("bbb", "a", 2)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("aaapppp", "b", 6)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("a", "bbb", 1)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("bbb", "a", 1)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("12345", "1234567", 1)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("1234567", "12345", 1)); 
     assertEquals(1, StringUtils.getLevenshteinDistance("frog", "fog", 1)); 
     assertEquals(3, StringUtils.getLevenshteinDistance("fly", "ant", 3)); 
     assertEquals(7, StringUtils.getLevenshteinDistance("elephant", "hippo", 7)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("elephant", "hippo", 6)); 
     assertEquals(7, StringUtils.getLevenshteinDistance("hippo", "elephant", 7)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("hippo", "elephant", 6)); 
     assertEquals(8, StringUtils.getLevenshteinDistance("hippo", "zzzzzzzz", 8)); 
     assertEquals(8, StringUtils.getLevenshteinDistance("zzzzzzzz", "hippo", 8)); 
     assertEquals(1, StringUtils.getLevenshteinDistance("hello", "hallo", 1)); 
     try { 
         @SuppressWarnings("unused") 
         final int d = StringUtils.getLevenshteinDistance("a", null, 0); 
         fail("expecting IllegalArgumentException"); 
     } catch (final IllegalArgumentException ex) { 
     } 
     try { 
         @SuppressWarnings("unused") 
         final int d = StringUtils.getLevenshteinDistance(null, "a", 0); 
         fail("expecting IllegalArgumentException"); 
     } catch (final IllegalArgumentException ex) { 
     } 
     try { 
         @SuppressWarnings("unused") 
         final int d = StringUtils.getLevenshteinDistance("a", "a", -1); 
         fail("expecting IllegalArgumentException"); 
     } catch (final IllegalArgumentException ex) { 
     } 
 }
@Test
public void testEscapeSurrogatePairs6391() throws Exception { 
     assertEquals("\uD83D\uDE30", StringEscapeUtils.escapeCsv("\uD83D\uDE30")); 
     assertEquals("\uD800\uDC00", StringEscapeUtils.escapeCsv("\uD800\uDC00")); 
     assertEquals("\uD834\uDD1E", StringEscapeUtils.escapeCsv("\uD834\uDD1E")); 
     assertEquals("\uDBFF\uDFFD", StringEscapeUtils.escapeCsv("\uDBFF\uDFFD")); 
     assertEquals("\uDBFF\uDFFD", StringEscapeUtils.escapeHtml3("\uDBFF\uDFFD")); 
     assertEquals("\uDBFF\uDFFD", StringEscapeUtils.escapeHtml4("\uDBFF\uDFFD")); 
     assertEquals("\uDBFF\uDFFD", StringEscapeUtils.escapeXml("\uDBFF\uDFFD")); 
 }
@Test
public void testSplitByWholeSeparatorPreserveAllTokens_StringStringInt6393() { 
     assertArrayEquals(null, StringUtils.splitByWholeSeparatorPreserveAllTokens(null, ".", -1)); 
     assertEquals(0, StringUtils.splitByWholeSeparatorPreserveAllTokens("", ".", -1).length); 
     String input = "ab   de fg"; 
     String[] expected = new String[] { "ab", "", "", "de", "fg" }; 
     String[] actual = StringUtils.splitByWholeSeparatorPreserveAllTokens(input, null, -1); 
     assertEquals(expected.length, actual.length); 
     for (int i = 0; i < actual.length; i += 1) { 
         assertEquals(expected[i], actual[i]); 
     } 
     input = "1::2:::3::::4"; 
     expected = new String[] { "1", "", "2", "", "", "3", "", "", "", "4" }; 
     actual = StringUtils.splitByWholeSeparatorPreserveAllTokens(input, ":", -1); 
     assertEquals(expected.length, actual.length); 
     for (int i = 0; i < actual.length; i += 1) { 
         assertEquals(expected[i], actual[i]); 
     } 
     input = "1::2:::3::::4"; 
     expected = new String[] { "1", "2", ":3", "", "4" }; 
     actual = StringUtils.splitByWholeSeparatorPreserveAllTokens(input, "::", -1); 
     assertEquals(expected.length, actual.length); 
     for (int i = 0; i < actual.length; i += 1) { 
         assertEquals(expected[i], actual[i]); 
     } 
     input = "1::2::3:4"; 
     expected = new String[] { "1", "", "2", ":3:4" }; 
     actual = StringUtils.splitByWholeSeparatorPreserveAllTokens(input, ":", 4); 
     assertEquals(expected.length, actual.length); 
     for (int i = 0; i < actual.length; i += 1) { 
         assertEquals(expected[i], actual[i]); 
     } 
 }
@Test
public void testJoin_ArrayCharSeparator6398() { 
     assertEquals(null, StringUtils.join((Object[]) null, ',')); 
     assertEquals(TEXT_LIST_CHAR, StringUtils.join(ARRAY_LIST, SEPARATOR_CHAR)); 
     assertEquals("", StringUtils.join(EMPTY_ARRAY_LIST, SEPARATOR_CHAR)); 
     assertEquals(";;foo", StringUtils.join(MIXED_ARRAY_LIST, SEPARATOR_CHAR)); 
     assertEquals("foo;2", StringUtils.join(MIXED_TYPE_LIST, SEPARATOR_CHAR)); 
     assertEquals("/", StringUtils.join(MIXED_ARRAY_LIST, '/', 0, MIXED_ARRAY_LIST.length - 1)); 
     assertEquals("foo", StringUtils.join(MIXED_TYPE_LIST, '/', 0, 1)); 
     assertEquals("null", StringUtils.join(NULL_TO_STRING_LIST, '/', 0, 1)); 
     assertEquals("foo/2", StringUtils.join(MIXED_TYPE_LIST, '/', 0, 2)); 
     assertEquals("2", StringUtils.join(MIXED_TYPE_LIST, '/', 1, 2)); 
     assertEquals("", StringUtils.join(MIXED_TYPE_LIST, '/', 2, 1)); 
 }
@Test
public void testJoin_ArrayOfFloats6410() { 
     assertEquals(null, StringUtils.join((float[]) null, ',')); 
     assertEquals("1.0;2.0", StringUtils.join(FLOAT_PRIM_LIST, SEPARATOR_CHAR)); 
     assertEquals("2.0", StringUtils.join(FLOAT_PRIM_LIST, SEPARATOR_CHAR, 1, 2)); 
 }
@Test
public void testReplace_StringStringArrayStringArray6412() { 
     assertNull(StringUtils.replaceEach(null, new String[] { "a" }, new String[] { "b" })); 
     assertEquals(StringUtils.replaceEach("", new String[] { "a" }, new String[] { "b" }), ""); 
     assertEquals(StringUtils.replaceEach("aba", null, null), "aba"); 
     assertEquals(StringUtils.replaceEach("aba", new String[0], null), "aba"); 
     assertEquals(StringUtils.replaceEach("aba", null, new String[0]), "aba"); 
     assertEquals(StringUtils.replaceEach("aba", new String[] { "a" }, null), "aba"); 
     assertEquals(StringUtils.replaceEach("aba", new String[] { "a" }, new String[] { "" }), "b"); 
     assertEquals(StringUtils.replaceEach("aba", new String[] { null }, new String[] { "a" }), "aba"); 
     assertEquals(StringUtils.replaceEach("abcde", new String[] { "ab", "d" }, new String[] { "w", "t" }), "wcte"); 
     assertEquals(StringUtils.replaceEach("abcde", new String[] { "ab", "d" }, new String[] { "d", "t" }), "dcte"); 
     assertEquals("bcc", StringUtils.replaceEach("abc", new String[] { "a", "b" }, new String[] { "b", "c" })); 
     assertEquals("q651.506bera", StringUtils.replaceEach("d216.102oren", new String[] { "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "1", "2", "3", "4", "5", "6", "7", "8", "9" }, new String[] { "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z", "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "5", "6", "7", "8", "9", "1", "2", "3", "4" })); 
     assertEquals(StringUtils.replaceEach("aba", new String[] { "a" }, new String[] { null }), "aba"); 
     assertEquals(StringUtils.replaceEach("aba", new String[] { "a", "b" }, new String[] { "c", null }), "cbc"); 
 }
@Test
public void testEscapeSurrogatePairs6422() throws Exception { 
     assertEquals("\uD83D\uDE30", StringEscapeUtils.escapeCsv("\uD83D\uDE30")); 
     assertEquals("\uD800\uDC00", StringEscapeUtils.escapeCsv("\uD800\uDC00")); 
     assertEquals("\uD834\uDD1E", StringEscapeUtils.escapeCsv("\uD834\uDD1E")); 
     assertEquals("\uDBFF\uDFFD", StringEscapeUtils.escapeCsv("\uDBFF\uDFFD")); 
     assertEquals("\uDBFF\uDFFD", StringEscapeUtils.escapeHtml3("\uDBFF\uDFFD")); 
     assertEquals("\uDBFF\uDFFD", StringEscapeUtils.escapeHtml4("\uDBFF\uDFFD")); 
     assertEquals("\uDBFF\uDFFD", StringEscapeUtils.escapeXml("\uDBFF\uDFFD")); 
 }
@Test
public void testRepeat_StringInt6426() { 
     assertEquals(null, StringUtils.repeat(null, 2)); 
     assertEquals("", StringUtils.repeat("ab", 0)); 
     assertEquals("", StringUtils.repeat("", 3)); 
     assertEquals("aaa", StringUtils.repeat("a", 3)); 
     assertEquals("ababab", StringUtils.repeat("ab", 3)); 
     assertEquals("abcabcabc", StringUtils.repeat("abc", 3)); 
     final String str = StringUtils.repeat("a", 10000); 
     assertEquals(10000, str.length()); 
     assertTrue(StringUtils.containsOnly(str, new char[] { 'a' })); 
 }
@Test
public void testDifference_StringString6432() { 
     assertEquals(null, StringUtils.difference(null, null)); 
     assertEquals("", StringUtils.difference("", "")); 
     assertEquals("abc", StringUtils.difference("", "abc")); 
     assertEquals("", StringUtils.difference("abc", "")); 
     assertEquals("i am a robot", StringUtils.difference(null, "i am a robot")); 
     assertEquals("i am a machine", StringUtils.difference("i am a machine", null)); 
     assertEquals("robot", StringUtils.difference("i am a machine", "i am a robot")); 
     assertEquals("", StringUtils.difference("abc", "abc")); 
     assertEquals("you are a robot", StringUtils.difference("i am a robot", "you are a robot")); 
 }
@Test
public void testSplitByCharacterTypeCamelCase6474() { 
     assertNull(StringUtils.splitByCharacterTypeCamelCase(null)); 
     assertEquals(0, StringUtils.splitByCharacterTypeCamelCase("").length); 
     assertTrue(ArrayUtils.isEquals(new String[] { "ab", " ", "de", " ", "fg" }, StringUtils.splitByCharacterTypeCamelCase("ab de fg"))); 
     assertTrue(ArrayUtils.isEquals(new String[] { "ab", "   ", "de", " ", "fg" }, StringUtils.splitByCharacterTypeCamelCase("ab   de fg"))); 
     assertTrue(ArrayUtils.isEquals(new String[] { "ab", ":", "cd", ":", "ef" }, StringUtils.splitByCharacterTypeCamelCase("ab:cd:ef"))); 
     assertTrue(ArrayUtils.isEquals(new String[] { "number", "5" }, StringUtils.splitByCharacterTypeCamelCase("number5"))); 
     assertTrue(ArrayUtils.isEquals(new String[] { "foo", "Bar" }, StringUtils.splitByCharacterTypeCamelCase("fooBar"))); 
     assertTrue(ArrayUtils.isEquals(new String[] { "foo", "200", "Bar" }, StringUtils.splitByCharacterTypeCamelCase("foo200Bar"))); 
     assertTrue(ArrayUtils.isEquals(new String[] { "ASF", "Rules" }, StringUtils.splitByCharacterTypeCamelCase("ASFRules"))); 
 }
@Test
public void testDeleteWhitespace_String6499() { 
     assertEquals(null, StringUtils.deleteWhitespace(null)); 
     assertEquals("", StringUtils.deleteWhitespace("")); 
     assertEquals("", StringUtils.deleteWhitespace("  \u000C  \t\t\u001F\n\n \u000B  ")); 
     assertEquals("", StringUtils.deleteWhitespace(StringUtilsTest.WHITESPACE)); 
     assertEquals(StringUtilsTest.NON_WHITESPACE, StringUtils.deleteWhitespace(StringUtilsTest.NON_WHITESPACE)); 
     assertEquals("\u00A0\u202F", StringUtils.deleteWhitespace("  \u00A0  \t\t\n\n \u202F  ")); 
     assertEquals("\u00A0\u202F", StringUtils.deleteWhitespace("\u00A0\u202F")); 
     assertEquals("test", StringUtils.deleteWhitespace("\u000Bt  \t\n\u0009e\rs\n\n   \tt")); 
 }
@Test
public void testPrependIfMissingIgnoreCase6535() { 
     assertEquals("prependIfMissingIgnoreCase(null,null)", null, StringUtils.prependIfMissingIgnoreCase(null, null)); 
     assertEquals("prependIfMissingIgnoreCase(abc,null)", "abc", StringUtils.prependIfMissingIgnoreCase("abc", null)); 
     assertEquals("prependIfMissingIgnoreCase(\"\",xyz)", "xyz", StringUtils.prependIfMissingIgnoreCase("", "xyz")); 
     assertEquals("prependIfMissingIgnoreCase(abc,xyz)", "xyzabc", StringUtils.prependIfMissingIgnoreCase("abc", "xyz")); 
     assertEquals("prependIfMissingIgnoreCase(xyzabc,xyz)", "xyzabc", StringUtils.prependIfMissingIgnoreCase("xyzabc", "xyz")); 
     assertEquals("prependIfMissingIgnoreCase(XYZabc,xyz)", "XYZabc", StringUtils.prependIfMissingIgnoreCase("XYZabc", "xyz")); 
     assertEquals("prependIfMissingIgnoreCase(null,null null)", null, StringUtils.prependIfMissingIgnoreCase(null, null, (CharSequence[]) null)); 
     assertEquals("prependIfMissingIgnoreCase(abc,null,null)", "abc", StringUtils.prependIfMissingIgnoreCase("abc", null, (CharSequence[]) null)); 
     assertEquals("prependIfMissingIgnoreCase(\"\",xyz,null)", "xyz", StringUtils.prependIfMissingIgnoreCase("", "xyz", (CharSequence[]) null)); 
     assertEquals("prependIfMissingIgnoreCase(abc,xyz,{null})", "xyzabc", StringUtils.prependIfMissingIgnoreCase("abc", "xyz", new CharSequence[] { null })); 
     assertEquals("prependIfMissingIgnoreCase(abc,xyz,\"\")", "abc", StringUtils.prependIfMissingIgnoreCase("abc", "xyz", "")); 
     assertEquals("prependIfMissingIgnoreCase(abc,xyz,mno)", "xyzabc", StringUtils.prependIfMissingIgnoreCase("abc", "xyz", "mno")); 
     assertEquals("prependIfMissingIgnoreCase(xyzabc,xyz,mno)", "xyzabc", StringUtils.prependIfMissingIgnoreCase("xyzabc", "xyz", "mno")); 
     assertEquals("prependIfMissingIgnoreCase(mnoabc,xyz,mno)", "mnoabc", StringUtils.prependIfMissingIgnoreCase("mnoabc", "xyz", "mno")); 
     assertEquals("prependIfMissingIgnoreCase(XYZabc,xyz,mno)", "XYZabc", StringUtils.prependIfMissingIgnoreCase("XYZabc", "xyz", "mno")); 
     assertEquals("prependIfMissingIgnoreCase(MNOabc,xyz,mno)", "MNOabc", StringUtils.prependIfMissingIgnoreCase("MNOabc", "xyz", "mno")); 
 }
@Test
public void testDefault_StringString6545() { 
     assertEquals("NULL", StringUtils.defaultString(null, "NULL")); 
     assertEquals("", StringUtils.defaultString("", "NULL")); 
     assertEquals("abc", StringUtils.defaultString("abc", "NULL")); 
 }
@Test
public void testGetLevenshteinDistance_StringStringInt6548() { 
     assertEquals(0, StringUtils.getLevenshteinDistance("", "", 0)); 
     assertEquals(7, StringUtils.getLevenshteinDistance("aaapppp", "", 8)); 
     assertEquals(7, StringUtils.getLevenshteinDistance("aaapppp", "", 7)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("aaapppp", "", 6)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("b", "a", 0)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("a", "b", 0)); 
     assertEquals(0, StringUtils.getLevenshteinDistance("aa", "aa", 0)); 
     assertEquals(0, StringUtils.getLevenshteinDistance("aa", "aa", 2)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("aaa", "bbb", 2)); 
     assertEquals(3, StringUtils.getLevenshteinDistance("aaa", "bbb", 3)); 
     assertEquals(6, StringUtils.getLevenshteinDistance("aaaaaa", "b", 10)); 
     assertEquals(7, StringUtils.getLevenshteinDistance("aaapppp", "b", 8)); 
     assertEquals(3, StringUtils.getLevenshteinDistance("a", "bbb", 4)); 
     assertEquals(7, StringUtils.getLevenshteinDistance("aaapppp", "b", 7)); 
     assertEquals(3, StringUtils.getLevenshteinDistance("a", "bbb", 3)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("a", "bbb", 2)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("bbb", "a", 2)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("aaapppp", "b", 6)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("a", "bbb", 1)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("bbb", "a", 1)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("12345", "1234567", 1)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("1234567", "12345", 1)); 
     assertEquals(1, StringUtils.getLevenshteinDistance("frog", "fog", 1)); 
     assertEquals(3, StringUtils.getLevenshteinDistance("fly", "ant", 3)); 
     assertEquals(7, StringUtils.getLevenshteinDistance("elephant", "hippo", 7)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("elephant", "hippo", 6)); 
     assertEquals(7, StringUtils.getLevenshteinDistance("hippo", "elephant", 7)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("hippo", "elephant", 6)); 
     assertEquals(8, StringUtils.getLevenshteinDistance("hippo", "zzzzzzzz", 8)); 
     assertEquals(8, StringUtils.getLevenshteinDistance("zzzzzzzz", "hippo", 8)); 
     assertEquals(1, StringUtils.getLevenshteinDistance("hello", "hallo", 1)); 
     try { 
         @SuppressWarnings("unused") 
         final int d = StringUtils.getLevenshteinDistance("a", null, 0); 
         fail("expecting IllegalArgumentException"); 
     } catch (final IllegalArgumentException ex) { 
     } 
     try { 
         @SuppressWarnings("unused") 
         final int d = StringUtils.getLevenshteinDistance(null, "a", 0); 
         fail("expecting IllegalArgumentException"); 
     } catch (final IllegalArgumentException ex) { 
     } 
     try { 
         @SuppressWarnings("unused") 
         final int d = StringUtils.getLevenshteinDistance("a", "a", -1); 
         fail("expecting IllegalArgumentException"); 
     } catch (final IllegalArgumentException ex) { 
     } 
 }
@Test
public void testReplace_StringStringStringInt6549() { 
     assertEquals(null, StringUtils.replace(null, null, null, 2)); 
     assertEquals(null, StringUtils.replace(null, null, "any", 2)); 
     assertEquals(null, StringUtils.replace(null, "any", null, 2)); 
     assertEquals(null, StringUtils.replace(null, "any", "any", 2)); 
     assertEquals("", StringUtils.replace("", null, null, 2)); 
     assertEquals("", StringUtils.replace("", null, "any", 2)); 
     assertEquals("", StringUtils.replace("", "any", null, 2)); 
     assertEquals("", StringUtils.replace("", "any", "any", 2)); 
     final String str = new String(new char[] { 'o', 'o', 'f', 'o', 'o' }); 
     assertSame(str, StringUtils.replace(str, "x", "", -1)); 
     assertEquals("f", StringUtils.replace("oofoo", "o", "", -1)); 
     assertEquals("oofoo", StringUtils.replace("oofoo", "o", "", 0)); 
     assertEquals("ofoo", StringUtils.replace("oofoo", "o", "", 1)); 
     assertEquals("foo", StringUtils.replace("oofoo", "o", "", 2)); 
     assertEquals("fo", StringUtils.replace("oofoo", "o", "", 3)); 
     assertEquals("f", StringUtils.replace("oofoo", "o", "", 4)); 
     assertEquals("f", StringUtils.replace("oofoo", "o", "", -5)); 
     assertEquals("f", StringUtils.replace("oofoo", "o", "", 1000)); 
 }
@Test
public void testIsAllUpperCase6556() { 
     assertFalse(StringUtils.isAllUpperCase(null)); 
     assertFalse(StringUtils.isAllUpperCase(StringUtils.EMPTY)); 
     assertTrue(StringUtils.isAllUpperCase("ABC")); 
     assertFalse(StringUtils.isAllUpperCase("ABC ")); 
     assertFalse(StringUtils.isAllUpperCase("aBC")); 
 }
@Test
public void testRepeat_StringInt6562() { 
     assertEquals(null, StringUtils.repeat(null, 2)); 
     assertEquals("", StringUtils.repeat("ab", 0)); 
     assertEquals("", StringUtils.repeat("", 3)); 
     assertEquals("aaa", StringUtils.repeat("a", 3)); 
     assertEquals("ababab", StringUtils.repeat("ab", 3)); 
     assertEquals("abcabcabc", StringUtils.repeat("abc", 3)); 
     final String str = StringUtils.repeat("a", 10000); 
     assertEquals(10000, str.length()); 
     assertTrue(StringUtils.containsOnly(str, new char[] { 'a' })); 
 }
@Test
public void testGetLevenshteinDistance_StringStringInt6576() { 
     assertEquals(0, StringUtils.getLevenshteinDistance("", "", 0)); 
     assertEquals(7, StringUtils.getLevenshteinDistance("aaapppp", "", 8)); 
     assertEquals(7, StringUtils.getLevenshteinDistance("aaapppp", "", 7)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("aaapppp", "", 6)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("b", "a", 0)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("a", "b", 0)); 
     assertEquals(0, StringUtils.getLevenshteinDistance("aa", "aa", 0)); 
     assertEquals(0, StringUtils.getLevenshteinDistance("aa", "aa", 2)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("aaa", "bbb", 2)); 
     assertEquals(3, StringUtils.getLevenshteinDistance("aaa", "bbb", 3)); 
     assertEquals(6, StringUtils.getLevenshteinDistance("aaaaaa", "b", 10)); 
     assertEquals(7, StringUtils.getLevenshteinDistance("aaapppp", "b", 8)); 
     assertEquals(3, StringUtils.getLevenshteinDistance("a", "bbb", 4)); 
     assertEquals(7, StringUtils.getLevenshteinDistance("aaapppp", "b", 7)); 
     assertEquals(3, StringUtils.getLevenshteinDistance("a", "bbb", 3)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("a", "bbb", 2)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("bbb", "a", 2)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("aaapppp", "b", 6)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("a", "bbb", 1)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("bbb", "a", 1)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("12345", "1234567", 1)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("1234567", "12345", 1)); 
     assertEquals(1, StringUtils.getLevenshteinDistance("frog", "fog", 1)); 
     assertEquals(3, StringUtils.getLevenshteinDistance("fly", "ant", 3)); 
     assertEquals(7, StringUtils.getLevenshteinDistance("elephant", "hippo", 7)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("elephant", "hippo", 6)); 
     assertEquals(7, StringUtils.getLevenshteinDistance("hippo", "elephant", 7)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("hippo", "elephant", 6)); 
     assertEquals(8, StringUtils.getLevenshteinDistance("hippo", "zzzzzzzz", 8)); 
     assertEquals(8, StringUtils.getLevenshteinDistance("zzzzzzzz", "hippo", 8)); 
     assertEquals(1, StringUtils.getLevenshteinDistance("hello", "hallo", 1)); 
     try { 
         @SuppressWarnings("unused") 
         final int d = StringUtils.getLevenshteinDistance("a", null, 0); 
         fail("expecting IllegalArgumentException"); 
     } catch (final IllegalArgumentException ex) { 
     } 
     try { 
         @SuppressWarnings("unused") 
         final int d = StringUtils.getLevenshteinDistance(null, "a", 0); 
         fail("expecting IllegalArgumentException"); 
     } catch (final IllegalArgumentException ex) { 
     } 
     try { 
         @SuppressWarnings("unused") 
         final int d = StringUtils.getLevenshteinDistance("a", "a", -1); 
         fail("expecting IllegalArgumentException"); 
     } catch (final IllegalArgumentException ex) { 
     } 
 }
@Test
public void testGetCommonPrefix_StringArray6583() { 
     assertEquals("", StringUtils.getCommonPrefix((String[]) null)); 
     assertEquals("", StringUtils.getCommonPrefix()); 
     assertEquals("abc", StringUtils.getCommonPrefix("abc")); 
     assertEquals("", StringUtils.getCommonPrefix(null, null)); 
     assertEquals("", StringUtils.getCommonPrefix("", "")); 
     assertEquals("", StringUtils.getCommonPrefix("", null)); 
     assertEquals("", StringUtils.getCommonPrefix("abc", null, null)); 
     assertEquals("", StringUtils.getCommonPrefix(null, null, "abc")); 
     assertEquals("", StringUtils.getCommonPrefix("", "abc")); 
     assertEquals("", StringUtils.getCommonPrefix("abc", "")); 
     assertEquals("abc", StringUtils.getCommonPrefix("abc", "abc")); 
     assertEquals("a", StringUtils.getCommonPrefix("abc", "a")); 
     assertEquals("ab", StringUtils.getCommonPrefix("ab", "abxyz")); 
     assertEquals("ab", StringUtils.getCommonPrefix("abcde", "abxyz")); 
     assertEquals("", StringUtils.getCommonPrefix("abcde", "xyz")); 
     assertEquals("", StringUtils.getCommonPrefix("xyz", "abcde")); 
     assertEquals("i am a ", StringUtils.getCommonPrefix("i am a machine", "i am a robot")); 
 }
@Test
public void testReplace_StringStringStringInt6656() { 
     assertEquals(null, StringUtils.replace(null, null, null, 2)); 
     assertEquals(null, StringUtils.replace(null, null, "any", 2)); 
     assertEquals(null, StringUtils.replace(null, "any", null, 2)); 
     assertEquals(null, StringUtils.replace(null, "any", "any", 2)); 
     assertEquals("", StringUtils.replace("", null, null, 2)); 
     assertEquals("", StringUtils.replace("", null, "any", 2)); 
     assertEquals("", StringUtils.replace("", "any", null, 2)); 
     assertEquals("", StringUtils.replace("", "any", "any", 2)); 
     final String str = new String(new char[] { 'o', 'o', 'f', 'o', 'o' }); 
     assertSame(str, StringUtils.replace(str, "x", "", -1)); 
     assertEquals("f", StringUtils.replace("oofoo", "o", "", -1)); 
     assertEquals("oofoo", StringUtils.replace("oofoo", "o", "", 0)); 
     assertEquals("ofoo", StringUtils.replace("oofoo", "o", "", 1)); 
     assertEquals("foo", StringUtils.replace("oofoo", "o", "", 2)); 
     assertEquals("fo", StringUtils.replace("oofoo", "o", "", 3)); 
     assertEquals("f", StringUtils.replace("oofoo", "o", "", 4)); 
     assertEquals("f", StringUtils.replace("oofoo", "o", "", -5)); 
     assertEquals("f", StringUtils.replace("oofoo", "o", "", 1000)); 
 }
@Test
public void testJoin_IterableString6659() { 
     assertEquals(null, StringUtils.join((Iterable<?>) null, null)); 
     assertEquals(TEXT_LIST_NOSEP, StringUtils.join(Arrays.asList(ARRAY_LIST), null)); 
     assertEquals(TEXT_LIST_NOSEP, StringUtils.join(Arrays.asList(ARRAY_LIST), "")); 
     assertEquals("foo", StringUtils.join(Collections.singleton("foo"), "x")); 
     assertEquals("foo", StringUtils.join(Collections.singleton("foo"), null)); 
     assertEquals("", StringUtils.join(Arrays.asList(NULL_ARRAY_LIST), null)); 
     assertEquals("", StringUtils.join(Arrays.asList(EMPTY_ARRAY_LIST), null)); 
     assertEquals("", StringUtils.join(Arrays.asList(EMPTY_ARRAY_LIST), "")); 
     assertEquals("", StringUtils.join(Arrays.asList(EMPTY_ARRAY_LIST), SEPARATOR)); 
     assertEquals(TEXT_LIST, StringUtils.join(Arrays.asList(ARRAY_LIST), SEPARATOR)); 
 }
@Test
public void testRepeat_StringInt6666() { 
     assertEquals(null, StringUtils.repeat(null, 2)); 
     assertEquals("", StringUtils.repeat("ab", 0)); 
     assertEquals("", StringUtils.repeat("", 3)); 
     assertEquals("aaa", StringUtils.repeat("a", 3)); 
     assertEquals("ababab", StringUtils.repeat("ab", 3)); 
     assertEquals("abcabcabc", StringUtils.repeat("abc", 3)); 
     final String str = StringUtils.repeat("a", 10000); 
     assertEquals(10000, str.length()); 
     assertTrue(StringUtils.containsOnly(str, new char[] { 'a' })); 
 }
@Test
public void testRepeat_StringInt6678() { 
     assertEquals(null, StringUtils.repeat(null, 2)); 
     assertEquals("", StringUtils.repeat("ab", 0)); 
     assertEquals("", StringUtils.repeat("", 3)); 
     assertEquals("aaa", StringUtils.repeat("a", 3)); 
     assertEquals("ababab", StringUtils.repeat("ab", 3)); 
     assertEquals("abcabcabc", StringUtils.repeat("abc", 3)); 
     final String str = StringUtils.repeat("a", 10000); 
     assertEquals(10000, str.length()); 
     assertTrue(StringUtils.containsOnly(str, new char[] { 'a' })); 
 }
@Test
public void testReplace_StringStringArrayStringArray6679() { 
     assertNull(StringUtils.replaceEach(null, new String[] { "a" }, new String[] { "b" })); 
     assertEquals(StringUtils.replaceEach("", new String[] { "a" }, new String[] { "b" }), ""); 
     assertEquals(StringUtils.replaceEach("aba", null, null), "aba"); 
     assertEquals(StringUtils.replaceEach("aba", new String[0], null), "aba"); 
     assertEquals(StringUtils.replaceEach("aba", null, new String[0]), "aba"); 
     assertEquals(StringUtils.replaceEach("aba", new String[] { "a" }, null), "aba"); 
     assertEquals(StringUtils.replaceEach("aba", new String[] { "a" }, new String[] { "" }), "b"); 
     assertEquals(StringUtils.replaceEach("aba", new String[] { null }, new String[] { "a" }), "aba"); 
     assertEquals(StringUtils.replaceEach("abcde", new String[] { "ab", "d" }, new String[] { "w", "t" }), "wcte"); 
     assertEquals(StringUtils.replaceEach("abcde", new String[] { "ab", "d" }, new String[] { "d", "t" }), "dcte"); 
     assertEquals("bcc", StringUtils.replaceEach("abc", new String[] { "a", "b" }, new String[] { "b", "c" })); 
     assertEquals("q651.506bera", StringUtils.replaceEach("d216.102oren", new String[] { "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "1", "2", "3", "4", "5", "6", "7", "8", "9" }, new String[] { "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z", "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "5", "6", "7", "8", "9", "1", "2", "3", "4" })); 
     assertEquals(StringUtils.replaceEach("aba", new String[] { "a" }, new String[] { null }), "aba"); 
     assertEquals(StringUtils.replaceEach("aba", new String[] { "a", "b" }, new String[] { "c", null }), "cbc"); 
 }
@Test
public void testGetCommonPrefix_StringArray6711() { 
     assertEquals("", StringUtils.getCommonPrefix((String[]) null)); 
     assertEquals("", StringUtils.getCommonPrefix()); 
     assertEquals("abc", StringUtils.getCommonPrefix("abc")); 
     assertEquals("", StringUtils.getCommonPrefix(null, null)); 
     assertEquals("", StringUtils.getCommonPrefix("", "")); 
     assertEquals("", StringUtils.getCommonPrefix("", null)); 
     assertEquals("", StringUtils.getCommonPrefix("abc", null, null)); 
     assertEquals("", StringUtils.getCommonPrefix(null, null, "abc")); 
     assertEquals("", StringUtils.getCommonPrefix("", "abc")); 
     assertEquals("", StringUtils.getCommonPrefix("abc", "")); 
     assertEquals("abc", StringUtils.getCommonPrefix("abc", "abc")); 
     assertEquals("a", StringUtils.getCommonPrefix("abc", "a")); 
     assertEquals("ab", StringUtils.getCommonPrefix("ab", "abxyz")); 
     assertEquals("ab", StringUtils.getCommonPrefix("abcde", "abxyz")); 
     assertEquals("", StringUtils.getCommonPrefix("abcde", "xyz")); 
     assertEquals("", StringUtils.getCommonPrefix("xyz", "abcde")); 
     assertEquals("i am a ", StringUtils.getCommonPrefix("i am a machine", "i am a robot")); 
 }
@Test
public void testJoin_ArrayOfLongs6716() { 
     assertEquals(null, StringUtils.join((long[]) null, ',')); 
     assertEquals("1;2", StringUtils.join(LONG_PRIM_LIST, SEPARATOR_CHAR)); 
     assertEquals("2", StringUtils.join(LONG_PRIM_LIST, SEPARATOR_CHAR, 1, 2)); 
 }
@Test
public void testRemoveEndIgnoreCase6743() { 
     assertNull("removeEndIgnoreCase(null, null)", StringUtils.removeEndIgnoreCase(null, null)); 
     assertNull("removeEndIgnoreCase(null, \"\")", StringUtils.removeEndIgnoreCase(null, "")); 
     assertNull("removeEndIgnoreCase(null, \"a\")", StringUtils.removeEndIgnoreCase(null, "a")); 
     assertEquals("removeEndIgnoreCase(\"\", null)", StringUtils.removeEndIgnoreCase("", null), ""); 
     assertEquals("removeEndIgnoreCase(\"\", \"\")", StringUtils.removeEndIgnoreCase("", ""), ""); 
     assertEquals("removeEndIgnoreCase(\"\", \"a\")", StringUtils.removeEndIgnoreCase("", "a"), ""); 
     assertEquals("removeEndIgnoreCase(\"www.domain.com.\", \".com\")", StringUtils.removeEndIgnoreCase("www.domain.com.", ".com"), "www.domain.com."); 
     assertEquals("removeEndIgnoreCase(\"www.domain.com\", \".com\")", StringUtils.removeEndIgnoreCase("www.domain.com", ".com"), "www.domain"); 
     assertEquals("removeEndIgnoreCase(\"www.domain\", \".com\")", StringUtils.removeEndIgnoreCase("www.domain", ".com"), "www.domain"); 
     assertEquals("removeEndIgnoreCase(\"domain.com\", \"\")", StringUtils.removeEndIgnoreCase("domain.com", ""), "domain.com"); 
     assertEquals("removeEndIgnoreCase(\"domain.com\", null)", StringUtils.removeEndIgnoreCase("domain.com", null), "domain.com"); 
     assertEquals("removeEndIgnoreCase(\"www.domain.com\", \".COM\")", StringUtils.removeEndIgnoreCase("www.domain.com", ".COM"), "www.domain"); 
     assertEquals("removeEndIgnoreCase(\"www.domain.COM\", \".com\")", StringUtils.removeEndIgnoreCase("www.domain.COM", ".com"), "www.domain"); 
 }
@Test
public void testDifference_StringString6752() { 
     assertEquals(null, StringUtils.difference(null, null)); 
     assertEquals("", StringUtils.difference("", "")); 
     assertEquals("abc", StringUtils.difference("", "abc")); 
     assertEquals("", StringUtils.difference("abc", "")); 
     assertEquals("i am a robot", StringUtils.difference(null, "i am a robot")); 
     assertEquals("i am a machine", StringUtils.difference("i am a machine", null)); 
     assertEquals("robot", StringUtils.difference("i am a machine", "i am a robot")); 
     assertEquals("", StringUtils.difference("abc", "abc")); 
     assertEquals("you are a robot", StringUtils.difference("i am a robot", "you are a robot")); 
 }
@Test
public void testCenter_StringIntChar6755() { 
     assertEquals(null, StringUtils.center(null, -1, ' ')); 
     assertEquals(null, StringUtils.center(null, 4, ' ')); 
     assertEquals("    ", StringUtils.center("", 4, ' ')); 
     assertEquals("ab", StringUtils.center("ab", 0, ' ')); 
     assertEquals("ab", StringUtils.center("ab", -1, ' ')); 
     assertEquals("ab", StringUtils.center("ab", 1, ' ')); 
     assertEquals("    ", StringUtils.center("", 4, ' ')); 
     assertEquals(" ab ", StringUtils.center("ab", 4, ' ')); 
     assertEquals("abcd", StringUtils.center("abcd", 2, ' ')); 
     assertEquals(" a  ", StringUtils.center("a", 4, ' ')); 
     assertEquals("  a  ", StringUtils.center("a", 5, ' ')); 
     assertEquals("xxaxx", StringUtils.center("a", 5, 'x')); 
 }
@Test
public void testJoin_IterableChar6789() { 
     assertEquals(null, StringUtils.join((Iterable<?>) null, ',')); 
     assertEquals(TEXT_LIST_CHAR, StringUtils.join(Arrays.asList(ARRAY_LIST), SEPARATOR_CHAR)); 
     assertEquals("", StringUtils.join(Arrays.asList(NULL_ARRAY_LIST), SEPARATOR_CHAR)); 
     assertEquals("", StringUtils.join(Arrays.asList(EMPTY_ARRAY_LIST), SEPARATOR_CHAR)); 
     assertEquals("foo", StringUtils.join(Collections.singleton("foo"), 'x')); 
 }
@Test
public void testRightPad_StringInt6790() { 
     assertEquals(null, StringUtils.rightPad(null, 5)); 
     assertEquals("     ", StringUtils.rightPad("", 5)); 
     assertEquals("abc  ", StringUtils.rightPad("abc", 5)); 
     assertEquals("abc", StringUtils.rightPad("abc", 2)); 
     assertEquals("abc", StringUtils.rightPad("abc", -1)); 
 }
@Test
public void testToString6806() throws UnsupportedEncodingException { 
     final String expectedString = "The quick brown fox jumped over the lazy dog."; 
     String encoding = SystemUtils.FILE_ENCODING; 
     byte[] expectedBytes = expectedString.getBytes(encoding); 
     assertArrayEquals(expectedBytes, expectedString.getBytes()); 
     assertEquals(expectedString, StringUtils.toString(expectedBytes, null)); 
     assertEquals(expectedString, StringUtils.toString(expectedBytes, encoding)); 
     encoding = "UTF-16"; 
     expectedBytes = expectedString.getBytes(encoding); 
     assertEquals(expectedString, StringUtils.toString(expectedBytes, encoding)); 
 }
@Test
public void testIsAllUpperCase6834() { 
     assertFalse(StringUtils.isAllUpperCase(null)); 
     assertFalse(StringUtils.isAllUpperCase(StringUtils.EMPTY)); 
     assertTrue(StringUtils.isAllUpperCase("ABC")); 
     assertFalse(StringUtils.isAllUpperCase("ABC ")); 
     assertFalse(StringUtils.isAllUpperCase("aBC")); 
 }
@Test
public void testAbbreviate_StringIntInt6838() { 
     assertEquals(null, StringUtils.abbreviate(null, 10, 12)); 
     assertEquals("", StringUtils.abbreviate("", 0, 10)); 
     assertEquals("", StringUtils.abbreviate("", 2, 10)); 
     try { 
         @SuppressWarnings("unused") 
         final String res = StringUtils.abbreviate("abcdefghij", 0, 3); 
         fail("StringUtils.abbreviate expecting IllegalArgumentException"); 
     } catch (final IllegalArgumentException ex) { 
     } 
     try { 
         @SuppressWarnings("unused") 
         final String res = StringUtils.abbreviate("abcdefghij", 5, 6); 
         fail("StringUtils.abbreviate expecting IllegalArgumentException"); 
     } catch (final IllegalArgumentException ex) { 
     } 
     final String raspberry = "raspberry peach"; 
     assertEquals("raspberry peach", StringUtils.abbreviate(raspberry, 11, 15)); 
     assertEquals(null, StringUtils.abbreviate(null, 7, 14)); 
     assertAbbreviateWithOffset("abcdefg...", -1, 10); 
     assertAbbreviateWithOffset("abcdefg...", 0, 10); 
     assertAbbreviateWithOffset("abcdefg...", 1, 10); 
     assertAbbreviateWithOffset("abcdefg...", 2, 10); 
     assertAbbreviateWithOffset("abcdefg...", 3, 10); 
     assertAbbreviateWithOffset("abcdefg...", 4, 10); 
     assertAbbreviateWithOffset("...fghi...", 5, 10); 
     assertAbbreviateWithOffset("...ghij...", 6, 10); 
     assertAbbreviateWithOffset("...hijk...", 7, 10); 
     assertAbbreviateWithOffset("...ijklmno", 8, 10); 
     assertAbbreviateWithOffset("...ijklmno", 9, 10); 
     assertAbbreviateWithOffset("...ijklmno", 10, 10); 
     assertAbbreviateWithOffset("...ijklmno", 10, 10); 
     assertAbbreviateWithOffset("...ijklmno", 11, 10); 
     assertAbbreviateWithOffset("...ijklmno", 12, 10); 
     assertAbbreviateWithOffset("...ijklmno", 13, 10); 
     assertAbbreviateWithOffset("...ijklmno", 14, 10); 
     assertAbbreviateWithOffset("...ijklmno", 15, 10); 
     assertAbbreviateWithOffset("...ijklmno", 16, 10); 
     assertAbbreviateWithOffset("...ijklmno", Integer.MAX_VALUE, 10); 
 }
@Test
public void testReplace_StringStringArrayStringArray6844() { 
     assertNull(StringUtils.replaceEach(null, new String[] { "a" }, new String[] { "b" })); 
     assertEquals(StringUtils.replaceEach("", new String[] { "a" }, new String[] { "b" }), ""); 
     assertEquals(StringUtils.replaceEach("aba", null, null), "aba"); 
     assertEquals(StringUtils.replaceEach("aba", new String[0], null), "aba"); 
     assertEquals(StringUtils.replaceEach("aba", null, new String[0]), "aba"); 
     assertEquals(StringUtils.replaceEach("aba", new String[] { "a" }, null), "aba"); 
     assertEquals(StringUtils.replaceEach("aba", new String[] { "a" }, new String[] { "" }), "b"); 
     assertEquals(StringUtils.replaceEach("aba", new String[] { null }, new String[] { "a" }), "aba"); 
     assertEquals(StringUtils.replaceEach("abcde", new String[] { "ab", "d" }, new String[] { "w", "t" }), "wcte"); 
     assertEquals(StringUtils.replaceEach("abcde", new String[] { "ab", "d" }, new String[] { "d", "t" }), "dcte"); 
     assertEquals("bcc", StringUtils.replaceEach("abc", new String[] { "a", "b" }, new String[] { "b", "c" })); 
     assertEquals("q651.506bera", StringUtils.replaceEach("d216.102oren", new String[] { "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "1", "2", "3", "4", "5", "6", "7", "8", "9" }, new String[] { "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z", "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "5", "6", "7", "8", "9", "1", "2", "3", "4" })); 
     assertEquals(StringUtils.replaceEach("aba", new String[] { "a" }, new String[] { null }), "aba"); 
     assertEquals(StringUtils.replaceEach("aba", new String[] { "a", "b" }, new String[] { "c", null }), "cbc"); 
 }
@Test
public void testSplit_String6893() { 
     assertArrayEquals(null, StringUtils.split(null)); 
     assertEquals(0, StringUtils.split("").length); 
     String str = "a b  .c"; 
     String[] res = StringUtils.split(str); 
     assertEquals(3, res.length); 
     assertEquals("a", res[0]); 
     assertEquals("b", res[1]); 
     assertEquals(".c", res[2]); 
     str = " a "; 
     res = StringUtils.split(str); 
     assertEquals(1, res.length); 
     assertEquals("a", res[0]); 
     str = "a" + WHITESPACE + "b" + NON_WHITESPACE + "c"; 
     res = StringUtils.split(str); 
     assertEquals(2, res.length); 
     assertEquals("a", res[0]); 
     assertEquals("b" + NON_WHITESPACE + "c", res[1]); 
 }
@Test
public void testJoin_IterableString6900() { 
     assertEquals(null, StringUtils.join((Iterable<?>) null, null)); 
     assertEquals(TEXT_LIST_NOSEP, StringUtils.join(Arrays.asList(ARRAY_LIST), null)); 
     assertEquals(TEXT_LIST_NOSEP, StringUtils.join(Arrays.asList(ARRAY_LIST), "")); 
     assertEquals("foo", StringUtils.join(Collections.singleton("foo"), "x")); 
     assertEquals("foo", StringUtils.join(Collections.singleton("foo"), null)); 
     assertEquals("", StringUtils.join(Arrays.asList(NULL_ARRAY_LIST), null)); 
     assertEquals("", StringUtils.join(Arrays.asList(EMPTY_ARRAY_LIST), null)); 
     assertEquals("", StringUtils.join(Arrays.asList(EMPTY_ARRAY_LIST), "")); 
     assertEquals("", StringUtils.join(Arrays.asList(EMPTY_ARRAY_LIST), SEPARATOR)); 
     assertEquals(TEXT_LIST, StringUtils.join(Arrays.asList(ARRAY_LIST), SEPARATOR)); 
 }
@Test
public void testJoin_ArrayOfFloats6902() { 
     assertEquals(null, StringUtils.join((float[]) null, ',')); 
     assertEquals("1.0;2.0", StringUtils.join(FLOAT_PRIM_LIST, SEPARATOR_CHAR)); 
     assertEquals("2.0", StringUtils.join(FLOAT_PRIM_LIST, SEPARATOR_CHAR, 1, 2)); 
 }
@Test
public void testReplaceChars_StringStringString6904() { 
     assertEquals(null, StringUtils.replaceChars(null, null, null)); 
     assertEquals(null, StringUtils.replaceChars(null, "", null)); 
     assertEquals(null, StringUtils.replaceChars(null, "a", null)); 
     assertEquals(null, StringUtils.replaceChars(null, null, "")); 
     assertEquals(null, StringUtils.replaceChars(null, null, "x")); 
     assertEquals("", StringUtils.replaceChars("", null, null)); 
     assertEquals("", StringUtils.replaceChars("", "", null)); 
     assertEquals("", StringUtils.replaceChars("", "a", null)); 
     assertEquals("", StringUtils.replaceChars("", null, "")); 
     assertEquals("", StringUtils.replaceChars("", null, "x")); 
     assertEquals("abc", StringUtils.replaceChars("abc", null, null)); 
     assertEquals("abc", StringUtils.replaceChars("abc", null, "")); 
     assertEquals("abc", StringUtils.replaceChars("abc", null, "x")); 
     assertEquals("abc", StringUtils.replaceChars("abc", "", null)); 
     assertEquals("abc", StringUtils.replaceChars("abc", "", "")); 
     assertEquals("abc", StringUtils.replaceChars("abc", "", "x")); 
     assertEquals("ac", StringUtils.replaceChars("abc", "b", null)); 
     assertEquals("ac", StringUtils.replaceChars("abc", "b", "")); 
     assertEquals("axc", StringUtils.replaceChars("abc", "b", "x")); 
     assertEquals("ayzya", StringUtils.replaceChars("abcba", "bc", "yz")); 
     assertEquals("ayya", StringUtils.replaceChars("abcba", "bc", "y")); 
     assertEquals("ayzya", StringUtils.replaceChars("abcba", "bc", "yzx")); 
     assertEquals("abcba", StringUtils.replaceChars("abcba", "z", "w")); 
     assertSame("abcba", StringUtils.replaceChars("abcba", "z", "w")); 
     assertEquals("jelly", StringUtils.replaceChars("hello", "ho", "jy")); 
     assertEquals("ayzya", StringUtils.replaceChars("abcba", "bc", "yz")); 
     assertEquals("ayya", StringUtils.replaceChars("abcba", "bc", "y")); 
     assertEquals("ayzya", StringUtils.replaceChars("abcba", "bc", "yzx")); 
     assertEquals("bcc", StringUtils.replaceChars("abc", "ab", "bc")); 
     assertEquals("q651.506bera", StringUtils.replaceChars("d216.102oren", "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ123456789", "nopqrstuvwxyzabcdefghijklmNOPQRSTUVWXYZABCDEFGHIJKLM567891234")); 
 }
@Test
public void testLang6236905() { 
     assertEquals("t", StringUtils.replaceChars("\u00DE", '\u00DE', 't')); 
     assertEquals("t", StringUtils.replaceChars("\u00FE", '\u00FE', 't')); 
 }
@Test
public void testRepeat_StringInt6907() { 
     assertEquals(null, StringUtils.repeat(null, 2)); 
     assertEquals("", StringUtils.repeat("ab", 0)); 
     assertEquals("", StringUtils.repeat("", 3)); 
     assertEquals("aaa", StringUtils.repeat("a", 3)); 
     assertEquals("ababab", StringUtils.repeat("ab", 3)); 
     assertEquals("abcabcabc", StringUtils.repeat("abc", 3)); 
     final String str = StringUtils.repeat("a", 10000); 
     assertEquals(10000, str.length()); 
     assertTrue(StringUtils.containsOnly(str, new char[] { 'a' })); 
 }
@Test
public void testGetLevenshteinDistance_StringStringInt6913() { 
     assertEquals(0, StringUtils.getLevenshteinDistance("", "", 0)); 
     assertEquals(7, StringUtils.getLevenshteinDistance("aaapppp", "", 8)); 
     assertEquals(7, StringUtils.getLevenshteinDistance("aaapppp", "", 7)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("aaapppp", "", 6)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("b", "a", 0)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("a", "b", 0)); 
     assertEquals(0, StringUtils.getLevenshteinDistance("aa", "aa", 0)); 
     assertEquals(0, StringUtils.getLevenshteinDistance("aa", "aa", 2)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("aaa", "bbb", 2)); 
     assertEquals(3, StringUtils.getLevenshteinDistance("aaa", "bbb", 3)); 
     assertEquals(6, StringUtils.getLevenshteinDistance("aaaaaa", "b", 10)); 
     assertEquals(7, StringUtils.getLevenshteinDistance("aaapppp", "b", 8)); 
     assertEquals(3, StringUtils.getLevenshteinDistance("a", "bbb", 4)); 
     assertEquals(7, StringUtils.getLevenshteinDistance("aaapppp", "b", 7)); 
     assertEquals(3, StringUtils.getLevenshteinDistance("a", "bbb", 3)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("a", "bbb", 2)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("bbb", "a", 2)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("aaapppp", "b", 6)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("a", "bbb", 1)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("bbb", "a", 1)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("12345", "1234567", 1)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("1234567", "12345", 1)); 
     assertEquals(1, StringUtils.getLevenshteinDistance("frog", "fog", 1)); 
     assertEquals(3, StringUtils.getLevenshteinDistance("fly", "ant", 3)); 
     assertEquals(7, StringUtils.getLevenshteinDistance("elephant", "hippo", 7)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("elephant", "hippo", 6)); 
     assertEquals(7, StringUtils.getLevenshteinDistance("hippo", "elephant", 7)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("hippo", "elephant", 6)); 
     assertEquals(8, StringUtils.getLevenshteinDistance("hippo", "zzzzzzzz", 8)); 
     assertEquals(8, StringUtils.getLevenshteinDistance("zzzzzzzz", "hippo", 8)); 
     assertEquals(1, StringUtils.getLevenshteinDistance("hello", "hallo", 1)); 
     try { 
         @SuppressWarnings("unused") 
         final int d = StringUtils.getLevenshteinDistance("a", null, 0); 
         fail("expecting IllegalArgumentException"); 
     } catch (final IllegalArgumentException ex) { 
     } 
     try { 
         @SuppressWarnings("unused") 
         final int d = StringUtils.getLevenshteinDistance(null, "a", 0); 
         fail("expecting IllegalArgumentException"); 
     } catch (final IllegalArgumentException ex) { 
     } 
     try { 
         @SuppressWarnings("unused") 
         final int d = StringUtils.getLevenshteinDistance("a", "a", -1); 
         fail("expecting IllegalArgumentException"); 
     } catch (final IllegalArgumentException ex) { 
     } 
 }
@Test
public void testReplace_StringStringArrayStringArray6921() { 
     assertNull(StringUtils.replaceEach(null, new String[] { "a" }, new String[] { "b" })); 
     assertEquals(StringUtils.replaceEach("", new String[] { "a" }, new String[] { "b" }), ""); 
     assertEquals(StringUtils.replaceEach("aba", null, null), "aba"); 
     assertEquals(StringUtils.replaceEach("aba", new String[0], null), "aba"); 
     assertEquals(StringUtils.replaceEach("aba", null, new String[0]), "aba"); 
     assertEquals(StringUtils.replaceEach("aba", new String[] { "a" }, null), "aba"); 
     assertEquals(StringUtils.replaceEach("aba", new String[] { "a" }, new String[] { "" }), "b"); 
     assertEquals(StringUtils.replaceEach("aba", new String[] { null }, new String[] { "a" }), "aba"); 
     assertEquals(StringUtils.replaceEach("abcde", new String[] { "ab", "d" }, new String[] { "w", "t" }), "wcte"); 
     assertEquals(StringUtils.replaceEach("abcde", new String[] { "ab", "d" }, new String[] { "d", "t" }), "dcte"); 
     assertEquals("bcc", StringUtils.replaceEach("abc", new String[] { "a", "b" }, new String[] { "b", "c" })); 
     assertEquals("q651.506bera", StringUtils.replaceEach("d216.102oren", new String[] { "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "1", "2", "3", "4", "5", "6", "7", "8", "9" }, new String[] { "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z", "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "5", "6", "7", "8", "9", "1", "2", "3", "4" })); 
     assertEquals(StringUtils.replaceEach("aba", new String[] { "a" }, new String[] { null }), "aba"); 
     assertEquals(StringUtils.replaceEach("aba", new String[] { "a", "b" }, new String[] { "c", null }), "cbc"); 
 }
@Test
public void testRemove_char6923() { 
     assertEquals(null, StringUtils.remove(null, 'a')); 
     assertEquals(null, StringUtils.remove(null, 'a')); 
     assertEquals(null, StringUtils.remove(null, 'a')); 
     assertEquals("", StringUtils.remove("", 'a')); 
     assertEquals("", StringUtils.remove("", 'a')); 
     assertEquals("", StringUtils.remove("", 'a')); 
     assertEquals("qeed", StringUtils.remove("queued", 'u')); 
     assertEquals("queued", StringUtils.remove("queued", 'z')); 
 }
@Test
public void testPrependIfMissingIgnoreCase6932() { 
     assertEquals("prependIfMissingIgnoreCase(null,null)", null, StringUtils.prependIfMissingIgnoreCase(null, null)); 
     assertEquals("prependIfMissingIgnoreCase(abc,null)", "abc", StringUtils.prependIfMissingIgnoreCase("abc", null)); 
     assertEquals("prependIfMissingIgnoreCase(\"\",xyz)", "xyz", StringUtils.prependIfMissingIgnoreCase("", "xyz")); 
     assertEquals("prependIfMissingIgnoreCase(abc,xyz)", "xyzabc", StringUtils.prependIfMissingIgnoreCase("abc", "xyz")); 
     assertEquals("prependIfMissingIgnoreCase(xyzabc,xyz)", "xyzabc", StringUtils.prependIfMissingIgnoreCase("xyzabc", "xyz")); 
     assertEquals("prependIfMissingIgnoreCase(XYZabc,xyz)", "XYZabc", StringUtils.prependIfMissingIgnoreCase("XYZabc", "xyz")); 
     assertEquals("prependIfMissingIgnoreCase(null,null null)", null, StringUtils.prependIfMissingIgnoreCase(null, null, (CharSequence[]) null)); 
     assertEquals("prependIfMissingIgnoreCase(abc,null,null)", "abc", StringUtils.prependIfMissingIgnoreCase("abc", null, (CharSequence[]) null)); 
     assertEquals("prependIfMissingIgnoreCase(\"\",xyz,null)", "xyz", StringUtils.prependIfMissingIgnoreCase("", "xyz", (CharSequence[]) null)); 
     assertEquals("prependIfMissingIgnoreCase(abc,xyz,{null})", "xyzabc", StringUtils.prependIfMissingIgnoreCase("abc", "xyz", new CharSequence[] { null })); 
     assertEquals("prependIfMissingIgnoreCase(abc,xyz,\"\")", "abc", StringUtils.prependIfMissingIgnoreCase("abc", "xyz", "")); 
     assertEquals("prependIfMissingIgnoreCase(abc,xyz,mno)", "xyzabc", StringUtils.prependIfMissingIgnoreCase("abc", "xyz", "mno")); 
     assertEquals("prependIfMissingIgnoreCase(xyzabc,xyz,mno)", "xyzabc", StringUtils.prependIfMissingIgnoreCase("xyzabc", "xyz", "mno")); 
     assertEquals("prependIfMissingIgnoreCase(mnoabc,xyz,mno)", "mnoabc", StringUtils.prependIfMissingIgnoreCase("mnoabc", "xyz", "mno")); 
     assertEquals("prependIfMissingIgnoreCase(XYZabc,xyz,mno)", "XYZabc", StringUtils.prependIfMissingIgnoreCase("XYZabc", "xyz", "mno")); 
     assertEquals("prependIfMissingIgnoreCase(MNOabc,xyz,mno)", "MNOabc", StringUtils.prependIfMissingIgnoreCase("MNOabc", "xyz", "mno")); 
 }
@Test
public void testJoin_ArrayOfShorts6942() { 
     assertEquals(null, StringUtils.join((short[]) null, ',')); 
     assertEquals("1;2", StringUtils.join(SHORT_PRIM_LIST, SEPARATOR_CHAR)); 
     assertEquals("2", StringUtils.join(SHORT_PRIM_LIST, SEPARATOR_CHAR, 1, 2)); 
 }
@Test
public void testReplace_StringStringArrayStringArray6959() { 
     assertNull(StringUtils.replaceEach(null, new String[] { "a" }, new String[] { "b" })); 
     assertEquals(StringUtils.replaceEach("", new String[] { "a" }, new String[] { "b" }), ""); 
     assertEquals(StringUtils.replaceEach("aba", null, null), "aba"); 
     assertEquals(StringUtils.replaceEach("aba", new String[0], null), "aba"); 
     assertEquals(StringUtils.replaceEach("aba", null, new String[0]), "aba"); 
     assertEquals(StringUtils.replaceEach("aba", new String[] { "a" }, null), "aba"); 
     assertEquals(StringUtils.replaceEach("aba", new String[] { "a" }, new String[] { "" }), "b"); 
     assertEquals(StringUtils.replaceEach("aba", new String[] { null }, new String[] { "a" }), "aba"); 
     assertEquals(StringUtils.replaceEach("abcde", new String[] { "ab", "d" }, new String[] { "w", "t" }), "wcte"); 
     assertEquals(StringUtils.replaceEach("abcde", new String[] { "ab", "d" }, new String[] { "d", "t" }), "dcte"); 
     assertEquals("bcc", StringUtils.replaceEach("abc", new String[] { "a", "b" }, new String[] { "b", "c" })); 
     assertEquals("q651.506bera", StringUtils.replaceEach("d216.102oren", new String[] { "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "1", "2", "3", "4", "5", "6", "7", "8", "9" }, new String[] { "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z", "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "5", "6", "7", "8", "9", "1", "2", "3", "4" })); 
     assertEquals(StringUtils.replaceEach("aba", new String[] { "a" }, new String[] { null }), "aba"); 
     assertEquals(StringUtils.replaceEach("aba", new String[] { "a", "b" }, new String[] { "c", null }), "cbc"); 
 }
@Test
public void testJoin_IterableString6964() { 
     assertEquals(null, StringUtils.join((Iterable<?>) null, null)); 
     assertEquals(TEXT_LIST_NOSEP, StringUtils.join(Arrays.asList(ARRAY_LIST), null)); 
     assertEquals(TEXT_LIST_NOSEP, StringUtils.join(Arrays.asList(ARRAY_LIST), "")); 
     assertEquals("foo", StringUtils.join(Collections.singleton("foo"), "x")); 
     assertEquals("foo", StringUtils.join(Collections.singleton("foo"), null)); 
     assertEquals("", StringUtils.join(Arrays.asList(NULL_ARRAY_LIST), null)); 
     assertEquals("", StringUtils.join(Arrays.asList(EMPTY_ARRAY_LIST), null)); 
     assertEquals("", StringUtils.join(Arrays.asList(EMPTY_ARRAY_LIST), "")); 
     assertEquals("", StringUtils.join(Arrays.asList(EMPTY_ARRAY_LIST), SEPARATOR)); 
     assertEquals(TEXT_LIST, StringUtils.join(Arrays.asList(ARRAY_LIST), SEPARATOR)); 
 }
@Test
public void testJoin_IteratorChar6978() { 
     assertEquals(null, StringUtils.join((Iterator<?>) null, ',')); 
     assertEquals(TEXT_LIST_CHAR, StringUtils.join(Arrays.asList(ARRAY_LIST).iterator(), SEPARATOR_CHAR)); 
     assertEquals("", StringUtils.join(Arrays.asList(NULL_ARRAY_LIST).iterator(), SEPARATOR_CHAR)); 
     assertEquals("", StringUtils.join(Arrays.asList(EMPTY_ARRAY_LIST).iterator(), SEPARATOR_CHAR)); 
     assertEquals("foo", StringUtils.join(Collections.singleton("foo").iterator(), 'x')); 
 }
@Test
public void testSplit_StringChar6983() { 
     assertArrayEquals(null, StringUtils.split(null, '.')); 
     assertEquals(0, StringUtils.split("", '.').length); 
     String str = "a.b.. c"; 
     String[] res = StringUtils.split(str, '.'); 
     assertEquals(3, res.length); 
     assertEquals("a", res[0]); 
     assertEquals("b", res[1]); 
     assertEquals(" c", res[2]); 
     str = ".a."; 
     res = StringUtils.split(str, '.'); 
     assertEquals(1, res.length); 
     assertEquals("a", res[0]); 
     str = "a b c"; 
     res = StringUtils.split(str, ' '); 
     assertEquals(3, res.length); 
     assertEquals("a", res[0]); 
     assertEquals("b", res[1]); 
     assertEquals("c", res[2]); 
 }
@Test
public void testDefaultIfBlank_StringBuffers6989() { 
     assertEquals("NULL", StringUtils.defaultIfBlank(new StringBuffer(""), new StringBuffer("NULL")).toString()); 
     assertEquals("NULL", StringUtils.defaultIfBlank(new StringBuffer(" "), new StringBuffer("NULL")).toString()); 
     assertEquals("abc", StringUtils.defaultIfBlank(new StringBuffer("abc"), new StringBuffer("NULL")).toString()); 
     assertNull(StringUtils.defaultIfBlank(new StringBuffer(""), null)); 
     final StringBuffer s = StringUtils.defaultIfBlank(new StringBuffer("abc"), new StringBuffer("NULL")); 
     assertEquals("abc", s.toString()); 
 }
@Test
public void testGetLevenshteinDistance_StringStringInt7007() { 
     assertEquals(0, StringUtils.getLevenshteinDistance("", "", 0)); 
     assertEquals(7, StringUtils.getLevenshteinDistance("aaapppp", "", 8)); 
     assertEquals(7, StringUtils.getLevenshteinDistance("aaapppp", "", 7)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("aaapppp", "", 6)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("b", "a", 0)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("a", "b", 0)); 
     assertEquals(0, StringUtils.getLevenshteinDistance("aa", "aa", 0)); 
     assertEquals(0, StringUtils.getLevenshteinDistance("aa", "aa", 2)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("aaa", "bbb", 2)); 
     assertEquals(3, StringUtils.getLevenshteinDistance("aaa", "bbb", 3)); 
     assertEquals(6, StringUtils.getLevenshteinDistance("aaaaaa", "b", 10)); 
     assertEquals(7, StringUtils.getLevenshteinDistance("aaapppp", "b", 8)); 
     assertEquals(3, StringUtils.getLevenshteinDistance("a", "bbb", 4)); 
     assertEquals(7, StringUtils.getLevenshteinDistance("aaapppp", "b", 7)); 
     assertEquals(3, StringUtils.getLevenshteinDistance("a", "bbb", 3)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("a", "bbb", 2)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("bbb", "a", 2)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("aaapppp", "b", 6)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("a", "bbb", 1)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("bbb", "a", 1)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("12345", "1234567", 1)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("1234567", "12345", 1)); 
     assertEquals(1, StringUtils.getLevenshteinDistance("frog", "fog", 1)); 
     assertEquals(3, StringUtils.getLevenshteinDistance("fly", "ant", 3)); 
     assertEquals(7, StringUtils.getLevenshteinDistance("elephant", "hippo", 7)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("elephant", "hippo", 6)); 
     assertEquals(7, StringUtils.getLevenshteinDistance("hippo", "elephant", 7)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("hippo", "elephant", 6)); 
     assertEquals(8, StringUtils.getLevenshteinDistance("hippo", "zzzzzzzz", 8)); 
     assertEquals(8, StringUtils.getLevenshteinDistance("zzzzzzzz", "hippo", 8)); 
     assertEquals(1, StringUtils.getLevenshteinDistance("hello", "hallo", 1)); 
     try { 
         @SuppressWarnings("unused") 
         final int d = StringUtils.getLevenshteinDistance("a", null, 0); 
         fail("expecting IllegalArgumentException"); 
     } catch (final IllegalArgumentException ex) { 
     } 
     try { 
         @SuppressWarnings("unused") 
         final int d = StringUtils.getLevenshteinDistance(null, "a", 0); 
         fail("expecting IllegalArgumentException"); 
     } catch (final IllegalArgumentException ex) { 
     } 
     try { 
         @SuppressWarnings("unused") 
         final int d = StringUtils.getLevenshteinDistance("a", "a", -1); 
         fail("expecting IllegalArgumentException"); 
     } catch (final IllegalArgumentException ex) { 
     } 
 }
@Test
public void testRepeat_StringStringInt7009() { 
     assertEquals(null, StringUtils.repeat(null, null, 2)); 
     assertEquals(null, StringUtils.repeat(null, "x", 2)); 
     assertEquals("", StringUtils.repeat("", null, 2)); 
     assertEquals("", StringUtils.repeat("ab", "", 0)); 
     assertEquals("", StringUtils.repeat("", "", 2)); 
     assertEquals("xx", StringUtils.repeat("", "x", 3)); 
     assertEquals("?, ?, ?", StringUtils.repeat("?", ", ", 3)); 
 }
@Test
public void testReplaceChars_StringStringString7013() { 
     assertEquals(null, StringUtils.replaceChars(null, null, null)); 
     assertEquals(null, StringUtils.replaceChars(null, "", null)); 
     assertEquals(null, StringUtils.replaceChars(null, "a", null)); 
     assertEquals(null, StringUtils.replaceChars(null, null, "")); 
     assertEquals(null, StringUtils.replaceChars(null, null, "x")); 
     assertEquals("", StringUtils.replaceChars("", null, null)); 
     assertEquals("", StringUtils.replaceChars("", "", null)); 
     assertEquals("", StringUtils.replaceChars("", "a", null)); 
     assertEquals("", StringUtils.replaceChars("", null, "")); 
     assertEquals("", StringUtils.replaceChars("", null, "x")); 
     assertEquals("abc", StringUtils.replaceChars("abc", null, null)); 
     assertEquals("abc", StringUtils.replaceChars("abc", null, "")); 
     assertEquals("abc", StringUtils.replaceChars("abc", null, "x")); 
     assertEquals("abc", StringUtils.replaceChars("abc", "", null)); 
     assertEquals("abc", StringUtils.replaceChars("abc", "", "")); 
     assertEquals("abc", StringUtils.replaceChars("abc", "", "x")); 
     assertEquals("ac", StringUtils.replaceChars("abc", "b", null)); 
     assertEquals("ac", StringUtils.replaceChars("abc", "b", "")); 
     assertEquals("axc", StringUtils.replaceChars("abc", "b", "x")); 
     assertEquals("ayzya", StringUtils.replaceChars("abcba", "bc", "yz")); 
     assertEquals("ayya", StringUtils.replaceChars("abcba", "bc", "y")); 
     assertEquals("ayzya", StringUtils.replaceChars("abcba", "bc", "yzx")); 
     assertEquals("abcba", StringUtils.replaceChars("abcba", "z", "w")); 
     assertSame("abcba", StringUtils.replaceChars("abcba", "z", "w")); 
     assertEquals("jelly", StringUtils.replaceChars("hello", "ho", "jy")); 
     assertEquals("ayzya", StringUtils.replaceChars("abcba", "bc", "yz")); 
     assertEquals("ayya", StringUtils.replaceChars("abcba", "bc", "y")); 
     assertEquals("ayzya", StringUtils.replaceChars("abcba", "bc", "yzx")); 
     assertEquals("bcc", StringUtils.replaceChars("abc", "ab", "bc")); 
     assertEquals("q651.506bera", StringUtils.replaceChars("d216.102oren", "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ123456789", "nopqrstuvwxyzabcdefghijklmNOPQRSTUVWXYZABCDEFGHIJKLM567891234")); 
 }
@Test
public void testSwapCase_String7039() { 
     assertEquals(null, StringUtils.swapCase(null)); 
     assertEquals("", StringUtils.swapCase("")); 
     assertEquals("  ", StringUtils.swapCase("  ")); 
     assertEquals("i", WordUtils.swapCase("I")); 
     assertEquals("I", WordUtils.swapCase("i")); 
     assertEquals("I AM HERE 123", StringUtils.swapCase("i am here 123")); 
     assertEquals("i aM hERE 123", StringUtils.swapCase("I Am Here 123")); 
     assertEquals("I AM here 123", StringUtils.swapCase("i am HERE 123")); 
     assertEquals("i am here 123", StringUtils.swapCase("I AM HERE 123")); 
     final String test = "This String contains a TitleCase character: \u01C8"; 
     final String expect = "tHIS sTRING CONTAINS A tITLEcASE CHARACTER: \u01C9"; 
     assertEquals(expect, WordUtils.swapCase(test)); 
 }
@Test
public void testOverlay_StringStringIntInt7051() { 
     assertEquals(null, StringUtils.overlay(null, null, 2, 4)); 
     assertEquals(null, StringUtils.overlay(null, null, -2, -4)); 
     assertEquals("", StringUtils.overlay("", null, 0, 0)); 
     assertEquals("", StringUtils.overlay("", "", 0, 0)); 
     assertEquals("zzzz", StringUtils.overlay("", "zzzz", 0, 0)); 
     assertEquals("zzzz", StringUtils.overlay("", "zzzz", 2, 4)); 
     assertEquals("zzzz", StringUtils.overlay("", "zzzz", -2, -4)); 
     assertEquals("abef", StringUtils.overlay("abcdef", null, 2, 4)); 
     assertEquals("abef", StringUtils.overlay("abcdef", null, 4, 2)); 
     assertEquals("abef", StringUtils.overlay("abcdef", "", 2, 4)); 
     assertEquals("abef", StringUtils.overlay("abcdef", "", 4, 2)); 
     assertEquals("abzzzzef", StringUtils.overlay("abcdef", "zzzz", 2, 4)); 
     assertEquals("abzzzzef", StringUtils.overlay("abcdef", "zzzz", 4, 2)); 
     assertEquals("zzzzef", StringUtils.overlay("abcdef", "zzzz", -1, 4)); 
     assertEquals("zzzzef", StringUtils.overlay("abcdef", "zzzz", 4, -1)); 
     assertEquals("zzzzabcdef", StringUtils.overlay("abcdef", "zzzz", -2, -1)); 
     assertEquals("zzzzabcdef", StringUtils.overlay("abcdef", "zzzz", -1, -2)); 
     assertEquals("abcdzzzz", StringUtils.overlay("abcdef", "zzzz", 4, 10)); 
     assertEquals("abcdzzzz", StringUtils.overlay("abcdef", "zzzz", 10, 4)); 
     assertEquals("abcdefzzzz", StringUtils.overlay("abcdef", "zzzz", 8, 10)); 
     assertEquals("abcdefzzzz", StringUtils.overlay("abcdef", "zzzz", 10, 8)); 
 }
@Test
public void testAbbreviateMiddle7062() { 
     assertNull(StringUtils.abbreviateMiddle(null, null, 0)); 
     assertEquals("abc", StringUtils.abbreviateMiddle("abc", null, 0)); 
     assertEquals("abc", StringUtils.abbreviateMiddle("abc", ".", 0)); 
     assertEquals("abc", StringUtils.abbreviateMiddle("abc", ".", 3)); 
     assertEquals("ab.f", StringUtils.abbreviateMiddle("abcdef", ".", 4)); 
     assertEquals("A very long text with un...f the text is complete.", StringUtils.abbreviateMiddle("A very long text with unimportant stuff in the middle but interesting start and " + "end to see if the text is complete.", "...", 50)); 
     final String longText = "Start text" + StringUtils.repeat("x", 10000) + "Close text"; 
     assertEquals("Start text->Close text", StringUtils.abbreviateMiddle(longText, "->", 22)); 
     assertEquals("abc", StringUtils.abbreviateMiddle("abc", ".", -1)); 
     assertEquals("abc", StringUtils.abbreviateMiddle("abc", ".", 1)); 
     assertEquals("abc", StringUtils.abbreviateMiddle("abc", ".", 2)); 
     assertEquals("a", StringUtils.abbreviateMiddle("a", ".", 1)); 
     assertEquals("a.d", StringUtils.abbreviateMiddle("abcd", ".", 3)); 
     assertEquals("a..f", StringUtils.abbreviateMiddle("abcdef", "..", 4)); 
     assertEquals("ab.ef", StringUtils.abbreviateMiddle("abcdef", ".", 5)); 
 }
@Test
public void testSplitByCharacterType7084() { 
     assertNull(StringUtils.splitByCharacterType(null)); 
     assertEquals(0, StringUtils.splitByCharacterType("").length); 
     assertTrue(ArrayUtils.isEquals(new String[] { "ab", " ", "de", " ", "fg" }, StringUtils.splitByCharacterType("ab de fg"))); 
     assertTrue(ArrayUtils.isEquals(new String[] { "ab", "   ", "de", " ", "fg" }, StringUtils.splitByCharacterType("ab   de fg"))); 
     assertTrue(ArrayUtils.isEquals(new String[] { "ab", ":", "cd", ":", "ef" }, StringUtils.splitByCharacterType("ab:cd:ef"))); 
     assertTrue(ArrayUtils.isEquals(new String[] { "number", "5" }, StringUtils.splitByCharacterType("number5"))); 
     assertTrue(ArrayUtils.isEquals(new String[] { "foo", "B", "ar" }, StringUtils.splitByCharacterType("fooBar"))); 
     assertTrue(ArrayUtils.isEquals(new String[] { "foo", "200", "B", "ar" }, StringUtils.splitByCharacterType("foo200Bar"))); 
     assertTrue(ArrayUtils.isEquals(new String[] { "ASFR", "ules" }, StringUtils.splitByCharacterType("ASFRules"))); 
 }
@Test
public void testJoin_IterableString7100() { 
     assertEquals(null, StringUtils.join((Iterable<?>) null, null)); 
     assertEquals(TEXT_LIST_NOSEP, StringUtils.join(Arrays.asList(ARRAY_LIST), null)); 
     assertEquals(TEXT_LIST_NOSEP, StringUtils.join(Arrays.asList(ARRAY_LIST), "")); 
     assertEquals("foo", StringUtils.join(Collections.singleton("foo"), "x")); 
     assertEquals("foo", StringUtils.join(Collections.singleton("foo"), null)); 
     assertEquals("", StringUtils.join(Arrays.asList(NULL_ARRAY_LIST), null)); 
     assertEquals("", StringUtils.join(Arrays.asList(EMPTY_ARRAY_LIST), null)); 
     assertEquals("", StringUtils.join(Arrays.asList(EMPTY_ARRAY_LIST), "")); 
     assertEquals("", StringUtils.join(Arrays.asList(EMPTY_ARRAY_LIST), SEPARATOR)); 
     assertEquals(TEXT_LIST, StringUtils.join(Arrays.asList(ARRAY_LIST), SEPARATOR)); 
 }
@Test
public void testGetCommonPrefix_StringArray7106() { 
     assertEquals("", StringUtils.getCommonPrefix((String[]) null)); 
     assertEquals("", StringUtils.getCommonPrefix()); 
     assertEquals("abc", StringUtils.getCommonPrefix("abc")); 
     assertEquals("", StringUtils.getCommonPrefix(null, null)); 
     assertEquals("", StringUtils.getCommonPrefix("", "")); 
     assertEquals("", StringUtils.getCommonPrefix("", null)); 
     assertEquals("", StringUtils.getCommonPrefix("abc", null, null)); 
     assertEquals("", StringUtils.getCommonPrefix(null, null, "abc")); 
     assertEquals("", StringUtils.getCommonPrefix("", "abc")); 
     assertEquals("", StringUtils.getCommonPrefix("abc", "")); 
     assertEquals("abc", StringUtils.getCommonPrefix("abc", "abc")); 
     assertEquals("a", StringUtils.getCommonPrefix("abc", "a")); 
     assertEquals("ab", StringUtils.getCommonPrefix("ab", "abxyz")); 
     assertEquals("ab", StringUtils.getCommonPrefix("abcde", "abxyz")); 
     assertEquals("", StringUtils.getCommonPrefix("abcde", "xyz")); 
     assertEquals("", StringUtils.getCommonPrefix("xyz", "abcde")); 
     assertEquals("i am a ", StringUtils.getCommonPrefix("i am a machine", "i am a robot")); 
 }
@Test
public void testDifference_StringString7112() { 
     assertEquals(null, StringUtils.difference(null, null)); 
     assertEquals("", StringUtils.difference("", "")); 
     assertEquals("abc", StringUtils.difference("", "abc")); 
     assertEquals("", StringUtils.difference("abc", "")); 
     assertEquals("i am a robot", StringUtils.difference(null, "i am a robot")); 
     assertEquals("i am a machine", StringUtils.difference("i am a machine", null)); 
     assertEquals("robot", StringUtils.difference("i am a machine", "i am a robot")); 
     assertEquals("", StringUtils.difference("abc", "abc")); 
     assertEquals("you are a robot", StringUtils.difference("i am a robot", "you are a robot")); 
 }
@Test
public void testRemovePattern7116() { 
     assertEquals("", StringUtils.removePattern("<A>x\\ny</A>", "<A>.*</A>")); 
 }
@Test
public void testPrependIfMissingIgnoreCase7160() { 
     assertEquals("prependIfMissingIgnoreCase(null,null)", null, StringUtils.prependIfMissingIgnoreCase(null, null)); 
     assertEquals("prependIfMissingIgnoreCase(abc,null)", "abc", StringUtils.prependIfMissingIgnoreCase("abc", null)); 
     assertEquals("prependIfMissingIgnoreCase(\"\",xyz)", "xyz", StringUtils.prependIfMissingIgnoreCase("", "xyz")); 
     assertEquals("prependIfMissingIgnoreCase(abc,xyz)", "xyzabc", StringUtils.prependIfMissingIgnoreCase("abc", "xyz")); 
     assertEquals("prependIfMissingIgnoreCase(xyzabc,xyz)", "xyzabc", StringUtils.prependIfMissingIgnoreCase("xyzabc", "xyz")); 
     assertEquals("prependIfMissingIgnoreCase(XYZabc,xyz)", "XYZabc", StringUtils.prependIfMissingIgnoreCase("XYZabc", "xyz")); 
     assertEquals("prependIfMissingIgnoreCase(null,null null)", null, StringUtils.prependIfMissingIgnoreCase(null, null, (CharSequence[]) null)); 
     assertEquals("prependIfMissingIgnoreCase(abc,null,null)", "abc", StringUtils.prependIfMissingIgnoreCase("abc", null, (CharSequence[]) null)); 
     assertEquals("prependIfMissingIgnoreCase(\"\",xyz,null)", "xyz", StringUtils.prependIfMissingIgnoreCase("", "xyz", (CharSequence[]) null)); 
     assertEquals("prependIfMissingIgnoreCase(abc,xyz,{null})", "xyzabc", StringUtils.prependIfMissingIgnoreCase("abc", "xyz", new CharSequence[] { null })); 
     assertEquals("prependIfMissingIgnoreCase(abc,xyz,\"\")", "abc", StringUtils.prependIfMissingIgnoreCase("abc", "xyz", "")); 
     assertEquals("prependIfMissingIgnoreCase(abc,xyz,mno)", "xyzabc", StringUtils.prependIfMissingIgnoreCase("abc", "xyz", "mno")); 
     assertEquals("prependIfMissingIgnoreCase(xyzabc,xyz,mno)", "xyzabc", StringUtils.prependIfMissingIgnoreCase("xyzabc", "xyz", "mno")); 
     assertEquals("prependIfMissingIgnoreCase(mnoabc,xyz,mno)", "mnoabc", StringUtils.prependIfMissingIgnoreCase("mnoabc", "xyz", "mno")); 
     assertEquals("prependIfMissingIgnoreCase(XYZabc,xyz,mno)", "XYZabc", StringUtils.prependIfMissingIgnoreCase("XYZabc", "xyz", "mno")); 
     assertEquals("prependIfMissingIgnoreCase(MNOabc,xyz,mno)", "MNOabc", StringUtils.prependIfMissingIgnoreCase("MNOabc", "xyz", "mno")); 
 } 
@SuppressWarnings("deprecation")
@Test
public void testChomp7175() { 
     final String[][] chompCases = { { FOO_UNCAP + "\r\n", FOO_UNCAP }, { FOO_UNCAP + "\n", FOO_UNCAP }, { FOO_UNCAP + "\r", FOO_UNCAP }, { FOO_UNCAP + " \r", FOO_UNCAP + " " }, { FOO_UNCAP, FOO_UNCAP }, { FOO_UNCAP + "\n\n", FOO_UNCAP + "\n" }, { FOO_UNCAP + "\r\n\r\n", FOO_UNCAP + "\r\n" }, { "foo\nfoo", "foo\nfoo" }, { "foo\n\rfoo", "foo\n\rfoo" }, { "\n", "" }, { "\r", "" }, { "a", "a" }, { "\r\n", "" }, { "", "" }, { null, null }, { FOO_UNCAP + "\n\r", FOO_UNCAP + "\n" } }; 
     for (final String[] chompCase : chompCases) { 
         final String original = chompCase[0]; 
         final String expectedResult = chompCase[1]; 
         assertEquals("chomp(String) failed", expectedResult, StringUtils.chomp(original)); 
     } 
     assertEquals("chomp(String, String) failed", "foo", StringUtils.chomp("foobar", "bar")); 
     assertEquals("chomp(String, String) failed", "foobar", StringUtils.chomp("foobar", "baz")); 
     assertEquals("chomp(String, String) failed", "foo", StringUtils.chomp("foo", "foooo")); 
     assertEquals("chomp(String, String) failed", "foobar", StringUtils.chomp("foobar", "")); 
     assertEquals("chomp(String, String) failed", "foobar", StringUtils.chomp("foobar", null)); 
     assertEquals("chomp(String, String) failed", "", StringUtils.chomp("", "foo")); 
     assertEquals("chomp(String, String) failed", "", StringUtils.chomp("", null)); 
     assertEquals("chomp(String, String) failed", "", StringUtils.chomp("", "")); 
     assertEquals("chomp(String, String) failed", null, StringUtils.chomp(null, "foo")); 
     assertEquals("chomp(String, String) failed", null, StringUtils.chomp(null, null)); 
     assertEquals("chomp(String, String) failed", null, StringUtils.chomp(null, "")); 
     assertEquals("chomp(String, String) failed", "", StringUtils.chomp("foo", "foo")); 
     assertEquals("chomp(String, String) failed", " ", StringUtils.chomp(" foo", "foo")); 
     assertEquals("chomp(String, String) failed", "foo ", StringUtils.chomp("foo ", "foo")); 
 }
@Test
public void testReplace_StringStringArrayStringArray7187() { 
     assertNull(StringUtils.replaceEach(null, new String[] { "a" }, new String[] { "b" })); 
     assertEquals(StringUtils.replaceEach("", new String[] { "a" }, new String[] { "b" }), ""); 
     assertEquals(StringUtils.replaceEach("aba", null, null), "aba"); 
     assertEquals(StringUtils.replaceEach("aba", new String[0], null), "aba"); 
     assertEquals(StringUtils.replaceEach("aba", null, new String[0]), "aba"); 
     assertEquals(StringUtils.replaceEach("aba", new String[] { "a" }, null), "aba"); 
     assertEquals(StringUtils.replaceEach("aba", new String[] { "a" }, new String[] { "" }), "b"); 
     assertEquals(StringUtils.replaceEach("aba", new String[] { null }, new String[] { "a" }), "aba"); 
     assertEquals(StringUtils.replaceEach("abcde", new String[] { "ab", "d" }, new String[] { "w", "t" }), "wcte"); 
     assertEquals(StringUtils.replaceEach("abcde", new String[] { "ab", "d" }, new String[] { "d", "t" }), "dcte"); 
     assertEquals("bcc", StringUtils.replaceEach("abc", new String[] { "a", "b" }, new String[] { "b", "c" })); 
     assertEquals("q651.506bera", StringUtils.replaceEach("d216.102oren", new String[] { "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "1", "2", "3", "4", "5", "6", "7", "8", "9" }, new String[] { "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z", "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "5", "6", "7", "8", "9", "1", "2", "3", "4" })); 
     assertEquals(StringUtils.replaceEach("aba", new String[] { "a" }, new String[] { null }), "aba"); 
     assertEquals(StringUtils.replaceEach("aba", new String[] { "a", "b" }, new String[] { "c", null }), "cbc"); 
 }
@Test
public void testGetCommonPrefix_StringArray7196() { 
     assertEquals("", StringUtils.getCommonPrefix((String[]) null)); 
     assertEquals("", StringUtils.getCommonPrefix()); 
     assertEquals("abc", StringUtils.getCommonPrefix("abc")); 
     assertEquals("", StringUtils.getCommonPrefix(null, null)); 
     assertEquals("", StringUtils.getCommonPrefix("", "")); 
     assertEquals("", StringUtils.getCommonPrefix("", null)); 
     assertEquals("", StringUtils.getCommonPrefix("abc", null, null)); 
     assertEquals("", StringUtils.getCommonPrefix(null, null, "abc")); 
     assertEquals("", StringUtils.getCommonPrefix("", "abc")); 
     assertEquals("", StringUtils.getCommonPrefix("abc", "")); 
     assertEquals("abc", StringUtils.getCommonPrefix("abc", "abc")); 
     assertEquals("a", StringUtils.getCommonPrefix("abc", "a")); 
     assertEquals("ab", StringUtils.getCommonPrefix("ab", "abxyz")); 
     assertEquals("ab", StringUtils.getCommonPrefix("abcde", "abxyz")); 
     assertEquals("", StringUtils.getCommonPrefix("abcde", "xyz")); 
     assertEquals("", StringUtils.getCommonPrefix("xyz", "abcde")); 
     assertEquals("i am a ", StringUtils.getCommonPrefix("i am a machine", "i am a robot")); 
 }
@Test
public void testReplace_StringStringArrayStringArray7205() { 
     assertNull(StringUtils.replaceEach(null, new String[] { "a" }, new String[] { "b" })); 
     assertEquals(StringUtils.replaceEach("", new String[] { "a" }, new String[] { "b" }), ""); 
     assertEquals(StringUtils.replaceEach("aba", null, null), "aba"); 
     assertEquals(StringUtils.replaceEach("aba", new String[0], null), "aba"); 
     assertEquals(StringUtils.replaceEach("aba", null, new String[0]), "aba"); 
     assertEquals(StringUtils.replaceEach("aba", new String[] { "a" }, null), "aba"); 
     assertEquals(StringUtils.replaceEach("aba", new String[] { "a" }, new String[] { "" }), "b"); 
     assertEquals(StringUtils.replaceEach("aba", new String[] { null }, new String[] { "a" }), "aba"); 
     assertEquals(StringUtils.replaceEach("abcde", new String[] { "ab", "d" }, new String[] { "w", "t" }), "wcte"); 
     assertEquals(StringUtils.replaceEach("abcde", new String[] { "ab", "d" }, new String[] { "d", "t" }), "dcte"); 
     assertEquals("bcc", StringUtils.replaceEach("abc", new String[] { "a", "b" }, new String[] { "b", "c" })); 
     assertEquals("q651.506bera", StringUtils.replaceEach("d216.102oren", new String[] { "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "1", "2", "3", "4", "5", "6", "7", "8", "9" }, new String[] { "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z", "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "5", "6", "7", "8", "9", "1", "2", "3", "4" })); 
     assertEquals(StringUtils.replaceEach("aba", new String[] { "a" }, new String[] { null }), "aba"); 
     assertEquals(StringUtils.replaceEach("aba", new String[] { "a", "b" }, new String[] { "c", null }), "cbc"); 
 }
@Test
public void testJoin_IterableString7207() { 
     assertEquals(null, StringUtils.join((Iterable<?>) null, null)); 
     assertEquals(TEXT_LIST_NOSEP, StringUtils.join(Arrays.asList(ARRAY_LIST), null)); 
     assertEquals(TEXT_LIST_NOSEP, StringUtils.join(Arrays.asList(ARRAY_LIST), "")); 
     assertEquals("foo", StringUtils.join(Collections.singleton("foo"), "x")); 
     assertEquals("foo", StringUtils.join(Collections.singleton("foo"), null)); 
     assertEquals("", StringUtils.join(Arrays.asList(NULL_ARRAY_LIST), null)); 
     assertEquals("", StringUtils.join(Arrays.asList(EMPTY_ARRAY_LIST), null)); 
     assertEquals("", StringUtils.join(Arrays.asList(EMPTY_ARRAY_LIST), "")); 
     assertEquals("", StringUtils.join(Arrays.asList(EMPTY_ARRAY_LIST), SEPARATOR)); 
     assertEquals(TEXT_LIST, StringUtils.join(Arrays.asList(ARRAY_LIST), SEPARATOR)); 
 }
@Test
public void testReplace_StringStringArrayStringArray7226() { 
     assertNull(StringUtils.replaceEach(null, new String[] { "a" }, new String[] { "b" })); 
     assertEquals(StringUtils.replaceEach("", new String[] { "a" }, new String[] { "b" }), ""); 
     assertEquals(StringUtils.replaceEach("aba", null, null), "aba"); 
     assertEquals(StringUtils.replaceEach("aba", new String[0], null), "aba"); 
     assertEquals(StringUtils.replaceEach("aba", null, new String[0]), "aba"); 
     assertEquals(StringUtils.replaceEach("aba", new String[] { "a" }, null), "aba"); 
     assertEquals(StringUtils.replaceEach("aba", new String[] { "a" }, new String[] { "" }), "b"); 
     assertEquals(StringUtils.replaceEach("aba", new String[] { null }, new String[] { "a" }), "aba"); 
     assertEquals(StringUtils.replaceEach("abcde", new String[] { "ab", "d" }, new String[] { "w", "t" }), "wcte"); 
     assertEquals(StringUtils.replaceEach("abcde", new String[] { "ab", "d" }, new String[] { "d", "t" }), "dcte"); 
     assertEquals("bcc", StringUtils.replaceEach("abc", new String[] { "a", "b" }, new String[] { "b", "c" })); 
     assertEquals("q651.506bera", StringUtils.replaceEach("d216.102oren", new String[] { "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "1", "2", "3", "4", "5", "6", "7", "8", "9" }, new String[] { "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z", "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "5", "6", "7", "8", "9", "1", "2", "3", "4" })); 
     assertEquals(StringUtils.replaceEach("aba", new String[] { "a" }, new String[] { null }), "aba"); 
     assertEquals(StringUtils.replaceEach("aba", new String[] { "a", "b" }, new String[] { "c", null }), "cbc"); 
 }
@Test
public void testSplit_StringChar7229() { 
     assertArrayEquals(null, StringUtils.split(null, '.')); 
     assertEquals(0, StringUtils.split("", '.').length); 
     String str = "a.b.. c"; 
     String[] res = StringUtils.split(str, '.'); 
     assertEquals(3, res.length); 
     assertEquals("a", res[0]); 
     assertEquals("b", res[1]); 
     assertEquals(" c", res[2]); 
     str = ".a."; 
     res = StringUtils.split(str, '.'); 
     assertEquals(1, res.length); 
     assertEquals("a", res[0]); 
     str = "a b c"; 
     res = StringUtils.split(str, ' '); 
     assertEquals(3, res.length); 
     assertEquals("a", res[0]); 
     assertEquals("b", res[1]); 
     assertEquals("c", res[2]); 
 }
@Test
public void testGetLevenshteinDistance_StringStringInt7251() { 
     assertEquals(0, StringUtils.getLevenshteinDistance("", "", 0)); 
     assertEquals(7, StringUtils.getLevenshteinDistance("aaapppp", "", 8)); 
     assertEquals(7, StringUtils.getLevenshteinDistance("aaapppp", "", 7)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("aaapppp", "", 6)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("b", "a", 0)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("a", "b", 0)); 
     assertEquals(0, StringUtils.getLevenshteinDistance("aa", "aa", 0)); 
     assertEquals(0, StringUtils.getLevenshteinDistance("aa", "aa", 2)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("aaa", "bbb", 2)); 
     assertEquals(3, StringUtils.getLevenshteinDistance("aaa", "bbb", 3)); 
     assertEquals(6, StringUtils.getLevenshteinDistance("aaaaaa", "b", 10)); 
     assertEquals(7, StringUtils.getLevenshteinDistance("aaapppp", "b", 8)); 
     assertEquals(3, StringUtils.getLevenshteinDistance("a", "bbb", 4)); 
     assertEquals(7, StringUtils.getLevenshteinDistance("aaapppp", "b", 7)); 
     assertEquals(3, StringUtils.getLevenshteinDistance("a", "bbb", 3)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("a", "bbb", 2)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("bbb", "a", 2)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("aaapppp", "b", 6)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("a", "bbb", 1)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("bbb", "a", 1)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("12345", "1234567", 1)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("1234567", "12345", 1)); 
     assertEquals(1, StringUtils.getLevenshteinDistance("frog", "fog", 1)); 
     assertEquals(3, StringUtils.getLevenshteinDistance("fly", "ant", 3)); 
     assertEquals(7, StringUtils.getLevenshteinDistance("elephant", "hippo", 7)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("elephant", "hippo", 6)); 
     assertEquals(7, StringUtils.getLevenshteinDistance("hippo", "elephant", 7)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("hippo", "elephant", 6)); 
     assertEquals(8, StringUtils.getLevenshteinDistance("hippo", "zzzzzzzz", 8)); 
     assertEquals(8, StringUtils.getLevenshteinDistance("zzzzzzzz", "hippo", 8)); 
     assertEquals(1, StringUtils.getLevenshteinDistance("hello", "hallo", 1)); 
     try { 
         @SuppressWarnings("unused") 
         final int d = StringUtils.getLevenshteinDistance("a", null, 0); 
         fail("expecting IllegalArgumentException"); 
     } catch (final IllegalArgumentException ex) { 
     } 
     try { 
         @SuppressWarnings("unused") 
         final int d = StringUtils.getLevenshteinDistance(null, "a", 0); 
         fail("expecting IllegalArgumentException"); 
     } catch (final IllegalArgumentException ex) { 
     } 
     try { 
         @SuppressWarnings("unused") 
         final int d = StringUtils.getLevenshteinDistance("a", "a", -1); 
         fail("expecting IllegalArgumentException"); 
     } catch (final IllegalArgumentException ex) { 
     } 
 }
@Test
public void testRepeat_StringStringInt7270() { 
     assertEquals(null, StringUtils.repeat(null, null, 2)); 
     assertEquals(null, StringUtils.repeat(null, "x", 2)); 
     assertEquals("", StringUtils.repeat("", null, 2)); 
     assertEquals("", StringUtils.repeat("ab", "", 0)); 
     assertEquals("", StringUtils.repeat("", "", 2)); 
     assertEquals("xx", StringUtils.repeat("", "x", 3)); 
     assertEquals("?, ?, ?", StringUtils.repeat("?", ", ", 3)); 
 }
@Test
public void testJoin_IteratorChar7300() { 
     assertEquals(null, StringUtils.join((Iterator<?>) null, ',')); 
     assertEquals(TEXT_LIST_CHAR, StringUtils.join(Arrays.asList(ARRAY_LIST).iterator(), SEPARATOR_CHAR)); 
     assertEquals("", StringUtils.join(Arrays.asList(NULL_ARRAY_LIST).iterator(), SEPARATOR_CHAR)); 
     assertEquals("", StringUtils.join(Arrays.asList(EMPTY_ARRAY_LIST).iterator(), SEPARATOR_CHAR)); 
     assertEquals("foo", StringUtils.join(Collections.singleton("foo").iterator(), 'x')); 
 }
@Test
public void testRepeat_StringInt7326() { 
     assertEquals(null, StringUtils.repeat(null, 2)); 
     assertEquals("", StringUtils.repeat("ab", 0)); 
     assertEquals("", StringUtils.repeat("", 3)); 
     assertEquals("aaa", StringUtils.repeat("a", 3)); 
     assertEquals("ababab", StringUtils.repeat("ab", 3)); 
     assertEquals("abcabcabc", StringUtils.repeat("abc", 3)); 
     final String str = StringUtils.repeat("a", 10000); 
     assertEquals(10000, str.length()); 
     assertTrue(StringUtils.containsOnly(str, new char[] { 'a' })); 
 }
@Test
public void testGetLevenshteinDistance_StringStringInt7333() { 
     assertEquals(0, StringUtils.getLevenshteinDistance("", "", 0)); 
     assertEquals(7, StringUtils.getLevenshteinDistance("aaapppp", "", 8)); 
     assertEquals(7, StringUtils.getLevenshteinDistance("aaapppp", "", 7)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("aaapppp", "", 6)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("b", "a", 0)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("a", "b", 0)); 
     assertEquals(0, StringUtils.getLevenshteinDistance("aa", "aa", 0)); 
     assertEquals(0, StringUtils.getLevenshteinDistance("aa", "aa", 2)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("aaa", "bbb", 2)); 
     assertEquals(3, StringUtils.getLevenshteinDistance("aaa", "bbb", 3)); 
     assertEquals(6, StringUtils.getLevenshteinDistance("aaaaaa", "b", 10)); 
     assertEquals(7, StringUtils.getLevenshteinDistance("aaapppp", "b", 8)); 
     assertEquals(3, StringUtils.getLevenshteinDistance("a", "bbb", 4)); 
     assertEquals(7, StringUtils.getLevenshteinDistance("aaapppp", "b", 7)); 
     assertEquals(3, StringUtils.getLevenshteinDistance("a", "bbb", 3)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("a", "bbb", 2)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("bbb", "a", 2)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("aaapppp", "b", 6)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("a", "bbb", 1)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("bbb", "a", 1)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("12345", "1234567", 1)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("1234567", "12345", 1)); 
     assertEquals(1, StringUtils.getLevenshteinDistance("frog", "fog", 1)); 
     assertEquals(3, StringUtils.getLevenshteinDistance("fly", "ant", 3)); 
     assertEquals(7, StringUtils.getLevenshteinDistance("elephant", "hippo", 7)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("elephant", "hippo", 6)); 
     assertEquals(7, StringUtils.getLevenshteinDistance("hippo", "elephant", 7)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("hippo", "elephant", 6)); 
     assertEquals(8, StringUtils.getLevenshteinDistance("hippo", "zzzzzzzz", 8)); 
     assertEquals(8, StringUtils.getLevenshteinDistance("zzzzzzzz", "hippo", 8)); 
     assertEquals(1, StringUtils.getLevenshteinDistance("hello", "hallo", 1)); 
     try { 
         @SuppressWarnings("unused") 
         final int d = StringUtils.getLevenshteinDistance("a", null, 0); 
         fail("expecting IllegalArgumentException"); 
     } catch (final IllegalArgumentException ex) { 
     } 
     try { 
         @SuppressWarnings("unused") 
         final int d = StringUtils.getLevenshteinDistance(null, "a", 0); 
         fail("expecting IllegalArgumentException"); 
     } catch (final IllegalArgumentException ex) { 
     } 
     try { 
         @SuppressWarnings("unused") 
         final int d = StringUtils.getLevenshteinDistance("a", "a", -1); 
         fail("expecting IllegalArgumentException"); 
     } catch (final IllegalArgumentException ex) { 
     } 
 }
@Test
public void testGetCommonPrefix_StringArray7363() { 
     assertEquals("", StringUtils.getCommonPrefix((String[]) null)); 
     assertEquals("", StringUtils.getCommonPrefix()); 
     assertEquals("abc", StringUtils.getCommonPrefix("abc")); 
     assertEquals("", StringUtils.getCommonPrefix(null, null)); 
     assertEquals("", StringUtils.getCommonPrefix("", "")); 
     assertEquals("", StringUtils.getCommonPrefix("", null)); 
     assertEquals("", StringUtils.getCommonPrefix("abc", null, null)); 
     assertEquals("", StringUtils.getCommonPrefix(null, null, "abc")); 
     assertEquals("", StringUtils.getCommonPrefix("", "abc")); 
     assertEquals("", StringUtils.getCommonPrefix("abc", "")); 
     assertEquals("abc", StringUtils.getCommonPrefix("abc", "abc")); 
     assertEquals("a", StringUtils.getCommonPrefix("abc", "a")); 
     assertEquals("ab", StringUtils.getCommonPrefix("ab", "abxyz")); 
     assertEquals("ab", StringUtils.getCommonPrefix("abcde", "abxyz")); 
     assertEquals("", StringUtils.getCommonPrefix("abcde", "xyz")); 
     assertEquals("", StringUtils.getCommonPrefix("xyz", "abcde")); 
     assertEquals("i am a ", StringUtils.getCommonPrefix("i am a machine", "i am a robot")); 
 }
@Test
public void testRepeat_StringInt7377() { 
     assertEquals(null, StringUtils.repeat(null, 2)); 
     assertEquals("", StringUtils.repeat("ab", 0)); 
     assertEquals("", StringUtils.repeat("", 3)); 
     assertEquals("aaa", StringUtils.repeat("a", 3)); 
     assertEquals("ababab", StringUtils.repeat("ab", 3)); 
     assertEquals("abcabcabc", StringUtils.repeat("abc", 3)); 
     final String str = StringUtils.repeat("a", 10000); 
     assertEquals(10000, str.length()); 
     assertTrue(StringUtils.containsOnly(str, new char[] { 'a' })); 
 }
@Test
public void testSwapCase_String7393() { 
     assertEquals(null, StringUtils.swapCase(null)); 
     assertEquals("", StringUtils.swapCase("")); 
     assertEquals("  ", StringUtils.swapCase("  ")); 
     assertEquals("i", WordUtils.swapCase("I")); 
     assertEquals("I", WordUtils.swapCase("i")); 
     assertEquals("I AM HERE 123", StringUtils.swapCase("i am here 123")); 
     assertEquals("i aM hERE 123", StringUtils.swapCase("I Am Here 123")); 
     assertEquals("I AM here 123", StringUtils.swapCase("i am HERE 123")); 
     assertEquals("i am here 123", StringUtils.swapCase("I AM HERE 123")); 
     final String test = "This String contains a TitleCase character: \u01C8"; 
     final String expect = "tHIS sTRING CONTAINS A tITLEcASE CHARACTER: \u01C9"; 
     assertEquals(expect, WordUtils.swapCase(test)); 
 }
@Test
public void testSplit_StringChar7399() { 
     assertArrayEquals(null, StringUtils.split(null, '.')); 
     assertEquals(0, StringUtils.split("", '.').length); 
     String str = "a.b.. c"; 
     String[] res = StringUtils.split(str, '.'); 
     assertEquals(3, res.length); 
     assertEquals("a", res[0]); 
     assertEquals("b", res[1]); 
     assertEquals(" c", res[2]); 
     str = ".a."; 
     res = StringUtils.split(str, '.'); 
     assertEquals(1, res.length); 
     assertEquals("a", res[0]); 
     str = "a b c"; 
     res = StringUtils.split(str, ' '); 
     assertEquals(3, res.length); 
     assertEquals("a", res[0]); 
     assertEquals("b", res[1]); 
     assertEquals("c", res[2]); 
 }
@Test
public void testToString7403() throws UnsupportedEncodingException { 
     final String expectedString = "The quick brown fox jumped over the lazy dog."; 
     String encoding = SystemUtils.FILE_ENCODING; 
     byte[] expectedBytes = expectedString.getBytes(encoding); 
     assertArrayEquals(expectedBytes, expectedString.getBytes()); 
     assertEquals(expectedString, StringUtils.toString(expectedBytes, null)); 
     assertEquals(expectedString, StringUtils.toString(expectedBytes, encoding)); 
     encoding = "UTF-16"; 
     expectedBytes = expectedString.getBytes(encoding); 
     assertEquals(expectedString, StringUtils.toString(expectedBytes, encoding)); 
 } 
@SuppressWarnings("deprecation")
@Test
public void testChomp7413() { 
     final String[][] chompCases = { { FOO_UNCAP + "\r\n", FOO_UNCAP }, { FOO_UNCAP + "\n", FOO_UNCAP }, { FOO_UNCAP + "\r", FOO_UNCAP }, { FOO_UNCAP + " \r", FOO_UNCAP + " " }, { FOO_UNCAP, FOO_UNCAP }, { FOO_UNCAP + "\n\n", FOO_UNCAP + "\n" }, { FOO_UNCAP + "\r\n\r\n", FOO_UNCAP + "\r\n" }, { "foo\nfoo", "foo\nfoo" }, { "foo\n\rfoo", "foo\n\rfoo" }, { "\n", "" }, { "\r", "" }, { "a", "a" }, { "\r\n", "" }, { "", "" }, { null, null }, { FOO_UNCAP + "\n\r", FOO_UNCAP + "\n" } }; 
     for (final String[] chompCase : chompCases) { 
         final String original = chompCase[0]; 
         final String expectedResult = chompCase[1]; 
         assertEquals("chomp(String) failed", expectedResult, StringUtils.chomp(original)); 
     } 
     assertEquals("chomp(String, String) failed", "foo", StringUtils.chomp("foobar", "bar")); 
     assertEquals("chomp(String, String) failed", "foobar", StringUtils.chomp("foobar", "baz")); 
     assertEquals("chomp(String, String) failed", "foo", StringUtils.chomp("foo", "foooo")); 
     assertEquals("chomp(String, String) failed", "foobar", StringUtils.chomp("foobar", "")); 
     assertEquals("chomp(String, String) failed", "foobar", StringUtils.chomp("foobar", null)); 
     assertEquals("chomp(String, String) failed", "", StringUtils.chomp("", "foo")); 
     assertEquals("chomp(String, String) failed", "", StringUtils.chomp("", null)); 
     assertEquals("chomp(String, String) failed", "", StringUtils.chomp("", "")); 
     assertEquals("chomp(String, String) failed", null, StringUtils.chomp(null, "foo")); 
     assertEquals("chomp(String, String) failed", null, StringUtils.chomp(null, null)); 
     assertEquals("chomp(String, String) failed", null, StringUtils.chomp(null, "")); 
     assertEquals("chomp(String, String) failed", "", StringUtils.chomp("foo", "foo")); 
     assertEquals("chomp(String, String) failed", " ", StringUtils.chomp(" foo", "foo")); 
     assertEquals("chomp(String, String) failed", "foo ", StringUtils.chomp("foo ", "foo")); 
 }
@Test
public void testReplace_StringStringArrayStringArray7422() { 
     assertNull(StringUtils.replaceEach(null, new String[] { "a" }, new String[] { "b" })); 
     assertEquals(StringUtils.replaceEach("", new String[] { "a" }, new String[] { "b" }), ""); 
     assertEquals(StringUtils.replaceEach("aba", null, null), "aba"); 
     assertEquals(StringUtils.replaceEach("aba", new String[0], null), "aba"); 
     assertEquals(StringUtils.replaceEach("aba", null, new String[0]), "aba"); 
     assertEquals(StringUtils.replaceEach("aba", new String[] { "a" }, null), "aba"); 
     assertEquals(StringUtils.replaceEach("aba", new String[] { "a" }, new String[] { "" }), "b"); 
     assertEquals(StringUtils.replaceEach("aba", new String[] { null }, new String[] { "a" }), "aba"); 
     assertEquals(StringUtils.replaceEach("abcde", new String[] { "ab", "d" }, new String[] { "w", "t" }), "wcte"); 
     assertEquals(StringUtils.replaceEach("abcde", new String[] { "ab", "d" }, new String[] { "d", "t" }), "dcte"); 
     assertEquals("bcc", StringUtils.replaceEach("abc", new String[] { "a", "b" }, new String[] { "b", "c" })); 
     assertEquals("q651.506bera", StringUtils.replaceEach("d216.102oren", new String[] { "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "1", "2", "3", "4", "5", "6", "7", "8", "9" }, new String[] { "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z", "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "5", "6", "7", "8", "9", "1", "2", "3", "4" })); 
     assertEquals(StringUtils.replaceEach("aba", new String[] { "a" }, new String[] { null }), "aba"); 
     assertEquals(StringUtils.replaceEach("aba", new String[] { "a", "b" }, new String[] { "c", null }), "cbc"); 
 }
@Test
public void testSplit_StringChar7430() { 
     assertArrayEquals(null, StringUtils.split(null, '.')); 
     assertEquals(0, StringUtils.split("", '.').length); 
     String str = "a.b.. c"; 
     String[] res = StringUtils.split(str, '.'); 
     assertEquals(3, res.length); 
     assertEquals("a", res[0]); 
     assertEquals("b", res[1]); 
     assertEquals(" c", res[2]); 
     str = ".a."; 
     res = StringUtils.split(str, '.'); 
     assertEquals(1, res.length); 
     assertEquals("a", res[0]); 
     str = "a b c"; 
     res = StringUtils.split(str, ' '); 
     assertEquals(3, res.length); 
     assertEquals("a", res[0]); 
     assertEquals("b", res[1]); 
     assertEquals("c", res[2]); 
 }
@Test
public void testReverse_String7441() { 
     assertEquals(null, StringUtils.reverse(null)); 
     assertEquals("", StringUtils.reverse("")); 
     assertEquals("sdrawkcab", StringUtils.reverse("backwards")); 
 }
@Test
public void testCenter_StringIntChar7453() { 
     assertEquals(null, StringUtils.center(null, -1, ' ')); 
     assertEquals(null, StringUtils.center(null, 4, ' ')); 
     assertEquals("    ", StringUtils.center("", 4, ' ')); 
     assertEquals("ab", StringUtils.center("ab", 0, ' ')); 
     assertEquals("ab", StringUtils.center("ab", -1, ' ')); 
     assertEquals("ab", StringUtils.center("ab", 1, ' ')); 
     assertEquals("    ", StringUtils.center("", 4, ' ')); 
     assertEquals(" ab ", StringUtils.center("ab", 4, ' ')); 
     assertEquals("abcd", StringUtils.center("abcd", 2, ' ')); 
     assertEquals(" a  ", StringUtils.center("a", 4, ' ')); 
     assertEquals("  a  ", StringUtils.center("a", 5, ' ')); 
     assertEquals("xxaxx", StringUtils.center("a", 5, 'x')); 
 }
@Test
public void testJoin_ArrayOfShorts7464() { 
     assertEquals(null, StringUtils.join((short[]) null, ',')); 
     assertEquals("1;2", StringUtils.join(SHORT_PRIM_LIST, SEPARATOR_CHAR)); 
     assertEquals("2", StringUtils.join(SHORT_PRIM_LIST, SEPARATOR_CHAR, 1, 2)); 
 }
@Test
public void testEscapeSurrogatePairsLang8587476() throws Exception { 
     assertEquals("\\uDBFF\\uDFFD", StringEscapeUtils.escapeJava("\uDBFF\uDFFD")); 
     assertEquals("\\uDBFF\\uDFFD", StringEscapeUtils.escapeEcmaScript("\uDBFF\uDFFD")); 
 }
@Test
public void testPrependIfMissingIgnoreCase7499() { 
     assertEquals("prependIfMissingIgnoreCase(null,null)", null, StringUtils.prependIfMissingIgnoreCase(null, null)); 
     assertEquals("prependIfMissingIgnoreCase(abc,null)", "abc", StringUtils.prependIfMissingIgnoreCase("abc", null)); 
     assertEquals("prependIfMissingIgnoreCase(\"\",xyz)", "xyz", StringUtils.prependIfMissingIgnoreCase("", "xyz")); 
     assertEquals("prependIfMissingIgnoreCase(abc,xyz)", "xyzabc", StringUtils.prependIfMissingIgnoreCase("abc", "xyz")); 
     assertEquals("prependIfMissingIgnoreCase(xyzabc,xyz)", "xyzabc", StringUtils.prependIfMissingIgnoreCase("xyzabc", "xyz")); 
     assertEquals("prependIfMissingIgnoreCase(XYZabc,xyz)", "XYZabc", StringUtils.prependIfMissingIgnoreCase("XYZabc", "xyz")); 
     assertEquals("prependIfMissingIgnoreCase(null,null null)", null, StringUtils.prependIfMissingIgnoreCase(null, null, (CharSequence[]) null)); 
     assertEquals("prependIfMissingIgnoreCase(abc,null,null)", "abc", StringUtils.prependIfMissingIgnoreCase("abc", null, (CharSequence[]) null)); 
     assertEquals("prependIfMissingIgnoreCase(\"\",xyz,null)", "xyz", StringUtils.prependIfMissingIgnoreCase("", "xyz", (CharSequence[]) null)); 
     assertEquals("prependIfMissingIgnoreCase(abc,xyz,{null})", "xyzabc", StringUtils.prependIfMissingIgnoreCase("abc", "xyz", new CharSequence[] { null })); 
     assertEquals("prependIfMissingIgnoreCase(abc,xyz,\"\")", "abc", StringUtils.prependIfMissingIgnoreCase("abc", "xyz", "")); 
     assertEquals("prependIfMissingIgnoreCase(abc,xyz,mno)", "xyzabc", StringUtils.prependIfMissingIgnoreCase("abc", "xyz", "mno")); 
     assertEquals("prependIfMissingIgnoreCase(xyzabc,xyz,mno)", "xyzabc", StringUtils.prependIfMissingIgnoreCase("xyzabc", "xyz", "mno")); 
     assertEquals("prependIfMissingIgnoreCase(mnoabc,xyz,mno)", "mnoabc", StringUtils.prependIfMissingIgnoreCase("mnoabc", "xyz", "mno")); 
     assertEquals("prependIfMissingIgnoreCase(XYZabc,xyz,mno)", "XYZabc", StringUtils.prependIfMissingIgnoreCase("XYZabc", "xyz", "mno")); 
     assertEquals("prependIfMissingIgnoreCase(MNOabc,xyz,mno)", "MNOabc", StringUtils.prependIfMissingIgnoreCase("MNOabc", "xyz", "mno")); 
 }
@Test
public void testAppendIfMissingIgnoreCase7507() { 
     assertEquals("appendIfMissingIgnoreCase(null,null)", null, StringUtils.appendIfMissingIgnoreCase(null, null)); 
     assertEquals("appendIfMissingIgnoreCase(abc,null)", "abc", StringUtils.appendIfMissingIgnoreCase("abc", null)); 
     assertEquals("appendIfMissingIgnoreCase(\"\",xyz)", "xyz", StringUtils.appendIfMissingIgnoreCase("", "xyz")); 
     assertEquals("appendIfMissingIgnoreCase(abc,xyz)", "abcxyz", StringUtils.appendIfMissingIgnoreCase("abc", "xyz")); 
     assertEquals("appendIfMissingIgnoreCase(abcxyz,xyz)", "abcxyz", StringUtils.appendIfMissingIgnoreCase("abcxyz", "xyz")); 
     assertEquals("appendIfMissingIgnoreCase(abcXYZ,xyz)", "abcXYZ", StringUtils.appendIfMissingIgnoreCase("abcXYZ", "xyz")); 
     assertEquals("appendIfMissingIgnoreCase(null,null,null)", null, StringUtils.appendIfMissingIgnoreCase(null, null, (CharSequence[]) null)); 
     assertEquals("appendIfMissingIgnoreCase(abc,null,null)", "abc", StringUtils.appendIfMissingIgnoreCase("abc", null, (CharSequence[]) null)); 
     assertEquals("appendIfMissingIgnoreCase(\"\",xyz,null)", "xyz", StringUtils.appendIfMissingIgnoreCase("", "xyz", (CharSequence[]) null)); 
     assertEquals("appendIfMissingIgnoreCase(abc,xyz,{null})", "abcxyz", StringUtils.appendIfMissingIgnoreCase("abc", "xyz", new CharSequence[] { null })); 
     assertEquals("appendIfMissingIgnoreCase(abc,xyz,\"\")", "abc", StringUtils.appendIfMissingIgnoreCase("abc", "xyz", "")); 
     assertEquals("appendIfMissingIgnoreCase(abc,xyz,mno)", "abcxyz", StringUtils.appendIfMissingIgnoreCase("abc", "xyz", "mno")); 
     assertEquals("appendIfMissingIgnoreCase(abcxyz,xyz,mno)", "abcxyz", StringUtils.appendIfMissingIgnoreCase("abcxyz", "xyz", "mno")); 
     assertEquals("appendIfMissingIgnoreCase(abcmno,xyz,mno)", "abcmno", StringUtils.appendIfMissingIgnoreCase("abcmno", "xyz", "mno")); 
     assertEquals("appendIfMissingIgnoreCase(abcXYZ,xyz,mno)", "abcXYZ", StringUtils.appendIfMissingIgnoreCase("abcXYZ", "xyz", "mno")); 
     assertEquals("appendIfMissingIgnoreCase(abcMNO,xyz,mno)", "abcMNO", StringUtils.appendIfMissingIgnoreCase("abcMNO", "xyz", "mno")); 
 }
@Test
public void testJoin_ArrayOfFloats7511() { 
     assertEquals(null, StringUtils.join((float[]) null, ',')); 
     assertEquals("1.0;2.0", StringUtils.join(FLOAT_PRIM_LIST, SEPARATOR_CHAR)); 
     assertEquals("2.0", StringUtils.join(FLOAT_PRIM_LIST, SEPARATOR_CHAR, 1, 2)); 
 }
@Test
public void testGetCommonPrefix_StringArray7529() { 
     assertEquals("", StringUtils.getCommonPrefix((String[]) null)); 
     assertEquals("", StringUtils.getCommonPrefix()); 
     assertEquals("abc", StringUtils.getCommonPrefix("abc")); 
     assertEquals("", StringUtils.getCommonPrefix(null, null)); 
     assertEquals("", StringUtils.getCommonPrefix("", "")); 
     assertEquals("", StringUtils.getCommonPrefix("", null)); 
     assertEquals("", StringUtils.getCommonPrefix("abc", null, null)); 
     assertEquals("", StringUtils.getCommonPrefix(null, null, "abc")); 
     assertEquals("", StringUtils.getCommonPrefix("", "abc")); 
     assertEquals("", StringUtils.getCommonPrefix("abc", "")); 
     assertEquals("abc", StringUtils.getCommonPrefix("abc", "abc")); 
     assertEquals("a", StringUtils.getCommonPrefix("abc", "a")); 
     assertEquals("ab", StringUtils.getCommonPrefix("ab", "abxyz")); 
     assertEquals("ab", StringUtils.getCommonPrefix("abcde", "abxyz")); 
     assertEquals("", StringUtils.getCommonPrefix("abcde", "xyz")); 
     assertEquals("", StringUtils.getCommonPrefix("xyz", "abcde")); 
     assertEquals("i am a ", StringUtils.getCommonPrefix("i am a machine", "i am a robot")); 
 }
@Test
public void testPrependIfMissingIgnoreCase7536() { 
     assertEquals("prependIfMissingIgnoreCase(null,null)", null, StringUtils.prependIfMissingIgnoreCase(null, null)); 
     assertEquals("prependIfMissingIgnoreCase(abc,null)", "abc", StringUtils.prependIfMissingIgnoreCase("abc", null)); 
     assertEquals("prependIfMissingIgnoreCase(\"\",xyz)", "xyz", StringUtils.prependIfMissingIgnoreCase("", "xyz")); 
     assertEquals("prependIfMissingIgnoreCase(abc,xyz)", "xyzabc", StringUtils.prependIfMissingIgnoreCase("abc", "xyz")); 
     assertEquals("prependIfMissingIgnoreCase(xyzabc,xyz)", "xyzabc", StringUtils.prependIfMissingIgnoreCase("xyzabc", "xyz")); 
     assertEquals("prependIfMissingIgnoreCase(XYZabc,xyz)", "XYZabc", StringUtils.prependIfMissingIgnoreCase("XYZabc", "xyz")); 
     assertEquals("prependIfMissingIgnoreCase(null,null null)", null, StringUtils.prependIfMissingIgnoreCase(null, null, (CharSequence[]) null)); 
     assertEquals("prependIfMissingIgnoreCase(abc,null,null)", "abc", StringUtils.prependIfMissingIgnoreCase("abc", null, (CharSequence[]) null)); 
     assertEquals("prependIfMissingIgnoreCase(\"\",xyz,null)", "xyz", StringUtils.prependIfMissingIgnoreCase("", "xyz", (CharSequence[]) null)); 
     assertEquals("prependIfMissingIgnoreCase(abc,xyz,{null})", "xyzabc", StringUtils.prependIfMissingIgnoreCase("abc", "xyz", new CharSequence[] { null })); 
     assertEquals("prependIfMissingIgnoreCase(abc,xyz,\"\")", "abc", StringUtils.prependIfMissingIgnoreCase("abc", "xyz", "")); 
     assertEquals("prependIfMissingIgnoreCase(abc,xyz,mno)", "xyzabc", StringUtils.prependIfMissingIgnoreCase("abc", "xyz", "mno")); 
     assertEquals("prependIfMissingIgnoreCase(xyzabc,xyz,mno)", "xyzabc", StringUtils.prependIfMissingIgnoreCase("xyzabc", "xyz", "mno")); 
     assertEquals("prependIfMissingIgnoreCase(mnoabc,xyz,mno)", "mnoabc", StringUtils.prependIfMissingIgnoreCase("mnoabc", "xyz", "mno")); 
     assertEquals("prependIfMissingIgnoreCase(XYZabc,xyz,mno)", "XYZabc", StringUtils.prependIfMissingIgnoreCase("XYZabc", "xyz", "mno")); 
     assertEquals("prependIfMissingIgnoreCase(MNOabc,xyz,mno)", "MNOabc", StringUtils.prependIfMissingIgnoreCase("MNOabc", "xyz", "mno")); 
 }
@Test
public void testChop7545() { 
     final String[][] chopCases = { { FOO_UNCAP + "\r\n", FOO_UNCAP }, { FOO_UNCAP + "\n", FOO_UNCAP }, { FOO_UNCAP + "\r", FOO_UNCAP }, { FOO_UNCAP + " \r", FOO_UNCAP + " " }, { "foo", "fo" }, { "foo\nfoo", "foo\nfo" }, { "\n", "" }, { "\r", "" }, { "\r\n", "" }, { null, null }, { "", "" }, { "a", "" } }; 
     for (final String[] chopCase : chopCases) { 
         final String original = chopCase[0]; 
         final String expectedResult = chopCase[1]; 
         assertEquals("chop(String) failed", expectedResult, StringUtils.chop(original)); 
     } 
 }
@Test
public void testRepeat_StringInt7569() { 
     assertEquals(null, StringUtils.repeat(null, 2)); 
     assertEquals("", StringUtils.repeat("ab", 0)); 
     assertEquals("", StringUtils.repeat("", 3)); 
     assertEquals("aaa", StringUtils.repeat("a", 3)); 
     assertEquals("ababab", StringUtils.repeat("ab", 3)); 
     assertEquals("abcabcabc", StringUtils.repeat("abc", 3)); 
     final String str = StringUtils.repeat("a", 10000); 
     assertEquals(10000, str.length()); 
     assertTrue(StringUtils.containsOnly(str, new char[] { 'a' })); 
 }
@Test
public void testLeftPad_StringIntString7582() { 
     assertEquals(null, StringUtils.leftPad(null, 5, "-+")); 
     assertEquals(null, StringUtils.leftPad(null, 5, null)); 
     assertEquals("     ", StringUtils.leftPad("", 5, " ")); 
     assertEquals("-+-+abc", StringUtils.leftPad("abc", 7, "-+")); 
     assertEquals("-+~abc", StringUtils.leftPad("abc", 6, "-+~")); 
     assertEquals("-+abc", StringUtils.leftPad("abc", 5, "-+~")); 
     assertEquals("abc", StringUtils.leftPad("abc", 2, " ")); 
     assertEquals("abc", StringUtils.leftPad("abc", -1, " ")); 
     assertEquals("  abc", StringUtils.leftPad("abc", 5, null)); 
     assertEquals("  abc", StringUtils.leftPad("abc", 5, "")); 
 }
@Test
public void testGetCommonPrefix_StringArray7589() { 
     assertEquals("", StringUtils.getCommonPrefix((String[]) null)); 
     assertEquals("", StringUtils.getCommonPrefix()); 
     assertEquals("abc", StringUtils.getCommonPrefix("abc")); 
     assertEquals("", StringUtils.getCommonPrefix(null, null)); 
     assertEquals("", StringUtils.getCommonPrefix("", "")); 
     assertEquals("", StringUtils.getCommonPrefix("", null)); 
     assertEquals("", StringUtils.getCommonPrefix("abc", null, null)); 
     assertEquals("", StringUtils.getCommonPrefix(null, null, "abc")); 
     assertEquals("", StringUtils.getCommonPrefix("", "abc")); 
     assertEquals("", StringUtils.getCommonPrefix("abc", "")); 
     assertEquals("abc", StringUtils.getCommonPrefix("abc", "abc")); 
     assertEquals("a", StringUtils.getCommonPrefix("abc", "a")); 
     assertEquals("ab", StringUtils.getCommonPrefix("ab", "abxyz")); 
     assertEquals("ab", StringUtils.getCommonPrefix("abcde", "abxyz")); 
     assertEquals("", StringUtils.getCommonPrefix("abcde", "xyz")); 
     assertEquals("", StringUtils.getCommonPrefix("xyz", "abcde")); 
     assertEquals("i am a ", StringUtils.getCommonPrefix("i am a machine", "i am a robot")); 
 }
@Test
public void testRepeat_StringInt7590() { 
     assertEquals(null, StringUtils.repeat(null, 2)); 
     assertEquals("", StringUtils.repeat("ab", 0)); 
     assertEquals("", StringUtils.repeat("", 3)); 
     assertEquals("aaa", StringUtils.repeat("a", 3)); 
     assertEquals("ababab", StringUtils.repeat("ab", 3)); 
     assertEquals("abcabcabc", StringUtils.repeat("abc", 3)); 
     final String str = StringUtils.repeat("a", 10000); 
     assertEquals(10000, str.length()); 
     assertTrue(StringUtils.containsOnly(str, new char[] { 'a' })); 
 }
@Test
public void testGetCommonPrefix_StringArray7623() { 
     assertEquals("", StringUtils.getCommonPrefix((String[]) null)); 
     assertEquals("", StringUtils.getCommonPrefix()); 
     assertEquals("abc", StringUtils.getCommonPrefix("abc")); 
     assertEquals("", StringUtils.getCommonPrefix(null, null)); 
     assertEquals("", StringUtils.getCommonPrefix("", "")); 
     assertEquals("", StringUtils.getCommonPrefix("", null)); 
     assertEquals("", StringUtils.getCommonPrefix("abc", null, null)); 
     assertEquals("", StringUtils.getCommonPrefix(null, null, "abc")); 
     assertEquals("", StringUtils.getCommonPrefix("", "abc")); 
     assertEquals("", StringUtils.getCommonPrefix("abc", "")); 
     assertEquals("abc", StringUtils.getCommonPrefix("abc", "abc")); 
     assertEquals("a", StringUtils.getCommonPrefix("abc", "a")); 
     assertEquals("ab", StringUtils.getCommonPrefix("ab", "abxyz")); 
     assertEquals("ab", StringUtils.getCommonPrefix("abcde", "abxyz")); 
     assertEquals("", StringUtils.getCommonPrefix("abcde", "xyz")); 
     assertEquals("", StringUtils.getCommonPrefix("xyz", "abcde")); 
     assertEquals("i am a ", StringUtils.getCommonPrefix("i am a machine", "i am a robot")); 
 }
@Test
public void testRightPad_StringIntChar7624() { 
     assertEquals(null, StringUtils.rightPad(null, 5, ' ')); 
     assertEquals("     ", StringUtils.rightPad("", 5, ' ')); 
     assertEquals("abc  ", StringUtils.rightPad("abc", 5, ' ')); 
     assertEquals("abc", StringUtils.rightPad("abc", 2, ' ')); 
     assertEquals("abc", StringUtils.rightPad("abc", -1, ' ')); 
     assertEquals("abcxx", StringUtils.rightPad("abc", 5, 'x')); 
     final String str = StringUtils.rightPad("aaa", 10000, 'a'); 
     assertEquals(10000, str.length()); 
     assertTrue(StringUtils.containsOnly(str, new char[] { 'a' })); 
 }
@Test
public void testReplace_StringStringArrayStringArray7626() { 
     assertNull(StringUtils.replaceEach(null, new String[] { "a" }, new String[] { "b" })); 
     assertEquals(StringUtils.replaceEach("", new String[] { "a" }, new String[] { "b" }), ""); 
     assertEquals(StringUtils.replaceEach("aba", null, null), "aba"); 
     assertEquals(StringUtils.replaceEach("aba", new String[0], null), "aba"); 
     assertEquals(StringUtils.replaceEach("aba", null, new String[0]), "aba"); 
     assertEquals(StringUtils.replaceEach("aba", new String[] { "a" }, null), "aba"); 
     assertEquals(StringUtils.replaceEach("aba", new String[] { "a" }, new String[] { "" }), "b"); 
     assertEquals(StringUtils.replaceEach("aba", new String[] { null }, new String[] { "a" }), "aba"); 
     assertEquals(StringUtils.replaceEach("abcde", new String[] { "ab", "d" }, new String[] { "w", "t" }), "wcte"); 
     assertEquals(StringUtils.replaceEach("abcde", new String[] { "ab", "d" }, new String[] { "d", "t" }), "dcte"); 
     assertEquals("bcc", StringUtils.replaceEach("abc", new String[] { "a", "b" }, new String[] { "b", "c" })); 
     assertEquals("q651.506bera", StringUtils.replaceEach("d216.102oren", new String[] { "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "1", "2", "3", "4", "5", "6", "7", "8", "9" }, new String[] { "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z", "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "5", "6", "7", "8", "9", "1", "2", "3", "4" })); 
     assertEquals(StringUtils.replaceEach("aba", new String[] { "a" }, new String[] { null }), "aba"); 
     assertEquals(StringUtils.replaceEach("aba", new String[] { "a", "b" }, new String[] { "c", null }), "cbc"); 
 }
@Test
public void testJoin_ArrayOfChars7633() { 
     assertEquals(null, StringUtils.join((char[]) null, ',')); 
     assertEquals("1;2", StringUtils.join(CHAR_PRIM_LIST, SEPARATOR_CHAR)); 
     assertEquals("2", StringUtils.join(CHAR_PRIM_LIST, SEPARATOR_CHAR, 1, 2)); 
 }
@Test
public void testLeftPad_StringInt7634() { 
     assertEquals(null, StringUtils.leftPad(null, 5)); 
     assertEquals("     ", StringUtils.leftPad("", 5)); 
     assertEquals("  abc", StringUtils.leftPad("abc", 5)); 
     assertEquals("abc", StringUtils.leftPad("abc", 2)); 
 }
@Test
public void testSplitByCharacterType7653() { 
     assertNull(StringUtils.splitByCharacterType(null)); 
     assertEquals(0, StringUtils.splitByCharacterType("").length); 
     assertTrue(ArrayUtils.isEquals(new String[] { "ab", " ", "de", " ", "fg" }, StringUtils.splitByCharacterType("ab de fg"))); 
     assertTrue(ArrayUtils.isEquals(new String[] { "ab", "   ", "de", " ", "fg" }, StringUtils.splitByCharacterType("ab   de fg"))); 
     assertTrue(ArrayUtils.isEquals(new String[] { "ab", ":", "cd", ":", "ef" }, StringUtils.splitByCharacterType("ab:cd:ef"))); 
     assertTrue(ArrayUtils.isEquals(new String[] { "number", "5" }, StringUtils.splitByCharacterType("number5"))); 
     assertTrue(ArrayUtils.isEquals(new String[] { "foo", "B", "ar" }, StringUtils.splitByCharacterType("fooBar"))); 
     assertTrue(ArrayUtils.isEquals(new String[] { "foo", "200", "B", "ar" }, StringUtils.splitByCharacterType("foo200Bar"))); 
     assertTrue(ArrayUtils.isEquals(new String[] { "ASFR", "ules" }, StringUtils.splitByCharacterType("ASFRules"))); 
 }
@Test
public void testDifference_StringString7666() { 
     assertEquals(null, StringUtils.difference(null, null)); 
     assertEquals("", StringUtils.difference("", "")); 
     assertEquals("abc", StringUtils.difference("", "abc")); 
     assertEquals("", StringUtils.difference("abc", "")); 
     assertEquals("i am a robot", StringUtils.difference(null, "i am a robot")); 
     assertEquals("i am a machine", StringUtils.difference("i am a machine", null)); 
     assertEquals("robot", StringUtils.difference("i am a machine", "i am a robot")); 
     assertEquals("", StringUtils.difference("abc", "abc")); 
     assertEquals("you are a robot", StringUtils.difference("i am a robot", "you are a robot")); 
 }
@Test
public void testGetCommonPrefix_StringArray7680() { 
     assertEquals("", StringUtils.getCommonPrefix((String[]) null)); 
     assertEquals("", StringUtils.getCommonPrefix()); 
     assertEquals("abc", StringUtils.getCommonPrefix("abc")); 
     assertEquals("", StringUtils.getCommonPrefix(null, null)); 
     assertEquals("", StringUtils.getCommonPrefix("", "")); 
     assertEquals("", StringUtils.getCommonPrefix("", null)); 
     assertEquals("", StringUtils.getCommonPrefix("abc", null, null)); 
     assertEquals("", StringUtils.getCommonPrefix(null, null, "abc")); 
     assertEquals("", StringUtils.getCommonPrefix("", "abc")); 
     assertEquals("", StringUtils.getCommonPrefix("abc", "")); 
     assertEquals("abc", StringUtils.getCommonPrefix("abc", "abc")); 
     assertEquals("a", StringUtils.getCommonPrefix("abc", "a")); 
     assertEquals("ab", StringUtils.getCommonPrefix("ab", "abxyz")); 
     assertEquals("ab", StringUtils.getCommonPrefix("abcde", "abxyz")); 
     assertEquals("", StringUtils.getCommonPrefix("abcde", "xyz")); 
     assertEquals("", StringUtils.getCommonPrefix("xyz", "abcde")); 
     assertEquals("i am a ", StringUtils.getCommonPrefix("i am a machine", "i am a robot")); 
 }
@Test
public void testDefault_StringString7684() { 
     assertEquals("NULL", StringUtils.defaultString(null, "NULL")); 
     assertEquals("", StringUtils.defaultString("", "NULL")); 
     assertEquals("abc", StringUtils.defaultString("abc", "NULL")); 
 }
@Test
public void testReplace_StringStringArrayStringArray7690() { 
     assertNull(StringUtils.replaceEach(null, new String[] { "a" }, new String[] { "b" })); 
     assertEquals(StringUtils.replaceEach("", new String[] { "a" }, new String[] { "b" }), ""); 
     assertEquals(StringUtils.replaceEach("aba", null, null), "aba"); 
     assertEquals(StringUtils.replaceEach("aba", new String[0], null), "aba"); 
     assertEquals(StringUtils.replaceEach("aba", null, new String[0]), "aba"); 
     assertEquals(StringUtils.replaceEach("aba", new String[] { "a" }, null), "aba"); 
     assertEquals(StringUtils.replaceEach("aba", new String[] { "a" }, new String[] { "" }), "b"); 
     assertEquals(StringUtils.replaceEach("aba", new String[] { null }, new String[] { "a" }), "aba"); 
     assertEquals(StringUtils.replaceEach("abcde", new String[] { "ab", "d" }, new String[] { "w", "t" }), "wcte"); 
     assertEquals(StringUtils.replaceEach("abcde", new String[] { "ab", "d" }, new String[] { "d", "t" }), "dcte"); 
     assertEquals("bcc", StringUtils.replaceEach("abc", new String[] { "a", "b" }, new String[] { "b", "c" })); 
     assertEquals("q651.506bera", StringUtils.replaceEach("d216.102oren", new String[] { "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "1", "2", "3", "4", "5", "6", "7", "8", "9" }, new String[] { "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z", "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "5", "6", "7", "8", "9", "1", "2", "3", "4" })); 
     assertEquals(StringUtils.replaceEach("aba", new String[] { "a" }, new String[] { null }), "aba"); 
     assertEquals(StringUtils.replaceEach("aba", new String[] { "a", "b" }, new String[] { "c", null }), "cbc"); 
 } 
@SuppressWarnings("deprecation")
@Test
public void testChomp7691() { 
     final String[][] chompCases = { { FOO_UNCAP + "\r\n", FOO_UNCAP }, { FOO_UNCAP + "\n", FOO_UNCAP }, { FOO_UNCAP + "\r", FOO_UNCAP }, { FOO_UNCAP + " \r", FOO_UNCAP + " " }, { FOO_UNCAP, FOO_UNCAP }, { FOO_UNCAP + "\n\n", FOO_UNCAP + "\n" }, { FOO_UNCAP + "\r\n\r\n", FOO_UNCAP + "\r\n" }, { "foo\nfoo", "foo\nfoo" }, { "foo\n\rfoo", "foo\n\rfoo" }, { "\n", "" }, { "\r", "" }, { "a", "a" }, { "\r\n", "" }, { "", "" }, { null, null }, { FOO_UNCAP + "\n\r", FOO_UNCAP + "\n" } }; 
     for (final String[] chompCase : chompCases) { 
         final String original = chompCase[0]; 
         final String expectedResult = chompCase[1]; 
         assertEquals("chomp(String) failed", expectedResult, StringUtils.chomp(original)); 
     } 
     assertEquals("chomp(String, String) failed", "foo", StringUtils.chomp("foobar", "bar")); 
     assertEquals("chomp(String, String) failed", "foobar", StringUtils.chomp("foobar", "baz")); 
     assertEquals("chomp(String, String) failed", "foo", StringUtils.chomp("foo", "foooo")); 
     assertEquals("chomp(String, String) failed", "foobar", StringUtils.chomp("foobar", "")); 
     assertEquals("chomp(String, String) failed", "foobar", StringUtils.chomp("foobar", null)); 
     assertEquals("chomp(String, String) failed", "", StringUtils.chomp("", "foo")); 
     assertEquals("chomp(String, String) failed", "", StringUtils.chomp("", null)); 
     assertEquals("chomp(String, String) failed", "", StringUtils.chomp("", "")); 
     assertEquals("chomp(String, String) failed", null, StringUtils.chomp(null, "foo")); 
     assertEquals("chomp(String, String) failed", null, StringUtils.chomp(null, null)); 
     assertEquals("chomp(String, String) failed", null, StringUtils.chomp(null, "")); 
     assertEquals("chomp(String, String) failed", "", StringUtils.chomp("foo", "foo")); 
     assertEquals("chomp(String, String) failed", " ", StringUtils.chomp(" foo", "foo")); 
     assertEquals("chomp(String, String) failed", "foo ", StringUtils.chomp("foo ", "foo")); 
 }
@Test
public void testEscapeSurrogatePairsLang8587696() throws Exception { 
     assertEquals("\\uDBFF\\uDFFD", StringEscapeUtils.escapeJava("\uDBFF\uDFFD")); 
     assertEquals("\\uDBFF\\uDFFD", StringEscapeUtils.escapeEcmaScript("\uDBFF\uDFFD")); 
 }
@Test
public void testPrependIfMissingIgnoreCase7702() { 
     assertEquals("prependIfMissingIgnoreCase(null,null)", null, StringUtils.prependIfMissingIgnoreCase(null, null)); 
     assertEquals("prependIfMissingIgnoreCase(abc,null)", "abc", StringUtils.prependIfMissingIgnoreCase("abc", null)); 
     assertEquals("prependIfMissingIgnoreCase(\"\",xyz)", "xyz", StringUtils.prependIfMissingIgnoreCase("", "xyz")); 
     assertEquals("prependIfMissingIgnoreCase(abc,xyz)", "xyzabc", StringUtils.prependIfMissingIgnoreCase("abc", "xyz")); 
     assertEquals("prependIfMissingIgnoreCase(xyzabc,xyz)", "xyzabc", StringUtils.prependIfMissingIgnoreCase("xyzabc", "xyz")); 
     assertEquals("prependIfMissingIgnoreCase(XYZabc,xyz)", "XYZabc", StringUtils.prependIfMissingIgnoreCase("XYZabc", "xyz")); 
     assertEquals("prependIfMissingIgnoreCase(null,null null)", null, StringUtils.prependIfMissingIgnoreCase(null, null, (CharSequence[]) null)); 
     assertEquals("prependIfMissingIgnoreCase(abc,null,null)", "abc", StringUtils.prependIfMissingIgnoreCase("abc", null, (CharSequence[]) null)); 
     assertEquals("prependIfMissingIgnoreCase(\"\",xyz,null)", "xyz", StringUtils.prependIfMissingIgnoreCase("", "xyz", (CharSequence[]) null)); 
     assertEquals("prependIfMissingIgnoreCase(abc,xyz,{null})", "xyzabc", StringUtils.prependIfMissingIgnoreCase("abc", "xyz", new CharSequence[] { null })); 
     assertEquals("prependIfMissingIgnoreCase(abc,xyz,\"\")", "abc", StringUtils.prependIfMissingIgnoreCase("abc", "xyz", "")); 
     assertEquals("prependIfMissingIgnoreCase(abc,xyz,mno)", "xyzabc", StringUtils.prependIfMissingIgnoreCase("abc", "xyz", "mno")); 
     assertEquals("prependIfMissingIgnoreCase(xyzabc,xyz,mno)", "xyzabc", StringUtils.prependIfMissingIgnoreCase("xyzabc", "xyz", "mno")); 
     assertEquals("prependIfMissingIgnoreCase(mnoabc,xyz,mno)", "mnoabc", StringUtils.prependIfMissingIgnoreCase("mnoabc", "xyz", "mno")); 
     assertEquals("prependIfMissingIgnoreCase(XYZabc,xyz,mno)", "XYZabc", StringUtils.prependIfMissingIgnoreCase("XYZabc", "xyz", "mno")); 
     assertEquals("prependIfMissingIgnoreCase(MNOabc,xyz,mno)", "MNOabc", StringUtils.prependIfMissingIgnoreCase("MNOabc", "xyz", "mno")); 
 }
@Test
public void testJoin_ArrayOfFloats7704() { 
     assertEquals(null, StringUtils.join((float[]) null, ',')); 
     assertEquals("1.0;2.0", StringUtils.join(FLOAT_PRIM_LIST, SEPARATOR_CHAR)); 
     assertEquals("2.0", StringUtils.join(FLOAT_PRIM_LIST, SEPARATOR_CHAR, 1, 2)); 
 }
@Test
public void testCenter_StringIntChar7705() { 
     assertEquals(null, StringUtils.center(null, -1, ' ')); 
     assertEquals(null, StringUtils.center(null, 4, ' ')); 
     assertEquals("    ", StringUtils.center("", 4, ' ')); 
     assertEquals("ab", StringUtils.center("ab", 0, ' ')); 
     assertEquals("ab", StringUtils.center("ab", -1, ' ')); 
     assertEquals("ab", StringUtils.center("ab", 1, ' ')); 
     assertEquals("    ", StringUtils.center("", 4, ' ')); 
     assertEquals(" ab ", StringUtils.center("ab", 4, ' ')); 
     assertEquals("abcd", StringUtils.center("abcd", 2, ' ')); 
     assertEquals(" a  ", StringUtils.center("a", 4, ' ')); 
     assertEquals("  a  ", StringUtils.center("a", 5, ' ')); 
     assertEquals("xxaxx", StringUtils.center("a", 5, 'x')); 
 }
@Test
public void testDeleteWhitespace_String7716() { 
     assertEquals(null, StringUtils.deleteWhitespace(null)); 
     assertEquals("", StringUtils.deleteWhitespace("")); 
     assertEquals("", StringUtils.deleteWhitespace("  \u000C  \t\t\u001F\n\n \u000B  ")); 
     assertEquals("", StringUtils.deleteWhitespace(StringUtilsTest.WHITESPACE)); 
     assertEquals(StringUtilsTest.NON_WHITESPACE, StringUtils.deleteWhitespace(StringUtilsTest.NON_WHITESPACE)); 
     assertEquals("\u00A0\u202F", StringUtils.deleteWhitespace("  \u00A0  \t\t\n\n \u202F  ")); 
     assertEquals("\u00A0\u202F", StringUtils.deleteWhitespace("\u00A0\u202F")); 
     assertEquals("test", StringUtils.deleteWhitespace("\u000Bt  \t\n\u0009e\rs\n\n   \tt")); 
 }
@Test
public void testJoin_IterableString7729() { 
     assertEquals(null, StringUtils.join((Iterable<?>) null, null)); 
     assertEquals(TEXT_LIST_NOSEP, StringUtils.join(Arrays.asList(ARRAY_LIST), null)); 
     assertEquals(TEXT_LIST_NOSEP, StringUtils.join(Arrays.asList(ARRAY_LIST), "")); 
     assertEquals("foo", StringUtils.join(Collections.singleton("foo"), "x")); 
     assertEquals("foo", StringUtils.join(Collections.singleton("foo"), null)); 
     assertEquals("", StringUtils.join(Arrays.asList(NULL_ARRAY_LIST), null)); 
     assertEquals("", StringUtils.join(Arrays.asList(EMPTY_ARRAY_LIST), null)); 
     assertEquals("", StringUtils.join(Arrays.asList(EMPTY_ARRAY_LIST), "")); 
     assertEquals("", StringUtils.join(Arrays.asList(EMPTY_ARRAY_LIST), SEPARATOR)); 
     assertEquals(TEXT_LIST, StringUtils.join(Arrays.asList(ARRAY_LIST), SEPARATOR)); 
 }
@Test
public void testPrependIfMissing7734() { 
     assertEquals("prependIfMissing(null,null)", null, StringUtils.prependIfMissing(null, null)); 
     assertEquals("prependIfMissing(abc,null)", "abc", StringUtils.prependIfMissing("abc", null)); 
     assertEquals("prependIfMissing(\"\",xyz)", "xyz", StringUtils.prependIfMissing("", "xyz")); 
     assertEquals("prependIfMissing(abc,xyz)", "xyzabc", StringUtils.prependIfMissing("abc", "xyz")); 
     assertEquals("prependIfMissing(xyzabc,xyz)", "xyzabc", StringUtils.prependIfMissing("xyzabc", "xyz")); 
     assertEquals("prependIfMissing(XYZabc,xyz)", "xyzXYZabc", StringUtils.prependIfMissing("XYZabc", "xyz")); 
     assertEquals("prependIfMissing(null,null null)", null, StringUtils.prependIfMissing(null, null, (CharSequence[]) null)); 
     assertEquals("prependIfMissing(abc,null,null)", "abc", StringUtils.prependIfMissing("abc", null, (CharSequence[]) null)); 
     assertEquals("prependIfMissing(\"\",xyz,null)", "xyz", StringUtils.prependIfMissing("", "xyz", (CharSequence[]) null)); 
     assertEquals("prependIfMissing(abc,xyz,{null})", "xyzabc", StringUtils.prependIfMissing("abc", "xyz", new CharSequence[] { null })); 
     assertEquals("prependIfMissing(abc,xyz,\"\")", "abc", StringUtils.prependIfMissing("abc", "xyz", "")); 
     assertEquals("prependIfMissing(abc,xyz,mno)", "xyzabc", StringUtils.prependIfMissing("abc", "xyz", "mno")); 
     assertEquals("prependIfMissing(xyzabc,xyz,mno)", "xyzabc", StringUtils.prependIfMissing("xyzabc", "xyz", "mno")); 
     assertEquals("prependIfMissing(mnoabc,xyz,mno)", "mnoabc", StringUtils.prependIfMissing("mnoabc", "xyz", "mno")); 
     assertEquals("prependIfMissing(XYZabc,xyz,mno)", "xyzXYZabc", StringUtils.prependIfMissing("XYZabc", "xyz", "mno")); 
     assertEquals("prependIfMissing(MNOabc,xyz,mno)", "xyzMNOabc", StringUtils.prependIfMissing("MNOabc", "xyz", "mno")); 
 }
@Test
public void testCenter_StringIntChar7748() { 
     assertEquals(null, StringUtils.center(null, -1, ' ')); 
     assertEquals(null, StringUtils.center(null, 4, ' ')); 
     assertEquals("    ", StringUtils.center("", 4, ' ')); 
     assertEquals("ab", StringUtils.center("ab", 0, ' ')); 
     assertEquals("ab", StringUtils.center("ab", -1, ' ')); 
     assertEquals("ab", StringUtils.center("ab", 1, ' ')); 
     assertEquals("    ", StringUtils.center("", 4, ' ')); 
     assertEquals(" ab ", StringUtils.center("ab", 4, ' ')); 
     assertEquals("abcd", StringUtils.center("abcd", 2, ' ')); 
     assertEquals(" a  ", StringUtils.center("a", 4, ' ')); 
     assertEquals("  a  ", StringUtils.center("a", 5, ' ')); 
     assertEquals("xxaxx", StringUtils.center("a", 5, 'x')); 
 }
@Test
public void testReplace_StringStringArrayStringArray7749() { 
     assertNull(StringUtils.replaceEach(null, new String[] { "a" }, new String[] { "b" })); 
     assertEquals(StringUtils.replaceEach("", new String[] { "a" }, new String[] { "b" }), ""); 
     assertEquals(StringUtils.replaceEach("aba", null, null), "aba"); 
     assertEquals(StringUtils.replaceEach("aba", new String[0], null), "aba"); 
     assertEquals(StringUtils.replaceEach("aba", null, new String[0]), "aba"); 
     assertEquals(StringUtils.replaceEach("aba", new String[] { "a" }, null), "aba"); 
     assertEquals(StringUtils.replaceEach("aba", new String[] { "a" }, new String[] { "" }), "b"); 
     assertEquals(StringUtils.replaceEach("aba", new String[] { null }, new String[] { "a" }), "aba"); 
     assertEquals(StringUtils.replaceEach("abcde", new String[] { "ab", "d" }, new String[] { "w", "t" }), "wcte"); 
     assertEquals(StringUtils.replaceEach("abcde", new String[] { "ab", "d" }, new String[] { "d", "t" }), "dcte"); 
     assertEquals("bcc", StringUtils.replaceEach("abc", new String[] { "a", "b" }, new String[] { "b", "c" })); 
     assertEquals("q651.506bera", StringUtils.replaceEach("d216.102oren", new String[] { "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "1", "2", "3", "4", "5", "6", "7", "8", "9" }, new String[] { "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z", "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "5", "6", "7", "8", "9", "1", "2", "3", "4" })); 
     assertEquals(StringUtils.replaceEach("aba", new String[] { "a" }, new String[] { null }), "aba"); 
     assertEquals(StringUtils.replaceEach("aba", new String[] { "a", "b" }, new String[] { "c", null }), "cbc"); 
 }
@Test
public void testReplace_StringStringArrayStringArray7755() { 
     assertNull(StringUtils.replaceEach(null, new String[] { "a" }, new String[] { "b" })); 
     assertEquals(StringUtils.replaceEach("", new String[] { "a" }, new String[] { "b" }), ""); 
     assertEquals(StringUtils.replaceEach("aba", null, null), "aba"); 
     assertEquals(StringUtils.replaceEach("aba", new String[0], null), "aba"); 
     assertEquals(StringUtils.replaceEach("aba", null, new String[0]), "aba"); 
     assertEquals(StringUtils.replaceEach("aba", new String[] { "a" }, null), "aba"); 
     assertEquals(StringUtils.replaceEach("aba", new String[] { "a" }, new String[] { "" }), "b"); 
     assertEquals(StringUtils.replaceEach("aba", new String[] { null }, new String[] { "a" }), "aba"); 
     assertEquals(StringUtils.replaceEach("abcde", new String[] { "ab", "d" }, new String[] { "w", "t" }), "wcte"); 
     assertEquals(StringUtils.replaceEach("abcde", new String[] { "ab", "d" }, new String[] { "d", "t" }), "dcte"); 
     assertEquals("bcc", StringUtils.replaceEach("abc", new String[] { "a", "b" }, new String[] { "b", "c" })); 
     assertEquals("q651.506bera", StringUtils.replaceEach("d216.102oren", new String[] { "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "1", "2", "3", "4", "5", "6", "7", "8", "9" }, new String[] { "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z", "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "5", "6", "7", "8", "9", "1", "2", "3", "4" })); 
     assertEquals(StringUtils.replaceEach("aba", new String[] { "a" }, new String[] { null }), "aba"); 
     assertEquals(StringUtils.replaceEach("aba", new String[] { "a", "b" }, new String[] { "c", null }), "cbc"); 
 }
@Test
public void testChop7761() { 
     final String[][] chopCases = { { FOO_UNCAP + "\r\n", FOO_UNCAP }, { FOO_UNCAP + "\n", FOO_UNCAP }, { FOO_UNCAP + "\r", FOO_UNCAP }, { FOO_UNCAP + " \r", FOO_UNCAP + " " }, { "foo", "fo" }, { "foo\nfoo", "foo\nfo" }, { "\n", "" }, { "\r", "" }, { "\r\n", "" }, { null, null }, { "", "" }, { "a", "" } }; 
     for (final String[] chopCase : chopCases) { 
         final String original = chopCase[0]; 
         final String expectedResult = chopCase[1]; 
         assertEquals("chop(String) failed", expectedResult, StringUtils.chop(original)); 
     } 
 }
@Test
public void testJoin_IteratorChar7766() { 
     assertEquals(null, StringUtils.join((Iterator<?>) null, ',')); 
     assertEquals(TEXT_LIST_CHAR, StringUtils.join(Arrays.asList(ARRAY_LIST).iterator(), SEPARATOR_CHAR)); 
     assertEquals("", StringUtils.join(Arrays.asList(NULL_ARRAY_LIST).iterator(), SEPARATOR_CHAR)); 
     assertEquals("", StringUtils.join(Arrays.asList(EMPTY_ARRAY_LIST).iterator(), SEPARATOR_CHAR)); 
     assertEquals("foo", StringUtils.join(Collections.singleton("foo").iterator(), 'x')); 
 }
@Test
public void testRepeat_StringInt7768() { 
     assertEquals(null, StringUtils.repeat(null, 2)); 
     assertEquals("", StringUtils.repeat("ab", 0)); 
     assertEquals("", StringUtils.repeat("", 3)); 
     assertEquals("aaa", StringUtils.repeat("a", 3)); 
     assertEquals("ababab", StringUtils.repeat("ab", 3)); 
     assertEquals("abcabcabc", StringUtils.repeat("abc", 3)); 
     final String str = StringUtils.repeat("a", 10000); 
     assertEquals(10000, str.length()); 
     assertTrue(StringUtils.containsOnly(str, new char[] { 'a' })); 
 }
@Test
public void testJoin_ArrayCharSeparator7778() { 
     assertEquals(null, StringUtils.join((Object[]) null, ',')); 
     assertEquals(TEXT_LIST_CHAR, StringUtils.join(ARRAY_LIST, SEPARATOR_CHAR)); 
     assertEquals("", StringUtils.join(EMPTY_ARRAY_LIST, SEPARATOR_CHAR)); 
     assertEquals(";;foo", StringUtils.join(MIXED_ARRAY_LIST, SEPARATOR_CHAR)); 
     assertEquals("foo;2", StringUtils.join(MIXED_TYPE_LIST, SEPARATOR_CHAR)); 
     assertEquals("/", StringUtils.join(MIXED_ARRAY_LIST, '/', 0, MIXED_ARRAY_LIST.length - 1)); 
     assertEquals("foo", StringUtils.join(MIXED_TYPE_LIST, '/', 0, 1)); 
     assertEquals("null", StringUtils.join(NULL_TO_STRING_LIST, '/', 0, 1)); 
     assertEquals("foo/2", StringUtils.join(MIXED_TYPE_LIST, '/', 0, 2)); 
     assertEquals("2", StringUtils.join(MIXED_TYPE_LIST, '/', 1, 2)); 
     assertEquals("", StringUtils.join(MIXED_TYPE_LIST, '/', 2, 1)); 
 }
@Test
public void testReplace_StringStringArrayStringArray7794() { 
     assertNull(StringUtils.replaceEach(null, new String[] { "a" }, new String[] { "b" })); 
     assertEquals(StringUtils.replaceEach("", new String[] { "a" }, new String[] { "b" }), ""); 
     assertEquals(StringUtils.replaceEach("aba", null, null), "aba"); 
     assertEquals(StringUtils.replaceEach("aba", new String[0], null), "aba"); 
     assertEquals(StringUtils.replaceEach("aba", null, new String[0]), "aba"); 
     assertEquals(StringUtils.replaceEach("aba", new String[] { "a" }, null), "aba"); 
     assertEquals(StringUtils.replaceEach("aba", new String[] { "a" }, new String[] { "" }), "b"); 
     assertEquals(StringUtils.replaceEach("aba", new String[] { null }, new String[] { "a" }), "aba"); 
     assertEquals(StringUtils.replaceEach("abcde", new String[] { "ab", "d" }, new String[] { "w", "t" }), "wcte"); 
     assertEquals(StringUtils.replaceEach("abcde", new String[] { "ab", "d" }, new String[] { "d", "t" }), "dcte"); 
     assertEquals("bcc", StringUtils.replaceEach("abc", new String[] { "a", "b" }, new String[] { "b", "c" })); 
     assertEquals("q651.506bera", StringUtils.replaceEach("d216.102oren", new String[] { "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "1", "2", "3", "4", "5", "6", "7", "8", "9" }, new String[] { "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z", "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "5", "6", "7", "8", "9", "1", "2", "3", "4" })); 
     assertEquals(StringUtils.replaceEach("aba", new String[] { "a" }, new String[] { null }), "aba"); 
     assertEquals(StringUtils.replaceEach("aba", new String[] { "a", "b" }, new String[] { "c", null }), "cbc"); 
 }
@Test
public void testDefaultIfBlank_StringBuffers7799() { 
     assertEquals("NULL", StringUtils.defaultIfBlank(new StringBuffer(""), new StringBuffer("NULL")).toString()); 
     assertEquals("NULL", StringUtils.defaultIfBlank(new StringBuffer(" "), new StringBuffer("NULL")).toString()); 
     assertEquals("abc", StringUtils.defaultIfBlank(new StringBuffer("abc"), new StringBuffer("NULL")).toString()); 
     assertNull(StringUtils.defaultIfBlank(new StringBuffer(""), null)); 
     final StringBuffer s = StringUtils.defaultIfBlank(new StringBuffer("abc"), new StringBuffer("NULL")); 
     assertEquals("abc", s.toString()); 
 }
@Test
public void testEscapeSurrogatePairs7851() throws Exception { 
     assertEquals("\uD83D\uDE30", StringEscapeUtils.escapeCsv("\uD83D\uDE30")); 
     assertEquals("\uD800\uDC00", StringEscapeUtils.escapeCsv("\uD800\uDC00")); 
     assertEquals("\uD834\uDD1E", StringEscapeUtils.escapeCsv("\uD834\uDD1E")); 
     assertEquals("\uDBFF\uDFFD", StringEscapeUtils.escapeCsv("\uDBFF\uDFFD")); 
     assertEquals("\uDBFF\uDFFD", StringEscapeUtils.escapeHtml3("\uDBFF\uDFFD")); 
     assertEquals("\uDBFF\uDFFD", StringEscapeUtils.escapeHtml4("\uDBFF\uDFFD")); 
     assertEquals("\uDBFF\uDFFD", StringEscapeUtils.escapeXml("\uDBFF\uDFFD")); 
 }
@Test
public void testReplace_StringStringStringInt7874() { 
     assertEquals(null, StringUtils.replace(null, null, null, 2)); 
     assertEquals(null, StringUtils.replace(null, null, "any", 2)); 
     assertEquals(null, StringUtils.replace(null, "any", null, 2)); 
     assertEquals(null, StringUtils.replace(null, "any", "any", 2)); 
     assertEquals("", StringUtils.replace("", null, null, 2)); 
     assertEquals("", StringUtils.replace("", null, "any", 2)); 
     assertEquals("", StringUtils.replace("", "any", null, 2)); 
     assertEquals("", StringUtils.replace("", "any", "any", 2)); 
     final String str = new String(new char[] { 'o', 'o', 'f', 'o', 'o' }); 
     assertSame(str, StringUtils.replace(str, "x", "", -1)); 
     assertEquals("f", StringUtils.replace("oofoo", "o", "", -1)); 
     assertEquals("oofoo", StringUtils.replace("oofoo", "o", "", 0)); 
     assertEquals("ofoo", StringUtils.replace("oofoo", "o", "", 1)); 
     assertEquals("foo", StringUtils.replace("oofoo", "o", "", 2)); 
     assertEquals("fo", StringUtils.replace("oofoo", "o", "", 3)); 
     assertEquals("f", StringUtils.replace("oofoo", "o", "", 4)); 
     assertEquals("f", StringUtils.replace("oofoo", "o", "", -5)); 
     assertEquals("f", StringUtils.replace("oofoo", "o", "", 1000)); 
 }
@Test
public void testSplitByCharacterType7881() { 
     assertNull(StringUtils.splitByCharacterType(null)); 
     assertEquals(0, StringUtils.splitByCharacterType("").length); 
     assertTrue(ArrayUtils.isEquals(new String[] { "ab", " ", "de", " ", "fg" }, StringUtils.splitByCharacterType("ab de fg"))); 
     assertTrue(ArrayUtils.isEquals(new String[] { "ab", "   ", "de", " ", "fg" }, StringUtils.splitByCharacterType("ab   de fg"))); 
     assertTrue(ArrayUtils.isEquals(new String[] { "ab", ":", "cd", ":", "ef" }, StringUtils.splitByCharacterType("ab:cd:ef"))); 
     assertTrue(ArrayUtils.isEquals(new String[] { "number", "5" }, StringUtils.splitByCharacterType("number5"))); 
     assertTrue(ArrayUtils.isEquals(new String[] { "foo", "B", "ar" }, StringUtils.splitByCharacterType("fooBar"))); 
     assertTrue(ArrayUtils.isEquals(new String[] { "foo", "200", "B", "ar" }, StringUtils.splitByCharacterType("foo200Bar"))); 
     assertTrue(ArrayUtils.isEquals(new String[] { "ASFR", "ules" }, StringUtils.splitByCharacterType("ASFRules"))); 
 }
@Test
public void testEscapeSurrogatePairs7888() throws Exception { 
     assertEquals("\uD83D\uDE30", StringEscapeUtils.escapeCsv("\uD83D\uDE30")); 
     assertEquals("\uD800\uDC00", StringEscapeUtils.escapeCsv("\uD800\uDC00")); 
     assertEquals("\uD834\uDD1E", StringEscapeUtils.escapeCsv("\uD834\uDD1E")); 
     assertEquals("\uDBFF\uDFFD", StringEscapeUtils.escapeCsv("\uDBFF\uDFFD")); 
     assertEquals("\uDBFF\uDFFD", StringEscapeUtils.escapeHtml3("\uDBFF\uDFFD")); 
     assertEquals("\uDBFF\uDFFD", StringEscapeUtils.escapeHtml4("\uDBFF\uDFFD")); 
     assertEquals("\uDBFF\uDFFD", StringEscapeUtils.escapeXml("\uDBFF\uDFFD")); 
 }
@Test
public void testCenter_StringIntChar7903() { 
     assertEquals(null, StringUtils.center(null, -1, ' ')); 
     assertEquals(null, StringUtils.center(null, 4, ' ')); 
     assertEquals("    ", StringUtils.center("", 4, ' ')); 
     assertEquals("ab", StringUtils.center("ab", 0, ' ')); 
     assertEquals("ab", StringUtils.center("ab", -1, ' ')); 
     assertEquals("ab", StringUtils.center("ab", 1, ' ')); 
     assertEquals("    ", StringUtils.center("", 4, ' ')); 
     assertEquals(" ab ", StringUtils.center("ab", 4, ' ')); 
     assertEquals("abcd", StringUtils.center("abcd", 2, ' ')); 
     assertEquals(" a  ", StringUtils.center("a", 4, ' ')); 
     assertEquals("  a  ", StringUtils.center("a", 5, ' ')); 
     assertEquals("xxaxx", StringUtils.center("a", 5, 'x')); 
 }
@Test
public void testEscapeSurrogatePairsLang8587910() throws Exception { 
     assertEquals("\\uDBFF\\uDFFD", StringEscapeUtils.escapeJava("\uDBFF\uDFFD")); 
     assertEquals("\\uDBFF\\uDFFD", StringEscapeUtils.escapeEcmaScript("\uDBFF\uDFFD")); 
 }
@Test
public void testDifference_StringString7922() { 
     assertEquals(null, StringUtils.difference(null, null)); 
     assertEquals("", StringUtils.difference("", "")); 
     assertEquals("abc", StringUtils.difference("", "abc")); 
     assertEquals("", StringUtils.difference("abc", "")); 
     assertEquals("i am a robot", StringUtils.difference(null, "i am a robot")); 
     assertEquals("i am a machine", StringUtils.difference("i am a machine", null)); 
     assertEquals("robot", StringUtils.difference("i am a machine", "i am a robot")); 
     assertEquals("", StringUtils.difference("abc", "abc")); 
     assertEquals("you are a robot", StringUtils.difference("i am a robot", "you are a robot")); 
 }
@Test
public void testRemoveStart7952() { 
     assertNull(StringUtils.removeStart(null, null)); 
     assertNull(StringUtils.removeStart(null, "")); 
     assertNull(StringUtils.removeStart(null, "a")); 
     assertEquals(StringUtils.removeStart("", null), ""); 
     assertEquals(StringUtils.removeStart("", ""), ""); 
     assertEquals(StringUtils.removeStart("", "a"), ""); 
     assertEquals(StringUtils.removeStart("www.domain.com", "www."), "domain.com"); 
     assertEquals(StringUtils.removeStart("domain.com", "www."), "domain.com"); 
     assertEquals(StringUtils.removeStart("domain.com", ""), "domain.com"); 
     assertEquals(StringUtils.removeStart("domain.com", null), "domain.com"); 
 }
@Test
public void testGetCommonPrefix_StringArray7970() { 
     assertEquals("", StringUtils.getCommonPrefix((String[]) null)); 
     assertEquals("", StringUtils.getCommonPrefix()); 
     assertEquals("abc", StringUtils.getCommonPrefix("abc")); 
     assertEquals("", StringUtils.getCommonPrefix(null, null)); 
     assertEquals("", StringUtils.getCommonPrefix("", "")); 
     assertEquals("", StringUtils.getCommonPrefix("", null)); 
     assertEquals("", StringUtils.getCommonPrefix("abc", null, null)); 
     assertEquals("", StringUtils.getCommonPrefix(null, null, "abc")); 
     assertEquals("", StringUtils.getCommonPrefix("", "abc")); 
     assertEquals("", StringUtils.getCommonPrefix("abc", "")); 
     assertEquals("abc", StringUtils.getCommonPrefix("abc", "abc")); 
     assertEquals("a", StringUtils.getCommonPrefix("abc", "a")); 
     assertEquals("ab", StringUtils.getCommonPrefix("ab", "abxyz")); 
     assertEquals("ab", StringUtils.getCommonPrefix("abcde", "abxyz")); 
     assertEquals("", StringUtils.getCommonPrefix("abcde", "xyz")); 
     assertEquals("", StringUtils.getCommonPrefix("xyz", "abcde")); 
     assertEquals("i am a ", StringUtils.getCommonPrefix("i am a machine", "i am a robot")); 
 }
@Test
public void testReplace_StringStringStringInt7984() { 
     assertEquals(null, StringUtils.replace(null, null, null, 2)); 
     assertEquals(null, StringUtils.replace(null, null, "any", 2)); 
     assertEquals(null, StringUtils.replace(null, "any", null, 2)); 
     assertEquals(null, StringUtils.replace(null, "any", "any", 2)); 
     assertEquals("", StringUtils.replace("", null, null, 2)); 
     assertEquals("", StringUtils.replace("", null, "any", 2)); 
     assertEquals("", StringUtils.replace("", "any", null, 2)); 
     assertEquals("", StringUtils.replace("", "any", "any", 2)); 
     final String str = new String(new char[] { 'o', 'o', 'f', 'o', 'o' }); 
     assertSame(str, StringUtils.replace(str, "x", "", -1)); 
     assertEquals("f", StringUtils.replace("oofoo", "o", "", -1)); 
     assertEquals("oofoo", StringUtils.replace("oofoo", "o", "", 0)); 
     assertEquals("ofoo", StringUtils.replace("oofoo", "o", "", 1)); 
     assertEquals("foo", StringUtils.replace("oofoo", "o", "", 2)); 
     assertEquals("fo", StringUtils.replace("oofoo", "o", "", 3)); 
     assertEquals("f", StringUtils.replace("oofoo", "o", "", 4)); 
     assertEquals("f", StringUtils.replace("oofoo", "o", "", -5)); 
     assertEquals("f", StringUtils.replace("oofoo", "o", "", 1000)); 
 }
@Test
public void testGetCommonPrefix_StringArray8002() { 
     assertEquals("", StringUtils.getCommonPrefix((String[]) null)); 
     assertEquals("", StringUtils.getCommonPrefix()); 
     assertEquals("abc", StringUtils.getCommonPrefix("abc")); 
     assertEquals("", StringUtils.getCommonPrefix(null, null)); 
     assertEquals("", StringUtils.getCommonPrefix("", "")); 
     assertEquals("", StringUtils.getCommonPrefix("", null)); 
     assertEquals("", StringUtils.getCommonPrefix("abc", null, null)); 
     assertEquals("", StringUtils.getCommonPrefix(null, null, "abc")); 
     assertEquals("", StringUtils.getCommonPrefix("", "abc")); 
     assertEquals("", StringUtils.getCommonPrefix("abc", "")); 
     assertEquals("abc", StringUtils.getCommonPrefix("abc", "abc")); 
     assertEquals("a", StringUtils.getCommonPrefix("abc", "a")); 
     assertEquals("ab", StringUtils.getCommonPrefix("ab", "abxyz")); 
     assertEquals("ab", StringUtils.getCommonPrefix("abcde", "abxyz")); 
     assertEquals("", StringUtils.getCommonPrefix("abcde", "xyz")); 
     assertEquals("", StringUtils.getCommonPrefix("xyz", "abcde")); 
     assertEquals("i am a ", StringUtils.getCommonPrefix("i am a machine", "i am a robot")); 
 }
@Test
public void testChop8028() { 
     final String[][] chopCases = { { FOO_UNCAP + "\r\n", FOO_UNCAP }, { FOO_UNCAP + "\n", FOO_UNCAP }, { FOO_UNCAP + "\r", FOO_UNCAP }, { FOO_UNCAP + " \r", FOO_UNCAP + " " }, { "foo", "fo" }, { "foo\nfoo", "foo\nfo" }, { "\n", "" }, { "\r", "" }, { "\r\n", "" }, { null, null }, { "", "" }, { "a", "" } }; 
     for (final String[] chopCase : chopCases) { 
         final String original = chopCase[0]; 
         final String expectedResult = chopCase[1]; 
         assertEquals("chop(String) failed", expectedResult, StringUtils.chop(original)); 
     } 
 }
@Test
public void testRemoveEndIgnoreCase8029() { 
     assertNull("removeEndIgnoreCase(null, null)", StringUtils.removeEndIgnoreCase(null, null)); 
     assertNull("removeEndIgnoreCase(null, \"\")", StringUtils.removeEndIgnoreCase(null, "")); 
     assertNull("removeEndIgnoreCase(null, \"a\")", StringUtils.removeEndIgnoreCase(null, "a")); 
     assertEquals("removeEndIgnoreCase(\"\", null)", StringUtils.removeEndIgnoreCase("", null), ""); 
     assertEquals("removeEndIgnoreCase(\"\", \"\")", StringUtils.removeEndIgnoreCase("", ""), ""); 
     assertEquals("removeEndIgnoreCase(\"\", \"a\")", StringUtils.removeEndIgnoreCase("", "a"), ""); 
     assertEquals("removeEndIgnoreCase(\"www.domain.com.\", \".com\")", StringUtils.removeEndIgnoreCase("www.domain.com.", ".com"), "www.domain.com."); 
     assertEquals("removeEndIgnoreCase(\"www.domain.com\", \".com\")", StringUtils.removeEndIgnoreCase("www.domain.com", ".com"), "www.domain"); 
     assertEquals("removeEndIgnoreCase(\"www.domain\", \".com\")", StringUtils.removeEndIgnoreCase("www.domain", ".com"), "www.domain"); 
     assertEquals("removeEndIgnoreCase(\"domain.com\", \"\")", StringUtils.removeEndIgnoreCase("domain.com", ""), "domain.com"); 
     assertEquals("removeEndIgnoreCase(\"domain.com\", null)", StringUtils.removeEndIgnoreCase("domain.com", null), "domain.com"); 
     assertEquals("removeEndIgnoreCase(\"www.domain.com\", \".COM\")", StringUtils.removeEndIgnoreCase("www.domain.com", ".COM"), "www.domain"); 
     assertEquals("removeEndIgnoreCase(\"www.domain.COM\", \".com\")", StringUtils.removeEndIgnoreCase("www.domain.COM", ".com"), "www.domain"); 
 }
@Test
public void testGetCommonPrefix_StringArray8075() { 
     assertEquals("", StringUtils.getCommonPrefix((String[]) null)); 
     assertEquals("", StringUtils.getCommonPrefix()); 
     assertEquals("abc", StringUtils.getCommonPrefix("abc")); 
     assertEquals("", StringUtils.getCommonPrefix(null, null)); 
     assertEquals("", StringUtils.getCommonPrefix("", "")); 
     assertEquals("", StringUtils.getCommonPrefix("", null)); 
     assertEquals("", StringUtils.getCommonPrefix("abc", null, null)); 
     assertEquals("", StringUtils.getCommonPrefix(null, null, "abc")); 
     assertEquals("", StringUtils.getCommonPrefix("", "abc")); 
     assertEquals("", StringUtils.getCommonPrefix("abc", "")); 
     assertEquals("abc", StringUtils.getCommonPrefix("abc", "abc")); 
     assertEquals("a", StringUtils.getCommonPrefix("abc", "a")); 
     assertEquals("ab", StringUtils.getCommonPrefix("ab", "abxyz")); 
     assertEquals("ab", StringUtils.getCommonPrefix("abcde", "abxyz")); 
     assertEquals("", StringUtils.getCommonPrefix("abcde", "xyz")); 
     assertEquals("", StringUtils.getCommonPrefix("xyz", "abcde")); 
     assertEquals("i am a ", StringUtils.getCommonPrefix("i am a machine", "i am a robot")); 
 }
@Test
public void testSplit_StringChar8139() { 
     assertArrayEquals(null, StringUtils.split(null, '.')); 
     assertEquals(0, StringUtils.split("", '.').length); 
     String str = "a.b.. c"; 
     String[] res = StringUtils.split(str, '.'); 
     assertEquals(3, res.length); 
     assertEquals("a", res[0]); 
     assertEquals("b", res[1]); 
     assertEquals(" c", res[2]); 
     str = ".a."; 
     res = StringUtils.split(str, '.'); 
     assertEquals(1, res.length); 
     assertEquals("a", res[0]); 
     str = "a b c"; 
     res = StringUtils.split(str, ' '); 
     assertEquals(3, res.length); 
     assertEquals("a", res[0]); 
     assertEquals("b", res[1]); 
     assertEquals("c", res[2]); 
 }
@Test
public void testIsAllUpperCase8140() { 
     assertFalse(StringUtils.isAllUpperCase(null)); 
     assertFalse(StringUtils.isAllUpperCase(StringUtils.EMPTY)); 
     assertTrue(StringUtils.isAllUpperCase("ABC")); 
     assertFalse(StringUtils.isAllUpperCase("ABC ")); 
     assertFalse(StringUtils.isAllUpperCase("aBC")); 
 }
@Test
public void testEscapeSurrogatePairsLang8588149() throws Exception { 
     assertEquals("\\uDBFF\\uDFFD", StringEscapeUtils.escapeJava("\uDBFF\uDFFD")); 
     assertEquals("\\uDBFF\\uDFFD", StringEscapeUtils.escapeEcmaScript("\uDBFF\uDFFD")); 
 }
@Test
public void testJoin_IteratorChar8165() { 
     assertEquals(null, StringUtils.join((Iterator<?>) null, ',')); 
     assertEquals(TEXT_LIST_CHAR, StringUtils.join(Arrays.asList(ARRAY_LIST).iterator(), SEPARATOR_CHAR)); 
     assertEquals("", StringUtils.join(Arrays.asList(NULL_ARRAY_LIST).iterator(), SEPARATOR_CHAR)); 
     assertEquals("", StringUtils.join(Arrays.asList(EMPTY_ARRAY_LIST).iterator(), SEPARATOR_CHAR)); 
     assertEquals("foo", StringUtils.join(Collections.singleton("foo").iterator(), 'x')); 
 }
@Test
public void testGetLevenshteinDistance_StringStringInt8167() { 
     assertEquals(0, StringUtils.getLevenshteinDistance("", "", 0)); 
     assertEquals(7, StringUtils.getLevenshteinDistance("aaapppp", "", 8)); 
     assertEquals(7, StringUtils.getLevenshteinDistance("aaapppp", "", 7)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("aaapppp", "", 6)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("b", "a", 0)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("a", "b", 0)); 
     assertEquals(0, StringUtils.getLevenshteinDistance("aa", "aa", 0)); 
     assertEquals(0, StringUtils.getLevenshteinDistance("aa", "aa", 2)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("aaa", "bbb", 2)); 
     assertEquals(3, StringUtils.getLevenshteinDistance("aaa", "bbb", 3)); 
     assertEquals(6, StringUtils.getLevenshteinDistance("aaaaaa", "b", 10)); 
     assertEquals(7, StringUtils.getLevenshteinDistance("aaapppp", "b", 8)); 
     assertEquals(3, StringUtils.getLevenshteinDistance("a", "bbb", 4)); 
     assertEquals(7, StringUtils.getLevenshteinDistance("aaapppp", "b", 7)); 
     assertEquals(3, StringUtils.getLevenshteinDistance("a", "bbb", 3)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("a", "bbb", 2)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("bbb", "a", 2)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("aaapppp", "b", 6)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("a", "bbb", 1)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("bbb", "a", 1)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("12345", "1234567", 1)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("1234567", "12345", 1)); 
     assertEquals(1, StringUtils.getLevenshteinDistance("frog", "fog", 1)); 
     assertEquals(3, StringUtils.getLevenshteinDistance("fly", "ant", 3)); 
     assertEquals(7, StringUtils.getLevenshteinDistance("elephant", "hippo", 7)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("elephant", "hippo", 6)); 
     assertEquals(7, StringUtils.getLevenshteinDistance("hippo", "elephant", 7)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("hippo", "elephant", 6)); 
     assertEquals(8, StringUtils.getLevenshteinDistance("hippo", "zzzzzzzz", 8)); 
     assertEquals(8, StringUtils.getLevenshteinDistance("zzzzzzzz", "hippo", 8)); 
     assertEquals(1, StringUtils.getLevenshteinDistance("hello", "hallo", 1)); 
     try { 
         @SuppressWarnings("unused") 
         final int d = StringUtils.getLevenshteinDistance("a", null, 0); 
         fail("expecting IllegalArgumentException"); 
     } catch (final IllegalArgumentException ex) { 
     } 
     try { 
         @SuppressWarnings("unused") 
         final int d = StringUtils.getLevenshteinDistance(null, "a", 0); 
         fail("expecting IllegalArgumentException"); 
     } catch (final IllegalArgumentException ex) { 
     } 
     try { 
         @SuppressWarnings("unused") 
         final int d = StringUtils.getLevenshteinDistance("a", "a", -1); 
         fail("expecting IllegalArgumentException"); 
     } catch (final IllegalArgumentException ex) { 
     } 
 }
@Test
public void testReplace_StringStringArrayStringArrayBoolean8170() { 
     assertNull(StringUtils.replaceEachRepeatedly(null, new String[] { "a" }, new String[] { "b" })); 
     assertEquals(StringUtils.replaceEachRepeatedly("", new String[] { "a" }, new String[] { "b" }), ""); 
     assertEquals(StringUtils.replaceEachRepeatedly("aba", null, null), "aba"); 
     assertEquals(StringUtils.replaceEachRepeatedly("aba", new String[0], null), "aba"); 
     assertEquals(StringUtils.replaceEachRepeatedly("aba", null, new String[0]), "aba"); 
     assertEquals(StringUtils.replaceEachRepeatedly("aba", new String[0], null), "aba"); 
     assertEquals(StringUtils.replaceEachRepeatedly("aba", new String[] { "a" }, new String[] { "" }), "b"); 
     assertEquals(StringUtils.replaceEachRepeatedly("aba", new String[] { null }, new String[] { "a" }), "aba"); 
     assertEquals(StringUtils.replaceEachRepeatedly("abcde", new String[] { "ab", "d" }, new String[] { "w", "t" }), "wcte"); 
     assertEquals(StringUtils.replaceEachRepeatedly("abcde", new String[] { "ab", "d" }, new String[] { "d", "t" }), "tcte"); 
     try { 
         StringUtils.replaceEachRepeatedly("abcde", new String[] { "ab", "d" }, new String[] { "d", "ab" }); 
         fail("Should be a circular reference"); 
     } catch (final IllegalStateException e) { 
     } 
 }
@Test
public void testJoin_ArrayOfFloats8185() { 
     assertEquals(null, StringUtils.join((float[]) null, ',')); 
     assertEquals("1.0;2.0", StringUtils.join(FLOAT_PRIM_LIST, SEPARATOR_CHAR)); 
     assertEquals("2.0", StringUtils.join(FLOAT_PRIM_LIST, SEPARATOR_CHAR, 1, 2)); 
 }
@Test
public void testJoin_IteratorChar8192() { 
     assertEquals(null, StringUtils.join((Iterator<?>) null, ',')); 
     assertEquals(TEXT_LIST_CHAR, StringUtils.join(Arrays.asList(ARRAY_LIST).iterator(), SEPARATOR_CHAR)); 
     assertEquals("", StringUtils.join(Arrays.asList(NULL_ARRAY_LIST).iterator(), SEPARATOR_CHAR)); 
     assertEquals("", StringUtils.join(Arrays.asList(EMPTY_ARRAY_LIST).iterator(), SEPARATOR_CHAR)); 
     assertEquals("foo", StringUtils.join(Collections.singleton("foo").iterator(), 'x')); 
 }
@Test
public void testPrependIfMissingIgnoreCase8219() { 
     assertEquals("prependIfMissingIgnoreCase(null,null)", null, StringUtils.prependIfMissingIgnoreCase(null, null)); 
     assertEquals("prependIfMissingIgnoreCase(abc,null)", "abc", StringUtils.prependIfMissingIgnoreCase("abc", null)); 
     assertEquals("prependIfMissingIgnoreCase(\"\",xyz)", "xyz", StringUtils.prependIfMissingIgnoreCase("", "xyz")); 
     assertEquals("prependIfMissingIgnoreCase(abc,xyz)", "xyzabc", StringUtils.prependIfMissingIgnoreCase("abc", "xyz")); 
     assertEquals("prependIfMissingIgnoreCase(xyzabc,xyz)", "xyzabc", StringUtils.prependIfMissingIgnoreCase("xyzabc", "xyz")); 
     assertEquals("prependIfMissingIgnoreCase(XYZabc,xyz)", "XYZabc", StringUtils.prependIfMissingIgnoreCase("XYZabc", "xyz")); 
     assertEquals("prependIfMissingIgnoreCase(null,null null)", null, StringUtils.prependIfMissingIgnoreCase(null, null, (CharSequence[]) null)); 
     assertEquals("prependIfMissingIgnoreCase(abc,null,null)", "abc", StringUtils.prependIfMissingIgnoreCase("abc", null, (CharSequence[]) null)); 
     assertEquals("prependIfMissingIgnoreCase(\"\",xyz,null)", "xyz", StringUtils.prependIfMissingIgnoreCase("", "xyz", (CharSequence[]) null)); 
     assertEquals("prependIfMissingIgnoreCase(abc,xyz,{null})", "xyzabc", StringUtils.prependIfMissingIgnoreCase("abc", "xyz", new CharSequence[] { null })); 
     assertEquals("prependIfMissingIgnoreCase(abc,xyz,\"\")", "abc", StringUtils.prependIfMissingIgnoreCase("abc", "xyz", "")); 
     assertEquals("prependIfMissingIgnoreCase(abc,xyz,mno)", "xyzabc", StringUtils.prependIfMissingIgnoreCase("abc", "xyz", "mno")); 
     assertEquals("prependIfMissingIgnoreCase(xyzabc,xyz,mno)", "xyzabc", StringUtils.prependIfMissingIgnoreCase("xyzabc", "xyz", "mno")); 
     assertEquals("prependIfMissingIgnoreCase(mnoabc,xyz,mno)", "mnoabc", StringUtils.prependIfMissingIgnoreCase("mnoabc", "xyz", "mno")); 
     assertEquals("prependIfMissingIgnoreCase(XYZabc,xyz,mno)", "XYZabc", StringUtils.prependIfMissingIgnoreCase("XYZabc", "xyz", "mno")); 
     assertEquals("prependIfMissingIgnoreCase(MNOabc,xyz,mno)", "MNOabc", StringUtils.prependIfMissingIgnoreCase("MNOabc", "xyz", "mno")); 
 }
@Test
public void testSplit_StringString_StringStringInt8235() { 
     assertArrayEquals(null, StringUtils.split(null, ".")); 
     assertArrayEquals(null, StringUtils.split(null, ".", 3)); 
     assertEquals(0, StringUtils.split("", ".").length); 
     assertEquals(0, StringUtils.split("", ".", 3).length); 
     innerTestSplit('.', ".", ' '); 
     innerTestSplit('.', ".", ','); 
     innerTestSplit('.', ".,", 'x'); 
     for (int i = 0; i < WHITESPACE.length(); i++) { 
         for (int j = 0; j < NON_WHITESPACE.length(); j++) { 
             innerTestSplit(WHITESPACE.charAt(i), null, NON_WHITESPACE.charAt(j)); 
             innerTestSplit(WHITESPACE.charAt(i), String.valueOf(WHITESPACE.charAt(i)), NON_WHITESPACE.charAt(j)); 
         } 
     } 
     String[] results; 
     final String[] expectedResults = { "ab", "de fg" }; 
     results = StringUtils.split("ab   de fg", null, 2); 
     assertEquals(expectedResults.length, results.length); 
     for (int i = 0; i < expectedResults.length; i++) { 
         assertEquals(expectedResults[i], results[i]); 
     } 
     final String[] expectedResults2 = { "ab", "cd:ef" }; 
     results = StringUtils.split("ab:cd:ef", ":", 2); 
     assertEquals(expectedResults2.length, results.length); 
     for (int i = 0; i < expectedResults2.length; i++) { 
         assertEquals(expectedResults2[i], results[i]); 
     } 
 }
@Test
public void testAbbreviate_StringIntInt8273() { 
     assertEquals(null, StringUtils.abbreviate(null, 10, 12)); 
     assertEquals("", StringUtils.abbreviate("", 0, 10)); 
     assertEquals("", StringUtils.abbreviate("", 2, 10)); 
     try { 
         @SuppressWarnings("unused") 
         final String res = StringUtils.abbreviate("abcdefghij", 0, 3); 
         fail("StringUtils.abbreviate expecting IllegalArgumentException"); 
     } catch (final IllegalArgumentException ex) { 
     } 
     try { 
         @SuppressWarnings("unused") 
         final String res = StringUtils.abbreviate("abcdefghij", 5, 6); 
         fail("StringUtils.abbreviate expecting IllegalArgumentException"); 
     } catch (final IllegalArgumentException ex) { 
     } 
     final String raspberry = "raspberry peach"; 
     assertEquals("raspberry peach", StringUtils.abbreviate(raspberry, 11, 15)); 
     assertEquals(null, StringUtils.abbreviate(null, 7, 14)); 
     assertAbbreviateWithOffset("abcdefg...", -1, 10); 
     assertAbbreviateWithOffset("abcdefg...", 0, 10); 
     assertAbbreviateWithOffset("abcdefg...", 1, 10); 
     assertAbbreviateWithOffset("abcdefg...", 2, 10); 
     assertAbbreviateWithOffset("abcdefg...", 3, 10); 
     assertAbbreviateWithOffset("abcdefg...", 4, 10); 
     assertAbbreviateWithOffset("...fghi...", 5, 10); 
     assertAbbreviateWithOffset("...ghij...", 6, 10); 
     assertAbbreviateWithOffset("...hijk...", 7, 10); 
     assertAbbreviateWithOffset("...ijklmno", 8, 10); 
     assertAbbreviateWithOffset("...ijklmno", 9, 10); 
     assertAbbreviateWithOffset("...ijklmno", 10, 10); 
     assertAbbreviateWithOffset("...ijklmno", 10, 10); 
     assertAbbreviateWithOffset("...ijklmno", 11, 10); 
     assertAbbreviateWithOffset("...ijklmno", 12, 10); 
     assertAbbreviateWithOffset("...ijklmno", 13, 10); 
     assertAbbreviateWithOffset("...ijklmno", 14, 10); 
     assertAbbreviateWithOffset("...ijklmno", 15, 10); 
     assertAbbreviateWithOffset("...ijklmno", 16, 10); 
     assertAbbreviateWithOffset("...ijklmno", Integer.MAX_VALUE, 10); 
 }
@Test
public void testPrependIfMissingIgnoreCase8320() { 
     assertEquals("prependIfMissingIgnoreCase(null,null)", null, StringUtils.prependIfMissingIgnoreCase(null, null)); 
     assertEquals("prependIfMissingIgnoreCase(abc,null)", "abc", StringUtils.prependIfMissingIgnoreCase("abc", null)); 
     assertEquals("prependIfMissingIgnoreCase(\"\",xyz)", "xyz", StringUtils.prependIfMissingIgnoreCase("", "xyz")); 
     assertEquals("prependIfMissingIgnoreCase(abc,xyz)", "xyzabc", StringUtils.prependIfMissingIgnoreCase("abc", "xyz")); 
     assertEquals("prependIfMissingIgnoreCase(xyzabc,xyz)", "xyzabc", StringUtils.prependIfMissingIgnoreCase("xyzabc", "xyz")); 
     assertEquals("prependIfMissingIgnoreCase(XYZabc,xyz)", "XYZabc", StringUtils.prependIfMissingIgnoreCase("XYZabc", "xyz")); 
     assertEquals("prependIfMissingIgnoreCase(null,null null)", null, StringUtils.prependIfMissingIgnoreCase(null, null, (CharSequence[]) null)); 
     assertEquals("prependIfMissingIgnoreCase(abc,null,null)", "abc", StringUtils.prependIfMissingIgnoreCase("abc", null, (CharSequence[]) null)); 
     assertEquals("prependIfMissingIgnoreCase(\"\",xyz,null)", "xyz", StringUtils.prependIfMissingIgnoreCase("", "xyz", (CharSequence[]) null)); 
     assertEquals("prependIfMissingIgnoreCase(abc,xyz,{null})", "xyzabc", StringUtils.prependIfMissingIgnoreCase("abc", "xyz", new CharSequence[] { null })); 
     assertEquals("prependIfMissingIgnoreCase(abc,xyz,\"\")", "abc", StringUtils.prependIfMissingIgnoreCase("abc", "xyz", "")); 
     assertEquals("prependIfMissingIgnoreCase(abc,xyz,mno)", "xyzabc", StringUtils.prependIfMissingIgnoreCase("abc", "xyz", "mno")); 
     assertEquals("prependIfMissingIgnoreCase(xyzabc,xyz,mno)", "xyzabc", StringUtils.prependIfMissingIgnoreCase("xyzabc", "xyz", "mno")); 
     assertEquals("prependIfMissingIgnoreCase(mnoabc,xyz,mno)", "mnoabc", StringUtils.prependIfMissingIgnoreCase("mnoabc", "xyz", "mno")); 
     assertEquals("prependIfMissingIgnoreCase(XYZabc,xyz,mno)", "XYZabc", StringUtils.prependIfMissingIgnoreCase("XYZabc", "xyz", "mno")); 
     assertEquals("prependIfMissingIgnoreCase(MNOabc,xyz,mno)", "MNOabc", StringUtils.prependIfMissingIgnoreCase("MNOabc", "xyz", "mno")); 
 }
@Test
public void testDeleteWhitespace_String8324() { 
     assertEquals(null, StringUtils.deleteWhitespace(null)); 
     assertEquals("", StringUtils.deleteWhitespace("")); 
     assertEquals("", StringUtils.deleteWhitespace("  \u000C  \t\t\u001F\n\n \u000B  ")); 
     assertEquals("", StringUtils.deleteWhitespace(StringUtilsTest.WHITESPACE)); 
     assertEquals(StringUtilsTest.NON_WHITESPACE, StringUtils.deleteWhitespace(StringUtilsTest.NON_WHITESPACE)); 
     assertEquals("\u00A0\u202F", StringUtils.deleteWhitespace("  \u00A0  \t\t\n\n \u202F  ")); 
     assertEquals("\u00A0\u202F", StringUtils.deleteWhitespace("\u00A0\u202F")); 
     assertEquals("test", StringUtils.deleteWhitespace("\u000Bt  \t\n\u0009e\rs\n\n   \tt")); 
 }
@Test
public void testRepeat_StringInt8397() { 
     assertEquals(null, StringUtils.repeat(null, 2)); 
     assertEquals("", StringUtils.repeat("ab", 0)); 
     assertEquals("", StringUtils.repeat("", 3)); 
     assertEquals("aaa", StringUtils.repeat("a", 3)); 
     assertEquals("ababab", StringUtils.repeat("ab", 3)); 
     assertEquals("abcabcabc", StringUtils.repeat("abc", 3)); 
     final String str = StringUtils.repeat("a", 10000); 
     assertEquals(10000, str.length()); 
     assertTrue(StringUtils.containsOnly(str, new char[] { 'a' })); 
 }
@Test
public void testJoin_ArrayOfChars8409() { 
     assertEquals(null, StringUtils.join((char[]) null, ',')); 
     assertEquals("1;2", StringUtils.join(CHAR_PRIM_LIST, SEPARATOR_CHAR)); 
     assertEquals("2", StringUtils.join(CHAR_PRIM_LIST, SEPARATOR_CHAR, 1, 2)); 
 }
@Test
public void testAbbreviate_StringIntInt8425() { 
     assertEquals(null, StringUtils.abbreviate(null, 10, 12)); 
     assertEquals("", StringUtils.abbreviate("", 0, 10)); 
     assertEquals("", StringUtils.abbreviate("", 2, 10)); 
     try { 
         @SuppressWarnings("unused") 
         final String res = StringUtils.abbreviate("abcdefghij", 0, 3); 
         fail("StringUtils.abbreviate expecting IllegalArgumentException"); 
     } catch (final IllegalArgumentException ex) { 
     } 
     try { 
         @SuppressWarnings("unused") 
         final String res = StringUtils.abbreviate("abcdefghij", 5, 6); 
         fail("StringUtils.abbreviate expecting IllegalArgumentException"); 
     } catch (final IllegalArgumentException ex) { 
     } 
     final String raspberry = "raspberry peach"; 
     assertEquals("raspberry peach", StringUtils.abbreviate(raspberry, 11, 15)); 
     assertEquals(null, StringUtils.abbreviate(null, 7, 14)); 
     assertAbbreviateWithOffset("abcdefg...", -1, 10); 
     assertAbbreviateWithOffset("abcdefg...", 0, 10); 
     assertAbbreviateWithOffset("abcdefg...", 1, 10); 
     assertAbbreviateWithOffset("abcdefg...", 2, 10); 
     assertAbbreviateWithOffset("abcdefg...", 3, 10); 
     assertAbbreviateWithOffset("abcdefg...", 4, 10); 
     assertAbbreviateWithOffset("...fghi...", 5, 10); 
     assertAbbreviateWithOffset("...ghij...", 6, 10); 
     assertAbbreviateWithOffset("...hijk...", 7, 10); 
     assertAbbreviateWithOffset("...ijklmno", 8, 10); 
     assertAbbreviateWithOffset("...ijklmno", 9, 10); 
     assertAbbreviateWithOffset("...ijklmno", 10, 10); 
     assertAbbreviateWithOffset("...ijklmno", 10, 10); 
     assertAbbreviateWithOffset("...ijklmno", 11, 10); 
     assertAbbreviateWithOffset("...ijklmno", 12, 10); 
     assertAbbreviateWithOffset("...ijklmno", 13, 10); 
     assertAbbreviateWithOffset("...ijklmno", 14, 10); 
     assertAbbreviateWithOffset("...ijklmno", 15, 10); 
     assertAbbreviateWithOffset("...ijklmno", 16, 10); 
     assertAbbreviateWithOffset("...ijklmno", Integer.MAX_VALUE, 10); 
 }
@Test
public void testReplace_StringStringStringInt8429() { 
     assertEquals(null, StringUtils.replace(null, null, null, 2)); 
     assertEquals(null, StringUtils.replace(null, null, "any", 2)); 
     assertEquals(null, StringUtils.replace(null, "any", null, 2)); 
     assertEquals(null, StringUtils.replace(null, "any", "any", 2)); 
     assertEquals("", StringUtils.replace("", null, null, 2)); 
     assertEquals("", StringUtils.replace("", null, "any", 2)); 
     assertEquals("", StringUtils.replace("", "any", null, 2)); 
     assertEquals("", StringUtils.replace("", "any", "any", 2)); 
     final String str = new String(new char[] { 'o', 'o', 'f', 'o', 'o' }); 
     assertSame(str, StringUtils.replace(str, "x", "", -1)); 
     assertEquals("f", StringUtils.replace("oofoo", "o", "", -1)); 
     assertEquals("oofoo", StringUtils.replace("oofoo", "o", "", 0)); 
     assertEquals("ofoo", StringUtils.replace("oofoo", "o", "", 1)); 
     assertEquals("foo", StringUtils.replace("oofoo", "o", "", 2)); 
     assertEquals("fo", StringUtils.replace("oofoo", "o", "", 3)); 
     assertEquals("f", StringUtils.replace("oofoo", "o", "", 4)); 
     assertEquals("f", StringUtils.replace("oofoo", "o", "", -5)); 
     assertEquals("f", StringUtils.replace("oofoo", "o", "", 1000)); 
 }
@Test
public void testRepeat_StringInt8430() { 
     assertEquals(null, StringUtils.repeat(null, 2)); 
     assertEquals("", StringUtils.repeat("ab", 0)); 
     assertEquals("", StringUtils.repeat("", 3)); 
     assertEquals("aaa", StringUtils.repeat("a", 3)); 
     assertEquals("ababab", StringUtils.repeat("ab", 3)); 
     assertEquals("abcabcabc", StringUtils.repeat("abc", 3)); 
     final String str = StringUtils.repeat("a", 10000); 
     assertEquals(10000, str.length()); 
     assertTrue(StringUtils.containsOnly(str, new char[] { 'a' })); 
 }
@Test
public void testAbbreviateMiddle8444() { 
     assertNull(StringUtils.abbreviateMiddle(null, null, 0)); 
     assertEquals("abc", StringUtils.abbreviateMiddle("abc", null, 0)); 
     assertEquals("abc", StringUtils.abbreviateMiddle("abc", ".", 0)); 
     assertEquals("abc", StringUtils.abbreviateMiddle("abc", ".", 3)); 
     assertEquals("ab.f", StringUtils.abbreviateMiddle("abcdef", ".", 4)); 
     assertEquals("A very long text with un...f the text is complete.", StringUtils.abbreviateMiddle("A very long text with unimportant stuff in the middle but interesting start and " + "end to see if the text is complete.", "...", 50)); 
     final String longText = "Start text" + StringUtils.repeat("x", 10000) + "Close text"; 
     assertEquals("Start text->Close text", StringUtils.abbreviateMiddle(longText, "->", 22)); 
     assertEquals("abc", StringUtils.abbreviateMiddle("abc", ".", -1)); 
     assertEquals("abc", StringUtils.abbreviateMiddle("abc", ".", 1)); 
     assertEquals("abc", StringUtils.abbreviateMiddle("abc", ".", 2)); 
     assertEquals("a", StringUtils.abbreviateMiddle("a", ".", 1)); 
     assertEquals("a.d", StringUtils.abbreviateMiddle("abcd", ".", 3)); 
     assertEquals("a..f", StringUtils.abbreviateMiddle("abcdef", "..", 4)); 
     assertEquals("ab.ef", StringUtils.abbreviateMiddle("abcdef", ".", 5)); 
 }
@Test
public void testCenter_StringIntChar8465() { 
     assertEquals(null, StringUtils.center(null, -1, ' ')); 
     assertEquals(null, StringUtils.center(null, 4, ' ')); 
     assertEquals("    ", StringUtils.center("", 4, ' ')); 
     assertEquals("ab", StringUtils.center("ab", 0, ' ')); 
     assertEquals("ab", StringUtils.center("ab", -1, ' ')); 
     assertEquals("ab", StringUtils.center("ab", 1, ' ')); 
     assertEquals("    ", StringUtils.center("", 4, ' ')); 
     assertEquals(" ab ", StringUtils.center("ab", 4, ' ')); 
     assertEquals("abcd", StringUtils.center("abcd", 2, ' ')); 
     assertEquals(" a  ", StringUtils.center("a", 4, ' ')); 
     assertEquals("  a  ", StringUtils.center("a", 5, ' ')); 
     assertEquals("xxaxx", StringUtils.center("a", 5, 'x')); 
 }
@Test
public void testReplace_StringStringArrayStringArray8482() { 
     assertNull(StringUtils.replaceEach(null, new String[] { "a" }, new String[] { "b" })); 
     assertEquals(StringUtils.replaceEach("", new String[] { "a" }, new String[] { "b" }), ""); 
     assertEquals(StringUtils.replaceEach("aba", null, null), "aba"); 
     assertEquals(StringUtils.replaceEach("aba", new String[0], null), "aba"); 
     assertEquals(StringUtils.replaceEach("aba", null, new String[0]), "aba"); 
     assertEquals(StringUtils.replaceEach("aba", new String[] { "a" }, null), "aba"); 
     assertEquals(StringUtils.replaceEach("aba", new String[] { "a" }, new String[] { "" }), "b"); 
     assertEquals(StringUtils.replaceEach("aba", new String[] { null }, new String[] { "a" }), "aba"); 
     assertEquals(StringUtils.replaceEach("abcde", new String[] { "ab", "d" }, new String[] { "w", "t" }), "wcte"); 
     assertEquals(StringUtils.replaceEach("abcde", new String[] { "ab", "d" }, new String[] { "d", "t" }), "dcte"); 
     assertEquals("bcc", StringUtils.replaceEach("abc", new String[] { "a", "b" }, new String[] { "b", "c" })); 
     assertEquals("q651.506bera", StringUtils.replaceEach("d216.102oren", new String[] { "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "1", "2", "3", "4", "5", "6", "7", "8", "9" }, new String[] { "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z", "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "5", "6", "7", "8", "9", "1", "2", "3", "4" })); 
     assertEquals(StringUtils.replaceEach("aba", new String[] { "a" }, new String[] { null }), "aba"); 
     assertEquals(StringUtils.replaceEach("aba", new String[] { "a", "b" }, new String[] { "c", null }), "cbc"); 
 }
@Test
public void testEscapeSurrogatePairs8490() throws Exception { 
     assertEquals("\uD83D\uDE30", StringEscapeUtils.escapeCsv("\uD83D\uDE30")); 
     assertEquals("\uD800\uDC00", StringEscapeUtils.escapeCsv("\uD800\uDC00")); 
     assertEquals("\uD834\uDD1E", StringEscapeUtils.escapeCsv("\uD834\uDD1E")); 
     assertEquals("\uDBFF\uDFFD", StringEscapeUtils.escapeCsv("\uDBFF\uDFFD")); 
     assertEquals("\uDBFF\uDFFD", StringEscapeUtils.escapeHtml3("\uDBFF\uDFFD")); 
     assertEquals("\uDBFF\uDFFD", StringEscapeUtils.escapeHtml4("\uDBFF\uDFFD")); 
     assertEquals("\uDBFF\uDFFD", StringEscapeUtils.escapeXml("\uDBFF\uDFFD")); 
 } 
@SuppressWarnings("deprecation")
@Test
public void testChomp8495() { 
     final String[][] chompCases = { { FOO_UNCAP + "\r\n", FOO_UNCAP }, { FOO_UNCAP + "\n", FOO_UNCAP }, { FOO_UNCAP + "\r", FOO_UNCAP }, { FOO_UNCAP + " \r", FOO_UNCAP + " " }, { FOO_UNCAP, FOO_UNCAP }, { FOO_UNCAP + "\n\n", FOO_UNCAP + "\n" }, { FOO_UNCAP + "\r\n\r\n", FOO_UNCAP + "\r\n" }, { "foo\nfoo", "foo\nfoo" }, { "foo\n\rfoo", "foo\n\rfoo" }, { "\n", "" }, { "\r", "" }, { "a", "a" }, { "\r\n", "" }, { "", "" }, { null, null }, { FOO_UNCAP + "\n\r", FOO_UNCAP + "\n" } }; 
     for (final String[] chompCase : chompCases) { 
         final String original = chompCase[0]; 
         final String expectedResult = chompCase[1]; 
         assertEquals("chomp(String) failed", expectedResult, StringUtils.chomp(original)); 
     } 
     assertEquals("chomp(String, String) failed", "foo", StringUtils.chomp("foobar", "bar")); 
     assertEquals("chomp(String, String) failed", "foobar", StringUtils.chomp("foobar", "baz")); 
     assertEquals("chomp(String, String) failed", "foo", StringUtils.chomp("foo", "foooo")); 
     assertEquals("chomp(String, String) failed", "foobar", StringUtils.chomp("foobar", "")); 
     assertEquals("chomp(String, String) failed", "foobar", StringUtils.chomp("foobar", null)); 
     assertEquals("chomp(String, String) failed", "", StringUtils.chomp("", "foo")); 
     assertEquals("chomp(String, String) failed", "", StringUtils.chomp("", null)); 
     assertEquals("chomp(String, String) failed", "", StringUtils.chomp("", "")); 
     assertEquals("chomp(String, String) failed", null, StringUtils.chomp(null, "foo")); 
     assertEquals("chomp(String, String) failed", null, StringUtils.chomp(null, null)); 
     assertEquals("chomp(String, String) failed", null, StringUtils.chomp(null, "")); 
     assertEquals("chomp(String, String) failed", "", StringUtils.chomp("foo", "foo")); 
     assertEquals("chomp(String, String) failed", " ", StringUtils.chomp(" foo", "foo")); 
     assertEquals("chomp(String, String) failed", "foo ", StringUtils.chomp("foo ", "foo")); 
 }
@Test
public void testIsAllLowerCase8527() { 
     assertFalse(StringUtils.isAllLowerCase(null)); 
     assertFalse(StringUtils.isAllLowerCase(StringUtils.EMPTY)); 
     assertTrue(StringUtils.isAllLowerCase("abc")); 
     assertFalse(StringUtils.isAllLowerCase("abc ")); 
     assertFalse(StringUtils.isAllLowerCase("abC")); 
 }
@Test
public void testJoin_ArrayOfFloats8532() { 
     assertEquals(null, StringUtils.join((float[]) null, ',')); 
     assertEquals("1.0;2.0", StringUtils.join(FLOAT_PRIM_LIST, SEPARATOR_CHAR)); 
     assertEquals("2.0", StringUtils.join(FLOAT_PRIM_LIST, SEPARATOR_CHAR, 1, 2)); 
 }
@Test
public void testCenter_StringIntChar8553() { 
     assertEquals(null, StringUtils.center(null, -1, ' ')); 
     assertEquals(null, StringUtils.center(null, 4, ' ')); 
     assertEquals("    ", StringUtils.center("", 4, ' ')); 
     assertEquals("ab", StringUtils.center("ab", 0, ' ')); 
     assertEquals("ab", StringUtils.center("ab", -1, ' ')); 
     assertEquals("ab", StringUtils.center("ab", 1, ' ')); 
     assertEquals("    ", StringUtils.center("", 4, ' ')); 
     assertEquals(" ab ", StringUtils.center("ab", 4, ' ')); 
     assertEquals("abcd", StringUtils.center("abcd", 2, ' ')); 
     assertEquals(" a  ", StringUtils.center("a", 4, ' ')); 
     assertEquals("  a  ", StringUtils.center("a", 5, ' ')); 
     assertEquals("xxaxx", StringUtils.center("a", 5, 'x')); 
 }
@Test
public void testReplace_StringStringArrayStringArray8556() { 
     assertNull(StringUtils.replaceEach(null, new String[] { "a" }, new String[] { "b" })); 
     assertEquals(StringUtils.replaceEach("", new String[] { "a" }, new String[] { "b" }), ""); 
     assertEquals(StringUtils.replaceEach("aba", null, null), "aba"); 
     assertEquals(StringUtils.replaceEach("aba", new String[0], null), "aba"); 
     assertEquals(StringUtils.replaceEach("aba", null, new String[0]), "aba"); 
     assertEquals(StringUtils.replaceEach("aba", new String[] { "a" }, null), "aba"); 
     assertEquals(StringUtils.replaceEach("aba", new String[] { "a" }, new String[] { "" }), "b"); 
     assertEquals(StringUtils.replaceEach("aba", new String[] { null }, new String[] { "a" }), "aba"); 
     assertEquals(StringUtils.replaceEach("abcde", new String[] { "ab", "d" }, new String[] { "w", "t" }), "wcte"); 
     assertEquals(StringUtils.replaceEach("abcde", new String[] { "ab", "d" }, new String[] { "d", "t" }), "dcte"); 
     assertEquals("bcc", StringUtils.replaceEach("abc", new String[] { "a", "b" }, new String[] { "b", "c" })); 
     assertEquals("q651.506bera", StringUtils.replaceEach("d216.102oren", new String[] { "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "1", "2", "3", "4", "5", "6", "7", "8", "9" }, new String[] { "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z", "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "5", "6", "7", "8", "9", "1", "2", "3", "4" })); 
     assertEquals(StringUtils.replaceEach("aba", new String[] { "a" }, new String[] { null }), "aba"); 
     assertEquals(StringUtils.replaceEach("aba", new String[] { "a", "b" }, new String[] { "c", null }), "cbc"); 
 }
@Test
public void testSplitByCharacterType8562() { 
     assertNull(StringUtils.splitByCharacterType(null)); 
     assertEquals(0, StringUtils.splitByCharacterType("").length); 
     assertTrue(ArrayUtils.isEquals(new String[] { "ab", " ", "de", " ", "fg" }, StringUtils.splitByCharacterType("ab de fg"))); 
     assertTrue(ArrayUtils.isEquals(new String[] { "ab", "   ", "de", " ", "fg" }, StringUtils.splitByCharacterType("ab   de fg"))); 
     assertTrue(ArrayUtils.isEquals(new String[] { "ab", ":", "cd", ":", "ef" }, StringUtils.splitByCharacterType("ab:cd:ef"))); 
     assertTrue(ArrayUtils.isEquals(new String[] { "number", "5" }, StringUtils.splitByCharacterType("number5"))); 
     assertTrue(ArrayUtils.isEquals(new String[] { "foo", "B", "ar" }, StringUtils.splitByCharacterType("fooBar"))); 
     assertTrue(ArrayUtils.isEquals(new String[] { "foo", "200", "B", "ar" }, StringUtils.splitByCharacterType("foo200Bar"))); 
     assertTrue(ArrayUtils.isEquals(new String[] { "ASFR", "ules" }, StringUtils.splitByCharacterType("ASFRules"))); 
 }
@Test
public void testGetLevenshteinDistance_StringStringInt8588() { 
     assertEquals(0, StringUtils.getLevenshteinDistance("", "", 0)); 
     assertEquals(7, StringUtils.getLevenshteinDistance("aaapppp", "", 8)); 
     assertEquals(7, StringUtils.getLevenshteinDistance("aaapppp", "", 7)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("aaapppp", "", 6)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("b", "a", 0)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("a", "b", 0)); 
     assertEquals(0, StringUtils.getLevenshteinDistance("aa", "aa", 0)); 
     assertEquals(0, StringUtils.getLevenshteinDistance("aa", "aa", 2)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("aaa", "bbb", 2)); 
     assertEquals(3, StringUtils.getLevenshteinDistance("aaa", "bbb", 3)); 
     assertEquals(6, StringUtils.getLevenshteinDistance("aaaaaa", "b", 10)); 
     assertEquals(7, StringUtils.getLevenshteinDistance("aaapppp", "b", 8)); 
     assertEquals(3, StringUtils.getLevenshteinDistance("a", "bbb", 4)); 
     assertEquals(7, StringUtils.getLevenshteinDistance("aaapppp", "b", 7)); 
     assertEquals(3, StringUtils.getLevenshteinDistance("a", "bbb", 3)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("a", "bbb", 2)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("bbb", "a", 2)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("aaapppp", "b", 6)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("a", "bbb", 1)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("bbb", "a", 1)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("12345", "1234567", 1)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("1234567", "12345", 1)); 
     assertEquals(1, StringUtils.getLevenshteinDistance("frog", "fog", 1)); 
     assertEquals(3, StringUtils.getLevenshteinDistance("fly", "ant", 3)); 
     assertEquals(7, StringUtils.getLevenshteinDistance("elephant", "hippo", 7)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("elephant", "hippo", 6)); 
     assertEquals(7, StringUtils.getLevenshteinDistance("hippo", "elephant", 7)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("hippo", "elephant", 6)); 
     assertEquals(8, StringUtils.getLevenshteinDistance("hippo", "zzzzzzzz", 8)); 
     assertEquals(8, StringUtils.getLevenshteinDistance("zzzzzzzz", "hippo", 8)); 
     assertEquals(1, StringUtils.getLevenshteinDistance("hello", "hallo", 1)); 
     try { 
         @SuppressWarnings("unused") 
         final int d = StringUtils.getLevenshteinDistance("a", null, 0); 
         fail("expecting IllegalArgumentException"); 
     } catch (final IllegalArgumentException ex) { 
     } 
     try { 
         @SuppressWarnings("unused") 
         final int d = StringUtils.getLevenshteinDistance(null, "a", 0); 
         fail("expecting IllegalArgumentException"); 
     } catch (final IllegalArgumentException ex) { 
     } 
     try { 
         @SuppressWarnings("unused") 
         final int d = StringUtils.getLevenshteinDistance("a", "a", -1); 
         fail("expecting IllegalArgumentException"); 
     } catch (final IllegalArgumentException ex) { 
     } 
 }
@Test
public void testLeftPad_StringInt8589() { 
     assertEquals(null, StringUtils.leftPad(null, 5)); 
     assertEquals("     ", StringUtils.leftPad("", 5)); 
     assertEquals("  abc", StringUtils.leftPad("abc", 5)); 
     assertEquals("abc", StringUtils.leftPad("abc", 2)); 
 }
@Test
public void testDefaultIfBlank_StringBuffers8644() { 
     assertEquals("NULL", StringUtils.defaultIfBlank(new StringBuffer(""), new StringBuffer("NULL")).toString()); 
     assertEquals("NULL", StringUtils.defaultIfBlank(new StringBuffer(" "), new StringBuffer("NULL")).toString()); 
     assertEquals("abc", StringUtils.defaultIfBlank(new StringBuffer("abc"), new StringBuffer("NULL")).toString()); 
     assertNull(StringUtils.defaultIfBlank(new StringBuffer(""), null)); 
     final StringBuffer s = StringUtils.defaultIfBlank(new StringBuffer("abc"), new StringBuffer("NULL")); 
     assertEquals("abc", s.toString()); 
 }
@Test
public void testReplace_StringStringArrayStringArray8647() { 
     assertNull(StringUtils.replaceEach(null, new String[] { "a" }, new String[] { "b" })); 
     assertEquals(StringUtils.replaceEach("", new String[] { "a" }, new String[] { "b" }), ""); 
     assertEquals(StringUtils.replaceEach("aba", null, null), "aba"); 
     assertEquals(StringUtils.replaceEach("aba", new String[0], null), "aba"); 
     assertEquals(StringUtils.replaceEach("aba", null, new String[0]), "aba"); 
     assertEquals(StringUtils.replaceEach("aba", new String[] { "a" }, null), "aba"); 
     assertEquals(StringUtils.replaceEach("aba", new String[] { "a" }, new String[] { "" }), "b"); 
     assertEquals(StringUtils.replaceEach("aba", new String[] { null }, new String[] { "a" }), "aba"); 
     assertEquals(StringUtils.replaceEach("abcde", new String[] { "ab", "d" }, new String[] { "w", "t" }), "wcte"); 
     assertEquals(StringUtils.replaceEach("abcde", new String[] { "ab", "d" }, new String[] { "d", "t" }), "dcte"); 
     assertEquals("bcc", StringUtils.replaceEach("abc", new String[] { "a", "b" }, new String[] { "b", "c" })); 
     assertEquals("q651.506bera", StringUtils.replaceEach("d216.102oren", new String[] { "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "1", "2", "3", "4", "5", "6", "7", "8", "9" }, new String[] { "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z", "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "5", "6", "7", "8", "9", "1", "2", "3", "4" })); 
     assertEquals(StringUtils.replaceEach("aba", new String[] { "a" }, new String[] { null }), "aba"); 
     assertEquals(StringUtils.replaceEach("aba", new String[] { "a", "b" }, new String[] { "c", null }), "cbc"); 
 }
@Test
public void testEscapeSurrogatePairsLang8588672() throws Exception { 
     assertEquals("\\uDBFF\\uDFFD", StringEscapeUtils.escapeJava("\uDBFF\uDFFD")); 
     assertEquals("\\uDBFF\\uDFFD", StringEscapeUtils.escapeEcmaScript("\uDBFF\uDFFD")); 
 }
@Test
public void testSplit_StringChar8674() { 
     assertArrayEquals(null, StringUtils.split(null, '.')); 
     assertEquals(0, StringUtils.split("", '.').length); 
     String str = "a.b.. c"; 
     String[] res = StringUtils.split(str, '.'); 
     assertEquals(3, res.length); 
     assertEquals("a", res[0]); 
     assertEquals("b", res[1]); 
     assertEquals(" c", res[2]); 
     str = ".a."; 
     res = StringUtils.split(str, '.'); 
     assertEquals(1, res.length); 
     assertEquals("a", res[0]); 
     str = "a b c"; 
     res = StringUtils.split(str, ' '); 
     assertEquals(3, res.length); 
     assertEquals("a", res[0]); 
     assertEquals("b", res[1]); 
     assertEquals("c", res[2]); 
 }
@Test
public void testReplace_StringStringArrayStringArray8675() { 
     assertNull(StringUtils.replaceEach(null, new String[] { "a" }, new String[] { "b" })); 
     assertEquals(StringUtils.replaceEach("", new String[] { "a" }, new String[] { "b" }), ""); 
     assertEquals(StringUtils.replaceEach("aba", null, null), "aba"); 
     assertEquals(StringUtils.replaceEach("aba", new String[0], null), "aba"); 
     assertEquals(StringUtils.replaceEach("aba", null, new String[0]), "aba"); 
     assertEquals(StringUtils.replaceEach("aba", new String[] { "a" }, null), "aba"); 
     assertEquals(StringUtils.replaceEach("aba", new String[] { "a" }, new String[] { "" }), "b"); 
     assertEquals(StringUtils.replaceEach("aba", new String[] { null }, new String[] { "a" }), "aba"); 
     assertEquals(StringUtils.replaceEach("abcde", new String[] { "ab", "d" }, new String[] { "w", "t" }), "wcte"); 
     assertEquals(StringUtils.replaceEach("abcde", new String[] { "ab", "d" }, new String[] { "d", "t" }), "dcte"); 
     assertEquals("bcc", StringUtils.replaceEach("abc", new String[] { "a", "b" }, new String[] { "b", "c" })); 
     assertEquals("q651.506bera", StringUtils.replaceEach("d216.102oren", new String[] { "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "1", "2", "3", "4", "5", "6", "7", "8", "9" }, new String[] { "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z", "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "5", "6", "7", "8", "9", "1", "2", "3", "4" })); 
     assertEquals(StringUtils.replaceEach("aba", new String[] { "a" }, new String[] { null }), "aba"); 
     assertEquals(StringUtils.replaceEach("aba", new String[] { "a", "b" }, new String[] { "c", null }), "cbc"); 
 }
@Test
public void testReplacePattern8676() { 
     assertEquals("X", StringUtils.replacePattern("<A>\nxy\n</A>", "<A>.*</A>", "X")); 
 }
@Test
public void testJoin_ArrayOfLongs8678() { 
     assertEquals(null, StringUtils.join((long[]) null, ',')); 
     assertEquals("1;2", StringUtils.join(LONG_PRIM_LIST, SEPARATOR_CHAR)); 
     assertEquals("2", StringUtils.join(LONG_PRIM_LIST, SEPARATOR_CHAR, 1, 2)); 
 }
@Test
public void testReplace_StringStringStringInt8681() { 
     assertEquals(null, StringUtils.replace(null, null, null, 2)); 
     assertEquals(null, StringUtils.replace(null, null, "any", 2)); 
     assertEquals(null, StringUtils.replace(null, "any", null, 2)); 
     assertEquals(null, StringUtils.replace(null, "any", "any", 2)); 
     assertEquals("", StringUtils.replace("", null, null, 2)); 
     assertEquals("", StringUtils.replace("", null, "any", 2)); 
     assertEquals("", StringUtils.replace("", "any", null, 2)); 
     assertEquals("", StringUtils.replace("", "any", "any", 2)); 
     final String str = new String(new char[] { 'o', 'o', 'f', 'o', 'o' }); 
     assertSame(str, StringUtils.replace(str, "x", "", -1)); 
     assertEquals("f", StringUtils.replace("oofoo", "o", "", -1)); 
     assertEquals("oofoo", StringUtils.replace("oofoo", "o", "", 0)); 
     assertEquals("ofoo", StringUtils.replace("oofoo", "o", "", 1)); 
     assertEquals("foo", StringUtils.replace("oofoo", "o", "", 2)); 
     assertEquals("fo", StringUtils.replace("oofoo", "o", "", 3)); 
     assertEquals("f", StringUtils.replace("oofoo", "o", "", 4)); 
     assertEquals("f", StringUtils.replace("oofoo", "o", "", -5)); 
     assertEquals("f", StringUtils.replace("oofoo", "o", "", 1000)); 
 }
@Test
public void testRepeat_StringInt8694() { 
     assertEquals(null, StringUtils.repeat(null, 2)); 
     assertEquals("", StringUtils.repeat("ab", 0)); 
     assertEquals("", StringUtils.repeat("", 3)); 
     assertEquals("aaa", StringUtils.repeat("a", 3)); 
     assertEquals("ababab", StringUtils.repeat("ab", 3)); 
     assertEquals("abcabcabc", StringUtils.repeat("abc", 3)); 
     final String str = StringUtils.repeat("a", 10000); 
     assertEquals(10000, str.length()); 
     assertTrue(StringUtils.containsOnly(str, new char[] { 'a' })); 
 }
@Test
public void testLeftPad_StringIntString8695() { 
     assertEquals(null, StringUtils.leftPad(null, 5, "-+")); 
     assertEquals(null, StringUtils.leftPad(null, 5, null)); 
     assertEquals("     ", StringUtils.leftPad("", 5, " ")); 
     assertEquals("-+-+abc", StringUtils.leftPad("abc", 7, "-+")); 
     assertEquals("-+~abc", StringUtils.leftPad("abc", 6, "-+~")); 
     assertEquals("-+abc", StringUtils.leftPad("abc", 5, "-+~")); 
     assertEquals("abc", StringUtils.leftPad("abc", 2, " ")); 
     assertEquals("abc", StringUtils.leftPad("abc", -1, " ")); 
     assertEquals("  abc", StringUtils.leftPad("abc", 5, null)); 
     assertEquals("  abc", StringUtils.leftPad("abc", 5, "")); 
 }
@Test
public void testSplit_StringChar8719() { 
     assertArrayEquals(null, StringUtils.split(null, '.')); 
     assertEquals(0, StringUtils.split("", '.').length); 
     String str = "a.b.. c"; 
     String[] res = StringUtils.split(str, '.'); 
     assertEquals(3, res.length); 
     assertEquals("a", res[0]); 
     assertEquals("b", res[1]); 
     assertEquals(" c", res[2]); 
     str = ".a."; 
     res = StringUtils.split(str, '.'); 
     assertEquals(1, res.length); 
     assertEquals("a", res[0]); 
     str = "a b c"; 
     res = StringUtils.split(str, ' '); 
     assertEquals(3, res.length); 
     assertEquals("a", res[0]); 
     assertEquals("b", res[1]); 
     assertEquals("c", res[2]); 
 }
@Test
public void testGetCommonPrefix_StringArray8752() { 
     assertEquals("", StringUtils.getCommonPrefix((String[]) null)); 
     assertEquals("", StringUtils.getCommonPrefix()); 
     assertEquals("abc", StringUtils.getCommonPrefix("abc")); 
     assertEquals("", StringUtils.getCommonPrefix(null, null)); 
     assertEquals("", StringUtils.getCommonPrefix("", "")); 
     assertEquals("", StringUtils.getCommonPrefix("", null)); 
     assertEquals("", StringUtils.getCommonPrefix("abc", null, null)); 
     assertEquals("", StringUtils.getCommonPrefix(null, null, "abc")); 
     assertEquals("", StringUtils.getCommonPrefix("", "abc")); 
     assertEquals("", StringUtils.getCommonPrefix("abc", "")); 
     assertEquals("abc", StringUtils.getCommonPrefix("abc", "abc")); 
     assertEquals("a", StringUtils.getCommonPrefix("abc", "a")); 
     assertEquals("ab", StringUtils.getCommonPrefix("ab", "abxyz")); 
     assertEquals("ab", StringUtils.getCommonPrefix("abcde", "abxyz")); 
     assertEquals("", StringUtils.getCommonPrefix("abcde", "xyz")); 
     assertEquals("", StringUtils.getCommonPrefix("xyz", "abcde")); 
     assertEquals("i am a ", StringUtils.getCommonPrefix("i am a machine", "i am a robot")); 
 }
@Test
public void testJoin_ArrayOfLongs8761() { 
     assertEquals(null, StringUtils.join((long[]) null, ',')); 
     assertEquals("1;2", StringUtils.join(LONG_PRIM_LIST, SEPARATOR_CHAR)); 
     assertEquals("2", StringUtils.join(LONG_PRIM_LIST, SEPARATOR_CHAR, 1, 2)); 
 }
@Test
public void testEscapeSurrogatePairsLang8588765() throws Exception { 
     assertEquals("\\uDBFF\\uDFFD", StringEscapeUtils.escapeJava("\uDBFF\uDFFD")); 
     assertEquals("\\uDBFF\\uDFFD", StringEscapeUtils.escapeEcmaScript("\uDBFF\uDFFD")); 
 }
@Test
public void testJoin_ArrayOfFloats8778() { 
     assertEquals(null, StringUtils.join((float[]) null, ',')); 
     assertEquals("1.0;2.0", StringUtils.join(FLOAT_PRIM_LIST, SEPARATOR_CHAR)); 
     assertEquals("2.0", StringUtils.join(FLOAT_PRIM_LIST, SEPARATOR_CHAR, 1, 2)); 
 }
@Test
public void testSplit_StringChar8786() { 
     assertArrayEquals(null, StringUtils.split(null, '.')); 
     assertEquals(0, StringUtils.split("", '.').length); 
     String str = "a.b.. c"; 
     String[] res = StringUtils.split(str, '.'); 
     assertEquals(3, res.length); 
     assertEquals("a", res[0]); 
     assertEquals("b", res[1]); 
     assertEquals(" c", res[2]); 
     str = ".a."; 
     res = StringUtils.split(str, '.'); 
     assertEquals(1, res.length); 
     assertEquals("a", res[0]); 
     str = "a b c"; 
     res = StringUtils.split(str, ' '); 
     assertEquals(3, res.length); 
     assertEquals("a", res[0]); 
     assertEquals("b", res[1]); 
     assertEquals("c", res[2]); 
 }
@Test
public void testDefaultIfEmpty_StringBuffers8800() { 
     assertEquals("NULL", StringUtils.defaultIfEmpty(new StringBuffer(""), new StringBuffer("NULL")).toString()); 
     assertEquals("abc", StringUtils.defaultIfEmpty(new StringBuffer("abc"), new StringBuffer("NULL")).toString()); 
     assertNull(StringUtils.defaultIfEmpty(new StringBuffer(""), null)); 
     final StringBuffer s = StringUtils.defaultIfEmpty(new StringBuffer("abc"), new StringBuffer("NULL")); 
     assertEquals("abc", s.toString()); 
 }
@Test
public void testDifference_StringString8806() { 
     assertEquals(null, StringUtils.difference(null, null)); 
     assertEquals("", StringUtils.difference("", "")); 
     assertEquals("abc", StringUtils.difference("", "abc")); 
     assertEquals("", StringUtils.difference("abc", "")); 
     assertEquals("i am a robot", StringUtils.difference(null, "i am a robot")); 
     assertEquals("i am a machine", StringUtils.difference("i am a machine", null)); 
     assertEquals("robot", StringUtils.difference("i am a machine", "i am a robot")); 
     assertEquals("", StringUtils.difference("abc", "abc")); 
     assertEquals("you are a robot", StringUtils.difference("i am a robot", "you are a robot")); 
 }
@Test
public void testReplace_StringStringStringInt8812() { 
     assertEquals(null, StringUtils.replace(null, null, null, 2)); 
     assertEquals(null, StringUtils.replace(null, null, "any", 2)); 
     assertEquals(null, StringUtils.replace(null, "any", null, 2)); 
     assertEquals(null, StringUtils.replace(null, "any", "any", 2)); 
     assertEquals("", StringUtils.replace("", null, null, 2)); 
     assertEquals("", StringUtils.replace("", null, "any", 2)); 
     assertEquals("", StringUtils.replace("", "any", null, 2)); 
     assertEquals("", StringUtils.replace("", "any", "any", 2)); 
     final String str = new String(new char[] { 'o', 'o', 'f', 'o', 'o' }); 
     assertSame(str, StringUtils.replace(str, "x", "", -1)); 
     assertEquals("f", StringUtils.replace("oofoo", "o", "", -1)); 
     assertEquals("oofoo", StringUtils.replace("oofoo", "o", "", 0)); 
     assertEquals("ofoo", StringUtils.replace("oofoo", "o", "", 1)); 
     assertEquals("foo", StringUtils.replace("oofoo", "o", "", 2)); 
     assertEquals("fo", StringUtils.replace("oofoo", "o", "", 3)); 
     assertEquals("f", StringUtils.replace("oofoo", "o", "", 4)); 
     assertEquals("f", StringUtils.replace("oofoo", "o", "", -5)); 
     assertEquals("f", StringUtils.replace("oofoo", "o", "", 1000)); 
 }
@Test
public void testOverlay_StringStringIntInt8820() { 
     assertEquals(null, StringUtils.overlay(null, null, 2, 4)); 
     assertEquals(null, StringUtils.overlay(null, null, -2, -4)); 
     assertEquals("", StringUtils.overlay("", null, 0, 0)); 
     assertEquals("", StringUtils.overlay("", "", 0, 0)); 
     assertEquals("zzzz", StringUtils.overlay("", "zzzz", 0, 0)); 
     assertEquals("zzzz", StringUtils.overlay("", "zzzz", 2, 4)); 
     assertEquals("zzzz", StringUtils.overlay("", "zzzz", -2, -4)); 
     assertEquals("abef", StringUtils.overlay("abcdef", null, 2, 4)); 
     assertEquals("abef", StringUtils.overlay("abcdef", null, 4, 2)); 
     assertEquals("abef", StringUtils.overlay("abcdef", "", 2, 4)); 
     assertEquals("abef", StringUtils.overlay("abcdef", "", 4, 2)); 
     assertEquals("abzzzzef", StringUtils.overlay("abcdef", "zzzz", 2, 4)); 
     assertEquals("abzzzzef", StringUtils.overlay("abcdef", "zzzz", 4, 2)); 
     assertEquals("zzzzef", StringUtils.overlay("abcdef", "zzzz", -1, 4)); 
     assertEquals("zzzzef", StringUtils.overlay("abcdef", "zzzz", 4, -1)); 
     assertEquals("zzzzabcdef", StringUtils.overlay("abcdef", "zzzz", -2, -1)); 
     assertEquals("zzzzabcdef", StringUtils.overlay("abcdef", "zzzz", -1, -2)); 
     assertEquals("abcdzzzz", StringUtils.overlay("abcdef", "zzzz", 4, 10)); 
     assertEquals("abcdzzzz", StringUtils.overlay("abcdef", "zzzz", 10, 4)); 
     assertEquals("abcdefzzzz", StringUtils.overlay("abcdef", "zzzz", 8, 10)); 
     assertEquals("abcdefzzzz", StringUtils.overlay("abcdef", "zzzz", 10, 8)); 
 }
@Test
public void testReplace_StringStringArrayStringArray8833() { 
     assertNull(StringUtils.replaceEach(null, new String[] { "a" }, new String[] { "b" })); 
     assertEquals(StringUtils.replaceEach("", new String[] { "a" }, new String[] { "b" }), ""); 
     assertEquals(StringUtils.replaceEach("aba", null, null), "aba"); 
     assertEquals(StringUtils.replaceEach("aba", new String[0], null), "aba"); 
     assertEquals(StringUtils.replaceEach("aba", null, new String[0]), "aba"); 
     assertEquals(StringUtils.replaceEach("aba", new String[] { "a" }, null), "aba"); 
     assertEquals(StringUtils.replaceEach("aba", new String[] { "a" }, new String[] { "" }), "b"); 
     assertEquals(StringUtils.replaceEach("aba", new String[] { null }, new String[] { "a" }), "aba"); 
     assertEquals(StringUtils.replaceEach("abcde", new String[] { "ab", "d" }, new String[] { "w", "t" }), "wcte"); 
     assertEquals(StringUtils.replaceEach("abcde", new String[] { "ab", "d" }, new String[] { "d", "t" }), "dcte"); 
     assertEquals("bcc", StringUtils.replaceEach("abc", new String[] { "a", "b" }, new String[] { "b", "c" })); 
     assertEquals("q651.506bera", StringUtils.replaceEach("d216.102oren", new String[] { "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "1", "2", "3", "4", "5", "6", "7", "8", "9" }, new String[] { "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z", "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "5", "6", "7", "8", "9", "1", "2", "3", "4" })); 
     assertEquals(StringUtils.replaceEach("aba", new String[] { "a" }, new String[] { null }), "aba"); 
     assertEquals(StringUtils.replaceEach("aba", new String[] { "a", "b" }, new String[] { "c", null }), "cbc"); 
 }
@Test
public void testNormalizeSpace8847() { 
     assertEquals(null, StringUtils.normalizeSpace(null)); 
     assertEquals("", StringUtils.normalizeSpace("")); 
     assertEquals("", StringUtils.normalizeSpace(" ")); 
     assertEquals("", StringUtils.normalizeSpace("\t")); 
     assertEquals("", StringUtils.normalizeSpace("\n")); 
     assertEquals("", StringUtils.normalizeSpace("\u0009")); 
     assertEquals("", StringUtils.normalizeSpace("\u000B")); 
     assertEquals("", StringUtils.normalizeSpace("\u000C")); 
     assertEquals("", StringUtils.normalizeSpace("\u001C")); 
     assertEquals("", StringUtils.normalizeSpace("\u001D")); 
     assertEquals("", StringUtils.normalizeSpace("\u001E")); 
     assertEquals("", StringUtils.normalizeSpace("\u001F")); 
     assertEquals("", StringUtils.normalizeSpace("\f")); 
     assertEquals("", StringUtils.normalizeSpace("\r")); 
     assertEquals("a", StringUtils.normalizeSpace("  a  ")); 
     assertEquals("a b c", StringUtils.normalizeSpace("  a  b   c  ")); 
     assertEquals("a b c", StringUtils.normalizeSpace("a\t\f\r  b\u000B   c\n")); 
 }
@Test
public void testJoin_ArrayOfBytes8850() { 
     assertEquals(null, StringUtils.join((byte[]) null, ',')); 
     assertEquals("1;2", StringUtils.join(BYTE_PRIM_LIST, SEPARATOR_CHAR)); 
     assertEquals("2", StringUtils.join(BYTE_PRIM_LIST, SEPARATOR_CHAR, 1, 2)); 
 }
@Test
public void testGetCommonPrefix_StringArray8867() { 
     assertEquals("", StringUtils.getCommonPrefix((String[]) null)); 
     assertEquals("", StringUtils.getCommonPrefix()); 
     assertEquals("abc", StringUtils.getCommonPrefix("abc")); 
     assertEquals("", StringUtils.getCommonPrefix(null, null)); 
     assertEquals("", StringUtils.getCommonPrefix("", "")); 
     assertEquals("", StringUtils.getCommonPrefix("", null)); 
     assertEquals("", StringUtils.getCommonPrefix("abc", null, null)); 
     assertEquals("", StringUtils.getCommonPrefix(null, null, "abc")); 
     assertEquals("", StringUtils.getCommonPrefix("", "abc")); 
     assertEquals("", StringUtils.getCommonPrefix("abc", "")); 
     assertEquals("abc", StringUtils.getCommonPrefix("abc", "abc")); 
     assertEquals("a", StringUtils.getCommonPrefix("abc", "a")); 
     assertEquals("ab", StringUtils.getCommonPrefix("ab", "abxyz")); 
     assertEquals("ab", StringUtils.getCommonPrefix("abcde", "abxyz")); 
     assertEquals("", StringUtils.getCommonPrefix("abcde", "xyz")); 
     assertEquals("", StringUtils.getCommonPrefix("xyz", "abcde")); 
     assertEquals("i am a ", StringUtils.getCommonPrefix("i am a machine", "i am a robot")); 
 }
@Test
public void testGetCommonPrefix_StringArray8869() { 
     assertEquals("", StringUtils.getCommonPrefix((String[]) null)); 
     assertEquals("", StringUtils.getCommonPrefix()); 
     assertEquals("abc", StringUtils.getCommonPrefix("abc")); 
     assertEquals("", StringUtils.getCommonPrefix(null, null)); 
     assertEquals("", StringUtils.getCommonPrefix("", "")); 
     assertEquals("", StringUtils.getCommonPrefix("", null)); 
     assertEquals("", StringUtils.getCommonPrefix("abc", null, null)); 
     assertEquals("", StringUtils.getCommonPrefix(null, null, "abc")); 
     assertEquals("", StringUtils.getCommonPrefix("", "abc")); 
     assertEquals("", StringUtils.getCommonPrefix("abc", "")); 
     assertEquals("abc", StringUtils.getCommonPrefix("abc", "abc")); 
     assertEquals("a", StringUtils.getCommonPrefix("abc", "a")); 
     assertEquals("ab", StringUtils.getCommonPrefix("ab", "abxyz")); 
     assertEquals("ab", StringUtils.getCommonPrefix("abcde", "abxyz")); 
     assertEquals("", StringUtils.getCommonPrefix("abcde", "xyz")); 
     assertEquals("", StringUtils.getCommonPrefix("xyz", "abcde")); 
     assertEquals("i am a ", StringUtils.getCommonPrefix("i am a machine", "i am a robot")); 
 }
@Test
public void testGetCommonPrefix_StringArray8872() { 
     assertEquals("", StringUtils.getCommonPrefix((String[]) null)); 
     assertEquals("", StringUtils.getCommonPrefix()); 
     assertEquals("abc", StringUtils.getCommonPrefix("abc")); 
     assertEquals("", StringUtils.getCommonPrefix(null, null)); 
     assertEquals("", StringUtils.getCommonPrefix("", "")); 
     assertEquals("", StringUtils.getCommonPrefix("", null)); 
     assertEquals("", StringUtils.getCommonPrefix("abc", null, null)); 
     assertEquals("", StringUtils.getCommonPrefix(null, null, "abc")); 
     assertEquals("", StringUtils.getCommonPrefix("", "abc")); 
     assertEquals("", StringUtils.getCommonPrefix("abc", "")); 
     assertEquals("abc", StringUtils.getCommonPrefix("abc", "abc")); 
     assertEquals("a", StringUtils.getCommonPrefix("abc", "a")); 
     assertEquals("ab", StringUtils.getCommonPrefix("ab", "abxyz")); 
     assertEquals("ab", StringUtils.getCommonPrefix("abcde", "abxyz")); 
     assertEquals("", StringUtils.getCommonPrefix("abcde", "xyz")); 
     assertEquals("", StringUtils.getCommonPrefix("xyz", "abcde")); 
     assertEquals("i am a ", StringUtils.getCommonPrefix("i am a machine", "i am a robot")); 
 }
@Test
public void testLeftPad_StringInt8876() { 
     assertEquals(null, StringUtils.leftPad(null, 5)); 
     assertEquals("     ", StringUtils.leftPad("", 5)); 
     assertEquals("  abc", StringUtils.leftPad("abc", 5)); 
     assertEquals("abc", StringUtils.leftPad("abc", 2)); 
 }
@Test
public void testGetLevenshteinDistance_StringStringInt8879() { 
     assertEquals(0, StringUtils.getLevenshteinDistance("", "", 0)); 
     assertEquals(7, StringUtils.getLevenshteinDistance("aaapppp", "", 8)); 
     assertEquals(7, StringUtils.getLevenshteinDistance("aaapppp", "", 7)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("aaapppp", "", 6)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("b", "a", 0)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("a", "b", 0)); 
     assertEquals(0, StringUtils.getLevenshteinDistance("aa", "aa", 0)); 
     assertEquals(0, StringUtils.getLevenshteinDistance("aa", "aa", 2)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("aaa", "bbb", 2)); 
     assertEquals(3, StringUtils.getLevenshteinDistance("aaa", "bbb", 3)); 
     assertEquals(6, StringUtils.getLevenshteinDistance("aaaaaa", "b", 10)); 
     assertEquals(7, StringUtils.getLevenshteinDistance("aaapppp", "b", 8)); 
     assertEquals(3, StringUtils.getLevenshteinDistance("a", "bbb", 4)); 
     assertEquals(7, StringUtils.getLevenshteinDistance("aaapppp", "b", 7)); 
     assertEquals(3, StringUtils.getLevenshteinDistance("a", "bbb", 3)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("a", "bbb", 2)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("bbb", "a", 2)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("aaapppp", "b", 6)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("a", "bbb", 1)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("bbb", "a", 1)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("12345", "1234567", 1)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("1234567", "12345", 1)); 
     assertEquals(1, StringUtils.getLevenshteinDistance("frog", "fog", 1)); 
     assertEquals(3, StringUtils.getLevenshteinDistance("fly", "ant", 3)); 
     assertEquals(7, StringUtils.getLevenshteinDistance("elephant", "hippo", 7)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("elephant", "hippo", 6)); 
     assertEquals(7, StringUtils.getLevenshteinDistance("hippo", "elephant", 7)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("hippo", "elephant", 6)); 
     assertEquals(8, StringUtils.getLevenshteinDistance("hippo", "zzzzzzzz", 8)); 
     assertEquals(8, StringUtils.getLevenshteinDistance("zzzzzzzz", "hippo", 8)); 
     assertEquals(1, StringUtils.getLevenshteinDistance("hello", "hallo", 1)); 
     try { 
         @SuppressWarnings("unused") 
         final int d = StringUtils.getLevenshteinDistance("a", null, 0); 
         fail("expecting IllegalArgumentException"); 
     } catch (final IllegalArgumentException ex) { 
     } 
     try { 
         @SuppressWarnings("unused") 
         final int d = StringUtils.getLevenshteinDistance(null, "a", 0); 
         fail("expecting IllegalArgumentException"); 
     } catch (final IllegalArgumentException ex) { 
     } 
     try { 
         @SuppressWarnings("unused") 
         final int d = StringUtils.getLevenshteinDistance("a", "a", -1); 
         fail("expecting IllegalArgumentException"); 
     } catch (final IllegalArgumentException ex) { 
     } 
 }
@Test
public void testDefaultIfBlank_StringBuffers8882() { 
     assertEquals("NULL", StringUtils.defaultIfBlank(new StringBuffer(""), new StringBuffer("NULL")).toString()); 
     assertEquals("NULL", StringUtils.defaultIfBlank(new StringBuffer(" "), new StringBuffer("NULL")).toString()); 
     assertEquals("abc", StringUtils.defaultIfBlank(new StringBuffer("abc"), new StringBuffer("NULL")).toString()); 
     assertNull(StringUtils.defaultIfBlank(new StringBuffer(""), null)); 
     final StringBuffer s = StringUtils.defaultIfBlank(new StringBuffer("abc"), new StringBuffer("NULL")); 
     assertEquals("abc", s.toString()); 
 }
@Test
public void testGetCommonPrefix_StringArray8898() { 
     assertEquals("", StringUtils.getCommonPrefix((String[]) null)); 
     assertEquals("", StringUtils.getCommonPrefix()); 
     assertEquals("abc", StringUtils.getCommonPrefix("abc")); 
     assertEquals("", StringUtils.getCommonPrefix(null, null)); 
     assertEquals("", StringUtils.getCommonPrefix("", "")); 
     assertEquals("", StringUtils.getCommonPrefix("", null)); 
     assertEquals("", StringUtils.getCommonPrefix("abc", null, null)); 
     assertEquals("", StringUtils.getCommonPrefix(null, null, "abc")); 
     assertEquals("", StringUtils.getCommonPrefix("", "abc")); 
     assertEquals("", StringUtils.getCommonPrefix("abc", "")); 
     assertEquals("abc", StringUtils.getCommonPrefix("abc", "abc")); 
     assertEquals("a", StringUtils.getCommonPrefix("abc", "a")); 
     assertEquals("ab", StringUtils.getCommonPrefix("ab", "abxyz")); 
     assertEquals("ab", StringUtils.getCommonPrefix("abcde", "abxyz")); 
     assertEquals("", StringUtils.getCommonPrefix("abcde", "xyz")); 
     assertEquals("", StringUtils.getCommonPrefix("xyz", "abcde")); 
     assertEquals("i am a ", StringUtils.getCommonPrefix("i am a machine", "i am a robot")); 
 }
@Test
public void testJoin_ArrayOfLongs8921() { 
     assertEquals(null, StringUtils.join((long[]) null, ',')); 
     assertEquals("1;2", StringUtils.join(LONG_PRIM_LIST, SEPARATOR_CHAR)); 
     assertEquals("2", StringUtils.join(LONG_PRIM_LIST, SEPARATOR_CHAR, 1, 2)); 
 }
@Test
public void testRemoveStartIgnoreCase8958() { 
     assertNull("removeStartIgnoreCase(null, null)", StringUtils.removeStartIgnoreCase(null, null)); 
     assertNull("removeStartIgnoreCase(null, \"\")", StringUtils.removeStartIgnoreCase(null, "")); 
     assertNull("removeStartIgnoreCase(null, \"a\")", StringUtils.removeStartIgnoreCase(null, "a")); 
     assertEquals("removeStartIgnoreCase(\"\", null)", StringUtils.removeStartIgnoreCase("", null), ""); 
     assertEquals("removeStartIgnoreCase(\"\", \"\")", StringUtils.removeStartIgnoreCase("", ""), ""); 
     assertEquals("removeStartIgnoreCase(\"\", \"a\")", StringUtils.removeStartIgnoreCase("", "a"), ""); 
     assertEquals("removeStartIgnoreCase(\"www.domain.com\", \"www.\")", StringUtils.removeStartIgnoreCase("www.domain.com", "www."), "domain.com"); 
     assertEquals("removeStartIgnoreCase(\"domain.com\", \"www.\")", StringUtils.removeStartIgnoreCase("domain.com", "www."), "domain.com"); 
     assertEquals("removeStartIgnoreCase(\"domain.com\", \"\")", StringUtils.removeStartIgnoreCase("domain.com", ""), "domain.com"); 
     assertEquals("removeStartIgnoreCase(\"domain.com\", null)", StringUtils.removeStartIgnoreCase("domain.com", null), "domain.com"); 
     assertEquals("removeStartIgnoreCase(\"www.domain.com\", \"WWW.\")", StringUtils.removeStartIgnoreCase("www.domain.com", "WWW."), "domain.com"); 
 }
@Test
public void testEscapeSurrogatePairsLang8588984() throws Exception { 
     assertEquals("\\uDBFF\\uDFFD", StringEscapeUtils.escapeJava("\uDBFF\uDFFD")); 
     assertEquals("\\uDBFF\\uDFFD", StringEscapeUtils.escapeEcmaScript("\uDBFF\uDFFD")); 
 }
@Test
public void testAbbreviate_StringIntInt8992() { 
     assertEquals(null, StringUtils.abbreviate(null, 10, 12)); 
     assertEquals("", StringUtils.abbreviate("", 0, 10)); 
     assertEquals("", StringUtils.abbreviate("", 2, 10)); 
     try { 
         @SuppressWarnings("unused") 
         final String res = StringUtils.abbreviate("abcdefghij", 0, 3); 
         fail("StringUtils.abbreviate expecting IllegalArgumentException"); 
     } catch (final IllegalArgumentException ex) { 
     } 
     try { 
         @SuppressWarnings("unused") 
         final String res = StringUtils.abbreviate("abcdefghij", 5, 6); 
         fail("StringUtils.abbreviate expecting IllegalArgumentException"); 
     } catch (final IllegalArgumentException ex) { 
     } 
     final String raspberry = "raspberry peach"; 
     assertEquals("raspberry peach", StringUtils.abbreviate(raspberry, 11, 15)); 
     assertEquals(null, StringUtils.abbreviate(null, 7, 14)); 
     assertAbbreviateWithOffset("abcdefg...", -1, 10); 
     assertAbbreviateWithOffset("abcdefg...", 0, 10); 
     assertAbbreviateWithOffset("abcdefg...", 1, 10); 
     assertAbbreviateWithOffset("abcdefg...", 2, 10); 
     assertAbbreviateWithOffset("abcdefg...", 3, 10); 
     assertAbbreviateWithOffset("abcdefg...", 4, 10); 
     assertAbbreviateWithOffset("...fghi...", 5, 10); 
     assertAbbreviateWithOffset("...ghij...", 6, 10); 
     assertAbbreviateWithOffset("...hijk...", 7, 10); 
     assertAbbreviateWithOffset("...ijklmno", 8, 10); 
     assertAbbreviateWithOffset("...ijklmno", 9, 10); 
     assertAbbreviateWithOffset("...ijklmno", 10, 10); 
     assertAbbreviateWithOffset("...ijklmno", 10, 10); 
     assertAbbreviateWithOffset("...ijklmno", 11, 10); 
     assertAbbreviateWithOffset("...ijklmno", 12, 10); 
     assertAbbreviateWithOffset("...ijklmno", 13, 10); 
     assertAbbreviateWithOffset("...ijklmno", 14, 10); 
     assertAbbreviateWithOffset("...ijklmno", 15, 10); 
     assertAbbreviateWithOffset("...ijklmno", 16, 10); 
     assertAbbreviateWithOffset("...ijklmno", Integer.MAX_VALUE, 10); 
 }
@Test
public void testSplit_String8994() { 
     assertArrayEquals(null, StringUtils.split(null)); 
     assertEquals(0, StringUtils.split("").length); 
     String str = "a b  .c"; 
     String[] res = StringUtils.split(str); 
     assertEquals(3, res.length); 
     assertEquals("a", res[0]); 
     assertEquals("b", res[1]); 
     assertEquals(".c", res[2]); 
     str = " a "; 
     res = StringUtils.split(str); 
     assertEquals(1, res.length); 
     assertEquals("a", res[0]); 
     str = "a" + WHITESPACE + "b" + NON_WHITESPACE + "c"; 
     res = StringUtils.split(str); 
     assertEquals(2, res.length); 
     assertEquals("a", res[0]); 
     assertEquals("b" + NON_WHITESPACE + "c", res[1]); 
 }
@Test
public void testGetLevenshteinDistance_StringStringInt9001() { 
     assertEquals(0, StringUtils.getLevenshteinDistance("", "", 0)); 
     assertEquals(7, StringUtils.getLevenshteinDistance("aaapppp", "", 8)); 
     assertEquals(7, StringUtils.getLevenshteinDistance("aaapppp", "", 7)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("aaapppp", "", 6)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("b", "a", 0)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("a", "b", 0)); 
     assertEquals(0, StringUtils.getLevenshteinDistance("aa", "aa", 0)); 
     assertEquals(0, StringUtils.getLevenshteinDistance("aa", "aa", 2)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("aaa", "bbb", 2)); 
     assertEquals(3, StringUtils.getLevenshteinDistance("aaa", "bbb", 3)); 
     assertEquals(6, StringUtils.getLevenshteinDistance("aaaaaa", "b", 10)); 
     assertEquals(7, StringUtils.getLevenshteinDistance("aaapppp", "b", 8)); 
     assertEquals(3, StringUtils.getLevenshteinDistance("a", "bbb", 4)); 
     assertEquals(7, StringUtils.getLevenshteinDistance("aaapppp", "b", 7)); 
     assertEquals(3, StringUtils.getLevenshteinDistance("a", "bbb", 3)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("a", "bbb", 2)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("bbb", "a", 2)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("aaapppp", "b", 6)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("a", "bbb", 1)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("bbb", "a", 1)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("12345", "1234567", 1)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("1234567", "12345", 1)); 
     assertEquals(1, StringUtils.getLevenshteinDistance("frog", "fog", 1)); 
     assertEquals(3, StringUtils.getLevenshteinDistance("fly", "ant", 3)); 
     assertEquals(7, StringUtils.getLevenshteinDistance("elephant", "hippo", 7)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("elephant", "hippo", 6)); 
     assertEquals(7, StringUtils.getLevenshteinDistance("hippo", "elephant", 7)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("hippo", "elephant", 6)); 
     assertEquals(8, StringUtils.getLevenshteinDistance("hippo", "zzzzzzzz", 8)); 
     assertEquals(8, StringUtils.getLevenshteinDistance("zzzzzzzz", "hippo", 8)); 
     assertEquals(1, StringUtils.getLevenshteinDistance("hello", "hallo", 1)); 
     try { 
         @SuppressWarnings("unused") 
         final int d = StringUtils.getLevenshteinDistance("a", null, 0); 
         fail("expecting IllegalArgumentException"); 
     } catch (final IllegalArgumentException ex) { 
     } 
     try { 
         @SuppressWarnings("unused") 
         final int d = StringUtils.getLevenshteinDistance(null, "a", 0); 
         fail("expecting IllegalArgumentException"); 
     } catch (final IllegalArgumentException ex) { 
     } 
     try { 
         @SuppressWarnings("unused") 
         final int d = StringUtils.getLevenshteinDistance("a", "a", -1); 
         fail("expecting IllegalArgumentException"); 
     } catch (final IllegalArgumentException ex) { 
     } 
 }
@Test
public void testJoin_ArrayOfFloats9036() { 
     assertEquals(null, StringUtils.join((float[]) null, ',')); 
     assertEquals("1.0;2.0", StringUtils.join(FLOAT_PRIM_LIST, SEPARATOR_CHAR)); 
     assertEquals("2.0", StringUtils.join(FLOAT_PRIM_LIST, SEPARATOR_CHAR, 1, 2)); 
 }
@Test
public void testReverse_String9038() { 
     assertEquals(null, StringUtils.reverse(null)); 
     assertEquals("", StringUtils.reverse("")); 
     assertEquals("sdrawkcab", StringUtils.reverse("backwards")); 
 }
@Test
public void testGetLevenshteinDistance_StringStringInt9044() { 
     assertEquals(0, StringUtils.getLevenshteinDistance("", "", 0)); 
     assertEquals(7, StringUtils.getLevenshteinDistance("aaapppp", "", 8)); 
     assertEquals(7, StringUtils.getLevenshteinDistance("aaapppp", "", 7)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("aaapppp", "", 6)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("b", "a", 0)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("a", "b", 0)); 
     assertEquals(0, StringUtils.getLevenshteinDistance("aa", "aa", 0)); 
     assertEquals(0, StringUtils.getLevenshteinDistance("aa", "aa", 2)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("aaa", "bbb", 2)); 
     assertEquals(3, StringUtils.getLevenshteinDistance("aaa", "bbb", 3)); 
     assertEquals(6, StringUtils.getLevenshteinDistance("aaaaaa", "b", 10)); 
     assertEquals(7, StringUtils.getLevenshteinDistance("aaapppp", "b", 8)); 
     assertEquals(3, StringUtils.getLevenshteinDistance("a", "bbb", 4)); 
     assertEquals(7, StringUtils.getLevenshteinDistance("aaapppp", "b", 7)); 
     assertEquals(3, StringUtils.getLevenshteinDistance("a", "bbb", 3)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("a", "bbb", 2)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("bbb", "a", 2)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("aaapppp", "b", 6)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("a", "bbb", 1)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("bbb", "a", 1)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("12345", "1234567", 1)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("1234567", "12345", 1)); 
     assertEquals(1, StringUtils.getLevenshteinDistance("frog", "fog", 1)); 
     assertEquals(3, StringUtils.getLevenshteinDistance("fly", "ant", 3)); 
     assertEquals(7, StringUtils.getLevenshteinDistance("elephant", "hippo", 7)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("elephant", "hippo", 6)); 
     assertEquals(7, StringUtils.getLevenshteinDistance("hippo", "elephant", 7)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("hippo", "elephant", 6)); 
     assertEquals(8, StringUtils.getLevenshteinDistance("hippo", "zzzzzzzz", 8)); 
     assertEquals(8, StringUtils.getLevenshteinDistance("zzzzzzzz", "hippo", 8)); 
     assertEquals(1, StringUtils.getLevenshteinDistance("hello", "hallo", 1)); 
     try { 
         @SuppressWarnings("unused") 
         final int d = StringUtils.getLevenshteinDistance("a", null, 0); 
         fail("expecting IllegalArgumentException"); 
     } catch (final IllegalArgumentException ex) { 
     } 
     try { 
         @SuppressWarnings("unused") 
         final int d = StringUtils.getLevenshteinDistance(null, "a", 0); 
         fail("expecting IllegalArgumentException"); 
     } catch (final IllegalArgumentException ex) { 
     } 
     try { 
         @SuppressWarnings("unused") 
         final int d = StringUtils.getLevenshteinDistance("a", "a", -1); 
         fail("expecting IllegalArgumentException"); 
     } catch (final IllegalArgumentException ex) { 
     } 
 }
@Test
public void testJoin_ArrayOfBytes9071() { 
     assertEquals(null, StringUtils.join((byte[]) null, ',')); 
     assertEquals("1;2", StringUtils.join(BYTE_PRIM_LIST, SEPARATOR_CHAR)); 
     assertEquals("2", StringUtils.join(BYTE_PRIM_LIST, SEPARATOR_CHAR, 1, 2)); 
 }
@Test
public void testRepeat_StringInt9092() { 
     assertEquals(null, StringUtils.repeat(null, 2)); 
     assertEquals("", StringUtils.repeat("ab", 0)); 
     assertEquals("", StringUtils.repeat("", 3)); 
     assertEquals("aaa", StringUtils.repeat("a", 3)); 
     assertEquals("ababab", StringUtils.repeat("ab", 3)); 
     assertEquals("abcabcabc", StringUtils.repeat("abc", 3)); 
     final String str = StringUtils.repeat("a", 10000); 
     assertEquals(10000, str.length()); 
     assertTrue(StringUtils.containsOnly(str, new char[] { 'a' })); 
 }
@Test
public void testReplace_StringStringString9115() { 
     assertEquals(null, StringUtils.replace(null, null, null)); 
     assertEquals(null, StringUtils.replace(null, null, "any")); 
     assertEquals(null, StringUtils.replace(null, "any", null)); 
     assertEquals(null, StringUtils.replace(null, "any", "any")); 
     assertEquals("", StringUtils.replace("", null, null)); 
     assertEquals("", StringUtils.replace("", null, "any")); 
     assertEquals("", StringUtils.replace("", "any", null)); 
     assertEquals("", StringUtils.replace("", "any", "any")); 
     assertEquals("FOO", StringUtils.replace("FOO", "", "any")); 
     assertEquals("FOO", StringUtils.replace("FOO", null, "any")); 
     assertEquals("FOO", StringUtils.replace("FOO", "F", null)); 
     assertEquals("FOO", StringUtils.replace("FOO", null, null)); 
     assertEquals("", StringUtils.replace("foofoofoo", "foo", "")); 
     assertEquals("barbarbar", StringUtils.replace("foofoofoo", "foo", "bar")); 
     assertEquals("farfarfar", StringUtils.replace("foofoofoo", "oo", "ar")); 
 }
@Test
public void testRemove_String9128() { 
     assertEquals(null, StringUtils.remove(null, null)); 
     assertEquals(null, StringUtils.remove(null, "")); 
     assertEquals(null, StringUtils.remove(null, "a")); 
     assertEquals("", StringUtils.remove("", null)); 
     assertEquals("", StringUtils.remove("", "")); 
     assertEquals("", StringUtils.remove("", "a")); 
     assertEquals(null, StringUtils.remove(null, null)); 
     assertEquals("", StringUtils.remove("", null)); 
     assertEquals("a", StringUtils.remove("a", null)); 
     assertEquals(null, StringUtils.remove(null, "")); 
     assertEquals("", StringUtils.remove("", "")); 
     assertEquals("a", StringUtils.remove("a", "")); 
     assertEquals("qd", StringUtils.remove("queued", "ue")); 
     assertEquals("queued", StringUtils.remove("queued", "zz")); 
 }
@Test
public void testJoin_ArrayOfChars9134() { 
     assertEquals(null, StringUtils.join((char[]) null, ',')); 
     assertEquals("1;2", StringUtils.join(CHAR_PRIM_LIST, SEPARATOR_CHAR)); 
     assertEquals("2", StringUtils.join(CHAR_PRIM_LIST, SEPARATOR_CHAR, 1, 2)); 
 }
@Test
public void testSplitByWholeSeparatorPreserveAllTokens_StringStringInt9135() { 
     assertArrayEquals(null, StringUtils.splitByWholeSeparatorPreserveAllTokens(null, ".", -1)); 
     assertEquals(0, StringUtils.splitByWholeSeparatorPreserveAllTokens("", ".", -1).length); 
     String input = "ab   de fg"; 
     String[] expected = new String[] { "ab", "", "", "de", "fg" }; 
     String[] actual = StringUtils.splitByWholeSeparatorPreserveAllTokens(input, null, -1); 
     assertEquals(expected.length, actual.length); 
     for (int i = 0; i < actual.length; i += 1) { 
         assertEquals(expected[i], actual[i]); 
     } 
     input = "1::2:::3::::4"; 
     expected = new String[] { "1", "", "2", "", "", "3", "", "", "", "4" }; 
     actual = StringUtils.splitByWholeSeparatorPreserveAllTokens(input, ":", -1); 
     assertEquals(expected.length, actual.length); 
     for (int i = 0; i < actual.length; i += 1) { 
         assertEquals(expected[i], actual[i]); 
     } 
     input = "1::2:::3::::4"; 
     expected = new String[] { "1", "2", ":3", "", "4" }; 
     actual = StringUtils.splitByWholeSeparatorPreserveAllTokens(input, "::", -1); 
     assertEquals(expected.length, actual.length); 
     for (int i = 0; i < actual.length; i += 1) { 
         assertEquals(expected[i], actual[i]); 
     } 
     input = "1::2::3:4"; 
     expected = new String[] { "1", "", "2", ":3:4" }; 
     actual = StringUtils.splitByWholeSeparatorPreserveAllTokens(input, ":", 4); 
     assertEquals(expected.length, actual.length); 
     for (int i = 0; i < actual.length; i += 1) { 
         assertEquals(expected[i], actual[i]); 
     } 
 }
@Test
public void testRemove_char9136() { 
     assertEquals(null, StringUtils.remove(null, 'a')); 
     assertEquals(null, StringUtils.remove(null, 'a')); 
     assertEquals(null, StringUtils.remove(null, 'a')); 
     assertEquals("", StringUtils.remove("", 'a')); 
     assertEquals("", StringUtils.remove("", 'a')); 
     assertEquals("", StringUtils.remove("", 'a')); 
     assertEquals("qeed", StringUtils.remove("queued", 'u')); 
     assertEquals("queued", StringUtils.remove("queued", 'z')); 
 } 
@SuppressWarnings("deprecation")
@Test
public void testChomp9148() { 
     final String[][] chompCases = { { FOO_UNCAP + "\r\n", FOO_UNCAP }, { FOO_UNCAP + "\n", FOO_UNCAP }, { FOO_UNCAP + "\r", FOO_UNCAP }, { FOO_UNCAP + " \r", FOO_UNCAP + " " }, { FOO_UNCAP, FOO_UNCAP }, { FOO_UNCAP + "\n\n", FOO_UNCAP + "\n" }, { FOO_UNCAP + "\r\n\r\n", FOO_UNCAP + "\r\n" }, { "foo\nfoo", "foo\nfoo" }, { "foo\n\rfoo", "foo\n\rfoo" }, { "\n", "" }, { "\r", "" }, { "a", "a" }, { "\r\n", "" }, { "", "" }, { null, null }, { FOO_UNCAP + "\n\r", FOO_UNCAP + "\n" } }; 
     for (final String[] chompCase : chompCases) { 
         final String original = chompCase[0]; 
         final String expectedResult = chompCase[1]; 
         assertEquals("chomp(String) failed", expectedResult, StringUtils.chomp(original)); 
     } 
     assertEquals("chomp(String, String) failed", "foo", StringUtils.chomp("foobar", "bar")); 
     assertEquals("chomp(String, String) failed", "foobar", StringUtils.chomp("foobar", "baz")); 
     assertEquals("chomp(String, String) failed", "foo", StringUtils.chomp("foo", "foooo")); 
     assertEquals("chomp(String, String) failed", "foobar", StringUtils.chomp("foobar", "")); 
     assertEquals("chomp(String, String) failed", "foobar", StringUtils.chomp("foobar", null)); 
     assertEquals("chomp(String, String) failed", "", StringUtils.chomp("", "foo")); 
     assertEquals("chomp(String, String) failed", "", StringUtils.chomp("", null)); 
     assertEquals("chomp(String, String) failed", "", StringUtils.chomp("", "")); 
     assertEquals("chomp(String, String) failed", null, StringUtils.chomp(null, "foo")); 
     assertEquals("chomp(String, String) failed", null, StringUtils.chomp(null, null)); 
     assertEquals("chomp(String, String) failed", null, StringUtils.chomp(null, "")); 
     assertEquals("chomp(String, String) failed", "", StringUtils.chomp("foo", "foo")); 
     assertEquals("chomp(String, String) failed", " ", StringUtils.chomp(" foo", "foo")); 
     assertEquals("chomp(String, String) failed", "foo ", StringUtils.chomp("foo ", "foo")); 
 } 
@SuppressWarnings("deprecation")
@Test
public void testChomp9161() { 
     final String[][] chompCases = { { FOO_UNCAP + "\r\n", FOO_UNCAP }, { FOO_UNCAP + "\n", FOO_UNCAP }, { FOO_UNCAP + "\r", FOO_UNCAP }, { FOO_UNCAP + " \r", FOO_UNCAP + " " }, { FOO_UNCAP, FOO_UNCAP }, { FOO_UNCAP + "\n\n", FOO_UNCAP + "\n" }, { FOO_UNCAP + "\r\n\r\n", FOO_UNCAP + "\r\n" }, { "foo\nfoo", "foo\nfoo" }, { "foo\n\rfoo", "foo\n\rfoo" }, { "\n", "" }, { "\r", "" }, { "a", "a" }, { "\r\n", "" }, { "", "" }, { null, null }, { FOO_UNCAP + "\n\r", FOO_UNCAP + "\n" } }; 
     for (final String[] chompCase : chompCases) { 
         final String original = chompCase[0]; 
         final String expectedResult = chompCase[1]; 
         assertEquals("chomp(String) failed", expectedResult, StringUtils.chomp(original)); 
     } 
     assertEquals("chomp(String, String) failed", "foo", StringUtils.chomp("foobar", "bar")); 
     assertEquals("chomp(String, String) failed", "foobar", StringUtils.chomp("foobar", "baz")); 
     assertEquals("chomp(String, String) failed", "foo", StringUtils.chomp("foo", "foooo")); 
     assertEquals("chomp(String, String) failed", "foobar", StringUtils.chomp("foobar", "")); 
     assertEquals("chomp(String, String) failed", "foobar", StringUtils.chomp("foobar", null)); 
     assertEquals("chomp(String, String) failed", "", StringUtils.chomp("", "foo")); 
     assertEquals("chomp(String, String) failed", "", StringUtils.chomp("", null)); 
     assertEquals("chomp(String, String) failed", "", StringUtils.chomp("", "")); 
     assertEquals("chomp(String, String) failed", null, StringUtils.chomp(null, "foo")); 
     assertEquals("chomp(String, String) failed", null, StringUtils.chomp(null, null)); 
     assertEquals("chomp(String, String) failed", null, StringUtils.chomp(null, "")); 
     assertEquals("chomp(String, String) failed", "", StringUtils.chomp("foo", "foo")); 
     assertEquals("chomp(String, String) failed", " ", StringUtils.chomp(" foo", "foo")); 
     assertEquals("chomp(String, String) failed", "foo ", StringUtils.chomp("foo ", "foo")); 
 }
@Test
public void testCenter_StringIntChar9198() { 
     assertEquals(null, StringUtils.center(null, -1, ' ')); 
     assertEquals(null, StringUtils.center(null, 4, ' ')); 
     assertEquals("    ", StringUtils.center("", 4, ' ')); 
     assertEquals("ab", StringUtils.center("ab", 0, ' ')); 
     assertEquals("ab", StringUtils.center("ab", -1, ' ')); 
     assertEquals("ab", StringUtils.center("ab", 1, ' ')); 
     assertEquals("    ", StringUtils.center("", 4, ' ')); 
     assertEquals(" ab ", StringUtils.center("ab", 4, ' ')); 
     assertEquals("abcd", StringUtils.center("abcd", 2, ' ')); 
     assertEquals(" a  ", StringUtils.center("a", 4, ' ')); 
     assertEquals("  a  ", StringUtils.center("a", 5, ' ')); 
     assertEquals("xxaxx", StringUtils.center("a", 5, 'x')); 
 }
@Test
public void testDeleteWhitespace_String9219() { 
     assertEquals(null, StringUtils.deleteWhitespace(null)); 
     assertEquals("", StringUtils.deleteWhitespace("")); 
     assertEquals("", StringUtils.deleteWhitespace("  \u000C  \t\t\u001F\n\n \u000B  ")); 
     assertEquals("", StringUtils.deleteWhitespace(StringUtilsTest.WHITESPACE)); 
     assertEquals(StringUtilsTest.NON_WHITESPACE, StringUtils.deleteWhitespace(StringUtilsTest.NON_WHITESPACE)); 
     assertEquals("\u00A0\u202F", StringUtils.deleteWhitespace("  \u00A0  \t\t\n\n \u202F  ")); 
     assertEquals("\u00A0\u202F", StringUtils.deleteWhitespace("\u00A0\u202F")); 
     assertEquals("test", StringUtils.deleteWhitespace("\u000Bt  \t\n\u0009e\rs\n\n   \tt")); 
 }
@Test
public void testRepeat_StringInt9235() { 
     assertEquals(null, StringUtils.repeat(null, 2)); 
     assertEquals("", StringUtils.repeat("ab", 0)); 
     assertEquals("", StringUtils.repeat("", 3)); 
     assertEquals("aaa", StringUtils.repeat("a", 3)); 
     assertEquals("ababab", StringUtils.repeat("ab", 3)); 
     assertEquals("abcabcabc", StringUtils.repeat("abc", 3)); 
     final String str = StringUtils.repeat("a", 10000); 
     assertEquals(10000, str.length()); 
     assertTrue(StringUtils.containsOnly(str, new char[] { 'a' })); 
 }
@Test
public void testJoin_ArrayOfFloats9245() { 
     assertEquals(null, StringUtils.join((float[]) null, ',')); 
     assertEquals("1.0;2.0", StringUtils.join(FLOAT_PRIM_LIST, SEPARATOR_CHAR)); 
     assertEquals("2.0", StringUtils.join(FLOAT_PRIM_LIST, SEPARATOR_CHAR, 1, 2)); 
 }
@Test
public void testLeftPad_StringIntString9248() { 
     assertEquals(null, StringUtils.leftPad(null, 5, "-+")); 
     assertEquals(null, StringUtils.leftPad(null, 5, null)); 
     assertEquals("     ", StringUtils.leftPad("", 5, " ")); 
     assertEquals("-+-+abc", StringUtils.leftPad("abc", 7, "-+")); 
     assertEquals("-+~abc", StringUtils.leftPad("abc", 6, "-+~")); 
     assertEquals("-+abc", StringUtils.leftPad("abc", 5, "-+~")); 
     assertEquals("abc", StringUtils.leftPad("abc", 2, " ")); 
     assertEquals("abc", StringUtils.leftPad("abc", -1, " ")); 
     assertEquals("  abc", StringUtils.leftPad("abc", 5, null)); 
     assertEquals("  abc", StringUtils.leftPad("abc", 5, "")); 
 }
@Test
public void testReplace_StringStringArrayStringArray9251() { 
     assertNull(StringUtils.replaceEach(null, new String[] { "a" }, new String[] { "b" })); 
     assertEquals(StringUtils.replaceEach("", new String[] { "a" }, new String[] { "b" }), ""); 
     assertEquals(StringUtils.replaceEach("aba", null, null), "aba"); 
     assertEquals(StringUtils.replaceEach("aba", new String[0], null), "aba"); 
     assertEquals(StringUtils.replaceEach("aba", null, new String[0]), "aba"); 
     assertEquals(StringUtils.replaceEach("aba", new String[] { "a" }, null), "aba"); 
     assertEquals(StringUtils.replaceEach("aba", new String[] { "a" }, new String[] { "" }), "b"); 
     assertEquals(StringUtils.replaceEach("aba", new String[] { null }, new String[] { "a" }), "aba"); 
     assertEquals(StringUtils.replaceEach("abcde", new String[] { "ab", "d" }, new String[] { "w", "t" }), "wcte"); 
     assertEquals(StringUtils.replaceEach("abcde", new String[] { "ab", "d" }, new String[] { "d", "t" }), "dcte"); 
     assertEquals("bcc", StringUtils.replaceEach("abc", new String[] { "a", "b" }, new String[] { "b", "c" })); 
     assertEquals("q651.506bera", StringUtils.replaceEach("d216.102oren", new String[] { "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "1", "2", "3", "4", "5", "6", "7", "8", "9" }, new String[] { "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z", "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "5", "6", "7", "8", "9", "1", "2", "3", "4" })); 
     assertEquals(StringUtils.replaceEach("aba", new String[] { "a" }, new String[] { null }), "aba"); 
     assertEquals(StringUtils.replaceEach("aba", new String[] { "a", "b" }, new String[] { "c", null }), "cbc"); 
 }
@Test
public void testJoin_ArrayOfShorts9252() { 
     assertEquals(null, StringUtils.join((short[]) null, ',')); 
     assertEquals("1;2", StringUtils.join(SHORT_PRIM_LIST, SEPARATOR_CHAR)); 
     assertEquals("2", StringUtils.join(SHORT_PRIM_LIST, SEPARATOR_CHAR, 1, 2)); 
 }
@Test
public void testEscapeSurrogatePairsLang8589255() throws Exception { 
     assertEquals("\\uDBFF\\uDFFD", StringEscapeUtils.escapeJava("\uDBFF\uDFFD")); 
     assertEquals("\\uDBFF\\uDFFD", StringEscapeUtils.escapeEcmaScript("\uDBFF\uDFFD")); 
 }
@Test
public void testOverlay_StringStringIntInt9269() { 
     assertEquals(null, StringUtils.overlay(null, null, 2, 4)); 
     assertEquals(null, StringUtils.overlay(null, null, -2, -4)); 
     assertEquals("", StringUtils.overlay("", null, 0, 0)); 
     assertEquals("", StringUtils.overlay("", "", 0, 0)); 
     assertEquals("zzzz", StringUtils.overlay("", "zzzz", 0, 0)); 
     assertEquals("zzzz", StringUtils.overlay("", "zzzz", 2, 4)); 
     assertEquals("zzzz", StringUtils.overlay("", "zzzz", -2, -4)); 
     assertEquals("abef", StringUtils.overlay("abcdef", null, 2, 4)); 
     assertEquals("abef", StringUtils.overlay("abcdef", null, 4, 2)); 
     assertEquals("abef", StringUtils.overlay("abcdef", "", 2, 4)); 
     assertEquals("abef", StringUtils.overlay("abcdef", "", 4, 2)); 
     assertEquals("abzzzzef", StringUtils.overlay("abcdef", "zzzz", 2, 4)); 
     assertEquals("abzzzzef", StringUtils.overlay("abcdef", "zzzz", 4, 2)); 
     assertEquals("zzzzef", StringUtils.overlay("abcdef", "zzzz", -1, 4)); 
     assertEquals("zzzzef", StringUtils.overlay("abcdef", "zzzz", 4, -1)); 
     assertEquals("zzzzabcdef", StringUtils.overlay("abcdef", "zzzz", -2, -1)); 
     assertEquals("zzzzabcdef", StringUtils.overlay("abcdef", "zzzz", -1, -2)); 
     assertEquals("abcdzzzz", StringUtils.overlay("abcdef", "zzzz", 4, 10)); 
     assertEquals("abcdzzzz", StringUtils.overlay("abcdef", "zzzz", 10, 4)); 
     assertEquals("abcdefzzzz", StringUtils.overlay("abcdef", "zzzz", 8, 10)); 
     assertEquals("abcdefzzzz", StringUtils.overlay("abcdef", "zzzz", 10, 8)); 
 }
@Test
public void testJoin_ArrayOfChars9299() { 
     assertEquals(null, StringUtils.join((char[]) null, ',')); 
     assertEquals("1;2", StringUtils.join(CHAR_PRIM_LIST, SEPARATOR_CHAR)); 
     assertEquals("2", StringUtils.join(CHAR_PRIM_LIST, SEPARATOR_CHAR, 1, 2)); 
 }
@Test
public void testDefaultIfBlank_StringBuffers9302() { 
     assertEquals("NULL", StringUtils.defaultIfBlank(new StringBuffer(""), new StringBuffer("NULL")).toString()); 
     assertEquals("NULL", StringUtils.defaultIfBlank(new StringBuffer(" "), new StringBuffer("NULL")).toString()); 
     assertEquals("abc", StringUtils.defaultIfBlank(new StringBuffer("abc"), new StringBuffer("NULL")).toString()); 
     assertNull(StringUtils.defaultIfBlank(new StringBuffer(""), null)); 
     final StringBuffer s = StringUtils.defaultIfBlank(new StringBuffer("abc"), new StringBuffer("NULL")); 
     assertEquals("abc", s.toString()); 
 }
@Test
public void testChop9304() { 
     final String[][] chopCases = { { FOO_UNCAP + "\r\n", FOO_UNCAP }, { FOO_UNCAP + "\n", FOO_UNCAP }, { FOO_UNCAP + "\r", FOO_UNCAP }, { FOO_UNCAP + " \r", FOO_UNCAP + " " }, { "foo", "fo" }, { "foo\nfoo", "foo\nfo" }, { "\n", "" }, { "\r", "" }, { "\r\n", "" }, { null, null }, { "", "" }, { "a", "" } }; 
     for (final String[] chopCase : chopCases) { 
         final String original = chopCase[0]; 
         final String expectedResult = chopCase[1]; 
         assertEquals("chop(String) failed", expectedResult, StringUtils.chop(original)); 
     } 
 }
@Test
public void testCenter_StringIntChar9311() { 
     assertEquals(null, StringUtils.center(null, -1, ' ')); 
     assertEquals(null, StringUtils.center(null, 4, ' ')); 
     assertEquals("    ", StringUtils.center("", 4, ' ')); 
     assertEquals("ab", StringUtils.center("ab", 0, ' ')); 
     assertEquals("ab", StringUtils.center("ab", -1, ' ')); 
     assertEquals("ab", StringUtils.center("ab", 1, ' ')); 
     assertEquals("    ", StringUtils.center("", 4, ' ')); 
     assertEquals(" ab ", StringUtils.center("ab", 4, ' ')); 
     assertEquals("abcd", StringUtils.center("abcd", 2, ' ')); 
     assertEquals(" a  ", StringUtils.center("a", 4, ' ')); 
     assertEquals("  a  ", StringUtils.center("a", 5, ' ')); 
     assertEquals("xxaxx", StringUtils.center("a", 5, 'x')); 
 }
@Test
public void testDeleteWhitespace_String9316() { 
     assertEquals(null, StringUtils.deleteWhitespace(null)); 
     assertEquals("", StringUtils.deleteWhitespace("")); 
     assertEquals("", StringUtils.deleteWhitespace("  \u000C  \t\t\u001F\n\n \u000B  ")); 
     assertEquals("", StringUtils.deleteWhitespace(StringUtilsTest.WHITESPACE)); 
     assertEquals(StringUtilsTest.NON_WHITESPACE, StringUtils.deleteWhitespace(StringUtilsTest.NON_WHITESPACE)); 
     assertEquals("\u00A0\u202F", StringUtils.deleteWhitespace("  \u00A0  \t\t\n\n \u202F  ")); 
     assertEquals("\u00A0\u202F", StringUtils.deleteWhitespace("\u00A0\u202F")); 
     assertEquals("test", StringUtils.deleteWhitespace("\u000Bt  \t\n\u0009e\rs\n\n   \tt")); 
 }
@Test
public void testJoin_ArrayOfFloats9330() { 
     assertEquals(null, StringUtils.join((float[]) null, ',')); 
     assertEquals("1.0;2.0", StringUtils.join(FLOAT_PRIM_LIST, SEPARATOR_CHAR)); 
     assertEquals("2.0", StringUtils.join(FLOAT_PRIM_LIST, SEPARATOR_CHAR, 1, 2)); 
 }
@Test
public void testAbbreviate_StringIntInt9335() { 
     assertEquals(null, StringUtils.abbreviate(null, 10, 12)); 
     assertEquals("", StringUtils.abbreviate("", 0, 10)); 
     assertEquals("", StringUtils.abbreviate("", 2, 10)); 
     try { 
         @SuppressWarnings("unused") 
         final String res = StringUtils.abbreviate("abcdefghij", 0, 3); 
         fail("StringUtils.abbreviate expecting IllegalArgumentException"); 
     } catch (final IllegalArgumentException ex) { 
     } 
     try { 
         @SuppressWarnings("unused") 
         final String res = StringUtils.abbreviate("abcdefghij", 5, 6); 
         fail("StringUtils.abbreviate expecting IllegalArgumentException"); 
     } catch (final IllegalArgumentException ex) { 
     } 
     final String raspberry = "raspberry peach"; 
     assertEquals("raspberry peach", StringUtils.abbreviate(raspberry, 11, 15)); 
     assertEquals(null, StringUtils.abbreviate(null, 7, 14)); 
     assertAbbreviateWithOffset("abcdefg...", -1, 10); 
     assertAbbreviateWithOffset("abcdefg...", 0, 10); 
     assertAbbreviateWithOffset("abcdefg...", 1, 10); 
     assertAbbreviateWithOffset("abcdefg...", 2, 10); 
     assertAbbreviateWithOffset("abcdefg...", 3, 10); 
     assertAbbreviateWithOffset("abcdefg...", 4, 10); 
     assertAbbreviateWithOffset("...fghi...", 5, 10); 
     assertAbbreviateWithOffset("...ghij...", 6, 10); 
     assertAbbreviateWithOffset("...hijk...", 7, 10); 
     assertAbbreviateWithOffset("...ijklmno", 8, 10); 
     assertAbbreviateWithOffset("...ijklmno", 9, 10); 
     assertAbbreviateWithOffset("...ijklmno", 10, 10); 
     assertAbbreviateWithOffset("...ijklmno", 10, 10); 
     assertAbbreviateWithOffset("...ijklmno", 11, 10); 
     assertAbbreviateWithOffset("...ijklmno", 12, 10); 
     assertAbbreviateWithOffset("...ijklmno", 13, 10); 
     assertAbbreviateWithOffset("...ijklmno", 14, 10); 
     assertAbbreviateWithOffset("...ijklmno", 15, 10); 
     assertAbbreviateWithOffset("...ijklmno", 16, 10); 
     assertAbbreviateWithOffset("...ijklmno", Integer.MAX_VALUE, 10); 
 }
@Test
public void testJoin_ArrayOfBytes9355() { 
     assertEquals(null, StringUtils.join((byte[]) null, ',')); 
     assertEquals("1;2", StringUtils.join(BYTE_PRIM_LIST, SEPARATOR_CHAR)); 
     assertEquals("2", StringUtils.join(BYTE_PRIM_LIST, SEPARATOR_CHAR, 1, 2)); 
 }
@Test
public void testReplace_StringStringStringInt9361() { 
     assertEquals(null, StringUtils.replace(null, null, null, 2)); 
     assertEquals(null, StringUtils.replace(null, null, "any", 2)); 
     assertEquals(null, StringUtils.replace(null, "any", null, 2)); 
     assertEquals(null, StringUtils.replace(null, "any", "any", 2)); 
     assertEquals("", StringUtils.replace("", null, null, 2)); 
     assertEquals("", StringUtils.replace("", null, "any", 2)); 
     assertEquals("", StringUtils.replace("", "any", null, 2)); 
     assertEquals("", StringUtils.replace("", "any", "any", 2)); 
     final String str = new String(new char[] { 'o', 'o', 'f', 'o', 'o' }); 
     assertSame(str, StringUtils.replace(str, "x", "", -1)); 
     assertEquals("f", StringUtils.replace("oofoo", "o", "", -1)); 
     assertEquals("oofoo", StringUtils.replace("oofoo", "o", "", 0)); 
     assertEquals("ofoo", StringUtils.replace("oofoo", "o", "", 1)); 
     assertEquals("foo", StringUtils.replace("oofoo", "o", "", 2)); 
     assertEquals("fo", StringUtils.replace("oofoo", "o", "", 3)); 
     assertEquals("f", StringUtils.replace("oofoo", "o", "", 4)); 
     assertEquals("f", StringUtils.replace("oofoo", "o", "", -5)); 
     assertEquals("f", StringUtils.replace("oofoo", "o", "", 1000)); 
 }
@Test
public void testJoin_ArrayOfChars9389() { 
     assertEquals(null, StringUtils.join((char[]) null, ',')); 
     assertEquals("1;2", StringUtils.join(CHAR_PRIM_LIST, SEPARATOR_CHAR)); 
     assertEquals("2", StringUtils.join(CHAR_PRIM_LIST, SEPARATOR_CHAR, 1, 2)); 
 }
@Test
public void testReplace_StringStringArrayStringArray9391() { 
     assertNull(StringUtils.replaceEach(null, new String[] { "a" }, new String[] { "b" })); 
     assertEquals(StringUtils.replaceEach("", new String[] { "a" }, new String[] { "b" }), ""); 
     assertEquals(StringUtils.replaceEach("aba", null, null), "aba"); 
     assertEquals(StringUtils.replaceEach("aba", new String[0], null), "aba"); 
     assertEquals(StringUtils.replaceEach("aba", null, new String[0]), "aba"); 
     assertEquals(StringUtils.replaceEach("aba", new String[] { "a" }, null), "aba"); 
     assertEquals(StringUtils.replaceEach("aba", new String[] { "a" }, new String[] { "" }), "b"); 
     assertEquals(StringUtils.replaceEach("aba", new String[] { null }, new String[] { "a" }), "aba"); 
     assertEquals(StringUtils.replaceEach("abcde", new String[] { "ab", "d" }, new String[] { "w", "t" }), "wcte"); 
     assertEquals(StringUtils.replaceEach("abcde", new String[] { "ab", "d" }, new String[] { "d", "t" }), "dcte"); 
     assertEquals("bcc", StringUtils.replaceEach("abc", new String[] { "a", "b" }, new String[] { "b", "c" })); 
     assertEquals("q651.506bera", StringUtils.replaceEach("d216.102oren", new String[] { "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "1", "2", "3", "4", "5", "6", "7", "8", "9" }, new String[] { "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z", "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "5", "6", "7", "8", "9", "1", "2", "3", "4" })); 
     assertEquals(StringUtils.replaceEach("aba", new String[] { "a" }, new String[] { null }), "aba"); 
     assertEquals(StringUtils.replaceEach("aba", new String[] { "a", "b" }, new String[] { "c", null }), "cbc"); 
 }
@Test
public void testOverlay_StringStringIntInt9398() { 
     assertEquals(null, StringUtils.overlay(null, null, 2, 4)); 
     assertEquals(null, StringUtils.overlay(null, null, -2, -4)); 
     assertEquals("", StringUtils.overlay("", null, 0, 0)); 
     assertEquals("", StringUtils.overlay("", "", 0, 0)); 
     assertEquals("zzzz", StringUtils.overlay("", "zzzz", 0, 0)); 
     assertEquals("zzzz", StringUtils.overlay("", "zzzz", 2, 4)); 
     assertEquals("zzzz", StringUtils.overlay("", "zzzz", -2, -4)); 
     assertEquals("abef", StringUtils.overlay("abcdef", null, 2, 4)); 
     assertEquals("abef", StringUtils.overlay("abcdef", null, 4, 2)); 
     assertEquals("abef", StringUtils.overlay("abcdef", "", 2, 4)); 
     assertEquals("abef", StringUtils.overlay("abcdef", "", 4, 2)); 
     assertEquals("abzzzzef", StringUtils.overlay("abcdef", "zzzz", 2, 4)); 
     assertEquals("abzzzzef", StringUtils.overlay("abcdef", "zzzz", 4, 2)); 
     assertEquals("zzzzef", StringUtils.overlay("abcdef", "zzzz", -1, 4)); 
     assertEquals("zzzzef", StringUtils.overlay("abcdef", "zzzz", 4, -1)); 
     assertEquals("zzzzabcdef", StringUtils.overlay("abcdef", "zzzz", -2, -1)); 
     assertEquals("zzzzabcdef", StringUtils.overlay("abcdef", "zzzz", -1, -2)); 
     assertEquals("abcdzzzz", StringUtils.overlay("abcdef", "zzzz", 4, 10)); 
     assertEquals("abcdzzzz", StringUtils.overlay("abcdef", "zzzz", 10, 4)); 
     assertEquals("abcdefzzzz", StringUtils.overlay("abcdef", "zzzz", 8, 10)); 
     assertEquals("abcdefzzzz", StringUtils.overlay("abcdef", "zzzz", 10, 8)); 
 }
@Test
public void testJoin_ArrayOfShorts9419() { 
     assertEquals(null, StringUtils.join((short[]) null, ',')); 
     assertEquals("1;2", StringUtils.join(SHORT_PRIM_LIST, SEPARATOR_CHAR)); 
     assertEquals("2", StringUtils.join(SHORT_PRIM_LIST, SEPARATOR_CHAR, 1, 2)); 
 }
@Test
public void testOverlay_StringStringIntInt9422() { 
     assertEquals(null, StringUtils.overlay(null, null, 2, 4)); 
     assertEquals(null, StringUtils.overlay(null, null, -2, -4)); 
     assertEquals("", StringUtils.overlay("", null, 0, 0)); 
     assertEquals("", StringUtils.overlay("", "", 0, 0)); 
     assertEquals("zzzz", StringUtils.overlay("", "zzzz", 0, 0)); 
     assertEquals("zzzz", StringUtils.overlay("", "zzzz", 2, 4)); 
     assertEquals("zzzz", StringUtils.overlay("", "zzzz", -2, -4)); 
     assertEquals("abef", StringUtils.overlay("abcdef", null, 2, 4)); 
     assertEquals("abef", StringUtils.overlay("abcdef", null, 4, 2)); 
     assertEquals("abef", StringUtils.overlay("abcdef", "", 2, 4)); 
     assertEquals("abef", StringUtils.overlay("abcdef", "", 4, 2)); 
     assertEquals("abzzzzef", StringUtils.overlay("abcdef", "zzzz", 2, 4)); 
     assertEquals("abzzzzef", StringUtils.overlay("abcdef", "zzzz", 4, 2)); 
     assertEquals("zzzzef", StringUtils.overlay("abcdef", "zzzz", -1, 4)); 
     assertEquals("zzzzef", StringUtils.overlay("abcdef", "zzzz", 4, -1)); 
     assertEquals("zzzzabcdef", StringUtils.overlay("abcdef", "zzzz", -2, -1)); 
     assertEquals("zzzzabcdef", StringUtils.overlay("abcdef", "zzzz", -1, -2)); 
     assertEquals("abcdzzzz", StringUtils.overlay("abcdef", "zzzz", 4, 10)); 
     assertEquals("abcdzzzz", StringUtils.overlay("abcdef", "zzzz", 10, 4)); 
     assertEquals("abcdefzzzz", StringUtils.overlay("abcdef", "zzzz", 8, 10)); 
     assertEquals("abcdefzzzz", StringUtils.overlay("abcdef", "zzzz", 10, 8)); 
 }
@Test
public void testJoin_ArrayOfShorts9430() { 
     assertEquals(null, StringUtils.join((short[]) null, ',')); 
     assertEquals("1;2", StringUtils.join(SHORT_PRIM_LIST, SEPARATOR_CHAR)); 
     assertEquals("2", StringUtils.join(SHORT_PRIM_LIST, SEPARATOR_CHAR, 1, 2)); 
 }
@Test
public void testRepeat_StringInt9440() { 
     assertEquals(null, StringUtils.repeat(null, 2)); 
     assertEquals("", StringUtils.repeat("ab", 0)); 
     assertEquals("", StringUtils.repeat("", 3)); 
     assertEquals("aaa", StringUtils.repeat("a", 3)); 
     assertEquals("ababab", StringUtils.repeat("ab", 3)); 
     assertEquals("abcabcabc", StringUtils.repeat("abc", 3)); 
     final String str = StringUtils.repeat("a", 10000); 
     assertEquals(10000, str.length()); 
     assertTrue(StringUtils.containsOnly(str, new char[] { 'a' })); 
 }
@Test
public void testJoin_IterableChar9457() { 
     assertEquals(null, StringUtils.join((Iterable<?>) null, ',')); 
     assertEquals(TEXT_LIST_CHAR, StringUtils.join(Arrays.asList(ARRAY_LIST), SEPARATOR_CHAR)); 
     assertEquals("", StringUtils.join(Arrays.asList(NULL_ARRAY_LIST), SEPARATOR_CHAR)); 
     assertEquals("", StringUtils.join(Arrays.asList(EMPTY_ARRAY_LIST), SEPARATOR_CHAR)); 
     assertEquals("foo", StringUtils.join(Collections.singleton("foo"), 'x')); 
 }
@Test
public void testCenter_StringIntChar9461() { 
     assertEquals(null, StringUtils.center(null, -1, ' ')); 
     assertEquals(null, StringUtils.center(null, 4, ' ')); 
     assertEquals("    ", StringUtils.center("", 4, ' ')); 
     assertEquals("ab", StringUtils.center("ab", 0, ' ')); 
     assertEquals("ab", StringUtils.center("ab", -1, ' ')); 
     assertEquals("ab", StringUtils.center("ab", 1, ' ')); 
     assertEquals("    ", StringUtils.center("", 4, ' ')); 
     assertEquals(" ab ", StringUtils.center("ab", 4, ' ')); 
     assertEquals("abcd", StringUtils.center("abcd", 2, ' ')); 
     assertEquals(" a  ", StringUtils.center("a", 4, ' ')); 
     assertEquals("  a  ", StringUtils.center("a", 5, ' ')); 
     assertEquals("xxaxx", StringUtils.center("a", 5, 'x')); 
 }
@Test
public void testAbbreviate_StringIntInt9482() { 
     assertEquals(null, StringUtils.abbreviate(null, 10, 12)); 
     assertEquals("", StringUtils.abbreviate("", 0, 10)); 
     assertEquals("", StringUtils.abbreviate("", 2, 10)); 
     try { 
         @SuppressWarnings("unused") 
         final String res = StringUtils.abbreviate("abcdefghij", 0, 3); 
         fail("StringUtils.abbreviate expecting IllegalArgumentException"); 
     } catch (final IllegalArgumentException ex) { 
     } 
     try { 
         @SuppressWarnings("unused") 
         final String res = StringUtils.abbreviate("abcdefghij", 5, 6); 
         fail("StringUtils.abbreviate expecting IllegalArgumentException"); 
     } catch (final IllegalArgumentException ex) { 
     } 
     final String raspberry = "raspberry peach"; 
     assertEquals("raspberry peach", StringUtils.abbreviate(raspberry, 11, 15)); 
     assertEquals(null, StringUtils.abbreviate(null, 7, 14)); 
     assertAbbreviateWithOffset("abcdefg...", -1, 10); 
     assertAbbreviateWithOffset("abcdefg...", 0, 10); 
     assertAbbreviateWithOffset("abcdefg...", 1, 10); 
     assertAbbreviateWithOffset("abcdefg...", 2, 10); 
     assertAbbreviateWithOffset("abcdefg...", 3, 10); 
     assertAbbreviateWithOffset("abcdefg...", 4, 10); 
     assertAbbreviateWithOffset("...fghi...", 5, 10); 
     assertAbbreviateWithOffset("...ghij...", 6, 10); 
     assertAbbreviateWithOffset("...hijk...", 7, 10); 
     assertAbbreviateWithOffset("...ijklmno", 8, 10); 
     assertAbbreviateWithOffset("...ijklmno", 9, 10); 
     assertAbbreviateWithOffset("...ijklmno", 10, 10); 
     assertAbbreviateWithOffset("...ijklmno", 10, 10); 
     assertAbbreviateWithOffset("...ijklmno", 11, 10); 
     assertAbbreviateWithOffset("...ijklmno", 12, 10); 
     assertAbbreviateWithOffset("...ijklmno", 13, 10); 
     assertAbbreviateWithOffset("...ijklmno", 14, 10); 
     assertAbbreviateWithOffset("...ijklmno", 15, 10); 
     assertAbbreviateWithOffset("...ijklmno", 16, 10); 
     assertAbbreviateWithOffset("...ijklmno", Integer.MAX_VALUE, 10); 
 }
@Test
public void testChop9484() { 
     final String[][] chopCases = { { FOO_UNCAP + "\r\n", FOO_UNCAP }, { FOO_UNCAP + "\n", FOO_UNCAP }, { FOO_UNCAP + "\r", FOO_UNCAP }, { FOO_UNCAP + " \r", FOO_UNCAP + " " }, { "foo", "fo" }, { "foo\nfoo", "foo\nfo" }, { "\n", "" }, { "\r", "" }, { "\r\n", "" }, { null, null }, { "", "" }, { "a", "" } }; 
     for (final String[] chopCase : chopCases) { 
         final String original = chopCase[0]; 
         final String expectedResult = chopCase[1]; 
         assertEquals("chop(String) failed", expectedResult, StringUtils.chop(original)); 
     } 
 }
@Test
public void testEscapeSurrogatePairsLang8589493() throws Exception { 
     assertEquals("\\uDBFF\\uDFFD", StringEscapeUtils.escapeJava("\uDBFF\uDFFD")); 
     assertEquals("\\uDBFF\\uDFFD", StringEscapeUtils.escapeEcmaScript("\uDBFF\uDFFD")); 
 }
@Test
public void testGetLevenshteinDistance_StringStringInt9495() { 
     assertEquals(0, StringUtils.getLevenshteinDistance("", "", 0)); 
     assertEquals(7, StringUtils.getLevenshteinDistance("aaapppp", "", 8)); 
     assertEquals(7, StringUtils.getLevenshteinDistance("aaapppp", "", 7)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("aaapppp", "", 6)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("b", "a", 0)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("a", "b", 0)); 
     assertEquals(0, StringUtils.getLevenshteinDistance("aa", "aa", 0)); 
     assertEquals(0, StringUtils.getLevenshteinDistance("aa", "aa", 2)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("aaa", "bbb", 2)); 
     assertEquals(3, StringUtils.getLevenshteinDistance("aaa", "bbb", 3)); 
     assertEquals(6, StringUtils.getLevenshteinDistance("aaaaaa", "b", 10)); 
     assertEquals(7, StringUtils.getLevenshteinDistance("aaapppp", "b", 8)); 
     assertEquals(3, StringUtils.getLevenshteinDistance("a", "bbb", 4)); 
     assertEquals(7, StringUtils.getLevenshteinDistance("aaapppp", "b", 7)); 
     assertEquals(3, StringUtils.getLevenshteinDistance("a", "bbb", 3)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("a", "bbb", 2)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("bbb", "a", 2)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("aaapppp", "b", 6)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("a", "bbb", 1)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("bbb", "a", 1)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("12345", "1234567", 1)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("1234567", "12345", 1)); 
     assertEquals(1, StringUtils.getLevenshteinDistance("frog", "fog", 1)); 
     assertEquals(3, StringUtils.getLevenshteinDistance("fly", "ant", 3)); 
     assertEquals(7, StringUtils.getLevenshteinDistance("elephant", "hippo", 7)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("elephant", "hippo", 6)); 
     assertEquals(7, StringUtils.getLevenshteinDistance("hippo", "elephant", 7)); 
     assertEquals(-1, StringUtils.getLevenshteinDistance("hippo", "elephant", 6)); 
     assertEquals(8, StringUtils.getLevenshteinDistance("hippo", "zzzzzzzz", 8)); 
     assertEquals(8, StringUtils.getLevenshteinDistance("zzzzzzzz", "hippo", 8)); 
     assertEquals(1, StringUtils.getLevenshteinDistance("hello", "hallo", 1)); 
     try { 
         @SuppressWarnings("unused") 
         final int d = StringUtils.getLevenshteinDistance("a", null, 0); 
         fail("expecting IllegalArgumentException"); 
     } catch (final IllegalArgumentException ex) { 
     } 
     try { 
         @SuppressWarnings("unused") 
         final int d = StringUtils.getLevenshteinDistance(null, "a", 0); 
         fail("expecting IllegalArgumentException"); 
     } catch (final IllegalArgumentException ex) { 
     } 
     try { 
         @SuppressWarnings("unused") 
         final int d = StringUtils.getLevenshteinDistance("a", "a", -1); 
         fail("expecting IllegalArgumentException"); 
     } catch (final IllegalArgumentException ex) { 
     } 
 }
@Test
public void testConstructor9498() { 
     assertNotNull(new StringUtils()); 
     final Constructor<?>[] cons = StringUtils.class.getDeclaredConstructors(); 
     assertEquals(1, cons.length); 
     assertTrue(Modifier.isPublic(cons[0].getModifiers())); 
     assertTrue(Modifier.isPublic(StringUtils.class.getModifiers())); 
     assertFalse(Modifier.isFinal(StringUtils.class.getModifiers())); 
 }
@Test
public void testJoin_IterableString9513() { 
     assertEquals(null, StringUtils.join((Iterable<?>) null, null)); 
     assertEquals(TEXT_LIST_NOSEP, StringUtils.join(Arrays.asList(ARRAY_LIST), null)); 
     assertEquals(TEXT_LIST_NOSEP, StringUtils.join(Arrays.asList(ARRAY_LIST), "")); 
     assertEquals("foo", StringUtils.join(Collections.singleton("foo"), "x")); 
     assertEquals("foo", StringUtils.join(Collections.singleton("foo"), null)); 
     assertEquals("", StringUtils.join(Arrays.asList(NULL_ARRAY_LIST), null)); 
     assertEquals("", StringUtils.join(Arrays.asList(EMPTY_ARRAY_LIST), null)); 
     assertEquals("", StringUtils.join(Arrays.asList(EMPTY_ARRAY_LIST), "")); 
     assertEquals("", StringUtils.join(Arrays.asList(EMPTY_ARRAY_LIST), SEPARATOR)); 
     assertEquals(TEXT_LIST, StringUtils.join(Arrays.asList(ARRAY_LIST), SEPARATOR)); 
 }
@Test
public void testSplitByCharacterType9522() { 
     assertNull(StringUtils.splitByCharacterType(null)); 
     assertEquals(0, StringUtils.splitByCharacterType("").length); 
     assertTrue(ArrayUtils.isEquals(new String[] { "ab", " ", "de", " ", "fg" }, StringUtils.splitByCharacterType("ab de fg"))); 
     assertTrue(ArrayUtils.isEquals(new String[] { "ab", "   ", "de", " ", "fg" }, StringUtils.splitByCharacterType("ab   de fg"))); 
     assertTrue(ArrayUtils.isEquals(new String[] { "ab", ":", "cd", ":", "ef" }, StringUtils.splitByCharacterType("ab:cd:ef"))); 
     assertTrue(ArrayUtils.isEquals(new String[] { "number", "5" }, StringUtils.splitByCharacterType("number5"))); 
     assertTrue(ArrayUtils.isEquals(new String[] { "foo", "B", "ar" }, StringUtils.splitByCharacterType("fooBar"))); 
     assertTrue(ArrayUtils.isEquals(new String[] { "foo", "200", "B", "ar" }, StringUtils.splitByCharacterType("foo200Bar"))); 
     assertTrue(ArrayUtils.isEquals(new String[] { "ASFR", "ules" }, StringUtils.splitByCharacterType("ASFRules"))); 
 }
@Test
public void testGetCommonPrefix_StringArray9523() { 
     assertEquals("", StringUtils.getCommonPrefix((String[]) null)); 
     assertEquals("", StringUtils.getCommonPrefix()); 
     assertEquals("abc", StringUtils.getCommonPrefix("abc")); 
     assertEquals("", StringUtils.getCommonPrefix(null, null)); 
     assertEquals("", StringUtils.getCommonPrefix("", "")); 
     assertEquals("", StringUtils.getCommonPrefix("", null)); 
     assertEquals("", StringUtils.getCommonPrefix("abc", null, null)); 
     assertEquals("", StringUtils.getCommonPrefix(null, null, "abc")); 
     assertEquals("", StringUtils.getCommonPrefix("", "abc")); 
     assertEquals("", StringUtils.getCommonPrefix("abc", "")); 
     assertEquals("abc", StringUtils.getCommonPrefix("abc", "abc")); 
     assertEquals("a", StringUtils.getCommonPrefix("abc", "a")); 
     assertEquals("ab", StringUtils.getCommonPrefix("ab", "abxyz")); 
     assertEquals("ab", StringUtils.getCommonPrefix("abcde", "abxyz")); 
     assertEquals("", StringUtils.getCommonPrefix("abcde", "xyz")); 
     assertEquals("", StringUtils.getCommonPrefix("xyz", "abcde")); 
     assertEquals("i am a ", StringUtils.getCommonPrefix("i am a machine", "i am a robot")); 
 }
@Test
public void testEscapeSurrogatePairsLang8589545() throws Exception { 
     assertEquals("\\uDBFF\\uDFFD", StringEscapeUtils.escapeJava("\uDBFF\uDFFD")); 
     assertEquals("\\uDBFF\\uDFFD", StringEscapeUtils.escapeEcmaScript("\uDBFF\uDFFD")); 
 }
@Test
public void testAppendIfMissingIgnoreCase9547() { 
     assertEquals("appendIfMissingIgnoreCase(null,null)", null, StringUtils.appendIfMissingIgnoreCase(null, null)); 
     assertEquals("appendIfMissingIgnoreCase(abc,null)", "abc", StringUtils.appendIfMissingIgnoreCase("abc", null)); 
     assertEquals("appendIfMissingIgnoreCase(\"\",xyz)", "xyz", StringUtils.appendIfMissingIgnoreCase("", "xyz")); 
     assertEquals("appendIfMissingIgnoreCase(abc,xyz)", "abcxyz", StringUtils.appendIfMissingIgnoreCase("abc", "xyz")); 
     assertEquals("appendIfMissingIgnoreCase(abcxyz,xyz)", "abcxyz", StringUtils.appendIfMissingIgnoreCase("abcxyz", "xyz")); 
     assertEquals("appendIfMissingIgnoreCase(abcXYZ,xyz)", "abcXYZ", StringUtils.appendIfMissingIgnoreCase("abcXYZ", "xyz")); 
     assertEquals("appendIfMissingIgnoreCase(null,null,null)", null, StringUtils.appendIfMissingIgnoreCase(null, null, (CharSequence[]) null)); 
     assertEquals("appendIfMissingIgnoreCase(abc,null,null)", "abc", StringUtils.appendIfMissingIgnoreCase("abc", null, (CharSequence[]) null)); 
     assertEquals("appendIfMissingIgnoreCase(\"\",xyz,null)", "xyz", StringUtils.appendIfMissingIgnoreCase("", "xyz", (CharSequence[]) null)); 
     assertEquals("appendIfMissingIgnoreCase(abc,xyz,{null})", "abcxyz", StringUtils.appendIfMissingIgnoreCase("abc", "xyz", new CharSequence[] { null })); 
     assertEquals("appendIfMissingIgnoreCase(abc,xyz,\"\")", "abc", StringUtils.appendIfMissingIgnoreCase("abc", "xyz", "")); 
     assertEquals("appendIfMissingIgnoreCase(abc,xyz,mno)", "abcxyz", StringUtils.appendIfMissingIgnoreCase("abc", "xyz", "mno")); 
     assertEquals("appendIfMissingIgnoreCase(abcxyz,xyz,mno)", "abcxyz", StringUtils.appendIfMissingIgnoreCase("abcxyz", "xyz", "mno")); 
     assertEquals("appendIfMissingIgnoreCase(abcmno,xyz,mno)", "abcmno", StringUtils.appendIfMissingIgnoreCase("abcmno", "xyz", "mno")); 
     assertEquals("appendIfMissingIgnoreCase(abcXYZ,xyz,mno)", "abcXYZ", StringUtils.appendIfMissingIgnoreCase("abcXYZ", "xyz", "mno")); 
     assertEquals("appendIfMissingIgnoreCase(abcMNO,xyz,mno)", "abcMNO", StringUtils.appendIfMissingIgnoreCase("abcMNO", "xyz", "mno")); 
 }
@Test
public void testGetCommonPrefix_StringArray9562() { 
     assertEquals("", StringUtils.getCommonPrefix((String[]) null)); 
     assertEquals("", StringUtils.getCommonPrefix()); 
     assertEquals("abc", StringUtils.getCommonPrefix("abc")); 
     assertEquals("", StringUtils.getCommonPrefix(null, null)); 
     assertEquals("", StringUtils.getCommonPrefix("", "")); 
     assertEquals("", StringUtils.getCommonPrefix("", null)); 
     assertEquals("", StringUtils.getCommonPrefix("abc", null, null)); 
     assertEquals("", StringUtils.getCommonPrefix(null, null, "abc")); 
     assertEquals("", StringUtils.getCommonPrefix("", "abc")); 
     assertEquals("", StringUtils.getCommonPrefix("abc", "")); 
     assertEquals("abc", StringUtils.getCommonPrefix("abc", "abc")); 
     assertEquals("a", StringUtils.getCommonPrefix("abc", "a")); 
     assertEquals("ab", StringUtils.getCommonPrefix("ab", "abxyz")); 
     assertEquals("ab", StringUtils.getCommonPrefix("abcde", "abxyz")); 
     assertEquals("", StringUtils.getCommonPrefix("abcde", "xyz")); 
     assertEquals("", StringUtils.getCommonPrefix("xyz", "abcde")); 
     assertEquals("i am a ", StringUtils.getCommonPrefix("i am a machine", "i am a robot")); 
 }
@Test
public void testRemove_char9563() { 
     assertEquals(null, StringUtils.remove(null, 'a')); 
     assertEquals(null, StringUtils.remove(null, 'a')); 
     assertEquals(null, StringUtils.remove(null, 'a')); 
     assertEquals("", StringUtils.remove("", 'a')); 
     assertEquals("", StringUtils.remove("", 'a')); 
     assertEquals("", StringUtils.remove("", 'a')); 
     assertEquals("qeed", StringUtils.remove("queued", 'u')); 
     assertEquals("queued", StringUtils.remove("queued", 'z')); 
 }
@Test
public void testSplitByWholeSeparatorPreserveAllTokens_StringStringInt9566() { 
     assertArrayEquals(null, StringUtils.splitByWholeSeparatorPreserveAllTokens(null, ".", -1)); 
     assertEquals(0, StringUtils.splitByWholeSeparatorPreserveAllTokens("", ".", -1).length); 
     String input = "ab   de fg"; 
     String[] expected = new String[] { "ab", "", "", "de", "fg" }; 
     String[] actual = StringUtils.splitByWholeSeparatorPreserveAllTokens(input, null, -1); 
     assertEquals(expected.length, actual.length); 
     for (int i = 0; i < actual.length; i += 1) { 
         assertEquals(expected[i], actual[i]); 
     } 
     input = "1::2:::3::::4"; 
     expected = new String[] { "1", "", "2", "", "", "3", "", "", "", "4" }; 
     actual = StringUtils.splitByWholeSeparatorPreserveAllTokens(input, ":", -1); 
     assertEquals(expected.length, actual.length); 
     for (int i = 0; i < actual.length; i += 1) { 
         assertEquals(expected[i], actual[i]); 
     } 
     input = "1::2:::3::::4"; 
     expected = new String[] { "1", "2", ":3", "", "4" }; 
     actual = StringUtils.splitByWholeSeparatorPreserveAllTokens(input, "::", -1); 
     assertEquals(expected.length, actual.length); 
     for (int i = 0; i < actual.length; i += 1) { 
         assertEquals(expected[i], actual[i]); 
     } 
     input = "1::2::3:4"; 
     expected = new String[] { "1", "", "2", ":3:4" }; 
     actual = StringUtils.splitByWholeSeparatorPreserveAllTokens(input, ":", 4); 
     assertEquals(expected.length, actual.length); 
     for (int i = 0; i < actual.length; i += 1) { 
         assertEquals(expected[i], actual[i]); 
     } 
 }
    
    
    //-----------------------------------------------------------------------
    

    

    //-----------------------------------------------------------------------
    

    
        
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    

    

    

    
    
    
    
    
    
    private void innerTestSplit(final char separator, final String sepStr, final char noMatch) {
        final String msg = "Failed on separator hex(" + Integer.toHexString(separator) +
            "), noMatch hex(" + Integer.toHexString(noMatch) + "), sepStr(" + sepStr + ")";
        
        final String str = "a" + separator + "b" + separator + separator + noMatch + "c";
        String[] res;
        // (str, sepStr)
        res = StringUtils.split(str, sepStr);
        assertEquals(msg, 3, res.length);
        assertEquals(msg, "a", res[0]);
        assertEquals(msg, "b", res[1]);
        assertEquals(msg, noMatch + "c", res[2]);
        
        final String str2 = separator + "a" + separator;
        res = StringUtils.split(str2, sepStr);
        assertEquals(msg, 1, res.length);
        assertEquals(msg, "a", res[0]);

        res = StringUtils.split(str, sepStr, -1);
        assertEquals(msg, 3, res.length);
        assertEquals(msg, "a", res[0]);
        assertEquals(msg, "b", res[1]);
        assertEquals(msg, noMatch + "c", res[2]);
        
        res = StringUtils.split(str, sepStr, 0);
        assertEquals(msg, 3, res.length);
        assertEquals(msg, "a", res[0]);
        assertEquals(msg, "b", res[1]);
        assertEquals(msg, noMatch + "c", res[2]);
        
        res = StringUtils.split(str, sepStr, 1);
        assertEquals(msg, 1, res.length);
        assertEquals(msg, str, res[0]);
        
        res = StringUtils.split(str, sepStr, 2);
        assertEquals(msg, 2, res.length);
        assertEquals(msg, "a", res[0]);
        assertEquals(msg, str.substring(2), res[1]);
    }

    

    

    
    
    
    
    
    
    
    
    private void innerTestSplitPreserveAllTokens(final char separator, final String sepStr, final char noMatch) {
        final String msg = "Failed on separator hex(" + Integer.toHexString(separator) +
            "), noMatch hex(" + Integer.toHexString(noMatch) + "), sepStr(" + sepStr + ")";
        
        final String str = "a" + separator + "b" + separator + separator + noMatch + "c";
        String[] res;
        // (str, sepStr)
        res = StringUtils.splitPreserveAllTokens(str, sepStr);
        assertEquals(msg, 4, res.length);
        assertEquals(msg, "a", res[0]);
        assertEquals(msg, "b", res[1]);
        assertEquals(msg, "", res[2]);
        assertEquals(msg, noMatch + "c", res[3]);
        
        final String str2 = separator + "a" + separator;
        res = StringUtils.splitPreserveAllTokens(str2, sepStr);
        assertEquals(msg, 3, res.length);
        assertEquals(msg, "", res[0]);
        assertEquals(msg, "a", res[1]);
        assertEquals(msg, "", res[2]);

        res = StringUtils.splitPreserveAllTokens(str, sepStr, -1);
        assertEquals(msg, 4, res.length);
        assertEquals(msg, "a", res[0]);
        assertEquals(msg, "b", res[1]);
        assertEquals(msg, "", res[2]);
        assertEquals(msg, noMatch + "c", res[3]);
        
        res = StringUtils.splitPreserveAllTokens(str, sepStr, 0);
        assertEquals(msg, 4, res.length);
        assertEquals(msg, "a", res[0]);
        assertEquals(msg, "b", res[1]);
        assertEquals(msg, "", res[2]);
        assertEquals(msg, noMatch + "c", res[3]);
        
        res = StringUtils.splitPreserveAllTokens(str, sepStr, 1);
        assertEquals(msg, 1, res.length);
        assertEquals(msg, str, res[0]);
        
        res = StringUtils.splitPreserveAllTokens(str, sepStr, 2);
        assertEquals(msg, 2, res.length);
        assertEquals(msg, "a", res[0]);
        assertEquals(msg, str.substring(2), res[1]);
    }

    
    
    

    

    

    
    
    
    
    
    
    
    
    

    /**
     * Test method for 'StringUtils.replaceEach(String, String[], String[])'
     */
    

    /**
     * Test method for 'StringUtils.replaceEachRepeatedly(String, String[], String[])'
     */
    
    
    
    
    
    
    

    

    

    

    

    //-----------------------------------------------------------------------
    

    

    
        
    //-----------------------------------------------------------------------
    
        
    
        
    

    

    

    
    
    

    //-----------------------------------------------------------------------
    
    
    
    
    

    //-----------------------------------------------------------------------
    
        
    

    //-----------------------------------------------------------------------
    

    

    

    

    

    

    

    

    

    

    //-----------------------------------------------------------------------
    
    
    

    private void assertAbbreviateWithOffset(final String expected, final int offset, final int maxWidth) {
        final String abcdefghijklmno = "abcdefghijklmno";
        final String message = "abbreviate(String,int,int) failed";
        final String actual = StringUtils.abbreviate(abcdefghijklmno, offset, maxWidth);
        if (offset >= 0 && offset < abcdefghijklmno.length()) {
            assertTrue(message + " -- should contain offset character",
                    actual.indexOf((char)('a'+offset)) != -1);
        }
        assertTrue(message + " -- should not be greater than maxWidth",
                actual.length() <= maxWidth);
        assertEquals(message, expected, actual);
    }

    

    //-----------------------------------------------------------------------
    

    

    //-----------------------------------------------------------------------
    

    

    /**
     * A sanity check for {@link StringUtils#EMPTY}.
     */
    

    /**
     * Test for {@link StringUtils#isAllLowerCase(CharSequence)}.
     */
    

    /**
     * Test for {@link StringUtils#isAllUpperCase(CharSequence)}.
     */
    

    
    
    

    

    

    

    
    
    
    
    
        
    

    

    // Methods on StringUtils that are immutable in spirit (i.e. calculate the length) 
    // should take a CharSequence parameter. Methods that are mutable in spirit (i.e. capitalize) 
    // should take a String or String[] parameter and return String or String[].
    // This test enforces that this is done.
    

    /**
     * Tests {@link StringUtils#toString(byte[], String)}
     * 
     * @throws UnsupportedEncodingException
     * @see StringUtils#toString(byte[], String)
     */
    
    
    
    
    /**
     * Tests LANG-858.
     * 
     * @throws Exception
     */
    
    
    

    /**
     * Tests {@code appendIfMissing}.
     */
    

    /**
     * Tests {@code appendIfMissingIgnoreCase}.
     */
    

    /**
     * Tests {@code prependIfMissing}.
     */
    

    /**
     * Tests {@code prependIfMissingIgnoreCase}.
     */
    
}
