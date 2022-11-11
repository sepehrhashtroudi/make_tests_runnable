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
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * Unit tests {@link org.apache.commons.lang3.StringUtils} - Trim/Empty methods
 *
 * @version $Id$
 */
public class StringUtilsTrimEmptyTest  {
    private static final String FOO = "foo";

    //-----------------------------------------------------------------------
@Test
public void testStripAll239() { 
     final String[] empty = new String[0]; 
     final String[] fooSpace = new String[] { "  " + FOO + "  ", "  " + FOO, FOO + "  " }; 
     final String[] fooDots = new String[] { ".." + FOO + "..", ".." + FOO, FOO + ".." }; 
     final String[] foo = new String[] { FOO, FOO, FOO }; 
     assertNull(StringUtils.stripAll((String[]) null)); 
     assertArrayEquals(empty, StringUtils.stripAll()); 
     assertArrayEquals(new String[] { null }, StringUtils.stripAll((String) null)); 
     assertArrayEquals(empty, StringUtils.stripAll(empty)); 
     assertArrayEquals(foo, StringUtils.stripAll(fooSpace)); 
     assertNull(StringUtils.stripAll(null, null)); 
     assertArrayEquals(foo, StringUtils.stripAll(fooSpace, null)); 
     assertArrayEquals(foo, StringUtils.stripAll(fooDots, ".")); 
 }
@Test
public void testTrimToNull305() { 
     assertEquals(FOO, StringUtils.trimToNull(FOO + "  ")); 
     assertEquals(FOO, StringUtils.trimToNull(" " + FOO + "  ")); 
     assertEquals(FOO, StringUtils.trimToNull(" " + FOO)); 
     assertEquals(FOO, StringUtils.trimToNull(FOO + "")); 
     assertEquals(null, StringUtils.trimToNull(" \t\r\n\b ")); 
     assertEquals(null, StringUtils.trimToNull(StringUtilsTest.TRIMMABLE)); 
     assertEquals(StringUtilsTest.NON_TRIMMABLE, StringUtils.trimToNull(StringUtilsTest.NON_TRIMMABLE)); 
     assertEquals(null, StringUtils.trimToNull("")); 
     assertEquals(null, StringUtils.trimToNull(null)); 
 }
@Test
public void testStripAccents708() { 
     final String cue = "\u00C7\u00FA\u00EA"; 
     assertEquals("Failed to strip accents from " + cue, "Cue", StringUtils.stripAccents(cue)); 
     final String lots = "\u00C0\u00C1\u00C2\u00C3\u00C4\u00C5\u00C7\u00C8\u00C9" + "\u00CA\u00CB\u00CC\u00CD\u00CE\u00CF\u00D1\u00D2\u00D3" + "\u00D4\u00D5\u00D6\u00D9\u00DA\u00DB\u00DC\u00DD"; 
     assertEquals("Failed to strip accents from " + lots, "AAAAAACEEEEIIIINOOOOOUUUUY", StringUtils.stripAccents(lots)); 
     assertNull("Failed null safety", StringUtils.stripAccents(null)); 
     assertEquals("Failed empty String", "", StringUtils.stripAccents("")); 
     assertEquals("Failed to handle non-accented text", "control", StringUtils.stripAccents("control")); 
     assertEquals("Failed to handle easy example", "eclair", StringUtils.stripAccents("\u00E9clair")); 
 }
@Test
public void testStripAccents1165() { 
     final String cue = "\u00C7\u00FA\u00EA"; 
     assertEquals("Failed to strip accents from " + cue, "Cue", StringUtils.stripAccents(cue)); 
     final String lots = "\u00C0\u00C1\u00C2\u00C3\u00C4\u00C5\u00C7\u00C8\u00C9" + "\u00CA\u00CB\u00CC\u00CD\u00CE\u00CF\u00D1\u00D2\u00D3" + "\u00D4\u00D5\u00D6\u00D9\u00DA\u00DB\u00DC\u00DD"; 
     assertEquals("Failed to strip accents from " + lots, "AAAAAACEEEEIIIINOOOOOUUUUY", StringUtils.stripAccents(lots)); 
     assertNull("Failed null safety", StringUtils.stripAccents(null)); 
     assertEquals("Failed empty String", "", StringUtils.stripAccents("")); 
     assertEquals("Failed to handle non-accented text", "control", StringUtils.stripAccents("control")); 
     assertEquals("Failed to handle easy example", "eclair", StringUtils.stripAccents("\u00E9clair")); 
 }
@Test
public void testStripAccents1204() { 
     final String cue = "\u00C7\u00FA\u00EA"; 
     assertEquals("Failed to strip accents from " + cue, "Cue", StringUtils.stripAccents(cue)); 
     final String lots = "\u00C0\u00C1\u00C2\u00C3\u00C4\u00C5\u00C7\u00C8\u00C9" + "\u00CA\u00CB\u00CC\u00CD\u00CE\u00CF\u00D1\u00D2\u00D3" + "\u00D4\u00D5\u00D6\u00D9\u00DA\u00DB\u00DC\u00DD"; 
     assertEquals("Failed to strip accents from " + lots, "AAAAAACEEEEIIIINOOOOOUUUUY", StringUtils.stripAccents(lots)); 
     assertNull("Failed null safety", StringUtils.stripAccents(null)); 
     assertEquals("Failed empty String", "", StringUtils.stripAccents("")); 
     assertEquals("Failed to handle non-accented text", "control", StringUtils.stripAccents("control")); 
     assertEquals("Failed to handle easy example", "eclair", StringUtils.stripAccents("\u00E9clair")); 
 }
@Test
public void testStripAll1292() { 
     final String[] empty = new String[0]; 
     final String[] fooSpace = new String[] { "  " + FOO + "  ", "  " + FOO, FOO + "  " }; 
     final String[] fooDots = new String[] { ".." + FOO + "..", ".." + FOO, FOO + ".." }; 
     final String[] foo = new String[] { FOO, FOO, FOO }; 
     assertNull(StringUtils.stripAll((String[]) null)); 
     assertArrayEquals(empty, StringUtils.stripAll()); 
     assertArrayEquals(new String[] { null }, StringUtils.stripAll((String) null)); 
     assertArrayEquals(empty, StringUtils.stripAll(empty)); 
     assertArrayEquals(foo, StringUtils.stripAll(fooSpace)); 
     assertNull(StringUtils.stripAll(null, null)); 
     assertArrayEquals(foo, StringUtils.stripAll(fooSpace, null)); 
     assertArrayEquals(foo, StringUtils.stripAll(fooDots, ".")); 
 }
@Test
public void testIsNotEmpty1403() { 
     assertFalse(StringUtils.isNotEmpty(null)); 
     assertFalse(StringUtils.isNotEmpty("")); 
     assertTrue(StringUtils.isNotEmpty(" ")); 
     assertTrue(StringUtils.isNotEmpty("foo")); 
     assertTrue(StringUtils.isNotEmpty("  foo  ")); 
 }
@Test
public void testIsNotBlank2097() { 
     assertFalse(StringUtils.isNotBlank(null)); 
     assertFalse(StringUtils.isNotBlank("")); 
     assertFalse(StringUtils.isNotBlank(StringUtilsTest.WHITESPACE)); 
     assertTrue(StringUtils.isNotBlank("foo")); 
     assertTrue(StringUtils.isNotBlank("  foo  ")); 
 }
@Test
public void testStripAll2148() { 
     final String[] empty = new String[0]; 
     final String[] fooSpace = new String[] { "  " + FOO + "  ", "  " + FOO, FOO + "  " }; 
     final String[] fooDots = new String[] { ".." + FOO + "..", ".." + FOO, FOO + ".." }; 
     final String[] foo = new String[] { FOO, FOO, FOO }; 
     assertNull(StringUtils.stripAll((String[]) null)); 
     assertArrayEquals(empty, StringUtils.stripAll()); 
     assertArrayEquals(new String[] { null }, StringUtils.stripAll((String) null)); 
     assertArrayEquals(empty, StringUtils.stripAll(empty)); 
     assertArrayEquals(foo, StringUtils.stripAll(fooSpace)); 
     assertNull(StringUtils.stripAll(null, null)); 
     assertArrayEquals(foo, StringUtils.stripAll(fooSpace, null)); 
     assertArrayEquals(foo, StringUtils.stripAll(fooDots, ".")); 
 }
@Test
public void testStripAll2211() { 
     final String[] empty = new String[0]; 
     final String[] fooSpace = new String[] { "  " + FOO + "  ", "  " + FOO, FOO + "  " }; 
     final String[] fooDots = new String[] { ".." + FOO + "..", ".." + FOO, FOO + ".." }; 
     final String[] foo = new String[] { FOO, FOO, FOO }; 
     assertNull(StringUtils.stripAll((String[]) null)); 
     assertArrayEquals(empty, StringUtils.stripAll()); 
     assertArrayEquals(new String[] { null }, StringUtils.stripAll((String) null)); 
     assertArrayEquals(empty, StringUtils.stripAll(empty)); 
     assertArrayEquals(foo, StringUtils.stripAll(fooSpace)); 
     assertNull(StringUtils.stripAll(null, null)); 
     assertArrayEquals(foo, StringUtils.stripAll(fooSpace, null)); 
     assertArrayEquals(foo, StringUtils.stripAll(fooDots, ".")); 
 }
@Test
public void testStripAll2788() { 
     final String[] empty = new String[0]; 
     final String[] fooSpace = new String[] { "  " + FOO + "  ", "  " + FOO, FOO + "  " }; 
     final String[] fooDots = new String[] { ".." + FOO + "..", ".." + FOO, FOO + ".." }; 
     final String[] foo = new String[] { FOO, FOO, FOO }; 
     assertNull(StringUtils.stripAll((String[]) null)); 
     assertArrayEquals(empty, StringUtils.stripAll()); 
     assertArrayEquals(new String[] { null }, StringUtils.stripAll((String) null)); 
     assertArrayEquals(empty, StringUtils.stripAll(empty)); 
     assertArrayEquals(foo, StringUtils.stripAll(fooSpace)); 
     assertNull(StringUtils.stripAll(null, null)); 
     assertArrayEquals(foo, StringUtils.stripAll(fooSpace, null)); 
     assertArrayEquals(foo, StringUtils.stripAll(fooDots, ".")); 
 }
@Test
public void testStripAccents2868() { 
     final String cue = "\u00C7\u00FA\u00EA"; 
     assertEquals("Failed to strip accents from " + cue, "Cue", StringUtils.stripAccents(cue)); 
     final String lots = "\u00C0\u00C1\u00C2\u00C3\u00C4\u00C5\u00C7\u00C8\u00C9" + "\u00CA\u00CB\u00CC\u00CD\u00CE\u00CF\u00D1\u00D2\u00D3" + "\u00D4\u00D5\u00D6\u00D9\u00DA\u00DB\u00DC\u00DD"; 
     assertEquals("Failed to strip accents from " + lots, "AAAAAACEEEEIIIINOOOOOUUUUY", StringUtils.stripAccents(lots)); 
     assertNull("Failed null safety", StringUtils.stripAccents(null)); 
     assertEquals("Failed empty String", "", StringUtils.stripAccents("")); 
     assertEquals("Failed to handle non-accented text", "control", StringUtils.stripAccents("control")); 
     assertEquals("Failed to handle easy example", "eclair", StringUtils.stripAccents("\u00E9clair")); 
 }
@Test
public void testIsNotBlank3158() { 
     assertFalse(StringUtils.isNotBlank(null)); 
     assertFalse(StringUtils.isNotBlank("")); 
     assertFalse(StringUtils.isNotBlank(StringUtilsTest.WHITESPACE)); 
     assertTrue(StringUtils.isNotBlank("foo")); 
     assertTrue(StringUtils.isNotBlank("  foo  ")); 
 }
@Test
public void testStripAll3209() { 
     final String[] empty = new String[0]; 
     final String[] fooSpace = new String[] { "  " + FOO + "  ", "  " + FOO, FOO + "  " }; 
     final String[] fooDots = new String[] { ".." + FOO + "..", ".." + FOO, FOO + ".." }; 
     final String[] foo = new String[] { FOO, FOO, FOO }; 
     assertNull(StringUtils.stripAll((String[]) null)); 
     assertArrayEquals(empty, StringUtils.stripAll()); 
     assertArrayEquals(new String[] { null }, StringUtils.stripAll((String) null)); 
     assertArrayEquals(empty, StringUtils.stripAll(empty)); 
     assertArrayEquals(foo, StringUtils.stripAll(fooSpace)); 
     assertNull(StringUtils.stripAll(null, null)); 
     assertArrayEquals(foo, StringUtils.stripAll(fooSpace, null)); 
     assertArrayEquals(foo, StringUtils.stripAll(fooDots, ".")); 
 }
@Test
public void testStripStart_StringString3728() { 
     assertEquals(null, StringUtils.stripStart(null, null)); 
     assertEquals("", StringUtils.stripStart("", null)); 
     assertEquals("", StringUtils.stripStart("        ", null)); 
     assertEquals("abc  ", StringUtils.stripStart("  abc  ", null)); 
     assertEquals(StringUtilsTest.NON_WHITESPACE + StringUtilsTest.WHITESPACE, StringUtils.stripStart(StringUtilsTest.WHITESPACE + StringUtilsTest.NON_WHITESPACE + StringUtilsTest.WHITESPACE, null)); 
     assertEquals(null, StringUtils.stripStart(null, "")); 
     assertEquals("", StringUtils.stripStart("", "")); 
     assertEquals("        ", StringUtils.stripStart("        ", "")); 
     assertEquals("  abc  ", StringUtils.stripStart("  abc  ", "")); 
     assertEquals(StringUtilsTest.WHITESPACE, StringUtils.stripStart(StringUtilsTest.WHITESPACE, "")); 
     assertEquals(null, StringUtils.stripStart(null, " ")); 
     assertEquals("", StringUtils.stripStart("", " ")); 
     assertEquals("", StringUtils.stripStart("        ", " ")); 
     assertEquals("abc  ", StringUtils.stripStart("  abc  ", " ")); 
     assertEquals(null, StringUtils.stripStart(null, "ab")); 
     assertEquals("", StringUtils.stripStart("", "ab")); 
     assertEquals("        ", StringUtils.stripStart("        ", "ab")); 
     assertEquals("  abc  ", StringUtils.stripStart("  abc  ", "ab")); 
     assertEquals("cabab", StringUtils.stripStart("abcabab", "ab")); 
     assertEquals(StringUtilsTest.WHITESPACE, StringUtils.stripStart(StringUtilsTest.WHITESPACE, "")); 
 }
@Test
public void testStripAll4125() { 
     final String[] empty = new String[0]; 
     final String[] fooSpace = new String[] { "  " + FOO + "  ", "  " + FOO, FOO + "  " }; 
     final String[] fooDots = new String[] { ".." + FOO + "..", ".." + FOO, FOO + ".." }; 
     final String[] foo = new String[] { FOO, FOO, FOO }; 
     assertNull(StringUtils.stripAll((String[]) null)); 
     assertArrayEquals(empty, StringUtils.stripAll()); 
     assertArrayEquals(new String[] { null }, StringUtils.stripAll((String) null)); 
     assertArrayEquals(empty, StringUtils.stripAll(empty)); 
     assertArrayEquals(foo, StringUtils.stripAll(fooSpace)); 
     assertNull(StringUtils.stripAll(null, null)); 
     assertArrayEquals(foo, StringUtils.stripAll(fooSpace, null)); 
     assertArrayEquals(foo, StringUtils.stripAll(fooDots, ".")); 
 }
@Test
public void testStripAll4305() { 
     final String[] empty = new String[0]; 
     final String[] fooSpace = new String[] { "  " + FOO + "  ", "  " + FOO, FOO + "  " }; 
     final String[] fooDots = new String[] { ".." + FOO + "..", ".." + FOO, FOO + ".." }; 
     final String[] foo = new String[] { FOO, FOO, FOO }; 
     assertNull(StringUtils.stripAll((String[]) null)); 
     assertArrayEquals(empty, StringUtils.stripAll()); 
     assertArrayEquals(new String[] { null }, StringUtils.stripAll((String) null)); 
     assertArrayEquals(empty, StringUtils.stripAll(empty)); 
     assertArrayEquals(foo, StringUtils.stripAll(fooSpace)); 
     assertNull(StringUtils.stripAll(null, null)); 
     assertArrayEquals(foo, StringUtils.stripAll(fooSpace, null)); 
     assertArrayEquals(foo, StringUtils.stripAll(fooDots, ".")); 
 }
@Test
public void testStripAccents4526() { 
     final String cue = "\u00C7\u00FA\u00EA"; 
     assertEquals("Failed to strip accents from " + cue, "Cue", StringUtils.stripAccents(cue)); 
     final String lots = "\u00C0\u00C1\u00C2\u00C3\u00C4\u00C5\u00C7\u00C8\u00C9" + "\u00CA\u00CB\u00CC\u00CD\u00CE\u00CF\u00D1\u00D2\u00D3" + "\u00D4\u00D5\u00D6\u00D9\u00DA\u00DB\u00DC\u00DD"; 
     assertEquals("Failed to strip accents from " + lots, "AAAAAACEEEEIIIINOOOOOUUUUY", StringUtils.stripAccents(lots)); 
     assertNull("Failed null safety", StringUtils.stripAccents(null)); 
     assertEquals("Failed empty String", "", StringUtils.stripAccents("")); 
     assertEquals("Failed to handle non-accented text", "control", StringUtils.stripAccents("control")); 
     assertEquals("Failed to handle easy example", "eclair", StringUtils.stripAccents("\u00E9clair")); 
 }
@Test
public void testStripStart_StringString5263() { 
     assertEquals(null, StringUtils.stripStart(null, null)); 
     assertEquals("", StringUtils.stripStart("", null)); 
     assertEquals("", StringUtils.stripStart("        ", null)); 
     assertEquals("abc  ", StringUtils.stripStart("  abc  ", null)); 
     assertEquals(StringUtilsTest.NON_WHITESPACE + StringUtilsTest.WHITESPACE, StringUtils.stripStart(StringUtilsTest.WHITESPACE + StringUtilsTest.NON_WHITESPACE + StringUtilsTest.WHITESPACE, null)); 
     assertEquals(null, StringUtils.stripStart(null, "")); 
     assertEquals("", StringUtils.stripStart("", "")); 
     assertEquals("        ", StringUtils.stripStart("        ", "")); 
     assertEquals("  abc  ", StringUtils.stripStart("  abc  ", "")); 
     assertEquals(StringUtilsTest.WHITESPACE, StringUtils.stripStart(StringUtilsTest.WHITESPACE, "")); 
     assertEquals(null, StringUtils.stripStart(null, " ")); 
     assertEquals("", StringUtils.stripStart("", " ")); 
     assertEquals("", StringUtils.stripStart("        ", " ")); 
     assertEquals("abc  ", StringUtils.stripStart("  abc  ", " ")); 
     assertEquals(null, StringUtils.stripStart(null, "ab")); 
     assertEquals("", StringUtils.stripStart("", "ab")); 
     assertEquals("        ", StringUtils.stripStart("        ", "ab")); 
     assertEquals("  abc  ", StringUtils.stripStart("  abc  ", "ab")); 
     assertEquals("cabab", StringUtils.stripStart("abcabab", "ab")); 
     assertEquals(StringUtilsTest.WHITESPACE, StringUtils.stripStart(StringUtilsTest.WHITESPACE, "")); 
 }
@Test
public void testTrimToNull5379() { 
     assertEquals(FOO, StringUtils.trimToNull(FOO + "  ")); 
     assertEquals(FOO, StringUtils.trimToNull(" " + FOO + "  ")); 
     assertEquals(FOO, StringUtils.trimToNull(" " + FOO)); 
     assertEquals(FOO, StringUtils.trimToNull(FOO + "")); 
     assertEquals(null, StringUtils.trimToNull(" \t\r\n\b ")); 
     assertEquals(null, StringUtils.trimToNull(StringUtilsTest.TRIMMABLE)); 
     assertEquals(StringUtilsTest.NON_TRIMMABLE, StringUtils.trimToNull(StringUtilsTest.NON_TRIMMABLE)); 
     assertEquals(null, StringUtils.trimToNull("")); 
     assertEquals(null, StringUtils.trimToNull(null)); 
 }
@Test
public void testTrimToNull5542() { 
     assertEquals(FOO, StringUtils.trimToNull(FOO + "  ")); 
     assertEquals(FOO, StringUtils.trimToNull(" " + FOO + "  ")); 
     assertEquals(FOO, StringUtils.trimToNull(" " + FOO)); 
     assertEquals(FOO, StringUtils.trimToNull(FOO + "")); 
     assertEquals(null, StringUtils.trimToNull(" \t\r\n\b ")); 
     assertEquals(null, StringUtils.trimToNull(StringUtilsTest.TRIMMABLE)); 
     assertEquals(StringUtilsTest.NON_TRIMMABLE, StringUtils.trimToNull(StringUtilsTest.NON_TRIMMABLE)); 
     assertEquals(null, StringUtils.trimToNull("")); 
     assertEquals(null, StringUtils.trimToNull(null)); 
 }
@Test
public void testTrimToNull5602() { 
     assertEquals(FOO, StringUtils.trimToNull(FOO + "  ")); 
     assertEquals(FOO, StringUtils.trimToNull(" " + FOO + "  ")); 
     assertEquals(FOO, StringUtils.trimToNull(" " + FOO)); 
     assertEquals(FOO, StringUtils.trimToNull(FOO + "")); 
     assertEquals(null, StringUtils.trimToNull(" \t\r\n\b ")); 
     assertEquals(null, StringUtils.trimToNull(StringUtilsTest.TRIMMABLE)); 
     assertEquals(StringUtilsTest.NON_TRIMMABLE, StringUtils.trimToNull(StringUtilsTest.NON_TRIMMABLE)); 
     assertEquals(null, StringUtils.trimToNull("")); 
     assertEquals(null, StringUtils.trimToNull(null)); 
 }
@Test
public void testIsNotEmpty5873() { 
     assertFalse(StringUtils.isNotEmpty(null)); 
     assertFalse(StringUtils.isNotEmpty("")); 
     assertTrue(StringUtils.isNotEmpty(" ")); 
     assertTrue(StringUtils.isNotEmpty("foo")); 
     assertTrue(StringUtils.isNotEmpty("  foo  ")); 
 }
@Test
public void testStripStart_StringString6299() { 
     assertEquals(null, StringUtils.stripStart(null, null)); 
     assertEquals("", StringUtils.stripStart("", null)); 
     assertEquals("", StringUtils.stripStart("        ", null)); 
     assertEquals("abc  ", StringUtils.stripStart("  abc  ", null)); 
     assertEquals(StringUtilsTest.NON_WHITESPACE + StringUtilsTest.WHITESPACE, StringUtils.stripStart(StringUtilsTest.WHITESPACE + StringUtilsTest.NON_WHITESPACE + StringUtilsTest.WHITESPACE, null)); 
     assertEquals(null, StringUtils.stripStart(null, "")); 
     assertEquals("", StringUtils.stripStart("", "")); 
     assertEquals("        ", StringUtils.stripStart("        ", "")); 
     assertEquals("  abc  ", StringUtils.stripStart("  abc  ", "")); 
     assertEquals(StringUtilsTest.WHITESPACE, StringUtils.stripStart(StringUtilsTest.WHITESPACE, "")); 
     assertEquals(null, StringUtils.stripStart(null, " ")); 
     assertEquals("", StringUtils.stripStart("", " ")); 
     assertEquals("", StringUtils.stripStart("        ", " ")); 
     assertEquals("abc  ", StringUtils.stripStart("  abc  ", " ")); 
     assertEquals(null, StringUtils.stripStart(null, "ab")); 
     assertEquals("", StringUtils.stripStart("", "ab")); 
     assertEquals("        ", StringUtils.stripStart("        ", "ab")); 
     assertEquals("  abc  ", StringUtils.stripStart("  abc  ", "ab")); 
     assertEquals("cabab", StringUtils.stripStart("abcabab", "ab")); 
     assertEquals(StringUtilsTest.WHITESPACE, StringUtils.stripStart(StringUtilsTest.WHITESPACE, "")); 
 }
@Test
public void testStripAll6395() { 
     final String[] empty = new String[0]; 
     final String[] fooSpace = new String[] { "  " + FOO + "  ", "  " + FOO, FOO + "  " }; 
     final String[] fooDots = new String[] { ".." + FOO + "..", ".." + FOO, FOO + ".." }; 
     final String[] foo = new String[] { FOO, FOO, FOO }; 
     assertNull(StringUtils.stripAll((String[]) null)); 
     assertArrayEquals(empty, StringUtils.stripAll()); 
     assertArrayEquals(new String[] { null }, StringUtils.stripAll((String) null)); 
     assertArrayEquals(empty, StringUtils.stripAll(empty)); 
     assertArrayEquals(foo, StringUtils.stripAll(fooSpace)); 
     assertNull(StringUtils.stripAll(null, null)); 
     assertArrayEquals(foo, StringUtils.stripAll(fooSpace, null)); 
     assertArrayEquals(foo, StringUtils.stripAll(fooDots, ".")); 
 }
@Test
public void testStripAll6724() { 
     final String[] empty = new String[0]; 
     final String[] fooSpace = new String[] { "  " + FOO + "  ", "  " + FOO, FOO + "  " }; 
     final String[] fooDots = new String[] { ".." + FOO + "..", ".." + FOO, FOO + ".." }; 
     final String[] foo = new String[] { FOO, FOO, FOO }; 
     assertNull(StringUtils.stripAll((String[]) null)); 
     assertArrayEquals(empty, StringUtils.stripAll()); 
     assertArrayEquals(new String[] { null }, StringUtils.stripAll((String) null)); 
     assertArrayEquals(empty, StringUtils.stripAll(empty)); 
     assertArrayEquals(foo, StringUtils.stripAll(fooSpace)); 
     assertNull(StringUtils.stripAll(null, null)); 
     assertArrayEquals(foo, StringUtils.stripAll(fooSpace, null)); 
     assertArrayEquals(foo, StringUtils.stripAll(fooDots, ".")); 
 }
@Test
public void testStripAccents6773() { 
     final String cue = "\u00C7\u00FA\u00EA"; 
     assertEquals("Failed to strip accents from " + cue, "Cue", StringUtils.stripAccents(cue)); 
     final String lots = "\u00C0\u00C1\u00C2\u00C3\u00C4\u00C5\u00C7\u00C8\u00C9" + "\u00CA\u00CB\u00CC\u00CD\u00CE\u00CF\u00D1\u00D2\u00D3" + "\u00D4\u00D5\u00D6\u00D9\u00DA\u00DB\u00DC\u00DD"; 
     assertEquals("Failed to strip accents from " + lots, "AAAAAACEEEEIIIINOOOOOUUUUY", StringUtils.stripAccents(lots)); 
     assertNull("Failed null safety", StringUtils.stripAccents(null)); 
     assertEquals("Failed empty String", "", StringUtils.stripAccents("")); 
     assertEquals("Failed to handle non-accented text", "control", StringUtils.stripAccents("control")); 
     assertEquals("Failed to handle easy example", "eclair", StringUtils.stripAccents("\u00E9clair")); 
 }
@Test
public void testStripEnd_StringString6939() { 
     assertEquals(null, StringUtils.stripEnd(null, null)); 
     assertEquals("", StringUtils.stripEnd("", null)); 
     assertEquals("", StringUtils.stripEnd("        ", null)); 
     assertEquals("  abc", StringUtils.stripEnd("  abc  ", null)); 
     assertEquals(StringUtilsTest.WHITESPACE + StringUtilsTest.NON_WHITESPACE, StringUtils.stripEnd(StringUtilsTest.WHITESPACE + StringUtilsTest.NON_WHITESPACE + StringUtilsTest.WHITESPACE, null)); 
     assertEquals(null, StringUtils.stripEnd(null, "")); 
     assertEquals("", StringUtils.stripEnd("", "")); 
     assertEquals("        ", StringUtils.stripEnd("        ", "")); 
     assertEquals("  abc  ", StringUtils.stripEnd("  abc  ", "")); 
     assertEquals(StringUtilsTest.WHITESPACE, StringUtils.stripEnd(StringUtilsTest.WHITESPACE, "")); 
     assertEquals(null, StringUtils.stripEnd(null, " ")); 
     assertEquals("", StringUtils.stripEnd("", " ")); 
     assertEquals("", StringUtils.stripEnd("        ", " ")); 
     assertEquals("  abc", StringUtils.stripEnd("  abc  ", " ")); 
     assertEquals(null, StringUtils.stripEnd(null, "ab")); 
     assertEquals("", StringUtils.stripEnd("", "ab")); 
     assertEquals("        ", StringUtils.stripEnd("        ", "ab")); 
     assertEquals("  abc  ", StringUtils.stripEnd("  abc  ", "ab")); 
     assertEquals("abc", StringUtils.stripEnd("abcabab", "ab")); 
     assertEquals(StringUtilsTest.WHITESPACE, StringUtils.stripEnd(StringUtilsTest.WHITESPACE, "")); 
 }
@Test
public void testStripToEmpty_String7085() { 
     assertEquals("", StringUtils.stripToEmpty(null)); 
     assertEquals("", StringUtils.stripToEmpty("")); 
     assertEquals("", StringUtils.stripToEmpty("        ")); 
     assertEquals("", StringUtils.stripToEmpty(StringUtilsTest.WHITESPACE)); 
     assertEquals("ab c", StringUtils.stripToEmpty("  ab c  ")); 
     assertEquals(StringUtilsTest.NON_WHITESPACE, StringUtils.stripToEmpty(StringUtilsTest.WHITESPACE + StringUtilsTest.NON_WHITESPACE + StringUtilsTest.WHITESPACE)); 
 }
@Test
public void testStripEnd_StringString7388() { 
     assertEquals(null, StringUtils.stripEnd(null, null)); 
     assertEquals("", StringUtils.stripEnd("", null)); 
     assertEquals("", StringUtils.stripEnd("        ", null)); 
     assertEquals("  abc", StringUtils.stripEnd("  abc  ", null)); 
     assertEquals(StringUtilsTest.WHITESPACE + StringUtilsTest.NON_WHITESPACE, StringUtils.stripEnd(StringUtilsTest.WHITESPACE + StringUtilsTest.NON_WHITESPACE + StringUtilsTest.WHITESPACE, null)); 
     assertEquals(null, StringUtils.stripEnd(null, "")); 
     assertEquals("", StringUtils.stripEnd("", "")); 
     assertEquals("        ", StringUtils.stripEnd("        ", "")); 
     assertEquals("  abc  ", StringUtils.stripEnd("  abc  ", "")); 
     assertEquals(StringUtilsTest.WHITESPACE, StringUtils.stripEnd(StringUtilsTest.WHITESPACE, "")); 
     assertEquals(null, StringUtils.stripEnd(null, " ")); 
     assertEquals("", StringUtils.stripEnd("", " ")); 
     assertEquals("", StringUtils.stripEnd("        ", " ")); 
     assertEquals("  abc", StringUtils.stripEnd("  abc  ", " ")); 
     assertEquals(null, StringUtils.stripEnd(null, "ab")); 
     assertEquals("", StringUtils.stripEnd("", "ab")); 
     assertEquals("        ", StringUtils.stripEnd("        ", "ab")); 
     assertEquals("  abc  ", StringUtils.stripEnd("  abc  ", "ab")); 
     assertEquals("abc", StringUtils.stripEnd("abcabab", "ab")); 
     assertEquals(StringUtilsTest.WHITESPACE, StringUtils.stripEnd(StringUtilsTest.WHITESPACE, "")); 
 }
@Test
public void testStripToEmpty_String7759() { 
     assertEquals("", StringUtils.stripToEmpty(null)); 
     assertEquals("", StringUtils.stripToEmpty("")); 
     assertEquals("", StringUtils.stripToEmpty("        ")); 
     assertEquals("", StringUtils.stripToEmpty(StringUtilsTest.WHITESPACE)); 
     assertEquals("ab c", StringUtils.stripToEmpty("  ab c  ")); 
     assertEquals(StringUtilsTest.NON_WHITESPACE, StringUtils.stripToEmpty(StringUtilsTest.WHITESPACE + StringUtilsTest.NON_WHITESPACE + StringUtilsTest.WHITESPACE)); 
 }
@Test
public void testStrip_String7963() { 
     assertEquals(null, StringUtils.strip(null)); 
     assertEquals("", StringUtils.strip("")); 
     assertEquals("", StringUtils.strip("        ")); 
     assertEquals("abc", StringUtils.strip("  abc  ")); 
     assertEquals(StringUtilsTest.NON_WHITESPACE, StringUtils.strip(StringUtilsTest.WHITESPACE + StringUtilsTest.NON_WHITESPACE + StringUtilsTest.WHITESPACE)); 
 }
@Test
public void testTrimToNull8094() { 
     assertEquals(FOO, StringUtils.trimToNull(FOO + "  ")); 
     assertEquals(FOO, StringUtils.trimToNull(" " + FOO + "  ")); 
     assertEquals(FOO, StringUtils.trimToNull(" " + FOO)); 
     assertEquals(FOO, StringUtils.trimToNull(FOO + "")); 
     assertEquals(null, StringUtils.trimToNull(" \t\r\n\b ")); 
     assertEquals(null, StringUtils.trimToNull(StringUtilsTest.TRIMMABLE)); 
     assertEquals(StringUtilsTest.NON_TRIMMABLE, StringUtils.trimToNull(StringUtilsTest.NON_TRIMMABLE)); 
     assertEquals(null, StringUtils.trimToNull("")); 
     assertEquals(null, StringUtils.trimToNull(null)); 
 }
@Test
public void testStripStart_StringString8554() { 
     assertEquals(null, StringUtils.stripStart(null, null)); 
     assertEquals("", StringUtils.stripStart("", null)); 
     assertEquals("", StringUtils.stripStart("        ", null)); 
     assertEquals("abc  ", StringUtils.stripStart("  abc  ", null)); 
     assertEquals(StringUtilsTest.NON_WHITESPACE + StringUtilsTest.WHITESPACE, StringUtils.stripStart(StringUtilsTest.WHITESPACE + StringUtilsTest.NON_WHITESPACE + StringUtilsTest.WHITESPACE, null)); 
     assertEquals(null, StringUtils.stripStart(null, "")); 
     assertEquals("", StringUtils.stripStart("", "")); 
     assertEquals("        ", StringUtils.stripStart("        ", "")); 
     assertEquals("  abc  ", StringUtils.stripStart("  abc  ", "")); 
     assertEquals(StringUtilsTest.WHITESPACE, StringUtils.stripStart(StringUtilsTest.WHITESPACE, "")); 
     assertEquals(null, StringUtils.stripStart(null, " ")); 
     assertEquals("", StringUtils.stripStart("", " ")); 
     assertEquals("", StringUtils.stripStart("        ", " ")); 
     assertEquals("abc  ", StringUtils.stripStart("  abc  ", " ")); 
     assertEquals(null, StringUtils.stripStart(null, "ab")); 
     assertEquals("", StringUtils.stripStart("", "ab")); 
     assertEquals("        ", StringUtils.stripStart("        ", "ab")); 
     assertEquals("  abc  ", StringUtils.stripStart("  abc  ", "ab")); 
     assertEquals("cabab", StringUtils.stripStart("abcabab", "ab")); 
     assertEquals(StringUtilsTest.WHITESPACE, StringUtils.stripStart(StringUtilsTest.WHITESPACE, "")); 
 }
@Test
public void testStripEnd_StringString8582() { 
     assertEquals(null, StringUtils.stripEnd(null, null)); 
     assertEquals("", StringUtils.stripEnd("", null)); 
     assertEquals("", StringUtils.stripEnd("        ", null)); 
     assertEquals("  abc", StringUtils.stripEnd("  abc  ", null)); 
     assertEquals(StringUtilsTest.WHITESPACE + StringUtilsTest.NON_WHITESPACE, StringUtils.stripEnd(StringUtilsTest.WHITESPACE + StringUtilsTest.NON_WHITESPACE + StringUtilsTest.WHITESPACE, null)); 
     assertEquals(null, StringUtils.stripEnd(null, "")); 
     assertEquals("", StringUtils.stripEnd("", "")); 
     assertEquals("        ", StringUtils.stripEnd("        ", "")); 
     assertEquals("  abc  ", StringUtils.stripEnd("  abc  ", "")); 
     assertEquals(StringUtilsTest.WHITESPACE, StringUtils.stripEnd(StringUtilsTest.WHITESPACE, "")); 
     assertEquals(null, StringUtils.stripEnd(null, " ")); 
     assertEquals("", StringUtils.stripEnd("", " ")); 
     assertEquals("", StringUtils.stripEnd("        ", " ")); 
     assertEquals("  abc", StringUtils.stripEnd("  abc  ", " ")); 
     assertEquals(null, StringUtils.stripEnd(null, "ab")); 
     assertEquals("", StringUtils.stripEnd("", "ab")); 
     assertEquals("        ", StringUtils.stripEnd("        ", "ab")); 
     assertEquals("  abc  ", StringUtils.stripEnd("  abc  ", "ab")); 
     assertEquals("abc", StringUtils.stripEnd("abcabab", "ab")); 
     assertEquals(StringUtilsTest.WHITESPACE, StringUtils.stripEnd(StringUtilsTest.WHITESPACE, "")); 
 }
@Test
public void testStrip_String8999() { 
     assertEquals(null, StringUtils.strip(null)); 
     assertEquals("", StringUtils.strip("")); 
     assertEquals("", StringUtils.strip("        ")); 
     assertEquals("abc", StringUtils.strip("  abc  ")); 
     assertEquals(StringUtilsTest.NON_WHITESPACE, StringUtils.strip(StringUtilsTest.WHITESPACE + StringUtilsTest.NON_WHITESPACE + StringUtilsTest.WHITESPACE)); 
 }
@Test
public void testStripEnd_StringString9079() { 
     assertEquals(null, StringUtils.stripEnd(null, null)); 
     assertEquals("", StringUtils.stripEnd("", null)); 
     assertEquals("", StringUtils.stripEnd("        ", null)); 
     assertEquals("  abc", StringUtils.stripEnd("  abc  ", null)); 
     assertEquals(StringUtilsTest.WHITESPACE + StringUtilsTest.NON_WHITESPACE, StringUtils.stripEnd(StringUtilsTest.WHITESPACE + StringUtilsTest.NON_WHITESPACE + StringUtilsTest.WHITESPACE, null)); 
     assertEquals(null, StringUtils.stripEnd(null, "")); 
     assertEquals("", StringUtils.stripEnd("", "")); 
     assertEquals("        ", StringUtils.stripEnd("        ", "")); 
     assertEquals("  abc  ", StringUtils.stripEnd("  abc  ", "")); 
     assertEquals(StringUtilsTest.WHITESPACE, StringUtils.stripEnd(StringUtilsTest.WHITESPACE, "")); 
     assertEquals(null, StringUtils.stripEnd(null, " ")); 
     assertEquals("", StringUtils.stripEnd("", " ")); 
     assertEquals("", StringUtils.stripEnd("        ", " ")); 
     assertEquals("  abc", StringUtils.stripEnd("  abc  ", " ")); 
     assertEquals(null, StringUtils.stripEnd(null, "ab")); 
     assertEquals("", StringUtils.stripEnd("", "ab")); 
     assertEquals("        ", StringUtils.stripEnd("        ", "ab")); 
     assertEquals("  abc  ", StringUtils.stripEnd("  abc  ", "ab")); 
     assertEquals("abc", StringUtils.stripEnd("abcabab", "ab")); 
     assertEquals(StringUtilsTest.WHITESPACE, StringUtils.stripEnd(StringUtilsTest.WHITESPACE, "")); 
 }
@Test
public void testStripStart_StringString9388() { 
     assertEquals(null, StringUtils.stripStart(null, null)); 
     assertEquals("", StringUtils.stripStart("", null)); 
     assertEquals("", StringUtils.stripStart("        ", null)); 
     assertEquals("abc  ", StringUtils.stripStart("  abc  ", null)); 
     assertEquals(StringUtilsTest.NON_WHITESPACE + StringUtilsTest.WHITESPACE, StringUtils.stripStart(StringUtilsTest.WHITESPACE + StringUtilsTest.NON_WHITESPACE + StringUtilsTest.WHITESPACE, null)); 
     assertEquals(null, StringUtils.stripStart(null, "")); 
     assertEquals("", StringUtils.stripStart("", "")); 
     assertEquals("        ", StringUtils.stripStart("        ", "")); 
     assertEquals("  abc  ", StringUtils.stripStart("  abc  ", "")); 
     assertEquals(StringUtilsTest.WHITESPACE, StringUtils.stripStart(StringUtilsTest.WHITESPACE, "")); 
     assertEquals(null, StringUtils.stripStart(null, " ")); 
     assertEquals("", StringUtils.stripStart("", " ")); 
     assertEquals("", StringUtils.stripStart("        ", " ")); 
     assertEquals("abc  ", StringUtils.stripStart("  abc  ", " ")); 
     assertEquals(null, StringUtils.stripStart(null, "ab")); 
     assertEquals("", StringUtils.stripStart("", "ab")); 
     assertEquals("        ", StringUtils.stripStart("        ", "ab")); 
     assertEquals("  abc  ", StringUtils.stripStart("  abc  ", "ab")); 
     assertEquals("cabab", StringUtils.stripStart("abcabab", "ab")); 
     assertEquals(StringUtilsTest.WHITESPACE, StringUtils.stripStart(StringUtilsTest.WHITESPACE, "")); 
 }
@Test
public void testStripToNull9623() { 
         assertEquals(null, StringUtils.stripToNull(null)); 
         assertEquals("", StringUtils.stripToNull("")); 
         assertEquals("", StringUtils.stripToNull("  ")); 
          
         assertEquals("", StringUtils.stripToNull("  ")); 
         assertEquals("abc", StringUtils.stripToNull("  abc  ")); 
         assertEquals(StringUtilsTest.NON_WHITESPACE,  
             StringUtils.stripToNull(StringUtilsTest.WHITESPACE + StringUtilsTest.NON_WHITESPACE + StringUtilsTest.WHITESPACE)); 
     }
@Test
public void testTrimToEmpty9645() { 
         assertEquals("", StringUtils.trimToEmpty(null)); 
         assertEquals("", StringUtils.trimToEmpty("")); 
         assertEquals("", StringUtils.trimToEmpty("  \u000C  \t\t\u001F\n\n \u000B  ")); 
         assertEquals("", StringUtils.trimToEmpty("")); 
         assertEquals("", StringUtils.trimToEmpty(StringUtilsTest.TRIMMABLE)); 
         assertEquals(StringUtilsTest.NON_TRIMMABLE, StringUtils.trimToEmpty(StringUtilsTest.NON_TRIMMABLE)); 
         assertEquals(StringUtilsTest.WHITESPACE, StringUtils.trimToEmpty(StringUtilsTest.WHITESPACE)); 
     }
@Test
public void testStrip_StringString11394() { 
         assertEquals(null, StringUtils.strip(null, null)); 
         assertEquals("", StringUtils.strip("", null)); 
         assertEquals("", StringUtils.strip("", "")); 
         assertEquals("", StringUtils.strip("        ", null)); 
         assertEquals("abc  ", StringUtils.strip("  abc  ", null)); 
          
         assertEquals(StringUtilsTest.NON_WHITESPACE + StringUtilsTest.WHITESPACE,  
             StringUtils.strip(StringUtilsTest.WHITESPACE + StringUtilsTest.NON_WHITESPACE + StringUtilsTest.WHITESPACE, null)); 
         assertEquals(StringUtilsTest.WHITESPACE, StringUtils.strip(StringUtilsTest.WHITESPACE, "")); 
         assertEquals(StringUtilsTest.WHITESPACE, StringUtils.strip("  abc  ", "")); 
         assertEquals(StringUtilsTest.WHITESPACE, StringUtils.strip("  abc  ", "")); 
          
         assertEquals(StringUtilsTest.WHITESPACE, StringUtils.strip(StringUtilsTest.WHITESPACE, "")); 
         assertEquals(StringUtilsTest.WHITESPACE, StringUtils.strip("  abc  ", "")); 
         assertEquals(StringUtilsTest.WHITESPACE, StringUtils.strip("  abc  ", "")); 
         assertEquals(StringUtilsTest.WHITESPACE, StringUtils.strip("  abc  ", "")); 
         assertEquals(StringUtilsTest.WHITESPACE, StringUtils.strip("  abc  ", "")); 
         assertEquals(StringUtilsTest.WHITESPACE, StringUtils.strip("  abc  ", "")); 
         assertEquals(StringUtilsTest.WHITESPACE, StringUtils.strip("  abc  ", "")); 
     }
@Test
public void testStripToNull11395() { 
         assertEquals(null, StringUtils.stripToNull(null)); 
         assertEquals("", StringUtils.stripToNull("")); 
         assertEquals("", StringUtils.stripToNull("  ")); 
          
         assertEquals("", StringUtils.stripToNull("  ")); 
         assertEquals("abc", StringUtils.stripToNull("  abc  ")); 
         assertEquals(StringUtilsTest.NON_WHITESPACE,  
             StringUtils.stripToNull(StringUtilsTest.WHITESPACE + StringUtilsTest.NON_WHITESPACE + StringUtilsTest.WHITESPACE)); 
     }
@Test
public void testStrip_StringString11397() { 
         assertEquals(null, StringUtils.strip(null, null)); 
         assertEquals("", StringUtils.strip("", null)); 
         assertEquals("", StringUtils.strip("", "")); 
         assertEquals("", StringUtils.strip("        ", null)); 
         assertEquals("abc  ", StringUtils.strip("  abc  ", null)); 
          
         assertEquals(StringUtilsTest.NON_WHITESPACE + StringUtilsTest.WHITESPACE,  
             StringUtils.strip(StringUtilsTest.WHITESPACE + StringUtilsTest.NON_WHITESPACE + StringUtilsTest.WHITESPACE, null)); 
         assertEquals(StringUtilsTest.WHITESPACE, StringUtils.strip(StringUtilsTest.WHITESPACE + StringUtilsTest.WHITESPACE, "")); 
         assertEquals(StringUtilsTest.WHITESPACE, StringUtils.strip(StringUtilsTest.WHITESPACE, "")); 
         assertEquals(StringUtilsTest.WHITESPACE, StringUtils.strip("  abc  ", "")); 
         assertEquals(StringUtilsTest.WHITESPACE, StringUtils.strip("  abc  ", "")); 
         assertEquals(StringUtilsTest.WHITESPACE, StringUtils.strip("  abc  ", "")); 
          
         assertEquals(StringUtilsTest.WHITESPACE, StringUtils.strip(StringUtilsTest.WHITESPACE, "")); 
         assertEquals(StringUtilsTest.WHITESPACE, StringUtils.strip("  abc  ", "")); 
         assertEquals(StringUtilsTest.WHITESPACE, StringUtils.strip("  abc  ", "")); 
         assertEquals(StringUtilsTest.WHITESPACE, StringUtils.strip("  abc  ", "")); 
         assertEquals(StringUtilsTest.WHITESPACE, StringUtils.strip(StringUtilsTest.WHITESPACE, "")); 
     }
@Test
public void testStrip_StringString11398() { 
         assertEquals(null, StringUtils.strip(null, null)); 
         assertEquals("", StringUtils.strip("", null)); 
         assertEquals("", StringUtils.strip("", "")); 
         assertEquals(null, StringUtils.strip(null, "ab")); 
          
         assertEquals("", StringUtils.strip("", "")); 
         assertEquals("", StringUtils.strip("", "ab")); 
         assertEquals("", StringUtils.strip("", "ab")); 
          
         assertEquals("", StringUtils.strip("        ", "ab")); 
         assertEquals("  abc", StringUtils.strip("  abc  ", "ab")); 
         assertEquals(StringUtilsTest.NON_WHITESPACE + StringUtilsTest.WHITESPACE,  
             StringUtils.strip(StringUtilsTest.WHITESPACE + StringUtilsTest.NON_WHITESPACE + StringUtilsTest.WHITESPACE, null) ); 
         assertEquals(StringUtilsTest.WHITESPACE, StringUtils.strip(StringUtilsTest.WHITESPACE, "") ); 
     }
@Test
public void testStripToNull11402() { 
         assertEquals(null, StringUtils.stripToNull(null)); 
         assertEquals("", StringUtils.stripToNull("")); 
         assertEquals("", StringUtils.stripToNull("  ")); 
          
         assertEquals("", StringUtils.stripToNull("  ")); 
         assertEquals("abc", StringUtils.stripToNull("  abc  ")); 
         assertEquals(StringUtilsTest.NON_WHITESPACE + StringUtilsTest.WHITESPACE,  
             StringUtils.stripToNull(StringUtilsTest.WHITESPACE + StringUtilsTest.NON_WHITESPACE + StringUtilsTest.WHITESPACE + StringUtilsTest.WHITESPACE)); 
          
         assertEquals(null, StringUtils.stripToNull(null)); 
         assertEquals("", StringUtils.stripToNull("")); 
         assertEquals("abc", StringUtils.stripToNull("  abc  ")); 
          
         assertEquals("i am a robot", StringUtils.stripToNull("I am a robot")); 
         assertEquals(null, StringUtils.stripToNull(null)); 
         assertEquals("i am a machine", StringUtils.stripToNull("i am a robot")); 
     }
@Test
public void testStrip_StringString11405() { 
         assertEquals(null, StringUtils.strip(null, null)); 
         assertEquals("", StringUtils.strip("", null)); 
         assertEquals("", StringUtils.strip("", "")); 
         assertEquals("", StringUtils.strip("        ", null)); 
         assertEquals("abc  ", StringUtils.strip("  abc  ", null)); 
          
         assertEquals(StringUtilsTest.NON_WHITESPACE + StringUtilsTest.WHITESPACE,  
             StringUtils.strip(StringUtilsTest.WHITESPACE + StringUtilsTest.NON_WHITESPACE + StringUtilsTest.WHITESPACE, null)); 
         assertEquals(StringUtilsTest.WHITESPACE, StringUtils.strip(StringUtilsTest.WHITESPACE + StringUtilsTest.WHITESPACE, "")); 
         assertEquals(StringUtilsTest.WHITESPACE, StringUtils.strip("  abc  ", null)); 
         assertEquals(StringUtilsTest.WHITESPACE, StringUtils.strip("  abc  ", "")); 
         assertEquals(StringUtilsTest.WHITESPACE, StringUtils.strip("  abc  ", "")); 
          
         assertEquals(StringUtilsTest.WHITESPACE, StringUtils.strip(StringUtilsTest.WHITESPACE, "")); 
         assertEquals(StringUtilsTest.WHITESPACE, StringUtils.strip("  abc  ", "")); 
         assertEquals(StringUtilsTest.WHITESPACE, StringUtils.strip("  abc  ", "")); 
         assertEquals(StringUtilsTest.WHITESPACE, StringUtils.strip("  abc  ", "")); 
         assertEquals(StringUtilsTest.WHITESPACE, StringUtils.strip("  abc  ", "")); 
         assertEquals(StringUtilsTest.WHITESPACE, StringUtils.strip(StringUtilsTest.WHITESPACE, "")); 
     }
@Test
public void testStrip_StringString11409() { 
         assertEquals(null, StringUtils.strip(null, null)); 
         assertEquals("", StringUtils.strip("", null)); 
         assertEquals("", StringUtils.strip("", "")); 
         assertEquals("", StringUtils.strip("        ", null)); 
         assertEquals("abc  ", StringUtils.strip("  abc  ", null)); 
          
         assertEquals(StringUtilsTest.NON_WHITESPACE + StringUtilsTest.WHITESPACE,  
             StringUtils.strip(StringUtilsTest.WHITESPACE + StringUtilsTest.NON_WHITESPACE + StringUtilsTest.WHITESPACE, null)); 
         assertEquals(StringUtilsTest.WHITESPACE, StringUtils.strip(StringUtilsTest.WHITESPACE, "")); 
         assertEquals(StringUtilsTest.WHITESPACE, StringUtils.strip("  abc  ", "")); 
         assertEquals(StringUtilsTest.WHITESPACE, StringUtils.strip("  abc  ", "")); 
          
         assertEquals(StringUtilsTest.WHITESPACE, StringUtils.strip(StringUtilsTest.WHITESPACE, "")); 
         assertEquals(StringUtilsTest.WHITESPACE, StringUtils.strip("  abc  ", "")); 
         assertEquals(StringUtilsTest.WHITESPACE, StringUtils.strip("  abc  ", "")); 
         assertEquals(StringUtilsTest.WHITESPACE, StringUtils.strip("  abc  ", "")); 
         assertEquals(StringUtilsTest.WHITESPACE, StringUtils.strip("  abc  ", "")); 
         assertEquals(StringUtilsTest.WHITESPACE, StringUtils.strip("  abc  ", "")); 
         assertEquals(StringUtilsTest.WHITESPACE, StringUtils.strip("  abc  ", "")); 
     }
@Test
public void testStripToNull11413() { 
         assertEquals(null, StringUtils.stripToNull(null)); 
         assertEquals("", StringUtils.stripToNull("")); 
         assertEquals("", StringUtils.stripToNull("  ")); 
          
         assertEquals("", StringUtils.stripToNull("  ")); 
         assertEquals("abc", StringUtils.stripToNull("  abc  ")); 
         assertEquals(StringUtilsTest.NON_WHITESPACE,  
             StringUtils.stripToNull("  abc  ")); 
          
         assertEquals(StringUtilsTest.WHITESPACE,  
             StringUtils.stripToNull(StringUtilsTest.WHITESPACE + StringUtilsTest.NON_WHITESPACE + StringUtilsTest.WHITESPACE)); 
         assertEquals(StringUtilsTest.WHITESPACE,  
             StringUtils.stripToNull(StringUtilsTest.WHITESPACE + StringUtilsTest.WHITESPACE + StringUtilsTest.WHITESPACE)); 
     }
@Test
public void testStripToNull11416() { 
         assertEquals(null, StringUtils.stripToNull(null)); 
         assertEquals("", StringUtils.stripToNull("")); 
         assertEquals("", StringUtils.stripToNull("  ")); 
          
         assertEquals("", StringUtils.stripToNull("  ")); 
         assertEquals("abc", StringUtils.stripToNull("  abc  ")); 
         assertEquals(StringUtilsTest.NON_WHITESPACE,  
             StringUtils.stripToNull(StringUtilsTest.WHITESPACE + StringUtilsTest.NON_WHITESPACE + StringUtilsTest.WHITESPACE)); 
          
         assertEquals(StringUtilsTest.WHITESPACE,  
             StringUtils.stripToNull("  abc  ")); 
         assertEquals(StringUtilsTest.WHITESPACE,  
             StringUtils.stripToNull(StringUtilsTest.WHITESPACE + StringUtilsTest.WHITESPACE + StringUtilsTest.WHITESPACE)); 
     }
@Test
public void testTrimToEmpty11734() { 
         assertEquals("", StringUtils.trimToEmpty(null)); 
         assertEquals("", StringUtils.trimToEmpty("")); 
         assertEquals("", StringUtils.trimToEmpty("  \u000C  \t\t\u001F\n\n \u000B  ")); 
         assertEquals("", StringUtils.trimToEmpty("")); 
         assertEquals("", StringUtils.trimToEmpty(StringUtilsTest.TRIMMABLE)); 
         assertEquals(StringUtilsTest.NON_TRIMMABLE, StringUtils.trimToEmpty(StringUtilsTest.NON_TRIMMABLE)); 
         assertEquals(StringUtilsTest.WHITESPACE, StringUtils.trimToEmpty(StringUtilsTest.WHITESPACE)); 
     }
    

    

    

    

    //-----------------------------------------------------------------------
    

    

    

    //-----------------------------------------------------------------------
    
    
    
    
    
    
    
    
    
    
    

    

    
}
