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
@Test(expected = UnsupportedOperationException.class) 
 public void testResultInitializerNamesModify103() throws ConcurrentException { 
     checkInitialize(); 
     final MultiBackgroundInitializer.MultiBackgroundInitializerResults res = initializer.get(); 
     final Iterator<String> it = res.initializerNames().iterator(); 
     it.next(); 
     it.remove(); 
 }
@Test(expected = UnsupportedOperationException.class) 
 public void testResultInitializerNamesModify314() throws ConcurrentException { 
     checkInitialize(); 
     final MultiBackgroundInitializer.MultiBackgroundInitializerResults res = initializer.get(); 
     final Iterator<String> it = res.initializerNames().iterator(); 
     it.next(); 
     it.remove(); 
 }
@Test(expected = UnsupportedOperationException.class) 
 public void testResultInitializerNamesModify419() throws ConcurrentException { 
     checkInitialize(); 
     final MultiBackgroundInitializer.MultiBackgroundInitializerResults res = initializer.get(); 
     final Iterator<String> it = res.initializerNames().iterator(); 
     it.next(); 
     it.remove(); 
 }
@Test(expected = UnsupportedOperationException.class) 
 public void testResultInitializerNamesModify451() throws ConcurrentException { 
     checkInitialize(); 
     final MultiBackgroundInitializer.MultiBackgroundInitializerResults res = initializer.get(); 
     final Iterator<String> it = res.initializerNames().iterator(); 
     it.next(); 
     it.remove(); 
 }
@Test(expected = UnsupportedOperationException.class) 
 public void testResultInitializerNamesModify546() throws ConcurrentException { 
     checkInitialize(); 
     final MultiBackgroundInitializer.MultiBackgroundInitializerResults res = initializer.get(); 
     final Iterator<String> it = res.initializerNames().iterator(); 
     it.next(); 
     it.remove(); 
 }
@Test(expected = UnsupportedOperationException.class) 
 public void testResultInitializerNamesModify583() throws ConcurrentException { 
     checkInitialize(); 
     final MultiBackgroundInitializer.MultiBackgroundInitializerResults res = initializer.get(); 
     final Iterator<String> it = res.initializerNames().iterator(); 
     it.next(); 
     it.remove(); 
 }
@Test(expected = UnsupportedOperationException.class) 
 public void testResultInitializerNamesModify909() throws ConcurrentException { 
     checkInitialize(); 
     final MultiBackgroundInitializer.MultiBackgroundInitializerResults res = initializer.get(); 
     final Iterator<String> it = res.initializerNames().iterator(); 
     it.next(); 
     it.remove(); 
 }
@Test(expected = UnsupportedOperationException.class) 
 public void testResultInitializerNamesModify1018() throws ConcurrentException { 
     checkInitialize(); 
     final MultiBackgroundInitializer.MultiBackgroundInitializerResults res = initializer.get(); 
     final Iterator<String> it = res.initializerNames().iterator(); 
     it.next(); 
     it.remove(); 
 }
@Test(expected = UnsupportedOperationException.class) 
 public void testResultInitializerNamesModify1055() throws ConcurrentException { 
     checkInitialize(); 
     final MultiBackgroundInitializer.MultiBackgroundInitializerResults res = initializer.get(); 
     final Iterator<String> it = res.initializerNames().iterator(); 
     it.next(); 
     it.remove(); 
 }
@Test(expected = UnsupportedOperationException.class) 
 public void testResultInitializerNamesModify1160() throws ConcurrentException { 
     checkInitialize(); 
     final MultiBackgroundInitializer.MultiBackgroundInitializerResults res = initializer.get(); 
     final Iterator<String> it = res.initializerNames().iterator(); 
     it.next(); 
     it.remove(); 
 }
@Test(expected = UnsupportedOperationException.class) 
 public void testResultInitializerNamesModify1161() throws ConcurrentException { 
     checkInitialize(); 
     final MultiBackgroundInitializer.MultiBackgroundInitializerResults res = initializer.get(); 
     final Iterator<String> it = res.initializerNames().iterator(); 
     it.next(); 
     it.remove(); 
 }
@Test
public void testInitializeNested1371() throws ConcurrentException { 
     final String nameMulti = "multiChildInitializer"; 
     initializer.addInitializer(CHILD_INIT, new ChildBackgroundInitializer()); 
     final MultiBackgroundInitializer mi2 = new MultiBackgroundInitializer(); 
     final int count = 3; 
     for (int i = 0; i < count; i++) { 
         mi2.addInitializer(CHILD_INIT + i, new ChildBackgroundInitializer()); 
     } 
     initializer.addInitializer(nameMulti, mi2); 
     initializer.start(); 
     final MultiBackgroundInitializer.MultiBackgroundInitializerResults res = initializer.get(); 
     final ExecutorService exec = initializer.getActiveExecutor(); 
     checkChild(res.getInitializer(CHILD_INIT), exec); 
     final MultiBackgroundInitializer.MultiBackgroundInitializerResults res2 = (MultiBackgroundInitializer.MultiBackgroundInitializerResults) res.getResultObject(nameMulti); 
     assertEquals("Wrong number of initializers", count, res2.initializerNames().size()); 
     for (int i = 0; i < count; i++) { 
         checkChild(res2.getInitializer(CHILD_INIT + i), exec); 
     } 
     assertTrue("Executor not shutdown", exec.isShutdown()); 
 }
