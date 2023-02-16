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
 * Unit test for the {@link com.google.gson.ModifyFirstLetterNamingPolicy} class.
 *
 * @author Joel Leitch
 */
public class ModifyFirstLetterNamingPolicyTest extends TestCase {


public void testUpperCaseFirstLetter176() throws Exception { 
     ModifyFirstLetterNamingPolicy policy = new ModifyFirstLetterNamingPolicy(ModifyFirstLetterNamingPolicy.LetterModifier.UPPER); 
     assertEquals("Blah", policy.translateName("blah", String.class, null)); 
     assertEquals("Blah", policy.translateName("Blah", String.class, null)); 
 } 


public void testFieldStartsWithUnderscore177() throws Exception { 
     ModifyFirstLetterNamingPolicy policy = new ModifyFirstLetterNamingPolicy(ModifyFirstLetterNamingPolicy.LetterModifier.UPPER); 
     assertEquals("_Blah", policy.translateName("_blah", String.class, null)); 
     assertEquals("_Blah", policy.translateName("_Blah", String.class, null)); 
 } 


public void testLowerCaseFirstLetter178() throws Exception { 
     ModifyFirstLetterNamingPolicy policy = new ModifyFirstLetterNamingPolicy(ModifyFirstLetterNamingPolicy.LetterModifier.LOWER); 
     assertEquals("blah", policy.translateName("Blah", String.class, null)); 
     assertEquals("blah", policy.translateName("blah", String.class, null)); 
 } 

  

  

  

  

  

  

  

  
}
