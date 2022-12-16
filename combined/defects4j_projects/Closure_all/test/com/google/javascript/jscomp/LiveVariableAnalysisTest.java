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

import com.google.javascript.jscomp.DataFlowAnalysis.FlowState;
import com.google.javascript.jscomp.Scope.Var;
import com.google.javascript.rhino.InputId;
import com.google.javascript.rhino.Node;
import com.google.javascript.rhino.Token;

import junit.framework.TestCase;

/**
 * Tests for {@link LiveVariablesAnalysis}. Test cases are snippets of a
 * function and assertions are made at the instruction labeled with {@code X}.
 *
 */
public class LiveVariableAnalysisTest extends TestCase {

  private LiveVariablesAnalysis liveness = null;


public void testGetCurrentNode26() { 
     Compiler compiler = new Compiler(); 
     ScopeCreator creator = new SyntacticScopeCreator(compiler, true); 
     ExpectNodeOnEnterScope callback = new ExpectNodeOnEnterScope(); 
     NodeTraversal t = new NodeTraversal(compiler, callback, creator); 
     String code = "" + "var a; " + "function foo() {" + "  var b;" + "}"; 
     Node tree = parse(compiler, code); 
     Scope topScope = creator.createScope(tree, null); 
     callback.expect(tree.getFirstChild(), tree); 
     t.traverseWithScope(tree.getFirstChild(), topScope); 
     callback.assertEntered(); 
     callback.expect(tree.getFirstChild(), tree.getFirstChild()); 
     t.traverse(tree.getFirstChild()); 
     callback.assertEntered(); 
     Node fn = tree.getFirstChild().getNext(); 
     Scope fnScope = creator.createScope(fn, topScope); 
     callback.expect(fn, fn); 
     t.traverseAtScope(fnScope); 
     callback.assertEntered(); 
 }


public void testDoContinueOptimization200() throws Exception { 
     fold("do{if(x)continue; x=3; continue; }while(true)", "do if(x); else x=3; while(true)"); 
     foldSame("do{a();continue;b()}while(true)"); 
     fold("do{if(true){a();continue;}else;b();}while(true)", "do{if(true){a();}else{b();}}while(true)"); 
     fold("do{if(false){a();continue;}else;b();continue;}while(true)", "do{if(false){a();}else{b();}}while(true)"); 
     fold("do{if(a()){b();continue;}else;c();}while(true)", "do{if(a()){b();}else{c()}}while(true)"); 
     fold("do{if(a()){b();}else{c();continue;}}while(true)", "do{if(a()){b();}else{c();}}while(true)"); 
     fold("do{if(a()){b();continue;}else;}while(true)", "do{if(a()){b();}else;}while(true)"); 
     fold("do{if(a()){continue;}else{continue;} continue;}while(true)", "do{if(a()){}else{}}while(true)"); 
     fold("do{if(a()){continue;}else{continue;} b();}while(true)", "do{if(a()){}else{continue; b();}}while(true)"); 
     fold("do{while(a())continue;}while(true)", "do while(a());while(true)"); 
     fold("do{for(x in a())continue}while(true)", "do for(x in a());while(true)"); 
     fold("do{while(a())break;}while(true)", "do while(a())break


public void testDoContinueLocation201() { 
     Node root = newParse("do { var x = 3; } while (true);"); 
     Node tryStmt = root.getFirstChild(); 
     Node tryBlock = tryStmt.getFirstChild(); 
     Node catchBlock = tryBlock.getNext(); 
     Node catchStmt = catchBlock.getFirstChild(); 
     Node exceptionVar = catchStmt.getFirstChild(); 
     Node exceptionBlock = exceptionVar.getNext(); 
     Node varDecl = exceptionBlock.getFirstChild(); 
     assertNodePosition(1, 0, tryStmt); 
     assertNodePosition(1, 4, tryBlock); 
     assertNodePosition(3, 0, catchBlock); 
     assertNodePosition(3, 9, exceptionVar); 
     assertNodePosition(3, 13, exceptionBlock); 
     assertNodePosition(4, 2, varDecl); 
 }


public void testDoContinueLocation202() { 
     Node root = newParse("do { var x = 3; } while (true);"); 
     Node tryStmt = root.getFirstChild(); 
     Node tryBlock = tryStmt.getFirstChild(); 
     Node catchBlock = tryBlock.getNext(); 
     Node catchStmt = catchBlock.getFirstChild(); 
     Node exceptionVar = catchStmt.getFirstChild(); 
     Node exceptionBlock = exceptionVar.getNext(); 
     Node varDecl = exceptionBlock.getFirstChild(); 
     assertNodePosition(1, 0, tryStmt); 
     assertNodePosition(1, 4, tryBlock); 
     assertNodePosition(3, 0, catchBlock); 
     assertNodePosition(3, 2, catchStmt); 
     assertNodePosition(3, 9, exceptionVar); 
     assertNodePosition(3, 13, exceptionBlock); 
     assertNodePosition(4, 2, varDecl); 
 }

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  private void assertLiveBeforeX(String src, String var) {
    FlowState<LiveVariablesAnalysis.LiveVariableLattice> state =
        getFlowStateAtX(src);
    assertNotNull(src + " should contain a label 'X:'", state);
    assertTrue("Variable" + var + " should be live before X", state.getIn()
        .isLive(liveness.getVarIndex(var)));
  }

  private void assertLiveAfterX(String src, String var) {
    FlowState<LiveVariablesAnalysis.LiveVariableLattice> state =
        getFlowStateAtX(src);
    assertTrue("Label X should be in the input program.", state != null);
    assertTrue("Variable" + var + " should be live after X", state.getOut()
        .isLive(liveness.getVarIndex(var)));
  }

  private void assertNotLiveAfterX(String src, String var) {
    FlowState<LiveVariablesAnalysis.LiveVariableLattice> state =
        getFlowStateAtX(src);
    assertTrue("Label X should be in the input program.", state != null);
    assertTrue("Variable" + var + " should not be live after X", !state
        .getOut().isLive(liveness.getVarIndex(var)));
  }

  private void assertNotLiveBeforeX(String src, String var) {
    FlowState<LiveVariablesAnalysis.LiveVariableLattice> state =
        getFlowStateAtX(src);
    assertTrue("Label X should be in the input program.", state != null);
    assertTrue("Variable" + var + " should not be live before X", !state
        .getIn().isLive(liveness.getVarIndex(var)));
  }

  private FlowState<LiveVariablesAnalysis.LiveVariableLattice> getFlowStateAtX(
      String src) {
    liveness = computeLiveness(src);
    return getFlowStateAtX(liveness.getCfg().getEntry().getValue(), liveness
        .getCfg());
  }

  private FlowState<LiveVariablesAnalysis.LiveVariableLattice> getFlowStateAtX(
      Node node, ControlFlowGraph<Node> cfg) {
    if (node.isLabel()) {
      if (node.getFirstChild().getString().equals("X")) {
        return cfg.getNode(node.getLastChild()).getAnnotation();
      }
    }
    for (Node c = node.getFirstChild(); c != null; c = c.getNext()) {
      FlowState<LiveVariablesAnalysis.LiveVariableLattice> state =
          getFlowStateAtX(c, cfg);
      if (state != null) {
        return state;
      }
    }
    return null;
  }

  private static void assertEscaped(String src, String name) {
    for (Var var : computeLiveness(src).getEscapedLocals()) {
      if (var.name.equals(name)) {
        return;
      }
    }
    fail("Variable " + name + " should be in the escaped local list.");
  }

  private static void assertNotEscaped(String src, String name) {
    for (Var var : computeLiveness(src).getEscapedLocals()) {
      assertFalse(var.name.equals(name));
    }
  }

  private static LiveVariablesAnalysis computeLiveness(String src) {
    Compiler compiler = new Compiler();
    CompilerOptions options = new CompilerOptions();
    options.setCodingConvention(new GoogleCodingConvention());
    compiler.initOptions(options);
    src = "function _FUNCTION(param1, param2){" + src + "}";
    Node n = compiler.parseTestCode(src).removeFirstChild();
    Node script = new Node(Token.SCRIPT, n);
    script.setInputId(new InputId("test"));
    assertEquals(0, compiler.getErrorCount());
    Scope scope = new SyntacticScopeCreator(compiler).createScope(
        n, Scope.createGlobalScope(script));
    ControlFlowAnalysis cfa = new ControlFlowAnalysis(compiler, false, true);
    cfa.process(null, n);
    ControlFlowGraph<Node> cfg = cfa.getCfg();
    LiveVariablesAnalysis analysis =
        new LiveVariablesAnalysis(cfg, scope, compiler);
    analysis.analyze();
    return analysis;
  }
}
