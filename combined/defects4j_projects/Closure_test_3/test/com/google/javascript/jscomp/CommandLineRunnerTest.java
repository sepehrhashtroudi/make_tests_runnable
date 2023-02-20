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

import com.google.common.base.Function;
import com.google.common.base.Joiner;
import com.google.common.base.Preconditions;
import com.google.common.base.Supplier;
import com.google.common.base.Suppliers;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.javascript.jscomp.AbstractCommandLineRunner.FlagUsageException;
import com.google.javascript.jscomp.CompilerOptions.LanguageMode;
import com.google.javascript.rhino.Node;

import junit.framework.TestCase;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.List;
import java.util.Map;

/**
 * Tests for {@link CommandLineRunner}.
 *
 * @author nicksantos@google.com (Nick Santos)
 */
public class CommandLineRunnerTest extends TestCase {

  private Compiler lastCompiler = null;
  private CommandLineRunner lastCommandLineRunner = null;
  private List<Integer> exitCodes = null;
  private ByteArrayOutputStream outReader = null;
  private ByteArrayOutputStream errReader = null;
  private Map<Integer,String> filenames;

  // If set, this will be appended to the end of the args list.
  // For testing args parsing.
  private String lastArg = null;

  // If set to true, uses comparison by string instead of by AST.
  private boolean useStringComparison = false;

  private ModulePattern useModules = ModulePattern.NONE;

  private enum ModulePattern {
    NONE,
    CHAIN,
    STAR
  }

  private List<String> args = Lists.newArrayList();

  /** Externs for the test */
  private final List<SourceFile> DEFAULT_EXTERNS = ImmutableList.of(
    SourceFile.fromCode("externs",
        "var arguments;"
        + "/**\n"
        + " * @constructor\n"
        + " * @param {...*} var_args\n"
        + " * @nosideeffects\n"
        + " * @throws {Error}\n"
        + " */\n"
        + "function Function(var_args) {}\n"
        + "/**\n"
        + " * @param {...*} var_args\n"
        + " * @return {*}\n"
        + " */\n"
        + "Function.prototype.call = function(var_args) {};"
        + "/**\n"
        + " * @constructor\n"
        + " * @param {...*} var_args\n"
        + " * @return {!Array}\n"
        + " */\n"
        + "function Array(var_args) {}"
        + "/**\n"
        + " * @param {*=} opt_begin\n"
        + " * @param {*=} opt_end\n"
        + " * @return {!Array}\n"
        + " * @this {Object}\n"
        + " */\n"
        + "Array.prototype.slice = function(opt_begin, opt_end) {};"
        + "/** @constructor */ function Window() {}\n"
        + "/** @type {string} */ Window.prototype.name;\n"
        + "/** @type {Window} */ var window;"
        + "/** @constructor */ function Element() {}"
        + "Element.prototype.offsetWidth;"
        + "/** @nosideeffects */ function noSideEffects() {}\n"
        + "/** @param {...*} x */ function alert(x) {}\n")
  );

  private List<SourceFile> externs;

  @Override
  public void setUp() throws Exception {
    super.setUp();
    externs = DEFAULT_EXTERNS;
    filenames = Maps.newHashMap();
    lastCompiler = null;
    lastArg = null;
    outReader = new ByteArrayOutputStream();
    errReader = new ByteArrayOutputStream();
    useStringComparison = false;
    useModules = ModulePattern.NONE;
    args.clear();
    exitCodes = Lists.newArrayList();
  }

