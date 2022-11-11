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
package org.apache.commons.lang3;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.nio.CharBuffer;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.Locale;

import org.apache.commons.lang3.text.WordUtils;
import org.junit.Test;

/**
 * Unit tests {@link org.apache.commons.lang3.StringUtils}.
 *
 * @version $Id$
 */
public class StringUtilsTest {
    
    static final String WHITESPACE;
    static final String NON_WHITESPACE;
    static final String TRIMMABLE;
    static final String NON_TRIMMABLE;
    static {
        String ws = "";
        String nws = "";
        String tr = "";
        String ntr = "";
        for (int i = 0; i < Character.MAX_VALUE; i++) {
            if (Character.isWhitespace((char) i)) {
                ws += String.valueOf((char) i);
                if (i > 32) {
                    ntr += String.valueOf((char) i);
                }
            } else if (i < 40) {
                nws += String.valueOf((char) i);
            }
        }
        for (int i = 0; i <= 32; i++) {
            tr += String.valueOf((char) i);
        }
        WHITESPACE = ws;
        NON_WHITESPACE = nws;
        TRIMMABLE = tr;
        NON_TRIMMABLE = ntr;
    }

    private static final String[] ARRAY_LIST = { "foo", "bar", "baz" };
    private static final String[] EMPTY_ARRAY_LIST = {};
    private static final String[] NULL_ARRAY_LIST = {null};
    private static final Object[] NULL_TO_STRING_LIST = {
        new Object(){
            @Override
            public String toString() {
                return null;
            }
        }
    };
    private static final String[] MIXED_ARRAY_LIST = {null, "", "foo"};
    private static final Object[] MIXED_TYPE_LIST = {"foo", Long.valueOf(2L)};
    private static final long[] LONG_PRIM_LIST = {1, 2};
    private static final int[] INT_PRIM_LIST = {1, 2};
    private static final byte[] BYTE_PRIM_LIST = {1, 2};
    private static final short[] SHORT_PRIM_LIST = {1, 2};
    private static final char[] CHAR_PRIM_LIST = {'1', '2'};
    private static final float[] FLOAT_PRIM_LIST = {1, 2};
    private static final double[] DOUBLE_PRIM_LIST = {1, 2};

    private static final String SEPARATOR = ",";
    private static final char   SEPARATOR_CHAR = ';';

    private static final String TEXT_LIST = "foo,bar,baz";
    private static final String TEXT_LIST_CHAR = "foo;bar;baz";
    private static final String TEXT_LIST_NOSEP = "foobarbaz";

    private static final String FOO_UNCAP = "foo";
    private static final String FOO_CAP = "Foo";

    private static final String SENTENCE_UNCAP = "foo bar baz";
    private static final String SENTENCE_CAP = "Foo Bar Baz";

