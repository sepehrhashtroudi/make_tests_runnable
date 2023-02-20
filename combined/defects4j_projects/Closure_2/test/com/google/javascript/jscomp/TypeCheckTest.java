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

import com.google.common.base.Joiner;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import com.google.javascript.jscomp.Scope.Var;
import com.google.javascript.jscomp.type.ClosureReverseAbstractInterpreter;
import com.google.javascript.jscomp.type.SemanticReverseAbstractInterpreter;
import com.google.javascript.rhino.InputId;
import com.google.javascript.rhino.Node;
import com.google.javascript.rhino.Token;
import com.google.javascript.rhino.jstype.FunctionType;
import com.google.javascript.rhino.jstype.JSType;
import com.google.javascript.rhino.jstype.JSTypeNative;
import com.google.javascript.rhino.jstype.ObjectType;
import com.google.javascript.rhino.testing.Asserts;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

/**
 * Tests {@link TypeCheck}.
 *
 */
public class TypeCheckTest extends CompilerTypeTestCase {

  private CheckLevel reportMissingOverrides = CheckLevel.WARNING;

  @Override
  public void setUp() throws Exception {
    super.setUp();
    reportMissingOverrides = CheckLevel.WARNING;
  }

public void testNumericComparison673() throws Exception { 
     testTypes("/**@return {void}*/ function foo() { if (3 >= foo()) return; }", "right side of numeric comparison\n" + "found   : undefined\n" + "required: number"); 
 }
public void testStruct274() throws Exception { 
     testTypes("/**\n" + " * @constructor\n" + " * @struct\n" + " */" + "function Struct1(){ this.prop = 123; }" + "/**\n" + " * @constructor\n" + " * @extends {Struct1}" + " */" + "function Struct1kid(){ this.prop = 123; }" + "/** @param{Struct1kid} x */" + "function takesStruct2(x) { return x['prop']; }", "Cannot do '[]' access on a struct"); 
 }
public void testPropAccess475() throws Exception { 
     testTypes("/** @param {*} x */ function f(x) { return x['hi']; }"); 
 }
public void testGoodExtends1579() throws Exception { 
     testTypes(CLOSURE_DEFS + "/** @constructor */ function OldType() {}" + "/** @param {?function(new:OldType)} f */ function g(f) {" + "  /**\n" + "    * @constructor\n" + "    * @extends {OldType}\n" + "    */\n" + "  function NewType() {};" + "  goog.inherits(NewType, f);" + "  NewType.prototype.method = function() {" + "    NewType.superClass_.foo.call(this);" + "  };" + "}", "Property foo never defined on OldType.prototype"); 
 }
public void testIIFE194() throws Exception { 
     testTypes("var namespace = {};" + "/** @type {number} */ namespace.prop = 3;" + "(function(ns) {" + "  ns.prop = true;" + "})(namespace);", "assignment to property prop of ns\n" + "found   : boolean\n" + "required: number"); 
 }
public void testGetelemStruct2106() throws Exception { 
     testTypes("/**\n" + " * @constructor\n" + " * @struct\n" + " */" + "function Struct1(){ this.prop = 123; }" + "/**\n" + " * @constructor\n" + " * @extends {Struct1}" + " */" + "function Struct1kid(){ this.prop = 123; }" + "/** @param{Struct1kid} x */" + "function takesStruct2(x) { return x['prop']; }", "Cannot do '[]' access on a struct"); 
 }
public void testGetpropDict1124() throws Exception { 
     testTypes("/**\n" + " * @constructor\n" + " * @dict\n" + " */" + "function Dict1(){ this['prop'] = 123; }" + "/** @param{Dict1} x */" + "function takesDict(x) { return x.prop; }", "Cannot do '.' access on a dict"); 
 }
public void testCast16175() throws Exception { 
     testTypes("for (var i = 0; i < 10; i++) {" + "var x = /** @type {Object|number} */ (" + "  {/** @type {string} */ foo: 3});" + "}", "assignment to property foo of Object\n" + "found   : number\n" + "required: string"); 
 }
public void testInOnStruct178() throws Exception { 
     testTypes("/**\n" + " * @constructor\n" + " * @struct\n" + " */" + "function Foo() {}\n" + "if ('prop' in (new Foo())) {}", "Cannot use the IN operator with structs"); 
 }
public void testBadInterfaceExtends4179() throws Exception { 
     testTypes("/** @interface */function A() {}\n" + "/** @constructor */function B() {}\n" + "B.prototype = A;"); 
 }
public void testConstructorType7180() throws Exception { 
     testTypes("/**@constructor*/function Foo(){\n" + "/**@type{!Number}*/this.bar = new Number(5);\n" + "}\n" + "/**@type{!Foo}*/var f = new Foo();\n" + "/**@type{!String}*/var n = f.bar;", "initializing variable\n" + "found   : Number\n" + "required: String"); 
 }
public void testTypeCheckCustomExterns2181() throws Exception { 
     testTypes(DEFAULT_EXTERNS + "/** @enum {string} */ var Enum = {FOO: 1, BAR: 1};", "/** @param {Enum} x */ function f(x) {} f(Enum.FOO); f(true);", "actual parameter 1 of f does not match formal parameter\n" + "found   : boolean\n" + "required: Enum.<string>", false); 
 }
public void testObjLitDef7182() throws Exception { 
     testTypes("var lit = /** @dict */ { x: 1 };", "Illegal key, the object literal is a struct"); 
 }
public void testEnum17183() throws Exception { 
     testTypes("var goog = {};" + "/**@enum*/goog.a={BB:'string'}", "assignment to property BB of enum{goog.a}\n" + "found   : string\n" + "required: number"); 
 }
public void testEnum19184() throws Exception { 
     testTypes("/**@enum*/ var E = {A: 1, B: 2};" + "/** @param {number} x\n@return {!E} */\n" + "var f = function(x) { return x; };", "inconsistent return type\n" + "found   : number\n" + "required: E.<number>"); 
 }
public void testInterfacePropertyOverride1185() throws Exception { 
     testTypes("/** @interface */function Super() {};" + "/** @desc description */Super.prototype.foo = function() {};" + "/** @interface\n @extends {Super} */function Sub() {};" + "/** @desc description */Sub.prototype.foo = function() {};"); 
 }
public void testInheritanceCheck14186() throws Exception { 
     testTypes("var goog = {};\n" + "/** @constructor\n @extends {goog.Missing} */\n" + "goog.Super = function() {};\n" + "/** @constructor\n @extends {goog.Super} */function Sub() {};" + "/** @override */Sub.prototype.foo = function() {};", "Bad type annotation. Unknown type goog.Missing"); 
 }
public void testLends5188() throws Exception { 
     testTypes("function extend(x, y) {}" + "/** @constructor */ function Foo() {}" + "extend(Foo, {bar: 1});" + "alert((new Foo()).bar);", "Property bar never defined on Foo"); 
 }
public void testTypeOfReduction16305() throws Exception { 
     testClosureTypes(CLOSURE_DEFS + "/** @interface */ function I() {}\n" + "/**\n" + " * @param {*} x\n" + " * @return {I}\n" + " */\n" + "function f(x) { " + "  if(goog.isObject(x)) {" + "    return /** @type {I} */(x);" + "  }" + "  return null;" + "}", null); 
 }
public void testPropertyTypeOfUnionType313() throws Exception { 
     testTypes("var a = {};" + "/** @constructor */ a.N = function() {};\n" + "a.N.prototype.p = 1;\n" + "/** @constructor */ a.S = function() {};\n" + "a.S.prototype.p = 'a';\n" + "/** @param {!a.N|!a.S} x\n@return {string} */\n" + "var f = function(x) { return x.p; };", "inconsistent return type\n" + "found   : (number|string)\n" + "required: string"); 
 }
public void testInterfaceExtendsLoop464() throws Exception { 
     testClosureTypesMultipleWarnings(suppressMissingProperty("foo") + "/** @interface \n * @extends {F} */var G = function() {};" + "/** @interface \n * @extends {G} */var F = function() {};", Lists.newArrayList("Could not resolve type in @extends tag of G")); 
 }
public void testMultipleExtendsInterface4465() throws Exception { 
     testTypes("/** @interface */function Int0() {};" + "/** @interface */function Int1() {};" + "/** @desc description */Int0.prototype.foo = function() {};" + "/** @interface \n @extends {Int0} \n @extends {Int1} */" + "function Int2() {};" + "/** @constructor\n @implements {Int2} */function Foo() {};", "Int2 @extends non-object type number"); 
 }
public void testBadStruct467() throws Exception { 
     testTypes("/** @struct */function Struct1() {}", "@dict used without @constructor for Struct1"); 
 }
public void testInnerFunction10469() throws Exception { 
     testTypes("function f() {" + "  /** @type {?number} */ var x = null;" + "  /** @return {string} */" + "  function g() {" + "    if (!x) {" + "      x = 1;" + "    }" + "    return x;" + "  }" + "}", "inconsistent return type\n" + "found   : number\n" + "required: string"); 
 }
public void testDuplicateRecordFields2691() throws Exception { 
     testTypes("/**" + "* @param {{name:string,number:x,number:y}} a" + " */" + "function f(a) {};", new String[] { "Bad type annotation. Unknown type x", "Parse error. Duplicate record field number", "Bad type annotation. Unknown type y" }); 
 }
public void testBitOperation9775() throws Exception { 
     testTypes("var x = void 0; x |= {};", "bad right operand to bitwise operator\n" + "found   : {}\n" + "required: (boolean|null|number|string|undefined)"); 
 }
public void testBug1943776776() throws Exception { 
     testTypes("/** @return  {{foo: Array}} */" + "function bar() {" + "  return {foo: []};" + "}"); 
 }
public void testObjectLiteralDeclaration1809() throws Exception { 
     testTypes("var x = {" + "/** @type {boolean} */ abc: true," + "/** @type {number} */ 'def': 0," + "/** @type {string} */ 3: 'fgh'" + "};"); 
 }
  

  

  

  

  

  

  

  

  

  

  

  

  

  


  

  


  


  

  

  

  

  

  

  

  

  

  

  


  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

   

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  /**
   * Tests the type of a function definition. The function defined by
   * {@code functionDef} should be named {@code "f"}.
   */
  private void testFunctionType(String functionDef, String functionType)
      throws Exception {
    testFunctionType(functionDef, "f", functionType);
  }

