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

import com.google.javascript.rhino.Node;

/**
 * Unit tests for {@link FlowSensitiveInlineVariables}.
 *
 */
public class FlowSensitiveInlineVariablesTest extends CompilerTestCase  {

  public static final String EXTERN_FUNCTIONS = "" +
      "var print;\n" +
      "/** @nosideeffects */ function noSFX() {} \n" +
      "                      function hasSFX() {} \n";

  public FlowSensitiveInlineVariablesTest() {
    enableNormalize(true);
  }

  @Override
  public int getNumRepetitions() {
    // Test repeatedly inline.
    return 3;
  }

  @Override
  protected CompilerPass getProcessor(final Compiler compiler) {
    //return new FlowSensitiveInlineVariables(compiler);
    return new CompilerPass() {
      @Override
      public void process(Node externs, Node root) {
        (new MarkNoSideEffectCalls(compiler)).process(externs, root);
        (new FlowSensitiveInlineVariables(compiler)).process(externs, root);
      }
    };
  }

public void testRemoveWithLabels5() { 
     inline("var x = 1; L: x = 2; print(x)", "var x = 1; L:{} print(2)"); 
     inline("var x = 1; L: M: x = 2; print(x)", "var x = 1; L:M:{} print(2)"); 
     inline("var x = 1; L: M: N: x = 2; print(x)", "var x = 1; L:M:N:{} print(2)"); 
 }
public void testDoNotInlineCatchExpression46() { 
     noInline("try {\n" + " stuff();\n" + "} catch (e) {\n" + " x = e;\n" + " print(x);\n" + "}"); 
 }
public void testIssue297g7() { 
     test("function f(a) {" + " var b = h((b=1) - (b = g(b)));" + " return b;" + "};", "function f(a) {" + " var b = h((b=1) - (b = g(b)));" + " return b;" + "};"); 
 }
public void testForIn8() { 
     noInline("var x; var y = {}; for(x in y){}"); 
     noInline("var x; var y = {}; var z; for(x in z = y){print(z)}"); 
     noInline("var x; var y = {}; var z; for(x in y){print(z)}"); 
 }
public void testNotOkToSkipCheckPathBetweenNodes188() { 
     noInline("var x; for(x = 1; foo(x);) {}"); 
     noInline("var x; for(; x = 1;foo(x)) {}"); 
 }
public void testCanInlineAcrossNoSideEffect643() { 
     noInline("var y; var x = noSFX(y), z = noSFX(); noSFX(); noSFX(), print(x)"); 
 }
  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  // TODO(user): These should be inlinable.
  

  // TODO(user): These should be inlinable.
  

  // TODO(user): These should be inlinable.
  

  // TODO(user): These should be inlinable after the REGEX checks.
  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  private void noInline(String input) {
    inline(input, input);
  }

  private void inline(String input, String expected) {
    test(EXTERN_FUNCTIONS, "function _func() {" + input + "}",
        "function _func() {" + expected + "}", null, null);
  }
}
