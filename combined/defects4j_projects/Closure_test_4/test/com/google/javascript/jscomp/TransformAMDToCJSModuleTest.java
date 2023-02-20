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
 * Unit tests for {@link TransformAMDToCJSModule}
 */
public class TransformAMDToCJSModuleTest extends CompilerTestCase {

  @Override protected CompilerPass getProcessor(Compiler compiler) {
    return new TransformAMDToCJSModule(compiler);
  }

  @Override
  protected int getNumRepetitions() {
    return 1;
  }

public void testDefineOnlyFunction505() { 
     test("define(function() { return { test: 1 } })", "module.exports={test:1}"); 
     test("define(function(exports, module) { return { test: 1 } })", "module.exports={test:1}"); 
 }
  

  

  

  

  

  

  

  private void testUnsupported(String js) {
    test(js, null, TransformAMDToCJSModule.UNSUPPORTED_DEFINE_SIGNATURE_ERROR);
  }

  private void testNonTopLevelDefine(String js) {
    test(js, null,
        TransformAMDToCJSModule.NON_TOP_LEVEL_STATEMENT_DEFINE_ERROR);
  }

}
