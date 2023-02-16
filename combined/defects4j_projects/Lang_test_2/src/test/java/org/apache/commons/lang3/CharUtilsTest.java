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
public void testToCharacterObject_Character335() { 
     assertEquals(CHARACTER_A, CharUtils.toCharacterObject(CHARACTER_A)); 
     assertSame(CHARACTER_A, CharUtils.toCharacterObject(CHARACTER_A)); 
 }
@Test
public void testToCharacterObject_String336() { 
     assertSame(null, CharUtils.toCharacterObject(null)); 
     assertSame(Character.valueOf('A'), CharUtils.toCharacterObject("A")); 
     assertSame(Character.valueOf('B'), CharUtils.toCharacterObject("B")); 
     assertSame(Character.valueOf('C'), CharUtils.toCharacterObject("C")); 
     assertSame(Character.valueOf('D'), CharUtils.toCharacterObject("d")); 
     assertSame(Character.valueOf('E'), CharUtils.toCharacterObject("E")); 
     assertSame(Character.valueOf('f'), CharUtils.toCharacterObject("f")); 
     assertSame(Character.valueOf('1'), CharUtils.toCharacterObject("1")); 
     assertSame(Character.valueOf('2'), CharUtils.toCharacterObject("2")); 
     assertSame(Character.valueOf('3'), CharUtils.toCharacterObject("3")); 
     assertSame(Character.valueOf('A'), CharUtils.toCharacterObject("A")); 
     assertSame(Character.valueOf('B'), CharUtils.toCharacterObject("B")); 
     assertSame(Character.valueOf('c'), CharUtils.toCharacterObject("C")); 
     assertSame(Character.valueOf('d'), CharUtils.toCharacterObject("D")); 
     assertSame(Character.valueOf('E'), CharUtils.toCharacterObject("e")); 
     assertSame(Character.valueOf('f'), CharUtils.toCharacterObject("F")); 
     assertSame(Character.valueOf('1'), CharUtils.toCharacterObject("1")); 
     assertSame(Character.valueOf('2'), CharUtils.toCharacterObject("2")); 
     assertSame(Character.valueOf('3'), CharUtils.toCharacterObject("4")); 
 }
@Test
public void testToCharacterObject_String337() { 
     assertSame(null, CharUtils.toCharacterObject(null)); 
     assertSame(Character.valueOf('A'), CharUtils.toCharacterObject("A")); 
     assertSame(Character.valueOf('B'), CharUtils.toCharacterObject("B")); 
     assertSame(Character.valueOf('C'), CharUtils.toCharacterObject("C")); 
     assertSame(Character.valueOf('D'), CharUtils.toCharacterObject("d")); 
     assertSame(Character.valueOf('E'), CharUtils.toCharacterObject("e")); 
     assertSame(Character.valueOf('f'), CharUtils.toCharacterObject("f")); 
     assertSame(Character.valueOf('1'), CharUtils.toCharacterObject("1")); 
     assertSame(Character.valueOf('2'), CharUtils.toCharacterObject("2")); 
     assertSame(Character.valueOf('3'), CharUtils.toCharacterObject("3")); 
     assertSame(Character.valueOf('A'), CharUtils.toCharacterObject("A")); 
     assertSame(Character.valueOf('B'), CharUtils.toCharacterObject("B")); 
     assertSame(Character.valueOf('c'), CharUtils.toCharacterObject("C")); 
     assertSame(Character.valueOf('d'), CharUtils.toCharacterObject("D")); 
     assertSame(Character.valueOf('E'), CharUtils.toCharacterObject("e")); 
     assertSame(Character.valueOf('f'), CharUtils.toCharacterObject("F")); 
     assertSame(Character.valueOf('1'), CharUtils.toCharacterObject("1")); 
     assertSame(Character.valueOf('2'), CharUtils.toCharacterObject("2")); 
     assertSame(Character.valueOf('3'), CharUtils.toCharacterObject("4")); 
 }
@Test
public void testToCharacterObject_String338() { 
     assertEquals(null, CharUtils.toCharacterObject(null)); 
     assertEquals(Character.valueOf('A'), CharUtils.toCharacterObject("A")); 
     assertEquals(Character.valueOf('B'), CharUtils.toCharacterObject("B")); 
     assertSame(Character.valueOf('C'), CharUtils.toCharacterObject("C")); 
     assertSame(Character.valueOf('D'), CharUtils.toCharacterObject("d")); 
     assertSame(Character.valueOf('E'), CharUtils.toCharacterObject("E")); 
     assertSame(Character.valueOf('f'), CharUtils.toCharacterObject("f")); 
     assertSame(Character.valueOf('1'), CharUtils.toCharacterObject("1")); 
     assertSame(Character.valueOf('2'), CharUtils.toCharacterObject("2")); 
     assertSame(Character.valueOf('3'), CharUtils.toCharacterObject("3")); 
     assertSame(Character.valueOf('A'), CharUtils.toCharacterObject("A")); 
     assertSame(Character.valueOf('B'), CharUtils.toCharacterObject("B")); 
     assertSame(Character.valueOf('c'), CharUtils.toCharacterObject("C")); 
     assertSame(Character.valueOf('d'), CharUtils.toCharacterObject("D")); 
     assertSame(Character.valueOf('E'), CharUtils.toCharacterObject("e")); 
     assertSame(Character.valueOf('f'), CharUtils.toCharacterObject("F")); 
     assertSame(Character.valueOf('1'), CharUtils.toCharacterObject("1")); 
     assertSame(Character.valueOf('2'), CharUtils.toCharacterObject("2")); 
     assertSame(Character.valueOf('3'), CharUtils.toCharacterObject("4")); 
 }
