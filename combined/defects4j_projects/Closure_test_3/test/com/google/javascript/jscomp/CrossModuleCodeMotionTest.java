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

/**
 * Tests for {@link CrossModuleCodeMotion}.
 *
 */
public class CrossModuleCodeMotionTest extends CompilerTestCase {

  private static final String EXTERNS = "alert";

  public CrossModuleCodeMotionTest() {
    super(EXTERNS);
  }

  @Override
  public void setUp() {
    super.enableLineNumberCheck(true);
  }

  @Override
  public CompilerPass getProcessor(Compiler compiler) {
    return new CrossModuleCodeMotion(compiler, compiler.getModuleGraph());
  }

public void testBug4118005452() { 
     testSame(createModuleChain("var m = 1;\n" + "(function () {\n" + " var x = 1;\n" + " m = function() { return x };\n" + "})();\n", "m();")); 
 }
public void testLiteralMovement2454() { 
     testSame(createModuleChain("var f = {'hi': 'mom', 'bye': goog.nullFunction};", "var h = f;")); 
 }
public void testClone1455() { 
     test(createModuleChain("function f(){} f.prototype.clone = function() { return new f };", "var a = (new f).clone();"), new String[] { "", "function f(){} f.prototype.clone = function() { return new f() };" + "var a = (new f).clone();" }); 
 }
public void testVarMovement7456() { 
     testSame(createModuleStar("function f() {g();}", "function g(){};")); 
 }
public void testClassMovement1457() { 
     test(createModuleStar("function f(){} f.prototype.bar=function (){};", "var a = new f();"), new String[] { "", "function f(){} f.prototype.bar=function (){};" + "var a = new f();" }); 
 }
public void testFunctionMovement6458() { 
     JSModule[] modules = createModuleChain("function f(){return 1}", "var a = f();", "var b = f();"); 
     test(modules, new String[] { "", "function f(){return 1}" + "var a = f();", "var b = f();" }); 
 }
public void testClassMovement6459() { 
     test(createModuleChain("function Foo(){} function Bar(){} goog.inherits(Bar, Foo);" + "new Foo();", "new Bar();"), new String[] { "function Foo(){} new Foo();", "function Bar(){} goog.inherits(Bar, Foo); new Bar();" }); 
 }
  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  


  


  

  

  

  

  

  

  

  

  
}
