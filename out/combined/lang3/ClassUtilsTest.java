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
public void testGetClassInvalidArguments31() throws Exception { 
     assertGetClassThrowsNullPointerException(null); 
     assertGetClassThrowsClassNotFound("[][][]"); 
     assertGetClassThrowsClassNotFound("[[]"); 
     assertGetClassThrowsClassNotFound("["); 
     assertGetClassThrowsClassNotFound("java.lang.String]["); 
     assertGetClassThrowsClassNotFound(".hello.world"); 
     assertGetClassThrowsClassNotFound("hello..world"); 
 }
@Test
public void test_getPackageName_Object38() { 
     assertEquals("org.apache.commons.lang3", ClassUtils.getPackageName(new ClassUtils(), "<null>")); 
     assertEquals("org.apache.commons.lang3", ClassUtils.getPackageName(new Inner(), "<null>")); 
     assertEquals("<null>", ClassUtils.getPackageName(null, "<null>")); 
 }
@Test
public void test_getPackageName_Class43() { 
     assertEquals("java.lang", ClassUtils.getPackageName(String.class)); 
     assertEquals("java.util", ClassUtils.getPackageName(Map.Entry.class)); 
     assertEquals("", ClassUtils.getPackageName((Class<?>) null)); 
     assertEquals("java.lang", ClassUtils.getPackageName(String[].class)); 
     assertEquals("", ClassUtils.getPackageName(boolean[].class)); 
     assertEquals("", ClassUtils.getPackageName(byte[].class)); 
     assertEquals("", ClassUtils.getPackageName(char[].class)); 
     assertEquals("", ClassUtils.getPackageName(short[].class)); 
     assertEquals("", ClassUtils.getPackageName(int[].class)); 
     assertEquals("", ClassUtils.getPackageName(long[].class)); 
     assertEquals("", ClassUtils.getPackageName(float[].class)); 
     assertEquals("", ClassUtils.getPackageName(double[].class)); 
     assertEquals("java.lang", ClassUtils.getPackageName(String[][].class)); 
     assertEquals("java.lang", ClassUtils.getPackageName(String[][][].class)); 
     assertEquals("java.lang", ClassUtils.getPackageName(String[][][][].class)); 
     class Named extends Object { 
     } 
     assertEquals("org.apache.commons.lang3", ClassUtils.getPackageName(new Object() { 
     }.getClass())); 
     assertEquals("org.apache.commons.lang3", ClassUtils.getPackageName(Named.class)); 
 }
@Test
public void test_getPackageName_Class46() { 
     assertEquals("java.lang", ClassUtils.getPackageName(String.class)); 
     assertEquals("java.util", ClassUtils.getPackageName(Map.Entry.class)); 
     assertEquals("", ClassUtils.getPackageName((Class<?>) null)); 
     assertEquals("java.lang", ClassUtils.getPackageName(String[].class)); 
     assertEquals("", ClassUtils.getPackageName(boolean[].class)); 
     assertEquals("", ClassUtils.getPackageName(byte[].class)); 
     assertEquals("", ClassUtils.getPackageName(char[].class)); 
     assertEquals("", ClassUtils.getPackageName(short[].class)); 
     assertEquals("", ClassUtils.getPackageName(int[].class)); 
     assertEquals("", ClassUtils.getPackageName(long[].class)); 
     assertEquals("", ClassUtils.getPackageName(float[].class)); 
     assertEquals("", ClassUtils.getPackageName(double[].class)); 
     assertEquals("java.lang", ClassUtils.getPackageName(String[][].class)); 
     assertEquals("java.lang", ClassUtils.getPackageName(String[][][].class)); 
     assertEquals("java.lang", ClassUtils.getPackageName(String[][][][].class)); 
     class Named extends Object { 
     } 
     assertEquals("org.apache.commons.lang3", ClassUtils.getPackageName(new Object() { 
     }.getClass())); 
     assertEquals("org.apache.commons.lang3", ClassUtils.getPackageName(Named.class)); 
 }
@Test
public void test_getShortClassName_Object51() { 
     assertEquals("ClassUtils", ClassUtils.getShortClassName(new ClassUtils(), "<null>")); 
     assertEquals("ClassUtilsTest.Inner", ClassUtils.getShortClassName(new Inner(), "<null>")); 
     assertEquals("String", ClassUtils.getShortClassName("hello", "<null>")); 
     assertEquals("<null>", ClassUtils.getShortClassName(null, "<null>")); 
     class Named extends Object { 
     } 
     assertEquals("ClassUtilsTest.1", ClassUtils.getShortClassName(new Object() { 
     }, "<null>")); 
     assertEquals("ClassUtilsTest.1Named", ClassUtils.getShortClassName(new Named(), "<null>")); 
     assertEquals("ClassUtilsTest.Inner", ClassUtils.getShortClassName(new Inner(), "<null>")); 
 }
@Test
public void test_getPackageName_Class73() { 
     assertEquals("java.lang", ClassUtils.getPackageName(String.class)); 
     assertEquals("java.util", ClassUtils.getPackageName(Map.Entry.class)); 
     assertEquals("", ClassUtils.getPackageName((Class<?>) null)); 
     assertEquals("java.lang", ClassUtils.getPackageName(String[].class)); 
     assertEquals("", ClassUtils.getPackageName(boolean[].class)); 
     assertEquals("", ClassUtils.getPackageName(byte[].class)); 
     assertEquals("", ClassUtils.getPackageName(char[].class)); 
     assertEquals("", ClassUtils.getPackageName(short[].class)); 
     assertEquals("", ClassUtils.getPackageName(int[].class)); 
     assertEquals("", ClassUtils.getPackageName(long[].class)); 
     assertEquals("", ClassUtils.getPackageName(float[].class)); 
     assertEquals("", ClassUtils.getPackageName(double[].class)); 
     assertEquals("java.lang", ClassUtils.getPackageName(String[][].class)); 
     assertEquals("java.lang", ClassUtils.getPackageName(String[][][].class)); 
     assertEquals("java.lang", ClassUtils.getPackageName(String[][][][].class)); 
     class Named extends Object { 
     } 
     assertEquals("org.apache.commons.lang3", ClassUtils.getPackageName(new Object() { 
     }.getClass())); 
     assertEquals("org.apache.commons.lang3", ClassUtils.getPackageName(Named.class)); 
 }
