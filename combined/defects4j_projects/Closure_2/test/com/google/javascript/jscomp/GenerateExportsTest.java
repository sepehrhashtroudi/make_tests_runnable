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

/**
 * Generate exports unit test.
 *
 */
public class GenerateExportsTest extends CompilerTestCase {

  private static final String EXTERNS =
      "function google_exportSymbol(a, b) {}; " +
      "goog.exportProperty = function(a, b, c) {}; ";

  public GenerateExportsTest() {
    super(EXTERNS);
  }

  @Override
  protected CompilerPass getProcessor(Compiler compiler) {
    return new GenerateExports(compiler,
        "google_exportSymbol", "goog.exportProperty");
  }

  @Override
  protected int getNumRepetitions() {
    // This pass only runs once.
    return 1;
  }

  @Override
  public void setUp() throws Exception {
    super.setUp();
    super.enableLineNumberCheck(false);
  }

public void testExportSymbolAndProperties169() { 
     test("/** @export */function foo() {}" + "/** @export */foo.prototype.bar = function() {}", "function foo(){}" + "google_exportSymbol(\"foo\",foo);" + "foo.prototype.bar=function(){};" + "goog.exportProperty(foo.prototype,\"bar\",foo.prototype.bar)"); 
 }
  

  

  

  

  

  /**
   * Nested assignments are ambiguous and therefore not supported.
   * @see FindExportableNodes
   */
  

  /**
   * Nested assignments are ambiguous and therefore not supported.
   * @see FindExportableNodes
   */
  

  

  

  

  
}