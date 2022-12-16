/*
 * Copyright 2005 The Closure Compiler Authors.
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

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMap;
import com.google.javascript.rhino.Node;

import java.util.*;


/**
 * Tests for {@link RenameVars}.
 */
public class RenameVarsTest extends CompilerTestCase {
  private static final String DEFAULT_PREFIX = "";
  private String prefix = DEFAULT_PREFIX;

  private VariableMap previouslyUsedMap =
      new VariableMap(ImmutableMap.<String, String>of());
  private RenameVars renameVars;
  private boolean withClosurePass = false;
  private boolean localRenamingOnly = false;
  private boolean preserveFunctionExpressionNames = false;
  private boolean useGoogleCodingConvention = true;
  private boolean generatePseudoNames = false;
  private boolean shouldShadow = false;

  @Override
  protected CodingConvention getCodingConvention() {
    if (useGoogleCodingConvention) {
      return new GoogleCodingConvention();
    } else {
      return CodingConventions.getDefault();
    }
  }

  @Override
  protected CompilerPass getProcessor(Compiler compiler) {
    if (withClosurePass) {
      return new ClosurePassAndRenameVars(compiler);
    } else {
      return renameVars = new RenameVars(compiler, prefix,
          localRenamingOnly, preserveFunctionExpressionNames,
          generatePseudoNames, shouldShadow,
          previouslyUsedMap, null, null);
    }
  }

  @Override
  protected int getNumRepetitions() {
    return 1;
  }

  @Override
  protected void setUp() throws Exception {
    super.setUp();
    previouslyUsedMap = new VariableMap(ImmutableMap.<String, String>of());
    prefix = DEFAULT_PREFIX;
    withClosurePass = false;
    localRenamingOnly = false;
    preserveFunctionExpressionNames = false;
    generatePseudoNames = false;
    shouldShadow = false;

    // TODO(johnlenz): Enable Normalize during these tests.
  }


public void testStableRenameWithPointlesslyAnonymousFunctions10() { 
     VariableMap expectedVariableMap = makeVariableMap("L 0", "a", "L 1", "b"); 
     testRenameMap("(function (v1, v2) {}); (function (v3, v4) {});", "(function (a, b) {}); (function (a, b) {});", expectedVariableMap); 
     expectedVariableMap = makeVariableMap("L 0", "a", "L 1", "b", "L 2", "c"); 
     testRenameMapUsingOldMap("(function (v0, v1, v2) {});" + "(function (v3, v4) {});", "(function (a, b, c) {});" + "(function (a, b) {});", expectedVariableMap); 
 }


public void testPseudoNames113() { 
     generatePseudoNames = false; 
     test("var foo = function(a, b, c){}", "var $foo$$ = function($a$$, $b$$, $c$$){}"); 
     generatePseudoNames = true; 
     test("var foo = function(a, b, c){}", "var $foo$$ = function($a$$, $b$$, $c$$){}"); 
     test("var a = function(a, b, c){}", "var $a$$ = function($a$$, $b$$, $c$$){}"); 
 }


public void testPseudoNamesUniqueStableRenameWithPointlesslyAnonymousFunctions114() { 
     VariableMap expectedVariableMap = makeVariableMap("L 0", "a", "L 1", "b"); 
     testRenameMap("(function (v1, v2) {}); (function (v3, v4) {});", "(function (a, b) {}); (function (a, b) {});", expectedVariableMap); 
     expectedVariableMap = makeVariableMap("L 0", "a", "L 1", "b", "L 2", "c"); 
     testRenameMapUsingOldMap("(function (v0, v1, v2) {});" + "(function (v3, v4) {});", "(function (a, b, c) {});" + "(function (a, b) {});", expectedVariableMap); 
 }


public void testThrowError1115() { 
     testDebugStrings("throw Error('xyz');", "throw Error('a');", (new String[] { "a", "xyz" })); 
     previous = VariableMap.fromMap(ImmutableMap.of("previous", "xyz")); 
     testDebugStrings("throw Error('xyz');", "throw Error('previous');", (new String[] { "previous", "xyz" })); 
 }


public void testSimpleStable116() { 
     inFunction("var x; var y; x=1; x; y=1; y; return y", "var x;        x=1; x; x=1; x; return x"); 
     inFunction("var x,y; x=1; x; y=1; y", "var x  ; x=1; x; x=1; x"); 
     inFunction("var x,y; x=1; y=2; y; x"); 
     inFunction("y=0; var x, y; y; x=0; x", "y=0; var y   ; y; y=0;y"); 
     inFunction("var x,y; x=1; y=x; y", "var x  ; x=1; x=x; x"); 
     inFunction("var x,y; x=1; y=x+1; y", "var x  ; x=1; x=x+1; x"); 
     inFunction("x=1; x; y=2; y; var x; var y", "x=1; x; x=2; x; var x"); 
     inFunction("var x=1; var y=x+1; return y", "var x=1;     x=x+1; return x"); 
     inFunction("var x=1; var y=0; x+=1; y"); 
     inFunction("var x=1; x+=1; var y=0; y", "var x=1; x+=1;     x=0; x"); 
     inFunction("var x=1; foo(bar(x+=1)); var y=0; y", "var x=1; foo(bar(x+=1));     x=0; x"); 
     inFunction("var y, x=1; f(x+=1, y)"); 
     inFunction("var x; var y; y += 1, y, x = 1; x"); 
 }

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  private VariableMap makeVariableMap(String... keyValPairs) {
    Preconditions.checkArgument(keyValPairs.length % 2 == 0);

    ImmutableMap.Builder<String, String> renameMap = ImmutableMap.builder();
    for (int i = 0; i < keyValPairs.length; i += 2) {
      renameMap.put(keyValPairs[i], keyValPairs[i + 1]);
    }

    return new VariableMap(renameMap.build());
  }

  private static void assertVariableMapsEqual(VariableMap a, VariableMap b) {
    Map<String, String> ma = a.getOriginalNameToNewNameMap();
    Map<String, String> mb = b.getOriginalNameToNewNameMap();
    assertEquals("VariableMaps not equal", ma, mb);
  }

  private class ClosurePassAndRenameVars implements CompilerPass {
    private final Compiler compiler;

    private ClosurePassAndRenameVars(Compiler compiler) {
      this.compiler = compiler;
    }

    @Override
    public void process(Node externs, Node root) {
      ProcessClosurePrimitives closurePass =
          new ProcessClosurePrimitives(
              compiler, null, CheckLevel.WARNING);
      closurePass.process(externs, root);
      renameVars = new RenameVars(compiler, prefix,
          false, false, false, false, previouslyUsedMap, null,
          closurePass.getExportedVariableNames());
      renameVars.process(externs, root);
    }
  }
}
