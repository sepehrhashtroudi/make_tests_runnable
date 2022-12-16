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
 public void testEquivalence138() throws Exception { 
     assertTrue(AnnotationUtils.equals(field1.getAnnotation(TestAnnotation.class), field2.getAnnotation(TestAnnotation.class))); 
     assertTrue(AnnotationUtils.equals(field2.getAnnotation(TestAnnotation.class), field1.getAnnotation(TestAnnotation.class))); 
 }
@Test(timeout = 666000) 
 public void testValidAnnotationMemberType513() throws Exception { 
     final Test testAnno = getClass().getDeclaredMethod("testValidAnnotationMemberType").getAnnotation(Test.class); 
     assertTrue(AnnotationUtils.isValidAnnotationMemberType(testAnno)); 
     final TestAnnotation testAnnotation1 = field1.getAnnotation(TestAnnotation.class); 
     assertTrue(AnnotationUtils.isValidAnnotationMemberType(testAnnotation1)); 
     final TestAnnotation testAnnotation3 = field3.getAnnotation(TestAnnotation.class); 
     assertTrue(AnnotationUtils.isValidAnnotationMemberType(testAnnotation3)); 
 }
@Test(timeout = 666000) 
 public void testArrayMemberEquals514() throws Exception { 
     final Test test = getClass().getDeclaredMethod("testArrayMemberEquals").getAnnotation(Test.class); 
     assertTrue(test.isAnnotation(Test.class)); 
     assertTrue(test.isAnnotation(TestAnnotation.class, "testAnnotation1")); 
     assertTrue(test.isAnnotation(TestAnnotation.class, "testAnnotation2")); 
     assertTrue(test.isAnnotation(TestAnnotation.class, "testAnnotation3")); 
     assertTrue(test.isAnnotation(TestAnnotation.class, "testAnnotation4")); 
     assertTrue(test.isAnnotation(TestAnnotation.class, "testAnnotation5")); 
     assertTrue(test.isAnnotation(TestAnnotation.class, "testAnnotation6")); 
     assertFalse(test.isAnnotation(TestAnnotation.class, "testAnnotation7")); 
     assertFalse(test.isAnnotation(TestAnnotation.class, "testAnnotation8")); 
     assertFalse(test.isAnnotation(TestAnnotation.class, "testAnnotation9")); 
     assertFalse(test.isAnnotation(TestAnnotation.class, "testAnnotation10")); 
     assertFalse(test.isAnnotation(TestAnnotation.class, "testAnnotation11")); 
     assertFalse(test.isAnnotation(TestAnnotation.class, "testAnnotation12")); 
     assertFalse(test.isAnnotation(TestAnnotation.class, "testAnnotation13")); 
     assertFalse(test.isAnnotation(TestAnnotation.class, "testAnnotation 14")); 
     assertFalse(test.isAnnotation(TestAnnotation.class, "testAnnotation15")); 
 }
@Test(timeout = 666000) 
 public void testAnnotationsOfDifferingTypes515() throws Exception { 
     assertFalse(AnnotationUtils.equals(field1.getAnnotation(TestAnnotation.class), field4.getAnnotation(NestAnnotation.class))); 
     assertFalse(AnnotationUtils.equals(field4.getAnnotation(NestAnnotation.class), field1.getAnnotation(TestAnnotation.class))); 
 }