  /**
   * Tests the type of a function definition. The function defined by
   * {@code functionDef} should be named {@code functionName}.
   */
  private void testFunctionType(String functionDef, String functionName,
      String functionType) throws Exception {
    // using the variable initialization check to verify the function's type
    testTypes(
        functionDef +
        "/** @type number */var a=" + functionName + ";",
        "initializing variable\n" +
        "found   : " + functionType + "\n" +
        "required: number");
  }

  /**
   * Tests the type of a function definition in externs.
   * The function defined by {@code functionDef} should be
   * named {@code functionName}.
   */
  private void testExternFunctionType(String functionDef, String functionName,
      String functionType) throws Exception {
    testTypes(
        functionDef,
        "/** @type number */var a=" + functionName + ";",
        "initializing variable\n" +
        "found   : " + functionType + "\n" +
        "required: number", false);
  }

  

  

  

  

  

  

  

  

  

  

  

  

  

  // TODO(nicksantos): change this to something that makes sense.
//   public void testComparison1() throws Exception {
//     testTypes("/**@type null */var a;" +
//         "/**@type !Date */var b;" +
//         "if (a==b) {}",
//         "condition always evaluates to false\n" +
//         "left : null\n" +
//         "right: Date");
//   }

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  /**
   * Test that type inference continues with the right side,
   * when no short-circuiting is possible.
   * See bugid 1205387 for more details.
   */
  

