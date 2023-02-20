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
package org.apache.commons.lang3.concurrent;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

import org.easymock.EasyMock;
import org.junit.Test;

/**
 * Test class for {@link ConcurrentUtils}.
 *
 * @version $Id$
 */
public class ConcurrentUtilsTest {
    /**
     * Tests creating a ConcurrentException with a runtime exception as cause.
     */
    

    /**
     * Tests creating a ConcurrentException with an error as cause.
     */
    

    /**
     * Tests creating a ConcurrentException with null as cause.
     */
    

    /**
     * Tries to create a ConcurrentRuntimeException with a runtime as cause.
     */
    

    /**
     * Tries to create a ConcurrentRuntimeException with an error as cause.
     */
    

    /**
     * Tries to create a ConcurrentRuntimeException with null as cause.
     */
    

    /**
     * Tests extractCause() for a null exception.
     */
    

    /**
     * Tests extractCause() if the cause of the passed in exception is null.
     */
    

    /**
     * Tests extractCause() if the cause is an error.
     */
    

    /**
     * Tests extractCause() if the cause is an unchecked exception.
     */
    

    /**
@Test
public void testInitializeUncheckedEx93() throws ConcurrentException { 
     @SuppressWarnings("unchecked") 
     final ConcurrentInitializer<Object> init = EasyMock.createMock(ConcurrentInitializer.class); 
     final Exception cause = new Exception(); 
     EasyMock.expect(init.get()).andThrow(new ConcurrentException(cause)); 
     EasyMock.replay(init); 
     try { 
         ConcurrentUtils.initializeUnchecked(init); 
         fail("Exception not thrown!"); 
     } catch (final ConcurrentRuntimeException crex) { 
         assertSame("Wrong cause", cause, crex.getCause()); 
     } 
     EasyMock.verify(init); 
 }
@Test
public void testExtractCauseChecked94() { 
     final Exception ex = new Exception("Test"); 
     final ConcurrentException cex = ConcurrentUtils.extractCause(new ExecutionException(ex)); 
     assertSame("Wrong cause", ex, cex.getCause()); 
 }
@Test
public void testExtractCauseNull196() { 
     assertNull("Non null result", ConcurrentUtils.extractCause(null)); 
 }
@Test
public void testHandleCauseUncheckedNull197() { 
     ConcurrentUtils.handleCauseUnchecked(null); 
     ConcurrentUtils.handleCauseUnchecked(new ExecutionException("Test", null)); 
 }
@Test
public void testHandleCauseChecked198() { 
     final Exception ex = new Exception("Test"); 
     try { 
         ConcurrentUtils.handleCause(new ExecutionException(ex)); 
         fail("ConcurrentException not thrown!"); 
     } catch (final ConcurrentException cex) { 
         assertEquals("Wrong cause", ex, cex.getCause()); 
     } 
 }
@Test(expected = IllegalArgumentException.class) 
 public void testConcurrentExceptionCauseError199() { 
     new ConcurrentException("An error", new Error()); 
 }
@Test
public void testHandleCauseUncheckedError200() { 
     final Error err = new AssertionError("Test"); 
     try { 
         ConcurrentUtils.handleCauseUnchecked(new ExecutionException(err)); 
         fail("Error not thrown!"); 
     } catch (final Error e) { 
         assertEquals("Wrong error", err, e); 
     } 
 }
@Test
public void testInitialize201() throws ConcurrentException { 
     @SuppressWarnings("unchecked") 
     final ConcurrentInitializer<Object> init = EasyMock.createMock(ConcurrentInitializer.class); 
     final Object result = new Object(); 
     EasyMock.expect(init.get()).andReturn(result); 
     EasyMock.replay(init); 
     assertSame("Wrong result object", result, ConcurrentUtils.initialize(init)); 
     EasyMock.verify(init); 
 }
@Test
public void testPutIfAbsentKeyPresent202() { 
     final String key = "testKey"; 
     final Integer value = 42; 
     final ConcurrentMap<String, Integer> map = new ConcurrentHashMap<String, Integer>(); 
     map.put(key, value); 
     assertEquals("Wrong result", value, ConcurrentUtils.putIfAbsent(map, key, 0)); 
     assertEquals("Wrong value in map", value, map.get(key)); 
 }
@Test
public void testPutIfAbsentNullMap203() { 
     assertNull("Wrong result", ConcurrentUtils.putIfAbsent(null, "test", 100)); 
 }
@Test
public void testCreateIfAbsentKeyPresent204() throws ConcurrentException { 
     @SuppressWarnings("unchecked") 
     final ConcurrentInitializer<Integer> init = EasyMock.createMock(ConcurrentInitializer.class); 
     EasyMock.replay(init); 
     final String key = "testKey"; 
     final Integer value = 42; 
     final ConcurrentMap<String, Integer> map = new ConcurrentHashMap<String, Integer>(); 
     map.put(key, value); 
     assertEquals("Wrong result", value, ConcurrentUtils.createIfAbsent(map, key, init)); 
     assertEquals("Wrong value in map", value, map.get(key)); 
     EasyMock.verify(init); 
 }
@Test
public void testCreateIfAbsentKeyNotPresent205() throws ConcurrentException { 
     @SuppressWarnings("unchecked") 
     final ConcurrentInitializer<Integer> init = EasyMock.createMock(ConcurrentInitializer.class); 
     final String key = "testKey"; 
     final Integer value = 42; 
     EasyMock.expect(init.get()).andReturn(value); 
     EasyMock.replay(init); 
     final ConcurrentMap<String, Integer> map = new ConcurrentHashMap<String, Integer>(); 
     assertEquals("Wrong result", value, ConcurrentUtils.createIfAbsent(map, key, init)); 
     assertEquals("Wrong value in map", value, map.get(key)); 
     EasyMock.verify(init); 
 }
@Test
public void testCreateIfAbsentUncheckedSuccess206() { 
     final String key = "testKey"; 
     final Integer value = 42; 
     final ConcurrentMap<String, Integer> map = new ConcurrentHashMap<String, Integer>(); 
     assertEquals("Wrong result", value, ConcurrentUtils.createIfAbsentUnchecked(map, key, new ConstantInitializer<Integer>(value))); 
     assertEquals("Wrong value in map", value, map.get(key)); 
 }
@Test
public void testCreateIfAbsentUncheckedException207() throws ConcurrentException { 
     @SuppressWarnings("unchecked") 
     final ConcurrentInitializer<Integer> init = EasyMock.createMock(ConcurrentInitializer.class); 
     final Exception ex = new Exception(); 
     EasyMock.expect(init.get()).andThrow(new ConcurrentException(ex)); 
     EasyMock.replay(init); 
     try { 
         ConcurrentUtils.createIfAbsentUnchecked(new ConcurrentHashMap<String, Integer>(), "test", init); 
         fail("Exception not thrown!"); 
     } catch (final ConcurrentRuntimeException crex) { 
         assertEquals("Wrong cause", ex, crex.getCause()); 
     } 
     EasyMock.verify(init); 
 }
@Test
public void testConstantFuture_null208() throws Exception { 
     final Integer value = null; 
     final Future<Integer> test = ConcurrentUtils.constantFuture(value); 
     assertTrue(test.isDone()); 
     assertSame(value, test.get()); 
     assertSame(value, test.get(1000, TimeUnit.SECONDS)); 
     assertSame(value, test.get(1000, null)); 
     assertFalse(test.isCancelled()); 
     assertFalse(test.cancel(true)); 
     assertFalse(test.cancel(false)); 
 }
     * Tests extractCause() if the cause is a checked exception.
     */
    

