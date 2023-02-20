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
package com.google.javascript.jscomp;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import com.google.javascript.jscomp.CallGraph.Callsite;
import com.google.javascript.jscomp.CallGraph.Function;
import com.google.javascript.jscomp.graph.FixedPointGraphTraversal;
import com.google.javascript.jscomp.graph.FixedPointGraphTraversal.EdgeCallback;
import com.google.javascript.rhino.Node;
import com.google.javascript.rhino.Token;

import java.util.Collection;
import java.util.List;
import java.util.Set;

/**
 * Tests for CallGraph.
 *
 * @author dcc@google.com (Devin Coughlin)
 */
public class CallGraphTest extends CompilerTestCase {

  private CallGraph currentProcessor;

  private boolean createForwardCallGraph;
  private boolean createBackwardCallGraph;

  @Override
  protected CompilerPass getProcessor(Compiler compiler) {
    // We store the new callgraph so it can be tested later
    currentProcessor = new CallGraph(compiler, createForwardCallGraph,
        createBackwardCallGraph);

    return currentProcessor;
  }

  static final String SHARED_EXTERNS =
      "var ExternalFunction = function(a) {}\n" +
      "var externalnamespace = {}\n" +
      "externalnamespace.prop = function(){};\n";

public void testGetDirectedGraph_backwardOnForward591() { 
     String source = "function A(){};\n" + "function B(){ExternalFunction(6); C(); D();}\n" + "function C(){B(); A();};\n" + "function D(){A();};\n" + "function E(){C()};\n" + "A();\n"; 
     CallGraph callgraph = compileAndRunForward(source); 
     final Set<Function> poisonedFunctions = Sets.newHashSet(); 
     for (Callsite callsite : callgraph.getAllCallsites()) { 
         if (callsite.hasExternTarget()) { 
             poisonedFunctions.add(callsite.getContainingFunction()); 
         } 
     } 
     EdgeCallback<CallGraph.Function, CallGraph.Callsite> edgeCallback = new EdgeCallback<CallGraph.Function, CallGraph.Callsite>() { 
  
         @Override 
         public boolean traverseEdge(Function callee, Callsite callsite, Function caller) { 
             boolean changed; 
             if (poisonedFunctions.contains(callee)) { 
                 changed = poisonedFunctions.add(caller); 
             } else { 
                 changed = false; 
             } 
             return changed; 
         } 
     }; 
     FixedPointGraphTraversal.newTraversal(edgeCallback).computeFixedPoint(callgraph.getBackwardDirectedGraph()); 
     assertEquals(3, poisonedFunctions.size()); 
     assertTrue(poisonedFunctions.contains(callgraph.getUniqueFunctionWithName("B"))); 
     assertTrue(poisonedFunctions.contains(callgraph.getUniqueFunctionWithName("C"))); 
     assertTrue(poisonedFunctions.contains(callgraph.getUniqueFunctionWithName("E"))); 
 }
public void testFunctionIsMain592() { 
     String source = "function A(){};\n" + "A();\n"; 
     CallGraph callgraph = compileAndRunForward(source); 
     CallGraph.Function mainFunction = callgraph.getMainFunction(); 
     assertTrue(mainFunction.isMain()); 
     assertNotNull(mainFunction.getBodyNode()); 
     assertTrue(mainFunction.getBodyNode().isBlock()); 
     CallGraph.Function functionA = callgraph.getUniqueFunctionWithName("A"); 
     assertFalse(functionA.isMain()); 
 }
public void testGetAllFunctionsContainsAnonymousFunction593() { 
     String source = "var A = function(){(function(){})();};\n"; 
     CallGraph callgraph = compileAndRunForward(source); 
     Collection<CallGraph.Function> allFunctions = callgraph.getAllFunctions(); 
     assertEquals(3, allFunctions.size()); 
     assertTrue(allFunctions.contains(callgraph.getUniqueFunctionWithName("A"))); 
     assertTrue(allFunctions.contains(callgraph.getUniqueFunctionWithName(null))); 
     assertTrue(allFunctions.contains(callgraph.getMainFunction())); 
 }
public void testGetAllFunctions594() { 
     String source = "function A() {}\n" + "var B = function() {\n" + "(function C(){A()})()\n" + "};\n"; 
     CallGraph callgraph = compileAndRunForward(source); 
     Collection<CallGraph.Function> functions = callgraph.getAllFunctions(); 
     assertEquals(4, functions.size()); 
     CallGraph.Function functionA = callgraph.getUniqueFunctionWithName("A"); 
     CallGraph.Function functionB = callgraph.getUniqueFunctionWithName("B"); 
     CallGraph.Function functionC = callgraph.getUniqueFunctionWithName("C"); 
     assertEquals("A", NodeUtil.getFunctionName(functionA.getAstNode())); 
     assertEquals("B", NodeUtil.getFunctionName(functionB.getAstNode())); 
     assertEquals("C", NodeUtil.getFunctionName(functionC.getAstNode())); 
 }
public void testFunctionGetIsMain596() { 
     String source = "function A(){};\n" + "A();\n"; 
     CallGraph callgraph = compileAndRunForward(source); 
     CallGraph.Function mainFunction = callgraph.getMainFunction(); 
     assertTrue(mainFunction.isMain()); 
     assertNotNull(mainFunction.getBodyNode()); 
     assertTrue(mainFunction.getBodyNode().isBlock()); 
     CallGraph.Function functionA = callgraph.getUniqueFunctionWithName("A"); 
     assertFalse(functionA.isMain()); 
 }
public void testGetAllFunctions598() { 
     String source = "function A() {}\n" + "var B = function() {\n" + "(function C(){A()})()\n" + "};\n"; 
     CallGraph callgraph = compileAndRunForward(source); 
     Collection<CallGraph.Function> allFunctions = callgraph.getAllFunctions(); 
     assertEquals(4, allFunctions.size()); 
     CallGraph.Function functionA = callgraph.getUniqueFunctionWithName("A"); 
     CallGraph.Function functionB = callgraph.getUniqueFunctionWithName("B"); 
     CallGraph.Function functionC = callgraph.getUniqueFunctionWithName("C"); 
     assertEquals("A", NodeUtil.getFunctionName(functionA.getAstNode())); 
     assertEquals("B", NodeUtil.getFunctionName(functionB.getAstNode())); 
     assertEquals("C", NodeUtil.getFunctionName(functionC.getAstNode())); 
 }
public void testFunctionGetIsExposedToCallOrApply599() { 
     String source = "function A(){};\n" + "function B(){ExternalFunction(6); C(); D();}\n" + "function C(){B(); A();};\n" + "function D(){A();};\n" + "function E(){C()};\n" + "A();\n"; 
     CallGraph callgraph = compileAndRunForward(source); 
     final Set<Function> poisonedFunctions = Sets.newHashSet(); 
     for (Callsite callsite : callgraph.getAllCallsites()) { 
         if (callsite.hasExternTarget()) { 
             poisonedFunctions.add(callsite.getContainingFunction()); 
         } 
     } 
     EdgeCallback<CallGraph.Function, CallGraph.Callsite> edgeCallback = new EdgeCallback<CallGraph.Function, CallGraph.Callsite>() { 
  
         @Override 
         public boolean traverseEdge(Function callee, Callsite callsite, Function caller) { 
             boolean changed; 
             if (poisonedFunctions.contains(callee)) { 
                 changed = poisonedFunctions.add(caller); 
             } else { 
                 changed = false; 
             } 
             return changed; 
         } 
     }; 
     FixedPointGraphTraversal.newTraversal(edgeCallback).computeFixedPoint(callgraph.getBackwardDirectedGraph()); 
     assertEquals(3, poisonedFunctions.size()); 
     assertTrue(poisonedFunctions.contains(callgraph.getUniqueFunctionWithName("B"))); 
     assertTrue(poisonedFunctions.contains(callgraph.getUniqueFunctionWithName("C"))); 
     assertTrue(poisonedFunctions.contains(callgraph.getUniqueFunctionWithName("E"))); 
 }
  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  /**
   * Test getting a backward directed graph on a backward call graph
   * and propagating over it.
   */
  

