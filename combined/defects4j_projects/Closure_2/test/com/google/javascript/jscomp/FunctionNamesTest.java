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

import com.google.common.collect.Maps;
import com.google.javascript.rhino.Node;

import java.util.Map;

/**
 * Tests for {@link FunctionNames}
 *
 */
public class FunctionNamesTest extends CompilerTestCase {
  private FunctionNames functionNames;

  public FunctionNamesTest() {
    this.functionNames = null;
  }

  @Override
  protected CompilerPass getProcessor(Compiler compiler) {
    functionNames = new FunctionNames(compiler);
    return functionNames;
  }

public void testSimple23() { 
     test("function foo()   { alert(arguments[0]); }", "function foo(p0) { alert(p0); }"); 
 }
  
}
