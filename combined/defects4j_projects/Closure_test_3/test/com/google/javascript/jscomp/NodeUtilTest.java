/*
 * Copyright 2004 The Closure Compiler Authors.
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

import com.google.common.base.Preconditions;
import com.google.common.base.Predicates;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Sets;
import com.google.javascript.jscomp.CompilerOptions.LanguageMode;
import com.google.javascript.rhino.IR;
import com.google.javascript.rhino.Node;
import com.google.javascript.rhino.Token;
import com.google.javascript.rhino.jstype.TernaryValue;

import junit.framework.TestCase;

import java.util.Collection;
import java.util.Set;

/**
 * Tests for NodeUtil
 */
public class NodeUtilTest extends TestCase {

  private static Node parse(String js) {
    Compiler compiler = new Compiler();
    compiler.initCompilerOptionsIfTesting();
    compiler.getOptions().setLanguageIn(LanguageMode.ECMASCRIPT5);
    Node n = compiler.parseTestCode(js);
    assertEquals(0, compiler.getErrorCount());
    return n;
  }

  static Node getNode(String js) {
    Node root = parse("var a=(" + js + ");");
    Node expr = root.getFirstChild();
    Node var = expr.getFirstChild();
    return var.getFirstChild();
  }

public void testIsLiteralOrConstValue537() { 
     assertLiteralAndImmutable(getNode("10")); 
     assertLiteralAndImmutable(getNode("-10")); 
     assertLiteralButNotImmutable(getNode("[10, 20]")); 
     assertLiteralButNotImmutable(getNode("{'a': 20}")); 
     assertLiteralButNotImmutable(getNode("[10, , 1.0, [undefined], 'a']")); 
     assertLiteralButNotImmutable(getNode("/abc/")); 
     assertLiteralAndImmutable(getNode("\"string\"")); 
     assertLiteralAndImmutable(getNode("'aaa'")); 
     assertLiteralAndImmutable(getNode("null")); 
     assertLiteralAndImmutable(getNode("undefined")); 
     assertLiteralAndImmutable(getNode("void 0")); 
     assertNotLiteral(getNode("abc")); 
     assertNotLiteral(getNode("[10, foo(), 20]")); 
     assertNotLiteral(getNode("foo()")); 
     assertNotLiteral(getNode("c + d")); 
     assertNotLiteral(getNode("{'a': foo()}")); 
     assertNotLiteral(getNode("void foo()")); 
 }
public void testCallSideEffects541() { 
     Node callExpr = getNode("new x().method()"); 
     assertTrue(NodeUtil.functionCallHasSideEffects(callExpr)); 
     Node newExpr = callExpr.getFirstChild().getFirstChild(); 
     Preconditions.checkState(newExpr.isNew()); 
     Node.SideEffectFlags flags = new Node.SideEffectFlags(); 
     flags.clearAllFlags(); 
     newExpr.setSideEffectFlags(flags.valueOf()); 
     flags.clearAllFlags(); 
     callExpr.setSideEffectFlags(flags.valueOf()); 
     assertTrue(NodeUtil.evaluatesToLocalValue(callExpr)); 
     assertFalse(NodeUtil.functionCallHasSideEffects(callExpr)); 
     assertFalse(NodeUtil.mayHaveSideEffects(callExpr)); 
     flags.clearAllFlags(); 
     newExpr.setSideEffectFlags(flags.valueOf()); 
     flags.clearAllFlags(); 
     flags.setMutatesThis(); 
     callExpr.setSideEffectFlags(flags.valueOf()); 
     assertTrue(NodeUtil.evaluatesToLocalValue(callExpr)); 
     assertFalse(NodeUtil.functionCallHasSideEffects(callExpr)); 
     assertFalse(NodeUtil.mayHaveSideEffects(callExpr)); 
     flags.clearAllFlags(); 
     newExpr.setSideEffectFlags(flags.valueOf()); 
     flags.clearAllFlags(); 
     flags.setMutatesThis(); 
     flags.setReturnsTainted(); 
     callExpr.setSideEffectFlags(flags.valueOf()); 
     assertFalse(NodeUtil.evaluatesToLocalValue(callExpr)); 
     assertFalse(NodeUtil.functionCallHasSideEffects(callExpr)); 
     assertFalse(NodeUtil.mayHaveSideEffects(callExpr)); 
     flags.clearAllFlags(); 
     newExpr.setSideEffectFlags(flags.valueOf()); 
     flags.clearAllFlags();
}

public void testGetNodeTypeReferenceCount553() { 
     assertEquals(0, NodeUtil.getNodeTypeReferenceCount(parse("function foo(){}"), Token.THIS, Predicates.<Node>alwaysTrue())); 
     assertEquals(1, NodeUtil.getNodeTypeReferenceCount(parse("this"), Token.THIS, Predicates.<Node>alwaysTrue())); 
     assertEquals(2, NodeUtil.getNodeTypeReferenceCount(parse("this;function foo(){}(this)"), Token.THIS, Predicates.<Node>alwaysTrue())); 
 }
  

  public void assertLiteralAndImmutable(Node n) {
    assertTrue(NodeUtil.isLiteralValue(n, true));
    assertTrue(NodeUtil.isLiteralValue(n, false));
    assertTrue(NodeUtil.isImmutableValue(n));
  }

  public void assertLiteralButNotImmutable(Node n) {
    assertTrue(NodeUtil.isLiteralValue(n, true));
    assertTrue(NodeUtil.isLiteralValue(n, false));
    assertFalse(NodeUtil.isImmutableValue(n));
  }

