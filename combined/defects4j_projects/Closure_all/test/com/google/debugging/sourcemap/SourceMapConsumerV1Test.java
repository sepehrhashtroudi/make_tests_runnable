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


public void testParseSourceMetaMap14() throws Exception { 
     final String INPUT1 = "file1"; 
     final String INPUT2 = "file2"; 
     LinkedHashMap<String, String> inputs = Maps.newLinkedHashMap(); 
     inputs.put(INPUT1, "var __FOO__ = 1;"); 
     inputs.put(INPUT2, "var __BAR__ = 2;"); 
     RunResult result1 = compile(inputs.get(INPUT1), INPUT1); 
     RunResult result2 = compile(inputs.get(INPUT2), INPUT2); 
     final String MAP1 = "map1"; 
     final String MAP2 = "map2"; 
     final LinkedHashMap<String, String> maps = Maps.newLinkedHashMap(); 
     maps.put(MAP1, result1.sourceMapFileContent); 
     maps.put(MAP2, result2.sourceMapFileContent); 
     List<SourceMapSection> sections = Lists.newArrayList(); 
     StringBuilder output = new StringBuilder(); 
     FilePosition offset = appendAndCount(output, result1.generatedSource); 
     sections.add(SourceMapSection.forURL(MAP1, 0, 0)); 
     output.append(result2.generatedSource); 
     sections.add(SourceMapSection.forURL(MAP2, offset.getLine(), offset.getColumn())); 
     SourceMapGeneratorV3 generator = new SourceMapGeneratorV3(); 
     StringBuilder mapContents = new StringBuilder(); 
     generator.appendIndexMapTo(mapContents, "out.js", sections); 
     check(inputs, output.toString(), mapContents.toString(), new SourceMapSupplier() { 
  
         @Override 
         public String getSourceMap(String url) { 
             return maps.get(url); 
         } 
     }); 
 }


public void testGetMappingForLineWithNameIndex127() throws Exception { 
     String mapData = "{\n" + "\"version\":2,\n" + "\"file\":\"testcode\",\n" + "\"lineCount\":1,\n" + "\"lineMaps\":" + "[\"cAEBABIBA/ICA+ADICA/ICA+IDA9AEYBMBA5\"],\n" + "\"sources\":[\"testcode\"],\n" + "\"names\": [\"f\"],\n" + "\"mappings\":[[0,1,9,0],\n" + "[0,1,9,0]\n" + "]\n" + "}\n"; 
     SourceMapConsumerV2 sourceMap = new SourceMapConsumerV2(); 
     sourceMap.parse(mapData); 
     OriginalMapping mapping = sourceMap.getMappingForLine(1, 10); 
     assertNotNull(mapping); 
     assertEquals("testcode", mapping.getOriginalFile()); 
     assertEquals(1, mapping.getLineNumber()); 
     assertEquals(9, mapping.getColumnPosition()); 
     assertEquals("f", mapping.getIdentifier()); 
 }


