/*
 * Copyright (C) 2010 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.gson.stream;

import junit.framework.TestCase;

import java.io.IOException;
import java.io.StringWriter;
import java.math.BigDecimal;
import java.math.BigInteger;

public final class JsonWriterTest extends TestCase {

public void testNullName5() throws IOException { 
     StringWriter stringWriter = new StringWriter(); 
     JsonWriter jsonWriter = new JsonWriter(stringWriter); 
     jsonWriter.beginArray(); 
     try { 
         jsonWriter.name(null); 
         fail(); 
     } catch (NullPointerException expected) { 
     } 
 }
public void testStrings6() throws IOException { 
     StringWriter stringWriter = new StringWriter(); 
     JsonWriter jsonWriter = new JsonWriter(stringWriter); 
     jsonWriter.beginArray(); 
     jsonWriter.value("a"); 
     jsonWriter.value("a\""); 
     jsonWriter.value("\""); 
     jsonWriter.value(":"); 
     jsonWriter.value(","); 
     jsonWriter.value("\b"); 
     jsonWriter.value("\f"); 
     jsonWriter.value("\n"); 
     jsonWriter.value("\r"); 
     jsonWriter.value("\t"); 
     jsonWriter.value(" "); 
     jsonWriter.value("\\"); 
     jsonWriter.value("{"); 
     jsonWriter.value("}"); 
     jsonWriter.value("["); 
     jsonWriter.value("]"); 
     jsonWriter.value("\0"); 
     jsonWriter.value("\u0019"); 
     jsonWriter.endArray(); 
     assertEquals("[\"a\"," + "\"a\\\"\"," + "\"\\\"\"," + "\":\"," + "\",\"," + "\"\\b\"," + "\"\\f\"," + "\"\\n\"," + "\"\\r\"," + "\"\\t\"," + "\" \"," + "\"\\\\\"," + "\"{\"," + "\"}\"," + "\"[\"," + "\"]\"," + "\"\\u0000\"," + "\"\\u0019\"]", stringWriter.toString()); 
 }
public void testDoubles7() throws IOException { 
     StringWriter stringWriter = new StringWriter(); 
     JsonWriter jsonWriter = new JsonWriter(stringWriter); 
     jsonWriter.beginArray(); 
     jsonWriter.value(-0.0); 
     jsonWriter.value(1.0); 
     jsonWriter.value(Double.MAX_VALUE); 
     jsonWriter.value(Double.MIN_VALUE); 
     jsonWriter.value(0.0); 
     jsonWriter.value(-0.5); 
     jsonWriter.value(2.2250738585072014E-308); 
     jsonWriter.value(Math.PI); 
     jsonWriter.value(Math.E); 
     jsonWriter.endArray(); 
     jsonWriter.close(); 
     assertEquals("[-0.0," + "1.0," + "1.7976931348623157E308," + "4.9E-324," + "0.0," + "-0.5," + "2.2250738585072014E-308," + "3.141592653589793," + "2.718281828459045]", stringWriter.toString()); 
 }
  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  
}
