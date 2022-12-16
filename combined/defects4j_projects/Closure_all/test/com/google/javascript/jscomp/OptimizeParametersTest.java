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
 * Tests for {@link OptimizeParameters}
 *
 */
public class OptimizeParametersTest extends CompilerTestCase {
  @Override
  public CompilerPass getProcessor(Compiler compiler) {
    return new OptimizeParameters(compiler);
  }

  @Override
  public void setUp() {
    super.enableNormalize();
    super.enableLineNumberCheck(false);
  }


public void testGoldenOutput0a50() throws Exception { 
     checkSourceMap("a;", "{\n" + "\"version\":3,\n" + "\"file\":\"testcode\",\n" + "\"lineCount\":1,\n" + "\"mappings\":\"AAAAA;\",\n" + "\"sources\":[\"testcode\"],\n" + "\"names\":[\"a\"]\n" + "}\n"); 
 }


public void testReport349() { 
     final List<JSError> errors = new ArrayList<JSError>(); 
     Compiler compiler = new Compiler(new BasicErrorManager() { 
  
         @Override 
         public void report(CheckLevel level, JSError error) { 
             errors.add(error); 
         } 
  
         @Override 
         public void println(CheckLevel level, JSError error) { 
         } 
  
         @Override 
         protected void printSummary() { 
         }); 
     }); 
     compiler.initCompilerOptionsIfTesting(); 
     NodeTraversal t = new NodeTraversal(compiler, null); 
     DiagnosticType[] warnings = new DiagnosticType[] { RhinoErrorReporter.PARSE_ERROR, RhinoErrorReporter.PARSE_ERROR, RhinoErrorReporter.PARSE_ERROR, RhinoErrorReporter.PARSE_ERROR, RhinoErrorReporter.PARSE_ERROR, RhinoErrorReporter.PARSE_ERROR, RhinoErrorReporter.PARSE_ERROR, RhinoErrorReporter.PARSE_ERROR, RhinoErrorReporter.PARSE_ERROR, RhinoErrorReporter.PARSE_ERROR, RhinoErrorReporter.PARSE_ERROR, RhinoErrorReporter.PARSE_ERROR, RhinoErrorReporter.PARSE_ERROR, RhinoErrorReporter.PARSE_ERROR, RhinoErrorReporter.PARSE_ERROR, RhinoErrorReporter.PARSE_ERROR, RhinoErrorReporter.PARSE_ERROR, RhinoErrorReporter.PARSE_ERROR, RhinoErrorReporter.PARSE_ERROR, RhinoErrorReporter.PARSE_ERROR, RhinoErrorReporter.PARSE_ERROR, RhinoErrorReporter.PARSE_ERROR, RhinoErrorReporter.PARSE_ERROR, RhinoErrorReporter.PARSE_ERROR, RhinoErrorReporter.PARSE_ERROR, RhinoErrorReporter.PARSE_ERROR, RhinoErrorReporter.PARSE_ERROR, RhinoErrorReporter.PARSE_ERROR, RhinoErrorReporter.PARSE_ERROR, RhinoErrorReporter.PARSE_ERROR, RhinoErrorReporter.PARSE_ERROR,


public void testCommonJSProvidesAndRequire350() throws Exception { 
     List<SourceFile> inputs = Lists.newArrayList(SourceFile.fromCode("gin.js", "require('tonic')"), SourceFile.fromCode("tonic.js", ""), SourceFile.fromCode("mix.js", "require('gin'); require('tonic');")); 
     List<String> entryPoints = Lists.newArrayList("module$mix"); 
     Compiler compiler = initCompilerForCommonJS(inputs, entryPoints); 
     JSModuleGraph graph = compiler.getModuleGraph(); 
     assertEquals(4, graph.getModuleCount()); 
     List<CompilerInput> result = graph.manageDependencies(entryPoints, compiler.getInputsForTesting()); 
     assertEquals("[root]", result.get(0).getName()); 
     assertEquals("[module$tonic]", result.get(1).getName()); 
     assertEquals("[module$gin]", result.get(2).getName()); 
     assertEquals("tonic.js", result.get(3).getName()); 
     assertEquals("gin.js", result.get(4).getName()); 
     assertEquals("mix.js", result.get(5).getName()); 
 }


public void testExternsLifting1351() throws Exception { 
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


public void testConstKeywordMayEffectMutableState352() { 
     assertMutableState(true, "i++"); 
     assertMutableState(true, "[b, [a, i++]]"); 
     assertMutableState(true, "i=3"); 
     assertMutableState(true, "[0, i=3]"); 
     assertMutableState(true, "b()"); 
     assertMutableState(true, "void b()"); 
     assertMutableState(true, "[1, b()]"); 
     assertMutableState(true, "b.b=4"); 
     assertMutableState(true, "b.b--"); 
     assertMutableState(true, "i--"); 
     assertMutableState(true, "a[0][i=4]"); 
     assertMutableState(true, "a += 3"); 
     assertMutableState(true, "a, b, z += 4"); 
     assertMutableState(true, "a ? c : d++"); 
     assertMutableState(true, "a + c++"); 
     assertMutableState(true, "a + c - d()"); 
     assertMutableState(true, "a + c - d()"); 
     assertMutableState(true, "function foo() {}"); 
     assertMutableState(true, "while(true);"); 
     assertMutableState(true, "if(true){a()}"); 
     assertMutableState(false, "if(true){a}"); 
     assertMutableState(true, "(function() { })"); 
     assertMutableState(true, "(function() { i++ })"); 
     assertMutableState(true, "[function a(){}]"); 
     assertMutableState(false, "a"); 
     assertMutableState(true, "[b, c [d, [e]]]"); 
     assertMutableState(true, "({a: x, b: y, c: z})"); 
     assertMutableState(true, "/abc/gi"); 
     assert


public void testReport353() { 
     final List<JSError> errors = new ArrayList<JSError>(); 
     Compiler compiler = new Compiler(new BasicErrorManager() { 
  
         @Override 
         public void report(CheckLevel level, JSError error) { 
             errors.add(error); 
         } 
  
         @Override 
         public void println(CheckLevel level, JSError error) { 
         } 
  
         @Override 
         protected void printSummary() { 
         }); 
     }); 
     compiler.initCompilerOptionsIfTesting(); 
     NodeTraversal t = new NodeTraversal(compiler, null); 
     DiagnosticType dt = DiagnosticType.warning("FOO", "{0}, {1} - {2}"); 
     t.report(null, dt, "Foo", "Bar", "Hello"); 
     assertEquals(1, errors.size()); 
     assertEquals("Foo, Bar - Hello", errors.get(0).description); 
 }


public void testAlwaysRunSafetyCheck354() { 
     CompilerOptions options = createCompilerOptions(); 
     options.checkSymbols = false; 
     options.customPasses = ArrayListMultimap.create(); 
     options.customPasses.put(CustomPassExecutionTime.BEFORE_OPTIMIZATIONS, new CompilerPass() { 
  
         @Override 
         public void process(Node externs, Node root) { 
             Node var = root.getLastChild().getFirstChild(); 
             assertEquals(Token.VAR, var.getType()); 
             var.detachFromParent(); 
         } 
     }); 
     try { 
         test(options, "var x = 3; function f() { return x + z; }", "function f() { return x + z; }"); 
         fail("Expected run-time exception"); 
     } catch (RuntimeException e) { 
         assertTrue(e.getMessage().indexOf("Unexpected variable x") != -1); 
     } 
 }


public void testChainModuleManifest355() throws Exception { 
     useModules = ModulePattern.CHAIN; 
     testSame(new String[] { "var x = 3;", "var y = 5;", "var z = 7;", "var a = 9;" }); 
     StringBuilder builder = new StringBuilder(); 
     lastCommandLineRunner.printModuleGraphManifestOrBundleTo(lastCompiler.getModuleGraph(), builder, true); 
     assertEquals("{m0}\n" + "i0\n" + "\n" + "{m1:m0}\n" + "i1\n" + "\n" + "{m2:m1}\n" + "i2\n" + "\n" + "{m3:m2}\n" + "i3\n", builder.toString()); 
 }


public void testNoMoveSideEffectProperty356() { 
     testSame(createModuleChain("function Foo(){} " + "Foo.prototype.bar = createSomething();", "new Foo();")); 
 }

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  
}
