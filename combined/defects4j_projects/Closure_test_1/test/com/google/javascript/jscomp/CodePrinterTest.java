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
import com.google.common.collect.Lists;
import com.google.javascript.jscomp.CompilerOptions.LanguageMode;
import com.google.javascript.rhino.InputId;
import com.google.javascript.rhino.Node;
import com.google.javascript.rhino.Token;

import junit.framework.TestCase;

import java.util.List;

public class CodePrinterTest extends TestCase {
  boolean trustedStrings = true;

  @Override public void setUp() {
    trustedStrings = true;
  }

  Node parse(String js) {
    return parse(js, false);
  }

  Node parse(String js, boolean checkTypes) {
    Compiler compiler = new Compiler();
    CompilerOptions options = new CompilerOptions();
    options.setTrustedStrings(trustedStrings);

    // Allow getters and setters.
    options.setLanguageIn(LanguageMode.ECMASCRIPT5);
    compiler.initOptions(options);
    Node n = compiler.parseTestCode(js);

    if (checkTypes) {
      DefaultPassConfig passConfig = new DefaultPassConfig(null);
      CompilerPass typeResolver = passConfig.resolveTypes.create(compiler);
      Node externs = new Node(Token.SCRIPT);
      externs.setInputId(new InputId("externs"));
      Node externAndJsRoot = new Node(Token.BLOCK, externs, n);
      externAndJsRoot.setIsSyntheticBlock(true);
      typeResolver.process(externs, n);
      CompilerPass inferTypes = passConfig.inferTypes.create(compiler);
      inferTypes.process(externs, n);
    }

    checkUnexpectedErrorsOrWarnings(compiler, 0);
    return n;
  }

  private static void checkUnexpectedErrorsOrWarnings(
      Compiler compiler, int expected) {
    int actual = compiler.getErrors().length + compiler.getWarnings().length;
    if (actual != expected) {
      String msg = "";
      for (JSError err : compiler.getErrors()) {
        msg += "Error:" + err.toString() + "\n";
      }
      for (JSError err : compiler.getWarnings()) {
        msg += "Warning:" + err.toString() + "\n";
      }
      assertEquals("Unexpected warnings or errors.\n " + msg, expected, actual);
    }
  }

  String parsePrint(String js, boolean prettyprint, int lineThreshold) {
    CompilerOptions options = new CompilerOptions();
    options.setTrustedStrings(trustedStrings);
    options.setPrettyPrint(prettyprint);
    options.setLineLengthThreshold(lineThreshold);
    return new CodePrinter.Builder(parse(js)).setCompilerOptions(options)
        .build();
  }

  String parsePrint(String js, boolean prettyprint, boolean lineBreak,
      int lineThreshold) {
    CompilerOptions options = new CompilerOptions();
    options.setTrustedStrings(trustedStrings);
    options.setPrettyPrint(prettyprint);
    options.setLineLengthThreshold(lineThreshold);
    options.setLineBreak(lineBreak);
    return new CodePrinter.Builder(parse(js)).setCompilerOptions(options)
        .build();
  }

  String parsePrint(String js, boolean prettyprint, boolean lineBreak,
      boolean preferLineBreakAtEof, int lineThreshold) {
    CompilerOptions options = new CompilerOptions();
    options.setTrustedStrings(trustedStrings);
    options.setPrettyPrint(prettyprint);
    options.setLineLengthThreshold(lineThreshold);
    options.setPreferLineBreakAtEndOfFile(preferLineBreakAtEof);
    options.setLineBreak(lineBreak);
    return new CodePrinter.Builder(parse(js)).setCompilerOptions(options)
        .build();
  }

  String parsePrint(String js, boolean prettyprint, boolean lineBreak,
      int lineThreshold, boolean outputTypes) {
    CompilerOptions options = new CompilerOptions();
    options.setTrustedStrings(trustedStrings);
    options.setPrettyPrint(prettyprint);
    options.setLineLengthThreshold(lineThreshold);
    options.setLineBreak(lineBreak);
    return new CodePrinter.Builder(parse(js, true)).setCompilerOptions(options)
        .setOutputTypes(outputTypes)
        .build();
  }

  String parsePrint(String js, boolean prettyprint, boolean lineBreak,
                    int lineThreshold, boolean outputTypes,
                    boolean tagAsStrict) {
    CompilerOptions options = new CompilerOptions();
    options.setTrustedStrings(trustedStrings);
    options.setPrettyPrint(prettyprint);
    options.setLineLengthThreshold(lineThreshold);
    options.setLineBreak(lineBreak);
    return new CodePrinter.Builder(parse(js, true)).setCompilerOptions(options)
        .setOutputTypes(outputTypes)
        .setTagAsStrict(tagAsStrict)
        .build();
  }


  String printNode(Node n) {
    CompilerOptions options = new CompilerOptions();
    options.setLineLengthThreshold(CodePrinter.DEFAULT_LINE_LENGTH_THRESHOLD);
    return new CodePrinter.Builder(n).setCompilerOptions(options).build();
  }

