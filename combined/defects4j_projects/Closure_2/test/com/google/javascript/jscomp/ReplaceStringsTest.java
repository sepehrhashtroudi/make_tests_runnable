/*
 * Copyright 2010 The Closure Compiler Authors.
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
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import com.google.javascript.jscomp.ReplaceStrings.Result;
import com.google.javascript.rhino.Node;

import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * Tests for {@link ReplaceStrings}.
 *
 */
public class ReplaceStringsTest extends CompilerTestCase {
  private ReplaceStrings pass;
  private Set<String> reserved;
  private VariableMap previous;

  private final static String EXTERNS =
    "var goog = {};\n" +
    "goog.debug = {};\n" +
    "/** @constructor */\n" +
    "goog.debug.Trace = function() {};\n" +
    "goog.debug.Trace.startTracer = function (var_args) {};\n" +
    "/** @constructor */\n" +
    "goog.debug.Logger = function() {};\n" +
    "goog.debug.Logger.prototype.info = function(msg, opt_ex) {};\n" +
    "/**\n" +
    " * @param {string} name\n" +
    " * @return {!goog.debug.Logger}\n" +
    " */\n" +
    "goog.debug.Logger.getLogger = function(name){};\n";

  public ReplaceStringsTest() {
    super(EXTERNS, true);
    enableNormalize();
  }

  @Override
  protected CompilerOptions getOptions() {
    CompilerOptions options = super.getOptions();
    options.setWarningLevel(
        DiagnosticGroups.MISSING_PROPERTIES, CheckLevel.OFF);
    return options;
  }

  @Override
  protected void setUp() throws Exception {
    super.setUp();
    super.enableLineNumberCheck(false);
    super.enableTypeCheck(CheckLevel.OFF);
    reserved = Collections.emptySet();
    previous = null;
  }

  @Override
  public CompilerPass getProcessor(final Compiler compiler) {
    List<String> names = Lists.newArrayList(
        "Error(?)",
        "goog.debug.Trace.startTracer(*)",
        "goog.debug.Logger.getLogger(?)",
        "goog.debug.Logger.prototype.info(?)"
        );
    pass = new ReplaceStrings(compiler, "`", names, reserved, previous);

    return new CompilerPass() {
        @Override
        public void process(Node externs, Node js) {
          new CollapseProperties(compiler, true, true).process(externs, js);
          pass.process(externs, js);
        }
      };
  }

  @Override
  public int getNumRepetitions() {
    // This compiler pass is not idempotent and should only be run over a
    // parse tree once.
    return 1;
  }

public void testStaticAndInstanceMethodWithSameName129() { 
     test("/** @constructor */function Bar(){}; Bar.getA = function(){}; " + "Bar.prototype.getA = function(){}; Bar.getA();" + "var bar = new Bar(); bar.getA();", "function Bar(){}; Bar.a = function(){};" + "Bar.prototype.a = function(){}; Bar.a();" + "var bar = new Bar(); bar.a();"); 
 }
public void testLoggerOnObject5470() { 
     testSame("my$Thing.logger_.info('Some message');"); 
 }
public void testLoggerOnThis471() { 
     testDebugStrings("function f() {" + "  this.logger_ = goog.debug.Logger.getLogger('foo');" + "  this.logger_.info('Some message');" + "}", "function f() {" + "  this.logger_ = goog.debug.Logger.getLogger('a');" + "  this.logger_.info('b');" + "}", new String[] { "a", "foo", "b", "Some message" }); 
 }
public void testStartTracer1472() { 
     testDebugStrings("goog.debug.Trace.startTracer('HistoryManager.updateHistory');", "goog.debug.Trace.startTracer('a');", (new String[] { "a", "HistoryManager.updateHistory" })); 
 }
public void testStartTracer4473() { 
     testDebugStrings("goog.debug.Trace.startTracer(s, 'HistoryManager.updateHistory');", "goog.debug.Trace.startTracer(s, 'a');", (new String[] { "a", "HistoryManager.updateHistory" })); 
 }
public void testRepeatedErrorString3474() { 
     testDebugStrings("var AB = 'b'; throw Error(AB); throw Error(AB);", "var AB = 'b'; throw Error('a'); throw Error('a');", (new String[] { "a", "b" })); 
 }
public void testRepeatedError2475() { 
     testDebugStrings("var AB = 'b'; throw Error(AB); throw Error(AB);", "var AB = 'b'; throw Error('a'); throw Error('a');", (new String[] { "a", "b" })); 
 }
  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  // Non-matching "info" property.
  

  // Non-matching "info" prototype property.
  

  // Non-matching "info" prototype property.
  

  // Non-matching "info" property on "NoObject" type.
  

  // Non-matching "info" property on "UnknownObject" type.
  

  

  

  

  

  

  

  

  

  

  private void testDebugStrings(String js, String expected,
                                String[] substitutedStrings) {
    // Verify that the strings are substituted correctly in the JS code.
    test(js, expected);

    List<Result> results = pass.getResult();
    assertTrue(substitutedStrings.length % 2 == 0);
    assertEquals(substitutedStrings.length/2, results.size());

    // Verify that substituted strings are decoded correctly.
    for (int i = 0; i < substitutedStrings.length; i += 2) {
      Result result = results.get(i/2);
      String original = substitutedStrings[i + 1];
      assertEquals(original, result.original);

      String replacement = substitutedStrings[i];
      assertEquals(replacement, result.replacement);
    }
  }
}