@Test(expected = UnsupportedOperationException.class) 
 public void testResultInitializerNamesModify1623() throws ConcurrentException { 
     checkInitialize(); 
     final MultiBackgroundInitializer.MultiBackgroundInitializerResults res = initializer.get(); 
     final Iterator<String> it = res.initializerNames().iterator(); 
     it.next(); 
     it.remove(); 
 }
@Test
public void testInitializeExternalExec1710() throws ConcurrentException { 
     final ExecutorService exec = Executors.newCachedThreadPool(); 
     try { 
         initializer = new MultiBackgroundInitializer(exec); 
         checkInitialize(); 
         assertEquals("Wrong executor", exec, initializer.getActiveExecutor()); 
         assertFalse("Executor was shutdown", exec.isShutdown()); 
     } finally { 
         exec.shutdown(); 
     } 
 }
@Test(expected = UnsupportedOperationException.class) 
 public void testResultInitializerNamesModify1810() throws ConcurrentException { 
     checkInitialize(); 
     final MultiBackgroundInitializer.MultiBackgroundInitializerResults res = initializer.get(); 
     final Iterator<String> it = res.initializerNames().iterator(); 
     it.next(); 
     it.remove(); 
 }
@Test(expected = UnsupportedOperationException.class) 
 public void testResultInitializerNamesModify2560() throws ConcurrentException { 
     checkInitialize(); 
     final MultiBackgroundInitializer.MultiBackgroundInitializerResults res = initializer.get(); 
     final Iterator<String> it = res.initializerNames().iterator(); 
     it.next(); 
     it.remove(); 
 }
@Test(expected = UnsupportedOperationException.class) 
 public void testResultInitializerNamesModify2996() throws ConcurrentException { 
     checkInitialize(); 
     final MultiBackgroundInitializer.MultiBackgroundInitializerResults res = initializer.get(); 
     final Iterator<String> it = res.initializerNames().iterator(); 
     it.next(); 
     it.remove(); 
 }
@Test(expected = IllegalArgumentException.class) 
 public void testAddInitializerNullInit3116() { 
     initializer.addInitializer(CHILD_INIT, null); 
 }
@Test(expected = UnsupportedOperationException.class) 
 public void testResultInitializerNamesModify3301() throws ConcurrentException { 
     checkInitialize(); 
     final MultiBackgroundInitializer.MultiBackgroundInitializerResults res = initializer.get(); 
     final Iterator<String> it = res.initializerNames().iterator(); 
     it.next(); 
     it.remove(); 
 }
@Test
public void testAddInitializerAfterStart3857() throws ConcurrentException { 
     initializer.start(); 
     try { 
         initializer.addInitializer(CHILD_INIT, new ChildBackgroundInitializer()); 
         fail("Could add initializer after start()!"); 
     } catch (final IllegalStateException istex) { 
         initializer.get(); 
     } 
 }
@Test(expected = UnsupportedOperationException.class) 
 public void testResultInitializerNamesModify3921() throws ConcurrentException { 
     checkInitialize(); 
     final MultiBackgroundInitializer.MultiBackgroundInitializerResults res = initializer.get(); 
     final Iterator<String> it = res.initializerNames().iterator(); 
     it.next(); 
     it.remove(); 
 }
@Test(expected = UnsupportedOperationException.class) 
 public void testResultInitializerNamesModify4057() throws ConcurrentException { 
     checkInitialize(); 
     final MultiBackgroundInitializer.MultiBackgroundInitializerResults res = initializer.get(); 
     final Iterator<String> it = res.initializerNames().iterator(); 
     it.next(); 
     it.remove(); 
 }
@Test(expected = UnsupportedOperationException.class) 
 public void testResultInitializerNamesModify4285() throws ConcurrentException { 
     checkInitialize(); 
     final MultiBackgroundInitializer.MultiBackgroundInitializerResults res = initializer.get(); 
     final Iterator<String> it = res.initializerNames().iterator(); 
     it.next(); 
     it.remove(); 
 }
@Test(expected = UnsupportedOperationException.class) 
 public void testResultInitializerNamesModify4336() throws ConcurrentException { 
     checkInitialize(); 
     final MultiBackgroundInitializer.MultiBackgroundInitializerResults res = initializer.get(); 
     final Iterator<String> it = res.initializerNames().iterator(); 
     it.next(); 
     it.remove(); 
 }
@Test(expected = UnsupportedOperationException.class) 
 public void testResultInitializerNamesModify4550() throws ConcurrentException { 
     checkInitialize(); 
     final MultiBackgroundInitializer.MultiBackgroundInitializerResults res = initializer.get(); 
     final Iterator<String> it = res.initializerNames().iterator(); 
     it.next(); 
     it.remove(); 
 }
@Test(expected = UnsupportedOperationException.class) 
 public void testResultInitializerNamesModify4644() throws ConcurrentException { 
     checkInitialize(); 
     final MultiBackgroundInitializer.MultiBackgroundInitializerResults res = initializer.get(); 
     final Iterator<String> it = res.initializerNames().iterator(); 
     it.next(); 
     it.remove(); 
 }
