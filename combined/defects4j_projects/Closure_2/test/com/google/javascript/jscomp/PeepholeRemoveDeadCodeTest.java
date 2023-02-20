/*
 * Copyright 2004 The Closure Compiler Authors.
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
 * Tests for PeepholeRemoveDeadCodeTest in isolation. Tests for the interaction
 * of multiple peephole passes are in PeepholeIntegrationTest.
 */
public class PeepholeRemoveDeadCodeTest extends CompilerTestCase {

  private static final String MATH =
      "/** @const */ var Math = {};" +
      "/** @nosideeffects */ Math.random = function(){};" +
      "/** @nosideeffects */ Math.sin = function(){};";

  public PeepholeRemoveDeadCodeTest() {
    super(MATH);
  }

  @Override
  public void setUp() throws Exception {
    super.setUp();
    enableLineNumberCheck(true);
  }

  @Override
  public CompilerPass getProcessor(final Compiler compiler) {
    return new CompilerPass() {
      @Override
      public void process(Node externs, Node root) {
        SimpleDefinitionFinder definitionFinder =
            new SimpleDefinitionFinder(compiler);
        definitionFinder.process(externs, root);
        new PureFunctionIdentifier(compiler, definitionFinder)
            .process(externs, root);
        PeepholeOptimizationsPass peepholePass =
            new PeepholeOptimizationsPass(
                compiler, new PeepholeRemoveDeadCode());
        peepholePass.process(externs, root);
      }
    };
  }

  @Override
  protected int getNumRepetitions() {
    // Reduce this to 2 if we get better expression evaluators.
    return 2;
  }

  private void foldSame(String js) {
    testSame(js);
  }

