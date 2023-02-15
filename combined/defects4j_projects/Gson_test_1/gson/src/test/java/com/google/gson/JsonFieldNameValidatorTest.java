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

import junit.framework.TestCase;

/**
 * Unit tests for the {@link JsonFieldNameValidator} class.
 *
 * @author Joel Leitch
 */
public class JsonFieldNameValidatorTest extends TestCase {

  private JsonFieldNameValidator validator;

  @Override
  protected void setUp() throws Exception {
    super.setUp();
    validator = new JsonFieldNameValidator();
  }

public void testValidFieldBeginsWithDollarSign77() throws Exception { 
     String fieldName = "$abc"; 
     assertEquals(fieldName, validator.validate(fieldName)); 
 }
public void testValidFieldBeginsWithDollarSign78() throws Exception { 
     String fieldName = "$abc"; 
     try { 
         validator.validate(fieldName); 
         fail("Field name should not be valid"); 
     } catch (IllegalArgumentException expected) { 
     } 
 }
  

  

  

  

  

  

  

  

  

  
  
  
  
  
  
  
}
