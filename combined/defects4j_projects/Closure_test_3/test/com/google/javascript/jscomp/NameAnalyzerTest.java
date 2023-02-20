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

public void testAliasInstanceof5596() { 
     test("function Foo() {}" + "function Bar() {}" + "var b = x ? Foo : Bar;" + "var y = new Foo();" + "if (y instanceof b) {}", "function Foo() {}" + "var y = new Foo;" + "if (false){}"); 
 }
public void testRemoveDeclaration4597() { 
     testSame("var a,b,c; c = a = b = {}; a.x = 1;alert(c.x);"); 
 }
public void testSetterInForStruct8598() { 
     test("var i = 0, j = 0, k = 0; for (i = 1, j = i, k = 2; i = 0;);", "var i = 0; for(i = 1, i , 2; i = 0;);"); 
 }
public void testNoRemoveWindowPropertyAlias3599() { 
     testSame("var self_ = window;\n" + "self_['qs'] = function() {};"); 
 }
public void testIf2600() { 
     test("var e = false;var foo = {};if(e)foo.bar=function(){};", "var e = false;if(e);"); 
 }
public void testSingletonGetter3601() { 
     testSame("function Foo() {} goog$addSingletonGetter(Foo);" + "this.x = Foo.getInstance();"); 
 }
public void testRefChain8602() { 
     test("var a = 1; var b = a; var c = b; var goog = {};" + "goog.mixin = function() {};" + "var d = goog.mixin(c.prototype, a.prototype) + " + "goog.mixin(b.prototype, a.prototype);" + "new b()", "var a = 1; var b = a; var goog = {};" + "goog.mixin = function() {};" + "goog.mixin(b.prototype, a.prototype);" + "new b()"); 
 }
public void testClassDefinedInObjectLit4603() { 
     test("var data = {};" + "data.baz = {bar: {Foo: function() {}}};" + "data.baz.bar.Foo.prototype.toString = function() {};", ""); 
 }
public void testUnintendedUseOfInheritsInLocalScope2604() { 
     testSame("goog.mixin = function() {}; " + "var x = {}; var y = {}; (function() { goog.mixin(x, y); })();"); 
 }
public void testRhsAssign5605() { 
     test("var a = 3, foo, bar; foo || (bar = a)", "var a = 3, foo; foo || a"); 
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
