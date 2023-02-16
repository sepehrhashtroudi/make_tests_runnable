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
public void testNotEmptyString2437() { 
     Validate.notEmpty("a", "MSG"); 
     try { 
         Validate.notEmpty((String) null, "MSG"); 
         fail("Expecting NullPointerException"); 
     } catch (final NullPointerException ex) { 
         assertEquals("MSG", ex.getMessage()); 
     } 
     try { 
         Validate.notEmpty(new Object[0], "MSG"); 
         fail("Expecting IllegalArgumentException"); 
     } catch (final IllegalArgumentException ex) { 
         assertEquals("MSG", ex.getMessage()); 
     } 
     final String str = "Hi"; 
     final String testStr = Validate.notEmpty(str, "Message"); 
     assertSame(str, testStr); 
 }
@Test
public void testNotBlankNullStringShouldThrow440() { 
     final String string = null; 
     try { 
         Validate.notBlank(string, "MSG"); 
         fail("Expecting NullPointerException"); 
     } catch (final NullPointerException ex) { 
         assertEquals("MSG", ex.getMessage()); 
     } 
 }
@Test
public void testNotBlankExMessageNotBlank441() { 
     final String string = "abc"; 
     try { 
         Validate.notBlank(string, "Error"); 
         fail("Expecting IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
         assertEquals("Error", e.getMessage()); 
     } 
 }
@Test
public void testNotBlankExceptionMessage442() { 
     final String string = "abc"; 
     try { 
         Validate.notBlank(string, "Error"); 
         fail("Expecting IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
         assertEquals("Error", e.getMessage()); 
     } 
 }
@Test
public void testValidIndex_withMessage_iterable443() { 
     final Collection<String> coll = new ArrayList<String>(); 
     coll.add(null); 
     coll.add(null); 
     Validate.validIndex(coll, 0); 
     Validate.validIndex(coll, 1); 
     try { 
         Validate.validIndex(coll, -1); 
         fail("Expecting IndexOutOfBoundsException"); 
     } catch (final IndexOutOfBoundsException ex) { 
         assertEquals("The validated iterable index is invalid: -1", ex.getMessage()); 
     } 
     try { 
         Validate.validIndex(coll, 2); 
         fail("Expecting IndexOutOfBoundsException"); 
     } catch (final IndexOutOfBoundsException ex) { 
         assertEquals("The validated iterable index is invalid: 2", ex.getMessage()); 
     } 
     final String[] strArray = new String[] { "Hi" }; 
     final String[] test = Validate.noNullElements(strArray, "Message"); 
     assertSame(strArray, test); 
 }
@Test
public void testValidIndex_withArray444() { 
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
public void testMatchesPattern445() { 
     final CharSequence str = "hi"; 
     Validate.matchesPattern(str, "[a-z]*", "Error"); 
     try { 
         Validate.matchesPattern(str, "[0-9]*", "Error"); 
         fail("Expecting IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
         assertEquals("Error", e.getMessage()); 
     } 
 }
@Test
public void testInclusiveBetween446() { 
     Validate.inclusiveBetween("a", "c", "b"); 
     Validate.inclusiveBetween(0, 2, 1); 
     try { 
         Validate.inclusiveBetween(0, 5, 6); 
         fail("Expecting IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
         assertEquals("The value 6 is not in the specified exclusive range of 0 to 5", e.getMessage()); 
     } 
     try { 
         Validate.inclusiveBetween(0, 5, 5); 
         fail("Expecting IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
         assertEquals("The value 5 is not in the specified exclusive range of 0 to 5", e.getMessage()); 
     } 
 }
@Test
public void testIsAssignableExceptionMessage447() { 
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
