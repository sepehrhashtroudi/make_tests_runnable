/*
 * Copyright 2008 The Closure Compiler Authors.
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

import com.google.javascript.jscomp.ConcreteType.ConcreteFunctionType;
import com.google.javascript.jscomp.ConcreteType.ConcreteInstanceType;
import com.google.javascript.jscomp.CheckLevel;
import com.google.javascript.jscomp.TightenTypes.ConcreteSlot;

import com.google.javascript.rhino.testing.BaseJSTypeTestCase;

/**
 * Unit test for the TightenTypes pass.
 *
 */
public class TightenTypesTest extends CompilerTestCase {
  private TightenTypes tt;

  public TightenTypesTest() {
    parseTypeInfo = true;
    enableTypeCheck(CheckLevel.WARNING);
    enableNormalize(true);
  }

  @Override
  public CompilerPass getProcessor(Compiler compiler) {
    return (tt = new TightenTypes(compiler));
  }

  @Override
  protected int getNumRepetitions() {
    return 1;
  }

  @Override
  protected CompilerOptions getOptions() {
    return new CompilerOptions(); // no missing properties check
  }

public void testSubclass137() { 
     testSame("" + "/** @constructor */ function Foo() {}\n" + "Foo.prototype.bar = function() { return this; };\n" + "/** @constructor\n@extends {Foo} */ function Baz() {}\n" + "Baz.prototype.bar = function() {};\n" + "(/** @type {Foo} */ new Baz()).bar();\n" + "(/** @type {Foo} */ new Baz()).bar();\n"); 
 }
public void testSetTimeout595() { 
     testSame("/** @constructor */ function Window() {};\n" + "Window.prototype.setTimeout = function(f, t) {};\n" + "/** @type Window */ var window;", "/** @constructor*/ function A() {}\n" + "A.prototype.handle = function() { foo(); };\n" + "function foo() {}\n" + "window.setTimeout((new A).handle, 3);", null); 
     assertTrue(isCalled(getType("foo"))); 
 }
public void testImplicitCallFromPropertyOfUnion596() { 
     testSame("/** @constructor */ function Element() {};\n" + "/** @type {function(this:Element,Event)} */\n" + "Element.prototype.onclick;\n" + "/** @constructor */ function Event() {};", "function foo(evt) {};\n" + "(new Element).onclick = foo;", null); 
     assertTrue(isCalled(getType("foo"))); 
     assertType("Event", getParamType(getType("foo"), 0)); 
     assertType("Element", getThisType(getType("foo").toFunction())); 
 }
public void testImplicitCallFromPropertyOfAllType597() { 
     testSame("/** @constructor */ function Element() {};\n" + "/** @type {function(this:Element,Event)} */\n" + "Element.prototype.onclick;\n" + "/** @constructor */ function Event() {};", "function foo(evt) {};\n" + "var elems = [];\n" + "var elem = elems[0];\n" + "elem.onclick = foo;", null); 
     assertTrue(isCalled(getType("foo"))); 
     assertType("Event", getParamType(getType("foo"), 0)); 
     assertType("Element", getThisType(getType("foo").toFunction())); 
 }
public void testCallPrototypeFunction598() { 
     testSame("/** @constructor */ function Foo() {}\n" + "Foo.prototype.a = function() { return new A; }\n" + "Foo.prototype.a = function() { return new A; };\n" + "/** @constructor \n @extends Foo */ function Bar() {}\n" + "/** @override */" + "Bar.prototype.a = function() { return new B; };\n" + "/** @constructor */ function A() {};\n" + "/** @constructor */ function B() {};\n" + "var ret = Foo.prototype.a.call(new Bar);"); 
     assertType("A", getType("ret")); 
 }
public void testRestrictToInterfaceCast599() { 
     testSame("/** @constructor \n @implements Int */ function Foo() {};\n" + "/** @interface */ function Int() {};\n" + "var a = [];\n" + "var foo = (/** @type {Int} */ a[0]);\n" + "new Foo"); 
     assertType("Foo", getType("foo")); 
 }
public void testGetElem3600() { 
     testSame(BaseJSTypeTestCase.ALL_NATIVE_EXTERN_TYPES, "/** @constructor */ function Foo() {}\n" + "/** @constructor */ function Bar() {}\n" + "/** @constructor */ function Baz() {\n" + "  this.arr = [];\n" + "}\n" + "function foo(anarr) {" + "}\n" + "var ar = [];\n" + "foo(ar);\n", null); 
     assertType("Array", getType("ar")); 
 }
  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  private void assertType(String expected, ConcreteType type) {
    assertEquals(expected, type.toString());
  }

  /** Returns the type of the given variable in the top-most scope. */
  private ConcreteType getType(String var) {
    assertNotNull(tt.getTopScope().getSlot(var));
    return tt.getTopScope().getSlot(var).getType();
  }

  /** Returns the variable for the given parameter of the given function. */
  private ConcreteSlot getParamVar(ConcreteType funType, int param) {
    assertTrue(funType.isFunction());
    return (ConcreteSlot)
        ((ConcreteFunctionType) funType).getParameterSlot(param);
  }

  /** Returns the type of the given parameter of the given function. */
  private ConcreteType getParamType(ConcreteType funType, int param) {
    ConcreteSlot paramVar = getParamVar(funType, param);
    return (paramVar != null) ? paramVar.getType() : ConcreteType.NONE;
  }

  /** Returns the variable for the this variable of the given function. */
  private ConcreteSlot getThisSlot(ConcreteType funType) {
    assertTrue(funType.isFunction());
    return (ConcreteSlot) ((ConcreteFunctionType) funType).getThisSlot();
  }

  /** Returns the type of the this variable of the given function. */
  private ConcreteType getThisType(ConcreteType funType) {
    return getThisSlot(funType).getType();
  }

  /** Returns the prototype type of the given function. */
  private ConcreteType getFunctionPrototype(ConcreteType funType) {
    assertTrue(funType.isFunction());
    return ((ConcreteFunctionType) funType).getPrototypeType();
  }

  /**
   * Returns the variable for the property with the give name on the given
   * instance type.
   */
  private ConcreteSlot getPropertyVar(ConcreteType instType, String name) {
    assertTrue(instType.isInstance());
    return (ConcreteSlot)
        ((ConcreteInstanceType) instType).getPropertySlot(name);
  }

  /** Returns the type of the property with the give name on the given type. */
  private ConcreteType getPropertyType(ConcreteType instType, String name) {
    return getPropertyVar(instType, name).getType();
  }

  /** Returns whether the given function is called. */
  private boolean isCalled(ConcreteType funType) {
    assertTrue(funType.isFunction());
    ConcreteSlot callVar = (ConcreteSlot)
        ((ConcreteFunctionType) funType).getCallSlot();
    return !callVar.getType().isNone();
  }
}
