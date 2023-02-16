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
public void testSubstring_StringInt448() { 
     assertEquals(null, StringUtils.substring(null, -1)); 
     assertEquals(null, StringUtils.substring(null, 0)); 
     assertEquals(null, StringUtils.substring(null, 1)); 
     assertEquals("", StringUtils.substring("", 0)); 
     assertEquals("", StringUtils.substring("", 2)); 
     assertEquals("", StringUtils.substring("", -1)); 
     assertEquals("", StringUtils.substring(SENTENCE, 8)); 
     assertEquals(FOO, StringUtils.substring(SENTENCE, 0)); 
     assertEquals("o", StringUtils.substring(SENTENCE, -1)); 
     assertEquals(FOO, StringUtils.substring(SENTENCE, 0)); 
     assertEquals("o", StringUtils.substring(SENTENCE, 3)); 
     assertEquals(SENTENCE, StringUtils.substring(SENTENCE, 80)); 
 }
@Test
public void testSubstring_StringInt449() { 
     assertEquals(null, StringUtils.substring(null, 0)); 
     assertEquals(null, StringUtils.substring(null, 1)); 
     assertEquals("", StringUtils.substring("", 0)); 
     assertEquals("", StringUtils.substring("", 2)); 
     assertEquals("", StringUtils.substring(SENTENCE, 8)); 
     assertEquals("", StringUtils.substring(SENTENCE, 9)); 
     assertEquals(FOO, StringUtils.substring(SENTENCE, 0)); 
     assertEquals("o", StringUtils.substring(SENTENCE, -9)); 
     assertEquals(FOO, StringUtils.substring(SENTENCE, 0)); 
     assertEquals("o", StringUtils.substring(SENTENCE, -8)); 
     assertEquals("o", StringUtils.substring(SENTENCE, 3)); 
     assertEquals(SENTENCE, StringUtils.substring(SENTENCE, 80)); 
 }
@Test
public void testSubstring_StringInt450() { 
     assertEquals(null, StringUtils.substring(null, -1)); 
     assertEquals(null, StringUtils.substring(null, 0)); 
     assertEquals(null, StringUtils.substring(null, 1)); 
     assertEquals("", StringUtils.substring("", 0)); 
     assertEquals("", StringUtils.substring("", 2)); 
     assertEquals("", StringUtils.substring("", -1)); 
     assertEquals("", StringUtils.substring(SENTENCE, 8)); 
     assertEquals(FOO, StringUtils.substring(SENTENCE, 0)); 
     assertEquals("o", StringUtils.substring(SENTENCE, -1)); 
     assertEquals(FOO, StringUtils.substring(SENTENCE, 0)); 
     assertEquals(SENTENCE, StringUtils.substring(SENTENCE, 3)); 
     assertEquals(SENTENCE, StringUtils.substring(SENTENCE, 80)); 
 }
@Test
public void testSubstring_StringInt451() { 
     assertEquals(null, StringUtils.substring(null, -1)); 
     assertEquals(null, StringUtils.substring(null, 0)); 
     assertEquals(null, StringUtils.substring(null, 1)); 
     assertEquals("", StringUtils.substring("", 0)); 
     assertEquals("", StringUtils.substring("", 2)); 
     assertEquals("", StringUtils.substring("", -1)); 
     assertEquals("", StringUtils.substring(SENTENCE, 8)); 
     assertEquals(FOO, StringUtils.substring(SENTENCE, 0)); 
     assertEquals("o", StringUtils.substring(SENTENCE, -9)); 
     assertEquals(FOO, StringUtils.substring(SENTENCE, 0)); 
     assertEquals(SENTENCE, StringUtils.substring(SENTENCE, -8)); 
 }
@Test
public void testSubstring_StringInt452() { 
     assertEquals(null, StringUtils.substring(null, 0)); 
     assertEquals(null, StringUtils.substring(null, 1)); 
     assertEquals("", StringUtils.substring("", 0)); 
     assertEquals("", StringUtils.substring("", 2)); 
     assertEquals("", StringUtils.substring(SENTENCE, 8)); 
     assertEquals(FOO, StringUtils.substring(SENTENCE, 0)); 
     assertEquals("o", StringUtils.substring(SENTENCE, -9)); 
     assertEquals(FOO, StringUtils.substring(SENTENCE, 0)); 
     assertEquals("o", StringUtils.substring(SENTENCE, -8)); 
     assertEquals("o", StringUtils.substring(SENTENCE, 3)); 
     assertEquals(SENTENCE, StringUtils.substring(SENTENCE, 80)); 
 }
