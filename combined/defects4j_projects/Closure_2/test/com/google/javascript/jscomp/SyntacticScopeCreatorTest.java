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

import com.google.javascript.rhino.Node;
import com.google.javascript.rhino.Token;

import junit.framework.TestCase;

/**
 * Tests for {@link SyntacticScopeCreator}.
 *
 */
public class SyntacticScopeCreatorTest extends TestCase {

  /**
   * Helper to create a top-level scope from a JavaScript string
   */
  private static Scope getScope(String js) {
    Compiler compiler = new Compiler();
    Node root = compiler.parseTestCode(js);
    assertEquals(0, compiler.getErrorCount());
    Scope scope =
        new SyntacticScopeCreator(compiler).createScope(root, null);
    return scope;
  }

  /**
   * Helper to traverse the tree creating the Scope object everywhere.
   */
  private static void testScopes(String js, int errorCount) {
    Compiler compiler = new Compiler();
    Node root = compiler.parseTestCode(js);
    NodeTraversal.traverse(
        compiler, root, new NodeTraversal.AbstractPostOrderCallback() {
          @Override
          public
          void visit(NodeTraversal t, Node n, Node parent) {
            t.getScope();
          }
        });
    assertEquals(errorCount, compiler.getErrorCount());
  }

public void testScopeRootNode399() { 
     String js = "function foo() {\n" + " var x = 10;" + "}"; 
     Compiler compiler = new Compiler(); 
     Node root = compiler.parseTestCode(js); 
     assertEquals(0, compiler.getErrorCount()); 
     Scope globalScope = new SyntacticScopeCreator(compiler).createScope(root, null); 
     assertEquals(root, globalScope.getRootNode()); 
     Node fooNode = root.getFirstChild(); 
     assertEquals(Token.FUNCTION, fooNode.getType()); 
     Scope fooScope = new SyntacticScopeCreator(compiler).createScope(fooNode, null); 
     assertEquals(fooNode, fooScope.getRootNode()); 
     assertTrue(fooScope.isDeclared("x", false)); 
 }
public void testRedeclaration1400() { 
     String js = "var a; var a;"; 
     int errors = createGlobalScopeHelper(js); 
     assertEquals(1, errors); 
 }
  

  

  

  

  


  

  /**
   * Parse the supplied JS and create the global SyntaticScope object.
   * @return The error count.
   */
  private int createGlobalScopeHelper(String js) {
    Compiler compiler = new Compiler();
    CompilerOptions options = new CompilerOptions();
    options.checkSymbols = true;
    compiler.initOptions(options);

    Node root = compiler.parseTestCode(js);
    assertEquals(0, compiler.getErrorCount());
    Scope globalScope =
      new SyntacticScopeCreator(compiler).createScope(root, null);
    assertEquals(root, globalScope.getRootNode());
    return compiler.getErrorCount();
  }
}
