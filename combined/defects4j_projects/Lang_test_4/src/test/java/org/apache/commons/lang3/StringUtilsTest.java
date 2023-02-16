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
public void testReverseDelimited_StringChar516() { 
     assertEquals(null, StringUtils.reverseDelimited(null, '.')); 
     assertEquals("", StringUtils.reverseDelimited("", '.')); 
     assertEquals("c.b.a", StringUtils.reverseDelimited("a.b.c", '.')); 
     assertEquals("a b c", StringUtils.reverseDelimited("a b c", '.')); 
     assertEquals("", StringUtils.reverseDelimited("", '.')); 
 }
@Test
public void testSplitByCharacterType_String517() { 
     assertNull(StringUtils.splitByCharacterType(null)); 
     assertEquals(0, StringUtils.splitByCharacterType("").length); 
     assertTrue(ArrayUtils.isEquals(new String[] { "ab", " ", "de", " ", "fg" }, StringUtils.splitByCharacterType("ab de fg"))); 
     assertTrue(ArrayUtils.isEquals(new String[] { "ab", "   ", "de", " ", "fg" }, StringUtils.splitByCharacterType("ab   de fg"))); 
     assertTrue(ArrayUtils.isEquals(new String[] { "ab", ":", "cd", ":", "ef" }, StringUtils.splitByCharacterType("ab:cd:ef"))); 
     assertTrue(ArrayUtils.isEquals(new String[] { "number", "5" }, StringUtils.splitByCharacterType("number5"))); 
     assertTrue(ArrayUtils.isEquals(new String[] { "foo", "Bar" }, StringUtils.splitByCharacterType("fooBar"))); 
     assertTrue(ArrayUtils.isEquals(new String[] { "foo", "200", "Bar" }, StringUtils.splitByCharacterType("foo200Bar"))); 
     assertTrue(ArrayUtils.isEquals(new String[] { "ASF", "Rules" }, StringUtils.splitByCharacterType("ASFRules"))); 
 }
@Test
public void testJoin_ArrayOfInts518() { 
     assertEquals(null, StringUtils.join((Object[]) null, ',')); 
     assertEquals("1;2", StringUtils.join(INT_PRIM_LIST, SEPARATOR_CHAR)); 
     assertEquals("2", StringUtils.join(INT_PRIM_LIST, SEPARATOR_CHAR, 1, 2)); 
 }
@Test
public void testJoin_ArrayOfPrimitives519() { 
     assertEquals(null, StringUtils.join((float[]) null, ',')); 
     assertEquals("1.0;2.0", StringUtils.join(FLOAT_PRIM_LIST, SEPARATOR_CHAR)); 
     assertEquals("2.0", StringUtils.join(FLOAT_PRIM_LIST, SEPARATOR_CHAR, 1, 2)); 
 }
@Test
public void testJoin_ArrayOfFloats520() { 
     assertEquals(null, StringUtils.join((float[]) null, ',')); 
     assertEquals("1.0;2.0", StringUtils.join(FLOAT_PRIM_LIST, SEPARATOR_CHAR)); 
     assertEquals("2.0", StringUtils.join(FLOAT_PRIM_LIST, SEPARATOR_CHAR, 1, 2)); 
 }
@Test
public void testJoin_ArrayOfLongs521() { 
     assertEquals(null, StringUtils.join((Object[]) null, ',')); 
     assertEquals("1;2", StringUtils.join(LONG_PRIM_LIST, SEPARATOR_CHAR)); 
     assertEquals("2", StringUtils.join(LONG_PRIM_LIST, SEPARATOR_CHAR, 1, 2)); 
 }
@Test
public void testJoin_ArrayOfObjects522() { 
     assertEquals(null, StringUtils.join((Object[]) null, ',')); 
     assertEquals("1;2", StringUtils.join(INT_PRIM_LIST, SEPARATOR_CHAR)); 
     assertEquals("2", StringUtils.join(INT_PRIM_LIST, SEPARATOR_CHAR, 1, 2)); 
 }
@Test
public void testJoin_ArrayOfInts523() { 
     assertEquals(null, StringUtils.join((Object[]) null, ",")); 
     assertEquals("1;2", StringUtils.join(INT_PRIM_LIST, SEPARATOR_CHAR)); 
     assertEquals("2", StringUtils.join(INT_PRIM_LIST, SEPARATOR_CHAR, 1, 2)); 
 }