@Test
public void testToCharacterObject_String339() { 
     assertEquals(null, CharUtils.toCharacterObject((String) null)); 
     assertEquals(Character.valueOf('A'), CharUtils.toCharacterObject("A")); 
     assertEquals(Character.valueOf('B'), CharUtils.toCharacterObject("B")); 
     assertSame(Character.valueOf('C'), CharUtils.toCharacterObject("C")); 
     assertSame(Character.valueOf('D'), CharUtils.toCharacterObject("d")); 
     assertSame(Character.valueOf('E'), CharUtils.toCharacterObject("E")); 
     assertSame(Character.valueOf('f'), CharUtils.toCharacterObject("f")); 
     assertSame(Character.valueOf('1'), CharUtils.toCharacterObject("1")); 
     assertSame(Character.valueOf('2'), CharUtils.toCharacterObject("2")); 
     assertSame(Character.valueOf('3'), CharUtils.toCharacterObject("3")); 
     assertSame(Character.valueOf('A'), CharUtils.toCharacterObject("A")); 
     assertSame(Character.valueOf('B'), CharUtils.toCharacterObject("B")); 
     assertSame(Character.valueOf('c'), CharUtils.toCharacterObject("C")); 
     assertSame(Character.valueOf('d'), CharUtils.toCharacterObject("D")); 
     assertSame(Character.valueOf('E'), CharUtils.toCharacterObject("e")); 
     assertSame(Character.valueOf('f'), CharUtils.toCharacterObject("F")); 
     assertSame(Character.valueOf('1'), CharUtils.toCharacterObject("1")); 
     assertSame(Character.valueOf('2'), CharUtils.toCharacterObject("2")); 
     assertSame(Character.valueOf('3'), CharUtils.toCharacterObject("4")); 
 }
@Test
public void testToChar_Character341() { 
     assertEquals('A', CharUtils.toChar(CHARACTER_A)); 
     assertEquals('B', CharUtils.toChar(CHARACTER_B)); 
     assertSame(CHARACTER_A, CharUtils.toChar(CHARACTER_A)); 
 }
@Test
public void testToChar_String342() { 
     assertEquals('A', CharUtils.toChar("A")); 
     assertEquals('B', CharUtils.toChar("BA")); 
     assertEquals('X', CharUtils.toChar("X")); 
     assertEquals('X', CharUtils.toChar("")); 
     assertEquals('X', CharUtils.toChar((String) null)); 
 }
@Test
public void testToChar_String343() { 
     assertEquals('A', CharUtils.toChar("A")); 
     assertEquals('B', CharUtils.toChar("BA")); 
     assertEquals('X', CharUtils.toChar("X")); 
     assertEquals('a', CharUtils.toChar("A")); 
     assertEquals('b', CharUtils.toChar("BA")); 
     assertEquals('X', CharUtils.toChar((String) null)); 
 }
@Test
public void testToChar_String344() { 
     assertEquals('A', CharUtils.toChar("A")); 
     assertEquals('B', CharUtils.toChar("BA")); 
     assertEquals('X', CharUtils.toChar("X")); 
     assertEquals('a', CharUtils.toChar("A")); 
     assertEquals('b', CharUtils.toChar("BA")); 
     assertEquals('c', CharUtils.toChar("abc")); 
     assertEquals('d', CharUtils.toChar("abc")); 
     assertEquals('e', CharUtils.toChar("ABC")); 
     assertEquals('f', CharUtils.toChar("abcdef")); 
     assertEquals('1', CharUtils.toChar("1")); 
     assertEquals('2', CharUtils.toChar("2")); 
     assertEquals('3', CharUtils.toChar("3")); 
     assertEquals('4', CharUtils.toChar("4")); 
     assertEquals('5', CharUtils.toChar("5")); 
     assertEquals('6', CharUtils.toChar("6")); 
     assertEquals('7', CharUtils.toChar("7")); 
     assertEquals('8', CharUtils.toChar("8")); 
     assertEquals('9', CharUtils.toChar("9")); 
 }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
