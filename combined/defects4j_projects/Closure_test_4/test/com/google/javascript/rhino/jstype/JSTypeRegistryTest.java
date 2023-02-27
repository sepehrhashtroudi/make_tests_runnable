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
public void testForceResolve398() { 
     SimpleErrorReporter reporter = new SimpleErrorReporter(); 
     JSTypeRegistry lazyExprRegistry = new JSTypeRegistry(reporter); 
     lazyExprRegistry.setResolveMode(ResolveMode.LAZY_EXPRESSIONS); 
     Node expr = new Node(Token.QMARK, Node.newString("foo")); 
     StaticScope<JSType> empty = MapBasedScope.emptyScope(); 
     JSType type = lazyExprRegistry.createFromTypeNodes(expr, "source.js", empty); 
     assertFalse(type.isResolved()); 
     assertTrue(type.forceResolve(reporter, empty).isResolved()); 
     assertEquals("Expected warnings", 1, reporter.warnings().size()); 
 }
  

  

  

  

  

  

  

  

  

  

  private void assertTypeEquals(JSType a, JSType b) {
    Asserts.assertTypeEquals(a, b);
  }
}