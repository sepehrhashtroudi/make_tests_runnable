/*
 * Copyright 2011 The Closure Compiler Authors.
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
 * Unit tests for {@link StatementFusion}.
 *
 */
public class StatementFusionTest extends CompilerTestCase  {

  @Override
  public void setUp() throws Exception {
    super.setUp();
    enableLineNumberCheck(true);
  }

  @Override
  public CompilerPass getProcessor(final Compiler compiler) {
    PeepholeOptimizationsPass peepholePass =
      new PeepholeOptimizationsPass(compiler, new StatementFusion());

    return peepholePass;
  }

public void testNothingToDo39() { 
     fuseSame(""); 
     fuseSame("a"); 
     fuseSame("a()"); 
     fuseSame("if(a()){}"); 
 }
public void testFoldBlockWithStatements40() { 
     fuse("a;b;c", "a,b,c"); 
     fuse("a();b();c();", "a(),b(),c()"); 
     fuse("a(),b();c(),d()", "a(),b(),c(),d()"); 
     fuse("a();b(),c(),d()", "a(),b(),c(),d()"); 
     fuse("a(),b(),c();d()", "a(),b(),c(),d()"); 
 }
  

  

  

  

  

  

  

  

  

  

  

  private void fuse(String before, String after) {
    test("function F(){if(CONDITION){" + before + "}}",
         "function F(){if(CONDITION){" + after + "}}");
  }

  private void fuseSame(String code) {
    fuse(code, code);
  }
}