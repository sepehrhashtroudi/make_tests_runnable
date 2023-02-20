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
 * @author johnlenz@google.com (John Lenz)
 */
public class MinimizeExitPointsTest extends CompilerTestCase {

  @Override
  public void setUp() {
    super.enableLineNumberCheck(true);
  }

  @Override
  protected CompilerPass getProcessor(final Compiler compiler) {
    return new CompilerPass() {
      @Override
      public void process(Node externs, Node js) {
        NodeTraversal.traverse(compiler, js, new MinimizeExitPoints(compiler));
      }
    };
  }

  @Override
  protected int getNumRepetitions() {
    return 1;
  }

  void foldSame(String js) {
    testSame(js);
  }

  void fold(String js, String expected) {
    test(js, expected);
  }

  void fold(String js, String expected, DiagnosticType warning) {
    test(js, expected, warning);
  }

public void testMinimizeForCondition213() { 
     fold("for(;!!true;) foo()", "for(;1;) foo()"); 
     fold("for(!!true;;) foo()", "for(!0;;) foo()"); 
     fold("for(;!!x;) foo()", "for(;x;) foo()"); 
     foldSame("for(a in b) foo()"); 
     foldSame("for(a in {}) foo()"); 
     foldSame("for(a in []) foo()"); 
     fold("for(a in !!true) foo()", "for(a in !0) foo()"); 
 }
public void testCodeMotionDoesntBreakFunctionHoisting216() throws Exception { 
     fold("function f() { if (x) return; foo(); function foo() {} }", "function f() { if (x); else { function foo() {} foo(); } }"); 
 }
public void testDenormalize542() { 
     testSame("startMarker();for(;;);endMarker()"); 
 }
  

  

  

  

  

  
}
