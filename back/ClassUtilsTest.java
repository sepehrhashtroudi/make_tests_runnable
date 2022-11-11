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
public void testWrapperToPrimitive31() { 
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
public void testPrimitivesToWrappersNull49() { 
 //        assertNull("Wrong result for null input", ClassUtils.primitivesToWrappers(null)); // generates warning 
         assertNull("Wrong result for null input", ClassUtils.primitivesToWrappers((Class<?>[]) null)); // equivalent explicit cast 
          
         // Other possible casts for null 
         assertTrue("empty -> empty", Arrays.equals(ArrayUtils.EMPTY_CLASS_ARRAY, ClassUtils.primitivesToWrappers())); 
         final Class<?>[] castNull = ClassUtils.primitivesToWrappers((Class<?>)null); // == new Class<?>[]{null} 
         assertTrue("(Class<?>)null -> [null]", Arrays.equals(new Class<?>[]{null}, castNull)); 
 }
@Test
public void testIsAssignable_ClassArray_ClassArray_Autoboxing108() { 
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
public void testIsAssignable_ClassArray_ClassArray_Autoboxing111() { 
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
public void testGetPublicMethod1242() throws Exception { 
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
public void testGetPublicMethod1261() throws Exception { 
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
public void testPrimitivesToWrappersNull1733() { 
 //        assertNull("Wrong result for null input", ClassUtils.primitivesToWrappers(null)); // generates warning 
         assertNull("Wrong result for null input", ClassUtils.primitivesToWrappers((Class<?>[]) null)); // equivalent cast 
          
         // Other possible casts for null 
         assertTrue("empty -> empty", Arrays.equals(ArrayUtils.EMPTY_CLASS_ARRAY, ClassUtils.primitivesToWrappers())); 
         final Class<?>[] castNull = ClassUtils.primitivesToWrappers((Class<?>)null); // == new Class<?>[]{null} 
         assertTrue("(Class<?>)null -> [null]", Arrays.equals(new Class<?>[]{null}, castNull)); 
 }
@Test
public void testPrimitivesToWrappersNull1734() { 
 //        assertNull("Wrong result for null input", ClassUtils.primitivesToWrappers(null)); // generates warning 
         assertNull("Wrong result for null input", ClassUtils.primitivesToWrappers((Class<?>[]) null)); // equivalent cast 
          
         // Other possible casts for null 
         assertTrue("empty -> empty", Arrays.equals(ArrayUtils.EMPTY_CLASS_ARRAY, ClassUtils.primitivesToWrappers())); 
         final Class<?>[] castNull = ClassUtils.primitivesToWrappers((Class<?>)null); // == new Class<?>[]{null} 
         assertTrue("(Class<?>)null -> [null]", Arrays.equals(new Class<?>[]{null}, castNull)); 
 }
@Test
public void testPrimitivesToWrappersNull1735() { 
 //        assertNull("Wrong result for null input", ClassUtils.primitivesToWrappers(null)); // generates warning 
         assertNull("Wrong result for null input", ClassUtils.primitivesToWrappers((Class<?>[]) null)); // equivalent cast 
          
         // Other possible casts for null 
         assertTrue("empty -> empty", Arrays.equals(ArrayUtils.EMPTY_CLASS_ARRAY, ClassUtils.primitivesToWrappers())); 
         final Class<?>[] castNull = ClassUtils.primitivesToWrappers((Class<?>)null); // == new Class<?>[]{null} 
         assertTrue("(Class<?>)null -> [null]", Arrays.equals(new Class<?>[]{null}, castNull)); 
 }
@Test
public void testPrimitivesToWrappersNull1736() { 
 //        assertNull("Wrong result for null input", ClassUtils.primitivesToWrappers(null)); // generates warning 
         assertNull("Wrong result for null input", ClassUtils.primitivesToWrappers((Class<?>[]) null)); // equivalent cast 
          
         // Other possible casts for null 
         assertTrue("empty -> empty", Arrays.equals(ArrayUtils.EMPTY_CLASS_ARRAY, ClassUtils.primitivesToWrappers())); 
         final Class<?>[] castNull = ClassUtils.primitivesToWrappers((Class<?>)null); // == new Class<?>[]{null} 
         assertTrue("(Class<?>)null -> [null]", Arrays.equals(new Class<?>[]{null}, castNull)); 
 }
@Test
public void testPrimitivesToWrappersNull1737() { 
 //        assertNull("Wrong result for null input", ClassUtils.primitivesToWrappers(null)); // generates warning 
         assertNull("Wrong result for null input", ClassUtils.primitivesToWrappers((Class<?>[]) null)); // equivalent explicit cast 
          
         // Other possible casts for null 
         assertTrue("empty -> empty", Arrays.equals(ArrayUtils.EMPTY_CLASS_ARRAY, ClassUtils.primitivesToWrappers())); 
         final Class<?>[] castNull = ClassUtils.primitivesToWrappers((Class<?>)null); // == new Class<?>[]{null} 
         assertTrue("(Class<?>)null -> [null]", Arrays.equals(new Class<?>[]{null}, castNull)); 
 }
@Test
public void testPrimitivesToWrappersNull1738() { 
 //        assertNull("Wrong result for null input", ClassUtils.primitivesToWrappers(null)); // generates warning 
         assertNull("Wrong result for null input", ClassUtils.primitivesToWrappers((Class<?>[]) null)); // equivalent explicit cast 
          
         // Other possible casts for null 
         assertTrue("empty -> empty", Arrays.equals(ArrayUtils.EMPTY_CLASS_ARRAY, ClassUtils.primitivesToWrappers())); 
         final Class<?>[] castNull = ClassUtils.primitivesToWrappers((Class<?>)null); // == new Class<?>[]{null} 
         assertTrue("(Class<?>)null -> [null]", Arrays.equals(new Class<?>[]{null}, castNull)); 
 }
@Test
public void testPrimitivesToWrappersNull1739() { 
 //        assertNull("Wrong result for null input", ClassUtils.primitivesToWrappers(null)); // generates warning 
         assertNull("Wrong result for null input", ClassUtils.primitivesToWrappers((Class<?>[]) null)); // equivalent explicit cast 
          
         // Other possible casts for null 
         assertTrue("empty -> empty", Arrays.equals(ArrayUtils.EMPTY_CLASS_ARRAY, ClassUtils.primitivesToWrappers())); 
         final Class<?>[] castNull = ClassUtils.primitivesToWrappers((Class<?>)null); // == new Class<?>[]{null} 
         assertTrue("(Class<?>)null -> [null]", Arrays.equals(new Class<?>[]{null}, castNull)); 
 }
@Test
public void testPrimitivesToWrappersNull1740() { 
 //        assertNull("Wrong result for null input", ClassUtils.primitivesToWrappers(null)); // generates warning 
         assertNull("Wrong result for null input", ClassUtils.primitivesToWrappers((Class<?>[]) null)); // equivalent explicit cast 
          
         // Other possible casts for null 
         assertTrue("empty -> empty", Arrays.equals(ArrayUtils.EMPTY_CLASS_ARRAY, ClassUtils.primitivesToWrappers())); 
         final Class<?>[] castNull = ClassUtils.primitivesToWrappers((Class<?>)null); // == new Class<?>[]{null} 
         assertTrue("(Class<?>)null -> [null]", Arrays.equals(new Class<?>[]{null}, castNull)); 
 }
@Test
public void testIsAssignable_ClassArray_ClassArray_Autoboxing2860() { 
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
public void testIsAssignable_ClassArray_ClassArray_Autoboxing2861() { 
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
public void testIsAssignable_ClassArray_ClassArray_Autoboxing2862() { 
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
public void testIsAssignable_ClassArray_ClassArray_Autoboxing2863() { 
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
public void testIsAssignable_ClassArray_ClassArray_Autoboxing2864() { 
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
public void testIsAssignable_ClassArray_ClassArray_Autoboxing2865() { 
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
public void testIsAssignable_ClassArray_ClassArray_Autoboxing2866() { 
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
public void testIsAssignable_ClassArray_ClassArray_Autoboxing2867() { 
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
public void testIsAssignable_ClassArray_ClassArray_Autoboxing2868() { 
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
