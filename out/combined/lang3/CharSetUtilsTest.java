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
import static org.junit.Assert.assertTrue;

import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;

import org.junit.Test;

/**
 * Unit tests {@link org.apache.commons.lang3.CharSetUtils}.
 *
 * @version $Id$
 */
public class CharSetUtilsTest  {

    //-----------------------------------------------------------------------
@Test
public void testDelete_StringStringarray139() { 
     assertEquals(null, CharSetUtils.delete(null, (String[]) null)); 
     assertEquals(null, CharSetUtils.delete(null, new String[0])); 
     assertEquals(null, CharSetUtils.delete(null, new String[] { null })); 
     assertEquals(null, CharSetUtils.delete(null, new String[] { "el" })); 
     assertEquals("", CharSetUtils.delete("", (String[]) null)); 
     assertEquals("", CharSetUtils.delete("", new String[0])); 
     assertEquals("", CharSetUtils.delete("", new String[] { null })); 
     assertEquals("", CharSetUtils.delete("", new String[] { "a-e" })); 
     assertEquals("hello", CharSetUtils.delete("hello", (String[]) null)); 
     assertEquals("hello", CharSetUtils.delete("hello", new String[0])); 
     assertEquals("hello", CharSetUtils.delete("hello", new String[] { null })); 
     assertEquals("hello", CharSetUtils.delete("hello", new String[] { "xyz" })); 
     assertEquals("ho", CharSetUtils.delete("hello", new String[] { "el" })); 
     assertEquals("", CharSetUtils.delete("hello", new String[] { "elho" })); 
     assertEquals("hello", CharSetUtils.delete("hello", new String[] { "" })); 
     assertEquals("hello", CharSetUtils.delete("hello", "")); 
     assertEquals("", CharSetUtils.delete("hello", new String[] { "a-z" })); 
     assertEquals("", CharSetUtils.delete("----", new String[] { "-" })); 
     assertEquals("heo", CharSetUtils.delete("hello", new String[] { "l" })); 
 }
@Test
public void testDelete_StringStringarray154() { 
     assertEquals(null, CharSetUtils.delete(null, (String[]) null)); 
     assertEquals(null, CharSetUtils.delete(null, new String[0])); 
     assertEquals(null, CharSetUtils.delete(null, new String[] { null })); 
     assertEquals(null, CharSetUtils.delete(null, new String[] { "el" })); 
     assertEquals("", CharSetUtils.delete("", (String[]) null)); 
     assertEquals("", CharSetUtils.delete("", new String[0])); 
     assertEquals("", CharSetUtils.delete("", new String[] { null })); 
     assertEquals("", CharSetUtils.delete("", new String[] { "a-e" })); 
     assertEquals("hello", CharSetUtils.delete("hello", (String[]) null)); 
     assertEquals("hello", CharSetUtils.delete("hello", new String[0])); 
     assertEquals("hello", CharSetUtils.delete("hello", new String[] { null })); 
     assertEquals("hello", CharSetUtils.delete("hello", new String[] { "xyz" })); 
     assertEquals("ho", CharSetUtils.delete("hello", new String[] { "el" })); 
     assertEquals("", CharSetUtils.delete("hello", new String[] { "elho" })); 
     assertEquals("hello", CharSetUtils.delete("hello", new String[] { "" })); 
     assertEquals("hello", CharSetUtils.delete("hello", "")); 
     assertEquals("", CharSetUtils.delete("hello", new String[] { "a-z" })); 
     assertEquals("", CharSetUtils.delete("----", new String[] { "-" })); 
     assertEquals("heo", CharSetUtils.delete("hello", new String[] { "l" })); 
 }
@Test
public void testDelete_StringStringarray357() { 
     assertEquals(null, CharSetUtils.delete(null, (String[]) null)); 
     assertEquals(null, CharSetUtils.delete(null, new String[0])); 
     assertEquals(null, CharSetUtils.delete(null, new String[] { null })); 
     assertEquals(null, CharSetUtils.delete(null, new String[] { "el" })); 
     assertEquals("", CharSetUtils.delete("", (String[]) null)); 
     assertEquals("", CharSetUtils.delete("", new String[0])); 
     assertEquals("", CharSetUtils.delete("", new String[] { null })); 
     assertEquals("", CharSetUtils.delete("", new String[] { "a-e" })); 
     assertEquals("hello", CharSetUtils.delete("hello", (String[]) null)); 
     assertEquals("hello", CharSetUtils.delete("hello", new String[0])); 
     assertEquals("hello", CharSetUtils.delete("hello", new String[] { null })); 
     assertEquals("hello", CharSetUtils.delete("hello", new String[] { "xyz" })); 
     assertEquals("ho", CharSetUtils.delete("hello", new String[] { "el" })); 
     assertEquals("", CharSetUtils.delete("hello", new String[] { "elho" })); 
     assertEquals("hello", CharSetUtils.delete("hello", new String[] { "" })); 
     assertEquals("hello", CharSetUtils.delete("hello", "")); 
     assertEquals("", CharSetUtils.delete("hello", new String[] { "a-z" })); 
     assertEquals("", CharSetUtils.delete("----", new String[] { "-" })); 
     assertEquals("heo", CharSetUtils.delete("hello", new String[] { "l" })); 
 }
@Test
public void testDelete_StringStringarray360() { 
     assertEquals(null, CharSetUtils.delete(null, (String[]) null)); 
     assertEquals(null, CharSetUtils.delete(null, new String[0])); 
     assertEquals(null, CharSetUtils.delete(null, new String[] { null })); 
     assertEquals(null, CharSetUtils.delete(null, new String[] { "el" })); 
     assertEquals("", CharSetUtils.delete("", (String[]) null)); 
     assertEquals("", CharSetUtils.delete("", new String[0])); 
     assertEquals("", CharSetUtils.delete("", new String[] { null })); 
     assertEquals("", CharSetUtils.delete("", new String[] { "a-e" })); 
     assertEquals("hello", CharSetUtils.delete("hello", (String[]) null)); 
     assertEquals("hello", CharSetUtils.delete("hello", new String[0])); 
     assertEquals("hello", CharSetUtils.delete("hello", new String[] { null })); 
     assertEquals("hello", CharSetUtils.delete("hello", new String[] { "xyz" })); 
     assertEquals("ho", CharSetUtils.delete("hello", new String[] { "el" })); 
     assertEquals("", CharSetUtils.delete("hello", new String[] { "elho" })); 
     assertEquals("hello", CharSetUtils.delete("hello", new String[] { "" })); 
     assertEquals("hello", CharSetUtils.delete("hello", "")); 
     assertEquals("", CharSetUtils.delete("hello", new String[] { "a-z" })); 
     assertEquals("", CharSetUtils.delete("----", new String[] { "-" })); 
     assertEquals("heo", CharSetUtils.delete("hello", new String[] { "l" })); 
 }
@Test
public void testDelete_StringStringarray382() { 
     assertEquals(null, CharSetUtils.delete(null, (String[]) null)); 
     assertEquals(null, CharSetUtils.delete(null, new String[0])); 
     assertEquals(null, CharSetUtils.delete(null, new String[] { null })); 
     assertEquals(null, CharSetUtils.delete(null, new String[] { "el" })); 
     assertEquals("", CharSetUtils.delete("", (String[]) null)); 
     assertEquals("", CharSetUtils.delete("", new String[0])); 
     assertEquals("", CharSetUtils.delete("", new String[] { null })); 
     assertEquals("", CharSetUtils.delete("", new String[] { "a-e" })); 
     assertEquals("hello", CharSetUtils.delete("hello", (String[]) null)); 
     assertEquals("hello", CharSetUtils.delete("hello", new String[0])); 
     assertEquals("hello", CharSetUtils.delete("hello", new String[] { null })); 
     assertEquals("hello", CharSetUtils.delete("hello", new String[] { "xyz" })); 
     assertEquals("ho", CharSetUtils.delete("hello", new String[] { "el" })); 
     assertEquals("", CharSetUtils.delete("hello", new String[] { "elho" })); 
     assertEquals("hello", CharSetUtils.delete("hello", new String[] { "" })); 
     assertEquals("hello", CharSetUtils.delete("hello", "")); 
     assertEquals("", CharSetUtils.delete("hello", new String[] { "a-z" })); 
     assertEquals("", CharSetUtils.delete("----", new String[] { "-" })); 
     assertEquals("heo", CharSetUtils.delete("hello", new String[] { "l" })); 
 }
@Test
public void testDelete_StringStringarray488() { 
     assertEquals(null, CharSetUtils.delete(null, (String[]) null)); 
     assertEquals(null, CharSetUtils.delete(null, new String[0])); 
     assertEquals(null, CharSetUtils.delete(null, new String[] { null })); 
     assertEquals(null, CharSetUtils.delete(null, new String[] { "el" })); 
     assertEquals("", CharSetUtils.delete("", (String[]) null)); 
     assertEquals("", CharSetUtils.delete("", new String[0])); 
     assertEquals("", CharSetUtils.delete("", new String[] { null })); 
     assertEquals("", CharSetUtils.delete("", new String[] { "a-e" })); 
     assertEquals("hello", CharSetUtils.delete("hello", (String[]) null)); 
     assertEquals("hello", CharSetUtils.delete("hello", new String[0])); 
     assertEquals("hello", CharSetUtils.delete("hello", new String[] { null })); 
     assertEquals("hello", CharSetUtils.delete("hello", new String[] { "xyz" })); 
     assertEquals("ho", CharSetUtils.delete("hello", new String[] { "el" })); 
     assertEquals("", CharSetUtils.delete("hello", new String[] { "elho" })); 
     assertEquals("hello", CharSetUtils.delete("hello", new String[] { "" })); 
     assertEquals("hello", CharSetUtils.delete("hello", "")); 
     assertEquals("", CharSetUtils.delete("hello", new String[] { "a-z" })); 
     assertEquals("", CharSetUtils.delete("----", new String[] { "-" })); 
     assertEquals("heo", CharSetUtils.delete("hello", new String[] { "l" })); 
 }
@Test
public void testDelete_StringStringarray511() { 
     assertEquals(null, CharSetUtils.delete(null, (String[]) null)); 
     assertEquals(null, CharSetUtils.delete(null, new String[0])); 
     assertEquals(null, CharSetUtils.delete(null, new String[] { null })); 
     assertEquals(null, CharSetUtils.delete(null, new String[] { "el" })); 
     assertEquals("", CharSetUtils.delete("", (String[]) null)); 
     assertEquals("", CharSetUtils.delete("", new String[0])); 
     assertEquals("", CharSetUtils.delete("", new String[] { null })); 
     assertEquals("", CharSetUtils.delete("", new String[] { "a-e" })); 
     assertEquals("hello", CharSetUtils.delete("hello", (String[]) null)); 
     assertEquals("hello", CharSetUtils.delete("hello", new String[0])); 
     assertEquals("hello", CharSetUtils.delete("hello", new String[] { null })); 
     assertEquals("hello", CharSetUtils.delete("hello", new String[] { "xyz" })); 
     assertEquals("ho", CharSetUtils.delete("hello", new String[] { "el" })); 
     assertEquals("", CharSetUtils.delete("hello", new String[] { "elho" })); 
     assertEquals("hello", CharSetUtils.delete("hello", new String[] { "" })); 
     assertEquals("hello", CharSetUtils.delete("hello", "")); 
     assertEquals("", CharSetUtils.delete("hello", new String[] { "a-z" })); 
     assertEquals("", CharSetUtils.delete("----", new String[] { "-" })); 
     assertEquals("heo", CharSetUtils.delete("hello", new String[] { "l" })); 
 }
@Test
public void testDelete_StringStringarray600() { 
     assertEquals(null, CharSetUtils.delete(null, (String[]) null)); 
     assertEquals(null, CharSetUtils.delete(null, new String[0])); 
     assertEquals(null, CharSetUtils.delete(null, new String[] { null })); 
     assertEquals(null, CharSetUtils.delete(null, new String[] { "el" })); 
     assertEquals("", CharSetUtils.delete("", (String[]) null)); 
     assertEquals("", CharSetUtils.delete("", new String[0])); 
     assertEquals("", CharSetUtils.delete("", new String[] { null })); 
     assertEquals("", CharSetUtils.delete("", new String[] { "a-e" })); 
     assertEquals("hello", CharSetUtils.delete("hello", (String[]) null)); 
     assertEquals("hello", CharSetUtils.delete("hello", new String[0])); 
     assertEquals("hello", CharSetUtils.delete("hello", new String[] { null })); 
     assertEquals("hello", CharSetUtils.delete("hello", new String[] { "xyz" })); 
     assertEquals("ho", CharSetUtils.delete("hello", new String[] { "el" })); 
     assertEquals("", CharSetUtils.delete("hello", new String[] { "elho" })); 
     assertEquals("hello", CharSetUtils.delete("hello", new String[] { "" })); 
     assertEquals("hello", CharSetUtils.delete("hello", "")); 
     assertEquals("", CharSetUtils.delete("hello", new String[] { "a-z" })); 
     assertEquals("", CharSetUtils.delete("----", new String[] { "-" })); 
     assertEquals("heo", CharSetUtils.delete("hello", new String[] { "l" })); 
 }
@Test
public void testContainsAny_StringStringarray805() { 
     assertFalse(CharSetUtils.containsAny(null, (String[]) null)); 
     assertFalse(CharSetUtils.containsAny(null, new String[0])); 
     assertFalse(CharSetUtils.containsAny(null, new String[] { null })); 
     assertFalse(CharSetUtils.containsAny(null, new String[] { "a-e" })); 
     assertFalse(CharSetUtils.containsAny("", (String[]) null)); 
     assertFalse(CharSetUtils.containsAny("", new String[0])); 
     assertFalse(CharSetUtils.containsAny("", new String[] { null })); 
     assertFalse(CharSetUtils.containsAny("", new String[] { "a-e" })); 
     assertFalse(CharSetUtils.containsAny("hello", (String[]) null)); 
     assertFalse(CharSetUtils.containsAny("hello", new String[0])); 
     assertFalse(CharSetUtils.containsAny("hello", new String[] { null })); 
     assertTrue(CharSetUtils.containsAny("hello", new String[] { "a-e" })); 
     assertTrue(CharSetUtils.containsAny("hello", new String[] { "el" })); 
     assertFalse(CharSetUtils.containsAny("hello", new String[] { "x" })); 
     assertTrue(CharSetUtils.containsAny("hello", new String[] { "e-i" })); 
     assertTrue(CharSetUtils.containsAny("hello", new String[] { "a-z" })); 
     assertFalse(CharSetUtils.containsAny("hello", new String[] { "" })); 
 }
@Test
public void testContainsAny_StringString891() { 
     assertFalse(CharSetUtils.containsAny(null, (String) null)); 
     assertFalse(CharSetUtils.containsAny(null, "")); 
     assertFalse(CharSetUtils.containsAny("", (String) null)); 
     assertFalse(CharSetUtils.containsAny("", "")); 
     assertFalse(CharSetUtils.containsAny("", "a-e")); 
     assertFalse(CharSetUtils.containsAny("hello", (String) null)); 
     assertFalse(CharSetUtils.containsAny("hello", "")); 
     assertTrue(CharSetUtils.containsAny("hello", "a-e")); 
     assertTrue(CharSetUtils.containsAny("hello", "l-p")); 
 }
@Test
public void testDelete_StringStringarray1031() { 
     assertEquals(null, CharSetUtils.delete(null, (String[]) null)); 
     assertEquals(null, CharSetUtils.delete(null, new String[0])); 
     assertEquals(null, CharSetUtils.delete(null, new String[] { null })); 
     assertEquals(null, CharSetUtils.delete(null, new String[] { "el" })); 
     assertEquals("", CharSetUtils.delete("", (String[]) null)); 
     assertEquals("", CharSetUtils.delete("", new String[0])); 
     assertEquals("", CharSetUtils.delete("", new String[] { null })); 
     assertEquals("", CharSetUtils.delete("", new String[] { "a-e" })); 
     assertEquals("hello", CharSetUtils.delete("hello", (String[]) null)); 
     assertEquals("hello", CharSetUtils.delete("hello", new String[0])); 
     assertEquals("hello", CharSetUtils.delete("hello", new String[] { null })); 
     assertEquals("hello", CharSetUtils.delete("hello", new String[] { "xyz" })); 
     assertEquals("ho", CharSetUtils.delete("hello", new String[] { "el" })); 
     assertEquals("", CharSetUtils.delete("hello", new String[] { "elho" })); 
     assertEquals("hello", CharSetUtils.delete("hello", new String[] { "" })); 
     assertEquals("hello", CharSetUtils.delete("hello", "")); 
     assertEquals("", CharSetUtils.delete("hello", new String[] { "a-z" })); 
     assertEquals("", CharSetUtils.delete("----", new String[] { "-" })); 
     assertEquals("heo", CharSetUtils.delete("hello", new String[] { "l" })); 
 }
@Test
public void testDelete_StringStringarray1181() { 
     assertEquals(null, CharSetUtils.delete(null, (String[]) null)); 
     assertEquals(null, CharSetUtils.delete(null, new String[0])); 
     assertEquals(null, CharSetUtils.delete(null, new String[] { null })); 
     assertEquals(null, CharSetUtils.delete(null, new String[] { "el" })); 
     assertEquals("", CharSetUtils.delete("", (String[]) null)); 
     assertEquals("", CharSetUtils.delete("", new String[0])); 
     assertEquals("", CharSetUtils.delete("", new String[] { null })); 
     assertEquals("", CharSetUtils.delete("", new String[] { "a-e" })); 
     assertEquals("hello", CharSetUtils.delete("hello", (String[]) null)); 
     assertEquals("hello", CharSetUtils.delete("hello", new String[0])); 
     assertEquals("hello", CharSetUtils.delete("hello", new String[] { null })); 
     assertEquals("hello", CharSetUtils.delete("hello", new String[] { "xyz" })); 
     assertEquals("ho", CharSetUtils.delete("hello", new String[] { "el" })); 
     assertEquals("", CharSetUtils.delete("hello", new String[] { "elho" })); 
     assertEquals("hello", CharSetUtils.delete("hello", new String[] { "" })); 
     assertEquals("hello", CharSetUtils.delete("hello", "")); 
     assertEquals("", CharSetUtils.delete("hello", new String[] { "a-z" })); 
     assertEquals("", CharSetUtils.delete("----", new String[] { "-" })); 
     assertEquals("heo", CharSetUtils.delete("hello", new String[] { "l" })); 
 }
@Test
public void testDelete_StringStringarray1399() { 
     assertEquals(null, CharSetUtils.delete(null, (String[]) null)); 
     assertEquals(null, CharSetUtils.delete(null, new String[0])); 
     assertEquals(null, CharSetUtils.delete(null, new String[] { null })); 
     assertEquals(null, CharSetUtils.delete(null, new String[] { "el" })); 
     assertEquals("", CharSetUtils.delete("", (String[]) null)); 
     assertEquals("", CharSetUtils.delete("", new String[0])); 
     assertEquals("", CharSetUtils.delete("", new String[] { null })); 
     assertEquals("", CharSetUtils.delete("", new String[] { "a-e" })); 
     assertEquals("hello", CharSetUtils.delete("hello", (String[]) null)); 
     assertEquals("hello", CharSetUtils.delete("hello", new String[0])); 
     assertEquals("hello", CharSetUtils.delete("hello", new String[] { null })); 
     assertEquals("hello", CharSetUtils.delete("hello", new String[] { "xyz" })); 
     assertEquals("ho", CharSetUtils.delete("hello", new String[] { "el" })); 
     assertEquals("", CharSetUtils.delete("hello", new String[] { "elho" })); 
     assertEquals("hello", CharSetUtils.delete("hello", new String[] { "" })); 
     assertEquals("hello", CharSetUtils.delete("hello", "")); 
     assertEquals("", CharSetUtils.delete("hello", new String[] { "a-z" })); 
     assertEquals("", CharSetUtils.delete("----", new String[] { "-" })); 
     assertEquals("heo", CharSetUtils.delete("hello", new String[] { "l" })); 
 }
@Test
public void testConstructor1419() { 
     assertNotNull(new CharSetUtils()); 
     final Constructor<?>[] cons = CharSetUtils.class.getDeclaredConstructors(); 
     assertEquals(1, cons.length); 
     assertTrue(Modifier.isPublic(cons[0].getModifiers())); 
     assertTrue(Modifier.isPublic(CharSetUtils.class.getModifiers())); 
     assertFalse(Modifier.isFinal(CharSetUtils.class.getModifiers())); 
 }
@Test
public void testDelete_StringStringarray2299() { 
     assertEquals(null, CharSetUtils.delete(null, (String[]) null)); 
     assertEquals(null, CharSetUtils.delete(null, new String[0])); 
     assertEquals(null, CharSetUtils.delete(null, new String[] { null })); 
     assertEquals(null, CharSetUtils.delete(null, new String[] { "el" })); 
     assertEquals("", CharSetUtils.delete("", (String[]) null)); 
     assertEquals("", CharSetUtils.delete("", new String[0])); 
     assertEquals("", CharSetUtils.delete("", new String[] { null })); 
     assertEquals("", CharSetUtils.delete("", new String[] { "a-e" })); 
     assertEquals("hello", CharSetUtils.delete("hello", (String[]) null)); 
     assertEquals("hello", CharSetUtils.delete("hello", new String[0])); 
     assertEquals("hello", CharSetUtils.delete("hello", new String[] { null })); 
     assertEquals("hello", CharSetUtils.delete("hello", new String[] { "xyz" })); 
     assertEquals("ho", CharSetUtils.delete("hello", new String[] { "el" })); 
     assertEquals("", CharSetUtils.delete("hello", new String[] { "elho" })); 
     assertEquals("hello", CharSetUtils.delete("hello", new String[] { "" })); 
     assertEquals("hello", CharSetUtils.delete("hello", "")); 
     assertEquals("", CharSetUtils.delete("hello", new String[] { "a-z" })); 
     assertEquals("", CharSetUtils.delete("----", new String[] { "-" })); 
     assertEquals("heo", CharSetUtils.delete("hello", new String[] { "l" })); 
 }
@Test
public void testDelete_StringStringarray2363() { 
     assertEquals(null, CharSetUtils.delete(null, (String[]) null)); 
     assertEquals(null, CharSetUtils.delete(null, new String[0])); 
     assertEquals(null, CharSetUtils.delete(null, new String[] { null })); 
     assertEquals(null, CharSetUtils.delete(null, new String[] { "el" })); 
     assertEquals("", CharSetUtils.delete("", (String[]) null)); 
     assertEquals("", CharSetUtils.delete("", new String[0])); 
     assertEquals("", CharSetUtils.delete("", new String[] { null })); 
     assertEquals("", CharSetUtils.delete("", new String[] { "a-e" })); 
     assertEquals("hello", CharSetUtils.delete("hello", (String[]) null)); 
     assertEquals("hello", CharSetUtils.delete("hello", new String[0])); 
     assertEquals("hello", CharSetUtils.delete("hello", new String[] { null })); 
     assertEquals("hello", CharSetUtils.delete("hello", new String[] { "xyz" })); 
     assertEquals("ho", CharSetUtils.delete("hello", new String[] { "el" })); 
     assertEquals("", CharSetUtils.delete("hello", new String[] { "elho" })); 
     assertEquals("hello", CharSetUtils.delete("hello", new String[] { "" })); 
     assertEquals("hello", CharSetUtils.delete("hello", "")); 
     assertEquals("", CharSetUtils.delete("hello", new String[] { "a-z" })); 
     assertEquals("", CharSetUtils.delete("----", new String[] { "-" })); 
     assertEquals("heo", CharSetUtils.delete("hello", new String[] { "l" })); 
 }
@Test
public void testDelete_StringStringarray2389() { 
     assertEquals(null, CharSetUtils.delete(null, (String[]) null)); 
     assertEquals(null, CharSetUtils.delete(null, new String[0])); 
     assertEquals(null, CharSetUtils.delete(null, new String[] { null })); 
     assertEquals(null, CharSetUtils.delete(null, new String[] { "el" })); 
     assertEquals("", CharSetUtils.delete("", (String[]) null)); 
     assertEquals("", CharSetUtils.delete("", new String[0])); 
     assertEquals("", CharSetUtils.delete("", new String[] { null })); 
     assertEquals("", CharSetUtils.delete("", new String[] { "a-e" })); 
     assertEquals("hello", CharSetUtils.delete("hello", (String[]) null)); 
     assertEquals("hello", CharSetUtils.delete("hello", new String[0])); 
     assertEquals("hello", CharSetUtils.delete("hello", new String[] { null })); 
     assertEquals("hello", CharSetUtils.delete("hello", new String[] { "xyz" })); 
     assertEquals("ho", CharSetUtils.delete("hello", new String[] { "el" })); 
     assertEquals("", CharSetUtils.delete("hello", new String[] { "elho" })); 
     assertEquals("hello", CharSetUtils.delete("hello", new String[] { "" })); 
     assertEquals("hello", CharSetUtils.delete("hello", "")); 
     assertEquals("", CharSetUtils.delete("hello", new String[] { "a-z" })); 
     assertEquals("", CharSetUtils.delete("----", new String[] { "-" })); 
     assertEquals("heo", CharSetUtils.delete("hello", new String[] { "l" })); 
 }
@Test
public void testCount_StringStringarray2500() { 
     assertEquals(0, CharSetUtils.count(null, (String[]) null)); 
     assertEquals(0, CharSetUtils.count(null, new String[0])); 
     assertEquals(0, CharSetUtils.count(null, new String[] { null })); 
     assertEquals(0, CharSetUtils.count(null, new String[] { "a-e" })); 
     assertEquals(0, CharSetUtils.count("", (String[]) null)); 
     assertEquals(0, CharSetUtils.count("", new String[0])); 
     assertEquals(0, CharSetUtils.count("", new String[] { null })); 
     assertEquals(0, CharSetUtils.count("", new String[] { "a-e" })); 
     assertEquals(0, CharSetUtils.count("hello", (String[]) null)); 
     assertEquals(0, CharSetUtils.count("hello", new String[0])); 
     assertEquals(0, CharSetUtils.count("hello", new String[] { null })); 
     assertEquals(1, CharSetUtils.count("hello", new String[] { "a-e" })); 
     assertEquals(3, CharSetUtils.count("hello", new String[] { "el" })); 
     assertEquals(0, CharSetUtils.count("hello", new String[] { "x" })); 
     assertEquals(2, CharSetUtils.count("hello", new String[] { "e-i" })); 
     assertEquals(5, CharSetUtils.count("hello", new String[] { "a-z" })); 
     assertEquals(0, CharSetUtils.count("hello", new String[] { "" })); 
 }
@Test
public void testDelete_StringStringarray2837() { 
     assertEquals(null, CharSetUtils.delete(null, (String[]) null)); 
     assertEquals(null, CharSetUtils.delete(null, new String[0])); 
     assertEquals(null, CharSetUtils.delete(null, new String[] { null })); 
     assertEquals(null, CharSetUtils.delete(null, new String[] { "el" })); 
     assertEquals("", CharSetUtils.delete("", (String[]) null)); 
     assertEquals("", CharSetUtils.delete("", new String[0])); 
     assertEquals("", CharSetUtils.delete("", new String[] { null })); 
     assertEquals("", CharSetUtils.delete("", new String[] { "a-e" })); 
     assertEquals("hello", CharSetUtils.delete("hello", (String[]) null)); 
     assertEquals("hello", CharSetUtils.delete("hello", new String[0])); 
     assertEquals("hello", CharSetUtils.delete("hello", new String[] { null })); 
     assertEquals("hello", CharSetUtils.delete("hello", new String[] { "xyz" })); 
     assertEquals("ho", CharSetUtils.delete("hello", new String[] { "el" })); 
     assertEquals("", CharSetUtils.delete("hello", new String[] { "elho" })); 
     assertEquals("hello", CharSetUtils.delete("hello", new String[] { "" })); 
     assertEquals("hello", CharSetUtils.delete("hello", "")); 
     assertEquals("", CharSetUtils.delete("hello", new String[] { "a-z" })); 
     assertEquals("", CharSetUtils.delete("----", new String[] { "-" })); 
     assertEquals("heo", CharSetUtils.delete("hello", new String[] { "l" })); 
 }
@Test
public void testContainsAny_StringString2847() { 
     assertFalse(CharSetUtils.containsAny(null, (String) null)); 
     assertFalse(CharSetUtils.containsAny(null, "")); 
     assertFalse(CharSetUtils.containsAny("", (String) null)); 
     assertFalse(CharSetUtils.containsAny("", "")); 
     assertFalse(CharSetUtils.containsAny("", "a-e")); 
     assertFalse(CharSetUtils.containsAny("hello", (String) null)); 
     assertFalse(CharSetUtils.containsAny("hello", "")); 
     assertTrue(CharSetUtils.containsAny("hello", "a-e")); 
     assertTrue(CharSetUtils.containsAny("hello", "l-p")); 
 }
@Test
public void testDelete_StringStringarray3149() { 
     assertEquals(null, CharSetUtils.delete(null, (String[]) null)); 
     assertEquals(null, CharSetUtils.delete(null, new String[0])); 
     assertEquals(null, CharSetUtils.delete(null, new String[] { null })); 
     assertEquals(null, CharSetUtils.delete(null, new String[] { "el" })); 
     assertEquals("", CharSetUtils.delete("", (String[]) null)); 
     assertEquals("", CharSetUtils.delete("", new String[0])); 
     assertEquals("", CharSetUtils.delete("", new String[] { null })); 
     assertEquals("", CharSetUtils.delete("", new String[] { "a-e" })); 
     assertEquals("hello", CharSetUtils.delete("hello", (String[]) null)); 
     assertEquals("hello", CharSetUtils.delete("hello", new String[0])); 
     assertEquals("hello", CharSetUtils.delete("hello", new String[] { null })); 
     assertEquals("hello", CharSetUtils.delete("hello", new String[] { "xyz" })); 
     assertEquals("ho", CharSetUtils.delete("hello", new String[] { "el" })); 
     assertEquals("", CharSetUtils.delete("hello", new String[] { "elho" })); 
     assertEquals("hello", CharSetUtils.delete("hello", new String[] { "" })); 
     assertEquals("hello", CharSetUtils.delete("hello", "")); 
     assertEquals("", CharSetUtils.delete("hello", new String[] { "a-z" })); 
     assertEquals("", CharSetUtils.delete("----", new String[] { "-" })); 
     assertEquals("heo", CharSetUtils.delete("hello", new String[] { "l" })); 
 }
@Test
public void testDelete_StringStringarray3160() { 
     assertEquals(null, CharSetUtils.delete(null, (String[]) null)); 
     assertEquals(null, CharSetUtils.delete(null, new String[0])); 
     assertEquals(null, CharSetUtils.delete(null, new String[] { null })); 
     assertEquals(null, CharSetUtils.delete(null, new String[] { "el" })); 
     assertEquals("", CharSetUtils.delete("", (String[]) null)); 
     assertEquals("", CharSetUtils.delete("", new String[0])); 
     assertEquals("", CharSetUtils.delete("", new String[] { null })); 
     assertEquals("", CharSetUtils.delete("", new String[] { "a-e" })); 
     assertEquals("hello", CharSetUtils.delete("hello", (String[]) null)); 
     assertEquals("hello", CharSetUtils.delete("hello", new String[0])); 
     assertEquals("hello", CharSetUtils.delete("hello", new String[] { null })); 
     assertEquals("hello", CharSetUtils.delete("hello", new String[] { "xyz" })); 
     assertEquals("ho", CharSetUtils.delete("hello", new String[] { "el" })); 
     assertEquals("", CharSetUtils.delete("hello", new String[] { "elho" })); 
     assertEquals("hello", CharSetUtils.delete("hello", new String[] { "" })); 
     assertEquals("hello", CharSetUtils.delete("hello", "")); 
     assertEquals("", CharSetUtils.delete("hello", new String[] { "a-z" })); 
     assertEquals("", CharSetUtils.delete("----", new String[] { "-" })); 
     assertEquals("heo", CharSetUtils.delete("hello", new String[] { "l" })); 
 }
@Test
public void testDelete_StringStringarray3586() { 
     assertEquals(null, CharSetUtils.delete(null, (String[]) null)); 
     assertEquals(null, CharSetUtils.delete(null, new String[0])); 
     assertEquals(null, CharSetUtils.delete(null, new String[] { null })); 
     assertEquals(null, CharSetUtils.delete(null, new String[] { "el" })); 
     assertEquals("", CharSetUtils.delete("", (String[]) null)); 
     assertEquals("", CharSetUtils.delete("", new String[0])); 
     assertEquals("", CharSetUtils.delete("", new String[] { null })); 
     assertEquals("", CharSetUtils.delete("", new String[] { "a-e" })); 
     assertEquals("hello", CharSetUtils.delete("hello", (String[]) null)); 
     assertEquals("hello", CharSetUtils.delete("hello", new String[0])); 
     assertEquals("hello", CharSetUtils.delete("hello", new String[] { null })); 
     assertEquals("hello", CharSetUtils.delete("hello", new String[] { "xyz" })); 
     assertEquals("ho", CharSetUtils.delete("hello", new String[] { "el" })); 
     assertEquals("", CharSetUtils.delete("hello", new String[] { "elho" })); 
     assertEquals("hello", CharSetUtils.delete("hello", new String[] { "" })); 
     assertEquals("hello", CharSetUtils.delete("hello", "")); 
     assertEquals("", CharSetUtils.delete("hello", new String[] { "a-z" })); 
     assertEquals("", CharSetUtils.delete("----", new String[] { "-" })); 
     assertEquals("heo", CharSetUtils.delete("hello", new String[] { "l" })); 
 }
@Test
public void testDelete_StringStringarray3600() { 
     assertEquals(null, CharSetUtils.delete(null, (String[]) null)); 
     assertEquals(null, CharSetUtils.delete(null, new String[0])); 
     assertEquals(null, CharSetUtils.delete(null, new String[] { null })); 
     assertEquals(null, CharSetUtils.delete(null, new String[] { "el" })); 
     assertEquals("", CharSetUtils.delete("", (String[]) null)); 
     assertEquals("", CharSetUtils.delete("", new String[0])); 
     assertEquals("", CharSetUtils.delete("", new String[] { null })); 
     assertEquals("", CharSetUtils.delete("", new String[] { "a-e" })); 
     assertEquals("hello", CharSetUtils.delete("hello", (String[]) null)); 
     assertEquals("hello", CharSetUtils.delete("hello", new String[0])); 
     assertEquals("hello", CharSetUtils.delete("hello", new String[] { null })); 
     assertEquals("hello", CharSetUtils.delete("hello", new String[] { "xyz" })); 
     assertEquals("ho", CharSetUtils.delete("hello", new String[] { "el" })); 
     assertEquals("", CharSetUtils.delete("hello", new String[] { "elho" })); 
     assertEquals("hello", CharSetUtils.delete("hello", new String[] { "" })); 
     assertEquals("hello", CharSetUtils.delete("hello", "")); 
     assertEquals("", CharSetUtils.delete("hello", new String[] { "a-z" })); 
     assertEquals("", CharSetUtils.delete("----", new String[] { "-" })); 
     assertEquals("heo", CharSetUtils.delete("hello", new String[] { "l" })); 
 }
@Test
public void testDelete_StringStringarray3813() { 
     assertEquals(null, CharSetUtils.delete(null, (String[]) null)); 
     assertEquals(null, CharSetUtils.delete(null, new String[0])); 
     assertEquals(null, CharSetUtils.delete(null, new String[] { null })); 
     assertEquals(null, CharSetUtils.delete(null, new String[] { "el" })); 
     assertEquals("", CharSetUtils.delete("", (String[]) null)); 
     assertEquals("", CharSetUtils.delete("", new String[0])); 
     assertEquals("", CharSetUtils.delete("", new String[] { null })); 
     assertEquals("", CharSetUtils.delete("", new String[] { "a-e" })); 
     assertEquals("hello", CharSetUtils.delete("hello", (String[]) null)); 
     assertEquals("hello", CharSetUtils.delete("hello", new String[0])); 
     assertEquals("hello", CharSetUtils.delete("hello", new String[] { null })); 
     assertEquals("hello", CharSetUtils.delete("hello", new String[] { "xyz" })); 
     assertEquals("ho", CharSetUtils.delete("hello", new String[] { "el" })); 
     assertEquals("", CharSetUtils.delete("hello", new String[] { "elho" })); 
     assertEquals("hello", CharSetUtils.delete("hello", new String[] { "" })); 
     assertEquals("hello", CharSetUtils.delete("hello", "")); 
     assertEquals("", CharSetUtils.delete("hello", new String[] { "a-z" })); 
     assertEquals("", CharSetUtils.delete("----", new String[] { "-" })); 
     assertEquals("heo", CharSetUtils.delete("hello", new String[] { "l" })); 
 }
@Test
public void testDelete_StringStringarray3990() { 
     assertEquals(null, CharSetUtils.delete(null, (String[]) null)); 
     assertEquals(null, CharSetUtils.delete(null, new String[0])); 
     assertEquals(null, CharSetUtils.delete(null, new String[] { null })); 
     assertEquals(null, CharSetUtils.delete(null, new String[] { "el" })); 
     assertEquals("", CharSetUtils.delete("", (String[]) null)); 
     assertEquals("", CharSetUtils.delete("", new String[0])); 
     assertEquals("", CharSetUtils.delete("", new String[] { null })); 
     assertEquals("", CharSetUtils.delete("", new String[] { "a-e" })); 
     assertEquals("hello", CharSetUtils.delete("hello", (String[]) null)); 
     assertEquals("hello", CharSetUtils.delete("hello", new String[0])); 
     assertEquals("hello", CharSetUtils.delete("hello", new String[] { null })); 
     assertEquals("hello", CharSetUtils.delete("hello", new String[] { "xyz" })); 
     assertEquals("ho", CharSetUtils.delete("hello", new String[] { "el" })); 
     assertEquals("", CharSetUtils.delete("hello", new String[] { "elho" })); 
     assertEquals("hello", CharSetUtils.delete("hello", new String[] { "" })); 
     assertEquals("hello", CharSetUtils.delete("hello", "")); 
     assertEquals("", CharSetUtils.delete("hello", new String[] { "a-z" })); 
     assertEquals("", CharSetUtils.delete("----", new String[] { "-" })); 
     assertEquals("heo", CharSetUtils.delete("hello", new String[] { "l" })); 
 }
@Test
public void testDelete_StringStringarray4304() { 
     assertEquals(null, CharSetUtils.delete(null, (String[]) null)); 
     assertEquals(null, CharSetUtils.delete(null, new String[0])); 
     assertEquals(null, CharSetUtils.delete(null, new String[] { null })); 
     assertEquals(null, CharSetUtils.delete(null, new String[] { "el" })); 
     assertEquals("", CharSetUtils.delete("", (String[]) null)); 
     assertEquals("", CharSetUtils.delete("", new String[0])); 
     assertEquals("", CharSetUtils.delete("", new String[] { null })); 
     assertEquals("", CharSetUtils.delete("", new String[] { "a-e" })); 
     assertEquals("hello", CharSetUtils.delete("hello", (String[]) null)); 
     assertEquals("hello", CharSetUtils.delete("hello", new String[0])); 
     assertEquals("hello", CharSetUtils.delete("hello", new String[] { null })); 
     assertEquals("hello", CharSetUtils.delete("hello", new String[] { "xyz" })); 
     assertEquals("ho", CharSetUtils.delete("hello", new String[] { "el" })); 
     assertEquals("", CharSetUtils.delete("hello", new String[] { "elho" })); 
     assertEquals("hello", CharSetUtils.delete("hello", new String[] { "" })); 
     assertEquals("hello", CharSetUtils.delete("hello", "")); 
     assertEquals("", CharSetUtils.delete("hello", new String[] { "a-z" })); 
     assertEquals("", CharSetUtils.delete("----", new String[] { "-" })); 
     assertEquals("heo", CharSetUtils.delete("hello", new String[] { "l" })); 
 }
@Test
public void testDelete_StringStringarray4479() { 
     assertEquals(null, CharSetUtils.delete(null, (String[]) null)); 
     assertEquals(null, CharSetUtils.delete(null, new String[0])); 
     assertEquals(null, CharSetUtils.delete(null, new String[] { null })); 
     assertEquals(null, CharSetUtils.delete(null, new String[] { "el" })); 
     assertEquals("", CharSetUtils.delete("", (String[]) null)); 
     assertEquals("", CharSetUtils.delete("", new String[0])); 
     assertEquals("", CharSetUtils.delete("", new String[] { null })); 
     assertEquals("", CharSetUtils.delete("", new String[] { "a-e" })); 
     assertEquals("hello", CharSetUtils.delete("hello", (String[]) null)); 
     assertEquals("hello", CharSetUtils.delete("hello", new String[0])); 
     assertEquals("hello", CharSetUtils.delete("hello", new String[] { null })); 
     assertEquals("hello", CharSetUtils.delete("hello", new String[] { "xyz" })); 
     assertEquals("ho", CharSetUtils.delete("hello", new String[] { "el" })); 
     assertEquals("", CharSetUtils.delete("hello", new String[] { "elho" })); 
     assertEquals("hello", CharSetUtils.delete("hello", new String[] { "" })); 
     assertEquals("hello", CharSetUtils.delete("hello", "")); 
     assertEquals("", CharSetUtils.delete("hello", new String[] { "a-z" })); 
     assertEquals("", CharSetUtils.delete("----", new String[] { "-" })); 
     assertEquals("heo", CharSetUtils.delete("hello", new String[] { "l" })); 
 }
@Test
public void testDelete_StringStringarray4529() { 
     assertEquals(null, CharSetUtils.delete(null, (String[]) null)); 
     assertEquals(null, CharSetUtils.delete(null, new String[0])); 
     assertEquals(null, CharSetUtils.delete(null, new String[] { null })); 
     assertEquals(null, CharSetUtils.delete(null, new String[] { "el" })); 
     assertEquals("", CharSetUtils.delete("", (String[]) null)); 
     assertEquals("", CharSetUtils.delete("", new String[0])); 
     assertEquals("", CharSetUtils.delete("", new String[] { null })); 
     assertEquals("", CharSetUtils.delete("", new String[] { "a-e" })); 
     assertEquals("hello", CharSetUtils.delete("hello", (String[]) null)); 
     assertEquals("hello", CharSetUtils.delete("hello", new String[0])); 
     assertEquals("hello", CharSetUtils.delete("hello", new String[] { null })); 
     assertEquals("hello", CharSetUtils.delete("hello", new String[] { "xyz" })); 
     assertEquals("ho", CharSetUtils.delete("hello", new String[] { "el" })); 
     assertEquals("", CharSetUtils.delete("hello", new String[] { "elho" })); 
     assertEquals("hello", CharSetUtils.delete("hello", new String[] { "" })); 
     assertEquals("hello", CharSetUtils.delete("hello", "")); 
     assertEquals("", CharSetUtils.delete("hello", new String[] { "a-z" })); 
     assertEquals("", CharSetUtils.delete("----", new String[] { "-" })); 
     assertEquals("heo", CharSetUtils.delete("hello", new String[] { "l" })); 
 }
@Test
public void testDelete_StringStringarray4560() { 
     assertEquals(null, CharSetUtils.delete(null, (String[]) null)); 
     assertEquals(null, CharSetUtils.delete(null, new String[0])); 
     assertEquals(null, CharSetUtils.delete(null, new String[] { null })); 
     assertEquals(null, CharSetUtils.delete(null, new String[] { "el" })); 
     assertEquals("", CharSetUtils.delete("", (String[]) null)); 
     assertEquals("", CharSetUtils.delete("", new String[0])); 
     assertEquals("", CharSetUtils.delete("", new String[] { null })); 
     assertEquals("", CharSetUtils.delete("", new String[] { "a-e" })); 
     assertEquals("hello", CharSetUtils.delete("hello", (String[]) null)); 
     assertEquals("hello", CharSetUtils.delete("hello", new String[0])); 
     assertEquals("hello", CharSetUtils.delete("hello", new String[] { null })); 
     assertEquals("hello", CharSetUtils.delete("hello", new String[] { "xyz" })); 
     assertEquals("ho", CharSetUtils.delete("hello", new String[] { "el" })); 
     assertEquals("", CharSetUtils.delete("hello", new String[] { "elho" })); 
     assertEquals("hello", CharSetUtils.delete("hello", new String[] { "" })); 
     assertEquals("hello", CharSetUtils.delete("hello", "")); 
     assertEquals("", CharSetUtils.delete("hello", new String[] { "a-z" })); 
     assertEquals("", CharSetUtils.delete("----", new String[] { "-" })); 
     assertEquals("heo", CharSetUtils.delete("hello", new String[] { "l" })); 
 }
@Test
public void testCount_StringStringarray4727() { 
     assertEquals(0, CharSetUtils.count(null, (String[]) null)); 
     assertEquals(0, CharSetUtils.count(null, new String[0])); 
     assertEquals(0, CharSetUtils.count(null, new String[] { null })); 
     assertEquals(0, CharSetUtils.count(null, new String[] { "a-e" })); 
     assertEquals(0, CharSetUtils.count("", (String[]) null)); 
     assertEquals(0, CharSetUtils.count("", new String[0])); 
     assertEquals(0, CharSetUtils.count("", new String[] { null })); 
     assertEquals(0, CharSetUtils.count("", new String[] { "a-e" })); 
     assertEquals(0, CharSetUtils.count("hello", (String[]) null)); 
     assertEquals(0, CharSetUtils.count("hello", new String[0])); 
     assertEquals(0, CharSetUtils.count("hello", new String[] { null })); 
     assertEquals(1, CharSetUtils.count("hello", new String[] { "a-e" })); 
     assertEquals(3, CharSetUtils.count("hello", new String[] { "el" })); 
     assertEquals(0, CharSetUtils.count("hello", new String[] { "x" })); 
     assertEquals(2, CharSetUtils.count("hello", new String[] { "e-i" })); 
     assertEquals(5, CharSetUtils.count("hello", new String[] { "a-z" })); 
     assertEquals(0, CharSetUtils.count("hello", new String[] { "" })); 
 }
@Test
public void testCount_StringStringarray4752() { 
     assertEquals(0, CharSetUtils.count(null, (String[]) null)); 
     assertEquals(0, CharSetUtils.count(null, new String[0])); 
     assertEquals(0, CharSetUtils.count(null, new String[] { null })); 
     assertEquals(0, CharSetUtils.count(null, new String[] { "a-e" })); 
     assertEquals(0, CharSetUtils.count("", (String[]) null)); 
     assertEquals(0, CharSetUtils.count("", new String[0])); 
     assertEquals(0, CharSetUtils.count("", new String[] { null })); 
     assertEquals(0, CharSetUtils.count("", new String[] { "a-e" })); 
     assertEquals(0, CharSetUtils.count("hello", (String[]) null)); 
     assertEquals(0, CharSetUtils.count("hello", new String[0])); 
     assertEquals(0, CharSetUtils.count("hello", new String[] { null })); 
     assertEquals(1, CharSetUtils.count("hello", new String[] { "a-e" })); 
     assertEquals(3, CharSetUtils.count("hello", new String[] { "el" })); 
     assertEquals(0, CharSetUtils.count("hello", new String[] { "x" })); 
     assertEquals(2, CharSetUtils.count("hello", new String[] { "e-i" })); 
     assertEquals(5, CharSetUtils.count("hello", new String[] { "a-z" })); 
     assertEquals(0, CharSetUtils.count("hello", new String[] { "" })); 
 }
@Test
public void testDelete_StringStringarray4761() { 
     assertEquals(null, CharSetUtils.delete(null, (String[]) null)); 
     assertEquals(null, CharSetUtils.delete(null, new String[0])); 
     assertEquals(null, CharSetUtils.delete(null, new String[] { null })); 
     assertEquals(null, CharSetUtils.delete(null, new String[] { "el" })); 
     assertEquals("", CharSetUtils.delete("", (String[]) null)); 
     assertEquals("", CharSetUtils.delete("", new String[0])); 
     assertEquals("", CharSetUtils.delete("", new String[] { null })); 
     assertEquals("", CharSetUtils.delete("", new String[] { "a-e" })); 
     assertEquals("hello", CharSetUtils.delete("hello", (String[]) null)); 
     assertEquals("hello", CharSetUtils.delete("hello", new String[0])); 
     assertEquals("hello", CharSetUtils.delete("hello", new String[] { null })); 
     assertEquals("hello", CharSetUtils.delete("hello", new String[] { "xyz" })); 
     assertEquals("ho", CharSetUtils.delete("hello", new String[] { "el" })); 
     assertEquals("", CharSetUtils.delete("hello", new String[] { "elho" })); 
     assertEquals("hello", CharSetUtils.delete("hello", new String[] { "" })); 
     assertEquals("hello", CharSetUtils.delete("hello", "")); 
     assertEquals("", CharSetUtils.delete("hello", new String[] { "a-z" })); 
     assertEquals("", CharSetUtils.delete("----", new String[] { "-" })); 
     assertEquals("heo", CharSetUtils.delete("hello", new String[] { "l" })); 
 }
@Test
public void testCount_StringStringarray5060() { 
     assertEquals(0, CharSetUtils.count(null, (String[]) null)); 
     assertEquals(0, CharSetUtils.count(null, new String[0])); 
     assertEquals(0, CharSetUtils.count(null, new String[] { null })); 
     assertEquals(0, CharSetUtils.count(null, new String[] { "a-e" })); 
     assertEquals(0, CharSetUtils.count("", (String[]) null)); 
     assertEquals(0, CharSetUtils.count("", new String[0])); 
     assertEquals(0, CharSetUtils.count("", new String[] { null })); 
     assertEquals(0, CharSetUtils.count("", new String[] { "a-e" })); 
     assertEquals(0, CharSetUtils.count("hello", (String[]) null)); 
     assertEquals(0, CharSetUtils.count("hello", new String[0])); 
     assertEquals(0, CharSetUtils.count("hello", new String[] { null })); 
     assertEquals(1, CharSetUtils.count("hello", new String[] { "a-e" })); 
     assertEquals(3, CharSetUtils.count("hello", new String[] { "el" })); 
     assertEquals(0, CharSetUtils.count("hello", new String[] { "x" })); 
     assertEquals(2, CharSetUtils.count("hello", new String[] { "e-i" })); 
     assertEquals(5, CharSetUtils.count("hello", new String[] { "a-z" })); 
     assertEquals(0, CharSetUtils.count("hello", new String[] { "" })); 
 }
@Test
public void testCount_StringStringarray5159() { 
     assertEquals(0, CharSetUtils.count(null, (String[]) null)); 
     assertEquals(0, CharSetUtils.count(null, new String[0])); 
     assertEquals(0, CharSetUtils.count(null, new String[] { null })); 
     assertEquals(0, CharSetUtils.count(null, new String[] { "a-e" })); 
     assertEquals(0, CharSetUtils.count("", (String[]) null)); 
     assertEquals(0, CharSetUtils.count("", new String[0])); 
     assertEquals(0, CharSetUtils.count("", new String[] { null })); 
     assertEquals(0, CharSetUtils.count("", new String[] { "a-e" })); 
     assertEquals(0, CharSetUtils.count("hello", (String[]) null)); 
     assertEquals(0, CharSetUtils.count("hello", new String[0])); 
     assertEquals(0, CharSetUtils.count("hello", new String[] { null })); 
     assertEquals(1, CharSetUtils.count("hello", new String[] { "a-e" })); 
     assertEquals(3, CharSetUtils.count("hello", new String[] { "el" })); 
     assertEquals(0, CharSetUtils.count("hello", new String[] { "x" })); 
     assertEquals(2, CharSetUtils.count("hello", new String[] { "e-i" })); 
     assertEquals(5, CharSetUtils.count("hello", new String[] { "a-z" })); 
     assertEquals(0, CharSetUtils.count("hello", new String[] { "" })); 
 }
@Test
public void testDelete_StringStringarray5205() { 
     assertEquals(null, CharSetUtils.delete(null, (String[]) null)); 
     assertEquals(null, CharSetUtils.delete(null, new String[0])); 
     assertEquals(null, CharSetUtils.delete(null, new String[] { null })); 
     assertEquals(null, CharSetUtils.delete(null, new String[] { "el" })); 
     assertEquals("", CharSetUtils.delete("", (String[]) null)); 
     assertEquals("", CharSetUtils.delete("", new String[0])); 
     assertEquals("", CharSetUtils.delete("", new String[] { null })); 
     assertEquals("", CharSetUtils.delete("", new String[] { "a-e" })); 
     assertEquals("hello", CharSetUtils.delete("hello", (String[]) null)); 
     assertEquals("hello", CharSetUtils.delete("hello", new String[0])); 
     assertEquals("hello", CharSetUtils.delete("hello", new String[] { null })); 
     assertEquals("hello", CharSetUtils.delete("hello", new String[] { "xyz" })); 
     assertEquals("ho", CharSetUtils.delete("hello", new String[] { "el" })); 
     assertEquals("", CharSetUtils.delete("hello", new String[] { "elho" })); 
     assertEquals("hello", CharSetUtils.delete("hello", new String[] { "" })); 
     assertEquals("hello", CharSetUtils.delete("hello", "")); 
     assertEquals("", CharSetUtils.delete("hello", new String[] { "a-z" })); 
     assertEquals("", CharSetUtils.delete("----", new String[] { "-" })); 
     assertEquals("heo", CharSetUtils.delete("hello", new String[] { "l" })); 
 }
@Test
public void testContainsAny_StringString5574() { 
     assertFalse(CharSetUtils.containsAny(null, (String) null)); 
     assertFalse(CharSetUtils.containsAny(null, "")); 
     assertFalse(CharSetUtils.containsAny("", (String) null)); 
     assertFalse(CharSetUtils.containsAny("", "")); 
     assertFalse(CharSetUtils.containsAny("", "a-e")); 
     assertFalse(CharSetUtils.containsAny("hello", (String) null)); 
     assertFalse(CharSetUtils.containsAny("hello", "")); 
     assertTrue(CharSetUtils.containsAny("hello", "a-e")); 
     assertTrue(CharSetUtils.containsAny("hello", "l-p")); 
 }
@Test
public void testConstructor5667() { 
     assertNotNull(new CharSetUtils()); 
     final Constructor<?>[] cons = CharSetUtils.class.getDeclaredConstructors(); 
     assertEquals(1, cons.length); 
     assertTrue(Modifier.isPublic(cons[0].getModifiers())); 
     assertTrue(Modifier.isPublic(CharSetUtils.class.getModifiers())); 
     assertFalse(Modifier.isFinal(CharSetUtils.class.getModifiers())); 
 }
@Test
public void testDelete_StringStringarray5671() { 
     assertEquals(null, CharSetUtils.delete(null, (String[]) null)); 
     assertEquals(null, CharSetUtils.delete(null, new String[0])); 
     assertEquals(null, CharSetUtils.delete(null, new String[] { null })); 
     assertEquals(null, CharSetUtils.delete(null, new String[] { "el" })); 
     assertEquals("", CharSetUtils.delete("", (String[]) null)); 
     assertEquals("", CharSetUtils.delete("", new String[0])); 
     assertEquals("", CharSetUtils.delete("", new String[] { null })); 
     assertEquals("", CharSetUtils.delete("", new String[] { "a-e" })); 
     assertEquals("hello", CharSetUtils.delete("hello", (String[]) null)); 
     assertEquals("hello", CharSetUtils.delete("hello", new String[0])); 
     assertEquals("hello", CharSetUtils.delete("hello", new String[] { null })); 
     assertEquals("hello", CharSetUtils.delete("hello", new String[] { "xyz" })); 
     assertEquals("ho", CharSetUtils.delete("hello", new String[] { "el" })); 
     assertEquals("", CharSetUtils.delete("hello", new String[] { "elho" })); 
     assertEquals("hello", CharSetUtils.delete("hello", new String[] { "" })); 
     assertEquals("hello", CharSetUtils.delete("hello", "")); 
     assertEquals("", CharSetUtils.delete("hello", new String[] { "a-z" })); 
     assertEquals("", CharSetUtils.delete("----", new String[] { "-" })); 
     assertEquals("heo", CharSetUtils.delete("hello", new String[] { "l" })); 
 }
@Test
public void testDelete_StringStringarray5741() { 
     assertEquals(null, CharSetUtils.delete(null, (String[]) null)); 
     assertEquals(null, CharSetUtils.delete(null, new String[0])); 
     assertEquals(null, CharSetUtils.delete(null, new String[] { null })); 
     assertEquals(null, CharSetUtils.delete(null, new String[] { "el" })); 
     assertEquals("", CharSetUtils.delete("", (String[]) null)); 
     assertEquals("", CharSetUtils.delete("", new String[0])); 
     assertEquals("", CharSetUtils.delete("", new String[] { null })); 
     assertEquals("", CharSetUtils.delete("", new String[] { "a-e" })); 
     assertEquals("hello", CharSetUtils.delete("hello", (String[]) null)); 
     assertEquals("hello", CharSetUtils.delete("hello", new String[0])); 
     assertEquals("hello", CharSetUtils.delete("hello", new String[] { null })); 
     assertEquals("hello", CharSetUtils.delete("hello", new String[] { "xyz" })); 
     assertEquals("ho", CharSetUtils.delete("hello", new String[] { "el" })); 
     assertEquals("", CharSetUtils.delete("hello", new String[] { "elho" })); 
     assertEquals("hello", CharSetUtils.delete("hello", new String[] { "" })); 
     assertEquals("hello", CharSetUtils.delete("hello", "")); 
     assertEquals("", CharSetUtils.delete("hello", new String[] { "a-z" })); 
     assertEquals("", CharSetUtils.delete("----", new String[] { "-" })); 
     assertEquals("heo", CharSetUtils.delete("hello", new String[] { "l" })); 
 }
@Test
public void testContainsAny_StringString5916() { 
     assertFalse(CharSetUtils.containsAny(null, (String) null)); 
     assertFalse(CharSetUtils.containsAny(null, "")); 
     assertFalse(CharSetUtils.containsAny("", (String) null)); 
     assertFalse(CharSetUtils.containsAny("", "")); 
     assertFalse(CharSetUtils.containsAny("", "a-e")); 
     assertFalse(CharSetUtils.containsAny("hello", (String) null)); 
     assertFalse(CharSetUtils.containsAny("hello", "")); 
     assertTrue(CharSetUtils.containsAny("hello", "a-e")); 
     assertTrue(CharSetUtils.containsAny("hello", "l-p")); 
 }
@Test
public void testCount_StringStringarray6043() { 
     assertEquals(0, CharSetUtils.count(null, (String[]) null)); 
     assertEquals(0, CharSetUtils.count(null, new String[0])); 
     assertEquals(0, CharSetUtils.count(null, new String[] { null })); 
     assertEquals(0, CharSetUtils.count(null, new String[] { "a-e" })); 
     assertEquals(0, CharSetUtils.count("", (String[]) null)); 
     assertEquals(0, CharSetUtils.count("", new String[0])); 
     assertEquals(0, CharSetUtils.count("", new String[] { null })); 
     assertEquals(0, CharSetUtils.count("", new String[] { "a-e" })); 
     assertEquals(0, CharSetUtils.count("hello", (String[]) null)); 
     assertEquals(0, CharSetUtils.count("hello", new String[0])); 
     assertEquals(0, CharSetUtils.count("hello", new String[] { null })); 
     assertEquals(1, CharSetUtils.count("hello", new String[] { "a-e" })); 
     assertEquals(3, CharSetUtils.count("hello", new String[] { "el" })); 
     assertEquals(0, CharSetUtils.count("hello", new String[] { "x" })); 
     assertEquals(2, CharSetUtils.count("hello", new String[] { "e-i" })); 
     assertEquals(5, CharSetUtils.count("hello", new String[] { "a-z" })); 
     assertEquals(0, CharSetUtils.count("hello", new String[] { "" })); 
 }
@Test
public void testCount_StringStringarray6068() { 
     assertEquals(0, CharSetUtils.count(null, (String[]) null)); 
     assertEquals(0, CharSetUtils.count(null, new String[0])); 
     assertEquals(0, CharSetUtils.count(null, new String[] { null })); 
     assertEquals(0, CharSetUtils.count(null, new String[] { "a-e" })); 
     assertEquals(0, CharSetUtils.count("", (String[]) null)); 
     assertEquals(0, CharSetUtils.count("", new String[0])); 
     assertEquals(0, CharSetUtils.count("", new String[] { null })); 
     assertEquals(0, CharSetUtils.count("", new String[] { "a-e" })); 
     assertEquals(0, CharSetUtils.count("hello", (String[]) null)); 
     assertEquals(0, CharSetUtils.count("hello", new String[0])); 
     assertEquals(0, CharSetUtils.count("hello", new String[] { null })); 
     assertEquals(1, CharSetUtils.count("hello", new String[] { "a-e" })); 
     assertEquals(3, CharSetUtils.count("hello", new String[] { "el" })); 
     assertEquals(0, CharSetUtils.count("hello", new String[] { "x" })); 
     assertEquals(2, CharSetUtils.count("hello", new String[] { "e-i" })); 
     assertEquals(5, CharSetUtils.count("hello", new String[] { "a-z" })); 
     assertEquals(0, CharSetUtils.count("hello", new String[] { "" })); 
 }
@Test
public void testDelete_StringStringarray6204() { 
     assertEquals(null, CharSetUtils.delete(null, (String[]) null)); 
     assertEquals(null, CharSetUtils.delete(null, new String[0])); 
     assertEquals(null, CharSetUtils.delete(null, new String[] { null })); 
     assertEquals(null, CharSetUtils.delete(null, new String[] { "el" })); 
     assertEquals("", CharSetUtils.delete("", (String[]) null)); 
     assertEquals("", CharSetUtils.delete("", new String[0])); 
     assertEquals("", CharSetUtils.delete("", new String[] { null })); 
     assertEquals("", CharSetUtils.delete("", new String[] { "a-e" })); 
     assertEquals("hello", CharSetUtils.delete("hello", (String[]) null)); 
     assertEquals("hello", CharSetUtils.delete("hello", new String[0])); 
     assertEquals("hello", CharSetUtils.delete("hello", new String[] { null })); 
     assertEquals("hello", CharSetUtils.delete("hello", new String[] { "xyz" })); 
     assertEquals("ho", CharSetUtils.delete("hello", new String[] { "el" })); 
     assertEquals("", CharSetUtils.delete("hello", new String[] { "elho" })); 
     assertEquals("hello", CharSetUtils.delete("hello", new String[] { "" })); 
     assertEquals("hello", CharSetUtils.delete("hello", "")); 
     assertEquals("", CharSetUtils.delete("hello", new String[] { "a-z" })); 
     assertEquals("", CharSetUtils.delete("----", new String[] { "-" })); 
     assertEquals("heo", CharSetUtils.delete("hello", new String[] { "l" })); 
 }
@Test
public void testDelete_StringStringarray6296() { 
     assertEquals(null, CharSetUtils.delete(null, (String[]) null)); 
     assertEquals(null, CharSetUtils.delete(null, new String[0])); 
     assertEquals(null, CharSetUtils.delete(null, new String[] { null })); 
     assertEquals(null, CharSetUtils.delete(null, new String[] { "el" })); 
     assertEquals("", CharSetUtils.delete("", (String[]) null)); 
     assertEquals("", CharSetUtils.delete("", new String[0])); 
     assertEquals("", CharSetUtils.delete("", new String[] { null })); 
     assertEquals("", CharSetUtils.delete("", new String[] { "a-e" })); 
     assertEquals("hello", CharSetUtils.delete("hello", (String[]) null)); 
     assertEquals("hello", CharSetUtils.delete("hello", new String[0])); 
     assertEquals("hello", CharSetUtils.delete("hello", new String[] { null })); 
     assertEquals("hello", CharSetUtils.delete("hello", new String[] { "xyz" })); 
     assertEquals("ho", CharSetUtils.delete("hello", new String[] { "el" })); 
     assertEquals("", CharSetUtils.delete("hello", new String[] { "elho" })); 
     assertEquals("hello", CharSetUtils.delete("hello", new String[] { "" })); 
     assertEquals("hello", CharSetUtils.delete("hello", "")); 
     assertEquals("", CharSetUtils.delete("hello", new String[] { "a-z" })); 
     assertEquals("", CharSetUtils.delete("----", new String[] { "-" })); 
     assertEquals("heo", CharSetUtils.delete("hello", new String[] { "l" })); 
 }
@Test
public void testDelete_StringStringarray6323() { 
     assertEquals(null, CharSetUtils.delete(null, (String[]) null)); 
     assertEquals(null, CharSetUtils.delete(null, new String[0])); 
     assertEquals(null, CharSetUtils.delete(null, new String[] { null })); 
     assertEquals(null, CharSetUtils.delete(null, new String[] { "el" })); 
     assertEquals("", CharSetUtils.delete("", (String[]) null)); 
     assertEquals("", CharSetUtils.delete("", new String[0])); 
     assertEquals("", CharSetUtils.delete("", new String[] { null })); 
     assertEquals("", CharSetUtils.delete("", new String[] { "a-e" })); 
     assertEquals("hello", CharSetUtils.delete("hello", (String[]) null)); 
     assertEquals("hello", CharSetUtils.delete("hello", new String[0])); 
     assertEquals("hello", CharSetUtils.delete("hello", new String[] { null })); 
     assertEquals("hello", CharSetUtils.delete("hello", new String[] { "xyz" })); 
     assertEquals("ho", CharSetUtils.delete("hello", new String[] { "el" })); 
     assertEquals("", CharSetUtils.delete("hello", new String[] { "elho" })); 
     assertEquals("hello", CharSetUtils.delete("hello", new String[] { "" })); 
     assertEquals("hello", CharSetUtils.delete("hello", "")); 
     assertEquals("", CharSetUtils.delete("hello", new String[] { "a-z" })); 
     assertEquals("", CharSetUtils.delete("----", new String[] { "-" })); 
     assertEquals("heo", CharSetUtils.delete("hello", new String[] { "l" })); 
 }
@Test
public void testDelete_StringStringarray6371() { 
     assertEquals(null, CharSetUtils.delete(null, (String[]) null)); 
     assertEquals(null, CharSetUtils.delete(null, new String[0])); 
     assertEquals(null, CharSetUtils.delete(null, new String[] { null })); 
     assertEquals(null, CharSetUtils.delete(null, new String[] { "el" })); 
     assertEquals("", CharSetUtils.delete("", (String[]) null)); 
     assertEquals("", CharSetUtils.delete("", new String[0])); 
     assertEquals("", CharSetUtils.delete("", new String[] { null })); 
     assertEquals("", CharSetUtils.delete("", new String[] { "a-e" })); 
     assertEquals("hello", CharSetUtils.delete("hello", (String[]) null)); 
     assertEquals("hello", CharSetUtils.delete("hello", new String[0])); 
     assertEquals("hello", CharSetUtils.delete("hello", new String[] { null })); 
     assertEquals("hello", CharSetUtils.delete("hello", new String[] { "xyz" })); 
     assertEquals("ho", CharSetUtils.delete("hello", new String[] { "el" })); 
     assertEquals("", CharSetUtils.delete("hello", new String[] { "elho" })); 
     assertEquals("hello", CharSetUtils.delete("hello", new String[] { "" })); 
     assertEquals("hello", CharSetUtils.delete("hello", "")); 
     assertEquals("", CharSetUtils.delete("hello", new String[] { "a-z" })); 
     assertEquals("", CharSetUtils.delete("----", new String[] { "-" })); 
     assertEquals("heo", CharSetUtils.delete("hello", new String[] { "l" })); 
 }
@Test
public void testCount_StringStringarray6417() { 
     assertEquals(0, CharSetUtils.count(null, (String[]) null)); 
     assertEquals(0, CharSetUtils.count(null, new String[0])); 
     assertEquals(0, CharSetUtils.count(null, new String[] { null })); 
     assertEquals(0, CharSetUtils.count(null, new String[] { "a-e" })); 
     assertEquals(0, CharSetUtils.count("", (String[]) null)); 
     assertEquals(0, CharSetUtils.count("", new String[0])); 
     assertEquals(0, CharSetUtils.count("", new String[] { null })); 
     assertEquals(0, CharSetUtils.count("", new String[] { "a-e" })); 
     assertEquals(0, CharSetUtils.count("hello", (String[]) null)); 
     assertEquals(0, CharSetUtils.count("hello", new String[0])); 
     assertEquals(0, CharSetUtils.count("hello", new String[] { null })); 
     assertEquals(1, CharSetUtils.count("hello", new String[] { "a-e" })); 
     assertEquals(3, CharSetUtils.count("hello", new String[] { "el" })); 
     assertEquals(0, CharSetUtils.count("hello", new String[] { "x" })); 
     assertEquals(2, CharSetUtils.count("hello", new String[] { "e-i" })); 
     assertEquals(5, CharSetUtils.count("hello", new String[] { "a-z" })); 
     assertEquals(0, CharSetUtils.count("hello", new String[] { "" })); 
 }
@Test
public void testContainsAny_StringString6690() { 
     assertFalse(CharSetUtils.containsAny(null, (String) null)); 
     assertFalse(CharSetUtils.containsAny(null, "")); 
     assertFalse(CharSetUtils.containsAny("", (String) null)); 
     assertFalse(CharSetUtils.containsAny("", "")); 
     assertFalse(CharSetUtils.containsAny("", "a-e")); 
     assertFalse(CharSetUtils.containsAny("hello", (String) null)); 
     assertFalse(CharSetUtils.containsAny("hello", "")); 
     assertTrue(CharSetUtils.containsAny("hello", "a-e")); 
     assertTrue(CharSetUtils.containsAny("hello", "l-p")); 
 }
@Test
public void testDelete_StringStringarray7094() { 
     assertEquals(null, CharSetUtils.delete(null, (String[]) null)); 
     assertEquals(null, CharSetUtils.delete(null, new String[0])); 
     assertEquals(null, CharSetUtils.delete(null, new String[] { null })); 
     assertEquals(null, CharSetUtils.delete(null, new String[] { "el" })); 
     assertEquals("", CharSetUtils.delete("", (String[]) null)); 
     assertEquals("", CharSetUtils.delete("", new String[0])); 
     assertEquals("", CharSetUtils.delete("", new String[] { null })); 
     assertEquals("", CharSetUtils.delete("", new String[] { "a-e" })); 
     assertEquals("hello", CharSetUtils.delete("hello", (String[]) null)); 
     assertEquals("hello", CharSetUtils.delete("hello", new String[0])); 
     assertEquals("hello", CharSetUtils.delete("hello", new String[] { null })); 
     assertEquals("hello", CharSetUtils.delete("hello", new String[] { "xyz" })); 
     assertEquals("ho", CharSetUtils.delete("hello", new String[] { "el" })); 
     assertEquals("", CharSetUtils.delete("hello", new String[] { "elho" })); 
     assertEquals("hello", CharSetUtils.delete("hello", new String[] { "" })); 
     assertEquals("hello", CharSetUtils.delete("hello", "")); 
     assertEquals("", CharSetUtils.delete("hello", new String[] { "a-z" })); 
     assertEquals("", CharSetUtils.delete("----", new String[] { "-" })); 
     assertEquals("heo", CharSetUtils.delete("hello", new String[] { "l" })); 
 }
@Test
public void testDelete_StringStringarray7328() { 
     assertEquals(null, CharSetUtils.delete(null, (String[]) null)); 
     assertEquals(null, CharSetUtils.delete(null, new String[0])); 
     assertEquals(null, CharSetUtils.delete(null, new String[] { null })); 
     assertEquals(null, CharSetUtils.delete(null, new String[] { "el" })); 
     assertEquals("", CharSetUtils.delete("", (String[]) null)); 
     assertEquals("", CharSetUtils.delete("", new String[0])); 
     assertEquals("", CharSetUtils.delete("", new String[] { null })); 
     assertEquals("", CharSetUtils.delete("", new String[] { "a-e" })); 
     assertEquals("hello", CharSetUtils.delete("hello", (String[]) null)); 
     assertEquals("hello", CharSetUtils.delete("hello", new String[0])); 
     assertEquals("hello", CharSetUtils.delete("hello", new String[] { null })); 
     assertEquals("hello", CharSetUtils.delete("hello", new String[] { "xyz" })); 
     assertEquals("ho", CharSetUtils.delete("hello", new String[] { "el" })); 
     assertEquals("", CharSetUtils.delete("hello", new String[] { "elho" })); 
     assertEquals("hello", CharSetUtils.delete("hello", new String[] { "" })); 
     assertEquals("hello", CharSetUtils.delete("hello", "")); 
     assertEquals("", CharSetUtils.delete("hello", new String[] { "a-z" })); 
     assertEquals("", CharSetUtils.delete("----", new String[] { "-" })); 
     assertEquals("heo", CharSetUtils.delete("hello", new String[] { "l" })); 
 }
@Test
public void testDelete_StringStringarray7487() { 
     assertEquals(null, CharSetUtils.delete(null, (String[]) null)); 
     assertEquals(null, CharSetUtils.delete(null, new String[0])); 
     assertEquals(null, CharSetUtils.delete(null, new String[] { null })); 
     assertEquals(null, CharSetUtils.delete(null, new String[] { "el" })); 
     assertEquals("", CharSetUtils.delete("", (String[]) null)); 
     assertEquals("", CharSetUtils.delete("", new String[0])); 
     assertEquals("", CharSetUtils.delete("", new String[] { null })); 
     assertEquals("", CharSetUtils.delete("", new String[] { "a-e" })); 
     assertEquals("hello", CharSetUtils.delete("hello", (String[]) null)); 
     assertEquals("hello", CharSetUtils.delete("hello", new String[0])); 
     assertEquals("hello", CharSetUtils.delete("hello", new String[] { null })); 
     assertEquals("hello", CharSetUtils.delete("hello", new String[] { "xyz" })); 
     assertEquals("ho", CharSetUtils.delete("hello", new String[] { "el" })); 
     assertEquals("", CharSetUtils.delete("hello", new String[] { "elho" })); 
     assertEquals("hello", CharSetUtils.delete("hello", new String[] { "" })); 
     assertEquals("hello", CharSetUtils.delete("hello", "")); 
     assertEquals("", CharSetUtils.delete("hello", new String[] { "a-z" })); 
     assertEquals("", CharSetUtils.delete("----", new String[] { "-" })); 
     assertEquals("heo", CharSetUtils.delete("hello", new String[] { "l" })); 
 }
@Test
public void testCount_StringStringarray7651() { 
     assertEquals(0, CharSetUtils.count(null, (String[]) null)); 
     assertEquals(0, CharSetUtils.count(null, new String[0])); 
     assertEquals(0, CharSetUtils.count(null, new String[] { null })); 
     assertEquals(0, CharSetUtils.count(null, new String[] { "a-e" })); 
     assertEquals(0, CharSetUtils.count("", (String[]) null)); 
     assertEquals(0, CharSetUtils.count("", new String[0])); 
     assertEquals(0, CharSetUtils.count("", new String[] { null })); 
     assertEquals(0, CharSetUtils.count("", new String[] { "a-e" })); 
     assertEquals(0, CharSetUtils.count("hello", (String[]) null)); 
     assertEquals(0, CharSetUtils.count("hello", new String[0])); 
     assertEquals(0, CharSetUtils.count("hello", new String[] { null })); 
     assertEquals(1, CharSetUtils.count("hello", new String[] { "a-e" })); 
     assertEquals(3, CharSetUtils.count("hello", new String[] { "el" })); 
     assertEquals(0, CharSetUtils.count("hello", new String[] { "x" })); 
     assertEquals(2, CharSetUtils.count("hello", new String[] { "e-i" })); 
     assertEquals(5, CharSetUtils.count("hello", new String[] { "a-z" })); 
     assertEquals(0, CharSetUtils.count("hello", new String[] { "" })); 
 }
@Test
public void testDelete_StringStringarray7669() { 
     assertEquals(null, CharSetUtils.delete(null, (String[]) null)); 
     assertEquals(null, CharSetUtils.delete(null, new String[0])); 
     assertEquals(null, CharSetUtils.delete(null, new String[] { null })); 
     assertEquals(null, CharSetUtils.delete(null, new String[] { "el" })); 
     assertEquals("", CharSetUtils.delete("", (String[]) null)); 
     assertEquals("", CharSetUtils.delete("", new String[0])); 
     assertEquals("", CharSetUtils.delete("", new String[] { null })); 
     assertEquals("", CharSetUtils.delete("", new String[] { "a-e" })); 
     assertEquals("hello", CharSetUtils.delete("hello", (String[]) null)); 
     assertEquals("hello", CharSetUtils.delete("hello", new String[0])); 
     assertEquals("hello", CharSetUtils.delete("hello", new String[] { null })); 
     assertEquals("hello", CharSetUtils.delete("hello", new String[] { "xyz" })); 
     assertEquals("ho", CharSetUtils.delete("hello", new String[] { "el" })); 
     assertEquals("", CharSetUtils.delete("hello", new String[] { "elho" })); 
     assertEquals("hello", CharSetUtils.delete("hello", new String[] { "" })); 
     assertEquals("hello", CharSetUtils.delete("hello", "")); 
     assertEquals("", CharSetUtils.delete("hello", new String[] { "a-z" })); 
     assertEquals("", CharSetUtils.delete("----", new String[] { "-" })); 
     assertEquals("heo", CharSetUtils.delete("hello", new String[] { "l" })); 
 }
@Test
public void testDelete_StringStringarray7675() { 
     assertEquals(null, CharSetUtils.delete(null, (String[]) null)); 
     assertEquals(null, CharSetUtils.delete(null, new String[0])); 
     assertEquals(null, CharSetUtils.delete(null, new String[] { null })); 
     assertEquals(null, CharSetUtils.delete(null, new String[] { "el" })); 
     assertEquals("", CharSetUtils.delete("", (String[]) null)); 
     assertEquals("", CharSetUtils.delete("", new String[0])); 
     assertEquals("", CharSetUtils.delete("", new String[] { null })); 
     assertEquals("", CharSetUtils.delete("", new String[] { "a-e" })); 
     assertEquals("hello", CharSetUtils.delete("hello", (String[]) null)); 
     assertEquals("hello", CharSetUtils.delete("hello", new String[0])); 
     assertEquals("hello", CharSetUtils.delete("hello", new String[] { null })); 
     assertEquals("hello", CharSetUtils.delete("hello", new String[] { "xyz" })); 
     assertEquals("ho", CharSetUtils.delete("hello", new String[] { "el" })); 
     assertEquals("", CharSetUtils.delete("hello", new String[] { "elho" })); 
     assertEquals("hello", CharSetUtils.delete("hello", new String[] { "" })); 
     assertEquals("hello", CharSetUtils.delete("hello", "")); 
     assertEquals("", CharSetUtils.delete("hello", new String[] { "a-z" })); 
     assertEquals("", CharSetUtils.delete("----", new String[] { "-" })); 
     assertEquals("heo", CharSetUtils.delete("hello", new String[] { "l" })); 
 }
@Test
public void testDelete_StringStringarray7735() { 
     assertEquals(null, CharSetUtils.delete(null, (String[]) null)); 
     assertEquals(null, CharSetUtils.delete(null, new String[0])); 
     assertEquals(null, CharSetUtils.delete(null, new String[] { null })); 
     assertEquals(null, CharSetUtils.delete(null, new String[] { "el" })); 
     assertEquals("", CharSetUtils.delete("", (String[]) null)); 
     assertEquals("", CharSetUtils.delete("", new String[0])); 
     assertEquals("", CharSetUtils.delete("", new String[] { null })); 
     assertEquals("", CharSetUtils.delete("", new String[] { "a-e" })); 
     assertEquals("hello", CharSetUtils.delete("hello", (String[]) null)); 
     assertEquals("hello", CharSetUtils.delete("hello", new String[0])); 
     assertEquals("hello", CharSetUtils.delete("hello", new String[] { null })); 
     assertEquals("hello", CharSetUtils.delete("hello", new String[] { "xyz" })); 
     assertEquals("ho", CharSetUtils.delete("hello", new String[] { "el" })); 
     assertEquals("", CharSetUtils.delete("hello", new String[] { "elho" })); 
     assertEquals("hello", CharSetUtils.delete("hello", new String[] { "" })); 
     assertEquals("hello", CharSetUtils.delete("hello", "")); 
     assertEquals("", CharSetUtils.delete("hello", new String[] { "a-z" })); 
     assertEquals("", CharSetUtils.delete("----", new String[] { "-" })); 
     assertEquals("heo", CharSetUtils.delete("hello", new String[] { "l" })); 
 }
@Test
public void testDelete_StringStringarray7941() { 
     assertEquals(null, CharSetUtils.delete(null, (String[]) null)); 
     assertEquals(null, CharSetUtils.delete(null, new String[0])); 
     assertEquals(null, CharSetUtils.delete(null, new String[] { null })); 
     assertEquals(null, CharSetUtils.delete(null, new String[] { "el" })); 
     assertEquals("", CharSetUtils.delete("", (String[]) null)); 
     assertEquals("", CharSetUtils.delete("", new String[0])); 
     assertEquals("", CharSetUtils.delete("", new String[] { null })); 
     assertEquals("", CharSetUtils.delete("", new String[] { "a-e" })); 
     assertEquals("hello", CharSetUtils.delete("hello", (String[]) null)); 
     assertEquals("hello", CharSetUtils.delete("hello", new String[0])); 
     assertEquals("hello", CharSetUtils.delete("hello", new String[] { null })); 
     assertEquals("hello", CharSetUtils.delete("hello", new String[] { "xyz" })); 
     assertEquals("ho", CharSetUtils.delete("hello", new String[] { "el" })); 
     assertEquals("", CharSetUtils.delete("hello", new String[] { "elho" })); 
     assertEquals("hello", CharSetUtils.delete("hello", new String[] { "" })); 
     assertEquals("hello", CharSetUtils.delete("hello", "")); 
     assertEquals("", CharSetUtils.delete("hello", new String[] { "a-z" })); 
     assertEquals("", CharSetUtils.delete("----", new String[] { "-" })); 
     assertEquals("heo", CharSetUtils.delete("hello", new String[] { "l" })); 
 }
@Test
public void testDelete_StringStringarray8179() { 
     assertEquals(null, CharSetUtils.delete(null, (String[]) null)); 
     assertEquals(null, CharSetUtils.delete(null, new String[0])); 
     assertEquals(null, CharSetUtils.delete(null, new String[] { null })); 
     assertEquals(null, CharSetUtils.delete(null, new String[] { "el" })); 
     assertEquals("", CharSetUtils.delete("", (String[]) null)); 
     assertEquals("", CharSetUtils.delete("", new String[0])); 
     assertEquals("", CharSetUtils.delete("", new String[] { null })); 
     assertEquals("", CharSetUtils.delete("", new String[] { "a-e" })); 
     assertEquals("hello", CharSetUtils.delete("hello", (String[]) null)); 
     assertEquals("hello", CharSetUtils.delete("hello", new String[0])); 
     assertEquals("hello", CharSetUtils.delete("hello", new String[] { null })); 
     assertEquals("hello", CharSetUtils.delete("hello", new String[] { "xyz" })); 
     assertEquals("ho", CharSetUtils.delete("hello", new String[] { "el" })); 
     assertEquals("", CharSetUtils.delete("hello", new String[] { "elho" })); 
     assertEquals("hello", CharSetUtils.delete("hello", new String[] { "" })); 
     assertEquals("hello", CharSetUtils.delete("hello", "")); 
     assertEquals("", CharSetUtils.delete("hello", new String[] { "a-z" })); 
     assertEquals("", CharSetUtils.delete("----", new String[] { "-" })); 
     assertEquals("heo", CharSetUtils.delete("hello", new String[] { "l" })); 
 }
@Test
public void testContainsAny_StringString8212() { 
     assertFalse(CharSetUtils.containsAny(null, (String) null)); 
     assertFalse(CharSetUtils.containsAny(null, "")); 
     assertFalse(CharSetUtils.containsAny("", (String) null)); 
     assertFalse(CharSetUtils.containsAny("", "")); 
     assertFalse(CharSetUtils.containsAny("", "a-e")); 
     assertFalse(CharSetUtils.containsAny("hello", (String) null)); 
     assertFalse(CharSetUtils.containsAny("hello", "")); 
     assertTrue(CharSetUtils.containsAny("hello", "a-e")); 
     assertTrue(CharSetUtils.containsAny("hello", "l-p")); 
 }
@Test
public void testDelete_StringStringarray8223() { 
     assertEquals(null, CharSetUtils.delete(null, (String[]) null)); 
     assertEquals(null, CharSetUtils.delete(null, new String[0])); 
     assertEquals(null, CharSetUtils.delete(null, new String[] { null })); 
     assertEquals(null, CharSetUtils.delete(null, new String[] { "el" })); 
     assertEquals("", CharSetUtils.delete("", (String[]) null)); 
     assertEquals("", CharSetUtils.delete("", new String[0])); 
     assertEquals("", CharSetUtils.delete("", new String[] { null })); 
     assertEquals("", CharSetUtils.delete("", new String[] { "a-e" })); 
     assertEquals("hello", CharSetUtils.delete("hello", (String[]) null)); 
     assertEquals("hello", CharSetUtils.delete("hello", new String[0])); 
     assertEquals("hello", CharSetUtils.delete("hello", new String[] { null })); 
     assertEquals("hello", CharSetUtils.delete("hello", new String[] { "xyz" })); 
     assertEquals("ho", CharSetUtils.delete("hello", new String[] { "el" })); 
     assertEquals("", CharSetUtils.delete("hello", new String[] { "elho" })); 
     assertEquals("hello", CharSetUtils.delete("hello", new String[] { "" })); 
     assertEquals("hello", CharSetUtils.delete("hello", "")); 
     assertEquals("", CharSetUtils.delete("hello", new String[] { "a-z" })); 
     assertEquals("", CharSetUtils.delete("----", new String[] { "-" })); 
     assertEquals("heo", CharSetUtils.delete("hello", new String[] { "l" })); 
 }
@Test
public void testDelete_StringStringarray8283() { 
     assertEquals(null, CharSetUtils.delete(null, (String[]) null)); 
     assertEquals(null, CharSetUtils.delete(null, new String[0])); 
     assertEquals(null, CharSetUtils.delete(null, new String[] { null })); 
     assertEquals(null, CharSetUtils.delete(null, new String[] { "el" })); 
     assertEquals("", CharSetUtils.delete("", (String[]) null)); 
     assertEquals("", CharSetUtils.delete("", new String[0])); 
     assertEquals("", CharSetUtils.delete("", new String[] { null })); 
     assertEquals("", CharSetUtils.delete("", new String[] { "a-e" })); 
     assertEquals("hello", CharSetUtils.delete("hello", (String[]) null)); 
     assertEquals("hello", CharSetUtils.delete("hello", new String[0])); 
     assertEquals("hello", CharSetUtils.delete("hello", new String[] { null })); 
     assertEquals("hello", CharSetUtils.delete("hello", new String[] { "xyz" })); 
     assertEquals("ho", CharSetUtils.delete("hello", new String[] { "el" })); 
     assertEquals("", CharSetUtils.delete("hello", new String[] { "elho" })); 
     assertEquals("hello", CharSetUtils.delete("hello", new String[] { "" })); 
     assertEquals("hello", CharSetUtils.delete("hello", "")); 
     assertEquals("", CharSetUtils.delete("hello", new String[] { "a-z" })); 
     assertEquals("", CharSetUtils.delete("----", new String[] { "-" })); 
     assertEquals("heo", CharSetUtils.delete("hello", new String[] { "l" })); 
 }
@Test
public void testDelete_StringStringarray8311() { 
     assertEquals(null, CharSetUtils.delete(null, (String[]) null)); 
     assertEquals(null, CharSetUtils.delete(null, new String[0])); 
     assertEquals(null, CharSetUtils.delete(null, new String[] { null })); 
     assertEquals(null, CharSetUtils.delete(null, new String[] { "el" })); 
     assertEquals("", CharSetUtils.delete("", (String[]) null)); 
     assertEquals("", CharSetUtils.delete("", new String[0])); 
     assertEquals("", CharSetUtils.delete("", new String[] { null })); 
     assertEquals("", CharSetUtils.delete("", new String[] { "a-e" })); 
     assertEquals("hello", CharSetUtils.delete("hello", (String[]) null)); 
     assertEquals("hello", CharSetUtils.delete("hello", new String[0])); 
     assertEquals("hello", CharSetUtils.delete("hello", new String[] { null })); 
     assertEquals("hello", CharSetUtils.delete("hello", new String[] { "xyz" })); 
     assertEquals("ho", CharSetUtils.delete("hello", new String[] { "el" })); 
     assertEquals("", CharSetUtils.delete("hello", new String[] { "elho" })); 
     assertEquals("hello", CharSetUtils.delete("hello", new String[] { "" })); 
     assertEquals("hello", CharSetUtils.delete("hello", "")); 
     assertEquals("", CharSetUtils.delete("hello", new String[] { "a-z" })); 
     assertEquals("", CharSetUtils.delete("----", new String[] { "-" })); 
     assertEquals("heo", CharSetUtils.delete("hello", new String[] { "l" })); 
 }
@Test
public void testDelete_StringStringarray8323() { 
     assertEquals(null, CharSetUtils.delete(null, (String[]) null)); 
     assertEquals(null, CharSetUtils.delete(null, new String[0])); 
     assertEquals(null, CharSetUtils.delete(null, new String[] { null })); 
     assertEquals(null, CharSetUtils.delete(null, new String[] { "el" })); 
     assertEquals("", CharSetUtils.delete("", (String[]) null)); 
     assertEquals("", CharSetUtils.delete("", new String[0])); 
     assertEquals("", CharSetUtils.delete("", new String[] { null })); 
     assertEquals("", CharSetUtils.delete("", new String[] { "a-e" })); 
     assertEquals("hello", CharSetUtils.delete("hello", (String[]) null)); 
     assertEquals("hello", CharSetUtils.delete("hello", new String[0])); 
     assertEquals("hello", CharSetUtils.delete("hello", new String[] { null })); 
     assertEquals("hello", CharSetUtils.delete("hello", new String[] { "xyz" })); 
     assertEquals("ho", CharSetUtils.delete("hello", new String[] { "el" })); 
     assertEquals("", CharSetUtils.delete("hello", new String[] { "elho" })); 
     assertEquals("hello", CharSetUtils.delete("hello", new String[] { "" })); 
     assertEquals("hello", CharSetUtils.delete("hello", "")); 
     assertEquals("", CharSetUtils.delete("hello", new String[] { "a-z" })); 
     assertEquals("", CharSetUtils.delete("----", new String[] { "-" })); 
     assertEquals("heo", CharSetUtils.delete("hello", new String[] { "l" })); 
 }
@Test
public void testCount_StringStringarray8525() { 
     assertEquals(0, CharSetUtils.count(null, (String[]) null)); 
     assertEquals(0, CharSetUtils.count(null, new String[0])); 
     assertEquals(0, CharSetUtils.count(null, new String[] { null })); 
     assertEquals(0, CharSetUtils.count(null, new String[] { "a-e" })); 
     assertEquals(0, CharSetUtils.count("", (String[]) null)); 
     assertEquals(0, CharSetUtils.count("", new String[0])); 
     assertEquals(0, CharSetUtils.count("", new String[] { null })); 
     assertEquals(0, CharSetUtils.count("", new String[] { "a-e" })); 
     assertEquals(0, CharSetUtils.count("hello", (String[]) null)); 
     assertEquals(0, CharSetUtils.count("hello", new String[0])); 
     assertEquals(0, CharSetUtils.count("hello", new String[] { null })); 
     assertEquals(1, CharSetUtils.count("hello", new String[] { "a-e" })); 
     assertEquals(3, CharSetUtils.count("hello", new String[] { "el" })); 
     assertEquals(0, CharSetUtils.count("hello", new String[] { "x" })); 
     assertEquals(2, CharSetUtils.count("hello", new String[] { "e-i" })); 
     assertEquals(5, CharSetUtils.count("hello", new String[] { "a-z" })); 
     assertEquals(0, CharSetUtils.count("hello", new String[] { "" })); 
 }
@Test
public void testDelete_StringStringarray8715() { 
     assertEquals(null, CharSetUtils.delete(null, (String[]) null)); 
     assertEquals(null, CharSetUtils.delete(null, new String[0])); 
     assertEquals(null, CharSetUtils.delete(null, new String[] { null })); 
     assertEquals(null, CharSetUtils.delete(null, new String[] { "el" })); 
     assertEquals("", CharSetUtils.delete("", (String[]) null)); 
     assertEquals("", CharSetUtils.delete("", new String[0])); 
     assertEquals("", CharSetUtils.delete("", new String[] { null })); 
     assertEquals("", CharSetUtils.delete("", new String[] { "a-e" })); 
     assertEquals("hello", CharSetUtils.delete("hello", (String[]) null)); 
     assertEquals("hello", CharSetUtils.delete("hello", new String[0])); 
     assertEquals("hello", CharSetUtils.delete("hello", new String[] { null })); 
     assertEquals("hello", CharSetUtils.delete("hello", new String[] { "xyz" })); 
     assertEquals("ho", CharSetUtils.delete("hello", new String[] { "el" })); 
     assertEquals("", CharSetUtils.delete("hello", new String[] { "elho" })); 
     assertEquals("hello", CharSetUtils.delete("hello", new String[] { "" })); 
     assertEquals("hello", CharSetUtils.delete("hello", "")); 
     assertEquals("", CharSetUtils.delete("hello", new String[] { "a-z" })); 
     assertEquals("", CharSetUtils.delete("----", new String[] { "-" })); 
     assertEquals("heo", CharSetUtils.delete("hello", new String[] { "l" })); 
 }
@Test
public void testDelete_StringStringarray8950() { 
     assertEquals(null, CharSetUtils.delete(null, (String[]) null)); 
     assertEquals(null, CharSetUtils.delete(null, new String[0])); 
     assertEquals(null, CharSetUtils.delete(null, new String[] { null })); 
     assertEquals(null, CharSetUtils.delete(null, new String[] { "el" })); 
     assertEquals("", CharSetUtils.delete("", (String[]) null)); 
     assertEquals("", CharSetUtils.delete("", new String[0])); 
     assertEquals("", CharSetUtils.delete("", new String[] { null })); 
     assertEquals("", CharSetUtils.delete("", new String[] { "a-e" })); 
     assertEquals("hello", CharSetUtils.delete("hello", (String[]) null)); 
     assertEquals("hello", CharSetUtils.delete("hello", new String[0])); 
     assertEquals("hello", CharSetUtils.delete("hello", new String[] { null })); 
     assertEquals("hello", CharSetUtils.delete("hello", new String[] { "xyz" })); 
     assertEquals("ho", CharSetUtils.delete("hello", new String[] { "el" })); 
     assertEquals("", CharSetUtils.delete("hello", new String[] { "elho" })); 
     assertEquals("hello", CharSetUtils.delete("hello", new String[] { "" })); 
     assertEquals("hello", CharSetUtils.delete("hello", "")); 
     assertEquals("", CharSetUtils.delete("hello", new String[] { "a-z" })); 
     assertEquals("", CharSetUtils.delete("----", new String[] { "-" })); 
     assertEquals("heo", CharSetUtils.delete("hello", new String[] { "l" })); 
 }
@Test
public void testCount_StringStringarray9124() { 
     assertEquals(0, CharSetUtils.count(null, (String[]) null)); 
     assertEquals(0, CharSetUtils.count(null, new String[0])); 
     assertEquals(0, CharSetUtils.count(null, new String[] { null })); 
     assertEquals(0, CharSetUtils.count(null, new String[] { "a-e" })); 
     assertEquals(0, CharSetUtils.count("", (String[]) null)); 
     assertEquals(0, CharSetUtils.count("", new String[0])); 
     assertEquals(0, CharSetUtils.count("", new String[] { null })); 
     assertEquals(0, CharSetUtils.count("", new String[] { "a-e" })); 
     assertEquals(0, CharSetUtils.count("hello", (String[]) null)); 
     assertEquals(0, CharSetUtils.count("hello", new String[0])); 
     assertEquals(0, CharSetUtils.count("hello", new String[] { null })); 
     assertEquals(1, CharSetUtils.count("hello", new String[] { "a-e" })); 
     assertEquals(3, CharSetUtils.count("hello", new String[] { "el" })); 
     assertEquals(0, CharSetUtils.count("hello", new String[] { "x" })); 
     assertEquals(2, CharSetUtils.count("hello", new String[] { "e-i" })); 
     assertEquals(5, CharSetUtils.count("hello", new String[] { "a-z" })); 
     assertEquals(0, CharSetUtils.count("hello", new String[] { "" })); 
 }
@Test
public void testContainsAny_StringString9384() { 
     assertFalse(CharSetUtils.containsAny(null, (String) null)); 
     assertFalse(CharSetUtils.containsAny(null, "")); 
     assertFalse(CharSetUtils.containsAny("", (String) null)); 
     assertFalse(CharSetUtils.containsAny("", "")); 
     assertFalse(CharSetUtils.containsAny("", "a-e")); 
     assertFalse(CharSetUtils.containsAny("hello", (String) null)); 
     assertFalse(CharSetUtils.containsAny("hello", "")); 
     assertTrue(CharSetUtils.containsAny("hello", "a-e")); 
     assertTrue(CharSetUtils.containsAny("hello", "l-p")); 
 }
    
    
    //-----------------------------------------------------------------------
    
    
    

    //-----------------------------------------------------------------------
    
    
    

    //-----------------------------------------------------------------------
    
    
    

    //-----------------------------------------------------------------------
    
    
    

    //-----------------------------------------------------------------------
    
    
    
    
}
