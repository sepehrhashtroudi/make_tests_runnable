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

public void testTry346() throws Exception { 
     testConversion("try {} catch (e) {}"); 
     testConversion("try {;} catch (e) {;}"); 
     testConversion("try {var x = 0; y / x} catch (e) {f(e)}"); 
     testConversion("try {2 + 3; q = 2 + 3; var v = y * z; " + "g = function(a) {true; var b = a + 1; h(q); return a * a}; " + "h(q)} catch (e) {f(x)}"); 
     testConversion("try {} finally {}"); 
     testConversion("try {;} finally {;}"); 
     testConversion("try {var x = 0; y / x} finally {f(y)}"); 
     testConversion("try {2 + 3; q = 2 + 3; var v = y * z; " + "g = function(a) {true; var b = a + 1; h(q); return a * a}; " + "h(q)} finally {f(x)}"); 
     testConversion("try {} catch (e) {} finally {}"); 
     testConversion("try {;} catch (e) {;} finally {;}"); 
     testConversion("try {var x = 0; y / x} catch (e) {;} finally {;}"); 
     testConversion("try {2 + 3; q = 2 + 3; var v = y * z; " + "g = function(a) {true; var b = a + 1; h(q); return a * a}; h(q)} " + "catch (e) {f(x)} finally {f(x)}"); 
 }
public void testFor387() throws Exception { 
     testConversion("for (;true;) {;}"); 
     testJsonMLToAstConversion("for (i = 0; i < 10; ++i) x++"); 
     testConversion("for (i = 0; i < 10; ++i) {x++}"); 
     testConversion("for (i = 0; i < 10; ++i) {2 + 3; q = 2 + 3; " + "var v = y * z; g = function(a) {true; var b = a + 1;" + "return a * a}}"); 
     testConversion("for(;true;) {break}"); 
     testConversion("for(i = 0; i < 10; ++i) {if (i > 5) {break}}"); 
     testConversion("s: for(i = 0; i < 10; ++i) {if (i > 5) {break s}}"); 
     testConversion("for (i = 0;true; ++i) {" + "if (i % 2) {continue} else {var x = i / 3; f(x)}}"); 
 }
public void testThis388() throws Exception { 
     testConversion("this"); 
     testConversion("var x = this"); 
     testConversion("this.foo()"); 
     testConversion("var x = this.foo()"); 
     testConversion("this.bar"); 
     testConversion("var x = this.bar()"); 
     testConversion("switch(this) {}"); 
     testConversion("x + this"); 
 }
public void testDelete781() throws Exception { 
     testConversion("delete x"); 
     testConversion("delete {x: 1, y: 2}"); 
     testConversion("delete x.a; delete x.b;"); 
     testConversion("delete {x: null}"); 
     testConversion("delete {a: function f() {}}"); 
     testConversion("delete {a: f()}"); 
     testConversion("delete {a: function f() {2 + 3; q = 2 + 3; var v = y * z; " + "g = function(a) {true; var b = a + 1; return a * a}}}"); 
     testConversion("delete {get a() {return 1}}"); 
     testConversion("delete {set a(b) {}}"); 
 }
public void testDelete782() throws Exception { 
     testConversion("var x = {};"); 
     testConversion("var x = {}"); 
     testConversion("x = {x: 1, y: 2}"); 
     testConversion("x = {x: null}"); 
     testConversion("x = {a: function f() {}}"); 
     testConversion("x = {a: f()}"); 
     testConversion("x = {a: function f() {2 + 3; q = 2 + 3; var v = y * z; " + "g = function(a) {true; var b = a + 1; return a * a}}}"); 
     testConversion("x = {get a() {return 1}}"); 
     testConversion("x = {set a(b) {}}"); 
 }
  

  

  

  

  
  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  
}