@Test(expected = UnsupportedOperationException.class) 
 public void testResultInitializerNamesModify4720() throws ConcurrentException { 
     checkInitialize(); 
     final MultiBackgroundInitializer.MultiBackgroundInitializerResults res = initializer.get(); 
     final Iterator<String> it = res.initializerNames().iterator(); 
     it.next(); 
     it.remove(); 
 }
@Test(expected = UnsupportedOperationException.class) 
 public void testResultInitializerNamesModify4974() throws ConcurrentException { 
     checkInitialize(); 
     final MultiBackgroundInitializer.MultiBackgroundInitializerResults res = initializer.get(); 
     final Iterator<String> it = res.initializerNames().iterator(); 
     it.next(); 
     it.remove(); 
 }
@Test(expected = UnsupportedOperationException.class) 
 public void testResultInitializerNamesModify5044() throws ConcurrentException { 
     checkInitialize(); 
     final MultiBackgroundInitializer.MultiBackgroundInitializerResults res = initializer.get(); 
     final Iterator<String> it = res.initializerNames().iterator(); 
     it.next(); 
     it.remove(); 
 }
@Test
public void testInitializeResultsIsSuccessfulFalse5111() throws ConcurrentException { 
     final ChildBackgroundInitializer child = new ChildBackgroundInitializer(); 
     child.ex = new Exception(); 
     initializer.addInitializer(CHILD_INIT, child); 
     initializer.start(); 
     final MultiBackgroundInitializer.MultiBackgroundInitializerResults res = initializer.get(); 
     assertFalse("Wrong success flag", res.isSuccessful()); 
 }
@Test(expected = UnsupportedOperationException.class) 
 public void testResultInitializerNamesModify5286() throws ConcurrentException { 
     checkInitialize(); 
     final MultiBackgroundInitializer.MultiBackgroundInitializerResults res = initializer.get(); 
     final Iterator<String> it = res.initializerNames().iterator(); 
     it.next(); 
     it.remove(); 
 }
@Test(expected = UnsupportedOperationException.class) 
 public void testResultInitializerNamesModify5362() throws ConcurrentException { 
     checkInitialize(); 
     final MultiBackgroundInitializer.MultiBackgroundInitializerResults res = initializer.get(); 
     final Iterator<String> it = res.initializerNames().iterator(); 
     it.next(); 
     it.remove(); 
 }
@Test(expected = UnsupportedOperationException.class) 
 public void testResultInitializerNamesModify5744() throws ConcurrentException { 
     checkInitialize(); 
     final MultiBackgroundInitializer.MultiBackgroundInitializerResults res = initializer.get(); 
     final Iterator<String> it = res.initializerNames().iterator(); 
     it.next(); 
     it.remove(); 
 }
@Test(expected = UnsupportedOperationException.class) 
 public void testResultInitializerNamesModify5772() throws ConcurrentException { 
     checkInitialize(); 
     final MultiBackgroundInitializer.MultiBackgroundInitializerResults res = initializer.get(); 
     final Iterator<String> it = res.initializerNames().iterator(); 
     it.next(); 
     it.remove(); 
 }
@Test
public void testInitializeEx5983() throws ConcurrentException { 
     final ChildBackgroundInitializer child = new ChildBackgroundInitializer(); 
     child.ex = new Exception(); 
     initializer.addInitializer(CHILD_INIT, child); 
     initializer.start(); 
     final MultiBackgroundInitializer.MultiBackgroundInitializerResults res = initializer.get(); 
     assertTrue("No exception flag", res.isException(CHILD_INIT)); 
     assertNull("Got a results object", res.getResultObject(CHILD_INIT)); 
     final ConcurrentException cex = res.getException(CHILD_INIT); 
     assertEquals("Wrong cause", child.ex, cex.getCause()); 
 }
@Test
public void testInitializeNested6747() throws ConcurrentException { 
     final String nameMulti = "multiChildInitializer"; 
     initializer.addInitializer(CHILD_INIT, new ChildBackgroundInitializer()); 
     final MultiBackgroundInitializer mi2 = new MultiBackgroundInitializer(); 
     final int count = 3; 
     for (int i = 0; i < count; i++) { 
         mi2.addInitializer(CHILD_INIT + i, new ChildBackgroundInitializer()); 
     } 
     initializer.addInitializer(nameMulti, mi2); 
     initializer.start(); 
     final MultiBackgroundInitializer.MultiBackgroundInitializerResults res = initializer.get(); 
     final ExecutorService exec = initializer.getActiveExecutor(); 
     checkChild(res.getInitializer(CHILD_INIT), exec); 
     final MultiBackgroundInitializer.MultiBackgroundInitializerResults res2 = (MultiBackgroundInitializer.MultiBackgroundInitializerResults) res.getResultObject(nameMulti); 
     assertEquals("Wrong number of initializers", count, res2.initializerNames().size()); 
     for (int i = 0; i < count; i++) { 
         checkChild(res2.getInitializer(CHILD_INIT + i), exec); 
     } 
     assertTrue("Executor not shutdown", exec.isShutdown()); 
 }
