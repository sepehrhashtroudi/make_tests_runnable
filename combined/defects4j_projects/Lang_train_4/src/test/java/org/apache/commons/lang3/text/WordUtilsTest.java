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
public void testCapitalize_String462() { 
     assertEquals(null, WordUtils.capitalize(null)); 
     assertEquals("", WordUtils.capitalize("")); 
     assertEquals("  ", WordUtils.capitalize("  ")); 
     assertEquals("I", WordUtils.capitalize("I")); 
     assertEquals("I", WordUtils.capitalize("i")); 
     assertEquals("I Am Here 123", WordUtils.capitalize("i am here 123")); 
     assertEquals("I Am Here 123", WordUtils.capitalize("I Am Here 123")); 
     assertEquals("I Am HERE 123", WordUtils.capitalize("i am HERE 123")); 
     assertEquals("I AM HERE 123", WordUtils.capitalize("I AM HERE 123")); 
 }
@Test
public void testCapitalizeFully_String463() { 
     assertEquals(null, WordUtils.capitalizeFully(null)); 
     assertEquals("", WordUtils.capitalizeFully("")); 
     assertEquals("  ", WordUtils.capitalizeFully("  ")); 
     assertEquals("I", WordUtils.capitalizeFully("I")); 
     assertEquals("I", WordUtils.capitalizeFully("i")); 
     assertEquals("I Am Here 123", WordUtils.capitalizeFully("i am here 123")); 
     assertEquals("I Am Here 123", WordUtils.capitalizeFully("I Am Here 123")); 
     assertEquals("I Am Here 123", WordUtils.capitalizeFully("i am HERE 123")); 
     assertEquals("I Am Here 123", WordUtils.capitalizeFully("I AM HERE 123")); 
 }
@Test
public void testUncapitalize_String464() { 
     assertEquals(null, WordUtils.uncapitalize(null)); 
     assertEquals("", WordUtils.uncapitalize("")); 
     assertEquals("  ", WordUtils.uncapitalize("  ")); 
     assertEquals("i", WordUtils.uncapitalize("I")); 
     assertEquals("i", WordUtils.uncapitalize("i")); 
     assertEquals("i am here 123", WordUtils.uncapitalize("i am here 123")); 
     assertEquals("i am here 123", WordUtils.uncapitalize("I Am Here 123")); 
     assertEquals("i am hERE 123", WordUtils.uncapitalize("i am HERE 123")); 
     assertEquals("i aM hERE 123", WordUtils.uncapitalize("I AM HERE 123")); 
 }
