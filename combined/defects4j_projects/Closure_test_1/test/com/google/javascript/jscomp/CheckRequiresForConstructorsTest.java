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

public void testPassWithLocalVariables403() { 
     String js = "/** @constructor */ var nodeCreator = function() {};" + "var newNode = new nodeCreator();"; 
     testSame(js); 
 }
public void testShouldWarnWhenInstantiatingGlobalClassesFromGlobalScope404() { 
     String good = "/** @constructor */ function Baz(){}; " + "Baz.prototype.bar = function(){return new Baz();};"; 
     String bad = "var baz = new Baz()"; 
     String[] js = new String[] { good, bad }; 
     String warning = "'Baz' used but not goog.require'd"; 
     test(js, js, null, MISSING_REQUIRE_WARNING, warning); 
 }
  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  
}