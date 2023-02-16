/*
 * Copyright (C) 2008 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.gson;

import com.google.gson.reflect.TypeToken;

import junit.framework.TestCase;

import java.lang.reflect.Type;
import java.util.List;

/**
 * Small test for the {@link TypeInfoArray}.
 *
 * @author Inderjeet Singh
 * @author Joel Leitch
 */
public class TypeInfoArrayTest extends TestCase {


public void testStringArray38() throws Exception { 
     TypeInfoArray arrayTypeInfo = new TypeInfoArray(String[].class); 
     assertTrue(arrayTypeInfo.isArray()); 
     assertEquals(String.class, arrayTypeInfo.getSecondLevelType()); 
     assertEquals(String[].class, arrayTypeInfo.getRawClass()); 
 } 


public void testArrayOfArrays39() { 
     String[][] a = { new String[] { "a1", "a2", "a3" }, new String[] { "b1", "b2", "b3" }, new String[] { "c1", "c2", "c3" } }; 
     TypeInfoArray typeInfo = new TypeInfoArray(a.getClass()); 
     assertEquals(a.getClass(), typeInfo.getRawClass()); 
     assertEquals(String.class, typeInfo.getComponentRawType()); 
     assertEquals(String[].class, typeInfo.getSecondLevelType()); 
 } 


public void testArrayAsParameterizedTypes145() throws Exception { 
     Type type = new TypeToken<List<String>[]>() { 
     }.getType(); 
     Type secondLevelType = new TypeToken<List<String>>() { 
     }.getType(); 
     TypeInfoArray typeInfo = new TypeInfoArray(type); 
     assertTrue(typeInfo.isArray()); 
     assertEquals(List[].class, typeInfo.getRawClass()); 
     assertEquals(secondLevelType, typeInfo.getSecondLevelType()); 
     Type actualType = typeInfo.getActualType(); 
     assertEquals(type, actualType); 
     Type actualTypeForFirstTypeVariable = TypeUtils.getActualTypeForFirstTypeVariable(actualType); 
     assertEquals(String.class, actualTypeForFirstTypeVariable); 
 } 

  

  

  

  

  

  

  

  

  

  
}
