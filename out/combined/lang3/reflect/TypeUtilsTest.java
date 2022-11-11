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
public void testGetRawType10() throws SecurityException, NoSuchFieldException { 
     final Type stringParentFieldType = GenericTypeHolder.class.getDeclaredField("stringParent").getGenericType(); 
     final Type integerParentFieldType = GenericTypeHolder.class.getDeclaredField("integerParent").getGenericType(); 
     final Type foosFieldType = GenericTypeHolder.class.getDeclaredField("foos").getGenericType(); 
     final Type genericParentT = GenericParent.class.getTypeParameters()[0]; 
     Assert.assertEquals(GenericParent.class, TypeUtils.getRawType(stringParentFieldType, null)); 
     Assert.assertEquals(GenericParent.class, TypeUtils.getRawType(integerParentFieldType, null)); 
     Assert.assertEquals(List.class, TypeUtils.getRawType(foosFieldType, null)); 
     Assert.assertEquals(String.class, TypeUtils.getRawType(genericParentT, StringParameterizedChild.class)); 
     Assert.assertEquals(String.class, TypeUtils.getRawType(genericParentT, stringParentFieldType)); 
     Assert.assertEquals(Foo.class, TypeUtils.getRawType(Iterable.class.getTypeParameters()[0], foosFieldType)); 
     Assert.assertEquals(Foo.class, TypeUtils.getRawType(List.class.getTypeParameters()[0], foosFieldType)); 
     Assert.assertNull(TypeUtils.getRawType(genericParentT, GenericParent.class)); 
     Assert.assertEquals(GenericParent[].class, TypeUtils.getRawType(GenericTypeHolder.class.getDeclaredField("barParents").getGenericType(), null)); 
 } 
@SuppressWarnings("boxing")
@Test
public void testIsInstance220() throws SecurityException, NoSuchFieldException { 
     final Type intComparableType = getClass().getField("intComparable").getGenericType(); 
     final Type uriComparableType = getClass().getField("uriComparable").getGenericType(); 
     intComparable = 1; 
     Assert.assertTrue(TypeUtils.isInstance(1, intComparableType)); 
     Assert.assertFalse(TypeUtils.isInstance(1, uriComparableType)); 
 } 
@SuppressWarnings("boxing")
@Test
public void testIsInstance249() throws SecurityException, NoSuchFieldException { 
     final Type intComparableType = getClass().getField("intComparable").getGenericType(); 
     final Type uriComparableType = getClass().getField("uriComparable").getGenericType(); 
     intComparable = 1; 
     Assert.assertTrue(TypeUtils.isInstance(1, intComparableType)); 
     Assert.assertFalse(TypeUtils.isInstance(1, uriComparableType)); 
 }
@Test
public void testIsArrayGenericTypes337() throws Exception { 
     final Method method = getClass().getMethod("dummyMethod", List.class, List.class, List.class, List.class, List.class, List.class, List.class, List[].class, List[].class, List[].class, List[].class, List[].class, List[].class, List[].class); 
     final Type[] types = method.getGenericParameterTypes(); 
     Assert.assertFalse(TypeUtils.isArrayType(types[0])); 
     Assert.assertFalse(TypeUtils.isArrayType(types[1])); 
     Assert.assertFalse(TypeUtils.isArrayType(types[2])); 
     Assert.assertFalse(TypeUtils.isArrayType(types[3])); 
     Assert.assertFalse(TypeUtils.isArrayType(types[4])); 
     Assert.assertFalse(TypeUtils.isArrayType(types[5])); 
     Assert.assertFalse(TypeUtils.isArrayType(types[6])); 
     Assert.assertTrue(TypeUtils.isArrayType(types[7])); 
     Assert.assertTrue(TypeUtils.isArrayType(types[8])); 
     Assert.assertTrue(TypeUtils.isArrayType(types[9])); 
     Assert.assertTrue(TypeUtils.isArrayType(types[10])); 
     Assert.assertTrue(TypeUtils.isArrayType(types[11])); 
     Assert.assertTrue(TypeUtils.isArrayType(types[12])); 
     Assert.assertTrue(TypeUtils.isArrayType(types[13])); 
 } 
@SuppressWarnings("boxing")
@Test
public void testIsInstance524() throws SecurityException, NoSuchFieldException { 
     final Type intComparableType = getClass().getField("intComparable").getGenericType(); 
     final Type uriComparableType = getClass().getField("uriComparable").getGenericType(); 
     intComparable = 1; 
     Assert.assertTrue(TypeUtils.isInstance(1, intComparableType)); 
     Assert.assertFalse(TypeUtils.isInstance(1, uriComparableType)); 
 }
@Test
public void testGetRawType562() throws SecurityException, NoSuchFieldException { 
     final Type stringParentFieldType = GenericTypeHolder.class.getDeclaredField("stringParent").getGenericType(); 
     final Type integerParentFieldType = GenericTypeHolder.class.getDeclaredField("integerParent").getGenericType(); 
     final Type foosFieldType = GenericTypeHolder.class.getDeclaredField("foos").getGenericType(); 
     final Type genericParentT = GenericParent.class.getTypeParameters()[0]; 
     Assert.assertEquals(GenericParent.class, TypeUtils.getRawType(stringParentFieldType, null)); 
     Assert.assertEquals(GenericParent.class, TypeUtils.getRawType(integerParentFieldType, null)); 
     Assert.assertEquals(List.class, TypeUtils.getRawType(foosFieldType, null)); 
     Assert.assertEquals(String.class, TypeUtils.getRawType(genericParentT, StringParameterizedChild.class)); 
     Assert.assertEquals(String.class, TypeUtils.getRawType(genericParentT, stringParentFieldType)); 
     Assert.assertEquals(Foo.class, TypeUtils.getRawType(Iterable.class.getTypeParameters()[0], foosFieldType)); 
     Assert.assertEquals(Foo.class, TypeUtils.getRawType(List.class.getTypeParameters()[0], foosFieldType)); 
     Assert.assertNull(TypeUtils.getRawType(genericParentT, GenericParent.class)); 
     Assert.assertEquals(GenericParent[].class, TypeUtils.getRawType(GenericTypeHolder.class.getDeclaredField("barParents").getGenericType(), null)); 
 }
@Test
public void testGetRawType647() throws SecurityException, NoSuchFieldException { 
     final Type stringParentFieldType = GenericTypeHolder.class.getDeclaredField("stringParent").getGenericType(); 
     final Type integerParentFieldType = GenericTypeHolder.class.getDeclaredField("integerParent").getGenericType(); 
     final Type foosFieldType = GenericTypeHolder.class.getDeclaredField("foos").getGenericType(); 
     final Type genericParentT = GenericParent.class.getTypeParameters()[0]; 
     Assert.assertEquals(GenericParent.class, TypeUtils.getRawType(stringParentFieldType, null)); 
     Assert.assertEquals(GenericParent.class, TypeUtils.getRawType(integerParentFieldType, null)); 
     Assert.assertEquals(List.class, TypeUtils.getRawType(foosFieldType, null)); 
     Assert.assertEquals(String.class, TypeUtils.getRawType(genericParentT, StringParameterizedChild.class)); 
     Assert.assertEquals(String.class, TypeUtils.getRawType(genericParentT, stringParentFieldType)); 
     Assert.assertEquals(Foo.class, TypeUtils.getRawType(Iterable.class.getTypeParameters()[0], foosFieldType)); 
     Assert.assertEquals(Foo.class, TypeUtils.getRawType(List.class.getTypeParameters()[0], foosFieldType)); 
     Assert.assertNull(TypeUtils.getRawType(genericParentT, GenericParent.class)); 
     Assert.assertEquals(GenericParent[].class, TypeUtils.getRawType(GenericTypeHolder.class.getDeclaredField("barParents").getGenericType(), null)); 
 } 
@SuppressWarnings("boxing")
@Test
public void testIsInstance733() throws SecurityException, NoSuchFieldException { 
     final Type intComparableType = getClass().getField("intComparable").getGenericType(); 
     final Type uriComparableType = getClass().getField("uriComparable").getGenericType(); 
     intComparable = 1; 
     Assert.assertTrue(TypeUtils.isInstance(1, intComparableType)); 
     Assert.assertFalse(TypeUtils.isInstance(1, uriComparableType)); 
 }
@Test
public void testGetRawType903() throws SecurityException, NoSuchFieldException { 
     final Type stringParentFieldType = GenericTypeHolder.class.getDeclaredField("stringParent").getGenericType(); 
     final Type integerParentFieldType = GenericTypeHolder.class.getDeclaredField("integerParent").getGenericType(); 
     final Type foosFieldType = GenericTypeHolder.class.getDeclaredField("foos").getGenericType(); 
     final Type genericParentT = GenericParent.class.getTypeParameters()[0]; 
     Assert.assertEquals(GenericParent.class, TypeUtils.getRawType(stringParentFieldType, null)); 
     Assert.assertEquals(GenericParent.class, TypeUtils.getRawType(integerParentFieldType, null)); 
     Assert.assertEquals(List.class, TypeUtils.getRawType(foosFieldType, null)); 
     Assert.assertEquals(String.class, TypeUtils.getRawType(genericParentT, StringParameterizedChild.class)); 
     Assert.assertEquals(String.class, TypeUtils.getRawType(genericParentT, stringParentFieldType)); 
     Assert.assertEquals(Foo.class, TypeUtils.getRawType(Iterable.class.getTypeParameters()[0], foosFieldType)); 
     Assert.assertEquals(Foo.class, TypeUtils.getRawType(List.class.getTypeParameters()[0], foosFieldType)); 
     Assert.assertNull(TypeUtils.getRawType(genericParentT, GenericParent.class)); 
     Assert.assertEquals(GenericParent[].class, TypeUtils.getRawType(GenericTypeHolder.class.getDeclaredField("barParents").getGenericType(), null)); 
 } 
@SuppressWarnings("boxing")
@Test
public void testIsInstance947() throws SecurityException, NoSuchFieldException { 
     final Type intComparableType = getClass().getField("intComparable").getGenericType(); 
     final Type uriComparableType = getClass().getField("uriComparable").getGenericType(); 
     intComparable = 1; 
     Assert.assertTrue(TypeUtils.isInstance(1, intComparableType)); 
     Assert.assertFalse(TypeUtils.isInstance(1, uriComparableType)); 
 }
@Test
public void testGetRawType999() throws SecurityException, NoSuchFieldException { 
     final Type stringParentFieldType = GenericTypeHolder.class.getDeclaredField("stringParent").getGenericType(); 
     final Type integerParentFieldType = GenericTypeHolder.class.getDeclaredField("integerParent").getGenericType(); 
     final Type foosFieldType = GenericTypeHolder.class.getDeclaredField("foos").getGenericType(); 
     final Type genericParentT = GenericParent.class.getTypeParameters()[0]; 
     Assert.assertEquals(GenericParent.class, TypeUtils.getRawType(stringParentFieldType, null)); 
     Assert.assertEquals(GenericParent.class, TypeUtils.getRawType(integerParentFieldType, null)); 
     Assert.assertEquals(List.class, TypeUtils.getRawType(foosFieldType, null)); 
     Assert.assertEquals(String.class, TypeUtils.getRawType(genericParentT, StringParameterizedChild.class)); 
     Assert.assertEquals(String.class, TypeUtils.getRawType(genericParentT, stringParentFieldType)); 
     Assert.assertEquals(Foo.class, TypeUtils.getRawType(Iterable.class.getTypeParameters()[0], foosFieldType)); 
     Assert.assertEquals(Foo.class, TypeUtils.getRawType(List.class.getTypeParameters()[0], foosFieldType)); 
     Assert.assertNull(TypeUtils.getRawType(genericParentT, GenericParent.class)); 
     Assert.assertEquals(GenericParent[].class, TypeUtils.getRawType(GenericTypeHolder.class.getDeclaredField("barParents").getGenericType(), null)); 
 } 
@SuppressWarnings("boxing")
@Test
public void testIsInstance1717() throws SecurityException, NoSuchFieldException { 
     final Type intComparableType = getClass().getField("intComparable").getGenericType(); 
     final Type uriComparableType = getClass().getField("uriComparable").getGenericType(); 
     intComparable = 1; 
     Assert.assertTrue(TypeUtils.isInstance(1, intComparableType)); 
     Assert.assertFalse(TypeUtils.isInstance(1, uriComparableType)); 
 } 
@SuppressWarnings("boxing")
@Test
public void testIsInstance1817() throws SecurityException, NoSuchFieldException { 
     final Type intComparableType = getClass().getField("intComparable").getGenericType(); 
     final Type uriComparableType = getClass().getField("uriComparable").getGenericType(); 
     intComparable = 1; 
     Assert.assertTrue(TypeUtils.isInstance(1, intComparableType)); 
     Assert.assertFalse(TypeUtils.isInstance(1, uriComparableType)); 
 }
@Test
public void testDetermineTypeVariableAssignments1964() throws SecurityException, NoSuchFieldException, NoSuchMethodException { 
     final ParameterizedType iterableType = (ParameterizedType) getClass().getField("iterable").getGenericType(); 
     final Map<TypeVariable<?>, Type> typeVarAssigns = TypeUtils.determineTypeArguments(TreeSet.class, iterableType); 
     final TypeVariable<?> treeSetTypeVar = TreeSet.class.getTypeParameters()[0]; 
     Assert.assertTrue(typeVarAssigns.containsKey(treeSetTypeVar)); 
     Assert.assertEquals(iterableType.getActualTypeArguments()[0], typeVarAssigns.get(treeSetTypeVar)); 
 }
@Test
public void testIsArrayGenericTypes2045() throws Exception { 
     final Method method = getClass().getMethod("dummyMethod", List.class, List.class, List.class, List.class, List.class, List.class, List.class, List[].class, List[].class, List[].class, List[].class, List[].class, List[].class, List[].class); 
     final Type[] types = method.getGenericParameterTypes(); 
     Assert.assertFalse(TypeUtils.isArrayType(types[0])); 
     Assert.assertFalse(TypeUtils.isArrayType(types[1])); 
     Assert.assertFalse(TypeUtils.isArrayType(types[2])); 
     Assert.assertFalse(TypeUtils.isArrayType(types[3])); 
     Assert.assertFalse(TypeUtils.isArrayType(types[4])); 
     Assert.assertFalse(TypeUtils.isArrayType(types[5])); 
     Assert.assertFalse(TypeUtils.isArrayType(types[6])); 
     Assert.assertTrue(TypeUtils.isArrayType(types[7])); 
     Assert.assertTrue(TypeUtils.isArrayType(types[8])); 
     Assert.assertTrue(TypeUtils.isArrayType(types[9])); 
     Assert.assertTrue(TypeUtils.isArrayType(types[10])); 
     Assert.assertTrue(TypeUtils.isArrayType(types[11])); 
     Assert.assertTrue(TypeUtils.isArrayType(types[12])); 
     Assert.assertTrue(TypeUtils.isArrayType(types[13])); 
 } 
@SuppressWarnings("boxing")
@Test
public void testIsInstance2074() throws SecurityException, NoSuchFieldException { 
     final Type intComparableType = getClass().getField("intComparable").getGenericType(); 
     final Type uriComparableType = getClass().getField("uriComparable").getGenericType(); 
     intComparable = 1; 
     Assert.assertTrue(TypeUtils.isInstance(1, intComparableType)); 
     Assert.assertFalse(TypeUtils.isInstance(1, uriComparableType)); 
 } 
@SuppressWarnings("boxing")
@Test
public void testIsInstance2079() throws SecurityException, NoSuchFieldException { 
     final Type intComparableType = getClass().getField("intComparable").getGenericType(); 
     final Type uriComparableType = getClass().getField("uriComparable").getGenericType(); 
     intComparable = 1; 
     Assert.assertTrue(TypeUtils.isInstance(1, intComparableType)); 
     Assert.assertFalse(TypeUtils.isInstance(1, uriComparableType)); 
 }
@Test
public void testGetArrayComponentType2115() throws Exception { 
     final Method method = getClass().getMethod("dummyMethod", List.class, List.class, List.class, List.class, List.class, List.class, List.class, List[].class, List[].class, List[].class, List[].class, List[].class, List[].class, List[].class); 
     final Type[] types = method.getGenericParameterTypes(); 
     Assert.assertNull(TypeUtils.getArrayComponentType(types[0])); 
     Assert.assertNull(TypeUtils.getArrayComponentType(types[1])); 
     Assert.assertNull(TypeUtils.getArrayComponentType(types[2])); 
     Assert.assertNull(TypeUtils.getArrayComponentType(types[3])); 
     Assert.assertNull(TypeUtils.getArrayComponentType(types[4])); 
     Assert.assertNull(TypeUtils.getArrayComponentType(types[5])); 
     Assert.assertNull(TypeUtils.getArrayComponentType(types[6])); 
     Assert.assertEquals(types[0], TypeUtils.getArrayComponentType(types[7])); 
     Assert.assertEquals(types[1], TypeUtils.getArrayComponentType(types[8])); 
     Assert.assertEquals(types[2], TypeUtils.getArrayComponentType(types[9])); 
     Assert.assertEquals(types[3], TypeUtils.getArrayComponentType(types[10])); 
     Assert.assertEquals(types[4], TypeUtils.getArrayComponentType(types[11])); 
     Assert.assertEquals(types[5], TypeUtils.getArrayComponentType(types[12])); 
     Assert.assertEquals(types[6], TypeUtils.getArrayComponentType(types[13])); 
 } 
@SuppressWarnings("boxing")
@Test
public void testIsInstance2153() throws SecurityException, NoSuchFieldException { 
     final Type intComparableType = getClass().getField("intComparable").getGenericType(); 
     final Type uriComparableType = getClass().getField("uriComparable").getGenericType(); 
     intComparable = 1; 
     Assert.assertTrue(TypeUtils.isInstance(1, intComparableType)); 
     Assert.assertFalse(TypeUtils.isInstance(1, uriComparableType)); 
 }
@Test
public void testDetermineTypeVariableAssignments2259() throws SecurityException, NoSuchFieldException, NoSuchMethodException { 
     final ParameterizedType iterableType = (ParameterizedType) getClass().getField("iterable").getGenericType(); 
     final Map<TypeVariable<?>, Type> typeVarAssigns = TypeUtils.determineTypeArguments(TreeSet.class, iterableType); 
     final TypeVariable<?> treeSetTypeVar = TreeSet.class.getTypeParameters()[0]; 
     Assert.assertTrue(typeVarAssigns.containsKey(treeSetTypeVar)); 
     Assert.assertEquals(iterableType.getActualTypeArguments()[0], typeVarAssigns.get(treeSetTypeVar)); 
 }
@Test
public void testGetRawType2453() throws SecurityException, NoSuchFieldException { 
     final Type stringParentFieldType = GenericTypeHolder.class.getDeclaredField("stringParent").getGenericType(); 
     final Type integerParentFieldType = GenericTypeHolder.class.getDeclaredField("integerParent").getGenericType(); 
     final Type foosFieldType = GenericTypeHolder.class.getDeclaredField("foos").getGenericType(); 
     final Type genericParentT = GenericParent.class.getTypeParameters()[0]; 
     Assert.assertEquals(GenericParent.class, TypeUtils.getRawType(stringParentFieldType, null)); 
     Assert.assertEquals(GenericParent.class, TypeUtils.getRawType(integerParentFieldType, null)); 
     Assert.assertEquals(List.class, TypeUtils.getRawType(foosFieldType, null)); 
     Assert.assertEquals(String.class, TypeUtils.getRawType(genericParentT, StringParameterizedChild.class)); 
     Assert.assertEquals(String.class, TypeUtils.getRawType(genericParentT, stringParentFieldType)); 
     Assert.assertEquals(Foo.class, TypeUtils.getRawType(Iterable.class.getTypeParameters()[0], foosFieldType)); 
     Assert.assertEquals(Foo.class, TypeUtils.getRawType(List.class.getTypeParameters()[0], foosFieldType)); 
     Assert.assertNull(TypeUtils.getRawType(genericParentT, GenericParent.class)); 
     Assert.assertEquals(GenericParent[].class, TypeUtils.getRawType(GenericTypeHolder.class.getDeclaredField("barParents").getGenericType(), null)); 
 }
@Test
public void testDetermineTypeVariableAssignments2525() throws SecurityException, NoSuchFieldException, NoSuchMethodException { 
     final ParameterizedType iterableType = (ParameterizedType) getClass().getField("iterable").getGenericType(); 
     final Map<TypeVariable<?>, Type> typeVarAssigns = TypeUtils.determineTypeArguments(TreeSet.class, iterableType); 
     final TypeVariable<?> treeSetTypeVar = TreeSet.class.getTypeParameters()[0]; 
     Assert.assertTrue(typeVarAssigns.containsKey(treeSetTypeVar)); 
     Assert.assertEquals(iterableType.getActualTypeArguments()[0], typeVarAssigns.get(treeSetTypeVar)); 
 }
@Test
public void testDetermineTypeVariableAssignments2567() throws SecurityException, NoSuchFieldException, NoSuchMethodException { 
     final ParameterizedType iterableType = (ParameterizedType) getClass().getField("iterable").getGenericType(); 
     final Map<TypeVariable<?>, Type> typeVarAssigns = TypeUtils.determineTypeArguments(TreeSet.class, iterableType); 
     final TypeVariable<?> treeSetTypeVar = TreeSet.class.getTypeParameters()[0]; 
     Assert.assertTrue(typeVarAssigns.containsKey(treeSetTypeVar)); 
     Assert.assertEquals(iterableType.getActualTypeArguments()[0], typeVarAssigns.get(treeSetTypeVar)); 
 }
@Test
public void testDetermineTypeVariableAssignments2577() throws SecurityException, NoSuchFieldException, NoSuchMethodException { 
     final ParameterizedType iterableType = (ParameterizedType) getClass().getField("iterable").getGenericType(); 
     final Map<TypeVariable<?>, Type> typeVarAssigns = TypeUtils.determineTypeArguments(TreeSet.class, iterableType); 
     final TypeVariable<?> treeSetTypeVar = TreeSet.class.getTypeParameters()[0]; 
     Assert.assertTrue(typeVarAssigns.containsKey(treeSetTypeVar)); 
     Assert.assertEquals(iterableType.getActualTypeArguments()[0], typeVarAssigns.get(treeSetTypeVar)); 
 }
@Test
public void testLang8202586() throws Exception { 
     final Type[] typeArray = { String.class, String.class }; 
     final Type[] expectedArray = { String.class }; 
     Assert.assertArrayEquals(expectedArray, TypeUtils.normalizeUpperBounds(typeArray)); 
 }
