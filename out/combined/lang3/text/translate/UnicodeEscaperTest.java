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

import org.junit.Test;

/**
 * Unit tests for {@link org.apache.commons.lang3.text.translate.UnicodeEscaper}.
 * @version $Id$
 */
public class UnicodeEscaperTest  {

@Test
public void testBetween609() { 
     final UnicodeEscaper ue = UnicodeEscaper.between('F', 'L'); 
     final String input = "ADFGZ"; 
     final String result = ue.translate(input); 
     assertEquals("Failed to escape Unicode characters via the between method", "AD\\u0046\\u0047Z", result); 
 }
@Test
public void testBetween1014() { 
     final UnicodeEscaper ue = UnicodeEscaper.between('F', 'L'); 
     final String input = "ADFGZ"; 
     final String result = ue.translate(input); 
     assertEquals("Failed to escape Unicode characters via the between method", "AD\\u0046\\u0047Z", result); 
 }
@Test
public void testBetween1280() { 
     final UnicodeEscaper ue = UnicodeEscaper.between('F', 'L'); 
     final String input = "ADFGZ"; 
     final String result = ue.translate(input); 
     assertEquals("Failed to escape Unicode characters via the between method", "AD\\u0046\\u0047Z", result); 
 }
@Test
public void testAbove1343() { 
     final UnicodeEscaper ue = UnicodeEscaper.above('F'); 
     final String input = "ADFGZ"; 
     final String result = ue.translate(input); 
     assertEquals("Failed to escape Unicode characters via the above method", "ADF\\u0047\\u005A", result); 
 }
@Test
public void testBelow2206() { 
     final UnicodeEscaper ue = UnicodeEscaper.below('F'); 
     final String input = "ADFGZ"; 
     final String result = ue.translate(input); 
     assertEquals("Failed to escape Unicode characters via the below method", "\\u0041\\u0044FGZ", result); 
 }
@Test
public void testAbove2743() { 
     final UnicodeEscaper ue = UnicodeEscaper.above('F'); 
     final String input = "ADFGZ"; 
     final String result = ue.translate(input); 
     assertEquals("Failed to escape Unicode characters via the above method", "ADF\\u0047\\u005A", result); 
 }
@Test
public void testBetween2879() { 
     final UnicodeEscaper ue = UnicodeEscaper.between('F', 'L'); 
     final String input = "ADFGZ"; 
     final String result = ue.translate(input); 
     assertEquals("Failed to escape Unicode characters via the between method", "AD\\u0046\\u0047Z", result); 
 }
@Test
public void testBetween3518() { 
     final UnicodeEscaper ue = UnicodeEscaper.between('F', 'L'); 
     final String input = "ADFGZ"; 
     final String result = ue.translate(input); 
     assertEquals("Failed to escape Unicode characters via the between method", "AD\\u0046\\u0047Z", result); 
 }
@Test
public void testBetween3572() { 
     final UnicodeEscaper ue = UnicodeEscaper.between('F', 'L'); 
     final String input = "ADFGZ"; 
     final String result = ue.translate(input); 
     assertEquals("Failed to escape Unicode characters via the between method", "AD\\u0046\\u0047Z", result); 
 }
@Test
public void testAbove3850() { 
     final UnicodeEscaper ue = UnicodeEscaper.above('F'); 
     final String input = "ADFGZ"; 
     final String result = ue.translate(input); 
     assertEquals("Failed to escape Unicode characters via the above method", "ADF\\u0047\\u005A", result); 
 }
@Test
public void testBetween4008() { 
     final UnicodeEscaper ue = UnicodeEscaper.between('F', 'L'); 
     final String input = "ADFGZ"; 
     final String result = ue.translate(input); 
     assertEquals("Failed to escape Unicode characters via the between method", "AD\\u0046\\u0047Z", result); 
 }
@Test
public void testBetween4054() { 
     final UnicodeEscaper ue = UnicodeEscaper.between('F', 'L'); 
     final String input = "ADFGZ"; 
     final String result = ue.translate(input); 
     assertEquals("Failed to escape Unicode characters via the between method", "AD\\u0046\\u0047Z", result); 
 }
@Test
public void testBetween4093() { 
     final UnicodeEscaper ue = UnicodeEscaper.between('F', 'L'); 
     final String input = "ADFGZ"; 
     final String result = ue.translate(input); 
     assertEquals("Failed to escape Unicode characters via the between method", "AD\\u0046\\u0047Z", result); 
 }
@Test
public void testBetween4267() { 
     final UnicodeEscaper ue = UnicodeEscaper.between('F', 'L'); 
     final String input = "ADFGZ"; 
     final String result = ue.translate(input); 
     assertEquals("Failed to escape Unicode characters via the between method", "AD\\u0046\\u0047Z", result); 
 }
@Test
public void testBetween5173() { 
     final UnicodeEscaper ue = UnicodeEscaper.between('F', 'L'); 
     final String input = "ADFGZ"; 
     final String result = ue.translate(input); 
     assertEquals("Failed to escape Unicode characters via the between method", "AD\\u0046\\u0047Z", result); 
 }
@Test
public void testBelow5174() { 
     final UnicodeEscaper ue = UnicodeEscaper.below('F'); 
     final String input = "ADFGZ"; 
     final String result = ue.translate(input); 
     assertEquals("Failed to escape Unicode characters via the below method", "\\u0041\\u0044FGZ", result); 
 }
@Test
public void testBetween5674() { 
     final UnicodeEscaper ue = UnicodeEscaper.between('F', 'L'); 
     final String input = "ADFGZ"; 
     final String result = ue.translate(input); 
     assertEquals("Failed to escape Unicode characters via the between method", "AD\\u0046\\u0047Z", result); 
 }
@Test
public void testBetween6635() { 
     final UnicodeEscaper ue = UnicodeEscaper.between('F', 'L'); 
     final String input = "ADFGZ"; 
     final String result = ue.translate(input); 
     assertEquals("Failed to escape Unicode characters via the between method", "AD\\u0046\\u0047Z", result); 
 }
@Test
public void testBetween7495() { 
     final UnicodeEscaper ue = UnicodeEscaper.between('F', 'L'); 
     final String input = "ADFGZ"; 
     final String result = ue.translate(input); 
     assertEquals("Failed to escape Unicode characters via the between method", "AD\\u0046\\u0047Z", result); 
 }
@Test
public void testAbove7538() { 
     final UnicodeEscaper ue = UnicodeEscaper.above('F'); 
     final String input = "ADFGZ"; 
     final String result = ue.translate(input); 
     assertEquals("Failed to escape Unicode characters via the above method", "ADF\\u0047\\u005A", result); 
 }
@Test
public void testAbove8104() { 
     final UnicodeEscaper ue = UnicodeEscaper.above('F'); 
     final String input = "ADFGZ"; 
     final String result = ue.translate(input); 
     assertEquals("Failed to escape Unicode characters via the above method", "ADF\\u0047\\u005A", result); 
 }
@Test
public void testAbove8718() { 
     final UnicodeEscaper ue = UnicodeEscaper.above('F'); 
     final String input = "ADFGZ"; 
     final String result = ue.translate(input); 
     assertEquals("Failed to escape Unicode characters via the above method", "ADF\\u0047\\u005A", result); 
 }
@Test
public void testBetween9272() { 
     final UnicodeEscaper ue = UnicodeEscaper.between('F', 'L'); 
     final String input = "ADFGZ"; 
     final String result = ue.translate(input); 
     assertEquals("Failed to escape Unicode characters via the between method", "AD\\u0046\\u0047Z", result); 
 }
@Test
public void testBetween9548() { 
     final UnicodeEscaper ue = UnicodeEscaper.between('F', 'L'); 
     final String input = "ADFGZ"; 
     final String result = ue.translate(input); 
     assertEquals("Failed to escape Unicode characters via the between method", "AD\\u0046\\u0047Z", result); 
 }
    

    

    
}
