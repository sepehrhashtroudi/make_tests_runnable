/*
 *
 * ***** BEGIN LICENSE BLOCK *****
 * Version: MPL 1.1/GPL 2.0
 *
 * The contents of this file are subject to the Mozilla Public License Version
 * 1.1 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 * http://www.mozilla.org/MPL/
 *
 * Software distributed under the License is distributed on an "AS IS" basis,
 * WITHOUT WARRANTY OF ANY KIND, either express or implied. See the License
 * for the specific language governing rights and limitations under the
 * License.
 *
 * The Original Code is Rhino code, released
 * May 6, 1999.
 *
 * The Initial Developer of the Original Code is
 * Netscape Communications Corporation.
 * Portions created by the Initial Developer are Copyright (C) 1997-1999
 * the Initial Developer. All Rights Reserved.
 *
 * Contributor(s):
 *   Nick Santos
 *
 * Alternatively, the contents of this file may be used under the terms of
 * the GNU General Public License Version 2 or later (the "GPL"), in which
 * case the provisions of the GPL are applicable instead of those above. If
 * you wish to allow use of your version of this file only under the terms of
 * the GPL and not to allow others to use your version of this file under the
 * MPL, indicate your decision by deleting the provisions above and replacing
 * them with the notice and other provisions required by the GPL. If you do
 * not delete the provisions above, a recipient may use your version of this
 * file under either the MPL or the GPL.
 *
 * ***** END LICENSE BLOCK ***** */

package com.google.javascript.rhino.jstype;

import com.google.javascript.rhino.Node;
import com.google.javascript.rhino.SimpleErrorReporter;
import com.google.javascript.rhino.Token;
import com.google.javascript.rhino.jstype.JSTypeRegistry.ResolveMode;
import com.google.javascript.rhino.testing.Asserts;
import com.google.javascript.rhino.testing.AbstractStaticScope;
import com.google.javascript.rhino.testing.MapBasedScope;

import junit.framework.TestCase;

/**
 * Tests {@link JSTypeRegistry}.
 *
 */
public class JSTypeRegistryTest extends TestCase {
  // TODO(user): extend this class with more tests, as JSTypeRegistry is
  // now much larger
public void testTypeResolutionModes63() { 
     SimpleErrorReporter reporter = new SimpleErrorReporter(); 
     JSTypeRegistry lazyExprRegistry = new JSTypeRegistry(reporter); 
     lazyExprRegistry.setResolveMode(ResolveMode.LAZY_EXPRESSIONS); 
     JSTypeRegistry lazyNameRegistry = new JSTypeRegistry(reporter); 
     lazyNameRegistry.setResolveMode(ResolveMode.LAZY_NAMES); 
     JSTypeRegistry immediateRegistry = new JSTypeRegistry(reporter); 
     immediateRegistry.setResolveMode(ResolveMode.IMMEDIATE); 
     Node expr = new Node(Token.QMARK, Node.newString("foo")); 
     StaticScope<JSType> empty = MapBasedScope.emptyScope(); 
     JSType type = lazyExprRegistry.createFromTypeNodes(expr, "source.js", empty); 
     assertTrue(type instanceof UnresolvedTypeExpression); 
     assertTrue(type.isUnknownType()); 
     assertEquals("?", type.toString()); 
     assertNull("Unexpected warnings: " + reporter.warnings(), reporter.warnings()); 
     type = lazyNameRegistry.createFromTypeNodes(expr, "source.js", empty); 
     assertTrue(type instanceof UnionType); 
     assertTrue(type.isUnknownType()); 
     assertEquals("(foo|null)", type.toString()); 
     assertNull("Unexpected warnings: " + reporter.warnings(), reporter.warnings()); 
     type = immediateRegistry.createFromTypeNodes(expr, "source.js", empty); 
     assertTrue(type instanceof UnknownType); 
     assertEquals("Expected warnings", 1, reporter.warnings().size()); 
 }
public void testGenerationIncrementing2688() { 
     SimpleErrorReporter reporter = new SimpleErrorReporter(); 
     final JSTypeRegistry typeRegistry = new JSTypeRegistry(reporter); 
     StaticScope<JSType> scope = new AbstractStaticScope<JSType>() { 
  
         @Override 
         public StaticSlot<JSType> getSlot(final String name) { 
             return new SimpleSlot(name, typeRegistry.getNativeType(JSTypeNative.UNKNOWN_TYPE), false); 
         } 
     }; 
     ObjectType namedType = (ObjectType) typeRegistry.getType(scope, "Foo", null, 0, 0); 
     FunctionType functionType = typeRegistry.createFunctionType(namedType); 
     typeRegistry.setLastGeneration(false); 
     typeRegistry.resolveTypesInScope(scope); 
     assertTrue(functionType.getReturnType().isUnknownType()); 
     functionType.resolve(reporter, scope); 
     assertTrue(functionType.getReturnType().isUnknownType()); 
     typeRegistry.declareType("Foo", typeRegistry.createAnonymousObjectType(null)); 
     typeRegistry.resolveTypesInScope(scope); 
     assertTrue(functionType.getReturnType().isUnknownType()); 
     assertNull("Unexpected errors: " + reporter.errors(), reporter.errors()); 
     assertNull("Unexpected warnings: " + reporter.warnings(), reporter.warnings()); 
     typeRegistry.incrementGeneration(); 
     typeRegistry.setLastGeneration(true); 
     typeRegistry.resolveTypesInScope(scope); 
     assertFalse(functionType.getReturnType().isUnknownType()); 
 }
public void testTypeResolutionModes690() { 
     SimpleErrorReporter reporter = new SimpleErrorReporter(); 
     JSTypeRegistry lazyExprRegistry = new JSTypeRegistry(reporter); 
     lazyExprRegistry.setResolveMode(ResolveMode.LAZY_EXPRESSIONS); 
     Node expr = new Node(Token.QMARK, Node.newString("foo")); 
     JSType type = lazyExprRegistry.createFromTypeNodes(expr, "source.js", MapBasedScope.emptyScope()); 
     assertTrue(type instanceof UnresolvedTypeExpression); 
     assertTrue(type.isUnknownType()); 
     assertEquals("?", type.toString()); 
     assertNull("Unexpected warnings: " + reporter.warnings(), reporter.warnings()); 
     type = lazyExprRegistry.createFromTypeNodes(expr, "source.js", MapBasedScope.emptyScope()); 
     assertTrue(type instanceof UnionType); 
     assertTrue(type.isUnknownType()); 
     assertEquals("(foo|null)", type.toString()); 
     assertNull("Unexpected warnings: " + reporter.warnings(), reporter.warnings()); 
     type = lazyExprRegistry.createFromTypeNodes(expr, "source.js", MapBasedScope.emptyScope()); 
     assertTrue(type instanceof UnknownType); 
     assertEquals("Expected warnings", 1, reporter.warnings().size()); 
 }
public void testAllTypeResolvesImmediately691() { 
     JSTypeRegistry lazyExprRegistry = new JSTypeRegistry(new SimpleErrorReporter()); 
     lazyExprRegistry.setResolveMode(ResolveMode.LAZY_EXPRESSIONS); 
     Node expr = new Node(Token.STAR); 
     JSType type = lazyExprRegistry.createFromTypeNodes(expr, "source.js", MapBasedScope.emptyScope()); 
     assertTrue(type instanceof AllType); 
 }
  

  

  

  

  

  

  

  

  

  

  private void assertTypeEquals(JSType a, JSType b) {
    Asserts.assertTypeEquals(a, b);
  }
}
