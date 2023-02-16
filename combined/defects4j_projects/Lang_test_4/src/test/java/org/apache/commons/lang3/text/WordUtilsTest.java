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
package org.apache.commons.lang3.text;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;

import org.junit.Test;

/**
 * Unit tests for WordUtils class.
 * 
 * @version $Id$
 */
public class WordUtilsTest {

    //-----------------------------------------------------------------------
@Test
public void testConstructor175() { 
     assertNotNull(new WordUtils()); 
     final Constructor<?>[] cons = WordUtils.class.getDeclaredConstructors(); 
     assertEquals(1, cons.length); 
     assertTrue(Modifier.isPublic(cons[0].getModifiers())); 
     assertTrue(Modifier.isPublic(WordUtils.class.getModifiers())); 
     assertFalse(Modifier.isFinal(WordUtils.class.getModifiers())); 
 }
@Test
public void testUncapitalizeWithDelimiters_String176() { 
     assertEquals(null, WordUtils.uncapitalize(null, null)); 
     assertEquals("", WordUtils.uncapitalize("", new char[0])); 
     assertEquals("  ", WordUtils.uncapitalize("  ", new char[0])); 
     char[] chars = new char[] { '-', '+', ' ', '@' }; 
     assertEquals("i", WordUtils.uncapitalize("I", chars)); 
     assertEquals("i", WordUtils.uncapitalize("i", chars)); 
     assertEquals("i am-here+123", WordUtils.uncapitalize("i am-here+123", chars)); 
     assertEquals("i+am here-123", WordUtils.uncapitalize("I+Am Here-123", chars)); 
     assertEquals("i-am+hERE 123", WordUtils.uncapitalize("i-am+HERE 123", chars)); 
     assertEquals("i aM-hERE+123", WordUtils.uncapitalize("I AM-HERE+123", chars)); 
     chars = new char[] { '.' }; 
     assertEquals("i AM.fINE", WordUtils.uncapitalize("I AM.FINE", chars)); 
     assertEquals("i aM.FINE", WordUtils.uncapitalize("I AM.FINE", null)); 
 }
    
    
    //-----------------------------------------------------------------------
    
    
    
    
    //-----------------------------------------------------------------------
    
    
    

    
    
    

    
    
    

    //-----------------------------------------------------------------------
    

    // -----------------------------------------------------------------------
    

    // -----------------------------------------------------------------------
    

}