  /**
   * @see #testOr4()
   */
  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  


  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  /**
   * Tests that the || operator is type checked correctly, that is of
   * the type of the first argument or of the second argument. See
   * bugid 592170 for more details.
   */
  

  /**
   * Tests that undefined can be compared shallowly to a value of type
   * (number,undefined) regardless of the side on which the undefined
   * value is.
   */
  

  /**
   * Tests that the match method of strings returns nullable arrays.
   */
  

  /**
   * Tests that named types play nicely with subtyping.
   */
  

  /**
   * Tests that assigning two untyped functions to a variable whose type is
   * inferred and calling this variable is legal.
   */
  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  /**
   * Type checks a NAME node and retrieve its type.
   */
  private JSType testNameNode(String name) {
    Node node = Node.newString(Token.NAME, name);
    Node parent = new Node(Token.SCRIPT, node);
    parent.setInputId(new InputId("code"));

    Node externs = new Node(Token.SCRIPT);
    externs.setInputId(new InputId("externs"));

    Node externAndJsRoot = new Node(Token.BLOCK, externs, parent);
    externAndJsRoot.setIsSyntheticBlock(true);

    makeTypeCheck().processForTesting(null, parent);
    return node.getJSType();
  }

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  private void testAddingMethodsUsingPrototypeIdiomComplexNamespace(
      TypeCheckResult p) {
    ObjectType goog = (ObjectType) p.scope.getVar("goog").getType();
    assertEquals(NATIVE_PROPERTIES_COUNT + 1, goog.getPropertiesCount());
    JSType googA = goog.getPropertyType("A");
    assertNotNull(googA);
    assertTrue(googA instanceof FunctionType);
    FunctionType googAFunction = (FunctionType) googA;
    ObjectType classA = googAFunction.getInstanceType();
    assertEquals(NATIVE_PROPERTIES_COUNT + 1, classA.getPropertiesCount());
    checkObjectType(classA, "m1", NUMBER_TYPE);
  }

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  // According to ECMA-262, Error & Array function calls are equivalent to
  // constructor calls.

  

  

  

