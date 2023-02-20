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
public void testConstructor819() { 
     assertNotNull(new CharUtils()); 
     final Constructor<?>[] cons = CharUtils.class.getDeclaredConstructors(); 
     assertEquals(1, cons.length); 
     assertTrue(Modifier.isPublic(cons[0].getModifiers())); 
     assertTrue(Modifier.isPublic(BooleanUtils.class.getModifiers())); 
     assertFalse(Modifier.isFinal(BooleanUtils.class.getModifiers())); 
 } 
@SuppressWarnings("deprecation")
@Test
public void testToCharacterObject_char820() { 
     assertEquals(new Character('a'), CharUtils.toCharacterObject('a')); 
     assertSame(CharUtils.toCharacterObject('a'), CharUtils.toCharacterObject('a')); 
     for (int i = 0; i < 128; i++) { 
         final Character ch = CharUtils.toCharacterObject((char) i); 
         final Character ch2 = CharUtils.toCharacterObject((char) i); 
         assertSame(ch, ch2); 
         assertEquals(i, ch.charValue()); 
     } 
     for (int i = 128; i < 196; i++) { 
         final Character ch = CharUtils.toCharacterObject((char) i); 
         final Character ch2 = CharUtils.toCharacterObject((char) i); 
         assertEquals(ch, ch2); 
         assertTrue(ch != ch2); 
         assertEquals(i, ch.charValue()); 
         assertEquals(i, ch2.charValue()); 
     } 
     assertSame(CharUtils.toCharacterObject("a"), CharUtils.toCharacterObject('a')); 
 }
@Test
public void testToCharacterObject_String821() { 
     assertEquals(null, CharUtils.toCharacterObject(null)); 
     assertEquals(null, CharUtils.toCharacterObject("")); 
     assertEquals(new Character('a'), CharUtils.toCharacterObject("a")); 
     assertEquals(new Character('a'), CharUtils.toCharacterObject("abc")); 
     assertSame(CharUtils.toCharacterObject("a"), CharUtils.toCharacterObject("a")); 
 }
@Test
public void testToChar_Character822() { 
     assertEquals('A', CharUtils.toChar(CHARACTER_A)); 
     assertEquals('B', CharUtils.toChar(CHARACTER_B)); 
     try { 
         CharUtils.toChar((Character) null); 
     } catch (final IllegalArgumentException ex) { 
     } 
 }
@Test
public void testToChar_Character_char823() { 
     assertEquals('A', CharUtils.toChar(CHARACTER_A, 'X')); 
     assertEquals('B', CharUtils.toChar(CHARACTER_B, 'X')); 
     assertEquals('X', CharUtils.toChar((Character) null, 'X')); 
 }
@Test
public void testToChar_String824() { 
     assertEquals('A', CharUtils.toChar("A")); 
     assertEquals('B', CharUtils.toChar("BA")); 
     try { 
         CharUtils.toChar((String) null); 
     } catch (final IllegalArgumentException ex) { 
     } 
     try { 
         CharUtils.toChar(""); 
     } catch (final IllegalArgumentException ex) { 
     } 
 }
@Test
public void testToChar_String_char825() { 
     assertEquals('A', CharUtils.toChar("A", 'X')); 
     assertEquals('B', CharUtils.toChar("BA", 'X')); 
     assertEquals('X', CharUtils.toChar("", 'X')); 
     assertEquals('X', CharUtils.toChar((String) null, 'X')); 
 }
@Test
public void testToIntValue_Character826() { 
     assertEquals(0, CharUtils.toIntValue(new Character('0'))); 
     assertEquals(3, CharUtils.toIntValue(new Character('3'))); 
     try { 
         CharUtils.toIntValue(null); 
     } catch (final IllegalArgumentException ex) { 
     } 
     try { 
         CharUtils.toIntValue(CHARACTER_A); 
     } catch (final IllegalArgumentException ex) { 
     } 
 }
@Test
public void testToString_Character827() { 
     assertEquals(null, CharUtils.toString(null)); 
     assertEquals("A", CharUtils.toString(CHARACTER_A)); 
     assertSame(CharUtils.toString(CHARACTER_A), CharUtils.toString(CHARACTER_A)); 
 }
@Test
public void testToUnicodeEscaped_Character828() { 
     assertEquals(null, CharUtils.unicodeEscaped(null)); 
     assertEquals("\\u0041", CharUtils.unicodeEscaped(CHARACTER_A)); 
 }
@Test
public void testIsAsciiControl_char829() { 
     assertFalse(CharUtils.isAsciiControl('a')); 
     assertFalse(CharUtils.isAsciiControl('A')); 
     assertFalse(CharUtils.isAsciiControl('3')); 
     assertFalse(CharUtils.isAsciiControl('-')); 
     assertTrue(CharUtils.isAsciiControl('\n')); 
     assertFalse(CharUtils.isAsciiControl(CHAR_COPY)); 
     for (int i = 0; i < 196; i++) { 
         if (i < 32 || i == 127) { 
             assertTrue(CharUtils.isAsciiControl((char) i)); 
         } else { 
             assertFalse(CharUtils.isAsciiControl((char) i)); 
         } 
     } 
 }
@Test
public void testIsAsciiAlphanumeric_char830() { 
     assertTrue(CharUtils.isAsciiAlphanumeric('a')); 
     assertTrue(CharUtils.isAsciiAlphanumeric('A')); 
     assertTrue(CharUtils.isAsciiAlphanumeric('3')); 
     assertFalse(CharUtils.isAsciiAlphanumeric('-')); 
     assertFalse(CharUtils.isAsciiAlphanumeric('\n')); 
     assertFalse(CharUtils.isAsciiAlphanumeric(CHAR_COPY)); 
     for (int i = 0; i < 196; i++) { 
         if ((i >= 'A' && i <= 'Z') || (i >= 'a' && i <= 'z') || (i >= '0' && i <= '9')) { 
             assertTrue(CharUtils.isAsciiAlphanumeric((char) i)); 
         } else { 
             assertFalse(CharUtils.isAsciiAlphanumeric((char) i)); 
         } 
     } 
 }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
