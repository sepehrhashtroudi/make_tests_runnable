/*
 * Copyright 2006 The Closure Compiler Authors.
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
 * Tests for variable declaration collapsing.
 *
 */
public class CollapseVariableDeclarationsTest extends CompilerTestCase {
public void testAggressiveRedeclaration361() { 
     test("var x = 2; foo(x);     x = 3; var y = 2;", "var x = 2; foo(x); var x = 3,     y = 2;"); 
 }
public void testAggressiveRedeclaration362() { 
     test("var x = 2; foo(x);     x = 3; var y = 2;", "var x = 2; foo(x); var x = 3,     y = 2;"); 
     test("var x = 2; foo(x);     x = 3; x = 1; var y = 2;", "var x = 2; foo(x); var x = 3, x = 1,     y = 2;"); 
     test("var x = 2; foo(x);     x = 3; x = 1; var y = 2; var z = 4", "var x = 2; foo(x); var x = 3, x = 1,     y = 2,     z = 4"); 
     test("var x = 2; foo(x);     x = 3; x = 1; var y = 2; var z = 4; x = 5", "var x = 2; foo(x); var x = 3, x = 1,     y = 2,     z = 4, x = 5"); 
 }
  

  

  

  

  

  

  @Override
  protected CompilerPass getProcessor(Compiler compiler) {
    return new CollapseVariableDeclarations(compiler);
  }
}
