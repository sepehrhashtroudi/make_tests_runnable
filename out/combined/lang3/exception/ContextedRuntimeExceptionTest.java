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
import org.junit.Before;
import org.junit.Test;

/**
 * JUnit tests for ContextedRuntimeException.
 */
public class ContextedRuntimeExceptionTest extends AbstractExceptionContextTest<ContextedRuntimeException> {
    
    @Override
    @Before
    public void setUp() throws Exception {
        exceptionContext = new ContextedRuntimeException(new Exception(TEST_MESSAGE));
        super.setUp();
    }

@Test
public void testNullExceptionPassing245() { 
     exceptionContext = new ContextedRuntimeException(TEST_MESSAGE_2, new Exception(TEST_MESSAGE), null).addContextValue("test1", null).addContextValue("test2", "some value").addContextValue("test Date", new Date()).addContextValue("test Nbr", Integer.valueOf(5)).addContextValue("test Poorly written obj", new ObjectWithFaultyToString()); 
     final String message = exceptionContext.getMessage(); 
     assertTrue(message != null); 
 }
@Test
public void testNullExceptionPassing497() { 
     exceptionContext = new ContextedRuntimeException(TEST_MESSAGE_2, new Exception(TEST_MESSAGE), null).addContextValue("test1", null).addContextValue("test2", "some value").addContextValue("test Date", new Date()).addContextValue("test Nbr", Integer.valueOf(5)).addContextValue("test Poorly written obj", new ObjectWithFaultyToString()); 
     final String message = exceptionContext.getMessage(); 
     assertTrue(message != null); 
 }
@Test
public void testRawMessage751() { 
     assertEquals(Exception.class.getName() + ": " + TEST_MESSAGE, exceptionContext.getRawMessage()); 
     exceptionContext = new ContextedRuntimeException(TEST_MESSAGE_2, new Exception(TEST_MESSAGE), new DefaultExceptionContext()); 
     assertEquals(TEST_MESSAGE_2, exceptionContext.getRawMessage()); 
     exceptionContext = new ContextedRuntimeException(null, new Exception(TEST_MESSAGE), new DefaultExceptionContext()); 
     assertNull(exceptionContext.getRawMessage()); 
 }
@Test
public void testNullExceptionPassing804() { 
     exceptionContext = new ContextedRuntimeException(TEST_MESSAGE_2, new Exception(TEST_MESSAGE), null).addContextValue("test1", null).addContextValue("test2", "some value").addContextValue("test Date", new Date()).addContextValue("test Nbr", Integer.valueOf(5)).addContextValue("test Poorly written obj", new ObjectWithFaultyToString()); 
     final String message = exceptionContext.getMessage(); 
     assertTrue(message != null); 
 }
@Test
public void testNullExceptionPassing820() { 
     exceptionContext = new ContextedRuntimeException(TEST_MESSAGE_2, new Exception(TEST_MESSAGE), null).addContextValue("test1", null).addContextValue("test2", "some value").addContextValue("test Date", new Date()).addContextValue("test Nbr", Integer.valueOf(5)).addContextValue("test Poorly written obj", new ObjectWithFaultyToString()); 
     final String message = exceptionContext.getMessage(); 
     assertTrue(message != null); 
 }
@Test
public void testNullExceptionPassing840() { 
     exceptionContext = new ContextedRuntimeException(TEST_MESSAGE_2, new Exception(TEST_MESSAGE), null).addContextValue("test1", null).addContextValue("test2", "some value").addContextValue("test Date", new Date()).addContextValue("test Nbr", Integer.valueOf(5)).addContextValue("test Poorly written obj", new ObjectWithFaultyToString()); 
     final String message = exceptionContext.getMessage(); 
     assertTrue(message != null); 
 }
@Test
public void testNullExceptionPassing937() { 
     exceptionContext = new ContextedRuntimeException(TEST_MESSAGE_2, new Exception(TEST_MESSAGE), null).addContextValue("test1", null).addContextValue("test2", "some value").addContextValue("test Date", new Date()).addContextValue("test Nbr", Integer.valueOf(5)).addContextValue("test Poorly written obj", new ObjectWithFaultyToString()); 
     final String message = exceptionContext.getMessage(); 
     assertTrue(message != null); 
 }
@Test
public void testNullExceptionPassing1044() { 
     exceptionContext = new ContextedRuntimeException(TEST_MESSAGE_2, new Exception(TEST_MESSAGE), null).addContextValue("test1", null).addContextValue("test2", "some value").addContextValue("test Date", new Date()).addContextValue("test Nbr", Integer.valueOf(5)).addContextValue("test Poorly written obj", new ObjectWithFaultyToString()); 
     final String message = exceptionContext.getMessage(); 
     assertTrue(message != null); 
 }
@Test
public void testNullExceptionPassing1301() { 
     exceptionContext = new ContextedRuntimeException(TEST_MESSAGE_2, new Exception(TEST_MESSAGE), null).addContextValue("test1", null).addContextValue("test2", "some value").addContextValue("test Date", new Date()).addContextValue("test Nbr", Integer.valueOf(5)).addContextValue("test Poorly written obj", new ObjectWithFaultyToString()); 
     final String message = exceptionContext.getMessage(); 
     assertTrue(message != null); 
 }
@Test
public void testContextedExceptionThrowable1313() { 
     exceptionContext = new ContextedRuntimeException(new Exception(TEST_MESSAGE)); 
     final String message = exceptionContext.getMessage(); 
     final String trace = ExceptionUtils.getStackTrace(exceptionContext); 
     assertTrue(trace.indexOf("ContextedException") >= 0); 
     assertTrue(trace.indexOf(TEST_MESSAGE) >= 0); 
     assertTrue(message.indexOf(TEST_MESSAGE) >= 0); 
 }
@Test
public void testContextedExceptionStringThrowable1323() { 
     exceptionContext = new ContextedRuntimeException(TEST_MESSAGE_2, new Exception(TEST_MESSAGE)); 
     final String message = exceptionContext.getMessage(); 
     final String trace = ExceptionUtils.getStackTrace(exceptionContext); 
     assertTrue(trace.indexOf("ContextedException") >= 0); 
     assertTrue(trace.indexOf(TEST_MESSAGE) >= 0); 
     assertTrue(trace.indexOf(TEST_MESSAGE_2) >= 0); 
     assertTrue(message.indexOf(TEST_MESSAGE_2) >= 0); 
 }
@Test
public void testNullExceptionPassing1361() { 
     exceptionContext = new ContextedRuntimeException(TEST_MESSAGE_2, new Exception(TEST_MESSAGE), null).addContextValue("test1", null).addContextValue("test2", "some value").addContextValue("test Date", new Date()).addContextValue("test Nbr", Integer.valueOf(5)).addContextValue("test Poorly written obj", new ObjectWithFaultyToString()); 
     final String message = exceptionContext.getMessage(); 
     assertTrue(message != null); 
 }
@Test
public void testNullExceptionPassing1522() { 
     exceptionContext = new ContextedRuntimeException(TEST_MESSAGE_2, new Exception(TEST_MESSAGE), null).addContextValue("test1", null).addContextValue("test2", "some value").addContextValue("test Date", new Date()).addContextValue("test Nbr", Integer.valueOf(5)).addContextValue("test Poorly written obj", new ObjectWithFaultyToString()); 
     final String message = exceptionContext.getMessage(); 
     assertTrue(message != null); 
 }
@Test
public void testNullExceptionPassing1536() { 
     exceptionContext = new ContextedRuntimeException(TEST_MESSAGE_2, new Exception(TEST_MESSAGE), null).addContextValue("test1", null).addContextValue("test2", "some value").addContextValue("test Date", new Date()).addContextValue("test Nbr", Integer.valueOf(5)).addContextValue("test Poorly written obj", new ObjectWithFaultyToString()); 
     final String message = exceptionContext.getMessage(); 
     assertTrue(message != null); 
 }
@Test
public void testNullExceptionPassing1940() { 
     exceptionContext = new ContextedRuntimeException(TEST_MESSAGE_2, new Exception(TEST_MESSAGE), null).addContextValue("test1", null).addContextValue("test2", "some value").addContextValue("test Date", new Date()).addContextValue("test Nbr", Integer.valueOf(5)).addContextValue("test Poorly written obj", new ObjectWithFaultyToString()); 
     final String message = exceptionContext.getMessage(); 
     assertTrue(message != null); 
 }
@Test
public void testNullExceptionPassing2309() { 
     exceptionContext = new ContextedRuntimeException(TEST_MESSAGE_2, new Exception(TEST_MESSAGE), null).addContextValue("test1", null).addContextValue("test2", "some value").addContextValue("test Date", new Date()).addContextValue("test Nbr", Integer.valueOf(5)).addContextValue("test Poorly written obj", new ObjectWithFaultyToString()); 
     final String message = exceptionContext.getMessage(); 
     assertTrue(message != null); 
 }
@Test
public void testNullExceptionPassing2437() { 
     exceptionContext = new ContextedRuntimeException(TEST_MESSAGE_2, new Exception(TEST_MESSAGE), null).addContextValue("test1", null).addContextValue("test2", "some value").addContextValue("test Date", new Date()).addContextValue("test Nbr", Integer.valueOf(5)).addContextValue("test Poorly written obj", new ObjectWithFaultyToString()); 
     final String message = exceptionContext.getMessage(); 
     assertTrue(message != null); 
 }
@Test
public void testNullExceptionPassing2811() { 
     exceptionContext = new ContextedRuntimeException(TEST_MESSAGE_2, new Exception(TEST_MESSAGE), null).addContextValue("test1", null).addContextValue("test2", "some value").addContextValue("test Date", new Date()).addContextValue("test Nbr", Integer.valueOf(5)).addContextValue("test Poorly written obj", new ObjectWithFaultyToString()); 
     final String message = exceptionContext.getMessage(); 
     assertTrue(message != null); 
 }
@Test
public void testNullExceptionPassing3119() { 
     exceptionContext = new ContextedRuntimeException(TEST_MESSAGE_2, new Exception(TEST_MESSAGE), null).addContextValue("test1", null).addContextValue("test2", "some value").addContextValue("test Date", new Date()).addContextValue("test Nbr", Integer.valueOf(5)).addContextValue("test Poorly written obj", new ObjectWithFaultyToString()); 
     final String message = exceptionContext.getMessage(); 
     assertTrue(message != null); 
 }
@Test
public void testContextedException3246() { 
     exceptionContext = new ContextedRuntimeException(); 
     final String message = exceptionContext.getMessage(); 
     final String trace = ExceptionUtils.getStackTrace(exceptionContext); 
     assertTrue(trace.indexOf("ContextedException") >= 0); 
     assertTrue(StringUtils.isEmpty(message)); 
 }
@Test
public void testNullExceptionPassing3654() { 
     exceptionContext = new ContextedRuntimeException(TEST_MESSAGE_2, new Exception(TEST_MESSAGE), null).addContextValue("test1", null).addContextValue("test2", "some value").addContextValue("test Date", new Date()).addContextValue("test Nbr", Integer.valueOf(5)).addContextValue("test Poorly written obj", new ObjectWithFaultyToString()); 
     final String message = exceptionContext.getMessage(); 
     assertTrue(message != null); 
 }
@Test
public void testRawMessage3784() { 
     assertEquals(Exception.class.getName() + ": " + TEST_MESSAGE, exceptionContext.getRawMessage()); 
     exceptionContext = new ContextedRuntimeException(TEST_MESSAGE_2, new Exception(TEST_MESSAGE), new DefaultExceptionContext()); 
     assertEquals(TEST_MESSAGE_2, exceptionContext.getRawMessage()); 
     exceptionContext = new ContextedRuntimeException(null, new Exception(TEST_MESSAGE), new DefaultExceptionContext()); 
     assertNull(exceptionContext.getRawMessage()); 
 }
@Test
public void testNullExceptionPassing3910() { 
     exceptionContext = new ContextedRuntimeException(TEST_MESSAGE_2, new Exception(TEST_MESSAGE), null).addContextValue("test1", null).addContextValue("test2", "some value").addContextValue("test Date", new Date()).addContextValue("test Nbr", Integer.valueOf(5)).addContextValue("test Poorly written obj", new ObjectWithFaultyToString()); 
     final String message = exceptionContext.getMessage(); 
     assertTrue(message != null); 
 }
@Test
public void testNullExceptionPassing4198() { 
     exceptionContext = new ContextedRuntimeException(TEST_MESSAGE_2, new Exception(TEST_MESSAGE), null).addContextValue("test1", null).addContextValue("test2", "some value").addContextValue("test Date", new Date()).addContextValue("test Nbr", Integer.valueOf(5)).addContextValue("test Poorly written obj", new ObjectWithFaultyToString()); 
     final String message = exceptionContext.getMessage(); 
     assertTrue(message != null); 
 }
@Test
public void testContextedExceptionString4539() { 
     exceptionContext = new ContextedRuntimeException(TEST_MESSAGE); 
     assertEquals(TEST_MESSAGE, exceptionContext.getMessage()); 
     final String trace = ExceptionUtils.getStackTrace(exceptionContext); 
     assertTrue(trace.indexOf(TEST_MESSAGE) >= 0); 
 }
@Test
public void testNullExceptionPassing5549() { 
     exceptionContext = new ContextedRuntimeException(TEST_MESSAGE_2, new Exception(TEST_MESSAGE), null).addContextValue("test1", null).addContextValue("test2", "some value").addContextValue("test Date", new Date()).addContextValue("test Nbr", Integer.valueOf(5)).addContextValue("test Poorly written obj", new ObjectWithFaultyToString()); 
     final String message = exceptionContext.getMessage(); 
     assertTrue(message != null); 
 }
@Test
public void testNullExceptionPassing5699() { 
     exceptionContext = new ContextedRuntimeException(TEST_MESSAGE_2, new Exception(TEST_MESSAGE), null).addContextValue("test1", null).addContextValue("test2", "some value").addContextValue("test Date", new Date()).addContextValue("test Nbr", Integer.valueOf(5)).addContextValue("test Poorly written obj", new ObjectWithFaultyToString()); 
     final String message = exceptionContext.getMessage(); 
     assertTrue(message != null); 
 }
@Test
public void testContextedExceptionThrowable5716() { 
     exceptionContext = new ContextedRuntimeException(new Exception(TEST_MESSAGE)); 
     final String message = exceptionContext.getMessage(); 
     final String trace = ExceptionUtils.getStackTrace(exceptionContext); 
     assertTrue(trace.indexOf("ContextedException") >= 0); 
     assertTrue(trace.indexOf(TEST_MESSAGE) >= 0); 
     assertTrue(message.indexOf(TEST_MESSAGE) >= 0); 
 }
@Test
public void testContextedExceptionStringThrowable5993() { 
     exceptionContext = new ContextedRuntimeException(TEST_MESSAGE_2, new Exception(TEST_MESSAGE)); 
     final String message = exceptionContext.getMessage(); 
     final String trace = ExceptionUtils.getStackTrace(exceptionContext); 
     assertTrue(trace.indexOf("ContextedException") >= 0); 
     assertTrue(trace.indexOf(TEST_MESSAGE) >= 0); 
     assertTrue(trace.indexOf(TEST_MESSAGE_2) >= 0); 
     assertTrue(message.indexOf(TEST_MESSAGE_2) >= 0); 
 }
@Test
public void testNullExceptionPassing6111() { 
     exceptionContext = new ContextedRuntimeException(TEST_MESSAGE_2, new Exception(TEST_MESSAGE), null).addContextValue("test1", null).addContextValue("test2", "some value").addContextValue("test Date", new Date()).addContextValue("test Nbr", Integer.valueOf(5)).addContextValue("test Poorly written obj", new ObjectWithFaultyToString()); 
     final String message = exceptionContext.getMessage(); 
     assertTrue(message != null); 
 }
@Test
public void testNullExceptionPassing6520() { 
     exceptionContext = new ContextedRuntimeException(TEST_MESSAGE_2, new Exception(TEST_MESSAGE), null).addContextValue("test1", null).addContextValue("test2", "some value").addContextValue("test Date", new Date()).addContextValue("test Nbr", Integer.valueOf(5)).addContextValue("test Poorly written obj", new ObjectWithFaultyToString()); 
     final String message = exceptionContext.getMessage(); 
     assertTrue(message != null); 
 }
@Test
public void testNullExceptionPassing6673() { 
     exceptionContext = new ContextedRuntimeException(TEST_MESSAGE_2, new Exception(TEST_MESSAGE), null).addContextValue("test1", null).addContextValue("test2", "some value").addContextValue("test Date", new Date()).addContextValue("test Nbr", Integer.valueOf(5)).addContextValue("test Poorly written obj", new ObjectWithFaultyToString()); 
     final String message = exceptionContext.getMessage(); 
     assertTrue(message != null); 
 }
@Test
public void testContextedExceptionThrowable6772() { 
     exceptionContext = new ContextedRuntimeException(new Exception(TEST_MESSAGE)); 
     final String message = exceptionContext.getMessage(); 
     final String trace = ExceptionUtils.getStackTrace(exceptionContext); 
     assertTrue(trace.indexOf("ContextedException") >= 0); 
     assertTrue(trace.indexOf(TEST_MESSAGE) >= 0); 
     assertTrue(message.indexOf(TEST_MESSAGE) >= 0); 
 }
@Test
public void testContextedExceptionStringThrowable7016() { 
     exceptionContext = new ContextedRuntimeException(TEST_MESSAGE_2, new Exception(TEST_MESSAGE)); 
     final String message = exceptionContext.getMessage(); 
     final String trace = ExceptionUtils.getStackTrace(exceptionContext); 
     assertTrue(trace.indexOf("ContextedException") >= 0); 
     assertTrue(trace.indexOf(TEST_MESSAGE) >= 0); 
     assertTrue(trace.indexOf(TEST_MESSAGE_2) >= 0); 
     assertTrue(message.indexOf(TEST_MESSAGE_2) >= 0); 
 }
@Test
public void testNullExceptionPassing7193() { 
     exceptionContext = new ContextedRuntimeException(TEST_MESSAGE_2, new Exception(TEST_MESSAGE), null).addContextValue("test1", null).addContextValue("test2", "some value").addContextValue("test Date", new Date()).addContextValue("test Nbr", Integer.valueOf(5)).addContextValue("test Poorly written obj", new ObjectWithFaultyToString()); 
     final String message = exceptionContext.getMessage(); 
     assertTrue(message != null); 
 }
@Test
public void testNullExceptionPassing7348() { 
     exceptionContext = new ContextedRuntimeException(TEST_MESSAGE_2, new Exception(TEST_MESSAGE), null).addContextValue("test1", null).addContextValue("test2", "some value").addContextValue("test Date", new Date()).addContextValue("test Nbr", Integer.valueOf(5)).addContextValue("test Poorly written obj", new ObjectWithFaultyToString()); 
     final String message = exceptionContext.getMessage(); 
     assertTrue(message != null); 
 }
@Test
public void testContextedExceptionStringThrowable7934() { 
     exceptionContext = new ContextedRuntimeException(TEST_MESSAGE_2, new Exception(TEST_MESSAGE)); 
     final String message = exceptionContext.getMessage(); 
     final String trace = ExceptionUtils.getStackTrace(exceptionContext); 
     assertTrue(trace.indexOf("ContextedException") >= 0); 
     assertTrue(trace.indexOf(TEST_MESSAGE) >= 0); 
     assertTrue(trace.indexOf(TEST_MESSAGE_2) >= 0); 
     assertTrue(message.indexOf(TEST_MESSAGE_2) >= 0); 
 }
@Test
public void testContextedExceptionString7995() { 
     exceptionContext = new ContextedRuntimeException(TEST_MESSAGE); 
     assertEquals(TEST_MESSAGE, exceptionContext.getMessage()); 
     final String trace = ExceptionUtils.getStackTrace(exceptionContext); 
     assertTrue(trace.indexOf(TEST_MESSAGE) >= 0); 
 }
@Test
public void testNullExceptionPassing8222() { 
     exceptionContext = new ContextedRuntimeException(TEST_MESSAGE_2, new Exception(TEST_MESSAGE), null).addContextValue("test1", null).addContextValue("test2", "some value").addContextValue("test Date", new Date()).addContextValue("test Nbr", Integer.valueOf(5)).addContextValue("test Poorly written obj", new ObjectWithFaultyToString()); 
     final String message = exceptionContext.getMessage(); 
     assertTrue(message != null); 
 }
@Test
public void testContextedException8318() { 
     exceptionContext = new ContextedRuntimeException(); 
     final String message = exceptionContext.getMessage(); 
     final String trace = ExceptionUtils.getStackTrace(exceptionContext); 
     assertTrue(trace.indexOf("ContextedException") >= 0); 
     assertTrue(StringUtils.isEmpty(message)); 
 }
@Test
public void testNullExceptionPassing8452() { 
     exceptionContext = new ContextedRuntimeException(TEST_MESSAGE_2, new Exception(TEST_MESSAGE), null).addContextValue("test1", null).addContextValue("test2", "some value").addContextValue("test Date", new Date()).addContextValue("test Nbr", Integer.valueOf(5)).addContextValue("test Poorly written obj", new ObjectWithFaultyToString()); 
     final String message = exceptionContext.getMessage(); 
     assertTrue(message != null); 
 }
@Test
public void testContextedExceptionStringThrowable8502() { 
     exceptionContext = new ContextedRuntimeException(TEST_MESSAGE_2, new Exception(TEST_MESSAGE)); 
     final String message = exceptionContext.getMessage(); 
     final String trace = ExceptionUtils.getStackTrace(exceptionContext); 
     assertTrue(trace.indexOf("ContextedException") >= 0); 
     assertTrue(trace.indexOf(TEST_MESSAGE) >= 0); 
     assertTrue(trace.indexOf(TEST_MESSAGE_2) >= 0); 
     assertTrue(message.indexOf(TEST_MESSAGE_2) >= 0); 
 }
@Test
public void testContextedExceptionString8787() { 
     exceptionContext = new ContextedRuntimeException(TEST_MESSAGE); 
     assertEquals(TEST_MESSAGE, exceptionContext.getMessage()); 
     final String trace = ExceptionUtils.getStackTrace(exceptionContext); 
     assertTrue(trace.indexOf(TEST_MESSAGE) >= 0); 
 }
@Test
public void testContextedExceptionStringThrowable8975() { 
     exceptionContext = new ContextedRuntimeException(TEST_MESSAGE_2, new Exception(TEST_MESSAGE)); 
     final String message = exceptionContext.getMessage(); 
     final String trace = ExceptionUtils.getStackTrace(exceptionContext); 
     assertTrue(trace.indexOf("ContextedException") >= 0); 
     assertTrue(trace.indexOf(TEST_MESSAGE) >= 0); 
     assertTrue(trace.indexOf(TEST_MESSAGE_2) >= 0); 
     assertTrue(message.indexOf(TEST_MESSAGE_2) >= 0); 
 }
@Test
public void testContextedException9138() { 
     exceptionContext = new ContextedRuntimeException(); 
     final String message = exceptionContext.getMessage(); 
     final String trace = ExceptionUtils.getStackTrace(exceptionContext); 
     assertTrue(trace.indexOf("ContextedException") >= 0); 
     assertTrue(StringUtils.isEmpty(message)); 
 }
@Test
public void testContextedExceptionThrowable9174() { 
     exceptionContext = new ContextedRuntimeException(new Exception(TEST_MESSAGE)); 
     final String message = exceptionContext.getMessage(); 
     final String trace = ExceptionUtils.getStackTrace(exceptionContext); 
     assertTrue(trace.indexOf("ContextedException") >= 0); 
     assertTrue(trace.indexOf(TEST_MESSAGE) >= 0); 
     assertTrue(message.indexOf(TEST_MESSAGE) >= 0); 
 }
@Test
public void testContextedExceptionStringThrowable9542() { 
     exceptionContext = new ContextedRuntimeException(TEST_MESSAGE_2, new Exception(TEST_MESSAGE)); 
     final String message = exceptionContext.getMessage(); 
     final String trace = ExceptionUtils.getStackTrace(exceptionContext); 
     assertTrue(trace.indexOf("ContextedException") >= 0); 
     assertTrue(trace.indexOf(TEST_MESSAGE) >= 0); 
     assertTrue(trace.indexOf(TEST_MESSAGE_2) >= 0); 
     assertTrue(message.indexOf(TEST_MESSAGE_2) >= 0); 
 }
    

    

    

    
    
    

    

    
}
