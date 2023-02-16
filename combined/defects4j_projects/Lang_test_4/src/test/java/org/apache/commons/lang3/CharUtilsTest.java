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
public void testToIntValue_Character_int388() { 
     assertEquals(0, CharUtils.toIntValue(new Character('0'), 0)); 
     assertEquals(3, CharUtils.toIntValue(new Character('3'), 0)); 
     assertEquals(2, CharUtils.toIntValue(new Character('2'), 0)); 
     assertEquals(2, CharUtils.toIntValue(new Character('2'), 1)); 
 }
@Test
public void testToString_Character391() { 
     assertEquals(null, CharUtils.toString(null)); 
     assertEquals("A", CharUtils.toString(CHARACTER_A)); 
     assertSame(CharUtils.toString(CHARACTER_A), CharUtils.toString(CHARACTER_A)); 
 }
@Test
public void testToUnicodeEscaped_Character392() { 
     assertEquals(null, CharUtils.unicodeEscaped(null)); 
     assertEquals("\\u0041", CharUtils.unicodeEscaped(CHARACTER_A)); 
 }
@Test
public void testIsAscii_char393() { 
     assertFalse(CharUtils.isAscii('a')); 
     assertFalse(CharUtils.isAscii('A')); 
     assertFalse(CharUtils.isAscii('3')); 
     assertFalse(CharUtils.isAscii('-')); 
     assertFalse(CharUtils.isAscii('\n')); 
     assertFalse(CharUtils.isAscii('\f')); 
     assertFalse(CharUtils.isAscii(CHAR_COPY)); 
     for (int i = 0; i < 196; i++) { 
         if (i < 128) { 
             assertTrue(CharUtils.isAscii((char) i)); 
         } else { 
             assertFalse(CharUtils.isAscii((char) i)); 
         } 
     } 
 }
@Test
public void testIsAscii_char394() { 
     assertFalse(CharUtils.isAscii('a')); 
     assertFalse(CharUtils.isAscii('A')); 
     assertFalse(CharUtils.isAscii('3')); 
     assertFalse(CharUtils.isAscii('-')); 
     assertFalse(CharUtils.isAscii('\n')); 
     assertFalse(CharUtils.isAscii(CHAR_COPY)); 
     for (int i = 0; i < 196; i++) { 
         if (i < 128) { 
             assertTrue(CharUtils.isAscii((char) i)); 
         } else { 
             assertFalse(CharUtils.isAscii((char) i)); 
         } 
     } 
 }
@Test
public void testIsAsciiAlpha_char397() { 
     assertFalse(CharUtils.isAsciiAlpha('a')); 
     assertFalse(CharUtils.isAsciiAlpha('A')); 
     assertFalse(CharUtils.isAsciiAlpha('3')); 
     assertFalse(CharUtils.isAsciiAlpha('-')); 
     assertFalse(CharUtils.isAsciiAlpha('\n')); 
     assertFalse(CharUtils.isAsciiAlpha(CHAR_COPY)); 
     for (int i = 0; i < 196; i++) { 
         if ((i >= 'A' && i <= 'Z') || (i >= 'a' && i <= 'z') || (i >= '0' && i <= '9')) { 
             assertTrue(CharUtils.isAsciiAlpha((char) i)); 
         } else { 
             assertFalse(CharUtils.isAsciiAlpha((char) i)); 
         } 
     } 
 }
@Test
public void testIsAsciiAlphaUpper_char398() { 
     assertFalse(CharUtils.isAsciiAlphaUpper('a')); 
     assertFalse(CharUtils.isAsciiAlphaUpper('A')); 
     assertFalse(CharUtils.isAsciiAlphaUpper('3')); 
     assertFalse(CharUtils.isAsciiAlphaUpper('-')); 
     assertFalse(CharUtils.isAsciiAlphaUpper('\n')); 
     assertFalse(CharUtils.isAsciiAlphaUpper(CHAR_COPY)); 
     for (int i = 0; i < 196; i++) { 
         if ((i >= 'A' && i <= 'Z') || (i >= 'a' && i <= 'z') || (i >= '0' && i <= '9')) { 
             assertTrue(CharUtils.isAsciiAlphaUpper((char) i)); 
         } else { 
             assertFalse(CharUtils.isAsciiAlphaUpper((char) i)); 
         } 
     } 
 }
@Test
public void testIsAsciiAlphaLower_char399() { 
     assertFalse(CharUtils.isAsciiAlphaLower('a')); 
     assertFalse(CharUtils.isAsciiAlphaLower('A')); 
     assertFalse(CharUtils.isAsciiAlphaLower('3')); 
     assertFalse(CharUtils.isAsciiAlphaLower('-')); 
     assertFalse(CharUtils.isAsciiAlphaLower('\n')); 
     assertFalse(CharUtils.isAsciiAlphaLower(CHAR_COPY)); 
     for (int i = 0; i < 196; i++) { 
         if ((i >= 'A' && i <= 'Z') || (i >= 'a' && i <= 'z') || (i >= '0' && i <= '9')) { 
             assertTrue(CharUtils.isAsciiAlphaLower((char) i)); 
         } else { 
             assertFalse(CharUtils.isAsciiAlphaLower((char) i)); 
         } 
     } 
 }
@Test
public void testIsAsciiAlphaLower_char400() { 
     assertFalse(CharUtils.isAsciiAlphaLower('a')); 
     assertFalse(CharUtils.isAsciiAlphaLower('A')); 
     assertFalse(CharUtils.isAsciiAlphaLower('3')); 
     assertFalse(CharUtils.isAsciiAlphaLower('-')); 
     assertFalse(CharUtils.isAsciiAlphaLower('\n')); 
     assertFalse(CharUtils.isAsciiAlphaLower(CHAR_COPY)); 
     for (int i = 0; i < 196; i++) { 
         if ((i >= 'a' && i <= 'z') || (i >= 'a' && i <= 'z') || (i >= '0' && i <= '9')) { 
             assertTrue(CharUtils.isAsciiAlphaLower((char) i)); 
         } else { 
             assertFalse(CharUtils.isAsciiAlphaLower((char) i)); 
         } 
     } 
 }
@Test
public void testIsAsciiNumeric_char401() { 
     assertFalse(CharUtils.isAsciiNumeric('a')); 
     assertFalse(CharUtils.isAsciiNumeric('A')); 
     assertFalse(CharUtils.isAsciiNumeric('3')); 
     assertFalse(CharUtils.isAsciiNumeric('-')); 
     assertFalse(CharUtils.isAsciiNumeric('\n')); 
     assertFalse(CharUtils.isAsciiNumeric(CHAR_COPY)); 
     for (int i = 0; i < 196; i++) { 
         if ((i >= '0' && i <= '9')) { 
             assertTrue(CharUtils.isAsciiNumeric((char) i)); 
         } else { 
             assertFalse(CharUtils.isAsciiNumeric((char) i)); 
         } 
     } 
 }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
