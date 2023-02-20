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

import static com.google.javascript.jscomp.CheckGlobalNames.NAME_DEFINED_LATE_WARNING;
import static com.google.javascript.jscomp.CheckGlobalNames.UNDEFINED_NAME_WARNING;
import static com.google.javascript.jscomp.CheckGlobalNames.STRICT_MODULE_DEP_QNAME;

import com.google.javascript.rhino.Node;

/**
 * Tests for {@code CheckGlobalNames.java}.
 *
 * @author nicksantos@google.com (Nick Santos)
 */
public class CheckGlobalNamesTest extends CompilerTestCase {

  private boolean injectNamespace = false;

  public CheckGlobalNamesTest() {
    super("function alert() {}" +
          "/** @constructor */ function Object(){}" +
          "Object.prototype.hasOwnProperty = function() {};" +
          "/** @constructor */ function Function(){}" +
          "Function.prototype.call = function() {};");
  }

  @Override
  protected CompilerPass getProcessor(final Compiler compiler) {
    final CheckGlobalNames checkGlobalNames = new CheckGlobalNames(
        compiler, CheckLevel.WARNING);
    if (injectNamespace) {
      return new CompilerPass() {
        @Override
        public void process(Node externs, Node js) {
          checkGlobalNames.injectNamespace(
              new GlobalNamespace(compiler, externs, js))
              .process(externs, js);
        }
      };
    } else {
      return checkGlobalNames;
    }
  }

  @Override
  public void setUp() {
    injectNamespace = false;
    STRICT_MODULE_DEP_QNAME.level = CheckLevel.WARNING;
  }

  private static final String GET_NAMES =
      "var a = {get d() {return 1}}; a.b = 3; a.c = {get e() {return 5}};";
  private static final String SET_NAMES =
      "var a = {set d(x) {}}; a.b = 3; a.c = {set e(y) {}};";
  private static final String NAMES = "var a = {d: 1}; a.b = 3; a.c = {e: 5};";

public void testInterfaceFunctionPropRef84() { 
     testSame("/** @interface */ function F() {}" + "F.call(); F.hasOwnProperty('z');"); 
 }
public void testTypedef286() { 
     test("var foo = {};" + "/** @typedef {number} */ foo.Bar.Baz;" + "foo.Bar = function() {};", "var foo$Bar$Baz; var foo$Bar = function(){};"); 
 }
public void testBadModuleDep187() { 
     testSame(createModuleChain("var c = a.b;", NAMES), STRICT_MODULE_DEP_QNAME); 
 }
public void testRefToDescendantOfUndefinedProperty188() { 
     testSame(NAMES + "var c = a.x.b;", UNDEFINED_NAME_WARNING); 
 }
public void testNoWarningForSimpleVarModuleDep289() { 
     testSame(createModuleChain("var c = a;", NAMES)); 
 }
public void testLocalAliasOfAncestor609() { 
     testSame("var a = {b: {c: 5}}; function g() { f(a); } " + "function f() { var x = a.b; f(x.c); }"); 
 }
  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  
  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  
}