@Test(timeout = 666000) 
 public void testAnnotationsOfDifferingTypes516() throws Exception { 
     final Test testAnno = getClass().getDeclaredMethod("testAnnotations").getAnnotation(Test.class); 
     final TestAnnotation testAnnotation1 = field1.getAnnotation(TestAnnotation.class); 
     final TestAnnotation testAnnotation3 = field3.getAnnotation(TestAnnotation.class); 
     assertFalse(AnnotationUtils.equals(testAnno, testAnnotation1)); 
     assertFalse(AnnotationUtils.equals(testAnno, testAnnotation3)); 
     assertFalse(AnnotationUtils.equals(testAnnotation1, testAnnotation3)); 
     assertFalse(AnnotationUtils.equals(testAnnotation3, testAnnotation4)); 
     assertFalse(AnnotationUtils.equals(testAnnotation4, testAnnotation3)); 
     assertFalse(AnnotationUtils.equals(testAnnotation5, testAnnotation4)); 
     assertFalse(AnnotationUtils.equals(testAnnotation6, testAnnotation5)); 
     assertFalse(AnnotationUtils.equals(testAnnotation7, testAnnotation7)); 
     assertFalse(AnnotationUtils.equals(testAnnotation8, testAnnotation8)); 
     assertFalse(AnnotationUtils.equals(testAnnotation9, testAnnotation9)); 
     assertFalse(AnnotationUtils.equals(testAnnotationA, testAnnotationA)); 
     assertFalse(AnnotationUtils.equals(testAnnotationB, testAnnotationB)); 
     assertFalse(AnnotationUtils.equals(testAnnotationC, testAnnotationA)); 
     assertFalse(AnnotationUtils.equals(testAnnotationD, testAnnotationD)); 
     assertFalse(AnnotationUtils.equals(testAnnotationE, testAnnotationE)); 
     assertFalse(AnnotationUtils.equals(testAnnotationF, testAnnotationF)); 
     assertFalse(AnnotationUtils.equals(testAnnotationG, testAnnotationG)); 
     assertFalse(AnnotationUtils.equals(testAnnotation bd, testAnnotationA)); 
     assertFalse(AnnotationUtils.equals(testAnnotation bd, testAnnotationB)); 
     assertFalse(AnnotationUtils.equals(testAnnotationC, testAnnotationB)); 
     assertFalse
@Test
public void testAnnotationsOfDifferingTypes517() { 
     assertFalse(AnnotationUtils.equals(field1.getAnnotation(TestAnnotation.class), field4.getAnnotation(NestAnnotation.class))); 
     assertFalse(AnnotationUtils.equals(field4.getAnnotation(NestAnnotation.class), field1.getAnnotation(TestAnnotation.class))); 
 }
@Test
public void testEquivalence518() { 
     assertTrue(AnnotationUtils.equals(field1.getAnnotation(TestAnnotation.class), field2.getAnnotation(TestAnnotation.class))); 
     assertTrue(AnnotationUtils.equals(field2.getAnnotation(TestAnnotation.class), field1.getAnnotation(TestAnnotation.class))); 
 }
@Test(timeout = 666000) 
 public void testByteArrayHiddenByObject519() { 
     final byte[] array1 = new byte[] { 1, 2, 3 }; 
     final byte[] array2 = new byte[] { 4, 6 }; 
     assertTrue(AnnotationUtils.equals(array1, array2)); 
     assertTrue(AnnotationUtils.equals(array1, array2)); 
     assertTrue(AnnotationUtils.equals(array2, array2)); 
     array1[1] = 7; 
     assertTrue(AnnotationUtils.equals(array1, array2)); 
     assertTrue(AnnotationUtils.equals(array2, array2)); 
     array2 = null; 
     assertTrue(AnnotationUtils.equals(array1, array2)); 
     assertFalse(AnnotationUtils.equals(array1, array2)); 
     assertFalse(AnnotationUtils.equals(array2, array2)); 
 }
@Test(timeout = 666000) 
 public void testDoubleArrayHiddenByObject520() { 
     final double[] array1 = new double[] { 1.0, 2.9876, -3.00001, 4.3 }; 
     final double[] array2 = new double[] { 1.0, 2.9876, -3.00001, 4.3 }; 
     assertTrue(AnnotationUtils.equals(array1, array2)); 
     assertTrue(AnnotationUtils.equals(array1, array2)); 
     assertTrue(AnnotationUtils.equals(array2, array2)); 
     array1[1] = 5.4d; 
     assertTrue(AnnotationUtils.equals(array1, array2)); 
     assertTrue(AnnotationUtils.equals(array2, array2)); 
     array2 = null; 
     assertTrue(AnnotationUtils.equals(array1, array2)); 
     assertFalse(AnnotationUtils.equals(array1, array2)); 
 }
@Test(timeout = 666000) 
 public void testFloatArrayMemberEquals521() throws Exception { 
     final float[] array1 = new float[] { 1.0f, 2.9876f, 3.00001f, 4.3f }; 
     final float[] array2 = new float[] { 1.0f, 2.9876f, 3.00001f, 4.3f }; 
     assertTrue(AnnotationUtils.equals(array1, array2)); 
     assertTrue(AnnotationUtils.equals(array1, array2)); 
     assertTrue(AnnotationUtils.equals(array2, array1)); 
     array2 = new float[] { 1.0f, 2.9876f, 3.00001f, 4.3f }; 
     assertFalse(AnnotationUtils.equals(array1, array2)); 
     assertFalse(AnnotationUtils.equals(array1, array2)); 
     assertFalse(AnnotationUtils.equals(array2, array1)); 
     array2 = new float[] { 1.0f, 2.9876f, 3.00001f, 4.3f }; 
     assertTrue(AnnotationUtils.equals(array1, array2)); 
     assertFalse(AnnotationUtils.equals(array2, array1)); 
 }
@Test(timeout = 666000) 
 public void testMultiFloatArray522() throws Exception { 
     final float[][] array1 = new float[][] { { 2.6f, 6.4f }, { 5.4f, 6.3f } }; 
     final float[][] array2 = new float[][] { { 2.6f, 6.4f }, { 5.4f, 6.3f } }; 
     assertTrue(AnnotationUtils.equals(array1, array2)); 
     final float[][] array3 = new float[][] { { 2.6f, 6.4f }, { 5.4f, 6.3f } }; 
     assertFalse(AnnotationUtils.equals(array1, array3)); 
     assertFalse(AnnotationUtils.equals(array3, array1)); 
     final float[][] array4 = new float[][] { { 2.6f, 6.4f }, { 5.4f, 6.3f } }; 
     assertFalse(AnnotationUtils.equals(array1, array2)); 
     assertFalse(AnnotationUtils.equals(array1, array3)); 
     assertFalse(AnnotationUtils.equals(array2, array1)); 
     assertTrue(AnnotationUtils.equals(array3, array2)); 
     assertTrue(AnnotationUtils.equals(array2, array3)); 
     assertFalse(AnnotationUtils.equals(array3, array4)); 
     assertFalse(AnnotationUtils.equals(array4, array3)); 
 }
@Test(timeout = 666000) 
 public void testEquivalence523() { 
     assertTrue(AnnotationUtils.equals(field1.getAnnotation(TestAnnotation.class), field2.getAnnotation(TestAnnotation.class))); 
     assertTrue(AnnotationUtils.equals(field2.getAnnotation(TestAnnotation.class), field1.getAnnotation(TestAnnotation.class))); 
 }
@Test(timeout = 666000) 
 public void testMultiIntArray524() throws Exception { 
     final int[][] array1 = new int[][] { { 1, 2 }, { 4, 5 } }; 
     final int[][] array2 = new int[][] { { 1, 2 }, { 4, 6 } }; 
     assertTrue(AnnotationUtils.equals(array1, array2)); 
     assertFalse(AnnotationUtils.equals(array1, array2)); 
     assertFalse(AnnotationUtils.equals(array1, array2)); 
     final int[] array3 = new int[] { 1, 2, 3 }; 
     assertTrue(AnnotationUtils.equals(array3, array3)); 
     assertFalse(AnnotationUtils.equals(array3, array4)); 
     assertFalse(AnnotationUtils.equals(array3, array2)); 
     assertFalse(AnnotationUtils.equals(array3, array1)); 
     assertFalse(AnnotationUtils.equals(array1, array2)); 
     assertTrue(AnnotationUtils.equals(array2, array3)); 
     assertFalse(AnnotationUtils.equals(array3, array4)); 
     assertFalse(AnnotationUtils.equals(array4, array3)); 
 }
@Test
public void testSameInstance525() { 
     assertTrue(AnnotationUtils.equals(field1.getAnnotation(TestAnnotation.class), field1.getAnnotation(TestAnnotation.class))); 
 }
@Test(timeout = 666000) 
 public void testShortArray526() throws Exception { 
     final short[] array1 = new short[] { 1, 2, 3 }; 
     final short[] array2 = new short[] { 4, 5 }; 
     assertTrue(AnnotationUtils.equals(array1, array1)); 
     assertTrue(AnnotationUtils.equals(array1, array2)); 
     array1[1] = (short) 5; 
     assertTrue(AnnotationUtils.equals(array1, array2)); 
     array2 = new short[] { 6, 7 }; 
     assertFalse(AnnotationUtils.equals(array1, array2)); 
     assertFalse(AnnotationUtils.equals(array2, array1)); 
     assertFalse(AnnotationUtils.equals(array1, array2)); 
     array2 = new short[] { 7, 8 }; 
     assertFalse(AnnotationUtils.equals(array1, array2)); 
     assertTrue(AnnotationUtils.equals(array2, array2)); 
 }
@Test(timeout = 666000) 
 public void testMultiCharArray527() throws Exception { 
     final char[] array1 = new char[] { 'A', '2', '_', 'D' }; 
     final char[] array2 = new char[] { 'A', '2', '_', 'D' }; 
     assertTrue(AnnotationUtils.equals(array1, array2)); 
     assertTrue(AnnotationUtils.equals(array1, array2)); 
     assertTrue(AnnotationUtils.equals(array2, array1)); 
     final char[] array3 = new char[] { 'A', '2', '_', 'D' }; 
     assertTrue(AnnotationUtils.equals(array3, array3)); 
     assertFalse(AnnotationUtils.equals(array1, array2)); 
     assertFalse(AnnotationUtils.equals(array1, array3)); 
     assertFalse(AnnotationUtils.equals(array2, array3)); 
     assertFalse(AnnotationUtils.equals(array3, array4)); 
     assertFalse(AnnotationUtils.equals(array4, array3)); 
     assertFalse(AnnotationUtils.equals(array3, array2)); 
     assertFalse(AnnotationUtils.equals(array2, array1)); 
     assertFalse(AnnotationUtils.equals(array1, array2)); 
     assertTrue(AnnotationUtils.equals(array2, array3)); 
     assertFalse(AnnotationUtils.equals(array3, array4)); 
 }
@Test(timeout = 666000) 
 public void testAnnotationsOfDifferingTypes528() throws Exception { 
     final Test testAnno = getClass().getDeclaredMethod("testAnnotations").getAnnotation(Test.class); 
     final TestAnnotation testAnnotation1 = field1.getAnnotation(TestAnnotation.class); 
     final TestAnnotation testAnnotation3 = field3.getAnnotation(TestAnnotation.class); 
     assertFalse(AnnotationUtils.equals(testAnnotation1, testAnnotation3)); 
     assertFalse(AnnotationUtils.equals(testAnnotation3, testAnnotation4)); 
     assertFalse(AnnotationUtils.equals(testAnnotation4, testAnnotation3)); 
     assertFalse(AnnotationUtils.equals(testAnnotation1, testAnnotation4)); 
     assertFalse(AnnotationUtils.equals(testAnnotation3, testAnnotation4)); 
     assertFalse(AnnotationUtils.equals(testAnnotation3, testAnnotation5)); 
     assertFalse(AnnotationUtils.equals(testAnnotation6, testAnnotation7)); 
     assertFalse(AnnotationUtils.equals(testAnnotation7, testAnnotation8)); 
     assertFalse(AnnotationUtils.equals(testAnnotation8, testAnnotation9)); 
     assertFalse(AnnotationUtils.equals(testAnnotation9, testAnnotation10)); 
     assertFalse(AnnotationUtils.equals(testAnnotation10, testAnnotation11)); 
     assertFalse(AnnotationUtils.equals(testAnnotation11, testAnnotation12)); 
     assertFalse(AnnotationUtils.equals(testAnnotation12, testAnnotation13)); 
     assertFalse(AnnotationUtils.equals(testAnnotation13, testAnnotation14)); 
     assertFalse(AnnotationUtils.equals(testAnnotation14, testAnnotation15)); 
     assertFalse(AnnotationUtils.equals(testAnnotation15, testAnnotation16)); 
     assertFalse(AnnotationUtils.equals(testAnnotation16, testAnnotation21)); 
     assertFalse(AnnotationUtils.equals(testAnnotation21, testAnnotation13)); 
     assertFalse(AnnotationUtils.equals(testAnnotation14, testAnnotation15)); 
 }
@Test(timeout = 666000) 
 public void testShortArray529() { 
     short[] array1 = new short[] { 1, 2, 3 }; 
     short[] array2 = new short[] { 4, 6 }; 
     assertTrue(AnnotationUtils.equals(array1, array2)); 
     assertTrue(AnnotationUtils.equals(array1, array2)); 
     array2 = new short[] { 3, 6 }; 
     assertTrue(AnnotationUtils.equals(array2, array2)); 
     assertTrue(AnnotationUtils.equals(array2, array1)); 
     array1 = new short[] { 1, 2, 3 }; 
     assertTrue(AnnotationUtils.equals(array1, array2)); 
     array2 = new short[] { 5, 6, 7 }; 
     assertTrue(AnnotationUtils.equals(array1, array2)); 
     assertTrue(AnnotationUtils.equals(array2, array1)); 
     array2 = new short[] { 6, 7, 8 }; 
     assertFalse(AnnotationUtils.equals(array1, array2)); 
     assertFalse(AnnotationUtils.equals(array1, array2)); 
     assertFalse(AnnotationUtils.equals(array2, array2)); 
 }
@Test
public void testMemberEquals530() throws Exception { 
     final Test test = getClass().getDeclaredMethod("testMemberEquals").getAnnotation(Test.class); 
     assertTrue(AnnotationUtils.equals(test, test)); 
     final TestAnnotation testAnnotation1 = field1.getAnnotation(TestAnnotation.class); 
     assertTrue(AnnotationUtils.equals(testAnnotation1, testAnnotation1)); 
     assertTrue(AnnotationUtils.equals(testAnnotation1, field2.getAnnotation(TestAnnotation.class))); 
     assertTrue(AnnotationUtils.equals(testAnnotation2, field1.getAnnotation(TestAnnotation.class))); 
     assertFalse(AnnotationUtils.equals(testAnnotation1, field2.getAnnotation(TestAnnotation.class))); 
     assertFalse(AnnotationUtils.equals(testAnnotation2, field1.getAnnotation(TestAnnotation.class))); 
     assertFalse(AnnotationUtils.equals(testAnnotation1, null)); 
     assertFalse(AnnotationUtils.equals(null, field2.getAnnotation(TestAnnotation.class))); 
 }
@Test(timeout = 666000) 
 public void testReflectionBooleanArrayArray531() throws Exception { 
     final boolean[] array1 = new boolean[] { true, false, true }; 
     final boolean[] array2 = new boolean[] { true, false, false }; 
     assertTrue(AnnotationUtils.equals(array1, AnnotationUtils.getAnnotation(TestAnnotation.class))); 
     assertTrue(AnnotationUtils.equals(array1, AnnotationUtils.getAnnotation(TestAnnotation.class, array2))); 
     assertTrue(AnnotationUtils.equals(array2, AnnotationUtils.getAnnotation(TestAnnotation.class, array1))); 
     assertFalse(AnnotationUtils.equals(array1, AnnotationUtils.getAnnotation(TestAnnotation.class, array2))); 
     assertFalse(AnnotationUtils.equals(array1, null)); 
     assertFalse(AnnotationUtils.equals(null, array2)); 
     array1[1] = true; 
     assertTrue(AnnotationUtils.equals(array1, array2)); 
     assertFalse(AnnotationUtils.equals(array2, AnnotationUtils.getAnnotation(TestAnnotation.class, array2))); 
 }
@Test(timeout = 666000) 
 public void testDoubleArrayMemberEquals532() throws Exception { 
     final double[] array1 = new double[] { 1.0, 2.9876, -3.00001, 4.3 }; 
     final double[] array2 = new double[] { 1.0, 2.9876, -3.00001, 4.3 }; 
     assertTrue(AnnotationUtils.equals(array1, array1)); 
     assertTrue(AnnotationUtils.equals(array1, array2)); 
     array2 = new double[] { 1.0, 2.9876, -3.00001, 4.3 }; 
     assertTrue(AnnotationUtils.equals(array1, array2)); 
     assertTrue(AnnotationUtils.equals(array2, array1)); 
     array1 = new double[] { 1.0, 2.9876, -3.00001, 4.3 }; 
     assertTrue(AnnotationUtils.equals(array1, array2)); 
     assertFalse(AnnotationUtils.equals(array1, array2)); 
     assertFalse(AnnotationUtils.equals(array2, array1)); 
     array2 = new double[] { 1.0, 2.9876, -3.00001, 4.3 }; 
     assertTrue(AnnotationUtils.equals(array1, array2)); 
     assertFalse(AnnotationUtils.equals(array2, array1)); 
 }
@Test(timeout = 666000) 
 public void testObjectArrayHiddenByObject533() { 
     final Test test = getClass().getDeclaredMethod("testObjectArrayHiddenByObject").getAnnotation(Test.class); 
     final TestAnnotation testAnnotation1 = field1.getAnnotation(TestAnnotation.class); 
     final TestAnnotation testAnnotation3 = field3.getAnnotation(TestAnnotation.class); 
     assertTrue(AnnotationUtils.equals(testAnnotation1, testAnnotation3)); 
     assertTrue(AnnotationUtils.equals(testAnnotation3, testAnnotation4)); 
     assertTrue(AnnotationUtils.equals(testAnnotation4, testAnnotation3)); 
     assertTrue(AnnotationUtils.equals(testAnnotation1, field4.getAnnotation(TestAnnotation.class))); 
     assertTrue(AnnotationUtils.equals(testAnnotation3, field1.getAnnotation(TestAnnotation.class))); 
     assertTrue(AnnotationUtils.equals(testAnnotation4, field3.getAnnotation(TestAnnotation.class))); 
 }
@Test(timeout = 666000) 
 public void testEquivalence534() { 
     assertTrue(AnnotationUtils.arrayMemberEquals(field1.getAnnotation(TestAnnotation.class), field2.getAnnotation(TestAnnotation.class))); 
     assertTrue(AnnotationUtils.arrayMemberEquals(field2.getAnnotation(TestAnnotation.class), field1.getAnnotation(TestAnnotation.class))); 
 }
    

    

    

    

    

    

    

    

    

    

}
