/*
 * Copyright 2007 The Closure Compiler Authors.
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

import com.google.common.collect.ImmutableSet;

import java.util.*;

/**
 * Tests for {@link AliasStrings}.
 *
 */
public class AliasStringsTest extends CompilerTestCase {

  private static final String EXTERNS = "alert";
  private static final Set<String> ALL_STRINGS = null;

  private Set<String> strings = ALL_STRINGS;
  private JSModuleGraph moduleGraph = null;
  private boolean hashReduction = false;

  public AliasStringsTest() {
    super(EXTERNS);
  }

  @Override
  public void setUp() {
    super.enableLineNumberCheck(false);
  }

  @Override
  public CompilerPass getProcessor(Compiler compiler) {
    AliasStrings pass =
        new AliasStrings(compiler, moduleGraph, strings, "(?i)secret", false);
    if (hashReduction)
      pass.unitTestHashReductionMask = 0;
    return pass;
  }

public void testStringsThatAreGlobalVarValues561() { 
     strings = ALL_STRINGS; 
     testSame("var foo='foo'; var bar='';"); 
     testSame("var foo=['foo','bar'];"); 
     testSame("var foo=['foo',['bar']];"); 
     test("var foo=['foo', 'bar'];function bar() {return 'foo';}", "var $$S_foo='foo';" + "var foo=[$$S_foo, 'bar'];function bar() {return $$S_foo;}"); 
     testSame("var foo={'foo': 'bar'};"); 
     testSame("var foo={'foo': {'bar': 'baz'}};"); 
     test("var foo={'foo': 'bar'};function bar() {return 'foo';}", "var $$S_foo='foo';var foo={'foo': 'bar'};" + "function bar() {return $$S_foo;}"); 
     test("var foo={'foo': 'foo'};function bar() {return 'foo';}", "var $$S_foo='foo';" + "var foo={'foo': $$S_foo};function bar() {return $$S_foo;}"); 
 }
  

  

  

  

  

  

  

  

  

  


  

  

  


  
}
