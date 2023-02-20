/*
 * Copyright 2006 The Closure Compiler Authors.
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

/**
 * Tests for {@link NameAnalyzer}
 *
 */
public class NameAnalyzerTest extends CompilerTestCase {

  private static String kExterns =
      "var window, top;" +
      "var document;" +
      "var Function;" +
      "var Array;" +
      "var externfoo; methods.externfoo;";

  public NameAnalyzerTest() {
    super(kExterns);
  }

  @Override
  protected void setUp() {
    super.enableNormalize();
    super.enableLineNumberCheck(true);
  }

  @Override
  protected int getNumRepetitions() {
    // pass reaches steady state after 1 iteration.
    return 1;
  }

public void testAssignWithHook8329() { 
     test("function Foo(){} var foo = null;" + "var f = window.a ? new Foo() : foo;", "function Foo(){}" + "window.a && new Foo()"); 
 }
public void testAliasInstanceof5619() { 
     test("function Foo() {}" + "function Bar() {}" + "var b = x ? Foo : Bar;" + "var y = new Foo();" + "if (y instanceof b) {}", "function Foo() {}" + "var y = new Foo;" + "if (false){}"); 
 }
public void testRefChain16620() { 
     testSame("function f(){}var a = 1; var b = a; var c = f(); c[b] ? g() : 0"); 
 }
public void testSetterInForStruct15621() { 
     test("var Class = function() {}; " + "for (var i = 1; Class.property_ = 0; i = 2);", "for (; 0;);"); 
 }
public void testSetterInDoWhilePredicate622() { 
     testSame("var a = 1;" + "var Class = function() {}; " + "do {} while(Class.property_ = a);"); 
 }
public void testSetterInForStruct8623() { 
     test("var i = 0, j = 0, k = 0; for (i = 1, j = i, k = 2; i = 0;);", "var i = 0; for(i = 1, i , 2; i = 0;);"); 
 }
public void testNestedAssign2624() { 
     test("var a, b = a = 1; foo(b)", "var b = 1; foo(b)"); 
 }
public void testGetElem3625() { 
     testSame("var foo = {'i': 0, 'j': 1}; foo['k'] = 2; top.foo = foo;"); 
 }
public void testIssue284627() { 
     test("var goog = {};" + "goog.inherits = function(x, y) {};" + "var ns = {};" + "/** @constructor */" + "ns.PageSelectionModel = function() {};" + "/** @constructor */" + "ns.PageSelectionModel.FooEvent = function() {};" + "/** @constructor */" + "ns.PageSelectionModel.SelectEvent = function() {};" + "goog.inherits(ns.PageSelectionModel.ChangeEvent," + "    ns.PageSelectionModel.FooEvent);", ""); 
 }
public void testConditionallyDefinedFunction1628() { 
     testSame("var g; externfoo.x || (externfoo.x = function() { g; })"); 
 }
public void testIf2629() { 
     test("var e = false;var foo = {};if(e)foo.bar=function(){};", "var e = false;if(e);"); 
 }
public void testIf5630() { 
     test("var e = false;var foo = {};if(e)foo.bar=function(){};", "var e = false;if(e);"); 
 }
  

  

  

  

  

  

  

  


  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  


  

  

  

  

  

  


  

  

  

  

  

  /**
   * Expressions that cannot be attributed to any enclosing dependency
   * scope should be treated as global references.
   * @bug 1739062
   */
  

  

  

  

  /**
   * Do not "prototype" property of variables that are not being
   * tracked (because they are local).
   * @bug 1809442
   */
  

  

  

  

  

  

  

  

  

  

  

  

  

 

  

  

  

  

  

  

  

  

  



  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  // We cannot leave x.a.prototype there because it will
  // fail sanity var check.
  

  

  

  

  


  

  

  

  

  

  

  @Override
  protected CompilerPass getProcessor(Compiler compiler) {
    return new MarkNoSideEffectCallsAndNameAnalyzerRunner(compiler);
  }

  private class MarkNoSideEffectCallsAndNameAnalyzerRunner
      implements CompilerPass {
    MarkNoSideEffectCalls markNoSideEffectCalls;
    NameAnalyzer analyzer;
    MarkNoSideEffectCallsAndNameAnalyzerRunner(Compiler compiler) {
      this.markNoSideEffectCalls = new MarkNoSideEffectCalls(compiler);
      this.analyzer = new NameAnalyzer(compiler, true);
    }

    @Override
    public void process(Node externs, Node root) {
      markNoSideEffectCalls.process(externs, root);
      analyzer.process(externs, root);
    }
  }
}
