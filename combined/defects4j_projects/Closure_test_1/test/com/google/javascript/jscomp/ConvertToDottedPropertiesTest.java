/*
 * Copyright 2007 The Closure Compiler Authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.javascript.jscomp;

/**
 * Tests for {@link ConvertToDottedProperties}.
 *
 */
public class ConvertToDottedPropertiesTest extends CompilerTestCase {
  @Override public CompilerPass getProcessor(Compiler compiler) {
    return new ConvertToDottedProperties(compiler);
  }

public void testValidNames572() { 
     assertTrue(NodeUtil.isValidPropertyName("a")); 
     assertTrue(NodeUtil.isValidPropertyName("a3")); 
     assertFalse(NodeUtil.isValidPropertyName("3a")); 
     assertFalse(NodeUtil.isValidPropertyName("a.")); 
     assertFalse(NodeUtil.isValidPropertyName(".a")); 
     assertFalse(NodeUtil.isValidPropertyName("a.b")); 
     assertFalse(NodeUtil.isValidPropertyName("true")); 
     assertFalse(NodeUtil.isValidPropertyName("a.true")); 
     assertFalse(NodeUtil.isValidPropertyName("a..b")); 
     assertTrue(NodeUtil.isValidSimpleName("a")); 
     assertTrue(NodeUtil.isValidSimpleName("a3")); 
     assertFalse(NodeUtil.isValidSimpleName("3a")); 
     assertFalse(NodeUtil.isValidSimpleName("a.")); 
     assertFalse(NodeUtil.isValidSimpleName(".a")); 
     assertFalse(NodeUtil.isValidSimpleName("a.b")); 
     assertFalse(NodeUtil.isValidSimpleName("true")); 
     assertFalse(NodeUtil.isValidSimpleName("a.true")); 
     assertFalse(NodeUtil.isValidSimpleName("a..b")); 
     assertTrue(NodeUtil.isValidQualifiedName("a")); 
     assertTrue(NodeUtil.isValidQualifiedName("a3")); 
     assertFalse(NodeUtil.isValidQualifiedName("3a")); 
     assertFalse(NodeUtil.isValidQualifiedName("a.")); 
     assertFalse(NodeUtil.isValidQualifiedName(".a")); 
     assertTrue(NodeUtil.isValidQualifiedName("a.b")); 
     assertFalse(NodeUtil.isValidQualifiedName("true")); 
     assertFalse(NodeUtil.isValidQualifiedName("a.true")); 
     assertFalse(NodeUtil.isValidQualifiedName("a..b")); 
 }
public void testRenamePrototypes1607() { 
     test("Bar.prototype={'getFoo':function(){},2:function(){}}", "Bar.prototype={'a':function(){},2:function(){}}"); 
 }
  

  


  

  
}
