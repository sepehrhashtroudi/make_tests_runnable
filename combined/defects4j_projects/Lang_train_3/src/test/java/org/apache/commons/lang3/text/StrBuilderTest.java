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
public void testReplaceFirst_StrMatcher_String338() { 
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
public void testCapacity621() { 
     final StrBuilder sb = new StrBuilder(); 
     assertEquals(sb.buffer.length, sb.capacity()); 
     sb.append("HelloWorldHelloWorldHelloWorldHelloWorld"); 
     assertEquals(sb.buffer.length, sb.capacity()); 
 }
@Test
public void testReplaceFirst_char_char622() { 
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
public void testIsEmpty625() { 
     final StrBuilder sb = new StrBuilder(); 
     assertTrue(sb.isEmpty()); 
     sb.append("Hello"); 
     assertFalse(sb.isEmpty()); 
     sb.clear(); 
     assertTrue(sb.isEmpty()); 
 }
@Test
public void testAsReader626() throws Exception { 
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
public void testCharAt627() { 
     final StrBuilder sb = new StrBuilder(); 
     try { 
         sb.charAt(0); 
         fail("charAt(0) expected IndexOutOfBoundsException"); 
     } catch (final IndexOutOfBoundsException e) { 
     } 
     try { 
         sb.charAt(-1); 
         fail("charAt(-1) expected IndexOutOfBoundsException"); 
     } catch (final IndexOutOfBoundsException e) { 
     } 
     sb.append("foo"); 
     assertEquals('f', sb.charAt(0)); 
     assertEquals('o', sb.charAt(1)); 
     assertEquals('o', sb.charAt(2)); 
     try { 
         sb.charAt(-1); 
         fail("charAt(-1) expected IndexOutOfBoundsException"); 
     } catch (final IndexOutOfBoundsException e) { 
     } 
     try { 
         sb.charAt(3); 
         fail("charAt(3) expected IndexOutOfBoundsException"); 
     } catch (final IndexOutOfBoundsException e) { 
     } 
 }
@Test
public void testChaining628() { 
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
public void testSetCharAt629() { 
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
public void testDeleteCharAt630() { 
     final StrBuilder sb = new StrBuilder("abc"); 
     sb.deleteCharAt(0); 
     assertEquals("bc", sb.toString()); 
     try { 
         sb.deleteCharAt(1000); 
         fail("Expected IndexOutOfBoundsException"); 
     } catch (final IndexOutOfBoundsException e) { 
     } 
 }
@Test
public void testToCharArray631() { 
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
public void testToCharArrayIntInt632() { 
     final StrBuilder sb = new StrBuilder(); 
     assertEquals(ArrayUtils.EMPTY_CHAR_ARRAY, sb.toCharArray(0, 0)); 
     sb.append("junit"); 
     char[] a = sb.toCharArray(0, 20); 
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
public void testGetChars633() { 
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
public void testAsWriter647() throws Exception { 
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
public void testAsBuilder658() { 
     final StrBuilder sb = new StrBuilder().appendAll("Lorem", " ", "ipsum", " ", "dolor"); 
     assertEquals(sb.toString(), sb.build()); 
 }
@Test
public void testLang412Right668() { 
     final StrBuilder sb = new StrBuilder(); 
     sb.appendFixedWidthPadRight(null, 10, '*'); 
     assertEquals("Failed to invoke appendFixedWidthPadRight correctly", "**********", sb.toString()); 
 }
@Test
public void testLang294672() { 
     final StrBuilder sb = new StrBuilder("\n%BLAH%\nDo more stuff\neven more stuff\n%BLAH%\n"); 
     sb.deleteAll("\n%BLAH%"); 
     assertEquals("\nDo more stuff\neven more stuff\n", sb.toString()); 
 }
@Test
public void testDeleteFirst_char673() { 
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
public void testDeleteAll_StrMatcher674() { 
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
public void testDeleteFirst_StrMatcher675() { 
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
public void testReplaceAll_String_String676() { 
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
public void testReplace_int_int_String677() { 
     StrBuilder sb = new StrBuilder("abc"); 
     sb.replace(0, 1, "d"); 
     assertEquals("dbc", sb.toString()); 
     sb.replace(0, 1, "aaa"); 
     assertEquals("aaabc", sb.toString()); 
     sb.replace(0, 3, ""); 
     assertEquals("bc", sb.toString()); 
     sb.replace(1, 2, (String) null); 
     assertEquals("b", sb.toString()); 
     sb.replace(1, 1000, "text"); 
     assertEquals("btext", sb.toString()); 
     sb.replace(0, 1000, "text"); 
     assertEquals("text", sb.toString()); 
     sb = new StrBuilder("atext"); 
     sb.replace(1, 1, "ny"); 
     assertEquals("anytext", sb.toString()); 
     try { 
         sb.replace(2, 1, "anything"); 
         fail("Expected IndexOutOfBoundsException"); 
     } catch (final IndexOutOfBoundsException e) { 
     } 
     sb = new StrBuilder(); 
     try { 
         sb.replace(1, 2, "anything"); 
         fail("Expected IndexOutOfBoundsException"); 
     } catch (final IndexOutOfBoundsException e) { 
     } 
     try { 
         sb.replace(-1, 1, "anything"); 
         fail("Expected IndexOutOfBoundsException"); 
     } catch (final IndexOutOfBoundsException e) { 
     } 
 }
@Test
public void testReplaceAll_char_char678() { 
     final StrBuilder sb = new StrBuilder("abcbccba"); 
     sb.replaceAll('x', 'y'); 
     assertEquals("abcbccba", sb.toString()); 
     sb.replaceAll('a', 'd'); 
     assertEquals("dbcbccbd", sb.toString()); 
     sb.replaceAll('b', 'e'); 
     assertEquals("dececced", sb.toString()); 
     sb.replaceAll('c', 'f'); 
     assertEquals("defeffed", sb.toString()); 
     sb.replaceAll('d', 'd'); 
     assertEquals("defeffed", sb.toString()); 
 }
@Test
public void testReplaceFirst_String_String679() { 
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
public void testReplaceAll_StrMatcher_String680() { 
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
public void testTrim681() { 
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
public void testReverse682() { 
     final StrBuilder sb = new StrBuilder(); 
     assertEquals("", sb.reverse().toString()); 
     sb.clear().append(true); 
     assertEquals("eurt", sb.reverse().toString()); 
     assertEquals("true", sb.reverse().toString()); 
 }
@Test
public void testStartsWith683() { 
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
public void testEndsWith684() { 
     final StrBuilder sb = new StrBuilder(); 
     assertFalse(sb.endsWith("a")); 
     assertFalse(sb.endsWith("c")); 
     assertTrue(sb.endsWith("")); 
     assertFalse(sb.endsWith(null)); 
     sb.append("abc"); 
     assertTrue(sb.endsWith("c")); 
     assertTrue(sb.endsWith("bc")); 
     assertTrue(sb.endsWith("abc")); 
     assertFalse(sb.endsWith("cba")); 
     assertFalse(sb.endsWith("abcd")); 
     assertFalse(sb.endsWith(" abc")); 
     assertFalse(sb.endsWith("abc ")); 
 }
@Test
public void testSubSequenceIntInt685() { 
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
public void testSubstringIntInt686() { 
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
public void testRightString687() { 
     final StrBuilder sb = new StrBuilder("left right"); 
     assertEquals("right", sb.rightString(5)); 
     assertEquals("", sb.rightString(0)); 
     assertEquals("", sb.rightString(-5)); 
     assertEquals("left right", sb.rightString(15)); 
 }
@Test
public void testMidString688() { 
     final StrBuilder sb = new StrBuilder("hello goodbye hello"); 
     assertEquals("goodbye", sb.midString(6, 7)); 
     assertEquals("hello", sb.midString(0, 5)); 
     assertEquals("hello", sb.midString(-5, 5)); 
     assertEquals("", sb.midString(0, -1)); 
     assertEquals("", sb.midString(20, 2)); 
     assertEquals("hello", sb.midString(14, 22)); 
 }
@Test
public void testLang295689() { 
     final StrBuilder sb = new StrBuilder("onetwothree"); 
     sb.deleteFirst("three"); 
     assertFalse("The contains(char) method is looking beyond the end of the string", sb.contains('h')); 
     assertEquals("The indexOf(char) method is looking beyond the end of the string", -1, sb.indexOf('h')); 
 }
@Test
public void testContains_String690() { 
     final StrBuilder sb = new StrBuilder("abcdefghijklmnopqrstuvwxyz"); 
     assertTrue(sb.contains("a")); 
     assertTrue(sb.contains("pq")); 
     assertTrue(sb.contains("z")); 
     assertFalse(sb.contains("zyx")); 
     assertFalse(sb.contains((String) null)); 
 }
@Test
public void testContains_StrMatcher691() { 
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
public void testIndexOf_String_int692() { 
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
public void testIndexOf_StrMatcher693() { 
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
public void testLastIndexOf_char694() { 
     final StrBuilder sb = new StrBuilder("abab"); 
     assertEquals(2, sb.lastIndexOf('a')); 
     assertEquals("abab".lastIndexOf('a'), sb.lastIndexOf('a')); 
     assertEquals(3, sb.lastIndexOf('b')); 
     assertEquals("abab".lastIndexOf('b'), sb.lastIndexOf('b')); 
     assertEquals(-1, sb.lastIndexOf('z')); 
 }
@Test
public void testLastIndexOf_char_int695() { 
     StrBuilder sb = new StrBuilder("abab"); 
     assertEquals(-1, sb.lastIndexOf('a', -1)); 
     assertEquals(0, sb.lastIndexOf('a', 0)); 
     assertEquals(0, sb.lastIndexOf('a', 1)); 
     assertEquals("abab".lastIndexOf('a', 1), sb.lastIndexOf('a', 1)); 
     assertEquals(1, sb.lastIndexOf('b', 2)); 
     assertEquals("abab".lastIndexOf('b', 2), sb.lastIndexOf('b', 2)); 
     assertEquals(-1, sb.lastIndexOf('z', 2)); 
     sb = new StrBuilder("xyzabc"); 
     assertEquals(2, sb.lastIndexOf('z', sb.length())); 
     assertEquals(-1, sb.lastIndexOf('z', 1)); 
 }
@Test
public void testLastIndexOf_String696() { 
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
public void testLastIndexOf_String_int697() { 
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
public void testAsTokenizer698() throws Exception { 
     final StrBuilder b = new StrBuilder(); 
     b.append("a b "); 
     final StrTokenizer t = b.asTokenizer(); 
     final String[] tokens1 = t.getTokenArray(); 
     assertEquals(2, tokens1.length); 
     assertEquals("a", tokens1[0]); 
     assertEquals("b", tokens1[1]); 
     assertEquals(2, t.size()); 
     b.append("c d "); 
     final String[] tokens2 = t.getTokenArray(); 
     assertEquals(2, tokens2.length); 
     assertEquals("a", tokens2[0]); 
     assertEquals("b", tokens2[1]); 
     assertEquals(2, t.size()); 
     assertEquals("a", t.next()); 
     assertEquals("b", t.next()); 
     t.reset(); 
     final String[] tokens3 = t.getTokenArray(); 
     assertEquals(4, tokens3.length); 
     assertEquals("a", tokens3[0]); 
     assertEquals("b", tokens3[1]); 
     assertEquals("c", tokens3[2]); 
     assertEquals("d", tokens3[3]); 
     assertEquals(4, t.size()); 
     assertEquals("a", t.next()); 
     assertEquals("b", t.next()); 
     assertEquals("c", t.next()); 
     assertEquals("d", t.next()); 
     assertEquals("a b c d ", t.getContent()); 
 }
@Test
public void testEqualsIgnoreCase699() { 
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
public void testEquals700() { 
     final StrBuilder sb1 = new StrBuilder(); 
     final StrBuilder sb2 = new StrBuilder(); 
     assertTrue(sb1.equals(sb2)); 
     assertTrue(sb1.equals(sb1)); 
     assertTrue(sb2.equals(sb2)); 
     assertTrue(sb1.equals((Object) sb2)); 
     sb1.append("abc"); 
     assertFalse(sb1.equals(sb2)); 
     assertFalse(sb1.equals((Object) sb2)); 
     sb2.append("ABC"); 
     assertFalse(sb1.equals(sb2)); 
     assertFalse(sb1.equals((Object) sb2)); 
     sb2.clear().append("abc"); 
     assertTrue(sb1.equals(sb2)); 
     assertTrue(sb1.equals((Object) sb2)); 
     assertFalse(sb1.equals(Integer.valueOf(1))); 
     assertFalse(sb1.equals("abc")); 
 }
@Test
public void testHashCode701() { 
     final StrBuilder sb = new StrBuilder(); 
     final int hc1a = sb.hashCode(); 
     final int hc1b = sb.hashCode(); 
     assertEquals(0, hc1a); 
     assertEquals(hc1a, hc1b); 
     sb.append("abc"); 
     final int hc2a = sb.hashCode(); 
     final int hc2b = sb.hashCode(); 
     assertTrue(hc2a != 0); 
     assertEquals(hc2a, hc2b); 
 }
@Test
public void testToStringBuffer702() { 
     final StrBuilder sb = new StrBuilder(); 
     assertEquals(new StringBuffer().toString(), sb.toStringBuffer().toString()); 
     sb.append("junit"); 
     assertEquals(new StringBuffer("junit").toString(), sb.toStringBuffer().toString()); 
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