@Test
public void testGetRawType3057() throws SecurityException, NoSuchFieldException { 
     final Type stringParentFieldType = GenericTypeHolder.class.getDeclaredField("stringParent").getGenericType(); 
     final Type integerParentFieldType = GenericTypeHolder.class.getDeclaredField("integerParent").getGenericType(); 
     final Type foosFieldType = GenericTypeHolder.class.getDeclaredField("foos").getGenericType(); 
     final Type genericParentT = GenericParent.class.getTypeParameters()[0]; 
     Assert.assertEquals(GenericParent.class, TypeUtils.getRawType(stringParentFieldType, null)); 
     Assert.assertEquals(GenericParent.class, TypeUtils.getRawType(integerParentFieldType, null)); 
     Assert.assertEquals(List.class, TypeUtils.getRawType(foosFieldType, null)); 
     Assert.assertEquals(String.class, TypeUtils.getRawType(genericParentT, StringParameterizedChild.class)); 
     Assert.assertEquals(String.class, TypeUtils.getRawType(genericParentT, stringParentFieldType)); 
     Assert.assertEquals(Foo.class, TypeUtils.getRawType(Iterable.class.getTypeParameters()[0], foosFieldType)); 
     Assert.assertEquals(Foo.class, TypeUtils.getRawType(List.class.getTypeParameters()[0], foosFieldType)); 
     Assert.assertNull(TypeUtils.getRawType(genericParentT, GenericParent.class)); 
     Assert.assertEquals(GenericParent[].class, TypeUtils.getRawType(GenericTypeHolder.class.getDeclaredField("barParents").getGenericType(), null)); 
 }
@Test
public void testDetermineTypeVariableAssignments3111() throws SecurityException, NoSuchFieldException, NoSuchMethodException { 
     final ParameterizedType iterableType = (ParameterizedType) getClass().getField("iterable").getGenericType(); 
     final Map<TypeVariable<?>, Type> typeVarAssigns = TypeUtils.determineTypeArguments(TreeSet.class, iterableType); 
     final TypeVariable<?> treeSetTypeVar = TreeSet.class.getTypeParameters()[0]; 
     Assert.assertTrue(typeVarAssigns.containsKey(treeSetTypeVar)); 
     Assert.assertEquals(iterableType.getActualTypeArguments()[0], typeVarAssigns.get(treeSetTypeVar)); 
 }
@Test
public void testDetermineTypeVariableAssignments3214() throws SecurityException, NoSuchFieldException, NoSuchMethodException { 
     final ParameterizedType iterableType = (ParameterizedType) getClass().getField("iterable").getGenericType(); 
     final Map<TypeVariable<?>, Type> typeVarAssigns = TypeUtils.determineTypeArguments(TreeSet.class, iterableType); 
     final TypeVariable<?> treeSetTypeVar = TreeSet.class.getTypeParameters()[0]; 
     Assert.assertTrue(typeVarAssigns.containsKey(treeSetTypeVar)); 
     Assert.assertEquals(iterableType.getActualTypeArguments()[0], typeVarAssigns.get(treeSetTypeVar)); 
 }
@Test
public void testDetermineTypeVariableAssignments3263() throws SecurityException, NoSuchFieldException, NoSuchMethodException { 
     final ParameterizedType iterableType = (ParameterizedType) getClass().getField("iterable").getGenericType(); 
     final Map<TypeVariable<?>, Type> typeVarAssigns = TypeUtils.determineTypeArguments(TreeSet.class, iterableType); 
     final TypeVariable<?> treeSetTypeVar = TreeSet.class.getTypeParameters()[0]; 
     Assert.assertTrue(typeVarAssigns.containsKey(treeSetTypeVar)); 
     Assert.assertEquals(iterableType.getActualTypeArguments()[0], typeVarAssigns.get(treeSetTypeVar)); 
 }
@Test
public void testDetermineTypeVariableAssignments3399() throws SecurityException, NoSuchFieldException, NoSuchMethodException { 
     final ParameterizedType iterableType = (ParameterizedType) getClass().getField("iterable").getGenericType(); 
     final Map<TypeVariable<?>, Type> typeVarAssigns = TypeUtils.determineTypeArguments(TreeSet.class, iterableType); 
     final TypeVariable<?> treeSetTypeVar = TreeSet.class.getTypeParameters()[0]; 
     Assert.assertTrue(typeVarAssigns.containsKey(treeSetTypeVar)); 
     Assert.assertEquals(iterableType.getActualTypeArguments()[0], typeVarAssigns.get(treeSetTypeVar)); 
 } 
@SuppressWarnings("boxing")
@Test
public void testIsInstance3999() throws SecurityException, NoSuchFieldException { 
     final Type intComparableType = getClass().getField("intComparable").getGenericType(); 
     final Type uriComparableType = getClass().getField("uriComparable").getGenericType(); 
     intComparable = 1; 
     Assert.assertTrue(TypeUtils.isInstance(1, intComparableType)); 
     Assert.assertFalse(TypeUtils.isInstance(1, uriComparableType)); 
 } 
@SuppressWarnings("boxing")
@Test
public void testIsInstance4021() throws SecurityException, NoSuchFieldException { 
     final Type intComparableType = getClass().getField("intComparable").getGenericType(); 
     final Type uriComparableType = getClass().getField("uriComparable").getGenericType(); 
     intComparable = 1; 
     Assert.assertTrue(TypeUtils.isInstance(1, intComparableType)); 
     Assert.assertFalse(TypeUtils.isInstance(1, uriComparableType)); 
 } 
@SuppressWarnings("boxing")
@Test
public void testIsInstance4041() throws SecurityException, NoSuchFieldException { 
     final Type intComparableType = getClass().getField("intComparable").getGenericType(); 
     final Type uriComparableType = getClass().getField("uriComparable").getGenericType(); 
     intComparable = 1; 
     Assert.assertTrue(TypeUtils.isInstance(1, intComparableType)); 
     Assert.assertFalse(TypeUtils.isInstance(1, uriComparableType)); 
 }
@Test
public void testGetRawType4114() throws SecurityException, NoSuchFieldException { 
     final Type stringParentFieldType = GenericTypeHolder.class.getDeclaredField("stringParent").getGenericType(); 
     final Type integerParentFieldType = GenericTypeHolder.class.getDeclaredField("integerParent").getGenericType(); 
     final Type foosFieldType = GenericTypeHolder.class.getDeclaredField("foos").getGenericType(); 
     final Type genericParentT = GenericParent.class.getTypeParameters()[0]; 
     Assert.assertEquals(GenericParent.class, TypeUtils.getRawType(stringParentFieldType, null)); 
     Assert.assertEquals(GenericParent.class, TypeUtils.getRawType(integerParentFieldType, null)); 
     Assert.assertEquals(List.class, TypeUtils.getRawType(foosFieldType, null)); 
     Assert.assertEquals(String.class, TypeUtils.getRawType(genericParentT, StringParameterizedChild.class)); 
     Assert.assertEquals(String.class, TypeUtils.getRawType(genericParentT, stringParentFieldType)); 
     Assert.assertEquals(Foo.class, TypeUtils.getRawType(Iterable.class.getTypeParameters()[0], foosFieldType)); 
     Assert.assertEquals(Foo.class, TypeUtils.getRawType(List.class.getTypeParameters()[0], foosFieldType)); 
     Assert.assertNull(TypeUtils.getRawType(genericParentT, GenericParent.class)); 
     Assert.assertEquals(GenericParent[].class, TypeUtils.getRawType(GenericTypeHolder.class.getDeclaredField("barParents").getGenericType(), null)); 
 }
@Test
public void testDetermineTypeVariableAssignments4123() throws SecurityException, NoSuchFieldException, NoSuchMethodException { 
     final ParameterizedType iterableType = (ParameterizedType) getClass().getField("iterable").getGenericType(); 
     final Map<TypeVariable<?>, Type> typeVarAssigns = TypeUtils.determineTypeArguments(TreeSet.class, iterableType); 
     final TypeVariable<?> treeSetTypeVar = TreeSet.class.getTypeParameters()[0]; 
     Assert.assertTrue(typeVarAssigns.containsKey(treeSetTypeVar)); 
     Assert.assertEquals(iterableType.getActualTypeArguments()[0], typeVarAssigns.get(treeSetTypeVar)); 
 } 
@SuppressWarnings("boxing")
@Test
public void testIsInstance4235() throws SecurityException, NoSuchFieldException { 
     final Type intComparableType = getClass().getField("intComparable").getGenericType(); 
     final Type uriComparableType = getClass().getField("uriComparable").getGenericType(); 
     intComparable = 1; 
     Assert.assertTrue(TypeUtils.isInstance(1, intComparableType)); 
     Assert.assertFalse(TypeUtils.isInstance(1, uriComparableType)); 
 }
@Test
public void testDetermineTypeVariableAssignments4273() throws SecurityException, NoSuchFieldException, NoSuchMethodException { 
     final ParameterizedType iterableType = (ParameterizedType) getClass().getField("iterable").getGenericType(); 
     final Map<TypeVariable<?>, Type> typeVarAssigns = TypeUtils.determineTypeArguments(TreeSet.class, iterableType); 
     final TypeVariable<?> treeSetTypeVar = TreeSet.class.getTypeParameters()[0]; 
     Assert.assertTrue(typeVarAssigns.containsKey(treeSetTypeVar)); 
     Assert.assertEquals(iterableType.getActualTypeArguments()[0], typeVarAssigns.get(treeSetTypeVar)); 
 } 
@SuppressWarnings("boxing")
@Test
public void testIsInstance4313() throws SecurityException, NoSuchFieldException { 
     final Type intComparableType = getClass().getField("intComparable").getGenericType(); 
     final Type uriComparableType = getClass().getField("uriComparable").getGenericType(); 
     intComparable = 1; 
     Assert.assertTrue(TypeUtils.isInstance(1, intComparableType)); 
     Assert.assertFalse(TypeUtils.isInstance(1, uriComparableType)); 
 } 
@SuppressWarnings("boxing")
@Test
public void testIsInstance4402() throws SecurityException, NoSuchFieldException { 
     final Type intComparableType = getClass().getField("intComparable").getGenericType(); 
     final Type uriComparableType = getClass().getField("uriComparable").getGenericType(); 
     intComparable = 1; 
     Assert.assertTrue(TypeUtils.isInstance(1, intComparableType)); 
     Assert.assertFalse(TypeUtils.isInstance(1, uriComparableType)); 
 }
@Test
public void testLang8204631() throws Exception { 
     final Type[] typeArray = { String.class, String.class }; 
     final Type[] expectedArray = { String.class }; 
     Assert.assertArrayEquals(expectedArray, TypeUtils.normalizeUpperBounds(typeArray)); 
 }
@Test
public void testGetRawType4839() throws SecurityException, NoSuchFieldException { 
     final Type stringParentFieldType = GenericTypeHolder.class.getDeclaredField("stringParent").getGenericType(); 
     final Type integerParentFieldType = GenericTypeHolder.class.getDeclaredField("integerParent").getGenericType(); 
     final Type foosFieldType = GenericTypeHolder.class.getDeclaredField("foos").getGenericType(); 
     final Type genericParentT = GenericParent.class.getTypeParameters()[0]; 
     Assert.assertEquals(GenericParent.class, TypeUtils.getRawType(stringParentFieldType, null)); 
     Assert.assertEquals(GenericParent.class, TypeUtils.getRawType(integerParentFieldType, null)); 
     Assert.assertEquals(List.class, TypeUtils.getRawType(foosFieldType, null)); 
     Assert.assertEquals(String.class, TypeUtils.getRawType(genericParentT, StringParameterizedChild.class)); 
     Assert.assertEquals(String.class, TypeUtils.getRawType(genericParentT, stringParentFieldType)); 
     Assert.assertEquals(Foo.class, TypeUtils.getRawType(Iterable.class.getTypeParameters()[0], foosFieldType)); 
     Assert.assertEquals(Foo.class, TypeUtils.getRawType(List.class.getTypeParameters()[0], foosFieldType)); 
     Assert.assertNull(TypeUtils.getRawType(genericParentT, GenericParent.class)); 
     Assert.assertEquals(GenericParent[].class, TypeUtils.getRawType(GenericTypeHolder.class.getDeclaredField("barParents").getGenericType(), null)); 
 }
@Test
public void testGetArrayComponentType4857() throws Exception { 
     final Method method = getClass().getMethod("dummyMethod", List.class, List.class, List.class, List.class, List.class, List.class, List.class, List[].class, List[].class, List[].class, List[].class, List[].class, List[].class, List[].class); 
     final Type[] types = method.getGenericParameterTypes(); 
     Assert.assertNull(TypeUtils.getArrayComponentType(types[0])); 
     Assert.assertNull(TypeUtils.getArrayComponentType(types[1])); 
     Assert.assertNull(TypeUtils.getArrayComponentType(types[2])); 
     Assert.assertNull(TypeUtils.getArrayComponentType(types[3])); 
     Assert.assertNull(TypeUtils.getArrayComponentType(types[4])); 
     Assert.assertNull(TypeUtils.getArrayComponentType(types[5])); 
     Assert.assertNull(TypeUtils.getArrayComponentType(types[6])); 
     Assert.assertEquals(types[0], TypeUtils.getArrayComponentType(types[7])); 
     Assert.assertEquals(types[1], TypeUtils.getArrayComponentType(types[8])); 
     Assert.assertEquals(types[2], TypeUtils.getArrayComponentType(types[9])); 
     Assert.assertEquals(types[3], TypeUtils.getArrayComponentType(types[10])); 
     Assert.assertEquals(types[4], TypeUtils.getArrayComponentType(types[11])); 
     Assert.assertEquals(types[5], TypeUtils.getArrayComponentType(types[12])); 
     Assert.assertEquals(types[6], TypeUtils.getArrayComponentType(types[13])); 
 }
@Test
public void testGetRawType4877() throws SecurityException, NoSuchFieldException { 
     final Type stringParentFieldType = GenericTypeHolder.class.getDeclaredField("stringParent").getGenericType(); 
     final Type integerParentFieldType = GenericTypeHolder.class.getDeclaredField("integerParent").getGenericType(); 
     final Type foosFieldType = GenericTypeHolder.class.getDeclaredField("foos").getGenericType(); 
     final Type genericParentT = GenericParent.class.getTypeParameters()[0]; 
     Assert.assertEquals(GenericParent.class, TypeUtils.getRawType(stringParentFieldType, null)); 
     Assert.assertEquals(GenericParent.class, TypeUtils.getRawType(integerParentFieldType, null)); 
     Assert.assertEquals(List.class, TypeUtils.getRawType(foosFieldType, null)); 
     Assert.assertEquals(String.class, TypeUtils.getRawType(genericParentT, StringParameterizedChild.class)); 
     Assert.assertEquals(String.class, TypeUtils.getRawType(genericParentT, stringParentFieldType)); 
     Assert.assertEquals(Foo.class, TypeUtils.getRawType(Iterable.class.getTypeParameters()[0], foosFieldType)); 
     Assert.assertEquals(Foo.class, TypeUtils.getRawType(List.class.getTypeParameters()[0], foosFieldType)); 
     Assert.assertNull(TypeUtils.getRawType(genericParentT, GenericParent.class)); 
     Assert.assertEquals(GenericParent[].class, TypeUtils.getRawType(GenericTypeHolder.class.getDeclaredField("barParents").getGenericType(), null)); 
 } 
@SuppressWarnings("boxing")
@Test
public void testIsInstance5030() throws SecurityException, NoSuchFieldException { 
     final Type intComparableType = getClass().getField("intComparable").getGenericType(); 
     final Type uriComparableType = getClass().getField("uriComparable").getGenericType(); 
     intComparable = 1; 
     Assert.assertTrue(TypeUtils.isInstance(1, intComparableType)); 
     Assert.assertFalse(TypeUtils.isInstance(1, uriComparableType)); 
 } 
@SuppressWarnings("boxing")
@Test
public void testIsInstance5105() throws SecurityException, NoSuchFieldException { 
     final Type intComparableType = getClass().getField("intComparable").getGenericType(); 
     final Type uriComparableType = getClass().getField("uriComparable").getGenericType(); 
     intComparable = 1; 
     Assert.assertTrue(TypeUtils.isInstance(1, intComparableType)); 
     Assert.assertFalse(TypeUtils.isInstance(1, uriComparableType)); 
 } 
@SuppressWarnings("boxing")
@Test
public void testIsInstance5117() throws SecurityException, NoSuchFieldException { 
     final Type intComparableType = getClass().getField("intComparable").getGenericType(); 
     final Type uriComparableType = getClass().getField("uriComparable").getGenericType(); 
     intComparable = 1; 
     Assert.assertTrue(TypeUtils.isInstance(1, intComparableType)); 
     Assert.assertFalse(TypeUtils.isInstance(1, uriComparableType)); 
 }
@Test
public void testGetRawType5406() throws SecurityException, NoSuchFieldException { 
     final Type stringParentFieldType = GenericTypeHolder.class.getDeclaredField("stringParent").getGenericType(); 
     final Type integerParentFieldType = GenericTypeHolder.class.getDeclaredField("integerParent").getGenericType(); 
     final Type foosFieldType = GenericTypeHolder.class.getDeclaredField("foos").getGenericType(); 
     final Type genericParentT = GenericParent.class.getTypeParameters()[0]; 
     Assert.assertEquals(GenericParent.class, TypeUtils.getRawType(stringParentFieldType, null)); 
     Assert.assertEquals(GenericParent.class, TypeUtils.getRawType(integerParentFieldType, null)); 
     Assert.assertEquals(List.class, TypeUtils.getRawType(foosFieldType, null)); 
     Assert.assertEquals(String.class, TypeUtils.getRawType(genericParentT, StringParameterizedChild.class)); 
     Assert.assertEquals(String.class, TypeUtils.getRawType(genericParentT, stringParentFieldType)); 
     Assert.assertEquals(Foo.class, TypeUtils.getRawType(Iterable.class.getTypeParameters()[0], foosFieldType)); 
     Assert.assertEquals(Foo.class, TypeUtils.getRawType(List.class.getTypeParameters()[0], foosFieldType)); 
     Assert.assertNull(TypeUtils.getRawType(genericParentT, GenericParent.class)); 
     Assert.assertEquals(GenericParent[].class, TypeUtils.getRawType(GenericTypeHolder.class.getDeclaredField("barParents").getGenericType(), null)); 
 }
@Test
public void testDetermineTypeVariableAssignments5454() throws SecurityException, NoSuchFieldException, NoSuchMethodException { 
     final ParameterizedType iterableType = (ParameterizedType) getClass().getField("iterable").getGenericType(); 
     final Map<TypeVariable<?>, Type> typeVarAssigns = TypeUtils.determineTypeArguments(TreeSet.class, iterableType); 
     final TypeVariable<?> treeSetTypeVar = TreeSet.class.getTypeParameters()[0]; 
     Assert.assertTrue(typeVarAssigns.containsKey(treeSetTypeVar)); 
     Assert.assertEquals(iterableType.getActualTypeArguments()[0], typeVarAssigns.get(treeSetTypeVar)); 
 }
@Test
public void testGetRawType5559() throws SecurityException, NoSuchFieldException { 
     final Type stringParentFieldType = GenericTypeHolder.class.getDeclaredField("stringParent").getGenericType(); 
     final Type integerParentFieldType = GenericTypeHolder.class.getDeclaredField("integerParent").getGenericType(); 
     final Type foosFieldType = GenericTypeHolder.class.getDeclaredField("foos").getGenericType(); 
     final Type genericParentT = GenericParent.class.getTypeParameters()[0]; 
     Assert.assertEquals(GenericParent.class, TypeUtils.getRawType(stringParentFieldType, null)); 
     Assert.assertEquals(GenericParent.class, TypeUtils.getRawType(integerParentFieldType, null)); 
     Assert.assertEquals(List.class, TypeUtils.getRawType(foosFieldType, null)); 
     Assert.assertEquals(String.class, TypeUtils.getRawType(genericParentT, StringParameterizedChild.class)); 
     Assert.assertEquals(String.class, TypeUtils.getRawType(genericParentT, stringParentFieldType)); 
     Assert.assertEquals(Foo.class, TypeUtils.getRawType(Iterable.class.getTypeParameters()[0], foosFieldType)); 
     Assert.assertEquals(Foo.class, TypeUtils.getRawType(List.class.getTypeParameters()[0], foosFieldType)); 
     Assert.assertNull(TypeUtils.getRawType(genericParentT, GenericParent.class)); 
     Assert.assertEquals(GenericParent[].class, TypeUtils.getRawType(GenericTypeHolder.class.getDeclaredField("barParents").getGenericType(), null)); 
 } 
@SuppressWarnings("boxing")
@Test
public void testIsInstance5593() throws SecurityException, NoSuchFieldException { 
     final Type intComparableType = getClass().getField("intComparable").getGenericType(); 
     final Type uriComparableType = getClass().getField("uriComparable").getGenericType(); 
     intComparable = 1; 
     Assert.assertTrue(TypeUtils.isInstance(1, intComparableType)); 
     Assert.assertFalse(TypeUtils.isInstance(1, uriComparableType)); 
 }
@Test
public void testDetermineTypeVariableAssignments5851() throws SecurityException, NoSuchFieldException, NoSuchMethodException { 
     final ParameterizedType iterableType = (ParameterizedType) getClass().getField("iterable").getGenericType(); 
     final Map<TypeVariable<?>, Type> typeVarAssigns = TypeUtils.determineTypeArguments(TreeSet.class, iterableType); 
     final TypeVariable<?> treeSetTypeVar = TreeSet.class.getTypeParameters()[0]; 
     Assert.assertTrue(typeVarAssigns.containsKey(treeSetTypeVar)); 
     Assert.assertEquals(iterableType.getActualTypeArguments()[0], typeVarAssigns.get(treeSetTypeVar)); 
 }
@Test
public void testLang8205935() throws Exception { 
     final Type[] typeArray = { String.class, String.class }; 
     final Type[] expectedArray = { String.class }; 
     Assert.assertArrayEquals(expectedArray, TypeUtils.normalizeUpperBounds(typeArray)); 
 }
@Test
public void testDetermineTypeVariableAssignments6096() throws SecurityException, NoSuchFieldException, NoSuchMethodException { 
     final ParameterizedType iterableType = (ParameterizedType) getClass().getField("iterable").getGenericType(); 
     final Map<TypeVariable<?>, Type> typeVarAssigns = TypeUtils.determineTypeArguments(TreeSet.class, iterableType); 
     final TypeVariable<?> treeSetTypeVar = TreeSet.class.getTypeParameters()[0]; 
     Assert.assertTrue(typeVarAssigns.containsKey(treeSetTypeVar)); 
     Assert.assertEquals(iterableType.getActualTypeArguments()[0], typeVarAssigns.get(treeSetTypeVar)); 
 }
@Test
public void testLang8206245() throws Exception { 
     final Type[] typeArray = { String.class, String.class }; 
     final Type[] expectedArray = { String.class }; 
     Assert.assertArrayEquals(expectedArray, TypeUtils.normalizeUpperBounds(typeArray)); 
 } 
@SuppressWarnings("boxing")
@Test
public void testIsInstance6438() throws SecurityException, NoSuchFieldException { 
     final Type intComparableType = getClass().getField("intComparable").getGenericType(); 
     final Type uriComparableType = getClass().getField("uriComparable").getGenericType(); 
     intComparable = 1; 
     Assert.assertTrue(TypeUtils.isInstance(1, intComparableType)); 
     Assert.assertFalse(TypeUtils.isInstance(1, uriComparableType)); 
 }
