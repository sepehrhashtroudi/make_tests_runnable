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


public final void testMoreCharsets23() { 
     test("var a = /[\\x00\\x22\\x26\\x27\\x3c\\x3e]/g", "var a = /[\\0\"&'<>]/g"); 
     test("var b = /[\\x00\\x22\\x27\\x3c\\x3e]/g", "var b = /[\\0\"'<>]/g"); 
     test("var c = /[\\x00\\x09-\\x0d \\x22\\x26\\x27\\x2d\\/\\x3c-\\x3e`" + "\\x85\\xa0\\u2028\\u2029]/g", "var c = /[\\0\\t-\\r \"&'/<->`\\x85\\xa0\\u2028\\u2029-]/g"); 
     test("var d = /[\\x00\\x09-\\x0d \\x22\\x27\\x2d\\/\\x3c-\\x3e`" + "\\x85\\xa0\\u2028\\u2029]/g", "var d = /[\\0\\t-\\r \"'/<->`\\x85\\xa0\\u2028\\u2029-]/g"); 
     test("var e = /[\\x00\\x08-\\x0d\\x22\\x26\\x27\\/\\x3c-\\x3e\\\\" + "\\x85\\u2028\\u2029]/g", "var e = /[\\0\\b-\\r\"&'/<->\\\\\\x85\\u2028\\u2029]/g"); 
     test("var f = /[\\x00\\x08-\\x0d\\x22\\x24\\x26-\\/\\x3a\\x3c-\\x3f" + "\\x5b-\\x5e\\x7b-\\x7d\\x85\\u2028\\u2029]/g", "var f = /[\\0\\b-\\r\"$&-/:<-?[-^{-}\\x85\\u2028\\u2029]/g"); [


public final void testRepetitions56() { 
     testSame("/a*/"); 
     testSame("/a+/"); 
     testSame("/a+?/"); 
     testSame("/a?/"); 
     testSame("/a{6}/"); 
     test("/a{4,}/", "/aaa+/"); 
     test("/a{3,}/", "/aaabbbb?/"); 
     testSame("/a{4,6}/"); 
     test("/a{4,6}?/"); 
     test("/(?:a?)?/", "/a?/"); 
     test("/(?:a?)*/", "/a*/"); 
     test("/(?:a*)?/", "/a*/"); 
     test("/a(?:a*)?/", "/a+/"); 
     test("/(?:a{2,3}){3,4}/", "/a{6,12}/"); 
     test("/a{2,3}a{3,4}/", "/a{5,7}/"); 
     testSame("/a{5,7}b{5,6}/"); 
     test("/a{2,3}b{3,4}/", "/aaa?bbbb?/"); 
     test("/a{3}b{3,4}/", "/aaabbbb?/"); 
     testSame("/[a-z]{1,2}/"); 
     test("/\\d{1,2}/", "/\\d\\d?/"); 
     test("/a*a*/", "/a*/"); 
     test("/a+a+/", "/aa+/"); 
     test("/a+a*/", "/a+/"); 
     testSame("/a\\{3,1}/"); 
     test("/a(?:{3,1})/", "/a\\{3,1}/"); 
     test("/a{3\\,1}/", "/a\\{3,1


public final void testRepetitions185() { 
     testSame("/a*/"); 
     testSame("/a+/"); 
     testSame("/a+?/"); 
     testSame("/a?/"); 
     testSame("/a{6}/"); 
     testSame("/a{4,}/"); 
     test("/a{3,}/", "/aaa+/"); 
     test("/a{4,6}/", "/aaabbbb?/"); 
     test("/a{4,6}?/"); 
     test("/(?:a?)?/", "/a?/"); 
     test("/(?:a?)*/", "/a*/"); 
     test("/(?:a*)?/", "/a*/"); 
     test("/a(?:a*)?/", "/a+/"); 
     test("/(?:a{2,3}){3,4}/", "/a{6,12}/"); 
     test("/a{2,3}a{3,4}/", "/a{5,7}/"); 
     testSame("/a{5,7}b{5,6}/"); 
     test("/a{2,3}b{3,4}/", "/aaa?bbbb?/"); 
     test("/a{3}b{3,4}/", "/aaabbbb?/"); 
     testSame("/[a-z]{1,2}/"); 
     test("/\\d{1,2}/", "/\\d\\d?/"); 
     test("/a*a*/", "/a*/"); 
     test("/a+a+/", "/aa+/"); 
     test("/a+a*/", "/a+/"); 
     testSame("/a\\{3,1}/"); 
     test("/a(?:{3,1})/", "/a\\{3,1}/"); 
     test("/a{3\\,1}/", "/a\\{3,1


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


public final void testRepetitions189() { 
     testSame("/a*/"); 
     testSame("/a+/"); 
     testSame("/a+?/"); 
     testSame("/a?/"); 
     testSame("/a{6}/"); 
     testSame("/a{4,}/"); 
     test("/a{3,}/", "/aaa+/"); 
     test("/a{4,6}/", "/aaa+/"); 
     test("/a{4,6}?/"); 
     test("/(?:a?)?/", "/a?/"); 
     test("/(?:a?)*/", "/a*/"); 
     test("/(?:a*)?/", "/a*/"); 
     test("/a(?:a*)?/", "/a+/"); 
     test("/(?:a{2,3}){3,4}/", "/a{6,12}/"); 
     test("/a{2,3}a{3,4}/", "/a{5,7}/"); 
     testSame("/a{5,7}b{5,6}/"); 
     test("/a{2,3}b{3,4}/", "/aaa?bbbb?/"); 
     test("/a{3}b{3,4}/", "/aaabbbb?/"); 
     testSame("/[a-z]{1,2}/"); 
     test("/\\d{1,2}/", "/\\d\\d?/"); 
     test("/a*a*/", "/a*/"); 
     test("/a+a+/", "/aa+/"); 
     test("/a+a*/", "/a+/"); 
     testSame("/a\\{3,1}/"); 
     test("/a(?:{3,1})/", "/a\\{3,1}/"); 
     test("/a{3\\,1}/", "/a\\{3,1}/"); [

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

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
