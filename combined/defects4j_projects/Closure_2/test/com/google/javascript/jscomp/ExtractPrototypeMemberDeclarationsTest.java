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

public void testExtractPrototypeMemberDeclarations259() { 
     extract("x.prototype.a = 1;" + "x.prototype.b = 1;" + "function devirtualize1() { }" + "x.prototype.c = 1;", "(function(" + TMP + "){" + TMP + ".a = 1;" + TMP + ".b = 1;" + TMP + ".c = 1;" + loadPrototype("x") + "function devirtualize1() { }" + "x.prototype.b = 1;" + "function devirtualize2() { }" + "x.prototype.c = 1;" + "function devirtualize3() { }"); 
     extract("x.prototype.a = 1;" + "x.prototype.b = 1;" + "function devirtualize1() { }" + "x.prototype.b = 1;" + "function devirtualize2() { }" + "x.prototype.c = 1;" + "function devirtualize3() { }", "(function(" + TMP + "){" + TMP + ".a = 1;" + TMP + ".b = 1;" + TMP + ".c = 1;" + loadPrototype("x") + "function devirtualize1() { }" + "function devirtualize2() { }" + "function devirtualize3() { }"); 
 }
public void testAnonWithDevirtualization261() { 
     pattern = Pattern.USE_ANON_FUNCTION; 
     extract("x.prototype.a = 1;" + "x.prototype.b = 1;" + "function devirtualize() { }" + "x.prototype.c = 1;", "(function(" + TMP + "){" + TMP + ".a = 1;" + TMP + ".b = 1;" + TMP + ".c = 1;" + loadPrototype("x") + "function devirtualize() { }"); 
     extract("x.prototype.a = 1;" + "function devirtualize1() { }" + "x.prototype.b = 1;" + "function devirtualize2() { }" + "x.prototype.c = 1;" + "function devirtualize3() { }", "(function(" + TMP + "){" + TMP + ".a = 1;" + TMP + ".b = 1;" + TMP + ".c = 1;" + loadPrototype("x") + "function devirtualize1() { }" + "function devirtualize2() { }" + "function devirtualize3() { }"); 
 }
public void testAnonWithDevirtualization262() { 
     pattern = Pattern.USE_ANON_FUNCTION; 
     extract("x.prototype.a = 1;" + "x.prototype.b = 1;" + "function devirtualize1() { }" + "x.prototype.c = 1;", "(function(" + TMP + "){" + TMP + ".a = 1;" + TMP + ".b = 1;" + TMP + ".c = 1;" + loadPrototype("x") + "function devirtualize1() { }" + "x.prototype.b = 1;" + "function devirtualize2() { }" + "x.prototype.c = 1;" + "function devirtualize3() { }"); 
     extract("x.prototype.a = 1;" + "x.prototype.b = 1;" + "function devirtualize1() { }" + "x.prototype.b = 1;" + "function devirtualize2() { }" + "x.prototype.c = 1;" + "function devirtualize3() { }", "(function(" + TMP + "){" + TMP + ".a = 1;" + TMP + ".b = 1;" + TMP + ".c = 1;" + loadPrototype("x") + "function devirtualize1() { }" + "function devirtualize2() { }" + "function devirtualize3() { }"); 
 }
public void testWithDevirtualization263() { 
     extract("x.prototype.a = 1;" + "x.prototype.b = 1;" + "function devirtualize1() { }" + "x.prototype.c = 1;", "(function(" + TMP + "){" + TMP + ".a = 1;" + TMP + ".b = 1;" + TMP + ".c = 1;" + loadPrototype("x") + "function devirtualize1() { }" + "x.prototype.b = 1;" + "function devirtualize2() { }" + "x.prototype.c = 1;" + "function devirtualize3() { }"); 
     extract("x.prototype.a = 1;" + "x.prototype.b = 1;" + "function devirtualize1() { }" + "x.prototype.b = 1;" + "function devirtualize2() { }" + "x.prototype.c = 1;" + "function devirtualize3() { }", "(function(" + TMP + "){" + TMP + ".a = 1;" + TMP + ".b = 1;" + TMP + ".c = 1;" + loadPrototype("x") + "function devirtualize1() { }" + "function devirtualize2() { }" + "function devirtualize3() { }"); 
 }
public void testAnonWithSideFx264() { 
     pattern = Pattern.USE_ANON_FUNCTION; 
     testSame("function foo() {};" + "foo.prototype.a1 = 1;" + "bar();;" + "foo.prototype.a2 = 2;" + "bar();;" + "foo.prototype.a3 = 3;" + "bar();;" + "foo.prototype.a4 = 4;" + "bar();;" + "foo.prototype.a5 = 5;" + "bar();;" + "foo.prototype.a6 = 6;" + "bar();;" + "foo.prototype.a7 = 7;" + "bar();"); 
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
