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

import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;
import java.lang.reflect.Constructor;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.apache.commons.lang3.mutable.MutableObject;

/**
 * Unit tests ConstructorUtils
 * @version $Id$
 */
public class ConstructorUtilsTest {
    public static class TestBean {
        private final String toString;

        public TestBean() {
            toString = "()";
        }

        public TestBean(final int i) {
            toString = "(int)";
        }

        public TestBean(final Integer i) {
            toString = "(Integer)";
        }

        public TestBean(final double d) {
            toString = "(double)";
        }

        public TestBean(final String s) {
            toString = "(String)";
        }

        public TestBean(final Object o) {
            toString = "(Object)";
        }

        @Override
        public String toString() {
            return toString;
        }
    }

    private static class PrivateClass {
        @SuppressWarnings("unused")
        public PrivateClass() {
        }
    }

    private final Map<Class<?>, Class<?>[]> classCache;

    public ConstructorUtilsTest() {
        classCache = new HashMap<Class<?>, Class<?>[]>();
    }


    @Before
    public void setUp() throws Exception {
        classCache.clear();
    }

@Test
public void testInvokeConstructor266() throws Exception { 
     assertEquals("()", ConstructorUtils.invokeConstructor(TestBean.class, (Object[]) ArrayUtils.EMPTY_CLASS_ARRAY).toString()); 
     assertEquals("()", ConstructorUtils.invokeConstructor(TestBean.class, (Object[]) null).toString()); 
     assertEquals("()", ConstructorUtils.invokeConstructor(TestBean.class).toString()); 
     assertEquals("(String)", ConstructorUtils.invokeConstructor(TestBean.class, "").toString()); 
     assertEquals("(Object)", ConstructorUtils.invokeConstructor(TestBean.class, new Object()).toString()); 
     assertEquals("(Object)", ConstructorUtils.invokeConstructor(TestBean.class, Boolean.TRUE).toString()); 
     assertEquals("(Integer)", ConstructorUtils.invokeConstructor(TestBean.class, NumberUtils.INTEGER_ONE).toString()); 
     assertEquals("(int)", ConstructorUtils.invokeConstructor(TestBean.class, NumberUtils.BYTE_ONE).toString()); 
     assertEquals("(double)", ConstructorUtils.invokeConstructor(TestBean.class, NumberUtils.LONG_ONE).toString()); 
     assertEquals("(double)", ConstructorUtils.invokeConstructor(TestBean.class, NumberUtils.DOUBLE_ONE).toString()); 
 }
@Test
public void testInvokeExactConstructor345() throws Exception { 
     assertEquals("()", ConstructorUtils.invokeExactConstructor(TestBean.class, (Object[]) ArrayUtils.EMPTY_CLASS_ARRAY).toString()); 
     assertEquals("()", ConstructorUtils.invokeExactConstructor(TestBean.class, (Object[]) null).toString()); 
     assertEquals("(String)", ConstructorUtils.invokeExactConstructor(TestBean.class, "").toString()); 
     assertEquals("(Object)", ConstructorUtils.invokeExactConstructor(TestBean.class, new Object()).toString()); 
     assertEquals("(Object)", ConstructorUtils.invokeExactConstructor(TestBean.class, Boolean.TRUE).toString()); 
     assertEquals("(Integer)", ConstructorUtils.invokeExactConstructor(TestBean.class, NumberUtils.INTEGER_ONE).toString()); 
     assertEquals("(int)", ConstructorUtils.invokeExactConstructor(TestBean.class, NumberUtils.BYTE_ONE).toString()); 
     assertEquals("(double)", ConstructorUtils.invokeExactConstructor(TestBean.class, NumberUtils.LONG_ONE).toString()); 
     assertEquals("(double)", ConstructorUtils.invokeExactConstructor(TestBean.class, NumberUtils.DOUBLE_ONE).toString()); 
     try { 
         ConstructorUtils.invokeExactConstructor(TestBean.class, NumberUtils.DOUBLE_ONE); 
         fail("should throw NoSuchMethodException"); 
     } catch (final NoSuchMethodException e) { 
     } 
 }
@Test
public void testInvokeExactConstructor346() throws Exception { 
     assertEquals("()", ConstructorUtils.invokeExactConstructor(TestBean.class, (Object[]) ArrayUtils.EMPTY_CLASS_ARRAY).toString()); 
     assertEquals("()", ConstructorUtils.invokeExactConstructor(TestBean.class, (Object[]) null).toString()); 
     assertEquals("()", ConstructorUtils.invokeExactConstructor(TestBean.class).toString()); 
     assertEquals("(String)", ConstructorUtils.invokeExactConstructor(TestBean.class, "").toString()); 
     assertEquals("(Object)", ConstructorUtils.invokeExactConstructor(TestBean.class, new Object()).toString()); 
     assertEquals("(Object)", ConstructorUtils.invokeExactConstructor(TestBean.class, Boolean.TRUE).toString()); 
     assertEquals("(Integer)", ConstructorUtils.invokeExactConstructor(TestBean.class, NumberUtils.INTEGER_ONE).toString()); 
     assertEquals("(int)", ConstructorUtils.invokeExactConstructor(TestBean.class, NumberUtils.BYTE_ONE).toString()); 
     assertEquals("(double)", ConstructorUtils.invokeExactConstructor(TestBean.class, NumberUtils.LONG_ONE).toString()); 
     assertEquals("(double)", ConstructorUtils.invokeExactConstructor(TestBean.class, NumberUtils.DOUBLE_ONE).toString()); 
     try { 
         ConstructorUtils.invokeExactConstructor(TestBean.class, NumberUtils.DOUBLE_ONE); 
         fail("should throw NoSuchMethodException"); 
     } catch (final NoSuchMethodException e) { 
     } 
 }
    

    

    

    

    

    

    

    private void expectMatchingAccessibleConstructorParameterTypes(final Class<?> cls,
            final Class<?>[] requestTypes, final Class<?>[] actualTypes) {
        final Constructor<?> c = ConstructorUtils.getMatchingAccessibleConstructor(cls,
                requestTypes);
        assertTrue(toString(c.getParameterTypes()) + " not equals "
                + toString(actualTypes), Arrays.equals(actualTypes, c
                .getParameterTypes()));
    }

    private String toString(final Class<?>[] c) {
        return Arrays.asList(c).toString();
    }

    private Class<?>[] singletonArray(final Class<?> c) {
        Class<?>[] result = classCache.get(c);
        if (result == null) {
            result = new Class[] { c };
            classCache.put(c, result);
        }
        return result;
    }

}