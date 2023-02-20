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

import com.google.debugging.sourcemap.SourceMapGeneratorV2.LineMapEncoder;
import com.google.javascript.jscomp.SourceMap;
import com.google.javascript.jscomp.SourceMap.Format;

import java.io.IOException;

/**
 * Tests for {@link SourceMap}.
 *
 */
public class SourceMapGeneratorV2Test extends SourceMapTestCase {

  public SourceMapGeneratorV2Test() {
    disableColumnValidation();
  }

  @Override
  protected SourceMapConsumer getSourceMapConsumer() {
    return new SourceMapConsumerV2();
  }

  @Override
  protected Format getSourceMapFormat() {
    return SourceMap.Format.V2;
  }

  @Override
  public void setUp() {
    detailLevel = SourceMap.DetailLevel.ALL;
  }

public void testGoldenOutput2301() throws Exception { 
     checkSourceMap("function f(foo, bar) {\r\n\n\n\nfoo = foo + bar + foo;" + "\nreturn foo;\n}", "{\n" + "\"version\":2,\n" + "\"file\":\"testcode\",\n" + "\"lineCount\":1,\n" + "\"lineMaps\":[" + "\"cAEBABIBA/ICA+ADICA/ICA+IDA9IEYBMBA5\"],\n" + "\"mappings\":[[0,1,0,0],\n" + "[0,1,9,0],\n" + "[0,1,10],\n" + "[0,1,11,1],\n" + "[0,1,16,2],\n" + "[0,1,21],\n" + "[0,5,0],\n" + "[0,5,0,1],\n" + "[0,5,6,1],\n" + "[0,5,12,2],\n" + "[0,5,18,1],\n" + "[0,6,0],\n" + "[0,6,7,1],\n" + "],\n" + "\"sources\":[\"testcode\"],\n" + "\"names\":[\"f\",\"foo\",\"bar\"]\n" + "}\n"); 
 }
  

  

  

  

  

  

  

  

  

  

  

  

  

  private int getRelativeId(int id, int lastId) {
    int length = LineMapEncoder.getRelativeMappingIdLength(id, lastId);
    int result = LineMapEncoder.getRelativeMappingId(id, length, lastId);
    int inverse = SourceMapLineDecoder.getIdFromRelativeId(
                      result, length, lastId);
    assertEquals(id, inverse);
    return result;
  }

  

  

  private String getEntry(int id, int lastId, int reps) throws IOException {
    StringBuilder sb = new StringBuilder();
    LineMapEncoder.encodeEntry(sb, id, lastId, reps);
    return sb.toString();
  }

  
}
