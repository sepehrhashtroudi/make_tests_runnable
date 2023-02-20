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

public void testInnerFunction719() throws Exception { 
     testClosureTypes(CLOSURE_DEFS + "function f() {" + " /** @type {number|function()} */" + " var x = 0 || function() {};\n" + " function g() { if (goog.isFunction(x)) { x(1); } }" + " g();" + "}", "Function x: called with 1 argument(s). " + "Function requires at least 0 argument(s) " + "and no more than 0 argument(s)."); 
 }
public void testPrototypeLoop50() throws Exception { 
     testClosureTypesMultipleWarnings(suppressMissingProperty("foo") + "/** @constructor \n * @extends {T} */var T = function() {};" + "alert((new T).foo);", Lists.newArrayList("Parse error. Cycle detected in inheritance chain of type T", "Could not resolve type in @extends tag of T")); 
 }
public void testObjectTypePropertiesCount51() throws Exception { 
     ObjectType sup = registry.createAnonymousObjectType(null); 
     int nativeProperties = sup.getPropertiesCount(); 
     sup.defineDeclaredProperty("a", DATE_TYPE, null); 
     assertEquals(nativeProperties + 1, sup.getPropertiesCount()); 
     sup.defineDeclaredProperty("b", DATE_TYPE, null); 
     assertEquals(nativeProperties + 2, sup.getPropertiesCount()); 
     ObjectType sub = registry.createObjectType(sup); 
     assertEquals(nativeProperties + 2, sub.getPropertiesCount()); 
 }
public void testThisTypeOfFunction482() throws Exception { 
     testTypes("/** @constructor */ function F() {}" + "F.prototype.moveTo = function(x, y) {};" + "F.prototype.lineTo = function(x, y) {};" + "function demo() {" + "  var path = new F();" + "  var points = [[1,1], [2,2]];" + "  for (var i = 0; i < points.length; i++) {" + "    (i == 0 ? path.moveTo : path.lineTo)(" + "       points[i][0], points[i][1]);" + "  }" + "}", "\"function (this:F, ?, ?): undefined\" " + "must be called with a \"this\" type"); 
 }
public void testSwitchCase386() throws Exception { 
     testTypes("/** @type String */" + "var a = new String('foo');" + "switch (a) { case 'A': }"); 
 }
public void testArrayAccess688() throws Exception { 
     testTypes("var bar = null[1];", "only arrays or objects can be accessed\n" + "found   : null\n" + "required: Object"); 
 }
public void testGoodExtends1690() throws Exception { 
     testTypes(CLOSURE_DEFS + "/** @param {Function} f */ function g(f) {" + "  /** @constructor */ function NewType() {};" + "  goog.inherits(f, NewType);" + "  (new NewType());" + "}"); 
 }
public void testSuperclassMismatch191() throws Exception { 
     compiler.getOptions().setCodingConvention(new GoogleCodingConvention()); 
     testTypes("/** @constructor */ var Foo = function() {};\n" + "/** @constructor \n @extends Object */ var Bar = function() {};\n" + "Bar.inherits = function(x){};" + "Bar.inherits(Foo);\n", "Missing @extends tag on type Bar"); 
 }
public void testConstructorType12143() throws Exception { 
     testTypes("/**\n" + " * @constructor\n" + " * @struct\n" + " */\n" + "function Bar() {}\n" + "Bar.prototype = {};\n", "Bar cannot extend this type; " + "structs can only extend structs"); 
 }
public void testOverriddenParams4155() throws Exception { 
     testTypes("/** @constructor */ function Foo() {}" + "/** @type {function(...[number])} */" + "Foo.prototype.bar = function(var_args) {};" + "/**\n" + " * @constructor\n" + " * @extends {Foo}\n" + " */ function SubFoo() {}" + "/**\n" + " * @type {function(number)}\n" + " * @override\n" + " */" + "SubFoo.prototype.bar = function(x) {};", "mismatch of the bar property type and the type of the " + "property it overrides from superclass Foo\n" + "original: function (...[number]): ?\n" + "override: function (number): ?"); 
 }
public void testTypeCheck5230() throws Exception { 
     testTypes("/**@return {void}*/function foo(){ var a = +foo(); }", "sign operator\n" + "found   : undefined\n" + "required: number"); 
 }
public void testDeleteOperator2231() throws Exception { 
     testTypes("var obj = {};" + "/** \n" + " * @param {string} x\n" + " * @return {Object} */ function f(x) { return obj; }" + "/** @param {?number} x */ function g(x) {" + "  if (x) { delete f(x)['a']; }" + "}", "actual parameter 1 of f does not match formal parameter\n" + "found   : number\n" + "required: string"); 
 }
public void testBitOperation2234() throws Exception { 
     testTypes("/**@return {void}*/function foo(){ ~foo(); }", "operator ~ cannot be applied to undefined"); 
 }
