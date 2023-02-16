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
public void testConstructor384() { 
     assertNotNull(new Validate()); 
     final Constructor<?>[] cons = Validate.class.getDeclaredConstructors(); 
     assertEquals(1, cons.length); 
     assertTrue(Modifier.isPublic(cons[0].getModifiers())); 
     assertTrue(Modifier.isPublic(Validate.class.getModifiers())); 
     assertFalse(Modifier.isFinal(Validate.class.getModifiers())); 
 }
@Test
public void testIsTrue4385() { 
     Validate.isTrue(true, "MSG", 7); 
     try { 
         Validate.isTrue(false, "MSG", 7); 
         fail("Expecting IllegalArgumentException"); 
     } catch (final IllegalArgumentException ex) { 
         assertEquals("MSG", ex.getMessage()); 
     } 
 }
@Test
public void testNotEmptyArray2386() { 
     String[] array = new String[] { "a", "b" }; 
     Validate.notEmpty(array); 
     try { 
         Validate.notEmpty((Object[]) null); 
         fail("Expecting NullPointerException"); 
     } catch (final NullPointerException ex) { 
         assertEquals("The validated array is empty", ex.getMessage()); 
     } 
     try { 
         Validate.notEmpty(array); 
         fail("Expecting IllegalArgumentException"); 
     } catch (final IllegalArgumentException ex) { 
         assertEquals("The validated array is empty", ex.getMessage()); 
     } 
     array = new String[] { "a", "b" }; 
     Validate.notEmpty(array); 
     final String[] test = Validate.notEmpty(array); 
     assertSame(array, test); 
 }
@Test
public void testNotEmptyArray1387() { 
     String[] array = new String[] { "a", "b" }; 
     Validate.notEmpty(array); 
     try { 
         Validate.notEmpty((Object[]) null); 
         fail("Expecting NullPointerException"); 
     } catch (final NullPointerException ex) { 
         assertEquals("The validated array is empty", ex.getMessage()); 
     } 
     try { 
         Validate.notEmpty(array); 
         fail("Expecting IllegalArgumentException"); 
     } catch (final IllegalArgumentException ex) { 
         assertEquals("The validated array is empty", ex.getMessage()); 
     } 
     array = new String[] { "a", "b" }; 
     final String[] test = Validate.notEmpty(array); 
     assertSame(array, test); 
 }
@Test
public void testNotEmptyString1388() { 
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
public void testValidIndex_withMessage_array389() { 
     final String[] array = new String[] { "a", "b" }; 
     Validate.validIndex(array, 0, "Broken: "); 
     Validate.validIndex(array, 1, "Broken: "); 
     try { 
         Validate.validIndex(array, -1, "Broken: "); 
         fail("Expecting IndexOutOfBoundsException"); 
     } catch (final IndexOutOfBoundsException ex) { 
         assertEquals("Broken: ", ex.getMessage()); 
     } 
     try { 
         Validate.validIndex(array, 2, "Broken: "); 
         fail("Expecting IndexOutOfBoundsException"); 
     } catch (final IndexOutOfBoundsException ex) { 
         assertEquals("Broken: ", ex.getMessage()); 
     } 
     final String[] strArray = new String[] { "a", "b" }; 
     final String[] test = Validate.noNullElements(strArray); 
     assertSame(strArray, test); 
 }
@Test
public void testValidIndex_withMessage_array390() { 
     final Object[] array = new Object[2]; 
     Validate.validIndex(array, 0, "Broken: "); 
     Validate.validIndex(array, 1, "Broken: "); 
     try { 
         Validate.validIndex(array, -1, "Broken: "); 
         fail("Expecting IndexOutOfBoundsException"); 
     } catch (final IndexOutOfBoundsException ex) { 
         assertEquals("Broken: ", ex.getMessage()); 
     } 
     try { 
         Validate.validIndex(array, 2, "Broken: "); 
         fail("Expecting IndexOutOfBoundsException"); 
     } catch (final IndexOutOfBoundsException ex) { 
         assertEquals("Broken: ", ex.getMessage()); 
     } 
     final String[] strArray = new String[] { "Hi" }; 
     final String[] test = Validate.noNullElements(strArray); 
     assertSame(strArray, test); 
 }
@Test
public void testValidIndex_array391() { 
     final String[] array = new String[] { "a", "b" }; 
     Validate.validIndex(array, 0); 
     Validate.validIndex(array, 1); 
     try { 
         Validate.validIndex(array, -1); 
         fail("Expecting IndexOutOfBoundsException"); 
     } catch (final IndexOutOfBoundsException ex) { 
         assertEquals("The validated character sequence is invalid: -1", ex.getMessage()); 
     } 
     try { 
         Validate.validIndex(array, 2); 
         fail("Expecting IndexOutOfBoundsException"); 
     } catch (final IndexOutOfBoundsException ex) { 
         assertEquals("The validated character sequence is invalid: 2", ex.getMessage()); 
     } 
     final String[] strArray = new String[] { "a", "b" }; 
     final String[] test = Validate.noNullElements(strArray); 
     assertSame(strArray, test); 
 }
@Test
public void testExclusiveBetween_withMessage393() { 
     Validate.exclusiveBetween("a", "c", "b"); 
     Validate.exclusiveBetween(0, 2, 1); 
     try { 
         Validate.exclusiveBetween(0, 5, 6); 
         fail("Expecting IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
         assertEquals("The value 6 is not in the specified inclusive range of 0 to 5", e.getMessage()); 
     } 
 }
@Test
public void testIsAssignable_withMessage394() { 
     Validate.isAssignableFrom(CharSequence.class, String.class); 
     Validate.isAssignableFrom(AbstractList.class, ArrayList.class); 
     try { 
         Validate.isAssignableFrom(List.class, String.class); 
         fail("Expecting IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
         assertEquals("Expected type: java.util.List, actual: java.lang.String", e.getMessage()); 
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
