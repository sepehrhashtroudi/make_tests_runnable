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

public void testFoldStringSplit19() { 
     late = false; 
     fold("x = 'abcde'.split('foo')", "x = ['abcde']"); 
     fold("x = 'abcde'.split()", "x = ['abcde']"); 
     fold("x = 'abcde'.split(null)", "x = ['abcde']"); 
     fold("x = 'a b c d e'.split(' ')", "x = ['a','b','c','d','e']"); 
     fold("x = 'a b c d e'.split(' ', 0)", "x = []"); 
     fold("x = 'abcde'.split('cd')", "x = ['ab','e']"); 
     fold("x = 'a b c d e'.split(' ', 1)", "x = ['a']"); 
     fold("x = 'a b c d e'.split(' ', 3)", "x = ['a','b','c']"); 
     fold("x = 'a b c d e'.split(null, 1)", "x = ['a b c d e']"); 
     fold("x = 'aaaaa'.split('a')", "x = ['', '', '', '', '', '']"); 
     fold("x = 'xyx'.split('x')", "x = ['', 'y', '']"); 
     fold("x = 'abcde'.split('')", "x = ['a','b','c','d','e']"); 
     fold("x = 'abcde'.split('', 3)", "x = ['a','b','c']"); 
     fold("x = ''.split('')", "x = []"); 
     fold("x = 'aaa'.split('aaa')", "x = ['','']"); 
     fold("x = ' '.split(' ')", "x = ['','']"); 
     foldSame("x = 'abcde'.split(/ /)"); 
     foldSame("x = 'abcde'.split(' ', -1)"); 
     late = true;
}

public void testStringJoinAddSparse21() { 
     fold("x = [,,'a'].join(',')", "x = ',,a'"); 
 }
public void testFoldStringSubstring22() { 
     fold("x = 'abcde'.substr(0,2)", "x = 'ab'"); 
     fold("x = 'abcde'.substr(1,2)", "x = 'bc'"); 
     fold("x = 'abcde'.substr(2)", "x = 'bcd'"); 
     fold("x = 'abcde'.substr(3,4)", "x = 'cde'"); 
     foldSame("x = 'abcde'.substr(-1)"); 
     foldSame("x = 'abcde'.substr(1, -2)"); 
     foldSame("x = 'abcde'.substr(1, 2, 3)"); 
     foldSame("x = 'a'.substr(0, 2)"); 
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