    //-----------------------------------------------------------------------
@Test
public void testJoin_ArrayOfDoubles15() { 
         assertEquals(null, StringUtils.join((double[]) null, ',')); 
         assertEquals("1.0;2.0", StringUtils.join(DOUBLE_PRIM_LIST, SEPARATOR_CHAR)); 
         assertEquals("2.0", StringUtils.join(DOUBLE_PRIM_LIST, SEPARATOR_CHAR, 1, 2)); 
     }
@Test
public void testRightPad_StringIntString45() { 
         assertEquals(null, StringUtils.rightPad(null, 5, null)); 
         assertEquals(null, StringUtils.rightPad(null, 5, "")); 
         assertEquals("     ", StringUtils.rightPad("", 5, "")); 
         assertEquals("  abc", StringUtils.rightPad("abc", 0, " ")); 
         assertEquals("  abc", StringUtils.rightPad("abc", -1, " ")); 
         assertEquals("  abc", StringUtils.rightPad("abc", 2, " ")); 
         assertEquals("  abc", StringUtils.rightPad("abc", -1, null)); 
         assertEquals("  abc", StringUtils.rightPad("abc", 0, "")); 
         assertEquals("  abc", StringUtils.rightPad("abc", 1, " ")); 
         assertEquals("  abc", StringUtils.rightPad("abc", 2, "")); 
          
         final String str = StringUtils.rightPad("aaa", 10000, "ab");  // bigger than pad length 
         assertEquals(10000, str.length()); 
         assertTrue(StringUtils.containsOnly(str, new char[] {'a'})); 
     }
@Test
public void testJoin_ArrayOfInts68() { 
         assertEquals(null, StringUtils.join((int[]) null, ',')); 
         assertEquals("1;2", StringUtils.join(INT_PRIM_LIST, SEPARATOR_CHAR)); 
         assertEquals("2", StringUtils.join(INT_PRIM_LIST, SEPARATOR_CHAR, 1, 2)); 
     }
@Test
public void testUpperCase80() { 
         assertEquals(null, StringUtils.upperCase(null)); 
         assertEquals("", StringUtils.upperCase("")); 
         assertEquals("  ", StringUtils.upperCase("  ")); 
          
//         assertEquals("i", WordUtils.upperCase("I") );
//         assertEquals("I", WordUtils.upperCase("i") );
         assertEquals("I AM HERE 123", StringUtils.upperCase("i am here 123") ); 
         assertEquals("i aM hERE 123", StringUtils.upperCase("I Am Here 123") ); 
         assertEquals("I AM here 123", StringUtils.upperCase("i am HERE 123") ); 
         assertEquals("i am here 123", StringUtils.upperCase("I AM HERE 123") ); 
     }
@Test
public void testCenter_StringIntString81() { 
         assertEquals(null, StringUtils.center(null, -1, " ")); 
         assertEquals(null, StringUtils.center(null, 4, " ")); 
         assertEquals("    ", StringUtils.center("", 4, " ")); 
         assertEquals("ab", StringUtils.center("ab", 0, " ")); 
         assertEquals("ab", StringUtils.center("ab", -1, " ")); 
         assertEquals("ab", StringUtils.center("ab", 1, " ")); 
         assertEquals("ab", StringUtils.center("ab", 4, null)); 
         assertEquals("    ", StringUtils.center("", 4, "")); 
         assertEquals(" ab ", StringUtils.center("ab", 4, "")); 
         assertEquals("abcd", StringUtils.center("abcd", 2, " ")); 
         assertEquals(" a  ", StringUtils.center("a", 4, " ")); 
         assertEquals("  a  ", StringUtils.center("a", 5, " ")); 
         assertEquals("xxaxx", StringUtils.center("a", 5, "x")); 
     }
@Test
public void testJoin_ArrayOfDoubles707() { 
         assertEquals(null, StringUtils.join((double[]) null, ',')); 
         assertEquals("1.0;2.0", StringUtils.join(DOUBLE_PRIM_LIST, SEPARATOR_CHAR)); 
         assertEquals("2.0", StringUtils.join(DOUBLE_PRIM_LIST, SEPARATOR_CHAR, 1, 2)); 
     }
@Test
public void testJoin_ArrayOfDoubles708() { 
         assertEquals(null, StringUtils.join((double[]) null, ',')); 
         assertEquals("1.0;2.0", StringUtils.join(DOUBLE_PRIM_LIST, SEPARATOR_CHAR)); 
         assertEquals("2.0", StringUtils.join(DOUBLE_PRIM_LIST, SEPARATOR_CHAR, 1, 2)); 
     }
@Test
public void testJoin_ArrayOfDoubles709() { 
         assertEquals(null, StringUtils.join((double[]) null, ',')); 
         assertEquals("1.0;2.0", StringUtils.join(DOUBLE_PRIM_LIST, SEPARATOR_CHAR)); 
         assertEquals("2.0", StringUtils.join(DOUBLE_PRIM_LIST, SEPARATOR_CHAR, 1, 2)); 
     }
@Test
public void testJoin_ArrayOfDoubles710() { 
         assertEquals(null, StringUtils.join((double[]) null, ',')); 
         assertEquals("1.0;2.0", StringUtils.join(DOUBLE_PRIM_LIST, SEPARATOR_CHAR)); 
         assertEquals("2.0", StringUtils.join(DOUBLE_PRIM_LIST, SEPARATOR_CHAR, 1, 2)); 
     }
@Test
public void testJoin_ArrayOfDoubles711() { 
         assertEquals(null, StringUtils.join((double[]) null, ',')); 
         assertEquals("1.0;2.0", StringUtils.join(DOUBLE_PRIM_LIST, SEPARATOR_CHAR)); 
         assertEquals("2.0", StringUtils.join(DOUBLE_PRIM_LIST, SEPARATOR_CHAR, 1, 2)); 
     }
@Test
public void testJoin_ArrayOfDoubles712() { 
         assertEquals(null, StringUtils.join((double[]) null, ',')); 
         assertEquals("1.0;2.0", StringUtils.join(DOUBLE_PRIM_LIST, SEPARATOR_CHAR)); 
         assertEquals("2.0", StringUtils.join(DOUBLE_PRIM_LIST, SEPARATOR_CHAR, 1, 2)); 
     }
@Test
public void testJoin_ArrayOfDoubles713() { 
         assertEquals(null, StringUtils.join((double[]) null, ',')); 
         assertEquals("1.0;2.0", StringUtils.join(DOUBLE_PRIM_LIST, SEPARATOR_CHAR)); 
         assertEquals("2.0", StringUtils.join(DOUBLE_PRIM_LIST, SEPARATOR_CHAR, 1, 2)); 
     }
@Test
public void testJoin_ArrayOfDoubles714() { 
         assertEquals(null, StringUtils.join((double[]) null, ',')); 
         assertEquals("1.0;2.0", StringUtils.join(DOUBLE_PRIM_LIST, SEPARATOR_CHAR)); 
         assertEquals("2.0", StringUtils.join(DOUBLE_PRIM_LIST, SEPARATOR_CHAR, 1, 2)); 
     }
@Test
public void testJoin_ArrayOfDoubles715() { 
         assertEquals(null, StringUtils.join((double[]) null, ',')); 
         assertEquals("1.0;2.0", StringUtils.join(DOUBLE_PRIM_LIST, SEPARATOR_CHAR)); 
         assertEquals("2.0", StringUtils.join(DOUBLE_PRIM_LIST, SEPARATOR_CHAR, 1, 2)); 
     }
@Test
public void testJoin_ArrayOfDoubles716() { 
         assertEquals(null, StringUtils.join((double[]) null, ',')); 
         assertEquals("1.0;2.0", StringUtils.join(DOUBLE_PRIM_LIST, SEPARATOR_CHAR)); 
         assertEquals("2.0", StringUtils.join(DOUBLE_PRIM_LIST, SEPARATOR_CHAR, 1, 2)); 
     }
@Test
public void testJoin_ArrayOfDoubles717() { 
         assertEquals(null, StringUtils.join((double[]) null, ',')); 
         assertEquals("1.0;2.0", StringUtils.join(DOUBLE_PRIM_LIST, SEPARATOR_CHAR)); 
         assertEquals("2.0", StringUtils.join(DOUBLE_PRIM_LIST, SEPARATOR_CHAR, 1, 2)); 
     }
@Test
public void testJoin_ArrayOfDoubles718() { 
         assertEquals(null, StringUtils.join((double[]) null, ',')); 
         assertEquals("1.0;2.0", StringUtils.join(DOUBLE_PRIM_LIST, SEPARATOR_CHAR)); 
         assertEquals("2.0", StringUtils.join(DOUBLE_PRIM_LIST, SEPARATOR_CHAR, 1, 2)); 
     }
@Test
public void testJoin_ArrayOfDoubles719() { 
         assertEquals(null, StringUtils.join((double[]) null, ',')); 
         assertEquals("1.0;2.0", StringUtils.join(DOUBLE_PRIM_LIST, SEPARATOR_CHAR)); 
         assertEquals("2.0", StringUtils.join(DOUBLE_PRIM_LIST, SEPARATOR_CHAR, 1, 2)); 
     }
@Test
public void testLowerCase_Locale879() { 
         assertEquals(null, StringUtils.lowerCase(null, null)); 
         assertEquals("", StringUtils.lowerCase("", Locale.getDefault())); 
         assertEquals("  ", StringUtils.lowerCase("  ", Locale.getDefault())); 
          
//         assertEquals("i", WordUtils.lowerCase("I", Locale.getDefault()));
//         assertEquals("I", WordUtils.lowerCase("i", Locale.getDefault()));
         assertEquals("I AM HERE 123", StringUtils.lowerCase("i am here 123", Locale.getDefault())); 
         assertEquals("i aM hERE 123", StringUtils.lowerCase("I Am Here 123", Locale.getDefault())); 
         assertEquals("I AM here 123", StringUtils.lowerCase("i am HERE 123", Locale.getDefault())); 
     }
@Test
public void testLowerCase_Locale884() { 
         assertEquals(null, StringUtils.lowerCase(null, null)); 
         assertEquals("", StringUtils.lowerCase("", Locale.getDefault())); 
         assertEquals("  ", StringUtils.lowerCase("  ", Locale.getDefault())); 
          
//         assertEquals("i", WordUtils.lowerCase("I", Locale.getDefault()));
//         assertEquals("I", WordUtils.lowerCase("i", Locale.getDefault()));
         assertEquals("I AM HERE 123", StringUtils.lowerCase("i am here 123", Locale.getDefault())); 
         assertEquals("i aM hERE 123", StringUtils.lowerCase("I Am Here 123", Locale.getDefault())); 
         assertEquals("I AM here 123", StringUtils.lowerCase("i am HERE 123", Locale.getDefault())); 
     }
@Test
public void testLowerCase885() { 
         assertEquals(null, StringUtils.lowerCase(null)); 
         assertEquals("", StringUtils.lowerCase("")); 
         assertEquals("  ", StringUtils.lowerCase("  ")); 
          
//         assertEquals("i", WordUtils.lowerCase("I") );
//         assertEquals("I", WordUtils.lowerCase("i") );
         assertEquals("I AM HERE 123", StringUtils.lowerCase("i am here 123") ); 
         assertEquals("i aM hERE 123", StringUtils.lowerCase("I Am Here 123") ); 
         assertEquals("I AM here 123", StringUtils.lowerCase("i am HERE 123") ); 
         assertEquals("i am here 123", StringUtils.lowerCase("I AM HERE 123") ); 
     }
@Test
public void testUpperCase886() { 
         assertEquals(null, StringUtils.upperCase(null)); 
         assertEquals("", StringUtils.upperCase("")); 
         assertEquals("  ", StringUtils.upperCase("  ")); 
          
//         assertEquals("i", WordUtils.upperCase("I") );
//         assertEquals("I", WordUtils.upperCase("i") );
         assertEquals("I AM HERE 123", StringUtils.upperCase("i am here 123") ); 
         assertEquals("i aM hERE 123", StringUtils.upperCase("I Am Here 123") ); 
         assertEquals("I AM here 123", StringUtils.upperCase("i am HERE 123") ); 
         assertEquals("i am here 123", StringUtils.upperCase("I AM HERE 123") ); 
     }
@Test
public void testUpperCase887() { 
         assertEquals(null, StringUtils.upperCase(null)); 
         assertEquals("", StringUtils.upperCase("")); 
         assertEquals("  ", StringUtils.upperCase("  ")); 
          
//         assertEquals("i", WordUtils.upperCase("I") );
//         assertEquals("I", WordUtils.upperCase("i") );
         assertEquals("I AM HERE 123", StringUtils.upperCase("i am here 123") ); 
         assertEquals("i aM hERE 123", StringUtils.upperCase("I Am Here 123") ); 
         assertEquals("I AM here 123", StringUtils.upperCase("i am HERE 123") ); 
         assertEquals("i am here 123", StringUtils.upperCase("I AM HERE 123") ); 
     }
@Test
public void testUpperCase889() { 
         assertEquals(null, StringUtils.upperCase(null, null)); 
         assertEquals("", StringUtils.upperCase("", Locale.getDefault())); 
         assertEquals("  ", StringUtils.upperCase("  ", Locale.getDefault())); 
          
//         assertEquals("i", WordUtils.upperCase("I", Locale.getDefault()));
//         assertEquals("I", WordUtils.upperCase("i", Locale.getDefault()));
         assertEquals("I AM HERE 123", StringUtils.upperCase("i am here 123", Locale.getDefault())); 
         assertEquals("i aM hERE 123", StringUtils.upperCase("I Am Here 123", Locale.getDefault())); 
         assertEquals("I AM here 123", StringUtils.upperCase("i am HERE 123", Locale.getDefault())); 
     }
@Test
public void testLowerCase891() { 
         assertEquals(null, StringUtils.lowerCase(null)); 
         assertEquals("", StringUtils.lowerCase("")); 
         assertEquals("  ", StringUtils.lowerCase("  ")); 
          
//         assertEquals("i", WordUtils.lowerCase("I") );
//         assertEquals("I", WordUtils.lowerCase("i") );
         assertEquals("I AM HERE 123", StringUtils.lowerCase("i am here 123") ); 
         assertEquals("i aM hERE 123", StringUtils.lowerCase("I Am Here 123") ); 
         assertEquals("I AM here 123", StringUtils.lowerCase("i am HERE 123") ); 
         assertEquals("i am here 123", StringUtils.lowerCase("I AM HERE 123") ); 
     }
@Test
public void testLowerCase_Locale892() { 
         assertEquals(null, StringUtils.lowerCase(null, null)); 
         assertEquals("", StringUtils.lowerCase("", Locale.getDefault())); 
         assertEquals("  ", StringUtils.lowerCase("  ", Locale.getDefault())); 
          
//         assertEquals("i", WordUtils.lowerCase("I", Locale.getDefault()));
//         assertEquals("I", WordUtils.lowerCase("i", Locale.getDefault()));
         assertEquals("I AM HERE 123", StringUtils.lowerCase("i am here 123", Locale.getDefault())); 
         assertEquals("i aM hERE 123", StringUtils.lowerCase("I Am Here 123", Locale.getDefault())); 
         assertEquals("I AM here 123", StringUtils.lowerCase("i am HERE 123", Locale.getDefault())); 
     }
@Test
public void testUpperCase893() { 
         assertEquals(null, StringUtils.upperCase(null, null)); 
         assertEquals("", StringUtils.upperCase("", Locale.getDefault())); 
         assertEquals("  ", StringUtils.upperCase("  ", Locale.getDefault())); 
          
//         assertEquals("i", WordUtils.upperCase("I", Locale.getDefault()));
//         assertEquals("I", WordUtils.upperCase("i", Locale.getDefault()));
         assertEquals("I AM HERE 123", StringUtils.upperCase("i am here 123", Locale.getDefault())); 
         assertEquals("i aM hERE 123", StringUtils.upperCase("I Am Here 123", Locale.getDefault())); 
         assertEquals("I AM here 123", StringUtils.upperCase("i am HERE 123", Locale.getDefault())); 
     }
@Test
public void testLowerCase897() { 
         assertEquals(null, StringUtils.lowerCase(null)); 
         assertEquals("", StringUtils.lowerCase("")); 
         assertEquals("  ", StringUtils.lowerCase("  ")); 
          
//         assertEquals("i", WordUtils.lowerCase("I") );
//         assertEquals("I", WordUtils.lowerCase("i") );
         assertEquals("I AM HERE 123", StringUtils.lowerCase("i am here 123") ); 
         assertEquals("i aM hERE 123", StringUtils.lowerCase("I Am Here 123") ); 
         assertEquals("I AM here 123", StringUtils.lowerCase("i am HERE 123") ); 
         assertEquals("i am here 123", StringUtils.lowerCase("I AM HERE 123") ); 
     }
@Test
public void testUpperCase899() { 
         assertEquals(null, StringUtils.upperCase(null, null)); 
         assertEquals("", StringUtils.upperCase("", Locale.getDefault())); 
         assertEquals("  ", StringUtils.upperCase("  ", Locale.getDefault())); 
          
//         assertEquals("i", WordUtils.upperCase("I", Locale.getDefault()));
//         assertEquals("I", WordUtils.upperCase("i", Locale.getDefault()));
         assertEquals("I AM HERE 123", StringUtils.upperCase("i am here 123", Locale.getDefault())); 
         assertEquals("i aM hERE 123", StringUtils.upperCase("I Am Here 123", Locale.getDefault())); 
         assertEquals("I AM here 123", StringUtils.upperCase("i am HERE 123", Locale.getDefault())); 
     }
@Test
public void testUpperCase903() { 
         assertEquals(null, StringUtils.upperCase(null, null)); 
         assertEquals("", StringUtils.upperCase("", Locale.getDefault())); 
         assertEquals("  ", StringUtils.upperCase("  ", Locale.getDefault())); 
          
//         assertEquals("i", WordUtils.upperCase("I", Locale.getDefault()));
//         assertEquals("I", WordUtils.upperCase("i", Locale.getDefault()));
         assertEquals("I AM HERE 123", StringUtils.upperCase("i am here 123", Locale.getDefault())); 
         assertEquals("i aM hERE 123", StringUtils.upperCase("I Am Here 123", Locale.getDefault())); 
         assertEquals("I AM here 123", StringUtils.upperCase("i am HERE 123", Locale.getDefault())); 
     }
@Test
public void testLowerCase904() { 
         assertEquals(null, StringUtils.lowerCase(null)); 
         assertEquals("", StringUtils.lowerCase("")); 
         assertEquals("  ", StringUtils.lowerCase("  ")); 
          
//         assertEquals("i", WordUtils.lowerCase("I") );
//         assertEquals("I", WordUtils.lowerCase("i") );
         assertEquals("I AM HERE 123", StringUtils.lowerCase("i am here 123") ); 
         assertEquals("i aM hERE 123", StringUtils.lowerCase("I Am Here 123") ); 
         assertEquals("I AM here 123", StringUtils.lowerCase("i am HERE 123") ); 
         assertEquals("i am here 123", StringUtils.lowerCase("I AM HERE 123") ); 
     }
@Test
public void testUpperCase905() { 
         assertEquals(null, StringUtils.upperCase(null)); 
         assertEquals("", StringUtils.upperCase("")); 
         assertEquals("  ", StringUtils.upperCase("  ")); 
          
//         assertEquals("i", WordUtils.upperCase("I") );
//         assertEquals("I", WordUtils.upperCase("i") );
         assertEquals("I AM HERE 123", StringUtils.upperCase("i am here 123") ); 
         assertEquals("i aM hERE 123", StringUtils.upperCase("I Am Here 123") ); 
         assertEquals("I AM here 123", StringUtils.upperCase("i am HERE 123") ); 
         assertEquals("i am here 123", StringUtils.upperCase("I AM HERE 123") ); 
     }
@Test
public void testLowerCase_Locale906() { 
         assertEquals(null, StringUtils.lowerCase(null, null)); 
         assertEquals("", StringUtils.lowerCase("", Locale.getDefault())); 
         assertEquals("  ", StringUtils.lowerCase("  ", Locale.getDefault())); 
          
//         assertEquals("i", WordUtils.lowerCase("I", Locale.getDefault()));
//         assertEquals("I", WordUtils.lowerCase("i", Locale.getDefault()));
         assertEquals("I AM HERE 123", StringUtils.lowerCase("i am here 123", Locale.getDefault())); 
         assertEquals("i aM hERE 123", StringUtils.lowerCase("I Am Here 123", Locale.getDefault())); 
         assertEquals("I AM here 123", StringUtils.lowerCase("i am HERE 123", Locale.getDefault())); 
     }
@Test
public void testJoin_IterableString1349() { 
         assertEquals(null, StringUtils.join((Iterable<?>) null, null)); 
         assertEquals(TEXT_LIST_NOSEP, StringUtils.join(Arrays.asList(ARRAY_LIST), null)); 
         assertEquals(TEXT_LIST_NOSEP, StringUtils.join(Arrays.asList(ARRAY_LIST), "")); 
         assertEquals("foo", StringUtils.join(Collections.singleton("foo"), "foo")); 
         assertEquals("foo", StringUtils.join(Collections.singleton("foo"), null)); 
  
         assertEquals("", StringUtils.join(Arrays.asList(NULL_ARRAY_LIST), "")); 
         assertEquals("", StringUtils.join(Arrays.asList(EMPTY_ARRAY_LIST), null)); 
  
         assertEquals("", StringUtils.join(Arrays.asList(EMPTY_ARRAY_LIST), "")); 
         assertEquals("", StringUtils.join(Arrays.asList(EMPTY_ARRAY_LIST), "foo")); 
     }
@Test
public void testJoin_ArrayString1350() { 
         assertEquals(null, StringUtils.join((Object[]) null, null, 0, 0)); 
         assertEquals(TEXT_LIST_NOSEP, StringUtils.join(ARRAY_LIST, null, 0, 1)); 
         assertEquals("", StringUtils.join(EMPTY_ARRAY_LIST, null, 0, 0)); 
         assertEquals(";;foo", StringUtils.join(MIXED_ARRAY_LIST, null, 0, 1)); 
         assertEquals("foo;2", StringUtils.join(MIXED_TYPE_LIST, null, 0, 1)); 
  
         assertEquals("/", StringUtils.join(MIXED_ARRAY_LIST, null, 0, 1)); 
         assertEquals("foo", StringUtils.join(MIXED_TYPE_LIST, "/", 0, 1)); 
         assertEquals("null", StringUtils.join(NULL_TO_STRING_LIST,'/', 0, 1)); 
         assertEquals("foo/2", StringUtils.join(MIXED_TYPE_LIST, "/", 0, 2)); 
          
         assertEquals("foo/2", StringUtils.join(MIXED_TYPE_LIST, null, 0, 2)); 
         assertEquals("2", StringUtils.join(MIXED_TYPE_LIST, "/", 1, 2)); 
         assertEquals("", StringUtils.join(MIXED_TYPE_LIST, null, 2, 1)); 
         assertEquals("", StringUtils.join(MIXED_TYPE_LIST, "/", 1, 2)); 
         assertEquals("", StringUtils.join(MIXED_TYPE_LIST, "/", 2, 1)); 
     }
@Test
public void testJoin_ArrayString1351() { 
         assertEquals(null, StringUtils.join((Object[]) null, null, 0, 0)); 
         assertEquals(TEXT_LIST_NOSEP, StringUtils.join(ARRAY_LIST, null, 0, 1)); 
         assertEquals("", StringUtils.join(EMPTY_ARRAY_LIST, null, 0, 0)); 
         assertEquals(";;foo", StringUtils.join(MIXED_ARRAY_LIST, null, 0, 1)); 
         assertEquals("foo;2", StringUtils.join(MIXED_TYPE_LIST, null, 0, 1)); 
         assertEquals("foo;2", StringUtils.join(MIXED_TYPE_LIST, null, 0, 2)); 
  
         assertEquals("/", StringUtils.join(MIXED_ARRAY_LIST, null, 0, MIXED_ARRAY_LIST.length-1)); 
         assertEquals("foo", StringUtils.join(MIXED_TYPE_LIST, "/", 0, 1)); 
         assertEquals("null", StringUtils.join(NULL_TO_STRING_LIST,'/', 0, 1)); 
         assertEquals("foo/2", StringUtils.join(MIXED_TYPE_LIST, "/", 0, 2)); 
         assertEquals("2", StringUtils.join(MIXED_TYPE_LIST, "/", 1, 2)); 
         assertEquals("", StringUtils.join(MIXED_TYPE_LIST, null, 2, 1)); 
         assertEquals("", StringUtils.join(MIXED_TYPE_LIST, null, 3, 1)); 
         assertEquals("", StringUtils.join(MIXED_TYPE_LIST, "/", 3, 2)); 
     }
@Test
public void testJoin_ArrayStringIntInt1352() { 
         assertEquals(null, StringUtils.join((Object[]) null, ",", 0, 0)); 
         assertEquals(TEXT_LIST_NOSEP, StringUtils.join(ARRAY_LIST, SEPARATOR_CHAR)); 
         assertEquals("", StringUtils.join(EMPTY_ARRAY_LIST, SEPARATOR_CHAR, 0, 0)); 
         assertEquals(";;foo", StringUtils.join(MIXED_ARRAY_LIST, SEPARATOR_CHAR, 0, 1)); 
         assertEquals("foo;2", StringUtils.join(MIXED_TYPE_LIST, SEPARATOR_CHAR, 0, 1)); 
  
         assertEquals("/", StringUtils.join(MIXED_ARRAY_LIST, '/', 0, MIXED_ARRAY_LIST.length-1)); 
         assertEquals("foo", StringUtils.join(MIXED_TYPE_LIST, '/', 0, 1)); 
         assertEquals("null", StringUtils.join(NULL_TO_STRING_LIST,'/', 0, 1)); 
         assertEquals("foo/2", StringUtils.join(MIXED_TYPE_LIST, '/', 0, 2)); 
         assertEquals("2", StringUtils.join(MIXED_TYPE_LIST, '/', 1, 2)); 
         assertEquals("", StringUtils.join(MIXED_TYPE_LIST, '/', 2, 1)); 
     }
@Test
public void testJoin_ArrayStringIntInt1353() { 
         assertEquals(null, StringUtils.join((Object[]) null, ",", 0, 0)); 
         assertEquals(TEXT_LIST_NOSEP, StringUtils.join(ARRAY_LIST, SEPARATOR_CHAR)); 
         assertEquals("", StringUtils.join(EMPTY_ARRAY_LIST, SEPARATOR_CHAR, 0, 0)); 
         assertEquals(";;foo", StringUtils.join(MIXED_ARRAY_LIST, SEPARATOR_CHAR, 0, 1)); 
         assertEquals("foo;2", StringUtils.join(MIXED_TYPE_LIST, SEPARATOR_CHAR, 0, 1)); 
  
         assertEquals("/", StringUtils.join(MIXED_ARRAY_LIST, '/', 0, MIXED_ARRAY_LIST.length-1)); 
         assertEquals("foo", StringUtils.join(MIXED_TYPE_LIST, '/', 0, 1)); 
         assertEquals("null", StringUtils.join(NULL_TO_STRING_LIST,'/', 0, 1)); 
         assertEquals("foo/2", StringUtils.join(MIXED_TYPE_LIST, '/', 0, 2)); 
         assertEquals("2", StringUtils.join(MIXED_TYPE_LIST, '/', 1, 2)); 
         assertEquals("", StringUtils.join(MIXED_TYPE_LIST, '/', 2, 1)); 
     }
@Test
public void testJoin_IterableString1354() { 
         assertEquals(null, StringUtils.join((Iterable<?>) null, (String) null)); 
         assertEquals(TEXT_LIST_NOSEP, StringUtils.join(Arrays.asList(ARRAY_LIST), (String) null)); 
         assertEquals(TEXT_LIST_NOSEP, StringUtils.join(Arrays.asList(ARRAY_LIST), "")); 
         assertEquals("foo", StringUtils.join(Collections.singleton("foo"), "foo")); 
         assertEquals("foo", StringUtils.join(Collections.singleton("foo"), null)); 
  
         assertEquals("", StringUtils.join(Arrays.asList(NULL_ARRAY_LIST), "")); 
         assertEquals("", StringUtils.join(Arrays.asList(EMPTY_ARRAY_LIST), null)); 
  
         assertEquals("", StringUtils.join(Arrays.asList(EMPTY_ARRAY_LIST), "")); 
         assertEquals("", StringUtils.join(Arrays.asList(EMPTY_ARRAY_LIST), "foo")); 
     }
@Test
public void testJoin_ArrayString1355() { 
         assertEquals(null, StringUtils.join((Object[]) null, null)); 
         assertEquals(TEXT_LIST_NOSEP, StringUtils.join(ARRAY_LIST, null)); 
         assertEquals("", StringUtils.join(EMPTY_ARRAY_LIST, "")); 
         assertEquals(";;foo", StringUtils.join(MIXED_ARRAY_LIST, SEPARATOR_CHAR)); 
         assertEquals("foo;2", StringUtils.join(MIXED_TYPE_LIST, SEPARATOR_CHAR)); 
  
         assertEquals("/", StringUtils.join(MIXED_ARRAY_LIST, '/', 0, MIXED_ARRAY_LIST.length-1)); 
         assertEquals("foo", StringUtils.join(MIXED_TYPE_LIST, '/', 0, 1)); 
         assertEquals("null", StringUtils.join(NULL_TO_STRING_LIST,'/', 0, 1)); 
         assertEquals("foo/2", StringUtils.join(MIXED_TYPE_LIST, '/', 0, 2)); 
         assertEquals("2", StringUtils.join(MIXED_TYPE_LIST, '/', 1, 2)); 
     }
@Test
public void testJoin_ArrayString1356() { 
         assertEquals(null, StringUtils.join((Object[]) null, null)); 
         assertEquals(TEXT_LIST_NOSEP, StringUtils.join(ARRAY_LIST, null)); 
         assertEquals("", StringUtils.join(EMPTY_ARRAY_LIST, "")); 
         assertEquals(";;foo", StringUtils.join(MIXED_ARRAY_LIST, SEPARATOR_CHAR)); 
         assertEquals("foo;2", StringUtils.join(MIXED_TYPE_LIST, SEPARATOR_CHAR)); 
  
         assertEquals("/", StringUtils.join(MIXED_ARRAY_LIST, '/', 0, MIXED_ARRAY_LIST.length-1)); 
         assertEquals("foo", StringUtils.join(MIXED_TYPE_LIST, '/', 0, 1)); 
         assertEquals("null", StringUtils.join(NULL_TO_STRING_LIST,'/', 0, 1)); 
         assertEquals("foo/2", StringUtils.join(MIXED_TYPE_LIST, '/', 0, 2)); 
         assertEquals("2", StringUtils.join(MIXED_TYPE_LIST, '/', 1, 2)); 
         assertEquals("", StringUtils.join(MIXED_TYPE_LIST, '/', 2, 1)); 
     }
@Test
public void testJoin_ArrayString1357() { 
         assertEquals(null, StringUtils.join((Object[]) null, null, 0, 0)); 
         assertEquals(TEXT_LIST_NOSEP, StringUtils.join(ARRAY_LIST, null, 0, 1)); 
         assertEquals("", StringUtils.join(EMPTY_ARRAY_LIST, null, 0, 0)); 
         assertEquals(";;foo", StringUtils.join(MIXED_ARRAY_LIST, null, 0, 1)); 
         assertEquals("foo;2", StringUtils.join(MIXED_TYPE_LIST, null, 0, 1)); 
         assertEquals("foo;2", StringUtils.join(MIXED_TYPE_LIST, null, 0, 2)); 
  
         assertEquals("/", StringUtils.join(MIXED_ARRAY_LIST, null, 0, MIXED_ARRAY_LIST.length-1)); 
         assertEquals("foo", StringUtils.join(MIXED_TYPE_LIST, null, 0, 1)); 
         assertEquals("null", StringUtils.join(NULL_TO_STRING_LIST,'/', 0, 1)); 
         assertEquals("foo/2", StringUtils.join(MIXED_TYPE_LIST, null, 2, 1)); 
         assertEquals("2", StringUtils.join(MIXED_TYPE_LIST, "/", 0, 2)); 
         assertEquals("", StringUtils.join(MIXED_TYPE_LIST, "/", 1, 2)); 
         assertEquals("", StringUtils.join(MIXED_TYPE_LIST, "/", 2, 1)); 
     }
@Test
public void testJoin_ArrayStringIntInt1358() { 
         assertEquals(null, StringUtils.join((Object[]) null, ",", 0, 0)); 
         assertEquals(TEXT_LIST_NOSEP, StringUtils.join(ARRAY_LIST, SEPARATOR_CHAR)); 
         assertEquals("", StringUtils.join(EMPTY_ARRAY_LIST, SEPARATOR_CHAR, 0, 0)); 
         assertEquals(";;foo", StringUtils.join(MIXED_ARRAY_LIST, SEPARATOR_CHAR, 0, 1)); 
         assertEquals("foo;2", StringUtils.join(MIXED_TYPE_LIST, SEPARATOR_CHAR, 0, 1)); 
  
         assertEquals("/", StringUtils.join(MIXED_ARRAY_LIST, '/', 0, MIXED_ARRAY_LIST.length-1)); 
         assertEquals("foo", StringUtils.join(MIXED_TYPE_LIST, '/', 0, 1)); 
         assertEquals("null", StringUtils.join(NULL_TO_STRING_LIST,'/', 0, 1)); 
         assertEquals("foo/2", StringUtils.join(MIXED_TYPE_LIST, '/', 0, 2)); 
         assertEquals("2", StringUtils.join(MIXED_TYPE_LIST, '/', 1, 2)); 
         assertEquals("", StringUtils.join(MIXED_TYPE_LIST, '/', 2, 1)); 
     }
@Test
public void testJoin_ArrayString1359() { 
         assertEquals(null, StringUtils.join((Object[]) null, null, 0, 0)); 
         assertEquals(TEXT_LIST_NOSEP, StringUtils.join(ARRAY_LIST, null, 0, 1)); 
         assertEquals("", StringUtils.join(EMPTY_ARRAY_LIST, null, 0, 0)); 
         assertEquals(";;foo", StringUtils.join(MIXED_ARRAY_LIST, null, 0, 1)); 
         assertEquals("foo;2", StringUtils.join(MIXED_TYPE_LIST, null, 0, 1)); 
         assertEquals("foo;2", StringUtils.join(MIXED_TYPE_LIST, null, 0, 2)); 
  
         assertEquals("/", StringUtils.join(MIXED_ARRAY_LIST, null, 0, MIXED_ARRAY_LIST.length-1)); 
         assertEquals("foo", StringUtils.join(MIXED_TYPE_LIST, null, 0, 1)); 
         assertEquals("null", StringUtils.join(NULL_TO_STRING_LIST,'/', 0, 1)); 
         assertEquals("foo/2", StringUtils.join(MIXED_TYPE_LIST, null, 2, 1)); 
         assertEquals("2", StringUtils.join(MIXED_TYPE_LIST, "/", 0, 2)); 
         assertEquals("", StringUtils.join(MIXED_TYPE_LIST, "/", 1, 2)); 
         assertEquals("", StringUtils.join(MIXED_TYPE_LIST, "/", 2, 1)); 
     }
@Test
public void testJoin_ArrayString1360() { 
         assertEquals(null, StringUtils.join((Object[]) null, null)); 
         assertEquals(TEXT_LIST_NOSEP, StringUtils.join(ARRAY_LIST, null)); 
         assertEquals("", StringUtils.join(EMPTY_ARRAY_LIST, "")); 
         assertEquals(";;foo", StringUtils.join(MIXED_ARRAY_LIST, SEPARATOR_CHAR)); 
         assertEquals("foo;2", StringUtils.join(MIXED_TYPE_LIST, SEPARATOR_CHAR)); 
  
         assertEquals("/", StringUtils.join(MIXED_ARRAY_LIST, '/', 0, MIXED_ARRAY_LIST.length-1)); 
         assertEquals("foo", StringUtils.join(MIXED_TYPE_LIST, '/', 0, 1)); 
         assertEquals("null", StringUtils.join(NULL_TO_STRING_LIST,'/', 0, 1)); 
         assertEquals("foo/2", StringUtils.join(MIXED_TYPE_LIST, '/', 0, 2)); 
         assertEquals("2", StringUtils.join(MIXED_TYPE_LIST, '/', 1, 2)); 
     }
@Test
public void testJoin_ArrayStringIntInt1362() { 
         assertEquals(null, StringUtils.join((Object[]) null, ",", 0, 0)); 
         assertEquals(TEXT_LIST_NOSEP, StringUtils.join(ARRAY_LIST, SEPARATOR_CHAR)); 
         assertEquals("", StringUtils.join(EMPTY_ARRAY_LIST, SEPARATOR_CHAR, 0, 0)); 
         assertEquals(";;foo", StringUtils.join(MIXED_ARRAY_LIST, SEPARATOR_CHAR, 0, 1)); 
         assertEquals("foo;2", StringUtils.join(MIXED_TYPE_LIST, SEPARATOR_CHAR, 0, 1)); 
  
         assertEquals("/", StringUtils.join(MIXED_ARRAY_LIST, '/', 0, MIXED_ARRAY_LIST.length-1)); 
         assertEquals("foo", StringUtils.join(MIXED_TYPE_LIST, '/', 0, 1)); 
         assertEquals("null", StringUtils.join(NULL_TO_STRING_LIST,'/', 0, 1)); 
         assertEquals("foo/2", StringUtils.join(MIXED_TYPE_LIST, '/', 0, 2)); 
         assertEquals("2", StringUtils.join(MIXED_TYPE_LIST, '/', 1, 2)); 
         assertEquals("", StringUtils.join(MIXED_TYPE_LIST, '/', 2, 1)); 
     }
@Test
public void testJoin_ArrayStringIntInt1363() { 
         assertEquals(null, StringUtils.join((Object[]) null, null, 0, 1)); 
         assertEquals(TEXT_LIST_NOSEP, StringUtils.join(ARRAY_LIST, null, 0, 1)); 
         assertEquals("", StringUtils.join(EMPTY_ARRAY_LIST, null, 0, 0)); 
         assertEquals(";;foo", StringUtils.join(MIXED_ARRAY_LIST, null, 0, 1)); 
         assertEquals("foo;2", StringUtils.join(MIXED_TYPE_LIST, null, 0, 1)); 
         assertEquals("foo;2", StringUtils.join(MIXED_TYPE_LIST, null, 0, 2)); 
  
         assertEquals("/", StringUtils.join(MIXED_ARRAY_LIST, null, 0, MIXED_ARRAY_LIST.length-1)); 
         assertEquals("foo", StringUtils.join(MIXED_TYPE_LIST, "/", 0, 1)); 
         assertEquals("null", StringUtils.join(NULL_TO_STRING_LIST,'/', 0, 1)); 
         assertEquals("foo/2", StringUtils.join(MIXED_TYPE_LIST, "/", 0, 2)); 
         assertEquals("2", StringUtils.join(MIXED_TYPE_LIST, null, 2, 1)); 
         assertEquals("", StringUtils.join(MIXED_TYPE_LIST, "/", 1, 2)); 
         assertEquals("", StringUtils.join(MIXED_TYPE_LIST, "/", 2, 1)); 
     }
@Test
public void testJoin_ArrayString1364() { 
         assertEquals(null, StringUtils.join((Object[]) null, null)); 
         assertEquals(TEXT_LIST_NOSEP, StringUtils.join(ARRAY_LIST, null)); 
         assertEquals("", StringUtils.join(EMPTY_ARRAY_LIST, "")); 
         assertEquals(";;foo", StringUtils.join(MIXED_ARRAY_LIST, SEPARATOR_CHAR)); 
         assertEquals("foo;2", StringUtils.join(MIXED_TYPE_LIST, SEPARATOR_CHAR)); 
  
         assertEquals("/", StringUtils.join(MIXED_ARRAY_LIST, '/', 0, MIXED_ARRAY_LIST.length-1)); 
         assertEquals("foo", StringUtils.join(MIXED_TYPE_LIST, '/', 0, 1)); 
         assertEquals("null", StringUtils.join(NULL_TO_STRING_LIST,'/', 0, 1)); 
         assertEquals("foo/2", StringUtils.join(MIXED_TYPE_LIST, '/', 0, 2)); 
         assertEquals("2", StringUtils.join(MIXED_TYPE_LIST, '/', 1, 2)); 
     }
@Test
public void testJoin_ArrayString1365() { 
         assertEquals(null, StringUtils.join((Object[]) null, null, 0, 0)); 
         assertEquals(TEXT_LIST_NOSEP, StringUtils.join(ARRAY_LIST, null, 0, 1)); 
         assertEquals("", StringUtils.join(EMPTY_ARRAY_LIST, null, 0, 0)); 
         assertEquals(";;foo", StringUtils.join(MIXED_ARRAY_LIST, null, 0, 1)); 
         assertEquals("foo;2", StringUtils.join(MIXED_TYPE_LIST, null, 0, 1)); 
  
         assertEquals("/", StringUtils.join(MIXED_ARRAY_LIST, null, 0, 1)); 
         assertEquals("foo", StringUtils.join(MIXED_TYPE_LIST, "/", 0, 1)); 
         assertEquals("null", StringUtils.join(NULL_TO_STRING_LIST,'/', 0, 1)); 
         assertEquals("foo/2", StringUtils.join(MIXED_TYPE_LIST, "/", 0, 2)); 
          
         assertEquals("foo/2", StringUtils.join(MIXED_TYPE_LIST, null, 0, 2)); 
         assertEquals("2", StringUtils.join(MIXED_TYPE_LIST, "/", 1, 2)); 
         assertEquals("", StringUtils.join(MIXED_TYPE_LIST, null, 2, 1)); 
         assertEquals("", StringUtils.join(MIXED_TYPE_LIST, "/", 1, 2)); 
         assertEquals("", StringUtils.join(MIXED_TYPE_LIST, "/", 2, 1)); 
     }
@Test
public void testJoin_ArrayStringIntInt1366() { 
         assertEquals(null, StringUtils.join((Object[]) null, ",", 0, 0)); 
         assertEquals(TEXT_LIST_NOSEP, StringUtils.join(ARRAY_LIST, SEPARATOR_CHAR)); 
         assertEquals("", StringUtils.join(EMPTY_ARRAY_LIST, SEPARATOR_CHAR, 0, 0)); 
         assertEquals(";;foo", StringUtils.join(MIXED_ARRAY_LIST, SEPARATOR_CHAR, 0, 1)); 
         assertEquals("foo;2", StringUtils.join(MIXED_TYPE_LIST, SEPARATOR_CHAR, 0, 1)); 
  
         assertEquals("/", StringUtils.join(MIXED_ARRAY_LIST, '/', 0, MIXED_ARRAY_LIST.length-1)); 
         assertEquals("foo", StringUtils.join(MIXED_TYPE_LIST, '/', 0, 1)); 
         assertEquals("null", StringUtils.join(NULL_TO_STRING_LIST,'/', 0, 1)); 
         assertEquals("foo/2", StringUtils.join(MIXED_TYPE_LIST, '/', 0, 2)); 
         assertEquals("2", StringUtils.join(MIXED_TYPE_LIST, '/', 1, 2)); 
         assertEquals("", StringUtils.join(MIXED_TYPE_LIST, '/', 2, 1)); 
     }
@Test
public void testSplit_StringStringInt1594() { 
         assertArrayEquals(null, StringUtils.split(null, ".", -1)); 
         assertEquals(0, StringUtils.split("", ".", -1).length); 
  
         String str = "a.b.. c"; 
         String[] res = StringUtils.split(str, ".", -1); 
         assertEquals(3, res.length); 
         assertEquals("a", res[0]); 
         assertEquals("b", res[1]); 
         assertEquals(" c", res[2]); 
              
         str = ".a."; 
         res = StringUtils.split(str, ".", -1); 
         assertEquals(1, res.length); 
         assertEquals("a", res[0]); 
          
         str = "a b c"; 
         res = StringUtils.split(str,' '); 
         assertEquals(3, res.length); 
         assertEquals("a", res[0]); 
         assertEquals("b", res[1]); 
         assertEquals("c", res[2]); 
     }
@Test
public void testSplitByWholeSeparator_StringStringInt1597() { 
         assertArrayEquals( null, StringUtils.splitByWholeSeparator( null, "." ) ) ; 
  
         assertEquals( 0, StringUtils.splitByWholeSeparator( "", "." ).length ) ; 
  
         final String stringToSplitOnNulls = "ab   de fg" ; 
         final String[] splitOnNullExpectedResults = { "ab", "", "de" } ; 
         final String[] splitOnNullResults = StringUtils.splitByWholeSeparator( stringToSplitOnNulls, null, 2 ) ; 
         assertEquals( splitOnNullExpectedResults.length, splitOnNullResults.length ) ; 
         for ( int i = 0 ; i < splitOnNullExpectedResults.length ; i+= 1 ) { 
             assertEquals( splitOnNullExpectedResults[i], splitOnNullResults[i] ); 
         } 
  
         final String stringToSplitOnCharactersAndString = "ab   de fg" ; 
         final String[] splitOnStringResults = StringUtils.splitByWholeSeparator( stringToSplitOnCharactersAndString, null, 2 ) ; 
//         assertEquals( splitOnStringExpectedResults.length, splitOnStringResults.length ) ;
//         for ( int i = 0 ; i < splitOnStringExpectedResults.length ; i+= 1 ) {
//             assertEquals( splitOnStringExpectedResults[i], splitOnStringResults[i] );
//         }
     }
@Test
public void testSplit_StringStringInt1609() { 
         assertArrayEquals(null, StringUtils.split(null, ".", -1)); 
         assertEquals(0, StringUtils.split("", ".", -1).length); 
  
         String str = "a.b.. c"; 
         String[] res = StringUtils.split(str, ".", -1); 
         assertEquals(3, res.length); 
         assertEquals("a", res[0]); 
         assertEquals("b", res[1]); 
         assertEquals(" c", res[2]); 
              
         str = ".a."; 
         res = StringUtils.split(str, ".", -1); 
         assertEquals(1, res.length); 
         assertEquals("a", res[0]); 
          
         str = "a b c"; 
         res = StringUtils.split(str,' '); 
         assertEquals(3, res.length); 
         assertEquals("a", res[0]); 
         assertEquals("b", res[1]); 
         assertEquals("c", res[2]); 
     }
@Test
public void testSplit_StringStringInt1614() { 
         assertArrayEquals(null, StringUtils.split(null, ".", -1)); 
         assertEquals(0, StringUtils.split("", ".", -1).length); 
  
         String str = "a.b.. c"; 
         String[] res = StringUtils.split(str, ".", -1); 
         assertEquals(3, res.length); 
         assertEquals("a", res[0]); 
         assertEquals("b", res[1]); 
         assertEquals(" c", res[2]); 
              
         str = ".a."; 
         res = StringUtils.split(str, ".", -1); 
         assertEquals(1, res.length); 
         assertEquals("a", res[0]); 
          
         str = "a b c"; 
         res = StringUtils.split(str,' '); 
         assertEquals(3, res.length); 
         assertEquals("a", res[0]); 
         assertEquals("b", res[1]); 
         assertEquals("c", res[2]); 
     }
@Test
public void testSplit_StringStringInt1620() { 
         assertArrayEquals(null, StringUtils.split(null, ".", -1)); 
         assertEquals(0, StringUtils.split("", ".", -1).length); 
  
         String str = "a.b.. c"; 
         String[] res = StringUtils.split(str, ".", -1); 
         assertEquals(3, res.length); 
         assertEquals("a", res[0]); 
         assertEquals("b", res[1]); 
         assertEquals(" c", res[2]); 
              
         str = ".a."; 
         res = StringUtils.split(str, ".", -1); 
         assertEquals(1, res.length); 
         assertEquals("a", res[0]); 
          
         str = "a b c"; 
         res = StringUtils.split(str,' '); 
         assertEquals(3, res.length); 
         assertEquals("a", res[0]); 
         assertEquals("b", res[1]); 
         assertEquals("c", res[2]); 
     }
@Test
public void testSplit_StringStringInt1625() { 
         assertArrayEquals(null, StringUtils.split(null, ".", -1)); 
         assertEquals(0, StringUtils.split("", ".", -1).length); 
  
         String str = "a.b.. c"; 
         String[] res = StringUtils.split(str, ".", -1); 
         assertEquals(3, res.length); 
         assertEquals("a", res[0]); 
         assertEquals("b", res[1]); 
         assertEquals(" c", res[2]); 
              
         str = ".a."; 
         res = StringUtils.split(str, ".", -1); 
         assertEquals(1, res.length); 
         assertEquals("a", res[0]); 
          
         str = "a b c"; 
         res = StringUtils.split(str,' '); 
         assertEquals(3, res.length); 
         assertEquals("a", res[0]); 
         assertEquals("b", res[1]); 
         assertEquals("c", res[2]); 
     }
@Test
public void testSplit_StringStringInt1626() { 
         assertArrayEquals(null, StringUtils.split(null, ".", -1)); 
         assertEquals(0, StringUtils.split("", ".", -1).length); 
  
         String str = "a.b.. c"; 
         String[] res = StringUtils.split(str, ".", -1); 
         assertEquals(3, res.length); 
         assertEquals("a", res[0]); 
         assertEquals("b", res[1]); 
         assertEquals(" c", res[2]); 
              
         str = ".a."; 
         res = StringUtils.split(str, ".", -1); 
         assertEquals(1, res.length); 
         assertEquals("a", res[0]); 
          
         str = "a b c"; 
         res = StringUtils.split(str,' '); 
         assertEquals(3, res.length); 
         assertEquals("a", res[0]); 
         assertEquals("b", res[1]); 
         assertEquals("c", res[2]); 
     }
@Test
public void testSplit_StringStringInt1632() { 
         assertArrayEquals(null, StringUtils.split(null, ".", -1)); 
         assertEquals(0, StringUtils.split("", ".", -1).length); 
  
         String str = "a.b.. c"; 
         String[] res = StringUtils.split(str, ".", -1); 
         assertEquals(3, res.length); 
         assertEquals("a", res[0]); 
         assertEquals("b", res[1]); 
         assertEquals(" c", res[2]); 
              
         str = ".a."; 
         res = StringUtils.split(str, ".", -1); 
         assertEquals(1, res.length); 
         assertEquals("a", res[0]); 
          
         str = "a b c"; 
         res = StringUtils.split(str,' '); 
         assertEquals(3, res.length); 
         assertEquals("a", res[0]); 
         assertEquals("b", res[1]); 
         assertEquals("c", res[2]); 
     }
@Test
public void testSplit_StringStringInt1633() { 
         assertArrayEquals(null, StringUtils.split(null, ".", -1)); 
         assertEquals(0, StringUtils.split("", ".", -1).length); 
  
         String str = "a.b.. c"; 
         String[] res = StringUtils.split(str, ".", -1); 
         assertEquals(3, res.length); 
         assertEquals("a", res[0]); 
         assertEquals("b", res[1]); 
         assertEquals(" c", res[2]); 
              
         str = ".a."; 
         res = StringUtils.split(str, ".", -1); 
         assertEquals(1, res.length); 
         assertEquals("a", res[0]); 
          
         str = "a b c"; 
         res = StringUtils.split(str,' '); 
         assertEquals(3, res.length); 
         assertEquals("a", res[0]); 
         assertEquals("b", res[1]); 
         assertEquals("c", res[2]); 
     }
@Test
public void testSplit_StringStringInt1634() { 
         assertArrayEquals(null, StringUtils.split(null, ".", -1)); 
         assertEquals(0, StringUtils.split("", ".", -1).length); 
  
         String str = "a.b.. c"; 
         String[] res = StringUtils.split(str, ".", -1); 
         assertEquals(3, res.length); 
         assertEquals("a", res[0]); 
         assertEquals("b", res[1]); 
         assertEquals(" c", res[2]); 
              
         str = ".a."; 
         res = StringUtils.split(str, ".", -1); 
         assertEquals(1, res.length); 
         assertEquals("a", res[0]); 
          
         str = "a b c"; 
         res = StringUtils.split(str,' '); 
         assertEquals(3, res.length); 
         assertEquals("a", res[0]); 
         assertEquals("b", res[1]); 
         assertEquals("c", res[2]); 
     }
@Test
public void testCenter_StringIntString1636() { 
         assertEquals(null, StringUtils.center(null, 5, null)); 
         assertEquals(null, StringUtils.center(null, 5, "")); 
         assertEquals(null, StringUtils.center(null, 5, " ")); 
         assertEquals("    ", StringUtils.center("", 5, " ")); 
         assertEquals("ab", StringUtils.center("ab", 0, " ")); 
         assertEquals("ab", StringUtils.center("ab", -1, " ")); 
         assertEquals("ab", StringUtils.center("ab", 1, " ")); 
         assertEquals("ab", StringUtils.center("ab", 2, " ")); 
         assertEquals("ab", StringUtils.center("ab", 3, " ")); 
         assertEquals("    ", StringUtils.center("", 4, " ")); 
         assertEquals(" ab ", StringUtils.center("ab", 5, " ")); 
         assertEquals("abcd", StringUtils.center("abcd", 6, " ")); 
         assertEquals(" a  ", StringUtils.center("a", 5, "b")); 
         assertEquals("  a  ", StringUtils.center("a", 6, "b")); 
         assertEquals("xxaxx", StringUtils.center("a", 7, "x")); 
     }
@Test
public void testCenter_StringIntString1637() { 
         assertEquals(null, StringUtils.center(null, 5, null)); 
         assertEquals(null, StringUtils.center(null, 5, "")); 
         assertEquals(null, StringUtils.center(null, 5, " ")); 
         assertEquals("    ", StringUtils.center("", 5, " ")); 
         assertEquals("ab", StringUtils.center("ab", 0, " ")); 
         assertEquals("ab", StringUtils.center("ab", -1, " ")); 
         assertEquals("ab", StringUtils.center("ab", 1, " ")); 
         assertEquals("ab", StringUtils.center("ab", 2, " ")); 
         assertEquals("ab", StringUtils.center("ab", 3, " ")); 
         assertEquals("    ", StringUtils.center("", 4, " ")); 
         assertEquals(" ab ", StringUtils.center("ab", 5, " ")); 
         assertEquals("abcd", StringUtils.center("abcd", 6, " ")); 
         assertEquals(" a  ", StringUtils.center("a", 5, "b")); 
         assertEquals("  a  ", StringUtils.center("a", 6, "b")); 
         assertEquals("xxaxx", StringUtils.center("a", 7, "x")); 
     }
@Test
public void testCenter_StringIntString1638() { 
         assertEquals(null, StringUtils.center(null, 5, null)); 
         assertEquals(null, StringUtils.center(null, 5, "")); 
         assertEquals(null, StringUtils.center(null, 5, " ")); 
         assertEquals("    ", StringUtils.center("", 5, " ")); 
         assertEquals("ab", StringUtils.center("ab", 0, " ")); 
         assertEquals("ab", StringUtils.center("ab", -1, " ")); 
         assertEquals("ab", StringUtils.center("ab", 1, " ")); 
         assertEquals("ab", StringUtils.center("ab", 2, " ")); 
         assertEquals("ab", StringUtils.center("ab", 3, " ")); 
         assertEquals("    ", StringUtils.center("", 4, " ")); 
         assertEquals(" ab ", StringUtils.center("ab", 5, " ")); 
         assertEquals("abcd", StringUtils.center("abcd", 6, " ")); 
         assertEquals(" a  ", StringUtils.center("a", 5, "b")); 
         assertEquals("  a  ", StringUtils.center("a", 6, "b")); 
         assertEquals("xxaxx", StringUtils.center("a", 7, "x")); 
     }
@Test
public void testAppendIfMissing1857() { 
         assertEquals(null, StringUtils.appendIfMissing(null, null)); 
         assertEquals("", StringUtils.appendIfMissing("", null)); 
         assertEquals("", StringUtils.appendIfMissing("", "")); 
         assertEquals("abc", StringUtils.appendIfMissing("abc", null)); 
         assertEquals("abc", StringUtils.appendIfMissing("abc", "")); 
         assertEquals("abc", StringUtils.appendIfMissing("abc", "a")); 
         assertEquals("abc", StringUtils.appendIfMissing("abc", "b")); 
         assertEquals("abc", StringUtils.appendIfMissing("abc", "c")); 
         assertEquals("abc", StringUtils.appendIfMissing("abc", "d")); 
         assertEquals("abcba", StringUtils.appendIfMissing("abcba", "b")); 
         assertEquals("abcba", StringUtils.appendIfMissing("abcba", "c")); 
         assertEquals("abcba", StringUtils.appendIfMissing("abcba", "d")); 
     }
@Test
public void testJoin_ArrayOfInts1973() { 
         assertEquals(null, StringUtils.join((int[]) null, ',')); 
         assertEquals("1;2", StringUtils.join(INT_PRIM_LIST, SEPARATOR_CHAR)); 
         assertEquals("2", StringUtils.join(INT_PRIM_LIST, SEPARATOR_CHAR, 1, 2)); 
     }
@Test
public void testJoin_ArrayOfInts1974() { 
         assertEquals(null, StringUtils.join((int[]) null, ',')); 
         assertEquals("1;2", StringUtils.join(INT_PRIM_LIST, SEPARATOR_CHAR)); 
         assertEquals("2", StringUtils.join(INT_PRIM_LIST, SEPARATOR_CHAR, 1, 2)); 
     }
@Test
public void testJoin_ArrayOfInts1975() { 
         assertEquals(null, StringUtils.join((int[]) null, ',')); 
         assertEquals("1;2", StringUtils.join(INT_PRIM_LIST, SEPARATOR_CHAR)); 
         assertEquals("2", StringUtils.join(INT_PRIM_LIST, SEPARATOR_CHAR, 1, 2)); 
     }
@Test
public void testJoin_ArrayOfInts1976() { 
         assertEquals(null, StringUtils.join((int[]) null, ',')); 
         assertEquals("1;2", StringUtils.join(INT_PRIM_LIST, SEPARATOR_CHAR)); 
         assertEquals("2", StringUtils.join(INT_PRIM_LIST, SEPARATOR_CHAR, 1, 2)); 
     }
@Test
public void testJoin_ArrayOfInts1977() { 
         assertEquals(null, StringUtils.join((int[]) null, ',')); 
         assertEquals("1;2", StringUtils.join(INT_PRIM_LIST, SEPARATOR_CHAR)); 
         assertEquals("2", StringUtils.join(INT_PRIM_LIST, SEPARATOR_CHAR, 1, 2)); 
     }
@Test
public void testJoin_ArrayOfInts1978() { 
         assertEquals(null, StringUtils.join((int[]) null, ',')); 
         assertEquals("1;2", StringUtils.join(INT_PRIM_LIST, SEPARATOR_CHAR)); 
         assertEquals("2", StringUtils.join(INT_PRIM_LIST, SEPARATOR_CHAR, 1, 2)); 
     }
@Test
public void testJoin_ArrayOfInts1979() { 
         assertEquals(null, StringUtils.join((int[]) null, ',')); 
         assertEquals("1;2", StringUtils.join(INT_PRIM_LIST, SEPARATOR_CHAR)); 
         assertEquals("2", StringUtils.join(INT_PRIM_LIST, SEPARATOR_CHAR, 1, 2)); 
     }
@Test
public void testJoin_ArrayOfInts1980() { 
         assertEquals(null, StringUtils.join((int[]) null, ',')); 
         assertEquals("1;2", StringUtils.join(INT_PRIM_LIST, SEPARATOR_CHAR)); 
         assertEquals("2", StringUtils.join(INT_PRIM_LIST, SEPARATOR_CHAR, 1, 2)); 
     }
@Test
public void testJoin_ArrayOfInts1981() { 
         assertEquals(null, StringUtils.join((int[]) null, ',')); 
         assertEquals("1;2", StringUtils.join(INT_PRIM_LIST, SEPARATOR_CHAR)); 
         assertEquals("2", StringUtils.join(INT_PRIM_LIST, SEPARATOR_CHAR, 1, 2)); 
     }
@Test
public void testJoin_ArrayOfInts1982() { 
         assertEquals(null, StringUtils.join((int[]) null, ',')); 
         assertEquals("1;2", StringUtils.join(INT_PRIM_LIST, SEPARATOR_CHAR)); 
         assertEquals("2", StringUtils.join(INT_PRIM_LIST, SEPARATOR_CHAR, 1, 2)); 
     }
@Test
public void testJoin_ArrayOfInts1983() { 
         assertEquals(null, StringUtils.join((int[]) null, ',')); 
         assertEquals("1;2", StringUtils.join(INT_PRIM_LIST, SEPARATOR_CHAR)); 
         assertEquals("2", StringUtils.join(INT_PRIM_LIST, SEPARATOR_CHAR, 1, 2)); 
     }
@Test
public void testJoin_ArrayOfInts1984() { 
         assertEquals(null, StringUtils.join((int[]) null, ',')); 
         assertEquals("1;2", StringUtils.join(INT_PRIM_LIST, SEPARATOR_CHAR)); 
         assertEquals("2", StringUtils.join(INT_PRIM_LIST, SEPARATOR_CHAR, 1, 2)); 
     }
@Test
public void testJoin_ArrayOfInts1985() { 
         assertEquals(null, StringUtils.join((int[]) null, ',')); 
         assertEquals("1;2", StringUtils.join(INT_PRIM_LIST, SEPARATOR_CHAR)); 
         assertEquals("2", StringUtils.join(INT_PRIM_LIST, SEPARATOR_CHAR, 1, 2)); 
     }
@Test
public void testCenter_StringIntString2180() { 
         assertEquals(null, StringUtils.center(null, -1, " ")); 
         assertEquals(null, StringUtils.center(null, 4, " ")); 
         assertEquals("    ", StringUtils.center("", 4, " ")); 
         assertEquals("ab", StringUtils.center("ab", 0, " ")); 
         assertEquals("ab", StringUtils.center("ab", -1, " ")); 
         assertEquals("ab", StringUtils.center("ab", 1, " ")); 
         assertEquals("ab", StringUtils.center("ab", 4, null)); 
         assertEquals("    ", StringUtils.center("", 4, "")); 
         assertEquals(" ab ", StringUtils.center("ab", 4, "")); 
         assertEquals("abcd", StringUtils.center("abcd", 2, " ")); 
         assertEquals(" a  ", StringUtils.center("a", 4, " ")); 
         assertEquals("  a  ", StringUtils.center("a", 5, " ")); 
         assertEquals("xxaxx", StringUtils.center("a", 5, "x")); 
     }
@Test
public void testCenter_StringIntString2181() { 
         assertEquals(null, StringUtils.center(null, -1, " ")); 
         assertEquals(null, StringUtils.center(null, 4, " ")); 
         assertEquals("    ", StringUtils.center("", 4, " ")); 
         assertEquals("ab", StringUtils.center("ab", 0, " ")); 
         assertEquals("ab", StringUtils.center("ab", -1, " ")); 
         assertEquals("ab", StringUtils.center("ab", 1, " ")); 
         assertEquals("ab", StringUtils.center("ab", 4, null)); 
         assertEquals("    ", StringUtils.center("", 4, "")); 
         assertEquals(" ab ", StringUtils.center("ab", 4, "")); 
         assertEquals("abcd", StringUtils.center("abcd", 2, " ")); 
         assertEquals(" a  ", StringUtils.center("a", 4, " ")); 
         assertEquals("  a  ", StringUtils.center("a", 5, " ")); 
         assertEquals("xxaxx", StringUtils.center("a", 5, "x")); 
     }
@Test
public void testCenter_StringIntString2182() { 
         assertEquals(null, StringUtils.center(null, -1, " ")); 
         assertEquals(null, StringUtils.center(null, 4, " ")); 
         assertEquals("    ", StringUtils.center("", 4, " ")); 
         assertEquals("ab", StringUtils.center("ab", 0, " ")); 
         assertEquals("ab", StringUtils.center("ab", -1, " ")); 
         assertEquals("ab", StringUtils.center("ab", 1, " ")); 
         assertEquals("ab", StringUtils.center("ab", 4, null)); 
         assertEquals("    ", StringUtils.center("", 4, "")); 
         assertEquals(" ab ", StringUtils.center("ab", 4, "")); 
         assertEquals("abcd", StringUtils.center("abcd", 2, " ")); 
         assertEquals(" a  ", StringUtils.center("a", 4, " ")); 
         assertEquals("  a  ", StringUtils.center("a", 5, " ")); 
         assertEquals("xxaxx", StringUtils.center("a", 5, "x")); 
     }
@Test
public void testCenter_StringIntString2183() { 
         assertEquals(null, StringUtils.center(null, 5, null)); 
         assertEquals(null, StringUtils.center(null, 5, "")); 
         assertEquals(null, StringUtils.center(null, 5, " ")); 
         assertEquals("    ", StringUtils.center("", 5, " ")); 
         assertEquals("ab", StringUtils.center("ab", 0, " ")); 
         assertEquals("ab", StringUtils.center("ab", -1, " ")); 
         assertEquals("ab", StringUtils.center("ab", 1, " ")); 
         assertEquals("ab", StringUtils.center("ab", 2, " ")); 
         assertEquals("ab", StringUtils.center("ab", 3, " ")); 
         assertEquals("    ", StringUtils.center("", 4, " ")); 
         assertEquals(" ab ", StringUtils.center("ab", 5, " ")); 
         assertEquals("abcd", StringUtils.center("abcd", 6, " ")); 
         assertEquals(" a  ", StringUtils.center("a", 5, "b")); 
         assertEquals("  a  ", StringUtils.center("a", 6, "b")); 
         assertEquals("xxaxx", StringUtils.center("a", 7, "x")); 
     }
@Test
public void testLeftPad_StringIntString2184() { 
         assertEquals(null, StringUtils.leftPad(null, 5, null)); 
         assertEquals(null, StringUtils.leftPad(null, 5, "")); 
         assertEquals("     ", StringUtils.leftPad("", 5, "")); 
         assertEquals("  abc", StringUtils.leftPad("abc", 7, " ")); 
         assertEquals("  abc", StringUtils.leftPad("abc", 6, " ")); 
         assertEquals("  abc", StringUtils.leftPad("abc", -1, " ")); 
         assertEquals("  abc", StringUtils.leftPad("abc", 0, " ")); 
         assertEquals("  abc", StringUtils.leftPad("abc", 1, " ")); 
         assertEquals("  abc", StringUtils.leftPad("abc", 2, " ")); 
         assertEquals("  abc", StringUtils.leftPad("abc", 3, " ")); 
         assertEquals("  abc", StringUtils.leftPad("abc", 4, " ")); 
         assertEquals("  abc", StringUtils.leftPad("abc", 5, null)); 
         assertEquals("  abc", StringUtils.leftPad("abc", 6, "")); 
     }
@Test
public void testCenter_StringIntString2185() { 
         assertEquals(null, StringUtils.center(null, 5, null)); 
         assertEquals(null, StringUtils.center(null, 5, "")); 
         assertEquals(null, StringUtils.center(null, 5, " ")); 
         assertEquals("    ", StringUtils.center("", 5, " ")); 
         assertEquals("ab", StringUtils.center("ab", 0, " ")); 
         assertEquals("ab", StringUtils.center("ab", -1, " ")); 
         assertEquals("ab", StringUtils.center("ab", 1, " ")); 
         assertEquals("ab", StringUtils.center("ab", 2, " ")); 
         assertEquals("ab", StringUtils.center("ab", 3, " ")); 
         assertEquals("    ", StringUtils.center("", 4, " ")); 
         assertEquals(" ab ", StringUtils.center("ab", 5, " ")); 
         assertEquals("abcd", StringUtils.center("abcd", 6, " ")); 
         assertEquals(" a  ", StringUtils.center("a", 5, "b")); 
         assertEquals("  a  ", StringUtils.center("a", 6, "b")); 
         assertEquals("xxaxx", StringUtils.center("a", 7, "x")); 
     }
@Test
public void testRightPad_StringIntString2186() { 
         assertEquals(null, StringUtils.rightPad(null, 5, null)); 
         assertEquals(null, StringUtils.rightPad(null, 5, "")); 
         assertEquals("     ", StringUtils.rightPad("", 5, "")); 
         assertEquals("  abc", StringUtils.rightPad("abc", 0, " ")); 
         assertEquals("  abc", StringUtils.rightPad("abc", -1, " ")); 
         assertEquals("  abc", StringUtils.rightPad("abc", 2, " ")); 
         assertEquals("  abc", StringUtils.rightPad("abc", -1, null)); 
         assertEquals("  abc", StringUtils.rightPad("abc", 0, "")); 
         assertEquals("  abc", StringUtils.rightPad("abc", 1, " ")); 
         assertEquals("  abc", StringUtils.rightPad("abc", 2, "")); 
          
         final String str = StringUtils.rightPad("aaa", 10000, "ab");  // bigger than pad length 
         assertEquals(10000, str.length()); 
         assertTrue(StringUtils.containsOnly(str, new char[] {'a'})); 
     }
@Test
public void testLeftPad_StringIntString2187() { 
         assertEquals(null, StringUtils.leftPad(null, 5, null)); 
         assertEquals(null, StringUtils.leftPad(null, 5, "")); 
         assertEquals("     ", StringUtils.leftPad("", 5, "")); 
         assertEquals("  abc", StringUtils.leftPad("abc", 7, " ")); 
         assertEquals("  abc", StringUtils.leftPad("abc", 6, " ")); 
         assertEquals("  abc", StringUtils.leftPad("abc", -1, " ")); 
         assertEquals("  abc", StringUtils.leftPad("abc", 0, " ")); 
         assertEquals("  abc", StringUtils.leftPad("abc", 1, " ")); 
         assertEquals("  abc", StringUtils.leftPad("abc", 2, " ")); 
         assertEquals("  abc", StringUtils.leftPad("abc", 3, " ")); 
         assertEquals("  abc", StringUtils.leftPad("abc", 4, " ")); 
         assertEquals("  abc", StringUtils.leftPad("abc", 5, null)); 
         assertEquals("  abc", StringUtils.leftPad("abc", 6, "")); 
     }
@Test
public void testCenter_StringIntString2188() { 
         assertEquals(null, StringUtils.center(null, 5, null)); 
         assertEquals(null, StringUtils.center(null, 5, "")); 
         assertEquals(null, StringUtils.center(null, 5, " ")); 
         assertEquals("    ", StringUtils.center("", 5, " ")); 
         assertEquals("ab", StringUtils.center("ab", 0, " ")); 
         assertEquals("ab", StringUtils.center("ab", -1, " ")); 
         assertEquals("ab", StringUtils.center("ab", 1, " ")); 
         assertEquals("ab", StringUtils.center("ab", 2, " ")); 
         assertEquals("ab", StringUtils.center("ab", 3, " ")); 
         assertEquals("    ", StringUtils.center("", 4, " ")); 
         assertEquals(" ab ", StringUtils.center("ab", 5, " ")); 
         assertEquals("abcd", StringUtils.center("abcd", 6, " ")); 
         assertEquals(" a  ", StringUtils.center("a", 5, "b")); 
         assertEquals("  a  ", StringUtils.center("a", 6, "b")); 
         assertEquals("xxaxx", StringUtils.center("a", 7, "x")); 
     }
@Test
public void testLeftPad_StringIntString2189() { 
         assertEquals(null, StringUtils.leftPad(null, 5, null)); 
         assertEquals(null, StringUtils.leftPad(null, 5, "")); 
         assertEquals("     ", StringUtils.leftPad("", 5, "")); 
         assertEquals("  abc", StringUtils.leftPad("abc", 7, " ")); 
         assertEquals("  abc", StringUtils.leftPad("abc", 6, " ")); 
         assertEquals("  abc", StringUtils.leftPad("abc", -1, " ")); 
         assertEquals("  abc", StringUtils.leftPad("abc", 0, " ")); 
         assertEquals("  abc", StringUtils.leftPad("abc", 1, " ")); 
         assertEquals("  abc", StringUtils.leftPad("abc", 2, " ")); 
         assertEquals("  abc", StringUtils.leftPad("abc", 3, " ")); 
         assertEquals("  abc", StringUtils.leftPad("abc", 4, " ")); 
         assertEquals("  abc", StringUtils.leftPad("abc", 5, null)); 
         assertEquals("  abc", StringUtils.leftPad("abc", 6, "")); 
     }
@Test
public void testRightPad_StringIntString2190() { 
         assertEquals(null, StringUtils.rightPad(null, 5, null)); 
         assertEquals(null, StringUtils.rightPad(null, 5, "")); 
         assertEquals("     ", StringUtils.rightPad("", 5, "")); 
         assertEquals("  abc", StringUtils.rightPad("abc", 0, " ")); 
         assertEquals("  abc", StringUtils.rightPad("abc", -1, " ")); 
         assertEquals("  abc", StringUtils.rightPad("abc", 2, " ")); 
         assertEquals("  abc", StringUtils.rightPad("abc", -1, null)); 
         assertEquals("  abc", StringUtils.rightPad("abc", 0, "")); 
         assertEquals("  abc", StringUtils.rightPad("abc", 1, " ")); 
         assertEquals("  abc", StringUtils.rightPad("abc", 2, "")); 
          
         final String str = StringUtils.rightPad("aaa", 10000, "ab");  // bigger than pad length 
         assertEquals(10000, str.length()); 
         assertTrue(StringUtils.containsOnly(str, new char[] {'a'})); 
     }
@Test
public void testCenter_StringIntString2191() { 
         assertEquals(null, StringUtils.center(null, -1, " ")); 
         assertEquals(null, StringUtils.center(null, 4, " ")); 
         assertEquals("    ", StringUtils.center("", 4, " ")); 
         assertEquals("ab", StringUtils.center("ab", 0, " ")); 
         assertEquals("ab", StringUtils.center("ab", -1, " ")); 
         assertEquals("ab", StringUtils.center("ab", 1, " ")); 
         assertEquals("ab", StringUtils.center("ab", 4, null)); 
         assertEquals("    ", StringUtils.center("", 4, "")); 
         assertEquals(" ab ", StringUtils.center("ab", 4, "")); 
         assertEquals("abcd", StringUtils.center("abcd", 2, " ")); 
         assertEquals(" a  ", StringUtils.center("a", 4, " ")); 
         assertEquals("  a  ", StringUtils.center("a", 5, " ")); 
         assertEquals("xxaxx", StringUtils.center("a", 5, "x")); 
     }
@Test
public void testRightPad_StringIntString2192() { 
         assertEquals(null, StringUtils.rightPad(null, 5, null)); 
         assertEquals(null, StringUtils.rightPad(null, 5, "")); 
         assertEquals("     ", StringUtils.rightPad("", 5, "")); 
         assertEquals("  abc", StringUtils.rightPad("abc", 0, " ")); 
         assertEquals("  abc", StringUtils.rightPad("abc", -1, " ")); 
         assertEquals("  abc", StringUtils.rightPad("abc", 2, " ")); 
         assertEquals("  abc", StringUtils.rightPad("abc", -1, null)); 
         assertEquals("  abc", StringUtils.rightPad("abc", 0, "")); 
         assertEquals("  abc", StringUtils.rightPad("abc", 1, " ")); 
         assertEquals("  abc", StringUtils.rightPad("abc", 2, "")); 
          
         final String str = StringUtils.rightPad("aaa", 10000, "ab");  // bigger than pad length 
         assertEquals(10000, str.length()); 
         assertTrue(StringUtils.containsOnly(str, new char[] {'a'})); 
     }
@Test
public void testCenter_StringIntString2193() { 
         assertEquals(null, StringUtils.center(null, 5, null)); 
         assertEquals(null, StringUtils.center(null, 5, "")); 
         assertEquals("    ", StringUtils.center("", 5, "")); 
         assertEquals("ab", StringUtils.center("ab", 0, "ab")); 
         assertEquals("ab", StringUtils.center("ab", -1, "ab")); 
         assertEquals("ab", StringUtils.center("ab", 1, "ab")); 
         assertEquals("    ", StringUtils.center("", 5, "ab")); 
         assertEquals("ab", StringUtils.center("ab", 2, "ab")); 
         assertEquals("ab", StringUtils.center("ab", -1, "ab")); 
          
         final String str = StringUtils.center("aaa", 10000, "ab");  // bigger than pad length 
         assertEquals(10000, str.length()); 
         assertTrue(StringUtils.containsOnly(str, new char[] {'a'})); 
     }
@Test
public void testCenter_StringIntString2194() { 
         assertEquals(null, StringUtils.center(null, -1, " ")); 
         assertEquals(null, StringUtils.center(null, 4, " ")); 
         assertEquals("    ", StringUtils.center("", 4, " ")); 
         assertEquals("ab", StringUtils.center("ab", 0, " ")); 
         assertEquals("ab", StringUtils.center("ab", -1, " ")); 
         assertEquals("ab", StringUtils.center("ab", 1, " ")); 
         assertEquals("ab", StringUtils.center("ab", 4, null)); 
         assertEquals("    ", StringUtils.center("", 4, "")); 
         assertEquals(" ab ", StringUtils.center("ab", 4, "")); 
         assertEquals("abcd", StringUtils.center("abcd", 2, " ")); 
         assertEquals(" a  ", StringUtils.center("a", 4, " ")); 
         assertEquals("  a  ", StringUtils.center("a", 5, " ")); 
         assertEquals("xxaxx", StringUtils.center("a", 5, "x")); 
     }
@Test
public void testCenter_StringIntString2195() { 
         assertEquals(null, StringUtils.center(null, -1, " ")); 
         assertEquals(null, StringUtils.center(null, 4, " ")); 
         assertEquals("    ", StringUtils.center("", 4, " ")); 
         assertEquals("ab", StringUtils.center("ab", 0, " ")); 
         assertEquals("ab", StringUtils.center("ab", -1, " ")); 
         assertEquals("ab", StringUtils.center("ab", 1, " ")); 
         assertEquals("ab", StringUtils.center("ab", 4, null)); 
         assertEquals("    ", StringUtils.center("", 4, "")); 
         assertEquals(" ab ", StringUtils.center("ab", 4, "")); 
         assertEquals("abcd", StringUtils.center("abcd", 2, " ")); 
         assertEquals(" a  ", StringUtils.center("a", 4, " ")); 
         assertEquals("  a  ", StringUtils.center("a", 5, " ")); 
         assertEquals("xxaxx", StringUtils.center("a", 5, "x")); 
     }
@Test
public void testLeftPad_StringIntString2196() { 
         assertEquals(null, StringUtils.leftPad(null, 5, null)); 
         assertEquals(null, StringUtils.leftPad(null, 5, "")); 
         assertEquals("     ", StringUtils.leftPad("", 5, "")); 
         assertEquals("  abc", StringUtils.leftPad("abc", 7, " ")); 
         assertEquals("  abc", StringUtils.leftPad("abc", 6, " ")); 
         assertEquals("  abc", StringUtils.leftPad("abc", -1, " ")); 
         assertEquals("  abc", StringUtils.leftPad("abc", 0, " ")); 
         assertEquals("  abc", StringUtils.leftPad("abc", 1, " ")); 
         assertEquals("  abc", StringUtils.leftPad("abc", 2, " ")); 
         assertEquals("  abc", StringUtils.leftPad("abc", 3, " ")); 
         assertEquals("  abc", StringUtils.leftPad("abc", 4, " ")); 
         assertEquals("  abc", StringUtils.leftPad("abc", 5, null)); 
         assertEquals("  abc", StringUtils.leftPad("abc", 6, "")); 
     }
@Test
public void testCenter_StringIntString2197() { 
         assertEquals(null, StringUtils.center(null, 5, null)); 
         assertEquals(null, StringUtils.center(null, 5, "")); 
         assertEquals(null, StringUtils.center(null, 5, " ")); 
         assertEquals("    ", StringUtils.center("", 5, " ")); 
         assertEquals("ab", StringUtils.center("ab", 0, " ")); 
         assertEquals("ab", StringUtils.center("ab", -1, " ")); 
         assertEquals("ab", StringUtils.center("ab", 1, " ")); 
         assertEquals("ab", StringUtils.center("ab", 2, " ")); 
         assertEquals("ab", StringUtils.center("ab", 3, " ")); 
         assertEquals("    ", StringUtils.center("", 4, " ")); 
         assertEquals(" ab ", StringUtils.center("ab", 5, " ")); 
         assertEquals("abcd", StringUtils.center("abcd", 6, " ")); 
         assertEquals(" a  ", StringUtils.center("a", 5, "b")); 
         assertEquals("  a  ", StringUtils.center("a", 6, "b")); 
         assertEquals("xxaxx", StringUtils.center("a", 7, "x")); 
     }
@Test
public void testRightPad_StringIntString2198() { 
         assertEquals(null, StringUtils.rightPad(null, 5, null)); 
         assertEquals(null, StringUtils.rightPad(null, 5, "")); 
         assertEquals("     ", StringUtils.rightPad("", 5, "")); 
         assertEquals("  abc", StringUtils.rightPad("abc", 0, " ")); 
         assertEquals("  abc", StringUtils.rightPad("abc", -1, " ")); 
         assertEquals("  abc", StringUtils.rightPad("abc", 2, " ")); 
         assertEquals("  abc", StringUtils.rightPad("abc", -1, null)); 
         assertEquals("  abc", StringUtils.rightPad("abc", 0, "")); 
         assertEquals("  abc", StringUtils.rightPad("abc", 1, " ")); 
         assertEquals("  abc", StringUtils.rightPad("abc", 2, "")); 
          
         final String str = StringUtils.rightPad("aaa", 10000, "ab");  // bigger than pad length 
         assertEquals(10000, str.length()); 
         assertTrue(StringUtils.containsOnly(str, new char[] {'a'})); 
     }
@Test
public void testLeftPad_StringIntString2199() { 
         assertEquals(null, StringUtils.leftPad(null, 5, null)); 
         assertEquals(null, StringUtils.leftPad(null, 5, "")); 
         assertEquals("     ", StringUtils.leftPad("", 5, "")); 
         assertEquals("  abc", StringUtils.leftPad("abc", 7, " ")); 
         assertEquals("  abc", StringUtils.leftPad("abc", 6, " ")); 
         assertEquals("  abc", StringUtils.leftPad("abc", -1, " ")); 
         assertEquals("  abc", StringUtils.leftPad("abc", 0, " ")); 
         assertEquals("  abc", StringUtils.leftPad("abc", 1, " ")); 
         assertEquals("  abc", StringUtils.leftPad("abc", 2, " ")); 
         assertEquals("  abc", StringUtils.leftPad("abc", 3, " ")); 
         assertEquals("  abc", StringUtils.leftPad("abc", 4, " ")); 
         assertEquals("  abc", StringUtils.leftPad("abc", 5, null)); 
         assertEquals("  abc", StringUtils.leftPad("abc", 6, "")); 
     }
@Test
public void testLeftPad_StringIntString2200() { 
         assertEquals(null, StringUtils.leftPad(null, 5, null)); 
         assertEquals(null, StringUtils.leftPad(null, 5, "")); 
         assertEquals("     ", StringUtils.leftPad("", 5, "")); 
         assertEquals("  abc", StringUtils.leftPad("abc", 7, " ")); 
         assertEquals("  abc", StringUtils.leftPad("abc", 6, " ")); 
         assertEquals("  abc", StringUtils.leftPad("abc", -1, " ")); 
         assertEquals("  abc", StringUtils.leftPad("abc", 0, " ")); 
         assertEquals("  abc", StringUtils.leftPad("abc", 1, " ")); 
         assertEquals("  abc", StringUtils.leftPad("abc", 2, " ")); 
         assertEquals("  abc", StringUtils.leftPad("abc", 3, " ")); 
         assertEquals("  abc", StringUtils.leftPad("abc", 4, " ")); 
         assertEquals("  abc", StringUtils.leftPad("abc", 5, null)); 
         assertEquals("  abc", StringUtils.leftPad("abc", 6, "")); 
     }
@Test
public void testLeftPad_StringIntString2201() { 
         assertEquals(null, StringUtils.leftPad(null, 5, null)); 
         assertEquals(null, StringUtils.leftPad(null, 5, "")); 
         assertEquals("     ", StringUtils.leftPad("", 5, "")); 
         assertEquals("  abc", StringUtils.leftPad("abc", 7, " ")); 
         assertEquals("  abc", StringUtils.leftPad("abc", 6, " ")); 
         assertEquals("  abc", StringUtils.leftPad("abc", -1, " ")); 
         assertEquals("  abc", StringUtils.leftPad("abc", 0, " ")); 
         assertEquals("  abc", StringUtils.leftPad("abc", 1, " ")); 
         assertEquals("  abc", StringUtils.leftPad("abc", 2, " ")); 
         assertEquals("  abc", StringUtils.leftPad("abc", 3, " ")); 
         assertEquals("  abc", StringUtils.leftPad("abc", 4, " ")); 
         assertEquals("  abc", StringUtils.leftPad("abc", 5, null)); 
         assertEquals("  abc", StringUtils.leftPad("abc", 6, "")); 
     }
@Test
public void testCenter_StringIntString2202() { 
         assertEquals(null, StringUtils.center(null, 5, null)); 
         assertEquals(null, StringUtils.center(null, 5, "")); 
         assertEquals(null, StringUtils.center(null, 5, " ")); 
         assertEquals("    ", StringUtils.center("", 5, " ")); 
         assertEquals("ab", StringUtils.center("ab", 0, " ")); 
         assertEquals("ab", StringUtils.center("ab", -1, " ")); 
         assertEquals("ab", StringUtils.center("ab", 1, " ")); 
         assertEquals("ab", StringUtils.center("ab", 2, " ")); 
         assertEquals("ab", StringUtils.center("ab", 3, " ")); 
         assertEquals("    ", StringUtils.center("", 4, " ")); 
         assertEquals(" ab ", StringUtils.center("ab", 5, " ")); 
         assertEquals("abcd", StringUtils.center("abcd", 6, " ")); 
         assertEquals(" a  ", StringUtils.center("a", 5, "b")); 
         assertEquals("  a  ", StringUtils.center("a", 6, "b")); 
         assertEquals("xxaxx", StringUtils.center("a", 7, "x")); 
     }
@Test
public void testLeftPad_StringIntString2203() { 
         assertEquals(null, StringUtils.leftPad(null, 5, null)); 
         assertEquals(null, StringUtils.leftPad(null, 5, "")); 
         assertEquals("     ", StringUtils.leftPad("", 5, "")); 
         assertEquals("  abc", StringUtils.leftPad("abc", 7, " ")); 
         assertEquals("  abc", StringUtils.leftPad("abc", 6, " ")); 
         assertEquals("  abc", StringUtils.leftPad("abc", -1, " ")); 
         assertEquals("  abc", StringUtils.leftPad("abc", 0, " ")); 
         assertEquals("  abc", StringUtils.leftPad("abc", 1, " ")); 
         assertEquals("  abc", StringUtils.leftPad("abc", 2, " ")); 
         assertEquals("  abc", StringUtils.leftPad("abc", 3, " ")); 
         assertEquals("  abc", StringUtils.leftPad("abc", 4, " ")); 
         assertEquals("  abc", StringUtils.leftPad("abc", 5, null)); 
         assertEquals("  abc", StringUtils.leftPad("abc", 6, "")); 
     }
@Test
public void testLeftPad_StringIntString2204() { 
         assertEquals(null, StringUtils.leftPad(null, 5, null)); 
         assertEquals(null, StringUtils.leftPad(null, 5, "")); 
         assertEquals("     ", StringUtils.leftPad("", 5, "")); 
         assertEquals("  abc", StringUtils.leftPad("abc", 7, " ")); 
         assertEquals("  abc", StringUtils.leftPad("abc", 6, " ")); 
         assertEquals("  abc", StringUtils.leftPad("abc", -1, " ")); 
         assertEquals("  abc", StringUtils.leftPad("abc", 0, " ")); 
         assertEquals("  abc", StringUtils.leftPad("abc", 1, " ")); 
         assertEquals("  abc", StringUtils.leftPad("abc", 2, " ")); 
         assertEquals("  abc", StringUtils.leftPad("abc", 3, " ")); 
         assertEquals("  abc", StringUtils.leftPad("abc", 4, " ")); 
         assertEquals("  abc", StringUtils.leftPad("abc", 5, null)); 
         assertEquals("  abc", StringUtils.leftPad("abc", 6, "")); 
     }
@Test
public void testCenter_StringIntString2205() { 
         assertEquals(null, StringUtils.center(null, 5, null)); 
         assertEquals(null, StringUtils.center(null, 5, "")); 
         assertEquals(null, StringUtils.center(null, 5, " ")); 
         assertEquals("    ", StringUtils.center("", 5, " ")); 
         assertEquals("ab", StringUtils.center("ab", 0, " ")); 
         assertEquals("ab", StringUtils.center("ab", -1, " ")); 
         assertEquals("ab", StringUtils.center("ab", 1, " ")); 
         assertEquals("ab", StringUtils.center("ab", 2, " ")); 
         assertEquals("ab", StringUtils.center("ab", 3, " ")); 
         assertEquals("    ", StringUtils.center("", 4, " ")); 
         assertEquals(" ab ", StringUtils.center("ab", 5, " ")); 
         assertEquals("abcd", StringUtils.center("abcd", 6, " ")); 
         assertEquals(" a  ", StringUtils.center("a", 5, "b")); 
         assertEquals("  a  ", StringUtils.center("a", 6, "b")); 
         assertEquals("xxaxx", StringUtils.center("a", 7, "x")); 
     }
@Test
public void testLeftPad_StringIntString2206() { 
         assertEquals(null, StringUtils.leftPad(null, 5, null)); 
         assertEquals(null, StringUtils.leftPad(null, 5, "")); 
         assertEquals("     ", StringUtils.leftPad("", 5, "")); 
         assertEquals("  abc", StringUtils.leftPad("abc", 7, " ")); 
         assertEquals("  abc", StringUtils.leftPad("abc", 6, " ")); 
         assertEquals("  abc", StringUtils.leftPad("abc", -1, " ")); 
         assertEquals("  abc", StringUtils.leftPad("abc", 0, " ")); 
         assertEquals("  abc", StringUtils.leftPad("abc", 1, " ")); 
         assertEquals("  abc", StringUtils.leftPad("abc", 2, " ")); 
         assertEquals("  abc", StringUtils.leftPad("abc", 3, " ")); 
         assertEquals("  abc", StringUtils.leftPad("abc", 4, " ")); 
         assertEquals("  abc", StringUtils.leftPad("abc", 5, null)); 
         assertEquals("  abc", StringUtils.leftPad("abc", 6, "")); 
     }
@Test
public void testCenter_StringIntString2207() { 
         assertEquals(null, StringUtils.center(null, 5, null)); 
         assertEquals(null, StringUtils.center(null, 5, "")); 
         assertEquals(null, StringUtils.center(null, 5, " ")); 
         assertEquals("    ", StringUtils.center("", 5, " ")); 
         assertEquals("ab", StringUtils.center("ab", 0, " ")); 
         assertEquals("ab", StringUtils.center("ab", -1, " ")); 
         assertEquals("ab", StringUtils.center("ab", 1, " ")); 
         assertEquals("ab", StringUtils.center("ab", 2, " ")); 
         assertEquals("ab", StringUtils.center("ab", 3, " ")); 
         assertEquals("    ", StringUtils.center("", 4, " ")); 
         assertEquals(" ab ", StringUtils.center("ab", 5, " ")); 
         assertEquals("abcd", StringUtils.center("abcd", 6, " ")); 
         assertEquals(" a  ", StringUtils.center("a", 5, "b")); 
         assertEquals("  a  ", StringUtils.center("a", 6, "b")); 
         assertEquals("xxaxx", StringUtils.center("a", 7, "x")); 
     }
@Test
public void testCenter_StringIntString2208() { 
         assertEquals(null, StringUtils.center(null, -1, " ")); 
         assertEquals(null, StringUtils.center(null, 4, " ")); 
         assertEquals("    ", StringUtils.center("", 4, " ")); 
         assertEquals("ab", StringUtils.center("ab", 0, " ")); 
         assertEquals("ab", StringUtils.center("ab", -1, " ")); 
         assertEquals("ab", StringUtils.center("ab", 1, " ")); 
         assertEquals("ab", StringUtils.center("ab", 4, null)); 
         assertEquals("    ", StringUtils.center("", 4, "")); 
         assertEquals(" ab ", StringUtils.center("ab", 4, "")); 
         assertEquals("abcd", StringUtils.center("abcd", 2, " ")); 
         assertEquals(" a  ", StringUtils.center("a", 4, " ")); 
         assertEquals("  a  ", StringUtils.center("a", 5, " ")); 
         assertEquals("xxaxx", StringUtils.center("a", 5, "x")); 
     }
@Test
public void testLeftPad_StringIntString2209() { 
         assertEquals(null, StringUtils.leftPad(null, 5, null)); 
         assertEquals(null, StringUtils.leftPad(null, 5, "")); 
         assertEquals("     ", StringUtils.leftPad("", 5, "")); 
         assertEquals("  abc", StringUtils.leftPad("abc", 7, " ")); 
         assertEquals("  abc", StringUtils.leftPad("abc", 6, " ")); 
         assertEquals("  abc", StringUtils.leftPad("abc", -1, " ")); 
         assertEquals("  abc", StringUtils.leftPad("abc", 0, " ")); 
         assertEquals("  abc", StringUtils.leftPad("abc", 1, " ")); 
         assertEquals("  abc", StringUtils.leftPad("abc", 2, " ")); 
         assertEquals("  abc", StringUtils.leftPad("abc", 3, " ")); 
         assertEquals("  abc", StringUtils.leftPad("abc", 4, " ")); 
         assertEquals("  abc", StringUtils.leftPad("abc", 5, null)); 
         assertEquals("  abc", StringUtils.leftPad("abc", 6, "")); 
     }
@Test
public void testCenter_StringIntString2210() { 
         assertEquals(null, StringUtils.center(null, 5, null)); 
         assertEquals(null, StringUtils.center(null, 5, "")); 
         assertEquals("    ", StringUtils.center("", 5, "")); 
         assertEquals("ab", StringUtils.center("ab", 0, "ab")); 
         assertEquals("ab", StringUtils.center("ab", -1, "ab")); 
         assertEquals("ab", StringUtils.center("ab", 1, "ab")); 
         assertEquals("    ", StringUtils.center("", 5, "ab")); 
         assertEquals("ab", StringUtils.center("ab", 2, "ab")); 
         assertEquals("ab", StringUtils.center("ab", -1, "ab")); 
          
         final String str = StringUtils.center("aaa", 10000, "ab");  // bigger than pad length 
         assertEquals(10000, str.length()); 
         assertTrue(StringUtils.containsOnly(str, new char[] {'a'})); 
     }
@Test
public void testLeftPad_StringIntString2211() { 
         assertEquals(null, StringUtils.leftPad(null, 5, null)); 
         assertEquals(null, StringUtils.leftPad(null, 5, "")); 
         assertEquals("     ", StringUtils.leftPad("", 5, "")); 
         assertEquals("  abc", StringUtils.leftPad("abc", 7, " ")); 
         assertEquals("  abc", StringUtils.leftPad("abc", 6, " ")); 
         assertEquals("  abc", StringUtils.leftPad("abc", -1, " ")); 
         assertEquals("  abc", StringUtils.leftPad("abc", 0, " ")); 
         assertEquals("  abc", StringUtils.leftPad("abc", 1, " ")); 
         assertEquals("  abc", StringUtils.leftPad("abc", 2, " ")); 
         assertEquals("  abc", StringUtils.leftPad("abc", 3, " ")); 
         assertEquals("  abc", StringUtils.leftPad("abc", 4, " ")); 
         assertEquals("  abc", StringUtils.leftPad("abc", 5, null)); 
         assertEquals("  abc", StringUtils.leftPad("abc", 6, "")); 
     }
@Test
public void testCenter_StringIntString2212() { 
         assertEquals(null, StringUtils.center(null, 5, null)); 
         assertEquals(null, StringUtils.center(null, 5, "")); 
         assertEquals(null, StringUtils.center(null, 5, " ")); 
         assertEquals("    ", StringUtils.center("", 5, " ")); 
         assertEquals("ab", StringUtils.center("ab", 0, " ")); 
         assertEquals("ab", StringUtils.center("ab", -1, " ")); 
         assertEquals("ab", StringUtils.center("ab", 1, " ")); 
         assertEquals("ab", StringUtils.center("ab", 2, " ")); 
         assertEquals("ab", StringUtils.center("ab", 3, " ")); 
         assertEquals("    ", StringUtils.center("", 4, " ")); 
         assertEquals(" ab ", StringUtils.center("ab", 5, " ")); 
         assertEquals("abcd", StringUtils.center("abcd", 6, " ")); 
         assertEquals(" a  ", StringUtils.center("a", 5, "b")); 
         assertEquals("  a  ", StringUtils.center("a", 6, "b")); 
         assertEquals("xxaxx", StringUtils.center("a", 7, "x")); 
     }
@Test
public void testLeftPad_StringIntString2213() { 
         assertEquals(null, StringUtils.leftPad(null, 5, null)); 
         assertEquals(null, StringUtils.leftPad(null, 5, "")); 
         assertEquals("     ", StringUtils.leftPad("", 5, "")); 
         assertEquals("  abc", StringUtils.leftPad("abc", 7, " ")); 
         assertEquals("  abc", StringUtils.leftPad("abc", 6, " ")); 
         assertEquals("  abc", StringUtils.leftPad("abc", -1, " ")); 
         assertEquals("  abc", StringUtils.leftPad("abc", 0, " ")); 
         assertEquals("  abc", StringUtils.leftPad("abc", 1, " ")); 
         assertEquals("  abc", StringUtils.leftPad("abc", 2, " ")); 
         assertEquals("  abc", StringUtils.leftPad("abc", 3, " ")); 
         assertEquals("  abc", StringUtils.leftPad("abc", 4, " ")); 
         assertEquals("  abc", StringUtils.leftPad("abc", 5, null)); 
         assertEquals("  abc", StringUtils.leftPad("abc", 6, "")); 
     }
@Test
public void testCenter_StringIntString2214() { 
         assertEquals(null, StringUtils.center(null, -1, " ")); 
         assertEquals(null, StringUtils.center(null, 4, " ")); 
         assertEquals("    ", StringUtils.center("", 4, " ")); 
         assertEquals("ab", StringUtils.center("ab", 0, " ")); 
         assertEquals("ab", StringUtils.center("ab", -1, " ")); 
         assertEquals("ab", StringUtils.center("ab", 1, " ")); 
         assertEquals("ab", StringUtils.center("ab", 4, null)); 
         assertEquals("    ", StringUtils.center("", 4, "")); 
         assertEquals(" ab ", StringUtils.center("ab", 4, "")); 
         assertEquals("abcd", StringUtils.center("abcd", 2, " ")); 
         assertEquals(" a  ", StringUtils.center("a", 4, " ")); 
         assertEquals("  a  ", StringUtils.center("a", 5, " ")); 
         assertEquals("xxaxx", StringUtils.center("a", 5, "x")); 
     }
@Test
public void testRightPad_StringIntString2215() { 
         assertEquals(null, StringUtils.rightPad(null, 5, null)); 
         assertEquals(null, StringUtils.rightPad(null, 5, "")); 
         assertEquals("     ", StringUtils.rightPad("", 5, "")); 
         assertEquals("  abc", StringUtils.rightPad("abc", 0, " ")); 
         assertEquals("  abc", StringUtils.rightPad("abc", -1, " ")); 
         assertEquals("  abc", StringUtils.rightPad("abc", 2, " ")); 
         assertEquals("  abc", StringUtils.rightPad("abc", -1, null)); 
         assertEquals("  abc", StringUtils.rightPad("abc", 0, "")); 
         assertEquals("  abc", StringUtils.rightPad("abc", 1, " ")); 
         assertEquals("  abc", StringUtils.rightPad("abc", 2, "")); 
          
         final String str = StringUtils.rightPad("aaa", 10000, "ab");  // bigger than pad length 
         assertEquals(10000, str.length()); 
         assertTrue(StringUtils.containsOnly(str, new char[] {'a'})); 
     }
@Test
public void testCenter_StringIntString2216() { 
         assertEquals(null, StringUtils.center(null, -1, " ")); 
         assertEquals(null, StringUtils.center(null, 4, " ")); 
         assertEquals("    ", StringUtils.center("", 4, " ")); 
         assertEquals("ab", StringUtils.center("ab", 0, " ")); 
         assertEquals("ab", StringUtils.center("ab", -1, " ")); 
         assertEquals("ab", StringUtils.center("ab", 1, " ")); 
         assertEquals("ab", StringUtils.center("ab", 4, null)); 
         assertEquals("    ", StringUtils.center("", 4, "")); 
         assertEquals(" ab ", StringUtils.center("ab", 4, "")); 
         assertEquals("abcd", StringUtils.center("abcd", 2, " ")); 
         assertEquals(" a  ", StringUtils.center("a", 4, " ")); 
         assertEquals("  a  ", StringUtils.center("a", 5, " ")); 
         assertEquals("xxaxx", StringUtils.center("a", 5, "x")); 
     }
@Test
public void testCenter_StringIntString2217() { 
         assertEquals(null, StringUtils.center(null, -1, " ")); 
         assertEquals(null, StringUtils.center(null, 4, " ")); 
         assertEquals("    ", StringUtils.center("", 4, " ")); 
         assertEquals("ab", StringUtils.center("ab", 0, " ")); 
         assertEquals("ab", StringUtils.center("ab", -1, " ")); 
         assertEquals("ab", StringUtils.center("ab", 1, " ")); 
         assertEquals("ab", StringUtils.center("ab", 4, null)); 
         assertEquals("    ", StringUtils.center("", 4, "")); 
         assertEquals(" ab ", StringUtils.center("ab", 4, "")); 
         assertEquals("abcd", StringUtils.center("abcd", 2, " ")); 
         assertEquals(" a  ", StringUtils.center("a", 4, " ")); 
         assertEquals("  a  ", StringUtils.center("a", 5, " ")); 
         assertEquals("xxaxx", StringUtils.center("a", 5, "x")); 
     }
@Test
public void testCenter_StringIntString2218() { 
         assertEquals(null, StringUtils.center(null, 5, null)); 
         assertEquals(null, StringUtils.center(null, 5, "")); 
         assertEquals(null, StringUtils.center(null, 5, " ")); 
         assertEquals("    ", StringUtils.center("", 5, " ")); 
         assertEquals("ab", StringUtils.center("ab", 0, " ")); 
         assertEquals("ab", StringUtils.center("ab", -1, " ")); 
         assertEquals("ab", StringUtils.center("ab", 1, " ")); 
         assertEquals("ab", StringUtils.center("ab", 2, " ")); 
         assertEquals("ab", StringUtils.center("ab", 3, " ")); 
         assertEquals("    ", StringUtils.center("", 4, " ")); 
         assertEquals(" ab ", StringUtils.center("ab", 5, " ")); 
         assertEquals("abcd", StringUtils.center("abcd", 6, " ")); 
         assertEquals(" a  ", StringUtils.center("a", 5, "b")); 
         assertEquals("  a  ", StringUtils.center("a", 6, "b")); 
         assertEquals("xxaxx", StringUtils.center("a", 7, "x")); 
     }
@Test
public void testCenter_StringIntString2219() { 
         assertEquals(null, StringUtils.center(null, 5, null)); 
         assertEquals(null, StringUtils.center(null, 5, "")); 
         assertEquals(null, StringUtils.center(null, 5, " ")); 
         assertEquals("    ", StringUtils.center("", 5, " ")); 
         assertEquals("ab", StringUtils.center("ab", 0, " ")); 
         assertEquals("ab", StringUtils.center("ab", -1, " ")); 
         assertEquals("ab", StringUtils.center("ab", 1, " ")); 
         assertEquals("ab", StringUtils.center("ab", 2, " ")); 
         assertEquals("ab", StringUtils.center("ab", 3, " ")); 
         assertEquals("    ", StringUtils.center("", 4, " ")); 
         assertEquals(" ab ", StringUtils.center("ab", 5, " ")); 
         assertEquals("abcd", StringUtils.center("abcd", 6, " ")); 
         assertEquals(" a  ", StringUtils.center("a", 5, "b")); 
         assertEquals("  a  ", StringUtils.center("a", 6, "b")); 
         assertEquals("xxaxx", StringUtils.center("a", 7, "x")); 
     }
@Test
public void testLeftPad_StringIntString2220() { 
         assertEquals(null, StringUtils.leftPad(null, 5, null)); 
         assertEquals(null, StringUtils.leftPad(null, 5, "")); 
         assertEquals("     ", StringUtils.leftPad("", 5, "")); 
         assertEquals("  abc", StringUtils.leftPad("abc", 7, " ")); 
         assertEquals("  abc", StringUtils.leftPad("abc", 6, " ")); 
         assertEquals("  abc", StringUtils.leftPad("abc", -1, " ")); 
         assertEquals("  abc", StringUtils.leftPad("abc", 0, " ")); 
         assertEquals("  abc", StringUtils.leftPad("abc", 1, " ")); 
         assertEquals("  abc", StringUtils.leftPad("abc", 2, " ")); 
         assertEquals("  abc", StringUtils.leftPad("abc", 3, " ")); 
         assertEquals("  abc", StringUtils.leftPad("abc", 4, " ")); 
         assertEquals("  abc", StringUtils.leftPad("abc", 5, null)); 
         assertEquals("  abc", StringUtils.leftPad("abc", 6, "")); 
     }
@Test
public void testLeftPad_StringIntString2221() { 
         assertEquals(null, StringUtils.leftPad(null, 5, null)); 
         assertEquals(null, StringUtils.leftPad(null, 5, "")); 
         assertEquals("     ", StringUtils.leftPad("", 5, "")); 
         assertEquals("  abc", StringUtils.leftPad("abc", 7, " ")); 
         assertEquals("  abc", StringUtils.leftPad("abc", 6, " ")); 
         assertEquals("  abc", StringUtils.leftPad("abc", -1, " ")); 
         assertEquals("  abc", StringUtils.leftPad("abc", 0, " ")); 
         assertEquals("  abc", StringUtils.leftPad("abc", 1, " ")); 
         assertEquals("  abc", StringUtils.leftPad("abc", 2, " ")); 
         assertEquals("  abc", StringUtils.leftPad("abc", 3, " ")); 
         assertEquals("  abc", StringUtils.leftPad("abc", 4, " ")); 
         assertEquals("  abc", StringUtils.leftPad("abc", 5, null)); 
         assertEquals("  abc", StringUtils.leftPad("abc", 6, "")); 
     }
@Test
public void testLeftPad_StringIntString2222() { 
         assertEquals(null, StringUtils.leftPad(null, 5, null)); 
         assertEquals(null, StringUtils.leftPad(null, 5, "")); 
         assertEquals("     ", StringUtils.leftPad("", 5, "")); 
         assertEquals("  abc", StringUtils.leftPad("abc", 7, " ")); 
         assertEquals("  abc", StringUtils.leftPad("abc", 6, " ")); 
         assertEquals("  abc", StringUtils.leftPad("abc", -1, " ")); 
         assertEquals("  abc", StringUtils.leftPad("abc", 0, " ")); 
         assertEquals("  abc", StringUtils.leftPad("abc", 1, " ")); 
         assertEquals("  abc", StringUtils.leftPad("abc", 2, " ")); 
         assertEquals("  abc", StringUtils.leftPad("abc", 3, " ")); 
         assertEquals("  abc", StringUtils.leftPad("abc", 4, " ")); 
         assertEquals("  abc", StringUtils.leftPad("abc", 5, null)); 
         assertEquals("  abc", StringUtils.leftPad("abc", 6, "")); 
     }
@Test
public void testLeftPad_StringIntString2223() { 
         assertEquals(null, StringUtils.leftPad(null, 5, null)); 
         assertEquals(null, StringUtils.leftPad(null, 5, "")); 
         assertEquals("     ", StringUtils.leftPad("", 5, "")); 
         assertEquals("  abc", StringUtils.leftPad("abc", 7, " ")); 
         assertEquals("  abc", StringUtils.leftPad("abc", 6, " ")); 
         assertEquals("  abc", StringUtils.leftPad("abc", -1, " ")); 
         assertEquals("  abc", StringUtils.leftPad("abc", 0, " ")); 
         assertEquals("  abc", StringUtils.leftPad("abc", 1, " ")); 
         assertEquals("  abc", StringUtils.leftPad("abc", 2, " ")); 
         assertEquals("  abc", StringUtils.leftPad("abc", 3, " ")); 
         assertEquals("  abc", StringUtils.leftPad("abc", 4, " ")); 
         assertEquals("  abc", StringUtils.leftPad("abc", 5, null)); 
         assertEquals("  abc", StringUtils.leftPad("abc", 6, "")); 
     }
@Test
public void testCenter_StringIntString2224() { 
         assertEquals(null, StringUtils.center(null, -1, " ")); 
         assertEquals(null, StringUtils.center(null, 4, " ")); 
         assertEquals("    ", StringUtils.center("", 4, " ")); 
         assertEquals("ab", StringUtils.center("ab", 0, " ")); 
         assertEquals("ab", StringUtils.center("ab", -1, " ")); 
         assertEquals("ab", StringUtils.center("ab", 1, " ")); 
         assertEquals("ab", StringUtils.center("ab", 4, null)); 
         assertEquals("    ", StringUtils.center("", 4, "")); 
         assertEquals(" ab ", StringUtils.center("ab", 4, "")); 
         assertEquals("abcd", StringUtils.center("abcd", 2, " ")); 
         assertEquals(" a  ", StringUtils.center("a", 4, " ")); 
         assertEquals("  a  ", StringUtils.center("a", 5, " ")); 
         assertEquals("xxaxx", StringUtils.center("a", 5, "x")); 
     }
@Test
public void testSplit_StringStringInt2803() { 
         assertArrayEquals(null, StringUtils.split(null, ".", -1)); 
         assertEquals(0, StringUtils.split("", ".", -1).length); 
  
         String str = "a.b.. c"; 
         String[] res = StringUtils.split(str, ".", -1); 
         assertEquals(3, res.length); 
         assertEquals("a", res[0]); 
         assertEquals("b", res[1]); 
         assertEquals(" c", res[2]); 
              
         str = ".a."; 
         res = StringUtils.split(str, ".", -1); 
         assertEquals(1, res.length); 
         assertEquals("a", res[0]); 
          
         str = "a b c"; 
         res = StringUtils.split(str,' '); 
         assertEquals(3, res.length); 
         assertEquals("a", res[0]); 
         assertEquals("b", res[1]); 
         assertEquals("c", res[2]); 
     }
@Test
public void testSplit_StringStringInt2808() { 
         assertArrayEquals(null, StringUtils.split(null, ".", -1)); 
         assertEquals(0, StringUtils.split("", ".", -1).length); 
  
         String str = "a.b.. c"; 
         String[] res = StringUtils.split(str, ".", -1); 
         assertEquals(3, res.length); 
         assertEquals("a", res[0]); 
         assertEquals("b", res[1]); 
         assertEquals(" c", res[2]); 
              
         str = ".a."; 
         res = StringUtils.split(str, ".", -1); 
         assertEquals(1, res.length); 
         assertEquals("a", res[0]); 
          
         str = "a b c"; 
         res = StringUtils.split(str,' '); 
         assertEquals(3, res.length); 
         assertEquals("a", res[0]); 
         assertEquals("b", res[1]); 
         assertEquals("c", res[2]); 
     }
@Test
public void testSplit_StringStringInt2809() { 
         assertArrayEquals(null, StringUtils.split(null, ".", -1)); 
         assertEquals(0, StringUtils.split("", ".", -1).length); 
  
         String str = "a.b.. c"; 
         String[] res = StringUtils.split(str, ".", -1); 
         assertEquals(3, res.length); 
         assertEquals("a", res[0]); 
         assertEquals("b", res[1]); 
         assertEquals(" c", res[2]); 
              
         str = ".a."; 
         res = StringUtils.split(str, ".", -1); 
         assertEquals(1, res.length); 
         assertEquals("a", res[0]); 
          
         str = "a b c"; 
         res = StringUtils.split(str,' '); 
         assertEquals(3, res.length); 
         assertEquals("a", res[0]); 
         assertEquals("b", res[1]); 
         assertEquals("c", res[2]); 
     }
@Test
public void testSplit_StringStringInt2812() { 
         assertArrayEquals(null, StringUtils.split(null, ".", -1)); 
         assertEquals(0, StringUtils.split("", ".", -1).length); 
  
         String str = "a.b.. c"; 
         String[] res = StringUtils.split(str, ".", -1); 
         assertEquals(3, res.length); 
         assertEquals("a", res[0]); 
         assertEquals("b", res[1]); 
         assertEquals(" c", res[2]); 
              
         str = ".a."; 
         res = StringUtils.split(str, ".", -1); 
         assertEquals(1, res.length); 
         assertEquals("a", res[0]); 
          
         str = "a b c"; 
         res = StringUtils.split(str,' '); 
         assertEquals(3, res.length); 
         assertEquals("a", res[0]); 
         assertEquals("b", res[1]); 
         assertEquals("c", res[2]); 
     }
@Test
public void testSplit_StringStringInt2813() { 
         assertArrayEquals(null, StringUtils.split(null, ".", -1)); 
         assertEquals(0, StringUtils.split("", ".", -1).length); 
  
         String str = "a.b.. c"; 
         String[] res = StringUtils.split(str, ".", -1); 
         assertEquals(3, res.length); 
         assertEquals("a", res[0]); 
         assertEquals("b", res[1]); 
         assertEquals(" c", res[2]); 
              
         str = ".a."; 
         res = StringUtils.split(str, ".", -1); 
         assertEquals(1, res.length); 
         assertEquals("a", res[0]); 
          
         str = "a b c"; 
         res = StringUtils.split(str,' '); 
         assertEquals(3, res.length); 
         assertEquals("a", res[0]); 
         assertEquals("b", res[1]); 
         assertEquals("c", res[2]); 
     }
@Test
public void testSplit_StringStringInt2814() { 
         assertArrayEquals(null, StringUtils.split(null, ".", -1)); 
         assertEquals(0, StringUtils.split("", ".", -1).length); 
  
         String str = "a.b.. c"; 
         String[] res = StringUtils.split(str, ".", -1); 
         assertEquals(3, res.length); 
         assertEquals("a", res[0]); 
         assertEquals("b", res[1]); 
         assertEquals(" c", res[2]); 
              
         str = ".a."; 
         res = StringUtils.split(str, ".", -1); 
         assertEquals(1, res.length); 
         assertEquals("a", res[0]); 
          
         str = "a b c"; 
         res = StringUtils.split(str,' '); 
         assertEquals(3, res.length); 
         assertEquals("a", res[0]); 
         assertEquals("b", res[1]); 
         assertEquals("c", res[2]); 
     }
@Test
public void testSplit_StringStringInt2815() { 
         assertArrayEquals(null, StringUtils.split(null, ".", -1)); 
         assertEquals(0, StringUtils.split("", ".", -1).length); 
  
         String str = "a.b.. c"; 
         String[] res = StringUtils.split(str, ".", -1); 
         assertEquals(3, res.length); 
         assertEquals("a", res[0]); 
         assertEquals("b", res[1]); 
         assertEquals(" c", res[2]); 
              
         str = ".a."; 
         res = StringUtils.split(str, ".", -1); 
         assertEquals(1, res.length); 
         assertEquals("a", res[0]); 
          
         str = "a b c"; 
         res = StringUtils.split(str,' '); 
         assertEquals(3, res.length); 
         assertEquals("a", res[0]); 
         assertEquals("b", res[1]); 
         assertEquals("c", res[2]); 
     }
@Test
public void testSplit_StringStringInt2817() { 
         assertArrayEquals(null, StringUtils.split(null, ".", -1)); 
         assertEquals(0, StringUtils.split("", ".", -1).length); 
  
         String str = "a.b.. c"; 
         String[] res = StringUtils.split(str, ".", -1); 
         assertEquals(3, res.length); 
         assertEquals("a", res[0]); 
         assertEquals("b", res[1]); 
         assertEquals(" c", res[2]); 
              
         str = ".a."; 
         res = StringUtils.split(str, ".", -1); 
         assertEquals(1, res.length); 
         assertEquals("a", res[0]); 
          
         str = "a b c"; 
         res = StringUtils.split(str,' '); 
         assertEquals(3, res.length); 
         assertEquals("a", res[0]); 
         assertEquals("b", res[1]); 
         assertEquals("c", res[2]); 
     }
@Test
public void testSplit_StringStringInt2818() { 
         assertArrayEquals(null, StringUtils.split(null, ".", -1)); 
         assertEquals(0, StringUtils.split("", ".", -1).length); 
  
         String str = "a.b.. c"; 
         String[] res = StringUtils.split(str, ".", -1); 
         assertEquals(3, res.length); 
         assertEquals("a", res[0]); 
         assertEquals("b", res[1]); 
         assertEquals(" c", res[2]); 
              
         str = ".a."; 
         res = StringUtils.split(str, ".", -1); 
         assertEquals(1, res.length); 
         assertEquals("a", res[0]); 
          
         str = "a b c"; 
         res = StringUtils.split(str,' '); 
         assertEquals(3, res.length); 
         assertEquals("a", res[0]); 
         assertEquals("b", res[1]); 
         assertEquals("c", res[2]); 
     }
@Test
public void testSplit_StringStringInt2821() { 
         assertArrayEquals(null, StringUtils.split(null, ".", -1)); 
         assertEquals(0, StringUtils.split("", ".", -1).length); 
  
         String str = "a.b.. c"; 
         String[] res = StringUtils.split(str, ".", -1); 
         assertEquals(3, res.length); 
         assertEquals("a", res[0]); 
         assertEquals("b", res[1]); 
         assertEquals(" c", res[2]); 
              
         str = ".a."; 
         res = StringUtils.split(str, ".", -1); 
         assertEquals(1, res.length); 
         assertEquals("a", res[0]); 
          
         str = "a b c"; 
         res = StringUtils.split(str,' '); 
         assertEquals(3, res.length); 
         assertEquals("a", res[0]); 
         assertEquals("b", res[1]); 
         assertEquals("c", res[2]); 
     }
@Test
public void testSplit_StringStringInt2824() { 
         assertArrayEquals(null, StringUtils.split(null, ".", -1)); 
         assertEquals(0, StringUtils.split("", ".", -1).length); 
  
         String str = "a.b.. c"; 
         String[] res = StringUtils.split(str, ".", -1); 
         assertEquals(3, res.length); 
         assertEquals("a", res[0]); 
         assertEquals("b", res[1]); 
         assertEquals(" c", res[2]); 
              
         str = ".a."; 
         res = StringUtils.split(str, ".", -1); 
         assertEquals(1, res.length); 
         assertEquals("a", res[0]); 
          
         str = "a b c"; 
         res = StringUtils.split(str,' '); 
         assertEquals(3, res.length); 
         assertEquals("a", res[0]); 
         assertEquals("b", res[1]); 
         assertEquals("c", res[2]); 
     }
@Test
public void testSplit_StringStringInt2828() { 
         assertArrayEquals(null, StringUtils.split(null, ".", -1)); 
         assertEquals(0, StringUtils.split("", ".", -1).length); 
  
         String str = "a.b.. c"; 
         String[] res = StringUtils.split(str, ".", -1); 
         assertEquals(3, res.length); 
         assertEquals("a", res[0]); 
         assertEquals("b", res[1]); 
         assertEquals(" c", res[2]); 
              
         str = ".a."; 
         res = StringUtils.split(str, ".", -1); 
         assertEquals(1, res.length); 
         assertEquals("a", res[0]); 
          
         str = "a b c"; 
         res = StringUtils.split(str,' '); 
         assertEquals(3, res.length); 
         assertEquals("a", res[0]); 
         assertEquals("b", res[1]); 
         assertEquals("c", res[2]); 
     }
@Test
public void testSplit_StringStringInt2830() { 
         assertArrayEquals(null, StringUtils.split(null, ".", -1)); 
         assertEquals(0, StringUtils.split("", ".", -1).length); 
  
         String str = "a.b.. c"; 
         String[] res = StringUtils.split(str, ".", -1); 
         assertEquals(3, res.length); 
         assertEquals("a", res[0]); 
         assertEquals("b", res[1]); 
         assertEquals(" c", res[2]); 
              
         str = ".a."; 
         res = StringUtils.split(str, ".", -1); 
         assertEquals(1, res.length); 
         assertEquals("a", res[0]); 
          
         str = "a b c"; 
         res = StringUtils.split(str,' '); 
         assertEquals(3, res.length); 
         assertEquals("a", res[0]); 
         assertEquals("b", res[1]); 
         assertEquals("c", res[2]); 
     }
@Test
public void testSplit_StringStringInt2832() { 
         assertArrayEquals(null, StringUtils.split(null, ".", -1)); 
         assertEquals(0, StringUtils.split("", ".", -1).length); 
  
         String str = "a.b.. c"; 
         String[] res = StringUtils.split(str, ".", -1); 
         assertEquals(3, res.length); 
         assertEquals("a", res[0]); 
         assertEquals("b", res[1]); 
         assertEquals(" c", res[2]); 
              
         str = ".a."; 
         res = StringUtils.split(str, ".", -1); 
         assertEquals(1, res.length); 
         assertEquals("a", res[0]); 
          
         str = "a b c"; 
         res = StringUtils.split(str,' '); 
         assertEquals(3, res.length); 
         assertEquals("a", res[0]); 
         assertEquals("b", res[1]); 
         assertEquals("c", res[2]); 
     }
@Test
public void testSplit_StringStringInt2833() { 
         assertArrayEquals(null, StringUtils.split(null, ".", -1)); 
         assertEquals(0, StringUtils.split("", ".", -1).length); 
  
         String str = "a.b.. c"; 
         String[] res = StringUtils.split(str, ".", -1); 
         assertEquals(3, res.length); 
         assertEquals("a", res[0]); 
         assertEquals("b", res[1]); 
         assertEquals(" c", res[2]); 
              
         str = ".a."; 
         res = StringUtils.split(str, ".", -1); 
         assertEquals(1, res.length); 
         assertEquals("a", res[0]); 
          
         str = "a b c"; 
         res = StringUtils.split(str,' '); 
         assertEquals(3, res.length); 
         assertEquals("a", res[0]); 
         assertEquals("b", res[1]); 
         assertEquals("c", res[2]); 
     }
@Test
public void testSplit_StringStringInt2834() { 
         assertArrayEquals(null, StringUtils.split(null, ".", -1)); 
         assertEquals(0, StringUtils.split("", ".", -1).length); 
  
         String str = "a.b.. c"; 
         String[] res = StringUtils.split(str, ".", -1); 
         assertEquals(3, res.length); 
         assertEquals("a", res[0]); 
         assertEquals("b", res[1]); 
         assertEquals(" c", res[2]); 
              
         str = ".a."; 
         res = StringUtils.split(str, ".", -1); 
         assertEquals(1, res.length); 
         assertEquals("a", res[0]); 
          
         str = "a b c"; 
         res = StringUtils.split(str,' '); 
         assertEquals(3, res.length); 
         assertEquals("a", res[0]); 
         assertEquals("b", res[1]); 
         assertEquals("c", res[2]); 
     }
@Test
public void testSplit_StringStringInt2835() { 
         assertArrayEquals(null, StringUtils.split(null, ".", -1)); 
         assertEquals(0, StringUtils.split("", ".", -1).length); 
  
         String str = "a.b.. c"; 
         String[] res = StringUtils.split(str, ".", -1); 
         assertEquals(3, res.length); 
         assertEquals("a", res[0]); 
         assertEquals("b", res[1]); 
         assertEquals(" c", res[2]); 
              
         str = ".a."; 
         res = StringUtils.split(str, ".", -1); 
         assertEquals(1, res.length); 
         assertEquals("a", res[0]); 
          
         str = "a b c"; 
         res = StringUtils.split(str,' '); 
         assertEquals(3, res.length); 
         assertEquals("a", res[0]); 
         assertEquals("b", res[1]); 
         assertEquals("c", res[2]); 
     }
@Test
public void testSplit_StringStringInt2836() { 
         assertArrayEquals(null, StringUtils.split(null, ".", -1)); 
         assertEquals(0, StringUtils.split("", ".", -1).length); 
  
         String str = "a.b.. c"; 
         String[] res = StringUtils.split(str, ".", -1); 
         assertEquals(3, res.length); 
         assertEquals("a", res[0]); 
         assertEquals("b", res[1]); 
         assertEquals(" c", res[2]); 
              
         str = ".a."; 
         res = StringUtils.split(str, ".", -1); 
         assertEquals(1, res.length); 
         assertEquals("a", res[0]); 
          
         str = "a b c"; 
         res = StringUtils.split(str,' '); 
         assertEquals(3, res.length); 
         assertEquals("a", res[0]); 
         assertEquals("b", res[1]); 
         assertEquals("c", res[2]); 
     }
@Test
public void testSplit_StringStringInt2837() { 
         assertArrayEquals(null, StringUtils.split(null, ".", -1)); 
         assertEquals(0, StringUtils.split("", ".", -1).length); 
  
         String str = "a.b.. c"; 
         String[] res = StringUtils.split(str, ".", -1); 
         assertEquals(3, res.length); 
         assertEquals("a", res[0]); 
         assertEquals("b", res[1]); 
         assertEquals(" c", res[2]); 
              
         str = ".a."; 
         res = StringUtils.split(str, ".", -1); 
         assertEquals(1, res.length); 
         assertEquals("a", res[0]); 
          
         str = "a b c"; 
         res = StringUtils.split(str,' '); 
         assertEquals(3, res.length); 
         assertEquals("a", res[0]); 
         assertEquals("b", res[1]); 
         assertEquals("c", res[2]); 
     }
@Test
public void testSplit_StringStringInt2839() { 
         assertArrayEquals(null, StringUtils.split(null, ".", -1)); 
         assertEquals(0, StringUtils.split("", ".", -1).length); 
  
         String str = "a.b.. c"; 
         String[] res = StringUtils.split(str, ".", -1); 
         assertEquals(3, res.length); 
         assertEquals("a", res[0]); 
         assertEquals("b", res[1]); 
         assertEquals(" c", res[2]); 
              
         str = ".a."; 
         res = StringUtils.split(str, ".", -1); 
         assertEquals(1, res.length); 
         assertEquals("a", res[0]); 
          
         str = "a b c"; 
         res = StringUtils.split(str,' '); 
         assertEquals(3, res.length); 
         assertEquals("a", res[0]); 
         assertEquals("b", res[1]); 
         assertEquals("c", res[2]); 
     }
    
    
    //-----------------------------------------------------------------------
    

    