@Test
public void test_getShortCanonicalName_String77() { 
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
public void test_getShortClassName_Class134() { 
     assertEquals("ClassUtils", ClassUtils.getShortClassName(ClassUtils.class)); 
     assertEquals("Map.Entry", ClassUtils.getShortClassName(Map.Entry.class)); 
     assertEquals("", ClassUtils.getShortClassName((Class<?>) null)); 
     assertEquals("String[]", ClassUtils.getShortClassName(String[].class)); 
     assertEquals("Map.Entry[]", ClassUtils.getShortClassName(Map.Entry[].class)); 
     assertEquals("boolean", ClassUtils.getShortClassName(boolean.class)); 
     assertEquals("byte", ClassUtils.getShortClassName(byte.class)); 
     assertEquals("char", ClassUtils.getShortClassName(char.class)); 
     assertEquals("short", ClassUtils.getShortClassName(short.class)); 
     assertEquals("int", ClassUtils.getShortClassName(int.class)); 
     assertEquals("long", ClassUtils.getShortClassName(long.class)); 
     assertEquals("float", ClassUtils.getShortClassName(float.class)); 
     assertEquals("double", ClassUtils.getShortClassName(double.class)); 
     assertEquals("boolean[]", ClassUtils.getShortClassName(boolean[].class)); 
     assertEquals("byte[]", ClassUtils.getShortClassName(byte[].class)); 
     assertEquals("char[]", ClassUtils.getShortClassName(char[].class)); 
     assertEquals("short[]", ClassUtils.getShortClassName(short[].class)); 
     assertEquals("int[]", ClassUtils.getShortClassName(int[].class)); 
     assertEquals("long[]", ClassUtils.getShortClassName(long[].class)); 
     assertEquals("float[]", ClassUtils.getShortClassName(float[].class)); 
     assertEquals("double[]", ClassUtils.getShortClassName(double[].class)); 
     assertEquals("String[][]", ClassUtils.getShortClassName(String[][].class)); 
     assertEquals("String[][][]", ClassUtils.getShortClassName(String[][][].class)); 
     assertEquals("String[][][][]", ClassUtils.getShortClassName(String[][][][].class)); 
     class Named extends Object { 
     } 
     assertEquals("ClassUtilsTest.2", ClassUtils.getShortClassName(new Object() { 
     }.getClass())); 
     assertEquals("ClassUtilsTest.2Named", ClassUtils.getShortClassName(Named.class)); 
     assertEquals("ClassUtilsTest.Inner", ClassUtils.getShortClassName(Inner.class)); 
 }
@Test
public void testGetPublicMethod174() throws Exception { 
     final Set<?> set = Collections.unmodifiableSet(new HashSet<Object>()); 
     final Method isEmptyMethod = ClassUtils.getPublicMethod(set.getClass(), "isEmpty", new Class[0]); 
     assertTrue(Modifier.isPublic(isEmptyMethod.getDeclaringClass().getModifiers())); 
     try { 
         isEmptyMethod.invoke(set, new Object[0]); 
     } catch (final java.lang.IllegalAccessException iae) { 
         fail("Should not have thrown IllegalAccessException"); 
     } 
     final Method toStringMethod = ClassUtils.getPublicMethod(Object.class, "toString", new Class[0]); 
     assertEquals(Object.class.getMethod("toString", new Class[0]), toStringMethod); 
 }
@Test
public void test_getShortClassName_Class188() { 
     assertEquals("ClassUtils", ClassUtils.getShortClassName(ClassUtils.class)); 
     assertEquals("Map.Entry", ClassUtils.getShortClassName(Map.Entry.class)); 
     assertEquals("", ClassUtils.getShortClassName((Class<?>) null)); 
     assertEquals("String[]", ClassUtils.getShortClassName(String[].class)); 
     assertEquals("Map.Entry[]", ClassUtils.getShortClassName(Map.Entry[].class)); 
     assertEquals("boolean", ClassUtils.getShortClassName(boolean.class)); 
     assertEquals("byte", ClassUtils.getShortClassName(byte.class)); 
     assertEquals("char", ClassUtils.getShortClassName(char.class)); 
     assertEquals("short", ClassUtils.getShortClassName(short.class)); 
     assertEquals("int", ClassUtils.getShortClassName(int.class)); 
     assertEquals("long", ClassUtils.getShortClassName(long.class)); 
     assertEquals("float", ClassUtils.getShortClassName(float.class)); 
     assertEquals("double", ClassUtils.getShortClassName(double.class)); 
     assertEquals("boolean[]", ClassUtils.getShortClassName(boolean[].class)); 
     assertEquals("byte[]", ClassUtils.getShortClassName(byte[].class)); 
     assertEquals("char[]", ClassUtils.getShortClassName(char[].class)); 
     assertEquals("short[]", ClassUtils.getShortClassName(short[].class)); 
     assertEquals("int[]", ClassUtils.getShortClassName(int[].class)); 
     assertEquals("long[]", ClassUtils.getShortClassName(long[].class)); 
     assertEquals("float[]", ClassUtils.getShortClassName(float[].class)); 
     assertEquals("double[]", ClassUtils.getShortClassName(double[].class)); 
     assertEquals("String[][]", ClassUtils.getShortClassName(String[][].class)); 
     assertEquals("String[][][]", ClassUtils.getShortClassName(String[][][].class)); 
     assertEquals("String[][][][]", ClassUtils.getShortClassName(String[][][][].class)); 
     class Named extends Object { 
     } 
     assertEquals("ClassUtilsTest.2", ClassUtils.getShortClassName(new Object() { 
     }.getClass())); 
     assertEquals("ClassUtilsTest.2Named", ClassUtils.getShortClassName(Named.class)); 
     assertEquals("ClassUtilsTest.Inner", ClassUtils.getShortClassName(Inner.class)); 
 }
@Test
public void test_getShortCanonicalName_String237() { 
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
public void test_getShortClassName_Object259() { 
     assertEquals("ClassUtils", ClassUtils.getShortClassName(new ClassUtils(), "<null>")); 
     assertEquals("ClassUtilsTest.Inner", ClassUtils.getShortClassName(new Inner(), "<null>")); 
     assertEquals("String", ClassUtils.getShortClassName("hello", "<null>")); 
     assertEquals("<null>", ClassUtils.getShortClassName(null, "<null>")); 
     class Named extends Object { 
     } 
     assertEquals("ClassUtilsTest.1", ClassUtils.getShortClassName(new Object() { 
     }, "<null>")); 
     assertEquals("ClassUtilsTest.1Named", ClassUtils.getShortClassName(new Named(), "<null>")); 
     assertEquals("ClassUtilsTest.Inner", ClassUtils.getShortClassName(new Inner(), "<null>")); 
 }
@Test
public void test_getShortCanonicalName_String298() { 
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
public void testWrappersToPrimitivesNull303() { 
     assertNull("Wrong result for null input", ClassUtils.wrappersToPrimitives((Class<?>[]) null)); 
     assertTrue("empty -> empty", Arrays.equals(ArrayUtils.EMPTY_CLASS_ARRAY, ClassUtils.wrappersToPrimitives())); 
     final Class<?>[] castNull = ClassUtils.wrappersToPrimitives((Class<?>) null); 
     assertTrue("(Class<?>)null -> [null]", Arrays.equals(new Class<?>[] { null }, castNull)); 
 }
@Test
public void testGetClassByNormalNameArrays2D327() throws ClassNotFoundException { 
     assertEquals(int[][].class, ClassUtils.getClass("int[][]")); 
     assertEquals(long[][].class, ClassUtils.getClass("long[][]")); 
     assertEquals(short[][].class, ClassUtils.getClass("short[][]")); 
     assertEquals(byte[][].class, ClassUtils.getClass("byte[][]")); 
     assertEquals(char[][].class, ClassUtils.getClass("char[][]")); 
     assertEquals(float[][].class, ClassUtils.getClass("float[][]")); 
     assertEquals(double[][].class, ClassUtils.getClass("double[][]")); 
     assertEquals(boolean[][].class, ClassUtils.getClass("boolean[][]")); 
     assertEquals(String[][].class, ClassUtils.getClass("java.lang.String[][]")); 
 }
@Test
public void testGetPublicMethod331() throws Exception { 
     final Set<?> set = Collections.unmodifiableSet(new HashSet<Object>()); 
     final Method isEmptyMethod = ClassUtils.getPublicMethod(set.getClass(), "isEmpty", new Class[0]); 
     assertTrue(Modifier.isPublic(isEmptyMethod.getDeclaringClass().getModifiers())); 
     try { 
         isEmptyMethod.invoke(set, new Object[0]); 
     } catch (final java.lang.IllegalAccessException iae) { 
         fail("Should not have thrown IllegalAccessException"); 
     } 
     final Method toStringMethod = ClassUtils.getPublicMethod(Object.class, "toString", new Class[0]); 
     assertEquals(Object.class.getMethod("toString", new Class[0]), toStringMethod); 
 }
@Test
public void test_convertClassesToClassNames_List346() { 
     final List<Class<?>> list = new ArrayList<Class<?>>(); 
     List<String> result = ClassUtils.convertClassesToClassNames(list); 
     assertEquals(0, result.size()); 
     list.add(String.class); 
     list.add(null); 
     list.add(Object.class); 
     result = ClassUtils.convertClassesToClassNames(list); 
     assertEquals(3, result.size()); 
     assertEquals("java.lang.String", result.get(0)); 
     assertEquals(null, result.get(1)); 
     assertEquals("java.lang.Object", result.get(2)); 
     @SuppressWarnings("unchecked") 
     final List<Object> olist = (List<Object>) (List<?>) list; 
     olist.add(new Object()); 
     try { 
         ClassUtils.convertClassesToClassNames(list); 
         fail("Should not have been able to convert list"); 
     } catch (final ClassCastException expected) { 
     } 
     assertEquals(null, ClassUtils.convertClassesToClassNames(null)); 
 }
@Test
public void test_isAssignable_NoAutoboxing439() throws Exception { 
     assertFalse(ClassUtils.isAssignable((Class<?>) null, null, false)); 
     assertFalse(ClassUtils.isAssignable(String.class, null, false)); 
     assertTrue(ClassUtils.isAssignable(null, Object.class, false)); 
     assertTrue(ClassUtils.isAssignable(null, Integer.class, false)); 
     assertFalse(ClassUtils.isAssignable(null, Integer.TYPE, false)); 
     assertTrue(ClassUtils.isAssignable(String.class, Object.class, false)); 
     assertTrue(ClassUtils.isAssignable(String.class, String.class, false)); 
     assertFalse(ClassUtils.isAssignable(Object.class, String.class, false)); 
     assertFalse(ClassUtils.isAssignable(Integer.TYPE, Integer.class, false)); 
     assertFalse(ClassUtils.isAssignable(Integer.TYPE, Object.class, false)); 
     assertFalse(ClassUtils.isAssignable(Integer.class, Integer.TYPE, false)); 
     assertTrue(ClassUtils.isAssignable(Integer.TYPE, Integer.TYPE, false)); 
     assertTrue(ClassUtils.isAssignable(Integer.class, Integer.class, false)); 
     assertFalse(ClassUtils.isAssignable(Boolean.TYPE, Boolean.class, false)); 
     assertFalse(ClassUtils.isAssignable(Boolean.TYPE, Object.class, false)); 
     assertFalse(ClassUtils.isAssignable(Boolean.class, Boolean.TYPE, false)); 
     assertTrue(ClassUtils.isAssignable(Boolean.class, Object.class, false)); 
     assertTrue(ClassUtils.isAssignable(Boolean.TYPE, Boolean.TYPE, false)); 
     assertTrue(ClassUtils.isAssignable(Boolean.class, Boolean.class, false)); 
 }
@Test
public void testGetPublicMethod454() throws Exception { 
     final Set<?> set = Collections.unmodifiableSet(new HashSet<Object>()); 
     final Method isEmptyMethod = ClassUtils.getPublicMethod(set.getClass(), "isEmpty", new Class[0]); 
     assertTrue(Modifier.isPublic(isEmptyMethod.getDeclaringClass().getModifiers())); 
     try { 
         isEmptyMethod.invoke(set, new Object[0]); 
     } catch (final java.lang.IllegalAccessException iae) { 
         fail("Should not have thrown IllegalAccessException"); 
     } 
     final Method toStringMethod = ClassUtils.getPublicMethod(Object.class, "toString", new Class[0]); 
     assertEquals(Object.class.getMethod("toString", new Class[0]), toStringMethod); 
 }
@Test
public void testGetPublicMethod586() throws Exception { 
     final Set<?> set = Collections.unmodifiableSet(new HashSet<Object>()); 
     final Method isEmptyMethod = ClassUtils.getPublicMethod(set.getClass(), "isEmpty", new Class[0]); 
     assertTrue(Modifier.isPublic(isEmptyMethod.getDeclaringClass().getModifiers())); 
     try { 
         isEmptyMethod.invoke(set, new Object[0]); 
     } catch (final java.lang.IllegalAccessException iae) { 
         fail("Should not have thrown IllegalAccessException"); 
     } 
     final Method toStringMethod = ClassUtils.getPublicMethod(Object.class, "toString", new Class[0]); 
     assertEquals(Object.class.getMethod("toString", new Class[0]), toStringMethod); 
 }
@Test
public void test_getSimpleName_Object637() { 
     assertEquals("ClassUtils", ClassUtils.getSimpleName(new ClassUtils(), "<null>")); 
     assertEquals("Inner", ClassUtils.getSimpleName(new Inner(), "<null>")); 
     assertEquals("String", ClassUtils.getSimpleName("hello", "<null>")); 
     assertEquals("<null>", ClassUtils.getSimpleName(null, "<null>")); 
 }
@Test
public void test_getPackageCanonicalName_Object668() { 
     assertEquals("<null>", ClassUtils.getPackageCanonicalName(null, "<null>")); 
     assertEquals("org.apache.commons.lang3", ClassUtils.getPackageCanonicalName(new ClassUtils(), "<null>")); 
     assertEquals("org.apache.commons.lang3", ClassUtils.getPackageCanonicalName(new ClassUtils[0], "<null>")); 
     assertEquals("org.apache.commons.lang3", ClassUtils.getPackageCanonicalName(new ClassUtils[0][0], "<null>")); 
     assertEquals("", ClassUtils.getPackageCanonicalName(new int[0], "<null>")); 
     assertEquals("", ClassUtils.getPackageCanonicalName(new int[0][0], "<null>")); 
     class Named extends Object { 
     } 
     assertEquals("org.apache.commons.lang3", ClassUtils.getPackageCanonicalName(new Object() { 
     }, "<null>")); 
     assertEquals("org.apache.commons.lang3", ClassUtils.getPackageCanonicalName(new Named(), "<null>")); 
     assertEquals("org.apache.commons.lang3", ClassUtils.getPackageCanonicalName(new Inner(), "<null>")); 
 }
@Test
public void test_getPackageCanonicalName_Class717() { 
     assertEquals("org.apache.commons.lang3", ClassUtils.getPackageCanonicalName(ClassUtils.class)); 
     assertEquals("org.apache.commons.lang3", ClassUtils.getPackageCanonicalName(ClassUtils[].class)); 
     assertEquals("org.apache.commons.lang3", ClassUtils.getPackageCanonicalName(ClassUtils[][].class)); 
     assertEquals("", ClassUtils.getPackageCanonicalName(int[].class)); 
     assertEquals("", ClassUtils.getPackageCanonicalName(int[][].class)); 
     class Named extends Object { 
     } 
     assertEquals("org.apache.commons.lang3", ClassUtils.getPackageCanonicalName(new Object() { 
     }.getClass())); 
     assertEquals("org.apache.commons.lang3", ClassUtils.getPackageCanonicalName(Named.class)); 
     assertEquals("org.apache.commons.lang3", ClassUtils.getPackageCanonicalName(Inner.class)); 
 }
@Test
public void test_getShortClassName_Class798() { 
     assertEquals("ClassUtils", ClassUtils.getShortClassName(ClassUtils.class)); 
     assertEquals("Map.Entry", ClassUtils.getShortClassName(Map.Entry.class)); 
     assertEquals("", ClassUtils.getShortClassName((Class<?>) null)); 
     assertEquals("String[]", ClassUtils.getShortClassName(String[].class)); 
     assertEquals("Map.Entry[]", ClassUtils.getShortClassName(Map.Entry[].class)); 
     assertEquals("boolean", ClassUtils.getShortClassName(boolean.class)); 
     assertEquals("byte", ClassUtils.getShortClassName(byte.class)); 
     assertEquals("char", ClassUtils.getShortClassName(char.class)); 
     assertEquals("short", ClassUtils.getShortClassName(short.class)); 
     assertEquals("int", ClassUtils.getShortClassName(int.class)); 
     assertEquals("long", ClassUtils.getShortClassName(long.class)); 
     assertEquals("float", ClassUtils.getShortClassName(float.class)); 
     assertEquals("double", ClassUtils.getShortClassName(double.class)); 
     assertEquals("boolean[]", ClassUtils.getShortClassName(boolean[].class)); 
     assertEquals("byte[]", ClassUtils.getShortClassName(byte[].class)); 
     assertEquals("char[]", ClassUtils.getShortClassName(char[].class)); 
     assertEquals("short[]", ClassUtils.getShortClassName(short[].class)); 
     assertEquals("int[]", ClassUtils.getShortClassName(int[].class)); 
     assertEquals("long[]", ClassUtils.getShortClassName(long[].class)); 
     assertEquals("float[]", ClassUtils.getShortClassName(float[].class)); 
     assertEquals("double[]", ClassUtils.getShortClassName(double[].class)); 
     assertEquals("String[][]", ClassUtils.getShortClassName(String[][].class)); 
     assertEquals("String[][][]", ClassUtils.getShortClassName(String[][][].class)); 
     assertEquals("String[][][][]", ClassUtils.getShortClassName(String[][][][].class)); 
     class Named extends Object { 
     } 
     assertEquals("ClassUtilsTest.2", ClassUtils.getShortClassName(new Object() { 
     }.getClass())); 
     assertEquals("ClassUtilsTest.2Named", ClassUtils.getShortClassName(Named.class)); 
     assertEquals("ClassUtilsTest.Inner", ClassUtils.getShortClassName(Inner.class)); 
 }
@Test
public void testIsPrimitiveOrWrapper813() { 
     assertTrue("Boolean.class", ClassUtils.isPrimitiveOrWrapper(Boolean.class)); 
     assertTrue("Byte.class", ClassUtils.isPrimitiveOrWrapper(Byte.class)); 
     assertTrue("Character.class", ClassUtils.isPrimitiveOrWrapper(Character.class)); 
     assertTrue("Short.class", ClassUtils.isPrimitiveOrWrapper(Short.class)); 
     assertTrue("Integer.class", ClassUtils.isPrimitiveOrWrapper(Integer.class)); 
     assertTrue("Long.class", ClassUtils.isPrimitiveOrWrapper(Long.class)); 
     assertTrue("Double.class", ClassUtils.isPrimitiveOrWrapper(Double.class)); 
     assertTrue("Float.class", ClassUtils.isPrimitiveOrWrapper(Float.class)); 
     assertTrue("boolean", ClassUtils.isPrimitiveOrWrapper(Boolean.TYPE)); 
     assertTrue("byte", ClassUtils.isPrimitiveOrWrapper(Byte.TYPE)); 
     assertTrue("char", ClassUtils.isPrimitiveOrWrapper(Character.TYPE)); 
     assertTrue("short", ClassUtils.isPrimitiveOrWrapper(Short.TYPE)); 
     assertTrue("int", ClassUtils.isPrimitiveOrWrapper(Integer.TYPE)); 
     assertTrue("long", ClassUtils.isPrimitiveOrWrapper(Long.TYPE)); 
     assertTrue("double", ClassUtils.isPrimitiveOrWrapper(Double.TYPE)); 
     assertTrue("float", ClassUtils.isPrimitiveOrWrapper(Float.TYPE)); 
     assertTrue("Void.TYPE", ClassUtils.isPrimitiveOrWrapper(Void.TYPE)); 
     assertFalse("null", ClassUtils.isPrimitiveOrWrapper(null)); 
     assertFalse("Void.class", ClassUtils.isPrimitiveOrWrapper(Void.class)); 
     assertFalse("String.class", ClassUtils.isPrimitiveOrWrapper(String.class)); 
     assertFalse("this.getClass()", ClassUtils.isPrimitiveOrWrapper(this.getClass())); 
 }
@Test
public void testGetClassByNormalNameArrays2D867() throws ClassNotFoundException { 
     assertEquals(int[][].class, ClassUtils.getClass("int[][]")); 
     assertEquals(long[][].class, ClassUtils.getClass("long[][]")); 
     assertEquals(short[][].class, ClassUtils.getClass("short[][]")); 
     assertEquals(byte[][].class, ClassUtils.getClass("byte[][]")); 
     assertEquals(char[][].class, ClassUtils.getClass("char[][]")); 
     assertEquals(float[][].class, ClassUtils.getClass("float[][]")); 
     assertEquals(double[][].class, ClassUtils.getClass("double[][]")); 
     assertEquals(boolean[][].class, ClassUtils.getClass("boolean[][]")); 
     assertEquals(String[][].class, ClassUtils.getClass("java.lang.String[][]")); 
 }
@Test
public void testGetPublicMethod935() throws Exception { 
     final Set<?> set = Collections.unmodifiableSet(new HashSet<Object>()); 
     final Method isEmptyMethod = ClassUtils.getPublicMethod(set.getClass(), "isEmpty", new Class[0]); 
     assertTrue(Modifier.isPublic(isEmptyMethod.getDeclaringClass().getModifiers())); 
     try { 
         isEmptyMethod.invoke(set, new Object[0]); 
     } catch (final java.lang.IllegalAccessException iae) { 
         fail("Should not have thrown IllegalAccessException"); 
     } 
     final Method toStringMethod = ClassUtils.getPublicMethod(Object.class, "toString", new Class[0]); 
     assertEquals(Object.class.getMethod("toString", new Class[0]), toStringMethod); 
 }
@Test
public void testGetClassRawPrimitives1052() throws ClassNotFoundException { 
     assertEquals(int.class, ClassUtils.getClass("int")); 
     assertEquals(long.class, ClassUtils.getClass("long")); 
     assertEquals(short.class, ClassUtils.getClass("short")); 
     assertEquals(byte.class, ClassUtils.getClass("byte")); 
     assertEquals(char.class, ClassUtils.getClass("char")); 
     assertEquals(float.class, ClassUtils.getClass("float")); 
     assertEquals(double.class, ClassUtils.getClass("double")); 
     assertEquals(boolean.class, ClassUtils.getClass("boolean")); 
 }
@Test
public void testGetPublicMethod1075() throws Exception { 
     final Set<?> set = Collections.unmodifiableSet(new HashSet<Object>()); 
     final Method isEmptyMethod = ClassUtils.getPublicMethod(set.getClass(), "isEmpty", new Class[0]); 
     assertTrue(Modifier.isPublic(isEmptyMethod.getDeclaringClass().getModifiers())); 
     try { 
         isEmptyMethod.invoke(set, new Object[0]); 
     } catch (final java.lang.IllegalAccessException iae) { 
         fail("Should not have thrown IllegalAccessException"); 
     } 
     final Method toStringMethod = ClassUtils.getPublicMethod(Object.class, "toString", new Class[0]); 
     assertEquals(Object.class.getMethod("toString", new Class[0]), toStringMethod); 
 }
@Test
public void test_getPackageCanonicalName_Class1080() { 
     assertEquals("org.apache.commons.lang3", ClassUtils.getPackageCanonicalName(ClassUtils.class)); 
     assertEquals("org.apache.commons.lang3", ClassUtils.getPackageCanonicalName(ClassUtils[].class)); 
     assertEquals("org.apache.commons.lang3", ClassUtils.getPackageCanonicalName(ClassUtils[][].class)); 
     assertEquals("", ClassUtils.getPackageCanonicalName(int[].class)); 
     assertEquals("", ClassUtils.getPackageCanonicalName(int[][].class)); 
     class Named extends Object { 
     } 
     assertEquals("org.apache.commons.lang3", ClassUtils.getPackageCanonicalName(new Object() { 
     }.getClass())); 
     assertEquals("org.apache.commons.lang3", ClassUtils.getPackageCanonicalName(Named.class)); 
     assertEquals("org.apache.commons.lang3", ClassUtils.getPackageCanonicalName(Inner.class)); 
 }
@Test
public void testConstructor1088() { 
     assertNotNull(new ClassUtils()); 
     final Constructor<?>[] cons = ClassUtils.class.getDeclaredConstructors(); 
     assertEquals(1, cons.length); 
     assertTrue(Modifier.isPublic(cons[0].getModifiers())); 
     assertTrue(Modifier.isPublic(ClassUtils.class.getModifiers())); 
     assertFalse(Modifier.isFinal(ClassUtils.class.getModifiers())); 
 }
@Test
public void testGetPublicMethod1192() throws Exception { 
     final Set<?> set = Collections.unmodifiableSet(new HashSet<Object>()); 
     final Method isEmptyMethod = ClassUtils.getPublicMethod(set.getClass(), "isEmpty", new Class[0]); 
     assertTrue(Modifier.isPublic(isEmptyMethod.getDeclaringClass().getModifiers())); 
     try { 
         isEmptyMethod.invoke(set, new Object[0]); 
     } catch (final java.lang.IllegalAccessException iae) { 
         fail("Should not have thrown IllegalAccessException"); 
     } 
     final Method toStringMethod = ClassUtils.getPublicMethod(Object.class, "toString", new Class[0]); 
     assertEquals(Object.class.getMethod("toString", new Class[0]), toStringMethod); 
 }
@Test
public void test_getShortClassName_String1196() { 
     assertEquals("ClassUtils", ClassUtils.getShortClassName(ClassUtils.class.getName())); 
     assertEquals("Map.Entry", ClassUtils.getShortClassName(Map.Entry.class.getName())); 
     assertEquals("", ClassUtils.getShortClassName((String) null)); 
     assertEquals("", ClassUtils.getShortClassName("")); 
 }
@Test
public void testWrappersToPrimitivesNull1263() { 
     assertNull("Wrong result for null input", ClassUtils.wrappersToPrimitives((Class<?>[]) null)); 
     assertTrue("empty -> empty", Arrays.equals(ArrayUtils.EMPTY_CLASS_ARRAY, ClassUtils.wrappersToPrimitives())); 
     final Class<?>[] castNull = ClassUtils.wrappersToPrimitives((Class<?>) null); 
     assertTrue("(Class<?>)null -> [null]", Arrays.equals(new Class<?>[] { null }, castNull)); 
 }
@Test
public void testGetPublicMethod1286() throws Exception { 
     final Set<?> set = Collections.unmodifiableSet(new HashSet<Object>()); 
     final Method isEmptyMethod = ClassUtils.getPublicMethod(set.getClass(), "isEmpty", new Class[0]); 
     assertTrue(Modifier.isPublic(isEmptyMethod.getDeclaringClass().getModifiers())); 
     try { 
         isEmptyMethod.invoke(set, new Object[0]); 
     } catch (final java.lang.IllegalAccessException iae) { 
         fail("Should not have thrown IllegalAccessException"); 
     } 
     final Method toStringMethod = ClassUtils.getPublicMethod(Object.class, "toString", new Class[0]); 
     assertEquals(Object.class.getMethod("toString", new Class[0]), toStringMethod); 
 }
@Test
public void testGetPublicMethod1295() throws Exception { 
     final Set<?> set = Collections.unmodifiableSet(new HashSet<Object>()); 
     final Method isEmptyMethod = ClassUtils.getPublicMethod(set.getClass(), "isEmpty", new Class[0]); 
     assertTrue(Modifier.isPublic(isEmptyMethod.getDeclaringClass().getModifiers())); 
     try { 
         isEmptyMethod.invoke(set, new Object[0]); 
     } catch (final java.lang.IllegalAccessException iae) { 
         fail("Should not have thrown IllegalAccessException"); 
     } 
     final Method toStringMethod = ClassUtils.getPublicMethod(Object.class, "toString", new Class[0]); 
     assertEquals(Object.class.getMethod("toString", new Class[0]), toStringMethod); 
 }
@Test
public void test_isAssignable_NoAutoboxing1471() throws Exception { 
     assertFalse(ClassUtils.isAssignable((Class<?>) null, null, false)); 
     assertFalse(ClassUtils.isAssignable(String.class, null, false)); 
     assertTrue(ClassUtils.isAssignable(null, Object.class, false)); 
     assertTrue(ClassUtils.isAssignable(null, Integer.class, false)); 
     assertFalse(ClassUtils.isAssignable(null, Integer.TYPE, false)); 
     assertTrue(ClassUtils.isAssignable(String.class, Object.class, false)); 
     assertTrue(ClassUtils.isAssignable(String.class, String.class, false)); 
     assertFalse(ClassUtils.isAssignable(Object.class, String.class, false)); 
     assertFalse(ClassUtils.isAssignable(Integer.TYPE, Integer.class, false)); 
     assertFalse(ClassUtils.isAssignable(Integer.TYPE, Object.class, false)); 
     assertFalse(ClassUtils.isAssignable(Integer.class, Integer.TYPE, false)); 
     assertTrue(ClassUtils.isAssignable(Integer.TYPE, Integer.TYPE, false)); 
     assertTrue(ClassUtils.isAssignable(Integer.class, Integer.class, false)); 
     assertFalse(ClassUtils.isAssignable(Boolean.TYPE, Boolean.class, false)); 
     assertFalse(ClassUtils.isAssignable(Boolean.TYPE, Object.class, false)); 
     assertFalse(ClassUtils.isAssignable(Boolean.class, Boolean.TYPE, false)); 
     assertTrue(ClassUtils.isAssignable(Boolean.class, Object.class, false)); 
     assertTrue(ClassUtils.isAssignable(Boolean.TYPE, Boolean.TYPE, false)); 
     assertTrue(ClassUtils.isAssignable(Boolean.class, Boolean.class, false)); 
 }
@Test
public void test_getShortCanonicalName_String1486() { 
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
public void testGetClassByNormalNameArrays2D1559() throws ClassNotFoundException { 
     assertEquals(int[][].class, ClassUtils.getClass("int[][]")); 
     assertEquals(long[][].class, ClassUtils.getClass("long[][]")); 
     assertEquals(short[][].class, ClassUtils.getClass("short[][]")); 
     assertEquals(byte[][].class, ClassUtils.getClass("byte[][]")); 
     assertEquals(char[][].class, ClassUtils.getClass("char[][]")); 
     assertEquals(float[][].class, ClassUtils.getClass("float[][]")); 
     assertEquals(double[][].class, ClassUtils.getClass("double[][]")); 
     assertEquals(boolean[][].class, ClassUtils.getClass("boolean[][]")); 
     assertEquals(String[][].class, ClassUtils.getClass("java.lang.String[][]")); 
 }
@Test
public void testGetPublicMethod1614() throws Exception { 
     final Set<?> set = Collections.unmodifiableSet(new HashSet<Object>()); 
     final Method isEmptyMethod = ClassUtils.getPublicMethod(set.getClass(), "isEmpty", new Class[0]); 
     assertTrue(Modifier.isPublic(isEmptyMethod.getDeclaringClass().getModifiers())); 
     try { 
         isEmptyMethod.invoke(set, new Object[0]); 
     } catch (final java.lang.IllegalAccessException iae) { 
         fail("Should not have thrown IllegalAccessException"); 
     } 
     final Method toStringMethod = ClassUtils.getPublicMethod(Object.class, "toString", new Class[0]); 
     assertEquals(Object.class.getMethod("toString", new Class[0]), toStringMethod); 
 }
@Test
public void testToClass_object1722() { 
     assertNull(ClassUtils.toClass((Object[]) null)); 
     assertTrue("empty -> empty", Arrays.equals(ArrayUtils.EMPTY_CLASS_ARRAY, ClassUtils.toClass())); 
     final Class<?>[] castNull = ClassUtils.toClass((Object) null); 
     assertTrue("(Object)null -> [null]", Arrays.equals(new Object[] { null }, castNull)); 
     assertSame(ArrayUtils.EMPTY_CLASS_ARRAY, ClassUtils.toClass(ArrayUtils.EMPTY_OBJECT_ARRAY)); 
     assertTrue(Arrays.equals(new Class[] { String.class, Integer.class, Double.class }, ClassUtils.toClass(new Object[] { "Test", Integer.valueOf(1), Double.valueOf(99d) }))); 
     assertTrue(Arrays.equals(new Class[] { String.class, null, Double.class }, ClassUtils.toClass(new Object[] { "Test", null, Double.valueOf(99d) }))); 
 }
@Test
public void test_getShortClassName_String1778() { 
     assertEquals("ClassUtils", ClassUtils.getShortClassName(ClassUtils.class.getName())); 
     assertEquals("Map.Entry", ClassUtils.getShortClassName(Map.Entry.class.getName())); 
     assertEquals("", ClassUtils.getShortClassName((String) null)); 
     assertEquals("", ClassUtils.getShortClassName("")); 
 }
@Test
public void test_isAssignable_ClassArray_ClassArray1825() throws Exception { 
     final Class<?>[] array2 = new Class[] { Object.class, Object.class }; 
     final Class<?>[] array1 = new Class[] { Object.class }; 
     final Class<?>[] array1s = new Class[] { String.class }; 
     final Class<?>[] array0 = new Class[] {}; 
     final Class<?>[] arrayPrimitives = { Integer.TYPE, Boolean.TYPE }; 
     final Class<?>[] arrayWrappers = { Integer.class, Boolean.class }; 
     assertFalse(ClassUtils.isAssignable(array1, array2)); 
     assertFalse(ClassUtils.isAssignable(null, array2)); 
     assertTrue(ClassUtils.isAssignable(null, array0)); 
     assertTrue(ClassUtils.isAssignable(array0, array0)); 
     assertTrue(ClassUtils.isAssignable(array0, (Class<?>[]) null)); 
     assertTrue(ClassUtils.isAssignable((Class[]) null, (Class[]) null)); 
     assertFalse(ClassUtils.isAssignable(array1, array1s)); 
     assertTrue(ClassUtils.isAssignable(array1s, array1s)); 
     assertTrue(ClassUtils.isAssignable(array1s, array1)); 
     final boolean autoboxing = SystemUtils.isJavaVersionAtLeast(JAVA_1_5); 
     assertEquals(autoboxing, ClassUtils.isAssignable(arrayPrimitives, arrayWrappers)); 
     assertEquals(autoboxing, ClassUtils.isAssignable(arrayWrappers, arrayPrimitives)); 
     assertFalse(ClassUtils.isAssignable(arrayPrimitives, array1)); 
     assertFalse(ClassUtils.isAssignable(arrayWrappers, array1)); 
     assertEquals(autoboxing, ClassUtils.isAssignable(arrayPrimitives, array2)); 
     assertTrue(ClassUtils.isAssignable(arrayWrappers, array2)); 
 }
@Test
public void testGetClassByNormalNameArrays2D1829() throws ClassNotFoundException { 
     assertEquals(int[][].class, ClassUtils.getClass("int[][]")); 
     assertEquals(long[][].class, ClassUtils.getClass("long[][]")); 
     assertEquals(short[][].class, ClassUtils.getClass("short[][]")); 
     assertEquals(byte[][].class, ClassUtils.getClass("byte[][]")); 
     assertEquals(char[][].class, ClassUtils.getClass("char[][]")); 
     assertEquals(float[][].class, ClassUtils.getClass("float[][]")); 
     assertEquals(double[][].class, ClassUtils.getClass("double[][]")); 
     assertEquals(boolean[][].class, ClassUtils.getClass("boolean[][]")); 
     assertEquals(String[][].class, ClassUtils.getClass("java.lang.String[][]")); 
 }
@Test
public void testGetPublicMethod1862() throws Exception { 
     final Set<?> set = Collections.unmodifiableSet(new HashSet<Object>()); 
     final Method isEmptyMethod = ClassUtils.getPublicMethod(set.getClass(), "isEmpty", new Class[0]); 
     assertTrue(Modifier.isPublic(isEmptyMethod.getDeclaringClass().getModifiers())); 
     try { 
         isEmptyMethod.invoke(set, new Object[0]); 
     } catch (final java.lang.IllegalAccessException iae) { 
         fail("Should not have thrown IllegalAccessException"); 
     } 
     final Method toStringMethod = ClassUtils.getPublicMethod(Object.class, "toString", new Class[0]); 
     assertEquals(Object.class.getMethod("toString", new Class[0]), toStringMethod); 
 }
@Test
public void test_getShortCanonicalName_String1878() { 
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
public void testGetPublicMethod1922() throws Exception { 
     final Set<?> set = Collections.unmodifiableSet(new HashSet<Object>()); 
     final Method isEmptyMethod = ClassUtils.getPublicMethod(set.getClass(), "isEmpty", new Class[0]); 
     assertTrue(Modifier.isPublic(isEmptyMethod.getDeclaringClass().getModifiers())); 
     try { 
         isEmptyMethod.invoke(set, new Object[0]); 
     } catch (final java.lang.IllegalAccessException iae) { 
         fail("Should not have thrown IllegalAccessException"); 
     } 
     final Method toStringMethod = ClassUtils.getPublicMethod(Object.class, "toString", new Class[0]); 
     assertEquals(Object.class.getMethod("toString", new Class[0]), toStringMethod); 
 }
@Test
public void testGetPublicMethod1923() throws Exception { 
     final Set<?> set = Collections.unmodifiableSet(new HashSet<Object>()); 
     final Method isEmptyMethod = ClassUtils.getPublicMethod(set.getClass(), "isEmpty", new Class[0]); 
     assertTrue(Modifier.isPublic(isEmptyMethod.getDeclaringClass().getModifiers())); 
     try { 
         isEmptyMethod.invoke(set, new Object[0]); 
     } catch (final java.lang.IllegalAccessException iae) { 
         fail("Should not have thrown IllegalAccessException"); 
     } 
     final Method toStringMethod = ClassUtils.getPublicMethod(Object.class, "toString", new Class[0]); 
     assertEquals(Object.class.getMethod("toString", new Class[0]), toStringMethod); 
 }
@Test
public void test_getShortCanonicalName_String1954() { 
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
public void testToClass_object2040() { 
     assertNull(ClassUtils.toClass((Object[]) null)); 
     assertTrue("empty -> empty", Arrays.equals(ArrayUtils.EMPTY_CLASS_ARRAY, ClassUtils.toClass())); 
     final Class<?>[] castNull = ClassUtils.toClass((Object) null); 
     assertTrue("(Object)null -> [null]", Arrays.equals(new Object[] { null }, castNull)); 
     assertSame(ArrayUtils.EMPTY_CLASS_ARRAY, ClassUtils.toClass(ArrayUtils.EMPTY_OBJECT_ARRAY)); 
     assertTrue(Arrays.equals(new Class[] { String.class, Integer.class, Double.class }, ClassUtils.toClass(new Object[] { "Test", Integer.valueOf(1), Double.valueOf(99d) }))); 
     assertTrue(Arrays.equals(new Class[] { String.class, null, Double.class }, ClassUtils.toClass(new Object[] { "Test", null, Double.valueOf(99d) }))); 
 }
@Test
public void testGetPublicMethod2185() throws Exception { 
     final Set<?> set = Collections.unmodifiableSet(new HashSet<Object>()); 
     final Method isEmptyMethod = ClassUtils.getPublicMethod(set.getClass(), "isEmpty", new Class[0]); 
     assertTrue(Modifier.isPublic(isEmptyMethod.getDeclaringClass().getModifiers())); 
     try { 
         isEmptyMethod.invoke(set, new Object[0]); 
     } catch (final java.lang.IllegalAccessException iae) { 
         fail("Should not have thrown IllegalAccessException"); 
     } 
     final Method toStringMethod = ClassUtils.getPublicMethod(Object.class, "toString", new Class[0]); 
     assertEquals(Object.class.getMethod("toString", new Class[0]), toStringMethod); 
 }
@Test
public void test_isAssignable_NoAutoboxing2258() throws Exception { 
     assertFalse(ClassUtils.isAssignable((Class<?>) null, null, false)); 
     assertFalse(ClassUtils.isAssignable(String.class, null, false)); 
     assertTrue(ClassUtils.isAssignable(null, Object.class, false)); 
     assertTrue(ClassUtils.isAssignable(null, Integer.class, false)); 
     assertFalse(ClassUtils.isAssignable(null, Integer.TYPE, false)); 
     assertTrue(ClassUtils.isAssignable(String.class, Object.class, false)); 
     assertTrue(ClassUtils.isAssignable(String.class, String.class, false)); 
     assertFalse(ClassUtils.isAssignable(Object.class, String.class, false)); 
     assertFalse(ClassUtils.isAssignable(Integer.TYPE, Integer.class, false)); 
     assertFalse(ClassUtils.isAssignable(Integer.TYPE, Object.class, false)); 
     assertFalse(ClassUtils.isAssignable(Integer.class, Integer.TYPE, false)); 
     assertTrue(ClassUtils.isAssignable(Integer.TYPE, Integer.TYPE, false)); 
     assertTrue(ClassUtils.isAssignable(Integer.class, Integer.class, false)); 
     assertFalse(ClassUtils.isAssignable(Boolean.TYPE, Boolean.class, false)); 
     assertFalse(ClassUtils.isAssignable(Boolean.TYPE, Object.class, false)); 
     assertFalse(ClassUtils.isAssignable(Boolean.class, Boolean.TYPE, false)); 
     assertTrue(ClassUtils.isAssignable(Boolean.class, Object.class, false)); 
     assertTrue(ClassUtils.isAssignable(Boolean.TYPE, Boolean.TYPE, false)); 
     assertTrue(ClassUtils.isAssignable(Boolean.class, Boolean.class, false)); 
 }
@Test
public void test_getShortCanonicalName_String2263() { 
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
public void test_getPackageName_Class2277() { 
     assertEquals("java.lang", ClassUtils.getPackageName(String.class)); 
     assertEquals("java.util", ClassUtils.getPackageName(Map.Entry.class)); 
     assertEquals("", ClassUtils.getPackageName((Class<?>) null)); 
     assertEquals("java.lang", ClassUtils.getPackageName(String[].class)); 
     assertEquals("", ClassUtils.getPackageName(boolean[].class)); 
     assertEquals("", ClassUtils.getPackageName(byte[].class)); 
     assertEquals("", ClassUtils.getPackageName(char[].class)); 
     assertEquals("", ClassUtils.getPackageName(short[].class)); 
     assertEquals("", ClassUtils.getPackageName(int[].class)); 
     assertEquals("", ClassUtils.getPackageName(long[].class)); 
     assertEquals("", ClassUtils.getPackageName(float[].class)); 
     assertEquals("", ClassUtils.getPackageName(double[].class)); 
     assertEquals("java.lang", ClassUtils.getPackageName(String[][].class)); 
     assertEquals("java.lang", ClassUtils.getPackageName(String[][][].class)); 
     assertEquals("java.lang", ClassUtils.getPackageName(String[][][][].class)); 
     class Named extends Object { 
     } 
     assertEquals("org.apache.commons.lang3", ClassUtils.getPackageName(new Object() { 
     }.getClass())); 
     assertEquals("org.apache.commons.lang3", ClassUtils.getPackageName(Named.class)); 
 }
@Test
public void testGetClassByNormalNameArrays2D2285() throws ClassNotFoundException { 
     assertEquals(int[][].class, ClassUtils.getClass("int[][]")); 
     assertEquals(long[][].class, ClassUtils.getClass("long[][]")); 
     assertEquals(short[][].class, ClassUtils.getClass("short[][]")); 
     assertEquals(byte[][].class, ClassUtils.getClass("byte[][]")); 
     assertEquals(char[][].class, ClassUtils.getClass("char[][]")); 
     assertEquals(float[][].class, ClassUtils.getClass("float[][]")); 
     assertEquals(double[][].class, ClassUtils.getClass("double[][]")); 
     assertEquals(boolean[][].class, ClassUtils.getClass("boolean[][]")); 
     assertEquals(String[][].class, ClassUtils.getClass("java.lang.String[][]")); 
 }
@Test
public void testGetPublicMethod2290() throws Exception { 
     final Set<?> set = Collections.unmodifiableSet(new HashSet<Object>()); 
     final Method isEmptyMethod = ClassUtils.getPublicMethod(set.getClass(), "isEmpty", new Class[0]); 
     assertTrue(Modifier.isPublic(isEmptyMethod.getDeclaringClass().getModifiers())); 
     try { 
         isEmptyMethod.invoke(set, new Object[0]); 
     } catch (final java.lang.IllegalAccessException iae) { 
         fail("Should not have thrown IllegalAccessException"); 
     } 
     final Method toStringMethod = ClassUtils.getPublicMethod(Object.class, "toString", new Class[0]); 
     assertEquals(Object.class.getMethod("toString", new Class[0]), toStringMethod); 
 }
@Test
public void test_getSimpleName_Object2345() { 
     assertEquals("ClassUtils", ClassUtils.getSimpleName(new ClassUtils(), "<null>")); 
     assertEquals("Inner", ClassUtils.getSimpleName(new Inner(), "<null>")); 
     assertEquals("String", ClassUtils.getSimpleName("hello", "<null>")); 
     assertEquals("<null>", ClassUtils.getSimpleName(null, "<null>")); 
 }
@Test
public void test_convertClassesToClassNames_List2376() { 
     final List<Class<?>> list = new ArrayList<Class<?>>(); 
     List<String> result = ClassUtils.convertClassesToClassNames(list); 
     assertEquals(0, result.size()); 
     list.add(String.class); 
     list.add(null); 
     list.add(Object.class); 
     result = ClassUtils.convertClassesToClassNames(list); 
     assertEquals(3, result.size()); 
     assertEquals("java.lang.String", result.get(0)); 
     assertEquals(null, result.get(1)); 
     assertEquals("java.lang.Object", result.get(2)); 
     @SuppressWarnings("unchecked") 
     final List<Object> olist = (List<Object>) (List<?>) list; 
     olist.add(new Object()); 
     try { 
         ClassUtils.convertClassesToClassNames(list); 
         fail("Should not have been able to convert list"); 
     } catch (final ClassCastException expected) { 
     } 
     assertEquals(null, ClassUtils.convertClassesToClassNames(null)); 
 }
@Test
public void test_convertClassNamesToClasses_List2401() { 
     final List<String> list = new ArrayList<String>(); 
     List<Class<?>> result = ClassUtils.convertClassNamesToClasses(list); 
     assertEquals(0, result.size()); 
     list.add("java.lang.String"); 
     list.add("java.lang.xxx"); 
     list.add("java.lang.Object"); 
     result = ClassUtils.convertClassNamesToClasses(list); 
     assertEquals(3, result.size()); 
     assertEquals(String.class, result.get(0)); 
     assertEquals(null, result.get(1)); 
     assertEquals(Object.class, result.get(2)); 
     @SuppressWarnings("unchecked") 
     final List<Object> olist = (List<Object>) (List<?>) list; 
     olist.add(new Object()); 
     try { 
         ClassUtils.convertClassNamesToClasses(list); 
         fail("Should not have been able to convert list"); 
     } catch (final ClassCastException expected) { 
     } 
     assertEquals(null, ClassUtils.convertClassNamesToClasses(null)); 
 }
@Test
public void test_getShortCanonicalName_String2452() { 
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
public void test_getPackageCanonicalName_Class2462() { 
     assertEquals("org.apache.commons.lang3", ClassUtils.getPackageCanonicalName(ClassUtils.class)); 
     assertEquals("org.apache.commons.lang3", ClassUtils.getPackageCanonicalName(ClassUtils[].class)); 
     assertEquals("org.apache.commons.lang3", ClassUtils.getPackageCanonicalName(ClassUtils[][].class)); 
     assertEquals("", ClassUtils.getPackageCanonicalName(int[].class)); 
     assertEquals("", ClassUtils.getPackageCanonicalName(int[][].class)); 
     class Named extends Object { 
     } 
     assertEquals("org.apache.commons.lang3", ClassUtils.getPackageCanonicalName(new Object() { 
     }.getClass())); 
     assertEquals("org.apache.commons.lang3", ClassUtils.getPackageCanonicalName(Named.class)); 
     assertEquals("org.apache.commons.lang3", ClassUtils.getPackageCanonicalName(Inner.class)); 
 }
@Test
public void test_getPackageCanonicalName_Object2470() { 
     assertEquals("<null>", ClassUtils.getPackageCanonicalName(null, "<null>")); 
     assertEquals("org.apache.commons.lang3", ClassUtils.getPackageCanonicalName(new ClassUtils(), "<null>")); 
     assertEquals("org.apache.commons.lang3", ClassUtils.getPackageCanonicalName(new ClassUtils[0], "<null>")); 
     assertEquals("org.apache.commons.lang3", ClassUtils.getPackageCanonicalName(new ClassUtils[0][0], "<null>")); 
     assertEquals("", ClassUtils.getPackageCanonicalName(new int[0], "<null>")); 
     assertEquals("", ClassUtils.getPackageCanonicalName(new int[0][0], "<null>")); 
     class Named extends Object { 
     } 
     assertEquals("org.apache.commons.lang3", ClassUtils.getPackageCanonicalName(new Object() { 
     }, "<null>")); 
     assertEquals("org.apache.commons.lang3", ClassUtils.getPackageCanonicalName(new Named(), "<null>")); 
     assertEquals("org.apache.commons.lang3", ClassUtils.getPackageCanonicalName(new Inner(), "<null>")); 
 }
@Test
public void test_getPackageName_Object2479() { 
     assertEquals("org.apache.commons.lang3", ClassUtils.getPackageName(new ClassUtils(), "<null>")); 
     assertEquals("org.apache.commons.lang3", ClassUtils.getPackageName(new Inner(), "<null>")); 
     assertEquals("<null>", ClassUtils.getPackageName(null, "<null>")); 
 }
@Test
public void testToClass_object2517() { 
     assertNull(ClassUtils.toClass((Object[]) null)); 
     assertTrue("empty -> empty", Arrays.equals(ArrayUtils.EMPTY_CLASS_ARRAY, ClassUtils.toClass())); 
     final Class<?>[] castNull = ClassUtils.toClass((Object) null); 
     assertTrue("(Object)null -> [null]", Arrays.equals(new Object[] { null }, castNull)); 
     assertSame(ArrayUtils.EMPTY_CLASS_ARRAY, ClassUtils.toClass(ArrayUtils.EMPTY_OBJECT_ARRAY)); 
     assertTrue(Arrays.equals(new Class[] { String.class, Integer.class, Double.class }, ClassUtils.toClass(new Object[] { "Test", Integer.valueOf(1), Double.valueOf(99d) }))); 
     assertTrue(Arrays.equals(new Class[] { String.class, null, Double.class }, ClassUtils.toClass(new Object[] { "Test", null, Double.valueOf(99d) }))); 
 }
@Test
public void testWrappersToPrimitivesNull2542() { 
     assertNull("Wrong result for null input", ClassUtils.wrappersToPrimitives((Class<?>[]) null)); 
     assertTrue("empty -> empty", Arrays.equals(ArrayUtils.EMPTY_CLASS_ARRAY, ClassUtils.wrappersToPrimitives())); 
     final Class<?>[] castNull = ClassUtils.wrappersToPrimitives((Class<?>) null); 
     assertTrue("(Class<?>)null -> [null]", Arrays.equals(new Class<?>[] { null }, castNull)); 
 }
@Test
public void test_isInnerClass_Class2580() { 
     assertTrue(ClassUtils.isInnerClass(Inner.class)); 
     assertTrue(ClassUtils.isInnerClass(Map.Entry.class)); 
     assertTrue(ClassUtils.isInnerClass(new Cloneable() { 
     }.getClass())); 
     assertFalse(ClassUtils.isInnerClass(this.getClass())); 
     assertFalse(ClassUtils.isInnerClass(String.class)); 
     assertFalse(ClassUtils.isInnerClass(null)); 
 }
@Test
public void testGetPublicMethod2746() throws Exception { 
     final Set<?> set = Collections.unmodifiableSet(new HashSet<Object>()); 
     final Method isEmptyMethod = ClassUtils.getPublicMethod(set.getClass(), "isEmpty", new Class[0]); 
     assertTrue(Modifier.isPublic(isEmptyMethod.getDeclaringClass().getModifiers())); 
     try { 
         isEmptyMethod.invoke(set, new Object[0]); 
     } catch (final java.lang.IllegalAccessException iae) { 
         fail("Should not have thrown IllegalAccessException"); 
     } 
     final Method toStringMethod = ClassUtils.getPublicMethod(Object.class, "toString", new Class[0]); 
     assertEquals(Object.class.getMethod("toString", new Class[0]), toStringMethod); 
 }
@Test
public void test_convertClassNamesToClasses_List2789() { 
     final List<String> list = new ArrayList<String>(); 
     List<Class<?>> result = ClassUtils.convertClassNamesToClasses(list); 
     assertEquals(0, result.size()); 
     list.add("java.lang.String"); 
     list.add("java.lang.xxx"); 
     list.add("java.lang.Object"); 
     result = ClassUtils.convertClassNamesToClasses(list); 
     assertEquals(3, result.size()); 
     assertEquals(String.class, result.get(0)); 
     assertEquals(null, result.get(1)); 
     assertEquals(Object.class, result.get(2)); 
     @SuppressWarnings("unchecked") 
     final List<Object> olist = (List<Object>) (List<?>) list; 
     olist.add(new Object()); 
     try { 
         ClassUtils.convertClassNamesToClasses(list); 
         fail("Should not have been able to convert list"); 
     } catch (final ClassCastException expected) { 
     } 
     assertEquals(null, ClassUtils.convertClassNamesToClasses(null)); 
 }
@Test
public void test_getShortCanonicalName_String2813() { 
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
public void testToClass_object2850() { 
     assertNull(ClassUtils.toClass((Object[]) null)); 
     assertTrue("empty -> empty", Arrays.equals(ArrayUtils.EMPTY_CLASS_ARRAY, ClassUtils.toClass())); 
     final Class<?>[] castNull = ClassUtils.toClass((Object) null); 
     assertTrue("(Object)null -> [null]", Arrays.equals(new Object[] { null }, castNull)); 
     assertSame(ArrayUtils.EMPTY_CLASS_ARRAY, ClassUtils.toClass(ArrayUtils.EMPTY_OBJECT_ARRAY)); 
     assertTrue(Arrays.equals(new Class[] { String.class, Integer.class, Double.class }, ClassUtils.toClass(new Object[] { "Test", Integer.valueOf(1), Double.valueOf(99d) }))); 
     assertTrue(Arrays.equals(new Class[] { String.class, null, Double.class }, ClassUtils.toClass(new Object[] { "Test", null, Double.valueOf(99d) }))); 
 }
@Test
public void testGetClassInvalidArguments2872() throws Exception { 
     assertGetClassThrowsNullPointerException(null); 
     assertGetClassThrowsClassNotFound("[][][]"); 
     assertGetClassThrowsClassNotFound("[[]"); 
     assertGetClassThrowsClassNotFound("["); 
     assertGetClassThrowsClassNotFound("java.lang.String]["); 
     assertGetClassThrowsClassNotFound(".hello.world"); 
     assertGetClassThrowsClassNotFound("hello..world"); 
 }
@Test
public void testGetClassByNormalNameArrays2D2939() throws ClassNotFoundException { 
     assertEquals(int[][].class, ClassUtils.getClass("int[][]")); 
     assertEquals(long[][].class, ClassUtils.getClass("long[][]")); 
     assertEquals(short[][].class, ClassUtils.getClass("short[][]")); 
     assertEquals(byte[][].class, ClassUtils.getClass("byte[][]")); 
     assertEquals(char[][].class, ClassUtils.getClass("char[][]")); 
     assertEquals(float[][].class, ClassUtils.getClass("float[][]")); 
     assertEquals(double[][].class, ClassUtils.getClass("double[][]")); 
     assertEquals(boolean[][].class, ClassUtils.getClass("boolean[][]")); 
     assertEquals(String[][].class, ClassUtils.getClass("java.lang.String[][]")); 
 }
@Test
public void testIsPrimitiveOrWrapper2972() { 
     assertTrue("Boolean.class", ClassUtils.isPrimitiveOrWrapper(Boolean.class)); 
     assertTrue("Byte.class", ClassUtils.isPrimitiveOrWrapper(Byte.class)); 
     assertTrue("Character.class", ClassUtils.isPrimitiveOrWrapper(Character.class)); 
     assertTrue("Short.class", ClassUtils.isPrimitiveOrWrapper(Short.class)); 
     assertTrue("Integer.class", ClassUtils.isPrimitiveOrWrapper(Integer.class)); 
     assertTrue("Long.class", ClassUtils.isPrimitiveOrWrapper(Long.class)); 
     assertTrue("Double.class", ClassUtils.isPrimitiveOrWrapper(Double.class)); 
     assertTrue("Float.class", ClassUtils.isPrimitiveOrWrapper(Float.class)); 
     assertTrue("boolean", ClassUtils.isPrimitiveOrWrapper(Boolean.TYPE)); 
     assertTrue("byte", ClassUtils.isPrimitiveOrWrapper(Byte.TYPE)); 
     assertTrue("char", ClassUtils.isPrimitiveOrWrapper(Character.TYPE)); 
     assertTrue("short", ClassUtils.isPrimitiveOrWrapper(Short.TYPE)); 
     assertTrue("int", ClassUtils.isPrimitiveOrWrapper(Integer.TYPE)); 
     assertTrue("long", ClassUtils.isPrimitiveOrWrapper(Long.TYPE)); 
     assertTrue("double", ClassUtils.isPrimitiveOrWrapper(Double.TYPE)); 
     assertTrue("float", ClassUtils.isPrimitiveOrWrapper(Float.TYPE)); 
     assertTrue("Void.TYPE", ClassUtils.isPrimitiveOrWrapper(Void.TYPE)); 
     assertFalse("null", ClassUtils.isPrimitiveOrWrapper(null)); 
     assertFalse("Void.class", ClassUtils.isPrimitiveOrWrapper(Void.class)); 
     assertFalse("String.class", ClassUtils.isPrimitiveOrWrapper(String.class)); 
     assertFalse("this.getClass()", ClassUtils.isPrimitiveOrWrapper(this.getClass())); 
 }
@Test
public void test_convertClassesToClassNames_List3175() { 
     final List<Class<?>> list = new ArrayList<Class<?>>(); 
     List<String> result = ClassUtils.convertClassesToClassNames(list); 
     assertEquals(0, result.size()); 
     list.add(String.class); 
     list.add(null); 
     list.add(Object.class); 
     result = ClassUtils.convertClassesToClassNames(list); 
     assertEquals(3, result.size()); 
     assertEquals("java.lang.String", result.get(0)); 
     assertEquals(null, result.get(1)); 
     assertEquals("java.lang.Object", result.get(2)); 
     @SuppressWarnings("unchecked") 
     final List<Object> olist = (List<Object>) (List<?>) list; 
     olist.add(new Object()); 
     try { 
         ClassUtils.convertClassesToClassNames(list); 
         fail("Should not have been able to convert list"); 
     } catch (final ClassCastException expected) { 
     } 
     assertEquals(null, ClassUtils.convertClassesToClassNames(null)); 
 }
@Test
public void testWrappersToPrimitivesNull3183() { 
     assertNull("Wrong result for null input", ClassUtils.wrappersToPrimitives((Class<?>[]) null)); 
     assertTrue("empty -> empty", Arrays.equals(ArrayUtils.EMPTY_CLASS_ARRAY, ClassUtils.wrappersToPrimitives())); 
     final Class<?>[] castNull = ClassUtils.wrappersToPrimitives((Class<?>) null); 
     assertTrue("(Class<?>)null -> [null]", Arrays.equals(new Class<?>[] { null }, castNull)); 
 }
@Test
public void testConstructor3192() { 
     assertNotNull(new ClassUtils()); 
     final Constructor<?>[] cons = ClassUtils.class.getDeclaredConstructors(); 
     assertEquals(1, cons.length); 
     assertTrue(Modifier.isPublic(cons[0].getModifiers())); 
     assertTrue(Modifier.isPublic(ClassUtils.class.getModifiers())); 
     assertFalse(Modifier.isFinal(ClassUtils.class.getModifiers())); 
 }
@Test
public void testWrappersToPrimitivesNull3216() { 
     assertNull("Wrong result for null input", ClassUtils.wrappersToPrimitives((Class<?>[]) null)); 
     assertTrue("empty -> empty", Arrays.equals(ArrayUtils.EMPTY_CLASS_ARRAY, ClassUtils.wrappersToPrimitives())); 
     final Class<?>[] castNull = ClassUtils.wrappersToPrimitives((Class<?>) null); 
     assertTrue("(Class<?>)null -> [null]", Arrays.equals(new Class<?>[] { null }, castNull)); 
 }
@Test
public void testGetPublicMethod3266() throws Exception { 
     final Set<?> set = Collections.unmodifiableSet(new HashSet<Object>()); 
     final Method isEmptyMethod = ClassUtils.getPublicMethod(set.getClass(), "isEmpty", new Class[0]); 
     assertTrue(Modifier.isPublic(isEmptyMethod.getDeclaringClass().getModifiers())); 
     try { 
         isEmptyMethod.invoke(set, new Object[0]); 
     } catch (final java.lang.IllegalAccessException iae) { 
         fail("Should not have thrown IllegalAccessException"); 
     } 
     final Method toStringMethod = ClassUtils.getPublicMethod(Object.class, "toString", new Class[0]); 
     assertEquals(Object.class.getMethod("toString", new Class[0]), toStringMethod); 
 }
@Test
public void testIsPrimitiveOrWrapper3430() { 
     assertTrue("Boolean.class", ClassUtils.isPrimitiveOrWrapper(Boolean.class)); 
     assertTrue("Byte.class", ClassUtils.isPrimitiveOrWrapper(Byte.class)); 
     assertTrue("Character.class", ClassUtils.isPrimitiveOrWrapper(Character.class)); 
     assertTrue("Short.class", ClassUtils.isPrimitiveOrWrapper(Short.class)); 
     assertTrue("Integer.class", ClassUtils.isPrimitiveOrWrapper(Integer.class)); 
     assertTrue("Long.class", ClassUtils.isPrimitiveOrWrapper(Long.class)); 
     assertTrue("Double.class", ClassUtils.isPrimitiveOrWrapper(Double.class)); 
     assertTrue("Float.class", ClassUtils.isPrimitiveOrWrapper(Float.class)); 
     assertTrue("boolean", ClassUtils.isPrimitiveOrWrapper(Boolean.TYPE)); 
     assertTrue("byte", ClassUtils.isPrimitiveOrWrapper(Byte.TYPE)); 
     assertTrue("char", ClassUtils.isPrimitiveOrWrapper(Character.TYPE)); 
     assertTrue("short", ClassUtils.isPrimitiveOrWrapper(Short.TYPE)); 
     assertTrue("int", ClassUtils.isPrimitiveOrWrapper(Integer.TYPE)); 
     assertTrue("long", ClassUtils.isPrimitiveOrWrapper(Long.TYPE)); 
     assertTrue("double", ClassUtils.isPrimitiveOrWrapper(Double.TYPE)); 
     assertTrue("float", ClassUtils.isPrimitiveOrWrapper(Float.TYPE)); 
     assertTrue("Void.TYPE", ClassUtils.isPrimitiveOrWrapper(Void.TYPE)); 
     assertFalse("null", ClassUtils.isPrimitiveOrWrapper(null)); 
     assertFalse("Void.class", ClassUtils.isPrimitiveOrWrapper(Void.class)); 
     assertFalse("String.class", ClassUtils.isPrimitiveOrWrapper(String.class)); 
     assertFalse("this.getClass()", ClassUtils.isPrimitiveOrWrapper(this.getClass())); 
 }
@Test
public void test_convertClassesToClassNames_List3449() { 
     final List<Class<?>> list = new ArrayList<Class<?>>(); 
     List<String> result = ClassUtils.convertClassesToClassNames(list); 
     assertEquals(0, result.size()); 
     list.add(String.class); 
     list.add(null); 
     list.add(Object.class); 
     result = ClassUtils.convertClassesToClassNames(list); 
     assertEquals(3, result.size()); 
     assertEquals("java.lang.String", result.get(0)); 
     assertEquals(null, result.get(1)); 
     assertEquals("java.lang.Object", result.get(2)); 
     @SuppressWarnings("unchecked") 
     final List<Object> olist = (List<Object>) (List<?>) list; 
     olist.add(new Object()); 
     try { 
         ClassUtils.convertClassesToClassNames(list); 
         fail("Should not have been able to convert list"); 
     } catch (final ClassCastException expected) { 
     } 
     assertEquals(null, ClassUtils.convertClassesToClassNames(null)); 
 }
@Test
public void test_isAssignable_ClassArray_ClassArray_Autoboxing3462() throws Exception { 
     final Class<?>[] array2 = new Class[] { Object.class, Object.class }; 
     final Class<?>[] array1 = new Class[] { Object.class }; 
     final Class<?>[] array1s = new Class[] { String.class }; 
     final Class<?>[] array0 = new Class[] {}; 
     final Class<?>[] arrayPrimitives = { Integer.TYPE, Boolean.TYPE }; 
     final Class<?>[] arrayWrappers = { Integer.class, Boolean.class }; 
     assertFalse(ClassUtils.isAssignable(array1, array2, true)); 
     assertFalse(ClassUtils.isAssignable(null, array2, true)); 
     assertTrue(ClassUtils.isAssignable(null, array0, true)); 
     assertTrue(ClassUtils.isAssignable(array0, array0, true)); 
     assertTrue(ClassUtils.isAssignable(array0, null, true)); 
     assertTrue(ClassUtils.isAssignable((Class[]) null, (Class[]) null, true)); 
     assertFalse(ClassUtils.isAssignable(array1, array1s, true)); 
     assertTrue(ClassUtils.isAssignable(array1s, array1s, true)); 
     assertTrue(ClassUtils.isAssignable(array1s, array1, true)); 
     assertTrue(ClassUtils.isAssignable(arrayPrimitives, arrayWrappers, true)); 
     assertTrue(ClassUtils.isAssignable(arrayWrappers, arrayPrimitives, true)); 
     assertFalse(ClassUtils.isAssignable(arrayPrimitives, array1, true)); 
     assertFalse(ClassUtils.isAssignable(arrayWrappers, array1, true)); 
     assertTrue(ClassUtils.isAssignable(arrayPrimitives, array2, true)); 
     assertTrue(ClassUtils.isAssignable(arrayWrappers, array2, true)); 
 }
@Test
public void testGetClassByNormalNameArrays2D3530() throws ClassNotFoundException { 
     assertEquals(int[][].class, ClassUtils.getClass("int[][]")); 
     assertEquals(long[][].class, ClassUtils.getClass("long[][]")); 
     assertEquals(short[][].class, ClassUtils.getClass("short[][]")); 
     assertEquals(byte[][].class, ClassUtils.getClass("byte[][]")); 
     assertEquals(char[][].class, ClassUtils.getClass("char[][]")); 
     assertEquals(float[][].class, ClassUtils.getClass("float[][]")); 
     assertEquals(double[][].class, ClassUtils.getClass("double[][]")); 
     assertEquals(boolean[][].class, ClassUtils.getClass("boolean[][]")); 
     assertEquals(String[][].class, ClassUtils.getClass("java.lang.String[][]")); 
 }
@Test
public void test_getShortClassName_Class3534() { 
     assertEquals("ClassUtils", ClassUtils.getShortClassName(ClassUtils.class)); 
     assertEquals("Map.Entry", ClassUtils.getShortClassName(Map.Entry.class)); 
     assertEquals("", ClassUtils.getShortClassName((Class<?>) null)); 
     assertEquals("String[]", ClassUtils.getShortClassName(String[].class)); 
     assertEquals("Map.Entry[]", ClassUtils.getShortClassName(Map.Entry[].class)); 
     assertEquals("boolean", ClassUtils.getShortClassName(boolean.class)); 
     assertEquals("byte", ClassUtils.getShortClassName(byte.class)); 
     assertEquals("char", ClassUtils.getShortClassName(char.class)); 
     assertEquals("short", ClassUtils.getShortClassName(short.class)); 
     assertEquals("int", ClassUtils.getShortClassName(int.class)); 
     assertEquals("long", ClassUtils.getShortClassName(long.class)); 
     assertEquals("float", ClassUtils.getShortClassName(float.class)); 
     assertEquals("double", ClassUtils.getShortClassName(double.class)); 
     assertEquals("boolean[]", ClassUtils.getShortClassName(boolean[].class)); 
     assertEquals("byte[]", ClassUtils.getShortClassName(byte[].class)); 
     assertEquals("char[]", ClassUtils.getShortClassName(char[].class)); 
     assertEquals("short[]", ClassUtils.getShortClassName(short[].class)); 
     assertEquals("int[]", ClassUtils.getShortClassName(int[].class)); 
     assertEquals("long[]", ClassUtils.getShortClassName(long[].class)); 
     assertEquals("float[]", ClassUtils.getShortClassName(float[].class)); 
     assertEquals("double[]", ClassUtils.getShortClassName(double[].class)); 
     assertEquals("String[][]", ClassUtils.getShortClassName(String[][].class)); 
     assertEquals("String[][][]", ClassUtils.getShortClassName(String[][][].class)); 
     assertEquals("String[][][][]", ClassUtils.getShortClassName(String[][][][].class)); 
     class Named extends Object { 
     } 
     assertEquals("ClassUtilsTest.2", ClassUtils.getShortClassName(new Object() { 
     }.getClass())); 
     assertEquals("ClassUtilsTest.2Named", ClassUtils.getShortClassName(Named.class)); 
     assertEquals("ClassUtilsTest.Inner", ClassUtils.getShortClassName(Inner.class)); 
 }
@Test
public void test_getPackageCanonicalName_Object3562() { 
     assertEquals("<null>", ClassUtils.getPackageCanonicalName(null, "<null>")); 
     assertEquals("org.apache.commons.lang3", ClassUtils.getPackageCanonicalName(new ClassUtils(), "<null>")); 
     assertEquals("org.apache.commons.lang3", ClassUtils.getPackageCanonicalName(new ClassUtils[0], "<null>")); 
     assertEquals("org.apache.commons.lang3", ClassUtils.getPackageCanonicalName(new ClassUtils[0][0], "<null>")); 
     assertEquals("", ClassUtils.getPackageCanonicalName(new int[0], "<null>")); 
     assertEquals("", ClassUtils.getPackageCanonicalName(new int[0][0], "<null>")); 
     class Named extends Object { 
     } 
     assertEquals("org.apache.commons.lang3", ClassUtils.getPackageCanonicalName(new Object() { 
     }, "<null>")); 
     assertEquals("org.apache.commons.lang3", ClassUtils.getPackageCanonicalName(new Named(), "<null>")); 
     assertEquals("org.apache.commons.lang3", ClassUtils.getPackageCanonicalName(new Inner(), "<null>")); 
 }
@Test
public void test_getAllInterfaces_Class3606() { 
     final List<?> list = ClassUtils.getAllInterfaces(CY.class); 
     assertEquals(6, list.size()); 
     assertEquals(IB.class, list.get(0)); 
     assertEquals(IC.class, list.get(1)); 
     assertEquals(ID.class, list.get(2)); 
     assertEquals(IE.class, list.get(3)); 
     assertEquals(IF.class, list.get(4)); 
     assertEquals(IA.class, list.get(5)); 
     assertEquals(null, ClassUtils.getAllInterfaces(null)); 
 }
@Test
public void testGetClassByNormalNameArrays2D3646() throws ClassNotFoundException { 
     assertEquals(int[][].class, ClassUtils.getClass("int[][]")); 
     assertEquals(long[][].class, ClassUtils.getClass("long[][]")); 
     assertEquals(short[][].class, ClassUtils.getClass("short[][]")); 
     assertEquals(byte[][].class, ClassUtils.getClass("byte[][]")); 
     assertEquals(char[][].class, ClassUtils.getClass("char[][]")); 
     assertEquals(float[][].class, ClassUtils.getClass("float[][]")); 
     assertEquals(double[][].class, ClassUtils.getClass("double[][]")); 
     assertEquals(boolean[][].class, ClassUtils.getClass("boolean[][]")); 
     assertEquals(String[][].class, ClassUtils.getClass("java.lang.String[][]")); 
 }
@Test
public void test_isAssignable_ClassArray_ClassArray_Autoboxing3689() throws Exception { 
     final Class<?>[] array2 = new Class[] { Object.class, Object.class }; 
     final Class<?>[] array1 = new Class[] { Object.class }; 
     final Class<?>[] array1s = new Class[] { String.class }; 
     final Class<?>[] array0 = new Class[] {}; 
     final Class<?>[] arrayPrimitives = { Integer.TYPE, Boolean.TYPE }; 
     final Class<?>[] arrayWrappers = { Integer.class, Boolean.class }; 
     assertFalse(ClassUtils.isAssignable(array1, array2, true)); 
     assertFalse(ClassUtils.isAssignable(null, array2, true)); 
     assertTrue(ClassUtils.isAssignable(null, array0, true)); 
     assertTrue(ClassUtils.isAssignable(array0, array0, true)); 
     assertTrue(ClassUtils.isAssignable(array0, null, true)); 
     assertTrue(ClassUtils.isAssignable((Class[]) null, (Class[]) null, true)); 
     assertFalse(ClassUtils.isAssignable(array1, array1s, true)); 
     assertTrue(ClassUtils.isAssignable(array1s, array1s, true)); 
     assertTrue(ClassUtils.isAssignable(array1s, array1, true)); 
     assertTrue(ClassUtils.isAssignable(arrayPrimitives, arrayWrappers, true)); 
     assertTrue(ClassUtils.isAssignable(arrayWrappers, arrayPrimitives, true)); 
     assertFalse(ClassUtils.isAssignable(arrayPrimitives, array1, true)); 
     assertFalse(ClassUtils.isAssignable(arrayWrappers, array1, true)); 
     assertTrue(ClassUtils.isAssignable(arrayPrimitives, array2, true)); 
     assertTrue(ClassUtils.isAssignable(arrayWrappers, array2, true)); 
 }
@Test
public void test_getPackageName_Class3704() { 
     assertEquals("java.lang", ClassUtils.getPackageName(String.class)); 
     assertEquals("java.util", ClassUtils.getPackageName(Map.Entry.class)); 
     assertEquals("", ClassUtils.getPackageName((Class<?>) null)); 
     assertEquals("java.lang", ClassUtils.getPackageName(String[].class)); 
     assertEquals("", ClassUtils.getPackageName(boolean[].class)); 
     assertEquals("", ClassUtils.getPackageName(byte[].class)); 
     assertEquals("", ClassUtils.getPackageName(char[].class)); 
     assertEquals("", ClassUtils.getPackageName(short[].class)); 
     assertEquals("", ClassUtils.getPackageName(int[].class)); 
     assertEquals("", ClassUtils.getPackageName(long[].class)); 
     assertEquals("", ClassUtils.getPackageName(float[].class)); 
     assertEquals("", ClassUtils.getPackageName(double[].class)); 
     assertEquals("java.lang", ClassUtils.getPackageName(String[][].class)); 
     assertEquals("java.lang", ClassUtils.getPackageName(String[][][].class)); 
     assertEquals("java.lang", ClassUtils.getPackageName(String[][][][].class)); 
     class Named extends Object { 
     } 
     assertEquals("org.apache.commons.lang3", ClassUtils.getPackageName(new Object() { 
     }.getClass())); 
     assertEquals("org.apache.commons.lang3", ClassUtils.getPackageName(Named.class)); 
 }
@Test
public void test_isAssignable_ClassArray_ClassArray_Autoboxing3791() throws Exception { 
     final Class<?>[] array2 = new Class[] { Object.class, Object.class }; 
     final Class<?>[] array1 = new Class[] { Object.class }; 
     final Class<?>[] array1s = new Class[] { String.class }; 
     final Class<?>[] array0 = new Class[] {}; 
     final Class<?>[] arrayPrimitives = { Integer.TYPE, Boolean.TYPE }; 
     final Class<?>[] arrayWrappers = { Integer.class, Boolean.class }; 
     assertFalse(ClassUtils.isAssignable(array1, array2, true)); 
     assertFalse(ClassUtils.isAssignable(null, array2, true)); 
     assertTrue(ClassUtils.isAssignable(null, array0, true)); 
     assertTrue(ClassUtils.isAssignable(array0, array0, true)); 
     assertTrue(ClassUtils.isAssignable(array0, null, true)); 
     assertTrue(ClassUtils.isAssignable((Class[]) null, (Class[]) null, true)); 
     assertFalse(ClassUtils.isAssignable(array1, array1s, true)); 
     assertTrue(ClassUtils.isAssignable(array1s, array1s, true)); 
     assertTrue(ClassUtils.isAssignable(array1s, array1, true)); 
     assertTrue(ClassUtils.isAssignable(arrayPrimitives, arrayWrappers, true)); 
     assertTrue(ClassUtils.isAssignable(arrayWrappers, arrayPrimitives, true)); 
     assertFalse(ClassUtils.isAssignable(arrayPrimitives, array1, true)); 
     assertFalse(ClassUtils.isAssignable(arrayWrappers, array1, true)); 
     assertTrue(ClassUtils.isAssignable(arrayPrimitives, array2, true)); 
     assertTrue(ClassUtils.isAssignable(arrayWrappers, array2, true)); 
 }
@Test
public void test_getShortCanonicalName_String3951() { 
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
public void test_isAssignable_ClassArray_ClassArray_Autoboxing3973() throws Exception { 
     final Class<?>[] array2 = new Class[] { Object.class, Object.class }; 
     final Class<?>[] array1 = new Class[] { Object.class }; 
     final Class<?>[] array1s = new Class[] { String.class }; 
     final Class<?>[] array0 = new Class[] {}; 
     final Class<?>[] arrayPrimitives = { Integer.TYPE, Boolean.TYPE }; 
     final Class<?>[] arrayWrappers = { Integer.class, Boolean.class }; 
     assertFalse(ClassUtils.isAssignable(array1, array2, true)); 
     assertFalse(ClassUtils.isAssignable(null, array2, true)); 
     assertTrue(ClassUtils.isAssignable(null, array0, true)); 
     assertTrue(ClassUtils.isAssignable(array0, array0, true)); 
     assertTrue(ClassUtils.isAssignable(array0, null, true)); 
     assertTrue(ClassUtils.isAssignable((Class[]) null, (Class[]) null, true)); 
     assertFalse(ClassUtils.isAssignable(array1, array1s, true)); 
     assertTrue(ClassUtils.isAssignable(array1s, array1s, true)); 
     assertTrue(ClassUtils.isAssignable(array1s, array1, true)); 
     assertTrue(ClassUtils.isAssignable(arrayPrimitives, arrayWrappers, true)); 
     assertTrue(ClassUtils.isAssignable(arrayWrappers, arrayPrimitives, true)); 
     assertFalse(ClassUtils.isAssignable(arrayPrimitives, array1, true)); 
     assertFalse(ClassUtils.isAssignable(arrayWrappers, array1, true)); 
     assertTrue(ClassUtils.isAssignable(arrayPrimitives, array2, true)); 
     assertTrue(ClassUtils.isAssignable(arrayWrappers, array2, true)); 
 }
@Test
public void test_getShortClassName_Class3984() { 
     assertEquals("ClassUtils", ClassUtils.getShortClassName(ClassUtils.class)); 
     assertEquals("Map.Entry", ClassUtils.getShortClassName(Map.Entry.class)); 
     assertEquals("", ClassUtils.getShortClassName((Class<?>) null)); 
     assertEquals("String[]", ClassUtils.getShortClassName(String[].class)); 
     assertEquals("Map.Entry[]", ClassUtils.getShortClassName(Map.Entry[].class)); 
     assertEquals("boolean", ClassUtils.getShortClassName(boolean.class)); 
     assertEquals("byte", ClassUtils.getShortClassName(byte.class)); 
     assertEquals("char", ClassUtils.getShortClassName(char.class)); 
     assertEquals("short", ClassUtils.getShortClassName(short.class)); 
     assertEquals("int", ClassUtils.getShortClassName(int.class)); 
     assertEquals("long", ClassUtils.getShortClassName(long.class)); 
     assertEquals("float", ClassUtils.getShortClassName(float.class)); 
     assertEquals("double", ClassUtils.getShortClassName(double.class)); 
     assertEquals("boolean[]", ClassUtils.getShortClassName(boolean[].class)); 
     assertEquals("byte[]", ClassUtils.getShortClassName(byte[].class)); 
     assertEquals("char[]", ClassUtils.getShortClassName(char[].class)); 
     assertEquals("short[]", ClassUtils.getShortClassName(short[].class)); 
     assertEquals("int[]", ClassUtils.getShortClassName(int[].class)); 
     assertEquals("long[]", ClassUtils.getShortClassName(long[].class)); 
     assertEquals("float[]", ClassUtils.getShortClassName(float[].class)); 
     assertEquals("double[]", ClassUtils.getShortClassName(double[].class)); 
     assertEquals("String[][]", ClassUtils.getShortClassName(String[][].class)); 
     assertEquals("String[][][]", ClassUtils.getShortClassName(String[][][].class)); 
     assertEquals("String[][][][]", ClassUtils.getShortClassName(String[][][][].class)); 
     class Named extends Object { 
     } 
     assertEquals("ClassUtilsTest.2", ClassUtils.getShortClassName(new Object() { 
     }.getClass())); 
     assertEquals("ClassUtilsTest.2Named", ClassUtils.getShortClassName(Named.class)); 
     assertEquals("ClassUtilsTest.Inner", ClassUtils.getShortClassName(Inner.class)); 
 }
@Test
public void test_getShortCanonicalName_Class3985() { 
     assertEquals("ClassUtils", ClassUtils.getShortCanonicalName(ClassUtils.class)); 
     assertEquals("ClassUtils[]", ClassUtils.getShortCanonicalName(ClassUtils[].class)); 
     assertEquals("ClassUtils[][]", ClassUtils.getShortCanonicalName(ClassUtils[][].class)); 
     assertEquals("int[]", ClassUtils.getShortCanonicalName(int[].class)); 
     assertEquals("int[][]", ClassUtils.getShortCanonicalName(int[][].class)); 
     class Named extends Object { 
     } 
     assertEquals("ClassUtilsTest.7", ClassUtils.getShortCanonicalName(new Object() { 
     }.getClass())); 
     assertEquals("ClassUtilsTest.6Named", ClassUtils.getShortCanonicalName(Named.class)); 
     assertEquals("ClassUtilsTest.Inner", ClassUtils.getShortCanonicalName(Inner.class)); 
 }
@Test
public void test_getSimpleName_Object3993() { 
     assertEquals("ClassUtils", ClassUtils.getSimpleName(new ClassUtils(), "<null>")); 
     assertEquals("Inner", ClassUtils.getSimpleName(new Inner(), "<null>")); 
     assertEquals("String", ClassUtils.getSimpleName("hello", "<null>")); 
     assertEquals("<null>", ClassUtils.getSimpleName(null, "<null>")); 
 }
@Test
public void testGetClassByNormalNameArrays2D4019() throws ClassNotFoundException { 
     assertEquals(int[][].class, ClassUtils.getClass("int[][]")); 
     assertEquals(long[][].class, ClassUtils.getClass("long[][]")); 
     assertEquals(short[][].class, ClassUtils.getClass("short[][]")); 
     assertEquals(byte[][].class, ClassUtils.getClass("byte[][]")); 
     assertEquals(char[][].class, ClassUtils.getClass("char[][]")); 
     assertEquals(float[][].class, ClassUtils.getClass("float[][]")); 
     assertEquals(double[][].class, ClassUtils.getClass("double[][]")); 
     assertEquals(boolean[][].class, ClassUtils.getClass("boolean[][]")); 
     assertEquals(String[][].class, ClassUtils.getClass("java.lang.String[][]")); 
 }
@Test
public void testGetClassRawPrimitives4137() throws ClassNotFoundException { 
     assertEquals(int.class, ClassUtils.getClass("int")); 
     assertEquals(long.class, ClassUtils.getClass("long")); 
     assertEquals(short.class, ClassUtils.getClass("short")); 
     assertEquals(byte.class, ClassUtils.getClass("byte")); 
     assertEquals(char.class, ClassUtils.getClass("char")); 
     assertEquals(float.class, ClassUtils.getClass("float")); 
     assertEquals(double.class, ClassUtils.getClass("double")); 
     assertEquals(boolean.class, ClassUtils.getClass("boolean")); 
 }
@Test
public void test_getShortClassName_String4346() { 
     assertEquals("ClassUtils", ClassUtils.getShortClassName(ClassUtils.class.getName())); 
     assertEquals("Map.Entry", ClassUtils.getShortClassName(Map.Entry.class.getName())); 
     assertEquals("", ClassUtils.getShortClassName((String) null)); 
     assertEquals("", ClassUtils.getShortClassName("")); 
 }
@Test
public void testToClass_object4453() { 
     assertNull(ClassUtils.toClass((Object[]) null)); 
     assertTrue("empty -> empty", Arrays.equals(ArrayUtils.EMPTY_CLASS_ARRAY, ClassUtils.toClass())); 
     final Class<?>[] castNull = ClassUtils.toClass((Object) null); 
     assertTrue("(Object)null -> [null]", Arrays.equals(new Object[] { null }, castNull)); 
     assertSame(ArrayUtils.EMPTY_CLASS_ARRAY, ClassUtils.toClass(ArrayUtils.EMPTY_OBJECT_ARRAY)); 
     assertTrue(Arrays.equals(new Class[] { String.class, Integer.class, Double.class }, ClassUtils.toClass(new Object[] { "Test", Integer.valueOf(1), Double.valueOf(99d) }))); 
     assertTrue(Arrays.equals(new Class[] { String.class, null, Double.class }, ClassUtils.toClass(new Object[] { "Test", null, Double.valueOf(99d) }))); 
 }
@Test
public void testGetClassByNormalNameArrays2D4457() throws ClassNotFoundException { 
     assertEquals(int[][].class, ClassUtils.getClass("int[][]")); 
     assertEquals(long[][].class, ClassUtils.getClass("long[][]")); 
     assertEquals(short[][].class, ClassUtils.getClass("short[][]")); 
     assertEquals(byte[][].class, ClassUtils.getClass("byte[][]")); 
     assertEquals(char[][].class, ClassUtils.getClass("char[][]")); 
     assertEquals(float[][].class, ClassUtils.getClass("float[][]")); 
     assertEquals(double[][].class, ClassUtils.getClass("double[][]")); 
     assertEquals(boolean[][].class, ClassUtils.getClass("boolean[][]")); 
     assertEquals(String[][].class, ClassUtils.getClass("java.lang.String[][]")); 
 }
@Test
public void test_getShortCanonicalName_String4474() { 
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
public void test_getShortCanonicalName_String4499() { 
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
public void testGetClassByNormalNameArrays2D4689() throws ClassNotFoundException { 
     assertEquals(int[][].class, ClassUtils.getClass("int[][]")); 
     assertEquals(long[][].class, ClassUtils.getClass("long[][]")); 
     assertEquals(short[][].class, ClassUtils.getClass("short[][]")); 
     assertEquals(byte[][].class, ClassUtils.getClass("byte[][]")); 
     assertEquals(char[][].class, ClassUtils.getClass("char[][]")); 
     assertEquals(float[][].class, ClassUtils.getClass("float[][]")); 
     assertEquals(double[][].class, ClassUtils.getClass("double[][]")); 
     assertEquals(boolean[][].class, ClassUtils.getClass("boolean[][]")); 
     assertEquals(String[][].class, ClassUtils.getClass("java.lang.String[][]")); 
 }
@Test
public void testGetPublicMethod4790() throws Exception { 
     final Set<?> set = Collections.unmodifiableSet(new HashSet<Object>()); 
     final Method isEmptyMethod = ClassUtils.getPublicMethod(set.getClass(), "isEmpty", new Class[0]); 
     assertTrue(Modifier.isPublic(isEmptyMethod.getDeclaringClass().getModifiers())); 
     try { 
         isEmptyMethod.invoke(set, new Object[0]); 
     } catch (final java.lang.IllegalAccessException iae) { 
         fail("Should not have thrown IllegalAccessException"); 
     } 
     final Method toStringMethod = ClassUtils.getPublicMethod(Object.class, "toString", new Class[0]); 
     assertEquals(Object.class.getMethod("toString", new Class[0]), toStringMethod); 
 }
@Test
public void test_getShortCanonicalName_Object4801() { 
     assertEquals("<null>", ClassUtils.getShortCanonicalName(null, "<null>")); 
     assertEquals("ClassUtils", ClassUtils.getShortCanonicalName(new ClassUtils(), "<null>")); 
     assertEquals("ClassUtils[]", ClassUtils.getShortCanonicalName(new ClassUtils[0], "<null>")); 
     assertEquals("ClassUtils[][]", ClassUtils.getShortCanonicalName(new ClassUtils[0][0], "<null>")); 
     assertEquals("int[]", ClassUtils.getShortCanonicalName(new int[0], "<null>")); 
     assertEquals("int[][]", ClassUtils.getShortCanonicalName(new int[0][0], "<null>")); 
     class Named extends Object { 
     } 
     assertEquals("ClassUtilsTest.6", ClassUtils.getShortCanonicalName(new Object() { 
     }, "<null>")); 
     assertEquals("ClassUtilsTest.5Named", ClassUtils.getShortCanonicalName(new Named(), "<null>")); 
     assertEquals("ClassUtilsTest.Inner", ClassUtils.getShortCanonicalName(new Inner(), "<null>")); 
 }
@Test
public void test_getPackageName_Class4830() { 
     assertEquals("java.lang", ClassUtils.getPackageName(String.class)); 
     assertEquals("java.util", ClassUtils.getPackageName(Map.Entry.class)); 
     assertEquals("", ClassUtils.getPackageName((Class<?>) null)); 
     assertEquals("java.lang", ClassUtils.getPackageName(String[].class)); 
     assertEquals("", ClassUtils.getPackageName(boolean[].class)); 
     assertEquals("", ClassUtils.getPackageName(byte[].class)); 
     assertEquals("", ClassUtils.getPackageName(char[].class)); 
     assertEquals("", ClassUtils.getPackageName(short[].class)); 
     assertEquals("", ClassUtils.getPackageName(int[].class)); 
     assertEquals("", ClassUtils.getPackageName(long[].class)); 
     assertEquals("", ClassUtils.getPackageName(float[].class)); 
     assertEquals("", ClassUtils.getPackageName(double[].class)); 
     assertEquals("java.lang", ClassUtils.getPackageName(String[][].class)); 
     assertEquals("java.lang", ClassUtils.getPackageName(String[][][].class)); 
     assertEquals("java.lang", ClassUtils.getPackageName(String[][][][].class)); 
     class Named extends Object { 
     } 
     assertEquals("org.apache.commons.lang3", ClassUtils.getPackageName(new Object() { 
     }.getClass())); 
     assertEquals("org.apache.commons.lang3", ClassUtils.getPackageName(Named.class)); 
 }
@Test
public void test_getShortClassName_String4892() { 
     assertEquals("ClassUtils", ClassUtils.getShortClassName(ClassUtils.class.getName())); 
     assertEquals("Map.Entry", ClassUtils.getShortClassName(Map.Entry.class.getName())); 
     assertEquals("", ClassUtils.getShortClassName((String) null)); 
     assertEquals("", ClassUtils.getShortClassName("")); 
 }
@Test
public void test_getShortCanonicalName_String4913() { 
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
public void test_convertClassNamesToClasses_List4948() { 
     final List<String> list = new ArrayList<String>(); 
     List<Class<?>> result = ClassUtils.convertClassNamesToClasses(list); 
     assertEquals(0, result.size()); 
     list.add("java.lang.String"); 
     list.add("java.lang.xxx"); 
     list.add("java.lang.Object"); 
     result = ClassUtils.convertClassNamesToClasses(list); 
     assertEquals(3, result.size()); 
     assertEquals(String.class, result.get(0)); 
     assertEquals(null, result.get(1)); 
     assertEquals(Object.class, result.get(2)); 
     @SuppressWarnings("unchecked") 
     final List<Object> olist = (List<Object>) (List<?>) list; 
     olist.add(new Object()); 
     try { 
         ClassUtils.convertClassNamesToClasses(list); 
         fail("Should not have been able to convert list"); 
     } catch (final ClassCastException expected) { 
     } 
     assertEquals(null, ClassUtils.convertClassNamesToClasses(null)); 
 }
@Test
public void test_isAssignable_ClassArray_ClassArray4997() throws Exception { 
     final Class<?>[] array2 = new Class[] { Object.class, Object.class }; 
     final Class<?>[] array1 = new Class[] { Object.class }; 
     final Class<?>[] array1s = new Class[] { String.class }; 
     final Class<?>[] array0 = new Class[] {}; 
     final Class<?>[] arrayPrimitives = { Integer.TYPE, Boolean.TYPE }; 
     final Class<?>[] arrayWrappers = { Integer.class, Boolean.class }; 
     assertFalse(ClassUtils.isAssignable(array1, array2)); 
     assertFalse(ClassUtils.isAssignable(null, array2)); 
     assertTrue(ClassUtils.isAssignable(null, array0)); 
     assertTrue(ClassUtils.isAssignable(array0, array0)); 
     assertTrue(ClassUtils.isAssignable(array0, (Class<?>[]) null)); 
     assertTrue(ClassUtils.isAssignable((Class[]) null, (Class[]) null)); 
     assertFalse(ClassUtils.isAssignable(array1, array1s)); 
     assertTrue(ClassUtils.isAssignable(array1s, array1s)); 
     assertTrue(ClassUtils.isAssignable(array1s, array1)); 
     final boolean autoboxing = SystemUtils.isJavaVersionAtLeast(JAVA_1_5); 
     assertEquals(autoboxing, ClassUtils.isAssignable(arrayPrimitives, arrayWrappers)); 
     assertEquals(autoboxing, ClassUtils.isAssignable(arrayWrappers, arrayPrimitives)); 
     assertFalse(ClassUtils.isAssignable(arrayPrimitives, array1)); 
     assertFalse(ClassUtils.isAssignable(arrayWrappers, array1)); 
     assertEquals(autoboxing, ClassUtils.isAssignable(arrayPrimitives, array2)); 
     assertTrue(ClassUtils.isAssignable(arrayWrappers, array2)); 
 }
@Test
public void testWrappersToPrimitivesNull5036() { 
     assertNull("Wrong result for null input", ClassUtils.wrappersToPrimitives((Class<?>[]) null)); 
     assertTrue("empty -> empty", Arrays.equals(ArrayUtils.EMPTY_CLASS_ARRAY, ClassUtils.wrappersToPrimitives())); 
     final Class<?>[] castNull = ClassUtils.wrappersToPrimitives((Class<?>) null); 
     assertTrue("(Class<?>)null -> [null]", Arrays.equals(new Class<?>[] { null }, castNull)); 
 }
@Test
public void testGetPublicMethod5058() throws Exception { 
     final Set<?> set = Collections.unmodifiableSet(new HashSet<Object>()); 
     final Method isEmptyMethod = ClassUtils.getPublicMethod(set.getClass(), "isEmpty", new Class[0]); 
     assertTrue(Modifier.isPublic(isEmptyMethod.getDeclaringClass().getModifiers())); 
     try { 
         isEmptyMethod.invoke(set, new Object[0]); 
     } catch (final java.lang.IllegalAccessException iae) { 
         fail("Should not have thrown IllegalAccessException"); 
     } 
     final Method toStringMethod = ClassUtils.getPublicMethod(Object.class, "toString", new Class[0]); 
     assertEquals(Object.class.getMethod("toString", new Class[0]), toStringMethod); 
 }
@Test
public void test_getPackageName_Object5064() { 
     assertEquals("org.apache.commons.lang3", ClassUtils.getPackageName(new ClassUtils(), "<null>")); 
     assertEquals("org.apache.commons.lang3", ClassUtils.getPackageName(new Inner(), "<null>")); 
     assertEquals("<null>", ClassUtils.getPackageName(null, "<null>")); 
 }
@Test
public void test_getShortCanonicalName_String5095() { 
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
public void test_getPackageName_Class5096() { 
     assertEquals("java.lang", ClassUtils.getPackageName(String.class)); 
     assertEquals("java.util", ClassUtils.getPackageName(Map.Entry.class)); 
     assertEquals("", ClassUtils.getPackageName((Class<?>) null)); 
     assertEquals("java.lang", ClassUtils.getPackageName(String[].class)); 
     assertEquals("", ClassUtils.getPackageName(boolean[].class)); 
     assertEquals("", ClassUtils.getPackageName(byte[].class)); 
     assertEquals("", ClassUtils.getPackageName(char[].class)); 
     assertEquals("", ClassUtils.getPackageName(short[].class)); 
     assertEquals("", ClassUtils.getPackageName(int[].class)); 
     assertEquals("", ClassUtils.getPackageName(long[].class)); 
     assertEquals("", ClassUtils.getPackageName(float[].class)); 
     assertEquals("", ClassUtils.getPackageName(double[].class)); 
     assertEquals("java.lang", ClassUtils.getPackageName(String[][].class)); 
     assertEquals("java.lang", ClassUtils.getPackageName(String[][][].class)); 
     assertEquals("java.lang", ClassUtils.getPackageName(String[][][][].class)); 
     class Named extends Object { 
     } 
     assertEquals("org.apache.commons.lang3", ClassUtils.getPackageName(new Object() { 
     }.getClass())); 
     assertEquals("org.apache.commons.lang3", ClassUtils.getPackageName(Named.class)); 
 }
@Test
public void test_getShortClassName_String5118() { 
     assertEquals("ClassUtils", ClassUtils.getShortClassName(ClassUtils.class.getName())); 
     assertEquals("Map.Entry", ClassUtils.getShortClassName(Map.Entry.class.getName())); 
     assertEquals("", ClassUtils.getShortClassName((String) null)); 
     assertEquals("", ClassUtils.getShortClassName("")); 
 }
@Test
public void testIsPrimitiveOrWrapper5165() { 
     assertTrue("Boolean.class", ClassUtils.isPrimitiveOrWrapper(Boolean.class)); 
     assertTrue("Byte.class", ClassUtils.isPrimitiveOrWrapper(Byte.class)); 
     assertTrue("Character.class", ClassUtils.isPrimitiveOrWrapper(Character.class)); 
     assertTrue("Short.class", ClassUtils.isPrimitiveOrWrapper(Short.class)); 
     assertTrue("Integer.class", ClassUtils.isPrimitiveOrWrapper(Integer.class)); 
     assertTrue("Long.class", ClassUtils.isPrimitiveOrWrapper(Long.class)); 
     assertTrue("Double.class", ClassUtils.isPrimitiveOrWrapper(Double.class)); 
     assertTrue("Float.class", ClassUtils.isPrimitiveOrWrapper(Float.class)); 
     assertTrue("boolean", ClassUtils.isPrimitiveOrWrapper(Boolean.TYPE)); 
     assertTrue("byte", ClassUtils.isPrimitiveOrWrapper(Byte.TYPE)); 
     assertTrue("char", ClassUtils.isPrimitiveOrWrapper(Character.TYPE)); 
     assertTrue("short", ClassUtils.isPrimitiveOrWrapper(Short.TYPE)); 
     assertTrue("int", ClassUtils.isPrimitiveOrWrapper(Integer.TYPE)); 
     assertTrue("long", ClassUtils.isPrimitiveOrWrapper(Long.TYPE)); 
     assertTrue("double", ClassUtils.isPrimitiveOrWrapper(Double.TYPE)); 
     assertTrue("float", ClassUtils.isPrimitiveOrWrapper(Float.TYPE)); 
     assertTrue("Void.TYPE", ClassUtils.isPrimitiveOrWrapper(Void.TYPE)); 
     assertFalse("null", ClassUtils.isPrimitiveOrWrapper(null)); 
     assertFalse("Void.class", ClassUtils.isPrimitiveOrWrapper(Void.class)); 
     assertFalse("String.class", ClassUtils.isPrimitiveOrWrapper(String.class)); 
     assertFalse("this.getClass()", ClassUtils.isPrimitiveOrWrapper(this.getClass())); 
 }
@Test
public void test_isInnerClass_Class5178() { 
     assertTrue(ClassUtils.isInnerClass(Inner.class)); 
     assertTrue(ClassUtils.isInnerClass(Map.Entry.class)); 
     assertTrue(ClassUtils.isInnerClass(new Cloneable() { 
     }.getClass())); 
     assertFalse(ClassUtils.isInnerClass(this.getClass())); 
     assertFalse(ClassUtils.isInnerClass(String.class)); 
     assertFalse(ClassUtils.isInnerClass(null)); 
 }
@Test
public void test_getShortCanonicalName_String5195() { 
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
public void testGetPublicMethod5207() throws Exception { 
     final Set<?> set = Collections.unmodifiableSet(new HashSet<Object>()); 
     final Method isEmptyMethod = ClassUtils.getPublicMethod(set.getClass(), "isEmpty", new Class[0]); 
     assertTrue(Modifier.isPublic(isEmptyMethod.getDeclaringClass().getModifiers())); 
     try { 
         isEmptyMethod.invoke(set, new Object[0]); 
     } catch (final java.lang.IllegalAccessException iae) { 
         fail("Should not have thrown IllegalAccessException"); 
     } 
     final Method toStringMethod = ClassUtils.getPublicMethod(Object.class, "toString", new Class[0]); 
     assertEquals(Object.class.getMethod("toString", new Class[0]), toStringMethod); 
 }
@Test
public void test_getPackageName_Class5210() { 
     assertEquals("java.lang", ClassUtils.getPackageName(String.class)); 
     assertEquals("java.util", ClassUtils.getPackageName(Map.Entry.class)); 
     assertEquals("", ClassUtils.getPackageName((Class<?>) null)); 
     assertEquals("java.lang", ClassUtils.getPackageName(String[].class)); 
     assertEquals("", ClassUtils.getPackageName(boolean[].class)); 
     assertEquals("", ClassUtils.getPackageName(byte[].class)); 
     assertEquals("", ClassUtils.getPackageName(char[].class)); 
     assertEquals("", ClassUtils.getPackageName(short[].class)); 
     assertEquals("", ClassUtils.getPackageName(int[].class)); 
     assertEquals("", ClassUtils.getPackageName(long[].class)); 
     assertEquals("", ClassUtils.getPackageName(float[].class)); 
     assertEquals("", ClassUtils.getPackageName(double[].class)); 
     assertEquals("java.lang", ClassUtils.getPackageName(String[][].class)); 
     assertEquals("java.lang", ClassUtils.getPackageName(String[][][].class)); 
     assertEquals("java.lang", ClassUtils.getPackageName(String[][][][].class)); 
     class Named extends Object { 
     } 
     assertEquals("org.apache.commons.lang3", ClassUtils.getPackageName(new Object() { 
     }.getClass())); 
     assertEquals("org.apache.commons.lang3", ClassUtils.getPackageName(Named.class)); 
 }
@Test
public void test_getShortCanonicalName_String5213() { 
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
public void testGetClassByNormalNameArrays2D5243() throws ClassNotFoundException { 
     assertEquals(int[][].class, ClassUtils.getClass("int[][]")); 
     assertEquals(long[][].class, ClassUtils.getClass("long[][]")); 
     assertEquals(short[][].class, ClassUtils.getClass("short[][]")); 
     assertEquals(byte[][].class, ClassUtils.getClass("byte[][]")); 
     assertEquals(char[][].class, ClassUtils.getClass("char[][]")); 
     assertEquals(float[][].class, ClassUtils.getClass("float[][]")); 
     assertEquals(double[][].class, ClassUtils.getClass("double[][]")); 
     assertEquals(boolean[][].class, ClassUtils.getClass("boolean[][]")); 
     assertEquals(String[][].class, ClassUtils.getClass("java.lang.String[][]")); 
 }
@Test
public void test_convertClassNamesToClasses_List5265() { 
     final List<String> list = new ArrayList<String>(); 
     List<Class<?>> result = ClassUtils.convertClassNamesToClasses(list); 
     assertEquals(0, result.size()); 
     list.add("java.lang.String"); 
     list.add("java.lang.xxx"); 
     list.add("java.lang.Object"); 
     result = ClassUtils.convertClassNamesToClasses(list); 
     assertEquals(3, result.size()); 
     assertEquals(String.class, result.get(0)); 
     assertEquals(null, result.get(1)); 
     assertEquals(Object.class, result.get(2)); 
     @SuppressWarnings("unchecked") 
     final List<Object> olist = (List<Object>) (List<?>) list; 
     olist.add(new Object()); 
     try { 
         ClassUtils.convertClassNamesToClasses(list); 
         fail("Should not have been able to convert list"); 
     } catch (final ClassCastException expected) { 
     } 
     assertEquals(null, ClassUtils.convertClassNamesToClasses(null)); 
 }
@Test
public void testGetPublicMethod5271() throws Exception { 
     final Set<?> set = Collections.unmodifiableSet(new HashSet<Object>()); 
     final Method isEmptyMethod = ClassUtils.getPublicMethod(set.getClass(), "isEmpty", new Class[0]); 
     assertTrue(Modifier.isPublic(isEmptyMethod.getDeclaringClass().getModifiers())); 
     try { 
         isEmptyMethod.invoke(set, new Object[0]); 
     } catch (final java.lang.IllegalAccessException iae) { 
         fail("Should not have thrown IllegalAccessException"); 
     } 
     final Method toStringMethod = ClassUtils.getPublicMethod(Object.class, "toString", new Class[0]); 
     assertEquals(Object.class.getMethod("toString", new Class[0]), toStringMethod); 
 }
@Test
public void test_getShortClassName_Class5302() { 
     assertEquals("ClassUtils", ClassUtils.getShortClassName(ClassUtils.class)); 
     assertEquals("Map.Entry", ClassUtils.getShortClassName(Map.Entry.class)); 
     assertEquals("", ClassUtils.getShortClassName((Class<?>) null)); 
     assertEquals("String[]", ClassUtils.getShortClassName(String[].class)); 
     assertEquals("Map.Entry[]", ClassUtils.getShortClassName(Map.Entry[].class)); 
     assertEquals("boolean", ClassUtils.getShortClassName(boolean.class)); 
     assertEquals("byte", ClassUtils.getShortClassName(byte.class)); 
     assertEquals("char", ClassUtils.getShortClassName(char.class)); 
     assertEquals("short", ClassUtils.getShortClassName(short.class)); 
     assertEquals("int", ClassUtils.getShortClassName(int.class)); 
     assertEquals("long", ClassUtils.getShortClassName(long.class)); 
     assertEquals("float", ClassUtils.getShortClassName(float.class)); 
     assertEquals("double", ClassUtils.getShortClassName(double.class)); 
     assertEquals("boolean[]", ClassUtils.getShortClassName(boolean[].class)); 
     assertEquals("byte[]", ClassUtils.getShortClassName(byte[].class)); 
     assertEquals("char[]", ClassUtils.getShortClassName(char[].class)); 
     assertEquals("short[]", ClassUtils.getShortClassName(short[].class)); 
     assertEquals("int[]", ClassUtils.getShortClassName(int[].class)); 
     assertEquals("long[]", ClassUtils.getShortClassName(long[].class)); 
     assertEquals("float[]", ClassUtils.getShortClassName(float[].class)); 
     assertEquals("double[]", ClassUtils.getShortClassName(double[].class)); 
     assertEquals("String[][]", ClassUtils.getShortClassName(String[][].class)); 
     assertEquals("String[][][]", ClassUtils.getShortClassName(String[][][].class)); 
     assertEquals("String[][][][]", ClassUtils.getShortClassName(String[][][][].class)); 
     class Named extends Object { 
     } 
     assertEquals("ClassUtilsTest.2", ClassUtils.getShortClassName(new Object() { 
     }.getClass())); 
     assertEquals("ClassUtilsTest.2Named", ClassUtils.getShortClassName(Named.class)); 
     assertEquals("ClassUtilsTest.Inner", ClassUtils.getShortClassName(Inner.class)); 
 }
@Test
public void testGetPublicMethod5330() throws Exception { 
     final Set<?> set = Collections.unmodifiableSet(new HashSet<Object>()); 
     final Method isEmptyMethod = ClassUtils.getPublicMethod(set.getClass(), "isEmpty", new Class[0]); 
     assertTrue(Modifier.isPublic(isEmptyMethod.getDeclaringClass().getModifiers())); 
     try { 
         isEmptyMethod.invoke(set, new Object[0]); 
     } catch (final java.lang.IllegalAccessException iae) { 
         fail("Should not have thrown IllegalAccessException"); 
     } 
     final Method toStringMethod = ClassUtils.getPublicMethod(Object.class, "toString", new Class[0]); 
     assertEquals(Object.class.getMethod("toString", new Class[0]), toStringMethod); 
 }
@Test
public void testGetClassByNormalNameArrays2D5335() throws ClassNotFoundException { 
     assertEquals(int[][].class, ClassUtils.getClass("int[][]")); 
     assertEquals(long[][].class, ClassUtils.getClass("long[][]")); 
     assertEquals(short[][].class, ClassUtils.getClass("short[][]")); 
     assertEquals(byte[][].class, ClassUtils.getClass("byte[][]")); 
     assertEquals(char[][].class, ClassUtils.getClass("char[][]")); 
     assertEquals(float[][].class, ClassUtils.getClass("float[][]")); 
     assertEquals(double[][].class, ClassUtils.getClass("double[][]")); 
     assertEquals(boolean[][].class, ClassUtils.getClass("boolean[][]")); 
     assertEquals(String[][].class, ClassUtils.getClass("java.lang.String[][]")); 
 }
@Test
public void test_getShortClassName_String5355() { 
     assertEquals("ClassUtils", ClassUtils.getShortClassName(ClassUtils.class.getName())); 
     assertEquals("Map.Entry", ClassUtils.getShortClassName(Map.Entry.class.getName())); 
     assertEquals("", ClassUtils.getShortClassName((String) null)); 
     assertEquals("", ClassUtils.getShortClassName("")); 
 }
@Test
public void test_getShortCanonicalName_String5407() { 
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
public void testWrappersToPrimitivesNull5411() { 
     assertNull("Wrong result for null input", ClassUtils.wrappersToPrimitives((Class<?>[]) null)); 
     assertTrue("empty -> empty", Arrays.equals(ArrayUtils.EMPTY_CLASS_ARRAY, ClassUtils.wrappersToPrimitives())); 
     final Class<?>[] castNull = ClassUtils.wrappersToPrimitives((Class<?>) null); 
     assertTrue("(Class<?>)null -> [null]", Arrays.equals(new Class<?>[] { null }, castNull)); 
 }
@Test
public void test_getShortCanonicalName_Object5461() { 
     assertEquals("<null>", ClassUtils.getShortCanonicalName(null, "<null>")); 
     assertEquals("ClassUtils", ClassUtils.getShortCanonicalName(new ClassUtils(), "<null>")); 
     assertEquals("ClassUtils[]", ClassUtils.getShortCanonicalName(new ClassUtils[0], "<null>")); 
     assertEquals("ClassUtils[][]", ClassUtils.getShortCanonicalName(new ClassUtils[0][0], "<null>")); 
     assertEquals("int[]", ClassUtils.getShortCanonicalName(new int[0], "<null>")); 
     assertEquals("int[][]", ClassUtils.getShortCanonicalName(new int[0][0], "<null>")); 
     class Named extends Object { 
     } 
     assertEquals("ClassUtilsTest.6", ClassUtils.getShortCanonicalName(new Object() { 
     }, "<null>")); 
     assertEquals("ClassUtilsTest.5Named", ClassUtils.getShortCanonicalName(new Named(), "<null>")); 
     assertEquals("ClassUtilsTest.Inner", ClassUtils.getShortCanonicalName(new Inner(), "<null>")); 
 }
@Test
public void testGetClassInvalidArguments5475() throws Exception { 
     assertGetClassThrowsNullPointerException(null); 
     assertGetClassThrowsClassNotFound("[][][]"); 
     assertGetClassThrowsClassNotFound("[[]"); 
     assertGetClassThrowsClassNotFound("["); 
     assertGetClassThrowsClassNotFound("java.lang.String]["); 
     assertGetClassThrowsClassNotFound(".hello.world"); 
     assertGetClassThrowsClassNotFound("hello..world"); 
 }
@Test
public void testGetPublicMethod5490() throws Exception { 
     final Set<?> set = Collections.unmodifiableSet(new HashSet<Object>()); 
     final Method isEmptyMethod = ClassUtils.getPublicMethod(set.getClass(), "isEmpty", new Class[0]); 
     assertTrue(Modifier.isPublic(isEmptyMethod.getDeclaringClass().getModifiers())); 
     try { 
         isEmptyMethod.invoke(set, new Object[0]); 
     } catch (final java.lang.IllegalAccessException iae) { 
         fail("Should not have thrown IllegalAccessException"); 
     } 
     final Method toStringMethod = ClassUtils.getPublicMethod(Object.class, "toString", new Class[0]); 
     assertEquals(Object.class.getMethod("toString", new Class[0]), toStringMethod); 
 }
@Test
public void testToClass_object5515() { 
     assertNull(ClassUtils.toClass((Object[]) null)); 
     assertTrue("empty -> empty", Arrays.equals(ArrayUtils.EMPTY_CLASS_ARRAY, ClassUtils.toClass())); 
     final Class<?>[] castNull = ClassUtils.toClass((Object) null); 
     assertTrue("(Object)null -> [null]", Arrays.equals(new Object[] { null }, castNull)); 
     assertSame(ArrayUtils.EMPTY_CLASS_ARRAY, ClassUtils.toClass(ArrayUtils.EMPTY_OBJECT_ARRAY)); 
     assertTrue(Arrays.equals(new Class[] { String.class, Integer.class, Double.class }, ClassUtils.toClass(new Object[] { "Test", Integer.valueOf(1), Double.valueOf(99d) }))); 
     assertTrue(Arrays.equals(new Class[] { String.class, null, Double.class }, ClassUtils.toClass(new Object[] { "Test", null, Double.valueOf(99d) }))); 
 }
@Test
public void test_getShortCanonicalName_String5592() { 
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
public void testGetClassByNormalNameArrays2D5606() throws ClassNotFoundException { 
     assertEquals(int[][].class, ClassUtils.getClass("int[][]")); 
     assertEquals(long[][].class, ClassUtils.getClass("long[][]")); 
     assertEquals(short[][].class, ClassUtils.getClass("short[][]")); 
     assertEquals(byte[][].class, ClassUtils.getClass("byte[][]")); 
     assertEquals(char[][].class, ClassUtils.getClass("char[][]")); 
     assertEquals(float[][].class, ClassUtils.getClass("float[][]")); 
     assertEquals(double[][].class, ClassUtils.getClass("double[][]")); 
     assertEquals(boolean[][].class, ClassUtils.getClass("boolean[][]")); 
     assertEquals(String[][].class, ClassUtils.getClass("java.lang.String[][]")); 
 }
@Test
public void testGetPublicMethod5640() throws Exception { 
     final Set<?> set = Collections.unmodifiableSet(new HashSet<Object>()); 
     final Method isEmptyMethod = ClassUtils.getPublicMethod(set.getClass(), "isEmpty", new Class[0]); 
     assertTrue(Modifier.isPublic(isEmptyMethod.getDeclaringClass().getModifiers())); 
     try { 
         isEmptyMethod.invoke(set, new Object[0]); 
     } catch (final java.lang.IllegalAccessException iae) { 
         fail("Should not have thrown IllegalAccessException"); 
     } 
     final Method toStringMethod = ClassUtils.getPublicMethod(Object.class, "toString", new Class[0]); 
     assertEquals(Object.class.getMethod("toString", new Class[0]), toStringMethod); 
 }
@Test
public void test_getShortClassName_String5751() { 
     assertEquals("ClassUtils", ClassUtils.getShortClassName(ClassUtils.class.getName())); 
     assertEquals("Map.Entry", ClassUtils.getShortClassName(Map.Entry.class.getName())); 
     assertEquals("", ClassUtils.getShortClassName((String) null)); 
     assertEquals("", ClassUtils.getShortClassName("")); 
 }
@Test
public void testGetClassByNormalNameArrays2D5753() throws ClassNotFoundException { 
     assertEquals(int[][].class, ClassUtils.getClass("int[][]")); 
     assertEquals(long[][].class, ClassUtils.getClass("long[][]")); 
     assertEquals(short[][].class, ClassUtils.getClass("short[][]")); 
     assertEquals(byte[][].class, ClassUtils.getClass("byte[][]")); 
     assertEquals(char[][].class, ClassUtils.getClass("char[][]")); 
     assertEquals(float[][].class, ClassUtils.getClass("float[][]")); 
     assertEquals(double[][].class, ClassUtils.getClass("double[][]")); 
     assertEquals(boolean[][].class, ClassUtils.getClass("boolean[][]")); 
     assertEquals(String[][].class, ClassUtils.getClass("java.lang.String[][]")); 
 }
@Test
public void testGetClassByNormalNameArrays2D5762() throws ClassNotFoundException { 
     assertEquals(int[][].class, ClassUtils.getClass("int[][]")); 
     assertEquals(long[][].class, ClassUtils.getClass("long[][]")); 
     assertEquals(short[][].class, ClassUtils.getClass("short[][]")); 
     assertEquals(byte[][].class, ClassUtils.getClass("byte[][]")); 
     assertEquals(char[][].class, ClassUtils.getClass("char[][]")); 
     assertEquals(float[][].class, ClassUtils.getClass("float[][]")); 
     assertEquals(double[][].class, ClassUtils.getClass("double[][]")); 
     assertEquals(boolean[][].class, ClassUtils.getClass("boolean[][]")); 
     assertEquals(String[][].class, ClassUtils.getClass("java.lang.String[][]")); 
 }
@Test
public void test_isAssignable_ClassArray_ClassArray_Autoboxing5775() throws Exception { 
     final Class<?>[] array2 = new Class[] { Object.class, Object.class }; 
     final Class<?>[] array1 = new Class[] { Object.class }; 
     final Class<?>[] array1s = new Class[] { String.class }; 
     final Class<?>[] array0 = new Class[] {}; 
     final Class<?>[] arrayPrimitives = { Integer.TYPE, Boolean.TYPE }; 
     final Class<?>[] arrayWrappers = { Integer.class, Boolean.class }; 
     assertFalse(ClassUtils.isAssignable(array1, array2, true)); 
     assertFalse(ClassUtils.isAssignable(null, array2, true)); 
     assertTrue(ClassUtils.isAssignable(null, array0, true)); 
     assertTrue(ClassUtils.isAssignable(array0, array0, true)); 
     assertTrue(ClassUtils.isAssignable(array0, null, true)); 
     assertTrue(ClassUtils.isAssignable((Class[]) null, (Class[]) null, true)); 
     assertFalse(ClassUtils.isAssignable(array1, array1s, true)); 
     assertTrue(ClassUtils.isAssignable(array1s, array1s, true)); 
     assertTrue(ClassUtils.isAssignable(array1s, array1, true)); 
     assertTrue(ClassUtils.isAssignable(arrayPrimitives, arrayWrappers, true)); 
     assertTrue(ClassUtils.isAssignable(arrayWrappers, arrayPrimitives, true)); 
     assertFalse(ClassUtils.isAssignable(arrayPrimitives, array1, true)); 
     assertFalse(ClassUtils.isAssignable(arrayWrappers, array1, true)); 
     assertTrue(ClassUtils.isAssignable(arrayPrimitives, array2, true)); 
     assertTrue(ClassUtils.isAssignable(arrayWrappers, array2, true)); 
 }
@Test
public void test_getShortClassName_Object5786() { 
     assertEquals("ClassUtils", ClassUtils.getShortClassName(new ClassUtils(), "<null>")); 
     assertEquals("ClassUtilsTest.Inner", ClassUtils.getShortClassName(new Inner(), "<null>")); 
     assertEquals("String", ClassUtils.getShortClassName("hello", "<null>")); 
     assertEquals("<null>", ClassUtils.getShortClassName(null, "<null>")); 
     class Named extends Object { 
     } 
     assertEquals("ClassUtilsTest.1", ClassUtils.getShortClassName(new Object() { 
     }, "<null>")); 
     assertEquals("ClassUtilsTest.1Named", ClassUtils.getShortClassName(new Named(), "<null>")); 
     assertEquals("ClassUtilsTest.Inner", ClassUtils.getShortClassName(new Inner(), "<null>")); 
 }
@Test
public void test_convertClassesToClassNames_List5948() { 
     final List<Class<?>> list = new ArrayList<Class<?>>(); 
     List<String> result = ClassUtils.convertClassesToClassNames(list); 
     assertEquals(0, result.size()); 
     list.add(String.class); 
     list.add(null); 
     list.add(Object.class); 
     result = ClassUtils.convertClassesToClassNames(list); 
     assertEquals(3, result.size()); 
     assertEquals("java.lang.String", result.get(0)); 
     assertEquals(null, result.get(1)); 
     assertEquals("java.lang.Object", result.get(2)); 
     @SuppressWarnings("unchecked") 
     final List<Object> olist = (List<Object>) (List<?>) list; 
     olist.add(new Object()); 
     try { 
         ClassUtils.convertClassesToClassNames(list); 
         fail("Should not have been able to convert list"); 
     } catch (final ClassCastException expected) { 
     } 
     assertEquals(null, ClassUtils.convertClassesToClassNames(null)); 
 }
@Test
public void test_getShortClassName_String5949() { 
     assertEquals("ClassUtils", ClassUtils.getShortClassName(ClassUtils.class.getName())); 
     assertEquals("Map.Entry", ClassUtils.getShortClassName(Map.Entry.class.getName())); 
     assertEquals("", ClassUtils.getShortClassName((String) null)); 
     assertEquals("", ClassUtils.getShortClassName("")); 
 }
@Test
public void testGetClassInvalidArguments6004() throws Exception { 
     assertGetClassThrowsNullPointerException(null); 
     assertGetClassThrowsClassNotFound("[][][]"); 
     assertGetClassThrowsClassNotFound("[[]"); 
     assertGetClassThrowsClassNotFound("["); 
     assertGetClassThrowsClassNotFound("java.lang.String]["); 
     assertGetClassThrowsClassNotFound(".hello.world"); 
     assertGetClassThrowsClassNotFound("hello..world"); 
 }
@Test
public void testGetClassByNormalNameArrays2D6136() throws ClassNotFoundException { 
     assertEquals(int[][].class, ClassUtils.getClass("int[][]")); 
     assertEquals(long[][].class, ClassUtils.getClass("long[][]")); 
     assertEquals(short[][].class, ClassUtils.getClass("short[][]")); 
     assertEquals(byte[][].class, ClassUtils.getClass("byte[][]")); 
     assertEquals(char[][].class, ClassUtils.getClass("char[][]")); 
     assertEquals(float[][].class, ClassUtils.getClass("float[][]")); 
     assertEquals(double[][].class, ClassUtils.getClass("double[][]")); 
     assertEquals(boolean[][].class, ClassUtils.getClass("boolean[][]")); 
     assertEquals(String[][].class, ClassUtils.getClass("java.lang.String[][]")); 
 }
@Test
public void test_convertClassNamesToClasses_List6143() { 
     final List<String> list = new ArrayList<String>(); 
     List<Class<?>> result = ClassUtils.convertClassNamesToClasses(list); 
     assertEquals(0, result.size()); 
     list.add("java.lang.String"); 
     list.add("java.lang.xxx"); 
     list.add("java.lang.Object"); 
     result = ClassUtils.convertClassNamesToClasses(list); 
     assertEquals(3, result.size()); 
     assertEquals(String.class, result.get(0)); 
     assertEquals(null, result.get(1)); 
     assertEquals(Object.class, result.get(2)); 
     @SuppressWarnings("unchecked") 
     final List<Object> olist = (List<Object>) (List<?>) list; 
     olist.add(new Object()); 
     try { 
         ClassUtils.convertClassNamesToClasses(list); 
         fail("Should not have been able to convert list"); 
     } catch (final ClassCastException expected) { 
     } 
     assertEquals(null, ClassUtils.convertClassNamesToClasses(null)); 
 }
@Test
public void testGetPublicMethod6180() throws Exception { 
     final Set<?> set = Collections.unmodifiableSet(new HashSet<Object>()); 
     final Method isEmptyMethod = ClassUtils.getPublicMethod(set.getClass(), "isEmpty", new Class[0]); 
     assertTrue(Modifier.isPublic(isEmptyMethod.getDeclaringClass().getModifiers())); 
     try { 
         isEmptyMethod.invoke(set, new Object[0]); 
     } catch (final java.lang.IllegalAccessException iae) { 
         fail("Should not have thrown IllegalAccessException"); 
     } 
     final Method toStringMethod = ClassUtils.getPublicMethod(Object.class, "toString", new Class[0]); 
     assertEquals(Object.class.getMethod("toString", new Class[0]), toStringMethod); 
 }
@Test
public void test_getShortClassName_Class6186() { 
     assertEquals("ClassUtils", ClassUtils.getShortClassName(ClassUtils.class)); 
     assertEquals("Map.Entry", ClassUtils.getShortClassName(Map.Entry.class)); 
     assertEquals("", ClassUtils.getShortClassName((Class<?>) null)); 
     assertEquals("String[]", ClassUtils.getShortClassName(String[].class)); 
     assertEquals("Map.Entry[]", ClassUtils.getShortClassName(Map.Entry[].class)); 
     assertEquals("boolean", ClassUtils.getShortClassName(boolean.class)); 
     assertEquals("byte", ClassUtils.getShortClassName(byte.class)); 
     assertEquals("char", ClassUtils.getShortClassName(char.class)); 
     assertEquals("short", ClassUtils.getShortClassName(short.class)); 
     assertEquals("int", ClassUtils.getShortClassName(int.class)); 
     assertEquals("long", ClassUtils.getShortClassName(long.class)); 
     assertEquals("float", ClassUtils.getShortClassName(float.class)); 
     assertEquals("double", ClassUtils.getShortClassName(double.class)); 
     assertEquals("boolean[]", ClassUtils.getShortClassName(boolean[].class)); 
     assertEquals("byte[]", ClassUtils.getShortClassName(byte[].class)); 
     assertEquals("char[]", ClassUtils.getShortClassName(char[].class)); 
     assertEquals("short[]", ClassUtils.getShortClassName(short[].class)); 
     assertEquals("int[]", ClassUtils.getShortClassName(int[].class)); 
     assertEquals("long[]", ClassUtils.getShortClassName(long[].class)); 
     assertEquals("float[]", ClassUtils.getShortClassName(float[].class)); 
     assertEquals("double[]", ClassUtils.getShortClassName(double[].class)); 
     assertEquals("String[][]", ClassUtils.getShortClassName(String[][].class)); 
     assertEquals("String[][][]", ClassUtils.getShortClassName(String[][][].class)); 
     assertEquals("String[][][][]", ClassUtils.getShortClassName(String[][][][].class)); 
     class Named extends Object { 
     } 
     assertEquals("ClassUtilsTest.2", ClassUtils.getShortClassName(new Object() { 
     }.getClass())); 
     assertEquals("ClassUtilsTest.2Named", ClassUtils.getShortClassName(Named.class)); 
     assertEquals("ClassUtilsTest.Inner", ClassUtils.getShortClassName(Inner.class)); 
 }
@Test
public void test_convertClassesToClassNames_List6205() { 
     final List<Class<?>> list = new ArrayList<Class<?>>(); 
     List<String> result = ClassUtils.convertClassesToClassNames(list); 
     assertEquals(0, result.size()); 
     list.add(String.class); 
     list.add(null); 
     list.add(Object.class); 
     result = ClassUtils.convertClassesToClassNames(list); 
     assertEquals(3, result.size()); 
     assertEquals("java.lang.String", result.get(0)); 
     assertEquals(null, result.get(1)); 
     assertEquals("java.lang.Object", result.get(2)); 
     @SuppressWarnings("unchecked") 
     final List<Object> olist = (List<Object>) (List<?>) list; 
     olist.add(new Object()); 
     try { 
         ClassUtils.convertClassesToClassNames(list); 
         fail("Should not have been able to convert list"); 
     } catch (final ClassCastException expected) { 
     } 
     assertEquals(null, ClassUtils.convertClassesToClassNames(null)); 
 }
@Test
public void test_getShortClassName_Class6316() { 
     assertEquals("ClassUtils", ClassUtils.getShortClassName(ClassUtils.class)); 
     assertEquals("Map.Entry", ClassUtils.getShortClassName(Map.Entry.class)); 
     assertEquals("", ClassUtils.getShortClassName((Class<?>) null)); 
     assertEquals("String[]", ClassUtils.getShortClassName(String[].class)); 
     assertEquals("Map.Entry[]", ClassUtils.getShortClassName(Map.Entry[].class)); 
     assertEquals("boolean", ClassUtils.getShortClassName(boolean.class)); 
     assertEquals("byte", ClassUtils.getShortClassName(byte.class)); 
     assertEquals("char", ClassUtils.getShortClassName(char.class)); 
     assertEquals("short", ClassUtils.getShortClassName(short.class)); 
     assertEquals("int", ClassUtils.getShortClassName(int.class)); 
     assertEquals("long", ClassUtils.getShortClassName(long.class)); 
     assertEquals("float", ClassUtils.getShortClassName(float.class)); 
     assertEquals("double", ClassUtils.getShortClassName(double.class)); 
     assertEquals("boolean[]", ClassUtils.getShortClassName(boolean[].class)); 
     assertEquals("byte[]", ClassUtils.getShortClassName(byte[].class)); 
     assertEquals("char[]", ClassUtils.getShortClassName(char[].class)); 
     assertEquals("short[]", ClassUtils.getShortClassName(short[].class)); 
     assertEquals("int[]", ClassUtils.getShortClassName(int[].class)); 
     assertEquals("long[]", ClassUtils.getShortClassName(long[].class)); 
     assertEquals("float[]", ClassUtils.getShortClassName(float[].class)); 
     assertEquals("double[]", ClassUtils.getShortClassName(double[].class)); 
     assertEquals("String[][]", ClassUtils.getShortClassName(String[][].class)); 
     assertEquals("String[][][]", ClassUtils.getShortClassName(String[][][].class)); 
     assertEquals("String[][][][]", ClassUtils.getShortClassName(String[][][][].class)); 
     class Named extends Object { 
     } 
     assertEquals("ClassUtilsTest.2", ClassUtils.getShortClassName(new Object() { 
     }.getClass())); 
     assertEquals("ClassUtilsTest.2Named", ClassUtils.getShortClassName(Named.class)); 
     assertEquals("ClassUtilsTest.Inner", ClassUtils.getShortClassName(Inner.class)); 
 }
@Test
public void test_getShortClassName_String6336() { 
     assertEquals("ClassUtils", ClassUtils.getShortClassName(ClassUtils.class.getName())); 
     assertEquals("Map.Entry", ClassUtils.getShortClassName(Map.Entry.class.getName())); 
     assertEquals("", ClassUtils.getShortClassName((String) null)); 
     assertEquals("", ClassUtils.getShortClassName("")); 
 }
@Test
public void test_getSimpleName_Object6379() { 
     assertEquals("ClassUtils", ClassUtils.getSimpleName(new ClassUtils(), "<null>")); 
     assertEquals("Inner", ClassUtils.getSimpleName(new Inner(), "<null>")); 
     assertEquals("String", ClassUtils.getSimpleName("hello", "<null>")); 
     assertEquals("<null>", ClassUtils.getSimpleName(null, "<null>")); 
 }
@Test
public void test_getPackageCanonicalName_Object6473() { 
     assertEquals("<null>", ClassUtils.getPackageCanonicalName(null, "<null>")); 
     assertEquals("org.apache.commons.lang3", ClassUtils.getPackageCanonicalName(new ClassUtils(), "<null>")); 
     assertEquals("org.apache.commons.lang3", ClassUtils.getPackageCanonicalName(new ClassUtils[0], "<null>")); 
     assertEquals("org.apache.commons.lang3", ClassUtils.getPackageCanonicalName(new ClassUtils[0][0], "<null>")); 
     assertEquals("", ClassUtils.getPackageCanonicalName(new int[0], "<null>")); 
     assertEquals("", ClassUtils.getPackageCanonicalName(new int[0][0], "<null>")); 
     class Named extends Object { 
     } 
     assertEquals("org.apache.commons.lang3", ClassUtils.getPackageCanonicalName(new Object() { 
     }, "<null>")); 
     assertEquals("org.apache.commons.lang3", ClassUtils.getPackageCanonicalName(new Named(), "<null>")); 
     assertEquals("org.apache.commons.lang3", ClassUtils.getPackageCanonicalName(new Inner(), "<null>")); 
 }
@Test
public void test_getShortCanonicalName_Object6504() { 
     assertEquals("<null>", ClassUtils.getShortCanonicalName(null, "<null>")); 
     assertEquals("ClassUtils", ClassUtils.getShortCanonicalName(new ClassUtils(), "<null>")); 
     assertEquals("ClassUtils[]", ClassUtils.getShortCanonicalName(new ClassUtils[0], "<null>")); 
     assertEquals("ClassUtils[][]", ClassUtils.getShortCanonicalName(new ClassUtils[0][0], "<null>")); 
     assertEquals("int[]", ClassUtils.getShortCanonicalName(new int[0], "<null>")); 
     assertEquals("int[][]", ClassUtils.getShortCanonicalName(new int[0][0], "<null>")); 
     class Named extends Object { 
     } 
     assertEquals("ClassUtilsTest.6", ClassUtils.getShortCanonicalName(new Object() { 
     }, "<null>")); 
     assertEquals("ClassUtilsTest.5Named", ClassUtils.getShortCanonicalName(new Named(), "<null>")); 
     assertEquals("ClassUtilsTest.Inner", ClassUtils.getShortCanonicalName(new Inner(), "<null>")); 
 }
@Test
public void testGetPublicMethod6539() throws Exception { 
     final Set<?> set = Collections.unmodifiableSet(new HashSet<Object>()); 
     final Method isEmptyMethod = ClassUtils.getPublicMethod(set.getClass(), "isEmpty", new Class[0]); 
     assertTrue(Modifier.isPublic(isEmptyMethod.getDeclaringClass().getModifiers())); 
     try { 
         isEmptyMethod.invoke(set, new Object[0]); 
     } catch (final java.lang.IllegalAccessException iae) { 
         fail("Should not have thrown IllegalAccessException"); 
     } 
     final Method toStringMethod = ClassUtils.getPublicMethod(Object.class, "toString", new Class[0]); 
     assertEquals(Object.class.getMethod("toString", new Class[0]), toStringMethod); 
 }
@Test
public void testWrappersToPrimitivesNull6580() { 
     assertNull("Wrong result for null input", ClassUtils.wrappersToPrimitives((Class<?>[]) null)); 
     assertTrue("empty -> empty", Arrays.equals(ArrayUtils.EMPTY_CLASS_ARRAY, ClassUtils.wrappersToPrimitives())); 
     final Class<?>[] castNull = ClassUtils.wrappersToPrimitives((Class<?>) null); 
     assertTrue("(Class<?>)null -> [null]", Arrays.equals(new Class<?>[] { null }, castNull)); 
 }
@Test
public void test_getSimpleName_Object6667() { 
     assertEquals("ClassUtils", ClassUtils.getSimpleName(new ClassUtils(), "<null>")); 
     assertEquals("Inner", ClassUtils.getSimpleName(new Inner(), "<null>")); 
     assertEquals("String", ClassUtils.getSimpleName("hello", "<null>")); 
     assertEquals("<null>", ClassUtils.getSimpleName(null, "<null>")); 
 }
@Test
public void test_getPackageName_Class6685() { 
     assertEquals("java.lang", ClassUtils.getPackageName(String.class)); 
     assertEquals("java.util", ClassUtils.getPackageName(Map.Entry.class)); 
     assertEquals("", ClassUtils.getPackageName((Class<?>) null)); 
     assertEquals("java.lang", ClassUtils.getPackageName(String[].class)); 
     assertEquals("", ClassUtils.getPackageName(boolean[].class)); 
     assertEquals("", ClassUtils.getPackageName(byte[].class)); 
     assertEquals("", ClassUtils.getPackageName(char[].class)); 
     assertEquals("", ClassUtils.getPackageName(short[].class)); 
     assertEquals("", ClassUtils.getPackageName(int[].class)); 
     assertEquals("", ClassUtils.getPackageName(long[].class)); 
     assertEquals("", ClassUtils.getPackageName(float[].class)); 
     assertEquals("", ClassUtils.getPackageName(double[].class)); 
     assertEquals("java.lang", ClassUtils.getPackageName(String[][].class)); 
     assertEquals("java.lang", ClassUtils.getPackageName(String[][][].class)); 
     assertEquals("java.lang", ClassUtils.getPackageName(String[][][][].class)); 
     class Named extends Object { 
     } 
     assertEquals("org.apache.commons.lang3", ClassUtils.getPackageName(new Object() { 
     }.getClass())); 
     assertEquals("org.apache.commons.lang3", ClassUtils.getPackageName(Named.class)); 
 }
@Test
public void test_getShortClassName_Object6718() { 
     assertEquals("ClassUtils", ClassUtils.getShortClassName(new ClassUtils(), "<null>")); 
     assertEquals("ClassUtilsTest.Inner", ClassUtils.getShortClassName(new Inner(), "<null>")); 
     assertEquals("String", ClassUtils.getShortClassName("hello", "<null>")); 
     assertEquals("<null>", ClassUtils.getShortClassName(null, "<null>")); 
     class Named extends Object { 
     } 
     assertEquals("ClassUtilsTest.1", ClassUtils.getShortClassName(new Object() { 
     }, "<null>")); 
     assertEquals("ClassUtilsTest.1Named", ClassUtils.getShortClassName(new Named(), "<null>")); 
     assertEquals("ClassUtilsTest.Inner", ClassUtils.getShortClassName(new Inner(), "<null>")); 
 }
@Test
public void test_getPackageName_Class6732() { 
     assertEquals("java.lang", ClassUtils.getPackageName(String.class)); 
     assertEquals("java.util", ClassUtils.getPackageName(Map.Entry.class)); 
     assertEquals("", ClassUtils.getPackageName((Class<?>) null)); 
     assertEquals("java.lang", ClassUtils.getPackageName(String[].class)); 
     assertEquals("", ClassUtils.getPackageName(boolean[].class)); 
     assertEquals("", ClassUtils.getPackageName(byte[].class)); 
     assertEquals("", ClassUtils.getPackageName(char[].class)); 
     assertEquals("", ClassUtils.getPackageName(short[].class)); 
     assertEquals("", ClassUtils.getPackageName(int[].class)); 
     assertEquals("", ClassUtils.getPackageName(long[].class)); 
     assertEquals("", ClassUtils.getPackageName(float[].class)); 
     assertEquals("", ClassUtils.getPackageName(double[].class)); 
     assertEquals("java.lang", ClassUtils.getPackageName(String[][].class)); 
     assertEquals("java.lang", ClassUtils.getPackageName(String[][][].class)); 
     assertEquals("java.lang", ClassUtils.getPackageName(String[][][][].class)); 
     class Named extends Object { 
     } 
     assertEquals("org.apache.commons.lang3", ClassUtils.getPackageName(new Object() { 
     }.getClass())); 
     assertEquals("org.apache.commons.lang3", ClassUtils.getPackageName(Named.class)); 
 }
@Test
public void test_getPackageCanonicalName_Object6837() { 
     assertEquals("<null>", ClassUtils.getPackageCanonicalName(null, "<null>")); 
     assertEquals("org.apache.commons.lang3", ClassUtils.getPackageCanonicalName(new ClassUtils(), "<null>")); 
     assertEquals("org.apache.commons.lang3", ClassUtils.getPackageCanonicalName(new ClassUtils[0], "<null>")); 
     assertEquals("org.apache.commons.lang3", ClassUtils.getPackageCanonicalName(new ClassUtils[0][0], "<null>")); 
     assertEquals("", ClassUtils.getPackageCanonicalName(new int[0], "<null>")); 
     assertEquals("", ClassUtils.getPackageCanonicalName(new int[0][0], "<null>")); 
     class Named extends Object { 
     } 
     assertEquals("org.apache.commons.lang3", ClassUtils.getPackageCanonicalName(new Object() { 
     }, "<null>")); 
     assertEquals("org.apache.commons.lang3", ClassUtils.getPackageCanonicalName(new Named(), "<null>")); 
     assertEquals("org.apache.commons.lang3", ClassUtils.getPackageCanonicalName(new Inner(), "<null>")); 
 }
@Test
public void test_convertClassNamesToClasses_List6845() { 
     final List<String> list = new ArrayList<String>(); 
     List<Class<?>> result = ClassUtils.convertClassNamesToClasses(list); 
     assertEquals(0, result.size()); 
     list.add("java.lang.String"); 
     list.add("java.lang.xxx"); 
     list.add("java.lang.Object"); 
     result = ClassUtils.convertClassNamesToClasses(list); 
     assertEquals(3, result.size()); 
     assertEquals(String.class, result.get(0)); 
     assertEquals(null, result.get(1)); 
     assertEquals(Object.class, result.get(2)); 
     @SuppressWarnings("unchecked") 
     final List<Object> olist = (List<Object>) (List<?>) list; 
     olist.add(new Object()); 
     try { 
         ClassUtils.convertClassNamesToClasses(list); 
         fail("Should not have been able to convert list"); 
     } catch (final ClassCastException expected) { 
     } 
     assertEquals(null, ClassUtils.convertClassNamesToClasses(null)); 
 }
@Test
public void testGetPublicMethod6863() throws Exception { 
     final Set<?> set = Collections.unmodifiableSet(new HashSet<Object>()); 
     final Method isEmptyMethod = ClassUtils.getPublicMethod(set.getClass(), "isEmpty", new Class[0]); 
     assertTrue(Modifier.isPublic(isEmptyMethod.getDeclaringClass().getModifiers())); 
     try { 
         isEmptyMethod.invoke(set, new Object[0]); 
     } catch (final java.lang.IllegalAccessException iae) { 
         fail("Should not have thrown IllegalAccessException"); 
     } 
     final Method toStringMethod = ClassUtils.getPublicMethod(Object.class, "toString", new Class[0]); 
     assertEquals(Object.class.getMethod("toString", new Class[0]), toStringMethod); 
 }
@Test
public void testGetClassByNormalNameArrays2D6881() throws ClassNotFoundException { 
     assertEquals(int[][].class, ClassUtils.getClass("int[][]")); 
     assertEquals(long[][].class, ClassUtils.getClass("long[][]")); 
     assertEquals(short[][].class, ClassUtils.getClass("short[][]")); 
     assertEquals(byte[][].class, ClassUtils.getClass("byte[][]")); 
     assertEquals(char[][].class, ClassUtils.getClass("char[][]")); 
     assertEquals(float[][].class, ClassUtils.getClass("float[][]")); 
     assertEquals(double[][].class, ClassUtils.getClass("double[][]")); 
     assertEquals(boolean[][].class, ClassUtils.getClass("boolean[][]")); 
     assertEquals(String[][].class, ClassUtils.getClass("java.lang.String[][]")); 
 }
@Test
public void testIsPrimitiveOrWrapper6885() { 
     assertTrue("Boolean.class", ClassUtils.isPrimitiveOrWrapper(Boolean.class)); 
     assertTrue("Byte.class", ClassUtils.isPrimitiveOrWrapper(Byte.class)); 
     assertTrue("Character.class", ClassUtils.isPrimitiveOrWrapper(Character.class)); 
     assertTrue("Short.class", ClassUtils.isPrimitiveOrWrapper(Short.class)); 
     assertTrue("Integer.class", ClassUtils.isPrimitiveOrWrapper(Integer.class)); 
     assertTrue("Long.class", ClassUtils.isPrimitiveOrWrapper(Long.class)); 
     assertTrue("Double.class", ClassUtils.isPrimitiveOrWrapper(Double.class)); 
     assertTrue("Float.class", ClassUtils.isPrimitiveOrWrapper(Float.class)); 
     assertTrue("boolean", ClassUtils.isPrimitiveOrWrapper(Boolean.TYPE)); 
     assertTrue("byte", ClassUtils.isPrimitiveOrWrapper(Byte.TYPE)); 
     assertTrue("char", ClassUtils.isPrimitiveOrWrapper(Character.TYPE)); 
     assertTrue("short", ClassUtils.isPrimitiveOrWrapper(Short.TYPE)); 
     assertTrue("int", ClassUtils.isPrimitiveOrWrapper(Integer.TYPE)); 
     assertTrue("long", ClassUtils.isPrimitiveOrWrapper(Long.TYPE)); 
     assertTrue("double", ClassUtils.isPrimitiveOrWrapper(Double.TYPE)); 
     assertTrue("float", ClassUtils.isPrimitiveOrWrapper(Float.TYPE)); 
     assertTrue("Void.TYPE", ClassUtils.isPrimitiveOrWrapper(Void.TYPE)); 
     assertFalse("null", ClassUtils.isPrimitiveOrWrapper(null)); 
     assertFalse("Void.class", ClassUtils.isPrimitiveOrWrapper(Void.class)); 
     assertFalse("String.class", ClassUtils.isPrimitiveOrWrapper(String.class)); 
     assertFalse("this.getClass()", ClassUtils.isPrimitiveOrWrapper(this.getClass())); 
 }
@Test
public void test_getShortClassName_Class6912() { 
     assertEquals("ClassUtils", ClassUtils.getShortClassName(ClassUtils.class)); 
     assertEquals("Map.Entry", ClassUtils.getShortClassName(Map.Entry.class)); 
     assertEquals("", ClassUtils.getShortClassName((Class<?>) null)); 
     assertEquals("String[]", ClassUtils.getShortClassName(String[].class)); 
     assertEquals("Map.Entry[]", ClassUtils.getShortClassName(Map.Entry[].class)); 
     assertEquals("boolean", ClassUtils.getShortClassName(boolean.class)); 
     assertEquals("byte", ClassUtils.getShortClassName(byte.class)); 
     assertEquals("char", ClassUtils.getShortClassName(char.class)); 
     assertEquals("short", ClassUtils.getShortClassName(short.class)); 
     assertEquals("int", ClassUtils.getShortClassName(int.class)); 
     assertEquals("long", ClassUtils.getShortClassName(long.class)); 
     assertEquals("float", ClassUtils.getShortClassName(float.class)); 
     assertEquals("double", ClassUtils.getShortClassName(double.class)); 
     assertEquals("boolean[]", ClassUtils.getShortClassName(boolean[].class)); 
     assertEquals("byte[]", ClassUtils.getShortClassName(byte[].class)); 
     assertEquals("char[]", ClassUtils.getShortClassName(char[].class)); 
     assertEquals("short[]", ClassUtils.getShortClassName(short[].class)); 
     assertEquals("int[]", ClassUtils.getShortClassName(int[].class)); 
     assertEquals("long[]", ClassUtils.getShortClassName(long[].class)); 
     assertEquals("float[]", ClassUtils.getShortClassName(float[].class)); 
     assertEquals("double[]", ClassUtils.getShortClassName(double[].class)); 
     assertEquals("String[][]", ClassUtils.getShortClassName(String[][].class)); 
     assertEquals("String[][][]", ClassUtils.getShortClassName(String[][][].class)); 
     assertEquals("String[][][][]", ClassUtils.getShortClassName(String[][][][].class)); 
     class Named extends Object { 
     } 
     assertEquals("ClassUtilsTest.2", ClassUtils.getShortClassName(new Object() { 
     }.getClass())); 
     assertEquals("ClassUtilsTest.2Named", ClassUtils.getShortClassName(Named.class)); 
     assertEquals("ClassUtilsTest.Inner", ClassUtils.getShortClassName(Inner.class)); 
 }
@Test
public void testGetClassByNormalNameArrays2D6965() throws ClassNotFoundException { 
     assertEquals(int[][].class, ClassUtils.getClass("int[][]")); 
     assertEquals(long[][].class, ClassUtils.getClass("long[][]")); 
     assertEquals(short[][].class, ClassUtils.getClass("short[][]")); 
     assertEquals(byte[][].class, ClassUtils.getClass("byte[][]")); 
     assertEquals(char[][].class, ClassUtils.getClass("char[][]")); 
     assertEquals(float[][].class, ClassUtils.getClass("float[][]")); 
     assertEquals(double[][].class, ClassUtils.getClass("double[][]")); 
     assertEquals(boolean[][].class, ClassUtils.getClass("boolean[][]")); 
     assertEquals(String[][].class, ClassUtils.getClass("java.lang.String[][]")); 
 }
@Test
public void test_isAssignable_ClassArray_ClassArray_Autoboxing7011() throws Exception { 
     final Class<?>[] array2 = new Class[] { Object.class, Object.class }; 
     final Class<?>[] array1 = new Class[] { Object.class }; 
     final Class<?>[] array1s = new Class[] { String.class }; 
     final Class<?>[] array0 = new Class[] {}; 
     final Class<?>[] arrayPrimitives = { Integer.TYPE, Boolean.TYPE }; 
     final Class<?>[] arrayWrappers = { Integer.class, Boolean.class }; 
     assertFalse(ClassUtils.isAssignable(array1, array2, true)); 
     assertFalse(ClassUtils.isAssignable(null, array2, true)); 
     assertTrue(ClassUtils.isAssignable(null, array0, true)); 
     assertTrue(ClassUtils.isAssignable(array0, array0, true)); 
     assertTrue(ClassUtils.isAssignable(array0, null, true)); 
     assertTrue(ClassUtils.isAssignable((Class[]) null, (Class[]) null, true)); 
     assertFalse(ClassUtils.isAssignable(array1, array1s, true)); 
     assertTrue(ClassUtils.isAssignable(array1s, array1s, true)); 
     assertTrue(ClassUtils.isAssignable(array1s, array1, true)); 
     assertTrue(ClassUtils.isAssignable(arrayPrimitives, arrayWrappers, true)); 
     assertTrue(ClassUtils.isAssignable(arrayWrappers, arrayPrimitives, true)); 
     assertFalse(ClassUtils.isAssignable(arrayPrimitives, array1, true)); 
     assertFalse(ClassUtils.isAssignable(arrayWrappers, array1, true)); 
     assertTrue(ClassUtils.isAssignable(arrayPrimitives, array2, true)); 
     assertTrue(ClassUtils.isAssignable(arrayWrappers, array2, true)); 
 }
@Test
public void test_isAssignable_ClassArray_ClassArray_Autoboxing7025() throws Exception { 
     final Class<?>[] array2 = new Class[] { Object.class, Object.class }; 
     final Class<?>[] array1 = new Class[] { Object.class }; 
     final Class<?>[] array1s = new Class[] { String.class }; 
     final Class<?>[] array0 = new Class[] {}; 
     final Class<?>[] arrayPrimitives = { Integer.TYPE, Boolean.TYPE }; 
     final Class<?>[] arrayWrappers = { Integer.class, Boolean.class }; 
     assertFalse(ClassUtils.isAssignable(array1, array2, true)); 
     assertFalse(ClassUtils.isAssignable(null, array2, true)); 
     assertTrue(ClassUtils.isAssignable(null, array0, true)); 
     assertTrue(ClassUtils.isAssignable(array0, array0, true)); 
     assertTrue(ClassUtils.isAssignable(array0, null, true)); 
     assertTrue(ClassUtils.isAssignable((Class[]) null, (Class[]) null, true)); 
     assertFalse(ClassUtils.isAssignable(array1, array1s, true)); 
     assertTrue(ClassUtils.isAssignable(array1s, array1s, true)); 
     assertTrue(ClassUtils.isAssignable(array1s, array1, true)); 
     assertTrue(ClassUtils.isAssignable(arrayPrimitives, arrayWrappers, true)); 
     assertTrue(ClassUtils.isAssignable(arrayWrappers, arrayPrimitives, true)); 
     assertFalse(ClassUtils.isAssignable(arrayPrimitives, array1, true)); 
     assertFalse(ClassUtils.isAssignable(arrayWrappers, array1, true)); 
     assertTrue(ClassUtils.isAssignable(arrayPrimitives, array2, true)); 
     assertTrue(ClassUtils.isAssignable(arrayWrappers, array2, true)); 
 }
@Test
public void test_getShortClassName_Class7038() { 
     assertEquals("ClassUtils", ClassUtils.getShortClassName(ClassUtils.class)); 
     assertEquals("Map.Entry", ClassUtils.getShortClassName(Map.Entry.class)); 
     assertEquals("", ClassUtils.getShortClassName((Class<?>) null)); 
     assertEquals("String[]", ClassUtils.getShortClassName(String[].class)); 
     assertEquals("Map.Entry[]", ClassUtils.getShortClassName(Map.Entry[].class)); 
     assertEquals("boolean", ClassUtils.getShortClassName(boolean.class)); 
     assertEquals("byte", ClassUtils.getShortClassName(byte.class)); 
     assertEquals("char", ClassUtils.getShortClassName(char.class)); 
     assertEquals("short", ClassUtils.getShortClassName(short.class)); 
     assertEquals("int", ClassUtils.getShortClassName(int.class)); 
     assertEquals("long", ClassUtils.getShortClassName(long.class)); 
     assertEquals("float", ClassUtils.getShortClassName(float.class)); 
     assertEquals("double", ClassUtils.getShortClassName(double.class)); 
     assertEquals("boolean[]", ClassUtils.getShortClassName(boolean[].class)); 
     assertEquals("byte[]", ClassUtils.getShortClassName(byte[].class)); 
     assertEquals("char[]", ClassUtils.getShortClassName(char[].class)); 
     assertEquals("short[]", ClassUtils.getShortClassName(short[].class)); 
     assertEquals("int[]", ClassUtils.getShortClassName(int[].class)); 
     assertEquals("long[]", ClassUtils.getShortClassName(long[].class)); 
     assertEquals("float[]", ClassUtils.getShortClassName(float[].class)); 
     assertEquals("double[]", ClassUtils.getShortClassName(double[].class)); 
     assertEquals("String[][]", ClassUtils.getShortClassName(String[][].class)); 
     assertEquals("String[][][]", ClassUtils.getShortClassName(String[][][].class)); 
     assertEquals("String[][][][]", ClassUtils.getShortClassName(String[][][][].class)); 
     class Named extends Object { 
     } 
     assertEquals("ClassUtilsTest.2", ClassUtils.getShortClassName(new Object() { 
     }.getClass())); 
     assertEquals("ClassUtilsTest.2Named", ClassUtils.getShortClassName(Named.class)); 
     assertEquals("ClassUtilsTest.Inner", ClassUtils.getShortClassName(Inner.class)); 
 }
@Test
public void test_getPackageName_Class7041() { 
     assertEquals("java.lang", ClassUtils.getPackageName(String.class)); 
     assertEquals("java.util", ClassUtils.getPackageName(Map.Entry.class)); 
     assertEquals("", ClassUtils.getPackageName((Class<?>) null)); 
     assertEquals("java.lang", ClassUtils.getPackageName(String[].class)); 
     assertEquals("", ClassUtils.getPackageName(boolean[].class)); 
     assertEquals("", ClassUtils.getPackageName(byte[].class)); 
     assertEquals("", ClassUtils.getPackageName(char[].class)); 
     assertEquals("", ClassUtils.getPackageName(short[].class)); 
     assertEquals("", ClassUtils.getPackageName(int[].class)); 
     assertEquals("", ClassUtils.getPackageName(long[].class)); 
     assertEquals("", ClassUtils.getPackageName(float[].class)); 
     assertEquals("", ClassUtils.getPackageName(double[].class)); 
     assertEquals("java.lang", ClassUtils.getPackageName(String[][].class)); 
     assertEquals("java.lang", ClassUtils.getPackageName(String[][][].class)); 
     assertEquals("java.lang", ClassUtils.getPackageName(String[][][][].class)); 
     class Named extends Object { 
     } 
     assertEquals("org.apache.commons.lang3", ClassUtils.getPackageName(new Object() { 
     }.getClass())); 
     assertEquals("org.apache.commons.lang3", ClassUtils.getPackageName(Named.class)); 
 }
@Test
public void test_getPackageName_Class7069() { 
     assertEquals("java.lang", ClassUtils.getPackageName(String.class)); 
     assertEquals("java.util", ClassUtils.getPackageName(Map.Entry.class)); 
     assertEquals("", ClassUtils.getPackageName((Class<?>) null)); 
     assertEquals("java.lang", ClassUtils.getPackageName(String[].class)); 
     assertEquals("", ClassUtils.getPackageName(boolean[].class)); 
     assertEquals("", ClassUtils.getPackageName(byte[].class)); 
     assertEquals("", ClassUtils.getPackageName(char[].class)); 
     assertEquals("", ClassUtils.getPackageName(short[].class)); 
     assertEquals("", ClassUtils.getPackageName(int[].class)); 
     assertEquals("", ClassUtils.getPackageName(long[].class)); 
     assertEquals("", ClassUtils.getPackageName(float[].class)); 
     assertEquals("", ClassUtils.getPackageName(double[].class)); 
     assertEquals("java.lang", ClassUtils.getPackageName(String[][].class)); 
     assertEquals("java.lang", ClassUtils.getPackageName(String[][][].class)); 
     assertEquals("java.lang", ClassUtils.getPackageName(String[][][][].class)); 
     class Named extends Object { 
     } 
     assertEquals("org.apache.commons.lang3", ClassUtils.getPackageName(new Object() { 
     }.getClass())); 
     assertEquals("org.apache.commons.lang3", ClassUtils.getPackageName(Named.class)); 
 }
@Test
public void test_getShortClassName_String7090() { 
     assertEquals("ClassUtils", ClassUtils.getShortClassName(ClassUtils.class.getName())); 
     assertEquals("Map.Entry", ClassUtils.getShortClassName(Map.Entry.class.getName())); 
     assertEquals("", ClassUtils.getShortClassName((String) null)); 
     assertEquals("", ClassUtils.getShortClassName("")); 
 }
@Test
public void testToClass_object7103() { 
     assertNull(ClassUtils.toClass((Object[]) null)); 
     assertTrue("empty -> empty", Arrays.equals(ArrayUtils.EMPTY_CLASS_ARRAY, ClassUtils.toClass())); 
     final Class<?>[] castNull = ClassUtils.toClass((Object) null); 
     assertTrue("(Object)null -> [null]", Arrays.equals(new Object[] { null }, castNull)); 
     assertSame(ArrayUtils.EMPTY_CLASS_ARRAY, ClassUtils.toClass(ArrayUtils.EMPTY_OBJECT_ARRAY)); 
     assertTrue(Arrays.equals(new Class[] { String.class, Integer.class, Double.class }, ClassUtils.toClass(new Object[] { "Test", Integer.valueOf(1), Double.valueOf(99d) }))); 
     assertTrue(Arrays.equals(new Class[] { String.class, null, Double.class }, ClassUtils.toClass(new Object[] { "Test", null, Double.valueOf(99d) }))); 
 }
@Test
public void test_getShortCanonicalName_Class7142() { 
     assertEquals("ClassUtils", ClassUtils.getShortCanonicalName(ClassUtils.class)); 
     assertEquals("ClassUtils[]", ClassUtils.getShortCanonicalName(ClassUtils[].class)); 
     assertEquals("ClassUtils[][]", ClassUtils.getShortCanonicalName(ClassUtils[][].class)); 
     assertEquals("int[]", ClassUtils.getShortCanonicalName(int[].class)); 
     assertEquals("int[][]", ClassUtils.getShortCanonicalName(int[][].class)); 
     class Named extends Object { 
     } 
     assertEquals("ClassUtilsTest.7", ClassUtils.getShortCanonicalName(new Object() { 
     }.getClass())); 
     assertEquals("ClassUtilsTest.6Named", ClassUtils.getShortCanonicalName(Named.class)); 
     assertEquals("ClassUtilsTest.Inner", ClassUtils.getShortCanonicalName(Inner.class)); 
 }
@Test
public void testToClass_object7159() { 
     assertNull(ClassUtils.toClass((Object[]) null)); 
     assertTrue("empty -> empty", Arrays.equals(ArrayUtils.EMPTY_CLASS_ARRAY, ClassUtils.toClass())); 
     final Class<?>[] castNull = ClassUtils.toClass((Object) null); 
     assertTrue("(Object)null -> [null]", Arrays.equals(new Object[] { null }, castNull)); 
     assertSame(ArrayUtils.EMPTY_CLASS_ARRAY, ClassUtils.toClass(ArrayUtils.EMPTY_OBJECT_ARRAY)); 
     assertTrue(Arrays.equals(new Class[] { String.class, Integer.class, Double.class }, ClassUtils.toClass(new Object[] { "Test", Integer.valueOf(1), Double.valueOf(99d) }))); 
     assertTrue(Arrays.equals(new Class[] { String.class, null, Double.class }, ClassUtils.toClass(new Object[] { "Test", null, Double.valueOf(99d) }))); 
 }
@Test
public void test_convertClassesToClassNames_List7173() { 
     final List<Class<?>> list = new ArrayList<Class<?>>(); 
     List<String> result = ClassUtils.convertClassesToClassNames(list); 
     assertEquals(0, result.size()); 
     list.add(String.class); 
     list.add(null); 
     list.add(Object.class); 
     result = ClassUtils.convertClassesToClassNames(list); 
     assertEquals(3, result.size()); 
     assertEquals("java.lang.String", result.get(0)); 
     assertEquals(null, result.get(1)); 
     assertEquals("java.lang.Object", result.get(2)); 
     @SuppressWarnings("unchecked") 
     final List<Object> olist = (List<Object>) (List<?>) list; 
     olist.add(new Object()); 
     try { 
         ClassUtils.convertClassesToClassNames(list); 
         fail("Should not have been able to convert list"); 
     } catch (final ClassCastException expected) { 
     } 
     assertEquals(null, ClassUtils.convertClassesToClassNames(null)); 
 }
@Test
public void test_getShortClassName_String7179() { 
     assertEquals("ClassUtils", ClassUtils.getShortClassName(ClassUtils.class.getName())); 
     assertEquals("Map.Entry", ClassUtils.getShortClassName(Map.Entry.class.getName())); 
     assertEquals("", ClassUtils.getShortClassName((String) null)); 
     assertEquals("", ClassUtils.getShortClassName("")); 
 }
@Test
public void testGetClassByNormalNameArrays2D7241() throws ClassNotFoundException { 
     assertEquals(int[][].class, ClassUtils.getClass("int[][]")); 
     assertEquals(long[][].class, ClassUtils.getClass("long[][]")); 
     assertEquals(short[][].class, ClassUtils.getClass("short[][]")); 
     assertEquals(byte[][].class, ClassUtils.getClass("byte[][]")); 
     assertEquals(char[][].class, ClassUtils.getClass("char[][]")); 
     assertEquals(float[][].class, ClassUtils.getClass("float[][]")); 
     assertEquals(double[][].class, ClassUtils.getClass("double[][]")); 
     assertEquals(boolean[][].class, ClassUtils.getClass("boolean[][]")); 
     assertEquals(String[][].class, ClassUtils.getClass("java.lang.String[][]")); 
 }
@Test
public void test_getPackageName_Class7329() { 
     assertEquals("java.lang", ClassUtils.getPackageName(String.class)); 
     assertEquals("java.util", ClassUtils.getPackageName(Map.Entry.class)); 
     assertEquals("", ClassUtils.getPackageName((Class<?>) null)); 
     assertEquals("java.lang", ClassUtils.getPackageName(String[].class)); 
     assertEquals("", ClassUtils.getPackageName(boolean[].class)); 
     assertEquals("", ClassUtils.getPackageName(byte[].class)); 
     assertEquals("", ClassUtils.getPackageName(char[].class)); 
     assertEquals("", ClassUtils.getPackageName(short[].class)); 
     assertEquals("", ClassUtils.getPackageName(int[].class)); 
     assertEquals("", ClassUtils.getPackageName(long[].class)); 
     assertEquals("", ClassUtils.getPackageName(float[].class)); 
     assertEquals("", ClassUtils.getPackageName(double[].class)); 
     assertEquals("java.lang", ClassUtils.getPackageName(String[][].class)); 
     assertEquals("java.lang", ClassUtils.getPackageName(String[][][].class)); 
     assertEquals("java.lang", ClassUtils.getPackageName(String[][][][].class)); 
     class Named extends Object { 
     } 
     assertEquals("org.apache.commons.lang3", ClassUtils.getPackageName(new Object() { 
     }.getClass())); 
     assertEquals("org.apache.commons.lang3", ClassUtils.getPackageName(Named.class)); 
 }
@Test
public void test_getPackageName_Class7350() { 
     assertEquals("java.lang", ClassUtils.getPackageName(String.class)); 
     assertEquals("java.util", ClassUtils.getPackageName(Map.Entry.class)); 
     assertEquals("", ClassUtils.getPackageName((Class<?>) null)); 
     assertEquals("java.lang", ClassUtils.getPackageName(String[].class)); 
     assertEquals("", ClassUtils.getPackageName(boolean[].class)); 
     assertEquals("", ClassUtils.getPackageName(byte[].class)); 
     assertEquals("", ClassUtils.getPackageName(char[].class)); 
     assertEquals("", ClassUtils.getPackageName(short[].class)); 
     assertEquals("", ClassUtils.getPackageName(int[].class)); 
     assertEquals("", ClassUtils.getPackageName(long[].class)); 
     assertEquals("", ClassUtils.getPackageName(float[].class)); 
     assertEquals("", ClassUtils.getPackageName(double[].class)); 
     assertEquals("java.lang", ClassUtils.getPackageName(String[][].class)); 
     assertEquals("java.lang", ClassUtils.getPackageName(String[][][].class)); 
     assertEquals("java.lang", ClassUtils.getPackageName(String[][][][].class)); 
     class Named extends Object { 
     } 
     assertEquals("org.apache.commons.lang3", ClassUtils.getPackageName(new Object() { 
     }.getClass())); 
     assertEquals("org.apache.commons.lang3", ClassUtils.getPackageName(Named.class)); 
 }
@Test
public void test_convertClassNamesToClasses_List7362() { 
     final List<String> list = new ArrayList<String>(); 
     List<Class<?>> result = ClassUtils.convertClassNamesToClasses(list); 
     assertEquals(0, result.size()); 
     list.add("java.lang.String"); 
     list.add("java.lang.xxx"); 
     list.add("java.lang.Object"); 
     result = ClassUtils.convertClassNamesToClasses(list); 
     assertEquals(3, result.size()); 
     assertEquals(String.class, result.get(0)); 
     assertEquals(null, result.get(1)); 
     assertEquals(Object.class, result.get(2)); 
     @SuppressWarnings("unchecked") 
     final List<Object> olist = (List<Object>) (List<?>) list; 
     olist.add(new Object()); 
     try { 
         ClassUtils.convertClassNamesToClasses(list); 
         fail("Should not have been able to convert list"); 
     } catch (final ClassCastException expected) { 
     } 
     assertEquals(null, ClassUtils.convertClassNamesToClasses(null)); 
 }
@Test
public void testGetClassInvalidArguments7412() throws Exception { 
     assertGetClassThrowsNullPointerException(null); 
     assertGetClassThrowsClassNotFound("[][][]"); 
     assertGetClassThrowsClassNotFound("[[]"); 
     assertGetClassThrowsClassNotFound("["); 
     assertGetClassThrowsClassNotFound("java.lang.String]["); 
     assertGetClassThrowsClassNotFound(".hello.world"); 
     assertGetClassThrowsClassNotFound("hello..world"); 
 }
@Test
public void test_convertClassNamesToClasses_List7416() { 
     final List<String> list = new ArrayList<String>(); 
     List<Class<?>> result = ClassUtils.convertClassNamesToClasses(list); 
     assertEquals(0, result.size()); 
     list.add("java.lang.String"); 
     list.add("java.lang.xxx"); 
     list.add("java.lang.Object"); 
     result = ClassUtils.convertClassNamesToClasses(list); 
     assertEquals(3, result.size()); 
     assertEquals(String.class, result.get(0)); 
     assertEquals(null, result.get(1)); 
     assertEquals(Object.class, result.get(2)); 
     @SuppressWarnings("unchecked") 
     final List<Object> olist = (List<Object>) (List<?>) list; 
     olist.add(new Object()); 
     try { 
         ClassUtils.convertClassNamesToClasses(list); 
         fail("Should not have been able to convert list"); 
     } catch (final ClassCastException expected) { 
     } 
     assertEquals(null, ClassUtils.convertClassNamesToClasses(null)); 
 }
@Test
public void testGetClassByNormalNameArrays2D7540() throws ClassNotFoundException { 
     assertEquals(int[][].class, ClassUtils.getClass("int[][]")); 
     assertEquals(long[][].class, ClassUtils.getClass("long[][]")); 
     assertEquals(short[][].class, ClassUtils.getClass("short[][]")); 
     assertEquals(byte[][].class, ClassUtils.getClass("byte[][]")); 
     assertEquals(char[][].class, ClassUtils.getClass("char[][]")); 
     assertEquals(float[][].class, ClassUtils.getClass("float[][]")); 
     assertEquals(double[][].class, ClassUtils.getClass("double[][]")); 
     assertEquals(boolean[][].class, ClassUtils.getClass("boolean[][]")); 
     assertEquals(String[][].class, ClassUtils.getClass("java.lang.String[][]")); 
 }
@Test
public void testGetClassInvalidArguments7573() throws Exception { 
     assertGetClassThrowsNullPointerException(null); 
     assertGetClassThrowsClassNotFound("[][][]"); 
     assertGetClassThrowsClassNotFound("[[]"); 
     assertGetClassThrowsClassNotFound("["); 
     assertGetClassThrowsClassNotFound("java.lang.String]["); 
     assertGetClassThrowsClassNotFound(".hello.world"); 
     assertGetClassThrowsClassNotFound("hello..world"); 
 }
@Test
public void testGetPublicMethod7631() throws Exception { 
     final Set<?> set = Collections.unmodifiableSet(new HashSet<Object>()); 
     final Method isEmptyMethod = ClassUtils.getPublicMethod(set.getClass(), "isEmpty", new Class[0]); 
     assertTrue(Modifier.isPublic(isEmptyMethod.getDeclaringClass().getModifiers())); 
     try { 
         isEmptyMethod.invoke(set, new Object[0]); 
     } catch (final java.lang.IllegalAccessException iae) { 
         fail("Should not have thrown IllegalAccessException"); 
     } 
     final Method toStringMethod = ClassUtils.getPublicMethod(Object.class, "toString", new Class[0]); 
     assertEquals(Object.class.getMethod("toString", new Class[0]), toStringMethod); 
 }
@Test
public void test_getAllSuperclasses_Class7647() { 
     final List<?> list = ClassUtils.getAllSuperclasses(CY.class); 
     assertEquals(2, list.size()); 
     assertEquals(CX.class, list.get(0)); 
     assertEquals(Object.class, list.get(1)); 
     assertEquals(null, ClassUtils.getAllSuperclasses(null)); 
 }
@Test
public void test_getShortCanonicalName_String7801() { 
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
public void test_convertClassesToClassNames_List7819() { 
     final List<Class<?>> list = new ArrayList<Class<?>>(); 
     List<String> result = ClassUtils.convertClassesToClassNames(list); 
     assertEquals(0, result.size()); 
     list.add(String.class); 
     list.add(null); 
     list.add(Object.class); 
     result = ClassUtils.convertClassesToClassNames(list); 
     assertEquals(3, result.size()); 
     assertEquals("java.lang.String", result.get(0)); 
     assertEquals(null, result.get(1)); 
     assertEquals("java.lang.Object", result.get(2)); 
     @SuppressWarnings("unchecked") 
     final List<Object> olist = (List<Object>) (List<?>) list; 
     olist.add(new Object()); 
     try { 
         ClassUtils.convertClassesToClassNames(list); 
         fail("Should not have been able to convert list"); 
     } catch (final ClassCastException expected) { 
     } 
     assertEquals(null, ClassUtils.convertClassesToClassNames(null)); 
 }
@Test
public void test_getPackageName_String7950() { 
     assertEquals("org.apache.commons.lang3", ClassUtils.getPackageName(ClassUtils.class.getName())); 
     assertEquals("java.util", ClassUtils.getPackageName(Map.Entry.class.getName())); 
     assertEquals("", ClassUtils.getPackageName((String) null)); 
     assertEquals("", ClassUtils.getPackageName("")); 
 }
@Test
public void testWrappersToPrimitivesNull8007() { 
     assertNull("Wrong result for null input", ClassUtils.wrappersToPrimitives((Class<?>[]) null)); 
     assertTrue("empty -> empty", Arrays.equals(ArrayUtils.EMPTY_CLASS_ARRAY, ClassUtils.wrappersToPrimitives())); 
     final Class<?>[] castNull = ClassUtils.wrappersToPrimitives((Class<?>) null); 
     assertTrue("(Class<?>)null -> [null]", Arrays.equals(new Class<?>[] { null }, castNull)); 
 }
@Test
public void test_getSimpleName_Object8042() { 
     assertEquals("ClassUtils", ClassUtils.getSimpleName(new ClassUtils(), "<null>")); 
     assertEquals("Inner", ClassUtils.getSimpleName(new Inner(), "<null>")); 
     assertEquals("String", ClassUtils.getSimpleName("hello", "<null>")); 
     assertEquals("<null>", ClassUtils.getSimpleName(null, "<null>")); 
 }
@Test
public void test_getShortClassName_Class8147() { 
     assertEquals("ClassUtils", ClassUtils.getShortClassName(ClassUtils.class)); 
     assertEquals("Map.Entry", ClassUtils.getShortClassName(Map.Entry.class)); 
     assertEquals("", ClassUtils.getShortClassName((Class<?>) null)); 
     assertEquals("String[]", ClassUtils.getShortClassName(String[].class)); 
     assertEquals("Map.Entry[]", ClassUtils.getShortClassName(Map.Entry[].class)); 
     assertEquals("boolean", ClassUtils.getShortClassName(boolean.class)); 
     assertEquals("byte", ClassUtils.getShortClassName(byte.class)); 
     assertEquals("char", ClassUtils.getShortClassName(char.class)); 
     assertEquals("short", ClassUtils.getShortClassName(short.class)); 
     assertEquals("int", ClassUtils.getShortClassName(int.class)); 
     assertEquals("long", ClassUtils.getShortClassName(long.class)); 
     assertEquals("float", ClassUtils.getShortClassName(float.class)); 
     assertEquals("double", ClassUtils.getShortClassName(double.class)); 
     assertEquals("boolean[]", ClassUtils.getShortClassName(boolean[].class)); 
     assertEquals("byte[]", ClassUtils.getShortClassName(byte[].class)); 
     assertEquals("char[]", ClassUtils.getShortClassName(char[].class)); 
     assertEquals("short[]", ClassUtils.getShortClassName(short[].class)); 
     assertEquals("int[]", ClassUtils.getShortClassName(int[].class)); 
     assertEquals("long[]", ClassUtils.getShortClassName(long[].class)); 
     assertEquals("float[]", ClassUtils.getShortClassName(float[].class)); 
     assertEquals("double[]", ClassUtils.getShortClassName(double[].class)); 
     assertEquals("String[][]", ClassUtils.getShortClassName(String[][].class)); 
     assertEquals("String[][][]", ClassUtils.getShortClassName(String[][][].class)); 
     assertEquals("String[][][][]", ClassUtils.getShortClassName(String[][][][].class)); 
     class Named extends Object { 
     } 
     assertEquals("ClassUtilsTest.2", ClassUtils.getShortClassName(new Object() { 
     }.getClass())); 
     assertEquals("ClassUtilsTest.2Named", ClassUtils.getShortClassName(Named.class)); 
     assertEquals("ClassUtilsTest.Inner", ClassUtils.getShortClassName(Inner.class)); 
 }
@Test
public void testGetClassByNormalNameArrays2D8248() throws ClassNotFoundException { 
     assertEquals(int[][].class, ClassUtils.getClass("int[][]")); 
     assertEquals(long[][].class, ClassUtils.getClass("long[][]")); 
     assertEquals(short[][].class, ClassUtils.getClass("short[][]")); 
     assertEquals(byte[][].class, ClassUtils.getClass("byte[][]")); 
     assertEquals(char[][].class, ClassUtils.getClass("char[][]")); 
     assertEquals(float[][].class, ClassUtils.getClass("float[][]")); 
     assertEquals(double[][].class, ClassUtils.getClass("double[][]")); 
     assertEquals(boolean[][].class, ClassUtils.getClass("boolean[][]")); 
     assertEquals(String[][].class, ClassUtils.getClass("java.lang.String[][]")); 
 }
@Test
public void test_getShortCanonicalName_String8282() { 
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
public void testGetClassByNormalNameArrays2D8289() throws ClassNotFoundException { 
     assertEquals(int[][].class, ClassUtils.getClass("int[][]")); 
     assertEquals(long[][].class, ClassUtils.getClass("long[][]")); 
     assertEquals(short[][].class, ClassUtils.getClass("short[][]")); 
     assertEquals(byte[][].class, ClassUtils.getClass("byte[][]")); 
     assertEquals(char[][].class, ClassUtils.getClass("char[][]")); 
     assertEquals(float[][].class, ClassUtils.getClass("float[][]")); 
     assertEquals(double[][].class, ClassUtils.getClass("double[][]")); 
     assertEquals(boolean[][].class, ClassUtils.getClass("boolean[][]")); 
     assertEquals(String[][].class, ClassUtils.getClass("java.lang.String[][]")); 
 }
@Test
public void testGetPublicMethod8319() throws Exception { 
     final Set<?> set = Collections.unmodifiableSet(new HashSet<Object>()); 
     final Method isEmptyMethod = ClassUtils.getPublicMethod(set.getClass(), "isEmpty", new Class[0]); 
     assertTrue(Modifier.isPublic(isEmptyMethod.getDeclaringClass().getModifiers())); 
     try { 
         isEmptyMethod.invoke(set, new Object[0]); 
     } catch (final java.lang.IllegalAccessException iae) { 
         fail("Should not have thrown IllegalAccessException"); 
     } 
     final Method toStringMethod = ClassUtils.getPublicMethod(Object.class, "toString", new Class[0]); 
     assertEquals(Object.class.getMethod("toString", new Class[0]), toStringMethod); 
 }
@Test
public void test_getSimpleName_Object8357() { 
     assertEquals("ClassUtils", ClassUtils.getSimpleName(new ClassUtils(), "<null>")); 
     assertEquals("Inner", ClassUtils.getSimpleName(new Inner(), "<null>")); 
     assertEquals("String", ClassUtils.getSimpleName("hello", "<null>")); 
     assertEquals("<null>", ClassUtils.getSimpleName(null, "<null>")); 
 }
@Test
public void testGetClassByNormalNameArrays2D8404() throws ClassNotFoundException { 
     assertEquals(int[][].class, ClassUtils.getClass("int[][]")); 
     assertEquals(long[][].class, ClassUtils.getClass("long[][]")); 
     assertEquals(short[][].class, ClassUtils.getClass("short[][]")); 
     assertEquals(byte[][].class, ClassUtils.getClass("byte[][]")); 
     assertEquals(char[][].class, ClassUtils.getClass("char[][]")); 
     assertEquals(float[][].class, ClassUtils.getClass("float[][]")); 
     assertEquals(double[][].class, ClassUtils.getClass("double[][]")); 
     assertEquals(boolean[][].class, ClassUtils.getClass("boolean[][]")); 
     assertEquals(String[][].class, ClassUtils.getClass("java.lang.String[][]")); 
 }
@Test
public void testGetPublicMethod8458() throws Exception { 
     final Set<?> set = Collections.unmodifiableSet(new HashSet<Object>()); 
     final Method isEmptyMethod = ClassUtils.getPublicMethod(set.getClass(), "isEmpty", new Class[0]); 
     assertTrue(Modifier.isPublic(isEmptyMethod.getDeclaringClass().getModifiers())); 
     try { 
         isEmptyMethod.invoke(set, new Object[0]); 
     } catch (final java.lang.IllegalAccessException iae) { 
         fail("Should not have thrown IllegalAccessException"); 
     } 
     final Method toStringMethod = ClassUtils.getPublicMethod(Object.class, "toString", new Class[0]); 
     assertEquals(Object.class.getMethod("toString", new Class[0]), toStringMethod); 
 }
@Test
public void test_getShortCanonicalName_Class8612() { 
     assertEquals("ClassUtils", ClassUtils.getShortCanonicalName(ClassUtils.class)); 
     assertEquals("ClassUtils[]", ClassUtils.getShortCanonicalName(ClassUtils[].class)); 
     assertEquals("ClassUtils[][]", ClassUtils.getShortCanonicalName(ClassUtils[][].class)); 
     assertEquals("int[]", ClassUtils.getShortCanonicalName(int[].class)); 
     assertEquals("int[][]", ClassUtils.getShortCanonicalName(int[][].class)); 
     class Named extends Object { 
     } 
     assertEquals("ClassUtilsTest.7", ClassUtils.getShortCanonicalName(new Object() { 
     }.getClass())); 
     assertEquals("ClassUtilsTest.6Named", ClassUtils.getShortCanonicalName(Named.class)); 
     assertEquals("ClassUtilsTest.Inner", ClassUtils.getShortCanonicalName(Inner.class)); 
 }
@Test
public void test_getShortClassName_Class8621() { 
     assertEquals("ClassUtils", ClassUtils.getShortClassName(ClassUtils.class)); 
     assertEquals("Map.Entry", ClassUtils.getShortClassName(Map.Entry.class)); 
     assertEquals("", ClassUtils.getShortClassName((Class<?>) null)); 
     assertEquals("String[]", ClassUtils.getShortClassName(String[].class)); 
     assertEquals("Map.Entry[]", ClassUtils.getShortClassName(Map.Entry[].class)); 
     assertEquals("boolean", ClassUtils.getShortClassName(boolean.class)); 
     assertEquals("byte", ClassUtils.getShortClassName(byte.class)); 
     assertEquals("char", ClassUtils.getShortClassName(char.class)); 
     assertEquals("short", ClassUtils.getShortClassName(short.class)); 
     assertEquals("int", ClassUtils.getShortClassName(int.class)); 
     assertEquals("long", ClassUtils.getShortClassName(long.class)); 
     assertEquals("float", ClassUtils.getShortClassName(float.class)); 
     assertEquals("double", ClassUtils.getShortClassName(double.class)); 
     assertEquals("boolean[]", ClassUtils.getShortClassName(boolean[].class)); 
     assertEquals("byte[]", ClassUtils.getShortClassName(byte[].class)); 
     assertEquals("char[]", ClassUtils.getShortClassName(char[].class)); 
     assertEquals("short[]", ClassUtils.getShortClassName(short[].class)); 
     assertEquals("int[]", ClassUtils.getShortClassName(int[].class)); 
     assertEquals("long[]", ClassUtils.getShortClassName(long[].class)); 
     assertEquals("float[]", ClassUtils.getShortClassName(float[].class)); 
     assertEquals("double[]", ClassUtils.getShortClassName(double[].class)); 
     assertEquals("String[][]", ClassUtils.getShortClassName(String[][].class)); 
     assertEquals("String[][][]", ClassUtils.getShortClassName(String[][][].class)); 
     assertEquals("String[][][][]", ClassUtils.getShortClassName(String[][][][].class)); 
     class Named extends Object { 
     } 
     assertEquals("ClassUtilsTest.2", ClassUtils.getShortClassName(new Object() { 
     }.getClass())); 
     assertEquals("ClassUtilsTest.2Named", ClassUtils.getShortClassName(Named.class)); 
     assertEquals("ClassUtilsTest.Inner", ClassUtils.getShortClassName(Inner.class)); 
 }
@Test
public void test_convertClassesToClassNames_List8627() { 
     final List<Class<?>> list = new ArrayList<Class<?>>(); 
     List<String> result = ClassUtils.convertClassesToClassNames(list); 
     assertEquals(0, result.size()); 
     list.add(String.class); 
     list.add(null); 
     list.add(Object.class); 
     result = ClassUtils.convertClassesToClassNames(list); 
     assertEquals(3, result.size()); 
     assertEquals("java.lang.String", result.get(0)); 
     assertEquals(null, result.get(1)); 
     assertEquals("java.lang.Object", result.get(2)); 
     @SuppressWarnings("unchecked") 
     final List<Object> olist = (List<Object>) (List<?>) list; 
     olist.add(new Object()); 
     try { 
         ClassUtils.convertClassesToClassNames(list); 
         fail("Should not have been able to convert list"); 
     } catch (final ClassCastException expected) { 
     } 
     assertEquals(null, ClassUtils.convertClassesToClassNames(null)); 
 }
@Test
public void test_getShortCanonicalName_Object8685() { 
     assertEquals("<null>", ClassUtils.getShortCanonicalName(null, "<null>")); 
     assertEquals("ClassUtils", ClassUtils.getShortCanonicalName(new ClassUtils(), "<null>")); 
     assertEquals("ClassUtils[]", ClassUtils.getShortCanonicalName(new ClassUtils[0], "<null>")); 
     assertEquals("ClassUtils[][]", ClassUtils.getShortCanonicalName(new ClassUtils[0][0], "<null>")); 
     assertEquals("int[]", ClassUtils.getShortCanonicalName(new int[0], "<null>")); 
     assertEquals("int[][]", ClassUtils.getShortCanonicalName(new int[0][0], "<null>")); 
     class Named extends Object { 
     } 
     assertEquals("ClassUtilsTest.6", ClassUtils.getShortCanonicalName(new Object() { 
     }, "<null>")); 
     assertEquals("ClassUtilsTest.5Named", ClassUtils.getShortCanonicalName(new Named(), "<null>")); 
     assertEquals("ClassUtilsTest.Inner", ClassUtils.getShortCanonicalName(new Inner(), "<null>")); 
 }
@Test
public void test_getPackageCanonicalName_Object8688() { 
     assertEquals("<null>", ClassUtils.getPackageCanonicalName(null, "<null>")); 
     assertEquals("org.apache.commons.lang3", ClassUtils.getPackageCanonicalName(new ClassUtils(), "<null>")); 
     assertEquals("org.apache.commons.lang3", ClassUtils.getPackageCanonicalName(new ClassUtils[0], "<null>")); 
     assertEquals("org.apache.commons.lang3", ClassUtils.getPackageCanonicalName(new ClassUtils[0][0], "<null>")); 
     assertEquals("", ClassUtils.getPackageCanonicalName(new int[0], "<null>")); 
     assertEquals("", ClassUtils.getPackageCanonicalName(new int[0][0], "<null>")); 
     class Named extends Object { 
     } 
     assertEquals("org.apache.commons.lang3", ClassUtils.getPackageCanonicalName(new Object() { 
     }, "<null>")); 
     assertEquals("org.apache.commons.lang3", ClassUtils.getPackageCanonicalName(new Named(), "<null>")); 
     assertEquals("org.apache.commons.lang3", ClassUtils.getPackageCanonicalName(new Inner(), "<null>")); 
 }
@Test
public void test_getSimpleName_Class8783() { 
     assertEquals("ClassUtils", ClassUtils.getSimpleName(ClassUtils.class)); 
     assertEquals("Entry", ClassUtils.getSimpleName(Map.Entry.class)); 
     assertEquals("", ClassUtils.getSimpleName((Class<?>) null)); 
     assertEquals("String[]", ClassUtils.getSimpleName(String[].class)); 
     assertEquals("Entry[]", ClassUtils.getSimpleName(Map.Entry[].class)); 
     assertEquals("boolean", ClassUtils.getSimpleName(boolean.class)); 
     assertEquals("byte", ClassUtils.getSimpleName(byte.class)); 
     assertEquals("char", ClassUtils.getSimpleName(char.class)); 
     assertEquals("short", ClassUtils.getSimpleName(short.class)); 
     assertEquals("int", ClassUtils.getSimpleName(int.class)); 
     assertEquals("long", ClassUtils.getSimpleName(long.class)); 
     assertEquals("float", ClassUtils.getSimpleName(float.class)); 
     assertEquals("double", ClassUtils.getSimpleName(double.class)); 
     assertEquals("boolean[]", ClassUtils.getSimpleName(boolean[].class)); 
     assertEquals("byte[]", ClassUtils.getSimpleName(byte[].class)); 
     assertEquals("char[]", ClassUtils.getSimpleName(char[].class)); 
     assertEquals("short[]", ClassUtils.getSimpleName(short[].class)); 
     assertEquals("int[]", ClassUtils.getSimpleName(int[].class)); 
     assertEquals("long[]", ClassUtils.getSimpleName(long[].class)); 
     assertEquals("float[]", ClassUtils.getSimpleName(float[].class)); 
     assertEquals("double[]", ClassUtils.getSimpleName(double[].class)); 
     assertEquals("String[][]", ClassUtils.getSimpleName(String[][].class)); 
     assertEquals("String[][][]", ClassUtils.getSimpleName(String[][][].class)); 
     assertEquals("String[][][][]", ClassUtils.getSimpleName(String[][][][].class)); 
     class Named extends Object { 
     } 
     assertEquals("", ClassUtils.getSimpleName(new Object() { 
     }.getClass())); 
     assertEquals("Named", ClassUtils.getSimpleName(Named.class)); 
 }
@Test
public void test_isAssignable_NoAutoboxing8848() throws Exception { 
     assertFalse(ClassUtils.isAssignable((Class<?>) null, null, false)); 
     assertFalse(ClassUtils.isAssignable(String.class, null, false)); 
     assertTrue(ClassUtils.isAssignable(null, Object.class, false)); 
     assertTrue(ClassUtils.isAssignable(null, Integer.class, false)); 
     assertFalse(ClassUtils.isAssignable(null, Integer.TYPE, false)); 
     assertTrue(ClassUtils.isAssignable(String.class, Object.class, false)); 
     assertTrue(ClassUtils.isAssignable(String.class, String.class, false)); 
     assertFalse(ClassUtils.isAssignable(Object.class, String.class, false)); 
     assertFalse(ClassUtils.isAssignable(Integer.TYPE, Integer.class, false)); 
     assertFalse(ClassUtils.isAssignable(Integer.TYPE, Object.class, false)); 
     assertFalse(ClassUtils.isAssignable(Integer.class, Integer.TYPE, false)); 
     assertTrue(ClassUtils.isAssignable(Integer.TYPE, Integer.TYPE, false)); 
     assertTrue(ClassUtils.isAssignable(Integer.class, Integer.class, false)); 
     assertFalse(ClassUtils.isAssignable(Boolean.TYPE, Boolean.class, false)); 
     assertFalse(ClassUtils.isAssignable(Boolean.TYPE, Object.class, false)); 
     assertFalse(ClassUtils.isAssignable(Boolean.class, Boolean.TYPE, false)); 
     assertTrue(ClassUtils.isAssignable(Boolean.class, Object.class, false)); 
     assertTrue(ClassUtils.isAssignable(Boolean.TYPE, Boolean.TYPE, false)); 
     assertTrue(ClassUtils.isAssignable(Boolean.class, Boolean.class, false)); 
 }
@Test
public void test_getPackageName_Object8871() { 
     assertEquals("org.apache.commons.lang3", ClassUtils.getPackageName(new ClassUtils(), "<null>")); 
     assertEquals("org.apache.commons.lang3", ClassUtils.getPackageName(new Inner(), "<null>")); 
     assertEquals("<null>", ClassUtils.getPackageName(null, "<null>")); 
 }
@Test
public void testGetClassByNormalNameArrays2D9119() throws ClassNotFoundException { 
     assertEquals(int[][].class, ClassUtils.getClass("int[][]")); 
     assertEquals(long[][].class, ClassUtils.getClass("long[][]")); 
     assertEquals(short[][].class, ClassUtils.getClass("short[][]")); 
     assertEquals(byte[][].class, ClassUtils.getClass("byte[][]")); 
     assertEquals(char[][].class, ClassUtils.getClass("char[][]")); 
     assertEquals(float[][].class, ClassUtils.getClass("float[][]")); 
     assertEquals(double[][].class, ClassUtils.getClass("double[][]")); 
     assertEquals(boolean[][].class, ClassUtils.getClass("boolean[][]")); 
     assertEquals(String[][].class, ClassUtils.getClass("java.lang.String[][]")); 
 }
@Test
public void testGetClassByNormalNameArrays2D9140() throws ClassNotFoundException { 
     assertEquals(int[][].class, ClassUtils.getClass("int[][]")); 
     assertEquals(long[][].class, ClassUtils.getClass("long[][]")); 
     assertEquals(short[][].class, ClassUtils.getClass("short[][]")); 
     assertEquals(byte[][].class, ClassUtils.getClass("byte[][]")); 
     assertEquals(char[][].class, ClassUtils.getClass("char[][]")); 
     assertEquals(float[][].class, ClassUtils.getClass("float[][]")); 
     assertEquals(double[][].class, ClassUtils.getClass("double[][]")); 
     assertEquals(boolean[][].class, ClassUtils.getClass("boolean[][]")); 
     assertEquals(String[][].class, ClassUtils.getClass("java.lang.String[][]")); 
 }
@Test
public void testGetPublicMethod9223() throws Exception { 
     final Set<?> set = Collections.unmodifiableSet(new HashSet<Object>()); 
     final Method isEmptyMethod = ClassUtils.getPublicMethod(set.getClass(), "isEmpty", new Class[0]); 
     assertTrue(Modifier.isPublic(isEmptyMethod.getDeclaringClass().getModifiers())); 
     try { 
         isEmptyMethod.invoke(set, new Object[0]); 
     } catch (final java.lang.IllegalAccessException iae) { 
         fail("Should not have thrown IllegalAccessException"); 
     } 
     final Method toStringMethod = ClassUtils.getPublicMethod(Object.class, "toString", new Class[0]); 
     assertEquals(Object.class.getMethod("toString", new Class[0]), toStringMethod); 
 }
@Test
public void testToClass_object9263() { 
     assertNull(ClassUtils.toClass((Object[]) null)); 
     assertTrue("empty -> empty", Arrays.equals(ArrayUtils.EMPTY_CLASS_ARRAY, ClassUtils.toClass())); 
     final Class<?>[] castNull = ClassUtils.toClass((Object) null); 
     assertTrue("(Object)null -> [null]", Arrays.equals(new Object[] { null }, castNull)); 
     assertSame(ArrayUtils.EMPTY_CLASS_ARRAY, ClassUtils.toClass(ArrayUtils.EMPTY_OBJECT_ARRAY)); 
     assertTrue(Arrays.equals(new Class[] { String.class, Integer.class, Double.class }, ClassUtils.toClass(new Object[] { "Test", Integer.valueOf(1), Double.valueOf(99d) }))); 
     assertTrue(Arrays.equals(new Class[] { String.class, null, Double.class }, ClassUtils.toClass(new Object[] { "Test", null, Double.valueOf(99d) }))); 
 }
@Test
public void test_convertClassNamesToClasses_List9264() { 
     final List<String> list = new ArrayList<String>(); 
     List<Class<?>> result = ClassUtils.convertClassNamesToClasses(list); 
     assertEquals(0, result.size()); 
     list.add("java.lang.String"); 
     list.add("java.lang.xxx"); 
     list.add("java.lang.Object"); 
     result = ClassUtils.convertClassNamesToClasses(list); 
     assertEquals(3, result.size()); 
     assertEquals(String.class, result.get(0)); 
     assertEquals(null, result.get(1)); 
     assertEquals(Object.class, result.get(2)); 
     @SuppressWarnings("unchecked") 
     final List<Object> olist = (List<Object>) (List<?>) list; 
     olist.add(new Object()); 
     try { 
         ClassUtils.convertClassNamesToClasses(list); 
         fail("Should not have been able to convert list"); 
     } catch (final ClassCastException expected) { 
     } 
     assertEquals(null, ClassUtils.convertClassNamesToClasses(null)); 
 }
@Test
public void testGetPublicMethod9312() throws Exception { 
     final Set<?> set = Collections.unmodifiableSet(new HashSet<Object>()); 
     final Method isEmptyMethod = ClassUtils.getPublicMethod(set.getClass(), "isEmpty", new Class[0]); 
     assertTrue(Modifier.isPublic(isEmptyMethod.getDeclaringClass().getModifiers())); 
     try { 
         isEmptyMethod.invoke(set, new Object[0]); 
     } catch (final java.lang.IllegalAccessException iae) { 
         fail("Should not have thrown IllegalAccessException"); 
     } 
     final Method toStringMethod = ClassUtils.getPublicMethod(Object.class, "toString", new Class[0]); 
     assertEquals(Object.class.getMethod("toString", new Class[0]), toStringMethod); 
 }
@Test
public void testGetPublicMethod9469() throws Exception { 
     final Set<?> set = Collections.unmodifiableSet(new HashSet<Object>()); 
     final Method isEmptyMethod = ClassUtils.getPublicMethod(set.getClass(), "isEmpty", new Class[0]); 
     assertTrue(Modifier.isPublic(isEmptyMethod.getDeclaringClass().getModifiers())); 
     try { 
         isEmptyMethod.invoke(set, new Object[0]); 
     } catch (final java.lang.IllegalAccessException iae) { 
         fail("Should not have thrown IllegalAccessException"); 
     } 
     final Method toStringMethod = ClassUtils.getPublicMethod(Object.class, "toString", new Class[0]); 
     assertEquals(Object.class.getMethod("toString", new Class[0]), toStringMethod); 
 }
@Test
public void testGetPublicMethod9514() throws Exception { 
     final Set<?> set = Collections.unmodifiableSet(new HashSet<Object>()); 
     final Method isEmptyMethod = ClassUtils.getPublicMethod(set.getClass(), "isEmpty", new Class[0]); 
     assertTrue(Modifier.isPublic(isEmptyMethod.getDeclaringClass().getModifiers())); 
     try { 
         isEmptyMethod.invoke(set, new Object[0]); 
     } catch (final java.lang.IllegalAccessException iae) { 
         fail("Should not have thrown IllegalAccessException"); 
     } 
     final Method toStringMethod = ClassUtils.getPublicMethod(Object.class, "toString", new Class[0]); 
     assertEquals(Object.class.getMethod("toString", new Class[0]), toStringMethod); 
 }
@Test
public void testIsPrimitiveOrWrapper9531() { 
     assertTrue("Boolean.class", ClassUtils.isPrimitiveOrWrapper(Boolean.class)); 
     assertTrue("Byte.class", ClassUtils.isPrimitiveOrWrapper(Byte.class)); 
     assertTrue("Character.class", ClassUtils.isPrimitiveOrWrapper(Character.class)); 
     assertTrue("Short.class", ClassUtils.isPrimitiveOrWrapper(Short.class)); 
     assertTrue("Integer.class", ClassUtils.isPrimitiveOrWrapper(Integer.class)); 
     assertTrue("Long.class", ClassUtils.isPrimitiveOrWrapper(Long.class)); 
     assertTrue("Double.class", ClassUtils.isPrimitiveOrWrapper(Double.class)); 
     assertTrue("Float.class", ClassUtils.isPrimitiveOrWrapper(Float.class)); 
     assertTrue("boolean", ClassUtils.isPrimitiveOrWrapper(Boolean.TYPE)); 
     assertTrue("byte", ClassUtils.isPrimitiveOrWrapper(Byte.TYPE)); 
     assertTrue("char", ClassUtils.isPrimitiveOrWrapper(Character.TYPE)); 
     assertTrue("short", ClassUtils.isPrimitiveOrWrapper(Short.TYPE)); 
     assertTrue("int", ClassUtils.isPrimitiveOrWrapper(Integer.TYPE)); 
     assertTrue("long", ClassUtils.isPrimitiveOrWrapper(Long.TYPE)); 
     assertTrue("double", ClassUtils.isPrimitiveOrWrapper(Double.TYPE)); 
     assertTrue("float", ClassUtils.isPrimitiveOrWrapper(Float.TYPE)); 
     assertTrue("Void.TYPE", ClassUtils.isPrimitiveOrWrapper(Void.TYPE)); 
     assertFalse("null", ClassUtils.isPrimitiveOrWrapper(null)); 
     assertFalse("Void.class", ClassUtils.isPrimitiveOrWrapper(Void.class)); 
     assertFalse("String.class", ClassUtils.isPrimitiveOrWrapper(String.class)); 
     assertFalse("this.getClass()", ClassUtils.isPrimitiveOrWrapper(this.getClass())); 
 }
@Test
public void testWrapperToPrimitive9598() { 
 //        assertEquals(boolean.class, ClassUtils.wrapperToPrimitive(boolean.class)); 
         assertEquals(byte.class, ClassUtils.wrapperToPrimitive(byte.class)); 
         assertEquals(char.class, ClassUtils.wrapperToPrimitive(char.class)); 
         assertEquals(short.class, ClassUtils.wrapperToPrimitive(short.class)); 
         assertEquals(int.class, ClassUtils.wrapperToPrimitive(int.class)); 
         assertEquals(long.class, ClassUtils.wrapperToPrimitive(long.class)); 
         assertEquals(float.class, ClassUtils.wrapperToPrimitive(float.class)); 
         assertEquals(double.class, ClassUtils.wrapperToPrimitive(double.class)); 
  
         // Inner types 
         class Named extends Object {} 
         assertEquals(Object.class, ClassUtils.wrapperToPrimitive(new Object(){}.getClass())); 
         assertEquals(Object.class, ClassUtils.wrapperToPrimitive(new Object(){}.getClass())); 
     }
@Test
public void testPrimitivesToWrappersNull9616() { 
 //        assertNull("Wrong result for null input", ClassUtils.primitivesToWrappers(null)); // generates warning 
         assertNull("Wrong result for null input", ClassUtils.primitivesToWrappers((Class<?>[]) null)); // equivalent explicit cast 
          
         // Other possible casts for null 
         assertTrue("empty -> empty", Arrays.equals(ArrayUtils.EMPTY_CLASS_ARRAY, ClassUtils.primitivesToWrappers())); 
         final Class<?>[] castNull = ClassUtils.primitivesToWrappers((Class<?>)null); // == new Class<?>[]{null} 
         assertTrue("(Class<?>)null -> [null]", Arrays.equals(new Class<?>[]{null}, castNull)); 
 }
@Test
public void testIsAssignable_ClassArray_ClassArray_Autoboxing9675() { 
         final Class<?>[] array2 = new Class[] {Object.class, Object.class}; 
         final Class<?>[] array1 = new Class[] {String.class}; 
         final Class<?>[] array1s = new Class[] {String.class}; 
         final Class<?>[] array0 = new Class[] {}; 
         final Class<?>[] arrayPrimitives = { Integer.TYPE, Boolean.TYPE }; 
         final Class<?>[] arrayWrappers = { Integer.class, Boolean.class }; 
  
         assertFalse(ClassUtils.isAssignable(array1, array2, true)); 
         assertFalse(ClassUtils.isAssignable(null, array2, true)); 
         assertTrue(ClassUtils.isAssignable(null, array0, true)); 
         assertTrue(ClassUtils.isAssignable(array0, array0, true)); 
         assertTrue(ClassUtils.isAssignable(array0, array1, true)); 
         assertFalse(ClassUtils.isAssignable(array1, array2, true)); 
  
         assertFalse(ClassUtils.isAssignable(arrayPrimitives, array2, true)); 
  
         assertFalse(ClassUtils.isAssignable(arrayWrappers, array1, true)); 
         assertFalse(ClassUtils.isAssignable(arrayWrappers, array1, true)); 
         assertFalse(ClassUtils.isAssignable(arrayWrappers, array2, true)); 
  
         assertFalse(ClassUtils.isAssignable(arrayPrimitives, array1, true)); 
         assertFalse(ClassUtils.isAssignable(arrayWrappers, array2, true)); 
     }
@Test
public void testIsAssignable_ClassArray_ClassArray_Autoboxing9678() { 
         final Class<?>[] array2 = new Class[] {Object.class, Object.class}; 
         final Class<?>[] array1 = new Class[] {String.class}; 
         final Class<?>[] array1s = new Class[] {String.class}; 
         final Class<?>[] array0 = new Class[] {}; 
         final Class<?>[] arrayPrimitives = { Integer.TYPE, Boolean.TYPE }; 
         final Class<?>[] arrayWrappers = { Integer.class, Boolean.class }; 
  
         assertFalse(ClassUtils.isAssignable(array1, array2, true)); 
         assertFalse(ClassUtils.isAssignable(null, array2, true)); 
         assertTrue(ClassUtils.isAssignable(null, array0, true)); 
         assertTrue(ClassUtils.isAssignable(array0, array0, true)); 
         assertTrue(ClassUtils.isAssignable(array0, array1, true)); 
         assertFalse(ClassUtils.isAssignable(array1, array2, true)); 
  
         assertFalse(ClassUtils.isAssignable(arrayPrimitives, array2, true)); 
  
         assertFalse(ClassUtils.isAssignable(arrayWrappers, array1, true)); 
         assertFalse(ClassUtils.isAssignable(arrayWrappers, array1, true)); 
         assertFalse(ClassUtils.isAssignable(arrayWrappers, array2, true)); 
  
         assertFalse(ClassUtils.isAssignable(arrayPrimitives, array1, true)); 
         assertFalse(ClassUtils.isAssignable(arrayWrappers, array2, true)); 
     }
@Test
public void testGetPublicMethod10809() throws Exception { 
         // Tests with Collections$UnmodifiableSet 
         final Set<?> set = Collections.unmodifiableSet(new HashSet<Object>()); 
         final Method isEmptyMethod = ClassUtils.getPublicMethod(set.getClass(), "isEmpty",  new Class[0]); 
             assertTrue(Modifier.isPublic(isEmptyMethod.getDeclaringClass().getModifiers())); 
  
         try { 
             isEmptyMethod.invoke(set, new Object[0]); 
         } catch(final java.lang.IllegalAccessException iae) { 
             fail("Should not have thrown IllegalAccessException"); 
         } 
  
         // Tests with a public Class 
         final Method toStringMethod = ClassUtils.getPublicMethod(Object.class, "toString",  new Class[0]); 
             assertEquals(Object.class.getMethod("toString", new Class[0]), toStringMethod); 
     }
@Test
public void testGetPublicMethod10828() throws Exception { 
         // Tests with Collections$UnmodifiableSet 
         final Set<?> set = Collections.unmodifiableSet(new HashSet<Object>()); 
         final Method isEmptyMethod = ClassUtils.getPublicMethod(set.getClass(), "isEmpty",  new Class[0]); 
             assertTrue(Modifier.isPublic(isEmptyMethod.getDeclaringClass().getModifiers())); 
  
         try { 
             isEmptyMethod.invoke(set, new Object[0]); 
         } catch(final java.lang.IllegalAccessException iae) { 
             fail("Should not have thrown IllegalAccessException"); 
         } 
  
         // Tests with a public Class 
         final Method toStringMethod = ClassUtils.getPublicMethod(Object.class, "toString",  new Class[0]); 
             assertEquals(Object.class.getMethod("toString", new Class[0]), toStringMethod); 
     }
@Test
public void testPrimitivesToWrappersNull11300() { 
 //        assertNull("Wrong result for null input", ClassUtils.primitivesToWrappers(null)); // generates warning 
         assertNull("Wrong result for null input", ClassUtils.primitivesToWrappers((Class<?>[]) null)); // equivalent cast 
          
         // Other possible casts for null 
         assertTrue("empty -> empty", Arrays.equals(ArrayUtils.EMPTY_CLASS_ARRAY, ClassUtils.primitivesToWrappers())); 
         final Class<?>[] castNull = ClassUtils.primitivesToWrappers((Class<?>)null); // == new Class<?>[]{null} 
         assertTrue("(Class<?>)null -> [null]", Arrays.equals(new Class<?>[]{null}, castNull)); 
 }
@Test
public void testPrimitivesToWrappersNull11301() { 
 //        assertNull("Wrong result for null input", ClassUtils.primitivesToWrappers(null)); // generates warning 
         assertNull("Wrong result for null input", ClassUtils.primitivesToWrappers((Class<?>[]) null)); // equivalent cast 
          
         // Other possible casts for null 
         assertTrue("empty -> empty", Arrays.equals(ArrayUtils.EMPTY_CLASS_ARRAY, ClassUtils.primitivesToWrappers())); 
         final Class<?>[] castNull = ClassUtils.primitivesToWrappers((Class<?>)null); // == new Class<?>[]{null} 
         assertTrue("(Class<?>)null -> [null]", Arrays.equals(new Class<?>[]{null}, castNull)); 
 }
@Test
public void testPrimitivesToWrappersNull11302() { 
 //        assertNull("Wrong result for null input", ClassUtils.primitivesToWrappers(null)); // generates warning 
         assertNull("Wrong result for null input", ClassUtils.primitivesToWrappers((Class<?>[]) null)); // equivalent cast 
          
         // Other possible casts for null 
         assertTrue("empty -> empty", Arrays.equals(ArrayUtils.EMPTY_CLASS_ARRAY, ClassUtils.primitivesToWrappers())); 
         final Class<?>[] castNull = ClassUtils.primitivesToWrappers((Class<?>)null); // == new Class<?>[]{null} 
         assertTrue("(Class<?>)null -> [null]", Arrays.equals(new Class<?>[]{null}, castNull)); 
 }
@Test
public void testPrimitivesToWrappersNull11303() { 
 //        assertNull("Wrong result for null input", ClassUtils.primitivesToWrappers(null)); // generates warning 
         assertNull("Wrong result for null input", ClassUtils.primitivesToWrappers((Class<?>[]) null)); // equivalent cast 
          
         // Other possible casts for null 
         assertTrue("empty -> empty", Arrays.equals(ArrayUtils.EMPTY_CLASS_ARRAY, ClassUtils.primitivesToWrappers())); 
         final Class<?>[] castNull = ClassUtils.primitivesToWrappers((Class<?>)null); // == new Class<?>[]{null} 
         assertTrue("(Class<?>)null -> [null]", Arrays.equals(new Class<?>[]{null}, castNull)); 
 }
@Test
public void testPrimitivesToWrappersNull11304() { 
 //        assertNull("Wrong result for null input", ClassUtils.primitivesToWrappers(null)); // generates warning 
         assertNull("Wrong result for null input", ClassUtils.primitivesToWrappers((Class<?>[]) null)); // equivalent explicit cast 
          
         // Other possible casts for null 
         assertTrue("empty -> empty", Arrays.equals(ArrayUtils.EMPTY_CLASS_ARRAY, ClassUtils.primitivesToWrappers())); 
         final Class<?>[] castNull = ClassUtils.primitivesToWrappers((Class<?>)null); // == new Class<?>[]{null} 
         assertTrue("(Class<?>)null -> [null]", Arrays.equals(new Class<?>[]{null}, castNull)); 
 }
@Test
public void testPrimitivesToWrappersNull11305() { 
 //        assertNull("Wrong result for null input", ClassUtils.primitivesToWrappers(null)); // generates warning 
         assertNull("Wrong result for null input", ClassUtils.primitivesToWrappers((Class<?>[]) null)); // equivalent explicit cast 
          
         // Other possible casts for null 
         assertTrue("empty -> empty", Arrays.equals(ArrayUtils.EMPTY_CLASS_ARRAY, ClassUtils.primitivesToWrappers())); 
         final Class<?>[] castNull = ClassUtils.primitivesToWrappers((Class<?>)null); // == new Class<?>[]{null} 
         assertTrue("(Class<?>)null -> [null]", Arrays.equals(new Class<?>[]{null}, castNull)); 
 }
@Test
public void testPrimitivesToWrappersNull11306() { 
 //        assertNull("Wrong result for null input", ClassUtils.primitivesToWrappers(null)); // generates warning 
         assertNull("Wrong result for null input", ClassUtils.primitivesToWrappers((Class<?>[]) null)); // equivalent explicit cast 
          
         // Other possible casts for null 
         assertTrue("empty -> empty", Arrays.equals(ArrayUtils.EMPTY_CLASS_ARRAY, ClassUtils.primitivesToWrappers())); 
         final Class<?>[] castNull = ClassUtils.primitivesToWrappers((Class<?>)null); // == new Class<?>[]{null} 
         assertTrue("(Class<?>)null -> [null]", Arrays.equals(new Class<?>[]{null}, castNull)); 
 }
@Test
public void testPrimitivesToWrappersNull11307() { 
 //        assertNull("Wrong result for null input", ClassUtils.primitivesToWrappers(null)); // generates warning 
         assertNull("Wrong result for null input", ClassUtils.primitivesToWrappers((Class<?>[]) null)); // equivalent explicit cast 
          
         // Other possible casts for null 
         assertTrue("empty -> empty", Arrays.equals(ArrayUtils.EMPTY_CLASS_ARRAY, ClassUtils.primitivesToWrappers())); 
         final Class<?>[] castNull = ClassUtils.primitivesToWrappers((Class<?>)null); // == new Class<?>[]{null} 
         assertTrue("(Class<?>)null -> [null]", Arrays.equals(new Class<?>[]{null}, castNull)); 
 }
@Test
public void testIsAssignable_ClassArray_ClassArray_Autoboxing12427() { 
         final Class<?>[] array2 = new Class[] {Object.class, Object.class}; 
         final Class<?>[] array1 = new Class[] {String.class}; 
         final Class<?>[] array1s = new Class[] {String.class}; 
         final Class<?>[] array0 = new Class[] {}; 
         final Class<?>[] arrayPrimitives = { Integer.TYPE, Boolean.TYPE }; 
         final Class<?>[] arrayWrappers = { Integer.class, Boolean.class }; 
  
         assertFalse(ClassUtils.isAssignable(array1, array2, true)); 
         assertFalse(ClassUtils.isAssignable(null, array2, true)); 
         assertTrue(ClassUtils.isAssignable(null, array0, true)); 
         assertTrue(ClassUtils.isAssignable(array0, array0, true)); 
         assertTrue(ClassUtils.isAssignable(array0, array1, true)); 
         assertFalse(ClassUtils.isAssignable(array1, array2, true)); 
  
         assertFalse(ClassUtils.isAssignable(arrayPrimitives, array2, true)); 
  
         assertFalse(ClassUtils.isAssignable(arrayWrappers, array1, true)); 
         assertFalse(ClassUtils.isAssignable(arrayWrappers, array1, true)); 
         assertFalse(ClassUtils.isAssignable(arrayWrappers, array2, true)); 
  
         assertFalse(ClassUtils.isAssignable(arrayPrimitives, array1, true)); 
         assertFalse(ClassUtils.isAssignable(arrayWrappers, array2, true)); 
     }
@Test
public void testIsAssignable_ClassArray_ClassArray_Autoboxing12428() { 
         final Class<?>[] array2 = new Class[] {Object.class, Object.class}; 
         final Class<?>[] array1 = new Class[] {String.class}; 
         final Class<?>[] array1s = new Class[] {String.class}; 
         final Class<?>[] array0 = null; 
         final Class<?>[] arrayPrimitives = { Integer.TYPE, Boolean.TYPE }; 
         final Class<?>[] arrayWrappers = { Integer.class, Boolean.class }; 
  
         assertFalse(ClassUtils.isAssignable(array1, array2, true)); 
         assertFalse(ClassUtils.isAssignable(null, array2, true)); 
         assertTrue(ClassUtils.isAssignable(null, array0, true)); 
         assertTrue(ClassUtils.isAssignable(array0, array0, true)); 
         assertTrue(ClassUtils.isAssignable(array0, array1, true)); 
         assertFalse(ClassUtils.isAssignable(array1, array2, true)); 
  
         assertFalse(ClassUtils.isAssignable(arrayPrimitives, array2, true)); 
         assertFalse(ClassUtils.isAssignable(arrayWrappers, array0, true)); 
         assertFalse(ClassUtils.isAssignable(arrayWrappers, array1, true)); 
         assertFalse(ClassUtils.isAssignable(arrayWrappers, array1, true)); 
         assertFalse(ClassUtils.isAssignable(arrayWrappers, array2, true)); 
  
         assertFalse(ClassUtils.isAssignable(arrayWrappers, array2, true)); 
     }
@Test
public void testIsAssignable_ClassArray_ClassArray_Autoboxing12429() { 
         final Class<?>[] array2 = new Class[] {Object.class, Object.class}; 
         final Class<?>[] array1 = new Class[] {String.class}; 
         final Class<?>[] array1s = new Class[] {String.class}; 
         final Class<?>[] array0 = new Class[] {}; 
         final Class<?>[] arrayPrimitives = { Integer.TYPE, Boolean.TYPE }; 
         final Class<?>[] arrayWrappers = { Integer.class, Boolean.class }; 
  
         assertFalse(ClassUtils.isAssignable(array1, array2, true)); 
         assertFalse(ClassUtils.isAssignable(null, array2, true)); 
         assertTrue(ClassUtils.isAssignable(null, array0, true)); 
         assertTrue(ClassUtils.isAssignable(array0, array0, true)); 
         assertTrue(ClassUtils.isAssignable(array0, array1, true)); 
         assertFalse(ClassUtils.isAssignable(array1, array2, true)); 
  
         assertFalse(ClassUtils.isAssignable(arrayPrimitives, array2, true)); 
  
         assertFalse(ClassUtils.isAssignable(arrayWrappers, array1, true)); 
         assertFalse(ClassUtils.isAssignable(arrayWrappers, array1, true)); 
         assertFalse(ClassUtils.isAssignable(arrayWrappers, array2, true)); 
  
         assertFalse(ClassUtils.isAssignable(arrayPrimitives, array1, true)); 
         assertFalse(ClassUtils.isAssignable(arrayWrappers, array2, true)); 
     }
@Test
public void testIsAssignable_ClassArray_ClassArray_Autoboxing12430() { 
         final Class<?>[] array2 = new Class[] {Object.class, Object.class}; 
         final Class<?>[] array1 = new Class[] {String.class}; 
         final Class<?>[] array1s = new Class[] {String.class}; 
         final Class<?>[] array0 = new Class[] {}; 
         final Class<?>[] arrayPrimitives = { Integer.TYPE, Boolean.TYPE }; 
         final Class<?>[] arrayWrappers = { Integer.class, Boolean.class }; 
  
         assertFalse(ClassUtils.isAssignable(array1, array2, true)); 
         assertFalse(ClassUtils.isAssignable(null, array2, true)); 
         assertTrue(ClassUtils.isAssignable(null, array0, true)); 
         assertTrue(ClassUtils.isAssignable(array0, array0, true)); 
         assertTrue(ClassUtils.isAssignable(array0, array1, true)); 
         assertFalse(ClassUtils.isAssignable(array1, array2, true)); 
  
         assertFalse(ClassUtils.isAssignable(arrayPrimitives, array2, true)); 
  
         assertFalse(ClassUtils.isAssignable(arrayWrappers, array1, true)); 
         assertFalse(ClassUtils.isAssignable(arrayWrappers, array1, true)); 
         assertFalse(ClassUtils.isAssignable(arrayWrappers, array2, true)); 
  
         assertFalse(ClassUtils.isAssignable(arrayPrimitives, array1, true)); 
         assertFalse(ClassUtils.isAssignable(arrayWrappers, array2, true)); 
     }
@Test
public void testIsAssignable_ClassArray_ClassArray_Autoboxing12431() { 
         final Class<?>[] array2 = new Class[] {Object.class, Object.class}; 
         final Class<?>[] array1 = new Class[] {String.class}; 
         final Class<?>[] array1s = new Class[] {String.class}; 
         final Class<?>[] array0 = new Class[] {}; 
         final Class<?>[] arrayPrimitives = { Integer.TYPE, Boolean.TYPE }; 
         final Class<?>[] arrayWrappers = { Integer.class, Boolean.class }; 
  
         assertFalse(ClassUtils.isAssignable(array1, array2, true)); 
         assertFalse(ClassUtils.isAssignable(null, array2, true)); 
         assertTrue(ClassUtils.isAssignable(null, array0, true)); 
         assertTrue(ClassUtils.isAssignable(array0, array0, true)); 
         assertTrue(ClassUtils.isAssignable(array0, array1, true)); 
         assertFalse(ClassUtils.isAssignable(array1, array2, true)); 
  
         assertFalse(ClassUtils.isAssignable(arrayPrimitives, array2, true)); 
  
         assertFalse(ClassUtils.isAssignable(arrayWrappers, array1, true)); 
         assertFalse(ClassUtils.isAssignable(arrayWrappers, array1, true)); 
         assertFalse(ClassUtils.isAssignable(arrayWrappers, array2, true)); 
  
         assertFalse(ClassUtils.isAssignable(arrayPrimitives, array1, true)); 
         assertFalse(ClassUtils.isAssignable(arrayWrappers, array2, true)); 
     }
@Test
public void testIsAssignable_ClassArray_ClassArray_Autoboxing12432() { 
         final Class<?>[] array2 = new Class[] {Object.class, Object.class}; 
         final Class<?>[] array1 = new Class[] {String.class}; 
         final Class<?>[] array1s = new Class[] {String.class}; 
         final Class<?>[] array0 = new Class[] {}; 
         final Class<?>[] arrayPrimitives = { Integer.TYPE, Boolean.TYPE }; 
         final Class<?>[] arrayWrappers = { Integer.class, Boolean.class }; 
  
         assertFalse(ClassUtils.isAssignable(array1, array2, true)); 
         assertFalse(ClassUtils.isAssignable(null, array2, true)); 
         assertTrue(ClassUtils.isAssignable(null, array0, true)); 
         assertTrue(ClassUtils.isAssignable(array0, array0, true)); 
         assertTrue(ClassUtils.isAssignable(array0, array1, true)); 
         assertFalse(ClassUtils.isAssignable(array1, array2, true)); 
  
         assertFalse(ClassUtils.isAssignable(arrayPrimitives, array2, true)); 
  
         assertFalse(ClassUtils.isAssignable(arrayWrappers, array1, true)); 
         assertFalse(ClassUtils.isAssignable(arrayWrappers, array1, true)); 
         assertFalse(ClassUtils.isAssignable(arrayWrappers, array2, true)); 
  
         assertFalse(ClassUtils.isAssignable(arrayPrimitives, array1, true)); 
         assertFalse(ClassUtils.isAssignable(arrayWrappers, array2, true)); 
     }
@Test
public void testIsAssignable_ClassArray_ClassArray_Autoboxing12433() { 
         final Class<?>[] array2 = new Class[] {Object.class, Object.class}; 
         final Class<?>[] array1 = new Class[] {String.class}; 
         final Class<?>[] array1s = new Class[] {String.class}; 
         final Class<?>[] array0 = new Class[] {}; 
         final Class<?>[] arrayPrimitives = { Integer.TYPE, Boolean.TYPE }; 
         final Class<?>[] arrayWrappers = { Integer.class, Boolean.class }; 
  
         assertFalse(ClassUtils.isAssignable(array1, array2, true)); 
         assertFalse(ClassUtils.isAssignable(null, array2, true)); 
         assertTrue(ClassUtils.isAssignable(null, array0, true)); 
         assertTrue(ClassUtils.isAssignable(array0, array0, true)); 
         assertTrue(ClassUtils.isAssignable(array0, array1, true)); 
         assertFalse(ClassUtils.isAssignable(array1, array2, true)); 
  
         assertFalse(ClassUtils.isAssignable(arrayPrimitives, array2, true)); 
         assertFalse(ClassUtils.isAssignable(arrayWrappers, array1s, true)); 
         assertFalse(ClassUtils.isAssignable(arrayWrappers, array1, true)); 
         assertFalse(ClassUtils.isAssignable(arrayWrappers, array1, true)); 
         assertFalse(ClassUtils.isAssignable(arrayWrappers, array2, true)); 
  
         assertFalse(ClassUtils.isAssignable(arrayWrappers, array2, true)); 
     }
@Test
public void testIsAssignable_ClassArray_ClassArray_Autoboxing12434() { 
         final Class<?>[] array2 = new Class[] {Object.class, Object.class}; 
         final Class<?>[] array1 = new Class[] {String.class}; 
         final Class<?>[] array1s = new Class[] {String.class}; 
         final Class<?>[] array0 = new Class[] {}; 
         final Class<?>[] arrayPrimitives = { Integer.TYPE, Boolean.TYPE }; 
         final Class<?>[] arrayWrappers = { Integer.class, Boolean.class }; 
  
         assertFalse(ClassUtils.isAssignable(array1, array2, true)); 
         assertFalse(ClassUtils.isAssignable(null, array2, true)); 
         assertTrue(ClassUtils.isAssignable(null, array0, true)); 
         assertTrue(ClassUtils.isAssignable(array0, array0, true)); 
         assertTrue(ClassUtils.isAssignable(array0, array1, true)); 
         assertFalse(ClassUtils.isAssignable(array1, array2, true)); 
  
         assertFalse(ClassUtils.isAssignable(arrayPrimitives, array2, true)); 
  
         assertFalse(ClassUtils.isAssignable(arrayWrappers, array1, true)); 
         assertFalse(ClassUtils.isAssignable(arrayWrappers, array1, true)); 
         assertFalse(ClassUtils.isAssignable(arrayWrappers, array2, true)); 
  
         assertFalse(ClassUtils.isAssignable(arrayPrimitives, array1, true)); 
         assertFalse(ClassUtils.isAssignable(arrayWrappers, array2, true)); 
     }
@Test
public void testIsAssignable_ClassArray_ClassArray_Autoboxing12435() { 
         final Class<?>[] array2 = new Class[] {Object.class, Object.class}; 
         final Class<?>[] array1 = new Class[] {String.class}; 
         final Class<?>[] array1s = new Class[] {String.class}; 
         final Class<?>[] array0 = new Class[] {}; 
         final Class<?>[] arrayPrimitives = { Integer.TYPE, Boolean.TYPE }; 
         final Class<?>[] arrayWrappers = { Integer.class, Boolean.class }; 
  
         assertFalse(ClassUtils.isAssignable(null, array2, true)); 
         assertFalse(ClassUtils.isAssignable(null, array2, true)); 
         assertTrue(ClassUtils.isAssignable(array0, array0, true)); 
         assertTrue(ClassUtils.isAssignable(array0, array0, true)); 
         assertTrue(ClassUtils.isAssignable(array0, array1, true)); 
         assertTrue(ClassUtils.isAssignable(array1, array1s, true)); 
         assertTrue(ClassUtils.isAssignable(array1s, array2, true)); 
  
         assertTrue(ClassUtils.isAssignable(arrayPrimitives, arrayWrappers, true)); 
         assertTrue(ClassUtils.isAssignable(arrayWrappers, arrayPrimitives, true)); 
         assertTrue(ClassUtils.isAssignable(arrayWrappers, array1, true)); 
         assertTrue(ClassUtils.isAssignable(arrayWrappers, array2, true)); 
  
         assertFalse(ClassUtils.isAssignable(arrayPrimitives, array1, true)); 
         assertFalse(ClassUtils.isAssignable(arrayPrimitives, array2, true)); 
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
