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
import com.google.javascript.jscomp.DefinitionsRemover.Definition;
import com.google.javascript.jscomp.NodeTraversal.AbstractPostOrderCallback;
import com.google.javascript.rhino.Node;

import java.util.List;

/**
 * Test for {@link DefinitionsRemover}. Basically test for the simple removal
 * cases. More complicated cases will be tested by the clients of
 * {@link DefinitionsRemover}.
 *
 */
public class DefinitionsRemoverTest extends CompilerTestCase {
public void testRemoveAssignment719() { 
     test("x = 0;", "0"); 
     test("{x = 0}", "{0}"); 
     test("x = 0; y = 0;", "0; 0;"); 
     test("for (x = 0;x;x) {};", "for(0;x;x) {};"); 
 }
public void testRemoveLiteral721() { 
     test("foo({ 'one' : 1 })", "foo({ })"); 
     test("foo({ 'one' : 1 , 'two' : 2 })", "foo({ })"); 
 }
public void testRemoveFunction723() { 
     test("function foo(p1) { } foo(); foo()", "function foo() {var p1;} foo(); foo()"); 
     test("function foo(p1) { } foo(1); foo(1)", "function foo() {var p1 = 1;} foo(); foo()"); 
     test("function foo(p1) { } foo(1,2); foo(1,4)", "function foo() {var p1 = 1;} foo(2); foo(4)"); 
 }
  

  

  

  

  

  @Override
  protected CompilerPass getProcessor(final Compiler compiler) {
    // Create a pass that removes all the definitions.
    return new CompilerPass() {
      @Override
      public void process(Node externs, Node root) {
        DefinitionsGatherer g = new DefinitionsGatherer();
        (new NodeTraversal(compiler, g)).traverse(root);
        for (Definition def : g.definitions) {
          def.remove();
          compiler.reportCodeChange();
        }
      }
    };
  }

  /**
   * Gather all possible definition objects.
   */
  private static class DefinitionsGatherer extends AbstractPostOrderCallback {
    final List<Definition> definitions = Lists.newArrayList();
    @Override
    public void visit(NodeTraversal t, Node n, Node parent) {
      Definition def = DefinitionsRemover.getDefinition(n, false);
      if (def != null) {
        definitions.add(def);
      }
    }
  }
}
