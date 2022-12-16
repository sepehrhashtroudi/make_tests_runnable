/*
 * Copyright 2009 The Closure Compiler Authors.
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

import junit.framework.TestCase;

import java.util.List;

/**
 * Tests for {@link ExternExportsPass}.
 *
 */
public class ExternExportsPassTest extends TestCase {

  private boolean runCheckTypes = true;

  /**
   * ExternExportsPass relies on type information to emit JSDoc annotations for
   * exported externs. However, the user can disable type checking and still
   * ask for externs to be exported. Set this flag to enable or disable checking
   * of types during a test.
   */
  private void setRunCheckTypes(boolean shouldRunCheckTypes) {
    runCheckTypes = shouldRunCheckTypes;
  }

  @Override
  public void setUp() throws Exception {
    super.setUp();

    setRunCheckTypes(true);
  }


public void testInnerFunction716() throws Exception { 
     testClosureTypes(CLOSURE_DEFS + "function f() {" + " /** @type {number|function()} */" + " var x = 0 || function() {};\n" + " function g() { if (goog.isFunction(x)) { x(1); } }" + " g();" + "}", "Function x: called with 1 argument(s). " + "Function requires at least 0 argument(s) " + "and no more than 0 argument(s)."); 
 }


public void testCompilerInterface135() throws Exception { 
     testString(SIMPLE_SOURCE); 
     testInvalidString(SYNTAX_ERROR); 
 }


public void testContinueToSwitchWithDefault136() { 
     assertInvalidContinue("switch(1){case(1):break;case(2):default:continue;}"); 
 }


public void testExtendedInterface137() { 
     testChecks("/** @interface */function I() {}" + "/** @interface\n@extends {I} */function J() {}" + "/** @param {!I} i */function f(i) {}" + "/** @constructor\n@implements {J} */function C() {}", "function I() {}" + "function J() {}" + "function f(i) {" + "  $jscomp.typecheck.checkType(i, " + "      [$jscomp.typecheck.interfaceChecker('I')])" + "}" + "function C() {}" + "C.prototype['instance_of__C'] = true;" + "C.prototype['implements__I'] = true;" + "C.prototype['implements__J'] = true;"); 
 }


public void testAllChecksOn138() { 
     CompilerOptions options = createCompilerOptions(); 
     options.checkSuspiciousCode = true; 
     options.checkControlStructures = true; 
     options.checkRequires = CheckLevel.ERROR; 
     options.checkProvides = CheckLevel.ERROR; 
     options.generateExports = true; 
     options.exportTestFunctions = true; 
     options.closurePass = true; 
     options.checkMissingGetCssNameLevel = CheckLevel.ERROR; 
     options.checkMissingGetCssNameBlacklist = "goog"; 
     options.syntheticBlockStartMarker = "synStart"; 
     options.syntheticBlockEndMarker = "synEnd"; 
     options.checkSymbols = true; 
     options.aggressiveVarCheck = CheckLevel.ERROR; 
     options.processObjectPropertyString = true; 
     options.collapseProperties = true; 
     test(options, CLOSURE_BOILERPLATE, CLOSURE_COMPILED); 
 }


public void testInlineName139() { 
     assertFalse(conv.isConstant("a")); 
     assertTrue(conv.isConstant("XYZ123_")); 
     assertTrue(conv.isConstant("ABC")); 
     assertFalse(conv.isConstant("ABCdef")); 
     assertFalse(conv.isConstant("aBC")); 
     assertFalse(conv.isConstant("A")); 
     assertFalse(conv.isConstant("_XYZ123")); 
     assertTrue(conv.isConstant("a$b$XYZ123_")); 
     assertTrue(conv.isConstant("a$b$ABC_DEF")); 
     assertTrue(conv.isConstant("a$b$A")); 
     assertFalse(conv.isConstant("a$b$a")); 
     assertFalse(conv.isConstant("a$b$ABCdef")); 
     assertFalse(conv.isConstant("a$b$aBC")); 
     assertFalse(conv.isConstant("a$b$")); 
     assertFalse(conv.isConstant("$")); 
 }


public void testAssertNumber2140() { 
     JSType startType = createNullableType(ALL_TYPE); 
     assuming("x", startType); 
     inFunction("goog.asserts.assertNumber(x + x); out1 = x;"); 
     verify("out1", startType); 
 }


public void testAssignOpsEarly141() { 
     late = false; 
     foldSame("x=x+y"); 
     foldSame("x=y+x"); 
     foldSame("x=x*y"); 
     foldSame("x=y*x"); 
     foldSame("x.y=x.y+z"); 
     foldSame("next().x = next().x + 1"); 
     foldSame("x=x-y"); 
     foldSame("x=y-x"); 
     foldSame("x=x|y"); 
     foldSame("x=y|x"); 
     foldSame("x=x*y"); 
     foldSame("x=y*x"); 
     foldSame("x.y=x.y+z"); 
     foldSame("next().x = next().x + 1"); 
     fold("({a:1}).a = ({a:1}).a + 1", "({a:1}).a = 2"); 
 }

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  /**
   * Enums are not currently handled.
   */
   

  /** If we export a property with "prototype" as a path component, there
    * is no need to emit the initializer for prototype because every namespace
    * has one automatically.
    */
  

  /**
   * Test the workflow of creating an externs file for a library
   * via the export pass and then using that externs file in a client.
   *
   * There should be no warnings in the client if the library includes
   * type information for the exported functions and the client uses them
   * correctly.
   */
  

  

  

  

  private void compileAndCheck(String js, String expected) {
    Result result = compileAndExportExterns(js);

    assertEquals(expected, result.externExport);
  }

  

  private Result compileAndExportExterns(String js) {
    return compileAndExportExterns(js, "");
  }

  /**
   * Compiles the passed in JavaScript with the passed in externs and returns
   * the new externs exported by the this pass.
   *
   * @param js the source to be compiled
   * @param externs the externs the {@code js} source needs
   * @return the externs generated from {@code js}
   */
  private Result compileAndExportExterns(String js, String externs) {
    Compiler compiler = new Compiler();
    CompilerOptions options = new CompilerOptions();
    options.externExportsPath = "externs.js";

    // Turn on IDE mode to get rid of optimizations.
    options.ideMode = true;

    /* Check types so we can make sure our exported externs have
     * type information.
     */
    options.checkSymbols = true;
    options.checkTypes = runCheckTypes;

    List<SourceFile> inputs = Lists.newArrayList(
      SourceFile.fromCode("testcode",
                            "var goog = {};" +
                            "goog.exportSymbol = function(a, b) {}; " +
                            "goog.exportProperty = function(a, b, c) {}; " +
                            js));

    List<SourceFile> externFiles = Lists.newArrayList(
        SourceFile.fromCode("externs", externs));

    Result result = compiler.compile(externFiles, inputs, options);

    if (!result.success) {
      String msg = "Errors:";
      msg += Joiner.on("\n").join(result.errors);
      assertTrue(msg, result.success);
    }

    return result;
  }
}
