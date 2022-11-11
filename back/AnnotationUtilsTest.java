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

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;
import static org.apache.commons.lang3.AnnotationUtilsTest.Stooge.CURLY;
import static org.apache.commons.lang3.AnnotationUtilsTest.Stooge.LARRY;
import static org.apache.commons.lang3.AnnotationUtilsTest.Stooge.MOE;
import static org.apache.commons.lang3.AnnotationUtilsTest.Stooge.SHEMP;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Collection;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

/**
 * @version $Id$
 */
public class AnnotationUtilsTest {
    @TestAnnotation(
            booleanValue = false,
            booleanValues = { false },
            byteValue = 0,
            byteValues = { 0 },
            charValue = 0,
            charValues = { 0 },
            doubleValue = 0,
            doubleValues = { 0 },
            floatValue = 0,
            floatValues = { 0 },
            intValue = 0,
            intValues = { 0 },
            longValue = 0,
            longValues = { 0 },
            nest = @NestAnnotation(
                    booleanValue = false,
                    booleanValues = { false },
                    byteValue = 0,
                    byteValues = { 0 },
                    charValue = 0,
                    charValues = { 0 },
                    doubleValue = 0,
                    doubleValues = { 0 },
                    floatValue = 0,
                    floatValues = { 0 },
                    intValue = 0,
                    intValues = { 0 },
                    longValue = 0,
                    longValues = { 0 },
                    shortValue = 0,
                    shortValues = { 0 },
                    stooge = CURLY,
                    stooges = { MOE, LARRY, SHEMP },
                    string = "",
                    strings = { "" },
                    type = Object.class,
                    types = { Object.class }
            ),
            nests = {
                @NestAnnotation(
                        booleanValue = false,
                        booleanValues = { false },
                        byteValue = 0,
                        byteValues = { 0 },
                        charValue = 0,
                        charValues = { 0 },
                        doubleValue = 0,
                        doubleValues = { 0 },
                        floatValue = 0,
                        floatValues = { 0 },
                        intValue = 0,
                        intValues = { 0 },
                        longValue = 0,
                        longValues = { 0 },
                        shortValue = 0,
                        shortValues = { 0 },
                        stooge = CURLY,
                        stooges = { MOE, LARRY, SHEMP },
                        string = "",
                        strings = { "" },
                        type = Object[].class,
                        types = { Object[].class }
                )
            },
            shortValue = 0,
            shortValues = { 0 },
            stooge = SHEMP,
            stooges = { MOE, LARRY, CURLY },
            string = "",
            strings = { "" },
            type = Object.class,
            types = { Object.class }
    )
    public Object dummy1;

    @TestAnnotation(
            booleanValue = false,
            booleanValues = { false },
            byteValue = 0,
            byteValues = { 0 },
            charValue = 0,
            charValues = { 0 },
            doubleValue = 0,
            doubleValues = { 0 },
            floatValue = 0,
            floatValues = { 0 },
            intValue = 0,
            intValues = { 0 },
            longValue = 0,
            longValues = { 0 },
            nest = @NestAnnotation(
                    booleanValue = false,
                    booleanValues = { false },
                    byteValue = 0,
                    byteValues = { 0 },
                    charValue = 0,
                    charValues = { 0 },
                    doubleValue = 0,
                    doubleValues = { 0 },
                    floatValue = 0,
                    floatValues = { 0 },
                    intValue = 0,
                    intValues = { 0 },
                    longValue = 0,
                    longValues = { 0 },
                    shortValue = 0,
                    shortValues = { 0 },
                    stooge = CURLY,
                    stooges = { MOE, LARRY, SHEMP },
                    string = "",
                    strings = { "" },
                    type = Object.class,
                    types = { Object.class }
            ),
            nests = {
                @NestAnnotation(
                        booleanValue = false,
                        booleanValues = { false },
                        byteValue = 0,
                        byteValues = { 0 },
                        charValue = 0,
                        charValues = { 0 },
                        doubleValue = 0,
                        doubleValues = { 0 },
                        floatValue = 0,
                        floatValues = { 0 },
                        intValue = 0,
                        intValues = { 0 },
                        longValue = 0,
                        longValues = { 0 },
                        shortValue = 0,
                        shortValues = { 0 },
                        stooge = CURLY,
                        stooges = { MOE, LARRY, SHEMP },
                        string = "",
                        strings = { "" },
                        type = Object[].class,
                        types = { Object[].class }
                )
            },
            shortValue = 0,
            shortValues = { 0 },
            stooge = SHEMP,
            stooges = { MOE, LARRY, CURLY },
            string = "",
            strings = { "" },
            type = Object.class,
            types = { Object.class }
    )
    public Object dummy2;

