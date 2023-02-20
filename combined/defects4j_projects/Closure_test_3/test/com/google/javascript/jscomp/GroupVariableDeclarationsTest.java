/*
 * Copyright 2010 The Closure Compiler Authors.
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

public class GroupVariableDeclarationsTest extends CompilerTestCase {

  @Override
  protected void setUp() {
    super.enableLineNumberCheck(false);
  }

public void testGroupingInitializedVarsInScope134() { 
     test("var a = 1; f1(); var b = 2;", "var a = 1, b; f1(); b = 2;"); 
     test("var a = \"mangoes\"; f1(); alert(a); var b = 2;", "var a = \"mangoes\", b; f1(); alert(a); b = 2;"); 
     test("var a = 1; {var c = 34; alert(c);} var b = 2;", "var a = 1, c, b; {c = 34; alert(c);} b = 2;"); 
     test("var a = 1; var b = 1; f1(); f2(); var c = 3; var d = 4;", "var a = 1, b, c, d; b = 1; f1(); f2(); c = 3; d = 4;"); 
     test("var a = 1; var b = 2; var c; f1(); f2(); var d = 4, e;", "var a = 1, b, c, d, e; b = 2; f1(); f2(); d = 4;"); 
     test("var a = 1, b = 2, c; f1(); f2(); var d; var e = 6; " + "f3(); f4(); var f; var g; var h = a + b;", "var a = 1, b = 2, c, d, e, f, g, h; f1(); f2(); e = 6; " + "f3(); f4(); h = a + b;"); 
 }
  

  

  

  

  

  

  

  @Override
  protected CompilerPass getProcessor(Compiler compiler) {
    return new GroupVariableDeclarations(compiler);
  }
}
