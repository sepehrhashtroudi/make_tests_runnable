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
public void testInitializeUncheckedNull110() { 
     assertNull("Got a result", ConcurrentUtils.initializeUnchecked(null)); 
 }
@Test
public void testCreateIfAbsentUncheckedException290() throws ConcurrentException { 
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
public void testCreateIfAbsentUncheckedException460() throws ConcurrentException { 
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
public void testCreateIfAbsentKeyPresent1095() throws ConcurrentException { 
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
public void testInitializeUncheckedEx1450() throws ConcurrentException { 
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
public void testPutIfAbsentKeyPresent1476() { 
     final String key = "testKey"; 
     final Integer value = 42; 
     final ConcurrentMap<String, Integer> map = new ConcurrentHashMap<String, Integer>(); 
     map.put(key, value); 
     assertEquals("Wrong result", value, ConcurrentUtils.putIfAbsent(map, key, 0)); 
     assertEquals("Wrong value in map", value, map.get(key)); 
 }
@Test
public void testCreateIfAbsentUncheckedException1534() throws ConcurrentException { 
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
public void testInitializeNull1584() throws ConcurrentException { 
     assertNull("Got a result", ConcurrentUtils.initialize(null)); 
 }
@Test
public void testCreateIfAbsentKeyPresent1642() throws ConcurrentException { 
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
public void testConstantFuture_Integer1675() throws Exception { 
     final Integer value = Integer.valueOf(5); 
     final Future<Integer> test = ConcurrentUtils.constantFuture(value); 
     assertTrue(test.isDone()); 
     assertSame(value, test.get()); 
     assertSame(value, test.get(1000, TimeUnit.SECONDS)); 
     assertSame(value, test.get(1000, null)); 
     assertFalse(test.isCancelled()); 
     assertFalse(test.cancel(true)); 
     assertFalse(test.cancel(false)); 
 }
@Test
public void testPutIfAbsentKeyPresent1768() { 
     final String key = "testKey"; 
     final Integer value = 42; 
     final ConcurrentMap<String, Integer> map = new ConcurrentHashMap<String, Integer>(); 
     map.put(key, value); 
     assertEquals("Wrong result", value, ConcurrentUtils.putIfAbsent(map, key, 0)); 
     assertEquals("Wrong value in map", value, map.get(key)); 
 }
@Test
public void testExtractCauseUncheckedChecked1795() { 
     final Exception ex = new Exception("Test"); 
     final ConcurrentRuntimeException cex = ConcurrentUtils.extractCauseUnchecked(new ExecutionException(ex)); 
     assertSame("Wrong cause", ex, cex.getCause()); 
 }
@Test
public void testCreateIfAbsentUncheckedException2047() throws ConcurrentException { 
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
public void testHandleCauseUncheckedUncheckedException2439() { 
     final RuntimeException rex = new RuntimeException("Test"); 
     try { 
         ConcurrentUtils.handleCauseUnchecked(new ExecutionException(rex)); 
         fail("Runtime exception not thrown!"); 
     } catch (final RuntimeException r) { 
         assertEquals("Wrong exception", rex, r); 
     } 
 }
@Test
public void testConstantFuture_Integer2546() throws Exception { 
     final Integer value = Integer.valueOf(5); 
     final Future<Integer> test = ConcurrentUtils.constantFuture(value); 
     assertTrue(test.isDone()); 
     assertSame(value, test.get()); 
     assertSame(value, test.get(1000, TimeUnit.SECONDS)); 
     assertSame(value, test.get(1000, null)); 
     assertFalse(test.isCancelled()); 
     assertFalse(test.cancel(true)); 
     assertFalse(test.cancel(false)); 
 }
@Test
public void testPutIfAbsentKeyPresent2852() { 
     final String key = "testKey"; 
     final Integer value = 42; 
     final ConcurrentMap<String, Integer> map = new ConcurrentHashMap<String, Integer>(); 
     map.put(key, value); 
     assertEquals("Wrong result", value, ConcurrentUtils.putIfAbsent(map, key, 0)); 
     assertEquals("Wrong value in map", value, map.get(key)); 
 }
@Test
public void testInitializeUncheckedEx2927() throws ConcurrentException { 
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
public void testPutIfAbsentKeyPresent2969() { 
     final String key = "testKey"; 
     final Integer value = 42; 
     final ConcurrentMap<String, Integer> map = new ConcurrentHashMap<String, Integer>(); 
     map.put(key, value); 
     assertEquals("Wrong result", value, ConcurrentUtils.putIfAbsent(map, key, 0)); 
     assertEquals("Wrong value in map", value, map.get(key)); 
 }
@Test
public void testExtractCauseUncheckedChecked3169() { 
     final Exception ex = new Exception("Test"); 
     final ConcurrentRuntimeException cex = ConcurrentUtils.extractCauseUnchecked(new ExecutionException(ex)); 
     assertSame("Wrong cause", ex, cex.getCause()); 
 }
@Test
public void testConstantFuture_Integer3435() throws Exception { 
     final Integer value = Integer.valueOf(5); 
     final Future<Integer> test = ConcurrentUtils.constantFuture(value); 
     assertTrue(test.isDone()); 
     assertSame(value, test.get()); 
     assertSame(value, test.get(1000, TimeUnit.SECONDS)); 
     assertSame(value, test.get(1000, null)); 
     assertFalse(test.isCancelled()); 
     assertFalse(test.cancel(true)); 
     assertFalse(test.cancel(false)); 
 }
@Test
public void testHandleCauseChecked3492() { 
     final Exception ex = new Exception("Test"); 
     try { 
         ConcurrentUtils.handleCause(new ExecutionException(ex)); 
         fail("ConcurrentException not thrown!"); 
     } catch (final ConcurrentException cex) { 
         assertEquals("Wrong cause", ex, cex.getCause()); 
     } 
 }
@Test
public void testConstantFuture_Integer3493() throws Exception { 
     final Integer value = Integer.valueOf(5); 
     final Future<Integer> test = ConcurrentUtils.constantFuture(value); 
     assertTrue(test.isDone()); 
     assertSame(value, test.get()); 
     assertSame(value, test.get(1000, TimeUnit.SECONDS)); 
     assertSame(value, test.get(1000, null)); 
     assertFalse(test.isCancelled()); 
     assertFalse(test.cancel(true)); 
     assertFalse(test.cancel(false)); 
 }
@Test(expected = IllegalArgumentException.class) 
 public void testConcurrentRuntimeExceptionCauseUnchecked3669() { 
     new ConcurrentRuntimeException(new RuntimeException()); 
 }
@Test
public void testConstantFuture_Integer3832() throws Exception { 
     final Integer value = Integer.valueOf(5); 
     final Future<Integer> test = ConcurrentUtils.constantFuture(value); 
     assertTrue(test.isDone()); 
     assertSame(value, test.get()); 
     assertSame(value, test.get(1000, TimeUnit.SECONDS)); 
     assertSame(value, test.get(1000, null)); 
     assertFalse(test.isCancelled()); 
     assertFalse(test.cancel(true)); 
     assertFalse(test.cancel(false)); 
 }
@Test
public void testExtractCauseError3868() { 
     final Error err = new AssertionError("Test"); 
     try { 
         ConcurrentUtils.extractCause(new ExecutionException(err)); 
         fail("Error not thrown!"); 
     } catch (final Error e) { 
         assertEquals("Wrong error", err, e); 
     } 
 }
@Test
public void testHandleCauseChecked3870() { 
     final Exception ex = new Exception("Test"); 
     try { 
         ConcurrentUtils.handleCause(new ExecutionException(ex)); 
         fail("ConcurrentException not thrown!"); 
     } catch (final ConcurrentException cex) { 
         assertEquals("Wrong cause", ex, cex.getCause()); 
     } 
 }
@Test
public void testCreateIfAbsentUncheckedException4148() throws ConcurrentException { 
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
@Test(expected = IllegalArgumentException.class) 
 public void testConcurrentRuntimeExceptionCauseUnchecked4259() { 
     new ConcurrentRuntimeException(new RuntimeException()); 
 }
@Test
public void testHandleCauseChecked4437() { 
     final Exception ex = new Exception("Test"); 
     try { 
         ConcurrentUtils.handleCause(new ExecutionException(ex)); 
         fail("ConcurrentException not thrown!"); 
     } catch (final ConcurrentException cex) { 
         assertEquals("Wrong cause", ex, cex.getCause()); 
     } 
 }
@Test
public void testConstantFuture_Integer4466() throws Exception { 
     final Integer value = Integer.valueOf(5); 
     final Future<Integer> test = ConcurrentUtils.constantFuture(value); 
     assertTrue(test.isDone()); 
     assertSame(value, test.get()); 
     assertSame(value, test.get(1000, TimeUnit.SECONDS)); 
     assertSame(value, test.get(1000, null)); 
     assertFalse(test.isCancelled()); 
     assertFalse(test.cancel(true)); 
     assertFalse(test.cancel(false)); 
 }
@Test
public void testCreateIfAbsentNullMap4617() throws ConcurrentException { 
     @SuppressWarnings("unchecked") 
     final ConcurrentInitializer<Integer> init = EasyMock.createMock(ConcurrentInitializer.class); 
     EasyMock.replay(init); 
     assertNull("Wrong result", ConcurrentUtils.createIfAbsent(null, "test", init)); 
     EasyMock.verify(init); 
 }
@Test(expected = IllegalArgumentException.class) 
 public void testConcurrentRuntimeExceptionCauseUnchecked4692() { 
     new ConcurrentRuntimeException(new RuntimeException()); 
 }
@Test
public void testExtractCauseNullCause4709() { 
     assertNull("Non null result", ConcurrentUtils.extractCause(new ExecutionException("Test", null))); 
 }
@Test
public void testCreateIfAbsentKeyPresent4711() throws ConcurrentException { 
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
public void testConstantFuture_Integer5229() throws Exception { 
     final Integer value = Integer.valueOf(5); 
     final Future<Integer> test = ConcurrentUtils.constantFuture(value); 
     assertTrue(test.isDone()); 
     assertSame(value, test.get()); 
     assertSame(value, test.get(1000, TimeUnit.SECONDS)); 
     assertSame(value, test.get(1000, null)); 
     assertFalse(test.isCancelled()); 
     assertFalse(test.cancel(true)); 
     assertFalse(test.cancel(false)); 
 }
@Test
public void testHandleCauseChecked5290() { 
     final Exception ex = new Exception("Test"); 
     try { 
         ConcurrentUtils.handleCause(new ExecutionException(ex)); 
         fail("ConcurrentException not thrown!"); 
     } catch (final ConcurrentException cex) { 
         assertEquals("Wrong cause", ex, cex.getCause()); 
     } 
 }
@Test
public void testConstantFuture_Integer5677() throws Exception { 
     final Integer value = Integer.valueOf(5); 
     final Future<Integer> test = ConcurrentUtils.constantFuture(value); 
     assertTrue(test.isDone()); 
     assertSame(value, test.get()); 
     assertSame(value, test.get(1000, TimeUnit.SECONDS)); 
     assertSame(value, test.get(1000, null)); 
     assertFalse(test.isCancelled()); 
     assertFalse(test.cancel(true)); 
     assertFalse(test.cancel(false)); 
 }
@Test
public void testHandleCauseChecked5837() { 
     final Exception ex = new Exception("Test"); 
     try { 
         ConcurrentUtils.handleCause(new ExecutionException(ex)); 
         fail("ConcurrentException not thrown!"); 
     } catch (final ConcurrentException cex) { 
         assertEquals("Wrong cause", ex, cex.getCause()); 
     } 
 }
@Test
public void testCreateIfAbsentNullMap6138() throws ConcurrentException { 
     @SuppressWarnings("unchecked") 
     final ConcurrentInitializer<Integer> init = EasyMock.createMock(ConcurrentInitializer.class); 
     EasyMock.replay(init); 
     assertNull("Wrong result", ConcurrentUtils.createIfAbsent(null, "test", init)); 
     EasyMock.verify(init); 
 }
@Test
public void testInitializeUncheckedEx6309() throws ConcurrentException { 
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
public void testCreateIfAbsentNullMap6387() throws ConcurrentException { 
     @SuppressWarnings("unchecked") 
     final ConcurrentInitializer<Integer> init = EasyMock.createMock(ConcurrentInitializer.class); 
     EasyMock.replay(init); 
     assertNull("Wrong result", ConcurrentUtils.createIfAbsent(null, "test", init)); 
     EasyMock.verify(init); 
 }
@Test
public void testHandleCauseChecked6508() { 
     final Exception ex = new Exception("Test"); 
     try { 
         ConcurrentUtils.handleCause(new ExecutionException(ex)); 
         fail("ConcurrentException not thrown!"); 
     } catch (final ConcurrentException cex) { 
         assertEquals("Wrong cause", ex, cex.getCause()); 
     } 
 }
@Test
public void testInitializeUncheckedNull6512() { 
     assertNull("Got a result", ConcurrentUtils.initializeUnchecked(null)); 
 }
@Test
public void testHandleCauseChecked6754() { 
     final Exception ex = new Exception("Test"); 
     try { 
         ConcurrentUtils.handleCause(new ExecutionException(ex)); 
         fail("ConcurrentException not thrown!"); 
     } catch (final ConcurrentException cex) { 
         assertEquals("Wrong cause", ex, cex.getCause()); 
     } 
 }
@Test
public void testHandleCauseChecked6858() { 
     final Exception ex = new Exception("Test"); 
     try { 
         ConcurrentUtils.handleCause(new ExecutionException(ex)); 
         fail("ConcurrentException not thrown!"); 
     } catch (final ConcurrentException cex) { 
         assertEquals("Wrong cause", ex, cex.getCause()); 
     } 
 }
@Test
public void testExtractCauseUncheckedNull7818() { 
     assertNull("Non null result", ConcurrentUtils.extractCauseUnchecked(null)); 
 }
@Test
public void testHandleCauseChecked7826() { 
     final Exception ex = new Exception("Test"); 
     try { 
         ConcurrentUtils.handleCause(new ExecutionException(ex)); 
         fail("ConcurrentException not thrown!"); 
     } catch (final ConcurrentException cex) { 
         assertEquals("Wrong cause", ex, cex.getCause()); 
     } 
 }
@Test
public void testConstantFuture_Integer7898() throws Exception { 
     final Integer value = Integer.valueOf(5); 
     final Future<Integer> test = ConcurrentUtils.constantFuture(value); 
     assertTrue(test.isDone()); 
     assertSame(value, test.get()); 
     assertSame(value, test.get(1000, TimeUnit.SECONDS)); 
     assertSame(value, test.get(1000, null)); 
     assertFalse(test.isCancelled()); 
     assertFalse(test.cancel(true)); 
     assertFalse(test.cancel(false)); 
 }
@Test
public void testConstantFuture_Integer8089() throws Exception { 
     final Integer value = Integer.valueOf(5); 
     final Future<Integer> test = ConcurrentUtils.constantFuture(value); 
     assertTrue(test.isDone()); 
     assertSame(value, test.get()); 
     assertSame(value, test.get(1000, TimeUnit.SECONDS)); 
     assertSame(value, test.get(1000, null)); 
     assertFalse(test.isCancelled()); 
     assertFalse(test.cancel(true)); 
     assertFalse(test.cancel(false)); 
 }
@Test
public void testConstantFuture_Integer8203() throws Exception { 
     final Integer value = Integer.valueOf(5); 
     final Future<Integer> test = ConcurrentUtils.constantFuture(value); 
     assertTrue(test.isDone()); 
     assertSame(value, test.get()); 
     assertSame(value, test.get(1000, TimeUnit.SECONDS)); 
     assertSame(value, test.get(1000, null)); 
     assertFalse(test.isCancelled()); 
     assertFalse(test.cancel(true)); 
     assertFalse(test.cancel(false)); 
 }
@Test
public void testConstantFuture_Integer8208() throws Exception { 
     final Integer value = Integer.valueOf(5); 
     final Future<Integer> test = ConcurrentUtils.constantFuture(value); 
     assertTrue(test.isDone()); 
     assertSame(value, test.get()); 
     assertSame(value, test.get(1000, TimeUnit.SECONDS)); 
     assertSame(value, test.get(1000, null)); 
     assertFalse(test.isCancelled()); 
     assertFalse(test.cancel(true)); 
     assertFalse(test.cancel(false)); 
 }
@Test
public void testConstantFuture_Integer8236() throws Exception { 
     final Integer value = Integer.valueOf(5); 
     final Future<Integer> test = ConcurrentUtils.constantFuture(value); 
     assertTrue(test.isDone()); 
     assertSame(value, test.get()); 
     assertSame(value, test.get(1000, TimeUnit.SECONDS)); 
     assertSame(value, test.get(1000, null)); 
     assertFalse(test.isCancelled()); 
     assertFalse(test.cancel(true)); 
     assertFalse(test.cancel(false)); 
 }
@Test
public void testPutIfAbsentNullMap8544() { 
     assertNull("Wrong result", ConcurrentUtils.putIfAbsent(null, "test", 100)); 
 }
@Test
public void testInitializeNull8893() throws ConcurrentException { 
     assertNull("Got a result", ConcurrentUtils.initialize(null)); 
 }
@Test
public void testConstantFuture_Integer8965() throws Exception { 
     final Integer value = Integer.valueOf(5); 
     final Future<Integer> test = ConcurrentUtils.constantFuture(value); 
     assertTrue(test.isDone()); 
     assertSame(value, test.get()); 
     assertSame(value, test.get(1000, TimeUnit.SECONDS)); 
     assertSame(value, test.get(1000, null)); 
     assertFalse(test.isCancelled()); 
     assertFalse(test.cancel(true)); 
     assertFalse(test.cancel(false)); 
 }
@Test
public void testHandleCauseChecked9246() { 
     final Exception ex = new Exception("Test"); 
     try { 
         ConcurrentUtils.handleCause(new ExecutionException(ex)); 
         fail("ConcurrentException not thrown!"); 
     } catch (final ConcurrentException cex) { 
         assertEquals("Wrong cause", ex, cex.getCause()); 
     } 
 }
@Test
public void testInitializeUncheckedNull9305() { 
     assertNull("Got a result", ConcurrentUtils.initializeUnchecked(null)); 
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
