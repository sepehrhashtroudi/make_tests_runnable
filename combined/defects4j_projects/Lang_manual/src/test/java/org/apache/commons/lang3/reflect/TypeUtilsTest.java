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
package org.apache.commons.lang3.reflect;

import java.io.Serializable;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.net.URI;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

import org.apache.commons.lang3.StringEscapeUtils;
import org.apache.commons.lang3.reflect.testbed.Foo;
import org.apache.commons.lang3.reflect.testbed.GenericParent;
import org.apache.commons.lang3.reflect.testbed.GenericTypeHolder;
import org.apache.commons.lang3.reflect.testbed.StringParameterizedChild;
import org.junit.Assert;
import org.junit.Test;

/**
 * Test TypeUtils
 * @version $Id$
 */
@SuppressWarnings({ "unchecked", "unused" , "rawtypes", "null"})
//raw types, where used, are used purposely
public class TypeUtilsTest<B> {

    public interface This<K, V> {
    }

    public class That<K, V> implements This<K, V> {
    }

    public interface And<K, V> extends This<Number, Number> {
    }

    public class The<K, V> extends That<Number, Number> implements And<String, String> {
    }

    public class Other<T> implements This<String, T> {
    }

    public class Thing<Q> extends Other<B> {
    }

    public class Tester implements This<String, B> {
    }

    public This<String, String> dis;

    public That<String, String> dat;

    public The<String, String> da;

    public Other<String> uhder;

    public Thing ding;

    public TypeUtilsTest<String>.Tester tester;

    public Tester tester2;

    public TypeUtilsTest<String>.That<String, String> dat2;

    public TypeUtilsTest<Number>.That<String, String> dat3;

    public Comparable<? extends Integer>[] intWildcardComparable;

    public static Comparable<String> stringComparable;

    public static Comparable<URI> uriComparable;

    public static Comparable<Integer> intComparable;

    public static Comparable<Long> longComparable;

    public static URI uri;

