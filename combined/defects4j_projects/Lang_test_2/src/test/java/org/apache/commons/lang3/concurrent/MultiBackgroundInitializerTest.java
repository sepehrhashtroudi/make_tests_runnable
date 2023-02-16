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
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.junit.Before;
import org.junit.Test;

/**
 * Test class for {@link MultiBackgroundInitializer}.
 *
 * @version $Id$
 */
public class MultiBackgroundInitializerTest {
    /** Constant for the names of the child initializers. */
    private static final String CHILD_INIT = "childInitializer";

    /** The initializer to be tested. */
    private MultiBackgroundInitializer initializer;

    @Before
    public void setUp() throws Exception {
        initializer = new MultiBackgroundInitializer();
    }

    /**
     * Tests whether a child initializer has been executed. Optionally the
     * expected executor service can be checked, too.
     *
     * @param child the child initializer
     * @param expExec the expected executor service (null if the executor should
     * not be checked)
     * @throws ConcurrentException if an error occurs
     */
    private void checkChild(final BackgroundInitializer<?> child,
            final ExecutorService expExec) throws ConcurrentException {
        final ChildBackgroundInitializer cinit = (ChildBackgroundInitializer) child;
        final Integer result = cinit.get();
        assertEquals("Wrong result", 1, result.intValue());
        assertEquals("Wrong number of executions", 1, cinit.initializeCalls);
        if (expExec != null) {
            assertEquals("Wrong executor service", expExec,
                    cinit.currentExecutor);
        }
    }

    /**
     * Tests addInitializer() if a null name is passed in. This should cause an
     * exception.
     */
    

    /**
     * Tests addInitializer() if a null initializer is passed in. This should
     * cause an exception.
     */
    

    /**
     * Tests the background processing if there are no child initializers.
     */
    

    /**
     * Helper method for testing the initialize() method. This method can
     * operate with both an external and a temporary executor service.
     *
     * @return the result object produced by the initializer
     */
    private MultiBackgroundInitializer.MultiBackgroundInitializerResults checkInitialize()
            throws ConcurrentException {
        final int count = 5;
        for (int i = 0; i < count; i++) {
            initializer.addInitializer(CHILD_INIT + i,
                    new ChildBackgroundInitializer());
        }
        initializer.start();
        final MultiBackgroundInitializer.MultiBackgroundInitializerResults res = initializer
                .get();
        assertEquals("Wrong number of child initializers", count, res
                .initializerNames().size());
        for (int i = 0; i < count; i++) {
            final String key = CHILD_INIT + i;
            assertTrue("Name not found: " + key, res.initializerNames()
                    .contains(key));
            assertEquals("Wrong result object", Integer.valueOf(1), res
                    .getResultObject(key));
            assertFalse("Exception flag", res.isException(key));
            assertNull("Got an exception", res.getException(key));
            checkChild(res.getInitializer(key), initializer.getActiveExecutor());
        }
        return res;
    }

    /**
     * Tests background processing if a temporary executor is used.
     */
    

    /**
     * Tests background processing if an external executor service is provided.
     */
    

    /**
     * Tests the behavior of initialize() if a child initializer has a specific
     * executor service. Then this service should not be overridden.
     */
    

    /**
     * Tries to add another child initializer after the start() method has been
     * called. This should not be allowed.
     */
    

    /**
     * Tries to query an unknown child initializer from the results object. This
     * should cause an exception.
     */
    

    /**
     * Tries to query the results of an unknown child initializer from the
     * results object. This should cause an exception.
     */
    

    /**
     * Tries to query the exception of an unknown child initializer from the
     * results object. This should cause an exception.
     */
    

    /**
     * Tries to query the exception flag of an unknown child initializer from
     * the results object. This should cause an exception.
     */
    

    /**
     * Tests that the set with the names of the initializers cannot be modified.
     */
    

    /**
     * Tests the behavior of the initializer if one of the child initializers
     * throws a runtime exception.
     */
    

    /**
     * Tests the behavior of the initializer if one of the child initializers
     * throws a checked exception.
     */
    

    /**
     * Tests the isSuccessful() method of the result object if no child
     * initializer has thrown an exception.
     */
    

    /**
     * Tests the isSuccessful() method of the result object if at least one
     * child initializer has thrown an exception.
     */
    

    /**
     * Tests whether MultiBackgroundInitializers can be combined in a nested
     * way.
     */
    

    /**
     * A concrete implementation of {@code BackgroundInitializer} used for
     * defining background tasks for {@code MultiBackgroundInitializer}.
     */
    private static class ChildBackgroundInitializer extends
            BackgroundInitializer<Integer> {
        /** Stores the current executor service. */
        volatile ExecutorService currentExecutor;

        /** A counter for the invocations of initialize(). */
        volatile int initializeCalls;

        /** An exception to be thrown by initialize(). */
        Exception ex;

        /**
         * Records this invocation. Optionally throws an exception.
         */
        @Override
        protected Integer initialize() throws Exception {
            currentExecutor = getActiveExecutor();
            initializeCalls++;

            if (ex != null) {
                throw ex;
            }

            return Integer.valueOf(initializeCalls);
        }
    }
}
