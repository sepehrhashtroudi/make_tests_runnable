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
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;

import org.junit.Test;

/**
 * Unit tests {@link org.apache.commons.lang3.StringUtils} - Substring methods
 *
 * @version $Id$
 */
public class StringUtilsSubstringTest  {
    private static final String FOO = "foo";
    private static final String BAR = "bar";
    private static final String BAZ = "baz";
    private static final String FOOBAR = "foobar";
    private static final String SENTENCE = "foo bar baz";

    //-----------------------------------------------------------------------

@Test
public void testRight_String3() { 
     assertSame(null, StringUtils.right(null, -1)); 
     assertSame(null, StringUtils.right(null, 0)); 
     assertSame(null, StringUtils.right(null, 2)); 
     assertEquals("", StringUtils.right("", -1)); 
     assertEquals("", StringUtils.right("", 0)); 
     assertEquals("", StringUtils.right("", 2)); 
     assertEquals("", StringUtils.right(FOOBAR, -1)); 
     assertEquals("", StringUtils.right(FOOBAR, 0)); 
     assertEquals(BAR, StringUtils.right(FOOBAR, 3)); 
     assertSame(FOOBAR, StringUtils.right(FOOBAR, 80)); 
 }
@Test
public void testSubstringAfterLast_StringString8() { 
     assertEquals("baz", StringUtils.substringAfterLast("fooXXbarXXbaz", "XX")); 
     assertEquals(null, StringUtils.substringAfterLast(null, null)); 
     assertEquals(null, StringUtils.substringAfterLast(null, "")); 
     assertEquals(null, StringUtils.substringAfterLast(null, "XX")); 
     assertEquals("", StringUtils.substringAfterLast("", null)); 
     assertEquals("", StringUtils.substringAfterLast("", "")); 
     assertEquals("", StringUtils.substringAfterLast("", "a")); 
     assertEquals("", StringUtils.substringAfterLast("foo", null)); 
     assertEquals("", StringUtils.substringAfterLast("foo", "b")); 
     assertEquals("t", StringUtils.substringAfterLast("foot", "o")); 
     assertEquals("bc", StringUtils.substringAfterLast("abc", "a")); 
     assertEquals("a", StringUtils.substringAfterLast("abcba", "b")); 
     assertEquals("", StringUtils.substringAfterLast("abc", "c")); 
     assertEquals("", StringUtils.substringAfterLast("", "d")); 
     assertEquals("", StringUtils.substringAfterLast("abc", "")); 
 }
@Test
public void testSubstringsBetween_StringStringString111() { 
     String[] results = StringUtils.substringsBetween("[one], [two], [three]", "[", "]"); 
     assertEquals(3, results.length); 
     assertEquals("one", results[0]); 
     assertEquals("two", results[1]); 
     assertEquals("three", results[2]); 
     results = StringUtils.substringsBetween("[one], [two], three", "[", "]"); 
     assertEquals(2, results.length); 
     assertEquals("one", results[0]); 
     assertEquals("two", results[1]); 
     results = StringUtils.substringsBetween("[one], [two], three]", "[", "]"); 
     assertEquals(2, results.length); 
     assertEquals("one", results[0]); 
     assertEquals("two", results[1]); 
     results = StringUtils.substringsBetween("[one], two], three]", "[", "]"); 
     assertEquals(1, results.length); 
     assertEquals("one", results[0]); 
     results = StringUtils.substringsBetween("one], two], [three]", "[", "]"); 
     assertEquals(1, results.length); 
     assertEquals("three", results[0]); 
     results = StringUtils.substringsBetween("aabhellobabnonba", "ab", "ba"); 
     assertEquals(1, results.length); 
     assertEquals("hello", results[0]); 
     results = StringUtils.substringsBetween("one, two, three", "[", "]"); 
     assertNull(results); 
     results = StringUtils.substringsBetween("[one, two, three", "[", "]"); 
     assertNull(results); 
     results = StringUtils.substringsBetween("one, two, three]", "[", "]"); 
     assertNull(results); 
     results = StringUtils.substringsBetween("[one], [two], [three]", "[", null); 
     assertNull(results); 
     results = StringUtils.substringsBetween("[one], [two], [three]", null, "]"); 
     assertNull(results); 
     results = StringUtils.substringsBetween("[one], [two], [three]", "", ""); 
     assertNull(results); 
     results = StringUtils.substringsBetween(null, "[", "]"); 
     assertNull(results); 
     results = StringUtils.substringsBetween("", "[", "]"); 
     assertEquals(0, results.length); 
 }
@Test
public void testRight_String232() { 
     assertSame(null, StringUtils.right(null, -1)); 
     assertSame(null, StringUtils.right(null, 0)); 
     assertSame(null, StringUtils.right(null, 2)); 
     assertEquals("", StringUtils.right("", -1)); 
     assertEquals("", StringUtils.right("", 0)); 
     assertEquals("", StringUtils.right("", 2)); 
     assertEquals("", StringUtils.right(FOOBAR, -1)); 
     assertEquals("", StringUtils.right(FOOBAR, 0)); 
     assertEquals(BAR, StringUtils.right(FOOBAR, 3)); 
     assertSame(FOOBAR, StringUtils.right(FOOBAR, 80)); 
 }
@Test
public void testSubstringBetween_StringStringString240() { 
     assertEquals(null, StringUtils.substringBetween(null, "", "")); 
     assertEquals(null, StringUtils.substringBetween("", null, "")); 
     assertEquals(null, StringUtils.substringBetween("", "", null)); 
     assertEquals("", StringUtils.substringBetween("", "", "")); 
     assertEquals("", StringUtils.substringBetween("foo", "", "")); 
     assertEquals(null, StringUtils.substringBetween("foo", "", "]")); 
     assertEquals(null, StringUtils.substringBetween("foo", "[", "]")); 
     assertEquals("", StringUtils.substringBetween("    ", " ", "  ")); 
     assertEquals("bar", StringUtils.substringBetween("<foo>bar</foo>", "<foo>", "</foo>")); 
 }
@Test
public void testCountMatches_String329() { 
     assertEquals(0, StringUtils.countMatches(null, null)); 
     assertEquals(0, StringUtils.countMatches("blah", null)); 
     assertEquals(0, StringUtils.countMatches(null, "DD")); 
     assertEquals(0, StringUtils.countMatches("x", "")); 
     assertEquals(0, StringUtils.countMatches("", "")); 
     assertEquals(3, StringUtils.countMatches("one long someone sentence of one", "one")); 
     assertEquals(0, StringUtils.countMatches("one long someone sentence of one", "two")); 
     assertEquals(4, StringUtils.countMatches("oooooooooooo", "ooo")); 
 }
@Test
public void testSubstringsBetween_StringStringString472() { 
     String[] results = StringUtils.substringsBetween("[one], [two], [three]", "[", "]"); 
     assertEquals(3, results.length); 
     assertEquals("one", results[0]); 
     assertEquals("two", results[1]); 
     assertEquals("three", results[2]); 
     results = StringUtils.substringsBetween("[one], [two], three", "[", "]"); 
     assertEquals(2, results.length); 
     assertEquals("one", results[0]); 
     assertEquals("two", results[1]); 
     results = StringUtils.substringsBetween("[one], [two], three]", "[", "]"); 
     assertEquals(2, results.length); 
     assertEquals("one", results[0]); 
     assertEquals("two", results[1]); 
     results = StringUtils.substringsBetween("[one], two], three]", "[", "]"); 
     assertEquals(1, results.length); 
     assertEquals("one", results[0]); 
     results = StringUtils.substringsBetween("one], two], [three]", "[", "]"); 
     assertEquals(1, results.length); 
     assertEquals("three", results[0]); 
     results = StringUtils.substringsBetween("aabhellobabnonba", "ab", "ba"); 
     assertEquals(1, results.length); 
     assertEquals("hello", results[0]); 
     results = StringUtils.substringsBetween("one, two, three", "[", "]"); 
     assertNull(results); 
     results = StringUtils.substringsBetween("[one, two, three", "[", "]"); 
     assertNull(results); 
     results = StringUtils.substringsBetween("one, two, three]", "[", "]"); 
     assertNull(results); 
     results = StringUtils.substringsBetween("[one], [two], [three]", "[", null); 
     assertNull(results); 
     results = StringUtils.substringsBetween("[one], [two], [three]", null, "]"); 
     assertNull(results); 
     results = StringUtils.substringsBetween("[one], [two], [three]", "", ""); 
     assertNull(results); 
     results = StringUtils.substringsBetween(null, "[", "]"); 
     assertNull(results); 
     results = StringUtils.substringsBetween("", "[", "]"); 
     assertEquals(0, results.length); 
 }
@Test
public void testRight_String510() { 
     assertSame(null, StringUtils.right(null, -1)); 
     assertSame(null, StringUtils.right(null, 0)); 
     assertSame(null, StringUtils.right(null, 2)); 
     assertEquals("", StringUtils.right("", -1)); 
     assertEquals("", StringUtils.right("", 0)); 
     assertEquals("", StringUtils.right("", 2)); 
     assertEquals("", StringUtils.right(FOOBAR, -1)); 
     assertEquals("", StringUtils.right(FOOBAR, 0)); 
     assertEquals(BAR, StringUtils.right(FOOBAR, 3)); 
     assertSame(FOOBAR, StringUtils.right(FOOBAR, 80)); 
 }
@Test
public void testSubstringsBetween_StringStringString617() { 
     String[] results = StringUtils.substringsBetween("[one], [two], [three]", "[", "]"); 
     assertEquals(3, results.length); 
     assertEquals("one", results[0]); 
     assertEquals("two", results[1]); 
     assertEquals("three", results[2]); 
     results = StringUtils.substringsBetween("[one], [two], three", "[", "]"); 
     assertEquals(2, results.length); 
     assertEquals("one", results[0]); 
     assertEquals("two", results[1]); 
     results = StringUtils.substringsBetween("[one], [two], three]", "[", "]"); 
     assertEquals(2, results.length); 
     assertEquals("one", results[0]); 
     assertEquals("two", results[1]); 
     results = StringUtils.substringsBetween("[one], two], three]", "[", "]"); 
     assertEquals(1, results.length); 
     assertEquals("one", results[0]); 
     results = StringUtils.substringsBetween("one], two], [three]", "[", "]"); 
     assertEquals(1, results.length); 
     assertEquals("three", results[0]); 
     results = StringUtils.substringsBetween("aabhellobabnonba", "ab", "ba"); 
     assertEquals(1, results.length); 
     assertEquals("hello", results[0]); 
     results = StringUtils.substringsBetween("one, two, three", "[", "]"); 
     assertNull(results); 
     results = StringUtils.substringsBetween("[one, two, three", "[", "]"); 
     assertNull(results); 
     results = StringUtils.substringsBetween("one, two, three]", "[", "]"); 
     assertNull(results); 
     results = StringUtils.substringsBetween("[one], [two], [three]", "[", null); 
     assertNull(results); 
     results = StringUtils.substringsBetween("[one], [two], [three]", null, "]"); 
     assertNull(results); 
     results = StringUtils.substringsBetween("[one], [two], [three]", "", ""); 
     assertNull(results); 
     results = StringUtils.substringsBetween(null, "[", "]"); 
     assertNull(results); 
     results = StringUtils.substringsBetween("", "[", "]"); 
     assertEquals(0, results.length); 
 }
@Test
public void testLeft_String652() { 
     assertSame(null, StringUtils.left(null, -1)); 
     assertSame(null, StringUtils.left(null, 0)); 
     assertSame(null, StringUtils.left(null, 2)); 
     assertEquals("", StringUtils.left("", -1)); 
     assertEquals("", StringUtils.left("", 0)); 
     assertEquals("", StringUtils.left("", 2)); 
     assertEquals("", StringUtils.left(FOOBAR, -1)); 
     assertEquals("", StringUtils.left(FOOBAR, 0)); 
     assertEquals(FOO, StringUtils.left(FOOBAR, 3)); 
     assertSame(FOOBAR, StringUtils.left(FOOBAR, 80)); 
 }
@Test
public void testSubstringsBetween_StringStringString674() { 
     String[] results = StringUtils.substringsBetween("[one], [two], [three]", "[", "]"); 
     assertEquals(3, results.length); 
     assertEquals("one", results[0]); 
     assertEquals("two", results[1]); 
     assertEquals("three", results[2]); 
     results = StringUtils.substringsBetween("[one], [two], three", "[", "]"); 
     assertEquals(2, results.length); 
     assertEquals("one", results[0]); 
     assertEquals("two", results[1]); 
     results = StringUtils.substringsBetween("[one], [two], three]", "[", "]"); 
     assertEquals(2, results.length); 
     assertEquals("one", results[0]); 
     assertEquals("two", results[1]); 
     results = StringUtils.substringsBetween("[one], two], three]", "[", "]"); 
     assertEquals(1, results.length); 
     assertEquals("one", results[0]); 
     results = StringUtils.substringsBetween("one], two], [three]", "[", "]"); 
     assertEquals(1, results.length); 
     assertEquals("three", results[0]); 
     results = StringUtils.substringsBetween("aabhellobabnonba", "ab", "ba"); 
     assertEquals(1, results.length); 
     assertEquals("hello", results[0]); 
     results = StringUtils.substringsBetween("one, two, three", "[", "]"); 
     assertNull(results); 
     results = StringUtils.substringsBetween("[one, two, three", "[", "]"); 
     assertNull(results); 
     results = StringUtils.substringsBetween("one, two, three]", "[", "]"); 
     assertNull(results); 
     results = StringUtils.substringsBetween("[one], [two], [three]", "[", null); 
     assertNull(results); 
     results = StringUtils.substringsBetween("[one], [two], [three]", null, "]"); 
     assertNull(results); 
     results = StringUtils.substringsBetween("[one], [two], [three]", "", ""); 
     assertNull(results); 
     results = StringUtils.substringsBetween(null, "[", "]"); 
     assertNull(results); 
     results = StringUtils.substringsBetween("", "[", "]"); 
     assertEquals(0, results.length); 
 }
@Test
public void testMid_String762() { 
     assertSame(null, StringUtils.mid(null, -1, 0)); 
     assertSame(null, StringUtils.mid(null, 0, -1)); 
     assertSame(null, StringUtils.mid(null, 3, 0)); 
     assertSame(null, StringUtils.mid(null, 3, 2)); 
     assertEquals("", StringUtils.mid("", 0, -1)); 
     assertEquals("", StringUtils.mid("", 0, 0)); 
     assertEquals("", StringUtils.mid("", 0, 2)); 
     assertEquals("", StringUtils.mid(FOOBAR, 3, -1)); 
     assertEquals("", StringUtils.mid(FOOBAR, 3, 0)); 
     assertEquals("b", StringUtils.mid(FOOBAR, 3, 1)); 
     assertEquals(FOO, StringUtils.mid(FOOBAR, 0, 3)); 
     assertEquals(BAR, StringUtils.mid(FOOBAR, 3, 3)); 
     assertEquals(FOOBAR, StringUtils.mid(FOOBAR, 0, 80)); 
     assertEquals(BAR, StringUtils.mid(FOOBAR, 3, 80)); 
     assertEquals("", StringUtils.mid(FOOBAR, 9, 3)); 
     assertEquals(FOO, StringUtils.mid(FOOBAR, -1, 3)); 
 }
@Test
public void testSubstringBefore_StringString790() { 
     assertEquals("foo", StringUtils.substringBefore("fooXXbarXXbaz", "XX")); 
     assertEquals(null, StringUtils.substringBefore(null, null)); 
     assertEquals(null, StringUtils.substringBefore(null, "")); 
     assertEquals(null, StringUtils.substringBefore(null, "XX")); 
     assertEquals("", StringUtils.substringBefore("", null)); 
     assertEquals("", StringUtils.substringBefore("", "")); 
     assertEquals("", StringUtils.substringBefore("", "XX")); 
     assertEquals("foo", StringUtils.substringBefore("foo", null)); 
     assertEquals("foo", StringUtils.substringBefore("foo", "b")); 
     assertEquals("f", StringUtils.substringBefore("foot", "o")); 
     assertEquals("", StringUtils.substringBefore("abc", "a")); 
     assertEquals("a", StringUtils.substringBefore("abcba", "b")); 
     assertEquals("ab", StringUtils.substringBefore("abc", "c")); 
     assertEquals("", StringUtils.substringBefore("abc", "")); 
 }
@Test
public void testSubstringsBetween_StringStringString802() { 
     String[] results = StringUtils.substringsBetween("[one], [two], [three]", "[", "]"); 
     assertEquals(3, results.length); 
     assertEquals("one", results[0]); 
     assertEquals("two", results[1]); 
     assertEquals("three", results[2]); 
     results = StringUtils.substringsBetween("[one], [two], three", "[", "]"); 
     assertEquals(2, results.length); 
     assertEquals("one", results[0]); 
     assertEquals("two", results[1]); 
     results = StringUtils.substringsBetween("[one], [two], three]", "[", "]"); 
     assertEquals(2, results.length); 
     assertEquals("one", results[0]); 
     assertEquals("two", results[1]); 
     results = StringUtils.substringsBetween("[one], two], three]", "[", "]"); 
     assertEquals(1, results.length); 
     assertEquals("one", results[0]); 
     results = StringUtils.substringsBetween("one], two], [three]", "[", "]"); 
     assertEquals(1, results.length); 
     assertEquals("three", results[0]); 
     results = StringUtils.substringsBetween("aabhellobabnonba", "ab", "ba"); 
     assertEquals(1, results.length); 
     assertEquals("hello", results[0]); 
     results = StringUtils.substringsBetween("one, two, three", "[", "]"); 
     assertNull(results); 
     results = StringUtils.substringsBetween("[one, two, three", "[", "]"); 
     assertNull(results); 
     results = StringUtils.substringsBetween("one, two, three]", "[", "]"); 
     assertNull(results); 
     results = StringUtils.substringsBetween("[one], [two], [three]", "[", null); 
     assertNull(results); 
     results = StringUtils.substringsBetween("[one], [two], [three]", null, "]"); 
     assertNull(results); 
     results = StringUtils.substringsBetween("[one], [two], [three]", "", ""); 
     assertNull(results); 
     results = StringUtils.substringsBetween(null, "[", "]"); 
     assertNull(results); 
     results = StringUtils.substringsBetween("", "[", "]"); 
     assertEquals(0, results.length); 
 }
@Test
public void testSubstringBetween_StringStringString934() { 
     assertEquals(null, StringUtils.substringBetween(null, "", "")); 
     assertEquals(null, StringUtils.substringBetween("", null, "")); 
     assertEquals(null, StringUtils.substringBetween("", "", null)); 
     assertEquals("", StringUtils.substringBetween("", "", "")); 
     assertEquals("", StringUtils.substringBetween("foo", "", "")); 
     assertEquals(null, StringUtils.substringBetween("foo", "", "]")); 
     assertEquals(null, StringUtils.substringBetween("foo", "[", "]")); 
     assertEquals("", StringUtils.substringBetween("    ", " ", "  ")); 
     assertEquals("bar", StringUtils.substringBetween("<foo>bar</foo>", "<foo>", "</foo>")); 
 }
@Test
public void testCountMatches_String958() { 
     assertEquals(0, StringUtils.countMatches(null, null)); 
     assertEquals(0, StringUtils.countMatches("blah", null)); 
     assertEquals(0, StringUtils.countMatches(null, "DD")); 
     assertEquals(0, StringUtils.countMatches("x", "")); 
     assertEquals(0, StringUtils.countMatches("", "")); 
     assertEquals(3, StringUtils.countMatches("one long someone sentence of one", "one")); 
     assertEquals(0, StringUtils.countMatches("one long someone sentence of one", "two")); 
     assertEquals(4, StringUtils.countMatches("oooooooooooo", "ooo")); 
 }
@Test
public void testSubstringBetween_StringStringString979() { 
     assertEquals(null, StringUtils.substringBetween(null, "", "")); 
     assertEquals(null, StringUtils.substringBetween("", null, "")); 
     assertEquals(null, StringUtils.substringBetween("", "", null)); 
     assertEquals("", StringUtils.substringBetween("", "", "")); 
     assertEquals("", StringUtils.substringBetween("foo", "", "")); 
     assertEquals(null, StringUtils.substringBetween("foo", "", "]")); 
     assertEquals(null, StringUtils.substringBetween("foo", "[", "]")); 
     assertEquals("", StringUtils.substringBetween("    ", " ", "  ")); 
     assertEquals("bar", StringUtils.substringBetween("<foo>bar</foo>", "<foo>", "</foo>")); 
 }
@Test
public void testMid_String1144() { 
     assertSame(null, StringUtils.mid(null, -1, 0)); 
     assertSame(null, StringUtils.mid(null, 0, -1)); 
     assertSame(null, StringUtils.mid(null, 3, 0)); 
     assertSame(null, StringUtils.mid(null, 3, 2)); 
     assertEquals("", StringUtils.mid("", 0, -1)); 
     assertEquals("", StringUtils.mid("", 0, 0)); 
     assertEquals("", StringUtils.mid("", 0, 2)); 
     assertEquals("", StringUtils.mid(FOOBAR, 3, -1)); 
     assertEquals("", StringUtils.mid(FOOBAR, 3, 0)); 
     assertEquals("b", StringUtils.mid(FOOBAR, 3, 1)); 
     assertEquals(FOO, StringUtils.mid(FOOBAR, 0, 3)); 
     assertEquals(BAR, StringUtils.mid(FOOBAR, 3, 3)); 
     assertEquals(FOOBAR, StringUtils.mid(FOOBAR, 0, 80)); 
     assertEquals(BAR, StringUtils.mid(FOOBAR, 3, 80)); 
     assertEquals("", StringUtils.mid(FOOBAR, 9, 3)); 
     assertEquals(FOO, StringUtils.mid(FOOBAR, -1, 3)); 
 }
@Test
public void testSubstringBetween_StringStringString1308() { 
     assertEquals(null, StringUtils.substringBetween(null, "", "")); 
     assertEquals(null, StringUtils.substringBetween("", null, "")); 
     assertEquals(null, StringUtils.substringBetween("", "", null)); 
     assertEquals("", StringUtils.substringBetween("", "", "")); 
     assertEquals("", StringUtils.substringBetween("foo", "", "")); 
     assertEquals(null, StringUtils.substringBetween("foo", "", "]")); 
     assertEquals(null, StringUtils.substringBetween("foo", "[", "]")); 
     assertEquals("", StringUtils.substringBetween("    ", " ", "  ")); 
     assertEquals("bar", StringUtils.substringBetween("<foo>bar</foo>", "<foo>", "</foo>")); 
 }
@Test
public void testLeft_String1329() { 
     assertSame(null, StringUtils.left(null, -1)); 
     assertSame(null, StringUtils.left(null, 0)); 
     assertSame(null, StringUtils.left(null, 2)); 
     assertEquals("", StringUtils.left("", -1)); 
     assertEquals("", StringUtils.left("", 0)); 
     assertEquals("", StringUtils.left("", 2)); 
     assertEquals("", StringUtils.left(FOOBAR, -1)); 
     assertEquals("", StringUtils.left(FOOBAR, 0)); 
     assertEquals(FOO, StringUtils.left(FOOBAR, 3)); 
     assertSame(FOOBAR, StringUtils.left(FOOBAR, 80)); 
 }
@Test
public void testLeft_String1506() { 
     assertSame(null, StringUtils.left(null, -1)); 
     assertSame(null, StringUtils.left(null, 0)); 
     assertSame(null, StringUtils.left(null, 2)); 
     assertEquals("", StringUtils.left("", -1)); 
     assertEquals("", StringUtils.left("", 0)); 
     assertEquals("", StringUtils.left("", 2)); 
     assertEquals("", StringUtils.left(FOOBAR, -1)); 
     assertEquals("", StringUtils.left(FOOBAR, 0)); 
     assertEquals(FOO, StringUtils.left(FOOBAR, 3)); 
     assertSame(FOOBAR, StringUtils.left(FOOBAR, 80)); 
 }
@Test
public void testSubstringBeforeLast_StringString1538() { 
     assertEquals("fooXXbar", StringUtils.substringBeforeLast("fooXXbarXXbaz", "XX")); 
     assertEquals(null, StringUtils.substringBeforeLast(null, null)); 
     assertEquals(null, StringUtils.substringBeforeLast(null, "")); 
     assertEquals(null, StringUtils.substringBeforeLast(null, "XX")); 
     assertEquals("", StringUtils.substringBeforeLast("", null)); 
     assertEquals("", StringUtils.substringBeforeLast("", "")); 
     assertEquals("", StringUtils.substringBeforeLast("", "XX")); 
     assertEquals("foo", StringUtils.substringBeforeLast("foo", null)); 
     assertEquals("foo", StringUtils.substringBeforeLast("foo", "b")); 
     assertEquals("fo", StringUtils.substringBeforeLast("foo", "o")); 
     assertEquals("abc\r\n", StringUtils.substringBeforeLast("abc\r\n", "d")); 
     assertEquals("abc", StringUtils.substringBeforeLast("abcdabc", "d")); 
     assertEquals("abcdabc", StringUtils.substringBeforeLast("abcdabcd", "d")); 
     assertEquals("a", StringUtils.substringBeforeLast("abc", "b")); 
     assertEquals("abc ", StringUtils.substringBeforeLast("abc \n", "\n")); 
     assertEquals("a", StringUtils.substringBeforeLast("a", null)); 
     assertEquals("a", StringUtils.substringBeforeLast("a", "")); 
     assertEquals("", StringUtils.substringBeforeLast("a", "a")); 
 }
@Test
public void testSubstring_StringInt1567() { 
     assertEquals(null, StringUtils.substring(null, 0)); 
     assertEquals("", StringUtils.substring("", 0)); 
     assertEquals("", StringUtils.substring("", 2)); 
     assertEquals("", StringUtils.substring(SENTENCE, 80)); 
     assertEquals(BAZ, StringUtils.substring(SENTENCE, 8)); 
     assertEquals(BAZ, StringUtils.substring(SENTENCE, -3)); 
     assertEquals(SENTENCE, StringUtils.substring(SENTENCE, 0)); 
     assertEquals("abc", StringUtils.substring("abc", -4)); 
     assertEquals("abc", StringUtils.substring("abc", -3)); 
     assertEquals("bc", StringUtils.substring("abc", -2)); 
     assertEquals("c", StringUtils.substring("abc", -1)); 
     assertEquals("abc", StringUtils.substring("abc", 0)); 
     assertEquals("bc", StringUtils.substring("abc", 1)); 
     assertEquals("c", StringUtils.substring("abc", 2)); 
     assertEquals("", StringUtils.substring("abc", 3)); 
     assertEquals("", StringUtils.substring("abc", 4)); 
 }
@Test
public void testMid_String1759() { 
     assertSame(null, StringUtils.mid(null, -1, 0)); 
     assertSame(null, StringUtils.mid(null, 0, -1)); 
     assertSame(null, StringUtils.mid(null, 3, 0)); 
     assertSame(null, StringUtils.mid(null, 3, 2)); 
     assertEquals("", StringUtils.mid("", 0, -1)); 
     assertEquals("", StringUtils.mid("", 0, 0)); 
     assertEquals("", StringUtils.mid("", 0, 2)); 
     assertEquals("", StringUtils.mid(FOOBAR, 3, -1)); 
     assertEquals("", StringUtils.mid(FOOBAR, 3, 0)); 
     assertEquals("b", StringUtils.mid(FOOBAR, 3, 1)); 
     assertEquals(FOO, StringUtils.mid(FOOBAR, 0, 3)); 
     assertEquals(BAR, StringUtils.mid(FOOBAR, 3, 3)); 
     assertEquals(FOOBAR, StringUtils.mid(FOOBAR, 0, 80)); 
     assertEquals(BAR, StringUtils.mid(FOOBAR, 3, 80)); 
     assertEquals("", StringUtils.mid(FOOBAR, 9, 3)); 
     assertEquals(FOO, StringUtils.mid(FOOBAR, -1, 3)); 
 }
@Test
public void testCountMatches_String1804() { 
     assertEquals(0, StringUtils.countMatches(null, null)); 
     assertEquals(0, StringUtils.countMatches("blah", null)); 
     assertEquals(0, StringUtils.countMatches(null, "DD")); 
     assertEquals(0, StringUtils.countMatches("x", "")); 
     assertEquals(0, StringUtils.countMatches("", "")); 
     assertEquals(3, StringUtils.countMatches("one long someone sentence of one", "one")); 
     assertEquals(0, StringUtils.countMatches("one long someone sentence of one", "two")); 
     assertEquals(4, StringUtils.countMatches("oooooooooooo", "ooo")); 
 }
@Test
public void testMid_String1832() { 
     assertSame(null, StringUtils.mid(null, -1, 0)); 
     assertSame(null, StringUtils.mid(null, 0, -1)); 
     assertSame(null, StringUtils.mid(null, 3, 0)); 
     assertSame(null, StringUtils.mid(null, 3, 2)); 
     assertEquals("", StringUtils.mid("", 0, -1)); 
     assertEquals("", StringUtils.mid("", 0, 0)); 
     assertEquals("", StringUtils.mid("", 0, 2)); 
     assertEquals("", StringUtils.mid(FOOBAR, 3, -1)); 
     assertEquals("", StringUtils.mid(FOOBAR, 3, 0)); 
     assertEquals("b", StringUtils.mid(FOOBAR, 3, 1)); 
     assertEquals(FOO, StringUtils.mid(FOOBAR, 0, 3)); 
     assertEquals(BAR, StringUtils.mid(FOOBAR, 3, 3)); 
     assertEquals(FOOBAR, StringUtils.mid(FOOBAR, 0, 80)); 
     assertEquals(BAR, StringUtils.mid(FOOBAR, 3, 80)); 
     assertEquals("", StringUtils.mid(FOOBAR, 9, 3)); 
     assertEquals(FOO, StringUtils.mid(FOOBAR, -1, 3)); 
 }
@Test
public void testSubstring_StringIntInt1891() { 
     assertEquals(null, StringUtils.substring(null, 0, 0)); 
     assertEquals(null, StringUtils.substring(null, 1, 2)); 
     assertEquals("", StringUtils.substring("", 0, 0)); 
     assertEquals("", StringUtils.substring("", 1, 2)); 
     assertEquals("", StringUtils.substring("", -2, -1)); 
     assertEquals("", StringUtils.substring(SENTENCE, 8, 6)); 
     assertEquals(FOO, StringUtils.substring(SENTENCE, 0, 3)); 
     assertEquals("o", StringUtils.substring(SENTENCE, -9, 3)); 
     assertEquals(FOO, StringUtils.substring(SENTENCE, 0, -8)); 
     assertEquals("o", StringUtils.substring(SENTENCE, -9, -8)); 
     assertEquals(SENTENCE, StringUtils.substring(SENTENCE, 0, 80)); 
     assertEquals("", StringUtils.substring(SENTENCE, 2, 2)); 
     assertEquals("b", StringUtils.substring("abc", -2, -1)); 
 }
@Test
public void testSubstringBefore_StringString1907() { 
     assertEquals("foo", StringUtils.substringBefore("fooXXbarXXbaz", "XX")); 
     assertEquals(null, StringUtils.substringBefore(null, null)); 
     assertEquals(null, StringUtils.substringBefore(null, "")); 
     assertEquals(null, StringUtils.substringBefore(null, "XX")); 
     assertEquals("", StringUtils.substringBefore("", null)); 
     assertEquals("", StringUtils.substringBefore("", "")); 
     assertEquals("", StringUtils.substringBefore("", "XX")); 
     assertEquals("foo", StringUtils.substringBefore("foo", null)); 
     assertEquals("foo", StringUtils.substringBefore("foo", "b")); 
     assertEquals("f", StringUtils.substringBefore("foot", "o")); 
     assertEquals("", StringUtils.substringBefore("abc", "a")); 
     assertEquals("a", StringUtils.substringBefore("abcba", "b")); 
     assertEquals("ab", StringUtils.substringBefore("abc", "c")); 
     assertEquals("", StringUtils.substringBefore("abc", "")); 
 }
@Test
public void testSubstring_StringInt2066() { 
     assertEquals(null, StringUtils.substring(null, 0)); 
     assertEquals("", StringUtils.substring("", 0)); 
     assertEquals("", StringUtils.substring("", 2)); 
     assertEquals("", StringUtils.substring(SENTENCE, 80)); 
     assertEquals(BAZ, StringUtils.substring(SENTENCE, 8)); 
     assertEquals(BAZ, StringUtils.substring(SENTENCE, -3)); 
     assertEquals(SENTENCE, StringUtils.substring(SENTENCE, 0)); 
     assertEquals("abc", StringUtils.substring("abc", -4)); 
     assertEquals("abc", StringUtils.substring("abc", -3)); 
     assertEquals("bc", StringUtils.substring("abc", -2)); 
     assertEquals("c", StringUtils.substring("abc", -1)); 
     assertEquals("abc", StringUtils.substring("abc", 0)); 
     assertEquals("bc", StringUtils.substring("abc", 1)); 
     assertEquals("c", StringUtils.substring("abc", 2)); 
     assertEquals("", StringUtils.substring("abc", 3)); 
     assertEquals("", StringUtils.substring("abc", 4)); 
 }
@Test
public void testSubstring_StringIntInt2076() { 
     assertEquals(null, StringUtils.substring(null, 0, 0)); 
     assertEquals(null, StringUtils.substring(null, 1, 2)); 
     assertEquals("", StringUtils.substring("", 0, 0)); 
     assertEquals("", StringUtils.substring("", 1, 2)); 
     assertEquals("", StringUtils.substring("", -2, -1)); 
     assertEquals("", StringUtils.substring(SENTENCE, 8, 6)); 
     assertEquals(FOO, StringUtils.substring(SENTENCE, 0, 3)); 
     assertEquals("o", StringUtils.substring(SENTENCE, -9, 3)); 
     assertEquals(FOO, StringUtils.substring(SENTENCE, 0, -8)); 
     assertEquals("o", StringUtils.substring(SENTENCE, -9, -8)); 
     assertEquals(SENTENCE, StringUtils.substring(SENTENCE, 0, 80)); 
     assertEquals("", StringUtils.substring(SENTENCE, 2, 2)); 
     assertEquals("b", StringUtils.substring("abc", -2, -1)); 
 }
@Test
public void testSubstringAfter_StringString2094() { 
     assertEquals("barXXbaz", StringUtils.substringAfter("fooXXbarXXbaz", "XX")); 
     assertEquals(null, StringUtils.substringAfter(null, null)); 
     assertEquals(null, StringUtils.substringAfter(null, "")); 
     assertEquals(null, StringUtils.substringAfter(null, "XX")); 
     assertEquals("", StringUtils.substringAfter("", null)); 
     assertEquals("", StringUtils.substringAfter("", "")); 
     assertEquals("", StringUtils.substringAfter("", "XX")); 
     assertEquals("", StringUtils.substringAfter("foo", null)); 
     assertEquals("ot", StringUtils.substringAfter("foot", "o")); 
     assertEquals("bc", StringUtils.substringAfter("abc", "a")); 
     assertEquals("cba", StringUtils.substringAfter("abcba", "b")); 
     assertEquals("", StringUtils.substringAfter("abc", "c")); 
     assertEquals("abc", StringUtils.substringAfter("abc", "")); 
     assertEquals("", StringUtils.substringAfter("abc", "d")); 
 }
@Test
public void testCountMatches_String2132() { 
     assertEquals(0, StringUtils.countMatches(null, null)); 
     assertEquals(0, StringUtils.countMatches("blah", null)); 
     assertEquals(0, StringUtils.countMatches(null, "DD")); 
     assertEquals(0, StringUtils.countMatches("x", "")); 
     assertEquals(0, StringUtils.countMatches("", "")); 
     assertEquals(3, StringUtils.countMatches("one long someone sentence of one", "one")); 
     assertEquals(0, StringUtils.countMatches("one long someone sentence of one", "two")); 
     assertEquals(4, StringUtils.countMatches("oooooooooooo", "ooo")); 
 }
@Test
public void testSubstringBeforeLast_StringString2251() { 
     assertEquals("fooXXbar", StringUtils.substringBeforeLast("fooXXbarXXbaz", "XX")); 
     assertEquals(null, StringUtils.substringBeforeLast(null, null)); 
     assertEquals(null, StringUtils.substringBeforeLast(null, "")); 
     assertEquals(null, StringUtils.substringBeforeLast(null, "XX")); 
     assertEquals("", StringUtils.substringBeforeLast("", null)); 
     assertEquals("", StringUtils.substringBeforeLast("", "")); 
     assertEquals("", StringUtils.substringBeforeLast("", "XX")); 
     assertEquals("foo", StringUtils.substringBeforeLast("foo", null)); 
     assertEquals("foo", StringUtils.substringBeforeLast("foo", "b")); 
     assertEquals("fo", StringUtils.substringBeforeLast("foo", "o")); 
     assertEquals("abc\r\n", StringUtils.substringBeforeLast("abc\r\n", "d")); 
     assertEquals("abc", StringUtils.substringBeforeLast("abcdabc", "d")); 
     assertEquals("abcdabc", StringUtils.substringBeforeLast("abcdabcd", "d")); 
     assertEquals("a", StringUtils.substringBeforeLast("abc", "b")); 
     assertEquals("abc ", StringUtils.substringBeforeLast("abc \n", "\n")); 
     assertEquals("a", StringUtils.substringBeforeLast("a", null)); 
     assertEquals("a", StringUtils.substringBeforeLast("a", "")); 
     assertEquals("", StringUtils.substringBeforeLast("a", "a")); 
 }
@Test
public void testSubstringAfterLast_StringString2252() { 
     assertEquals("baz", StringUtils.substringAfterLast("fooXXbarXXbaz", "XX")); 
     assertEquals(null, StringUtils.substringAfterLast(null, null)); 
     assertEquals(null, StringUtils.substringAfterLast(null, "")); 
     assertEquals(null, StringUtils.substringAfterLast(null, "XX")); 
     assertEquals("", StringUtils.substringAfterLast("", null)); 
     assertEquals("", StringUtils.substringAfterLast("", "")); 
     assertEquals("", StringUtils.substringAfterLast("", "a")); 
     assertEquals("", StringUtils.substringAfterLast("foo", null)); 
     assertEquals("", StringUtils.substringAfterLast("foo", "b")); 
     assertEquals("t", StringUtils.substringAfterLast("foot", "o")); 
     assertEquals("bc", StringUtils.substringAfterLast("abc", "a")); 
     assertEquals("a", StringUtils.substringAfterLast("abcba", "b")); 
     assertEquals("", StringUtils.substringAfterLast("abc", "c")); 
     assertEquals("", StringUtils.substringAfterLast("", "d")); 
     assertEquals("", StringUtils.substringAfterLast("abc", "")); 
 }
@Test
public void testMid_String2323() { 
     assertSame(null, StringUtils.mid(null, -1, 0)); 
     assertSame(null, StringUtils.mid(null, 0, -1)); 
     assertSame(null, StringUtils.mid(null, 3, 0)); 
     assertSame(null, StringUtils.mid(null, 3, 2)); 
     assertEquals("", StringUtils.mid("", 0, -1)); 
     assertEquals("", StringUtils.mid("", 0, 0)); 
     assertEquals("", StringUtils.mid("", 0, 2)); 
     assertEquals("", StringUtils.mid(FOOBAR, 3, -1)); 
     assertEquals("", StringUtils.mid(FOOBAR, 3, 0)); 
     assertEquals("b", StringUtils.mid(FOOBAR, 3, 1)); 
     assertEquals(FOO, StringUtils.mid(FOOBAR, 0, 3)); 
     assertEquals(BAR, StringUtils.mid(FOOBAR, 3, 3)); 
     assertEquals(FOOBAR, StringUtils.mid(FOOBAR, 0, 80)); 
     assertEquals(BAR, StringUtils.mid(FOOBAR, 3, 80)); 
     assertEquals("", StringUtils.mid(FOOBAR, 9, 3)); 
     assertEquals(FOO, StringUtils.mid(FOOBAR, -1, 3)); 
 }
@Test
public void testSubstringsBetween_StringStringString2433() { 
     String[] results = StringUtils.substringsBetween("[one], [two], [three]", "[", "]"); 
     assertEquals(3, results.length); 
     assertEquals("one", results[0]); 
     assertEquals("two", results[1]); 
     assertEquals("three", results[2]); 
     results = StringUtils.substringsBetween("[one], [two], three", "[", "]"); 
     assertEquals(2, results.length); 
     assertEquals("one", results[0]); 
     assertEquals("two", results[1]); 
     results = StringUtils.substringsBetween("[one], [two], three]", "[", "]"); 
     assertEquals(2, results.length); 
     assertEquals("one", results[0]); 
     assertEquals("two", results[1]); 
     results = StringUtils.substringsBetween("[one], two], three]", "[", "]"); 
     assertEquals(1, results.length); 
     assertEquals("one", results[0]); 
     results = StringUtils.substringsBetween("one], two], [three]", "[", "]"); 
     assertEquals(1, results.length); 
     assertEquals("three", results[0]); 
     results = StringUtils.substringsBetween("aabhellobabnonba", "ab", "ba"); 
     assertEquals(1, results.length); 
     assertEquals("hello", results[0]); 
     results = StringUtils.substringsBetween("one, two, three", "[", "]"); 
     assertNull(results); 
     results = StringUtils.substringsBetween("[one, two, three", "[", "]"); 
     assertNull(results); 
     results = StringUtils.substringsBetween("one, two, three]", "[", "]"); 
     assertNull(results); 
     results = StringUtils.substringsBetween("[one], [two], [three]", "[", null); 
     assertNull(results); 
     results = StringUtils.substringsBetween("[one], [two], [three]", null, "]"); 
     assertNull(results); 
     results = StringUtils.substringsBetween("[one], [two], [three]", "", ""); 
     assertNull(results); 
     results = StringUtils.substringsBetween(null, "[", "]"); 
     assertNull(results); 
     results = StringUtils.substringsBetween("", "[", "]"); 
     assertEquals(0, results.length); 
 }
@Test
public void testSubstringBefore_StringString2488() { 
     assertEquals("foo", StringUtils.substringBefore("fooXXbarXXbaz", "XX")); 
     assertEquals(null, StringUtils.substringBefore(null, null)); 
     assertEquals(null, StringUtils.substringBefore(null, "")); 
     assertEquals(null, StringUtils.substringBefore(null, "XX")); 
     assertEquals("", StringUtils.substringBefore("", null)); 
     assertEquals("", StringUtils.substringBefore("", "")); 
     assertEquals("", StringUtils.substringBefore("", "XX")); 
     assertEquals("foo", StringUtils.substringBefore("foo", null)); 
     assertEquals("foo", StringUtils.substringBefore("foo", "b")); 
     assertEquals("f", StringUtils.substringBefore("foot", "o")); 
     assertEquals("", StringUtils.substringBefore("abc", "a")); 
     assertEquals("a", StringUtils.substringBefore("abcba", "b")); 
     assertEquals("ab", StringUtils.substringBefore("abc", "c")); 
     assertEquals("", StringUtils.substringBefore("abc", "")); 
 }
@Test
public void testCountMatches_String2506() { 
     assertEquals(0, StringUtils.countMatches(null, null)); 
     assertEquals(0, StringUtils.countMatches("blah", null)); 
     assertEquals(0, StringUtils.countMatches(null, "DD")); 
     assertEquals(0, StringUtils.countMatches("x", "")); 
     assertEquals(0, StringUtils.countMatches("", "")); 
     assertEquals(3, StringUtils.countMatches("one long someone sentence of one", "one")); 
     assertEquals(0, StringUtils.countMatches("one long someone sentence of one", "two")); 
     assertEquals(4, StringUtils.countMatches("oooooooooooo", "ooo")); 
 }
@Test
public void testSubstringsBetween_StringStringString2538() { 
     String[] results = StringUtils.substringsBetween("[one], [two], [three]", "[", "]"); 
     assertEquals(3, results.length); 
     assertEquals("one", results[0]); 
     assertEquals("two", results[1]); 
     assertEquals("three", results[2]); 
     results = StringUtils.substringsBetween("[one], [two], three", "[", "]"); 
     assertEquals(2, results.length); 
     assertEquals("one", results[0]); 
     assertEquals("two", results[1]); 
     results = StringUtils.substringsBetween("[one], [two], three]", "[", "]"); 
     assertEquals(2, results.length); 
     assertEquals("one", results[0]); 
     assertEquals("two", results[1]); 
     results = StringUtils.substringsBetween("[one], two], three]", "[", "]"); 
     assertEquals(1, results.length); 
     assertEquals("one", results[0]); 
     results = StringUtils.substringsBetween("one], two], [three]", "[", "]"); 
     assertEquals(1, results.length); 
     assertEquals("three", results[0]); 
     results = StringUtils.substringsBetween("aabhellobabnonba", "ab", "ba"); 
     assertEquals(1, results.length); 
     assertEquals("hello", results[0]); 
     results = StringUtils.substringsBetween("one, two, three", "[", "]"); 
     assertNull(results); 
     results = StringUtils.substringsBetween("[one, two, three", "[", "]"); 
     assertNull(results); 
     results = StringUtils.substringsBetween("one, two, three]", "[", "]"); 
     assertNull(results); 
     results = StringUtils.substringsBetween("[one], [two], [three]", "[", null); 
     assertNull(results); 
     results = StringUtils.substringsBetween("[one], [two], [three]", null, "]"); 
     assertNull(results); 
     results = StringUtils.substringsBetween("[one], [two], [three]", "", ""); 
     assertNull(results); 
     results = StringUtils.substringsBetween(null, "[", "]"); 
     assertNull(results); 
     results = StringUtils.substringsBetween("", "[", "]"); 
     assertEquals(0, results.length); 
 }
@Test
public void testSubstringsBetween_StringStringString2589() { 
     String[] results = StringUtils.substringsBetween("[one], [two], [three]", "[", "]"); 
     assertEquals(3, results.length); 
     assertEquals("one", results[0]); 
     assertEquals("two", results[1]); 
     assertEquals("three", results[2]); 
     results = StringUtils.substringsBetween("[one], [two], three", "[", "]"); 
     assertEquals(2, results.length); 
     assertEquals("one", results[0]); 
     assertEquals("two", results[1]); 
     results = StringUtils.substringsBetween("[one], [two], three]", "[", "]"); 
     assertEquals(2, results.length); 
     assertEquals("one", results[0]); 
     assertEquals("two", results[1]); 
     results = StringUtils.substringsBetween("[one], two], three]", "[", "]"); 
     assertEquals(1, results.length); 
     assertEquals("one", results[0]); 
     results = StringUtils.substringsBetween("one], two], [three]", "[", "]"); 
     assertEquals(1, results.length); 
     assertEquals("three", results[0]); 
     results = StringUtils.substringsBetween("aabhellobabnonba", "ab", "ba"); 
     assertEquals(1, results.length); 
     assertEquals("hello", results[0]); 
     results = StringUtils.substringsBetween("one, two, three", "[", "]"); 
     assertNull(results); 
     results = StringUtils.substringsBetween("[one, two, three", "[", "]"); 
     assertNull(results); 
     results = StringUtils.substringsBetween("one, two, three]", "[", "]"); 
     assertNull(results); 
     results = StringUtils.substringsBetween("[one], [two], [three]", "[", null); 
     assertNull(results); 
     results = StringUtils.substringsBetween("[one], [two], [three]", null, "]"); 
     assertNull(results); 
     results = StringUtils.substringsBetween("[one], [two], [three]", "", ""); 
     assertNull(results); 
     results = StringUtils.substringsBetween(null, "[", "]"); 
     assertNull(results); 
     results = StringUtils.substringsBetween("", "[", "]"); 
     assertEquals(0, results.length); 
 }
@Test
public void testSubstringBefore_StringString2606() { 
     assertEquals("foo", StringUtils.substringBefore("fooXXbarXXbaz", "XX")); 
     assertEquals(null, StringUtils.substringBefore(null, null)); 
     assertEquals(null, StringUtils.substringBefore(null, "")); 
     assertEquals(null, StringUtils.substringBefore(null, "XX")); 
     assertEquals("", StringUtils.substringBefore("", null)); 
     assertEquals("", StringUtils.substringBefore("", "")); 
     assertEquals("", StringUtils.substringBefore("", "XX")); 
     assertEquals("foo", StringUtils.substringBefore("foo", null)); 
     assertEquals("foo", StringUtils.substringBefore("foo", "b")); 
     assertEquals("f", StringUtils.substringBefore("foot", "o")); 
     assertEquals("", StringUtils.substringBefore("abc", "a")); 
     assertEquals("a", StringUtils.substringBefore("abcba", "b")); 
     assertEquals("ab", StringUtils.substringBefore("abc", "c")); 
     assertEquals("", StringUtils.substringBefore("abc", "")); 
 }
@Test
public void testSubstring_StringIntInt2630() { 
     assertEquals(null, StringUtils.substring(null, 0, 0)); 
     assertEquals(null, StringUtils.substring(null, 1, 2)); 
     assertEquals("", StringUtils.substring("", 0, 0)); 
     assertEquals("", StringUtils.substring("", 1, 2)); 
     assertEquals("", StringUtils.substring("", -2, -1)); 
     assertEquals("", StringUtils.substring(SENTENCE, 8, 6)); 
     assertEquals(FOO, StringUtils.substring(SENTENCE, 0, 3)); 
     assertEquals("o", StringUtils.substring(SENTENCE, -9, 3)); 
     assertEquals(FOO, StringUtils.substring(SENTENCE, 0, -8)); 
     assertEquals("o", StringUtils.substring(SENTENCE, -9, -8)); 
     assertEquals(SENTENCE, StringUtils.substring(SENTENCE, 0, 80)); 
     assertEquals("", StringUtils.substring(SENTENCE, 2, 2)); 
     assertEquals("b", StringUtils.substring("abc", -2, -1)); 
 }
@Test
public void testSubstring_StringInt2644() { 
     assertEquals(null, StringUtils.substring(null, 0)); 
     assertEquals("", StringUtils.substring("", 0)); 
     assertEquals("", StringUtils.substring("", 2)); 
     assertEquals("", StringUtils.substring(SENTENCE, 80)); 
     assertEquals(BAZ, StringUtils.substring(SENTENCE, 8)); 
     assertEquals(BAZ, StringUtils.substring(SENTENCE, -3)); 
     assertEquals(SENTENCE, StringUtils.substring(SENTENCE, 0)); 
     assertEquals("abc", StringUtils.substring("abc", -4)); 
     assertEquals("abc", StringUtils.substring("abc", -3)); 
     assertEquals("bc", StringUtils.substring("abc", -2)); 
     assertEquals("c", StringUtils.substring("abc", -1)); 
     assertEquals("abc", StringUtils.substring("abc", 0)); 
     assertEquals("bc", StringUtils.substring("abc", 1)); 
     assertEquals("c", StringUtils.substring("abc", 2)); 
     assertEquals("", StringUtils.substring("abc", 3)); 
     assertEquals("", StringUtils.substring("abc", 4)); 
 }
@Test
public void testCountMatches_String2676() { 
     assertEquals(0, StringUtils.countMatches(null, null)); 
     assertEquals(0, StringUtils.countMatches("blah", null)); 
     assertEquals(0, StringUtils.countMatches(null, "DD")); 
     assertEquals(0, StringUtils.countMatches("x", "")); 
     assertEquals(0, StringUtils.countMatches("", "")); 
     assertEquals(3, StringUtils.countMatches("one long someone sentence of one", "one")); 
     assertEquals(0, StringUtils.countMatches("one long someone sentence of one", "two")); 
     assertEquals(4, StringUtils.countMatches("oooooooooooo", "ooo")); 
 }
@Test
public void testRight_String2688() { 
     assertSame(null, StringUtils.right(null, -1)); 
     assertSame(null, StringUtils.right(null, 0)); 
     assertSame(null, StringUtils.right(null, 2)); 
     assertEquals("", StringUtils.right("", -1)); 
     assertEquals("", StringUtils.right("", 0)); 
     assertEquals("", StringUtils.right("", 2)); 
     assertEquals("", StringUtils.right(FOOBAR, -1)); 
     assertEquals("", StringUtils.right(FOOBAR, 0)); 
     assertEquals(BAR, StringUtils.right(FOOBAR, 3)); 
     assertSame(FOOBAR, StringUtils.right(FOOBAR, 80)); 
 }
@Test
public void testMid_String2773() { 
     assertSame(null, StringUtils.mid(null, -1, 0)); 
     assertSame(null, StringUtils.mid(null, 0, -1)); 
     assertSame(null, StringUtils.mid(null, 3, 0)); 
     assertSame(null, StringUtils.mid(null, 3, 2)); 
     assertEquals("", StringUtils.mid("", 0, -1)); 
     assertEquals("", StringUtils.mid("", 0, 0)); 
     assertEquals("", StringUtils.mid("", 0, 2)); 
     assertEquals("", StringUtils.mid(FOOBAR, 3, -1)); 
     assertEquals("", StringUtils.mid(FOOBAR, 3, 0)); 
     assertEquals("b", StringUtils.mid(FOOBAR, 3, 1)); 
     assertEquals(FOO, StringUtils.mid(FOOBAR, 0, 3)); 
     assertEquals(BAR, StringUtils.mid(FOOBAR, 3, 3)); 
     assertEquals(FOOBAR, StringUtils.mid(FOOBAR, 0, 80)); 
     assertEquals(BAR, StringUtils.mid(FOOBAR, 3, 80)); 
     assertEquals("", StringUtils.mid(FOOBAR, 9, 3)); 
     assertEquals(FOO, StringUtils.mid(FOOBAR, -1, 3)); 
 }
@Test
public void testSubstring_StringInt2812() { 
     assertEquals(null, StringUtils.substring(null, 0)); 
     assertEquals("", StringUtils.substring("", 0)); 
     assertEquals("", StringUtils.substring("", 2)); 
     assertEquals("", StringUtils.substring(SENTENCE, 80)); 
     assertEquals(BAZ, StringUtils.substring(SENTENCE, 8)); 
     assertEquals(BAZ, StringUtils.substring(SENTENCE, -3)); 
     assertEquals(SENTENCE, StringUtils.substring(SENTENCE, 0)); 
     assertEquals("abc", StringUtils.substring("abc", -4)); 
     assertEquals("abc", StringUtils.substring("abc", -3)); 
     assertEquals("bc", StringUtils.substring("abc", -2)); 
     assertEquals("c", StringUtils.substring("abc", -1)); 
     assertEquals("abc", StringUtils.substring("abc", 0)); 
     assertEquals("bc", StringUtils.substring("abc", 1)); 
     assertEquals("c", StringUtils.substring("abc", 2)); 
     assertEquals("", StringUtils.substring("abc", 3)); 
     assertEquals("", StringUtils.substring("abc", 4)); 
 }
@Test
public void testCountMatches_String2882() { 
     assertEquals(0, StringUtils.countMatches(null, null)); 
     assertEquals(0, StringUtils.countMatches("blah", null)); 
     assertEquals(0, StringUtils.countMatches(null, "DD")); 
     assertEquals(0, StringUtils.countMatches("x", "")); 
     assertEquals(0, StringUtils.countMatches("", "")); 
     assertEquals(3, StringUtils.countMatches("one long someone sentence of one", "one")); 
     assertEquals(0, StringUtils.countMatches("one long someone sentence of one", "two")); 
     assertEquals(4, StringUtils.countMatches("oooooooooooo", "ooo")); 
 }
@Test
public void testSubstringBetween_StringStringString2911() { 
     assertEquals(null, StringUtils.substringBetween(null, "", "")); 
     assertEquals(null, StringUtils.substringBetween("", null, "")); 
     assertEquals(null, StringUtils.substringBetween("", "", null)); 
     assertEquals("", StringUtils.substringBetween("", "", "")); 
     assertEquals("", StringUtils.substringBetween("foo", "", "")); 
     assertEquals(null, StringUtils.substringBetween("foo", "", "]")); 
     assertEquals(null, StringUtils.substringBetween("foo", "[", "]")); 
     assertEquals("", StringUtils.substringBetween("    ", " ", "  ")); 
     assertEquals("bar", StringUtils.substringBetween("<foo>bar</foo>", "<foo>", "</foo>")); 
 }
@Test
public void testSubstringBefore_StringString3255() { 
     assertEquals("foo", StringUtils.substringBefore("fooXXbarXXbaz", "XX")); 
     assertEquals(null, StringUtils.substringBefore(null, null)); 
     assertEquals(null, StringUtils.substringBefore(null, "")); 
     assertEquals(null, StringUtils.substringBefore(null, "XX")); 
     assertEquals("", StringUtils.substringBefore("", null)); 
     assertEquals("", StringUtils.substringBefore("", "")); 
     assertEquals("", StringUtils.substringBefore("", "XX")); 
     assertEquals("foo", StringUtils.substringBefore("foo", null)); 
     assertEquals("foo", StringUtils.substringBefore("foo", "b")); 
     assertEquals("f", StringUtils.substringBefore("foot", "o")); 
     assertEquals("", StringUtils.substringBefore("abc", "a")); 
     assertEquals("a", StringUtils.substringBefore("abcba", "b")); 
     assertEquals("ab", StringUtils.substringBefore("abc", "c")); 
     assertEquals("", StringUtils.substringBefore("abc", "")); 
 }
@Test
public void testRight_String3499() { 
     assertSame(null, StringUtils.right(null, -1)); 
     assertSame(null, StringUtils.right(null, 0)); 
     assertSame(null, StringUtils.right(null, 2)); 
     assertEquals("", StringUtils.right("", -1)); 
     assertEquals("", StringUtils.right("", 0)); 
     assertEquals("", StringUtils.right("", 2)); 
     assertEquals("", StringUtils.right(FOOBAR, -1)); 
     assertEquals("", StringUtils.right(FOOBAR, 0)); 
     assertEquals(BAR, StringUtils.right(FOOBAR, 3)); 
     assertSame(FOOBAR, StringUtils.right(FOOBAR, 80)); 
 }
@Test
public void testSubstringsBetween_StringStringString3515() { 
     String[] results = StringUtils.substringsBetween("[one], [two], [three]", "[", "]"); 
     assertEquals(3, results.length); 
     assertEquals("one", results[0]); 
     assertEquals("two", results[1]); 
     assertEquals("three", results[2]); 
     results = StringUtils.substringsBetween("[one], [two], three", "[", "]"); 
     assertEquals(2, results.length); 
     assertEquals("one", results[0]); 
     assertEquals("two", results[1]); 
     results = StringUtils.substringsBetween("[one], [two], three]", "[", "]"); 
     assertEquals(2, results.length); 
     assertEquals("one", results[0]); 
     assertEquals("two", results[1]); 
     results = StringUtils.substringsBetween("[one], two], three]", "[", "]"); 
     assertEquals(1, results.length); 
     assertEquals("one", results[0]); 
     results = StringUtils.substringsBetween("one], two], [three]", "[", "]"); 
     assertEquals(1, results.length); 
     assertEquals("three", results[0]); 
     results = StringUtils.substringsBetween("aabhellobabnonba", "ab", "ba"); 
     assertEquals(1, results.length); 
     assertEquals("hello", results[0]); 
     results = StringUtils.substringsBetween("one, two, three", "[", "]"); 
     assertNull(results); 
     results = StringUtils.substringsBetween("[one, two, three", "[", "]"); 
     assertNull(results); 
     results = StringUtils.substringsBetween("one, two, three]", "[", "]"); 
     assertNull(results); 
     results = StringUtils.substringsBetween("[one], [two], [three]", "[", null); 
     assertNull(results); 
     results = StringUtils.substringsBetween("[one], [two], [three]", null, "]"); 
     assertNull(results); 
     results = StringUtils.substringsBetween("[one], [two], [three]", "", ""); 
     assertNull(results); 
     results = StringUtils.substringsBetween(null, "[", "]"); 
     assertNull(results); 
     results = StringUtils.substringsBetween("", "[", "]"); 
     assertEquals(0, results.length); 
 }
@Test
public void testCountMatches_String3546() { 
     assertEquals(0, StringUtils.countMatches(null, null)); 
     assertEquals(0, StringUtils.countMatches("blah", null)); 
     assertEquals(0, StringUtils.countMatches(null, "DD")); 
     assertEquals(0, StringUtils.countMatches("x", "")); 
     assertEquals(0, StringUtils.countMatches("", "")); 
     assertEquals(3, StringUtils.countMatches("one long someone sentence of one", "one")); 
     assertEquals(0, StringUtils.countMatches("one long someone sentence of one", "two")); 
     assertEquals(4, StringUtils.countMatches("oooooooooooo", "ooo")); 
 }
@Test
public void testSubstringBeforeLast_StringString3817() { 
     assertEquals("fooXXbar", StringUtils.substringBeforeLast("fooXXbarXXbaz", "XX")); 
     assertEquals(null, StringUtils.substringBeforeLast(null, null)); 
     assertEquals(null, StringUtils.substringBeforeLast(null, "")); 
     assertEquals(null, StringUtils.substringBeforeLast(null, "XX")); 
     assertEquals("", StringUtils.substringBeforeLast("", null)); 
     assertEquals("", StringUtils.substringBeforeLast("", "")); 
     assertEquals("", StringUtils.substringBeforeLast("", "XX")); 
     assertEquals("foo", StringUtils.substringBeforeLast("foo", null)); 
     assertEquals("foo", StringUtils.substringBeforeLast("foo", "b")); 
     assertEquals("fo", StringUtils.substringBeforeLast("foo", "o")); 
     assertEquals("abc\r\n", StringUtils.substringBeforeLast("abc\r\n", "d")); 
     assertEquals("abc", StringUtils.substringBeforeLast("abcdabc", "d")); 
     assertEquals("abcdabc", StringUtils.substringBeforeLast("abcdabcd", "d")); 
     assertEquals("a", StringUtils.substringBeforeLast("abc", "b")); 
     assertEquals("abc ", StringUtils.substringBeforeLast("abc \n", "\n")); 
     assertEquals("a", StringUtils.substringBeforeLast("a", null)); 
     assertEquals("a", StringUtils.substringBeforeLast("a", "")); 
     assertEquals("", StringUtils.substringBeforeLast("a", "a")); 
 }
@Test
public void testSubstringsBetween_StringStringString3828() { 
     String[] results = StringUtils.substringsBetween("[one], [two], [three]", "[", "]"); 
     assertEquals(3, results.length); 
     assertEquals("one", results[0]); 
     assertEquals("two", results[1]); 
     assertEquals("three", results[2]); 
     results = StringUtils.substringsBetween("[one], [two], three", "[", "]"); 
     assertEquals(2, results.length); 
     assertEquals("one", results[0]); 
     assertEquals("two", results[1]); 
     results = StringUtils.substringsBetween("[one], [two], three]", "[", "]"); 
     assertEquals(2, results.length); 
     assertEquals("one", results[0]); 
     assertEquals("two", results[1]); 
     results = StringUtils.substringsBetween("[one], two], three]", "[", "]"); 
     assertEquals(1, results.length); 
     assertEquals("one", results[0]); 
     results = StringUtils.substringsBetween("one], two], [three]", "[", "]"); 
     assertEquals(1, results.length); 
     assertEquals("three", results[0]); 
     results = StringUtils.substringsBetween("aabhellobabnonba", "ab", "ba"); 
     assertEquals(1, results.length); 
     assertEquals("hello", results[0]); 
     results = StringUtils.substringsBetween("one, two, three", "[", "]"); 
     assertNull(results); 
     results = StringUtils.substringsBetween("[one, two, three", "[", "]"); 
     assertNull(results); 
     results = StringUtils.substringsBetween("one, two, three]", "[", "]"); 
     assertNull(results); 
     results = StringUtils.substringsBetween("[one], [two], [three]", "[", null); 
     assertNull(results); 
     results = StringUtils.substringsBetween("[one], [two], [three]", null, "]"); 
     assertNull(results); 
     results = StringUtils.substringsBetween("[one], [two], [three]", "", ""); 
     assertNull(results); 
     results = StringUtils.substringsBetween(null, "[", "]"); 
     assertNull(results); 
     results = StringUtils.substringsBetween("", "[", "]"); 
     assertEquals(0, results.length); 
 }
@Test
public void testSubstringAfter_StringString3907() { 
     assertEquals("barXXbaz", StringUtils.substringAfter("fooXXbarXXbaz", "XX")); 
     assertEquals(null, StringUtils.substringAfter(null, null)); 
     assertEquals(null, StringUtils.substringAfter(null, "")); 
     assertEquals(null, StringUtils.substringAfter(null, "XX")); 
     assertEquals("", StringUtils.substringAfter("", null)); 
     assertEquals("", StringUtils.substringAfter("", "")); 
     assertEquals("", StringUtils.substringAfter("", "XX")); 
     assertEquals("", StringUtils.substringAfter("foo", null)); 
     assertEquals("ot", StringUtils.substringAfter("foot", "o")); 
     assertEquals("bc", StringUtils.substringAfter("abc", "a")); 
     assertEquals("cba", StringUtils.substringAfter("abcba", "b")); 
     assertEquals("", StringUtils.substringAfter("abc", "c")); 
     assertEquals("abc", StringUtils.substringAfter("abc", "")); 
     assertEquals("", StringUtils.substringAfter("abc", "d")); 
 }
@Test
public void testSubstring_StringInt3957() { 
     assertEquals(null, StringUtils.substring(null, 0)); 
     assertEquals("", StringUtils.substring("", 0)); 
     assertEquals("", StringUtils.substring("", 2)); 
     assertEquals("", StringUtils.substring(SENTENCE, 80)); 
     assertEquals(BAZ, StringUtils.substring(SENTENCE, 8)); 
     assertEquals(BAZ, StringUtils.substring(SENTENCE, -3)); 
     assertEquals(SENTENCE, StringUtils.substring(SENTENCE, 0)); 
     assertEquals("abc", StringUtils.substring("abc", -4)); 
     assertEquals("abc", StringUtils.substring("abc", -3)); 
     assertEquals("bc", StringUtils.substring("abc", -2)); 
     assertEquals("c", StringUtils.substring("abc", -1)); 
     assertEquals("abc", StringUtils.substring("abc", 0)); 
     assertEquals("bc", StringUtils.substring("abc", 1)); 
     assertEquals("c", StringUtils.substring("abc", 2)); 
     assertEquals("", StringUtils.substring("abc", 3)); 
     assertEquals("", StringUtils.substring("abc", 4)); 
 }
@Test
public void testSubstringAfter_StringString4001() { 
     assertEquals("barXXbaz", StringUtils.substringAfter("fooXXbarXXbaz", "XX")); 
     assertEquals(null, StringUtils.substringAfter(null, null)); 
     assertEquals(null, StringUtils.substringAfter(null, "")); 
     assertEquals(null, StringUtils.substringAfter(null, "XX")); 
     assertEquals("", StringUtils.substringAfter("", null)); 
     assertEquals("", StringUtils.substringAfter("", "")); 
     assertEquals("", StringUtils.substringAfter("", "XX")); 
     assertEquals("", StringUtils.substringAfter("foo", null)); 
     assertEquals("ot", StringUtils.substringAfter("foot", "o")); 
     assertEquals("bc", StringUtils.substringAfter("abc", "a")); 
     assertEquals("cba", StringUtils.substringAfter("abcba", "b")); 
     assertEquals("", StringUtils.substringAfter("abc", "c")); 
     assertEquals("abc", StringUtils.substringAfter("abc", "")); 
     assertEquals("", StringUtils.substringAfter("abc", "d")); 
 }
@Test
public void testRight_String4082() { 
     assertSame(null, StringUtils.right(null, -1)); 
     assertSame(null, StringUtils.right(null, 0)); 
     assertSame(null, StringUtils.right(null, 2)); 
     assertEquals("", StringUtils.right("", -1)); 
     assertEquals("", StringUtils.right("", 0)); 
     assertEquals("", StringUtils.right("", 2)); 
     assertEquals("", StringUtils.right(FOOBAR, -1)); 
     assertEquals("", StringUtils.right(FOOBAR, 0)); 
     assertEquals(BAR, StringUtils.right(FOOBAR, 3)); 
     assertSame(FOOBAR, StringUtils.right(FOOBAR, 80)); 
 }
@Test
public void testSubstringAfter_StringString4090() { 
     assertEquals("barXXbaz", StringUtils.substringAfter("fooXXbarXXbaz", "XX")); 
     assertEquals(null, StringUtils.substringAfter(null, null)); 
     assertEquals(null, StringUtils.substringAfter(null, "")); 
     assertEquals(null, StringUtils.substringAfter(null, "XX")); 
     assertEquals("", StringUtils.substringAfter("", null)); 
     assertEquals("", StringUtils.substringAfter("", "")); 
     assertEquals("", StringUtils.substringAfter("", "XX")); 
     assertEquals("", StringUtils.substringAfter("foo", null)); 
     assertEquals("ot", StringUtils.substringAfter("foot", "o")); 
     assertEquals("bc", StringUtils.substringAfter("abc", "a")); 
     assertEquals("cba", StringUtils.substringAfter("abcba", "b")); 
     assertEquals("", StringUtils.substringAfter("abc", "c")); 
     assertEquals("abc", StringUtils.substringAfter("abc", "")); 
     assertEquals("", StringUtils.substringAfter("abc", "d")); 
 }
@Test
public void testSubstringBefore_StringString4091() { 
     assertEquals("foo", StringUtils.substringBefore("fooXXbarXXbaz", "XX")); 
     assertEquals(null, StringUtils.substringBefore(null, null)); 
     assertEquals(null, StringUtils.substringBefore(null, "")); 
     assertEquals(null, StringUtils.substringBefore(null, "XX")); 
     assertEquals("", StringUtils.substringBefore("", null)); 
     assertEquals("", StringUtils.substringBefore("", "")); 
     assertEquals("", StringUtils.substringBefore("", "XX")); 
     assertEquals("foo", StringUtils.substringBefore("foo", null)); 
     assertEquals("foo", StringUtils.substringBefore("foo", "b")); 
     assertEquals("f", StringUtils.substringBefore("foot", "o")); 
     assertEquals("", StringUtils.substringBefore("abc", "a")); 
     assertEquals("a", StringUtils.substringBefore("abcba", "b")); 
     assertEquals("ab", StringUtils.substringBefore("abc", "c")); 
     assertEquals("", StringUtils.substringBefore("abc", "")); 
 }
@Test
public void testSubstringBetween_StringStringString4101() { 
     assertEquals(null, StringUtils.substringBetween(null, "", "")); 
     assertEquals(null, StringUtils.substringBetween("", null, "")); 
     assertEquals(null, StringUtils.substringBetween("", "", null)); 
     assertEquals("", StringUtils.substringBetween("", "", "")); 
     assertEquals("", StringUtils.substringBetween("foo", "", "")); 
     assertEquals(null, StringUtils.substringBetween("foo", "", "]")); 
     assertEquals(null, StringUtils.substringBetween("foo", "[", "]")); 
     assertEquals("", StringUtils.substringBetween("    ", " ", "  ")); 
     assertEquals("bar", StringUtils.substringBetween("<foo>bar</foo>", "<foo>", "</foo>")); 
 }
@Test
public void testSubstringsBetween_StringStringString4146() { 
     String[] results = StringUtils.substringsBetween("[one], [two], [three]", "[", "]"); 
     assertEquals(3, results.length); 
     assertEquals("one", results[0]); 
     assertEquals("two", results[1]); 
     assertEquals("three", results[2]); 
     results = StringUtils.substringsBetween("[one], [two], three", "[", "]"); 
     assertEquals(2, results.length); 
     assertEquals("one", results[0]); 
     assertEquals("two", results[1]); 
     results = StringUtils.substringsBetween("[one], [two], three]", "[", "]"); 
     assertEquals(2, results.length); 
     assertEquals("one", results[0]); 
     assertEquals("two", results[1]); 
     results = StringUtils.substringsBetween("[one], two], three]", "[", "]"); 
     assertEquals(1, results.length); 
     assertEquals("one", results[0]); 
     results = StringUtils.substringsBetween("one], two], [three]", "[", "]"); 
     assertEquals(1, results.length); 
     assertEquals("three", results[0]); 
     results = StringUtils.substringsBetween("aabhellobabnonba", "ab", "ba"); 
     assertEquals(1, results.length); 
     assertEquals("hello", results[0]); 
     results = StringUtils.substringsBetween("one, two, three", "[", "]"); 
     assertNull(results); 
     results = StringUtils.substringsBetween("[one, two, three", "[", "]"); 
     assertNull(results); 
     results = StringUtils.substringsBetween("one, two, three]", "[", "]"); 
     assertNull(results); 
     results = StringUtils.substringsBetween("[one], [two], [three]", "[", null); 
     assertNull(results); 
     results = StringUtils.substringsBetween("[one], [two], [three]", null, "]"); 
     assertNull(results); 
     results = StringUtils.substringsBetween("[one], [two], [three]", "", ""); 
     assertNull(results); 
     results = StringUtils.substringsBetween(null, "[", "]"); 
     assertNull(results); 
     results = StringUtils.substringsBetween("", "[", "]"); 
     assertEquals(0, results.length); 
 }
@Test
public void testMid_String4237() { 
     assertSame(null, StringUtils.mid(null, -1, 0)); 
     assertSame(null, StringUtils.mid(null, 0, -1)); 
     assertSame(null, StringUtils.mid(null, 3, 0)); 
     assertSame(null, StringUtils.mid(null, 3, 2)); 
     assertEquals("", StringUtils.mid("", 0, -1)); 
     assertEquals("", StringUtils.mid("", 0, 0)); 
     assertEquals("", StringUtils.mid("", 0, 2)); 
     assertEquals("", StringUtils.mid(FOOBAR, 3, -1)); 
     assertEquals("", StringUtils.mid(FOOBAR, 3, 0)); 
     assertEquals("b", StringUtils.mid(FOOBAR, 3, 1)); 
     assertEquals(FOO, StringUtils.mid(FOOBAR, 0, 3)); 
     assertEquals(BAR, StringUtils.mid(FOOBAR, 3, 3)); 
     assertEquals(FOOBAR, StringUtils.mid(FOOBAR, 0, 80)); 
     assertEquals(BAR, StringUtils.mid(FOOBAR, 3, 80)); 
     assertEquals("", StringUtils.mid(FOOBAR, 9, 3)); 
     assertEquals(FOO, StringUtils.mid(FOOBAR, -1, 3)); 
 }
@Test
public void testSubstring_StringIntInt4262() { 
     assertEquals(null, StringUtils.substring(null, 0, 0)); 
     assertEquals(null, StringUtils.substring(null, 1, 2)); 
     assertEquals("", StringUtils.substring("", 0, 0)); 
     assertEquals("", StringUtils.substring("", 1, 2)); 
     assertEquals("", StringUtils.substring("", -2, -1)); 
     assertEquals("", StringUtils.substring(SENTENCE, 8, 6)); 
     assertEquals(FOO, StringUtils.substring(SENTENCE, 0, 3)); 
     assertEquals("o", StringUtils.substring(SENTENCE, -9, 3)); 
     assertEquals(FOO, StringUtils.substring(SENTENCE, 0, -8)); 
     assertEquals("o", StringUtils.substring(SENTENCE, -9, -8)); 
     assertEquals(SENTENCE, StringUtils.substring(SENTENCE, 0, 80)); 
     assertEquals("", StringUtils.substring(SENTENCE, 2, 2)); 
     assertEquals("b", StringUtils.substring("abc", -2, -1)); 
 }
@Test
public void testCountMatches_String4266() { 
     assertEquals(0, StringUtils.countMatches(null, null)); 
     assertEquals(0, StringUtils.countMatches("blah", null)); 
     assertEquals(0, StringUtils.countMatches(null, "DD")); 
     assertEquals(0, StringUtils.countMatches("x", "")); 
     assertEquals(0, StringUtils.countMatches("", "")); 
     assertEquals(3, StringUtils.countMatches("one long someone sentence of one", "one")); 
     assertEquals(0, StringUtils.countMatches("one long someone sentence of one", "two")); 
     assertEquals(4, StringUtils.countMatches("oooooooooooo", "ooo")); 
 }
@Test
public void testSubstringBeforeLast_StringString4271() { 
     assertEquals("fooXXbar", StringUtils.substringBeforeLast("fooXXbarXXbaz", "XX")); 
     assertEquals(null, StringUtils.substringBeforeLast(null, null)); 
     assertEquals(null, StringUtils.substringBeforeLast(null, "")); 
     assertEquals(null, StringUtils.substringBeforeLast(null, "XX")); 
     assertEquals("", StringUtils.substringBeforeLast("", null)); 
     assertEquals("", StringUtils.substringBeforeLast("", "")); 
     assertEquals("", StringUtils.substringBeforeLast("", "XX")); 
     assertEquals("foo", StringUtils.substringBeforeLast("foo", null)); 
     assertEquals("foo", StringUtils.substringBeforeLast("foo", "b")); 
     assertEquals("fo", StringUtils.substringBeforeLast("foo", "o")); 
     assertEquals("abc\r\n", StringUtils.substringBeforeLast("abc\r\n", "d")); 
     assertEquals("abc", StringUtils.substringBeforeLast("abcdabc", "d")); 
     assertEquals("abcdabc", StringUtils.substringBeforeLast("abcdabcd", "d")); 
     assertEquals("a", StringUtils.substringBeforeLast("abc", "b")); 
     assertEquals("abc ", StringUtils.substringBeforeLast("abc \n", "\n")); 
     assertEquals("a", StringUtils.substringBeforeLast("a", null)); 
     assertEquals("a", StringUtils.substringBeforeLast("a", "")); 
     assertEquals("", StringUtils.substringBeforeLast("a", "a")); 
 }
@Test
public void testSubstringsBetween_StringStringString4422() { 
     String[] results = StringUtils.substringsBetween("[one], [two], [three]", "[", "]"); 
     assertEquals(3, results.length); 
     assertEquals("one", results[0]); 
     assertEquals("two", results[1]); 
     assertEquals("three", results[2]); 
     results = StringUtils.substringsBetween("[one], [two], three", "[", "]"); 
     assertEquals(2, results.length); 
     assertEquals("one", results[0]); 
     assertEquals("two", results[1]); 
     results = StringUtils.substringsBetween("[one], [two], three]", "[", "]"); 
     assertEquals(2, results.length); 
     assertEquals("one", results[0]); 
     assertEquals("two", results[1]); 
     results = StringUtils.substringsBetween("[one], two], three]", "[", "]"); 
     assertEquals(1, results.length); 
     assertEquals("one", results[0]); 
     results = StringUtils.substringsBetween("one], two], [three]", "[", "]"); 
     assertEquals(1, results.length); 
     assertEquals("three", results[0]); 
     results = StringUtils.substringsBetween("aabhellobabnonba", "ab", "ba"); 
     assertEquals(1, results.length); 
     assertEquals("hello", results[0]); 
     results = StringUtils.substringsBetween("one, two, three", "[", "]"); 
     assertNull(results); 
     results = StringUtils.substringsBetween("[one, two, three", "[", "]"); 
     assertNull(results); 
     results = StringUtils.substringsBetween("one, two, three]", "[", "]"); 
     assertNull(results); 
     results = StringUtils.substringsBetween("[one], [two], [three]", "[", null); 
     assertNull(results); 
     results = StringUtils.substringsBetween("[one], [two], [three]", null, "]"); 
     assertNull(results); 
     results = StringUtils.substringsBetween("[one], [two], [three]", "", ""); 
     assertNull(results); 
     results = StringUtils.substringsBetween(null, "[", "]"); 
     assertNull(results); 
     results = StringUtils.substringsBetween("", "[", "]"); 
     assertEquals(0, results.length); 
 }
@Test
public void testSubstringsBetween_StringStringString4449() { 
     String[] results = StringUtils.substringsBetween("[one], [two], [three]", "[", "]"); 
     assertEquals(3, results.length); 
     assertEquals("one", results[0]); 
     assertEquals("two", results[1]); 
     assertEquals("three", results[2]); 
     results = StringUtils.substringsBetween("[one], [two], three", "[", "]"); 
     assertEquals(2, results.length); 
     assertEquals("one", results[0]); 
     assertEquals("two", results[1]); 
     results = StringUtils.substringsBetween("[one], [two], three]", "[", "]"); 
     assertEquals(2, results.length); 
     assertEquals("one", results[0]); 
     assertEquals("two", results[1]); 
     results = StringUtils.substringsBetween("[one], two], three]", "[", "]"); 
     assertEquals(1, results.length); 
     assertEquals("one", results[0]); 
     results = StringUtils.substringsBetween("one], two], [three]", "[", "]"); 
     assertEquals(1, results.length); 
     assertEquals("three", results[0]); 
     results = StringUtils.substringsBetween("aabhellobabnonba", "ab", "ba"); 
     assertEquals(1, results.length); 
     assertEquals("hello", results[0]); 
     results = StringUtils.substringsBetween("one, two, three", "[", "]"); 
     assertNull(results); 
     results = StringUtils.substringsBetween("[one, two, three", "[", "]"); 
     assertNull(results); 
     results = StringUtils.substringsBetween("one, two, three]", "[", "]"); 
     assertNull(results); 
     results = StringUtils.substringsBetween("[one], [two], [three]", "[", null); 
     assertNull(results); 
     results = StringUtils.substringsBetween("[one], [two], [three]", null, "]"); 
     assertNull(results); 
     results = StringUtils.substringsBetween("[one], [two], [three]", "", ""); 
     assertNull(results); 
     results = StringUtils.substringsBetween(null, "[", "]"); 
     assertNull(results); 
     results = StringUtils.substringsBetween("", "[", "]"); 
     assertEquals(0, results.length); 
 }
@Test
public void testLeft_String4843() { 
     assertSame(null, StringUtils.left(null, -1)); 
     assertSame(null, StringUtils.left(null, 0)); 
     assertSame(null, StringUtils.left(null, 2)); 
     assertEquals("", StringUtils.left("", -1)); 
     assertEquals("", StringUtils.left("", 0)); 
     assertEquals("", StringUtils.left("", 2)); 
     assertEquals("", StringUtils.left(FOOBAR, -1)); 
     assertEquals("", StringUtils.left(FOOBAR, 0)); 
     assertEquals(FOO, StringUtils.left(FOOBAR, 3)); 
     assertSame(FOOBAR, StringUtils.left(FOOBAR, 80)); 
 }
@Test
public void testRight_String4904() { 
     assertSame(null, StringUtils.right(null, -1)); 
     assertSame(null, StringUtils.right(null, 0)); 
     assertSame(null, StringUtils.right(null, 2)); 
     assertEquals("", StringUtils.right("", -1)); 
     assertEquals("", StringUtils.right("", 0)); 
     assertEquals("", StringUtils.right("", 2)); 
     assertEquals("", StringUtils.right(FOOBAR, -1)); 
     assertEquals("", StringUtils.right(FOOBAR, 0)); 
     assertEquals(BAR, StringUtils.right(FOOBAR, 3)); 
     assertSame(FOOBAR, StringUtils.right(FOOBAR, 80)); 
 }
@Test
public void testMid_String4933() { 
     assertSame(null, StringUtils.mid(null, -1, 0)); 
     assertSame(null, StringUtils.mid(null, 0, -1)); 
     assertSame(null, StringUtils.mid(null, 3, 0)); 
     assertSame(null, StringUtils.mid(null, 3, 2)); 
     assertEquals("", StringUtils.mid("", 0, -1)); 
     assertEquals("", StringUtils.mid("", 0, 0)); 
     assertEquals("", StringUtils.mid("", 0, 2)); 
     assertEquals("", StringUtils.mid(FOOBAR, 3, -1)); 
     assertEquals("", StringUtils.mid(FOOBAR, 3, 0)); 
     assertEquals("b", StringUtils.mid(FOOBAR, 3, 1)); 
     assertEquals(FOO, StringUtils.mid(FOOBAR, 0, 3)); 
     assertEquals(BAR, StringUtils.mid(FOOBAR, 3, 3)); 
     assertEquals(FOOBAR, StringUtils.mid(FOOBAR, 0, 80)); 
     assertEquals(BAR, StringUtils.mid(FOOBAR, 3, 80)); 
     assertEquals("", StringUtils.mid(FOOBAR, 9, 3)); 
     assertEquals(FOO, StringUtils.mid(FOOBAR, -1, 3)); 
 }
@Test
public void testMid_String5086() { 
     assertSame(null, StringUtils.mid(null, -1, 0)); 
     assertSame(null, StringUtils.mid(null, 0, -1)); 
     assertSame(null, StringUtils.mid(null, 3, 0)); 
     assertSame(null, StringUtils.mid(null, 3, 2)); 
     assertEquals("", StringUtils.mid("", 0, -1)); 
     assertEquals("", StringUtils.mid("", 0, 0)); 
     assertEquals("", StringUtils.mid("", 0, 2)); 
     assertEquals("", StringUtils.mid(FOOBAR, 3, -1)); 
     assertEquals("", StringUtils.mid(FOOBAR, 3, 0)); 
     assertEquals("b", StringUtils.mid(FOOBAR, 3, 1)); 
     assertEquals(FOO, StringUtils.mid(FOOBAR, 0, 3)); 
     assertEquals(BAR, StringUtils.mid(FOOBAR, 3, 3)); 
     assertEquals(FOOBAR, StringUtils.mid(FOOBAR, 0, 80)); 
     assertEquals(BAR, StringUtils.mid(FOOBAR, 3, 80)); 
     assertEquals("", StringUtils.mid(FOOBAR, 9, 3)); 
     assertEquals(FOO, StringUtils.mid(FOOBAR, -1, 3)); 
 }
@Test
public void testSubstringsBetween_StringStringString5198() { 
     String[] results = StringUtils.substringsBetween("[one], [two], [three]", "[", "]"); 
     assertEquals(3, results.length); 
     assertEquals("one", results[0]); 
     assertEquals("two", results[1]); 
     assertEquals("three", results[2]); 
     results = StringUtils.substringsBetween("[one], [two], three", "[", "]"); 
     assertEquals(2, results.length); 
     assertEquals("one", results[0]); 
     assertEquals("two", results[1]); 
     results = StringUtils.substringsBetween("[one], [two], three]", "[", "]"); 
     assertEquals(2, results.length); 
     assertEquals("one", results[0]); 
     assertEquals("two", results[1]); 
     results = StringUtils.substringsBetween("[one], two], three]", "[", "]"); 
     assertEquals(1, results.length); 
     assertEquals("one", results[0]); 
     results = StringUtils.substringsBetween("one], two], [three]", "[", "]"); 
     assertEquals(1, results.length); 
     assertEquals("three", results[0]); 
     results = StringUtils.substringsBetween("aabhellobabnonba", "ab", "ba"); 
     assertEquals(1, results.length); 
     assertEquals("hello", results[0]); 
     results = StringUtils.substringsBetween("one, two, three", "[", "]"); 
     assertNull(results); 
     results = StringUtils.substringsBetween("[one, two, three", "[", "]"); 
     assertNull(results); 
     results = StringUtils.substringsBetween("one, two, three]", "[", "]"); 
     assertNull(results); 
     results = StringUtils.substringsBetween("[one], [two], [three]", "[", null); 
     assertNull(results); 
     results = StringUtils.substringsBetween("[one], [two], [three]", null, "]"); 
     assertNull(results); 
     results = StringUtils.substringsBetween("[one], [two], [three]", "", ""); 
     assertNull(results); 
     results = StringUtils.substringsBetween(null, "[", "]"); 
     assertNull(results); 
     results = StringUtils.substringsBetween("", "[", "]"); 
     assertEquals(0, results.length); 
 }
@Test
public void testSubstring_StringInt5239() { 
     assertEquals(null, StringUtils.substring(null, 0)); 
     assertEquals("", StringUtils.substring("", 0)); 
     assertEquals("", StringUtils.substring("", 2)); 
     assertEquals("", StringUtils.substring(SENTENCE, 80)); 
     assertEquals(BAZ, StringUtils.substring(SENTENCE, 8)); 
     assertEquals(BAZ, StringUtils.substring(SENTENCE, -3)); 
     assertEquals(SENTENCE, StringUtils.substring(SENTENCE, 0)); 
     assertEquals("abc", StringUtils.substring("abc", -4)); 
     assertEquals("abc", StringUtils.substring("abc", -3)); 
     assertEquals("bc", StringUtils.substring("abc", -2)); 
     assertEquals("c", StringUtils.substring("abc", -1)); 
     assertEquals("abc", StringUtils.substring("abc", 0)); 
     assertEquals("bc", StringUtils.substring("abc", 1)); 
     assertEquals("c", StringUtils.substring("abc", 2)); 
     assertEquals("", StringUtils.substring("abc", 3)); 
     assertEquals("", StringUtils.substring("abc", 4)); 
 }
@Test
public void testSubstring_StringInt5275() { 
     assertEquals(null, StringUtils.substring(null, 0)); 
     assertEquals("", StringUtils.substring("", 0)); 
     assertEquals("", StringUtils.substring("", 2)); 
     assertEquals("", StringUtils.substring(SENTENCE, 80)); 
     assertEquals(BAZ, StringUtils.substring(SENTENCE, 8)); 
     assertEquals(BAZ, StringUtils.substring(SENTENCE, -3)); 
     assertEquals(SENTENCE, StringUtils.substring(SENTENCE, 0)); 
     assertEquals("abc", StringUtils.substring("abc", -4)); 
     assertEquals("abc", StringUtils.substring("abc", -3)); 
     assertEquals("bc", StringUtils.substring("abc", -2)); 
     assertEquals("c", StringUtils.substring("abc", -1)); 
     assertEquals("abc", StringUtils.substring("abc", 0)); 
     assertEquals("bc", StringUtils.substring("abc", 1)); 
     assertEquals("c", StringUtils.substring("abc", 2)); 
     assertEquals("", StringUtils.substring("abc", 3)); 
     assertEquals("", StringUtils.substring("abc", 4)); 
 }
@Test
public void testRight_String5325() { 
     assertSame(null, StringUtils.right(null, -1)); 
     assertSame(null, StringUtils.right(null, 0)); 
     assertSame(null, StringUtils.right(null, 2)); 
     assertEquals("", StringUtils.right("", -1)); 
     assertEquals("", StringUtils.right("", 0)); 
     assertEquals("", StringUtils.right("", 2)); 
     assertEquals("", StringUtils.right(FOOBAR, -1)); 
     assertEquals("", StringUtils.right(FOOBAR, 0)); 
     assertEquals(BAR, StringUtils.right(FOOBAR, 3)); 
     assertSame(FOOBAR, StringUtils.right(FOOBAR, 80)); 
 }
@Test
public void testSubstring_StringIntInt5328() { 
     assertEquals(null, StringUtils.substring(null, 0, 0)); 
     assertEquals(null, StringUtils.substring(null, 1, 2)); 
     assertEquals("", StringUtils.substring("", 0, 0)); 
     assertEquals("", StringUtils.substring("", 1, 2)); 
     assertEquals("", StringUtils.substring("", -2, -1)); 
     assertEquals("", StringUtils.substring(SENTENCE, 8, 6)); 
     assertEquals(FOO, StringUtils.substring(SENTENCE, 0, 3)); 
     assertEquals("o", StringUtils.substring(SENTENCE, -9, 3)); 
     assertEquals(FOO, StringUtils.substring(SENTENCE, 0, -8)); 
     assertEquals("o", StringUtils.substring(SENTENCE, -9, -8)); 
     assertEquals(SENTENCE, StringUtils.substring(SENTENCE, 0, 80)); 
     assertEquals("", StringUtils.substring(SENTENCE, 2, 2)); 
     assertEquals("b", StringUtils.substring("abc", -2, -1)); 
 }
@Test
public void testSubstringBeforeLast_StringString5430() { 
     assertEquals("fooXXbar", StringUtils.substringBeforeLast("fooXXbarXXbaz", "XX")); 
     assertEquals(null, StringUtils.substringBeforeLast(null, null)); 
     assertEquals(null, StringUtils.substringBeforeLast(null, "")); 
     assertEquals(null, StringUtils.substringBeforeLast(null, "XX")); 
     assertEquals("", StringUtils.substringBeforeLast("", null)); 
     assertEquals("", StringUtils.substringBeforeLast("", "")); 
     assertEquals("", StringUtils.substringBeforeLast("", "XX")); 
     assertEquals("foo", StringUtils.substringBeforeLast("foo", null)); 
     assertEquals("foo", StringUtils.substringBeforeLast("foo", "b")); 
     assertEquals("fo", StringUtils.substringBeforeLast("foo", "o")); 
     assertEquals("abc\r\n", StringUtils.substringBeforeLast("abc\r\n", "d")); 
     assertEquals("abc", StringUtils.substringBeforeLast("abcdabc", "d")); 
     assertEquals("abcdabc", StringUtils.substringBeforeLast("abcdabcd", "d")); 
     assertEquals("a", StringUtils.substringBeforeLast("abc", "b")); 
     assertEquals("abc ", StringUtils.substringBeforeLast("abc \n", "\n")); 
     assertEquals("a", StringUtils.substringBeforeLast("a", null)); 
     assertEquals("a", StringUtils.substringBeforeLast("a", "")); 
     assertEquals("", StringUtils.substringBeforeLast("a", "a")); 
 }
@Test
public void testSubstringAfterLast_StringString5433() { 
     assertEquals("baz", StringUtils.substringAfterLast("fooXXbarXXbaz", "XX")); 
     assertEquals(null, StringUtils.substringAfterLast(null, null)); 
     assertEquals(null, StringUtils.substringAfterLast(null, "")); 
     assertEquals(null, StringUtils.substringAfterLast(null, "XX")); 
     assertEquals("", StringUtils.substringAfterLast("", null)); 
     assertEquals("", StringUtils.substringAfterLast("", "")); 
     assertEquals("", StringUtils.substringAfterLast("", "a")); 
     assertEquals("", StringUtils.substringAfterLast("foo", null)); 
     assertEquals("", StringUtils.substringAfterLast("foo", "b")); 
     assertEquals("t", StringUtils.substringAfterLast("foot", "o")); 
     assertEquals("bc", StringUtils.substringAfterLast("abc", "a")); 
     assertEquals("a", StringUtils.substringAfterLast("abcba", "b")); 
     assertEquals("", StringUtils.substringAfterLast("abc", "c")); 
     assertEquals("", StringUtils.substringAfterLast("", "d")); 
     assertEquals("", StringUtils.substringAfterLast("abc", "")); 
 }
@Test
public void testSubstringBetween_StringStringString5628() { 
     assertEquals(null, StringUtils.substringBetween(null, "", "")); 
     assertEquals(null, StringUtils.substringBetween("", null, "")); 
     assertEquals(null, StringUtils.substringBetween("", "", null)); 
     assertEquals("", StringUtils.substringBetween("", "", "")); 
     assertEquals("", StringUtils.substringBetween("foo", "", "")); 
     assertEquals(null, StringUtils.substringBetween("foo", "", "]")); 
     assertEquals(null, StringUtils.substringBetween("foo", "[", "]")); 
     assertEquals("", StringUtils.substringBetween("    ", " ", "  ")); 
     assertEquals("bar", StringUtils.substringBetween("<foo>bar</foo>", "<foo>", "</foo>")); 
 }
@Test
public void testSubstring_StringIntInt5636() { 
     assertEquals(null, StringUtils.substring(null, 0, 0)); 
     assertEquals(null, StringUtils.substring(null, 1, 2)); 
     assertEquals("", StringUtils.substring("", 0, 0)); 
     assertEquals("", StringUtils.substring("", 1, 2)); 
     assertEquals("", StringUtils.substring("", -2, -1)); 
     assertEquals("", StringUtils.substring(SENTENCE, 8, 6)); 
     assertEquals(FOO, StringUtils.substring(SENTENCE, 0, 3)); 
     assertEquals("o", StringUtils.substring(SENTENCE, -9, 3)); 
     assertEquals(FOO, StringUtils.substring(SENTENCE, 0, -8)); 
     assertEquals("o", StringUtils.substring(SENTENCE, -9, -8)); 
     assertEquals(SENTENCE, StringUtils.substring(SENTENCE, 0, 80)); 
     assertEquals("", StringUtils.substring(SENTENCE, 2, 2)); 
     assertEquals("b", StringUtils.substring("abc", -2, -1)); 
 }
@Test
public void testSubstringAfterLast_StringString5651() { 
     assertEquals("baz", StringUtils.substringAfterLast("fooXXbarXXbaz", "XX")); 
     assertEquals(null, StringUtils.substringAfterLast(null, null)); 
     assertEquals(null, StringUtils.substringAfterLast(null, "")); 
     assertEquals(null, StringUtils.substringAfterLast(null, "XX")); 
     assertEquals("", StringUtils.substringAfterLast("", null)); 
     assertEquals("", StringUtils.substringAfterLast("", "")); 
     assertEquals("", StringUtils.substringAfterLast("", "a")); 
     assertEquals("", StringUtils.substringAfterLast("foo", null)); 
     assertEquals("", StringUtils.substringAfterLast("foo", "b")); 
     assertEquals("t", StringUtils.substringAfterLast("foot", "o")); 
     assertEquals("bc", StringUtils.substringAfterLast("abc", "a")); 
     assertEquals("a", StringUtils.substringAfterLast("abcba", "b")); 
     assertEquals("", StringUtils.substringAfterLast("abc", "c")); 
     assertEquals("", StringUtils.substringAfterLast("", "d")); 
     assertEquals("", StringUtils.substringAfterLast("abc", "")); 
 }
@Test
public void testSubstringAfterLast_StringString5656() { 
     assertEquals("baz", StringUtils.substringAfterLast("fooXXbarXXbaz", "XX")); 
     assertEquals(null, StringUtils.substringAfterLast(null, null)); 
     assertEquals(null, StringUtils.substringAfterLast(null, "")); 
     assertEquals(null, StringUtils.substringAfterLast(null, "XX")); 
     assertEquals("", StringUtils.substringAfterLast("", null)); 
     assertEquals("", StringUtils.substringAfterLast("", "")); 
     assertEquals("", StringUtils.substringAfterLast("", "a")); 
     assertEquals("", StringUtils.substringAfterLast("foo", null)); 
     assertEquals("", StringUtils.substringAfterLast("foo", "b")); 
     assertEquals("t", StringUtils.substringAfterLast("foot", "o")); 
     assertEquals("bc", StringUtils.substringAfterLast("abc", "a")); 
     assertEquals("a", StringUtils.substringAfterLast("abcba", "b")); 
     assertEquals("", StringUtils.substringAfterLast("abc", "c")); 
     assertEquals("", StringUtils.substringAfterLast("", "d")); 
     assertEquals("", StringUtils.substringAfterLast("abc", "")); 
 }
@Test
public void testSubstringsBetween_StringStringString5732() { 
     String[] results = StringUtils.substringsBetween("[one], [two], [three]", "[", "]"); 
     assertEquals(3, results.length); 
     assertEquals("one", results[0]); 
     assertEquals("two", results[1]); 
     assertEquals("three", results[2]); 
     results = StringUtils.substringsBetween("[one], [two], three", "[", "]"); 
     assertEquals(2, results.length); 
     assertEquals("one", results[0]); 
     assertEquals("two", results[1]); 
     results = StringUtils.substringsBetween("[one], [two], three]", "[", "]"); 
     assertEquals(2, results.length); 
     assertEquals("one", results[0]); 
     assertEquals("two", results[1]); 
     results = StringUtils.substringsBetween("[one], two], three]", "[", "]"); 
     assertEquals(1, results.length); 
     assertEquals("one", results[0]); 
     results = StringUtils.substringsBetween("one], two], [three]", "[", "]"); 
     assertEquals(1, results.length); 
     assertEquals("three", results[0]); 
     results = StringUtils.substringsBetween("aabhellobabnonba", "ab", "ba"); 
     assertEquals(1, results.length); 
     assertEquals("hello", results[0]); 
     results = StringUtils.substringsBetween("one, two, three", "[", "]"); 
     assertNull(results); 
     results = StringUtils.substringsBetween("[one, two, three", "[", "]"); 
     assertNull(results); 
     results = StringUtils.substringsBetween("one, two, three]", "[", "]"); 
     assertNull(results); 
     results = StringUtils.substringsBetween("[one], [two], [three]", "[", null); 
     assertNull(results); 
     results = StringUtils.substringsBetween("[one], [two], [three]", null, "]"); 
     assertNull(results); 
     results = StringUtils.substringsBetween("[one], [two], [three]", "", ""); 
     assertNull(results); 
     results = StringUtils.substringsBetween(null, "[", "]"); 
     assertNull(results); 
     results = StringUtils.substringsBetween("", "[", "]"); 
     assertEquals(0, results.length); 
 }
@Test
public void testSubstringBetween_StringString5844() { 
     assertEquals(null, StringUtils.substringBetween(null, "tag")); 
     assertEquals("", StringUtils.substringBetween("", "")); 
     assertEquals(null, StringUtils.substringBetween("", "abc")); 
     assertEquals("", StringUtils.substringBetween("    ", " ")); 
     assertEquals(null, StringUtils.substringBetween("abc", null)); 
     assertEquals("", StringUtils.substringBetween("abc", "")); 
     assertEquals(null, StringUtils.substringBetween("abc", "a")); 
     assertEquals("bc", StringUtils.substringBetween("abca", "a")); 
     assertEquals("bc", StringUtils.substringBetween("abcabca", "a")); 
     assertEquals("bar", StringUtils.substringBetween("\nbar\n", "\n")); 
 }
@Test
public void testSubstringAfter_StringString5974() { 
     assertEquals("barXXbaz", StringUtils.substringAfter("fooXXbarXXbaz", "XX")); 
     assertEquals(null, StringUtils.substringAfter(null, null)); 
     assertEquals(null, StringUtils.substringAfter(null, "")); 
     assertEquals(null, StringUtils.substringAfter(null, "XX")); 
     assertEquals("", StringUtils.substringAfter("", null)); 
     assertEquals("", StringUtils.substringAfter("", "")); 
     assertEquals("", StringUtils.substringAfter("", "XX")); 
     assertEquals("", StringUtils.substringAfter("foo", null)); 
     assertEquals("ot", StringUtils.substringAfter("foot", "o")); 
     assertEquals("bc", StringUtils.substringAfter("abc", "a")); 
     assertEquals("cba", StringUtils.substringAfter("abcba", "b")); 
     assertEquals("", StringUtils.substringAfter("abc", "c")); 
     assertEquals("abc", StringUtils.substringAfter("abc", "")); 
     assertEquals("", StringUtils.substringAfter("abc", "d")); 
 }
@Test
public void testSubstring_StringIntInt6019() { 
     assertEquals(null, StringUtils.substring(null, 0, 0)); 
     assertEquals(null, StringUtils.substring(null, 1, 2)); 
     assertEquals("", StringUtils.substring("", 0, 0)); 
     assertEquals("", StringUtils.substring("", 1, 2)); 
     assertEquals("", StringUtils.substring("", -2, -1)); 
     assertEquals("", StringUtils.substring(SENTENCE, 8, 6)); 
     assertEquals(FOO, StringUtils.substring(SENTENCE, 0, 3)); 
     assertEquals("o", StringUtils.substring(SENTENCE, -9, 3)); 
     assertEquals(FOO, StringUtils.substring(SENTENCE, 0, -8)); 
     assertEquals("o", StringUtils.substring(SENTENCE, -9, -8)); 
     assertEquals(SENTENCE, StringUtils.substring(SENTENCE, 0, 80)); 
     assertEquals("", StringUtils.substring(SENTENCE, 2, 2)); 
     assertEquals("b", StringUtils.substring("abc", -2, -1)); 
 }
@Test
public void testSubstringAfter_StringString6025() { 
     assertEquals("barXXbaz", StringUtils.substringAfter("fooXXbarXXbaz", "XX")); 
     assertEquals(null, StringUtils.substringAfter(null, null)); 
     assertEquals(null, StringUtils.substringAfter(null, "")); 
     assertEquals(null, StringUtils.substringAfter(null, "XX")); 
     assertEquals("", StringUtils.substringAfter("", null)); 
     assertEquals("", StringUtils.substringAfter("", "")); 
     assertEquals("", StringUtils.substringAfter("", "XX")); 
     assertEquals("", StringUtils.substringAfter("foo", null)); 
     assertEquals("ot", StringUtils.substringAfter("foot", "o")); 
     assertEquals("bc", StringUtils.substringAfter("abc", "a")); 
     assertEquals("cba", StringUtils.substringAfter("abcba", "b")); 
     assertEquals("", StringUtils.substringAfter("abc", "c")); 
     assertEquals("abc", StringUtils.substringAfter("abc", "")); 
     assertEquals("", StringUtils.substringAfter("abc", "d")); 
 }
@Test
public void testLeft_String6341() { 
     assertSame(null, StringUtils.left(null, -1)); 
     assertSame(null, StringUtils.left(null, 0)); 
     assertSame(null, StringUtils.left(null, 2)); 
     assertEquals("", StringUtils.left("", -1)); 
     assertEquals("", StringUtils.left("", 0)); 
     assertEquals("", StringUtils.left("", 2)); 
     assertEquals("", StringUtils.left(FOOBAR, -1)); 
     assertEquals("", StringUtils.left(FOOBAR, 0)); 
     assertEquals(FOO, StringUtils.left(FOOBAR, 3)); 
     assertSame(FOOBAR, StringUtils.left(FOOBAR, 80)); 
 }
@Test
public void testCountMatches_String6357() { 
     assertEquals(0, StringUtils.countMatches(null, null)); 
     assertEquals(0, StringUtils.countMatches("blah", null)); 
     assertEquals(0, StringUtils.countMatches(null, "DD")); 
     assertEquals(0, StringUtils.countMatches("x", "")); 
     assertEquals(0, StringUtils.countMatches("", "")); 
     assertEquals(3, StringUtils.countMatches("one long someone sentence of one", "one")); 
     assertEquals(0, StringUtils.countMatches("one long someone sentence of one", "two")); 
     assertEquals(4, StringUtils.countMatches("oooooooooooo", "ooo")); 
 }
@Test
public void testSubstringAfterLast_StringString6466() { 
     assertEquals("baz", StringUtils.substringAfterLast("fooXXbarXXbaz", "XX")); 
     assertEquals(null, StringUtils.substringAfterLast(null, null)); 
     assertEquals(null, StringUtils.substringAfterLast(null, "")); 
     assertEquals(null, StringUtils.substringAfterLast(null, "XX")); 
     assertEquals("", StringUtils.substringAfterLast("", null)); 
     assertEquals("", StringUtils.substringAfterLast("", "")); 
     assertEquals("", StringUtils.substringAfterLast("", "a")); 
     assertEquals("", StringUtils.substringAfterLast("foo", null)); 
     assertEquals("", StringUtils.substringAfterLast("foo", "b")); 
     assertEquals("t", StringUtils.substringAfterLast("foot", "o")); 
     assertEquals("bc", StringUtils.substringAfterLast("abc", "a")); 
     assertEquals("a", StringUtils.substringAfterLast("abcba", "b")); 
     assertEquals("", StringUtils.substringAfterLast("abc", "c")); 
     assertEquals("", StringUtils.substringAfterLast("", "d")); 
     assertEquals("", StringUtils.substringAfterLast("abc", "")); 
 }
@Test
public void testSubstringBefore_StringString6485() { 
     assertEquals("foo", StringUtils.substringBefore("fooXXbarXXbaz", "XX")); 
     assertEquals(null, StringUtils.substringBefore(null, null)); 
     assertEquals(null, StringUtils.substringBefore(null, "")); 
     assertEquals(null, StringUtils.substringBefore(null, "XX")); 
     assertEquals("", StringUtils.substringBefore("", null)); 
     assertEquals("", StringUtils.substringBefore("", "")); 
     assertEquals("", StringUtils.substringBefore("", "XX")); 
     assertEquals("foo", StringUtils.substringBefore("foo", null)); 
     assertEquals("foo", StringUtils.substringBefore("foo", "b")); 
     assertEquals("f", StringUtils.substringBefore("foot", "o")); 
     assertEquals("", StringUtils.substringBefore("abc", "a")); 
     assertEquals("a", StringUtils.substringBefore("abcba", "b")); 
     assertEquals("ab", StringUtils.substringBefore("abc", "c")); 
     assertEquals("", StringUtils.substringBefore("abc", "")); 
 }
@Test
public void testSubstringBefore_StringString6519() { 
     assertEquals("foo", StringUtils.substringBefore("fooXXbarXXbaz", "XX")); 
     assertEquals(null, StringUtils.substringBefore(null, null)); 
     assertEquals(null, StringUtils.substringBefore(null, "")); 
     assertEquals(null, StringUtils.substringBefore(null, "XX")); 
     assertEquals("", StringUtils.substringBefore("", null)); 
     assertEquals("", StringUtils.substringBefore("", "")); 
     assertEquals("", StringUtils.substringBefore("", "XX")); 
     assertEquals("foo", StringUtils.substringBefore("foo", null)); 
     assertEquals("foo", StringUtils.substringBefore("foo", "b")); 
     assertEquals("f", StringUtils.substringBefore("foot", "o")); 
     assertEquals("", StringUtils.substringBefore("abc", "a")); 
     assertEquals("a", StringUtils.substringBefore("abcba", "b")); 
     assertEquals("ab", StringUtils.substringBefore("abc", "c")); 
     assertEquals("", StringUtils.substringBefore("abc", "")); 
 }
@Test
public void testLeft_String6639() { 
     assertSame(null, StringUtils.left(null, -1)); 
     assertSame(null, StringUtils.left(null, 0)); 
     assertSame(null, StringUtils.left(null, 2)); 
     assertEquals("", StringUtils.left("", -1)); 
     assertEquals("", StringUtils.left("", 0)); 
     assertEquals("", StringUtils.left("", 2)); 
     assertEquals("", StringUtils.left(FOOBAR, -1)); 
     assertEquals("", StringUtils.left(FOOBAR, 0)); 
     assertEquals(FOO, StringUtils.left(FOOBAR, 3)); 
     assertSame(FOOBAR, StringUtils.left(FOOBAR, 80)); 
 }
@Test
public void testSubstringAfterLast_StringString6654() { 
     assertEquals("baz", StringUtils.substringAfterLast("fooXXbarXXbaz", "XX")); 
     assertEquals(null, StringUtils.substringAfterLast(null, null)); 
     assertEquals(null, StringUtils.substringAfterLast(null, "")); 
     assertEquals(null, StringUtils.substringAfterLast(null, "XX")); 
     assertEquals("", StringUtils.substringAfterLast("", null)); 
     assertEquals("", StringUtils.substringAfterLast("", "")); 
     assertEquals("", StringUtils.substringAfterLast("", "a")); 
     assertEquals("", StringUtils.substringAfterLast("foo", null)); 
     assertEquals("", StringUtils.substringAfterLast("foo", "b")); 
     assertEquals("t", StringUtils.substringAfterLast("foot", "o")); 
     assertEquals("bc", StringUtils.substringAfterLast("abc", "a")); 
     assertEquals("a", StringUtils.substringAfterLast("abcba", "b")); 
     assertEquals("", StringUtils.substringAfterLast("abc", "c")); 
     assertEquals("", StringUtils.substringAfterLast("", "d")); 
     assertEquals("", StringUtils.substringAfterLast("abc", "")); 
 }
@Test
public void testSubstring_StringIntInt6785() { 
     assertEquals(null, StringUtils.substring(null, 0, 0)); 
     assertEquals(null, StringUtils.substring(null, 1, 2)); 
     assertEquals("", StringUtils.substring("", 0, 0)); 
     assertEquals("", StringUtils.substring("", 1, 2)); 
     assertEquals("", StringUtils.substring("", -2, -1)); 
     assertEquals("", StringUtils.substring(SENTENCE, 8, 6)); 
     assertEquals(FOO, StringUtils.substring(SENTENCE, 0, 3)); 
     assertEquals("o", StringUtils.substring(SENTENCE, -9, 3)); 
     assertEquals(FOO, StringUtils.substring(SENTENCE, 0, -8)); 
     assertEquals("o", StringUtils.substring(SENTENCE, -9, -8)); 
     assertEquals(SENTENCE, StringUtils.substring(SENTENCE, 0, 80)); 
     assertEquals("", StringUtils.substring(SENTENCE, 2, 2)); 
     assertEquals("b", StringUtils.substring("abc", -2, -1)); 
 }
@Test
public void testSubstringsBetween_StringStringString6821() { 
     String[] results = StringUtils.substringsBetween("[one], [two], [three]", "[", "]"); 
     assertEquals(3, results.length); 
     assertEquals("one", results[0]); 
     assertEquals("two", results[1]); 
     assertEquals("three", results[2]); 
     results = StringUtils.substringsBetween("[one], [two], three", "[", "]"); 
     assertEquals(2, results.length); 
     assertEquals("one", results[0]); 
     assertEquals("two", results[1]); 
     results = StringUtils.substringsBetween("[one], [two], three]", "[", "]"); 
     assertEquals(2, results.length); 
     assertEquals("one", results[0]); 
     assertEquals("two", results[1]); 
     results = StringUtils.substringsBetween("[one], two], three]", "[", "]"); 
     assertEquals(1, results.length); 
     assertEquals("one", results[0]); 
     results = StringUtils.substringsBetween("one], two], [three]", "[", "]"); 
     assertEquals(1, results.length); 
     assertEquals("three", results[0]); 
     results = StringUtils.substringsBetween("aabhellobabnonba", "ab", "ba"); 
     assertEquals(1, results.length); 
     assertEquals("hello", results[0]); 
     results = StringUtils.substringsBetween("one, two, three", "[", "]"); 
     assertNull(results); 
     results = StringUtils.substringsBetween("[one, two, three", "[", "]"); 
     assertNull(results); 
     results = StringUtils.substringsBetween("one, two, three]", "[", "]"); 
     assertNull(results); 
     results = StringUtils.substringsBetween("[one], [two], [three]", "[", null); 
     assertNull(results); 
     results = StringUtils.substringsBetween("[one], [two], [three]", null, "]"); 
     assertNull(results); 
     results = StringUtils.substringsBetween("[one], [two], [three]", "", ""); 
     assertNull(results); 
     results = StringUtils.substringsBetween(null, "[", "]"); 
     assertNull(results); 
     results = StringUtils.substringsBetween("", "[", "]"); 
     assertEquals(0, results.length); 
 }
@Test
public void testSubstringBefore_StringString6906() { 
     assertEquals("foo", StringUtils.substringBefore("fooXXbarXXbaz", "XX")); 
     assertEquals(null, StringUtils.substringBefore(null, null)); 
     assertEquals(null, StringUtils.substringBefore(null, "")); 
     assertEquals(null, StringUtils.substringBefore(null, "XX")); 
     assertEquals("", StringUtils.substringBefore("", null)); 
     assertEquals("", StringUtils.substringBefore("", "")); 
     assertEquals("", StringUtils.substringBefore("", "XX")); 
     assertEquals("foo", StringUtils.substringBefore("foo", null)); 
     assertEquals("foo", StringUtils.substringBefore("foo", "b")); 
     assertEquals("f", StringUtils.substringBefore("foot", "o")); 
     assertEquals("", StringUtils.substringBefore("abc", "a")); 
     assertEquals("a", StringUtils.substringBefore("abcba", "b")); 
     assertEquals("ab", StringUtils.substringBefore("abc", "c")); 
     assertEquals("", StringUtils.substringBefore("abc", "")); 
 }
@Test
public void testSubstring_StringIntInt6980() { 
     assertEquals(null, StringUtils.substring(null, 0, 0)); 
     assertEquals(null, StringUtils.substring(null, 1, 2)); 
     assertEquals("", StringUtils.substring("", 0, 0)); 
     assertEquals("", StringUtils.substring("", 1, 2)); 
     assertEquals("", StringUtils.substring("", -2, -1)); 
     assertEquals("", StringUtils.substring(SENTENCE, 8, 6)); 
     assertEquals(FOO, StringUtils.substring(SENTENCE, 0, 3)); 
     assertEquals("o", StringUtils.substring(SENTENCE, -9, 3)); 
     assertEquals(FOO, StringUtils.substring(SENTENCE, 0, -8)); 
     assertEquals("o", StringUtils.substring(SENTENCE, -9, -8)); 
     assertEquals(SENTENCE, StringUtils.substring(SENTENCE, 0, 80)); 
     assertEquals("", StringUtils.substring(SENTENCE, 2, 2)); 
     assertEquals("b", StringUtils.substring("abc", -2, -1)); 
 }
@Test
public void testSubstring_StringIntInt7375() { 
     assertEquals(null, StringUtils.substring(null, 0, 0)); 
     assertEquals(null, StringUtils.substring(null, 1, 2)); 
     assertEquals("", StringUtils.substring("", 0, 0)); 
     assertEquals("", StringUtils.substring("", 1, 2)); 
     assertEquals("", StringUtils.substring("", -2, -1)); 
     assertEquals("", StringUtils.substring(SENTENCE, 8, 6)); 
     assertEquals(FOO, StringUtils.substring(SENTENCE, 0, 3)); 
     assertEquals("o", StringUtils.substring(SENTENCE, -9, 3)); 
     assertEquals(FOO, StringUtils.substring(SENTENCE, 0, -8)); 
     assertEquals("o", StringUtils.substring(SENTENCE, -9, -8)); 
     assertEquals(SENTENCE, StringUtils.substring(SENTENCE, 0, 80)); 
     assertEquals("", StringUtils.substring(SENTENCE, 2, 2)); 
     assertEquals("b", StringUtils.substring("abc", -2, -1)); 
 }
@Test
public void testSubstringsBetween_StringStringString7473() { 
     String[] results = StringUtils.substringsBetween("[one], [two], [three]", "[", "]"); 
     assertEquals(3, results.length); 
     assertEquals("one", results[0]); 
     assertEquals("two", results[1]); 
     assertEquals("three", results[2]); 
     results = StringUtils.substringsBetween("[one], [two], three", "[", "]"); 
     assertEquals(2, results.length); 
     assertEquals("one", results[0]); 
     assertEquals("two", results[1]); 
     results = StringUtils.substringsBetween("[one], [two], three]", "[", "]"); 
     assertEquals(2, results.length); 
     assertEquals("one", results[0]); 
     assertEquals("two", results[1]); 
     results = StringUtils.substringsBetween("[one], two], three]", "[", "]"); 
     assertEquals(1, results.length); 
     assertEquals("one", results[0]); 
     results = StringUtils.substringsBetween("one], two], [three]", "[", "]"); 
     assertEquals(1, results.length); 
     assertEquals("three", results[0]); 
     results = StringUtils.substringsBetween("aabhellobabnonba", "ab", "ba"); 
     assertEquals(1, results.length); 
     assertEquals("hello", results[0]); 
     results = StringUtils.substringsBetween("one, two, three", "[", "]"); 
     assertNull(results); 
     results = StringUtils.substringsBetween("[one, two, three", "[", "]"); 
     assertNull(results); 
     results = StringUtils.substringsBetween("one, two, three]", "[", "]"); 
     assertNull(results); 
     results = StringUtils.substringsBetween("[one], [two], [three]", "[", null); 
     assertNull(results); 
     results = StringUtils.substringsBetween("[one], [two], [three]", null, "]"); 
     assertNull(results); 
     results = StringUtils.substringsBetween("[one], [two], [three]", "", ""); 
     assertNull(results); 
     results = StringUtils.substringsBetween(null, "[", "]"); 
     assertNull(results); 
     results = StringUtils.substringsBetween("", "[", "]"); 
     assertEquals(0, results.length); 
 }
@Test
public void testSubstring_StringIntInt7555() { 
     assertEquals(null, StringUtils.substring(null, 0, 0)); 
     assertEquals(null, StringUtils.substring(null, 1, 2)); 
     assertEquals("", StringUtils.substring("", 0, 0)); 
     assertEquals("", StringUtils.substring("", 1, 2)); 
     assertEquals("", StringUtils.substring("", -2, -1)); 
     assertEquals("", StringUtils.substring(SENTENCE, 8, 6)); 
     assertEquals(FOO, StringUtils.substring(SENTENCE, 0, 3)); 
     assertEquals("o", StringUtils.substring(SENTENCE, -9, 3)); 
     assertEquals(FOO, StringUtils.substring(SENTENCE, 0, -8)); 
     assertEquals("o", StringUtils.substring(SENTENCE, -9, -8)); 
     assertEquals(SENTENCE, StringUtils.substring(SENTENCE, 0, 80)); 
     assertEquals("", StringUtils.substring(SENTENCE, 2, 2)); 
     assertEquals("b", StringUtils.substring("abc", -2, -1)); 
 }
@Test
public void testSubstringsBetween_StringStringString7617() { 
     String[] results = StringUtils.substringsBetween("[one], [two], [three]", "[", "]"); 
     assertEquals(3, results.length); 
     assertEquals("one", results[0]); 
     assertEquals("two", results[1]); 
     assertEquals("three", results[2]); 
     results = StringUtils.substringsBetween("[one], [two], three", "[", "]"); 
     assertEquals(2, results.length); 
     assertEquals("one", results[0]); 
     assertEquals("two", results[1]); 
     results = StringUtils.substringsBetween("[one], [two], three]", "[", "]"); 
     assertEquals(2, results.length); 
     assertEquals("one", results[0]); 
     assertEquals("two", results[1]); 
     results = StringUtils.substringsBetween("[one], two], three]", "[", "]"); 
     assertEquals(1, results.length); 
     assertEquals("one", results[0]); 
     results = StringUtils.substringsBetween("one], two], [three]", "[", "]"); 
     assertEquals(1, results.length); 
     assertEquals("three", results[0]); 
     results = StringUtils.substringsBetween("aabhellobabnonba", "ab", "ba"); 
     assertEquals(1, results.length); 
     assertEquals("hello", results[0]); 
     results = StringUtils.substringsBetween("one, two, three", "[", "]"); 
     assertNull(results); 
     results = StringUtils.substringsBetween("[one, two, three", "[", "]"); 
     assertNull(results); 
     results = StringUtils.substringsBetween("one, two, three]", "[", "]"); 
     assertNull(results); 
     results = StringUtils.substringsBetween("[one], [two], [three]", "[", null); 
     assertNull(results); 
     results = StringUtils.substringsBetween("[one], [two], [three]", null, "]"); 
     assertNull(results); 
     results = StringUtils.substringsBetween("[one], [two], [three]", "", ""); 
     assertNull(results); 
     results = StringUtils.substringsBetween(null, "[", "]"); 
     assertNull(results); 
     results = StringUtils.substringsBetween("", "[", "]"); 
     assertEquals(0, results.length); 
 }
@Test
public void testSubstringsBetween_StringStringString7654() { 
     String[] results = StringUtils.substringsBetween("[one], [two], [three]", "[", "]"); 
     assertEquals(3, results.length); 
     assertEquals("one", results[0]); 
     assertEquals("two", results[1]); 
     assertEquals("three", results[2]); 
     results = StringUtils.substringsBetween("[one], [two], three", "[", "]"); 
     assertEquals(2, results.length); 
     assertEquals("one", results[0]); 
     assertEquals("two", results[1]); 
     results = StringUtils.substringsBetween("[one], [two], three]", "[", "]"); 
     assertEquals(2, results.length); 
     assertEquals("one", results[0]); 
     assertEquals("two", results[1]); 
     results = StringUtils.substringsBetween("[one], two], three]", "[", "]"); 
     assertEquals(1, results.length); 
     assertEquals("one", results[0]); 
     results = StringUtils.substringsBetween("one], two], [three]", "[", "]"); 
     assertEquals(1, results.length); 
     assertEquals("three", results[0]); 
     results = StringUtils.substringsBetween("aabhellobabnonba", "ab", "ba"); 
     assertEquals(1, results.length); 
     assertEquals("hello", results[0]); 
     results = StringUtils.substringsBetween("one, two, three", "[", "]"); 
     assertNull(results); 
     results = StringUtils.substringsBetween("[one, two, three", "[", "]"); 
     assertNull(results); 
     results = StringUtils.substringsBetween("one, two, three]", "[", "]"); 
     assertNull(results); 
     results = StringUtils.substringsBetween("[one], [two], [three]", "[", null); 
     assertNull(results); 
     results = StringUtils.substringsBetween("[one], [two], [three]", null, "]"); 
     assertNull(results); 
     results = StringUtils.substringsBetween("[one], [two], [three]", "", ""); 
     assertNull(results); 
     results = StringUtils.substringsBetween(null, "[", "]"); 
     assertNull(results); 
     results = StringUtils.substringsBetween("", "[", "]"); 
     assertEquals(0, results.length); 
 }
@Test
public void testSubstringBefore_StringString7798() { 
     assertEquals("foo", StringUtils.substringBefore("fooXXbarXXbaz", "XX")); 
     assertEquals(null, StringUtils.substringBefore(null, null)); 
     assertEquals(null, StringUtils.substringBefore(null, "")); 
     assertEquals(null, StringUtils.substringBefore(null, "XX")); 
     assertEquals("", StringUtils.substringBefore("", null)); 
     assertEquals("", StringUtils.substringBefore("", "")); 
     assertEquals("", StringUtils.substringBefore("", "XX")); 
     assertEquals("foo", StringUtils.substringBefore("foo", null)); 
     assertEquals("foo", StringUtils.substringBefore("foo", "b")); 
     assertEquals("f", StringUtils.substringBefore("foot", "o")); 
     assertEquals("", StringUtils.substringBefore("abc", "a")); 
     assertEquals("a", StringUtils.substringBefore("abcba", "b")); 
     assertEquals("ab", StringUtils.substringBefore("abc", "c")); 
     assertEquals("", StringUtils.substringBefore("abc", "")); 
 }
@Test
public void testSubstringAfter_StringString7882() { 
     assertEquals("barXXbaz", StringUtils.substringAfter("fooXXbarXXbaz", "XX")); 
     assertEquals(null, StringUtils.substringAfter(null, null)); 
     assertEquals(null, StringUtils.substringAfter(null, "")); 
     assertEquals(null, StringUtils.substringAfter(null, "XX")); 
     assertEquals("", StringUtils.substringAfter("", null)); 
     assertEquals("", StringUtils.substringAfter("", "")); 
     assertEquals("", StringUtils.substringAfter("", "XX")); 
     assertEquals("", StringUtils.substringAfter("foo", null)); 
     assertEquals("ot", StringUtils.substringAfter("foot", "o")); 
     assertEquals("bc", StringUtils.substringAfter("abc", "a")); 
     assertEquals("cba", StringUtils.substringAfter("abcba", "b")); 
     assertEquals("", StringUtils.substringAfter("abc", "c")); 
     assertEquals("abc", StringUtils.substringAfter("abc", "")); 
     assertEquals("", StringUtils.substringAfter("abc", "d")); 
 }
@Test
public void testSubstring_StringIntInt7909() { 
     assertEquals(null, StringUtils.substring(null, 0, 0)); 
     assertEquals(null, StringUtils.substring(null, 1, 2)); 
     assertEquals("", StringUtils.substring("", 0, 0)); 
     assertEquals("", StringUtils.substring("", 1, 2)); 
     assertEquals("", StringUtils.substring("", -2, -1)); 
     assertEquals("", StringUtils.substring(SENTENCE, 8, 6)); 
     assertEquals(FOO, StringUtils.substring(SENTENCE, 0, 3)); 
     assertEquals("o", StringUtils.substring(SENTENCE, -9, 3)); 
     assertEquals(FOO, StringUtils.substring(SENTENCE, 0, -8)); 
     assertEquals("o", StringUtils.substring(SENTENCE, -9, -8)); 
     assertEquals(SENTENCE, StringUtils.substring(SENTENCE, 0, 80)); 
     assertEquals("", StringUtils.substring(SENTENCE, 2, 2)); 
     assertEquals("b", StringUtils.substring("abc", -2, -1)); 
 }
@Test
public void testSubstring_StringIntInt7918() { 
     assertEquals(null, StringUtils.substring(null, 0, 0)); 
     assertEquals(null, StringUtils.substring(null, 1, 2)); 
     assertEquals("", StringUtils.substring("", 0, 0)); 
     assertEquals("", StringUtils.substring("", 1, 2)); 
     assertEquals("", StringUtils.substring("", -2, -1)); 
     assertEquals("", StringUtils.substring(SENTENCE, 8, 6)); 
     assertEquals(FOO, StringUtils.substring(SENTENCE, 0, 3)); 
     assertEquals("o", StringUtils.substring(SENTENCE, -9, 3)); 
     assertEquals(FOO, StringUtils.substring(SENTENCE, 0, -8)); 
     assertEquals("o", StringUtils.substring(SENTENCE, -9, -8)); 
     assertEquals(SENTENCE, StringUtils.substring(SENTENCE, 0, 80)); 
     assertEquals("", StringUtils.substring(SENTENCE, 2, 2)); 
     assertEquals("b", StringUtils.substring("abc", -2, -1)); 
 }
@Test
public void testSubstring_StringIntInt7972() { 
     assertEquals(null, StringUtils.substring(null, 0, 0)); 
     assertEquals(null, StringUtils.substring(null, 1, 2)); 
     assertEquals("", StringUtils.substring("", 0, 0)); 
     assertEquals("", StringUtils.substring("", 1, 2)); 
     assertEquals("", StringUtils.substring("", -2, -1)); 
     assertEquals("", StringUtils.substring(SENTENCE, 8, 6)); 
     assertEquals(FOO, StringUtils.substring(SENTENCE, 0, 3)); 
     assertEquals("o", StringUtils.substring(SENTENCE, -9, 3)); 
     assertEquals(FOO, StringUtils.substring(SENTENCE, 0, -8)); 
     assertEquals("o", StringUtils.substring(SENTENCE, -9, -8)); 
     assertEquals(SENTENCE, StringUtils.substring(SENTENCE, 0, 80)); 
     assertEquals("", StringUtils.substring(SENTENCE, 2, 2)); 
     assertEquals("b", StringUtils.substring("abc", -2, -1)); 
 }
@Test
public void testCountMatches_String8074() { 
     assertEquals(0, StringUtils.countMatches(null, null)); 
     assertEquals(0, StringUtils.countMatches("blah", null)); 
     assertEquals(0, StringUtils.countMatches(null, "DD")); 
     assertEquals(0, StringUtils.countMatches("x", "")); 
     assertEquals(0, StringUtils.countMatches("", "")); 
     assertEquals(3, StringUtils.countMatches("one long someone sentence of one", "one")); 
     assertEquals(0, StringUtils.countMatches("one long someone sentence of one", "two")); 
     assertEquals(4, StringUtils.countMatches("oooooooooooo", "ooo")); 
 }
@Test
public void testSubstringsBetween_StringStringString8211() { 
     String[] results = StringUtils.substringsBetween("[one], [two], [three]", "[", "]"); 
     assertEquals(3, results.length); 
     assertEquals("one", results[0]); 
     assertEquals("two", results[1]); 
     assertEquals("three", results[2]); 
     results = StringUtils.substringsBetween("[one], [two], three", "[", "]"); 
     assertEquals(2, results.length); 
     assertEquals("one", results[0]); 
     assertEquals("two", results[1]); 
     results = StringUtils.substringsBetween("[one], [two], three]", "[", "]"); 
     assertEquals(2, results.length); 
     assertEquals("one", results[0]); 
     assertEquals("two", results[1]); 
     results = StringUtils.substringsBetween("[one], two], three]", "[", "]"); 
     assertEquals(1, results.length); 
     assertEquals("one", results[0]); 
     results = StringUtils.substringsBetween("one], two], [three]", "[", "]"); 
     assertEquals(1, results.length); 
     assertEquals("three", results[0]); 
     results = StringUtils.substringsBetween("aabhellobabnonba", "ab", "ba"); 
     assertEquals(1, results.length); 
     assertEquals("hello", results[0]); 
     results = StringUtils.substringsBetween("one, two, three", "[", "]"); 
     assertNull(results); 
     results = StringUtils.substringsBetween("[one, two, three", "[", "]"); 
     assertNull(results); 
     results = StringUtils.substringsBetween("one, two, three]", "[", "]"); 
     assertNull(results); 
     results = StringUtils.substringsBetween("[one], [two], [three]", "[", null); 
     assertNull(results); 
     results = StringUtils.substringsBetween("[one], [two], [three]", null, "]"); 
     assertNull(results); 
     results = StringUtils.substringsBetween("[one], [two], [three]", "", ""); 
     assertNull(results); 
     results = StringUtils.substringsBetween(null, "[", "]"); 
     assertNull(results); 
     results = StringUtils.substringsBetween("", "[", "]"); 
     assertEquals(0, results.length); 
 }
@Test
public void testSubstringsBetween_StringStringString8242() { 
     String[] results = StringUtils.substringsBetween("[one], [two], [three]", "[", "]"); 
     assertEquals(3, results.length); 
     assertEquals("one", results[0]); 
     assertEquals("two", results[1]); 
     assertEquals("three", results[2]); 
     results = StringUtils.substringsBetween("[one], [two], three", "[", "]"); 
     assertEquals(2, results.length); 
     assertEquals("one", results[0]); 
     assertEquals("two", results[1]); 
     results = StringUtils.substringsBetween("[one], [two], three]", "[", "]"); 
     assertEquals(2, results.length); 
     assertEquals("one", results[0]); 
     assertEquals("two", results[1]); 
     results = StringUtils.substringsBetween("[one], two], three]", "[", "]"); 
     assertEquals(1, results.length); 
     assertEquals("one", results[0]); 
     results = StringUtils.substringsBetween("one], two], [three]", "[", "]"); 
     assertEquals(1, results.length); 
     assertEquals("three", results[0]); 
     results = StringUtils.substringsBetween("aabhellobabnonba", "ab", "ba"); 
     assertEquals(1, results.length); 
     assertEquals("hello", results[0]); 
     results = StringUtils.substringsBetween("one, two, three", "[", "]"); 
     assertNull(results); 
     results = StringUtils.substringsBetween("[one, two, three", "[", "]"); 
     assertNull(results); 
     results = StringUtils.substringsBetween("one, two, three]", "[", "]"); 
     assertNull(results); 
     results = StringUtils.substringsBetween("[one], [two], [three]", "[", null); 
     assertNull(results); 
     results = StringUtils.substringsBetween("[one], [two], [three]", null, "]"); 
     assertNull(results); 
     results = StringUtils.substringsBetween("[one], [two], [three]", "", ""); 
     assertNull(results); 
     results = StringUtils.substringsBetween(null, "[", "]"); 
     assertNull(results); 
     results = StringUtils.substringsBetween("", "[", "]"); 
     assertEquals(0, results.length); 
 }
@Test
public void testSubstring_StringInt8280() { 
     assertEquals(null, StringUtils.substring(null, 0)); 
     assertEquals("", StringUtils.substring("", 0)); 
     assertEquals("", StringUtils.substring("", 2)); 
     assertEquals("", StringUtils.substring(SENTENCE, 80)); 
     assertEquals(BAZ, StringUtils.substring(SENTENCE, 8)); 
     assertEquals(BAZ, StringUtils.substring(SENTENCE, -3)); 
     assertEquals(SENTENCE, StringUtils.substring(SENTENCE, 0)); 
     assertEquals("abc", StringUtils.substring("abc", -4)); 
     assertEquals("abc", StringUtils.substring("abc", -3)); 
     assertEquals("bc", StringUtils.substring("abc", -2)); 
     assertEquals("c", StringUtils.substring("abc", -1)); 
     assertEquals("abc", StringUtils.substring("abc", 0)); 
     assertEquals("bc", StringUtils.substring("abc", 1)); 
     assertEquals("c", StringUtils.substring("abc", 2)); 
     assertEquals("", StringUtils.substring("abc", 3)); 
     assertEquals("", StringUtils.substring("abc", 4)); 
 }
@Test
public void testSubstringAfter_StringString8288() { 
     assertEquals("barXXbaz", StringUtils.substringAfter("fooXXbarXXbaz", "XX")); 
     assertEquals(null, StringUtils.substringAfter(null, null)); 
     assertEquals(null, StringUtils.substringAfter(null, "")); 
     assertEquals(null, StringUtils.substringAfter(null, "XX")); 
     assertEquals("", StringUtils.substringAfter("", null)); 
     assertEquals("", StringUtils.substringAfter("", "")); 
     assertEquals("", StringUtils.substringAfter("", "XX")); 
     assertEquals("", StringUtils.substringAfter("foo", null)); 
     assertEquals("ot", StringUtils.substringAfter("foot", "o")); 
     assertEquals("bc", StringUtils.substringAfter("abc", "a")); 
     assertEquals("cba", StringUtils.substringAfter("abcba", "b")); 
     assertEquals("", StringUtils.substringAfter("abc", "c")); 
     assertEquals("abc", StringUtils.substringAfter("abc", "")); 
     assertEquals("", StringUtils.substringAfter("abc", "d")); 
 }
@Test
public void testSubstringBetween_StringStringString8406() { 
     assertEquals(null, StringUtils.substringBetween(null, "", "")); 
     assertEquals(null, StringUtils.substringBetween("", null, "")); 
     assertEquals(null, StringUtils.substringBetween("", "", null)); 
     assertEquals("", StringUtils.substringBetween("", "", "")); 
     assertEquals("", StringUtils.substringBetween("foo", "", "")); 
     assertEquals(null, StringUtils.substringBetween("foo", "", "]")); 
     assertEquals(null, StringUtils.substringBetween("foo", "[", "]")); 
     assertEquals("", StringUtils.substringBetween("    ", " ", "  ")); 
     assertEquals("bar", StringUtils.substringBetween("<foo>bar</foo>", "<foo>", "</foo>")); 
 }
@Test
public void testSubstringBeforeLast_StringString8591() { 
     assertEquals("fooXXbar", StringUtils.substringBeforeLast("fooXXbarXXbaz", "XX")); 
     assertEquals(null, StringUtils.substringBeforeLast(null, null)); 
     assertEquals(null, StringUtils.substringBeforeLast(null, "")); 
     assertEquals(null, StringUtils.substringBeforeLast(null, "XX")); 
     assertEquals("", StringUtils.substringBeforeLast("", null)); 
     assertEquals("", StringUtils.substringBeforeLast("", "")); 
     assertEquals("", StringUtils.substringBeforeLast("", "XX")); 
     assertEquals("foo", StringUtils.substringBeforeLast("foo", null)); 
     assertEquals("foo", StringUtils.substringBeforeLast("foo", "b")); 
     assertEquals("fo", StringUtils.substringBeforeLast("foo", "o")); 
     assertEquals("abc\r\n", StringUtils.substringBeforeLast("abc\r\n", "d")); 
     assertEquals("abc", StringUtils.substringBeforeLast("abcdabc", "d")); 
     assertEquals("abcdabc", StringUtils.substringBeforeLast("abcdabcd", "d")); 
     assertEquals("a", StringUtils.substringBeforeLast("abc", "b")); 
     assertEquals("abc ", StringUtils.substringBeforeLast("abc \n", "\n")); 
     assertEquals("a", StringUtils.substringBeforeLast("a", null)); 
     assertEquals("a", StringUtils.substringBeforeLast("a", "")); 
     assertEquals("", StringUtils.substringBeforeLast("a", "a")); 
 }
@Test
public void testLeft_String8722() { 
     assertSame(null, StringUtils.left(null, -1)); 
     assertSame(null, StringUtils.left(null, 0)); 
     assertSame(null, StringUtils.left(null, 2)); 
     assertEquals("", StringUtils.left("", -1)); 
     assertEquals("", StringUtils.left("", 0)); 
     assertEquals("", StringUtils.left("", 2)); 
     assertEquals("", StringUtils.left(FOOBAR, -1)); 
     assertEquals("", StringUtils.left(FOOBAR, 0)); 
     assertEquals(FOO, StringUtils.left(FOOBAR, 3)); 
     assertSame(FOOBAR, StringUtils.left(FOOBAR, 80)); 
 }
@Test
public void testSubstringBefore_StringString8737() { 
     assertEquals("foo", StringUtils.substringBefore("fooXXbarXXbaz", "XX")); 
     assertEquals(null, StringUtils.substringBefore(null, null)); 
     assertEquals(null, StringUtils.substringBefore(null, "")); 
     assertEquals(null, StringUtils.substringBefore(null, "XX")); 
     assertEquals("", StringUtils.substringBefore("", null)); 
     assertEquals("", StringUtils.substringBefore("", "")); 
     assertEquals("", StringUtils.substringBefore("", "XX")); 
     assertEquals("foo", StringUtils.substringBefore("foo", null)); 
     assertEquals("foo", StringUtils.substringBefore("foo", "b")); 
     assertEquals("f", StringUtils.substringBefore("foot", "o")); 
     assertEquals("", StringUtils.substringBefore("abc", "a")); 
     assertEquals("a", StringUtils.substringBefore("abcba", "b")); 
     assertEquals("ab", StringUtils.substringBefore("abc", "c")); 
     assertEquals("", StringUtils.substringBefore("abc", "")); 
 }
@Test
public void testSubstringsBetween_StringStringString8768() { 
     String[] results = StringUtils.substringsBetween("[one], [two], [three]", "[", "]"); 
     assertEquals(3, results.length); 
     assertEquals("one", results[0]); 
     assertEquals("two", results[1]); 
     assertEquals("three", results[2]); 
     results = StringUtils.substringsBetween("[one], [two], three", "[", "]"); 
     assertEquals(2, results.length); 
     assertEquals("one", results[0]); 
     assertEquals("two", results[1]); 
     results = StringUtils.substringsBetween("[one], [two], three]", "[", "]"); 
     assertEquals(2, results.length); 
     assertEquals("one", results[0]); 
     assertEquals("two", results[1]); 
     results = StringUtils.substringsBetween("[one], two], three]", "[", "]"); 
     assertEquals(1, results.length); 
     assertEquals("one", results[0]); 
     results = StringUtils.substringsBetween("one], two], [three]", "[", "]"); 
     assertEquals(1, results.length); 
     assertEquals("three", results[0]); 
     results = StringUtils.substringsBetween("aabhellobabnonba", "ab", "ba"); 
     assertEquals(1, results.length); 
     assertEquals("hello", results[0]); 
     results = StringUtils.substringsBetween("one, two, three", "[", "]"); 
     assertNull(results); 
     results = StringUtils.substringsBetween("[one, two, three", "[", "]"); 
     assertNull(results); 
     results = StringUtils.substringsBetween("one, two, three]", "[", "]"); 
     assertNull(results); 
     results = StringUtils.substringsBetween("[one], [two], [three]", "[", null); 
     assertNull(results); 
     results = StringUtils.substringsBetween("[one], [two], [three]", null, "]"); 
     assertNull(results); 
     results = StringUtils.substringsBetween("[one], [two], [three]", "", ""); 
     assertNull(results); 
     results = StringUtils.substringsBetween(null, "[", "]"); 
     assertNull(results); 
     results = StringUtils.substringsBetween("", "[", "]"); 
     assertEquals(0, results.length); 
 }
@Test
public void testSubstring_StringIntInt8838() { 
     assertEquals(null, StringUtils.substring(null, 0, 0)); 
     assertEquals(null, StringUtils.substring(null, 1, 2)); 
     assertEquals("", StringUtils.substring("", 0, 0)); 
     assertEquals("", StringUtils.substring("", 1, 2)); 
     assertEquals("", StringUtils.substring("", -2, -1)); 
     assertEquals("", StringUtils.substring(SENTENCE, 8, 6)); 
     assertEquals(FOO, StringUtils.substring(SENTENCE, 0, 3)); 
     assertEquals("o", StringUtils.substring(SENTENCE, -9, 3)); 
     assertEquals(FOO, StringUtils.substring(SENTENCE, 0, -8)); 
     assertEquals("o", StringUtils.substring(SENTENCE, -9, -8)); 
     assertEquals(SENTENCE, StringUtils.substring(SENTENCE, 0, 80)); 
     assertEquals("", StringUtils.substring(SENTENCE, 2, 2)); 
     assertEquals("b", StringUtils.substring("abc", -2, -1)); 
 }
@Test
public void testSubstringBetween_StringStringString8968() { 
     assertEquals(null, StringUtils.substringBetween(null, "", "")); 
     assertEquals(null, StringUtils.substringBetween("", null, "")); 
     assertEquals(null, StringUtils.substringBetween("", "", null)); 
     assertEquals("", StringUtils.substringBetween("", "", "")); 
     assertEquals("", StringUtils.substringBetween("foo", "", "")); 
     assertEquals(null, StringUtils.substringBetween("foo", "", "]")); 
     assertEquals(null, StringUtils.substringBetween("foo", "[", "]")); 
     assertEquals("", StringUtils.substringBetween("    ", " ", "  ")); 
     assertEquals("bar", StringUtils.substringBetween("<foo>bar</foo>", "<foo>", "</foo>")); 
 }
@Test
public void testSubstringBeforeLast_StringString9024() { 
     assertEquals("fooXXbar", StringUtils.substringBeforeLast("fooXXbarXXbaz", "XX")); 
     assertEquals(null, StringUtils.substringBeforeLast(null, null)); 
     assertEquals(null, StringUtils.substringBeforeLast(null, "")); 
     assertEquals(null, StringUtils.substringBeforeLast(null, "XX")); 
     assertEquals("", StringUtils.substringBeforeLast("", null)); 
     assertEquals("", StringUtils.substringBeforeLast("", "")); 
     assertEquals("", StringUtils.substringBeforeLast("", "XX")); 
     assertEquals("foo", StringUtils.substringBeforeLast("foo", null)); 
     assertEquals("foo", StringUtils.substringBeforeLast("foo", "b")); 
     assertEquals("fo", StringUtils.substringBeforeLast("foo", "o")); 
     assertEquals("abc\r\n", StringUtils.substringBeforeLast("abc\r\n", "d")); 
     assertEquals("abc", StringUtils.substringBeforeLast("abcdabc", "d")); 
     assertEquals("abcdabc", StringUtils.substringBeforeLast("abcdabcd", "d")); 
     assertEquals("a", StringUtils.substringBeforeLast("abc", "b")); 
     assertEquals("abc ", StringUtils.substringBeforeLast("abc \n", "\n")); 
     assertEquals("a", StringUtils.substringBeforeLast("a", null)); 
     assertEquals("a", StringUtils.substringBeforeLast("a", "")); 
     assertEquals("", StringUtils.substringBeforeLast("a", "a")); 
 }
@Test
public void testSubstringAfter_StringString9045() { 
     assertEquals("barXXbaz", StringUtils.substringAfter("fooXXbarXXbaz", "XX")); 
     assertEquals(null, StringUtils.substringAfter(null, null)); 
     assertEquals(null, StringUtils.substringAfter(null, "")); 
     assertEquals(null, StringUtils.substringAfter(null, "XX")); 
     assertEquals("", StringUtils.substringAfter("", null)); 
     assertEquals("", StringUtils.substringAfter("", "")); 
     assertEquals("", StringUtils.substringAfter("", "XX")); 
     assertEquals("", StringUtils.substringAfter("foo", null)); 
     assertEquals("ot", StringUtils.substringAfter("foot", "o")); 
     assertEquals("bc", StringUtils.substringAfter("abc", "a")); 
     assertEquals("cba", StringUtils.substringAfter("abcba", "b")); 
     assertEquals("", StringUtils.substringAfter("abc", "c")); 
     assertEquals("abc", StringUtils.substringAfter("abc", "")); 
     assertEquals("", StringUtils.substringAfter("abc", "d")); 
 }
@Test
public void testSubstringsBetween_StringStringString9057() { 
     String[] results = StringUtils.substringsBetween("[one], [two], [three]", "[", "]"); 
     assertEquals(3, results.length); 
     assertEquals("one", results[0]); 
     assertEquals("two", results[1]); 
     assertEquals("three", results[2]); 
     results = StringUtils.substringsBetween("[one], [two], three", "[", "]"); 
     assertEquals(2, results.length); 
     assertEquals("one", results[0]); 
     assertEquals("two", results[1]); 
     results = StringUtils.substringsBetween("[one], [two], three]", "[", "]"); 
     assertEquals(2, results.length); 
     assertEquals("one", results[0]); 
     assertEquals("two", results[1]); 
     results = StringUtils.substringsBetween("[one], two], three]", "[", "]"); 
     assertEquals(1, results.length); 
     assertEquals("one", results[0]); 
     results = StringUtils.substringsBetween("one], two], [three]", "[", "]"); 
     assertEquals(1, results.length); 
     assertEquals("three", results[0]); 
     results = StringUtils.substringsBetween("aabhellobabnonba", "ab", "ba"); 
     assertEquals(1, results.length); 
     assertEquals("hello", results[0]); 
     results = StringUtils.substringsBetween("one, two, three", "[", "]"); 
     assertNull(results); 
     results = StringUtils.substringsBetween("[one, two, three", "[", "]"); 
     assertNull(results); 
     results = StringUtils.substringsBetween("one, two, three]", "[", "]"); 
     assertNull(results); 
     results = StringUtils.substringsBetween("[one], [two], [three]", "[", null); 
     assertNull(results); 
     results = StringUtils.substringsBetween("[one], [two], [three]", null, "]"); 
     assertNull(results); 
     results = StringUtils.substringsBetween("[one], [two], [three]", "", ""); 
     assertNull(results); 
     results = StringUtils.substringsBetween(null, "[", "]"); 
     assertNull(results); 
     results = StringUtils.substringsBetween("", "[", "]"); 
     assertEquals(0, results.length); 
 }
@Test
public void testSubstringAfterLast_StringString9064() { 
     assertEquals("baz", StringUtils.substringAfterLast("fooXXbarXXbaz", "XX")); 
     assertEquals(null, StringUtils.substringAfterLast(null, null)); 
     assertEquals(null, StringUtils.substringAfterLast(null, "")); 
     assertEquals(null, StringUtils.substringAfterLast(null, "XX")); 
     assertEquals("", StringUtils.substringAfterLast("", null)); 
     assertEquals("", StringUtils.substringAfterLast("", "")); 
     assertEquals("", StringUtils.substringAfterLast("", "a")); 
     assertEquals("", StringUtils.substringAfterLast("foo", null)); 
     assertEquals("", StringUtils.substringAfterLast("foo", "b")); 
     assertEquals("t", StringUtils.substringAfterLast("foot", "o")); 
     assertEquals("bc", StringUtils.substringAfterLast("abc", "a")); 
     assertEquals("a", StringUtils.substringAfterLast("abcba", "b")); 
     assertEquals("", StringUtils.substringAfterLast("abc", "c")); 
     assertEquals("", StringUtils.substringAfterLast("", "d")); 
     assertEquals("", StringUtils.substringAfterLast("abc", "")); 
 }
@Test
public void testSubstring_StringInt9187() { 
     assertEquals(null, StringUtils.substring(null, 0)); 
     assertEquals("", StringUtils.substring("", 0)); 
     assertEquals("", StringUtils.substring("", 2)); 
     assertEquals("", StringUtils.substring(SENTENCE, 80)); 
     assertEquals(BAZ, StringUtils.substring(SENTENCE, 8)); 
     assertEquals(BAZ, StringUtils.substring(SENTENCE, -3)); 
     assertEquals(SENTENCE, StringUtils.substring(SENTENCE, 0)); 
     assertEquals("abc", StringUtils.substring("abc", -4)); 
     assertEquals("abc", StringUtils.substring("abc", -3)); 
     assertEquals("bc", StringUtils.substring("abc", -2)); 
     assertEquals("c", StringUtils.substring("abc", -1)); 
     assertEquals("abc", StringUtils.substring("abc", 0)); 
     assertEquals("bc", StringUtils.substring("abc", 1)); 
     assertEquals("c", StringUtils.substring("abc", 2)); 
     assertEquals("", StringUtils.substring("abc", 3)); 
     assertEquals("", StringUtils.substring("abc", 4)); 
 }
@Test
public void testSubstringBetween_StringString9216() { 
     assertEquals(null, StringUtils.substringBetween(null, "tag")); 
     assertEquals("", StringUtils.substringBetween("", "")); 
     assertEquals(null, StringUtils.substringBetween("", "abc")); 
     assertEquals("", StringUtils.substringBetween("    ", " ")); 
     assertEquals(null, StringUtils.substringBetween("abc", null)); 
     assertEquals("", StringUtils.substringBetween("abc", "")); 
     assertEquals(null, StringUtils.substringBetween("abc", "a")); 
     assertEquals("bc", StringUtils.substringBetween("abca", "a")); 
     assertEquals("bc", StringUtils.substringBetween("abcabca", "a")); 
     assertEquals("bar", StringUtils.substringBetween("\nbar\n", "\n")); 
 }
@Test
public void testSubstring_StringIntInt9395() { 
     assertEquals(null, StringUtils.substring(null, 0, 0)); 
     assertEquals(null, StringUtils.substring(null, 1, 2)); 
     assertEquals("", StringUtils.substring("", 0, 0)); 
     assertEquals("", StringUtils.substring("", 1, 2)); 
     assertEquals("", StringUtils.substring("", -2, -1)); 
     assertEquals("", StringUtils.substring(SENTENCE, 8, 6)); 
     assertEquals(FOO, StringUtils.substring(SENTENCE, 0, 3)); 
     assertEquals("o", StringUtils.substring(SENTENCE, -9, 3)); 
     assertEquals(FOO, StringUtils.substring(SENTENCE, 0, -8)); 
     assertEquals("o", StringUtils.substring(SENTENCE, -9, -8)); 
     assertEquals(SENTENCE, StringUtils.substring(SENTENCE, 0, 80)); 
     assertEquals("", StringUtils.substring(SENTENCE, 2, 2)); 
     assertEquals("b", StringUtils.substring("abc", -2, -1)); 
 }
@Test
public void testSubstring_StringInt9410() { 
     assertEquals(null, StringUtils.substring(null, 0)); 
     assertEquals("", StringUtils.substring("", 0)); 
     assertEquals("", StringUtils.substring("", 2)); 
     assertEquals("", StringUtils.substring(SENTENCE, 80)); 
     assertEquals(BAZ, StringUtils.substring(SENTENCE, 8)); 
     assertEquals(BAZ, StringUtils.substring(SENTENCE, -3)); 
     assertEquals(SENTENCE, StringUtils.substring(SENTENCE, 0)); 
     assertEquals("abc", StringUtils.substring("abc", -4)); 
     assertEquals("abc", StringUtils.substring("abc", -3)); 
     assertEquals("bc", StringUtils.substring("abc", -2)); 
     assertEquals("c", StringUtils.substring("abc", -1)); 
     assertEquals("abc", StringUtils.substring("abc", 0)); 
     assertEquals("bc", StringUtils.substring("abc", 1)); 
     assertEquals("c", StringUtils.substring("abc", 2)); 
     assertEquals("", StringUtils.substring("abc", 3)); 
     assertEquals("", StringUtils.substring("abc", 4)); 
 }
@Test
public void testLeft_String9487() { 
     assertSame(null, StringUtils.left(null, -1)); 
     assertSame(null, StringUtils.left(null, 0)); 
     assertSame(null, StringUtils.left(null, 2)); 
     assertEquals("", StringUtils.left("", -1)); 
     assertEquals("", StringUtils.left("", 0)); 
     assertEquals("", StringUtils.left("", 2)); 
     assertEquals("", StringUtils.left(FOOBAR, -1)); 
     assertEquals("", StringUtils.left(FOOBAR, 0)); 
     assertEquals(FOO, StringUtils.left(FOOBAR, 3)); 
     assertSame(FOOBAR, StringUtils.left(FOOBAR, 80)); 
 }
@Test
public void testMid_String9492() { 
     assertSame(null, StringUtils.mid(null, -1, 0)); 
     assertSame(null, StringUtils.mid(null, 0, -1)); 
     assertSame(null, StringUtils.mid(null, 3, 0)); 
     assertSame(null, StringUtils.mid(null, 3, 2)); 
     assertEquals("", StringUtils.mid("", 0, -1)); 
     assertEquals("", StringUtils.mid("", 0, 0)); 
     assertEquals("", StringUtils.mid("", 0, 2)); 
     assertEquals("", StringUtils.mid(FOOBAR, 3, -1)); 
     assertEquals("", StringUtils.mid(FOOBAR, 3, 0)); 
     assertEquals("b", StringUtils.mid(FOOBAR, 3, 1)); 
     assertEquals(FOO, StringUtils.mid(FOOBAR, 0, 3)); 
     assertEquals(BAR, StringUtils.mid(FOOBAR, 3, 3)); 
     assertEquals(FOOBAR, StringUtils.mid(FOOBAR, 0, 80)); 
     assertEquals(BAR, StringUtils.mid(FOOBAR, 3, 80)); 
     assertEquals("", StringUtils.mid(FOOBAR, 9, 3)); 
     assertEquals(FOO, StringUtils.mid(FOOBAR, -1, 3)); 
 }
@Test
public void testSubstringAfterLast_StringString9551() { 
     assertEquals("baz", StringUtils.substringAfterLast("fooXXbarXXbaz", "XX")); 
     assertEquals(null, StringUtils.substringAfterLast(null, null)); 
     assertEquals(null, StringUtils.substringAfterLast(null, "")); 
     assertEquals(null, StringUtils.substringAfterLast(null, "XX")); 
     assertEquals("", StringUtils.substringAfterLast("", null)); 
     assertEquals("", StringUtils.substringAfterLast("", "")); 
     assertEquals("", StringUtils.substringAfterLast("", "a")); 
     assertEquals("", StringUtils.substringAfterLast("foo", null)); 
     assertEquals("", StringUtils.substringAfterLast("foo", "b")); 
     assertEquals("t", StringUtils.substringAfterLast("foot", "o")); 
     assertEquals("bc", StringUtils.substringAfterLast("abc", "a")); 
     assertEquals("a", StringUtils.substringAfterLast("abcba", "b")); 
     assertEquals("", StringUtils.substringAfterLast("abc", "c")); 
     assertEquals("", StringUtils.substringAfterLast("", "d")); 
     assertEquals("", StringUtils.substringAfterLast("abc", "")); 
 }
    
    
    
           
    
    
    
    
    
    
    //-----------------------------------------------------------------------
    
    
    

    
    
            
        
    //-----------------------------------------------------------------------
    
            
    

   /**
     * Tests the substringsBetween method that returns an String Array of substrings.
     */
    

    //-----------------------------------------------------------------------
    

}
