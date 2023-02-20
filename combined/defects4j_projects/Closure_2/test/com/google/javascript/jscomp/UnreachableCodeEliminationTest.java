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
 * Test for {@link UnreachableCodeElimination}.
 *
 */
public class UnreachableCodeEliminationTest extends CompilerTestCase {
  private boolean removeNoOpStatements = true;

  @Override
  protected CompilerPass getProcessor(Compiler compiler) {
    return new UnreachableCodeElimination(compiler, removeNoOpStatements);
  }

  @Override public void setUp() throws Exception {
    super.setUp();
    removeNoOpStatements = true;
  }

public void testRemoveDo1() { 
     test("do { print(1); break } while(1)", "do { print(1); break } while(1)"); 
     test("while(1) { break; do { print(1); break } while(1) }", "while(1) { break; do {} while(1) }"); 
 }
public void testRemoveTryCatchFinally548() { 
     test("try{var a=1;}catch(ex){var b=2;}finally{var c=3;}", "var b;var a=1;var c=3"); 
     test("try{var a=1;var b=2}catch(ex){var c=3;var d=4;}finally{var e=5;" + "var f=6;}", "var d;var c;var a=1;var b=2;var e=5;var f=6"); 
 }
  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  
}
