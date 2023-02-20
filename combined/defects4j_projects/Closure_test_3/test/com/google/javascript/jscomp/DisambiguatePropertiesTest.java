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

import com.google.common.collect.Maps;
import com.google.common.collect.Multimap;
import com.google.common.collect.Sets;
import com.google.javascript.rhino.Node;
import com.google.javascript.rhino.jstype.JSTypeNative;
import com.google.javascript.rhino.jstype.JSTypeRegistry;
import com.google.javascript.rhino.testing.BaseJSTypeTestCase;
import com.google.javascript.rhino.testing.TestErrorReporter;

import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * Unit test for the Compiler DisambiguateProperties pass.
 *
 */
public class DisambiguatePropertiesTest extends CompilerTestCase {
  private DisambiguateProperties<?> lastPass;
  private boolean runTightenTypes;

  public DisambiguatePropertiesTest() {
    parseTypeInfo = true;
  }

  @Override
  protected void setUp() throws Exception {
    super.setUp();
    super.enableNormalize(true);
    super.enableTypeCheck(CheckLevel.WARNING);
  }

  @Override
  public CompilerPass getProcessor(final Compiler compiler) {

    return new CompilerPass() {
      @Override
      public void process(Node externs, Node root) {
        Map<String, CheckLevel> propertiesToErrorFor =
            Maps.<String, CheckLevel>newHashMap();
        propertiesToErrorFor.put("foobar", CheckLevel.ERROR);

        if (runTightenTypes) {
          TightenTypes tightener = new TightenTypes(compiler);
          tightener.process(externs, root);
          lastPass = DisambiguateProperties.forConcreteTypeSystem(compiler,
              tightener, propertiesToErrorFor);
        } else {
          // This must be created after type checking is run as it depends on
          // any mismatches found during checking.
          lastPass = DisambiguateProperties.forJSTypeSystem(
              compiler, propertiesToErrorFor);
        }

        lastPass.process(externs, root);
      }
    };
  }

  @Override
  protected int getNumRepetitions() {
    return 1;
  }

public void testFor238() { 
     test("for(a = 0; a < 2 ; a++) foo();", "a = 0; for(; a < 2 ; a++) foo()"); 
     test("for(var a = 0; c < b ; c++) foo()", "var a = 0; for(; c < b ; c++) foo()"); 
     test("a:for(var a = 0; c < b ; c++) foo()", "var a = 0; a:for(; c < b ; c++) foo()"); 
     test("a:b:for(var a = 0; c < b ; c++) foo()", "var a = 0; a:b:for(; c < b ; c++) foo()"); 
     test("if(x) for(var a = 0; c < b ; c++) foo()", "if(x){var a = 0; for(; c < b ; c++) foo()}"); 
     test("for(init(); a < 2 ; a++) foo();", "init(); for(; a < 2 ; a++) foo()"); 
 }
public void testUnknownType674() { 
     String js = "" + "/** @constructor */ var Foo = function() {};\n" + "/** @constructor */ var Bar = function() {};\n" + "/** @return {?} */ function fun() {}\n" + "Foo.prototype.a = fun();\n" + "fun().a;\n" + "Bar.prototype.a = 0;"; 
     String ttOutput = "" + "var Foo=function(){};\n" + "var Bar=function(){};\n" + "function fun(){}\n" + "Foo.prototype.Foo_prototype$a=fun();\n" + "fun().Unique$1$a;\n" + "Bar.prototype.Bar_prototype$a=0;"; 
     testSets(false, js, js, "{}"); 
     testSets(true, BaseJSTypeTestCase.ALL_NATIVE_EXTERN_TYPES, js, ttOutput, "{a=[[Bar.prototype], [Foo.prototype], [Unique$1]]}"); 
 }
public void testMismatchForbiddenInvalidation675() { 
     test("/** @constructor */ function F() {}" + "/** @type {number} */ F.prototype.foobar = 3;" + "/** @return {number} */ function g() { return new F(); }", null, DisambiguateProperties.Warnings.INVALIDATION); 
     assertTrue(getLastCompiler().getErrors()[0].toString().contains("Consider fixing errors")); 
 }
public void testObjectLiteralReflected676() { 
     String js = "" + "var goog = {};" + "goog.reflect = {};" + "goog.reflect.object = function(x, y) { return y; };" + "/** @constructor */ function F() {}" + "/** @type {number} */ F.prototype.foo = 3;" + "/** @constructor */ function G() {}" + "/** @type {number} */ G.prototype.foo = 3;" + "goog.reflect.object(F, {foo: 5});"; 
     String result = "" + "var goog = {};" + "goog.reflect = {};" + "goog.reflect.object = function(x, y) { return y; };" + "function F() {}" + "F.prototype.F_prototype$foo = 3;" + "function G() {}" + "G.prototype.G_prototype$foo = 3;" + "goog.reflect.object(F, {F_prototype$foo: 5});"; 
     testSets(false, js, result, "{foo=[[F.prototype], [G.prototype]]}"); 
     testSets(true, js, result, "{foo=[[F.prototype], [G.prototype]]}"); 
 }
public void testErrorOnProtectedProperty677() { 
     test("function addSingletonGetter(foo) { foo.foobar = 'a'; };", null, DisambiguateProperties.Warnings.INVALIDATION); 
     assertTrue(getLastCompiler().getErrors()[0].toString().contains("foobar")); 
 }
public void testInterfaceUnionWithCtor678() { 
     String js = "" + "/** @interface */ function I() {};\n" + "/** @type {!Function} */ I.prototype.addEventListener;\n" + "/** @constructor \n * @implements {I} */ function Impl() {};\n" + "/** @type {!Function} */ Impl.prototype.addEventListener;" + "/** @constructor */ function C() {};\n" + "/** @type {!Function} */ C.prototype.addEventListener;" + "/** @param {C|I} x */" + "function f(x) { x.addEventListener(); };\n" + "f(new C()); f(new Impl());"; 
     testSets(false, js, js, "{addEventListener=[[C.prototype, I.prototype, Impl.prototype]]}"); 
     String tightenedOutput = "" + "function I() {};\n" + "I.prototype.I_prototype$addEventListener;\n" + "function Impl() {};\n" + "Impl.prototype.C_prototype$addEventListener;" + "function C() {};\n" + "C.prototype.C_prototype$addEventListener;" + "/** @param {C|I} x */" + "function f(x) { x.C_prototype$addEventListener(); };\n" + "f(new C()); f(new Impl());"; 
     testSets(true, js, tightenedOutput, "{addEventListener=[[C.prototype, Impl.prototype], [I.prototype]]}"); 
 }
public void testStringFunction679() { 
     String externs = "/**@constructor\n@param {*} opt_str \n @return {string}*/" + "function String(opt_str) {};\n" + "/** @override \n @return {string} */\n" + "String.prototype.toString = function() { };\n"; 
     String js = "" + "/** @constructor */ function Foo() {};\n" + "Foo.prototype.foo = function() {};\n" + "String.prototype.foo = function() {};\n" + "var a = 'str'.toString().foo();\n"; 
     String output = "" + "function Foo() {};\n" + "Foo.prototype.Foo_prototype$foo = function() {};\n" + "String.prototype.String_prototype$foo = function() {};\n" + "var a = 'str'.toString().String_prototype$foo();\n"; 
     testSets(false, externs, js, output, "{foo=[[Foo.prototype], [String.prototype]]}"); 
     testSets(true, externs, js, output, "{foo=[[Foo.prototype], [String.prototype]]}"); 
 }
  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  /**
   * Tests that the type based version skips renaming on types that have a
   * mismatch, and the type tightened version continues to work as normal.
   */
  

  

  

  

  

  

  

  

