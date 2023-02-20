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
public void testHook7162() { 
     test("a() ? 1 : b()", "a() || b()"); 
 }
public void testRemoveDuplicateReturn217() { 
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
public void testFoldNot218() { 
     fold("while(!(x==y)){a=b;}", "while(x!=y){a=b;}"); 
     fold("while(!(x!=y)){a=b;}", "while(x==y){a=b;}"); 
     fold("while(!(x===y)){a=b;}", "while(x!==y){a=b;}"); 
     fold("while(!(x!==y)){a=b;}", "while(x===y){a=b;}"); 
     foldSame("while(!(x>y)){a=b;}"); 
     foldSame("while(!(x>=y)){a=b;}"); 
     foldSame("while(!(x<y)){a=b;}"); 
     foldSame("while(!(x<=y)){a=b;}"); 
     foldSame("while(!(x<=NaN)){a=b;}"); 
     fold("x = !(y() && true)", "x = !y()"); 
     fold("x = !true", "x = !1"); 
 }
public void testFoldTrueFalse219() { 
     fold("x = true", "x = !0"); 
     fold("x = false", "x = !1"); 
 }
public void testStringArraySplitting220() { 
     testSame("var x=['1','2','3','4']"); 
     testSame("var x=['1','2','3','4','5']"); 
     test("var x=['1','2','3','4','5','6']", "var x='123456'.split('')"); 
     test("var x=['1','2','3','4','5','00']", "var x='1 2 3 4 5 00'.split(' ')"); 
     test("var x=['1','2','3','4','5','6','7']", "var x='1234567'.split('')"); 
     test("var x=['1','2','3','4','5','6','00']", "var x='1 2 3 4 5 6 00'.split(' ')"); 
     test("var x=[' ,',',',',',',',',',',']", "var x=' ,;,;,;,;,;,'.split(';')"); 
     test("var x=[',,',' ',',',',',',',',']", "var x=',,; ;,;,;,;,'.split(';')"); 
     test("var x=['a,',' ',',',',',',',',']", "var x='a,; ;,;,;,;,'.split(';')"); 
     testSame("var x=[',', ' ', ';', '{', '}']"); 
 }
public void testComma1221() { 
     late = false; 
     fold("1, 2", "1; 2"); 
     fold("1; 2", "1; 1"); 
     late = true; 
     foldSame("1, 2"); 
 }
public void testFoldReturns222() { 
     fold("function f(){if(x)return 1;else return 2}", "function f(){return x?1:2}"); 
     fold("function f(){if(x)return 1;return 2}", "function f(){return x?1:2}"); 
     fold("function f(){if(x)return;return 2}", "function f(){return x?void 0:2}"); 
     fold("function f(){if(x)return 1+x;else return 2-x}", "function f(){return x?1+x:2-x}"); 
     fold("function f(){if(x)return 1+x;return 2-x}", "function f(){return x?1+x:2-x}"); 
     fold("function f(){if(x)return y += 1;else return y += 2}", "function f(){return x?(y+=1):(y+=2)}"); 
     fold("function f(){if(x)return;else return 2-x}", "function f(){if(x);else return 2-x}"); 
     fold("function f(){if(x)return;return 2-x}", "function f(){return x?void 0:2-x}"); 
     fold("function f(){if(x)return x;else return}", "function f(){if(x)return x;{}}"); 
     fold("function f(){if(x)return x;return}", "function f(){if(x)return x}"); 
     foldSame("function f(){for(var x in y) { return x.y; } return k}"); 
 }
public void testFoldConditionalVarDeclaration223() { 
     fold("if(x) var y=1;else y=2", "var y=x?1:2"); 
     fold("if(x) y=1;else var y=2", "var y=x?1:2"); 
     foldSame("if(x) var y = 1; z = 2"); 
     foldSame("if(x||y) y = 1; var z = 2"); 
     foldSame("if(x) { var y = 1; print(y)} else y = 2 "); 
     foldSame("if(x) var y = 1; else {y = 2; print(y)}"); 
 }
public void testMinimizeWhileCondition224() { 
     fold("while(!!true) foo()", "while(1) foo()"); 
     fold("while(!!x) foo()", "while(x) foo()"); 
     fold("while(!(!x&&!y)) foo()", "while(x||y) foo()"); 
     fold("while(x||!!y) foo()", "while(x||y) foo()"); 
     fold("while(!(!!x&&y)) foo()", "while(!x||!y) foo()"); 
     fold("while(!(!x&&y)) foo()", "while(x||!y) foo()"); 
     fold("while(!(x||!y)) foo()", "while(!x&&y) foo()"); 
     fold("while(!(x||y)) foo()", "while(!x&&!y) foo()"); 
     fold("while(!(!x||y-z)) foo()", "while(x&&!(y-z)) foo()"); 
     fold("while(!(!(x/y)||z+w)) foo()", "while(x/y&&!(z+w)) foo()"); 
     foldSame("while(!(x+y||z)) foo()"); 
     foldSame("while(!(x&&y*z)) foo()"); 
     fold("while(!(!!x&&y)) foo()", "while(!x||!y) foo()"); 
     fold("while(x&&!0) foo()", "while(x) foo()"); 
     fold("while(x||!1) foo()", "while(x) foo()"); 
     fold("while(!((x,y)&&z)) foo()", "while(!(x,y)||!z) foo()"); 
 }
public void testFoldRegExpConstructorStringCompare225() { 
     assertResultString("x=new RegExp(\"\\n\", \"i\")", "x=/\\n/i", true); 
 }
public void testAdd269() { 
     test("add(x){}", "x = 0"); 
     test("add(x){}", "x = 1"); 
     test("add(x){}", "x = 2"); 
     test("add(x){}", "x = 3"); 
     test("add(x){}", "x = 4"); 
     test("add(x){}", "x = 5"); 
     test("add(x){}", "x = 0"); 
     test("add(x){}", "x = 1"); 
     test("add(x){}", "x = 2"); 
     test("add(x){}", "x = 5"); 
     test("add(x){}", "x = 0"); 
     test("add(x){}", "x = 1"); 
     test("add(x){}", "x = 2"); 
     test("add(x){}", "x = 3"); 
     test("add(x){}", "x = 4"); 
 }
public void testIgnoredOps273() { 
     testSame("function foo() { this.length-- }"); 
     testSame("function foo() { this.length++ }"); 
     testSame("function foo() { this.length+=5 }"); 
     testSame("function foo() { this.length-=5 }"); 
 }
public void testLocalScopeOnly1374() { 
     test("if (x) var f = function(){ var g = function(){} }", "if (x) var f = function(){ function g(){} }"); 
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