@Test(expected = UnsupportedOperationException.class) 
 public void testResultInitializerNamesModify6919() throws ConcurrentException { 
     checkInitialize(); 
     final MultiBackgroundInitializer.MultiBackgroundInitializerResults res = initializer.get(); 
     final Iterator<String> it = res.initializerNames().iterator(); 
     it.next(); 
     it.remove(); 
 }
@Test(expected = UnsupportedOperationException.class) 
 public void testResultInitializerNamesModify6931() throws ConcurrentException { 
     checkInitialize(); 
     final MultiBackgroundInitializer.MultiBackgroundInitializerResults res = initializer.get(); 
     final Iterator<String> it = res.initializerNames().iterator(); 
     it.next(); 
     it.remove(); 
 }
@Test(expected = UnsupportedOperationException.class) 
 public void testResultInitializerNamesModify7301() throws ConcurrentException { 
     checkInitialize(); 
     final MultiBackgroundInitializer.MultiBackgroundInitializerResults res = initializer.get(); 
     final Iterator<String> it = res.initializerNames().iterator(); 
     it.next(); 
     it.remove(); 
 }
@Test(expected = UnsupportedOperationException.class) 
 public void testResultInitializerNamesModify7474() throws ConcurrentException { 
     checkInitialize(); 
     final MultiBackgroundInitializer.MultiBackgroundInitializerResults res = initializer.get(); 
     final Iterator<String> it = res.initializerNames().iterator(); 
     it.next(); 
     it.remove(); 
 }
@Test(expected = IllegalArgumentException.class) 
 public void testAddInitializerNullName7498() { 
     initializer.addInitializer(null, new ChildBackgroundInitializer()); 
 }
@Test(expected = UnsupportedOperationException.class) 
 public void testResultInitializerNamesModify7512() throws ConcurrentException { 
     checkInitialize(); 
     final MultiBackgroundInitializer.MultiBackgroundInitializerResults res = initializer.get(); 
     final Iterator<String> it = res.initializerNames().iterator(); 
     it.next(); 
     it.remove(); 
 }
@Test(expected = UnsupportedOperationException.class) 
 public void testResultInitializerNamesModify7725() throws ConcurrentException { 
     checkInitialize(); 
     final MultiBackgroundInitializer.MultiBackgroundInitializerResults res = initializer.get(); 
     final Iterator<String> it = res.initializerNames().iterator(); 
     it.next(); 
     it.remove(); 
 }
@Test(expected = UnsupportedOperationException.class) 
 public void testResultInitializerNamesModify7936() throws ConcurrentException { 
     checkInitialize(); 
     final MultiBackgroundInitializer.MultiBackgroundInitializerResults res = initializer.get(); 
     final Iterator<String> it = res.initializerNames().iterator(); 
     it.next(); 
     it.remove(); 
 }
@Test(expected = UnsupportedOperationException.class) 
 public void testResultInitializerNamesModify8255() throws ConcurrentException { 
     checkInitialize(); 
     final MultiBackgroundInitializer.MultiBackgroundInitializerResults res = initializer.get(); 
     final Iterator<String> it = res.initializerNames().iterator(); 
     it.next(); 
     it.remove(); 
 }
@Test(expected = UnsupportedOperationException.class) 
 public void testResultInitializerNamesModify8355() throws ConcurrentException { 
     checkInitialize(); 
     final MultiBackgroundInitializer.MultiBackgroundInitializerResults res = initializer.get(); 
     final Iterator<String> it = res.initializerNames().iterator(); 
     it.next(); 
     it.remove(); 
 }
@Test(expected = UnsupportedOperationException.class) 
 public void testResultInitializerNamesModify8389() throws ConcurrentException { 
     checkInitialize(); 
     final MultiBackgroundInitializer.MultiBackgroundInitializerResults res = initializer.get(); 
     final Iterator<String> it = res.initializerNames().iterator(); 
     it.next(); 
     it.remove(); 
 }
@Test
public void testInitializeResultsIsSuccessfulFalse8991() throws ConcurrentException { 
     final ChildBackgroundInitializer child = new ChildBackgroundInitializer(); 
     child.ex = new Exception(); 
     initializer.addInitializer(CHILD_INIT, child); 
     initializer.start(); 
     final MultiBackgroundInitializer.MultiBackgroundInitializerResults res = initializer.get(); 
     assertFalse("Wrong success flag", res.isSuccessful()); 
 }
@Test
public void testInitializeExternalExec9273() throws ConcurrentException { 
     final ExecutorService exec = Executors.newCachedThreadPool(); 
     try { 
         initializer = new MultiBackgroundInitializer(exec); 
         checkInitialize(); 
         assertEquals("Wrong executor", exec, initializer.getActiveExecutor()); 
         assertFalse("Executor was shutdown", exec.isShutdown()); 
     } finally { 
         exec.shutdown(); 
     } 
 }
@Test(expected = UnsupportedOperationException.class) 
 public void testResultInitializerNamesModify9297() throws ConcurrentException { 
     checkInitialize(); 
     final MultiBackgroundInitializer.MultiBackgroundInitializerResults res = initializer.get(); 
     final Iterator<String> it = res.initializerNames().iterator(); 
     it.next(); 
     it.remove(); 
 }