@Test
public void testSubstring_StringInt453() { 
     assertEquals(null, StringUtils.substring(null, -1)); 
     assertEquals(null, StringUtils.substring(null, 0)); 
     assertEquals(null, StringUtils.substring(null, 1)); 
     assertEquals("", StringUtils.substring("", 0)); 
     assertEquals("", StringUtils.substring("", 2)); 
     assertEquals("", StringUtils.substring(SENTENCE, 8)); 
     assertEquals("", StringUtils.substring(SENTENCE, 9)); 
     assertEquals(FOO, StringUtils.substring(SENTENCE, 0)); 
     assertEquals("o", StringUtils.substring(SENTENCE, -1)); 
     assertEquals("o", StringUtils.substring(SENTENCE, 0)); 
     assertEquals(SENTENCE, StringUtils.substring(SENTENCE, 3)); 
     assertEquals(SENTENCE, StringUtils.substring(SENTENCE, 80)); 
 }
@Test
public void testSubstringBeforeLast_StringString454() { 
     assertEquals("foo", StringUtils.substringBeforeLast("fooXXbarXXbaz", "XX")); 
     assertEquals(null, StringUtils.substringBeforeLast(null, null)); 
     assertEquals(null, StringUtils.substringBeforeLast(null, "")); 
     assertEquals(null, StringUtils.substringBeforeLast(null, "XX")); 
     assertEquals("", StringUtils.substringBeforeLast("", null)); 
     assertEquals("", StringUtils.substringBeforeLast("", "")); 
     assertEquals("", StringUtils.substringBeforeLast("", "XX")); 
     assertEquals("foo", StringUtils.substringBeforeLast("foo", null)); 
     assertEquals("foo", StringUtils.substringBeforeLast("foo", "b")); 
     assertEquals("f", StringUtils.substringBeforeLast("foot", "o")); 
     assertEquals("", StringUtils.substringBeforeLast("abc", "a")); 
     assertEquals("a", StringUtils.substringBeforeLast("abcba", "b")); 
     assertEquals("ab", StringUtils.substringBeforeLast("abc", "c")); 
     assertEquals("", StringUtils.substringBeforeLast("abc", "")); 
 }
@Test
public void testSubstringBeforeLast_StringString455() { 
     assertEquals("baz", StringUtils.substringBeforeLast("fooXXbarXXbaz", "XX")); 
     assertEquals(null, StringUtils.substringBeforeLast(null, null)); 
     assertEquals(null, StringUtils.substringBeforeLast(null, "")); 
     assertEquals(null, StringUtils.substringBeforeLast(null, "XX")); 
     assertEquals("", StringUtils.substringBeforeLast("", null)); 
     assertEquals("", StringUtils.substringBeforeLast("", "")); 
     assertEquals("", StringUtils.substringBeforeLast("", "a")); 
     assertEquals("", StringUtils.substringBeforeLast("foo", null)); 
     assertEquals("", StringUtils.substringBeforeLast("foo", "b")); 
     assertEquals("t", StringUtils.substringBeforeLast("foot", "o")); 
     assertEquals("bc", StringUtils.substringBeforeLast("abc", "a")); 
     assertEquals("a", StringUtils.substringBeforeLast("abcba", "b")); 
     assertEquals("", StringUtils.substringBeforeLast("abc", "c")); 
     assertEquals("", StringUtils.substringBeforeLast("", "d")); 
     assertEquals("", StringUtils.substringBeforeLast("abc", "")); 
 }
    
    
    
           
    
    
    
    
    
    
    //-----------------------------------------------------------------------
    
    
    

    
    
            
        
    //-----------------------------------------------------------------------
    
            
    

   /**
     * Tests the substringsBetween method that returns an String Array of substrings.
     */
    

    //-----------------------------------------------------------------------
    

}
