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

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.google.javascript.jscomp.CheckLevel;
import com.google.javascript.jscomp.NodeTraversal.AbstractPostOrderCallback;
import static com.google.javascript.jscomp.PureFunctionIdentifier.INVALID_NO_SIDE_EFFECT_ANNOTATION;
import com.google.javascript.rhino.Node;
import java.util.List;

/**
 * Tests for {@link PureFunctionIdentifier}
 *
 */
public class PureFunctionIdentifierTest extends CompilerTestCase {
  List<String> noSideEffectCalls = Lists.newArrayList();
  List<String> localResultCalls = Lists.newArrayList();

  boolean regExpHaveSideEffects = true;

  private static String kExterns =
      CompilerTypeTestCase.DEFAULT_EXTERNS +
      "var window; window.setTimeout;" +
      "/**@nosideeffects*/ function externSENone(){}\n" +

      "/**@modifies{this}*/ function externSEThis(){}\n" +

      "/**@constructor\n" +
      " * @modifies{this}*/\n" +
      "function externObjSEThis(){}\n" +

      "/**\n" +
      " * @param {string} s id.\n" +
      " * @return {string}\n" +
      " * @modifies{this}\n" +
      " */\n" +
      "externObjSEThis.prototype.externObjSEThisMethod = function(s) {};" +

      "/**\n" +
      " * @param {string} s id.\n" +
      " * @return {string}\n" +
      " * @modifies{arguments}\n" +
      " */\n" +
      "externObjSEThis.prototype.externObjSEThisMethod2 = function(s) {};" +

      "/**@nosideeffects*/function Error(){}" +

      "function externSef1(){}" +

      "/**@nosideeffects*/function externNsef1(){}" +

      "var externSef2 = function(){};" +

      "/**@nosideeffects*/var externNsef2 = function(){};" +

      "var externNsef3 = /**@nosideeffects*/function(){};" +

      "var externObj;" +

      "externObj.sef1 = function(){};" +

      "/**@nosideeffects*/externObj.nsef1 = function(){};" +

      "externObj.nsef2 = /**@nosideeffects*/function(){};" +

      "externObj.partialFn;" +

      "externObj.partialSharedFn;" +

      "var externObj2;" +

      "externObj2.partialSharedFn = /**@nosideeffects*/function(){};" +

      "/**@constructor*/function externSefConstructor(){}" +

      "externSefConstructor.prototype.sefFnOfSefObj = function(){};" +

      "externSefConstructor.prototype.nsefFnOfSefObj = " +
      "  /**@nosideeffects*/function(){};" +

      "externSefConstructor.prototype.externShared = function(){};" +

      "/**@constructor\n@nosideeffects*/function externNsefConstructor(){}" +

      "externNsefConstructor.prototype.sefFnOfNsefObj = function(){};" +

      "externNsefConstructor.prototype.nsefFnOfNsefObj = " +
      "  /**@nosideeffects*/function(){};" +

      "externNsefConstructor.prototype.externShared = " +
      "  /**@nosideeffects*/function(){};" +

      "/**@constructor\n@nosideeffects*/function externNsefConstructor2(){}" +
      "externNsefConstructor2.prototype.externShared = " +
      "  /**@nosideeffects*/function(){};" +

      "externNsefConstructor.prototype.sharedPartialSef;" +
      "/**@nosideeffects*/externNsefConstructor.prototype.sharedPartialNsef;" +

      // An externs definition with a stub before.

      "/**@constructor*/function externObj3(){}" +

      "externObj3.prototype.propWithStubBefore;" +

      "/**\n" +
      " * @param {string} s id.\n" +
      " * @return {string}\n" +
      " * @nosideeffects\n" +
      " */\n" +
      "externObj3.prototype.propWithStubBefore = function(s) {};" +

      // useless JsDoc
      "/**\n" +
      " * @see {foo}\n" +
      " */\n" +
      "externObj3.prototype.propWithStubBeforeWithJSDoc;" +

      "/**\n" +
      " * @param {string} s id.\n" +
      " * @return {string}\n" +
      " * @nosideeffects\n" +
      " */\n" +
      "externObj3.prototype.propWithStubBeforeWithJSDoc = function(s) {};" +

