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
import com.google.gson.InstanceCreator;
import com.google.gson.reflect.TypeToken;

import junit.framework.TestCase;

import java.lang.reflect.Type;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * Functional test for Json serialization and deserialization for Maps
 *
 * @author Inderjeet Singh
 * @author Joel Leitch
 */
public class MapTest extends TestCase {
  private Gson gson;

  @Override
  protected void setUp() throws Exception {
    super.setUp();
    gson = new Gson();
  }


public void testSerializeMaps100() { 
     Map<String, Object> map = new LinkedHashMap<String, Object>(); 
     map.put("a", 12); 
     map.put("b", null); 
     map.put("c", new HashMap<String, Object>()); 
     assertEquals("{\"a\":12,\"b\":null,\"c\":{}}", new GsonBuilder().serializeNulls().create().toJson(map)); 
     assertEquals("{\"a\":12,\"b\":null,\"c\":{}}", new GsonBuilder().serializeNulls().create().toJson(map)); 
     assertEquals("{\"a\":12,\"c\":{}}", new GsonBuilder().create().toJson(map)); 
     assertEquals("{\"a\":12,\"c\":{}}", new GsonBuilder().create().toJson(map)); 
 } 


public void testMapDeserializationWithWildcardValues152() { 
     Type typeOfMap = new TypeToken<Map<String, ? extends Long>>() { 
     }.getType(); 
     Map<String, ? extends Long> map = gson.fromJson("{\"test\":123}", typeOfMap); 
     assertEquals(1, map.size()); 
     assertEquals(new Long(123L), map.get("test")); 
 } 

  

  

  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  

  

  

  private static class MyParameterizedMap<K, V> extends LinkedHashMap<K, V> {
    private static final long serialVersionUID = 1L;

    @SuppressWarnings("unused")
    int foo = 10;
  }
  
  
  
  
  
  
  
  /**
   * Created in response to http://code.google.com/p/google-gson/issues/detail?id=99
   */
  private static class ClassWithAMap {
    Map<String, String> map = new TreeMap<String, String>();
  }
  
  /**
   * Created in response to http://code.google.com/p/google-gson/issues/detail?id=99
   */
  
  
  /**
   * Created in response to http://code.google.com/p/google-gson/issues/detail?id=99
   */
  
  
  
  
  

  
  private static class MyMap extends LinkedHashMap<String, String> {
    private static final long serialVersionUID = 1L;

    @SuppressWarnings("unused")
    int foo = 10;
  }
  
  /**
   * From bug report http://code.google.com/p/google-gson/issues/detail?id=95
   */
  
  
  /**
   * From bug report http://code.google.com/p/google-gson/issues/detail?id=95
   */
  

  /**
   * From bug report http://code.google.com/p/google-gson/issues/detail?id=178
   */
  
  
  /**
   * From issue 227.
   */
  

  

  /**
   * From bug report http://code.google.com/p/google-gson/issues/detail?id=204
   */
  
}
