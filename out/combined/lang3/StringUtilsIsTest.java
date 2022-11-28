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

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * Unit tests {@link org.apache.commons.lang3.StringUtils} - Substring methods
 *
 * @version $Id$
 */
public class StringUtilsIsTest  {

    //-----------------------------------------------------------------------

@Test
public void testIsNumeric399() { 
     assertFalse(StringUtils.isNumeric(null)); 
     assertFalse(StringUtils.isNumeric("")); 
     assertFalse(StringUtils.isNumeric(" ")); 
     assertFalse(StringUtils.isNumeric("a")); 
     assertFalse(StringUtils.isNumeric("A")); 
     assertFalse(StringUtils.isNumeric("kgKgKgKgkgkGkjkjlJlOKLgHdGdHgl")); 
     assertFalse(StringUtils.isNumeric("ham kso")); 
     assertTrue(StringUtils.isNumeric("1")); 
     assertTrue(StringUtils.isNumeric("1000")); 
     assertFalse(StringUtils.isNumeric("2.3")); 
     assertFalse(StringUtils.isNumeric("10 00")); 
     assertFalse(StringUtils.isNumeric("hkHKHik6iUGHKJgU7tUJgKJGI87GIkug")); 
     assertFalse(StringUtils.isNumeric("_")); 
     assertFalse(StringUtils.isNumeric("hkHKHik*khbkuh")); 
     assertFalse(StringUtils.isNumeric("+123")); 
     assertFalse(StringUtils.isNumeric("-123")); 
 }
@Test
public void testIsAsciiPrintable_String504() { 
     assertFalse(StringUtils.isAsciiPrintable(null)); 
     assertTrue(StringUtils.isAsciiPrintable("")); 
     assertTrue(StringUtils.isAsciiPrintable(" ")); 
     assertTrue(StringUtils.isAsciiPrintable("a")); 
     assertTrue(StringUtils.isAsciiPrintable("A")); 
     assertTrue(StringUtils.isAsciiPrintable("1")); 
     assertTrue(StringUtils.isAsciiPrintable("Ceki")); 
     assertTrue(StringUtils.isAsciiPrintable("!ab2c~")); 
     assertTrue(StringUtils.isAsciiPrintable("1000")); 
     assertTrue(StringUtils.isAsciiPrintable("10 00")); 
     assertFalse(StringUtils.isAsciiPrintable("10\t00")); 
     assertTrue(StringUtils.isAsciiPrintable("10.00")); 
     assertTrue(StringUtils.isAsciiPrintable("10,00")); 
     assertTrue(StringUtils.isAsciiPrintable("!ab-c~")); 
     assertTrue(StringUtils.isAsciiPrintable("hkHK=Hik6i?UGH_KJgU7.tUJgKJ*GI87GI,kug")); 
     assertTrue(StringUtils.isAsciiPrintable("\u0020")); 
     assertTrue(StringUtils.isAsciiPrintable("\u0021")); 
     assertTrue(StringUtils.isAsciiPrintable("\u007e")); 
     assertFalse(StringUtils.isAsciiPrintable("\u007f")); 
     assertTrue(StringUtils.isAsciiPrintable("G?lc?")); 
     assertTrue(StringUtils.isAsciiPrintable("=?iso-8859-1?Q?G=FClc=FC?=")); 
     assertFalse(StringUtils.isAsciiPrintable("G\u00fclc\u00fc")); 
 }
@Test
public void testIsNumericSpace818() { 
     assertFalse(StringUtils.isNumericSpace(null)); 
     assertTrue(StringUtils.isNumericSpace("")); 
     assertTrue(StringUtils.isNumericSpace(" ")); 
     assertFalse(StringUtils.isNumericSpace("a")); 
     assertFalse(StringUtils.isNumericSpace("A")); 
     assertFalse(StringUtils.isNumericSpace("kgKgKgKgkgkGkjkjlJlOKLgHdGdHgl")); 
     assertFalse(StringUtils.isNumericSpace("ham kso")); 
     assertTrue(StringUtils.isNumericSpace("1")); 
     assertTrue(StringUtils.isNumericSpace("1000")); 
     assertFalse(StringUtils.isNumericSpace("2.3")); 
     assertTrue(StringUtils.isNumericSpace("10 00")); 
     assertFalse(StringUtils.isNumericSpace("hkHKHik6iUGHKJgU7tUJgKJGI87GIkug")); 
     assertFalse(StringUtils.isNumericSpace("_")); 
     assertFalse(StringUtils.isNumericSpace("hkHKHik*khbkuh")); 
 }
@Test
public void testIsAsciiPrintable_String1157() { 
     assertFalse(StringUtils.isAsciiPrintable(null)); 
     assertTrue(StringUtils.isAsciiPrintable("")); 
     assertTrue(StringUtils.isAsciiPrintable(" ")); 
     assertTrue(StringUtils.isAsciiPrintable("a")); 
     assertTrue(StringUtils.isAsciiPrintable("A")); 
     assertTrue(StringUtils.isAsciiPrintable("1")); 
     assertTrue(StringUtils.isAsciiPrintable("Ceki")); 
     assertTrue(StringUtils.isAsciiPrintable("!ab2c~")); 
     assertTrue(StringUtils.isAsciiPrintable("1000")); 
     assertTrue(StringUtils.isAsciiPrintable("10 00")); 
     assertFalse(StringUtils.isAsciiPrintable("10\t00")); 
     assertTrue(StringUtils.isAsciiPrintable("10.00")); 
     assertTrue(StringUtils.isAsciiPrintable("10,00")); 
     assertTrue(StringUtils.isAsciiPrintable("!ab-c~")); 
     assertTrue(StringUtils.isAsciiPrintable("hkHK=Hik6i?UGH_KJgU7.tUJgKJ*GI87GI,kug")); 
     assertTrue(StringUtils.isAsciiPrintable("\u0020")); 
     assertTrue(StringUtils.isAsciiPrintable("\u0021")); 
     assertTrue(StringUtils.isAsciiPrintable("\u007e")); 
     assertFalse(StringUtils.isAsciiPrintable("\u007f")); 
     assertTrue(StringUtils.isAsciiPrintable("G?lc?")); 
     assertTrue(StringUtils.isAsciiPrintable("=?iso-8859-1?Q?G=FClc=FC?=")); 
     assertFalse(StringUtils.isAsciiPrintable("G\u00fclc\u00fc")); 
 }
@Test
public void testIsAsciiPrintable_String1173() { 
     assertFalse(StringUtils.isAsciiPrintable(null)); 
     assertTrue(StringUtils.isAsciiPrintable("")); 
     assertTrue(StringUtils.isAsciiPrintable(" ")); 
     assertTrue(StringUtils.isAsciiPrintable("a")); 
     assertTrue(StringUtils.isAsciiPrintable("A")); 
     assertTrue(StringUtils.isAsciiPrintable("1")); 
     assertTrue(StringUtils.isAsciiPrintable("Ceki")); 
     assertTrue(StringUtils.isAsciiPrintable("!ab2c~")); 
     assertTrue(StringUtils.isAsciiPrintable("1000")); 
     assertTrue(StringUtils.isAsciiPrintable("10 00")); 
     assertFalse(StringUtils.isAsciiPrintable("10\t00")); 
     assertTrue(StringUtils.isAsciiPrintable("10.00")); 
     assertTrue(StringUtils.isAsciiPrintable("10,00")); 
     assertTrue(StringUtils.isAsciiPrintable("!ab-c~")); 
     assertTrue(StringUtils.isAsciiPrintable("hkHK=Hik6i?UGH_KJgU7.tUJgKJ*GI87GI,kug")); 
     assertTrue(StringUtils.isAsciiPrintable("\u0020")); 
     assertTrue(StringUtils.isAsciiPrintable("\u0021")); 
     assertTrue(StringUtils.isAsciiPrintable("\u007e")); 
     assertFalse(StringUtils.isAsciiPrintable("\u007f")); 
     assertTrue(StringUtils.isAsciiPrintable("G?lc?")); 
     assertTrue(StringUtils.isAsciiPrintable("=?iso-8859-1?Q?G=FClc=FC?=")); 
     assertFalse(StringUtils.isAsciiPrintable("G\u00fclc\u00fc")); 
 }
@Test
public void testIsAlphanumeric1251() { 
     assertFalse(StringUtils.isAlphanumeric(null)); 
     assertFalse(StringUtils.isAlphanumeric("")); 
     assertFalse(StringUtils.isAlphanumeric(" ")); 
     assertTrue(StringUtils.isAlphanumeric("a")); 
     assertTrue(StringUtils.isAlphanumeric("A")); 
     assertTrue(StringUtils.isAlphanumeric("kgKgKgKgkgkGkjkjlJlOKLgHdGdHgl")); 
     assertFalse(StringUtils.isAlphanumeric("ham kso")); 
     assertTrue(StringUtils.isAlphanumeric("1")); 
     assertTrue(StringUtils.isAlphanumeric("hkHKHik6iUGHKJgU7tUJgKJGI87GIkug")); 
     assertFalse(StringUtils.isAlphanumeric("_")); 
     assertFalse(StringUtils.isAlphanumeric("hkHKHik*khbkuh")); 
 }
@Test
public void testIsAlphanumericSpace1328() { 
     assertFalse(StringUtils.isAlphanumericSpace(null)); 
     assertTrue(StringUtils.isAlphanumericSpace("")); 
     assertTrue(StringUtils.isAlphanumericSpace(" ")); 
     assertTrue(StringUtils.isAlphanumericSpace("a")); 
     assertTrue(StringUtils.isAlphanumericSpace("A")); 
     assertTrue(StringUtils.isAlphanumericSpace("kgKgKgKgkgkGkjkjlJlOKLgHdGdHgl")); 
     assertTrue(StringUtils.isAlphanumericSpace("ham kso")); 
     assertTrue(StringUtils.isAlphanumericSpace("1")); 
     assertTrue(StringUtils.isAlphanumericSpace("hkHKHik6iUGHKJgU7tUJgKJGI87GIkug")); 
     assertFalse(StringUtils.isAlphanumericSpace("_")); 
     assertFalse(StringUtils.isAlphanumericSpace("hkHKHik*khbkuh")); 
 }
@Test
public void testIsNumericSpace1521() { 
     assertFalse(StringUtils.isNumericSpace(null)); 
     assertTrue(StringUtils.isNumericSpace("")); 
     assertTrue(StringUtils.isNumericSpace(" ")); 
     assertFalse(StringUtils.isNumericSpace("a")); 
     assertFalse(StringUtils.isNumericSpace("A")); 
     assertFalse(StringUtils.isNumericSpace("kgKgKgKgkgkGkjkjlJlOKLgHdGdHgl")); 
     assertFalse(StringUtils.isNumericSpace("ham kso")); 
     assertTrue(StringUtils.isNumericSpace("1")); 
     assertTrue(StringUtils.isNumericSpace("1000")); 
     assertFalse(StringUtils.isNumericSpace("2.3")); 
     assertTrue(StringUtils.isNumericSpace("10 00")); 
     assertFalse(StringUtils.isNumericSpace("hkHKHik6iUGHKJgU7tUJgKJGI87GIkug")); 
     assertFalse(StringUtils.isNumericSpace("_")); 
     assertFalse(StringUtils.isNumericSpace("hkHKHik*khbkuh")); 
 }
@Test
public void testIsAlphanumericSpace1824() { 
     assertFalse(StringUtils.isAlphanumericSpace(null)); 
     assertTrue(StringUtils.isAlphanumericSpace("")); 
     assertTrue(StringUtils.isAlphanumericSpace(" ")); 
     assertTrue(StringUtils.isAlphanumericSpace("a")); 
     assertTrue(StringUtils.isAlphanumericSpace("A")); 
     assertTrue(StringUtils.isAlphanumericSpace("kgKgKgKgkgkGkjkjlJlOKLgHdGdHgl")); 
     assertTrue(StringUtils.isAlphanumericSpace("ham kso")); 
     assertTrue(StringUtils.isAlphanumericSpace("1")); 
     assertTrue(StringUtils.isAlphanumericSpace("hkHKHik6iUGHKJgU7tUJgKJGI87GIkug")); 
     assertFalse(StringUtils.isAlphanumericSpace("_")); 
     assertFalse(StringUtils.isAlphanumericSpace("hkHKHik*khbkuh")); 
 }
@Test
public void testIsAlphaspace2020() { 
     assertFalse(StringUtils.isAlphaSpace(null)); 
     assertTrue(StringUtils.isAlphaSpace("")); 
     assertTrue(StringUtils.isAlphaSpace(" ")); 
     assertTrue(StringUtils.isAlphaSpace("a")); 
     assertTrue(StringUtils.isAlphaSpace("A")); 
     assertTrue(StringUtils.isAlphaSpace("kgKgKgKgkgkGkjkjlJlOKLgHdGdHgl")); 
     assertTrue(StringUtils.isAlphaSpace("ham kso")); 
     assertFalse(StringUtils.isAlphaSpace("1")); 
     assertFalse(StringUtils.isAlphaSpace("hkHKHik6iUGHKJgU7tUJgKJGI87GIkug")); 
     assertFalse(StringUtils.isAlphaSpace("_")); 
     assertFalse(StringUtils.isAlphaSpace("hkHKHik*khbkuh")); 
 }
@Test
public void testIsNumeric2057() { 
     assertFalse(StringUtils.isNumeric(null)); 
     assertFalse(StringUtils.isNumeric("")); 
     assertFalse(StringUtils.isNumeric(" ")); 
     assertFalse(StringUtils.isNumeric("a")); 
     assertFalse(StringUtils.isNumeric("A")); 
     assertFalse(StringUtils.isNumeric("kgKgKgKgkgkGkjkjlJlOKLgHdGdHgl")); 
     assertFalse(StringUtils.isNumeric("ham kso")); 
     assertTrue(StringUtils.isNumeric("1")); 
     assertTrue(StringUtils.isNumeric("1000")); 
     assertFalse(StringUtils.isNumeric("2.3")); 
     assertFalse(StringUtils.isNumeric("10 00")); 
     assertFalse(StringUtils.isNumeric("hkHKHik6iUGHKJgU7tUJgKJGI87GIkug")); 
     assertFalse(StringUtils.isNumeric("_")); 
     assertFalse(StringUtils.isNumeric("hkHKHik*khbkuh")); 
     assertFalse(StringUtils.isNumeric("+123")); 
     assertFalse(StringUtils.isNumeric("-123")); 
 }
@Test
public void testIsAlphanumericSpace2438() { 
     assertFalse(StringUtils.isAlphanumericSpace(null)); 
     assertTrue(StringUtils.isAlphanumericSpace("")); 
     assertTrue(StringUtils.isAlphanumericSpace(" ")); 
     assertTrue(StringUtils.isAlphanumericSpace("a")); 
     assertTrue(StringUtils.isAlphanumericSpace("A")); 
     assertTrue(StringUtils.isAlphanumericSpace("kgKgKgKgkgkGkjkjlJlOKLgHdGdHgl")); 
     assertTrue(StringUtils.isAlphanumericSpace("ham kso")); 
     assertTrue(StringUtils.isAlphanumericSpace("1")); 
     assertTrue(StringUtils.isAlphanumericSpace("hkHKHik6iUGHKJgU7tUJgKJGI87GIkug")); 
     assertFalse(StringUtils.isAlphanumericSpace("_")); 
     assertFalse(StringUtils.isAlphanumericSpace("hkHKHik*khbkuh")); 
 }
@Test
public void testIsAlphanumericSpace2588() { 
     assertFalse(StringUtils.isAlphanumericSpace(null)); 
     assertTrue(StringUtils.isAlphanumericSpace("")); 
     assertTrue(StringUtils.isAlphanumericSpace(" ")); 
     assertTrue(StringUtils.isAlphanumericSpace("a")); 
     assertTrue(StringUtils.isAlphanumericSpace("A")); 
     assertTrue(StringUtils.isAlphanumericSpace("kgKgKgKgkgkGkjkjlJlOKLgHdGdHgl")); 
     assertTrue(StringUtils.isAlphanumericSpace("ham kso")); 
     assertTrue(StringUtils.isAlphanumericSpace("1")); 
     assertTrue(StringUtils.isAlphanumericSpace("hkHKHik6iUGHKJgU7tUJgKJGI87GIkug")); 
     assertFalse(StringUtils.isAlphanumericSpace("_")); 
     assertFalse(StringUtils.isAlphanumericSpace("hkHKHik*khbkuh")); 
 }
@Test
public void testIsAlphanumeric2597() { 
     assertFalse(StringUtils.isAlphanumeric(null)); 
     assertFalse(StringUtils.isAlphanumeric("")); 
     assertFalse(StringUtils.isAlphanumeric(" ")); 
     assertTrue(StringUtils.isAlphanumeric("a")); 
     assertTrue(StringUtils.isAlphanumeric("A")); 
     assertTrue(StringUtils.isAlphanumeric("kgKgKgKgkgkGkjkjlJlOKLgHdGdHgl")); 
     assertFalse(StringUtils.isAlphanumeric("ham kso")); 
     assertTrue(StringUtils.isAlphanumeric("1")); 
     assertTrue(StringUtils.isAlphanumeric("hkHKHik6iUGHKJgU7tUJgKJGI87GIkug")); 
     assertFalse(StringUtils.isAlphanumeric("_")); 
     assertFalse(StringUtils.isAlphanumeric("hkHKHik*khbkuh")); 
 }
@Test
public void testIsWhitespace2602() { 
     assertFalse(StringUtils.isWhitespace(null)); 
     assertTrue(StringUtils.isWhitespace("")); 
     assertTrue(StringUtils.isWhitespace(" ")); 
     assertTrue(StringUtils.isWhitespace("\t \n \t")); 
     assertFalse(StringUtils.isWhitespace("\t aa\n \t")); 
     assertTrue(StringUtils.isWhitespace(" ")); 
     assertFalse(StringUtils.isWhitespace(" a ")); 
     assertFalse(StringUtils.isWhitespace("a  ")); 
     assertFalse(StringUtils.isWhitespace("  a")); 
     assertFalse(StringUtils.isWhitespace("aba")); 
     assertTrue(StringUtils.isWhitespace(StringUtilsTest.WHITESPACE)); 
     assertFalse(StringUtils.isWhitespace(StringUtilsTest.NON_WHITESPACE)); 
 }
@Test
public void testIsAlphanumeric2950() { 
     assertFalse(StringUtils.isAlphanumeric(null)); 
     assertFalse(StringUtils.isAlphanumeric("")); 
     assertFalse(StringUtils.isAlphanumeric(" ")); 
     assertTrue(StringUtils.isAlphanumeric("a")); 
     assertTrue(StringUtils.isAlphanumeric("A")); 
     assertTrue(StringUtils.isAlphanumeric("kgKgKgKgkgkGkjkjlJlOKLgHdGdHgl")); 
     assertFalse(StringUtils.isAlphanumeric("ham kso")); 
     assertTrue(StringUtils.isAlphanumeric("1")); 
     assertTrue(StringUtils.isAlphanumeric("hkHKHik6iUGHKJgU7tUJgKJGI87GIkug")); 
     assertFalse(StringUtils.isAlphanumeric("_")); 
     assertFalse(StringUtils.isAlphanumeric("hkHKHik*khbkuh")); 
 }
@Test
public void testIsNumeric3068() { 
     assertFalse(StringUtils.isNumeric(null)); 
     assertFalse(StringUtils.isNumeric("")); 
     assertFalse(StringUtils.isNumeric(" ")); 
     assertFalse(StringUtils.isNumeric("a")); 
     assertFalse(StringUtils.isNumeric("A")); 
     assertFalse(StringUtils.isNumeric("kgKgKgKgkgkGkjkjlJlOKLgHdGdHgl")); 
     assertFalse(StringUtils.isNumeric("ham kso")); 
     assertTrue(StringUtils.isNumeric("1")); 
     assertTrue(StringUtils.isNumeric("1000")); 
     assertFalse(StringUtils.isNumeric("2.3")); 
     assertFalse(StringUtils.isNumeric("10 00")); 
     assertFalse(StringUtils.isNumeric("hkHKHik6iUGHKJgU7tUJgKJGI87GIkug")); 
     assertFalse(StringUtils.isNumeric("_")); 
     assertFalse(StringUtils.isNumeric("hkHKHik*khbkuh")); 
     assertFalse(StringUtils.isNumeric("+123")); 
     assertFalse(StringUtils.isNumeric("-123")); 
 }
@Test
public void testIsAlphaspace3191() { 
     assertFalse(StringUtils.isAlphaSpace(null)); 
     assertTrue(StringUtils.isAlphaSpace("")); 
     assertTrue(StringUtils.isAlphaSpace(" ")); 
     assertTrue(StringUtils.isAlphaSpace("a")); 
     assertTrue(StringUtils.isAlphaSpace("A")); 
     assertTrue(StringUtils.isAlphaSpace("kgKgKgKgkgkGkjkjlJlOKLgHdGdHgl")); 
     assertTrue(StringUtils.isAlphaSpace("ham kso")); 
     assertFalse(StringUtils.isAlphaSpace("1")); 
     assertFalse(StringUtils.isAlphaSpace("hkHKHik6iUGHKJgU7tUJgKJGI87GIkug")); 
     assertFalse(StringUtils.isAlphaSpace("_")); 
     assertFalse(StringUtils.isAlphaSpace("hkHKHik*khbkuh")); 
 }
@Test
public void testIsNumeric3226() { 
     assertFalse(StringUtils.isNumeric(null)); 
     assertFalse(StringUtils.isNumeric("")); 
     assertFalse(StringUtils.isNumeric(" ")); 
     assertFalse(StringUtils.isNumeric("a")); 
     assertFalse(StringUtils.isNumeric("A")); 
     assertFalse(StringUtils.isNumeric("kgKgKgKgkgkGkjkjlJlOKLgHdGdHgl")); 
     assertFalse(StringUtils.isNumeric("ham kso")); 
     assertTrue(StringUtils.isNumeric("1")); 
     assertTrue(StringUtils.isNumeric("1000")); 
     assertFalse(StringUtils.isNumeric("2.3")); 
     assertFalse(StringUtils.isNumeric("10 00")); 
     assertFalse(StringUtils.isNumeric("hkHKHik6iUGHKJgU7tUJgKJGI87GIkug")); 
     assertFalse(StringUtils.isNumeric("_")); 
     assertFalse(StringUtils.isNumeric("hkHKHik*khbkuh")); 
     assertFalse(StringUtils.isNumeric("+123")); 
     assertFalse(StringUtils.isNumeric("-123")); 
 }
@Test
public void testIsAlphanumericSpace3265() { 
     assertFalse(StringUtils.isAlphanumericSpace(null)); 
     assertTrue(StringUtils.isAlphanumericSpace("")); 
     assertTrue(StringUtils.isAlphanumericSpace(" ")); 
     assertTrue(StringUtils.isAlphanumericSpace("a")); 
     assertTrue(StringUtils.isAlphanumericSpace("A")); 
     assertTrue(StringUtils.isAlphanumericSpace("kgKgKgKgkgkGkjkjlJlOKLgHdGdHgl")); 
     assertTrue(StringUtils.isAlphanumericSpace("ham kso")); 
     assertTrue(StringUtils.isAlphanumericSpace("1")); 
     assertTrue(StringUtils.isAlphanumericSpace("hkHKHik6iUGHKJgU7tUJgKJGI87GIkug")); 
     assertFalse(StringUtils.isAlphanumericSpace("_")); 
     assertFalse(StringUtils.isAlphanumericSpace("hkHKHik*khbkuh")); 
 }
@Test
public void testIsAlphanumericSpace3287() { 
     assertFalse(StringUtils.isAlphanumericSpace(null)); 
     assertTrue(StringUtils.isAlphanumericSpace("")); 
     assertTrue(StringUtils.isAlphanumericSpace(" ")); 
     assertTrue(StringUtils.isAlphanumericSpace("a")); 
     assertTrue(StringUtils.isAlphanumericSpace("A")); 
     assertTrue(StringUtils.isAlphanumericSpace("kgKgKgKgkgkGkjkjlJlOKLgHdGdHgl")); 
     assertTrue(StringUtils.isAlphanumericSpace("ham kso")); 
     assertTrue(StringUtils.isAlphanumericSpace("1")); 
     assertTrue(StringUtils.isAlphanumericSpace("hkHKHik6iUGHKJgU7tUJgKJGI87GIkug")); 
     assertFalse(StringUtils.isAlphanumericSpace("_")); 
     assertFalse(StringUtils.isAlphanumericSpace("hkHKHik*khbkuh")); 
 }
@Test
public void testIsAsciiPrintable_String3599() { 
     assertFalse(StringUtils.isAsciiPrintable(null)); 
     assertTrue(StringUtils.isAsciiPrintable("")); 
     assertTrue(StringUtils.isAsciiPrintable(" ")); 
     assertTrue(StringUtils.isAsciiPrintable("a")); 
     assertTrue(StringUtils.isAsciiPrintable("A")); 
     assertTrue(StringUtils.isAsciiPrintable("1")); 
     assertTrue(StringUtils.isAsciiPrintable("Ceki")); 
     assertTrue(StringUtils.isAsciiPrintable("!ab2c~")); 
     assertTrue(StringUtils.isAsciiPrintable("1000")); 
     assertTrue(StringUtils.isAsciiPrintable("10 00")); 
     assertFalse(StringUtils.isAsciiPrintable("10\t00")); 
     assertTrue(StringUtils.isAsciiPrintable("10.00")); 
     assertTrue(StringUtils.isAsciiPrintable("10,00")); 
     assertTrue(StringUtils.isAsciiPrintable("!ab-c~")); 
     assertTrue(StringUtils.isAsciiPrintable("hkHK=Hik6i?UGH_KJgU7.tUJgKJ*GI87GI,kug")); 
     assertTrue(StringUtils.isAsciiPrintable("\u0020")); 
     assertTrue(StringUtils.isAsciiPrintable("\u0021")); 
     assertTrue(StringUtils.isAsciiPrintable("\u007e")); 
     assertFalse(StringUtils.isAsciiPrintable("\u007f")); 
     assertTrue(StringUtils.isAsciiPrintable("G?lc?")); 
     assertTrue(StringUtils.isAsciiPrintable("=?iso-8859-1?Q?G=FClc=FC?=")); 
     assertFalse(StringUtils.isAsciiPrintable("G\u00fclc\u00fc")); 
 }
@Test
public void testIsWhitespace4333() { 
     assertFalse(StringUtils.isWhitespace(null)); 
     assertTrue(StringUtils.isWhitespace("")); 
     assertTrue(StringUtils.isWhitespace(" ")); 
     assertTrue(StringUtils.isWhitespace("\t \n \t")); 
     assertFalse(StringUtils.isWhitespace("\t aa\n \t")); 
     assertTrue(StringUtils.isWhitespace(" ")); 
     assertFalse(StringUtils.isWhitespace(" a ")); 
     assertFalse(StringUtils.isWhitespace("a  ")); 
     assertFalse(StringUtils.isWhitespace("  a")); 
     assertFalse(StringUtils.isWhitespace("aba")); 
     assertTrue(StringUtils.isWhitespace(StringUtilsTest.WHITESPACE)); 
     assertFalse(StringUtils.isWhitespace(StringUtilsTest.NON_WHITESPACE)); 
 }
@Test
public void testIsAsciiPrintable_String4361() { 
     assertFalse(StringUtils.isAsciiPrintable(null)); 
     assertTrue(StringUtils.isAsciiPrintable("")); 
     assertTrue(StringUtils.isAsciiPrintable(" ")); 
     assertTrue(StringUtils.isAsciiPrintable("a")); 
     assertTrue(StringUtils.isAsciiPrintable("A")); 
     assertTrue(StringUtils.isAsciiPrintable("1")); 
     assertTrue(StringUtils.isAsciiPrintable("Ceki")); 
     assertTrue(StringUtils.isAsciiPrintable("!ab2c~")); 
     assertTrue(StringUtils.isAsciiPrintable("1000")); 
     assertTrue(StringUtils.isAsciiPrintable("10 00")); 
     assertFalse(StringUtils.isAsciiPrintable("10\t00")); 
     assertTrue(StringUtils.isAsciiPrintable("10.00")); 
     assertTrue(StringUtils.isAsciiPrintable("10,00")); 
     assertTrue(StringUtils.isAsciiPrintable("!ab-c~")); 
     assertTrue(StringUtils.isAsciiPrintable("hkHK=Hik6i?UGH_KJgU7.tUJgKJ*GI87GI,kug")); 
     assertTrue(StringUtils.isAsciiPrintable("\u0020")); 
     assertTrue(StringUtils.isAsciiPrintable("\u0021")); 
     assertTrue(StringUtils.isAsciiPrintable("\u007e")); 
     assertFalse(StringUtils.isAsciiPrintable("\u007f")); 
     assertTrue(StringUtils.isAsciiPrintable("G?lc?")); 
     assertTrue(StringUtils.isAsciiPrintable("=?iso-8859-1?Q?G=FClc=FC?=")); 
     assertFalse(StringUtils.isAsciiPrintable("G\u00fclc\u00fc")); 
 }
@Test
public void testIsNumericSpace4572() { 
     assertFalse(StringUtils.isNumericSpace(null)); 
     assertTrue(StringUtils.isNumericSpace("")); 
     assertTrue(StringUtils.isNumericSpace(" ")); 
     assertFalse(StringUtils.isNumericSpace("a")); 
     assertFalse(StringUtils.isNumericSpace("A")); 
     assertFalse(StringUtils.isNumericSpace("kgKgKgKgkgkGkjkjlJlOKLgHdGdHgl")); 
     assertFalse(StringUtils.isNumericSpace("ham kso")); 
     assertTrue(StringUtils.isNumericSpace("1")); 
     assertTrue(StringUtils.isNumericSpace("1000")); 
     assertFalse(StringUtils.isNumericSpace("2.3")); 
     assertTrue(StringUtils.isNumericSpace("10 00")); 
     assertFalse(StringUtils.isNumericSpace("hkHKHik6iUGHKJgU7tUJgKJGI87GIkug")); 
     assertFalse(StringUtils.isNumericSpace("_")); 
     assertFalse(StringUtils.isNumericSpace("hkHKHik*khbkuh")); 
 }
@Test
public void testIsAlphaspace4921() { 
     assertFalse(StringUtils.isAlphaSpace(null)); 
     assertTrue(StringUtils.isAlphaSpace("")); 
     assertTrue(StringUtils.isAlphaSpace(" ")); 
     assertTrue(StringUtils.isAlphaSpace("a")); 
     assertTrue(StringUtils.isAlphaSpace("A")); 
     assertTrue(StringUtils.isAlphaSpace("kgKgKgKgkgkGkjkjlJlOKLgHdGdHgl")); 
     assertTrue(StringUtils.isAlphaSpace("ham kso")); 
     assertFalse(StringUtils.isAlphaSpace("1")); 
     assertFalse(StringUtils.isAlphaSpace("hkHKHik6iUGHKJgU7tUJgKJGI87GIkug")); 
     assertFalse(StringUtils.isAlphaSpace("_")); 
     assertFalse(StringUtils.isAlphaSpace("hkHKHik*khbkuh")); 
 }
@Test
public void testIsNumeric4947() { 
     assertFalse(StringUtils.isNumeric(null)); 
     assertFalse(StringUtils.isNumeric("")); 
     assertFalse(StringUtils.isNumeric(" ")); 
     assertFalse(StringUtils.isNumeric("a")); 
     assertFalse(StringUtils.isNumeric("A")); 
     assertFalse(StringUtils.isNumeric("kgKgKgKgkgkGkjkjlJlOKLgHdGdHgl")); 
     assertFalse(StringUtils.isNumeric("ham kso")); 
     assertTrue(StringUtils.isNumeric("1")); 
     assertTrue(StringUtils.isNumeric("1000")); 
     assertFalse(StringUtils.isNumeric("2.3")); 
     assertFalse(StringUtils.isNumeric("10 00")); 
     assertFalse(StringUtils.isNumeric("hkHKHik6iUGHKJgU7tUJgKJGI87GIkug")); 
     assertFalse(StringUtils.isNumeric("_")); 
     assertFalse(StringUtils.isNumeric("hkHKHik*khbkuh")); 
     assertFalse(StringUtils.isNumeric("+123")); 
     assertFalse(StringUtils.isNumeric("-123")); 
 }
@Test
public void testIsAlphanumeric5024() { 
     assertFalse(StringUtils.isAlphanumeric(null)); 
     assertFalse(StringUtils.isAlphanumeric("")); 
     assertFalse(StringUtils.isAlphanumeric(" ")); 
     assertTrue(StringUtils.isAlphanumeric("a")); 
     assertTrue(StringUtils.isAlphanumeric("A")); 
     assertTrue(StringUtils.isAlphanumeric("kgKgKgKgkgkGkjkjlJlOKLgHdGdHgl")); 
     assertFalse(StringUtils.isAlphanumeric("ham kso")); 
     assertTrue(StringUtils.isAlphanumeric("1")); 
     assertTrue(StringUtils.isAlphanumeric("hkHKHik6iUGHKJgU7tUJgKJGI87GIkug")); 
     assertFalse(StringUtils.isAlphanumeric("_")); 
     assertFalse(StringUtils.isAlphanumeric("hkHKHik*khbkuh")); 
 }
@Test
public void testIsAlphanumericSpace5109() { 
     assertFalse(StringUtils.isAlphanumericSpace(null)); 
     assertTrue(StringUtils.isAlphanumericSpace("")); 
     assertTrue(StringUtils.isAlphanumericSpace(" ")); 
     assertTrue(StringUtils.isAlphanumericSpace("a")); 
     assertTrue(StringUtils.isAlphanumericSpace("A")); 
     assertTrue(StringUtils.isAlphanumericSpace("kgKgKgKgkgkGkjkjlJlOKLgHdGdHgl")); 
     assertTrue(StringUtils.isAlphanumericSpace("ham kso")); 
     assertTrue(StringUtils.isAlphanumericSpace("1")); 
     assertTrue(StringUtils.isAlphanumericSpace("hkHKHik6iUGHKJgU7tUJgKJGI87GIkug")); 
     assertFalse(StringUtils.isAlphanumericSpace("_")); 
     assertFalse(StringUtils.isAlphanumericSpace("hkHKHik*khbkuh")); 
 }
@Test
public void testIsAsciiPrintable_String5148() { 
     assertFalse(StringUtils.isAsciiPrintable(null)); 
     assertTrue(StringUtils.isAsciiPrintable("")); 
     assertTrue(StringUtils.isAsciiPrintable(" ")); 
     assertTrue(StringUtils.isAsciiPrintable("a")); 
     assertTrue(StringUtils.isAsciiPrintable("A")); 
     assertTrue(StringUtils.isAsciiPrintable("1")); 
     assertTrue(StringUtils.isAsciiPrintable("Ceki")); 
     assertTrue(StringUtils.isAsciiPrintable("!ab2c~")); 
     assertTrue(StringUtils.isAsciiPrintable("1000")); 
     assertTrue(StringUtils.isAsciiPrintable("10 00")); 
     assertFalse(StringUtils.isAsciiPrintable("10\t00")); 
     assertTrue(StringUtils.isAsciiPrintable("10.00")); 
     assertTrue(StringUtils.isAsciiPrintable("10,00")); 
     assertTrue(StringUtils.isAsciiPrintable("!ab-c~")); 
     assertTrue(StringUtils.isAsciiPrintable("hkHK=Hik6i?UGH_KJgU7.tUJgKJ*GI87GI,kug")); 
     assertTrue(StringUtils.isAsciiPrintable("\u0020")); 
     assertTrue(StringUtils.isAsciiPrintable("\u0021")); 
     assertTrue(StringUtils.isAsciiPrintable("\u007e")); 
     assertFalse(StringUtils.isAsciiPrintable("\u007f")); 
     assertTrue(StringUtils.isAsciiPrintable("G?lc?")); 
     assertTrue(StringUtils.isAsciiPrintable("=?iso-8859-1?Q?G=FClc=FC?=")); 
     assertFalse(StringUtils.isAsciiPrintable("G\u00fclc\u00fc")); 
 }
@Test
public void testIsNumericSpace5324() { 
     assertFalse(StringUtils.isNumericSpace(null)); 
     assertTrue(StringUtils.isNumericSpace("")); 
     assertTrue(StringUtils.isNumericSpace(" ")); 
     assertFalse(StringUtils.isNumericSpace("a")); 
     assertFalse(StringUtils.isNumericSpace("A")); 
     assertFalse(StringUtils.isNumericSpace("kgKgKgKgkgkGkjkjlJlOKLgHdGdHgl")); 
     assertFalse(StringUtils.isNumericSpace("ham kso")); 
     assertTrue(StringUtils.isNumericSpace("1")); 
     assertTrue(StringUtils.isNumericSpace("1000")); 
     assertFalse(StringUtils.isNumericSpace("2.3")); 
     assertTrue(StringUtils.isNumericSpace("10 00")); 
     assertFalse(StringUtils.isNumericSpace("hkHKHik6iUGHKJgU7tUJgKJGI87GIkug")); 
     assertFalse(StringUtils.isNumericSpace("_")); 
     assertFalse(StringUtils.isNumericSpace("hkHKHik*khbkuh")); 
 }
@Test
public void testIsNumericSpace5347() { 
     assertFalse(StringUtils.isNumericSpace(null)); 
     assertTrue(StringUtils.isNumericSpace("")); 
     assertTrue(StringUtils.isNumericSpace(" ")); 
     assertFalse(StringUtils.isNumericSpace("a")); 
     assertFalse(StringUtils.isNumericSpace("A")); 
     assertFalse(StringUtils.isNumericSpace("kgKgKgKgkgkGkjkjlJlOKLgHdGdHgl")); 
     assertFalse(StringUtils.isNumericSpace("ham kso")); 
     assertTrue(StringUtils.isNumericSpace("1")); 
     assertTrue(StringUtils.isNumericSpace("1000")); 
     assertFalse(StringUtils.isNumericSpace("2.3")); 
     assertTrue(StringUtils.isNumericSpace("10 00")); 
     assertFalse(StringUtils.isNumericSpace("hkHKHik6iUGHKJgU7tUJgKJGI87GIkug")); 
     assertFalse(StringUtils.isNumericSpace("_")); 
     assertFalse(StringUtils.isNumericSpace("hkHKHik*khbkuh")); 
 }
@Test
public void testIsWhitespace5660() { 
     assertFalse(StringUtils.isWhitespace(null)); 
     assertTrue(StringUtils.isWhitespace("")); 
     assertTrue(StringUtils.isWhitespace(" ")); 
     assertTrue(StringUtils.isWhitespace("\t \n \t")); 
     assertFalse(StringUtils.isWhitespace("\t aa\n \t")); 
     assertTrue(StringUtils.isWhitespace(" ")); 
     assertFalse(StringUtils.isWhitespace(" a ")); 
     assertFalse(StringUtils.isWhitespace("a  ")); 
     assertFalse(StringUtils.isWhitespace("  a")); 
     assertFalse(StringUtils.isWhitespace("aba")); 
     assertTrue(StringUtils.isWhitespace(StringUtilsTest.WHITESPACE)); 
     assertFalse(StringUtils.isWhitespace(StringUtilsTest.NON_WHITESPACE)); 
 }
@Test
public void testIsWhitespace5874() { 
     assertFalse(StringUtils.isWhitespace(null)); 
     assertTrue(StringUtils.isWhitespace("")); 
     assertTrue(StringUtils.isWhitespace(" ")); 
     assertTrue(StringUtils.isWhitespace("\t \n \t")); 
     assertFalse(StringUtils.isWhitespace("\t aa\n \t")); 
     assertTrue(StringUtils.isWhitespace(" ")); 
     assertFalse(StringUtils.isWhitespace(" a ")); 
     assertFalse(StringUtils.isWhitespace("a  ")); 
     assertFalse(StringUtils.isWhitespace("  a")); 
     assertFalse(StringUtils.isWhitespace("aba")); 
     assertTrue(StringUtils.isWhitespace(StringUtilsTest.WHITESPACE)); 
     assertFalse(StringUtils.isWhitespace(StringUtilsTest.NON_WHITESPACE)); 
 }
@Test
public void testIsAlphanumeric5973() { 
     assertFalse(StringUtils.isAlphanumeric(null)); 
     assertFalse(StringUtils.isAlphanumeric("")); 
     assertFalse(StringUtils.isAlphanumeric(" ")); 
     assertTrue(StringUtils.isAlphanumeric("a")); 
     assertTrue(StringUtils.isAlphanumeric("A")); 
     assertTrue(StringUtils.isAlphanumeric("kgKgKgKgkgkGkjkjlJlOKLgHdGdHgl")); 
     assertFalse(StringUtils.isAlphanumeric("ham kso")); 
     assertTrue(StringUtils.isAlphanumeric("1")); 
     assertTrue(StringUtils.isAlphanumeric("hkHKHik6iUGHKJgU7tUJgKJGI87GIkug")); 
     assertFalse(StringUtils.isAlphanumeric("_")); 
     assertFalse(StringUtils.isAlphanumeric("hkHKHik*khbkuh")); 
 }
@Test
public void testIsNumericSpace5999() { 
     assertFalse(StringUtils.isNumericSpace(null)); 
     assertTrue(StringUtils.isNumericSpace("")); 
     assertTrue(StringUtils.isNumericSpace(" ")); 
     assertFalse(StringUtils.isNumericSpace("a")); 
     assertFalse(StringUtils.isNumericSpace("A")); 
     assertFalse(StringUtils.isNumericSpace("kgKgKgKgkgkGkjkjlJlOKLgHdGdHgl")); 
     assertFalse(StringUtils.isNumericSpace("ham kso")); 
     assertTrue(StringUtils.isNumericSpace("1")); 
     assertTrue(StringUtils.isNumericSpace("1000")); 
     assertFalse(StringUtils.isNumericSpace("2.3")); 
     assertTrue(StringUtils.isNumericSpace("10 00")); 
     assertFalse(StringUtils.isNumericSpace("hkHKHik6iUGHKJgU7tUJgKJGI87GIkug")); 
     assertFalse(StringUtils.isNumericSpace("_")); 
     assertFalse(StringUtils.isNumericSpace("hkHKHik*khbkuh")); 
 }
@Test
public void testIsAlphaspace6095() { 
     assertFalse(StringUtils.isAlphaSpace(null)); 
     assertTrue(StringUtils.isAlphaSpace("")); 
     assertTrue(StringUtils.isAlphaSpace(" ")); 
     assertTrue(StringUtils.isAlphaSpace("a")); 
     assertTrue(StringUtils.isAlphaSpace("A")); 
     assertTrue(StringUtils.isAlphaSpace("kgKgKgKgkgkGkjkjlJlOKLgHdGdHgl")); 
     assertTrue(StringUtils.isAlphaSpace("ham kso")); 
     assertFalse(StringUtils.isAlphaSpace("1")); 
     assertFalse(StringUtils.isAlphaSpace("hkHKHik6iUGHKJgU7tUJgKJGI87GIkug")); 
     assertFalse(StringUtils.isAlphaSpace("_")); 
     assertFalse(StringUtils.isAlphaSpace("hkHKHik*khbkuh")); 
 }
@Test
public void testIsAlphanumericSpace6305() { 
     assertFalse(StringUtils.isAlphanumericSpace(null)); 
     assertTrue(StringUtils.isAlphanumericSpace("")); 
     assertTrue(StringUtils.isAlphanumericSpace(" ")); 
     assertTrue(StringUtils.isAlphanumericSpace("a")); 
     assertTrue(StringUtils.isAlphanumericSpace("A")); 
     assertTrue(StringUtils.isAlphanumericSpace("kgKgKgKgkgkGkjkjlJlOKLgHdGdHgl")); 
     assertTrue(StringUtils.isAlphanumericSpace("ham kso")); 
     assertTrue(StringUtils.isAlphanumericSpace("1")); 
     assertTrue(StringUtils.isAlphanumericSpace("hkHKHik6iUGHKJgU7tUJgKJGI87GIkug")); 
     assertFalse(StringUtils.isAlphanumericSpace("_")); 
     assertFalse(StringUtils.isAlphanumericSpace("hkHKHik*khbkuh")); 
 }
@Test
public void testIsNumeric6439() { 
     assertFalse(StringUtils.isNumeric(null)); 
     assertFalse(StringUtils.isNumeric("")); 
     assertFalse(StringUtils.isNumeric(" ")); 
     assertFalse(StringUtils.isNumeric("a")); 
     assertFalse(StringUtils.isNumeric("A")); 
     assertFalse(StringUtils.isNumeric("kgKgKgKgkgkGkjkjlJlOKLgHdGdHgl")); 
     assertFalse(StringUtils.isNumeric("ham kso")); 
     assertTrue(StringUtils.isNumeric("1")); 
     assertTrue(StringUtils.isNumeric("1000")); 
     assertFalse(StringUtils.isNumeric("2.3")); 
     assertFalse(StringUtils.isNumeric("10 00")); 
     assertFalse(StringUtils.isNumeric("hkHKHik6iUGHKJgU7tUJgKJGI87GIkug")); 
     assertFalse(StringUtils.isNumeric("_")); 
     assertFalse(StringUtils.isNumeric("hkHKHik*khbkuh")); 
     assertFalse(StringUtils.isNumeric("+123")); 
     assertFalse(StringUtils.isNumeric("-123")); 
 }
@Test
public void testIsNumeric6531() { 
     assertFalse(StringUtils.isNumeric(null)); 
     assertFalse(StringUtils.isNumeric("")); 
     assertFalse(StringUtils.isNumeric(" ")); 
     assertFalse(StringUtils.isNumeric("a")); 
     assertFalse(StringUtils.isNumeric("A")); 
     assertFalse(StringUtils.isNumeric("kgKgKgKgkgkGkjkjlJlOKLgHdGdHgl")); 
     assertFalse(StringUtils.isNumeric("ham kso")); 
     assertTrue(StringUtils.isNumeric("1")); 
     assertTrue(StringUtils.isNumeric("1000")); 
     assertFalse(StringUtils.isNumeric("2.3")); 
     assertFalse(StringUtils.isNumeric("10 00")); 
     assertFalse(StringUtils.isNumeric("hkHKHik6iUGHKJgU7tUJgKJGI87GIkug")); 
     assertFalse(StringUtils.isNumeric("_")); 
     assertFalse(StringUtils.isNumeric("hkHKHik*khbkuh")); 
     assertFalse(StringUtils.isNumeric("+123")); 
     assertFalse(StringUtils.isNumeric("-123")); 
 }
@Test
public void testIsAlphaspace6894() { 
     assertFalse(StringUtils.isAlphaSpace(null)); 
     assertTrue(StringUtils.isAlphaSpace("")); 
     assertTrue(StringUtils.isAlphaSpace(" ")); 
     assertTrue(StringUtils.isAlphaSpace("a")); 
     assertTrue(StringUtils.isAlphaSpace("A")); 
     assertTrue(StringUtils.isAlphaSpace("kgKgKgKgkgkGkjkjlJlOKLgHdGdHgl")); 
     assertTrue(StringUtils.isAlphaSpace("ham kso")); 
     assertFalse(StringUtils.isAlphaSpace("1")); 
     assertFalse(StringUtils.isAlphaSpace("hkHKHik6iUGHKJgU7tUJgKJGI87GIkug")); 
     assertFalse(StringUtils.isAlphaSpace("_")); 
     assertFalse(StringUtils.isAlphaSpace("hkHKHik*khbkuh")); 
 }
@Test
public void testIsAlphaspace6917() { 
     assertFalse(StringUtils.isAlphaSpace(null)); 
     assertTrue(StringUtils.isAlphaSpace("")); 
     assertTrue(StringUtils.isAlphaSpace(" ")); 
     assertTrue(StringUtils.isAlphaSpace("a")); 
     assertTrue(StringUtils.isAlphaSpace("A")); 
     assertTrue(StringUtils.isAlphaSpace("kgKgKgKgkgkGkjkjlJlOKLgHdGdHgl")); 
     assertTrue(StringUtils.isAlphaSpace("ham kso")); 
     assertFalse(StringUtils.isAlphaSpace("1")); 
     assertFalse(StringUtils.isAlphaSpace("hkHKHik6iUGHKJgU7tUJgKJGI87GIkug")); 
     assertFalse(StringUtils.isAlphaSpace("_")); 
     assertFalse(StringUtils.isAlphaSpace("hkHKHik*khbkuh")); 
 }
@Test
public void testIsWhitespace7095() { 
     assertFalse(StringUtils.isWhitespace(null)); 
     assertTrue(StringUtils.isWhitespace("")); 
     assertTrue(StringUtils.isWhitespace(" ")); 
     assertTrue(StringUtils.isWhitespace("\t \n \t")); 
     assertFalse(StringUtils.isWhitespace("\t aa\n \t")); 
     assertTrue(StringUtils.isWhitespace(" ")); 
     assertFalse(StringUtils.isWhitespace(" a ")); 
     assertFalse(StringUtils.isWhitespace("a  ")); 
     assertFalse(StringUtils.isWhitespace("  a")); 
     assertFalse(StringUtils.isWhitespace("aba")); 
     assertTrue(StringUtils.isWhitespace(StringUtilsTest.WHITESPACE)); 
     assertFalse(StringUtils.isWhitespace(StringUtilsTest.NON_WHITESPACE)); 
 }
@Test
public void testIsWhitespace7299() { 
     assertFalse(StringUtils.isWhitespace(null)); 
     assertTrue(StringUtils.isWhitespace("")); 
     assertTrue(StringUtils.isWhitespace(" ")); 
     assertTrue(StringUtils.isWhitespace("\t \n \t")); 
     assertFalse(StringUtils.isWhitespace("\t aa\n \t")); 
     assertTrue(StringUtils.isWhitespace(" ")); 
     assertFalse(StringUtils.isWhitespace(" a ")); 
     assertFalse(StringUtils.isWhitespace("a  ")); 
     assertFalse(StringUtils.isWhitespace("  a")); 
     assertFalse(StringUtils.isWhitespace("aba")); 
     assertTrue(StringUtils.isWhitespace(StringUtilsTest.WHITESPACE)); 
     assertFalse(StringUtils.isWhitespace(StringUtilsTest.NON_WHITESPACE)); 
 }
@Test
public void testIsAsciiPrintable_String7320() { 
     assertFalse(StringUtils.isAsciiPrintable(null)); 
     assertTrue(StringUtils.isAsciiPrintable("")); 
     assertTrue(StringUtils.isAsciiPrintable(" ")); 
     assertTrue(StringUtils.isAsciiPrintable("a")); 
     assertTrue(StringUtils.isAsciiPrintable("A")); 
     assertTrue(StringUtils.isAsciiPrintable("1")); 
     assertTrue(StringUtils.isAsciiPrintable("Ceki")); 
     assertTrue(StringUtils.isAsciiPrintable("!ab2c~")); 
     assertTrue(StringUtils.isAsciiPrintable("1000")); 
     assertTrue(StringUtils.isAsciiPrintable("10 00")); 
     assertFalse(StringUtils.isAsciiPrintable("10\t00")); 
     assertTrue(StringUtils.isAsciiPrintable("10.00")); 
     assertTrue(StringUtils.isAsciiPrintable("10,00")); 
     assertTrue(StringUtils.isAsciiPrintable("!ab-c~")); 
     assertTrue(StringUtils.isAsciiPrintable("hkHK=Hik6i?UGH_KJgU7.tUJgKJ*GI87GI,kug")); 
     assertTrue(StringUtils.isAsciiPrintable("\u0020")); 
     assertTrue(StringUtils.isAsciiPrintable("\u0021")); 
     assertTrue(StringUtils.isAsciiPrintable("\u007e")); 
     assertFalse(StringUtils.isAsciiPrintable("\u007f")); 
     assertTrue(StringUtils.isAsciiPrintable("G?lc?")); 
     assertTrue(StringUtils.isAsciiPrintable("=?iso-8859-1?Q?G=FClc=FC?=")); 
     assertFalse(StringUtils.isAsciiPrintable("G\u00fclc\u00fc")); 
 }
@Test
public void testIsWhitespace7331() { 
     assertFalse(StringUtils.isWhitespace(null)); 
     assertTrue(StringUtils.isWhitespace("")); 
     assertTrue(StringUtils.isWhitespace(" ")); 
     assertTrue(StringUtils.isWhitespace("\t \n \t")); 
     assertFalse(StringUtils.isWhitespace("\t aa\n \t")); 
     assertTrue(StringUtils.isWhitespace(" ")); 
     assertFalse(StringUtils.isWhitespace(" a ")); 
     assertFalse(StringUtils.isWhitespace("a  ")); 
     assertFalse(StringUtils.isWhitespace("  a")); 
     assertFalse(StringUtils.isWhitespace("aba")); 
     assertTrue(StringUtils.isWhitespace(StringUtilsTest.WHITESPACE)); 
     assertFalse(StringUtils.isWhitespace(StringUtilsTest.NON_WHITESPACE)); 
 }
@Test
public void testIsWhitespace7712() { 
     assertFalse(StringUtils.isWhitespace(null)); 
     assertTrue(StringUtils.isWhitespace("")); 
     assertTrue(StringUtils.isWhitespace(" ")); 
     assertTrue(StringUtils.isWhitespace("\t \n \t")); 
     assertFalse(StringUtils.isWhitespace("\t aa\n \t")); 
     assertTrue(StringUtils.isWhitespace(" ")); 
     assertFalse(StringUtils.isWhitespace(" a ")); 
     assertFalse(StringUtils.isWhitespace("a  ")); 
     assertFalse(StringUtils.isWhitespace("  a")); 
     assertFalse(StringUtils.isWhitespace("aba")); 
     assertTrue(StringUtils.isWhitespace(StringUtilsTest.WHITESPACE)); 
     assertFalse(StringUtils.isWhitespace(StringUtilsTest.NON_WHITESPACE)); 
 }
@Test
public void testIsAlphanumeric7767() { 
     assertFalse(StringUtils.isAlphanumeric(null)); 
     assertFalse(StringUtils.isAlphanumeric("")); 
     assertFalse(StringUtils.isAlphanumeric(" ")); 
     assertTrue(StringUtils.isAlphanumeric("a")); 
     assertTrue(StringUtils.isAlphanumeric("A")); 
     assertTrue(StringUtils.isAlphanumeric("kgKgKgKgkgkGkjkjlJlOKLgHdGdHgl")); 
     assertFalse(StringUtils.isAlphanumeric("ham kso")); 
     assertTrue(StringUtils.isAlphanumeric("1")); 
     assertTrue(StringUtils.isAlphanumeric("hkHKHik6iUGHKJgU7tUJgKJGI87GIkug")); 
     assertFalse(StringUtils.isAlphanumeric("_")); 
     assertFalse(StringUtils.isAlphanumeric("hkHKHik*khbkuh")); 
 }
@Test
public void testIsAlphaspace7971() { 
     assertFalse(StringUtils.isAlphaSpace(null)); 
     assertTrue(StringUtils.isAlphaSpace("")); 
     assertTrue(StringUtils.isAlphaSpace(" ")); 
     assertTrue(StringUtils.isAlphaSpace("a")); 
     assertTrue(StringUtils.isAlphaSpace("A")); 
     assertTrue(StringUtils.isAlphaSpace("kgKgKgKgkgkGkjkjlJlOKLgHdGdHgl")); 
     assertTrue(StringUtils.isAlphaSpace("ham kso")); 
     assertFalse(StringUtils.isAlphaSpace("1")); 
     assertFalse(StringUtils.isAlphaSpace("hkHKHik6iUGHKJgU7tUJgKJGI87GIkug")); 
     assertFalse(StringUtils.isAlphaSpace("_")); 
     assertFalse(StringUtils.isAlphaSpace("hkHKHik*khbkuh")); 
 }
@Test
public void testIsAsciiPrintable_String8017() { 
     assertFalse(StringUtils.isAsciiPrintable(null)); 
     assertTrue(StringUtils.isAsciiPrintable("")); 
     assertTrue(StringUtils.isAsciiPrintable(" ")); 
     assertTrue(StringUtils.isAsciiPrintable("a")); 
     assertTrue(StringUtils.isAsciiPrintable("A")); 
     assertTrue(StringUtils.isAsciiPrintable("1")); 
     assertTrue(StringUtils.isAsciiPrintable("Ceki")); 
     assertTrue(StringUtils.isAsciiPrintable("!ab2c~")); 
     assertTrue(StringUtils.isAsciiPrintable("1000")); 
     assertTrue(StringUtils.isAsciiPrintable("10 00")); 
     assertFalse(StringUtils.isAsciiPrintable("10\t00")); 
     assertTrue(StringUtils.isAsciiPrintable("10.00")); 
     assertTrue(StringUtils.isAsciiPrintable("10,00")); 
     assertTrue(StringUtils.isAsciiPrintable("!ab-c~")); 
     assertTrue(StringUtils.isAsciiPrintable("hkHK=Hik6i?UGH_KJgU7.tUJgKJ*GI87GI,kug")); 
     assertTrue(StringUtils.isAsciiPrintable("\u0020")); 
     assertTrue(StringUtils.isAsciiPrintable("\u0021")); 
     assertTrue(StringUtils.isAsciiPrintable("\u007e")); 
     assertFalse(StringUtils.isAsciiPrintable("\u007f")); 
     assertTrue(StringUtils.isAsciiPrintable("G?lc?")); 
     assertTrue(StringUtils.isAsciiPrintable("=?iso-8859-1?Q?G=FClc=FC?=")); 
     assertFalse(StringUtils.isAsciiPrintable("G\u00fclc\u00fc")); 
 }
@Test
public void testIsAlphanumeric8020() { 
     assertFalse(StringUtils.isAlphanumeric(null)); 
     assertFalse(StringUtils.isAlphanumeric("")); 
     assertFalse(StringUtils.isAlphanumeric(" ")); 
     assertTrue(StringUtils.isAlphanumeric("a")); 
     assertTrue(StringUtils.isAlphanumeric("A")); 
     assertTrue(StringUtils.isAlphanumeric("kgKgKgKgkgkGkjkjlJlOKLgHdGdHgl")); 
     assertFalse(StringUtils.isAlphanumeric("ham kso")); 
     assertTrue(StringUtils.isAlphanumeric("1")); 
     assertTrue(StringUtils.isAlphanumeric("hkHKHik6iUGHKJgU7tUJgKJGI87GIkug")); 
     assertFalse(StringUtils.isAlphanumeric("_")); 
     assertFalse(StringUtils.isAlphanumeric("hkHKHik*khbkuh")); 
 }
@Test
public void testIsNumeric8437() { 
     assertFalse(StringUtils.isNumeric(null)); 
     assertFalse(StringUtils.isNumeric("")); 
     assertFalse(StringUtils.isNumeric(" ")); 
     assertFalse(StringUtils.isNumeric("a")); 
     assertFalse(StringUtils.isNumeric("A")); 
     assertFalse(StringUtils.isNumeric("kgKgKgKgkgkGkjkjlJlOKLgHdGdHgl")); 
     assertFalse(StringUtils.isNumeric("ham kso")); 
     assertTrue(StringUtils.isNumeric("1")); 
     assertTrue(StringUtils.isNumeric("1000")); 
     assertFalse(StringUtils.isNumeric("2.3")); 
     assertFalse(StringUtils.isNumeric("10 00")); 
     assertFalse(StringUtils.isNumeric("hkHKHik6iUGHKJgU7tUJgKJGI87GIkug")); 
     assertFalse(StringUtils.isNumeric("_")); 
     assertFalse(StringUtils.isNumeric("hkHKHik*khbkuh")); 
     assertFalse(StringUtils.isNumeric("+123")); 
     assertFalse(StringUtils.isNumeric("-123")); 
 }
@Test
public void testIsNumericSpace8474() { 
     assertFalse(StringUtils.isNumericSpace(null)); 
     assertTrue(StringUtils.isNumericSpace("")); 
     assertTrue(StringUtils.isNumericSpace(" ")); 
     assertFalse(StringUtils.isNumericSpace("a")); 
     assertFalse(StringUtils.isNumericSpace("A")); 
     assertFalse(StringUtils.isNumericSpace("kgKgKgKgkgkGkjkjlJlOKLgHdGdHgl")); 
     assertFalse(StringUtils.isNumericSpace("ham kso")); 
     assertTrue(StringUtils.isNumericSpace("1")); 
     assertTrue(StringUtils.isNumericSpace("1000")); 
     assertFalse(StringUtils.isNumericSpace("2.3")); 
     assertTrue(StringUtils.isNumericSpace("10 00")); 
     assertFalse(StringUtils.isNumericSpace("hkHKHik6iUGHKJgU7tUJgKJGI87GIkug")); 
     assertFalse(StringUtils.isNumericSpace("_")); 
     assertFalse(StringUtils.isNumericSpace("hkHKHik*khbkuh")); 
 }
@Test
public void testIsAlphaspace8866() { 
     assertFalse(StringUtils.isAlphaSpace(null)); 
     assertTrue(StringUtils.isAlphaSpace("")); 
     assertTrue(StringUtils.isAlphaSpace(" ")); 
     assertTrue(StringUtils.isAlphaSpace("a")); 
     assertTrue(StringUtils.isAlphaSpace("A")); 
     assertTrue(StringUtils.isAlphaSpace("kgKgKgKgkgkGkjkjlJlOKLgHdGdHgl")); 
     assertTrue(StringUtils.isAlphaSpace("ham kso")); 
     assertFalse(StringUtils.isAlphaSpace("1")); 
     assertFalse(StringUtils.isAlphaSpace("hkHKHik6iUGHKJgU7tUJgKJGI87GIkug")); 
     assertFalse(StringUtils.isAlphaSpace("_")); 
     assertFalse(StringUtils.isAlphaSpace("hkHKHik*khbkuh")); 
 }
@Test
public void testIsNumericSpace8967() { 
     assertFalse(StringUtils.isNumericSpace(null)); 
     assertTrue(StringUtils.isNumericSpace("")); 
     assertTrue(StringUtils.isNumericSpace(" ")); 
     assertFalse(StringUtils.isNumericSpace("a")); 
     assertFalse(StringUtils.isNumericSpace("A")); 
     assertFalse(StringUtils.isNumericSpace("kgKgKgKgkgkGkjkjlJlOKLgHdGdHgl")); 
     assertFalse(StringUtils.isNumericSpace("ham kso")); 
     assertTrue(StringUtils.isNumericSpace("1")); 
     assertTrue(StringUtils.isNumericSpace("1000")); 
     assertFalse(StringUtils.isNumericSpace("2.3")); 
     assertTrue(StringUtils.isNumericSpace("10 00")); 
     assertFalse(StringUtils.isNumericSpace("hkHKHik6iUGHKJgU7tUJgKJGI87GIkug")); 
     assertFalse(StringUtils.isNumericSpace("_")); 
     assertFalse(StringUtils.isNumericSpace("hkHKHik*khbkuh")); 
 }
@Test
public void testIsAlphanumeric9275() { 
     assertFalse(StringUtils.isAlphanumeric(null)); 
     assertFalse(StringUtils.isAlphanumeric("")); 
     assertFalse(StringUtils.isAlphanumeric(" ")); 
     assertTrue(StringUtils.isAlphanumeric("a")); 
     assertTrue(StringUtils.isAlphanumeric("A")); 
     assertTrue(StringUtils.isAlphanumeric("kgKgKgKgkgkGkjkjlJlOKLgHdGdHgl")); 
     assertFalse(StringUtils.isAlphanumeric("ham kso")); 
     assertTrue(StringUtils.isAlphanumeric("1")); 
     assertTrue(StringUtils.isAlphanumeric("hkHKHik6iUGHKJgU7tUJgKJGI87GIkug")); 
     assertFalse(StringUtils.isAlphanumeric("_")); 
     assertFalse(StringUtils.isAlphanumeric("hkHKHik*khbkuh")); 
 }
    

    

    

    

    

    
  
    

    

}
