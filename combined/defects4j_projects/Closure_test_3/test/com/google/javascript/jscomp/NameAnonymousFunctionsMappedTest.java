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

import com.google.common.collect.ImmutableMap;

/**
 * Test cases for {@link NameAnonymousFunctionsMapped}.
 *
 */
public class NameAnonymousFunctionsMappedTest extends CompilerTestCase {
  private static final String EXTERNS = "var document;";

  private NameAnonymousFunctionsMapped pass;
  private VariableMap previous;

  public NameAnonymousFunctionsMappedTest() {
    super(EXTERNS);
  }

  @Override
  protected int getNumRepetitions() {
    return 1;
  }

  @Override
  protected void setUp() throws Exception {
    super.setUp();
    previous = null;
  }

  @Override
  public CompilerPass getProcessor(Compiler compiler) {
    return pass = new NameAnonymousFunctionsMapped(compiler, previous);
  }

  private void assertMapping(String... pairs) {
    VariableMap functionMap = pass.getFunctionMap();
    assertTrue(pairs.length % 2 == 0);
    for (int i = 0; i < pairs.length; i += 2) {
      String s = functionMap.lookupSourceName(pairs[i]);
      assertEquals(pairs[i + 1], s);
    }
    assertEquals(pairs.length / 2,
        functionMap.getNewNameToOriginalNameMap().size());
  }

public void testSimpleVarAssignment3401() { 
     previous = VariableMap.fromMap(ImmutableMap.<String, String>of("unused", "$")); 
     test("var fn = function() { return 1; }", "var fn = function $a() { return 1; }"); 
     assertMapping("$a", "fn"); 
 }
public void testMultiplePrototypeInitializer402() { 
     test("function a(){} a.prototype = {b: function() { return 1; }, " + "c: function() { return 2; }};", "function a(){} " + "a.prototype = {b: function $a$$b$() { return 1; }," + "c: function $a$$c$() { return 2; }};"); 
     assertMapping("$a$$", "a.prototype.b"); 
 }
public void testPrototypeInitializer403() { 
     test("function a(){} a.prototype = {b: function() { return 1; }};", "function a(){} " + "a.prototype = {b: function $() { return 1; }};"); 
     assertMapping("$", "a.prototype.b"); 
 }
public void testSimpleVarAssignment1404() { 
     test("var a = function() { return 1; }", "var a = function $() { return 1; }"); 
     assertMapping("$", "a"); 
 }
public void testMultiplePrototypeInitializer405() { 
     test("function a(){} a.prototype = {b: function() { return 1; }, " + "c: function() { return 2; }};", "function a(){} " + "a.prototype = {b: function $() { return 1; }," + "c: function $() { return 2; }};"); 
     assertMapping("$", "a.prototype.b"); 
 }
  

  

  

  

  

  

  

  

  


  

  

  

  

  

  
}
