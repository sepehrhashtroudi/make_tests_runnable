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
public void testToString713() throws Exception { 
     assertEquals("(null,null,null)", MutableTriple.of(null, null, null).toString()); 
     assertEquals("(null,two,null)", MutableTriple.of(null, "two", null).toString()); 
     assertEquals("(one,null,null)", MutableTriple.of("one", null, null).toString()); 
     assertEquals("(one,two,null)", MutableTriple.of("one", "two", null).toString()); 
     assertEquals("(null,two,three)", MutableTriple.of(null, "two", "three").toString()); 
     assertEquals("(one,null,three)", MutableTriple.of("one", null, "three").toString()); 
     assertEquals("(one,two,three)", MutableTriple.of("one", "two", "three").toString()); 
 }
@Test
public void testDefault714() throws Exception { 
     final MutableTriple<Integer, String, Boolean> triple = new MutableTriple<Integer, String, Boolean>(); 
     assertNull(triple.getLeft()); 
     assertNull(triple.getMiddle()); 
     assertNull(triple.getRight()); 
 }
@Test
public void testMutate715() throws Exception { 
     final MutableTriple<Integer, String, Boolean> triple = new MutableTriple<Integer, String, Boolean>(0, "foo", Boolean.TRUE); 
     triple.setLeft(42); 
     triple.setMiddle("bar"); 
     triple.setRight(Boolean.FALSE); 
     assertEquals(42, triple.getLeft().intValue()); 
     assertEquals("bar", triple.getMiddle()); 
     assertEquals(Boolean.FALSE, triple.getRight()); 
 }
    

    
    
    

    

    

    

    

    
}