  @Override
  public void tearDown() throws Exception {
    super.tearDown();
  }

public void testIssue60125() { 
     args.add("--compilation_level=WHITESPACE_ONLY"); 
     test("function f() { return '\\v' == 'v'; } window['f'] = f;", "function f(){return'\\v'=='v'}window['f']=f"); 
 }
public void testIssue29728() { 
     args.add("--compilation_level=SIMPLE_OPTIMIZATIONS"); 
     test("function f(p) {" + " var x;" + " return ((x=p.id) && (x=parseInt(x.substr(1))) && x>0);" + "}", "function f(b) {" + " var a;" + " return ((a=b.id) && (a=parseInt(a.substr(1))) && 0<a);" + "}"); 
 }
public void testBooleanFlag230() { 
     args.add("--debug"); 
     args.add("--compilation_level=SIMPLE_OPTIMIZATIONS"); 
     test("function foo(a) {alert(a)}", "function foo($a$$) {alert($a$$)}"); 
 }
public void testGetMsgWiring317() throws Exception { 
     test("var goog = {}; goog.getMsg = function(x) { return x; };" + "/** @desc A real foo. */ var MSG_FOO = goog.getMsg('foo');", "var goog={getMsg:function(a){return a}}, " + "MSG_FOO=goog.getMsg('foo');"); 
     args.add("--compilation_level=ADVANCED_OPTIMIZATIONS"); 
     test("var goog = {}; goog.getMsg = function(x) { return x; };" + "/** @desc A real foo. */ var MSG_FOO = goog.getMsg('foo');" + "window['foo'] = MSG_FOO;", "window.foo = 'foo';"); 
 }
public void testExternsLifting1436() throws Exception { 
     String code = "/** @externs */ function f() {}"; 
     test(new String[] { code }, new String[] {}); 
     assertEquals(2, lastCompiler.getExternsForTesting().size()); 
     CompilerInput extern = lastCompiler.getExternsForTesting().get(1); 
     assertNull(extern.getModule()); 
     assertTrue(extern.isExtern()); 
     assertEquals(code, extern.getCode()); 
     assertEquals(1, lastCompiler.getInputsForTesting().size()); 
     CompilerInput input = lastCompiler.getInputsForTesting().get(0); 
     assertNotNull(input.getModule()); 
     assertFalse(input.isExtern()); 
     assertEquals("", input.getCode()); 
 }
public void testNoSrCFilesWithManifest437() throws IOException { 
     args.add("--use_only_custom_externs=true"); 
     args.add("--output_manifest=test.MF"); 
     CommandLineRunner runner = createCommandLineRunner(new String[0]); 
     String expectedMessage = ""; 
     try { 
         runner.doRun(); 
     } catch (FlagUsageException e) { 
         expectedMessage = e.getMessage(); 
     } 
     assertEquals(expectedMessage, "Bad --js flag. " + "Manifest files cannot be generated when the input is from stdin."); 
 }
public void testSourceMapExpansion1438() { 
     args.add("--js_output_file"); 
     args.add("/path/to/out.js"); 
     args.add("--create_source_map=%outname%.map"); 
     testSame("var x = 3;"); 
     assertEquals("/path/to/out.js.map", lastCommandLineRunner.expandSourceMapPath(lastCompiler.getOptions(), null)); 
 }
public void testCheckSymbolsOverrideForQuiet439() { 
     args.add("--warning_level=QUIET"); 
     args.add("--jscomp_error=undefinedVars"); 
     test("x = 3;", VarCheck.UNDEFINED_VAR_ERROR); 
 }
public void testDefineFlag2440() { 
     args.add("--define=FOO=\"x'\""); 
     test("/** @define {string} */ var FOO = \"a\";", "var FOO = \"x'\";"); 
 }
public void testPrintAstFlag442() { 
     args.add("--print_ast=true"); 
     testSame(""); 
     assertEquals("digraph AST {\n" + "  node [color=lightblue2, style=filled];\n" + "  node0 [label=\"BLOCK\"];\n" + "  node1 [label=\"SCRIPT\"];\n" + "  node0 -> node1 [weight=1];\n" + "  node1 -> RETURN [label=\"UNCOND\", " + "fontcolor=\"red\", weight=0.01, color=\"red\"];\n" + "  node0 -> RETURN [label=\"SYN_BLOCK\", " + "fontcolor=\"red\", weight=0.01, color=\"red\"];\n" + "  node0 -> node1 [label=\"UNCOND\", " + "fontcolor=\"red\", weight=0.01, color=\"red\"];\n" + "}\n\n", new String(outReader.toByteArray())); 
 }
public void testOutputSameAsInput443() { 
     args.add("--js_output_file=" + getFilename(0)); 
     test("", AbstractCommandLineRunner.OUTPUT_SAME_AS_INPUT_ERROR); 
 }
public void testCharSetExpansion444() { 
     testSame(""); 
     assertEquals("US-ASCII", lastCompiler.getOptions().outputCharset); 
     args.add("--charset=UTF-8"); 
     testSame(""); 
     assertEquals("UTF-8", lastCompiler.getOptions().outputCharset); 
 }
public void testDefineFlag3445() { 
     args.add("--define=FOO=\"x'\""); 
     test("/** @define {string} */ var FOO = \"a\";", "var FOO = \"x'\";"); 
 }
public void testOptimizeSrCFilesWithManifest448() throws IOException { 
     args.add("--use_only_custom_externs=true"); 
     args.add("--output_manifest=test.MF"); 
     CommandLineRunner runner = createCommandLineRunner(new String[0]); 
     String expectedMessage = ""; 
     try { 
         runner.doRun(); 
     } catch (FlagUsageException e) { 
         expectedMessage = e.getMessage(); 
     } 
     assertEquals(expectedMessage, "Bad --js flag. " + "Manifest files cannot be generated when the input is from stdin."); 
 }
public void testIssue182d581() { 
     args.add("--compilation_level=SIMPLE_OPTIMIZATIONS"); 
     test("function f(p) {" + " var x;" + " return ((x=p.id) && (x=parseInt(x.substr(1))) && x>0);" + "}", "function f(b) {" + " var a;" + " return ((a=b.id) && (a=parseInt(a.substr(1))) && 0<a);" + "}"); 
 }
public void testGlobalThis6582() { 
     testSame("a = this;"); 
 }
public void testSourcePruningOn2586() { 
     args.add("--closure_entry_point=guinness"); 
     test(new String[] { "goog.provide('guinness');\ngoog.require('beer');", "goog.provide('beer');", "goog.provide('scotch'); var x = 3;" }, new String[] { "var beer = {};", "var guinness = {};" }); 
 }
public void testDegenerateModuleChain703() throws Exception { 
     useModules = ModulePattern.CHAIN; 
     testSame(new String[] { "var x = 3;", "var y = 5;", "var z = 7;", "var a = 9;" }); 
     StringBuilder builder = new StringBuilder(); 
     lastCommandLineRunner.printModuleGraphManifestOrBundleTo(lastCompiler.getModuleGraph(), builder, true); 
     assertEquals("{m0}\n" + "i0\n" + "\n" + "{m1:m0}\n" + "i1\n" + "\n" + "{m2:m1}\n" + "i2\n" + "\n" + "{m3:m2}\n" + "i3\n", builder.toString()); 
 }
public void testHelpFlag766() { 
     args.add("--help"); 
     assertFalse(createCommandLineRunner(new String[] { "function f() {}" }).shouldRunCompiler()); 
 }
public void testProcessClosurePrimitives767() { 
     test("var goog = {}; goog.provide('goog.dom');", "var goog = {dom:{}};"); 
     args.add("--process_closure_primitives=false"); 
     testSame("var goog = {}; goog.provide('goog.dom');"); 
 }
public void testVersionFlag2768() { 
     lastArg = "--version"; 
     testSame(""); 
     assertEquals(0, new String(errReader.toByteArray()).indexOf("Closure Compiler (http://code.google.com/closure/compiler)\n" + "Version: ")); 
 }
public void test() { 
     args.add("--compilation_level=ADVANCED_OPTIMIZATIONS"); 
     args.add("--use_types_for_optimization"); 
     test("/** @constructor */\n" + "function Foo() {}\n" + "Foo.prototype.handle1 = function(x, y) { alert(y); };\n" + "/** @constructor */\n" + "function Bar() {}\n" + "Bar.prototype.handle1 = function(x, y) {};\n" + "new Foo().handle1(1, 2);\n" + "new Bar().handle1(1, 2);\n", "alert(2)"); 
 }
public void testFormattingSingleQuote770() { 
     testSame("var x = '';"); 
     assertEquals("var x=\"\";", lastCompiler.toSource()); 
     args.add("--formatting=SINGLE_QUOTES"); 
     testSame("var x = '';"); 
     assertEquals("var x='';", lastCompiler.toSource()); 
 }
public void testTypedAdvanced771() { 
     args.add("--compilation_level=ADVANCED_OPTIMIZATIONS"); 
     args.add("--use_types_for_optimization"); 
     test("/** @constructor */\n" + "function Foo() {}\n" + "Foo.prototype.handle1 = function(x, y) { alert(y); };\n" + "/** @constructor */\n" + "function Bar() {}\n" + "Bar.prototype.handle1 = function(x, y) {};\n" + "new Foo().handle1(1, 2);\n" + "new Bar().handle1(1, 2);\n", "alert(2)"); 
 }
public void testADVANCED_OPTIMIZATIONS772() { 
     args.add("--compilation_level=ADVANCED_OPTIMIZATIONS"); 
     args.add("--use_only_custom_externs=true"); 
     test("/** @constructor */\n" + "function Foo() {}\n" + "Foo.prototype.handle1 = function(x, y) { alert(y); };\n" + "/** @constructor */\n" + "function Bar() {}\n" + "Bar.prototype.handle1 = function(x, y) {};\n" + "new Foo().handle1(1, 2);\n" + "new Bar().handle1(1, 2);\n", "alert(2)"); 
 }
  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  


