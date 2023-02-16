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
public void test_getPackageName_Class55() { 
     assertEquals("org.apache.commons.lang3", ClassUtils.getPackageName(ClassUtils.class)); 
     assertEquals("java.util", ClassUtils.getPackageName(Map.Entry.class)); 
     assertEquals("", ClassUtils.getPackageName((Class<?>) null)); 
     assertEquals("String[]", ClassUtils.getPackageName(String[].class)); 
     assertEquals("Map.Entry[]", ClassUtils.getPackageName(Map.Entry[].class)); 
     assertEquals("boolean", ClassUtils.getPackageName(boolean.class)); 
     assertEquals("byte", ClassUtils.getPackageName(byte.class)); 
     assertEquals("char", ClassUtils.getPackageName(char.class)); 
     assertEquals("short", ClassUtils.getPackageName(short.class)); 
     assertEquals("int", ClassUtils.getPackageName(int.class)); 
     assertEquals("long", ClassUtils.getPackageName(long.class)); 
     assertEquals("float", ClassUtils.getPackageName(float.class)); 
     assertEquals("double", ClassUtils.getPackageName(double.class)); 
     assertEquals("boolean[]", ClassUtils.getPackageName(boolean[].class)); 
     assertEquals("byte[]", ClassUtils.getPackageName(byte[].class)); 
     assertEquals("char[]", ClassUtils.getPackageName(char[].class)); 
     assertEquals("short[]", ClassUtils.getPackageName(short[].class)); 
     assertEquals("int[]", ClassUtils.getPackageName(int[].class)); 
     assertEquals("long[]", ClassUtils.getPackageName(long[].class)); 
     assertEquals("float[]", ClassUtils.getPackageName(float[].class)); 
     assertEquals("double[]", ClassUtils.getPackageName(double[].class)); 
     assertEquals("String[][]", ClassUtils.getPackageName(String[][].class)); 
     assertEquals("String[][][]", ClassUtils.getPackageName(String[][][].class));
}

@Test
public void test_getPackageName_String56() { 
     assertEquals("org.apache.commons.lang3", ClassUtils.getPackageName(ClassUtils.class.getName())); 
     assertEquals("java.util", ClassUtils.getPackageName(Map.Entry.class.getName())); 
     assertEquals("", ClassUtils.getPackageName((String) null)); 
     assertEquals("", ClassUtils.getPackageName("")); 
 }
@Test
public void test_getAllInterfaces_Class57() { 
     final List<?> list = ClassUtils.getAllInterfaces(CY.class); 
     assertEquals(2, list.size()); 
     assertEquals(CX.class, list.get(0)); 
     assertEquals(Object.class, list.get(1)); 
     assertEquals(null, ClassUtils.getAllInterfaces(null)); 
 }
@Test
public void test_getAllInterfaces_Class61() { 
     final HashSet<Class<?>> set = new HashSet<Class<?>>(); 
     set.add(CY.class); 
     set.add(Object.class); 
     final List<?> list = ClassUtils.getAllInterfaces(CY.class); 
     assertEquals(2, list.size()); 
     assertEquals(CX.class, list.get(0)); 
     assertEquals(Object.class, list.get(1)); 
     assertEquals(null, ClassUtils.getAllInterfaces(null)); 
 }
@Test
public void test_getShortCanonicalName_Object64() { 
     assertEquals("ClassUtils", ClassUtils.getShortCanonicalName(new ClassUtils(), "<null>")); 
     assertEquals("ClassUtilsTest.Inner", ClassUtils.getShortCanonicalName(new Inner(), "<null>")); 
     assertEquals("String", ClassUtils.getShortCanonicalName("hello", "<null>")); 
     assertEquals("<null>", ClassUtils.getShortCanonicalName(null, "<null>")); 
     class Named extends Object { 
     } 
     assertEquals("ClassUtilsTest.1", ClassUtils.getShortCanonicalName(new Object() { 
     }, "<null>")); 
     assertEquals("ClassUtilsTest.1Named", ClassUtils.getShortCanonicalName(new Named(), "<null>")); 
     assertEquals("ClassUtilsTest.Inner", ClassUtils.getShortCanonicalName(new Inner(), "<null>")); 
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
