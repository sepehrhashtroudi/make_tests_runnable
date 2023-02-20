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
public void testFoldLoopBreakLate127() { 
     late = true; 
     fold("for(;;) if (a) break", "for(;!a;);"); 
     foldSame("for(;;) if (a) { f(); break }"); 
     foldSame("for(;;) if (a) break"); 
     foldSame("for(;a;) if (b) break"); 
     fold("for(;a;) if (b) break", "for(;a && !b;);"); 
     fold("for(;a;) { if (b) break; if (c) break; }", "for(;(a && !b);) if (c) break;"); 
     fold("for(;(a && !b);) if (c) break;", "for(;(a && !b) && !c;);"); 
     enableNormalize(true); 
     fold("while(true) if (a) break", "for(;1&&!a;);"); 
 }
public void testMinimizeWhileCondition129() { 
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
