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
public void testAppendFixedWidthPadLeft623() { 
     final StrBuilder sb = new StrBuilder(); 
     sb.appendFixedWidthPadLeft("foo", -1, '-'); 
     assertEquals("", sb.toString()); 
     sb.clear(); 
     sb.appendFixedWidthPadLeft("foo", 0, '-'); 
     assertEquals("", sb.toString()); 
     sb.clear(); 
     sb.appendFixedWidthPadLeft("foo", 1, '-'); 
     assertEquals("o", sb.toString()); 
     sb.clear(); 
     sb.appendFixedWidthPadLeft("foo", 2, '-'); 
     assertEquals("oo", sb.toString()); 
     sb.clear(); 
     sb.appendFixedWidthPadLeft("foo", 3, '-'); 
     assertEquals("foo", sb.toString()); 
     sb.clear(); 
     sb.appendFixedWidthPadLeft("foo", 4, '-'); 
     assertEquals("-foo", sb.toString()); 
     sb.clear(); 
     sb.appendFixedWidthPadLeft("foo", 10, '-'); 
     assertEquals(10, sb.length()); 
     assertEquals("-------foo", sb.toString()); 
     sb.clear(); 
     sb.setNullText("null"); 
     sb.appendFixedWidthPadLeft(null, 5, '-'); 
     assertEquals("-null", sb.toString()); 
 }
