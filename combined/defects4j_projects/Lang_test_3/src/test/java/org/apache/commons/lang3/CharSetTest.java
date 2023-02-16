/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.apache.commons.lang3;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import java.lang.reflect.Modifier;

import org.junit.Test;

/**
 * Unit tests {@link org.apache.commons.lang3.CharSet}.
 *
 * @version $Id$
 */
public class CharSetTest  {

    //-----------------------------------------------------------------------
@Test
public void testDelete_StringString390() { 
     assertEquals(null, CharSetUtils.delete(null, (String) null)); 
     assertEquals(null, CharSetUtils.delete(null, "")); 
     assertEquals("", CharSetUtils.delete("", (String) null)); 
     assertEquals("", CharSetUtils.delete("", "")); 
     assertEquals("", CharSetUtils.delete("", "a-e")); 
     assertEquals("hello", CharSetUtils.delete("hello", (String) null)); 
     assertEquals("hello", CharSetUtils.delete("hello", "")); 
     assertEquals("hllo", CharSetUtils.delete("hello", "a-e")); 
     assertEquals("he", CharSetUtils.delete("hello", "l-p")); 
     assertEquals("hello", CharSetUtils.delete("hello", "z")); 
 }
@Test
public void testSerialization391() { 
     CharSet set; 
     CharRange[] array; 
     set = CharSet.getInstance((String) null); 
     array = set.getCharRanges(); 
     assertEquals("[]", set.toString()); 
     assertEquals(0, array.length); 
     set = CharSet.getInstance(""); 
     array = set.getCharRanges(); 
     assertEquals("[]", set.toString()); 
     assertEquals(0, array.length); 
     set = CharSet.getInstance("a"); 
     array = set.getCharRanges(); 
     assertEquals("[a]", set.toString()); 
     assertEquals(1, array.length); 
     assertEquals("a", array[0].toString()); 
     set = CharSet.getInstance("^a"); 
     array = set.getCharRanges(); 
     assertEquals("[^a]", set.toString()); 
     assertEquals(1, array.length); 
     assertEquals("^a", array[0].toString()); 
     set = CharSet.getInstance("a-e"); 
     array = set.getCharRanges(); 
     assertEquals("[a-e]", set.toString()); 
     assertEquals(1, array.length); 
     assertEquals("a-e", array[0].toString()); 
     set = CharSet.getInstance("^a-e"); 
     array = set.getCharRanges(); 
     assertEquals("[^a-e]", set.toString()); 
     assertEquals(1, array.length); 
     assertEquals("^a-e", array[0].toString()); 
 }
@Test
public void testEquals_Object392() { 
     final CharSet abc = CharSet.getInstance("abc"); 
     final CharSet abc2 = CharSet.getInstance("abc"); 
     final CharSet atoc = CharSet.getInstance("a-c"); 
     final CharSet atoc2 = CharSet.getInstance("a-c"); 
     final CharSet notatoc = CharSet.getInstance("^a-c"); 
     final CharSet notatoc2 = CharSet.getInstance("^a-c"); 
     assertTrue(abc.equals(abc)); 
     assertTrue(abc.equals(abc2)); 
     assertTrue(atoc.equals(atoc)); 
     assertTrue(atoc.equals(atoc2)); 
     assertFalse(abc.equals(null)); 
     assertFalse(abc.equals(new Object())); 
     assertFalse(abc.equals("0")); 
 }
    
    
    //-----------------------------------------------------------------------
    

    //-----------------------------------------------------------------------
    
    
    //-----------------------------------------------------------------------
    
    
    
    
    

    
    
    
    
    
        
    //-----------------------------------------------------------------------    
    
            
    
    
    //-----------------------------------------------------------------------    
    
    
    //-----------------------------------------------------------------------    
    
    
    //-----------------------------------------------------------------------    
    
    
}
