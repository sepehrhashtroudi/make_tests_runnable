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
 * Unit test for {@link NameAnonymousFunctionsTest}.
 *
 */
public class NameAnonymousFunctionsTest extends CompilerTestCase {

  private static final String EXTERNS = "var document;";

  public NameAnonymousFunctionsTest() {
    super(EXTERNS);
  }

  @Override public CompilerPass getProcessor(Compiler compiler) {
    return new NameAnonymousFunctions(compiler);
  }

public void testAssignmentToPropertyOfArrayElement341() { 
     test("var a = {}; a.b = [{}]; a.b[0].c = function() {};", "var a = {}; a.b = [{}]; a.b[0].c = function $a$b$0$c$() {};"); 
     test("var a = {b: {'c': {}}}; a.b['c'].d = function() {};", "var a = {b: {'c': {}}}; a.b['c'].d = function $a$b$c$d$() {};"); 
     test("var a = {b: {'c': {}}}; a.b[x()].d = function() {};", "var a = {b: {'c': {}}}; a.b[x()].d = function $a$b$x$d$() {};"); 
 }
public void testRecursiveObjectLiteral784() { 
     test("function a(){} a.prototype = {b: {c: function() { return 1; }}}", "function a(){}a.prototype={b:{c:function $a$$b$c$(){return 1}}}"); 
 }
  

  

  

  

  

  

  

  

  

  

  

  

  

  
}
