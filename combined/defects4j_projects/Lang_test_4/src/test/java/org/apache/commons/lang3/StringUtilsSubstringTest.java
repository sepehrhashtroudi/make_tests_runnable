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
public void testSubstring_StringIntInt505() { 
     assertEquals(null, StringUtils.substring(null, 2, 4)); 
     assertEquals("", StringUtils.substring("", 0, 4)); 
     assertEquals("", StringUtils.substring("", 2, 4)); 
     assertEquals(null, StringUtils.substring(null, 3, 2)); 
     assertEquals("", StringUtils.substring("", 3, 4)); 
     assertEquals("", StringUtils.substring("", 2, 4)); 
     assertEquals("", StringUtils.substring("", 4, 2)); 
     assertEquals("foo", StringUtils.substring("foo", 0, 3)); 
     assertEquals("bar", StringUtils.substring("foo", 2, 4)); 
     assertEquals("baz", StringUtils.substring("foo", 3, 4)); 
     assertEquals("farfarfar", StringUtils.substring("foo", 6, 10)); 
 }
@Test
public void testSubstringAfterLast_StringString508() { 
     assertEquals("barXXbaz", StringUtils.substringAfterLast("fooXXbarXXbaz", "XX")); 
     assertEquals(null, StringUtils.substringAfterLast(null, null)); 
     assertEquals(null, StringUtils.substringAfterLast(null, "")); 
     assertEquals(null, StringUtils.substringAfterLast(null, "XX")); 
     assertEquals("", StringUtils.substringAfterLast("", null)); 
     assertEquals("", StringUtils.substringAfterLast("", "")); 
     assertEquals("", StringUtils.substringAfterLast("", "XX")); 
     assertEquals("", StringUtils.substringAfterLast("foo", null)); 
     assertEquals("ot", StringUtils.substringAfterLast("foot", "o")); 
     assertEquals("bc", StringUtils.substringAfterLast("abc", "a")); 
     assertEquals("cba", StringUtils.substringAfterLast("abcba", "b")); 
     assertEquals("", StringUtils.substringAfterLast("abc", "c")); 
     assertEquals("abc", StringUtils.substringAfterLast("abc", "")); 
     assertEquals("", StringUtils.substringAfterLast("abc", "d")); 
 }
    
    
    
           
    
    
    
    
    
    
    //-----------------------------------------------------------------------
    
    
    

    
    
            
        
    //-----------------------------------------------------------------------
    
            
    

   /**
     * Tests the substringsBetween method that returns an String Array of substrings.
     */
    

    //-----------------------------------------------------------------------
    

}