  // TODO(user): We should flag these as invalid. This will probably happen
  // when we make sure the interface is never referenced outside of its
  // definition. We might want more specific and helpful error messages.
  //public void testWarningOnInterfacePrototype() throws Exception {
  //  testTypes("/** @interface */ u.T = function() {};\n" +
  //      "/** @return {number} */ u.T.prototype = function() { };",
  //      "e of its definition");
  //}
  //
  //public void testBadPropertyOnInterface1() throws Exception {
  //  testTypes("/** @interface */ u.T = function() {};\n" +
  //      "/** @return {number} */ u.T.f = function() { return 1;};",
  //      "cannot reference an interface outside of its definition");
  //}
  //
  //public void testBadPropertyOnInterface2() throws Exception {
  //  testTypes("/** @interface */ function T() {};\n" +
  //      "/** @return {number} */ T.f = function() { return 1;};",
  //      "cannot reference an interface outside of its definition");
  //}
  //
  //public void testBadPropertyOnInterface3() throws Exception {
  //  testTypes("/** @interface */ u.T = function() {}; u.T.x",
  //      "cannot reference an interface outside of its definition");
  //}
  //
  //public void testBadPropertyOnInterface4() throws Exception {
  //  testTypes("/** @interface */ function T() {}; T.x;",
  //      "cannot reference an interface outside of its definition");
  //}

  

  

  

  

  // TODO(user): If we want to support this syntax we have to warn about
  // missing annotations.
  //public void testWarnUnannotatedPropertyOnInterface1() throws Exception {
  //  testTypes("/** @interface */ u.T = function () {}; u.T.prototype.x;",
  //      "interface property x is not annotated");
  //}
  //
  //public void testWarnUnannotatedPropertyOnInterface2() throws Exception {
  //  testTypes("/** @interface */ function T() {}; T.prototype.x;",
  //      "interface property x is not annotated");
  //}

  

  

  // TODO(user): If we want to support this syntax we have to warn about
  // the invalid type of the interface member.
  //public void testWarnDataPropertyOnInterface1() throws Exception {
  //  testTypes("/** @interface */ u.T = function () {};\n" +
  //      "/** @type {number} */u.T.prototype.x;",
  //      "interface members can only be plain functions");
  //}

  

  

  

  

  

  

  // TODO(user): If we want to support this syntax we should warn about the
  // mismatching types in the two tests below.
  //public void testErrorMismatchingPropertyOnInterface1() throws Exception {
  //  testTypes("/** @interface */ u.T = function () {};\n" +
  //      "/** @param {Number} foo */u.T.prototype.x =\n" +
  //      "/** @param {String} foo */function(foo) {};",
  //      "found   : \n" +
  //      "required: ");
  //}
  //
  //public void testErrorMismatchingPropertyOnInterface2() throws Exception {
  //  testTypes("/** @interface */ function T() {};\n" +
  //      "/** @return {number} */T.prototype.x =\n" +
  //      "/** @return {string} */function() {};",
  //      "found   : \n" +
  //      "required: ");
  //}