    //-----------------------------------------------------------------------
    

    
        
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    

    

    

    
    
    
    
    
    
    private void innerTestSplit(final char separator, final String sepStr, final char noMatch) {
        final String msg = "Failed on separator hex(" + Integer.toHexString(separator) +
            "), noMatch hex(" + Integer.toHexString(noMatch) + "), sepStr(" + sepStr + ")";
        
        final String str = "a" + separator + "b" + separator + separator + noMatch + "c";
        String[] res;
        // (str, sepStr)
        res = StringUtils.split(str, sepStr);
        assertEquals(msg, 3, res.length);
        assertEquals(msg, "a", res[0]);
        assertEquals(msg, "b", res[1]);
        assertEquals(msg, noMatch + "c", res[2]);
        
        final String str2 = separator + "a" + separator;
        res = StringUtils.split(str2, sepStr);
        assertEquals(msg, 1, res.length);
        assertEquals(msg, "a", res[0]);

        res = StringUtils.split(str, sepStr, -1);
        assertEquals(msg, 3, res.length);
        assertEquals(msg, "a", res[0]);
        assertEquals(msg, "b", res[1]);
        assertEquals(msg, noMatch + "c", res[2]);
        
        res = StringUtils.split(str, sepStr, 0);
        assertEquals(msg, 3, res.length);
        assertEquals(msg, "a", res[0]);
        assertEquals(msg, "b", res[1]);
        assertEquals(msg, noMatch + "c", res[2]);
        
        res = StringUtils.split(str, sepStr, 1);
        assertEquals(msg, 1, res.length);
        assertEquals(msg, str, res[0]);
        
        res = StringUtils.split(str, sepStr, 2);
        assertEquals(msg, 2, res.length);
        assertEquals(msg, "a", res[0]);
        assertEquals(msg, str.substring(2), res[1]);
    }

    

    

    
    
    
    
    
    
    
    
