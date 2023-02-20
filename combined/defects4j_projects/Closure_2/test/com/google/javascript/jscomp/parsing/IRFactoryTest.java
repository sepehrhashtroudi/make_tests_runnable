/*
 * Copyright 2009 The Closure Compiler Authors.
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

package com.google.javascript.jscomp.parsing;

import com.google.common.collect.Sets;
import com.google.javascript.jscomp.SourceFile;
import com.google.javascript.jscomp.parsing.Config.LanguageMode;
import com.google.javascript.jscomp.testing.TestErrorReporter;
import com.google.javascript.rhino.JSDocInfo;
import com.google.javascript.rhino.Node;
import com.google.javascript.rhino.head.CompilerEnvirons;
import com.google.javascript.rhino.head.Parser;
import com.google.javascript.rhino.head.ast.AstRoot;
import com.google.javascript.rhino.testing.BaseJSTypeTestCase;

/**
 * Tests {@link IRFactory}.
 */
public class IRFactoryTest extends BaseJSTypeTestCase {

  private LanguageMode mode = LanguageMode.ECMASCRIPT3;

  @Override
  protected void setUp() throws Exception {
    super.setUp();
    mode = LanguageMode.ECMASCRIPT3;
  }

public void testOptionNotToTraverseFunctions359() { 
     String src = "var x = 1; function f() { x = null; }"; 
     String expectedWhenNotTraversingFunctions = "digraph AST {\n" + "  node [color=lightblue2, style=filled];\n" + "  node0 [label=\"SCRIPT\"];\n" + "  node1 [label=\"VAR\"];\n" + "  node0 -> node1 [weight=1];\n" + "  node2 [label=\"NAME\"];\n" + "  node1 -> node2 [weight=1];\n" + "  node3 [label=\"NUMBER\"];\n" + "  node2 -> node3 [weight=1];\n" + "  node1 -> RETURN " + "[label=\"UNCOND\", fontcolor=\"red\", weight=0.01, color=\"red\"];\n" + "  node4 [label=\"FUNCTION\"];\n" + "  node0 -> node4 [weight=1];\n" + "  node5 [label=\"NAME\"];\n" + "  node4 -> node5 [weight=1];\n" + "  node6 [label=\"PARAM_LIST\"];\n" + "  node4 -> node6 [weight=1];\n" + "  node7 [label=\"BLOCK\"];\n" + "  node4 -> node7 [weight=1];\n" + "  node8 [label=\"EXPR_RESULT\"];\n" + "  node7 -> node8 [weight=1];\n" + "  node9 [label=\"ASSIGN\"];\n" + "  node8 -> node9 [weight=1];\n" + "  node10 [label=\"NAME\"];\n" + "  node9 -> node10 [weight=1];\n" + "  node11 [label=\"NULL\"];\n" + "  node9 -> node11 [weight=1];\n" + "  node0 -> node1 " + "[label=\"UNCOND\", fontcolor=\"red\", weight=0.01, color=\"red\"];\n" + "}\n";
}

public void testObjectLitLocation810() { 
     Node root = newParse("var foo =\n" + "{ \n" + "'A' : 'A', \n" + "'B' : 'B', \n" + "'C' :\n" + "    'C' \n" + "};\n"); 
     Node firstVarDecl = root.getFirstChild(); 
     Node firstVar = firstVarDecl.getFirstChild(); 
     Node firstObjectLit = firstVar.getFirstChild(); 
     Node firstKey = firstObjectLit.getFirstChild(); 
     Node firstValue = firstKey.getFirstChild(); 
     Node secondKey = firstKey.getNext(); 
     Node secondValue = secondKey.getFirstChild(); 
     Node thirdKey = secondKey.getNext(); 
     Node thirdValue = thirdKey.getFirstChild(); 
     assertNodePosition(1, 4, firstVar); 
     assertNodePosition(2, 0, firstObjectLit); 
     assertNodePosition(3, 0, firstKey); 
     assertNodePosition(3, 6, firstValue); 
     assertNodePosition(4, 0, secondKey); 
     assertNodePosition(4, 6, secondValue); 
     assertNodePosition(5, 0, thirdKey); 
     assertNodePosition(6, 4, thirdValue); 
 }
public void testLabel3811() { 
     testNewParser("Foo:Bar:X:{ break Bar; }", "SCRIPT 1 [source_file: FileName.js] [length: 24]\n" + "    LABEL 1 [source_file: FileName.js] [length: 4]\n" + "        LABEL_NAME Foo 1 [source_file: FileName.js] [length: 4]\n" + "        EXPR_RESULT 1 [source_file: FileName.js] [length: 3]\n" + "            NAME Bar 1 [source_file: FileName.js] [length: 3]\n"); 
 }
public void testLabel812() { 
     testNewParser("foo: bar", "SCRIPT 1 [source_file: FileName.js] [length: 8]\n" + "    LABEL 1 [source_file: FileName.js] [length: 4]\n" + "        LABEL_NAME foo 1 [source_file: FileName.js] [length: 4]\n" + "        EXPR_RESULT 1 [source_file: FileName.js] [length: 3]\n" + "            NAME bar 1 [source_file: FileName.js] [length: 3]\n"); 
 }
public void testLabel3813() { 
     testNewParser("Foo:Bar:X:{ break Bar; }", "SCRIPT 1 [source_file: FileName.js] [length: 24]\n" + "    LABEL 1 [source_file: FileName.js] [length: 4]\n" + "        LABEL_NAME Foo 1 [source_file: FileName.js] [length: 4]\n" + "        LABEL 1 [source_file: FileName.js] [length: 4]\n" + "            LABEL_NAME Bar 1 [source_file: FileName.js] [length: 4]\n" + "            LABEL 1 [source_file: FileName.js] [length: 2]\n" + "                LABEL_NAME X 1 [source_file: FileName.js] [length: 2]\n" + "                BLOCK 1 [source_file: FileName.js] [length: 14]\n" + "                    BREAK 1 [source_file: FileName.js] [length: 10]\n" + "                        LABEL_NAME Bar 1 [source_file: FileName.js] [length: 3]\n"); 
 }
public void testNegation2816() { 
     testNewParser("-2", "SCRIPT 1 [source_file: FileName.js] [length: 2]\n" + "    EXPR_RESULT 1 [source_file: FileName.js] [length: 2]\n" + "        NUMBER -2.0 1 [source_file: FileName.js] [length: 1]\n"); 
 }
  

  

  

  

  

  

  

  

  

  

  