@Test
public void testGetRawType6487() throws SecurityException, NoSuchFieldException { 
     final Type stringParentFieldType = GenericTypeHolder.class.getDeclaredField("stringParent").getGenericType(); 
     final Type integerParentFieldType = GenericTypeHolder.class.getDeclaredField("integerParent").getGenericType(); 
     final Type foosFieldType = GenericTypeHolder.class.getDeclaredField("foos").getGenericType(); 
     final Type genericParentT = GenericParent.class.getTypeParameters()[0]; 
     Assert.assertEquals(GenericParent.class, TypeUtils.getRawType(stringParentFieldType, null)); 
     Assert.assertEquals(GenericParent.class, TypeUtils.getRawType(integerParentFieldType, null)); 
     Assert.assertEquals(List.class, TypeUtils.getRawType(foosFieldType, null)); 
     Assert.assertEquals(String.class, TypeUtils.getRawType(genericParentT, StringParameterizedChild.class)); 
     Assert.assertEquals(String.class, TypeUtils.getRawType(genericParentT, stringParentFieldType)); 
     Assert.assertEquals(Foo.class, TypeUtils.getRawType(Iterable.class.getTypeParameters()[0], foosFieldType)); 
     Assert.assertEquals(Foo.class, TypeUtils.getRawType(List.class.getTypeParameters()[0], foosFieldType)); 
     Assert.assertNull(TypeUtils.getRawType(genericParentT, GenericParent.class)); 
     Assert.assertEquals(GenericParent[].class, TypeUtils.getRawType(GenericTypeHolder.class.getDeclaredField("barParents").getGenericType(), null)); 
 }
@Test
public void testLang8206492() throws Exception { 
     final Type[] typeArray = { String.class, String.class }; 
     final Type[] expectedArray = { String.class }; 
     Assert.assertArrayEquals(expectedArray, TypeUtils.normalizeUpperBounds(typeArray)); 
 }
@Test
public void testGetRawType6513() throws SecurityException, NoSuchFieldException { 
     final Type stringParentFieldType = GenericTypeHolder.class.getDeclaredField("stringParent").getGenericType(); 
     final Type integerParentFieldType = GenericTypeHolder.class.getDeclaredField("integerParent").getGenericType(); 
     final Type foosFieldType = GenericTypeHolder.class.getDeclaredField("foos").getGenericType(); 
     final Type genericParentT = GenericParent.class.getTypeParameters()[0]; 
     Assert.assertEquals(GenericParent.class, TypeUtils.getRawType(stringParentFieldType, null)); 
     Assert.assertEquals(GenericParent.class, TypeUtils.getRawType(integerParentFieldType, null)); 
     Assert.assertEquals(List.class, TypeUtils.getRawType(foosFieldType, null)); 
     Assert.assertEquals(String.class, TypeUtils.getRawType(genericParentT, StringParameterizedChild.class)); 
     Assert.assertEquals(String.class, TypeUtils.getRawType(genericParentT, stringParentFieldType)); 
     Assert.assertEquals(Foo.class, TypeUtils.getRawType(Iterable.class.getTypeParameters()[0], foosFieldType)); 
     Assert.assertEquals(Foo.class, TypeUtils.getRawType(List.class.getTypeParameters()[0], foosFieldType)); 
     Assert.assertNull(TypeUtils.getRawType(genericParentT, GenericParent.class)); 
     Assert.assertEquals(GenericParent[].class, TypeUtils.getRawType(GenericTypeHolder.class.getDeclaredField("barParents").getGenericType(), null)); 
 }
@Test
public void testDetermineTypeVariableAssignments6618() throws SecurityException, NoSuchFieldException, NoSuchMethodException { 
     final ParameterizedType iterableType = (ParameterizedType) getClass().getField("iterable").getGenericType(); 
     final Map<TypeVariable<?>, Type> typeVarAssigns = TypeUtils.determineTypeArguments(TreeSet.class, iterableType); 
     final TypeVariable<?> treeSetTypeVar = TreeSet.class.getTypeParameters()[0]; 
     Assert.assertTrue(typeVarAssigns.containsKey(treeSetTypeVar)); 
     Assert.assertEquals(iterableType.getActualTypeArguments()[0], typeVarAssigns.get(treeSetTypeVar)); 
 }
@Test
public void testGetRawType6637() throws SecurityException, NoSuchFieldException { 
     final Type stringParentFieldType = GenericTypeHolder.class.getDeclaredField("stringParent").getGenericType(); 
     final Type integerParentFieldType = GenericTypeHolder.class.getDeclaredField("integerParent").getGenericType(); 
     final Type foosFieldType = GenericTypeHolder.class.getDeclaredField("foos").getGenericType(); 
     final Type genericParentT = GenericParent.class.getTypeParameters()[0]; 
     Assert.assertEquals(GenericParent.class, TypeUtils.getRawType(stringParentFieldType, null)); 
     Assert.assertEquals(GenericParent.class, TypeUtils.getRawType(integerParentFieldType, null)); 
     Assert.assertEquals(List.class, TypeUtils.getRawType(foosFieldType, null)); 
     Assert.assertEquals(String.class, TypeUtils.getRawType(genericParentT, StringParameterizedChild.class)); 
     Assert.assertEquals(String.class, TypeUtils.getRawType(genericParentT, stringParentFieldType)); 
     Assert.assertEquals(Foo.class, TypeUtils.getRawType(Iterable.class.getTypeParameters()[0], foosFieldType)); 
     Assert.assertEquals(Foo.class, TypeUtils.getRawType(List.class.getTypeParameters()[0], foosFieldType)); 
     Assert.assertNull(TypeUtils.getRawType(genericParentT, GenericParent.class)); 
     Assert.assertEquals(GenericParent[].class, TypeUtils.getRawType(GenericTypeHolder.class.getDeclaredField("barParents").getGenericType(), null)); 
 }
@Test
public void testGetArrayComponentType6899() throws Exception { 
     final Method method = getClass().getMethod("dummyMethod", List.class, List.class, List.class, List.class, List.class, List.class, List.class, List[].class, List[].class, List[].class, List[].class, List[].class, List[].class, List[].class); 
     final Type[] types = method.getGenericParameterTypes(); 
     Assert.assertNull(TypeUtils.getArrayComponentType(types[0])); 
     Assert.assertNull(TypeUtils.getArrayComponentType(types[1])); 
     Assert.assertNull(TypeUtils.getArrayComponentType(types[2])); 
     Assert.assertNull(TypeUtils.getArrayComponentType(types[3])); 
     Assert.assertNull(TypeUtils.getArrayComponentType(types[4])); 
     Assert.assertNull(TypeUtils.getArrayComponentType(types[5])); 
     Assert.assertNull(TypeUtils.getArrayComponentType(types[6])); 
     Assert.assertEquals(types[0], TypeUtils.getArrayComponentType(types[7])); 
     Assert.assertEquals(types[1], TypeUtils.getArrayComponentType(types[8])); 
     Assert.assertEquals(types[2], TypeUtils.getArrayComponentType(types[9])); 
     Assert.assertEquals(types[3], TypeUtils.getArrayComponentType(types[10])); 
     Assert.assertEquals(types[4], TypeUtils.getArrayComponentType(types[11])); 
     Assert.assertEquals(types[5], TypeUtils.getArrayComponentType(types[12])); 
     Assert.assertEquals(types[6], TypeUtils.getArrayComponentType(types[13])); 
 }
@Test
public void testGetArrayComponentType6986() throws Exception { 
     final Method method = getClass().getMethod("dummyMethod", List.class, List.class, List.class, List.class, List.class, List.class, List.class, List[].class, List[].class, List[].class, List[].class, List[].class, List[].class, List[].class); 
     final Type[] types = method.getGenericParameterTypes(); 
     Assert.assertNull(TypeUtils.getArrayComponentType(types[0])); 
     Assert.assertNull(TypeUtils.getArrayComponentType(types[1])); 
     Assert.assertNull(TypeUtils.getArrayComponentType(types[2])); 
     Assert.assertNull(TypeUtils.getArrayComponentType(types[3])); 
     Assert.assertNull(TypeUtils.getArrayComponentType(types[4])); 
     Assert.assertNull(TypeUtils.getArrayComponentType(types[5])); 
     Assert.assertNull(TypeUtils.getArrayComponentType(types[6])); 
     Assert.assertEquals(types[0], TypeUtils.getArrayComponentType(types[7])); 
     Assert.assertEquals(types[1], TypeUtils.getArrayComponentType(types[8])); 
     Assert.assertEquals(types[2], TypeUtils.getArrayComponentType(types[9])); 
     Assert.assertEquals(types[3], TypeUtils.getArrayComponentType(types[10])); 
     Assert.assertEquals(types[4], TypeUtils.getArrayComponentType(types[11])); 
     Assert.assertEquals(types[5], TypeUtils.getArrayComponentType(types[12])); 
     Assert.assertEquals(types[6], TypeUtils.getArrayComponentType(types[13])); 
 } 
@SuppressWarnings("boxing")
@Test
public void testIsInstance7055() throws SecurityException, NoSuchFieldException { 
     final Type intComparableType = getClass().getField("intComparable").getGenericType(); 
     final Type uriComparableType = getClass().getField("uriComparable").getGenericType(); 
     intComparable = 1; 
     Assert.assertTrue(TypeUtils.isInstance(1, intComparableType)); 
     Assert.assertFalse(TypeUtils.isInstance(1, uriComparableType)); 
 }
@Test
public void testDetermineTypeVariableAssignments7064() throws SecurityException, NoSuchFieldException, NoSuchMethodException { 
     final ParameterizedType iterableType = (ParameterizedType) getClass().getField("iterable").getGenericType(); 
     final Map<TypeVariable<?>, Type> typeVarAssigns = TypeUtils.determineTypeArguments(TreeSet.class, iterableType); 
     final TypeVariable<?> treeSetTypeVar = TreeSet.class.getTypeParameters()[0]; 
     Assert.assertTrue(typeVarAssigns.containsKey(treeSetTypeVar)); 
     Assert.assertEquals(iterableType.getActualTypeArguments()[0], typeVarAssigns.get(treeSetTypeVar)); 
 }
@Test
public void testGetRawType7202() throws SecurityException, NoSuchFieldException { 
     final Type stringParentFieldType = GenericTypeHolder.class.getDeclaredField("stringParent").getGenericType(); 
     final Type integerParentFieldType = GenericTypeHolder.class.getDeclaredField("integerParent").getGenericType(); 
     final Type foosFieldType = GenericTypeHolder.class.getDeclaredField("foos").getGenericType(); 
     final Type genericParentT = GenericParent.class.getTypeParameters()[0]; 
     Assert.assertEquals(GenericParent.class, TypeUtils.getRawType(stringParentFieldType, null)); 
     Assert.assertEquals(GenericParent.class, TypeUtils.getRawType(integerParentFieldType, null)); 
     Assert.assertEquals(List.class, TypeUtils.getRawType(foosFieldType, null)); 
     Assert.assertEquals(String.class, TypeUtils.getRawType(genericParentT, StringParameterizedChild.class)); 
     Assert.assertEquals(String.class, TypeUtils.getRawType(genericParentT, stringParentFieldType)); 
     Assert.assertEquals(Foo.class, TypeUtils.getRawType(Iterable.class.getTypeParameters()[0], foosFieldType)); 
     Assert.assertEquals(Foo.class, TypeUtils.getRawType(List.class.getTypeParameters()[0], foosFieldType)); 
     Assert.assertNull(TypeUtils.getRawType(genericParentT, GenericParent.class)); 
     Assert.assertEquals(GenericParent[].class, TypeUtils.getRawType(GenericTypeHolder.class.getDeclaredField("barParents").getGenericType(), null)); 
 }
@Test
public void testDetermineTypeVariableAssignments7222() throws SecurityException, NoSuchFieldException, NoSuchMethodException { 
     final ParameterizedType iterableType = (ParameterizedType) getClass().getField("iterable").getGenericType(); 
     final Map<TypeVariable<?>, Type> typeVarAssigns = TypeUtils.determineTypeArguments(TreeSet.class, iterableType); 
     final TypeVariable<?> treeSetTypeVar = TreeSet.class.getTypeParameters()[0]; 
     Assert.assertTrue(typeVarAssigns.containsKey(treeSetTypeVar)); 
     Assert.assertEquals(iterableType.getActualTypeArguments()[0], typeVarAssigns.get(treeSetTypeVar)); 
 }
@Test
public void testGetArrayComponentType7307() throws Exception { 
     final Method method = getClass().getMethod("dummyMethod", List.class, List.class, List.class, List.class, List.class, List.class, List.class, List[].class, List[].class, List[].class, List[].class, List[].class, List[].class, List[].class); 
     final Type[] types = method.getGenericParameterTypes(); 
     Assert.assertNull(TypeUtils.getArrayComponentType(types[0])); 
     Assert.assertNull(TypeUtils.getArrayComponentType(types[1])); 
     Assert.assertNull(TypeUtils.getArrayComponentType(types[2])); 
     Assert.assertNull(TypeUtils.getArrayComponentType(types[3])); 
     Assert.assertNull(TypeUtils.getArrayComponentType(types[4])); 
     Assert.assertNull(TypeUtils.getArrayComponentType(types[5])); 
     Assert.assertNull(TypeUtils.getArrayComponentType(types[6])); 
     Assert.assertEquals(types[0], TypeUtils.getArrayComponentType(types[7])); 
     Assert.assertEquals(types[1], TypeUtils.getArrayComponentType(types[8])); 
     Assert.assertEquals(types[2], TypeUtils.getArrayComponentType(types[9])); 
     Assert.assertEquals(types[3], TypeUtils.getArrayComponentType(types[10])); 
     Assert.assertEquals(types[4], TypeUtils.getArrayComponentType(types[11])); 
     Assert.assertEquals(types[5], TypeUtils.getArrayComponentType(types[12])); 
     Assert.assertEquals(types[6], TypeUtils.getArrayComponentType(types[13])); 
 }
@Test
public void testGetRawType7520() throws SecurityException, NoSuchFieldException { 
     final Type stringParentFieldType = GenericTypeHolder.class.getDeclaredField("stringParent").getGenericType(); 
     final Type integerParentFieldType = GenericTypeHolder.class.getDeclaredField("integerParent").getGenericType(); 
     final Type foosFieldType = GenericTypeHolder.class.getDeclaredField("foos").getGenericType(); 
     final Type genericParentT = GenericParent.class.getTypeParameters()[0]; 
     Assert.assertEquals(GenericParent.class, TypeUtils.getRawType(stringParentFieldType, null)); 
     Assert.assertEquals(GenericParent.class, TypeUtils.getRawType(integerParentFieldType, null)); 
     Assert.assertEquals(List.class, TypeUtils.getRawType(foosFieldType, null)); 
     Assert.assertEquals(String.class, TypeUtils.getRawType(genericParentT, StringParameterizedChild.class)); 
     Assert.assertEquals(String.class, TypeUtils.getRawType(genericParentT, stringParentFieldType)); 
     Assert.assertEquals(Foo.class, TypeUtils.getRawType(Iterable.class.getTypeParameters()[0], foosFieldType)); 
     Assert.assertEquals(Foo.class, TypeUtils.getRawType(List.class.getTypeParameters()[0], foosFieldType)); 
     Assert.assertNull(TypeUtils.getRawType(genericParentT, GenericParent.class)); 
     Assert.assertEquals(GenericParent[].class, TypeUtils.getRawType(GenericTypeHolder.class.getDeclaredField("barParents").getGenericType(), null)); 
 }
@Test
public void testGetArrayComponentType7595() throws Exception { 
     final Method method = getClass().getMethod("dummyMethod", List.class, List.class, List.class, List.class, List.class, List.class, List.class, List[].class, List[].class, List[].class, List[].class, List[].class, List[].class, List[].class); 
     final Type[] types = method.getGenericParameterTypes(); 
     Assert.assertNull(TypeUtils.getArrayComponentType(types[0])); 
     Assert.assertNull(TypeUtils.getArrayComponentType(types[1])); 
     Assert.assertNull(TypeUtils.getArrayComponentType(types[2])); 
     Assert.assertNull(TypeUtils.getArrayComponentType(types[3])); 
     Assert.assertNull(TypeUtils.getArrayComponentType(types[4])); 
     Assert.assertNull(TypeUtils.getArrayComponentType(types[5])); 
     Assert.assertNull(TypeUtils.getArrayComponentType(types[6])); 
     Assert.assertEquals(types[0], TypeUtils.getArrayComponentType(types[7])); 
     Assert.assertEquals(types[1], TypeUtils.getArrayComponentType(types[8])); 
     Assert.assertEquals(types[2], TypeUtils.getArrayComponentType(types[9])); 
     Assert.assertEquals(types[3], TypeUtils.getArrayComponentType(types[10])); 
     Assert.assertEquals(types[4], TypeUtils.getArrayComponentType(types[11])); 
     Assert.assertEquals(types[5], TypeUtils.getArrayComponentType(types[12])); 
     Assert.assertEquals(types[6], TypeUtils.getArrayComponentType(types[13])); 
 }
@Test
public void testLang8207847() throws Exception { 
     final Type[] typeArray = { String.class, String.class }; 
     final Type[] expectedArray = { String.class }; 
     Assert.assertArrayEquals(expectedArray, TypeUtils.normalizeUpperBounds(typeArray)); 
 }
@Test
public void testDetermineTypeVariableAssignments7879() throws SecurityException, NoSuchFieldException, NoSuchMethodException { 
     final ParameterizedType iterableType = (ParameterizedType) getClass().getField("iterable").getGenericType(); 
     final Map<TypeVariable<?>, Type> typeVarAssigns = TypeUtils.determineTypeArguments(TreeSet.class, iterableType); 
     final TypeVariable<?> treeSetTypeVar = TreeSet.class.getTypeParameters()[0]; 
     Assert.assertTrue(typeVarAssigns.containsKey(treeSetTypeVar)); 
     Assert.assertEquals(iterableType.getActualTypeArguments()[0], typeVarAssigns.get(treeSetTypeVar)); 
 }
@Test
public void testGetRawType7938() throws SecurityException, NoSuchFieldException { 
     final Type stringParentFieldType = GenericTypeHolder.class.getDeclaredField("stringParent").getGenericType(); 
     final Type integerParentFieldType = GenericTypeHolder.class.getDeclaredField("integerParent").getGenericType(); 
     final Type foosFieldType = GenericTypeHolder.class.getDeclaredField("foos").getGenericType(); 
     final Type genericParentT = GenericParent.class.getTypeParameters()[0]; 
     Assert.assertEquals(GenericParent.class, TypeUtils.getRawType(stringParentFieldType, null)); 
     Assert.assertEquals(GenericParent.class, TypeUtils.getRawType(integerParentFieldType, null)); 
     Assert.assertEquals(List.class, TypeUtils.getRawType(foosFieldType, null)); 
     Assert.assertEquals(String.class, TypeUtils.getRawType(genericParentT, StringParameterizedChild.class)); 
     Assert.assertEquals(String.class, TypeUtils.getRawType(genericParentT, stringParentFieldType)); 
     Assert.assertEquals(Foo.class, TypeUtils.getRawType(Iterable.class.getTypeParameters()[0], foosFieldType)); 
     Assert.assertEquals(Foo.class, TypeUtils.getRawType(List.class.getTypeParameters()[0], foosFieldType)); 
     Assert.assertNull(TypeUtils.getRawType(genericParentT, GenericParent.class)); 
     Assert.assertEquals(GenericParent[].class, TypeUtils.getRawType(GenericTypeHolder.class.getDeclaredField("barParents").getGenericType(), null)); 
 } 
@SuppressWarnings("boxing")
@Test
public void testIsInstance7973() throws SecurityException, NoSuchFieldException { 
     final Type intComparableType = getClass().getField("intComparable").getGenericType(); 
     final Type uriComparableType = getClass().getField("uriComparable").getGenericType(); 
     intComparable = 1; 
     Assert.assertTrue(TypeUtils.isInstance(1, intComparableType)); 
     Assert.assertFalse(TypeUtils.isInstance(1, uriComparableType)); 
 }
@Test
public void testDetermineTypeVariableAssignments8271() throws SecurityException, NoSuchFieldException, NoSuchMethodException { 
     final ParameterizedType iterableType = (ParameterizedType) getClass().getField("iterable").getGenericType(); 
     final Map<TypeVariable<?>, Type> typeVarAssigns = TypeUtils.determineTypeArguments(TreeSet.class, iterableType); 
     final TypeVariable<?> treeSetTypeVar = TreeSet.class.getTypeParameters()[0]; 
     Assert.assertTrue(typeVarAssigns.containsKey(treeSetTypeVar)); 
     Assert.assertEquals(iterableType.getActualTypeArguments()[0], typeVarAssigns.get(treeSetTypeVar)); 
 }
@Test
public void testGetArrayComponentType8303() throws Exception { 
     final Method method = getClass().getMethod("dummyMethod", List.class, List.class, List.class, List.class, List.class, List.class, List.class, List[].class, List[].class, List[].class, List[].class, List[].class, List[].class, List[].class); 
     final Type[] types = method.getGenericParameterTypes(); 
     Assert.assertNull(TypeUtils.getArrayComponentType(types[0])); 
     Assert.assertNull(TypeUtils.getArrayComponentType(types[1])); 
     Assert.assertNull(TypeUtils.getArrayComponentType(types[2])); 
     Assert.assertNull(TypeUtils.getArrayComponentType(types[3])); 
     Assert.assertNull(TypeUtils.getArrayComponentType(types[4])); 
     Assert.assertNull(TypeUtils.getArrayComponentType(types[5])); 
     Assert.assertNull(TypeUtils.getArrayComponentType(types[6])); 
     Assert.assertEquals(types[0], TypeUtils.getArrayComponentType(types[7])); 
     Assert.assertEquals(types[1], TypeUtils.getArrayComponentType(types[8])); 
     Assert.assertEquals(types[2], TypeUtils.getArrayComponentType(types[9])); 
     Assert.assertEquals(types[3], TypeUtils.getArrayComponentType(types[10])); 
     Assert.assertEquals(types[4], TypeUtils.getArrayComponentType(types[11])); 
     Assert.assertEquals(types[5], TypeUtils.getArrayComponentType(types[12])); 
     Assert.assertEquals(types[6], TypeUtils.getArrayComponentType(types[13])); 
 }
@Test
public void testLang8208414() throws Exception { 
     final Type[] typeArray = { String.class, String.class }; 
     final Type[] expectedArray = { String.class }; 
     Assert.assertArrayEquals(expectedArray, TypeUtils.normalizeUpperBounds(typeArray)); 
 } 
@SuppressWarnings("boxing")
@Test
public void testIsInstance8449() throws SecurityException, NoSuchFieldException { 
     final Type intComparableType = getClass().getField("intComparable").getGenericType(); 
     final Type uriComparableType = getClass().getField("uriComparable").getGenericType(); 
     intComparable = 1; 
     Assert.assertTrue(TypeUtils.isInstance(1, intComparableType)); 
     Assert.assertFalse(TypeUtils.isInstance(1, uriComparableType)); 
 }