    @TestAnnotation(
            booleanValue = false,
            booleanValues = { false },
            byteValue = 0,
            byteValues = { 0 },
            charValue = 0,
            charValues = { 0 },
            doubleValue = 0,
            doubleValues = { 0 },
            floatValue = 0,
            floatValues = { 0 },
            intValue = 0,
            intValues = { 0 },
            longValue = 0,
            longValues = { 0 },
            nest = @NestAnnotation(
                    booleanValue = false,
                    booleanValues = { false },
                    byteValue = 0,
                    byteValues = { 0 },
                    charValue = 0,
                    charValues = { 0 },
                    doubleValue = 0,
                    doubleValues = { 0 },
                    floatValue = 0,
                    floatValues = { 0 },
                    intValue = 0,
                    intValues = { 0 },
                    longValue = 0,
                    longValues = { 0 },
                    shortValue = 0,
                    shortValues = { 0 },
                    stooge = CURLY,
                    stooges = { MOE, LARRY, SHEMP },
                    string = "",
                    strings = { "" },
                    type = Object.class,
                    types = { Object.class }
            ),
            nests = {
                @NestAnnotation(
                        booleanValue = false,
                        booleanValues = { false },
                        byteValue = 0,
                        byteValues = { 0 },
                        charValue = 0,
                        charValues = { 0 },
                        doubleValue = 0,
                        doubleValues = { 0 },
                        floatValue = 0,
                        floatValues = { 0 },
                        intValue = 0,
                        intValues = { 0 },
                        longValue = 0,
                        longValues = { 0 },
                        shortValue = 0,
                        shortValues = { 0 },
                        stooge = CURLY,
                        stooges = { MOE, LARRY, SHEMP },
                        string = "",
                        strings = { "" },
                        type = Object[].class,
                        types = { Object[].class }
                ),
                //add a second NestAnnotation to break equality:
                @NestAnnotation(
                        booleanValue = false,
                        booleanValues = { false },
                        byteValue = 0,
                        byteValues = { 0 },
                        charValue = 0,
                        charValues = { 0 },
                        doubleValue = 0,
                        doubleValues = { 0 },
                        floatValue = 0,
                        floatValues = { 0 },
                        intValue = 0,
                        intValues = { 0 },
                        longValue = 0,
                        longValues = { 0 },
                        shortValue = 0,
                        shortValues = { 0 },
                        stooge = CURLY,
                        stooges = { MOE, LARRY, SHEMP },
                        string = "",
                        strings = { "" },
                        type = Object[].class,
                        types = { Object[].class }
                )
            },
            shortValue = 0,
            shortValues = { 0 },
            stooge = SHEMP,
            stooges = { MOE, LARRY, CURLY },
            string = "",
            strings = { "" },
            type = Object.class,
            types = { Object.class }
    )
    public Object dummy3;

    @NestAnnotation(
            booleanValue = false,
            booleanValues = { false },
            byteValue = 0,
            byteValues = { 0 },
            charValue = 0,
            charValues = { 0 },
            doubleValue = 0,
            doubleValues = { 0 },
            floatValue = 0,
            floatValues = { 0 },
            intValue = 0,
            intValues = { 0 },
            longValue = 0,
            longValues = { 0 },
            shortValue = 0,
            shortValues = { 0 },
            stooge = CURLY,
            stooges = { MOE, LARRY, SHEMP },
            string = "",
            strings = { "" },
            type = Object[].class,
            types = { Object[].class }
    )
    public Object dummy4;

    @Target(FIELD)
    @Retention(RUNTIME)
    public @interface TestAnnotation {
        String string();
        String[] strings();
        Class<?> type();
        Class<?>[] types();
        byte byteValue();
        byte[] byteValues();
        short shortValue();
        short[] shortValues();
        int intValue();
        int[] intValues();
        char charValue();
        char[] charValues();
        long longValue();
        long[] longValues();
        float floatValue();
        float[] floatValues();
        double doubleValue();
        double[] doubleValues();
        boolean booleanValue();
        boolean[] booleanValues();
        Stooge stooge();
        Stooge[] stooges();
        NestAnnotation nest();
        NestAnnotation[] nests();
    }

    public @interface NestAnnotation {
        String string();
        String[] strings();
        Class<?> type();
        Class<?>[] types();
        byte byteValue();
        byte[] byteValues();
        short shortValue();
        short[] shortValues();
        int intValue();
        int[] intValues();
        char charValue();
        char[] charValues();
        long longValue();
        long[] longValues();
        float floatValue();
        float[] floatValues();
        double doubleValue();
        double[] doubleValues();
        boolean booleanValue();
        boolean[] booleanValues();
        Stooge stooge();
        Stooge[] stooges();
    }

