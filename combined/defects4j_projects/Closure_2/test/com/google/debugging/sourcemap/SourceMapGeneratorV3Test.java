/*
 * Copyright 2011 The Closure Compiler Authors.
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

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.javascript.jscomp.SourceMap;
import com.google.javascript.jscomp.SourceMap.Format;

import java.io.IOException;
import java.io.StringWriter;
import java.util.LinkedHashMap;
import java.util.List;


/**
 * @author johnlenz@google.com (John Lenz)
 */
public class SourceMapGeneratorV3Test extends SourceMapTestCase {

  public SourceMapGeneratorV3Test() {
  }

  @Override
  protected SourceMapConsumer getSourceMapConsumer() {
    return new SourceMapConsumerV3();
  }

  @Override
  protected Format getSourceMapFormat() {
    return SourceMap.Format.V3;
  }

public void testParseSourceMetaMap53() throws Exception { 
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
public void testFunctionNameOutput2153() throws Exception { 
     checkSourceMap("a.b.c = function () {};", "/** Begin line maps. **/{ \"file\" : \"testcode\", " + "\"count\": 1 }\n" + "[3,2,2,1,1,0,4,4,4,4,4,4,4,4,5,5,6,6]\n" + "/** Begin file information. **/\n" + "[]\n" + "/** Begin mapping definitions. **/\n" + "[\"testcode\",1,0]\n" + "[\"testcode\",1,0,\"c\"]\n" + "[\"testcode\",1,0,\"b\"]\n" + "[\"testcode\",1,0,\"a\"]\n" + "[\"testcode\",1,8,\"a.b.c\"]\n" + "[\"testcode\",1,17]\n" + "[\"testcode\",1,20]\n"); 
 }
public void testGoldenOutput2327() throws Exception { 
     checkSourceMap("function f(foo, bar) { foo = foo + bar + 2; return foo; }", "{\n" + "\"version\":2,\n" + "\"file\":\"testcode\",\n" + "\"lineCount\":1,\n" + "\"lineMaps\":[\"cAEBABIBA/ICA+ADICA/ICA+IDA9AEYBMBA5\"],\n" + "\"mappings\":[[0,1,0,0],\n" + "[0,1,9,0],\n" + "[0,1,10],\n" + "[0,1,11,1],\n" + "[0,1,16,2],\n" + "[0,1,21],\n" + "[0,1,23],\n" + "[0,1,23,1],\n" + "[0,1,29,1],\n" + "[0,1,35,2],\n" + "[0,1,41],\n" + "[0,1,44],\n" + "[0,1,51,1],\n" + "],\n" + "\"sources\":[\"testcode\"],\n" + "\"names\":[\"f\",\"foo\",\"bar\"]\n" + "}\n"); 
 }
  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  private String getEmptyMapFor(String name) throws IOException {
    StringWriter out = new StringWriter();
    SourceMapGeneratorV3 generator = new SourceMapGeneratorV3();
    generator.appendTo(out, name);
    return out.toString();
  }

  

  

  

  FilePosition count(String js) {
    int line = 0, column = 0;
    for (int i = 0; i < js.length(); i++) {
      if (js.charAt(i) == '\n') {
        line++;
        column = 0;
      } else {
        column++;
      }
    }
    return new FilePosition(line, column);
  }

  FilePosition appendAndCount(Appendable out, String js) throws IOException {
    out.append(js);
    return count(js);
  }
}
