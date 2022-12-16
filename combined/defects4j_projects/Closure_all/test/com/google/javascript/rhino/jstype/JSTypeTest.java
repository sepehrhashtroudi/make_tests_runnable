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

import static com.google.javascript.rhino.jstype.TernaryValue.FALSE;
import static com.google.javascript.rhino.jstype.TernaryValue.TRUE;
import static com.google.javascript.rhino.jstype.TernaryValue.UNKNOWN;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import com.google.javascript.rhino.JSDocInfo;
import com.google.javascript.rhino.JSDocInfo.Visibility;
import com.google.javascript.rhino.Node;
import com.google.javascript.rhino.SimpleErrorReporter;
import com.google.javascript.rhino.Token;
import com.google.javascript.rhino.jstype.ArrowType;
import com.google.javascript.rhino.jstype.JSType.TypePair;
import com.google.javascript.rhino.jstype.RecordTypeBuilder.RecordProperty;
import com.google.javascript.rhino.testing.Asserts;
import com.google.javascript.rhino.testing.AbstractStaticScope;
import com.google.javascript.rhino.testing.BaseJSTypeTestCase;
import com.google.javascript.rhino.testing.MapBasedScope;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

// TODO(nicksantos): Split some of this up into per-class unit tests.
public class JSTypeTest extends BaseJSTypeTestCase {
  private FunctionType dateMethod;
  private FunctionType functionType;
  private NamedType unresolvedNamedType;
  private FunctionType googBar;
  private FunctionType googSubBar;
  private FunctionType googSubSubBar;
  private ObjectType googBarInst;
  private ObjectType googSubBarInst;
  private ObjectType googSubSubBarInst;
  private NamedType namedGoogBar;
  private ObjectType subclassOfUnresolvedNamedType;
  private FunctionType subclassCtor;
  private FunctionType interfaceType;
  private ObjectType interfaceInstType;
  private FunctionType subInterfaceType;
  private ObjectType subInterfaceInstType;
  private JSType recordType;
  private EnumType enumType;
  private EnumElementType elementsType;
  private NamedType forwardDeclaredNamedType;

  private static final StaticScope<JSType> EMPTY_SCOPE =
      MapBasedScope.emptyScope();

  /**
   * A non exhaustive list of representative types used to test simple
   * properties that should hold for all types (such as the reflexivity
   * of subtyping).
   */
  private List<JSType> types;

  @Override
  protected void setUp() throws Exception {
    super.setUp();

    RecordTypeBuilder builder = new RecordTypeBuilder(registry);
    builder.addProperty("a", NUMBER_TYPE, null);
    builder.addProperty("b", STRING_TYPE, null);
    recordType = builder.build();

    enumType = new EnumType(registry, "Enum", null, NUMBER_TYPE);
    elementsType = enumType.getElementsType();
    functionType = new FunctionBuilder(registry)
        .withReturnType(NUMBER_TYPE)
        .build();
    dateMethod = new FunctionBuilder(registry)
        .withParamsNode(new Node(Token.PARAM_LIST))
        .withReturnType(NUMBER_TYPE)
        .withTypeOfThis(DATE_TYPE)
        .build();
    unresolvedNamedType =
        new NamedType(registry, "not.resolved.named.type", null, -1, -1);
    namedGoogBar = new NamedType(registry, "goog.Bar", null, -1, -1);

    subclassCtor =
        new FunctionType(registry, null, null, createArrowType(null),
            null, null, true, false);
    subclassCtor.setPrototypeBasedOn(unresolvedNamedType);
    subclassOfUnresolvedNamedType = subclassCtor.getInstanceType();

    interfaceType = FunctionType.forInterface(registry, "Interface", null);
    interfaceInstType = interfaceType.getInstanceType();

    subInterfaceType = FunctionType.forInterface(
        registry, "SubInterface", null);
    subInterfaceType.setExtendedInterfaces(
        Lists.<ObjectType>newArrayList(interfaceInstType));
    subInterfaceInstType = subInterfaceType.getInstanceType();

    googBar = registry.createConstructorType(
        "goog.Bar", null, null, null, null);
    googBar.getPrototype().defineDeclaredProperty("date", DATE_TYPE,
        null);
    googBar.setImplementedInterfaces(
        Lists.<ObjectType>newArrayList(interfaceInstType));
    googBarInst = googBar.getInstanceType();

    googSubBar = registry.createConstructorType(
        "googSubBar", null, null, null, null);
    googSubBar.setPrototypeBasedOn(googBar.getInstanceType());
    googSubBarInst = googSubBar.getInstanceType();

    googSubSubBar = registry.createConstructorType(
        "googSubSubBar", null, null, null, null);
    googSubSubBar.setPrototypeBasedOn(googSubBar.getInstanceType());
    googSubSubBarInst = googSubSubBar.getInstanceType();

    final ObjectType googObject = registry.createAnonymousObjectType(null);
    googObject.defineDeclaredProperty("Bar", googBar, null);

    namedGoogBar.resolve(null, new AbstractStaticScope<JSType>() {
          @Override
          public StaticSlot<JSType> getSlot(String name) {
            if ("goog".equals(name)) {
              return new SimpleSlot("goog", googObject, false);
            } else {
              return null;
            }
          }
        });
    assertNotNull(namedGoogBar.getImplicitPrototype());

    forwardDeclaredNamedType =
        new NamedType(registry, "forwardDeclared", "source", 1, 0);
    registry.forwardDeclareType("forwardDeclared");
    forwardDeclaredNamedType.resolve(
        new SimpleErrorReporter(), EMPTY_SCOPE);

    types = ImmutableList.of(
        NO_OBJECT_TYPE,
        NO_RESOLVED_TYPE,
        NO_TYPE,
        BOOLEAN_OBJECT_TYPE,
        BOOLEAN_TYPE,
        STRING_OBJECT_TYPE,
        STRING_TYPE,
        VOID_TYPE,
        UNKNOWN_TYPE,
        NULL_TYPE,
        NUMBER_OBJECT_TYPE,
        NUMBER_TYPE,
        DATE_TYPE,
        ERROR_TYPE,
        SYNTAX_ERROR_TYPE,
        dateMethod,
        functionType,
        unresolvedNamedType,
        googBar,
        googSubBar,
        googSubSubBar,
        namedGoogBar,
        googBar.getInstanceType(),
        subclassOfUnresolvedNamedType,
        subclassCtor,
        recordType,
        enumType,
        elementsType,
        googBar,
        googSubBar,
        forwardDeclaredNamedType);
  }

