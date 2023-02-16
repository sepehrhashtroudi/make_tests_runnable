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
public void testConstructor_String_simple332() { 
     CharSet set; 
     CharRange[] array; 
     set = CharSet.getInstance((String) null); 
     array = set.getCharRanges(); 
     assertEquals("[]", set.toString()); 
     assertEquals(0, array.length); 
     set = CharSet.getInstance(""); 
     array = set.getCharRanges(); 
     assertEquals("[]", set.toString()); 
     assertEquals(0, array.length); 
     set = CharSet.getInstance("a"); 
     array = set.getCharRanges(); 
     assertEquals("[a]", set.toString()); 
     assertEquals(1, array.length); 
     assertEquals("a", array[0].toString()); 
     set = CharSet.getInstance("^a"); 
     array = set.getCharRanges(); 
     assertEquals("[^a]", set.toString()); 
     assertEquals(1, array.length); 
     assertEquals("^a", array[0].toString()); 
     set = CharSet.getInstance("a-e"); 
     array = set.getCharRanges(); 
     assertEquals("[a-e]", set.toString()); 
     assertEquals(1, array.length); 
     assertEquals("a-e", array[0].toString()); 
     set = CharSet.getInstance("^a-e"); 
     array = set.getCharRanges(); 
     assertEquals("[^a-e]", set.toString()); 
     assertEquals(1, array.length); 
     assertEquals("^a-e", array[0].toString()); 
 }
@Test
public void testConstructor460() { 
     assertNotNull(new CharSetUtils()); 
     final Constructor<?>[] cons = CharSetUtils.class.getDeclaredConstructors(); 
     assertEquals(1, cons.length); 
     assertTrue(Modifier.isPublic(cons[0].getModifiers())); 
     assertTrue(Modifier.isPublic(CharSetUtils.class.getModifiers())); 
     assertFalse(Modifier.isFinal(CharSetUtils.class.getModifiers())); 
 }
@Test
public void testCount_StringString461() { 
     assertEquals(0, CharSetUtils.count(null, (String) null)); 
     assertEquals(0, CharSetUtils.count(null, "")); 
     assertEquals("", CharSetUtils.count("", (String) null)); 
     assertEquals("", CharSetUtils.count("", "")); 
     assertEquals("", CharSetUtils.count("", "a-e")); 
     assertEquals("", CharSetUtils.count("hello", (String) null)); 
     assertEquals("", CharSetUtils.count("hello", "")); 
     assertEquals("", CharSetUtils.count("hello", "xyz")); 
     assertEquals(3, CharSetUtils.count("hello", "a-z")); 
     assertEquals("hello", CharSetUtils.count("hello", "oleh")); 
     assertEquals("ell", CharSetUtils.count("hello", "el")); 
 }
@Test
public void testDelete_StringString462() { 
     assertEquals(null, CharSetUtils.delete(null, (String) null)); 
     assertEquals(null, CharSetUtils.delete(null, "")); 
     assertEquals("", CharSetUtils.delete("", (String) null)); 
     assertEquals("", CharSetUtils.delete("", "")); 
     assertEquals("", CharSetUtils.delete("", "a-e")); 
     assertEquals("", CharSetUtils.delete("hello", (String) null)); 
     assertEquals("", CharSetUtils.delete("hello", "")); 
     assertEquals("", CharSetUtils.delete("hello", "xyz")); 
     assertEquals("hello", CharSetUtils.delete("hello", "a-z")); 
     assertEquals("hello", CharSetUtils.delete("hello", "oleh")); 
     assertEquals("ell", CharSetUtils.delete("hello", "el")); 
 }
@Test
public void testContainsAny_StringString464() { 
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
