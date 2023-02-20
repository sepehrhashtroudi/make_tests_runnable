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
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.Calendar;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map.Entry;

import org.junit.Test;

/**
 * Test the Pair class.
 * 
 * @version $Id$
 */
public class PairTest {

@Test
public void testComparable1121() throws Exception { 
     final Pair<String, String> pair1 = Pair.of("A", "D"); 
     final Pair<String, String> pair2 = Pair.of("B", "C"); 
     assertTrue(pair1.compareTo(pair1) == 0); 
     assertTrue(pair1.compareTo(pair2) < 0); 
     assertTrue(pair2.compareTo(pair2) == 0); 
     assertTrue(pair2.compareTo(pair1) > 0); 
 }
@Test
public void testFormattable_simple122() throws Exception { 
     final Pair<String, String> pair = Pair.of("Key", "Value"); 
     assertEquals("(Key,Value)", String.format("%1$s", pair)); 
 }
@Test
public void testToStringCustom123() throws Exception { 
     final Calendar date = Calendar.getInstance(); 
     date.set(2011, Calendar.APRIL, 25); 
     final Pair<String, Calendar> pair = Pair.of("DOB", date); 
     assertEquals("Test created on " + "04-25-2011", pair.toString("Test created on %2$tm-%2$td-%2$tY")); 
 }
    

    

    

    

    

    

    

    

    

}
