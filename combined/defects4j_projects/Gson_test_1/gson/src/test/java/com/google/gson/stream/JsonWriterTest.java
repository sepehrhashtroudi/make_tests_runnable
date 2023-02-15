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

public void testPrettyPrintArray5() throws IOException { 
     StringWriter stringWriter = new StringWriter(); 
     JsonWriter jsonWriter = new JsonWriter(stringWriter); 
     jsonWriter.setIndent("   "); 
     jsonWriter.beginArray(); 
     jsonWriter.value(true); 
     jsonWriter.value(false); 
     jsonWriter.value(5.0); 
     jsonWriter.nullValue(); 
     jsonWriter.beginObject(); 
     jsonWriter.name("a").value(6.0); 
     jsonWriter.name("b").value(7.0); 
     jsonWriter.endObject(); 
     jsonWriter.beginArray(); 
     jsonWriter.value(8.0); 
     jsonWriter.value(9.0); 
     jsonWriter.endArray(); 
     jsonWriter.endArray(); 
     String expected = "[\n" + "   true,\n" + "   false,\n" + "   5.0,\n" + "   null,\n" + "   {\n" + "      \"a\": 6.0,\n" + "      \"b\": 7.0\n" + "   },\n" + "   [\n" + "      8.0,\n" + "      9.0\n" + "   ]\n" + "]"; 
     assertEquals(expected, stringWriter.toString()); 
 }
public void testEmptyArray6() throws IOException { 
     StringWriter stringWriter = new StringWriter(); 
     JsonWriter jsonWriter = new JsonWriter(stringWriter); 
     jsonWriter.beginArray(); 
     jsonWriter.endArray(); 
     assertEquals("[]", stringWriter.toString()); 
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
public void testTwoNames8() throws IOException { 
     StringWriter stringWriter = new StringWriter(); 
     JsonWriter jsonWriter = new JsonWriter(stringWriter); 
     jsonWriter.beginObject(); 
     jsonWriter.name("a"); 
     try { 
         jsonWriter.name("a"); 
         fail(); 
     } catch (IllegalStateException expected) { 
     } 
 }
public void testObjectsInArrays9() throws IOException { 
     StringWriter stringWriter = new StringWriter(); 
     JsonWriter jsonWriter = new JsonWriter(stringWriter); 
     jsonWriter.beginArray(); 
     jsonWriter.beginObject(); 
     jsonWriter.name("a").value(5); 
     jsonWriter.name("b").value(false); 
     jsonWriter.endObject(); 
     jsonWriter.beginObject(); 
     jsonWriter.name("c").value(6); 
     jsonWriter.name("d").value(true); 
     jsonWriter.endObject(); 
     jsonWriter.endArray(); 
     assertEquals("[{\"a\":5,\"b\":false}," + "{\"c\":6,\"d\":true}]", stringWriter.toString()); 
 }
public void testPeekEmptyObject10() throws IOException { 
     StringWriter stringWriter = new StringWriter(); 
     JsonWriter jsonWriter = new JsonWriter(stringWriter); 
     jsonWriter.beginObject(); 
     jsonWriter.endObject(); 
     assertEquals("{}", stringWriter.toString()); 
 }
public void testNonFiniteBoxedDoubles11() throws IOException { 
     StringWriter stringWriter = new StringWriter(); 
     JsonWriter jsonWriter = new JsonWriter(stringWriter); 
     jsonWriter.beginArray(); 
     try { 
         jsonWriter.value(new Double(Double.NaN)); 
         fail(); 
     } catch (IllegalArgumentException expected) { 
     } 
     try { 
         jsonWriter.value(new Double(Double.NEGATIVE_INFINITY)); 
         fail(); 
     } catch (IllegalArgumentException expected) { 
     } 
     try { 
         jsonWriter.value(new Double(Double.POSITIVE_INFINITY)); 
         fail(); 
     } catch (IllegalArgumentException expected) { 
     } 
 }
  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  
}
