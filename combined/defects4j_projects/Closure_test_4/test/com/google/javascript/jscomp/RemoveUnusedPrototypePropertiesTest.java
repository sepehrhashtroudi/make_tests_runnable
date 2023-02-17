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

public void testDontSpecializeAliasedFunctions_remove_unused_properties506() { 
     JSModule[] modules = createModuleStar("var Foo = function(){};" + "Foo.prototype.a = function() {this.a()};" + "Foo.prototype.b = function() {return 6};" + "var aliasB = Foo.prototype.b;" + "Foo.prototype.c = function() {return 7};" + "Foo.prototype.d = function() {return 7};" + "var aliasA = Foo.prototype.a;" + "var x = new Foo();" + "x.a();" + "var aliasC = (new Foo).c", ""); 
     test(modules, new String[] { "var Foo = function(){};" + "Foo.prototype.a = function() {this.a()};" + "Foo.prototype.b = function() {return 6};" + "var aliasB = Foo.prototype.b;" + "Foo.prototype.c = function() {return 7};" + "var aliasA = Foo.prototype.a;" + "var x = new Foo();" + "x.a();" + "var aliasC = (new Foo).c", "Foo.prototype.d = function() {return 7};" }); 
 }
public void testAnalyzePrototypeProperties541() { 
     test("function e(){}" + "e.prototype.a = function(){};" + "e.prototype.b = function(){};" + "var x = new e; x.a()", "function e(){}" + "e.prototype.a = function(){};" + "var x = new e; x.a()"); 
     test("function e(){}" + "e.prototype = {a: function(){}, b: function(){}};" + "var x=new e; x.a()", "function e(){}" + "e.prototype = {a: function(){}};" + "var x = new e; x.a()"); 
     test("function e(){}" + "e.prototype.a = function(){};" + "e.prototype.bExtern = function(){};" + "var x = new e;x.a()", "function e(){}" + "e.prototype.a = function(){};" + "e.prototype.bExtern = function(){};" + "var x = new e; x.a()"); 
     test("function e(){}" + "e.prototype = {a: function(){}, bExtern: function(){}};" + "var x = new e; x.a()", "function e(){}" + "e.prototype = {a: function(){}, bExtern: function(){}};" + "var x = new e; x.a()"); 
 }
  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

}
