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

import com.google.javascript.rhino.Node;

/**
 * Unit tests for {@link CoalesceVariableNames}
 *
 */
public class CoalesceVariableNamesTest extends CompilerTestCase {
  // The spacing in this file is not exactly standard but it greatly helps
  // picking out which variable names are merged.

  private boolean usePseudoName = false;

  @Override
  protected int getNumRepetitions() {
   return 1;
  }

  @Override
  public void setUp() {
    super.enableLineNumberCheck(true);
    usePseudoName = false;
  }

  @Override
  public CompilerPass getProcessor(final Compiler compiler) {
    return new CompilerPass() {
      @Override
      public void process(Node externs, Node js) {
        NodeTraversal.traverse(compiler, js,
            new CoalesceVariableNames(compiler, usePseudoName));
      }
    };
  }

public void testSimple545() { 
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
  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  // Sometimes live range can be cross even within a VAR declaration.
  

  

  

  

  

  

  private void inFunction(String src) {
    inFunction(src, src);
  }

  private void inFunction(String src, String expected) {
    test("function FUNC(){" + src + "}",
         "function FUNC(){" + expected + "}");
  }

  private void test(String src) {
    test(src, src);
  }
}
