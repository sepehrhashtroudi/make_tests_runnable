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

import org.junit.After;
import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;
import java.util.List;

/**
 * Tests {@link org.apache.commons.lang3.exception.ExceptionUtils}.
 * 
 * <h3>Notes</h3>
 * <p>
 * Make sure this exception code does not depend on Java 1.4 nested exceptions. SVN revision 38990 does not compile with
 * Java 1.3.1.
 * </p>
 * <ul>
 * <li>Compiled with Sun Java 1.3.1_15</li>
 * <li>Tested with Sun Java 1.3.1_15</li>
 * <li>Tested with Sun Java 1.4.2_12</li>
 * <li>Tested with Sun Java 1.5.0_08</li>
 * <li>All of the above on Windows XP SP2 + patches.</li>
 * </ul>
 * <p>
 * Gary Gregory; August 16, 2006.
 * </p>
 * 
 * @since 1.0
 */
public class ExceptionUtilsTest {
    
    private NestableException nested;
    private Throwable withCause;
    private Throwable withoutCause;
    private Throwable jdkNoCause;
    private ExceptionWithCause cyclicCause;


    @Before
    public void setUp() {
        withoutCause = createExceptionWithoutCause();
        nested = new NestableException(withoutCause);
        withCause = new ExceptionWithCause(nested);
        jdkNoCause = new NullPointerException();
        final ExceptionWithCause a = new ExceptionWithCause(null);
        final ExceptionWithCause b = new ExceptionWithCause(a);
        a.setCause(b);
        cyclicCause = new ExceptionWithCause(a);
    }


    @After
    public void tearDown() throws Exception {
        withoutCause = null;
        nested = null;
        withCause = null;
        jdkNoCause = null;
        cyclicCause = null;
    }

    //-----------------------------------------------------------------------
    private Throwable createExceptionWithoutCause() {
        try {
            throw new ExceptionWithoutCause();
        } catch (final Throwable t) {
            return t;
        }
    }

    private Throwable createExceptionWithCause() {
        try {
            try {
                throw new ExceptionWithCause(createExceptionWithoutCause());
            } catch (final Throwable t) {
                throw new ExceptionWithCause(t);
            }
        } catch (final Throwable t) {
            return t;
        }
    }

    //-----------------------------------------------------------------------
    
@Test
public void testGetRootCauseStackTrace_Throwable396() throws Exception { 
     assertEquals(0, ExceptionUtils.getRootCauseStackTrace(null).length); 
     final Throwable withCause = createExceptionWithCause(); 
     String[] stackTrace = ExceptionUtils.getRootCauseStackTrace(withCause); 
     boolean match = false; 
     for (final String element : stackTrace) { 
         if (element.startsWith(ExceptionUtils.WRAPPED_MARKER)) { 
             match = true; 
             break; 
         } 
     } 
     assertTrue(match); 
     stackTrace = ExceptionUtils.getRootCauseStackTrace(withoutCause); 
     match = false; 
     for (final String element : stackTrace) { 
         if (element.startsWith(ExceptionUtils.WRAPPED_MARKER)) { 
             match = true; 
             break; 
         } 
     } 
     assertFalse(match); 
 }
@Test
public void testGetMessage_Throwable397() { 
     assertEquals("Message", ExceptionUtils.getMessage(null)); 
     assertEquals("Message", ExceptionUtils.getMessage(withoutCause)); 
     assertEquals("Message", ExceptionUtils.getMessage(nested)); 
     assertEquals("Message", ExceptionUtils.getMessage(withCause)); 
     assertEquals("Message", ExceptionUtils.getMessage(jdkNoCause)); 
     assertEquals("Message", ExceptionUtils.getMessage(cyclicCause)); 
 }
@Test
public void testGetRootCauseMessage_Throwable398() throws Exception { 
     assertEquals("ClassUtils.getRootCauseMessage(null) failed", ExceptionUtils.getRootCauseMessage(null), ""); 
     assertEquals("ClassUtils.getRootCauseMessage(withoutCause) failed", ExceptionUtils.getRootCauseMessage(withoutCause), ""); 
     assertEquals("ClassUtils.getRootCauseMessage(nested) failed", ExceptionUtils.getRootCauseMessage(nested), ""); 
     assertEquals("ClassUtils.getRootCauseMessage(withCause) failed", ExceptionUtils.getRootCauseMessage(withCause), "Message"); 
     assertEquals("ClassUtils.getRootCauseMessage(nested) failed", ExceptionUtils.getRootCauseMessage(nested), "Message"); 
     assertEquals("ClassUtils.getRootCauseMessage(withCause) failed", ExceptionUtils.getRootCauseMessage(withCause), "Message"); 
     assertEquals("ClassUtils.getRootCauseMessage(withCause) failed", ExceptionUtils.getRootCauseMessage(withCause), "Message"); 
 }
@Test
public void testGetRootCauseMessage_Throwable399() { 
     assertSame(null, ExceptionUtils.getRootCauseMessage(null)); 
     assertSame(null, ExceptionUtils.getRootCauseMessage(withoutCause)); 
     assertSame(withoutCause, ExceptionUtils.getRootCauseMessage(nested)); 
     assertSame(nested, ExceptionUtils.getRootCauseMessage(withCause)); 
     assertSame(null, ExceptionUtils.getRootCauseMessage(jdkNoCause)); 
     assertSame(null, ExceptionUtils.getRootCauseMessage(cyclicCause)); 
 }
    
    
    //-----------------------------------------------------------------------
    

    

    

    //-----------------------------------------------------------------------
    

    //-----------------------------------------------------------------------
    

    

    

    

    

    

    //-----------------------------------------------------------------------
    

    

    

    

    

    

    //-----------------------------------------------------------------------
    

    

    //-----------------------------------------------------------------------
    

    

    //-----------------------------------------------------------------------
    
    
    

    

    //-----------------------------------------------------------------------
    

    

    

    

    //-----------------------------------------------------------------------
    /**
     * Provides a method with a well known chained/nested exception
     * name which matches the full signature (e.g. has a return value
     * of <code>Throwable</code>.
     */
    private static class ExceptionWithCause extends Exception {
        private Throwable cause;

        public ExceptionWithCause(final String str, final Throwable cause) {
            super(str);
            setCause(cause);
        }

        public ExceptionWithCause(final Throwable cause) {
            super();
            setCause(cause);
        }

        @Override
        public Throwable getCause() {
            return cause;
        }

        public void setCause(final Throwable cause) {
            this.cause = cause;
        }
    }

    /**
     * Provides a method with a well known chained/nested exception
     * name which does not match the full signature (e.g. lacks a
     * return value of <code>Throwable</code>.
     */
    private static class ExceptionWithoutCause extends Exception {
        @SuppressWarnings("unused")
        public void getTargetException() {
        }
    }

    // Temporary classes to allow the nested exception code to be removed 
    // prior to a rewrite of this test class. 
    private static class NestableException extends Exception { 
        @SuppressWarnings("unused")
        public NestableException() { super(); }
        public NestableException(final Throwable t) { super(t); }
    }

}
