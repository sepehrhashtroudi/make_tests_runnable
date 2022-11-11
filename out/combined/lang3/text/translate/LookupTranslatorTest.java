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

package org.apache.commons.lang3.text.translate;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.io.StringWriter;

import org.junit.Test;

/**
 * Unit tests for {@link org.apache.commons.lang3.text.translate.LookupTranslator}.
 * @version $Id$
 */
public class LookupTranslatorTest  {

@Test
public void testLang882172() throws IOException { 
     final LookupTranslator lt = new LookupTranslator(new CharSequence[][] { { new StringBuffer("one"), new StringBuffer("two") } }); 
     final StringWriter out = new StringWriter(); 
     final int result = lt.translate(new StringBuffer("one"), 0, out); 
     assertEquals("Incorrect codepoint consumption", 3, result); 
     assertEquals("Incorrect value", "two", out.toString()); 
 }
@Test
public void testLang882392() throws IOException { 
     final LookupTranslator lt = new LookupTranslator(new CharSequence[][] { { new StringBuffer("one"), new StringBuffer("two") } }); 
     final StringWriter out = new StringWriter(); 
     final int result = lt.translate(new StringBuffer("one"), 0, out); 
     assertEquals("Incorrect codepoint consumption", 3, result); 
     assertEquals("Incorrect value", "two", out.toString()); 
 }
@Test
public void testLang882626() throws IOException { 
     final LookupTranslator lt = new LookupTranslator(new CharSequence[][] { { new StringBuffer("one"), new StringBuffer("two") } }); 
     final StringWriter out = new StringWriter(); 
     final int result = lt.translate(new StringBuffer("one"), 0, out); 
     assertEquals("Incorrect codepoint consumption", 3, result); 
     assertEquals("Incorrect value", "two", out.toString()); 
 }
@Test
public void testLang882683() throws IOException { 
     final LookupTranslator lt = new LookupTranslator(new CharSequence[][] { { new StringBuffer("one"), new StringBuffer("two") } }); 
     final StringWriter out = new StringWriter(); 
     final int result = lt.translate(new StringBuffer("one"), 0, out); 
     assertEquals("Incorrect codepoint consumption", 3, result); 
     assertEquals("Incorrect value", "two", out.toString()); 
 }
@Test
public void testLang8821357() throws IOException { 
     final LookupTranslator lt = new LookupTranslator(new CharSequence[][] { { new StringBuffer("one"), new StringBuffer("two") } }); 
     final StringWriter out = new StringWriter(); 
     final int result = lt.translate(new StringBuffer("one"), 0, out); 
     assertEquals("Incorrect codepoint consumption", 3, result); 
     assertEquals("Incorrect value", "two", out.toString()); 
 }
@Test
public void testLang8822013() throws IOException { 
     final LookupTranslator lt = new LookupTranslator(new CharSequence[][] { { new StringBuffer("one"), new StringBuffer("two") } }); 
     final StringWriter out = new StringWriter(); 
     final int result = lt.translate(new StringBuffer("one"), 0, out); 
     assertEquals("Incorrect codepoint consumption", 3, result); 
     assertEquals("Incorrect value", "two", out.toString()); 
 }
@Test
public void testLang8822052() throws IOException { 
     final LookupTranslator lt = new LookupTranslator(new CharSequence[][] { { new StringBuffer("one"), new StringBuffer("two") } }); 
     final StringWriter out = new StringWriter(); 
     final int result = lt.translate(new StringBuffer("one"), 0, out); 
     assertEquals("Incorrect codepoint consumption", 3, result); 
     assertEquals("Incorrect value", "two", out.toString()); 
 }
@Test
public void testLang8822520() throws IOException { 
     final LookupTranslator lt = new LookupTranslator(new CharSequence[][] { { new StringBuffer("one"), new StringBuffer("two") } }); 
     final StringWriter out = new StringWriter(); 
     final int result = lt.translate(new StringBuffer("one"), 0, out); 
     assertEquals("Incorrect codepoint consumption", 3, result); 
     assertEquals("Incorrect value", "two", out.toString()); 
 }
@Test
public void testLang8823141() throws IOException { 
     final LookupTranslator lt = new LookupTranslator(new CharSequence[][] { { new StringBuffer("one"), new StringBuffer("two") } }); 
     final StringWriter out = new StringWriter(); 
     final int result = lt.translate(new StringBuffer("one"), 0, out); 
     assertEquals("Incorrect codepoint consumption", 3, result); 
     assertEquals("Incorrect value", "two", out.toString()); 
 }
@Test
public void testLang8823267() throws IOException { 
     final LookupTranslator lt = new LookupTranslator(new CharSequence[][] { { new StringBuffer("one"), new StringBuffer("two") } }); 
     final StringWriter out = new StringWriter(); 
     final int result = lt.translate(new StringBuffer("one"), 0, out); 
     assertEquals("Incorrect codepoint consumption", 3, result); 
     assertEquals("Incorrect value", "two", out.toString()); 
 }
@Test
public void testLang8823285() throws IOException { 
     final LookupTranslator lt = new LookupTranslator(new CharSequence[][] { { new StringBuffer("one"), new StringBuffer("two") } }); 
     final StringWriter out = new StringWriter(); 
     final int result = lt.translate(new StringBuffer("one"), 0, out); 
     assertEquals("Incorrect codepoint consumption", 3, result); 
     assertEquals("Incorrect value", "two", out.toString()); 
 }
@Test
public void testLang8824427() throws IOException { 
     final LookupTranslator lt = new LookupTranslator(new CharSequence[][] { { new StringBuffer("one"), new StringBuffer("two") } }); 
     final StringWriter out = new StringWriter(); 
     final int result = lt.translate(new StringBuffer("one"), 0, out); 
     assertEquals("Incorrect codepoint consumption", 3, result); 
     assertEquals("Incorrect value", "two", out.toString()); 
 }
@Test
public void testLang8824827() throws IOException { 
     final LookupTranslator lt = new LookupTranslator(new CharSequence[][] { { new StringBuffer("one"), new StringBuffer("two") } }); 
     final StringWriter out = new StringWriter(); 
     final int result = lt.translate(new StringBuffer("one"), 0, out); 
     assertEquals("Incorrect codepoint consumption", 3, result); 
     assertEquals("Incorrect value", "two", out.toString()); 
 }
@Test
public void testLang8824990() throws IOException { 
     final LookupTranslator lt = new LookupTranslator(new CharSequence[][] { { new StringBuffer("one"), new StringBuffer("two") } }); 
     final StringWriter out = new StringWriter(); 
     final int result = lt.translate(new StringBuffer("one"), 0, out); 
     assertEquals("Incorrect codepoint consumption", 3, result); 
     assertEquals("Incorrect value", "two", out.toString()); 
 }
@Test
public void testLang8825422() throws IOException { 
     final LookupTranslator lt = new LookupTranslator(new CharSequence[][] { { new StringBuffer("one"), new StringBuffer("two") } }); 
     final StringWriter out = new StringWriter(); 
     final int result = lt.translate(new StringBuffer("one"), 0, out); 
     assertEquals("Incorrect codepoint consumption", 3, result); 
     assertEquals("Incorrect value", "two", out.toString()); 
 }
@Test
public void testLang8826578() throws IOException { 
     final LookupTranslator lt = new LookupTranslator(new CharSequence[][] { { new StringBuffer("one"), new StringBuffer("two") } }); 
     final StringWriter out = new StringWriter(); 
     final int result = lt.translate(new StringBuffer("one"), 0, out); 
     assertEquals("Incorrect codepoint consumption", 3, result); 
     assertEquals("Incorrect value", "two", out.toString()); 
 }
@Test
public void testLang8826998() throws IOException { 
     final LookupTranslator lt = new LookupTranslator(new CharSequence[][] { { new StringBuffer("one"), new StringBuffer("two") } }); 
     final StringWriter out = new StringWriter(); 
     final int result = lt.translate(new StringBuffer("one"), 0, out); 
     assertEquals("Incorrect codepoint consumption", 3, result); 
     assertEquals("Incorrect value", "two", out.toString()); 
 }
@Test
public void testLang8827592() throws IOException { 
     final LookupTranslator lt = new LookupTranslator(new CharSequence[][] { { new StringBuffer("one"), new StringBuffer("two") } }); 
     final StringWriter out = new StringWriter(); 
     final int result = lt.translate(new StringBuffer("one"), 0, out); 
     assertEquals("Incorrect codepoint consumption", 3, result); 
     assertEquals("Incorrect value", "two", out.toString()); 
 }
@Test
public void testLang8827682() throws IOException { 
     final LookupTranslator lt = new LookupTranslator(new CharSequence[][] { { new StringBuffer("one"), new StringBuffer("two") } }); 
     final StringWriter out = new StringWriter(); 
     final int result = lt.translate(new StringBuffer("one"), 0, out); 
     assertEquals("Incorrect codepoint consumption", 3, result); 
     assertEquals("Incorrect value", "two", out.toString()); 
 }
@Test
public void testLang8827919() throws IOException { 
     final LookupTranslator lt = new LookupTranslator(new CharSequence[][] { { new StringBuffer("one"), new StringBuffer("two") } }); 
     final StringWriter out = new StringWriter(); 
     final int result = lt.translate(new StringBuffer("one"), 0, out); 
     assertEquals("Incorrect codepoint consumption", 3, result); 
     assertEquals("Incorrect value", "two", out.toString()); 
 }
@Test
public void testLang8828045() throws IOException { 
     final LookupTranslator lt = new LookupTranslator(new CharSequence[][] { { new StringBuffer("one"), new StringBuffer("two") } }); 
     final StringWriter out = new StringWriter(); 
     final int result = lt.translate(new StringBuffer("one"), 0, out); 
     assertEquals("Incorrect codepoint consumption", 3, result); 
     assertEquals("Incorrect value", "two", out.toString()); 
 }
@Test
public void testLang8828097() throws IOException { 
     final LookupTranslator lt = new LookupTranslator(new CharSequence[][] { { new StringBuffer("one"), new StringBuffer("two") } }); 
     final StringWriter out = new StringWriter(); 
     final int result = lt.translate(new StringBuffer("one"), 0, out); 
     assertEquals("Incorrect codepoint consumption", 3, result); 
     assertEquals("Incorrect value", "two", out.toString()); 
 }
@Test
public void testLang8828952() throws IOException { 
     final LookupTranslator lt = new LookupTranslator(new CharSequence[][] { { new StringBuffer("one"), new StringBuffer("two") } }); 
     final StringWriter out = new StringWriter(); 
     final int result = lt.translate(new StringBuffer("one"), 0, out); 
     assertEquals("Incorrect codepoint consumption", 3, result); 
     assertEquals("Incorrect value", "two", out.toString()); 
 }
    

    // Tests: https://issues.apache.org/jira/browse/LANG-882
    

}
