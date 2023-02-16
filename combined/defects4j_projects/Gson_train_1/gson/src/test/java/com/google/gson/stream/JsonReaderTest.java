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


public void testLenientSemicolonDelimitedArray48() throws IOException { 
     JsonReader reader = new JsonReader(new StringReader("[true;true]")); 
     reader.setLenient(true); 
     reader.beginArray(); 
     assertEquals(true, reader.nextBoolean()); 
     assertEquals(true, reader.nextBoolean()); 
 } 


public void testDoubles50() throws IOException { 
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


public void testReadEmptyObject51() throws IOException { 
     JsonReader reader = new JsonReader(new StringReader("{}")); 
     reader.beginObject(); 
     assertFalse(reader.hasNext()); 
     reader.endObject(); 
     assertEquals(JsonToken.END_DOCUMENT, reader.peek()); 
 } 


public void testNextFailuresDoNotAdvance52() throws IOException { 
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


public void testNullLiteralIsNotAString53() throws IOException { 
     JsonReader reader = new JsonReader(new StringReader("[null]")); 
     reader.beginArray(); 
     try { 
         reader.nextString(); 
         fail(); 
     } catch (IllegalStateException expected) { 
     } 
 } 


public void testStrictNonExecutePrefix54() { 
     JsonReader reader = new JsonReader(new StringReader(")]}'\n []")); 
     try { 
         reader.beginArray(); 
         fail(); 
     } catch (IOException expected) { 
     } 
 } 


public void testPrematureEndOfInput55() throws IOException { 
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


public void testStrictMultipleTopLevelValues56() throws IOException { 
     JsonReader reader = new JsonReader(new StringReader("[] []")); 
     reader.beginArray(); 
     reader.endArray(); 
     try { 
         reader.peek(); 
         fail(); 
     } catch (IOException expected) { 
     } 
 } 


public void testLenientMultipleTopLevelValues57() throws IOException { 
     JsonReader reader = new JsonReader(new StringReader("[] true {}")); 
     reader.setLenient(true); 
     reader.beginArray(); 
     reader.endArray(); 
     assertEquals(true, reader.nextBoolean()); 
     reader.beginObject(); 
     reader.endObject(); 
     assertEquals(JsonToken.END_DOCUMENT, reader.peek()); 
 } 


public void testPrematurelyClosed58() throws IOException { 
     try { 
         JsonReader reader = new JsonReader(new StringReader("{\"a\":[]}")); 
         reader.beginObject(); 
         reader.close(); 
         reader.nextName(); 
         fail(); 
     } catch (IllegalStateException expected) { 
     } 
     try { 
         JsonReader reader = new JsonReader(new StringReader("{\"a\":[]}")); 
         reader.close(); 
         reader.beginObject(); 
         fail(); 
     } catch (IllegalStateException expected) { 
     } 
     try { 
         JsonReader reader = new JsonReader(new StringReader("{\"a\":true}")); 
         reader.beginObject(); 
         reader.nextName(); 
         reader.peek(); 
         reader.close(); 
         reader.nextBoolean(); 
         fail(); 
     } catch (IllegalStateException expected) { 
     } 
 } 


public void testLenientNonExecutePrefixWithLeadingWhitespace59() throws IOException { 
     JsonReader reader = new JsonReader(new StringReader("\r\n \t)]}'\n []")); 
     reader.setLenient(true); 
     reader.beginArray(); 
     reader.endArray(); 
     assertEquals(JsonToken.END_DOCUMENT, reader.peek()); 
 } 


public void testStrictSingleQuotedNames60() throws IOException { 
     JsonReader reader = new JsonReader(new StringReader("{'a':true}")); 
     reader.beginObject(); 
     try { 
         reader.nextName(); 
         fail(); 
     } catch (IOException expected) { 
     } 
 } 


public void testLenientSingleQuotedStrings61() throws IOException { 
     JsonReader reader = new JsonReader(new StringReader("['a']")); 
     reader.setLenient(true); 
     reader.beginArray(); 
     assertEquals("a", reader.nextString()); 
 } 


public void testMixedCaseLiterals62() throws IOException { 
     JsonReader reader = new JsonReader(new StringReader("[True,TruE,False,FALSE,NULL,nulL]")); 
     reader.beginArray(); 
     assertEquals(true, reader.nextBoolean()); 
     assertEquals(true, reader.nextBoolean()); 
     assertEquals(false, reader.nextBoolean()); 
     assertEquals(false, reader.nextBoolean()); 
     reader.nextNull(); 
     reader.nextNull(); 
     reader.endArray(); 
     assertEquals(JsonToken.END_DOCUMENT, reader.peek()); 
 } 


public void testStringNullIsNotNull63() throws IOException { 
     JsonReader reader = new JsonReader(new StringReader("[\"null\"]")); 
     reader.beginArray(); 
     try { 
         reader.nextNull(); 
         fail(); 
     } catch (IllegalStateException expected) { 
     } 
 } 


public void testSkipObject64() throws IOException { 
     JsonReader reader = new JsonReader(new StringReader("{\"a\": { \"c\": [], \"d\": [true, true, {}] }, \"b\": \"banana\"}")); 
     reader.beginObject(); 
     assertEquals("a", reader.nextName()); 
     reader.skipValue(); 
     assertEquals("b", reader.nextName()); 
     reader.skipValue(); 
     reader.endObject(); 
     assertEquals(JsonToken.END_DOCUMENT, reader.peek()); 
 } 


public void testLenientSemicolonDelimitedNameValuePair65() throws IOException { 
     JsonReader reader = new JsonReader(new StringReader("{\"a\":true;\"b\":true}")); 
     reader.setLenient(true); 
     reader.beginObject(); 
     assertEquals("a", reader.nextName()); 
     assertEquals(true, reader.nextBoolean()); 
     assertEquals("b", reader.nextName()); 
 } 


public void testStrictNameValueSeparator66() throws IOException { 
     JsonReader reader = new JsonReader(new StringReader("{\"a\"=true}")); 
     reader.beginObject(); 
     assertEquals("a", reader.nextName()); 
     try { 
         reader.nextBoolean(); 
         fail(); 
     } catch (IOException expected) { 
     } 
     reader = new JsonReader(new StringReader("{\"a\"=>true}")); 
     reader.beginObject(); 
     assertEquals("a", reader.nextName()); 
     try { 
         reader.nextBoolean(); 
         fail(); 
     } catch (IOException expected) { 
     } 
 } 


public void testLenientNameValueSeparator67() throws IOException { 
     JsonReader reader = new JsonReader(new StringReader("{\"a\"=true}")); 
     reader.setLenient(true); 
     reader.beginObject(); 
     assertEquals("a", reader.nextName()); 
     assertEquals(true, reader.nextBoolean()); 
     reader = new JsonReader(new StringReader("{\"a\"=>true}")); 
     reader.setLenient(true); 
     reader.beginObject(); 
     assertEquals("a", reader.nextName()); 
     assertEquals(true, reader.nextBoolean()); 
 } 


public void testStrictSingleQuotedStrings69() throws IOException { 
     JsonReader reader = new JsonReader(new StringReader("['a']")); 
     reader.beginArray(); 
     try { 
         reader.nextString(); 
         fail(); 
     } catch (IOException expected) { 
     } 
 } 


public void testLenientComments70() throws IOException { 
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


public void testMissingValue71() throws IOException { 
     JsonReader reader = new JsonReader(new StringReader("{\"a\":}")); 
     reader.beginObject(); 
     assertEquals("a", reader.nextName()); 
     try { 
         reader.nextString(); 
         fail(); 
     } catch (IOException expected) { 
     } 
 } 


public void testNoTopLevelObject73() throws IOException { 
     try { 
         new JsonReader(new StringReader("true")).nextBoolean(); 
     } catch (IOException expected) { 
     } 
 } 


public void testLenientUnquotedStrings75() throws IOException { 
     JsonReader reader = new JsonReader(new StringReader("[a]")); 
     reader.setLenient(true); 
     reader.beginArray(); 
     assertEquals("a", reader.nextString()); 
 } 


public void testStrictSemicolonDelimitedArray80() throws IOException { 
     JsonReader reader = new JsonReader(new StringReader("[true;true]")); 
     reader.beginArray(); 
     try { 
         reader.nextBoolean(); 
         reader.nextBoolean(); 
         fail(); 
     } catch (IOException expected) { 
     } 
 } 

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  /**
   * This test fails because there's no double for 9223372036854775806, and
   * our long parsing uses Double.parseDouble() for fractional values.
   */
  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  
}
