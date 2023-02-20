/*
 * Copyright 2009 The Closure Compiler Authors.
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

package com.google.debugging.sourcemap;

import com.google.debugging.sourcemap.SourceMapConsumerV1;
import com.google.debugging.sourcemap.SourceMapParseException;
import com.google.debugging.sourcemap.proto.Mapping.OriginalMapping;

import junit.framework.TestCase;

public class SourceMapConsumerV1Test extends TestCase {

  public SourceMapConsumerV1Test() {
  }

  public SourceMapConsumerV1Test(String name) {
    super(name);
  }

public void testMultipleLineFragments318() throws Exception { 
     StringBuilder sb = new StringBuilder(); 
     sb.append("/** Begin line maps. **/{ count : 1 }\n"); 
     sb.append("[0,1,2,3,260,261,262]\n"); 
     sb.append("/** Begin file information. **/\n"); 
     sb.append("\n"); 
     sb.append("/** Begin mapping definitions. **/\n"); 
     for (int i = 0; i < 262; i++) { 
         sb.append("['frog/test" + i + ".js', " + i + ", 1]\n"); 
     } 
     sb.append("['frog/testigloo.js', 500, 1]"); 
     SourceMapConsumerV1 sourceMap = new SourceMapConsumerV1(); 
     sourceMap.parse(sb.toString()); 
     OriginalMapping mapping = sourceMap.getMappingForLine(1, 1); 
     assertNotNull(mapping); 
     assertEquals("frog/test0.js", mapping.getOriginalFile()); 
     assertEquals(0, mapping.getLineNumber()); 
     assertEquals(1, mapping.getColumnPosition()); 
     assertEquals("", mapping.getIdentifier()); 
     mapping = sourceMap.getMappingForLine(1, 6); 
     assertNotNull(mapping); 
     assertEquals("frog/test261.js", mapping.getOriginalFile()); 
     assertEquals(261, mapping.getLineNumber()); 
     assertEquals(1, mapping.getColumnPosition()); 
 }
  

  

  

  

  

  

  

  

  

  

  

  

  

  

  private void assertException(String exception, StringBuilder sb) {
    boolean exceptionRaised = false;

    try {
      SourceMapConsumerV1 sourceMap = new SourceMapConsumerV1();
      sourceMap.parse(sb.toString());

    } catch (SourceMapParseException pe) {
      assertEquals(exception, pe.getMessage());
      exceptionRaised = true;
    }

    assertTrue(exceptionRaised);
  }

  private void assertExceptionStartsWith(String exception, StringBuilder sb) {
    boolean exceptionRaised = false;

    try {
      SourceMapConsumerV1 sourceMap = new SourceMapConsumerV1();
      sourceMap.parse(sb.toString());

    } catch (SourceMapParseException pe) {
      assertTrue(
        "expected <" + exception +"> but was <"+ pe.getMessage() +">",
        pe.getMessage().startsWith(exception));
      exceptionRaised = true;
    }

    assertTrue(exceptionRaised);
  }

}
