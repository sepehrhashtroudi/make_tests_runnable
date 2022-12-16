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

import com.google.common.collect.Lists;
import com.google.javascript.rhino.Node;
import com.google.javascript.rhino.Token;
import com.google.javascript.jscomp.NodeIterators.FunctionlessLocalScope;
import com.google.javascript.jscomp.NodeIterators.LocalVarMotion;

import java.util.Iterator;
import java.util.List;
import junit.framework.TestCase;

/**
 * Tests for NodeIterators.
 * @author nicksantos@google.com (Nick Santos)
 */
public class NodeIteratorsTest extends TestCase {

  // In each test, we find the declaration of "X" in the local scope,
  // construct a list of all nodes where X is guaranteed to retain its
  // original value, and compare those nodes against an expected list of
  // tokens.


public void testMayEffectMutableState18() { 
     assertMutableState(true, "i++"); 
     assertMutableState(true, "[b, [a, i++]]"); 
     assertMutableState(true, "i=3"); 
     assertMutableState(true, "[0, i=3]"); 
     assertMutableState(true, "b()"); 
     assertMutableState(true, "void b()"); 
     assertMutableState(true, "[1, b()]"); 
     assertMutableState(true, "b.b=4"); 
     assertMutableState(true, "b.b--"); 
     assertMutableState(true, "i--"); 
     assertMutableState(true, "a[0][i=4]"); 
     assertMutableState(true, "a += 3"); 
     assertMutableState(true, "a, b, z += 4"); 
     assertMutableState(true, "a ? c : d++"); 
     assertMutableState(true, "a + c++"); 
     assertMutableState(true, "a + c - d()"); 
     assertMutableState(true, "a + c - d()"); 
     assertMutableState(true, "function foo() {}"); 
     assertMutableState(true, "while(true);"); 
     assertMutableState(true, "if(true){a()}"); 
     assertMutableState(false, "if(true){a}"); 
     assertMutableState(true, "(function() { })"); 
     assertMutableState(true, "(function() { i++ })"); 
     assertMutableState(true, "[function a(){}]"); 
     assertMutableState(false, "a"); 
     assertMutableState(true, "[b, c [d, [e]]]"); 
     assertMutableState(true, "({a: x, b: y, c: z})"); 
     assertMutableState(true, "/abc/gi"); 
     assertMutableState


public void testStubsInExterns4153() { 
     testSame("Extern.prototype.foo;" + "/** @constructor */ function Extern() {}", "", null); 
     JSType e = globalScope.getVar("Extern").getType(); 
     assertEquals("function (new:Extern): ?", e.toString()); 
     ObjectType externProto = ((FunctionType) e).getPrototype(); 
     assertTrue(globalScope.getRootNode().toStringTree(), externProto.hasOwnProperty("foo")); 
     assertTrue(externProto.isPropertyTypeInferred("foo")); 
     assertEquals("?", externProto.getPropertyType("foo").toString()); 
     assertTrue(externProto.isPropertyInExterns("foo")); 
 }


public void testHaltAtVarRef154() { 
     testVarMotionWithCode("var X, Y = 3; var Z = X;", Token.NUMBER, Token.NAME, Token.VAR, Token.NAME); 
 }

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  /**
   * Parses the given code, finds the variable X in the global scope, and runs
   * the VarMotion iterator. Asserts that the iteration order matches the
   * tokens given.
   */
  

  /**
   * @see #testVarMotionWithCode(String, int ...)
   */
  
}
