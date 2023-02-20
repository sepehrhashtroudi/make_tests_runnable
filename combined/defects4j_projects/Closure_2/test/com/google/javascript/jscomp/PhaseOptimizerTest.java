/*
 * Copyright 2009 The Closure Compiler Authors.
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

package com.google.javascript.jscomp;

import com.google.common.collect.Lists;
import com.google.javascript.jscomp.CompilerOptions.TracerMode;
import com.google.javascript.jscomp.PhaseOptimizer.Loop;
import com.google.javascript.rhino.Node;
import com.google.javascript.rhino.Token;

import junit.framework.TestCase;

import java.util.List;
import java.util.Random;

/**
 * Tests for {@link PhaseOptimizer}.
 * @author nicksantos@google.com (Nick Santos)
 */
public class PhaseOptimizerTest extends TestCase {
  private final List<String> passesRun = Lists.newArrayList();
  private PhaseOptimizer optimizer;
  private Compiler compiler;
  private PerformanceTracker tracker;

  @Override
  public void setUp() {
    passesRun.clear();
    compiler = new Compiler();
    compiler.initCompilerOptionsIfTesting();
    tracker = new PerformanceTracker(
        new Node(Token.BLOCK), TracerMode.TIMING_ONLY);
    optimizer = new PhaseOptimizer(compiler, tracker, null);
  }

public void testConsumption3427() { 
     optimizer.consume(Lists.newArrayList(createPassFactory("a", 2, true), createPassFactory("b", 0, false), createPassFactory("c", 0, false))); 
     assertPasses("a", "b", "c"); 
 }
public void testProgress428() { 
     final List<Double> progressList = Lists.newArrayList(); 
     compiler = new Compiler() { 
  
         @Override 
         void setProgress(double p, String name) { 
             progressList.add(p); 
         } 
     }; 
     compiler.initCompilerOptionsIfTesting(); 
     optimizer = new PhaseOptimizer(compiler, null, new PhaseOptimizer.ProgressRange(0, 100)); 
     addOneTimePass("x1"); 
     addOneTimePass("x2"); 
     addOneTimePass("x3"); 
     addOneTimePass("x4"); 
     optimizer.process(null, null); 
     assertEquals(4, progressList.size()); 
     assertEquals(25, Math.round(progressList.get(0))); 
     assertEquals(50, Math.round(progressList.get(1))); 
     assertEquals(75, Math.round(progressList.get(2))); 
     assertEquals(100, Math.round(progressList.get(3))); 
 }
public void testInfiniteLoop432() { 
     Loop loop = optimizer.addFixedPointLoop(); 
     addLoopedPass(loop, "x", PhaseOptimizer.MAX_LOOPS + 1); 
     try { 
         optimizer.process(null, null); 
         fail("Expected RuntimeException"); 
     } catch (RuntimeException e) { 
         assertTrue(e.getMessage().contains(PhaseOptimizer.OPTIMIZE_LOOP_ERROR)); 
     } 
 }
  

  

  

  

  

  

  

  

  

  

  

  

  

  

  public void assertPasses(String ... names) {
    optimizer.process(null, null);
    assertEquals(Lists.newArrayList(names), passesRun);
  }

  private void addOneTimePass(String name) {
    optimizer.addOneTimePass(
        createPassFactory(name, 0, true));
  }

  private void addLoopedPass(Loop loop, String name, int numChanges) {
    loop.addLoopedPass(
        createPassFactory(name, numChanges, false));
  }

  private PassFactory createPassFactory(
      String name, int numChanges, boolean isOneTime) {
    return createPassFactory(name, createPass(name, numChanges), isOneTime);
  }

  private PassFactory createPassFactory(
      String name, final CompilerPass pass, boolean isOneTime) {
    return new PassFactory(name, isOneTime) {
      @Override
      protected CompilerPass create(AbstractCompiler compiler) {
        return pass;
      }
    };
  }

  private CompilerPass createPass(final String name, int numChanges) {
    final int[] numChangesClosure = new int[] {numChanges};
    return new CompilerPass() {
      @Override public void process(Node externs, Node root) {
        passesRun.add(name);
        if (numChangesClosure[0] > 0) {
          compiler.reportCodeChange();
          numChangesClosure[0] = numChangesClosure[0] - 1;
        }
      }
    };
  }
}
