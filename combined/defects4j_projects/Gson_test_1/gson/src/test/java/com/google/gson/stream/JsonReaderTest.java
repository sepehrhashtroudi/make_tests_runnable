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
import java.io.StringReader;

public final class JsonReaderTest extends TestCase {

public void testNullLiteralIsNotAString13() throws IOException { 
     JsonReader reader = new JsonReader(new StringReader("[null]")); 
     reader.beginArray(); 
     try { 
         reader.nextString(); 
         fail(); 
     } catch (NullPointerException expected) { 
     } 
 }
public void testLenientSemicolonDelimitedArray14() throws IOException { 
     JsonReader reader = new JsonReader(new StringReader("[true;true]")); 
     reader.setLenient(true); 
     reader.beginArray(); 
     assertEquals(true, reader.nextBoolean()); 
     assertEquals(true, reader.nextBoolean()); 
 }
public void testNextFailuresDoNotAdvance15() throws IOException { 
     JsonReader reader = new JsonReader(new StringReader("{\"a\":true}")); 
     reader.beginObject(); 
     try { 
         reader.nextString(); 
         fail(); 
     } catch (IllegalStateException expected) { 
     } 
     assertEquals("a", reader.nextName()); 
     try { 
         reader.nextName(); 
         fail(); 
     } catch (IllegalStateException expected) { 
     } 
     try { 
         reader.beginArray(); 
         fail(); 
     } catch (IllegalStateException expected) { 
     } 
     try { 
         reader.endArray(); 
         fail(); 
     } catch (IllegalStateException expected) { 
     } 
     try { 
         reader.beginObject(); 
         fail(); 
     } catch (IllegalStateException expected) { 
     } 
     try { 
         reader.endObject(); 
         fail(); 
     } catch (IllegalStateException expected) { 
     } 
     assertEquals(true, reader.nextBoolean()); 
     try { 
         reader.nextString(); 
         fail(); 
     } catch (IllegalStateException expected) { 
     } 
     try { 
         reader.nextName(); 
         fail(); 
     } catch (IllegalStateException expected) { 
     } 
     try { 
         reader.beginArray(); 
         fail(); 
     } catch (IllegalStateException expected) { 
     } 
     try { 
         reader.endArray(); 
         fail(); 
     } catch (IllegalStateException expected) { 
     } 
     reader.endObject(); 
     assertEquals(JsonToken.END_DOCUMENT, reader.peek()); 
     reader.close(); 
 }
public void testNullLiteralIsNotAString16() throws IOException { 
     JsonReader reader = new JsonReader(new StringReader("[null]")); 
     reader.beginArray(); 
     try { 
         reader.nextNull(); 
         fail(); 
     } catch (IllegalStateException expected) { 
     } 
 }
public void testDoubles17() throws IOException { 
     String json = "[-0.0," + "1.0," + "1.7976931348623157E308," + "4.9E-324," + "0.0," + "-0.5," + "2.2250738585072014E-308," + "3.141592653589793," + "2.718281828459045]"; 
     JsonReader reader = new JsonReader(new StringReader(json)); 
     reader.beginArray(); 
     assertEquals(-0.0, reader.nextDouble()); 
     assertEquals(1.0, reader.nextDouble()); 
     assertEquals(1.7976931348623157E308, reader.nextDouble()); 
     assertEquals(4.9E-324, reader.nextDouble()); 
     assertEquals(0.0, reader.nextDouble()); 
     assertEquals(-0.5, reader.nextDouble()); 
     assertEquals(2.2250738585072014E-308, reader.nextDouble()); 
     assertEquals(3.141592653589793, reader.nextDouble()); 
     assertEquals(2.718281828459045, reader.nextDouble()); 
     reader.endArray(); 
     assertEquals(JsonToken.END_DOCUMENT, reader.peek()); 
 }
public void testReadEmptyObject19() throws IOException { 
     JsonReader reader = new JsonReader(new StringReader("{}")); 
     reader.beginObject(); 
     assertFalse(reader.hasNext()); 
     reader.endObject(); 
     assertEquals(JsonToken.END_DOCUMENT, reader.peek()); 
 }
public void testStrictSingleQuotedNames20() throws IOException { 
     JsonReader reader = new JsonReader(new StringReader("{'a':true}")); 
     reader.beginObject(); 
     try { 
         reader.nextName(); 
         fail(); 
     } catch (IOException expected) { 
     } 
 }
public void testSkipObject21() throws IOException { 
     JsonReader reader = new JsonReader(new StringReader("{\"a\": { \"c\": [], \"d\": [true, true, {}] }, \"b\": \"banana\"}")); 
     reader.beginObject(); 
     assertEquals("a", reader.nextName()); 
     reader.skipValue(); 
     assertEquals("b", reader.nextName()); 
     reader.skipValue(); 
     reader.endObject(); 
     assertEquals(JsonToken.END_DOCUMENT, reader.peek()); 
 }
public void testLenientComments22() throws IOException { 
     JsonReader reader = new JsonReader(new StringReader("[// comment \n true]")); 
     reader.setLenient(true); 
     reader.beginArray(); 
     assertEquals(true, reader.nextBoolean()); 
     reader = new JsonReader(new StringReader("[# comment \n true]")); 
     reader.setLenient(true); 
     reader.beginArray(); 
     assertEquals(true, reader.nextBoolean()); 
     reader = new JsonReader(new StringReader("[/* comment */ true]")); 
     reader.setLenient(true); 
     reader.beginArray(); 
     assertEquals(true, reader.nextBoolean()); 
 }
public void testPrematureEndOfInput23() throws IOException { 
     JsonReader reader = new JsonReader(new StringReader("{\"a\":true,")); 
     reader.beginObject(); 
     assertEquals("a", reader.nextName()); 
     assertEquals(true, reader.nextBoolean()); 
     try { 
         reader.nextName(); 
         fail(); 
     } catch (IOException expected) { 
     } 
 }
public void testNullLiteralIsNotAString25() throws IOException { 
     JsonReader reader = new JsonReader(new StringReader("[null]")); 
     reader.beginArray(); 
     try { 
         reader.nextString(); 
         fail(); 
     } catch (IllegalStateException expected) { 
     } 
 }
  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  /**
   * This test fails because there's no double for 9223372036854775806, and
   * our long parsing uses Double.parseDouble() for fractional values.
   */
  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  
}
