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

import com.google.common.base.Joiner;

/**
 * Tests OptimizeReturns
 * @author johnlenz@google.com (John Lenz)
 */
public class OptimizeReturnsTest extends CompilerTestCase {

  @Override
  protected CompilerPass getProcessor(Compiler compiler) {
    return new OptimizeReturns(compiler);
  }

  private static final String EXTERNAL_SYMBOLS =
    "var extern;extern.externalMethod";

  public OptimizeReturnsTest() {
    super(EXTERNAL_SYMBOLS);
  }

  @Override
  protected int getNumRepetitions() {
    // run pass once.
    return 1;
  }

  @Override
  protected void setUp() throws Exception {
    super.setUp();
    super.enableLineNumberCheck(true);
    disableTypeCheck();
  }

  /**
   * Combine source strings using '\n' as the separator.
   */
  private static String newlineJoin(String ... parts) {
    return Joiner.on("\n").join(parts);
  }

public void testRewriteUnusedResult7b562() throws Exception { 
     String source = newlineJoin("c();", "function c() { return b() }", "function b() { return a() }", "function a() { return 1 }"); 
     String expected = newlineJoin("c();", "function c() { b(); return }", "function b() { return a() }", "function a() { return 1 }"); 
     test(source, expected); 
     source = expected; 
     expected = newlineJoin("c();", "function c() { b(); return }", "function b() { a(); return }", "function a() { return 1 }"); 
     test(source, expected); 
     source = expected; 
     expected = newlineJoin("c();", "function c() { b(); return }", "function b() { a(); return }", "function a() { return }"); 
     test(source, expected); 
 }
public void testNoRewriteObjLit2563() throws Exception { 
     String source = newlineJoin("var a = {b:function fn(){return 1;}}", "for(c in a) (a[c])();", "a.b()"); 
     testSame(source); 
 }
public void testRewriteUnusedResult5699() throws Exception { 
     String source = newlineJoin("function a(){}", "a.prototype.foo = function(args) {return args};", "var o = new a;", "o.foo()"); 
     String expected = newlineJoin("function a(){}", "a.prototype.foo = function(args) {return};", "var o = new a;", "o.foo()"); 
     test(source, expected); 
 }
  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  
}
