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

public void testFoldingMixTypesLate169() { 
     late = true; 
     fold("x = x + '2'", "x+='2'"); 
     fold("x = +x + +'2'", "x = +x + 2"); 
     fold("x = x - '2'", "x-=2"); 
     fold("x = x ^ '2'", "x^=2"); 
     fold("x = '2' ^ x", "x^=2"); 
     fold("x = '2' & x", "x&=2"); 
     fold("x = '2' | x", "x|=2"); 
     fold("x = '2' | y", "x=2|y"); 
     fold("x = y | '2'", "x=y|2"); 
     fold("x = y | (a && '2')", "x=y|(a&&2)"); 
     fold("x = y | (a,'2')", "x=y|(a,2)"); 
     fold("x = y | (a?'1':'2')", "x=y|(a?1:2)"); 
     fold("x = y | ('x'?'1':'2')", "x=y|('x'?1:2)"); 
 }
public void testUnaryOpsStringCompare458() { 
     assertResultString("a=-1", "a=-1"); 
     assertResultString("a=~0", "a=-1"); 
     assertResultString("a=~1", "a=-2"); 
     assertResultString("a=~101", "a=-102"); 
 }
public void testFoldUnaryOpsStringCompare480() { 
     assertResultString("a=-1", "a=-1"); 
     assertResultString("a=~0", "a=-1"); 
     assertResultString("a=~1", "a=-2"); 
     assertResultString("a=~101", "a=-102"); 
 }
public void testFoldVoid481() { 
     foldSame("void 0"); 
     fold("void 1", "void 0"); 
     fold("void x", "void 0"); 
     fold("void x()", "void x()"); 
 }
public void testFoldBitShiftsStringCompare482() { 
     assertResultString("x = -1 << 1", "x=-2"); 
     assertResultString("x = -1 << 8", "x=-256"); 
     assertResultString("x = -1 >> 1", "x=-1"); 
     assertResultString("x = -2 >> 1", "x=-1"); 
     assertResultString("x = -1 >> 0", "x=-1"); 
 }
public void testFoldSimpleArithmeticOp483() { 
     foldSame("x*NaN"); 
     foldSame("NaN/y"); 
     foldSame("f(x)-0"); 
     foldSame("f(x)*1"); 
     foldSame("1*f(x)"); 
     foldSame("0+a+b"); 
     foldSame("0-a-b"); 
     foldSame("a+b-0"); 
     foldSame("(1+x)*NaN"); 
     foldSame("(1+f(x))*NaN"); 
 }
