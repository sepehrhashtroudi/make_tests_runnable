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

public void testFor140() { 
     test("a = 0; for(; a < 2 ; a++) foo()", "for(a = 0; a < 2 ; a++) foo();"); 
     test("var a = 0; for(; c < b ; c++) foo()", "for(var a = 0; c < b ; c++) foo()"); 
     testSame("var a = 0; a:for(; c < b ; c++) foo()"); 
     testSame("var a = 0; a:b:for(; c < b ; c++) foo()"); 
     test("if(x){var a = 0; for(; c < b; c++) foo()}", "if(x){for(var a = 0; c < b; c++) foo()}"); 
     test("init(); for(; a < 2 ; a++) foo()", "for(init(); a < 2 ; a++) foo();"); 
     test("function f(){ var a; for(; a < 2 ; a++) foo() }", "function f(){ for(var a; a < 2 ; a++) foo() }"); 
     testSame("function f(){ return; for(; a < 2 ; a++) foo() }"); 
 }
public void testIgnoredOps145() { 
     testSame("function foo() { this.length-- }"); 
     testSame("function foo() { this.length++ }"); 
     testSame("function foo() { this.length+=5 }"); 
     testSame("function foo() { this.length-=5 }"); 
 }
public void testDirectives306() throws Exception { 
     testConversion("'use strict'"); 
     testConversion("function foo() {'use strict'}"); 
     testConversion("'use strict'; function foo() {'use strict'}"); 
 }
public void testFunctions307() throws Exception { 
     testConversion("(function () {})"); 
     testConversion("(function (x, y) {})"); 
     testConversion("(function () {})()"); 
     testConversion("(function (x, y) {})()"); 
     testConversion("[ function f() {} ]"); 
     testConversion("var f = function f() {};"); 
     testConversion("for (function f() {};true;) {}"); 
     testConversion("x = (function (x, y) {})"); 
     testConversion("function f() {}"); 
     testConversion("for (;true;) { function f() {} }"); 
     testConversion("function f() {;}"); 
     testConversion("function f() {x}"); 
     testConversion("function f() {x;y;z}"); 
     testConversion("function f() {{}}"); 
 }
public void testDoWhile324() throws Exception { 
     testConversion("do {} while (true)"); 
     testConversion("do {;} while (true)"); 
     testConversion("do {} while (f(x, y))"); 
     testConversion("do {} while (f(f(f(x, y))))"); 
     testConversion("do {} while ((f(f(f(x, y))))())"); 
     testConversion("do {2 + 3; q = 2 + 3; var v = y * z;" + "g = function(a) {true; var b = a + 1; return a * a}} while (--x)"); 
 }
public void testSwitch328() throws Exception { 
     testConversion("switch (x) {}"); 
     testConversion("switch (x) {case 'a':}"); 
     testConversion("switch (x) {case 'a':case 'b':}"); 
     testConversion("switch (x) {case 'a':case 'b': x}"); 
     testConversion("switch (x) {case 'a':case 'b': {;}}"); 
     testConversion("switch (x) {case 'a':case 'b': f()}"); 
     testConversion("switch (x) {case 'x': case 'y': {;} case 'a':case 'b': f()}"); 
     testConversion("switch (x) {case 'a': f(x)}"); 
     testConversion("switch (x) {case 'a': {f()} {g(x)}}"); 
     testConversion("switch (x) {case 'a': f(); g(x)}"); 
     testConversion("switch (x) {default: ;}"); 
     testConversion("switch (x) {default:case 'a': ;}"); 
     testConversion("switch (x) {case 'a':case'b':default: f()}"); 
     testConversion("switch (x) {default:f(x); g(); case 'a': ; case 'b': g(x)}"); 
     testConversion("switch (x) {case 'a': default: {f(x); g(z)} case 'b': g(x)}"); 
     testConversion("switch (x) {case x: {;}}"); 
 }
public void testDelete330() throws Exception { 
     testConversion("delete a"); 
     testConversion("delete a.x"); 
     testConversion("delete a[0]"); 
     testConversion("delete a.x[0]"); 
 }
public void testSetter331() throws Exception { 
     testConversion("this"); 
     testConversion("var x = this"); 
     testConversion("this.foo()"); 
     testConversion("var x = this.foo()"); 
     testConversion("this.bar"); 
     testConversion("var x = this.bar()"); 
     testConversion("switch(this) {}"); 
     testConversion("x + this"); 
 }
public void testSetter763() throws Exception { 
     testConversion("set a(b)"); 
     testConversion("set a(b)"); 
     testConversion("set a(b) {case 'a':}"); 
     testConversion("set a(b) {case 'a':case 'b': x}"); 
     testConversion("set a(b) {case 'a':case 'b': {;}}"); 
     testConversion("set a(b) {case 'a':case 'b': f()}"); 
     testConversion("set a(b) {case 'x': case 'y': {;} case 'a':case 'b': f()}"); 
     testConversion("set a(b) {case 'a': f(x)}"); 
     testConversion("set a(b) {case 'a': {f()} {g(x)}}"); 
     testConversion("set a(b) {case 'a': f(); g(x)}"); 
     testConversion("set a(b) {default: ;}"); 
     testConversion("set a(b) {default:case 'a': ;}"); 
     testConversion("set a(b) {case 'a':case'b':default: f()}"); 
     testConversion("set a(b) {default:f(x); g(); case 'a': ; case 'b': g(x)}"); 
     testConversion("set a(b) {case 'a': default: {f(x); g(z)} case 'b': g(x)}"); 
     testConversion("set a(b) {case x: {;}}"); 
 }
  

  

  

  

  
  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  
}
