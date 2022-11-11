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

package org.apache.commons.lang3.text;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * Unit tests for {@link org.apache.commons.lang3.text.StrMatcher}.
 *
 * @version $Id$
 */
public class StrMatcherTest  {

    private static final char[] BUFFER1 = "0,1\t2 3\n\r\f\u0000'\"".toCharArray();

    private static final char[] BUFFER2 = "abcdef".toCharArray();


    //-----------------------------------------------------------------------
@Test
public void testSingleQuoteMatcher125() { 
     final StrMatcher matcher = StrMatcher.singleQuoteMatcher(); 
     assertSame(matcher, StrMatcher.singleQuoteMatcher()); 
     assertEquals(0, matcher.isMatch(BUFFER1, 10)); 
     assertEquals(1, matcher.isMatch(BUFFER1, 11)); 
     assertEquals(0, matcher.isMatch(BUFFER1, 12)); 
 }
@Test
public void testCharSetMatcher_String701() { 
     final StrMatcher matcher = StrMatcher.charSetMatcher("ace"); 
     assertEquals(1, matcher.isMatch(BUFFER2, 0)); 
     assertEquals(0, matcher.isMatch(BUFFER2, 1)); 
     assertEquals(1, matcher.isMatch(BUFFER2, 2)); 
     assertEquals(0, matcher.isMatch(BUFFER2, 3)); 
     assertEquals(1, matcher.isMatch(BUFFER2, 4)); 
     assertEquals(0, matcher.isMatch(BUFFER2, 5)); 
     assertSame(StrMatcher.noneMatcher(), StrMatcher.charSetMatcher("")); 
     assertSame(StrMatcher.noneMatcher(), StrMatcher.charSetMatcher((String) null)); 
     assertTrue(StrMatcher.charSetMatcher("a") instanceof StrMatcher.CharMatcher); 
 }
@Test
public void testQuoteMatcher1106() { 
     final StrMatcher matcher = StrMatcher.quoteMatcher(); 
     assertSame(matcher, StrMatcher.quoteMatcher()); 
     assertEquals(0, matcher.isMatch(BUFFER1, 10)); 
     assertEquals(1, matcher.isMatch(BUFFER1, 11)); 
     assertEquals(1, matcher.isMatch(BUFFER1, 12)); 
 }
@Test
public void testCommaMatcher1188() { 
     final StrMatcher matcher = StrMatcher.commaMatcher(); 
     assertSame(matcher, StrMatcher.commaMatcher()); 
     assertEquals(0, matcher.isMatch(BUFFER1, 0)); 
     assertEquals(1, matcher.isMatch(BUFFER1, 1)); 
     assertEquals(0, matcher.isMatch(BUFFER1, 2)); 
 }
@Test
public void testDoubleQuoteMatcher1193() { 
     final StrMatcher matcher = StrMatcher.doubleQuoteMatcher(); 
     assertSame(matcher, StrMatcher.doubleQuoteMatcher()); 
     assertEquals(0, matcher.isMatch(BUFFER1, 11)); 
     assertEquals(1, matcher.isMatch(BUFFER1, 12)); 
 }
@Test
public void testCharSetMatcher_String1387() { 
     final StrMatcher matcher = StrMatcher.charSetMatcher("ace"); 
     assertEquals(1, matcher.isMatch(BUFFER2, 0)); 
     assertEquals(0, matcher.isMatch(BUFFER2, 1)); 
     assertEquals(1, matcher.isMatch(BUFFER2, 2)); 
     assertEquals(0, matcher.isMatch(BUFFER2, 3)); 
     assertEquals(1, matcher.isMatch(BUFFER2, 4)); 
     assertEquals(0, matcher.isMatch(BUFFER2, 5)); 
     assertSame(StrMatcher.noneMatcher(), StrMatcher.charSetMatcher("")); 
     assertSame(StrMatcher.noneMatcher(), StrMatcher.charSetMatcher((String) null)); 
     assertTrue(StrMatcher.charSetMatcher("a") instanceof StrMatcher.CharMatcher); 
 }
@Test
public void testCharSetMatcher_String2889() { 
     final StrMatcher matcher = StrMatcher.charSetMatcher("ace"); 
     assertEquals(1, matcher.isMatch(BUFFER2, 0)); 
     assertEquals(0, matcher.isMatch(BUFFER2, 1)); 
     assertEquals(1, matcher.isMatch(BUFFER2, 2)); 
     assertEquals(0, matcher.isMatch(BUFFER2, 3)); 
     assertEquals(1, matcher.isMatch(BUFFER2, 4)); 
     assertEquals(0, matcher.isMatch(BUFFER2, 5)); 
     assertSame(StrMatcher.noneMatcher(), StrMatcher.charSetMatcher("")); 
     assertSame(StrMatcher.noneMatcher(), StrMatcher.charSetMatcher((String) null)); 
     assertTrue(StrMatcher.charSetMatcher("a") instanceof StrMatcher.CharMatcher); 
 }
@Test
public void testSingleQuoteMatcher3416() { 
     final StrMatcher matcher = StrMatcher.singleQuoteMatcher(); 
     assertSame(matcher, StrMatcher.singleQuoteMatcher()); 
     assertEquals(0, matcher.isMatch(BUFFER1, 10)); 
     assertEquals(1, matcher.isMatch(BUFFER1, 11)); 
     assertEquals(0, matcher.isMatch(BUFFER1, 12)); 
 }
@Test
public void testTabMatcher3489() { 
     final StrMatcher matcher = StrMatcher.tabMatcher(); 
     assertSame(matcher, StrMatcher.tabMatcher()); 
     assertEquals(0, matcher.isMatch(BUFFER1, 2)); 
     assertEquals(1, matcher.isMatch(BUFFER1, 3)); 
     assertEquals(0, matcher.isMatch(BUFFER1, 4)); 
 }
@Test
public void testQuoteMatcher3695() { 
     final StrMatcher matcher = StrMatcher.quoteMatcher(); 
     assertSame(matcher, StrMatcher.quoteMatcher()); 
     assertEquals(0, matcher.isMatch(BUFFER1, 10)); 
     assertEquals(1, matcher.isMatch(BUFFER1, 11)); 
     assertEquals(1, matcher.isMatch(BUFFER1, 12)); 
 }
@Test
public void testQuoteMatcher3834() { 
     final StrMatcher matcher = StrMatcher.quoteMatcher(); 
     assertSame(matcher, StrMatcher.quoteMatcher()); 
     assertEquals(0, matcher.isMatch(BUFFER1, 10)); 
     assertEquals(1, matcher.isMatch(BUFFER1, 11)); 
     assertEquals(1, matcher.isMatch(BUFFER1, 12)); 
 }
@Test
public void testDoubleQuoteMatcher3892() { 
     final StrMatcher matcher = StrMatcher.doubleQuoteMatcher(); 
     assertSame(matcher, StrMatcher.doubleQuoteMatcher()); 
     assertEquals(0, matcher.isMatch(BUFFER1, 11)); 
     assertEquals(1, matcher.isMatch(BUFFER1, 12)); 
 }
@Test
public void testCharMatcher_char4343() { 
     final StrMatcher matcher = StrMatcher.charMatcher('c'); 
     assertEquals(0, matcher.isMatch(BUFFER2, 0)); 
     assertEquals(0, matcher.isMatch(BUFFER2, 1)); 
     assertEquals(1, matcher.isMatch(BUFFER2, 2)); 
     assertEquals(0, matcher.isMatch(BUFFER2, 3)); 
     assertEquals(0, matcher.isMatch(BUFFER2, 4)); 
     assertEquals(0, matcher.isMatch(BUFFER2, 5)); 
 }
@Test
public void testStringMatcher_String4634() { 
     final StrMatcher matcher = StrMatcher.stringMatcher("bc"); 
     assertEquals(0, matcher.isMatch(BUFFER2, 0)); 
     assertEquals(2, matcher.isMatch(BUFFER2, 1)); 
     assertEquals(0, matcher.isMatch(BUFFER2, 2)); 
     assertEquals(0, matcher.isMatch(BUFFER2, 3)); 
     assertEquals(0, matcher.isMatch(BUFFER2, 4)); 
     assertEquals(0, matcher.isMatch(BUFFER2, 5)); 
     assertSame(StrMatcher.noneMatcher(), StrMatcher.stringMatcher("")); 
     assertSame(StrMatcher.noneMatcher(), StrMatcher.stringMatcher((String) null)); 
 }
@Test
public void testCharSetMatcher_String4668() { 
     final StrMatcher matcher = StrMatcher.charSetMatcher("ace"); 
     assertEquals(1, matcher.isMatch(BUFFER2, 0)); 
     assertEquals(0, matcher.isMatch(BUFFER2, 1)); 
     assertEquals(1, matcher.isMatch(BUFFER2, 2)); 
     assertEquals(0, matcher.isMatch(BUFFER2, 3)); 
     assertEquals(1, matcher.isMatch(BUFFER2, 4)); 
     assertEquals(0, matcher.isMatch(BUFFER2, 5)); 
     assertSame(StrMatcher.noneMatcher(), StrMatcher.charSetMatcher("")); 
     assertSame(StrMatcher.noneMatcher(), StrMatcher.charSetMatcher((String) null)); 
     assertTrue(StrMatcher.charSetMatcher("a") instanceof StrMatcher.CharMatcher); 
 }
@Test
public void testTrimMatcher4715() { 
     final StrMatcher matcher = StrMatcher.trimMatcher(); 
     assertSame(matcher, StrMatcher.trimMatcher()); 
     assertEquals(0, matcher.isMatch(BUFFER1, 2)); 
     assertEquals(1, matcher.isMatch(BUFFER1, 3)); 
     assertEquals(0, matcher.isMatch(BUFFER1, 4)); 
     assertEquals(1, matcher.isMatch(BUFFER1, 5)); 
     assertEquals(0, matcher.isMatch(BUFFER1, 6)); 
     assertEquals(1, matcher.isMatch(BUFFER1, 7)); 
     assertEquals(1, matcher.isMatch(BUFFER1, 8)); 
     assertEquals(1, matcher.isMatch(BUFFER1, 9)); 
     assertEquals(1, matcher.isMatch(BUFFER1, 10)); 
 }
@Test
public void testTabMatcher5431() { 
     final StrMatcher matcher = StrMatcher.tabMatcher(); 
     assertSame(matcher, StrMatcher.tabMatcher()); 
     assertEquals(0, matcher.isMatch(BUFFER1, 2)); 
     assertEquals(1, matcher.isMatch(BUFFER1, 3)); 
     assertEquals(0, matcher.isMatch(BUFFER1, 4)); 
 }
@Test
public void testSplitMatcher5942() { 
     final StrMatcher matcher = StrMatcher.splitMatcher(); 
     assertSame(matcher, StrMatcher.splitMatcher()); 
     assertEquals(0, matcher.isMatch(BUFFER1, 2)); 
     assertEquals(1, matcher.isMatch(BUFFER1, 3)); 
     assertEquals(0, matcher.isMatch(BUFFER1, 4)); 
     assertEquals(1, matcher.isMatch(BUFFER1, 5)); 
     assertEquals(0, matcher.isMatch(BUFFER1, 6)); 
     assertEquals(1, matcher.isMatch(BUFFER1, 7)); 
     assertEquals(1, matcher.isMatch(BUFFER1, 8)); 
     assertEquals(1, matcher.isMatch(BUFFER1, 9)); 
     assertEquals(0, matcher.isMatch(BUFFER1, 10)); 
 }
@Test
public void testTrimMatcher6075() { 
     final StrMatcher matcher = StrMatcher.trimMatcher(); 
     assertSame(matcher, StrMatcher.trimMatcher()); 
     assertEquals(0, matcher.isMatch(BUFFER1, 2)); 
     assertEquals(1, matcher.isMatch(BUFFER1, 3)); 
     assertEquals(0, matcher.isMatch(BUFFER1, 4)); 
     assertEquals(1, matcher.isMatch(BUFFER1, 5)); 
     assertEquals(0, matcher.isMatch(BUFFER1, 6)); 
     assertEquals(1, matcher.isMatch(BUFFER1, 7)); 
     assertEquals(1, matcher.isMatch(BUFFER1, 8)); 
     assertEquals(1, matcher.isMatch(BUFFER1, 9)); 
     assertEquals(1, matcher.isMatch(BUFFER1, 10)); 
 }
@Test
public void testTrimMatcher6097() { 
     final StrMatcher matcher = StrMatcher.trimMatcher(); 
     assertSame(matcher, StrMatcher.trimMatcher()); 
     assertEquals(0, matcher.isMatch(BUFFER1, 2)); 
     assertEquals(1, matcher.isMatch(BUFFER1, 3)); 
     assertEquals(0, matcher.isMatch(BUFFER1, 4)); 
     assertEquals(1, matcher.isMatch(BUFFER1, 5)); 
     assertEquals(0, matcher.isMatch(BUFFER1, 6)); 
     assertEquals(1, matcher.isMatch(BUFFER1, 7)); 
     assertEquals(1, matcher.isMatch(BUFFER1, 8)); 
     assertEquals(1, matcher.isMatch(BUFFER1, 9)); 
     assertEquals(1, matcher.isMatch(BUFFER1, 10)); 
 }
@Test
public void testTrimMatcher6347() { 
     final StrMatcher matcher = StrMatcher.trimMatcher(); 
     assertSame(matcher, StrMatcher.trimMatcher()); 
     assertEquals(0, matcher.isMatch(BUFFER1, 2)); 
     assertEquals(1, matcher.isMatch(BUFFER1, 3)); 
     assertEquals(0, matcher.isMatch(BUFFER1, 4)); 
     assertEquals(1, matcher.isMatch(BUFFER1, 5)); 
     assertEquals(0, matcher.isMatch(BUFFER1, 6)); 
     assertEquals(1, matcher.isMatch(BUFFER1, 7)); 
     assertEquals(1, matcher.isMatch(BUFFER1, 8)); 
     assertEquals(1, matcher.isMatch(BUFFER1, 9)); 
     assertEquals(1, matcher.isMatch(BUFFER1, 10)); 
 }
@Test
public void testSplitMatcher6476() { 
     final StrMatcher matcher = StrMatcher.splitMatcher(); 
     assertSame(matcher, StrMatcher.splitMatcher()); 
     assertEquals(0, matcher.isMatch(BUFFER1, 2)); 
     assertEquals(1, matcher.isMatch(BUFFER1, 3)); 
     assertEquals(0, matcher.isMatch(BUFFER1, 4)); 
     assertEquals(1, matcher.isMatch(BUFFER1, 5)); 
     assertEquals(0, matcher.isMatch(BUFFER1, 6)); 
     assertEquals(1, matcher.isMatch(BUFFER1, 7)); 
     assertEquals(1, matcher.isMatch(BUFFER1, 8)); 
     assertEquals(1, matcher.isMatch(BUFFER1, 9)); 
     assertEquals(0, matcher.isMatch(BUFFER1, 10)); 
 }
@Test
public void testCharSetMatcher_String6909() { 
     final StrMatcher matcher = StrMatcher.charSetMatcher("ace"); 
     assertEquals(1, matcher.isMatch(BUFFER2, 0)); 
     assertEquals(0, matcher.isMatch(BUFFER2, 1)); 
     assertEquals(1, matcher.isMatch(BUFFER2, 2)); 
     assertEquals(0, matcher.isMatch(BUFFER2, 3)); 
     assertEquals(1, matcher.isMatch(BUFFER2, 4)); 
     assertEquals(0, matcher.isMatch(BUFFER2, 5)); 
     assertSame(StrMatcher.noneMatcher(), StrMatcher.charSetMatcher("")); 
     assertSame(StrMatcher.noneMatcher(), StrMatcher.charSetMatcher((String) null)); 
     assertTrue(StrMatcher.charSetMatcher("a") instanceof StrMatcher.CharMatcher); 
 }
@Test
public void testQuoteMatcher8125() { 
     final StrMatcher matcher = StrMatcher.quoteMatcher(); 
     assertSame(matcher, StrMatcher.quoteMatcher()); 
     assertEquals(0, matcher.isMatch(BUFFER1, 10)); 
     assertEquals(1, matcher.isMatch(BUFFER1, 11)); 
     assertEquals(1, matcher.isMatch(BUFFER1, 12)); 
 }
@Test
public void testStringMatcher_String8224() { 
     final StrMatcher matcher = StrMatcher.stringMatcher("bc"); 
     assertEquals(0, matcher.isMatch(BUFFER2, 0)); 
     assertEquals(2, matcher.isMatch(BUFFER2, 1)); 
     assertEquals(0, matcher.isMatch(BUFFER2, 2)); 
     assertEquals(0, matcher.isMatch(BUFFER2, 3)); 
     assertEquals(0, matcher.isMatch(BUFFER2, 4)); 
     assertEquals(0, matcher.isMatch(BUFFER2, 5)); 
     assertSame(StrMatcher.noneMatcher(), StrMatcher.stringMatcher("")); 
     assertSame(StrMatcher.noneMatcher(), StrMatcher.stringMatcher((String) null)); 
 }
@Test
public void testCharMatcher_char8335() { 
     final StrMatcher matcher = StrMatcher.charMatcher('c'); 
     assertEquals(0, matcher.isMatch(BUFFER2, 0)); 
     assertEquals(0, matcher.isMatch(BUFFER2, 1)); 
     assertEquals(1, matcher.isMatch(BUFFER2, 2)); 
     assertEquals(0, matcher.isMatch(BUFFER2, 3)); 
     assertEquals(0, matcher.isMatch(BUFFER2, 4)); 
     assertEquals(0, matcher.isMatch(BUFFER2, 5)); 
 }
@Test
public void testCharSetMatcher_String8402() { 
     final StrMatcher matcher = StrMatcher.charSetMatcher("ace"); 
     assertEquals(1, matcher.isMatch(BUFFER2, 0)); 
     assertEquals(0, matcher.isMatch(BUFFER2, 1)); 
     assertEquals(1, matcher.isMatch(BUFFER2, 2)); 
     assertEquals(0, matcher.isMatch(BUFFER2, 3)); 
     assertEquals(1, matcher.isMatch(BUFFER2, 4)); 
     assertEquals(0, matcher.isMatch(BUFFER2, 5)); 
     assertSame(StrMatcher.noneMatcher(), StrMatcher.charSetMatcher("")); 
     assertSame(StrMatcher.noneMatcher(), StrMatcher.charSetMatcher((String) null)); 
     assertTrue(StrMatcher.charSetMatcher("a") instanceof StrMatcher.CharMatcher); 
 }
@Test
public void testCommaMatcher8897() { 
     final StrMatcher matcher = StrMatcher.commaMatcher(); 
     assertSame(matcher, StrMatcher.commaMatcher()); 
     assertEquals(0, matcher.isMatch(BUFFER1, 0)); 
     assertEquals(1, matcher.isMatch(BUFFER1, 1)); 
     assertEquals(0, matcher.isMatch(BUFFER1, 2)); 
 }
@Test
public void testCharSetMatcher_String9620() { 
         final StrMatcher matcher = StrMatcher.charSetMatcher("ace"); 
         assertEquals(1, matcher.isMatch(BUFFER2, 0)); 
         assertEquals(0, matcher.isMatch(BUFFER2, 1)); 
         assertEquals(1, matcher.isMatch(BUFFER2, 2)); 
         assertEquals(0, matcher.isMatch(BUFFER2, 3)); 
         assertEquals(0, matcher.isMatch(BUFFER2, 4)); 
         assertEquals(0, matcher.isMatch(BUFFER2, 5)); 
         assertSame(StrMatcher.noneMatcher(), StrMatcher.charSetMatcher("")); 
         assertSame(StrMatcher.noneMatcher(), StrMatcher.charSetMatcher((String) null)); 
     } 
  