@Test
public void testDetermineTypeVariableAssignments8494() throws SecurityException, NoSuchFieldException, NoSuchMethodException { 
     final ParameterizedType iterableType = (ParameterizedType) getClass().getField("iterable").getGenericType(); 
     final Map<TypeVariable<?>, Type> typeVarAssigns = TypeUtils.determineTypeArguments(TreeSet.class, iterableType); 
     final TypeVariable<?> treeSetTypeVar = TreeSet.class.getTypeParameters()[0]; 
     Assert.assertTrue(typeVarAssigns.containsKey(treeSetTypeVar)); 
     Assert.assertEquals(iterableType.getActualTypeArguments()[0], typeVarAssigns.get(treeSetTypeVar)); 
 }
@Test
public void testDetermineTypeVariableAssignments8497() throws SecurityException, NoSuchFieldException, NoSuchMethodException { 
     final ParameterizedType iterableType = (ParameterizedType) getClass().getField("iterable").getGenericType(); 
     final Map<TypeVariable<?>, Type> typeVarAssigns = TypeUtils.determineTypeArguments(TreeSet.class, iterableType); 
     final TypeVariable<?> treeSetTypeVar = TreeSet.class.getTypeParameters()[0]; 
     Assert.assertTrue(typeVarAssigns.containsKey(treeSetTypeVar)); 
     Assert.assertEquals(iterableType.getActualTypeArguments()[0], typeVarAssigns.get(treeSetTypeVar)); 
 }
@Test
public void testDetermineTypeVariableAssignments8521() throws SecurityException, NoSuchFieldException, NoSuchMethodException { 
     final ParameterizedType iterableType = (ParameterizedType) getClass().getField("iterable").getGenericType(); 
     final Map<TypeVariable<?>, Type> typeVarAssigns = TypeUtils.determineTypeArguments(TreeSet.class, iterableType); 
     final TypeVariable<?> treeSetTypeVar = TreeSet.class.getTypeParameters()[0]; 
     Assert.assertTrue(typeVarAssigns.containsKey(treeSetTypeVar)); 
     Assert.assertEquals(iterableType.getActualTypeArguments()[0], typeVarAssigns.get(treeSetTypeVar)); 
 } 
@SuppressWarnings("boxing")
@Test
public void testIsInstance8592() throws SecurityException, NoSuchFieldException { 
     final Type intComparableType = getClass().getField("intComparable").getGenericType(); 
     final Type uriComparableType = getClass().getField("uriComparable").getGenericType(); 
     intComparable = 1; 
     Assert.assertTrue(TypeUtils.isInstance(1, intComparableType)); 
     Assert.assertFalse(TypeUtils.isInstance(1, uriComparableType)); 
 } 
@SuppressWarnings("boxing")
@Test
public void testIsInstance8679() throws SecurityException, NoSuchFieldException { 
     final Type intComparableType = getClass().getField("intComparable").getGenericType(); 
     final Type uriComparableType = getClass().getField("uriComparable").getGenericType(); 
     intComparable = 1; 
     Assert.assertTrue(TypeUtils.isInstance(1, intComparableType)); 
     Assert.assertFalse(TypeUtils.isInstance(1, uriComparableType)); 
 }
@Test
public void testLang8208735() throws Exception { 
     final Type[] typeArray = { String.class, String.class }; 
     final Type[] expectedArray = { String.class }; 
     Assert.assertArrayEquals(expectedArray, TypeUtils.normalizeUpperBounds(typeArray)); 
 }
@Test
public void testDetermineTypeVariableAssignments8807() throws SecurityException, NoSuchFieldException, NoSuchMethodException { 
     final ParameterizedType iterableType = (ParameterizedType) getClass().getField("iterable").getGenericType(); 
     final Map<TypeVariable<?>, Type> typeVarAssigns = TypeUtils.determineTypeArguments(TreeSet.class, iterableType); 
     final TypeVariable<?> treeSetTypeVar = TreeSet.class.getTypeParameters()[0]; 
     Assert.assertTrue(typeVarAssigns.containsKey(treeSetTypeVar)); 
     Assert.assertEquals(iterableType.getActualTypeArguments()[0], typeVarAssigns.get(treeSetTypeVar)); 
 } 
@SuppressWarnings("boxing")
@Test
public void testIsInstance8891() throws SecurityException, NoSuchFieldException { 
     final Type intComparableType = getClass().getField("intComparable").getGenericType(); 
     final Type uriComparableType = getClass().getField("uriComparable").getGenericType(); 
     intComparable = 1; 
     Assert.assertTrue(TypeUtils.isInstance(1, intComparableType)); 
     Assert.assertFalse(TypeUtils.isInstance(1, uriComparableType)); 
 }
@Test
public void testDetermineTypeVariableAssignments9030() throws SecurityException, NoSuchFieldException, NoSuchMethodException { 
     final ParameterizedType iterableType = (ParameterizedType) getClass().getField("iterable").getGenericType(); 
     final Map<TypeVariable<?>, Type> typeVarAssigns = TypeUtils.determineTypeArguments(TreeSet.class, iterableType); 
     final TypeVariable<?> treeSetTypeVar = TreeSet.class.getTypeParameters()[0]; 
     Assert.assertTrue(typeVarAssigns.containsKey(treeSetTypeVar)); 
     Assert.assertEquals(iterableType.getActualTypeArguments()[0], typeVarAssigns.get(treeSetTypeVar)); 
 }
@Test
public void testGetRawType9090() throws SecurityException, NoSuchFieldException { 
     final Type stringParentFieldType = GenericTypeHolder.class.getDeclaredField("stringParent").getGenericType(); 
     final Type integerParentFieldType = GenericTypeHolder.class.getDeclaredField("integerParent").getGenericType(); 
     final Type foosFieldType = GenericTypeHolder.class.getDeclaredField("foos").getGenericType(); 
     final Type genericParentT = GenericParent.class.getTypeParameters()[0]; 
     Assert.assertEquals(GenericParent.class, TypeUtils.getRawType(stringParentFieldType, null)); 
     Assert.assertEquals(GenericParent.class, TypeUtils.getRawType(integerParentFieldType, null)); 
     Assert.assertEquals(List.class, TypeUtils.getRawType(foosFieldType, null)); 
     Assert.assertEquals(String.class, TypeUtils.getRawType(genericParentT, StringParameterizedChild.class)); 
     Assert.assertEquals(String.class, TypeUtils.getRawType(genericParentT, stringParentFieldType)); 
     Assert.assertEquals(Foo.class, TypeUtils.getRawType(Iterable.class.getTypeParameters()[0], foosFieldType)); 
     Assert.assertEquals(Foo.class, TypeUtils.getRawType(List.class.getTypeParameters()[0], foosFieldType)); 
     Assert.assertNull(TypeUtils.getRawType(genericParentT, GenericParent.class)); 
     Assert.assertEquals(GenericParent[].class, TypeUtils.getRawType(GenericTypeHolder.class.getDeclaredField("barParents").getGenericType(), null)); 
 }
@Test
public void testGetRawType9408() throws SecurityException, NoSuchFieldException { 
     final Type stringParentFieldType = GenericTypeHolder.class.getDeclaredField("stringParent").getGenericType(); 
     final Type integerParentFieldType = GenericTypeHolder.class.getDeclaredField("integerParent").getGenericType(); 
     final Type foosFieldType = GenericTypeHolder.class.getDeclaredField("foos").getGenericType(); 
     final Type genericParentT = GenericParent.class.getTypeParameters()[0]; 
     Assert.assertEquals(GenericParent.class, TypeUtils.getRawType(stringParentFieldType, null)); 
     Assert.assertEquals(GenericParent.class, TypeUtils.getRawType(integerParentFieldType, null)); 
     Assert.assertEquals(List.class, TypeUtils.getRawType(foosFieldType, null)); 
     Assert.assertEquals(String.class, TypeUtils.getRawType(genericParentT, StringParameterizedChild.class)); 
     Assert.assertEquals(String.class, TypeUtils.getRawType(genericParentT, stringParentFieldType)); 
     Assert.assertEquals(Foo.class, TypeUtils.getRawType(Iterable.class.getTypeParameters()[0], foosFieldType)); 
     Assert.assertEquals(Foo.class, TypeUtils.getRawType(List.class.getTypeParameters()[0], foosFieldType)); 
     Assert.assertNull(TypeUtils.getRawType(genericParentT, GenericParent.class)); 
     Assert.assertEquals(GenericParent[].class, TypeUtils.getRawType(GenericTypeHolder.class.getDeclaredField("barParents").getGenericType(), null)); 
 }
@Test
public void testDetermineTypeVariableAssignments9426() throws SecurityException, NoSuchFieldException, NoSuchMethodException { 
     final ParameterizedType iterableType = (ParameterizedType) getClass().getField("iterable").getGenericType(); 
     final Map<TypeVariable<?>, Type> typeVarAssigns = TypeUtils.determineTypeArguments(TreeSet.class, iterableType); 
     final TypeVariable<?> treeSetTypeVar = TreeSet.class.getTypeParameters()[0]; 
     Assert.assertTrue(typeVarAssigns.containsKey(treeSetTypeVar)); 
     Assert.assertEquals(iterableType.getActualTypeArguments()[0], typeVarAssigns.get(treeSetTypeVar)); 
 }
@Test
public void testIsInstance9597() throws SecurityException, NoSuchFieldException { 
         final Type intComparableType = getClass().getField("intComparable").getGenericType(); 
         final Type uriComparableType = getClass().getField("uriComparable").getGenericType(); 
         intComparable = 1; 
         Assert.assertTrue(TypeUtils.isInstance(1, intComparableType)); 
         // uriComparable = 1; 
         Assert.assertFalse(TypeUtils.isInstance(1, uriComparableType)); 
     }
@Test
public void testGetRawType10744() throws SecurityException, NoSuchFieldException { 
         final Type stringParentFieldType = GenericTypeHolder.class.getDeclaredField("stringParent") 
                 .getGenericType(); 
         final Type integerParentFieldType = GenericTypeHolder.class.getDeclaredField("integerParent") 
                 .getGenericType(); 
         final Type foosFieldType = GenericTypeHolder.class.getDeclaredField("foos").getGenericType(); 
         final Type genericParentT = GenericParent.class.getTypeParameters()[0]; 
         Assert.assertEquals(GenericParent.class, TypeUtils.getRawType(stringParentFieldType, null)); 
         Assert 
                 .assertEquals(GenericParent.class, TypeUtils.getRawType(integerParentFieldType, 
                         null)); 
         Assert.assertEquals(List.class, TypeUtils.getRawType(foosFieldType, null)); 
         Assert.assertEquals(String.class, TypeUtils.getRawType(genericParentT, 
                 StringParameterizedChild.class)); 
         Assert.assertEquals(String.class, TypeUtils.getRawType(genericParentT, 
                 stringParentFieldType)); 
         Assert.assertEquals(Foo.class, TypeUtils.getRawType(Iterable.class.getTypeParameters()[0], 
                 foosFieldType)); 
         Assert.assertEquals(Foo.class, TypeUtils.getRawType(List.class.getTypeParameters()[0], 
                 foosFieldType)); 
         Assert.assertNull(TypeUtils.getRawType(genericParentT, GenericParent.class)); 
         Assert.assertEquals(GenericParent[].class, TypeUtils.getRawType(GenericTypeHolder.class 
                 .getDeclaredField("barParents").getGenericType(), null)); 
     }
@Test
public void testDetermineTypeVariableAssignments10745() throws SecurityException, 
             NoSuchFieldException, NoSuchMethodException { 
         final ParameterizedType iterableType = (ParameterizedType) getClass().getField("iterable") 
                 .getGenericType(); 
         final Map<TypeVariable<?>, Type> typeVarAssigns = TypeUtils.determineTypeArguments(TreeSet.class, 
                 iterableType); 
         final TypeVariable<?> treeSetTypeVar = TreeSet.class.getTypeParameters()[0]; 
         Assert.assertTrue(typeVarAssigns.containsKey(treeSetTypeVar)); 
         Assert.assertEquals(iterableType.getActualTypeArguments()[0], typeVarAssigns 
                 .get(treeSetTypeVar)); 
     }
@Test
public void testGetRawType10746() throws SecurityException, NoSuchFieldException { 
         final Type stringParentFieldType = GenericTypeHolder.class.getDeclaredField("stringParent") 
                 .getGenericType(); 
         final Type integerParentFieldType = GenericTypeHolder.class.getDeclaredField("integerParent") 
                 .getGenericType(); 
         final Type foosFieldType = GenericTypeHolder.class.getDeclaredField("foos").getGenericType(); 
         final Type genericParentT = GenericParent.class.getTypeParameters()[0]; 
         Assert.assertEquals(GenericParent.class, TypeUtils.getRawType(stringParentFieldType, null)); 
         Assert 
                 .assertEquals(GenericParent.class, TypeUtils.getRawType(integerParentFieldType, 
                         null)); 
         Assert.assertEquals(List.class, TypeUtils.getRawType(foosFieldType, null)); 
         Assert.assertEquals(String.class, TypeUtils.getRawType(genericParentT, 
                 StringParameterizedChild.class)); 
         Assert.assertEquals(String.class, TypeUtils.getRawType(genericParentT, 
                 stringParentFieldType)); 
         Assert.assertEquals(Foo.class, TypeUtils.getRawType(Iterable.class.getTypeParameters()[0], 
                 foosFieldType)); 
         Assert.assertEquals(Foo.class, TypeUtils.getRawType(List.class.getTypeParameters()[0], 
                 foosFieldType)); 
         Assert.assertNull(TypeUtils.getRawType(genericParentT, GenericParent.class)); 
         Assert.assertEquals(GenericParent[].class, TypeUtils.getRawType(GenericTypeHolder.class 
                 .getDeclaredField("barParents").getGenericType(), null)); 
     }
@Test
public void testDetermineTypeVariableAssignments10747() throws SecurityException, 
             NoSuchFieldException, NoSuchMethodException { 
         final ParameterizedType iterableType = (ParameterizedType) getClass().getField("iterable") 
                 .getGenericType(); 
         final Map<TypeVariable<?>, Type> typeVarAssigns = TypeUtils.determineTypeArguments(TreeSet.class, 
                 iterableType); 
         final TypeVariable<?> treeSetTypeVar = TreeSet.class.getTypeParameters()[0]; 
         Assert.assertTrue(typeVarAssigns.containsKey(treeSetTypeVar)); 
         Assert.assertEquals(iterableType.getActualTypeArguments()[0], typeVarAssigns 
                 .get(treeSetTypeVar)); 
     }
@Test
public void testGetRawType10748() throws SecurityException, NoSuchFieldException { 
         final Type stringParentFieldType = GenericTypeHolder.class.getDeclaredField("stringParent") 
                 .getGenericType(); 
         final Type integerParentFieldType = GenericTypeHolder.class.getDeclaredField("integerParent") 
                 .getGenericType(); 
         final Type foosFieldType = GenericTypeHolder.class.getDeclaredField("foos").getGenericType(); 
         final Type genericParentT = GenericParent.class.getTypeParameters()[0]; 
         Assert.assertEquals(GenericParent.class, TypeUtils.getRawType(stringParentFieldType, null)); 
         Assert 
                 .assertEquals(GenericParent.class, TypeUtils.getRawType(integerParentFieldType, 
                         null)); 
         Assert.assertEquals(List.class, TypeUtils.getRawType(foosFieldType, null)); 
         Assert.assertEquals(String.class, TypeUtils.getRawType(genericParentT, 
                 StringParameterizedChild.class)); 
         Assert.assertEquals(String.class, TypeUtils.getRawType(genericParentT, 
                 stringParentFieldType)); 
         Assert.assertEquals(Foo.class, TypeUtils.getRawType(Iterable.class.getTypeParameters()[0], 
                 foosFieldType)); 
         Assert.assertEquals(Foo.class, TypeUtils.getRawType(List.class.getTypeParameters()[0], 
                 foosFieldType)); 
         Assert.assertNull(TypeUtils.getRawType(genericParentT, GenericParent.class)); 
         Assert.assertEquals(GenericParent[].class, TypeUtils.getRawType(GenericTypeHolder.class 
                 .getDeclaredField("barParents").getGenericType(), null)); 
     }
@Test
public void testDetermineTypeVariableAssignments10749() throws SecurityException, 
             NoSuchFieldException, NoSuchMethodException { 
         final ParameterizedType iterableType = (ParameterizedType) getClass().getField("iterable") 
                 .getGenericType(); 
         final Map<TypeVariable<?>, Type> typeVarAssigns = TypeUtils.determineTypeArguments(TreeSet.class, 
                 iterableType); 
         final TypeVariable<?> treeSetTypeVar = TreeSet.class.getTypeParameters()[0]; 
         Assert.assertTrue(typeVarAssigns.containsKey(treeSetTypeVar)); 
         Assert.assertEquals(iterableType.getActualTypeArguments()[0], typeVarAssigns 
                 .get(treeSetTypeVar)); 
     }
@Test
public void testGetRawType10750() throws SecurityException, NoSuchFieldException { 
         final Type stringParentFieldType = GenericTypeHolder.class.getDeclaredField("stringParent") 
                 .getGenericType(); 
         final Type integerParentFieldType = GenericTypeHolder.class.getDeclaredField("integerParent") 
                 .getGenericType(); 
         final Type foosFieldType = GenericTypeHolder.class.getDeclaredField("foos").getGenericType(); 
         final Type genericParentT = GenericParent.class.getTypeParameters()[0]; 
         Assert.assertEquals(GenericParent.class, TypeUtils.getRawType(stringParentFieldType, null)); 
         Assert 
                 .assertEquals(GenericParent.class, TypeUtils.getRawType(integerParentFieldType, 
                         null)); 
         Assert.assertEquals(List.class, TypeUtils.getRawType(foosFieldType, null)); 
         Assert.assertEquals(String.class, TypeUtils.getRawType(genericParentT, 
                 StringParameterizedChild.class)); 
         Assert.assertEquals(String.class, TypeUtils.getRawType(genericParentT, 
                 stringParentFieldType)); 
         Assert.assertEquals(Foo.class, TypeUtils.getRawType(Iterable.class.getTypeParameters()[0], 
                 foosFieldType)); 
         Assert.assertEquals(Foo.class, TypeUtils.getRawType(List.class.getTypeParameters()[0], 
                 foosFieldType)); 
         Assert.assertNull(TypeUtils.getRawType(genericParentT, GenericParent.class)); 
         Assert.assertEquals(GenericParent[].class, TypeUtils.getRawType(GenericTypeHolder.class 
                 .getDeclaredField("barParents").getGenericType(), null)); 
     }
@Test
public void testGetRawType10751() throws SecurityException, NoSuchFieldException { 
         final Type stringParentFieldType = GenericTypeHolder.class.getDeclaredField("stringParent") 
                 .getGenericType(); 
         final Type integerParentFieldType = GenericTypeHolder.class.getDeclaredField("integerParent") 
                 .getGenericType(); 
         final Type foosFieldType = GenericTypeHolder.class.getDeclaredField("foos").getGenericType(); 
         final Type genericParentT = GenericParent.class.getTypeParameters()[0]; 
         Assert.assertEquals(GenericParent.class, TypeUtils.getRawType(stringParentFieldType, null)); 
         Assert 
                 .assertEquals(GenericParent.class, TypeUtils.getRawType(integerParentFieldType, 
                         null)); 
         Assert.assertEquals(List.class, TypeUtils.getRawType(foosFieldType, null)); 
         Assert.assertEquals(String.class, TypeUtils.getRawType(genericParentT, 
                 StringParameterizedChild.class)); 
         Assert.assertEquals(String.class, TypeUtils.getRawType(genericParentT, 
                 stringParentFieldType)); 
         Assert.assertEquals(Foo.class, TypeUtils.getRawType(Iterable.class.getTypeParameters()[0], 
                 foosFieldType)); 
         Assert.assertEquals(Foo.class, TypeUtils.getRawType(List.class.getTypeParameters()[0], 
                 foosFieldType)); 
         Assert.assertNull(TypeUtils.getRawType(genericParentT, GenericParent.class)); 
         Assert.assertEquals(GenericParent[].class, TypeUtils.getRawType(GenericTypeHolder.class 
                 .getDeclaredField("barParents").getGenericType(), null)); 
     }
@Test
public void testDetermineTypeVariableAssignments10752() throws SecurityException, 
             NoSuchFieldException, NoSuchMethodException { 
         final ParameterizedType iterableType = (ParameterizedType) getClass().getField("iterable") 
                 .getGenericType(); 
         final Map<TypeVariable<?>, Type> typeVarAssigns = TypeUtils.determineTypeArguments(TreeSet.class, 
                 iterableType); 
         final TypeVariable<?> treeSetTypeVar = TreeSet.class.getTypeParameters()[0]; 
         Assert.assertTrue(typeVarAssigns.containsKey(treeSetTypeVar)); 
         Assert.assertEquals(iterableType.getActualTypeArguments()[0], typeVarAssigns 
                 .get(treeSetTypeVar)); 
     }
@Test
public void testGetRawType10753() throws SecurityException, NoSuchFieldException { 
         final Type stringParentFieldType = GenericTypeHolder.class.getDeclaredField("stringParent") 
                 .getGenericType(); 
         final Type integerParentFieldType = GenericTypeHolder.class.getDeclaredField("integerParent") 
                 .getGenericType(); 
         final Type foosFieldType = GenericTypeHolder.class.getDeclaredField("foos").getGenericType(); 
         final Type genericParentT = GenericParent.class.getTypeParameters()[0]; 
         Assert.assertEquals(GenericParent.class, TypeUtils.getRawType(stringParentFieldType, null)); 
         Assert 
                 .assertEquals(GenericParent.class, TypeUtils.getRawType(integerParentFieldType, 
                         null)); 
         Assert.assertEquals(List.class, TypeUtils.getRawType(foosFieldType, null)); 
         Assert.assertEquals(String.class, TypeUtils.getRawType(genericParentT, 
                 StringParameterizedChild.class)); 
         Assert.assertEquals(String.class, TypeUtils.getRawType(genericParentT, 
                 stringParentFieldType)); 
         Assert.assertEquals(Foo.class, TypeUtils.getRawType(Iterable.class.getTypeParameters()[0], 
                 foosFieldType)); 
         Assert.assertEquals(Foo.class, TypeUtils.getRawType(List.class.getTypeParameters()[0], 
                 foosFieldType)); 
         Assert.assertNull(TypeUtils.getRawType(genericParentT, GenericParent.class)); 
         Assert.assertEquals(GenericParent[].class, TypeUtils.getRawType(GenericTypeHolder.class 
                 .getDeclaredField("barParents").getGenericType(), null)); 
     }