@Test(expected = UnsupportedOperationException.class) 
 public void testResultInitializerNamesModify9477() throws ConcurrentException { 
     checkInitialize(); 
     final MultiBackgroundInitializer.MultiBackgroundInitializerResults res = initializer.get(); 
     final Iterator<String> it = res.initializerNames().iterator(); 
     it.next(); 
     it.remove(); 
 }
@Test(expected = IllegalArgumentException.class) 
     public void testAddInitializerNullName11206() { 
         initializer.addInitializer(null, new ChildBackgroundInitializer()); 
     }
@Test
public void testInitialize11208() throws ConcurrentException { 
         initializer.addInitializer(CHILD_INIT, new ChildBackgroundInitializer()); 
         initializer.addInitializer(INIT_2, new ChildBackgroundInitializer()); 
         initializer.addInitializer(INIT_3, new ChildBackgroundInitializer()); 
         initializer.addInitializer(INIT_4, new ChildBackgroundInitializer()); 
         initializer.addInitializer(INIT_5, new ChildBackgroundInitializer()); 
         initializer.addInitializer(INIT_6, new ChildBackgroundInitializer()); 
         initializer.addInitializer(INIT_7, new ChildBackgroundInitializer()); 
         initializer.addInitializer(INIT_8, new ChildBackgroundInitializer()); 
         initializer.addInitializer(INIT_9, new ChildBackgroundInitializer()); 
         initializer.addInitializer(INIT_10, new ChildBackgroundInitializer()); 
         initializer.addInitializer(INIT_11, new ChildBackgroundInitializer()); 
         initializer.addInitializer(INIT_12, new ChildBackgroundInitializer()); 
         initializer.addInitializer(INIT_13, new ChildBackgroundInitializer()); 
         initializer.addInitializer(INIT_14, new ChildBackgroundInitializer()); 
         initializer.addInitializer(INIT_15, new ChildBackgroundInitializer()); 
         initializer.addInitializer(INIT_16, new ChildBackgroundInitializer()); 
         initializer.addInitializer(INIT_17, new ChildBackgroundInitializer()); 
         initializer.addInitializer(INIT_14, new ChildBackgroundInitializer()); 
     }
@Test
public void testGetResultObject11211() throws ConcurrentException { 
         initializer.addInitializer(CHILD_INIT, new ChildBackgroundInitializer()); 
         initializer.addInitializer(CHILD_INIT + 1, new ChildBackgroundInitializer()); 
         initializer.addInitializer(CHILD_INIT + 2, new ChildBackgroundInitializer()); 
         initializer.addInitializer(CHILD_INIT + 3, new ChildBackgroundInitializer()); 
         initializer.addInitializer(CHILD_INIT + 4, new ChildBackgroundInitializer()); 
         initializer.addInitializer(CHILD_INIT + 5, new ChildBackgroundInitializer()); 
         initializer.addInitializer(CHILD_INIT + 6, new ChildBackgroundInitializer()); 
         initializer.addInitializer(CHILD_INIT + 7, new ChildBackgroundInitializer()); 
         initializer.addInitializer(CHILD_INIT + 8, new ChildBackgroundInitializer()); 
         initializer.addInitializer(CHILD_INIT + 9, new ChildBackgroundInitializer()); 
         initializer.addInitializer(CHILD_INIT + 10, new ChildBackgroundInitializer()); 
         initializer.addInitializer(CHILD_INIT + 11, new ChildBackgroundInitializer()); 
         initializer.addInitializer(CHILD_INIT + 12, new ChildBackgroundInitializer()); 
         initializer.addInitializer(CHILD_INIT + 13, new ChildBackgroundInitializer()); 
          
         final MultiBackgroundInitializer.MultiBackgroundInitializerResults res = initializer.get(); 
         final MultiBackgroundInitializer.MultiBackgroundInitializerResults res2 = (MultiBackgroundInitializer.MultiBackgroundInitializerResults) res 
         assertEquals(6, res.getResultObjects().size()); 
         assertTrue(res.getResultObjects().contains(CHILD_INIT)); 
         assertTrue(res.getResultObjects().contains(CHILD_INIT)); 
         assertTrue(res.getResultObjects().contains(CHILD_INIT)); 
     }
@Test
public void testInitializeUnsuccessful11216() { 
         initializer.addInitializer(CHILD_INIT, new ChildBackgroundInitializer()); 
         initializer.addInitializer(CHILD_INIT + 1, new ChildBackgroundInitializer()); 
         initializer.addInitializer(CHILD_INIT + 2, new ChildBackgroundInitializer()); 
         initializer.addInitializer(CHILD_INIT + 3, new ChildBackgroundInitializer()); 
         initializer.addInitializer(CHILD_INIT + 4, new ChildBackgroundInitializer()); 
         initializer.addInitializer(CHILD_INIT + 5, new ChildBackgroundInitializer()); 
         initializer.addInitializer(CHILD_INIT + 6, new ChildBackgroundInitializer()); 
         initializer.addInitializer(CHILD_INIT + 7, new ChildBackgroundInitializer()); 
         initializer.addInitializer(CHILD_INIT + 8, new ChildBackgroundInitializer()); 
         initializer.addInitializer(CHILD_INIT + 9, new ChildBackgroundInitializer()); 
         initializer.addInitializer(CHILD_INIT + 10, new ChildBackgroundInitializer()); 
         initializer.addInitializer(CHILD_INIT + 11, new ChildBackgroundInitializer()); 
         initializer.addInitializer(CHILD_INIT + 12, new ChildBackgroundInitializer()); 
  
         final MultiBackgroundInitializer.MultiBackgroundInitializerResults res = initializer 
                 .get(); 
         assertFalse("Wrong success flag", res.isSuccessful()); 
     }
