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
public void testDetermineTypeVariableAssignments89() throws SecurityException, NoSuchFieldException, NoSuchMethodException { 
     final ParameterizedType iterableType = (ParameterizedType) getClass().getField("iterable").getGenericType(); 
     final Map<TypeVariable<?>, Type> typeVarAssigns = TypeUtils.determineTypeArguments(TreeSet.class, iterableType); 
     final TypeVariable<?> treeSetTypeVar = TreeSet.class.getTypeParameters()[0]; 
     Assert.assertTrue(typeVarAssigns.containsKey(treeSetTypeVar)); 
     Assert.assertEquals(iterableType.getActualTypeArguments()[0], typeVarAssigns.get(treeSetTypeVar)); 
 }
@Test
public void testGetArrayComponentType340() throws Exception { 
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
public void testGetPrimitiveArrayComponentType738() throws Exception { 
     Assert.assertEquals(boolean.class, TypeUtils.getArrayComponentType(boolean[].class)); 
     Assert.assertEquals(byte.class, TypeUtils.getArrayComponentType(byte[].class)); 
     Assert.assertEquals(short.class, TypeUtils.getArrayComponentType(short[].class)); 
     Assert.assertEquals(int.class, TypeUtils.getArrayComponentType(int[].class)); 
     Assert.assertEquals(char.class, TypeUtils.getArrayComponentType(char[].class)); 
     Assert.assertEquals(long.class, TypeUtils.getArrayComponentType(long[].class)); 
     Assert.assertEquals(float.class, TypeUtils.getArrayComponentType(float[].class)); 
     Assert.assertEquals(double.class, TypeUtils.getArrayComponentType(double[].class)); 
     Assert.assertNull(TypeUtils.getArrayComponentType(boolean.class)); 
     Assert.assertNull(TypeUtils.getArrayComponentType(byte.class)); 
     Assert.assertNull(TypeUtils.getArrayComponentType(short.class)); 
     Assert.assertNull(TypeUtils.getArrayComponentType(int.class)); 
     Assert.assertNull(TypeUtils.getArrayComponentType(char.class)); 
     Assert.assertNull(TypeUtils.getArrayComponentType(long.class)); 
     Assert.assertNull(TypeUtils.getArrayComponentType(float.class)); 
     Assert.assertNull(TypeUtils.getArrayComponentType(double.class)); 
 }
@Test
public void testIsArrayTypeClasses850() { 
     Assert.assertTrue(TypeUtils.isArrayType(boolean[].class)); 
     Assert.assertTrue(TypeUtils.isArrayType(byte[].class)); 
     Assert.assertTrue(TypeUtils.isArrayType(short[].class)); 
     Assert.assertTrue(TypeUtils.isArrayType(int[].class)); 
     Assert.assertTrue(TypeUtils.isArrayType(char[].class)); 
     Assert.assertTrue(TypeUtils.isArrayType(long[].class)); 
     Assert.assertTrue(TypeUtils.isArrayType(float[].class)); 
     Assert.assertTrue(TypeUtils.isArrayType(double[].class)); 
     Assert.assertTrue(TypeUtils.isArrayType(Object[].class)); 
     Assert.assertTrue(TypeUtils.isArrayType(String[].class)); 
     Assert.assertFalse(TypeUtils.isArrayType(boolean.class)); 
     Assert.assertFalse(TypeUtils.isArrayType(byte.class)); 
     Assert.assertFalse(TypeUtils.isArrayType(short.class)); 
     Assert.assertFalse(TypeUtils.isArrayType(int.class)); 
     Assert.assertFalse(TypeUtils.isArrayType(char.class)); 
     Assert.assertFalse(TypeUtils.isArrayType(long.class)); 
     Assert.assertFalse(TypeUtils.isArrayType(float.class)); 
     Assert.assertFalse(TypeUtils.isArrayType(double.class)); 
     Assert.assertFalse(TypeUtils.isArrayType(Object.class)); 
     Assert.assertFalse(TypeUtils.isArrayType(String.class)); 
 }
@Test
public void testGetTypeArguments1149() { 
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
     typeVarAssigns = TypeUtils.getTypeArguments(AAAClass.BBBClass.class, AAClass.BBClass.class); 
     Assert.assertTrue(typeVarAssigns.size() == 2); 
     Assert.assertEquals(String.class, typeVarAssigns.get(AAClass.class.getTypeParameters()[0])); 
     Assert.assertEquals(String.class, typeVarAssigns.get(AAClass.BBClass.class.getTypeParameters()[0])); 
     typeVarAssigns = TypeUtils.getTypeArguments(Other.class, This.class); 
     Assert.assertEquals(2, typeVarAssigns.size()); 
     Assert.assertEquals(String.class, typeVarAssigns.get(This.class.getTypeParameters()[0])); 
     Assert.assertEquals(Other.class.getTypeParameters()[0], typeVarAssigns.get(This.class.getTypeParameters()[1])); 
     typeVarAssigns = TypeUtils.getTypeArguments(And.class, This.class); 
     Assert.assertEquals(2, typeVarAssigns.size()); 
     Assert.assertEquals(Number.class, typeVarAssigns.get(This.class.getTypeParameters()[0])); 
     Assert.assertEquals(Number.class, typeVarAssigns.get(This.class.getTypeParameters()[1])); 
     typeVarAssigns = TypeUtils.getTypeArguments(Thing.class, Other.class); 
     Assert.assertEquals(2, typeVarAssigns.size()); 
     Assert.assertEquals(getClass().getTypeParameters()[0], typeVarAssigns.get(getClass().getTypeParameters()[0])); 
     Assert.assertEquals(getClass().getTypeParameters()[0], typeVarAssigns.get(Other.class.getTypeParameters()[0])); 
 } 
@SuppressWarnings("boxing")
@Test
public void testIsInstance1165() throws SecurityException, NoSuchFieldException { 
     final Type intComparableType = getClass().getField("intComparable").getGenericType(); 
     final Type uriComparableType = getClass().getField("uriComparable").getGenericType(); 
     intComparable = 1; 
     Assert.assertTrue(TypeUtils.isInstance(1, intComparableType)); 
     Assert.assertFalse(TypeUtils.isInstance(1, uriComparableType)); 
 }
@Test
public void testDetermineTypeVariableAssignments1427() throws SecurityException, NoSuchFieldException, NoSuchMethodException { 
     final ParameterizedType iterableType = (ParameterizedType) getClass().getField("iterable").getGenericType(); 
     final Map<TypeVariable<?>, Type> typeVarAssigns = TypeUtils.determineTypeArguments(TreeSet.class, iterableType); 
     final TypeVariable<?> treeSetTypeVar = TreeSet.class.getTypeParameters()[0]; 
     Assert.assertTrue(typeVarAssigns.containsKey(treeSetTypeVar)); 
     Assert.assertEquals(iterableType.getActualTypeArguments()[0], typeVarAssigns.get(treeSetTypeVar)); 
 }
@Test
public void testGetRawType_GenericArray1491() throws Exception { 
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
public void testGetRawType_PrimitiveArray1492() throws Exception { 
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
public void testTypeVariableAssignments1660() throws SecurityException, NoSuchFieldException { 
     final ParameterizedType iterableType = (ParameterizedType) getClass().getField("iterable").getGenericType(); 
     final Map<TypeVariable<?>, Type> typeVarAssigns = TypeUtils.determineTypeArguments(TreeSet.class, iterableType); 
     final TypeVariable<?> treeSetTypeVar = TreeSet.class.getTypeParameters()[0]; 
     Assert.assertTrue(typeVarAssigns.containsKey(treeSetTypeVar)); 
     Assert.assertEquals(iterableType.getActualTypeArguments()[0], typeVarAssigns.get(treeSetTypeVar)); 
 }
@Test
public void test_isAssignable1662() throws SecurityException, NoSuchFieldException { 
     final ParameterizedType iterableType = (ParameterizedType) getClass().getField("iterable").getGenericType(); 
     final Map<TypeVariable<?>, Type> typeVarAssigns = TypeUtils.determineTypeArguments(TreeSet.class, iterableType); 
     final TypeVariable<?> treeSetTypeVar = TreeSet.class.getTypeParameters()[0]; 
     Assert.assertTrue(typeVarAssigns.containsKey(treeSetTypeVar)); 
     Assert.assertEquals(iterableType.getActualTypeArguments()[0], typeVarAssigns.get(treeSetTypeVar)); 
 }
@Test
public void testDetermineTypeVariableAssignments1673() throws Exception { 
     final ParameterizedType iterableType = (ParameterizedType) getClass().getField("iterable").getGenericType(); 
     final Map<TypeVariable<?>, Type> typeVarAssigns = TypeUtils.determineTypeArguments(TreeSet.class, iterableType); 
     final TypeVariable<?> treeSetTypeVar = TreeSet.class.getTypeParameters()[0]; 
     Assert.assertTrue(typeVarAssigns.containsKey(treeSetTypeVar)); 
     Assert.assertEquals(iterableType.getActualTypeArguments()[0], typeVarAssigns.get(treeSetTypeVar)); 
 }
@Test
public void testDetermineTypeVariableAssignments1678() throws SecurityException, NoSuchFieldException { 
     final ParameterizedType iterableType = (ParameterizedType) getClass().getField("iterable").getGenericType(); 
     final Map<TypeVariable<?>, Type> typeVarAssigns = TypeUtils.determineTypeArguments(TreeSet.class, iterableType); 
     final TypeVariable<?> treeSetTypeVar = TreeSet.class.getTypeParameters()[0]; 
     Assert.assertTrue(typeVarAssigns.containsKey(treeSetTypeVar)); 
     Assert.assertEquals(iterableType.getActualTypeArguments()[0], typeVarAssigns.get(treeSetTypeVar)); 
 }
@Test
public void test_isAssignable1681() throws Exception { 
     final ParameterizedType iterableType = (ParameterizedType) getClass().getField("iterable").getGenericType(); 
     final Map<TypeVariable<?>, Type> typeVarAssigns = TypeUtils.determineTypeArguments(TreeSet.class, iterableType); 
     final TypeVariable<?> treeSetTypeVar = TreeSet.class.getTypeParameters()[0]; 
     Assert.assertTrue(typeVarAssigns.containsKey(treeSetTypeVar)); 
     Assert.assertEquals(iterableType.getActualTypeArguments()[0], typeVarAssigns.get(treeSetTypeVar)); 
 }
@Test
public void test_isAssignable1685() throws SecurityException, NoSuchFieldException, NoSuchMethodException { 
     final ParameterizedType iterableType = (ParameterizedType) getClass().getField("iterable").getGenericType(); 
     final Map<TypeVariable<?>, Type> typeVarAssigns = TypeUtils.determineTypeArguments(TreeSet.class, iterableType); 
     final TypeVariable<?> treeSetTypeVar = TreeSet.class.getTypeParameters()[0]; 
     Assert.assertTrue(typeVarAssigns.containsKey(treeSetTypeVar)); 
     Assert.assertEquals(iterableType.getActualTypeArguments()[0], typeVarAssigns.get(treeSetTypeVar)); 
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