@Test
public void testGetRawType10754() throws SecurityException, NoSuchFieldException { 
         final Type stringParentFieldType = GenericTypeHolder.class.getDeclaredField("stringParent") 
                 .getGenericType(); 
         final Type integerParentFieldType = GenericTypeHolder.class.getDeclaredField("integerParent") 
                 .getGenericType(); 
         final Type foosFieldType = GenericTypeHolder.class.getDeclaredField("foos").getGenericType(); 
         final Type genericParentT = GenericParent.class.getTypeParameters()[0]; 
         Assert.assertEquals(GenericParent.class, TypeUtils.getRawType(stringParentFieldType, null)); 
         Assert 
                 .assertEquals(GenericParent.class, TypeUtils.getRawType(integerParentFieldType, 
                         null)); 
         Assert.assertEquals(List.class, TypeUtils.getRawType(foosFieldType, null)); 
         Assert.assertEquals(String.class, TypeUtils.getRawType(genericParentT, 
                 StringParameterizedChild.class)); 
         Assert.assertEquals(String.class, TypeUtils.getRawType(genericParentT, 
                 stringParentFieldType)); 
         Assert.assertEquals(Foo.class, TypeUtils.getRawType(Iterable.class.getTypeParameters()[0], 
                 foosFieldType)); 
         Assert.assertEquals(Foo.class, TypeUtils.getRawType(List.class.getTypeParameters()[0], 
                 foosFieldType)); 
         Assert.assertNull(TypeUtils.getRawType(genericParentT, GenericParent.class)); 
         Assert.assertEquals(GenericParent[].class, TypeUtils.getRawType(GenericTypeHolder.class 
                 .getDeclaredField("barParents").getGenericType(), null)); 
     }
@Test
public void testGetRawType10755() throws SecurityException, NoSuchFieldException { 
         final Type stringParentFieldType = GenericTypeHolder.class.getDeclaredField("stringParent") 
                 .getGenericType(); 
         final Type integerParentFieldType = GenericTypeHolder.class.getDeclaredField("integerParent") 
                 .getGenericType(); 
         final Type foosFieldType = GenericTypeHolder.class.getDeclaredField("foos").getGenericType(); 
         final Type genericParentT = GenericParent.class.getTypeParameters()[0]; 
         Assert.assertEquals(GenericParent.class, TypeUtils.getRawType(stringParentFieldType, null)); 
         Assert 
                 .assertEquals(GenericParent.class, TypeUtils.getRawType(integerParentFieldType, 
                         null)); 
         Assert.assertEquals(List.class, TypeUtils.getRawType(foosFieldType, null)); 
         Assert.assertEquals(String.class, TypeUtils.getRawType(genericParentT, 
                 StringParameterizedChild.class)); 
         Assert.assertEquals(String.class, TypeUtils.getRawType(genericParentT, 
                 stringParentFieldType)); 
         Assert.assertEquals(Foo.class, TypeUtils.getRawType(Iterable.class.getTypeParameters()[0], 
                 foosFieldType)); 
         Assert.assertEquals(Foo.class, TypeUtils.getRawType(List.class.getTypeParameters()[0], 
                 foosFieldType)); 
         Assert.assertNull(TypeUtils.getRawType(genericParentT, GenericParent.class)); 
         Assert.assertEquals(GenericParent[].class, TypeUtils.getRawType(GenericTypeHolder.class 
                 .getDeclaredField("barParents").getGenericType(), null)); 
     }
@Test
public void testIsInstance10756() throws SecurityException, NoSuchFieldException { 
         final Type intComparableType = getClass().getField("intComparable").getGenericType(); 
         final Type uriComparableType = getClass().getField("uriComparable").getGenericType(); 
         intComparable = 1; 
         Assert.assertTrue(TypeUtils.isInstance(1, intComparableType)); 
         // uriComparable = 1; 
         Assert.assertFalse(TypeUtils.isInstance(1, uriComparableType)); 
     }
@Test
public void testIsInstance10757() throws SecurityException, NoSuchFieldException { 
         final Type intComparableType = getClass().getField("intComparable").getGenericType(); 
         final Type uriComparableType = getClass().getField("uriComparable").getGenericType(); 
         intComparable = 1; 
         Assert.assertTrue(TypeUtils.isInstance(1, intComparableType)); 
         // uriComparable = 1; 
         Assert.assertFalse(TypeUtils.isInstance(1, uriComparableType)); 
     }
@Test
public void testGetRawType10758() throws SecurityException, NoSuchFieldException { 
         final Type stringParentFieldType = GenericTypeHolder.class.getDeclaredField("stringParent") 
                 .getGenericType(); 
         final Type integerParentFieldType = GenericTypeHolder.class.getDeclaredField("integerParent") 
                 .getGenericType(); 
         final Type foosFieldType = GenericTypeHolder.class.getDeclaredField("foos").getGenericType(); 
         final Type genericParentT = GenericParent.class.getTypeParameters()[0]; 
         Assert.assertEquals(GenericParent.class, TypeUtils.getRawType(stringParentFieldType, null)); 
         Assert 
                 .assertEquals(GenericParent.class, TypeUtils.getRawType(integerParentFieldType, 
                         null)); 
         Assert.assertEquals(List.class, TypeUtils.getRawType(foosFieldType, null)); 
         Assert.assertEquals(String.class, TypeUtils.getRawType(genericParentT, 
                 StringParameterizedChild.class)); 
         Assert.assertEquals(String.class, TypeUtils.getRawType(genericParentT, 
                 stringParentFieldType)); 
         Assert.assertEquals(Foo.class, TypeUtils.getRawType(Iterable.class.getTypeParameters()[0], 
                 foosFieldType)); 
         Assert.assertEquals(Foo.class, TypeUtils.getRawType(List.class.getTypeParameters()[0], 
                 foosFieldType)); 
         Assert.assertNull(TypeUtils.getRawType(genericParentT, GenericParent.class)); 
         Assert.assertEquals(GenericParent[].class, TypeUtils.getRawType(GenericTypeHolder.class 
                 .getDeclaredField("barParents").getGenericType(), null)); 
     }
@Test
public void testDetermineTypeVariableAssignments10759() throws SecurityException, 
             NoSuchFieldException, NoSuchMethodException { 
         final ParameterizedType iterableType = (ParameterizedType) getClass().getField("iterable") 
                 .getGenericType(); 
         final Map<TypeVariable<?>, Type> typeVarAssigns = TypeUtils.determineTypeArguments(TreeSet.class, 
                 iterableType); 
         final TypeVariable<?> treeSetTypeVar = TreeSet.class.getTypeParameters()[0]; 
         Assert.assertTrue(typeVarAssigns.containsKey(treeSetTypeVar)); 
         Assert.assertEquals(iterableType.getActualTypeArguments()[0], typeVarAssigns 
                 .get(treeSetTypeVar)); 
     }
@Test
public void testDetermineTypeVariableAssignments10760() throws SecurityException, 
             NoSuchFieldException, NoSuchMethodException { 
         final ParameterizedType iterableType = (ParameterizedType) getClass().getField("iterable") 
                 .getGenericType(); 
         final Map<TypeVariable<?>, Type> typeVarAssigns = TypeUtils.determineTypeArguments(TreeSet.class, 
                 iterableType); 
         final TypeVariable<?> treeSetTypeVar = TreeSet.class.getTypeParameters()[0]; 
         Assert.assertTrue(typeVarAssigns.containsKey(treeSetTypeVar)); 
         Assert.assertEquals(iterableType.getActualTypeArguments()[0], typeVarAssigns 
                 .get(treeSetTypeVar)); 
     }
@Test
public void testGetRawType10761() throws SecurityException, NoSuchFieldException { 
         final Type stringParentFieldType = GenericTypeHolder.class.getDeclaredField("stringParent") 
                 .getGenericType(); 
         final Type integerParentFieldType = GenericTypeHolder.class.getDeclaredField("integerParent") 
                 .getGenericType(); 
         final Type foosFieldType = GenericTypeHolder.class.getDeclaredField("foos").getGenericType(); 
         final Type genericParentT = GenericParent.class.getTypeParameters()[0]; 
         Assert.assertEquals(GenericParent.class, TypeUtils.getRawType(stringParentFieldType, null)); 
         Assert 
                 .assertEquals(GenericParent.class, TypeUtils.getRawType(integerParentFieldType, 
                         null)); 
         Assert.assertEquals(List.class, TypeUtils.getRawType(foosFieldType, null)); 
         Assert.assertEquals(String.class, TypeUtils.getRawType(genericParentT, 
                 StringParameterizedChild.class)); 
         Assert.assertEquals(String.class, TypeUtils.getRawType(genericParentT, 
                 stringParentFieldType)); 
         Assert.assertEquals(Foo.class, TypeUtils.getRawType(Iterable.class.getTypeParameters()[0], 
                 foosFieldType)); 
         Assert.assertEquals(Foo.class, TypeUtils.getRawType(List.class.getTypeParameters()[0], 
                 foosFieldType)); 
         Assert.assertNull(TypeUtils.getRawType(genericParentT, GenericParent.class)); 
         Assert.assertEquals(GenericParent[].class, TypeUtils.getRawType(GenericTypeHolder.class 
                 .getDeclaredField("barParents").getGenericType(), null)); 
     }
@Test
public void testGetRawType10762() throws SecurityException, NoSuchFieldException { 
         final Type stringParentFieldType = GenericTypeHolder.class.getDeclaredField("stringParent") 
                 .getGenericType(); 
         final Type integerParentFieldType = GenericTypeHolder.class.getDeclaredField("integerParent") 
                 .getGenericType(); 
         final Type foosFieldType = GenericTypeHolder.class.getDeclaredField("foos").getGenericType(); 
         final Type genericParentT = GenericParent.class.getTypeParameters()[0]; 
         Assert.assertEquals(GenericParent.class, TypeUtils.getRawType(stringParentFieldType)); 
         Assert 
                 .assertEquals(GenericParent.class, TypeUtils.getRawType(integerParentFieldType)); 
         Assert.assertEquals(List.class, TypeUtils.getRawType(foosFieldType)); 
         Assert.assertEquals(String.class, TypeUtils.getRawType(genericParentT)); 
         Assert.assertEquals(String.class, TypeUtils.getRawType(genericParentT)); 
     }
@Test
public void testGetRawType10763() throws SecurityException, NoSuchFieldException { 
         final Type stringParentFieldType = GenericTypeHolder.class.getDeclaredField("stringParent") 
                 .getGenericType(); 
         final Type integerParentFieldType = GenericTypeHolder.class.getDeclaredField("integerParent") 
                 .getGenericType(); 
         final Type foosFieldType = GenericTypeHolder.class.getDeclaredField("foos").getGenericType(); 
         final Type genericParentT = GenericParent.class.getTypeParameters()[0]; 
         Assert.assertEquals(GenericParent.class, TypeUtils.getRawType(stringParentFieldType, null)); 
         Assert 
                 .assertEquals(GenericParent.class, TypeUtils.getRawType(integerParentFieldType, 
                         null)); 
         Assert.assertEquals(List.class, TypeUtils.getRawType(foosFieldType, null)); 
         Assert.assertEquals(String.class, TypeUtils.getRawType(genericParentT, 
                 StringParameterizedChild.class)); 
         Assert.assertEquals(String.class, TypeUtils.getRawType(genericParentT, 
                 stringParentFieldType)); 
         Assert.assertEquals(Foo.class, TypeUtils.getRawType(Iterable.class.getTypeParameters()[0], 
                 foosFieldType)); 
         Assert.assertEquals(Foo.class, TypeUtils.getRawType(List.class.getTypeParameters()[0], 
                 foosFieldType)); 
         Assert.assertNull(TypeUtils.getRawType(genericParentT, GenericParent.class)); 
         Assert.assertEquals(GenericParent[].class, TypeUtils.getRawType(GenericTypeHolder.class 
                 .getDeclaredField("barParents").getGenericType(), null)); 
     }
@Test
public void testDetermineTypeVariableAssignments10764() throws SecurityException, 
             NoSuchFieldException, NoSuchMethodException { 
         final ParameterizedType iterableType = (ParameterizedType) getClass().getField("iterable") 
                 .getGenericType(); 
         final Map<TypeVariable<?>, Type> typeVarAssigns = TypeUtils.determineTypeArguments(TreeSet.class, 
                 iterableType); 
         final TypeVariable<?> treeSetTypeVar = TreeSet.class.getTypeParameters()[0]; 
         Assert.assertTrue(typeVarAssigns.containsKey(treeSetTypeVar)); 
         Assert.assertEquals(iterableType.getActualTypeArguments()[0], typeVarAssigns 
                 .get(treeSetTypeVar)); 
     }
@Test
public void testGetRawType10765() throws SecurityException, NoSuchFieldException { 
         final Type stringParentFieldType = GenericTypeHolder.class.getDeclaredField("stringParent") 
                 .getGenericType(); 
         final Type integerParentFieldType = GenericTypeHolder.class.getDeclaredField("integerParent") 
                 .getGenericType(); 
         final Type foosFieldType = GenericTypeHolder.class.getDeclaredField("foos").getGenericType(); 
         final Type genericParentT = GenericParent.class.getTypeParameters()[0]; 
         Assert.assertEquals(GenericParent.class, TypeUtils.getRawType(stringParentFieldType, null)); 
         Assert 
                 .assertEquals(GenericParent.class, TypeUtils.getRawType(integerParentFieldType, 
                         null)); 
         Assert.assertEquals(List.class, TypeUtils.getRawType(foosFieldType, null)); 
         Assert.assertEquals(String.class, TypeUtils.getRawType(genericParentT, 
                 StringParameterizedChild.class)); 
         Assert.assertEquals(String.class, TypeUtils.getRawType(genericParentT, 
                 stringParentFieldType)); 
         Assert.assertEquals(Foo.class, TypeUtils.getRawType(Iterable.class.getTypeParameters()[0], 
                 foosFieldType)); 
         Assert.assertEquals(Foo.class, TypeUtils.getRawType(List.class.getTypeParameters()[0], 
                 foosFieldType)); 
         Assert.assertNull(TypeUtils.getRawType(genericParentT, GenericParent.class)); 
         Assert.assertEquals(GenericParent[].class, TypeUtils.getRawType(GenericTypeHolder.class 
                 .getDeclaredField("barParents").getGenericType(), null)); 
     }
@Test
public void testGetRawType10766() throws SecurityException, NoSuchFieldException { 
         final Type stringParentFieldType = GenericTypeHolder.class.getDeclaredField("stringParent") 
                 .getGenericType(); 
         final Type integerParentFieldType = GenericTypeHolder.class.getDeclaredField("integerParent") 
                 .getGenericType(); 
         final Type foosFieldType = GenericTypeHolder.class.getDeclaredField("foos").getGenericType(); 
         final Type genericParentT = GenericParent.class.getTypeParameters()[0]; 
         Assert.assertEquals(GenericParent.class, TypeUtils.getRawType(stringParentFieldType, null)); 
         Assert 
                 .assertEquals(GenericParent.class, TypeUtils.getRawType(integerParentFieldType, 
                         null)); 
         Assert.assertEquals(List.class, TypeUtils.getRawType(foosFieldType, null)); 
         Assert.assertEquals(String.class, TypeUtils.getRawType(genericParentT, 
                 StringParameterizedChild.class)); 
         Assert.assertEquals(String.class, TypeUtils.getRawType(genericParentT, 
                 stringParentFieldType)); 
         Assert.assertEquals(Foo.class, TypeUtils.getRawType(Iterable.class.getTypeParameters()[0], 
                 foosFieldType)); 
         Assert.assertEquals(Foo.class, TypeUtils.getRawType(List.class.getTypeParameters()[0], 
                 foosFieldType)); 
         Assert.assertNull(TypeUtils.getRawType(genericParentT, GenericParent.class)); 
         Assert.assertEquals(GenericParent[].class, TypeUtils.getRawType(GenericTypeHolder.class 
                 .getDeclaredField("barParents").getGenericType(), null)); 
     }
@Test
public void testGetRawType10767() throws SecurityException, NoSuchFieldException { 
         final Type stringParentFieldType = GenericTypeHolder.class.getDeclaredField("stringParent") 
                 .getGenericType(); 
         final Type integerParentFieldType = GenericTypeHolder.class.getDeclaredField("integerParent") 
                 .getGenericType(); 
         final Type foosFieldType = GenericTypeHolder.class.getDeclaredField("foos").getGenericType(); 
         final Type genericParentT = GenericParent.class.getTypeParameters()[0]; 
         Assert.assertEquals(GenericParent.class, TypeUtils.getRawType(stringParentFieldType, null)); 
         Assert 
                 .assertEquals(GenericParent.class, TypeUtils.getRawType(integerParentFieldType, 
                         null)); 
         Assert.assertEquals(List.class, TypeUtils.getRawType(foosFieldType, null)); 
         Assert.assertEquals(String.class, TypeUtils.getRawType(genericParentT, 
                 StringParameterizedChild.class)); 
         Assert.assertEquals(String.class, TypeUtils.getRawType(genericParentT, 
                 stringParentFieldType)); 
         Assert.assertEquals(Foo.class, TypeUtils.getRawType(Iterable.class.getTypeParameters()[0], 
                 foosFieldType)); 
         Assert.assertEquals(Foo.class, TypeUtils.getRawType(List.class.getTypeParameters()[0], 
                 foosFieldType)); 
         Assert.assertNull(TypeUtils.getRawType(genericParentT, GenericParent.class)); 
         Assert.assertEquals(GenericParent[].class, TypeUtils.getRawType(GenericTypeHolder.class 
                 .getDeclaredField("barParents").getGenericType(), null)); 
     }
@Test
public void testIsInstance10768() throws SecurityException, NoSuchFieldException { 
         final Type intComparableType = getClass().getField("intComparable").getGenericType(); 
         final Type uriComparableType = getClass().getField("uriComparable").getGenericType(); 
         intComparable = 1; 
         Assert.assertTrue(TypeUtils.isInstance(1, intComparableType)); 
         // uriComparable = 1; 
         Assert.assertFalse(TypeUtils.isInstance(1, uriComparableType)); 
     }
@Test
public void testDetermineTypeVariableAssignments10769() throws SecurityException, 
             NoSuchFieldException, NoSuchMethodException { 
         final ParameterizedType iterableType = (ParameterizedType) getClass().getField("iterable") 
                 .getGenericType(); 
         final Map<TypeVariable<?>, Type> typeVarAssigns = TypeUtils.determineTypeArguments(TreeSet.class, 
                 iterableType); 
         final TypeVariable<?> treeSetTypeVar = TreeSet.class.getTypeParameters()[0]; 
         Assert.assertTrue(typeVarAssigns.containsKey(treeSetTypeVar)); 
         Assert.assertEquals(iterableType.getActualTypeArguments()[0], typeVarAssigns 
                 .get(treeSetTypeVar)); 
     }
@Test
public void testDetermineTypeVariableAssignments10770() throws SecurityException, 
             NoSuchFieldException, NoSuchMethodException { 
         final ParameterizedType iterableType = (ParameterizedType) getClass().getField("iterable") 
                 .getGenericType(); 
         final Map<TypeVariable<?>, Type> typeVarAssigns = TypeUtils.determineTypeArguments(TreeSet.class, 
                 iterableType); 
         final TypeVariable<?> treeSetTypeVar = TreeSet.class.getTypeParameters()[0]; 
         Assert.assertTrue(typeVarAssigns.containsKey(treeSetTypeVar)); 
         Assert.assertEquals(iterableType.getActualTypeArguments()[0], typeVarAssigns 
                 .get(treeSetTypeVar)); 
     }
@Test
public void testDetermineTypeVariableAssignments10771() throws SecurityException, 
             NoSuchFieldException, NoSuchMethodException { 
         final ParameterizedType iterableType = (ParameterizedType) getClass().getField("iterable") 
                 .getGenericType(); 
         final Map<TypeVariable<?>, Type> typeVarAssigns = TypeUtils.determineTypeArguments(TreeSet.class, 
                 iterableType); 
         final TypeVariable<?> treeSetTypeVar = TreeSet.class.getTypeParameters()[0]; 
         Assert.assertTrue(typeVarAssigns.containsKey(treeSetTypeVar)); 
         Assert.assertEquals(iterableType.getActualTypeArguments()[0], typeVarAssigns 
                 .get(treeSetTypeVar)); 
     }
@Test
public void testGetRawType10772() throws SecurityException, NoSuchFieldException { 
         final Type stringParentFieldType = GenericTypeHolder.class.getDeclaredField("stringParent") 
                 .getGenericType(); 
         final Type integerParentFieldType = GenericTypeHolder.class.getDeclaredField("integerParent") 
                 .getGenericType(); 
         final Type foosFieldType = GenericTypeHolder.class.getDeclaredField("foos").getGenericType(); 
         final Type genericParentT = GenericParent.class.getTypeParameters()[0]; 
         Assert.assertEquals(GenericParent.class, TypeUtils.getRawType(stringParentFieldType, null)); 
         Assert 
                 .assertEquals(GenericParent.class, TypeUtils.getRawType(integerParentFieldType, 
                         null)); 
         Assert.assertEquals(List.class, TypeUtils.getRawType(foosFieldType, null)); 
         Assert.assertEquals(String.class, TypeUtils.getRawType(genericParentT, 
                 StringParameterizedChild.class)); 
         Assert.assertEquals(String.class, TypeUtils.getRawType(genericParentT, 
                 stringParentFieldType)); 
         Assert.assertEquals(Foo.class, TypeUtils.getRawType(Iterable.class.getTypeParameters()[0], 
                 foosFieldType)); 
         Assert.assertEquals(Foo.class, TypeUtils.getRawType(List.class.getTypeParameters()[0], 
                 foosFieldType)); 
         Assert.assertNull(TypeUtils.getRawType(genericParentT, GenericParent.class)); 
         Assert.assertEquals(GenericParent[].class, TypeUtils.getRawType(GenericTypeHolder.class 
                 .getDeclaredField("barParents").getGenericType(), null)); 
     }
@Test
public void testIsInstance10773() throws SecurityException, NoSuchFieldException { 
         final Type intComparableType = getClass().getField("intComparable").getGenericType(); 
         final Type uriComparableType = getClass().getField("uriComparable").getGenericType(); 
         intComparable = 1; 
         Assert.assertTrue(TypeUtils.isInstance(1, intComparableType)); 
         // uriComparable = 1; 
         Assert.assertFalse(TypeUtils.isInstance(1, uriComparableType)); 
     }
@Test
public void testGetRawType10774() throws SecurityException, NoSuchFieldException { 
         final Type stringParentFieldType = GenericTypeHolder.class.getDeclaredField("stringParent") 
                 .getGenericType(); 
         final Type integerParentFieldType = GenericTypeHolder.class.getDeclaredField("integerParent") 
                 .getGenericType(); 
         final Type foosFieldType = GenericTypeHolder.class.getDeclaredField("foos").getGenericType(); 
         final Type genericParentT = GenericParent.class.getTypeParameters()[0]; 
         Assert.assertEquals(GenericParent.class, TypeUtils.getRawType(stringParentFieldType, null)); 
         Assert 
                 .assertEquals(GenericParent.class, TypeUtils.getRawType(integerParentFieldType, 
                         null)); 
         Assert.assertEquals(List.class, TypeUtils.getRawType(foosFieldType, null)); 
         Assert.assertEquals(String.class, TypeUtils.getRawType(genericParentT, 
                 StringParameterizedChild.class)); 
         Assert.assertEquals(String.class, TypeUtils.getRawType(genericParentT, 
                 stringParentFieldType)); 
         Assert.assertEquals(Foo.class, TypeUtils.getRawType(Iterable.class.getTypeParameters()[0], 
                 foosFieldType)); 
         Assert.assertEquals(Foo.class, TypeUtils.getRawType(List.class.getTypeParameters()[0], 
                 foosFieldType)); 
         Assert.assertNull(TypeUtils.getRawType(genericParentT, GenericParent.class)); 
         Assert.assertEquals(GenericParent[].class, TypeUtils.getRawType(GenericTypeHolder.class 
                 .getDeclaredField("barParents").getGenericType(), null)); 
     }
