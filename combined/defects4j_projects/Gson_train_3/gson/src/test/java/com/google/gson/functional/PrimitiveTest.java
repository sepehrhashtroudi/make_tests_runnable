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

import java.io.StringReader;
import java.math.BigDecimal;
import java.math.BigInteger;

import com.google.gson.*;
import junit.framework.TestCase;

import com.google.gson.common.TestTypes.CrazyLongTypeAdapter;

/**
 * Functional tests for Json primitive values: integers, and floating point numbers.
 *
 * @author Inderjeet Singh
 * @author Joel Leitch
 */
public class PrimitiveTest extends TestCase {
  private Gson gson;

  @Override
  protected void setUp() throws Exception {
    super.setUp();
    gson = new Gson();
  }


public void testHtmlCharacterSerialization32() throws Exception { 
     String target = "<script>var a = 12;</script>"; 
     String result = gson.toJson(target); 
     assertFalse(result.equals('"' + target + '"')); 
     gson = new GsonBuilder().disableHtmlEscaping().create(); 
     result = gson.toJson(target); 
     assertTrue(result.equals('"' + target + '"')); 
 } 


public void testNumberSerialization109() { 
     Number expected = 1L; 
     String json = gson.toJson(expected); 
     assertEquals(expected.toString(), json); 
     json = gson.toJson(expected, Number.class); 
     assertEquals(expected.toString(), json); 
 } 


public void testFloatNaNSerializationNotSupportedByDefault112() { 
     try { 
         float nan = Float.NaN; 
         gson.toJson(nan); 
         fail("Gson should not accept NaN for serialization"); 
     } catch (IllegalArgumentException expected) { 
     } 
     try { 
         gson.toJson(Float.NaN); 
         fail("Gson should not accept NaN for serialization"); 
     } catch (IllegalArgumentException expected) { 
     } 
 } 


public void testNegativeInfinitySerialization114() { 
     Gson gson = new GsonBuilder().serializeSpecialFloatingPointValues().create(); 
     double negativeInfinity = Double.NEGATIVE_INFINITY; 
     assertEquals("-Infinity", gson.toJson(negativeInfinity)); 
     assertEquals("-Infinity", gson.toJson(Double.NEGATIVE_INFINITY)); 
 } 


public void testDoubleNaNSerializationNotSupportedByDefault116() { 
     try { 
         double nan = Double.NaN; 
         gson.toJson(nan); 
         fail("Gson should not accept NaN for serialization"); 
     } catch (IllegalArgumentException expected) { 
     } 
     try { 
         gson.toJson(Double.NaN); 
         fail("Gson should not accept NaN for serialization"); 
     } catch (IllegalArgumentException expected) { 
     } 
 } 


public void testDoubleNoFractAsStringRepresentationDeserialization117() { 
     String doubleValue = "1E+5"; 
     Double expected = Double.valueOf(doubleValue); 
     Double actual = gson.fromJson(doubleValue, Double.class); 
     assertEquals(expected, actual); 
     double actual1 = gson.fromJson(doubleValue, double.class); 
     assertEquals(expected.doubleValue(), actual1); 
 } 


public void testPrimitiveDoubleAutoboxedInASingleElementArrayDeserialization131() { 
     double expected = -122.08; 
     double actual = gson.fromJson("[-122.08]", double.class); 
     assertEquals(expected, actual); 
     actual = gson.fromJson("[-122.08]", Double.class); 
     assertEquals(expected, actual); 
 } 


public void testBigDecimalInASingleElementArrayDeserialization132() { 
     BigDecimal expected = new BigDecimal("-122.08e-21"); 
     BigDecimal actual = gson.fromJson("[-122.08e-21]", BigDecimal.class); 
     assertEquals(expected, actual); 
 } 


public void testBigIntegerInASingleElementArrayDeserialization133() { 
     BigInteger expected = new BigInteger("34343434343424242423432323243243242"); 
     BigInteger actual = gson.fromJson("[34343434343424242423432323243243242]", BigInteger.class); 
     assertEquals(expected, actual); 
 } 


public void testPrimitiveIntegerAutoboxedInASingleElementArrayDeserialization134() { 
     int expected = 1; 
     int actual = gson.fromJson("[1]", int.class); 
     assertEquals(expected, actual); 
     actual = gson.fromJson("[1]", Integer.class); 
     assertEquals(expected, actual); 
 } 


public void testLongAsStringSerialization179() throws Exception { 
     gson = new GsonBuilder().setLongSerializationPolicy(LongSerializationPolicy.STRING).create(); 
     String result = gson.toJson(15L); 
     assertEquals("\"15\"", result); 
     result = gson.toJson(2); 
     assertEquals("2", result); 
 } 


public void testReallyLongValuesDeserialization198() { 
     String json = "333961828784581"; 
     long value = gson.fromJson(json, Long.class); 
     assertEquals(333961828784581L, value); 
 } 


public void testBigDecimalNaNDeserializationNotSupported199() { 
     try { 
         gson.fromJson("NaN", BigDecimal.class); 
         fail("Gson should not accept NaN for deserialization by default."); 
     } catch (JsonParseException expected) { 
     } 
 } 

  

  

  

  

  

  

  

  

  

  

  

  

  

  
  
  
  
  

  

  

  
  
  
  
  

  

  

  

  

  

  

  

  
  
  
  
  

  
  
  

  

  

  

  

  

  

  
  
  

  private String extractElementFromArray(String json) {
    return json.substring(json.indexOf('[') + 1, json.indexOf(']'));
  }
  
  
    
  
  
  
  
  
  
  
  
  

  

  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
    
  
  
  
  
  
  

  
  
  private static class ClassWithIntegerField {
    Integer i;
  }
  
  
}
