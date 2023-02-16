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

import org.junit.Test;
import static org.junit.Assert.*;
import org.apache.commons.lang3.text.StrBuilder;

/**
 * Unit tests {@link org.apache.commons.lang3.StringUtils} - StartsWith/EndsWith methods
 *
 * @version $Id$
 */
public class StringUtilsStartsEndsWithTest {
    private static final String foo    = "foo";
    private static final String bar    = "bar";
    private static final String foobar = "foobar";
    private static final String FOO    = "FOO";
    private static final String BAR    = "BAR";
    private static final String FOOBAR = "FOOBAR";

    //-----------------------------------------------------------------------

    /**
     * Test StringUtils.startsWith()
     */
@Test
public void testStartsWithAny484() { 
     assertFalse(StringUtils.startsWithAny(null, (String[]) null)); 
     assertFalse(StringUtils.startsWithAny(null, "abc")); 
     assertFalse(StringUtils.startsWithAny("abcxyz", (String[]) null)); 
     assertFalse(StringUtils.startsWithAny("abcxyz")); 
     assertTrue(StringUtils.startsWithAny("abcxyz", "abc")); 
     assertTrue(StringUtils.startsWithAny("abcxyz", null, "xyz", "abc")); 
     assertFalse(StringUtils.startsWithAny("abcxyz", null, "xyz", "abcd")); 
     assertTrue("StringUtils.startsWithAny(abcxyz, StringBuilder(xyz), StringBuffer(abc))", StringUtils.startsWithAny("abcxyz", new StringBuilder("xyz"), new StringBuffer("abc"))); 
     assertTrue("StringUtils.startsWithAny( StrBuilder(abcxyz), StringBuilder(xyz), StringBuffer(abc))", StringUtils.startsWithAny(new StrBuilder("abcxyz"), new StringBuilder("xyz"), new StringBuffer("abc"))); 
 }
@Test
public void testRemoveEnd485() { 
     assertNull("removeEnd(null, null)", StringUtils.removeEnd(null, null)); 
     assertNull("removeEnd(null, \"\")", StringUtils.removeEnd(null, "")); 
     assertNull("removeEnd(null, \"a\")", StringUtils.removeEnd(null, "a")); 
     assertEquals("removeEnd(\"\", null)", StringUtils.removeEnd("", null), ""); 
     assertEquals("removeEnd(\"\", \"\")", StringUtils.removeEnd("", ""), ""); 
     assertEquals("removeEnd(\"\", \"a\")", StringUtils.removeEnd("", "a"), ""); 
     assertEquals("removeEnd(\"www.domain.com.\", \".com\")", StringUtils.removeEnd("www.domain.com.", ".com"), "www.domain.com."); 
     assertEquals("removeEnd(\"www.domain.com\", \".com\")", StringUtils.removeEnd("www.domain.com", ".com"), "www.domain"); 
     assertEquals("removeEnd(\"www.domain\", \".com\")", StringUtils.removeEnd("www.domain", ".com"), "www.domain"); 
     assertEquals("removeEnd(\"domain.com\", \"\")", StringUtils.removeEnd("domain.com", ""), "domain.com"); 
     assertEquals("removeEnd(\"domain.com\", null)", StringUtils.removeEnd("domain.com", null), "domain.com"); 
     assertEquals("removeEnd(\"www.domain.com\", \".COM\")", StringUtils.removeEnd("www.domain.com", ".COM"), "www.domain"); 
     assertEquals("removeEnd(\"www.domain.COM\", \".com\")", StringUtils.removeEnd("www.domain.COM", ".com"), "www.domain"); 
 }
    

    /**
     * Test StringUtils.testStartsWithIgnoreCase()
     */
    

    
 

    /**
     * Test StringUtils.endsWith()
     */
    

    /**
     * Test StringUtils.endsWithIgnoreCase()
     */
    

    


}
