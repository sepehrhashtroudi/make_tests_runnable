/*
 * Copyright 2007 The Closure Compiler Authors.
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

import static com.google.javascript.jscomp.SyntacticScopeCreator.VAR_MULTIPLY_DECLARED_ERROR;

import com.google.common.collect.Maps;
import com.google.javascript.jscomp.GlobalNamespace.Name;
import com.google.javascript.rhino.Node;
import com.google.javascript.rhino.Token;

import java.util.Map;

/**
 * @author nicksantos@google.com (Nick Santos)
 */
public class ProcessDefinesTest extends CompilerTestCase {

  public ProcessDefinesTest() {
    super("var externMethod;");

    // ProcessDefines emits warnings if the user tries to re-define a constant,
    // but the constant is not defined anywhere in the binary.
    allowSourcelessWarnings();
  }

  private Map<String, Node> overrides = Maps.newHashMap();
  private GlobalNamespace namespace;

  @Override
  public void setUp() throws Exception {
    super.setUp();
    overrides.clear();
  }

  @Override
  protected CompilerPass getProcessor(Compiler compiler) {
    return new ProcessDefinesWithInjectedNamespace(compiler);
  }

  @Override
  protected int getNumRepetitions() {
    // Only do one repetition, so that we can make sure the first pass keeps
    // GlobalNamespace up to date.
    return 1;
  }

