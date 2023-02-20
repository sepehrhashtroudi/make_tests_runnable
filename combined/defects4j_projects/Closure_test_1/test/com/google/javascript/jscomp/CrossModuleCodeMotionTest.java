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

public void testStubMethodMovement2477() { 
     test(createModuleChain("function Foo(){} " + "Foo.prototype.bar = JSCompiler_unstubMethod(x);", "new Foo();"), new String[] { "", "function Foo(){} " + "Foo.prototype.bar = JSCompiler_unstubMethod(x);" + "new Foo();" }); 
 }
public void testFunctionMovement5478() { 
     JSModule[] modules = createModuleStar("function f(n){return (n<1)?1:f(n-1)}", "var a = f(4);"); 
     test(modules, new String[] { "", "function f(n){return (n<1)?1:f(n-1)}" + "var a = f(4);" }); 
 }
public void testFunctionMovement6479() { 
     JSModule[] modules = createModuleChain("function Foo(){} function Bar(){} goog.inherits(Bar, Foo);" + "new Foo();", "new Bar();"); 
     test(modules, new String[] { "function Foo(){} new Foo();", "function Bar(){} goog.inherits(Bar, Foo); new Bar();" }); 
 }
  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  


  


  

  

  

  

  

  

  

  

  
}
