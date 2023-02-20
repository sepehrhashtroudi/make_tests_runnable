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
 * Tests for {@link PeepholeSubstituteAlternateSyntax} in isolation.
 * Tests for the interaction of multiple peephole passes are in
 * PeepholeIntegrationTest.
 */
public class PeepholeSubstituteAlternateSyntaxTest extends CompilerTestCase {

  // Externs for built-in constructors
  // Needed for testFoldLiteralObjectConstructors(),
  // testFoldLiteralArrayConstructors() and testFoldRegExp...()
  private static final String FOLD_CONSTANTS_TEST_EXTERNS =
      "var Object = function f(){};\n" +
      "var RegExp = function f(a){};\n" +
      "var Array = function f(a){};\n";

  private boolean late = true;

  // TODO(user): Remove this when we no longer need to do string comparison.
  private PeepholeSubstituteAlternateSyntaxTest(boolean compareAsTree) {
    super(FOLD_CONSTANTS_TEST_EXTERNS, compareAsTree);
  }

  public PeepholeSubstituteAlternateSyntaxTest() {
    super(FOLD_CONSTANTS_TEST_EXTERNS);
  }

  @Override
  public void setUp() throws Exception {
    late = true;
    super.setUp();
    enableLineNumberCheck(true);
    disableNormalize();
  }

  @Override
  public CompilerPass getProcessor(final Compiler compiler) {
    CompilerPass peepholePass =
      new PeepholeOptimizationsPass(compiler,
          new PeepholeSubstituteAlternateSyntax(late))
      .setRetraverseOnChange(false);

    return peepholePass;
  }

  @Override
  protected int getNumRepetitions() {
    return 1;
  }

  private void foldSame(String js) {
    testSame(js);
  }

  private void fold(String js, String expected) {
    test(js, expected);
  }

  void assertResultString(String js, String expected) {
    assertResultString(js, expected, false);
  }

  // TODO(user): This is same as fold() except it uses string comparison. Any
  // test that needs tell us where a folding is constructing an invalid AST.
  void assertResultString(String js, String expected, boolean normalize) {
    PeepholeSubstituteAlternateSyntaxTest scTest
        = new PeepholeSubstituteAlternateSyntaxTest(false);

    if (normalize) {
      scTest.enableNormalize();
    } else {
      scTest.disableNormalize();
    }

    scTest.test(js, expected);
  }