@Test(expected = IllegalArgumentException.class) 
     public void testAddInitializerNullName11219() { 
         initializer.addInitializer(null, new ChildBackgroundInitializer()); 
     }
@Test(expected = IllegalArgumentException.class) 
     public void testAddInitializerNullName11222() { 
         initializer.addInitializer(null, new ChildBackgroundInitializer()); 
     }
@Test
public void testInitializeUnsuccessful11223() { 
         initializer.addInitializer(CHILD_INIT, new ChildBackgroundInitializer()); 
         initializer.addInitializer(CHILD_INIT_2, new ChildBackgroundInitializer()); 
         initializer.addInitializer(CHILD_INIT_3, new ChildBackgroundInitializer()); 
         initializer.addInitializer(CHILD_INIT_4, new ChildBackgroundInitializer()); 
         initializer.addInitializer(CHILD_INIT_5, new ChildBackgroundInitializer()); 
         initializer.addInitializer(CHILD_INIT_6, new ChildBackgroundInitializer()); 
         initializer.addInitializer(CHILD_INIT_7, new ChildBackgroundInitializer()); 
         initializer.addInitializer(CHILD_INIT_8, new ChildBackgroundInitializer()); 
         initializer.addInitializer(CHILD_INIT_9, new ChildBackgroundInitializer()); 
         initializer.addInitializer(CHILD_INIT_10, new ChildBackgroundInitializer()); 
         initializer.addInitializer(CHILD_INIT_11, new ChildBackgroundInitializer()); 
         initializer.addInitializer(CHILD_INIT_12, new ChildBackgroundInitializer()); 
         initializer.addInitializer(CHILD_INIT_13, new ChildBackgroundInitializer()); 
         initializer.addInitializer(CHILD_INIT_14, new ChildBackgroundInitializer()); 
         initializer.addInitializer(CHILD_INIT_15, new ChildBackgroundInitializer()); 
     }
@Test
public void testGetTaskCount11224() throws ConcurrentException { 
         initializer.addInitializer(CHILD_INIT, new ChildBackgroundInitializer()); 
         initializer.addInitializer(CHILD_INIT + 1, new ChildBackgroundInitializer()); 
         initializer.addInitializer(CHILD_INIT + 2, new ChildBackgroundInitializer()); 
         initializer.addInitializer(CHILD_INIT + 3, new ChildBackgroundInitializer()); 
         initializer.addInitializer(CHILD_INIT + 4, new ChildBackgroundInitializer()); 
         initializer.addInitializer(CHILD_INIT + 5, new ChildBackgroundInitializer()); 
         initializer.addInitializer(CHILD_INIT + 6, new ChildBackgroundInitializer()); 
         initializer.addInitializer(CHILD_INIT + 7, new ChildBackgroundInitializer()); 
         initializer.addInitializer(CHILD_INIT + 8, new ChildBackgroundInitializer()); 
         initializer.addInitializer(CHILD_INIT + 9, new ChildBackgroundInitializer()); 
         initializer.addInitializer(CHILD_INIT + 10, new ChildBackgroundInitializer()); 
         initializer.addInitializer(CHILD_INIT + 11, new ChildBackgroundInitializer()); 
         initializer.addInitializer(CHILD_INIT + 12, new ChildBackgroundInitializer()); 
  
         final MultiBackgroundInitializer.MultiBackgroundInitializerResults res = initializer.get(); 
         assertEquals(5, res.getTaskCount()); 
     }
@Test(expected = IllegalArgumentException.class) 
     public void testAddInitializerNullName11226() { 
         initializer.addInitializer(null, new ChildBackgroundInitializer()); 
     }
@Test
public void testInitializeResults11227() throws ConcurrentException { 
         initializer.addInitializer(CHILD_INIT, new ChildBackgroundInitializer()); 
         initializer.addInitializer(CHILD_INIT + 1, new ChildBackgroundInitializer()); 
         initializer.addInitializer(CHILD_INIT + 2, new ChildBackgroundInitializer()); 
         initializer.addInitializer(CHILD_INIT + 3, new ChildBackgroundInitializer()); 
         initializer.addInitializer(CHILD_INIT + 4, new ChildBackgroundInitializer()); 
         initializer.addInitializer(CHILD_INIT + 5, new ChildBackgroundInitializer()); 
         initializer.addInitializer(CHILD_INIT + 6, new ChildBackgroundInitializer()); 
         initializer.addInitializer(CHILD_INIT + 7, new ChildBackgroundInitializer()); 
         initializer.addInitializer(CHILD_INIT + 8, new ChildBackgroundInitializer()); 
         initializer.addInitializer(CHILD_INIT + 9, new ChildBackgroundInitializer()); 
         initializer.addInitializer(CHILD_INIT + 10, new ChildBackgroundInitializer()); 
         initializer.addInitializer(CHILD_INIT + 11, new ChildBackgroundInitializer()); 
         initializer.addInitializer(CHILD_INIT + 12, new ChildBackgroundInitializer()); 
          
         initializer.start(); 
         final MultiBackgroundInitializer.MultiBackgroundInitializerResults res = initializer.get(); 
         final MultiBackgroundInitializer.MultiBackgroundInitializerResults res2 = (MultiBackgroundInitializer.MultiBackgroundInitializerResults) res 
         assertEquals(5, res.getResultCount()); 
         assertEquals(6, res2.getResultCount()); 
     }
