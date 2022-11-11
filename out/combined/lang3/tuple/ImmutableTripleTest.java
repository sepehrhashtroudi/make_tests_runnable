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
 * Test the Triple class.
 * @version $Id$
 */
public class ImmutableTripleTest {

@Test
public void testBasic291() throws Exception { 
     final ImmutableTriple<Integer, String, Boolean> triple = new ImmutableTriple<Integer, String, Boolean>(0, "foo", Boolean.TRUE); 
     assertEquals(0, triple.left.intValue()); 
     assertEquals(0, triple.getLeft().intValue()); 
     assertEquals("foo", triple.middle); 
     assertEquals("foo", triple.getMiddle()); 
     assertEquals(Boolean.TRUE, triple.right); 
     assertEquals(Boolean.TRUE, triple.getRight()); 
     final ImmutableTriple<Object, String, Integer> triple2 = new ImmutableTriple<Object, String, Integer>(null, "bar", 42); 
     assertNull(triple2.left); 
     assertNull(triple2.getLeft()); 
     assertEquals("bar", triple2.middle); 
     assertEquals("bar", triple2.getMiddle()); 
     assertEquals(new Integer(42), triple2.right); 
     assertEquals(new Integer(42), triple2.getRight()); 
 }
@Test
public void testBasic856() throws Exception { 
     final ImmutableTriple<Integer, String, Boolean> triple = new ImmutableTriple<Integer, String, Boolean>(0, "foo", Boolean.TRUE); 
     assertEquals(0, triple.left.intValue()); 
     assertEquals(0, triple.getLeft().intValue()); 
     assertEquals("foo", triple.middle); 
     assertEquals("foo", triple.getMiddle()); 
     assertEquals(Boolean.TRUE, triple.right); 
     assertEquals(Boolean.TRUE, triple.getRight()); 
     final ImmutableTriple<Object, String, Integer> triple2 = new ImmutableTriple<Object, String, Integer>(null, "bar", 42); 
     assertNull(triple2.left); 
     assertNull(triple2.getLeft()); 
     assertEquals("bar", triple2.middle); 
     assertEquals("bar", triple2.getMiddle()); 
     assertEquals(new Integer(42), triple2.right); 
     assertEquals(new Integer(42), triple2.getRight()); 
 }
@Test
@SuppressWarnings("unchecked") 
 public void testSerialization951() throws Exception { 
     final ImmutableTriple<Integer, String, Boolean> origTriple = ImmutableTriple.of(0, "foo", Boolean.TRUE); 
     final ByteArrayOutputStream baos = new ByteArrayOutputStream(); 
     final ObjectOutputStream out = new ObjectOutputStream(baos); 
     out.writeObject(origTriple); 
     final ImmutableTriple<Integer, String, Boolean> deserializedTriple = (ImmutableTriple<Integer, String, Boolean>) new ObjectInputStream(new ByteArrayInputStream(baos.toByteArray())).readObject(); 
     assertEquals(origTriple, deserializedTriple); 
     assertEquals(origTriple.hashCode(), deserializedTriple.hashCode()); 
 }
@Test
public void testBasic1422() throws Exception { 
     final ImmutableTriple<Integer, String, Boolean> triple = new ImmutableTriple<Integer, String, Boolean>(0, "foo", Boolean.TRUE); 
     assertEquals(0, triple.left.intValue()); 
     assertEquals(0, triple.getLeft().intValue()); 
     assertEquals("foo", triple.middle); 
     assertEquals("foo", triple.getMiddle()); 
     assertEquals(Boolean.TRUE, triple.right); 
     assertEquals(Boolean.TRUE, triple.getRight()); 
     final ImmutableTriple<Object, String, Integer> triple2 = new ImmutableTriple<Object, String, Integer>(null, "bar", 42); 
     assertNull(triple2.left); 
     assertNull(triple2.getLeft()); 
     assertEquals("bar", triple2.middle); 
     assertEquals("bar", triple2.getMiddle()); 
     assertEquals(new Integer(42), triple2.right); 
     assertEquals(new Integer(42), triple2.getRight()); 
 }
@Test
public void testBasic2189() throws Exception { 
     final ImmutableTriple<Integer, String, Boolean> triple = new ImmutableTriple<Integer, String, Boolean>(0, "foo", Boolean.TRUE); 
     assertEquals(0, triple.left.intValue()); 
     assertEquals(0, triple.getLeft().intValue()); 
     assertEquals("foo", triple.middle); 
     assertEquals("foo", triple.getMiddle()); 
     assertEquals(Boolean.TRUE, triple.right); 
     assertEquals(Boolean.TRUE, triple.getRight()); 
     final ImmutableTriple<Object, String, Integer> triple2 = new ImmutableTriple<Object, String, Integer>(null, "bar", 42); 
     assertNull(triple2.left); 
     assertNull(triple2.getLeft()); 
     assertEquals("bar", triple2.middle); 
     assertEquals("bar", triple2.getMiddle()); 
     assertEquals(new Integer(42), triple2.right); 
     assertEquals(new Integer(42), triple2.getRight()); 
 }
@Test
public void testBasic2552() throws Exception { 
     final ImmutableTriple<Integer, String, Boolean> triple = new ImmutableTriple<Integer, String, Boolean>(0, "foo", Boolean.TRUE); 
     assertEquals(0, triple.left.intValue()); 
     assertEquals(0, triple.getLeft().intValue()); 
     assertEquals("foo", triple.middle); 
     assertEquals("foo", triple.getMiddle()); 
     assertEquals(Boolean.TRUE, triple.right); 
     assertEquals(Boolean.TRUE, triple.getRight()); 
     final ImmutableTriple<Object, String, Integer> triple2 = new ImmutableTriple<Object, String, Integer>(null, "bar", 42); 
     assertNull(triple2.left); 
     assertNull(triple2.getLeft()); 
     assertEquals("bar", triple2.middle); 
     assertEquals("bar", triple2.getMiddle()); 
     assertEquals(new Integer(42), triple2.right); 
     assertEquals(new Integer(42), triple2.getRight()); 
 }
@Test
public void testBasic3443() throws Exception { 
     final ImmutableTriple<Integer, String, Boolean> triple = new ImmutableTriple<Integer, String, Boolean>(0, "foo", Boolean.TRUE); 
     assertEquals(0, triple.left.intValue()); 
     assertEquals(0, triple.getLeft().intValue()); 
     assertEquals("foo", triple.middle); 
     assertEquals("foo", triple.getMiddle()); 
     assertEquals(Boolean.TRUE, triple.right); 
     assertEquals(Boolean.TRUE, triple.getRight()); 
     final ImmutableTriple<Object, String, Integer> triple2 = new ImmutableTriple<Object, String, Integer>(null, "bar", 42); 
     assertNull(triple2.left); 
     assertNull(triple2.getLeft()); 
     assertEquals("bar", triple2.middle); 
     assertEquals("bar", triple2.getMiddle()); 
     assertEquals(new Integer(42), triple2.right); 
     assertEquals(new Integer(42), triple2.getRight()); 
 }
@Test
public void testBasic3621() throws Exception { 
     final ImmutableTriple<Integer, String, Boolean> triple = new ImmutableTriple<Integer, String, Boolean>(0, "foo", Boolean.TRUE); 
     assertEquals(0, triple.left.intValue()); 
     assertEquals(0, triple.getLeft().intValue()); 
     assertEquals("foo", triple.middle); 
     assertEquals("foo", triple.getMiddle()); 
     assertEquals(Boolean.TRUE, triple.right); 
     assertEquals(Boolean.TRUE, triple.getRight()); 
     final ImmutableTriple<Object, String, Integer> triple2 = new ImmutableTriple<Object, String, Integer>(null, "bar", 42); 
     assertNull(triple2.left); 
     assertNull(triple2.getLeft()); 
     assertEquals("bar", triple2.middle); 
     assertEquals("bar", triple2.getMiddle()); 
     assertEquals(new Integer(42), triple2.right); 
     assertEquals(new Integer(42), triple2.getRight()); 
 }
@Test
public void testBasic4664() throws Exception { 
     final ImmutableTriple<Integer, String, Boolean> triple = new ImmutableTriple<Integer, String, Boolean>(0, "foo", Boolean.TRUE); 
     assertEquals(0, triple.left.intValue()); 
     assertEquals(0, triple.getLeft().intValue()); 
     assertEquals("foo", triple.middle); 
     assertEquals("foo", triple.getMiddle()); 
     assertEquals(Boolean.TRUE, triple.right); 
     assertEquals(Boolean.TRUE, triple.getRight()); 
     final ImmutableTriple<Object, String, Integer> triple2 = new ImmutableTriple<Object, String, Integer>(null, "bar", 42); 
     assertNull(triple2.left); 
     assertNull(triple2.getLeft()); 
     assertEquals("bar", triple2.middle); 
     assertEquals("bar", triple2.getMiddle()); 
     assertEquals(new Integer(42), triple2.right); 
     assertEquals(new Integer(42), triple2.getRight()); 
 }
@Test
public void testBasic5987() throws Exception { 
     final ImmutableTriple<Integer, String, Boolean> triple = new ImmutableTriple<Integer, String, Boolean>(0, "foo", Boolean.TRUE); 
     assertEquals(0, triple.left.intValue()); 
     assertEquals(0, triple.getLeft().intValue()); 
     assertEquals("foo", triple.middle); 
     assertEquals("foo", triple.getMiddle()); 
     assertEquals(Boolean.TRUE, triple.right); 
     assertEquals(Boolean.TRUE, triple.getRight()); 
     final ImmutableTriple<Object, String, Integer> triple2 = new ImmutableTriple<Object, String, Integer>(null, "bar", 42); 
     assertNull(triple2.left); 
     assertNull(triple2.getLeft()); 
     assertEquals("bar", triple2.middle); 
     assertEquals("bar", triple2.getMiddle()); 
     assertEquals(new Integer(42), triple2.right); 
     assertEquals(new Integer(42), triple2.getRight()); 
 }
@Test
@SuppressWarnings("unchecked") 
 public void testSerialization6600() throws Exception { 
     final ImmutableTriple<Integer, String, Boolean> origTriple = ImmutableTriple.of(0, "foo", Boolean.TRUE); 
     final ByteArrayOutputStream baos = new ByteArrayOutputStream(); 
     final ObjectOutputStream out = new ObjectOutputStream(baos); 
     out.writeObject(origTriple); 
     final ImmutableTriple<Integer, String, Boolean> deserializedTriple = (ImmutableTriple<Integer, String, Boolean>) new ObjectInputStream(new ByteArrayInputStream(baos.toByteArray())).readObject(); 
     assertEquals(origTriple, deserializedTriple); 
     assertEquals(origTriple.hashCode(), deserializedTriple.hashCode()); 
 }
@Test
public void testBasic7674() throws Exception { 
     final ImmutableTriple<Integer, String, Boolean> triple = new ImmutableTriple<Integer, String, Boolean>(0, "foo", Boolean.TRUE); 
     assertEquals(0, triple.left.intValue()); 
     assertEquals(0, triple.getLeft().intValue()); 
     assertEquals("foo", triple.middle); 
     assertEquals("foo", triple.getMiddle()); 
     assertEquals(Boolean.TRUE, triple.right); 
     assertEquals(Boolean.TRUE, triple.getRight()); 
     final ImmutableTriple<Object, String, Integer> triple2 = new ImmutableTriple<Object, String, Integer>(null, "bar", 42); 
     assertNull(triple2.left); 
     assertNull(triple2.getLeft()); 
     assertEquals("bar", triple2.middle); 
     assertEquals("bar", triple2.getMiddle()); 
     assertEquals(new Integer(42), triple2.right); 
     assertEquals(new Integer(42), triple2.getRight()); 
 }
@Test
public void testBasic8650() throws Exception { 
     final ImmutableTriple<Integer, String, Boolean> triple = new ImmutableTriple<Integer, String, Boolean>(0, "foo", Boolean.TRUE); 
     assertEquals(0, triple.left.intValue()); 
     assertEquals(0, triple.getLeft().intValue()); 
     assertEquals("foo", triple.middle); 
     assertEquals("foo", triple.getMiddle()); 
     assertEquals(Boolean.TRUE, triple.right); 
     assertEquals(Boolean.TRUE, triple.getRight()); 
     final ImmutableTriple<Object, String, Integer> triple2 = new ImmutableTriple<Object, String, Integer>(null, "bar", 42); 
     assertNull(triple2.left); 
     assertNull(triple2.getLeft()); 
     assertEquals("bar", triple2.middle); 
     assertEquals("bar", triple2.getMiddle()); 
     assertEquals(new Integer(42), triple2.right); 
     assertEquals(new Integer(42), triple2.getRight()); 
 }
    

    

    

    

    

    
}

