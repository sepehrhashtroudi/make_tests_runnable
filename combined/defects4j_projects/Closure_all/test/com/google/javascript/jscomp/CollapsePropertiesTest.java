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


public void testIssue38930() { 
     test("function alias() {}" + "var dojo = {};" + "dojo.gfx = {};" + "dojo.declare = function() {};" + "/** @constructor */" + "dojo.gfx.Shape = function() {};" + "dojo.gfx.Shape = dojo.declare('dojo.gfx.Shape');" + "alias(dojo);", "function alias() {}" + "var dojo = {};" + "dojo.gfx = {};" + "dojo.declare = function() {};" + "/** @constructor */" + "var dojo$gfx$Shape = function() {};" + "dojo$gfx$Shape = dojo.declare('dojo.gfx.Shape');" + "alias(dojo);", null, CollapseProperties.UNSAFE_NAMESPACE_WARNING); 
 }


public void testAddPropertyToFunctionInLocalScopeDepth134() { 
     test("function a() {} function f() { a.c = 5; return a.c; }", "function a() {} var a$c; function f() { a$c = 5; return a$c; }"); 
 }


public void testGoodCrossModuleRequire1268() { 
     test(createModuleStar("goog.provide('goog.ui');", "", "goog.require('goog.ui');"), new String[] { "goog.ui = {};", "", "" }); 
 }


public void testPrototypeReferences5269() throws Exception { 
     SymbolTable table = createSymbolTable("var goog = {}; /** @constructor */ goog.Foo = function() {};"); 
     Symbol fooPrototype = getGlobalVar(table, "goog.Foo.prototype"); 
     assertNotNull(fooPrototype); 
     List<Reference> refs = table.getReferenceList(fooPrototype); 
     assertEquals(1, refs.size()); 
     assertEquals(Token.GETPROP, refs.get(0).getNode().getType()); 
     assertEquals(refs.get(0).getNode(), table.getReferenceList(getGlobalVar(table, "goog.Foo")).get(0).getNode()); 
 }


public void testRemoveDeclaration2270() { 
     Name n = new Name("a", null, false); 
     Ref set1 = createNodelessRef(Ref.Type.SET_FROM_GLOBAL); 
     Ref set2 = createNodelessRef(Ref.Type.SET_FROM_LOCAL); 
     n.addRef(set1); 
     n.addRef(set2); 
     assertEquals(set1, n.getDeclaration()); 
     assertEquals(1, n.globalSets); 
     assertEquals(1, n.localSets); 
     assertEquals(2, n.getRefs().size()); 
     n.removeRef(set1); 
     assertEquals(null, n.getDeclaration()); 
     assertEquals(0, n.globalSets); 
 }


public void testTwiceDefinedGlobalNameDepth2271() { 
     test("var a = {}; a.b = {}; function f() { a.b.c(); }" + "a.b = function() {}; a.b.c = function() {};", "var a$b = {}; function f() { a$b.c(); }" + "a$b = function() {}; a$b.c = function() {};"); 
 }


public void testObjLitAssignedInTernaryExpression2272() { 
     testSame("a = x ? {b: 0} : {b: 1}; var c = a.b;"); 
 }


public void testIssue389273() { 
     test("function alias() {}" + "var dojo = {};" + "dojo.gfx = {};" + "dojo.declare = function() {};" + "/** @constructor */" + "dojo.gfx.Shape = function() {};" + "dojo.gfx.Shape = dojo.declare('dojo.gfx.Shape');" + "alias(dojo);", "function alias() {}" + "var dojo$gfx$Shape = function() {};" + "dojo$gfx$Shape = dojo.declare('dojo.gfx.Shape');" + "alias(dojo);", null, CollapseProperties.UNSAFE_NAMESPACE_WARNING); 
 }


public void testIssue598274() { 
     CompilerOptions options = createCompilerOptions(); 
     options.setLanguageIn(LanguageMode.ECMASCRIPT5_STRICT); 
     WarningLevel.VERBOSE.setOptionsForWarningLevel(options); 
     options.setLanguageIn(LanguageMode.ECMASCRIPT5); 
     String code = "'use strict';\n" + "function App() {}\n" + "App.prototype = {\n" + "  get appData() { return this.appData_; },\n" + "  set appData(data) { this.appData_ = data; }\n" + "};"; 
     Compiler compiler = compile(options, code); 
     testSame(options, code); 
 }


public void testLateDefinedName3275() { 
     testSame("var x = {}; x.y.z = {}; x.y = {z: {}};", NAME_DEFINED_LATE_WARNING); 
 }


public void testLocalAlias4276() { 
     test("var a = {b: 3}; var c = {d: 5}; " + "function f() { var x = a; var y = c; f(x.b); f(y.d); }", "var a$b = 3; var c$d = 5; " + "function f() { var x = null; var y = null; f(a$b); f(c$d);}"); 
 }


public void testIssue90277() { 
     CompilerOptions options = createCompilerOptions(); 
     options.foldConstants = true; 
     options.inlineVariables = true; 
     options.removeDeadCode = true; 
     test(options, "var x; x && alert(1);", ""); 
 }


public void testPropWithDollarSign2278() { 
     test("var a = {b: 3}; var c = {d: 5}; " + "function f() { var x = a; var y = c; f(x.b); f(y.d); }", "var a$b = 3; var c$d = 5; " + "function f() { var x = null; var y = null; f(a$b); f(c$d);}"); 
 }


public void testCrashInNestedAssign279() { 
     test("var a = {}; if (a.b = function() {}) a.b();", "var a$b; if (a$b=function() {}) { a$b(); }"); 
 }

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  private final String COMMON_ENUM =
        "/** @enum {Object} */ var Foo = {A: {c: 2}, B: {c: 3}};";

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  
}
