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
 * Unit test for {@link NameAnonymousFunctionsTest}.
 *
 */
public class NameAnonymousFunctionsTest extends CompilerTestCase {

  private static final String EXTERNS = "var document;";

  public NameAnonymousFunctionsTest() {
    super(EXTERNS);
  }

  @Override public CompilerPass getProcessor(Compiler compiler) {
    return new NameAnonymousFunctions(compiler);
  }

public void testAssignmentToPrototype4298() { 
     test("function a() {} a['prototype']['b'] = function() { return 1; };", "function a() {} " + "a['prototype']['b'] = function $a$$b$() { return 1; };"); 
 }
public void testAssignmentToPrototype4526() { 
     test("var Y = 1; function a() {} " + "a.prototype[Y] = function() { return 1; };", "var Y = 1; function a() {} " + "a.prototype[Y] = function $() { return 1; };"); 
 }
  

  

  

  

  

  

  

  

  

  

  

  

  

  
}
