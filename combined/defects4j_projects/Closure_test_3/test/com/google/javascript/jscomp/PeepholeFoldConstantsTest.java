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

import com.google.common.base.Joiner;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.javascript.rhino.Node;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Tests for {@link PeepholeFoldConstants} in isolation. Tests for
 * the interaction of multiple peephole passes are in
 * {@link PeepholeIntegrationTest}.
 */
public class PeepholeFoldConstantsTest extends CompilerTestCase {

  private boolean late;

  // TODO(user): Remove this when we no longer need to do string comparison.
  private PeepholeFoldConstantsTest(boolean compareAsTree) {
    super("", compareAsTree);
  }

  public PeepholeFoldConstantsTest() {
    super("");
  }

  @Override
  public void setUp() {
    late = false;
    enableLineNumberCheck(true);
  }

  @Override
  public CompilerPass getProcessor(final Compiler compiler) {
    CompilerPass peepholePass = new PeepholeOptimizationsPass(compiler,
          new PeepholeFoldConstants(late));
    return peepholePass;
  }

  @Override
  protected int getNumRepetitions() {
    // Reduce this to 1 if we get better expression evaluators.
    return 2;
  }

  private void foldSame(String js) {
    testSame(js);
  }

  private void fold(String js, String expected) {
    test(js, expected);
  }

  private void fold(String js, String expected, DiagnosticType warning) {
    test(js, expected, null, warning);
  }

