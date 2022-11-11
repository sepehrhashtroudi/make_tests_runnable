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
public void testIndexOf_ThrowableClass198() { 
     assertEquals(-1, ExceptionUtils.indexOfThrowable(null, null)); 
     assertEquals(-1, ExceptionUtils.indexOfThrowable(null, NestableException.class)); 
     assertEquals(-1, ExceptionUtils.indexOfThrowable(withoutCause, null)); 
     assertEquals(-1, ExceptionUtils.indexOfThrowable(withoutCause, ExceptionWithCause.class)); 
     assertEquals(-1, ExceptionUtils.indexOfThrowable(withoutCause, NestableException.class)); 
     assertEquals(0, ExceptionUtils.indexOfThrowable(withoutCause, ExceptionWithoutCause.class)); 
     assertEquals(-1, ExceptionUtils.indexOfThrowable(nested, null)); 
     assertEquals(-1, ExceptionUtils.indexOfThrowable(nested, ExceptionWithCause.class)); 
     assertEquals(0, ExceptionUtils.indexOfThrowable(nested, NestableException.class)); 
     assertEquals(1, ExceptionUtils.indexOfThrowable(nested, ExceptionWithoutCause.class)); 
     assertEquals(-1, ExceptionUtils.indexOfThrowable(withCause, null)); 
     assertEquals(0, ExceptionUtils.indexOfThrowable(withCause, ExceptionWithCause.class)); 
     assertEquals(1, ExceptionUtils.indexOfThrowable(withCause, NestableException.class)); 
     assertEquals(2, ExceptionUtils.indexOfThrowable(withCause, ExceptionWithoutCause.class)); 
     assertEquals(-1, ExceptionUtils.indexOfThrowable(withCause, Exception.class)); 
 }
@Test
public void testIndexOfType_ThrowableClass210() { 
     assertEquals(-1, ExceptionUtils.indexOfType(null, null)); 
     assertEquals(-1, ExceptionUtils.indexOfType(null, NestableException.class)); 
     assertEquals(-1, ExceptionUtils.indexOfType(withoutCause, null)); 
     assertEquals(-1, ExceptionUtils.indexOfType(withoutCause, ExceptionWithCause.class)); 
     assertEquals(-1, ExceptionUtils.indexOfType(withoutCause, NestableException.class)); 
     assertEquals(0, ExceptionUtils.indexOfType(withoutCause, ExceptionWithoutCause.class)); 
     assertEquals(-1, ExceptionUtils.indexOfType(nested, null)); 
     assertEquals(-1, ExceptionUtils.indexOfType(nested, ExceptionWithCause.class)); 
     assertEquals(0, ExceptionUtils.indexOfType(nested, NestableException.class)); 
     assertEquals(1, ExceptionUtils.indexOfType(nested, ExceptionWithoutCause.class)); 
     assertEquals(-1, ExceptionUtils.indexOfType(withCause, null)); 
     assertEquals(0, ExceptionUtils.indexOfType(withCause, ExceptionWithCause.class)); 
     assertEquals(1, ExceptionUtils.indexOfType(withCause, NestableException.class)); 
     assertEquals(2, ExceptionUtils.indexOfType(withCause, ExceptionWithoutCause.class)); 
     assertEquals(0, ExceptionUtils.indexOfType(withCause, Exception.class)); 
 }
@Test
public void testIndexOfType_ThrowableClass226() { 
     assertEquals(-1, ExceptionUtils.indexOfType(null, null)); 
     assertEquals(-1, ExceptionUtils.indexOfType(null, NestableException.class)); 
     assertEquals(-1, ExceptionUtils.indexOfType(withoutCause, null)); 
     assertEquals(-1, ExceptionUtils.indexOfType(withoutCause, ExceptionWithCause.class)); 
     assertEquals(-1, ExceptionUtils.indexOfType(withoutCause, NestableException.class)); 
     assertEquals(0, ExceptionUtils.indexOfType(withoutCause, ExceptionWithoutCause.class)); 
     assertEquals(-1, ExceptionUtils.indexOfType(nested, null)); 
     assertEquals(-1, ExceptionUtils.indexOfType(nested, ExceptionWithCause.class)); 
     assertEquals(0, ExceptionUtils.indexOfType(nested, NestableException.class)); 
     assertEquals(1, ExceptionUtils.indexOfType(nested, ExceptionWithoutCause.class)); 
     assertEquals(-1, ExceptionUtils.indexOfType(withCause, null)); 
     assertEquals(0, ExceptionUtils.indexOfType(withCause, ExceptionWithCause.class)); 
     assertEquals(1, ExceptionUtils.indexOfType(withCause, NestableException.class)); 
     assertEquals(2, ExceptionUtils.indexOfType(withCause, ExceptionWithoutCause.class)); 
     assertEquals(0, ExceptionUtils.indexOfType(withCause, Exception.class)); 
 } 
