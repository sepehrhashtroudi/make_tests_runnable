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
import com.google.common.collect.Sets;
import com.google.javascript.jscomp.NodeTraversal.AbstractPostOrderCallback;
import com.google.javascript.rhino.Node;

import java.util.Set;

/**
 * @author johnlenz@google.com (John Lenz)
 *
 */
public class NormalizeTest extends CompilerTestCase {

  private static final String EXTERNS = "var window;";

  public NormalizeTest() {
    super(EXTERNS);
    super.enableLineNumberCheck(true);
  }

  @Override
  public CompilerPass getProcessor(final Compiler compiler) {
    return new Normalize(compiler, false);
  }

  @Override
  protected int getNumRepetitions() {
    // The normalize pass is only run once.
    return 1;
  }

public void testFor226() { 
     test("for(a = 0; a < 2 ; a++) foo();", "a = 0; for(; a < 2 ; a++) foo()"); 
     test("for(var a = 0; c < b ; c++) foo()", "var a = 0; for(; c < b ; c++) foo()"); 
     test("a:for(var a = 0; c < b ; c++) foo()", "var a = 0; a:for(; c < b ; c++) foo()"); 
     test("a:b:for(var a = 0; c < b ; c++) foo()", "var a = 0; a:b:for(; c < b ; c++) foo()"); 
     test("if(x) for(var a = 0; c < b ; c++) foo()", "if(x){var a = 0; for(; c < b ; c++) foo()}"); 
     test("for(init(); a < 2 ; a++) foo();", "init(); for(; a < 2 ; a++) foo()"); 
 }
public void testExposeComplex227() { 
     test("var x = {/** @expose */ a: 1, b: 2};" + "x.a = 3; /** @expose */ x.b = 5;", "var x = {'a': 1, 'b': 2};" + "x['a'] = 3; x['b'] = 5;"); 
 }
public void testIssue166d228() { 
     test("function a() {" + "var e = 0; try { throw 1 } catch(e) {" + "/** @suppress {duplicate} */ var e=2 }" + "};", "function a() {" + "var e = 0; try { throw 1 } catch(e) { var e=2 }" + "}", Normalize.CATCH_BLOCK_VAR_ERROR); 
 }
public void testMakeLocalNamesUnique229() { 
     if (!Normalize.MAKE_LOCAL_NAMES_UNIQUE) { 
         return; 
     } 
     testSame("var a;"); 
     testSame("a;"); 
     test("var a;function foo(a){var b;a}", "var a;function foo(a$$1){var b;a$$1}"); 
     test("var a;function foo(){var b;a}function boo(){var b;a}", "var a;function foo(){var b;a}function boo(){var b$$1;a}"); 
     test("function foo(a){var b}" + "function boo(a){var b}", "function foo(a){var b}" + "function boo(a$$1){var b$$1}"); 
     test("var a = function foo(){foo()};var b = function foo(){foo()};", "var a = function foo(){foo()};var b = function foo$$1(){foo$$1()};"); 
     test("try { } catch(e) {e;}", "try { } catch(e) {e;}"); 
     test("try { } catch(e) {e;}; try { } catch(e) {e;}", "try { } catch(e) {e;}; try { } catch(e$$1) {e$$1;}"); 
     test("try { } catch(e) {e; try { } catch(e) {e;}};", "try { } catch(e) {e; try { } catch(e$$1) {e$$1;} }; "); 
     test("/** @suppress {duplicate} */\nvar window;", "var window;"); 
     test("function f() {var window}", "function f() {var window$$1}"); 
 }
public void testIssue230() { 
     super.allowExternsChanges(true); 
     test("var a,b,c; var a,b", "a(), b()", "a(), b()", null, null); 
 }
public void testRemoveDuplicateVarDeclarations3231() { 
     test("var f = 1; function f(){}", "f = 1; function f(){}"); 
     test("var f; function f(){}", "function f(){}"); 
     test("if (a) { var f = 1; } else { function f(){} }", "if (a) { var f = 1; } else { f = function (){} }"); 
     test("function f(){} var f = 1;", "function f(){} f = 1;"); 
     test("function f(){} var f;", "function f(){}"); 
     test("if (a) { function f(){} } else { var f = 1; }", "if (a) { var f = function (){} } else { f = 1; }"); 
     test("function f(){} function f(){}", "function f(){} function f(){}", SyntacticScopeCreator.VAR_MULTIPLY_DECLARED_ERROR); 
     test("if (a) { function f(){} } else { function f(){} }", "if (a) { var f = function (){} } else { f = function (){} }"); 
 }
  

  

  

  

  

  

  

  

  

  private String inFunction(String code) {
    return "(function(){" + code + "})";
  }

  private void testSameInFunction(String code) {
    testSame(inFunction(code));
  }

  private void testInFunction(String code, String expected) {
    test(inFunction(code), inFunction(expected));
  }

  


  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  private Set<Node> findNodesWithProperty(Node root, final int prop) {
    final Set<Node> set = Sets.newHashSet();
    NodeTraversal.traverse(
        getLastCompiler(), root, new AbstractPostOrderCallback() {
        @Override
        public void visit(NodeTraversal t, Node node, Node parent) {
          if (node.getBooleanProp(prop)) {
            set.add(node);
          }
        }
      });
    return set;
  }

  

  private class WithCollapse extends CompilerTestCase {
    WithCollapse() {
      enableNormalize();
    }

    private void testConstantProperties() {
      test("var a={}; a.ACONST = 4;var b = a.ACONST;",
           "var a$ACONST = 4; var b = a$ACONST;");

      test("var a={b:{}}; a.b.ACONST = 4;var b = a.b.ACONST;",
           "var a$b$ACONST = 4;var b = a$b$ACONST;");

      test("var a = {FOO: 1};var b = a.FOO;",
           "var a$FOO = 1; var b = a$FOO;");

      test("var EXTERN; var ext; ext.FOO;", "var b = EXTERN; var c = ext.FOO",
           "var b = EXTERN; var c = ext.FOO", null, null);

      test("var a={}; a.ACONST = 4; var b = a.ACONST;",
           "var a$ACONST = 4; var b = a$ACONST;");

      test("var a = {}; function foo() { var d = a.CONST; };" +
           "(function(){a.CONST=4})();",
           "var a$CONST;function foo(){var d = a$CONST;};" +
           "(function(){a$CONST = 4})();");

      test("var a = {}; a.ACONST = new Foo(); var b = a.ACONST;",
           "var a$ACONST = new Foo(); var b = a$ACONST;");
    }

    @Override
    protected int getNumRepetitions() {
      // The normalize pass is only run once.
      return 1;
    }

    @Override
    public CompilerPass getProcessor(final Compiler compiler) {
      return new CompilerPass() {
        @Override
        public void process(Node externs, Node root) {
          new CollapseProperties(compiler, false, true).process(externs, root);
        }
      };
    }
  }
}
