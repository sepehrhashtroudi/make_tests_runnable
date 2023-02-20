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

import static com.google.javascript.jscomp.CheckRequiresForConstructors.MISSING_REQUIRE_WARNING;

import com.google.common.collect.ImmutableList;
import com.google.javascript.jscomp.CheckLevel;
import com.google.javascript.jscomp.Result;

/**
 * Tests for {@link CheckRequiresForConstructors}.
 *
 */
public class CheckRequiresForConstructorsTest extends CompilerTestCase {
  @Override
  protected CompilerPass getProcessor(Compiler compiler) {
    return new CheckRequiresForConstructors(compiler, CheckLevel.WARNING);
  }

public void testPassWithOneNewOuterClassWithUpperPrefix351() { 
     String js = "var goog = {};" + "goog.require('goog.foo.IDBar'); var bar = new goog.foo.IDBar.Baz();"; 
     testSame(js); 
 }
public void testFailWithLocalVariableInMoreThanOneFile352() { 
     String localVar = "/** @constructor */ function tempCtor() {}" + "function baz(){" + " /** @constructor */ function tempCtor() {}; " + "var foo = new tempCtor();}"; 
     String[] js = new String[] { localVar, " var foo = new tempCtor();" }; 
     String warning = "'tempCtor' used but not goog.require'd"; 
     test(js, js, null, MISSING_REQUIRE_WARNING, warning); 
 }
public void testDoNotConvert353() { 
     testSame("a[0]"); 
     testSame("a['']"); 
     testSame("a[' ']"); 
     testSame("a[',']"); 
     testSame("a[';']"); 
     testSame("a[':']"); 
     testSame("a['.']"); 
     testSame("a['0']"); 
     testSame("a['p ']"); 
     testSame("a['p' + '']"); 
     testSame("a[p]"); 
     testSame("a[P]"); 
     testSame("a[$]"); 
     testSame("a[p()]"); 
     testSame("a['default']"); 
     test("a['\u1d17A']", "a['\u1d17A']"); 
     test("a['\u00d1StuffAfter']", "a['\u00d1StuffAfter']"); 
 }
public void testNoWarningsForThisConstructor354() { 
     String js = "var goog = {};" + "/** @constructor */goog.Foo = function() {};" + "goog.Foo.bar = function() {" + "  return new this.constructor; " + "};"; 
     testSame(js); 
 }
public void testClassWithStaticInitFn355() { 
     test("x.y = goog.defineClass(some.Super, {\n" + "  constructor: function(){\n" + "    this.foo = 1;\n" + "  },\n" + "  statics: function(cls) {\n" + "    cls.prop1 = 1;\n" + "    /** @const */\n" + "    cls.PROP2 = 2;\n" + "  },\n" + "  anotherProp: 1,\n" + "  aMethod: function() {}\n" + "});", "x.y=function(){this.foo=1};" + "goog.inherits(x.y,some.Super);" + "x.y.prototype.anotherProp=1;" + "x.y.prototype.aMethod=function(){};" + "(function(cls) {" + "  cls.prop1=1;\n" + "  cls.PROP2=2;" + "})(x.y);\n" + "}"); 
 }
public void testPassWithLocalVariables356() { 
     String js = "/** @constructor */ var nodeCreator = function() {};" + "var newNode = new nodeCreator();"; 
     testSame(js); 
 }
  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  
}