public void testBasicDeterminism128() throws Exception { 
     RunResult result1 = compile("file1", "{\n" + "\"version\":2,\n" + "\"file\":\"testcode\",\n" + "\"lineCount\":1,\n" + "\"lineMaps\":[" + "\"cAEBABIBA/ICA+ADICA/ICA+IDA9IEYBMBA5\"],\n" + "\"mappings\":[[0,1,0,0],\n" + "[0,1,9,0],\n" + "[0,1,10],\n" + "[0,1,11,1],\n" + "[0,1,16,2],\n" + "[0,1,21],\n" + "[0,5,0],\n" + "[0,5,0,1],\n" + "[0,5,6,1],\n" + "[0,5,12,2],\n" + "[0,5,18,1],\n" + "[0,6,0],\n" + "[0,6,7,1],\n" + "],\n" + "\"sources\":[\"testcode\"],\n" + "\"names\":[\"f\",\"foo\",\"bar\"]\n" + "}\n"); 
     RunResult result2 = compile("file2", "{\n" + "\"version\":2,\n" + "\"file\":\"testcode\",\n" + "\"lineCount\":1,\n" + "\"lineMaps\":[\"cAEBABIBA/ICA+IDE9IEA8IFA7IGg6MHA5\"],\n" + "\"mappings\":[[0,5,6,0],\n" + "[0,5,12,2],\n" + "[0,6,7,1],\n" + "[0,6,7,1],\n" + "[0,6,7,1],\n" + "[0,6,7,1],\n" + "[0,6,7,1],\n" + "[0,6,7,1],\n" + "[0,6,7,1


public void testSplitCommaExpressions129() throws Exception { 
     late = false; 
     foldSame("while (foo(), !0) boo()"); 
     foldSame("var a = (foo(), !0);"); 
     foldSame("a = (foo(), !0);"); 
     foldSame("a:a(),b()"); 
     fold("(x=2), foo()", "x=2; foo()"); 
     fold("foo(), boo();", "foo(); boo()"); 
     fold("(a(), b()), (c(), d());", "a(); b(); (c(), d());"); 
     fold("a(); b(); (c(), d());", "a(); b(); c(); d();"); 
     fold("foo(), true", "foo();true"); 
     fold("foo();true", "foo();1"); 
     fold("function x(){foo(), !0}", "function x(){foo(); !0}"); 
     fold("function x(){foo(); !0}", "function x(){foo(); 1}"); 
 }


public void testValidSourceMap130() throws Exception { 
     final String INPUT1 = "file1"; 
     final String INPUT2 = "file2"; 
     LinkedHashMap<String, String> inputs = Maps.newLinkedHashMap(); 
     inputs.put(INPUT1, "var __FOO__ = 1;"); 
     inputs.put(INPUT2, "var __BAR__ = 2;"); 
     RunResult result1 = compile(inputs.get(INPUT1), INPUT1); 
     RunResult result2 = compile(inputs.get(INPUT2), INPUT2); 
     final String MAP1 = "map1"; 
     final String MAP2 = "map2"; 
     final LinkedHashMap<String, String> maps = Maps.newLinkedHashMap(); 
     maps.put(MAP1, result1.sourceMapFileContent); 
     maps.put(MAP2, result2.sourceMapFileContent); 
     List<SourceMapSection> sections = Lists.newArrayList(); 
     StringBuilder output = new StringBuilder(); 
     FilePosition offset = appendAndCount(output, result1.generatedSource); 
     sections.add(SourceMapSection.forURL(MAP1, 0, 0)); 
     output.append(result2.generatedSource); 
     sections.add(SourceMapSection.forURL(MAP2, offset.getLine(), offset.getColumn())); 
     SourceMapGeneratorV3 generator = new SourceMapGeneratorV3(); 
     StringBuilder mapContents = new StringBuilder(); 
     generator.appendIndexMapTo(mapContents, "out.js", sections); 
     check(inputs, output.toString(), mapContents.toString(), new SourceMapSupplier() { 
  
         @Override 
         public String getSourceMap(String url) { 
             return maps.get(url); 
         } 
     }); 
 }


public void testInvalidHeaderFailure131() throws Exception { 
     StringBuilder sb = new StringBuilder(); 
     sb.append("/** Begin line maps. **/{ count : 1 }\n"); 
     sb.append("[0,,,1]\n"); 
     sb.append("[3,,,4]\n"); 
     sb.append("[5,,,6]\n"); 
     assertException("Expected /** Begin file information. **/ got [3,,,4]\n", sb); 
 }


public void testInvalidCountFailure132() throws Exception { 
     StringBuilder sb = new StringBuilder(); 
     sb.append("/** Begin line maps. **/{ count : 0 }\n"); 
     sb.append("[0,,,1]\n"); 
     sb.append("[3,,,4]\n"); 
     sb.append("[5,,,6]\n"); 
     assertException("Expected /** Begin file information. **/ got [3,,,4]\n", sb); 
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
