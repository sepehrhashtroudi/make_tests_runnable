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

/**
 * Tests for the interaction between multiple peephole passes.
 */
public class PeepholeIntegrationTest extends CompilerTestCase {

  private boolean late = true;

  // TODO(user): Remove this when we no longer need to do string comparison.
  private PeepholeIntegrationTest(boolean compareAsTree) {
    super("", compareAsTree);
  }

  public PeepholeIntegrationTest() {
    super("");
  }

  @Override
  public void setUp() throws Exception {
    super.setUp();
    this.late = false;
    enableLineNumberCheck(true);

    // TODO(nicksantos): Turn this on. There are some normalizations
    // that cause weirdness here.
    disableNormalize();
  }

  @Override
  public CompilerPass getProcessor(final Compiler compiler) {
    PeepholeOptimizationsPass peepholePass =
      new PeepholeOptimizationsPass(compiler,
        new PeepholeSubstituteAlternateSyntax(late),
        new PeepholeRemoveDeadCode(),
        new PeepholeFoldConstants(late)
      );

    return peepholePass;
  }

  @Override
  protected int getNumRepetitions() {
    // Reduce this to 2 if we get better expression evaluators.
    return 4;
  }

  private void foldSame(String js) {
    testSame(js);
  }

  private void fold(String js, String expected) {
    test(js, expected);
  }

  // TODO(user): This is same as fold() except it uses string comparison. Any
  // test that needs tell us where a folding is constructing an invalid AST.
  private void assertResultString(String js, String expected) {
    PeepholeIntegrationTest scTest = new PeepholeIntegrationTest(false);

    scTest.disableNormalize();

    scTest.test(js, expected);
  }

public void testLocalScopeOnly1152() { 
     test("if (x) var f = function(){ var g = function(){} }", "if (x) var f = function(){ function g(){} }"); 
 }
public void testRenameReused153() { 
     test("foo:{break foo}; foo:{break foo}", "a:{break a};a:{break a}"); 
 }
public void testSwitch155() { 
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
public void testIf272() { 
     fold("if (1){ x=1; } else { x = 2;}", "x=1"); 
     fold("if (false){ x = 1; } else { x = 2; }", "x=2"); 
     fold("if (undefined){ x = 1; } else { x = 2; }", "x=2"); 
     fold("if (null){ x = 1; } else { x = 2; }", "x=2"); 
     fold("if (void 0){ x = 1; } else { x = 2; }", "x=2"); 
     fold("if (void foo()){ x = 1; } else { x = 2; }", "foo();x=2"); 
     fold("if (false){ x = 1; } else if (true) { x = 3; } else { x = 2; }", "foo();x=3"); 
     fold("if (x){ x = 1; } else if (false) { x = 3; }", "if(x)x=1"); 
 }
public void testVarLifting273() { 
     fold("if(true)var a", "var a"); 
     fold("if(false)var a", "var a"); 
 }
public void testNoRemoveCall2287() { 
     test("a()+b()", "a(),b()"); 
     test("a()+b()", "a(),b()"); 
     test("a()?b() : true", "a() && b()"); 
     test("a()?b() : false", "a() || b()"); 
     test("(a = true) ? b() : c()", "a = true, b()"); 
     test("(a = false) ? b() : c()", "a = false, c()"); 
     test("do {f()} while((a = true) ? b() : c())", "do {f()} while((a = true) , b())"); 
     test("do {f()} while((a = false) ? b() : c())", "do {f()} while((a = false) , c())"); 
     test("var x = (true) ? 1 : 0", "var x=1"); 
     test("var y = (true) ? ((false) ? 12 : (cond ? 1 : 2)) : 13", "var y=cond?1:2"); 
     testSame("var z=x?void 0:y()"); 
     testSame("z=x?void 0:y()"); 
     testSame("z*=x?void 0:y()"); 
     testSame("var z=x?y():void 0"); 
     testSame("(w?x:void 0).y=z"); 
     testSame("(w?x:void 0).y+=z"); 
     test("y = (x ? void 0 : void 0)", "y = void 0"); 
     test("y = (x ? f() : f())", "y = f()"); 
 }
public void testFoldStringCharCodeAt344() { 
     fold("x = 'abcde'.charCodeAt(0)", "x = 97"); 
     fold("x = 'abcde'.charCodeAt(1)", "x = 98"); 
     fold("x = 'abcde'.charCodeAt(2)", "x = 99"); 
     fold("x = 'abcde'.charCodeAt(3)", "x = 100"); 
     fold("x = 'abcde'.charCodeAt(4)", "x = 101"); 
     foldSame("x = 'abcde'.charCodeAt(5)"); 
     foldSame("x = 'abcde'.charCodeAt(-1)"); 
     foldSame("x = 'abcde'.charCodeAt(y)"); 
     foldSame("x = 'abcde'.charCodeAt()"); 
     foldSame("x = 'abcde'.charCodeAt(0, ++z)"); 
     foldSame("x = 'abcde'.charCodeAt(null)"); 
     foldSame("x = 'abcde'.charCodeAt(true)"); 
     fold("x = '\\ud834\udd1e'.charCodeAt(0)", "x = 55348"); 
     fold("x = '\\ud834\udd1e'.charCodeAt(1)", "x = 56606"); 
 }
public void testCorrectIfReturns347() { 
     testSame("function f() { if (x) { return } }"); 
     testSame("function f() { if (x) { return } return }"); 
     testSame("function f() { if (x) { if (y) { return } } else { return }}"); 
     testSame("function f()" + "{ if (x) { if (y) { return } return } else { return }}"); 
 }
public void testReturnInTry348() { 
     test("var a = true; " + "try { var b = a; } " + "catch (e) { var c = a + b; var d = true; } " + "finally { var f = a + b + c + d; }", "try { var b = true; } " + "catch (e) { var c = true + b; var d = true; } " + "finally { var f = true + b + c + d; }"); 
 }
public void testHook399() { 
     test("a() ? b() : 2", "a() && b()"); 
     test("a() ? b() : 2", "a() || b()"); 
     test("a() ? true : b()", "a() || b()"); 
     test("(a = true) ? b() : c()", "a = true, b()"); 
     test("(a = false) ? b() : c()", "a = false, c()"); 
     test("do {f()} while((a = true) ? b() : c())", "do {f()} while((a = true) , b())"); 
     test("do {f()} while((a = false) ? b() : c())", "do {f()} while((a = false) , c())"); 
     test("var x = (true) ? 1 : 0", "var x=1"); 
     test("var y = (true) ? ((false) ? 12 : (cond ? 1 : 2)) : 13", "var y=cond?1:2"); 
     testSame("var z=x?void 0:y()"); 
     testSame("z=x?void 0:y()"); 
     testSame("z*=x?void 0:y()"); 
     testSame("var z=x?y():void 0"); 
     testSame("(w?x:void 0).y=z"); 
     testSame("(w?x:void 0).y+=z"); 
     test("y = (x ? void 0 : void 0)", "y = void 0"); 
     test("y = (x ? f() : f())", "y = f()"); 
 }
  

  /** Check that removing blocks with 1 child works */
  

  

  /** Test a particularly hairy edge case. */
  

  /** Try to minimize returns */
  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  
}