     //-----------------------------------------------------------------------
@Test
public void testCharSetMatcher_String11365() { 
         final StrMatcher matcher = StrMatcher.charSetMatcher("ace"); 
         assertEquals(1, matcher.isMatch(BUFFER2, 0)); 
         assertEquals(0, matcher.isMatch(BUFFER2, 1)); 
         assertEquals(1, matcher.isMatch(BUFFER2, 2)); 
         assertEquals(0, matcher.isMatch(BUFFER2, 3)); 
         assertEquals(0, matcher.isMatch(BUFFER2, 4)); 
         assertEquals(0, matcher.isMatch(BUFFER2, 5)); 
         assertSame(StrMatcher.noneMatcher(), StrMatcher.charSetMatcher("")); 
         assertSame(StrMatcher.noneMatcher(), StrMatcher.charSetMatcher((String) null)); 
     } 
  
     //-----------------------------------------------------------------------
@Test
public void testCharSetMatcher_String11367() { 
         final StrMatcher matcher = StrMatcher.charSetMatcher("ace"); 
         assertEquals(1, matcher.isMatch(BUFFER2, 0)); 
         assertEquals(0, matcher.isMatch(BUFFER2, 1)); 
         assertEquals(1, matcher.isMatch(BUFFER2, 2)); 
         assertEquals(0, matcher.isMatch(BUFFER2, 3)); 
         assertEquals(0, matcher.isMatch(BUFFER2, 4)); 
         assertEquals(0, matcher.isMatch(BUFFER2, 5)); 
         assertSame(StrMatcher.noneMatcher(), StrMatcher.charSetMatcher("")); 
         assertSame(StrMatcher.noneMatcher(), StrMatcher.charSetMatcher((String) null)); 
     } 
  
