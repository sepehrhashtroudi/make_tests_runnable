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

import java.math.BigDecimal;
import java.math.BigInteger;

import junit.framework.TestCase;

/**
 * Unit test for the {@link JsonPrimitive} class.
 * 
 * @author Joel Leitch
 */
public class JsonPrimitiveTest extends TestCase {

public void testFloatEqualsDouble73() { 
     JsonPrimitive p1 = new JsonPrimitive(new Float(10.25F)); 
     JsonPrimitive p2 = new JsonPrimitive(new Double(10.25D)); 
     assertEquals(p1, p2); 
     assertEquals(p1.hashCode(), p2.hashCode()); 
 }
public void testShortEqualsInteger74() { 
     JsonPrimitive p1 = new JsonPrimitive(new Short((short) 10)); 
     JsonPrimitive p2 = new JsonPrimitive(new Integer(10)); 
     assertEquals(p1, p2); 
     assertEquals(p1.hashCode(), p2.hashCode()); 
 }
  
  
  
  
  
  
  
  
  
  
  

  

  

  

  

  

  

  

  

  

  

  

  
  
  
}
