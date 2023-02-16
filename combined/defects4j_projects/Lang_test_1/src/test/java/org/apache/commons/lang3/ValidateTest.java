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
public void testNotEmptyArray1394() { 
     Validate.notNull(new Object[] { null }); 
     try { 
         Validate.notNull((Object[]) null); 
         fail("Expecting NullPointerException"); 
     } catch (final NullPointerException ex) { 
         assertEquals("The validated object is null", ex.getMessage()); 
     } 
     try { 
         Validate.notNull(new Object[0]); 
         fail("Expecting IllegalArgumentException"); 
     } catch (final IllegalArgumentException ex) { 
         assertEquals("The validated object is null", ex.getMessage()); 
     } 
     final String[] array = new String[] { "hi" }; 
     final String[] test = Validate.notNull(array); 
     assertSame(array, test); 
 }
@Test
public void testNotNullString2395() { 
     Validate.notNull("a", "MSG"); 
     try { 
         Validate.notNull((String) null, "MSG"); 
         fail("Expecting NullPointerException"); 
     } catch (final NullPointerException ex) { 
         assertEquals("MSG", ex.getMessage()); 
     } 
     try { 
         Validate.notNull("", "MSG"); 
         fail("Expecting IllegalArgumentException"); 
     } catch (final IllegalArgumentException ex) { 
         assertEquals("MSG", ex.getMessage()); 
     } 
     final String str = "Hi"; 
     final String testStr = Validate.notNull(str, "Message"); 
     assertSame(str, testStr); 
 }
@Test
public void testNotEmptyString2396() { 
     Validate.notEmpty("a", "MSG"); 
     try { 
         Validate.notEmpty((String) null, "MSG"); 
         fail("Expecting NullPointerException"); 
     } catch (final NullPointerException ex) { 
         assertEquals("MSG", ex.getMessage()); 
     } 
     try { 
         Validate.notEmpty("", "MSG"); 
         fail("Expecting IllegalArgumentException"); 
     } catch (final IllegalArgumentException ex) { 
         assertEquals("MSG", ex.getMessage()); 
     } 
     final String str = "Hi"; 
     final String testStr = Validate.notEmpty(str, "Message"); 
     assertSame(str, testStr); 
 }
@Test
public void testNotBlankNullStringShouldThrow397() { 
     final String string = null; 
     try { 
         Validate.notBlank(string); 
         fail("Expecting NullPointerException"); 
     } catch (final NullPointerException e) { 
         assertEquals("The validated character sequence is blank", e.getMessage()); 
     } 
 }
@Test
public void testNoNullElementsArray1398() { 
     Validate.noNullElements(new Object[] { null }); 
     try { 
         Validate.noNullElements((Object[]) null); 
         fail("Expecting NullPointerException"); 
     } catch (final NullPointerException ex) { 
         assertEquals("The validated array is empty", ex.getMessage()); 
     } 
     try { 
         Validate.noNullElements(new Object[0]); 
         fail("Expecting IllegalArgumentException"); 
     } catch (final IllegalArgumentException ex) { 
         assertEquals("The validated array is empty", ex.getMessage()); 
     } 
     final String[] array = new String[] { "hi" }; 
     final String[] test = Validate.noNullElements(array); 
     assertSame(array, test); 
 }
@Test
public void testValidIndex_array399() { 
     final String[] array = new String[] { "a", "b", "c" }; 
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
     final String[] array2 = new String[] { "a", "b", "c" }; 
     final String[] array3 = new String[] { "a", "b", "c", "d" }; 
     final String[] array4 = new String[] { "a", "b", "c", "d", "e" }; 
     final String[] array5 = new String[] { "b", "c", "d", "e", "f" }; 
     final String[] array6 = new String[] { "a", "b", "c", "d", "e", "f" }; 
     final String[] array7 = new String[] { "a", "b", "c", "d", "e" }; 
     final String[] array8 = new String[] { "b", "c", "d", "e", "f" }; 
     final String[] array9 = Validate.validIndex(array8, 0); 
     assertSame(array8, array9); 
 }
@Test
public void testValidIndex_array400() { 
     final String[] array = new String[] { "a", "b", "c" }; 
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
     final String[] nullArray = null; 
     final String[] emptyArray = new String[] {}; 
     final String[] test = Validate.validIndex(emptyArray, 0); 
     assertSame(emptyArray, test); 
 }
@Test
public void testValidIndex_array401() { 
     final String[] array = new String[] { "a", "b", "c" }; 
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
     final String[] array2 = new String[] { "a", "b", "c" }; 
     final String[] array3 = new String[] { "a", "b", "c", "d" }; 
     final String[] array4 = new String[] { "a", "b", "c", "d", "e" }; 
     final String[] array5 = new String[] { "b", "c", "d", "e", "f" }; 
     final String[] array6 = new String[] { "a", "b", "c", "d", "e", "f" }; 
     final String[] array7 = new String[] { "a", "b", "c", "d", "e", "f" }; 
     final String[] array8 = new String[] { "b", "c", "d", "e", "f" }; 
     final String[] array9 = Validate.validIndex(array8, 0); 
     assertSame(array8, array9); 
 }
@Test
public void testValidIndex_array402() { 
     final Object[] array = new Object[] { "a", "b", "c", "d", "e", "f" }; 
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
     final String[] test = Validate.validIndex(strArray, 0); 
     assertSame(strArray, test); 
 }
@Test
public void testValidIndex_collection403() { 
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
public void testIsInstanceOfExceptionMessage404() { 
     try { 
         Validate.isInstanceOf(List.class, "hi"); 
         fail("Expecting IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
         assertEquals("The validated type: java.util.List, actual: java.lang.String", e.getMessage()); 
     } 
 }
@Test
public void testIsInstanceOf_withMessage405() { 
     Validate.isInstanceOf(CharSequence.class, "hi"); 
     Validate.isInstanceOf(AbstractList.class, "b", "Error"); 
     try { 
         Validate.isInstanceOf(List.class, "a", "Error"); 
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
