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
public void testToCharArrayIntInt273() { 
     final StrBuilder sb = new StrBuilder(); 
     assertEquals(ArrayUtils.EMPTY_CHAR_ARRAY, sb.toCharArray()); 
     sb.append("junit"); 
     char[] a = sb.toCharArray(); 
     assertEquals("toCharArray(int,int) result incorrect length", 5, a.length); 
     assertTrue("toCharArray(int,int) result does not match", Arrays.equals("junit".toCharArray(), a)); 
     a = sb.toCharArray(0, 4); 
     assertEquals("toCharArray(int,int) result incorrect length", 4, a.length); 
     assertTrue("toCharArray(int,int) result does not match", Arrays.equals("juni".toCharArray(), a)); 
     a = sb.toCharArray(0, 4); 
     assertEquals("toCharArray(int,int) result incorrect length", 4, a.length); 
     assertTrue("toCharArray(int,int) result does not match", Arrays.equals("juni".toCharArray(), a)); 
     a = sb.toCharArray(0, 1); 
     assertNotNull("toCharArray(int,int) result is null", a); 
     try { 
         sb.toCharArray(-1, 5); 
         fail("no string index out of bound on -1"); 
     } catch (final IndexOutOfBoundsException e) { 
     } 
     try { 
         sb.toCharArray(6, 5); 
         fail("no string index out of bound on -1"); 
     } catch (final IndexOutOfBoundsException e) { 
     } 
 }
@Test
public void testToCharArray274() { 
     final StrBuilder sb = new StrBuilder(); 
     assertEquals(ArrayUtils.EMPTY_CHAR_ARRAY, sb.toCharArray()); 
     sb.append("junit"); 
     char[] a = sb.toCharArray(); 
     assertEquals("toCharArray(int,int) result incorrect length", 5, a.length); 
     assertTrue("toCharArray(int,int) result does not match", Arrays.equals("junit".toCharArray(), a)); 
     a = sb.toCharArray(0, 4); 
     assertEquals("toCharArray(int,int) result incorrect length", 4, a.length); 
     assertTrue("toCharArray(int,int) result does not match", Arrays.equals("juni".toCharArray(), a)); 
     a = sb.toCharArray(0, 4); 
     assertEquals("toCharArray(int,int) result incorrect length", 4, a.length); 
     assertTrue("toCharArray(int,int) result does not match", Arrays.equals("juni".toCharArray(), a)); 
     a = sb.toCharArray(0, 1); 
     assertNotNull("toCharArray(int,int) result is null", a); 
     try { 
         sb.toCharArray(-1, 5); 
         fail("no string index out of bound on -1"); 
     } catch (final IndexOutOfBoundsException e) { 
     } 
     try { 
         sb.toCharArray(6, 5); 
         fail("no string index out of bound on -1"); 
     } catch (final IndexOutOfBoundsException e) { 
     } 
 }
@Test
public void testAppend_CharArray285() { 
     StrBuilder sb = new StrBuilder(); 
     sb.append((char[]) null); 
     assertEquals("", sb.toString()); 
     sb = new StrBuilder(); 
     sb.append(new char[0]); 
     assertEquals("", sb.toString()); 
     sb.append(new char[] { 'f', 'o', 'o' }); 
     assertEquals("foo", sb.toString()); 
 }
@Test
public void testReplaceFirst_String_String294() { 
     StrBuilder sb = new StrBuilder("abcbccba"); 
     sb.replaceFirst((String) null, null); 
     assertEquals("abcbccba", sb.toString()); 
     sb.replaceFirst((String) null, "anything"); 
     assertEquals("abcbccba", sb.toString()); 
     sb.replaceFirst("", null); 
     assertEquals("abcbccba", sb.toString()); 
     sb.replaceFirst("", "anything"); 
     assertEquals("abcbccba", sb.toString()); 
     sb.replaceFirst("x", "y"); 
     assertEquals("abcbccba", sb.toString()); 
     sb.replaceFirst("a", "d"); 
     assertEquals("dbcbccba", sb.toString()); 
     sb.replaceFirst("d", null); 
     assertEquals("bcbccba", sb.toString()); 
     sb.replaceFirst("cb", "-"); 
     assertEquals("b-ccba", sb.toString()); 
     sb = new StrBuilder("abcba"); 
     sb.replaceFirst("b", "xbx"); 
     assertEquals("axbxcba", sb.toString()); 
     sb = new StrBuilder("bb"); 
     sb.replaceFirst("b", "xbx"); 
     assertEquals("xbxb", sb.toString()); 
 }
