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

/**
 * Test for {@link UnreachableCodeElimination}.
 *
 */
public class UnreachableCodeEliminationTest extends CompilerTestCase {
  private boolean removeNoOpStatements = true;

  @Override
  protected CompilerPass getProcessor(Compiler compiler) {
    return new UnreachableCodeElimination(compiler, removeNoOpStatements);
  }

  @Override public void setUp() throws Exception {
    super.setUp();
    removeNoOpStatements = true;
  }

public void testIssue5215541_deadVarDeclar1() { 
     testSame("throw 1; var x"); 
     testSame("throw 1; var x; var y;"); 
     test("throw 1; var x = foo", "var x; throw 1"); 
 }
public void testIssue3112() { 
     test("function a(b) {\n" + "  switch (b.v) {\n" + "    case 'SWITCH':\n" + "      if (b.i >= 0) {\n" + "        return b.o;\n" + "      } else {\n" + "        return;\n" + "      }\n" + "      break;\n" + "  }\n" + "}", "function a(b) {\n" + "  switch (b.v) {\n" + "    case 'SWITCH':\n" + "      if (b.i >= 0) {\n" + "        return b.o;\n" + "      } else {\n" + "      }\n" + "  }\n" + "}"); 
 }
public void testUnlessUnconditonalBreak3() { 
     test("switch (a) { case 'a': break }", "switch (a) { case 'a': }"); 
     test("switch (a) { case 'a': break; case foo(): }", "switch (a) { case 'a':        case foo(): }"); 
     test("switch (a) { default: break; case 'a': }", "switch (a) { default:        case 'a': }"); 
     testSame("switch (a) { case 'a': alert(a); break; default: alert(a); }"); 
     testSame("switch (a) { default: alert(a); break; case 'a': alert(a); }"); 
     test("X: {switch (a) { case 'a': break X}}", "X: {switch (a) { case 'a': }}"); 
     testSame("X: {switch (a) { case 'a': if (a()) {break X}  a = 1}}"); 
     test("X: {switch (a) { case 'a': if (a()) {break X}}}", "X: {switch (a) { case 'a': if (a()) {}}}"); 
     test("X: {switch (a) { case 'a': if (a()) {break X}}}", "X: {switch (a) { case 'a': if (a()) {}}}"); 
     testSame("do { break } while(1);"); 
     testSame("for(;1;) { break }"); 
 }
public void testTryCatchFinally4() { 
     testSame("try {foo()} catch (e) {bar()}"); 
     testSame("try { try {foo()} catch (e) {bar()}} catch (x) {bar()}"); 
     test("try {var x = 1} catch (e) {e()}", "try {var x = 1} finally {}"); 
     test("try {var x = 1} catch (e) {e()} finally {x()}", " try {var x = 1}                 finally {x()}"); 
     test("try {var x = 1} catch (e) {e()} finally {}", "try {var x = 1} finally {}"); 
     testSame("try {var x = 1} finally {x()}"); 
     testSame("try {var x = 1} finally {}"); 
     test("function f() {return; try{var x = 1}catch(e){} }", "function f() {var x;}"); 
 }
public void testFor345() { 
     test("for(a = 0; a < 2 ; a++) foo();", "a = 0; for(; a < 2 ; a++) foo()"); 
     test("for(var a = 0; c < b ; c++) foo()", "var a = 0; for(; c < b ; c++) foo()"); 
     testSame("var a = 0; a:for(; c < b ; c++) foo()"); 
     testSame("var a = 0; a:b:for(; c < b ; c++) foo()"); 
     test("if(x){var a = 0; for(; c < b; c++) foo()}", "if(x){for(var a = 0; c < b; c++) foo()}"); 
     test("init(); for(; a < 2 ; a++) foo()", "for(init(); a < 2 ; a++) foo();"); 
     test("function f(){ var a; for(; a < 2 ; a++) foo() }", "function f(){ for(var a; a < 2 ; a++) foo() }"); 
     testSame("function f(){ return; for(; a < 2 ; a++) foo() }"); 
 }
  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  
}
