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

import static com.google.javascript.jscomp.ReplaceCssNames.UNEXPECTED_STRING_LITERAL_ERROR;
import static com.google.javascript.jscomp.ReplaceCssNames.UNKNOWN_SYMBOL_WARNING;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Maps;
import com.google.javascript.rhino.Node;

import java.util.Map;
import java.util.Set;


/**
 * Tests for ReplaceCssNames.java.
 *
 */
public class ReplaceCssNamesTest extends CompilerTestCase {
  /** Whether to pass the map of replacements as opposed to null */
  boolean useReplacementMap;

  /** Map of replacements to use during the test. */
  Map<String, String> replacementMap =
      new ImmutableMap.Builder<String, String>()
      .put("active", "a")
      .put("buttonbar", "b")
      .put("colorswatch", "c")
      .put("disabled", "d")
      .put("elephant", "e")
      .put("footer", "f")
      .put("goog", "g")
    .build();

  Map<String, String> replacementMapFull =
      new ImmutableMap.Builder<String, String>()
      .put("long-prefix", "h")
      .put("suffix1", "i")
      .put("unrelated-word", "k")
      .put("unrelated", "l")
      .put("long-suffix", "m")
      .put("long-prefix-suffix1", "h-i")
      .build();

  CssRenamingMap renamingMap;
  Set<String> whitelist;

  Map<String, Integer> cssNames;

  public ReplaceCssNamesTest() {
  }

  @Override protected CompilerPass getProcessor(Compiler compiler) {
    return new ReplaceCssNames(compiler, cssNames, whitelist) {
      @Override
      protected CssRenamingMap getCssRenamingMap() {
        return useReplacementMap ? renamingMap : null;
      }
    };
  }

  protected CssRenamingMap getPartialMap() {
    CssRenamingMap map = new CssRenamingMap.ByPart() {
      @Override public String get(String value) {
        return replacementMap.get(value);
      }
    };
    return map;
  }

  protected CssRenamingMap getFullMap() {
    return new CssRenamingMap.ByWhole() {
      @Override public String get(String value) {
        return replacementMapFull.get(value);
      }
    };
  }

  @Override
  protected void setUp() throws Exception {
    super.setUp();
    super.enableLineNumberCheck(true);
    cssNames = Maps.newHashMap();
    useReplacementMap = true;
    renamingMap = getPartialMap();
  }

  @Override
  protected int getNumRepetitions() {
    // The first pass strips the goog.getCssName even if a warning is issued,
    // such that a subsequent pass won't issue a warning.
    return 1;
  }

public void testNoSymbolMapStripsCallAndDoesntIssueWarnings739() { 
     String input = "[goog.getCssName('test'), goog.getCssName(base, 'active')]"; 
     Compiler compiler = new Compiler(); 
     ErrorManager errorMan = new BasicErrorManager() { 
  
         @Override 
         protected void printSummary() { 
         } 
  
         @Override 
         public void println(CheckLevel level, JSError error) { 
         } 
     }; 
     compiler.setErrorManager(errorMan); 
     Node root = compiler.parseTestCode(input); 
     useReplacementMap = false; 
     ReplaceCssNames replacer = new ReplaceCssNames(compiler, null, null); 
     replacer.process(null, root); 
     assertEquals("[\"test\",base+\"-active\"]", compiler.toSource(root)); 
     assertEquals("There should be no errors", 0, errorMan.getErrorCount()); 
     assertEquals("There should be no warnings", 0, errorMan.getWarningCount()); 
 }
public void testTwoArgsWithStringLiterals740() { 
     test("var x = goog.getCssName('header', 'active')", null, UNEXPECTED_STRING_LITERAL_ERROR); 
     test("el.className = goog.getCssName('footer', window)", null, ReplaceCssNames.STRING_LITERAL_EXPECTED_ERROR); 
     test("setClass(goog.getCssName('buttonbar', 'disabled'))", null, UNEXPECTED_STRING_LITERAL_ERROR); 
     test("setClass(goog.getCssName(goog.getCssName('buttonbar'), 'active'))", null, UNEXPECTED_STRING_LITERAL_ERROR); 
 }
public void testTwoArgsWithVariableFirstArgFull741() { 
     renamingMap = getFullMap(); 
     test("var x = goog.getCssName(baseClass, 'long-suffix')", "var x = baseClass + '-m'"); 
 }
public void testOneArgWithCompositeClassNamesWithUnknownParts742() { 
     test("var x = goog.getCssName('goog-header-active')", "var x = 'goog-header-active'", null, UNKNOWN_SYMBOL_WARNING); 
     test("el.className = goog.getCssName('goog-colorswatch-focussed')", "el.className = 'goog-colorswatch-focussed'", null, UNKNOWN_SYMBOL_WARNING); 
     test("setClass(goog.getCssName('inactive-buttonbar'))", "setClass('inactive-buttonbar')", null, UNKNOWN_SYMBOL_WARNING); 
 }
  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

}