    private void innerTestSplitPreserveAllTokens(final char separator, final String sepStr, final char noMatch) {
        final String msg = "Failed on separator hex(" + Integer.toHexString(separator) +
            "), noMatch hex(" + Integer.toHexString(noMatch) + "), sepStr(" + sepStr + ")";
        
        final String str = "a" + separator + "b" + separator + separator + noMatch + "c";
        String[] res;
        // (str, sepStr)
        res = StringUtils.splitPreserveAllTokens(str, sepStr);
        assertEquals(msg, 4, res.length);
        assertEquals(msg, "a", res[0]);
        assertEquals(msg, "b", res[1]);
        assertEquals(msg, "", res[2]);
        assertEquals(msg, noMatch + "c", res[3]);
        
        final String str2 = separator + "a" + separator;
        res = StringUtils.splitPreserveAllTokens(str2, sepStr);
        assertEquals(msg, 3, res.length);
        assertEquals(msg, "", res[0]);
        assertEquals(msg, "a", res[1]);
        assertEquals(msg, "", res[2]);

        res = StringUtils.splitPreserveAllTokens(str, sepStr, -1);
        assertEquals(msg, 4, res.length);
        assertEquals(msg, "a", res[0]);
        assertEquals(msg, "b", res[1]);
        assertEquals(msg, "", res[2]);
        assertEquals(msg, noMatch + "c", res[3]);
        
        res = StringUtils.splitPreserveAllTokens(str, sepStr, 0);
        assertEquals(msg, 4, res.length);
        assertEquals(msg, "a", res[0]);
        assertEquals(msg, "b", res[1]);
        assertEquals(msg, "", res[2]);
        assertEquals(msg, noMatch + "c", res[3]);
        
        res = StringUtils.splitPreserveAllTokens(str, sepStr, 1);
        assertEquals(msg, 1, res.length);
        assertEquals(msg, str, res[0]);
        
        res = StringUtils.splitPreserveAllTokens(str, sepStr, 2);
        assertEquals(msg, 2, res.length);
        assertEquals(msg, "a", res[0]);
        assertEquals(msg, str.substring(2), res[1]);
    }

    
    
    

    

    

    
    
    
    
    
    
    
    
    

