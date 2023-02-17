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
 * Verifies that valid candidates for object literals are inlined as
 * expected, and invalid candidates are not touched.
 *
 */
public class InlineObjectLiteralsTest extends CompilerTestCase {

  public InlineObjectLiteralsTest() {
    enableNormalize();
  }

  @Override
  public void setUp() {
    super.enableLineNumberCheck(true);
  }

  @Override
  protected CompilerPass getProcessor(final Compiler compiler) {
    return new InlineObjectLiterals(
        compiler,
        compiler.getUniqueNameIdSupplier());
  }

  // Test object literal -> variable inlining

public void testObject222() { 
     testLocal("while(1) { var a = {y:1}; if (b) a.x = 2; f(a.y, a.x);}", "for(;1;){" + " var JSCompiler_object_inline_y_0=1;" + " var JSCompiler_object_inline_x_1;" + " if(b) JSCompiler_object_inline_x_1=2;" + " f(JSCompiler_object_inline_y_0,JSCompiler_object_inline_x_1)" + "}"); 
     testLocal("var a; while (1) { f(a.x, a.y); a = {x:1, y:1};}", "var a; while (1) { f(a.x, a.y); a = {x:1, y:1};}"); 
 }
  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  private final String LOCAL_PREFIX = "function local(){";
  private final String LOCAL_POSTFIX = "}";

  private void testLocal(String code, String result) {
    test(LOCAL_PREFIX + code + LOCAL_POSTFIX,
         LOCAL_PREFIX + result + LOCAL_POSTFIX);
  }

  private void testSameLocal(String code) {
    testLocal(code, code);
  }
}
