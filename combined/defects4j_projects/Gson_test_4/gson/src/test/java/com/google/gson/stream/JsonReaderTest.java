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

public void testLenientUnnecessaryArraySeparators9() throws IOException { 
     JsonReader reader = new JsonReader(new StringReader("[true,,true]")); 
     reader.setLenient(true); 
     reader.beginArray(); 
     assertEquals(true, reader.nextBoolean()); 
     reader.nextNull(); 
     assertEquals(true, reader.nextBoolean()); 
     reader.endArray(); 
     reader = new JsonReader(new StringReader("[,true]")); 
     reader.setLenient(true); 
     reader.beginArray(); 
     assertEquals(true, reader.nextBoolean()); 
     reader.nextNull(); 
     assertEquals(true, reader.nextBoolean()); 
     reader.endArray(); 
 }
public void testLenientComments10() throws IOException { 
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
public void testLenientUnnecessaryArraySeparators11() throws IOException { 
     JsonReader reader = new JsonReader(new StringReader("[true,,true]")); 
     reader.setLenient(true); 
     reader.beginArray(); 
     assertEquals(true, reader.nextBoolean()); 
     reader.nextNull(); 
     assertEquals(true, reader.nextBoolean()); 
     reader.endArray(); 
     reader = new JsonReader(new StringReader("[,true]")); 
     reader.setLenient(true); 
     reader.beginArray(); 
     assertEquals(true, reader.nextBoolean()); 
     reader.nextNull(); 
     assertEquals(true, reader.nextBoolean()); 
 }
public void testStrictSingleQuotedStrings12() throws IOException { 
     JsonReader reader = new JsonReader(new StringReader("['a']")); 
     reader.beginArray(); 
     try { 
         reader.nextString(); 
         fail(); 
     } catch (IOException expected) { 
     } 
 }
public void testLenientUnnecessaryArraySeparators13() throws IOException { 
     JsonReader reader = new JsonReader(new StringReader("[true,,true]")); 
     reader.setLenient(true); 
     reader.beginArray(); 
     assertEquals(true, reader.nextBoolean()); 
     reader.nextNull(); 
     assertEquals(true, reader.nextBoolean()); 
     reader.endArray(); 
     reader = new JsonReader(new StringReader("[,true]")); 
     reader.setLenient(true); 
     reader.beginArray(); 
     assertEquals(true, reader.nextBoolean()); 
     reader.nextNull(); 
     assertEquals(true, reader.nextBoolean()); 
     reader.endArray(); 
     reader = new JsonReader(new StringReader("[true,]")); 
     reader.setLenient(true); 
     reader.beginArray(); 
     assertEquals(true, reader.nextBoolean()); 
 }
public void testPrematureEndOfInput14() throws IOException { 
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
public void testStrictSingleQuotedNames15() throws IOException { 
     JsonReader reader = new JsonReader(new StringReader("{'a':true}")); 
     reader.beginObject(); 
     try { 
         reader.nextName(); 
         fail(); 
     } catch (IllegalStateException expected) { 
     } 
 }
public void testNumberWithOctalPrefix16() throws IOException { 
     String json = "[01]"; 
     JsonReader reader = new JsonReader(new StringReader(json)); 
     reader.beginArray(); 
     try { 
         reader.nextInt(); 
         fail(); 
     } catch (NumberFormatException expected) { 
     } 
     try { 
         reader.nextLong(); 
         fail(); 
     } catch (NumberFormatException expected) { 
     } 
     try { 
         reader.nextDouble(); 
         fail(); 
     } catch (NumberFormatException expected) { 
     } 
     assertEquals("01", reader.nextString()); 
     reader.endArray(); 
     assertEquals(JsonToken.END_DOCUMENT, reader.peek()); 
 }
public void testLenientUnnecessaryArraySeparators17() throws IOException { 
     JsonReader reader = new JsonReader(new StringReader("[true,,true]")); 
     reader.setLenient(true); 
     reader.beginArray(); 
     assertEquals(true, reader.nextBoolean()); 
     reader.nextNull(); 
     assertEquals(true, reader.nextBoolean()); 
     reader.endArray(); 
     reader = new JsonReader(new StringReader("[,true]")); 
     reader.setLenient(true); 
     reader.beginArray(); 
     reader.nextNull(); 
     assertEquals(true, reader.nextBoolean()); 
     reader.endArray(); 
     reader = new JsonReader(new StringReader("[true,]")); 
     reader.setLenient(true); 
     reader.beginArray(); 
     assertEquals(true, reader.nextBoolean()); 
 }
public void testLenientUnnecessaryArraySeparators18() throws IOException { 
     JsonReader reader = new JsonReader(new StringReader("[true,,true]")); 
     reader.setLenient(true); 
     reader.beginArray(); 
     assertEquals(true, reader.nextBoolean()); 
     reader.nextNull(); 
     assertEquals(true, reader.nextBoolean()); 
     reader.endArray(); 
     reader = new JsonReader(new StringReader("[,true]")); 
     reader.setLenient(true); 
     reader.beginArray(); 
     reader.nextNull(); 
     assertEquals(true, reader.nextBoolean()); 
     reader.endArray(); 
     reader = new JsonReader(new StringReader("[true,]")); 
     reader.setLenient(true); 
     reader.beginArray(); 
     assertEquals(true, reader.nextBoolean()); 
     reader.nextNull(); 
     reader.endArray(); 
 }
public void testLenientUnquotedNames19() throws IOException { 
     JsonReader reader = new JsonReader(new StringReader("{a:true}")); 
     reader.setLenient(true); 
     reader.beginObject(); 
     assertEquals("a", reader.nextName()); 
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
public void testLenientUnquotedStrings22() throws IOException { 
     JsonReader reader = new JsonReader(new StringReader("[a]")); 
     reader.setLenient(true); 
     reader.beginArray(); 
     assertEquals("a", reader.nextString()); 
 }
  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  /**
   * This test fails because there's no double for 9223372036854775806, and
   * our long parsing uses Double.parseDouble() for fractional values.
   */
  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  
}
