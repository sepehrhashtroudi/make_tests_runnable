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
public void testConstructor445() { 
     assertNotNull(new WordUtils()); 
     final Constructor<?>[] cons = WordUtils.class.getDeclaredConstructors(); 
     assertEquals(1, cons.length); 
     assertTrue(Modifier.isPublic(cons[0].getModifiers())); 
     assertTrue(Modifier.isPublic(WordUtils.class.getModifiers())); 
     assertFalse(Modifier.isFinal(WordUtils.class.getModifiers())); 
 }
@Test
public void testWrap_StringInt446() { 
     assertEquals(null, WordUtils.wrap(null, 20)); 
     assertEquals(null, WordUtils.wrap(null, -1)); 
     assertEquals("", WordUtils.wrap("", 20)); 
     assertEquals("", WordUtils.wrap("", -1)); 
     final String systemNewLine = System.getProperty("line.separator"); 
     String input = "Here is one line of text that is going to be wrapped after 20 columns."; 
     String expected = "Here is one line of" + systemNewLine + "text that is going" + systemNewLine + "to be wrapped after" + systemNewLine + "20 columns."; 
     assertEquals(expected, WordUtils.wrap(input, 20)); 
     input = "Click here to jump to the jakarta website - http://jakarta.apache.org"; 
     expected = "Click here to jump" + systemNewLine + "to the jakarta" + systemNewLine + "website -" + systemNewLine + "http://jakarta.apache.org"; 
     assertEquals(expected, WordUtils.wrap(input, 20)); 
     input = "Click here, http://jakarta.apache.org, to jump to the jakarta website"; 
     expected = "Click here," + systemNewLine + "http://jakarta.apache.org," + systemNewLine + "to jump to the" + systemNewLine + "jakarta website"; 
     assertEquals(expected, WordUtils.wrap(input, 20)); 
 }
@Test
public void testWrap_StringIntStringBoolean447() { 
     assertEquals(null, WordUtils.wrap(null, 20, "\n", false)); 
     assertEquals(null, WordUtils.wrap(null, 20, "\n", true)); 
     assertEquals(null, WordUtils.wrap(null, 20, null, true)); 
     assertEquals(null, WordUtils.wrap(null, 20, null, false)); 
     assertEquals(null, WordUtils.wrap(null, -1, null, true)); 
     assertEquals(null, WordUtils.wrap(null, -1, null, false)); 
     assertEquals("", WordUtils.wrap("", 20, "\n", false)); 
     assertEquals("", WordUtils.wrap("", 20, "\n", true)); 
     assertEquals("", WordUtils.wrap("", 20, null, false)); 
     assertEquals("", WordUtils.wrap("", 20, null, true)); 
     assertEquals("", WordUtils.wrap("", -1, null, false)); 
     assertEquals("", WordUtils.wrap("", -1, null, true)); 
     String input = "Here is one line of text that is going to be wrapped after 20 columns."; 
     String expected = "Here is one line of\ntext that is going\nto be wrapped after\n20 columns."; 
     assertEquals(expected, WordUtils.wrap(input, 20, "\n", false)); 
     assertEquals(expected, WordUtils.wrap(input, 20, "\n", true)); 
     input = "Here is one line of text that is going to be wrapped after 20 columns."; 
     expected = "Here is one line of<br />text that is going<br />to be wrapped after<br />20 columns."; 
     assertEquals(expected, WordUtils.wrap(input, 20, "<br />", false)); 
     assertEquals(expected, WordUtils.wrap(input, 20, "<br />", true)); 
     input = "Here is one line"; 
     expected = "Here\nis one\nline"; 
     assertEquals(expected, WordUtils.wrap(input, 6, "\n", false)); 
     expected = "Here\nis\none\nline"; 
     assertEquals(expected, WordUtils.wrap(input, 2, "\n", false)); 
     assertEquals(expected, WordUtils.wrap(input, -1, "\n", false)); 
     final String systemNewLine = System.getProperty("line.separator"); 
     input = "Here is one line of text that is going to be wrapped after 20 columns."; 
     expected = "Here is one line of" + systemNewLine + "text that is going" + systemNewLine + "to be wrapped after" + systemNewLine + "20 columns."; 
     assertEquals(expected, WordUtils.wrap(input, 20, null, false)); 
     assertEquals(expected, WordUtils.wrap(input, 20, null, true)); 
     input = " Here:  is  one  line  of  text  that  is  going  to  be  wrapped  after  20  columns."; 
     expected = "Here:  is  one  line\nof  text  that  is \ngoing  to  be \nwrapped  after  20 \ncolumns."; 
     assertEquals(expected, WordUtils.wrap(input, 20, "\n", false)); 
     assertEquals(expected, WordUtils.wrap(input, 20, "\n", true)); 
     input = "Here is\tone line of text that is going to be wrapped after 20 columns."; 
     expected = "Here is\tone line of\ntext that is going\nto be wrapped after\n20 columns."; 
     assertEquals(expected, WordUtils.wrap(input, 20, "\n", false)); 
     assertEquals(expected, WordUtils.wrap(input, 20, "\n", true)); 
     input = "Here is one line of\ttext that is going to be wrapped after 20 columns."; 
     expected = "Here is one line\nof\ttext that is\ngoing to be wrapped\nafter 20 columns."; 
     assertEquals(expected, WordUtils.wrap(input, 20, "\n", false)); 
     assertEquals(expected, WordUtils.wrap(input, 20, "\n", true)); 
     input = "Click here to jump to the jakarta website - http://jakarta.apache.org"; 
     expected = "Click here to jump\nto the jakarta\nwebsite -\nhttp://jakarta.apache.org"; 
     assertEquals(expected, WordUtils.wrap(input, 20, "\n", false)); 
     expected = "Click here to jump\nto the jakarta\nwebsite -\nhttp://jakarta.apach\ne.org"; 
     assertEquals(expected, WordUtils.wrap(input, 20, "\n", true)); 
     input = "Click here, http://jakarta.apache.org, to jump to the jakarta website"; 
     expected = "Click here,\nhttp://jakarta.apache.org,\nto jump to the\njakarta website"; 
     assertEquals(expected, WordUtils.wrap(input, 20, "\n", false)); 
     expected = "Click here,\nhttp://jakarta.apach\ne.org, to jump to\nthe jakarta website"; 
     assertEquals(expected, WordUtils.wrap(input, 20, "\n", true)); 
 }
@Test
public void testCapitalize_String448() { 
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
public void testCapitalizeFully_String449() { 
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
public void testSwapCase_String450() { 
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
public void testInitials_String451() { 
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
public void testInitials_String_charArray452() { 
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
