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
public void testStripToNull488() { 
     assertEquals(null, StringUtils.stripToNull(null)); 
     assertEquals("", StringUtils.stripToNull("")); 
     assertEquals("", StringUtils.stripToNull("        ")); 
     assertEquals("abc", StringUtils.stripToNull("  abc  ")); 
     assertEquals(StringUtilsTest.NON_WHITESPACE, StringUtils.stripToNull(StringUtilsTest.WHITESPACE + StringUtilsTest.NON_WHITESPACE + StringUtilsTest.WHITESPACE)); 
 }
@Test
public void testStripToEmpty489() { 
     assertEquals(null, StringUtils.stripToEmpty(null)); 
     assertEquals("", StringUtils.stripToEmpty("")); 
     assertEquals("", StringUtils.stripToEmpty("        ")); 
     assertEquals("abc", StringUtils.stripToEmpty("  abc  ")); 
     assertEquals(StringUtilsTest.NON_WHITESPACE, StringUtils.stripToEmpty(StringUtilsTest.WHITESPACE + StringUtilsTest.NON_WHITESPACE + StringUtilsTest.WHITESPACE)); 
 }
@Test
public void testStripAccents_String490() { 
     assertEquals(null, StringUtils.stripAccents(null)); 
     assertEquals("", StringUtils.stripAccents("")); 
     assertEquals("", StringUtils.stripAccents("        ")); 
     assertEquals("abc", StringUtils.stripAccents("  abc  ")); 
     assertEquals(StringUtilsTest.NON_WHITESPACE, StringUtils.stripAccents(StringUtilsTest.WHITESPACE + StringUtilsTest.NON_WHITESPACE + StringUtilsTest.WHITESPACE)); 
 }
    

    

    

    

    //-----------------------------------------------------------------------
    

    

    

    //-----------------------------------------------------------------------
    
    
    
    
    
    
    
    
    
    
    

    

    
}
