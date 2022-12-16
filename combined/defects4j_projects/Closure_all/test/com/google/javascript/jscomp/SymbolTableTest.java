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

import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.common.collect.Ordering;
import com.google.common.collect.Sets;
import com.google.javascript.jscomp.SymbolTable.Reference;
import com.google.javascript.jscomp.SymbolTable.Symbol;
import com.google.javascript.jscomp.SymbolTable.SymbolScope;
import com.google.javascript.rhino.JSDocInfo;
import com.google.javascript.rhino.Token;

import junit.framework.TestCase;

import java.util.List;
import java.util.Set;

/**
 * @author nicksantos@google.com (Nick Santos)
 */
public class SymbolTableTest extends TestCase {

  private static final String EXTERNS = CompilerTypeTestCase.DEFAULT_EXTERNS +
      "\nfunction customExternFn(customExternArg) {}";

  private CompilerOptions options;

  @Override
  public void setUp() throws Exception {
    super.setUp();

    options = new CompilerOptions();
    options.setCodingConvention(new ClosureCodingConvention());
    CompilationLevel.SIMPLE_OPTIMIZATIONS.setOptionsForCompilationLevel(
        options);
    WarningLevel.VERBOSE.setOptionsForWarningLevel(options);
    options.ideMode = true;
  }


public void testGreatestSubtypeSimpleTypes39() { 
     assertTypeEquals(ARRAY_TYPE, ARRAY_TYPE.getGreatestSubtype(ALL_TYPE)); 
     assertTypeEquals(ARRAY_TYPE, ALL_TYPE.getGreatestSubtype(ARRAY_TYPE)); 
     assertTypeEquals(NO_OBJECT_TYPE, REGEXP_TYPE.getGreatestSubtype(NO_OBJECT_TYPE)); 
     assertTypeEquals(NO_OBJECT_TYPE, NO_OBJECT_TYPE.getGreatestSubtype(REGEXP_TYPE)); 
     assertTypeEquals(NO_OBJECT_TYPE, ARRAY_TYPE.getGreatestSubtype(STRING_OBJECT_TYPE)); 
     assertTypeEquals(NO_TYPE, ARRAY_TYPE.getGreatestSubtype(NUMBER_TYPE)); 
     assertTypeEquals(NO_OBJECT_TYPE, ARRAY_TYPE.getGreatestSubtype(functionType)); 
     assertTypeEquals(STRING_OBJECT_TYPE, STRING_OBJECT_TYPE.getGreatestSubtype(OBJECT_TYPE)); 
     assertTypeEquals(STRING_OBJECT_TYPE, OBJECT_TYPE.getGreatestSubtype(STRING_OBJECT_TYPE)); 
     assertTypeEquals(NO_OBJECT_TYPE, ARRAY_TYPE.getGreatestSubtype(DATE_TYPE)); 
     assertTypeEquals(NO_OBJECT_TYPE, ARRAY_TYPE.getGreatestSubtype(REGEXP_TYPE)); 
     assertTypeEquals(EVAL_ERROR_TYPE, ERROR_TYPE.getGreatestSubtype(EVAL_ERROR_TYPE)); 
     assertTypeEquals(EVAL_ERROR_TYPE, EVAL_ERROR_TYPE.getGreatestSubtype(ERROR_TYPE)); 
     assertTypeEquals(NO_TYPE, NULL_TYPE.getGreatestSubtype(ERROR_TYPE)); 
     assertTypeEquals(UNKNOWN_TYPE, NUMBER_TYPE.getGreatestSubtype(UNKNOWN_TYPE)); 
     assertTypeEquals(NO_RESOLVED_TYPE, NO_OBJECT_TYPE.getGreatestSubtype(forwardDeclaredNamedType)); 
     assertTypeEquals(NO_


public void testRemovalOfNamespacedReferencesOfProperties315() throws Exception { 
     SymbolTable table = createSymbolTable("/** @constructor */ var DomHelper = function(){};" + "/** method */ DomHelper.method = function() {};"); 
     Symbol domHelper = getGlobalVar(table, "DomHelper"); 
     assertNotNull(domHelper); 
     Symbol domHelperNamespacedMethod = getGlobalVar(table, "DomHelper.method"); 
     assertEquals("method", domHelperNamespacedMethod.getName()); 
     Symbol domHelperMethod = domHelper.getPropertyScope().getSlot("method"); 
     assertNotNull(domHelperMethod); 
 }


public void testMemoizedTypedScopeCreator316() { 
     CompilerOptions options = createCompilerOptions(); 
     options.checkTypes = true; 
     options.ambiguateProperties = true; 
     options.propertyRenaming = PropertyRenamingPolicy.ALL_UNQUOTED; 
     test(options, "function someTest() {\n" + "  /** @constructor */\n" + "  function Foo() { this.instProp = 3; }\n" + "  Foo.prototype.protoProp = function(a, b) {};\n" + "  /** @constructor\n @extends Foo */\n" + "  function Bar() {}\n" + "  goog.inherits(Bar, Foo);\n" + "  var o = new Bar();\n" + "  o.protoProp(o.protoProp, o.instProp);\n" + "}", "function someTest() {\n" + "  function Foo() { this.b = 3; }\n" + "  function Bar() {}\n" + "  Foo.prototype.a = function(a, b) {};\n" + "  goog.c(Bar, Foo);\n" + "  var o = new Bar();\n" + "  o.a(o.a, o.b);\n" + "}"); 
 }


public void testAliasOfSymbolInGoogScope317() { 
     test("var goog = {};" + "goog.scope(function() {" + "  var g = goog;" + "  g.Foo = function() {};" + "  var Foo = g.Foo;" + "  Foo.prototype.bar = function() {};" + "});", "var goog = {}; goog.Foo = function() {};" + "goog.Foo.prototype.bar = function() {};"); 
 }


public void testNativeCtor318() { 
     testSame("/** Object. \n * @param {*=} x \n * @constructor */ " + "function Object(x) {};", "var x = new Object();" + "/** Another object. */ var y = new Object();", null); 
     assertEquals("Object.", findGlobalNameType("x").getJSDocInfo().getBlockDescription()); 
     assertEquals("Object.", findGlobalNameType("y").getJSDocInfo().getBlockDescription()); 
     assertEquals("Object.", globalScope.getVar("y").getType().getJSDocInfo().getBlockDescription()); 
 }


public void testTypeCheckingOff319() { 
     options = new CompilerOptions(); 
     SymbolTable table = createSymbolTable("/** @contstructor */" + "function F() {" + "  this.field1 = 3;" + "}" + "F.prototype.method1 = function() {" + "  this.field1 = 5;" + "};" + "(new F()).method1();"); 
     assertNull(getGlobalVar(table, "F.prototype.field1")); 
     Symbol sym = getGlobalVar(table, "F"); 
     assertEquals(3, table.getReferenceList(sym).size()); 
 }


public void testToString320() { 
     ObjectType type = registry.createAnonymousObjectType(null); 
     assertEquals("{}", type.toString()); 
     type.defineDeclaredProperty("foo", NUMBER_TYPE, null); 
     assertEquals("{foo: number}", type.toString()); 
     type.defineDeclaredProperty("bar", type, null); 
     assertEquals("{bar: {...}, foo: number}", type.toString()); 
 }


public void testParseWithMarkers1321() throws Exception { 
     JSDocInfo jsdoc = parse("@return some long \n * multiline" + " \n * description */", true); 
     assertDocumentationInMarker(assertAnnotationMarker(jsdoc, "return", 0, 0), "some long multiline description", 8, 2, 15); 
 }


public void testJsDocEnum322() { 
     testTypes("var x = goog.Timer;", "" + "/** @enum {x} */ types.actual;" + "/** @enum {goog.Timer} */ types.expected;"); 
 }


public void testSharingAcrossInnerScopes323() { 
     test("function f() {var f=function g(){g()}; var x=function y(){y()}}", "function c() {var d=function a(){a()}; var e=function b(){b()}}"); 
     test("function f(x) { return x ? function(y){} : function(z) {} }", "function b(a) { return a ? function(a){} : function(a) {} }"); 
 }


public void testUnion324() { 
     testChecks("/** @param {number|string} x */ function f(x) {}", "function f(x) {" + "  $jscomp.typecheck.checkType(x, [" + "      $jscomp.typecheck.valueChecker('number'), " + "      $jscomp.typecheck.valueChecker('string')" + "]);" + "}"); 
 }


public void testPropAccess4325() throws Exception { 
     testTypes("/** @param {*} x */ function f(x) { return x['hi']; }"); 
 }


public void testObjectTypePropertiesCount326() throws Exception { 
     ObjectType sup = registry.createAnonymousObjectType(null); 
     int nativeProperties = sup.getPropertiesCount(); 
     sup.defineDeclaredProperty("a", DATE_TYPE, null); 
     assertEquals(nativeProperties + 1, sup.getPropertiesCount()); 
     sup.defineDeclaredProperty("b", DATE_TYPE, null); 
     assertEquals(nativeProperties + 2, sup.getPropertiesCount()); 
     ObjectType sub = registry.createObjectType(sup); 
     assertEquals(nativeProperties + 2, sub.getPropertiesCount()); 
 }

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  private void assertSymmetricOrdering(
      Ordering<Symbol> ordering, Symbol first, Symbol second) {
    assertTrue(ordering.compare(first, first) == 0);
    assertTrue(ordering.compare(second, second) == 0);
    assertTrue(ordering.compare(first, second) < 0);
    assertTrue(ordering.compare(second, first) > 0);
  }

  private Symbol getGlobalVar(SymbolTable table, String name) {
    return table.getGlobalScope().getQualifiedSlot(name);
  }

  private Symbol getDocVar(SymbolTable table, String name) {
    for (Symbol sym : table.getAllSymbols()) {
      if (sym.isDocOnlyParameter() && sym.getName().equals(name)) {
        return sym;
      }
    }
    return null;
  }

  private Symbol getLocalVar(SymbolTable table, String name) {
    for (SymbolScope scope : table.getAllScopes()) {
      if (!scope.isGlobalScope() && scope.isLexicalScope() &&
          scope.getQualifiedSlot(name) != null) {
        return scope.getQualifiedSlot(name);
      }
    }
    return null;
  }

  /** Returns all non-extern vars. */
  private List<Symbol> getVars(SymbolTable table) {
    List<Symbol> result = Lists.newArrayList();
    for (Symbol symbol : table.getAllSymbols()) {
      if (symbol.getDeclaration() != null &&
          !symbol.getDeclaration().getNode().isFromExterns()) {
        result.add(symbol);
      }
    }
    return result;
  }

  private SymbolTable createSymbolTable(String input) {
    List<SourceFile> inputs = Lists.newArrayList(
        SourceFile.fromCode("in1", input));
    List<SourceFile> externs = Lists.newArrayList(
        SourceFile.fromCode("externs1", EXTERNS));

    Compiler compiler = new Compiler();
    compiler.compile(externs, inputs, options);
    return assertSymbolTableValid(compiler.buildKnownSymbolTable());
  }

  /**
   * Asserts that the symbol table meets some invariants.
   * Returns the same table for easy chaining.
   */
  private SymbolTable assertSymbolTableValid(SymbolTable table) {
    Set<Symbol> allSymbols = Sets.newHashSet(table.getAllSymbols());
    for (Symbol sym : table.getAllSymbols()) {
      // Make sure that grabbing the symbol's scope and looking it up
      // again produces the same symbol.
      assertEquals(sym, table.getScope(sym).getQualifiedSlot(sym.getName()));

      for (Reference ref : table.getReferences(sym)) {
        // Make sure that the symbol and reference are mutually linked.
        assertEquals(sym, ref.getSymbol());
      }

      Symbol scope = table.getSymbolForScope(table.getScope(sym));
      assertTrue(
          "The symbol's scope is a zombie scope that shouldn't exist.\n" +
          "Symbol: " + sym + "\n" +
          "Scope: " + table.getScope(sym),
          scope == null || allSymbols.contains(scope));
    }

    // Make sure that the global "this" is declared at the first input root.
    Symbol global = getGlobalVar(table, SymbolTable.GLOBAL_THIS);
    assertNotNull(global);
    assertNotNull(global.getDeclaration());
    assertEquals(Token.SCRIPT, global.getDeclaration().getNode().getType());

    List<Reference> globalRefs = table.getReferenceList(global);

    // The main reference list should never contain the synthetic declaration
    // for the global root.
    assertFalse(globalRefs.contains(global.getDeclaration()));

    return table;
  }
}
