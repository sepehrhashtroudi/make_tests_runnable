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
public void testGetSetCapacity238() { 
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
}

@Test
public void testConstructors239() { 
     final StrBuilder sb0 = new StrBuilder(); 
     assertEquals(32, sb0.capacity()); 
     assertEquals(0, sb0.length()); 
     assertEquals(0, sb0.size()); 
     final StrBuilder sb1 = new StrBuilder(32); 
     assertEquals(32, sb1.capacity()); 
     assertEquals(0, sb1.length()); 
     assertEquals(0, sb1.size()); 
     final StrBuilder sb2 = new StrBuilder(-1); 
     assertEquals(32, sb2.capacity()); 
     assertEquals(0, sb2.length()); 
     assertEquals(0, sb2.size()); 
     final StrBuilder sb3 = new StrBuilder(-1); 
     assertEquals(32, sb3.capacity()); 
     assertEquals(0, sb3.length()); 
     assertEquals(0, sb3.size()); 
     final StrBuilder sb4 = new StrBuilder(0); 
     assertEquals(32, sb4.capacity()); 
     assertEquals(0, sb4.length()); 
     assertEquals(0, sb4.size()); 
     final StrBuilder sb5 = new StrBuilder((String) null); 
     assertEquals(32, sb5.capacity()); 
     assertEquals(0, sb5.length()); 
     assertEquals(0, sb5.size()); 
     final StrBuilder sb6 = new StrBuilder(""); 
     assertEquals(32, sb6.capacity()); 
     assertEquals(0, sb6.length()); 
     assertEquals(0, sb6.size()); 
     final StrBuilder sb7 = new StrBuilder("foo"); 
     assertEquals(35, sb7.capacity()); 
     assertEquals(3, sb7.length()); 
     assertEquals(3, sb7.size()); 
 }
@Test
public void testAppend_String240() { 
     StrBuilder sb = new StrBuilder(); 
     sb.append("foo"); 
     assertEquals("foo", sb.toString()); 
     sb.append((String) null); 
     assertEquals("foo", sb.toString()); 
     sb.append(""); 
     assertEquals("foo", sb.toString()); 
     sb.append("bar"); 
     assertEquals("foobar", sb.toString()); 
 }
@Test
public void testCapacityAndLength241() { 
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
}

@Test
public void testDeleteCharAt243() { 
     StrBuilder sb = new StrBuilder("abc"); 
     sb.deleteCharAt(0); 
     assertEquals("bc", sb.toString()); 
     sb.deleteCharAt(1); 
     assertEquals("b", sb.toString()); 
     sb.deleteCharAt(2); 
     assertEquals("", sb.toString()); 
     sb.deleteCharAt(0); 
     assertEquals("", sb.toString()); 
     try { 
         sb.deleteCharAt(-1); 
         fail("Expected IndexOutOfBoundsException"); 
     } catch (final IndexOutOfBoundsException e) { 
     } 
     try { 
         sb.deleteCharAt(2); 
         fail("Expected IndexOutOfBoundsException"); 
     } catch (final IndexOutOfBoundsException e) { 
     } 
 }
@Test
public void testDeleteCharAt244() { 
     StrBuilder sb = new StrBuilder("abc"); 
     sb.deleteCharAt(0); 
     assertEquals("bc", sb.toString()); 
     sb.deleteCharAt(1); 
     assertEquals("b", sb.toString()); 
     sb.deleteCharAt(2); 
     assertEquals("", sb.toString()); 
     sb.deleteCharAt(3); 
     assertEquals("", sb.toString()); 
     try { 
         sb.deleteCharAt(-1); 
         fail("Expected IndexOutOfBoundsException"); 
     } catch (final IndexOutOfBoundsException e) { 
     } 
     try { 
         sb.deleteCharAt(2); 
         fail("Expected IndexOutOfBoundsException"); 
     } catch (final IndexOutOfBoundsException e) { 
     } 
     sb = new StrBuilder("anything"); 
     try { 
         sb.deleteCharAt(0); 
         fail("Expected IndexOutOfBoundsException"); 
     } catch (final IndexOutOfBoundsException e) { 
     } 
 }