     //-----------------------------------------------------------------------
@Test
public void testCharSetMatcher_String11368() { 
         final StrMatcher matcher = StrMatcher.charSetMatcher("ace"); 
         assertEquals(1, matcher.isMatch(BUFFER2, 0)); 
         assertEquals(0, matcher.isMatch(BUFFER2, 1)); 
         assertEquals(1, matcher.isMatch(BUFFER2, 2)); 
         assertEquals(0, matcher.isMatch(BUFFER2, 3)); 
         assertEquals(0, matcher.isMatch(BUFFER2, 4)); 
         assertEquals(0, matcher.isMatch(BUFFER2, 5)); 
         assertSame(StrMatcher.noneMatcher(), StrMatcher.charSetMatcher("")); 
         assertSame(StrMatcher.noneMatcher(), StrMatcher.charSetMatcher((String) null)); 
     } 
  
     //-----------------------------------------------------------------------
@Test
public void testCharSetMatcher_String11369() { 
         final StrMatcher matcher = StrMatcher.charSetMatcher("ace"); 
         assertEquals(1, matcher.isMatch(BUFFER2, 0)); 
         assertEquals(0, matcher.isMatch(BUFFER2, 1)); 
         assertEquals(1, matcher.isMatch(BUFFER2, 2)); 
         assertEquals(0, matcher.isMatch(BUFFER2, 3)); 
         assertEquals(0, matcher.isMatch(BUFFER2, 4)); 
         assertEquals(0, matcher.isMatch(BUFFER2, 5)); 
         assertSame(StrMatcher.noneMatcher(), StrMatcher.charSetMatcher("")); 
         assertSame(StrMatcher.noneMatcher(), StrMatcher.charSetMatcher((String) null)); 
     } 
  
