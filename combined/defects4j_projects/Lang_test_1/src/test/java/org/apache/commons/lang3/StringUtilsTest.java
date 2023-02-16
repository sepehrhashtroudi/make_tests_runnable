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
public void testSplit_String456() { 
     assertArrayEquals(null, StringUtils.split(null)); 
     assertEquals(0, StringUtils.split("").length); 
     String str = "abc def"; 
     String[] res = StringUtils.split(str); 
     assertEquals(2, res.length); 
     assertEquals("abc", res[0]); 
     assertEquals("def", res[1]); 
     str = "abc  def"; 
     res = StringUtils.split(str); 
     assertEquals(3, res.length); 
     assertEquals("abc", res[0]); 
     assertEquals("", res[1]); 
     assertEquals("def", res[2]); 
     str = " abc "; 
     res = StringUtils.split(str); 
     assertEquals(3, res.length); 
     assertEquals("", res[0]); 
     assertEquals("abc", res[1]); 
     assertEquals("", res[2]); 
     str = "a b .c"; 
     res = StringUtils.split(str); 
     assertEquals(3, res.length); 
     assertEquals("a", res[0]); 
     assertEquals("b", res[1]); 
     assertEquals(".c", res[2]); 
     str = " a b .c"; 
     res = StringUtils.split(str); 
     assertEquals(4, res.length); 
     assertEquals("", res[0]); 
     assertEquals("a", res[1]); 
     assertEquals("b", res[2]); 
     assertEquals(".c", res[3]); 
     str = "a  b  .c"; 
     res = StringUtils.split(str); 
     assertEquals(5, res.length);
}

@Test
public void testSplitByWholeString_StringStringInt457() { 
     assertArrayEquals(null, StringUtils.splitByWholeSeparator(null, ".")); 
     assertEquals(0, StringUtils.splitByWholeSeparator("", ".").length); 
     final String stringToSplitOnNulls = "ab   de fg"; 
     final String[] splitOnNullExpectedResults = { "ab", "de fg" }; 
     final String[] splitOnNullResults = StringUtils.splitByWholeSeparator(stringToSplitOnNulls, null); 
     assertEquals(splitOnNullExpectedResults.length, splitOnNullResults.length); 
     for (int i = 0; i < splitOnNullExpectedResults.length; i += 1) { 
         assertEquals(splitOnNullExpectedResults[i], splitOnNullResults[i]); 
     } 
     final String stringToSplitOnCharactersAndString = "abstemiouslyaeiouyabstemiously"; 
     final String[] splitOnStringExpectedResults = { "abstemiously", "abstemiouslyaeiouyabstemiously" }; 
     final String[] splitOnStringResults = StringUtils.splitByWholeSeparator(stringToSplitOnCharactersAndString, "aeiouy"); 
     assertEquals(splitOnStringExpectedResults.length, splitOnStringResults.length); 
     for (int i = 0; i < splitOnStringExpectedResults.length; i++) { 
         assertEquals(splitOnStringExpectedResults[i], splitOnStringResults[i]); 
     } 
 }
@Test
public void testSplitByWholeString_StringStringBooleanInt458() { 
     assertArrayEquals(null, StringUtils.splitByWholeSeparator(null, ".", 3)); 
     assertEquals(0, StringUtils.splitByWholeSeparator("", ".", 3).length); 
     final String stringToSplitOnNulls = "ab   de fg"; 
     final String[] splitOnNullExpectedResults = { "ab", "de fg" }; 
     final String[] splitOnNullResults = StringUtils.splitByWholeSeparator(stringToSplitOnNulls, null, 2); 
     assertEquals(splitOnNullExpectedResults.length, splitOnNullResults.length); 
     for (int i = 0; i < splitOnNullExpectedResults.length; i += 1) { 
         assertEquals(splitOnNullExpectedResults[i], splitOnNullResults[i]); 
     } 
     final String stringToSplitOnCharactersAndString = "abstemiouslyaeiouyabstemiously"; 
     final String[] splitOnStringExpectedResults = { "abstemiously", "abstemiouslyaeiouyabstemiously" }; 
     final String[] splitOnStringResults = StringUtils.splitByWholeSeparator(stringToSplitOnCharactersAndString, "aeiouy", 2); 
     assertEquals(splitOnStringExpectedResults.length, splitOnStringResults.length); 
     for (int i = 0; i < splitOnStringExpectedResults.length; i++) { 
         assertEquals(splitOnStringExpectedResults[i], splitOnStringResults[i]); 
     } 
 }
