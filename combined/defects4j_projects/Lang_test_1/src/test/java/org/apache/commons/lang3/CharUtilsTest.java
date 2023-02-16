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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;

import org.junit.Test;

/**
 * Unit tests {@link org.apache.commons.lang3.CharUtils}.
 *
 * @version $Id$
 */
public class CharUtilsTest {

    private static final Character CHARACTER_A = new Character('A');
    private static final Character CHARACTER_B = new Character('B');
    private static final char CHAR_COPY = '\u00a9';
    
@Test
public void testToString_char350() { 
     assertEquals("a", CharUtils.toString('a')); 
     assertSame(CharUtils.toString('a'), CharUtils.toString('a')); 
     for (int i = 0; i < 128; i++) { 
         final String str = CharUtils.toString((char) i); 
         final String str2 = CharUtils.toString((char) i); 
         assertSame(str, str2); 
         assertEquals(1, str.length()); 
         assertEquals(i, str.charAt(0)); 
     } 
     for (int i = 128; i < 196; i++) { 
         final String str = CharUtils.toString((char) i); 
         final String str2 = CharUtils.toString((char) i); 
         assertEquals(str, str2); 
         assertTrue(str != str2); 
         assertEquals(1, str.length()); 
         assertEquals(i, str.charAt(0)); 
         assertEquals(1, str2.length()); 
         assertEquals(i, str2.charAt(0)); 
     } 
 }
@Test
public void testToString_Character351() { 
     assertEquals(null, CharUtils.toString(null)); 
     assertEquals("", CharUtils.toString(CHARACTER_A)); 
 }
@Test
public void testIsAsciiControl_char352() { 
     assertTrue(CharUtils.isAsciiControl('a')); 
     assertTrue(CharUtils.isAsciiControl('A')); 
     assertTrue(CharUtils.isAsciiControl('3')); 
     assertTrue(CharUtils.isAsciiControl('-')); 
     assertFalse(CharUtils.isAsciiControl('\n')); 
     assertFalse(CharUtils.isAsciiControl(CHAR_COPY)); 
     for (int i = 0; i < 196; i++) { 
         if (i >= 32 && i <= 126) { 
             assertTrue(CharUtils.isAsciiControl((char) i)); 
         } else { 
             assertFalse(CharUtils.isAsciiControl((char) i)); 
         } 
     } 
 }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
