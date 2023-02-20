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

public void testExportEnum163() { 
     compileAndCheck("/** @enum {string}\n @export */ var E = {A:8, B:9};" + "goog.exportSymbol('E', E);", "/** @enum {string} */\n" + "var E = {A:1, B:2};\n"); 
 }
public void testExportSymbolWithoutTypeCheck164() { 
     setRunCheckTypes(false); 
     compileAndCheck("var internalName;\n" + "/**\n" + " * @param {string} param1\n" + " * @param {number} param2\n" + " * @return {string}\n" + " */\n" + "internalName = function(param1, param2) {" + "return param1 + param2;" + "};" + "goog.exportSymbol('externalName', internalName)", "var externalName = function(param1, param2) {\n};\n"); 
 }
public void testExportProperty165() throws Exception { 
     compileAndCheck("var a = {}; a.b = {}; a.b.c = function(d, e, f) {};" + "goog.exportProperty(a.b, 'cprop', a.b.c)", "var a;\n" + "a.b;\n" + "/**\n" + " * @param {*} d\n" + " * @param {*} e\n" + " * @param {*} f\n" + " * @return {undefined}\n" + " */\n" + "a.b.cprop = function(d, e, f) {\n};\n"); 
 }
public void testExportFunctionWithVariableArguments774() { 
     compileAndCheck("var internalName;\n" + "/**\n" + " * @param {...number} a\n" + " * @return {number}\n" + " */\n" + "internalName = function(a) {" + "  return 6;\n" + "};" + "goog.exportSymbol('externalName', internalName)", "/**\n" + " * @param {...number} a\n" + " * @return {number}\n" + " */\nvar externalName = function(a) {\n};\n"); 
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
