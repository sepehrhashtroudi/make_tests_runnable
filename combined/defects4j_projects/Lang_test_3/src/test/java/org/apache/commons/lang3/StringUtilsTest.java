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
public void testEscapeSurrogatePairs168() throws Exception { 
     assertEquals("\uD83D\uDE30", StringEscapeUtils.escapeCsv("\uD83D\uDE30")); 
     assertEquals("\uD800\uDC00", StringEscapeUtils.escapeCsv("\uD800\uDC00")); 
     assertEquals("\uD834\uDD1E", StringEscapeUtils.escapeCsv("\uD834\uDD1E")); 
     assertEquals("\uDBFF\uDFFD", StringEscapeUtils.escapeCsv("\uDBFF\uDFFD")); 
     assertEquals("\uDBFF\uDFFD", StringEscapeUtils.escapeHtml3("\uDBFF\uDFFD")); 
     assertEquals("\uDBFF\uDFFD", StringEscapeUtils.escapeHtml4("\uDBFF\uDFFD")); 
     assertEquals("\uDBFF\uDFFD", StringEscapeUtils.escapeXml("\uDBFF\uDFFD")); 
 }
@Test
public void testSplitByWholeString_StringStringBooleanInt480() { 
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
public void testSplitByWholeString_StringStringBooleanInt481() { 
     assertArrayEquals(null, StringUtils.splitByWholeSeparatorPreserveAllTokens(null, ".", 3)); 
     assertEquals(0, StringUtils.splitByWholeSeparatorPreserveAllTokens("", ".", 3).length); 
     final String stringToSplitOnNulls = "ab   de fg"; 
     final String[] splitOnNullExpectedResults = { "ab", "de fg" }; 
     final String[] splitOnNullResults = StringUtils.splitByWholeSeparatorPreserveAllTokens(stringToSplitOnNulls, null, 2); 
     assertEquals(splitOnNullExpectedResults.length, splitOnNullResults.length); 
     for (int i = 0; i < splitOnNullExpectedResults.length; i += 1) { 
         assertEquals(splitOnNullExpectedResults[i], splitOnNullResults[i]); 
     } 
     final String stringToSplitOnCharactersAndString = "abstemiouslyaeiouyabstemiouslyaeiouyabstemiously"; 
     final String[] splitOnStringExpectedResults = { "abstemiously", "abstemiouslyaeiouyabstemiously" }; 
     final String[] splitOnStringResults = StringUtils.splitByWholeSeparatorPreserveAllTokens(stringToSplitOnCharactersAndString, "aeiouy", 2); 
     assertEquals(splitOnStringExpectedResults.length, splitOnStringResults.length); 
     for (int i = 0; i < splitOnStringExpectedResults.length; i++) { 
         assertEquals(splitOnStringExpectedResults[i], splitOnStringResults[i]); 
     } 
 }
@Test
public void testSplitPreserveAllTokens_String482() { 
     assertArrayEquals(null, StringUtils.splitPreserveAllTokens(null)); 
     assertEquals(0, StringUtils.splitPreserveAllTokens("").length); 
     String str = "a b  .c"; 
     String[] res = StringUtils.splitPreserveAllTokens(str); 
     assertEquals(3, res.length); 
     assertEquals("a", res[0]); 
     assertEquals("b", res[1]); 
     assertEquals(".c", res[2]); 
     str = " a "; 
     res = StringUtils.splitPreserveAllTokens(str); 
     assertEquals(1, res.length); 
     assertEquals("a", res[0]); 
     str = "a" + WHITESPACE + "b" + NON_WHITESPACE + "c"; 
     res = StringUtils.splitPreserveAllTokens(str); 
     assertEquals(2, res.length); 
     assertEquals("a", res[0]); 
     assertEquals("b" + NON_WHITESPACE + "c", res[1]); 
 }
@Test
public void testJoin_IterableChar484() { 
     assertEquals(null, StringUtils.join((Iterable<?>) null, ',')); 
     assertEquals(TEXT_LIST_CHAR, StringUtils.join(Arrays.asList(ARRAY_LIST), SEPARATOR_CHAR)); 
     assertEquals("", StringUtils.join(Arrays.asList(NULL_ARRAY_LIST), SEPARATOR_CHAR)); 
     assertEquals("", StringUtils.join(Arrays.asList(EMPTY_ARRAY_LIST), SEPARATOR_CHAR)); 
     assertEquals("foo", StringUtils.join(Collections.singleton("foo"), 'x')); 
 }
@Test
public void testDeleteWhitespace485() { 
     assertEquals(null, StringUtils.deleteWhitespace(null)); 
     assertEquals("", StringUtils.deleteWhitespace("")); 
     assertEquals("", StringUtils.deleteWhitespace(" ")); 
     assertEquals("a", StringUtils.deleteWhitespace("a")); 
     assertEquals("a", StringUtils.deleteWhitespace("  a")); 
     assertEquals("i am a robot", StringUtils.deleteWhitespace("i am a robot")); 
     assertEquals("i am a machine", StringUtils.deleteWhitespace("i am a machine")); 
     assertEquals("robot", StringUtils.deleteWhitespace("i am a machine")); 
     assertEquals("", StringUtils.deleteWhitespace("abc")); 
     assertEquals("you are a robot", StringUtils.deleteWhitespace("i am a robot")); 
 }
@Test
public void testDeleteWhitespace486() { 
     assertEquals(null, StringUtils.deleteWhitespace(null)); 
     assertEquals("", StringUtils.deleteWhitespace("")); 
     assertEquals("", StringUtils.deleteWhitespace(" ")); 
     assertEquals("", StringUtils.deleteWhitespace("\t")); 
     assertEquals("", StringUtils.deleteWhitespace("\n")); 
     assertEquals("", StringUtils.deleteWhitespace("\u0009")); 
     assertEquals("", StringUtils.deleteWhitespace("\u000B")); 
     assertEquals("", StringUtils.deleteWhitespace("\u000C")); 
     assertEquals("", StringUtils.deleteWhitespace("\u001C")); 
     assertEquals("", StringUtils.deleteWhitespace("\u001D")); 
     assertEquals("", StringUtils.deleteWhitespace("\u001E")); 
     assertEquals("", StringUtils.deleteWhitespace("\u001F")); 
     assertEquals("", StringUtils.deleteWhitespace("\f")); 
     assertEquals("", StringUtils.deleteWhitespace("\r")); 
     assertEquals("a", StringUtils.deleteWhitespace("  a  ")); 
     assertEquals("a b c", StringUtils.deleteWhitespace("  a  b   c  ")); 
     assertEquals("a b c", StringUtils.deleteWhitespace("a\t\f\r  b\u000B   c\n")); 
 }
@Test
public void testRemoveStartIgnoreCase487() { 
     assertNull(StringUtils.removeStartIgnoreCase(null, null)); 
     assertNull(StringUtils.removeStartIgnoreCase(null, "")); 
     assertNull(StringUtils.removeStartIgnoreCase(null, "a")); 
     assertEquals(StringUtils.removeStartIgnoreCase("", null), ""); 
     assertEquals(StringUtils.removeStartIgnoreCase("", ""), ""); 
     assertEquals(StringUtils.removeStartIgnoreCase("", "a"), ""); 
     assertEquals(StringUtils.removeStartIgnoreCase("www.domain.com", "www."), "domain.com"); 
     assertEquals(StringUtils.removeStartIgnoreCase("domain.com", "www."), "domain.com"); 
     assertEquals(StringUtils.removeStartIgnoreCase("domain.com", ""), "domain.com"); 
     assertEquals(StringUtils.removeStartIgnoreCase("domain.com", null), "domain.com"); 
 }
@Test
public void testRemoveEndIgnoreCase488() { 
     assertNull(StringUtils.removeEndIgnoreCase(null, null)); 
     assertNull(StringUtils.removeEndIgnoreCase(null, "")); 
     assertNull(StringUtils.removeEndIgnoreCase(null, "a")); 
     assertEquals(StringUtils.removeEndIgnoreCase("", null), ""); 
     assertEquals(StringUtils.removeEndIgnoreCase("", ""), ""); 
     assertEquals(StringUtils.removeEndIgnoreCase("", "a"), ""); 
     assertEquals(StringUtils.removeEndIgnoreCase("www.domain.com.", ".com"), "www.domain.com."); 
     assertEquals(StringUtils.removeEndIgnoreCase("www.domain.com", ".com"), "www.domain"); 
     assertEquals(StringUtils.removeEndIgnoreCase("www.domain", ".com"), "www.domain"); 
     assertEquals(StringUtils.removeEndIgnoreCase("domain.com", ""), "domain.com"); 
     assertEquals(StringUtils.removeEndIgnoreCase("domain.com", null), "domain.com"); 
 }
@Test
public void testReplaceOnce_StringStringString489() { 
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
     assertEquals("", StringUtils.replaceOnce("foofoofoo", "foo", "")); 
     assertEquals("barbarbar", StringUtils.replaceOnce("foofoofoo", "foo", "bar")); 
     assertEquals("farfarfar", StringUtils.replaceOnce("foofoofoo", "oo", "ar")); 
 }
@Test
public void testRemovePattern490() { 
     assertEquals(null, StringUtils.removePattern(null, null)); 
     assertEquals(null, StringUtils.removePattern(null, "")); 
     assertEquals(null, StringUtils.removePattern(null, "a")); 
     assertEquals("", StringUtils.removePattern("", null)); 
     assertEquals("", StringUtils.removePattern("", "")); 
     assertEquals("", StringUtils.removePattern("", "a")); 
     assertEquals(null, StringUtils.removePattern(null, null)); 
     assertEquals("", StringUtils.removePattern("", null)); 
     assertEquals("a", StringUtils.removePattern("a", null)); 
     assertEquals(null, StringUtils.removePattern(null, "")); 
     assertEquals("", StringUtils.removePattern("", "")); 
     assertEquals("a", StringUtils.removePattern("a", "")); 
     assertEquals("qd", StringUtils.removePattern("queued", "ue")); 
     assertEquals("queued", StringUtils.removePattern("queued", "zz")); 
 }
@Test
public void testCenter_StringIntString495() { 
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
public void testRightPad_StringIntString496() { 
     assertEquals(null, StringUtils.rightPad(null, 5, "-+")); 
     assertEquals(null, StringUtils.rightPad(null, 5, null)); 
     assertEquals("     ", StringUtils.rightPad("", 5, " ")); 
     assertEquals("-+-+abc", StringUtils.rightPad("abc", 7, "-+")); 
     assertEquals("-+~abc", StringUtils.rightPad("abc", 6, "-+~")); 
     assertEquals("-+abc", StringUtils.rightPad("abc", 5, "-+~")); 
     assertEquals("abc", StringUtils.rightPad("abc", 2, " ")); 
     assertEquals("abc", StringUtils.rightPad("abc", -1, " ")); 
     assertEquals("  abc", StringUtils.rightPad("abc", 5, null)); 
     assertEquals("  abc", StringUtils.rightPad("abc", 5, "")); 
 }
@Test
public void testLeftPad_StringInt497() { 
     assertEquals(null, StringUtils.leftPad(null, 5)); 
     assertEquals("     ", StringUtils.leftPad("", 5)); 
     assertEquals("  abc", StringUtils.leftPad("abc", 5)); 
     assertEquals("xxabc", StringUtils.leftPad("abc", 5)); 
     assertEquals("\uffff\uffffabc", StringUtils.leftPad("abc", 5)); 
     assertEquals("abc", StringUtils.leftPad("abc", 2)); 
     final String str = StringUtils.leftPad("aaa", 10000); 
     assertEquals(10000, str.length()); 
     assertTrue(StringUtils.containsOnly(str, new char[] { 'a' })); 
 }
@Test
public void testDefaultIfEmpty_StringString499() { 
     assertEquals("NULL", StringUtils.defaultIfEmpty(null, "NULL")); 
     assertEquals("NULL", StringUtils.defaultIfEmpty("", "NULL")); 
     assertEquals("NULL", StringUtils.defaultIfEmpty(" ", "NULL")); 
     assertEquals("abc", StringUtils.defaultIfEmpty("abc", "NULL")); 
     assertNull(StringUtils.defaultIfEmpty("", null)); 
     final String s = StringUtils.defaultIfEmpty("abc", "NULL"); 
     assertEquals("abc", s); 
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
