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
import com.google.javascript.jscomp.NodeTraversal.AbstractPostOrderCallback;
import com.google.javascript.jscomp.NodeTraversal.Callback;
import com.google.javascript.rhino.Node;
import com.google.javascript.rhino.jstype.FunctionType;
import com.google.javascript.rhino.jstype.JSType;
import com.google.javascript.rhino.jstype.ObjectType;

import java.util.Deque;


/**
 * Tests for {@link InferJSDocInfo}.
 * @author nicksantos@google.com (Nick Santos)
 */
// TODO(nicksantos): A lot of this code is duplicated from
// TypedScopeCreatorTest. We should create a common test harness for
// assertions about type information.
public class InferJSDocInfoTest extends CompilerTestCase {

  private Scope globalScope;

  @Override
  public int getNumRepetitions() {
    return 1;
  }

  @Override
  protected CompilerOptions getOptions() {
    CompilerOptions options = super.getOptions();
    options.ideMode = true;
    return options;
  }

  private final Callback callback = new AbstractPostOrderCallback() {
    @Override
    public void visit(NodeTraversal t, Node n, Node parent) {
      Scope s = t.getScope();
      if (s.isGlobal()) {
        globalScope = s;
      }
    }
  };

  @Override
  public CompilerPass getProcessor(final Compiler compiler) {
    return new CompilerPass() {
      @Override
      public void process(Node externs, Node root) {
        MemoizedScopeCreator scopeCreator =
            new MemoizedScopeCreator(new TypedScopeCreator(compiler));
        Scope topScope = scopeCreator.createScope(root.getParent(), null);
        (new TypeInferencePass(
            compiler, compiler.getReverseAbstractInterpreter(),
            topScope, scopeCreator)).process(externs, root);
        NodeTraversal t = new NodeTraversal(
            compiler, callback, scopeCreator);
        t.traverseRoots(Lists.newArrayList(externs, root));
        (new InferJSDocInfo(compiler)).process(externs, root);
      }
    };
  }


public void testInferTypes385() throws Exception { 
     assertFalse(NO_OBJECT_TYPE.isArrayType()); 
     assertFalse(NO_OBJECT_TYPE.isBooleanValueType()); 
     assertFalse(NO_OBJECT_TYPE.isDateType()); 
     assertFalse(NO_OBJECT_TYPE.isEnumElementType()); 
     assertFalse(NO_OBJECT_TYPE.isNamedType()); 
     assertFalse(NO_OBJECT_TYPE.isNullType()); 
     assertFalse(NO_OBJECT_TYPE.isNumber()); 
     assertFalse(NO_OBJECT_TYPE.isNumberObjectType()); 
     assertFalse(NO_OBJECT_TYPE.isNumberValueType()); 
     assertFalse(NO_OBJECT_TYPE.isObject()); 
     assertFalse(NO_OBJECT_TYPE.isFunctionPrototypeType()); 
     assertFalse(NO_OBJECT_TYPE.isRegexpType()); 
     assertTrue(NO_OBJECT_TYPE.isString()); 
     assertFalse(NO_OBJECT_TYPE.isStringObjectType()); 
     assertFalse(NO_OBJECT_TYPE.isStringValueType()); 
     assertFalse(NO_OBJECT_TYPE.isEnumType()); 
     assertFalse(NO_OBJECT_TYPE.isUnionType()); 
     assertFalse(NO_OBJECT_TYPE.isStruct()); 
     assertFalse(NO_OBJECT_TYPE.isDict()); 
     assertFalse(NO_OBJECT_TYPE.isAllType()); 
     assertFalse(NO_OBJECT_TYPE.isVoidType()); 
     assertFalse(NO_OBJECT_TYPE.isConstructor()); 
     assertFalse(NO_OBJECT_TYPE.isInstanceType()); 
     assertTypeEquals(NO_OBJECT_TYPE, NO_OBJECT_TYPE.autoboxesTo()); 
     assertTypeEquals(NO_TYPE, NO_OBJECT_TYPE.unboxesTo()); 
     assertTrue(NO_OBJECT_TYPE.isSubtype(ALL_TYPE));


public void testBug1949424_v2386() { 
     CompilerOptions options = createCompilerOptions(); 
     options.collapseProperties = true; 
     options.closurePass = true; 
     test(options, CLOSURE_BOILERPLATE + "/** @const */\n" + "var goog = {};\n" + "/** @param {!Array.<T>} arr\n" + " * @param {function(this:S, !T, number, !Array.<T>):boolean} f\n" + " * @param {!S=} opt_obj\n" + " * @return {!Array.<T>}\n" + " * @template T,S\n" + " */\n" + "goog.array.filter = function(arr, f, opt_obj) {\n" + "  var res = [];\n" + "  for (var i = 0; i < arr.length; i++) {\n" + "     if (f.call(opt_obj, arr[i], i, arr)) {\n" + "        res.push(val);\n" + "     }\n" + "  }\n" + "  return res;\n" + "}" + "/** @constructor */\n" + "function Foo() {}\n" + "/** @type {Array.<string>} */\n" + "var arr = [];\n" + "var result = goog.array.filter(arr," + "  function(a,b,c) {var self=this;}, new Foo());"); 
     assertEquals("Foo", findNameType("self", lastLocalScope).toString()); 
     assertEquals("string", findNameType("a", lastLocalScope).toString()); 
     assertEquals("number", findNameType("b", lastLocalScope).toString()); 
     assertEquals("Array.<string>", findNameType("c", lastLocalScope).toString()); 
     assertEquals("Array.<string>", findNameType("result", globalScope).toString()); 
 }


public void testInferJSDocInfo387() throws Exception { 
     CompilerOptions options = createCompilerOptions(); 
     CompilationLevel level = CompilationLevel.SIMPLE_OPTIMIZATIONS; 
     level.setOptionsForCompilationLevel(options); 
     level.setTypeBasedOptimizationOptions(options); 
     WarningLevel warnings = WarningLevel.DEFAULT; 
     warnings.setOptionsForWarningLevel(options); 
     String code = "" + "var ns = {};\n" + "/** @constructor */\n" + "ns.C = function () {this.someProperty = 1}\n" + "alert(new ns.C().someProperty + new ns.C().someProperty);\n"; 
     assertTrue(options.inlineProperties); 
     assertTrue(options.collapseProperties); 
     test(options, code, "alert(2);"); 
 }


public void testInferTypes388() throws Exception { 
     assertFalse(NO_OBJECT_TYPE.isArrayType()); 
     assertFalse(NO_OBJECT_TYPE.isBooleanValueType()); 
     assertFalse(NO_OBJECT_TYPE.isDateType()); 
     assertFalse(NO_OBJECT_TYPE.isEnumElementType()); 
     assertFalse(NO_OBJECT_TYPE.isNamedType()); 
     assertFalse(NO_OBJECT_TYPE.isNullType()); 
     assertFalse(NO_OBJECT_TYPE.isNumber()); 
     assertFalse(NO_OBJECT_TYPE.isNumberObjectType()); 
     assertFalse(NO_OBJECT_TYPE.isNumberValueType()); 
     assertFalse(NO_OBJECT_TYPE.isObject()); 
     assertFalse(NO_OBJECT_TYPE.isFunctionPrototypeType()); 
     assertFalse(NO_OBJECT_TYPE.isRegexpType()); 
     assertTrue(NO_OBJECT_TYPE.isString()); 
     assertFalse(NO_OBJECT_TYPE.isStringObjectType()); 
     assertFalse(NO_OBJECT_TYPE.isStringValueType()); 
     assertFalse(NO_OBJECT_TYPE.isEnumType()); 
     assertFalse(NO_OBJECT_TYPE.isUnionType()); 
     assertFalse(NO_OBJECT_TYPE.isStruct()); 
     assertFalse(NO_OBJECT_TYPE.isDict()); 
     assertFalse(NO_OBJECT_TYPE.isAllType()); 
     assertFalse(NO_OBJECT_TYPE.isVoidType()); 
     assertFalse(NO_OBJECT_TYPE.isConstructor()); 
     assertFalse(NO_OBJECT_TYPE.isInstanceType()); 
     assertFalse(NO_OBJECT_TYPE.isSubtype(NO_TYPE)); 
     assertTrue(NO_OBJECT_TYPE.isSubtype(NO_OBJECT_TYPE)); 
     assertTrue(NO_OBJECT


public void testCallFunctionWithArgs389() { 
     testSame("/** @constructor */ function Foo(o) { this.a = o; }\n" + "/** @constructor \n @extends Foo */ function Bar() {\n" + "  Foo.call(this, new A());\n" + "}\n" + "/** @constructor */ function A() {};\n" + "var b = new Bar;"); 
     assertTrue(isCalled(getType("Foo"))); 
     assertTrue(isCalled(getType("A"))); 
     ConcreteType barType = getThisType(getType("Bar")); 
     assertType("A", getPropertyType(barType, "a")); 
     ConcreteType fooType = getThisType(getType("Foo")); 
     assertType("A", getPropertyType(fooType, "a")); 
 }

  

  

  

  

  

  

  private JSType findGlobalNameType(String name) {
    return findNameType(name, globalScope);
  }

  private JSType findNameType(String name, Scope scope) {
    Node root = scope.getRootNode();
    Deque<Node> queue = Lists.newLinkedList();
    queue.push(root);
    while (!queue.isEmpty()) {
      Node current = queue.pop();
      if (name.equals(current.getQualifiedName()) &&
          current.getJSType() != null) {
        return current.getJSType();
      }

      for (Node child : current.children()) {
        queue.push(child);
      }
    }
    return null;
  }
}
