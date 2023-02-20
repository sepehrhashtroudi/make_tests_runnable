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

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.google.javascript.rhino.Node;

import junit.framework.TestCase;

import java.util.List;

/**
 * @author johnlenz@google.com (John Lenz)
 */
public class CompilerTest extends TestCase {

public void testCyclicalDependencyInInputs695() { 
     List<SourceFile> inputs = Lists.newArrayList(SourceFile.fromCode("gin", "goog.provide('gin'); goog.require('tonic'); var gin = {};"), SourceFile.fromCode("tonic", "goog.provide('tonic'); goog.require('gin'); var tonic = {};"), SourceFile.fromCode("mix", "goog.require('gin'); goog.require('tonic');")); 
     CompilerOptions options = new CompilerOptions(); 
     options.ideMode = true; 
     options.setManageClosureDependencies(true); 
     Compiler compiler = new Compiler(); 
     compiler.init(ImmutableList.<SourceFile>of(), inputs, options); 
     compiler.parseInputs(); 
     assertEquals(compiler.externAndJsRoot, compiler.jsRoot.getParent()); 
     assertEquals(compiler.externAndJsRoot, compiler.externsRoot.getParent()); 
     assertNotNull(compiler.externAndJsRoot); 
     Node jsRoot = compiler.jsRoot; 
     assertEquals(3, jsRoot.getChildCount()); 
 }
  

  // Verify the line and column information is maintained after a reset
  

  

  

  

  

  

  private Compiler initCompilerForCommonJS(
      List<SourceFile> inputs, List<String> entryPoints)
      throws Exception {
    CompilerOptions options = new CompilerOptions();
    options.ideMode = true;
    options.setManageClosureDependencies(entryPoints);
    options.closurePass = true;
    options.processCommonJSModules = true;
    Compiler compiler = new Compiler();
    compiler.init(Lists.<SourceFile>newArrayList(), inputs, options);
    compiler.parseInputs();
    return compiler;
  }


}
