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

public void testNoInlineIntoNestedNamedFunctions530() { 
     testSame("f(); var x = false; function f() { if (false) { alert(x); } };"); 
 }
public void testDoNotEnterSubscope804() { 
     testSame("var x = function() {" + "  var self = this; " + "  return function() { var y = self; };" + "}"); 
     testSame("var x = function() {" + "  var y = [1]; " + "  return function() { var z = y; };" + "}"); 
 }
public void testInlineAcrossModules805() { 
     test(createModules("var a = 2;", "var b = a;"), new String[] { "", "var b = 2;" }); 
 }
public void testInlineVariablesConstants806() { 
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
public void testInsideIfConditional807() { 
     test("var a = foo(); if (a) { alert(3); }", "if (foo()) { alert(3); }"); 
     test("var a; a = foo(); if (a) { alert(3); }", "if (foo()) { alert(3); }"); 
 }
public void testInlineCatchAlias2808() { 
     test("try {" + "} catch (e) {" + "  var y; y = e;" + "  g();" + "  y;y;" + "}", "try {" + "} catch (e) {" + "  e;" + "  g();" + "  e;e;" + "}"); 
 }
  

  

  

  

  

  

  

  

  

  

  

  

  

  

  


  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  // Test movement of constant values

  

  


  // Test tricky declarations and references

  

  

  // Test movement of values that have (may) side effects

  

  


  // Test movement of values that are complex but lack side effects

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  // Make sure that we still inline constants that are not provably
  // written before they're read.
  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  
}
