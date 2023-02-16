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


public void testTopLevelArrayOfIntsSerialization7() { 
     int[] target = { 1, 2, 3, 4, 5, 6, 7, 8, 9 }; 
     assertEquals("[1,2,3,4,5,6,7,8,9]", gson.toJson(target)); 
 } 


public void testNullsInArraySerialization12() { 
     String[] array = { "foo", null, "bar" }; 
     String expected = "[\"foo\",null,\"bar\"]"; 
     String json = gson.toJson(array); 
     assertEquals(expected, json); 
 } 


public void testInvalidArrayDeserialization64() { 
     String json = "[1, 2 3, 4, 5]"; 
     try { 
         gson.fromJson(json, int[].class); 
         fail("Gson should not deserialize array elements with missing ,"); 
     } catch (JsonParseException expected) { 
     } 
 } 


public void testArrayWithoutTypeInfoDeserialization77() throws Exception { 
     String json = "[1,'abc',[1,2],5]"; 
     try { 
         gson.fromJson(json, Object[].class); 
         fail("This is crazy....how did we deserialize it!!!"); 
     } catch (JsonParseException expected) { 
     } 
 } 


public void testArrayOfObjectsWithoutTypeInfoDeserialization78() throws Exception { 
     String json = "[1,'abc',{a:1},5]"; 
     try { 
         gson.fromJson(json, Object[].class); 
         fail("This is crazy....how did we deserialize it!!!"); 
     } catch (JsonParseException expected) { 
     } 
 } 


public void testArrayOfStringsDeserialization125() { 
     String json = "[\"Hello\",\"World\"]"; 
     String[] target = gson.fromJson(json, String[].class); 
     assertEquals("Hello", target[0]); 
     assertEquals("World", target[1]); 
 } 


public void testNullsInArrayDeserialization126() { 
     String json = "[\"foo\",null,\"bar\"]"; 
     String[] expected = { "foo", null, "bar" }; 
     String[] target = gson.fromJson(json, expected.getClass()); 
     for (int i = 0; i < expected.length; ++i) { 
         assertEquals(expected[i], target[i]); 
     } 
 } 

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  
}
