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

import com.google.javascript.jscomp.ExtractPrototypeMemberDeclarations.Pattern;

/**
 * Tests for {@link ExtractPrototypeMemberDeclarations}.
 *
 */
public class ExtractPrototypeMemberDeclarationsTest extends CompilerTestCase {
  private static final String TMP = "JSCompiler_prototypeAlias";
  private Pattern pattern = Pattern.USE_GLOBAL_TEMP;

  @Override
  protected void setUp() {
    super.enableLineNumberCheck(true);
    enableNormalize();
    pattern = Pattern.USE_GLOBAL_TEMP;
  }

  @Override
  protected CompilerPass getProcessor(Compiler compiler) {
    return new ExtractPrototypeMemberDeclarations(compiler, pattern);
  }


public void testWithDevirtualization4() { 
     pattern = Pattern.USE_ANON_FUNCTION; 
     extract("x.prototype.a = 1;" + "x.prototype.b = 1;" + "function devirtualize1() { }" + "x.prototype.c = 1;", "(function(" + TMP + "){" + TMP + ".a = 1;" + TMP + ".b = 1;" + TMP + ".c = 1;" + loadPrototype("x") + "function devirtualize1() { }"); 
     extract("x.prototype.a = 1;" + "function devirtualize1() { }" + "x.prototype.b = 1;" + "function devirtualize2() { }" + "x.prototype.c = 1;" + "function devirtualize3() { }", "(function(" + TMP + "){" + TMP + ".a = 1;" + TMP + ".b = 1;" + TMP + ".c = 1;" + loadPrototype("x") + "function devirtualize1() { }" + "function devirtualize2() { }" + "function devirtualize3() { }"); 
 }


public void testWithDevirtualization68() { 
     pattern = Pattern.USE_ANON_FUNCTION; 
     extract("x.prototype.a = 1;" + "x.prototype.b = 1;" + "function devirtualize() { }" + "x.prototype.c = 1;", "(function(" + TMP + "){" + TMP + ".a = 1;" + TMP + ".b = 1;" + TMP + ".c = 1;" + loadPrototype("x") + "function devirtualize1() { }"); 
     extract("x.prototype.a = 1;" + "function devirtualize1() { }" + "x.prototype.b = 1;" + "function devirtualize2() { }" + "x.prototype.c = 1;" + "function devirtualize3() { }", "(function(" + TMP + "){" + TMP + ".a = 1;" + TMP + ".b = 1;" + TMP + ".c = 1;" + loadPrototype("x") + "function devirtualize1() { }" + "function devirtualize2() { }" + "function devirtualize3() { }"); 
 }


public void testAnonWithDevirtualization69() { 
     pattern = Pattern.USE_ANON_FUNCTION; 
     extract("x.prototype.a = 1;" + "x.prototype.b = 1;" + "function devirtualize1() { }" + "x.prototype.c = 1;", "(function(" + TMP + "){" + TMP + ".a = 1;" + TMP + ".b = 1;" + TMP + ".c = 1;" + loadPrototype("x") + "function devirtualize1() { }"); 
     extract("x.prototype.a = 1;" + "function devirtualize2() { }" + "x.prototype.b = 1;" + "function devirtualize3() { }", "(function(" + TMP + "){" + TMP + ".a = 1;" + TMP + ".b = 1;" + TMP + ".c = 1;" + loadPrototype("x") + "function devirtualize1() { }" + "function devirtualize2() { }" + "function devirtualize3() { }"); 
 }


public void testBug1949424_v270() { 
     CompilerOptions options = createCompilerOptions(); 
     options.collapseProperties = true; 
     options.closurePass = true; 
     test(options, CLOSURE_BOILERPLATE + "goog.provide('FOO.BAR'); FOO.BAR = 3;", CLOSURE_COMPILED + "var FOO$BAR = 3;"); 
 }


public void testAnonWithDevirtualization71() { 
     pattern = Pattern.USE_ANON_FUNCTION; 
     extract("x.prototype.a = 1;" + "x.prototype.b = 1;" + "function devirtualize() { }" + "x.prototype.c = 1;", "(function(" + TMP + "){" + TMP + ".a = 1;" + TMP + ".b = 1;" + TMP + ".c = 1;" + loadPrototype("x") + "function devirtualize1() { }" + "function devirtualize2() { }" + "function devirtualize3() { }"); 
     extract("x.prototype.a = 1;" + "function devirtualize1() { }" + "x.prototype.b = 1;" + "function devirtualize2() { }" + "function devirtualize3() { }", "(function(" + TMP + "){" + TMP + ".a = 1;" + TMP + ".b = 1;" + TMP + ".c = 1;" + loadPrototype("x") + "function devirtualize1() { }" + "function devirtualize2() { }" + "function devirtualize3() { }"); 
 }


public void testAnonWithDevirtualization72() { 
     pattern = Pattern.USE_ANON_FUNCTION; 
     extract("x.prototype.a = 1;" + "x.prototype.b = 1;" + "function devirtualize1() { }" + "x.prototype.c = 1;", "(function(" + TMP + "){" + TMP + ".a = 1;" + TMP + ".b = 1;" + TMP + ".c = 1;" + loadPrototype("x") + "function devirtualize1() { }"); 
     extract("x.prototype.a = 1;" + "function devirtualize1() { }" + "x.prototype.b = 1;" + "function devirtualize2() { }" + "x.prototype.c = 1;" + "function devirtualize3() { }", "(function(" + TMP + "){" + TMP + ".a = 1;" + TMP + ".b = 1;" + TMP + ".c = 1;" + loadPrototype("x") + "function devirtualize1() { }" + "function devirtualize2() { }" + "function devirtualize3() { }"); 
 }


public void testAnonWithDevirtualization73() { 
     pattern = Pattern.USE_ANON_FUNCTION; 
     extract("x.prototype.a = 1;" + "x.prototype.b = 1;" + "function devirtualize() { }" + "x.prototype.c = 1;", "(function(" + TMP + "){" + TMP + ".a = 1;" + TMP + ".b = 1;" + TMP + ".c = 1;" + loadPrototype("x") + "function devirtualize1() { }" + "function devirtualize2() { }" + "function devirtualize3() { }"); 
     extract("x.prototype.a = 1;" + "function devirtualize4() { }" + "x.prototype.b = 1;" + "function devirtualize5() { }", "(function(" + TMP + "){" + TMP + ".a = 1;" + TMP + ".b = 1;" + TMP + ".c = 1;" + loadPrototype("x") + "function devirtualize1() { }" + "function devirtualize2() { }" + "function devirtualize3() { }"); 
 }


public void testAnonWithDevirtualization74() { 
     pattern = Pattern.USE_ANON_FUNCTION; 
     extract("x.prototype.a = 1;" + "x.prototype.b = 1;" + "function devirtualize() { }" + "x.prototype.c = 1;", "(function(" + TMP + "){" + TMP + ".a = 1;" + TMP + ".b = 1;" + TMP + ".c = 1;" + loadPrototype("x") + "function devirtualize1() { }"); 
     extract("x.prototype.a = 1;" + "function devirtualize1() { }" + "x.prototype.b = 1;" + "function devirtualize2() { }" + "x.prototype.c = 1;" + "function devirtualize3() { }", "(function(" + TMP + "){" + TMP + ".a = 1;" + TMP + ".b = 1;" + TMP + ".c = 1;" + loadPrototype("x") + "function devirtualize1() { }" + "function devirtualize2() { }" + "function devirtualize3() { }"); 
 }


public void testAnonWithDevirtualization75() { 
     pattern = Pattern.USE_GLOBAL_TEMP; 
     extract("x.prototype.a = 1;" + "x.prototype.b = 1;" + "function devirtualize() { }" + "x.prototype.c = 1;", "(function(" + TMP + "){" + TMP + ".a = 1;" + TMP + ".b = 1;" + TMP + ".c = 1;" + loadPrototype("x") + "function devirtualize1() { }"); 
     extract("x.prototype.a = 1;" + "function devirtualize1() { }" + "x.prototype.b = 1;" + "function devirtualize2() { }" + "x.prototype.c = 1;" + "function devirtualize3() { }", "(function(" + TMP + "){" + TMP + ".a = 1;" + TMP + ".b = 1;" + TMP + ".c = 1;" + loadPrototype("x") + "function devirtualize1() { }" + "function devirtualize2() { }" + "function devirtualize3() { }"); 
 }


public void testStringEscapeSequences76() { 
     assertPrintSame("var x=\"\\b\""); 
     assertPrintSame("var x=\"\\f\""); 
     assertPrintSame("var x=\"\\n\""); 
     assertPrintSame("var x=\"\\r\""); 
     assertPrintSame("var x=\"\\t\""); 
     assertPrintSame("var x=\"\\v\""); 
     assertPrint("var x=\"\\\"\"", "var x='\"'"); 
     assertPrint("var x=\"\\\'\"", "var x=\"'\""); 
     assertPrint("var x=\"\\u000A\"", "var x=\"\\n\""); 
     assertPrint("var x=\"\\u000D\"", "var x=\"\\r\""); 
     assertPrintSame("var x=\"\\u2028\""); 
     assertPrintSame("var x=\"\\u2029\""); 
     assertPrintSame("var x=/\\b/"); 
     assertPrintSame("var x=/\\f/"); 
     assertPrintSame("var x=/\\n/"); 
     assertPrintSame("var x=/\\r/"); 
     assertPrintSame("var x=/\\t/"); 
     assertPrintSame("var x=/\\v/"); 
     assertPrintSame("var x=/\\u000A/"); 
     assertPrintSame("var x=/\\u000D/"); 
     assertPrintSame("var x=/\\u2028/"); 
     assertPrintSame("var x=/\\u2029/"); 
 }


public void testGoogDefineClass377() { 
     CompilerOptions options = createCompilerOptions(); 
     CompilationLevel level = CompilationLevel.ADVANCED_OPTIMIZATIONS; 
     level.setOptionsForCompilationLevel(options); 
     level.setTypeBasedOptimizationOptions(options); 
     String code = "" + "var ns = {};\n" + "/** @constructor */\n" + "ns.C = function () {this.someProperty = 1}\n" + "alert(new ns.C().someProperty + new ns.C().someProperty);\n"; 
     assertTrue(options.inlineProperties); 
     assertTrue(options.collapseProperties); 
     test(options, code, "alert(2);"); 
 }


public void testSymmetryOfLeastSupertype78() { 
     List<JSType> listA = getTypesToTestForSymmetry(); 
     List<JSType> listB = getTypesToTestForSymmetry(); 
     for (JSType typeA : listA) { 
         for (JSType typeB : listB) { 
             TernaryValue aOnB = typeA.testForEquality(typeB); 
             TernaryValue bOnA = typeB.testForEquality(typeA); 
             assertTrue(String.format("testForEquality not symmetrical:\n" + "typeA: %s\ntypeB: %s\n" + "a.testForEquality(b): %s\n" + "b.testForEquality(a): %s\n", typeA, typeB, aOnB, bOnA), aOnB == bOnA); 
         } 
     } 
 }


public void testGoogAssertStripping79() { 
     args.add("--compilation_level=ADVANCED_OPTIMIZATIONS"); 
     test("goog.asserts.assert(false)", ""); 
     args.add("--debug"); 
     test("goog.asserts.assert(false)", "goog.$asserts$.$assert$(!1)"); 
 }


public void testFoldOneChildBlocksIntegration80() { 
     fold("function f(){switch(foo()){default:{break}}}", "function f(){foo()}"); 
     fold("function f(){switch(x){default:{break}}}", "function f(){}"); 
     fold("function f(){switch(x){default:x;case 1:return 2}}", "function f(){switch(x){default:case 1:return 2}}"); 
     fold("if(x){if(true){foo();foo()}else{bar();bar()}}", "if(x){foo();foo()}"); 
     fold("if(x){if(false){foo();foo()}else{bar();bar()}}", "if(x){bar();bar()}"); 
     fold("if(x()){}", "x()"); 
     fold("if(x()){} else {x()}", "x()||x()"); 
     fold("if(x){}", ""); 
     fold("if(a()){A()} else if (b()) {} else {C()}", "a()?A():b()||C()"); 
     fold("if(a()){} else if (b()) {} else {C()}", "a()||b()||C()"); 
     fold("if(a()){A()} else if (b()) {} else if (c()) {} else{D()}", "a()?A():b()||c()||D()"); 
     fold("if(a()){} else if (b()) {} else if (c()) {} else{D()}", "a()||b()||c()||D()"); 
     fold("if(a()){A()} else if (b()) {} else if (c()) {} else{}", "a()?A():b()||c()"); 
     fold("function foo(){if(x()){}}", "function foo(){x()}"); 
 }


public void testAnonWithDevirtualization81() { 
     pattern = Pattern.USE_ANON_FUNCTION; 
     extract("x.prototype.a = 1;" + "x.prototype.b = 1;" + "function devirtualize() { }" + "x.prototype.c = 1;", "(function(" + TMP + "){" + TMP + ".a = 1;" + TMP + ".b = 1;" + TMP + ".c = 1;" + loadPrototype("x") + "function devirtualize1() { }"); 
     extract("x.prototype.a = 1;" + "function devirtualize2() { }" + "x.prototype.b = 1;" + "function devirtualize3() { }", "(function(" + TMP + "){" + TMP + ".a = 1;" + TMP + ".b = 1;" + TMP + ".c = 1;" + loadPrototype("x") + "function devirtualize1() { }" + "function devirtualize2() { }" + "function devirtualize3() { }"); 
 }

  

  

  

  

  

  

  

  

  

  

  

  