  //////////////////////////////////////////////////////////////////////////////
  // Integration tests

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  /* Helper functions */

  private void testSame(String original) {
    testSame(new String[] { original });
  }

  private void testSame(String[] original) {
    test(original, original);
  }

  private void test(String original, String compiled) {
    test(new String[] { original }, new String[] { compiled });
  }

  /**
   * Asserts that when compiling with the given compiler options,
   * {@code original} is transformed into {@code compiled}.
   */
  private void test(String[] original, String[] compiled) {
    test(original, compiled, null);
  }

  /**
   * Asserts that when compiling with the given compiler options,
   * {@code original} is transformed into {@code compiled}.
   * If {@code warning} is non-null, we will also check if the given
   * warning type was emitted.
   */
  private void test(String[] original, String[] compiled,
                    DiagnosticType warning) {
    Compiler compiler = compile(original);

    if (warning == null) {
      assertEquals("Expected no warnings or errors\n" +
          "Errors: \n" + Joiner.on("\n").join(compiler.getErrors()) +
          "Warnings: \n" + Joiner.on("\n").join(compiler.getWarnings()),
          0, compiler.getErrors().length + compiler.getWarnings().length);
    } else {
      assertEquals(1, compiler.getWarnings().length);
      assertEquals(warning, compiler.getWarnings()[0].getType());
    }

    Node root = compiler.getRoot().getLastChild();
    if (useStringComparison) {
      assertEquals(Joiner.on("").join(compiled), compiler.toSource());
    } else {
      Node expectedRoot = parse(compiled);
      String explanation = expectedRoot.checkTreeEquals(root);
      assertNull("\nExpected: " + compiler.toSource(expectedRoot) +
          "\nResult: " + compiler.toSource(root) +
          "\n" + explanation, explanation);
    }
  }