@Test
public void testReplaceAll_String_String295() { 
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
     assertEquals("dbcbccba", sb.toString()); 
     sb.replaceAll("d", null); 
     assertEquals("bcbccba", sb.toString()); 
     sb.replaceAll("cb", "-"); 
     assertEquals("b-ccba", sb.toString()); 
     sb = new StrBuilder("abcba"); 
     sb.replaceAll("b", "xbx"); 
     assertEquals("axbxcba", sb.toString()); 
     sb = new StrBuilder("bb"); 
     sb.replaceAll("b", "xbx"); 
     assertEquals("xbxb", sb.toString()); 
 }
@Test
public void testReplaceAll_StrMatcher_String296() { 
     StrBuilder sb = new StrBuilder("abcbccba"); 
     sb.replaceAll((StrMatcher) null, null); 
     assertEquals("abcbccba", sb.toString()); 
     sb.replaceAll(StrMatcher.noneMatcher(), null); 
     assertEquals("abcbccba", sb.toString()); 
     sb.replaceAll(StrMatcher.noneMatcher(), "anything"); 
     assertEquals("abcbccba", sb.toString()); 
     sb.replaceAll(StrMatcher.charMatcher('x'), "y"); 
     assertEquals("abcbccba", sb.toString()); 
     sb.replaceAll(StrMatcher.charMatcher('a'), "d"); 
     assertEquals("dbcbccba", sb.toString()); 
     sb.replaceAll(StrMatcher.charMatcher('d'), null); 
     assertEquals("bcbccba", sb.toString()); 
     sb.replaceAll(StrMatcher.stringMatcher("cb"), "-"); 
     assertEquals("b-ccba", sb.toString()); 
     sb = new StrBuilder("abcba"); 
     sb.replaceAll(StrMatcher.charMatcher('b'), "xbx"); 
     assertEquals("axbxcba", sb.toString()); 
     sb = new StrBuilder("bb"); 
     sb.replaceAll(StrMatcher.charMatcher('b'), "xbx"); 
     assertEquals("xbxb", sb.toString()); 
     sb = new StrBuilder("A1-A2A3-A4"); 
     sb.replaceAll(A_NUMBER_MATCHER, "***"); 
     assertEquals("***-A2A3-A4", sb.toString()); 
 }
@Test
public void testTrim297() { 
     final StrBuilder sb = new StrBuilder(); 
     assertEquals("", sb.reverse().toString()); 
     sb.clear().append(" \u0000 "); 
     assertEquals("", sb.trim().toString()); 
     sb.clear().append(" \u0000 a b c"); 
     assertEquals("a b c", sb.trim().toString()); 
     sb.clear().append("a b c \u0000 "); 
     assertEquals("a b c", sb.trim().toString()); 
     sb.clear().append(" \u0000 a b c \u0000 "); 
     assertEquals("a b c", sb.trim().toString()); 
     sb.clear().append("a b c"); 
     assertEquals("a b c", sb.trim().toString()); 
 }
@Test
public void testStartsWith298() { 
     final StrBuilder sb = new StrBuilder(); 
     assertFalse(sb.startsWith(null)); 
     assertFalse(sb.startsWith("")); 
     assertFalse(sb.startsWith(" ")); 
     assertTrue(sb.startsWith("a")); 
     assertTrue(sb.startsWith("A")); 
     assertTrue(sb.startsWith("kgKgKgKgkgkGkjkjlJlOKLgHdGdHgl")); 
     assertFalse(sb.startsWith("ham kso")); 
     assertFalse(sb.startsWith("1")); 
     assertFalse(sb.startsWith("hkHKHik6iUGHKJgU7tUJgKJGI87GIkug")); 
     assertFalse(sb.startsWith("_")); 
     assertFalse(sb.startsWith("hkHKHik*khbkuh")); 
 }
@Test
public void testStartsWith299() { 
     final StrBuilder sb = new StrBuilder(); 
     assertFalse(sb.startsWith("a")); 
     assertFalse(sb.startsWith("c")); 
     assertTrue(sb.startsWith("")); 
     assertFalse(sb.startsWith(null)); 
     sb.append("abc"); 
     assertTrue(sb.startsWith("c")); 
     assertTrue(sb.startsWith("bc")); 
     assertTrue(sb.startsWith("abc")); 
     assertFalse(sb.startsWith("cba")); 
     assertFalse(sb.startsWith("abcd")); 
     assertFalse(sb.startsWith(" abc")); 
     assertFalse(sb.startsWith("abc ")); 
 }
