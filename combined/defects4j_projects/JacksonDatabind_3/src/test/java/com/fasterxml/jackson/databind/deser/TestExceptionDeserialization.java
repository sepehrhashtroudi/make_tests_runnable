package com.fasterxml.jackson.databind.deser;

import java.io.IOException;
import java.util.*;

import com.fasterxml.jackson.annotation.*;

import com.fasterxml.jackson.databind.*;

/**
 * Unit tests for verifying that simple exceptions can be deserialized.
 */
public class TestExceptionDeserialization
    extends BaseMapTest
{
    @SuppressWarnings("serial")
    static class MyException extends Exception
    {
        protected int value;

        protected String myMessage;
        protected HashMap<String,Object> stuff = new HashMap<String, Object>();
        
        @JsonCreator
        MyException(@JsonProperty("message") String msg, @JsonProperty("value") int v)
        {
            super(msg);
            myMessage = msg;
            value = v;
        }

        public int getValue() { return value; }
        
        public String getFoo() { return "bar"; }

        @JsonAnySetter public void setter(String key, Object value)
        {
            stuff.put(key, value);
        }
    }

    @SuppressWarnings("serial")
    static class MyNoArgException extends Exception
    {
        @JsonCreator MyNoArgException() { }
    }
    
    /*
    /**********************************************************
    /* Tests
    /**********************************************************
     */

    final ObjectMapper MAPPER = new ObjectMapper();
    
public void testIOException51() throws IOException { 
     IOException ioe = new IOException("TEST"); 
     String json = MAPPER.writeValueAsString(ioe); 
     IOException result = MAPPER.readValue(json, IOException.class); 
     assertEquals(ioe.getMessage(), result.getMessage()); 
 }
public void testCurrency136() throws IOException { 
     Currency usd = Currency.getInstance("USD"); 
     assertEquals(usd, new ObjectMapper().readValue(quote("USD"), Currency.class)); 
 }
    

    // As per [JACKSON-377]
    

    // [JACKSON-388]
    

    

    // [JACKSON-794]: try simulating JDK 7 behavior
    
}
