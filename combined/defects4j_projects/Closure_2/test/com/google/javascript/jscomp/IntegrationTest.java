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

public void testBug1949424_v292() { 
     CompilerOptions options = createCompilerOptions(); 
     options.collapseProperties = true; 
     options.closurePass = true; 
     test(options, CLOSURE_BOILERPLATE + "goog.provide('FOO.BAR'); FOO.BAR = 3;", CLOSURE_COMPILED + "var FOO$BAR = 3;"); 
 }
public void testRenamePrefixNamespace291() { 
     String code = "var x = null; try { +x.FOO; } catch (e) {}"; 
     CompilerOptions options = createCompilerOptions(); 
     testSame(options, code); 
     options.renamePrefixNamespace = "_"; 
     test(options, code, "_.x = null; try { +_.x.FOO; } catch (e) {}"); 
 }
public void testRenamePrefixNamespace292() { 
     String code = "var x = {}; x.FOO = 5; x.bar = 3;"; 
     CompilerOptions options = createCompilerOptions(); 
     testSame(options, code); 
     options.renamePrefixNamespace = "_"; 
     test(options, code, "_.x$FOO = 5; _.x$bar = 3;"); 
 }
public void testConvertToDottedProperties293() { 
     CompilerOptions options = createCompilerOptions(); 
     String code = "function f() { return this['bar']; } f.prototype.bar = 3;"; 
     String expected = "function f() { return this.bar; } f.prototype.a = 3;"; 
     testSame(options, code); 
     options.convertToDottedProperties = true; 
     options.propertyRenaming = PropertyRenamingPolicy.ALL_UNQUOTED; 
     test(options, code, expected); 
 }
public void testExtractPrototypeMemberDeclarations294() { 
     CompilerOptions options = createCompilerOptions(); 
     String code = "var f = function() {};"; 
     String expected = "var a; var b = function() {}; a = b.prototype;"; 
     for (int i = 0; i < 10; i++) { 
         code += "f.prototype.a = " + i + ";"; 
         expected += "a.a = " + i + ";"; 
     } 
     testSame(options, code); 
     options.extractPrototypeMemberDeclarations = true; 
     options.variableRenaming = VariableRenamingPolicy.ALL; 
     test(options, code, expected); 
     options.propertyRenaming = PropertyRenamingPolicy.HEURISTIC; 
     options.variableRenaming = VariableRenamingPolicy.OFF; 
     testSame(options, code); 
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
