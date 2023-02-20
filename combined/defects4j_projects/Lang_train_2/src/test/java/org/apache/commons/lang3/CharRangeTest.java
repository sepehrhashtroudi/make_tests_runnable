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
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.lang.reflect.Modifier;
import java.util.Iterator;
import java.util.NoSuchElementException;

import org.junit.Test;

/**
 * Unit tests {@link org.apache.commons.lang3.CharRange}.
 *
 * @version $Id$
 */
public class CharRangeTest  {

    //-----------------------------------------------------------------------
@Test
public void testContains_Char758() { 
     CharRange range = CharRange.is('c'); 
     assertFalse(range.contains('b')); 
     assertTrue(range.contains('c')); 
     assertFalse(range.contains('d')); 
     assertFalse(range.contains('e')); 
     range = CharRange.isIn('c', 'd'); 
     assertFalse(range.contains('b')); 
     assertTrue(range.contains('c')); 
     assertTrue(range.contains('d')); 
     assertFalse(range.contains('e')); 
     range = CharRange.isIn('d', 'c'); 
     assertFalse(range.contains('b')); 
     assertTrue(range.contains('c')); 
     assertTrue(range.contains('d')); 
     assertFalse(range.contains('e')); 
     range = CharRange.isNotIn('c', 'd'); 
     assertTrue(range.contains('b')); 
     assertFalse(range.contains('c')); 
     assertFalse(range.contains('d')); 
     assertTrue(range.contains('e')); 
     assertTrue(range.contains((char) 0)); 
     assertTrue(range.contains(Character.MAX_VALUE)); 
 }
@Test
public void testSerialization759() { 
     CharRange range = CharRange.is('a'); 
     assertEquals(range, SerializationUtils.clone(range)); 
     range = CharRange.isIn('a', 'e'); 
     assertEquals(range, SerializationUtils.clone(range)); 
     range = CharRange.isNotIn('a', 'e'); 
     assertEquals(range, SerializationUtils.clone(range)); 
 }
@Test
public void testEquals_Object760() { 
     final CharRange rangea = CharRange.is('a'); 
     final CharRange rangeae = CharRange.isIn('a', 'e'); 
     final CharRange rangenotbf = CharRange.isIn('b', 'f'); 
     assertFalse(rangea.equals(null)); 
     assertTrue(rangea.equals(rangea)); 
     assertTrue(rangea.equals(CharRange.is('a'))); 
     assertTrue(rangeae.equals(rangeae)); 
     assertTrue(rangeae.equals(CharRange.isIn('a', 'e'))); 
     assertTrue(rangenotbf.equals(rangenotbf)); 
     assertTrue(rangenotbf.equals(CharRange.isIn('b', 'f'))); 
     assertFalse(rangea.equals(rangeae)); 
     assertFalse(rangea.equals(rangenotbf)); 
     assertFalse(rangeae.equals(rangea)); 
     assertFalse(rangeae.equals(rangenotbf)); 
     assertFalse(rangenotbf.equals(rangea)); 
     assertFalse(rangenotbf.equals(rangeae)); 
 }
@Test
public void testHashCode761() { 
     final CharRange rangea = CharRange.is('a'); 
     final CharRange rangeae = CharRange.isIn('a', 'e'); 
     final CharRange rangenotbf = CharRange.isIn('b', 'f'); 
     assertTrue(rangea.hashCode() == rangea.hashCode()); 
     assertTrue(rangea.hashCode() == CharRange.is('a').hashCode()); 
     assertTrue(rangeae.hashCode() == rangeae.hashCode()); 
     assertTrue(rangeae.hashCode() == CharRange.isIn('a', 'e').hashCode()); 
     assertTrue(rangenotbf.hashCode() == rangenotbf.hashCode()); 
     assertTrue(rangenotbf.hashCode() == CharRange.isIn('b', 'f').hashCode()); 
     assertFalse(rangea.hashCode() == rangeae.hashCode()); 
     assertFalse(rangea.hashCode() == rangenotbf.hashCode()); 
     assertFalse(rangeae.hashCode() == rangea.hashCode()); 
     assertFalse(rangeae.hashCode() == rangenotbf.hashCode()); 
     assertFalse(rangenotbf.hashCode() == rangea.hashCode()); 
     assertFalse(rangenotbf.hashCode() == rangeae.hashCode()); 
 }
@Test
public void testConstructorAccessors_isNotIn_Normal762() { 
     final CharRange rangea = CharRange.isNotIn('a', 'e'); 
     assertEquals('a', rangea.getStart()); 
     assertEquals('e', rangea.getEnd()); 
     assertTrue(rangea.isNegated()); 
     assertEquals("^a-e", rangea.toString()); 
 }
    

    //-----------------------------------------------------------------------
    

    

    

    

    

    

    

    

    //-----------------------------------------------------------------------
    

    

    //-----------------------------------------------------------------------
    

    //-----------------------------------------------------------------------
    

    

    

    //-----------------------------------------------------------------------
    

}
