/*
 * Copyright 2012 The Closure Compiler Authors.
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

import static com.google.javascript.jscomp.ClosureRewriteClass.GOOG_CLASS_CONSTRUCTOR_MISING;
import static com.google.javascript.jscomp.ClosureRewriteClass.GOOG_CLASS_DESCRIPTOR_NOT_VALID;
import static com.google.javascript.jscomp.ClosureRewriteClass.GOOG_CLASS_STATICS_NOT_VALID;
import static com.google.javascript.jscomp.ClosureRewriteClass.GOOG_CLASS_SUPER_CLASS_NOT_VALID;
import static com.google.javascript.jscomp.ClosureRewriteClass.GOOG_CLASS_TARGET_INVALID;
import static com.google.javascript.jscomp.ClosureRewriteClass.GOOG_CLASS_UNEXPECTED_PARAMS;


/**
 * Unit tests for ClosureRewriteGoogClass
 * @author johnlenz@google.com (John Lenz)
 */
public class ClosureRewriteClassTest extends CompilerTestCase {

  @Override
  protected CompilerPass getProcessor(Compiler compiler) {
    return new ClosureRewriteClass(compiler);
  }

  @Override
  protected void setUp() throws Exception {
    super.setUp();
    this.enableEcmaScript5(false);
  }

  @Override
  protected int getNumRepetitions() {
    return 1;
  }

public void testComplete2378() { 
     test("x.y = goog.defineClass(some.Super, {\n" + "  constructor: function(){\n" + "    this.foo = 1;\n" + "  },\n" + "  statics: {\n" + "    prop1: 1,\n" + "    /** @const */\n" + "    PROP2: 2\n" + "  },\n" + "  anotherProp: 1,\n" + "  aMethod: function() {}\n" + "});", "{\n" + "/** @constructor */\n" + "x.y=function(){this.foo=1};\n" + "goog.inherits(x.y,some.Super);" + "x.y.prop1=1;\n" + "/** @const */\n" + "x.y.PROP2=2;\n" + "x.y.prototype.anotherProp=1;" + "x.y.prototype.aMethod=function(){};" + "}"); 
 }
  

  

  

  

  

  

  

  

  

  

  

  

  
}
