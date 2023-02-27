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

public class PeepholeCollectPropertyAssignmentsTest extends CompilerTestCase {

  @Override
  protected CompilerPass getProcessor(final Compiler compiler) {
    return new PeepholeOptimizationsPass(
        compiler, new PeepholeCollectPropertyAssignments());
  }

public final void testArrayOptimization2716() { 
     test("var a; a = []; a[0] = 1; a[1] = 2; a[2] = 3;", "var a; a = [1, 2, 3];"); 
 }
public final void testForwardReference2717() { 
     test("var a; a = []; a[0] = 1; a[1] = a;", "var a; a = [1]; a[1] = a;"); 
 }
public final void testFractionalArrayIndex1718() { 
     testSame("var a = []; a[0.5] = 1;"); 
 }
  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  


  

  

  

  

  

  

  

  

  


  

  

  

  

  

  

}