    /**
     * Test method for 'StringUtils.replaceEach(String, String[], String[])'
     */
    

    /**
     * Test method for 'StringUtils.replaceEachRepeatedly(String, String[], String[])'
     */
    
    
    
    
    
    
    

    

    

    

    

    //-----------------------------------------------------------------------
    

    

    
        
    //-----------------------------------------------------------------------
    
        
    
        
    

    

    

    
    
    

    //-----------------------------------------------------------------------
    
    
    
    
    

    //-----------------------------------------------------------------------
    
        
    

    //-----------------------------------------------------------------------
    

    

    

    

    

    

    

    

    

    

    //-----------------------------------------------------------------------
    
    
    

    private void assertAbbreviateWithOffset(final String expected, final int offset, final int maxWidth) {
        final String abcdefghijklmno = "abcdefghijklmno";
        final String message = "abbreviate(String,int,int) failed";
        final String actual = StringUtils.abbreviate(abcdefghijklmno, offset, maxWidth);
        if (offset >= 0 && offset < abcdefghijklmno.length()) {
            assertTrue(message + " -- should contain offset character",
                    actual.indexOf((char)('a'+offset)) != -1);
        }
        assertTrue(message + " -- should not be greater than maxWidth",
                actual.length() <= maxWidth);
        assertEquals(message, expected, actual);
    }

    

