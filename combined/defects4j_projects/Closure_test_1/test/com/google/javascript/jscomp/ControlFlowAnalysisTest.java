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

package com.google.javascript.jscomp;

import com.google.common.collect.Lists;
import com.google.javascript.jscomp.ControlFlowGraph.Branch;
import com.google.javascript.jscomp.graph.DiGraph.DiGraphEdge;
import com.google.javascript.jscomp.graph.DiGraph.DiGraphNode;
import com.google.javascript.rhino.Node;
import com.google.javascript.rhino.Token;

import junit.framework.TestCase;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;


/**
 * Tests {@link ControlFlowAnalysis}.
 *
 */
public class ControlFlowAnalysisTest extends TestCase {

  /**
   * Given an input in JavaScript, test if the control flow analysis
   * creates the proper control flow graph by comparing the expected
   * Dot file output.
   *
   * @param input Input JavaScript.
   * @param expected Expected Graphviz Dot file.
   */
  private void testCfg(String input, String expected) {
    testCfg(input, expected, true);
  }

  /**
   * Gets all the edges of the graph.
   */
  private static List<DiGraphEdge<Node, Branch>> getAllEdges(
      ControlFlowGraph<Node> cfg) {
    List<DiGraphEdge<Node, Branch>> edges = Lists.newArrayList();
    for (DiGraphNode<Node, Branch> n : cfg.getDirectedGraphNodes()) {
      for (DiGraphEdge<Node, Branch> e : cfg.getOutEdges(n.getValue())) {
        edges.add(e);
      }
    }
    return edges;
  }

  /**
   * Gets all the control flow edges from some node with the first token to
   * some node with the second token.
   */
  private static List<DiGraphEdge<Node, Branch>> getAllEdges(
      ControlFlowGraph<Node> cfg, int startToken, int endToken) {
    List<DiGraphEdge<Node, Branch>> edges = getAllEdges(cfg);
    Iterator<DiGraphEdge<Node, Branch>> it = edges.iterator();
    while (it.hasNext()) {
      DiGraphEdge<Node, Branch> edge = it.next();
      Node startNode = edge.getSource().getValue();
      Node endNode = edge.getDestination().getValue();
      if (startNode == null || endNode == null ||
          startNode.getType() != startToken || endNode.getType() != endToken) {
        it.remove();
      }
    }
    return edges;
  }

  /**
   * Gets all the control flow edges of the given type from some node with the
   * first token to some node with the second token.
   */
  private static List<DiGraphEdge<Node, Branch>> getAllEdges(
      ControlFlowGraph<Node> cfg, int startToken, int endToken, Branch type) {
    List<DiGraphEdge<Node, Branch>> edges =
        getAllEdges(cfg, startToken, endToken);
    Iterator<DiGraphEdge<Node, Branch>> it = edges.iterator();
    while (it.hasNext()) {
      if (type != it.next().getValue()) {
        it.remove();
      }
    }
    return edges;
  }

  private static boolean isAncestor(Node n, Node maybeDescendent) {
    for (Node current = n.getFirstChild(); current != null;
         current = current.getNext()) {
      if (current == maybeDescendent ||
          isAncestor(current, maybeDescendent)) {
        return true;
      }
    }

    return false;
  }

  /**
   * Gets all the control flow edges of the given type from some node with
   * the first token to some node with the second token.
   * This edge must flow from a parent to one of its descendants.
   */
  private static List<DiGraphEdge<Node, Branch>> getAllDownEdges(
      ControlFlowGraph<Node> cfg, int startToken, int endToken, Branch type) {
    List<DiGraphEdge<Node, Branch>> edges =
        getAllEdges(cfg, startToken, endToken, type);
    Iterator<DiGraphEdge<Node, Branch>> it = edges.iterator();
    while (it.hasNext()) {
      DiGraphEdge<Node, Branch> edge = it.next();
      Node source = edge.getSource().getValue();
      Node dest = edge.getDestination().getValue();
      if (!isAncestor(source, dest)) {
        it.remove();
      }
    }

    return edges;
  }

