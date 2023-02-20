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

public void testDoNotRemoveNonQualifiedName338() { 
     testSame("document.getElementById('x').y = goog.abstractMethod;"); 
 }
public void testRemoveMultiplySetAbstract339() { 
     test("function Foo() {}; Foo.prototype.doSomething = " + "Foo.prototype.doSomethingElse = Foo.prototype.oneMore = " + "goog.abstractMethod;", "function Foo() {};"); 
 }
public void testStopRemovalAtNonQualifiedName340() { 
     test("function Foo() {}; function Bar() {};" + "Foo.prototype.x = document.getElementById('x').y = Bar.prototype.x" + " = goog.abstractMethod;", "function Foo() {}; function Bar() {};" + "Foo.prototype.x = document.getElementById('x').y = " + "goog.abstractMethod;"); 
 }
  

  

  

  

  

  

  

  

  

  

  @Override
  protected ClosureCodeRemoval getProcessor(Compiler compiler) {
    return new ClosureCodeRemoval(compiler, true, true);
  }
}
