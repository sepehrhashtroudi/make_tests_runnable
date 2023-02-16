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

package com.google.gson.functional;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonParseException;
import com.google.gson.common.MoreAsserts;
import com.google.gson.common.TestTypes.BagOfPrimitives;
import com.google.gson.common.TestTypes.ClassWithObjects;
import com.google.gson.common.TestTypes.CrazyLongTypeAdapter;
import com.google.gson.reflect.TypeToken;

import junit.framework.TestCase;

import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
/**
 * Functional tests for Json serialization and deserialization of arrays.
 *
 * @author Inderjeet Singh
 * @author Joel Leitch
 */
public class ArrayTest extends TestCase {
  private Gson gson;

  @Override
  protected void setUp() throws Exception {
    super.setUp();
    gson = new Gson();
  }


public void testArrayOfCollectionDeserialization2() throws Exception { 
     String json = "[[1,2],[3,4]]"; 
     Type type = new TypeToken<Collection<Integer>[]>() { 
     }.getType(); 
     Collection<Integer>[] target = gson.fromJson(json, type); 
     assertEquals(2, target.length); 
     MoreAsserts.assertEquals(new Integer[] { 1, 2 }, target[0].toArray(new Integer[0])); 
     MoreAsserts.assertEquals(new Integer[] { 3, 4 }, target[1].toArray(new Integer[0])); 
 } 


public void testTopLevelArrayOfIntsSerialization9() { 
     int[] target = { 1, 2, 3, 4, 5, 6, 7, 8, 9 }; 
     assertEquals("[1,2,3,4,5,6,7,8,9]", gson.toJson(target)); 
 } 


public void testNullsInArraySerialization13() { 
     String[] array = { "foo", null, "bar" }; 
     String expected = "[\"foo\",null,\"bar\"]"; 
     String json = gson.toJson(array); 
     assertEquals(expected, json); 
 } 


public void testArrayOfPrimitivesWithCustomTypeAdapter160() throws Exception { 
     CrazyLongTypeAdapter typeAdapter = new CrazyLongTypeAdapter(); 
     gson = new GsonBuilder().registerTypeAdapter(long.class, typeAdapter).registerTypeAdapter(Long.class, typeAdapter).create(); 
     long[] value = { 1L }; 
     String serializedValue = gson.toJson(value); 
     String expected = "[" + String.valueOf(value[0] + CrazyLongTypeAdapter.DIFFERENCE) + "]"; 
     assertEquals(expected, serializedValue); 
     long[] deserializedValue = gson.fromJson(serializedValue, long[].class); 
     assertEquals(1, deserializedValue.length); 
     assertEquals(value[0], deserializedValue[0]); 
 } 


public void testObjectArrayWithNonPrimitivesSerialization161() throws Exception { 
     ClassWithObjects classWithObjects = new ClassWithObjects(); 
     BagOfPrimitives bagOfPrimitives = new BagOfPrimitives(); 
     String classWithObjectsJson = gson.toJson(classWithObjects); 
     String bagOfPrimitivesJson = gson.toJson(bagOfPrimitives); 
     Object[] objects = new Object[] { classWithObjects, bagOfPrimitives }; 
     String json = gson.toJson(objects); 
     assertTrue(json.contains(classWithObjectsJson)); 
     assertTrue(json.contains(bagOfPrimitivesJson)); 
 } 

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  
}
