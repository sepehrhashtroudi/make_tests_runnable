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

public void testAssignmentValidation521() { 
     testNoParseError("x=1"); 
     testNoParseError("x.y=1"); 
     testNoParseError("f().y=1"); 
     testParseError("(x||y)=1", INVALID_ASSIGNMENT_TARGET); 
     testParseError("(x?y:z)=1", INVALID_ASSIGNMENT_TARGET); 
     testParseError("f()=1", INVALID_ASSIGNMENT_TARGET); 
     testNoParseError("x+=1"); 
     testNoParseError("x.y+=1"); 
     testNoParseError("f().y+=1"); 
     testParseError("(x||y)+=1", INVALID_ASSIGNMENT_TARGET); 
     testParseError("(x?y:z)+=1", INVALID_ASSIGNMENT_TARGET); 
     testParseError("f()+=1", INVALID_ASSIGNMENT_TARGET); 
     testParseError("f()++", INVALID_INCREMENT_TARGET); 
     testParseError("f()--", INVALID_DECREMENT_TARGET); 
     testParseError("++f()", INVALID_INCREMENT_TARGET); 
     testParseError("--f()", INVALID_DECREMENT_TARGET); 
 }
public void testTryWithoutFinallyLocation522() { 
     Node root = newParse("try {\n" + "  var x = 1;\n" + "} catch (ex) {\n" + "  var y = 2;\n" + "}\n"); 
     Node tryStmt = root.getFirstChild(); 
     Node tryBlock = tryStmt.getFirstChild(); 
     Node catchBlock = tryBlock.getNext(); 
     Node catchStmt = catchBlock.getFirstChild(); 
     Node exceptionVar = catchStmt.getFirstChild(); 
     Node exceptionBlock = exceptionVar.getNext(); 
     Node varDecl = exceptionBlock.getFirstChild(); 
     assertNodePosition(1, 0, tryStmt); 
     assertNodePosition(1, 4, tryBlock); 
     assertNodePosition(3, 0, catchBlock); 
     assertNodePosition(3, 2, catchStmt); 
     assertNodePosition(3, 9, exceptionVar); 
     assertNodePosition(3, 13, exceptionBlock); 
     assertNodePosition(4, 2, varDecl); 
 }
public void testIfLocation523() { 
     Node root = newParse("if\n" + "  (a == 3)\n" + "{\n" + "  b = 0;\n" + "}\n" + "  else\n" + "{\n" + "  c = 1;\n" + "}\n"); 
     Node ifStmt = root.getFirstChild(); 
     Node eqClause = ifStmt.getFirstChild(); 
     Node thenClause = eqClause.getNext(); 
     Node elseClause = thenClause.getNext(); 
     assertNodePosition(1, 0, ifStmt); 
     assertNodePosition(2, 3, eqClause); 
     assertNodePosition(3, 0, thenClause); 
     assertNodePosition(7, 0, elseClause); 
 }
public void testCommentPositions1524() { 
     Node root = newParse("/** @param {string} x */function a(x) {};" + "/** @param {string} x */function b(x) {}"); 
     Node a = root.getFirstChild(); 
     Node b = root.getLastChild(); 
     assertMarkerPosition(a, 1, 4); 
     assertMarkerPosition(b, 1, 45); 
 }
public void testObjectLiteral2525() { 
     newParse("var o = {a: 1}"); 
 }
public void testStrictScript526() throws Exception { 
     assertNull(newParse("").getDirectives()); 
     assertEquals(Sets.newHashSet("use strict"), newParse("'use strict'").getDirectives()); 
 }
public void testFunctionParamLocation530() { 
     Node root = newParse("function\n" + "     foo(a,\n" + "     b,\n" + "     c)\n" + "{}\n"); 
     Node function = root.getFirstChild(); 
     Node functionName = function.getFirstChild(); 
     Node params = functionName.getNext(); 
     Node param1 = params.getFirstChild(); 
     Node param2 = param1.getNext(); 
     Node param3 = param2.getNext(); 
     Node body = params.getNext(); 
     assertNodePosition(1, 0, function); 
     assertNodePosition(2, 5, functionName); 
     assertNodePosition(2, 8, params); 
     assertNodePosition(2, 9, param1); 
     assertNodePosition(3, 5, param2); 
     assertNodePosition(4, 5, param3); 
     assertNodePosition(5, 0, body); 
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
