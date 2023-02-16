/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.commons.lang3.exception;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.Date;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

/**
 * JUnit tests for ContextedException.
 */
public class ContextedExceptionTest extends AbstractExceptionContextTest<ContextedException> {
    
    @Override
    public void setUp() throws Exception {
        exceptionContext = new ContextedException(new Exception(TEST_MESSAGE));
        super.setUp();
    }

@Test
public void testSetContextValue258() { 
     exceptionContext.addContextValue("test2", "different value"); 
     exceptionContext.setContextValue("test3", "3"); 
     final String message = exceptionContext.getFormattedExceptionMessage(TEST_MESSAGE); 
     assertTrue(message.indexOf(TEST_MESSAGE) >= 0); 
     assertTrue(message.indexOf("test Poorly written obj") >= 0); 
     assertTrue(message.indexOf("Crap") >= 0); 
     assertTrue(exceptionContext.getFirstContextValue("crap") == null); 
     assertTrue(exceptionContext.getFirstContextValue("test Poorly written obj") instanceof ObjectWithFaultyToString); 
     assertEquals(7, exceptionContext.getContextEntries().size()); 
     assertEquals(6, exceptionContext.getContextLabels().size()); 
     assertTrue(exceptionContext.getContextLabels().contains("test Poorly written obj")); 
     assertTrue(!exceptionContext.getContextLabels().contains("crap")); 
     exceptionContext.setContextValue("test Poorly written obj", "replacement"); 
     assertEquals(7, exceptionContext.getContextEntries().size()); 
     assertEquals(6, exceptionContext.getContextLabels().size()); 
     exceptionContext.setContextValue("test2", "another"); 
     assertEquals(6, exceptionContext.getContextEntries().size()); 
     assertEquals(6, exceptionContext.getContextLabels().size()); 
     final String contextMessage = exceptionContext.getFormattedExceptionMessage(null); 
     assertTrue(contextMessage.indexOf(TEST_MESSAGE) == -1); 
 }
@Test
public void testContextedExceptionString327() { 
     exceptionContext = new ContextedException(TEST_MESSAGE); 
     assertEquals(TEST_MESSAGE, exceptionContext.getMessage()); 
     final String trace = ExceptionUtils.getStackTrace(exceptionContext); 
     assertTrue(trace.indexOf(TEST_MESSAGE) >= 0); 
 }
@Test
public void testContextedExceptionStringThrowableContext328() { 
     exceptionContext = new ContextedException(TEST_MESSAGE_2, new Exception(TEST_MESSAGE), new DefaultExceptionContext() { 
     }); 
     final String message = exceptionContext.getMessage(); 
     final String trace = ExceptionUtils.getStackTrace(exceptionContext); 
     assertTrue(trace.indexOf("ContextedException") >= 0); 
     assertTrue(trace.indexOf(TEST_MESSAGE) >= 0); 
     assertTrue(trace.indexOf(TEST_MESSAGE_2) >= 0); 
     assertTrue(message.indexOf(TEST_MESSAGE_2) >= 0); 
 }
@Test
public void testNullExceptionPassing329() { 
     exceptionContext = new ContextedException(TEST_MESSAGE_2, new Exception(TEST_MESSAGE), null).addContextValue("test1", null).addContextValue("test2", "some value").addContextValue("test Date", new Date()).addContextValue("test Nbr", Integer.valueOf(5)).addContextValue("test Poorly written obj", new ObjectWithFaultyToString()); 
     final String message = exceptionContext.getMessage(); 
     assertTrue(message != null); 
 }
@Test
public void testContextedExceptionStringThrowable331() { 
     exceptionContext = new ContextedException(TEST_MESSAGE_2, new Exception(TEST_MESSAGE)); 
     final String message = exceptionContext.getMessage(); 
     final String trace = ExceptionUtils.getStackTrace(exceptionContext); 
     assertTrue(trace.indexOf("ContextedException") >= 0); 
     assertTrue(trace.indexOf(TEST_MESSAGE) >= 0); 
     assertTrue(trace.indexOf(TEST_MESSAGE_2) >= 0); 
     assertTrue(message.indexOf(TEST_MESSAGE_2) >= 0); 
 }
@Test
public void testRawMessage332() { 
     assertEquals(Exception.class.getName() + ": " + TEST_MESSAGE, exceptionContext.getRawMessage()); 
     exceptionContext = new ContextedException(TEST_MESSAGE_2, new Exception(TEST_MESSAGE), new DefaultExceptionContext()); 
     assertEquals(TEST_MESSAGE_2, exceptionContext.getRawMessage()); 
     exceptionContext = new ContextedException(null, new Exception(TEST_MESSAGE), new DefaultExceptionContext()); 
     assertNull(exceptionContext.getRawMessage()); 
 }
    

    

    

    
    
    

    

    
}
