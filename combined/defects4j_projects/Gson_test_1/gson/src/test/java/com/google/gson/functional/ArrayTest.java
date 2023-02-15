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

public void testInvalidJsonDeserializationFails18() throws Exception { 
     try { 
         gson.fromJson("adfasdf1112,,,\":", BagOfPrimitives.class); 
         fail("Bad JSON should throw a ParseException"); 
     } catch (JsonParseException expected) { 
     } 
     try { 
         gson.fromJson("{adfasdf1112,,,\":}", BagOfPrimitives.class); 
         fail("Bad JSON should throw a ParseException"); 
     } catch (JsonParseException expected) { 
     } 
 }
public void testArrayOfCollectionDeserialization46() throws Exception { 
     String json = "[[1,2],[3,4]]"; 
     Type type = new TypeToken<Collection<Integer>[]>() { 
     }.getType(); 
     Collection<Integer>[] target = gson.fromJson(json, type); 
     assertEquals(2, target.length); 
     MoreAsserts.assertEquals(new Integer[] { 1, 2 }, target[0].toArray(new Integer[0])); 
     MoreAsserts.assertEquals(new Integer[] { 3, 4 }, target[1].toArray(new Integer[0])); 
 }
public void testRawCollectionOfCollectionDeserialization48() throws Exception { 
     String json = "[0,1,2,3,4,5,6,7,8,9]"; 
     Type type = new TypeToken<Collection<Integer>[]>() { 
     }.getType(); 
     Collection<Integer>[] target = gson.fromJson(json, type); 
     assertEquals(2, target.length); 
     MoreAsserts.assertEquals(new Integer[] { 0, 1, 2, 3 }, target[0].toArray(new Integer[0])); 
     MoreAsserts.assertEquals(new Integer[] { 4, 5, 6, 7, 8 }, target[1].toArray(new Integer[0])); 
 }
public void testReallyLongValuesDeserialization71() { 
     String json = "333961828784581"; 
     long value = gson.fromJson(json, Long.class); 
     assertEquals(333961828784581L, value); 
 }
  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  
}
