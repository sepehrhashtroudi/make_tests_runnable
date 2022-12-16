/*
 * Copyright 2007 The Closure Compiler Authors.
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

import com.google.common.collect.ImmutableSet;
import com.google.javascript.jscomp.NodeTraversal.AbstractNodeTypePruningCallback;
import com.google.javascript.rhino.Node;
import com.google.javascript.rhino.Token;

import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Tests for {@link NodeTraversal}.
 */
public class NodeTraversalTest extends TestCase {

public void testParsePrintParse48() { 
     testReparse("3;"); 
     testReparse("var a = b;"); 
     testReparse("var x, y, z;"); 
     testReparse("try { foo() } catch(e) { bar() }"); 
     testReparse("try { foo() } catch(e) { bar() } finally { stuff() }"); 
     testReparse("try { foo() } finally { stuff() }"); 
     testReparse("throw 'me'"); 
     testReparse("function foo(a) { return a + 4; }"); 
     testReparse("function foo() { return; }"); 
     testReparse("var a = function(a, b) { foo(); return a + b; }"); 
     testReparse("b = [3, 4, 'paul', \"Buchhe it\",,5];"); 
     testReparse("v = (5, 6, 7, 8)"); 
     testReparse("d = 34.0; x = 0; y = .3; z = -22"); 
     testReparse("d = -x; t = !x + ~y;"); 
     testReparse("'hi'; /* just a test */ stuff(a,b) \n" + " foo(); // and another \n" + " bar();"); 
     testReparse("a = b++ + ++c; a = b++-++c; a = - --b; a = - ++b;"); 
     testReparse("a++; b= a++; b = ++a; b = a--; b = --a; a+=2; b-=5"); 
     testReparse("a = (2 + 3) * 4;"); 
     testReparse("a = 1 + (2 + 3) + 4;"); 
     testReparse("x = a ? b : c; x = a ? (b,3,5) : (foo(),bar());"); 
     testReparse("a = b | c


public void testGetCurrentNode342() { 
     Compiler compiler = new Compiler(); 
     ScopeCreator creator = new SyntacticScopeCreator(compiler, null); 
     ExpectNodeOnEnterScope callback = new ExpectNodeOnEnterScope(); 
     NodeTraversal t = new NodeTraversal(compiler, callback, creator); 
     String code = "" + "var a; " + "function foo() {" + "  var b;" + "}"; 
     Node tree = parse(compiler, code); 
     Scope topScope = creator.createScope(tree, null); 
     callback.expect(tree.getFirstChild(), tree); 
     t.traverseWithScope(tree.getFirstChild(), topScope); 
     callback.assertEntered(); 
     callback.expect(tree.getFirstChild(), tree.getFirstChild()); 
     t.traverse(tree.getFirstChild()); 
     callback.assertEntered(); 
     Node fn = tree.getFirstChild().getNext(); 
     Scope fnScope = creator.createScope(fn, topScope); 
     callback.expect(fn, fn); 
     t.traverseAtScope(fnScope); 
     callback.assertEntered(); 
 }


public void testGetCurrentNode343() { 
     Compiler compiler = new Compiler(); 
     ScopeCreator creator = new SyntacticScopeCreator(compiler, null); 
     ExpectNodeOnEnterScope callback = new ExpectNodeOnEnterScope(); 
     NodeTraversal t = new NodeTraversal(compiler, callback, creator); 
     String code = "" + "var a; " + "function foo() {" + "  var b;" + "}"; 
     Node tree = parse(compiler, code); 
     Scope topScope = creator.createScope(tree, null); 
     callback.expect(tree.getFirstChild(), tree); 
     t.traverseWith(tree.getFirstChild(), topScope); 
     callback.assertEntered(); 
     callback.expect(tree.getFirstChild(), tree.getFirstChild()); 
     t.traverse(tree.getFirstChild()); 
     callback.assertEntered(); 
     Node fn = tree.getFirstChild().getNext(); 
     Scope fnScope = creator.createScope(fn, topScope); 
     callback.expect(fn, fn); 
     t.traverseWith(fnScope); 
     callback.assertEntered(); 
 }


public void testUnexpectedException344() { 
     final String TEST_EXCEPTION = "test me"; 
     NodeTraversal.Callback cb = new NodeTraversal.AbstractPostOrderCallback() { 
  
         @Override 
         public void visit(NodeTraversal t, Node n, Node parent) { 
             throw new RuntimeException(TEST_EXCEPTION); 
         } 
     }; 
     Compiler compiler = new Compiler(); 
     NodeTraversal t = new NodeTraversal(compiler, cb); 
     String code = "function foo() {}"; 
     Node tree = parse(compiler, code); 
     try { 
         t.traverse(tree); 
         fail("Expected RuntimeException"); 
     } catch (RuntimeException e) { 
         assertTrue(e.getMessage().startsWith("INTERNAL COMPILER ERROR.\n" + "Please report this problem.\n" + "test me")); 
     } 
 }


public void testGetCurrentNode345() { 
     Compiler compiler = new Compiler(); 
     ScopeCreator creator = new SyntacticScopeCreator(compiler, null); 
     ExpectNodeOnEnterScope callback = new ExpectNodeOnEnterScope(); 
     NodeTraversal t = new NodeTraversal(compiler, callback, creator); 
     String code = "" + "var a; " + "function foo() {" + "  var b;" + "}"; 
     Node tree = parse(compiler, code); 
     Scope topScope = creator.createScope(tree, null); 
     callback.expect(tree.getFirstChild(), tree); 
     t.traverse(tree.getFirstChild()); 
     callback.assertEntered(); 
     callback.expect(tree.getFirstChild(), tree.getFirstChild()); 
     t.traverse(tree.getFirstChild()); 
     callback.assertEntered(); 
     Node fn = tree.getFirstChild().getNext(); 
     Scope fnScope = creator.createScope(fn, topScope); 
     callback.expect(fn, fn); 
     t.traverse(fnScope); 
     callback.assertEntered(); 
 }

  

  

  /**
   * Concrete implementation of AbstractPrunedCallback to test the
   * AbstractNodeTypePruningCallback shouldTraverse method.
   */
  static class PruningCallback extends AbstractNodeTypePruningCallback {
    public PruningCallback(Set<Integer> nodeTypes, boolean include) {
      super(nodeTypes, include);
    }

    @Override
    public void visit(NodeTraversal t, Node n, Node parent) {
      throw new UnsupportedOperationException();
    }
  }

  

  


  

  


  // Helper class used to test getCurrentNode
  private static class ExpectNodeOnEnterScope implements
      NodeTraversal.ScopedCallback {
    private Node node;
    private Node scopeRoot;
    private boolean entered = false;

    private void expect(Node node, Node scopeRoot) {
      this.node = node;
      this.scopeRoot = scopeRoot;
      entered = false;
    }

    private void assertEntered() {
      assertTrue(entered);
    }

    @Override
    public void enterScope(NodeTraversal t) {
      assertEquals(node, t.getCurrentNode());
      assertEquals(scopeRoot, t.getScopeRoot());
      entered = true;
    }

    @Override
    public void exitScope(NodeTraversal t) {
    }

    @Override
    public boolean shouldTraverse(NodeTraversal t, Node n, Node parent) {
      return true;
    }

    @Override
    public void visit(NodeTraversal t, Node n, Node parent) {
    }
  }

  private static Node parse(Compiler compiler, String js) {
    Node n = compiler.parseTestCode(js);
    assertEquals(0, compiler.getErrorCount());
    return n;
  }
}
