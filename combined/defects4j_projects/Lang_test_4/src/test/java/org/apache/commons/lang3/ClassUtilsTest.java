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
public void test_getShortClassName_Class60() { 
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
}

@Test
public void test_getSimpleName_Object61() { 
     assertEquals("ClassUtils", ClassUtils.getSimpleName(new ClassUtils(), "<null>")); 
     assertEquals("Inner", ClassUtils.getSimpleName(new Inner(), "<null>")); 
     assertEquals("String", ClassUtils.getSimpleName("hello", "<null>")); 
     assertEquals("<null>", ClassUtils.getSimpleName(null, "<null>")); 
 }
@Test
public void test_convertClassNamesToClasses_List63() { 
     final List<String> list = new ArrayList<String>(); 
     List<?> result = ClassUtils.convertClassNamesToClasses(list); 
     assertEquals(null, result); 
     list.add(String.class.getName()); 
     list.add(null); 
     result = ClassUtils.convertClassNamesToClasses(list); 
     assertEquals(3, result.size()); 
     assertEquals(String.class, result.get(0)); 
     assertEquals(null, result.get(1)); 
     assertEquals(null, result.get(2)); 
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
public void test_isPrimitiveOrWrapper_Class64() { 
     assertTrue(ClassUtils.isPrimitiveOrWrapper(boolean.class)); 
     assertTrue(ClassUtils.isPrimitiveOrWrapper(byte.class)); 
     assertTrue(ClassUtils.isPrimitiveOrWrapper(char.class)); 
     assertTrue(ClassUtils.isPrimitiveOrWrapper(short.class)); 
     assertTrue(ClassUtils.isPrimitiveOrWrapper(int.class)); 
     assertTrue(ClassUtils.isPrimitiveOrWrapper(long.class)); 
     assertTrue(ClassUtils.isPrimitiveOrWrapper(float.class)); 
     assertTrue(ClassUtils.isPrimitiveOrWrapper(double.class)); 
     assertFalse(ClassUtils.isPrimitiveOrWrapper(boolean.class)); 
     assertFalse(ClassUtils.isPrimitiveOrWrapper(byte.class)); 
     assertFalse(ClassUtils.isPrimitiveOrWrapper(short.class)); 
     assertTrue(ClassUtils.isPrimitiveOrWrapper(int.class)); 
     assertTrue(ClassUtils.isPrimitiveOrWrapper(long.class)); 
     assertTrue(ClassUtils.isPrimitiveOrWrapper(float.class)); 
     assertTrue(ClassUtils.isPrimitiveOrWrapper(double.class)); 
     assertFalse(ClassUtils.isPrimitiveOrWrapper(boolean.class)); 
 }
@Test
public void test_isPrimitiveWrapper_Class65() { 
     assertTrue(ClassUtils.isPrimitiveWrapper(boolean.class)); 
     assertTrue(ClassUtils.isPrimitiveWrapper(byte.class)); 
     assertTrue(ClassUtils.isPrimitiveWrapper(char.class)); 
     assertTrue(ClassUtils.isPrimitiveWrapper(short.class)); 
     assertTrue(ClassUtils.isPrimitiveWrapper(int.class)); 
     assertTrue(ClassUtils.isPrimitiveWrapper(long.class)); 
     assertTrue(ClassUtils.isPrimitiveWrapper(float.class)); 
     assertTrue(ClassUtils.isPrimitiveWrapper(double.class)); 
     assertFalse(ClassUtils.isPrimitiveWrapper(boolean.class)); 
     assertFalse(ClassUtils.isPrimitiveWrapper(byte.class)); 
     assertFalse(ClassUtils.isPrimitiveWrapper(short.class)); 
     assertTrue(ClassUtils.isPrimitiveWrapper(int.class)); 
     assertTrue(ClassUtils.isPrimitiveWrapper(long.class)); 
     assertTrue(ClassUtils.isPrimitiveWrapper(float.class)); 
     assertTrue(ClassUtils.isPrimitiveWrapper(double.class)); 
     assertFalse(ClassUtils.isPrimitiveWrapper(boolean.class)); 
 }
@Test
public void testWrapperToPrimitive_Class73() { 
     assertEquals(boolean.class, ClassUtils.wrapperToPrimitive(boolean.class)); 
     assertEquals(byte.class, ClassUtils.wrapperToPrimitive(byte.class)); 
     assertEquals(char.class, ClassUtils.wrapperToPrimitive(char.class)); 
     assertEquals(short.class, ClassUtils.wrapperToPrimitive(short.class)); 
     assertEquals(int.class, ClassUtils.wrapperToPrimitive(int.class)); 
     assertEquals(char.class, ClassUtils.wrapperToPrimitive(char.class)); 
     assertEquals(short.class, ClassUtils.wrapperToPrimitive(short.class)); 
     assertEquals(int.class, ClassUtils.wrapperToPrimitive(int.class)); 
     class Named extends Object { 
     } 
     assertEquals(new Object() { 
     }, ClassUtils.wrapperToPrimitive(new Object() { 
     }.getClass())); 
     assertEquals(new Object() { 
     }, ClassUtils.wrapperToPrimitive(new Named() { 
     }.getClass())); 
     assertEquals(new Object() { 
     }, ClassUtils.wrapperToPrimitive(new Inner() { 
     }.getClass())); 
 }
@Test
public void test_toClass_Object_Object74() { 
     final Object[] b = null; 
     assertArrayEquals(null, ClassUtils.toClass(b)); 
     assertSame(ArrayUtils.EMPTY_CLASS_ARRAY, ClassUtils.toClass(new Object[0])); 
     assertTrue(Arrays.equals(new Class[] { String.class, Object.class }, ClassUtils.toClass(new String[] { "foo", "bar", "baz" }))); 
     try { 
         ClassUtils.toClass(new Object[] { "foo", "bar", "baz", "blah" }); 
         fail("expecting ClassCastException"); 
     } catch (final ClassCastException expected) { 
     } 
     try { 
         ClassUtils.toClass(new Object[] { "foo", "bar", "baz", "blah" }); 
         fail("expecting ClassCastException"); 
     } catch (final ClassCastException expected) { 
     } 
 }
@Test
public void test_getShortCanonicalName_Object75() { 
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
public void test_getPackageCanonicalName_Object77() { 
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
public void test_getPackageCanonicalName_Object78() { 
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
public void test_getPackageCanonicalName_Object79() { 
     assertEquals("org.apache.commons.lang3", ClassUtils.getPackageCanonicalName(new ClassUtils(), "<null>")); 
     assertEquals("org.apache.commons.lang3", ClassUtils.getPackageCanonicalName(new Inner(), "<null>")); 
     assertEquals("<null>", ClassUtils.getPackageCanonicalName(new Inner[0], "<null>")); 
     assertEquals("org.apache.commons.lang3", ClassUtils.getPackageCanonicalName(new Inner[0][0], "<null>")); 
     assertEquals("", ClassUtils.getPackageCanonicalName(new int[0], "<null>")); 
     assertEquals("", ClassUtils.getPackageCanonicalName(new int[0][0], "<null>")); 
     class Named extends Object { 
     } 
     assertEquals("org.apache.commons.lang3", ClassUtils.getPackageCanonicalName(new Object() { 
     }, "<null>")); 
     assertEquals("org.apache.commons.lang3", ClassUtils.getPackageCanonicalName(new Named(), "<null>")); 
     assertEquals("org.apache.commons.lang3", ClassUtils.getPackageCanonicalName(new Inner(), "<null>")); 
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
