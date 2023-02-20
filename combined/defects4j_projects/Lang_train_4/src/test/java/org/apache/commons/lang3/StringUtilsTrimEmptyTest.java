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
public void testIsNotBlank993() { 
     assertFalse(StringUtils.isNotBlank(null)); 
     assertFalse(StringUtils.isNotBlank("")); 
     assertFalse(StringUtils.isNotBlank(StringUtilsTest.WHITESPACE)); 
     assertTrue(StringUtils.isNotBlank("foo")); 
     assertTrue(StringUtils.isNotBlank("  foo  ")); 
 }
@Test
public void testTrim994() { 
     assertEquals(FOO, StringUtils.trim(FOO + "  ")); 
     assertEquals(FOO, StringUtils.trim(" " + FOO + "  ")); 
     assertEquals(FOO, StringUtils.trim(" " + FOO)); 
     assertEquals(FOO, StringUtils.trim(FOO + "")); 
     assertEquals("", StringUtils.trim(" \t\r\n\b ")); 
     assertEquals("", StringUtils.trim(StringUtilsTest.TRIMMABLE)); 
     assertEquals(StringUtilsTest.NON_TRIMMABLE, StringUtils.trim(StringUtilsTest.NON_TRIMMABLE)); 
     assertEquals("", StringUtils.trim("")); 
     assertEquals(null, StringUtils.trim(null)); 
 }
@Test
public void testTrimToNull995() { 
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
public void testTrimToEmpty996() { 
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
public void testStrip_String997() { 
     assertEquals(null, StringUtils.strip(null)); 
     assertEquals("", StringUtils.strip("")); 
     assertEquals("", StringUtils.strip("        ")); 
     assertEquals("abc", StringUtils.strip("  abc  ")); 
     assertEquals(StringUtilsTest.NON_WHITESPACE, StringUtils.strip(StringUtilsTest.WHITESPACE + StringUtilsTest.NON_WHITESPACE + StringUtilsTest.WHITESPACE)); 
 }
@Test
public void testStripStart_StringString998() { 
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
public void testStrip_StringString999() { 
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
public void testStripAll1001() { 
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
    

    

    

    

    //-----------------------------------------------------------------------
    

    

    

    //-----------------------------------------------------------------------
    
    
    
    
    
    
    
    
    
    
    

    

    
}
