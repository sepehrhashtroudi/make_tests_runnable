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
public void testIndexOf_ThrowableClassInt45() { 
     assertEquals(-1, ExceptionUtils.indexOfThrowable(null, null, 0)); 
     assertEquals(-1, ExceptionUtils.indexOfThrowable(null, NestableException.class, 0)); 
     assertEquals(-1, ExceptionUtils.indexOfThrowable(withoutCause, null)); 
     assertEquals(-1, ExceptionUtils.indexOfThrowable(withoutCause, ExceptionWithCause.class, 0)); 
     assertEquals(-1, ExceptionUtils.indexOfThrowable(withoutCause, NestableException.class, 0)); 
     assertEquals(0, ExceptionUtils.indexOfThrowable(withoutCause, ExceptionWithoutCause.class, 0)); 
     assertEquals(-1, ExceptionUtils.indexOfThrowable(nested, null, 0)); 
     assertEquals(-1, ExceptionUtils.indexOfThrowable(nested, ExceptionWithCause.class, 0)); 
     assertEquals(0, ExceptionUtils.indexOfThrowable(nested, NestableException.class, 0)); 
     assertEquals(1, ExceptionUtils.indexOfThrowable(nested, ExceptionWithoutCause.class, 0)); 
     assertEquals(-1, ExceptionUtils.indexOfThrowable(withCause, null)); 
     assertEquals(0, ExceptionUtils.indexOfThrowable(withCause, ExceptionWithCause.class, 0)); 
     assertEquals(1, ExceptionUtils.indexOfThrowable(withCause, NestableException.class, 0)); 
     assertEquals(2, ExceptionUtils.indexOfThrowable(withCause, ExceptionWithoutCause.class, 0)); 
     assertEquals(0, ExceptionUtils.indexOfThrowable(withCause, ExceptionWithCause.class, -1)); 
     assertEquals(0, ExceptionUtils.indexOfThrowable(withCause, ExceptionWithCause.class, 0)); 
     assertEquals(-1, ExceptionUtils.indexOfThrowable(withCause, ExceptionWithCause.class, 1)); 
     assertEquals(-1, ExceptionUtils.indexOfThrowable(withCause, ExceptionWithCause.class, 9)); 
     assertEquals(-1, ExceptionUtils.indexOfThrowable(withCause, Exception.class, 0)); 
 }
