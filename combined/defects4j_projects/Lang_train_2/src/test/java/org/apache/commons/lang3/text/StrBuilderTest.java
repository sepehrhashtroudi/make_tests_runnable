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
public void testReplaceFirst_StrMatcher_String334() { 
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
public void testConstructors625() { 
     final StrBuilder sb0 = new StrBuilder(); 
     assertEquals(32, sb0.capacity()); 
     assertEquals(0, sb0.length()); 
     assertEquals(0, sb0.size()); 
     final StrBuilder sb1 = new StrBuilder(32); 
     assertEquals(32, sb1.capacity()); 
     assertEquals(0, sb1.length()); 
     assertEquals(0, sb1.size()); 
     final StrBuilder sb2 = new StrBuilder(0); 
     assertEquals(32, sb2.capacity()); 
     assertEquals(0, sb2.length()); 
     assertEquals(0, sb2.size()); 
     final StrBuilder sb3 = new StrBuilder(-1); 
     assertEquals(32, sb3.capacity()); 
     assertEquals(0, sb3.length()); 
     assertEquals(0, sb3.size()); 
     final StrBuilder sb4 = new StrBuilder(1); 
     assertEquals(1, sb4.capacity()); 
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
public void testGetSetNewLineText626() { 
     final StrBuilder sb = new StrBuilder(); 
     assertEquals(null, sb.getNewLineText()); 
     sb.setNewLineText("#"); 
     assertEquals("#", sb.getNewLineText()); 
     sb.setNewLineText(""); 
     assertEquals("", sb.getNewLineText()); 
     sb.setNewLineText((String) null); 
     assertEquals(null, sb.getNewLineText()); 
 }
@Test
public void testGetSetNullText629() { 
     final StrBuilder sb = new StrBuilder(); 
     assertEquals(null, sb.getNullText()); 
     sb.setNullText("null"); 
     assertEquals("null", sb.getNullText()); 
     sb.setNullText(""); 
     assertEquals(null, sb.getNullText()); 
     sb.setNullText("NULL"); 
     assertEquals("NULL", sb.getNullText()); 
     sb.setNullText((String) null); 
     assertEquals(null, sb.getNullText()); 
 }
@Test
public void testCapacityAndLength630() { 
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
     assertEquals(33, sb.size()); 
     assertTrue(sb.isEmpty() == false); 
     try { 
         sb.setLength(-1); 
         fail("setLength(-1) expected StringIndexOutOfBoundsException"); 
     } catch (final IndexOutOfBoundsException e) { 
     } 
     sb.setLength(33); 
     assertEquals(33, sb.capacity()); 
     assertEquals(33, sb.length()); 
     assertEquals(33, sb.size()); 
     assertTrue(sb.isEmpty() == false); 
     sb.setLength(16); 
     assertTrue(sb.capacity() >= 16); 
     assertEquals(16, sb.length()); 
     assertEquals(16, sb.size()); 
     assertEquals("1234567890123456", sb.toString()); 
     assertTrue(sb.isEmpty() == false); 
     sb.setLength(32); 
     assertTrue(sb.capacity() >= 32); 
     assertEquals(32, sb.length()); 
     assertEquals(32, sb.size()); 
     assertEquals("1234567890123456\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0", sb.toString()); 
     assertTrue(sb.isEmpty() == false); 
     sb.setLength(0); 
     assertTrue(sb.capacity() >= 32); 
     assertEquals(0, sb.length()); 
     assertEquals(0, sb.size()); 
     assertTrue(sb.isEmpty()); 
 }
@Test
public void testIsEmpty631() { 
     final StrBuilder sb = new StrBuilder(); 
     assertTrue(sb.isEmpty()); 
     sb.append("Hello"); 
     assertFalse(sb.isEmpty()); 
     sb.clear(); 
     assertTrue(sb.isEmpty()); 
 }
@Test
public void testAsReader632() throws Exception { 
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
     } catch (final IndexOutOfBoundsException ex) { 
     } 
     try { 
         reader.read(array, 100, 1); 
         fail(); 
     } catch (final IndexOutOfBoundsException ex) { 
     } 
     try { 
         reader.read(array, 0, 100); 
         fail(); 
     } catch (final IndexOutOfBoundsException ex) { 
     } 
     try { 
         reader.read(array, Integer.MAX_VALUE, Integer.MAX_VALUE); 
         fail(); 
     } catch (final IndexOutOfBoundsException ex) { 
     } 
     assertEquals(0, reader.read(array, 0, 0)); 
     assertEquals(0, array[0]); 
     assertEquals(0, array[1]); 
     assertEquals(0, array[2]); 
     reader.skip(9); 
     assertEquals(-1, reader.read(array, 0, 1)); 
     reader.reset(); 
     array = new char[30]; 
     assertEquals(9, reader.read(array, 0, 30)); 
 }
@Test
public void testChaining633() { 
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
public void testSetCharAt634() { 
     final StrBuilder sb = new StrBuilder(); 
     try { 
         sb.setCharAt(0, 'f'); 
         fail("setCharAt(0,) expected IndexOutOfBoundsException"); 
     } catch (final IndexOutOfBoundsException e) { 
     } 
     try { 
         sb.setCharAt(-1, 'f'); 
         fail("setCharAt(-1,) expected IndexOutOfBoundsException"); 
     } catch (final IndexOutOfBoundsException e) { 
     } 
     sb.append("foo"); 
     sb.setCharAt(0, 'b'); 
     sb.setCharAt(1, 'a'); 
     sb.setCharAt(2, 'r'); 
     try { 
         sb.setCharAt(3, '!'); 
         fail("setCharAt(3,) expected IndexOutOfBoundsException"); 
     } catch (final IndexOutOfBoundsException e) { 
     } 
     assertEquals("bar", sb.toString()); 
 }
@Test
public void testToCharArray635() { 
     final StrBuilder sb = new StrBuilder(); 
     assertEquals(ArrayUtils.EMPTY_CHAR_ARRAY, sb.toCharArray()); 
     char[] a = sb.toCharArray(); 
     assertNotNull("toCharArray() result is null", a); 
     assertEquals("toCharArray() result is too large", 0, a.length); 
     sb.append("junit"); 
     a = sb.toCharArray(); 
     assertEquals("toCharArray() result incorrect length", 5, a.length); 
     assertTrue("toCharArray() result does not match", Arrays.equals("junit".toCharArray(), a)); 
 }
@Test
public void testGetChars636() { 
     final StrBuilder sb = new StrBuilder(); 
     char[] input = new char[10]; 
     char[] a = sb.getChars(input); 
     assertSame(input, a); 
     assertTrue(Arrays.equals(new char[10], a)); 
     sb.append("junit"); 
     a = sb.getChars(input); 
     assertSame(input, a); 
     assertTrue(Arrays.equals(new char[] { 'j', 'u', 'n', 'i', 't', 0, 0, 0, 0, 0 }, a)); 
     a = sb.getChars(null); 
     assertNotSame(input, a); 
     assertEquals(5, a.length); 
     assertTrue(Arrays.equals("junit".toCharArray(), a)); 
     input = new char[5]; 
     a = sb.getChars(input); 
     assertSame(input, a); 
     input = new char[4]; 
     a = sb.getChars(input); 
     assertNotSame(input, a); 
 }
@Test
public void testGetCharsIntIntCharArrayInt638() { 
     final StrBuilder sb = new StrBuilder(); 
     sb.append("junit"); 
     char[] a = new char[5]; 
     sb.getChars(0, 5, a, 0); 
     assertTrue(Arrays.equals(new char[] { 'j', 'u', 'n', 'i', 't' }, a)); 
     a = new char[5]; 
     sb.getChars(0, 2, a, 3); 
     assertTrue(Arrays.equals(new char[] { 0, 0, 0, 'j', 'u' }, a)); 
     try { 
         sb.getChars(-1, 0, a, 0); 
         fail("no exception"); 
     } catch (final IndexOutOfBoundsException e) { 
     } 
     try { 
         sb.getChars(0, -1, a, 0); 
         fail("no exception"); 
     } catch (final IndexOutOfBoundsException e) { 
     } 
     try { 
         sb.getChars(0, 20, a, 0); 
         fail("no exception"); 
     } catch (final IndexOutOfBoundsException e) { 
     } 
     try { 
         sb.getChars(4, 2, a, 0); 
         fail("no exception"); 
     } catch (final IndexOutOfBoundsException e) { 
     } 
 }
@Test
public void testAsWriter649() throws Exception { 
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
@Test
public void testAsBuilder659() { 
     final StrBuilder sb = new StrBuilder().appendAll("Lorem", " ", "ipsum", " ", "dolor"); 
     assertEquals(sb.toString(), sb.build()); 
 }
@Test
public void testLang412Left670() { 
     final StrBuilder sb = new StrBuilder(); 
     sb.appendFixedWidthPadLeft(null, 10, '*'); 
     assertEquals("Failed to invoke appendFixedWidthPadLeft correctly", "**********", sb.toString()); 
 }
@Test
public void testLang412Right672() { 
     final StrBuilder sb = new StrBuilder(); 
     sb.appendFixedWidthPadRight(null, 10, '*'); 
     assertEquals("Failed to invoke appendFixedWidthPadRight correctly", "**********", sb.toString()); 
 }
@Test
public void testDeleteIntInt677() { 
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
public void testDeleteAll_char678() { 
     StrBuilder sb = new StrBuilder("abcbccba"); 
     sb.deleteAll('X'); 
     assertEquals("abcbccba", sb.toString()); 
     sb.deleteAll('a'); 
     assertEquals("bcbccb", sb.toString()); 
     sb.deleteAll('c'); 
     assertEquals("bbb", sb.toString()); 
     sb.deleteAll('b'); 
     assertEquals("", sb.toString()); 
     sb = new StrBuilder(""); 
     sb.deleteAll('b'); 
     assertEquals("", sb.toString()); 
 }
@Test
public void testDeleteFirst_char679() { 
     StrBuilder sb = new StrBuilder("abcba"); 
     sb.deleteFirst('X'); 
     assertEquals("abcba", sb.toString()); 
     sb.deleteFirst('a'); 
     assertEquals("bcba", sb.toString()); 
     sb.deleteFirst('c'); 
     assertEquals("bba", sb.toString()); 
     sb.deleteFirst('b'); 
     assertEquals("ba", sb.toString()); 
     sb = new StrBuilder(""); 
     sb.deleteFirst('b'); 
     assertEquals("", sb.toString()); 
 }
@Test
public void testIndexOfLang294680() { 
     final StrBuilder sb = new StrBuilder("onetwothree"); 
     sb.deleteFirst("three"); 
     assertEquals(-1, sb.indexOf("three")); 
 }
@Test
public void testDeleteAll_StrMatcher681() { 
     StrBuilder sb = new StrBuilder("A0xA1A2yA3"); 
     sb.deleteAll((StrMatcher) null); 
     assertEquals("A0xA1A2yA3", sb.toString()); 
     sb.deleteAll(A_NUMBER_MATCHER); 
     assertEquals("xy", sb.toString()); 
     sb = new StrBuilder("Ax1"); 
     sb.deleteAll(A_NUMBER_MATCHER); 
     assertEquals("Ax1", sb.toString()); 
     sb = new StrBuilder(""); 
     sb.deleteAll(A_NUMBER_MATCHER); 
     assertEquals("", sb.toString()); 
 }
@Test
public void testDeleteFirst_StrMatcher682() { 
     StrBuilder sb = new StrBuilder("A0xA1A2yA3"); 
     sb.deleteFirst((StrMatcher) null); 
     assertEquals("A0xA1A2yA3", sb.toString()); 
     sb.deleteFirst(A_NUMBER_MATCHER); 
     assertEquals("xA1A2yA3", sb.toString()); 
     sb = new StrBuilder("Ax1"); 
     sb.deleteFirst(A_NUMBER_MATCHER); 
     assertEquals("Ax1", sb.toString()); 
     sb = new StrBuilder(""); 
     sb.deleteFirst(A_NUMBER_MATCHER); 
     assertEquals("", sb.toString()); 
 }
@Test
public void testReplaceAll_String_String683() { 
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
public void testReplaceFirst_String_String684() { 
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
public void testReplaceAll_StrMatcher_String685() { 
     StrBuilder sb = new StrBuilder("abcbccba"); 
     sb.replaceAll((StrMatcher) null, null); 
     assertEquals("abcbccba", sb.toString()); 
     sb.replaceAll((StrMatcher) null, "anything"); 
     assertEquals("abcbccba", sb.toString()); 
     sb.replaceAll(StrMatcher.noneMatcher(), null); 
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
     sb = new StrBuilder("A1-A2A3-A4"); 
     sb.replaceAll(A_NUMBER_MATCHER, "***"); 
     assertEquals("***-******-***", sb.toString()); 
 }
@Test
public void testTrim686() { 
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
public void testStartsWith687() { 
     final StrBuilder sb = new StrBuilder(); 
     assertFalse(sb.startsWith("a")); 
     assertFalse(sb.startsWith(null)); 
     assertTrue(sb.startsWith("")); 
     sb.append("abc"); 
     assertTrue(sb.startsWith("a")); 
     assertTrue(sb.startsWith("ab")); 
     assertTrue(sb.startsWith("abc")); 
     assertFalse(sb.startsWith("cba")); 
 }
@Test
public void testSubSequenceIntInt688() { 
     final StrBuilder sb = new StrBuilder("hello goodbye"); 
     try { 
         sb.subSequence(-1, 5); 
         fail(); 
     } catch (final IndexOutOfBoundsException e) { 
     } 
     try { 
         sb.subSequence(2, -1); 
         fail(); 
     } catch (final IndexOutOfBoundsException e) { 
     } 
     try { 
         sb.subSequence(2, sb.length() + 1); 
         fail(); 
     } catch (final IndexOutOfBoundsException e) { 
     } 
     try { 
         sb.subSequence(3, 2); 
         fail(); 
     } catch (final IndexOutOfBoundsException e) { 
     } 
     assertEquals("hello", sb.subSequence(0, 5)); 
     assertEquals("hello goodbye".subSequence(0, 6), sb.subSequence(0, 6)); 
     assertEquals("goodbye", sb.subSequence(6, 13)); 
     assertEquals("hello goodbye".subSequence(6, 13), sb.subSequence(6, 13)); 
 }
@Test
public void testSubstringInt689() { 
     final StrBuilder sb = new StrBuilder("hello goodbye"); 
     assertEquals("goodbye", sb.substring(6)); 
     assertEquals("hello goodbye".substring(6), sb.substring(6)); 
     assertEquals("hello goodbye", sb.substring(0)); 
     assertEquals("hello goodbye".substring(0), sb.substring(0)); 
     try { 
         sb.substring(-1); 
         fail(); 
     } catch (final IndexOutOfBoundsException e) { 
     } 
     try { 
         sb.substring(15); 
         fail(); 
     } catch (final IndexOutOfBoundsException e) { 
     } 
 }
@Test
public void testSubstringIntInt690() { 
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
public void testLeftString691() { 
     final StrBuilder sb = new StrBuilder("left right"); 
     assertEquals("left", sb.leftString(4)); 
     assertEquals("", sb.leftString(0)); 
     assertEquals("", sb.leftString(-5)); 
     assertEquals("left right", sb.leftString(15)); 
 }
@Test
public void testRightString692() { 
     final StrBuilder sb = new StrBuilder("left right"); 
     assertEquals("right", sb.rightString(5)); 
     assertEquals("", sb.rightString(0)); 
     assertEquals("", sb.rightString(-5)); 
     assertEquals("left right", sb.rightString(15)); 
 }
@Test
public void testMidString693() { 
     final StrBuilder sb = new StrBuilder("hello goodbye hello"); 
     assertEquals("goodbye", sb.midString(6, 7)); 
     assertEquals("hello", sb.midString(0, 5)); 
     assertEquals("hello", sb.midString(-5, 5)); 
     assertEquals("", sb.midString(0, -1)); 
     assertEquals("", sb.midString(20, 2)); 
     assertEquals("hello", sb.midString(14, 22)); 
 }
@Test
public void testLang295694() { 
     final StrBuilder sb = new StrBuilder("onetwothree"); 
     sb.deleteFirst("three"); 
     assertFalse("The contains(char) method is looking beyond the end of the string", sb.contains('h')); 
     assertEquals("The indexOf(char) method is looking beyond the end of the string", -1, sb.indexOf('h')); 
 }
@Test
public void testContains_char695() { 
     final StrBuilder sb = new StrBuilder("abcdefghijklmnopqrstuvwxyz"); 
     assertTrue(sb.contains('a')); 
     assertTrue(sb.contains('o')); 
     assertTrue(sb.contains('z')); 
     assertFalse(sb.contains('1')); 
 }
@Test
public void testContains_String696() { 
     final StrBuilder sb = new StrBuilder("abcdefghijklmnopqrstuvwxyz"); 
     assertTrue(sb.contains("a")); 
     assertTrue(sb.contains("pq")); 
     assertTrue(sb.contains("z")); 
     assertFalse(sb.contains("zyx")); 
     assertFalse(sb.contains((String) null)); 
 }
@Test
public void testContains_StrMatcher697() { 
     StrBuilder sb = new StrBuilder("abcdefghijklmnopqrstuvwxyz"); 
     assertTrue(sb.contains(StrMatcher.charMatcher('a'))); 
     assertTrue(sb.contains(StrMatcher.stringMatcher("pq"))); 
     assertTrue(sb.contains(StrMatcher.charMatcher('z'))); 
     assertFalse(sb.contains(StrMatcher.stringMatcher("zy"))); 
     assertFalse(sb.contains((StrMatcher) null)); 
     sb = new StrBuilder(); 
     assertFalse(sb.contains(A_NUMBER_MATCHER)); 
     sb.append("B A1 C"); 
     assertTrue(sb.contains(A_NUMBER_MATCHER)); 
 }
@Test
public void testIndexOf_char698() { 
     final StrBuilder sb = new StrBuilder("abab"); 
     assertEquals(0, sb.indexOf('a')); 
     assertEquals("abab".indexOf('a'), sb.indexOf('a')); 
     assertEquals(1, sb.indexOf('b')); 
     assertEquals("abab".indexOf('b'), sb.indexOf('b')); 
     assertEquals(-1, sb.indexOf('z')); 
 }
@Test
public void testIndexOf_char_int699() { 
     StrBuilder sb = new StrBuilder("abab"); 
     assertEquals(0, sb.indexOf('a', -1)); 
     assertEquals(0, sb.indexOf('a', 0)); 
     assertEquals(2, sb.indexOf('a', 1)); 
     assertEquals(-1, sb.indexOf('a', 4)); 
     assertEquals(-1, sb.indexOf('a', 5)); 
     assertEquals("abab".indexOf('a', 1), sb.indexOf('a', 1)); 
     assertEquals(3, sb.indexOf('b', 2)); 
     assertEquals("abab".indexOf('b', 2), sb.indexOf('b', 2)); 
     assertEquals(-1, sb.indexOf('z', 2)); 
     sb = new StrBuilder("xyzabc"); 
     assertEquals(2, sb.indexOf('z', 0)); 
     assertEquals(-1, sb.indexOf('z', 3)); 
 }
@Test
public void testIndexOf_String_int700() { 
     StrBuilder sb = new StrBuilder("abab"); 
     assertEquals(0, sb.indexOf("a", -1)); 
     assertEquals(0, sb.indexOf("a", 0)); 
     assertEquals(2, sb.indexOf("a", 1)); 
     assertEquals(2, sb.indexOf("a", 2)); 
     assertEquals(-1, sb.indexOf("a", 3)); 
     assertEquals(-1, sb.indexOf("a", 4)); 
     assertEquals(-1, sb.indexOf("a", 5)); 
     assertEquals(-1, sb.indexOf("abcdef", 0)); 
     assertEquals(0, sb.indexOf("", 0)); 
     assertEquals(1, sb.indexOf("", 1)); 
     assertEquals("abab".indexOf("a", 1), sb.indexOf("a", 1)); 
     assertEquals(2, sb.indexOf("ab", 1)); 
     assertEquals("abab".indexOf("ab", 1), sb.indexOf("ab", 1)); 
     assertEquals(3, sb.indexOf("b", 2)); 
     assertEquals("abab".indexOf("b", 2), sb.indexOf("b", 2)); 
     assertEquals(1, sb.indexOf("ba", 1)); 
     assertEquals("abab".indexOf("ba", 2), sb.indexOf("ba", 2)); 
     assertEquals(-1, sb.indexOf("z", 2)); 
     sb = new StrBuilder("xyzabc"); 
     assertEquals(2, sb.indexOf("za", 0)); 
     assertEquals(-1, sb.indexOf("za", 3)); 
     assertEquals(-1, sb.indexOf((String) null, 2)); 
 }
@Test
public void testIndexOf_StrMatcher701() { 
     final StrBuilder sb = new StrBuilder(); 
     assertEquals(-1, sb.indexOf((StrMatcher) null)); 
     assertEquals(-1, sb.indexOf(StrMatcher.charMatcher('a'))); 
     sb.append("ab bd"); 
     assertEquals(0, sb.indexOf(StrMatcher.charMatcher('a'))); 
     assertEquals(1, sb.indexOf(StrMatcher.charMatcher('b'))); 
     assertEquals(2, sb.indexOf(StrMatcher.spaceMatcher())); 
     assertEquals(4, sb.indexOf(StrMatcher.charMatcher('d'))); 
     assertEquals(-1, sb.indexOf(StrMatcher.noneMatcher())); 
     assertEquals(-1, sb.indexOf((StrMatcher) null)); 
     sb.append(" A1 junction"); 
     assertEquals(6, sb.indexOf(A_NUMBER_MATCHER)); 
 }
@Test
public void testIndexOf_StrMatcher_int702() { 
     final StrBuilder sb = new StrBuilder(); 
     assertEquals(-1, sb.indexOf((StrMatcher) null, 2)); 
     assertEquals(-1, sb.indexOf(StrMatcher.charMatcher('a'), 2)); 
     assertEquals(-1, sb.indexOf(StrMatcher.charMatcher('a'), 0)); 
     sb.append("ab bd"); 
     assertEquals(0, sb.indexOf(StrMatcher.charMatcher('a'), -2)); 
     assertEquals(0, sb.indexOf(StrMatcher.charMatcher('a'), 0)); 
     assertEquals(-1, sb.indexOf(StrMatcher.charMatcher('a'), 2)); 
     assertEquals(-1, sb.indexOf(StrMatcher.charMatcher('a'), 20)); 
     assertEquals(1, sb.indexOf(StrMatcher.charMatcher('b'), -1)); 
     assertEquals(1, sb.indexOf(StrMatcher.charMatcher('b'), 0)); 
     assertEquals(1, sb.indexOf(StrMatcher.charMatcher('b'), 1)); 
     assertEquals(3, sb.indexOf(StrMatcher.charMatcher('b'), 2)); 
     assertEquals(3, sb.indexOf(StrMatcher.charMatcher('b'), 3)); 
     assertEquals(-1, sb.indexOf(StrMatcher.charMatcher('b'), 4)); 
     assertEquals(-1, sb.indexOf(StrMatcher.charMatcher('b'), 5)); 
     assertEquals(-1, sb.indexOf(StrMatcher.charMatcher('b'), 6)); 
     assertEquals(2, sb.indexOf(StrMatcher.spaceMatcher(), -2)); 
     assertEquals(2, sb.indexOf(StrMatcher.spaceMatcher(), 0)); 
     assertEquals(2, sb.indexOf(StrMatcher.spaceMatcher(), 2)); 
     assertEquals(-1, sb.indexOf(StrMatcher.spaceMatcher(), 4)); 
     assertEquals(-1, sb.indexOf(StrMatcher.spaceMatcher(), 20)); 
     assertEquals(-1, sb.indexOf(StrMatcher.noneMatcher(), 0)); 
     assertEquals(-1, sb.indexOf((StrMatcher) null, 0)); 
     sb.append(" A1 junction with A2"); 
     assertEquals(6, sb.indexOf(A_NUMBER_MATCHER, 5)); 
     assertEquals(6, sb.indexOf(A_NUMBER_MATCHER, 6)); 
     assertEquals(23, sb.indexOf(A_NUMBER_MATCHER, 7)); 
     assertEquals(23, sb.indexOf(A_NUMBER_MATCHER, 22)); 
     assertEquals(23, sb.indexOf(A_NUMBER_MATCHER, 23)); 
     assertEquals(-1, sb.indexOf(A_NUMBER_MATCHER, 24)); 
 }
@Test
public void testLastIndexOf_char703() { 
     final StrBuilder sb = new StrBuilder("abab"); 
     assertEquals(2, sb.lastIndexOf('a')); 
     assertEquals("abab".lastIndexOf('a'), sb.lastIndexOf('a')); 
     assertEquals(3, sb.lastIndexOf('b')); 
     assertEquals("abab".lastIndexOf('b'), sb.lastIndexOf('b')); 
     assertEquals(-1, sb.lastIndexOf('z')); 
 }
@Test
public void testLastIndexOf_String704() { 
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
public void testLastIndexOf_String_int705() { 
     StrBuilder sb = new StrBuilder("abab"); 
     assertEquals(-1, sb.lastIndexOf("a", -1)); 
     assertEquals(0, sb.lastIndexOf("a", 0)); 
     assertEquals(0, sb.lastIndexOf("a", 1)); 
     assertEquals(2, sb.lastIndexOf("a", 2)); 
     assertEquals(2, sb.lastIndexOf("a", 3)); 
     assertEquals(2, sb.lastIndexOf("a", 4)); 
     assertEquals(2, sb.lastIndexOf("a", 5)); 
     assertEquals(-1, sb.lastIndexOf("abcdef", 3)); 
     assertEquals("abab".lastIndexOf("", 3), sb.lastIndexOf("", 3)); 
     assertEquals("abab".lastIndexOf("", 1), sb.lastIndexOf("", 1)); 
     assertEquals("abab".lastIndexOf("a", 1), sb.lastIndexOf("a", 1)); 
     assertEquals(0, sb.lastIndexOf("ab", 1)); 
     assertEquals("abab".lastIndexOf("ab", 1), sb.lastIndexOf("ab", 1)); 
     assertEquals(1, sb.lastIndexOf("b", 2)); 
     assertEquals("abab".lastIndexOf("b", 2), sb.lastIndexOf("b", 2)); 
     assertEquals(1, sb.lastIndexOf("ba", 2)); 
     assertEquals("abab".lastIndexOf("ba", 2), sb.lastIndexOf("ba", 2)); 
     assertEquals(-1, sb.lastIndexOf("z", 2)); 
     sb = new StrBuilder("xyzabc"); 
     assertEquals(2, sb.lastIndexOf("za", sb.length())); 
     assertEquals(-1, sb.lastIndexOf("za", 1)); 
     assertEquals(-1, sb.lastIndexOf((String) null, 2)); 
 }
@Test
public void testLastIndexOf_StrMatcher706() { 
     final StrBuilder sb = new StrBuilder(); 
     assertEquals(-1, sb.lastIndexOf((StrMatcher) null)); 
     assertEquals(-1, sb.lastIndexOf(StrMatcher.charMatcher('a'))); 
     sb.append("ab bd"); 
     assertEquals(0, sb.lastIndexOf(StrMatcher.charMatcher('a'))); 
     assertEquals(3, sb.lastIndexOf(StrMatcher.charMatcher('b'))); 
     assertEquals(2, sb.lastIndexOf(StrMatcher.spaceMatcher())); 
     assertEquals(4, sb.lastIndexOf(StrMatcher.charMatcher('d'))); 
     assertEquals(-1, sb.lastIndexOf(StrMatcher.noneMatcher())); 
     assertEquals(-1, sb.lastIndexOf((StrMatcher) null)); 
     sb.append(" A1 junction"); 
     assertEquals(6, sb.lastIndexOf(A_NUMBER_MATCHER)); 
 }
@Test
public void testEqualsIgnoreCase707() { 
     final StrBuilder sb1 = new StrBuilder(); 
     final StrBuilder sb2 = new StrBuilder(); 
     assertTrue(sb1.equalsIgnoreCase(sb1)); 
     assertTrue(sb1.equalsIgnoreCase(sb2)); 
     assertTrue(sb2.equalsIgnoreCase(sb2)); 
     sb1.append("abc"); 
     assertFalse(sb1.equalsIgnoreCase(sb2)); 
     sb2.append("ABC"); 
     assertTrue(sb1.equalsIgnoreCase(sb2)); 
     sb2.clear().append("abc"); 
     assertTrue(sb1.equalsIgnoreCase(sb2)); 
     assertTrue(sb1.equalsIgnoreCase(sb1)); 
     assertTrue(sb2.equalsIgnoreCase(sb2)); 
     sb2.clear().append("aBc"); 
     assertTrue(sb1.equalsIgnoreCase(sb2)); 
 }
@Test
public void testToStringBuffer708() { 
     final StrBuilder sb = new StrBuilder(); 
     assertEquals(new StringBuffer().toString(), sb.toStringBuffer().toString()); 
     sb.append("junit"); 
     assertEquals(new StringBuffer("junit").toString(), sb.toStringBuffer().toString()); 
 }
@Test
public void testToStringBuilder709() { 
     final StrBuilder sb = new StrBuilder(); 
     assertEquals(new StringBuilder().toString(), sb.toStringBuilder().toString()); 
     sb.append("junit"); 
     assertEquals(new StringBuilder("junit").toString(), sb.toStringBuilder().toString()); 
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
