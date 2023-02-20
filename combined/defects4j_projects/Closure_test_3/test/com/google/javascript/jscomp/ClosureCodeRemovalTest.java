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
 * Tests for {@link ClosureCodeRemoval}
 *
 * @author robbyw@google.com (Robby Walker)
 */
public class ClosureCodeRemovalTest extends CompilerTestCase {

  private static String EXTERNS = "var window;";

  public ClosureCodeRemovalTest() {
    super(EXTERNS);
  }

public void testRemoveAbstract302() { 
     test("function Foo() {}; Foo.prototype.doSomething = goog.abstractMethod;", "function Foo() {};"); 
 }
public void testAssertionRemoval1303() { 
     test("var x = goog.asserts.assert(y(), 'message');", "var x = y();"); 
 }
  

  

  

  

  

  

  

  

  

  

  @Override
  protected ClosureCodeRemoval getProcessor(Compiler compiler) {
    return new ClosureCodeRemoval(compiler, true, true);
  }
}
