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
 * Verifies that valid candidates for inlining are inlined, but
 * that no dangerous inlining occurs.
 *
 * @author kushal@google.com (Kushal Dave)
 */
public class InlineVariablesTest extends CompilerTestCase {

  private boolean inlineAllStrings = false;
  private boolean inlineLocalsOnly = false;

  public InlineVariablesTest() {
    enableNormalize();
  }

  @Override
  public void setUp() {
    super.enableLineNumberCheck(true);
  }

  @Override
  protected CompilerPass getProcessor(final Compiler compiler) {
    return new InlineVariables(
        compiler,
        (inlineLocalsOnly)
            ? InlineVariables.Mode.LOCALS_ONLY
            : InlineVariables.Mode.ALL,
        inlineAllStrings);
  }

  @Override
  public void tearDown() {
    inlineAllStrings = false;
    inlineLocalsOnly = false;
  }

  // Test respect for scopes and blocks

public void testImmutableWithSingleReferenceAfterInitialzation548() { 
     test("var a; a = 1;", "1;"); 
     test("var a; if (a = 1) { alert(3); }", "if (1) { alert(3); }"); 
     test("var a; switch (a = 1) {}", "switch(1) {}"); 
     test("var a; function f(){ return a = 1; }", "function f(){ return 1; }"); 
     test("function f(){ var a; return a = 1; }", "function f(){ return 1; }"); 
     test("var a; with (a = 1) { alert(3); }", "with (1) { alert(3); }"); 
     test("var a; b = (a = 1);", "b = 1;"); 
     test("var a; while(a = 1) { alert(3); }", "while(1) { alert(3); }"); 
     test("var a; for(;a = 1;) { alert(3); }", "for(;1;) { alert(3); }"); 
     test("var a; do {} while(a = 1) { alert(3); }", "do {} while(1) { alert(3); }"); 
 }
public void testDoNotCrossDelete549() { 
     testSame("var x = {}; var y = x.a; delete x.a; var z = y;"); 
 }
public void testDoNotOptimizeJSCompiler_ObjectPropertyString565() { 
     testSame("function JSCompiler_ObjectPropertyString(a, b) {return a[b]};" + "JSCompiler_renameProperty(window,'b');"); 
 }
public void testIssue378EscapedArguments3566() { 
     test("function g(callback) {\n" + "  var f = callback;\n" + "  f.apply(this, arguments);\n" + "}\n", "function g(callback) {\n" + "  callback.apply(this, arguments);\n" + "}\n"); 
 }
public void testDoNotEnterSubscope836() { 
     testSame("var x = function() {" + "  var self = this; " + "  return function() { var y = self; };" + "}"); 
     testSame("var x = function() {" + "  var y = [1]; " + "  return function() { var z = y; };" + "}"); 
 }
public void testInlineVariablesConstants837() { 
     test("var ABC=2; var x = ABC;", "var x=2"); 
     test("var AA = 'aa'; AA;", "'aa'"); 
     test("var A_A=10; A_A + A_A;", "10+10"); 
     test("var AA=1", ""); 
     test("var AA; AA=1", "1"); 
     test("var AA; if (false) AA=1; AA;", "if (false) 1; 1;"); 
     testSame("var AA; if (false) AA=1; else AA=2; AA;"); 
     test("var AA;(function () {AA=1})()", "(function () {1})()"); 
     testSame("var x = AA;"); 
     testSame("var AA = '1234567890'; foo(AA); foo(AA); foo(AA);"); 
     test("var AA = '123456789012345';AA;", "'123456789012345'"); 
 }
public void testOnlyReadAtInitialization838() { 
     test("var a; a = foo();", "foo();"); 
     test("var a; if (a = foo()) { alert(3); }", "if (foo()) { alert(3); }"); 
     test("var a; switch (a = foo()) {}", "switch(foo()) {}"); 
     test("var a; function f(){ return a = foo(); }", "function f(){ return foo(); }"); 
     test("function f(){ var a; return a = foo(); }", "function f(){ return foo(); }"); 
     test("var a; with (a = foo()) { alert(3); }", "with (foo()) { alert(3); }"); 
     test("var a; b = (a = foo());", "b = foo();"); 
     test("var a; while(a = foo()) { alert(3); }", "while(foo()) { alert(3); }"); 
     test("var a; for(;a = foo();) { alert(3); }", "for(;foo();) { alert(3); }"); 
     test("var a; do {} while(a = foo()) { alert(3); }", "do {} while(foo()) { alert(3); }"); 
 }
public void testInlineFunctionDeclaration839() { 
     test("var f = function () {}; var a = f;", "var a = function () {};"); 
     test("var f = function () {}; foo(); var a = f;", "foo(); var a = function () {};"); 
     test("var f = function () {}; foo(f);", "foo(function () {});"); 
     testSame("var f = function () {}; function g() {var a = f;}"); 
     testSame("var f = function () {}; function g() {h(f);}"); 
 }
public void testInsideIfConditional840() { 
     test("var a = foo(); if (a) { alert(3); }", "if (foo()) { alert(3); }"); 
     test("var a; a = foo(); if (a) { alert(3); }", "if (foo()) { alert(3); }"); 
 }
  

  

  

  

  

  

  

  

  

  

  

  

  

  

  


  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  // Test movement of constant values

  

  


  // Test tricky declarations and references

  

  

  // Test movement of values that have (may) side effects

  

  


  // Test movement of values that are complex but lack side effects

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  // Make sure that we still inline constants that are not provably
  // written before they're read.
  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  
}