  public void runFindHighestTypeInChain() {
    // Check that this doesn't go into an infinite loop.
    DisambiguateProperties.forJSTypeSystem(new Compiler(),
        Maps.<String, CheckLevel>newHashMap())
        .getTypeWithProperty("no",
            new JSTypeRegistry(new TestErrorReporter(null, null))
            .getNativeType(JSTypeNative.OBJECT_PROTOTYPE));
  }

  @SuppressWarnings("unchecked")
  private void testSets(boolean runTightenTypes, String js, String expected,
      String fieldTypes) {
    this.runTightenTypes = runTightenTypes;
    test(js, expected);
    assertEquals(
        fieldTypes, mapToString(lastPass.getRenamedTypesForTesting()));
  }

  @SuppressWarnings("unchecked")
  private void testSets(boolean runTightenTypes, String externs, String js,
       String expected, String fieldTypes) {
    testSets(runTightenTypes, externs, js, expected, fieldTypes, null, null);
  }

  @SuppressWarnings("unchecked")
  private void testSets(boolean runTightenTypes, String externs, String js,
       String expected, String fieldTypes, DiagnosticType warning,
       String description) {
    this.runTightenTypes = runTightenTypes;
    test(externs, js, expected, null, warning, description);
    assertEquals(
        fieldTypes, mapToString(lastPass.getRenamedTypesForTesting()));
  }

  /**
   * Compiles the code and checks that the set of types for each field matches
   * the expected value.
   *
   * <p>The format for the set of types for fields is:
   * {field=[[Type1, Type2]]}
   */
  private void testSets(boolean runTightenTypes, String js, String fieldTypes) {
    this.runTightenTypes = runTightenTypes;
    test(js, null, null, null);
    assertEquals(fieldTypes, mapToString(lastPass.getRenamedTypesForTesting()));
  }

  /**
   * Compiles the code and checks that the set of types for each field matches
   * the expected value.
   *
   * <p>The format for the set of types for fields is:
   * {field=[[Type1, Type2]]}
   */
  private void testSets(boolean runTightenTypes, String js, String fieldTypes,
      DiagnosticType warning) {
    this.runTightenTypes = runTightenTypes;
    test(js, null, null, warning);
    assertEquals(fieldTypes, mapToString(lastPass.getRenamedTypesForTesting()));
  }

  /** Sorts the map and converts to a string for comparison purposes. */
  private <T> String mapToString(Multimap<String, Collection<T>> map) {
    TreeMap<String, String> retMap = Maps.newTreeMap();
    for (String key : map.keySet()) {
      TreeSet<String> treeSet = Sets.newTreeSet();
      for (Collection<T> collection : map.get(key)) {
        Set<String> subSet = Sets.newTreeSet();
        for (T type : collection) {
          subSet.add(type.toString());
        }
        treeSet.add(subSet.toString());
      }
      retMap.put(key, treeSet.toString());
    }
    return retMap.toString();
  }
}
