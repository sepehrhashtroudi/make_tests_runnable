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
public void testConstructor_String_oddNegate1213() { 
     CharSet set; 
     CharRange[] array; 
     set = CharSet.getInstance("^"); 
     array = set.getCharRanges(); 
     assertEquals(1, array.length); 
     assertTrue(ArrayUtils.contains(array, CharRange.is('^'))); 
     set = CharSet.getInstance("^^"); 
     array = set.getCharRanges(); 
     assertEquals(1, array.length); 
     assertTrue(ArrayUtils.contains(array, CharRange.isNot('^'))); 
     set = CharSet.getInstance("^^^"); 
     array = set.getCharRanges(); 
     assertEquals(2, array.length); 
     assertTrue(ArrayUtils.contains(array, CharRange.isNot('^'))); 
     assertTrue(ArrayUtils.contains(array, CharRange.is('^'))); 
     set = CharSet.getInstance("^^^^"); 
     array = set.getCharRanges(); 
     assertEquals(1, array.length); 
     assertTrue(ArrayUtils.contains(array, CharRange.isNot('^'))); 
     set = CharSet.getInstance("a^"); 
     array = set.getCharRanges(); 
     assertEquals(2, array.length); 
     assertTrue(ArrayUtils.contains(array, CharRange.is('a'))); 
     assertTrue(ArrayUtils.contains(array, CharRange.is('^'))); 
     set = CharSet.getInstance("^a-"); 
     array = set.getCharRanges(); 
     assertEquals(2, array.length); 
     assertTrue(ArrayUtils.contains(array, CharRange.isNot('a'))); 
     assertTrue(ArrayUtils.contains(array, CharRange.is('-'))); 
     set = CharSet.getInstance("^^-c"); 
     array = set.getCharRanges(); 
     assertEquals(1, array.length); 
     assertTrue(ArrayUtils.contains(array, CharRange.isNotIn('^', 'c'))); 
     set = CharSet.getInstance("^c-^"); 
     array = set.getCharRanges(); 
     assertEquals(1, array.length); 
     assertTrue(ArrayUtils.contains(array, CharRange.isNotIn('c', '^'))); 
     set = CharSet.getInstance("^c-^d"); 
     array = set.getCharRanges(); 
     assertEquals(2, array.length); 
     assertTrue(ArrayUtils.contains(array, CharRange.isNotIn('c', '^'))); 
     assertTrue(ArrayUtils.contains(array, CharRange.is('d'))); 
     set = CharSet.getInstance("^^-"); 
     array = set.getCharRanges(); 
     assertEquals(2, array.length); 
     assertTrue(ArrayUtils.contains(array, CharRange.isNot('^'))); 
     assertTrue(ArrayUtils.contains(array, CharRange.is('-'))); 
 }
@Test
public void testContains_Char1565() { 
     final CharSet btod = CharSet.getInstance("b-d"); 
     final CharSet dtob = CharSet.getInstance("d-b"); 
     final CharSet bcd = CharSet.getInstance("bcd"); 
     final CharSet bd = CharSet.getInstance("bd"); 
     final CharSet notbtod = CharSet.getInstance("^b-d"); 
     assertFalse(btod.contains('a')); 
     assertTrue(btod.contains('b')); 
     assertTrue(btod.contains('c')); 
     assertTrue(btod.contains('d')); 
     assertFalse(btod.contains('e')); 
     assertFalse(bcd.contains('a')); 
     assertTrue(bcd.contains('b')); 
     assertTrue(bcd.contains('c')); 
     assertTrue(bcd.contains('d')); 
     assertFalse(bcd.contains('e')); 
     assertFalse(bd.contains('a')); 
     assertTrue(bd.contains('b')); 
     assertFalse(bd.contains('c')); 
     assertTrue(bd.contains('d')); 
     assertFalse(bd.contains('e')); 
     assertTrue(notbtod.contains('a')); 
     assertFalse(notbtod.contains('b')); 
     assertFalse(notbtod.contains('c')); 
     assertFalse(notbtod.contains('d')); 
     assertTrue(notbtod.contains('e')); 
     assertFalse(dtob.contains('a')); 
     assertTrue(dtob.contains('b')); 
     assertTrue(dtob.contains('c')); 
     assertTrue(dtob.contains('d')); 
     assertFalse(dtob.contains('e')); 
     final CharRange[] array = dtob.getCharRanges(); 
     assertEquals("[b-d]", dtob.toString()); 
     assertEquals(1, array.length); 
 }