@Test
public void testUncapitalizeWithDelimiters_String465() { 
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
@Test
public void testSwapCase_String466() { 
     assertEquals(null, WordUtils.swapCase(null)); 
     assertEquals("", WordUtils.swapCase("")); 
     assertEquals("  ", WordUtils.swapCase("  ")); 
     assertEquals("i", WordUtils.swapCase("I")); 
     assertEquals("I", WordUtils.swapCase("i")); 
     assertEquals("I AM HERE 123", WordUtils.swapCase("i am here 123")); 
     assertEquals("i aM hERE 123", WordUtils.swapCase("I Am Here 123")); 
     assertEquals("I AM here 123", WordUtils.swapCase("i am HERE 123")); 
     assertEquals("i am here 123", WordUtils.swapCase("I AM HERE 123")); 
     final String test = "This String contains a TitleCase character: \u01C8"; 
     final String expect = "tHIS sTRING CONTAINS A tITLEcASE CHARACTER: \u01C9"; 
     assertEquals(expect, WordUtils.swapCase(test)); 
 }
@Test
public void testInitials_String467() { 
     assertEquals(null, WordUtils.initials(null)); 
     assertEquals("", WordUtils.initials("")); 
     assertEquals("", WordUtils.initials("  ")); 
     assertEquals("I", WordUtils.initials("I")); 
     assertEquals("i", WordUtils.initials("i")); 
     assertEquals("BJL", WordUtils.initials("Ben John Lee")); 
     assertEquals("BJ", WordUtils.initials("Ben J.Lee")); 
     assertEquals("BJ.L", WordUtils.initials(" Ben   John  . Lee")); 
     assertEquals("iah1", WordUtils.initials("i am here 123")); 
 }
@Test
public void testInitials_String_charArray468() { 
     char[] array = null; 
     assertEquals(null, WordUtils.initials(null, array)); 
     assertEquals("", WordUtils.initials("", array)); 
     assertEquals("", WordUtils.initials("  ", array)); 
     assertEquals("I", WordUtils.initials("I", array)); 
     assertEquals("i", WordUtils.initials("i", array)); 
     assertEquals("S", WordUtils.initials("SJC", array)); 
     assertEquals("BJL", WordUtils.initials("Ben John Lee", array)); 
     assertEquals("BJ", WordUtils.initials("Ben J.Lee", array)); 
     assertEquals("BJ.L", WordUtils.initials(" Ben   John  . Lee", array)); 
     assertEquals("KO", WordUtils.initials("Kay O'Murphy", array)); 
     assertEquals("iah1", WordUtils.initials("i am here 123", array)); 
     array = new char[0]; 
     assertEquals(null, WordUtils.initials(null, array)); 
     assertEquals("", WordUtils.initials("", array)); 
     assertEquals("", WordUtils.initials("  ", array)); 
     assertEquals("", WordUtils.initials("I", array)); 
     assertEquals("", WordUtils.initials("i", array)); 
     assertEquals("", WordUtils.initials("SJC", array)); 
     assertEquals("", WordUtils.initials("Ben John Lee", array)); 
     assertEquals("", WordUtils.initials("Ben J.Lee", array)); 
     assertEquals("", WordUtils.initials(" Ben   John  . Lee", array)); 
     assertEquals("", WordUtils.initials("Kay O'Murphy", array)); 
     assertEquals("", WordUtils.initials("i am here 123", array)); 
     array = " ".toCharArray(); 
     assertEquals(null, WordUtils.initials(null, array)); 
     assertEquals("", WordUtils.initials("", array)); 
     assertEquals("", WordUtils.initials("  ", array)); 
     assertEquals("I", WordUtils.initials("I", array)); 
     assertEquals("i", WordUtils.initials("i", array)); 
     assertEquals("S", WordUtils.initials("SJC", array)); 
     assertEquals("BJL", WordUtils.initials("Ben John Lee", array)); 
     assertEquals("BJ", WordUtils.initials("Ben J.Lee", array)); 
     assertEquals("BJ.L", WordUtils.initials(" Ben   John  . Lee", array)); 
     assertEquals("KO", WordUtils.initials("Kay O'Murphy", array)); 
     assertEquals("iah1", WordUtils.initials("i am here 123", array)); 
     array = " .".toCharArray(); 
     assertEquals(null, WordUtils.initials(null, array)); 
     assertEquals("", WordUtils.initials("", array)); 
     assertEquals("", WordUtils.initials("  ", array)); 
     assertEquals("I", WordUtils.initials("I", array)); 
     assertEquals("i", WordUtils.initials("i", array)); 
     assertEquals("S", WordUtils.initials("SJC", array)); 
     assertEquals("BJL", WordUtils.initials("Ben John Lee", array)); 
     assertEquals("BJL", WordUtils.initials("Ben J.Lee", array)); 
     assertEquals("BJL", WordUtils.initials(" Ben   John  . Lee", array)); 
     assertEquals("KO", WordUtils.initials("Kay O'Murphy", array)); 
     assertEquals("iah1", WordUtils.initials("i am here 123", array)); 
     array = " .'".toCharArray(); 
     assertEquals(null, WordUtils.initials(null, array)); 
     assertEquals("", WordUtils.initials("", array)); 
     assertEquals("", WordUtils.initials("  ", array)); 
     assertEquals("I", WordUtils.initials("I", array)); 
     assertEquals("i", WordUtils.initials("i", array)); 
     assertEquals("S", WordUtils.initials("SJC", array)); 
     assertEquals("BJL", WordUtils.initials("Ben John Lee", array)); 
     assertEquals("BJL", WordUtils.initials("Ben J.Lee", array)); 
     assertEquals("BJL", WordUtils.initials(" Ben   John  . Lee", array)); 
     assertEquals("KOM", WordUtils.initials("Kay O'Murphy", array)); 
     assertEquals("iah1", WordUtils.initials("i am here 123", array)); 
     array = "SIJo1".toCharArray(); 
     assertEquals(null, WordUtils.initials(null, array)); 
     assertEquals("", WordUtils.initials("", array)); 
     assertEquals(" ", WordUtils.initials("  ", array)); 
     assertEquals("", WordUtils.initials("I", array)); 
     assertEquals("i", WordUtils.initials("i", array)); 
     assertEquals("C", WordUtils.initials("SJC", array)); 
     assertEquals("Bh", WordUtils.initials("Ben John Lee", array)); 
     assertEquals("B.", WordUtils.initials("Ben J.Lee", array)); 
     assertEquals(" h", WordUtils.initials(" Ben   John  . Lee", array)); 
     assertEquals("K", WordUtils.initials("Kay O'Murphy", array)); 
     assertEquals("i2", WordUtils.initials("i am here 123", array)); 
 }
    
    
    //-----------------------------------------------------------------------
    
    
    
    
    //-----------------------------------------------------------------------
    
    
    

    
    
    

    
    
    

    //-----------------------------------------------------------------------
    

    // -----------------------------------------------------------------------
    

    // -----------------------------------------------------------------------
    

}