      // An externs definition with a stub after.

      "/**@constructor*/function externObj4(){}" +

      "/**\n" +
      " * @param {string} s id.\n" +
      " * @return {string}\n" +
      " * @nosideeffects\n" +
      " */\n" +
      "externObj4.prototype.propWithStubAfter = function(s) {};" +

      "externObj4.prototype.propWithStubAfter;" +

      "/**\n" +
      " * @param {string} s id.\n" +
      " * @return {string}\n" +
      " * @nosideeffects\n" +
      " */\n" +
      "externObj4.prototype.propWithStubAfterWithJSDoc = function(s) {};" +

      // useless JsDoc
      "/**\n" +
      " * @see {foo}\n" +
      " */\n" +
      "externObj4.prototype.propWithStubAfterWithJSDoc;";

  public PureFunctionIdentifierTest() {
    super(kExterns);
    enableTypeCheck(CheckLevel.ERROR);
  }

  @Override
  protected int getNumRepetitions() {
    // run pass once.
    return 1;
  }

  @Override
  protected void tearDown() throws Exception {
    super.tearDown();
    noSideEffectCalls.clear();
    localResultCalls.clear();
    boolean regExpHaveSideEffects = true;
  }


public void testConstructorThatModifiesThis322() throws Exception { 
     String source = "/**@constructor*/function A(){this.foo()}\n" + "A.prototype.foo = function(){this.bar()};\n" + "A.prototype.bar = function(){this.data=24};\n" + "function f() {return new A}" + "f()"; 
     checkMarkedCalls(source, ImmutableList.of("A", "f")); 
 }


public void testIssue303179() throws Exception { 
     checkMarkedCalls("/** @constructor */ function F() {" + "  var self = this;" + "  window.setTimeout(function() {" + "    window.location = self.location;" + "  }, 0);" + "}" + "F.prototype.setLocation = function(x) {" + "  this.location = x;" + "};" + "(new F()).setLocation('http://www.google.com/');", ImmutableList.<String>of()); 
 }


public void testIssue538180() { 
     checkCompilesToSame("/** @constructor */\n" + "WebInspector.Setting = function() {}\n" + "WebInspector.Setting.prototype = {\n" + "    get name0(){return this._name;},\n" + "    get name1(){return this._name;},\n" + "    get name2(){return this._name;},\n" + "    get name3(){return this._name;},\n" + "    get name4(){return this._name;},\n" + "    get name5(){return this._name;},\n" + "    get name6(){return this._name;},\n" + "    get name7(){return this._name;},\n" + "    get name8(){return this._name;},\n" + "    get name9(){return this._name;},\n" + "}", 1); 
 }


public void testCallFunctionFOrGViaHook181() throws Exception { 
     String source = "function f(){}\n" + "function g(){}\n" + "function h(){ (false ? f : g)() }\n" + "h()"; 
     checkMarkedCalls(source, ImmutableList.<String>of("(f : g)", "h")); 
 }


public void testIssue504182() { 
     args.add("--compilation_level=ADVANCED_OPTIMIZATIONS"); 
     test("void function() { alert('hi'); }();", "alert('hi');void 0", CheckSideEffects.USELESS_CODE_ERROR); 
 }


public void testRegExp1183() { 
     CompilerOptions options = createCompilerOptions(); 
     options.foldConstants = true; 
     String code = "/(a)/.test(\"a\");"; 
     testSame(options, code); 
     options.computeFunctionSideEffects = true; 
     String expected = ""; 
     test(options, code, expected); 
 }


public void testLocalValue1184() throws Exception { 
     assertFalse(testLocalValue("x")); 
     assertFalse(testLocalValue("x()")); 
     assertFalse(testLocalValue("this")); 
     assertFalse(testLocalValue("arguments")); 
     assertFalse(testLocalValue("new x()")); 
     assertFalse(testLocalValue("(new x()).y")); 
     assertFalse(testLocalValue("(new x())['y']")); 
     assertTrue(testLocalValue("null")); 
     assertTrue(testLocalValue("undefined")); 
     assertTrue(testLocalValue("Infinity")); 
     assertTrue(testLocalValue("NaN")); 
     assertTrue(testLocalValue("1")); 
     assertTrue(testLocalValue("'a'")); 
     assertTrue(testLocalValue("true")); 
     assertTrue(testLocalValue("false")); 
     assertTrue(testLocalValue("[]")); 
     assertTrue(testLocalValue("{}")); 
     assertTrue(testLocalValue("[x]")); 
     assertTrue(testLocalValue("{'a':x}")); 
     assertTrue(testLocalValue("++x")); 
     assertTrue(testLocalValue("--x")); 
     assertFalse(testLocalValue("x++")); 
     assertFalse(testLocalValue("x--")); 
     assertTrue(testLocalValue("x=1")); 
     assertFalse(testLocalValue("x=[]")); 
     assertFalse(testLocalValue("x=y")); 
     assertTrue(testLocalValue("x+=y")); 
     assertTrue(testLocalValue("x*=y")); 
     assertTrue(testLocalValue("x==y")); 
     assertTrue(testLocalValue("x!=y")); 
     assertTrue(testLocalValue("x>y")); 
     assertTrue(testLocalValue("(1,

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  // Indirect complex function definitions aren't yet supported.
  

  

  

  

  

  

  void checkMarkedCalls(String source, List<String> expected) {
    testSame(source);
    assertEquals(expected, noSideEffectCalls);
    noSideEffectCalls.clear();
  }

  void checkLocalityOfMarkedCalls(String source, List<String> expected) {
    testSame(source);
    assertEquals(expected, localResultCalls);
    localResultCalls.clear();
  }

  @Override
  protected CompilerPass getProcessor(Compiler compiler) {
    return new NoSideEffectCallEnumerator(compiler);
  }

  /**
   * Run PureFunctionIdentifier, then gather a list of calls that are
   * marked as having no side effects.
   */
  private class NoSideEffectCallEnumerator
      extends AbstractPostOrderCallback implements CompilerPass {
    private final Compiler compiler;

    NoSideEffectCallEnumerator(Compiler compiler) {
      this.compiler = compiler;
    }

    @Override
    public void process(Node externs, Node root) {
      compiler.setHasRegExpGlobalReferences(regExpHaveSideEffects);
      SimpleDefinitionFinder defFinder = new SimpleDefinitionFinder(compiler);
      defFinder.process(externs, root);
      PureFunctionIdentifier passUnderTest =
          new PureFunctionIdentifier(compiler, defFinder);
      passUnderTest.process(externs, root);

      // Ensure that debug report computation works.
      String debugReport = passUnderTest.getDebugReport();

      NodeTraversal.traverse(compiler, externs, this);
      NodeTraversal.traverse(compiler, root, this);
    }

    @Override
    public void visit(NodeTraversal t, Node n, Node parent) {
      if (n.isNew()) {
        if (!NodeUtil.constructorCallHasSideEffects(n)) {
          noSideEffectCalls.add(generateNameString(n.getFirstChild()));
        }
      } else if (n.isCall()) {
        if (!NodeUtil.functionCallHasSideEffects(n)) {
          noSideEffectCalls.add(generateNameString(n.getFirstChild()));
        }
        if (NodeUtil.callHasLocalResult(n)) {
          localResultCalls.add(generateNameString(n.getFirstChild()));
        }
      }
    }

    private String generateNameString(Node node) {
      if (node.isOr()) {
        return "(" + generateNameString(node.getFirstChild()) +
            " || " + generateNameString(node.getLastChild()) + ")";
      } else if (node.isHook()) {
        return "(" + generateNameString(node.getFirstChild().getNext()) +
            " : " + generateNameString(node.getLastChild()) + ")";
      } else {
        String result = node.getQualifiedName();
        if (result == null) {
          if (node.isFunction()) {
            result = node.toString(false, false, false).trim();
          } else {
            result = node.getFirstChild().toString(false, false, false);
            result += " " + node.getLastChild().toString(false, false, false);
          }
        }
        return result;
      }
    }
  }
}
