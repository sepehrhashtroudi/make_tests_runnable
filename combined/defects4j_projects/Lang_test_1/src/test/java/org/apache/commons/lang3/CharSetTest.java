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
public void testDelete_StringString324() { 
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
public void testHashCode325() { 
     final CharSet abc = CharSet.getInstance("abc"); 
     final CharSet abc2 = CharSet.getInstance("abc"); 
     final CharSet atoc = CharSet.getInstance("a-c"); 
     final CharSet atoc2 = CharSet.getInstance("a-c"); 
     final CharSet notatoc = CharSet.getInstance("^a-c"); 
     final CharSet notatoc2 = CharSet.getInstance("^a-c"); 
     assertTrue(abc.hashCode() == abc.hashCode()); 
     assertTrue(abc.hashCode() == atoc.hashCode()); 
     assertTrue(atoc.hashCode() == atoc2.hashCode()); 
     assertTrue(notatoc.hashCode() == notatoc.hashCode()); 
     assertTrue(notatoc.hashCode() == notatoc.hashCode()); 
     assertTrue(notatoc.hashCode() == atoc.hashCode()); 
     assertTrue(notatoc.hashCode() == notatoc2.hashCode()); 
     assertTrue(notatoc.hashCode() == notatoc.hashCode()); 
     assertTrue(notatoc.hashCode() == notatoc.hashCode()); 
     assertTrue(notatoc.hashCode() == notatoc2.hashCode()); 
 }
@Test
public void testHashCode326() { 
     final CharSet abc = CharSet.getInstance("abc"); 
     final CharSet abc2 = CharSet.getInstance("abc"); 
     final CharSet atoc = CharSet.getInstance("a-c"); 
     final CharSet atoc2 = CharSet.getInstance("a-c"); 
     final CharSet notatoc = CharSet.getInstance("^a-c"); 
     final CharSet notatoc2 = CharSet.getInstance("^a-c"); 
     assertTrue(abc.hashCode() == abc.hashCode()); 
     assertTrue(abc.hashCode() == abc2.hashCode()); 
     assertFalse(abc.hashCode() == atoc.hashCode()); 
     assertFalse(atoc.hashCode() == atoc.hashCode()); 
     assertFalse(atoc.hashCode() == atoc.hashCode()); 
     assertFalse(atoc.hashCode() == notatoc2.hashCode()); 
     assertFalse(notatoc.hashCode() == notatoc.hashCode()); 
     assertTrue(notatoc.hashCode() == notatoc.hashCode()); 
     assertTrue(notatoc.hashCode() == notatoc2.hashCode()); 
 }
    
    
    //-----------------------------------------------------------------------
    

    //-----------------------------------------------------------------------
    
    
    //-----------------------------------------------------------------------
    
    
    
    
    

    
    
    
    
    
        
    //-----------------------------------------------------------------------    
    
            
    
    
    //-----------------------------------------------------------------------    
    
    
    //-----------------------------------------------------------------------    
    
    
    //-----------------------------------------------------------------------    
    
    
}
