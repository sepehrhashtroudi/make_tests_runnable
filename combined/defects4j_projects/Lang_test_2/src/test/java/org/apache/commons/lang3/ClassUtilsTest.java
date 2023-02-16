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
package org.apache.commons.lang3;

import static org.apache.commons.lang3.JavaVersion.JAVA_1_5;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.Test;

/**
 * Unit tests {@link org.apache.commons.lang3.ClassUtils}.
 *
 * @version $Id$
 */
@SuppressWarnings("boxing") // JUnit4 does not support primitive equality testing apart from long
public class ClassUtilsTest  {

    private static class Inner {
        private class DeeplyNested{}
    }

    //-----------------------------------------------------------------------
@Test
public void testConstructor69() { 
     assertNotNull(new ClassUtils()); 
     final Constructor<?>[] cons = ClassUtils.class.getDeclaredConstructors(); 
     assertEquals(1, cons.length); 
     assertTrue(Modifier.isPublic(cons[0].getModifiers())); 
     assertTrue(Modifier.isPublic(ClassUtils.class.getModifiers())); 
     assertFalse(Modifier.isFinal(ClassUtils.class.getModifiers())); 
 }
@Test
public void test_getShortClassName_Class70() { 
     assertEquals("ClassUtils", ClassUtils.getShortClassName(ClassUtils.class)); 
     assertEquals("ClassUtils[]", ClassUtils.getShortClassName(ClassUtils[].class)); 
     assertEquals("ClassUtils[][]", ClassUtils.getShortClassName(ClassUtils[][].class)); 
     assertEquals("int[]", ClassUtils.getShortClassName(int[].class)); 
     assertEquals("int[][]", ClassUtils.getShortClassName(int[][].class)); 
     class Named extends Object { 
     } 
     assertEquals("ClassUtilsTest.7", ClassUtils.getShortClassName(new Object() { 
     }.getClass())); 
     assertEquals("ClassUtilsTest.6Named", ClassUtils.getShortClassName(Named.class)); 
     assertEquals("ClassUtilsTest.Inner", ClassUtils.getShortClassName(Inner.class)); 
 }
@Test
public void test_getShortCanonicalName_String71() { 
     assertEquals("ClassUtils", ClassUtils.getShortCanonicalName("org.apache.commons.lang3.ClassUtils")); 
     assertEquals("ClassUtils[]", ClassUtils.getShortCanonicalName("[Lorg.apache.commons.lang3.ClassUtils;")); 
     assertEquals("ClassUtils[][]", ClassUtils.getShortCanonicalName("[[Lorg.apache.commons.lang3.ClassUtils;")); 
     assertEquals("ClassUtils[]", ClassUtils.getShortCanonicalName("org.apache.commons.lang3.ClassUtils[]")); 
     assertEquals("ClassUtils[][]", ClassUtils.getShortCanonicalName("org.apache.commons.lang3.ClassUtils[][]")); 
     assertEquals("int[]", ClassUtils.getShortCanonicalName("[I")); 
     assertEquals("int[][]", ClassUtils.getShortCanonicalName("[[I")); 
     assertEquals("int[]", ClassUtils.getShortCanonicalName("int[]")); 
     assertEquals("int[][]", ClassUtils.getShortCanonicalName("int[][]")); 
     assertEquals("ClassUtilsTest.6", ClassUtils.getShortCanonicalName("org.apache.commons.lang3.ClassUtilsTest$6")); 
     assertEquals("ClassUtilsTest.5Named", ClassUtils.getShortCanonicalName("org.apache.commons.lang3.ClassUtilsTest$5Named")); 
     assertEquals("ClassUtilsTest.Inner", ClassUtils.getShortCanonicalName("org.apache.commons.lang3.ClassUtilsTest$Inner")); 
 }
@Test
public void test_getPackageName_String72() { 
     assertEquals("org.apache.commons.lang3", ClassUtils.getPackageName(ClassUtils.class.getName())); 
     assertEquals("java.util", ClassUtils.getPackageName(Map.Entry.class.getName())); 
     assertEquals("", ClassUtils.getPackageName((String) null)); 
     assertEquals("", ClassUtils.getPackageName("")); 
 }
@Test
public void test_isAssignable76() throws Exception { 
     assertFalse(ClassUtils.isAssignable((Class<?>[]) null, null)); 
     assertFalse(ClassUtils.isAssignable(String.class, null)); 
     assertTrue(ClassUtils.isAssignable(null, Object.class)); 
     assertTrue(ClassUtils.isAssignable(null, Integer.class)); 
     assertFalse(ClassUtils.isAssignable(null, Integer.TYPE)); 
     assertTrue(ClassUtils.isAssignable(String.class, Object.class)); 
     assertTrue(ClassUtils.isAssignable(String.class, String.class)); 
     assertFalse(ClassUtils.isAssignable(Object.class, String.class)); 
     final boolean autoboxing = SystemUtils.isJavaVersionAtLeast(JAVA_1_5); 
     assertEquals(autoboxing, ClassUtils.isAssignable(Integer.TYPE, Integer.class)); 
     assertEquals(autoboxing, ClassUtils.isAssignable(Integer.TYPE, Object.class)); 
     assertEquals(autoboxing, ClassUtils.isAssignable(Integer.class, Integer.TYPE)); 
     assertEquals(autoboxing, ClassUtils.isAssignable(Integer.class, Object.class)); 
     assertTrue(ClassUtils.isAssignable(Integer.TYPE, Integer.TYPE)); 
     assertTrue(ClassUtils.isAssignable(Integer.class, Integer.class)); 
     assertEquals(autoboxing, ClassUtils.isAssignable(Boolean.TYPE, Boolean.class)); 
     assertEquals(autoboxing, ClassUtils.isAssignable(Boolean.TYPE, Object.class)); 
     assertEquals(autoboxing, ClassUtils.isAssignable(Boolean.class, Boolean.TYPE)); 
     assertEquals(autoboxing, ClassUtils.isAssignable(Boolean.class, Object.class)); 
     assertTrue(ClassUtils.isAssignable(Boolean.TYPE, Boolean.TYPE)); 
     assertTrue(ClassUtils.isAssignable(Boolean.class, Boolean.class)); 
 }
@Test
public void testIsAssignable77() throws Exception { 
     assertFalse(ClassUtils.isAssignable((Class<?>[]) null, null)); 
     assertFalse(ClassUtils.isAssignable(String.class, null)); 
     assertTrue(ClassUtils.isAssignable(null, Object.class)); 
     assertTrue(ClassUtils.isAssignable(null, Integer.class)); 
     assertFalse(ClassUtils.isAssignable(null, Integer.TYPE)); 
     assertTrue(ClassUtils.isAssignable(String.class, Object.class)); 
     assertTrue(ClassUtils.isAssignable(String.class, String.class)); 
     assertFalse(ClassUtils.isAssignable(Object.class, String.class)); 
     final boolean autoboxing = SystemUtils.isJavaVersionAtLeast(JAVA_1_5); 
     assertEquals(autoboxing, ClassUtils.isAssignable(Integer.TYPE, Integer.class)); 
     assertEquals(autoboxing, ClassUtils.isAssignable(Integer.TYPE, Object.class)); 
     assertEquals(autoboxing, ClassUtils.isAssignable(Integer.class, Integer.TYPE)); 
     assertEquals(autoboxing, ClassUtils.isAssignable(Integer.class, Object.class)); 
     assertTrue(ClassUtils.isAssignable(Integer.TYPE, Integer.TYPE)); 
     assertTrue(ClassUtils.isAssignable(Integer.class, Integer.class)); 
     assertEquals(autoboxing, ClassUtils.isAssignable(Boolean.TYPE, Boolean.class)); 
     assertEquals(autoboxing, ClassUtils.isAssignable(Boolean.TYPE, Object.class)); 
     assertEquals(autoboxing, ClassUtils.isAssignable(Boolean.class, Boolean.TYPE)); 
     assertEquals(autoboxing, ClassUtils.isAssignable(Boolean.class, Object.class)); 
     assertTrue(ClassUtils.isAssignable(Boolean.TYPE, Boolean.TYPE)); 
     assertTrue(ClassUtils.isAssignable(Boolean.class, Boolean.class)); 
 }
@Test
public void test_isAssignable78() throws Exception { 
     assertFalse(ClassUtils.isAssignable((Class<?>) null, null)); 
     assertFalse(ClassUtils.isAssignable(String.class, null)); 
     assertTrue(ClassUtils.isAssignable(null, Object.class)); 
     assertTrue(ClassUtils.isAssignable(null, Integer.class)); 
     assertFalse(ClassUtils.isAssignable(null, Integer.TYPE)); 
     assertTrue(ClassUtils.isAssignable(String.class, Object.class)); 
     assertTrue(ClassUtils.isAssignable(String.class, String.class)); 
     assertFalse(ClassUtils.isAssignable(Object.class, String.class)); 
     final boolean autoboxing = SystemUtils.isJavaVersionAtLeast(JAVA_1_5); 
     assertEquals(autoboxing, ClassUtils.isAssignable(Integer.TYPE, Integer.class)); 
     assertEquals(autoboxing, ClassUtils.isAssignable(Integer.TYPE, Object.class)); 
     assertEquals(autoboxing, ClassUtils.isAssignable(Integer.class, Integer.TYPE)); 
     assertEquals(autoboxing, ClassUtils.isAssignable(Integer.class, Object.class)); 
     assertTrue(ClassUtils.isAssignable(Integer.TYPE, Integer.TYPE)); 
     assertTrue(ClassUtils.isAssignable(Integer.class, Integer.class)); 
     assertEquals(autoboxing, ClassUtils.isAssignable(Boolean.TYPE, Boolean.class)); 
     assertEquals(autoboxing, ClassUtils.isAssignable(Boolean.TYPE, Object.class)); 
     assertEquals(autoboxing, ClassUtils.isAssignable(Boolean.class, Boolean.TYPE)); 
     assertEquals(autoboxing, ClassUtils.isAssignable(Boolean.class, Object.class)); 
     assertTrue(ClassUtils.isAssignable(Boolean.TYPE, Boolean.TYPE)); 
     assertTrue(ClassUtils.isAssignable(Boolean.class, Boolean.class)); 
 }
@Test
public void testGetClassClassNotFound79() throws Exception { 
     assertGetClassThrowsClassNotFound("bool"); 
     assertGetClassThrowsClassNotFound("bool[]"); 
     assertGetClassThrowsClassNotFound("integer[]"); 
 }
@Test
public void test_getClass_String80() throws Exception { 
     assertEquals("ClassUtils", ClassUtils.getClass("org.apache.commons.lang3.ClassUtils")); 
     assertEquals("ClassUtils[]", ClassUtils.getClass("[Lorg.apache.commons.lang3.ClassUtils;")); 
     assertEquals("ClassUtils[][]", ClassUtils.getClass("[[Lorg.apache.commons.lang3.ClassUtils;")); 
     assertEquals("ClassUtils[]", ClassUtils.getClass("org.apache.commons.lang3.ClassUtils[]")); 
     assertEquals("ClassUtils[][]", ClassUtils.getClass("org.apache.commons.lang3.ClassUtils[][]")); 
     assertEquals("int[]", ClassUtils.getClass("[I")); 
     assertEquals("int[][]", ClassUtils.getClass("[[I")); 
     assertEquals("int[]", ClassUtils.getClass("int[]")); 
     assertEquals("int[][]", ClassUtils.getClass("int[][]")); 
     assertEquals("ClassUtilsTest.6", ClassUtils.getClass("org.apache.commons.lang3.ClassUtilsTest$6")); 
     assertEquals("ClassUtilsTest.5Named", ClassUtils.getClass("org.apache.commons.lang3.ClassUtilsTest$5Named")); 
     assertEquals("ClassUtilsTest.Inner", ClassUtils.getClass("org.apache.commons.lang3.ClassUtilsTest$Inner")); 
 }
@Test
public void test_getPackageCanonicalName_Object81() { 
     assertEquals("org.apache.commons.lang3", ClassUtils.getPackageCanonicalName(new ClassUtils(), "<null>")); 
     assertEquals("org.apache.commons.lang3", ClassUtils.getPackageCanonicalName(new Inner(), "<null>")); 
     assertEquals("<null>", ClassUtils.getPackageCanonicalName(null, "<null>")); 
 }
    

