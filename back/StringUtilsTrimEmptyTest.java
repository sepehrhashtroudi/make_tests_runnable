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
public void testStripToNull56() { 
         assertEquals(null, StringUtils.stripToNull(null)); 
         assertEquals("", StringUtils.stripToNull("")); 
         assertEquals("", StringUtils.stripToNull("  ")); 
          
         assertEquals("", StringUtils.stripToNull("  ")); 
         assertEquals("abc", StringUtils.stripToNull("  abc  ")); 
         assertEquals(StringUtilsTest.NON_WHITESPACE,  
             StringUtils.stripToNull(StringUtilsTest.WHITESPACE + StringUtilsTest.NON_WHITESPACE + StringUtilsTest.WHITESPACE)); 
     }
@Test
public void testTrimToEmpty78() { 
         assertEquals("", StringUtils.trimToEmpty(null)); 
         assertEquals("", StringUtils.trimToEmpty("")); 
         assertEquals("", StringUtils.trimToEmpty("  \u000C  \t\t\u001F\n\n \u000B  ")); 
         assertEquals("", StringUtils.trimToEmpty("")); 
         assertEquals("", StringUtils.trimToEmpty(StringUtilsTest.TRIMMABLE)); 
         assertEquals(StringUtilsTest.NON_TRIMMABLE, StringUtils.trimToEmpty(StringUtilsTest.NON_TRIMMABLE)); 
         assertEquals(StringUtilsTest.WHITESPACE, StringUtils.trimToEmpty(StringUtilsTest.WHITESPACE)); 
     }
@Test
public void testStrip_StringString1827() { 
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
public void testStripToNull1828() { 
         assertEquals(null, StringUtils.stripToNull(null)); 
         assertEquals("", StringUtils.stripToNull("")); 
         assertEquals("", StringUtils.stripToNull("  ")); 
          
         assertEquals("", StringUtils.stripToNull("  ")); 
         assertEquals("abc", StringUtils.stripToNull("  abc  ")); 
         assertEquals(StringUtilsTest.NON_WHITESPACE,  
             StringUtils.stripToNull(StringUtilsTest.WHITESPACE + StringUtilsTest.NON_WHITESPACE + StringUtilsTest.WHITESPACE)); 
     }
@Test
public void testStrip_StringString1830() { 
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
public void testStrip_StringString1831() { 
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
public void testStripToNull1835() { 
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
public void testStrip_StringString1838() { 
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
public void testStrip_StringString1842() { 
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
public void testStripToNull1846() { 
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
public void testStripToNull1849() { 
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
public void testTrimToEmpty2167() { 
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
