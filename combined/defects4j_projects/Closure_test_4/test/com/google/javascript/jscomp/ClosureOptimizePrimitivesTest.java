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

/**
 * Tests for {@link ClosureOptimizePrimitives}.
 *
 * @author agrieve@google.com (Andrew Grieve)
 */
public class ClosureOptimizePrimitivesTest extends CompilerTestCase {

  @Override public CompilerPass getProcessor(final Compiler compiler) {
    return new ClosureOptimizePrimitives(compiler);
  }

public void testPropertyKey159() { 
     test("for (z.i in x) { f(z.i); f(z.i); }", "for (var JSCompiler_IgnoreCajaProperties_0 in x) {" + "  if (!JSCompiler_IgnoreCajaProperties_0.match(/___$/)) {" + "    z.i = JSCompiler_IgnoreCajaProperties_0;" + "    { f(z.i); f(z.i); }" + "  }" + "}"); 
 }
public void testObjectCreate3420() { 
     testSame("goog.object.create = function() { return { 'a': 1, 'b': 2, 'c': 8}, " + "function() { return { 'a': 1, 'b': 2, 'c': 8}, " + "function() { return { 'a': 1, 'b': 2, 'c': 8}, " + "function() { return { 'a': 1, 'b': 8}, " + "function() { return { 'a': 1, 'b': 2, 'c': 8}, " + "function() { return { 'a': 1, 'b': 2, 'c': 8}, " + "function() { return { 'a': 1, 'b': 2, 'c': 8}, " + "function() { return { 'a': 1, 'b': 2, 'c': 8}, " + "function() { return { 'a': 1, 'b': 3, 'c': 8}, " + "function() {return {'a': 1, 'b': 3, 'c': 8}, " + "function() {return {'a': 1, 'b': 2, 'c': 8}, " + "function() {return {'a': 1, 'b': 3, 'c': 8}, " + "function() {return {'a': 1, 'b': 2, 'c': 8}, " + "function() {return {'a': 1, 'b': 3, 'c': 8}, " + "function() {return {'a': 1, 'b': 3, 'c': 8}, " + "function() {return {'a': 1, 'b': 2, 'c': 8}, " + "function() {return {'a': 1, 'b': 3, 'c': 8}, " + "function() {return 'foo'}}"); 
 }
public void testObjectCreate3421() { 
     testSame("goog.object.create = function() { return { 'a': 1, 'b': 2, 'c': 8}, " + "function() { return { 'a': 1, 'b': 2, 'c': 8}, " + "function() { return { 'a': 1, 'b': 2, 'c': 8}, " + "function() { return { 'a': 1, 'b': 3, 'c': 8}, " + "function() { return { 'a': 1, 'b': 3, 'c': 8}, " + "function() { return { 'a': 1, 'b': 2, 'c': 8}, " + "function() { return { 'a': 1, 'b': 3, 'c': 8}, " + "function() { return { 'a': 1, 'b': 2, 'c': 8}, " + "function() { return { 'a': 1, 'b': 3, 'c': 8}, " + "function() {return {'a': 1, 'b': 3, 'c': 8}, " + "function() {return {'a': 1, 'b': 2, 'c': 8}, " + "function() {return {'a': 1, 'b': 3, 'c': 8}, " + "function() {return {'a': 1, 'b': 2, 'c': 8}, " + "function() {return {'a': 1, 'b': 3, 'c': 8}, " + "function() {return {'a': 1, 'b': 3, 'c': 8}, " + "function() {return 'foo'}}"); 
 }
  

  

  

  

  

  

  
}
