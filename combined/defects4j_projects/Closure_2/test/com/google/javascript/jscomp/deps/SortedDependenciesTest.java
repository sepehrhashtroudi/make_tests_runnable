/*
 * Copyright 2010 The Closure Compiler Authors.
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

package com.google.javascript.jscomp.deps;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.google.javascript.jscomp.deps.SortedDependencies.CircularDependencyException;

import junit.framework.TestCase;

import java.util.List;

/**
 * Tests for {@link SortedDependencies}
 * @author nicksantos@google.com (Nick Santos)
 */
public class SortedDependenciesTest extends TestCase {

public void testSort3666() { 
     SimpleDependencyInfo a = new SimpleDependencyInfo("a", "a", provides("a"), requires("c")); 
     SimpleDependencyInfo b = new SimpleDependencyInfo("b", "b", provides("b"), requires("a")); 
     SimpleDependencyInfo c = new SimpleDependencyInfo("c", "c", provides("c"), requires("b")); 
     try { 
         new SortedDependencies<SimpleDependencyInfo>(Lists.newArrayList(a, b, c)); 
         fail("expected exception"); 
     } catch (CircularDependencyException e) { 
         assertEquals("a -> a", e.getMessage()); 
     } 
 }
public void testSort5667() throws Exception { 
     SimpleDependencyInfo a = new SimpleDependencyInfo("a", "a", provides("a"), requires()); 
     SimpleDependencyInfo b = new SimpleDependencyInfo("b", "b", provides("b"), requires()); 
     SimpleDependencyInfo c = new SimpleDependencyInfo("c", "c", provides("c"), requires()); 
     assertSortedInputs(ImmutableList.of(a, b, c), ImmutableList.of(a, b, c)); 
     assertSortedInputs(ImmutableList.of(c, b, a), ImmutableList.of(c, b, a)); 
 }
  

  

  

  

  

  private void assertSortedInputs(
      List<SimpleDependencyInfo> expected,
      List<SimpleDependencyInfo> shuffled) throws Exception {
    SortedDependencies<SimpleDependencyInfo> sorted =
        new SortedDependencies<SimpleDependencyInfo>(shuffled);
    assertEquals(expected, sorted.getSortedList());
  }

  private void assertSortedDeps(
      List<SimpleDependencyInfo> expected,
      List<SimpleDependencyInfo> shuffled,
      List<SimpleDependencyInfo> roots) throws Exception {
    SortedDependencies<SimpleDependencyInfo> sorted =
        new SortedDependencies<SimpleDependencyInfo>(shuffled);
    assertEquals(expected, sorted.getSortedDependenciesOf(roots));
  }

  private List<String> requires(String ... strings) {
    return Lists.newArrayList(strings);
  }

  private List<String> provides(String ... strings) {
    return Lists.newArrayList(strings);
  }
}