public void testObjectLiteralDeclaration7237() throws Exception { 
     testTypes("var x = {};" + "/**\n" + " * @type {function(boolean): undefined}\n" + " */ x.abc = function(x) {};" + "x = {" + "  /**\n" + "   * @param {boolean} x\n" + "   * @suppress {duplicate}\n" + "   */" + "  abc: function(x) {}" + "};"); 
 }
public void testInterfacePropertyOverride1239() throws Exception { 
     testTypes("/** @interface */function Super() {};" + "/** @desc description */Super.prototype.foo = function() {};" + "/** @interface\n @extends {Super} */function Sub() {};" + "/** @desc description */Sub.prototype.foo = function() {};"); 
 }
public void testInheritanceCheck3240() throws Exception { 
     testTypes("/** @constructor */function Super() {};" + "Super.prototype.foo = function() {};" + "/** @constructor\n @extends {Super} */function Sub() {};" + "Sub.prototype.foo = function() {};", "property foo already defined on superclass Super; " + "use @override to override it"); 
 }
public void testMultipleExtendsInterface6241() throws Exception { 
     testTypes("/** @interface */function Super1() {};" + "/** @interface */function Super2() {};" + "/** @param {number} bar */Super2.prototype.foo = function(bar) {};" + "/** @interface\n @extends {Super1}\n " + "@extends {Super2} */function Sub() {};" + "/** @override\n @param {string} bar */Sub.prototype.foo =\n" + "function(bar) {};", "mismatch of the foo property type and the type of the property it " + "overrides from superclass Super2\n" + "original: function (this:Super2, number): undefined\n" + "override: function (this:Sub, string): undefined"); 
 }
public void testInterfaceNonEmptyFunction242() throws Exception { 
     testTypes("/** @interface */ function T() {};\n" + "T.prototype.x = function() { return 'foo'; }", "interface member functions must have an empty body"); 
 }
public void testStringFunction243() throws Exception { 
     testTypes("/** @constructor */ function Foo() {}" + "Foo.prototype.foo = function() { return this; };" + "/** @constructor \n * @extends {Foo} */ " + "function SubFoo() {}" + "/** @override */ SubFoo.prototype.foo = function() { return this; };" + "/** @constructor \n * @extends {SubFoo} */ function SubFoo() {}" + "/** @override */ SubFoo.prototype.foo = function() { return this; };" + "/** @constructor */ function Foo() {}" + "/** @constructor \n * @extends {Foo} */ function Bar() {}" + "Bar.prototype.foo = function() { return this; };" + "/** @constructor */ function SubFoo() {}" + "/** @type {string} */" + "var x = new Foo();" + "x.foo()" + "function f() { return x.foo(); }", "property foo already defined on Foo"); 
 }
public void testMissingProperty35244() throws Exception { 
     testTypes("/** @constructor */ function Foo() {}" + "/** @constructor */ function Bar() {}" + "/** @constructor */ function Baz() {}" + "/** @param {Foo|Bar} x */ function f(x) { x.specialProp = 1; }" + "/** @param {Bar|Baz} x */ function g(x) { return x.specialProp; }"); 
 }
public void testBackwardsInferenceGoogArrayFilter1245() throws Exception { 
     testClosureTypes(CLOSURE_DEFS + "/** @type {Array.<string>} */" + "var arr;\n" + "/** @type {!Array.<number>} */" + "var result = goog.array.filter(" + "   arr," + "   function(item,index,src) {return false;});", "initializing variable\n" + "found   : Array.<string>\n" + "required: Array.<number>"); 
 }
public void testMissingProperty19246() throws Exception { 
     testTypes("/** @param {Object} x */" + "function f(x) { x.foo && x.foo(); }"); 
 }
public void testMissingProperty21247() throws Exception { 
     testTypes("/** @param {Object} x */" + "function f(x) { x.foo && x.foo(); }"); 
 }
public void testMissingProperty22249() throws Exception { 
     testTypes("/** @param {Object} x */" + "function f(x) { x.foo && x.foo(); }"); 
 }
public void testBadImplementsAConstructor250() throws Exception { 
     testTypes("/** @constructor */function A() {}\n" + "/** @constructor \n * @implements {A} */function B() {}", "can only implement interfaces"); 
 }
public void testExtendedInterfacePropertiesCompatibility4251() throws Exception { 
     testTypes("/** @interface */function Int0() {};" + "/** @interface \n @extends {Int0} */ function Int1() {};" + "/** @type {number} */" + "Int0.prototype.foo;" + "/** @interface */function Int2() {};" + "/** @interface \n @extends {Int2} */ function Int3() {};" + "/** @type {string} */" + "Int2.prototype.foo;" + "/** @interface \n @extends {Int1} \n @extends {Int3} */" + "function Int4() {};", "Interface Int4 has a property foo with incompatible types in its " + "super interfaces Int0 and Int2"); 
 }
