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
public void testSplit_StringStringInt436() { 
     assertArrayEquals(null, StringUtils.split(null, ".", -1)); 
     assertEquals(0, StringUtils.split("", ".", -1).length); 
     String input = "ab   de fg"; 
     String[] expected = new String[] { "ab", "", "", "de", "fg" }; 
     String[] actual = StringUtils.split(input, null, -1); 
     assertEquals(expected.length, actual.length); 
     for (int i = 0; i < actual.length; i += 1) { 
         assertEquals(expected[i], actual[i]); 
     } 
     input = "1::2:::3::::4"; 
     expected = new String[] { "1", "", "2", "", "", "3", "", "", "", "4" }; 
     actual = StringUtils.split(input, ":", -1); 
     assertEquals(expected.length, actual.length); 
     for (int i = 0; i < actual.length; i += 1) { 
         assertEquals(expected[i], actual[i]); 
     } 
     input = "1::2:::3::::4"; 
     expected = new String[] { "1", "2", ":3", "", "4" }; 
     actual = StringUtils.split(input, "::", -1); 
     assertEquals(expected.length, actual.length); 
     for (int i = 0; i < actual.length; i += 1) { 
         assertEquals(expected[i], actual[i]); 
     } 
     input = "1::2::3:4"; 
     expected = new String[] { "1", "", "2", ":3:4" };
}

@Test
public void testSplitByWholeString_StringStringInt437() { 
     assertArrayEquals(null, StringUtils.splitByWholeSeparator(null, ".", -1)); 
     assertEquals(0, StringUtils.splitByWholeSeparator("", ".", -1).length); 
     String input = "ab   de fg"; 
     String[] expected = new String[] { "ab", "", "", "de", "fg" }; 
     String[] actual = StringUtils.splitByWholeSeparator(input, null, -1); 
     assertEquals(expected.length, actual.length); 
     for (int i = 0; i < actual.length; i += 1) { 
         assertEquals(expected[i], actual[i]); 
     } 
     input = "1::2:::3::::4"; 
     expected = new String[] { "1", "", "2", "", "", "3", "", "", "", "4" }; 
     actual = StringUtils.splitByWholeSeparator(input, ":", -1); 
     assertEquals(expected.length, actual.length); 
     for (int i = 0; i < actual.length; i += 1) { 
         assertEquals(expected[i], actual[i]); 
     } 
     input = "1::2:::3::::4"; 
     expected = new String[] { "1", "2", ":3", "", "4" }; 
     actual = StringUtils.splitByWholeSeparator(input, "::", -1); 
     assertEquals(expected.length, actual.length); 
     for (int i = 0; i < actual.length; i += 1) { 
         assertEquals(expected[i], actual[i]); 
     } 
     input = "1::2::3:4"; 
     expected = new String[] { "1", "", "2", ":3:4" };
}

@Test
public void testSplitByWholeSeparatorPreserveAllTokens_StringStringInt438() { 
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
}

@Test
public void testSplitPreserveAllTokens_StringStringInt442() { 
     assertArrayEquals(null, StringUtils.splitPreserveAllTokens(null, ".", -1)); 
     assertEquals(0, StringUtils.splitPreserveAllTokens("", ".", -1).length); 
     String input = "ab   de fg"; 
     String[] expected = new String[] { "ab", "", "", "de", "fg" }; 
     String[] actual = StringUtils.splitPreserveAllTokens(input, null, -1); 
     assertEquals(expected.length, actual.length); 
     for (int i = 0; i < actual.length; i += 1) { 
         assertEquals(expected[i], actual[i]); 
     } 
     input = "1::2:::3::::4"; 
     expected = new String[] { "1", "", "2", "", "", "3", "", "", "", "4" }; 
     actual = StringUtils.splitPreserveAllTokens(input, ":", -1); 
     assertEquals(expected.length, actual.length); 
     for (int i = 0; i < actual.length; i += 1) { 
         assertEquals(expected[i], actual[i]); 
     } 
     input = "1::2:::3::::4"; 
     expected = new String[] { "1", "2", ":3", "", "4" }; 
     actual = StringUtils.splitPreserveAllTokens(input, "::", -1); 
     assertEquals(expected.length, actual.length); 
     for (int i = 0; i < actual.length; i += 1) { 
         assertEquals(expected[i], actual[i]); 
     } 
     input = "1::2::3:4"; 
     expected = new String[] { "1", "", "2", ":3:4" };
}

