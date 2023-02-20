/*
 * Copyright 2006 The Closure Compiler Authors.
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
 * Tests for {@link RemoveUnusedPrototypeProperties}.
 *
 * @author nicksantos@google.com (Nick Santos)
 */
public class RemoveUnusedPrototypePropertiesTest extends CompilerTestCase {
  private static final String EXTERNS =
      "IFoo.prototype.bar; var mExtern; mExtern.bExtern; mExtern['cExtern'];";

  private boolean canRemoveExterns = false;
  private boolean anchorUnusedVars = false;

  public RemoveUnusedPrototypePropertiesTest() {
    super(EXTERNS);
  }

  @Override
  protected CompilerPass getProcessor(Compiler compiler) {
    return new RemoveUnusedPrototypeProperties(compiler,
        canRemoveExterns, anchorUnusedVars);
  }

  @Override
  public void setUp() {
    anchorUnusedVars = false;
    canRemoveExterns = false;
  }

public void testAliasing7828() { 
     testSame("function e(){}" + "e.prototype['alias1'] = e.prototype.method1 = " + "function(){this.method2()};" + "e.prototype.method2 = function(){};"); 
 }
public void testExportedMethodsByNamingConvention829() { 
     String classAndItsMethodAliasedAsExtern = "function Foo() {}" + "Foo.prototype.method = function() {};" + "Foo.prototype.unused = function() {};" + "Foo.prototype.method2 = function() {};"; 
     String compiled = "function Foo(){}" + "Foo.prototype.method = function(){};" + "Foo.prototype.method2 = function(){};"; 
     test(classAndItsMethodAliasedAsExtern, compiled); 
 }
public void testExportedMethodsByNamingConvention831() { 
     String classAndItsMethodAliasedAsExtern = "function Foo() {}" + "Foo.prototype.method = function() {};" + "Foo.prototype.unused = function() {};" + "var _externInstance = new Foo();" + "Foo.prototype._externMethod = Foo.prototype.method"; 
     String compiled = "function Foo(){}" + "Foo.prototype.method = function(){};" + "var _externInstance = new Foo;" + "Foo.prototype._externMethod = Foo.prototype.method"; 
     test(classAndItsMethodAliasedAsExtern, compiled); 
 }
public void testGetter1835() { 
     test("function Foo() {}" + "Foo.prototype = { " + "  get methodA() {}," + "  get methodB() { x(); }" + "};" + "function x() { (new Foo).methodA; }", "function Foo() {}" + "Foo.prototype = { " + "  get methodA() {}" + "};" + "function x() { (new Foo).methodA; }"); 
 }
public void testCantMovePrototypeProp836() { 
     testSame(createModuleChain("function Foo() {}" + "Foo.prototype.baz = goog.nullFunction;", "(new Foo).baz()")); 
 }
  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

}