@Test
public void testDeleteCharAt245() { 
     StrBuilder sb = new StrBuilder("abc"); 
     sb.deleteCharAt(0); 
     assertEquals("bc", sb.toString()); 
     sb.deleteCharAt(1); 
     assertEquals("b", sb.toString()); 
     sb.deleteCharAt(2); 
     assertEquals("", sb.toString()); 
     sb.deleteCharAt(3); 
     assertEquals("", sb.toString()); 
     try { 
         sb.deleteCharAt(-1); 
         fail("Expected IndexOutOfBoundsException"); 
     } catch (final IndexOutOfBoundsException e) { 
     } 
     try { 
         sb.deleteCharAt(2); 
         fail("Expected IndexOutOfBoundsException"); 
     } catch (final IndexOutOfBoundsException e) { 
     } 
 }
@Test
public void testToCharArray246() { 
     final StrBuilder sb = new StrBuilder(); 
     assertEquals(ArrayUtils.EMPTY_CHAR_ARRAY, sb.toCharArray()); 
     char[] a = sb.toCharArray(0, 5); 
     assertNotNull("toCharArray() result is null", a); 
     assertEquals("toCharArray() result is too large", 0, a.length); 
     sb.append("junit"); 
     a = sb.toCharArray(0, 5); 
     assertEquals("toCharArray() result incorrect length", 5, a.length); 
     assertTrue("toCharArray() result does not match", Arrays.equals("junit".toCharArray(), a)); 
 }
@Test
public void testToCharArrayIntInt247() { 
     final StrBuilder sb = new StrBuilder(); 
     assertEquals(ArrayUtils.EMPTY_CHAR_ARRAY, sb.toCharArray(0, 1)); 
     assertEquals(ArrayUtils.EMPTY_CHAR_ARRAY, sb.toCharArray(1, 2)); 
     assertEquals(ArrayUtils.EMPTY_CHAR_ARRAY, sb.toCharArray(0, 3)); 
     assertEquals(ArrayUtils.EMPTY_CHAR_ARRAY, sb.toCharArray(1, 4)); 
     assertEquals(ArrayUtils.EMPTY_CHAR_ARRAY, sb.toCharArray(0, 5)); 
     assertTrue(Arrays.equals(new char[] { 'a', 'b', 'c' }, sb.toCharArray(0, 6))); 
     assertTrue(Arrays.equals(new char[] { 'a', 'b', 'c' }, sb.toCharArray(6, 13))); 
 }
@Test
public void testToCharArrayIntInt248() { 
     final StrBuilder sb = new StrBuilder(); 
     assertEquals(ArrayUtils.EMPTY_CHAR_ARRAY, sb.toCharArray(0, 2)); 
     assertEquals(ArrayUtils.EMPTY_CHAR_ARRAY, sb.toCharArray(1, 2)); 
     assertEquals(ArrayUtils.EMPTY_CHAR_ARRAY, sb.toCharArray(0, -1)); 
     assertEquals(ArrayUtils.EMPTY_CHAR_ARRAY, sb.toCharArray(0, 20)); 
     assertEquals(ArrayUtils.EMPTY_CHAR_ARRAY, sb.toCharArray(4, 2)); 
     assertTrue(Arrays.equals(new char[] { 'f', 'o', 'o' }, sb.toCharArray(0, 4))); 
     assertTrue(Arrays.equals(new char[] { 'o', 'o', 'o' }, sb.toCharArray(2, 2))); 
     assertTrue(Arrays.equals(new char[] { 'b', 'a', 'r' }, sb.toCharArray(4, 2))); 
     assertEquals("abcd", sb.toCharArray(6, 10)); 
 }
