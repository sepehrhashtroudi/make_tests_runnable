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

public final void testSingleCharAlterations63() { 
     test("/a|B|c|D/i", "/[a-d]/i"); 
     test("/a|B|c|D/", "/[BDac]/"); 
     test("/a|[Bc]|D/", "/[BDac]/"); 
     test("/[aB]|[cD]/", "/[BDac]/"); 
     test("/a|B|c|D|a|B/i", "/[a-d]/i"); 
     test("/a|A|/i", "/a?/i"); 
 }
public final void testWaysOfMatchingEmptyString68() { 
     testSame("/(?:)/"); 
     test("/(?:)/i", "/(?:)/"); 
     test("/.{0}/i", "/(?:)/"); 
     test("/[^\\0-\\uffff]{0}/", "/(?:)/"); 
     testSame("/(){0}/"); 
 }
public final void testMalformedRegularExpressions71() { 
     test("/(?<!foo)/", "/(?<!foo)/", null, CheckRegExp.MALFORMED_REGEXP); 
     test("/(/", "/(/", null, CheckRegExp.MALFORMED_REGEXP); 
     test("/)/", "/)/", null, CheckRegExp.MALFORMED_REGEXP); 
     test("/\\uabc/", "/\\uabc/", null, CheckRegExp.MALFORMED_REGEXP); 
     test("/\\uabcg/", "/\\uabcg/", null, CheckRegExp.MALFORMED_REGEXP); 
 }
public final void testBackReferences72() { 
     testSame("/foo(bar)baz(?:\\1|\\x01)boo/"); 
     test("/foo(?:bar)baz(?:\\1|\\x01)boo/", "/foobarbaz\\x01boo/"); 
     test("/foo(?:bar)baz(?:\\8|8)boo/", "/foobarbaz8boo/"); 
     test("/(1?)(2?)(3?)(4?)(5?)(6?)(7?)(8?)(9?)(A?)(B?)" + "\\12\\11\\10\\9\\8\\7\\6\\5\\4\\3\\2\\1\\0/", "/(1?)(2?)(3?)(4?)(5?)(6?)(7?)(8?)(9?)(A?)(B?)" + "\\1(?:2)\\11\\10\\9\\8\\7\\6\\5\\4\\3\\2\\1\\0/"); 
     test("/(1?)(2?)(3?)(4?)(5?)(6?)(7?)(8?)(9?)(A?)(B?)(?:\\1)0/", "/(1?)(2?)(3?)(4?)(5?)(6?)(7?)(8?)(9?)(A?)(B?)\\1(?:0)/"); 
     test("/(1?)(2?)(3?)(4?)(5?)(6?)(7?)(8?)(9?)(A?)(B?)(C?)" + "\\012\\11\\10\\9\\8\\7\\6\\5\\4\\3\\2\\1\\0/", "/(1?)(2?)(3?)(4?)(5?)(6?)(7?)(8?)(9?)(A?)(B?)(C?)" + "\\n\\11\\10\\9\\8\\7\\6\\5\\4\\3\\2\\1\\0/"); 
 }
public final void testUnion73() { 
     testSame("/foo(bar)baz(?:\\1|\\x01)boo/"); 
     test("/foo(?:bar)baz(?:\\1|\\x01)boo/", "/foobarbaz\\x01boo/"); 
     test("/foo(?:bar)baz(?:\\8|8)boo/", "/foobarbaz8boo/"); 
     test("/(1?)(2?)(3?)(4?)(5?)(6?)(7?)(8?)(9?)(A?)(B?)" + "\\12\\11\\10\\9\\8\\7\\6\\5\\4\\3\\2\\1\\0/", "/(1?)(2?)(3?)(4?)(5?)(6?)(7?)(8?)(9?)(A?)(B?)" + "\\1(?:2)\\11\\10\\9\\8\\7\\6\\5\\4\\3\\2\\1\\0/"); 
     test("/(1?)(2?)(3?)(4?)(5?)(6?)(7?)(8?)(9?)(A?)(B?)(?:\\1)0/", "/(1?)(2?)(3?)(4?)(5?)(6?)(7?)(8?)(9?)(A?)(B?)\\1(?:0)/"); 
     test("/(1?)(2?)(3?)(4?)(5?)(6?)(7?)(8?)(9?)(A?)(B?)(C?)" + "\\012\\11\\10\\9\\8\\7\\6\\5\\4\\3\\2\\1\\0/", "/(1?)(2?)(3?)(4?)(5?)(6?)(7?)(8?)(9?)(A?)(B?)(C?)" + "\\n\\11\\10\\9\\8\\7\\6\\5\\4\\3\\2\\1\\0/"); 
 }
public void testNoArgumentRemovalNonEqualNodes427() { 
     testSame("function foo(a){}; foo('bar'); foo('baz');"); 
     testSame("function foo(a){}; foo(1.0); foo(2.0);"); 
     testSame("function foo(a){}; foo(true); foo(false);"); 
     testSame("var a = 1, b = 2; function foo(a){}; foo(a); foo(b);"); 
     testSame("function foo(a){}; foo(/&/g); foo(/</g);"); 
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
