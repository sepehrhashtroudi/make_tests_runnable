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

import org.junit.Test;
import static org.junit.Assert.*;
import org.apache.commons.lang3.text.StrBuilder;

/**
 * Unit tests {@link org.apache.commons.lang3.StringUtils} - StartsWith/EndsWith methods
 *
 * @version $Id$
 */
public class StringUtilsStartsEndsWithTest {
    private static final String foo    = "foo";
    private static final String bar    = "bar";
    private static final String foobar = "foobar";
    private static final String FOO    = "FOO";
    private static final String BAR    = "BAR";
    private static final String FOOBAR = "FOOBAR";

    //-----------------------------------------------------------------------

    /**
     * Test StringUtils.startsWith()
     */
@Test
public void testStartsWithAny47() { 
     assertFalse(StringUtils.startsWithAny(null, (String[]) null)); 
     assertFalse(StringUtils.startsWithAny(null, "abc")); 
     assertFalse(StringUtils.startsWithAny("abcxyz", (String[]) null)); 
     assertFalse(StringUtils.startsWithAny("abcxyz")); 
     assertTrue(StringUtils.startsWithAny("abcxyz", "abc")); 
     assertTrue(StringUtils.startsWithAny("abcxyz", null, "xyz", "abc")); 
     assertFalse(StringUtils.startsWithAny("abcxyz", null, "xyz", "abcd")); 
     assertTrue("StringUtils.startsWithAny(abcxyz, StringBuilder(xyz), StringBuffer(abc))", StringUtils.startsWithAny("abcxyz", new StringBuilder("xyz"), new StringBuffer("abc"))); 
     assertTrue("StringUtils.startsWithAny( StrBuilder(abcxyz), StringBuilder(xyz), StringBuffer(abc))", StringUtils.startsWithAny(new StrBuilder("abcxyz"), new StringBuilder("xyz"), new StringBuffer("abc"))); 
 }
@Test
public void testEndsWithAny645() { 
     assertFalse("StringUtils.endsWithAny(null, null)", StringUtils.endsWithAny(null, (String) null)); 
     assertFalse("StringUtils.endsWithAny(null, new String[] {abc})", StringUtils.endsWithAny(null, new String[] { "abc" })); 
     assertFalse("StringUtils.endsWithAny(abcxyz, null)", StringUtils.endsWithAny("abcxyz", (String) null)); 
     assertTrue("StringUtils.endsWithAny(abcxyz, new String[] {\"\"})", StringUtils.endsWithAny("abcxyz", new String[] { "" })); 
     assertTrue("StringUtils.endsWithAny(abcxyz, new String[] {xyz})", StringUtils.endsWithAny("abcxyz", new String[] { "xyz" })); 
     assertTrue("StringUtils.endsWithAny(abcxyz, new String[] {null, xyz, abc})", StringUtils.endsWithAny("abcxyz", new String[] { null, "xyz", "abc" })); 
     assertFalse("StringUtils.endsWithAny(defg, new String[] {null, xyz, abc})", StringUtils.endsWithAny("defg", new String[] { null, "xyz", "abc" })); 
     assertTrue("StringUtils.endsWithAny(abcxyz, StringBuilder(abc), StringBuffer(xyz))", StringUtils.endsWithAny("abcxyz", new StringBuilder("abc"), new StringBuffer("xyz"))); 
     assertTrue("StringUtils.endsWithAny( StrBuilder(abcxyz), StringBuilder(abc), StringBuffer(xyz))", StringUtils.endsWithAny(new StrBuilder("abcxyz"), new StringBuilder("abc"), new StringBuffer("xyz"))); 
 }
@Test
public void testStartsWithIgnoreCase814() { 
     assertTrue("startsWithIgnoreCase(null, null)", StringUtils.startsWithIgnoreCase(null, (String) null)); 
     assertFalse("startsWithIgnoreCase(FOOBAR, null)", StringUtils.startsWithIgnoreCase(FOOBAR, (String) null)); 
     assertFalse("startsWithIgnoreCase(null, FOO)", StringUtils.startsWithIgnoreCase(null, FOO)); 
     assertTrue("startsWithIgnoreCase(FOOBAR, \"\")", StringUtils.startsWithIgnoreCase(FOOBAR, "")); 
     assertTrue("startsWithIgnoreCase(foobar, foo)", StringUtils.startsWithIgnoreCase(foobar, foo)); 
     assertTrue("startsWithIgnoreCase(FOOBAR, FOO)", StringUtils.startsWithIgnoreCase(FOOBAR, FOO)); 
     assertTrue("startsWithIgnoreCase(foobar, FOO)", StringUtils.startsWithIgnoreCase(foobar, FOO)); 
     assertTrue("startsWithIgnoreCase(FOOBAR, foo)", StringUtils.startsWithIgnoreCase(FOOBAR, foo)); 
     assertFalse("startsWithIgnoreCase(foo, foobar)", StringUtils.startsWithIgnoreCase(foo, foobar)); 
     assertFalse("startsWithIgnoreCase(foo, foobar)", StringUtils.startsWithIgnoreCase(bar, foobar)); 
     assertFalse("startsWithIgnoreCase(foobar, bar)", StringUtils.startsWithIgnoreCase(foobar, bar)); 
     assertFalse("startsWithIgnoreCase(FOOBAR, BAR)", StringUtils.startsWithIgnoreCase(FOOBAR, BAR)); 
     assertFalse("startsWithIgnoreCase(foobar, BAR)", StringUtils.startsWithIgnoreCase(foobar, BAR)); 
     assertFalse("startsWithIgnoreCase(FOOBAR, bar)", StringUtils.startsWithIgnoreCase(FOOBAR, bar)); 
 }
@Test
public void testEndsWithAny1050() { 
     assertFalse("StringUtils.endsWithAny(null, null)", StringUtils.endsWithAny(null, (String) null)); 
     assertFalse("StringUtils.endsWithAny(null, new String[] {abc})", StringUtils.endsWithAny(null, new String[] { "abc" })); 
     assertFalse("StringUtils.endsWithAny(abcxyz, null)", StringUtils.endsWithAny("abcxyz", (String) null)); 
     assertTrue("StringUtils.endsWithAny(abcxyz, new String[] {\"\"})", StringUtils.endsWithAny("abcxyz", new String[] { "" })); 
     assertTrue("StringUtils.endsWithAny(abcxyz, new String[] {xyz})", StringUtils.endsWithAny("abcxyz", new String[] { "xyz" })); 
     assertTrue("StringUtils.endsWithAny(abcxyz, new String[] {null, xyz, abc})", StringUtils.endsWithAny("abcxyz", new String[] { null, "xyz", "abc" })); 
     assertFalse("StringUtils.endsWithAny(defg, new String[] {null, xyz, abc})", StringUtils.endsWithAny("defg", new String[] { null, "xyz", "abc" })); 
     assertTrue("StringUtils.endsWithAny(abcxyz, StringBuilder(abc), StringBuffer(xyz))", StringUtils.endsWithAny("abcxyz", new StringBuilder("abc"), new StringBuffer("xyz"))); 
     assertTrue("StringUtils.endsWithAny( StrBuilder(abcxyz), StringBuilder(abc), StringBuffer(xyz))", StringUtils.endsWithAny(new StrBuilder("abcxyz"), new StringBuilder("abc"), new StringBuffer("xyz"))); 
 }
@Test
public void testEndsWithIgnoreCase1298() { 
     assertTrue("endsWithIgnoreCase(null, null)", StringUtils.endsWithIgnoreCase(null, (String) null)); 
     assertFalse("endsWithIgnoreCase(FOOBAR, null)", StringUtils.endsWithIgnoreCase(FOOBAR, (String) null)); 
     assertFalse("endsWithIgnoreCase(null, FOO)", StringUtils.endsWithIgnoreCase(null, FOO)); 
     assertTrue("endsWithIgnoreCase(FOOBAR, \"\")", StringUtils.endsWithIgnoreCase(FOOBAR, "")); 
     assertFalse("endsWithIgnoreCase(foobar, foo)", StringUtils.endsWithIgnoreCase(foobar, foo)); 
     assertFalse("endsWithIgnoreCase(FOOBAR, FOO)", StringUtils.endsWithIgnoreCase(FOOBAR, FOO)); 
     assertFalse("endsWithIgnoreCase(foobar, FOO)", StringUtils.endsWithIgnoreCase(foobar, FOO)); 
     assertFalse("endsWithIgnoreCase(FOOBAR, foo)", StringUtils.endsWithIgnoreCase(FOOBAR, foo)); 
     assertFalse("endsWithIgnoreCase(foo, foobar)", StringUtils.endsWithIgnoreCase(foo, foobar)); 
     assertFalse("endsWithIgnoreCase(foo, foobar)", StringUtils.endsWithIgnoreCase(bar, foobar)); 
     assertTrue("endsWithIgnoreCase(foobar, bar)", StringUtils.endsWithIgnoreCase(foobar, bar)); 
     assertTrue("endsWithIgnoreCase(FOOBAR, BAR)", StringUtils.endsWithIgnoreCase(FOOBAR, BAR)); 
     assertTrue("endsWithIgnoreCase(foobar, BAR)", StringUtils.endsWithIgnoreCase(foobar, BAR)); 
     assertTrue("endsWithIgnoreCase(FOOBAR, bar)", StringUtils.endsWithIgnoreCase(FOOBAR, bar)); 
     assertTrue(StringUtils.endsWithIgnoreCase("abcdef", "def")); 
     assertTrue(StringUtils.endsWithIgnoreCase("ABCDEF", "def")); 
     assertFalse(StringUtils.endsWithIgnoreCase("ABCDEF", "cde")); 
     assertTrue("endsWith(\u03B1\u03B2\u03B3\u03B4, \u0394)", StringUtils.endsWithIgnoreCase("\u03B1\u03B2\u03B3\u03B4", "\u0394")); 
     assertFalse("endsWith(\u03B1\u03B2\u03B3\u03B4, \u0393)", StringUtils.endsWithIgnoreCase("\u03B1\u03B2\u03B3\u03B4", "\u0393")); 
 }
@Test
public void testEndsWithAny1344() { 
     assertFalse("StringUtils.endsWithAny(null, null)", StringUtils.endsWithAny(null, (String) null)); 
     assertFalse("StringUtils.endsWithAny(null, new String[] {abc})", StringUtils.endsWithAny(null, new String[] { "abc" })); 
     assertFalse("StringUtils.endsWithAny(abcxyz, null)", StringUtils.endsWithAny("abcxyz", (String) null)); 
     assertTrue("StringUtils.endsWithAny(abcxyz, new String[] {\"\"})", StringUtils.endsWithAny("abcxyz", new String[] { "" })); 
     assertTrue("StringUtils.endsWithAny(abcxyz, new String[] {xyz})", StringUtils.endsWithAny("abcxyz", new String[] { "xyz" })); 
     assertTrue("StringUtils.endsWithAny(abcxyz, new String[] {null, xyz, abc})", StringUtils.endsWithAny("abcxyz", new String[] { null, "xyz", "abc" })); 
     assertFalse("StringUtils.endsWithAny(defg, new String[] {null, xyz, abc})", StringUtils.endsWithAny("defg", new String[] { null, "xyz", "abc" })); 
     assertTrue("StringUtils.endsWithAny(abcxyz, StringBuilder(abc), StringBuffer(xyz))", StringUtils.endsWithAny("abcxyz", new StringBuilder("abc"), new StringBuffer("xyz"))); 
     assertTrue("StringUtils.endsWithAny( StrBuilder(abcxyz), StringBuilder(abc), StringBuffer(xyz))", StringUtils.endsWithAny(new StrBuilder("abcxyz"), new StringBuilder("abc"), new StringBuffer("xyz"))); 
 }
@Test
public void testEndsWithIgnoreCase1375() { 
     assertTrue("endsWithIgnoreCase(null, null)", StringUtils.endsWithIgnoreCase(null, (String) null)); 
     assertFalse("endsWithIgnoreCase(FOOBAR, null)", StringUtils.endsWithIgnoreCase(FOOBAR, (String) null)); 
     assertFalse("endsWithIgnoreCase(null, FOO)", StringUtils.endsWithIgnoreCase(null, FOO)); 
     assertTrue("endsWithIgnoreCase(FOOBAR, \"\")", StringUtils.endsWithIgnoreCase(FOOBAR, "")); 
     assertFalse("endsWithIgnoreCase(foobar, foo)", StringUtils.endsWithIgnoreCase(foobar, foo)); 
     assertFalse("endsWithIgnoreCase(FOOBAR, FOO)", StringUtils.endsWithIgnoreCase(FOOBAR, FOO)); 
     assertFalse("endsWithIgnoreCase(foobar, FOO)", StringUtils.endsWithIgnoreCase(foobar, FOO)); 
     assertFalse("endsWithIgnoreCase(FOOBAR, foo)", StringUtils.endsWithIgnoreCase(FOOBAR, foo)); 
     assertFalse("endsWithIgnoreCase(foo, foobar)", StringUtils.endsWithIgnoreCase(foo, foobar)); 
     assertFalse("endsWithIgnoreCase(foo, foobar)", StringUtils.endsWithIgnoreCase(bar, foobar)); 
     assertTrue("endsWithIgnoreCase(foobar, bar)", StringUtils.endsWithIgnoreCase(foobar, bar)); 
     assertTrue("endsWithIgnoreCase(FOOBAR, BAR)", StringUtils.endsWithIgnoreCase(FOOBAR, BAR)); 
     assertTrue("endsWithIgnoreCase(foobar, BAR)", StringUtils.endsWithIgnoreCase(foobar, BAR)); 
     assertTrue("endsWithIgnoreCase(FOOBAR, bar)", StringUtils.endsWithIgnoreCase(FOOBAR, bar)); 
     assertTrue(StringUtils.endsWithIgnoreCase("abcdef", "def")); 
     assertTrue(StringUtils.endsWithIgnoreCase("ABCDEF", "def")); 
     assertFalse(StringUtils.endsWithIgnoreCase("ABCDEF", "cde")); 
     assertTrue("endsWith(\u03B1\u03B2\u03B3\u03B4, \u0394)", StringUtils.endsWithIgnoreCase("\u03B1\u03B2\u03B3\u03B4", "\u0394")); 
     assertFalse("endsWith(\u03B1\u03B2\u03B3\u03B4, \u0393)", StringUtils.endsWithIgnoreCase("\u03B1\u03B2\u03B3\u03B4", "\u0393")); 
 }
@Test
public void testEndsWithAny1685() { 
     assertFalse("StringUtils.endsWithAny(null, null)", StringUtils.endsWithAny(null, (String) null)); 
     assertFalse("StringUtils.endsWithAny(null, new String[] {abc})", StringUtils.endsWithAny(null, new String[] { "abc" })); 
     assertFalse("StringUtils.endsWithAny(abcxyz, null)", StringUtils.endsWithAny("abcxyz", (String) null)); 
     assertTrue("StringUtils.endsWithAny(abcxyz, new String[] {\"\"})", StringUtils.endsWithAny("abcxyz", new String[] { "" })); 
     assertTrue("StringUtils.endsWithAny(abcxyz, new String[] {xyz})", StringUtils.endsWithAny("abcxyz", new String[] { "xyz" })); 
     assertTrue("StringUtils.endsWithAny(abcxyz, new String[] {null, xyz, abc})", StringUtils.endsWithAny("abcxyz", new String[] { null, "xyz", "abc" })); 
     assertFalse("StringUtils.endsWithAny(defg, new String[] {null, xyz, abc})", StringUtils.endsWithAny("defg", new String[] { null, "xyz", "abc" })); 
     assertTrue("StringUtils.endsWithAny(abcxyz, StringBuilder(abc), StringBuffer(xyz))", StringUtils.endsWithAny("abcxyz", new StringBuilder("abc"), new StringBuffer("xyz"))); 
     assertTrue("StringUtils.endsWithAny( StrBuilder(abcxyz), StringBuilder(abc), StringBuffer(xyz))", StringUtils.endsWithAny(new StrBuilder("abcxyz"), new StringBuilder("abc"), new StringBuffer("xyz"))); 
 }
@Test
public void testStartsWith1703() { 
     assertTrue("startsWith(null, null)", StringUtils.startsWith(null, (String) null)); 
     assertFalse("startsWith(FOOBAR, null)", StringUtils.startsWith(FOOBAR, (String) null)); 
     assertFalse("startsWith(null, FOO)", StringUtils.startsWith(null, FOO)); 
     assertTrue("startsWith(FOOBAR, \"\")", StringUtils.startsWith(FOOBAR, "")); 
     assertTrue("startsWith(foobar, foo)", StringUtils.startsWith(foobar, foo)); 
     assertTrue("startsWith(FOOBAR, FOO)", StringUtils.startsWith(FOOBAR, FOO)); 
     assertFalse("startsWith(foobar, FOO)", StringUtils.startsWith(foobar, FOO)); 
     assertFalse("startsWith(FOOBAR, foo)", StringUtils.startsWith(FOOBAR, foo)); 
     assertFalse("startsWith(foo, foobar)", StringUtils.startsWith(foo, foobar)); 
     assertFalse("startsWith(foo, foobar)", StringUtils.startsWith(bar, foobar)); 
     assertFalse("startsWith(foobar, bar)", StringUtils.startsWith(foobar, bar)); 
     assertFalse("startsWith(FOOBAR, BAR)", StringUtils.startsWith(FOOBAR, BAR)); 
     assertFalse("startsWith(foobar, BAR)", StringUtils.startsWith(foobar, BAR)); 
     assertFalse("startsWith(FOOBAR, bar)", StringUtils.startsWith(FOOBAR, bar)); 
 }
@Test
public void testEndsWithAny1851() { 
     assertFalse("StringUtils.endsWithAny(null, null)", StringUtils.endsWithAny(null, (String) null)); 
     assertFalse("StringUtils.endsWithAny(null, new String[] {abc})", StringUtils.endsWithAny(null, new String[] { "abc" })); 
     assertFalse("StringUtils.endsWithAny(abcxyz, null)", StringUtils.endsWithAny("abcxyz", (String) null)); 
     assertTrue("StringUtils.endsWithAny(abcxyz, new String[] {\"\"})", StringUtils.endsWithAny("abcxyz", new String[] { "" })); 
     assertTrue("StringUtils.endsWithAny(abcxyz, new String[] {xyz})", StringUtils.endsWithAny("abcxyz", new String[] { "xyz" })); 
     assertTrue("StringUtils.endsWithAny(abcxyz, new String[] {null, xyz, abc})", StringUtils.endsWithAny("abcxyz", new String[] { null, "xyz", "abc" })); 
     assertFalse("StringUtils.endsWithAny(defg, new String[] {null, xyz, abc})", StringUtils.endsWithAny("defg", new String[] { null, "xyz", "abc" })); 
     assertTrue("StringUtils.endsWithAny(abcxyz, StringBuilder(abc), StringBuffer(xyz))", StringUtils.endsWithAny("abcxyz", new StringBuilder("abc"), new StringBuffer("xyz"))); 
     assertTrue("StringUtils.endsWithAny( StrBuilder(abcxyz), StringBuilder(abc), StringBuffer(xyz))", StringUtils.endsWithAny(new StrBuilder("abcxyz"), new StringBuilder("abc"), new StringBuffer("xyz"))); 
 }
@Test
public void testEndsWithAny2243() { 
     assertFalse("StringUtils.endsWithAny(null, null)", StringUtils.endsWithAny(null, (String) null)); 
     assertFalse("StringUtils.endsWithAny(null, new String[] {abc})", StringUtils.endsWithAny(null, new String[] { "abc" })); 
     assertFalse("StringUtils.endsWithAny(abcxyz, null)", StringUtils.endsWithAny("abcxyz", (String) null)); 
     assertTrue("StringUtils.endsWithAny(abcxyz, new String[] {\"\"})", StringUtils.endsWithAny("abcxyz", new String[] { "" })); 
     assertTrue("StringUtils.endsWithAny(abcxyz, new String[] {xyz})", StringUtils.endsWithAny("abcxyz", new String[] { "xyz" })); 
     assertTrue("StringUtils.endsWithAny(abcxyz, new String[] {null, xyz, abc})", StringUtils.endsWithAny("abcxyz", new String[] { null, "xyz", "abc" })); 
     assertFalse("StringUtils.endsWithAny(defg, new String[] {null, xyz, abc})", StringUtils.endsWithAny("defg", new String[] { null, "xyz", "abc" })); 
     assertTrue("StringUtils.endsWithAny(abcxyz, StringBuilder(abc), StringBuffer(xyz))", StringUtils.endsWithAny("abcxyz", new StringBuilder("abc"), new StringBuffer("xyz"))); 
     assertTrue("StringUtils.endsWithAny( StrBuilder(abcxyz), StringBuilder(abc), StringBuffer(xyz))", StringUtils.endsWithAny(new StrBuilder("abcxyz"), new StringBuilder("abc"), new StringBuffer("xyz"))); 
 }
@Test
public void testEndsWithIgnoreCase2342() { 
     assertTrue("endsWithIgnoreCase(null, null)", StringUtils.endsWithIgnoreCase(null, (String) null)); 
     assertFalse("endsWithIgnoreCase(FOOBAR, null)", StringUtils.endsWithIgnoreCase(FOOBAR, (String) null)); 
     assertFalse("endsWithIgnoreCase(null, FOO)", StringUtils.endsWithIgnoreCase(null, FOO)); 
     assertTrue("endsWithIgnoreCase(FOOBAR, \"\")", StringUtils.endsWithIgnoreCase(FOOBAR, "")); 
     assertFalse("endsWithIgnoreCase(foobar, foo)", StringUtils.endsWithIgnoreCase(foobar, foo)); 
     assertFalse("endsWithIgnoreCase(FOOBAR, FOO)", StringUtils.endsWithIgnoreCase(FOOBAR, FOO)); 
     assertFalse("endsWithIgnoreCase(foobar, FOO)", StringUtils.endsWithIgnoreCase(foobar, FOO)); 
     assertFalse("endsWithIgnoreCase(FOOBAR, foo)", StringUtils.endsWithIgnoreCase(FOOBAR, foo)); 
     assertFalse("endsWithIgnoreCase(foo, foobar)", StringUtils.endsWithIgnoreCase(foo, foobar)); 
     assertFalse("endsWithIgnoreCase(foo, foobar)", StringUtils.endsWithIgnoreCase(bar, foobar)); 
     assertTrue("endsWithIgnoreCase(foobar, bar)", StringUtils.endsWithIgnoreCase(foobar, bar)); 
     assertTrue("endsWithIgnoreCase(FOOBAR, BAR)", StringUtils.endsWithIgnoreCase(FOOBAR, BAR)); 
     assertTrue("endsWithIgnoreCase(foobar, BAR)", StringUtils.endsWithIgnoreCase(foobar, BAR)); 
     assertTrue("endsWithIgnoreCase(FOOBAR, bar)", StringUtils.endsWithIgnoreCase(FOOBAR, bar)); 
     assertTrue(StringUtils.endsWithIgnoreCase("abcdef", "def")); 
     assertTrue(StringUtils.endsWithIgnoreCase("ABCDEF", "def")); 
     assertFalse(StringUtils.endsWithIgnoreCase("ABCDEF", "cde")); 
     assertTrue("endsWith(\u03B1\u03B2\u03B3\u03B4, \u0394)", StringUtils.endsWithIgnoreCase("\u03B1\u03B2\u03B3\u03B4", "\u0394")); 
     assertFalse("endsWith(\u03B1\u03B2\u03B3\u03B4, \u0393)", StringUtils.endsWithIgnoreCase("\u03B1\u03B2\u03B3\u03B4", "\u0393")); 
 }
@Test
public void testStartsWithAny2526() { 
     assertFalse(StringUtils.startsWithAny(null, (String[]) null)); 
     assertFalse(StringUtils.startsWithAny(null, "abc")); 
     assertFalse(StringUtils.startsWithAny("abcxyz", (String[]) null)); 
     assertFalse(StringUtils.startsWithAny("abcxyz")); 
     assertTrue(StringUtils.startsWithAny("abcxyz", "abc")); 
     assertTrue(StringUtils.startsWithAny("abcxyz", null, "xyz", "abc")); 
     assertFalse(StringUtils.startsWithAny("abcxyz", null, "xyz", "abcd")); 
     assertTrue("StringUtils.startsWithAny(abcxyz, StringBuilder(xyz), StringBuffer(abc))", StringUtils.startsWithAny("abcxyz", new StringBuilder("xyz"), new StringBuffer("abc"))); 
     assertTrue("StringUtils.startsWithAny( StrBuilder(abcxyz), StringBuilder(xyz), StringBuffer(abc))", StringUtils.startsWithAny(new StrBuilder("abcxyz"), new StringBuilder("xyz"), new StringBuffer("abc"))); 
 }
@Test
public void testEndsWithAny2607() { 
     assertFalse("StringUtils.endsWithAny(null, null)", StringUtils.endsWithAny(null, (String) null)); 
     assertFalse("StringUtils.endsWithAny(null, new String[] {abc})", StringUtils.endsWithAny(null, new String[] { "abc" })); 
     assertFalse("StringUtils.endsWithAny(abcxyz, null)", StringUtils.endsWithAny("abcxyz", (String) null)); 
     assertTrue("StringUtils.endsWithAny(abcxyz, new String[] {\"\"})", StringUtils.endsWithAny("abcxyz", new String[] { "" })); 
     assertTrue("StringUtils.endsWithAny(abcxyz, new String[] {xyz})", StringUtils.endsWithAny("abcxyz", new String[] { "xyz" })); 
     assertTrue("StringUtils.endsWithAny(abcxyz, new String[] {null, xyz, abc})", StringUtils.endsWithAny("abcxyz", new String[] { null, "xyz", "abc" })); 
     assertFalse("StringUtils.endsWithAny(defg, new String[] {null, xyz, abc})", StringUtils.endsWithAny("defg", new String[] { null, "xyz", "abc" })); 
     assertTrue("StringUtils.endsWithAny(abcxyz, StringBuilder(abc), StringBuffer(xyz))", StringUtils.endsWithAny("abcxyz", new StringBuilder("abc"), new StringBuffer("xyz"))); 
     assertTrue("StringUtils.endsWithAny( StrBuilder(abcxyz), StringBuilder(abc), StringBuffer(xyz))", StringUtils.endsWithAny(new StrBuilder("abcxyz"), new StringBuilder("abc"), new StringBuffer("xyz"))); 
 }
@Test
public void testEndsWithAny4066() { 
     assertFalse("StringUtils.endsWithAny(null, null)", StringUtils.endsWithAny(null, (String) null)); 
     assertFalse("StringUtils.endsWithAny(null, new String[] {abc})", StringUtils.endsWithAny(null, new String[] { "abc" })); 
     assertFalse("StringUtils.endsWithAny(abcxyz, null)", StringUtils.endsWithAny("abcxyz", (String) null)); 
     assertTrue("StringUtils.endsWithAny(abcxyz, new String[] {\"\"})", StringUtils.endsWithAny("abcxyz", new String[] { "" })); 
     assertTrue("StringUtils.endsWithAny(abcxyz, new String[] {xyz})", StringUtils.endsWithAny("abcxyz", new String[] { "xyz" })); 
     assertTrue("StringUtils.endsWithAny(abcxyz, new String[] {null, xyz, abc})", StringUtils.endsWithAny("abcxyz", new String[] { null, "xyz", "abc" })); 
     assertFalse("StringUtils.endsWithAny(defg, new String[] {null, xyz, abc})", StringUtils.endsWithAny("defg", new String[] { null, "xyz", "abc" })); 
     assertTrue("StringUtils.endsWithAny(abcxyz, StringBuilder(abc), StringBuffer(xyz))", StringUtils.endsWithAny("abcxyz", new StringBuilder("abc"), new StringBuffer("xyz"))); 
     assertTrue("StringUtils.endsWithAny( StrBuilder(abcxyz), StringBuilder(abc), StringBuffer(xyz))", StringUtils.endsWithAny(new StrBuilder("abcxyz"), new StringBuilder("abc"), new StringBuffer("xyz"))); 
 }
@Test
public void testStartsWith4443() { 
     assertTrue("startsWith(null, null)", StringUtils.startsWith(null, (String) null)); 
     assertFalse("startsWith(FOOBAR, null)", StringUtils.startsWith(FOOBAR, (String) null)); 
     assertFalse("startsWith(null, FOO)", StringUtils.startsWith(null, FOO)); 
     assertTrue("startsWith(FOOBAR, \"\")", StringUtils.startsWith(FOOBAR, "")); 
     assertTrue("startsWith(foobar, foo)", StringUtils.startsWith(foobar, foo)); 
     assertTrue("startsWith(FOOBAR, FOO)", StringUtils.startsWith(FOOBAR, FOO)); 
     assertFalse("startsWith(foobar, FOO)", StringUtils.startsWith(foobar, FOO)); 
     assertFalse("startsWith(FOOBAR, foo)", StringUtils.startsWith(FOOBAR, foo)); 
     assertFalse("startsWith(foo, foobar)", StringUtils.startsWith(foo, foobar)); 
     assertFalse("startsWith(foo, foobar)", StringUtils.startsWith(bar, foobar)); 
     assertFalse("startsWith(foobar, bar)", StringUtils.startsWith(foobar, bar)); 
     assertFalse("startsWith(FOOBAR, BAR)", StringUtils.startsWith(FOOBAR, BAR)); 
     assertFalse("startsWith(foobar, BAR)", StringUtils.startsWith(foobar, BAR)); 
     assertFalse("startsWith(FOOBAR, bar)", StringUtils.startsWith(FOOBAR, bar)); 
 }
@Test
public void testEndsWithAny4869() { 
     assertFalse("StringUtils.endsWithAny(null, null)", StringUtils.endsWithAny(null, (String) null)); 
     assertFalse("StringUtils.endsWithAny(null, new String[] {abc})", StringUtils.endsWithAny(null, new String[] { "abc" })); 
     assertFalse("StringUtils.endsWithAny(abcxyz, null)", StringUtils.endsWithAny("abcxyz", (String) null)); 
     assertTrue("StringUtils.endsWithAny(abcxyz, new String[] {\"\"})", StringUtils.endsWithAny("abcxyz", new String[] { "" })); 
     assertTrue("StringUtils.endsWithAny(abcxyz, new String[] {xyz})", StringUtils.endsWithAny("abcxyz", new String[] { "xyz" })); 
     assertTrue("StringUtils.endsWithAny(abcxyz, new String[] {null, xyz, abc})", StringUtils.endsWithAny("abcxyz", new String[] { null, "xyz", "abc" })); 
     assertFalse("StringUtils.endsWithAny(defg, new String[] {null, xyz, abc})", StringUtils.endsWithAny("defg", new String[] { null, "xyz", "abc" })); 
     assertTrue("StringUtils.endsWithAny(abcxyz, StringBuilder(abc), StringBuffer(xyz))", StringUtils.endsWithAny("abcxyz", new StringBuilder("abc"), new StringBuffer("xyz"))); 
     assertTrue("StringUtils.endsWithAny( StrBuilder(abcxyz), StringBuilder(abc), StringBuffer(xyz))", StringUtils.endsWithAny(new StrBuilder("abcxyz"), new StringBuilder("abc"), new StringBuffer("xyz"))); 
 }
@Test
public void testEndsWithAny5073() { 
     assertFalse("StringUtils.endsWithAny(null, null)", StringUtils.endsWithAny(null, (String) null)); 
     assertFalse("StringUtils.endsWithAny(null, new String[] {abc})", StringUtils.endsWithAny(null, new String[] { "abc" })); 
     assertFalse("StringUtils.endsWithAny(abcxyz, null)", StringUtils.endsWithAny("abcxyz", (String) null)); 
     assertTrue("StringUtils.endsWithAny(abcxyz, new String[] {\"\"})", StringUtils.endsWithAny("abcxyz", new String[] { "" })); 
     assertTrue("StringUtils.endsWithAny(abcxyz, new String[] {xyz})", StringUtils.endsWithAny("abcxyz", new String[] { "xyz" })); 
     assertTrue("StringUtils.endsWithAny(abcxyz, new String[] {null, xyz, abc})", StringUtils.endsWithAny("abcxyz", new String[] { null, "xyz", "abc" })); 
     assertFalse("StringUtils.endsWithAny(defg, new String[] {null, xyz, abc})", StringUtils.endsWithAny("defg", new String[] { null, "xyz", "abc" })); 
     assertTrue("StringUtils.endsWithAny(abcxyz, StringBuilder(abc), StringBuffer(xyz))", StringUtils.endsWithAny("abcxyz", new StringBuilder("abc"), new StringBuffer("xyz"))); 
     assertTrue("StringUtils.endsWithAny( StrBuilder(abcxyz), StringBuilder(abc), StringBuffer(xyz))", StringUtils.endsWithAny(new StrBuilder("abcxyz"), new StringBuilder("abc"), new StringBuffer("xyz"))); 
 }
@Test
public void testStartsWithAny5121() { 
     assertFalse(StringUtils.startsWithAny(null, (String[]) null)); 
     assertFalse(StringUtils.startsWithAny(null, "abc")); 
     assertFalse(StringUtils.startsWithAny("abcxyz", (String[]) null)); 
     assertFalse(StringUtils.startsWithAny("abcxyz")); 
     assertTrue(StringUtils.startsWithAny("abcxyz", "abc")); 
     assertTrue(StringUtils.startsWithAny("abcxyz", null, "xyz", "abc")); 
     assertFalse(StringUtils.startsWithAny("abcxyz", null, "xyz", "abcd")); 
     assertTrue("StringUtils.startsWithAny(abcxyz, StringBuilder(xyz), StringBuffer(abc))", StringUtils.startsWithAny("abcxyz", new StringBuilder("xyz"), new StringBuffer("abc"))); 
     assertTrue("StringUtils.startsWithAny( StrBuilder(abcxyz), StringBuilder(xyz), StringBuffer(abc))", StringUtils.startsWithAny(new StrBuilder("abcxyz"), new StringBuilder("xyz"), new StringBuffer("abc"))); 
 }
@Test
public void testStartsWithIgnoreCase5321() { 
     assertTrue("startsWithIgnoreCase(null, null)", StringUtils.startsWithIgnoreCase(null, (String) null)); 
     assertFalse("startsWithIgnoreCase(FOOBAR, null)", StringUtils.startsWithIgnoreCase(FOOBAR, (String) null)); 
     assertFalse("startsWithIgnoreCase(null, FOO)", StringUtils.startsWithIgnoreCase(null, FOO)); 
     assertTrue("startsWithIgnoreCase(FOOBAR, \"\")", StringUtils.startsWithIgnoreCase(FOOBAR, "")); 
     assertTrue("startsWithIgnoreCase(foobar, foo)", StringUtils.startsWithIgnoreCase(foobar, foo)); 
     assertTrue("startsWithIgnoreCase(FOOBAR, FOO)", StringUtils.startsWithIgnoreCase(FOOBAR, FOO)); 
     assertTrue("startsWithIgnoreCase(foobar, FOO)", StringUtils.startsWithIgnoreCase(foobar, FOO)); 
     assertTrue("startsWithIgnoreCase(FOOBAR, foo)", StringUtils.startsWithIgnoreCase(FOOBAR, foo)); 
     assertFalse("startsWithIgnoreCase(foo, foobar)", StringUtils.startsWithIgnoreCase(foo, foobar)); 
     assertFalse("startsWithIgnoreCase(foo, foobar)", StringUtils.startsWithIgnoreCase(bar, foobar)); 
     assertFalse("startsWithIgnoreCase(foobar, bar)", StringUtils.startsWithIgnoreCase(foobar, bar)); 
     assertFalse("startsWithIgnoreCase(FOOBAR, BAR)", StringUtils.startsWithIgnoreCase(FOOBAR, BAR)); 
     assertFalse("startsWithIgnoreCase(foobar, BAR)", StringUtils.startsWithIgnoreCase(foobar, BAR)); 
     assertFalse("startsWithIgnoreCase(FOOBAR, bar)", StringUtils.startsWithIgnoreCase(FOOBAR, bar)); 
 }
@Test
public void testEndsWithAny5456() { 
     assertFalse("StringUtils.endsWithAny(null, null)", StringUtils.endsWithAny(null, (String) null)); 
     assertFalse("StringUtils.endsWithAny(null, new String[] {abc})", StringUtils.endsWithAny(null, new String[] { "abc" })); 
     assertFalse("StringUtils.endsWithAny(abcxyz, null)", StringUtils.endsWithAny("abcxyz", (String) null)); 
     assertTrue("StringUtils.endsWithAny(abcxyz, new String[] {\"\"})", StringUtils.endsWithAny("abcxyz", new String[] { "" })); 
     assertTrue("StringUtils.endsWithAny(abcxyz, new String[] {xyz})", StringUtils.endsWithAny("abcxyz", new String[] { "xyz" })); 
     assertTrue("StringUtils.endsWithAny(abcxyz, new String[] {null, xyz, abc})", StringUtils.endsWithAny("abcxyz", new String[] { null, "xyz", "abc" })); 
     assertFalse("StringUtils.endsWithAny(defg, new String[] {null, xyz, abc})", StringUtils.endsWithAny("defg", new String[] { null, "xyz", "abc" })); 
     assertTrue("StringUtils.endsWithAny(abcxyz, StringBuilder(abc), StringBuffer(xyz))", StringUtils.endsWithAny("abcxyz", new StringBuilder("abc"), new StringBuffer("xyz"))); 
     assertTrue("StringUtils.endsWithAny( StrBuilder(abcxyz), StringBuilder(abc), StringBuffer(xyz))", StringUtils.endsWithAny(new StrBuilder("abcxyz"), new StringBuilder("abc"), new StringBuffer("xyz"))); 
 }
@Test
public void testEndsWithAny5464() { 
     assertFalse("StringUtils.endsWithAny(null, null)", StringUtils.endsWithAny(null, (String) null)); 
     assertFalse("StringUtils.endsWithAny(null, new String[] {abc})", StringUtils.endsWithAny(null, new String[] { "abc" })); 
     assertFalse("StringUtils.endsWithAny(abcxyz, null)", StringUtils.endsWithAny("abcxyz", (String) null)); 
     assertTrue("StringUtils.endsWithAny(abcxyz, new String[] {\"\"})", StringUtils.endsWithAny("abcxyz", new String[] { "" })); 
     assertTrue("StringUtils.endsWithAny(abcxyz, new String[] {xyz})", StringUtils.endsWithAny("abcxyz", new String[] { "xyz" })); 
     assertTrue("StringUtils.endsWithAny(abcxyz, new String[] {null, xyz, abc})", StringUtils.endsWithAny("abcxyz", new String[] { null, "xyz", "abc" })); 
     assertFalse("StringUtils.endsWithAny(defg, new String[] {null, xyz, abc})", StringUtils.endsWithAny("defg", new String[] { null, "xyz", "abc" })); 
     assertTrue("StringUtils.endsWithAny(abcxyz, StringBuilder(abc), StringBuffer(xyz))", StringUtils.endsWithAny("abcxyz", new StringBuilder("abc"), new StringBuffer("xyz"))); 
     assertTrue("StringUtils.endsWithAny( StrBuilder(abcxyz), StringBuilder(abc), StringBuffer(xyz))", StringUtils.endsWithAny(new StrBuilder("abcxyz"), new StringBuilder("abc"), new StringBuffer("xyz"))); 
 }
@Test
public void testStartsWithAny6569() { 
     assertFalse(StringUtils.startsWithAny(null, (String[]) null)); 
     assertFalse(StringUtils.startsWithAny(null, "abc")); 
     assertFalse(StringUtils.startsWithAny("abcxyz", (String[]) null)); 
     assertFalse(StringUtils.startsWithAny("abcxyz")); 
     assertTrue(StringUtils.startsWithAny("abcxyz", "abc")); 
     assertTrue(StringUtils.startsWithAny("abcxyz", null, "xyz", "abc")); 
     assertFalse(StringUtils.startsWithAny("abcxyz", null, "xyz", "abcd")); 
     assertTrue("StringUtils.startsWithAny(abcxyz, StringBuilder(xyz), StringBuffer(abc))", StringUtils.startsWithAny("abcxyz", new StringBuilder("xyz"), new StringBuffer("abc"))); 
     assertTrue("StringUtils.startsWithAny( StrBuilder(abcxyz), StringBuilder(xyz), StringBuffer(abc))", StringUtils.startsWithAny(new StrBuilder("abcxyz"), new StringBuilder("xyz"), new StringBuffer("abc"))); 
 }
@Test
public void testStartsWithAny6915() { 
     assertFalse(StringUtils.startsWithAny(null, (String[]) null)); 
     assertFalse(StringUtils.startsWithAny(null, "abc")); 
     assertFalse(StringUtils.startsWithAny("abcxyz", (String[]) null)); 
     assertFalse(StringUtils.startsWithAny("abcxyz")); 
     assertTrue(StringUtils.startsWithAny("abcxyz", "abc")); 
     assertTrue(StringUtils.startsWithAny("abcxyz", null, "xyz", "abc")); 
     assertFalse(StringUtils.startsWithAny("abcxyz", null, "xyz", "abcd")); 
     assertTrue("StringUtils.startsWithAny(abcxyz, StringBuilder(xyz), StringBuffer(abc))", StringUtils.startsWithAny("abcxyz", new StringBuilder("xyz"), new StringBuffer("abc"))); 
     assertTrue("StringUtils.startsWithAny( StrBuilder(abcxyz), StringBuilder(xyz), StringBuffer(abc))", StringUtils.startsWithAny(new StrBuilder("abcxyz"), new StringBuilder("xyz"), new StringBuffer("abc"))); 
 }
@Test
public void testStartsWithAny7310() { 
     assertFalse(StringUtils.startsWithAny(null, (String[]) null)); 
     assertFalse(StringUtils.startsWithAny(null, "abc")); 
     assertFalse(StringUtils.startsWithAny("abcxyz", (String[]) null)); 
     assertFalse(StringUtils.startsWithAny("abcxyz")); 
     assertTrue(StringUtils.startsWithAny("abcxyz", "abc")); 
     assertTrue(StringUtils.startsWithAny("abcxyz", null, "xyz", "abc")); 
     assertFalse(StringUtils.startsWithAny("abcxyz", null, "xyz", "abcd")); 
     assertTrue("StringUtils.startsWithAny(abcxyz, StringBuilder(xyz), StringBuffer(abc))", StringUtils.startsWithAny("abcxyz", new StringBuilder("xyz"), new StringBuffer("abc"))); 
     assertTrue("StringUtils.startsWithAny( StrBuilder(abcxyz), StringBuilder(xyz), StringBuffer(abc))", StringUtils.startsWithAny(new StrBuilder("abcxyz"), new StringBuilder("xyz"), new StringBuffer("abc"))); 
 }
@Test
public void testEndsWithAny7323() { 
     assertFalse("StringUtils.endsWithAny(null, null)", StringUtils.endsWithAny(null, (String) null)); 
     assertFalse("StringUtils.endsWithAny(null, new String[] {abc})", StringUtils.endsWithAny(null, new String[] { "abc" })); 
     assertFalse("StringUtils.endsWithAny(abcxyz, null)", StringUtils.endsWithAny("abcxyz", (String) null)); 
     assertTrue("StringUtils.endsWithAny(abcxyz, new String[] {\"\"})", StringUtils.endsWithAny("abcxyz", new String[] { "" })); 
     assertTrue("StringUtils.endsWithAny(abcxyz, new String[] {xyz})", StringUtils.endsWithAny("abcxyz", new String[] { "xyz" })); 
     assertTrue("StringUtils.endsWithAny(abcxyz, new String[] {null, xyz, abc})", StringUtils.endsWithAny("abcxyz", new String[] { null, "xyz", "abc" })); 
     assertFalse("StringUtils.endsWithAny(defg, new String[] {null, xyz, abc})", StringUtils.endsWithAny("defg", new String[] { null, "xyz", "abc" })); 
     assertTrue("StringUtils.endsWithAny(abcxyz, StringBuilder(abc), StringBuffer(xyz))", StringUtils.endsWithAny("abcxyz", new StringBuilder("abc"), new StringBuffer("xyz"))); 
     assertTrue("StringUtils.endsWithAny( StrBuilder(abcxyz), StringBuilder(abc), StringBuffer(xyz))", StringUtils.endsWithAny(new StrBuilder("abcxyz"), new StringBuilder("abc"), new StringBuffer("xyz"))); 
 }
@Test
public void testEndsWithIgnoreCase7598() { 
     assertTrue("endsWithIgnoreCase(null, null)", StringUtils.endsWithIgnoreCase(null, (String) null)); 
     assertFalse("endsWithIgnoreCase(FOOBAR, null)", StringUtils.endsWithIgnoreCase(FOOBAR, (String) null)); 
     assertFalse("endsWithIgnoreCase(null, FOO)", StringUtils.endsWithIgnoreCase(null, FOO)); 
     assertTrue("endsWithIgnoreCase(FOOBAR, \"\")", StringUtils.endsWithIgnoreCase(FOOBAR, "")); 
     assertFalse("endsWithIgnoreCase(foobar, foo)", StringUtils.endsWithIgnoreCase(foobar, foo)); 
     assertFalse("endsWithIgnoreCase(FOOBAR, FOO)", StringUtils.endsWithIgnoreCase(FOOBAR, FOO)); 
     assertFalse("endsWithIgnoreCase(foobar, FOO)", StringUtils.endsWithIgnoreCase(foobar, FOO)); 
     assertFalse("endsWithIgnoreCase(FOOBAR, foo)", StringUtils.endsWithIgnoreCase(FOOBAR, foo)); 
     assertFalse("endsWithIgnoreCase(foo, foobar)", StringUtils.endsWithIgnoreCase(foo, foobar)); 
     assertFalse("endsWithIgnoreCase(foo, foobar)", StringUtils.endsWithIgnoreCase(bar, foobar)); 
     assertTrue("endsWithIgnoreCase(foobar, bar)", StringUtils.endsWithIgnoreCase(foobar, bar)); 
     assertTrue("endsWithIgnoreCase(FOOBAR, BAR)", StringUtils.endsWithIgnoreCase(FOOBAR, BAR)); 
     assertTrue("endsWithIgnoreCase(foobar, BAR)", StringUtils.endsWithIgnoreCase(foobar, BAR)); 
     assertTrue("endsWithIgnoreCase(FOOBAR, bar)", StringUtils.endsWithIgnoreCase(FOOBAR, bar)); 
     assertTrue(StringUtils.endsWithIgnoreCase("abcdef", "def")); 
     assertTrue(StringUtils.endsWithIgnoreCase("ABCDEF", "def")); 
     assertFalse(StringUtils.endsWithIgnoreCase("ABCDEF", "cde")); 
     assertTrue("endsWith(\u03B1\u03B2\u03B3\u03B4, \u0394)", StringUtils.endsWithIgnoreCase("\u03B1\u03B2\u03B3\u03B4", "\u0394")); 
     assertFalse("endsWith(\u03B1\u03B2\u03B3\u03B4, \u0393)", StringUtils.endsWithIgnoreCase("\u03B1\u03B2\u03B3\u03B4", "\u0393")); 
 }
@Test
public void testEndsWithAny7609() { 
     assertFalse("StringUtils.endsWithAny(null, null)", StringUtils.endsWithAny(null, (String) null)); 
     assertFalse("StringUtils.endsWithAny(null, new String[] {abc})", StringUtils.endsWithAny(null, new String[] { "abc" })); 
     assertFalse("StringUtils.endsWithAny(abcxyz, null)", StringUtils.endsWithAny("abcxyz", (String) null)); 
     assertTrue("StringUtils.endsWithAny(abcxyz, new String[] {\"\"})", StringUtils.endsWithAny("abcxyz", new String[] { "" })); 
     assertTrue("StringUtils.endsWithAny(abcxyz, new String[] {xyz})", StringUtils.endsWithAny("abcxyz", new String[] { "xyz" })); 
     assertTrue("StringUtils.endsWithAny(abcxyz, new String[] {null, xyz, abc})", StringUtils.endsWithAny("abcxyz", new String[] { null, "xyz", "abc" })); 
     assertFalse("StringUtils.endsWithAny(defg, new String[] {null, xyz, abc})", StringUtils.endsWithAny("defg", new String[] { null, "xyz", "abc" })); 
     assertTrue("StringUtils.endsWithAny(abcxyz, StringBuilder(abc), StringBuffer(xyz))", StringUtils.endsWithAny("abcxyz", new StringBuilder("abc"), new StringBuffer("xyz"))); 
     assertTrue("StringUtils.endsWithAny( StrBuilder(abcxyz), StringBuilder(abc), StringBuffer(xyz))", StringUtils.endsWithAny(new StrBuilder("abcxyz"), new StringBuilder("abc"), new StringBuffer("xyz"))); 
 }
@Test
public void testEndsWithAny8123() { 
     assertFalse("StringUtils.endsWithAny(null, null)", StringUtils.endsWithAny(null, (String) null)); 
     assertFalse("StringUtils.endsWithAny(null, new String[] {abc})", StringUtils.endsWithAny(null, new String[] { "abc" })); 
     assertFalse("StringUtils.endsWithAny(abcxyz, null)", StringUtils.endsWithAny("abcxyz", (String) null)); 
     assertTrue("StringUtils.endsWithAny(abcxyz, new String[] {\"\"})", StringUtils.endsWithAny("abcxyz", new String[] { "" })); 
     assertTrue("StringUtils.endsWithAny(abcxyz, new String[] {xyz})", StringUtils.endsWithAny("abcxyz", new String[] { "xyz" })); 
     assertTrue("StringUtils.endsWithAny(abcxyz, new String[] {null, xyz, abc})", StringUtils.endsWithAny("abcxyz", new String[] { null, "xyz", "abc" })); 
     assertFalse("StringUtils.endsWithAny(defg, new String[] {null, xyz, abc})", StringUtils.endsWithAny("defg", new String[] { null, "xyz", "abc" })); 
     assertTrue("StringUtils.endsWithAny(abcxyz, StringBuilder(abc), StringBuffer(xyz))", StringUtils.endsWithAny("abcxyz", new StringBuilder("abc"), new StringBuffer("xyz"))); 
     assertTrue("StringUtils.endsWithAny( StrBuilder(abcxyz), StringBuilder(abc), StringBuffer(xyz))", StringUtils.endsWithAny(new StrBuilder("abcxyz"), new StringBuilder("abc"), new StringBuffer("xyz"))); 
 }
@Test
public void testStartsWithAny8657() { 
     assertFalse(StringUtils.startsWithAny(null, (String[]) null)); 
     assertFalse(StringUtils.startsWithAny(null, "abc")); 
     assertFalse(StringUtils.startsWithAny("abcxyz", (String[]) null)); 
     assertFalse(StringUtils.startsWithAny("abcxyz")); 
     assertTrue(StringUtils.startsWithAny("abcxyz", "abc")); 
     assertTrue(StringUtils.startsWithAny("abcxyz", null, "xyz", "abc")); 
     assertFalse(StringUtils.startsWithAny("abcxyz", null, "xyz", "abcd")); 
     assertTrue("StringUtils.startsWithAny(abcxyz, StringBuilder(xyz), StringBuffer(abc))", StringUtils.startsWithAny("abcxyz", new StringBuilder("xyz"), new StringBuffer("abc"))); 
     assertTrue("StringUtils.startsWithAny( StrBuilder(abcxyz), StringBuilder(xyz), StringBuffer(abc))", StringUtils.startsWithAny(new StrBuilder("abcxyz"), new StringBuilder("xyz"), new StringBuffer("abc"))); 
 }
@Test
public void testEndsWithAny8792() { 
     assertFalse("StringUtils.endsWithAny(null, null)", StringUtils.endsWithAny(null, (String) null)); 
     assertFalse("StringUtils.endsWithAny(null, new String[] {abc})", StringUtils.endsWithAny(null, new String[] { "abc" })); 
     assertFalse("StringUtils.endsWithAny(abcxyz, null)", StringUtils.endsWithAny("abcxyz", (String) null)); 
     assertTrue("StringUtils.endsWithAny(abcxyz, new String[] {\"\"})", StringUtils.endsWithAny("abcxyz", new String[] { "" })); 
     assertTrue("StringUtils.endsWithAny(abcxyz, new String[] {xyz})", StringUtils.endsWithAny("abcxyz", new String[] { "xyz" })); 
     assertTrue("StringUtils.endsWithAny(abcxyz, new String[] {null, xyz, abc})", StringUtils.endsWithAny("abcxyz", new String[] { null, "xyz", "abc" })); 
     assertFalse("StringUtils.endsWithAny(defg, new String[] {null, xyz, abc})", StringUtils.endsWithAny("defg", new String[] { null, "xyz", "abc" })); 
     assertTrue("StringUtils.endsWithAny(abcxyz, StringBuilder(abc), StringBuffer(xyz))", StringUtils.endsWithAny("abcxyz", new StringBuilder("abc"), new StringBuffer("xyz"))); 
     assertTrue("StringUtils.endsWithAny( StrBuilder(abcxyz), StringBuilder(abc), StringBuffer(xyz))", StringUtils.endsWithAny(new StrBuilder("abcxyz"), new StringBuilder("abc"), new StringBuffer("xyz"))); 
 }
@Test
public void testEndsWithAny9449() { 
     assertFalse("StringUtils.endsWithAny(null, null)", StringUtils.endsWithAny(null, (String) null)); 
     assertFalse("StringUtils.endsWithAny(null, new String[] {abc})", StringUtils.endsWithAny(null, new String[] { "abc" })); 
     assertFalse("StringUtils.endsWithAny(abcxyz, null)", StringUtils.endsWithAny("abcxyz", (String) null)); 
     assertTrue("StringUtils.endsWithAny(abcxyz, new String[] {\"\"})", StringUtils.endsWithAny("abcxyz", new String[] { "" })); 
     assertTrue("StringUtils.endsWithAny(abcxyz, new String[] {xyz})", StringUtils.endsWithAny("abcxyz", new String[] { "xyz" })); 
     assertTrue("StringUtils.endsWithAny(abcxyz, new String[] {null, xyz, abc})", StringUtils.endsWithAny("abcxyz", new String[] { null, "xyz", "abc" })); 
     assertFalse("StringUtils.endsWithAny(defg, new String[] {null, xyz, abc})", StringUtils.endsWithAny("defg", new String[] { null, "xyz", "abc" })); 
     assertTrue("StringUtils.endsWithAny(abcxyz, StringBuilder(abc), StringBuffer(xyz))", StringUtils.endsWithAny("abcxyz", new StringBuilder("abc"), new StringBuffer("xyz"))); 
     assertTrue("StringUtils.endsWithAny( StrBuilder(abcxyz), StringBuilder(abc), StringBuffer(xyz))", StringUtils.endsWithAny(new StrBuilder("abcxyz"), new StringBuilder("abc"), new StringBuffer("xyz"))); 
 }
    

    /**
     * Test StringUtils.testStartsWithIgnoreCase()
     */
    

    
 

    /**
     * Test StringUtils.endsWith()
     */
    

    /**
     * Test StringUtils.endsWithIgnoreCase()
     */
    

    


}