@SuppressWarnings("deprecation")
@Test
public void testGetCause_ThrowableArray231() { 
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
public void testGetThrowables_Throwable_withoutCause336() { 
     final Throwable[] throwables = ExceptionUtils.getThrowables(withoutCause); 
     assertEquals(1, throwables.length); 
     assertSame(withoutCause, throwables[0]); 
 }
@Test
public void testIndexOf_ThrowableClass431() { 
     assertEquals(-1, ExceptionUtils.indexOfThrowable(null, null)); 
     assertEquals(-1, ExceptionUtils.indexOfThrowable(null, NestableException.class)); 
     assertEquals(-1, ExceptionUtils.indexOfThrowable(withoutCause, null)); 
     assertEquals(-1, ExceptionUtils.indexOfThrowable(withoutCause, ExceptionWithCause.class)); 
     assertEquals(-1, ExceptionUtils.indexOfThrowable(withoutCause, NestableException.class)); 
     assertEquals(0, ExceptionUtils.indexOfThrowable(withoutCause, ExceptionWithoutCause.class)); 
     assertEquals(-1, ExceptionUtils.indexOfThrowable(nested, null)); 
     assertEquals(-1, ExceptionUtils.indexOfThrowable(nested, ExceptionWithCause.class)); 
     assertEquals(0, ExceptionUtils.indexOfThrowable(nested, NestableException.class)); 
     assertEquals(1, ExceptionUtils.indexOfThrowable(nested, ExceptionWithoutCause.class)); 
     assertEquals(-1, ExceptionUtils.indexOfThrowable(withCause, null)); 
     assertEquals(0, ExceptionUtils.indexOfThrowable(withCause, ExceptionWithCause.class)); 
     assertEquals(1, ExceptionUtils.indexOfThrowable(withCause, NestableException.class)); 
     assertEquals(2, ExceptionUtils.indexOfThrowable(withCause, ExceptionWithoutCause.class)); 
     assertEquals(-1, ExceptionUtils.indexOfThrowable(withCause, Exception.class)); 
 }
@Test
public void testIndexOfType_ThrowableClass484() { 
     assertEquals(-1, ExceptionUtils.indexOfType(null, null)); 
     assertEquals(-1, ExceptionUtils.indexOfType(null, NestableException.class)); 
     assertEquals(-1, ExceptionUtils.indexOfType(withoutCause, null)); 
     assertEquals(-1, ExceptionUtils.indexOfType(withoutCause, ExceptionWithCause.class)); 
     assertEquals(-1, ExceptionUtils.indexOfType(withoutCause, NestableException.class)); 
     assertEquals(0, ExceptionUtils.indexOfType(withoutCause, ExceptionWithoutCause.class)); 
     assertEquals(-1, ExceptionUtils.indexOfType(nested, null)); 
     assertEquals(-1, ExceptionUtils.indexOfType(nested, ExceptionWithCause.class)); 
     assertEquals(0, ExceptionUtils.indexOfType(nested, NestableException.class)); 
     assertEquals(1, ExceptionUtils.indexOfType(nested, ExceptionWithoutCause.class)); 
     assertEquals(-1, ExceptionUtils.indexOfType(withCause, null)); 
     assertEquals(0, ExceptionUtils.indexOfType(withCause, ExceptionWithCause.class)); 
     assertEquals(1, ExceptionUtils.indexOfType(withCause, NestableException.class)); 
     assertEquals(2, ExceptionUtils.indexOfType(withCause, ExceptionWithoutCause.class)); 
     assertEquals(0, ExceptionUtils.indexOfType(withCause, Exception.class)); 
 }
@Test
public void testIndexOf_ThrowableClassInt525() { 
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
public void testGetRootCause_Throwable587() { 
     assertSame(null, ExceptionUtils.getRootCause(null)); 
     assertSame(null, ExceptionUtils.getRootCause(withoutCause)); 
     assertSame(withoutCause, ExceptionUtils.getRootCause(nested)); 
     assertSame(withoutCause, ExceptionUtils.getRootCause(withCause)); 
     assertSame(null, ExceptionUtils.getRootCause(jdkNoCause)); 
     assertSame(((ExceptionWithCause) cyclicCause.getCause()).getCause(), ExceptionUtils.getRootCause(cyclicCause)); 
 }
@Test
public void testPrintRootCauseStackTrace_ThrowableStream590() throws Exception { 
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
public void testGetThrowables_Throwable_withoutCause848() { 
     final Throwable[] throwables = ExceptionUtils.getThrowables(withoutCause); 
     assertEquals(1, throwables.length); 
     assertSame(withoutCause, throwables[0]); 
 }
@Test
public void testIndexOf_ThrowableClass850() { 
     assertEquals(-1, ExceptionUtils.indexOfThrowable(null, null)); 
     assertEquals(-1, ExceptionUtils.indexOfThrowable(null, NestableException.class)); 
     assertEquals(-1, ExceptionUtils.indexOfThrowable(withoutCause, null)); 
     assertEquals(-1, ExceptionUtils.indexOfThrowable(withoutCause, ExceptionWithCause.class)); 
     assertEquals(-1, ExceptionUtils.indexOfThrowable(withoutCause, NestableException.class)); 
     assertEquals(0, ExceptionUtils.indexOfThrowable(withoutCause, ExceptionWithoutCause.class)); 
     assertEquals(-1, ExceptionUtils.indexOfThrowable(nested, null)); 
     assertEquals(-1, ExceptionUtils.indexOfThrowable(nested, ExceptionWithCause.class)); 
     assertEquals(0, ExceptionUtils.indexOfThrowable(nested, NestableException.class)); 
     assertEquals(1, ExceptionUtils.indexOfThrowable(nested, ExceptionWithoutCause.class)); 
     assertEquals(-1, ExceptionUtils.indexOfThrowable(withCause, null)); 
     assertEquals(0, ExceptionUtils.indexOfThrowable(withCause, ExceptionWithCause.class)); 
     assertEquals(1, ExceptionUtils.indexOfThrowable(withCause, NestableException.class)); 
     assertEquals(2, ExceptionUtils.indexOfThrowable(withCause, ExceptionWithoutCause.class)); 
     assertEquals(-1, ExceptionUtils.indexOfThrowable(withCause, Exception.class)); 
 }
@Test
public void test_getRootCauseMessage_Throwable1016() { 
     Throwable th = null; 
     assertEquals("", ExceptionUtils.getRootCauseMessage(th)); 
     th = new IllegalArgumentException("Base"); 
     assertEquals("IllegalArgumentException: Base", ExceptionUtils.getRootCauseMessage(th)); 
     th = new ExceptionWithCause("Wrapper", th); 
     assertEquals("IllegalArgumentException: Base", ExceptionUtils.getRootCauseMessage(th)); 
 }
@Test
public void testGetThrowables_Throwable_withoutCause1076() { 
     final Throwable[] throwables = ExceptionUtils.getThrowables(withoutCause); 
     assertEquals(1, throwables.length); 
     assertSame(withoutCause, throwables[0]); 
 }
@Test
public void testIndexOf_ThrowableClassInt1180() { 
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
public void testIndexOf_ThrowableClassInt1545() { 
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
public void testIndexOf_ThrowableClass1654() { 
     assertEquals(-1, ExceptionUtils.indexOfThrowable(null, null)); 
     assertEquals(-1, ExceptionUtils.indexOfThrowable(null, NestableException.class)); 
     assertEquals(-1, ExceptionUtils.indexOfThrowable(withoutCause, null)); 
     assertEquals(-1, ExceptionUtils.indexOfThrowable(withoutCause, ExceptionWithCause.class)); 
     assertEquals(-1, ExceptionUtils.indexOfThrowable(withoutCause, NestableException.class)); 
     assertEquals(0, ExceptionUtils.indexOfThrowable(withoutCause, ExceptionWithoutCause.class)); 
     assertEquals(-1, ExceptionUtils.indexOfThrowable(nested, null)); 
     assertEquals(-1, ExceptionUtils.indexOfThrowable(nested, ExceptionWithCause.class)); 
     assertEquals(0, ExceptionUtils.indexOfThrowable(nested, NestableException.class)); 
     assertEquals(1, ExceptionUtils.indexOfThrowable(nested, ExceptionWithoutCause.class)); 
     assertEquals(-1, ExceptionUtils.indexOfThrowable(withCause, null)); 
     assertEquals(0, ExceptionUtils.indexOfThrowable(withCause, ExceptionWithCause.class)); 
     assertEquals(1, ExceptionUtils.indexOfThrowable(withCause, NestableException.class)); 
     assertEquals(2, ExceptionUtils.indexOfThrowable(withCause, ExceptionWithoutCause.class)); 
     assertEquals(-1, ExceptionUtils.indexOfThrowable(withCause, Exception.class)); 
 }
@Test
public void testPrintRootCauseStackTrace_Throwable1830() throws Exception { 
     ExceptionUtils.printRootCauseStackTrace(null); 
 }
@Test
public void testGetThrowables_Throwable_withoutCause1856() { 
     final Throwable[] throwables = ExceptionUtils.getThrowables(withoutCause); 
     assertEquals(1, throwables.length); 
     assertSame(withoutCause, throwables[0]); 
 }
@Test
public void testGetThrowables_Throwable_withoutCause2098() { 
     final Throwable[] throwables = ExceptionUtils.getThrowables(withoutCause); 
     assertEquals(1, throwables.length); 
     assertSame(withoutCause, throwables[0]); 
 }
@Test
public void testPrintRootCauseStackTrace_Throwable2550() throws Exception { 
     ExceptionUtils.printRootCauseStackTrace(null); 
 }
@Test
public void testGetThrowables_Throwable_withoutCause2604() { 
     final Throwable[] throwables = ExceptionUtils.getThrowables(withoutCause); 
     assertEquals(1, throwables.length); 
     assertSame(withoutCause, throwables[0]); 
 }
@Test
public void testGetThrowables_Throwable_withoutCause2667() { 
     final Throwable[] throwables = ExceptionUtils.getThrowables(withoutCause); 
     assertEquals(1, throwables.length); 
     assertSame(withoutCause, throwables[0]); 
 }
@Test
public void testPrintRootCauseStackTrace_ThrowableStream2675() throws Exception { 
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
public void testGetThrowables_Throwable_withoutCause2783() { 
     final Throwable[] throwables = ExceptionUtils.getThrowables(withoutCause); 
     assertEquals(1, throwables.length); 
     assertSame(withoutCause, throwables[0]); 
 }
@Test
public void test_getRootCauseMessage_Throwable2793() { 
     Throwable th = null; 
     assertEquals("", ExceptionUtils.getRootCauseMessage(th)); 
     th = new IllegalArgumentException("Base"); 
     assertEquals("IllegalArgumentException: Base", ExceptionUtils.getRootCauseMessage(th)); 
     th = new ExceptionWithCause("Wrapper", th); 
     assertEquals("IllegalArgumentException: Base", ExceptionUtils.getRootCauseMessage(th)); 
 }
@Test
public void testGetThrowables_Throwable_withoutCause2839() { 
     final Throwable[] throwables = ExceptionUtils.getThrowables(withoutCause); 
     assertEquals(1, throwables.length); 
     assertSame(withoutCause, throwables[0]); 
 }
@Test
public void testIndexOf_ThrowableClassInt3176() { 
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
public void testPrintRootCauseStackTrace_ThrowableStream3225() throws Exception { 
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
public void test_getRootCauseMessage_Throwable3329() { 
     Throwable th = null; 
     assertEquals("", ExceptionUtils.getRootCauseMessage(th)); 
     th = new IllegalArgumentException("Base"); 
     assertEquals("IllegalArgumentException: Base", ExceptionUtils.getRootCauseMessage(th)); 
     th = new ExceptionWithCause("Wrapper", th); 
     assertEquals("IllegalArgumentException: Base", ExceptionUtils.getRootCauseMessage(th)); 
 } 
@SuppressWarnings("deprecation")
@Test
public void testGetCause_ThrowableArray3506() { 
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
public void test_getRootCauseMessage_Throwable3722() { 
     Throwable th = null; 
     assertEquals("", ExceptionUtils.getRootCauseMessage(th)); 
     th = new IllegalArgumentException("Base"); 
     assertEquals("IllegalArgumentException: Base", ExceptionUtils.getRootCauseMessage(th)); 
     th = new ExceptionWithCause("Wrapper", th); 
     assertEquals("IllegalArgumentException: Base", ExceptionUtils.getRootCauseMessage(th)); 
 }
@Test
public void testGetThrowables_Throwable_withoutCause3825() { 
     final Throwable[] throwables = ExceptionUtils.getThrowables(withoutCause); 
     assertEquals(1, throwables.length); 
     assertSame(withoutCause, throwables[0]); 
 }
@Test
public void testIndexOf_ThrowableClass3887() { 
     assertEquals(-1, ExceptionUtils.indexOfThrowable(null, null)); 
     assertEquals(-1, ExceptionUtils.indexOfThrowable(null, NestableException.class)); 
     assertEquals(-1, ExceptionUtils.indexOfThrowable(withoutCause, null)); 
     assertEquals(-1, ExceptionUtils.indexOfThrowable(withoutCause, ExceptionWithCause.class)); 
     assertEquals(-1, ExceptionUtils.indexOfThrowable(withoutCause, NestableException.class)); 
     assertEquals(0, ExceptionUtils.indexOfThrowable(withoutCause, ExceptionWithoutCause.class)); 
     assertEquals(-1, ExceptionUtils.indexOfThrowable(nested, null)); 
     assertEquals(-1, ExceptionUtils.indexOfThrowable(nested, ExceptionWithCause.class)); 
     assertEquals(0, ExceptionUtils.indexOfThrowable(nested, NestableException.class)); 
     assertEquals(1, ExceptionUtils.indexOfThrowable(nested, ExceptionWithoutCause.class)); 
     assertEquals(-1, ExceptionUtils.indexOfThrowable(withCause, null)); 
     assertEquals(0, ExceptionUtils.indexOfThrowable(withCause, ExceptionWithCause.class)); 
     assertEquals(1, ExceptionUtils.indexOfThrowable(withCause, NestableException.class)); 
     assertEquals(2, ExceptionUtils.indexOfThrowable(withCause, ExceptionWithoutCause.class)); 
     assertEquals(-1, ExceptionUtils.indexOfThrowable(withCause, Exception.class)); 
 }
@Test
public void testIndexOf_ThrowableClass3912() { 
     assertEquals(-1, ExceptionUtils.indexOfThrowable(null, null)); 
     assertEquals(-1, ExceptionUtils.indexOfThrowable(null, NestableException.class)); 
     assertEquals(-1, ExceptionUtils.indexOfThrowable(withoutCause, null)); 
     assertEquals(-1, ExceptionUtils.indexOfThrowable(withoutCause, ExceptionWithCause.class)); 
     assertEquals(-1, ExceptionUtils.indexOfThrowable(withoutCause, NestableException.class)); 
     assertEquals(0, ExceptionUtils.indexOfThrowable(withoutCause, ExceptionWithoutCause.class)); 
     assertEquals(-1, ExceptionUtils.indexOfThrowable(nested, null)); 
     assertEquals(-1, ExceptionUtils.indexOfThrowable(nested, ExceptionWithCause.class)); 
     assertEquals(0, ExceptionUtils.indexOfThrowable(nested, NestableException.class)); 
     assertEquals(1, ExceptionUtils.indexOfThrowable(nested, ExceptionWithoutCause.class)); 
     assertEquals(-1, ExceptionUtils.indexOfThrowable(withCause, null)); 
     assertEquals(0, ExceptionUtils.indexOfThrowable(withCause, ExceptionWithCause.class)); 
     assertEquals(1, ExceptionUtils.indexOfThrowable(withCause, NestableException.class)); 
     assertEquals(2, ExceptionUtils.indexOfThrowable(withCause, ExceptionWithoutCause.class)); 
     assertEquals(-1, ExceptionUtils.indexOfThrowable(withCause, Exception.class)); 
 }
@Test
public void testGetThrowables_Throwable_withoutCause3924() { 
     final Throwable[] throwables = ExceptionUtils.getThrowables(withoutCause); 
     assertEquals(1, throwables.length); 
     assertSame(withoutCause, throwables[0]); 
 }
@Test
public void testIndexOf_ThrowableClass4026() { 
     assertEquals(-1, ExceptionUtils.indexOfThrowable(null, null)); 
     assertEquals(-1, ExceptionUtils.indexOfThrowable(null, NestableException.class)); 
     assertEquals(-1, ExceptionUtils.indexOfThrowable(withoutCause, null)); 
     assertEquals(-1, ExceptionUtils.indexOfThrowable(withoutCause, ExceptionWithCause.class)); 
     assertEquals(-1, ExceptionUtils.indexOfThrowable(withoutCause, NestableException.class)); 
     assertEquals(0, ExceptionUtils.indexOfThrowable(withoutCause, ExceptionWithoutCause.class)); 
     assertEquals(-1, ExceptionUtils.indexOfThrowable(nested, null)); 
     assertEquals(-1, ExceptionUtils.indexOfThrowable(nested, ExceptionWithCause.class)); 
     assertEquals(0, ExceptionUtils.indexOfThrowable(nested, NestableException.class)); 
     assertEquals(1, ExceptionUtils.indexOfThrowable(nested, ExceptionWithoutCause.class)); 
     assertEquals(-1, ExceptionUtils.indexOfThrowable(withCause, null)); 
     assertEquals(0, ExceptionUtils.indexOfThrowable(withCause, ExceptionWithCause.class)); 
     assertEquals(1, ExceptionUtils.indexOfThrowable(withCause, NestableException.class)); 
     assertEquals(2, ExceptionUtils.indexOfThrowable(withCause, ExceptionWithoutCause.class)); 
     assertEquals(-1, ExceptionUtils.indexOfThrowable(withCause, Exception.class)); 
 }
@Test
public void test_getRootCauseMessage_Throwable4092() { 
     Throwable th = null; 
     assertEquals("", ExceptionUtils.getRootCauseMessage(th)); 
     th = new IllegalArgumentException("Base"); 
     assertEquals("IllegalArgumentException: Base", ExceptionUtils.getRootCauseMessage(th)); 
     th = new ExceptionWithCause("Wrapper", th); 
     assertEquals("IllegalArgumentException: Base", ExceptionUtils.getRootCauseMessage(th)); 
 }
@Test
public void testGetThrowables_Throwable_withoutCause4119() { 
     final Throwable[] throwables = ExceptionUtils.getThrowables(withoutCause); 
     assertEquals(1, throwables.length); 
     assertSame(withoutCause, throwables[0]); 
 }
@Test
public void testGetThrowables_Throwable_withoutCause4290() { 
     final Throwable[] throwables = ExceptionUtils.getThrowables(withoutCause); 
     assertEquals(1, throwables.length); 
     assertSame(withoutCause, throwables[0]); 
 }
@Test
public void testGetThrowables_Throwable_withoutCause4355() { 
     final Throwable[] throwables = ExceptionUtils.getThrowables(withoutCause); 
     assertEquals(1, throwables.length); 
     assertSame(withoutCause, throwables[0]); 
 }
@Test
public void testIndexOfType_ThrowableClassInt4614() { 
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
public void testPrintRootCauseStackTrace_ThrowableStream4666() throws Exception { 
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
public void testPrintRootCauseStackTrace_Throwable4673() throws Exception { 
     ExceptionUtils.printRootCauseStackTrace(null); 
 }
@Test
public void testGetRootCause_Throwable4767() { 
     assertSame(null, ExceptionUtils.getRootCause(null)); 
     assertSame(null, ExceptionUtils.getRootCause(withoutCause)); 
     assertSame(withoutCause, ExceptionUtils.getRootCause(nested)); 
     assertSame(withoutCause, ExceptionUtils.getRootCause(withCause)); 
     assertSame(null, ExceptionUtils.getRootCause(jdkNoCause)); 
     assertSame(((ExceptionWithCause) cyclicCause.getCause()).getCause(), ExceptionUtils.getRootCause(cyclicCause)); 
 }
@Test
public void testPrintRootCauseStackTrace_ThrowableStream4789() throws Exception { 
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
@Test(expected = IllegalArgumentException.class) 
 public void testRemoveCommonFrames_ListList4885() throws Exception { 
     ExceptionUtils.removeCommonFrames(null, null); 
 }
@Test
public void test_getRootCauseMessage_Throwable5021() { 
     Throwable th = null; 
     assertEquals("", ExceptionUtils.getRootCauseMessage(th)); 
     th = new IllegalArgumentException("Base"); 
     assertEquals("IllegalArgumentException: Base", ExceptionUtils.getRootCauseMessage(th)); 
     th = new ExceptionWithCause("Wrapper", th); 
     assertEquals("IllegalArgumentException: Base", ExceptionUtils.getRootCauseMessage(th)); 
 }
@Test
public void testGetThrowables_Throwable_withoutCause5038() { 
     final Throwable[] throwables = ExceptionUtils.getThrowables(withoutCause); 
     assertEquals(1, throwables.length); 
     assertSame(withoutCause, throwables[0]); 
 }
@Test
public void testGetThrowables_Throwable_withoutCause5141() { 
     final Throwable[] throwables = ExceptionUtils.getThrowables(withoutCause); 
     assertEquals(1, throwables.length); 
     assertSame(withoutCause, throwables[0]); 
 }
@Test
public void testGetThrowableCount_Throwable5394() { 
     assertEquals(0, ExceptionUtils.getThrowableCount(null)); 
     assertEquals(1, ExceptionUtils.getThrowableCount(withoutCause)); 
     assertEquals(2, ExceptionUtils.getThrowableCount(nested)); 
     assertEquals(3, ExceptionUtils.getThrowableCount(withCause)); 
     assertEquals(1, ExceptionUtils.getThrowableCount(jdkNoCause)); 
     assertEquals(3, ExceptionUtils.getThrowableCount(cyclicCause)); 
 }
@Test
public void testIndexOfType_ThrowableClass5416() { 
     assertEquals(-1, ExceptionUtils.indexOfType(null, null)); 
     assertEquals(-1, ExceptionUtils.indexOfType(null, NestableException.class)); 
     assertEquals(-1, ExceptionUtils.indexOfType(withoutCause, null)); 
     assertEquals(-1, ExceptionUtils.indexOfType(withoutCause, ExceptionWithCause.class)); 
     assertEquals(-1, ExceptionUtils.indexOfType(withoutCause, NestableException.class)); 
     assertEquals(0, ExceptionUtils.indexOfType(withoutCause, ExceptionWithoutCause.class)); 
     assertEquals(-1, ExceptionUtils.indexOfType(nested, null)); 
     assertEquals(-1, ExceptionUtils.indexOfType(nested, ExceptionWithCause.class)); 
     assertEquals(0, ExceptionUtils.indexOfType(nested, NestableException.class)); 
     assertEquals(1, ExceptionUtils.indexOfType(nested, ExceptionWithoutCause.class)); 
     assertEquals(-1, ExceptionUtils.indexOfType(withCause, null)); 
     assertEquals(0, ExceptionUtils.indexOfType(withCause, ExceptionWithCause.class)); 
     assertEquals(1, ExceptionUtils.indexOfType(withCause, NestableException.class)); 
     assertEquals(2, ExceptionUtils.indexOfType(withCause, ExceptionWithoutCause.class)); 
     assertEquals(0, ExceptionUtils.indexOfType(withCause, Exception.class)); 
 }
@Test
public void testConstructor5460() { 
     assertNotNull(new ExceptionUtils()); 
     final Constructor<?>[] cons = ExceptionUtils.class.getDeclaredConstructors(); 
     assertEquals(1, cons.length); 
     assertTrue(Modifier.isPublic(cons[0].getModifiers())); 
     assertTrue(Modifier.isPublic(ExceptionUtils.class.getModifiers())); 
     assertFalse(Modifier.isFinal(ExceptionUtils.class.getModifiers())); 
 }
@Test
public void test_getRootCauseMessage_Throwable5738() { 
     Throwable th = null; 
     assertEquals("", ExceptionUtils.getRootCauseMessage(th)); 
     th = new IllegalArgumentException("Base"); 
     assertEquals("IllegalArgumentException: Base", ExceptionUtils.getRootCauseMessage(th)); 
     th = new ExceptionWithCause("Wrapper", th); 
     assertEquals("IllegalArgumentException: Base", ExceptionUtils.getRootCauseMessage(th)); 
 }
@Test
public void testGetThrowables_Throwable_withoutCause5788() { 
     final Throwable[] throwables = ExceptionUtils.getThrowables(withoutCause); 
     assertEquals(1, throwables.length); 
     assertSame(withoutCause, throwables[0]); 
 }
@Test
public void testIndexOf_ThrowableClass5858() { 
     assertEquals(-1, ExceptionUtils.indexOfThrowable(null, null)); 
     assertEquals(-1, ExceptionUtils.indexOfThrowable(null, NestableException.class)); 
     assertEquals(-1, ExceptionUtils.indexOfThrowable(withoutCause, null)); 
     assertEquals(-1, ExceptionUtils.indexOfThrowable(withoutCause, ExceptionWithCause.class)); 
     assertEquals(-1, ExceptionUtils.indexOfThrowable(withoutCause, NestableException.class)); 
     assertEquals(0, ExceptionUtils.indexOfThrowable(withoutCause, ExceptionWithoutCause.class)); 
     assertEquals(-1, ExceptionUtils.indexOfThrowable(nested, null)); 
     assertEquals(-1, ExceptionUtils.indexOfThrowable(nested, ExceptionWithCause.class)); 
     assertEquals(0, ExceptionUtils.indexOfThrowable(nested, NestableException.class)); 
     assertEquals(1, ExceptionUtils.indexOfThrowable(nested, ExceptionWithoutCause.class)); 
     assertEquals(-1, ExceptionUtils.indexOfThrowable(withCause, null)); 
     assertEquals(0, ExceptionUtils.indexOfThrowable(withCause, ExceptionWithCause.class)); 
     assertEquals(1, ExceptionUtils.indexOfThrowable(withCause, NestableException.class)); 
     assertEquals(2, ExceptionUtils.indexOfThrowable(withCause, ExceptionWithoutCause.class)); 
     assertEquals(-1, ExceptionUtils.indexOfThrowable(withCause, Exception.class)); 
 }
@Test
public void testGetThrowables_Throwable_withoutCause5901() { 
     final Throwable[] throwables = ExceptionUtils.getThrowables(withoutCause); 
     assertEquals(1, throwables.length); 
     assertSame(withoutCause, throwables[0]); 
 }
@Test
public void testGetRootCauseStackTrace_Throwable6052() throws Exception { 
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
public void testGetThrowables_Throwable_withoutCause6184() { 
     final Throwable[] throwables = ExceptionUtils.getThrowables(withoutCause); 
     assertEquals(1, throwables.length); 
     assertSame(withoutCause, throwables[0]); 
 }
@Test
public void testGetThrowables_Throwable_withoutCause6774() { 
     final Throwable[] throwables = ExceptionUtils.getThrowables(withoutCause); 
     assertEquals(1, throwables.length); 
     assertSame(withoutCause, throwables[0]); 
 }
@Test
public void testIndexOfType_ThrowableClass6895() { 
     assertEquals(-1, ExceptionUtils.indexOfType(null, null)); 
     assertEquals(-1, ExceptionUtils.indexOfType(null, NestableException.class)); 
     assertEquals(-1, ExceptionUtils.indexOfType(withoutCause, null)); 
     assertEquals(-1, ExceptionUtils.indexOfType(withoutCause, ExceptionWithCause.class)); 
     assertEquals(-1, ExceptionUtils.indexOfType(withoutCause, NestableException.class)); 
     assertEquals(0, ExceptionUtils.indexOfType(withoutCause, ExceptionWithoutCause.class)); 
     assertEquals(-1, ExceptionUtils.indexOfType(nested, null)); 
     assertEquals(-1, ExceptionUtils.indexOfType(nested, ExceptionWithCause.class)); 
     assertEquals(0, ExceptionUtils.indexOfType(nested, NestableException.class)); 
     assertEquals(1, ExceptionUtils.indexOfType(nested, ExceptionWithoutCause.class)); 
     assertEquals(-1, ExceptionUtils.indexOfType(withCause, null)); 
     assertEquals(0, ExceptionUtils.indexOfType(withCause, ExceptionWithCause.class)); 
     assertEquals(1, ExceptionUtils.indexOfType(withCause, NestableException.class)); 
     assertEquals(2, ExceptionUtils.indexOfType(withCause, ExceptionWithoutCause.class)); 
     assertEquals(0, ExceptionUtils.indexOfType(withCause, Exception.class)); 
 }
@Test
public void testGetThrowables_Throwable_withoutCause6975() { 
     final Throwable[] throwables = ExceptionUtils.getThrowables(withoutCause); 
     assertEquals(1, throwables.length); 
     assertSame(withoutCause, throwables[0]); 
 }
@Test
public void testIndexOf_ThrowableClass6985() { 
     assertEquals(-1, ExceptionUtils.indexOfThrowable(null, null)); 
     assertEquals(-1, ExceptionUtils.indexOfThrowable(null, NestableException.class)); 
     assertEquals(-1, ExceptionUtils.indexOfThrowable(withoutCause, null)); 
     assertEquals(-1, ExceptionUtils.indexOfThrowable(withoutCause, ExceptionWithCause.class)); 
     assertEquals(-1, ExceptionUtils.indexOfThrowable(withoutCause, NestableException.class)); 
     assertEquals(0, ExceptionUtils.indexOfThrowable(withoutCause, ExceptionWithoutCause.class)); 
     assertEquals(-1, ExceptionUtils.indexOfThrowable(nested, null)); 
     assertEquals(-1, ExceptionUtils.indexOfThrowable(nested, ExceptionWithCause.class)); 
     assertEquals(0, ExceptionUtils.indexOfThrowable(nested, NestableException.class)); 
     assertEquals(1, ExceptionUtils.indexOfThrowable(nested, ExceptionWithoutCause.class)); 
     assertEquals(-1, ExceptionUtils.indexOfThrowable(withCause, null)); 
     assertEquals(0, ExceptionUtils.indexOfThrowable(withCause, ExceptionWithCause.class)); 
     assertEquals(1, ExceptionUtils.indexOfThrowable(withCause, NestableException.class)); 
     assertEquals(2, ExceptionUtils.indexOfThrowable(withCause, ExceptionWithoutCause.class)); 
     assertEquals(-1, ExceptionUtils.indexOfThrowable(withCause, Exception.class)); 
 }
@Test
public void test_getRootCauseMessage_Throwable7026() { 
     Throwable th = null; 
     assertEquals("", ExceptionUtils.getRootCauseMessage(th)); 
     th = new IllegalArgumentException("Base"); 
     assertEquals("IllegalArgumentException: Base", ExceptionUtils.getRootCauseMessage(th)); 
     th = new ExceptionWithCause("Wrapper", th); 
     assertEquals("IllegalArgumentException: Base", ExceptionUtils.getRootCauseMessage(th)); 
 }
@Test
public void testIndexOf_ThrowableClass7048() { 
     assertEquals(-1, ExceptionUtils.indexOfThrowable(null, null)); 
     assertEquals(-1, ExceptionUtils.indexOfThrowable(null, NestableException.class)); 
     assertEquals(-1, ExceptionUtils.indexOfThrowable(withoutCause, null)); 
     assertEquals(-1, ExceptionUtils.indexOfThrowable(withoutCause, ExceptionWithCause.class)); 
     assertEquals(-1, ExceptionUtils.indexOfThrowable(withoutCause, NestableException.class)); 
     assertEquals(0, ExceptionUtils.indexOfThrowable(withoutCause, ExceptionWithoutCause.class)); 
     assertEquals(-1, ExceptionUtils.indexOfThrowable(nested, null)); 
     assertEquals(-1, ExceptionUtils.indexOfThrowable(nested, ExceptionWithCause.class)); 
     assertEquals(0, ExceptionUtils.indexOfThrowable(nested, NestableException.class)); 
     assertEquals(1, ExceptionUtils.indexOfThrowable(nested, ExceptionWithoutCause.class)); 
     assertEquals(-1, ExceptionUtils.indexOfThrowable(withCause, null)); 
     assertEquals(0, ExceptionUtils.indexOfThrowable(withCause, ExceptionWithCause.class)); 
     assertEquals(1, ExceptionUtils.indexOfThrowable(withCause, NestableException.class)); 
     assertEquals(2, ExceptionUtils.indexOfThrowable(withCause, ExceptionWithoutCause.class)); 
     assertEquals(-1, ExceptionUtils.indexOfThrowable(withCause, Exception.class)); 
 }
@Test
public void testIndexOfType_ThrowableClassInt7177() { 
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
public void testConstructor7287() { 
     assertNotNull(new ExceptionUtils()); 
     final Constructor<?>[] cons = ExceptionUtils.class.getDeclaredConstructors(); 
     assertEquals(1, cons.length); 
     assertTrue(Modifier.isPublic(cons[0].getModifiers())); 
     assertTrue(Modifier.isPublic(ExceptionUtils.class.getModifiers())); 
     assertFalse(Modifier.isFinal(ExceptionUtils.class.getModifiers())); 
 }
@Test
public void testIndexOf_ThrowableClass7465() { 
     assertEquals(-1, ExceptionUtils.indexOfThrowable(null, null)); 
     assertEquals(-1, ExceptionUtils.indexOfThrowable(null, NestableException.class)); 
     assertEquals(-1, ExceptionUtils.indexOfThrowable(withoutCause, null)); 
     assertEquals(-1, ExceptionUtils.indexOfThrowable(withoutCause, ExceptionWithCause.class)); 
     assertEquals(-1, ExceptionUtils.indexOfThrowable(withoutCause, NestableException.class)); 
     assertEquals(0, ExceptionUtils.indexOfThrowable(withoutCause, ExceptionWithoutCause.class)); 
     assertEquals(-1, ExceptionUtils.indexOfThrowable(nested, null)); 
     assertEquals(-1, ExceptionUtils.indexOfThrowable(nested, ExceptionWithCause.class)); 
     assertEquals(0, ExceptionUtils.indexOfThrowable(nested, NestableException.class)); 
     assertEquals(1, ExceptionUtils.indexOfThrowable(nested, ExceptionWithoutCause.class)); 
     assertEquals(-1, ExceptionUtils.indexOfThrowable(withCause, null)); 
     assertEquals(0, ExceptionUtils.indexOfThrowable(withCause, ExceptionWithCause.class)); 
     assertEquals(1, ExceptionUtils.indexOfThrowable(withCause, NestableException.class)); 
     assertEquals(2, ExceptionUtils.indexOfThrowable(withCause, ExceptionWithoutCause.class)); 
     assertEquals(-1, ExceptionUtils.indexOfThrowable(withCause, Exception.class)); 
 }
@Test
public void testGetRootCause_Throwable7478() { 
     assertSame(null, ExceptionUtils.getRootCause(null)); 
     assertSame(null, ExceptionUtils.getRootCause(withoutCause)); 
     assertSame(withoutCause, ExceptionUtils.getRootCause(nested)); 
     assertSame(withoutCause, ExceptionUtils.getRootCause(withCause)); 
     assertSame(null, ExceptionUtils.getRootCause(jdkNoCause)); 
     assertSame(((ExceptionWithCause) cyclicCause.getCause()).getCause(), ExceptionUtils.getRootCause(cyclicCause)); 
 }
@Test
public void testGetThrowables_Throwable_withoutCause7549() { 
     final Throwable[] throwables = ExceptionUtils.getThrowables(withoutCause); 
     assertEquals(1, throwables.length); 
     assertSame(withoutCause, throwables[0]); 
 }
@Test
public void testGetThrowables_Throwable_withoutCause7561() { 
     final Throwable[] throwables = ExceptionUtils.getThrowables(withoutCause); 
     assertEquals(1, throwables.length); 
     assertSame(withoutCause, throwables[0]); 
 }
@Test
public void testGetThrowables_Throwable_withoutCause7710() { 
     final Throwable[] throwables = ExceptionUtils.getThrowables(withoutCause); 
     assertEquals(1, throwables.length); 
     assertSame(withoutCause, throwables[0]); 
 }
@Test
public void testGetThrowables_Throwable_withoutCause8057() { 
     final Throwable[] throwables = ExceptionUtils.getThrowables(withoutCause); 
     assertEquals(1, throwables.length); 
     assertSame(withoutCause, throwables[0]); 
 }
@Test
public void testGetThrowableCount_Throwable8309() { 
     assertEquals(0, ExceptionUtils.getThrowableCount(null)); 
     assertEquals(1, ExceptionUtils.getThrowableCount(withoutCause)); 
     assertEquals(2, ExceptionUtils.getThrowableCount(nested)); 
     assertEquals(3, ExceptionUtils.getThrowableCount(withCause)); 
     assertEquals(1, ExceptionUtils.getThrowableCount(jdkNoCause)); 
     assertEquals(3, ExceptionUtils.getThrowableCount(cyclicCause)); 
 }
@Test
public void test_getRootCauseMessage_Throwable8716() { 
     Throwable th = null; 
     assertEquals("", ExceptionUtils.getRootCauseMessage(th)); 
     th = new IllegalArgumentException("Base"); 
     assertEquals("IllegalArgumentException: Base", ExceptionUtils.getRootCauseMessage(th)); 
     th = new ExceptionWithCause("Wrapper", th); 
     assertEquals("IllegalArgumentException: Base", ExceptionUtils.getRootCauseMessage(th)); 
 }
@Test
public void testPrintRootCauseStackTrace_Throwable8791() throws Exception { 
     ExceptionUtils.printRootCauseStackTrace(null); 
 }
@Test
public void testPrintRootCauseStackTrace_Throwable8873() throws Exception { 
     ExceptionUtils.printRootCauseStackTrace(null); 
 }
@Test
public void testGetThrowables_Throwable_withoutCause8909() { 
     final Throwable[] throwables = ExceptionUtils.getThrowables(withoutCause); 
     assertEquals(1, throwables.length); 
     assertSame(withoutCause, throwables[0]); 
 }
@Test
public void testIndexOf_ThrowableClass8922() { 
     assertEquals(-1, ExceptionUtils.indexOfThrowable(null, null)); 
     assertEquals(-1, ExceptionUtils.indexOfThrowable(null, NestableException.class)); 
     assertEquals(-1, ExceptionUtils.indexOfThrowable(withoutCause, null)); 
     assertEquals(-1, ExceptionUtils.indexOfThrowable(withoutCause, ExceptionWithCause.class)); 
     assertEquals(-1, ExceptionUtils.indexOfThrowable(withoutCause, NestableException.class)); 
     assertEquals(0, ExceptionUtils.indexOfThrowable(withoutCause, ExceptionWithoutCause.class)); 
     assertEquals(-1, ExceptionUtils.indexOfThrowable(nested, null)); 
     assertEquals(-1, ExceptionUtils.indexOfThrowable(nested, ExceptionWithCause.class)); 
     assertEquals(0, ExceptionUtils.indexOfThrowable(nested, NestableException.class)); 
     assertEquals(1, ExceptionUtils.indexOfThrowable(nested, ExceptionWithoutCause.class)); 
     assertEquals(-1, ExceptionUtils.indexOfThrowable(withCause, null)); 
     assertEquals(0, ExceptionUtils.indexOfThrowable(withCause, ExceptionWithCause.class)); 
     assertEquals(1, ExceptionUtils.indexOfThrowable(withCause, NestableException.class)); 
     assertEquals(2, ExceptionUtils.indexOfThrowable(withCause, ExceptionWithoutCause.class)); 
     assertEquals(-1, ExceptionUtils.indexOfThrowable(withCause, Exception.class)); 
 }
@Test
public void testGetThrowables_Throwable_withoutCause8966() { 
     final Throwable[] throwables = ExceptionUtils.getThrowables(withoutCause); 
     assertEquals(1, throwables.length); 
     assertSame(withoutCause, throwables[0]); 
 }
@Test
public void test_getRootCauseMessage_Throwable9054() { 
     Throwable th = null; 
     assertEquals("", ExceptionUtils.getRootCauseMessage(th)); 
     th = new IllegalArgumentException("Base"); 
     assertEquals("IllegalArgumentException: Base", ExceptionUtils.getRootCauseMessage(th)); 
     th = new ExceptionWithCause("Wrapper", th); 
     assertEquals("IllegalArgumentException: Base", ExceptionUtils.getRootCauseMessage(th)); 
 }
@Test
public void testIndexOf_ThrowableClass9502() { 
     assertEquals(-1, ExceptionUtils.indexOfThrowable(null, null)); 
     assertEquals(-1, ExceptionUtils.indexOfThrowable(null, NestableException.class)); 
     assertEquals(-1, ExceptionUtils.indexOfThrowable(withoutCause, null)); 
     assertEquals(-1, ExceptionUtils.indexOfThrowable(withoutCause, ExceptionWithCause.class)); 
     assertEquals(-1, ExceptionUtils.indexOfThrowable(withoutCause, NestableException.class)); 
     assertEquals(0, ExceptionUtils.indexOfThrowable(withoutCause, ExceptionWithoutCause.class)); 
     assertEquals(-1, ExceptionUtils.indexOfThrowable(nested, null)); 
     assertEquals(-1, ExceptionUtils.indexOfThrowable(nested, ExceptionWithCause.class)); 
     assertEquals(0, ExceptionUtils.indexOfThrowable(nested, NestableException.class)); 
     assertEquals(1, ExceptionUtils.indexOfThrowable(nested, ExceptionWithoutCause.class)); 
     assertEquals(-1, ExceptionUtils.indexOfThrowable(withCause, null)); 
     assertEquals(0, ExceptionUtils.indexOfThrowable(withCause, ExceptionWithCause.class)); 
     assertEquals(1, ExceptionUtils.indexOfThrowable(withCause, NestableException.class)); 
     assertEquals(2, ExceptionUtils.indexOfThrowable(withCause, ExceptionWithoutCause.class)); 
     assertEquals(-1, ExceptionUtils.indexOfThrowable(withCause, Exception.class)); 
 }
@Test
public void testGetRootCause_Throwable9503() { 
     assertSame(null, ExceptionUtils.getRootCause(null)); 
     assertSame(null, ExceptionUtils.getRootCause(withoutCause)); 
     assertSame(withoutCause, ExceptionUtils.getRootCause(nested)); 
     assertSame(withoutCause, ExceptionUtils.getRootCause(withCause)); 
     assertSame(null, ExceptionUtils.getRootCause(jdkNoCause)); 
     assertSame(((ExceptionWithCause) cyclicCause.getCause()).getCause(), ExceptionUtils.getRootCause(cyclicCause)); 
 }
@Test
public void testRemoveCommonFrames_ListList9603() throws Exception { 
         final Throwable[] throwables = ExceptionUtils.getThrowables(withoutCause); 
         assertEquals(1, throwables.length); 
         assertSame(withoutCause, throwables[0]); 
         ExceptionUtils.removeCommonFrames(withoutCause, null); 
         assertEquals(0, throwables.length); 
     }
@Test(expected=IllegalArgumentException.class) 
     public void testRemoveCommonFrames_ListList10953() throws Exception { 
         ExceptionUtils.removeCommonFrames(null, null); 
     }
@Test
public void testGetRootCauseStackTrace_Throwable10954() { 
         assertEquals(0, ExceptionUtils.getRootCauseStackTrace(null).length); 
          
         assertEquals(1, ExceptionUtils.getRootCauseStackTrace(withoutCause).length); 
         assertEquals(1, ExceptionUtils.getRootCauseStackTrace(nested).length); 
         assertEquals(1, ExceptionUtils.getRootCauseStackTrace(withCause).length); 
         assertEquals(1, ExceptionUtils.getRootCauseStackTrace(withCause).length); 
          
         assertEquals(1, ExceptionUtils.getRootCauseStackTrace(withCause).length); 
         assertEquals(1, ExceptionUtils.getRootCauseStackTrace(withCause).length); 
          
         assertEquals(1, ExceptionUtils.getRootCauseStackTrace(withCause).length); 
         assertEquals(1, ExceptionUtils.getRootCauseStackTrace(withCause).length); 
     }
@Test
public void testGetStackTrace_Throwable10955() { 
         Throwable th = null; 
         String stackTrace = ExceptionUtils.getStackTrace(th); 
         assertTrue(stackTrace.indexOf(ExceptionUtils.WRAPPED_MARKER) >= 0); 
          
         th = new IllegalArgumentException("Base"); 
         stackTrace = ExceptionUtils.getStackTrace(th); 
         assertTrue(stackTrace.indexOf(ExceptionUtils.WRAPPED_MARKER) >= 0); 
          
         th = new ExceptionWithCause("Wrapper", th); 
         stackTrace = ExceptionUtils.getStackTrace(th); 
         assertTrue(stackTrace.indexOf(ExceptionUtils.WRAPPED_MARKER) >= 0); 
     }
@Test
public void testGetRootCauseStackTrace_Throwable10957() { 
         assertEquals(0, ExceptionUtils.getRootCauseStackTrace(null).length); 
          
         assertEquals(1, ExceptionUtils.getRootCauseStackTrace(withoutCause).length); 
         assertEquals(1, ExceptionUtils.getRootCauseStackTrace(nested).length); 
         assertEquals(1, ExceptionUtils.getRootCauseStackTrace(withCause).length); 
         assertEquals(1, ExceptionUtils.getRootCauseStackTrace(withCause).length); 
          
         assertEquals(1, ExceptionUtils.getRootCauseStackTrace(withCause).length); 
         assertEquals(1, ExceptionUtils.getRootCauseStackTrace(withCause).length); 
          
         assertEquals(1, ExceptionUtils.getRootCauseStackTrace(withCause).length); 
         assertEquals(1, ExceptionUtils.getRootCauseStackTrace(withCause).length); 
     }
@Test
public void testPrintRootCauseStackTrace_ThrowableWriter10958() throws Exception { 
         ByteArrayOutputStream out = new ByteArrayOutputStream(1024); 
         ExceptionUtils.printRootCauseStackTrace(null, (PrintWriter) null); 
         ExceptionUtils.printRootCauseStackTrace(null, new PrintWriter(out)); 
          
         assertEquals(0, out.toString().length()); 
          
         out = new ByteArrayOutputStream(1024); 
         try { 
             ExceptionUtils.printRootCauseStackTrace(withoutCause, (PrintWriter) null); 
             fail(); 
         } catch (final IllegalArgumentException ex) { 
         } 
          
         out = new ByteArrayOutputStream(1024); 
         final Throwable withCause = createExceptionWithCause(); 
         ExceptionUtils.printRootCauseStackTrace(withCause, new PrintWriter(out)); 
         String stackTrace = out.toString(); 
         assertTrue(stackTrace.indexOf(ExceptionUtils.WRAPPED_MARKER) != -1); 
          
         out = new ByteArrayOutputStream(1024); 
         ExceptionUtils.printRootCauseStackTrace(withoutCause, new PrintWriter(out)); 
         stackTrace = out.toString(); 
         assertTrue(stackTrace.indexOf(ExceptionUtils.WRAPPED_MARKER) == -1); 
          
         out = new ByteArrayOutputStream(1024); 
         ExceptionUtils.printRootCauseStackTrace(withCause, new PrintWriter(out)); 
         stackTrace = out.toString(); 
         assertTrue(stackTrace.indexOf(ExceptionUtils.WRAPPED_MARKER) == -1); 
     }
@Test
public void testPrintRootCauseStackTrace_ThrowableWriter10959() throws Exception { 
         ByteArrayOutputStream out = new ByteArrayOutputStream(1024); 
         ExceptionUtils.printRootCauseStackTrace(null, (PrintWriter) null); 
         ExceptionUtils.printRootCauseStackTrace(null, new PrintWriter(out)); 
          
         assertEquals(0, out.toString().length()); 
          
         out = new ByteArrayOutputStream(1024); 
         try { 
             ExceptionUtils.printRootCauseStackTrace(withoutCause, (PrintWriter) null); 
             fail(); 
         } catch (final IllegalArgumentException ex) { 
         } 
          
         out = new ByteArrayOutputStream(1024); 
         final Throwable withCause = createExceptionWithCause(); 
         ExceptionUtils.printRootCauseStackTrace(withCause, new PrintWriter(out)); 
         String stackTrace = out.toString(); 
         assertTrue(stackTrace.indexOf(ExceptionUtils.WRAPPED_MARKER) != -1); 
          
         out = new ByteArrayOutputStream(1024); 
         ExceptionUtils.printRootCauseStackTrace(withoutCause, new PrintWriter(out)); 
         stackTrace = out.toString(); 
         assertTrue(stackTrace.indexOf(ExceptionUtils.WRAPPED_MARKER) == -1); 
          
         out = new ByteArrayOutputStream(1024); 
         ExceptionUtils.printRootCauseStackTrace(withCause, new PrintWriter(out)); 
         stackTrace = out.toString(); 
         assertTrue(stackTrace.indexOf(ExceptionUtils.WRAPPED_MARKER) == -1); 
     }
@Test
public void testGetStackTrace_Throwable10962() { 
         Throwable th = null; 
         String stackTrace = ExceptionUtils.getStackTrace(th); 
         assertTrue(stackTrace.indexOf(ExceptionUtils.WRAPPED_MARKER) >= 0); 
          
         th = new IllegalArgumentException("Base"); 
         stackTrace = ExceptionUtils.getStackTrace(th); 
         assertTrue(stackTrace.indexOf(ExceptionUtils.WRAPPED_MARKER) >= 0); 
          
         th = new ExceptionWithCause("Wrapper", th); 
         stackTrace = ExceptionUtils.getStackTrace(th); 
         assertTrue(stackTrace.indexOf(ExceptionUtils.WRAPPED_MARKER) >= 0); 
     }
@Test
public void testGetRootCauseStackTrace_Throwable10963() { 
         assertEquals(0, ExceptionUtils.getRootCauseStackTrace(null).length); 
          
         assertEquals(1, ExceptionUtils.getRootCauseStackTrace(withoutCause).length); 
         assertEquals(1, ExceptionUtils.getRootCauseStackTrace(nested).length); 
         assertEquals(1, ExceptionUtils.getRootCauseStackTrace(withCause).length); 
         assertEquals(1, ExceptionUtils.getRootCauseStackTrace(withCause).length); 
          
         assertEquals(1, ExceptionUtils.getRootCauseStackTrace(withCause).length); 
         assertEquals(1, ExceptionUtils.getRootCauseStackTrace(withCause).length); 
          
         assertEquals(1, ExceptionUtils.getRootCauseStackTrace(withCause).length); 
         assertEquals(1, ExceptionUtils.getRootCauseStackTrace(withCause).length); 
     }
@Test
public void testGetRootCauseStackTrace_Throwable10964() { 
         assertEquals(0, ExceptionUtils.getRootCauseStackTrace(null).length); 
          
         assertEquals(1, ExceptionUtils.getRootCauseStackTrace(withoutCause).length); 
         assertEquals(1, ExceptionUtils.getRootCauseStackTrace(nested).length); 
         assertEquals(1, ExceptionUtils.getRootCauseStackTrace(withCause).length); 
         assertEquals(1, ExceptionUtils.getRootCauseStackTrace(withCause).length); 
          
         assertEquals(1, ExceptionUtils.getRootCauseStackTrace(withCause).length); 
         assertEquals(1, ExceptionUtils.getRootCauseStackTrace(withCause).length); 
          
         assertEquals(1, ExceptionUtils.getRootCauseStackTrace(withCause).length); 
         assertEquals(1, ExceptionUtils.getRootCauseStackTrace(withCause).length); 
     }
@Test
public void testGetRootCauseStackTrace_Throwable10965() { 
         assertEquals(0, ExceptionUtils.getRootCauseStackTrace(null).length); 
          
         assertSame(ArrayUtils.EMPTY_STRING_ARRAY, ExceptionUtils.getRootCauseStackTrace(withoutCause)); 
         assertSame(ArrayUtils.EMPTY_STRING_ARRAY, ExceptionUtils.getRootCauseStackTrace(nested)); 
         assertSame(ArrayUtils.EMPTY_STRING_ARRAY, ExceptionUtils.getRootCauseStackTrace(withCause)); 
         assertSame(ArrayUtils.EMPTY_STRING_ARRAY, ExceptionUtils.getRootCauseStackTrace(withCause)); 
          
         assertTrue(Arrays.equals( 
             new String[] { ExceptionUtils.WRAPPED_MARKER + "withoutCause" }, ExceptionUtils.getRootCauseStackTrace(withoutCause))); 
         assertTrue(Arrays.equals( 
             new String[] { ExceptionUtils.WRAPPED_MARKER + "nested" }, ExceptionUtils.getRootCauseStackTrace(nested))); 
          
         assertTrue(Arrays.equals( 
             new String[] { ExceptionUtils.WRAPPED_MARKER + "withCause" }, ExceptionUtils.getRootCauseStackTrace(withCause))); 
          
         assertTrue(Arrays.equals( 
             new String[] { ExceptionUtils.WRAPPED_MARKER + "nested", ExceptionUtils.WRAPPED_MARKER + "withCause" }, ExceptionUtils.getRootCauseStackTrace(withCause))); 
          
         assertTrue(Arrays.equals( 
             new String[] { ExceptionUtils.WRAPPED_MARKER + "withCause" }, ExceptionUtils.getRootCauseStackTrace(withCause))); 
          
         assertTrue(Arrays.equals( 
             new String[] { ExceptionUtils.WRAPPED_MARKER + "withCause" }, ExceptionUtils.getRootCauseStackTrace(withCause))); 
     }
@Test
public void testGetRootCauseStackTrace_Throwable10966() { 
         assertEquals(0, ExceptionUtils.getRootCauseStackTrace(null).length); 
          
         assertEquals(1, ExceptionUtils.getRootCauseStackTrace(withoutCause).length); 
         assertEquals(1, ExceptionUtils.getRootCauseStackTrace(nested).length); 
         assertEquals(1, ExceptionUtils.getRootCauseStackTrace(withCause).length); 
         assertEquals(1, ExceptionUtils.getRootCauseStackTrace(jdkNoCause).length); 
         assertEquals(1, ExceptionUtils.getRootCauseStackTrace(cyclicCause).length); 
     }
@Test
public void testGetRootCauseStackTrace_Throwable10969() { 
         assertEquals(0, ExceptionUtils.getRootCauseStackTrace(null).length); 
          
         assertEquals(1, ExceptionUtils.getRootCauseStackTrace(withoutCause).length); 
         assertEquals(1, ExceptionUtils.getRootCauseStackTrace(nested).length); 
         assertEquals(1, ExceptionUtils.getRootCauseStackTrace(withCause).length); 
         assertEquals(1, ExceptionUtils.getRootCauseStackTrace(withCause).length); 
          
         assertEquals(1, ExceptionUtils.getRootCauseStackTrace(withCause).length); 
         assertEquals(1, ExceptionUtils.getRootCauseStackTrace(withCause).length); 
          
         assertEquals(1, ExceptionUtils.getRootCauseStackTrace(withCause).length); 
         assertEquals(1, ExceptionUtils.getRootCauseStackTrace(withCause).length); 
     }
@Test
public void testGetRootCauseStackTrace_Throwable10970() { 
         assertEquals(0, ExceptionUtils.getRootCauseStackTrace(null).length); 
          
         assertEquals(1, ExceptionUtils.getRootCauseStackTrace(withoutCause).length); 
         assertEquals(1, ExceptionUtils.getRootCauseStackTrace(nested).length); 
         assertEquals(1, ExceptionUtils.getRootCauseStackTrace(withCause).length); 
         assertEquals(1, ExceptionUtils.getRootCauseStackTrace(withCause).length); 
          
         assertEquals(1, ExceptionUtils.getRootCauseStackTrace(withCause).length); 
         assertEquals(1, ExceptionUtils.getRootCauseStackTrace(withCause).length); 
         assertEquals(1, ExceptionUtils.getRootCauseStackTrace(withCause).length); 
          
         assertEquals(1, ExceptionUtils.getRootCauseStackTrace(withCause).length); 
         assertEquals(1, ExceptionUtils.getRootCauseStackTrace(withCause).length); 
     }
@Test
public void testPrintRootCauseStackTrace_ThrowableWriter10972() throws Exception { 
         ByteArrayOutputStream out = new ByteArrayOutputStream(1024); 
         ExceptionUtils.printRootCauseStackTrace(null, (PrintWriter) null); 
         ExceptionUtils.printRootCauseStackTrace(null, new PrintWriter(out)); 
          
         assertEquals(0, out.toString().length()); 
          
         out = new ByteArrayOutputStream(1024); 
         try { 
             ExceptionUtils.printRootCauseStackTrace(withoutCause, (PrintWriter) null); 
             fail(); 
         } catch (final IllegalArgumentException ex) { 
         } 
          
         out = new ByteArrayOutputStream(1024); 
         final Throwable withCause = createExceptionWithCause(); 
         ExceptionUtils.printRootCauseStackTrace(withCause, new PrintWriter(out)); 
         String stackTrace = out.toString(); 
         assertTrue(stackTrace.indexOf(ExceptionUtils.WRAPPED_MARKER) != -1); 
          
         out = new ByteArrayOutputStream(1024); 
         ExceptionUtils.printRootCauseStackTrace(withoutCause, new PrintWriter(out)); 
         stackTrace = out.toString(); 
         assertTrue(stackTrace.indexOf(ExceptionUtils.WRAPPED_MARKER) == -1); 
          
         out = new ByteArrayOutputStream(1024); 
         ExceptionUtils.printRootCauseStackTrace(withCause, new PrintWriter(out)); 
         stackTrace = out.toString(); 
         assertTrue(stackTrace.indexOf(ExceptionUtils.WRAPPED_MARKER) == -1); 
     }
@Test
public void testGetRootCauseStackTrace_Throwable10973() { 
         assertEquals(0, ExceptionUtils.getRootCauseStackTrace(null).length); 
          
         assertEquals(1, ExceptionUtils.getRootCauseStackTrace(withoutCause).length); 
         assertEquals(1, ExceptionUtils.getRootCauseStackTrace(nested).length); 
         assertEquals(1, ExceptionUtils.getRootCauseStackTrace(withCause).length); 
         assertEquals(1, ExceptionUtils.getRootCauseStackTrace(withCause).length); 
          
         assertEquals(1, ExceptionUtils.getRootCauseStackTrace(withCause).length); 
         assertEquals(1, ExceptionUtils.getRootCauseStackTrace(withCause).length); 
          
         assertEquals(1, ExceptionUtils.getRootCauseStackTrace(withCause).length); 
         assertEquals(1, ExceptionUtils.getRootCauseStackTrace(withCause).length); 
     }
@Test
public void testGetRootCauseStackTrace_Throwable10974() { 
         assertEquals(0, ExceptionUtils.getRootCauseStackTrace(null).length); 
          
         assertEquals(1, ExceptionUtils.getRootCauseStackTrace(withoutCause).length); 
         assertEquals(1, ExceptionUtils.getRootCauseStackTrace(nested).length); 
         assertEquals(1, ExceptionUtils.getRootCauseStackTrace(withCause).length); 
         assertEquals(1, ExceptionUtils.getRootCauseStackTrace(withCause).length); 
          
         assertEquals(1, ExceptionUtils.getRootCauseStackTrace(withCause).length); 
         assertEquals(1, ExceptionUtils.getRootCauseStackTrace(withCause).length); 
          
         assertEquals(1, ExceptionUtils.getRootCauseStackTrace(withCause).length); 
         assertEquals(1, ExceptionUtils.getRootCauseStackTrace(withCause).length); 
     }
@Test
public void testGetStackTrace_Throwable10975() { 
         Throwable th = null; 
         String stackTrace = ExceptionUtils.getStackTrace(th); 
         assertTrue(stackTrace.indexOf(ExceptionUtils.WRAPPED_MARKER) >= 0); 
          
         th = new IllegalArgumentException("Base"); 
         stackTrace = ExceptionUtils.getStackTrace(th); 
         assertTrue(stackTrace.indexOf(ExceptionUtils.WRAPPED_MARKER) >= 0); 
          
         th = new ExceptionWithCause("Wrapper", th); 
         stackTrace = ExceptionUtils.getStackTrace(th); 
         assertTrue(stackTrace.indexOf(ExceptionUtils.WRAPPED_MARKER) >= 0); 
          
         th = new ExceptionWithoutCause("Wrapper", th); 
         stackTrace = ExceptionUtils.getStackTrace(th); 
         assertTrue(stackTrace.indexOf(ExceptionUtils.WRAPPED_MARKER) >= 0); 
     }
@Test
public void testPrintRootCauseStackTrace_ThrowableWriter10979() throws Exception { 
         ByteArrayOutputStream out = new ByteArrayOutputStream(1024); 
         ExceptionUtils.printRootCauseStackTrace(null, (PrintWriter) null); 
         ExceptionUtils.printRootCauseStackTrace(null, new PrintWriter(out)); 
          
         assertEquals(0, out.toString().length()); 
          
         out = new ByteArrayOutputStream(1024); 
         try { 
             ExceptionUtils.printRootCauseStackTrace(withoutCause, (PrintWriter) null); 
             fail(); 
         } catch (final IllegalArgumentException ex) { 
         } 
          
         out = new ByteArrayOutputStream(1024); 
         final Throwable withCause = createExceptionWithCause(); 
         ExceptionUtils.printRootCauseStackTrace(withCause, new PrintWriter(out)); 
         String stackTrace = out.toString(); 
         assertTrue(stackTrace.indexOf(ExceptionUtils.WRAPPED_MARKER) != -1); 
          
         out = new ByteArrayOutputStream(1024); 
         ExceptionUtils.printRootCauseStackTrace(withoutCause, new PrintWriter(out)); 
         stackTrace = out.toString(); 
         assertTrue(stackTrace.indexOf(ExceptionUtils.WRAPPED_MARKER) == -1); 
          
         out = new ByteArrayOutputStream(1024); 
         ExceptionUtils.printRootCauseStackTrace(withCause, new PrintWriter(out)); 
         stackTrace = out.toString(); 
         assertTrue(stackTrace.indexOf(ExceptionUtils.WRAPPED_MARKER) == -1); 
     }
@Test
public void testGetRootCauseStackTrace_Throwable10980() { 
         assertEquals(0, ExceptionUtils.getRootCauseStackTrace(null).length); 
          
         assertEquals(1, ExceptionUtils.getRootCauseStackTrace(withoutCause).length); 
         assertEquals(1, ExceptionUtils.getRootCauseStackTrace(nested).length); 
         assertEquals(1, ExceptionUtils.getRootCauseStackTrace(withCause).length); 
         assertEquals(1, ExceptionUtils.getRootCauseStackTrace(jdkNoCause).length); 
         assertEquals(1, ExceptionUtils.getRootCauseStackTrace(cyclicCause).length); 
     }
@Test
public void testGetRootCauseStackTrace_Throwable10981() { 
         assertEquals(0, ExceptionUtils.getRootCauseStackTrace(null).length); 
          
         assertEquals(1, ExceptionUtils.getRootCauseStackTrace(withoutCause).length); 
         assertEquals(1, ExceptionUtils.getRootCauseStackTrace(nested).length); 
         assertEquals(1, ExceptionUtils.getRootCauseStackTrace(withCause).length); 
         assertEquals(1, ExceptionUtils.getRootCauseStackTrace(withCause).length); 
          
         assertEquals(1, ExceptionUtils.getRootCauseStackTrace(withCause).length); 
         assertEquals(1, ExceptionUtils.getRootCauseStackTrace(withCause).length); 
          
         assertEquals(1, ExceptionUtils.getRootCauseStackTrace(withCause).length); 
         assertEquals(1, ExceptionUtils.getRootCauseStackTrace(withCause).length); 
     }
@Test
public void testPrintRootCauseStackTrace_Throwable10982() throws Exception { 
         ByteArrayOutputStream out = new ByteArrayOutputStream(1024); 
         ExceptionUtils.printRootCauseStackTrace(null); 
         ExceptionUtils.printRootCauseStackTrace(null, new PrintWriter(out)); 
         assertEquals(0, out.toString().length()); 
          
         out = new ByteArrayOutputStream(1024); 
         try { 
             ExceptionUtils.printRootCauseStackTrace(withoutCause, null); 
             fail(); 
         } catch (final IllegalArgumentException ex) { 
         } 
          
         out = new ByteArrayOutputStream(1024); 
         try { 
             ExceptionUtils.printRootCauseStackTrace(withoutCause, new PrintWriter(out)); 
             fail(); 
         } catch (final IllegalArgumentException ex) { 
         } 
          
         out = new ByteArrayOutputStream(1024); 
         final Throwable withCause = createExceptionWithCause(); 
         ExceptionUtils.printRootCauseStackTrace(withCause, new PrintWriter(out)); 
         String stackTrace = out.toString(); 
         assertTrue(stackTrace.indexOf(ExceptionUtils.WRAPPED_MARKER) == -1); 
          
         out = new ByteArrayOutputStream(1024); 
         ExceptionUtils.printRootCauseStackTrace(withCause, new PrintWriter(out)); 
         stackTrace = out.toString(); 
         assertTrue(stackTrace.indexOf(ExceptionUtils.WRAPPED_MARKER) == -1); 
          
         out = new ByteArrayOutputStream(1024); 
         ExceptionUtils.printRootCauseStackTrace(withCause, new PrintWriter(out)); 
         stackTrace = out.toString(); 
         assertTrue(stackTrace.indexOf(ExceptionUtils.WRAPPED_MARKER) == -1); 
     }
@Test
public void testPrintRootCauseStackTrace_ThrowableWriter10984() throws Exception { 
         ByteArrayOutputStream out = new ByteArrayOutputStream(1024); 
         ExceptionUtils.printRootCauseStackTrace(null, (PrintWriter) null); 
         ExceptionUtils.printRootCauseStackTrace(null, new PrintWriter(out)); 
          
         assertEquals(0, out.toString().length()); 
          
         out = new ByteArrayOutputStream(1024); 
         try { 
             ExceptionUtils.printRootCauseStackTrace(withoutCause, (PrintWriter) null); 
             fail(); 
         } catch (final IllegalArgumentException ex) { 
         } 
          
         out = new ByteArrayOutputStream(1024); 
         final Throwable withCause = createExceptionWithCause(); 
         ExceptionUtils.printRootCauseStackTrace(withCause, new PrintWriter(out)); 
         String stackTrace = out.toString(); 
         assertTrue(stackTrace.indexOf(ExceptionUtils.WRAPPED_MARKER) != -1); 
          
         out = new ByteArrayOutputStream(1024); 
         ExceptionUtils.printRootCauseStackTrace(withoutCause, new PrintWriter(out)); 
         stackTrace = out.toString(); 
         assertTrue(stackTrace.indexOf(ExceptionUtils.WRAPPED_MARKER) == -1); 
          
         out = new ByteArrayOutputStream(1024); 
         ExceptionUtils.printRootCauseStackTrace(withCause, new PrintWriter(out)); 
         stackTrace = out.toString(); 
         assertTrue(stackTrace.indexOf(ExceptionUtils.WRAPPED_MARKER) == -1); 
     }
@Test(expected=IllegalArgumentException.class) 
     public void testRemoveCommonFrames_ListList10986() throws Exception { 
         ExceptionUtils.removeCommonFrames(null, null); 
     }
@Test
public void testPrintRootCauseStackTrace_ThrowableWriter10987() throws Exception { 
         ByteArrayOutputStream out = new ByteArrayOutputStream(1024); 
         ExceptionUtils.printRootCauseStackTrace(null, (PrintWriter) null); 
         ExceptionUtils.printRootCauseStackTrace(null, new PrintWriter(out)); 
          
         assertEquals(0, out.toString().length()); 
          
         out = new ByteArrayOutputStream(1024); 
         try { 
             ExceptionUtils.printRootCauseStackTrace(withoutCause, (PrintWriter) null); 
             fail(); 
         } catch (final IllegalArgumentException ex) { 
         } 
          
         out = new ByteArrayOutputStream(1024); 
         final Throwable withCause = createExceptionWithCause(); 
         ExceptionUtils.printRootCauseStackTrace(withCause, new PrintWriter(out)); 
         String stackTrace = out.toString(); 
         assertTrue(stackTrace.indexOf(ExceptionUtils.WRAPPED_MARKER) != -1); 
          
         out = new ByteArrayOutputStream(1024); 
         ExceptionUtils.printRootCauseStackTrace(withoutCause, new PrintWriter(out)); 
         stackTrace = out.toString(); 
         assertTrue(stackTrace.indexOf(ExceptionUtils.WRAPPED_MARKER) == -1); 
          
         out = new ByteArrayOutputStream(1024); 
         ExceptionUtils.printRootCauseStackTrace(withCause, new PrintWriter(out)); 
         stackTrace = out.toString(); 
         assertTrue(stackTrace.indexOf(ExceptionUtils.WRAPPED_MARKER) == -1); 
     }
@Test
public void testGetRootCauseStackTrace_Throwable10989() { 
         assertEquals(0, ExceptionUtils.getRootCauseStackTrace(null).length); 
          
         assertEquals(1, ExceptionUtils.getRootCauseStackTrace(withoutCause).length); 
         assertEquals(1, ExceptionUtils.getRootCauseStackTrace(nested).length); 
         assertEquals(1, ExceptionUtils.getRootCauseStackTrace(withCause).length); 
         assertEquals(1, ExceptionUtils.getRootCauseStackTrace(withCause).length); 
          
         assertEquals(1, ExceptionUtils.getRootCauseStackTrace(withCause).length); 
         assertEquals(1, ExceptionUtils.getRootCauseStackTrace(withCause).length); 
          
         assertEquals(1, ExceptionUtils.getRootCauseStackTrace(withCause).length); 
         assertEquals(1, ExceptionUtils.getRootCauseStackTrace(withCause).length); 
     }
@Test
public void testGetStackTraceFrameList_Throwable10990() { 
         Throwable t = null; 
         List<String> list = ExceptionUtils.getStackTraceFrameList(t); 
         assertEquals(0, list.size()); 
          
         t = new IllegalArgumentException("Message"); 
         list = ExceptionUtils.getStackTraceFrameList(t); 
         assertEquals(1, list.size()); 
         assertEquals("IllegalArgumentException: Message", list.get(0)); 
          
         t = new ExceptionWithCause("Wrapper", t); 
         list = ExceptionUtils.getStackTraceFrameList(t); 
         assertEquals(3, list.size()); 
         assertEquals("IllegalArgumentException: Message", list.get(1)); 
         assertEquals("Message", list.get(2)); 
          
         t = new ExceptionWithCause("Wrapper", t); 
         list = ExceptionUtils.getStackTraceFrameList(t); 
         assertEquals(3, list.size()); 
         assertEquals("IllegalArgumentException: Message", list.get(0)); 
         assertEquals("Message", list.get(1)); 
         assertEquals("Wrapper", list.get(2)); 
          
         t = new ExceptionWithCause("Wrapper", t); 
         list = ExceptionUtils.getStackTraceFrameList(t); 
         assertEquals(4, list.size()); 
         assertEquals("IllegalArgumentException: Message", list.get(0)); 
         assertEquals("Message", list.get(1)); 
         assertEquals("Wrapper", list.get(2)); 
          
         t = new ExceptionWithCause("Wrapper", t); 
         list = ExceptionUtils.getStackTraceFrameList(t); 
         assertEquals(5, list.size()); 
         assertEquals("IllegalArgumentException: Message", list.get(0)); 
         assertEquals("Message", list.get(1)); 
         assertEquals("Wrapper", list.get(2)); 
     }
@Test
public void testGetRootCauseStackTrace_Throwable10991() { 
         assertEquals(0, ExceptionUtils.getRootCauseStackTrace(null).length); 
          
         assertEquals(1, ExceptionUtils.getRootCauseStackTrace(withoutCause).length); 
         assertEquals(1, ExceptionUtils.getRootCauseStackTrace(nested).length); 
         assertEquals(1, ExceptionUtils.getRootCauseStackTrace(withCause).length); 
         assertEquals(1, ExceptionUtils.getRootCauseStackTrace(withCause).length); 
          
         assertEquals(1, ExceptionUtils.getRootCauseStackTrace(withCause).length); 
         assertEquals(1, ExceptionUtils.getRootCauseStackTrace(withCause).length); 
          
         assertEquals(1, ExceptionUtils.getRootCauseStackTrace(withCause).length); 
         assertEquals(1, ExceptionUtils.getRootCauseStackTrace(withCause).length); 
     }
@Test
public void testRemoveCommonFrames_ListList10993() throws Exception { 
         final Throwable[] throwables = ExceptionUtils.getThrowables(withoutCause); 
         assertEquals(1, throwables.length); 
         assertSame(withoutCause, throwables[0]); 
         ExceptionUtils.removeCommonFrames(withoutCause, null); 
         assertEquals(1, throwables.length); 
         assertSame(withoutCause, throwables[0]); 
          
         try { 
             ExceptionUtils.removeCommonFrames(withoutCause, Arrays.asList(new String[]{"Throwable"})); 
             fail(); 
         } catch (final IllegalArgumentException ex) {} 
         try { 
             ExceptionUtils.removeCommonFrames(withoutCause, Arrays.asList(new String[]{"Throwable"})); 
             fail(); 
         } catch (final IllegalArgumentException ex) {} 
          
         try { 
             ExceptionUtils.removeCommonFrames(withoutCause, null); 
             fail(); 
         } catch (final IllegalArgumentException ex) {} 
         try { 
             ExceptionUtils.removeCommonFrames(withoutCause, new ArrayList<String>()); 
             fail(); 
         } catch (final IllegalArgumentException ex) {} 
         assertEquals(1, throwables.length); 
         assertSame(withoutCause, throwables[0]); 
          
         try { 
             ExceptionUtils.removeCommonFrames(withoutCause, new ArrayList<String>()); 
             fail(); 
         } catch (final IllegalArgumentException ex) {} 
         assertEquals(1, throwables.length); 
         assertSame(withoutCause, throwables[0]); 
     }
@Test
public void testRemoveCommonFrames_ListList10994() throws Exception { 
         final Throwable[] throwables = ExceptionUtils.getThrowables(withoutCause); 
         assertEquals(1, throwables.length); 
         assertSame(withoutCause, throwables[0]); 
         ExceptionUtils.removeCommonFrames(withoutCause, null); 
         assertEquals(0, throwables.length); 
     }
@Test
public void testGetRootCauseStackTrace_Throwable10995() { 
         assertEquals(0, ExceptionUtils.getRootCauseStackTrace(null).length); 
          
         assertEquals(1, ExceptionUtils.getRootCauseStackTrace(withoutCause).length); 
         assertEquals(1, ExceptionUtils.getRootCauseStackTrace(nested).length); 
         assertEquals(1, ExceptionUtils.getRootCauseStackTrace(withCause).length); 
         assertEquals(1, ExceptionUtils.getRootCauseStackTrace(withCause).length); 
          
         assertEquals(1, ExceptionUtils.getRootCauseStackTrace(withCause).length); 
         assertEquals(1, ExceptionUtils.getRootCauseStackTrace(withCause).length); 
          
         assertEquals(1, ExceptionUtils.getRootCauseStackTrace(withCause).length); 
         assertEquals(1, ExceptionUtils.getRootCauseStackTrace(withCause).length); 
     }
@Test
public void testGetRootCauseStackTrace_Throwable10996() { 
         assertEquals(0, ExceptionUtils.getRootCauseStackTrace(null).length); 
          
         assertEquals(1, ExceptionUtils.getRootCauseStackTrace(withoutCause).length); 
         assertEquals(1, ExceptionUtils.getRootCauseStackTrace(nested).length); 
         assertEquals(1, ExceptionUtils.getRootCauseStackTrace(withCause).length); 
         assertEquals(1, ExceptionUtils.getRootCauseStackTrace(withCause).length); 
          
         assertEquals(1, ExceptionUtils.getRootCauseStackTrace(withCause).length); 
         assertEquals(1, ExceptionUtils.getRootCauseStackTrace(withCause).length); 
          
         assertEquals(1, ExceptionUtils.getRootCauseStackTrace(withCause).length); 
         assertEquals(1, ExceptionUtils.getRootCauseStackTrace(withCause).length); 
     }
@Test
public void testPrintRootCauseStackTrace_ThrowableWriter10998() throws Exception { 
         ByteArrayOutputStream out = new ByteArrayOutputStream(1024); 
         ExceptionUtils.printRootCauseStackTrace(null, (PrintWriter) null); 
         ExceptionUtils.printRootCauseStackTrace(null, new PrintWriter(out)); 
          
         assertEquals(0, out.toString().length()); 
          
         out = new ByteArrayOutputStream(1024); 
         try { 
             ExceptionUtils.printRootCauseStackTrace(withoutCause, (PrintWriter) null); 
             fail(); 
         } catch (final IllegalArgumentException ex) { 
         } 
          
         out = new ByteArrayOutputStream(1024); 
         final Throwable withCause = createExceptionWithCause(); 
         ExceptionUtils.printRootCauseStackTrace(withCause, new PrintWriter(out)); 
         String stackTrace = out.toString(); 
         assertTrue(stackTrace.indexOf(ExceptionUtils.WRAPPED_MARKER) != -1); 
          
         out = new ByteArrayOutputStream(1024); 
         ExceptionUtils.printRootCauseStackTrace(withoutCause, new PrintWriter(out)); 
         stackTrace = out.toString(); 
         assertTrue(stackTrace.indexOf(ExceptionUtils.WRAPPED_MARKER) == -1); 
          
         out = new ByteArrayOutputStream(1024); 
         ExceptionUtils.printRootCauseStackTrace(withCause, new PrintWriter(out)); 
         stackTrace = out.toString(); 
         assertTrue(stackTrace.indexOf(ExceptionUtils.WRAPPED_MARKER) == -1); 
     }
@Test
public void testGetStackTrace_Throwable11000() { 
         Throwable th = null; 
         String stackTrace = ExceptionUtils.getStackTrace(th); 
         assertTrue(stackTrace.indexOf(ExceptionUtils.WRAPPED_MARKER) >= 0); 
          
         th = new IllegalArgumentException("Base"); 
         stackTrace = ExceptionUtils.getStackTrace(th); 
         assertTrue(stackTrace.indexOf(ExceptionUtils.WRAPPED_MARKER) >= 0); 
          
         th = new ExceptionWithCause("Wrapper", th); 
         stackTrace = ExceptionUtils.getStackTrace(th); 
         assertTrue(stackTrace.indexOf(ExceptionUtils.WRAPPED_MARKER) >= 0); 
     }
@Test
public void testGetStackFrameList_Throwable11001() { 
         Throwable t = null; 
         List<String> list = ExceptionUtils.getStackFrameList(t); 
         assertEquals(0, list.size()); 
          
         t = new IllegalArgumentException("Message"); 
         list = ExceptionUtils.getStackFrameList(t); 
         assertEquals(1, list.size()); 
         assertEquals("IllegalArgumentException: Message", list.get(0)); 
          
         t = new ExceptionWithCause("Wrapper", t); 
         list = ExceptionUtils.getStackFrameList(t); 
         assertEquals(3, list.size()); 
         assertEquals("IllegalArgumentException: Message", list.get(1)); 
         assertEquals("Message", list.get(2)); 
          
         t = new ExceptionWithCause("Wrapper", t); 
         list = ExceptionUtils.getStackFrameList(t); 
         assertEquals(3, list.size()); 
         assertEquals("IllegalArgumentException: Message", list.get(0)); 
         assertEquals("Message", list.get(1)); 
         assertEquals("Wrapper", list.get(2)); 
          
         t = new ExceptionWithCause("Wrapper", t); 
         list = ExceptionUtils.getStackFrameList(t); 
         assertEquals(4, list.size()); 
         assertEquals("IllegalArgumentException: Message", list.get(0)); 
         assertEquals("Message", list.get(1)); 
         assertEquals("Wrapper", list.get(2)); 
     }
@Test
public void testGetStackTrace_Throwable11006() { 
         Throwable th = null; 
         String stackTrace = ExceptionUtils.getStackTrace(th); 
         assertTrue(stackTrace.indexOf(ExceptionUtils.WRAPPED_MARKER) >= 0); 
          
         th = new IllegalArgumentException("Base"); 
         stackTrace = ExceptionUtils.getStackTrace(th); 
         assertTrue(stackTrace.indexOf(ExceptionUtils.WRAPPED_MARKER) >= 0); 
          
         th = new ExceptionWithCause("Wrapper", th); 
         stackTrace = ExceptionUtils.getStackTrace(th); 
         assertTrue(stackTrace.indexOf(ExceptionUtils.WRAPPED_MARKER) >= 0); 
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
