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
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;

import org.apache.commons.lang3.SystemUtils;

/**
 * Unit tests for {@link org.apache.commons.lang3.text.StrBuilder}.
 *
 * @version $Id$
 */
public class StrBuilderAppendInsertTest {

    /** The system line separator. */
    private static final String SEP = SystemUtils.LINE_SEPARATOR;

    /** Test subclass of Object, with a toString method. */
    private static final Object FOO = new Object() {
        @Override
        public String toString() {
            return "foo";
        }
    };

    //-----------------------------------------------------------------------
@Test
public void testAppendln_PrimitiveNumber28() { 
     final StrBuilder sb = new StrBuilder(); 
     sb.appendln(0); 
     assertEquals("0" + SEP, sb.toString()); 
     sb.clear(); 
     sb.appendln(1L); 
     assertEquals("1" + SEP, sb.toString()); 
     sb.clear(); 
     sb.appendln(2.3f); 
     assertEquals("2.3" + SEP, sb.toString()); 
     sb.clear(); 
     sb.appendln(4.5d); 
     assertEquals("4.5" + SEP, sb.toString()); 
 }
@Test
public void testAppendSeparator_String75() { 
     final StrBuilder sb = new StrBuilder(); 
     sb.appendSeparator(","); 
     assertEquals("", sb.toString()); 
     sb.append("foo"); 
     assertEquals("foo", sb.toString()); 
     sb.appendSeparator(","); 
     assertEquals("foo,", sb.toString()); 
 }
@Test
public void testAppend_StringBuffer78() { 
     StrBuilder sb = new StrBuilder(); 
     sb.setNullText("NULL").append((StringBuffer) null); 
     assertEquals("NULL", sb.toString()); 
     sb = new StrBuilder(); 
     sb.append(new StringBuffer("foo")); 
     assertEquals("foo", sb.toString()); 
     sb.append(new StringBuffer("")); 
     assertEquals("foo", sb.toString()); 
     sb.append(new StringBuffer("bar")); 
     assertEquals("foobar", sb.toString()); 
 }
@Test
public void testAppend_String_int_int95() { 
     StrBuilder sb = new StrBuilder(); 
     sb.setNullText("NULL").append((String) null, 0, 1); 
     assertEquals("NULL", sb.toString()); 
     sb = new StrBuilder(); 
     sb.append("foo", 0, 3); 
     assertEquals("foo", sb.toString()); 
     try { 
         sb.append("bar", -1, 1); 
         fail("append(char[], -1,) expected IndexOutOfBoundsException"); 
     } catch (final IndexOutOfBoundsException e) { 
     } 
     try { 
         sb.append("bar", 3, 1); 
         fail("append(char[], 3,) expected IndexOutOfBoundsException"); 
     } catch (final IndexOutOfBoundsException e) { 
     } 
     try { 
         sb.append("bar", 1, -1); 
         fail("append(char[],, -1) expected IndexOutOfBoundsException"); 
     } catch (final IndexOutOfBoundsException e) { 
     } 
     try { 
         sb.append("bar", 1, 3); 
         fail("append(char[], 1, 3) expected IndexOutOfBoundsException"); 
     } catch (final IndexOutOfBoundsException e) { 
     } 
     try { 
         sb.append("bar", -1, 3); 
         fail("append(char[], -1, 3) expected IndexOutOfBoundsException"); 
     } catch (final IndexOutOfBoundsException e) { 
     } 
     try { 
         sb.append("bar", 4, 0); 
         fail("append(char[], 4, 0) expected IndexOutOfBoundsException"); 
     } catch (final IndexOutOfBoundsException e) { 
     } 
     sb.append("bar", 3, 0); 
     assertEquals("foo", sb.toString()); 
     sb.append("abcbardef", 3, 3); 
     assertEquals("foobar", sb.toString()); 
     sb.append((CharSequence) "abcbardef", 4, 3); 
     assertEquals("foobarard", sb.toString()); 
 }
@Test
public void testAppend_PrimitiveNumber114() { 
     final StrBuilder sb = new StrBuilder(); 
     sb.append(0); 
     assertEquals("0", sb.toString()); 
     sb.append(1L); 
     assertEquals("01", sb.toString()); 
     sb.append(2.3f); 
     assertEquals("012.3", sb.toString()); 
     sb.append(4.5d); 
     assertEquals("012.34.5", sb.toString()); 
 }
@Test
public void testAppendAll_Collection204() { 
     final StrBuilder sb = new StrBuilder(); 
     sb.appendAll((Collection<?>) null); 
     assertEquals("", sb.toString()); 
     sb.clear(); 
     sb.appendAll(Collections.EMPTY_LIST); 
     assertEquals("", sb.toString()); 
     sb.clear(); 
     sb.appendAll(Arrays.asList(new Object[] { "foo", "bar", "baz" })); 
     assertEquals("foobarbaz", sb.toString()); 
 }
@Test
public void testAppendWithSeparatorsWithNullText218() { 
     final StrBuilder sb = new StrBuilder(); 
     sb.setNullText("null"); 
     sb.appendWithSeparators(new Object[] { "foo", null, "baz" }, ","); 
     assertEquals("foo,null,baz", sb.toString()); 
     sb.clear(); 
     sb.appendWithSeparators(Arrays.asList(new Object[] { "foo", null, "baz" }), ","); 
     assertEquals("foo,null,baz", sb.toString()); 
 }
@Test
public void testAppendFixedWidthPadLeft_int263() { 
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
public void testAppendAll_Iterator312() { 
     final StrBuilder sb = new StrBuilder(); 
     sb.appendAll((Iterator<?>) null); 
     assertEquals("", sb.toString()); 
     sb.clear(); 
     sb.appendAll(Collections.EMPTY_LIST.iterator()); 
     assertEquals("", sb.toString()); 
     sb.clear(); 
     sb.appendAll(Arrays.asList(new Object[] { "foo", "bar", "baz" }).iterator()); 
     assertEquals("foobarbaz", sb.toString()); 
 }
@Test
public void testAppend_StringBuffer_int_int345() { 
     StrBuilder sb = new StrBuilder(); 
     sb.setNullText("NULL").append((StringBuffer) null, 0, 1); 
     assertEquals("NULL", sb.toString()); 
     sb = new StrBuilder(); 
     sb.append(new StringBuffer("foo"), 0, 3); 
     assertEquals("foo", sb.toString()); 
     try { 
         sb.append(new StringBuffer("bar"), -1, 1); 
         fail("append(char[], -1,) expected IndexOutOfBoundsException"); 
     } catch (final IndexOutOfBoundsException e) { 
     } 
     try { 
         sb.append(new StringBuffer("bar"), 3, 1); 
         fail("append(char[], 3,) expected IndexOutOfBoundsException"); 
     } catch (final IndexOutOfBoundsException e) { 
     } 
     try { 
         sb.append(new StringBuffer("bar"), 1, -1); 
         fail("append(char[],, -1) expected IndexOutOfBoundsException"); 
     } catch (final IndexOutOfBoundsException e) { 
     } 
     try { 
         sb.append(new StringBuffer("bar"), 1, 3); 
         fail("append(char[], 1, 3) expected IndexOutOfBoundsException"); 
     } catch (final IndexOutOfBoundsException e) { 
     } 
     try { 
         sb.append(new StringBuffer("bar"), -1, 3); 
         fail("append(char[], -1, 3) expected IndexOutOfBoundsException"); 
     } catch (final IndexOutOfBoundsException e) { 
     } 
     try { 
         sb.append(new StringBuffer("bar"), 4, 0); 
         fail("append(char[], 4, 0) expected IndexOutOfBoundsException"); 
     } catch (final IndexOutOfBoundsException e) { 
     } 
     sb.append(new StringBuffer("bar"), 3, 0); 
     assertEquals("foo", sb.toString()); 
     sb.append(new StringBuffer("abcbardef"), 3, 3); 
     assertEquals("foobar", sb.toString()); 
 }
@Test
public void testAppendln_Object400() { 
     final StrBuilder sb = new StrBuilder(); 
     sb.appendln((Object) null); 
     assertEquals("" + SEP, sb.toString()); 
     sb.appendln(FOO); 
     assertEquals(SEP + "foo" + SEP, sb.toString()); 
     sb.appendln(Integer.valueOf(6)); 
     assertEquals(SEP + "foo" + SEP + "6" + SEP, sb.toString()); 
 }
@Test
public void testAppendWithSeparatorsWithNullText406() { 
     final StrBuilder sb = new StrBuilder(); 
     sb.setNullText("null"); 
     sb.appendWithSeparators(new Object[] { "foo", null, "baz" }, ","); 
     assertEquals("foo,null,baz", sb.toString()); 
     sb.clear(); 
     sb.appendWithSeparators(Arrays.asList(new Object[] { "foo", null, "baz" }), ","); 
     assertEquals("foo,null,baz", sb.toString()); 
 }
@Test
public void testAppendln_Boolean448() { 
     final StrBuilder sb = new StrBuilder(); 
     sb.appendln(true); 
     assertEquals("true" + SEP, sb.toString()); 
     sb.clear(); 
     sb.appendln(false); 
     assertEquals("false" + SEP, sb.toString()); 
 }
@Test
public void testAppendln_PrimitiveNumber471() { 
     final StrBuilder sb = new StrBuilder(); 
     sb.appendln(0); 
     assertEquals("0" + SEP, sb.toString()); 
     sb.clear(); 
     sb.appendln(1L); 
     assertEquals("1" + SEP, sb.toString()); 
     sb.clear(); 
     sb.appendln(2.3f); 
     assertEquals("2.3" + SEP, sb.toString()); 
     sb.clear(); 
     sb.appendln(4.5d); 
     assertEquals("4.5" + SEP, sb.toString()); 
 }
@Test
public void testAppendln_Object489() { 
     final StrBuilder sb = new StrBuilder(); 
     sb.appendln((Object) null); 
     assertEquals("" + SEP, sb.toString()); 
     sb.appendln(FOO); 
     assertEquals(SEP + "foo" + SEP, sb.toString()); 
     sb.appendln(Integer.valueOf(6)); 
     assertEquals(SEP + "foo" + SEP + "6" + SEP, sb.toString()); 
 }
@Test
public void testAppend_StrBuilder494() { 
     StrBuilder sb = new StrBuilder(); 
     sb.setNullText("NULL").append((StrBuilder) null); 
     assertEquals("NULL", sb.toString()); 
     sb = new StrBuilder(); 
     sb.append(new StrBuilder("foo")); 
     assertEquals("foo", sb.toString()); 
     sb.append(new StrBuilder("")); 
     assertEquals("foo", sb.toString()); 
     sb.append(new StrBuilder("bar")); 
     assertEquals("foobar", sb.toString()); 
 }
@Test
public void testAppendln_StringBuffer519() { 
     final int[] count = new int[2]; 
     final StrBuilder sb = new StrBuilder() { 
  
         @Override 
         public StrBuilder append(final StringBuffer str) { 
             count[0]++; 
             return super.append(str); 
         } 
  
         @Override 
         public StrBuilder appendNewLine() { 
             count[1]++; 
             return super.appendNewLine(); 
         } 
     }; 
     sb.appendln(new StringBuffer("foo")); 
     assertEquals("foo" + SEP, sb.toString()); 
     assertEquals(1, count[0]); 
     assertEquals(1, count[1]); 
 }
@Test
public void testAppendln_CharArray_int_int555() { 
     final int[] count = new int[2]; 
     final StrBuilder sb = new StrBuilder() { 
  
         @Override 
         public StrBuilder append(final char[] str, final int startIndex, final int length) { 
             count[0]++; 
             return super.append(str, startIndex, length); 
         } 
  
         @Override 
         public StrBuilder appendNewLine() { 
             count[1]++; 
             return super.appendNewLine(); 
         } 
     }; 
     sb.appendln("foo".toCharArray(), 0, 3); 
     assertEquals("foo" + SEP, sb.toString()); 
     assertEquals(1, count[0]); 
     assertEquals(1, count[1]); 
 }
@Test
public void testAppend_PrimitiveNumber580() { 
     final StrBuilder sb = new StrBuilder(); 
     sb.append(0); 
     assertEquals("0", sb.toString()); 
     sb.append(1L); 
     assertEquals("01", sb.toString()); 
     sb.append(2.3f); 
     assertEquals("012.3", sb.toString()); 
     sb.append(4.5d); 
     assertEquals("012.34.5", sb.toString()); 
 }
@Test
public void testAppendln_Boolean631() { 
     final StrBuilder sb = new StrBuilder(); 
     sb.appendln(true); 
     assertEquals("true" + SEP, sb.toString()); 
     sb.clear(); 
     sb.appendln(false); 
     assertEquals("false" + SEP, sb.toString()); 
 }
@Test
public void testAppendAll_Collection642() { 
     final StrBuilder sb = new StrBuilder(); 
     sb.appendAll((Collection<?>) null); 
     assertEquals("", sb.toString()); 
     sb.clear(); 
     sb.appendAll(Collections.EMPTY_LIST); 
     assertEquals("", sb.toString()); 
     sb.clear(); 
     sb.appendAll(Arrays.asList(new Object[] { "foo", "bar", "baz" })); 
     assertEquals("foobarbaz", sb.toString()); 
 }
@Test
public void testAppendSeparator_char_char664() { 
     final StrBuilder sb = new StrBuilder(); 
     final char startSeparator = ':'; 
     final char standardSeparator = ','; 
     final String foo = "foo"; 
     sb.appendSeparator(standardSeparator, startSeparator); 
     assertEquals(String.valueOf(startSeparator), sb.toString()); 
     sb.append(foo); 
     assertEquals(String.valueOf(startSeparator) + foo, sb.toString()); 
     sb.appendSeparator(standardSeparator, startSeparator); 
     assertEquals(String.valueOf(startSeparator) + foo + standardSeparator, sb.toString()); 
 }
@Test
public void testAppend_StrBuilder675() { 
     StrBuilder sb = new StrBuilder(); 
     sb.setNullText("NULL").append((StrBuilder) null); 
     assertEquals("NULL", sb.toString()); 
     sb = new StrBuilder(); 
     sb.append(new StrBuilder("foo")); 
     assertEquals("foo", sb.toString()); 
     sb.append(new StrBuilder("")); 
     assertEquals("foo", sb.toString()); 
     sb.append(new StrBuilder("bar")); 
     assertEquals("foobar", sb.toString()); 
 }
@Test
public void testAppend_Object699() { 
     final StrBuilder sb = new StrBuilder(); 
     sb.appendNull(); 
     assertEquals("", sb.toString()); 
     sb.append((Object) null); 
     assertEquals("", sb.toString()); 
     sb.append(FOO); 
     assertEquals("foo", sb.toString()); 
     sb.append((StringBuffer) null); 
     assertEquals("foo", sb.toString()); 
     sb.append(new StringBuffer("baz")); 
     assertEquals("foobaz", sb.toString()); 
     sb.append(new StrBuilder("yes")); 
     assertEquals("foobazyes", sb.toString()); 
     sb.append((CharSequence) "Seq"); 
     assertEquals("foobazyesSeq", sb.toString()); 
     sb.append(new StringBuilder("bld")); 
     assertEquals("foobazyesSeqbld", sb.toString()); 
 }
@Test
public void testAppend_StrBuilder725() { 
     StrBuilder sb = new StrBuilder(); 
     sb.setNullText("NULL").append((StrBuilder) null); 
     assertEquals("NULL", sb.toString()); 
     sb = new StrBuilder(); 
     sb.append(new StrBuilder("foo")); 
     assertEquals("foo", sb.toString()); 
     sb.append(new StrBuilder("")); 
     assertEquals("foo", sb.toString()); 
     sb.append(new StrBuilder("bar")); 
     assertEquals("foobar", sb.toString()); 
 }
@Test
public void testAppendFixedWidthPadLeft_int729() { 
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
public void testAppendln_StrBuilder_int_int753() { 
     final int[] count = new int[2]; 
     final StrBuilder sb = new StrBuilder() { 
  
         @Override 
         public StrBuilder append(final StrBuilder str, final int startIndex, final int length) { 
             count[0]++; 
             return super.append(str, startIndex, length); 
         } 
  
         @Override 
         public StrBuilder appendNewLine() { 
             count[1]++; 
             return super.appendNewLine(); 
         } 
     }; 
     sb.appendln(new StrBuilder("foo"), 0, 3); 
     assertEquals("foo" + SEP, sb.toString()); 
     assertEquals(1, count[0]); 
     assertEquals(1, count[1]); 
 }
@Test
public void testAppendFixedWidthPadLeft_int770() { 
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
public void testAppendPadding892() { 
     final StrBuilder sb = new StrBuilder(); 
     sb.append("foo"); 
     assertEquals("foo", sb.toString()); 
     sb.appendPadding(-1, '-'); 
     assertEquals("foo", sb.toString()); 
     sb.appendPadding(0, '-'); 
     assertEquals("foo", sb.toString()); 
     sb.appendPadding(1, '-'); 
     assertEquals("foo-", sb.toString()); 
     sb.appendPadding(16, '-'); 
     assertEquals(20, sb.length()); 
     assertEquals("foo-----------------", sb.toString()); 
 }
@Test
public void testAppend_CharArray900() { 
     StrBuilder sb = new StrBuilder(); 
     sb.setNullText("NULL").append((char[]) null); 
     assertEquals("NULL", sb.toString()); 
     sb = new StrBuilder(); 
     sb.append(new char[0]); 
     assertEquals("", sb.toString()); 
     sb.append(new char[] { 'f', 'o', 'o' }); 
     assertEquals("foo", sb.toString()); 
 }
@Test
public void testAppend_StringBuffer_int_int941() { 
     StrBuilder sb = new StrBuilder(); 
     sb.setNullText("NULL").append((StringBuffer) null, 0, 1); 
     assertEquals("NULL", sb.toString()); 
     sb = new StrBuilder(); 
     sb.append(new StringBuffer("foo"), 0, 3); 
     assertEquals("foo", sb.toString()); 
     try { 
         sb.append(new StringBuffer("bar"), -1, 1); 
         fail("append(char[], -1,) expected IndexOutOfBoundsException"); 
     } catch (final IndexOutOfBoundsException e) { 
     } 
     try { 
         sb.append(new StringBuffer("bar"), 3, 1); 
         fail("append(char[], 3,) expected IndexOutOfBoundsException"); 
     } catch (final IndexOutOfBoundsException e) { 
     } 
     try { 
         sb.append(new StringBuffer("bar"), 1, -1); 
         fail("append(char[],, -1) expected IndexOutOfBoundsException"); 
     } catch (final IndexOutOfBoundsException e) { 
     } 
     try { 
         sb.append(new StringBuffer("bar"), 1, 3); 
         fail("append(char[], 1, 3) expected IndexOutOfBoundsException"); 
     } catch (final IndexOutOfBoundsException e) { 
     } 
     try { 
         sb.append(new StringBuffer("bar"), -1, 3); 
         fail("append(char[], -1, 3) expected IndexOutOfBoundsException"); 
     } catch (final IndexOutOfBoundsException e) { 
     } 
     try { 
         sb.append(new StringBuffer("bar"), 4, 0); 
         fail("append(char[], 4, 0) expected IndexOutOfBoundsException"); 
     } catch (final IndexOutOfBoundsException e) { 
     } 
     sb.append(new StringBuffer("bar"), 3, 0); 
     assertEquals("foo", sb.toString()); 
     sb.append(new StringBuffer("abcbardef"), 3, 3); 
     assertEquals("foobar", sb.toString()); 
 }
@Test
public void testAppendSeparator_char_char965() { 
     final StrBuilder sb = new StrBuilder(); 
     final char startSeparator = ':'; 
     final char standardSeparator = ','; 
     final String foo = "foo"; 
     sb.appendSeparator(standardSeparator, startSeparator); 
     assertEquals(String.valueOf(startSeparator), sb.toString()); 
     sb.append(foo); 
     assertEquals(String.valueOf(startSeparator) + foo, sb.toString()); 
     sb.appendSeparator(standardSeparator, startSeparator); 
     assertEquals(String.valueOf(startSeparator) + foo + standardSeparator, sb.toString()); 
 }
@Test
public void testAppend_String_int_int992() { 
     StrBuilder sb = new StrBuilder(); 
     sb.setNullText("NULL").append((String) null, 0, 1); 
     assertEquals("NULL", sb.toString()); 
     sb = new StrBuilder(); 
     sb.append("foo", 0, 3); 
     assertEquals("foo", sb.toString()); 
     try { 
         sb.append("bar", -1, 1); 
         fail("append(char[], -1,) expected IndexOutOfBoundsException"); 
     } catch (final IndexOutOfBoundsException e) { 
     } 
     try { 
         sb.append("bar", 3, 1); 
         fail("append(char[], 3,) expected IndexOutOfBoundsException"); 
     } catch (final IndexOutOfBoundsException e) { 
     } 
     try { 
         sb.append("bar", 1, -1); 
         fail("append(char[],, -1) expected IndexOutOfBoundsException"); 
     } catch (final IndexOutOfBoundsException e) { 
     } 
     try { 
         sb.append("bar", 1, 3); 
         fail("append(char[], 1, 3) expected IndexOutOfBoundsException"); 
     } catch (final IndexOutOfBoundsException e) { 
     } 
     try { 
         sb.append("bar", -1, 3); 
         fail("append(char[], -1, 3) expected IndexOutOfBoundsException"); 
     } catch (final IndexOutOfBoundsException e) { 
     } 
     try { 
         sb.append("bar", 4, 0); 
         fail("append(char[], 4, 0) expected IndexOutOfBoundsException"); 
     } catch (final IndexOutOfBoundsException e) { 
     } 
     sb.append("bar", 3, 0); 
     assertEquals("foo", sb.toString()); 
     sb.append("abcbardef", 3, 3); 
     assertEquals("foobar", sb.toString()); 
     sb.append((CharSequence) "abcbardef", 4, 3); 
     assertEquals("foobarard", sb.toString()); 
 }
@Test
public void testAppendSeparator_char1041() { 
     final StrBuilder sb = new StrBuilder(); 
     sb.appendSeparator(','); 
     assertEquals("", sb.toString()); 
     sb.append("foo"); 
     assertEquals("foo", sb.toString()); 
     sb.appendSeparator(','); 
     assertEquals("foo,", sb.toString()); 
 }
@Test
public void testAppendln_StrBuilder_int_int1094() { 
     final int[] count = new int[2]; 
     final StrBuilder sb = new StrBuilder() { 
  
         @Override 
         public StrBuilder append(final StrBuilder str, final int startIndex, final int length) { 
             count[0]++; 
             return super.append(str, startIndex, length); 
         } 
  
         @Override 
         public StrBuilder appendNewLine() { 
             count[1]++; 
             return super.appendNewLine(); 
         } 
     }; 
     sb.appendln(new StrBuilder("foo"), 0, 3); 
     assertEquals("foo" + SEP, sb.toString()); 
     assertEquals(1, count[0]); 
     assertEquals(1, count[1]); 
 }
@Test
public void testAppendWithSeparatorsWithNullText1174() { 
     final StrBuilder sb = new StrBuilder(); 
     sb.setNullText("null"); 
     sb.appendWithSeparators(new Object[] { "foo", null, "baz" }, ","); 
     assertEquals("foo,null,baz", sb.toString()); 
     sb.clear(); 
     sb.appendWithSeparators(Arrays.asList(new Object[] { "foo", null, "baz" }), ","); 
     assertEquals("foo,null,baz", sb.toString()); 
 }
@Test
public void testAppendln_StrBuilder1177() { 
     final int[] count = new int[2]; 
     final StrBuilder sb = new StrBuilder() { 
  
         @Override 
         public StrBuilder append(final StrBuilder str) { 
             count[0]++; 
             return super.append(str); 
         } 
  
         @Override 
         public StrBuilder appendNewLine() { 
             count[1]++; 
             return super.appendNewLine(); 
         } 
     }; 
     sb.appendln(new StrBuilder("foo")); 
     assertEquals("foo" + SEP, sb.toString()); 
     assertEquals(1, count[0]); 
     assertEquals(1, count[1]); 
 }
@Test
public void testAppendSeparator_char_int1210() { 
     final StrBuilder sb = new StrBuilder(); 
     sb.appendSeparator(',', 0); 
     assertEquals("", sb.toString()); 
     sb.append("foo"); 
     assertEquals("foo", sb.toString()); 
     sb.appendSeparator(',', 1); 
     assertEquals("foo,", sb.toString()); 
     sb.appendSeparator(',', -1); 
     assertEquals("foo,", sb.toString()); 
 }
@Test
public void testAppend_FormattedString1214() { 
     StrBuilder sb; 
     sb = new StrBuilder(); 
     sb.append("Hi", (Object[]) null); 
     assertEquals("Hi", sb.toString()); 
     sb = new StrBuilder(); 
     sb.append("Hi", "Alice"); 
     assertEquals("Hi", sb.toString()); 
     sb = new StrBuilder(); 
     sb.append("Hi %s", "Alice"); 
     assertEquals("Hi Alice", sb.toString()); 
     sb = new StrBuilder(); 
     sb.append("Hi %s %,d", "Alice", 5000); 
     assertEquals("Hi Alice 5,000", sb.toString()); 
 }
@Test
public void testAppendSeparator_String_int1377() { 
     final StrBuilder sb = new StrBuilder(); 
     sb.appendSeparator(",", 0); 
     assertEquals("", sb.toString()); 
     sb.append("foo"); 
     assertEquals("foo", sb.toString()); 
     sb.appendSeparator(",", 1); 
     assertEquals("foo,", sb.toString()); 
     sb.appendSeparator(",", -1); 
     assertEquals("foo,", sb.toString()); 
 }
@Test
public void testAppendln_StringBuffer_int_int1525() { 
     final int[] count = new int[2]; 
     final StrBuilder sb = new StrBuilder() { 
  
         @Override 
         public StrBuilder append(final StringBuffer str, final int startIndex, final int length) { 
             count[0]++; 
             return super.append(str, startIndex, length); 
         } 
  
         @Override 
         public StrBuilder appendNewLine() { 
             count[1]++; 
             return super.appendNewLine(); 
         } 
     }; 
     sb.appendln(new StringBuffer("foo"), 0, 3); 
     assertEquals("foo" + SEP, sb.toString()); 
     assertEquals(1, count[0]); 
     assertEquals(1, count[1]); 
 }
@Test
public void testAppend_CharArray1529() { 
     StrBuilder sb = new StrBuilder(); 
     sb.setNullText("NULL").append((char[]) null); 
     assertEquals("NULL", sb.toString()); 
     sb = new StrBuilder(); 
     sb.append(new char[0]); 
     assertEquals("", sb.toString()); 
     sb.append(new char[] { 'f', 'o', 'o' }); 
     assertEquals("foo", sb.toString()); 
 }
@Test
public void testAppendln_StringBuilder_int_int1555() { 
     final int[] count = new int[2]; 
     final StrBuilder sb = new StrBuilder() { 
  
         @Override 
         public StrBuilder append(final StringBuilder str, final int startIndex, final int length) { 
             count[0]++; 
             return super.append(str, startIndex, length); 
         } 
  
         @Override 
         public StrBuilder appendNewLine() { 
             count[1]++; 
             return super.appendNewLine(); 
         } 
     }; 
     sb.appendln(new StringBuilder("foo"), 0, 3); 
     assertEquals("foo" + SEP, sb.toString()); 
     assertEquals(1, count[0]); 
     assertEquals(1, count[1]); 
 }
@Test
public void testAppendAll_Collection1636() { 
     final StrBuilder sb = new StrBuilder(); 
     sb.appendAll((Collection<?>) null); 
     assertEquals("", sb.toString()); 
     sb.clear(); 
     sb.appendAll(Collections.EMPTY_LIST); 
     assertEquals("", sb.toString()); 
     sb.clear(); 
     sb.appendAll(Arrays.asList(new Object[] { "foo", "bar", "baz" })); 
     assertEquals("foobarbaz", sb.toString()); 
 }
@Test
public void testAppendFixedWidthPadLeft_int1702() { 
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
public void testAppendln_StrBuilder_int_int1709() { 
     final int[] count = new int[2]; 
     final StrBuilder sb = new StrBuilder() { 
  
         @Override 
         public StrBuilder append(final StrBuilder str, final int startIndex, final int length) { 
             count[0]++; 
             return super.append(str, startIndex, length); 
         } 
  
         @Override 
         public StrBuilder appendNewLine() { 
             count[1]++; 
             return super.appendNewLine(); 
         } 
     }; 
     sb.appendln(new StrBuilder("foo"), 0, 3); 
     assertEquals("foo" + SEP, sb.toString()); 
     assertEquals(1, count[0]); 
     assertEquals(1, count[1]); 
 }
@Test
public void testAppendln_Boolean1799() { 
     final StrBuilder sb = new StrBuilder(); 
     sb.appendln(true); 
     assertEquals("true" + SEP, sb.toString()); 
     sb.clear(); 
     sb.appendln(false); 
     assertEquals("false" + SEP, sb.toString()); 
 }
@Test
public void testAppendFixedWidthPadLeft_int1872() { 
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
public void testAppendSeparator_char_char1889() { 
     final StrBuilder sb = new StrBuilder(); 
     final char startSeparator = ':'; 
     final char standardSeparator = ','; 
     final String foo = "foo"; 
     sb.appendSeparator(standardSeparator, startSeparator); 
     assertEquals(String.valueOf(startSeparator), sb.toString()); 
     sb.append(foo); 
     assertEquals(String.valueOf(startSeparator) + foo, sb.toString()); 
     sb.appendSeparator(standardSeparator, startSeparator); 
     assertEquals(String.valueOf(startSeparator) + foo + standardSeparator, sb.toString()); 
 }
@Test
public void testAppendln_FormattedString2010() { 
     final int[] count = new int[2]; 
     final StrBuilder sb = new StrBuilder() { 
  
         @Override 
         public StrBuilder append(final String str) { 
             count[0]++; 
             return super.append(str); 
         } 
  
         @Override 
         public StrBuilder appendNewLine() { 
             count[1]++; 
             return super.appendNewLine(); 
         } 
     }; 
     sb.appendln("Hello %s", "Alice"); 
     assertEquals("Hello Alice" + SEP, sb.toString()); 
     assertEquals(2, count[0]); 
     assertEquals(1, count[1]); 
 }
@Test
public void testAppendln_StringBuilder_int_int2064() { 
     final int[] count = new int[2]; 
     final StrBuilder sb = new StrBuilder() { 
  
         @Override 
         public StrBuilder append(final StringBuilder str, final int startIndex, final int length) { 
             count[0]++; 
             return super.append(str, startIndex, length); 
         } 
  
         @Override 
         public StrBuilder appendNewLine() { 
             count[1]++; 
             return super.appendNewLine(); 
         } 
     }; 
     sb.appendln(new StringBuilder("foo"), 0, 3); 
     assertEquals("foo" + SEP, sb.toString()); 
     assertEquals(1, count[0]); 
     assertEquals(1, count[1]); 
 }
@Test
public void testAppendln_Boolean2188() { 
     final StrBuilder sb = new StrBuilder(); 
     sb.appendln(true); 
     assertEquals("true" + SEP, sb.toString()); 
     sb.clear(); 
     sb.appendln(false); 
     assertEquals("false" + SEP, sb.toString()); 
 }
@Test
public void testAppendWithSeparators_Iterator2200() { 
     final StrBuilder sb = new StrBuilder(); 
     sb.appendWithSeparators((Iterator<?>) null, ","); 
     assertEquals("", sb.toString()); 
     sb.clear(); 
     sb.appendWithSeparators(Collections.EMPTY_LIST.iterator(), ","); 
     assertEquals("", sb.toString()); 
     sb.clear(); 
     sb.appendWithSeparators(Arrays.asList(new Object[] { "foo", "bar", "baz" }).iterator(), ","); 
     assertEquals("foo,bar,baz", sb.toString()); 
     sb.clear(); 
     sb.appendWithSeparators(Arrays.asList(new Object[] { "foo", "bar", "baz" }).iterator(), null); 
     assertEquals("foobarbaz", sb.toString()); 
     sb.clear(); 
     sb.appendWithSeparators(Arrays.asList(new Object[] { "foo", null, "baz" }).iterator(), ","); 
     assertEquals("foo,,baz", sb.toString()); 
 }
@Test
public void testAppendln_StringBuffer2240() { 
     final int[] count = new int[2]; 
     final StrBuilder sb = new StrBuilder() { 
  
         @Override 
         public StrBuilder append(final StringBuffer str) { 
             count[0]++; 
             return super.append(str); 
         } 
  
         @Override 
         public StrBuilder appendNewLine() { 
             count[1]++; 
             return super.appendNewLine(); 
         } 
     }; 
     sb.appendln(new StringBuffer("foo")); 
     assertEquals("foo" + SEP, sb.toString()); 
     assertEquals(1, count[0]); 
     assertEquals(1, count[1]); 
 }
@Test
public void testAppendWithSeparatorsWithNullText2286() { 
     final StrBuilder sb = new StrBuilder(); 
     sb.setNullText("null"); 
     sb.appendWithSeparators(new Object[] { "foo", null, "baz" }, ","); 
     assertEquals("foo,null,baz", sb.toString()); 
     sb.clear(); 
     sb.appendWithSeparators(Arrays.asList(new Object[] { "foo", null, "baz" }), ","); 
     assertEquals("foo,null,baz", sb.toString()); 
 }
@Test
public void testAppend_StringBuffer_int_int2322() { 
     StrBuilder sb = new StrBuilder(); 
     sb.setNullText("NULL").append((StringBuffer) null, 0, 1); 
     assertEquals("NULL", sb.toString()); 
     sb = new StrBuilder(); 
     sb.append(new StringBuffer("foo"), 0, 3); 
     assertEquals("foo", sb.toString()); 
     try { 
         sb.append(new StringBuffer("bar"), -1, 1); 
         fail("append(char[], -1,) expected IndexOutOfBoundsException"); 
     } catch (final IndexOutOfBoundsException e) { 
     } 
     try { 
         sb.append(new StringBuffer("bar"), 3, 1); 
         fail("append(char[], 3,) expected IndexOutOfBoundsException"); 
     } catch (final IndexOutOfBoundsException e) { 
     } 
     try { 
         sb.append(new StringBuffer("bar"), 1, -1); 
         fail("append(char[],, -1) expected IndexOutOfBoundsException"); 
     } catch (final IndexOutOfBoundsException e) { 
     } 
     try { 
         sb.append(new StringBuffer("bar"), 1, 3); 
         fail("append(char[], 1, 3) expected IndexOutOfBoundsException"); 
     } catch (final IndexOutOfBoundsException e) { 
     } 
     try { 
         sb.append(new StringBuffer("bar"), -1, 3); 
         fail("append(char[], -1, 3) expected IndexOutOfBoundsException"); 
     } catch (final IndexOutOfBoundsException e) { 
     } 
     try { 
         sb.append(new StringBuffer("bar"), 4, 0); 
         fail("append(char[], 4, 0) expected IndexOutOfBoundsException"); 
     } catch (final IndexOutOfBoundsException e) { 
     } 
     sb.append(new StringBuffer("bar"), 3, 0); 
     assertEquals("foo", sb.toString()); 
     sb.append(new StringBuffer("abcbardef"), 3, 3); 
     assertEquals("foobar", sb.toString()); 
 }
@Test
public void testAppendln_Boolean2375() { 
     final StrBuilder sb = new StrBuilder(); 
     sb.appendln(true); 
     assertEquals("true" + SEP, sb.toString()); 
     sb.clear(); 
     sb.appendln(false); 
     assertEquals("false" + SEP, sb.toString()); 
 }
@Test
public void testAppendSeparator_char2404() { 
     final StrBuilder sb = new StrBuilder(); 
     sb.appendSeparator(','); 
     assertEquals("", sb.toString()); 
     sb.append("foo"); 
     assertEquals("foo", sb.toString()); 
     sb.appendSeparator(','); 
     assertEquals("foo,", sb.toString()); 
 }
@Test
public void testAppendln_Boolean2413() { 
     final StrBuilder sb = new StrBuilder(); 
     sb.appendln(true); 
     assertEquals("true" + SEP, sb.toString()); 
     sb.clear(); 
     sb.appendln(false); 
     assertEquals("false" + SEP, sb.toString()); 
 }
@Test
public void testAppendln_StringBuffer2425() { 
     final int[] count = new int[2]; 
     final StrBuilder sb = new StrBuilder() { 
  
         @Override 
         public StrBuilder append(final StringBuffer str) { 
             count[0]++; 
             return super.append(str); 
         } 
  
         @Override 
         public StrBuilder appendNewLine() { 
             count[1]++; 
             return super.appendNewLine(); 
         } 
     }; 
     sb.appendln(new StringBuffer("foo")); 
     assertEquals("foo" + SEP, sb.toString()); 
     assertEquals(1, count[0]); 
     assertEquals(1, count[1]); 
 }
@Test
public void testAppend_CharArray_int_int2502() { 
     StrBuilder sb = new StrBuilder(); 
     sb.setNullText("NULL").append((char[]) null, 0, 1); 
     assertEquals("NULL", sb.toString()); 
     sb = new StrBuilder(); 
     sb.append(new char[] { 'f', 'o', 'o' }, 0, 3); 
     assertEquals("foo", sb.toString()); 
     try { 
         sb.append(new char[] { 'b', 'a', 'r' }, -1, 1); 
         fail("append(char[], -1,) expected IndexOutOfBoundsException"); 
     } catch (final IndexOutOfBoundsException e) { 
     } 
     try { 
         sb.append(new char[] { 'b', 'a', 'r' }, 3, 1); 
         fail("append(char[], 3,) expected IndexOutOfBoundsException"); 
     } catch (final IndexOutOfBoundsException e) { 
     } 
     try { 
         sb.append(new char[] { 'b', 'a', 'r' }, 1, -1); 
         fail("append(char[],, -1) expected IndexOutOfBoundsException"); 
     } catch (final IndexOutOfBoundsException e) { 
     } 
     try { 
         sb.append(new char[] { 'b', 'a', 'r' }, 1, 3); 
         fail("append(char[], 1, 3) expected IndexOutOfBoundsException"); 
     } catch (final IndexOutOfBoundsException e) { 
     } 
     try { 
         sb.append(new char[] { 'b', 'a', 'r' }, -1, 3); 
         fail("append(char[], -1, 3) expected IndexOutOfBoundsException"); 
     } catch (final IndexOutOfBoundsException e) { 
     } 
     try { 
         sb.append(new char[] { 'b', 'a', 'r' }, 4, 0); 
         fail("append(char[], 4, 0) expected IndexOutOfBoundsException"); 
     } catch (final IndexOutOfBoundsException e) { 
     } 
     sb.append(new char[] { 'b', 'a', 'r' }, 3, 0); 
     assertEquals("foo", sb.toString()); 
     sb.append(new char[] { 'a', 'b', 'c', 'b', 'a', 'r', 'd', 'e', 'f' }, 3, 3); 
     assertEquals("foobar", sb.toString()); 
 }
@Test
public void testAppend_PrimitiveNumber2725() { 
     final StrBuilder sb = new StrBuilder(); 
     sb.append(0); 
     assertEquals("0", sb.toString()); 
     sb.append(1L); 
     assertEquals("01", sb.toString()); 
     sb.append(2.3f); 
     assertEquals("012.3", sb.toString()); 
     sb.append(4.5d); 
     assertEquals("012.34.5", sb.toString()); 
 }
@Test
public void testAppend_StringBuffer_int_int2734() { 
     StrBuilder sb = new StrBuilder(); 
     sb.setNullText("NULL").append((StringBuffer) null, 0, 1); 
     assertEquals("NULL", sb.toString()); 
     sb = new StrBuilder(); 
     sb.append(new StringBuffer("foo"), 0, 3); 
     assertEquals("foo", sb.toString()); 
     try { 
         sb.append(new StringBuffer("bar"), -1, 1); 
         fail("append(char[], -1,) expected IndexOutOfBoundsException"); 
     } catch (final IndexOutOfBoundsException e) { 
     } 
     try { 
         sb.append(new StringBuffer("bar"), 3, 1); 
         fail("append(char[], 3,) expected IndexOutOfBoundsException"); 
     } catch (final IndexOutOfBoundsException e) { 
     } 
     try { 
         sb.append(new StringBuffer("bar"), 1, -1); 
         fail("append(char[],, -1) expected IndexOutOfBoundsException"); 
     } catch (final IndexOutOfBoundsException e) { 
     } 
     try { 
         sb.append(new StringBuffer("bar"), 1, 3); 
         fail("append(char[], 1, 3) expected IndexOutOfBoundsException"); 
     } catch (final IndexOutOfBoundsException e) { 
     } 
     try { 
         sb.append(new StringBuffer("bar"), -1, 3); 
         fail("append(char[], -1, 3) expected IndexOutOfBoundsException"); 
     } catch (final IndexOutOfBoundsException e) { 
     } 
     try { 
         sb.append(new StringBuffer("bar"), 4, 0); 
         fail("append(char[], 4, 0) expected IndexOutOfBoundsException"); 
     } catch (final IndexOutOfBoundsException e) { 
     } 
     sb.append(new StringBuffer("bar"), 3, 0); 
     assertEquals("foo", sb.toString()); 
     sb.append(new StringBuffer("abcbardef"), 3, 3); 
     assertEquals("foobar", sb.toString()); 
 }
@Test
public void testAppend_StrBuilder2744() { 
     StrBuilder sb = new StrBuilder(); 
     sb.setNullText("NULL").append((StrBuilder) null); 
     assertEquals("NULL", sb.toString()); 
     sb = new StrBuilder(); 
     sb.append(new StrBuilder("foo")); 
     assertEquals("foo", sb.toString()); 
     sb.append(new StrBuilder("")); 
     assertEquals("foo", sb.toString()); 
     sb.append(new StrBuilder("bar")); 
     assertEquals("foobar", sb.toString()); 
 }
@Test
public void testAppendPadding2777() { 
     final StrBuilder sb = new StrBuilder(); 
     sb.append("foo"); 
     assertEquals("foo", sb.toString()); 
     sb.appendPadding(-1, '-'); 
     assertEquals("foo", sb.toString()); 
     sb.appendPadding(0, '-'); 
     assertEquals("foo", sb.toString()); 
     sb.appendPadding(1, '-'); 
     assertEquals("foo-", sb.toString()); 
     sb.appendPadding(16, '-'); 
     assertEquals(20, sb.length()); 
     assertEquals("foo-----------------", sb.toString()); 
 }
@Test
public void testAppendln_StrBuilder_int_int2891() { 
     final int[] count = new int[2]; 
     final StrBuilder sb = new StrBuilder() { 
  
         @Override 
         public StrBuilder append(final StrBuilder str, final int startIndex, final int length) { 
             count[0]++; 
             return super.append(str, startIndex, length); 
         } 
  
         @Override 
         public StrBuilder appendNewLine() { 
             count[1]++; 
             return super.appendNewLine(); 
         } 
     }; 
     sb.appendln(new StrBuilder("foo"), 0, 3); 
     assertEquals("foo" + SEP, sb.toString()); 
     assertEquals(1, count[0]); 
     assertEquals(1, count[1]); 
 }
@Test
public void testAppend_StringBuffer_int_int2903() { 
     StrBuilder sb = new StrBuilder(); 
     sb.setNullText("NULL").append((StringBuffer) null, 0, 1); 
     assertEquals("NULL", sb.toString()); 
     sb = new StrBuilder(); 
     sb.append(new StringBuffer("foo"), 0, 3); 
     assertEquals("foo", sb.toString()); 
     try { 
         sb.append(new StringBuffer("bar"), -1, 1); 
         fail("append(char[], -1,) expected IndexOutOfBoundsException"); 
     } catch (final IndexOutOfBoundsException e) { 
     } 
     try { 
         sb.append(new StringBuffer("bar"), 3, 1); 
         fail("append(char[], 3,) expected IndexOutOfBoundsException"); 
     } catch (final IndexOutOfBoundsException e) { 
     } 
     try { 
         sb.append(new StringBuffer("bar"), 1, -1); 
         fail("append(char[],, -1) expected IndexOutOfBoundsException"); 
     } catch (final IndexOutOfBoundsException e) { 
     } 
     try { 
         sb.append(new StringBuffer("bar"), 1, 3); 
         fail("append(char[], 1, 3) expected IndexOutOfBoundsException"); 
     } catch (final IndexOutOfBoundsException e) { 
     } 
     try { 
         sb.append(new StringBuffer("bar"), -1, 3); 
         fail("append(char[], -1, 3) expected IndexOutOfBoundsException"); 
     } catch (final IndexOutOfBoundsException e) { 
     } 
     try { 
         sb.append(new StringBuffer("bar"), 4, 0); 
         fail("append(char[], 4, 0) expected IndexOutOfBoundsException"); 
     } catch (final IndexOutOfBoundsException e) { 
     } 
     sb.append(new StringBuffer("bar"), 3, 0); 
     assertEquals("foo", sb.toString()); 
     sb.append(new StringBuffer("abcbardef"), 3, 3); 
     assertEquals("foobar", sb.toString()); 
 }
@Test
public void testAppendWithSeparatorsWithNullText2943() { 
     final StrBuilder sb = new StrBuilder(); 
     sb.setNullText("null"); 
     sb.appendWithSeparators(new Object[] { "foo", null, "baz" }, ","); 
     assertEquals("foo,null,baz", sb.toString()); 
     sb.clear(); 
     sb.appendWithSeparators(Arrays.asList(new Object[] { "foo", null, "baz" }), ","); 
     assertEquals("foo,null,baz", sb.toString()); 
 }
@Test
public void testAppendWithSeparatorsWithNullText2944() { 
     final StrBuilder sb = new StrBuilder(); 
     sb.setNullText("null"); 
     sb.appendWithSeparators(new Object[] { "foo", null, "baz" }, ","); 
     assertEquals("foo,null,baz", sb.toString()); 
     sb.clear(); 
     sb.appendWithSeparators(Arrays.asList(new Object[] { "foo", null, "baz" }), ","); 
     assertEquals("foo,null,baz", sb.toString()); 
 }
@Test
public void testAppendFixedWidthPadRight_int2989() { 
     final StrBuilder sb = new StrBuilder(); 
     sb.appendFixedWidthPadRight(123, -1, '-'); 
     assertEquals("", sb.toString()); 
     sb.clear(); 
     sb.appendFixedWidthPadRight(123, 0, '-'); 
     assertEquals("", sb.toString()); 
     sb.clear(); 
     sb.appendFixedWidthPadRight(123, 1, '-'); 
     assertEquals("1", sb.toString()); 
     sb.clear(); 
     sb.appendFixedWidthPadRight(123, 2, '-'); 
     assertEquals("12", sb.toString()); 
     sb.clear(); 
     sb.appendFixedWidthPadRight(123, 3, '-'); 
     assertEquals("123", sb.toString()); 
     sb.clear(); 
     sb.appendFixedWidthPadRight(123, 4, '-'); 
     assertEquals("123-", sb.toString()); 
     sb.clear(); 
     sb.appendFixedWidthPadRight(123, 10, '-'); 
     assertEquals(10, sb.length()); 
     assertEquals("123-------", sb.toString()); 
 }
@Test
public void testAppendln_FormattedString3033() { 
     final int[] count = new int[2]; 
     final StrBuilder sb = new StrBuilder() { 
  
         @Override 
         public StrBuilder append(final String str) { 
             count[0]++; 
             return super.append(str); 
         } 
  
         @Override 
         public StrBuilder appendNewLine() { 
             count[1]++; 
             return super.appendNewLine(); 
         } 
     }; 
     sb.appendln("Hello %s", "Alice"); 
     assertEquals("Hello Alice" + SEP, sb.toString()); 
     assertEquals(2, count[0]); 
     assertEquals(1, count[1]); 
 }
@Test
public void testAppend_String_int_int3079() { 
     StrBuilder sb = new StrBuilder(); 
     sb.setNullText("NULL").append((String) null, 0, 1); 
     assertEquals("NULL", sb.toString()); 
     sb = new StrBuilder(); 
     sb.append("foo", 0, 3); 
     assertEquals("foo", sb.toString()); 
     try { 
         sb.append("bar", -1, 1); 
         fail("append(char[], -1,) expected IndexOutOfBoundsException"); 
     } catch (final IndexOutOfBoundsException e) { 
     } 
     try { 
         sb.append("bar", 3, 1); 
         fail("append(char[], 3,) expected IndexOutOfBoundsException"); 
     } catch (final IndexOutOfBoundsException e) { 
     } 
     try { 
         sb.append("bar", 1, -1); 
         fail("append(char[],, -1) expected IndexOutOfBoundsException"); 
     } catch (final IndexOutOfBoundsException e) { 
     } 
     try { 
         sb.append("bar", 1, 3); 
         fail("append(char[], 1, 3) expected IndexOutOfBoundsException"); 
     } catch (final IndexOutOfBoundsException e) { 
     } 
     try { 
         sb.append("bar", -1, 3); 
         fail("append(char[], -1, 3) expected IndexOutOfBoundsException"); 
     } catch (final IndexOutOfBoundsException e) { 
     } 
     try { 
         sb.append("bar", 4, 0); 
         fail("append(char[], 4, 0) expected IndexOutOfBoundsException"); 
     } catch (final IndexOutOfBoundsException e) { 
     } 
     sb.append("bar", 3, 0); 
     assertEquals("foo", sb.toString()); 
     sb.append("abcbardef", 3, 3); 
     assertEquals("foobar", sb.toString()); 
     sb.append((CharSequence) "abcbardef", 4, 3); 
     assertEquals("foobarard", sb.toString()); 
 }
@Test
public void testAppendln_StrBuilder_int_int3185() { 
     final int[] count = new int[2]; 
     final StrBuilder sb = new StrBuilder() { 
  
         @Override 
         public StrBuilder append(final StrBuilder str, final int startIndex, final int length) { 
             count[0]++; 
             return super.append(str, startIndex, length); 
         } 
  
         @Override 
         public StrBuilder appendNewLine() { 
             count[1]++; 
             return super.appendNewLine(); 
         } 
     }; 
     sb.appendln(new StrBuilder("foo"), 0, 3); 
     assertEquals("foo" + SEP, sb.toString()); 
     assertEquals(1, count[0]); 
     assertEquals(1, count[1]); 
 }
@Test
public void testAppend_StringBuilder_int_int3211() { 
     StrBuilder sb = new StrBuilder(); 
     sb.setNullText("NULL").append((String) null, 0, 1); 
     assertEquals("NULL", sb.toString()); 
     sb = new StrBuilder(); 
     sb.append(new StringBuilder("foo"), 0, 3); 
     assertEquals("foo", sb.toString()); 
     try { 
         sb.append(new StringBuilder("bar"), -1, 1); 
         fail("append(StringBuilder, -1,) expected IndexOutOfBoundsException"); 
     } catch (final IndexOutOfBoundsException e) { 
     } 
     try { 
         sb.append(new StringBuilder("bar"), 3, 1); 
         fail("append(StringBuilder, 3,) expected IndexOutOfBoundsException"); 
     } catch (final IndexOutOfBoundsException e) { 
     } 
     try { 
         sb.append(new StringBuilder("bar"), 1, -1); 
         fail("append(StringBuilder,, -1) expected IndexOutOfBoundsException"); 
     } catch (final IndexOutOfBoundsException e) { 
     } 
     try { 
         sb.append(new StringBuilder("bar"), 1, 3); 
         fail("append(StringBuilder, 1, 3) expected IndexOutOfBoundsException"); 
     } catch (final IndexOutOfBoundsException e) { 
     } 
     try { 
         sb.append(new StringBuilder("bar"), -1, 3); 
         fail("append(StringBuilder, -1, 3) expected IndexOutOfBoundsException"); 
     } catch (final IndexOutOfBoundsException e) { 
     } 
     try { 
         sb.append(new StringBuilder("bar"), 4, 0); 
         fail("append(StringBuilder, 4, 0) expected IndexOutOfBoundsException"); 
     } catch (final IndexOutOfBoundsException e) { 
     } 
     sb.append(new StringBuilder("bar"), 3, 0); 
     assertEquals("foo", sb.toString()); 
     sb.append(new StringBuilder("abcbardef"), 3, 3); 
     assertEquals("foobar", sb.toString()); 
     sb.append(new StringBuilder("abcbardef"), 4, 3); 
     assertEquals("foobarard", sb.toString()); 
 }
@Test
public void testAppendFixedWidthPadLeft_int3233() { 
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
public void testAppendSeparator_char_char3317() { 
     final StrBuilder sb = new StrBuilder(); 
     final char startSeparator = ':'; 
     final char standardSeparator = ','; 
     final String foo = "foo"; 
     sb.appendSeparator(standardSeparator, startSeparator); 
     assertEquals(String.valueOf(startSeparator), sb.toString()); 
     sb.append(foo); 
     assertEquals(String.valueOf(startSeparator) + foo, sb.toString()); 
     sb.appendSeparator(standardSeparator, startSeparator); 
     assertEquals(String.valueOf(startSeparator) + foo + standardSeparator, sb.toString()); 
 }
@Test
public void testAppendln_Boolean3321() { 
     final StrBuilder sb = new StrBuilder(); 
     sb.appendln(true); 
     assertEquals("true" + SEP, sb.toString()); 
     sb.clear(); 
     sb.appendln(false); 
     assertEquals("false" + SEP, sb.toString()); 
 }
@Test
public void testAppendWithSeparatorsWithNullText3348() { 
     final StrBuilder sb = new StrBuilder(); 
     sb.setNullText("null"); 
     sb.appendWithSeparators(new Object[] { "foo", null, "baz" }, ","); 
     assertEquals("foo,null,baz", sb.toString()); 
     sb.clear(); 
     sb.appendWithSeparators(Arrays.asList(new Object[] { "foo", null, "baz" }), ","); 
     assertEquals("foo,null,baz", sb.toString()); 
 }
@Test
public void testAppendln_StringBuffer3405() { 
     final int[] count = new int[2]; 
     final StrBuilder sb = new StrBuilder() { 
  
         @Override 
         public StrBuilder append(final StringBuffer str) { 
             count[0]++; 
             return super.append(str); 
         } 
  
         @Override 
         public StrBuilder appendNewLine() { 
             count[1]++; 
             return super.appendNewLine(); 
         } 
     }; 
     sb.appendln(new StringBuffer("foo")); 
     assertEquals("foo" + SEP, sb.toString()); 
     assertEquals(1, count[0]); 
     assertEquals(1, count[1]); 
 }
@Test
public void testAppendln_CharArray3410() { 
     final int[] count = new int[2]; 
     final StrBuilder sb = new StrBuilder() { 
  
         @Override 
         public StrBuilder append(final char[] str) { 
             count[0]++; 
             return super.append(str); 
         } 
  
         @Override 
         public StrBuilder appendNewLine() { 
             count[1]++; 
             return super.appendNewLine(); 
         } 
     }; 
     sb.appendln("foo".toCharArray()); 
     assertEquals("foo" + SEP, sb.toString()); 
     assertEquals(1, count[0]); 
     assertEquals(1, count[1]); 
 }
@Test
public void testAppendln_StrBuilder_int_int3421() { 
     final int[] count = new int[2]; 
     final StrBuilder sb = new StrBuilder() { 
  
         @Override 
         public StrBuilder append(final StrBuilder str, final int startIndex, final int length) { 
             count[0]++; 
             return super.append(str, startIndex, length); 
         } 
  
         @Override 
         public StrBuilder appendNewLine() { 
             count[1]++; 
             return super.appendNewLine(); 
         } 
     }; 
     sb.appendln(new StrBuilder("foo"), 0, 3); 
     assertEquals("foo" + SEP, sb.toString()); 
     assertEquals(1, count[0]); 
     assertEquals(1, count[1]); 
 }
@Test
public void testAppend_FormattedString3427() { 
     StrBuilder sb; 
     sb = new StrBuilder(); 
     sb.append("Hi", (Object[]) null); 
     assertEquals("Hi", sb.toString()); 
     sb = new StrBuilder(); 
     sb.append("Hi", "Alice"); 
     assertEquals("Hi", sb.toString()); 
     sb = new StrBuilder(); 
     sb.append("Hi %s", "Alice"); 
     assertEquals("Hi Alice", sb.toString()); 
     sb = new StrBuilder(); 
     sb.append("Hi %s %,d", "Alice", 5000); 
     assertEquals("Hi Alice 5,000", sb.toString()); 
 }
@Test
public void testAppendln_CharArray_int_int3467() { 
     final int[] count = new int[2]; 
     final StrBuilder sb = new StrBuilder() { 
  
         @Override 
         public StrBuilder append(final char[] str, final int startIndex, final int length) { 
             count[0]++; 
             return super.append(str, startIndex, length); 
         } 
  
         @Override 
         public StrBuilder appendNewLine() { 
             count[1]++; 
             return super.appendNewLine(); 
         } 
     }; 
     sb.appendln("foo".toCharArray(), 0, 3); 
     assertEquals("foo" + SEP, sb.toString()); 
     assertEquals(1, count[0]); 
     assertEquals(1, count[1]); 
 }
@Test
public void testAppendln_String3475() { 
     final int[] count = new int[2]; 
     final StrBuilder sb = new StrBuilder() { 
  
         @Override 
         public StrBuilder append(final String str) { 
             count[0]++; 
             return super.append(str); 
         } 
  
         @Override 
         public StrBuilder appendNewLine() { 
             count[1]++; 
             return super.appendNewLine(); 
         } 
     }; 
     sb.appendln("foo"); 
     assertEquals("foo" + SEP, sb.toString()); 
     assertEquals(2, count[0]); 
     assertEquals(1, count[1]); 
 }
@Test
public void testAppend_CharArray3523() { 
     StrBuilder sb = new StrBuilder(); 
     sb.setNullText("NULL").append((char[]) null); 
     assertEquals("NULL", sb.toString()); 
     sb = new StrBuilder(); 
     sb.append(new char[0]); 
     assertEquals("", sb.toString()); 
     sb.append(new char[] { 'f', 'o', 'o' }); 
     assertEquals("foo", sb.toString()); 
 }
@Test
public void testAppendPadding3536() { 
     final StrBuilder sb = new StrBuilder(); 
     sb.append("foo"); 
     assertEquals("foo", sb.toString()); 
     sb.appendPadding(-1, '-'); 
     assertEquals("foo", sb.toString()); 
     sb.appendPadding(0, '-'); 
     assertEquals("foo", sb.toString()); 
     sb.appendPadding(1, '-'); 
     assertEquals("foo-", sb.toString()); 
     sb.appendPadding(16, '-'); 
     assertEquals(20, sb.length()); 
     assertEquals("foo-----------------", sb.toString()); 
 }
@Test
public void testAppend_CharArray3609() { 
     StrBuilder sb = new StrBuilder(); 
     sb.setNullText("NULL").append((char[]) null); 
     assertEquals("NULL", sb.toString()); 
     sb = new StrBuilder(); 
     sb.append(new char[0]); 
     assertEquals("", sb.toString()); 
     sb.append(new char[] { 'f', 'o', 'o' }); 
     assertEquals("foo", sb.toString()); 
 }
@Test
public void testAppend_String_int_int3612() { 
     StrBuilder sb = new StrBuilder(); 
     sb.setNullText("NULL").append((String) null, 0, 1); 
     assertEquals("NULL", sb.toString()); 
     sb = new StrBuilder(); 
     sb.append("foo", 0, 3); 
     assertEquals("foo", sb.toString()); 
     try { 
         sb.append("bar", -1, 1); 
         fail("append(char[], -1,) expected IndexOutOfBoundsException"); 
     } catch (final IndexOutOfBoundsException e) { 
     } 
     try { 
         sb.append("bar", 3, 1); 
         fail("append(char[], 3,) expected IndexOutOfBoundsException"); 
     } catch (final IndexOutOfBoundsException e) { 
     } 
     try { 
         sb.append("bar", 1, -1); 
         fail("append(char[],, -1) expected IndexOutOfBoundsException"); 
     } catch (final IndexOutOfBoundsException e) { 
     } 
     try { 
         sb.append("bar", 1, 3); 
         fail("append(char[], 1, 3) expected IndexOutOfBoundsException"); 
     } catch (final IndexOutOfBoundsException e) { 
     } 
     try { 
         sb.append("bar", -1, 3); 
         fail("append(char[], -1, 3) expected IndexOutOfBoundsException"); 
     } catch (final IndexOutOfBoundsException e) { 
     } 
     try { 
         sb.append("bar", 4, 0); 
         fail("append(char[], 4, 0) expected IndexOutOfBoundsException"); 
     } catch (final IndexOutOfBoundsException e) { 
     } 
     sb.append("bar", 3, 0); 
     assertEquals("foo", sb.toString()); 
     sb.append("abcbardef", 3, 3); 
     assertEquals("foobar", sb.toString()); 
     sb.append((CharSequence) "abcbardef", 4, 3); 
     assertEquals("foobarard", sb.toString()); 
 }
@Test
public void testAppendSeparator_String3623() { 
     final StrBuilder sb = new StrBuilder(); 
     sb.appendSeparator(","); 
     assertEquals("", sb.toString()); 
     sb.append("foo"); 
     assertEquals("foo", sb.toString()); 
     sb.appendSeparator(","); 
     assertEquals("foo,", sb.toString()); 
 }
@Test
public void testAppendln_String_int_int3641() { 
     final int[] count = new int[2]; 
     final StrBuilder sb = new StrBuilder() { 
  
         @Override 
         public StrBuilder append(final String str, final int startIndex, final int length) { 
             count[0]++; 
             return super.append(str, startIndex, length); 
         } 
  
         @Override 
         public StrBuilder appendNewLine() { 
             count[1]++; 
             return super.appendNewLine(); 
         } 
     }; 
     sb.appendln("foo", 0, 3); 
     assertEquals("foo" + SEP, sb.toString()); 
     assertEquals(1, count[0]); 
     assertEquals(1, count[1]); 
 }
@Test
public void testAppendAll_Iterator3686() { 
     final StrBuilder sb = new StrBuilder(); 
     sb.appendAll((Iterator<?>) null); 
     assertEquals("", sb.toString()); 
     sb.clear(); 
     sb.appendAll(Collections.EMPTY_LIST.iterator()); 
     assertEquals("", sb.toString()); 
     sb.clear(); 
     sb.appendAll(Arrays.asList(new Object[] { "foo", "bar", "baz" }).iterator()); 
     assertEquals("foobarbaz", sb.toString()); 
 }
@Test
public void testAppend_StrBuilder3698() { 
     StrBuilder sb = new StrBuilder(); 
     sb.setNullText("NULL").append((StrBuilder) null); 
     assertEquals("NULL", sb.toString()); 
     sb = new StrBuilder(); 
     sb.append(new StrBuilder("foo")); 
     assertEquals("foo", sb.toString()); 
     sb.append(new StrBuilder("")); 
     assertEquals("foo", sb.toString()); 
     sb.append(new StrBuilder("bar")); 
     assertEquals("foobar", sb.toString()); 
 }
@Test
public void testAppend_StringBuffer_int_int3764() { 
     StrBuilder sb = new StrBuilder(); 
     sb.setNullText("NULL").append((StringBuffer) null, 0, 1); 
     assertEquals("NULL", sb.toString()); 
     sb = new StrBuilder(); 
     sb.append(new StringBuffer("foo"), 0, 3); 
     assertEquals("foo", sb.toString()); 
     try { 
         sb.append(new StringBuffer("bar"), -1, 1); 
         fail("append(char[], -1,) expected IndexOutOfBoundsException"); 
     } catch (final IndexOutOfBoundsException e) { 
     } 
     try { 
         sb.append(new StringBuffer("bar"), 3, 1); 
         fail("append(char[], 3,) expected IndexOutOfBoundsException"); 
     } catch (final IndexOutOfBoundsException e) { 
     } 
     try { 
         sb.append(new StringBuffer("bar"), 1, -1); 
         fail("append(char[],, -1) expected IndexOutOfBoundsException"); 
     } catch (final IndexOutOfBoundsException e) { 
     } 
     try { 
         sb.append(new StringBuffer("bar"), 1, 3); 
         fail("append(char[], 1, 3) expected IndexOutOfBoundsException"); 
     } catch (final IndexOutOfBoundsException e) { 
     } 
     try { 
         sb.append(new StringBuffer("bar"), -1, 3); 
         fail("append(char[], -1, 3) expected IndexOutOfBoundsException"); 
     } catch (final IndexOutOfBoundsException e) { 
     } 
     try { 
         sb.append(new StringBuffer("bar"), 4, 0); 
         fail("append(char[], 4, 0) expected IndexOutOfBoundsException"); 
     } catch (final IndexOutOfBoundsException e) { 
     } 
     sb.append(new StringBuffer("bar"), 3, 0); 
     assertEquals("foo", sb.toString()); 
     sb.append(new StringBuffer("abcbardef"), 3, 3); 
     assertEquals("foobar", sb.toString()); 
 }
@Test
public void testAppend_StringBuffer_int_int3807() { 
     StrBuilder sb = new StrBuilder(); 
     sb.setNullText("NULL").append((StringBuffer) null, 0, 1); 
     assertEquals("NULL", sb.toString()); 
     sb = new StrBuilder(); 
     sb.append(new StringBuffer("foo"), 0, 3); 
     assertEquals("foo", sb.toString()); 
     try { 
         sb.append(new StringBuffer("bar"), -1, 1); 
         fail("append(char[], -1,) expected IndexOutOfBoundsException"); 
     } catch (final IndexOutOfBoundsException e) { 
     } 
     try { 
         sb.append(new StringBuffer("bar"), 3, 1); 
         fail("append(char[], 3,) expected IndexOutOfBoundsException"); 
     } catch (final IndexOutOfBoundsException e) { 
     } 
     try { 
         sb.append(new StringBuffer("bar"), 1, -1); 
         fail("append(char[],, -1) expected IndexOutOfBoundsException"); 
     } catch (final IndexOutOfBoundsException e) { 
     } 
     try { 
         sb.append(new StringBuffer("bar"), 1, 3); 
         fail("append(char[], 1, 3) expected IndexOutOfBoundsException"); 
     } catch (final IndexOutOfBoundsException e) { 
     } 
     try { 
         sb.append(new StringBuffer("bar"), -1, 3); 
         fail("append(char[], -1, 3) expected IndexOutOfBoundsException"); 
     } catch (final IndexOutOfBoundsException e) { 
     } 
     try { 
         sb.append(new StringBuffer("bar"), 4, 0); 
         fail("append(char[], 4, 0) expected IndexOutOfBoundsException"); 
     } catch (final IndexOutOfBoundsException e) { 
     } 
     sb.append(new StringBuffer("bar"), 3, 0); 
     assertEquals("foo", sb.toString()); 
     sb.append(new StringBuffer("abcbardef"), 3, 3); 
     assertEquals("foobar", sb.toString()); 
 }
@Test
public void testAppendFixedWidthPadLeft_int3826() { 
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
public void testAppendWithSeparators_Iterator3931() { 
     final StrBuilder sb = new StrBuilder(); 
     sb.appendWithSeparators((Iterator<?>) null, ","); 
     assertEquals("", sb.toString()); 
     sb.clear(); 
     sb.appendWithSeparators(Collections.EMPTY_LIST.iterator(), ","); 
     assertEquals("", sb.toString()); 
     sb.clear(); 
     sb.appendWithSeparators(Arrays.asList(new Object[] { "foo", "bar", "baz" }).iterator(), ","); 
     assertEquals("foo,bar,baz", sb.toString()); 
     sb.clear(); 
     sb.appendWithSeparators(Arrays.asList(new Object[] { "foo", "bar", "baz" }).iterator(), null); 
     assertEquals("foobarbaz", sb.toString()); 
     sb.clear(); 
     sb.appendWithSeparators(Arrays.asList(new Object[] { "foo", null, "baz" }).iterator(), ","); 
     assertEquals("foo,,baz", sb.toString()); 
 }
@Test
public void testAppend_CharArray3966() { 
     StrBuilder sb = new StrBuilder(); 
     sb.setNullText("NULL").append((char[]) null); 
     assertEquals("NULL", sb.toString()); 
     sb = new StrBuilder(); 
     sb.append(new char[0]); 
     assertEquals("", sb.toString()); 
     sb.append(new char[] { 'f', 'o', 'o' }); 
     assertEquals("foo", sb.toString()); 
 }
@Test
public void testAppendFixedWidthPadLeft_int3996() { 
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
public void testAppendln_StringBuffer4138() { 
     final int[] count = new int[2]; 
     final StrBuilder sb = new StrBuilder() { 
  
         @Override 
         public StrBuilder append(final StringBuffer str) { 
             count[0]++; 
             return super.append(str); 
         } 
  
         @Override 
         public StrBuilder appendNewLine() { 
             count[1]++; 
             return super.appendNewLine(); 
         } 
     }; 
     sb.appendln(new StringBuffer("foo")); 
     assertEquals("foo" + SEP, sb.toString()); 
     assertEquals(1, count[0]); 
     assertEquals(1, count[1]); 
 }
@Test
public void testAppend_CharArray4164() { 
     StrBuilder sb = new StrBuilder(); 
     sb.setNullText("NULL").append((char[]) null); 
     assertEquals("NULL", sb.toString()); 
     sb = new StrBuilder(); 
     sb.append(new char[0]); 
     assertEquals("", sb.toString()); 
     sb.append(new char[] { 'f', 'o', 'o' }); 
     assertEquals("foo", sb.toString()); 
 }
@Test
public void testAppendAll_Collection4223() { 
     final StrBuilder sb = new StrBuilder(); 
     sb.appendAll((Collection<?>) null); 
     assertEquals("", sb.toString()); 
     sb.clear(); 
     sb.appendAll(Collections.EMPTY_LIST); 
     assertEquals("", sb.toString()); 
     sb.clear(); 
     sb.appendAll(Arrays.asList(new Object[] { "foo", "bar", "baz" })); 
     assertEquals("foobarbaz", sb.toString()); 
 }
@Test
public void testAppendln_String_int_int4251() { 
     final int[] count = new int[2]; 
     final StrBuilder sb = new StrBuilder() { 
  
         @Override 
         public StrBuilder append(final String str, final int startIndex, final int length) { 
             count[0]++; 
             return super.append(str, startIndex, length); 
         } 
  
         @Override 
         public StrBuilder appendNewLine() { 
             count[1]++; 
             return super.appendNewLine(); 
         } 
     }; 
     sb.appendln("foo", 0, 3); 
     assertEquals("foo" + SEP, sb.toString()); 
     assertEquals(1, count[0]); 
     assertEquals(1, count[1]); 
 }
@Test
public void testAppendSeparator_char_int4373() { 
     final StrBuilder sb = new StrBuilder(); 
     sb.appendSeparator(',', 0); 
     assertEquals("", sb.toString()); 
     sb.append("foo"); 
     assertEquals("foo", sb.toString()); 
     sb.appendSeparator(',', 1); 
     assertEquals("foo,", sb.toString()); 
     sb.appendSeparator(',', -1); 
     assertEquals("foo,", sb.toString()); 
 }
@Test
public void testAppendFixedWidthPadLeft_int4382() { 
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
public void testAppend_PrimitiveNumber4394() { 
     final StrBuilder sb = new StrBuilder(); 
     sb.append(0); 
     assertEquals("0", sb.toString()); 
     sb.append(1L); 
     assertEquals("01", sb.toString()); 
     sb.append(2.3f); 
     assertEquals("012.3", sb.toString()); 
     sb.append(4.5d); 
     assertEquals("012.34.5", sb.toString()); 
 }
@Test
public void testAppend_PrimitiveNumber4413() { 
     final StrBuilder sb = new StrBuilder(); 
     sb.append(0); 
     assertEquals("0", sb.toString()); 
     sb.append(1L); 
     assertEquals("01", sb.toString()); 
     sb.append(2.3f); 
     assertEquals("012.3", sb.toString()); 
     sb.append(4.5d); 
     assertEquals("012.34.5", sb.toString()); 
 }
@Test
public void testAppendAll_Iterator4489() { 
     final StrBuilder sb = new StrBuilder(); 
     sb.appendAll((Iterator<?>) null); 
     assertEquals("", sb.toString()); 
     sb.clear(); 
     sb.appendAll(Collections.EMPTY_LIST.iterator()); 
     assertEquals("", sb.toString()); 
     sb.clear(); 
     sb.appendAll(Arrays.asList(new Object[] { "foo", "bar", "baz" }).iterator()); 
     assertEquals("foobarbaz", sb.toString()); 
 }
@Test
public void testAppendSeparator_char4553() { 
     final StrBuilder sb = new StrBuilder(); 
     sb.appendSeparator(','); 
     assertEquals("", sb.toString()); 
     sb.append("foo"); 
     assertEquals("foo", sb.toString()); 
     sb.appendSeparator(','); 
     assertEquals("foo,", sb.toString()); 
 }
@Test
public void testAppend_StrBuilder4598() { 
     StrBuilder sb = new StrBuilder(); 
     sb.setNullText("NULL").append((StrBuilder) null); 
     assertEquals("NULL", sb.toString()); 
     sb = new StrBuilder(); 
     sb.append(new StrBuilder("foo")); 
     assertEquals("foo", sb.toString()); 
     sb.append(new StrBuilder("")); 
     assertEquals("foo", sb.toString()); 
     sb.append(new StrBuilder("bar")); 
     assertEquals("foobar", sb.toString()); 
 }
@Test
public void testLang2994643() { 
     final StrBuilder sb = new StrBuilder(1); 
     sb.appendFixedWidthPadRight("foo", 1, '-'); 
     assertEquals("f", sb.toString()); 
 }
@Test
public void testAppendSeparator_char_char4646() { 
     final StrBuilder sb = new StrBuilder(); 
     final char startSeparator = ':'; 
     final char standardSeparator = ','; 
     final String foo = "foo"; 
     sb.appendSeparator(standardSeparator, startSeparator); 
     assertEquals(String.valueOf(startSeparator), sb.toString()); 
     sb.append(foo); 
     assertEquals(String.valueOf(startSeparator) + foo, sb.toString()); 
     sb.appendSeparator(standardSeparator, startSeparator); 
     assertEquals(String.valueOf(startSeparator) + foo + standardSeparator, sb.toString()); 
 }
@Test
public void testAppendSeparator_String_int4691() { 
     final StrBuilder sb = new StrBuilder(); 
     sb.appendSeparator(",", 0); 
     assertEquals("", sb.toString()); 
     sb.append("foo"); 
     assertEquals("foo", sb.toString()); 
     sb.appendSeparator(",", 1); 
     assertEquals("foo,", sb.toString()); 
     sb.appendSeparator(",", -1); 
     assertEquals("foo,", sb.toString()); 
 }
@Test
public void testAppendFixedWidthPadRight_int4708() { 
     final StrBuilder sb = new StrBuilder(); 
     sb.appendFixedWidthPadRight(123, -1, '-'); 
     assertEquals("", sb.toString()); 
     sb.clear(); 
     sb.appendFixedWidthPadRight(123, 0, '-'); 
     assertEquals("", sb.toString()); 
     sb.clear(); 
     sb.appendFixedWidthPadRight(123, 1, '-'); 
     assertEquals("1", sb.toString()); 
     sb.clear(); 
     sb.appendFixedWidthPadRight(123, 2, '-'); 
     assertEquals("12", sb.toString()); 
     sb.clear(); 
     sb.appendFixedWidthPadRight(123, 3, '-'); 
     assertEquals("123", sb.toString()); 
     sb.clear(); 
     sb.appendFixedWidthPadRight(123, 4, '-'); 
     assertEquals("123-", sb.toString()); 
     sb.clear(); 
     sb.appendFixedWidthPadRight(123, 10, '-'); 
     assertEquals(10, sb.length()); 
     assertEquals("123-------", sb.toString()); 
 }
@Test
public void testAppendFixedWidthPadLeft_int4735() { 
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
public void testAppendln_Boolean4861() { 
     final StrBuilder sb = new StrBuilder(); 
     sb.appendln(true); 
     assertEquals("true" + SEP, sb.toString()); 
     sb.clear(); 
     sb.appendln(false); 
     assertEquals("false" + SEP, sb.toString()); 
 }
@Test
public void testAppend_Object4890() { 
     final StrBuilder sb = new StrBuilder(); 
     sb.appendNull(); 
     assertEquals("", sb.toString()); 
     sb.append((Object) null); 
     assertEquals("", sb.toString()); 
     sb.append(FOO); 
     assertEquals("foo", sb.toString()); 
     sb.append((StringBuffer) null); 
     assertEquals("foo", sb.toString()); 
     sb.append(new StringBuffer("baz")); 
     assertEquals("foobaz", sb.toString()); 
     sb.append(new StrBuilder("yes")); 
     assertEquals("foobazyes", sb.toString()); 
     sb.append((CharSequence) "Seq"); 
     assertEquals("foobazyesSeq", sb.toString()); 
     sb.append(new StringBuilder("bld")); 
     assertEquals("foobazyesSeqbld", sb.toString()); 
 }
@Test
public void testAppend_StringBuffer_int_int4925() { 
     StrBuilder sb = new StrBuilder(); 
     sb.setNullText("NULL").append((StringBuffer) null, 0, 1); 
     assertEquals("NULL", sb.toString()); 
     sb = new StrBuilder(); 
     sb.append(new StringBuffer("foo"), 0, 3); 
     assertEquals("foo", sb.toString()); 
     try { 
         sb.append(new StringBuffer("bar"), -1, 1); 
         fail("append(char[], -1,) expected IndexOutOfBoundsException"); 
     } catch (final IndexOutOfBoundsException e) { 
     } 
     try { 
         sb.append(new StringBuffer("bar"), 3, 1); 
         fail("append(char[], 3,) expected IndexOutOfBoundsException"); 
     } catch (final IndexOutOfBoundsException e) { 
     } 
     try { 
         sb.append(new StringBuffer("bar"), 1, -1); 
         fail("append(char[],, -1) expected IndexOutOfBoundsException"); 
     } catch (final IndexOutOfBoundsException e) { 
     } 
     try { 
         sb.append(new StringBuffer("bar"), 1, 3); 
         fail("append(char[], 1, 3) expected IndexOutOfBoundsException"); 
     } catch (final IndexOutOfBoundsException e) { 
     } 
     try { 
         sb.append(new StringBuffer("bar"), -1, 3); 
         fail("append(char[], -1, 3) expected IndexOutOfBoundsException"); 
     } catch (final IndexOutOfBoundsException e) { 
     } 
     try { 
         sb.append(new StringBuffer("bar"), 4, 0); 
         fail("append(char[], 4, 0) expected IndexOutOfBoundsException"); 
     } catch (final IndexOutOfBoundsException e) { 
     } 
     sb.append(new StringBuffer("bar"), 3, 0); 
     assertEquals("foo", sb.toString()); 
     sb.append(new StringBuffer("abcbardef"), 3, 3); 
     assertEquals("foobar", sb.toString()); 
 }
@Test
public void testAppendPadding4935() { 
     final StrBuilder sb = new StrBuilder(); 
     sb.append("foo"); 
     assertEquals("foo", sb.toString()); 
     sb.appendPadding(-1, '-'); 
     assertEquals("foo", sb.toString()); 
     sb.appendPadding(0, '-'); 
     assertEquals("foo", sb.toString()); 
     sb.appendPadding(1, '-'); 
     assertEquals("foo-", sb.toString()); 
     sb.appendPadding(16, '-'); 
     assertEquals(20, sb.length()); 
     assertEquals("foo-----------------", sb.toString()); 
 }
@Test
public void testAppendAll_Collection4994() { 
     final StrBuilder sb = new StrBuilder(); 
     sb.appendAll((Collection<?>) null); 
     assertEquals("", sb.toString()); 
     sb.clear(); 
     sb.appendAll(Collections.EMPTY_LIST); 
     assertEquals("", sb.toString()); 
     sb.clear(); 
     sb.appendAll(Arrays.asList(new Object[] { "foo", "bar", "baz" })); 
     assertEquals("foobarbaz", sb.toString()); 
 }
@Test
public void testAppendWithSeparatorsWithNullText5020() { 
     final StrBuilder sb = new StrBuilder(); 
     sb.setNullText("null"); 
     sb.appendWithSeparators(new Object[] { "foo", null, "baz" }, ","); 
     assertEquals("foo,null,baz", sb.toString()); 
     sb.clear(); 
     sb.appendWithSeparators(Arrays.asList(new Object[] { "foo", null, "baz" }), ","); 
     assertEquals("foo,null,baz", sb.toString()); 
 }
@Test
public void testAppend_CharArray5054() { 
     StrBuilder sb = new StrBuilder(); 
     sb.setNullText("NULL").append((char[]) null); 
     assertEquals("NULL", sb.toString()); 
     sb = new StrBuilder(); 
     sb.append(new char[0]); 
     assertEquals("", sb.toString()); 
     sb.append(new char[] { 'f', 'o', 'o' }); 
     assertEquals("foo", sb.toString()); 
 }
@Test
public void testAppendln_PrimitiveNumber5074() { 
     final StrBuilder sb = new StrBuilder(); 
     sb.appendln(0); 
     assertEquals("0" + SEP, sb.toString()); 
     sb.clear(); 
     sb.appendln(1L); 
     assertEquals("1" + SEP, sb.toString()); 
     sb.clear(); 
     sb.appendln(2.3f); 
     assertEquals("2.3" + SEP, sb.toString()); 
     sb.clear(); 
     sb.appendln(4.5d); 
     assertEquals("4.5" + SEP, sb.toString()); 
 }
@Test
public void testAppendln_StringBuilder_int_int5177() { 
     final int[] count = new int[2]; 
     final StrBuilder sb = new StrBuilder() { 
  
         @Override 
         public StrBuilder append(final StringBuilder str, final int startIndex, final int length) { 
             count[0]++; 
             return super.append(str, startIndex, length); 
         } 
  
         @Override 
         public StrBuilder appendNewLine() { 
             count[1]++; 
             return super.appendNewLine(); 
         } 
     }; 
     sb.appendln(new StringBuilder("foo"), 0, 3); 
     assertEquals("foo" + SEP, sb.toString()); 
     assertEquals(1, count[0]); 
     assertEquals(1, count[1]); 
 }
@Test
public void testAppend_CharArray5215() { 
     StrBuilder sb = new StrBuilder(); 
     sb.setNullText("NULL").append((char[]) null); 
     assertEquals("NULL", sb.toString()); 
     sb = new StrBuilder(); 
     sb.append(new char[0]); 
     assertEquals("", sb.toString()); 
     sb.append(new char[] { 'f', 'o', 'o' }); 
     assertEquals("foo", sb.toString()); 
 }
@Test
public void testAppendln_StrBuilder_int_int5240() { 
     final int[] count = new int[2]; 
     final StrBuilder sb = new StrBuilder() { 
  
         @Override 
         public StrBuilder append(final StrBuilder str, final int startIndex, final int length) { 
             count[0]++; 
             return super.append(str, startIndex, length); 
         } 
  
         @Override 
         public StrBuilder appendNewLine() { 
             count[1]++; 
             return super.appendNewLine(); 
         } 
     }; 
     sb.appendln(new StrBuilder("foo"), 0, 3); 
     assertEquals("foo" + SEP, sb.toString()); 
     assertEquals(1, count[0]); 
     assertEquals(1, count[1]); 
 }
@Test
public void testAppendFixedWidthPadLeft_int5274() { 
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
public void testAppendSeparator_char5364() { 
     final StrBuilder sb = new StrBuilder(); 
     sb.appendSeparator(','); 
     assertEquals("", sb.toString()); 
     sb.append("foo"); 
     assertEquals("foo", sb.toString()); 
     sb.appendSeparator(','); 
     assertEquals("foo,", sb.toString()); 
 }
@Test
public void testAppend_CharArray5385() { 
     StrBuilder sb = new StrBuilder(); 
     sb.setNullText("NULL").append((char[]) null); 
     assertEquals("NULL", sb.toString()); 
     sb = new StrBuilder(); 
     sb.append(new char[0]); 
     assertEquals("", sb.toString()); 
     sb.append(new char[] { 'f', 'o', 'o' }); 
     assertEquals("foo", sb.toString()); 
 }
@Test
public void testAppendPadding5389() { 
     final StrBuilder sb = new StrBuilder(); 
     sb.append("foo"); 
     assertEquals("foo", sb.toString()); 
     sb.appendPadding(-1, '-'); 
     assertEquals("foo", sb.toString()); 
     sb.appendPadding(0, '-'); 
     assertEquals("foo", sb.toString()); 
     sb.appendPadding(1, '-'); 
     assertEquals("foo-", sb.toString()); 
     sb.appendPadding(16, '-'); 
     assertEquals(20, sb.length()); 
     assertEquals("foo-----------------", sb.toString()); 
 }
@Test
public void testAppendWithSeparatorsWithNullText5440() { 
     final StrBuilder sb = new StrBuilder(); 
     sb.setNullText("null"); 
     sb.appendWithSeparators(new Object[] { "foo", null, "baz" }, ","); 
     assertEquals("foo,null,baz", sb.toString()); 
     sb.clear(); 
     sb.appendWithSeparators(Arrays.asList(new Object[] { "foo", null, "baz" }), ","); 
     assertEquals("foo,null,baz", sb.toString()); 
 }
@Test
public void testAppend_CharArray5469() { 
     StrBuilder sb = new StrBuilder(); 
     sb.setNullText("NULL").append((char[]) null); 
     assertEquals("NULL", sb.toString()); 
     sb = new StrBuilder(); 
     sb.append(new char[0]); 
     assertEquals("", sb.toString()); 
     sb.append(new char[] { 'f', 'o', 'o' }); 
     assertEquals("foo", sb.toString()); 
 }
@Test
public void testAppend_StrBuilder5511() { 
     StrBuilder sb = new StrBuilder(); 
     sb.setNullText("NULL").append((StrBuilder) null); 
     assertEquals("NULL", sb.toString()); 
     sb = new StrBuilder(); 
     sb.append(new StrBuilder("foo")); 
     assertEquals("foo", sb.toString()); 
     sb.append(new StrBuilder("")); 
     assertEquals("foo", sb.toString()); 
     sb.append(new StrBuilder("bar")); 
     assertEquals("foobar", sb.toString()); 
 }
@Test
public void testAppendln_StrBuilder_int_int5554() { 
     final int[] count = new int[2]; 
     final StrBuilder sb = new StrBuilder() { 
  
         @Override 
         public StrBuilder append(final StrBuilder str, final int startIndex, final int length) { 
             count[0]++; 
             return super.append(str, startIndex, length); 
         } 
  
         @Override 
         public StrBuilder appendNewLine() { 
             count[1]++; 
             return super.appendNewLine(); 
         } 
     }; 
     sb.appendln(new StrBuilder("foo"), 0, 3); 
     assertEquals("foo" + SEP, sb.toString()); 
     assertEquals(1, count[0]); 
     assertEquals(1, count[1]); 
 }
@Test
public void testAppendln_StringBuffer5569() { 
     final int[] count = new int[2]; 
     final StrBuilder sb = new StrBuilder() { 
  
         @Override 
         public StrBuilder append(final StringBuffer str) { 
             count[0]++; 
             return super.append(str); 
         } 
  
         @Override 
         public StrBuilder appendNewLine() { 
             count[1]++; 
             return super.appendNewLine(); 
         } 
     }; 
     sb.appendln(new StringBuffer("foo")); 
     assertEquals("foo" + SEP, sb.toString()); 
     assertEquals(1, count[0]); 
     assertEquals(1, count[1]); 
 }
@Test
public void testAppend_PrimitiveNumber5585() { 
     final StrBuilder sb = new StrBuilder(); 
     sb.append(0); 
     assertEquals("0", sb.toString()); 
     sb.append(1L); 
     assertEquals("01", sb.toString()); 
     sb.append(2.3f); 
     assertEquals("012.3", sb.toString()); 
     sb.append(4.5d); 
     assertEquals("012.34.5", sb.toString()); 
 }
@Test
public void testAppendWithSeparators_Iterator5591() { 
     final StrBuilder sb = new StrBuilder(); 
     sb.appendWithSeparators((Iterator<?>) null, ","); 
     assertEquals("", sb.toString()); 
     sb.clear(); 
     sb.appendWithSeparators(Collections.EMPTY_LIST.iterator(), ","); 
     assertEquals("", sb.toString()); 
     sb.clear(); 
     sb.appendWithSeparators(Arrays.asList(new Object[] { "foo", "bar", "baz" }).iterator(), ","); 
     assertEquals("foo,bar,baz", sb.toString()); 
     sb.clear(); 
     sb.appendWithSeparators(Arrays.asList(new Object[] { "foo", "bar", "baz" }).iterator(), null); 
     assertEquals("foobarbaz", sb.toString()); 
     sb.clear(); 
     sb.appendWithSeparators(Arrays.asList(new Object[] { "foo", null, "baz" }).iterator(), ","); 
     assertEquals("foo,,baz", sb.toString()); 
 }
@Test
public void testAppendAll_Collection5622() { 
     final StrBuilder sb = new StrBuilder(); 
     sb.appendAll((Collection<?>) null); 
     assertEquals("", sb.toString()); 
     sb.clear(); 
     sb.appendAll(Collections.EMPTY_LIST); 
     assertEquals("", sb.toString()); 
     sb.clear(); 
     sb.appendAll(Arrays.asList(new Object[] { "foo", "bar", "baz" })); 
     assertEquals("foobarbaz", sb.toString()); 
 }
@Test
public void testAppendSeparator_String5645() { 
     final StrBuilder sb = new StrBuilder(); 
     sb.appendSeparator(","); 
     assertEquals("", sb.toString()); 
     sb.append("foo"); 
     assertEquals("foo", sb.toString()); 
     sb.appendSeparator(","); 
     assertEquals("foo,", sb.toString()); 
 }
@Test
public void testAppend_CharArray_int_int5678() { 
     StrBuilder sb = new StrBuilder(); 
     sb.setNullText("NULL").append((char[]) null, 0, 1); 
     assertEquals("NULL", sb.toString()); 
     sb = new StrBuilder(); 
     sb.append(new char[] { 'f', 'o', 'o' }, 0, 3); 
     assertEquals("foo", sb.toString()); 
     try { 
         sb.append(new char[] { 'b', 'a', 'r' }, -1, 1); 
         fail("append(char[], -1,) expected IndexOutOfBoundsException"); 
     } catch (final IndexOutOfBoundsException e) { 
     } 
     try { 
         sb.append(new char[] { 'b', 'a', 'r' }, 3, 1); 
         fail("append(char[], 3,) expected IndexOutOfBoundsException"); 
     } catch (final IndexOutOfBoundsException e) { 
     } 
     try { 
         sb.append(new char[] { 'b', 'a', 'r' }, 1, -1); 
         fail("append(char[],, -1) expected IndexOutOfBoundsException"); 
     } catch (final IndexOutOfBoundsException e) { 
     } 
     try { 
         sb.append(new char[] { 'b', 'a', 'r' }, 1, 3); 
         fail("append(char[], 1, 3) expected IndexOutOfBoundsException"); 
     } catch (final IndexOutOfBoundsException e) { 
     } 
     try { 
         sb.append(new char[] { 'b', 'a', 'r' }, -1, 3); 
         fail("append(char[], -1, 3) expected IndexOutOfBoundsException"); 
     } catch (final IndexOutOfBoundsException e) { 
     } 
     try { 
         sb.append(new char[] { 'b', 'a', 'r' }, 4, 0); 
         fail("append(char[], 4, 0) expected IndexOutOfBoundsException"); 
     } catch (final IndexOutOfBoundsException e) { 
     } 
     sb.append(new char[] { 'b', 'a', 'r' }, 3, 0); 
     assertEquals("foo", sb.toString()); 
     sb.append(new char[] { 'a', 'b', 'c', 'b', 'a', 'r', 'd', 'e', 'f' }, 3, 3); 
     assertEquals("foobar", sb.toString()); 
 }
@Test
public void testAppend_StringBuffer_int_int5733() { 
     StrBuilder sb = new StrBuilder(); 
     sb.setNullText("NULL").append((StringBuffer) null, 0, 1); 
     assertEquals("NULL", sb.toString()); 
     sb = new StrBuilder(); 
     sb.append(new StringBuffer("foo"), 0, 3); 
     assertEquals("foo", sb.toString()); 
     try { 
         sb.append(new StringBuffer("bar"), -1, 1); 
         fail("append(char[], -1,) expected IndexOutOfBoundsException"); 
     } catch (final IndexOutOfBoundsException e) { 
     } 
     try { 
         sb.append(new StringBuffer("bar"), 3, 1); 
         fail("append(char[], 3,) expected IndexOutOfBoundsException"); 
     } catch (final IndexOutOfBoundsException e) { 
     } 
     try { 
         sb.append(new StringBuffer("bar"), 1, -1); 
         fail("append(char[],, -1) expected IndexOutOfBoundsException"); 
     } catch (final IndexOutOfBoundsException e) { 
     } 
     try { 
         sb.append(new StringBuffer("bar"), 1, 3); 
         fail("append(char[], 1, 3) expected IndexOutOfBoundsException"); 
     } catch (final IndexOutOfBoundsException e) { 
     } 
     try { 
         sb.append(new StringBuffer("bar"), -1, 3); 
         fail("append(char[], -1, 3) expected IndexOutOfBoundsException"); 
     } catch (final IndexOutOfBoundsException e) { 
     } 
     try { 
         sb.append(new StringBuffer("bar"), 4, 0); 
         fail("append(char[], 4, 0) expected IndexOutOfBoundsException"); 
     } catch (final IndexOutOfBoundsException e) { 
     } 
     sb.append(new StringBuffer("bar"), 3, 0); 
     assertEquals("foo", sb.toString()); 
     sb.append(new StringBuffer("abcbardef"), 3, 3); 
     assertEquals("foobar", sb.toString()); 
 }
@Test
public void testAppendln_StringBuilder_int_int5782() { 
     final int[] count = new int[2]; 
     final StrBuilder sb = new StrBuilder() { 
  
         @Override 
         public StrBuilder append(final StringBuilder str, final int startIndex, final int length) { 
             count[0]++; 
             return super.append(str, startIndex, length); 
         } 
  
         @Override 
         public StrBuilder appendNewLine() { 
             count[1]++; 
             return super.appendNewLine(); 
         } 
     }; 
     sb.appendln(new StringBuilder("foo"), 0, 3); 
     assertEquals("foo" + SEP, sb.toString()); 
     assertEquals(1, count[0]); 
     assertEquals(1, count[1]); 
 }
@Test
public void testAppendWithSeparatorsWithNullText5789() { 
     final StrBuilder sb = new StrBuilder(); 
     sb.setNullText("null"); 
     sb.appendWithSeparators(new Object[] { "foo", null, "baz" }, ","); 
     assertEquals("foo,null,baz", sb.toString()); 
     sb.clear(); 
     sb.appendWithSeparators(Arrays.asList(new Object[] { "foo", null, "baz" }), ","); 
     assertEquals("foo,null,baz", sb.toString()); 
 }
@Test
public void testAppend_StringBuilder5799() { 
     StrBuilder sb = new StrBuilder(); 
     sb.setNullText("NULL").append((String) null); 
     assertEquals("NULL", sb.toString()); 
     sb = new StrBuilder(); 
     sb.append(new StringBuilder("foo")); 
     assertEquals("foo", sb.toString()); 
     sb.append(new StringBuilder("")); 
     assertEquals("foo", sb.toString()); 
     sb.append(new StringBuilder("bar")); 
     assertEquals("foobar", sb.toString()); 
 }
@Test
public void testAppendWithSeparatorsWithNullText5843() { 
     final StrBuilder sb = new StrBuilder(); 
     sb.setNullText("null"); 
     sb.appendWithSeparators(new Object[] { "foo", null, "baz" }, ","); 
     assertEquals("foo,null,baz", sb.toString()); 
     sb.clear(); 
     sb.appendWithSeparators(Arrays.asList(new Object[] { "foo", null, "baz" }), ","); 
     assertEquals("foo,null,baz", sb.toString()); 
 }
@Test
public void testAppendln_StringBuilder_int_int5899() { 
     final int[] count = new int[2]; 
     final StrBuilder sb = new StrBuilder() { 
  
         @Override 
         public StrBuilder append(final StringBuilder str, final int startIndex, final int length) { 
             count[0]++; 
             return super.append(str, startIndex, length); 
         } 
  
         @Override 
         public StrBuilder appendNewLine() { 
             count[1]++; 
             return super.appendNewLine(); 
         } 
     }; 
     sb.appendln(new StringBuilder("foo"), 0, 3); 
     assertEquals("foo" + SEP, sb.toString()); 
     assertEquals(1, count[0]); 
     assertEquals(1, count[1]); 
 }
@Test
public void testAppendWithSeparatorsWithNullText5907() { 
     final StrBuilder sb = new StrBuilder(); 
     sb.setNullText("null"); 
     sb.appendWithSeparators(new Object[] { "foo", null, "baz" }, ","); 
     assertEquals("foo,null,baz", sb.toString()); 
     sb.clear(); 
     sb.appendWithSeparators(Arrays.asList(new Object[] { "foo", null, "baz" }), ","); 
     assertEquals("foo,null,baz", sb.toString()); 
 }
@Test
public void testAppendWithSeparators_Collection6006() { 
     final StrBuilder sb = new StrBuilder(); 
     sb.appendWithSeparators((Collection<?>) null, ","); 
     assertEquals("", sb.toString()); 
     sb.clear(); 
     sb.appendWithSeparators(Collections.EMPTY_LIST, ","); 
     assertEquals("", sb.toString()); 
     sb.clear(); 
     sb.appendWithSeparators(Arrays.asList(new Object[] { "foo", "bar", "baz" }), ","); 
     assertEquals("foo,bar,baz", sb.toString()); 
     sb.clear(); 
     sb.appendWithSeparators(Arrays.asList(new Object[] { "foo", "bar", "baz" }), null); 
     assertEquals("foobarbaz", sb.toString()); 
     sb.clear(); 
     sb.appendWithSeparators(Arrays.asList(new Object[] { "foo", null, "baz" }), ","); 
     assertEquals("foo,,baz", sb.toString()); 
 }
@Test
public void testAppendln_StringBuilder_int_int6032() { 
     final int[] count = new int[2]; 
     final StrBuilder sb = new StrBuilder() { 
  
         @Override 
         public StrBuilder append(final StringBuilder str, final int startIndex, final int length) { 
             count[0]++; 
             return super.append(str, startIndex, length); 
         } 
  
         @Override 
         public StrBuilder appendNewLine() { 
             count[1]++; 
             return super.appendNewLine(); 
         } 
     }; 
     sb.appendln(new StringBuilder("foo"), 0, 3); 
     assertEquals("foo" + SEP, sb.toString()); 
     assertEquals(1, count[0]); 
     assertEquals(1, count[1]); 
 }
@Test
public void testAppendln_PrimitiveNumber6108() { 
     final StrBuilder sb = new StrBuilder(); 
     sb.appendln(0); 
     assertEquals("0" + SEP, sb.toString()); 
     sb.clear(); 
     sb.appendln(1L); 
     assertEquals("1" + SEP, sb.toString()); 
     sb.clear(); 
     sb.appendln(2.3f); 
     assertEquals("2.3" + SEP, sb.toString()); 
     sb.clear(); 
     sb.appendln(4.5d); 
     assertEquals("4.5" + SEP, sb.toString()); 
 }
@Test
public void testAppendln_CharArray6144() { 
     final int[] count = new int[2]; 
     final StrBuilder sb = new StrBuilder() { 
  
         @Override 
         public StrBuilder append(final char[] str) { 
             count[0]++; 
             return super.append(str); 
         } 
  
         @Override 
         public StrBuilder appendNewLine() { 
             count[1]++; 
             return super.appendNewLine(); 
         } 
     }; 
     sb.appendln("foo".toCharArray()); 
     assertEquals("foo" + SEP, sb.toString()); 
     assertEquals(1, count[0]); 
     assertEquals(1, count[1]); 
 }
@Test
public void testAppendln_Boolean6287() { 
     final StrBuilder sb = new StrBuilder(); 
     sb.appendln(true); 
     assertEquals("true" + SEP, sb.toString()); 
     sb.clear(); 
     sb.appendln(false); 
     assertEquals("false" + SEP, sb.toString()); 
 }
@Test
public void testAppendln_Boolean6369() { 
     final StrBuilder sb = new StrBuilder(); 
     sb.appendln(true); 
     assertEquals("true" + SEP, sb.toString()); 
     sb.clear(); 
     sb.appendln(false); 
     assertEquals("false" + SEP, sb.toString()); 
 }
@Test
public void testAppendWithSeparatorsWithNullText6443() { 
     final StrBuilder sb = new StrBuilder(); 
     sb.setNullText("null"); 
     sb.appendWithSeparators(new Object[] { "foo", null, "baz" }, ","); 
     assertEquals("foo,null,baz", sb.toString()); 
     sb.clear(); 
     sb.appendWithSeparators(Arrays.asList(new Object[] { "foo", null, "baz" }), ","); 
     assertEquals("foo,null,baz", sb.toString()); 
 }
@Test
public void testAppend_StrBuilder_int_int6449() { 
     StrBuilder sb = new StrBuilder(); 
     sb.setNullText("NULL").append((StrBuilder) null, 0, 1); 
     assertEquals("NULL", sb.toString()); 
     sb = new StrBuilder(); 
     sb.append(new StrBuilder("foo"), 0, 3); 
     assertEquals("foo", sb.toString()); 
     try { 
         sb.append(new StrBuilder("bar"), -1, 1); 
         fail("append(char[], -1,) expected IndexOutOfBoundsException"); 
     } catch (final IndexOutOfBoundsException e) { 
     } 
     try { 
         sb.append(new StrBuilder("bar"), 3, 1); 
         fail("append(char[], 3,) expected IndexOutOfBoundsException"); 
     } catch (final IndexOutOfBoundsException e) { 
     } 
     try { 
         sb.append(new StrBuilder("bar"), 1, -1); 
         fail("append(char[],, -1) expected IndexOutOfBoundsException"); 
     } catch (final IndexOutOfBoundsException e) { 
     } 
     try { 
         sb.append(new StrBuilder("bar"), 1, 3); 
         fail("append(char[], 1, 3) expected IndexOutOfBoundsException"); 
     } catch (final IndexOutOfBoundsException e) { 
     } 
     try { 
         sb.append(new StrBuilder("bar"), -1, 3); 
         fail("append(char[], -1, 3) expected IndexOutOfBoundsException"); 
     } catch (final IndexOutOfBoundsException e) { 
     } 
     try { 
         sb.append(new StrBuilder("bar"), 4, 0); 
         fail("append(char[], 4, 0) expected IndexOutOfBoundsException"); 
     } catch (final IndexOutOfBoundsException e) { 
     } 
     sb.append(new StrBuilder("bar"), 3, 0); 
     assertEquals("foo", sb.toString()); 
     sb.append(new StrBuilder("abcbardef"), 3, 3); 
     assertEquals("foobar", sb.toString()); 
 }
@Test
public void testAppendln_Boolean6516() { 
     final StrBuilder sb = new StrBuilder(); 
     sb.appendln(true); 
     assertEquals("true" + SEP, sb.toString()); 
     sb.clear(); 
     sb.appendln(false); 
     assertEquals("false" + SEP, sb.toString()); 
 }
@Test
public void testAppend_CharArray_int_int6523() { 
     StrBuilder sb = new StrBuilder(); 
     sb.setNullText("NULL").append((char[]) null, 0, 1); 
     assertEquals("NULL", sb.toString()); 
     sb = new StrBuilder(); 
     sb.append(new char[] { 'f', 'o', 'o' }, 0, 3); 
     assertEquals("foo", sb.toString()); 
     try { 
         sb.append(new char[] { 'b', 'a', 'r' }, -1, 1); 
         fail("append(char[], -1,) expected IndexOutOfBoundsException"); 
     } catch (final IndexOutOfBoundsException e) { 
     } 
     try { 
         sb.append(new char[] { 'b', 'a', 'r' }, 3, 1); 
         fail("append(char[], 3,) expected IndexOutOfBoundsException"); 
     } catch (final IndexOutOfBoundsException e) { 
     } 
     try { 
         sb.append(new char[] { 'b', 'a', 'r' }, 1, -1); 
         fail("append(char[],, -1) expected IndexOutOfBoundsException"); 
     } catch (final IndexOutOfBoundsException e) { 
     } 
     try { 
         sb.append(new char[] { 'b', 'a', 'r' }, 1, 3); 
         fail("append(char[], 1, 3) expected IndexOutOfBoundsException"); 
     } catch (final IndexOutOfBoundsException e) { 
     } 
     try { 
         sb.append(new char[] { 'b', 'a', 'r' }, -1, 3); 
         fail("append(char[], -1, 3) expected IndexOutOfBoundsException"); 
     } catch (final IndexOutOfBoundsException e) { 
     } 
     try { 
         sb.append(new char[] { 'b', 'a', 'r' }, 4, 0); 
         fail("append(char[], 4, 0) expected IndexOutOfBoundsException"); 
     } catch (final IndexOutOfBoundsException e) { 
     } 
     sb.append(new char[] { 'b', 'a', 'r' }, 3, 0); 
     assertEquals("foo", sb.toString()); 
     sb.append(new char[] { 'a', 'b', 'c', 'b', 'a', 'r', 'd', 'e', 'f' }, 3, 3); 
     assertEquals("foobar", sb.toString()); 
 }
@Test
public void testAppendWithSeparators_Iterator6543() { 
     final StrBuilder sb = new StrBuilder(); 
     sb.appendWithSeparators((Iterator<?>) null, ","); 
     assertEquals("", sb.toString()); 
     sb.clear(); 
     sb.appendWithSeparators(Collections.EMPTY_LIST.iterator(), ","); 
     assertEquals("", sb.toString()); 
     sb.clear(); 
     sb.appendWithSeparators(Arrays.asList(new Object[] { "foo", "bar", "baz" }).iterator(), ","); 
     assertEquals("foo,bar,baz", sb.toString()); 
     sb.clear(); 
     sb.appendWithSeparators(Arrays.asList(new Object[] { "foo", "bar", "baz" }).iterator(), null); 
     assertEquals("foobarbaz", sb.toString()); 
     sb.clear(); 
     sb.appendWithSeparators(Arrays.asList(new Object[] { "foo", null, "baz" }).iterator(), ","); 
     assertEquals("foo,,baz", sb.toString()); 
 }
@Test
public void testAppendFixedWidthPadLeft_int6609() { 
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
public void testAppendPadding6631() { 
     final StrBuilder sb = new StrBuilder(); 
     sb.append("foo"); 
     assertEquals("foo", sb.toString()); 
     sb.appendPadding(-1, '-'); 
     assertEquals("foo", sb.toString()); 
     sb.appendPadding(0, '-'); 
     assertEquals("foo", sb.toString()); 
     sb.appendPadding(1, '-'); 
     assertEquals("foo-", sb.toString()); 
     sb.appendPadding(16, '-'); 
     assertEquals(20, sb.length()); 
     assertEquals("foo-----------------", sb.toString()); 
 }
@Test
public void testAppendWithSeparatorsWithNullText6734() { 
     final StrBuilder sb = new StrBuilder(); 
     sb.setNullText("null"); 
     sb.appendWithSeparators(new Object[] { "foo", null, "baz" }, ","); 
     assertEquals("foo,null,baz", sb.toString()); 
     sb.clear(); 
     sb.appendWithSeparators(Arrays.asList(new Object[] { "foo", null, "baz" }), ","); 
     assertEquals("foo,null,baz", sb.toString()); 
 }
@Test
public void testAppendSeparator_String_int6746() { 
     final StrBuilder sb = new StrBuilder(); 
     sb.appendSeparator(",", 0); 
     assertEquals("", sb.toString()); 
     sb.append("foo"); 
     assertEquals("foo", sb.toString()); 
     sb.appendSeparator(",", 1); 
     assertEquals("foo,", sb.toString()); 
     sb.appendSeparator(",", -1); 
     assertEquals("foo,", sb.toString()); 
 }
@Test
public void testAppendSeparator_String6827() { 
     final StrBuilder sb = new StrBuilder(); 
     sb.appendSeparator(","); 
     assertEquals("", sb.toString()); 
     sb.append("foo"); 
     assertEquals("foo", sb.toString()); 
     sb.appendSeparator(","); 
     assertEquals("foo,", sb.toString()); 
 }
@Test
public void testAppendSeparator_char_int6843() { 
     final StrBuilder sb = new StrBuilder(); 
     sb.appendSeparator(',', 0); 
     assertEquals("", sb.toString()); 
     sb.append("foo"); 
     assertEquals("foo", sb.toString()); 
     sb.appendSeparator(',', 1); 
     assertEquals("foo,", sb.toString()); 
     sb.appendSeparator(',', -1); 
     assertEquals("foo,", sb.toString()); 
 }
@Test
public void testAppendln_PrimitiveNumber6856() { 
     final StrBuilder sb = new StrBuilder(); 
     sb.appendln(0); 
     assertEquals("0" + SEP, sb.toString()); 
     sb.clear(); 
     sb.appendln(1L); 
     assertEquals("1" + SEP, sb.toString()); 
     sb.clear(); 
     sb.appendln(2.3f); 
     assertEquals("2.3" + SEP, sb.toString()); 
     sb.clear(); 
     sb.appendln(4.5d); 
     assertEquals("4.5" + SEP, sb.toString()); 
 }
@Test
public void testAppendln_Boolean6866() { 
     final StrBuilder sb = new StrBuilder(); 
     sb.appendln(true); 
     assertEquals("true" + SEP, sb.toString()); 
     sb.clear(); 
     sb.appendln(false); 
     assertEquals("false" + SEP, sb.toString()); 
 }
@Test
public void testAppendln_StringBuffer6883() { 
     final int[] count = new int[2]; 
     final StrBuilder sb = new StrBuilder() { 
  
         @Override 
         public StrBuilder append(final StringBuffer str) { 
             count[0]++; 
             return super.append(str); 
         } 
  
         @Override 
         public StrBuilder appendNewLine() { 
             count[1]++; 
             return super.appendNewLine(); 
         } 
     }; 
     sb.appendln(new StringBuffer("foo")); 
     assertEquals("foo" + SEP, sb.toString()); 
     assertEquals(1, count[0]); 
     assertEquals(1, count[1]); 
 }
@Test
public void testAppendSeparator_char_int6918() { 
     final StrBuilder sb = new StrBuilder(); 
     sb.appendSeparator(',', 0); 
     assertEquals("", sb.toString()); 
     sb.append("foo"); 
     assertEquals("foo", sb.toString()); 
     sb.appendSeparator(',', 1); 
     assertEquals("foo,", sb.toString()); 
     sb.appendSeparator(',', -1); 
     assertEquals("foo,", sb.toString()); 
 }
@Test
public void testAppendln_String6981() { 
     final int[] count = new int[2]; 
     final StrBuilder sb = new StrBuilder() { 
  
         @Override 
         public StrBuilder append(final String str) { 
             count[0]++; 
             return super.append(str); 
         } 
  
         @Override 
         public StrBuilder appendNewLine() { 
             count[1]++; 
             return super.appendNewLine(); 
         } 
     }; 
     sb.appendln("foo"); 
     assertEquals("foo" + SEP, sb.toString()); 
     assertEquals(2, count[0]); 
     assertEquals(1, count[1]); 
 }
@Test
public void testAppendFixedWidthPadLeft_int6994() { 
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
public void testAppend_String_int_int7008() { 
     StrBuilder sb = new StrBuilder(); 
     sb.setNullText("NULL").append((String) null, 0, 1); 
     assertEquals("NULL", sb.toString()); 
     sb = new StrBuilder(); 
     sb.append("foo", 0, 3); 
     assertEquals("foo", sb.toString()); 
     try { 
         sb.append("bar", -1, 1); 
         fail("append(char[], -1,) expected IndexOutOfBoundsException"); 
     } catch (final IndexOutOfBoundsException e) { 
     } 
     try { 
         sb.append("bar", 3, 1); 
         fail("append(char[], 3,) expected IndexOutOfBoundsException"); 
     } catch (final IndexOutOfBoundsException e) { 
     } 
     try { 
         sb.append("bar", 1, -1); 
         fail("append(char[],, -1) expected IndexOutOfBoundsException"); 
     } catch (final IndexOutOfBoundsException e) { 
     } 
     try { 
         sb.append("bar", 1, 3); 
         fail("append(char[], 1, 3) expected IndexOutOfBoundsException"); 
     } catch (final IndexOutOfBoundsException e) { 
     } 
     try { 
         sb.append("bar", -1, 3); 
         fail("append(char[], -1, 3) expected IndexOutOfBoundsException"); 
     } catch (final IndexOutOfBoundsException e) { 
     } 
     try { 
         sb.append("bar", 4, 0); 
         fail("append(char[], 4, 0) expected IndexOutOfBoundsException"); 
     } catch (final IndexOutOfBoundsException e) { 
     } 
     sb.append("bar", 3, 0); 
     assertEquals("foo", sb.toString()); 
     sb.append("abcbardef", 3, 3); 
     assertEquals("foobar", sb.toString()); 
     sb.append((CharSequence) "abcbardef", 4, 3); 
     assertEquals("foobarard", sb.toString()); 
 }
@Test
public void testAppendln_Boolean7068() { 
     final StrBuilder sb = new StrBuilder(); 
     sb.appendln(true); 
     assertEquals("true" + SEP, sb.toString()); 
     sb.clear(); 
     sb.appendln(false); 
     assertEquals("false" + SEP, sb.toString()); 
 }
@Test
public void testAppendAll_Iterator7101() { 
     final StrBuilder sb = new StrBuilder(); 
     sb.appendAll((Iterator<?>) null); 
     assertEquals("", sb.toString()); 
     sb.clear(); 
     sb.appendAll(Collections.EMPTY_LIST.iterator()); 
     assertEquals("", sb.toString()); 
     sb.clear(); 
     sb.appendAll(Arrays.asList(new Object[] { "foo", "bar", "baz" }).iterator()); 
     assertEquals("foobarbaz", sb.toString()); 
 }
@Test
public void testAppendAll_Collection7102() { 
     final StrBuilder sb = new StrBuilder(); 
     sb.appendAll((Collection<?>) null); 
     assertEquals("", sb.toString()); 
     sb.clear(); 
     sb.appendAll(Collections.EMPTY_LIST); 
     assertEquals("", sb.toString()); 
     sb.clear(); 
     sb.appendAll(Arrays.asList(new Object[] { "foo", "bar", "baz" })); 
     assertEquals("foobarbaz", sb.toString()); 
 }
@Test
public void testAppendln_StringBuffer7124() { 
     final int[] count = new int[2]; 
     final StrBuilder sb = new StrBuilder() { 
  
         @Override 
         public StrBuilder append(final StringBuffer str) { 
             count[0]++; 
             return super.append(str); 
         } 
  
         @Override 
         public StrBuilder appendNewLine() { 
             count[1]++; 
             return super.appendNewLine(); 
         } 
     }; 
     sb.appendln(new StringBuffer("foo")); 
     assertEquals("foo" + SEP, sb.toString()); 
     assertEquals(1, count[0]); 
     assertEquals(1, count[1]); 
 }
@Test
public void testAppend_StrBuilder_int_int7133() { 
     StrBuilder sb = new StrBuilder(); 
     sb.setNullText("NULL").append((StrBuilder) null, 0, 1); 
     assertEquals("NULL", sb.toString()); 
     sb = new StrBuilder(); 
     sb.append(new StrBuilder("foo"), 0, 3); 
     assertEquals("foo", sb.toString()); 
     try { 
         sb.append(new StrBuilder("bar"), -1, 1); 
         fail("append(char[], -1,) expected IndexOutOfBoundsException"); 
     } catch (final IndexOutOfBoundsException e) { 
     } 
     try { 
         sb.append(new StrBuilder("bar"), 3, 1); 
         fail("append(char[], 3,) expected IndexOutOfBoundsException"); 
     } catch (final IndexOutOfBoundsException e) { 
     } 
     try { 
         sb.append(new StrBuilder("bar"), 1, -1); 
         fail("append(char[],, -1) expected IndexOutOfBoundsException"); 
     } catch (final IndexOutOfBoundsException e) { 
     } 
     try { 
         sb.append(new StrBuilder("bar"), 1, 3); 
         fail("append(char[], 1, 3) expected IndexOutOfBoundsException"); 
     } catch (final IndexOutOfBoundsException e) { 
     } 
     try { 
         sb.append(new StrBuilder("bar"), -1, 3); 
         fail("append(char[], -1, 3) expected IndexOutOfBoundsException"); 
     } catch (final IndexOutOfBoundsException e) { 
     } 
     try { 
         sb.append(new StrBuilder("bar"), 4, 0); 
         fail("append(char[], 4, 0) expected IndexOutOfBoundsException"); 
     } catch (final IndexOutOfBoundsException e) { 
     } 
     sb.append(new StrBuilder("bar"), 3, 0); 
     assertEquals("foo", sb.toString()); 
     sb.append(new StrBuilder("abcbardef"), 3, 3); 
     assertEquals("foobar", sb.toString()); 
 }
@Test
public void testAppendFixedWidthPadLeft_int7138() { 
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
public void testAppendln_StringBuilder_int_int7214() { 
     final int[] count = new int[2]; 
     final StrBuilder sb = new StrBuilder() { 
  
         @Override 
         public StrBuilder append(final StringBuilder str, final int startIndex, final int length) { 
             count[0]++; 
             return super.append(str, startIndex, length); 
         } 
  
         @Override 
         public StrBuilder appendNewLine() { 
             count[1]++; 
             return super.appendNewLine(); 
         } 
     }; 
     sb.appendln(new StringBuilder("foo"), 0, 3); 
     assertEquals("foo" + SEP, sb.toString()); 
     assertEquals(1, count[0]); 
     assertEquals(1, count[1]); 
 }
@Test
public void testAppendln_StringBuilder_int_int7292() { 
     final int[] count = new int[2]; 
     final StrBuilder sb = new StrBuilder() { 
  
         @Override 
         public StrBuilder append(final StringBuilder str, final int startIndex, final int length) { 
             count[0]++; 
             return super.append(str, startIndex, length); 
         } 
  
         @Override 
         public StrBuilder appendNewLine() { 
             count[1]++; 
             return super.appendNewLine(); 
         } 
     }; 
     sb.appendln(new StringBuilder("foo"), 0, 3); 
     assertEquals("foo" + SEP, sb.toString()); 
     assertEquals(1, count[0]); 
     assertEquals(1, count[1]); 
 }
@Test
public void testAppendln_StringBuffer7479() { 
     final int[] count = new int[2]; 
     final StrBuilder sb = new StrBuilder() { 
  
         @Override 
         public StrBuilder append(final StringBuffer str) { 
             count[0]++; 
             return super.append(str); 
         } 
  
         @Override 
         public StrBuilder appendNewLine() { 
             count[1]++; 
             return super.appendNewLine(); 
         } 
     }; 
     sb.appendln(new StringBuffer("foo")); 
     assertEquals("foo" + SEP, sb.toString()); 
     assertEquals(1, count[0]); 
     assertEquals(1, count[1]); 
 }
@Test
public void testAppend_CharArray7481() { 
     StrBuilder sb = new StrBuilder(); 
     sb.setNullText("NULL").append((char[]) null); 
     assertEquals("NULL", sb.toString()); 
     sb = new StrBuilder(); 
     sb.append(new char[0]); 
     assertEquals("", sb.toString()); 
     sb.append(new char[] { 'f', 'o', 'o' }); 
     assertEquals("foo", sb.toString()); 
 }
@Test
public void testAppendAll_Iterator7514() { 
     final StrBuilder sb = new StrBuilder(); 
     sb.appendAll((Iterator<?>) null); 
     assertEquals("", sb.toString()); 
     sb.clear(); 
     sb.appendAll(Collections.EMPTY_LIST.iterator()); 
     assertEquals("", sb.toString()); 
     sb.clear(); 
     sb.appendAll(Arrays.asList(new Object[] { "foo", "bar", "baz" }).iterator()); 
     assertEquals("foobarbaz", sb.toString()); 
 }
@Test
public void testAppendln_StringBuffer7518() { 
     final int[] count = new int[2]; 
     final StrBuilder sb = new StrBuilder() { 
  
         @Override 
         public StrBuilder append(final StringBuffer str) { 
             count[0]++; 
             return super.append(str); 
         } 
  
         @Override 
         public StrBuilder appendNewLine() { 
             count[1]++; 
             return super.appendNewLine(); 
         } 
     }; 
     sb.appendln(new StringBuffer("foo")); 
     assertEquals("foo" + SEP, sb.toString()); 
     assertEquals(1, count[0]); 
     assertEquals(1, count[1]); 
 }
@Test
public void testAppend_StringBuffer_int_int7547() { 
     StrBuilder sb = new StrBuilder(); 
     sb.setNullText("NULL").append((StringBuffer) null, 0, 1); 
     assertEquals("NULL", sb.toString()); 
     sb = new StrBuilder(); 
     sb.append(new StringBuffer("foo"), 0, 3); 
     assertEquals("foo", sb.toString()); 
     try { 
         sb.append(new StringBuffer("bar"), -1, 1); 
         fail("append(char[], -1,) expected IndexOutOfBoundsException"); 
     } catch (final IndexOutOfBoundsException e) { 
     } 
     try { 
         sb.append(new StringBuffer("bar"), 3, 1); 
         fail("append(char[], 3,) expected IndexOutOfBoundsException"); 
     } catch (final IndexOutOfBoundsException e) { 
     } 
     try { 
         sb.append(new StringBuffer("bar"), 1, -1); 
         fail("append(char[],, -1) expected IndexOutOfBoundsException"); 
     } catch (final IndexOutOfBoundsException e) { 
     } 
     try { 
         sb.append(new StringBuffer("bar"), 1, 3); 
         fail("append(char[], 1, 3) expected IndexOutOfBoundsException"); 
     } catch (final IndexOutOfBoundsException e) { 
     } 
     try { 
         sb.append(new StringBuffer("bar"), -1, 3); 
         fail("append(char[], -1, 3) expected IndexOutOfBoundsException"); 
     } catch (final IndexOutOfBoundsException e) { 
     } 
     try { 
         sb.append(new StringBuffer("bar"), 4, 0); 
         fail("append(char[], 4, 0) expected IndexOutOfBoundsException"); 
     } catch (final IndexOutOfBoundsException e) { 
     } 
     sb.append(new StringBuffer("bar"), 3, 0); 
     assertEquals("foo", sb.toString()); 
     sb.append(new StringBuffer("abcbardef"), 3, 3); 
     assertEquals("foobar", sb.toString()); 
 }
@Test
public void testAppendWithSeparatorsWithNullText7556() { 
     final StrBuilder sb = new StrBuilder(); 
     sb.setNullText("null"); 
     sb.appendWithSeparators(new Object[] { "foo", null, "baz" }, ","); 
     assertEquals("foo,null,baz", sb.toString()); 
     sb.clear(); 
     sb.appendWithSeparators(Arrays.asList(new Object[] { "foo", null, "baz" }), ","); 
     assertEquals("foo,null,baz", sb.toString()); 
 }
@Test
public void testAppendln_PrimitiveNumber7570() { 
     final StrBuilder sb = new StrBuilder(); 
     sb.appendln(0); 
     assertEquals("0" + SEP, sb.toString()); 
     sb.clear(); 
     sb.appendln(1L); 
     assertEquals("1" + SEP, sb.toString()); 
     sb.clear(); 
     sb.appendln(2.3f); 
     assertEquals("2.3" + SEP, sb.toString()); 
     sb.clear(); 
     sb.appendln(4.5d); 
     assertEquals("4.5" + SEP, sb.toString()); 
 }
@Test
public void testAppend_StrBuilder_int_int7593() { 
     StrBuilder sb = new StrBuilder(); 
     sb.setNullText("NULL").append((StrBuilder) null, 0, 1); 
     assertEquals("NULL", sb.toString()); 
     sb = new StrBuilder(); 
     sb.append(new StrBuilder("foo"), 0, 3); 
     assertEquals("foo", sb.toString()); 
     try { 
         sb.append(new StrBuilder("bar"), -1, 1); 
         fail("append(char[], -1,) expected IndexOutOfBoundsException"); 
     } catch (final IndexOutOfBoundsException e) { 
     } 
     try { 
         sb.append(new StrBuilder("bar"), 3, 1); 
         fail("append(char[], 3,) expected IndexOutOfBoundsException"); 
     } catch (final IndexOutOfBoundsException e) { 
     } 
     try { 
         sb.append(new StrBuilder("bar"), 1, -1); 
         fail("append(char[],, -1) expected IndexOutOfBoundsException"); 
     } catch (final IndexOutOfBoundsException e) { 
     } 
     try { 
         sb.append(new StrBuilder("bar"), 1, 3); 
         fail("append(char[], 1, 3) expected IndexOutOfBoundsException"); 
     } catch (final IndexOutOfBoundsException e) { 
     } 
     try { 
         sb.append(new StrBuilder("bar"), -1, 3); 
         fail("append(char[], -1, 3) expected IndexOutOfBoundsException"); 
     } catch (final IndexOutOfBoundsException e) { 
     } 
     try { 
         sb.append(new StrBuilder("bar"), 4, 0); 
         fail("append(char[], 4, 0) expected IndexOutOfBoundsException"); 
     } catch (final IndexOutOfBoundsException e) { 
     } 
     sb.append(new StrBuilder("bar"), 3, 0); 
     assertEquals("foo", sb.toString()); 
     sb.append(new StrBuilder("abcbardef"), 3, 3); 
     assertEquals("foobar", sb.toString()); 
 }
@Test
public void testAppendln_PrimitiveNumber7620() { 
     final StrBuilder sb = new StrBuilder(); 
     sb.appendln(0); 
     assertEquals("0" + SEP, sb.toString()); 
     sb.clear(); 
     sb.appendln(1L); 
     assertEquals("1" + SEP, sb.toString()); 
     sb.clear(); 
     sb.appendln(2.3f); 
     assertEquals("2.3" + SEP, sb.toString()); 
     sb.clear(); 
     sb.appendln(4.5d); 
     assertEquals("4.5" + SEP, sb.toString()); 
 }
@Test
public void testAppendWithSeparators_Iterator7636() { 
     final StrBuilder sb = new StrBuilder(); 
     sb.appendWithSeparators((Iterator<?>) null, ","); 
     assertEquals("", sb.toString()); 
     sb.clear(); 
     sb.appendWithSeparators(Collections.EMPTY_LIST.iterator(), ","); 
     assertEquals("", sb.toString()); 
     sb.clear(); 
     sb.appendWithSeparators(Arrays.asList(new Object[] { "foo", "bar", "baz" }).iterator(), ","); 
     assertEquals("foo,bar,baz", sb.toString()); 
     sb.clear(); 
     sb.appendWithSeparators(Arrays.asList(new Object[] { "foo", "bar", "baz" }).iterator(), null); 
     assertEquals("foobarbaz", sb.toString()); 
     sb.clear(); 
     sb.appendWithSeparators(Arrays.asList(new Object[] { "foo", null, "baz" }).iterator(), ","); 
     assertEquals("foo,,baz", sb.toString()); 
 }
@Test
public void testAppendFixedWidthPadLeft_int7672() { 
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
public void testAppendln_StringBuilder_int_int7715() { 
     final int[] count = new int[2]; 
     final StrBuilder sb = new StrBuilder() { 
  
         @Override 
         public StrBuilder append(final StringBuilder str, final int startIndex, final int length) { 
             count[0]++; 
             return super.append(str, startIndex, length); 
         } 
  
         @Override 
         public StrBuilder appendNewLine() { 
             count[1]++; 
             return super.appendNewLine(); 
         } 
     }; 
     sb.appendln(new StringBuilder("foo"), 0, 3); 
     assertEquals("foo" + SEP, sb.toString()); 
     assertEquals(1, count[0]); 
     assertEquals(1, count[1]); 
 }
@Test
public void testAppendln_StringBuilder_int_int7983() { 
     final int[] count = new int[2]; 
     final StrBuilder sb = new StrBuilder() { 
  
         @Override 
         public StrBuilder append(final StringBuilder str, final int startIndex, final int length) { 
             count[0]++; 
             return super.append(str, startIndex, length); 
         } 
  
         @Override 
         public StrBuilder appendNewLine() { 
             count[1]++; 
             return super.appendNewLine(); 
         } 
     }; 
     sb.appendln(new StringBuilder("foo"), 0, 3); 
     assertEquals("foo" + SEP, sb.toString()); 
     assertEquals(1, count[0]); 
     assertEquals(1, count[1]); 
 }
@Test
public void testAppendSeparator_String8014() { 
     final StrBuilder sb = new StrBuilder(); 
     sb.appendSeparator(","); 
     assertEquals("", sb.toString()); 
     sb.append("foo"); 
     assertEquals("foo", sb.toString()); 
     sb.appendSeparator(","); 
     assertEquals("foo,", sb.toString()); 
 }
@Test
public void testAppendln_Boolean8039() { 
     final StrBuilder sb = new StrBuilder(); 
     sb.appendln(true); 
     assertEquals("true" + SEP, sb.toString()); 
     sb.clear(); 
     sb.appendln(false); 
     assertEquals("false" + SEP, sb.toString()); 
 }
@Test
public void testAppendln_StrBuilder_int_int8067() { 
     final int[] count = new int[2]; 
     final StrBuilder sb = new StrBuilder() { 
  
         @Override 
         public StrBuilder append(final StrBuilder str, final int startIndex, final int length) { 
             count[0]++; 
             return super.append(str, startIndex, length); 
         } 
  
         @Override 
         public StrBuilder appendNewLine() { 
             count[1]++; 
             return super.appendNewLine(); 
         } 
     }; 
     sb.appendln(new StrBuilder("foo"), 0, 3); 
     assertEquals("foo" + SEP, sb.toString()); 
     assertEquals(1, count[0]); 
     assertEquals(1, count[1]); 
 }
@Test
public void testAppend_StrBuilder8110() { 
     StrBuilder sb = new StrBuilder(); 
     sb.setNullText("NULL").append((StrBuilder) null); 
     assertEquals("NULL", sb.toString()); 
     sb = new StrBuilder(); 
     sb.append(new StrBuilder("foo")); 
     assertEquals("foo", sb.toString()); 
     sb.append(new StrBuilder("")); 
     assertEquals("foo", sb.toString()); 
     sb.append(new StrBuilder("bar")); 
     assertEquals("foobar", sb.toString()); 
 }
@Test
public void testAppendln_StringBuilder_int_int8137() { 
     final int[] count = new int[2]; 
     final StrBuilder sb = new StrBuilder() { 
  
         @Override 
         public StrBuilder append(final StringBuilder str, final int startIndex, final int length) { 
             count[0]++; 
             return super.append(str, startIndex, length); 
         } 
  
         @Override 
         public StrBuilder appendNewLine() { 
             count[1]++; 
             return super.appendNewLine(); 
         } 
     }; 
     sb.appendln(new StringBuilder("foo"), 0, 3); 
     assertEquals("foo" + SEP, sb.toString()); 
     assertEquals(1, count[0]); 
     assertEquals(1, count[1]); 
 }
@Test
public void testAppend_Object8182() { 
     final StrBuilder sb = new StrBuilder(); 
     sb.appendNull(); 
     assertEquals("", sb.toString()); 
     sb.append((Object) null); 
     assertEquals("", sb.toString()); 
     sb.append(FOO); 
     assertEquals("foo", sb.toString()); 
     sb.append((StringBuffer) null); 
     assertEquals("foo", sb.toString()); 
     sb.append(new StringBuffer("baz")); 
     assertEquals("foobaz", sb.toString()); 
     sb.append(new StrBuilder("yes")); 
     assertEquals("foobazyes", sb.toString()); 
     sb.append((CharSequence) "Seq"); 
     assertEquals("foobazyesSeq", sb.toString()); 
     sb.append(new StringBuilder("bld")); 
     assertEquals("foobazyesSeqbld", sb.toString()); 
 }
@Test
public void testAppendln_StrBuilder_int_int8239() { 
     final int[] count = new int[2]; 
     final StrBuilder sb = new StrBuilder() { 
  
         @Override 
         public StrBuilder append(final StrBuilder str, final int startIndex, final int length) { 
             count[0]++; 
             return super.append(str, startIndex, length); 
         } 
  
         @Override 
         public StrBuilder appendNewLine() { 
             count[1]++; 
             return super.appendNewLine(); 
         } 
     }; 
     sb.appendln(new StrBuilder("foo"), 0, 3); 
     assertEquals("foo" + SEP, sb.toString()); 
     assertEquals(1, count[0]); 
     assertEquals(1, count[1]); 
 }
@Test
public void testAppendln_StringBuilder_int_int8265() { 
     final int[] count = new int[2]; 
     final StrBuilder sb = new StrBuilder() { 
  
         @Override 
         public StrBuilder append(final StringBuilder str, final int startIndex, final int length) { 
             count[0]++; 
             return super.append(str, startIndex, length); 
         } 
  
         @Override 
         public StrBuilder appendNewLine() { 
             count[1]++; 
             return super.appendNewLine(); 
         } 
     }; 
     sb.appendln(new StringBuilder("foo"), 0, 3); 
     assertEquals("foo" + SEP, sb.toString()); 
     assertEquals(1, count[0]); 
     assertEquals(1, count[1]); 
 }
@Test
public void testAppendln_StringBuilder_int_int8345() { 
     final int[] count = new int[2]; 
     final StrBuilder sb = new StrBuilder() { 
  
         @Override 
         public StrBuilder append(final StringBuilder str, final int startIndex, final int length) { 
             count[0]++; 
             return super.append(str, startIndex, length); 
         } 
  
         @Override 
         public StrBuilder appendNewLine() { 
             count[1]++; 
             return super.appendNewLine(); 
         } 
     }; 
     sb.appendln(new StringBuilder("foo"), 0, 3); 
     assertEquals("foo" + SEP, sb.toString()); 
     assertEquals(1, count[0]); 
     assertEquals(1, count[1]); 
 }
@Test
public void testAppend_StringBuffer_int_int8354() { 
     StrBuilder sb = new StrBuilder(); 
     sb.setNullText("NULL").append((StringBuffer) null, 0, 1); 
     assertEquals("NULL", sb.toString()); 
     sb = new StrBuilder(); 
     sb.append(new StringBuffer("foo"), 0, 3); 
     assertEquals("foo", sb.toString()); 
     try { 
         sb.append(new StringBuffer("bar"), -1, 1); 
         fail("append(char[], -1,) expected IndexOutOfBoundsException"); 
     } catch (final IndexOutOfBoundsException e) { 
     } 
     try { 
         sb.append(new StringBuffer("bar"), 3, 1); 
         fail("append(char[], 3,) expected IndexOutOfBoundsException"); 
     } catch (final IndexOutOfBoundsException e) { 
     } 
     try { 
         sb.append(new StringBuffer("bar"), 1, -1); 
         fail("append(char[],, -1) expected IndexOutOfBoundsException"); 
     } catch (final IndexOutOfBoundsException e) { 
     } 
     try { 
         sb.append(new StringBuffer("bar"), 1, 3); 
         fail("append(char[], 1, 3) expected IndexOutOfBoundsException"); 
     } catch (final IndexOutOfBoundsException e) { 
     } 
     try { 
         sb.append(new StringBuffer("bar"), -1, 3); 
         fail("append(char[], -1, 3) expected IndexOutOfBoundsException"); 
     } catch (final IndexOutOfBoundsException e) { 
     } 
     try { 
         sb.append(new StringBuffer("bar"), 4, 0); 
         fail("append(char[], 4, 0) expected IndexOutOfBoundsException"); 
     } catch (final IndexOutOfBoundsException e) { 
     } 
     sb.append(new StringBuffer("bar"), 3, 0); 
     assertEquals("foo", sb.toString()); 
     sb.append(new StringBuffer("abcbardef"), 3, 3); 
     assertEquals("foobar", sb.toString()); 
 }
@Test
public void testAppend_PrimitiveNumber8432() { 
     final StrBuilder sb = new StrBuilder(); 
     sb.append(0); 
     assertEquals("0", sb.toString()); 
     sb.append(1L); 
     assertEquals("01", sb.toString()); 
     sb.append(2.3f); 
     assertEquals("012.3", sb.toString()); 
     sb.append(4.5d); 
     assertEquals("012.34.5", sb.toString()); 
 }
@Test
public void testAppendln_StrBuilder_int_int8478() { 
     final int[] count = new int[2]; 
     final StrBuilder sb = new StrBuilder() { 
  
         @Override 
         public StrBuilder append(final StrBuilder str, final int startIndex, final int length) { 
             count[0]++; 
             return super.append(str, startIndex, length); 
         } 
  
         @Override 
         public StrBuilder appendNewLine() { 
             count[1]++; 
             return super.appendNewLine(); 
         } 
     }; 
     sb.appendln(new StrBuilder("foo"), 0, 3); 
     assertEquals("foo" + SEP, sb.toString()); 
     assertEquals(1, count[0]); 
     assertEquals(1, count[1]); 
 }
@Test
public void testAppendln_StringBuilder_int_int8492() { 
     final int[] count = new int[2]; 
     final StrBuilder sb = new StrBuilder() { 
  
         @Override 
         public StrBuilder append(final StringBuilder str, final int startIndex, final int length) { 
             count[0]++; 
             return super.append(str, startIndex, length); 
         } 
  
         @Override 
         public StrBuilder appendNewLine() { 
             count[1]++; 
             return super.appendNewLine(); 
         } 
     }; 
     sb.appendln(new StringBuilder("foo"), 0, 3); 
     assertEquals("foo" + SEP, sb.toString()); 
     assertEquals(1, count[0]); 
     assertEquals(1, count[1]); 
 }
@Test
public void testAppendln_Boolean8505() { 
     final StrBuilder sb = new StrBuilder(); 
     sb.appendln(true); 
     assertEquals("true" + SEP, sb.toString()); 
     sb.clear(); 
     sb.appendln(false); 
     assertEquals("false" + SEP, sb.toString()); 
 }
@Test
public void testAppendWithSeparators_Iterator8524() { 
     final StrBuilder sb = new StrBuilder(); 
     sb.appendWithSeparators((Iterator<?>) null, ","); 
     assertEquals("", sb.toString()); 
     sb.clear(); 
     sb.appendWithSeparators(Collections.EMPTY_LIST.iterator(), ","); 
     assertEquals("", sb.toString()); 
     sb.clear(); 
     sb.appendWithSeparators(Arrays.asList(new Object[] { "foo", "bar", "baz" }).iterator(), ","); 
     assertEquals("foo,bar,baz", sb.toString()); 
     sb.clear(); 
     sb.appendWithSeparators(Arrays.asList(new Object[] { "foo", "bar", "baz" }).iterator(), null); 
     assertEquals("foobarbaz", sb.toString()); 
     sb.clear(); 
     sb.appendWithSeparators(Arrays.asList(new Object[] { "foo", null, "baz" }).iterator(), ","); 
     assertEquals("foo,,baz", sb.toString()); 
 }
@Test
public void testAppendln_StrBuilder_int_int8563() { 
     final int[] count = new int[2]; 
     final StrBuilder sb = new StrBuilder() { 
  
         @Override 
         public StrBuilder append(final StrBuilder str, final int startIndex, final int length) { 
             count[0]++; 
             return super.append(str, startIndex, length); 
         } 
  
         @Override 
         public StrBuilder appendNewLine() { 
             count[1]++; 
             return super.appendNewLine(); 
         } 
     }; 
     sb.appendln(new StrBuilder("foo"), 0, 3); 
     assertEquals("foo" + SEP, sb.toString()); 
     assertEquals(1, count[0]); 
     assertEquals(1, count[1]); 
 }
@Test
public void testAppend_CharArray8571() { 
     StrBuilder sb = new StrBuilder(); 
     sb.setNullText("NULL").append((char[]) null); 
     assertEquals("NULL", sb.toString()); 
     sb = new StrBuilder(); 
     sb.append(new char[0]); 
     assertEquals("", sb.toString()); 
     sb.append(new char[] { 'f', 'o', 'o' }); 
     assertEquals("foo", sb.toString()); 
 }
@Test
public void testAppendFixedWidthPadLeft_int8666() { 
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
public void testAppendSeparator_String8669() { 
     final StrBuilder sb = new StrBuilder(); 
     sb.appendSeparator(","); 
     assertEquals("", sb.toString()); 
     sb.append("foo"); 
     assertEquals("foo", sb.toString()); 
     sb.appendSeparator(","); 
     assertEquals("foo,", sb.toString()); 
 }
@Test
public void testAppendNewLine8683() { 
     StrBuilder sb = new StrBuilder("---"); 
     sb.appendNewLine().append("+++"); 
     assertEquals("---" + SEP + "+++", sb.toString()); 
     sb = new StrBuilder("---"); 
     sb.setNewLineText("#").appendNewLine().setNewLineText(null).appendNewLine(); 
     assertEquals("---#" + SEP, sb.toString()); 
 }
@Test
public void testAppend_StringBuilder_int_int8687() { 
     StrBuilder sb = new StrBuilder(); 
     sb.setNullText("NULL").append((String) null, 0, 1); 
     assertEquals("NULL", sb.toString()); 
     sb = new StrBuilder(); 
     sb.append(new StringBuilder("foo"), 0, 3); 
     assertEquals("foo", sb.toString()); 
     try { 
         sb.append(new StringBuilder("bar"), -1, 1); 
         fail("append(StringBuilder, -1,) expected IndexOutOfBoundsException"); 
     } catch (final IndexOutOfBoundsException e) { 
     } 
     try { 
         sb.append(new StringBuilder("bar"), 3, 1); 
         fail("append(StringBuilder, 3,) expected IndexOutOfBoundsException"); 
     } catch (final IndexOutOfBoundsException e) { 
     } 
     try { 
         sb.append(new StringBuilder("bar"), 1, -1); 
         fail("append(StringBuilder,, -1) expected IndexOutOfBoundsException"); 
     } catch (final IndexOutOfBoundsException e) { 
     } 
     try { 
         sb.append(new StringBuilder("bar"), 1, 3); 
         fail("append(StringBuilder, 1, 3) expected IndexOutOfBoundsException"); 
     } catch (final IndexOutOfBoundsException e) { 
     } 
     try { 
         sb.append(new StringBuilder("bar"), -1, 3); 
         fail("append(StringBuilder, -1, 3) expected IndexOutOfBoundsException"); 
     } catch (final IndexOutOfBoundsException e) { 
     } 
     try { 
         sb.append(new StringBuilder("bar"), 4, 0); 
         fail("append(StringBuilder, 4, 0) expected IndexOutOfBoundsException"); 
     } catch (final IndexOutOfBoundsException e) { 
     } 
     sb.append(new StringBuilder("bar"), 3, 0); 
     assertEquals("foo", sb.toString()); 
     sb.append(new StringBuilder("abcbardef"), 3, 3); 
     assertEquals("foobar", sb.toString()); 
     sb.append(new StringBuilder("abcbardef"), 4, 3); 
     assertEquals("foobarard", sb.toString()); 
 }
@Test
public void testAppendWithSeparatorsWithNullText8690() { 
     final StrBuilder sb = new StrBuilder(); 
     sb.setNullText("null"); 
     sb.appendWithSeparators(new Object[] { "foo", null, "baz" }, ","); 
     assertEquals("foo,null,baz", sb.toString()); 
     sb.clear(); 
     sb.appendWithSeparators(Arrays.asList(new Object[] { "foo", null, "baz" }), ","); 
     assertEquals("foo,null,baz", sb.toString()); 
 }
@Test
public void testAppendWithSeparatorsWithNullText8692() { 
     final StrBuilder sb = new StrBuilder(); 
     sb.setNullText("null"); 
     sb.appendWithSeparators(new Object[] { "foo", null, "baz" }, ","); 
     assertEquals("foo,null,baz", sb.toString()); 
     sb.clear(); 
     sb.appendWithSeparators(Arrays.asList(new Object[] { "foo", null, "baz" }), ","); 
     assertEquals("foo,null,baz", sb.toString()); 
 }
@Test
public void testAppendln_StringBuffer8703() { 
     final int[] count = new int[2]; 
     final StrBuilder sb = new StrBuilder() { 
  
         @Override 
         public StrBuilder append(final StringBuffer str) { 
             count[0]++; 
             return super.append(str); 
         } 
  
         @Override 
         public StrBuilder appendNewLine() { 
             count[1]++; 
             return super.appendNewLine(); 
         } 
     }; 
     sb.appendln(new StringBuffer("foo")); 
     assertEquals("foo" + SEP, sb.toString()); 
     assertEquals(1, count[0]); 
     assertEquals(1, count[1]); 
 }
@Test
public void testAppend_StrBuilder8738() { 
     StrBuilder sb = new StrBuilder(); 
     sb.setNullText("NULL").append((StrBuilder) null); 
     assertEquals("NULL", sb.toString()); 
     sb = new StrBuilder(); 
     sb.append(new StrBuilder("foo")); 
     assertEquals("foo", sb.toString()); 
     sb.append(new StrBuilder("")); 
     assertEquals("foo", sb.toString()); 
     sb.append(new StrBuilder("bar")); 
     assertEquals("foobar", sb.toString()); 
 }
@Test
public void testAppendSeparator_String_int8740() { 
     final StrBuilder sb = new StrBuilder(); 
     sb.appendSeparator(",", 0); 
     assertEquals("", sb.toString()); 
     sb.append("foo"); 
     assertEquals("foo", sb.toString()); 
     sb.appendSeparator(",", 1); 
     assertEquals("foo,", sb.toString()); 
     sb.appendSeparator(",", -1); 
     assertEquals("foo,", sb.toString()); 
 }
@Test
public void testAppend_StringBuffer_int_int8746() { 
     StrBuilder sb = new StrBuilder(); 
     sb.setNullText("NULL").append((StringBuffer) null, 0, 1); 
     assertEquals("NULL", sb.toString()); 
     sb = new StrBuilder(); 
     sb.append(new StringBuffer("foo"), 0, 3); 
     assertEquals("foo", sb.toString()); 
     try { 
         sb.append(new StringBuffer("bar"), -1, 1); 
         fail("append(char[], -1,) expected IndexOutOfBoundsException"); 
     } catch (final IndexOutOfBoundsException e) { 
     } 
     try { 
         sb.append(new StringBuffer("bar"), 3, 1); 
         fail("append(char[], 3,) expected IndexOutOfBoundsException"); 
     } catch (final IndexOutOfBoundsException e) { 
     } 
     try { 
         sb.append(new StringBuffer("bar"), 1, -1); 
         fail("append(char[],, -1) expected IndexOutOfBoundsException"); 
     } catch (final IndexOutOfBoundsException e) { 
     } 
     try { 
         sb.append(new StringBuffer("bar"), 1, 3); 
         fail("append(char[], 1, 3) expected IndexOutOfBoundsException"); 
     } catch (final IndexOutOfBoundsException e) { 
     } 
     try { 
         sb.append(new StringBuffer("bar"), -1, 3); 
         fail("append(char[], -1, 3) expected IndexOutOfBoundsException"); 
     } catch (final IndexOutOfBoundsException e) { 
     } 
     try { 
         sb.append(new StringBuffer("bar"), 4, 0); 
         fail("append(char[], 4, 0) expected IndexOutOfBoundsException"); 
     } catch (final IndexOutOfBoundsException e) { 
     } 
     sb.append(new StringBuffer("bar"), 3, 0); 
     assertEquals("foo", sb.toString()); 
     sb.append(new StringBuffer("abcbardef"), 3, 3); 
     assertEquals("foobar", sb.toString()); 
 }
@Test
public void testAppendAll_Collection8808() { 
     final StrBuilder sb = new StrBuilder(); 
     sb.appendAll((Collection<?>) null); 
     assertEquals("", sb.toString()); 
     sb.clear(); 
     sb.appendAll(Collections.EMPTY_LIST); 
     assertEquals("", sb.toString()); 
     sb.clear(); 
     sb.appendAll(Arrays.asList(new Object[] { "foo", "bar", "baz" })); 
     assertEquals("foobarbaz", sb.toString()); 
 }
@Test
public void testAppend_PrimitiveNumber8828() { 
     final StrBuilder sb = new StrBuilder(); 
     sb.append(0); 
     assertEquals("0", sb.toString()); 
     sb.append(1L); 
     assertEquals("01", sb.toString()); 
     sb.append(2.3f); 
     assertEquals("012.3", sb.toString()); 
     sb.append(4.5d); 
     assertEquals("012.34.5", sb.toString()); 
 }
@Test
public void testAppendWithSeparatorsWithNullText8883() { 
     final StrBuilder sb = new StrBuilder(); 
     sb.setNullText("null"); 
     sb.appendWithSeparators(new Object[] { "foo", null, "baz" }, ","); 
     assertEquals("foo,null,baz", sb.toString()); 
     sb.clear(); 
     sb.appendWithSeparators(Arrays.asList(new Object[] { "foo", null, "baz" }), ","); 
     assertEquals("foo,null,baz", sb.toString()); 
 }
@Test
public void testAppendln_StringBuilder_int_int8924() { 
     final int[] count = new int[2]; 
     final StrBuilder sb = new StrBuilder() { 
  
         @Override 
         public StrBuilder append(final StringBuilder str, final int startIndex, final int length) { 
             count[0]++; 
             return super.append(str, startIndex, length); 
         } 
  
         @Override 
         public StrBuilder appendNewLine() { 
             count[1]++; 
             return super.appendNewLine(); 
         } 
     }; 
     sb.appendln(new StringBuilder("foo"), 0, 3); 
     assertEquals("foo" + SEP, sb.toString()); 
     assertEquals(1, count[0]); 
     assertEquals(1, count[1]); 
 }
@Test
public void testAppendWithSeparators_Iterator8943() { 
     final StrBuilder sb = new StrBuilder(); 
     sb.appendWithSeparators((Iterator<?>) null, ","); 
     assertEquals("", sb.toString()); 
     sb.clear(); 
     sb.appendWithSeparators(Collections.EMPTY_LIST.iterator(), ","); 
     assertEquals("", sb.toString()); 
     sb.clear(); 
     sb.appendWithSeparators(Arrays.asList(new Object[] { "foo", "bar", "baz" }).iterator(), ","); 
     assertEquals("foo,bar,baz", sb.toString()); 
     sb.clear(); 
     sb.appendWithSeparators(Arrays.asList(new Object[] { "foo", "bar", "baz" }).iterator(), null); 
     assertEquals("foobarbaz", sb.toString()); 
     sb.clear(); 
     sb.appendWithSeparators(Arrays.asList(new Object[] { "foo", null, "baz" }).iterator(), ","); 
     assertEquals("foo,,baz", sb.toString()); 
 }
@Test
public void testAppendln_Boolean9003() { 
     final StrBuilder sb = new StrBuilder(); 
     sb.appendln(true); 
     assertEquals("true" + SEP, sb.toString()); 
     sb.clear(); 
     sb.appendln(false); 
     assertEquals("false" + SEP, sb.toString()); 
 }
@Test
public void testAppendln_PrimitiveNumber9067() { 
     final StrBuilder sb = new StrBuilder(); 
     sb.appendln(0); 
     assertEquals("0" + SEP, sb.toString()); 
     sb.clear(); 
     sb.appendln(1L); 
     assertEquals("1" + SEP, sb.toString()); 
     sb.clear(); 
     sb.appendln(2.3f); 
     assertEquals("2.3" + SEP, sb.toString()); 
     sb.clear(); 
     sb.appendln(4.5d); 
     assertEquals("4.5" + SEP, sb.toString()); 
 }
@Test
public void testAppendln_StrBuilder9099() { 
     final int[] count = new int[2]; 
     final StrBuilder sb = new StrBuilder() { 
  
         @Override 
         public StrBuilder append(final StrBuilder str) { 
             count[0]++; 
             return super.append(str); 
         } 
  
         @Override 
         public StrBuilder appendNewLine() { 
             count[1]++; 
             return super.appendNewLine(); 
         } 
     }; 
     sb.appendln(new StrBuilder("foo")); 
     assertEquals("foo" + SEP, sb.toString()); 
     assertEquals(1, count[0]); 
     assertEquals(1, count[1]); 
 }
@Test
public void testAppend_CharArray9127() { 
     StrBuilder sb = new StrBuilder(); 
     sb.setNullText("NULL").append((char[]) null); 
     assertEquals("NULL", sb.toString()); 
     sb = new StrBuilder(); 
     sb.append(new char[0]); 
     assertEquals("", sb.toString()); 
     sb.append(new char[] { 'f', 'o', 'o' }); 
     assertEquals("foo", sb.toString()); 
 }
@Test
public void testAppendln_StringBuffer_int_int9170() { 
     final int[] count = new int[2]; 
     final StrBuilder sb = new StrBuilder() { 
  
         @Override 
         public StrBuilder append(final StringBuffer str, final int startIndex, final int length) { 
             count[0]++; 
             return super.append(str, startIndex, length); 
         } 
  
         @Override 
         public StrBuilder appendNewLine() { 
             count[1]++; 
             return super.appendNewLine(); 
         } 
     }; 
     sb.appendln(new StringBuffer("foo"), 0, 3); 
     assertEquals("foo" + SEP, sb.toString()); 
     assertEquals(1, count[0]); 
     assertEquals(1, count[1]); 
 }
@Test
public void testAppendSeparator_String9289() { 
     final StrBuilder sb = new StrBuilder(); 
     sb.appendSeparator(","); 
     assertEquals("", sb.toString()); 
     sb.append("foo"); 
     assertEquals("foo", sb.toString()); 
     sb.appendSeparator(","); 
     assertEquals("foo,", sb.toString()); 
 }
@Test
public void testAppendWithSeparators_Iterator9325() { 
     final StrBuilder sb = new StrBuilder(); 
     sb.appendWithSeparators((Iterator<?>) null, ","); 
     assertEquals("", sb.toString()); 
     sb.clear(); 
     sb.appendWithSeparators(Collections.EMPTY_LIST.iterator(), ","); 
     assertEquals("", sb.toString()); 
     sb.clear(); 
     sb.appendWithSeparators(Arrays.asList(new Object[] { "foo", "bar", "baz" }).iterator(), ","); 
     assertEquals("foo,bar,baz", sb.toString()); 
     sb.clear(); 
     sb.appendWithSeparators(Arrays.asList(new Object[] { "foo", "bar", "baz" }).iterator(), null); 
     assertEquals("foobarbaz", sb.toString()); 
     sb.clear(); 
     sb.appendWithSeparators(Arrays.asList(new Object[] { "foo", null, "baz" }).iterator(), ","); 
     assertEquals("foo,,baz", sb.toString()); 
 }
@Test
public void testAppendln_StringBuilder_int_int9348() { 
     final int[] count = new int[2]; 
     final StrBuilder sb = new StrBuilder() { 
  
         @Override 
         public StrBuilder append(final StringBuilder str, final int startIndex, final int length) { 
             count[0]++; 
             return super.append(str, startIndex, length); 
         } 
  
         @Override 
         public StrBuilder appendNewLine() { 
             count[1]++; 
             return super.appendNewLine(); 
         } 
     }; 
     sb.appendln(new StringBuilder("foo"), 0, 3); 
     assertEquals("foo" + SEP, sb.toString()); 
     assertEquals(1, count[0]); 
     assertEquals(1, count[1]); 
 }
@Test
public void testAppend_StringBuffer_int_int9489() { 
     StrBuilder sb = new StrBuilder(); 
     sb.setNullText("NULL").append((StringBuffer) null, 0, 1); 
     assertEquals("NULL", sb.toString()); 
     sb = new StrBuilder(); 
     sb.append(new StringBuffer("foo"), 0, 3); 
     assertEquals("foo", sb.toString()); 
     try { 
         sb.append(new StringBuffer("bar"), -1, 1); 
         fail("append(char[], -1,) expected IndexOutOfBoundsException"); 
     } catch (final IndexOutOfBoundsException e) { 
     } 
     try { 
         sb.append(new StringBuffer("bar"), 3, 1); 
         fail("append(char[], 3,) expected IndexOutOfBoundsException"); 
     } catch (final IndexOutOfBoundsException e) { 
     } 
     try { 
         sb.append(new StringBuffer("bar"), 1, -1); 
         fail("append(char[],, -1) expected IndexOutOfBoundsException"); 
     } catch (final IndexOutOfBoundsException e) { 
     } 
     try { 
         sb.append(new StringBuffer("bar"), 1, 3); 
         fail("append(char[], 1, 3) expected IndexOutOfBoundsException"); 
     } catch (final IndexOutOfBoundsException e) { 
     } 
     try { 
         sb.append(new StringBuffer("bar"), -1, 3); 
         fail("append(char[], -1, 3) expected IndexOutOfBoundsException"); 
     } catch (final IndexOutOfBoundsException e) { 
     } 
     try { 
         sb.append(new StringBuffer("bar"), 4, 0); 
         fail("append(char[], 4, 0) expected IndexOutOfBoundsException"); 
     } catch (final IndexOutOfBoundsException e) { 
     } 
     sb.append(new StringBuffer("bar"), 3, 0); 
     assertEquals("foo", sb.toString()); 
     sb.append(new StringBuffer("abcbardef"), 3, 3); 
     assertEquals("foobar", sb.toString()); 
 }
@Test
public void testAppend_StrBuilder9491() { 
     StrBuilder sb = new StrBuilder(); 
     sb.setNullText("NULL").append((StrBuilder) null); 
     assertEquals("NULL", sb.toString()); 
     sb = new StrBuilder(); 
     sb.append(new StrBuilder("foo")); 
     assertEquals("foo", sb.toString()); 
     sb.append(new StrBuilder("")); 
     assertEquals("foo", sb.toString()); 
     sb.append(new StrBuilder("bar")); 
     assertEquals("foobar", sb.toString()); 
 }
@Test
public void testAppend_StringBuilder_int_int9543() { 
     StrBuilder sb = new StrBuilder(); 
     sb.setNullText("NULL").append((String) null, 0, 1); 
     assertEquals("NULL", sb.toString()); 
     sb = new StrBuilder(); 
     sb.append(new StringBuilder("foo"), 0, 3); 
     assertEquals("foo", sb.toString()); 
     try { 
         sb.append(new StringBuilder("bar"), -1, 1); 
         fail("append(StringBuilder, -1,) expected IndexOutOfBoundsException"); 
     } catch (final IndexOutOfBoundsException e) { 
     } 
     try { 
         sb.append(new StringBuilder("bar"), 3, 1); 
         fail("append(StringBuilder, 3,) expected IndexOutOfBoundsException"); 
     } catch (final IndexOutOfBoundsException e) { 
     } 
     try { 
         sb.append(new StringBuilder("bar"), 1, -1); 
         fail("append(StringBuilder,, -1) expected IndexOutOfBoundsException"); 
     } catch (final IndexOutOfBoundsException e) { 
     } 
     try { 
         sb.append(new StringBuilder("bar"), 1, 3); 
         fail("append(StringBuilder, 1, 3) expected IndexOutOfBoundsException"); 
     } catch (final IndexOutOfBoundsException e) { 
     } 
     try { 
         sb.append(new StringBuilder("bar"), -1, 3); 
         fail("append(StringBuilder, -1, 3) expected IndexOutOfBoundsException"); 
     } catch (final IndexOutOfBoundsException e) { 
     } 
     try { 
         sb.append(new StringBuilder("bar"), 4, 0); 
         fail("append(StringBuilder, 4, 0) expected IndexOutOfBoundsException"); 
     } catch (final IndexOutOfBoundsException e) { 
     } 
     sb.append(new StringBuilder("bar"), 3, 0); 
     assertEquals("foo", sb.toString()); 
     sb.append(new StringBuilder("abcbardef"), 3, 3); 
     assertEquals("foobar", sb.toString()); 
     sb.append(new StringBuilder("abcbardef"), 4, 3); 
     assertEquals("foobarard", sb.toString()); 
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
    

    //-----------------------------------------------------------------------
    

    //-----------------------------------------------------------------------
    

    //-----------------------------------------------------------------------
    

    //-----------------------------------------------------------------------
    

    // See: http://issues.apache.org/jira/browse/LANG-299
    

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
    

    //-----------------------------------------------------------------------
    

    //-----------------------------------------------------------------------
    
}