@Test
public void testJoin_ArrayOfObjects524() { 
     assertEquals(null, StringUtils.join((Object[]) null, null, 2, 4)); 
     assertEquals("1;2", StringUtils.join(INT_PRIM_LIST, null, 2, 4)); 
     assertEquals("2", StringUtils.join(INT_PRIM_LIST, "", 2, 4)); 
     assertEquals("3", StringUtils.join(INT_PRIM_LIST, "", 4, 2)); 
     assertEquals("1", StringUtils.join(INT_PRIM_LIST, "x", 2, 4)); 
     assertEquals("2", StringUtils.join(INT_PRIM_LIST, "y", 2, 4)); 
     assertEquals("3", StringUtils.join(INT_PRIM_LIST, "z", 2, 4)); 
 }
@Test
public void testJoin_ArrayOfObjects525() { 
     assertEquals(null, StringUtils.join((Object[]) null, null, 2, 4)); 
     assertEquals("1;2", StringUtils.join(INT_PRIM_LIST, null, 2, 4)); 
     assertEquals("2", StringUtils.join(INT_PRIM_LIST, "", 2, 4)); 
     assertEquals("3", StringUtils.join(INT_PRIM_LIST, "x", 2, 4)); 
     assertEquals("4", StringUtils.join(INT_PRIM_LIST, "y", 2, 4)); 
     assertEquals("2", StringUtils.join(INT_PRIM_LIST, "z", 2, 4)); 
 }
@Test
public void testJoin_ArrayOfObjects526() { 
     assertEquals(null, StringUtils.join((Object[]) null, ",")); 
     assertEquals("1;2", StringUtils.join(INT_PRIM_LIST, SEPARATOR_CHAR)); 
     assertEquals("2", StringUtils.join(INT_PRIM_LIST, SEPARATOR_CHAR, 1, 2)); 
 }
@Test
public void testJoin_ArrayOfObjects527() { 
     assertEquals(null, StringUtils.join((Object[]) null, null, 2, 4)); 
     assertEquals("1;2", StringUtils.join(INT_PRIM_LIST, null, 2, 4)); 
     assertEquals("2", StringUtils.join(INT_PRIM_LIST, "", 2, 4)); 
     assertEquals("3", StringUtils.join(INT_PRIM_LIST, "", 3, 2)); 
     assertEquals("4", StringUtils.join(INT_PRIM_LIST, "", 4, 2)); 
     assertEquals("2", StringUtils.join(INT_PRIM_LIST, "x", 2, 4)); 
     assertEquals("", StringUtils.join(INT_PRIM_LIST, null, 3, 2)); 
     assertEquals("", StringUtils.join(INT_PRIM_LIST, "", 2, 4)); 
     assertEquals("", StringUtils.join(INT_PRIM_LIST, "", 4, 2)); 
 }
@Test
public void testJoin_IterableString528() { 
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
     assertEquals(TEXT_LIST, StringUtils.join(Arrays.asList(ARRAY_LIST), SEPARATOR)); 
 }
@Test
public void testJoin_IterableString529() { 
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
     assertEquals("foo", StringUtils.join(Collections.singleton("foo"), "x")); 
 }
@Test
public void testReplacePattern_StringStringString530() { 
     assertEquals(null, StringUtils.replacePattern(null, "a", null)); 
     assertEquals(null, StringUtils.replacePattern(null, "a", "any")); 
     assertEquals(null, StringUtils.replacePattern(null, "a", "any")); 
     assertEquals("", StringUtils.replacePattern("", null, null)); 
     assertEquals("", StringUtils.replacePattern("", "", null)); 
     assertEquals("", StringUtils.replacePattern("", "a", null)); 
     assertEquals("", StringUtils.replacePattern("", "a", "")); 
     assertEquals("", StringUtils.replacePattern("", "a", "any")); 
     assertEquals("FOO", StringUtils.replacePattern("FOO", "", "any")); 
     assertEquals("FOO", StringUtils.replacePattern("FOO", null, "any")); 
     assertEquals("FOO", StringUtils.replacePattern("FOO", "F", null)); 
     assertEquals("FOO", StringUtils.replacePattern("FOO", null, null)); 
     assertEquals("", StringUtils.replacePattern("foofoofoo", "foo", "")); 
     assertEquals("barbarbar", StringUtils.replacePattern("foofoofoo", "foo", "bar")); 
     assertEquals("farfarfar", StringUtils.replacePattern("foofoofoo", "oo", "ar")); 
 }
