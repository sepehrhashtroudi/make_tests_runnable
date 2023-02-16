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
public void testComparable336() throws Exception { 
     final Calendar date1 = Calendar.getInstance(); 
     final Calendar date2 = Calendar.getInstance(); 
     date1.set(2011, Calendar.APRIL, 25); 
     date2.set(2011, Calendar.APRIL, 26); 
     final Pair<String, Calendar> pair1 = Pair.of("DOB", date1); 
     final Pair<String, Calendar> pair2 = Pair.of("DOB", date2); 
     assertTrue(pair1.compareTo(pair1) == 0); 
     assertTrue(pair1.compareTo(pair2) < 0); 
     assertTrue(pair2.compareTo(pair2) == 0); 
     assertTrue(pair2.compareTo(pair1) == 0); 
     assertTrue(pair2.compareTo(pair2) == 0); 
     assertTrue(pair2.compareTo(pair1) > 0); 
 }
    

    

    

    

    

    

    

    

    

}
