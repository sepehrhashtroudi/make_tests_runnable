/*
 * Copyright 2006 The Closure Compiler Authors.
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

import static com.google.javascript.jscomp.CollapseProperties.UNSAFE_THIS;

import com.google.javascript.rhino.Node;

/**
 * Tests for {@link CollapseProperties}.
 *
 */
public class CollapsePropertiesTest extends CompilerTestCase {

  private static String EXTERNS =
      "var window; function alert(s) {} function parseInt(s) {}" +
      "/** @constructor */ function String() {}";

  private boolean collapsePropertiesOnExternTypes = false;

  public CollapsePropertiesTest() {
    super(EXTERNS);
  }

  @Override public CompilerPass getProcessor(Compiler compiler) {
    return new CollapseProperties(
        compiler, collapsePropertiesOnExternTypes, true);
  }

  @Override
  public void setUp() {
    enableLineNumberCheck(true);
    enableNormalize(true);
  }

  @Override public int getNumRepetitions() {
    return 1;
  }

public void testInlineAliasWithModifications610() { 
     testSame("var x = 10; function f() { var y = x; x++; alert(y)} "); 
     testSame("var x = 10; function f() { var y = x; x+=1; alert(y)} "); 
     test("var x = {}; x.x = 10; function f() {var y=x.x; x.x++; alert(y)}", "var x$x = 10; function f() {var y=x$x; x$x++; alert(y)}"); 
     test("var x = {}; x.x = 10; function f() {var y=x.x; x.x+=1; alert(y)}", "var x$x = 10; function f() {var y=x$x; x$x+=1; alert(y)}"); 
 }
public void testObjLitAssignedInTernaryExpression2611() { 
     testSame("a = x ? {b: 0} : {b: 1}; var c = a.b;"); 
 }
public void testCollapseForEachWithoutExterns613() { 
     collapsePropertiesOnExternTypes = true; 
     test("/** @constructor */function Array(){};\n", "if (!Array.forEach) {\n" + "  Array.forEach = function() {};\n" + "}", "if (!Array$forEach) {\n" + "  var Array$forEach = function() {};\n" + "}", null, null); 
 }
public void testTwiceDefinedGlobalNameDepth2616() { 
     test("var a = {}; a.b = {}; function f() { a.b.c(); }" + "a.b = function() {}; a.b.c = function() {};", "var a$b = {}; function f() { a$b.c(); }" + "a$b = function() {}; a$b.c = function() {};"); 
 }
public void testGlobalVarSetToObjLitConditionally2617() { 
     test("if (x) var a = {b: 0}; var c = a.b; var d = a.c;", "if (x){ var a$b = 0; var a = {}; }var c = a$b; var d = a.c;"); 
 }
public void testObjLitDefinedInLocalScopeIsLeftAlone669() { 
     test("var a = {}; a.b = function() {};" + "a.b.prototype.f_ = function() {" + "  var x = { p: '', q: '', r: ''}; var y = x.q;" + "};", "var a$b = function() {};" + "a$b.prototype.f_ = function() {" + "  var x = { p: '', q: '', r: ''}; var y = x.q;" + "};"); 
 }
  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  private final String COMMON_ENUM =
        "/** @enum {Object} */ var Foo = {A: {c: 2}, B: {c: 3}};";

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  
}