  // TODO(user): We should warn about this (bar is missing an annotation). We
  // probably don't want to warn about all missing parameter annotations, but
  // we should be as strict as possible regarding interfaces.
  //public void testErrorMismatchingPropertyOnInterface3() throws Exception {
  //  testTypes("/** @interface */ u.T = function () {};\n" +
  //      "/** @param {Number} foo */u.T.prototype.x =\n" +
  //      "function(foo, bar) {};",
  //      "found   : \n" +
  //      "required: ");
  //}

  

  

  

  

  

  

  

  

  

  

  

  

  

  // In all testResolutionViaRegistry* tests, since u is unknown, u.T can only
  // be resolved via the registry and not via properties.

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  private double getTypedPercent(String js) throws Exception {
    Node n = compiler.parseTestCode(js);

    Node externs = new Node(Token.BLOCK);
    Node externAndJsRoot = new Node(Token.BLOCK, externs, n);
    externAndJsRoot.setIsSyntheticBlock(true);

    TypeCheck t = makeTypeCheck();
    t.processForTesting(null, n);
    return t.getTypedPercent();
  }

  private ObjectType getInstanceType(Node js1Node) {
    JSType type = js1Node.getFirstChild().getJSType();
    assertNotNull(type);
    assertTrue(type instanceof FunctionType);
    FunctionType functionType = (FunctionType) type;
    assertTrue(functionType.isConstructor());
    return functionType.getInstanceType();
  }

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  


  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  private void checkObjectType(ObjectType objectType, String propertyName,
        JSType expectedType) {
    assertTrue("Expected " + objectType.getReferenceName() +
        " to have property " +
        propertyName, objectType.hasProperty(propertyName));
    assertTypeEquals("Expected " + objectType.getReferenceName() +
        "'s property " +
        propertyName + " to have type " + expectedType,
        expectedType, objectType.getPropertyType(propertyName));
  }

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  private void testTypes(String js) throws Exception {
    testTypes(js, (String) null);
  }

  private void testTypes(String js, String description) throws Exception {
    testTypes(js, description, false);
  }

  private void testTypes(String js, DiagnosticType type) throws Exception {
    testTypes(js, type.format(), false);
  }

  private void testClosureTypes(String js, String description)
      throws Exception {
    testClosureTypesMultipleWarnings(js,
        description == null ? null : Lists.newArrayList(description));
  }

  private void testClosureTypesMultipleWarnings(
      String js, List<String> descriptions) throws Exception {
    Node n = compiler.parseTestCode(js);
    Node externs = new Node(Token.BLOCK);
    Node externAndJsRoot = new Node(Token.BLOCK, externs, n);
    externAndJsRoot.setIsSyntheticBlock(true);

    assertEquals("parsing error: " +
        Joiner.on(", ").join(compiler.getErrors()),
        0, compiler.getErrorCount());

    // For processing goog.addDependency for forward typedefs.
    new ProcessClosurePrimitives(compiler, null, CheckLevel.ERROR)
        .process(null, n);

    CodingConvention convention = compiler.getCodingConvention();
    new TypeCheck(compiler,
        new ClosureReverseAbstractInterpreter(
            convention, registry).append(
                new SemanticReverseAbstractInterpreter(
                    convention, registry))
            .getFirst(),
        registry)
        .processForTesting(null, n);

    assertEquals(
        "unexpected error(s) : " +
        Joiner.on(", ").join(compiler.getErrors()),
        0, compiler.getErrorCount());

    if (descriptions == null) {
      assertEquals(
          "unexpected warning(s) : " +
          Joiner.on(", ").join(compiler.getWarnings()),
          0, compiler.getWarningCount());
    } else {
      assertEquals(
          "unexpected warning(s) : " +
          Joiner.on(", ").join(compiler.getWarnings()),
          descriptions.size(), compiler.getWarningCount());
      Set<String> actualWarningDescriptions = Sets.newHashSet();
      for (int i = 0; i < descriptions.size(); i++) {
        actualWarningDescriptions.add(compiler.getWarnings()[i].description);
      }
      assertEquals(
          Sets.newHashSet(descriptions), actualWarningDescriptions);
    }
  }

  void testTypes(String js, String description, boolean isError)
      throws Exception {
    testTypes(DEFAULT_EXTERNS, js, description, isError);
  }

