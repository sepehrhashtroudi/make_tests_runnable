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

import com.google.javascript.rhino.Node;

/**
 * Unit tests for {@link FlowSensitiveInlineVariables}.
 *
 */
public class FlowSensitiveInlineVariablesTest extends CompilerTestCase  {

  public static final String EXTERN_FUNCTIONS = "" +
      "var print;\n" +
      "/** @nosideeffects */ function noSFX() {} \n" +
      "                      function hasSFX() {} \n";

  public FlowSensitiveInlineVariablesTest() {
    enableNormalize(true);
  }

  @Override
  public int getNumRepetitions() {
    // Test repeatedly inline.
    return 3;
  }

  @Override
  protected CompilerPass getProcessor(final Compiler compiler) {
    //return new FlowSensitiveInlineVariables(compiler);
    return new CompilerPass() {
      @Override
      public void process(Node externs, Node root) {
        (new MarkNoSideEffectCalls(compiler)).process(externs, root);
        (new FlowSensitiveInlineVariables(compiler)).process(externs, root);
      }
    };
  }


public void testAssignmentBeforeDefinition20() { 
     inline("x = 1; var x = 0; print(x)", "x = 1; var x; print(0)"); 
 }


public void testSimple35() { 
     test("function foo()   { alert(arguments[0]); }", "function foo(p0) { alert(p0); }"); 
 }


public void testDoNotInlineWithinLoop170() { 
     noInline("var y = noSFX(); do { var z = y.foo(); } while (true);"); 
 }


public void testMultiUseInSameCfgNode171() { 
     noInline("var x; x = 1; print(x) || print (x);"); 
     noInline("var x; x = 1; print(x) || print (x);"); 
     noInline("var x; x = 1; print(x) || print (x);"); 
     noInline("var x; x = 1; print(x) || print (1);"); 
     noInline("var x; x = 1; print(x) || print (1);"); 
     noInline("var x; x = 1; print(x) || print (1);"); 
     noInline("var x; x = 1; print(x) || print (1);"); 
     noInline("var x; x = 1; print(x) || print (1);"); 
     noInline("var x; x = 1; print(x) || print (1);"); 
     noInline("var x; x = 1; print(x) || print (1);"); 
     noInline("var x; x = 1; print(x) || print (1);"); 
     noInline("var x; x = 1; print(x) || print (1);"); 
     noInline("var x; x = 1; print(x) || print (1);"); 
     noInline("var x; x = 1; print(x) || print (1);"); 
     noInline("var x; x = 1; print(x);"); 
     noInline("var x; x = 1; print(x);"); 
     noInline("var x; x = 1; print(x);"); 
     noInline("var x; x = 1; print(x);"); 
     noInline("var x; x = 1; print(x);"); 
 }


public void testMultiUseInSameCfgNode172() { 
     noInline("var x; x = 1; print(x); print(x);"); 
     noInline("var x; x = 1; print(x); print(1);"); 
     noInline("var x; x = 1; print(x); print(1);"); 
     noInline("var x; x = 1; print(x); print(1);"); 
     noInline("var x; x = 1; print(x); print(1);"); 
     noInline("var x; x = 1; print(x); print(1);"); 
     noInline("var x; x = 1; print(x + 1); print(1);"); 
     noInline("var x; x = 1; print(x + 1); print(1);"); 
     noInline("var x; x = 1; print(x + 1); print(1);"); 
     noInline("var x; x = 1; print(x + 1); print(1);"); 
     noInline("var x; x = 1; print(x + 1); print(1);"); 
     noInline("var x; x = 1; print(x + 1); print(1);"); 
     noInline("var x; x = 1; print(x + 1); print(1);"); 
     noInline("var x; x = 1; print(x + 1); print(1);"); 
     noInline("var x; x = 1; print(x + 1); print(1);"); 
     noInline("var x; x = 1; print(x + 1); print(1);"); 
 }


public void testMultiUseInSameCfgNode173() { 
     noInline("var x; x = 1; print(x) || print (x);"); 
     noInline("var x; x = 1; print(x) || print (x);"); 
     noInline("var x; x = 1; print(x) || print (x);"); 
     noInline("var x; x = 1; print(x) || print (1);"); 
     noInline("var x; x = 1; print(x) || print (1);"); 
     noInline("var x; x = 1; print(x) || print (1);"); 
     noInline("var x; x = 1; print(x) || print (1);"); 
     noInline("var x; x = 1; print(x) || print (1);"); 
     noInline("var x; x = 1; print(x) || print (1);"); 
     noInline("var x; x = 1; print(x);"); 
     noInline("var x; x = 1; print(x);"); 
     noInline("var x; x = 1; print(x);"); 
     noInline("var x; x = 1; print(x);"); 
     noInline("var x; x = 1; print(x);"); 
     noInline("var x; x = 1; print(x);"); 
     noInline("var x; x = 1; print(x);"); 
     noInline("var x; x = 1; print(x);"); 
     noInline("var x; x = 1; print(x);"); 
     noInline("var x; x = 1; print(x);"); 
     noInline("var x; x = 1; print(x);"); 
 }


public void testShadowVariables16174() { 
     assumeMinimumCapture = false; 
     test("var a=3;" + "function foo(){return a}" + "(function(){var a=5;(function(){foo()})()})()", "var a=3;" + "{var a$$inline_0=5;{a}}"); 
     assumeMinimumCapture = true; 
     test("var a=3;" + "function foo(){return a}" + "(function(){var a=5;(function(){foo()})()})()", "var a=3;" + "{var a$$inline_1=5;{a}}"); 
 }


public void testMultiUseInSameCfgNode175() { 
     noInline("var x; x = 1; print(x); print(1);"); 
     noInline("var x; x = 1; print(x); print(1);"); 
     noInline("var x; x = 1; print(x); print(1);"); 
     noInline("var x; x = 1; print(x); print(1);"); 
     noInline("var x; x = 1; print(x); print(1);"); 
     noInline("var x; x = 1; print(x); print(1);"); 
     noInline("var x; x = 1; print(x); print(1);"); 
     noInline("var x; x = 1; print(x); print(1);"); 
     noInline("var x; x = 1; print(x); print(1);"); 
     noInline("var x; x = 1; print(x); print(1);"); 
     noInline("var x; x = 1; print(x); print(1);"); 
     noInline("var x; x = 1; print(x); print(1);"); 
     noInline("var x; x = 1; print(x); print(1);"); 
     noInline("var x; x = 1; print(x); print(1);"); 
     noInline("var x; x = 1; print(x); print(1);"); 
     noInline("var x; x = 1; print(x); print(1);"); 
     noInline("var x; x = 1; print(x); print(1);"); 
 }


public void testNoArgumentRemovalNonEqualNodes294() { 
     testSame("function foo(a){}; foo('bar'); foo('baz');"); 
     testSame("function foo(a){}; foo(1.0); foo(2.0);"); 
     testSame("function foo(a){}; foo(true); foo(false);"); 
     testSame("var a = 1, b = 2; function foo(a){}; foo(a); foo(b);"); 
     testSame("function foo(a){}; foo(/&/g); foo(/</g);"); 
 }


public void testRemoveForChild295() { 
     Compiler compiler = new Compiler(); 
     Node actual = parse("for(var a=0;a<0;a++)foo()"); 
     Node forNode = actual.getFirstChild(); 
     Node child = forNode.getFirstChild(); 
     NodeUtil.removeChild(forNode, child); 
     String expected = "for(;a<0;a++)foo()"; 
     String difference = parse(expected).checkTreeEquals(actual); 
     if (difference != null) { 
         assertTrue("Nodes do not match:\n" + difference, false); 
     } 
     actual = parse("for(var a=0;a<0;a++)foo()"); 
     forNode = actual.getFirstChild(); 
     child = forNode.getFirstChild().getNext(); 
     NodeUtil.removeChild(forNode, child); 
     expected = "for(var a=0;a<0;a++)foo()"; 
     difference = parse(expected).checkTreeEquals(actual); 
     if (difference != null) { 
         assertTrue("Nodes do not match:\n" + difference, false); 
     } 
     actual = parse("for(var a=0;a<0;a++)foo()"); 
     forNode = actual.getFirstChild(); 
     child = forNode.getFirstChild().getNext(); 
     NodeUtil.removeChild(forNode, child); 
     expected = "for(var a=0;a<0;a++)foo()"; 
     difference = parse(expected).checkTreeEquals(actual); 
     if (difference != null) { 
         assertTrue("Nodes do not match:\n" + difference


public void testQualifiedNameReduction3296() throws Exception { 
     testTypes("/** @param {string|Array} a\n@constructor */ var T = " + "function(a) {this.a = a};\n" + "/** @return {string} */ T.prototype.f = function() {\n" + "return typeof this.a == 'string' ? this.a : 'a'; }"); 
 }


public void testRemoveFromParent297() { 
     Node actual = parse("{{x()}}"); 
     Node outerBlockNode = actual.getFirstChild(); 
     Node innerBlockNode = outerBlockNode.getFirstChild(); 
     innerBlockNode.setIsSyntheticBlock(true); 
     NodeUtil.removeChild(outerBlockNode, innerBlockNode); 
     String expected = "{{}}"; 
     String difference = parse(expected).checkTreeEquals(actual); 
     if (difference != null) { 
         assertTrue("Nodes do not match:\n" + difference, false); 
     } 
 }


public void testCopyInformationFrom298() { 
     Node assign = getAssignExpr("b", "c"); 
     assign.setSourceEncodedPosition(99); 
     assign.setSourceFileForTesting("foo.js"); 
     Node lhs = assign.getFirstChild(); 
     lhs.copyInformationFrom(assign); 
     assertEquals(99, lhs.getSourcePosition()); 
     assertEquals("foo.js", lhs.getSourceFileName()); 
     assign.setSourceEncodedPosition(101); 
     assign.setSourceFileForTesting("bar.js"); 
     lhs.copyInformationFrom(assign); 
     assertEquals(99, lhs.getSourcePosition()); 
     assertEquals("foo.js", lhs.getSourceFileName()); 
 }


public void testUnaryOps299() { 
     foldSame("!foo()"); 
     foldSame("~foo()"); 
     foldSame("-foo()"); 
     fold("a=!true", "a=false"); 
     fold("a=!10", "a=false"); 
     fold("a=!false", "a=true"); 
     fold("a=!foo()", "a=!foo()"); 
     fold("a=-0", "a=-0.0"); 
     fold("a=-(0)", "a=-0.0"); 
     fold("a=-Infinity", "a=-Infinity"); 
     fold("a=-NaN", "a=NaN"); 
     fold("a=-foo()", "a=-foo()"); 
     fold("a=~~0", "a=0"); 
     fold("a=~~10", "a=10"); 
     fold("a=~-7", "a=6"); 
     fold("a=+true", "a=1"); 
     fold("a=+10", "a=10"); 
     fold("a=+false", "a=0"); 
     foldSame("a=+foo()"); 
     foldSame("a=+f"); 
     fold("a=+(f?true:false)", "a=+(f?1:0)"); 
     fold("a=+0", "a=0"); 
     fold("a=+Infinity", "a=Infinity"); 
     fold("a=+NaN", "a=NaN"); 
     fold("a=+-7", "a=-7"); 
     fold("a=+.5", "a=.5"); 
     fold("a=~0x100000000", "a=~0x100000000", PeepholeFoldConstants.BITWISE_OPERAND_OUT_OF_RANGE); 
     fold("a=~-0x100000000", "a=~-0x100000000", Peeph


public void testCheckTreeEqualsImplDifferentChildCount300() { 
     Node node1 = new Node(1, new Node(2)); 
     Node node2 = new Node(1); 
     assertEquals(new NodeMismatch(node1, node2), node1.checkTreeEqualsImpl(node2)); 
 }


public void testCheckTreeEquals301() { 
     Node node1 = new Node(1, new Node(2)); 
     Node node2 = new Node(1); 
     assertNull(node1.checkTreeEquals(node2)); 
 }


public void testLocalValue2302() { 
     Node newExpr = getNode("new x()"); 
     assertFalse(NodeUtil.evaluatesToLocalValue(newExpr)); 
     Preconditions.checkState(newExpr.isNew()); 
     Node.SideEffectFlags flags = new Node.SideEffectFlags(); 
     flags.clearAllFlags(); 
     newExpr.setSideEffectFlags(flags.valueOf()); 
     assertTrue(NodeUtil.evaluatesToLocalValue(newExpr)); 
     flags.clearAllFlags(); 
     flags.setMutatesThis(); 
     newExpr.setSideEffectFlags(flags.valueOf()); 
     assertTrue(NodeUtil.evaluatesToLocalValue(newExpr)); 
     flags.clearAllFlags(); 
     flags.setReturnsTainted(); 
     newExpr.setSideEffectFlags(flags.valueOf()); 
     assertTrue(NodeUtil.evaluatesToLocalValue(newExpr)); 
     flags.clearAllFlags(); 
     flags.setThrows(); 
     newExpr.setSideEffectFlags(flags.valueOf()); 
     assertFalse(NodeUtil.evaluatesToLocalValue(newExpr)); 
     flags.clearAllFlags(); 
     flags.setMutatesArguments(); 
     newExpr.setSideEffectFlags(flags.valueOf()); 
     assertFalse(NodeUtil.evaluatesToLocalValue(newExpr)); 
     flags.clearAllFlags(); 
     flags.setMutatesGlobalState(); 
     newExpr.setSideEffectFlags(flags.valueOf()); 
     assertFalse(NodeUtil.evaluatesToLocalValue(newExpr)); 
 }


public void testCheckTreeEquals303() { 
     Node node1 = new Node(1, new Node(2)); 
     Node node2 = new Node(1); 
     assertEquals(null, node1.checkTreeEquals(node2)); 
     node1.checkTreeEquals(null, node2); 
     assertEquals(null, node1.checkTreeEquals(new Node(2), null)); 
     assertEquals(null, node2.checkTreeEquals(new Node(2), null)); 
     assertEquals(null, node1.checkTreeEquals(new Node(3), null)); 
     assertEquals(null, node2.checkTreeEquals(new Node(4), null)); 
     assertEquals(null, node1.checkTreeEquals(new Node(5), null)); 
     assertEquals(null, node2.checkTreeEquals(new Node(7), null)); 
     assertEquals(null, node1.checkTreeEquals(new Node(8), null)); 
     assertEquals(null, node2.checkTreeEquals(new Node(9), null)); 
     assertEquals(null, node1.checkTreeEquals(new Node(10), null)); 
     assertEquals(null, node2.checkTreeEquals(new Node(11), null)); 
     assertEquals(null, node1.checkTreeEquals(new Node(16), null)); 
     assertEquals(null, node2.checkTreeEquals(new Node(17), null)); 
     assertEquals(null, node1.checkTreeEquals(new Node(18), null)); 
     assertEquals(null, node2.checkTreeEquals(new Node(21), null)); 
 }


public void testUnhandledTopNode304() { 
     testSame("function Foo() {}; Foo.prototype.isBar = function() {};" + "function Bar() {}; Bar.prototype.isFoo = function() {};" + "var foo = new Foo(); var bar = new Bar();" + "var cond = foo.isBar() && bar.isFoo();" + "if (cond) {window.alert('hello');}"); 
 }


public void testCheckTreeTypeAwareEqualsSameNull305() { 
     TestErrorReporter testErrorReporter = new TestErrorReporter(null, null); 
     JSTypeRegistry registry = new JSTypeRegistry(testErrorReporter); 
     Node node1 = Node.newString(Token.NAME, "f"); 
     Node node2 = Node.newString(Token.NAME, "f"); 
     assertTrue(node1.isEquivalentToTyped(node2)); 
 }


public void testRemoveChildBlock306() { 
     Node actual = parse("{{x()}}"); 
     Node outerBlockNode = actual.getFirstChild(); 
     Node innerBlockNode = outerBlockNode.getFirstChild(); 
     innerBlockNode.setIsSyntheticBlock(true); 
     NodeUtil.removeChild(outerBlockNode, innerBlockNode); 
     String expected = "{{}}"; 
     String difference = parse(expected).checkTreeEquals(actual); 
     if (difference != null) { 
         assertTrue("Nodes do not match:\n" + difference, false); 
     } 
 }


public void testMutateWithMultipleReturns307() { 
     helperMutate("function foo(){ if (0) {return 0} else {return 1} };" + "var result=foo();", "{" + "JSCompiler_inline_label_foo_0:{" + "if(0) {" + "result=0; break JSCompiler_inline_label_foo_0" + "} else {" + "result=1; break JSCompiler_inline_label_foo_0" + "} result=void 0" + "}" + "}", "foo", true, false); 
 }


public void testUseSourceInfoFrom308() { 
     Node assign = getAssignExpr("b", "c"); 
     assign.setSourceEncodedPosition(99); 
     assign.setSourceFileForTesting("foo.js"); 
     Node lhs = assign.getFirstChild(); 
     lhs.useSourceInfoFrom(assign); 
     assertEquals(99, lhs.getSourcePosition()); 
     assertEquals("foo.js", lhs.getSourceFileName()); 
     assign.setSourceEncodedPosition(101); 
     assign.setSourceFileForTesting("bar.js"); 
     lhs.useSourceInfoFrom(assign); 
     assertEquals(99, lhs.getSourcePosition()); 
     assertEquals("foo.js", lhs.getSourceFileName()); 
 }


public void testDoNotInlineIntoLhsOfAssign309() { 
     noInline("var x = 1; x += 3;"); 
 }

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  // TODO(user): These should be inlinable.
  

  // TODO(user): These should be inlinable.
  

  // TODO(user): These should be inlinable.
  

  // TODO(user): These should be inlinable after the REGEX checks.
  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  private void noInline(String input) {
    inline(input, input);
  }

  private void inline(String input, String expected) {
    test(EXTERN_FUNCTIONS, "function _func() {" + input + "}",
        "function _func() {" + expected + "}", null, null);
  }
}