@Test
public void testJoin_Array459() { 
     assertEquals(null, StringUtils.join((Object[]) null)); 
     assertEquals(TEXT_LIST_NOSEP, StringUtils.join(ARRAY_LIST)); 
     assertEquals(TEXT_LIST_NOSEP, StringUtils.join(ARRAY_LIST, "")); 
     assertEquals("", StringUtils.join(NULL_ARRAY_LIST)); 
     assertEquals("", StringUtils.join(EMPTY_ARRAY_LIST)); 
     assertEquals("", StringUtils.join(EMPTY_ARRAY_LIST)); 
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
public void testJoin_ArrayOfLongs460() { 
     assertEquals(null, StringUtils.join((long[]) null, ',')); 
     assertEquals("1;2", StringUtils.join(INT_PRIM_LIST, SEPARATOR_CHAR)); 
     assertEquals("2", StringUtils.join(INT_PRIM_LIST, SEPARATOR_CHAR, 1, 2)); 
 }
@Test
public void testJoin_ArrayOfLongs461() { 
     assertEquals(null, StringUtils.join((long[]) null, ',')); 
     assertEquals("1;2", StringUtils.join(LONG_PRIM_LIST, SEPARATOR_CHAR)); 
     assertEquals("2", StringUtils.join(LONG_PRIM_LIST, SEPARATOR_CHAR, 1, 2)); 
 }
@Test
public void testJoin_ArrayOfShorts462() { 
     assertEquals(null, StringUtils.join((short[]) null, ',')); 
     assertEquals("1;2", StringUtils.join(SHORT_PRIM_LIST, SEPARATOR_CHAR)); 
     assertEquals("2", StringUtils.join(SHORT_PRIM_LIST, SEPARATOR_CHAR, 1, 2)); 
 }
@Test
public void testJoin_ArrayOfDoubles463() { 
     assertEquals(null, StringUtils.join((double[]) null, ',')); 
     assertEquals("1.0;2.0", StringUtils.join(DOUBLE_PRIM_LIST, SEPARATOR_CHAR)); 
     assertEquals("2.0", StringUtils.join(DOUBLE_PRIM_LIST, SEPARATOR_CHAR, 1, 2)); 
 }
@Test
public void testRemoveStart464() { 
     assertNull(StringUtils.removeStart(null, null)); 
     assertNull(StringUtils.removeStart(null, "")); 
     assertNull(StringUtils.removeStart(null, "a")); 
     assertEquals(StringUtils.removeStart("", null), ""); 
     assertEquals(StringUtils.removeStart("", ""), ""); 
     assertEquals(StringUtils.removeStart("", "a"), ""); 
     assertEquals(StringUtils.removeStart("www.domain.com.", ".com"), "www.domain.com."); 
     assertEquals(StringUtils.removeStart("www.domain.com", ".com"), "www.domain"); 
     assertEquals(StringUtils.removeStart("www.domain", ".com"), "www.domain"); 
     assertEquals(StringUtils.removeStart("domain.com", ""), "domain.com"); 
     assertEquals(StringUtils.removeStart("domain.com", null), "domain.com"); 
 }
@Test
public void testChomp467() { 
     final String[][] chopCases = { { FOO_UNCAP + "\r\n", FOO_UNCAP }, { FOO_UNCAP + "\n", FOO_UNCAP }, { FOO_UNCAP + "\r", FOO_UNCAP }, { FOO_UNCAP + " \r", FOO_UNCAP + " " }, { "foo", "fo" }, { "foo\nfoo", "foo\nfo" }, { "\n", "" }, { "\r", "" }, { "\r\n", "" }, { null, null }, { "", "" }, { "a", "" } }; 
     for (final String[] chopCase : chopCases) { 
         final String original = chopCase[0]; 
         final String expectedResult = chopCase[1]; 
         assertEquals("chomp(String) failed", expectedResult, StringUtils.chomp(original)); 
     } 
 }
@Test
public void testChomp_String468() { 
     assertEquals(null, StringUtils.chomp(null)); 
     assertEquals("", StringUtils.chomp("")); 
     assertEquals("", StringUtils.chomp(" ")); 
     assertEquals("", StringUtils.chomp("\t")); 
     assertEquals("", StringUtils.chomp("\n")); 
     assertEquals("", StringUtils.chomp("\u0009")); 
     assertEquals("", StringUtils.chomp("\u000B")); 
     assertEquals("", StringUtils.chomp("\u000C")); 
     assertEquals("", StringUtils.chomp("\u001C")); 
     assertEquals("", StringUtils.chomp("\u001D")); 
     assertEquals("", StringUtils.chomp("\u001E")); 
     assertEquals("", StringUtils.chomp("\u001F")); 
     assertEquals("", StringUtils.chomp("\f")); 
     assertEquals("", StringUtils.chomp("\r")); 
     assertEquals("a", StringUtils.chomp("  a  ")); 
     assertEquals("a b c", StringUtils.chomp("  a  b   c  ")); 
     assertEquals("a b c", StringUtils.chomp("a\t\f\r  b\u000B   c\n")); 
 }
@Test
public void testChomp469() { 
     assertEquals("foo", StringUtils.chomp("fooXXbarXXbaz", "XX")); 
     assertEquals(null, StringUtils.chomp(null, null)); 
     assertEquals(null, StringUtils.chomp(null, "")); 
     assertEquals(null, StringUtils.chomp(null, "XX")); 
     assertEquals("", StringUtils.chomp("", null)); 
     assertEquals("", StringUtils.chomp("", "")); 
     assertEquals("", StringUtils.chomp("", "XX")); 
     assertEquals("foo", StringUtils.chomp("foo", null)); 
     assertEquals("foo", StringUtils.chomp("foo", "b")); 
     assertEquals("f", StringUtils.chomp("foot", "o")); 
     assertEquals("", StringUtils.chomp("abc", "a")); 
     assertEquals("a", StringUtils.chomp("abcba", "b")); 
     assertEquals("ab", StringUtils.chomp("abc", "c")); 
     assertEquals("", StringUtils.chomp("abc", "")); 
 }
@Test
public void testRepeat_StringStringInt471() { 
     assertEquals(null, StringUtils.repeat(null, ".", 3)); 
     assertEquals(null, StringUtils.repeat(null, ".", 3)); 
     assertEquals("", StringUtils.repeat("ab", null, 3)); 
     assertEquals("", StringUtils.repeat("", ".", 3)); 
     assertEquals("aaa", StringUtils.repeat("a", ".", 3)); 
     assertEquals("ababab", StringUtils.repeat("ab", ".", 3)); 
     assertEquals("abcabcabc", StringUtils.repeat("abc", ".", 3)); 
     final String str = StringUtils.repeat("a", ".", 10000); 
     assertEquals(10000, str.length()); 
     assertTrue(StringUtils.containsOnly(str, new char[] { 'a' })); 
 }
@Test
public void testSwapCase_String472() { 
     assertEquals(null, StringUtils.swapCase(null)); 
     assertEquals("", StringUtils.swapCase("")); 
     assertEquals("  ", StringUtils.swapCase("  ")); 
     assertEquals("i", StringUtils.swapCase("I")); 
     assertEquals("I", StringUtils.swapCase("i")); 
     assertEquals("I AM HERE 123", StringUtils.swapCase("i am here 123")); 
     assertEquals("i aM hERE 123", StringUtils.swapCase("I Am Here 123")); 
     assertEquals("I AM here 123", StringUtils.swapCase("i am HERE 123")); 
     assertEquals("i am here 123", StringUtils.swapCase("I AM HERE 123")); 
     final String test = "This String contains a TitleCase character: \u01C8"; 
     final String expect = "tHIS sTRING CONTAINS A tITLEcASE CHARACTER: \u01C9"; 
     assertEquals(expect, StringUtils.swapCase(test)); 
 }
@Test
public void testDefaultIfBlank474() { 
     assertEquals("NULL", StringUtils.defaultIfBlank(null, "NULL")); 
     assertEquals("", StringUtils.defaultIfBlank("", "NULL")); 
     assertEquals("abc", StringUtils.defaultIfBlank("abc", "NULL")); 
     assertEquals("abc", StringUtils.defaultIfBlank("abc", "")); 
     assertEquals("i am a robot", StringUtils.defaultIfBlank("I Am a machine", "NULL")); 
     assertEquals("robot", StringUtils.defaultIfBlank("i am a machine", "NULL")); 
     assertEquals("", StringUtils.defaultIfBlank("abc", "NULL")); 
     assertEquals("you are a robot", StringUtils.defaultIfBlank("i am a robot", "Y")); 
 }
@Test
public void testDifference_StringString475() { 
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
public void testGetCommonPrefix476() { 
     assertEquals("", StringUtils.getCommonPrefix((String[]) null)); 
     assertEquals("", StringUtils.getCommonPrefix()); 
     assertEquals("", StringUtils.getCommonPrefix("")); 
     assertEquals("", StringUtils.getCommonPrefix(" ")); 
     assertEquals("", StringUtils.getCommonPrefix("\t")); 
     assertEquals("", StringUtils.getCommonPrefix("\n")); 
     assertEquals("", StringUtils.getCommonPrefix("\u0009")); 
     assertEquals("", StringUtils.getCommonPrefix("\u000B")); 
     assertEquals("", StringUtils.getCommonPrefix("\u000C")); 
     assertEquals("", StringUtils.getCommonPrefix("\u001C")); 
     assertEquals("", StringUtils.getCommonPrefix("\u001D")); 
     assertEquals("", StringUtils.getCommonPrefix("\u001E")); 
     assertEquals("", StringUtils.getCommonPrefix("\u001F")); 
     assertEquals("", StringUtils.getCommonPrefix("\f")); 
     assertEquals("", StringUtils.getCommonPrefix("\r")); 
     assertEquals("a", StringUtils.getCommonPrefix("  a  ")); 
     assertEquals("a b c", StringUtils.getCommonPrefix("  a  b   c  ")); 
     assertEquals("a b c", StringUtils.getCommonPrefix("a\t\f\r  b\u000B   c\n")); 
 }
@Test
public void testGetCommonPrefix477() { 
     assertEquals("", StringUtils.getCommonPrefix(null, null)); 
     assertEquals("", StringUtils.getCommonPrefix("", null)); 
     assertEquals("", StringUtils.getCommonPrefix("abc", null)); 
     assertEquals("abc", StringUtils.getCommonPrefix("abc", "")); 
     assertEquals("i am a robot", StringUtils.getCommonPrefix(null, "i am a robot")); 
     assertEquals("i am a machine", StringUtils.getCommonPrefix("i am a machine", null)); 
     assertEquals("robot", StringUtils.getCommonPrefix("i am a machine", "i am a robot")); 
     assertEquals("", StringUtils.getCommonPrefix("abc", "robot")); 
     assertEquals("you are a robot", StringUtils.getCommonPrefix("i am a robot", "you are a robot")); 
 }
@Test
public void testGetCommonPrefix479() { 
     assertEquals("", StringUtils.getCommonPrefix(null, null)); 
     assertEquals("", StringUtils.getCommonPrefix("", null)); 
     assertEquals("abc", StringUtils.getCommonPrefix("abc", null)); 
     assertEquals("", StringUtils.getCommonPrefix("abc", "")); 
     assertEquals("i am a robot", StringUtils.getCommonPrefix(null, "i am a robot")); 
     assertEquals("i am a machine", StringUtils.getCommonPrefix("i am a machine", null)); 
     assertEquals("robot", StringUtils.getCommonPrefix("i am a machine", "i am a robot")); 
     assertEquals("", StringUtils.getCommonPrefix("abc", "robot")); 
     assertEquals("you are a robot", StringUtils.getCommonPrefix("i am a robot", "you are a robot")); 
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