  /**
   * Assert that there exists a control flow edge of the given type
   * from some node with the first token to some node with the second token.
   */
  private static void assertNoEdge(ControlFlowGraph<Node> cfg, int startToken,
      int endToken) {
    assertEquals(0, getAllEdges(cfg, startToken, endToken).size());
  }

  /**
   * Assert that there exists a control flow edge of the given type
   * from some node with the first token to some node with the second token.
   * This edge must flow from a parent to one of its descendants.
   */
  private static void assertDownEdge(ControlFlowGraph<Node> cfg,
      int startToken, int endToken, Branch type) {
    assertTrue("No down edge found",
        0 != getAllDownEdges(cfg, startToken, endToken, type).size());
  }

  /**
   * Assert that there exists a control flow edge of the given type
   * from some node with the first token to some node with the second token.
   * This edge must flow from a node to one of its ancestors.
   */
  private static void assertUpEdge(ControlFlowGraph<Node> cfg,
      int startToken, int endToken, Branch type) {
    assertTrue("No up edge found",
        0 != getAllDownEdges(cfg, endToken, startToken, type).size());
  }

  /**
   * Assert that there exists a control flow edge of the given type
   * from some node with the first token to some node with the second token.
   * This edge must flow between two nodes that are not in the same subtree.
   */
  private static void assertCrossEdge(ControlFlowGraph<Node> cfg,
      int startToken, int endToken, Branch type) {
    int numDownEdges = getAllDownEdges(cfg, startToken, endToken, type).size();
    int numUpEdges = getAllDownEdges(cfg, endToken, startToken, type).size();
    int numEdges = getAllEdges(cfg, startToken, endToken, type).size();
    assertTrue("No cross edges found", numDownEdges + numUpEdges < numEdges);
  }

  /**
   * Assert that there exists a control flow edge of the given type
   * from some node with the first token to the return node.
   */
  private static void assertReturnEdge(ControlFlowGraph<Node> cfg,
      int startToken) {
    List<DiGraphEdge<Node, Branch>> edges = getAllEdges(cfg);
    for (DiGraphEdge<Node, Branch> edge : edges) {
      Node source = edge.getSource().getValue();
      DiGraphNode<Node, Branch> dest = edge.getDestination();
      if (source.getType() == startToken &&
          cfg.isImplicitReturn(dest)) {
        return;
      }
    }

    fail("No return edge found");
  }

  /**
   * Assert that there exists no control flow edge of the given type
   * from some node with the first token to the return node.
   */
  private static void assertNoReturnEdge(ControlFlowGraph<Node> cfg,
      int startToken) {
    List<DiGraphEdge<Node, Branch>> edges = getAllEdges(cfg);
    for (DiGraphEdge<Node, Branch> edge : edges) {
      Node source = edge.getSource().getValue();
      DiGraphNode<Node, Branch> dest = edge.getDestination();
      if (source.getType() == startToken) {
        assertTrue("Token " + startToken + " should not have an out going" +
            " edge to the implicit return", !cfg.isImplicitReturn(dest));
        return;
      }
    }
  }

  /**
   * Given an input in JavaScript, get a control flow graph for it.
   *
   * @param input Input JavaScript.
   */
  private ControlFlowGraph<Node> createCfg(String input,
      boolean runSynBlockPass) {
    Compiler compiler = new Compiler();
    ControlFlowAnalysis cfa = new ControlFlowAnalysis(compiler, true, true);

    Node root = compiler.parseSyntheticCode("cfgtest", input);
    if (runSynBlockPass) {
      CreateSyntheticBlocks pass = new CreateSyntheticBlocks(
          compiler, "START", "END");
      pass.process(null, root);
    }
    cfa.process(null, root);
    return cfa.getCfg();
  }

  private ControlFlowGraph<Node> createCfg(String input) {
    return createCfg(input, false);
  }

