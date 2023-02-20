/*
 * Copyright 2008 The Closure Compiler Authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.javascript.jscomp.graph;

import com.google.common.collect.HashMultiset;
import com.google.common.collect.ImmutableSet;

import junit.framework.Assert;
import junit.framework.TestCase;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

/**
 * Unit test for the {@link StandardUnionFind} data structure.
 *
 */
public class StandardUnionFindTest extends TestCase {
  private StandardUnionFind<String> union;

  @Override protected void setUp() {
    union = new StandardUnionFind<String>();
  }

public void testFind541() { 
     union.add("A"); 
     union.add("B"); 
     assertEquals("A", union.find("A")); 
     assertEquals("B", union.find("B")); 
     union.union("A", "B"); 
     assertEquals(union.find("A"), union.find("B")); 
     try { 
         union.find("Z"); 
         fail("find() on unknown element should not be allowed."); 
     } catch (IllegalArgumentException e) { 
     } 
 }
public void testFindAllSize542() { 
     union.union("A", "B"); 
     union.union("B", "C"); 
     assertEquals(3, union.findAll("A").size()); 
     assertEquals(3, union.findAll("B").size()); 
     assertEquals(3, union.findAll("C").size()); 
     union.union("D", "E"); 
     assertEquals(3, union.findAll("C").size()); 
     assertEquals(2, union.findAll("D").size()); 
     union.union("B", "E"); 
     assertEquals(5, union.findAll("C").size()); 
     assertEquals(5, union.findAll("D").size()); 
 }
public void testAllEquivalenceClasses543() { 
     union.union("A", "B"); 
     union.union("A", "B"); 
     union.union("B", "A"); 
     union.union("B", "C"); 
     union.union("D", "E"); 
     union.union("F", "F"); 
     Collection<Set<String>> classes = union.allEquivalenceClasses(); 
     assertEquals(3, classes.size()); 
     assertContentsAnyOrder(classes, ImmutableSet.of("A", "B", "C"), ImmutableSet.of("D", "E"), ImmutableSet.of("F")); 
 }
public void testFindAll544() { 
     union.union("A", "B"); 
     union.union("A", "B"); 
     union.union("B", "A"); 
     union.union("D", "E"); 
     union.union("F", "F"); 
     Set<String> aSet = union.findAll("A"); 
     assertEquals(2, aSet.size()); 
     assertTrue(aSet.contains("A")); 
     assertTrue(aSet.contains("B")); 
     assertFalse(aSet.contains("C")); 
     assertFalse(aSet.contains("D")); 
     assertFalse(aSet.contains("E")); 
     assertFalse(aSet.contains("F")); 
     union.union("B", "C"); 
     assertTrue(aSet.contains("C")); 
     assertEquals(3, aSet.size()); 
     try { 
         union.findAll("Z"); 
         fail("findAll() on unknown element should not be allowed."); 
     } catch (IllegalArgumentException e) { 
     } 
 }
  

  

  

  

  

  

  

  

  

  

  

  

  

  /**
   * Asserts that {@code actual} contains precisely the elements
   * {@code expected}, in any order.  Both collections may contain
   * duplicates, and this method will only pass if the quantities are
   * exactly the same.
   */
  private static void assertContentsAnyOrder(
      String message, Iterable<?> actual, Object... expected) {
    Assert.assertEquals(message,
        HashMultiset.create(Arrays.asList(expected)),
        HashMultiset.create(actual));
  }

  /**
   * Variant of {@link #assertContentsAnyOrder(String,Iterable,Object...)}
   * using a generic message.
   */
  private static void assertContentsAnyOrder(
      Iterable<?> actual, Object... expected) {
    assertContentsAnyOrder((String) null, actual, expected);
  }
}
