/*
 * Copyright 2011 The Closure Compiler Authors.
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

import com.google.javascript.jscomp.AstValidator.ViolationHandler;
import com.google.javascript.rhino.InputId;
import com.google.javascript.rhino.Node;
import com.google.javascript.rhino.Token;
import com.google.javascript.rhino.jstype.SimpleSourceFile;


/**
 * @author johnlenz@google.com (John Lenz)
 */
public class AstValidatorTest extends CompilerTestCase {

  private boolean lastCheckWasValid = true;

  @Override
  protected CompilerPass getProcessor(Compiler compiler) {
    return createValidator();
  }

  private AstValidator createValidator() {
    lastCheckWasValid = true;
    return new AstValidator(new ViolationHandler() {
      @Override
      public void handleViolation(String message, Node n) {
        lastCheckWasValid = false;
      }
    });
  }

  @Override
  protected int getNumRepetitions() {
    return 1;
  }

  @Override
  protected void setUp() throws Exception {
    super.enableAstValidation(false);
    super.disableNormalize();
    super.enableLineNumberCheck(false);
    super.setUp();
  }

public void testValidExpression2147() { 
     Node n = new Node(Token.ARRAYLIT, new Node(Token.EMPTY)); 
     expectValid(n, Check.EXPRESSION); 
     expectInvalid(n, Check.STATEMENT); 
     expectInvalid(n, Check.SCRIPT); 
 }
public void testValidExpression1149() { 
     Node n = new Node(Token.ARRAYLIT, new Node(Token.EMPTY)); 
     expectValid(n, Check.EXPRESSION); 
     expectInvalid(n, Check.STATEMENT); 
     expectInvalid(n, Check.SCRIPT); 
 }
public void testRemoveInControlStructure3150() { 
     test("for(1;2;3) 4", "for(;;);"); 
 }
public void testNoMoveSideEffectProperty151() { 
     testSame(createModuleChain("function Foo(){} " + "Foo.prototype.bar = createSomething();", "new Foo();")); 
 }
public void testInlineIntoTryCatch156() { 
     test("var a = true; " + "try { var b = a; } " + "catch (e) { var c = a + b; var d = true; } " + "finally { var f = a + b + c + d; }", "try { var b = true; } " + "catch (e) { var c = true + b; var d = true; } " + "finally { var f = true + b + c + d; }"); 
 }
public void testNonConstructorClassProp1157() { 
     testSame("function C() {\n" + "  this.foo = 1;\n" + "  return this;\n" + "}\n" + "C().foo;"); 
 }
  

  

  

  

  

  

  

  private void valid(String code) {
    testSame(code);
    assertTrue(lastCheckWasValid);
  }

  private enum Check {
    SCRIPT,
    STATEMENT,
    EXPRESSION
  }

  private boolean doCheck(Node n, Check level) {
    AstValidator validator = createValidator();
    switch (level) {
      case SCRIPT:
        validator.validateScript(n);
        break;
      case STATEMENT:
        validator.validateStatement(n);
        break;
      case EXPRESSION:
        validator.validateExpression(n);
        break;
    }
    return lastCheckWasValid;
  }

  private void expectInvalid(Node n, Check level) {
    assertFalse(doCheck(n, level));
  }

  private void expectValid(Node n, Check level) {
    assertTrue(doCheck(n, level));
  }
}