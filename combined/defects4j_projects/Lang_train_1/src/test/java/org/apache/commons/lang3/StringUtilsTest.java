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
public void testEscapeSurrogatePairs214() throws Exception { 
     assertEquals("\uD83D\uDE30", StringEscapeUtils.escapeCsv("\uD83D\uDE30")); 
     assertEquals("\uD800\uDC00", StringEscapeUtils.escapeCsv("\uD800\uDC00")); 
     assertEquals("\uD834\uDD1E", StringEscapeUtils.escapeCsv("\uD834\uDD1E")); 
     assertEquals("\uDBFF\uDFFD", StringEscapeUtils.escapeCsv("\uDBFF\uDFFD")); 
     assertEquals("\uDBFF\uDFFD", StringEscapeUtils.escapeHtml3("\uDBFF\uDFFD")); 
     assertEquals("\uDBFF\uDFFD", StringEscapeUtils.escapeHtml4("\uDBFF\uDFFD")); 
     assertEquals("\uDBFF\uDFFD", StringEscapeUtils.escapeXml("\uDBFF\uDFFD")); 
 }
@Test
public void testAppendIfMissing277() { 
     assertEquals("appendIfMissing(null,null)", null, StringUtils.appendIfMissing(null, null)); 
     assertEquals("appendIfMissing(abc,null)", "abc", StringUtils.appendIfMissing("abc", null)); 
     assertEquals("appendIfMissing(\"\",xyz)", "xyz", StringUtils.appendIfMissing("", "xyz")); 
     assertEquals("appendIfMissing(abc,xyz)", "abcxyz", StringUtils.appendIfMissing("abc", "xyz")); 
     assertEquals("appendIfMissing(abcxyz,xyz)", "abcxyz", StringUtils.appendIfMissing("abcxyz", "xyz")); 
     assertEquals("appendIfMissing(aXYZ,xyz)", "aXYZxyz", StringUtils.appendIfMissing("aXYZ", "xyz")); 
     assertEquals("appendIfMissing(null,null,null)", null, StringUtils.appendIfMissing(null, null, (CharSequence[]) null)); 
     assertEquals("appendIfMissing(abc,null,null)", "abc", StringUtils.appendIfMissing("abc", null, (CharSequence[]) null)); 
     assertEquals("appendIfMissing(\"\",xyz,null))", "xyz", StringUtils.appendIfMissing("", "xyz", (CharSequence[]) null)); 
     assertEquals("appendIfMissing(abc,xyz,{null})", "abcxyz", StringUtils.appendIfMissing("abc", "xyz", new CharSequence[] { null })); 
     assertEquals("appendIfMissing(abc,xyz,\"\")", "abc", StringUtils.appendIfMissing("abc", "xyz", "")); 
     assertEquals("appendIfMissing(abc,xyz,mno)", "abcxyz", StringUtils.appendIfMissing("abc", "xyz", "mno")); 
     assertEquals("appendIfMissing(abcxyz,xyz,mno)", "abcxyz", StringUtils.appendIfMissing("abcxyz", "xyz", "mno")); 
     assertEquals("appendIfMissing(abcmno,xyz,mno)", "abcmno", StringUtils.appendIfMissing("abcmno", "xyz", "mno")); 
     assertEquals("appendIfMissing(abcXYZ,xyz,mno)", "abcXYZxyz", StringUtils.appendIfMissing("abcXYZ", "xyz", "mno")); 
     assertEquals("appendIfMissing(abcMNO,xyz,mno)", "abcMNOxyz", StringUtils.appendIfMissing("abcMNO", "xyz", "mno")); 
 }
@Test
public void testEscapeSurrogatePairsLang858300() throws Exception { 
     assertEquals("\\uDBFF\\uDFFD", StringEscapeUtils.escapeJava("\uDBFF\uDFFD")); 
     assertEquals("\\uDBFF\\uDFFD", StringEscapeUtils.escapeEcmaScript("\uDBFF\uDFFD")); 
 }
@Test
public void testJoin_IterableChar894() { 
     assertEquals(null, StringUtils.join((Iterable<?>) null, ',')); 
     assertEquals(TEXT_LIST_CHAR, StringUtils.join(Arrays.asList(ARRAY_LIST), SEPARATOR_CHAR)); 
     assertEquals("", StringUtils.join(Arrays.asList(NULL_ARRAY_LIST), SEPARATOR_CHAR)); 
     assertEquals("", StringUtils.join(Arrays.asList(EMPTY_ARRAY_LIST), SEPARATOR_CHAR)); 
     assertEquals("foo", StringUtils.join(Collections.singleton("foo"), 'x')); 
 }
