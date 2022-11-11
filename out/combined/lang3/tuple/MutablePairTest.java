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
 * Test the MutablePair class.
 * @version $Id$
 */
public class MutablePairTest {

@Test
@SuppressWarnings("unchecked") 
 public void testSerialization223() throws Exception { 
     final MutablePair<Integer, String> origPair = MutablePair.of(0, "foo"); 
     final ByteArrayOutputStream baos = new ByteArrayOutputStream(); 
     final ObjectOutputStream out = new ObjectOutputStream(baos); 
     out.writeObject(origPair); 
     final MutablePair<Integer, String> deserializedPair = (MutablePair<Integer, String>) new ObjectInputStream(new ByteArrayInputStream(baos.toByteArray())).readObject(); 
     assertEquals(origPair, deserializedPair); 
     assertEquals(origPair.hashCode(), deserializedPair.hashCode()); 
 }
@Test
public void testMutate879() throws Exception { 
     final MutablePair<Integer, String> pair = new MutablePair<Integer, String>(0, "foo"); 
     pair.setLeft(42); 
     pair.setRight("bar"); 
     assertEquals(42, pair.getLeft().intValue()); 
     assertEquals("bar", pair.getRight()); 
 }
@Test
@SuppressWarnings("unchecked") 
 public void testSerialization2104() throws Exception { 
     final MutablePair<Integer, String> origPair = MutablePair.of(0, "foo"); 
     final ByteArrayOutputStream baos = new ByteArrayOutputStream(); 
     final ObjectOutputStream out = new ObjectOutputStream(baos); 
     out.writeObject(origPair); 
     final MutablePair<Integer, String> deserializedPair = (MutablePair<Integer, String>) new ObjectInputStream(new ByteArrayInputStream(baos.toByteArray())).readObject(); 
     assertEquals(origPair, deserializedPair); 
     assertEquals(origPair.hashCode(), deserializedPair.hashCode()); 
 }
@Test
public void testMutate2316() throws Exception { 
     final MutablePair<Integer, String> pair = new MutablePair<Integer, String>(0, "foo"); 
     pair.setLeft(42); 
     pair.setRight("bar"); 
     assertEquals(42, pair.getLeft().intValue()); 
     assertEquals("bar", pair.getRight()); 
 }
@Test
public void testMutate2360() throws Exception { 
     final MutablePair<Integer, String> pair = new MutablePair<Integer, String>(0, "foo"); 
     pair.setLeft(42); 
     pair.setRight("bar"); 
     assertEquals(42, pair.getLeft().intValue()); 
     assertEquals("bar", pair.getRight()); 
 }
@Test
public void testEquals2956() throws Exception { 
     assertEquals(MutablePair.of(null, "foo"), MutablePair.of(null, "foo")); 
     assertFalse(MutablePair.of("foo", 0).equals(MutablePair.of("foo", null))); 
     assertFalse(MutablePair.of("foo", "bar").equals(MutablePair.of("xyz", "bar"))); 
     final MutablePair<String, String> p = MutablePair.of("foo", "bar"); 
     assertTrue(p.equals(p)); 
     assertFalse(p.equals(new Object())); 
 }
@Test
@SuppressWarnings("unchecked") 
 public void testSerialization3157() throws Exception { 
     final MutablePair<Integer, String> origPair = MutablePair.of(0, "foo"); 
     final ByteArrayOutputStream baos = new ByteArrayOutputStream(); 
     final ObjectOutputStream out = new ObjectOutputStream(baos); 
     out.writeObject(origPair); 
     final MutablePair<Integer, String> deserializedPair = (MutablePair<Integer, String>) new ObjectInputStream(new ByteArrayInputStream(baos.toByteArray())).readObject(); 
     assertEquals(origPair, deserializedPair); 
     assertEquals(origPair.hashCode(), deserializedPair.hashCode()); 
 }
@Test
@SuppressWarnings("unchecked") 
 public void testSerialization4002() throws Exception { 
     final MutablePair<Integer, String> origPair = MutablePair.of(0, "foo"); 
     final ByteArrayOutputStream baos = new ByteArrayOutputStream(); 
     final ObjectOutputStream out = new ObjectOutputStream(baos); 
     out.writeObject(origPair); 
     final MutablePair<Integer, String> deserializedPair = (MutablePair<Integer, String>) new ObjectInputStream(new ByteArrayInputStream(baos.toByteArray())).readObject(); 
     assertEquals(origPair, deserializedPair); 
     assertEquals(origPair.hashCode(), deserializedPair.hashCode()); 
 }
@Test
@SuppressWarnings("unchecked") 
 public void testSerialization4419() throws Exception { 
     final MutablePair<Integer, String> origPair = MutablePair.of(0, "foo"); 
     final ByteArrayOutputStream baos = new ByteArrayOutputStream(); 
     final ObjectOutputStream out = new ObjectOutputStream(baos); 
     out.writeObject(origPair); 
     final MutablePair<Integer, String> deserializedPair = (MutablePair<Integer, String>) new ObjectInputStream(new ByteArrayInputStream(baos.toByteArray())).readObject(); 
     assertEquals(origPair, deserializedPair); 
     assertEquals(origPair.hashCode(), deserializedPair.hashCode()); 
 }
@Test
public void testEquals5125() throws Exception { 
     assertEquals(MutablePair.of(null, "foo"), MutablePair.of(null, "foo")); 
     assertFalse(MutablePair.of("foo", 0).equals(MutablePair.of("foo", null))); 
     assertFalse(MutablePair.of("foo", "bar").equals(MutablePair.of("xyz", "bar"))); 
     final MutablePair<String, String> p = MutablePair.of("foo", "bar"); 
     assertTrue(p.equals(p)); 
     assertFalse(p.equals(new Object())); 
 }
@Test
@SuppressWarnings("unchecked") 
 public void testSerialization5366() throws Exception { 
     final MutablePair<Integer, String> origPair = MutablePair.of(0, "foo"); 
     final ByteArrayOutputStream baos = new ByteArrayOutputStream(); 
     final ObjectOutputStream out = new ObjectOutputStream(baos); 
     out.writeObject(origPair); 
     final MutablePair<Integer, String> deserializedPair = (MutablePair<Integer, String>) new ObjectInputStream(new ByteArrayInputStream(baos.toByteArray())).readObject(); 
     assertEquals(origPair, deserializedPair); 
     assertEquals(origPair.hashCode(), deserializedPair.hashCode()); 
 }
@Test
public void testMutate6248() throws Exception { 
     final MutablePair<Integer, String> pair = new MutablePair<Integer, String>(0, "foo"); 
     pair.setLeft(42); 
     pair.setRight("bar"); 
     assertEquals(42, pair.getLeft().intValue()); 
     assertEquals("bar", pair.getRight()); 
 }
@Test
@SuppressWarnings("unchecked") 
 public void testSerialization7170() throws Exception { 
     final MutablePair<Integer, String> origPair = MutablePair.of(0, "foo"); 
     final ByteArrayOutputStream baos = new ByteArrayOutputStream(); 
     final ObjectOutputStream out = new ObjectOutputStream(baos); 
     out.writeObject(origPair); 
     final MutablePair<Integer, String> deserializedPair = (MutablePair<Integer, String>) new ObjectInputStream(new ByteArrayInputStream(baos.toByteArray())).readObject(); 
     assertEquals(origPair, deserializedPair); 
     assertEquals(origPair.hashCode(), deserializedPair.hashCode()); 
 }
@Test
public void testDefault7703() throws Exception { 
     final MutablePair<Integer, String> pair = new MutablePair<Integer, String>(); 
     assertNull(pair.getLeft()); 
     assertNull(pair.getRight()); 
 }
@Test
@SuppressWarnings("unchecked") 
 public void testSerialization8072() throws Exception { 
     final MutablePair<Integer, String> origPair = MutablePair.of(0, "foo"); 
     final ByteArrayOutputStream baos = new ByteArrayOutputStream(); 
     final ObjectOutputStream out = new ObjectOutputStream(baos); 
     out.writeObject(origPair); 
     final MutablePair<Integer, String> deserializedPair = (MutablePair<Integer, String>) new ObjectInputStream(new ByteArrayInputStream(baos.toByteArray())).readObject(); 
     assertEquals(origPair, deserializedPair); 
     assertEquals(origPair.hashCode(), deserializedPair.hashCode()); 
 }
@Test
@SuppressWarnings("unchecked") 
 public void testSerialization8205() throws Exception { 
     final MutablePair<Integer, String> origPair = MutablePair.of(0, "foo"); 
     final ByteArrayOutputStream baos = new ByteArrayOutputStream(); 
     final ObjectOutputStream out = new ObjectOutputStream(baos); 
     out.writeObject(origPair); 
     final MutablePair<Integer, String> deserializedPair = (MutablePair<Integer, String>) new ObjectInputStream(new ByteArrayInputStream(baos.toByteArray())).readObject(); 
     assertEquals(origPair, deserializedPair); 
     assertEquals(origPair.hashCode(), deserializedPair.hashCode()); 
 }
@Test
@SuppressWarnings("unchecked") 
 public void testSerialization8745() throws Exception { 
     final MutablePair<Integer, String> origPair = MutablePair.of(0, "foo"); 
     final ByteArrayOutputStream baos = new ByteArrayOutputStream(); 
     final ObjectOutputStream out = new ObjectOutputStream(baos); 
     out.writeObject(origPair); 
     final MutablePair<Integer, String> deserializedPair = (MutablePair<Integer, String>) new ObjectInputStream(new ByteArrayInputStream(baos.toByteArray())).readObject(); 
     assertEquals(origPair, deserializedPair); 
     assertEquals(origPair.hashCode(), deserializedPair.hashCode()); 
 }
@Test
public void testDefault8863() throws Exception { 
     final MutablePair<Integer, String> pair = new MutablePair<Integer, String>(); 
     assertNull(pair.getLeft()); 
     assertNull(pair.getRight()); 
 }
    

    
    
    

    

    

    

    

    
}