public void testAssignOpsEarly485() { 
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
public void testFoldLiteralsAsNumbers486() { 
     fold("x/'12'", "x/12"); 
     fold("x/('12'+'6')", "x/126"); 
     fold("true*x", "1*x"); 
     fold("x/false", "x/0"); 
 }
public void testFoldBitwiseOp488() { 
     fold("x = 1 & 1", "x = 1"); 
     fold("x = 1 & 2", "x = 0"); 
     fold("x = 3 & 1", "x = 1"); 
     fold("x = 3 & 3", "x = 3"); 
     fold("x = 1 | 1", "x = 1"); 
     fold("x = 1 | 2", "x = 3"); 
     fold("x = 3 | 1", "x = 3"); 
     fold("x = 3 | 3", "x = 3"); 
     fold("x = 1 ^ 1", "x = 0"); 
     fold("x = 1 ^ 2", "x = 3"); 
     fold("x = 3 ^ 1", "x = 2"); 
     fold("x = 3 ^ 3", "x = 0"); 
     fold("x = -1 & 0", "x = 0"); 
     fold("x = 0 & -1", "x = 0"); 
     fold("x = 1 & 4", "x = 0"); 
     fold("x = 2 & 3", "x = 2"); 
     fold("x = 1 & 1.1", "x = 1"); 
     fold("x = 1.1 & 1", "x = 1"); 
     fold("x = 1 & 3000000000", "x = 0"); 
     fold("x = 3000000000 & 1", "x = 0"); 
     fold("x = 1 | 4", "x = 5"); 
     fold("x = 1 | 3", "x = 3"); 
     fold("x = 1 | 1.1", "x = 1"); 
     foldSame("x = 1 | 3E9"); 
     fold("x = 1 | 3000000001", "x = -1294967295"); 
 }
public void testUndefinedComparison3489() { 
     fold("\"123\" !== undefined", "true"); 
     fold("\"123\" === undefined", "false"); 
     fold("undefined !== \"123\"", "true"); 
     fold("undefined === \"123\"", "false"); 
 }
public void testIssue601490() { 
     testSame("'\\v' == 'v'"); 
     testSame("'v' == '\\v'"); 
     testSame("'\\u000B' == '\\v'"); 
 }
public void testFoldLiteralsTypeMismatches491() { 
     fold("true == true", "true"); 
     fold("true == false", "false"); 
     fold("true == null", "false"); 
     fold("false == null", "false"); 
     fold("null <= null", "true"); 
     fold("null >= null", "true"); 
     fold("null > null", "false"); 
     fold("null < null", "false"); 
     fold("false >= null", "true"); 
     fold("false <= null", "true"); 
     fold("false > null", "false"); 
     fold("false < null", "false"); 
     fold("true >= null", "true"); 
     fold("true <= null", "false"); 
     fold("true > null", "true"); 
     fold("true < null", "false"); 
     fold("true >= false", "true"); 
     fold("true <= false", "false"); 
     fold("true > false", "true"); 
     fold("true < false", "false"); 
 }
public void testFoldComplex492() { 
     fold("x = (3 / 1.0) + (1 * 2)", "x = 5"); 
     fold("x = (1 == 1.0) && foo() && true", "x = foo()&&true"); 
     fold("x = 'abc' + 5 + 10", "x = \"abc510\""); 
 }
public void testComparison3493() { 
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
public void testFoldBitwiseOpStringCompareIntegration564() { 
     assertResultString("while(-1 | 0){}", "while(1);"); 
 }
public void testFoldLeftChildOp578() { 
     fold("x * Infinity * 2", "x * Infinity"); 
     foldSame("x - Infinity - 2"); 
     foldSame("x - 1 + Infinity"); 
     foldSame("x - 2 + 1"); 
     foldSame("x - 2 + 3"); 
     foldSame("1 + x - 2 + 1"); 
     foldSame("1 + x - 2 + 3"); 
     foldSame("1 + x - 2 + 3 - 1"); 
     foldSame("f(x)-0"); 
     foldSame("x-0-0"); 
     foldSame("x+2-2+2"); 
     foldSame("x+2-2+2-2"); 
     foldSame("x-2+2"); 
     foldSame("x-2+2-2"); 
     foldSame("x-2+2-2+2"); 
     foldSame("1+x-0-NaN"); 
     foldSame("1+f(x)-0-NaN"); 
     foldSame("1+x-0+NaN"); 
     foldSame("1+f(x)-0+NaN"); 
     foldSame("1+x+NaN"); 
     foldSame("1+f(x)-0+NaN"); 
     foldSame("1+x+NaN"); 
     foldSame("1+x+NaN"); 
     foldSame("1+f(x)-0+NaN"); 
     foldSame("1+x+NaN"); 
     foldSame("1+f(x)-0+NaN"); 
     foldSame("x+2-2"); 
     foldSame("x-2"); 
 }
public void testComplete1665() { 
     test("var x = goog.defineClass(some.Super, {\n" + "  constructor: function(){\n" + "    this.foo = 1;\n" + "  },\n" + "  statics: {\n" + "    prop1: 1,\n" + "    /** @const */\n" + "    PROP2: 2\n" + "  },\n" + "  anotherProp: 1,\n" + "  aMethod: function() {}\n" + "});", "{" + "var x=function(){this.foo=1};" + "goog.inherits(x,some.Super);" + "x.prop1=1;" + "x.PROP2=2;" + "x.prototype.anotherProp=1;" + "x.prototype.aMethod=function(){};" + "}"); 
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