    /**
     * Tests extractCauseUnchecked() for a null exception.
     */
    

    /**
     * Tests extractCauseUnchecked() if the cause of the passed in exception is null.
     */
    

    /**
     * Tests extractCauseUnchecked() if the cause is an error.
     */
    

    /**
     * Tests extractCauseUnchecked() if the cause is an unchecked exception.
     */
    

    /**
     * Tests extractCauseUnchecked() if the cause is a checked exception.
     */
    

    /**
     * Tests handleCause() if the cause is an error.
     */
    

    /**
     * Tests handleCause() if the cause is an unchecked exception.
     */
    

    /**
     * Tests handleCause() if the cause is a checked exception.
     */
    

    /**
     * Tests handleCause() for a null parameter or a null cause. In this case
     * the method should do nothing. We can only test that no exception is
     * thrown.
     */
    

    /**
     * Tests handleCauseUnchecked() if the cause is an error.
     */
    

    /**
     * Tests handleCauseUnchecked() if the cause is an unchecked exception.
     */
    

    /**
     * Tests handleCauseUnchecked() if the cause is a checked exception.
     */
    

    /**
     * Tests handleCauseUnchecked() for a null parameter or a null cause. In
     * this case the method should do nothing. We can only test that no
     * exception is thrown.
     */
    

    //-----------------------------------------------------------------------
    /**
     * Tests initialize() for a null argument.
     */
    

    /**
     * Tests a successful initialize() operation.
     */
    

    /**
     * Tests initializeUnchecked() for a null argument.
     */
    

    /**
     * Tests a successful initializeUnchecked() operation.
     */
    

    /**
     * Tests whether exceptions are correctly handled by initializeUnchecked().
     */
    

    //-----------------------------------------------------------------------
    /**
     * Tests constant future.
     */
    

    /**
     * Tests constant future.
     */
    

    //-----------------------------------------------------------------------
    /**
     * Tests putIfAbsent() if the map contains the key in question.
     */
    

    /**
     * Tests putIfAbsent() if the map does not contain the key in question.
     */
    

    /**
     * Tests putIfAbsent() if a null map is passed in.
     */
    

    /**
     * Tests createIfAbsent() if the key is found in the map.
     */
    

    /**
     * Tests createIfAbsent() if the map does not contain the key in question.
     */
    

    /**
     * Tests createIfAbsent() if a null map is passed in.
     */
    

    /**
     * Tests createIfAbsent() if a null initializer is passed in.
     */
    

    /**
     * Tests createIfAbsentUnchecked() if no exception is thrown.
     */
    

    /**
     * Tests createIfAbsentUnchecked() if an exception is thrown.
     */
    
}
