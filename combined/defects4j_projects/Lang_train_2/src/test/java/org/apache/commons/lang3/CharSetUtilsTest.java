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
public void testDelete_StringString741() { 
     assertEquals(null, CharSetUtils.delete(null, (String) null)); 
     assertEquals(null, CharSetUtils.delete(null, "")); 
     assertEquals("", CharSetUtils.delete("", (String) null)); 
     assertEquals("", CharSetUtils.delete("", "")); 
     assertEquals("", CharSetUtils.delete("", "a-e")); 
     assertEquals("hello", CharSetUtils.delete("hello", (String) null)); 
     assertEquals("hello", CharSetUtils.delete("hello", "")); 
     assertEquals("hllo", CharSetUtils.delete("hello", "a-e")); 
     assertEquals("he", CharSetUtils.delete("hello", "l-p")); 
     assertEquals("hello", CharSetUtils.delete("hello", "z")); 
 }
@Test
public void testConstructor922() { 
     assertNotNull(new CharSetUtils()); 
     final Constructor<?>[] cons = CharSetUtils.class.getDeclaredConstructors(); 
     assertEquals(1, cons.length); 
     assertTrue(Modifier.isPublic(cons[0].getModifiers())); 
     assertTrue(Modifier.isPublic(CharSetUtils.class.getModifiers())); 
     assertFalse(Modifier.isFinal(CharSetUtils.class.getModifiers())); 
 }
@Test
public void testContainsAny_StringString923() { 
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
public void testContainsAny_StringStringarray924() { 
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
public void testCount_StringString925() { 
     assertEquals(0, CharSetUtils.count(null, (String) null)); 
     assertEquals(0, CharSetUtils.count(null, "")); 
     assertEquals(0, CharSetUtils.count("", (String) null)); 
     assertEquals(0, CharSetUtils.count("", "")); 
     assertEquals(0, CharSetUtils.count("", "a-e")); 
     assertEquals(0, CharSetUtils.count("hello", (String) null)); 
     assertEquals(0, CharSetUtils.count("hello", "")); 
     assertEquals(1, CharSetUtils.count("hello", "a-e")); 
     assertEquals(3, CharSetUtils.count("hello", "l-p")); 
 }
@Test
public void testKeep_StringString926() { 
     assertEquals(null, CharSetUtils.keep(null, (String) null)); 
     assertEquals(null, CharSetUtils.keep(null, "")); 
     assertEquals("", CharSetUtils.keep("", (String) null)); 
     assertEquals("", CharSetUtils.keep("", "")); 
     assertEquals("", CharSetUtils.keep("", "a-e")); 
     assertEquals("", CharSetUtils.keep("hello", (String) null)); 
     assertEquals("", CharSetUtils.keep("hello", "")); 
     assertEquals("", CharSetUtils.keep("hello", "xyz")); 
     assertEquals("hello", CharSetUtils.keep("hello", "a-z")); 
     assertEquals("hello", CharSetUtils.keep("hello", "oleh")); 
     assertEquals("ell", CharSetUtils.keep("hello", "el")); 
 }
    
    
    //-----------------------------------------------------------------------
    
    
    

    //-----------------------------------------------------------------------
    
    
    

    //-----------------------------------------------------------------------
    
    
    

    //-----------------------------------------------------------------------
    
    
    

    //-----------------------------------------------------------------------
    
    
    
    
}
