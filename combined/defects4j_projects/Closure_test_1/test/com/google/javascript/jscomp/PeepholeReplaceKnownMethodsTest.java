/*
 * Copyright 2011 The Closure Compiler Authors.
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

/**
 * Unit tests for {#link {@link PeepholeReplaceKnownMethods}
 *
 */
public class PeepholeReplaceKnownMethodsTest extends CompilerTestCase {

  private boolean late = true;

  public PeepholeReplaceKnownMethodsTest() {
    super("");
  }

  @Override
  public void setUp() {
    enableLineNumberCheck(true);
  }

  @Override
  public CompilerPass getProcessor(final Compiler compiler) {
    CompilerPass peepholePass = new PeepholeOptimizationsPass(compiler,
          new PeepholeReplaceKnownMethods(late));
    return peepholePass;
  }

public void testFoldStringSubstring25() { 
     fold("x = 'abcde'.substring(0,2)", "x = 'ab'"); 
     fold("x = 'abcde'.substring(1,2)", "x = 'b'"); 
     fold("x = 'abcde'['substring'](1,3)", "x = 'bc'"); 
     fold("x = 'abcde'.substring(1,4)", "x = 'cde'"); 
     foldSame("x = 'abcde'.substring(-1)"); 
     foldSame("x = 'abcde'.substring(1, -2)"); 
     foldSame("x = 'abcde'.substring(1, 2, 3)"); 
     foldSame("x = 'a'.substring(0, 2)"); 
 }
public void testFoldStringSubstring26() { 
     fold("x = 'abcde'.substring(0,2)", "x = 'ab'"); 
     fold("x = 'abcde'.substring(1,2)", "x = 'b'"); 
     fold("x = 'abcde'['substring'](1,3)", "x = 'bc'"); 
     fold("x = 'abcde'.substring(1,2)", "x = 'cde'"); 
     foldSame("x = 'abcde'.substring(-1)"); 
     foldSame("x = 'abcde'.substring(1, -2)"); 
     foldSame("x = 'abcde'.substring(1, 2, 3)"); 
     foldSame("x = 'a'.substring(0, 2)"); 
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
}