  /**
   * Asserts that when compiling, there is an error or warning.
   */
  private void test(String original, DiagnosticType warning) {
    test(new String[] { original }, warning);
  }

  private void test(String original, String expected, DiagnosticType warning) {
    test(new String[] { original }, new String[] { expected }, warning);
  }

  /**
   * Asserts that when compiling, there is an error or warning.
   */
  private void test(String[] original, DiagnosticType warning) {
    Compiler compiler = compile(original);
    assertEquals("Expected exactly one warning or error " +
        "Errors: \n" + Joiner.on("\n").join(compiler.getErrors()) +
        "Warnings: \n" + Joiner.on("\n").join(compiler.getWarnings()),
        1, compiler.getErrors().length + compiler.getWarnings().length);

    assertTrue(exitCodes.size() > 0);
    int lastExitCode = exitCodes.get(exitCodes.size() - 1);

    if (compiler.getErrors().length > 0) {
      assertEquals(1, compiler.getErrors().length);
      assertEquals(warning, compiler.getErrors()[0].getType());
      assertEquals(1, lastExitCode);
    } else {
      assertEquals(1, compiler.getWarnings().length);
      assertEquals(warning, compiler.getWarnings()[0].getType());
      assertEquals(0, lastExitCode);
    }
  }

  private CommandLineRunner createCommandLineRunner(String[] original) {
    for (int i = 0; i < original.length; i++) {
      args.add("--js");
      args.add("/path/to/input" + i + ".js");
      if (useModules == ModulePattern.CHAIN) {
        args.add("--module");
        args.add("m" + i + ":1" + (i > 0 ? (":m" + (i - 1)) : ""));
      } else if (useModules == ModulePattern.STAR) {
        args.add("--module");
        args.add("m" + i + ":1" + (i > 0 ? ":m0" : ""));
      }
    }

    if (lastArg != null) {
      args.add(lastArg);
    }

    String[] argStrings = args.toArray(new String[] {});
    return new CommandLineRunner(
        argStrings,
        new PrintStream(outReader),
        new PrintStream(errReader));
  }

