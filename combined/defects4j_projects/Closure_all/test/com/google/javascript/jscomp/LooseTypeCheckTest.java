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
import com.google.javascript.jscomp.CheckLevel;
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
 * This is a temporary fork of the TypeCheckTest for the experimental
 * "looseTypes" option.  These tests should be be folded into TypeCheckTest
 * or removed along with the looseTypes option.
 *
 */
public class LooseTypeCheckTest extends CompilerTypeTestCase {

  @Override
  public CompilerOptions getOptions() {
    CompilerOptions options = super.getOptions();
    options.looseTypes = true;
    return options;
  }


public void testIssue78511() { 
     inFunction("/** @param {string|{prop: (string|undefined)}} x */" + "function f(x) {}" + "var out = {};" + "f(out);"); 
     assertEquals("{prop: (string|undefined)}", getType("out").toString()); 
 }


public void testReturnNotMissing117() { 
     testNotMissing(""); 
     testSame("function f() { var x; }"); 
     testNotMissing("return 1;"); 
     testNotMissing("void", "var x;"); 
     testNotMissing("undefined", "var x;"); 
     testNotMissing("number|undefined", "var x;"); 
     testNotMissing("number|void", "var x;"); 
     testNotMissing("(number,void)", "var x;"); 
     testNotMissing("(number,undefined)", "var x;"); 
     testNotMissing("(number,undefined)", "var x;"); 
     testNotMissing("*", "var x;"); 
     testNotMissing("try { return foo() } catch (e) { } finally { }"); 
     testNotMissing("/** @return {number} */ function f() { return 1; }; return 1;"); 
     testNotMissing("try { return 12; } finally { return 62; }"); 
     testNotMissing("try { } finally { return 1; }"); 
     testNotMissing("switch(1) { default: return 1; }"); 
     testNotMissing("switch(g) { case 1: return 1; default: return 2; }"); 
 }


public void testObjectLit118() { 
     inFunction("var x = {}; var out = x.a;"); 
     verify("out", UNKNOWN_TYPE); 
     inFunction("var x = {a:1}; var out = x.a;"); 
     verify("out", NUMBER_TYPE); 
     inFunction("var x = {a:1}; var out = x.a; x.a = 'string'; var out2 = x.a;"); 
     verify("out", NUMBER_TYPE); 
     verify("out2", STRING_TYPE); 
     inFunction("var x = { get a() {return 1} }; var out = x.a;"); 
     verify("out", UNKNOWN_TYPE); 
     inFunction("var x = {" + "  /** @return {number} */ get a() {return 1}" + "};" + "var out = x.a;"); 
     verify("out", NUMBER_TYPE); 
     inFunction("var x = { set a(b) {} }; var out = x.a;"); 
     verify("out", UNKNOWN_TYPE); 
     inFunction("var x = { " + "/** @param {number} b */ set a(b) {} };" + "var out = x.a;"); 
     verify("out", NUMBER_TYPE); 
 }


public void testCast5a119() throws Exception { 
     testTypes("/** @constructor */function foo() {}\n" + "/** @constructor */function bar() {}\n" + "var barInstance = new bar;\n" + "var baz = /** @type {!foo} */(barInstance);\n", "invalid cast - must be a subtype or supertype\n" + "from: bar\n" + "to  : foo"); 
 }


public void testRecordSubtypeChain120() throws Exception { 
     RecordTypeBuilder builder = new RecordTypeBuilder(registry); 
     builder.addProperty("a", STRING_TYPE, null); 
     JSType aType = builder.build(); 
     builder = new RecordTypeBuilder(registry); 
     builder.addProperty("a", STRING_TYPE, null); 
     builder.addProperty("b", STRING_TYPE, null); 
     JSType abType = builder.build(); 
     builder = new RecordTypeBuilder(registry); 
     builder.addProperty("a", STRING_TYPE, null); 
     builder.addProperty("c", STRING_TYPE, null); 
     JSType acType = builder.build(); 
     JSType abOrAcType = registry.createUnionType(abType, acType); 
     builder = new RecordTypeBuilder(registry); 
     builder.addProperty("a", STRING_TYPE, null); 
     builder.addProperty("b", STRING_TYPE, null); 
     builder.addProperty("c", NUMBER_TYPE, null); 
     JSType abcType = builder.build(); 
     List<JSType> typeChain = Lists.newArrayList(registry.getNativeType(JSTypeNative.ALL_TYPE), registry.getNativeType(JSTypeNative.OBJECT_PROTOTYPE), registry.getNativeType(JSTypeNative.OBJECT_TYPE), aType, abOrAcType, abType, abcType, registry.getNativeType(JSTypeNative.NO_OBJECT_TYPE), registry.getNativeType(JSTypeNative.NO_TYPE)); 
     verifySubtypeChain(typeChain); 
 }


public void testReturnNotMissing121() { 
     testNotMissing(""); 
     testSame("function f() { var x; }"); 
     testNotMissing("return 1;"); 
     testNotMissing("void", "var x;"); 
     testNotMissing("undefined", "var x;"); 
     testNotMissing("number|undefined", "var x;"); 
     testNotMissing("number|void", "var x;"); 
     testNotMissing("(number,void)", "var x;"); 
     testNotMissing("(number,undefined)", "var x;"); 
     testNotMissing("(number,undefined)", "var x;"); 
     testNotMissing("*", "var x;"); 
     testNotMissing("try { return foo() } catch (e) { } finally { }"); 
     testNotMissing("/** @return {number} */ function f() { return 1; }; return 1;"); 
     testNotMissing("try { return foo() } finally { return 1; }"); 
     testNotMissing("try { return foo() } finally { return 1; }"); 
     testNotMissing("switch(1) { default: return 1; }"); 
     testNotMissing("switch(g) { case 1: return 1; default: return 2; }"); 
 }


public void testObjectLiteralCast122() { 
     inFunction("var x = {}; var out = x.a;"); 
     verify("out", UNKNOWN_TYPE); 
     inFunction("var x = {a:1}; var out = x.a;"); 
     verify("out", NUMBER_TYPE); 
     inFunction("var x = {a:1}; var out = x.a; x.a = 'string'; var out2 = x.a;"); 
     verify("out", NUMBER_TYPE); 
     verify("out2", STRING_TYPE); 
     inFunction("var x = {a:1}; var out = x.a; x.a = 'string'; var out2 = x.a;"); 
     verify("out", NUMBER_TYPE); 
     inFunction("var x = {a:1}; var out = x.a; x.a = 'string'; var out2 = x.a;"); 
     verify("out", NUMBER_TYPE); 
     inFunction("var x = {a:1}; var out = x.a; x.a = 'string'; var out2 = x.a;"); 
     verify("out", UNKNOWN_TYPE); 
     inFunction("var x = {a:1}; var out = x.a;"); 
     verify("out", NUMBER_TYPE); 
     inFunction("var x = {a:1}; var out = x.a; x.a = 'string'; var out2 = x.a;"); 
     verify("out", UNKNOWN_TYPE); 
     inFunction("var x = {a:1}; var out = x.a; x.a = 'string'; var out2 = x.a;"); 
     verify("out", NUMBER_TYPE); 
 }

  

  

  

  

  

  

  

  

  

  

  

  

  


  

  

  

  


  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

   

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  /**
   * Tests the type of a function definition. The function defined by
   * {@code functionDef} should be named {@code "f"}.
   */
  