@Test
public void testReplacePattern_StringStringString531() { 
     assertEquals(null, StringUtils.replacePattern(null, "[a-z]*", null)); 
     assertEquals(null, StringUtils.replacePattern(null, "[a-z]*", "any")); 
     assertEquals(null, StringUtils.replacePattern(null, "[a-z]*", "")); 
     assertEquals(null, StringUtils.replacePattern(null, "[a-z]*", "any")); 
     assertEquals("", StringUtils.replacePattern("", null, null)); 
     assertEquals("", StringUtils.replacePattern("", "", null)); 
     assertEquals("", StringUtils.replacePattern("", "a", null)); 
     assertEquals("", StringUtils.replacePattern("", "a", "")); 
     assertEquals("", StringUtils.replacePattern("", "a", "any")); 
     assertEquals("FOO", StringUtils.replacePattern("FOO", "", "any")); 
     assertEquals("FOO", StringUtils.replacePattern("FOO", null, "any")); 
     assertEquals("FOO", StringUtils.replacePattern("FOO", "F", null)); 
     assertEquals("FOO", StringUtils.replacePattern("FOO", null, null)); 
     assertEquals("", StringUtils.replacePattern("foofoofoo", "foo", "")); 
     assertEquals("barbarbar", StringUtils.replacePattern("foofoofoo", "foo", "bar")); 
     assertEquals("farfarfar", StringUtils.replacePattern("foofoofoo", "oo", "ar")); 
 }
@SuppressWarnings("deprecation")
@Test
public void testRepeat_charInt534() { 
     assertEquals(null, StringUtils.repeat(null, 2)); 
     assertEquals("", StringUtils.repeat('a', 2)); 
     assertEquals("", StringUtils.repeat('b', 2)); 
     assertEquals("", StringUtils.repeat('c', 2)); 
     assertEquals("", StringUtils.repeat('d', 2)); 
     assertEquals("aaa", StringUtils.repeat('a', 3)); 
     assertEquals("ab", StringUtils.repeat('b', 3)); 
     assertEquals("ab", StringUtils.repeat('c', 2)); 
     assertEquals("abc", StringUtils.repeat('d', 3)); 
     final String str = StringUtils.repeat('a', 10000); 
     assertEquals(10000, str.length()); 
     assertTrue(StringUtils.containsOnly(str, new char[] { 'a' })); 
 }
@Test
public void testRepeat_char_int535() { 
     assertEquals(null, StringUtils.repeat(null, 2)); 
     assertEquals("", StringUtils.repeat('a', 2)); 
     assertEquals("", StringUtils.repeat('b', 2)); 
     assertEquals("", StringUtils.repeat('c', 2)); 
     assertEquals("", StringUtils.repeat('d', 2)); 
     assertEquals("aaa", StringUtils.repeat('a', 3)); 
     assertEquals("ab", StringUtils.repeat('b', 3)); 
     assertEquals("ab", StringUtils.repeat('c', 2)); 
     assertEquals("abc", StringUtils.repeat('d', 3)); 
     final String str = StringUtils.repeat('a', 10000); 
     assertEquals(10000, str.length()); 
     assertTrue(StringUtils.containsOnly(str, new char[] { 'a' })); 
 }
