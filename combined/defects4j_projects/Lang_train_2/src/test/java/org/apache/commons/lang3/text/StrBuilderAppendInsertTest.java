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
public void testAppendFixedWidthPadLeft627() { 
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
public void testAppend_String628() { 
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
public void testAppend_StrBuilder_int_int637() { 
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
public void testAppendln_String_int_int639() { 
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
public void testAppendNewLine640() { 
     StrBuilder sb = new StrBuilder("---"); 
     sb.appendNewLine().append("+++"); 
     assertEquals("---" + SEP + "+++", sb.toString()); 
     sb = new StrBuilder("---"); 
     sb.setNewLineText("#").appendNewLine().setNewLineText(null).appendNewLine(); 
     assertEquals("---#" + SEP, sb.toString()); 
 }
@Test
public void testAppendWithSeparators_Iterator641() { 
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
public void testAppend_Object642() { 
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
public void testAppend_String_int_int643() { 
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
public void testAppendln_FormattedString644() { 
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
public void testAppendln_StringBuffer645() { 
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
public void testAppendWithNullText646() { 
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
public void testAppend_StringBuffer_int_int647() { 
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
public void testAppendln_StringBuilder_int_int648() { 
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
public void testAppend_CharArray650() { 
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
public void testAppend_CharArray_int_int651() { 
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
public void testAppend_Boolean652() { 
     final StrBuilder sb = new StrBuilder(); 
     sb.append(true); 
     assertEquals("true", sb.toString()); 
     sb.append(false); 
     assertEquals("truefalse", sb.toString()); 
     sb.append('!'); 
     assertEquals("truefalse!", sb.toString()); 
 }
@Test
public void testAppend_PrimitiveNumber653() { 
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
public void testAppendln_String654() { 
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
public void testAppendln_StringBuffer_int_int655() { 
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
public void testAppendln_StrBuilder_int_int656() { 
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
public void testAppendln_CharArray657() { 
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
public void testAppendln_Boolean658() { 
     final StrBuilder sb = new StrBuilder(); 
     sb.appendln(true); 
     assertEquals("true" + SEP, sb.toString()); 
     sb.clear(); 
     sb.appendln(false); 
     assertEquals("false" + SEP, sb.toString()); 
 }
@Test
public void testAppendAll_Collection660() { 
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
public void testAppendAll_Iterator661() { 
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
public void testAppendWithSeparators_Array662() { 
     final StrBuilder sb = new StrBuilder(); 
     sb.appendWithSeparators((Object[]) null, ","); 
     assertEquals("", sb.toString()); 
     sb.clear(); 
     sb.appendWithSeparators(new Object[0], ","); 
     assertEquals("", sb.toString()); 
     sb.clear(); 
     sb.appendWithSeparators(new Object[] { "foo", "bar", "baz" }, ","); 
     assertEquals("foo,bar,baz", sb.toString()); 
     sb.clear(); 
     sb.appendWithSeparators(new Object[] { "foo", "bar", "baz" }, null); 
     assertEquals("foobarbaz", sb.toString()); 
     sb.clear(); 
     sb.appendWithSeparators(new Object[] { "foo", null, "baz" }, ","); 
     assertEquals("foo,,baz", sb.toString()); 
 }
@Test
public void testAppendWithSeparators_Collection663() { 
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
public void testAppendSeparator_String664() { 
     final StrBuilder sb = new StrBuilder(); 
     sb.appendSeparator(","); 
     assertEquals("", sb.toString()); 
     sb.append("foo"); 
     assertEquals("foo", sb.toString()); 
     sb.appendSeparator(","); 
     assertEquals("foo,", sb.toString()); 
 }
@Test
public void testAppendSeparator_String_String665() { 
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
public void testAppendSeparator_char666() { 
     final StrBuilder sb = new StrBuilder(); 
     sb.appendSeparator(','); 
     assertEquals("", sb.toString()); 
     sb.append("foo"); 
     assertEquals("foo", sb.toString()); 
     sb.appendSeparator(','); 
     assertEquals("foo,", sb.toString()); 
 }
@Test
public void testAppendSeparator_char_char667() { 
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
public void testAppendSeparator_String_int668() { 
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
public void testAppendPadding669() { 
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
public void testLang299671() { 
     final StrBuilder sb = new StrBuilder(1); 
     sb.appendFixedWidthPadRight("foo", 1, '-'); 
     assertEquals("f", sb.toString()); 
 }
@Test
public void testAppendFixedWidthPadRight673() { 
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
public void testAppendFixedWidthPadRight_int674() { 
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
public void testInsertWithNullText675() { 
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
@Test
public void testInsert676() { 
     final StrBuilder sb = new StrBuilder(); 
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
     assertEquals("barbaz", sb.toString()); 
     sb.insert(0, FOO); 
     assertEquals("foobarbaz", sb.toString()); 
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
     assertEquals("barbaz", sb.toString()); 
     sb.insert(0, "foo"); 
     assertEquals("foobarbaz", sb.toString()); 
     sb.clear(); 
     sb.append("barbaz"); 
     assertEquals("barbaz", sb.toString()); 
     try { 
         sb.insert(-1, new char[] { 'f', 'o', 'o' }); 
         fail("insert(-1, char[]) expected StringIndexOutOfBoundsException"); 
     } catch (final IndexOutOfBoundsException e) { 
     } 
     try { 
         sb.insert(7, new char[] { 'f', 'o', 'o' }); 
         fail("insert(7, char[]) expected StringIndexOutOfBoundsException"); 
     } catch (final IndexOutOfBoundsException e) { 
     } 
     sb.insert(0, (char[]) null); 
     assertEquals("barbaz", sb.toString()); 
     sb.insert(0, new char[0]); 
     assertEquals("barbaz", sb.toString()); 
     sb.insert(0, new char[] { 'f', 'o', 'o' }); 
     assertEquals("foobarbaz", sb.toString()); 
     sb.clear(); 
     sb.append("barbaz"); 
     assertEquals("barbaz", sb.toString()); 
     try { 
         sb.insert(-1, new char[] { 'a', 'b', 'c', 'f', 'o', 'o', 'd', 'e', 'f' }, 3, 3); 
         fail("insert(-1, char[], 3, 3) expected StringIndexOutOfBoundsException"); 
     } catch (final IndexOutOfBoundsException e) { 
     } 
     try { 
         sb.insert(7, new char[] { 'a', 'b', 'c', 'f', 'o', 'o', 'd', 'e', 'f' }, 3, 3); 
         fail("insert(7, char[], 3, 3) expected StringIndexOutOfBoundsException"); 
     } catch (final IndexOutOfBoundsException e) { 
     } 
     sb.insert(0, (char[]) null, 0, 0); 
     assertEquals("barbaz", sb.toString()); 
     sb.insert(0, new char[0], 0, 0); 
     assertEquals("barbaz", sb.toString()); 
     try { 
         sb.insert(0, new char[] { 'a', 'b', 'c', 'f', 'o', 'o', 'd', 'e', 'f' }, -1, 3); 
         fail("insert(0, char[], -1, 3) expected StringIndexOutOfBoundsException"); 
     } catch (final IndexOutOfBoundsException e) { 
     } 
     try { 
         sb.insert(0, new char[] { 'a', 'b', 'c', 'f', 'o', 'o', 'd', 'e', 'f' }, 10, 3); 
         fail("insert(0, char[], 10, 3) expected StringIndexOutOfBoundsException"); 
     } catch (final IndexOutOfBoundsException e) { 
     } 
     try { 
         sb.insert(0, new char[] { 'a', 'b', 'c', 'f', 'o', 'o', 'd', 'e', 'f' }, 0, -1); 
         fail("insert(0, char[], 0, -1) expected StringIndexOutOfBoundsException"); 
     } catch (final IndexOutOfBoundsException e) { 
     } 
     try { 
         sb.insert(0, new char[] { 'a', 'b', 'c', 'f', 'o', 'o', 'd', 'e', 'f' }, 0, 10); 
         fail("insert(0, char[], 0, 10) expected StringIndexOutOfBoundsException"); 
     } catch (final IndexOutOfBoundsException e) { 
     } 
     sb.insert(0, new char[] { 'a', 'b', 'c', 'f', 'o', 'o', 'd', 'e', 'f' }, 0, 0); 
     assertEquals("barbaz", sb.toString()); 
     sb.insert(0, new char[] { 'a', 'b', 'c', 'f', 'o', 'o', 'd', 'e', 'f' }, 3, 3); 
     assertEquals("foobarbaz", sb.toString()); 
     sb.clear(); 
     sb.append("barbaz"); 
     assertEquals("barbaz", sb.toString()); 
     try { 
         sb.insert(-1, true); 
         fail("insert(-1, boolean) expected StringIndexOutOfBoundsException"); 
     } catch (final IndexOutOfBoundsException e) { 
     } 
     try { 
         sb.insert(7, true); 
         fail("insert(7, boolean) expected StringIndexOutOfBoundsException"); 
     } catch (final IndexOutOfBoundsException e) { 
     } 
     sb.insert(0, true); 
     assertEquals("truebarbaz", sb.toString()); 
     sb.insert(0, false); 
     assertEquals("falsetruebarbaz", sb.toString()); 
     sb.clear(); 
     sb.append("barbaz"); 
     assertEquals("barbaz", sb.toString()); 
     try { 
         sb.insert(-1, '!'); 
         fail("insert(-1, char) expected StringIndexOutOfBoundsException"); 
     } catch (final IndexOutOfBoundsException e) { 
     } 
     try { 
         sb.insert(7, '!'); 
         fail("insert(7, char) expected StringIndexOutOfBoundsException"); 
     } catch (final IndexOutOfBoundsException e) { 
     } 
     sb.insert(0, '!'); 
     assertEquals("!barbaz", sb.toString()); 
     sb.clear(); 
     sb.append("barbaz"); 
     assertEquals("barbaz", sb.toString()); 
     try { 
         sb.insert(-1, 0); 
         fail("insert(-1, int) expected StringIndexOutOfBoundsException"); 
     } catch (final IndexOutOfBoundsException e) { 
     } 
     try { 
         sb.insert(7, 0); 
         fail("insert(7, int) expected StringIndexOutOfBoundsException"); 
     } catch (final IndexOutOfBoundsException e) { 
     } 
     sb.insert(0, '0'); 
     assertEquals("0barbaz", sb.toString()); 
     sb.clear(); 
     sb.append("barbaz"); 
     assertEquals("barbaz", sb.toString()); 
     try { 
         sb.insert(-1, 1L); 
         fail("insert(-1, long) expected StringIndexOutOfBoundsException"); 
     } catch (final IndexOutOfBoundsException e) { 
     } 
     try { 
         sb.insert(7, 1L); 
         fail("insert(7, long) expected StringIndexOutOfBoundsException"); 
     } catch (final IndexOutOfBoundsException e) { 
     } 
     sb.insert(0, 1L); 
     assertEquals("1barbaz", sb.toString()); 
     sb.clear(); 
     sb.append("barbaz"); 
     assertEquals("barbaz", sb.toString()); 
     try { 
         sb.insert(-1, 2.3F); 
         fail("insert(-1, float) expected StringIndexOutOfBoundsException"); 
     } catch (final IndexOutOfBoundsException e) { 
     } 
     try { 
         sb.insert(7, 2.3F); 
         fail("insert(7, float) expected StringIndexOutOfBoundsException"); 
     } catch (final IndexOutOfBoundsException e) { 
     } 
     sb.insert(0, 2.3F); 
     assertEquals("2.3barbaz", sb.toString()); 
     sb.clear(); 
     sb.append("barbaz"); 
     assertEquals("barbaz", sb.toString()); 
     try { 
         sb.insert(-1, 4.5D); 
         fail("insert(-1, double) expected StringIndexOutOfBoundsException"); 
     } catch (final IndexOutOfBoundsException e) { 
     } 
     try { 
         sb.insert(7, 4.5D); 
         fail("insert(7, double) expected StringIndexOutOfBoundsException"); 
     } catch (final IndexOutOfBoundsException e) { 
     } 
     sb.insert(0, 4.5D); 
     assertEquals("4.5barbaz", sb.toString()); 
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