  private Compiler compile(String[] original) {
    CommandLineRunner runner = createCommandLineRunner(original);
    assertTrue(new String(errReader.toByteArray()), runner.shouldRunCompiler());
    Supplier<List<SourceFile>> inputsSupplier = null;
    Supplier<List<JSModule>> modulesSupplier = null;

    if (useModules == ModulePattern.NONE) {
      List<SourceFile> inputs = Lists.newArrayList();
      for (int i = 0; i < original.length; i++) {
        inputs.add(SourceFile.fromCode(getFilename(i), original[i]));
      }
      inputsSupplier = Suppliers.ofInstance(inputs);
    } else if (useModules == ModulePattern.STAR) {
      modulesSupplier = Suppliers.<List<JSModule>>ofInstance(
          Lists.<JSModule>newArrayList(
              CompilerTestCase.createModuleStar(original)));
    } else if (useModules == ModulePattern.CHAIN) {
      modulesSupplier = Suppliers.<List<JSModule>>ofInstance(
          Lists.<JSModule>newArrayList(
              CompilerTestCase.createModuleChain(original)));
    } else {
      throw new IllegalArgumentException("Unknown module type: " + useModules);
    }

    runner.enableTestMode(
        Suppliers.<List<SourceFile>>ofInstance(externs),
        inputsSupplier,
        modulesSupplier,
        new Function<Integer, Boolean>() {
          @Override
          public Boolean apply(Integer code) {
            return exitCodes.add(code);
          }
        });
    runner.run();
    lastCompiler = runner.getCompiler();
    lastCommandLineRunner = runner;
    return lastCompiler;
  }

  private Node parse(String[] original) {
    String[] argStrings = args.toArray(new String[] {});
    CommandLineRunner runner = new CommandLineRunner(argStrings);
    Compiler compiler = runner.createCompiler();
    List<SourceFile> inputs = Lists.newArrayList();
    for (int i = 0; i < original.length; i++) {
      inputs.add(SourceFile.fromCode(getFilename(i), original[i]));
    }
    CompilerOptions options = new CompilerOptions();
    // ECMASCRIPT5 is the most forgiving.
    options.setLanguageIn(LanguageMode.ECMASCRIPT5);
    compiler.init(externs, inputs, options);
    Node all = compiler.parseInputs();
    Preconditions.checkState(compiler.getErrorCount() == 0);
    Preconditions.checkNotNull(all);
    Node n = all.getLastChild();
    return n;
  }

  private void setFilename(int i, String filename) {
    this.filenames.put(i, filename);
  }

  private String getFilename(int i) {
    if (filenames.isEmpty()) {
      return "input" + i;
    }
    return filenames.get(i);
  }
}
