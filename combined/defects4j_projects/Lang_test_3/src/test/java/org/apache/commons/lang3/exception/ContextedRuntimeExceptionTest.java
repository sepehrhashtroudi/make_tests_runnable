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
public void testContextedExceptionString69() { 
     exceptionContext = new ContextedRuntimeException(TEST_MESSAGE); 
     assertEquals(TEST_MESSAGE, exceptionContext.getMessage()); 
     final String trace = ExceptionUtils.getStackTrace(exceptionContext); 
     assertTrue(trace.indexOf(TEST_MESSAGE) >= 0); 
 }
@Test
public void testContextedExceptionThrowable70() { 
     exceptionContext = new ContextedRuntimeException(new Exception(TEST_MESSAGE)); 
     final String message = exceptionContext.getMessage(); 
     final String trace = ExceptionUtils.getStackTrace(exceptionContext); 
     assertTrue(trace.indexOf("ContextedException") >= 0); 
     assertTrue(trace.indexOf(TEST_MESSAGE) >= 0); 
     assertTrue(message.indexOf(TEST_MESSAGE) >= 0); 
 }
    

    

    

    
    
    

    

    
}