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

import com.google.javascript.rhino.Node;

public class PeepholeSimplifyRegExpTest extends CompilerTestCase {

public final void testBackReferences186() { 
     testSame("/foo(bar)baz(?:\\1|\\x01)boo/"); 
     test("/foo(?:bar)baz(?:\\1|\\x01)boo/", "/foobarbaz\\x01boo/"); 
     test("/foo(?:bar)baz(?:\\8|8)boo/", "/foobarbaz8boo/"); 
     test("/(1?)(2?)(3?)(4?)(5?)(6?)(7?)(8?)(9?)(A?)(B?)" + "\\12\\11\\10\\9\\8\\7\\6\\5\\4\\3\\2\\1\\0/", "/(1?)(2?)(3?)(4?)(5?)(6?)(7?)(8?)(9?)(A?)(B?)" + "\\1(?:2)\\11\\10\\9\\8\\7\\6\\5\\4\\3\\2\\1\\0/"); 
     test("/(1?)(2?)(3?)(4?)(5?)(6?)(7?)(8?)(9?)(A?)(B?)(?:\\1)0/", "/(1?)(2?)(3?)(4?)(5?)(6?)(7?)(8?)(9?)(A?)(B?)\\1(?:0)/"); 
     test("/(1?)(2?)(3?)(4?)(5?)(6?)(7?)(8?)(9?)(A?)(B?)(C?)" + "\\012\\11\\10\\9\\8\\7\\6\\5\\4\\3\\2\\1\\0/", "/(1?)(2?)(3?)(4?)(5?)(6?)(7?)(8?)(9?)(A?)(B?)(C?)" + "\\n\\11\\10\\9\\8\\7\\6\\5\\4\\3\\2\\1\\0/"); 
 }
public final void testSingleCharAlterations187() { 
     test("/a|B|c|D/i", "/[a-d]/i"); 
     test("/a|B|c|D/", "/[BDac]/"); 
     test("/a|[Bc]|D/", "/[BDac]/"); 
     test("/[aB]|[cD]/", "/[BDac]/"); 
     test("/a|B|c|D|a|B/i", "/[a-d]/i"); 
     test("/a|A|/i", "/a?/i"); 
 }
public final void testCharsetFixup188() { 
     testSame("/[a-z]/i"); 
     test("/[^\\0-`{-\\uffff]/i", "/(?!)/"); 
     test("/[^a-z]/i", "/[\\W\\d_]/"); 
 }
  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  @Override
  protected CompilerPass getProcessor(Compiler compiler) {
    final CompilerPass simplifier = new PeepholeOptimizationsPass(
        compiler, new PeepholeSimplifyRegExp());
    final CompilerPass checker = new CheckRegExp(compiler);

    return new CompilerPass() {
      @Override
      public void process(Node externs, Node root) {
        checker.process(externs, root);
        simplifier.process(externs, root);
      }
    };
  }
}