@Test
public void testSerialization1883() { 
     CharSet set = CharSet.getInstance("a"); 
     assertEquals(set, SerializationUtils.clone(set)); 
     set = CharSet.getInstance("a-e"); 
     assertEquals(set, SerializationUtils.clone(set)); 
     set = CharSet.getInstance("be-f^a-z"); 
     assertEquals(set, SerializationUtils.clone(set)); 
 }
@Test
public void testContains_Char1906() { 
     final CharSet btod = CharSet.getInstance("b-d"); 
     final CharSet dtob = CharSet.getInstance("d-b"); 
     final CharSet bcd = CharSet.getInstance("bcd"); 
     final CharSet bd = CharSet.getInstance("bd"); 
     final CharSet notbtod = CharSet.getInstance("^b-d"); 
     assertFalse(btod.contains('a')); 
     assertTrue(btod.contains('b')); 
     assertTrue(btod.contains('c')); 
     assertTrue(btod.contains('d')); 
     assertFalse(btod.contains('e')); 
     assertFalse(bcd.contains('a')); 
     assertTrue(bcd.contains('b')); 
     assertTrue(bcd.contains('c')); 
     assertTrue(bcd.contains('d')); 
     assertFalse(bcd.contains('e')); 
     assertFalse(bd.contains('a')); 
     assertTrue(bd.contains('b')); 
     assertFalse(bd.contains('c')); 
     assertTrue(bd.contains('d')); 
     assertFalse(bd.contains('e')); 
     assertTrue(notbtod.contains('a')); 
     assertFalse(notbtod.contains('b')); 
     assertFalse(notbtod.contains('c')); 
     assertFalse(notbtod.contains('d')); 
     assertTrue(notbtod.contains('e')); 
     assertFalse(dtob.contains('a')); 
     assertTrue(dtob.contains('b')); 
     assertTrue(dtob.contains('c')); 
     assertTrue(dtob.contains('d')); 
     assertFalse(dtob.contains('e')); 
     final CharRange[] array = dtob.getCharRanges(); 
     assertEquals("[b-d]", dtob.toString()); 
     assertEquals(1, array.length); 
 }
@Test
public void testContains_Char2119() { 
     final CharSet btod = CharSet.getInstance("b-d"); 
     final CharSet dtob = CharSet.getInstance("d-b"); 
     final CharSet bcd = CharSet.getInstance("bcd"); 
     final CharSet bd = CharSet.getInstance("bd"); 
     final CharSet notbtod = CharSet.getInstance("^b-d"); 
     assertFalse(btod.contains('a')); 
     assertTrue(btod.contains('b')); 
     assertTrue(btod.contains('c')); 
     assertTrue(btod.contains('d')); 
     assertFalse(btod.contains('e')); 
     assertFalse(bcd.contains('a')); 
     assertTrue(bcd.contains('b')); 
     assertTrue(bcd.contains('c')); 
     assertTrue(bcd.contains('d')); 
     assertFalse(bcd.contains('e')); 
     assertFalse(bd.contains('a')); 
     assertTrue(bd.contains('b')); 
     assertFalse(bd.contains('c')); 
     assertTrue(bd.contains('d')); 
     assertFalse(bd.contains('e')); 
     assertTrue(notbtod.contains('a')); 
     assertFalse(notbtod.contains('b')); 
     assertFalse(notbtod.contains('c')); 
     assertFalse(notbtod.contains('d')); 
     assertTrue(notbtod.contains('e')); 
     assertFalse(dtob.contains('a')); 
     assertTrue(dtob.contains('b')); 
     assertTrue(dtob.contains('c')); 
     assertTrue(dtob.contains('d')); 
     assertFalse(dtob.contains('e')); 
     final CharRange[] array = dtob.getCharRanges(); 
     assertEquals("[b-d]", dtob.toString()); 
     assertEquals(1, array.length); 
 }
