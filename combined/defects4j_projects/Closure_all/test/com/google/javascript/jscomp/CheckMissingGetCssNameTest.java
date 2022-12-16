/*
 * Copyright 2009 The Closure Compiler Authors.
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
 * @author mkretzschmar@google.com (Martin Kretzschmar)
 */
public class CheckMissingGetCssNameTest extends CompilerTestCase {
  @Override
  protected CompilerPass getProcessor(final Compiler compiler) {
    return new CombinedCompilerPass(
        compiler,
        new CheckMissingGetCssName(compiler, CheckLevel.ERROR, "goog-[a-z-]*"));
  }


public void testBug259265915() { 
     CompilerOptions options = createCompilerOptions(); 
     options.setLanguageIn(LanguageMode.ECMASCRIPT5_STRICT); 
     WarningLevel.VERBOSE.setOptionsForWarningLevel(options); 
     options.setLanguageIn(LanguageMode.ECMASCRIPT5); 
     String code = "'use strict';\n" + "function App() {}\n" + "App.prototype = {\n" + "  get appData() { return this.appData_; },\n" + "  set appData(data) { this.appData_ = data; }\n" + "};"; 
     Compiler compiler = compile(options, code); 
     testSame(options, code); 
 }


public void testBug2592659133() { 
     CompilerOptions options = createCompilerOptions(); 
     options.checkTypes = true; 
     options.closurePass = true; 
     test(options, CLOSURE_BOILERPLATE + "goog.provide('FOO.BAR'); FOO.BAR = 3;", CLOSURE_COMPILED + "var FOO$BAR = 3;"); 
 }


public void testBug2592659134() { 
     CompilerOptions options = createCompilerOptions(); 
     options.closurePass = true; 
     options.checkTypes = true; 
     test(options, CLOSURE_BOILERPLATE + "goog.provide('FOO.BAR'); FOO.BAR = 3;", CLOSURE_COMPILED + "var FOO$BAR = 3;"); 
 }

  

  

  

  

  

  

  

  
}
