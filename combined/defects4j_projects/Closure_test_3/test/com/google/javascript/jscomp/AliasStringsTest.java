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

public void testObjectLiterals572() { 
     strings = ImmutableSet.of("px", "!@#$%^&*()"); 
     test("var foo={px:435}", "var foo={px:435}"); 
     test("var foo={'px':435}", "var foo={'px':435}"); 
     test("bar=function f(){return {'px':435}}", "bar=function f(){return {'px':435}}"); 
     test("function f() {var foo={bar:'!@#$%^&*()'}}", "var $$S_$21$40$23$24$25$5e$26$2a$28$29='!@#$%^&*()';" + "function f() {var foo={bar:$$S_$21$40$23$24$25$5e$26$2a$28$29}}"); 
     test("function f() {var foo={px:435,foo:'px',bar:'baz'}}", "var $$S_px='px';" + "function f() {var foo={px:435,foo:$$S_px,bar:'baz'}}"); 
 }
public void testEmptyModules573() { 
     JSModule[] modules = createModuleStar("", "function foo() { f('good') }", "function foo() { f('good') }"); 
     moduleGraph = new JSModuleGraph(modules); 
     test(modules, new String[] { "var $$S_good='good'", "function foo() {f($$S_good)}", "function foo() {f($$S_good)}" }); 
     moduleGraph = null; 
 }
public void testBlackList574() { 
     test("(function (){var f=\'sec ret\';g=\"TOPseCreT\"})", "var $$S_sec$20ret='sec ret';" + "(function (){var f=$$S_sec$20ret;g=\"TOPseCreT\"})"); 
 }
public void testGetProp575() { 
     strings = ImmutableSet.of("px", "width"); 
     testSame("function f(){element.style.px=1234}"); 
     test("function f(){shape.width.units='px'}", "var $$S_px='px';function f(){shape.width.units='px'}"); 
     test("function f(){shape['width'].units='pt'}", "var $$S_width='width';" + "function f(){shape[$$S_width].units='pt'}"); 
 }
public void testProp576() { 
     strings = ImmutableSet.of("px", "!@#$%^&*()"); 
     test("var foo={px:435}", "var foo={px:435}"); 
     test("var foo={'px':435}", "var foo={'px':435}"); 
     test("bar=function f(){return {'px':435}}", "bar=function f(){return {'px':435}}"); 
     test("function f() {var foo={bar:'!@#$%^&*()'}}", "var $$S_$21$40$23$24$25$5e$26$2a$28$29='!@#$%^&*()';" + "function f() {var foo={bar:$$S_$21$40$23$24$25$5e$26$2a$28$29}}"); 
     test("function f() {var foo={px:435,foo:'px',bar:'baz'}}", "var $$S_px='px';" + "function f() {var foo={px:435,foo:$$S_px,bar:'baz'}}"); 
 }
public void testLongStableAliasHashCollision577() { 
     strings = ALL_STRINGS; 
     hashReduction = true; 
     test("f('Antidisestablishmentarianism');" + "f('Antidisestablishmentarianism');" + "f('Antidisestablishmentarianismo');" + "f('Antidisestablishmentarianismo');", "var $$S_Antidisestablishment_0=" + "  'Antidisestablishmentarianism';" + "var $$S_Antidisestablishment_0_1=" + "  'Antidisestablishmentarianismo';" + "f($$S_Antidisestablishment_0);" + "f($$S_Antidisestablishment_0);" + "f($$S_Antidisestablishment_0_1);" + "f($$S_Antidisestablishment_0_1);"); 
 }
  

  

  

  

  

  

  

  

  

  


  

  

  


  
}
