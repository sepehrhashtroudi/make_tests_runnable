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
public void testIsAlphas461() { 
     assertFalse(StringUtils.isAlpha(null)); 
     assertFalse(StringUtils.isAlpha("")); 
     assertFalse(StringUtils.isAlpha(" ")); 
     assertTrue(StringUtils.isAlpha("a")); 
     assertTrue(StringUtils.isAlpha("A")); 
     assertTrue(StringUtils.isAlpha("kgKgKgKgkgkGkjkjlJlOKLgHdGdHgl")); 
     assertFalse(StringUtils.isAlpha("ham kso")); 
     assertTrue(StringUtils.isAlpha("1")); 
     assertTrue(StringUtils.isAlpha("hkHKHik6iUGHKJgU7tUJgKJGI87GIkug")); 
     assertFalse(StringUtils.isAlpha("_")); 
     assertFalse(StringUtils.isAlpha("hkHKHik*khbkuh")); 
 }
@Test
public void testIsAsciiPrintable462() { 
     assertFalse(StringUtils.isAsciiPrintable(null)); 
     assertTrue(StringUtils.isAsciiPrintable("")); 
     assertTrue(StringUtils.isAsciiPrintable(" ")); 
     assertTrue(StringUtils.isAsciiPrintable("\t \n \t")); 
     assertFalse(StringUtils.isAsciiPrintable("\t aa\n \t")); 
     assertTrue(StringUtils.isAsciiPrintable(" ")); 
     assertFalse(StringUtils.isAsciiPrintable(" a ")); 
     assertFalse(StringUtils.isAsciiPrintable("a  ")); 
     assertFalse(StringUtils.isAsciiPrintable("  a")); 
     assertFalse(StringUtils.isAsciiPrintable("aba")); 
     assertTrue(StringUtils.isAsciiPrintable(StringUtilsTest.WHITESPACE)); 
     assertFalse(StringUtils.isAsciiPrintable(StringUtilsTest.NON_WHITESPACE)); 
 }
@Test
public void testIsAsciiPrintable463() { 
     assertFalse(StringUtils.isAsciiPrintable(null)); 
     assertTrue(StringUtils.isAsciiPrintable("")); 
     assertTrue(StringUtils.isAsciiPrintable(" ")); 
     assertTrue(StringUtils.isAsciiPrintable("a")); 
     assertTrue(StringUtils.isAsciiPrintable("A")); 
     assertTrue(StringUtils.isAsciiPrintable("kgKgKgKgkgkGkjkjlJlOKLgHdGdHgl")); 
     assertTrue(StringUtils.isAsciiPrintable("ham kso")); 
     assertFalse(StringUtils.isAsciiPrintable("1")); 
     assertFalse(StringUtils.isAsciiPrintable("hkHKHik6iUGHKJgU7tUJgKJGI87GIkug")); 
     assertFalse(StringUtils.isAsciiPrintable("_")); 
     assertFalse(StringUtils.isAsciiPrintable("hkHKHik*khbkuh")); 
 }
    

    

    

    

    

    
  
    

    

}