  /**
   * Tests the type of a function definition. The function defined by
   * {@code functionDef} should be named {@code functionName}.
   */
  

  /**
   * Tests the type of a function definition in externs.
   * The function defined by {@code functionDef} should be
   * named {@code functionName}.
   */
  

  

  

  

  

  

  

  

  

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
  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  // TODO(user): We should support this way of declaring properties as it is
  // widely used.
  //public void testInheritanceCheck15() throws Exception {
  //  testTypes(
  //      "/** @constructor */function Super() {};" +
  //      "/** @param {number} bar */Super.prototype.foo;" +
  //      "/** @constructor\n @extends {Super} */function Sub() {};" +
  //      "/** @override\n  @param {number} bar */Sub.prototype.foo =\n" +
  //      "function(bar) {};");
  //}

//   public void testInterfacePropertyOverride1() throws Exception {
//     testTypes(
//         "/** @interface */function Super() {};" +
//         "/** @desc description */Super.prototype.foo = function() {};" +
//         "/** @interface\n @extends {Super} */function Sub() {};" +
//         "/** @desc description */Sub.prototype.foo = function() {};",
//         "property foo is already defined by the Super extended interface");
//   }

//   public void testInterfacePropertyOverride2() throws Exception {
//     testTypes(
//         "/** @interface */function Root() {};" +
//         "/** @desc description */Root.prototype.foo = function() {};" +
//         "/** @interface\n @extends {Root} */function Super() {};" +
//         "/** @interface\n @extends {Super} */function Sub() {};" +
//         "/** @desc description */Sub.prototype.foo = function() {};",
//         "property foo is already defined by the Root extended interface");
//   }

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  // According to ECMA-262, Error & Array function calls are equivalent to
  // constructor calls.

  

  

  

  // TODO(user): We should flag these as invalid. This will probably happen
  // when we make sure the interface is never referenced outside of its
  // definition. We might want more specific and helpful error messages.
  //public void testWarningOnInterfacePrototype() throws Exception {
  //  testTypes("/** @interface */ u.T = function() {};\n" +
  //      "/** @return {number} */ u.T.prototype = function() { };",
  //      "cannot reference an interface outside of its definition");
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
  //
  //public void testWarnDataPropertyOnInterface2() throws Exception {
  //  testTypes("/** @interface */ function T() {};\n" +
  //      "/** @type {number} */T.prototype.x;",
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
        registry);
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
