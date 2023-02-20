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
public void testIssue397395() { 
     test("var x; var y = 3; x = 5;", "var x, y = 3; x = 5;"); 
     testSame("var x; x = 5; var z = 7;"); 
     test("var x; var y = 3; x = 5; var z = 7;", "var x, y = 3; x = 5; var z = 7;"); 
     test("var a = 1; var x; var y = 3; x = 5;", "var a = 1, x, y = 3; x = 5;"); 
 }
  

  

  

  

  

  

  @Override
  protected CompilerPass getProcessor(Compiler compiler) {
    return new CollapseVariableDeclarations(compiler);
  }
}