  public String loadPrototype(String qName) {
    if (pattern == Pattern.USE_GLOBAL_TEMP) {
      return TMP + " = " + qName + ".prototype;";
    } else {
      return "})(" + qName + ".prototype);";
    }
  }

  public void extract(String src, String expected) {
    if (pattern == Pattern.USE_GLOBAL_TEMP) {
      test(src, "var " + TMP + ";" + expected);
    } else {
      test(src, expected);
    }
  }

  public String generatePrototypeDeclarations(String className, int num) {
    StringBuilder builder = new StringBuilder();
    for (int i = 0; i < num; i++) {
      char member = (char) ('a' + i);
      builder.append(generatePrototypeDeclaration(
          className, "" + member,  "" + member));
    }
    return builder.toString();
  }

  public String generatePrototypeDeclaration(String className, String member,
      String value) {
    return className + ".prototype." + member + " = " + value + ";";
  }

  public String generateExtractedDeclarations(int num) {
    StringBuilder builder = new StringBuilder();

    if (pattern == Pattern.USE_ANON_FUNCTION) {
      builder.append("(function(" + TMP + "){");
    }

    for (int i = 0; i < num; i++) {
      char member = (char) ('a' + i);
      builder.append(generateExtractedDeclaration("" + member,  "" + member));
    }
    return builder.toString();
  }

  public String generateExtractedDeclaration(String member, String value) {
    return TMP + "." + member + " = " + value + ";";
  }
}