@Test
public void testDeleteIntInt266() { 
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
public void testDeleteAll_String267() { 
     StrBuilder sb = new StrBuilder("abcbccba"); 
     sb.deleteAll((String) null); 
     assertEquals("abcbccba", sb.toString()); 
     sb.deleteAll(""); 
     assertEquals("bcbccb", sb.toString()); 
     sb.deleteAll(""); 
     assertEquals("", sb.toString()); 
     sb = new StrBuilder(""); 
     sb.deleteAll(""); 
     assertEquals("", sb.toString()); 
 }
@Test
public void testReplaceFirst_StrMatcher_String268() { 
     StrBuilder sb = new StrBuilder("abcbccba"); 
     sb.replaceFirst((StrMatcher) null, null); 
     assertEquals("abcbccba", sb.toString()); 
     sb.replaceFirst((StrMatcher) null, "anything"); 
     assertEquals("abcbccba", sb.toString()); 
     sb.replaceFirst(StrMatcher.noneMatcher(), null); 
     assertEquals("abcbccba", sb.toString()); 
     sb.replaceFirst(StrMatcher.noneMatcher(), "anything"); 
     assertEquals("abcbccba", sb.toString()); 
     sb.replaceFirst(StrMatcher.charMatcher('x'), "y"); 
     assertEquals("abcbccba", sb.toString()); 
     sb.replaceFirst(StrMatcher.charMatcher('a'), "d"); 
     assertEquals("dbcbccba", sb.toString()); 
     sb.replaceFirst(StrMatcher.charMatcher('d'), null); 
     assertEquals("bcbccba", sb.toString()); 
     sb.replaceFirst(StrMatcher.stringMatcher("cb"), "-"); 
     assertEquals("b-ccba", sb.toString()); 
     sb = new StrBuilder("abcba"); 
     sb.replaceFirst(StrMatcher.charMatcher('b'), "xbx"); 
     assertEquals("axbxcba", sb.toString()); 
     sb = new StrBuilder("bb"); 
     sb.replaceFirst(StrMatcher.charMatcher('b'), "xbx"); 
     assertEquals("xbxb", sb.toString()); 
     sb = new StrBuilder("A1-A2A3-A4"); 
     sb.replaceFirst(A_NUMBER_MATCHER, "***"); 
     assertEquals("***-A2A3-A4", sb.toString()); 
 }
@Test
public void testReplaceAll_String_String269() { 
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
public void testReplaceFirst_char_char272() { 
     StrBuilder sb = new StrBuilder("abcbccba"); 
     sb.replaceFirst((char) 0, 'X'); 
     assertEquals("abcbccba", sb.toString()); 
     sb.replaceFirst((char) 0, 'a'); 
     assertEquals("abcbccba", sb.toString()); 
     sb.replaceFirst('x', 'a'); 
     assertEquals("abcbccba", sb.toString()); 
     sb.replaceFirst('a', 'b'); 
     assertEquals("abcbccba", sb.toString()); 
     sb.replaceFirst('b', 'c'); 
     assertEquals("abcbccba", sb.toString()); 
     sb.replaceFirst('c', 'd'); 
     assertEquals("dbcbccba", sb.toString()); 
     sb.replaceFirst('d', 'e'); 
     assertEquals("bcbccba", sb.toString()); 
     sb.replaceFirst('b', 'f'); 
     assertEquals("b-ccba", sb.toString()); 
     sb = new StrBuilder("abcba"); 
     sb.replaceFirst('b', 'b'); 
     assertEquals("axbxcba", sb.toString()); 
     sb = new StrBuilder("bb"); 
     sb.replaceFirst('b', 'b'); 
     assertEquals("xbxb", sb.toString()); 
 }
@Test
public void testTrim273() { 
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
public void testEndsWith274() { 
     final StrBuilder sb = new StrBuilder(); 
     assertFalse(sb.endsWith("a")); 
     assertFalse(sb.endsWith(null)); 
     assertTrue(sb.endsWith("")); 
     sb.append("abc"); 
     assertTrue(sb.endsWith("a")); 
     assertTrue(sb.endsWith("ab")); 
     assertTrue(sb.endsWith("abc")); 
     assertFalse(sb.endsWith("cba")); 
 }
@Test
public void testEndsWith275() { 
     final StrBuilder sb = new StrBuilder(); 
     assertFalse("endsWith(null) failed", sb.endsWith(null)); 
     assertTrue("endsWith('') failed", sb.endsWith("")); 
     assertTrue("endsWith(String) failed", sb.endsWith("12345")); 
     assertFalse("endsWith(String) neg 1 failed", sb.endsWith("1234.5")); 
     assertFalse("endsWith(String) neg 3 failed", sb.endsWith("1ab")); 
     assertFalse("endsWith(String) neg 4 failed", sb.endsWith("abc")); 
 }
@Test
public void testLastIndexOf_char276() { 
     final StrBuilder sb = new StrBuilder("abab"); 
     assertEquals(-1, sb.lastIndexOf('a')); 
     assertEquals("abab".lastIndexOf('a'), sb.lastIndexOf('a')); 
     assertEquals(3, sb.lastIndexOf('b')); 
     assertEquals("abab".lastIndexOf('b'), sb.lastIndexOf('b')); 
     assertEquals(-1, sb.lastIndexOf('z')); 
 }
@Test
public void testEquals278() { 
     final StrBuilder sb1 = new StrBuilder(); 
     final StrBuilder sb2 = new StrBuilder(); 
     assertTrue(sb1.equals(sb1)); 
     assertTrue(sb1.equals(sb2)); 
     assertTrue(sb2.equals(sb2)); 
     sb1.append("abc"); 
     assertFalse(sb1.equals(sb2)); 
     sb2.append("ABC"); 
     assertTrue(sb1.equals(sb2)); 
     sb2.clear().append("abc"); 
     assertTrue(sb1.equals(sb2)); 
     assertTrue(sb1.equals(sb1)); 
     assertTrue(sb2.equals(sb2)); 
     sb2.clear().append("aBc"); 
     assertTrue(sb1.equals(sb2)); 
 }
@Test
public void testHashCode279() { 
     final StrBuilder sb1 = new StrBuilder(); 
     final StrBuilder sb2 = new StrBuilder(); 
     assertTrue(sb1.hashCode() == sb2.hashCode()); 
     sb1.append("foo"); 
     assertTrue(sb1.hashCode() == sb2.hashCode()); 
     sb2.append("123456789012345678901234567890123"); 
     assertFalse(sb1.hashCode() == sb2.hashCode()); 
 }
@Test
public void testHashCode280() { 
     final StrBuilder sb1 = new StrBuilder(); 
     final StrBuilder sb2 = new StrBuilder(); 
     assertTrue(sb1.hashCode() == sb2.hashCode()); 
     sb1.append("junit"); 
     assertFalse(sb1.hashCode() == sb2.hashCode()); 
     sb2.append("junit"); 
     assertTrue(sb1.hashCode() != sb2.hashCode()); 
 }
@Test
public void testToString281() { 
     final StrBuilder sb = new StrBuilder(); 
     assertEquals("", sb.toString()); 
     sb.append("junit"); 
     assertEquals("junit", sb.toString()); 
 }
@Test
public void testAsWriter282() throws Exception { 
     final StrBuilder sb = new StrBuilder("base"); 
     final Writer writer = sb.asWriter(); 
     writer.write('l'); 
     assertEquals("basel", sb.toString()); 
     writer.write(new char[] { 'i', 'n' }); 
     assertEquals("baselin", sb.toString()); 
     writer.write(new char[] { 'n', 'e', 'r' }, 1, 2); 
     assertEquals("baseliner", sb.toString()); 
     writer.write(" rout"); 
     assertEquals("baseliner rout", sb.toString()); 
     writer.write("ping that server", 1, 3); 
     assertEquals("baseliner routing", sb.toString()); 
     writer.flush(); 
     assertEquals("baseliner routing", sb.toString()); 
     writer.close(); 
     assertEquals("baseliner routing", sb.toString()); 
     writer.write(" hi"); 
     assertEquals("baseliner routing hi", sb.toString()); 
     sb.setLength(4); 
     writer.write('d'); 
     assertEquals("based", sb.toString()); 
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
