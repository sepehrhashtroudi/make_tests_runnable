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

import com.google.common.collect.Maps;

import com.google.javascript.jscomp.CompilerOptions.LanguageMode;
import com.google.javascript.rhino.Node;

import java.util.Map;

/**
 * Unit test for AmbiguateProperties Compiler pass.
 *
 */
public class AmbiguatePropertiesTest extends CompilerTestCase {
  private AmbiguateProperties lastPass;

  private static final String EXTERNS =
      "Function.prototype.call=function(){};" +
      "Function.prototype.inherits=function(){};" +
      "prop.toString;" +
      "var google = { gears: { factory: {}, workerPool: {} } };";

  public AmbiguatePropertiesTest() {
    super(EXTERNS);
    enableNormalize();
    enableTypeCheck(CheckLevel.WARNING);
    enableClosurePass();
  }

  @Override
  public CompilerPass getProcessor(final Compiler compiler) {
    return new CompilerPass() {
      @Override
      public void process(Node externs, Node root) {
        lastPass = new AmbiguateProperties(compiler, new char[]{'$'});
        lastPass.process(externs, root);
      }
    };
  }

  @Override
  protected int getNumRepetitions() {
    return 1;
  }

  @Override
  protected CompilerOptions getOptions() {
    // no missing properties check
    CompilerOptions options = new CompilerOptions();
    options.setLanguageIn(LanguageMode.ECMASCRIPT5);
    return options;
  }


public void testExternSubTypes46() throws Exception { 
     testSame(ALL_NATIVE_EXTERN_TYPES, "", null); 
     List<FunctionType> subtypes = ((ObjectType) getLastCompiler().getTypeRegistry().getType("Error")).getConstructor().getSubTypes(); 
     for (FunctionType type : subtypes) { 
         String typeName = type.getInstanceType().toString(); 
         FunctionType typeInRegistry = ((ObjectType) getLastCompiler().getTypeRegistry().getType(typeName)).getConstructor(); 
         assertTrue(typeInRegistry == type); 
     } 
 }


public void testSupAndInfOfReturnTypesWithDifferentParams335() { 
     FunctionType retString = new FunctionBuilder(registry).withParamsNode(registry.createParameters(NUMBER_TYPE)).withInferredReturnType(STRING_TYPE).build(); 
     FunctionType retNumber = new FunctionBuilder(registry).withParamsNode(registry.createParameters()).withReturnType(NUMBER_TYPE).build(); 
     assertLeastSupertype("Function", retString, retNumber); 
     assertGreatestSubtype("function (...[*]): None", retString, retNumber); 
 }


public void testFunctionTypeRepresentation336() { 
     assertEquals("function (number, string): boolean", registry.createFunctionType(BOOLEAN_TYPE, false, NUMBER_TYPE, STRING_TYPE).toString()); 
     assertEquals("function (new:Array, ...[*]): Array", ARRAY_FUNCTION_TYPE.toString()); 
     assertEquals("function (new:Boolean, *=): boolean", BOOLEAN_OBJECT_FUNCTION_TYPE.toString()); 
     assertEquals("function (new:Number, *=): number", NUMBER_OBJECT_FUNCTION_TYPE.toString()); 
     assertEquals("function (new:String, *=): string", STRING_OBJECT_FUNCTION_TYPE.toString()); 
     assertEquals("function (...[number]): boolean", registry.createFunctionType(BOOLEAN_TYPE, true, NUMBER_TYPE).toString()); 
     assertEquals("function (number, ...[string]): boolean", registry.createFunctionType(BOOLEAN_TYPE, true, NUMBER_TYPE, STRING_TYPE).toString()); 
     assertEquals("function (this:Date, number): (boolean|number|string)", new FunctionBuilder(registry).withParamsNode(registry.createParameters(NUMBER_TYPE)).withReturnType(NUMBER_STRING_BOOLEAN).withTypeOfThis(DATE_TYPE).build().toString()); 
 }

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  
}
