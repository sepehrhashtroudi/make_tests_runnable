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

public void testPropertyRenaming243() { 
     CompilerOptions options = createCompilerOptions(); 
     options.propertyAffinity = true; 
     String code = "function f() { return this.foo + this['bar'] + this.Baz; }" + "f.prototype.bar = 3; f.prototype.Baz = 3;"; 
     String heuristic = "function f() { return this.foo + this['bar'] + this.a; }" + "f.prototype.bar = 3; f.prototype.a = 3;"; 
     String aggHeuristic = "function f() { return this.foo + this['b'] + this.a; } " + "f.prototype.b = 3; f.prototype.a = 3;"; 
     String all = "function f() { return this.b + this['bar'] + this.a; }" + "f.prototype.c = 3; f.prototype.a = 3;"; 
     testSame(options, code); 
     options.propertyRenaming = PropertyRenamingPolicy.HEURISTIC; 
     test(options, code, heuristic); 
     options.propertyRenaming = PropertyRenamingPolicy.AGGRESSIVE_HEURISTIC; 
     test(options, code, aggHeuristic); 
     options.propertyRenaming = PropertyRenamingPolicy.ALL_UNQUOTED; 
     test(options, code, all); 
 }
public void testIssue724293() { 
     CompilerOptions options = createCompilerOptions(); 
     CompilationLevel.ADVANCED_OPTIMIZATIONS.setOptionsForCompilationLevel(options); 
     String code = "isFunction = function(functionToCheck) {" + "  var getType = {};" + "  return functionToCheck && " + "      getType.toString.apply(functionToCheck) === " + "     '[object Function]';" + "};"; 
     String result = "isFunction=function(a){var b={};" + "return a&&\"[object Function]\"===b.b.a(a)}"; 
     test(options, code, result); 
 }
public void testTightenTypesWithoutTypeCheck294() { 
     CompilerOptions options = createCompilerOptions(); 
     options.tightenTypes = true; 
     test(options, "", DefaultPassConfig.TIGHTEN_TYPES_WITHOUT_TYPE_CHECK); 
 }
public void testMarkNoSideEffects295() { 
     String testCode = "noSideEffects();"; 
     CompilerOptions options = createCompilerOptions(); 
     options.removeDeadCode = true; 
     testSame(options, testCode); 
     options.markNoSideEffectCalls = true; 
     test(options, testCode, ""); 
 }
public void testChainedCalls296() { 
     CompilerOptions options = createCompilerOptions(); 
     options.chainCalls = true; 
     test(options, "/** @constructor */ function Foo() {} " + "Foo.prototype.bar = function() { return this; }; " + "var f = new Foo();" + "f.bar(); " + "f.bar(); ", "function Foo() {} " + "Foo.prototype.bar = function() { return this; }; " + "var f = new Foo();" + "f.bar().bar();"); 
 }
public void testRenamePrefixNamespaceActivatesMoveFunctionDeclarations297() { 
     CompilerOptions options = createCompilerOptions(); 
     String code = "var x = f; function f() { return 3; }"; 
     testSame(options, code); 
     assertFalse(options.moveFunctionDeclarations); 
     options.renamePrefixNamespace = "_"; 
     test(options, code, "_.f = function() { return 3; }; _.x = _.f;"); 
 }
public void testConvertToDottedProperties298() { 
     CompilerOptions options = createCompilerOptions(); 
     String code = "function f() { return this['bar']; } f.prototype.bar = 3;"; 
     String expected = "function f() { return this.bar; } f.prototype.a = 3;"; 
     testSame(options, code); 
     options.convertToDottedProperties = true; 
     options.propertyRenaming = PropertyRenamingPolicy.ALL_UNQUOTED; 
     test(options, code, expected); 
 }
public void testBug1962380552() { 
     CompilerOptions options = createCompilerOptions(); 
     options.collapseProperties = true; 
     options.inlineVariables = true; 
     options.generateExports = true; 
     test(options, CLOSURE_BOILERPLATE + "/** @export */ goog.CONSTANT = 1;" + "var x = goog.CONSTANT;", "(function() {})('goog.CONSTANT', 1);" + "var x = 1;"); 
 }
public void testSuppressCastWarning558() { 
     CompilerOptions options = createCompilerOptions(); 
     options.setWarningLevel(DiagnosticGroups.CHECK_TYPES, CheckLevel.WARNING); 
     normalizeResults = true; 
     test(options, "function f() { var xyz = /** @type {string} */ (0); }", DiagnosticType.warning("JSC_INVALID_CAST", "invalid cast")); 
     testSame(options, "/** @suppress{cast} */\n" + "function f() { var xyz = /** @type {string} */ (0); }"); 
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
