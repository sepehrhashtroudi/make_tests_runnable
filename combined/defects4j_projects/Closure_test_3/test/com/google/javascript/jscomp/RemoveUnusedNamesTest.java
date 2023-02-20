/*
 * Copyright 2009 The Closure Compiler Authors.
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

import com.google.javascript.jscomp.CheckLevel;
import com.google.javascript.jscomp.type.SemanticReverseAbstractInterpreter;
import com.google.javascript.rhino.Node;

/**
 * Tests for {@link RemoveUnusedPrototypeProperties}.
 *
 * @author nicksantos@google.com (Nick Santos)
 */
public class RemoveUnusedNamesTest extends CompilerTestCase {
  private static final String EXTERNS =
      "/** @constructor */\n " +
      "function IFoo() { } \n" +
      "IFoo.prototype.bar; \n" +

      "/** @constructor */\n " +
      "var mExtern; \n" +
      "mExtern.bExtern; \n" +
      "mExtern['cExtern']; \n";

  public RemoveUnusedNamesTest() {
    super(EXTERNS);
  }

  private boolean canRemoveExterns = false;

  @Override
  protected int getNumRepetitions() {
    return 1;
  }

  @Override
  protected CompilerPass getProcessor(final Compiler compiler) {
    return new CompilerPass() {

      @Override
      public void process(Node externs, Node root) {
        new TypeCheck(compiler,
            new SemanticReverseAbstractInterpreter(
                compiler.getCodingConvention(),
                compiler.getTypeRegistry()),
            compiler.getTypeRegistry(),
            CheckLevel.ERROR,
            CheckLevel.ERROR).processForTesting(externs, root);

        new RemoveUnusedNames(
            compiler, canRemoveExterns).process(externs, root);

        // Use to remove side-effect-free artifacts that are left over.
        new UnreachableCodeElimination(compiler, true).process(externs, root);
      }
    };
  }

  @Override
  public void setUp() {
    canRemoveExterns = false;
  }

public void testAnalyzeUnusedPrototypeProperties277() { 
     test("/** @constructor */ \n" + "function e(){} \n" + "e.prototype.a = function(){};" + "e.prototype.b = function(){};" + "var x = new e; x.a()", "function e(){}" + " e.prototype.a = function(){};" + "var x = new e; x.a()"); 
 }
public void testNamespacedClass1278() { 
     test("var foo = {};foo.bar = {};foo.bar.prototype.baz = {}", ""); 
 }
public void testUnusedPropAssign1b279() { 
     test("var x = {}; x.foo = alert();", "alert()"); 
 }
public void testRefChain16280() { 
     testSame("function f(){}var a = 1; var b = a; var c = f(); c[b] ? g() : 0"); 
 }
public void testAssignWithHook8281() { 
     test("function Foo(){} var foo = null;" + "var f = window.a ? new Foo() : foo;", "function Foo(){}" + "window.a && new Foo()"); 
 }
public void testDoNotEnterSubscope778() { 
     testSame("var x = function() {" + "  var self = this; " + "  return function() { var y = self; };" + "}"); 
     testSame("var x = function() {" + "  var y = [1]; " + "  return function() { var z = y; };" + "}"); 
 }
  

  

  

  

  

  

  
}
