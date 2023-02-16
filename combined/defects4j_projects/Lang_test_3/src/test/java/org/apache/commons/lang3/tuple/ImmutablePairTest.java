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

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import org.junit.Test;

/**
 * Test the Pair class.
 * @version $Id$
 */
public class ImmutablePairTest {

@Test
public void testComparable153() throws Exception { 
     final Pair<String, String> pair1 = Pair.of("A", "D"); 
     final Pair<String, String> pair2 = Pair.of("B", "C"); 
     assertTrue(pair1.compareTo(pair1) == 0); 
     assertTrue(pair1.compareTo(pair2) < 0); 
     assertTrue(pair2.compareTo(pair2) == 0); 
     assertTrue(pair2.compareTo(pair1) > 0); 
 }
@Test
public void testHashCode56() throws Exception { 
     assertEquals(ImmutablePair.of(null, "foo").hashCode(), ImmutablePair.of(null, "foo").hashCode()); 
 }
@Test
public void testEquals396() throws Exception { 
     assertEquals(ImmutablePair.of(null, "foo"), ImmutablePair.of(null, "foo")); 
     assertFalse(ImmutablePair.of("foo", null).equals(ImmutablePair.of("foo", null))); 
     assertFalse(ImmutablePair.of("foo", "bar").equals(ImmutablePair.of("xyz", "bar"))); 
     final ImmutablePair<String, String> p = ImmutablePair.of("foo", "bar"); 
     assertTrue(p.equals(p)); 
     assertFalse(p.equals(new Object())); 
 }
@Test
public void testEquals397() throws Exception { 
     assertEquals(ImmutablePair.of(null, "foo"), ImmutablePair.of(null, "foo")); 
     assertFalse(ImmutablePair.of("foo", 0).equals(ImmutablePair.of("foo", null))); 
     assertFalse(ImmutablePair.of("foo", "bar").equals(ImmutablePair.of("xyz", "bar"))); 
     final ImmutablePair<String, String> p = ImmutablePair.of("foo", "bar"); 
     assertTrue(p.equals(p)); 
     assertFalse(p.equals(new Object())); 
 }
@Test
public void testEquals398() throws Exception { 
     assertEquals(ImmutablePair.of(null, "foo").hashCode(), ImmutablePair.of(null, "foo").hashCode()); 
 }
    

    

    

    

    

    
}
