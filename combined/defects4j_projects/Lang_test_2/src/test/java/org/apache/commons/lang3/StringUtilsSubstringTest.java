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
public void testMid_String427() { 
     assertSame(null, StringUtils.mid(null, 0, -1)); 
     assertSame(null, StringUtils.mid(null, 1, 2)); 
     assertSame(null, StringUtils.mid(null, 2, -1)); 
     assertEquals("", StringUtils.mid("", 0, -1)); 
     assertEquals("", StringUtils.mid("", 1, 2)); 
     assertEquals("", StringUtils.mid("", -1, 2)); 
     assertEquals("", StringUtils.mid("", 0, -1)); 
     assertEquals("", StringUtils.mid("", 1, 2)); 
     assertEquals("", StringUtils.mid("", -1, 2)); 
     assertEquals("", StringUtils.mid("abc", 0, -1)); 
     assertEquals("abc", StringUtils.mid("abc", 1, 2)); 
     assertEquals("bc", StringUtils.mid("abc", 2, 2)); 
     assertEquals("c", StringUtils.mid("abc", 3, 2)); 
     assertEquals("abc", StringUtils.mid("abc", 3, -1)); 
     assertEquals("a", StringUtils.mid("abc", 0, 4)); 
     assertEquals("ab", StringUtils.mid("ab", 4, 2)); 
     assertEquals("ab", StringUtils.mid("abc", 5, 2)); 
     assertEquals("", StringUtils.mid("abc", 6, 2)); 
     assertEquals("", StringUtils.mid("abc", 7, 2)); 
 }
@Test
public void testMid_String428() { 
     assertSame(null, StringUtils.mid(null, -1, -1)); 
     assertSame(null, StringUtils.mid(null, 0, -1)); 
     assertSame(null, StringUtils.mid(null, 1, -1)); 
     assertEquals("", StringUtils.mid("", -1, -1)); 
     assertEquals("", StringUtils.mid("", 0, -1)); 
     assertEquals("", StringUtils.mid("", 1, -1)); 
     assertEquals("", StringUtils.mid("abc", -1, -1)); 
     assertEquals("", StringUtils.mid("abc", 0, 3)); 
     assertEquals("", StringUtils.mid("abc", 2, -1)); 
     assertEquals("b", StringUtils.mid("abc", -1, -1)); 
     assertEquals("a", StringUtils.mid("a", 0, 3)); 
     assertEquals("ab", StringUtils.mid("ab", 3, 2)); 
     assertEquals("ab", StringUtils.mid("abc", 4, 2)); 
     assertEquals("ab", StringUtils.mid("abc", 5, 2)); 
     assertEquals("", StringUtils.mid("abc", 6, 2)); 
     assertEquals("", StringUtils.mid("abc", 7, 2)); 
     assertEquals("", StringUtils.mid("abc", 8, 2)); 
 }
@Test
public void testMid_String429() { 
     assertSame(null, StringUtils.mid(null, -1, -1)); 
     assertSame(null, StringUtils.mid(null, 0, -1)); 
     assertSame(null, StringUtils.mid(null, 2, -1)); 
     assertEquals("", StringUtils.mid("", -1, -1)); 
     assertEquals("", StringUtils.mid("", 0, -1)); 
     assertEquals("", StringUtils.mid("", 2, -1)); 
     assertEquals("", StringUtils.mid("", -1, -1)); 
     assertEquals("", StringUtils.mid("", 0, -1)); 
     assertEquals("", StringUtils.mid("", 2, -1)); 
     assertEquals("", StringUtils.mid("abc", -1, -1)); 
     assertEquals("abc", StringUtils.mid("abc", -1, -1)); 
     assertEquals("a", StringUtils.mid("abc", 0, 3)); 
     assertEquals("ab", StringUtils.mid("ab", 3, 2)); 
     assertEquals("ab", StringUtils.mid("abc", 4, 2)); 
     assertEquals("ab", StringUtils.mid("abc", 5, 2)); 
     assertEquals("", StringUtils.mid("abc", 6, 2)); 
     assertEquals("", StringUtils.mid("abc", 7, 2)); 
     assertEquals("", StringUtils.mid("abc", 8, 2)); 
 }
@Test
public void testSubstringBefore_StringString432() { 
     assertEquals("fooXXbar", StringUtils.substringBefore("fooXXbarXXbaz", "XX")); 
     assertEquals(null, StringUtils.substringBefore(null, null)); 
     assertEquals(null, StringUtils.substringBefore(null, "")); 
     assertEquals(null, StringUtils.substringBefore(null, "XX")); 
     assertEquals("", StringUtils.substringBefore("", null)); 
     assertEquals("", StringUtils.substringBefore("", "")); 
     assertEquals("", StringUtils.substringBefore("", "XX")); 
     assertEquals("", StringUtils.substringBefore("foo", null)); 
     assertEquals("ot", StringUtils.substringBefore("foot", "o")); 
     assertEquals("bc", StringUtils.substringBefore("abc", "a")); 
     assertEquals("cba", StringUtils.substringBefore("abcba", "b")); 
     assertEquals("", StringUtils.substringBefore("abc", "c")); 
     assertEquals("abc", StringUtils.substringBefore("abc", "")); 
     assertEquals("", StringUtils.substringBefore("abc", "d")); 
 }
@Test
public void testSubstringBefore_StringString433() { 
     assertEquals("fooXXbar", StringUtils.substringBefore("fooXXbarXXbaz", "XX")); 
     assertEquals(null, StringUtils.substringBefore(null, null)); 
     assertEquals(null, StringUtils.substringBefore(null, "")); 
     assertEquals(null, StringUtils.substringBefore(null, "XX")); 
     assertEquals("", StringUtils.substringBefore("", null)); 
     assertEquals("", StringUtils.substringBefore("", "")); 
     assertEquals("", StringUtils.substringBefore("", "XX")); 
     assertEquals("foo", StringUtils.substringBefore("foo", null)); 
     assertEquals("ot", StringUtils.substringBefore("foot", "o")); 
     assertEquals("bc", StringUtils.substringBefore("abc", "a")); 
     assertEquals("cba", StringUtils.substringBefore("abcba", "b")); 
     assertEquals("", StringUtils.substringBefore("abc", "c")); 
     assertEquals("abc", StringUtils.substringBefore("abc", "")); 
     assertEquals("", StringUtils.substringBefore("abc", "d")); 
 }
    
    
    
           
    
    
    
    
    
    
    //-----------------------------------------------------------------------
    
    
    

    
    
            
        
    //-----------------------------------------------------------------------
    
            
    

   /**
     * Tests the substringsBetween method that returns an String Array of substrings.
     */
    

    //-----------------------------------------------------------------------
    

}
