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

/**
 * Tests for ExportTestFunctions.
 *
 */
public class ExportTestFunctionsTest extends CompilerTestCase {

  private static final String EXTERNS =
      "function google_exportSymbol(a, b) {}; "
      + "function google_exportProperty(a, b, c) {};";

  private static final String TEST_FUNCTIONS_WITH_NAMES =
      "function Foo(arg) {}; "
      + "function setUp(arg3) {}; "
      + "function tearDown(arg, arg2) {}; "
      + "function testBar(arg) {}";

  public ExportTestFunctionsTest() {
    super(EXTERNS);
  }

  @Override
  public void setUp() {
    super.enableLineNumberCheck(false);
  }

  @Override
  protected CompilerPass getProcessor(Compiler compiler) {
    return new ExportTestFunctions(compiler, "google_exportSymbol",
        "google_exportProperty");
  }

  @Override
  protected int getNumRepetitions() {
    // This pass only runs once.
    return 1;
  }

  

  // Helper functions
  

  /**
   * Make sure this works for global functions declared as function expressions:
   * <pre>
   * var testFunctionName = function() {
   *   // Implementation
   * };
   * </pre>
   * This format should be supported in addition to function statements.
   */
  

  
}
