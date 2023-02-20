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

import com.google.javascript.rhino.Node;

/**
 * Tests for {@link DeadAssignmentsElimination}.
 *
 */
public class DeadAssignmentsEliminationTest extends CompilerTestCase {

  public DeadAssignmentsEliminationTest() {
    super("var extern;");
  }

  @Override
  public void setUp() {
    super.enableLineNumberCheck(true);
  }

  @Override
  public CompilerPass getProcessor(final Compiler compiler) {
    return new CompilerPass() {
      @Override
      public void process(Node externs, Node js) {
        NodeTraversal.traverse(
            compiler, js, new DeadAssignmentsElimination(compiler));
      }
    };
  }

  @Override
  protected int getNumRepetitions() {
    return 1;
  }

public void testForIn335() { 
     inFunction("var x = {}; for (var y in x) { y() }"); 
     inFunction("var x, y, z; x = {}; z = {}; for (y in x = z) { y() }", "var x, y, z;   ({}); z = {}; for (y in z)     { y() }"); 
     inFunction("var x, y, z; x = {}; z = {}; for (y[z=1] in z) { y() }", "var x, y, z;   ({}); z = {}; for (y[z=1] in z) { y() }"); 
     inFunction("var x, y, z; x = {}; z = {}; for (x in z) { x() }"); 
 }
public void testIssue297g336() { 
     test("function f(a) {" + " var b = h((b=1) - (b = g(b)));" + " return b;" + "};", "function f(a) {" + " var b = h((b=1) - (b = g(b)));" + " return b;" + "};"); 
 }
public void testMultiPaths765() { 
     inFunction("var x,y; if(x)y=1;", "var x,y; if(x)1;"); 
     inFunction("var x,y; if(x)y=1; y=2; x(y)", "var x,y; if(x)1; y=2; x(y)"); 
     inFunction("var x; switch(x) { case(1): x=1; break; } x"); 
     inFunction("var x; switch(x) { case(1): x=1; break; }", "var x; switch(x) { case(1): 1; break; }"); 
 }
public void testIssue297b766() { 
     test("function f() {" + " var x;" + " return (x='') && (x = x.substr(1));" + "};", "function f() {" + " var x;" + " return (x='') && (x.substr(1));" + "};"); 
 }
public void testIssue384b767() { 
     inFunction(" var a, b;\n" + " (f(b = true) || f(b = false)) ? (a = b) : (a = null);\n" + " return a;"); 
 }
public void testIssue297a768() { 
     testSame("function f(p) {" + " var x;" + " return ((x=p.id) && (x=parseInt(x.substr(1))) && x>0);" + "}; f('');"); 
 }
  

  

  

  

  

  

  

  

  /**
   * BUG #1358904
   */
  

  

  

  

  

  

  

  

  

  

  

  

  

  

  


  

  

  

  

  

  

  

  private void inFunction(String src) {
    inFunction(src, src);
  }

  private void inFunction(String src, String expected) {
    test("function FUNC(param1, param2){" + src + "}",
         "function FUNC(param1, param2){" + expected + "}");
  }

  

  

  

  

  

  

  

  

  

  


  

  

  

  

  

  

  
}