@Test
public void testCenter_StringIntString536() { 
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
public void testLength537() { 
     assertEquals(null, StringUtils.length(null)); 
     assertEquals("", StringUtils.length("")); 
     assertEquals("", StringUtils.length(" ")); 
     assertEquals("", StringUtils.length("a")); 
     assertEquals("", StringUtils.length("A")); 
     assertEquals("", StringUtils.length("kgKgKgKgkgkGkjkjlJlOKLgHdGdHgl")); 
     assertEquals("", StringUtils.length("ham kso")); 
     assertEquals("", StringUtils.length("1")); 
     assertEquals("1", StringUtils.length("hkHKHik6iUGHKJgU7tUJgKJGI87GIkug")); 
     assertEquals("", StringUtils.length("_")); 
     assertEquals("", StringUtils.length("hkHKHik*khbkuh")); 
 }
@Test
public void testLength538() { 
     assertEquals(null, StringUtils.length(null)); 
     assertEquals("", StringUtils.length("")); 
     assertEquals("", StringUtils.length(" ")); 
     assertEquals("", StringUtils.length("a")); 
     assertEquals("", StringUtils.length("  a")); 
     assertEquals(StringUtilsTest.NON_WHITESPACE, StringUtils.length(StringUtilsTest.WHITESPACE + StringUtilsTest.NON_WHITESPACE + StringUtilsTest.WHITESPACE)); 
 }
@Test
public void testCapitalize_String547() { 
     assertEquals(null, StringUtils.capitalize(null)); 
     assertEquals("", StringUtils.capitalize("")); 
     assertEquals("  ", StringUtils.capitalize("  ")); 
     assertEquals("I", StringUtils.capitalize("I")); 
     assertEquals("I", StringUtils.capitalize("i")); 
     assertEquals("I Am Here 123", StringUtils.capitalize("i am here 123")); 
     assertEquals("I Am Here 123", StringUtils.capitalize("I Am Here 123")); 
     assertEquals("I Am Here 123", StringUtils.capitalize("i am HERE 123")); 
     assertEquals("I Am Here 123", StringUtils.capitalize("I AM HERE 123")); 
 }
@Test
public void testCapitalize_String548() { 
     assertEquals(null, StringUtils.capitalize(null)); 
     assertEquals("", StringUtils.capitalize("")); 
     assertEquals("  ", StringUtils.capitalize("  ")); 
     assertEquals("I", StringUtils.capitalize("I")); 
     assertEquals("I", StringUtils.capitalize("i")); 
     assertEquals("I AM HERE 123", StringUtils.capitalize("i am here 123")); 
     assertEquals("i aM hERE 123", StringUtils.capitalize("I Am Here 123")); 
     assertEquals("I AM here 123", StringUtils.capitalize("i am HERE 123")); 
     assertEquals("i am here 123", StringUtils.capitalize("I AM HERE 123")); 
     final String test = "This String contains a TitleCase character: \u01C8"; 
     final String expect = "tHIS sTRING CONTAINS A tITLEcASE CHARACTER: \u01C9"; 
     assertEquals(expect, StringUtils.capitalize(test)); 
 }
@Test
public void testUncapitalize_String549() { 
     assertEquals(null, StringUtils.uncapitalize(null)); 
     assertEquals("", StringUtils.uncapitalize("")); 
     assertEquals("  ", StringUtils.uncapitalize("  ")); 
     assertEquals("i", WordUtils.uncapitalize("I")); 
     assertEquals("i", WordUtils.uncapitalize("i")); 
     assertEquals("I AM HERE 123", StringUtils.uncapitalize("i am here 123")); 
     assertEquals("i aM hERE 123", StringUtils.uncapitalize("I Am Here 123")); 
     assertEquals("I AM here 123", StringUtils.uncapitalize("i am HERE 123")); 
     assertEquals("i am here 123", StringUtils.uncapitalize("I AM HERE 123")); 
     final String test = "This String contains a Title"; 
     final String expect = "tHIS sTRING CONTAINS A tITLEcASE CHARACTER: \u01C8"; 
     assertEquals(expect, WordUtils.uncapitalize(test)); 
 }
@Test
public void testUncapitalize_String550() { 
     assertEquals(null, StringUtils.uncapitalize(null)); 
     assertEquals("", StringUtils.uncapitalize("")); 
     assertEquals("  ", StringUtils.uncapitalize("  ")); 
     assertEquals("i", WordUtils.uncapitalize("I")); 
     assertEquals("I", WordUtils.uncapitalize("i")); 
     assertEquals("I AM HERE 123", StringUtils.uncapitalize("i am here 123")); 
     assertEquals("i aM hERE 123", StringUtils.uncapitalize("I Am Here 123")); 
     assertEquals("I AM here 123", StringUtils.uncapitalize("i am HERE 123")); 
     assertEquals("i am here 123", StringUtils.uncapitalize("I AM HERE 123")); 
     final String test = "This String contains a Title"; 
     final String expect = "tHIS sTRING CONTAINS A tITLEcASE CHARACTER: \u01C8"; 
     assertEquals(expect, WordUtils.uncapitalize(test)); 
 }
@Test
public void testIsAllUpperCase553() { 
     assertFalse(StringUtils.isAllUpperCase(null)); 
     assertFalse(StringUtils.isAllUpperCase(StringUtils.EMPTY)); 
     assertTrue(StringUtils.isAllUpperCase("abc")); 
     assertFalse(StringUtils.isAllUpperCase("abc ")); 
     assertFalse(StringUtils.isAllUpperCase("abC")); 
 }
@Test
public void testIsAllUpperCase554() { 
     assertFalse(StringUtils.isAllUpperCase(null)); 
     assertFalse(StringUtils.isAllUpperCase("")); 
     assertFalse(StringUtils.isAllUpperCase(" ")); 
     assertTrue(StringUtils.isAllUpperCase("a")); 
     assertTrue(StringUtils.isAllUpperCase("A")); 
     assertTrue(StringUtils.isAllUpperCase("kgKgKgKgkgkGkjkjlJlOKLgHdGdHgl")); 
     assertFalse(StringUtils.isAllUpperCase("ham kso")); 
     assertFalse(StringUtils.isAllUpperCase("1")); 
     assertFalse(StringUtils.isAllUpperCase("hkHKHik6iUGHKJgU7tUJgKJGI87GIkug")); 
     assertFalse(StringUtils.isAllUpperCase("_")); 
     assertFalse(StringUtils.isAllUpperCase("hkHKHik*khbkuh")); 
 }
@Test
public void testDefault_StringString555() { 
     assertEquals("NULL", StringUtils.defaultString(null, "NULL")); 
     assertEquals("NULL", StringUtils.defaultString("", "NULL")); 
 }
@Test
public void testDifference_StringStringArray564() { 
     assertEquals(null, StringUtils.difference(null, null)); 
     assertEquals("", StringUtils.difference("", "")); 
     assertEquals("abc", StringUtils.difference("", "abc")); 
     assertEquals("", StringUtils.difference("abc", "")); 
     assertEquals("i am a robot", StringUtils.difference(null, "i am a robot")); 
     assertEquals("i am a machine", StringUtils.difference("i am a machine", null)); 
     assertEquals("robot", StringUtils.difference("i am a machine", "i")); 
     assertEquals("", StringUtils.difference("abc", "abc")); 
     assertEquals("you are a robot", StringUtils.difference("i am a robot", "you are a robot")); 
 }
@Test
public void testGetLevenshteinDistance_StringString565() { 
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
         final int d = StringUtils.getLevenshteinDistance(null, "a", 0); 
         fail("expecting IllegalArgumentException"); 
     } catch (final IllegalArgumentException ex) { 
     } 
 }
