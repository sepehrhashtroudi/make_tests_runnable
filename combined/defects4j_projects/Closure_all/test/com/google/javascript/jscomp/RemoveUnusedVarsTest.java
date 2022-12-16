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


public class RemoveUnusedVarsTest extends CompilerTestCase {

  private boolean removeGlobal;
  private boolean preserveFunctionExpressionNames;
  private boolean modifyCallSites;

  public RemoveUnusedVarsTest() {
    super("function alert() {}");
    enableNormalize();
  }

  @Override
  public void setUp() {
    removeGlobal = true;
    preserveFunctionExpressionNames = false;
    modifyCallSites = false;
  }

  @Override
  protected CompilerPass getProcessor(final Compiler compiler) {
    return new RemoveUnusedVars(
        compiler, removeGlobal, preserveFunctionExpressionNames,
        modifyCallSites);
  }


public void testCallSiteInteraction43() { 
     this.modifyCallSites = true; 
     testSame("var b=function(){return};b()"); 
     testSame("var b=function(c){return c};b(1)"); 
     test("var b=function(c){};b.call(null, x)", "var b=function(){};b.call(null)"); 
     test("var b=function(c){};b.apply(null, x)", "var b=function(){};b.apply(null, x)"); 
     test("var b=function(c){return};b(1)", "var b=function(){return};b()"); 
     test("var b=function(c){return};b(1,2)", "var b=function(){return};b()"); 
     test("var b=function(c){return};b(1,2);b(3,4)", "var b=function(){return};b();b()"); 
     test("var b=function(c,d){return d};b(1,2);b(3,4);b.length", "var b=function(c,d){return d};b(0,2);b(0,4);b.length"); 
     test("var b=function(c){return};b(1,2);b(3,new x())", "var b=function(){return};b();b(new x())"); 
     test("var b=function(c){return};b(1,2);b(new x(),4)", "var b=function(){return};b();b(new x())"); 
     test("var b=function(c,d){return d};b(1,2);b(new x(),4)", "var b=function(c,d){return d};b(0,2);b(new x(),4)"); 
     test("var b=function(c,d,e){return d};b(1,2,3);b(new x(),


public void testUnusedPropAssign1b333() { 
     test("var x = {}; x.foo = alert();", "alert()"); 
 }

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  
}