  void testTypes(String externs, String js, String description, boolean isError)
      throws Exception {
    Node n = parseAndTypeCheck(externs, js);

    JSError[] errors = compiler.getErrors();
    if (description != null && isError) {
      assertTrue("expected an error", errors.length > 0);
      assertEquals(description, errors[0].description);
      errors = Arrays.asList(errors).subList(1, errors.length).toArray(
          new JSError[errors.length - 1]);
    }
    if (errors.length > 0) {
      fail("unexpected error(s):\n" + Joiner.on("\n").join(errors));
    }

    JSError[] warnings = compiler.getWarnings();
    if (description != null && !isError) {
      assertTrue("expected a warning", warnings.length > 0);
      assertEquals(description, warnings[0].description);
      warnings = Arrays.asList(warnings).subList(1, warnings.length).toArray(
          new JSError[warnings.length - 1]);
    }
    if (warnings.length > 0) {
      fail("unexpected warnings(s):\n" + Joiner.on("\n").join(warnings));
    }
  }

  /**
   * Parses and type checks the JavaScript code.
   */
  private Node parseAndTypeCheck(String js) {
    return parseAndTypeCheck(DEFAULT_EXTERNS, js);
  }

  private Node parseAndTypeCheck(String externs, String js) {
    return parseAndTypeCheckWithScope(externs, js).root;
  }

  /**
   * Parses and type checks the JavaScript code and returns the Scope used
   * whilst type checking.
   */
  private TypeCheckResult parseAndTypeCheckWithScope(String js) {
    return parseAndTypeCheckWithScope(DEFAULT_EXTERNS, js);
  }

  private TypeCheckResult parseAndTypeCheckWithScope(
      String externs, String js) {
    compiler.init(
        Lists.newArrayList(SourceFile.fromCode("[externs]", externs)),
        Lists.newArrayList(SourceFile.fromCode("[testcode]", js)),
        compiler.getOptions());

    Node n = compiler.getInput(new InputId("[testcode]")).getAstRoot(compiler);
    Node externsNode = compiler.getInput(new InputId("[externs]"))
        .getAstRoot(compiler);
    Node externAndJsRoot = new Node(Token.BLOCK, externsNode, n);
    externAndJsRoot.setIsSyntheticBlock(true);

    assertEquals("parsing error: " +
        Joiner.on(", ").join(compiler.getErrors()),
        0, compiler.getErrorCount());

    Scope s = makeTypeCheck().processForTesting(externsNode, n);
    return new TypeCheckResult(n, s);
  }

  private Node typeCheck(Node n) {
    Node externsNode = new Node(Token.BLOCK);
    Node externAndJsRoot = new Node(Token.BLOCK, externsNode, n);
    externAndJsRoot.setIsSyntheticBlock(true);

    makeTypeCheck().processForTesting(null, n);
    return n;
  }

  private TypeCheck makeTypeCheck() {
    return new TypeCheck(
        compiler,
        new SemanticReverseAbstractInterpreter(
            compiler.getCodingConvention(), registry),
        registry,
        reportMissingOverrides,
        CheckLevel.OFF);
  }

  void testTypes(String js, String[] warnings) throws Exception {
    Node n = compiler.parseTestCode(js);
    assertEquals(0, compiler.getErrorCount());
    Node externsNode = new Node(Token.BLOCK);
    Node externAndJsRoot = new Node(Token.BLOCK, externsNode, n);

    makeTypeCheck().processForTesting(null, n);
    assertEquals(0, compiler.getErrorCount());
    if (warnings != null) {
      assertEquals(warnings.length, compiler.getWarningCount());
      JSError[] messages = compiler.getWarnings();
      for (int i = 0; i < warnings.length && i < compiler.getWarningCount();
           i++) {
        assertEquals(warnings[i], messages[i].description);
      }
    } else {
      assertEquals(0, compiler.getWarningCount());
    }
  }

  String suppressMissingProperty(String ... props) {
    String result = "function dummy(x) { ";
    for (String prop : props) {
      result += "x." + prop + " = 3;";
    }
    return result + "}";
  }

  private static class TypeCheckResult {
    private final Node root;
    private final Scope scope;

    private TypeCheckResult(Node root, Scope scope) {
      this.root = root;
      this.scope = scope;
    }
  }
}
