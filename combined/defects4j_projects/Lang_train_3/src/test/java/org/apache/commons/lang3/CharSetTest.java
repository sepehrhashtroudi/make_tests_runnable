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
public void testGetInstance_Stringarray734() { 
     assertEquals(null, CharSet.getInstance((String[]) null)); 
     assertEquals("[]", CharSet.getInstance(new String[0]).toString()); 
     assertEquals("[]", CharSet.getInstance(new String[] { null }).toString()); 
     assertEquals("[a-e]", CharSet.getInstance(new String[] { "a-e" }).toString()); 
 }
@Test
public void testConstructor_String_simple735() { 
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
public void testConstructor_String_oddDash736() { 
     CharSet set; 
     CharRange[] array; 
     set = CharSet.getInstance("-"); 
     array = set.getCharRanges(); 
     assertEquals(1, array.length); 
     assertTrue(ArrayUtils.contains(array, CharRange.is('-'))); 
     set = CharSet.getInstance("--"); 
     array = set.getCharRanges(); 
     assertEquals(1, array.length); 
     assertTrue(ArrayUtils.contains(array, CharRange.is('-'))); 
     set = CharSet.getInstance("---"); 
     array = set.getCharRanges(); 
     assertEquals(1, array.length); 
     assertTrue(ArrayUtils.contains(array, CharRange.is('-'))); 
     set = CharSet.getInstance("----"); 
     array = set.getCharRanges(); 
     assertEquals(1, array.length); 
     assertTrue(ArrayUtils.contains(array, CharRange.is('-'))); 
     set = CharSet.getInstance("-a"); 
     array = set.getCharRanges(); 
     assertEquals(2, array.length); 
     assertTrue(ArrayUtils.contains(array, CharRange.is('-'))); 
     assertTrue(ArrayUtils.contains(array, CharRange.is('a'))); 
     set = CharSet.getInstance("a-"); 
     array = set.getCharRanges(); 
     assertEquals(2, array.length); 
     assertTrue(ArrayUtils.contains(array, CharRange.is('a'))); 
     assertTrue(ArrayUtils.contains(array, CharRange.is('-'))); 
     set = CharSet.getInstance("a--"); 
     array = set.getCharRanges(); 
     assertEquals(1, array.length); 
     assertTrue(ArrayUtils.contains(array, CharRange.isIn('a', '-'))); 
     set = CharSet.getInstance("--a"); 
     array = set.getCharRanges(); 
     assertEquals(1, array.length); 
     assertTrue(ArrayUtils.contains(array, CharRange.isIn('-', 'a'))); 
 }
@Test
public void testHashCode737() { 
     final CharSet abc = CharSet.getInstance("abc"); 
     final CharSet abc2 = CharSet.getInstance("abc"); 
     final CharSet atoc = CharSet.getInstance("a-c"); 
     final CharSet atoc2 = CharSet.getInstance("a-c"); 
     final CharSet notatoc = CharSet.getInstance("^a-c"); 
     final CharSet notatoc2 = CharSet.getInstance("^a-c"); 
     assertEquals(abc.hashCode(), abc.hashCode()); 
     assertEquals(abc.hashCode(), abc2.hashCode()); 
     assertEquals(atoc.hashCode(), atoc.hashCode()); 
     assertEquals(atoc.hashCode(), atoc2.hashCode()); 
     assertEquals(notatoc.hashCode(), notatoc.hashCode()); 
     assertEquals(notatoc.hashCode(), notatoc2.hashCode()); 
 }
    
    
    //-----------------------------------------------------------------------
    

    //-----------------------------------------------------------------------
    
    
    //-----------------------------------------------------------------------
    
    
    
    
    

    
    
    
    
    
        
    //-----------------------------------------------------------------------    
    
            
    
    
    //-----------------------------------------------------------------------    
    
    
    //-----------------------------------------------------------------------    
    
    
    //-----------------------------------------------------------------------    
    
    
}
