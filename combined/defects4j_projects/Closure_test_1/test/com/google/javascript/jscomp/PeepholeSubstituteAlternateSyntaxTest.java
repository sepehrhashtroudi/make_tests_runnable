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
public void testHook7222() { 
     test("a() ? 1 : b()", "a() || b()"); 
 }
public void testStringArraySplitting276() { 
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
public void testIssue291277() { 
     fold("if (true) { f.onchange(); }", "if (1) f.onchange();"); 
     foldSame("if (f) { f.onchange(); }"); 
     foldSame("if (f) { f.bar(); } else { f.onchange(); }"); 
     fold("if (f) { f.bonchange(); }", "f && f.bonchange();"); 
     foldSame("if (f) { f['x'](); }"); 
 }
public void testFoldAssignments278() { 
     fold("function f(){if(x)y=3;else y=4;}", "function f(){y=x?3:4}"); 
     fold("function f(){if(x)y=1+a;else y=2+a;}", "function f(){y=x?1+a:2+a}"); 
     fold("function f(){if(x)y+=1;else y+=2;}", "function f(){y+=x?1:2}"); 
     fold("function f(){if(x)y-=1;else y-=2;}", "function f(){y-=x?1:2}"); 
     fold("function f(){if(x)y%=1;else y%=2;}", "function f(){y%=x?1:2}"); 
     fold("function f(){if(x)y|=1;else y|=2;}", "function f(){y|=x?1:2}"); 
     foldSame("function f(){x ? y-=1 : y+=2}"); 
     foldSame("function f(){x ? y-=1 : z-=1}"); 
     foldSame("function f(){x ? y().a=3 : y().a=4}"); 
 }
public void testFoldStandardConstructor279() { 
     fold("x = this[new String('a')]", "x = this['a']"); 
     fold("x = ob[new String(12)]", "x = ob['12']"); 
     fold("x = ob[new String(false)]", "x = ob['false']"); 
     fold("x = ob[new String(null)]", "x = ob['null']"); 
     fold("x = 'a' + new String('b')", "x = 'ab'"); 
     fold("x = 'a' + new String(23)", "x = 'a23'"); 
     fold("x = 2 + new String(1)", "x = '21'"); 
     foldSame("x = ob[new String(a)]"); 
     foldSame("x = new String('a')"); 
     foldSame("x = (new String('a'))[3]"); 
 }
public void testFoldConstructor280() { 
     fold("x = this[new String('a')]", "x = this['a']"); 
     fold("x = ob[new String(12)]", "x = ob['12']"); 
     fold("x = ob[new String(false)]", "x = ob['false']"); 
     fold("x = ob[new String(null)]", "x = ob['null']"); 
     fold("x = 'a' + new String('b')", "x = 'ab'"); 
     fold("x = 'a' + new String(23)", "x = 'a23'"); 
     fold("x = 2 + new String(1)", "x = '21'"); 
     foldSame("x = ob[new String(a)]"); 
     foldSame("x = new String('a')"); 
     foldSame("x = (new String('a'))[3]"); 
 }
public void testFoldRegExpConstructor281() { 
     enableNormalize(); 
     fold("x = new RegExp", "x = RegExp()"); 
     fold("x = new RegExp(\"\")", "x = RegExp(\"\")"); 
     fold("x = new RegExp(\"\", \"i\")", "x = RegExp(\"\",\"i\")"); 
     testSame("x = RegExp(\"foobar\", \"bogus\")", PeepholeSubstituteAlternateSyntax.INVALID_REGULAR_EXPRESSION_FLAGS); 
     fold("x = new RegExp(\"foobar\")", "x = /foobar/"); 
     fold("x = RegExp(\"foobar\")", "x = /foobar/"); 
     fold("x = new RegExp(\"foobar\", \"i\")", "x = /foobar/i"); 
     fold("x = new RegExp(\"\\\\.\", \"i\")", "x = /\\./i"); 
     fold("x = new RegExp(\"/\", \"\")", "x = /\\//"); 
     fold("x = new RegExp(\"[/]\", \"\")", "x = /[/]/"); 
     fold("x = new RegExp(\"///\", \"\")", "x = /\\/\\/\\//"); 
     fold("x = new RegExp(\"\\\\\\/\", \"\")", "x = /\\//"); 
     fold("x = new RegExp(\"\\n\")", "x = /\\n/"); 
     fold("x = new RegExp('\\\\\\r')", "x = /\\r/"); 
     String longRegexp = ""; 
     for (int i = 0; i < 200; i++) longRegexp += "x"; 
     foldSame("x = RegExp(\"" + longRegexp + "\")"); 
     disableNormalize(); 
     foldSame("x = new RegExp(\"foobar\")"); 
 }
public void testFoldStringConstructor282() { 
     fold("x = this[new String('a')]", "x = this['a']"); 
     fold("x = ob[new String(12)]", "x = ob['12']"); 
     fold("x = ob[new String(false)]", "x = ob['false']"); 
     fold("x = ob[new String(null)]", "x = ob['null']"); 
     fold("x = 'a' + new String('b')", "x = 'ab'"); 
     fold("x = 'a' + new String(23)", "x = 'a23'"); 
     fold("x = 2 + new String(1)", "x = '21'"); 
     foldSame("x = ob[new String(a)]"); 
     foldSame("x = new String('a')"); 
     foldSame("x = (new String('a'))[3]"); 
 }
public void testVersionSpecificRegExpQuirks283() { 
     enableNormalize(); 
     enableEcmaScript5(false); 
     fold("x = new RegExp(\"foobar\", \"g\")", "x = RegExp(\"foobar\",\"g\")"); 
     fold("x = new RegExp(\"foobar\", \"ig\")", "x = RegExp(\"foobar\",\"ig\")"); 
     enableEcmaScript5(true); 
     fold("x = new RegExp(\"foobar\", \"ig\")", "x = /foobar/ig"); 
     enableEcmaScript5(false); 
     fold("x = new RegExp(\"\\u2028\")", "x = RegExp(\"\\u2028\")"); 
     fold("x = new RegExp(\"\\\\\\\\u2028\")", "x = /\\\\u2028/"); 
     enableEcmaScript5(true); 
     fold("x = new RegExp(\"\\u2028\\u2029\")", "x = /\\u2028\\u2029/"); 
     fold("x = new RegExp(\"\\\\u2028\")", "x = /\\u2028/"); 
     fold("x = new RegExp(\"\\\\\\\\u2028\")", "x = /\\\\u2028/"); 
 }
public void testLocalScopeOnly1426() { 
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