@Test
public void testGetRawType10775() throws SecurityException, NoSuchFieldException { 
         final Type stringParentFieldType = GenericTypeHolder.class.getDeclaredField("stringParent") 
                 .getGenericType(); 
         final Type integerParentFieldType = GenericTypeHolder.class.getDeclaredField("integerParent") 
                 .getGenericType(); 
         final Type foosFieldType = GenericTypeHolder.class.getDeclaredField("foos").getGenericType(); 
         final Type genericParentT = GenericParent.class.getTypeParameters()[0]; 
         Assert.assertEquals(GenericParent.class, TypeUtils.getRawType(stringParentFieldType, null)); 
         Assert 
                 .assertEquals(GenericParent.class, TypeUtils.getRawType(integerParentFieldType, 
                         null)); 
         Assert.assertEquals(List.class, TypeUtils.getRawType(foosFieldType, null)); 
         Assert.assertEquals(String.class, TypeUtils.getRawType(genericParentT, 
                 StringParameterizedChild.class)); 
         Assert.assertEquals(String.class, TypeUtils.getRawType(genericParentT, 
                 stringParentFieldType)); 
         Assert.assertEquals(Foo.class, TypeUtils.getRawType(Iterable.class.getTypeParameters()[0], 
                 foosFieldType)); 
         Assert.assertEquals(Foo.class, TypeUtils.getRawType(List.class.getTypeParameters()[0], 
                 foosFieldType)); 
         Assert.assertNull(TypeUtils.getRawType(genericParentT, GenericParent.class)); 
         Assert.assertEquals(GenericParent[].class, TypeUtils.getRawType(GenericTypeHolder.class 
                 .getDeclaredField("barParents").getGenericType(), null)); 
     }
@Test
public void testIsInstance10776() throws SecurityException, NoSuchFieldException { 
         final Type intComparableType = getClass().getField("intComparable").getGenericType(); 
         final Type uriComparableType = getClass().getField("uriComparable").getGenericType(); 
         intComparable = 1; 
         Assert.assertTrue(TypeUtils.isInstance(1, intComparableType)); 
         // uriComparable = 1; 
         Assert.assertFalse(TypeUtils.isInstance(1, uriComparableType)); 
     }
@Test
public void testGetRawType10777() throws SecurityException, NoSuchFieldException { 
         final Type stringParentFieldType = GenericTypeHolder.class.getDeclaredField("stringParent") 
                 .getGenericType(); 
         final Type integerParentFieldType = GenericTypeHolder.class.getDeclaredField("integerParent") 
                 .getGenericType(); 
         final Type foosFieldType = GenericTypeHolder.class.getDeclaredField("foos").getGenericType(); 
         final Type genericParentT = GenericParent.class.getTypeParameters()[0]; 
         Assert.assertEquals(GenericParent.class, TypeUtils.getRawType(stringParentFieldType, null)); 
         Assert 
                 .assertEquals(GenericParent.class, TypeUtils.getRawType(integerParentFieldType, 
                         null)); 
         Assert.assertEquals(List.class, TypeUtils.getRawType(foosFieldType, null)); 
         Assert.assertEquals(String.class, TypeUtils.getRawType(genericParentT, 
                 StringParameterizedChild.class)); 
         Assert.assertEquals(String.class, TypeUtils.getRawType(genericParentT, 
                 stringParentFieldType)); 
         Assert.assertEquals(Foo.class, TypeUtils.getRawType(Iterable.class.getTypeParameters()[0], 
                 foosFieldType)); 
         Assert.assertEquals(Foo.class, TypeUtils.getRawType(List.class.getTypeParameters()[0], 
                 foosFieldType)); 
         Assert.assertNull(TypeUtils.getRawType(genericParentT, GenericParent.class)); 
         Assert.assertEquals(GenericParent[].class, TypeUtils.getRawType(GenericTypeHolder.class 
                 .getDeclaredField("barParents").getGenericType(), null)); 
     }
@Test
public void testGetRawType10778() throws SecurityException, NoSuchFieldException { 
         final Type stringParentFieldType = GenericTypeHolder.class.getDeclaredField("stringParent") 
                 .getGenericType(); 
         final Type integerParentFieldType = GenericTypeHolder.class.getDeclaredField("integerParent") 
                 .getGenericType(); 
         final Type foosFieldType = GenericTypeHolder.class.getDeclaredField("foos").getGenericType(); 
         final Type genericParentT = GenericParent.class.getTypeParameters()[0]; 
         Assert.assertEquals(GenericParent.class, TypeUtils.getRawType(stringParentFieldType, null)); 
         Assert 
                 .assertEquals(GenericParent.class, TypeUtils.getRawType(integerParentFieldType, 
                         null)); 
         Assert.assertEquals(List.class, TypeUtils.getRawType(foosFieldType, null)); 
         Assert.assertEquals(String.class, TypeUtils.getRawType(genericParentT, 
                 StringParameterizedChild.class)); 
         Assert.assertEquals(String.class, TypeUtils.getRawType(genericParentT, 
                 stringParentFieldType)); 
         Assert.assertEquals(Foo.class, TypeUtils.getRawType(Iterable.class.getTypeParameters()[0], 
                 foosFieldType)); 
         Assert.assertEquals(Foo.class, TypeUtils.getRawType(List.class.getTypeParameters()[0], 
                 foosFieldType)); 
         Assert.assertNull(TypeUtils.getRawType(genericParentT, GenericParent.class)); 
         Assert.assertEquals(GenericParent[].class, TypeUtils.getRawType(GenericTypeHolder.class 
                 .getDeclaredField("barParents").getGenericType(), null)); 
     }
@Test
public void testDetermineTypeVariableAssignments10779() throws SecurityException, 
             NoSuchFieldException, NoSuchMethodException { 
         final ParameterizedType iterableType = (ParameterizedType) getClass().getField("iterable") 
                 .getGenericType(); 
         final Map<TypeVariable<?>, Type> typeVarAssigns = TypeUtils.determineTypeArguments(TreeSet.class, 
                 iterableType); 
         final TypeVariable<?> treeSetTypeVar = TreeSet.class.getTypeParameters()[0]; 
         Assert.assertTrue(typeVarAssigns.containsKey(treeSetTypeVar)); 
         Assert.assertEquals(iterableType.getActualTypeArguments()[0], typeVarAssigns 
                 .get(treeSetTypeVar)); 
     }
@Test
public void testGetRawType10780() throws SecurityException, NoSuchFieldException { 
         final Type stringParentFieldType = GenericTypeHolder.class.getDeclaredField("stringParent") 
                 .getGenericType(); 
         final Type integerParentFieldType = GenericTypeHolder.class.getDeclaredField("integerParent") 
                 .getGenericType(); 
         final Type foosFieldType = GenericTypeHolder.class.getDeclaredField("foos").getGenericType(); 
         final Type genericParentT = GenericParent.class.getTypeParameters()[0]; 
         Assert.assertEquals(GenericParent.class, TypeUtils.getRawType(stringParentFieldType, null)); 
         Assert 
                 .assertEquals(GenericParent.class, TypeUtils.getRawType(integerParentFieldType, 
                         null)); 
         Assert.assertEquals(List.class, TypeUtils.getRawType(foosFieldType, null)); 
         Assert.assertEquals(String.class, TypeUtils.getRawType(genericParentT, 
                 StringParameterizedChild.class)); 
         Assert.assertEquals(String.class, TypeUtils.getRawType(genericParentT, 
                 stringParentFieldType)); 
         Assert.assertEquals(Foo.class, TypeUtils.getRawType(Iterable.class.getTypeParameters()[0], 
                 foosFieldType)); 
         Assert.assertEquals(Foo.class, TypeUtils.getRawType(List.class.getTypeParameters()[0], 
                 foosFieldType)); 
         Assert.assertNull(TypeUtils.getRawType(genericParentT, GenericParent.class)); 
         Assert.assertEquals(GenericParent[].class, TypeUtils.getRawType(GenericTypeHolder.class 
                 .getDeclaredField("barParents").getGenericType(), null)); 
     }
@Test
public void testIsInstance10781() throws SecurityException, NoSuchFieldException { 
         final Type intComparableType = getClass().getField("intComparable").getGenericType(); 
         final Type uriComparableType = getClass().getField("uriComparable").getGenericType(); 
         intComparable = 1; 
         Assert.assertTrue(TypeUtils.isInstance(1, intComparableType)); 
         // uriComparable = 1; 
         Assert.assertFalse(TypeUtils.isInstance(1, uriComparableType)); 
     }
@Test
public void testGetRawType10782() throws SecurityException, NoSuchFieldException { 
         final Type stringParentFieldType = GenericTypeHolder.class.getDeclaredField("stringParent") 
                 .getGenericType(); 
         final Type integerParentFieldType = GenericTypeHolder.class.getDeclaredField("integerParent") 
                 .getGenericType(); 
         final Type foosFieldType = GenericTypeHolder.class.getDeclaredField("foos").getGenericType(); 
         final Type genericParentT = GenericParent.class.getTypeParameters()[0]; 
         Assert.assertEquals(GenericParent.class, TypeUtils.getRawType(stringParentFieldType, null)); 
         Assert 
                 .assertEquals(GenericParent.class, TypeUtils.getRawType(integerParentFieldType, 
                         null)); 
         Assert.assertEquals(List.class, TypeUtils.getRawType(foosFieldType, null)); 
         Assert.assertEquals(String.class, TypeUtils.getRawType(genericParentT, 
                 StringParameterizedChild.class)); 
         Assert.assertEquals(String.class, TypeUtils.getRawType(genericParentT, 
                 stringParentFieldType)); 
         Assert.assertEquals(Foo.class, TypeUtils.getRawType(Iterable.class.getTypeParameters()[0], 
                 foosFieldType)); 
         Assert.assertEquals(Foo.class, TypeUtils.getRawType(List.class.getTypeParameters()[0], 
                 foosFieldType)); 
         Assert.assertNull(TypeUtils.getRawType(genericParentT, GenericParent.class)); 
         Assert.assertEquals(GenericParent[].class, TypeUtils.getRawType(GenericTypeHolder.class 
                 .getDeclaredField("barParents").getGenericType(), null)); 
     }
@Test
public void testGetRawType10783() throws SecurityException, NoSuchFieldException { 
         final Type stringParentFieldType = GenericTypeHolder.class.getDeclaredField("stringParent") 
                 .getGenericType(); 
         final Type integerParentFieldType = GenericTypeHolder.class.getDeclaredField("integerParent") 
                 .getGenericType(); 
         final Type foosFieldType = GenericTypeHolder.class.getDeclaredField("foos").getGenericType(); 
         final Type genericParentT = GenericParent.class.getTypeParameters()[0]; 
         Assert.assertEquals(GenericParent.class, TypeUtils.getRawType(stringParentFieldType, null)); 
         Assert 
                 .assertEquals(GenericParent.class, TypeUtils.getRawType(integerParentFieldType, 
                         null)); 
         Assert.assertEquals(List.class, TypeUtils.getRawType(foosFieldType, null)); 
         Assert.assertEquals(String.class, TypeUtils.getRawType(genericParentT, 
                 StringParameterizedChild.class)); 
         Assert.assertEquals(String.class, TypeUtils.getRawType(genericParentT, 
                 stringParentFieldType)); 
         Assert.assertEquals(Foo.class, TypeUtils.getRawType(Iterable.class.getTypeParameters()[0], 
                 foosFieldType)); 
         Assert.assertEquals(Foo.class, TypeUtils.getRawType(List.class.getTypeParameters()[0], 
                 foosFieldType)); 
         Assert.assertNull(TypeUtils.getRawType(genericParentT, GenericParent.class)); 
         Assert.assertEquals(GenericParent[].class, TypeUtils.getRawType(GenericTypeHolder.class 
                 .getDeclaredField("barParents").getGenericType(), null)); 
     }
@Test
public void testGetRawType10784() throws SecurityException, NoSuchFieldException { 
         final Type stringParentFieldType = GenericTypeHolder.class.getDeclaredField("stringParent") 
                 .getGenericType(); 
         final Type integerParentFieldType = GenericTypeHolder.class.getDeclaredField("integerParent") 
                 .getGenericType(); 
         final Type foosFieldType = GenericTypeHolder.class.getDeclaredField("foos").getGenericType(); 
         final Type genericParentT = GenericParent.class.getTypeParameters()[0]; 
         Assert.assertEquals(GenericParent.class, TypeUtils.getRawType(stringParentFieldType, null)); 
         Assert 
                 .assertEquals(GenericParent.class, TypeUtils.getRawType(integerParentFieldType, 
                         null)); 
         Assert.assertEquals(List.class, TypeUtils.getRawType(foosFieldType, null)); 
         Assert.assertEquals(String.class, TypeUtils.getRawType(genericParentT, 
                 StringParameterizedChild.class)); 
         Assert.assertEquals(String.class, TypeUtils.getRawType(genericParentT, 
                 stringParentFieldType)); 
         Assert.assertEquals(Foo.class, TypeUtils.getRawType(Iterable.class.getTypeParameters()[0], 
                 foosFieldType)); 
         Assert.assertEquals(Foo.class, TypeUtils.getRawType(List.class.getTypeParameters()[0], 
                 foosFieldType)); 
         Assert.assertNull(TypeUtils.getRawType(genericParentT, GenericParent.class)); 
         Assert.assertEquals(GenericParent[].class, TypeUtils.getRawType(GenericTypeHolder.class 
                 .getDeclaredField("barParents").getGenericType(), null)); 
     }
@Test
public void testGetRawType10785() throws SecurityException, NoSuchFieldException { 
         final Type stringParentFieldType = GenericTypeHolder.class.getDeclaredField("stringParent") 
                 .getGenericType(); 
         final Type integerParentFieldType = GenericTypeHolder.class.getDeclaredField("integerParent") 
                 .getGenericType(); 
         final Type foosFieldType = GenericTypeHolder.class.getDeclaredField("foos").getGenericType(); 
         final Type genericParentT = GenericParent.class.getTypeParameters()[0]; 
         Assert.assertEquals(GenericParent.class, TypeUtils.getRawType(stringParentFieldType, null)); 
         Assert 
                 .assertEquals(GenericParent.class, TypeUtils.getRawType(integerParentFieldType, 
                         null)); 
         Assert.assertEquals(List.class, TypeUtils.getRawType(foosFieldType, null)); 
         Assert.assertEquals(String.class, TypeUtils.getRawType(genericParentT, 
                 StringParameterizedChild.class)); 
         Assert.assertEquals(String.class, TypeUtils.getRawType(genericParentT, 
                 stringParentFieldType)); 
         Assert.assertEquals(Foo.class, TypeUtils.getRawType(Iterable.class.getTypeParameters()[0], 
                 foosFieldType)); 
         Assert.assertEquals(Foo.class, TypeUtils.getRawType(List.class.getTypeParameters()[0], 
                 foosFieldType)); 
         Assert.assertNull(TypeUtils.getRawType(genericParentT, GenericParent.class)); 
         Assert.assertEquals(GenericParent[].class, TypeUtils.getRawType(GenericTypeHolder.class 
                 .getDeclaredField("barParents").getGenericType(), null)); 
     }
@Test
public void testDetermineTypeVariableAssignments10786() throws SecurityException, 
             NoSuchFieldException, NoSuchMethodException { 
         final ParameterizedType iterableType = (ParameterizedType) getClass().getField("iterable") 
                 .getGenericType(); 
         final Map<TypeVariable<?>, Type> typeVarAssigns = TypeUtils.determineTypeArguments(TreeSet.class, 
                 iterableType); 
         final TypeVariable<?> treeSetTypeVar = TreeSet.class.getTypeParameters()[0]; 
         Assert.assertTrue(typeVarAssigns.containsKey(treeSetTypeVar)); 
         Assert.assertEquals(iterableType.getActualTypeArguments()[0], typeVarAssigns 
                 .get(treeSetTypeVar)); 
     }
@Test
public void testGetRawType10787() throws SecurityException, NoSuchFieldException { 
         final Type stringParentFieldType = GenericTypeHolder.class.getDeclaredField("stringParent") 
                 .getGenericType(); 
         final Type integerParentFieldType = GenericTypeHolder.class.getDeclaredField("integerParent") 
                 .getGenericType(); 
         final Type foosFieldType = GenericTypeHolder.class.getDeclaredField("foos").getGenericType(); 
         final Type genericParentT = GenericParent.class.getTypeParameters()[0]; 
         Assert.assertEquals(GenericParent.class, TypeUtils.getRawType(stringParentFieldType, null)); 
         Assert 
                 .assertEquals(GenericParent.class, TypeUtils.getRawType(integerParentFieldType, 
                         null)); 
         Assert.assertEquals(List.class, TypeUtils.getRawType(foosFieldType, null)); 
         Assert.assertEquals(String.class, TypeUtils.getRawType(genericParentT, 
                 StringParameterizedChild.class)); 
         Assert.assertEquals(String.class, TypeUtils.getRawType(genericParentT, 
                 stringParentFieldType)); 
         Assert.assertEquals(Foo.class, TypeUtils.getRawType(Iterable.class.getTypeParameters()[0], 
                 foosFieldType)); 
         Assert.assertEquals(Foo.class, TypeUtils.getRawType(List.class.getTypeParameters()[0], 
                 foosFieldType)); 
         Assert.assertNull(TypeUtils.getRawType(genericParentT, GenericParent.class)); 
         Assert.assertEquals(GenericParent[].class, TypeUtils.getRawType(GenericTypeHolder.class 
                 .getDeclaredField("barParents").getGenericType(), null)); 
     }
@Test
public void testIsInstance10788() throws SecurityException, NoSuchFieldException { 
         final Type intComparableType = getClass().getField("intComparable").getGenericType(); 
         final Type uriComparableType = getClass().getField("uriComparable").getGenericType(); 
         intComparable = 1; 
         Assert.assertTrue(TypeUtils.isInstance(1, intComparableType)); 
         // uriComparable = 1; 
         Assert.assertFalse(TypeUtils.isInstance(1, uriComparableType)); 
     }
@Test
public void testIsInstance10789() throws SecurityException, NoSuchFieldException { 
         final Type intComparableType = getClass().getField("intComparable").getGenericType(); 
         final Type uriComparableType = getClass().getField("uriComparable").getGenericType(); 
         intComparable = 1; 
         Assert.assertTrue(TypeUtils.isInstance(1, intComparableType)); 
         // uriComparable = 1; 
         Assert.assertFalse(TypeUtils.isInstance(1, uriComparableType)); 
     }
@Test
public void testIsInstance10790() throws SecurityException, NoSuchFieldException { 
         final Type intComparableType = getClass().getField("intComparable").getGenericType(); 
         final Type uriComparableType = getClass().getField("uriComparable").getGenericType(); 
         intComparable = 1; 
         Assert.assertTrue(TypeUtils.isInstance(1, intComparableType)); 
         // uriComparable = 1; 
         Assert.assertFalse(TypeUtils.isInstance(1, uriComparableType)); 
     }
@Test
public void testIsInstance10791() throws SecurityException, NoSuchFieldException { 
         final Type intComparableType = getClass().getField("intComparable").getGenericType(); 
         final Type uriComparableType = getClass().getField("uriComparable").getGenericType(); 
         intComparable = 1; 
         Assert.assertTrue(TypeUtils.isInstance(1, intComparableType)); 
         // uriComparable = 1; 
         Assert.assertFalse(TypeUtils.isInstance(1, uriComparableType)); 
     }
@Test
public void testDetermineTypeVariableAssignments10792() throws SecurityException, 
             NoSuchFieldException, NoSuchMethodException { 
         final ParameterizedType iterableType = (ParameterizedType) getClass().getField("iterable") 
                 .getGenericType(); 
         final Map<TypeVariable<?>, Type> typeVarAssigns = TypeUtils.determineTypeArguments(TreeSet.class, 
                 iterableType); 
         final TypeVariable<?> treeSetTypeVar = TreeSet.class.getTypeParameters()[0]; 
         Assert.assertTrue(typeVarAssigns.containsKey(treeSetTypeVar)); 
         Assert.assertEquals(iterableType.getActualTypeArguments()[0], typeVarAssigns 
                 .get(treeSetTypeVar)); 
     }
@Test
public void testGetRawType10793() throws SecurityException, NoSuchFieldException { 
         final Type stringParentFieldType = GenericTypeHolder.class.getDeclaredField("stringParent") 
                 .getGenericType(); 
         final Type integerParentFieldType = GenericTypeHolder.class.getDeclaredField("integerParent") 
                 .getGenericType(); 
         final Type foosFieldType = GenericTypeHolder.class.getDeclaredField("foos").getGenericType(); 
         final Type genericParentT = GenericParent.class.getTypeParameters()[0]; 
         Assert.assertEquals(GenericParent.class, TypeUtils.getRawType(stringParentFieldType, null)); 
         Assert 
                 .assertEquals(GenericParent.class, TypeUtils.getRawType(integerParentFieldType, 
                         null)); 
         Assert.assertEquals(List.class, TypeUtils.getRawType(foosFieldType, null)); 
         Assert.assertEquals(String.class, TypeUtils.getRawType(genericParentT, 
                 StringParameterizedChild.class)); 
         Assert.assertEquals(String.class, TypeUtils.getRawType(genericParentT, 
                 stringParentFieldType)); 
         Assert.assertEquals(Foo.class, TypeUtils.getRawType(Iterable.class.getTypeParameters()[0], 
                 foosFieldType)); 
         Assert.assertEquals(Foo.class, TypeUtils.getRawType(List.class.getTypeParameters()[0], 
                 foosFieldType)); 
         Assert.assertNull(TypeUtils.getRawType(genericParentT, GenericParent.class)); 
         Assert.assertEquals(GenericParent[].class, TypeUtils.getRawType(GenericTypeHolder.class 
                 .getDeclaredField("barParents").getGenericType(), null)); 
     }
