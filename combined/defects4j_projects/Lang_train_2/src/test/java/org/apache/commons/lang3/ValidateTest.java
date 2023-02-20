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
public void testIsTrue4885() { 
     Validate.isTrue(true, "MSG", 7); 
     try { 
         Validate.isTrue(false, "MSG", 7); 
         fail("Expecting IllegalArgumentException"); 
     } catch (final IllegalArgumentException ex) { 
         assertEquals("MSG", ex.getMessage()); 
     } 
 }
@Test
public void testIsTrue2886() { 
     Validate.isTrue(true, "MSG"); 
     try { 
         Validate.isTrue(false, "MSG"); 
         fail("Expecting IllegalArgumentException"); 
     } catch (final IllegalArgumentException ex) { 
         assertEquals("MSG", ex.getMessage()); 
     } 
 }
@Test
public void testIsTrue1887() { 
     Validate.isTrue(true); 
     try { 
         Validate.isTrue(false); 
         fail("Expecting IllegalArgumentException"); 
     } catch (final IllegalArgumentException ex) { 
         assertEquals("The validated expression is false", ex.getMessage()); 
     } 
 }
@Test
public void testValidIndex_array888() { 
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
public void testNoNullElementsArray2889() { 
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
public void testNotEmptyCollection1890() { 
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
public void testNotEmptyMap1891() { 
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
public void testNotEmptyString1892() { 
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
public void testNotBlankMsgBlankStringShouldThrow893() { 
     final String string = " \n \t \r \n "; 
     try { 
         Validate.notBlank(string, "Message"); 
         fail("Expecting IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
         assertEquals("Message", e.getMessage()); 
     } 
 }
@Test
public void testNotBlankNullStringShouldThrow894() { 
     final String string = null; 
     try { 
         Validate.notBlank(string); 
         fail("Expecting NullPointerException"); 
     } catch (final NullPointerException e) { 
         assertEquals("The validated character sequence is blank", e.getMessage()); 
     } 
 }
@Test
public void testNotBlankMsgNotBlankStringShouldNotThrow895() { 
     final String string = "abc"; 
     Validate.notBlank(string, "Message"); 
 }
@Test
public void testNotBlankBlankStringWithWhitespacesShouldThrow896() { 
     final String string = "   "; 
     try { 
         Validate.notBlank(string); 
         fail("Expecting IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
         assertEquals("The validated character sequence is blank", e.getMessage()); 
     } 
 }
@Test
public void testNoNullElementsCollection1897() { 
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
public void testValidIndex_withMessage_collection898() { 
     final Collection<String> coll = new ArrayList<String>(); 
     coll.add(null); 
     coll.add(null); 
     Validate.validIndex(coll, 0, "Broken: "); 
     Validate.validIndex(coll, 1, "Broken: "); 
     try { 
         Validate.validIndex(coll, -1, "Broken: "); 
         fail("Expecting IndexOutOfBoundsException"); 
     } catch (final IndexOutOfBoundsException ex) { 
         assertEquals("Broken: ", ex.getMessage()); 
     } 
     try { 
         Validate.validIndex(coll, 2, "Broken: "); 
         fail("Expecting IndexOutOfBoundsException"); 
     } catch (final IndexOutOfBoundsException ex) { 
         assertEquals("Broken: ", ex.getMessage()); 
     } 
     final List<String> strColl = Arrays.asList(new String[] { "Hi" }); 
     final List<String> test = Validate.validIndex(strColl, 0, "Message"); 
     assertSame(strColl, test); 
 }
@Test
public void testValidIndex_collection899() { 
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
public void testMatchesPattern900() { 
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
public void testMatchesPattern_withMessage901() { 
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
public void testInclusiveBetween902() { 
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
public void testInclusiveBetween_withMessage903() { 
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
public void testExclusiveBetween_withMessage904() { 
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
public void testIsInstanceOfExceptionMessage905() { 
     try { 
         Validate.isInstanceOf(List.class, "hi"); 
         fail("Expecting IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
         assertEquals("Expected type: java.util.List, actual: java.lang.String", e.getMessage()); 
     } 
 }
@Test
public void testIsInstanceOf_withMessage906() { 
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
public void testIsAssignable_withMessage907() { 
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