    // -------------------------------------------------------------------------
    

    



    

    

    

    // -------------------------------------------------------------------------
    

    

    

    // -------------------------------------------------------------------------
    

    

    private static interface IA {
    }
    private static interface IB {
    }
    private static interface IC extends ID, IE {
    }
    private static interface ID {
    }
    private static interface IE extends IF {
    }
    private static interface IF {
    }
    private static class CX implements IB, IA, IE {
    }
    private static class CY extends CX implements IB, IC {
    }

    // -------------------------------------------------------------------------
    

    

    // -------------------------------------------------------------------------
    

    // -------------------------------------------------------------------------
    

    

    

    

    

    

    

    

    

    
    
    
    
    

    

    

    

    

    

    

    

    

    

    

    

    

    

    

    

    

    private void assertGetClassReturnsClass( final Class<?> c ) throws Exception {
        assertEquals( c, ClassUtils.getClass( c.getName() ) );
    }

    private void assertGetClassThrowsException( final String className, final Class<?> exceptionType ) throws Exception {
        try {
            ClassUtils.getClass( className );
            fail( "ClassUtils.getClass() should fail with an exception of type " + exceptionType.getName() + " when given class name \"" + className + "\"." );
        }
        catch( final Exception e ) {
            assertTrue( exceptionType.isAssignableFrom( e.getClass() ) );
        }
    }

    private void assertGetClassThrowsNullPointerException( final String className ) throws Exception {
        assertGetClassThrowsException( className, NullPointerException.class );
    }

    private void assertGetClassThrowsClassNotFound( final String className ) throws Exception {
        assertGetClassThrowsException( className, ClassNotFoundException.class );
    }

    // Show the Java bug: http://bugs.sun.com/bugdatabase/view_bug.do?bug_id=4071957
    // We may have to delete this if a JDK fixes the bug.
    

    

    

    

    

    

    

    

    

}