  public void assertNotLiteral(Node n) {
    assertFalse(NodeUtil.isLiteralValue(n, true));
    assertFalse(NodeUtil.isLiteralValue(n, false));
    assertFalse(NodeUtil.isImmutableValue(n));
  }

  

  private void assertPureBooleanTrue(String val) {
    assertEquals(TernaryValue.TRUE, NodeUtil.getPureBooleanValue(getNode(val)));
  }

  private void assertPureBooleanFalse(String val) {
    assertEquals(
        TernaryValue.FALSE, NodeUtil.getPureBooleanValue(getNode(val)));
  }

  private void assertPureBooleanUnknown(String val) {
    assertEquals(
        TernaryValue.UNKNOWN, NodeUtil.getPureBooleanValue(getNode(val)));
  }

  

  private void assertImpureBooleanTrue(String val) {
    assertEquals(TernaryValue.TRUE,
        NodeUtil.getImpureBooleanValue(getNode(val)));
  }

  private void assertImpureBooleanFalse(String val) {
    assertEquals(TernaryValue.FALSE,
        NodeUtil.getImpureBooleanValue(getNode(val)));
  }

  private void assertImpureBooleanUnknown(String val) {
    assertEquals(TernaryValue.UNKNOWN,
        NodeUtil.getImpureBooleanValue(getNode(val)));
  }

  

  

  

  private Node parseExpr(String js) {
    Compiler compiler = new Compiler();
    CompilerOptions options = new CompilerOptions();
    options.setLanguageIn(LanguageMode.ECMASCRIPT5);
    compiler.initOptions(options);
    Node root = compiler.parseTestCode(js);
    return root.getFirstChild().getFirstChild();
  }

  private void testIsObjectLiteralKey(Node node, boolean expected) {
    assertEquals(expected, NodeUtil.isObjectLitKey(node, node.getParent()));
  }

  

  

  

  

  

  private void testGetFunctionName(Node function, String name) {
    assertEquals(Token.FUNCTION, function.getType());
    assertEquals(name, NodeUtil.getFunctionName(function));
  }

  

  private void assertSideEffect(boolean se, String js) {
    Node n = parse(js);
    assertEquals(se, NodeUtil.mayHaveSideEffects(n.getFirstChild()));
  }

  private void assertSideEffect(boolean se, String js, boolean globalRegExp) {
    Node n = parse(js);
    Compiler compiler = new Compiler();
    compiler.setHasRegExpGlobalReferences(globalRegExp);
    assertEquals(se, NodeUtil.mayHaveSideEffects(n.getFirstChild(), compiler));
  }

  

  

  

  private void assertMutableState(boolean se, String js) {
    Node n = parse(js);
    assertEquals(se, NodeUtil.mayEffectMutableState(n.getFirstChild()));
  }

  


  

  private void assertContainsAnonFunc(boolean expected, String js) {
    Node funcParent = findParentOfFuncDescendant(parse(js));
    assertNotNull("Expected function node in parse tree of: " + js, funcParent);
    Node funcNode = getFuncChild(funcParent);
    assertEquals(expected, NodeUtil.isFunctionExpression(funcNode));
  }

  private Node findParentOfFuncDescendant(Node n) {
    for (Node c = n.getFirstChild(); c != null; c = c.getNext()) {
      if (c.isFunction()) {
        return n;
      }
      Node result = findParentOfFuncDescendant(c);
      if (result != null) {
        return result;
      }
    }
    return null;
  }

  private Node getFuncChild(Node n) {
    for (Node c = n.getFirstChild(); c != null; c = c.getNext()) {
      if (c.isFunction()) {
        return c;
      }
    }
    return null;
  }

  

  

  

  


  

  

  private void assertNodeNames(Set<String> nodeNames, Collection<Node> nodes) {
    Set<String> actualNames = Sets.newHashSet();
    for (Node node : nodes) {
      actualNames.add(node.getString());
    }
    assertEquals(nodeNames, actualNames);
  }

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  private boolean testLocalValue(String js) {
    return NodeUtil.evaluatesToLocalValue(getNode(js));
  }

  

  private boolean testValidDefineValue(String js) {
    Node script = parse("var test = " + js + ";");
    Node var = script.getFirstChild();
    Node name = var.getFirstChild();
    Node value = name.getFirstChild();

    ImmutableSet<String> defines = ImmutableSet.of();
    return NodeUtil.isValidDefineValue(value, defines);
  }

  

  

  

  

  

  

  

  

  

  private boolean executedOnceTestCase(String code) {
    Node ast = parse(code);
    Node nameNode = getNameNode(ast, "x");
    return NodeUtil.isExecutedExactlyOnce(nameNode);
  }

  private String getFunctionLValue(String js) {
    Node lVal = NodeUtil.getBestLValue(getFunctionNode(js));
    return lVal == null ? null : lVal.getString();
  }

  static void testFunctionName(String js, String expected) {
    assertEquals(
        expected,
        NodeUtil.getNearestFunctionName(getFunctionNode(js)));
  }

  static Node getFunctionNode(String js) {
    Node root = parse(js);
    return getFunctionNode(root);
  }

  static Node getFunctionNode(Node n) {
    if (n.isFunction()) {
      return n;
    }
    for (Node c : n.children()) {
      Node result = getFunctionNode(c);
      if (result != null) {
        return result;
      }
    }
    return null;
  }

  static Node getNameNode(Node n, String name) {
    if (n.isName() && n.getString().equals(name)) {
      return n;
    }
    for (Node c : n.children()) {
      Node result = getNameNode(c, name);
      if (result != null) {
        return result;
      }
    }
    return null;
  }
}