@Test
public void testConstructor_String_oddDash2279() { 
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
public void testSerialization2627() { 
     CharSet set = CharSet.getInstance("a"); 
     assertEquals(set, SerializationUtils.clone(set)); 
     set = CharSet.getInstance("a-e"); 
     assertEquals(set, SerializationUtils.clone(set)); 
     set = CharSet.getInstance("be-f^a-z"); 
     assertEquals(set, SerializationUtils.clone(set)); 
 }
@Test
public void testGetInstance_Stringarray3525() { 
     assertEquals(null, CharSet.getInstance((String[]) null)); 
     assertEquals("[]", CharSet.getInstance(new String[0]).toString()); 
     assertEquals("[]", CharSet.getInstance(new String[] { null }).toString()); 
     assertEquals("[a-e]", CharSet.getInstance(new String[] { "a-e" }).toString()); 
 }
@Test
public void testConstructor_String_oddNegate3743() { 
     CharSet set; 
     CharRange[] array; 
     set = CharSet.getInstance("^"); 
     array = set.getCharRanges(); 
     assertEquals(1, array.length); 
     assertTrue(ArrayUtils.contains(array, CharRange.is('^'))); 
     set = CharSet.getInstance("^^"); 
     array = set.getCharRanges(); 
     assertEquals(1, array.length); 
     assertTrue(ArrayUtils.contains(array, CharRange.isNot('^'))); 
     set = CharSet.getInstance("^^^"); 
     array = set.getCharRanges(); 
     assertEquals(2, array.length); 
     assertTrue(ArrayUtils.contains(array, CharRange.isNot('^'))); 
     assertTrue(ArrayUtils.contains(array, CharRange.is('^'))); 
     set = CharSet.getInstance("^^^^"); 
     array = set.getCharRanges(); 
     assertEquals(1, array.length); 
     assertTrue(ArrayUtils.contains(array, CharRange.isNot('^'))); 
     set = CharSet.getInstance("a^"); 
     array = set.getCharRanges(); 
     assertEquals(2, array.length); 
     assertTrue(ArrayUtils.contains(array, CharRange.is('a'))); 
     assertTrue(ArrayUtils.contains(array, CharRange.is('^'))); 
     set = CharSet.getInstance("^a-"); 
     array = set.getCharRanges(); 
     assertEquals(2, array.length); 
     assertTrue(ArrayUtils.contains(array, CharRange.isNot('a'))); 
     assertTrue(ArrayUtils.contains(array, CharRange.is('-'))); 
     set = CharSet.getInstance("^^-c"); 
     array = set.getCharRanges(); 
     assertEquals(1, array.length); 
     assertTrue(ArrayUtils.contains(array, CharRange.isNotIn('^', 'c'))); 
     set = CharSet.getInstance("^c-^"); 
     array = set.getCharRanges(); 
     assertEquals(1, array.length); 
     assertTrue(ArrayUtils.contains(array, CharRange.isNotIn('c', '^'))); 
     set = CharSet.getInstance("^c-^d"); 
     array = set.getCharRanges(); 
     assertEquals(2, array.length); 
     assertTrue(ArrayUtils.contains(array, CharRange.isNotIn('c', '^'))); 
     assertTrue(ArrayUtils.contains(array, CharRange.is('d'))); 
     set = CharSet.getInstance("^^-"); 
     array = set.getCharRanges(); 
     assertEquals(2, array.length); 
     assertTrue(ArrayUtils.contains(array, CharRange.isNot('^'))); 
     assertTrue(ArrayUtils.contains(array, CharRange.is('-'))); 
 }
@Test
public void testSerialization5331() { 
     CharSet set = CharSet.getInstance("a"); 
     assertEquals(set, SerializationUtils.clone(set)); 
     set = CharSet.getInstance("a-e"); 
     assertEquals(set, SerializationUtils.clone(set)); 
     set = CharSet.getInstance("be-f^a-z"); 
     assertEquals(set, SerializationUtils.clone(set)); 
 }
@Test
public void testHashCode6384() { 
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
@Test
public void testEquals_Object6715() { 
     final CharSet abc = CharSet.getInstance("abc"); 
     final CharSet abc2 = CharSet.getInstance("abc"); 
     final CharSet atoc = CharSet.getInstance("a-c"); 
     final CharSet atoc2 = CharSet.getInstance("a-c"); 
     final CharSet notatoc = CharSet.getInstance("^a-c"); 
     final CharSet notatoc2 = CharSet.getInstance("^a-c"); 
     assertFalse(abc.equals(null)); 
     assertTrue(abc.equals(abc)); 
     assertTrue(abc.equals(abc2)); 
     assertFalse(abc.equals(atoc)); 
     assertFalse(abc.equals(notatoc)); 
     assertFalse(atoc.equals(abc)); 
     assertTrue(atoc.equals(atoc)); 
     assertTrue(atoc.equals(atoc2)); 
     assertFalse(atoc.equals(notatoc)); 
     assertFalse(notatoc.equals(abc)); 
     assertFalse(notatoc.equals(atoc)); 
     assertTrue(notatoc.equals(notatoc)); 
     assertTrue(notatoc.equals(notatoc2)); 
 }
@Test
public void testSerialization6891() { 
     CharSet set = CharSet.getInstance("a"); 
     assertEquals(set, SerializationUtils.clone(set)); 
     set = CharSet.getInstance("a-e"); 
     assertEquals(set, SerializationUtils.clone(set)); 
     set = CharSet.getInstance("be-f^a-z"); 
     assertEquals(set, SerializationUtils.clone(set)); 
 }
@Test
public void testEquals_Object6928() { 
     final CharSet abc = CharSet.getInstance("abc"); 
     final CharSet abc2 = CharSet.getInstance("abc"); 
     final CharSet atoc = CharSet.getInstance("a-c"); 
     final CharSet atoc2 = CharSet.getInstance("a-c"); 
     final CharSet notatoc = CharSet.getInstance("^a-c"); 
     final CharSet notatoc2 = CharSet.getInstance("^a-c"); 
     assertFalse(abc.equals(null)); 
     assertTrue(abc.equals(abc)); 
     assertTrue(abc.equals(abc2)); 
     assertFalse(abc.equals(atoc)); 
     assertFalse(abc.equals(notatoc)); 
     assertFalse(atoc.equals(abc)); 
     assertTrue(atoc.equals(atoc)); 
     assertTrue(atoc.equals(atoc2)); 
     assertFalse(atoc.equals(notatoc)); 
     assertFalse(notatoc.equals(abc)); 
     assertFalse(notatoc.equals(atoc)); 
     assertTrue(notatoc.equals(notatoc)); 
     assertTrue(notatoc.equals(notatoc2)); 
 }
@Test
public void testSerialization8199() { 
     CharSet set = CharSet.getInstance("a"); 
     assertEquals(set, SerializationUtils.clone(set)); 
     set = CharSet.getInstance("a-e"); 
     assertEquals(set, SerializationUtils.clone(set)); 
     set = CharSet.getInstance("be-f^a-z"); 
     assertEquals(set, SerializationUtils.clone(set)); 
 }
@Test
public void testHashCode9014() { 
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
@Test
public void testContains_Char9147() { 
     final CharSet btod = CharSet.getInstance("b-d"); 
     final CharSet dtob = CharSet.getInstance("d-b"); 
     final CharSet bcd = CharSet.getInstance("bcd"); 
     final CharSet bd = CharSet.getInstance("bd"); 
     final CharSet notbtod = CharSet.getInstance("^b-d"); 
     assertFalse(btod.contains('a')); 
     assertTrue(btod.contains('b')); 
     assertTrue(btod.contains('c')); 
     assertTrue(btod.contains('d')); 
     assertFalse(btod.contains('e')); 
     assertFalse(bcd.contains('a')); 
     assertTrue(bcd.contains('b')); 
     assertTrue(bcd.contains('c')); 
     assertTrue(bcd.contains('d')); 
     assertFalse(bcd.contains('e')); 
     assertFalse(bd.contains('a')); 
     assertTrue(bd.contains('b')); 
     assertFalse(bd.contains('c')); 
     assertTrue(bd.contains('d')); 
     assertFalse(bd.contains('e')); 
     assertTrue(notbtod.contains('a')); 
     assertFalse(notbtod.contains('b')); 
     assertFalse(notbtod.contains('c')); 
     assertFalse(notbtod.contains('d')); 
     assertTrue(notbtod.contains('e')); 
     assertFalse(dtob.contains('a')); 
     assertTrue(dtob.contains('b')); 
     assertTrue(dtob.contains('c')); 
     assertTrue(dtob.contains('d')); 
     assertFalse(dtob.contains('e')); 
     final CharRange[] array = dtob.getCharRanges(); 
     assertEquals("[b-d]", dtob.toString()); 
     assertEquals(1, array.length); 
 }
@Test
public void testContains_Char9466() { 
     final CharSet btod = CharSet.getInstance("b-d"); 
     final CharSet dtob = CharSet.getInstance("d-b"); 
     final CharSet bcd = CharSet.getInstance("bcd"); 
     final CharSet bd = CharSet.getInstance("bd"); 
     final CharSet notbtod = CharSet.getInstance("^b-d"); 
     assertFalse(btod.contains('a')); 
     assertTrue(btod.contains('b')); 
     assertTrue(btod.contains('c')); 
     assertTrue(btod.contains('d')); 
     assertFalse(btod.contains('e')); 
     assertFalse(bcd.contains('a')); 
     assertTrue(bcd.contains('b')); 
     assertTrue(bcd.contains('c')); 
     assertTrue(bcd.contains('d')); 
     assertFalse(bcd.contains('e')); 
     assertFalse(bd.contains('a')); 
     assertTrue(bd.contains('b')); 
     assertFalse(bd.contains('c')); 
     assertTrue(bd.contains('d')); 
     assertFalse(bd.contains('e')); 
     assertTrue(notbtod.contains('a')); 
     assertFalse(notbtod.contains('b')); 
     assertFalse(notbtod.contains('c')); 
     assertFalse(notbtod.contains('d')); 
     assertTrue(notbtod.contains('e')); 
     assertFalse(dtob.contains('a')); 
     assertTrue(dtob.contains('b')); 
     assertTrue(dtob.contains('c')); 
     assertTrue(dtob.contains('d')); 
     assertFalse(dtob.contains('e')); 
     final CharRange[] array = dtob.getCharRanges(); 
     assertEquals("[b-d]", dtob.toString()); 
     assertEquals(1, array.length); 
 }
    
    
    //-----------------------------------------------------------------------
    

    //-----------------------------------------------------------------------
    
    
    //-----------------------------------------------------------------------
    
    
    
    
    

    
    
    
    
    
        
    //-----------------------------------------------------------------------    
    
            
    
    
    //-----------------------------------------------------------------------    
    
    
    //-----------------------------------------------------------------------    
    
    
    //-----------------------------------------------------------------------    
    
    
}
