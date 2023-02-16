package com.google.gson.functional;

import com.google.gson.Gson;

import junit.framework.TestCase;

/**
 * Functional tests for Json serialization and deserialization of strings.
 *
 * @author Inderjeet Singh
 * @author Joel Leitch
 */
public class StringTest extends TestCase {
  private Gson gson;

  @Override
  protected void setUp() throws Exception {
    super.setUp();
    gson = new Gson();
  }
  

public void testSingleQuoteInStringSerialization30() throws Exception { 
     String valueWithQuotes = "beforeQuote'afterQuote"; 
     String jsonRepresentation = gson.toJson(valueWithQuotes); 
     assertEquals(valueWithQuotes, gson.fromJson(jsonRepresentation, String.class)); 
 } 

  

  

  

  

  

  

  

  

  

  

  

  

  

  
  
  
  
  /**
   * Created in response to http://groups.google.com/group/google-gson/browse_thread/thread/2431d4a3d0d6cb23
   */
  
  
  /**
   * Created in response to http://groups.google.com/group/google-gson/browse_thread/thread/2431d4a3d0d6cb23
   */
  
  
  
  
  
}