  /**
   * Helper for tests that expects definitions to remain unchanged, such
   * that {@code definitions+js} is converted to {@code definitions+expected}.
   */

public void testDefineOnlyFunction2() { 
     test("/** @define {boolean} */var DEF=true;function foo() {DEF=false};", null, ProcessDefines.INVALID_DEFINE_TYPE_ERROR); 
     test("/** @define {boolean} */var DEF=false;function foo() {DEF=true};", null, ProcessDefines.INVALID_DEFINE_TYPE_ERROR); 
     test("/** @define {boolean} */var DEF=false;function foo() {DEF=true};function bar() {DEF=false};", null, ProcessDefines.INVALID_DEFINE_TYPE_ERROR); 
     test("/** @define {boolean} */var DEF=true;function foo() {DEF=false};", null, ProcessDefines.INVALID_DEFINE_TYPE_ERROR); 
     test("/** @define {boolean} */var DEF=false;function foo() {DEF=true};", null, ProcessDefines.INVALID_DEFINE_TYPE_ERROR); 
 }


public void testAssignInNonGlobalScope45() { 
     test("/** @define {boolean} */var DEF=true;function foo() {DEF=false};", null, ProcessDefines.NON_GLOBAL_DEFINE_INIT_ERROR); 
 }


public void testNamespacedDefine355() { 
     overrides.put("a.b", new Node(Token.TRUE)); 
     overrides.put("a.b.c", new Node(Token.FALSE)); 
     test("var a = {}; var b = {};", "var a = {}; var b = {};"); 
     assertEquals(1, lastCompiler.getNamespace().size()); 
     assertEquals("var a = {}; var b = {};", lastCompiler.getNamespace().get(0).toString()); 
 }


public void testDefineOnlyFunction62() { 
     test("/** @define {boolean} */var DEF=true;function foo() {DEF=false};", null, ProcessDefines.NON_GLOBAL_DEFINE_NOT_ASSIGNABLE_ERROR); 
     test("/** @define {boolean} */var DEF=false;function foo() {DEF=true};function bar() {DEF=false};", null, ProcessDefines.NON_GLOBAL_DEFINE_NOT_ASSIGNABLE_ERROR); 
     test("/** @define {boolean} */var DEF=true;function foo() {DEF=false};", null, ProcessDefines.NON_GLOBAL_DEFINE_NOT_ASSIGNABLE_ERROR); 
     test("/** @define {boolean} */var DEF=false;function foo() {DEF=true};function bar() {DEF=false};", null, ProcessDefines.NON_GLOBAL_DEFINE_NOT_ASSIGNABLE_ERROR); 
     test("/** @define {boolean} */var DEF=true;function foo() {DEF=false};", null, ProcessDefines.NON_GLOBAL_DEFINE_NOT_ASSIGNABLE_ERROR); 
     test("/** @define {boolean} */var DEF=false;function foo() {DEF=true};function bar() {DEF=false};", null, ProcessDefines.NON_GLOBAL_DEFINE_NOT_ASSIGNABLE_ERROR); 
     test("/** @define {boolean} */var DEF=false;function foo() {DEF=true};function bar() {DEF=false};", null, ProcessDefines.NON_GLOBAL_DEFINE_NOT_ASSIGNABLE_ERROR); 
 }


public void testAssignInNonGlobalScope63() { 
     test("/** @define {boolean} */var DEF=true;function foo() {DEF=false};", null, ProcessDefines.NON_GLOBAL_DEFINE_NOT_ASSIGNABLE_ERROR); 
 }


public void testNotAssignable64() { 
     test("/** @define {boolean} */var DEF=true;function foo() {DEF=false};", null, ProcessDefines.NON_GLOBAL_DEFINE_NOT_ASSIGNABLE_ERROR); 
     test("/** @define {boolean} */var DEF=false;function foo() {DEF=true};function bar() {DEF=false};", null, ProcessDefines.NON_GLOBAL_DEFINE_NOT_ASSIGNABLE_ERROR); 
     test("/** @define {boolean} */var DEF=false;function foo() {DEF=true};function bar() {DEF=false};", null, ProcessDefines.NON_GLOBAL_DEFINE_NOT_ASSIGNABLE_ERROR); 
     test("/** @define {boolean} */var DEF=true;function foo() {DEF=false};", null, ProcessDefines.NON_GLOBAL_DEFINE_NOT_ASSIGNABLE_ERROR); 
     test("/** @define {boolean} */var DEF=false;function foo() {DEF=true};function bar() {DEF=false};", null, ProcessDefines.NON_GLOBAL_DEFINE_NOT_ASSIGNABLE_ERROR); 
     test("/** @define {boolean} */var DEF=true;function foo() {DEF=false};", null, ProcessDefines.NON_GLOBAL_DEFINE_NOT_ASSIGNABLE_ERROR); 
     test("/** @define {boolean} */var DEF=false;function foo() {DEF=true};function bar() {DEF=false};", null, ProcessDefines.NON_GLOBAL_DEFINE_NOT_ASSIGNABLE_ERROR); 
 }


public void testDefineOnlyFunction65() { 
     test("/** @define {boolean} */var DEF=true;function foo() {DEF=false}", null, ProcessDefines.INVALID_DEFINE_NOT_ASSIGNABLE_ERROR); 
     test("/** @define {boolean} */var DEF=false;function foo() {DEF=true}", null, ProcessDefines.INVALID_DEFINE_NOT_ASSIGNABLE_ERROR); 
     test("/** @define {boolean} */var DEF=false;function foo() {DEF=true}", null, ProcessDefines.INVALID_DEFINE_NOT_ASSIGNABLE_ERROR); 
     test("/** @define {boolean} */var DEF=false;function foo() {DEF=false}", null, ProcessDefines.INVALID_DEFINE_NOT_ASSIGNABLE_ERROR); 
     test("/** @define {boolean} */var DEF=true;function foo() {DEF=false}", null, ProcessDefines.INVALID_DEFINE_NOT_ASSIGNABLE_ERROR); 
     test("/** @define {boolean} */var DEF=false;function foo() {DEF=true;}", null, ProcessDefines.INVALID_DEFINE_NOT_ASSIGNABLE_ERROR); 
 }


public void testExportSymbolWithTypeAnnotation66() { 
     compileAndCheck("var internalName;\n" + "/**\n" + " * @param {string} param1\n" + " * @param {number} param2\n" + " * @return {string}\n" + " */\n" + "internalName = function(param1, param2) {" + "return param1 + param2;" + "};" + "goog.exportSymbol('externalName', internalName)", "/**\n" + " * @param {string} param1\n" + " * @param {number} param2\n" + " * @return {string}\n" + " */\n" + "var externalName = function(param1, param2) {\n};\n"); 
 }


public void testDefineOnlyFunction334() { 
     test("/** @define {boolean} */var DEF=true;function foo() {DEF=false};", null, ProcessDefines.NON_GLOBAL_DEFINE_NOT_ASSIGNABLE_ERROR); 
     test("/** @define {boolean} */var DEF=false;function foo() {DEF=true};function bar() {DEF=false};", null, ProcessDefines.NON_GLOBAL_DEFINE_NOT_ASSIGNABLE_ERROR); 
     test("/** @define {boolean} */var DEF=true;function foo() {DEF=false};", null, ProcessDefines.NON_GLOBAL_DEFINE_NOT_ASSIGNABLE_ERROR); 
     test("/** @define {boolean} */var DEF=false;function foo() {DEF=true};function bar() {DEF=false};", null, ProcessDefines.NON_GLOBAL_DEFINE_NOT_ASSIGNABLE_ERROR); 
     test("/** @define {boolean} */var DEF=true;function foo() {DEF=false};", null, ProcessDefines.NON_GLOBAL_DEFINE_NOT_ASSIGNABLE_ERROR); 
     test("/** @define {boolean} */var DEF=false;function foo() {DEF=true};function bar() {DEF=false};", null, ProcessDefines.NON_GLOBAL_DEFINE_NOT_ASSIGNABLE_ERROR); 
     test("/** @define {boolean} */var DEF=true;function foo() {DEF=false};", null, ProcessDefines.NON_GLOBAL_DEFINE_NOT_ASSIGNABLE_ERROR); 
 }


public void testOverriddenParams4371() throws Exception { 
     testTypes("/** @constructor */ function Foo() {}" + "/** @type {function(...[number])} */" + "Foo.prototype.bar = function(var_args) {};" + "/**\n" + " * @constructor\n" + " * @extends {Foo}\n" + " */ function SubFoo() {}" + "/**\n" + " * @type {function(number)}\n" + " * @override\n" + " */" + "SubFoo.prototype.bar = function(x) {};", "mismatch of the bar property type and the type of the " + "property it overrides from superclass Foo\n" + "original: function (...[number]): ?\n" + "override: function (number): ?"); 
 }


public void testAssignBeforeDeclaration1372() { 
     test("/** @define {boolean} */var DEF=true;var x = DEF;DEF=false", null, ProcessDefines.INVALID_DEFINE_TYPE_ERROR); 
 }


public void testInlineVariables373() { 
     test("/** @define {boolean} */var DEF=true;function foo() {DEF=false};", null, ProcessDefines.NON_GLOBAL_DEFINE_INIT_ERROR); 
     test("/** @define {boolean} */var DEF=false;function foo() {DEF=true};function bar() {DEF=false};", null, ProcessDefines.NON_GLOBAL_DEFINE_INIT_ERROR); 
     test("/** @define {boolean} */var DEF=true;function foo() {DEF=false};function bar() {DEF=false};", null, ProcessDefines.NON_GLOBAL_DEFINE_INIT_ERROR); 
     test("/** @define {boolean} */var DEF=false;function foo() {DEF=true};function bar() {DEF=false};", null, ProcessDefines.NON_GLOBAL_DEFINE_INIT_ERROR); 
     test("/** @define {boolean} */var DEF=true;function foo() {DEF=false};function bar() {DEF=true};", null, ProcessDefines.NON_GLOBAL_DEFINE_INIT_ERROR); 
     test("/** @define {boolean} */var DEF=false;function foo() {DEF=true};function bar() {DEF=false};", null, ProcessDefines.NON_GLOBAL_DEFINE_INIT_ERROR); 
     test("/** @define {boolean} */var DEF=false;function foo() {DEF=true};function bar() {DEF=false};", null, ProcessDefines.NON_GLOBAL_DEFINE_ERROR); 
 }


public void testDefineOnlyFunction374() { 
     test("/** @define {boolean} */var DEF=true;function foo() {DEF=false}", null, ProcessDefines.INVALID_DEFINE_TYPE_ERROR); 
     test("/** @define {boolean} */var DEF=false;function foo() {DEF=true}", null, ProcessDefines.INVALID_DEFINE_TYPE_ERROR); 
     test("/** @define {boolean} */var DEF=false;function foo() {DEF=true}", null, ProcessDefines.INVALID_DEFINE_TYPE_ERROR); 
     test("/** @define {boolean} */var DEF=false;function foo() {DEF=false}", null, ProcessDefines.INVALID_DEFINE_TYPE_ERROR); 
 }


public void testAssignBeforeDeclaration1375() { 
     test("/** @define {boolean} */var DEF=true;var x=false;DEF=false", null, ProcessDefines.INVALID_DEFINE_INIT_ERROR); 
 }


public void testAssignBeforeDeclaration1376() { 
     test("/** @define {boolean} */var DEF=true;function foo() {DEF=false};", null, ProcessDefines.NON_GLOBAL_DEFINE_INIT_ERROR); 
 }


public void testDefineOnlyFunction377() { 
     test("/** @define {boolean} */var DEF=true;function foo() {DEF=false}", null, ProcessDefines.NON_GLOBAL_DEFINE_INIT_ERROR); 
     test("/** @define {boolean} */var DEF=false;function foo() {DEF=true}", null, ProcessDefines.NON_GLOBAL_DEFINE_INIT_ERROR); 
     test("/** @define {boolean} */var DEF=false;function foo() {DEF=true}", null, ProcessDefines.NON_GLOBAL_DEFINE_INIT_ERROR); 
     test("/** @define {boolean} */var DEF=false;function foo() {DEF=false}", null, ProcessDefines.NON_GLOBAL_DEFINE_INIT_ERROR); 
 }


public void testCheckConstants2378() { 
     CompilerOptions options = createCompilerOptions(); 
     CompilationLevel level = CompilationLevel.SIMPLE_OPTIMIZATIONS; 
     level.setOptionsForCompilationLevel(options); 
     WarningLevel warnings = WarningLevel.DEFAULT; 
     warnings.setOptionsForWarningLevel(options); 
     String code = "" + "var foo;\n" + "/** @const */\n" + "var x = 1; foo(); x = 2;\n"; 
     test(options, code, ConstCheck.CONST_REASSIGNED_VALUE_ERROR); 
 }


public void testNamespacedDefine1379() { 
     overrides.put("a.B", new Node(Token.TRUE)); 
     test("var a = {};", "var a = {};", null, ProcessDefines.NON_GLOBAL_DEFINE_INIT_ERROR); 
     test("var a = {};", "var a = {};", null, ProcessDefines.NON_GLOBAL_DEFINE_INIT_ERROR); 
 }


public void testDefineOnlyFunction380() { 
     test("/** @define {boolean} */var DEF=true;function foo() {DEF=false}", null, ProcessDefines.INVALID_DEFINE_TYPE_ERROR); 
     test("/** @define {boolean} */var DEF=false;function foo() {DEF=true}", null, ProcessDefines.INVALID_DEFINE_TYPE_ERROR); 
     test("/** @define {boolean} */var DEF=false;function foo() {DEF=true}", null, ProcessDefines.INVALID_DEFINE_TYPE_ERROR); 
     test("/** @define {boolean} */var DEF=false;function foo() {DEF=false}", null, ProcessDefines.INVALID_DEFINE_TYPE_ERROR); 
     test("/** @define {boolean} */var DEF=true;function foo() {DEF=false}", null, ProcessDefines.INVALID_DEFINE_TYPE_ERROR); 
 }


public void testNamespacedDefine1381() { 
     overrides.put("a.B", new Node(Token.TRUE)); 
     test("var a = {};", "var a = {};", null, ProcessDefines.NON_GLOBAL_DEFINE_INIT_ERROR); 
     test("var a = {};", "var a = {};", null, ProcessDefines.NON_GLOBAL_DEFINE_INIT_ERROR); 
     test("var a = {};", "var a = {};", null, ProcessDefines.NON_GLOBAL_DEFINE_INIT_ERROR); 
     test("var a = {};", "var a = {};", null, ProcessDefines.NON_GLOBAL_DEFINE_INIT_ERROR); 
 }


public void testDefineOnlyFunction382() { 
     test("/** @define {boolean} */var DEF=true;function foo() {DEF=false};", null, ProcessDefines.INVALID_DEFINE_NOT_ASSIGNABLE_ERROR); 
     test("/** @define {boolean} */var DEF=false;function foo() {DEF=true};function bar() {DEF=false};", null, ProcessDefines.INVALID_DEFINE_NOT_ASSIGNABLE_ERROR); 
     test("/** @define {boolean} */var DEF=true;function foo() {DEF=false};function bar() {DEF=false};", null, ProcessDefines.INVALID_DEFINE_NOT_ASSIGNABLE_ERROR); 
     test("/** @define {boolean} */var DEF=false;function foo() {DEF=true};function bar() {DEF=false};", null, ProcessDefines.INVALID_DEFINE_NOT_ASSIGNABLE_ERROR); 
     test("/** @define {boolean} */var DEF=false;function foo() {DEF=true};function bar() {DEF=false};", null, ProcessDefines.INVALID_DEFINE_NOT_ASSIGNABLE_ERROR); 
     test("/** @define {boolean} */var DEF=false;function foo() {DEF=true};function bar() {DEF=false};", null, ProcessDefines.INVALID_DEFINE_NOT_ASSIGNABLE_ERROR); 
     test("/** @define {boolean} */var DEF=false;function foo() {DEF=true};function bar() {DEF=false};", null, ProcessDefines.INVALID_DEFINE_NOT_ASSIGNABLE_ERROR); 
 }


public void testDefineBadType383() { 
     test("/** @define {Object} */ var DEF = {}", null, ProcessDefines.INVALID_DEFINE_TYPE_ERROR); 
 }


public void testNamespacedDefine1384() { 
     test("var a = {}; /** @define {boolean} */ a.B = false;", "var a = {}; a.B = false;"); 
     Name aDotB = namespace.getName("a.B"); 
     assertEquals("{b:false}", aDotB.toString()); 
     Name aDotC = namespace.getName("a.C"); 
     assertEquals("{b:false}", aDotC.toString()); 
     assertEquals("{c:false}", aDotC.getPropertyType("c").toString()); 
     assertEquals("{d:false}", aDotC.getPropertyType("d").toString()); 
     assertEquals("{e:true}", aDotC.getType("e").toString()); 
     assertEquals("true", aDotC.getVisibility("a").toString()); 
     assertEquals("false", aDotC.getVisibility("b").toString()); 
     assertEquals("false", aDotC.getVisibility("c").toString()); 
     assertEquals("true", aDotC.getVisibility("d").toString()); 
     assertEquals("false", aDotC.getVisibility("e").toString()); 
     assertEquals("true", aDotC.getVisibility("f").toString()); 
     assertEquals("false", aDotC.getVisibility("f").toString()); 
     assertEquals("false", aDotC.getVisibility("g").toString()); 
     assertEquals("true", aDotC.getVisibility("h").toString()); 
     assertEquals("false", aDotC.getVisibility("i").toString()); 
     assertEquals("false", aDotC.getVisibility("h").toString()); 
     assertEquals("true", aDotC.getVisibility("true").toString()); 
     assertEquals("false", aDotC.getVisibility("true").toString()); 
     assertEquals("false", aDotC.getVisibility("false").toString()); 
     assertEquals("false", aDotC.getVisibility("true").toString()); 
     assertEquals("

  

  

  

  

  

  

  

  


  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  


  

  private class ProcessDefinesWithInjectedNamespace implements CompilerPass {
    private final Compiler compiler;

    public ProcessDefinesWithInjectedNamespace(Compiler compiler) {
      this.compiler = compiler;
    }

    @Override
    public void process(Node externs, Node js) {
      namespace = new GlobalNamespace(compiler, js);
      new ProcessDefines(compiler, overrides)
          .injectNamespace(namespace)
          .process(externs, js);
    }
  }
}