  // TODO(user): This is same as fold() except it uses string comparison. Any
  // test that needs tell us where a folding is constructing an invalid AST.
  private void assertResultString(String js, String expected) {
    PeepholeFoldConstantsTest scTest = new PeepholeFoldConstantsTest(false);

    scTest.test(js, expected);
  }

public void testFoldNewValues460() { 
     fold("x=x+y", "x+=y"); 
     foldSame("x=y+x"); 
     fold("x=x*y", "x*=y"); 
     fold("x=y*x", "x*=y"); 
     fold("x.y=x.y+z", "x.y+=z"); 
     foldSame("next().x = next().x + 1"); 
     fold("x=x-y", "x-=y"); 
     foldSame("x=y-x"); 
     foldSame("x=x|y"); 
     foldSame("x=y|x"); 
     foldSame("x=x*y"); 
     foldSame("x=y*x"); 
     foldSame("x.y=x.y+z"); 
     foldSame("next().x = next().x + 1"); 
     fold("({a:1}).a = ({a:1}).a + 1", "({a:1}).a = 2"); 
 }
public void testAssignOpsEarly461() { 
     late = false; 
     foldSame("x=x+y"); 
     foldSame("x=y+x"); 
     foldSame("x=x*y"); 
     foldSame("x=y*x"); 
     foldSame("x.y=x.y+z"); 
     foldSame("next().x = next().x + 1"); 
     foldSame("x=x-y"); 
     foldSame("x=y-x"); 
     foldSame("x=x|y"); 
     foldSame("x=y|x"); 
     foldSame("x=x*y"); 
     foldSame("x=y*x"); 
     foldSame("x.y=x.y+z"); 
     foldSame("next().x = next().x + 1"); 
     fold("({a:1}).a = ({a:1}).a + 1", "({a:1}).a = 2"); 
 }
public void testFoldLeftChildConcat463() { 
     foldSame("x +5 + \"1\""); 
     fold("x+\"5\" + \"1\"", "x + \"51\""); 
     fold("\"a\"+(\"b\"+c)", "\"ab\"+c"); 
 }
public void testFoldSimple464() { 
     fold("x = 'abcde'.split('foo')", "x = ['abcde']"); 
     fold("x = 'abcde'.split()", "x = ['abcde']"); 
     fold("x = 'abcde'.split(null)", "x = ['abcde']"); 
     fold("x = 'a b c d e'.split(' ')", "x = ['a','b','c','d','e']"); 
     fold("x = 'a b c d e'.split(' ', 0)", "x = []"); 
     fold("x = 'abcde'.split('cd')", "x = ['ab','e']"); 
     fold("x = 'a b c d e'.split(' ', 1)", "x = ['a']"); 
     fold("x = 'a b c d e'.split(' ', 3)", "x = ['a','b','c']"); 
     fold("x = 'a b c d e'.split(null, 1)", "x = ['a b c d e']"); 
     fold("x = 'aaaaa'.split('a')", "x = ['', '', '', '', '', '']"); 
     fold("x = 'xyx'.split('x')", "x = ['', 'y', '']"); 
     fold("x = 'abcde'.split('')", "x = ['a','b','c','d','e']"); 
     fold("x = 'abcde'.split('', 3)", "x = ['a','b','c']"); 
     fold("x = ''.split('')", "x = []"); 
     fold("x = 'aaa'.split('aaa')", "x = ['','']"); 
     fold("x = ' '.split(' ')", "x = ['','']"); 
     foldSame("x = 'abcde'.split(/ /)"); 
     foldSame("x = 'abcde'.split(' ', -1)"); 
     late = true;
}

public void testFoldInForcedString466() { 
     fold("for (var i in x) {;}", "for (var i in x) {f(i)}"); 
     fold("for (var i in x) {f(i);}", "for (var i in x) {if(i > 5) {break}}"); 
     fold("s: for(var i in x) {if(i % 2) {" + "continue} else {var x = i / 3; f(x)}}", "for (var i in x) {2 + 3; q = 2 + 3; var v = y * z; " + "g = function(a) {true; var b = a + 1; return a * a}}"); 
     fold("for (i in x) {}", "for (i in x) {}"); 
     fold("for (i in x) {;}", "for (i in x) {;}"); 
     foldSame("for (i in x) {f(x)}"); 
     foldSame("for (i in x) {if (i > 5) {break s}}"); 
     fold("for (i in x) {if (i % 2) {" + "continue} else {var x = i / 3; f(x)}}", "for (i in x) {2 + 3; q = 2 + 3; var v = y * z; " + "g = function(a) {true; var b = a + 1; return a * a}}"); 
 }
public void testFoldInFor467() { 
     fold("for(;!!true;) foo()", "for(;1;) foo()"); 
     fold("for(!!true;;) foo()", "for(!0;;) foo()"); 
     fold("for(;!!x;) foo()", "for(;x;) foo()"); 
     foldSame("for(a in b) foo()"); 
     foldSame("for(a in {}) foo()"); 
     foldSame("for(a in []) foo()"); 
     fold("for(a in !!true) foo()", "for(a in !0) foo()"); 
 }
public void testFoldInForcedString468() { 
     fold("for(var a = 0; a < 2 ; a++) foo()", "for(a = 0; a < 2 ; a++) foo();"); 
     fold("for(var a = 0; c < b ; c++) foo()", "for(var a = 0; c < b ; c++) foo()"); 
     foldSame("for(init(); a < 2 ; a++) foo()"); 
     foldSame("for(init(); a < 2 ; a++) foo()"); 
     foldSame("for(var a = 0; c < b ; c++) foo()"); 
     foldSame("for(init(); a < 2 ; a++) foo()"); 
     foldSame("for(init(); a < 2 ; a++) foo()"); 
     foldSame("for(init(); a < 2 ; a++) foo()"); 
     fold("function f(){ var a; for(; a < 2 ; a++) foo() }", "function f(){ for(var a; a < 2 ; a++) foo() }"); 
     fold("function f(){ var a; a < 2 ; a++) foo() }", "function f(){ for(var a; a < 2 ; a++) foo() }"); 
     fold("function f(){ return; for(; a < 2 ; a++) foo() }", "function f(){ return; for(; a < 2 ; a++) foo() }"); 
     fold("function f(){ return; for(var a; a < 2 ; a++) foo() }", "function f(){ return; for(var a; a < 2 ; a++) foo() }"); 
     fold("function f(){ return; for(var a; a < 2 ; a++) foo() }", "function f(){ return; for(var a; a < 2 ; a++) foo() }"); 
     fold("function f(){ return; for(var a; a < 2 ; a++) foo() }", "function f(){ return; for(var a; a < 2 ; a++) foo() }"); 
 }
public void testFoldInForcedString469() { 
     fold("x = 'abcde'.split('foo')", "x = ['abcde']"); 
     fold("x = 'abcde'.split()", "x = ['abcde']"); 
     fold("x = 'abcde'.split(null)", "x = ['abcde']"); 
     fold("x = 'a b c d e'.split(' ')", "x = ['a','b','c','d','e']"); 
     fold("x = 'a b c d e'.split(' ', 0)", "x = []"); 
     fold("x = 'abcde'.split('cd')", "x = ['ab','e']"); 
     fold("x = 'a b c d e'.split(' ', 1)", "x = ['a']"); 
     fold("x = 'a b c d e'.split(' ', 3)", "x = ['a','b','c']"); 
     fold("x = 'a b c d e'.split(null, 1)", "x = ['a b c d e']"); 
     fold("x = 'aaaaa'.split('a')", "x = ['', '', '', '', '', '']"); 
     fold("x = 'xyx'.split('x')", "x = ['', 'y', '']"); 
     fold("x = 'abcde'.split('')", "x = ['a','b','c','d','e']"); 
     fold("x = 'abcde'.split('', 3)", "x = ['a','b','c']"); 
     fold("x = ''.split('')", "x = []"); 
     fold("x = 'aaa'.split('aaa')", "x = ['','']"); 
     fold("x = ' '.split(' ')", "x = ['','']"); 
     foldSame("x = 'abcde'.split(/ /)"); 
     foldSame("x = 'abcde'.split(' ', -1)"); 
     late = true;
}

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  // ===, !== comparison tests
  

  

  

  

  

  

  

  

  

  

  

 

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  private static final List<String> LITERAL_OPERANDS =
      ImmutableList.of(
          "null",
          "undefined",
          "void 0",
          "true",
          "false",
          "!0",
          "!1",
          "0",
          "1",
          "''",
          "'123'",
          "'abc'",
          "'def'",
          "NaN",
          "Infinity",
          // TODO(nicksantos): Add more literals
          "-Infinity"
          //"({})",
          // "[]"
          //"[0]",
          //"Object",
          //"(function() {})"
          );

  

  

  