@Test
public void testGetLevenshteinDistance_StringStringInt568() { 
     assertEquals(0, StringUtils.getLevenshteinDistance("", "", 0)); 
     assertEquals(1, StringUtils.getLevenshteinDistance("", "", -1)); 
     assertEquals(7, StringUtils.getLevenshteinDistance("aaapppp", "", 0)); 
     assertEquals(1, StringUtils.getLevenshteinDistance("frog", "fog", 0)); 
     assertEquals(3, StringUtils.getLevenshteinDistance("fly", "ant", 0)); 
     assertEquals(7, StringUtils.getLevenshteinDistance("elephant", "hippo", 0)); 
     assertEquals(7, StringUtils.getLevenshteinDistance("hippo", "elephant", 1)); 
     assertEquals(8, StringUtils.getLevenshteinDistance("hippo", "zzzzzzzz", 0)); 
     assertEquals(8, StringUtils.getLevenshteinDistance("zzzzzzzz", "hippo", 2)); 
     assertEquals(1, StringUtils.getLevenshteinDistance("hello", "hallo", 0)); 
     try { 
         @SuppressWarnings("unused") 
         final int d = StringUtils.getLevenshteinDistance("a", null, -1); 
         fail("expecting IllegalArgumentException"); 
     } catch (final IllegalArgumentException ex) { 
     } 
     try { 
         @SuppressWarnings("unused") 
         final int d = StringUtils.getLevenshteinDistance(null, "a", 0); 
         fail("expecting IllegalArgumentException"); 
     } catch (final IllegalArgumentException ex) { 
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
