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

import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.URI;
import java.net.URL;
import java.sql.Time;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.Locale;
import java.util.Properties;
import java.util.Set;
import java.util.TimeZone;
import java.util.TreeSet;
import java.util.UUID;

import junit.framework.TestCase;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.reflect.TypeToken;

/**
 * Functional test for Json serialization and deserialization for common classes for which default
 * support is provided in Gson. The tests for Map types are available in {@link MapTest}.
 *
 * @author Inderjeet Singh
 * @author Joel Leitch
 */
public class DefaultTypeAdaptersTest extends TestCase {
  private Gson gson;
  private TimeZone oldTimeZone;

  @Override
  protected void setUp() throws Exception {
    super.setUp();
    this.oldTimeZone = TimeZone.getDefault();
    TimeZone.setDefault(TimeZone.getTimeZone("PST"));
    gson = new Gson();
  }

  @Override
  protected void tearDown() throws Exception {
    TimeZone.setDefault(oldTimeZone);
    super.tearDown();
  }

public void testSetSerialization29() throws Exception { 
     Gson gson = new Gson(); 
     HashSet<String> s = new HashSet<String>(); 
     s.add("blah"); 
     String json = gson.toJson(s); 
     assertEquals("[\"blah\"]", json); 
     json = gson.toJson(s, Set.class); 
     assertEquals("[\"blah\"]", json); 
 }
public void testDoubleSerialization30() { 
     Gson gson = new GsonBuilder().serializeSpecialFloatingPointValues().create(); 
     double value = 1.0; 
     String json = gson.toJson(value); 
     assertEquals("1.0", json); 
     value = 1.7976931348623157E308; 
     json = gson.toJson(value); 
     assertEquals("1.7976931348623157E308", json); 
 }
public void testNegativeInfinitySerialization32() { 
     Gson gson = new GsonBuilder().serializeSpecialFloatingPointValues().create(); 
     double negativeInfinity = Double.NEGATIVE_INFINITY; 
     assertEquals("-Infinity", gson.toJson(negativeInfinity)); 
     assertEquals("-Infinity", gson.toJson(Double.NEGATIVE_INFINITY)); 
 }
public void testSetDeserialization33() { 
     Gson gson = new Gson(); 
     HashSet<String> s = new HashSet<String>(); 
     s.add("blah"); 
     String json = gson.toJson(s); 
     assertEquals("[\"blah\"]", json); 
     json = gson.toJson(s, Set.class); 
     assertEquals("[\"blah\"]", json); 
 }
public void testDefaultJavaSqlTimeDeserialization35() { 
     String json = "'Dec 3, 2009 1:18:02 PM'"; 
     Time extracted = gson.fromJson(json, Time.class); 
     assertEqualsDate(extracted, 2009, 11, 3); 
     assertEqualsTime(extracted, 13, 18, 02); 
 }
public void testLocaleSerialization38() { 
     Locale locale = new Locale("en"); 
     String json = gson.toJson(locale); 
     assertEquals("en", json); 
 }
public void testFloatInfinitySerialization41() { 
     Gson gson = new GsonBuilder().serializeSpecialFloatingPointValues().create(); 
     float infinity = Float.POSITIVE_INFINITY; 
     assertEquals("Infinity", gson.toJson(infinity)); 
     assertEquals("Infinity", gson.toJson(Float.POSITIVE_INFINITY)); 
 }
public void testDateSerializationWithPattern65() throws Exception { 
     String pattern = "yyyy-MM-dd"; 
     DateFormat formatter = new SimpleDateFormat(pattern); 
     Gson gson = new GsonBuilder().setDateFormat(pattern).create(); 
     Date now = new Date(); 
     String json = gson.toJson(now); 
     assertEquals("\"" + formatter.format(now) + "\"", json); 
 }
  

  

  

  

  private static class ClassWithUrlField {
    URL url;
  }

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  // Date can not directly be compared with another instance since the deserialization loses the
  // millisecond portion.
  @SuppressWarnings("deprecation")
  private void assertEqualsDate(Date date, int year, int month, int day) {
      assertEquals(year-1900, date.getYear());
      assertEquals(month, date.getMonth());
      assertEquals(day, date.getDate());
  }

  @SuppressWarnings("deprecation")
  private void assertEqualsTime(Date date, int hours, int minutes, int seconds) {
    assertEquals(hours, date.getHours());
    assertEquals(minutes, date.getMinutes());
    assertEquals(seconds, date.getSeconds());
  }

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  private static class ClassWithBigDecimal {
    BigDecimal value;
    // For use by Gson
    @SuppressWarnings("unused")
    private ClassWithBigDecimal() { }
    ClassWithBigDecimal(String value) {
      this.value = new BigDecimal(value);
    }
    String getExpectedJson() {
      return "{\"value\":" + value.toEngineeringString() + "}";
    }
  }

  private static class ClassWithBigInteger {
    BigInteger value;
    // For use by Gson
    @SuppressWarnings("unused")
    private ClassWithBigInteger() { }
    ClassWithBigInteger(String value) {
      this.value = new BigInteger(value);
    }
    String getExpectedJson() {
      return "{\"value\":" + value + "}";
    }
  }

  

  

  

  
}
