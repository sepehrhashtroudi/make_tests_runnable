/*
 * Copyright 2008 The Closure Compiler Authors.
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

import com.google.javascript.rhino.Node;

/**
 * Unit tests for {@link CoalesceVariableNames}
 *
 */
public class CoalesceVariableNamesTest extends CompilerTestCase {
  // The spacing in this file is not exactly standard but it greatly helps
  // picking out which variable names are merged.

  private boolean usePseudoName = false;

  @Override
  protected int getNumRepetitions() {
   return 1;
  }

  @Override
  public void setUp() {
    super.enableLineNumberCheck(true);
    usePseudoName = false;
  }

  @Override
  public CompilerPass getProcessor(final Compiler compiler) {
    return new CompilerPass() {
      @Override
      public void process(Node externs, Node js) {
        NodeTraversal.traverse(compiler, js,
            new CoalesceVariableNames(compiler, usePseudoName));
      }
    };
  }

public void testForIn322() { 
     inFunction("var x = {}; for (var y in x) { y() }"); 
     inFunction("var x, y, z; x = {}; z = {}; for (y in x = z) { y() }", "var x, y, z;   ({}); z = {}; for (y in z)     { y() }"); 
     inFunction("var x, y, z; x = {}; z = {}; for (y[z=1] in z) { y() }", "var x, y, z;   ({}); z = {}; for (y[z=1] in z) { y() }"); 
     inFunction("var x, y, z; x = {}; z = {}; for (x in z) { x() }"); 
 }
public void testMaxVars513() { 
     String code = ""; 
     for (int i = 0; i < LiveVariablesAnalysis.MAX_VARIABLES_TO_ANALYZE + 1; i++) { 
         code += String.format("var x%d = 0; print(x%d);", i, i); 
     } 
     inFunction(code); 
 }
public void testForIn514() { 
     inFunction("var x = 1, k; x;      ; for (var y in k) { y }", "var x = 1, k; x;      ; for (var y in k) { y }"); 
     inFunction("var x = 1, k; x; y = 1; for (var y in k) { y }", "var x = 1, k; x; x = 1; for (    x in k) { x }"); 
 }
public void testMultiPaths515() { 
     inFunction("var x,y; if(x)y=1;", "var x,y; if(x)1;"); 
     inFunction("var x,y; if(x)y=1; y=2; x(y)", "var x,y; if(x)1; y=2; x(y)"); 
     inFunction("var x; switch(x) { case(1): x=1; break; } x"); 
     inFunction("var x; switch(x) { case(1): x=1; break; }", "var x; switch(x) { case(1): 1; break; }"); 
 }
public void testParameter4516() { 
     test("function FUNC(x, y) {var a,b; y; a=0; a; x; b=0; b}", "function FUNC(x, y) {var a; y; a=0; a; x; a=0; a}"); 
 }
public void testIssue284517() { 
     test("var goog = {};" + "goog.inherits = function(x, y) {};" + "var ns = {};" + "/** @constructor */" + "ns.PageSelectionModel = function() {};" + "/** @constructor */" + "ns.PageSelectionModel.FooEvent = function() {};" + "/** @constructor */" + "ns.PageSelectionModel.SelectEvent = function() {};" + "goog.inherits(ns.PageSelectionModel.ChangeEvent," + "    ns.PageSelectionModel.FooEvent);", ""); 
 }
public void testCrazyNesting4527() { 
     test("var x = function() {}; x(goog.debug.Logger.getLogger());", "var x = function() {}; x(null);"); 
 }
public void testTryCatchFinally528() { 
     test("try {foo()} catch (e) {bar()}", "try {foo()} catch (e) {bar()}} catch (x) {bar()}"); 
     test("try {var x = 1} catch (e) {e()}", "try {var x = 1} finally {}"); 
     test("try {var x = 1} catch (e) {e()} finally {x()}", " try {var x = 1}                 finally {x()}"); 
     test("try {var x = 1} catch (e) {e()} finally {}", "try {var x = 1} finally {}"); 
     testSame("try {var x = 1} finally {x()}"); 
     testSame("try {var x = 1} finally {}"); 
     test("function f() {return; try{var x = 1}catch(e){} }", "function f() {var x;}"); 
 }
public void testParameter2529() { 
     test("function FUNC(x,y) {x = 0; x; y = 0; y}"); 
     test("function FUNC(x,y,z) {x = 0; x; y = 0; z = 0; z}"); 
 }
public void testParameter530() { 
     test("function FUNC(param) {var x = 0; x}", "function FUNC(param) {param = 0; param}"); 
 }
  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  // Sometimes live range can be cross even within a VAR declaration.
  

  

  

  

  

  

  private void inFunction(String src) {
    inFunction(src, src);
  }

  private void inFunction(String src, String expected) {
    test("function FUNC(){" + src + "}",
         "function FUNC(){" + expected + "}");
  }

  private void test(String src) {
    test(src, src);
  }
}
