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

import com.google.common.collect.Sets;

import java.util.Set;

/**
 * Tests for {@link StripCode}.
 *
 */
public class StripCodeTest extends CompilerTestCase {

  private static final String EXTERNS = "";

  public StripCodeTest() {
    super(EXTERNS, true);
  }

  /**
   * Creates an instance for removing logging code.
   *
   * @param compiler The Compiler
   * @return A new {@link StripCode} instance
   */
  private static StripCode createLoggerInstance(Compiler compiler) {
    Set<String> stripTypes = Sets.newHashSet(
        "goog.debug.DebugWindow",
        "goog.debug.FancyWindow",
        "goog.debug.Formatter",
        "goog.debug.HtmlFormatter",
        "goog.debug.TextFormatter",
        "goog.debug.Logger",
        "goog.debug.LogManager",
        "goog.debug.LogRecord",
        "goog.net.BrowserChannel.LogSaver",
        "GA_GoogleDebugger");

    Set<String> stripNames = Sets.newHashSet(
        "logger",
        "logger_",
        "debugWindow",
        "debugWindow_",
        "logFormatter_",
        "logBuffer_");

    Set<String> stripNamePrefixes = Sets.newHashSet("trace");
    Set<String> stripTypePrefixes = Sets.newHashSet("e.f.Trace");

    return new StripCode(compiler, stripTypes, stripNames, stripTypePrefixes,
        stripNamePrefixes);
  }

  @Override public CompilerPass getProcessor(Compiler compiler) {
    return createLoggerInstance(compiler);
  }

public void testLoggerDefinedInPrototypeAndUsedInConstructor651() { 
     test("a.b.c = function(level) {" + "  if (!this.logger.isLoggable(level)) {" + "    this.logger.setLevel(level);" + "  }" + "  this.logger.log(level, 'hi');" + "};" + "a.b.c.prototype.logger = goog.debug.Logger.getLogger('a.b.c');" + "a.b.c.prototype.go = function() { this.logger.finer('x'); };", "a.b.c=function(level){if(!null);};" + "a.b.c.prototype.go=function(){}"); 
 }
public void testCrazyNesting4652() { 
     test("var x = function() {}; x(goog.debug.Logger.getLogger());", "var x = function() {}; x(null);"); 
 }
public void testTypePrefix653() { 
     test("e.f.TraceXXX = function() {}; " + "e.f.TraceXXX.prototype.yyy = 2;", ""); 
 }
public void testClassDefiningCallWithStripType8654() { 
     test("goog.debug.DebugWindow = function(){}", ""); 
     test("goog.inherits(goog.debug.DebugWindow,Base)", ""); 
     testSame("goog.debug.DebugWindowFoo=function(){}"); 
     testSame("goog.inherits(goog.debug.DebugWindowFoo,Base)"); 
     testSame("goog.debug.DebugWindowFoo"); 
     testSame("goog.debug.DebugWindowFoo=1"); 
     test("goog.debug.DebugWindow.Foo=function(){}", ""); 
     test("goog.inherits(goog.debug.DebugWindow.Foo,Base)", ""); 
     test("goog.debug.DebugWindow.Foo", ""); 
     test("goog.debug.DebugWindow.Foo=1", ""); 
 }
  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  
}