  /**
   * Tests the behavior of the top constructor type.
   */

public void testStringValueType33() throws Exception { 
     assertFalse(STRING_TYPE.isArrayType()); 
     assertFalse(STRING_TYPE.isBooleanObjectType()); 
     assertFalse(STRING_TYPE.isBooleanValueType()); 
     assertFalse(STRING_TYPE.isDateType()); 
     assertFalse(STRING_TYPE.isEnumElementType()); 
     assertFalse(STRING_TYPE.isNamedType()); 
     assertFalse(STRING_TYPE.isNullType()); 
     assertFalse(STRING_TYPE.isNumber()); 
     assertFalse(STRING_TYPE.isNumberObjectType()); 
     assertFalse(STRING_TYPE.isNumberValueType()); 
     assertFalse(STRING_TYPE.isObject()); 
     assertFalse(STRING_TYPE.isFunctionPrototypeType()); 
     assertFalse(STRING_TYPE.isRegexpType()); 
     assertTrue(STRING_TYPE.isString()); 
     assertFalse(STRING_TYPE.isStringObjectType()); 
     assertFalse(STRING_TYPE.isStringValueType()); 
     assertFalse(STRING_TYPE.isEnumType()); 
     assertFalse(STRING_TYPE.isUnionType()); 
     assertFalse(STRING_TYPE.isStruct()); 
     assertFalse(STRING_TYPE.isDict()); 
     assertFalse(STRING_TYPE.isAllType()); 
     assertFalse(STRING_TYPE.isVoidType()); 
     assertFalse(STRING_TYPE.isConstructor()); 
     assertFalse(STRING_TYPE.isInstanceType()); 
     assertTypeEquals(STRING_OBJECT_TYPE, STRING_TYPE.autoboxesTo()); 
     assertTypeEquals(STRING_TYPE, STRING_OBJECT_TYPE.unboxesTo()); 
     assertTrue(STRING_TYPE.isSubtype(ALL_TYPE)); 
     assertFalse(STRING_TYPE.isSubtype(STRING_OBJECT_TYPE)); 
     assertFalse(STRING_TYPE.isSubtype(NUMBER_TYPE)); 
     assertFalse(STRING_TYPE.isSubtype(OBJECT_TYPE)); 
     assertFalse(STRING_TYPE.isSub


public void testSymmetryOfTestForEquality282() { 
     List<JSType> listA = getTypesToTestForSymmetry(); 
     List<JSType> listB = getTypesToTestForSymmetry(); 
     for (JSType typeA : listA) { 
         for (JSType typeB : listB) { 
             TernaryValue aOnB = typeA.testForEquality(typeB); 
             TernaryValue bOnA = typeB.testForEquality(typeA); 
             assertTrue(String.format("testForEquality not symmetrical:\n" + "typeA: %s\ntypeB: %s\n" + "a.testForEquality(b): %s\n" + "b.testForEquality(a): %s\n", typeA, typeB, aOnB, bOnA), aOnB == bOnA); 
         } 
     } 
 }


public void testPropertyTypeOfUnionType283() throws Exception { 
     testTypes("var a = {};" + "/** @constructor */ a.N = function() {};\n" + "a.N.prototype.p = 1;\n" + "/** @constructor */ a.S = function() {};\n" + "a.S.prototype.p = 'a';\n" + "/** @param {!a.N|!a.S} x\n@return {string} */\n" + "var f = function(x) { return x.p; };", "inconsistent return type\n" + "found   : (number|string)\n" + "required: string"); 
 }


public void testGetpropDict2284() throws Exception { 
     testTypes("/**\n" + " * @constructor\n" + " * @dict\n" + " */" + "function Dict1(){ this['prop'] = 123; }" + "/**\n" + " * @constructor\n" + " * @extends {Dict1}\n" + " */" + "function Dict1kid(){ this['prop'] = 123; }" + "/** @param{Dict1kid} x */" + "function takesDict(x) { return x.prop; }", "Cannot do '.' access on a dict"); 
 }


public void testBitOperation9285() throws Exception { 
     testTypes("var x = void 0; x |= {};", "bad right operand to bitwise operator\n" + "found   : {}\n" + "required: (boolean|null|number|string|undefined)"); 
 }


public void testNullType286() { 
     testTypes("var x = goog.Timer;", "/** @param draggable */ types.actual;" + "/** @param draggable */ types.expected;"); 
 }


public void testForceResolve287() { 
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


public void testRecordTypeLeastSupertype2288() { 
     RecordTypeBuilder builder = new RecordTypeBuilder(registry); 
     builder.addProperty("a", STRING_TYPE, null); 
     JSType aType = builder.build(); 
     builder = new RecordTypeBuilder(registry); 
     builder.addProperty("a", STRING_TYPE, null); 
     builder.addProperty("b", STRING_TYPE, null); 
     JSType abType = builder.build(); 
     builder = new RecordTypeBuilder(registry); 
     builder.addProperty("a", STRING_TYPE, null); 
     builder.addProperty("c", STRING_TYPE, null); 
     JSType acType = builder.build(); 
     JSType abOrAcType = registry.createUnionType(abType, acType); 
     builder = new RecordTypeBuilder(registry); 
     builder.addProperty("a", STRING_TYPE, null); 
     builder.addProperty("b", STRING_TYPE, null); 
     builder.addProperty("c", NUMBER_TYPE, null); 
     JSType abcType = builder.build(); 
     List<JSType> typeChain = Lists.newArrayList(registry.getNativeType(JSTypeNative.ALL_TYPE), registry.getNativeType(JSTypeNative.OBJECT_PROTOTYPE), registry.getNativeType(JSTypeNative.OBJECT_TYPE), aType, abOrAcType, abType, abcType, registry.getNativeType(JSTypeNative.NO_OBJECT_TYPE), registry.getNativeType(JSTypeNative.NO_TYPE)); 
     verifySubtypeChain(typeChain); 
 }


public void testBug1484445289() throws Exception { 
     testTypes("/** @constructor */ function Foo() {}" + "/** @type {number?} */ Foo.prototype.bar = null;" + "/** @type {number?} */ Foo.prototype.baz = null;" + "/** @param {Foo} foo */" + "function f(foo) {" + "  while (true) {" + "    if (foo.bar == null && foo.baz == null) {" + "      foo.bar;" + "    }" + "  }" + "}"); 
 }


public void testRecordTypeLeastSuperType2290() { 
     RecordTypeBuilder builder = new RecordTypeBuilder(registry); 
     builder.addProperty("a", STRING_TYPE, null); 
     JSType aType = builder.build(); 
     builder = new RecordTypeBuilder(registry); 
     builder.addProperty("a", STRING_TYPE, null); 
     builder.addProperty("b", STRING_TYPE, null); 
     JSType abType = builder.build(); 
     builder = new RecordTypeBuilder(registry); 
     builder.addProperty("a", STRING_TYPE, null); 
     builder.addProperty("c", STRING_TYPE, null); 
     JSType acType = builder.build(); 
     JSType abOrAcType = registry.createUnionType(abType, acType); 
     builder = new RecordTypeBuilder(registry); 
     builder.addProperty("a", STRING_TYPE, null); 
     builder.addProperty("b", STRING_TYPE, null); 
     builder.addProperty("c", NUMBER_TYPE, null); 
     JSType abcType = builder.build(); 
     List<JSType> typeChain = Lists.newArrayList(registry.getNativeType(JSTypeNative.ALL_TYPE), registry.getNativeType(JSTypeNative.OBJECT_PROTOTYPE), registry.getNativeType(JSTypeNative.OBJECT_TYPE), aType, abOrAcType, abType, abcType, registry.getNativeType(JSTypeNative.NO_OBJECT_TYPE), registry.getNativeType(JSTypeNative.NO_TYPE)); 
     verifySubtypeChain(typeChain); 
 }


public void testSymmetryOfLeastSupertype291() { 
     List<JSType> listA = getTypesToTestForSymmetry(); 
     List<JSType> listB = getTypesToTestForSymmetry(); 
     for (JSType typeA : listA) { 
         for (JSType typeB : listB) { 
             JSType aOnB = typeA.getLeastSupertype(typeB); 
             JSType bOnA = typeB.getLeastSupertype(typeA); 
             assertTrue(String.format("getLeastSupertype not symmetrical:\n" + "typeA: %s\ntypeB: %s\n" + "a.getLeastSupertype(b): %s\n" + "b.getLeastSupertype(a): %s\n", typeA, typeB, aOnB, bOnA), aOnB.isEquivalentTo(bOnA)); 
         } 
     } 
 }


public void testGreatestSubtypeSimpleTypes292() { 
     assertTypeEquals(ARRAY_TYPE, ARRAY_TYPE.getGreatestSubtype(ALL_TYPE)); 
     assertTypeEquals(ARRAY_TYPE, ALL_TYPE.getGreatestSubtype(ARRAY_TYPE)); 
     assertTypeEquals(NO_OBJECT_TYPE, REGEXP_TYPE.getGreatestSubtype(NO_OBJECT_TYPE)); 
     assertTypeEquals(NO_OBJECT_TYPE, NO_OBJECT_TYPE.getGreatestSubtype(REGEXP_TYPE)); 
     assertTypeEquals(NO_OBJECT_TYPE, ARRAY_TYPE.getGreatestSubtype(STRING_OBJECT_TYPE)); 
     assertTypeEquals(NO_TYPE, ARRAY_TYPE.getGreatestSubtype(NUMBER_TYPE)); 
     assertTypeEquals(NO_OBJECT_TYPE, ARRAY_TYPE.getGreatestSubtype(functionType)); 
     assertTypeEquals(STRING_OBJECT_TYPE, STRING_OBJECT_TYPE.getGreatestSubtype(OBJECT_TYPE)); 
     assertTypeEquals(STRING_OBJECT_TYPE, OBJECT_TYPE.getGreatestSubtype(STRING_OBJECT_TYPE)); 
     assertTypeEquals(NO_OBJECT_TYPE, ARRAY_TYPE.getGreatestSubtype(DATE_TYPE)); 
     assertTypeEquals(NO_OBJECT_TYPE, ARRAY_TYPE.getGreatestSubtype(REGEXP_TYPE)); 
     assertTypeEquals(EVAL_ERROR_TYPE, ERROR_TYPE.getGreatestSubtype(EVAL_ERROR_TYPE)); 
     assertTypeEquals(EVAL_ERROR_TYPE, EVAL_ERROR_TYPE.getGreatestSubtype(ERROR_TYPE)); 
     assertTypeEquals(NO_TYPE, NULL_TYPE.getGreatestSubtype(UNKNOWN_TYPE)); 
     assertTypeEquals(UNKNOWN_TYPE, NUMBER_TYPE.getGreatestSubtype(UNKNOWN_TYPE)); 
     assertTypeEquals(NO_RESOLVED_TYPE, NO_OBJECT_TYPE.getGreatestSubtype(forwardDeclaredNamedType)); 
     assertTypeEquals(NO_


public void testUnionTypes293() { 
     assertTypeEquals(ARRAY_TYPE, ARRAY_TYPE.getGreatestSubtype(ALL_TYPE)); 
     assertTypeEquals(ARRAY_TYPE, ALL_TYPE.getGreatestSubtype(ARRAY_TYPE)); 
     assertTypeEquals(NO_OBJECT_TYPE, REGEXP_TYPE.getGreatestSubtype(NO_OBJECT_TYPE)); 
     assertTypeEquals(NO_OBJECT_TYPE, NO_OBJECT_TYPE.getGreatestSubtype(REGEXP_TYPE)); 
     assertTypeEquals(NO_OBJECT_TYPE, ARRAY_TYPE.getGreatestSubtype(STRING_OBJECT_TYPE)); 
     assertTypeEquals(NO_TYPE, ARRAY_TYPE.getGreatestSubtype(NUMBER_TYPE)); 
     assertTypeEquals(NO_OBJECT_TYPE, ARRAY_TYPE.getGreatestSubtype(functionType)); 
     assertTypeEquals(STRING_OBJECT_TYPE, STRING_OBJECT_TYPE.getGreatestSubtype(OBJECT_TYPE)); 
     assertTypeEquals(STRING_OBJECT_TYPE, OBJECT_TYPE.getGreatestSubtype(STRING_OBJECT_TYPE)); 
     assertTypeEquals(NO_OBJECT_TYPE, ARRAY_TYPE.getGreatestSubtype(DATE_TYPE)); 
     assertTypeEquals(NO_OBJECT_TYPE, ARRAY_TYPE.getGreatestSubtype(REGEXP_TYPE)); 
     assertTypeEquals(EVAL_ERROR_TYPE, ERROR_TYPE.getGreatestSubtype(EVAL_ERROR_TYPE)); 
     assertTypeEquals(EVAL_ERROR_TYPE, EVAL_ERROR_TYPE.getGreatestSubtype(ERROR_TYPE)); 
     assertTypeEquals(NO_TYPE, NULL_TYPE.getGreatestSubtype(ERROR_TYPE)); 
     assertTypeEquals(UNKNOWN_TYPE, NUMBER_TYPE.getGreatestSubtype(UNKNOWN_TYPE)); 
     assertTypeEquals(NO_RESOLVED_TYPE, NO_OBJECT_TYPE.getGreatestSubtype(forwardDeclaredNamedType)); 
     assertTypeEquals(NO_


public void testInvalidTemplatizedType347() throws Exception { 
     FunctionType templatizedCtor = registry.createConstructorType("TestingType", null, null, UNKNOWN_TYPE, ImmutableList.of("A", "B")); 
     boolean exceptionThrown = false; 
     try { 
         JSType templatizedInstance = registry.createTemplatizedType(templatizedCtor.getInstanceType(), ImmutableList.of(NUMBER_TYPE, STRING_TYPE, BOOLEAN_TYPE)); 
     } catch (IllegalArgumentException e) { 
         exceptionThrown = true; 
     } 
     assertTrue(exceptionThrown); 
 }


public void testGetDeclaredTypeInNamespace348() { 
     JSTypeRegistry typeRegistry = new JSTypeRegistry(null); 
     JSType type = typeRegistry.createAnonymousObjectType(null); 
     String name = "a.b.Foo"; 
     typeRegistry.declareType(name, type); 
     assertTypeEquals(type, typeRegistry.getType(name)); 
     assertTrue(typeRegistry.hasNamespace("a")); 
     assertTrue(typeRegistry.hasNamespace("a.b")); 
 }

  

  /**
   * Tests the behavior of the Bottom Object type.
   */
  

  /**
   * Tests the behavior of the Bottom type.
   */
  

  /**
   * Tests the behavior of the unresolved Bottom type.
   */
  

  /**
   * Tests the behavior of the Array type.
   */
  

  /**
   * Tests the behavior of the unknown type.
   */
  

  /**
   * Tests the behavior of the checked unknown type.
   */
  

  /**
   * Tests the behavior of the unknown type.
   */
  

  /**
   * Tests the behavior of the Object type (the object
   * at the top of the JavaScript hierarchy).
   */
  

  /**
   * Tests the behavior of the number value type.
   */
  

  /**
   * Tests the behavior of the number value type.
   */
  

  /**
   * Tests the behavior of the null type.
   */
  

  /**
   * Tests the behavior of the Date type.
   */
  

  /**
   * Tests the behavior of the RegExp type.
   */
  

  /**
   * Tests the behavior of the string object type.
   */
  

  /**
   * Tests the behavior of the string value type.
   */
  

  private void assertPropertyTypeDeclared(ObjectType ownerType, String prop) {
    assertTrue(ownerType.isPropertyTypeDeclared(prop));
    assertFalse(ownerType.isPropertyTypeInferred(prop));
  }

  private void assertPropertyTypeInferred(ObjectType ownerType, String prop) {
    assertFalse(ownerType.isPropertyTypeDeclared(prop));
    assertTrue(ownerType.isPropertyTypeInferred(prop));
  }

  private void assertPropertyTypeUnknown(ObjectType ownerType, String prop) {
    assertFalse(ownerType.isPropertyTypeDeclared(prop));
    assertFalse(ownerType.isPropertyTypeInferred(prop));
    assertTrue(ownerType.getPropertyType(prop).isUnknownType());
  }

  private void assertReturnTypeEquals(JSType expectedReturnType,
      JSType function) {
    assertTrue(function instanceof FunctionType);
    assertTypeEquals(expectedReturnType,
        ((FunctionType) function).getReturnType());
  }


  /**
   * Tests the behavior of record types.
   */
  

  /**
   * Tests the behavior of the instance of Function.
   */
  

  /**
   * Tests the behavior of functional types.
   */
  

  /**
   * Tests the subtyping relation of record types.
   */
  

  /**
   * Tests the subtyping relation of record types when an object has
   * an inferred property..
   */
  

  /**
   * Tests the getLeastSupertype method for record types.
   */
  

  

  

  

  /**
   * Tests the getGreatestSubtype method for record types.
   */
  

  

  

  

  

  

  
  

  /**
   * Tests the "apply" method on the function type.
   */
  

  /**
   * Tests the "call" method on the function type.
   */
  

  /**
   * Tests the representation of function types.
   */
  

  /**
   * Tests relationships between structural function types.
   */
  

  

  /**
   * Tests relationships between structural function types.
   */
  

  /**
   * Tests that defining a property of a function's {@code prototype} adds the
   * property to it instance type.
   */
  

  /**
   * Tests that replacing a function's {@code prototype} changes the visible
   * properties of its instance type.
   */
  

  /** Tests assigning JsDoc on a prototype property. */
  

  /**
   * Tests the behavior of the void type.
   */
  

  /**
   * Tests the behavior of the boolean type.
   */
  

  /**
   * Tests the behavior of the Boolean type.
   */
  

  /**
   * Tests the behavior of the enum type.
   */
  

  /**
   * Tests the behavior of the enum element type.
   */
  

  

  


  /**
   * Tests object types.
   */
  

  /**
   * Tests the goog.Bar type.
   */
  

  /**
   * Tests how properties are counted for object types.
   */
  

  /**
   * Tests how properties are defined.
   */
  

  /**
   * Tests that properties are correctly counted even when shadowing occurs.
   */
  

  /**
   * Tests the named type goog.Bar.
   */
  

  /**
   * Tests the prototype chaining of native objects.
   */
  

  /**
   * Tests that function instances have their constructor pointer back at the
   * function that created them.
   */
  

  /**
   * Tests that the method {@link JSType#canTestForEqualityWith(JSType)} handles
   * special corner cases.
   */
  

  /**
   * Tests the {@link JSType#testForEquality(JSType)} method.
   */
  

  private void compare(TernaryValue r, JSType t1, JSType t2) {
    assertEquals(r, t1.testForEquality(t2));
    assertEquals(r, t2.testForEquality(t1));
  }

  

  

  /**
   * Tests the subtyping relationships among simple types.
   */
  

  /**
   * Tests that the Object type is the greatest element (top) of the object
   * hierarchy.
   */
  

  

  

  

  

  

  

  

  /**
   * Types to test for symmetrical relationships.
   */
  

  

  /**
   * Tests that getLeastSupertype is a symmetric relation.
   */
  

  

  /**
   * Tests that getGreatestSubtype is a symmetric relation.
   */
  

  /**
   * Tests that getLeastSupertype is a reflexive relation.
   */
  

  /**
   * Tests that getGreatestSubtype is a reflexive relation.
   */
  

  /**
   * Tests {@link JSType#getLeastSupertype(JSType)} for unresolved named types.
   */
  

  

  

  /** Tests the subclass of an unresolved named type */
  

  /**
   * Tests that Proxied FunctionTypes behave the same over getLeastSupertype and
   * getGreatestSubtype as non proxied FunctionTypes
   */
  

  

  /**
   * Tests the {@link NamedType#equals} function, which had a bug in it.
   */
  

  /**
   * Tests the {@link NamedType#equals} function against other types.
   */
  

  /**
   * Tests the {@link NamedType#equals} function against other types
   * when it's forward-declared.
   */
  

  

  /**
   * Tests {@link JSType#getGreatestSubtype(JSType)} on simple types.
   */
  

  /**
   * Tests that a derived class extending a type via a named type is a subtype
   * of it.
   */
  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  /**
   * Tests that the given chain of types has a total ordering defined
   * by the subtype relationship, with types at the top of the lattice
   * listed first.
   *
   * Also verifies that the infimum of any two types on the chain
   * is the lower type, and the supremum of any two types on the chain
   * is the higher type.
   */
  public void verifySubtypeChain(List<JSType> typeChain) throws Exception {
    verifySubtypeChain(typeChain, true);
  }

  public void verifySubtypeChain(List<JSType> typeChain,
                                 boolean checkSubtyping) throws Exception {
    // Ugh. This wouldn't require so much copy-and-paste if we had a functional
    // programming language.
    for (int i = 0; i < typeChain.size(); i++) {
      for (int j = 0; j < typeChain.size(); j++) {
        JSType typeI = typeChain.get(i);
        JSType typeJ = typeChain.get(j);

        JSType namedTypeI = getNamedWrapper("TypeI", typeI);
        JSType namedTypeJ = getNamedWrapper("TypeJ", typeJ);
        JSType proxyTypeI = new ProxyObjectType(registry, typeI);
        JSType proxyTypeJ = new ProxyObjectType(registry, typeJ);

        if (i == j) {
          assertTrue(typeI + " should equal itself",
              typeI.isEquivalentTo(typeI));
          assertTrue("Named " + typeI + " should equal itself",
              namedTypeI.isEquivalentTo(namedTypeI));
          assertTrue("Proxy " + typeI + " should equal itself",
              proxyTypeI.isEquivalentTo(proxyTypeI));
        } else {
          assertFalse(typeI + " should not equal " + typeJ,
              typeI.isEquivalentTo(typeJ));
          assertFalse("Named " + typeI + " should not equal " + typeJ,
              namedTypeI.isEquivalentTo(namedTypeJ));
          assertFalse("Proxy " + typeI + " should not equal " + typeJ,
              proxyTypeI.isEquivalentTo(proxyTypeJ));
        }

        assertTrue(typeJ + " should be castable to " + typeI,
            typeJ.canCastTo(typeI));
        assertTrue(typeJ + " should be castable to Named " + namedTypeI,
            typeJ.canCastTo(namedTypeI));
        assertTrue(typeJ + " should be castable to Proxy " + proxyTypeI,
            typeJ.canCastTo(proxyTypeI));

        assertTrue(
            "Named " + typeJ + " should be castable to " + typeI,
            namedTypeJ.canCastTo(typeI));
        assertTrue(
            "Named " + typeJ + " should be castable to Named " + typeI,
            namedTypeJ.canCastTo(namedTypeI));
        assertTrue(
            "Named " + typeJ + " should be castable to Proxy " + typeI,
            namedTypeJ.canCastTo(proxyTypeI));

        assertTrue(
            "Proxy " + typeJ + " should be castable to " + typeI,
            proxyTypeJ.canCastTo(typeI));
        assertTrue(
            "Proxy " + typeJ + " should be castable to Named " + typeI,
            proxyTypeJ.canCastTo(namedTypeI));
        assertTrue(
            "Proxy " + typeJ + " should be castable to Proxy " + typeI,
            proxyTypeJ.canCastTo(proxyTypeI));

        if (checkSubtyping) {
          if (i <= j) {
            assertTrue(typeJ + " should be a subtype of " + typeI,
                typeJ.isSubtype(typeI));
            assertTrue(
                "Named " + typeJ + " should be a subtype of Named " + typeI,
                namedTypeJ.isSubtype(namedTypeI));
            assertTrue(
                "Proxy " + typeJ + " should be a subtype of Proxy " + typeI,
                proxyTypeJ.isSubtype(proxyTypeI));
          } else {
            assertFalse(typeJ + " should not be a subtype of " + typeI,
                typeJ.isSubtype(typeI));
            assertFalse(
                "Named " + typeJ + " should not be a subtype of Named " + typeI,
                namedTypeJ.isSubtype(namedTypeI));
            assertFalse(
                "Named " + typeJ + " should not be a subtype of Named " + typeI,
                proxyTypeJ.isSubtype(proxyTypeI));
          }

          JSType expectedSupremum = i < j ? typeI : typeJ;
          JSType expectedInfimum = i > j ? typeI : typeJ;

          assertTypeEquals(
              expectedSupremum + " should be the least supertype of " + typeI +
              " and " + typeJ,
              expectedSupremum, typeI.getLeastSupertype(typeJ));

          // TODO(nicksantos): Should these tests pass?
          //assertTypeEquals(
          //    expectedSupremum + " should be the least supertype of Named " +
          //    typeI + " and Named " + typeJ,
          //    expectedSupremum, namedTypeI.getLeastSupertype(namedTypeJ));
          //assertTypeEquals(
          //    expectedSupremum + " should be the least supertype of Proxy " +
          //    typeI + " and Proxy " + typeJ,
          //    expectedSupremum, proxyTypeI.getLeastSupertype(proxyTypeJ));

          assertTypeEquals(
              expectedInfimum + " should be the greatest subtype of " + typeI +
              " and " + typeJ,
              expectedInfimum, typeI.getGreatestSubtype(typeJ));

          // TODO(nicksantos): Should these tests pass?
          //assertTypeEquals(
          //    expectedInfimum + " should be the greatest subtype of Named " +
          //    typeI + " and Named " + typeJ,
          //    expectedInfimum, namedTypeI.getGreatestSubtype(namedTypeJ));
          //assertTypeEquals(
          //    expectedInfimum + " should be the greatest subtype of Proxy " +
          //    typeI + " and Proxy " + typeJ,
          //    expectedInfimum, proxyTypeI.getGreatestSubtype(proxyTypeJ));
        }
      }
    }
  }

  JSType getNamedWrapper(String name, JSType jstype) {
    // Normally, there is no way to create a Named NoType alias so
    // avoid confusing things by doing it here..
    if (!jstype.isNoType()) {
      NamedType namedWrapper = new NamedType(
          registry, name, "[testcode]", -1, -1);
      namedWrapper.setReferencedType(jstype);
      return namedWrapper;
    } else {
      return jstype;
    }
  }

  /**
   * Tests the behavior of
   * {@link JSType#getRestrictedTypeGivenToBooleanOutcome(boolean)}.
   */
  

  

  

  /**
   * Tests
   * {@link JSTypeRegistry#getGreatestSubtypeWithProperty(JSType, String)}.
   */
  

  

  

  

  

  

  

  

  

  

  

  

  

  

  


  /**
   * Tests the factory method
   * {@link JSTypeRegistry#createRecordType}.
   */
  

  /**
   * Tests the factory method {@link JSTypeRegistry#createOptionalType(JSType)}.
   */
  

  public void assertUnionContains(UnionType union, JSType type) {
    assertTrue(union + " should contain " + type, union.contains(type));
  }

  /**
   * Tests the factory method
   * {@link JSTypeRegistry#createAnonymousObjectType}}.
   */
  

  /**
   * Tests the factory method
   * {@link JSTypeRegistry#createAnonymousObjectType}} and adds
   * some properties to it.
   */
  

  /**
   * Tests the factory methods
   * {@link JSTypeRegistry#createObjectType(ObjectType)}} and
   * {@link JSTypeRegistry#createObjectType(String, Node, ObjectType)}}.
   */
  

  /**
   * Tests {@code (U2U_CONSTRUCTOR,undefined) <: (U2U_CONSTRUCTOR,undefined)}.
   */
  

  /**
   * Tests {@code U2U_FUNCTION_TYPE <: U2U_CONSTRUCTOR} and
   * {@code U2U_FUNCTION_TYPE <: (U2U_CONSTRUCTOR,undefined)}.
   */
  

  /**
   * Assert that a type can assign to itself.
   */
  private void assertTypeCanAssignToItself(JSType type) {
    assertTrue(type.isSubtype(type));
  }

  /**
   * Tests that hasOwnProperty returns true when a property is defined directly
   * on a class and false if the property is defined on the supertype or not at
   * all.
   */
  

  

  

  

  

  

  

  

  

  

  

  

  

  

  private static boolean containsType(
      Iterable<? extends JSType> types, JSType type) {
    for (JSType alt : types) {
      if (alt.isEquivalentTo(type)) {
        return true;
      }
    }
    return false;
  }

  private static boolean assertTypeListEquals(
      Iterable<? extends JSType> typeListA,
      Iterable<? extends JSType> typeListB) {
    for (JSType alt : typeListA) {
      assertTrue(
          "List : " + typeListA + "\n" +
          "does not contain: " + alt,
          containsType(typeListA, alt));
    }
    for (JSType alt : typeListB) {
      assertTrue(
          "List : " + typeListB + "\n" +
          "does not contain: " + alt,
          containsType(typeListB, alt));
    }
    return false;
  }

  private ArrowType createArrowType(Node params) {
    return registry.createArrowType(params);
  }
}
