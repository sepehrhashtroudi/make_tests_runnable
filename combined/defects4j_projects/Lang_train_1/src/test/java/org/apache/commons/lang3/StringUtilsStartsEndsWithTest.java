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
public void testStartsWithAny278() { 
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
public void testEndsWithAny1097() { 
     assertFalse("StringUtils.endsWithAny(null, null)", StringUtils.endsWithAny(null, (String) null)); 
     assertFalse("StringUtils.endsWithAny(null, new String[] {abc})", StringUtils.endsWithAny(null, new String[] { "abc" })); 
     assertFalse("StringUtils.endsWithAny(abcxyz, null)", StringUtils.endsWithAny("abcxyz", (String) null)); 
     assertTrue("StringUtils.endsWithAny(abcxyz, new String[] {\"\"})", StringUtils.endsWithAny("abcxyz", new String[] { "" })); 
     assertTrue("StringUtils.endsWithAny(abcxyz, new String[] {xyz})", StringUtils.endsWithAny("abcxyz", new String[] { "xyz" })); 
     assertTrue("StringUtils.endsWithAny(abcxyz, new String[] {null, xyz, abc})", StringUtils.endsWithAny("abcxyz", new String[] { null, "xyz", "abc" })); 
     assertFalse("StringUtils.endsWithAny(defg, new String[] {null, xyz, abc})", StringUtils.endsWithAny("defg", new String[] { null, "xyz", "abc" })); 
     assertTrue("StringUtils.endsWithAny(abcxyz, StringBuilder(abc), StringBuffer(xyz))", StringUtils.endsWithAny("abcxyz", new StringBuilder("abc"), new StringBuffer("xyz"))); 
     assertTrue("StringUtils.endsWithAny( StrBuilder(abcxyz), StringBuilder(abc), StringBuffer(xyz))", StringUtils.endsWithAny(new StrBuilder("abcxyz"), new StringBuilder("abc"), new StringBuffer("xyz"))); 
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