@Test
public void testGetRawType10794() throws SecurityException, NoSuchFieldException { 
         final Type stringParentFieldType = GenericTypeHolder.class.getDeclaredField("stringParent") 
                 .getGenericType(); 
         final Type integerParentFieldType = GenericTypeHolder.class.getDeclaredField("integerParent") 
                 .getGenericType(); 
         final Type foosFieldType = GenericTypeHolder.class.getDeclaredField("foos").getGenericType(); 
         final Type genericParentT = GenericParent.class.getTypeParameters()[0]; 
         Assert.assertEquals(GenericParent.class, TypeUtils.getRawType(stringParentFieldType, null)); 
         Assert 
                 .assertEquals(GenericParent.class, TypeUtils.getRawType(integerParentFieldType, 
                         null)); 
         Assert.assertEquals(List.class, TypeUtils.getRawType(foosFieldType, null)); 
         Assert.assertEquals(String.class, TypeUtils.getRawType(genericParentT, 
                 StringParameterizedChild.class)); 
         Assert.assertEquals(String.class, TypeUtils.getRawType(genericParentT, 
                 stringParentFieldType)); 
         Assert.assertEquals(Foo.class, TypeUtils.getRawType(Iterable.class.getTypeParameters()[0], 
                 foosFieldType)); 
         Assert.assertEquals(Foo.class, TypeUtils.getRawType(List.class.getTypeParameters()[0], 
                 foosFieldType)); 
         Assert.assertNull(TypeUtils.getRawType(genericParentT, GenericParent.class)); 
         Assert.assertEquals(GenericParent[].class, TypeUtils.getRawType(GenericTypeHolder.class 
                 .getDeclaredField("barParents").getGenericType(), null)); 
     }
@Test
public void testGetRawType10795() throws SecurityException, NoSuchFieldException { 
         final Type stringParentFieldType = GenericTypeHolder.class.getDeclaredField("stringParent") 
                 .getGenericType(); 
         final Type integerParentFieldType = GenericTypeHolder.class.getDeclaredField("integerParent") 
                 .getGenericType(); 
         final Type foosFieldType = GenericTypeHolder.class.getDeclaredField("foos").getGenericType(); 
         final Type genericParentT = GenericParent.class.getTypeParameters()[0]; 
         Assert.assertEquals(GenericParent.class, TypeUtils.getRawType(stringParentFieldType, null)); 
         Assert 
                 .assertEquals(GenericParent.class, TypeUtils.getRawType(integerParentFieldType, 
                         null)); 
         Assert.assertEquals(List.class, TypeUtils.getRawType(foosFieldType, null)); 
         Assert.assertEquals(String.class, TypeUtils.getRawType(genericParentT, 
                 StringParameterizedChild.class)); 
         Assert.assertEquals(String.class, TypeUtils.getRawType(genericParentT, 
                 stringParentFieldType)); 
         Assert.assertEquals(Foo.class, TypeUtils.getRawType(Iterable.class.getTypeParameters()[0], 
                 foosFieldType)); 
         Assert.assertEquals(Foo.class, TypeUtils.getRawType(List.class.getTypeParameters()[0], 
                 foosFieldType)); 
         Assert.assertNull(TypeUtils.getRawType(genericParentT, GenericParent.class)); 
         Assert.assertEquals(GenericParent[].class, TypeUtils.getRawType(GenericTypeHolder.class 
                 .getDeclaredField("barParents").getGenericType(), null)); 
     }
@Test
public void testGetRawType10796() throws SecurityException, NoSuchFieldException { 
         final Type stringParentFieldType = GenericTypeHolder.class.getDeclaredField("stringParent") 
                 .getGenericType(); 
         final Type integerParentFieldType = GenericTypeHolder.class.getDeclaredField("integerParent") 
                 .getGenericType(); 
         final Type foosFieldType = GenericTypeHolder.class.getDeclaredField("foos").getGenericType(); 
         final Type genericParentT = GenericParent.class.getTypeParameters()[0]; 
         Assert.assertEquals(GenericParent.class, TypeUtils.getRawType(stringParentFieldType, null)); 
         Assert 
                 .assertEquals(GenericParent.class, TypeUtils.getRawType(integerParentFieldType, 
                         null)); 
         Assert.assertEquals(List.class, TypeUtils.getRawType(foosFieldType, null)); 
         Assert.assertEquals(String.class, TypeUtils.getRawType(genericParentT, 
                 StringParameterizedChild.class)); 
         Assert.assertEquals(String.class, TypeUtils.getRawType(genericParentT, 
                 stringParentFieldType)); 
         Assert.assertEquals(Foo.class, TypeUtils.getRawType(Iterable.class.getTypeParameters()[0], 
                 foosFieldType)); 
         Assert.assertEquals(Foo.class, TypeUtils.getRawType(List.class.getTypeParameters()[0], 
                 foosFieldType)); 
         Assert.assertNull(TypeUtils.getRawType(genericParentT, GenericParent.class)); 
         Assert.assertEquals(GenericParent[].class, TypeUtils.getRawType(GenericTypeHolder.class 
                 .getDeclaredField("barParents").getGenericType(), null)); 
     }
@Test
public void testGetRawType10797() throws SecurityException, NoSuchFieldException { 
         final Type stringParentFieldType = GenericTypeHolder.class.getDeclaredField("stringParent") 
                 .getGenericType(); 
         final Type integerParentFieldType = GenericTypeHolder.class.getDeclaredField("integerParent") 
                 .getGenericType(); 
         final Type foosFieldType = GenericTypeHolder.class.getDeclaredField("foos").getGenericType(); 
         final Type genericParentT = GenericParent.class.getTypeParameters()[0]; 
         Assert.assertEquals(GenericParent.class, TypeUtils.getRawType(stringParentFieldType, null)); 
         Assert 
                 .assertEquals(GenericParent.class, TypeUtils.getRawType(integerParentFieldType, 
                         null)); 
         Assert.assertEquals(List.class, TypeUtils.getRawType(foosFieldType, null)); 
         Assert.assertEquals(String.class, TypeUtils.getRawType(genericParentT, 
                 StringParameterizedChild.class)); 
         Assert.assertEquals(String.class, TypeUtils.getRawType(genericParentT, 
                 stringParentFieldType)); 
         Assert.assertEquals(Foo.class, TypeUtils.getRawType(Iterable.class.getTypeParameters()[0], 
                 foosFieldType)); 
         Assert.assertEquals(Foo.class, TypeUtils.getRawType(List.class.getTypeParameters()[0], 
                 foosFieldType)); 
         Assert.assertNull(TypeUtils.getRawType(genericParentT, GenericParent.class)); 
         Assert.assertEquals(GenericParent[].class, TypeUtils.getRawType(GenericTypeHolder.class 
                 .getDeclaredField("barParents").getGenericType(), null)); 
     }
@Test
public void testGetRawType10798() throws SecurityException, NoSuchFieldException { 
         final Type stringParentFieldType = GenericTypeHolder.class.getDeclaredField("stringParent") 
                 .getGenericType(); 
         final Type integerParentFieldType = GenericTypeHolder.class.getDeclaredField("integerParent") 
                 .getGenericType(); 
         final Type foosFieldType = GenericTypeHolder.class.getDeclaredField("foos").getGenericType(); 
         final Type genericParentT = GenericParent.class.getTypeParameters()[0]; 
         Assert.assertEquals(GenericParent.class, TypeUtils.getRawType(stringParentFieldType, null)); 
         Assert 
                 .assertEquals(GenericParent.class, TypeUtils.getRawType(integerParentFieldType, 
                         null)); 
         Assert.assertEquals(List.class, TypeUtils.getRawType(foosFieldType, null)); 
         Assert.assertEquals(String.class, TypeUtils.getRawType(genericParentT, 
                 StringParameterizedChild.class)); 
         Assert.assertEquals(String.class, TypeUtils.getRawType(genericParentT, 
                 stringParentFieldType)); 
         Assert.assertEquals(Foo.class, TypeUtils.getRawType(Iterable.class.getTypeParameters()[0], 
                 foosFieldType)); 
         Assert.assertEquals(Foo.class, TypeUtils.getRawType(List.class.getTypeParameters()[0], 
                 foosFieldType)); 
         Assert.assertNull(TypeUtils.getRawType(genericParentT, GenericParent.class)); 
         Assert.assertEquals(GenericParent[].class, TypeUtils.getRawType(GenericTypeHolder.class 
                 .getDeclaredField("barParents").getGenericType(), null)); 
     }
@Test
public void testGetRawType10799() throws SecurityException, NoSuchFieldException { 
         final Type stringParentFieldType = GenericTypeHolder.class.getDeclaredField("stringParent") 
                 .getGenericType(); 
         final Type integerParentFieldType = GenericTypeHolder.class.getDeclaredField("integerParent") 
                 .getGenericType(); 
         final Type foosFieldType = GenericTypeHolder.class.getDeclaredField("foos").getGenericType(); 
         final Type genericParentT = GenericParent.class.getTypeParameters()[0]; 
         Assert.assertEquals(GenericParent.class, TypeUtils.getRawType(stringParentFieldType, null)); 
         Assert 
                 .assertEquals(GenericParent.class, TypeUtils.getRawType(integerParentFieldType, 
                         null)); 
         Assert.assertEquals(List.class, TypeUtils.getRawType(foosFieldType, null)); 
         Assert.assertEquals(String.class, TypeUtils.getRawType(genericParentT, 
                 StringParameterizedChild.class)); 
         Assert.assertEquals(String.class, TypeUtils.getRawType(genericParentT, 
                 stringParentFieldType)); 
         Assert.assertEquals(Foo.class, TypeUtils.getRawType(Iterable.class.getTypeParameters()[0], 
                 foosFieldType)); 
         Assert.assertEquals(Foo.class, TypeUtils.getRawType(List.class.getTypeParameters()[0], 
                 foosFieldType)); 
         Assert.assertNull(TypeUtils.getRawType(genericParentT, GenericParent.class)); 
         Assert.assertEquals(GenericParent[].class, TypeUtils.getRawType(GenericTypeHolder.class 
                 .getDeclaredField("barParents").getGenericType(), null)); 
     }
@Test
public void testGetRawType10800() throws SecurityException, NoSuchFieldException { 
         final Type stringParentFieldType = GenericTypeHolder.class.getDeclaredField("stringParent") 
                 .getGenericType(); 
         final Type integerParentFieldType = GenericTypeHolder.class.getDeclaredField("integerParent") 
                 .getGenericType(); 
         final Type foosFieldType = GenericTypeHolder.class.getDeclaredField("foos").getGenericType(); 
         final Type genericParentT = GenericParent.class.getTypeParameters()[0]; 
         Assert.assertEquals(GenericParent.class, TypeUtils.getRawType(stringParentFieldType, null)); 
         Assert 
                 .assertEquals(GenericParent.class, TypeUtils.getRawType(integerParentFieldType, 
                         null)); 
         Assert.assertEquals(List.class, TypeUtils.getRawType(foosFieldType, null)); 
         Assert.assertEquals(String.class, TypeUtils.getRawType(genericParentT, 
                 StringParameterizedChild.class)); 
         Assert.assertEquals(String.class, TypeUtils.getRawType(genericParentT, 
                 stringParentFieldType)); 
         Assert.assertEquals(Foo.class, TypeUtils.getRawType(Iterable.class.getTypeParameters()[0], 
                 foosFieldType)); 
         Assert.assertEquals(Foo.class, TypeUtils.getRawType(List.class.getTypeParameters()[0], 
                 foosFieldType)); 
         Assert.assertNull(TypeUtils.getRawType(genericParentT, GenericParent.class)); 
         Assert.assertEquals(GenericParent[].class, TypeUtils.getRawType(GenericTypeHolder.class 
                 .getDeclaredField("barParents").getGenericType(), null)); 
     }
@Test
public void testIsInstance10801() throws SecurityException, NoSuchFieldException { 
         final Type intComparableType = getClass().getField("intComparable").getGenericType(); 
         final Type uriComparableType = getClass().getField("uriComparable").getGenericType(); 
         intComparable = 1; 
         Assert.assertTrue(TypeUtils.isInstance(1, intComparableType)); 
         // uriComparable = 1; 
         Assert.assertFalse(TypeUtils.isInstance(1, uriComparableType)); 
     }
@Test
public void testGetRawType10802() throws SecurityException, NoSuchFieldException { 
         final Type stringParentFieldType = GenericTypeHolder.class.getDeclaredField("stringParent") 
                 .getGenericType(); 
         final Type integerParentFieldType = GenericTypeHolder.class.getDeclaredField("integerParent") 
                 .getGenericType(); 
         final Type foosFieldType = GenericTypeHolder.class.getDeclaredField("foos").getGenericType(); 
         final Type genericParentT = GenericParent.class.getTypeParameters()[0]; 
         Assert.assertEquals(GenericParent.class, TypeUtils.getRawType(stringParentFieldType, null)); 
         Assert 
                 .assertEquals(GenericParent.class, TypeUtils.getRawType(integerParentFieldType, 
                         null)); 
         Assert.assertEquals(List.class, TypeUtils.getRawType(foosFieldType, null)); 
         Assert.assertEquals(String.class, TypeUtils.getRawType(genericParentT, 
                 StringParameterizedChild.class)); 
         Assert.assertEquals(String.class, TypeUtils.getRawType(genericParentT, 
                 stringParentFieldType)); 
         Assert.assertEquals(Foo.class, TypeUtils.getRawType(Iterable.class.getTypeParameters()[0], 
                 foosFieldType)); 
         Assert.assertEquals(Foo.class, TypeUtils.getRawType(List.class.getTypeParameters()[0], 
                 foosFieldType)); 
         Assert.assertNull(TypeUtils.getRawType(genericParentT, GenericParent.class)); 
         Assert.assertEquals(GenericParent[].class, TypeUtils.getRawType(GenericTypeHolder.class 
                 .getDeclaredField("barParents").getGenericType(), null)); 
     }
@Test
public void testIsInstance10803() throws SecurityException, NoSuchFieldException { 
         final Type intComparableType = getClass().getField("intComparable").getGenericType(); 
         final Type uriComparableType = getClass().getField("uriComparable").getGenericType(); 
         intComparable = 1; 
         Assert.assertTrue(TypeUtils.isInstance(1, intComparableType)); 
         // uriComparable = 1; 
         Assert.assertFalse(TypeUtils.isInstance(1, uriComparableType)); 
     }
@Test
public void testIsAssignable12127() throws SecurityException, NoSuchFieldException { 
         final Type intComparableType = getClass().getField("intComparable").getGenericType(); 
         final Type uriComparableType = getClass().getField("uriComparable").getGenericType(); 
         intComparable = 1; 
         Assert.assertTrue(TypeUtils.isAssignable(1, intComparableType)); 
         // uriComparable = 1; 
         Assert.assertFalse(TypeUtils.isAssignable(1, uriComparableType)); 
     }
@Test
public void testIsInstance12128() throws SecurityException, NoSuchFieldException { 
         final Type intComparableType = getClass().getField("intComparable").getGenericType(); 
         final Type uriComparableType = getClass().getField("uriComparable").getGenericType(); 
         intComparable = 1; 
         Assert.assertTrue(TypeUtils.isInstance(1, intComparableType)); 
         // uriComparable = 1; 
         Assert.assertFalse(TypeUtils.isInstance(1, uriComparableType)); 
     }
@Test
public void testIsAssignable12129() throws SecurityException, NoSuchFieldException { 
         final Type intComparableType = getClass().getField("intComparable").getGenericType(); 
         final Type uriComparableType = getClass().getField("uriComparable").getGenericType(); 
         intComparable = 1; 
         Assert.assertTrue(TypeUtils.isAssignable(1, intComparableType)); 
         // uriComparable = 1; 
         Assert.assertFalse(TypeUtils.isAssignable(1, uriComparableType)); 
     }
@Test
public void testIsInstance12131() throws SecurityException, NoSuchFieldException { 
         final Type intComparableType = getClass().getField("intComparable").getGenericType(); 
         final Type uriComparableType = getClass().getField("uriComparable").getGenericType(); 
         intComparable = 1; 
         Assert.assertTrue(TypeUtils.isInstance(1, intComparableType)); 
         // uriComparable = 1; 
         Assert.assertFalse(TypeUtils.isInstance(1, uriComparableType)); 
     }
@Test
public void testIsAssignable12132() throws SecurityException, NoSuchFieldException { 
         final Type intComparableType = getClass().getField("intComparable").getGenericType(); 
         final Type uriComparableType = getClass().getField("uriComparable").getGenericType(); 
         intComparable = 1; 
         Assert.assertTrue(TypeUtils.isAssignable(1, intComparableType)); 
         // uriComparable = 1; 
         Assert.assertFalse(TypeUtils.isAssignable(1, uriComparableType)); 
     }
@Test
public void testIsInstance12133() throws SecurityException, NoSuchFieldException { 
         final Type intComparableType = getClass().getField("intComparable").getGenericType(); 
         final Type uriComparableType = getClass().getField("uriComparable").getGenericType(); 
         intComparable = 1; 
         Assert.assertTrue(TypeUtils.isInstance(1, intComparableType)); 
         // uriComparable = 1; 
         Assert.assertFalse(TypeUtils.isInstance(1, uriComparableType)); 
     }
@Test
public void testGetImplicitUpperBounds12134() { 
         final WildcardType wildcardType = EasyMock.createMock(WildcardType.class); 
         final Type[] expectedArray = {String.class}; 
         final Type[] actualArray = TypeUtils.getImplicitUpperBounds(wildcardType); 
         assertEquals(expectedArray.length, actualArray.length); 
         assertEquals(expectedArray[0], actualArray[0]); 
         assertEquals(expectedArray[1], actualArray[1]); 
         assertEquals(expectedArray[2], actualArray[2]); 
         assertEquals(expectedArray[3], actualArray[3]); 
         assertEquals(expectedArray[4], actualArray[4]); 
         assertEquals(expectedArray[5], actualArray[5]); 
         assertEquals(expectedArray[6], actualArray[6]); 
         assertEquals(expectedArray[7], actualArray[7]); 
         assertEquals(expectedArray[8], actualArray[8]); 
         assertEquals(expectedArray[9], actualArray[9]); 
         assertEquals(expectedArray[10], actualArray[10]); 
         assertEquals(expectedArray[11], actualArray[11]); 
         assertEquals(expectedArray[12], actualArray[12]); 
         assertEquals(expectedArray[13], actualArray[13]); 
         assertEquals(expectedArray[14], actualArray[14]); 
         assertEquals(expectedArray[15], actualArray[15]); 
     }
@Test
public void testIsInstance12135() throws SecurityException, NoSuchFieldException { 
         final Type intComparableType = getClass().getField("intComparable").getGenericType(); 
         final Type uriComparableType = getClass().getField("uriComparable").getGenericType(); 
         intComparable = 1; 
         Assert.assertTrue(TypeUtils.isInstance(1, intComparableType)); 
         // uriComparable = 1; 
         Assert.assertFalse(TypeUtils.isInstance(1, uriComparableType)); 
     }
@Test
public void testIsAssignable12136() throws SecurityException, NoSuchFieldException { 
         final Type intComparableType = getClass().getField("intComparable").getGenericType(); 
         final Type uriComparableType = getClass().getField("uriComparable").getGenericType(); 
         intComparable = 1; 
         Assert.assertTrue(TypeUtils.isAssignable(1, intComparableType)); 
         // uriComparable = 1; 
         Assert.assertFalse(TypeUtils.isAssignable(1, uriComparableType)); 
     }
@Test
public void testIsAssignable12137() throws SecurityException, NoSuchFieldException { 
         final Type intComparableType = getClass().getField("intComparable").getGenericType(); 
         final Type uriComparableType = getClass().getField("uriComparable").getGenericType(); 
         intComparable = 1; 
         Assert.assertTrue(TypeUtils.isAssignable(1, intComparableType)); 
         // uriComparable = 1; 
         Assert.assertFalse(TypeUtils.isAssignable(1, uriComparableType)); 
     }
@Test
public void testGetImplicitUpperBounds12138() { 
         final WildcardType wildcardType = EasyMock.createMock(WildcardType.class); 
         final Type[] expectedArray = {String.class}; 
         Assert.assertArrayEquals(expectedArray, TypeUtils.getImplicitUpperBounds(wildcardType)); 
         EasyMock.replay(wildcardType); 
         final Type[] actualArray = TypeUtils.getImplicitUpperBounds(wildcardType); 
         Assert.assertArrayEquals(expectedArray, actualArray); 
         EasyMock.verify(wildcardType); 
     }
@Test
public void testIsAssignable12139() throws SecurityException, NoSuchFieldException { 
         final Type intComparableType = getClass().getField("intComparable").getGenericType(); 
         final Type uriComparableType = getClass().getField("uriComparable").getGenericType(); 
         intComparable = 1; 
         Assert.assertTrue(TypeUtils.isAssignable(1, intComparableType)); 
         // uriComparable = 1; 
         Assert.assertFalse(TypeUtils.isAssignable(1, uriComparableType)); 
     }
@Test
public void testIsInstance12140() throws SecurityException, NoSuchFieldException { 
         final Type intComparableType = getClass().getField("intComparable").getGenericType(); 
         final Type uriComparableType = getClass().getField("uriComparable").getGenericType(); 
         intComparable = 1; 
         Assert.assertTrue(TypeUtils.isInstance(1, intComparableType)); 
         // uriComparable = 1; 
         Assert.assertFalse(TypeUtils.isInstance(1, uriComparableType)); 
     }
@Test
public void testLang82012141() throws Exception { 
         final Type[] typeArray = {String.class, String.class}; 
         final Type[] expectedArray = {String.class}; 
         Assert.assertArrayEquals(expectedArray, TypeUtils.normalizeUpperBounds(typeArray)); 
     }
@Test
public void testIsAssignable12142() throws SecurityException, NoSuchFieldException { 
         final Type intComparableType = getClass().getField("intComparable").getGenericType(); 
         final Type uriComparableType = getClass().getField("uriComparable").getGenericType(); 
         intComparable = 1; 
         Assert.assertTrue(TypeUtils.isAssignable(1, intComparableType)); 
         // uriComparable = 1; 
         Assert.assertFalse(TypeUtils.isAssignable(1, uriComparableType)); 
     }
@Test
public void testIsAssignable12143() throws SecurityException, NoSuchFieldException { 
         final Type intComparableType = getClass().getField("intComparable").getGenericType(); 
         final Type uriComparableType = getClass().getField("uriComparable").getGenericType(); 
         intComparable = 1; 
         Assert.assertTrue(TypeUtils.isAssignable(1, intComparableType)); 
         // uriComparable = 1; 
         Assert.assertFalse(TypeUtils.isAssignable(1, uriComparableType)); 
     }
@Test
public void testIsAssignable12144() throws SecurityException, NoSuchFieldException { 
         final Type intComparableType = getClass().getField("intComparable").getGenericType(); 
         final Type uriComparableType = getClass().getField("uriComparable").getGenericType(); 
         intComparable = 1; 
         Assert.assertTrue(TypeUtils.isAssignable(1, intComparableType)); 
         // uriComparable = 1; 
         Assert.assertFalse(TypeUtils.isAssignable(1, uriComparableType)); 
     }
@Test
public void testIsInstance12145() throws SecurityException, NoSuchFieldException { 
         final Type intComparableType = getClass().getField("intComparable").getGenericType(); 
         final Type uriComparableType = getClass().getField("uriComparable").getGenericType(); 
         intComparable = 1; 
         Assert.assertTrue(TypeUtils.isInstance(1, intComparableType)); 
         // uriComparable = 1; 
         Assert.assertFalse(TypeUtils.isInstance(1, uriComparableType)); 
     }
