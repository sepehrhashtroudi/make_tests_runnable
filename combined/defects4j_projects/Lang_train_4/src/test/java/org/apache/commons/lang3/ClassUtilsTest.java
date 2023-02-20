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
public void test_getPackageCanonicalName_Object173() { 
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
public void test_getShortClassName_Object174() { 
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
public void test_getShortClassName_Class175() { 
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
public void test_getShortClassName_String176() { 
     assertEquals("ClassUtils", ClassUtils.getShortClassName(ClassUtils.class.getName())); 
     assertEquals("Map.Entry", ClassUtils.getShortClassName(Map.Entry.class.getName())); 
     assertEquals("", ClassUtils.getShortClassName((String) null)); 
     assertEquals("", ClassUtils.getShortClassName("")); 
 }
@Test
public void test_getSimpleName_Object177() { 
     assertEquals("ClassUtils", ClassUtils.getSimpleName(new ClassUtils(), "<null>")); 
     assertEquals("Inner", ClassUtils.getSimpleName(new Inner(), "<null>")); 
     assertEquals("String", ClassUtils.getSimpleName("hello", "<null>")); 
     assertEquals("<null>", ClassUtils.getSimpleName(null, "<null>")); 
 }
@Test
public void test_getPackageName_Object178() { 
     assertEquals("org.apache.commons.lang3", ClassUtils.getPackageName(new ClassUtils(), "<null>")); 
     assertEquals("org.apache.commons.lang3", ClassUtils.getPackageName(new Inner(), "<null>")); 
     assertEquals("<null>", ClassUtils.getPackageName(null, "<null>")); 
 }
@Test
public void test_getPackageName_Class179() { 
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
public void test_getPackageName_String180() { 
     assertEquals("org.apache.commons.lang3", ClassUtils.getPackageName(ClassUtils.class.getName())); 
     assertEquals("java.util", ClassUtils.getPackageName(Map.Entry.class.getName())); 
     assertEquals("", ClassUtils.getPackageName((String) null)); 
     assertEquals("", ClassUtils.getPackageName("")); 
 }
@Test
public void test_getAllSuperclasses_Class181() { 
     final List<?> list = ClassUtils.getAllSuperclasses(CY.class); 
     assertEquals(2, list.size()); 
     assertEquals(CX.class, list.get(0)); 
     assertEquals(Object.class, list.get(1)); 
     assertEquals(null, ClassUtils.getAllSuperclasses(null)); 
 }
@Test
public void test_getAllInterfaces_Class182() { 
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
public void test_convertClassesToClassNames_List183() { 
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
public void test_isAssignable_ClassArray_ClassArray184() throws Exception { 
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
public void test_isAssignable_ClassArray_ClassArray_NoAutoboxing185() throws Exception { 
     final Class<?>[] array2 = new Class[] { Object.class, Object.class }; 
     final Class<?>[] array1 = new Class[] { Object.class }; 
     final Class<?>[] array1s = new Class[] { String.class }; 
     final Class<?>[] array0 = new Class[] {}; 
     final Class<?>[] arrayPrimitives = { Integer.TYPE, Boolean.TYPE }; 
     final Class<?>[] arrayWrappers = { Integer.class, Boolean.class }; 
     assertFalse(ClassUtils.isAssignable(array1, array2, false)); 
     assertFalse(ClassUtils.isAssignable(null, array2, false)); 
     assertTrue(ClassUtils.isAssignable(null, array0, false)); 
     assertTrue(ClassUtils.isAssignable(array0, array0, false)); 
     assertTrue(ClassUtils.isAssignable(array0, null, false)); 
     assertTrue(ClassUtils.isAssignable((Class[]) null, (Class[]) null, false)); 
     assertFalse(ClassUtils.isAssignable(array1, array1s, false)); 
     assertTrue(ClassUtils.isAssignable(array1s, array1s, false)); 
     assertTrue(ClassUtils.isAssignable(array1s, array1, false)); 
     assertFalse(ClassUtils.isAssignable(arrayPrimitives, arrayWrappers, false)); 
     assertFalse(ClassUtils.isAssignable(arrayWrappers, arrayPrimitives, false)); 
     assertFalse(ClassUtils.isAssignable(arrayPrimitives, array1, false)); 
     assertFalse(ClassUtils.isAssignable(arrayWrappers, array1, false)); 
     assertTrue(ClassUtils.isAssignable(arrayWrappers, array2, false)); 
     assertFalse(ClassUtils.isAssignable(arrayPrimitives, array2, false)); 
 }
@Test
public void test_isAssignable_Unboxing_Widening186() throws Exception { 
     assertFalse("byte -> char", ClassUtils.isAssignable(Byte.class, Character.TYPE, true)); 
     assertTrue("byte -> byte", ClassUtils.isAssignable(Byte.class, Byte.TYPE, true)); 
     assertTrue("byte -> short", ClassUtils.isAssignable(Byte.class, Short.TYPE, true)); 
     assertTrue("byte -> int", ClassUtils.isAssignable(Byte.class, Integer.TYPE, true)); 
     assertTrue("byte -> long", ClassUtils.isAssignable(Byte.class, Long.TYPE, true)); 
     assertTrue("byte -> float", ClassUtils.isAssignable(Byte.class, Float.TYPE, true)); 
     assertTrue("byte -> double", ClassUtils.isAssignable(Byte.class, Double.TYPE, true)); 
     assertFalse("byte -> boolean", ClassUtils.isAssignable(Byte.class, Boolean.TYPE, true)); 
     assertFalse("short -> char", ClassUtils.isAssignable(Short.class, Character.TYPE, true)); 
     assertFalse("short -> byte", ClassUtils.isAssignable(Short.class, Byte.TYPE, true)); 
     assertTrue("short -> short", ClassUtils.isAssignable(Short.class, Short.TYPE, true)); 
     assertTrue("short -> int", ClassUtils.isAssignable(Short.class, Integer.TYPE, true)); 
     assertTrue("short -> long", ClassUtils.isAssignable(Short.class, Long.TYPE, true)); 
     assertTrue("short -> float", ClassUtils.isAssignable(Short.class, Float.TYPE, true)); 
     assertTrue("short -> double", ClassUtils.isAssignable(Short.class, Double.TYPE, true)); 
     assertFalse("short -> boolean", ClassUtils.isAssignable(Short.class, Boolean.TYPE, true)); 
     assertTrue("char -> char", ClassUtils.isAssignable(Character.class, Character.TYPE, true)); 
     assertFalse("char -> byte", ClassUtils.isAssignable(Character.class, Byte.TYPE, true)); 
     assertFalse("char -> short", ClassUtils.isAssignable(Character.class, Short.TYPE, true)); 
     assertTrue("char -> int", ClassUtils.isAssignable(Character.class, Integer.TYPE, true)); 
     assertTrue("char -> long", ClassUtils.isAssignable(Character.class, Long.TYPE, true)); 
     assertTrue("char -> float", ClassUtils.isAssignable(Character.class, Float.TYPE, true)); 
     assertTrue("char -> double", ClassUtils.isAssignable(Character.class, Double.TYPE, true)); 
     assertFalse("char -> boolean", ClassUtils.isAssignable(Character.class, Boolean.TYPE, true)); 
     assertFalse("int -> char", ClassUtils.isAssignable(Integer.class, Character.TYPE, true)); 
     assertFalse("int -> byte", ClassUtils.isAssignable(Integer.class, Byte.TYPE, true)); 
     assertFalse("int -> short", ClassUtils.isAssignable(Integer.class, Short.TYPE, true)); 
     assertTrue("int -> int", ClassUtils.isAssignable(Integer.class, Integer.TYPE, true)); 
     assertTrue("int -> long", ClassUtils.isAssignable(Integer.class, Long.TYPE, true)); 
     assertTrue("int -> float", ClassUtils.isAssignable(Integer.class, Float.TYPE, true)); 
     assertTrue("int -> double", ClassUtils.isAssignable(Integer.class, Double.TYPE, true)); 
     assertFalse("int -> boolean", ClassUtils.isAssignable(Integer.class, Boolean.TYPE, true)); 
     assertFalse("long -> char", ClassUtils.isAssignable(Long.class, Character.TYPE, true)); 
     assertFalse("long -> byte", ClassUtils.isAssignable(Long.class, Byte.TYPE, true)); 
     assertFalse("long -> short", ClassUtils.isAssignable(Long.class, Short.TYPE, true)); 
     assertFalse("long -> int", ClassUtils.isAssignable(Long.class, Integer.TYPE, true)); 
     assertTrue("long -> long", ClassUtils.isAssignable(Long.class, Long.TYPE, true)); 
     assertTrue("long -> float", ClassUtils.isAssignable(Long.class, Float.TYPE, true)); 
     assertTrue("long -> double", ClassUtils.isAssignable(Long.class, Double.TYPE, true)); 
     assertFalse("long -> boolean", ClassUtils.isAssignable(Long.class, Boolean.TYPE, true)); 
     assertFalse("float -> char", ClassUtils.isAssignable(Float.class, Character.TYPE, true)); 
     assertFalse("float -> byte", ClassUtils.isAssignable(Float.class, Byte.TYPE, true)); 
     assertFalse("float -> short", ClassUtils.isAssignable(Float.class, Short.TYPE, true)); 
     assertFalse("float -> int", ClassUtils.isAssignable(Float.class, Integer.TYPE, true)); 
     assertFalse("float -> long", ClassUtils.isAssignable(Float.class, Long.TYPE, true)); 
     assertTrue("float -> float", ClassUtils.isAssignable(Float.class, Float.TYPE, true)); 
     assertTrue("float -> double", ClassUtils.isAssignable(Float.class, Double.TYPE, true)); 
     assertFalse("float -> boolean", ClassUtils.isAssignable(Float.class, Boolean.TYPE, true)); 
     assertFalse("double -> char", ClassUtils.isAssignable(Double.class, Character.TYPE, true)); 
     assertFalse("double -> byte", ClassUtils.isAssignable(Double.class, Byte.TYPE, true)); 
     assertFalse("double -> short", ClassUtils.isAssignable(Double.class, Short.TYPE, true)); 
     assertFalse("double -> int", ClassUtils.isAssignable(Double.class, Integer.TYPE, true)); 
     assertFalse("double -> long", ClassUtils.isAssignable(Double.class, Long.TYPE, true)); 
     assertFalse("double -> float", ClassUtils.isAssignable(Double.class, Float.TYPE, true)); 
     assertTrue("double -> double", ClassUtils.isAssignable(Double.class, Double.TYPE, true)); 
     assertFalse("double -> boolean", ClassUtils.isAssignable(Double.class, Boolean.TYPE, true)); 
     assertFalse("boolean -> char", ClassUtils.isAssignable(Boolean.class, Character.TYPE, true)); 
     assertFalse("boolean -> byte", ClassUtils.isAssignable(Boolean.class, Byte.TYPE, true)); 
     assertFalse("boolean -> short", ClassUtils.isAssignable(Boolean.class, Short.TYPE, true)); 
     assertFalse("boolean -> int", ClassUtils.isAssignable(Boolean.class, Integer.TYPE, true)); 
     assertFalse("boolean -> long", ClassUtils.isAssignable(Boolean.class, Long.TYPE, true)); 
     assertFalse("boolean -> float", ClassUtils.isAssignable(Boolean.class, Float.TYPE, true)); 
     assertFalse("boolean -> double", ClassUtils.isAssignable(Boolean.class, Double.TYPE, true)); 
     assertTrue("boolean -> boolean", ClassUtils.isAssignable(Boolean.class, Boolean.TYPE, true)); 
 }
@Test
public void testPrimitivesToWrappers187() { 
     assertNull("null -> null", ClassUtils.primitivesToWrappers((Class<?>[]) null)); 
     assertTrue("empty -> empty", Arrays.equals(ArrayUtils.EMPTY_CLASS_ARRAY, ClassUtils.primitivesToWrappers())); 
     final Class<?>[] castNull = ClassUtils.primitivesToWrappers((Class<?>) null); 
     assertTrue("(Class<?>)null -> [null]", Arrays.equals(new Class<?>[] { null }, castNull)); 
     assertArrayEquals("empty -> empty", ArrayUtils.EMPTY_CLASS_ARRAY, ClassUtils.primitivesToWrappers(ArrayUtils.EMPTY_CLASS_ARRAY)); 
     final Class<?>[] primitives = new Class[] { Boolean.TYPE, Byte.TYPE, Character.TYPE, Short.TYPE, Integer.TYPE, Long.TYPE, Double.TYPE, Float.TYPE, String.class, ClassUtils.class }; 
     final Class<?>[] wrappers = ClassUtils.primitivesToWrappers(primitives); 
     for (int i = 0; i < primitives.length; i++) { 
         final Class<?> primitive = primitives[i]; 
         final Class<?> expectedWrapper = ClassUtils.primitiveToWrapper(primitive); 
         assertEquals(primitive + " -> " + expectedWrapper, expectedWrapper, wrappers[i]); 
     } 
     final Class<?>[] noPrimitives = new Class[] { String.class, ClassUtils.class, Void.TYPE }; 
     assertNotSame("unmodified", noPrimitives, ClassUtils.primitivesToWrappers(noPrimitives)); 
 }
@Test
public void testWrappersToPrimitivesNull188() { 
     assertNull("Wrong result for null input", ClassUtils.wrappersToPrimitives((Class<?>[]) null)); 
     assertTrue("empty -> empty", Arrays.equals(ArrayUtils.EMPTY_CLASS_ARRAY, ClassUtils.wrappersToPrimitives())); 
     final Class<?>[] castNull = ClassUtils.wrappersToPrimitives((Class<?>) null); 
     assertTrue("(Class<?>)null -> [null]", Arrays.equals(new Class<?>[] { null }, castNull)); 
 }
@Test
public void test_isInnerClass_Class189() { 
     assertTrue(ClassUtils.isInnerClass(Inner.class)); 
     assertTrue(ClassUtils.isInnerClass(Map.Entry.class)); 
     assertTrue(ClassUtils.isInnerClass(new Cloneable() { 
     }.getClass())); 
     assertFalse(ClassUtils.isInnerClass(this.getClass())); 
     assertFalse(ClassUtils.isInnerClass(String.class)); 
     assertFalse(ClassUtils.isInnerClass(null)); 
 }
@Test
public void testGetClassWithArrayClasses190() throws Exception { 
     assertGetClassReturnsClass(String[].class); 
     assertGetClassReturnsClass(int[].class); 
     assertGetClassReturnsClass(long[].class); 
     assertGetClassReturnsClass(short[].class); 
     assertGetClassReturnsClass(byte[].class); 
     assertGetClassReturnsClass(char[].class); 
     assertGetClassReturnsClass(float[].class); 
     assertGetClassReturnsClass(double[].class); 
     assertGetClassReturnsClass(boolean[].class); 
 }
@Test
public void testGetClassRawPrimitives191() throws ClassNotFoundException { 
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
public void testGetClassClassNotFound192() throws Exception { 
     assertGetClassThrowsClassNotFound("bool"); 
     assertGetClassThrowsClassNotFound("bool[]"); 
     assertGetClassThrowsClassNotFound("integer[]"); 
 }
@Test
public void testGetClassInvalidArguments193() throws Exception { 
     assertGetClassThrowsNullPointerException(null); 
     assertGetClassThrowsClassNotFound("[][][]"); 
     assertGetClassThrowsClassNotFound("[[]"); 
     assertGetClassThrowsClassNotFound("["); 
     assertGetClassThrowsClassNotFound("java.lang.String]["); 
     assertGetClassThrowsClassNotFound(".hello.world"); 
     assertGetClassThrowsClassNotFound("hello..world"); 
 }
@Test
public void testGetPublicMethod194() throws Exception { 
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
public void testWithInterleavingWhitespace195() throws ClassNotFoundException { 
     assertEquals(int[].class, ClassUtils.getClass(" int [ ] ")); 
     assertEquals(long[].class, ClassUtils.getClass("\rlong\t[\n]\r")); 
     assertEquals(short[].class, ClassUtils.getClass("\tshort                \t\t[]")); 
     assertEquals(byte[].class, ClassUtils.getClass("byte[\t\t\n\r]   ")); 
 }
@Test
public void test_getShortCanonicalName_Object196() { 
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
public void test_getShortCanonicalName_Class197() { 
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
public void test_getPackageCanonicalName_Class198() { 
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