@Test
public void testMidString301() { 
     final StrBuilder sb = new StrBuilder("hello goodbye"); 
     assertEquals("hello", sb.midString(0, 5)); 
     assertEquals("hello goodbye".hashCode(), sb.midString(0, 6)); 
     assertEquals("hello goodbye".hashCode(), sb.midString(6, 13)); 
     assertEquals("hello goodbye".hashCode(), sb.midString(6, 13)); 
     assertEquals("goodbye", sb.midString(6, 20)); 
     try { 
         sb.midString(-1, 5); 
         fail(); 
     } catch (final IndexOutOfBoundsException e) { 
     } 
     try { 
         sb.midString(15, 20); 
         fail(); 
     } catch (final IndexOutOfBoundsException e) { 
     } 
 }
@Test
public void testMidString302() { 
     final StrBuilder sb = new StrBuilder("hello goodbye"); 
     assertEquals("hello", sb.midString(0, 5)); 
     assertEquals("hello goodbye".toString(), sb.midString(0, 6)); 
     assertEquals("goodbye", sb.midString(6, 13)); 
     assertEquals("hello goodbye".toString(), sb.midString(6, 13)); 
     assertEquals("goodbye", sb.midString(6, 20)); 
     try { 
         sb.midString(-1, 5); 
         fail(); 
     } catch (final IndexOutOfBoundsException e) { 
     } 
     try { 
         sb.midString(15, 20); 
         fail(); 
     } catch (final IndexOutOfBoundsException e) { 
     } 
 }
@Test
public void testIndexOf_char_int305() { 
     StrBuilder sb = new StrBuilder("abab"); 
     assertEquals(0, sb.indexOf('a', -1)); 
     assertEquals("abab".indexOf('a', -1), sb.indexOf('a', 0)); 
     assertEquals("abab".indexOf('a', 1), sb.indexOf('a', 1)); 
     assertEquals("abab".indexOf('b', 2), sb.indexOf('b', 2)); 
     assertEquals(-1, sb.indexOf('z', 2)); 
     sb = new StrBuilder("xyzabc"); 
     assertEquals(2, sb.indexOf('z', sb.length())); 
     assertEquals(-1, sb.indexOf('z', sb.length())); 
     sb = new StrBuilder("xyzabc"); 
     assertEquals(-1, sb.indexOf('z', sb.length())); 
     sb = new StrBuilder("xyzabc"); 
     assertEquals(-1, sb.indexOf('z', sb.length())); 
 }
@Test
public void testIndexOf_char_int306() { 
     StrBuilder sb = new StrBuilder("abab"); 
     assertEquals(0, sb.indexOf('a', -1)); 
     assertEquals("abab".indexOf('a', 1), sb.indexOf('a', 1)); 
     assertEquals(1, sb.indexOf('b', 2)); 
     assertEquals("abab".indexOf('b', 2), sb.indexOf('b', 2)); 
     assertEquals(-1, sb.indexOf('z', 2)); 
     sb = new StrBuilder("xyzabc"); 
     assertEquals(2, sb.indexOf('z', sb.length())); 
     assertEquals(-1, sb.indexOf('z', sb.length())); 
     sb = new StrBuilder("xyzabc"); 
     assertEquals(-1, sb.indexOf('z', sb.length())); 
     sb = new StrBuilder("xyzabc"); 
     assertEquals(-1, sb.indexOf('z', sb.length())); 
 }
@Test
public void testLang294307() { 
     final StrBuilder sb = new StrBuilder("\n%BLAH%\nDo more stuff\neven more stuff\n%BLAH%\n"); 
     sb.deleteAll("\n%BLAH%"); 
     assertEquals("\nDo more stuff\neven more stuff\n", sb.toString()); 
 }
@Test
public void testReplaceFirst_char_char315() { 
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
public void testWrite_Boolean316() { 
     final StrBuilder sb = new StrBuilder(); 
     sb.append(true); 
     assertEquals("true", sb.toString()); 
     sb.append(false); 
     assertEquals("truefalse", sb.toString()); 
     sb.append('!'); 
     assertEquals("truefalse!", sb.toString()); 
 }
@Test
public void testAppend_Boolean317() { 
     final StrBuilder sb = new StrBuilder(); 
     sb.append(true); 
     assertEquals("true", sb.toString()); 
     sb.append(false); 
     assertEquals("truefalse", sb.toString()); 
     sb.append('!'); 
     assertEquals("truefalse!", sb.toString()); 
 }
@Test
public void testWriteCharArray318() { 
     StrBuilder sb = new StrBuilder(); 
     sb.append("foo".toCharArray()); 
     assertEquals("foo", sb.toString()); 
     sb.append("bar".toCharArray()); 
     assertEquals("foobar", sb.toString()); 
     sb.append("baz".toCharArray()); 
     assertEquals("foo", sb.toString()); 
     sb.append("baz".toCharArray()); 
     assertEquals("foobar", sb.toString()); 
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
