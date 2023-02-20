/*
 * Copyright 2007 The Closure Compiler Authors.
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

public class InlineSimpleMethodsTest extends CompilerTestCase {

  public InlineSimpleMethodsTest() {
    super("", false);
  }

  @Override
  protected void setUp() throws Exception {
    super.setUp();
    super.enableLineNumberCheck(true);
  }

  @Override
  protected CompilerPass getProcessor(Compiler compiler) {
    return new InlineSimpleMethods(compiler);
  }

  /**
   * Helper for tests that expects definitions to remain unchanged, such
   * that {@code definitions+js} is converted to {@code definitions+expected}.
   */
  private void testWithPrefix(String definitions, String js, String expected) {
    test(definitions + js, definitions + expected);
  }

public void testNoInlineOfDangerousProperty308() { 
     testSame("function Foo(){this.bar=3}" + "Foo.prototype.bar=function(){};" + "var x=new Foo;var y=x.bar()"); 
 }
public void testConstantInline309() { 
     testWithPrefix("function Foo(){}" + "Foo.prototype.bar=function(){return 3};", "var f=new Foo;var x=f.bar()", "var f=new Foo;var x=3"); 
 }
public void testNestedProperties310() { 
     testWithPrefix("function Foo(){}" + "Foo.prototype.bar=function(){return this.baz.ooka};", "(new Foo).bar()", "(new Foo).baz.ooka"); 
 }
public void testIssue2508576_2311() { 
     testSame("({a:function(){},b:x()}).a(\"a\")"); 
 }
public void testObjectLitExtern425() { 
     String externs = "window.bridge={_sip:function(){}};"; 
     testSame(externs, "window.bridge._sip()", null); 
 }
public void testNoWarn426() { 
     testSame("function Foo(){}" + "Foo.prototype.bar=function(opt_a,b){var x=1};" + "var x=new Foo;x.bar()"); 
     testSame("function Foo(){}" + "Foo.prototype.bar=function(var_args,b){var x=1};" + "var x=new Foo;x.bar()"); 
 }
  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  // Don't warn about argument naming conventions (this is done in another pass)
  //   opt_ parameters must not be followed by non-optional parameters.
  //   var_args must be last
  

  

  

  

  

  

  

  

  

  
}
