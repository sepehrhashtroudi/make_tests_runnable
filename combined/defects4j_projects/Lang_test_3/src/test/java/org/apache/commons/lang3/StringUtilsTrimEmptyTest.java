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
public void testIsWhitespace465() { 
     assertTrue(StringUtils.isWhitespace(null)); 
     assertTrue(StringUtils.isWhitespace("")); 
     assertTrue(StringUtils.isWhitespace(" ")); 
     assertTrue(StringUtils.isWhitespace("\t \n \t")); 
     assertFalse(StringUtils.isWhitespace("\t aa\n \t")); 
     assertTrue(StringUtils.isWhitespace(" ")); 
     assertFalse(StringUtils.isWhitespace(" a ")); 
     assertFalse(StringUtils.isWhitespace("a  ")); 
     assertFalse(StringUtils.isWhitespace("  a")); 
     assertFalse(StringUtils.isWhitespace("aba")); 
     assertTrue(StringUtils.isWhitespace(StringUtilsTest.WHITESPACE)); 
     assertFalse(StringUtils.isWhitespace(StringUtilsTest.NON_WHITESPACE)); 
 }
@Test
public void testIsNotEmpty466() { 
     assertFalse(StringUtils.isNotEmpty(null)); 
     assertFalse(StringUtils.isNotEmpty("")); 
     assertTrue(StringUtils.isNotEmpty(" ")); 
     assertTrue(StringUtils.isNotEmpty("foo")); 
     assertTrue(StringUtils.isNotEmpty("  foo  ")); 
 }
@Test
public void testTrim467() { 
     assertEquals(FOO, StringUtils.trim(FOO + "  ")); 
     assertEquals(FOO, StringUtils.trim(" " + FOO + "  ")); 
     assertEquals(FOO, StringUtils.trim(" " + FOO)); 
     assertEquals(FOO, StringUtils.trim(FOO + "")); 
     assertEquals(null, StringUtils.trim(" \t\r\n\b ")); 
     assertEquals(null, StringUtils.trim(StringUtilsTest.TRIMMABLE)); 
     assertEquals(StringUtilsTest.NON_TRIMMABLE, StringUtils.trim(StringUtilsTest.NON_TRIMMABLE)); 
     assertEquals(null, StringUtils.trim(null)); 
 }
@Test
public void testStrip_String468() { 
     assertEquals(null, StringUtils.strip(null)); 
     assertEquals("", StringUtils.strip("")); 
     assertEquals("", StringUtils.strip("        ")); 
     assertEquals("", StringUtils.strip(StringUtilsTest.WHITESPACE)); 
     assertEquals("ab c", StringUtils.strip("  ab c  ")); 
     assertEquals(StringUtilsTest.NON_WHITESPACE, StringUtils.strip(StringUtilsTest.WHITESPACE + StringUtilsTest.NON_WHITESPACE + StringUtilsTest.WHITESPACE)); 
 }
@Test
public void testStrip_StringString469() { 
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
    

    

    

    

    //-----------------------------------------------------------------------
    

    

    

    //-----------------------------------------------------------------------
    
    
    
    
    
    
    
    
    
    
    

    

    
}