@Test
public void testIsInstance12146() throws SecurityException, NoSuchFieldException { 
         final Type intComparableType = getClass().getField("intComparable").getGenericType(); 
         final Type uriComparableType = getClass().getField("uriComparable").getGenericType(); 
         intComparable = 1; 
         Assert.assertTrue(TypeUtils.isInstance(1, intComparableType)); 
         // uriComparable = 1; 
         Assert.assertFalse(TypeUtils.isInstance(1, uriComparableType)); 
     }
@Test
public void testGetImplicitLowerBounds12147() throws SecurityException, NoSuchFieldException { 
         final Type stringParentFieldType = GenericTypeHolder.class.getDeclaredField("stringParent") 
                 .getGenericType(); 
         final Type integerParentFieldType = GenericTypeHolder.class.getDeclaredField("integerParent") 
                 .getGenericType(); 
         final Type foosFieldType = GenericTypeHolder.class.getDeclaredField("foos").getGenericType(); 
         final Type genericParentT = GenericParent.class.getTypeParameters()[0]; 
         Assert.assertNull(TypeUtils.getImplicitLowerBounds(stringParentFieldType)); 
         Assert.assertNull(TypeUtils.getImplicitLowerBounds(integerParentFieldType)); 
         Assert.assertEquals(GenericParent.class, TypeUtils.getImplicitLowerBounds(foosFieldType)); 
         Assert.assertEquals(String.class, TypeUtils.getImplicitLowerBounds(genericParentT)); 
         Assert.assertEquals(Foo.class, TypeUtils.getImplicitLowerBounds(genericParentT)); 
     }
@Test
public void testIsAssignable12148() throws SecurityException, NoSuchFieldException { 
         final Type intComparableType = getClass().getField("intComparable").getGenericType(); 
         final Type uriComparableType = getClass().getField("uriComparable").getGenericType(); 
         intComparable = 1; 
         Assert.assertTrue(TypeUtils.isAssignable(1, intComparableType)); 
         // uriComparable = 1; 
         Assert.assertFalse(TypeUtils.isAssignable(1, uriComparableType)); 
     }
@Test
public void testIsInstance12149() throws SecurityException, NoSuchFieldException { 
         final Type intComparableType = getClass().getField("intComparable").getGenericType(); 
         final Type uriComparableType = getClass().getField("uriComparable").getGenericType(); 
         intComparable = 1; 
         Assert.assertTrue(TypeUtils.isInstance(1, intComparableType)); 
         // uriComparable = 1; 
         Assert.assertFalse(TypeUtils.isInstance(1, uriComparableType)); 
     }
@Test
public void testDetermineTypeVariableAssignments12150() throws SecurityException, 
             NoSuchFieldException, NoSuchMethodException { 
         final ParameterizedType iterableType = (ParameterizedType) getClass().getField("iterable") 
                 .getGenericType(); 
         final Map<TypeVariable<?>, Type> typeVarAssigns = TypeUtils.determineTypeArguments(TreeSet.class, 
                 iterableType); 
         final TypeVariable<?> treeSetTypeVar = TreeSet.class.getTypeParameters()[0]; 
         Assert.assertTrue(typeVarAssigns.containsKey(treeSetTypeVar)); 
         Assert.assertEquals(iterableType.getActualTypeArguments()[0], typeVarAssigns 
                 .get(treeSetTypeVar)); 
     }
@Test
public void testIsInstance12151() throws SecurityException, NoSuchFieldException { 
         final Type intComparableType = getClass().getField("intComparable").getGenericType(); 
         final Type uriComparableType = getClass().getField("uriComparable").getGenericType(); 
         intComparable = 1; 
         Assert.assertTrue(TypeUtils.isInstance(1, intComparableType)); 
         // uriComparable = 1; 
         Assert.assertFalse(TypeUtils.isInstance(1, uriComparableType)); 
     }
@Test
public void testIsInstance12152() throws SecurityException, NoSuchFieldException { 
         final Type intComparableType = getClass().getField("intComparable").getGenericType(); 
         final Type uriComparableType = getClass().getField("uriComparable").getGenericType(); 
         intComparable = 1; 
         Assert.assertTrue(TypeUtils.isInstance(1, intComparableType)); 
         // uriComparable = 1; 
         Assert.assertFalse(TypeUtils.isInstance(1, uriComparableType)); 
     }
@Test
public void testLang82012153() throws Exception { 
         final Type[] typeArray = {String.class, String.class}; 
         final Type[] expectedArray = {String.class}; 
         Assert.assertArrayEquals(expectedArray, TypeUtils.normalizeUpperBounds(typeArray)); 
     }
@Test
public void testIsInstance12154() throws SecurityException, NoSuchFieldException { 
         final Type intComparableType = getClass().getField("intComparable").getGenericType(); 
         final Type uriComparableType = getClass().getField("uriComparable").getGenericType(); 
         intComparable = 1; 
         Assert.assertTrue(TypeUtils.isInstance(1, intComparableType)); 
         // uriComparable = 1; 
         Assert.assertFalse(TypeUtils.isInstance(1, uriComparableType)); 
     }
@Test
public void testIsAssignable12155() throws SecurityException, NoSuchFieldException { 
         final Type intComparableType = getClass().getField("intComparable").getGenericType(); 
         final Type uriComparableType = getClass().getField("uriComparable").getGenericType(); 
         intComparable = 1; 
         Assert.assertTrue(TypeUtils.isAssignable(1, intComparableType)); 
         // uriComparable = 1; 
         Assert.assertFalse(TypeUtils.isAssignable(1, uriComparableType)); 
     }
@Test
public void testIsInstance12156() throws SecurityException, NoSuchFieldException { 
         final Type intComparableType = getClass().getField("intComparable").getGenericType(); 
         final Type uriComparableType = getClass().getField("uriComparable").getGenericType(); 
         intComparable = 1; 
         Assert.assertTrue(TypeUtils.isInstance(1, intComparableType)); 
         // uriComparable = 1; 
         Assert.assertFalse(TypeUtils.isInstance(1, uriComparableType)); 
     }
@Test
public void testLang82012157() throws Exception { 
         final Type[] typeArray = {String.class, String.class}; 
         final Type[] expectedArray = {String.class}; 
         Assert.assertArrayEquals(expectedArray, TypeUtils.normalizeUpperBounds(typeArray)); 
     }
@Test
public void testIsInstance12158() throws SecurityException, NoSuchFieldException { 
         final Type intComparableType = getClass().getField("intComparable").getGenericType(); 
         final Type uriComparableType = getClass().getField("uriComparable").getGenericType(); 
         intComparable = 1; 
         Assert.assertTrue(TypeUtils.isInstance(1, intComparableType)); 
         // uriComparable = 1; 
         Assert.assertFalse(TypeUtils.isInstance(1, uriComparableType)); 
     }
@Test
public void testIsInstance12159() throws SecurityException, NoSuchFieldException { 
         final Type intComparableType = getClass().getField("intComparable").getGenericType(); 
         final Type uriComparableType = getClass().getField("uriComparable").getGenericType(); 
         intComparable = 1; 
         Assert.assertTrue(TypeUtils.isInstance(1, intComparableType)); 
         // uriComparable = 1; 
         Assert.assertFalse(TypeUtils.isInstance(1, uriComparableType)); 
     }
@Test
public void testIsInstance12160() throws SecurityException, NoSuchFieldException { 
         final Type intComparableType = getClass().getField("intComparable").getGenericType(); 
         final Type uriComparableType = getClass().getField("uriComparable").getGenericType(); 
         intComparable = 1; 
         Assert.assertTrue(TypeUtils.isInstance(1, intComparableType)); 
         // uriComparable = 1; 
         Assert.assertFalse(TypeUtils.isInstance(1, uriComparableType)); 
     }
@Test
public void testIsAssignable12161() throws SecurityException, NoSuchFieldException { 
         final Type intComparableType = getClass().getField("intComparable").getGenericType(); 
         final Type uriComparableType = getClass().getField("uriComparable").getGenericType(); 
         intComparable = 1; 
         Assert.assertTrue(TypeUtils.isAssignable(1, intComparableType)); 
         // uriComparable = 1; 
         Assert.assertFalse(TypeUtils.isAssignable(1, uriComparableType)); 
     }
@Test
public void testIsAssignable12162() throws SecurityException, NoSuchFieldException { 
         final Type intComparableType = getClass().getField("intComparable").getGenericType(); 
         final Type uriComparableType = getClass().getField("uriComparable").getGenericType(); 
         intComparable = 1; 
         Assert.assertTrue(TypeUtils.isAssignable(1, intComparableType)); 
         // uriComparable = 1; 
         Assert.assertFalse(TypeUtils.isAssignable(1, uriComparableType)); 
     }
@Test
public void testIsInstance12163() throws SecurityException, NoSuchFieldException { 
         final Type intComparableType = getClass().getField("intComparable").getGenericType(); 
         final Type uriComparableType = getClass().getField("uriComparable").getGenericType(); 
         intComparable = 1; 
         Assert.assertTrue(TypeUtils.isInstance(1, intComparableType)); 
         // uriComparable = 1; 
         Assert.assertFalse(TypeUtils.isInstance(1, uriComparableType)); 
     }
@Test
public void testIsInstance12164() throws SecurityException, NoSuchFieldException { 
         final Type intComparableType = getClass().getField("intComparable").getGenericType(); 
         final Type uriComparableType = getClass().getField("uriComparable").getGenericType(); 
         intComparable = 1; 
         Assert.assertTrue(TypeUtils.isInstance(1, intComparableType)); 
         // uriComparable = 1; 
         Assert.assertFalse(TypeUtils.isInstance(1, uriComparableType)); 
     }
@Test
public void testIsAssignable12165() throws SecurityException, NoSuchFieldException { 
         final Type intComparableType = getClass().getField("intComparable").getGenericType(); 
         final Type uriComparableType = getClass().getField("uriComparable").getGenericType(); 
         intComparable = 1; 
         Assert.assertTrue(TypeUtils.isAssignable(1, intComparableType)); 
         // uriComparable = 1; 
         Assert.assertFalse(TypeUtils.isAssignable(1, uriComparableType)); 
     }
@Test
public void testIsInstance12166() throws SecurityException, NoSuchFieldException { 
         final Type intComparableType = getClass().getField("intComparable").getGenericType(); 
         final Type uriComparableType = getClass().getField("uriComparable").getGenericType(); 
         intComparable = 1; 
         Assert.assertTrue(TypeUtils.isInstance(1, intComparableType)); 
         // uriComparable = 1; 
         Assert.assertFalse(TypeUtils.isInstance(1, uriComparableType)); 
     }
@Test
public void testIsAssignable12167() throws SecurityException, NoSuchFieldException { 
         final Type intComparableType = getClass().getField("intComparable").getGenericType(); 
         final Type uriComparableType = getClass().getField("uriComparable").getGenericType(); 
         intComparable = 1; 
         Assert.assertTrue(TypeUtils.isAssignable(1, intComparableType)); 
         // uriComparable = 1; 
         Assert.assertFalse(TypeUtils.isAssignable(1, uriComparableType)); 
     }
@Test
public void testIsAssignable12168() throws SecurityException, NoSuchFieldException { 
         final Type intComparableType = getClass().getField("intComparable").getGenericType(); 
         final Type uriComparableType = getClass().getField("uriComparable").getGenericType(); 
         intComparable = 1; 
         Assert.assertTrue(TypeUtils.isAssignable(1, intComparableType)); 
         // uriComparable = 1; 
         Assert.assertFalse(TypeUtils.isAssignable(1, uriComparableType)); 
     }
@Test
public void testIsAssignable12169() throws SecurityException, NoSuchFieldException { 
         final Type intComparableType = getClass().getField("intComparable").getGenericType(); 
         final Type uriComparableType = getClass().getField("uriComparable").getGenericType(); 
         intComparable = 1; 
         Assert.assertTrue(TypeUtils.isAssignable(1, intComparableType)); 
         // uriComparable = 1; 
         Assert.assertFalse(TypeUtils.isAssignable(1, uriComparableType)); 
     }
@Test
public void testDetermineTypeVariableAssignments12170() throws SecurityException, 
             NoSuchFieldException, NoSuchMethodException { 
         final ParameterizedType iterableType = (ParameterizedType) getClass().getField("iterable") 
                 .getGenericType(); 
         final Map<TypeVariable<?>, Type> typeVarAssigns = TypeUtils.determineTypeArguments(TreeSet.class, 
                 iterableType); 
         final TypeVariable<?> treeSetTypeVar = TreeSet.class.getTypeParameters()[0]; 
         Assert.assertTrue(typeVarAssigns.containsKey(treeSetTypeVar)); 
         Assert.assertEquals(iterableType.getActualTypeArguments()[0], typeVarAssigns 
                 .get(treeSetTypeVar)); 
     }
@Test
public void testDetermineTypeVariableAssignments12171() throws SecurityException, 
             NoSuchFieldException, NoSuchMethodException { 
         final ParameterizedType iterableType = (ParameterizedType) getClass().getField("iterable") 
                 .getGenericType(); 
         final Map<TypeVariable<?>, Type> typeVarAssigns = TypeUtils.determineTypeArguments(TreeSet.class, 
                 iterableType); 
         final TypeVariable<?> treeSetTypeVar = TreeSet.class.getTypeParameters()[0]; 
         Assert.assertTrue(typeVarAssigns.containsKey(treeSetTypeVar)); 
         Assert.assertEquals(iterableType.getActualTypeArguments()[0], typeVarAssigns 
                 .get(treeSetTypeVar)); 
     }
@Test
public void testIsAssignable12172() throws SecurityException, NoSuchFieldException { 
         final Type intComparableType = getClass().getField("intComparable").getGenericType(); 
         final Type uriComparableType = getClass().getField("uriComparable").getGenericType(); 
         intComparable = 1; 
         Assert.assertTrue(TypeUtils.isAssignable(1, intComparableType)); 
         // uriComparable = 1; 
         Assert.assertFalse(TypeUtils.isAssignable(1, uriComparableType)); 
     }
@Test
public void testIsInstance12173() throws SecurityException, NoSuchFieldException { 
         final Type intComparableType = getClass().getField("intComparable").getGenericType(); 
         final Type uriComparableType = getClass().getField("uriComparable").getGenericType(); 
         intComparable = 1; 
         Assert.assertTrue(TypeUtils.isInstance(1, intComparableType)); 
         // uriComparable = 1; 
         Assert.assertFalse(TypeUtils.isInstance(1, uriComparableType)); 
     }
@Test
public void testIsInstance12174() throws SecurityException, NoSuchFieldException { 
         final Type intComparableType = getClass().getField("intComparable").getGenericType(); 
         final Type uriComparableType = getClass().getField("uriComparable").getGenericType(); 
         intComparable = 1; 
         Assert.assertTrue(TypeUtils.isInstance(1, intComparableType)); 
         // uriComparable = 1; 
         Assert.assertFalse(TypeUtils.isInstance(1, uriComparableType)); 
     }
@Test
public void testIsAssignable12175() throws SecurityException, NoSuchFieldException { 
         final Type intComparableType = getClass().getField("intComparable").getGenericType(); 
         final Type uriComparableType = getClass().getField("uriComparable").getGenericType(); 
         intComparable = 1; 
         Assert.assertTrue(TypeUtils.isAssignable(1, intComparableType)); 
         // uriComparable = 1; 
         Assert.assertFalse(TypeUtils.isAssignable(1, uriComparableType)); 
     }
@Test
public void testIsInstance12176() throws SecurityException, NoSuchFieldException { 
         final Type intComparableType = getClass().getField("intComparable").getGenericType(); 
         final Type uriComparableType = getClass().getField("uriComparable").getGenericType(); 
         intComparable = 1; 
         Assert.assertTrue(TypeUtils.isInstance(1, intComparableType)); 
         // uriComparable = 1; 
         Assert.assertFalse(TypeUtils.isInstance(1, uriComparableType)); 
     }
@Test
public void testIsAssignable12178() throws SecurityException, NoSuchFieldException { 
         final Type intComparableType = getClass().getField("intComparable").getGenericType(); 
         final Type uriComparableType = getClass().getField("uriComparable").getGenericType(); 
         intComparable = 1; 
         Assert.assertTrue(TypeUtils.isAssignable(1, intComparableType)); 
         // uriComparable = 1; 
         Assert.assertFalse(TypeUtils.isAssignable(1, uriComparableType)); 
     }
@Test
public void testIsAssignable12179() throws SecurityException, NoSuchFieldException { 
         final Type intComparableType = getClass().getField("intComparable").getGenericType(); 
         final Type uriComparableType = getClass().getField("uriComparable").getGenericType(); 
         intComparable = 1; 
         Assert.assertTrue(TypeUtils.isAssignable(1, intComparableType)); 
         // uriComparable = 1; 
         Assert.assertFalse(TypeUtils.isAssignable(1, uriComparableType)); 
     }
@Test
public void testIsAssignable12180() throws SecurityException, NoSuchFieldException { 
         final Type intComparableType = getClass().getField("intComparable").getGenericType(); 
         final Type uriComparableType = getClass().getField("uriComparable").getGenericType(); 
         intComparable = 1; 
         Assert.assertTrue(TypeUtils.isAssignable(1, intComparableType)); 
         // uriComparable = 1; 
         Assert.assertFalse(TypeUtils.isAssignable(1, uriComparableType)); 
     }
@Test
public void testIsInstance12181() throws SecurityException, NoSuchFieldException { 
         final Type intComparableType = getClass().getField("intComparable").getGenericType(); 
         final Type uriComparableType = getClass().getField("uriComparable").getGenericType(); 
         intComparable = 1; 
         Assert.assertTrue(TypeUtils.isInstance(1, intComparableType)); 
         // uriComparable = 1; 
         Assert.assertFalse(TypeUtils.isInstance(1, uriComparableType)); 
     }
@Test
public void testIsAssignable12182() throws SecurityException, NoSuchFieldException { 
         final Type intComparableType = getClass().getField("intComparable").getGenericType(); 
         final Type uriComparableType = getClass().getField("uriComparable").getGenericType(); 
         intComparable = 1; 
         Assert.assertTrue(TypeUtils.isAssignable(1, intComparableType)); 
         // uriComparable = 1; 
         Assert.assertFalse(TypeUtils.isAssignable(1, uriComparableType)); 
     }
@Test
public void testIsInstance12183() throws SecurityException, NoSuchFieldException { 
         final Type intComparableType = getClass().getField("intComparable").getGenericType(); 
         final Type uriComparableType = getClass().getField("uriComparable").getGenericType(); 
         intComparable = 1; 
         Assert.assertTrue(TypeUtils.isInstance(1, intComparableType)); 
         // uriComparable = 1; 
         Assert.assertFalse(TypeUtils.isInstance(1, uriComparableType)); 
     }
@Test
public void testIsAssignable12184() throws SecurityException, NoSuchFieldException { 
         final Type intComparableType = getClass().getField("intComparable").getGenericType(); 
         final Type uriComparableType = getClass().getField("uriComparable").getGenericType(); 
         intComparable = 1; 
         Assert.assertTrue(TypeUtils.isAssignable(1, intComparableType)); 
         // uriComparable = 1; 
         Assert.assertFalse(TypeUtils.isAssignable(1, uriComparableType)); 
     }
@Test
public void testIsAssignable12185() throws SecurityException, NoSuchFieldException { 
         final Type intComparableType = getClass().getField("intComparable").getGenericType(); 
         final Type uriComparableType = getClass().getField("uriComparable").getGenericType(); 
         intComparable = 1; 
         Assert.assertTrue(TypeUtils.isAssignable(1, intComparableType)); 
         // uriComparable = 1; 
         Assert.assertFalse(TypeUtils.isAssignable(1, uriComparableType)); 
     }
@Test
public void testIsAssignable12186() throws SecurityException, NoSuchFieldException { 
         final Type intComparableType = getClass().getField("intComparable").getGenericType(); 
         final Type uriComparableType = getClass().getField("uriComparable").getGenericType(); 
         intComparable = 1; 
         Assert.assertTrue(TypeUtils.isAssignable(1, intComparableType)); 
         // uriComparable = 1; 
         Assert.assertFalse(TypeUtils.isAssignable(1, uriComparableType)); 
     }
@Test
public void testIsAssignable12187() throws SecurityException, NoSuchFieldException { 
         final Type intComparableType = getClass().getField("intComparable").getGenericType(); 
         final Type uriComparableType = getClass().getField("uriComparable").getGenericType(); 
         intComparable = 1; 
         Assert.assertTrue(TypeUtils.isAssignable(1, intComparableType)); 
         // uriComparable = 1; 
         Assert.assertFalse(TypeUtils.isAssignable(1, uriComparableType)); 
     }
@Test
public void testIsInstance12188() throws SecurityException, NoSuchFieldException { 
         final Type intComparableType = getClass().getField("intComparable").getGenericType(); 
         final Type uriComparableType = getClass().getField("uriComparable").getGenericType(); 
         intComparable = 1; 
         Assert.assertTrue(TypeUtils.isInstance(1, intComparableType)); 
         // uriComparable = 1; 
         Assert.assertFalse(TypeUtils.isInstance(1, uriComparableType)); 
     }
@Test
public void testIsInstance12189() throws SecurityException, NoSuchFieldException { 
         final Type intComparableType = getClass().getField("intComparable").getGenericType(); 
         final Type uriComparableType = getClass().getField("uriComparable").getGenericType(); 
         intComparable = 1; 
         Assert.assertTrue(TypeUtils.isInstance(1, intComparableType)); 
         // uriComparable = 1; 
         Assert.assertFalse(TypeUtils.isInstance(1, uriComparableType)); 
     }
@Test
public void testIsInstance12190() throws SecurityException, NoSuchFieldException { 
         final Type intComparableType = getClass().getField("intComparable").getGenericType(); 
         final Type uriComparableType = getClass().getField("uriComparable").getGenericType(); 
         intComparable = 1; 
         Assert.assertTrue(TypeUtils.isInstance(1, intComparableType)); 
         // uriComparable = 1; 
         Assert.assertFalse(TypeUtils.isInstance(1, uriComparableType)); 
     }
    

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

    

    

//    @Test
//    public void testTypesSatisfyVariables() throws SecurityException, NoSuchFieldException,
//            NoSuchMethodException {
//        final Map<TypeVariable<?>, Type> typeVarAssigns = new HashMap<TypeVariable<?>, Type>();
//        final Integer max = TypeUtilsTest.stub();
//        typeVarAssigns.put(getClass().getMethod("stub").getTypeParameters()[0], Integer.class);
//        Assert.assertTrue(TypeUtils.typesSatisfyVariables(typeVarAssigns));
//        typeVarAssigns.clear();
//        typeVarAssigns.put(getClass().getMethod("stub2").getTypeParameters()[0], Integer.class);
//        Assert.assertTrue(TypeUtils.typesSatisfyVariables(typeVarAssigns));
//        typeVarAssigns.clear();
//        typeVarAssigns.put(getClass().getMethod("stub3").getTypeParameters()[0], Integer.class);
//        Assert.assertTrue(TypeUtils.typesSatisfyVariables(typeVarAssigns));
//    }

    

    

    

    

    

    

    

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
