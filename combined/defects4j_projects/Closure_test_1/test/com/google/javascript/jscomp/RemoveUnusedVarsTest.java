/*
 * Copyright 2004 The Closure Compiler Authors.
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


public class RemoveUnusedVarsTest extends CompilerTestCase {

  private boolean removeGlobal;
  private boolean preserveFunctionExpressionNames;
  private boolean modifyCallSites;

  public RemoveUnusedVarsTest() {
    super("function alert() {}");
    enableNormalize();
  }

  @Override
  public void setUp() {
    removeGlobal = true;
    preserveFunctionExpressionNames = false;
    modifyCallSites = false;
  }

  @Override
  protected CompilerPass getProcessor(final Compiler compiler) {
    return new RemoveUnusedVars(
        compiler, removeGlobal, preserveFunctionExpressionNames,
        modifyCallSites);
  }

public void testUnusedPropAssign1b834() { 
     test("var x = {}; x.foo = alert();", "alert()"); 
 }
public void testUsedPropAssign7835() { 
     testSame("var x = {}; for (x in alert()) { x.foo = 3; }"); 
 }
  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  
}
