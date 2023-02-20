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

/**
 * Tests for {@link ExternExportsPass}.
 *
 * @author dcc@google.com (Devin Coughlin)
 */
public class PeepholeFoldWithTypesTest extends CompilerTestCase {

  @Override
  protected CompilerPass getProcessor(Compiler compiler) {
    return new PeepholeOptimizationsPass(compiler, new PeepholeFoldWithTypes());
  }

  @Override
  public void setUp() {
    enableTypeCheck(CheckLevel.WARNING);
  }

public void testFoldTypeof97() { 
     test("x = typeof 1", "x = \"number\""); 
     test("x = typeof 'foo'", "x = \"string\""); 
     test("x = typeof true", "x = \"boolean\""); 
     test("x = typeof false", "x = \"boolean\""); 
     test("x = typeof null", "x = \"object\""); 
     test("x = typeof undefined", "x = \"undefined\""); 
     test("x = typeof void 0", "x = \"undefined\""); 
     test("x = typeof []", "x = \"object\""); 
     test("x = typeof [1]", "x = \"object\""); 
     test("x = typeof [1,[]]", "x = \"object\""); 
     test("x = typeof {}", "x = \"object\""); 
     test("x = typeof function() {}", "x = 'function'"); 
     testSame("x = typeof[1,[foo()]]"); 
     testSame("x = typeof{bathwater:baby()}"); 
 }
public void testDontFoldTypeofUnionTypes99() { 
     testSame("var x = (unknown ? {} : null);typeof x"); 
 }
public void testFoldTypeof100() { 
     test("var x = typeof 1", "var x = \"number\""); 
     test("var x = typeof 'foo'", "var x = \"string\""); 
     test("var x = typeof true", "var x = \"boolean\""); 
     test("var x = typeof false", "var x = \"boolean\""); 
     test("var x = typeof null", "var x = \"object\""); 
     test("var x = typeof undefined", "var x = \"undefined\""); 
     test("var x = typeof void 0", "var x = \"undefined\""); 
     test("var x = typeof []", "var x = \"object\""); 
     test("var x = typeof [1]", "var x = \"object\""); 
     test("var x = typeof [1,[]]", "var x = \"object\""); 
     test("var x = typeof {}", "var x = \"object\""); 
     test("var x = typeof function() {}", "var x = 'function'"); 
     testSame("var x = typeof[1,[foo()]]"); 
     testSame("var x = typeof{bathwater:baby()}"); 
 }
  

  

  

  

  

  

  

  
}
