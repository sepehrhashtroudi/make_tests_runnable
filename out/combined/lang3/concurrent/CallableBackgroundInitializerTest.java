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

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.junit.Test;

/**
 * Test class for {@code CallableBackgroundInitializer}
 *
 * @version $Id$
 */
public class CallableBackgroundInitializerTest  {
    /** Constant for the result of the call() invocation. */
    private static final Integer RESULT = Integer.valueOf(42);

    /**
     * Tries to create an instance without a Callable. This should cause an
     * exception.
     */
    

    /**
     * Tests whether the executor service is correctly passed to the super
     * class.
     */
    

    /**
@Test
public void testInitialize122() throws Exception { 
     final TestCallable call = new TestCallable(); 
     final CallableBackgroundInitializer<Integer> init = new CallableBackgroundInitializer<Integer>(call); 
     assertEquals("Wrong result", RESULT, init.initialize()); 
     assertEquals("Wrong number of invocations", 1, call.callCount); 
 }
@Test(expected = IllegalArgumentException.class) 
 public void testInitExecutorNullCallable373() { 
     final ExecutorService exec = Executors.newSingleThreadExecutor(); 
     new CallableBackgroundInitializer<Integer>(null, exec); 
 }
@Test(expected = IllegalArgumentException.class) 
 public void testInitExecutorNullCallable2374() { 
     final ExecutorService exec = Executors.newSingleThreadExecutor(); 
     new CallableBackgroundInitializer<Integer>(null, exec); 
 }
@Test
public void testInitialize4546() throws Exception { 
     final TestCallable call = new TestCallable(); 
     final CallableBackgroundInitializer<Integer> init = new CallableBackgroundInitializer<Integer>(call); 
     assertEquals("Wrong result", RESULT, init.initialize()); 
     assertEquals("Wrong number of invocations", 1, call.callCount); 
 }
@Test
public void testInitialize4575() throws Exception { 
     final TestCallable call = new TestCallable(); 
     final CallableBackgroundInitializer<Integer> init = new CallableBackgroundInitializer<Integer>(call); 
     assertEquals("Wrong result", RESULT, init.initialize()); 
     assertEquals("Wrong number of invocations", 1, call.callCount); 
 }
@Test(expected = IllegalArgumentException.class) 
 public void testInitExecutorNullCallable5918() { 
     final ExecutorService exec = Executors.newSingleThreadExecutor(); 
     new CallableBackgroundInitializer<Integer>(null, exec); 
 }
@Test
public void testInitialize6814() throws Exception { 
     final TestCallable call = new TestCallable(); 
     final CallableBackgroundInitializer<Integer> init = new CallableBackgroundInitializer<Integer>(call); 
     assertEquals("Wrong result", RESULT, init.initialize()); 
     assertEquals("Wrong number of invocations", 1, call.callCount); 
 }
@Test
public void testInitExecutor6888() { 
     final ExecutorService exec = Executors.newSingleThreadExecutor(); 
     final CallableBackgroundInitializer<Integer> init = new CallableBackgroundInitializer<Integer>(new TestCallable(), exec); 
     assertEquals("Executor not set", exec, init.getExternalExecutor()); 
 }
@Test
public void testInitialize7517() throws Exception { 
     final TestCallable call = new TestCallable(); 
     final CallableBackgroundInitializer<Integer> init = new CallableBackgroundInitializer<Integer>(call); 
     assertEquals("Wrong result", RESULT, init.initialize()); 
     assertEquals("Wrong number of invocations", 1, call.callCount); 
 }
@Test(expected = IllegalArgumentException.class) 
 public void testInitExecutorNullCallable7733() { 
     final ExecutorService exec = Executors.newSingleThreadExecutor(); 
     new CallableBackgroundInitializer<Integer>(null, exec); 
 }
@Test(expected = IllegalArgumentException.class) 
 public void testInitExecutorNullCallable8148() { 
     final ExecutorService exec = Executors.newSingleThreadExecutor(); 
     new CallableBackgroundInitializer<Integer>(null, exec); 
 }
@Test(expected = IllegalArgumentException.class) 
 public void testInitExecutorNullCallable8398() { 
     final ExecutorService exec = Executors.newSingleThreadExecutor(); 
     new CallableBackgroundInitializer<Integer>(null, exec); 
 }
     * Tries to pass a null Callable to the constructor that takes an executor.
     * This should cause an exception.
     */
    

    /**
     * Tests the implementation of initialize().
     */
    

    /**
     * A test Callable implementation for checking the initializer's
     * implementation of the initialize() method.
     */
    private static class TestCallable implements Callable<Integer> {
        /** A counter for the number of call() invocations. */
        int callCount;

        /**
         * Records this invocation and returns the test result.
         */
        @Override
        public Integer call() throws Exception {
            callCount++;
            return RESULT;
        }
    }
}