@Test
public void testConstructor982() { 
     assertNotNull(new StringUtils()); 
     final Constructor<?>[] cons = StringUtils.class.getDeclaredConstructors(); 
     assertEquals(1, cons.length); 
     assertTrue(Modifier.isPublic(cons[0].getModifiers())); 
     assertTrue(Modifier.isPublic(StringUtils.class.getModifiers())); 
     assertFalse(Modifier.isFinal(StringUtils.class.getModifiers())); 
 }
@Test
public void testLANG666993() { 
     assertEquals("12", StringUtils.stripEnd("120.00", ".0")); 
     assertEquals("121", StringUtils.stripEnd("121.00", ".0")); 
 }
@Test
public void testLeftPad_StringIntChar1014() { 
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
public void testReverseDelimited_StringChar1033() { 
     assertEquals(null, StringUtils.reverseDelimited(null, '.')); 
     assertEquals("", StringUtils.reverseDelimited("", '.')); 
     assertEquals("c.b.a", StringUtils.reverseDelimited("a.b.c", '.')); 
     assertEquals("a b c", StringUtils.reverseDelimited("a b c", '.')); 
     assertEquals("", StringUtils.reverseDelimited("", '.')); 
 }
@Test
public void testSplit_StringString_StringStringInt1034() { 
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
public void testSplitByWholeString_StringStringBooleanInt1035() { 
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
public void testSplitByWholeSeparatorPreserveAllTokens_StringStringInt1036() { 
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
public void testSplitPreserveAllTokens_String1037() { 
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
public void testSplitPreserveAllTokens_StringChar1038() { 
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
public void testSplitPreserveAllTokens_StringString_StringStringInt1039() { 
     assertArrayEquals(null, StringUtils.splitPreserveAllTokens(null, ".")); 
     assertArrayEquals(null, StringUtils.splitPreserveAllTokens(null, ".", 3)); 
     assertEquals(0, StringUtils.splitPreserveAllTokens("", ".").length); 
     assertEquals(0, StringUtils.splitPreserveAllTokens("", ".", 3).length); 
     innerTestSplitPreserveAllTokens('.', ".", ' '); 
     innerTestSplitPreserveAllTokens('.', ".", ','); 
     innerTestSplitPreserveAllTokens('.', ".,", 'x'); 
     for (int i = 0; i < WHITESPACE.length(); i++) { 
         for (int j = 0; j < NON_WHITESPACE.length(); j++) { 
             innerTestSplitPreserveAllTokens(WHITESPACE.charAt(i), null, NON_WHITESPACE.charAt(j)); 
             innerTestSplitPreserveAllTokens(WHITESPACE.charAt(i), String.valueOf(WHITESPACE.charAt(i)), NON_WHITESPACE.charAt(j)); 
         } 
     } 
     { 
         String[] results; 
         final String[] expectedResults = { "ab", "de fg" }; 
         results = StringUtils.splitPreserveAllTokens("ab de fg", null, 2); 
         assertEquals(expectedResults.length, results.length); 
         for (int i = 0; i < expectedResults.length; i++) { 
             assertEquals(expectedResults[i], results[i]); 
         } 
     } 
     { 
         String[] results; 
         final String[] expectedResults = { "ab", "  de fg" }; 
         results = StringUtils.splitPreserveAllTokens("ab   de fg", null, 2); 
         assertEquals(expectedResults.length, results.length); 
         for (int i = 0; i < expectedResults.length; i++) { 
             assertEquals(expectedResults[i], results[i]); 
         } 
     } 
     { 
         String[] results; 
         final String[] expectedResults = { "ab", "::de:fg" }; 
         results = StringUtils.splitPreserveAllTokens("ab:::de:fg", ":", 2); 
         assertEquals(expectedResults.length, results.length); 
         for (int i = 0; i < expectedResults.length; i++) { 
             assertEquals(expectedResults[i], results[i]); 
         } 
     } 
     { 
         String[] results; 
         final String[] expectedResults = { "ab", "", " de fg" }; 
         results = StringUtils.splitPreserveAllTokens("ab   de fg", null, 3); 
         assertEquals(expectedResults.length, results.length); 
         for (int i = 0; i < expectedResults.length; i++) { 
             assertEquals(expectedResults[i], results[i]); 
         } 
     } 
     { 
         String[] results; 
         final String[] expectedResults = { "ab", "", "", "de fg" }; 
         results = StringUtils.splitPreserveAllTokens("ab   de fg", null, 4); 
         assertEquals(expectedResults.length, results.length); 
         for (int i = 0; i < expectedResults.length; i++) { 
             assertEquals(expectedResults[i], results[i]); 
         } 
     } 
     { 
         final String[] expectedResults = { "ab", "cd:ef" }; 
         String[] results; 
         results = StringUtils.splitPreserveAllTokens("ab:cd:ef", ":", 2); 
         assertEquals(expectedResults.length, results.length); 
         for (int i = 0; i < expectedResults.length; i++) { 
             assertEquals(expectedResults[i], results[i]); 
         } 
     } 
     { 
         String[] results; 
         final String[] expectedResults = { "ab", ":cd:ef" }; 
         results = StringUtils.splitPreserveAllTokens("ab::cd:ef", ":", 2); 
         assertEquals(expectedResults.length, results.length); 
         for (int i = 0; i < expectedResults.length; i++) { 
             assertEquals(expectedResults[i], results[i]); 
         } 
     } 
     { 
         String[] results; 
         final String[] expectedResults = { "ab", "", ":cd:ef" }; 
         results = StringUtils.splitPreserveAllTokens("ab:::cd:ef", ":", 3); 
         assertEquals(expectedResults.length, results.length); 
         for (int i = 0; i < expectedResults.length; i++) { 
             assertEquals(expectedResults[i], results[i]); 
         } 
     } 
     { 
         String[] results; 
         final String[] expectedResults = { "ab", "", "", "cd:ef" }; 
         results = StringUtils.splitPreserveAllTokens("ab:::cd:ef", ":", 4); 
         assertEquals(expectedResults.length, results.length); 
         for (int i = 0; i < expectedResults.length; i++) { 
             assertEquals(expectedResults[i], results[i]); 
         } 
     } 
     { 
         String[] results; 
         final String[] expectedResults = { "", "ab", "", "", "cd:ef" }; 
         results = StringUtils.splitPreserveAllTokens(":ab:::cd:ef", ":", 5); 
         assertEquals(expectedResults.length, results.length); 
         for (int i = 0; i < expectedResults.length; i++) { 
             assertEquals(expectedResults[i], results[i]); 
         } 
     } 
     { 
         String[] results; 
         final String[] expectedResults = { "", "", "ab", "", "", "cd:ef" }; 
         results = StringUtils.splitPreserveAllTokens("::ab:::cd:ef", ":", 6); 
         assertEquals(expectedResults.length, results.length); 
         for (int i = 0; i < expectedResults.length; i++) { 
             assertEquals(expectedResults[i], results[i]); 
         } 
     } 
 }
@Test
public void testSplitByCharacterType1040() { 
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
public void testSplitByCharacterTypeCamelCase1041() { 
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
public void testJoin_ArrayCharSeparator1042() { 
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
public void testJoin_ArrayOfInts1043() { 
     assertEquals(null, StringUtils.join((int[]) null, ',')); 
     assertEquals("1;2", StringUtils.join(INT_PRIM_LIST, SEPARATOR_CHAR)); 
     assertEquals("2", StringUtils.join(INT_PRIM_LIST, SEPARATOR_CHAR, 1, 2)); 
 }
@Test
public void testJoin_ArrayOfBytes1044() { 
     assertEquals(null, StringUtils.join((byte[]) null, ',')); 
     assertEquals("1;2", StringUtils.join(BYTE_PRIM_LIST, SEPARATOR_CHAR)); 
     assertEquals("2", StringUtils.join(BYTE_PRIM_LIST, SEPARATOR_CHAR, 1, 2)); 
 }
@Test
public void testJoin_ArrayOfChars1045() { 
     assertEquals(null, StringUtils.join((char[]) null, ',')); 
     assertEquals("1;2", StringUtils.join(CHAR_PRIM_LIST, SEPARATOR_CHAR)); 
     assertEquals("2", StringUtils.join(CHAR_PRIM_LIST, SEPARATOR_CHAR, 1, 2)); 
 }
@Test
public void testJoin_ArrayOfFloats1046() { 
     assertEquals(null, StringUtils.join((float[]) null, ',')); 
     assertEquals("1.0;2.0", StringUtils.join(FLOAT_PRIM_LIST, SEPARATOR_CHAR)); 
     assertEquals("2.0", StringUtils.join(FLOAT_PRIM_LIST, SEPARATOR_CHAR, 1, 2)); 
 }
@Test
public void testJoin_ArrayString1047() { 
     assertEquals(null, StringUtils.join((Object[]) null, null)); 
     assertEquals(TEXT_LIST_NOSEP, StringUtils.join(ARRAY_LIST, null)); 
     assertEquals(TEXT_LIST_NOSEP, StringUtils.join(ARRAY_LIST, "")); 
     assertEquals("", StringUtils.join(NULL_ARRAY_LIST, null)); 
     assertEquals("", StringUtils.join(EMPTY_ARRAY_LIST, null)); 
     assertEquals("", StringUtils.join(EMPTY_ARRAY_LIST, "")); 
     assertEquals("", StringUtils.join(EMPTY_ARRAY_LIST, SEPARATOR)); 
     assertEquals(TEXT_LIST, StringUtils.join(ARRAY_LIST, SEPARATOR)); 
     assertEquals(",,foo", StringUtils.join(MIXED_ARRAY_LIST, SEPARATOR)); 
     assertEquals("foo,2", StringUtils.join(MIXED_TYPE_LIST, SEPARATOR)); 
     assertEquals("/", StringUtils.join(MIXED_ARRAY_LIST, "/", 0, MIXED_ARRAY_LIST.length - 1)); 
     assertEquals("", StringUtils.join(MIXED_ARRAY_LIST, "", 0, MIXED_ARRAY_LIST.length - 1)); 
     assertEquals("foo", StringUtils.join(MIXED_TYPE_LIST, "/", 0, 1)); 
     assertEquals("foo/2", StringUtils.join(MIXED_TYPE_LIST, "/", 0, 2)); 
     assertEquals("2", StringUtils.join(MIXED_TYPE_LIST, "/", 1, 2)); 
     assertEquals("", StringUtils.join(MIXED_TYPE_LIST, "/", 2, 1)); 
 }
@Test
public void testJoin_IteratorChar1048() { 
     assertEquals(null, StringUtils.join((Iterator<?>) null, ',')); 
     assertEquals(TEXT_LIST_CHAR, StringUtils.join(Arrays.asList(ARRAY_LIST).iterator(), SEPARATOR_CHAR)); 
     assertEquals("", StringUtils.join(Arrays.asList(NULL_ARRAY_LIST).iterator(), SEPARATOR_CHAR)); 
     assertEquals("", StringUtils.join(Arrays.asList(EMPTY_ARRAY_LIST).iterator(), SEPARATOR_CHAR)); 
     assertEquals("foo", StringUtils.join(Collections.singleton("foo").iterator(), 'x')); 
 }
@Test
public void testJoin_IteratorString1049() { 
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
public void testJoin_IterableString1050() { 
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
public void testDeleteWhitespace_String1051() { 
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
public void testRemoveStartIgnoreCase1052() { 
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
public void testRemoveEnd1053() { 
     assertNull(StringUtils.removeEnd(null, null)); 
     assertNull(StringUtils.removeEnd(null, "")); 
     assertNull(StringUtils.removeEnd(null, "a")); 
     assertEquals(StringUtils.removeEnd("", null), ""); 
     assertEquals(StringUtils.removeEnd("", ""), ""); 
     assertEquals(StringUtils.removeEnd("", "a"), ""); 
     assertEquals(StringUtils.removeEnd("www.domain.com.", ".com"), "www.domain.com."); 
     assertEquals(StringUtils.removeEnd("www.domain.com", ".com"), "www.domain"); 
     assertEquals(StringUtils.removeEnd("www.domain", ".com"), "www.domain"); 
     assertEquals(StringUtils.removeEnd("domain.com", ""), "domain.com"); 
     assertEquals(StringUtils.removeEnd("domain.com", null), "domain.com"); 
 }
@Test
public void testRemoveEndIgnoreCase1054() { 
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
public void testRemove_String1055() { 
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
public void testRemove_char1056() { 
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
public void testReplaceOnce_StringStringString1057() { 
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
public void testReplacePattern1058() { 
     assertEquals("X", StringUtils.replacePattern("<A>\nxy\n</A>", "<A>.*</A>", "X")); 
 }
@Test
public void testRemovePattern1059() { 
     assertEquals("", StringUtils.removePattern("<A>x\\ny</A>", "<A>.*</A>")); 
 }
@Test
public void testReplace_StringStringString1060() { 
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
public void testReplace_StringStringStringInt1061() { 
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
public void testReplace_StringStringArrayStringArray1062() { 
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
public void testReplaceChars_StringCharChar1063() { 
     assertEquals(null, StringUtils.replaceChars(null, 'b', 'z')); 
     assertEquals("", StringUtils.replaceChars("", 'b', 'z')); 
     assertEquals("azcza", StringUtils.replaceChars("abcba", 'b', 'z')); 
     assertEquals("abcba", StringUtils.replaceChars("abcba", 'x', 'z')); 
 }
@Test
public void testReplaceChars_StringStringString1064() { 
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
public void testOverlay_StringStringIntInt1065() { 
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
public void testChop1066() { 
     final String[][] chopCases = { { FOO_UNCAP + "\r\n", FOO_UNCAP }, { FOO_UNCAP + "\n", FOO_UNCAP }, { FOO_UNCAP + "\r", FOO_UNCAP }, { FOO_UNCAP + " \r", FOO_UNCAP + " " }, { "foo", "fo" }, { "foo\nfoo", "foo\nfo" }, { "\n", "" }, { "\r", "" }, { "\r\n", "" }, { null, null }, { "", "" }, { "a", "" } }; 
     for (final String[] chopCase : chopCases) { 
         final String original = chopCase[0]; 
         final String expectedResult = chopCase[1]; 
         assertEquals("chop(String) failed", expectedResult, StringUtils.chop(original)); 
     } 
 }
@Test
public void testRepeat_StringInt1067() { 
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
public void testCenter_StringInt1068() { 
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
public void testRightPad_StringInt1069() { 
     assertEquals(null, StringUtils.rightPad(null, 5)); 
     assertEquals("     ", StringUtils.rightPad("", 5)); 
     assertEquals("abc  ", StringUtils.rightPad("abc", 5)); 
     assertEquals("abc", StringUtils.rightPad("abc", 2)); 
     assertEquals("abc", StringUtils.rightPad("abc", -1)); 
 }
@Test
public void testRightPad_StringIntChar1070() { 
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
public void testCenter_StringIntString1071() { 
     assertEquals(null, StringUtils.center(null, 4, null)); 
     assertEquals(null, StringUtils.center(null, -1, " ")); 
     assertEquals(null, StringUtils.center(null, 4, " ")); 
     assertEquals("    ", StringUtils.center("", 4, " ")); 
     assertEquals("ab", StringUtils.center("ab", 0, " ")); 
     assertEquals("ab", StringUtils.center("ab", -1, " ")); 
     assertEquals("ab", StringUtils.center("ab", 1, " ")); 
     assertEquals("    ", StringUtils.center("", 4, " ")); 
     assertEquals(" ab ", StringUtils.center("ab", 4, " ")); 
     assertEquals("abcd", StringUtils.center("abcd", 2, " ")); 
     assertEquals(" a  ", StringUtils.center("a", 4, " ")); 
     assertEquals("yayz", StringUtils.center("a", 4, "yz")); 
     assertEquals("yzyayzy", StringUtils.center("a", 7, "yz")); 
     assertEquals("  abc  ", StringUtils.center("abc", 7, null)); 
     assertEquals("  abc  ", StringUtils.center("abc", 7, "")); 
 }
@Test
public void testRightPad_StringIntString1072() { 
     assertEquals(null, StringUtils.rightPad(null, 5, "-+")); 
     assertEquals("     ", StringUtils.rightPad("", 5, " ")); 
     assertEquals(null, StringUtils.rightPad(null, 8, null)); 
     assertEquals("abc-+-+", StringUtils.rightPad("abc", 7, "-+")); 
     assertEquals("abc-+~", StringUtils.rightPad("abc", 6, "-+~")); 
     assertEquals("abc-+", StringUtils.rightPad("abc", 5, "-+~")); 
     assertEquals("abc", StringUtils.rightPad("abc", 2, " ")); 
     assertEquals("abc", StringUtils.rightPad("abc", -1, " ")); 
     assertEquals("abc  ", StringUtils.rightPad("abc", 5, null)); 
     assertEquals("abc  ", StringUtils.rightPad("abc", 5, "")); 
 }
@Test
public void testLeftPad_StringInt1073() { 
     assertEquals(null, StringUtils.leftPad(null, 5)); 
     assertEquals("     ", StringUtils.leftPad("", 5)); 
     assertEquals("  abc", StringUtils.leftPad("abc", 5)); 
     assertEquals("abc", StringUtils.leftPad("abc", 2)); 
 }
@Test
public void testLeftPad_StringIntString1074() { 
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
public void testLengthStringBuffer1075() { 
     assertEquals(0, StringUtils.length(new StringBuffer(""))); 
     assertEquals(0, StringUtils.length(new StringBuffer(StringUtils.EMPTY))); 
     assertEquals(1, StringUtils.length(new StringBuffer("A"))); 
     assertEquals(1, StringUtils.length(new StringBuffer(" "))); 
     assertEquals(8, StringUtils.length(new StringBuffer("ABCDEFGH"))); 
 }
@Test
public void testCaseFunctions1076() { 
     assertEquals(null, StringUtils.upperCase(null)); 
     assertEquals(null, StringUtils.upperCase(null, Locale.ENGLISH)); 
     assertEquals(null, StringUtils.lowerCase(null)); 
     assertEquals(null, StringUtils.lowerCase(null, Locale.ENGLISH)); 
     assertEquals(null, StringUtils.capitalize(null)); 
     assertEquals(null, StringUtils.uncapitalize(null)); 
     assertEquals("capitalize(empty-string) failed", "", StringUtils.capitalize("")); 
     assertEquals("capitalize(single-char-string) failed", "X", StringUtils.capitalize("x")); 
     assertEquals("capitalize(String) failed", FOO_CAP, StringUtils.capitalize(FOO_CAP)); 
     assertEquals("capitalize(string) failed", FOO_CAP, StringUtils.capitalize(FOO_UNCAP)); 
     assertEquals("uncapitalize(String) failed", FOO_UNCAP, StringUtils.uncapitalize(FOO_CAP)); 
     assertEquals("uncapitalize(string) failed", FOO_UNCAP, StringUtils.uncapitalize(FOO_UNCAP)); 
     assertEquals("uncapitalize(empty-string) failed", "", StringUtils.uncapitalize("")); 
     assertEquals("uncapitalize(single-char-string) failed", "x", StringUtils.uncapitalize("X")); 
     assertEquals("uncapitalize(capitalize(String)) failed", SENTENCE_UNCAP, StringUtils.uncapitalize(StringUtils.capitalize(SENTENCE_UNCAP))); 
     assertEquals("capitalize(uncapitalize(String)) failed", SENTENCE_CAP, StringUtils.capitalize(StringUtils.uncapitalize(SENTENCE_CAP))); 
     assertEquals("uncapitalize(capitalize(String)) failed", FOO_UNCAP, StringUtils.uncapitalize(StringUtils.capitalize(FOO_UNCAP))); 
     assertEquals("capitalize(uncapitalize(String)) failed", FOO_CAP, StringUtils.capitalize(StringUtils.uncapitalize(FOO_CAP))); 
     assertEquals("upperCase(String) failed", "FOO TEST THING", StringUtils.upperCase("fOo test THING")); 
     assertEquals("upperCase(empty-string) failed", "", StringUtils.upperCase("")); 
     assertEquals("lowerCase(String) failed", "foo test thing", StringUtils.lowerCase("fOo test THING")); 
     assertEquals("lowerCase(empty-string) failed", "", StringUtils.lowerCase("")); 
     assertEquals("upperCase(String, Locale) failed", "FOO TEST THING", StringUtils.upperCase("fOo test THING", Locale.ENGLISH)); 
     assertEquals("upperCase(empty-string, Locale) failed", "", StringUtils.upperCase("", Locale.ENGLISH)); 
     assertEquals("lowerCase(String, Locale) failed", "foo test thing", StringUtils.lowerCase("fOo test THING", Locale.ENGLISH)); 
     assertEquals("lowerCase(empty-string, Locale) failed", "", StringUtils.lowerCase("", Locale.ENGLISH)); 
 }
@Test
public void testIsAllLowerCase1085() { 
     assertFalse(StringUtils.isAllLowerCase(null)); 
     assertFalse(StringUtils.isAllLowerCase(StringUtils.EMPTY)); 
     assertTrue(StringUtils.isAllLowerCase("abc")); 
     assertFalse(StringUtils.isAllLowerCase("abc ")); 
     assertFalse(StringUtils.isAllLowerCase("abC")); 
 }
@Test
public void testIsAllUpperCase1086() { 
     assertFalse(StringUtils.isAllUpperCase(null)); 
     assertFalse(StringUtils.isAllUpperCase(StringUtils.EMPTY)); 
     assertTrue(StringUtils.isAllUpperCase("ABC")); 
     assertFalse(StringUtils.isAllUpperCase("ABC ")); 
     assertFalse(StringUtils.isAllUpperCase("aBC")); 
 }
@Test
public void testDefault_String1087() { 
     assertEquals("", StringUtils.defaultString(null)); 
     assertEquals("", StringUtils.defaultString("")); 
     assertEquals("abc", StringUtils.defaultString("abc")); 
 }
@Test
public void testDefault_StringString1088() { 
     assertEquals("NULL", StringUtils.defaultString(null, "NULL")); 
     assertEquals("", StringUtils.defaultString("", "NULL")); 
     assertEquals("abc", StringUtils.defaultString("abc", "NULL")); 
 }
@Test
public void testDefaultIfEmpty_StringBuffers1089() { 
     assertEquals("NULL", StringUtils.defaultIfEmpty(new StringBuffer(""), new StringBuffer("NULL")).toString()); 
     assertEquals("abc", StringUtils.defaultIfEmpty(new StringBuffer("abc"), new StringBuffer("NULL")).toString()); 
     assertNull(StringUtils.defaultIfEmpty(new StringBuffer(""), null)); 
     final StringBuffer s = StringUtils.defaultIfEmpty(new StringBuffer("abc"), new StringBuffer("NULL")); 
     assertEquals("abc", s.toString()); 
 }
@Test
public void testReverse_String1090() { 
     assertEquals(null, StringUtils.reverse(null)); 
     assertEquals("", StringUtils.reverse("")); 
     assertEquals("sdrawkcab", StringUtils.reverse("backwards")); 
 }
@Test
public void testAbbreviate_StringIntInt1091() { 
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
public void testAbbreviateMiddle1092() { 
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
public void testDifference_StringString1093() { 
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
public void testDifferenceAt_StringArray1094() { 
     assertEquals(-1, StringUtils.indexOfDifference((String[]) null)); 
     assertEquals(-1, StringUtils.indexOfDifference(new String[] {})); 
     assertEquals(-1, StringUtils.indexOfDifference(new String[] { "abc" })); 
     assertEquals(-1, StringUtils.indexOfDifference(new String[] { null, null })); 
     assertEquals(-1, StringUtils.indexOfDifference(new String[] { "", "" })); 
     assertEquals(0, StringUtils.indexOfDifference(new String[] { "", null })); 
     assertEquals(0, StringUtils.indexOfDifference(new String[] { "abc", null, null })); 
     assertEquals(0, StringUtils.indexOfDifference(new String[] { null, null, "abc" })); 
     assertEquals(0, StringUtils.indexOfDifference(new String[] { "", "abc" })); 
     assertEquals(0, StringUtils.indexOfDifference(new String[] { "abc", "" })); 
     assertEquals(-1, StringUtils.indexOfDifference(new String[] { "abc", "abc" })); 
     assertEquals(1, StringUtils.indexOfDifference(new String[] { "abc", "a" })); 
     assertEquals(2, StringUtils.indexOfDifference(new String[] { "ab", "abxyz" })); 
     assertEquals(2, StringUtils.indexOfDifference(new String[] { "abcde", "abxyz" })); 
     assertEquals(0, StringUtils.indexOfDifference(new String[] { "abcde", "xyz" })); 
     assertEquals(0, StringUtils.indexOfDifference(new String[] { "xyz", "abcde" })); 
     assertEquals(7, StringUtils.indexOfDifference(new String[] { "i am a machine", "i am a robot" })); 
 }
@Test
public void testGetLevenshteinDistance_StringStringInt1095() { 
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
public void testNormalizeSpace1096() { 
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
public void testAppendIfMissingIgnoreCase1098() { 
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
public void testPrependIfMissingIgnoreCase1099() { 
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
public void testPrependIfMissing1100() { 
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
