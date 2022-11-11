/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.apache.commons.lang3;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

/**
 * Unit tests {@link org.apache.commons.lang3.Validate}.
 *
 * @version $Id$
 */
public class ValidateTest  {
    
    //-----------------------------------------------------------------------
@Test
public void testNoNullElementsArray244() { 
     String[] array = new String[] { "a", "b" }; 
     Validate.noNullElements(array, "MSG"); 
     try { 
         Validate.noNullElements((Object[]) null, "MSG"); 
         fail("Expecting NullPointerException"); 
     } catch (final NullPointerException ex) { 
         assertEquals("The validated object is null", ex.getMessage()); 
     } 
     array[1] = null; 
     try { 
         Validate.noNullElements(array, "MSG"); 
         fail("Expecting IllegalArgumentException"); 
     } catch (final IllegalArgumentException ex) { 
         assertEquals("MSG", ex.getMessage()); 
     } 
     array = new String[] { "a", "b" }; 
     final String[] test = Validate.noNullElements(array, "Message"); 
     assertSame(array, test); 
 }
@Test
public void testExclusiveBetween_withMessage96() { 
     Validate.exclusiveBetween("a", "c", "b", "Error"); 
     Validate.exclusiveBetween(0, 2, 1, "Error"); 
     try { 
         Validate.exclusiveBetween(0, 5, 6, "Error"); 
         fail("Expecting IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
         assertEquals("Error", e.getMessage()); 
     } 
     try { 
         Validate.exclusiveBetween(0, 5, 5, "Error"); 
         fail("Expecting IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
         assertEquals("Error", e.getMessage()); 
     } 
 }
@Test
public void testMatchesPattern156() { 
     final CharSequence str = "hi"; 
     Validate.matchesPattern(str, "[a-z]*"); 
     try { 
         Validate.matchesPattern(str, "[0-9]*"); 
         fail("Expecting IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
         assertEquals("The string hi does not match the pattern [0-9]*", e.getMessage()); 
     } 
 }
@Test
public void testNoNullElementsArray2159() { 
     String[] array = new String[] { "a", "b" }; 
     Validate.noNullElements(array, "MSG"); 
     try { 
         Validate.noNullElements((Object[]) null, "MSG"); 
         fail("Expecting NullPointerException"); 
     } catch (final NullPointerException ex) { 
         assertEquals("The validated object is null", ex.getMessage()); 
     } 
     array[1] = null; 
     try { 
         Validate.noNullElements(array, "MSG"); 
         fail("Expecting IllegalArgumentException"); 
     } catch (final IllegalArgumentException ex) { 
         assertEquals("MSG", ex.getMessage()); 
     } 
     array = new String[] { "a", "b" }; 
     final String[] test = Validate.noNullElements(array, "Message"); 
     assertSame(array, test); 
 }
@Test
public void testNotEmptyString1160() { 
     Validate.notEmpty("hjl"); 
     try { 
         Validate.notEmpty((String) null); 
         fail("Expecting NullPointerException"); 
     } catch (final NullPointerException ex) { 
         assertEquals("The validated character sequence is empty", ex.getMessage()); 
     } 
     try { 
         Validate.notEmpty(""); 
         fail("Expecting IllegalArgumentException"); 
     } catch (final IllegalArgumentException ex) { 
         assertEquals("The validated character sequence is empty", ex.getMessage()); 
     } 
     final String str = "Hi"; 
     final String testStr = Validate.notEmpty(str); 
     assertSame(str, testStr); 
 }
@Test
public void testValidIndex_array194() { 
     final Object[] array = new Object[2]; 
     Validate.validIndex(array, 0); 
     Validate.validIndex(array, 1); 
     try { 
         Validate.validIndex(array, -1); 
         fail("Expecting IndexOutOfBoundsException"); 
     } catch (final IndexOutOfBoundsException ex) { 
         assertEquals("The validated array index is invalid: -1", ex.getMessage()); 
     } 
     try { 
         Validate.validIndex(array, 2); 
         fail("Expecting IndexOutOfBoundsException"); 
     } catch (final IndexOutOfBoundsException ex) { 
         assertEquals("The validated array index is invalid: 2", ex.getMessage()); 
     } 
     final String[] strArray = new String[] { "Hi" }; 
     final String[] test = Validate.noNullElements(strArray); 
     assertSame(strArray, test); 
 }
@Test
public void testNoNullElementsArray2228() { 
     String[] array = new String[] { "a", "b" }; 
     Validate.noNullElements(array, "MSG"); 
     try { 
         Validate.noNullElements((Object[]) null, "MSG"); 
         fail("Expecting NullPointerException"); 
     } catch (final NullPointerException ex) { 
         assertEquals("The validated object is null", ex.getMessage()); 
     } 
     array[1] = null; 
     try { 
         Validate.noNullElements(array, "MSG"); 
         fail("Expecting IllegalArgumentException"); 
     } catch (final IllegalArgumentException ex) { 
         assertEquals("MSG", ex.getMessage()); 
     } 
     array = new String[] { "a", "b" }; 
     final String[] test = Validate.noNullElements(array, "Message"); 
     assertSame(array, test); 
 }
@Test
public void testNoNullElementsCollection1243() { 
     final List<String> coll = new ArrayList<String>(); 
     coll.add("a"); 
     coll.add("b"); 
     Validate.noNullElements(coll); 
     try { 
         Validate.noNullElements((Collection<?>) null); 
         fail("Expecting NullPointerException"); 
     } catch (final NullPointerException ex) { 
         assertEquals("The validated object is null", ex.getMessage()); 
     } 
     coll.set(1, null); 
     try { 
         Validate.noNullElements(coll); 
         fail("Expecting IllegalArgumentException"); 
     } catch (final IllegalArgumentException ex) { 
         assertEquals("The validated collection contains null element at index: 1", ex.getMessage()); 
     } 
     coll.set(1, "b"); 
     final List<String> test = Validate.noNullElements(coll); 
     assertSame(coll, test); 
 }
@Test
public void testNoNullElementsCollection1262() { 
     final List<String> coll = new ArrayList<String>(); 
     coll.add("a"); 
     coll.add("b"); 
     Validate.noNullElements(coll); 
     try { 
         Validate.noNullElements((Collection<?>) null); 
         fail("Expecting NullPointerException"); 
     } catch (final NullPointerException ex) { 
         assertEquals("The validated object is null", ex.getMessage()); 
     } 
     coll.set(1, null); 
     try { 
         Validate.noNullElements(coll); 
         fail("Expecting IllegalArgumentException"); 
     } catch (final IllegalArgumentException ex) { 
         assertEquals("The validated collection contains null element at index: 1", ex.getMessage()); 
     } 
     coll.set(1, "b"); 
     final List<String> test = Validate.noNullElements(coll); 
     assertSame(coll, test); 
 }
@Test
public void testConstructor280() { 
     assertNotNull(new Validate()); 
     final Constructor<?>[] cons = Validate.class.getDeclaredConstructors(); 
     assertEquals(1, cons.length); 
     assertTrue(Modifier.isPublic(cons[0].getModifiers())); 
     assertTrue(Modifier.isPublic(Validate.class.getModifiers())); 
     assertFalse(Modifier.isFinal(Validate.class.getModifiers())); 
 }
@Test
public void testNotEmptyMap2340() { 
     final Map<String, Integer> map = new HashMap<String, Integer>(); 
     try { 
         Validate.notEmpty((Map<?, ?>) null, "MSG"); 
         fail("Expecting NullPointerException"); 
     } catch (final NullPointerException ex) { 
         assertEquals("MSG", ex.getMessage()); 
     } 
     try { 
         Validate.notEmpty(map, "MSG"); 
         fail("Expecting IllegalArgumentException"); 
     } catch (final IllegalArgumentException ex) { 
         assertEquals("MSG", ex.getMessage()); 
     } 
     map.put("ll", Integer.valueOf(8)); 
     Validate.notEmpty(map, "MSG"); 
     final Map<String, Integer> test = Validate.notEmpty(map, "Message"); 
     assertSame(map, test); 
 }
@Test
public void testNoNullElementsArray1368() { 
     String[] array = new String[] { "a", "b" }; 
     Validate.noNullElements(array); 
     try { 
         Validate.noNullElements((Object[]) null); 
         fail("Expecting NullPointerException"); 
     } catch (final NullPointerException ex) { 
         assertEquals("The validated object is null", ex.getMessage()); 
     } 
     array[1] = null; 
     try { 
         Validate.noNullElements(array); 
         fail("Expecting IllegalArgumentException"); 
     } catch (final IllegalArgumentException ex) { 
         assertEquals("The validated array contains null element at index: 1", ex.getMessage()); 
     } 
     array = new String[] { "a", "b" }; 
     final String[] test = Validate.noNullElements(array); 
     assertSame(array, test); 
 }
@Test
public void testNoNullElementsArray2459() { 
     String[] array = new String[] { "a", "b" }; 
     Validate.noNullElements(array, "MSG"); 
     try { 
         Validate.noNullElements((Object[]) null, "MSG"); 
         fail("Expecting NullPointerException"); 
     } catch (final NullPointerException ex) { 
         assertEquals("The validated object is null", ex.getMessage()); 
     } 
     array[1] = null; 
     try { 
         Validate.noNullElements(array, "MSG"); 
         fail("Expecting IllegalArgumentException"); 
     } catch (final IllegalArgumentException ex) { 
         assertEquals("MSG", ex.getMessage()); 
     } 
     array = new String[] { "a", "b" }; 
     final String[] test = Validate.noNullElements(array, "Message"); 
     assertSame(array, test); 
 }
@Test
public void testNotEmptyArray1464() { 
     Validate.notEmpty(new Object[] { null }); 
     try { 
         Validate.notEmpty((Object[]) null); 
         fail("Expecting NullPointerException"); 
     } catch (final NullPointerException ex) { 
         assertEquals("The validated array is empty", ex.getMessage()); 
     } 
     try { 
         Validate.notEmpty(new Object[0]); 
         fail("Expecting IllegalArgumentException"); 
     } catch (final IllegalArgumentException ex) { 
         assertEquals("The validated array is empty", ex.getMessage()); 
     } 
     final String[] array = new String[] { "hi" }; 
     final String[] test = Validate.notEmpty(array); 
     assertSame(array, test); 
 }
@Test
public void testValidIndex_collection529() { 
     final Collection<String> coll = new ArrayList<String>(); 
     coll.add(null); 
     coll.add(null); 
     Validate.validIndex(coll, 0); 
     Validate.validIndex(coll, 1); 
     try { 
         Validate.validIndex(coll, -1); 
         fail("Expecting IndexOutOfBoundsException"); 
     } catch (final IndexOutOfBoundsException ex) { 
         assertEquals("The validated collection index is invalid: -1", ex.getMessage()); 
     } 
     try { 
         Validate.validIndex(coll, 2); 
         fail("Expecting IndexOutOfBoundsException"); 
     } catch (final IndexOutOfBoundsException ex) { 
         assertEquals("The validated collection index is invalid: 2", ex.getMessage()); 
     } 
     final List<String> strColl = Arrays.asList(new String[] { "Hi" }); 
     final List<String> test = Validate.validIndex(strColl, 0); 
     assertSame(strColl, test); 
 }
@Test
public void testNotEmptyCollection1585() { 
     final Collection<Integer> coll = new ArrayList<Integer>(); 
     try { 
         Validate.notEmpty((Collection<?>) null); 
         fail("Expecting NullPointerException"); 
     } catch (final NullPointerException ex) { 
         assertEquals("The validated collection is empty", ex.getMessage()); 
     } 
     try { 
         Validate.notEmpty(coll); 
         fail("Expecting IllegalArgumentException"); 
     } catch (final IllegalArgumentException ex) { 
         assertEquals("The validated collection is empty", ex.getMessage()); 
     } 
     coll.add(Integer.valueOf(8)); 
     Validate.notEmpty(coll); 
     final Collection<Integer> test = Validate.notEmpty(coll); 
     assertSame(coll, test); 
 }
@Test
public void testNoNullElementsCollection1768() { 
     final List<String> coll = new ArrayList<String>(); 
     coll.add("a"); 
     coll.add("b"); 
     Validate.noNullElements(coll); 
     try { 
         Validate.noNullElements((Collection<?>) null); 
         fail("Expecting NullPointerException"); 
     } catch (final NullPointerException ex) { 
         assertEquals("The validated object is null", ex.getMessage()); 
     } 
     coll.set(1, null); 
     try { 
         Validate.noNullElements(coll); 
         fail("Expecting IllegalArgumentException"); 
     } catch (final IllegalArgumentException ex) { 
         assertEquals("The validated collection contains null element at index: 1", ex.getMessage()); 
     } 
     coll.set(1, "b"); 
     final List<String> test = Validate.noNullElements(coll); 
     assertSame(coll, test); 
 }
@Test
public void testIsTrue5784() { 
     Validate.isTrue(true, "MSG", 7.4d); 
     try { 
         Validate.isTrue(false, "MSG", 7.4d); 
         fail("Expecting IllegalArgumentException"); 
     } catch (final IllegalArgumentException ex) { 
         assertEquals("MSG", ex.getMessage()); 
     } 
 }
@Test
public void testNotBlankNotBlankStringShouldNotThrow957() { 
     final String string = "abc"; 
     Validate.notBlank(string); 
 }
@Test
public void testNotEmptyMap21015() { 
     final Map<String, Integer> map = new HashMap<String, Integer>(); 
     try { 
         Validate.notEmpty((Map<?, ?>) null, "MSG"); 
         fail("Expecting NullPointerException"); 
     } catch (final NullPointerException ex) { 
         assertEquals("MSG", ex.getMessage()); 
     } 
     try { 
         Validate.notEmpty(map, "MSG"); 
         fail("Expecting IllegalArgumentException"); 
     } catch (final IllegalArgumentException ex) { 
         assertEquals("MSG", ex.getMessage()); 
     } 
     map.put("ll", Integer.valueOf(8)); 
     Validate.notEmpty(map, "MSG"); 
     final Map<String, Integer> test = Validate.notEmpty(map, "Message"); 
     assertSame(map, test); 
 }
@Test
public void testIsTrue21023() { 
     Validate.isTrue(true, "MSG"); 
     try { 
         Validate.isTrue(false, "MSG"); 
         fail("Expecting IllegalArgumentException"); 
     } catch (final IllegalArgumentException ex) { 
         assertEquals("MSG", ex.getMessage()); 
     } 
 }
@Test
public void testNotBlankMsgNotBlankStringWithWhitespacesShouldNotThrow1038() { 
     final String string = "  abc   "; 
     Validate.notBlank(string, "Message"); 
 }
@Test
public void testExclusiveBetween_withMessage1178() { 
     Validate.exclusiveBetween("a", "c", "b", "Error"); 
     Validate.exclusiveBetween(0, 2, 1, "Error"); 
     try { 
         Validate.exclusiveBetween(0, 5, 6, "Error"); 
         fail("Expecting IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
         assertEquals("Error", e.getMessage()); 
     } 
     try { 
         Validate.exclusiveBetween(0, 5, 5, "Error"); 
         fail("Expecting IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
         assertEquals("Error", e.getMessage()); 
     } 
 }
@Test
public void testIsTrue41199() { 
     Validate.isTrue(true, "MSG", 7); 
     try { 
         Validate.isTrue(false, "MSG", 7); 
         fail("Expecting IllegalArgumentException"); 
     } catch (final IllegalArgumentException ex) { 
         assertEquals("MSG", ex.getMessage()); 
     } 
 }
@Test
public void testNotEmptyCollection11268() { 
     final Collection<Integer> coll = new ArrayList<Integer>(); 
     try { 
         Validate.notEmpty((Collection<?>) null); 
         fail("Expecting NullPointerException"); 
     } catch (final NullPointerException ex) { 
         assertEquals("The validated collection is empty", ex.getMessage()); 
     } 
     try { 
         Validate.notEmpty(coll); 
         fail("Expecting IllegalArgumentException"); 
     } catch (final IllegalArgumentException ex) { 
         assertEquals("The validated collection is empty", ex.getMessage()); 
     } 
     coll.add(Integer.valueOf(8)); 
     Validate.notEmpty(coll); 
     final Collection<Integer> test = Validate.notEmpty(coll); 
     assertSame(coll, test); 
 }
@Test
public void testMatchesPattern1271() { 
     final CharSequence str = "hi"; 
     Validate.matchesPattern(str, "[a-z]*"); 
     try { 
         Validate.matchesPattern(str, "[0-9]*"); 
         fail("Expecting IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
         assertEquals("The string hi does not match the pattern [0-9]*", e.getMessage()); 
     } 
 }
@Test
public void testIsTrue21356() { 
     Validate.isTrue(true, "MSG"); 
     try { 
         Validate.isTrue(false, "MSG"); 
         fail("Expecting IllegalArgumentException"); 
     } catch (final IllegalArgumentException ex) { 
         assertEquals("MSG", ex.getMessage()); 
     } 
 }
@Test
public void testNoNullElementsArray21579() { 
     String[] array = new String[] { "a", "b" }; 
     Validate.noNullElements(array, "MSG"); 
     try { 
         Validate.noNullElements((Object[]) null, "MSG"); 
         fail("Expecting NullPointerException"); 
     } catch (final NullPointerException ex) { 
         assertEquals("The validated object is null", ex.getMessage()); 
     } 
     array[1] = null; 
     try { 
         Validate.noNullElements(array, "MSG"); 
         fail("Expecting IllegalArgumentException"); 
     } catch (final IllegalArgumentException ex) { 
         assertEquals("MSG", ex.getMessage()); 
     } 
     array = new String[] { "a", "b" }; 
     final String[] test = Validate.noNullElements(array, "Message"); 
     assertSame(array, test); 
 }
@Test
public void testNotBlankMsgNotBlankStringWithWhitespacesShouldNotThrow1596() { 
     final String string = "  abc   "; 
     Validate.notBlank(string, "Message"); 
 }
@Test
public void testValidIndex_charSequence1639() { 
     final CharSequence str = "Hi"; 
     Validate.validIndex(str, 0); 
     Validate.validIndex(str, 1); 
     try { 
         Validate.validIndex(str, -1); 
         fail("Expecting IndexOutOfBoundsException"); 
     } catch (final IndexOutOfBoundsException ex) { 
         assertEquals("The validated character sequence index is invalid: -1", ex.getMessage()); 
     } 
     try { 
         Validate.validIndex(str, 2); 
         fail("Expecting IndexOutOfBoundsException"); 
     } catch (final IndexOutOfBoundsException ex) { 
         assertEquals("The validated character sequence index is invalid: 2", ex.getMessage()); 
     } 
     final String input = "Hi"; 
     final String test = Validate.validIndex(input, 0); 
     assertSame(input, test); 
 }
@Test
public void testNotEmptyString11661() { 
     Validate.notEmpty("hjl"); 
     try { 
         Validate.notEmpty((String) null); 
         fail("Expecting NullPointerException"); 
     } catch (final NullPointerException ex) { 
         assertEquals("The validated character sequence is empty", ex.getMessage()); 
     } 
     try { 
         Validate.notEmpty(""); 
         fail("Expecting IllegalArgumentException"); 
     } catch (final IllegalArgumentException ex) { 
         assertEquals("The validated character sequence is empty", ex.getMessage()); 
     } 
     final String str = "Hi"; 
     final String testStr = Validate.notEmpty(str); 
     assertSame(str, testStr); 
 }
@Test
public void testIsTrue11741() { 
     Validate.isTrue(true); 
     try { 
         Validate.isTrue(false); 
         fail("Expecting IllegalArgumentException"); 
     } catch (final IllegalArgumentException ex) { 
         assertEquals("The validated expression is false", ex.getMessage()); 
     } 
 }
@Test
public void testNotEmptyString11776() { 
     Validate.notEmpty("hjl"); 
     try { 
         Validate.notEmpty((String) null); 
         fail("Expecting NullPointerException"); 
     } catch (final NullPointerException ex) { 
         assertEquals("The validated character sequence is empty", ex.getMessage()); 
     } 
     try { 
         Validate.notEmpty(""); 
         fail("Expecting IllegalArgumentException"); 
     } catch (final IllegalArgumentException ex) { 
         assertEquals("The validated character sequence is empty", ex.getMessage()); 
     } 
     final String str = "Hi"; 
     final String testStr = Validate.notEmpty(str); 
     assertSame(str, testStr); 
 }
@Test
public void testNoNullElementsCollection11790() { 
     final List<String> coll = new ArrayList<String>(); 
     coll.add("a"); 
     coll.add("b"); 
     Validate.noNullElements(coll); 
     try { 
         Validate.noNullElements((Collection<?>) null); 
         fail("Expecting NullPointerException"); 
     } catch (final NullPointerException ex) { 
         assertEquals("The validated object is null", ex.getMessage()); 
     } 
     coll.set(1, null); 
     try { 
         Validate.noNullElements(coll); 
         fail("Expecting IllegalArgumentException"); 
     } catch (final IllegalArgumentException ex) { 
         assertEquals("The validated collection contains null element at index: 1", ex.getMessage()); 
     } 
     coll.set(1, "b"); 
     final List<String> test = Validate.noNullElements(coll); 
     assertSame(coll, test); 
 }
@Test
public void testIsTrue11818() { 
     Validate.isTrue(true); 
     try { 
         Validate.isTrue(false); 
         fail("Expecting IllegalArgumentException"); 
     } catch (final IllegalArgumentException ex) { 
         assertEquals("The validated expression is false", ex.getMessage()); 
     } 
 }
@Test
public void testIsTrue41852() { 
     Validate.isTrue(true, "MSG", 7); 
     try { 
         Validate.isTrue(false, "MSG", 7); 
         fail("Expecting IllegalArgumentException"); 
     } catch (final IllegalArgumentException ex) { 
         assertEquals("MSG", ex.getMessage()); 
     } 
 }
@Test
public void testValidIndex_collection1902() { 
     final Collection<String> coll = new ArrayList<String>(); 
     coll.add(null); 
     coll.add(null); 
     Validate.validIndex(coll, 0); 
     Validate.validIndex(coll, 1); 
     try { 
         Validate.validIndex(coll, -1); 
         fail("Expecting IndexOutOfBoundsException"); 
     } catch (final IndexOutOfBoundsException ex) { 
         assertEquals("The validated collection index is invalid: -1", ex.getMessage()); 
     } 
     try { 
         Validate.validIndex(coll, 2); 
         fail("Expecting IndexOutOfBoundsException"); 
     } catch (final IndexOutOfBoundsException ex) { 
         assertEquals("The validated collection index is invalid: 2", ex.getMessage()); 
     } 
     final List<String> strColl = Arrays.asList(new String[] { "Hi" }); 
     final List<String> test = Validate.validIndex(strColl, 0); 
     assertSame(strColl, test); 
 }
@Test
public void testNoNullElementsCollection11986() { 
     final List<String> coll = new ArrayList<String>(); 
     coll.add("a"); 
     coll.add("b"); 
     Validate.noNullElements(coll); 
     try { 
         Validate.noNullElements((Collection<?>) null); 
         fail("Expecting NullPointerException"); 
     } catch (final NullPointerException ex) { 
         assertEquals("The validated object is null", ex.getMessage()); 
     } 
     coll.set(1, null); 
     try { 
         Validate.noNullElements(coll); 
         fail("Expecting IllegalArgumentException"); 
     } catch (final IllegalArgumentException ex) { 
         assertEquals("The validated collection contains null element at index: 1", ex.getMessage()); 
     } 
     coll.set(1, "b"); 
     final List<String> test = Validate.noNullElements(coll); 
     assertSame(coll, test); 
 }
@Test
public void testNoNullElementsCollection12025() { 
     final List<String> coll = new ArrayList<String>(); 
     coll.add("a"); 
     coll.add("b"); 
     Validate.noNullElements(coll); 
     try { 
         Validate.noNullElements((Collection<?>) null); 
         fail("Expecting NullPointerException"); 
     } catch (final NullPointerException ex) { 
         assertEquals("The validated object is null", ex.getMessage()); 
     } 
     coll.set(1, null); 
     try { 
         Validate.noNullElements(coll); 
         fail("Expecting IllegalArgumentException"); 
     } catch (final IllegalArgumentException ex) { 
         assertEquals("The validated collection contains null element at index: 1", ex.getMessage()); 
     } 
     coll.set(1, "b"); 
     final List<String> test = Validate.noNullElements(coll); 
     assertSame(coll, test); 
 }
@Test
public void testNotEmptyMap12220() { 
     final Map<String, Integer> map = new HashMap<String, Integer>(); 
     try { 
         Validate.notEmpty((Map<?, ?>) null); 
         fail("Expecting NullPointerException"); 
     } catch (final NullPointerException ex) { 
         assertEquals("The validated map is empty", ex.getMessage()); 
     } 
     try { 
         Validate.notEmpty(map); 
         fail("Expecting IllegalArgumentException"); 
     } catch (final IllegalArgumentException ex) { 
         assertEquals("The validated map is empty", ex.getMessage()); 
     } 
     map.put("ll", Integer.valueOf(8)); 
     Validate.notEmpty(map); 
     final Map<String, Integer> test = Validate.notEmpty(map); 
     assertSame(map, test); 
 }
@Test
public void testNoNullElementsArray22232() { 
     String[] array = new String[] { "a", "b" }; 
     Validate.noNullElements(array, "MSG"); 
     try { 
         Validate.noNullElements((Object[]) null, "MSG"); 
         fail("Expecting NullPointerException"); 
     } catch (final NullPointerException ex) { 
         assertEquals("The validated object is null", ex.getMessage()); 
     } 
     array[1] = null; 
     try { 
         Validate.noNullElements(array, "MSG"); 
         fail("Expecting IllegalArgumentException"); 
     } catch (final IllegalArgumentException ex) { 
         assertEquals("MSG", ex.getMessage()); 
     } 
     array = new String[] { "a", "b" }; 
     final String[] test = Validate.noNullElements(array, "Message"); 
     assertSame(array, test); 
 }
@Test
public void testInclusiveBetween_withMessage2304() { 
     Validate.inclusiveBetween("a", "c", "b", "Error"); 
     Validate.inclusiveBetween(0, 2, 1, "Error"); 
     Validate.inclusiveBetween(0, 2, 2, "Error"); 
     try { 
         Validate.inclusiveBetween(0, 5, 6, "Error"); 
         fail("Expecting IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
         assertEquals("Error", e.getMessage()); 
     } 
 }
@Test
public void testIsTrue22336() { 
     Validate.isTrue(true, "MSG"); 
     try { 
         Validate.isTrue(false, "MSG"); 
         fail("Expecting IllegalArgumentException"); 
     } catch (final IllegalArgumentException ex) { 
         assertEquals("MSG", ex.getMessage()); 
     } 
 }
@Test
public void testIsTrue42441() { 
     Validate.isTrue(true, "MSG", 7); 
     try { 
         Validate.isTrue(false, "MSG", 7); 
         fail("Expecting IllegalArgumentException"); 
     } catch (final IllegalArgumentException ex) { 
         assertEquals("MSG", ex.getMessage()); 
     } 
 }
@Test
public void testNotEmptyArray12618() { 
     Validate.notEmpty(new Object[] { null }); 
     try { 
         Validate.notEmpty((Object[]) null); 
         fail("Expecting NullPointerException"); 
     } catch (final NullPointerException ex) { 
         assertEquals("The validated array is empty", ex.getMessage()); 
     } 
     try { 
         Validate.notEmpty(new Object[0]); 
         fail("Expecting IllegalArgumentException"); 
     } catch (final IllegalArgumentException ex) { 
         assertEquals("The validated array is empty", ex.getMessage()); 
     } 
     final String[] array = new String[] { "hi" }; 
     final String[] test = Validate.notEmpty(array); 
     assertSame(array, test); 
 }
@Test
public void testIsAssignableExceptionMessage2804() { 
     try { 
         Validate.isAssignableFrom(List.class, String.class); 
         fail("Expecting IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
         assertEquals("Cannot assign a java.lang.String to a java.util.List", e.getMessage()); 
     } 
 }
@Test
public void testValidIndex_withMessage_charSequence2806() { 
     final CharSequence str = "Hi"; 
     Validate.validIndex(str, 0, "Broken: "); 
     Validate.validIndex(str, 1, "Broken: "); 
     try { 
         Validate.validIndex(str, -1, "Broken: "); 
         fail("Expecting IndexOutOfBoundsException"); 
     } catch (final IndexOutOfBoundsException ex) { 
         assertEquals("Broken: ", ex.getMessage()); 
     } 
     try { 
         Validate.validIndex(str, 2, "Broken: "); 
         fail("Expecting IndexOutOfBoundsException"); 
     } catch (final IndexOutOfBoundsException ex) { 
         assertEquals("Broken: ", ex.getMessage()); 
     } 
     final String input = "Hi"; 
     final String test = Validate.validIndex(input, 0, "Message"); 
     assertSame(input, test); 
 }
@Test
public void testValidIndex_charSequence2841() { 
     final CharSequence str = "Hi"; 
     Validate.validIndex(str, 0); 
     Validate.validIndex(str, 1); 
     try { 
         Validate.validIndex(str, -1); 
         fail("Expecting IndexOutOfBoundsException"); 
     } catch (final IndexOutOfBoundsException ex) { 
         assertEquals("The validated character sequence index is invalid: -1", ex.getMessage()); 
     } 
     try { 
         Validate.validIndex(str, 2); 
         fail("Expecting IndexOutOfBoundsException"); 
     } catch (final IndexOutOfBoundsException ex) { 
         assertEquals("The validated character sequence index is invalid: 2", ex.getMessage()); 
     } 
     final String input = "Hi"; 
     final String test = Validate.validIndex(input, 0); 
     assertSame(input, test); 
 }
@Test
public void testNotEmptyCollection12913() { 
     final Collection<Integer> coll = new ArrayList<Integer>(); 
     try { 
         Validate.notEmpty((Collection<?>) null); 
         fail("Expecting NullPointerException"); 
     } catch (final NullPointerException ex) { 
         assertEquals("The validated collection is empty", ex.getMessage()); 
     } 
     try { 
         Validate.notEmpty(coll); 
         fail("Expecting IllegalArgumentException"); 
     } catch (final IllegalArgumentException ex) { 
         assertEquals("The validated collection is empty", ex.getMessage()); 
     } 
     coll.add(Integer.valueOf(8)); 
     Validate.notEmpty(coll); 
     final Collection<Integer> test = Validate.notEmpty(coll); 
     assertSame(coll, test); 
 }
@Test
public void testValidIndex_array3005() { 
     final Object[] array = new Object[2]; 
     Validate.validIndex(array, 0); 
     Validate.validIndex(array, 1); 
     try { 
         Validate.validIndex(array, -1); 
         fail("Expecting IndexOutOfBoundsException"); 
     } catch (final IndexOutOfBoundsException ex) { 
         assertEquals("The validated array index is invalid: -1", ex.getMessage()); 
     } 
     try { 
         Validate.validIndex(array, 2); 
         fail("Expecting IndexOutOfBoundsException"); 
     } catch (final IndexOutOfBoundsException ex) { 
         assertEquals("The validated array index is invalid: 2", ex.getMessage()); 
     } 
     final String[] strArray = new String[] { "Hi" }; 
     final String[] test = Validate.noNullElements(strArray); 
     assertSame(strArray, test); 
 }
@Test
public void testNoNullElementsCollection13050() { 
     final List<String> coll = new ArrayList<String>(); 
     coll.add("a"); 
     coll.add("b"); 
     Validate.noNullElements(coll); 
     try { 
         Validate.noNullElements((Collection<?>) null); 
         fail("Expecting NullPointerException"); 
     } catch (final NullPointerException ex) { 
         assertEquals("The validated object is null", ex.getMessage()); 
     } 
     coll.set(1, null); 
     try { 
         Validate.noNullElements(coll); 
         fail("Expecting IllegalArgumentException"); 
     } catch (final IllegalArgumentException ex) { 
         assertEquals("The validated collection contains null element at index: 1", ex.getMessage()); 
     } 
     coll.set(1, "b"); 
     final List<String> test = Validate.noNullElements(coll); 
     assertSame(coll, test); 
 }
@Test
public void testNotEmptyArray13162() { 
     Validate.notEmpty(new Object[] { null }); 
     try { 
         Validate.notEmpty((Object[]) null); 
         fail("Expecting NullPointerException"); 
     } catch (final NullPointerException ex) { 
         assertEquals("The validated array is empty", ex.getMessage()); 
     } 
     try { 
         Validate.notEmpty(new Object[0]); 
         fail("Expecting IllegalArgumentException"); 
     } catch (final IllegalArgumentException ex) { 
         assertEquals("The validated array is empty", ex.getMessage()); 
     } 
     final String[] array = new String[] { "hi" }; 
     final String[] test = Validate.notEmpty(array); 
     assertSame(array, test); 
 }
@Test
public void testValidIndex_collection3342() { 
     final Collection<String> coll = new ArrayList<String>(); 
     coll.add(null); 
     coll.add(null); 
     Validate.validIndex(coll, 0); 
     Validate.validIndex(coll, 1); 
     try { 
         Validate.validIndex(coll, -1); 
         fail("Expecting IndexOutOfBoundsException"); 
     } catch (final IndexOutOfBoundsException ex) { 
         assertEquals("The validated collection index is invalid: -1", ex.getMessage()); 
     } 
     try { 
         Validate.validIndex(coll, 2); 
         fail("Expecting IndexOutOfBoundsException"); 
     } catch (final IndexOutOfBoundsException ex) { 
         assertEquals("The validated collection index is invalid: 2", ex.getMessage()); 
     } 
     final List<String> strColl = Arrays.asList(new String[] { "Hi" }); 
     final List<String> test = Validate.validIndex(strColl, 0); 
     assertSame(strColl, test); 
 }
@Test
public void testNotEmptyArray13433() { 
     Validate.notEmpty(new Object[] { null }); 
     try { 
         Validate.notEmpty((Object[]) null); 
         fail("Expecting NullPointerException"); 
     } catch (final NullPointerException ex) { 
         assertEquals("The validated array is empty", ex.getMessage()); 
     } 
     try { 
         Validate.notEmpty(new Object[0]); 
         fail("Expecting IllegalArgumentException"); 
     } catch (final IllegalArgumentException ex) { 
         assertEquals("The validated array is empty", ex.getMessage()); 
     } 
     final String[] array = new String[] { "hi" }; 
     final String[] test = Validate.notEmpty(array); 
     assertSame(array, test); 
 }
@Test
public void testNoNullElementsArray13501() { 
     String[] array = new String[] { "a", "b" }; 
     Validate.noNullElements(array); 
     try { 
         Validate.noNullElements((Object[]) null); 
         fail("Expecting NullPointerException"); 
     } catch (final NullPointerException ex) { 
         assertEquals("The validated object is null", ex.getMessage()); 
     } 
     array[1] = null; 
     try { 
         Validate.noNullElements(array); 
         fail("Expecting IllegalArgumentException"); 
     } catch (final IllegalArgumentException ex) { 
         assertEquals("The validated array contains null element at index: 1", ex.getMessage()); 
     } 
     array = new String[] { "a", "b" }; 
     final String[] test = Validate.noNullElements(array); 
     assertSame(array, test); 
 }
@Test
public void testValidIndex_collection3632() { 
     final Collection<String> coll = new ArrayList<String>(); 
     coll.add(null); 
     coll.add(null); 
     Validate.validIndex(coll, 0); 
     Validate.validIndex(coll, 1); 
     try { 
         Validate.validIndex(coll, -1); 
         fail("Expecting IndexOutOfBoundsException"); 
     } catch (final IndexOutOfBoundsException ex) { 
         assertEquals("The validated collection index is invalid: -1", ex.getMessage()); 
     } 
     try { 
         Validate.validIndex(coll, 2); 
         fail("Expecting IndexOutOfBoundsException"); 
     } catch (final IndexOutOfBoundsException ex) { 
         assertEquals("The validated collection index is invalid: 2", ex.getMessage()); 
     } 
     final List<String> strColl = Arrays.asList(new String[] { "Hi" }); 
     final List<String> test = Validate.validIndex(strColl, 0); 
     assertSame(strColl, test); 
 }
@Test
public void testNotEmptyString13699() { 
     Validate.notEmpty("hjl"); 
     try { 
         Validate.notEmpty((String) null); 
         fail("Expecting NullPointerException"); 
     } catch (final NullPointerException ex) { 
         assertEquals("The validated character sequence is empty", ex.getMessage()); 
     } 
     try { 
         Validate.notEmpty(""); 
         fail("Expecting IllegalArgumentException"); 
     } catch (final IllegalArgumentException ex) { 
         assertEquals("The validated character sequence is empty", ex.getMessage()); 
     } 
     final String str = "Hi"; 
     final String testStr = Validate.notEmpty(str); 
     assertSame(str, testStr); 
 }
@Test
public void testNoNullElementsArray23709() { 
     String[] array = new String[] { "a", "b" }; 
     Validate.noNullElements(array, "MSG"); 
     try { 
         Validate.noNullElements((Object[]) null, "MSG"); 
         fail("Expecting NullPointerException"); 
     } catch (final NullPointerException ex) { 
         assertEquals("The validated object is null", ex.getMessage()); 
     } 
     array[1] = null; 
     try { 
         Validate.noNullElements(array, "MSG"); 
         fail("Expecting IllegalArgumentException"); 
     } catch (final IllegalArgumentException ex) { 
         assertEquals("MSG", ex.getMessage()); 
     } 
     array = new String[] { "a", "b" }; 
     final String[] test = Validate.noNullElements(array, "Message"); 
     assertSame(array, test); 
 }
@Test
public void testNotEmptyCollection13760() { 
     final Collection<Integer> coll = new ArrayList<Integer>(); 
     try { 
         Validate.notEmpty((Collection<?>) null); 
         fail("Expecting NullPointerException"); 
     } catch (final NullPointerException ex) { 
         assertEquals("The validated collection is empty", ex.getMessage()); 
     } 
     try { 
         Validate.notEmpty(coll); 
         fail("Expecting IllegalArgumentException"); 
     } catch (final IllegalArgumentException ex) { 
         assertEquals("The validated collection is empty", ex.getMessage()); 
     } 
     coll.add(Integer.valueOf(8)); 
     Validate.notEmpty(coll); 
     final Collection<Integer> test = Validate.notEmpty(coll); 
     assertSame(coll, test); 
 }
@Test
public void testValidIndex_array3806() { 
     final Object[] array = new Object[2]; 
     Validate.validIndex(array, 0); 
     Validate.validIndex(array, 1); 
     try { 
         Validate.validIndex(array, -1); 
         fail("Expecting IndexOutOfBoundsException"); 
     } catch (final IndexOutOfBoundsException ex) { 
         assertEquals("The validated array index is invalid: -1", ex.getMessage()); 
     } 
     try { 
         Validate.validIndex(array, 2); 
         fail("Expecting IndexOutOfBoundsException"); 
     } catch (final IndexOutOfBoundsException ex) { 
         assertEquals("The validated array index is invalid: 2", ex.getMessage()); 
     } 
     final String[] strArray = new String[] { "Hi" }; 
     final String[] test = Validate.noNullElements(strArray); 
     assertSame(strArray, test); 
 }
@Test
public void testNotBlankMsgNullStringShouldThrow3820() { 
     final String string = null; 
     try { 
         Validate.notBlank(string, "Message"); 
         fail("Expecting NullPointerException"); 
     } catch (final NullPointerException e) { 
         assertEquals("Message", e.getMessage()); 
     } 
 }
@Test
public void testNotBlankNotBlankStringShouldNotThrow3920() { 
     final String string = "abc"; 
     Validate.notBlank(string); 
 }
@Test
public void testNotEmptyString13941() { 
     Validate.notEmpty("hjl"); 
     try { 
         Validate.notEmpty((String) null); 
         fail("Expecting NullPointerException"); 
     } catch (final NullPointerException ex) { 
         assertEquals("The validated character sequence is empty", ex.getMessage()); 
     } 
     try { 
         Validate.notEmpty(""); 
         fail("Expecting IllegalArgumentException"); 
     } catch (final IllegalArgumentException ex) { 
         assertEquals("The validated character sequence is empty", ex.getMessage()); 
     } 
     final String str = "Hi"; 
     final String testStr = Validate.notEmpty(str); 
     assertSame(str, testStr); 
 }
@Test
public void testNotEmptyMap24167() { 
     final Map<String, Integer> map = new HashMap<String, Integer>(); 
     try { 
         Validate.notEmpty((Map<?, ?>) null, "MSG"); 
         fail("Expecting NullPointerException"); 
     } catch (final NullPointerException ex) { 
         assertEquals("MSG", ex.getMessage()); 
     } 
     try { 
         Validate.notEmpty(map, "MSG"); 
         fail("Expecting IllegalArgumentException"); 
     } catch (final IllegalArgumentException ex) { 
         assertEquals("MSG", ex.getMessage()); 
     } 
     map.put("ll", Integer.valueOf(8)); 
     Validate.notEmpty(map, "MSG"); 
     final Map<String, Integer> test = Validate.notEmpty(map, "Message"); 
     assertSame(map, test); 
 }
@Test
public void testIsInstanceOf_withMessage4339() { 
     Validate.isInstanceOf(String.class, "hi", "Error"); 
     Validate.isInstanceOf(Integer.class, 1, "Error"); 
     try { 
         Validate.isInstanceOf(List.class, "hi", "Error"); 
         fail("Expecting IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
         assertEquals("Error", e.getMessage()); 
     } 
 }
@Test
public void testIsInstanceOf4350() { 
     Validate.isInstanceOf(String.class, "hi"); 
     Validate.isInstanceOf(Integer.class, 1); 
 }
@Test
public void testValidIndex_collection4481() { 
     final Collection<String> coll = new ArrayList<String>(); 
     coll.add(null); 
     coll.add(null); 
     Validate.validIndex(coll, 0); 
     Validate.validIndex(coll, 1); 
     try { 
         Validate.validIndex(coll, -1); 
         fail("Expecting IndexOutOfBoundsException"); 
     } catch (final IndexOutOfBoundsException ex) { 
         assertEquals("The validated collection index is invalid: -1", ex.getMessage()); 
     } 
     try { 
         Validate.validIndex(coll, 2); 
         fail("Expecting IndexOutOfBoundsException"); 
     } catch (final IndexOutOfBoundsException ex) { 
         assertEquals("The validated collection index is invalid: 2", ex.getMessage()); 
     } 
     final List<String> strColl = Arrays.asList(new String[] { "Hi" }); 
     final List<String> test = Validate.validIndex(strColl, 0); 
     assertSame(strColl, test); 
 }
@Test
public void testNoNullElementsArray24518() { 
     String[] array = new String[] { "a", "b" }; 
     Validate.noNullElements(array, "MSG"); 
     try { 
         Validate.noNullElements((Object[]) null, "MSG"); 
         fail("Expecting NullPointerException"); 
     } catch (final NullPointerException ex) { 
         assertEquals("The validated object is null", ex.getMessage()); 
     } 
     array[1] = null; 
     try { 
         Validate.noNullElements(array, "MSG"); 
         fail("Expecting IllegalArgumentException"); 
     } catch (final IllegalArgumentException ex) { 
         assertEquals("MSG", ex.getMessage()); 
     } 
     array = new String[] { "a", "b" }; 
     final String[] test = Validate.noNullElements(array, "Message"); 
     assertSame(array, test); 
 }
@Test
public void testNoNullElementsCollection14697() { 
     final List<String> coll = new ArrayList<String>(); 
     coll.add("a"); 
     coll.add("b"); 
     Validate.noNullElements(coll); 
     try { 
         Validate.noNullElements((Collection<?>) null); 
         fail("Expecting NullPointerException"); 
     } catch (final NullPointerException ex) { 
         assertEquals("The validated object is null", ex.getMessage()); 
     } 
     coll.set(1, null); 
     try { 
         Validate.noNullElements(coll); 
         fail("Expecting IllegalArgumentException"); 
     } catch (final IllegalArgumentException ex) { 
         assertEquals("The validated collection contains null element at index: 1", ex.getMessage()); 
     } 
     coll.set(1, "b"); 
     final List<String> test = Validate.noNullElements(coll); 
     assertSame(coll, test); 
 }
@Test
public void testNotEmptyCollection14754() { 
     final Collection<Integer> coll = new ArrayList<Integer>(); 
     try { 
         Validate.notEmpty((Collection<?>) null); 
         fail("Expecting NullPointerException"); 
     } catch (final NullPointerException ex) { 
         assertEquals("The validated collection is empty", ex.getMessage()); 
     } 
     try { 
         Validate.notEmpty(coll); 
         fail("Expecting IllegalArgumentException"); 
     } catch (final IllegalArgumentException ex) { 
         assertEquals("The validated collection is empty", ex.getMessage()); 
     } 
     coll.add(Integer.valueOf(8)); 
     Validate.notEmpty(coll); 
     final Collection<Integer> test = Validate.notEmpty(coll); 
     assertSame(coll, test); 
 }
@Test
public void testConstructor4989() { 
     assertNotNull(new Validate()); 
     final Constructor<?>[] cons = Validate.class.getDeclaredConstructors(); 
     assertEquals(1, cons.length); 
     assertTrue(Modifier.isPublic(cons[0].getModifiers())); 
     assertTrue(Modifier.isPublic(Validate.class.getModifiers())); 
     assertFalse(Modifier.isFinal(Validate.class.getModifiers())); 
 }
@Test
public void testInclusiveBetween_withMessage5423() { 
     Validate.inclusiveBetween("a", "c", "b", "Error"); 
     Validate.inclusiveBetween(0, 2, 1, "Error"); 
     Validate.inclusiveBetween(0, 2, 2, "Error"); 
     try { 
         Validate.inclusiveBetween(0, 5, 6, "Error"); 
         fail("Expecting IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
         assertEquals("Error", e.getMessage()); 
     } 
 }
@Test
public void testValidIndex_withMessage_charSequence5426() { 
     final CharSequence str = "Hi"; 
     Validate.validIndex(str, 0, "Broken: "); 
     Validate.validIndex(str, 1, "Broken: "); 
     try { 
         Validate.validIndex(str, -1, "Broken: "); 
         fail("Expecting IndexOutOfBoundsException"); 
     } catch (final IndexOutOfBoundsException ex) { 
         assertEquals("Broken: ", ex.getMessage()); 
     } 
     try { 
         Validate.validIndex(str, 2, "Broken: "); 
         fail("Expecting IndexOutOfBoundsException"); 
     } catch (final IndexOutOfBoundsException ex) { 
         assertEquals("Broken: ", ex.getMessage()); 
     } 
     final String input = "Hi"; 
     final String test = Validate.validIndex(input, 0, "Message"); 
     assertSame(input, test); 
 }
@Test
public void testIsTrue15472() { 
     Validate.isTrue(true); 
     try { 
         Validate.isTrue(false); 
         fail("Expecting IllegalArgumentException"); 
     } catch (final IllegalArgumentException ex) { 
         assertEquals("The validated expression is false", ex.getMessage()); 
     } 
 }
@Test
public void testNotEmptyMap15526() { 
     final Map<String, Integer> map = new HashMap<String, Integer>(); 
     try { 
         Validate.notEmpty((Map<?, ?>) null); 
         fail("Expecting NullPointerException"); 
     } catch (final NullPointerException ex) { 
         assertEquals("The validated map is empty", ex.getMessage()); 
     } 
     try { 
         Validate.notEmpty(map); 
         fail("Expecting IllegalArgumentException"); 
     } catch (final IllegalArgumentException ex) { 
         assertEquals("The validated map is empty", ex.getMessage()); 
     } 
     map.put("ll", Integer.valueOf(8)); 
     Validate.notEmpty(map); 
     final Map<String, Integer> test = Validate.notEmpty(map); 
     assertSame(map, test); 
 }
@Test
public void testValidIndex_collection5576() { 
     final Collection<String> coll = new ArrayList<String>(); 
     coll.add(null); 
     coll.add(null); 
     Validate.validIndex(coll, 0); 
     Validate.validIndex(coll, 1); 
     try { 
         Validate.validIndex(coll, -1); 
         fail("Expecting IndexOutOfBoundsException"); 
     } catch (final IndexOutOfBoundsException ex) { 
         assertEquals("The validated collection index is invalid: -1", ex.getMessage()); 
     } 
     try { 
         Validate.validIndex(coll, 2); 
         fail("Expecting IndexOutOfBoundsException"); 
     } catch (final IndexOutOfBoundsException ex) { 
         assertEquals("The validated collection index is invalid: 2", ex.getMessage()); 
     } 
     final List<String> strColl = Arrays.asList(new String[] { "Hi" }); 
     final List<String> test = Validate.validIndex(strColl, 0); 
     assertSame(strColl, test); 
 }
@Test
public void testNotBlankMsgNotBlankStringWithWhitespacesShouldNotThrow5798() { 
     final String string = "  abc   "; 
     Validate.notBlank(string, "Message"); 
 }
@Test
public void testValidIndex_withMessage_charSequence5827() { 
     final CharSequence str = "Hi"; 
     Validate.validIndex(str, 0, "Broken: "); 
     Validate.validIndex(str, 1, "Broken: "); 
     try { 
         Validate.validIndex(str, -1, "Broken: "); 
         fail("Expecting IndexOutOfBoundsException"); 
     } catch (final IndexOutOfBoundsException ex) { 
         assertEquals("Broken: ", ex.getMessage()); 
     } 
     try { 
         Validate.validIndex(str, 2, "Broken: "); 
         fail("Expecting IndexOutOfBoundsException"); 
     } catch (final IndexOutOfBoundsException ex) { 
         assertEquals("Broken: ", ex.getMessage()); 
     } 
     final String input = "Hi"; 
     final String test = Validate.validIndex(input, 0, "Message"); 
     assertSame(input, test); 
 }
@Test
public void testInclusiveBetween_withMessage5965() { 
     Validate.inclusiveBetween("a", "c", "b", "Error"); 
     Validate.inclusiveBetween(0, 2, 1, "Error"); 
     Validate.inclusiveBetween(0, 2, 2, "Error"); 
     try { 
         Validate.inclusiveBetween(0, 5, 6, "Error"); 
         fail("Expecting IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
         assertEquals("Error", e.getMessage()); 
     } 
 }
@Test
public void testNotEmptyMap26033() { 
     final Map<String, Integer> map = new HashMap<String, Integer>(); 
     try { 
         Validate.notEmpty((Map<?, ?>) null, "MSG"); 
         fail("Expecting NullPointerException"); 
     } catch (final NullPointerException ex) { 
         assertEquals("MSG", ex.getMessage()); 
     } 
     try { 
         Validate.notEmpty(map, "MSG"); 
         fail("Expecting IllegalArgumentException"); 
     } catch (final IllegalArgumentException ex) { 
         assertEquals("MSG", ex.getMessage()); 
     } 
     map.put("ll", Integer.valueOf(8)); 
     Validate.notEmpty(map, "MSG"); 
     final Map<String, Integer> test = Validate.notEmpty(map, "Message"); 
     assertSame(map, test); 
 }
@Test
public void testNoNullElementsArray26044() { 
     String[] array = new String[] { "a", "b" }; 
     Validate.noNullElements(array, "MSG"); 
     try { 
         Validate.noNullElements((Object[]) null, "MSG"); 
         fail("Expecting NullPointerException"); 
     } catch (final NullPointerException ex) { 
         assertEquals("The validated object is null", ex.getMessage()); 
     } 
     array[1] = null; 
     try { 
         Validate.noNullElements(array, "MSG"); 
         fail("Expecting IllegalArgumentException"); 
     } catch (final IllegalArgumentException ex) { 
         assertEquals("MSG", ex.getMessage()); 
     } 
     array = new String[] { "a", "b" }; 
     final String[] test = Validate.noNullElements(array, "Message"); 
     assertSame(array, test); 
 }
@Test
public void testNoNullElementsCollection16155() { 
     final List<String> coll = new ArrayList<String>(); 
     coll.add("a"); 
     coll.add("b"); 
     Validate.noNullElements(coll); 
     try { 
         Validate.noNullElements((Collection<?>) null); 
         fail("Expecting NullPointerException"); 
     } catch (final NullPointerException ex) { 
         assertEquals("The validated object is null", ex.getMessage()); 
     } 
     coll.set(1, null); 
     try { 
         Validate.noNullElements(coll); 
         fail("Expecting IllegalArgumentException"); 
     } catch (final IllegalArgumentException ex) { 
         assertEquals("The validated collection contains null element at index: 1", ex.getMessage()); 
     } 
     coll.set(1, "b"); 
     final List<String> test = Validate.noNullElements(coll); 
     assertSame(coll, test); 
 }
@Test
public void testNotEmptyCollection16261() { 
     final Collection<Integer> coll = new ArrayList<Integer>(); 
     try { 
         Validate.notEmpty((Collection<?>) null); 
         fail("Expecting NullPointerException"); 
     } catch (final NullPointerException ex) { 
         assertEquals("The validated collection is empty", ex.getMessage()); 
     } 
     try { 
         Validate.notEmpty(coll); 
         fail("Expecting IllegalArgumentException"); 
     } catch (final IllegalArgumentException ex) { 
         assertEquals("The validated collection is empty", ex.getMessage()); 
     } 
     coll.add(Integer.valueOf(8)); 
     Validate.notEmpty(coll); 
     final Collection<Integer> test = Validate.notEmpty(coll); 
     assertSame(coll, test); 
 }
@Test
public void testIsAssignable_withMessage6297() { 
     Validate.isAssignableFrom(CharSequence.class, String.class, "Error"); 
     Validate.isAssignableFrom(AbstractList.class, ArrayList.class, "Error"); 
     try { 
         Validate.isAssignableFrom(List.class, String.class, "Error"); 
         fail("Expecting IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
         assertEquals("Error", e.getMessage()); 
     } 
 }
@Test
public void testNotEmptyArray16322() { 
     Validate.notEmpty(new Object[] { null }); 
     try { 
         Validate.notEmpty((Object[]) null); 
         fail("Expecting NullPointerException"); 
     } catch (final NullPointerException ex) { 
         assertEquals("The validated array is empty", ex.getMessage()); 
     } 
     try { 
         Validate.notEmpty(new Object[0]); 
         fail("Expecting IllegalArgumentException"); 
     } catch (final IllegalArgumentException ex) { 
         assertEquals("The validated array is empty", ex.getMessage()); 
     } 
     final String[] array = new String[] { "hi" }; 
     final String[] test = Validate.notEmpty(array); 
     assertSame(array, test); 
 }
@Test
public void testExclusiveBetween6415() { 
     Validate.exclusiveBetween("a", "c", "b"); 
     Validate.exclusiveBetween(0, 2, 1); 
     try { 
         Validate.exclusiveBetween(0, 5, 6); 
         fail("Expecting IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
         assertEquals("The value 6 is not in the specified exclusive range of 0 to 5", e.getMessage()); 
     } 
     try { 
         Validate.exclusiveBetween(0, 5, 5); 
         fail("Expecting IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
         assertEquals("The value 5 is not in the specified exclusive range of 0 to 5", e.getMessage()); 
     } 
 }
@Test
public void testNotBlankMsgNotBlankStringWithWhitespacesShouldNotThrow6433() { 
     final String string = "  abc   "; 
     Validate.notBlank(string, "Message"); 
 }
@Test
public void testMatchesPattern_withMessage6435() { 
     final CharSequence str = "hi"; 
     Validate.matchesPattern(str, "[a-z]*", "Does not match"); 
     try { 
         Validate.matchesPattern(str, "[0-9]*", "Does not match"); 
         fail("Expecting IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
         assertEquals("Does not match", e.getMessage()); 
     } 
 }
@Test
public void testNotEmptyCollection16460() { 
     final Collection<Integer> coll = new ArrayList<Integer>(); 
     try { 
         Validate.notEmpty((Collection<?>) null); 
         fail("Expecting NullPointerException"); 
     } catch (final NullPointerException ex) { 
         assertEquals("The validated collection is empty", ex.getMessage()); 
     } 
     try { 
         Validate.notEmpty(coll); 
         fail("Expecting IllegalArgumentException"); 
     } catch (final IllegalArgumentException ex) { 
         assertEquals("The validated collection is empty", ex.getMessage()); 
     } 
     coll.add(Integer.valueOf(8)); 
     Validate.notEmpty(coll); 
     final Collection<Integer> test = Validate.notEmpty(coll); 
     assertSame(coll, test); 
 }
@Test
public void testNotEmptyString16526() { 
     Validate.notEmpty("hjl"); 
     try { 
         Validate.notEmpty((String) null); 
         fail("Expecting NullPointerException"); 
     } catch (final NullPointerException ex) { 
         assertEquals("The validated character sequence is empty", ex.getMessage()); 
     } 
     try { 
         Validate.notEmpty(""); 
         fail("Expecting IllegalArgumentException"); 
     } catch (final IllegalArgumentException ex) { 
         assertEquals("The validated character sequence is empty", ex.getMessage()); 
     } 
     final String str = "Hi"; 
     final String testStr = Validate.notEmpty(str); 
     assertSame(str, testStr); 
 }
@Test
public void testNoNullElementsArray26581() { 
     String[] array = new String[] { "a", "b" }; 
     Validate.noNullElements(array, "MSG"); 
     try { 
         Validate.noNullElements((Object[]) null, "MSG"); 
         fail("Expecting NullPointerException"); 
     } catch (final NullPointerException ex) { 
         assertEquals("The validated object is null", ex.getMessage()); 
     } 
     array[1] = null; 
     try { 
         Validate.noNullElements(array, "MSG"); 
         fail("Expecting IllegalArgumentException"); 
     } catch (final IllegalArgumentException ex) { 
         assertEquals("MSG", ex.getMessage()); 
     } 
     array = new String[] { "a", "b" }; 
     final String[] test = Validate.noNullElements(array, "Message"); 
     assertSame(array, test); 
 }
@Test
public void testInclusiveBetween6588() { 
     Validate.inclusiveBetween("a", "c", "b"); 
     Validate.inclusiveBetween(0, 2, 1); 
     Validate.inclusiveBetween(0, 2, 2); 
     try { 
         Validate.inclusiveBetween(0, 5, 6); 
         fail("Expecting IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
         assertEquals("The value 6 is not in the specified inclusive range of 0 to 5", e.getMessage()); 
     } 
 }
@Test
public void testValidIndex_array6590() { 
     final Object[] array = new Object[2]; 
     Validate.validIndex(array, 0); 
     Validate.validIndex(array, 1); 
     try { 
         Validate.validIndex(array, -1); 
         fail("Expecting IndexOutOfBoundsException"); 
     } catch (final IndexOutOfBoundsException ex) { 
         assertEquals("The validated array index is invalid: -1", ex.getMessage()); 
     } 
     try { 
         Validate.validIndex(array, 2); 
         fail("Expecting IndexOutOfBoundsException"); 
     } catch (final IndexOutOfBoundsException ex) { 
         assertEquals("The validated array index is invalid: 2", ex.getMessage()); 
     } 
     final String[] strArray = new String[] { "Hi" }; 
     final String[] test = Validate.noNullElements(strArray); 
     assertSame(strArray, test); 
 }
@Test
public void testIsInstanceOf6657() { 
     Validate.isInstanceOf(String.class, "hi"); 
     Validate.isInstanceOf(Integer.class, 1); 
 }
@Test
public void testIsAssignableExceptionMessage6945() { 
     try { 
         Validate.isAssignableFrom(List.class, String.class); 
         fail("Expecting IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
         assertEquals("Cannot assign a java.lang.String to a java.util.List", e.getMessage()); 
     } 
 }
@Test
public void testValidIndex_array7028() { 
     final Object[] array = new Object[2]; 
     Validate.validIndex(array, 0); 
     Validate.validIndex(array, 1); 
     try { 
         Validate.validIndex(array, -1); 
         fail("Expecting IndexOutOfBoundsException"); 
     } catch (final IndexOutOfBoundsException ex) { 
         assertEquals("The validated array index is invalid: -1", ex.getMessage()); 
     } 
     try { 
         Validate.validIndex(array, 2); 
         fail("Expecting IndexOutOfBoundsException"); 
     } catch (final IndexOutOfBoundsException ex) { 
         assertEquals("The validated array index is invalid: 2", ex.getMessage()); 
     } 
     final String[] strArray = new String[] { "Hi" }; 
     final String[] test = Validate.noNullElements(strArray); 
     assertSame(strArray, test); 
 }
@Test
public void testMatchesPattern_withMessage7077() { 
     final CharSequence str = "hi"; 
     Validate.matchesPattern(str, "[a-z]*", "Does not match"); 
     try { 
         Validate.matchesPattern(str, "[0-9]*", "Does not match"); 
         fail("Expecting IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
         assertEquals("Does not match", e.getMessage()); 
     } 
 }
@Test
public void testIsTrue57276() { 
     Validate.isTrue(true, "MSG", 7.4d); 
     try { 
         Validate.isTrue(false, "MSG", 7.4d); 
         fail("Expecting IllegalArgumentException"); 
     } catch (final IllegalArgumentException ex) { 
         assertEquals("MSG", ex.getMessage()); 
     } 
 }
@Test
public void testInclusiveBetween7304() { 
     Validate.inclusiveBetween("a", "c", "b"); 
     Validate.inclusiveBetween(0, 2, 1); 
     Validate.inclusiveBetween(0, 2, 2); 
     try { 
         Validate.inclusiveBetween(0, 5, 6); 
         fail("Expecting IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
         assertEquals("The value 6 is not in the specified inclusive range of 0 to 5", e.getMessage()); 
     } 
 }
@Test
public void testIsInstanceOf_withMessage7336() { 
     Validate.isInstanceOf(String.class, "hi", "Error"); 
     Validate.isInstanceOf(Integer.class, 1, "Error"); 
     try { 
         Validate.isInstanceOf(List.class, "hi", "Error"); 
         fail("Expecting IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
         assertEquals("Error", e.getMessage()); 
     } 
 }
@Test
public void testNoNullElementsArray27433() { 
     String[] array = new String[] { "a", "b" }; 
     Validate.noNullElements(array, "MSG"); 
     try { 
         Validate.noNullElements((Object[]) null, "MSG"); 
         fail("Expecting NullPointerException"); 
     } catch (final NullPointerException ex) { 
         assertEquals("The validated object is null", ex.getMessage()); 
     } 
     array[1] = null; 
     try { 
         Validate.noNullElements(array, "MSG"); 
         fail("Expecting IllegalArgumentException"); 
     } catch (final IllegalArgumentException ex) { 
         assertEquals("MSG", ex.getMessage()); 
     } 
     array = new String[] { "a", "b" }; 
     final String[] test = Validate.noNullElements(array, "Message"); 
     assertSame(array, test); 
 }
@Test
public void testIsAssignable_withMessage7482() { 
     Validate.isAssignableFrom(CharSequence.class, String.class, "Error"); 
     Validate.isAssignableFrom(AbstractList.class, ArrayList.class, "Error"); 
     try { 
         Validate.isAssignableFrom(List.class, String.class, "Error"); 
         fail("Expecting IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
         assertEquals("Error", e.getMessage()); 
     } 
 }
@Test
public void testExclusiveBetween7658() { 
     Validate.exclusiveBetween("a", "c", "b"); 
     Validate.exclusiveBetween(0, 2, 1); 
     try { 
         Validate.exclusiveBetween(0, 5, 6); 
         fail("Expecting IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
         assertEquals("The value 6 is not in the specified exclusive range of 0 to 5", e.getMessage()); 
     } 
     try { 
         Validate.exclusiveBetween(0, 5, 5); 
         fail("Expecting IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
         assertEquals("The value 5 is not in the specified exclusive range of 0 to 5", e.getMessage()); 
     } 
 }
@Test
public void testNotEmptyString17671() { 
     Validate.notEmpty("hjl"); 
     try { 
         Validate.notEmpty((String) null); 
         fail("Expecting NullPointerException"); 
     } catch (final NullPointerException ex) { 
         assertEquals("The validated character sequence is empty", ex.getMessage()); 
     } 
     try { 
         Validate.notEmpty(""); 
         fail("Expecting IllegalArgumentException"); 
     } catch (final IllegalArgumentException ex) { 
         assertEquals("The validated character sequence is empty", ex.getMessage()); 
     } 
     final String str = "Hi"; 
     final String testStr = Validate.notEmpty(str); 
     assertSame(str, testStr); 
 }
@Test
public void testExclusiveBetween_withMessage7802() { 
     Validate.exclusiveBetween("a", "c", "b", "Error"); 
     Validate.exclusiveBetween(0, 2, 1, "Error"); 
     try { 
         Validate.exclusiveBetween(0, 5, 6, "Error"); 
         fail("Expecting IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
         assertEquals("Error", e.getMessage()); 
     } 
     try { 
         Validate.exclusiveBetween(0, 5, 5, "Error"); 
         fail("Expecting IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
         assertEquals("Error", e.getMessage()); 
     } 
 }
@Test
public void testNotEmptyMap27838() { 
     final Map<String, Integer> map = new HashMap<String, Integer>(); 
     try { 
         Validate.notEmpty((Map<?, ?>) null, "MSG"); 
         fail("Expecting NullPointerException"); 
     } catch (final NullPointerException ex) { 
         assertEquals("MSG", ex.getMessage()); 
     } 
     try { 
         Validate.notEmpty(map, "MSG"); 
         fail("Expecting IllegalArgumentException"); 
     } catch (final IllegalArgumentException ex) { 
         assertEquals("MSG", ex.getMessage()); 
     } 
     map.put("ll", Integer.valueOf(8)); 
     Validate.notEmpty(map, "MSG"); 
     final Map<String, Integer> test = Validate.notEmpty(map, "Message"); 
     assertSame(map, test); 
 }
@Test
public void testInclusiveBetween7905() { 
     Validate.inclusiveBetween("a", "c", "b"); 
     Validate.inclusiveBetween(0, 2, 1); 
     Validate.inclusiveBetween(0, 2, 2); 
     try { 
         Validate.inclusiveBetween(0, 5, 6); 
         fail("Expecting IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
         assertEquals("The value 6 is not in the specified inclusive range of 0 to 5", e.getMessage()); 
     } 
 }
@Test
public void testIsAssignableExceptionMessage8070() { 
     try { 
         Validate.isAssignableFrom(List.class, String.class); 
         fail("Expecting IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
         assertEquals("Cannot assign a java.lang.String to a java.util.List", e.getMessage()); 
     } 
 }
@Test
public void testNoNullElementsCollection18116() { 
     final List<String> coll = new ArrayList<String>(); 
     coll.add("a"); 
     coll.add("b"); 
     Validate.noNullElements(coll); 
     try { 
         Validate.noNullElements((Collection<?>) null); 
         fail("Expecting NullPointerException"); 
     } catch (final NullPointerException ex) { 
         assertEquals("The validated object is null", ex.getMessage()); 
     } 
     coll.set(1, null); 
     try { 
         Validate.noNullElements(coll); 
         fail("Expecting IllegalArgumentException"); 
     } catch (final IllegalArgumentException ex) { 
         assertEquals("The validated collection contains null element at index: 1", ex.getMessage()); 
     } 
     coll.set(1, "b"); 
     final List<String> test = Validate.noNullElements(coll); 
     assertSame(coll, test); 
 }
@Test
public void testNotBlankMsgBlankStringWithWhitespacesShouldThrow8117() { 
     final String string = "   "; 
     try { 
         Validate.notBlank(string, "Message"); 
         fail("Expecting IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
         assertEquals("Message", e.getMessage()); 
     } 
 }
@Test
public void testValidIndex_array8152() { 
     final Object[] array = new Object[2]; 
     Validate.validIndex(array, 0); 
     Validate.validIndex(array, 1); 
     try { 
         Validate.validIndex(array, -1); 
         fail("Expecting IndexOutOfBoundsException"); 
     } catch (final IndexOutOfBoundsException ex) { 
         assertEquals("The validated array index is invalid: -1", ex.getMessage()); 
     } 
     try { 
         Validate.validIndex(array, 2); 
         fail("Expecting IndexOutOfBoundsException"); 
     } catch (final IndexOutOfBoundsException ex) { 
         assertEquals("The validated array index is invalid: 2", ex.getMessage()); 
     } 
     final String[] strArray = new String[] { "Hi" }; 
     final String[] test = Validate.noNullElements(strArray); 
     assertSame(strArray, test); 
 }
@Test
public void testIsTrue58200() { 
     Validate.isTrue(true, "MSG", 7.4d); 
     try { 
         Validate.isTrue(false, "MSG", 7.4d); 
         fail("Expecting IllegalArgumentException"); 
     } catch (final IllegalArgumentException ex) { 
         assertEquals("MSG", ex.getMessage()); 
     } 
 }
@Test
public void testExclusiveBetween8341() { 
     Validate.exclusiveBetween("a", "c", "b"); 
     Validate.exclusiveBetween(0, 2, 1); 
     try { 
         Validate.exclusiveBetween(0, 5, 6); 
         fail("Expecting IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
         assertEquals("The value 6 is not in the specified exclusive range of 0 to 5", e.getMessage()); 
     } 
     try { 
         Validate.exclusiveBetween(0, 5, 5); 
         fail("Expecting IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
         assertEquals("The value 5 is not in the specified exclusive range of 0 to 5", e.getMessage()); 
     } 
 }
@Test
public void testValidIndex_withMessage_charSequence8372() { 
     final CharSequence str = "Hi"; 
     Validate.validIndex(str, 0, "Broken: "); 
     Validate.validIndex(str, 1, "Broken: "); 
     try { 
         Validate.validIndex(str, -1, "Broken: "); 
         fail("Expecting IndexOutOfBoundsException"); 
     } catch (final IndexOutOfBoundsException ex) { 
         assertEquals("Broken: ", ex.getMessage()); 
     } 
     try { 
         Validate.validIndex(str, 2, "Broken: "); 
         fail("Expecting IndexOutOfBoundsException"); 
     } catch (final IndexOutOfBoundsException ex) { 
         assertEquals("Broken: ", ex.getMessage()); 
     } 
     final String input = "Hi"; 
     final String test = Validate.validIndex(input, 0, "Message"); 
     assertSame(input, test); 
 }
@Test
public void testNotEmptyArray18428() { 
     Validate.notEmpty(new Object[] { null }); 
     try { 
         Validate.notEmpty((Object[]) null); 
         fail("Expecting NullPointerException"); 
     } catch (final NullPointerException ex) { 
         assertEquals("The validated array is empty", ex.getMessage()); 
     } 
     try { 
         Validate.notEmpty(new Object[0]); 
         fail("Expecting IllegalArgumentException"); 
     } catch (final IllegalArgumentException ex) { 
         assertEquals("The validated array is empty", ex.getMessage()); 
     } 
     final String[] array = new String[] { "hi" }; 
     final String[] test = Validate.notEmpty(array); 
     assertSame(array, test); 
 }
@Test
public void testIsInstanceOfExceptionMessage8435() { 
     try { 
         Validate.isInstanceOf(List.class, "hi"); 
         fail("Expecting IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
         assertEquals("Expected type: java.util.List, actual: java.lang.String", e.getMessage()); 
     } 
 }
@Test
public void testNotEmptyMap28486() { 
     final Map<String, Integer> map = new HashMap<String, Integer>(); 
     try { 
         Validate.notEmpty((Map<?, ?>) null, "MSG"); 
         fail("Expecting NullPointerException"); 
     } catch (final NullPointerException ex) { 
         assertEquals("MSG", ex.getMessage()); 
     } 
     try { 
         Validate.notEmpty(map, "MSG"); 
         fail("Expecting IllegalArgumentException"); 
     } catch (final IllegalArgumentException ex) { 
         assertEquals("MSG", ex.getMessage()); 
     } 
     map.put("ll", Integer.valueOf(8)); 
     Validate.notEmpty(map, "MSG"); 
     final Map<String, Integer> test = Validate.notEmpty(map, "Message"); 
     assertSame(map, test); 
 }
@Test
public void testNotEmptyArray18549() { 
     Validate.notEmpty(new Object[] { null }); 
     try { 
         Validate.notEmpty((Object[]) null); 
         fail("Expecting NullPointerException"); 
     } catch (final NullPointerException ex) { 
         assertEquals("The validated array is empty", ex.getMessage()); 
     } 
     try { 
         Validate.notEmpty(new Object[0]); 
         fail("Expecting IllegalArgumentException"); 
     } catch (final IllegalArgumentException ex) { 
         assertEquals("The validated array is empty", ex.getMessage()); 
     } 
     final String[] array = new String[] { "hi" }; 
     final String[] test = Validate.notEmpty(array); 
     assertSame(array, test); 
 }
@Test
public void testValidIndex_withMessage_charSequence8626() { 
     final CharSequence str = "Hi"; 
     Validate.validIndex(str, 0, "Broken: "); 
     Validate.validIndex(str, 1, "Broken: "); 
     try { 
         Validate.validIndex(str, -1, "Broken: "); 
         fail("Expecting IndexOutOfBoundsException"); 
     } catch (final IndexOutOfBoundsException ex) { 
         assertEquals("Broken: ", ex.getMessage()); 
     } 
     try { 
         Validate.validIndex(str, 2, "Broken: "); 
         fail("Expecting IndexOutOfBoundsException"); 
     } catch (final IndexOutOfBoundsException ex) { 
         assertEquals("Broken: ", ex.getMessage()); 
     } 
     final String input = "Hi"; 
     final String test = Validate.validIndex(input, 0, "Message"); 
     assertSame(input, test); 
 }
@Test
public void testNoNullElementsArray28652() { 
     String[] array = new String[] { "a", "b" }; 
     Validate.noNullElements(array, "MSG"); 
     try { 
         Validate.noNullElements((Object[]) null, "MSG"); 
         fail("Expecting NullPointerException"); 
     } catch (final NullPointerException ex) { 
         assertEquals("The validated object is null", ex.getMessage()); 
     } 
     array[1] = null; 
     try { 
         Validate.noNullElements(array, "MSG"); 
         fail("Expecting IllegalArgumentException"); 
     } catch (final IllegalArgumentException ex) { 
         assertEquals("MSG", ex.getMessage()); 
     } 
     array = new String[] { "a", "b" }; 
     final String[] test = Validate.noNullElements(array, "Message"); 
     assertSame(array, test); 
 }
@Test
public void testNotEmptyString18708() { 
     Validate.notEmpty("hjl"); 
     try { 
         Validate.notEmpty((String) null); 
         fail("Expecting NullPointerException"); 
     } catch (final NullPointerException ex) { 
         assertEquals("The validated character sequence is empty", ex.getMessage()); 
     } 
     try { 
         Validate.notEmpty(""); 
         fail("Expecting IllegalArgumentException"); 
     } catch (final IllegalArgumentException ex) { 
         assertEquals("The validated character sequence is empty", ex.getMessage()); 
     } 
     final String str = "Hi"; 
     final String testStr = Validate.notEmpty(str); 
     assertSame(str, testStr); 
 }
@Test
public void testValidIndex_array8763() { 
     final Object[] array = new Object[2]; 
     Validate.validIndex(array, 0); 
     Validate.validIndex(array, 1); 
     try { 
         Validate.validIndex(array, -1); 
         fail("Expecting IndexOutOfBoundsException"); 
     } catch (final IndexOutOfBoundsException ex) { 
         assertEquals("The validated array index is invalid: -1", ex.getMessage()); 
     } 
     try { 
         Validate.validIndex(array, 2); 
         fail("Expecting IndexOutOfBoundsException"); 
     } catch (final IndexOutOfBoundsException ex) { 
         assertEquals("The validated array index is invalid: 2", ex.getMessage()); 
     } 
     final String[] strArray = new String[] { "Hi" }; 
     final String[] test = Validate.noNullElements(strArray); 
     assertSame(strArray, test); 
 }
@Test
public void testValidIndex_collection8804() { 
     final Collection<String> coll = new ArrayList<String>(); 
     coll.add(null); 
     coll.add(null); 
     Validate.validIndex(coll, 0); 
     Validate.validIndex(coll, 1); 
     try { 
         Validate.validIndex(coll, -1); 
         fail("Expecting IndexOutOfBoundsException"); 
     } catch (final IndexOutOfBoundsException ex) { 
         assertEquals("The validated collection index is invalid: -1", ex.getMessage()); 
     } 
     try { 
         Validate.validIndex(coll, 2); 
         fail("Expecting IndexOutOfBoundsException"); 
     } catch (final IndexOutOfBoundsException ex) { 
         assertEquals("The validated collection index is invalid: 2", ex.getMessage()); 
     } 
     final List<String> strColl = Arrays.asList(new String[] { "Hi" }); 
     final List<String> test = Validate.validIndex(strColl, 0); 
     assertSame(strColl, test); 
 }
@Test
public void testNotEmptyArray18829() { 
     Validate.notEmpty(new Object[] { null }); 
     try { 
         Validate.notEmpty((Object[]) null); 
         fail("Expecting NullPointerException"); 
     } catch (final NullPointerException ex) { 
         assertEquals("The validated array is empty", ex.getMessage()); 
     } 
     try { 
         Validate.notEmpty(new Object[0]); 
         fail("Expecting IllegalArgumentException"); 
     } catch (final IllegalArgumentException ex) { 
         assertEquals("The validated array is empty", ex.getMessage()); 
     } 
     final String[] array = new String[] { "hi" }; 
     final String[] test = Validate.notEmpty(array); 
     assertSame(array, test); 
 }
@Test
public void testMatchesPattern_withMessage8880() { 
     final CharSequence str = "hi"; 
     Validate.matchesPattern(str, "[a-z]*", "Does not match"); 
     try { 
         Validate.matchesPattern(str, "[0-9]*", "Does not match"); 
         fail("Expecting IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
         assertEquals("Does not match", e.getMessage()); 
     } 
 }
@Test
public void testMatchesPattern9004() { 
     final CharSequence str = "hi"; 
     Validate.matchesPattern(str, "[a-z]*"); 
     try { 
         Validate.matchesPattern(str, "[0-9]*"); 
         fail("Expecting IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
         assertEquals("The string hi does not match the pattern [0-9]*", e.getMessage()); 
     } 
 }
@Test
public void testIsInstanceOf_withMessage9259() { 
     Validate.isInstanceOf(String.class, "hi", "Error"); 
     Validate.isInstanceOf(Integer.class, 1, "Error"); 
     try { 
         Validate.isInstanceOf(List.class, "hi", "Error"); 
         fail("Expecting IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
         assertEquals("Error", e.getMessage()); 
     } 
 }
@Test
public void testNoNullElementsArray29326() { 
     String[] array = new String[] { "a", "b" }; 
     Validate.noNullElements(array, "MSG"); 
     try { 
         Validate.noNullElements((Object[]) null, "MSG"); 
         fail("Expecting NullPointerException"); 
     } catch (final NullPointerException ex) { 
         assertEquals("The validated object is null", ex.getMessage()); 
     } 
     array[1] = null; 
     try { 
         Validate.noNullElements(array, "MSG"); 
         fail("Expecting IllegalArgumentException"); 
     } catch (final IllegalArgumentException ex) { 
         assertEquals("MSG", ex.getMessage()); 
     } 
     array = new String[] { "a", "b" }; 
     final String[] test = Validate.noNullElements(array, "Message"); 
     assertSame(array, test); 
 }
@Test
public void testNotEmptyCollection19490() { 
     final Collection<Integer> coll = new ArrayList<Integer>(); 
     try { 
         Validate.notEmpty((Collection<?>) null); 
         fail("Expecting NullPointerException"); 
     } catch (final NullPointerException ex) { 
         assertEquals("The validated collection is empty", ex.getMessage()); 
     } 
     try { 
         Validate.notEmpty(coll); 
         fail("Expecting IllegalArgumentException"); 
     } catch (final IllegalArgumentException ex) { 
         assertEquals("The validated collection is empty", ex.getMessage()); 
     } 
     coll.add(Integer.valueOf(8)); 
     Validate.notEmpty(coll); 
     final Collection<Integer> test = Validate.notEmpty(coll); 
     assertSame(coll, test); 
 }
@Test
public void testIsAssignable_withMessage9512() { 
     Validate.isAssignableFrom(CharSequence.class, String.class, "Error"); 
     Validate.isAssignableFrom(AbstractList.class, ArrayList.class, "Error"); 
     try { 
         Validate.isAssignableFrom(List.class, String.class, "Error"); 
         fail("Expecting IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
         assertEquals("Error", e.getMessage()); 
     } 
 }
    

    //-----------------------------------------------------------------------
    

    //-----------------------------------------------------------------------
    

    //-----------------------------------------------------------------------
    

    //-----------------------------------------------------------------------
    

    //-----------------------------------------------------------------------
    //-----------------------------------------------------------------------
    

    //-----------------------------------------------------------------------
    

    //-----------------------------------------------------------------------
    //-----------------------------------------------------------------------
    

    //-----------------------------------------------------------------------
    

    //-----------------------------------------------------------------------
    //-----------------------------------------------------------------------
    

    //-----------------------------------------------------------------------
    

    //-----------------------------------------------------------------------
    //-----------------------------------------------------------------------
    

    //-----------------------------------------------------------------------
    

    //-----------------------------------------------------------------------
    //-----------------------------------------------------------------------
    

    //-----------------------------------------------------------------------
    

    //-----------------------------------------------------------------------
    //-----------------------------------------------------------------------
    

    //-----------------------------------------------------------------------
    

    //-----------------------------------------------------------------------
    

    //-----------------------------------------------------------------------
    

    //-----------------------------------------------------------------------
    

    //-----------------------------------------------------------------------
    

    //-----------------------------------------------------------------------
    

    //-----------------------------------------------------------------------
    

    //-----------------------------------------------------------------------
    

    //-----------------------------------------------------------------------
    

    //-----------------------------------------------------------------------
    

    //-----------------------------------------------------------------------
    

    //-----------------------------------------------------------------------
    

    //-----------------------------------------------------------------------
    

    //-----------------------------------------------------------------------
    

    

    //-----------------------------------------------------------------------
    //-----------------------------------------------------------------------
    

    //-----------------------------------------------------------------------
    

    //-----------------------------------------------------------------------
    //-----------------------------------------------------------------------
    

    //-----------------------------------------------------------------------
    

    //-----------------------------------------------------------------------
    //-----------------------------------------------------------------------
    

    //-----------------------------------------------------------------------
    //-----------------------------------------------------------------------
    

    

    //-----------------------------------------------------------------------
    //-----------------------------------------------------------------------
    

    

    //-----------------------------------------------------------------------
    //-----------------------------------------------------------------------
    

    
    
    
    
    
    
    
    
    
    
    
    
    

    
    
    
    
    
    
    
    
    
    
    

}
