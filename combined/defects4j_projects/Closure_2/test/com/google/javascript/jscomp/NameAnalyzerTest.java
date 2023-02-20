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

public void testNoRemoveWindowPropertyAlias5a393() { 
     test("var self_; self_ = window || {};\n" + "self_['qs'] = function() {};", ""); 
 }
public void testStaticAndSubInstanceProperties550() { 
     String js = "" + "/** @constructor */ var Foo = function(){};\n" + "Foo.x=0;\n" + "/** @constructor \n @extends Foo */ var Bar = function(){};\n" + "goog.inherits(Bar, Foo);\n" + "Bar.y=0;\n" + "Bar.prototype.z=0;\n"; 
     String output = "" + "/** @constructor */ var Foo = function(){};\n" + "Foo.a=0;\n" + "/** @constructor \n @extends Foo */ var Bar = function(){};\n" + "goog.inherits(Bar, Foo);\n" + "Bar.a=0;\n" + "Bar.prototype.a=0;\n"; 
     test(js, output); 
 }
public void testNamespacedClass1580() { 
     test("var foo = {};foo.bar = {};foo.bar.prototype.baz = {}", ""); 
 }
public void testIssue284581() { 
     test("var goog = {};" + "goog.inherits = function(x, y) {};" + "var ns = {};" + "/** @constructor */" + "ns.PageSelectionModel = function() {};" + "/** @constructor */" + "ns.PageSelectionModel.FooEvent = function() {};" + "/** @constructor */" + "ns.PageSelectionModel.SelectEvent = function() {};" + "goog.inherits(ns.PageSelectionModel.ChangeEvent," + "    ns.PageSelectionModel.FooEvent);", ""); 
 }
public void testSetterInDoWhilePredicate582() { 
     testSame("var a = 1;" + "var Class = function() {}; " + "do {} while(Class.property_ = a);"); 
 }
public void testIssue838a583() { 
     testSame("var z = window['z'] || (window['z'] = {});\n" + "z['hello'] = 'Hello';\n" + "z['world'] = 'World';"); 
 }
public void testSetterInForIn3584() { 
     testSame("var foo = {}; var bar; for(e in bar = foo.a); bar.b = 3"); 
 }
public void testAliasInstanceof5585() { 
     test("function Foo() {}" + "function Bar() {}" + "var b = x ? Foo : Bar;" + "var y = new Foo();" + "if (y instanceof b) {}", "function Foo() {}" + "var y = new Foo;" + "if (false){}"); 
 }
public void testAssignWithHook8586() { 
     test("function Foo(){} var foo = null;" + "var f = window.a ? new Foo() : foo;", "function Foo(){}" + "window.a && new Foo()"); 
 }
public void testGetElem3587() { 
     testSame("var foo = {'i': 0, 'j': 1}; foo['k'] = 2; top.foo = foo;"); 
 }
public void testNamespacedClass3588() { 
     test("var a = {}; a.b = function() {}; a.b.prototype = {x: function() {}};", ""); 
 }
public void testAssignWithHook3589() { 
     testSame("function Foo(){} var foo = null; var f = {};" + "f.b = window.a ? " + "    function () {return new Foo()} : function () {return foo}; f.b()"); 
 }
public void testIssue389590() { 
     test("function alias() {}" + "var dojo = {};" + "dojo.gfx = {};" + "dojo.declare = function() {};" + "/** @constructor */" + "dojo.gfx.Shape = function() {};" + "dojo.gfx.Shape = dojo.declare('dojo.gfx.Shape');" + "alias(dojo);", "function alias() {}" + "var dojo = {};" + "dojo.gfx = {};" + "dojo.declare = function() {};" + "/** @constructor */" + "var dojo$gfx$Shape = function() {};" + "dojo$gfx$Shape = dojo.declare('dojo.gfx.Shape');" + "alias(dojo);", null, CollapseProperties.UNSAFE_NAMESPACE_WARNING); 
 }
public void testSetterInForStruct10591() { 
     test("var Class = function() {}; " + "for (var i = 1; Class.property_ = 0; i = 2);", "for (; 0;);"); 
 }
public void testNestedAssign2592() { 
     test("var a, b = a = 1; foo(b)", "var b = 1; foo(b)"); 
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
