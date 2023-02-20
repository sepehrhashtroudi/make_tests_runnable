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
public void testIsNotEmpty979() { 
     assertFalse(StringUtils.isNotEmpty(null)); 
     assertFalse(StringUtils.isNotEmpty("")); 
     assertTrue(StringUtils.isNotEmpty(" ")); 
     assertTrue(StringUtils.isNotEmpty("foo")); 
     assertTrue(StringUtils.isNotEmpty("  foo  ")); 
 }
@Test
public void testTrimToNull980() { 
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
public void testTrimToEmpty981() { 
     assertEquals(FOO, StringUtils.trimToEmpty(FOO + "  ")); 
     assertEquals(FOO, StringUtils.trimToEmpty(" " + FOO + "  ")); 
     assertEquals(FOO, StringUtils.trimToEmpty(" " + FOO)); 
     assertEquals(FOO, StringUtils.trimToEmpty(FOO + "")); 
     assertEquals("", StringUtils.trimToEmpty(" \t\r\n\b ")); 
     assertEquals("", StringUtils.trimToEmpty(StringUtilsTest.TRIMMABLE)); 
     assertEquals(StringUtilsTest.NON_TRIMMABLE, StringUtils.trimToEmpty(StringUtilsTest.NON_TRIMMABLE)); 
     assertEquals("", StringUtils.trimToEmpty("")); 
     assertEquals("", StringUtils.trimToEmpty(null)); 
 }
@Test
public void testStripToNull_String982() { 
     assertEquals(null, StringUtils.stripToNull(null)); 
     assertEquals(null, StringUtils.stripToNull("")); 
     assertEquals(null, StringUtils.stripToNull("        ")); 
     assertEquals(null, StringUtils.stripToNull(StringUtilsTest.WHITESPACE)); 
     assertEquals("ab c", StringUtils.stripToNull("  ab c  ")); 
     assertEquals(StringUtilsTest.NON_WHITESPACE, StringUtils.stripToNull(StringUtilsTest.WHITESPACE + StringUtilsTest.NON_WHITESPACE + StringUtilsTest.WHITESPACE)); 
 }
@Test
public void testStripToEmpty_String983() { 
     assertEquals("", StringUtils.stripToEmpty(null)); 
     assertEquals("", StringUtils.stripToEmpty("")); 
     assertEquals("", StringUtils.stripToEmpty("        ")); 
     assertEquals("", StringUtils.stripToEmpty(StringUtilsTest.WHITESPACE)); 
     assertEquals("ab c", StringUtils.stripToEmpty("  ab c  ")); 
     assertEquals(StringUtilsTest.NON_WHITESPACE, StringUtils.stripToEmpty(StringUtilsTest.WHITESPACE + StringUtilsTest.NON_WHITESPACE + StringUtilsTest.WHITESPACE)); 
 }
@Test
public void testStrip_StringString984() { 
     assertEquals(null, StringUtils.strip(null, null)); 
     assertEquals("", StringUtils.strip("", null)); 
     assertEquals("", StringUtils.strip("        ", null)); 
     assertEquals("abc", StringUtils.strip("  abc  ", null)); 
     assertEquals(StringUtilsTest.NON_WHITESPACE, StringUtils.strip(StringUtilsTest.WHITESPACE + StringUtilsTest.NON_WHITESPACE + StringUtilsTest.WHITESPACE, null)); 
     assertEquals(null, StringUtils.strip(null, "")); 
     assertEquals("", StringUtils.strip("", "")); 
     assertEquals("        ", StringUtils.strip("        ", "")); 
     assertEquals("  abc  ", StringUtils.strip("  abc  ", "")); 
     assertEquals(StringUtilsTest.WHITESPACE, StringUtils.strip(StringUtilsTest.WHITESPACE, "")); 
     assertEquals(null, StringUtils.strip(null, " ")); 
     assertEquals("", StringUtils.strip("", " ")); 
     assertEquals("", StringUtils.strip("        ", " ")); 
     assertEquals("abc", StringUtils.strip("  abc  ", " ")); 
     assertEquals(null, StringUtils.strip(null, "ab")); 
     assertEquals("", StringUtils.strip("", "ab")); 
     assertEquals("        ", StringUtils.strip("        ", "ab")); 
     assertEquals("  abc  ", StringUtils.strip("  abc  ", "ab")); 
     assertEquals("c", StringUtils.strip("abcabab", "ab")); 
     assertEquals(StringUtilsTest.WHITESPACE, StringUtils.strip(StringUtilsTest.WHITESPACE, "")); 
 }
@Test
public void testStripAll985() { 
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
public void testStripAccents986() { 
     final String cue = "\u00C7\u00FA\u00EA"; 
     assertEquals("Failed to strip accents from " + cue, "Cue", StringUtils.stripAccents(cue)); 
     final String lots = "\u00C0\u00C1\u00C2\u00C3\u00C4\u00C5\u00C7\u00C8\u00C9" + "\u00CA\u00CB\u00CC\u00CD\u00CE\u00CF\u00D1\u00D2\u00D3" + "\u00D4\u00D5\u00D6\u00D9\u00DA\u00DB\u00DC\u00DD"; 
     assertEquals("Failed to strip accents from " + lots, "AAAAAACEEEEIIIINOOOOOUUUUY", StringUtils.stripAccents(lots)); 
     assertNull("Failed null safety", StringUtils.stripAccents(null)); 
     assertEquals("Failed empty String", "", StringUtils.stripAccents("")); 
     assertEquals("Failed to handle non-accented text", "control", StringUtils.stripAccents("control")); 
     assertEquals("Failed to handle easy example", "eclair", StringUtils.stripAccents("\u00E9clair")); 
 }
    

    

    

    

    //-----------------------------------------------------------------------
    

    

    

    //-----------------------------------------------------------------------
    
    
    
    
    
    
    
    
    
    
    

    

    
}
