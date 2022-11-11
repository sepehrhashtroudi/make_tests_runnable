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
package org.apache.commons.lang3.tuple;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.Calendar;
import java.util.HashSet;

import org.junit.Test;

/**
 * Test the Triple class.
 *
 * @version $Id$
 */
public class TripleTest {

@Test
public void testComparable1395() throws Exception { 
     final Triple<String, String, String> triple1 = Triple.of("A", "D", "A"); 
     final Triple<String, String, String> triple2 = Triple.of("B", "C", "A"); 
     assertTrue(triple1.compareTo(triple1) == 0); 
     assertTrue(triple1.compareTo(triple2) < 0); 
     assertTrue(triple2.compareTo(triple2) == 0); 
     assertTrue(triple2.compareTo(triple1) > 0); 
 }
@Test
public void testComparable1866() throws Exception { 
     final Triple<String, String, String> triple1 = Triple.of("A", "D", "A"); 
     final Triple<String, String, String> triple2 = Triple.of("B", "C", "A"); 
     assertTrue(triple1.compareTo(triple1) == 0); 
     assertTrue(triple1.compareTo(triple2) < 0); 
     assertTrue(triple2.compareTo(triple2) == 0); 
     assertTrue(triple2.compareTo(triple1) > 0); 
 }
@Test
public void testComparable1876() throws Exception { 
     final Triple<String, String, String> triple1 = Triple.of("A", "D", "A"); 
     final Triple<String, String, String> triple2 = Triple.of("B", "C", "A"); 
     assertTrue(triple1.compareTo(triple1) == 0); 
     assertTrue(triple1.compareTo(triple2) < 0); 
     assertTrue(triple2.compareTo(triple2) == 0); 
     assertTrue(triple2.compareTo(triple1) > 0); 
 }
@Test
public void testToStringCustom1991() throws Exception { 
     final Calendar date = Calendar.getInstance(); 
     date.set(2011, Calendar.APRIL, 25); 
     final Triple<String, String, Calendar> triple = Triple.of("DOB", "string", date); 
     assertEquals("Test created on " + "04-25-2011", triple.toString("Test created on %3$tm-%3$td-%3$tY")); 
 }
@Test
public void testFormattable_padded5859() throws Exception { 
     final Triple<String, String, String> triple = Triple.of("Key", "Something", "Value"); 
     assertEquals("         (Key,Something,Value)", String.format("%1$30s", triple)); 
 }
@Test
public void testComparable16935() throws Exception { 
     final Triple<String, String, String> triple1 = Triple.of("A", "D", "A"); 
     final Triple<String, String, String> triple2 = Triple.of("B", "C", "A"); 
     assertTrue(triple1.compareTo(triple1) == 0); 
     assertTrue(triple1.compareTo(triple2) < 0); 
     assertTrue(triple2.compareTo(triple2) == 0); 
     assertTrue(triple2.compareTo(triple1) > 0); 
 }
@Test
public void testFormattable_padded7668() throws Exception { 
     final Triple<String, String, String> triple = Triple.of("Key", "Something", "Value"); 
     assertEquals("         (Key,Something,Value)", String.format("%1$30s", triple)); 
 }
@Test
public void testToStringCustom8892() throws Exception { 
     final Calendar date = Calendar.getInstance(); 
     date.set(2011, Calendar.APRIL, 25); 
     final Triple<String, String, Calendar> triple = Triple.of("DOB", "string", date); 
     assertEquals("Test created on " + "04-25-2011", triple.toString("Test created on %3$tm-%3$td-%3$tY")); 
 }
    

    

    

    

    

    

    

    

    

    

}

