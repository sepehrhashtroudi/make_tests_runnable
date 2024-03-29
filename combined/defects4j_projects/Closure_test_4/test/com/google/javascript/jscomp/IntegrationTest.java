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

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Sets;
import com.google.javascript.jscomp.CompilerOptions.LanguageMode;
import com.google.javascript.rhino.Node;
import com.google.javascript.rhino.Token;

/**
 * Tests for {@link PassFactory}.
 *
 * @author nicksantos@google.com (Nick Santos)
 */
public class IntegrationTest extends IntegrationTestCase {

  private static final String CLOSURE_BOILERPLATE =
      "/** @define {boolean} */ var COMPILED = false; var goog = {};" +
      "goog.exportSymbol = function() {};";

  private static final String CLOSURE_COMPILED =
      "var COMPILED = true; var goog$exportSymbol = function() {};";

public void testGoogDefineClass1162() { 
     CompilerOptions options = createCompilerOptions(); 
     CompilationLevel level = CompilationLevel.ADVANCED_OPTIMIZATIONS; 
     level.setOptionsForCompilationLevel(options); 
     level.setTypeBasedOptimizationOptions(options); 
     String code = "" + "var ns = {};\n" + "ns.C = goog.defineClass(null, {\n" + "  /** @constructor */\n" + "  constructor: function () {this.someProperty = 1}\n" + "});\n" + "alert(new ns.C().someProperty + new ns.C().someProperty);\n"; 
     assertTrue(options.inlineProperties); 
     assertTrue(options.collapseProperties); 
     test(options, code, "alert(2);"); 
 }
public void testExtractPrototypeMemberDeclarations164() { 
     CompilerOptions options = createCompilerOptions(); 
     options.extractPrototypeMemberDeclarations = true; 
     options.closurePass = true; 
     options.checkTypes = true; 
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
public void testAliasAllChecksOn165() { 
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
  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  // This tests that the TypedScopeCreator is memoized so that it only creates a
  // Scope object once for each scope. If, when type inference requests a scope,
  // it creates a new one, then multiple JSType objects end up getting created
  // for the same local type, and ambiguate will rename the last statement to
  // o.a(o.a, o.a), which is bad.
  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  // Make sure that if we change variables which are constant to have
  // $$constant appended to their names, we remove that tag before
  // we finish.
  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  


  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  
// Defects4J: flaky method
//   public void testManyAdds() {
//     CompilerOptions options = createCompilerOptions();
//     CompilationLevel level = CompilationLevel.SIMPLE_OPTIMIZATIONS;
//     level.setOptionsForCompilationLevel(options);
//     WarningLevel warnings = WarningLevel.VERBOSE;
//     warnings.setOptionsForWarningLevel(options);
// 
//     int numAdds = 4750;
//     StringBuilder original = new StringBuilder("var x = 0");
//     for (int i = 0; i < numAdds; i++) {
//       original.append(" + 1");
//     }
//     original.append(";");
//     test(options, original.toString(), "var x = " + numAdds + ";");
//   }

  /** Creates a CompilerOptions object with google coding conventions. */
  @Override
  protected CompilerOptions createCompilerOptions() {
    CompilerOptions options = new CompilerOptions();
    options.setCodingConvention(new GoogleCodingConvention());
    return options;
  }
}