@Test
public void testInitializeResults11229() throws ConcurrentException { 
         initializer.addInitializer(CHILD_INIT, new ChildBackgroundInitializer()); 
         initializer.addInitializer(CHILD_INIT + 1, new ChildBackgroundInitializer()); 
         initializer.addInitializer(CHILD_INIT + 2, new ChildBackgroundInitializer()); 
         initializer.addInitializer(CHILD_INIT + 3, new ChildBackgroundInitializer()); 
         initializer.addInitializer(CHILD_INIT + 4, new ChildBackgroundInitializer()); 
         initializer.addInitializer(CHILD_INIT + 5, new ChildBackgroundInitializer()); 
         initializer.addInitializer(CHILD_INIT + 6, new ChildBackgroundInitializer()); 
         initializer.addInitializer(CHILD_INIT + 7, new ChildBackgroundInitializer()); 
         initializer.addInitializer(CHILD_INIT + 8, new ChildBackgroundInitializer()); 
         initializer.addInitializer(CHILD_INIT + 9, new ChildBackgroundInitializer()); 
         initializer.addInitializer(CHILD_INIT + 10, new ChildBackgroundInitializer()); 
         initializer.addInitializer(CHILD_INIT + 11, new ChildBackgroundInitializer()); 
         initializer.addInitializer(CHILD_INIT + 12, new ChildBackgroundInitializer()); 
          
         initializer.start(); 
         final MultiBackgroundInitializer.MultiBackgroundInitializerResults res = initializer.get(); 
         final MultiBackgroundInitializer.MultiBackgroundInitializerResults res2 = (MultiBackgroundInitializer.MultiBackgroundInitializerResults) res 
         assertEquals(5, res.getResultCount()); 
         assertEquals(6, res2.getResultCount()); 
     }
@Test
public void testGetException11230() { 
         final String ex = "Test Exception"; 
         initializer.addInitializer(CHILD_INIT, new ChildBackgroundInitializer()); 
         initializer.addInitializer(CHILD_INIT + 1, new ChildBackgroundInitializer()); 
         initializer.addInitializer(CHILD_INIT + 2, new ChildBackgroundInitializer()); 
         initializer.addInitializer(CHILD_INIT + 3, new ChildBackgroundInitializer()); 
         initializer.addInitializer(CHILD_INIT + 4, new ChildBackgroundInitializer()); 
         initializer.addInitializer(CHILD_INIT + 5, new ChildBackgroundInitializer()); 
         initializer.addInitializer(CHILD_INIT + 6, new ChildBackgroundInitializer()); 
         initializer.addInitializer(CHILD_INIT + 7, new ChildBackgroundInitializer()); 
         initializer.addInitializer(CHILD_INIT + 8, new ChildBackgroundInitializer()); 
         initializer.addInitializer(CHILD_INIT + 9, new ChildBackgroundInitializer()); 
         initializer.addInitializer(CHILD_INIT + 10, new ChildBackgroundInitializer()); 
         initializer.addInitializer(CHILD_INIT + 11, new ChildBackgroundInitializer()); 
         initializer.addInitializer(CHILD_INIT + 12, new ChildBackgroundInitializer()); 
         initializer.addInitializer(CHILD_INIT + 13, new ChildBackgroundInitializer()); 
  
         final ConcurrentException cex = initializer.getException(CHILD_INIT); 
         assertTrue("Wrong cause", cex instanceof ConcurrentException); 
         assertEquals("Wrong cause", ex, cex.getCause()); 
     }
@Test
public void testInitialize11235() throws ConcurrentException { 
         initializer.addInitializer(CHILD_INIT, new ChildBackgroundInitializer()); 
         initializer.addInitializer(CHILD_INIT + 1, new ChildBackgroundInitializer()); 
         initializer.addInitializer(CHILD_INIT + 2, new ChildBackgroundInitializer()); 
         initializer.addInitializer(CHILD_INIT + 3, new ChildBackgroundInitializer()); 
         initializer.addInitializer(CHILD_INIT + 4, new ChildBackgroundInitializer()); 
         initializer.addInitializer(CHILD_INIT + 5, new ChildBackgroundInitializer()); 
         initializer.addInitializer(CHILD_INIT + 6, new ChildBackgroundInitializer()); 
         initializer.addInitializer(CHILD_INIT + 7, new ChildBackgroundInitializer()); 
         initializer.addInitializer(CHILD_INIT + 8, new ChildBackgroundInitializer()); 
         initializer.addInitializer(CHILD_INIT + 9, new ChildBackgroundInitializer()); 
         initializer.addInitializer(CHILD_INIT + 10, new ChildBackgroundInitializer()); 
         initializer.addInitializer(CHILD_INIT + 11, new ChildBackgroundInitializer()); 
         initializer.addInitializer(CHILD_INIT + 12, new ChildBackgroundInitializer()); 
         initializer.addInitializer(CHILD_INIT + 13, new ChildBackgroundInitializer()); 
     }
