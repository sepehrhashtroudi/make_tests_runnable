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

public void testSimpleRemoval11() { 
     test("function foo(p1) { } foo(); foo()", "function foo() {var p1;} foo(); foo()"); 
     test("function foo(p1) { } foo(1); foo(1)", "function foo() {var p1 = 1;} foo(); foo()"); 
     test("function foo(p1) { } foo(1,2); foo(1,4)", "function foo() {var p1 = 1;} foo(2); foo(4)"); 
 }
public void testDoNotOptimizeWhenArgumentsPassedAsParameter12() { 
     testSame("function foo(a) {}; foo(arguments)"); 
     testSame("function foo(a) {}; foo(arguments[0])"); 
     test("function foo(a, b) {}; foo(arguments, 1)", "function foo(a) {var b = 1}; foo(arguments)"); 
     test("function foo(a, b) {}; foo(arguments)", "function foo(a) {var b}; foo(arguments)"); 
 }
  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  
}