     //-----------------------------------------------------------------------
@Test
public void testCharSetMatcher_String11370() { 
         final StrMatcher matcher = StrMatcher.charSetMatcher("ace"); 
         assertEquals(1, matcher.isMatch(BUFFER2, 0)); 
         assertEquals(0, matcher.isMatch(BUFFER2, 1)); 
         assertEquals(1, matcher.isMatch(BUFFER2, 2)); 
         assertEquals(0, matcher.isMatch(BUFFER2, 3)); 
         assertEquals(0, matcher.isMatch(BUFFER2, 4)); 
         assertEquals(0, matcher.isMatch(BUFFER2, 5)); 
         assertSame(StrMatcher.noneMatcher(), StrMatcher.charSetMatcher("")); 
         assertSame(StrMatcher.noneMatcher(), StrMatcher.charSetMatcher((String) null)); 
     } 
  
     //-----------------------------------------------------------------------
    

    //-----------------------------------------------------------------------
    

    //-----------------------------------------------------------------------
    

    //-----------------------------------------------------------------------
    

    //-----------------------------------------------------------------------
    

    //-----------------------------------------------------------------------
    

    //-----------------------------------------------------------------------
    

    //-----------------------------------------------------------------------
    

    //-----------------------------------------------------------------------
    

    //-----------------------------------------------------------------------
    

    //-----------------------------------------------------------------------
    

    //-----------------------------------------------------------------------
    

    //-----------------------------------------------------------------------
    

    //-----------------------------------------------------------------------
    

}