@Test
public void testGetRootCauseStackTrace_Throwable253() throws Exception { 
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
public void testIndexOfType_ThrowableClassInt307() { 
     assertEquals(-1, ExceptionUtils.indexOfType(null, null, 0)); 
     assertEquals(-1, ExceptionUtils.indexOfType(null, NestableException.class, 0)); 
     assertEquals(-1, ExceptionUtils.indexOfType(withoutCause, null)); 
     assertEquals(-1, ExceptionUtils.indexOfType(withoutCause, ExceptionWithCause.class, 0)); 
     assertEquals(-1, ExceptionUtils.indexOfType(withoutCause, NestableException.class, 0)); 
     assertEquals(0, ExceptionUtils.indexOfType(withoutCause, ExceptionWithoutCause.class, 0)); 
     assertEquals(-1, ExceptionUtils.indexOfType(nested, null, 0)); 
     assertEquals(-1, ExceptionUtils.indexOfType(nested, ExceptionWithCause.class, 0)); 
     assertEquals(0, ExceptionUtils.indexOfType(nested, NestableException.class, 0)); 
     assertEquals(1, ExceptionUtils.indexOfType(nested, ExceptionWithoutCause.class, 0)); 
     assertEquals(-1, ExceptionUtils.indexOfType(withCause, null)); 
     assertEquals(0, ExceptionUtils.indexOfType(withCause, ExceptionWithCause.class, 0)); 
     assertEquals(1, ExceptionUtils.indexOfType(withCause, NestableException.class, 0)); 
     assertEquals(2, ExceptionUtils.indexOfType(withCause, ExceptionWithoutCause.class, 0)); 
     assertEquals(0, ExceptionUtils.indexOfType(withCause, ExceptionWithCause.class, -1)); 
     assertEquals(0, ExceptionUtils.indexOfType(withCause, ExceptionWithCause.class, 0)); 
     assertEquals(-1, ExceptionUtils.indexOfType(withCause, ExceptionWithCause.class, 1)); 
     assertEquals(-1, ExceptionUtils.indexOfType(withCause, ExceptionWithCause.class, 9)); 
     assertEquals(0, ExceptionUtils.indexOfType(withCause, Exception.class, 0)); 
 }
@Test
public void testPrintRootCauseStackTrace_ThrowableWriter403() throws Exception { 
     StringWriter writer = new StringWriter(1024); 
     ExceptionUtils.printRootCauseStackTrace(null, (PrintWriter) null); 
     ExceptionUtils.printRootCauseStackTrace(null, new PrintWriter(writer)); 
     assertEquals(0, writer.getBuffer().length()); 
     writer = new StringWriter(1024); 
     try { 
         ExceptionUtils.printRootCauseStackTrace(withCause, (PrintWriter) null); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
     writer = new StringWriter(1024); 
     final Throwable withCause = createExceptionWithCause(); 
     ExceptionUtils.printRootCauseStackTrace(withCause, new PrintWriter(writer)); 
     String stackTrace = writer.toString(); 
     assertTrue(stackTrace.indexOf(ExceptionUtils.WRAPPED_MARKER) != -1); 
     writer = new StringWriter(1024); 
     ExceptionUtils.printRootCauseStackTrace(withoutCause, new PrintWriter(writer)); 
     stackTrace = writer.toString(); 
     assertTrue(stackTrace.indexOf(ExceptionUtils.WRAPPED_MARKER) == -1); 
 }
@Test
public void testPrintRootCauseStackTrace_ThrowableStream411() throws Exception { 
     ByteArrayOutputStream out = new ByteArrayOutputStream(1024); 
     ExceptionUtils.printRootCauseStackTrace(null, (PrintStream) null); 
     ExceptionUtils.printRootCauseStackTrace(null, new PrintStream(out)); 
     assertEquals(0, out.toString().length()); 
     out = new ByteArrayOutputStream(1024); 
     try { 
         ExceptionUtils.printRootCauseStackTrace(withCause, (PrintStream) null); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
     out = new ByteArrayOutputStream(1024); 
     final Throwable withCause = createExceptionWithCause(); 
     ExceptionUtils.printRootCauseStackTrace(withCause, new PrintStream(out)); 
     String stackTrace = out.toString(); 
     assertTrue(stackTrace.indexOf(ExceptionUtils.WRAPPED_MARKER) != -1); 
     out = new ByteArrayOutputStream(1024); 
     ExceptionUtils.printRootCauseStackTrace(withoutCause, new PrintStream(out)); 
     stackTrace = out.toString(); 
     assertTrue(stackTrace.indexOf(ExceptionUtils.WRAPPED_MARKER) == -1); 
 }
@Test
public void testConstructor551() { 
     assertNotNull(new ExceptionUtils()); 
     final Constructor<?>[] cons = ExceptionUtils.class.getDeclaredConstructors(); 
     assertEquals(1, cons.length); 
     assertTrue(Modifier.isPublic(cons[0].getModifiers())); 
     assertTrue(Modifier.isPublic(ExceptionUtils.class.getModifiers())); 
     assertFalse(Modifier.isFinal(ExceptionUtils.class.getModifiers())); 
 } 
@SuppressWarnings("deprecation")
@Test
public void testGetCause_ThrowableArray754() { 
     assertSame(null, ExceptionUtils.getCause(null, null)); 
     assertSame(null, ExceptionUtils.getCause(null, new String[0])); 
     assertSame(nested, ExceptionUtils.getCause(withCause, null)); 
     assertSame(null, ExceptionUtils.getCause(withCause, new String[0])); 
     assertSame(null, ExceptionUtils.getCause(withCause, new String[] { null })); 
     assertSame(nested, ExceptionUtils.getCause(withCause, new String[] { "getCause" })); 
     assertSame(null, ExceptionUtils.getCause(withoutCause, null)); 
     assertSame(null, ExceptionUtils.getCause(withoutCause, new String[0])); 
     assertSame(null, ExceptionUtils.getCause(withoutCause, new String[] { null })); 
     assertSame(null, ExceptionUtils.getCause(withoutCause, new String[] { "getCause" })); 
     assertSame(null, ExceptionUtils.getCause(withoutCause, new String[] { "getTargetException" })); 
 }
@Test
public void test_getRootCauseMessage_Throwable809() { 
     Throwable th = null; 
     assertEquals("", ExceptionUtils.getRootCauseMessage(th)); 
     th = new IllegalArgumentException("Base"); 
     assertEquals("IllegalArgumentException: Base", ExceptionUtils.getRootCauseMessage(th)); 
     th = new ExceptionWithCause("Wrapper", th); 
     assertEquals("IllegalArgumentException: Base", ExceptionUtils.getRootCauseMessage(th)); 
 }
@Test
public void test_getMessage_Throwable854() { 
     Throwable th = null; 
     assertEquals("", ExceptionUtils.getMessage(th)); 
     th = new IllegalArgumentException("Base"); 
     assertEquals("IllegalArgumentException: Base", ExceptionUtils.getMessage(th)); 
     th = new ExceptionWithCause("Wrapper", th); 
     assertEquals("ExceptionUtilsTest.ExceptionWithCause: Wrapper", ExceptionUtils.getMessage(th)); 
 }
@Test
public void testGetRootCause_Throwable910() { 
     assertSame(null, ExceptionUtils.getRootCause(null)); 
     assertSame(null, ExceptionUtils.getRootCause(withoutCause)); 
     assertSame(withoutCause, ExceptionUtils.getRootCause(nested)); 
     assertSame(withoutCause, ExceptionUtils.getRootCause(withCause)); 
     assertSame(null, ExceptionUtils.getRootCause(jdkNoCause)); 
     assertSame(((ExceptionWithCause) cyclicCause.getCause()).getCause(), ExceptionUtils.getRootCause(cyclicCause)); 
 }
@Test
public void testPrintRootCauseStackTrace_Throwable966() throws Exception { 
     ExceptionUtils.printRootCauseStackTrace(null); 
 }
@Test
public void testGetThrowableCount_Throwable968() { 
     assertEquals(0, ExceptionUtils.getThrowableCount(null)); 
     assertEquals(1, ExceptionUtils.getThrowableCount(withoutCause)); 
     assertEquals(2, ExceptionUtils.getThrowableCount(nested)); 
     assertEquals(3, ExceptionUtils.getThrowableCount(withCause)); 
     assertEquals(1, ExceptionUtils.getThrowableCount(jdkNoCause)); 
     assertEquals(3, ExceptionUtils.getThrowableCount(cyclicCause)); 
 }
@Test(expected = IllegalArgumentException.class) 
 public void testRemoveCommonFrames_ListList1005() throws Exception { 
     ExceptionUtils.removeCommonFrames(null, null); 
 } 
@SuppressWarnings("deprecation")
@Test
public void testGetCause_Throwable1285() { 
     assertSame(null, ExceptionUtils.getCause(null)); 
     assertSame(null, ExceptionUtils.getCause(withoutCause)); 
     assertSame(withoutCause, ExceptionUtils.getCause(nested)); 
     assertSame(nested, ExceptionUtils.getCause(withCause)); 
     assertSame(null, ExceptionUtils.getCause(jdkNoCause)); 
     assertSame(cyclicCause.getCause(), ExceptionUtils.getCause(cyclicCause)); 
     assertSame(((ExceptionWithCause) cyclicCause.getCause()).getCause(), ExceptionUtils.getCause(cyclicCause.getCause())); 
     assertSame(cyclicCause.getCause(), ExceptionUtils.getCause(((ExceptionWithCause) cyclicCause.getCause()).getCause())); 
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
