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

import com.google.javascript.jscomp.type.ClosureReverseAbstractInterpreter;
import com.google.javascript.jscomp.type.FlowScope;
import com.google.javascript.rhino.Node;
import com.google.javascript.rhino.Token;
import com.google.javascript.rhino.jstype.JSType;
import com.google.javascript.rhino.testing.Asserts;

public class ClosureReverseAbstractInterpreterTest extends
    CompilerTypeTestCase {

public void testGoogIsArray3393() throws Exception { 
     testClosureFunction("goog.isArray", createUnionType(ARRAY_TYPE, NUMBER_STRING_BOOLEAN, NULL_TYPE, VOID_TYPE), OBJECT_TYPE, createUnionType(NUMBER_STRING_BOOLEAN, NULL_TYPE, VOID_TYPE)); 
 }
public void testGoogIsObject3394() throws Exception { 
     testClosureFunction("goog.isObject", createUnionType(OBJECT_TYPE, NUMBER_STRING_BOOLEAN, NULL_TYPE, VOID_TYPE), OBJECT_TYPE, createUnionType(NUMBER_STRING_BOOLEAN, NULL_TYPE, VOID_TYPE)); 
 }
public void testGoogIsArray3395() throws Exception { 
     testClosureFunction("goog.isArray", UNKNOWN_TYPE, CHECKED_UNKNOWN_TYPE, CHECKED_UNKNOWN_TYPE); 
 }
public void testGoogIsFunction1396() throws Exception { 
     testClosureFunction("goog.isFunction", createOptionalType(NUMBER_TYPE), NUMBER_TYPE, NULL_TYPE); 
 }
public void testGoogIsArrayOnNull397() throws Exception { 
     testClosureFunction("goog.isArray", null, ARRAY_TYPE, null); 
 }
public void testGoogIsArray3398() throws Exception { 
     testClosureFunction("goog.isArray", createUnionType(ARRAY_TYPE, NUMBER_STRING_BOOLEAN, NULL_TYPE, VOID_TYPE), ARRAY_TYPE, createUnionType(NUMBER_STRING_BOOLEAN, NULL_TYPE, VOID_TYPE)); 
 }
public void testGoogIsBoolean4681() throws Exception { 
     testClosureFunction("goog.isBoolean", UNKNOWN_TYPE, BOOLEAN_TYPE, CHECKED_UNKNOWN_TYPE); 
 }
  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  private void testClosureFunction(String function, JSType type,
      JSType trueType, JSType falseType) {
    // function(a) where a : type
    Node n = compiler.parseTestCode("var a; " + function + "(a)");
    Node call = n.getLastChild().getLastChild();
    Node name = call.getLastChild();

    Scope scope = new SyntacticScopeCreator(compiler).createScope(n, null);
    FlowScope flowScope = LinkedFlowScope.createEntryLattice(scope);

    assertEquals(Token.CALL, call.getType());
    assertEquals(Token.NAME, name.getType());

    GoogleCodingConvention convention = new GoogleCodingConvention();
    flowScope.inferSlotType("a", type);
    ClosureReverseAbstractInterpreter rai =
        new ClosureReverseAbstractInterpreter(convention, registry);

    // trueScope
    Asserts.assertTypeEquals(
        trueType,
        rai.getPreciserScopeKnowingConditionOutcome(call, flowScope, true)
        .getSlot("a").getType());

    // falseScope
    Asserts.assertTypeEquals(
        falseType,
        rai.getPreciserScopeKnowingConditionOutcome(call, flowScope, false)
        .getSlot("a").getType());
  }
}
