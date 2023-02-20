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

public void testMultipleUnknown8() { 
     String src = "var goog1 = {};" + "goog1.foo = function () { };" + "var goog2 = {};" + "goog2.foo = function (p1) { };" + "var x = getGoog();" + "x.foo()"; 
     String expected = "var goog1 = {};" + "goog1.foo = function () { };" + "var goog2 = {};" + "goog2.foo = function () { var p1 };" + "var x = getGoog();" + "x.foo()"; 
     testSame(src); 
 }
public void testMutableValues410() { 
     testSame("var x; var y; var z;" + "function foo(p1, p2, p3) {}" + "foo(x(), y(), z()); foo(x(),y(),3)"); 
     testSame("var x; var y; var z;" + "function foo(p1, p2, p3) {}" + "foo(x, y(), z()); foo(x,y(),3)"); 
     test("var x; var y; var z;" + "function foo(p1, p2, p3) {}" + "foo([], y(), z()); foo([],y(),3)", "var x; var y; var z;" + "function foo(p2, p3) {var p1=[]}" + "foo(y(), z()); foo(y(),3)"); 
 }
public void testOptimizeOnlyImmutableValues11() { 
     test("function foo(a) {}; foo(undefined);", "function foo() {var a = undefined}; foo()"); 
     test("function foo(a) {}; foo(null);", "function foo() {var a = null}; foo()"); 
     test("function foo(a) {}; foo('abc');", "function foo() {var a = 'abc'}; foo()"); 
     test("function foo(a) {}; foo('abc');", "function foo() {var a = 'abc'}; foo()"); 
     test("var foo = function(a) {}; foo(undefined);", "var foo = function() {var a = undefined}; foo()"); 
     test("var foo = function(a) {}; foo('abc');", "var foo = function() {var a = 'abc'}; foo()"); 
     test("var foo = function(a) {}; foo('abc');", "var foo = function() {var a = 'abc'}; foo()"); 
     test("var foo = function(a) {}; foo('abc');", "var foo = function() {var a = 'abc'}; foo()"); 
 }
public void testNoRemoval756() { 
     testSame("function foo(p1) { } foo(1); foo(2)"); 
     testSame("function foo(p1) { } foo(1,2); foo(3,4)"); 
 }
  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  
}
