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

public void testFor378() { 
     test("a = 0; for(; a < 2 ; a++) foo()", "for(a = 0; a < 2 ; a++) foo();"); 
     test("var a = 0; for(; c < b ; c++) foo()", "for(var a = 0; c < b ; c++) foo()"); 
     testSame("var a = 0; a:for(; c < b ; c++) foo()"); 
     testSame("var a = 0; a:b:for(; c < b ; c++) foo()"); 
     test("if(x){var a = 0; for(; c < b; c++) foo()}", "if(x){for(var a = 0; c < b; c++) foo()}"); 
     test("init(); for(; a < 2 ; a++) foo()", "for(init(); a < 2 ; a++) foo();"); 
     test("function f(){ var a; for(; a < 2 ; a++) foo() }", "function f(){ for(var a; a < 2 ; a++) foo() }"); 
     testSame("function f(){ return; for(; a < 2 ; a++) foo() }"); 
 }
public void testFoldLiteralsAsNumbers445() { 
     fold("x/'12'", "x/12"); 
     fold("x/('12'+'6')", "x/126"); 
     fold("true*x", "1*x"); 
     fold("x/false", "x/0"); 
 }
public void testAssignOpsEarly446() { 
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
public void testUnaryOpsStringCompare447() { 
     assertResultString("a=-1", "a=-1"); 
     assertResultString("a=~0", "a=-1"); 
     assertResultString("a=~1", "a=-2"); 
     assertResultString("a=~101", "a=-102"); 
 }
public void testFoldArithmeticInfinity448() { 
     fold("x=-Infinity-2", "x=-Infinity"); 
     fold("x=Infinity-2", "x=Infinity"); 
     fold("x=Infinity*5", "x=Infinity"); 
 }
public void testAssignOpsLate450() { 
     late = true; 
     fold("x=x+y", "x+=y"); 
     foldSame("x=y+x"); 
     fold("x=x*y", "x*=y"); 
     fold("x=y*x", "x*=y"); 
     fold("x.y=x.y+z", "x.y+=z"); 
     foldSame("next().x = next().x + 1"); 
     fold("x=x-y", "x-=y"); 
     foldSame("x=y-x"); 
     fold("x=x|y", "x|=y"); 
     fold("x=y|x", "x|=y"); 
     fold("x=x*y", "x*=y"); 
     fold("x=y*x", "x*=y"); 
     fold("x.y=x.y+z", "x.y+=z"); 
     foldSame("next().x = next().x + 1"); 
     fold("({a:1}).a = ({a:1}).a + 1", "({a:1}).a = 2"); 
 }
public void testFoldBitwiseOp2451() { 
     fold("x = 1 << 0", "x = 1"); 
     fold("x = -1 << 0", "x = -1"); 
     fold("x = 1 << 1", "x = 2"); 
     fold("x = 3 << 1", "x = 6"); 
     fold("x = 1 << 8", "x = 256"); 
     fold("x = 1 >> 0", "x = 1"); 
     fold("x = -1 >> 0", "x = -1"); 
     fold("x = 1 >> 1", "x = 0"); 
     fold("x = 2 >> 1", "x = 1"); 
     fold("x = 5 >> 1", "x = 2"); 
     fold("x = 127 >> 3", "x = 15"); 
     fold("x = 3 >> 1", "x = 1"); 
     fold("x = 3 >> 2", "x = 0"); 
     fold("x = 10 >> 1", "x = 5"); 
     fold("x = 10 >> 2", "x = 2"); 
     fold("x = 10 >> 5", "x = 0"); 
     fold("x = 10 >>> 1", "x = 5"); 
     fold("x = 10 >>> 2", "x = 2"); 
     fold("x = 10 >>> 5", "x = 0"); 
     fold("x = -1 >>> 1", "x = 2147483647"); 
     fold("x = -1 >>> 0", "x = 4294967295"); 
     fold("x = -2 >>> 0", "x = 4294967294"); 
     testSame("3000000000 << 1", PeepholeFoldConstants.BITWISE_OPERAND_OUT_OF_RANGE); 
     testSame("1 << 32", PeepholeFoldConstants.SHIFT_AMOUNT_OUT_OF_BOUNDS); 
     testSame("1 << -1", PeepholeFoldConstants.SHIFT_AMOUNT_OUT_OF_BOUNDS);
}

public void testCommutativeOperators455() { 
     late = true; 
     List<String> operators = ImmutableList.of("==", "!=", "===", "!==", "*", "|", "&", "^"); 
     for (int iOperandA = 0; iOperandA < LITERAL_OPERANDS.size(); iOperandA++) { 
         for (int iOperandB = iOperandA; iOperandB < LITERAL_OPERANDS.size(); iOperandB++) { 
             for (int iOp = 0; iOp < operators.size(); iOp++) { 
                 String a = LITERAL_OPERANDS.get(iOperandA); 
                 String b = LITERAL_OPERANDS.get(iOperandB); 
                 String op = operators.get(iOp); 
                 assertSameResultsOrUncollapsed(join(a, op, b), join(b, op, a)); 
             } 
         } 
     } 
 }
public void testFoldSimpleArithmeticOp456() { 
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
public void testStringAdd457() { 
     fold("x = 'a' + \"bc\"", "x = \"abc\""); 
     fold("x = 'a' + 5", "x = \"a5a\""); 
     fold("x = 5 + 'a'", "x = \"5a\""); 
     fold("x = 'a' + ''", "x = \"a\""); 
     fold("x = \"a\" + foo()", "x = \"a\"+foo()"); 
     fold("x = foo() + 'a' + 'b'", "x = foo()+\"ab\""); 
     fold("x = (foo() + 'a') + 'b'", "x = foo()+\"ab\""); 
     fold("x = foo() + 'a' + 'b' + 'cd' + bar()", "x = foo()+\"abcd\"+bar()"); 
     fold("x = foo() + 2 + 'b'", "x = foo()+2+\"b\""); 
     fold("x = foo() + 'a' + 2", "x = foo()+\"a2\""); 
     fold("x = '' + null", "x = \"null\""); 
     fold("x = true + '' + false", "x = \"truefalse\""); 
     fold("x = '' + []", "x = ''"); 
 }
public void testIssue821458() { 
     foldSame("var a =(Math.random()>0.5? '1' : 2 ) + 3 + 4;"); 
     foldSame("var a = ((Math.random() ? 0 : 1) ||" + "(Math.random()>0.5? '1' : 2 )) + 3 + 4;"); 
 }
public void testFoldArithmetic459() { 
     fold("x = 10 + 20", "x = 30"); 
     fold("x = 2 / 4", "x = 0.5"); 
     fold("x = 2.25 * 3", "x = 6.75"); 
     fold("z = x * y", "z = x * y"); 
     fold("x = y * 5", "x = y * 5"); 
     fold("x = 1 / 0", "x = 1 / 0"); 
     fold("x = 3 % 2", "x = 1"); 
     fold("x = 3 % -2", "x = 1"); 
     fold("x = -1 % 3", "x = -1"); 
     fold("x = 1 % 0", "x = 1 % 0"); 
 }
public void testFoldLiteralNames461() { 
     foldSame("NaN == NaN"); 
     foldSame("Infinity == Infinity"); 
     foldSame("Infinity == NaN"); 
     fold("undefined == NaN", "false"); 
     fold("undefined == Infinity", "false"); 
     foldSame("Infinity >= Infinity"); 
     foldSame("NaN >= NaN"); 
 }
public void testObjectCreate5620() { 
     test("goog.object.create('a',2).toString()", "({'a':2}).toString()"); 
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