@Test
public void testAppend_String624() { 
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
public void testAppend_StrBuilder_int_int634() { 
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
public void testAppendln_String_int_int635() { 
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
public void testAppendWithSeparators_Iterator636() { 
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
public void testAppend_Object637() { 
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
public void testAppend_String_int_int638() { 
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
public void testAppendln_FormattedString639() { 
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
public void testAppendln_StringBuffer640() { 
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
public void testAppendWithNullText641() { 
     final StrBuilder sb = new StrBuilder(); 
     sb.setNullText("NULL"); 
     assertEquals("", sb.toString()); 
     sb.appendNull(); 
     assertEquals("NULL", sb.toString()); 
     sb.append((Object) null); 
     assertEquals("NULLNULL", sb.toString()); 
     sb.append(FOO); 
     assertEquals("NULLNULLfoo", sb.toString()); 
     sb.append((String) null); 
     assertEquals("NULLNULLfooNULL", sb.toString()); 
     sb.append(""); 
     assertEquals("NULLNULLfooNULL", sb.toString()); 
     sb.append("bar"); 
     assertEquals("NULLNULLfooNULLbar", sb.toString()); 
     sb.append((StringBuffer) null); 
     assertEquals("NULLNULLfooNULLbarNULL", sb.toString()); 
     sb.append(new StringBuffer("baz")); 
     assertEquals("NULLNULLfooNULLbarNULLbaz", sb.toString()); 
 }
@Test
public void testAppend_StringBuffer_int_int642() { 
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
public void testAppendln_StringBuilder643() { 
     final int[] count = new int[2]; 
     final StrBuilder sb = new StrBuilder() { 
  
         @Override 
         public StrBuilder append(final StringBuilder str) { 
             count[0]++; 
             return super.append(str); 
         } 
  
         @Override 
         public StrBuilder appendNewLine() { 
             count[1]++; 
             return super.appendNewLine(); 
         } 
     }; 
     sb.appendln(new StringBuilder("foo")); 
     assertEquals("foo" + SEP, sb.toString()); 
     assertEquals(1, count[0]); 
     assertEquals(1, count[1]); 
 }
@Test
public void testAppendln_StringBuilder_int_int644() { 
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
public void testAppend_StringBuilder_int_int645() { 
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
public void testAppend_StrBuilder646() { 
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
public void testAppend_CharArray648() { 
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
public void testAppend_CharArray_int_int649() { 
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
public void testAppend_Boolean650() { 
     final StrBuilder sb = new StrBuilder(); 
     sb.append(true); 
     assertEquals("true", sb.toString()); 
     sb.append(false); 
     assertEquals("truefalse", sb.toString()); 
     sb.append('!'); 
     assertEquals("truefalse!", sb.toString()); 
 }
@Test
public void testAppend_PrimitiveNumber651() { 
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
public void testAppendln_Object652() { 
     final StrBuilder sb = new StrBuilder(); 
     sb.appendln((Object) null); 
     assertEquals("" + SEP, sb.toString()); 
     sb.appendln(FOO); 
     assertEquals(SEP + "foo" + SEP, sb.toString()); 
     sb.appendln(Integer.valueOf(6)); 
     assertEquals(SEP + "foo" + SEP + "6" + SEP, sb.toString()); 
 }
@Test
public void testAppendln_String653() { 
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
public void testAppendln_StrBuilder654() { 
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
public void testAppendln_StrBuilder_int_int655() { 
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
public void testAppendln_CharArray_int_int656() { 
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
public void testAppendln_PrimitiveNumber657() { 
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
public void testAppendAll_Iterator659() { 
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
public void testAppendSeparator_String660() { 
     final StrBuilder sb = new StrBuilder(); 
     sb.appendSeparator(","); 
     assertEquals("", sb.toString()); 
     sb.append("foo"); 
     assertEquals("foo", sb.toString()); 
     sb.appendSeparator(","); 
     assertEquals("foo,", sb.toString()); 
 }
@Test
public void testAppendSeparator_String_String661() { 
     final StrBuilder sb = new StrBuilder(); 
     final String startSeparator = "order by "; 
     final String standardSeparator = ","; 
     final String foo = "foo"; 
     sb.appendSeparator(null, null); 
     assertEquals("", sb.toString()); 
     sb.appendSeparator(standardSeparator, null); 
     assertEquals("", sb.toString()); 
     sb.appendSeparator(standardSeparator, startSeparator); 
     assertEquals(startSeparator, sb.toString()); 
     sb.appendSeparator(null, null); 
     assertEquals(startSeparator, sb.toString()); 
     sb.appendSeparator(null, startSeparator); 
     assertEquals(startSeparator, sb.toString()); 
     sb.append(foo); 
     assertEquals(startSeparator + foo, sb.toString()); 
     sb.appendSeparator(standardSeparator, startSeparator); 
     assertEquals(startSeparator + foo + standardSeparator, sb.toString()); 
 }
@Test
public void testAppendSeparator_char662() { 
     final StrBuilder sb = new StrBuilder(); 
     sb.appendSeparator(','); 
     assertEquals("", sb.toString()); 
     sb.append("foo"); 
     assertEquals("foo", sb.toString()); 
     sb.appendSeparator(','); 
     assertEquals("foo,", sb.toString()); 
 }
@Test
public void testAppendSeparator_String_int663() { 
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
public void testAppendSeparator_char_int664() { 
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
public void testAppendPadding665() { 
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
public void testAppendFixedWidthPadLeft_int666() { 
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
public void testLang299667() { 
     final StrBuilder sb = new StrBuilder(1); 
     sb.appendFixedWidthPadRight("foo", 1, '-'); 
     assertEquals("f", sb.toString()); 
 }
@Test
public void testAppendFixedWidthPadRight669() { 
     final StrBuilder sb = new StrBuilder(); 
     sb.appendFixedWidthPadRight("foo", -1, '-'); 
     assertEquals("", sb.toString()); 
     sb.clear(); 
     sb.appendFixedWidthPadRight("foo", 0, '-'); 
     assertEquals("", sb.toString()); 
     sb.clear(); 
     sb.appendFixedWidthPadRight("foo", 1, '-'); 
     assertEquals("f", sb.toString()); 
     sb.clear(); 
     sb.appendFixedWidthPadRight("foo", 2, '-'); 
     assertEquals("fo", sb.toString()); 
     sb.clear(); 
     sb.appendFixedWidthPadRight("foo", 3, '-'); 
     assertEquals("foo", sb.toString()); 
     sb.clear(); 
     sb.appendFixedWidthPadRight("foo", 4, '-'); 
     assertEquals("foo-", sb.toString()); 
     sb.clear(); 
     sb.appendFixedWidthPadRight("foo", 10, '-'); 
     assertEquals(10, sb.length()); 
     assertEquals("foo-------", sb.toString()); 
     sb.clear(); 
     sb.setNullText("null"); 
     sb.appendFixedWidthPadRight(null, 5, '-'); 
     assertEquals("null-", sb.toString()); 
 }
@Test
public void testAppendFixedWidthPadRight_int670() { 
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
public void testInsertWithNullText671() { 
     final StrBuilder sb = new StrBuilder(); 
     sb.setNullText("null"); 
     sb.append("barbaz"); 
     assertEquals("barbaz", sb.toString()); 
     try { 
         sb.insert(-1, FOO); 
         fail("insert(-1, Object) expected StringIndexOutOfBoundsException"); 
     } catch (final IndexOutOfBoundsException e) { 
     } 
     try { 
         sb.insert(7, FOO); 
         fail("insert(7, Object) expected StringIndexOutOfBoundsException"); 
     } catch (final IndexOutOfBoundsException e) { 
     } 
     sb.insert(0, (Object) null); 
     assertEquals("nullbarbaz", sb.toString()); 
     sb.insert(0, FOO); 
     assertEquals("foonullbarbaz", sb.toString()); 
     sb.clear(); 
     sb.append("barbaz"); 
     assertEquals("barbaz", sb.toString()); 
     try { 
         sb.insert(-1, "foo"); 
         fail("insert(-1, String) expected StringIndexOutOfBoundsException"); 
     } catch (final IndexOutOfBoundsException e) { 
     } 
     try { 
         sb.insert(7, "foo"); 
         fail("insert(7, String) expected StringIndexOutOfBoundsException"); 
     } catch (final IndexOutOfBoundsException e) { 
     } 
     sb.insert(0, (String) null); 
     assertEquals("nullbarbaz", sb.toString()); 
     sb.insert(0, "foo"); 
     assertEquals("foonullbarbaz", sb.toString()); 
     sb.insert(0, (char[]) null); 
     assertEquals("nullfoonullbarbaz", sb.toString()); 
     sb.insert(0, (char[]) null, 0, 0); 
     assertEquals("nullnullfoonullbarbaz", sb.toString()); 
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