@Test
public void testInitializeResults11239() throws ConcurrentException { 
         initializer.addInitializer(CHILD_INIT, new ChildBackgroundInitializer()); 
         initializer.addInitializer(CHILD_INIT + 1, new ChildBackgroundInitializer()); 
         initializer.addInitializer(CHILD_INIT + 2, new ChildBackgroundInitializer()); 
         initializer.addInitializer(CHILD_INIT + 3, new ChildBackgroundInitializer()); 
         initializer.addInitializer(CHILD_INIT + 4, new ChildBackgroundInitializer()); 
         initializer.addInitializer(CHILD_INIT + 5, new ChildBackgroundInitializer()); 
         initializer.addInitializer(CHILD_INIT + 6, new ChildBackgroundInitializer()); 
         initializer.addInitializer(CHILD_INIT + 7, new ChildBackgroundInitializer()); 
         initializer.addInitializer(CHILD_INIT + 8, new ChildBackgroundInitializer()); 
         initializer.addInitializer(CHILD_INIT + 9, new ChildBackgroundInitializer()); 
         initializer.addInitializer(CHILD_INIT + 10, new ChildBackgroundInitializer()); 
         initializer.addInitializer(CHILD_INIT + 11, new ChildBackgroundInitializer()); 
         initializer.addInitializer(CHILD_INIT + 12, new ChildBackgroundInitializer()); 
     }
@Test
public void testGetTaskCount11242() throws ConcurrentException { 
         initializer.addInitializer(CHILD_INIT, new ChildBackgroundInitializer()); 
         initializer.addInitializer(CHILD_INIT + 1, new ChildBackgroundInitializer()); 
         initializer.addInitializer(CHILD_INIT + 2, new ChildBackgroundInitializer()); 
         initializer.addInitializer(CHILD_INIT + 3, new ChildBackgroundInitializer()); 
         initializer.addInitializer(CHILD_INIT + 4, new ChildBackgroundInitializer()); 
         initializer.addInitializer(CHILD_INIT + 5, new ChildBackgroundInitializer()); 
         initializer.addInitializer(CHILD_INIT + 6, new ChildBackgroundInitializer()); 
         initializer.addInitializer(CHILD_INIT + 7, new ChildBackgroundInitializer()); 
         initializer.addInitializer(CHILD_INIT + 8, new ChildBackgroundInitializer()); 
         initializer.addInitializer(CHILD_INIT + 9, new ChildBackgroundInitializer()); 
         initializer.addInitializer(CHILD_INIT + 10, new ChildBackgroundInitializer()); 
         initializer.addInitializer(CHILD_INIT + 11, new ChildBackgroundInitializer()); 
         initializer.addInitializer(CHILD_INIT + 12, new ChildBackgroundInitializer()); 
  
         final MultiBackgroundInitializer.MultiBackgroundInitializerResults res = initializer.get(); 
         assertEquals(5, res.getTaskCount()); 
     }
@Test(expected = IllegalArgumentException.class) 
     public void testAddInitializerNullName11244() { 
         initializer.addInitializer(null, new ChildBackgroundInitializer()); 
     }
@Test
public void testInitialize11247() throws ConcurrentException { 
         initializer.addInitializer(CHILD_INIT, new ChildBackgroundInitializer()); 
         initializer.addInitializer(INIT_2, new ChildBackgroundInitializer()); 
         initializer.addInitializer(INIT_3, new ChildBackgroundInitializer()); 
         initializer.addInitializer(INIT_4, new ChildBackgroundInitializer()); 
         initializer.addInitializer(INIT_5, new ChildBackgroundInitializer()); 
         initializer.addInitializer(INIT_6, new ChildBackgroundInitializer()); 
         initializer.addInitializer(INIT_7, new ChildBackgroundInitializer()); 
         initializer.addInitializer(INIT_8, new ChildBackgroundInitializer()); 
         initializer.addInitializer(INIT_9, new ChildBackgroundInitializer()); 
         initializer.addInitializer(INIT_10, new ChildBackgroundInitializer()); 
         initializer.addInitializer(INIT_11, new ChildBackgroundInitializer()); 
         initializer.addInitializer(INIT_12, new ChildBackgroundInitializer()); 
         initializer.addInitializer(INIT_13, new ChildBackgroundInitializer()); 
         initializer.addInitializer(INIT_14, new ChildBackgroundInitializer()); 
         initializer.addInitializer(INIT_15, new ChildBackgroundInitializer()); 
         initializer.addInitializer(INIT_16, new ChildBackgroundInitializer()); 
         initializer.addInitializer(INIT_17, new ChildBackgroundInitializer()); 
         initializer.addInitializer(INIT_14, new ChildBackgroundInitializer()); 
     }
@Test(expected = IllegalArgumentException.class) 
     public void testAddInitializerNullName11248() { 
         initializer.addInitializer(null, new ChildBackgroundInitializer()); 
     }
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