  // The old and new parser produce different results now with labels, and
  // named breaks and continues, so disable these tests.
  

  

  

  

  

  

  

  

  

  

  

  

  

  

   

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  final String INVALID_ASSIGNMENT_TARGET = "invalid assignment target";
  final String INVALID_INCREMENT_TARGET = "invalid increment target";
  final String INVALID_DECREMENT_TARGET = "invalid decrement target";

  final String INVALID_INC_OPERAND = "Invalid increment operand";
  final String INVALID_DEC_OPERAND = "Invalid decrement operand";

  

  private void testNoParseError(String string) {
    testParseError(string, (String)null);
  }

  private void testParseError(String string, String error) {
    testParseError(string, error == null ? null : new String[] { error });
  }

  private void testParseError(String string, String[] errors) {
    Node root = newParse(string, new TestErrorReporter(errors, null));
    assertTrue("unexpected warnings reported",
        errorReporter.hasEncounteredAllWarnings());
    assertTrue("expected error were not reported",
        errorReporter.hasEncounteredAllErrors());
  }

  private void assertMarkerPosition(Node n, int lineno, int charno) {
    int count = 0;
    for (JSDocInfo.Marker marker : n.getJSDocInfo().getMarkers()) {
      assertEquals(lineno, marker.getAnnotation().getStartLine());
      assertEquals(charno, marker.getAnnotation().getPositionOnStartLine());
      count++;
    }
    assertEquals(1, count);
  }

  private void assertNodePosition(int lineno, int charno, Node n) {
    assertEquals("Line number", lineno, n.getLineno());
    assertEquals("Column position", charno, n.getCharno());
  }

  private void assertNodePosition(int lineno, int charno, int length, Node n) {
    assertEquals("Line number", lineno, n.getLineno());
    assertEquals("Column position", charno, n.getCharno());
    assertEquals("Length", length, n.getLength());
  }


  private void testNewParser(String code, String expected) {
    String actual = newParse(code).toStringTree();
    assertEquals(expected, actual);
  }

  private Node newParse(String string) {
    return newParse(string, new TestErrorReporter(null, null));
  }

  private Node newParse(String string, TestErrorReporter errorReporter) {
    CompilerEnvirons environment = new CompilerEnvirons();

    environment.setRecordingComments(true);
    environment.setRecordingLocalJsDocComments(true);

    Parser p = new Parser(environment);
    AstRoot script = p.parse(string, null, 1);

    Config config = ParserRunner.createConfig(true, mode, false);
    Node root = IRFactory.transformTree(
        script, SourceFile.fromCode("FileName.js", string), string, config, errorReporter);

    return root;
  }
}
