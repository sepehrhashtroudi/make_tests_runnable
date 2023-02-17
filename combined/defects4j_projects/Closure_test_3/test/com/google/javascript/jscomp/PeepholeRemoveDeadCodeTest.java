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

public void testHook7255() { 
     test("a() ? 1 : b()", "a() || b()"); 
 }
public void testFoldBlock256() { 
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
public void testHook6257() { 
     test("a() ? b() : 2", "a() && b()"); 
 }
public void testFoldUselessSwitch259() { 
     fold("switch (a) { case 'a': break }", "switch (a) { case 'a': }"); 
     fold("switch (a) { case 'a': break; case foo(): }", "switch (a) { case 'a':        case foo(): }"); 
     fold("switch (a) { default: break; case 'a': }", "switch (a) { default:        case 'a': }"); 
     foldSame("switch (a) { case 'a': alert(a); break; default: alert(a); }"); 
     foldSame("switch (a) { default: alert(a); break; case 'a': alert(a); }"); 
     fold("X: {switch (a) { case 'a': break X}}", "X: {switch (a) { case 'a': }}"); 
     foldSame("X: {switch (a) { case 'a': if (a()) {break X}  a = 1}}"); 
     fold("X: {switch (a) { case 'a': if (a()) {break X}}}", "X: {switch (a) { case 'a': if (a()) {}}}"); 
     fold("X: {switch (a) { case 'a': if (a()) {break X}}}", "X: {switch (a) { case 'a': if (a()) {}}}"); 
     foldSame("do { break } while(1);"); 
     foldSame("for(;1;) { break }"); 
 }
public void testFoldBlocksWithManyChildren260() { 
     fold("function f() { if (false) {} }", "function f(){}"); 
     fold("function f() { { if (false) {} if (true) {} {} } }", "function f(){}"); 
     fold("{var x; var y; var z; function f() { { var a; { var b; } } } }", "var x;var y;var z;function f(){var a;var b}"); 
 }
public void testFoldComparison3261() { 
     fold("x = !1 == !0", "x = false"); 
     fold("x = !0 == !0", "x = true"); 
     fold("x = !1 == !1", "x = true"); 
     fold("x = !1 == null", "x = false"); 
     fold("x = !1 == !0", "x = false"); 
     fold("x = !0 == null", "x = false"); 
     fold("!0 == !0", "true"); 
     fold("!1 == null", "false"); 
     fold("!1 == !0", "false"); 
     fold("!0 == null", "false"); 
     fold("x = !0 === !0", "x = true"); 
     fold("x = !1 === !1", "x = true"); 
     fold("x = !1 === null", "x = false"); 
     fold("x = !1 === !0", "x = false"); 
     fold("x = !0 === null", "x = false"); 
     fold("!0 === !0", "true"); 
     fold("!1 === null", "false"); 
     fold("!1 === !0", "false"); 
     fold("!0 === null", "false"); 
 }
public void testHook263() { 
     fold("true ? a() : b()", "a()"); 
     fold("false ? a() : b()", "b()"); 
     fold("a() ? b() : true", "a() && b()"); 
     fold("a() ? true : b()", "a() || b()"); 
     fold("(a = true) ? b() : c()", "a = true, b()"); 
     fold("(a = false) ? b() : c()", "a = false, c()"); 
     fold("do {f()} while((a = true) ? b() : c())", "do {f()} while((a = true) , b())"); 
     fold("do {f()} while((a = false) ? b() : c())", "do {f()} while((a = false) , c())"); 
     fold("var x = (true) ? 1 : 0", "var x=1"); 
     fold("var y = (true) ? ((false) ? 12 : (cond ? 1 : 2)) : 13", "var y=cond?1:2"); 
     foldSame("var z=x?void 0:y()"); 
     foldSame("z=x?void 0:y()"); 
     foldSame("z*=x?void 0:y()"); 
     foldSame("var z=x?y():void 0"); 
     foldSame("(w?x:void 0).y=z"); 
     foldSame("(w?x:void 0).y+=z"); 
     fold("y = (x ? void 0 : void 0)", "y = void 0"); 
     fold("y = (x ? f() : f())", "y = f()"); 
 }
public void testRemoveUselessReturn264() { 
     fold("function f() { return; }", "function f(){}"); 
     foldSame("function f() { return a; }"); 
     fold("function f() { if (x) { return a } return a; }", "function f() { if (x) {} return a; }"); 
     foldSame("function f() { try { if (x) { return a } } catch(e) {} return a; }"); 
     foldSame("function f() { try { if (x) {} } catch(e) {} return 1; }"); 
     foldSame("function f() { try { if (x) { return a } } finally { a++ } return a; }"); 
     fold("function f() { try { if (x) { return 1 } } finally {} return 1; }", "function f() { try { if (x) {} } finally {} return 1; }"); 
     fold("function f() { switch(a){ case 1: return a; } return a; }", "function f() { switch(a){ case 1: } return a; }"); 
     fold("function f() { switch(a){ " + "  case 1: return a; case 2: return a; } return a; }", "function f() { switch(a){ " + "  case 1: break; case 2: } return a; }"); 
 }
public void testSwitch265() { 
     fold("switch (a) { case 'a': break }", "switch (a) { case 'a': }"); 
     fold("switch (a) { case 'a': break; case foo(): }", "switch (a) { case 'a':        case foo(): }"); 
     fold("switch (a) { default: break; case 'a': }", "switch (a) { default:        case 'a': }"); 
     foldSame("switch (a) { case 'a': alert(a); break; default: alert(a); }"); 
     foldSame("switch (a) { default: alert(a); break; case 'a': alert(a); }"); 
     fold("X: {switch (a) { case 'a': break X}}", "X: {switch (a) { case 'a': }}"); 
     foldSame("X: {switch (a) { case 'a': if (a()) {break X}  a = 1}}"); 
     fold("X: {switch (a) { case 'a': if (a()) {break X}}}", "X: {switch (a) { case 'a': if (a()) {}}}"); 
     fold("X: {switch (a) { case 'a': if (a()) {break X}}}", "X: {switch (a) { case 'a': if (a()) {}}}"); 
     foldSame("do { break } while(1);"); 
     foldSame("for(;1;) { break }"); 
 }
public void testUselessUnconditionalReturn266() { 
     test("function foo() { return }", " function foo() { }"); 
     test("function foo() { return; return; x=1 }", "function foo() { }"); 
     test("function foo() { return; return; var x=1}", "function foo() {var x}"); 
     test("function foo() { return; function bar() {} }", "function foo() {         function bar() {} }"); 
     testSame("function foo() { return 5 }"); 
     test("function f() {switch (a) { case 'a': return}}", "function f() {switch (a) { case 'a': }}"); 
     testSame("function f() {switch (a) { case 'a': case foo(): }}"); 
     testSame("function f() {switch (a) {" + " default: return; case 'a': alert(1)}}"); 
     testSame("function f() {switch (a) {" + " case 'a': return; default: alert(1)}}"); 
 }
public void testSwitch4267() { 
     test("switch (a) { case 'a': break }", "switch (a) { case 'a': }"); 
     test("switch (a) { case 'a': break; case foo(): }", "switch (a) { case 'a':        case foo(): }"); 
     test("switch (a) { default: break; case 'a': }", "switch (a) { default:        case 'a': }"); 
     testSame("switch (a) { case 'a': alert(a); break; default: alert(a); }"); 
     testSame("switch (a) { default: alert(a); break; case 'a': alert(a); }"); 
     test("X: {switch (a) { case 'a': break X}}", "X: {switch (a) { case 'a': }}"); 
     testSame("X: {switch (a) { case 'a': if (a()) {break X}  a = 1}}"); 
     test("X: {switch (a) { case 'a': if (a()) {break X}}}", "X: {switch (a) { case 'a': if (a()) {}}}"); 
     test("X: {switch (a) { case 'a': if (a()) {break X}}}", "X: {switch (a) { case 'a': if (a()) {}}}"); 
     testSame("do { break } while(1);"); 
     testSame("for(;1;) { break }"); 
 }
public void testFoldUselessBlock268() { 
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
public void testRemoveUselessDo269() { 
     fold("do { foo() } while(false);", "foo()"); 
     fold("do { foo() } while(void 0);", "foo()"); 
     fold("do { foo() } while(undefined);", "foo()"); 
     fold("do { foo() } while(true);", "do { foo() } while(true);"); 
     fold("do { var a = 0; } while(false);", "var a=0"); 
     fold("do { var a = 0; } while(!{a:foo()});", "var a=0;foo()"); 
     foldSame("do { foo(); continue; } while(0)"); 
     foldSame("do { foo(); break; } while(0)"); 
 }
public void testRemoveFromLabel2270() { 
     test("LBL: foo() + 1 + bar()", "LBL: foo(),bar()"); 
 }
public void testConstantConditionWithSideEffect2271() { 
     fold("(b=true)?x=1:x=2;", "b=true,x=1"); 
     fold("(b=false)?x=1:x=2;", "b=false,x=2"); 
     fold("if (b=/ab/) x=1;", "b=/ab/;x=1"); 
     fold("var b;b=/ab/;(b)?x=1:x=2;", "var b;b=/ab/;x=1"); 
     foldSame("var b;b=f();(b)?x=1:x=2;"); 
     fold("var b=/ab/;(b)?x=1:x=2;", "var b=/ab/;x=1"); 
     foldSame("var b=f();(b)?x=1:x=2;"); 
 }
public void testRemoveInControlStructure1274() { 
     test("if(x()) 1", "x()"); 
 }
  

  /** Try to remove spurious blocks with multiple children */
  

  

  

  

  

  

  

  

  

  

  


  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  // TODO(johnlenz): Consider adding a post optimization pass to
  // convert OR into HOOK to save parentheses when the operator
  // precedents would require them.
  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  
}