  /** Check that removing blocks with 1 child works */
public void testRemoveDuplicateReturn215() { 
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
public void testIssue291216() { 
     fold("if (true) { f.onchange(); }", "if (1) f.onchange();"); 
     foldSame("if (f) { f.onchange(); }"); 
     foldSame("if (f) { f.bar(); } else { f.onchange(); }"); 
     fold("if (f) { f.bonchange(); }", "f && f.bonchange();"); 
     foldSame("if (f) { f['x'](); }"); 
 }
public void testSplitCommaExpressions218() { 
     late = false; 
     foldSame("while (foo(), !0) boo()"); 
     foldSame("var a = (foo(), !0);"); 
     foldSame("a = (foo(), !0);"); 
     foldSame("a:a(),b()"); 
     fold("(x=2), foo()", "x=2; foo()"); 
     fold("foo(), boo();", "foo(); boo()"); 
     fold("(a(), b()), (c(), d());", "a(); b(); (c(), d());"); 
     fold("a(); b(); (c(), d());", "a(); b(); c(); d();"); 
     fold("foo(), true", "foo();true"); 
     fold("foo();true", "foo();1"); 
     fold("function x(){foo(), !0}", "function x(){foo(); !0}"); 
     fold("function x(){foo(); !0}", "function x(){foo(); 1}"); 
 }
public void testMinimizeForCondition219() { 
     fold("for(;!!true;) foo()", "for(;1;) foo()"); 
     fold("for(!!true;;) foo()", "for(!0;;) foo()"); 
     fold("for(;!!x;) foo()", "for(;x;) foo()"); 
     foldSame("for(a in b) foo()"); 
     foldSame("for(a in {}) foo()"); 
     foldSame("for(a in []) foo()"); 
     fold("for(a in !!true) foo()", "for(a in !0) foo()"); 
 }
public void testSimpleFunctionCall220() { 
     test("var a = String(23)", "var a = '' + 23"); 
     test("var a = String('hello')", "var a = '' + 'hello'"); 
     testSame("var a = String('hello', bar());"); 
     testSame("var a = String({valueOf: function() { return 1; }});"); 
 }
public void testBindToCall2221() { 
     test("(goog$bind(f))()", "f()"); 
     test("(goog$bind(f,a))()", "f.call(a)"); 
     test("(goog$bind(f,a,b))()", "f.call(a,b)"); 
     test("(goog$bind(f))(a)", "f(a)"); 
     test("(goog$bind(f,a))(b)", "f.call(a,b)"); 
     test("(goog$bind(f,a,b))(c)", "f.call(a,b,c)"); 
     test("(goog$partial(f))()", "f()"); 
     test("(goog$partial(f,a))()", "f(a)"); 
     test("(goog$partial(f,a,b))()", "f(a,b)"); 
     test("(goog$partial(f))(a)", "f(a)"); 
     test("(goog$partial(f,a))(b)", "f(a,b)"); 
     test("(goog$partial(f,a,b))(c)", "f(a,b,c)"); 
     testSame("(goog$bind(f)).call(g)"); 
 }
public void testFoldRegExpConstructorStringCompare222() { 
     assertResultString("x=new RegExp(\"\\n\", \"i\")", "x=/\\n/i", true); 
 }
public void testRemoveElseCause1223() { 
     test("function f() { if (x) throw 1; else f() }", "function f() { if (x) throw 1; { f() } }"); 
 }
public void testNotCond224() { 
     fold("function f(){if(!x)foo()}", "function f(){x||foo()}"); 
     fold("function f(){if(!x)b=1}", "function f(){x||(b=1)}"); 
     fold("if(!x)z=1;else if(y)z=2", "if(x){y&&(z=2);}else{z=1;}"); 
     fold("if(x)y&&(z=2);else z=1;", "x ? y&&(z=2) : z=1"); 
     foldSame("function f(){if(!(x=1))a.b=1}"); 
 }
public void testComma1226() { 
     late = false; 
     fold("1, 2", "1; 2"); 
     fold("1; 2", "1; 1"); 
     late = true; 
     foldSame("1, 2"); 
 }
public void testUndefined228() { 
     foldSame("var x = undefined"); 
     foldSame("function f(f) {var undefined=2;var x = undefined;}"); 
     this.enableNormalize(); 
     fold("var x = undefined", "var x=void 0"); 
     foldSame("var undefined = 1;" + "function f() {var undefined=2;var x = undefined;}"); 
     foldSame("function f(undefined) {}"); 
     foldSame("try {} catch(undefined) {}"); 
     foldSame("for (undefined in {}) {}"); 
     foldSame("undefined++;"); 
     fold("undefined += undefined;", "undefined += void 0;"); 
 }
public void testFoldConditionalVarDeclaration229() { 
     fold("if(x) var y=1;else y=2", "var y=x?1:2"); 
     fold("if(x) y=1;else var y=2", "var y=x?1:2"); 
     foldSame("if(x) var y = 1; z = 2"); 
     foldSame("if(x||y) y = 1; var z = 2"); 
     foldSame("if(x) { var y = 1; print(y)} else y = 2 "); 
     foldSame("if(x) var y = 1; else {y = 2; print(y)}"); 
 }
public void testNestedIfCombine230() { 
     fold("if(x)if(y){while(1){}}", "if(x&&y){while(1){}}"); 
     fold("if(x||z)if(y){while(1){}}", "if((x||z)&&y){while(1){}}"); 
     fold("if(x)if(y||z){while(1){}}", "if((x)&&(y||z)){while(1){}}"); 
     foldSame("if(x||z)if(y||z){while(1){}}"); 
     fold("if(x)if(y){if(z){while(1){}}}", "if(x&&y&&z){while(1){}}"); 
 }
public void testRemoveDuplicateStatements231() { 
     fold("if (a) { x = 1; x++ } else { x = 2; x++ }", "x=(a) ? 1 : 2; x++"); 
     fold("if (a) { x = 1; x++; y += 1; z = pi; }" + " else  { x = 2; x++; y += 1; z = pi; }", "x=(a) ? 1 : 2; x++; y += 1; z = pi;"); 
     fold("function z() {" + "if (a) { foo(); return !0 } else { goo(); return !0 }" + "}", "function z() {(a) ? foo() : goo(); return !0}"); 
     fold("function z() {if (a) { foo(); x = true; return true " + "} else { goo(); x = true; return true }}", "function z() {(a) ? foo() : goo(); x = !0; return !0}"); 
     fold("function z() {" + "  if (a) { bar(); foo(); return true }" + "    else { bar(); goo(); return true }" + "}", "function z() {" + "  if (a) { bar(); foo(); }" + "    else { bar(); goo(); }" + "  return !0;" + "}"); 
 }
public void testMinimizeExprCondition232() { 
     fold("(x ? true : false) && y()", "x&&y()"); 
     fold("(x ? false : true) && y()", "(!x)&&y()"); 
     fold("(x ? true : y) && y()", "(x || y)&&y()"); 
     fold("(x ? y : false) && y()", "(x && y)&&y()"); 
     fold("(x && true) && y()", "x && y()"); 
     fold("(x && false) && y()", "0&&y()"); 
     fold("(x || true) && y()", "1&&y()"); 
     fold("(x || false) && y()", "x&&y()"); 
 }
public void testPropertyKey290() { 
     test("for (z.i in x) { f(z.i); f(z.i); }", "for (var JSCompiler_IgnoreCajaProperties_0 in x) {" + "  if (!JSCompiler_IgnoreCajaProperties_0.match(/___$/)) {" + "    z.i = JSCompiler_IgnoreCajaProperties_0;" + "    { f(z.i); f(z.i); }" + "  }" + "}"); 
 }
  

  /** Try to minimize returns */
  

  

  

  


  /** Try to minimize assignments */
  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  


  

  

  

  

  
  

  

  

  

  

  

  

  

  

  

  


  

  

  

  

  

  

  

  

  private static class StringCompareTestCase extends CompilerTestCase {

    StringCompareTestCase() {
      super("", false);
    }

    @Override
    protected CompilerPass getProcessor(Compiler compiler) {
      CompilerPass peepholePass =
        new PeepholeOptimizationsPass(compiler,
            new PeepholeSubstituteAlternateSyntax(false));
      return peepholePass;
    }

    


  }
}
