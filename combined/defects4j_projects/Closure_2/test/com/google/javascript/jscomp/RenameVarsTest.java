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

public void testStableRenameWithExterns1417() { 
     String externs = "var foo;"; 
     test(externs, "var bar; foo(bar);", "var a; foo(a);", null, null); 
     previouslyUsedMap = renameVars.getVariableMap(); 
     test(externs, "var bar, baz; foo(bar, baz);", "var a, b; foo(a, b);", null, null); 
 }
public void testRecursiveFunctions1418() { 
     test("var walk = function walk(node, aFunction) {" + "  walk(node, aFunction);" + "};", "var a = function a(b, c) {" + "  a(b, c);" + "};"); 
     localRenamingOnly = true; 
     test("var walk = function walk(node, aFunction) {" + "  walk(node, aFunction);" + "};", "var walk = function walk(a, b) {" + "  walk(a, b);" + "};"); 
 }
public void testStableRenameWithPointlesslyAnonymousFunctions419() { 
     VariableMap expectedVariableMap = makeVariableMap("L 0", "a", "L 1", "b"); 
     testRenameMap("(function (v1, v2) {}); (function (v3, v4) {});", "(function (a, b) {}); (function (a, b) {});", expectedVariableMap); 
     expectedVariableMap = makeVariableMap("L 0", "a", "L 1", "b", "L 2", "c"); 
     testRenameMapUsingOldMap("(function (v0, v1, v2) {});" + "(function (v3, v4) {});", "(function (a, b, c) {});" + "(function (a, b) {});", expectedVariableMap); 
 }
public void testBleedingRecursiveFunctions2420() { 
     test("function f() {" + "  var x = function a(x) { return x ? 1 : a(1); };" + "  var y = function b(x) { return x ? 2 : b(2); };" + "}", "function d() {" + "  var e = function b(a) { return a ? 1 : b(1); };" + "  var f = function a(c) { return c ? 2 : a(2); };" + "}"); 
 }
  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  private void testRenameMapUsingOldMap(String input, String expected,
                                        VariableMap expectedMap) {
    previouslyUsedMap = renameVars.getVariableMap();
    testRenameMap("", input, expected,  expectedMap);
  }

  private void testRenameMapUsingOldMap(String externs, String input,
                                        String expected,
                                        VariableMap expectedMap) {
    previouslyUsedMap = renameVars.getVariableMap();
    testRenameMap(externs, input, expected,  expectedMap);
  }

  private void testRenameMap(String input, String expected,
                             VariableMap expectedRenameMap) {
    testRenameMap("", input, expected, expectedRenameMap);
  }

  private void testRenameMap(String externs, String input, String expected,
                             VariableMap expectedRenameMap) {
    test(externs, input, expected, null, null);
    VariableMap renameMap = renameVars.getVariableMap();
    assertVariableMapsEqual(expectedRenameMap, renameMap);
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