  /**
   * Test getting a backward directed graph on a forward call graph
   * and propagating over it.
   */
  

  /**
   * Test getting a forward directed graph on a forward call graph
   * and propagating over it.
   */
  

  /**
   * Test getting a backward directed graph on a forward call graph
   * and propagating over it.
   */
  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  /**
   * Helper function that, given a collection of callsites, returns a
   * collection of the names of the target expression nodes, e.g.
   * if the callsites are [A(), B.b()], the collection returned is
   * ["A", "B"].
   *
   * This makes it easier to test methods that return collections of callsites.
   *
   * An exception is thrown if the callsite target is not a simple name
   * (e.g. "a.bar()").
   */
  private List<String> getCallsiteTargetNames(Collection<Callsite>
      callsites) {
    List<String> result = Lists.newArrayList();

    for (Callsite callsite : callsites) {
      Node targetExpressionNode = callsite.getAstNode().getFirstChild();
      if (targetExpressionNode.isName()) {
        result.add(targetExpressionNode.getString());
      } else {
        throw new IllegalStateException("Called getCallsiteTargetNames() on " +
            "a complex callsite.");
      }
    }

    return result;
  }

  private void assertFunctionAliased(boolean aliased, String name) {
    Function function = currentProcessor.getUniqueFunctionWithName(name);

    assertEquals(aliased, function.isAliased());
  }

  private CallGraph compileAndRunBackward(String js) {
    return compileAndRun(SHARED_EXTERNS, js, false, true);
  }

  private CallGraph compileAndRunForward(String js) {
    return compileAndRun(SHARED_EXTERNS, js, true, false);
  }

  private CallGraph compileAndRun(String externs,
      String js,
      boolean forward,
      boolean backward) {

    createBackwardCallGraph = backward;
    createForwardCallGraph = forward;

    testSame(externs, js, null);

    return currentProcessor;
  }
}