  /**
   * Given an input in JavaScript, test if the control flow analysis
   * creates the proper control flow graph by comparing the expected
   * Dot file output.
   *
   * @param input Input JavaScript.
   * @param expected Expected Graphviz Dot file.
   * @param shouldTraverseFunctions Whether to traverse functions when
   *    constructing the CFG (true by default). Passed in to the
   *    constructor of {@link ControlFlowAnalysis}.
   */
  private void testCfg(String input, String expected,
      boolean shouldTraverseFunctions) {
    Compiler compiler = new Compiler();
    ControlFlowAnalysis cfa =
        new ControlFlowAnalysis(compiler, shouldTraverseFunctions, true);

    Node root = compiler.parseSyntheticCode("cfgtest", input);
    cfa.process(null, root);
    ControlFlowGraph<Node> cfg = cfa.getCfg();
    try {
      assertEquals(expected, DotFormatter.toDot(root, cfg));
    } catch (java.io.IOException e) {
      fail("Tests failed with IOExceptions");
    }
  }

public void testLocalFunctionOrder412() { 
     ControlFlowGraph<Node> cfg = createCfg("function f() { while (x) { x++; } } var x = 3;"); 
     assertNodeOrder(cfg, Lists.newArrayList(Token.SCRIPT, Token.VAR, Token.FUNCTION, Token.BLOCK, Token.WHILE, Token.BLOCK, Token.EXPR_RESULT)); 
 }
public void testOptionNotToTraverseFunctions818() { 
     String src = "var x = 1; function f() { x = null; }"; 
     String expectedWhenNotTraversingFunctions = "digraph AST {\n" + "  node [color=lightblue2, style=filled];\n" + "  node0 [label=\"SCRIPT\"];\n" + "  node1 [label=\"VAR\"];\n" + "  node0 -> node1 [weight=1];\n" + "  node2 [label=\"NAME\"];\n" + "  node1 -> node2 [weight=1];\n" + "  node3 [label=\"NUMBER\"];\n" + "  node2 -> node3 [weight=1];\n" + "  node1 -> RETURN " + "[label=\"UNCOND\", fontcolor=\"red\", weight=0.01, color=\"red\"];\n" + "  node4 [label=\"FUNCTION\"];\n" + "  node0 -> node4 [weight=1];\n" + "  node5 [label=\"NAME\"];\n" + "  node4 -> node5 [weight=1];\n" + "  node6 [label=\"PARAM_LIST\"];\n" + "  node4 -> node6 [weight=1];\n" + "  node7 [label=\"BLOCK\"];\n" + "  node4 -> node7 [weight=1];\n" + "  node8 [label=\"EXPR_RESULT\"];\n" + "  node7 -> node8 [weight=1];\n" + "  node9 [label=\"ASSIGN\"];\n" + "  node8 -> node9 [weight=1];\n" + "  node10 [label=\"NAME\"];\n" + "  node9 -> node10 [weight=1];\n" + "  node11 [label=\"NULL\"];\n" + "  node9 -> node11 [weight=1];\n" + "  node0 -> node1 " + "[label=\"UNCOND\", fontcolor=\"red\", weight=0.01, color=\"red\"];\n" + "}\n";
}

public void testBreakingTryBlock819() { 
     String src = "a: try { break a; } finally {} if(x) {}"; 
     ControlFlowGraph<Node> cfg = createCfg(src); 
     assertCrossEdge(cfg, Token.BREAK, Token.IF, Branch.UNCOND); 
     src = "a: try {} finally {break a;} if(x) {}"; 
     cfg = createCfg(src); 
     assertCrossEdge(cfg, Token.BREAK, Token.IF, Branch.UNCOND); 
     src = "a: try {} catch(e) {break a;} if(x) {}"; 
     cfg = createCfg(src); 
     assertCrossEdge(cfg, Token.BREAK, Token.IF, Branch.UNCOND); 
 }
public void testPartialTraversalOfScope821() { 
     Compiler compiler = new Compiler(); 
     ControlFlowAnalysis cfa = new ControlFlowAnalysis(compiler, true, true); 
     Node script1 = compiler.parseSyntheticCode("cfgtest", "var foo;"); 
     Node script2 = compiler.parseSyntheticCode("cfgtest2", "var bar;"); 
     Node root = new Node(Token.BLOCK, script1, script2); 
     cfa.process(null, script1); 
     ControlFlowGraph<Node> cfg = cfa.getCfg(); 
     assertNotNull(cfg.getNode(script1)); 
     assertNull(cfg.getNode(script2)); 
 }
public void testDoWhileOrder822() { 
     assertNodeOrder(createCfg("do { var x = 3; } while (true); void x;"), Lists.newArrayList(Token.SCRIPT, Token.BLOCK, Token.VAR, Token.DO, Token.EXPR_RESULT)); 
 }
public void testReturnInFinally825() { 
     String src = "function f(x){ try{} finally {return x;} }"; 
     ControlFlowGraph<Node> cfg = createCfg(src); 
     assertReturnEdge(cfg, Token.RETURN); 
 }
public void testComplicatedFinally2826() { 
     String src = "while(1){try{" + "if(a){a;continue;}else if(b){b;break;} else if(c) throw 1; else a}" + "catch(e){}finally{c()}bar}foo"; 
     ControlFlowGraph<Node> cfg = createCfg(src); 
     assertCrossEdge(cfg, Token.CONTINUE, Token.BLOCK, Branch.UNCOND); 
     assertCrossEdge(cfg, Token.BREAK, Token.BLOCK, Branch.UNCOND); 
     assertCrossEdge(cfg, Token.THROW, Token.BLOCK, Branch.ON_EX); 
 }
public void testDeepNestedFinally829() { 
     String src = "try{try{try{throw 1}" + "finally{1;var a}}finally{2;if(a);}}finally{3;a()}"; 
     ControlFlowGraph<Node> cfg = createCfg(src); 
     assertCrossEdge(cfg, Token.THROW, Token.BLOCK, Branch.ON_EX); 
     assertCrossEdge(cfg, Token.VAR, Token.BLOCK, Branch.UNCOND); 
     assertCrossEdge(cfg, Token.IF, Token.BLOCK, Branch.ON_EX); 
 }
  

