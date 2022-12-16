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

import org.junit.Test;
import static org.junit.Assert.*;
import java.io.Reader;
import java.io.Writer;
import java.util.Arrays;

import org.apache.commons.lang3.ArrayUtils;

/**
 * Unit tests for {@link org.apache.commons.lang3.text.StrBuilder}.
 * 
 * @version $Id$
 */
public class StrBuilderTest {

    //-----------------------------------------------------------------------
@Test
public void testSplitMatcher12() { 
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
public void testReplaceAll_char_char13() { 
     StrBuilder sb = new StrBuilder("abcbccba"); 
     sb.replaceAll('x', 'y'); 
     assertEquals("abcbccba", sb.toString()); 
     sb.replaceAll('a', 'd'); 
     assertEquals("dbcbccba", sb.toString()); 
     sb.replaceAll('b', 'e'); 
     assertEquals("decbccba", sb.toString()); 
     sb.replaceAll('c', 'f'); 
     assertEquals("defbccba", sb.toString()); 
     sb.replaceAll('d', 'd'); 
     assertEquals("defbccba", sb.toString()); 
 }
@Test
public void testLeftString16() { 
     final StrBuilder sb = new StrBuilder("left right"); 
     assertEquals("left right", sb.leftString(5)); 
     assertEquals("", sb.leftString(0)); 
     assertEquals("", sb.leftString(-5)); 
     assertEquals("left right", sb.leftString(15)); 
 }
@Test
public void testReplaceFirst_char_char17() { 
     final StrBuilder sb = new StrBuilder("abcbccba"); 
     sb.replaceFirst('x', 'y'); 
     assertEquals("abcbccba", sb.toString()); 
     sb.replaceFirst('a', 'd'); 
     assertEquals("dbcbccba", sb.toString()); 
     sb.replaceFirst('b', 'e'); 
     assertEquals("decbccba", sb.toString()); 
     sb.replaceFirst('c', 'f'); 
     assertEquals("defbccba", sb.toString()); 
     sb.replaceFirst('d', 'd'); 
     assertEquals("defbccba", sb.toString()); 
 }
@Test
public void testLastIndexOf_String28() { 
     final StrBuilder sb = new StrBuilder("abab"); 
     assertEquals(2, sb.lastIndexOf("a")); 
     assertEquals("abab".lastIndexOf("a"), sb.lastIndexOf("a")); 
     assertEquals(2, sb.lastIndexOf("ab")); 
     assertEquals("abab".lastIndexOf("ab"), sb.lastIndexOf("ab")); 
     assertEquals(3, sb.lastIndexOf("b")); 
     assertEquals("abab".lastIndexOf("b"), sb.lastIndexOf("b")); 
     assertEquals(1, sb.lastIndexOf("ba")); 
     assertEquals("abab".lastIndexOf("ba"), sb.lastIndexOf("ba")); 
     assertEquals(-1, sb.lastIndexOf("z")); 
     assertEquals(-1, sb.lastIndexOf((String) null)); 
 }
@Test
public void testMidString59() { 
     final StrBuilder sb = new StrBuilder("hello goodbye"); 
     assertEquals("hello", sb.midString(0, 5)); 
     assertEquals("hello goodbye".indexOf("goodbye"), sb.midString(0, 6)); 
     assertEquals("goodbye", sb.midString(6, 13)); 
     assertEquals("hello goodbye".indexOf("goodbye"), sb.midString(6, 13)); 
     assertEquals("goodbye", sb.midString(6, 20)); 
     assertEquals("hello goodbye".indexOf("goodbye"), sb.midString(6, 20)); 
     assertEquals("goodbye", sb.midString(6, 20)); 
     assertEquals("hello goodbye".indexOf("goodbye"), sb.midString(6, 20)); 
     assertEquals("goodbye", sb.midString(6, 20)); 
     assertEquals("hello goodbye".indexOf("goodbye"), sb.midString(6, 20)); 
 }
@Test
public void testReplaceAll_String_String63() { 
     StrBuilder sb = new StrBuilder("abcbccba"); 
     sb.replaceAll((String) null, null); 
     assertEquals("abcbccba", sb.toString()); 
     sb.replaceAll((String) null, "anything"); 
     assertEquals("abcbccba", sb.toString()); 
     sb.replaceAll("", null); 
     assertEquals("abcbccba", sb.toString()); 
     sb.replaceAll("", "anything"); 
     assertEquals("abcbccba", sb.toString()); 
     sb.replaceAll("x", "y"); 
     assertEquals("abcbccba", sb.toString()); 
     sb.replaceAll("a", "d"); 
     assertEquals("dbcbccbd", sb.toString()); 
     sb.replaceAll("d", null); 
     assertEquals("bcbccb", sb.toString()); 
     sb.replaceAll("cb", "-"); 
     assertEquals("b-c-", sb.toString()); 
     sb = new StrBuilder("abcba"); 
     sb.replaceAll("b", "xbx"); 
     assertEquals("axbxcxbxa", sb.toString()); 
     sb = new StrBuilder("bb"); 
     sb.replaceAll("b", "xbx"); 
     assertEquals("xbxxbx", sb.toString()); 
 }
@Test
public void testAsReader74() throws Exception { 
     final StrBuilder sb = new StrBuilder("some text"); 
     Reader reader = sb.asReader(); 
     assertTrue(reader.ready()); 
     final char[] buf = new char[40]; 
     assertEquals(9, reader.read(buf)); 
     assertEquals("some text", new String(buf, 0, 9)); 
     assertEquals(-1, reader.read()); 
     assertFalse(reader.ready()); 
     assertEquals(0, reader.skip(2)); 
     assertEquals(0, reader.skip(-1)); 
     assertTrue(reader.markSupported()); 
     reader = sb.asReader(); 
     assertEquals('s', reader.read()); 
     reader.mark(-1); 
     char[] array = new char[3]; 
     assertEquals(3, reader.read(array, 0, 3)); 
     assertEquals('o', array[0]); 
     assertEquals('m', array[1]); 
     assertEquals('e', array[2]); 
     reader.reset(); 
     assertEquals(1, reader.read(array, 1, 1)); 
     assertEquals('o', array[0]); 
     assertEquals('o', array[1]); 
     assertEquals('e', array[2]); 
     assertEquals(2, reader.skip(2)); 
     assertEquals(' ', reader.read()); 
     assertTrue(reader.ready()); 
     reader.close(); 
     assertTrue(reader.ready()); 
     reader = sb.asReader(); 
     array = new char[3]; 
     try { 
         reader.read(array, -1, 0); 
         fail(); 
     } catch (final IndexOutOfBoundsException ex) { 
     } 
     try { 
         reader.read(array, 0, -1); 
         fail(); 
     } catch (final IndexOutOfBoundsException ex
@Test
public void testDeleteIntInt179() { 
     StrBuilder sb = new StrBuilder("abc"); 
     sb.delete(0, 1); 
     assertEquals("bc", sb.toString()); 
     sb.delete(1, 2); 
     assertEquals("b", sb.toString()); 
     sb.delete(0, 1); 
     assertEquals("", sb.toString()); 
     sb.delete(0, 1000); 
     assertEquals("", sb.toString()); 
     try { 
         sb.delete(1, 2); 
         fail("Expected IndexOutOfBoundsException"); 
     } catch (final IndexOutOfBoundsException e) { 
     } 
     try { 
         sb.delete(-1, 1); 
         fail("Expected IndexOutOfBoundsException"); 
     } catch (final IndexOutOfBoundsException e) { 
     } 
     sb = new StrBuilder("anything"); 
     try { 
         sb.delete(2, 1); 
         fail("Expected IndexOutOfBoundsException"); 
     } catch (final IndexOutOfBoundsException e) { 
     } 
 }
@Test
public void testReplace_StrMatcher_String_int_int180() { 
     StrBuilder sb = new StrBuilder("abc"); 
     sb.replace((StrMatcher) null, null, 2, 4); 
     assertEquals("bc", sb.toString()); 
     sb.replace(StrMatcher.noneMatcher(), null, 2, 4); 
     assertEquals("bc", sb.toString()); 
     sb.replace(StrMatcher.noneMatcher(), "anything", 0, 2); 
     assertEquals("bc", sb.toString()); 
     try { 
         sb.replace(StrMatcher.noneMatcher(), "anything", -1, 1); 
         fail("Expected IndexOutOfBoundsException"); 
     } catch (final IndexOutOfBoundsException e) { 
     } 
     try { 
         sb.replace(StrMatcher.noneMatcher(), "anything", 4, 1); 
         fail("Expected IndexOutOfBoundsException"); 
     } catch (final IndexOutOfBoundsException e) { 
     } 
     sb.replace(StrMatcher.charMatcher('x'), "y"); 
     assertEquals("abcba", sb.toString()); 
     sb.replace(StrMatcher.charMatcher('a'), "d"); 
     assertEquals("dbcba", sb.toString()); 
     sb.replace(StrMatcher.stringMatcher("cb"), "-", 2, 4); 
     assertEquals("bcba", sb.toString()); 
     sb.replace(StrMatcher.stringMatcher("cb"), "-", 4, 1); 
     assertEquals("b-c-", sb.toString()); 
     sb = new StrBuilder("abcba"); 
     sb.replace(StrMatcher.charMatcher('b'), "xbx"); 
     assertEquals("axbxcxbxa", sb.toString()); 
     sb = new StrBuilder("bb"); 
     sb.replace(StrMatcher.charMatcher('b'), "xbx"); 
     assertEquals("xbxxbx", sb.toString()); 
     sb = new StrBuilder("A
@Test
public void testNoneMatcher181() { 
     final StrMatcher matcher = StrMatcher.noneMatcher(); 
     assertSame(matcher, StrMatcher.noneMatcher()); 
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
public void testReplaceAll_StrMatcher_String182() { 
     StrBuilder sb = new StrBuilder("abcbccba"); 
     sb.replaceAll((StrMatcher) null, null); 
     assertEquals("abcbccba", sb.toString()); 
     sb.replaceAll((StrMatcher) null, "anything"); 
     assertEquals("abcbccba", sb.toString()); 
     sb.replaceAll(StrMatcher.noneMatcher(), null); 
     assertEquals("abcbccba", sb.toString()); 
     sb.replaceAll(StrMatcher.noneMatcher(), "anything"); 
     assertEquals("abcbccba", sb.toString()); 
     sb.replaceAll(StrMatcher.noneMatcher(), "anything"); 
     assertEquals("abcbccba", sb.toString()); 
     sb.replaceAll(StrMatcher.noneMatcher(), "anything"); 
     assertEquals("abcbccba", sb.toString()); 
     sb.replaceAll(StrMatcher.charMatcher('x'), "y"); 
     assertEquals("abcbccba", sb.toString()); 
     sb.replaceAll(StrMatcher.charMatcher('a'), "d"); 
     assertEquals("dbcbccbd", sb.toString()); 
     sb.replaceAll(StrMatcher.charMatcher('d'), null); 
     assertEquals("bcbccb", sb.toString()); 
     sb.replaceAll(StrMatcher.stringMatcher("cb"), "-"); 
     assertEquals("b-c-", sb.toString()); 
     sb = new StrBuilder("abcba"); 
     sb.replaceAll(StrMatcher.charMatcher('b'), "xbx"); 
     assertEquals("axbxcxbxa", sb.toString()); 
     sb = new StrBuilder("bb"); 
     sb.replaceAll(StrMatcher.charMatcher('b'), "xbx"); 
     assertEquals("xbxxbx", sb.toString()); 
     sb = new StrBuilder("A1-A2A
@Test
public void testReplace_StrMatcher_String_int_int183() { 
     StrBuilder sb = new StrBuilder("abc"); 
     sb.replace((StrMatcher) null, null, 2, 1); 
     assertEquals("bc", sb.toString()); 
     sb.replace(StrMatcher.noneMatcher(), null, 2, 1); 
     assertEquals("bc", sb.toString()); 
     sb.replace(StrMatcher.noneMatcher(), "anything", 0, 1); 
     assertEquals("bc", sb.toString()); 
     sb.replace(StrMatcher.noneMatcher(), null, 2, 2); 
     assertEquals("b", sb.toString()); 
     sb.replace(StrMatcher.noneMatcher(), "anything", 0, 1); 
     assertEquals("", sb.toString()); 
     try { 
         sb.replace(StrMatcher.noneMatcher(), null, 2, 1); 
         fail("Expected NullPointerException"); 
     } catch (final NullPointerException npe) { 
     } 
     try { 
         sb.replace(StrMatcher.noneMatcher(), "anything", 1, 2); 
         fail("Expected IllegalArgumentException"); 
     } catch (final IllegalArgumentException npe) { 
     } 
     try { 
         sb.replace(StrMatcher.noneMatcher(), "anything", 2, 1); 
         fail("Expected IllegalArgumentException"); 
     } catch (final IllegalArgumentException npe) { 
     } 
     sb = new StrBuilder("anything"); 
     try { 
         sb.replace(StrMatcher.noneMatcher(), "anything", 1, 2); 
         fail("Expected IllegalArgumentException"); 
     } catch (final IllegalArgumentException npe) { 
     } 
 }
@Test
public void testMatcherIndices184() { 
     final StrMatcher matcher = StrMatcher.stringMatcher("bc"); 
     assertEquals(2, matcher.isMatch(BUFFER2, 1, 1, BUFFER2.length)); 
     assertEquals(2, matcher.isMatch(BUFFER2, 1, 0, 3)); 
     assertEquals(0, matcher.isMatch(BUFFER2, 1, 0, 2)); 
 }
@Test
public void testReplaceAll_StrMatcher_String185() { 
     StrBuilder sb = new StrBuilder("abcbccba"); 
     sb.replaceAll((StrMatcher) null, null); 
     assertEquals("abcbccba", sb.toString()); 
     sb.replaceAll((StrMatcher) null, "anything"); 
     assertEquals("abcbccba", sb.toString()); 
     sb.replaceAll("", null); 
     assertEquals("abcbccba", sb.toString()); 
     sb.replaceAll("", "anything"); 
     assertEquals("abcbccba", sb.toString()); 
     sb.replaceAll("x", "y"); 
     assertEquals("abcbccba", sb.toString()); 
     sb.replaceAll("a", "d"); 
     assertEquals("dbcbccbd", sb.toString()); 
     sb.replaceAll("d", null); 
     assertEquals("bcbccb", sb.toString()); 
     sb.replaceAll("cb", "-"); 
     assertEquals("b-c-", sb.toString()); 
     sb = new StrBuilder("abcba"); 
     sb.replaceAll("b", "xbx"); 
     assertEquals("axbxcxbxa", sb.toString()); 
     sb = new StrBuilder("bb"); 
     sb.replaceAll("b", "xbx"); 
     assertEquals("xbxxbx", sb.toString()); 
 }
@Test
public void testCharMatcher_char186() { 
     final StrMatcher matcher = StrMatcher.charMatcher('a'); 
     assertEquals(0, matcher.isMatch(BUFFER2, 0)); 
     assertEquals(1, matcher.isMatch(BUFFER2, 1)); 
     assertEquals(0, matcher.isMatch(BUFFER2, 2)); 
     assertEquals(1, matcher.isMatch(BUFFER2, 3)); 
     assertEquals(0, matcher.isMatch(BUFFER2, 4)); 
     assertEquals(1, matcher.isMatch(BUFFER2, 5)); 
     assertSame(StrMatcher.noneMatcher(), StrMatcher.charMatcher(CHAR_COPY)); 
     assertSame(StrMatcher.noneMatcher(), StrMatcher.charMatcher((char) 0)); 
     assertSame(StrMatcher.noneMatcher(), StrMatcher.charMatcher((char[]) null)); 
 }
@Test
public void testCharMatcher_char187() { 
     final StrMatcher matcher = StrMatcher.charMatcher('a'); 
     assertEquals(0, matcher.isMatch(BUFFER2, 0)); 
     assertEquals(1, matcher.isMatch(BUFFER2, 1)); 
     assertEquals(0, matcher.isMatch(BUFFER2, 2)); 
     assertEquals(1, matcher.isMatch(BUFFER2, 3)); 
     assertEquals(0, matcher.isMatch(BUFFER2, 4)); 
     assertEquals(1, matcher.isMatch(BUFFER2, 5)); 
     assertSame(StrMatcher.noneMatcher(), StrMatcher.charMatcher(Character.MIN_VALUE)); 
     assertSame(StrMatcher.noneMatcher(), StrMatcher.charMatcher((char) 0)); 
     assertSame(StrMatcher.noneMatcher(), StrMatcher.charMatcher((char[]) null)); 
 }
@Test
public void testLeftString198() { 
     final StrBuilder sb = new StrBuilder(); 
     assertEquals("", sb.leftString(5)); 
     assertEquals("", sb.leftString(0)); 
     assertEquals("", sb.leftString(-5)); 
     assertEquals("", sb.leftString(15)); 
 }
@Test
public void testLeftString199() { 
     final StrBuilder sb = new StrBuilder("left right"); 
     assertEquals("right", sb.leftString(5)); 
     assertEquals("", sb.leftString(0)); 
     assertEquals("", sb.leftString(-5)); 
     assertEquals("left right", sb.leftString(15)); 
 }
@Test
public void testIndexOfLang294354() { 
     final StrBuilder sb = new StrBuilder("onetwothree"); 
     sb.deleteAll("three"); 
     assertEquals(-1, sb.indexOf("three")); 
 }
@Test
public void testCapacityAndLength385() { 
     final StrBuilder sb = new StrBuilder(); 
     assertEquals(32, sb.capacity()); 
     assertEquals(0, sb.length()); 
     assertEquals(0, sb.size()); 
     assertTrue(sb.isEmpty()); 
     sb.minimizeCapacity(); 
     assertEquals(0, sb.capacity()); 
     assertEquals(0, sb.length()); 
     assertEquals(0, sb.size()); 
     assertTrue(sb.isEmpty()); 
     sb.ensureCapacity(32); 
     assertTrue(sb.capacity() >= 32); 
     assertEquals(0, sb.length()); 
     assertEquals(0, sb.size()); 
     assertTrue(sb.isEmpty()); 
     sb.append("foo"); 
     assertTrue(sb.capacity() >= 32); 
     assertEquals(3, sb.length()); 
     assertEquals(3, sb.size()); 
     assertTrue(sb.isEmpty() == false); 
     sb.clear(); 
     assertTrue(sb.capacity() >= 32); 
     assertEquals(0, sb.length()); 
     assertEquals(0, sb.size()); 
     assertTrue(sb.isEmpty()); 
     sb.append("123456789012345678901234567890123"); 
     assertTrue(sb.capacity() > 32); 
     assertEquals(33, sb.length()); 
     assertEquals(33, sb.size()); 
     assertTrue(sb.isEmpty() == false); 
     sb.ensureCapacity(16); 
     assertTrue(sb.capacity() > 16); 
     assertEquals(33, sb.length()); 
     assertEquals(33, sb.size()); 
     assertTrue(sb.isEmpty() == false); 
     sb.minimizeCapacity(); 
     assertEquals(33, sb.capacity()); 
     assertEquals(33, sb.length());
    

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
    

    

    // -----------------------------------------------------------------------
    

    

    // -----------------------------------------------------------------------
    

    

    // -----------------------------------------------------------------------
    

    //-----------------------------------------------------------------------
    

    //-----------------------------------------------------------------------
    

    //-----------------------------------------------------------------------
    

    

    //-----------------------------------------------------------------------
    

    

    //-----------------------------------------------------------------------
    

    

    

    

    

    //-----------------------------------------------------------------------
    

    //-----------------------------------------------------------------------
    

    //-----------------------------------------------------------------------
    

    

    //-----------------------------------------------------------------------
    

    
    
    

    // -----------------------------------------------------------------------
    

    

    

    // -----------------------------------------------------------------------
    

    

    

    // -----------------------------------------------------------------------
    

    

    

    

    // -----------------------------------------------------------------------
    

    

    

    

    // -----------------------------------------------------------------------
    

    

    

    

    static final StrMatcher A_NUMBER_MATCHER = new StrMatcher() {
        @Override
        public int isMatch(final char[] buffer, int pos, final int bufferStart, final int bufferEnd) {
            if (buffer[pos] == 'A') {
                pos++;
                if (pos < bufferEnd && buffer[pos] >= '0' && buffer[pos] <= '9') {
                    return 2;
                }
            }
            return 0;
        }
    };

    //-----------------------------------------------------------------------
    

    // -----------------------------------------------------------------------
    

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
