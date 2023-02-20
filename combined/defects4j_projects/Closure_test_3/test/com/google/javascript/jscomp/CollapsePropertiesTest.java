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

public void testGoodCrossModuleRequire1584() { 
     test(createModuleStar("goog.provide('goog.ui');", "", "goog.require('goog.ui');"), new String[] { "goog.ui = {};", "", "" }); 
 }
public void testValidNames585() { 
     assertTrue(NodeUtil.isValidPropertyName("a")); 
     assertTrue(NodeUtil.isValidPropertyName("a3")); 
     assertFalse(NodeUtil.isValidPropertyName("3a")); 
     assertFalse(NodeUtil.isValidPropertyName("a.")); 
     assertFalse(NodeUtil.isValidPropertyName(".a")); 
     assertFalse(NodeUtil.isValidPropertyName("a.b")); 
     assertFalse(NodeUtil.isValidPropertyName("true")); 
     assertFalse(NodeUtil.isValidPropertyName("a.true")); 
     assertFalse(NodeUtil.isValidPropertyName("a..b")); 
     assertTrue(NodeUtil.isValidSimpleName("a")); 
     assertTrue(NodeUtil.isValidSimpleName("a3")); 
     assertFalse(NodeUtil.isValidSimpleName("3a")); 
     assertFalse(NodeUtil.isValidSimpleName("a.")); 
     assertFalse(NodeUtil.isValidSimpleName(".a")); 
     assertFalse(NodeUtil.isValidSimpleName("a.b")); 
     assertFalse(NodeUtil.isValidSimpleName("true")); 
     assertFalse(NodeUtil.isValidSimpleName("a.true")); 
     assertFalse(NodeUtil.isValidSimpleName("a..b")); 
     assertTrue(NodeUtil.isValidQualifiedName("a")); 
     assertTrue(NodeUtil.isValidQualifiedName("a3")); 
     assertFalse(NodeUtil.isValidQualifiedName("3a")); 
     assertFalse(NodeUtil.isValidQualifiedName("a.")); 
     assertFalse(NodeUtil.isValidQualifiedName(".a")); 
     assertTrue(NodeUtil.isValidQualifiedName("a.b")); 
     assertFalse(NodeUtil.isValidQualifiedName("true")); 
     assertFalse(NodeUtil.isValidQualifiedName("a.true")); 
     assertFalse(NodeUtil.isValidQualifiedName("a..b")); 
 }
public void testRenamePrototypes1588() { 
     test("Bar.prototype={'getFoo':function(){},2:function(){}}", "Bar.prototype={'a':function(){},2:function(){}}"); 
 }
public void testLocalAlias4630() { 
     test("var a = {b: 3}; var c = {d: 5}; " + "function f() { var x = a; var y = c; f(x.b); f(y.d); }", "var a$b = 3; var c$d = 5; " + "function f() { var x = null; var y = null; f(a$b); f(c$d);}"); 
 }
public void testInlineAliasWithModifications631() { 
     testSame("var x = 10; function f() { var y = x; x++; alert(y)} "); 
     testSame("var x = 10; function f() { var y = x; x+=1; alert(y)} "); 
     test("var x = {}; x.x = 10; function f() {var y=x.x; x.x++; alert(y)}", "var x$x = 10; function f() {var y=x$x; x$x++; alert(y)}"); 
     test("var x = {}; x.x = 10; function f() {var y=x.x; x.x+=1; alert(y)}", "var x$x = 10; function f() {var y=x$x; x$x+=1; alert(y)}"); 
 }
public void testObjLitAssignedInTernaryExpression2632() { 
     testSame("a = x ? {b: 0} : {b: 1}; var c = a.b;"); 
 }
public void testCrashInNestedAssign633() { 
     test("var a = {}; if (a.b = function() {}) a.b();", "var a$b; if (a$b=function() {}) { a$b(); }"); 
 }
public void testAliasCreatedForEnumDepth1_3634() { 
     test("/** @enum */ var a = {b: 0}; new f(a); a.b;", "var a$b = 0; var a = {b: a$b}; new f(a); a$b;"); 
 }
public void testAddPropertyToFunctionInLocalScopeDepth1636() { 
     test("function a() {} function f() { a.c = 5; return a.c; }", "function a() {} var a$c; function f() { a$c = 5; return a$c; }"); 
 }
public void testTypedef2640() { 
     test("var foo = {};" + "/** @typedef {number} */ foo.Bar.Baz;" + "foo.Bar = function() {};", "var foo$Bar$Baz; var foo$Bar = function(){};"); 
 }
public void testIndirectlyDeclaredProperties642() { 
     testSame("Function.prototype.inherits = function(ctor) {" + "  this.superClass_ = ctor;" + "};" + "/** @constructor */ function Foo() {}" + "Foo.prototype.bar = function() {};" + "/** @constructor */ function SubFoo() {}" + "SubFoo.inherits(Foo);" + "SubFoo.superClass_.bar();"); 
 }
public void testCollapsePropertyOnExternType680() { 
     collapsePropertiesOnExternTypes = true; 
     test("String.myFunc = function() {}; String.myFunc();", "var String$myFunc = function() {}; String$myFunc()"); 
 }
public void testTwiceDefinedGlobalNameDepth2681() { 
     test("var a = {}; a.b = {}; function f() { a.b.c(); }" + "a.b = function() {}; a.b.c = function() {};", "var a$b = {}; function f() { a$b.c(); }" + "a$b = function() {}; a$b.c = function() {};"); 
 }
public void testNamespaceResetInLocalScope2682() { 
     test("var a = {}; function f() { a = {}; }" + " /** @constructor */a.b = function() {};", "var a = {}; function f() { a = {}; }" + " var a$b = function() {};", null, CollapseProperties.NAMESPACE_REDEFINED_WARNING); 
 }
public void testObjLitDefinedInLocalScopeIsLeftAlone683() { 
     test("var a = {}; a.b = function() {};" + "a.b.prototype.f_ = function() {" + "  var x = { p: '', q: '', r: ''}; var y = x.q;" + "};", "var a$b = function() {};" + "a$b.prototype.f_ = function() {" + "  var x = { p: '', q: '', r: ''}; var y = x.q;" + "};"); 
 }
public void testObjLitAssignmentDepth4684() { 
     test("var a = {}; a.b = {}; a.b.c = {}; a.b.c.d = {e: 1, f: 2}; " + "var g = a.b.c.d.e", "var a$b$c$d$e = 1; var a$b$c$d$f = 2; var g = a$b$c$d$e"); 
 }
public void testAddPropertyToChildOfUncollapsibleFunctionInLocalScope685() { 
     testSame("function a() {} a.b = {x: 0}; var c = a;" + "(function() {a.b.y = 0;})(); a.b.y;"); 
 }
public void testDelete7686() { 
     test("var x = {};" + "x.foo = {bar: 3};" + "delete x.foo.bar;", "var x$foo = {bar: 3};" + "delete x$foo.bar;"); 
 }
public void testPropWithDollarSign2687() { 
     test("var a = {$: function(){}}", "var a$$0 = function(){};"); 
 }
  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  private final String COMMON_ENUM =
        "/** @enum {Object} */ var Foo = {A: {c: 2}, B: {c: 3}};";

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  
}