  // Test a simple IF control flow.
  

  

  

  

  // Test a simple WHILE control flow with BREAKs.
  

  

  

  

  

  

  

  // Test a simple FOR loop.
  

  

  

  

  

  

  // Test a simple FUNCTION.
  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  


  /**
   * Asserts the priority order of CFG nodes.
   *
   * Checks that the node type of the highest-priority node matches the
   * first element of the list, the type of the second node matches the
   * second element of the list, and so on.
   *
   * @param cfg The control flow graph.
   * @param nodeTypes The expected node types, in order.
   */
  private void assertNodeOrder(ControlFlowGraph<Node> cfg,
      List<Integer> nodeTypes) {
    List<DiGraphNode<Node, Branch>> cfgNodes =
        Lists.newArrayList(cfg.getDirectedGraphNodes());
    Collections.sort(cfgNodes, cfg.getOptionalNodeComparator(true));

    // IMPLICIT RETURN must always be last.
    Node implicitReturn = cfgNodes.remove(cfgNodes.size() - 1).getValue();
    assertNull(implicitReturn == null ? "null" : implicitReturn.toStringTree(),
        implicitReturn);

    assertEquals("Wrong number of CFG nodes",
        nodeTypes.size(), cfgNodes.size());
    for (int i = 0; i < cfgNodes.size(); i++) {
      int expectedType = nodeTypes.get(i);
      int actualType = cfgNodes.get(i).getValue().getType();
      assertEquals(
          "node type mismatch at " + i + ".\n" +
          "found   : " + Token.name(actualType) + "\n" +
          "required: " + Token.name(expectedType) + "\n",
          expectedType, actualType);
    }
  }
}
