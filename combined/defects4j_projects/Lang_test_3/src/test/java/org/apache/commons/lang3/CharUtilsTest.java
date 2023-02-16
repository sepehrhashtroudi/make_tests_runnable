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
public void testToIntValue_Character_int413() { 
     assertEquals(0, CharUtils.toIntValue(new Character('0'), -1)); 
     assertEquals(3, CharUtils.toIntValue(new Character('3'), -1)); 
     assertEquals(-1, CharUtils.toIntValue(new Character('A'), -1)); 
     assertEquals(-1, CharUtils.toIntValue(null, -1)); 
 }
@Test
public void testToIntValue_Character414() { 
     assertEquals(0, CharUtils.toIntValue(new Character('0'))); 
     assertEquals(3, CharUtils.toIntValue(new Character('3'), -1)); 
     assertEquals(-1, CharUtils.toIntValue(new Character('A'), -1)); 
     assertEquals(-1, CharUtils.toIntValue(null, -1)); 
 }
@Test
public void testToUnicodeEscaped_char415() { 
     assertEquals("\\u0041", CharUtils.unicodeEscaped('A')); 
     for (int i = 0; i < 196; i++) { 
         final String str = CharUtils.unicodeEscaped((char) i); 
         assertEquals(6, str.length()); 
         final int val = Integer.parseInt(str.substring(2), 16); 
         assertEquals(i, val); 
     } 
     assertEquals("\\u0999", CharUtils.unicodeEscaped((char) 0x999)); 
     assertEquals("\\u1001", CharUtils.unicodeEscaped((char) 0x1001)); 
 }
@Test
public void testToUnicodeEscaped_Character418() { 
     assertEquals(null, CharUtils.unicodeEscaped(null)); 
     assertEquals("A", CharUtils.unicodeEscaped(CHARACTER_A)); 
     assertSame(CharUtils.unicodeEscaped(CHARACTER_A), CharUtils.unicodeEscaped(CHARACTER_A)); 
 }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
