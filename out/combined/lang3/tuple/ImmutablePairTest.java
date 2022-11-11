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
public void testToString17() throws Exception { 
     assertEquals("(null,null)", ImmutablePair.of(null, null).toString()); 
     assertEquals("(null,two)", ImmutablePair.of(null, "two").toString()); 
     assertEquals("(one,null)", ImmutablePair.of("one", null).toString()); 
     assertEquals("(one,two)", ImmutablePair.of("one", "two").toString()); 
 }
@Test
public void testHashCode596() throws Exception { 
     assertEquals(ImmutablePair.of(null, "foo").hashCode(), ImmutablePair.of(null, "foo").hashCode()); 
 }
@Test
public void testToString984() throws Exception { 
     assertEquals("(null,null)", ImmutablePair.of(null, null).toString()); 
     assertEquals("(null,two)", ImmutablePair.of(null, "two").toString()); 
     assertEquals("(one,null)", ImmutablePair.of("one", null).toString()); 
     assertEquals("(one,two)", ImmutablePair.of("one", "two").toString()); 
 }
@Test
public void testToString1879() throws Exception { 
     assertEquals("(null,null)", ImmutablePair.of(null, null).toString()); 
     assertEquals("(null,two)", ImmutablePair.of(null, "two").toString()); 
     assertEquals("(one,null)", ImmutablePair.of("one", null).toString()); 
     assertEquals("(one,two)", ImmutablePair.of("one", "two").toString()); 
 }
@Test
public void testToString2108() throws Exception { 
     assertEquals("(null,null)", ImmutablePair.of(null, null).toString()); 
     assertEquals("(null,two)", ImmutablePair.of(null, "two").toString()); 
     assertEquals("(one,null)", ImmutablePair.of("one", null).toString()); 
     assertEquals("(one,two)", ImmutablePair.of("one", "two").toString()); 
 }
@Test
public void testToString2704() throws Exception { 
     assertEquals("(null,null)", ImmutablePair.of(null, null).toString()); 
     assertEquals("(null,two)", ImmutablePair.of(null, "two").toString()); 
     assertEquals("(one,null)", ImmutablePair.of("one", null).toString()); 
     assertEquals("(one,two)", ImmutablePair.of("one", "two").toString()); 
 }
@Test
public void testToString2893() throws Exception { 
     assertEquals("(null,null)", ImmutablePair.of(null, null).toString()); 
     assertEquals("(null,two)", ImmutablePair.of(null, "two").toString()); 
     assertEquals("(one,null)", ImmutablePair.of("one", null).toString()); 
     assertEquals("(one,two)", ImmutablePair.of("one", "two").toString()); 
 }
@Test
public void testHashCode3060() throws Exception { 
     assertEquals(ImmutablePair.of(null, "foo").hashCode(), ImmutablePair.of(null, "foo").hashCode()); 
 }
@Test
public void testToString3519() throws Exception { 
     assertEquals("(null,null)", ImmutablePair.of(null, null).toString()); 
     assertEquals("(null,two)", ImmutablePair.of(null, "two").toString()); 
     assertEquals("(one,null)", ImmutablePair.of("one", null).toString()); 
     assertEquals("(one,two)", ImmutablePair.of("one", "two").toString()); 
 }
@Test
public void testToString3543() throws Exception { 
     assertEquals("(null,null)", ImmutablePair.of(null, null).toString()); 
     assertEquals("(null,two)", ImmutablePair.of(null, "two").toString()); 
     assertEquals("(one,null)", ImmutablePair.of("one", null).toString()); 
     assertEquals("(one,two)", ImmutablePair.of("one", "two").toString()); 
 }
@Test
public void testToString3992() throws Exception { 
     assertEquals("(null,null)", ImmutablePair.of(null, null).toString()); 
     assertEquals("(null,two)", ImmutablePair.of(null, "two").toString()); 
     assertEquals("(one,null)", ImmutablePair.of("one", null).toString()); 
     assertEquals("(one,two)", ImmutablePair.of("one", "two").toString()); 
 }
@Test
public void testHashCode4153() throws Exception { 
     assertEquals(ImmutablePair.of(null, "foo").hashCode(), ImmutablePair.of(null, "foo").hashCode()); 
 }
@Test
public void testHashCode5420() throws Exception { 
     assertEquals(ImmutablePair.of(null, "foo").hashCode(), ImmutablePair.of(null, "foo").hashCode()); 
 }
@Test
public void testToString5826() throws Exception { 
     assertEquals("(null,null)", ImmutablePair.of(null, null).toString()); 
     assertEquals("(null,two)", ImmutablePair.of(null, "two").toString()); 
     assertEquals("(one,null)", ImmutablePair.of("one", null).toString()); 
     assertEquals("(one,two)", ImmutablePair.of("one", "two").toString()); 
 }
@Test
public void testHashCode6911() throws Exception { 
     assertEquals(ImmutablePair.of(null, "foo").hashCode(), ImmutablePair.of(null, "foo").hashCode()); 
 }
@Test
public void testToString8728() throws Exception { 
     assertEquals("(null,null)", ImmutablePair.of(null, null).toString()); 
     assertEquals("(null,two)", ImmutablePair.of(null, "two").toString()); 
     assertEquals("(one,null)", ImmutablePair.of("one", null).toString()); 
     assertEquals("(one,two)", ImmutablePair.of("one", "two").toString()); 
 }
@Test
public void testToString8779() throws Exception { 
     assertEquals("(null,null)", ImmutablePair.of(null, null).toString()); 
     assertEquals("(null,two)", ImmutablePair.of(null, "two").toString()); 
     assertEquals("(one,null)", ImmutablePair.of("one", null).toString()); 
     assertEquals("(one,two)", ImmutablePair.of("one", "two").toString()); 
 }
@Test
public void testHashCode8796() throws Exception { 
     assertEquals(ImmutablePair.of(null, "foo").hashCode(), ImmutablePair.of(null, "foo").hashCode()); 
 }
    

    

    

    

    

    
}
