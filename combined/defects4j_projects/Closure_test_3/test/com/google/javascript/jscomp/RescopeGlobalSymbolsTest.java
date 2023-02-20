/*
 * Copyright 2011 The Closure Compiler Authors.
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
 * Unit tests for {@link RescopeGlobalSymbols}
 *
 */
public class RescopeGlobalSymbolsTest extends CompilerTestCase {

  private final String namespace = "_";

  public RescopeGlobalSymbolsTest() {
  }

  @Override protected CompilerPass getProcessor(Compiler compiler) {
    return new RescopeGlobalSymbols(compiler, namespace, false);
  }

  @Override
  protected int getNumRepetitions() {
    return 1;
  }

public void testExterns351() { 
     test("var document;", "document", "window.document", null, null); 
     test("var document;", "document.getElementsByTagName('test')", "window.document.getElementsByTagName('test')", null, null); 
     test("var document;", "window.document.getElementsByTagName('test')", "window.document.getElementsByTagName('test')", null, null); 
     test("var document;document.getElementsByTagName", "document.getElementsByTagName('test')", "window.document.getElementsByTagName('test')", null, null); 
     test("var document,navigator", "document.navigator;navigator", "window.document.navigator;window.navigator", null, null); 
     test("var iframes", "function test() { iframes.resize(); }", "_.test = function() { window.iframes.resize(); }", null, null); 
     test("var iframes", "var foo = iframes;", "_.foo = window.iframes;", null, null); 
     test("var arguments, window, eval;", "arguments;window;eval;", "arguments;window;eval;", null, null); 
     test("", "document", "window.document", null, null); 
 }
public void testVarDeclarations352() { 
     test("var a = 1;", "_.a = 1;"); 
     test("var a = 1, b = 2, c = 3;", "_.a = 1; _.b = 2; _.c = 3;"); 
     test("var a = 'str', b = 1, c = { foo: 'bar' }, d = function() {};", "_.a = 'str'; _.b = 1; _.c = { foo: 'bar' }; _.d = function() {};"); 
     test("if(1){var x = 1;}", "if(1){_.x = 1;}"); 
     test("var x;", ""); 
     test("var a, b = 1;", "_.b = 1"); 
 }
public void testForLoops353() { 
     test("for (var i = 0; i < 1000; i++);", "for (_.i = 0; _.i < 1000; _.i++);"); 
     test("for (var i = 0, c = 2; i < 1000; i++);", "for (_.i = 0, _.c = 2; _.i < 1000; _.i++);"); 
     test("for (var i = 0, c = 2, d = 3; i < 1000; i++);", "for (_.i = 0, _.c = 2, _.d = 3; _.i < 1000; _.i++);"); 
     test("for (var i = 0, c = 2, d = 3, e = 4; i < 1000; i++);", "for (_.i = 0, _.c = 2, _.d = 3, _.e = 4; _.i < 1000; _.i++);"); 
     test("for (var i = 0; i < 1000;)i++;", "for (_.i = 0; _.i < 1000;)_.i++;"); 
     test("for (var i = 0,b; i < 1000;)i++;b++", "for (_.i = 0,_.b; _.i < 1000;)_.i++;_.b++"); 
     test("var o={};for (var i in o)i++;", "_.o={};for (_.i in _.o)_.i++;"); 
 }
  

  

  

  

  

  

  

  private class StringCompare extends CompilerTestCase {

    StringCompare() {
      super("", false);
    }

    @Override protected CompilerPass getProcessor(Compiler compiler) {
      return new RescopeGlobalSymbols(compiler, namespace, false);
    }

    
  }
}
