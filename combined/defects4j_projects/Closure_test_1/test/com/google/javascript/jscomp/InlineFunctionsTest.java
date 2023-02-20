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


/**
 * Inline function tests.
 * @author johnlenz@google.com (john lenz)
 */
public class InlineFunctionsTest extends CompilerTestCase {
  boolean allowGlobalFunctionInlining = true;
  boolean allowBlockInlining = true;
  final boolean allowExpressionDecomposition = true;
  final boolean allowFunctionExpressionInlining = true;
  final boolean allowLocalFunctionInlining = true;
  boolean assumeStrictThis = false;
  boolean assumeMinimumCapture = false;

  public InlineFunctionsTest() {
    this.enableNormalize();
    this.enableMarkNoSideEffects();
  }

  @Override
  protected void setUp() throws Exception {
    super.setUp();
    super.enableLineNumberCheck(true);
    allowGlobalFunctionInlining = true;
    allowBlockInlining = true;
    assumeStrictThis = false;
    assumeMinimumCapture = false;
  }

  @Override
  protected CompilerPass getProcessor(Compiler compiler) {
    compiler.resetUniqueNameId();
    return new InlineFunctions(
        compiler,
        compiler.getUniqueNameIdSupplier(),
        allowGlobalFunctionInlining,
        allowLocalFunctionInlining,
        allowBlockInlining,
        assumeStrictThis,
        assumeMinimumCapture);
  }

  /**
   * Returns the number of times the pass should be run before results are
   * verified.
   */
  @Override
  protected int getNumRepetitions() {
    // Some inlining can only be done in multiple passes.
    return 3;
  }

public void testInlineWithThis638() { 
     assumeStrictThis = false; 
     testSame("function f(){this} f.call(new g);"); 
     assumeStrictThis = true; 
     test("function f(){this} f.call(new g);", "{var JSCompiler_inline_this_0=new g;JSCompiler_inline_this_0}"); 
 }
public void testFor327() { 
     test("a = 0; for(; a < 2 ; a++) foo()", "for(a = 0; a < 2 ; a++) foo();"); 
     test("var a = 0; for(; c < b ; c++) foo()", "for(var a = 0; c < b ; c++) foo()"); 
     testSame("var a = 0; a:for(; c < b ; c++) foo()"); 
     testSame("var a = 0; a:b:for(; c < b ; c++) foo()"); 
     test("if(x){var a = 0; for(; c < b; c++) foo()}", "if(x){for(var a = 0; c < b; c++) foo()}"); 
     test("init(); for(; a < 2 ; a++) foo()", "for(init(); a < 2 ; a++) foo();"); 
     test("function f(){ var a; for(; a < 2 ; a++) foo() }", "function f(){ for(var a; a < 2 ; a++) foo() }"); 
     testSame("function f(){ return; for(; a < 2 ; a++) foo() }"); 
 }
public void testMutableValues1562() { 
     test("function foo(p1) {} foo()", "function foo() {var p1} foo()"); 
     test("function foo(p1) {} foo(1)", "function foo() {var p1=1} foo()"); 
     test("function foo(p1) {} foo([])", "function foo() {var p1=[]} foo()"); 
     test("function foo(p1) {} foo({})", "function foo() {var p1={}} foo()"); 
     test("var x;function foo(p1) {} foo(x)", "var x;function foo() {var p1=x} foo()"); 
     test("var x;function foo(p1) {} foo(x())", "var x;function foo() {var p1=x()} foo()"); 
     test("var x;function foo(p1) {} foo(new x())", "var x;function foo() {var p1=new x()} foo()"); 
     test("var x;function foo(p1) {} foo('' + x)", "var x;function foo() {var p1='' + x} foo()"); 
     testSame("function foo(p1) {} foo(this)"); 
     testSame("function foo(p1) {} foo(arguments)"); 
     testSame("function foo(p1) {} foo(function(){})"); 
     testSame("function foo(p1) {} (function () {var x;foo(x)})()"); 
 }
public void testFunctionExpressionCallInlining2675() { 
     test("(function(){foo(this)}).call(this)", "{foo(this)}"); 
 }
public void testInlineFunctions9721() { 
     test("function INC(x){return x++}" + "var y=INC(i)", "var y;{var x$$inline_0=i;" + "y=x$$inline_0++}"); 
 }
public void testIssue728722() { 
     String f = "var f = function() { return false; };"; 
     StringBuilder calls = new StringBuilder(); 
     StringBuilder folded = new StringBuilder(); 
     for (int i = 0; i < 30; i++) { 
         calls.append("if (!f()) alert('x');"); 
         folded.append("if (!false) alert('x');"); 
     } 
     test(f + calls, folded.toString()); 
 }
public void testCostBasedInliningComplex4724() { 
     testSame("function foo(a,b){a+b+a+b}" + "var b=foo;" + "function _t1(){foo(1,2)}" + "function _t2(){foo(2,3)}"); 
 }
public void testShadowVariables5725() { 
     allowBlockInlining = false; 
     testSame("var a=0;" + "function foo(){var a=4;return 3+a}" + "function _bar(a){a=foo(4)+a}"); 
 }
public void testReplacePropertyFunction726() { 
     test("function f(x) {return x} " + "foo(window, f); f(1)", "function f(x) {return x} " + "foo(window, f); 1"); 
     testSame("function f(x) {return x} " + "new JSCompiler_ObjectPropertyString(window, f); 1"); 
 }
public void testComplexInlineInExpresssions3728() { 
     test("function f(){a()}c=z=f()", "var JSCompiler_inline_result$$0;" + "{a();JSCompiler_inline_result$$0=void 0;}" + "c=z=JSCompiler_inline_result$$0"); 
 }
public void testInlineWithRegularFunctions729() { 
     JSModule[] modules = createModuleStar("function A() {alert(B());A()}" + "function B() {return 6}" + "A();", "B = function() {return 7};" + "A();"); 
     test(modules, new String[] { "function A() {alert(6);A()}" + "A();" + "var B;", "A = function() {alert(B());A()};" + "B = function() {return 6};" + "B = function() {return 7};" + "A();" }); 
 }
  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  // Test redefinition of parameter name.
  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  // http://en.wikipedia.org/wiki/Fixed_point_combinator#Y_combinator
  

  

  

  

  

  

  

  private static class StringCompare extends CompilerTestCase {
    private boolean allowGlobalFunctionInlining = true;

    StringCompare() {
      super("", false);
      this.enableNormalize();
      this.enableMarkNoSideEffects();
    }

    @Override
    public void setUp() throws Exception {
      super.setUp();
      super.enableLineNumberCheck(true);
      allowGlobalFunctionInlining = true;
    }

    @Override
    protected CompilerPass getProcessor(Compiler compiler) {
      compiler.resetUniqueNameId();
      return new InlineFunctions(
          compiler,
          compiler.getUniqueNameIdSupplier(),
          allowGlobalFunctionInlining,
          true,  // allowLocalFunctionInlining
          true,  // allowBlockInlining
          true,  // assumeStrictThis
          true); // assumeMinimumCapture
    }

    
  }

  

  

  

  

  

  


  

  

  // Inline a single reference function into deeper modules
  

  // Inline a single reference function into shallow modules, only if it
  // is cheaper than the call itself.
  

  // Inline a multi-reference functions into shallow modules, only if it
  // is cheaper than the call itself.
  
  
  

}
