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
public void testCapacity326() { 
     final StrBuilder sb = new StrBuilder(); 
     assertEquals(sb.buffer.length, sb.capacity()); 
     sb.append("HelloWorldHelloWorldHelloWorldHelloWorld"); 
     assertEquals(sb.buffer.length, sb.capacity()); 
 }
@Test
public void testReplaceFirst_char_char327() { 
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
public void testGetNewLineText328() { 
     final StrBuilder sb = new StrBuilder(); 
     assertEquals("", sb.getNewLineText()); 
     sb.append("foo"); 
     assertEquals("foo", sb.getNewLineText()); 
     sb.append(""); 
     assertEquals("foo", sb.getNewLineText()); 
     sb.append("bar"); 
     assertEquals("foobar", sb.getNewLineText()); 
 }
@Test
public void testAppend_String329() { 
     StrBuilder sb = new StrBuilder(); 
     sb.setNullText("NULL").append((String) null); 
     assertEquals("NULL", sb.toString()); 
     sb = new StrBuilder(); 
     sb.append("foo"); 
     assertEquals("foo", sb.toString()); 
     sb.append(""); 
     assertEquals("foo", sb.toString()); 
     sb.append("bar"); 
     assertEquals("foobar", sb.toString()); 
 }
@Test
public void testSetLength331() { 
     final StrBuilder sb = new StrBuilder(); 
     try { 
         sb.setLength(0); 
         fail("setLength(0) expected IndexOutOfBoundsException"); 
     } catch (final IndexOutOfBoundsException e) { 
     } 
     try { 
         sb.setLength(-1); 
         fail("setLength(-1) expected IndexOutOfBoundsException"); 
     } catch (final IndexOutOfBoundsException e) { 
     } 
     sb.append("foo"); 
     sb.setLength(3); 
     sb.setLength(4); 
     assertEquals("foo", sb.toString()); 
     try { 
         sb.setLength(5); 
         fail("setLength(5) expected IndexOutOfBoundsException"); 
     } catch (final IndexOutOfBoundsException e) { 
     } 
     assertEquals("foobar", sb.toString()); 
     sb.setLength(6); 
     assertEquals("foo", sb.toString()); 
     sb.setLength(7); 
     assertEquals("foobar", sb.toString()); 
     sb.setLength(8); 
     assertEquals("foobar", sb.toString()); 
 }
@Test
public void testChaining332() { 
     final StrBuilder sb = new StrBuilder(); 
     assertSame(sb, sb.setNewLineText(null)); 
     assertSame(sb, sb.setNullText(null)); 
     assertSame(sb, sb.setLength(1)); 
     assertSame(sb, sb.setCharAt(0, 'a')); 
     assertSame(sb, sb.ensureCapacity(0)); 
     assertSame(sb, sb.minimizeCapacity()); 
     assertSame(sb, sb.clear()); 
     assertSame(sb, sb.reverse()); 
     assertSame(sb, sb.trim()); 
 }
@Test
public void testMinimizeCapacity333() { 
     final StrBuilder sb = new StrBuilder(); 
     assertEquals(sb.buffer.length, sb.minimizeCapacity()); 
     sb.append("HelloWorldHelloWorldHelloWorldHelloWorld"); 
     assertEquals(sb.buffer.length, sb.minimizeCapacity()); 
 }
@Test
public void testAppendFixedWidthPadLeft_int350() { 
     final StrBuilder sb = new StrBuilder(); 
     sb.appendFixedWidthPadLeft(123, -1, '-'); 
     assertEquals("", sb.toString()); 
     sb.clear(); 
     sb.appendFixedWidthPadLeft(123, 0, '-'); 
     assertEquals("", sb.toString()); 
     sb.clear(); 
     sb.appendFixedWidthPadLeft(123, 1, '-'); 
     assertEquals("3", sb.toString()); 
     sb.clear(); 
     sb.appendFixedWidthPadLeft(123, 2, '-'); 
     assertEquals("23", sb.toString()); 
     sb.clear(); 
     sb.appendFixedWidthPadLeft(123, 3, '-'); 
     assertEquals("123", sb.toString()); 
     sb.clear(); 
     sb.appendFixedWidthPadLeft(123, 4, '-'); 
     assertEquals("-123", sb.toString()); 
     sb.clear(); 
     sb.appendFixedWidthPadLeft(123, 10, '-'); 
     assertEquals(10, sb.length()); 
     assertEquals("-------123", sb.toString()); 
 }
@Test
public void testLang294352() { 
     final StrBuilder sb = new StrBuilder("\n%BLAH%\nDo more stuff\neven more stuff\n%BLAH%\n"); 
     sb.deleteAll("\n%BLAH%"); 
     assertEquals("\nDo more stuff\neven more stuff\n", sb.toString()); 
 }
@Test
public void testDelete_int_int354() { 
     StrBuilder sb = new StrBuilder("abc"); 
     sb.delete(0, 1); 
     assertEquals("bc", sb.toString()); 
     try { 
         sb.delete(1000, -1); 
         fail("Expected IndexOutOfBoundsException"); 
     } catch (final IndexOutOfBoundsException e) { 
     } 
     try { 
         sb.delete(2, 1); 
         fail("Expected IndexOutOfBoundsException"); 
     } catch (final IndexOutOfBoundsException e) { 
     } 
     sb = new StrBuilder("atext"); 
     sb.delete(2, 1); 
     assertEquals("anytext", sb.toString()); 
     try { 
         sb.delete(3, 1); 
         fail("Expected IndexOutOfBoundsException"); 
     } catch (final IndexOutOfBoundsException e) { 
     } 
     try { 
         sb.delete(-1, 1); 
         fail("Expected IndexOutOfBoundsException"); 
     } catch (final IndexOutOfBoundsException e) { 
     } 
 }
@Test
public void testDeleteFirst_String355() { 
     StrBuilder sb = new StrBuilder("abcba"); 
     sb.deleteFirst("a"); 
     assertEquals("abcba", sb.toString()); 
     sb.deleteFirst(""); 
     assertEquals("bcba", sb.toString()); 
     sb.deleteFirst("cba"); 
     assertEquals("bba", sb.toString()); 
     sb.deleteFirst("ba"); 
     assertEquals("ba", sb.toString()); 
     sb = new StrBuilder(""); 
     sb.deleteFirst("b"); 
     assertEquals("", sb.toString()); 
 }
@Test
public void testSubstringIntInt356() { 
     final StrBuilder sb = new StrBuilder("hello goodbye"); 
     assertEquals("hello", sb.substring(0, 5)); 
     assertEquals("hello goodbye".substring(0, 6), sb.substring(0, 6)); 
     assertEquals("goodbye", sb.substring(6, 13)); 
     assertEquals("hello goodbye".substring(6, 13), sb.substring(6, 13)); 
     assertEquals("goodbye", sb.substring(6, 20)); 
     try { 
         sb.substring(-1, 5); 
         fail(); 
     } catch (final IndexOutOfBoundsException e) { 
     } 
     try { 
         sb.substring(15, 20); 
         fail(); 
     } catch (final IndexOutOfBoundsException e) { 
     } 
 }
@Test
public void testLeftString_int357() { 
     final StrBuilder sb = new StrBuilder("left"); 
     assertEquals("left", sb.leftString(5)); 
     assertEquals("", sb.leftString(0)); 
     assertEquals("", sb.leftString(-5)); 
     assertEquals("left", sb.leftString(15)); 
 }
@Test
public void testLeftString358() { 
     final StrBuilder sb = new StrBuilder("left"); 
     assertEquals("left", sb.leftString(5)); 
     assertEquals("", sb.leftString(0)); 
     assertEquals("", sb.leftString(-5)); 
     assertEquals("left", sb.leftString(15)); 
 }
@Test
public void testLang295359() { 
     final StrBuilder sb = new StrBuilder("onetwothree"); 
     sb.deleteFirst("three"); 
     assertFalse("The contains(char) method is looking beyond the end of the string", sb.contains('h')); 
     assertEquals("The indexOf(char) method is looking beyond the end of the string", -1, sb.indexOf('h')); 
 }
@Test
public void testReplaceAll_String_String360() { 
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
public void testIndexOf_String361() { 
     final StrBuilder sb = new StrBuilder("abab"); 
     assertEquals(0, sb.indexOf("a")); 
     assertEquals(0, sb.indexOf("a")); 
     assertEquals(1, sb.indexOf("ab")); 
     assertEquals(2, sb.indexOf("ab")); 
     assertEquals(-1, sb.indexOf("z")); 
 }
@Test
public void testIndexOf_StrMatcher_int362() { 
     StrBuilder sb = new StrBuilder(); 
     assertEquals(-1, sb.indexOf((StrMatcher) null, -1)); 
     assertEquals(-1, sb.indexOf(StrMatcher.charMatcher('a'), 0)); 
     assertEquals(-1, sb.indexOf(StrMatcher.charMatcher('a'), 1)); 
     assertEquals(0, sb.indexOf(StrMatcher.charMatcher('a'), 1)); 
     assertEquals(1, sb.indexOf(StrMatcher.spaceMatcher(), 0)); 
     assertEquals(2, sb.indexOf(StrMatcher.charMatcher('b'), 2)); 
     assertEquals(3, sb.indexOf(StrMatcher.spaceMatcher(), 3)); 
     assertEquals(-1, sb.indexOf(StrMatcher.charMatcher('z'), 0)); 
     sb = new StrBuilder(); 
     assertEquals(-1, sb.indexOf(StrMatcher.charMatcher('a'), -1)); 
     assertEquals(2, sb.indexOf(StrMatcher.charMatcher('b'), 2)); 
     assertEquals(3, sb.indexOf(StrMatcher.spaceMatcher(), 1)); 
     assertEquals(-1, sb.indexOf(StrMatcher.charMatcher('z'), 1)); 
 }
@Test
public void testIndexOf_StrMatcher_int363() { 
     StrBuilder sb = new StrBuilder(); 
     assertEquals(-1, sb.indexOf((StrMatcher) null, -1)); 
     assertEquals(-1, sb.indexOf(StrMatcher.charMatcher('a'), 0)); 
     assertEquals(-1, sb.indexOf(StrMatcher.charMatcher('a'), -1)); 
     assertEquals(0, sb.indexOf(StrMatcher.charMatcher('a'), 0)); 
     assertEquals(1, sb.indexOf(StrMatcher.spaceMatcher(), 0)); 
     assertEquals(2, sb.indexOf(StrMatcher.charMatcher('b'), 0)); 
     assertEquals(3, sb.indexOf(StrMatcher.spaceMatcher(), 1)); 
     assertEquals(-1, sb.indexOf(StrMatcher.charMatcher('d'), 0)); 
     assertEquals(0, sb.indexOf(StrMatcher.noneMatcher(), 0)); 
     assertEquals(-1, sb.indexOf((StrMatcher) null, 0)); 
     assertEquals(-1, sb.indexOf(StrMatcher.stringMatcher(""), 0)); 
     assertEquals(0, sb.indexOf("", 0)); 
     assertEquals(-1, sb.indexOf("", 1)); 
     assertEquals(-1, sb.indexOf("", 2)); 
     assertEquals(-1, sb.indexOf("", 3)); 
     assertEquals(-1, sb.indexOf((StrMatcher) null, 3)); 
 }
@Test
public void testIndexOf_StrMatcher_int364() { 
     StrBuilder sb = new StrBuilder(); 
     assertEquals(-1, sb.indexOf((StrMatcher) null, -1)); 
     assertEquals(-1, sb.indexOf(StrMatcher.charMatcher('a'))); 
     sb.append("ab bd"); 
     assertEquals(0, sb.indexOf(StrMatcher.charMatcher('a'))); 
     assertEquals(1, sb.indexOf(StrMatcher.charMatcher('b'))); 
     assertEquals(2, sb.indexOf(StrMatcher.spaceMatcher())); 
     assertEquals(4, sb.indexOf(StrMatcher.charMatcher('d'))); 
     assertEquals(-1, sb.indexOf(StrMatcher.noneMatcher())); 
     assertEquals(-1, sb.indexOf((StrMatcher) null)); 
     sb.append(" A1 junction"); 
     assertEquals(6, sb.indexOf(A_NUMBER_MATCHER, 0)); 
     assertEquals(-1, sb.indexOf(A_NUMBER_MATCHER, 1)); 
 }
@Test
public void testLastIndexOf_StrMatcher366() { 
     final StrBuilder sb = new StrBuilder("abab"); 
     assertEquals(2, sb.lastIndexOf(StrMatcher.charMatcher('a'))); 
     assertEquals("abab".lastIndexOf('a'), sb.lastIndexOf(StrMatcher.charMatcher('a'))); 
     assertEquals(3, sb.lastIndexOf(StrMatcher.charMatcher('b'))); 
     assertEquals("abab".lastIndexOf('b'), sb.lastIndexOf(StrMatcher.charMatcher('b'))); 
     assertEquals(-1, sb.lastIndexOf(StrMatcher.noneMatcher())); 
     assertEquals(-1, sb.lastIndexOf((StrMatcher) null)); 
     sb.append("abab"); 
     assertEquals(6, sb.lastIndexOf(A_NUMBER_MATCHER)); 
 }
@Test
public void testLastIndexOf_StrMatcher367() { 
     final StrBuilder sb = new StrBuilder("abab"); 
     assertEquals(2, sb.lastIndexOf(StrMatcher.charMatcher('a'))); 
     assertEquals("abab".lastIndexOf("a"), sb.lastIndexOf(StrMatcher.charMatcher('a'))); 
     assertEquals(3, sb.lastIndexOf(StrMatcher.charMatcher('b'))); 
     assertEquals("abab".lastIndexOf("b"), sb.lastIndexOf(StrMatcher.charMatcher('b'))); 
     assertEquals(-1, sb.lastIndexOf(StrMatcher.noneMatcher())); 
     assertEquals(-1, sb.lastIndexOf((StrMatcher) null)); 
     sb.append("abab"); 
     assertEquals(6, sb.lastIndexOf(A_NUMBER_MATCHER)); 
 }
@Test
public void testToStringBuilder373() { 
     final StrBuilder sb = new StrBuilder(); 
     assertEquals("", sb.toStringBuilder().toString()); 
     sb.append("junit"); 
     assertEquals("junit", sb.toStringBuilder().toString()); 
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