  private void fold(String js, String expected) {
    test(js, expected);
  }

public void testFoldUselessWhile243() { 
     fold("while(false) { foo() }", ""); 
     fold("while(void 0) { foo() }", ""); 
     fold("while(undefined) { foo() }", ""); 
     foldSame("while(true) foo()"); 
     fold("while(false) { var a = 0; }", "var a"); 
     fold("while(false) { foo(); continue }", ""); 
     fold("while(0) { foo() }", ""); 
 }
public void testRemoveNamespaceGet2244() { 
     test("var a = {};a.b=1;a.b", "var a = {};a.b=1"); 
 }
public void testRemoveInControlStructure3246() { 
     test("for(1;2;3) 4", "for(;;);"); 
 }
public void testOptimizeTry247() { 
     fold("try{var a=1;}catch(ex){var b=2;}", "try{var a=1}catch(ex){var b=2}"); 
     fold("try{var a=1;var b=3;}", "var a=1;var b=3"); 
     fold("try{var a=1;var b=2}catch(ex){var c=3;}", "var a=1;var b=2;var c=3"); 
     foldSame("try{var a=1;var b=2}catch(ex){var c=3;var d=4;}finally{var e=5;" + "var f=6;}"); 
 }
public void testFoldTry248() { 
     fold("try{var a=1;}catch(ex){var b=2;}", "try{var a=1}catch(ex){var b=2}"); 
     fold("try{var a=1;var b=3;}", "var a=1;var b=3"); 
     fold("try{var a=1;var b=2}catch(ex){var c=3;}", "var a=1;var b=2;var c=3"); 
     foldSame("try{var a=1;var b=2}catch(ex){var c=3;var d=4;}finally{var e=5;" + "var f=6;}"); 
 }
public void testConstantConditionWithSideEffect1249() { 
     fold("if (b=true) x=1;", "b=true;x=1"); 
     fold("if (b=/ab/) x=1;", "b=/ab/;x=1"); 
     fold("if (b=/ab/){ x=1; } else { x=2; }", "b=/ab/;x=1"); 
     fold("var b;b=/ab/;if(b)x=1;", "var b;b=/ab/;x=1"); 
     foldSame("var b;b=f();if(b)x=1;"); 
     fold("var b=/ab/;if(b)x=1;", "var b=/ab/;x=1"); 
     foldSame("var b=f();if(b)x=1;"); 
     foldSame("b=b++;if(b)x=b;"); 
     fold("(b=0,b=1);if(b)x=b;", "b=0,b=1;if(b)x=b;"); 
     fold("b=1;if(foo,b)x=b;", "b=1;x=b;"); 
     foldSame("b=1;if(foo=1,b)x=b;"); 
 }
public void testFoldBlock250() { 
     fold("{{foo()}}", "foo()"); 
     fold("{foo();{}}", "foo()"); 
     fold("{{foo()}{}}", "foo()"); 
     fold("{{foo()}{bar()}}", "foo();bar()"); 
     fold("{if(false)foo(); {bar()}}", "bar()"); 
     fold("{if(false)if(false)if(false)foo(); {bar()}}", "bar()"); 
     fold("{'hi'}", ""); 
     fold("{x==3}", ""); 
     fold("{ (function(){x++}) }", ""); 
     fold("function f(){return;}", "function f(){return;}"); 
     fold("function f(){return 3;}", "function f(){return 3}"); 
     fold("function f(){if(x)return; x=3; return; }", "function f(){if(x)return; x=3; return; }"); 
     fold("{x=3;;;y=2;;;}", "x=3;y=2"); 
     fold("while(x()){x}", "while(x());"); 
     fold("while(x()){x()}", "while(x())x()"); 
     fold("for(x=0;x<100;x++){x}", "for(x=0;x<100;x++);"); 
     fold("for(x in y){x}", "for(x in y);"); 
 }
public void testRemoveFromLabel1252() { 
     test("LBL: void 0", "LBL: {}"); 
 }
public void testFoldUselessFor253() { 
     fold("for(;false;) { foo() }", ""); 
     fold("for(;void 0;) { foo() }", ""); 
     fold("for(;undefined;) { foo() }", ""); 
     fold("for(;true;) foo() ", "for(;;) foo() "); 
     foldSame("for(;;) foo()"); 
     fold("for(;false;) { var a = 0; }", "var a"); 
     fold("for(;false;) { foo(); continue }", ""); 
 }
public void testNextBlock254() { 
     fold("{{foo()}}", "foo()"); 
     fold("{foo();{}}", "foo()"); 
     fold("{{foo()}{}}", "foo()"); 
     fold("{{foo()}{bar()}}", "foo();bar()"); 
     fold("{if(false)foo(); {bar()}}", "bar()"); 
     fold("{if(false)if(false)if(false)foo(); {bar()}}", "bar()"); 
     fold("{'hi'}", ""); 
     fold("{x==3}", ""); 
     fold("{ (function(){x++}) }", ""); 
     fold("function f(){return;}", "function f(){return;}"); 
     fold("function f(){return 3;}", "function f(){return 3}"); 
     fold("function f(){if(x)return; x=3; return; }", "function f(){if(x)return; x=3; return; }"); 
     fold("{x=3;;;y=2;;;}", "x=3;y=2"); 
     fold("while(x()){x}", "while(x());"); 
     fold("while(x()){x()}", "while(x())x()"); 
     fold("for(x=0;x<100;x++){x}", "for(x=0;x<100;x++);"); 
     fold("for(x in y){x}", "for(x in y);"); 
 }
public void testParentChild255() { 
     test("a()", "a()"); 
 }
public void testRemoveFromLabel2256() { 
     test("LBL: foo() + 1 + bar()", "LBL: foo(),bar()"); 
 }
public void testParentChild257() { 
     testSame("a()"); 
     testSame("a() + b()"); 
     testSame("a() + b()"); 
     testSame("function f() { a(); }"); 
     test("function f() { a(); break }", "function f() { a(); break }"); 
     test("function f() { if (x) { a(); break } else { f() }", "function f() { if (x) {} }"); 
     testSame("function f() { try { if (x) {} } catch(e) {} return 1; }"); 
     testSame("function f() { try { if (x) { return 1 } } finally { a(); break }"); 
     test("function f() { try { if (x) { return 1 } } finally {} return 1; }", "function f() { try { if (x) {} } finally {} return 1; }"); 
     test("function f() { switch(a){ case 1: return a; } return a; }", "function f() { switch(a){ case 1: } return a; }"); 
     test("function f() { switch(a){ " + "  case 1: return a; case 2: return a; } return a; }", "function f() { switch(a){ " + "  case 1: break; case 2: } return a; }"); 
 }
  

  /** Try to remove spurious blocks with multiple children */
  

  

  

  

  

  

  

  

  

  

  


  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  // TODO(johnlenz): Consider adding a post optimization pass to
  // convert OR into HOOK to save parentheses when the operator
  // precedents would require them.
  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  
}
