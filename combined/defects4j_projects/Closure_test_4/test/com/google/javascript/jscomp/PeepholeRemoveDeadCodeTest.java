/*
 * Copyright 2004 The Closure Compiler Authors.
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

import com.google.javascript.rhino.Node;

/**
 * Tests for PeepholeRemoveDeadCodeTest in isolation. Tests for the interaction
 * of multiple peephole passes are in PeepholeIntegrationTest.
 */
public class PeepholeRemoveDeadCodeTest extends CompilerTestCase {

  private static final String MATH =
      "/** @const */ var Math = {};" +
      "/** @nosideeffects */ Math.random = function(){};" +
      "/** @nosideeffects */ Math.sin = function(){};";

  public PeepholeRemoveDeadCodeTest() {
    super(MATH);
  }

  @Override
  public void setUp() throws Exception {
    super.setUp();
    enableLineNumberCheck(true);
  }

  @Override
  public CompilerPass getProcessor(final Compiler compiler) {
    return new CompilerPass() {
      @Override
      public void process(Node externs, Node root) {
        SimpleDefinitionFinder definitionFinder =
            new SimpleDefinitionFinder(compiler);
        definitionFinder.process(externs, root);
        new PureFunctionIdentifier(compiler, definitionFinder)
            .process(externs, root);
        PeepholeOptimizationsPass peepholePass =
            new PeepholeOptimizationsPass(
                compiler, new PeepholeRemoveDeadCode());
        peepholePass.process(externs, root);
      }
    };
  }

  @Override
  protected int getNumRepetitions() {
    // Reduce this to 2 if we get better expression evaluators.
    return 2;
  }

  private void foldSame(String js) {
    testSame(js);
  }

  private void fold(String js, String expected) {
    test(js, expected);
  }

public void testConstantConditionWithSideEffect1154() { 
     fold("if (b=true) x=1;", "b=true;x=1"); 
     fold("if (b=/ab/) x=1;", "b=/ab/;x=1"); 
     foldSame("var b;b=/ab/;if(b)x=1;"); 
     fold("var b=/ab/;if(b)x=1;", "var b=/ab/;x=1"); 
     foldSame("var b=f();if(b)x=1;"); 
     foldSame("var b=f();if(b)x=1;"); 
     foldSame("var b=b++;if(b)x=b;"); 
     foldSame("var b=b++;if(b)x=b;"); 
     foldSame("var b=b++;if(b)x=b;"); 
     foldSame("b=b++;if(b)x=b;"); 
     fold("(b=0,b=1);if(b)x=b;", "b=0,b=1;if(b)x=b;"); 
     foldSame("b=1;if(b)x=b;"); 
     fold("b=1;if(foo,b)x=b;", "b=1;x=b;"); 
     foldSame("b=1;if(foo=1,b)x=b;"); 
 }
public void testFoldUselessFor155() { 
     fold("for(;false;) { foo() }", ""); 
     fold("for(;void 0;) { foo() }", ""); 
     fold("for(;undefined;) { foo() }", ""); 
     fold("for(;true;) foo() ", "for(;;) foo() "); 
     foldSame("for(;;) foo()"); 
     foldSame("for(;false;) { var a = 0; }"); 
     fold("for(;false;) { foo(); continue }", ""); 
 }
  

  /** Try to remove spurious blocks with multiple children */
  

  

  

  

  

  

  

  

  

  

  


  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  // TODO(johnlenz): Consider adding a post optimization pass to
  // convert OR into HOOK to save parentheses when the operator
  // precedents would require them.
  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  
}
