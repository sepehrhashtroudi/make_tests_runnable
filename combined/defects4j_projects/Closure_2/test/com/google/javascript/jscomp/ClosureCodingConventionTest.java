/*
 * Copyright 2007 The Closure Compiler Authors.
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

import com.google.javascript.jscomp.CodingConvention.SubclassRelationship;
import com.google.javascript.jscomp.CodingConvention.SubclassType;
import com.google.javascript.rhino.Node;
import com.google.javascript.rhino.Token;
import com.google.javascript.rhino.jstype.FunctionType;
import com.google.javascript.rhino.jstype.JSTypeRegistry;

import junit.framework.TestCase;

/**
 * Test class for {@link GoogleCodingConvention}.
 */
public class ClosureCodingConventionTest extends TestCase {
  private ClosureCodingConvention conv = new ClosureCodingConvention();

public void testInheritanceDetection10552() { 
     assertDefinesClasses("goog.mixin(A.prototype, B.prototype);", "A", "B"); 
 }
public void testInheritanceDetectionPostCollapseProperties553() { 
     assertDefinesClasses("goog$inherits(A, B);", "A", "B"); 
     assertNotClassDefining("goog$inherits(A);"); 
 }
public void testInheritanceDetection5554() { 
     assertDefinesClasses("goog.A.inherits(goog.B);", "goog.A", "goog.B"); 
 }
public void testFunctionBind557() { 
     assertNotFunctionBind("goog.bind()"); 
     assertFunctionBind("goog.bind(f)"); 
     assertFunctionBind("goog.bind(f, obj)"); 
     assertFunctionBind("goog.bind(f, obj, p1)"); 
     assertNotFunctionBind("goog$bind()"); 
     assertFunctionBind("goog$bind(f)"); 
     assertFunctionBind("goog$bind(f, obj)"); 
     assertFunctionBind("goog$bind(f, obj, p1)"); 
     assertNotFunctionBind("goog.partial()"); 
     assertFunctionBind("goog.partial(f)"); 
     assertFunctionBind("goog.partial(f, obj)"); 
     assertFunctionBind("goog.partial(f, obj, p1)"); 
     assertNotFunctionBind("goog$partial()"); 
     assertFunctionBind("goog$partial(f)"); 
     assertFunctionBind("goog$partial(f, obj)"); 
     assertFunctionBind("goog$partial(f, obj, p1)"); 
     assertFunctionBind("(function(){}).bind()"); 
     assertFunctionBind("(function(){}).bind(obj)"); 
     assertFunctionBind("(function(){}).bind(obj, p1)"); 
     assertNotFunctionBind("Function.prototype.bind.call()"); 
     assertFunctionBind("Function.prototype.bind.call(obj)"); 
     assertFunctionBind("Function.prototype.bind.call(obj, p1)"); 
 }
public void testVarAndOptionalParams558() { 
     Node args = new Node(Token.PARAM_LIST, Node.newString(Token.NAME, "a"), Node.newString(Token.NAME, "b")); 
     Node optArgs = new Node(Token.PARAM_LIST, Node.newString(Token.NAME, "opt_a"), Node.newString(Token.NAME, "opt_b")); 
     assertFalse(conv.isVarArgsParameter(args.getFirstChild())); 
     assertTrue(conv.isVarArgsParameter(args.getLastChild())); 
     assertFalse(conv.isVarArgsParameter(optArgs.getFirstChild())); 
     assertTrue(conv.isVarArgsParameter(optArgs.getLastChild())); 
     assertTrue(conv.isOptionalParameter(args.getFirstChild())); 
     assertFalse(conv.isOptionalParameter(args.getLastChild())); 
     assertTrue(conv.isOptionalParameter(optArgs.getFirstChild())); 
     assertFalse(conv.isOptionalParameter(optArgs.getLastChild())); 
 }
  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  private void assertFunctionBind(String code) {
    Node n = parseTestCode(code);
    assertNotNull(conv.describeFunctionBind(n.getFirstChild()));
  }

  private void assertNotFunctionBind(String code) {
    Node n = parseTestCode(code);
    assertNull(conv.describeFunctionBind(n.getFirstChild()));
  }

  private void assertRequire(String code) {
    Node n = parseTestCode(code);
    assertNotNull(conv.extractClassNameIfRequire(n.getFirstChild(), n));
  }

  private void assertNotRequire(String code) {
    Node n = parseTestCode(code);
    assertNull(conv.extractClassNameIfRequire(n.getFirstChild(), n));
  }

  private void assertNotObjectLiteralCast(String code) {
    Node n = parseTestCode(code);
    assertNull(conv.getObjectLiteralCast(n.getFirstChild()));
  }

  private void assertObjectLiteralCast(String code) {
    Node n = parseTestCode(code);
    assertNotNull(conv.getObjectLiteralCast(n.getFirstChild()));
  }

  private void assertNotClassDefining(String code) {
    Node n = parseTestCode(code);
    assertNull(conv.getClassesDefinedByCall(n.getFirstChild()));
  }

  private void assertDefinesClasses(String code, String subclassName,
      String superclassName) {
    Node n = parseTestCode(code);
    SubclassRelationship classes =
        conv.getClassesDefinedByCall(n.getFirstChild());
    assertNotNull(classes);
    assertEquals(subclassName, classes.subclassName);
    assertEquals(superclassName, classes.superclassName);
  }

  private Node parseTestCode(String code) {
    Compiler compiler = new Compiler();
    return compiler.parseTestCode(code).getFirstChild();
  }
}
