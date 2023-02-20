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

public void testExternedPropertyName13() { 
     test("/** @constructor */ var Bar = function(){};" + "/** @override */ Bar.prototype.toString = function(){};" + "Bar.prototype.func = function(){};" + "var bar = new Bar();" + "bar.toString();", "var Bar = function(){};" + "Bar.prototype.toString = function(){};" + "Bar.prototype.a = function(){};" + "var bar = new Bar();" + "bar.toString();"); 
 }
public void testSetQuotedPropertyOfThis14() { 
     testSame("this['prop'] = 'bar';"); 
 }
public void testUnion15() { 
     String js = "" + "/** @constructor */ var Foo = function(){};\n" + "/** @constructor */ var Bar = function(){};\n" + "Foo.prototype.foodoo=0;\n" + "Bar.prototype.bardoo=0;\n" + "/** @type {Foo|Bar} */\n" + "var U;\n" + "U.joint;" + "U.joint"; 
     String output = "" + "var Foo = function(){};\n" + "var Bar = function(){};\n" + "Foo.prototype.b=0;\n" + "Bar.prototype.b=0;\n" + "var U;\n" + "U.a;" + "U.a"; 
     test(js, output); 
 }
public void testOneVar216() { 
     testSame("/** @constructor */ var Foo = function(){};" + "Foo.prototype = {b: 0};"); 
 }
  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  
}
