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
public void testAppendIfMissing281() { 
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
public void testEscapeSurrogatePairsLang858306() throws Exception { 
     assertEquals("\\uDBFF\\uDFFD", StringEscapeUtils.escapeJava("\uDBFF\uDFFD")); 
     assertEquals("\\uDBFF\\uDFFD", StringEscapeUtils.escapeEcmaScript("\uDBFF\uDFFD")); 
 }
@Test
public void testJoin_IterableChar901() { 
     assertEquals(null, StringUtils.join((Iterable<?>) null, ',')); 
     assertEquals(TEXT_LIST_CHAR, StringUtils.join(Arrays.asList(ARRAY_LIST), SEPARATOR_CHAR)); 
     assertEquals("", StringUtils.join(Arrays.asList(NULL_ARRAY_LIST), SEPARATOR_CHAR)); 
     assertEquals("", StringUtils.join(Arrays.asList(EMPTY_ARRAY_LIST), SEPARATOR_CHAR)); 
     assertEquals("foo", StringUtils.join(Collections.singleton("foo"), 'x')); 
 }
@Test
public void testConstructor992() { 
     assertNotNull(new StringUtils()); 
     final Constructor<?>[] cons = StringUtils.class.getDeclaredConstructors(); 
     assertEquals(1, cons.length); 
     assertTrue(Modifier.isPublic(cons[0].getModifiers())); 
     assertTrue(Modifier.isPublic(StringUtils.class.getModifiers())); 
     assertFalse(Modifier.isFinal(StringUtils.class.getModifiers())); 
 }
@Test
public void testLANG6661000() { 
     assertEquals("12", StringUtils.stripEnd("120.00", ".0")); 
     assertEquals("121", StringUtils.stripEnd("121.00", ".0")); 
 }
@Test
public void testLeftPad_StringIntChar1018() { 
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
public void testSplit_String1034() { 
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
public void testReverseDelimited_StringChar1035() { 
     assertEquals(null, StringUtils.reverseDelimited(null, '.')); 
     assertEquals("", StringUtils.reverseDelimited("", '.')); 
     assertEquals("c.b.a", StringUtils.reverseDelimited("a.b.c", '.')); 
     assertEquals("a b c", StringUtils.reverseDelimited("a b c", '.')); 
     assertEquals("", StringUtils.reverseDelimited("", '.')); 
 }
@Test
public void testSplit_StringString_StringStringInt1036() { 
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
public void testSplitByWholeString_StringStringBoolean1037() { 
     assertArrayEquals(null, StringUtils.splitByWholeSeparator(null, ".")); 
     assertEquals(0, StringUtils.splitByWholeSeparator("", ".").length); 
     final String stringToSplitOnNulls = "ab   de fg"; 
     final String[] splitOnNullExpectedResults = { "ab", "de", "fg" }; 
     final String[] splitOnNullResults = StringUtils.splitByWholeSeparator(stringToSplitOnNulls, null); 
     assertEquals(splitOnNullExpectedResults.length, splitOnNullResults.length); 
     for (int i = 0; i < splitOnNullExpectedResults.length; i += 1) { 
         assertEquals(splitOnNullExpectedResults[i], splitOnNullResults[i]); 
     } 
     final String stringToSplitOnCharactersAndString = "abstemiouslyaeiouyabstemiously"; 
     final String[] splitOnStringExpectedResults = { "abstemiously", "abstemiously" }; 
     final String[] splitOnStringResults = StringUtils.splitByWholeSeparator(stringToSplitOnCharactersAndString, "aeiouy"); 
     assertEquals(splitOnStringExpectedResults.length, splitOnStringResults.length); 
     for (int i = 0; i < splitOnStringExpectedResults.length; i += 1) { 
         assertEquals(splitOnStringExpectedResults[i], splitOnStringResults[i]); 
     } 
     final String[] splitWithMultipleSeparatorExpectedResults = { "ab", "cd", "ef" }; 
     final String[] splitWithMultipleSeparator = StringUtils.splitByWholeSeparator("ab:cd::ef", ":"); 
     assertEquals(splitWithMultipleSeparatorExpectedResults.length, splitWithMultipleSeparator.length); 
     for (int i = 0; i < splitWithMultipleSeparatorExpectedResults.length; i++) { 
         assertEquals(splitWithMultipleSeparatorExpectedResults[i], splitWithMultipleSeparator[i]); 
     } 
 }
@Test
public void testSplitByWholeString_StringStringBooleanInt1038() { 
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
public void testSplitByWholeSeparatorPreserveAllTokens_StringStringInt1039() { 
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
public void testSplitPreserveAllTokens_String1040() { 
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
public void testSplitPreserveAllTokens_StringString_StringStringInt1041() { 
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
public void testSplitByCharacterTypeCamelCase1042() { 
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
public void testJoin_Objectarray1043() { 
     assertEquals(null, StringUtils.join((Object[]) null)); 
     assertEquals("", StringUtils.join()); 
     assertEquals("", StringUtils.join((Object) null)); 
     assertEquals("", StringUtils.join(EMPTY_ARRAY_LIST)); 
     assertEquals("", StringUtils.join(NULL_ARRAY_LIST)); 
     assertEquals("null", StringUtils.join(NULL_TO_STRING_LIST)); 
     assertEquals("abc", StringUtils.join(new String[] { "a", "b", "c" })); 
     assertEquals("a", StringUtils.join(new String[] { null, "a", "" })); 
     assertEquals("foo", StringUtils.join(MIXED_ARRAY_LIST)); 
     assertEquals("foo2", StringUtils.join(MIXED_TYPE_LIST)); 
 }
@Test
public void testJoin_ArrayOfLongs1044() { 
     assertEquals(null, StringUtils.join((long[]) null, ',')); 
     assertEquals("1;2", StringUtils.join(LONG_PRIM_LIST, SEPARATOR_CHAR)); 
     assertEquals("2", StringUtils.join(LONG_PRIM_LIST, SEPARATOR_CHAR, 1, 2)); 
 }
@Test
public void testJoin_ArrayOfInts1045() { 
     assertEquals(null, StringUtils.join((int[]) null, ',')); 
     assertEquals("1;2", StringUtils.join(INT_PRIM_LIST, SEPARATOR_CHAR)); 
     assertEquals("2", StringUtils.join(INT_PRIM_LIST, SEPARATOR_CHAR, 1, 2)); 
 }
@Test
public void testJoin_ArrayOfShorts1046() { 
     assertEquals(null, StringUtils.join((short[]) null, ',')); 
     assertEquals("1;2", StringUtils.join(SHORT_PRIM_LIST, SEPARATOR_CHAR)); 
     assertEquals("2", StringUtils.join(SHORT_PRIM_LIST, SEPARATOR_CHAR, 1, 2)); 
 }
@Test
public void testJoin_ArrayOfBytes1047() { 
     assertEquals(null, StringUtils.join((byte[]) null, ',')); 
     assertEquals("1;2", StringUtils.join(BYTE_PRIM_LIST, SEPARATOR_CHAR)); 
     assertEquals("2", StringUtils.join(BYTE_PRIM_LIST, SEPARATOR_CHAR, 1, 2)); 
 }
@Test
public void testJoin_ArrayOfChars1048() { 
     assertEquals(null, StringUtils.join((char[]) null, ',')); 
     assertEquals("1;2", StringUtils.join(CHAR_PRIM_LIST, SEPARATOR_CHAR)); 
     assertEquals("2", StringUtils.join(CHAR_PRIM_LIST, SEPARATOR_CHAR, 1, 2)); 
 }
@Test
public void testJoin_ArrayOfDoubles1049() { 
     assertEquals(null, StringUtils.join((double[]) null, ',')); 
     assertEquals("1.0;2.0", StringUtils.join(DOUBLE_PRIM_LIST, SEPARATOR_CHAR)); 
     assertEquals("2.0", StringUtils.join(DOUBLE_PRIM_LIST, SEPARATOR_CHAR, 1, 2)); 
 }
@Test
public void testJoin_IteratorChar1050() { 
     assertEquals(null, StringUtils.join((Iterator<?>) null, ',')); 
     assertEquals(TEXT_LIST_CHAR, StringUtils.join(Arrays.asList(ARRAY_LIST).iterator(), SEPARATOR_CHAR)); 
     assertEquals("", StringUtils.join(Arrays.asList(NULL_ARRAY_LIST).iterator(), SEPARATOR_CHAR)); 
     assertEquals("", StringUtils.join(Arrays.asList(EMPTY_ARRAY_LIST).iterator(), SEPARATOR_CHAR)); 
     assertEquals("foo", StringUtils.join(Collections.singleton("foo").iterator(), 'x')); 
 }
@Test
public void testJoin_IterableString1051() { 
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
public void testDeleteWhitespace_String1052() { 
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
public void testRemoveStart1053() { 
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
public void testRemoveStartIgnoreCase1054() { 
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
public void testRemoveEnd1055() { 
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
public void testRemoveEndIgnoreCase1056() { 
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
public void testRemove_String1057() { 
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
public void testRemove_char1058() { 
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
public void testReplaceOnce_StringStringString1059() { 
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
public void testRemovePattern1060() { 
     assertEquals("", StringUtils.removePattern("<A>x\\ny</A>", "<A>.*</A>")); 
 }
@Test
public void testReplace_StringStringString1061() { 
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
public void testReplace_StringStringStringInt1062() { 
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
public void testReplace_StringStringArrayStringArray1063() { 
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
public void testReplace_StringStringArrayStringArrayBoolean1064() { 
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
public void testReplaceChars_StringCharChar1065() { 
     assertEquals(null, StringUtils.replaceChars(null, 'b', 'z')); 
     assertEquals("", StringUtils.replaceChars("", 'b', 'z')); 
     assertEquals("azcza", StringUtils.replaceChars("abcba", 'b', 'z')); 
     assertEquals("abcba", StringUtils.replaceChars("abcba", 'x', 'z')); 
 }
@Test
public void testReplaceChars_StringStringString1066() { 
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
public void testOverlay_StringStringIntInt1067() { 
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
@SuppressWarnings("deprecation")
@Test
public void testChomp1068() { 
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
public void testRepeat_StringInt1069() { 
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
public void testRepeat_StringStringInt1070() { 
     assertEquals(null, StringUtils.repeat(null, null, 2)); 
     assertEquals(null, StringUtils.repeat(null, "x", 2)); 
     assertEquals("", StringUtils.repeat("", null, 2)); 
     assertEquals("", StringUtils.repeat("ab", "", 0)); 
     assertEquals("", StringUtils.repeat("", "", 2)); 
     assertEquals("xx", StringUtils.repeat("", "x", 3)); 
     assertEquals("?, ?, ?", StringUtils.repeat("?", ", ", 3)); 
 }
@Test
public void testRightPad_StringInt1071() { 
     assertEquals(null, StringUtils.rightPad(null, 5)); 
     assertEquals("     ", StringUtils.rightPad("", 5)); 
     assertEquals("abc  ", StringUtils.rightPad("abc", 5)); 
     assertEquals("abc", StringUtils.rightPad("abc", 2)); 
     assertEquals("abc", StringUtils.rightPad("abc", -1)); 
 }
@Test
public void testCenter_StringIntString1072() { 
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
public void testRightPad_StringIntString1073() { 
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
public void testLeftPad_StringInt1074() { 
     assertEquals(null, StringUtils.leftPad(null, 5)); 
     assertEquals("     ", StringUtils.leftPad("", 5)); 
     assertEquals("  abc", StringUtils.leftPad("abc", 5)); 
     assertEquals("abc", StringUtils.leftPad("abc", 2)); 
 }
@Test
public void testLeftPad_StringIntString1075() { 
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
public void testSwapCase_String1076() { 
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
public void testIsAllLowerCase1084() { 
     assertFalse(StringUtils.isAllLowerCase(null)); 
     assertFalse(StringUtils.isAllLowerCase(StringUtils.EMPTY)); 
     assertTrue(StringUtils.isAllLowerCase("abc")); 
     assertFalse(StringUtils.isAllLowerCase("abc ")); 
     assertFalse(StringUtils.isAllLowerCase("abC")); 
 }
@Test
public void testDefault_String1085() { 
     assertEquals("", StringUtils.defaultString(null)); 
     assertEquals("", StringUtils.defaultString("")); 
     assertEquals("abc", StringUtils.defaultString("abc")); 
 }
@Test
public void testDefaultIfBlank_StringString1086() { 
     assertEquals("NULL", StringUtils.defaultIfBlank(null, "NULL")); 
     assertEquals("NULL", StringUtils.defaultIfBlank("", "NULL")); 
     assertEquals("NULL", StringUtils.defaultIfBlank(" ", "NULL")); 
     assertEquals("abc", StringUtils.defaultIfBlank("abc", "NULL")); 
     assertNull(StringUtils.defaultIfBlank("", null)); 
     final String s = StringUtils.defaultIfBlank("abc", "NULL"); 
     assertEquals("abc", s); 
 }
@Test
public void testDefaultIfEmpty_StringBuffers1087() { 
     assertEquals("NULL", StringUtils.defaultIfEmpty(new StringBuffer(""), new StringBuffer("NULL")).toString()); 
     assertEquals("abc", StringUtils.defaultIfEmpty(new StringBuffer("abc"), new StringBuffer("NULL")).toString()); 
     assertNull(StringUtils.defaultIfEmpty(new StringBuffer(""), null)); 
     final StringBuffer s = StringUtils.defaultIfEmpty(new StringBuffer("abc"), new StringBuffer("NULL")); 
     assertEquals("abc", s.toString()); 
 }
@Test
public void testReverse_String1088() { 
     assertEquals(null, StringUtils.reverse(null)); 
     assertEquals("", StringUtils.reverse("")); 
     assertEquals("sdrawkcab", StringUtils.reverse("backwards")); 
 }
@Test
public void testAbbreviate_StringIntInt1089() { 
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
public void testDifference_StringString1090() { 
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
public void testDifferenceAt_StringString1091() { 
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
public void testGetCommonPrefix_StringArray1092() { 
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
public void testGetLevenshteinDistance_StringString1093() { 
     assertEquals(0, StringUtils.getLevenshteinDistance("", "")); 
     assertEquals(1, StringUtils.getLevenshteinDistance("", "a")); 
     assertEquals(7, StringUtils.getLevenshteinDistance("aaapppp", "")); 
     assertEquals(1, StringUtils.getLevenshteinDistance("frog", "fog")); 
     assertEquals(3, StringUtils.getLevenshteinDistance("fly", "ant")); 
     assertEquals(7, StringUtils.getLevenshteinDistance("elephant", "hippo")); 
     assertEquals(7, StringUtils.getLevenshteinDistance("hippo", "elephant")); 
     assertEquals(8, StringUtils.getLevenshteinDistance("hippo", "zzzzzzzz")); 
     assertEquals(8, StringUtils.getLevenshteinDistance("zzzzzzzz", "hippo")); 
     assertEquals(1, StringUtils.getLevenshteinDistance("hello", "hallo")); 
     try { 
         @SuppressWarnings("unused") 
         final int d = StringUtils.getLevenshteinDistance("a", null); 
         fail("expecting IllegalArgumentException"); 
     } catch (final IllegalArgumentException ex) { 
     } 
     try { 
         @SuppressWarnings("unused") 
         final int d = StringUtils.getLevenshteinDistance(null, "a"); 
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
public void testAppendIfMissingIgnoreCase1097() { 
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
public void testPrependIfMissing1098() { 
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
public void testToString1099() throws UnsupportedEncodingException { 
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
public void testUnescapeSurrogatePairs1171() throws Exception { 
     assertEquals("\uD83D\uDE30", StringEscapeUtils.unescapeCsv("\uD83D\uDE30")); 
     assertEquals("\uD800\uDC00", StringEscapeUtils.unescapeCsv("\uD800\uDC00")); 
     assertEquals("\uD834\uDD1E", StringEscapeUtils.unescapeCsv("\uD834\uDD1E")); 
     assertEquals("\uDBFF\uDFFD", StringEscapeUtils.unescapeCsv("\uDBFF\uDFFD")); 
     assertEquals("\uDBFF\uDFFD", StringEscapeUtils.unescapeHtml3("\uDBFF\uDFFD")); 
     assertEquals("\uDBFF\uDFFD", StringEscapeUtils.unescapeHtml4("\uDBFF\uDFFD")); 
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