    public static enum Stooge {
        MOE, LARRY, CURLY, JOE, SHEMP;
    }

    private Field field1;
    private Field field2;
    private Field field3;
    private Field field4;

    @Before
    public void setup() throws Exception {
        field1 = getClass().getDeclaredField("dummy1");
        field2 = getClass().getDeclaredField("dummy2");
        field3 = getClass().getDeclaredField("dummy3");
        field4 = getClass().getDeclaredField("dummy4");
    }


@Test(timeout = 666000) 
     public void testToString2226() throws Exception { 
         final Test test = getClass().getDeclaredMethod("testToString").getAnnotation(Test.class); 
         assertEquals(test.toString(), AnnotationUtils.toString(test)); 
         final TestAnnotation testAnnotation1 = field1.getAnnotation(TestAnnotation.class); 
         assertEquals(testAnnotation1.toString(), AnnotationUtils.toString(testAnnotation1)); 
         final TestAnnotation testAnnotation3 = field3.getAnnotation(TestAnnotation.class); 
         assertEquals(testAnnotation3.toString(), AnnotationUtils.toString(testAnnotation3)); 
     }
@Test(timeout = 666000) 
     public void testToString2227() throws Exception { 
         final Test test = getClass().getDeclaredMethod("testToString").getAnnotation(Test.class); 
         assertEquals(test.toString(), AnnotationUtils.toString(test)); 
         final TestAnnotation testAnnotation1 = field1.getAnnotation(TestAnnotation.class); 
         assertEquals(testAnnotation1.toString(), AnnotationUtils.toString(testAnnotation1)); 
         final TestAnnotation testAnnotation3 = field3.getAnnotation(TestAnnotation.class); 
         assertEquals(testAnnotation3.toString(), AnnotationUtils.toString(testAnnotation3)); 
     }
@Test(timeout = 666000) 
     public void testToString2228() throws Exception { 
         final Test test = getClass().getDeclaredMethod("testToString").getAnnotation(Test.class); 
         assertEquals(test.toString(), AnnotationUtils.toString(test)); 
         final TestAnnotation testAnnotation1 = field1.getAnnotation(TestAnnotation.class); 
         assertEquals(testAnnotation1.toString(), AnnotationUtils.toString(testAnnotation1)); 
         final TestAnnotation testAnnotation3 = field3.getAnnotation(TestAnnotation.class); 
         assertEquals(testAnnotation3.toString(), AnnotationUtils.toString(testAnnotation3)); 
     }
//@Test(timeout = 666000)
//     public void testGetShortClassName2229() throws Exception {
//         assertEquals("Test", AnnotationUtils.getShortClassName(field1.getAnnotation(Test.class)));
//         assertEquals("TestAnnotation1", AnnotationUtils.getShortClassName(field3.getAnnotation(TestAnnotation1.class)));
//         assertEquals("TestAnnotation2", AnnotationUtils.getShortClassName(field2.getAnnotation(TestAnnotation2.class)));
//         assertEquals("TestAnnotation3", AnnotationUtils.getShortClassName(field3.getAnnotation(TestAnnotation3.class)));
//     }
//@Test(timeout = 666000)
//     public void testGetShortClassName2230() throws Exception {
//         assertEquals("Test", AnnotationUtils.getShortClassName(field1.getAnnotation(Test.class)));
//         assertEquals("TestAnnotation1", AnnotationUtils.getShortClassName(field3.getAnnotation(TestAnnotation1.class)));
//         assertEquals("TestAnnotation2", AnnotationUtils.getShortClassName(field2.getAnnotation(TestAnnotation2.class)));
//         assertEquals("TestAnnotation3", AnnotationUtils.getShortClassName(field3.getAnnotation(TestAnnotation3.class)));
//     }
@Test(timeout = 666000) 
     public void testHashCode2231() throws Exception { 
         final Test test = getClass().getDeclaredMethod("testHashCode").getAnnotation(Test.class); 
         assertEquals(test.hashCode(), AnnotationUtils.hashCode(test)); 
         final TestAnnotation testAnnotation1 = field1.getAnnotation(TestAnnotation.class); 
         assertEquals(testAnnotation1.hashCode(), AnnotationUtils.hashCode(testAnnotation1)); 
         final TestAnnotation testAnnotation3 = field3.getAnnotation(TestAnnotation.class); 
         assertEquals(testAnnotation3.hashCode(), AnnotationUtils.hashCode(testAnnotation3)); 
     }
//@Test(timeout = 666000)
//     public void testGetShortClassName2232() throws Exception {
//         assertEquals("Test", AnnotationUtils.getShortClassName(field1.getAnnotation(Test.class)));
//         assertEquals("TestAnnotation1", AnnotationUtils.getShortClassName(field3.getAnnotation(TestAnnotation1.class)));
//         assertEquals("TestAnnotation2", AnnotationUtils.getShortClassName(field2.getAnnotation(TestAnnotation2.class)));
//         assertEquals("TestAnnotation3", AnnotationUtils.getShortClassName(field3.getAnnotation(TestAnnotation3.class)));
//     }
@Test(timeout = 666000) 
     public void testHashCode2233() throws Exception { 
         final Test test = getClass().getDeclaredMethod("testHashCode").getAnnotation(Test.class); 
         assertEquals(test.hashCode(), AnnotationUtils.hashCode(test)); 
         final TestAnnotation testAnnotation1 = field1.getAnnotation(TestAnnotation.class); 
         assertEquals(testAnnotation1.hashCode(), AnnotationUtils.hashCode(testAnnotation1)); 
         final TestAnnotation testAnnotation3 = field3.getAnnotation(TestAnnotation.class); 
         assertEquals(testAnnotation3.hashCode(), AnnotationUtils.hashCode(testAnnotation3)); 
     }

@Test(timeout = 666000) 
     public void testToString2235() throws Exception { 
         final Test test = getClass().getDeclaredMethod("testToString").getAnnotation(Test.class); 
         assertEquals(test.toString(), AnnotationUtils.toString(test)); 
         final TestAnnotation testAnnotation1 = field1.getAnnotation(TestAnnotation.class); 
         assertEquals(testAnnotation1.toString(), AnnotationUtils.toString(testAnnotation1)); 
         final TestAnnotation testAnnotation3 = field3.getAnnotation(TestAnnotation.class); 
         assertEquals(testAnnotation3.toString(), AnnotationUtils.toString(testAnnotation3)); 
     }

@Test(timeout = 666000) 
     public void testToString2237() throws Exception { 
         final Test test = getClass().getDeclaredMethod("testToString").getAnnotation(Test.class); 
         assertEquals(test.toString(), AnnotationUtils.toString(test)); 
         final TestAnnotation testAnnotation1 = field1.getAnnotation(TestAnnotation.class); 
         assertEquals(testAnnotation1.toString(), AnnotationUtils.toString(testAnnotation1)); 
         final TestAnnotation testAnnotation3 = field3.getAnnotation(TestAnnotation.class); 
         assertEquals(testAnnotation3.toString(), AnnotationUtils.toString(testAnnotation3)); 
     }
@Test(timeout = 666000) 
     public void testToString2238() throws Exception { 
         final Test test = getClass().getDeclaredMethod("testToString").getAnnotation(Test.class); 
         assertEquals(test.toString(), AnnotationUtils.toString(test)); 
         final TestAnnotation testAnnotation1 = field1.getAnnotation(TestAnnotation.class); 
         assertEquals(testAnnotation1.toString(), AnnotationUtils.toString(testAnnotation1)); 
         final TestAnnotation testAnnotation3 = field3.getAnnotation(TestAnnotation.class); 
         assertEquals(testAnnotation3.toString(), AnnotationUtils.toString(testAnnotation3)); 
     }
@Test(timeout = 666000) 
     public void testHashCode2239() throws Exception { 
         final Test test = getClass().getDeclaredMethod("testHashCode").getAnnotation(Test.class); 
         assertEquals(test.hashCode(), AnnotationUtils.hashCode(test)); 
         final TestAnnotation testAnnotation1 = field1.getAnnotation(TestAnnotation.class); 
         assertEquals(testAnnotation1.hashCode(), AnnotationUtils.hashCode(testAnnotation1)); 
         final TestAnnotation testAnnotation3 = field3.getAnnotation(TestAnnotation.class); 
         assertEquals(testAnnotation3.hashCode(), AnnotationUtils.hashCode(testAnnotation3)); 
     }
@Test(timeout = 666000) 
     public void testToString2240() throws Exception { 
         final Test test = getClass().getDeclaredMethod("testToString").getAnnotation(Test.class); 
         assertEquals(test.toString(), AnnotationUtils.toString(test)); 
         final TestAnnotation testAnnotation1 = field1.getAnnotation(TestAnnotation.class); 
         assertEquals(testAnnotation1.toString(), AnnotationUtils.toString(testAnnotation1)); 
         final TestAnnotation testAnnotation3 = field3.getAnnotation(TestAnnotation.class); 
         assertEquals(testAnnotation3.toString(), AnnotationUtils.toString(testAnnotation3)); 
     }


    

    

    

    

    

    

    

    

    

}
