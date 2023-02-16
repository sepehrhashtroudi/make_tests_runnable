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
package com.google.gson.functional;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonStreamParser;
import com.google.gson.common.TestTypes.BagOfPrimitives;

import junit.framework.TestCase;

import java.io.CharArrayReader;
import java.io.CharArrayWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;

/**
 * Functional tests for the support of {@link Reader}s and {@link Writer}s.
 *
 * @author Inderjeet Singh
 * @author Joel Leitch
 */
public class ReadersWritersTest extends TestCase {
  private Gson gson;

  @Override
  protected void setUp() throws Exception {
    super.setUp();
    gson = new Gson();
  }


public void testReadWriteTwoObjects135() throws IOException { 
     Gson gson = new Gson(); 
     CharArrayWriter writer = new CharArrayWriter(); 
     BagOfPrimitives expectedOne = new BagOfPrimitives(1, 1, true, "one"); 
     writer.write(gson.toJson(expectedOne).toCharArray()); 
     BagOfPrimitives expectedTwo = new BagOfPrimitives(2, 2, false, "two"); 
     writer.write(gson.toJson(expectedTwo).toCharArray()); 
     CharArrayReader reader = new CharArrayReader(writer.toCharArray()); 
     JsonStreamParser parser = new JsonStreamParser(reader); 
     BagOfPrimitives actualOne = gson.fromJson(parser.next(), BagOfPrimitives.class); 
     assertEquals("one", actualOne.stringValue); 
     BagOfPrimitives actualTwo = gson.fromJson(parser.next(), BagOfPrimitives.class); 
     assertEquals("two", actualTwo.stringValue); 
     assertFalse(parser.hasNext()); 
 } 


public void testWriterForSerialization157() throws Exception { 
     Writer writer = new StringWriter(); 
     BagOfPrimitives src = new BagOfPrimitives(); 
     gson.toJson(src, writer); 
     assertEquals(src.getExpectedJson(), writer.toString()); 
 } 


public void testReaderForDeserialization161() throws Exception { 
     BagOfPrimitives expected = new BagOfPrimitives(); 
     Reader json = new StringReader(expected.getExpectedJson()); 
     BagOfPrimitives actual = gson.fromJson(json, BagOfPrimitives.class); 
     assertEquals(expected, actual); 
 } 

  

  

  

  

  

  
  
  
  
  
}