public void testCall8252() throws Exception { 
     testTypes("/** @type {Function|number} */var f;f();", "(Function|number) expressions are " + "not callable"); 
 }
public void testBitOperation2253() throws Exception { 
     testTypes("/**@return {void}*/function foo(){var a = foo()<<3;}", "operator << cannot be applied to undefined"); 
 }
public void testBitOperation9254() throws Exception { 
     testTypes("var x = void 0; x |= {};", "bad right operand to bitwise operator\n" + "found   : {}\n" + "required: (boolean|null|number|string|undefined)"); 
 }
public void testBitOperation3255() throws Exception { 
     testTypes("/**@return {void}*/function foo(){var a = 3<<foo();}", "operator << cannot be applied to undefined"); 
 }
public void testBitOperation1256() throws Exception { 
     testTypes("/**@return {void}*/function foo(){ ~foo(); }", "operator ~ cannot be applied to undefined"); 
 }
public void testAdd4257() throws Exception { 
     testTypes("/** @type {number} */ var a = 5;" + "/** @type {string} */ var b = 'b';" + "/** @type {string} */ var c = a + b;"); 
 }
public void testTemplateType5296() throws Exception { 
     testTypes("/**" + " * @param {Array.<T>} arr \n" + " * @param {?function(T)} f \n" + " * @return {T} \n" + " * @template T\n" + " */\n" + "function fn(arr, f) { return arr[0]; }\n" + "/** @param {Array.<number>} arr */ function g(arr) {" + "  /** @type {!Object} */ var x = fn.call(null, arr, null);" + "}", "initializing variable\n" + "found   : number\n" + "required: Object"); 
 }
public void testStringComparison2355() throws Exception { 
     testTypes("/**@param {Object} a*/ function f(a) {return a < 'x';}"); 
 }
public void testEnum39357() throws Exception { 
     testTypes("/** @enum {Number} */ var MyEnum = {FOO: new Number(1)};" + "/** @param {MyEnum} x \n * @return {number} */" + "function f(x) { return x == MyEnum.FOO && MyEnum.FOO == x; }", "inconsistent return type\n" + "found   : boolean\n" + "required: number"); 
 }
public void testTypeOfReduction13438() throws Exception { 
     testClosureTypes(CLOSURE_DEFS + "/** @enum {string} */ var E = {A: 'a', B: 'b'};\n" + "/** @param {E|Array} x\n@return {Array} */ " + "function f(x) { return goog.isObject(x) ? x : []; }", null); 
 }
public void testParameterizedObject2467() throws Exception { 
     testTypes("/** @param {!Object.<string,number>} a\n" + "* @return {string}\n" + "*/ var f = function(a) { return a['x']; };", "inconsistent return type\n" + "found   : number\n" + "required: string"); 
 }
public void testGetTypedPercent4496() throws Exception { 
     String js = "var n = {};\n /** @constructor */ n.T = function() {};\n" + "/** @type n.T */ var x = new n.T();"; 
     assertEquals(100.0, getTypedPercent(js), 0.1); 
 }
public void testInferredReturn5575() throws Exception { 
     testTypes("/** @return {string} */" + "function f() {" + "  var x = function() {};" + "  x = /** @type {function(): number} */ (function() { return 3; });" + "  return x();" + "}", "inconsistent return type\n" + "found   : number\n" + "required: string"); 
 }
public void testAnnotatedPropertyOnInterface4706() throws Exception { 
     testTypes(CLOSURE_DEFS + "/** @interface */ function T() {};\n" + "/** @return {number} */ T.prototype.f = goog.abstractMethod;"); 
 }
public void testIIFE4737() throws Exception { 
     testTypes("/** @const */ var namespace = {};" + "(function(ns) {" + "  /**\n" + "   * @constructor\n" + "   * @param {number} x\n" + "   */\n" + "   ns.Ctor = function(x) {};" + "})(namespace);" + "new namespace.Ctor(true);", "actual parameter 1 of namespace.Ctor " + "does not match formal parameter\n" + "found   : boolean\n" + "required: number"); 
 }
public void testTypeOfReduction15755() throws Exception { 
     testClosureTypes(CLOSURE_DEFS + "function f(x) { " + "  return typeof arguments[0] == 'string' ? arguments[0] : 0;" + "}", null); 
 }
public void testOverriddenReturn1791() throws Exception { 
     testTypes("/** @constructor */ function Foo() {}" + "/** @return {Object} */ Foo.prototype.bar = " + "    function() { return {}; };" + "/** @constructor \n * @extends {Foo} */ function SubFoo() {}" + "/** @return {SubFoo}\n * @override */ SubFoo.prototype.bar = " + "    function() { return new Foo(); }", "inconsistent return type\n" + "found   : Foo\n" + "required: (SubFoo|null)"); 
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
