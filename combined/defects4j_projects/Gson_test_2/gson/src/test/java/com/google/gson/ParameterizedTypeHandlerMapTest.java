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

import com.google.gson.common.TestTypes.Base;
import com.google.gson.common.TestTypes.Sub;
import com.google.gson.reflect.TypeToken;

import junit.framework.TestCase;

import java.lang.reflect.Type;
import java.util.List;

/**
 * Unit tests for the {@link ParameterizedTypeHandlerMap} class.
 *
 * @author Joel Leitch
 */
public class ParameterizedTypeHandlerMapTest extends TestCase {
  private ParameterizedTypeHandlerMap<String> paramMap;

  @Override
  protected void setUp() throws Exception {
    super.setUp();
    paramMap = new ParameterizedTypeHandlerMap<String>();
  }

public void testHidingExistingTypeHierarchyHandlerIsDisallowed54() { 
     paramMap.registerForTypeHierarchy(Sub.class, "subHandler"); 
     try { 
         paramMap.registerForTypeHierarchy(Base.class, "baseHandler"); 
         fail("A handler that hides an existing type hierarchy handler is not allowed"); 
     } catch (IllegalArgumentException expected) { 
     } 
 }
public void testMakeUnmodifiable55() throws Exception { 
     paramMap.makeUnmodifiable(); 
     try { 
         paramMap.register(String.class, "blah"); 
         fail("Can not register handlers when map is unmodifiable"); 
     } catch (IllegalStateException expected) { 
     } 
 }
public void testMakeUnmodifiable56() throws Exception { 
     paramMap.makeUnmodifiable(); 
     try { 
         paramMap.registerIfAbsent(String.class, "blah"); 
         fail("Can not register handlers when map is unmodifiable"); 
     } catch (IllegalStateException expected) { 
     } 
 }
public void testHidingExistingTypeHierarchyHandlerIsDisallowed57() { 
     paramMap.registerForTypeHierarchy(Sub.class, "subHandler"); 
     try { 
         paramMap.getHandlerFor(Sub.class); 
         fail("A handler that hides an existing type hierarchy handler is not allowed"); 
     } catch (IllegalArgumentException expected) { 
     } 
 }
  

  

  

  

  

  

  

  

  

  
  private static class SubOfSub extends Sub {
  }
}
