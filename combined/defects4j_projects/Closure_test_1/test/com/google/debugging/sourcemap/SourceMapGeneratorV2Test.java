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

public void testEncoding386() throws IOException { 
     assertEquals("AA", getEntry(0, 0, 1)); 
     assertEquals("EA", getEntry(0, 0, 2)); 
     assertEquals("8A", getEntry(0, 0, 16)); 
     assertEquals("!AQA", getEntry(0, 0, 17)); 
     assertEquals("!ARA", getEntry(0, 0, 18)); 
     assertEquals("!A+A", getEntry(0, 0, 63)); 
     assertEquals("!A/A", getEntry(0, 0, 64)); 
     assertEquals("!!ABAA", getEntry(0, 0, 65)); 
     assertEquals("!!A//A", getEntry(0, 0, 4096)); 
     assertEquals("!!!ABAAA", getEntry(0, 0, 4097)); 
     assertEquals("Af", getEntry(31, 0, 1)); 
     assertEquals("BAg", getEntry(32, 0, 1)); 
     assertEquals("AB", getEntry(32, 31, 1)); 
     assertEquals("!AQf", getEntry(31, 0, 17)); 
     assertEquals("!BQAg", getEntry(32, 0, 17)); 
     assertEquals("!AQB", getEntry(32, 31, 17)); 
     assertEquals("!A/B", getEntry(32, 31, 64)); 
     assertEquals("!!ABAB", getEntry(32, 31, 65)); 
 }
public void testBasicMapping546() throws Exception { 
     compileAndCheck("function __BASIC__() { }"); 
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
