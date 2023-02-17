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

import com.google.javascript.jscomp.CompilerOptions.LanguageMode;
import com.google.javascript.rhino.Node;

import java.util.Map;

/**
 * Unit test for AmbiguateProperties Compiler pass.
 *
 */
public class AmbiguatePropertiesTest extends CompilerTestCase {
  private AmbiguateProperties lastPass;

  private static final String EXTERNS =
      "Function.prototype.call=function(){};" +
      "Function.prototype.inherits=function(){};" +
      "prop.toString;" +
      "var google = { gears: { factory: {}, workerPool: {} } };";

  public AmbiguatePropertiesTest() {
    super(EXTERNS);
    enableNormalize();
    enableTypeCheck(CheckLevel.WARNING);
    enableClosurePass();
  }

  @Override
  public CompilerPass getProcessor(final Compiler compiler) {
    return new CompilerPass() {
      @Override
      public void process(Node externs, Node root) {
        lastPass = new AmbiguateProperties(compiler, new char[]{'$'});
        lastPass.process(externs, root);
      }
    };
  }

  @Override
  protected int getNumRepetitions() {
    return 1;
  }

  @Override
  protected CompilerOptions getOptions() {
    // no missing properties check
    CompilerOptions options = new CompilerOptions();
    options.setLanguageIn(LanguageMode.ECMASCRIPT5);
    return options;
  }

public void testExternedPropertyName18() { 
     test("/** @constructor */ var Bar = function(){};" + "/** @override */ Bar.prototype.toString = function(){};" + "Bar.prototype.func = function(){};" + "var bar = new Bar();" + "bar.toString();", "var Bar = function(){};" + "Bar.prototype.toString = function(){};" + "Bar.prototype.a = function(){};" + "var bar = new Bar();" + "bar.toString();"); 
 }
public void testImplementsAndExtends19() { 
     String js = "" + "/** @interface */ function Foo() {}\n" + "/**\n" + " * @constructor\n" + " */\n" + "function Bar(){}\n" + "Bar.prototype.y = function() { return 3; };\n" + "/**\n" + " * @constructor\n" + " * @extends {Bar}\n" + " * @implements {Foo}\n" + " */\n" + "function SubBar(){ }\n" + "/** @param {Foo} x */ function f(x) { x.z = 3; }\n" + "/** @param {SubBar} x */ function g(x) { x.z = 3; }"; 
     String output = "" + "function Foo(){}\n" + "function Bar(){}\n" + "Bar.prototype.b = function() { return 3; };\n" + "function SubBar(){}\n" + "function f(x) { x.a = 3; }\n" + "function g(x) { x.a = 3; }"; 
     test(js, output); 
 }
public void testTypeMismatch20() { 
     testSame(EXTERNS, "/** @constructor */var Foo = function(){};\n" + "/** @constructor */var Bar = function(){};\n" + "Foo.prototype.b = 0;\n" + "/** @type {Foo} */\n" + "var F = new Bar();", TypeValidator.TYPE_MISMATCH_WARNING, "initializing variable\n" + "found   : Bar\n" + "required: (Foo|null)"); 
 }
public void testRenamePropertiesFunctionCall221() { 
     test("var foo = {myProp: 0}; " + "f(JSCompiler_renameProperty('otherProp.myProp.someProp')); " + "foo.myProp = 1; foo.theirProp = 2; foo.yourProp = 3;", "var foo = {a: 0}; f('b.a.c'); " + "foo.a = 1; foo.d = 2; foo.e = 3;"); 
 }
public void testSetQuotedPropertyOfThis22() { 
     testSame("this['prop'] = 'bar';"); 
 }
public void testTwoVar223() { 
     String js = "" + "/** @constructor */ var Foo = function(){};\n" + "Foo.prototype={z:0, z:1, x:0};\n"; 
     testSame(js); 
 }
  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  
}
