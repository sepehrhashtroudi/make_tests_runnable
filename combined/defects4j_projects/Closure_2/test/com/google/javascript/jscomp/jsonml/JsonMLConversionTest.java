/*
 * Copyright 2010 The Closure Compiler Authors.
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

package com.google.javascript.jscomp.jsonml;

import com.google.common.base.Preconditions;
import com.google.javascript.jscomp.Compiler;
import com.google.javascript.jscomp.CompilerPass;
import com.google.javascript.jscomp.CompilerTestCase;
import com.google.javascript.rhino.Token;
import com.google.javascript.jscomp.jsonml.Writer;
import com.google.javascript.jscomp.jsonml.JsonML;
import com.google.javascript.jscomp.jsonml.JsonMLAst;
import com.google.javascript.jscomp.jsonml.JsonMLUtil;

import com.google.javascript.rhino.Node;

import com.google.caja.parser.js.JsonMLParser;

/**
 * Tests for parsing JsonML to AST and vice versa.
 * @author dhans@google.com (Daniel Hans)
 *
 */
public class JsonMLConversionTest extends CompilerTestCase {

  @Override
  public CompilerPass getProcessor(Compiler compiler) {
    return null; // unused
  }

  @Override
  public void setUp() {
    enableEcmaScript5(true);
  }

  private void testJsonMLToAstConversion(String js) throws Exception {
    JsonML jsonml = JsonMLParser.parse(js);
    Node root = parseExpectedJs(js);
    Node ast = root.getFirstChild();
    Preconditions.checkState(ast.getType() == Token.SCRIPT);

    testJsonMLToAstConversion(ast, jsonml, js);
  }

  private void testJsonMLToAstConversion(Node astRoot, JsonML jsonmlRoot,
      String js) {
    Compiler compiler = new Compiler();
    JsonMLAst ast = new JsonMLAst(jsonmlRoot);
    Node resultAstRoot = ast.getAstRoot(compiler);

    String explanation = resultAstRoot.checkTreeEquals(astRoot);
    assertNull("JsonML -> AST converter returned incorect result for " + js
       + "\n" + explanation, explanation);
  }

  private void testAstToJsonMLConverstion(Node astRoot, JsonML jsonmlRoot,
      String js) {
    JsonML resultJsonMLRoot = (new Writer()).processAst(astRoot);
    String explanation = JsonMLUtil.compare(resultJsonMLRoot, jsonmlRoot);
    assertNull("AST -> JsonML converter returned incorrect result for " + js +
        "\n" + explanation, explanation);
  }

  private void testConversion(String js) throws Exception {
    JsonML jsonml = JsonMLParser.parse(js);
    Node root = parseExpectedJs(js);
    Node ast = root.getFirstChild();
    Preconditions.checkState(ast.getType() == Token.SCRIPT);

    testJsonMLToAstConversion(ast, jsonml, js);

    jsonml = JsonMLParser.parse(js);
    testAstToJsonMLConverstion(ast, jsonml, js);
  }

public void testUnaryExpressions337() throws Exception { 
     testConversion("!x"); 
     testConversion("!null"); 
     testConversion("!3.14"); 
     testConversion("!true"); 
     testConversion("~x"); 
     testConversion("~null"); 
     testConversion("~3.14"); 
     testConversion("~true"); 
     testConversion("+x"); 
     testConversion("+null"); 
     testConversion("+3.14"); 
     testConversion("+true"); 
     testConversion("-x"); 
     testConversion("-null"); 
     testConversion("-true"); 
     testConversion("!~+-z"); 
     testConversion("void x"); 
     testConversion("void null"); 
     testConversion("void void !x"); 
     testConversion("void (x + 1)"); 
 }
public void testFor338() throws Exception { 
     testConversion("for (;true;) {;}"); 
     testJsonMLToAstConversion("for (i = 0; i < 10; ++i) x++"); 
     testConversion("for (i = 0; i < 10; ++i) {x++}"); 
     testConversion("for (i = 0; i < 10; ++i) {2 + 3; q = 2 + 3; " + "var v = y * z; g = function(a) {true; var b = a + 1;" + "return a * a}}"); 
     testConversion("for(;true;) {break}"); 
     testConversion("for(i = 0; i < 10; ++i) {if (i > 5) {break}}"); 
     testConversion("s: for(i = 0; i < 10; ++i) {if (i > 5) {break s}}"); 
     testConversion("for (i = 0;true; ++i) {" + "if (i % 2) {continue} else {var x = i / 3; f(x)}}"); 
 }
public void testDelete340() throws Exception { 
     testConversion("delete a"); 
     testConversion("delete a.x"); 
     testConversion("delete a[0]"); 
     testConversion("delete a.x[0]"); 
 }
public void testObject341() throws Exception { 
     testConversion("x = {}"); 
     testConversion("var x = {}"); 
     testConversion("x = {x: 1, y: 2}"); 
     testConversion("x = {x: null}"); 
     testConversion("x = {a: function f() {}}"); 
     testConversion("x = {a: f()}"); 
     testConversion("x = {a: function f() {2 + 3; q = 2 + 3; var v = y * z; " + "g = function(a) {true; var b = a + 1; return a * a}}}"); 
     testConversion("x = {get a() {return 1}}"); 
     testConversion("x = {set a(b) {}}"); 
 }
public void testLogicalExpr344() throws Exception { 
     testConversion("a && b"); 
     testConversion("a || b"); 
     testConversion("a && b || c"); 
     testConversion("a && (b || c)"); 
     testConversion("f(x) && (function (x) {" + "return x % 2 == 0 })(z) || z % 3 == 0 ? true : false"); 
 }
public void testTypeof440() throws Exception { 
     testConversion("!x"); 
     testConversion("!null"); 
     testConversion("!3.14"); 
     testConversion("!true"); 
     testConversion("~x"); 
     testConversion("~null"); 
     testConversion("~3.14"); 
     testConversion("~true"); 
     testConversion("+x"); 
     testConversion("+null"); 
     testConversion("+3.14"); 
     testConversion("+true"); 
     testConversion("-x"); 
     testConversion("-null"); 
     testConversion("-true"); 
     testConversion("!~+-z"); 
     testConversion("void x"); 
     testConversion("void null"); 
     testConversion("void void !x"); 
     testConversion("void (x + 1)"); 
 }
public void testTypeof764() throws Exception { 
     testConversion("x instanceof Null"); 
     testConversion("!x instanceof A"); 
     testConversion("!(x instanceof A)"); 
     testConversion("'a' in x"); 
     testConversion("if('a' in x) {f(x)}"); 
     testConversion("undefined in A"); 
     testConversion("!(Number(1) in [2, 3, 4])"); 
     testConversion("true ? x : y"); 
     testConversion("(function() {var y = 2 + 3 * 4; return y >> 1})() ? x : y"); 
 }
  

  

  

  

  
  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  
}
