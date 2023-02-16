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
import com.google.gson.JsonElement;
import com.google.gson.JsonNull;
import com.google.gson.JsonObject;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import com.google.gson.common.TestTypes.BagOfPrimitives;
import com.google.gson.common.TestTypes.ClassWithObjects;

import junit.framework.TestCase;

import java.lang.reflect.Type;
import java.util.Collection;

/**
 * Functional tests for the different cases for serializing (or ignoring) null fields and object.
 *
 * @author Inderjeet Singh
 * @author Joel Leitch
 */
public class NullObjectAndFieldTest extends TestCase {
  private GsonBuilder gsonBuilder;

  @Override
  protected void setUp() throws Exception {
    super.setUp();
    gsonBuilder = new GsonBuilder().serializeNulls();
  }

  

  

  

  
  
  
  
  /** 
   * Added to verify http://code.google.com/p/google-gson/issues/detail?id=68
   */
  
  
  /** 
   * Added to verify http://code.google.com/p/google-gson/issues/detail?id=68
   */
  
  
  
  
  

  
  
  
  
  

  private static class ClassWithNullWrappedPrimitive {
    private Long value;
  }

  @SuppressWarnings("unused")
  private static class ClassWithMembers {
    String str;
    int[] array;
    Collection<String> col;
  }
  
  private static class ClassWithObjectsSerializer implements JsonSerializer<ClassWithObjects> {
    public JsonElement serialize(ClassWithObjects src, Type typeOfSrc,
        JsonSerializationContext context) {
      JsonObject obj = new JsonObject();
      obj.add("bag", new JsonNull());
      return obj;
    }
  }

  

  

  

  private static class ObjectWithField {
    String value = "";
  }
}