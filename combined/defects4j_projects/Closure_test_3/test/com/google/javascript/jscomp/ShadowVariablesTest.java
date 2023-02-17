/*
 * Copyright 2011 The Closure Compiler Authors.
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

/**
 * Unit tests for {@link ShadowVariables}.
 *
 *
 */
public class ShadowVariablesTest extends CompilerTestCase{
  // Use pseudo names to make test easier to read.
  private boolean generatePseudoNames = false;
  @Override
  protected CompilerPass getProcessor(Compiler compiler) {
      return new RenameVars(
          compiler, "", false, false,
          generatePseudoNames, true, null, null, null);
  }

  @Override
  protected int getNumRepetitions() {
    return 1;
  }

  @Override
  protected void setUp() throws Exception {
    super.setUp();
    generatePseudoNames = false;
  }

public void testPseudoNames378() { 
     generatePseudoNames = false; 
     test("var foo = function(a, b, c){}", "var d = function(a, b, c){}"); 
     generatePseudoNames = true; 
     test("var foo = function(a, b, c){}", "var $foo$$ = function($a$$, $b$$, $c$$){}"); 
     test("var a = function(a, b, c){}", "var $a$$ = function($a$$, $b$$, $c$$){}"); 
 }
public void testExportedLocal1380() { 
     test("function f(a) { a();a();a();a(); return function($super){} }", "function b(a) { a();a();a(); return function($super){} }"); 
 }
public void testAnalyzeUnusedPrototypeProperties381() { 
     test("/** @constructor */ \n" + "function e(){} \n" + "e.prototype.a = function(){};" + "e.prototype.b = function(){};" + "var x = new e; x.a()", "function e(){}" + "e.prototype.a = function(){};" + "var x = new e; x.a()"); 
 }
public void testShadowedScopedVar382() { 
     test("var goog = {};" + "goog.bar = {};" + "goog.scope(function() {" + "  var bar = goog.bar;" + "  bar.newMethod = function(goog) { return goog + bar; };" + "});", "var goog={};" + "goog.bar={};" + "goog.bar.newMethod=function(goog$$1){return goog$$1 + goog.bar}"); 
 }
public void testShadowFunctionDeclaration383() { 
     test("function e(){}" + "e.prototype.a = function(){};" + "e.prototype.b = function(){};" + "var x = new e; x.a()", "function e(){}" + "e.prototype.a = function(){};" + "var x = new e; x.a()"); 
     test("function e(){}" + "e.prototype = {a: function(){}, b: function(){}};" + "var x=new e; x.a()", "function e(){}" + "e.prototype = {a: function(){}};" + "var x = new e; x.a()"); 
     test("function e(){}" + "e.prototype.a = function(){};" + "e.prototype.bExtern = function(){};" + "var x = new e;x.a()", "function e(){}" + "e.prototype.a = function(){};" + "e.prototype.bExtern = function(){};" + "var x = new e; x.a()"); 
     test("function e(){}" + "e.prototype = {a: function(){}, bExtern: function(){}};" + "var x = new e; x.a()", "function e(){}" + "e.prototype = {a: function(){}, bExtern: function(){}};" + "var x = new e; x.a()"); 
 }
  

  

  /**
   * If we have a choice, pick out the most used variable to shadow.
   */
  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  
}
