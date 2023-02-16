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
 * Test the MutableTriple class.
 * @version $Id$
 */
public class MutableTripleTest {

@Test
public void testEquals293() throws Exception { 
     assertEquals(MutableTriple.of(null, "foo", 42), MutableTriple.of(null, "foo", 42)); 
     assertFalse(MutableTriple.of("foo", 0, Boolean.TRUE).equals(MutableTriple.of("foo", null, null))); 
     assertFalse(MutableTriple.of("foo", "bar", "baz").equals(MutableTriple.of("xyz", "bar", "blo"))); 
     final MutableTriple<String, String, String> p = MutableTriple.of("foo", "bar", "baz"); 
     assertTrue(p.equals(p)); 
     assertFalse(p.equals(new Object())); 
 }
@Test
public void testDefault294() throws Exception { 
     final MutableTriple<Integer, String, Boolean> triple = new MutableTriple<Integer, String, Boolean>(); 
     assertNull(triple.getLeft()); 
     assertNull(triple.getMiddle()); 
     assertNull(triple.getRight()); 
 }
@Test
public void testEquals295() throws Exception { 
     assertEquals(ImmutableTriple.of(null, "foo", 42), MutableTriple.of(null, "foo", 42)); 
     assertFalse(ImmutableTriple.of("foo", 0, Boolean.TRUE).equals(MutableTriple.of("foo", null, null))); 
     assertFalse(ImmutableTriple.of("foo", "bar", "baz").equals(MutableTriple.of("xyz", "bar", "blo"))); 
     final MutableTriple<String, String, String> p = MutableTriple.of("foo", "bar", "baz"); 
     assertTrue(p.equals(p)); 
     assertFalse(p.equals(new Object())); 
 }
    

    
    
    

    

    

    

    

    
}

