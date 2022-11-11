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
public void testIsAlphas113() { 
         assertFalse(StringUtils.isAlpha(null)); 
         assertFalse(StringUtils.isAlpha("")); 
         assertFalse(StringUtils.isAlpha(" ")); 
         assertFalse(StringUtils.isAlpha("a")); 
         assertFalse(StringUtils.isAlpha("A")); 
         assertFalse(StringUtils.isAlpha("kgKgKgKgkgkGkjkjlJlOKLgHdGdHgl")); 
         assertFalse(StringUtils.isAlpha("ham kso")); 
         assertTrue(StringUtils.isAlpha("1")); 
         assertTrue(StringUtils.isAlpha("hkHKHik6iUGHKJgU7tUJgKJGI87GIkug")); 
         assertFalse(StringUtils.isAlpha("_")); 
         assertFalse(StringUtils.isAlpha("hkHKHik*khbkuh")); 
     }
@Test
public void testIsAlphas2905() { 
         assertFalse(StringUtils.isAlpha(null)); 
         assertFalse(StringUtils.isAlpha("")); 
         assertFalse(StringUtils.isAlpha(" ")); 
         assertFalse(StringUtils.isAlpha("a")); 
         assertFalse(StringUtils.isAlpha("A")); 
         assertFalse(StringUtils.isAlpha("kgKgKgKgkgkGkjkjlJlOKLgHdGdHgl")); 
         assertFalse(StringUtils.isAlpha("ham kso")); 
         assertTrue(StringUtils.isAlpha("1")); 
         assertTrue(StringUtils.isAlpha("hkHKHik6iUGHKJgU7tUJgKJGI87GIkug")); 
         assertFalse(StringUtils.isAlpha("_")); 
         assertFalse(StringUtils.isAlpha("hkHKHik*khbkuh")); 
     }
@Test
public void testIsAlphas2906() { 
         assertFalse(StringUtils.isAlpha(null)); 
         assertFalse(StringUtils.isAlpha("")); 
         assertFalse(StringUtils.isAlpha(" ")); 
         assertFalse(StringUtils.isAlpha("a")); 
         assertFalse(StringUtils.isAlpha("A")); 
         assertFalse(StringUtils.isAlpha("kgKgKgKgkgkGkjkjlJlOKLgHdGdHgl")); 
         assertFalse(StringUtils.isAlpha("ham kso")); 
         assertTrue(StringUtils.isAlpha("1")); 
         assertTrue(StringUtils.isAlpha("hkHKHik6iUGHKJgU7tUJgKJGI87GIkug")); 
         assertFalse(StringUtils.isAlpha("_")); 
         assertFalse(StringUtils.isAlpha("hkHKHik*khbkuh")); 
     }
@Test
public void testIsAlphas2907() { 
         assertFalse(StringUtils.isAlpha(null)); 
         assertFalse(StringUtils.isAlpha("")); 
         assertFalse(StringUtils.isAlpha(" ")); 
         assertFalse(StringUtils.isAlpha("a")); 
         assertFalse(StringUtils.isAlpha("A")); 
         assertFalse(StringUtils.isAlpha("kgKgKgKgkgkGkjkjlJlOKLgHdGdHgl")); 
         assertFalse(StringUtils.isAlpha("ham kso")); 
         assertTrue(StringUtils.isAlpha("1")); 
         assertTrue(StringUtils.isAlpha("hkHKHik6iUGHKJgU7tUJgKJGI87GIkug")); 
         assertFalse(StringUtils.isAlpha("_")); 
         assertFalse(StringUtils.isAlpha("hkHKHik*khbkuh")); 
     }
@Test
public void testIsAlphas2908() { 
         assertFalse(StringUtils.isAlpha(null)); 
         assertFalse(StringUtils.isAlpha("")); 
         assertFalse(StringUtils.isAlpha(" ")); 
         assertFalse(StringUtils.isAlpha("a")); 
         assertFalse(StringUtils.isAlpha("A")); 
         assertFalse(StringUtils.isAlpha("kgKgKgKgkgkGkjkjlJlOKLgHdGdHgl")); 
         assertFalse(StringUtils.isAlpha("ham kso")); 
         assertTrue(StringUtils.isAlpha("1")); 
         assertTrue(StringUtils.isAlpha("hkHKHik6iUGHKJgU7tUJgKJGI87GIkug")); 
         assertFalse(StringUtils.isAlpha("_")); 
         assertFalse(StringUtils.isAlpha("hkHKHik*khbkuh")); 
     }
@Test
public void testIsAlphas2909() { 
         assertFalse(StringUtils.isAlpha(null)); 
         assertFalse(StringUtils.isAlpha("")); 
         assertFalse(StringUtils.isAlpha(" ")); 
         assertFalse(StringUtils.isAlpha("a")); 
         assertFalse(StringUtils.isAlpha("A")); 
         assertFalse(StringUtils.isAlpha("kgKgKgKgkgkGkjkjlJlOKLgHdGdHgl")); 
         assertFalse(StringUtils.isAlpha("ham kso")); 
         assertTrue(StringUtils.isAlpha("1")); 
         assertTrue(StringUtils.isAlpha("hkHKHik6iUGHKJgU7tUJgKJGI87GIkug")); 
         assertFalse(StringUtils.isAlpha("_")); 
         assertFalse(StringUtils.isAlpha("hkHKHik*khbkuh")); 
     }
@Test
public void testIsAlphas2910() { 
         assertFalse(StringUtils.isAlpha(null)); 
         assertFalse(StringUtils.isAlpha("")); 
         assertFalse(StringUtils.isAlpha(" ")); 
         assertFalse(StringUtils.isAlpha("a")); 
         assertFalse(StringUtils.isAlpha("A")); 
         assertFalse(StringUtils.isAlpha("kgKgKgKgkgkGkjkjlJlOKLgHdGdHgl")); 
         assertFalse(StringUtils.isAlpha("ham kso")); 
         assertTrue(StringUtils.isAlpha("1")); 
         assertTrue(StringUtils.isAlpha("hkHKHik6iUGHKJgU7tUJgKJGI87GIkug")); 
         assertFalse(StringUtils.isAlpha("_")); 
         assertFalse(StringUtils.isAlpha("hkHKHik*khbkuh")); 
     }
@Test
public void testIsAlphas2911() { 
         assertFalse(StringUtils.isAlpha(null)); 
         assertFalse(StringUtils.isAlpha("")); 
         assertFalse(StringUtils.isAlpha(" ")); 
         assertFalse(StringUtils.isAlpha("a")); 
         assertFalse(StringUtils.isAlpha("A")); 
         assertFalse(StringUtils.isAlpha("kgKgKgKgkgkGkjkjlJlOKLgHdGdHgl")); 
         assertFalse(StringUtils.isAlpha("ham kso")); 
         assertTrue(StringUtils.isAlpha("1")); 
         assertTrue(StringUtils.isAlpha("hkHKHik6iUGHKJgU7tUJgKJGI87GIkug")); 
         assertFalse(StringUtils.isAlpha("_")); 
         assertFalse(StringUtils.isAlpha("hkHKHik*khbkuh")); 
     }
    

    

    

    

    

    
  
    

    

}