    //-----------------------------------------------------------------------
    

    

    //-----------------------------------------------------------------------
    

    

    /**
     * A sanity check for {@link StringUtils#EMPTY}.
     */
    

    /**
     * Test for {@link StringUtils#isAllLowerCase(CharSequence)}.
     */
    

    /**
     * Test for {@link StringUtils#isAllUpperCase(CharSequence)}.
     */
    

    
    
    

    

    

    

    
    
    
    
    
        
    

    

    // Methods on StringUtils that are immutable in spirit (i.e. calculate the length) 
    // should take a CharSequence parameter. Methods that are mutable in spirit (i.e. capitalize) 
    // should take a String or String[] parameter and return String or String[].
    // This test enforces that this is done.
    

    /**
     * Tests {@link StringUtils#toString(byte[], String)}
     * 
     * @throws UnsupportedEncodingException
     * @see StringUtils#toString(byte[], String)
     */
    
    
    
    
    /**
     * Tests LANG-858.
     * 
     * @throws Exception
     */
    
    
    

    /**
     * Tests {@code appendIfMissing}.
     */
    

    /**
     * Tests {@code appendIfMissingIgnoreCase}.
     */
    

    /**
     * Tests {@code prependIfMissing}.
     */
    

    /**
     * Tests {@code prependIfMissingIgnoreCase}.
     */
    
}