  void assertPrintNode(String expectedJs, Node ast) {
    assertEquals(expectedJs, printNode(ast));
  }

public void testPrettyPrinter400() { 
     assertPrettyPrint("(function(){})();", "(function() {\n})();\n"); 
     assertPrettyPrint("var a = (function() {});alert(a);", "var a = function() {\n};\nalert(a);\n"); 
     assertPrettyPrint("if (1) {}", "if(1) {\n" + "}\n"); 
     assertPrettyPrint("if (1) {alert(\"\");}", "if(1) {\n" + "  alert(\"\")\n" + "}\n"); 
     assertPrettyPrint("if (1)alert(\"\");", "if(1) {\n" + "  alert(\"\")\n" + "}\n"); 
     assertPrettyPrint("if (1) {alert();alert();}", "if(1) {\n" + "  alert();\n" + "  alert()\n" + "}\n"); 
     assertPrettyPrint("label: alert();", "label:alert();\n"); 
     assertPrettyPrint("if (1) alert();", "if(1) {\n" + "  alert()\n" + "}\n"); 
     assertPrettyPrint("for (;;) alert();", "for(;;) {\n" + "  alert()\n" + "}\n"); 
     assertPrettyPrint("while (1) alert();", "while(1) {\n" + "  alert()\n" + "}\n"); 
     assertPrettyPrint("if (1) {} else {alert(a);}", "if(1) {\n" + "}else {\n  alert(a)\n}\n"); 
     assertPrettyPrint("if (1) alert(a); else alert(b);", "if(1) {\n" + "  alert(a)\n" + "}else {\n" + "  alert(b)\n" + "}\n"); 
     assertPrettyPrint("for(;;) { alert();}", "for(;;) {\n" + "  alert()\n" + "}\n");
}

public void testTypeAnnotationsImplements787() { 
     assertTypeAnnotations("var a = {};" + "/** @constructor */ a.Foo = function(){};\n" + "/** @interface */ a.I = function(){};\n" + "/** @interface */ a.I2 = function(){};\n" + "/** @constructor \n @extends {a.Foo}\n" + " * @implements {a.I} \n @implements {a.I2}\n" + "*/ a.Bar = function(){}", "var a = {};\n" + "/**\n * @return {undefined}\n * @constructor\n */\n" + "a.Foo = function() {\n};\n" + "/**\n * @interface\n */\n" + "a.I = function() {\n};\n" + "/**\n * @interface\n */\n" + "a.I2 = function() {\n};\n" + "/**\n * @return {undefined}\n * @extends {a.Foo}\n" + " * @implements {a.I}\n" + " * @implements {a.I2}\n * @constructor\n */\n" + "a.Bar = function() {\n};\n"); 
 }
  

  

  

  

  

  

  

  private void assertPrint(String js, String expected) {
    parse(expected); // validate the expected string is valid JS
    assertEquals(expected,
        parsePrint(js, false, CodePrinter.DEFAULT_LINE_LENGTH_THRESHOLD));
  }

  private void assertPrintSame(String js) {
    assertPrint(js, js);
  }

  // Make sure that the code generator doesn't associate an
  // else clause with the wrong if clause.
  

  

  private void assertLineBreak(String js, String expected) {
    assertEquals(expected,
        parsePrint(js, false, true,
            CodePrinter.DEFAULT_LINE_LENGTH_THRESHOLD));
  }

  

  private void assertLineBreakAtEndOfFile(String js,
      String expectedWithoutBreakAtEnd, String expectedWithBreakAtEnd) {
    assertEquals(expectedWithoutBreakAtEnd,
        parsePrint(js, false, false, false, 30));
    assertEquals(expectedWithBreakAtEnd,
        parsePrint(js, false, false, true, 30));
  }

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  private void assertPrettyPrint(String js, String expected) {
    assertEquals(expected,
        parsePrint(js, true, false,
            CodePrinter.DEFAULT_LINE_LENGTH_THRESHOLD));
  }

  private void assertTypeAnnotations(String js, String expected) {
    assertEquals(expected,
        parsePrint(js, true, false,
            CodePrinter.DEFAULT_LINE_LENGTH_THRESHOLD, true));
  }

  

  

  

  private void assertLineLength(String js, String expected) {
    assertEquals(expected,
        parsePrint(js, false, true, 10));
  }

  

  private void testReparse(String code) {
    Compiler compiler = new Compiler();
    Node parse1 = parse(code);
    Node parse2 = parse(new CodePrinter.Builder(parse1).build());
    String explanation = parse1.checkTreeEquals(parse2);
    assertNull("\nExpected: " + compiler.toSource(parse1) +
        "\nResult: " + compiler.toSource(parse2) +
        "\n" + explanation, explanation);
  }

  

  

  

  // Make sure to test as both a String and a Node, because
  // negative numbers do not parse consistently from strings.
  private void assertPrintNumber(String expected, double number) {
    assertPrint(String.valueOf(number), expected);
    assertPrintNode(expected, Node.newNumber(number));
  }

  private void assertPrintNumber(String expected, int number) {
    assertPrint(String.valueOf(number), expected);
    assertPrintNode(expected, Node.newNumber(number));
  }

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  
}