  private String join(String operandA, String op, String operandB) {
    return operandA + " " + op + " " + operandB;
  }

  private void assertSameResultsOrUncollapsed(String exprA, String exprB) {
    String resultA = process(exprA);
    String resultB = process(exprB);  // TODO: why is nothing done with this?
    if (resultA.equals(print(exprA))) {
      foldSame(exprA);
      foldSame(exprB);
    } else {
      assertSameResults(exprA, exprB);
    }
  }

  private void assertSameResults(String exprA, String exprB) {
    assertEquals(
        "Expressions did not fold the same\nexprA: " +
        exprA + "\nexprB: " + exprB,
        process(exprA), process(exprB));
  }

  private void assertNotSameResults(String exprA, String exprB) {
    assertFalse(
        "Expressions folded the same\nexprA: " +
        exprA + "\nexprB: " + exprB,
        process(exprA).equals(process(exprB)));
  }

  private String process(String js) {
    return printHelper(js, true);
  }

  private String print(String js) {
    return printHelper(js, false);
  }

  private String printHelper(String js, boolean runProcessor) {
    Compiler compiler = createCompiler();
    CompilerOptions options = getOptions();
    compiler.init(
        ImmutableList.<SourceFile>of(),
        ImmutableList.of(SourceFile.fromCode("testcode", js)),
        options);
    Node root = compiler.parseInputs();
    assertTrue("Unexpected parse error(s): " +
        Joiner.on("\n").join(compiler.getErrors()) +
        "\nEXPR: " + js,
        root != null);
    Node externsRoot = root.getFirstChild();
    Node mainRoot = externsRoot.getNext();
    if (runProcessor) {
      getProcessor(compiler).process(externsRoot, mainRoot);
    }
    return compiler.toSource(mainRoot);
  }
}
