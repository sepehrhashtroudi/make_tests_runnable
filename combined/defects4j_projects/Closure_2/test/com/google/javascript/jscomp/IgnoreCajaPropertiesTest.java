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
 * {@link IgnoreCajaProperties} tests.
 *
 */
public class IgnoreCajaPropertiesTest extends CompilerTestCase {

  private static final String EXTERNS =
      "var z = {}, " +
      "f = function(y) { z[y] = z[y] ? (z[y]+1) : 1; }, " +
      "x, i;";

  public IgnoreCajaPropertiesTest() {
    super(EXTERNS);
  }

  @Override
  public void setUp() {
    super.enableLineNumberCheck(false);
  }

  @Override
  public int getNumRepetitions() {
    return 1;
  }

public void testFourChildFor730() { 
     test("for (i = 0; i < 10; ++i) { f(i); }", "for (i = 0; i < 10; ++i) { f(i); }"); 
 }
public void testVarKey731() { 
     test("for (var j in x) { f(j); }", "for (var JSCompiler_IgnoreCajaProperties_0 in x) {" + "  if (!JSCompiler_IgnoreCajaProperties_0.match(/___$/)) {" + "    var j;" + "    j = JSCompiler_IgnoreCajaProperties_0;" + "    { f(j); }" + "  }" + "}"); 
     test("for (var j in x) { f(j); f(j); }", "for (var JSCompiler_IgnoreCajaProperties_0 in x) {" + "  if (!JSCompiler_IgnoreCajaProperties_0.match(/___$/)) {" + "    var j;" + "    j = JSCompiler_IgnoreCajaProperties_0;" + "    { f(j); f(j); }" + "  }" + "}"); 
     test("for (var i in x) for (var j in y) f(i,j);", "for (var JSCompiler_IgnoreCajaProperties_1 in x)" + "  if (!JSCompiler_IgnoreCajaProperties_1.match(/___$/)) {" + "    var i;" + "    i = JSCompiler_IgnoreCajaProperties_1;" + "    {" + "      for (var JSCompiler_IgnoreCajaProperties_0 in y)" + "        if (!JSCompiler_IgnoreCajaProperties_0.match(/___$/)) {" + "          var j;" + "          j = JSCompiler_IgnoreCajaProperties_0;" + "          { f(i,j); }" + "        }" + "    }" + "  }"); 
 }
public void testProcessCajaProperties732() { 
     test("for (var j in x) { f(j); }", "for (var JSCompiler_IgnoreCajaProperties_0 in x) {" + "  if (!JSCompiler_IgnoreCajaProperties_0.match(/___$/)) {" + "    var j;" + "    j = JSCompiler_IgnoreCajaProperties_0;" + "    { f(j); }" + "  }" + "}"); 
     test("for (var j in x) { f(j); f(j); }", "for (var JSCompiler_IgnoreCajaProperties_0 in x) {" + "  if (!JSCompiler_IgnoreCajaProperties_0.match(/___$/)) {" + "    var j;" + "    j = JSCompiler_IgnoreCajaProperties_0;" + "    { f(j); f(j); }" + "  }" + "}"); 
     test("for (var i in x) for (var j in y) f(i,j);", "for (var JSCompiler_IgnoreCajaProperties_1 in x)" + "  if (!JSCompiler_IgnoreCajaProperties_1.match(/___$/)) {" + "    var i;" + "    i = JSCompiler_IgnoreCajaProperties_1;" + "    {" + "      for (var JSCompiler_IgnoreCajaProperties_0 in y)" + "        if (!JSCompiler_IgnoreCajaProperties_0.match(/___$/)) {" + "          var j;" + "          j = JSCompiler_IgnoreCajaProperties_0;" + "          { f(i,j); }" + "        }" + "    }" + "  }"); 
 }
  

  

  

  

  

  @Override
  public CompilerPass getProcessor(Compiler compiler) {
    return new IgnoreCajaProperties(compiler);
  }
}