@Test
public void testJoin_ArrayOfBytes443() { 
     assertEquals(null, StringUtils.join((byte[]) null, ',')); 
     assertEquals("1;2", StringUtils.join(BYTE_PRIM_LIST, SEPARATOR_CHAR)); 
     assertEquals("2", StringUtils.join(BYTE_PRIM_LIST, SEPARATOR_CHAR, 1, 2)); 
 }
@Test
public void testJoin_ArrayCharSeparator444() { 
     assertEquals(null, StringUtils.join((char[]) null, ',')); 
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
public void testJoin_IterableString446() { 
     assertEquals(null, StringUtils.join((Iterable<?>) null, null)); 
     assertEquals(TEXT_LIST_NOSEP, StringUtils.join(Arrays.asList(ARRAY_LIST), null)); 
     assertEquals(TEXT_LIST_NOSEP, StringUtils.join(Arrays.asList(ARRAY_LIST), "")); 
     assertEquals("", StringUtils.join(Arrays.asList(NULL_ARRAY_LIST), null)); 
     assertEquals("", StringUtils.join(Arrays.asList(EMPTY_ARRAY_LIST), null)); 
     assertEquals("", StringUtils.join(Arrays.asList(EMPTY_ARRAY_LIST), "")); 
     assertEquals("", StringUtils.join(Arrays.asList(EMPTY_ARRAY_LIST), SEPARATOR)); 
     assertEquals(TEXT_LIST, StringUtils.join(Arrays.asList(ARRAY_LIST), SEPARATOR)); 
 }
@Test
public void testRemove_StringString447() { 
     assertNull(StringUtils.remove(null, null)); 
     assertNull(StringUtils.remove(null, "")); 
     assertNull(StringUtils.remove(null, "a")); 
     assertEquals(StringUtils.remove("", null), ""); 
     assertEquals(StringUtils.remove("", ""), ""); 
     assertEquals(StringUtils.remove("", "a"), ""); 
     assertEquals(StringUtils.remove("www.domain.com.", ".com"), "www.domain.com."); 
     assertEquals(StringUtils.remove("www.domain.com", ".com"), "www.domain"); 
     assertEquals(StringUtils.remove("www.domain", ".com"), "www.domain"); 
     assertEquals(StringUtils.remove("domain.com", ""), "domain.com"); 
     assertEquals(StringUtils.remove("domain.com", null), "domain.com"); 
 }
@Test
public void testReplace_StringStringString448() { 
     assertEquals(null, StringUtils.replace(null, null, null)); 
     assertEquals(null, StringUtils.replace(null, null, "any")); 
     assertEquals(null, StringUtils.replace(null, "any", null)); 
     assertEquals(null, StringUtils.replace(null, "any", "any")); 
     assertEquals("", StringUtils.replace("", null, null)); 
     assertEquals("", StringUtils.replace("", "any", null)); 
     assertEquals("", StringUtils.replace("", "any", "any")); 
     assertEquals("FOO", StringUtils.replace("FOO", "", "any")); 
     assertEquals("FOO", StringUtils.replace("FOO", "F", null)); 
     assertEquals("FOO", StringUtils.replace("FOO", null, "any")); 
     assertEquals("FOO", StringUtils.replace("FOO", "F", "any")); 
     assertEquals("FOO", StringUtils.replace("FOO", "F", null)); 
     assertEquals("foofoo", StringUtils.replace("foofoofoo", "foo", "")); 
 }
@Test
public void testReplace_StringStringString449() { 
     assertEquals(null, StringUtils.replace(null, null, null)); 
     assertEquals(null, StringUtils.replace(null, null, "any")); 
     assertEquals(null, StringUtils.replace(null, "any", null)); 
     assertEquals(null, StringUtils.replace(null, "any", "any")); 
     assertEquals("", StringUtils.replace("", null, null)); 
     assertEquals("", StringUtils.replace("", "any", null)); 
     assertEquals("", StringUtils.replace("", "any", "any")); 
     assertEquals("FOO", StringUtils.replace("FOO", "", "any")); 
     assertEquals("FOO", StringUtils.replace("FOO", "F", null)); 
     assertEquals("FOO", StringUtils.replace("FOO", null, "any")); 
     assertEquals("FOO", StringUtils.replace("FOO", "F", "any")); 
     assertEquals("FOO", StringUtils.replace("FOO", "F", null)); 
     assertEquals("FOO", StringUtils.replace("FOO", "F", "any")); 
     assertEquals("FOO", StringUtils.replace("FOO", "F", null)); 
     assertEquals("foofoo", StringUtils.replace("foofoofoo", "foo", "")); 
 }
@Test
public void testReplace_StringStringStringInt450() { 
     assertEquals(null, StringUtils.replace(null, null, null, 2)); 
     assertEquals(null, StringUtils.replace(null, "any", null, 2)); 
     assertEquals(null, StringUtils.replace(null, "any", "any", 2)); 
     assertEquals("", StringUtils.replace("", null, "any", 2)); 
     assertEquals("", StringUtils.replace("", "any", "any", 2)); 
     assertEquals("", StringUtils.replace("", "any", "any", 2)); 
     assertEquals("", StringUtils.replace("", "any", "any", 2)); 
     final String str = new String(new char[] { 'o', 'o', 'f', 'o', 'o' }); 
     assertSame(str, StringUtils.replace(str, "x", "", -1)); 
     assertEquals("f", StringUtils.replace("oofoo", "o", "", 0)); 
     assertEquals("oofoo", StringUtils.replace("oofoo", "o", "", 1)); 
     assertEquals("ofoo", StringUtils.replace("oofoo", "o", "", 2)); 
     assertEquals("foo", StringUtils.replace("oofoo", "o", "", 3)); 
     assertEquals("foo", StringUtils.replace("oofoo", "o", "", 4)); 
     assertEquals("fo", StringUtils.replace("oofoo", "o", "", -5)); 
     assertEquals("foo", StringUtils.replace("oofoo", "o", "", 1000)); 
 }
@Test
public void testReplace_StringStringStringInt451() { 
     assertEquals(null, StringUtils.replace(null, null, null, 2)); 
     assertEquals(null, StringUtils.replace(null, "any", null, 2)); 
     assertEquals(null, StringUtils.replace(null, "any", "any", 2)); 
     assertEquals("", StringUtils.replace("", null, "any", 2)); 
     assertEquals("", StringUtils.replace("", "any", "any", 2)); 
     assertEquals("", StringUtils.replace("", "any", "any", 2)); 
     assertEquals("", StringUtils.replace("", "any", "any", 2)); 
     final String str = new String(new char[] { 'o', 'o', 'f', 'o', 'o' }); 
     assertSame(str, StringUtils.replace(str, "x", "", -1)); 
     assertEquals("f", StringUtils.replace("oofoo", "o", "", 0)); 
     assertEquals("oofoo", StringUtils.replace("oofoo", "o", "", 1)); 
     assertEquals("oofoo", StringUtils.replace("oofoo", "o", "", 2)); 
     assertEquals("foo", StringUtils.replace("oofoo", "o", "", 3)); 
     assertEquals("foo", StringUtils.replace("oofoo", "o", "", 4)); 
     assertEquals("foo", StringUtils.replace("oofoo", "o", "", -5)); 
     assertEquals("foo", StringUtils.replace("oofoo", "o", "", 1000)); 
 }
@Test
public void testReplace_StringStringArrayStringArrayBoolean452() { 
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
public void testReplaceChars_charChar453() { 
     assertEquals(null, StringUtils.replaceChars(null, ' ', ' ')); 
     assertEquals("", StringUtils.replaceChars("", ' ', ' ')); 
     assertEquals("", StringUtils.replaceChars("        ", ' ', ' ')); 
     assertEquals("abc", StringUtils.replaceChars("  abc  ", ' ', ' ')); 
     assertEquals(StringUtilsTest.NON_WHITESPACE, StringUtils.replaceChars(StringUtilsTest.WHITESPACE + StringUtilsTest.NON_WHITESPACE + StringUtilsTest.WHITESPACE, ' ', ' ')); 
 }
@Test
public void testReplaceChars_StringStringString454() { 
     assertEquals(null, StringUtils.replaceChars(null, null, null)); 
     assertEquals(null, StringUtils.replaceChars(null, null, "any")); 
     assertEquals(null, StringUtils.replaceChars(null, "any", null)); 
     assertEquals(null, StringUtils.replaceChars(null, "any", "any")); 
     assertEquals("", StringUtils.replaceChars("", null, "any")); 
     assertEquals("", StringUtils.replaceChars("", "any", "any")); 
     assertEquals("", StringUtils.replaceChars("", "any", "any")); 
     assertEquals("FOO", StringUtils.replaceChars("FOO", "", "any")); 
     assertEquals("FOO", StringUtils.replaceChars("FOO", "F", null)); 
     assertEquals("FOO", StringUtils.replaceChars("FOO", null, "any")); 
     assertEquals("FOO", StringUtils.replaceChars("FOO", "F", "any")); 
     assertEquals("FOO", StringUtils.replaceChars("FOO", "F", null)); 
     assertEquals("foofoo", StringUtils.replaceChars("foofoofoo", "foo", "")); 
 }
@Test
public void testReplaceChars_StringStringString455() { 
     assertEquals(null, StringUtils.replaceChars(null, null, null)); 
     assertEquals(null, StringUtils.replaceChars(null, null, "any")); 
     assertEquals(null, StringUtils.replaceChars(null, "any", null)); 
     assertEquals(null, StringUtils.replaceChars(null, "any", "any")); 
     assertEquals("", StringUtils.replaceChars("", null, "any")); 
     assertEquals("", StringUtils.replaceChars("", "any", "any")); 
     assertEquals("", StringUtils.replaceChars("", "any", "any")); 
     assertEquals("", StringUtils.replaceChars("", "any", "any")); 
     assertEquals("FOO", StringUtils.replaceChars("FOO", "", "any")); 
     assertEquals("FOO", StringUtils.replaceChars("FOO", "F", null)); 
     assertEquals("FOO", StringUtils.replaceChars("FOO", null, "any")); 
     assertEquals("FOO", StringUtils.replaceChars("FOO", "F", "any")); 
     assertEquals("FOO", StringUtils.replaceChars("FOO", "F", null)); 
     assertEquals("foofoo", StringUtils.replaceChars("foofoofoo", "foo", "")); 
 }
@Test
public void testReplaceChars_StringStringString456() { 
     assertEquals(null, StringUtils.replaceChars(null, null, null)); 
     assertEquals(null, StringUtils.replaceChars(null, null, "any")); 
     assertEquals(null, StringUtils.replaceChars(null, "any", null)); 
     assertEquals(null, StringUtils.replaceChars(null, "any", "any")); 
     assertEquals("", StringUtils.replaceChars("", null, "any")); 
     assertEquals("", StringUtils.replaceChars("", "any", "any")); 
     assertEquals("", StringUtils.replaceChars("", "any", "any")); 
     assertEquals("FOO", StringUtils.replaceChars("FOO", "", "any")); 
     assertEquals("FOO", StringUtils.replaceChars("FOO", "", "any")); 
     assertEquals("FOO", StringUtils.replaceChars("FOO", "F", null)); 
     assertEquals("FOO", StringUtils.replaceChars("FOO", null, "any")); 
     assertEquals("FOO", StringUtils.replaceChars("FOO", "F", "any")); 
     assertEquals("FOO", StringUtils.replaceChars("FOO", "F", null)); 
     assertEquals("foofoo", StringUtils.replaceChars("foofoofoo", "foo", "")); 
 }
@Test
public void testCenter_StringInt457() { 
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
public void testRightPad_StringInt458() { 
     assertEquals(null, StringUtils.rightPad(null, 5)); 
     assertEquals("     ", StringUtils.rightPad("", 5)); 
     assertEquals("  abc", StringUtils.rightPad("abc", 5)); 
     assertEquals("abc", StringUtils.rightPad("abc", 2)); 
 }
@Test
public void testRightPad_StringIntString459() { 
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
public void testLeftPad_StringIntChar460() { 
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
public void testDefault_String464() { 
     assertEquals("NULL", StringUtils.defaultString(null)); 
     assertEquals("", StringUtils.defaultString("")); 
     assertEquals("abc", StringUtils.defaultString("abc")); 
 }
@Test
public void testReverse_String465() { 
     assertEquals(null, StringUtils.reverse(null)); 
     assertEquals("", StringUtils.reverse("")); 
     assertEquals("", StringUtils.reverse("        ")); 
     assertEquals("abc", StringUtils.reverse("  abc  ")); 
     assertEquals(StringUtilsTest.NON_WHITESPACE, StringUtils.reverse(StringUtilsTest.WHITESPACE + StringUtilsTest.NON_WHITESPACE + StringUtilsTest.WHITESPACE)); 
 }
@Test
public void testDifference_StringString466() { 
     assertEquals(null, StringUtils.difference(null, null)); 
     assertEquals(null, StringUtils.difference(null, "i am a robot")); 
     assertEquals("", StringUtils.difference("", "")); 
     assertEquals("", StringUtils.difference("", "abc")); 
     assertEquals("", StringUtils.difference("abc", null)); 
     assertEquals("", StringUtils.difference("abc", "")); 
     assertEquals("", StringUtils.difference("abc", "abc")); 
     assertEquals("qeed", StringUtils.difference("queued", "queued")); 
     assertEquals("queued", StringUtils.difference("queued", "queued")); 
     assertEquals("queued", StringUtils.difference("queued", "queued")); 
     assertEquals("queued", StringUtils.difference("queued", "queued")); 
     assertEquals("queued", StringUtils.difference("queued", "queued")); 
     assertEquals("queued", StringUtils.difference("queued", "queued")); 
     assertEquals("queued", StringUtils.difference("queued", "queued")); 
     assertEquals("queued", StringUtils.difference("queued", "queued")); 
     assertEquals("queued", StringUtils.difference("queued", "queued")); 
     assertEquals("queued", StringUtils.difference("queued", "queued")); 
     assertEquals("queued", StringUtils.difference("queued", "queued")); 
     assertEquals("queued", StringUtils.difference("queued", "queued")); 
     assertEquals("queued", StringUtils.difference("queued", "queued")); 
     assertEquals("queued", StringUtils.difference("queued", "queued")); 
     assertEquals("queued", StringUtils.difference("queued", "queued")); 
     assertEquals("queued", StringUtils.difference("queued", "queued")); 
     assertEquals("queued", StringUtils.difference("queued", "queued")); 
     assertEquals("queued", StringUtils.difference("queued", "queued")); 
     assertEquals("queued", StringUtils.difference("queued", "queued"));
}

@Test
public void testDifferenceAt_StringString469() { 
     assertEquals(-1, StringUtils.indexOfDifference(null, null)); 
     assertEquals(-1, StringUtils.indexOfDifference(null, "i am a robot")); 
     assertEquals(-1, StringUtils.indexOfDifference("", "")); 
     assertEquals(0, StringUtils.indexOfDifference("", "abc")); 
     assertEquals(0, StringUtils.indexOfDifference("abc", "")); 
     assertEquals(0, StringUtils.indexOfDifference("i am a machine", null)); 
     assertEquals(-1, StringUtils.indexOfDifference("i am a machine", "i am a robot")); 
     assertEquals(0, StringUtils.indexOfDifference("i am a machine", "i am a robot")); 
     assertEquals(0, StringUtils.indexOfDifference("i am a machine", "i am a robot")); 
     assertEquals(-1, StringUtils.indexOfDifference("i am a robot", "you are a robot")); 
 }
@Test
public void testDifferenceAt_StringString470() { 
     assertEquals(-1, StringUtils.indexOfDifference(null, null)); 
     assertEquals(-1, StringUtils.indexOfDifference(null, "i am a robot")); 
     assertEquals(-1, StringUtils.indexOfDifference("", "")); 
     assertEquals(0, StringUtils.indexOfDifference("", "abc")); 
     assertEquals(0, StringUtils.indexOfDifference("abc", "")); 
     assertEquals(0, StringUtils.indexOfDifference("i am a machine", null)); 
     assertEquals(-1, StringUtils.indexOfDifference("i am a machine", "i am a robot")); 
     assertEquals(0, StringUtils.indexOfDifference("i am a machine", "i am a robot")); 
     assertEquals(0, StringUtils.indexOfDifference("i am a machine", "you are a robot")); 
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