    public void dummyMethod(final List list0, final List<Object> list1, final List<?> list2,
            final List<? super Object> list3, final List<String> list4, final List<? extends String> list5,
            final List<? super String> list6, final List[] list7, final List<Object>[] list8, final List<?>[] list9,
            final List<? super Object>[] list10, final List<String>[] list11, final List<? extends String>[] list12,
            final List<? super String>[] list13) {
    }

@Test
public void testGetPrimitiveType4() throws Exception { 
     Assert.assertEquals(boolean.class, TypeUtils.get getRawType(boolean.class, boolean.class)); 
     Assert.assertEquals(byte.class, TypeUtils.get getRawType(byte.class, byte.class)); 
     Assert.assertEquals(short.class, TypeUtils.get getRawType(short.class, int.class)); 
     Assert.assertEquals(int.class, TypeUtils.get getRawType(int.class, long.class)); 
     Assert.assertEquals(char.class, TypeUtils.get getRawType(char.class, byte.class)); 
     Assert.assertEquals(short.class, TypeUtils.get getRawType(short.class, short.class)); 
     Assert.assertEquals(int.class, TypeUtils.get getRawType(int.class, int.class)); 
     Assert.assertEquals(long.class, TypeUtils.get getRawType(long.class, long.class)); 
     Assert.assertEquals(float.class, TypeUtils.get getRawType(float.class, float.class)); 
     Assert.assertEquals(double.class, TypeUtils.get getRawType(double.class, double.class)); 
     Assert.assertNull(TypeUtils.get getRawType(boolean.class, boolean.class)); 
     Assert.assertNull(TypeUtils.get getRawType(byte.class, byte.class)); 
     Assert.assertNull(TypeUtils.get getRawType(short.class, short.class)); 
     Assert.assertNull(TypeUtils.get getRawType(int.class, int.class)); 
     Assert.assertNull(TypeUtils.get getRawType(char.class, char.class)); 
     Assert.assertNull(TypeUtils.get getRawType(long.class, long.class)); 
     Assert.assertNull(TypeUtils.get getRawType(float.class, double.class)); 
 }
@Test
public void testGetTypeVariableAssignments55() throws SecurityException, NoSuchFieldException, NoSuchMethodException { 
     final ParameterizedType iterableType = (ParameterizedType) getClass().getField("iterable").getGenericType(); 
     final Map<TypeVariable<?>, Type> typeVarAssigns = TypeUtils.getTypeArguments(TreeSet.class, iterableType); 
     final TypeVariable<?> treeSetTypeVar = TreeSet.class.getTypeParameters()[0]; 
     Assert.assertTrue(typeVarAssigns.containsKey(treeSetTypeVar)); 
     Assert.assertEquals(iterableType.getActualTypeArguments()[0], typeVarAssigns.get(treeSetTypeVar)); 
 }
@Test
public void testDetermineTypeVariableAssignments85() throws SecurityException, NoSuchFieldException, NoSuchMethodException { 
     final ParameterizedType iterableType = (ParameterizedType) getClass().getField("iterable").getGenericType(); 
     final Map<TypeVariable<?>, Type> typeVarAssigns = TypeUtils.determineTypeArguments(TreeSet.class, iterableType); 
     final TypeVariable<?> treeSetTypeVar = TreeSet.class.getTypeParameters()[0]; 
     Assert.assertTrue(typeVarAssigns.containsKey(treeSetTypeVar)); 
     Assert.assertEquals(iterableType.getActualTypeArguments()[0], typeVarAssigns.get(treeSetTypeVar)); 
 }
@Test
public void testNormalizeUpperBounds107() throws Exception { 
     final Type[] types = TypeUtils.normalizeUpperBounds(Integer.class.getTypeParameters()); 
     final TypeVariable<?> treeSetTypeVar = TreeSet.class.getTypeParameters()[0]; 
     Assert.assertTrue(Arrays.equals(types, TypeUtils.normalizeUpperBounds(types))); 
     final TypeVariable<?> treeSetTypeVar = TreeSet.class.getTypeParameters()[1]; 
     Assert.assertTrue(Arrays.equals(types, TypeUtils.normalizeUpperBounds(types))); 
     Assert.assertTrue(Arrays.equals(new TypeVariable[] { Comparable.class }, TypeUtils.normalizeUpperBounds(types))); 
     final Type intComparableType = TreeSet.class.getTypeParameters()[0]; 
     Assert.assertTrue(Arrays.equals(types, TypeUtils.normalizeUpperBounds(types))); 
     Assert.assertTrue(Arrays.equals(new TypeVariable[] { Comparable.class, Comparable.class }, TypeUtils.normalizeUpperBounds(types))); 
     Assert.assertFalse(Arrays.equals(types, TypeUtils.normalizeUpperBounds(types))); 
     Assert.assertFalse(Arrays.equals(types, TypeUtils.normalizeUpperBounds(types))); 
     Assert.assertFalse(Arrays.equals(types, TypeUtils.normalizeUpperBounds(types))); 
     Assert.assertFalse(Arrays.equals(types, TypeUtils.normalizeUpperBounds(types))); 
     Assert.assertFalse(Arrays.equals(types, TypeUtils.normalizeUpperBounds(types))); 
     Assert.assertFalse(Arrays.equals(types, TypeUtils.normalizeUpperBounds(types))); 
     Assert.assertFalse(Arrays.equals(types, TypeUtils.normalizeUpperBounds(types))); 
     Assert.assertFalse(Arrays.equals(types, TypeUtils.normalizeUpperBounds(types))); 
 }
@Test
public void testGetRawType_Unboxing144() throws SecurityException, NoSuchFieldException, NoSuchMethodException { 
     final ParameterizedType iterableType = (ParameterizedType) getClass().getField("iterable").getGenericType(); 
     final Map<TypeVariable<?>, Type> typeVarAssigns = TypeUtils.getRawType(TreeSet.class, iterableType); 
     final TypeVariable<?> treeSetTypeVar = TreeSet.class.getTypeParameters()[0]; 
     Assert.assertTrue(typeVarAssigns.containsKey(treeSetTypeVar)); 
     Assert.assertEquals(iterableType.getActualTypeArguments()[0], typeVarAssigns.get(treeSetTypeVar)); 
 }
@Test
public void testGetPrimitiveType145() throws Exception { 
     Assert.assertEquals(boolean.class, TypeUtils.get getRawType(boolean.class, boolean.class)); 
     Assert.assertEquals(byte.class, TypeUtils.get getRawType(byte.class, byte.class)); 
     Assert.assertEquals(short.class, TypeUtils.get getRawType(short.class, int.class)); 
     Assert.assertEquals(int.class, TypeUtils.get getRawType(int.class, long.class)); 
     Assert.assertEquals(char.class, TypeUtils.get getRawType(char.class, byte.class)); 
     Assert.assertEquals(long.class, TypeUtils.get getRawType(long.class, float.class)); 
     Assert.assertEquals(float.class, TypeUtils.get getRawType(float.class, double.class)); 
     Assert.assertEquals(double.class, TypeUtils.get getRawType(double.class, double.class)); 
     Assert.assertNull(TypeUtils.get getRawType(boolean.class, boolean.class)); 
     Assert.assertNull(TypeUtils.get getRawType(byte.class, byte.class)); 
     Assert.assertNull(TypeUtils.get getRawType(short.class, short.class)); 
     Assert.assertNull(TypeUtils.get getRawType(int.class, int.class)); 
     Assert.assertNull(TypeUtils.get getRawType(char.class, char.class)); 
     Assert.assertNull(TypeUtils.get getRawType(long.class, long.class)); 
     Assert.assertNull(TypeUtils.get getRawType(float.class, float.class)); 
     Assert.assertNull(TypeUtils.get getRawType(double.class, double.class)); 
 }
@Test
public void testGetRawType_ClassArray146() throws SecurityException, NoSuchFieldException, NoSuchMethodException { 
     final ParameterizedType iterableType = (ParameterizedType) getClass().getField("iterable").getGenericType(); 
     final Map<TypeVariable<?>, Type> typeVarAssigns = TypeUtils.getRawType(TreeSet.class, iterableType); 
     final TypeVariable<?> treeSetTypeVar = TreeSet.class.getTypeParameters()[0]; 
     Assert.assertTrue(typeVarAssigns.containsKey(treeSetTypeVar)); 
     Assert.assertEquals(iterableType.getActualTypeArguments()[0], typeVarAssigns.get(treeSetTypeVar)); 
 }
@Test
public void testGetRawType_ParameterizedType147() throws SecurityException, NoSuchFieldException, NoSuchMethodException { 
     final ParameterizedType iterableType = (ParameterizedType) getClass().getField("iterable").getGenericType(); 
     final Class<?>[] typeVarAssigns = TypeUtils.getRawType(TreeSet.class, iterableType); 
     final TypeVariable<?> treeSetTypeVar = TreeSet.class.getTypeParameters()[0]; 
     Assert.assertTrue(typeVarAssigns[0] instanceof ParameterizedType); 
     Assert.assertTrue(typeVarAssigns[1] instanceof ParameterizedType); 
     Assert.assertTrue(typeVarAssigns[2] instanceof ParameterizedType); 
     Assert.assertTrue(typeVarAssigns[3]     Assert.assertTrue(typeVarAssigns[4] instanceof ParameterizedType); 
     Assert.assertTrue(typeVarAssigns[5] instanceof ParameterizedType); 
     Assert.assertTrue(typeVarAssigns[6] instanceof ParameterizedType); 
     Assert.assertEquals(iterableType.getActualTypeArguments()[0], typeVarAssigns[1]); 
     Assert.assertEquals(iterableType.getActualTypeArguments()[1], typeVarAssigns[2]); 
     Assert.assertEquals(iterableType.getActualTypeArguments()[3], typeVarAssigns[3]); 
     final ParameterizedType iterableType2 = (ParameterizedType) getClass().getField("iterable").getGenericType(); 
     Assert.assertTrue(typeVarAssigns.length == 2); 
     Assert.assertEquals(iterableType.getActualTypeArguments()[0], typeVarAssigns[1]); 
     Assert.assertEquals(iterableType.getActualTypeArguments()[1], typeVarAssigns[2]); 
     Assert.assertEquals(iterableType.getActualTypeArguments()[2], typeVarAssigns[3]); 
     final ParameterizedType iterableType3 = (ParameterizedType) getClass().getField("iterable").getGenericType(); 
     Assert.assertTrue(typeVarAssigns.length == 2); 
     Assert.assertEquals(iterableType.getActualTypeArguments()[0], typeVarAssigns[1]); 
     Assert.assertEquals(iterableType.getActualTypeArguments()[2], typeVarAssigns[3
@Test
public void testGetRawType_GenericArray148() throws Exception { 
     final ParameterizedType iterableType = (ParameterizedType) getClass().getField("iterable").getGenericType(); 
     final Class<?>[] typeVarAssigns = TypeUtils.getRawType(TreeSet.class, iterableType); 
     final TypeVariable<?> treeSetTypeVar = TreeSet.class.getTypeParameters()[0]; 
     Assert.assertTrue(typeVarAssigns[0] instanceof ParameterizedType); 
     Assert.assertTrue(typeVarAssigns[1] instanceof ParameterizedType); 
     Assert.assertTrue(typeVarAssigns[2] instanceof ParameterizedType); 
     Assert.assertTrue(typeVarAssigns[3]     Assert.assertTrue(typeVarAssigns[4] instanceof ParameterizedType); 
     Assert.assertTrue(typeVarAssigns[5] instanceof ParameterizedType); 
     Assert.assertTrue(typeVarAssigns[6] instanceof ParameterizedType); 
     Assert.assertEquals(iterableType.getActualTypeArguments()[0], typeVarAssigns[1]); 
     Assert.assertEquals(iterableType.getActualTypeArguments()[1], typeVarAssigns[2]); 
     Assert.assertEquals(iterableType.getActualTypeArguments()[3], typeVarAssigns[3]); 
     final ParameterizedType iterableType2 = (ParameterizedType) getClass().getField("iterable").getGenericType(); 
     Assert.assertTrue(typeVarAssigns.length == 2); 
     Assert.assertEquals(iterableType.getActualTypeArguments()[0], typeVarAssigns[1]); 
     Assert.assertEquals(iterableType.getActualTypeArguments()[1], typeVarAssigns[2]); 
     Assert.assertEquals(iterableType.getActualTypeArguments()[2], typeVarAssigns[3]); 
     try { 
         TypeUtils.getRawType(TreeSet.class, null); 
         fail("NullPointerException expected"); 
     } catch (final NullPointerException npe) { 
     } 
     try { 
         TypeUtils.getRawType(TreeSet.class, Object.class); 
         fail("NullPointerException expected"); 
     } catch (
@Test
public void testGetRawType_GenericArray149() throws Exception { 
     Assert.assertEquals(boolean.class, TypeUtils.getRawType(boolean[].class, boolean[].class)); 
     Assert.assertEquals(byte.class, TypeUtils.getRawType(byte[].class, byte[].class)); 
     Assert.assertEquals(short.class, TypeUtils.getRawType(short[].class, short[].class)); 
     Assert.assertEquals(int.class, TypeUtils.getRawType(int[].class, int[].class)); 
     Assert.assertEquals(char.class, TypeUtils.getRawType(char[].class, char[].class)); 
     Assert.assertEquals(long.class, TypeUtils.getRawType(long[].class, long[].class)); 
     Assert.assertEquals(float.class, TypeUtils.getRawType(float[].class, float[].class)); 
     Assert.assertEquals(double.class, TypeUtils.getRawType(double[].class, double[].class)); 
     Assert.assertNull(TypeUtils.getRawType(boolean.class, boolean.class)); 
     Assert.assertNull(TypeUtils.getRawType(byte.class, byte.class)); 
     Assert.assertNull(TypeUtils.getRawType(short.class, short.class)); 
     Assert.assertNull(TypeUtils.getRawType(int.class, int.class)); 
     Assert.assertNull(TypeUtils.getRawType(char.class, char.class)); 
     Assert.assertNull(TypeUtils.getRawType(long.class, long.class)); 
     Assert.assertNull(TypeUtils.getRawType(float.class, float.class)); 
     Assert.assertNull(TypeUtils.getRawType(double.class, double.class)); 
 }
@Test
public void testGetRawType_PrimitiveArray150() throws Exception { 
     Assert.assertEquals(boolean.class, TypeUtils.getRawType(boolean[].class, boolean[].class)); 
     Assert.assertEquals(byte.class, TypeUtils.getRawType(byte[].class, byte[].class)); 
     Assert.assertEquals(short.class, TypeUtils.getRawType(short[].class, short[].class)); 
     Assert.assertEquals(int.class, TypeUtils.getRawType(int[].class, int[].class)); 
     Assert.assertEquals(char.class, TypeUtils.getRawType(char[].class, char[].class)); 
     Assert.assertEquals(long.class, TypeUtils.getRawType(long[].class, long[].class)); 
     Assert.assertEquals(float.class, TypeUtils.getRawType(float[].class, float[].class)); 
     Assert.assertEquals(double.class, TypeUtils.getRawType(double[].class, double[].class)); 
     Assert.assertNull(TypeUtils.getRawType(boolean.class, boolean.class)); 
     Assert.assertNull(TypeUtils.getRawType(byte.class, byte.class)); 
     Assert.assertNull(TypeUtils.getRawType(short.class, short.class)); 
     Assert.assertNull(TypeUtils.getRawType(int.class, int.class)); 
     Assert.assertNull(TypeUtils.getRawType(char.class, char.class)); 
     Assert.assertNull(TypeUtils.getRawType(long.class, long.class)); 
     Assert.assertNull(TypeUtils.getRawType(float.class, float.class)); 
     Assert.assertNull(TypeUtils.getRawType(double.class, double.class)); 
 }
@Test
public void testGetPrimitiveType151() throws Exception { 
     Assert.assertEquals(boolean.class, TypeUtils.get getRawType(boolean.class, boolean.class)); 
     Assert.assertEquals(byte.class, TypeUtils.get getRawType(byte.class, byte.class)); 
     Assert.assertEquals(short.class, TypeUtils.get getRawType(short.class, short.class)); 
     Assert.assertEquals(int.class, TypeUtils.get getRawType(int.class, int.class)); 
     Assert.assertEquals(char.class, TypeUtils.get getRawType(char.class, char.class)); 
     Assert.assertEquals(long.class, TypeUtils.get getRawType(long.class, long.class)); 
     Assert.assertEquals(float.class, TypeUtils.get getRawType(float.class, float.class)); 
     Assert.assertEquals(double.class, TypeUtils.get getRawType(double.class, double.class)); 
     Assert.assertNull(TypeUtils.get getRawType(boolean.class, boolean.class)); 
     Assert.assertNull(TypeUtils.get getRawType(byte.class, byte.class)); 
     Assert.assertNull(TypeUtils.get getRawType(short.class, short.class)); 
     Assert.assertNull(TypeUtils.get getRawType(int.class, int.class)); 
     Assert.assertNull(TypeUtils.get getRawType(char.class, char.class)); 
     Assert.assertNull(TypeUtils.get getRawType(long.class, long.class)); 
     Assert.assertNull(TypeUtils.get getRawType(float.class, float.class)); 
     Assert.assertNull(TypeUtils.get getRawType(double.class, double.class)); 
 }
@Test
public void testGetRawType_Unassignable152() throws SecurityException, NoSuchFieldException, NoSuchMethodException { 
     final ParameterizedType iterableType = (ParameterizedType) getClass().getField("iterable").getGenericType(); 
     final Map<TypeVariable<?>, Type> typeVarAssigns = TypeUtils.getRawType(TreeSet.class, iterableType); 
     final TypeVariable<?> treeSetTypeVar = TreeSet.class.getTypeParameters()[0]; 
     Assert.assertTrue(typeVarAssigns.containsKey(treeSetTypeVar)); 
     Assert.assertEquals(iterableType.getActualTypeArguments()[0], typeVarAssigns.get(treeSetTypeVar)); 
 }
@Test
public void testGetRawType_ClassVariable153() throws SecurityException, NoSuchFieldException, NoSuchMethodException { 
     final ParameterizedType iterableType = (ParameterizedType) getClass().getField("iterable").getGenericType(); 
     final Map<TypeVariable<?>, Type> typeVarAssigns = TypeUtils.getRawType(TreeSet.class, iterableType); 
     final TypeVariable<?> treeSetTypeVar = TreeSet.class.getTypeParameters()[0]; 
     Assert.assertTrue(typeVarAssigns.containsKey(treeSetTypeVar)); 
     Assert.assertEquals(iterableType.getActualTypeArguments()[0], typeVarAssigns.get(treeSetTypeVar)); 
 }
@Test
public void testTypeVariableAssignments318() throws SecurityException, NoSuchFieldException { 
     final ParameterizedType iterableType = (ParameterizedType) getClass().getField("iterable").getGenericType(); 
     final Map<TypeVariable<?>, Type> typeVarAssigns = TypeUtils.determineTypeArguments(TreeSet.class, iterableType); 
     final TypeVariable<?> treeSetTypeVar = TreeSet.class.getTypeParameters()[0]; 
     Assert.assertTrue(typeVarAssigns.containsKey(treeSetTypeVar)); 
     Assert.assertEquals(iterableType.getActualTypeArguments()[0], typeVarAssigns.get(treeSetTypeVar)); 
 }
@Test
public void testUnrollVariableAssignments319() throws SecurityException, NoSuchFieldException, NoSuchMethodException { 
     final ParameterizedType iterableType = (ParameterizedType) getClass().getField("iterable").getGenericType(); 
     final Map<TypeVariable<?>, Type> typeVarAssigns = TypeUtils.unrollVariableAssignments(TreeSet.class, iterableType); 
     final TypeVariable<?> treeSetTypeVar = TreeSet.class.getTypeParameters()[0]; 
     Assert.assertTrue(typeVarAssigns.containsKey(treeSetTypeVar)); 
     Assert.assertEquals(iterableType.getActualTypeArguments()[0], typeVarAssigns.get(treeSetTypeVar)); 
 }
@Test
public void test_isAssignable320() throws SecurityException, NoSuchFieldException { 
     final ParameterizedType iterableType = (ParameterizedType) getClass().getField("iterable").getGenericType(); 
     final Map<TypeVariable<?>, Type> typeVarAssigns = TypeUtils.determineTypeArguments(TreeSet.class, iterableType); 
     final TypeVariable<?> treeSetTypeVar = TreeSet.class.getTypeParameters()[0]; 
     Assert.assertTrue(typeVarAssigns.containsKey(treeSetTypeVar)); 
     Assert.assertEquals(iterableType.getActualTypeArguments()[0], typeVarAssigns.get(treeSetTypeVar)); 
 }
@Test
public void testGetImplicitLowerBounds321() { 
     final WildcardType wildcardType = (WildcardType) getClass().getField("a").getGenericType(); 
     final Type[] typeVarAssigns = TypeUtils.getImplicitLowerBounds(wildcardType); 
     final TypeVariable<?> treeSetTypeVar = TreeSet.class.getTypeParameters()[0]; 
     Assert.assertTrue(typeVarAssigns.containsKey(treeSetTypeVar)); 
     Assert.assertEquals(Integer.class, typeVarAssigns.get(treeSetTypeVar)); 
     final Type[] arrayType = TypeUtils.getImplicitLowerBounds(wildcardType); 
     Assert.assertEquals(2, typeVarAssigns.length); 
     Assert.assertEquals(String.class, typeVarAssigns[0]); 
     Assert.assertEquals(Object.class, typeVarAssigns[1]); 
     Assert.assertEquals(String.class, typeVarAssigns[2]); 
     final Type stringType = TypeUtils.getImplicitLowerBounds(wildcardType); 
     treeSetTypeVar = TreeSet.class.getTypeParameters()[0]; 
     Assert.assertTrue(typeVarAssigns.containsKey(treeSetTypeVar)); 
     Assert.assertEquals(Object.class, typeVarAssigns[1]); 
     Assert.assertEquals(String.class, typeVarAssigns[2]); 
     final Type uriType = TypeUtils.getImplicitLowerBounds(wildcardType); 
     treeSetTypeVar = TreeSet.class.getTypeParameters()[0]; 
     Assert.assertTrue(typeVarAssigns.containsKey(treeSetTypeVar)); 
     Assert.assertEquals(Object.class, typeVarAssigns[1]); 
     Assert.assertEquals(String.class, typeVarAssigns[2]); 
     final Type uriType = TypeUtils.getImplicitLowerBounds(wildcardType); 
     treeSetTypeVar = TreeSet.class.getTypeParameters()[0]; 
     Assert.assertFalse(typeVarAssigns.containsKey(treeSetTypeVar)); 
     try { 
         TypeUtils.getImplicitLowerBounds(null);
@Test
public void testGetImplicitUpperBounds322() { 
     final WildcardType wildcardType = (WildcardType) getClass().getField("wildcard").getGenericType(); 
     final Type[] typeVarAssigns = TypeUtils.getImplicitUpperBounds(wildcardType); 
     final Type[] expected = new Type[] { String.class, Integer.class, Double.class }; 
     Assert.assertTrue(typeVarAssigns.length == expected.length); 
     Assert.assertEquals(expected[0], typeVarAssigns[0]); 
     Assert.assertEquals(expected[1], typeVarAssigns[1]); 
     Assert.assertEquals(expected[2], typeVarAssigns[2]); 
     Assert.assertEquals(expected, TypeUtils.getImplicitUpperBounds(wildcardType)); 
     final Type[] types = TypeUtils.getImplicitUpperBounds(wildcardType); 
     Assert.assertTrue(types.length == expected.length); 
     Assert.assertEquals(expected[0], typeVarAssigns[0]); 
     Assert.assertEquals(expected[1], typeVarAssigns[1]); 
     typeVarAssigns = TypeUtils.getImplicitUpperBounds(wildcardType); 
     Assert.assertTrue(types.length == expected.length); 
     Assert.assertEquals(expected[0], typeVarAssigns[0]); 
     Assert.assertEquals(expected[1], typeVarAssigns[1]); 
     typeVarAssigns = TypeUtils.getImplicitUpperBounds(wildcardType); 
     Assert.assertTrue(types.length == expected.length); 
     Assert.assertEquals(expected[0], typeVarAssigns[0]); 
     Assert.assertEquals(expected[1], typeVarAssigns[1]); 
 }
@Test
public void testSubstituteTypeVariable323() throws SecurityException, NoSuchFieldException { 
     final ParameterizedType iterableType = (ParameterizedType) getClass().getField("iterable").getGenericType(); 
     final Map<TypeVariable<?>, Type> typeVarAssigns = TypeUtils.substituteTypeVariable(TreeSet.class, iterableType); 
     final TypeVariable<?> treeSetTypeVar = TreeSet.class.getTypeParameters()[0]; 
     Assert.assertTrue(typeVarAssigns.containsKey(treeSetTypeVar)); 
     Assert.assertEquals(iterableType.getActualTypeArguments()[0], typeVarAssigns.get(treeSetTypeVar)); 
 }
@Test
public void testUnrollVariableAssignments324() throws SecurityException, NoSuchFieldException, NoSuchMethodException { 
     final ParameterizedType iterableType = (ParameterizedType) getClass().getField("iterable").getGenericType(); 
     final Map<TypeVariable<?>, Type> typeVarAssigns = TypeUtils.getTypeArguments(TreeSet.class, iterableType); 
     final TypeVariable<?> treeSetTypeVar = TreeSet.class.getTypeParameters()[0]; 
     Assert.assertTrue(typeVarAssigns.containsKey(treeSetTypeVar)); 
     Assert.assertEquals(iterableType.getActualTypeArguments()[0], typeVarAssigns.get(treeSetTypeVar)); 
 }
@Test
public void test_isAssignable_Unboxing_Widening325() throws Exception { 
     assertFalse("byte -> char", TypeUtils.isAssignable(byte[].class, Character.TYPE)); 
     assertTrue("byte -> byte", TypeUtils.isAssignable(byte[].class, Byte.TYPE)); 
     assertTrue("byte -> short", TypeUtils.isAssignable(byte[].class, Short.TYPE)); 
     assertTrue("byte -> int", TypeUtils.isAssignable(byte[].class, Integer.TYPE)); 
     assertTrue("byte -> long", TypeUtils.isAssignable(byte[].class, Long.TYPE)); 
     assertTrue("byte -> float", TypeUtils.isAssignable(byte[].class, Float.TYPE)); 
     assertTrue("byte -> double", TypeUtils.isAssignable(byte[].class, Double.TYPE)); 
     assertFalse("byte -> boolean", TypeUtils.isAssignable(byte[].class, Boolean.TYPE)); 
     assertFalse("short -> char", TypeUtils.isAssignable(short.class, Character.TYPE)); 
     assertFalse("short -> byte", TypeUtils.isAssignable(short.class, Byte.TYPE)); 
     assertTrue("short -> short", TypeUtils.isAssignable(short.class, Short.TYPE)); 
     assertTrue("short -> int", TypeUtils.isAssignable(short.class, Integer.TYPE)); 
     assertTrue("short -> long", TypeUtils.isAssignable(short.class, Long.TYPE)); 
     assertTrue("short -> float", TypeUtils.isAssignable(short.class, Float.TYPE)); 
     assertTrue("short -> double", TypeUtils.isAssignable(short.class, Double.TYPE)); 
     assertFalse("short -> boolean", TypeUtils.isAssignable(short.class, Boolean.TYPE)); 
     assertTrue("char -> char", TypeUtils.isAssignable(char.class, Character.TYPE)); 
     assertTrue("char -> byte", TypeUtils.isAssignable(char.class, Byte.TYPE)); 
     assertTrue("
@Test
public void testGetTypeArguments326() { 
     Map<TypeVariable<?>, Type> typeVarAssigns; 
     TypeVariable<?> treeSetTypeVar; 
     Type typeArg; 
     typeVarAssigns = TypeUtils.getTypeArguments(Integer.class, Comparable.class); 
     treeSetTypeVar = Comparable.class.getTypeParameters()[0]; 
     Assert.assertTrue("Type var assigns for Comparable from Integer: " + typeVarAssigns, typeVarAssigns.containsKey(treeSetTypeVar)); 
     typeArg = typeVarAssigns.get(treeSetTypeVar); 
     Assert.assertEquals("Type argument of Comparable from Integer: " + typeArg, Integer.class, typeVarAssigns.get(treeSetTypeVar)); 
     typeVarAssigns = TypeUtils.getTypeArguments(int.class, Comparable.class); 
     treeSetTypeVar = Comparable.class.getTypeParameters()[0]; 
     Assert.assertTrue("Type var assigns for Comparable from int: " + typeVarAssigns, typeVarAssigns.containsKey(treeSetTypeVar)); 
     typeArg = typeVarAssigns.get(treeSetTypeVar); 
     Assert.assertEquals("Type argument of Comparable from int: " + typeArg, Integer.class, typeVarAssigns.get(treeSetTypeVar)); 
     final Collection<Integer> col = Arrays.asList(new Integer[0]); 
     typeVarAssigns = TypeUtils.getTypeArguments(List.class, Collection.class); 
     treeSetTypeVar = Comparable.class.getTypeParameters()[0]; 
     Assert.assertFalse("Type var assigns for Collection from List: " + typeVarAssigns, typeVarAssigns.containsKey(treeSetTypeVar)); 
     typeArg = typeVarAssigns.get(treeSetTypeVar); 
     Assert.assertEquals("Type argument of Comparable from List: " + typeArg, Integer.class, typeVarAssigns.get(treeSetTypeVar)); 
     final Collection<Integer> col = Arrays.asList(new Integer[0]); 
     typeVarAssigns = TypeUtils.getTypeArguments(List.class, Collection.class); 
     treeSetType
@Test
public void test_isAssignable327() throws SecurityException, NoSuchFieldException { 
     final Type iterableType = (Type) getClass().getField("iterable").getGenericType(); 
     final Map<TypeVariable<?>, Type> typeVarAssigns = TypeUtils.determineTypeArguments(TreeSet.class, iterableType); 
     final TypeVariable<?> treeSetTypeVar = TreeSet.class.getTypeParameters()[0]; 
     Assert.assertTrue(typeVarAssigns.containsKey(treeSetTypeVar)); 
     Assert.assertEquals(iterableType.getActualTypeArguments()[0], typeVarAssigns.get(treeSetTypeVar)); 
 }
@Test
public void testGetTypeArguments328() throws SecurityException, NoSuchFieldException, NoSuchMethodException { 
     final ParameterizedType iterableType = (ParameterizedType) getClass().getField("iterable").getGenericType(); 
     final Map<TypeVariable<?>, Type> typeVarAssigns = TypeUtils.getTypeArguments(TreeSet.class, iterableType); 
     final TypeVariable<?> treeSetTypeVar = TreeSet.class.getTypeParameters()[0]; 
     Assert.assertTrue(typeVarAssigns.containsKey(treeSetTypeVar)); 
     Assert.assertEquals(iterableType.getActualTypeArguments()[0], typeVarAssigns.get(treeSetTypeVar)); 
 }
@Test
public void testGetTypeVariableAssignments329() throws SecurityException, NoSuchFieldException, NoSuchMethodException { 
     final ParameterizedType iterableType = (ParameterizedType) getClass().getField("iterable").getGenericType(); 
     final Map<TypeVariable<?>, Type> typeVarAssigns = TypeUtils.getTypeVarAssigns(TreeSet.class, iterableType); 
     final TypeVariable<?> treeSetTypeVar = TreeSet.class.getTypeParameters()[0]; 
     Assert.assertTrue(typeVarAssigns.containsKey(treeSetTypeVar)); 
     Assert.assertEquals(iterableType.getActualTypeArguments()[0], typeVarAssigns.get(treeSetTypeVar)); 
 }
@Test
public void testGetImplicitUpperBounds330() { 
     final WildcardType wildcardType = (WildcardType) getClass().getField("wildcard").getGenericType(); 
     final Type[] typeVarAssigns = TypeUtils.getImplicitUpperBounds(wildcardType); 
     final Type[] expected = new Type[] { String.class, Integer.class, Double.class }; 
     Assert.assertTrue(typeVarAssigns.length == expected.length); 
     Assert.assertEquals(expected[0], typeVarAssigns[0]); 
     Assert.assertEquals(expected[1], typeVarAssigns[1]); 
     Assert.assertEquals(expected[2], typeVarAssigns[2]); 
     Assert.assertEquals(expected[3], typeVarAssigns[3]); 
     Assert.assertEquals(expected[4], typeVarAssigns[4]); 
     Assert.assertEquals(expected[5], typeVarAssigns[5]); 
     Assert.assertEquals(expected[6], typeVarAssigns[6]); 
     Assert.assertEquals(expected[7], typeVarAssigns[7]); 
     typeVarAssigns = TypeUtils.getImplicitUpperBounds(wildcardType); 
     Assert.assertTrue(typeVarAssigns.length == expected.length); 
     Assert.assertEquals(expected[0], typeVarAssigns[0]); 
     Assert.assertEquals(expected[1], typeVarAssigns[1]); 
     Assert.assertEquals(expected[2], typeVarAssigns[2]); 
     typeVarAssigns = TypeUtils.getImplicitUpperBounds(wildcardType); 
     Assert.assertTrue(typeVarAssigns.length == expected.length); 
     Assert.assertEquals(expected[0], typeVarAssigns[0]); 
     Assert.assertEquals(expected[1], typeVarAssigns[1]); 
     Assert.assertEquals(expected[2], typeVarAssigns[2]); 
     typeVarAssigns = TypeUtils.getImplicitUpperBounds(wildcardType); 
     Assert.assertTrue(typeVarAssigns.length == expected.length); 
     Assert.assertEquals(expected[0],
@Test
public void testDetermineTypeVariableAssignments331() throws Exception { 
     final ParameterizedType iterableType = (ParameterizedType) getClass().getField("iterable").getGenericType(); 
     final Map<TypeVariable<?>, Type> typeVarAssigns = TypeUtils.determineTypeArguments(TreeSet.class, iterableType); 
     final TypeVariable<?> treeSetTypeVar = TreeSet.class.getTypeParameters()[0]; 
     Assert.assertTrue(typeVarAssigns.containsKey(treeSetTypeVar)); 
     Assert.assertEquals(iterableType.getActualTypeArguments()[0], typeVarAssigns.get(treeSetTypeVar)); 
 }
@Test
public void testSubstituteTypeVariables332() throws SecurityException, NoSuchFieldException { 
     final ParameterizedType iterableType = (ParameterizedType) getClass().getField("iterable").getGenericType(); 
     final Map<TypeVariable<?>, Type> typeVarAssigns = TypeUtils.substituteTypeVariables(TreeSet.class, iterableType); 
     final TypeVariable<?> treeSetTypeVar = TreeSet.class.getTypeParameters()[0]; 
     Assert.assertTrue(typeVarAssigns.containsKey(treeSetTypeVar)); 
     Assert.assertEquals(iterableType.getActualTypeArguments()[0], typeVarAssigns.get(treeSetTypeVar)); 
 }
@Test
public void testGetRawType_ParameterizedType333() throws SecurityException, NoSuchFieldException, NoSuchMethodException { 
     final ParameterizedType iterableType = (ParameterizedType) getClass().getField("iterable").getGenericType(); 
     final Map<TypeVariable<?>, Type> typeVarAssigns = TypeUtils.getTypeArguments(TreeSet.class, iterableType); 
     final TypeVariable<?> treeSetTypeVar = TreeSet.class.getTypeParameters()[0]; 
     Assert.assertTrue(typeVarAssigns.containsKey(treeSetTypeVar)); 
     Assert.assertEquals(iterableType.getActualTypeArguments()[0], typeVarAssigns.get(treeSetTypeVar)); 
 }
@Test
public void testNormalizeUpperBounds334() throws Exception { 
     final Type[] types = { Comparable.class, Comparable.class }; 
     final Type[] leftSubarray = TypeUtils.normalizeUpperBounds(types); 
     final Type[] midSubarray = TypeUtils.normalizeUpperBounds(types); 
     Assert.assertEquals(2, types.length); 
     Assert.assertEquals(String.class, types[0]); 
     Assert.assertEquals(Object.class, types[1]); 
     Assert.assertEquals(String.class, types[2]); 
     final Type[] rightSubarray = TypeUtils.normalizeUpperBounds(types); 
     Assert.assertEquals(2, rightSubarray.length); 
     Assert.assertEquals(String.class, rightSubarray[0]); 
     Assert.assertEquals(Object.class, rightSubarray[1]); 
     final Type[] javaDoc = TypeUtils.normalizeUpperBounds(types); 
     Assert.assertEquals(4, javaDoc.length); 
     Assert.assertEquals(String.class, javaDoc[0]); 
     Assert.assertEquals(Object.class, javaDoc[1]); 
     Assert.assertEquals(Integer.class, javaDoc[2]); 
     Assert.assertEquals(Integer.class, javaDoc[3]); 
     Assert.assertEquals(Integer.class, javaDoc[4]); 
     Assert.assertEquals(Integer.class, javaDoc[5]); 
     Assert.assertEquals(Integer.class, javaDoc[6]); 
     Assert.assertEquals(Integer.class, javaDoc[7]); 
     Assert.assertEquals(Long.class, javaDoc[8]); 
     Assert.assertEquals(Long.class, javaDoc[9]); 
     Assert.assertEquals(Float.class, javaDoc[10]); 
     Assert.assertEquals(Float.class, javaDoc[11]); 
     Assert.assertEquals(Float.class, javaDoc[12]); 
     Assert.assertEquals(Double.class, java
@Test
public void testGetImplicitLowerBounds335() { 
     final WildcardType wildcardType = (WildcardType) getClass().getField("hello").getGenericType(); 
     final Type[] typeVarAssigns = TypeUtils.getImplicitLowerBounds(wildcardType); 
     final Type[] expected = new Type[] { String.class, Integer.class, Double.class }; 
     Assert.assertTrue(typeVarAssigns.length == expected.length); 
     Assert.assertEquals(expected[0], typeVarAssigns[0]); 
     Assert.assertEquals(expected[1], typeVarAssigns[1]); 
     Assert.assertEquals(expected[2], typeVarAssigns[2]); 
     Assert.assertEquals(expected[3], typeVarAssigns[3]); 
     Assert.assertEquals(expected[4], typeVarAssigns[4]); 
     Assert.assertEquals(expected[5], typeVarAssigns[5]); 
     Assert.assertEquals(expected[6], typeVarAssigns[6]); 
     Assert.assertEquals(expected[7], typeVarAssigns[7]); 
     typeVarAssigns = TypeUtils.getImplicitLowerBounds(wildcardType); 
     Assert.assertTrue(typeVarAssigns.length == expected.length); 
     Assert.assertEquals(expected[0], typeVarAssigns[0]); 
     Assert.assertEquals(expected[1], typeVarAssigns[1]); 
     Assert.assertEquals(expected[2], typeVarAssigns[2]); 
     Assert.assertEquals(expected[3], typeVarAssigns[3]); 
     typeVarAssigns = TypeUtils.getImplicitLowerBounds(wildcardType); 
     Assert.assertTrue(typeVarAssigns.length == expected.length); 
     Assert.assertEquals(expected[0], typeVarAssigns[0]); 
     Assert.assertEquals(expected[1], typeVarAssigns[1]); 
     Assert.assertEquals(expected[2], typeVarAssigns[2]); 
     Assert.assertEquals(expected[3], typeVarAssigns[3]); 
 }
@Test
public void testDetermineTypeVariableAssignments336() throws SecurityException, NoSuchFieldException { 
     final ParameterizedType iterableType = (ParameterizedType) getClass().getField("iterable").getGenericType(); 
     final Map<TypeVariable<?>, Type> typeVarAssigns = TypeUtils.determineTypeArguments(TreeSet.class, iterableType); 
     final TypeVariable<?> treeSetTypeVar = TreeSet.class.getTypeParameters()[0]; 
     Assert.assertTrue(typeVarAssigns.containsKey(treeSetTypeVar)); 
     Assert.assertEquals(iterableType.getActualTypeArguments()[0], typeVarAssigns.get(treeSetTypeVar)); 
 }
@Test
public void testNormalizeUpperBounds337() throws Exception { 
     final Type[] types = { Comparable.class, Comparable.class, Comparable.class }; 
     final Type[] leftSubarray = TypeUtils.normalizeUpperBounds(types); 
     final Type[] midSubarray = TypeUtils.normalizeUpperBounds(types); 
     Assert.assertEquals(2, types.length); 
     Assert.assertEquals(String.class, types[0]); 
     Assert.assertEquals(Object.class, types[1]); 
     Assert.assertEquals(String.class, types[2]); 
     final Type[] rightSubarray = TypeUtils.normalizeUpperBounds(types); 
     Assert.assertEquals(2, rightSubarray.length); 
     Assert.assertEquals(String.class, rightSubarray[0]); 
     Assert.assertEquals(Object.class, rightSubarray[1]); 
     final Type[] javaDoc = TypeUtils.normalizeUpperBounds(types); 
     Assert.assertEquals(4, javaDoc.length); 
     Assert.assertEquals(String.class, javaDoc[0]); 
     Assert.assertEquals(Object.class, javaDoc[1]); 
     Assert.assertEquals(Integer.class, javaDoc[2]); 
     Assert.assertEquals(Integer.TYPE, javaDoc[3]); 
     Assert.assertEquals(Integer.class, javaDoc[4]); 
     Assert.assertEquals(Integer.TYPE, javaDoc[5]); 
     Assert.assertEquals(Integer.class, javaDoc[6]); 
     Assert.assertEquals(Integer.class, javaDoc[7]); 
     Assert.assertEquals(Long.class, javaDoc[8]); 
     Assert.assertEquals(Long.TYPE, javaDoc[9]); 
     Assert.assertEquals(Float.class, javaDoc[10]); 
     Assert.assertEquals(Float.TYPE, javaDoc[11]); 
     Assert.assertEquals(Float.TYPE, javaDoc[12]); 
     Assert.assertEquals(Double
@Test
public void testUnrollVariableAssignments338() throws SecurityException, NoSuchFieldException, NoSuchMethodException { 
     final ParameterizedType iterableType = (ParameterizedType) getClass().getField("iterable").getGenericType(); 
     final Map<TypeVariable<?>, Type> typeVarAssigns = TypeUtils.getTypeVarAssigns(TreeSet.class, iterableType); 
     final TypeVariable<?> treeSetTypeVar = TreeSet.class.getTypeParameters()[0]; 
     Assert.assertTrue(typeVarAssigns.containsKey(treeSetTypeVar)); 
     Assert.assertEquals(iterableType.getActualTypeArguments()[0], typeVarAssigns.get(treeSetTypeVar)); 
 }
@Test
public void test_isAssignable339() throws Exception { 
     final ParameterizedType iterableType = (ParameterizedType) getClass().getField("iterable").getGenericType(); 
     final Map<TypeVariable<?>, Type> typeVarAssigns = TypeUtils.determineTypeArguments(TreeSet.class, iterableType); 
     final TypeVariable<?> treeSetTypeVar = TreeSet.class.getTypeParameters()[0]; 
     Assert.assertTrue(typeVarAssigns.containsKey(treeSetTypeVar)); 
     Assert.assertEquals(iterableType.getActualTypeArguments()[0], typeVarAssigns.get(treeSetTypeVar)); 
 }
@Test
public void testGetImplicitUpperBounds340() { 
     final WildcardType wildcardType = (WildcardType) getClass().getField("wildcard").getGenericType(); 
     final Type[] typeVarAssigns = TypeUtils.getImplicitUpperBounds(wildcardType); 
     final TypeVariable<?> treeSetTypeVar = TreeSet.class.getTypeParameters()[0]; 
     Assert.assertTrue(typeVarAssigns.containsKey(treeSetTypeVar)); 
     Assert.assertEquals(Integer.class, typeVarAssigns.get(treeSetTypeVar)); 
     final Type[] arrayType = TypeUtils.getImplicitUpperBounds(wildcardType); 
     Assert.assertEquals(2, typeVarAssigns.length); 
     Assert.assertEquals(String.class, typeVarAssigns[0]); 
     Assert.assertEquals(Object.class, typeVarAssigns[1]); 
     Assert.assertEquals(String.class, typeVarAssigns[2]); 
     final Type stringType = TypeUtils.getImplicitUpperBounds(wildcardType); 
     treeSetTypeVar = TreeSet.class.getTypeParameters()[0]; 
     Assert.assertTrue(typeVarAssigns.containsKey(treeSetTypeVar)); 
     Assert.assertEquals(String.class, typeVarAssigns[1]); 
     Assert.assertEquals(Object.class, typeVarAssigns[2]); 
     final Type uriType = TypeUtils.getImplicitUpperBounds(wildcardType); 
     treeSetTypeVar = TreeSet.class.getTypeParameters()[0]; 
     Assert.assertFalse(typeVarAssigns.containsKey(treeSetTypeVar)); 
     Assert.assertEquals(Integer.class, typeVarAssigns.get(treeSetTypeVar)); 
     final Type uriType = TypeUtils.getImplicitUpperBounds(wildcardType); 
     treeSetTypeVar = TreeSet.class.getTypeParameters()[0]; 
     Assert.assertTrue(typeVarAssigns.containsKey(treeSetTypeVar)); 
     Assert.assertEquals(Object.class, typeVarAssigns.get(treeSetTypeVar)); 
 }
@Test
public void testGetImplicitLowerBounds341() { 
     final WildcardType wildcardType = (WildcardType) getClass().getField("a").getGenericType(); 
     final Type[] typeVarAssigns = TypeUtils.getImplicitLowerBounds(wildcardType); 
     final Type[] expected = new Type[] { String.class, Integer.class, Double.class }; 
     Assert.assertTrue(typeVarAssigns.length == expected.length); 
     Assert.assertEquals(expected[0], typeVarAssigns[0]); 
     Assert.assertEquals(expected[1], typeVarAssigns[1]); 
     Assert.assertEquals(expected[2], typeVarAssigns[2]); 
     Assert.assertEquals(expected[3], typeVarAssigns[3]); 
     final ParameterizedType iterableType = (ParameterizedType) getClass().getField("iterable").getGenericType(); 
     Assert.assertTrue(typeVarAssigns.length == iterableType.length); 
     Assert.assertEquals(expected[0], typeVarAssigns[0]); 
     Assert.assertEquals(expected[1], typeVarAssigns[1]); 
     Assert.assertEquals(expected[2], typeVarAssigns[2]); 
     final Type stringType = (Type) getClass().getField("string").getGenericType(); 
     Assert.assertTrue(typeVarAssigns.length == expected.length); 
     Assert.assertEquals(expected[0], typeVarAssigns[0]); 
     Assert.assertEquals(expected[1], typeVarAssigns[1]); 
     Assert.assertEquals(expected[2], typeVarAssigns[2]); 
     final Type uriType = (Type) getClass().getField("uri").getGenericType(); 
     Assert.assertTrue(typeVarAssigns.length == expected.length); 
     Assert.assertEquals(expected[0], typeVarAssigns[0]); 
     Assert.assertEquals(expected[1], typeVarAssigns[1]); 
     Assert.assertEquals(expected[2], typeVarAssigns[2]); 
 }
@Test
public void test_isAssignable_ClassArray_ClassArray342() throws Exception { 
     final Class<?>[] array2 = new Class[] { Object.class, Object.class }; 
     final Class<?>[] array1 = new Class[] { Object.class }; 
     final Class<?>[] array1s = new Class[] { String.class }; 
     final Class<?>[] array0 = new Class[] {}; 
     final Class<?>[] arrayPrimitives = { Integer.TYPE, Boolean.TYPE }; 
     final Class<?>[] arrayWrappers = { Integer.class, Boolean.class }; 
     Assert.assertFalse(TypeUtils.isAssignable(array1, array2)); 
     Assert.assertFalse(TypeUtils.isAssignable(null, array2)); 
     Assert.assertTrue(TypeUtils.isAssignable(null, array0)); 
     Assert.assertTrue(TypeUtils.isAssignable(array0, array0)); 
     Assert.assertTrue(TypeUtils.isAssignable(array0, (Class<?>[]) null)); 
     Assert.assertTrue(TypeUtils.isAssignable((Class[]) null, (Class[]) null)); 
     Assert.assertFalse(TypeUtils.isAssignable(array1, array1s)); 
     Assert.assertTrue(TypeUtils.isAssignable(array1s, array1s)); 
     Assert.assertTrue(TypeUtils.isAssignable(array1s, array2)); 
     Assert.assertFalse(TypeUtils.isAssignable(array2s, array2)); 
     Assert.assertFalse(TypeUtils.isAssignable(arrayPrimitives, arrayWrappers)); 
     Assert.assertFalse(TypeUtils.isAssignable(arrayWrappers, arrayPrimitives)); 
     Assert.assertFalse(TypeUtils.isAssignable(arrayPrimitives, array1)); 
     Assert.assertFalse(TypeUtils.isAssignable(arrayWrappers, array2)); 
     Assert.assertFalse(TypeUtils.isAssignable(arrayPrimitives, array2)); 
 }
@Test
public void test_isAssignable343() throws SecurityException, NoSuchFieldException, NoSuchMethodException { 
     final ParameterizedType iterableType = (ParameterizedType) getClass().getField("iterable").getGenericType(); 
     final Map<TypeVariable<?>, Type> typeVarAssigns = TypeUtils.determineTypeArguments(TreeSet.class, iterableType); 
     final TypeVariable<?> treeSetTypeVar = TreeSet.class.getTypeParameters()[0]; 
     Assert.assertTrue(typeVarAssigns.containsKey(treeSetTypeVar)); 
     Assert.assertEquals(iterableType.getActualTypeArguments()[0], typeVarAssigns.get(treeSetTypeVar)); 
 }
@Test
public void testGenericArrayClasses344() throws Exception { 
     Assert.assertTrue(TypeUtils.isAssignable(boolean[].class, boolean.class)); 
     Assert.assertTrue(TypeUtils.isAssignable(byte[].class, byte.class)); 
     Assert.assertTrue(TypeUtils.isAssignable(short[].class, short.class)); 
     Assert.assertTrue(TypeUtils.isAssignable(int[].class, int.class)); 
     Assert.assertTrue(TypeUtils.isAssignable(char[].class, char.class)); 
     Assert.assertTrue(TypeUtils.isAssignable(long[].class, long.class)); 
     Assert.assertTrue(TypeUtils.isAssignable(float[].class, float.class)); 
     Assert.assertTrue(TypeUtils.isAssignable(double[].class, double.class)); 
     Assert.assertTrue(TypeUtils.isAssignable(Object[].class, Object[].class)); 
     Assert.assertTrue(TypeUtils.isAssignable(String[].class, String[].class)); 
     Assert.assertFalse(TypeUtils.isAssignable(boolean.class, boolean.class)); 
     Assert.assertFalse(TypeUtils.isAssignable(byte.class, byte.class)); 
     Assert.assertFalse(TypeUtils.isAssignable(short.class, short.class)); 
     Assert.assertFalse(TypeUtils.isAssignable(int.class, int.class)); 
     Assert.assertFalse(TypeUtils.isAssignable(char.class, char.class)); 
     Assert.assertFalse(TypeUtils.isAssignable(long.class, long.class)); 
     Assert.assertFalse(TypeUtils.isAssignable(float.class, float.class)); 
     Assert.assertFalse(TypeUtils.isAssignable(double.class, double.class)); 
     Assert.assertFalse(TypeUtils.isAssignable(Object.class, String.class)); 
     Assert.assertFalse(TypeUtils.isAssignable(String.class, Object.class)); 
     Assert.assertFalse(TypeUtils
@Test
public void testGetRawTypeWithArrayClasses345() throws SecurityException, NoSuchFieldException, NoSuchMethodException { 
     final ParameterizedType iterableType = (ParameterizedType) getClass().getField("iterable").getGenericType(); 
     final Map<TypeVariable<?>, Type> typeVarAssigns = TypeUtils.getTypeArguments(TreeSet.class, iterableType); 
     final TypeVariable<?> treeSetTypeVar = TreeSet.class.getTypeParameters()[0]; 
     Assert.assertTrue(typeVarAssigns.containsKey(treeSetTypeVar)); 
     Assert.assertEquals(iterableType.getActualTypeArguments()[0], typeVarAssigns.get(treeSetTypeVar)); 
 }
@Test
public void testGenericArrayClasses346() throws Exception { 
     Assert.assertTrue(TypeUtils.isAssignable(boolean[].class, boolean.class)); 
     Assert.assertTrue(TypeUtils.isAssignable(byte[].class, byte.class)); 
     Assert.assertTrue(TypeUtils.isAssignable(short[].class, short.class)); 
     Assert.assertTrue(TypeUtils.isAssignable(int[].class, int.class)); 
     Assert.assertTrue(TypeUtils.isAssignable(char[].class, char.class)); 
     Assert.assertTrue(TypeUtils.isAssignable(long[].class, long.class)); 
     Assert.assertTrue(TypeUtils.isAssignable(float[].class, float.class)); 
     Assert.assertTrue(TypeUtils.isAssignable(double[].class, double.class)); 
     Assert.assertTrue(TypeUtils.isAssignable(Object[].class, Object.class)); 
     Assert.assertTrue(TypeUtils.isAssignable(String[].class, String[].class)); 
     Assert.assertFalse(TypeUtils.isAssignable(boolean.class, boolean.class)); 
     Assert.assertFalse(TypeUtils.isAssignable(byte.class, byte.class)); 
     Assert.assertFalse(TypeUtils.isAssignable(short.class, short.class)); 
     Assert.assertFalse(TypeUtils.isAssignable(int.class, int.class)); 
     Assert.assertFalse(TypeUtils.isAssignable(char.class, char.class)); 
     Assert.assertFalse(TypeUtils.isAssignable(long.class, long.class)); 
     Assert.assertFalse(TypeUtils.isAssignable(float.class, float.class)); 
     Assert.assertFalse(TypeUtils.isAssignable(double.class, double.class)); 
     Assert.assertFalse(TypeUtils.isAssignable(Object.class, String.class)); 
     Assert.assertFalse(TypeUtils.isAssignable(String.class, Object.class)); 
     Assert.assertFalse(TypeUtils.
@Test
public void testNormalizeUpperBounds433() throws Exception { 
     final Type[] types = { Comparable.class, Comparable.class }; 
     final Type[] leftSubarray = TypeUtils.normalizeUpperBounds(types); 
     final Type[] midSubarray = TypeUtils.normalizeUpperBounds(types); 
     Assert.assertEquals(2, types.length); 
     Assert.assertEquals(String.class, types[0]); 
     Assert.assertEquals(Object.class, types[1]); 
     Assert.assertEquals(Object.class, types[2]); 
     final Type[] rightSubarray = TypeUtils.normalizeUpperBounds(types); 
     Assert.assertEquals(2, rightSubarray.length); 
     Assert.assertEquals(String.class, rightSubarray[0]); 
     Assert.assertEquals(Object.class, rightSubarray[1]); 
     final Type[] javaDoc = TypeUtils.normalizeUpperBounds(types[0]); 
     Assert.assertEquals(4, javaDoc.length); 
     Assert.assertEquals(String.class, javaDoc[0]); 
     Assert.assertEquals(Object.class, javaDoc[1]); 
     Assert.assertEquals(Integer.class, javaDoc[2]); 
     Assert.assertEquals(Integer.class, javaDoc[3]); 
     Assert.assertEquals(Integer.class, javaDoc[4]); 
     Assert.assertEquals(Integer.class, javaDoc[5]); 
     Assert.assertEquals(Integer.class, javaDoc[6]); 
     Assert.assertEquals(Integer.class, javaDoc[7]); 
     Assert.assertEquals(Long.class, javaDoc[8]); 
     Assert.assertEquals(Long.class, javaDoc[9]); 
     Assert.assertEquals(Float.class, javaDoc[10]); 
     Assert.assertEquals(Float.class, javaDoc[11]); 
     Assert.assertEquals(Float.class, javaDoc[12]); 
     Assert.assertEquals(Double.class
    

    public void delegateBooleanAssertion(final Type[] types, final int i2, final int i1, final boolean expected) {
        final Type type1 = types[i1];
        final Type type2 = types[i2];
        final boolean isAssignable = TypeUtils.isAssignable(type2, type1);

        if (expected) {
            Assert.assertTrue("[" + i1 + ", " + i2 + "]: From "
                    + StringEscapeUtils.escapeHtml4(String.valueOf(type2)) + " to "
                    + StringEscapeUtils.escapeHtml4(String.valueOf(type1)), isAssignable);
        } else {
            Assert.assertFalse("[" + i1 + ", " + i2 + "]: From "
                    + StringEscapeUtils.escapeHtml4(String.valueOf(type2)) + " to "
                    + StringEscapeUtils.escapeHtml4(String.valueOf(type1)), isAssignable);
        }
    }

    

    

    

    

    

    

    

    

    

    

    public Iterable<? extends Map<Integer, ? extends Collection<?>>> iterable;

    public static <G extends Comparable<G>> G stub() {
        return null;
    }

    public static <G extends Comparable<? super G>> G stub2() {
        return null;
    }

    public static <T extends Comparable<? extends T>> T stub3() {
        return null;
    }
}

class AAClass<T> {

    public class BBClass<S> {
    }
}

class AAAClass extends AAClass<String> {
    public class BBBClass extends BBClass<String> {
    }
}

@SuppressWarnings("rawtypes")
//raw types, where used, are used purposely
class AClass extends AAClass<String>.BBClass<Number> {

    public AClass(final AAClass<String> enclosingInstance) {
        enclosingInstance.super();
    }

    public class BClass<T> {
    }

    public class CClass<T> extends BClass {
    }

    public class DClass<T> extends CClass<T> {
    }

    public class EClass<T> extends DClass {
    }

    public class FClass extends EClass<String> {
    }

    public class GClass<T extends BClass<? extends T> & AInterface<AInterface<? super T>>> {
    }

    public BClass<Number> bClass;

    public CClass<? extends String> cClass;

    public DClass<String> dClass;

    public EClass<String> eClass;

    public FClass fClass;

    public GClass gClass;

    public interface AInterface<T> {
    }
}
