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

public void testFunctionNonMovement1443() { 
     testSame(createModuleStar("function f(){};f.prototype.bar=new f;" + "if(a)function f2(){}" + "{{while(a)function f3(){}}}", "var a = new f();f2();f3();")); 
 }
public void testAssignMovement444() { 
     test(createModuleChain("var f = 3;" + "f = 5;", "var h = f;"), new String[] { "", "var f = 3;" + "f = 5;" + "var h = f;" }); 
     testSame(createModuleChain("var f = 3;" + "var g = f = 5;", "var h = f;")); 
 }
  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  


  


  

  

  

  

  

  

  

  

  
}
