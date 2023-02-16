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
public void testRight_String477() { 
     assertSame(null, StringUtils.right(null, -1)); 
     assertSame(null, StringUtils.right(null, 0)); 
     assertSame(null, StringUtils.right(null, 2)); 
     assertEquals("", StringUtils.right("", -1)); 
     assertEquals("", StringUtils.right("", 0)); 
     assertEquals("", StringUtils.right("", 2)); 
     assertEquals("", StringUtils.right(FOOBAR, -1)); 
     assertEquals("", StringUtils.right(FOOBAR, 0)); 
     assertEquals(FOO, StringUtils.right(FOOBAR, 3)); 
     assertEquals(BAR, StringUtils.right(FOOBAR, 3)); 
     assertEquals(FOOBAR, StringUtils.right(FOOBAR, 80)); 
 }
@Test
public void testRight_String478() { 
     assertSame(null, StringUtils.right(null, -1)); 
     assertSame(null, StringUtils.right(null, 0)); 
     assertSame(null, StringUtils.right(null, 2)); 
     assertEquals("", StringUtils.right("", -1)); 
     assertEquals("", StringUtils.right("", 0)); 
     assertEquals("", StringUtils.right("", 2)); 
     assertEquals("", StringUtils.right(FOOBAR, -1)); 
     assertEquals("", StringUtils.right(FOOBAR, 0)); 
     assertEquals(FOO, StringUtils.right(FOOBAR, 3)); 
     assertSame(FOOBAR, StringUtils.right(FOOBAR, 80)); 
 }
    
    
    
           
    
    
    
    
    
    
    //-----------------------------------------------------------------------
    
    
    

    
    
            
        
    //-----------------------------------------------------------------------
    
            
    

   /**
     * Tests the substringsBetween method that returns an String Array of substrings.
     */
    

    //-----------------------------------------------------------------------
    

}
