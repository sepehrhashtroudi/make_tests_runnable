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

@Test
public void testNonEquivalentAnnotationsOfSameType30() { 
     assertFalse(AnnotationUtils.equals(field1.getAnnotation(TestAnnotation.class), field3.getAnnotation(TestAnnotation.class))); 
     assertFalse(AnnotationUtils.equals(field3.getAnnotation(TestAnnotation.class), field1.getAnnotation(TestAnnotation.class))); 
 }
@Test
public void testNonEquivalentAnnotationsOfSameType33() { 
     assertFalse(AnnotationUtils.equals(field1.getAnnotation(TestAnnotation.class), field3.getAnnotation(TestAnnotation.class))); 
     assertFalse(AnnotationUtils.equals(field3.getAnnotation(TestAnnotation.class), field1.getAnnotation(TestAnnotation.class))); 
 }
@Test
public void testNonEquivalentAnnotationsOfSameType107() { 
     assertFalse(AnnotationUtils.equals(field1.getAnnotation(TestAnnotation.class), field3.getAnnotation(TestAnnotation.class))); 
     assertFalse(AnnotationUtils.equals(field3.getAnnotation(TestAnnotation.class), field1.getAnnotation(TestAnnotation.class))); 
 }
@Test(timeout = 666000) 
 public void testHashCode152() throws Exception { 
     final Test test = getClass().getDeclaredMethod("testHashCode").getAnnotation(Test.class); 
     assertEquals(test.hashCode(), AnnotationUtils.hashCode(test)); 
     final TestAnnotation testAnnotation1 = field1.getAnnotation(TestAnnotation.class); 
     assertEquals(testAnnotation1.hashCode(), AnnotationUtils.hashCode(testAnnotation1)); 
     final TestAnnotation testAnnotation3 = field3.getAnnotation(TestAnnotation.class); 
     assertEquals(testAnnotation3.hashCode(), AnnotationUtils.hashCode(testAnnotation3)); 
 }
@Test(timeout = 666000) 
 public void testHashCode299() throws Exception { 
     final Test test = getClass().getDeclaredMethod("testHashCode").getAnnotation(Test.class); 
     assertEquals(test.hashCode(), AnnotationUtils.hashCode(test)); 
     final TestAnnotation testAnnotation1 = field1.getAnnotation(TestAnnotation.class); 
     assertEquals(testAnnotation1.hashCode(), AnnotationUtils.hashCode(testAnnotation1)); 
     final TestAnnotation testAnnotation3 = field3.getAnnotation(TestAnnotation.class); 
     assertEquals(testAnnotation3.hashCode(), AnnotationUtils.hashCode(testAnnotation3)); 
 }
@Test(timeout = 666000) 
 public void testHashCode378() throws Exception { 
     final Test test = getClass().getDeclaredMethod("testHashCode").getAnnotation(Test.class); 
     assertEquals(test.hashCode(), AnnotationUtils.hashCode(test)); 
     final TestAnnotation testAnnotation1 = field1.getAnnotation(TestAnnotation.class); 
     assertEquals(testAnnotation1.hashCode(), AnnotationUtils.hashCode(testAnnotation1)); 
     final TestAnnotation testAnnotation3 = field3.getAnnotation(TestAnnotation.class); 
     assertEquals(testAnnotation3.hashCode(), AnnotationUtils.hashCode(testAnnotation3)); 
 }
@Test
public void testOneArgNull732() { 
     assertFalse(AnnotationUtils.equals(field1.getAnnotation(TestAnnotation.class), null)); 
     assertFalse(AnnotationUtils.equals(null, field1.getAnnotation(TestAnnotation.class))); 
 }
@Test
public void testNonEquivalentAnnotationsOfSameType769() { 
     assertFalse(AnnotationUtils.equals(field1.getAnnotation(TestAnnotation.class), field3.getAnnotation(TestAnnotation.class))); 
     assertFalse(AnnotationUtils.equals(field3.getAnnotation(TestAnnotation.class), field1.getAnnotation(TestAnnotation.class))); 
 }
@Test
public void testNonEquivalentAnnotationsOfSameType844() { 
     assertFalse(AnnotationUtils.equals(field1.getAnnotation(TestAnnotation.class), field3.getAnnotation(TestAnnotation.class))); 
     assertFalse(AnnotationUtils.equals(field3.getAnnotation(TestAnnotation.class), field1.getAnnotation(TestAnnotation.class))); 
 }
@Test
public void testNonEquivalentAnnotationsOfSameType881() { 
     assertFalse(AnnotationUtils.equals(field1.getAnnotation(TestAnnotation.class), field3.getAnnotation(TestAnnotation.class))); 
     assertFalse(AnnotationUtils.equals(field3.getAnnotation(TestAnnotation.class), field1.getAnnotation(TestAnnotation.class))); 
 }
@Test
public void testNonEquivalentAnnotationsOfSameType993() { 
     assertFalse(AnnotationUtils.equals(field1.getAnnotation(TestAnnotation.class), field3.getAnnotation(TestAnnotation.class))); 
     assertFalse(AnnotationUtils.equals(field3.getAnnotation(TestAnnotation.class), field1.getAnnotation(TestAnnotation.class))); 
 }
@Test(timeout = 666000) 
 public void testHashCode1223() throws Exception { 
     final Test test = getClass().getDeclaredMethod("testHashCode").getAnnotation(Test.class); 
     assertEquals(test.hashCode(), AnnotationUtils.hashCode(test)); 
     final TestAnnotation testAnnotation1 = field1.getAnnotation(TestAnnotation.class); 
     assertEquals(testAnnotation1.hashCode(), AnnotationUtils.hashCode(testAnnotation1)); 
     final TestAnnotation testAnnotation3 = field3.getAnnotation(TestAnnotation.class); 
     assertEquals(testAnnotation3.hashCode(), AnnotationUtils.hashCode(testAnnotation3)); 
 }
@Test
public void testNonEquivalentAnnotationsOfSameType1468() { 
     assertFalse(AnnotationUtils.equals(field1.getAnnotation(TestAnnotation.class), field3.getAnnotation(TestAnnotation.class))); 
     assertFalse(AnnotationUtils.equals(field3.getAnnotation(TestAnnotation.class), field1.getAnnotation(TestAnnotation.class))); 
 }
@Test(timeout = 666000) 
 public void testHashCode1604() throws Exception { 
     final Test test = getClass().getDeclaredMethod("testHashCode").getAnnotation(Test.class); 
     assertEquals(test.hashCode(), AnnotationUtils.hashCode(test)); 
     final TestAnnotation testAnnotation1 = field1.getAnnotation(TestAnnotation.class); 
     assertEquals(testAnnotation1.hashCode(), AnnotationUtils.hashCode(testAnnotation1)); 
     final TestAnnotation testAnnotation3 = field3.getAnnotation(TestAnnotation.class); 
     assertEquals(testAnnotation3.hashCode(), AnnotationUtils.hashCode(testAnnotation3)); 
 }
@Test(timeout = 666000) 
 public void testHashCode1643() throws Exception { 
     final Test test = getClass().getDeclaredMethod("testHashCode").getAnnotation(Test.class); 
     assertEquals(test.hashCode(), AnnotationUtils.hashCode(test)); 
     final TestAnnotation testAnnotation1 = field1.getAnnotation(TestAnnotation.class); 
     assertEquals(testAnnotation1.hashCode(), AnnotationUtils.hashCode(testAnnotation1)); 
     final TestAnnotation testAnnotation3 = field3.getAnnotation(TestAnnotation.class); 
     assertEquals(testAnnotation3.hashCode(), AnnotationUtils.hashCode(testAnnotation3)); 
 }
@Test
public void testNonEquivalentAnnotationsOfSameType1770() { 
     assertFalse(AnnotationUtils.equals(field1.getAnnotation(TestAnnotation.class), field3.getAnnotation(TestAnnotation.class))); 
     assertFalse(AnnotationUtils.equals(field3.getAnnotation(TestAnnotation.class), field1.getAnnotation(TestAnnotation.class))); 
 }
@Test(timeout = 666000) 
 public void testHashCode1827() throws Exception { 
     final Test test = getClass().getDeclaredMethod("testHashCode").getAnnotation(Test.class); 
     assertEquals(test.hashCode(), AnnotationUtils.hashCode(test)); 
     final TestAnnotation testAnnotation1 = field1.getAnnotation(TestAnnotation.class); 
     assertEquals(testAnnotation1.hashCode(), AnnotationUtils.hashCode(testAnnotation1)); 
     final TestAnnotation testAnnotation3 = field3.getAnnotation(TestAnnotation.class); 
     assertEquals(testAnnotation3.hashCode(), AnnotationUtils.hashCode(testAnnotation3)); 
 }
@Test(timeout = 666000) 
 public void testHashCode1835() throws Exception { 
     final Test test = getClass().getDeclaredMethod("testHashCode").getAnnotation(Test.class); 
     assertEquals(test.hashCode(), AnnotationUtils.hashCode(test)); 
     final TestAnnotation testAnnotation1 = field1.getAnnotation(TestAnnotation.class); 
     assertEquals(testAnnotation1.hashCode(), AnnotationUtils.hashCode(testAnnotation1)); 
     final TestAnnotation testAnnotation3 = field3.getAnnotation(TestAnnotation.class); 
     assertEquals(testAnnotation3.hashCode(), AnnotationUtils.hashCode(testAnnotation3)); 
 }
@Test
public void testEquivalence1853() { 
     assertTrue(AnnotationUtils.equals(field1.getAnnotation(TestAnnotation.class), field2.getAnnotation(TestAnnotation.class))); 
     assertTrue(AnnotationUtils.equals(field2.getAnnotation(TestAnnotation.class), field1.getAnnotation(TestAnnotation.class))); 
 }
@Test
public void testNonEquivalentAnnotationsOfSameType1910() { 
     assertFalse(AnnotationUtils.equals(field1.getAnnotation(TestAnnotation.class), field3.getAnnotation(TestAnnotation.class))); 
     assertFalse(AnnotationUtils.equals(field3.getAnnotation(TestAnnotation.class), field1.getAnnotation(TestAnnotation.class))); 
 }
@Test
public void testEquivalence2102() { 
     assertTrue(AnnotationUtils.equals(field1.getAnnotation(TestAnnotation.class), field2.getAnnotation(TestAnnotation.class))); 
     assertTrue(AnnotationUtils.equals(field2.getAnnotation(TestAnnotation.class), field1.getAnnotation(TestAnnotation.class))); 
 }
@Test(timeout = 666000) 
 public void testHashCode2165() throws Exception { 
     final Test test = getClass().getDeclaredMethod("testHashCode").getAnnotation(Test.class); 
     assertEquals(test.hashCode(), AnnotationUtils.hashCode(test)); 
     final TestAnnotation testAnnotation1 = field1.getAnnotation(TestAnnotation.class); 
     assertEquals(testAnnotation1.hashCode(), AnnotationUtils.hashCode(testAnnotation1)); 
     final TestAnnotation testAnnotation3 = field3.getAnnotation(TestAnnotation.class); 
     assertEquals(testAnnotation3.hashCode(), AnnotationUtils.hashCode(testAnnotation3)); 
 }
@Test
public void testNonEquivalentAnnotationsOfSameType2262() { 
     assertFalse(AnnotationUtils.equals(field1.getAnnotation(TestAnnotation.class), field3.getAnnotation(TestAnnotation.class))); 
     assertFalse(AnnotationUtils.equals(field3.getAnnotation(TestAnnotation.class), field1.getAnnotation(TestAnnotation.class))); 
 }
@Test
public void testNonEquivalentAnnotationsOfSameType2390() { 
     assertFalse(AnnotationUtils.equals(field1.getAnnotation(TestAnnotation.class), field3.getAnnotation(TestAnnotation.class))); 
     assertFalse(AnnotationUtils.equals(field3.getAnnotation(TestAnnotation.class), field1.getAnnotation(TestAnnotation.class))); 
 }
@Test
public void testNonEquivalentAnnotationsOfSameType2412() { 
     assertFalse(AnnotationUtils.equals(field1.getAnnotation(TestAnnotation.class), field3.getAnnotation(TestAnnotation.class))); 
     assertFalse(AnnotationUtils.equals(field3.getAnnotation(TestAnnotation.class), field1.getAnnotation(TestAnnotation.class))); 
 }
@Test(timeout = 666000) 
 public void testHashCode2573() throws Exception { 
     final Test test = getClass().getDeclaredMethod("testHashCode").getAnnotation(Test.class); 
     assertEquals(test.hashCode(), AnnotationUtils.hashCode(test)); 
     final TestAnnotation testAnnotation1 = field1.getAnnotation(TestAnnotation.class); 
     assertEquals(testAnnotation1.hashCode(), AnnotationUtils.hashCode(testAnnotation1)); 
     final TestAnnotation testAnnotation3 = field3.getAnnotation(TestAnnotation.class); 
     assertEquals(testAnnotation3.hashCode(), AnnotationUtils.hashCode(testAnnotation3)); 
 }
@Test
public void testNonEquivalentAnnotationsOfSameType2669() { 
     assertFalse(AnnotationUtils.equals(field1.getAnnotation(TestAnnotation.class), field3.getAnnotation(TestAnnotation.class))); 
     assertFalse(AnnotationUtils.equals(field3.getAnnotation(TestAnnotation.class), field1.getAnnotation(TestAnnotation.class))); 
 }
@Test
public void testNonEquivalentAnnotationsOfSameType2685() { 
     assertFalse(AnnotationUtils.equals(field1.getAnnotation(TestAnnotation.class), field3.getAnnotation(TestAnnotation.class))); 
     assertFalse(AnnotationUtils.equals(field3.getAnnotation(TestAnnotation.class), field1.getAnnotation(TestAnnotation.class))); 
 }
@Test
public void testAnnotationsOfDifferingTypes2740() { 
     assertFalse(AnnotationUtils.equals(field1.getAnnotation(TestAnnotation.class), field4.getAnnotation(NestAnnotation.class))); 
     assertFalse(AnnotationUtils.equals(field4.getAnnotation(NestAnnotation.class), field1.getAnnotation(TestAnnotation.class))); 
 }
@Test
public void testNonEquivalentAnnotationsOfSameType2787() { 
     assertFalse(AnnotationUtils.equals(field1.getAnnotation(TestAnnotation.class), field3.getAnnotation(TestAnnotation.class))); 
     assertFalse(AnnotationUtils.equals(field3.getAnnotation(TestAnnotation.class), field1.getAnnotation(TestAnnotation.class))); 
 }
@Test
public void testOneArgNull2820() { 
     assertFalse(AnnotationUtils.equals(field1.getAnnotation(TestAnnotation.class), null)); 
     assertFalse(AnnotationUtils.equals(null, field1.getAnnotation(TestAnnotation.class))); 
 }
@Test(timeout = 666000) 
 public void testHashCode2922() throws Exception { 
     final Test test = getClass().getDeclaredMethod("testHashCode").getAnnotation(Test.class); 
     assertEquals(test.hashCode(), AnnotationUtils.hashCode(test)); 
     final TestAnnotation testAnnotation1 = field1.getAnnotation(TestAnnotation.class); 
     assertEquals(testAnnotation1.hashCode(), AnnotationUtils.hashCode(testAnnotation1)); 
     final TestAnnotation testAnnotation3 = field3.getAnnotation(TestAnnotation.class); 
     assertEquals(testAnnotation3.hashCode(), AnnotationUtils.hashCode(testAnnotation3)); 
 }
@Test
public void testNonEquivalentAnnotationsOfSameType3013() { 
     assertFalse(AnnotationUtils.equals(field1.getAnnotation(TestAnnotation.class), field3.getAnnotation(TestAnnotation.class))); 
     assertFalse(AnnotationUtils.equals(field3.getAnnotation(TestAnnotation.class), field1.getAnnotation(TestAnnotation.class))); 
 }
@Test
public void testOneArgNull3062() { 
     assertFalse(AnnotationUtils.equals(field1.getAnnotation(TestAnnotation.class), null)); 
     assertFalse(AnnotationUtils.equals(null, field1.getAnnotation(TestAnnotation.class))); 
 }
@Test(timeout = 666000) 
 public void testHashCode3165() throws Exception { 
     final Test test = getClass().getDeclaredMethod("testHashCode").getAnnotation(Test.class); 
     assertEquals(test.hashCode(), AnnotationUtils.hashCode(test)); 
     final TestAnnotation testAnnotation1 = field1.getAnnotation(TestAnnotation.class); 
     assertEquals(testAnnotation1.hashCode(), AnnotationUtils.hashCode(testAnnotation1)); 
     final TestAnnotation testAnnotation3 = field3.getAnnotation(TestAnnotation.class); 
     assertEquals(testAnnotation3.hashCode(), AnnotationUtils.hashCode(testAnnotation3)); 
 }
@Test
public void testNonEquivalentAnnotationsOfSameType3396() { 
     assertFalse(AnnotationUtils.equals(field1.getAnnotation(TestAnnotation.class), field3.getAnnotation(TestAnnotation.class))); 
     assertFalse(AnnotationUtils.equals(field3.getAnnotation(TestAnnotation.class), field1.getAnnotation(TestAnnotation.class))); 
 }
@Test(timeout = 666000) 
 public void testHashCode3450() throws Exception { 
     final Test test = getClass().getDeclaredMethod("testHashCode").getAnnotation(Test.class); 
     assertEquals(test.hashCode(), AnnotationUtils.hashCode(test)); 
     final TestAnnotation testAnnotation1 = field1.getAnnotation(TestAnnotation.class); 
     assertEquals(testAnnotation1.hashCode(), AnnotationUtils.hashCode(testAnnotation1)); 
     final TestAnnotation testAnnotation3 = field3.getAnnotation(TestAnnotation.class); 
     assertEquals(testAnnotation3.hashCode(), AnnotationUtils.hashCode(testAnnotation3)); 
 }
@Test(timeout = 666000) 
 public void testHashCode3545() throws Exception { 
     final Test test = getClass().getDeclaredMethod("testHashCode").getAnnotation(Test.class); 
     assertEquals(test.hashCode(), AnnotationUtils.hashCode(test)); 
     final TestAnnotation testAnnotation1 = field1.getAnnotation(TestAnnotation.class); 
     assertEquals(testAnnotation1.hashCode(), AnnotationUtils.hashCode(testAnnotation1)); 
     final TestAnnotation testAnnotation3 = field3.getAnnotation(TestAnnotation.class); 
     assertEquals(testAnnotation3.hashCode(), AnnotationUtils.hashCode(testAnnotation3)); 
 }
@Test
public void testNonEquivalentAnnotationsOfSameType3597() { 
     assertFalse(AnnotationUtils.equals(field1.getAnnotation(TestAnnotation.class), field3.getAnnotation(TestAnnotation.class))); 
     assertFalse(AnnotationUtils.equals(field3.getAnnotation(TestAnnotation.class), field1.getAnnotation(TestAnnotation.class))); 
 }
@Test(timeout = 666000) 
 public void testHashCode3625() throws Exception { 
     final Test test = getClass().getDeclaredMethod("testHashCode").getAnnotation(Test.class); 
     assertEquals(test.hashCode(), AnnotationUtils.hashCode(test)); 
     final TestAnnotation testAnnotation1 = field1.getAnnotation(TestAnnotation.class); 
     assertEquals(testAnnotation1.hashCode(), AnnotationUtils.hashCode(testAnnotation1)); 
     final TestAnnotation testAnnotation3 = field3.getAnnotation(TestAnnotation.class); 
     assertEquals(testAnnotation3.hashCode(), AnnotationUtils.hashCode(testAnnotation3)); 
 }
@Test
public void testNonEquivalentAnnotationsOfSameType3653() { 
     assertFalse(AnnotationUtils.equals(field1.getAnnotation(TestAnnotation.class), field3.getAnnotation(TestAnnotation.class))); 
     assertFalse(AnnotationUtils.equals(field3.getAnnotation(TestAnnotation.class), field1.getAnnotation(TestAnnotation.class))); 
 }
@Test(timeout = 666000) 
 public void testHashCode3841() throws Exception { 
     final Test test = getClass().getDeclaredMethod("testHashCode").getAnnotation(Test.class); 
     assertEquals(test.hashCode(), AnnotationUtils.hashCode(test)); 
     final TestAnnotation testAnnotation1 = field1.getAnnotation(TestAnnotation.class); 
     assertEquals(testAnnotation1.hashCode(), AnnotationUtils.hashCode(testAnnotation1)); 
     final TestAnnotation testAnnotation3 = field3.getAnnotation(TestAnnotation.class); 
     assertEquals(testAnnotation3.hashCode(), AnnotationUtils.hashCode(testAnnotation3)); 
 }
@Test(timeout = 666000) 
 public void testHashCode3842() throws Exception { 
     final Test test = getClass().getDeclaredMethod("testHashCode").getAnnotation(Test.class); 
     assertEquals(test.hashCode(), AnnotationUtils.hashCode(test)); 
     final TestAnnotation testAnnotation1 = field1.getAnnotation(TestAnnotation.class); 
     assertEquals(testAnnotation1.hashCode(), AnnotationUtils.hashCode(testAnnotation1)); 
     final TestAnnotation testAnnotation3 = field3.getAnnotation(TestAnnotation.class); 
     assertEquals(testAnnotation3.hashCode(), AnnotationUtils.hashCode(testAnnotation3)); 
 }
@Test
public void testOneArgNull3848() { 
     assertFalse(AnnotationUtils.equals(field1.getAnnotation(TestAnnotation.class), null)); 
     assertFalse(AnnotationUtils.equals(null, field1.getAnnotation(TestAnnotation.class))); 
 }
@Test(timeout = 666000) 
 public void testHashCode3885() throws Exception { 
     final Test test = getClass().getDeclaredMethod("testHashCode").getAnnotation(Test.class); 
     assertEquals(test.hashCode(), AnnotationUtils.hashCode(test)); 
     final TestAnnotation testAnnotation1 = field1.getAnnotation(TestAnnotation.class); 
     assertEquals(testAnnotation1.hashCode(), AnnotationUtils.hashCode(testAnnotation1)); 
     final TestAnnotation testAnnotation3 = field3.getAnnotation(TestAnnotation.class); 
     assertEquals(testAnnotation3.hashCode(), AnnotationUtils.hashCode(testAnnotation3)); 
 }
@Test(timeout = 666000) 
 public void testHashCode4193() throws Exception { 
     final Test test = getClass().getDeclaredMethod("testHashCode").getAnnotation(Test.class); 
     assertEquals(test.hashCode(), AnnotationUtils.hashCode(test)); 
     final TestAnnotation testAnnotation1 = field1.getAnnotation(TestAnnotation.class); 
     assertEquals(testAnnotation1.hashCode(), AnnotationUtils.hashCode(testAnnotation1)); 
     final TestAnnotation testAnnotation3 = field3.getAnnotation(TestAnnotation.class); 
     assertEquals(testAnnotation3.hashCode(), AnnotationUtils.hashCode(testAnnotation3)); 
 }
@Test(timeout = 666000) 
 public void testHashCode4200() throws Exception { 
     final Test test = getClass().getDeclaredMethod("testHashCode").getAnnotation(Test.class); 
     assertEquals(test.hashCode(), AnnotationUtils.hashCode(test)); 
     final TestAnnotation testAnnotation1 = field1.getAnnotation(TestAnnotation.class); 
     assertEquals(testAnnotation1.hashCode(), AnnotationUtils.hashCode(testAnnotation1)); 
     final TestAnnotation testAnnotation3 = field3.getAnnotation(TestAnnotation.class); 
     assertEquals(testAnnotation3.hashCode(), AnnotationUtils.hashCode(testAnnotation3)); 
 }
@Test
public void testNonEquivalentAnnotationsOfSameType4241() { 
     assertFalse(AnnotationUtils.equals(field1.getAnnotation(TestAnnotation.class), field3.getAnnotation(TestAnnotation.class))); 
     assertFalse(AnnotationUtils.equals(field3.getAnnotation(TestAnnotation.class), field1.getAnnotation(TestAnnotation.class))); 
 }
@Test
public void testNonEquivalentAnnotationsOfSameType4243() { 
     assertFalse(AnnotationUtils.equals(field1.getAnnotation(TestAnnotation.class), field3.getAnnotation(TestAnnotation.class))); 
     assertFalse(AnnotationUtils.equals(field3.getAnnotation(TestAnnotation.class), field1.getAnnotation(TestAnnotation.class))); 
 }
@Test
public void testNonEquivalentAnnotationsOfSameType4388() { 
     assertFalse(AnnotationUtils.equals(field1.getAnnotation(TestAnnotation.class), field3.getAnnotation(TestAnnotation.class))); 
     assertFalse(AnnotationUtils.equals(field3.getAnnotation(TestAnnotation.class), field1.getAnnotation(TestAnnotation.class))); 
 }
@Test
public void testNonEquivalentAnnotationsOfSameType4721() { 
     assertFalse(AnnotationUtils.equals(field1.getAnnotation(TestAnnotation.class), field3.getAnnotation(TestAnnotation.class))); 
     assertFalse(AnnotationUtils.equals(field3.getAnnotation(TestAnnotation.class), field1.getAnnotation(TestAnnotation.class))); 
 }
@Test
public void testNonEquivalentAnnotationsOfSameType4802() { 
     assertFalse(AnnotationUtils.equals(field1.getAnnotation(TestAnnotation.class), field3.getAnnotation(TestAnnotation.class))); 
     assertFalse(AnnotationUtils.equals(field3.getAnnotation(TestAnnotation.class), field1.getAnnotation(TestAnnotation.class))); 
 }
@Test(timeout = 666000) 
 public void testHashCode4917() throws Exception { 
     final Test test = getClass().getDeclaredMethod("testHashCode").getAnnotation(Test.class); 
     assertEquals(test.hashCode(), AnnotationUtils.hashCode(test)); 
     final TestAnnotation testAnnotation1 = field1.getAnnotation(TestAnnotation.class); 
     assertEquals(testAnnotation1.hashCode(), AnnotationUtils.hashCode(testAnnotation1)); 
     final TestAnnotation testAnnotation3 = field3.getAnnotation(TestAnnotation.class); 
     assertEquals(testAnnotation3.hashCode(), AnnotationUtils.hashCode(testAnnotation3)); 
 }
@Test
public void testNonEquivalentAnnotationsOfSameType4970() { 
     assertFalse(AnnotationUtils.equals(field1.getAnnotation(TestAnnotation.class), field3.getAnnotation(TestAnnotation.class))); 
     assertFalse(AnnotationUtils.equals(field3.getAnnotation(TestAnnotation.class), field1.getAnnotation(TestAnnotation.class))); 
 }
@Test(timeout = 666000) 
 public void testHashCode5010() throws Exception { 
     final Test test = getClass().getDeclaredMethod("testHashCode").getAnnotation(Test.class); 
     assertEquals(test.hashCode(), AnnotationUtils.hashCode(test)); 
     final TestAnnotation testAnnotation1 = field1.getAnnotation(TestAnnotation.class); 
     assertEquals(testAnnotation1.hashCode(), AnnotationUtils.hashCode(testAnnotation1)); 
     final TestAnnotation testAnnotation3 = field3.getAnnotation(TestAnnotation.class); 
     assertEquals(testAnnotation3.hashCode(), AnnotationUtils.hashCode(testAnnotation3)); 
 }
@Test(timeout = 666000) 
 public void testHashCode5012() throws Exception { 
     final Test test = getClass().getDeclaredMethod("testHashCode").getAnnotation(Test.class); 
     assertEquals(test.hashCode(), AnnotationUtils.hashCode(test)); 
     final TestAnnotation testAnnotation1 = field1.getAnnotation(TestAnnotation.class); 
     assertEquals(testAnnotation1.hashCode(), AnnotationUtils.hashCode(testAnnotation1)); 
     final TestAnnotation testAnnotation3 = field3.getAnnotation(TestAnnotation.class); 
     assertEquals(testAnnotation3.hashCode(), AnnotationUtils.hashCode(testAnnotation3)); 
 }
@Test
public void testNonEquivalentAnnotationsOfSameType5307() { 
     assertFalse(AnnotationUtils.equals(field1.getAnnotation(TestAnnotation.class), field3.getAnnotation(TestAnnotation.class))); 
     assertFalse(AnnotationUtils.equals(field3.getAnnotation(TestAnnotation.class), field1.getAnnotation(TestAnnotation.class))); 
 }
@Test(timeout = 666000) 
 public void testHashCode5357() throws Exception { 
     final Test test = getClass().getDeclaredMethod("testHashCode").getAnnotation(Test.class); 
     assertEquals(test.hashCode(), AnnotationUtils.hashCode(test)); 
     final TestAnnotation testAnnotation1 = field1.getAnnotation(TestAnnotation.class); 
     assertEquals(testAnnotation1.hashCode(), AnnotationUtils.hashCode(testAnnotation1)); 
     final TestAnnotation testAnnotation3 = field3.getAnnotation(TestAnnotation.class); 
     assertEquals(testAnnotation3.hashCode(), AnnotationUtils.hashCode(testAnnotation3)); 
 }
@Test(timeout = 666000) 
 public void testHashCode5545() throws Exception { 
     final Test test = getClass().getDeclaredMethod("testHashCode").getAnnotation(Test.class); 
     assertEquals(test.hashCode(), AnnotationUtils.hashCode(test)); 
     final TestAnnotation testAnnotation1 = field1.getAnnotation(TestAnnotation.class); 
     assertEquals(testAnnotation1.hashCode(), AnnotationUtils.hashCode(testAnnotation1)); 
     final TestAnnotation testAnnotation3 = field3.getAnnotation(TestAnnotation.class); 
     assertEquals(testAnnotation3.hashCode(), AnnotationUtils.hashCode(testAnnotation3)); 
 }
@Test
public void testNonEquivalentAnnotationsOfSameType5608() { 
     assertFalse(AnnotationUtils.equals(field1.getAnnotation(TestAnnotation.class), field3.getAnnotation(TestAnnotation.class))); 
     assertFalse(AnnotationUtils.equals(field3.getAnnotation(TestAnnotation.class), field1.getAnnotation(TestAnnotation.class))); 
 }
@Test
public void testNonEquivalentAnnotationsOfSameType5809() { 
     assertFalse(AnnotationUtils.equals(field1.getAnnotation(TestAnnotation.class), field3.getAnnotation(TestAnnotation.class))); 
     assertFalse(AnnotationUtils.equals(field3.getAnnotation(TestAnnotation.class), field1.getAnnotation(TestAnnotation.class))); 
 }
@Test
public void testOneArgNull5953() { 
     assertFalse(AnnotationUtils.equals(field1.getAnnotation(TestAnnotation.class), null)); 
     assertFalse(AnnotationUtils.equals(null, field1.getAnnotation(TestAnnotation.class))); 
 }
@Test
public void testNonEquivalentAnnotationsOfSameType5966() { 
     assertFalse(AnnotationUtils.equals(field1.getAnnotation(TestAnnotation.class), field3.getAnnotation(TestAnnotation.class))); 
     assertFalse(AnnotationUtils.equals(field3.getAnnotation(TestAnnotation.class), field1.getAnnotation(TestAnnotation.class))); 
 }
@Test
public void testNonEquivalentAnnotationsOfSameType6091() { 
     assertFalse(AnnotationUtils.equals(field1.getAnnotation(TestAnnotation.class), field3.getAnnotation(TestAnnotation.class))); 
     assertFalse(AnnotationUtils.equals(field3.getAnnotation(TestAnnotation.class), field1.getAnnotation(TestAnnotation.class))); 
 }
@Test
public void testNonEquivalentAnnotationsOfSameType6392() { 
     assertFalse(AnnotationUtils.equals(field1.getAnnotation(TestAnnotation.class), field3.getAnnotation(TestAnnotation.class))); 
     assertFalse(AnnotationUtils.equals(field3.getAnnotation(TestAnnotation.class), field1.getAnnotation(TestAnnotation.class))); 
 }
@Test(timeout = 666000) 
 public void testHashCode6511() throws Exception { 
     final Test test = getClass().getDeclaredMethod("testHashCode").getAnnotation(Test.class); 
     assertEquals(test.hashCode(), AnnotationUtils.hashCode(test)); 
     final TestAnnotation testAnnotation1 = field1.getAnnotation(TestAnnotation.class); 
     assertEquals(testAnnotation1.hashCode(), AnnotationUtils.hashCode(testAnnotation1)); 
     final TestAnnotation testAnnotation3 = field3.getAnnotation(TestAnnotation.class); 
     assertEquals(testAnnotation3.hashCode(), AnnotationUtils.hashCode(testAnnotation3)); 
 }
@Test
public void testSameInstance6661() { 
     assertTrue(AnnotationUtils.equals(field1.getAnnotation(TestAnnotation.class), field1.getAnnotation(TestAnnotation.class))); 
 }
@Test(timeout = 666000) 
 public void testHashCode6762() throws Exception { 
     final Test test = getClass().getDeclaredMethod("testHashCode").getAnnotation(Test.class); 
     assertEquals(test.hashCode(), AnnotationUtils.hashCode(test)); 
     final TestAnnotation testAnnotation1 = field1.getAnnotation(TestAnnotation.class); 
     assertEquals(testAnnotation1.hashCode(), AnnotationUtils.hashCode(testAnnotation1)); 
     final TestAnnotation testAnnotation3 = field3.getAnnotation(TestAnnotation.class); 
     assertEquals(testAnnotation3.hashCode(), AnnotationUtils.hashCode(testAnnotation3)); 
 }
@Test
public void testEquivalence6780() { 
     assertTrue(AnnotationUtils.equals(field1.getAnnotation(TestAnnotation.class), field2.getAnnotation(TestAnnotation.class))); 
     assertTrue(AnnotationUtils.equals(field2.getAnnotation(TestAnnotation.class), field1.getAnnotation(TestAnnotation.class))); 
 }
@Test(timeout = 666000) 
 public void testHashCode6812() throws Exception { 
     final Test test = getClass().getDeclaredMethod("testHashCode").getAnnotation(Test.class); 
     assertEquals(test.hashCode(), AnnotationUtils.hashCode(test)); 
     final TestAnnotation testAnnotation1 = field1.getAnnotation(TestAnnotation.class); 
     assertEquals(testAnnotation1.hashCode(), AnnotationUtils.hashCode(testAnnotation1)); 
     final TestAnnotation testAnnotation3 = field3.getAnnotation(TestAnnotation.class); 
     assertEquals(testAnnotation3.hashCode(), AnnotationUtils.hashCode(testAnnotation3)); 
 }
@Test(timeout = 666000) 
 public void testHashCode6976() throws Exception { 
     final Test test = getClass().getDeclaredMethod("testHashCode").getAnnotation(Test.class); 
     assertEquals(test.hashCode(), AnnotationUtils.hashCode(test)); 
     final TestAnnotation testAnnotation1 = field1.getAnnotation(TestAnnotation.class); 
     assertEquals(testAnnotation1.hashCode(), AnnotationUtils.hashCode(testAnnotation1)); 
     final TestAnnotation testAnnotation3 = field3.getAnnotation(TestAnnotation.class); 
     assertEquals(testAnnotation3.hashCode(), AnnotationUtils.hashCode(testAnnotation3)); 
 }
@Test
public void testNonEquivalentAnnotationsOfSameType7140() { 
     assertFalse(AnnotationUtils.equals(field1.getAnnotation(TestAnnotation.class), field3.getAnnotation(TestAnnotation.class))); 
     assertFalse(AnnotationUtils.equals(field3.getAnnotation(TestAnnotation.class), field1.getAnnotation(TestAnnotation.class))); 
 }
@Test
public void testAnnotationsOfDifferingTypes7186() { 
     assertFalse(AnnotationUtils.equals(field1.getAnnotation(TestAnnotation.class), field4.getAnnotation(NestAnnotation.class))); 
     assertFalse(AnnotationUtils.equals(field4.getAnnotation(NestAnnotation.class), field1.getAnnotation(TestAnnotation.class))); 
 }
@Test
public void testNonEquivalentAnnotationsOfSameType7250() { 
     assertFalse(AnnotationUtils.equals(field1.getAnnotation(TestAnnotation.class), field3.getAnnotation(TestAnnotation.class))); 
     assertFalse(AnnotationUtils.equals(field3.getAnnotation(TestAnnotation.class), field1.getAnnotation(TestAnnotation.class))); 
 }
@Test
public void testNonEquivalentAnnotationsOfSameType7281() { 
     assertFalse(AnnotationUtils.equals(field1.getAnnotation(TestAnnotation.class), field3.getAnnotation(TestAnnotation.class))); 
     assertFalse(AnnotationUtils.equals(field3.getAnnotation(TestAnnotation.class), field1.getAnnotation(TestAnnotation.class))); 
 }
@Test
public void testNonEquivalentAnnotationsOfSameType7288() { 
     assertFalse(AnnotationUtils.equals(field1.getAnnotation(TestAnnotation.class), field3.getAnnotation(TestAnnotation.class))); 
     assertFalse(AnnotationUtils.equals(field3.getAnnotation(TestAnnotation.class), field1.getAnnotation(TestAnnotation.class))); 
 }
@Test(timeout = 666000) 
 public void testHashCode7298() throws Exception { 
     final Test test = getClass().getDeclaredMethod("testHashCode").getAnnotation(Test.class); 
     assertEquals(test.hashCode(), AnnotationUtils.hashCode(test)); 
     final TestAnnotation testAnnotation1 = field1.getAnnotation(TestAnnotation.class); 
     assertEquals(testAnnotation1.hashCode(), AnnotationUtils.hashCode(testAnnotation1)); 
     final TestAnnotation testAnnotation3 = field3.getAnnotation(TestAnnotation.class); 
     assertEquals(testAnnotation3.hashCode(), AnnotationUtils.hashCode(testAnnotation3)); 
 }
@Test
public void testNonEquivalentAnnotationsOfSameType7346() { 
     assertFalse(AnnotationUtils.equals(field1.getAnnotation(TestAnnotation.class), field3.getAnnotation(TestAnnotation.class))); 
     assertFalse(AnnotationUtils.equals(field3.getAnnotation(TestAnnotation.class), field1.getAnnotation(TestAnnotation.class))); 
 }
@Test
public void testNonEquivalentAnnotationsOfSameType7463() { 
     assertFalse(AnnotationUtils.equals(field1.getAnnotation(TestAnnotation.class), field3.getAnnotation(TestAnnotation.class))); 
     assertFalse(AnnotationUtils.equals(field3.getAnnotation(TestAnnotation.class), field1.getAnnotation(TestAnnotation.class))); 
 }
@Test
public void testNonEquivalentAnnotationsOfSameType7616() { 
     assertFalse(AnnotationUtils.equals(field1.getAnnotation(TestAnnotation.class), field3.getAnnotation(TestAnnotation.class))); 
     assertFalse(AnnotationUtils.equals(field3.getAnnotation(TestAnnotation.class), field1.getAnnotation(TestAnnotation.class))); 
 }
@Test(timeout = 666000) 
 public void testHashCode7679() throws Exception { 
     final Test test = getClass().getDeclaredMethod("testHashCode").getAnnotation(Test.class); 
     assertEquals(test.hashCode(), AnnotationUtils.hashCode(test)); 
     final TestAnnotation testAnnotation1 = field1.getAnnotation(TestAnnotation.class); 
     assertEquals(testAnnotation1.hashCode(), AnnotationUtils.hashCode(testAnnotation1)); 
     final TestAnnotation testAnnotation3 = field3.getAnnotation(TestAnnotation.class); 
     assertEquals(testAnnotation3.hashCode(), AnnotationUtils.hashCode(testAnnotation3)); 
 }
@Test(timeout = 666000) 
 public void testHashCode7743() throws Exception { 
     final Test test = getClass().getDeclaredMethod("testHashCode").getAnnotation(Test.class); 
     assertEquals(test.hashCode(), AnnotationUtils.hashCode(test)); 
     final TestAnnotation testAnnotation1 = field1.getAnnotation(TestAnnotation.class); 
     assertEquals(testAnnotation1.hashCode(), AnnotationUtils.hashCode(testAnnotation1)); 
     final TestAnnotation testAnnotation3 = field3.getAnnotation(TestAnnotation.class); 
     assertEquals(testAnnotation3.hashCode(), AnnotationUtils.hashCode(testAnnotation3)); 
 }
@Test
public void testAnnotationsOfDifferingTypes7816() { 
     assertFalse(AnnotationUtils.equals(field1.getAnnotation(TestAnnotation.class), field4.getAnnotation(NestAnnotation.class))); 
     assertFalse(AnnotationUtils.equals(field4.getAnnotation(NestAnnotation.class), field1.getAnnotation(TestAnnotation.class))); 
 }
@Test
public void testNonEquivalentAnnotationsOfSameType7825() { 
     assertFalse(AnnotationUtils.equals(field1.getAnnotation(TestAnnotation.class), field3.getAnnotation(TestAnnotation.class))); 
     assertFalse(AnnotationUtils.equals(field3.getAnnotation(TestAnnotation.class), field1.getAnnotation(TestAnnotation.class))); 
 }
@Test
public void testNonEquivalentAnnotationsOfSameType7926() { 
     assertFalse(AnnotationUtils.equals(field1.getAnnotation(TestAnnotation.class), field3.getAnnotation(TestAnnotation.class))); 
     assertFalse(AnnotationUtils.equals(field3.getAnnotation(TestAnnotation.class), field1.getAnnotation(TestAnnotation.class))); 
 }
@Test
public void testOneArgNull8001() { 
     assertFalse(AnnotationUtils.equals(field1.getAnnotation(TestAnnotation.class), null)); 
     assertFalse(AnnotationUtils.equals(null, field1.getAnnotation(TestAnnotation.class))); 
 }
@Test
public void testNonEquivalentAnnotationsOfSameType8011() { 
     assertFalse(AnnotationUtils.equals(field1.getAnnotation(TestAnnotation.class), field3.getAnnotation(TestAnnotation.class))); 
     assertFalse(AnnotationUtils.equals(field3.getAnnotation(TestAnnotation.class), field1.getAnnotation(TestAnnotation.class))); 
 }
@Test
public void testNonEquivalentAnnotationsOfSameType8043() { 
     assertFalse(AnnotationUtils.equals(field1.getAnnotation(TestAnnotation.class), field3.getAnnotation(TestAnnotation.class))); 
     assertFalse(AnnotationUtils.equals(field3.getAnnotation(TestAnnotation.class), field1.getAnnotation(TestAnnotation.class))); 
 }
@Test
public void testNonEquivalentAnnotationsOfSameType8115() { 
     assertFalse(AnnotationUtils.equals(field1.getAnnotation(TestAnnotation.class), field3.getAnnotation(TestAnnotation.class))); 
     assertFalse(AnnotationUtils.equals(field3.getAnnotation(TestAnnotation.class), field1.getAnnotation(TestAnnotation.class))); 
 }
@Test
public void testNonEquivalentAnnotationsOfSameType8347() { 
     assertFalse(AnnotationUtils.equals(field1.getAnnotation(TestAnnotation.class), field3.getAnnotation(TestAnnotation.class))); 
     assertFalse(AnnotationUtils.equals(field3.getAnnotation(TestAnnotation.class), field1.getAnnotation(TestAnnotation.class))); 
 }
@Test(timeout = 666000) 
 public void testHashCode8488() throws Exception { 
     final Test test = getClass().getDeclaredMethod("testHashCode").getAnnotation(Test.class); 
     assertEquals(test.hashCode(), AnnotationUtils.hashCode(test)); 
     final TestAnnotation testAnnotation1 = field1.getAnnotation(TestAnnotation.class); 
     assertEquals(testAnnotation1.hashCode(), AnnotationUtils.hashCode(testAnnotation1)); 
     final TestAnnotation testAnnotation3 = field3.getAnnotation(TestAnnotation.class); 
     assertEquals(testAnnotation3.hashCode(), AnnotationUtils.hashCode(testAnnotation3)); 
 }
@Test
public void testNonEquivalentAnnotationsOfSameType8680() { 
     assertFalse(AnnotationUtils.equals(field1.getAnnotation(TestAnnotation.class), field3.getAnnotation(TestAnnotation.class))); 
     assertFalse(AnnotationUtils.equals(field3.getAnnotation(TestAnnotation.class), field1.getAnnotation(TestAnnotation.class))); 
 }
@Test
public void testNonEquivalentAnnotationsOfSameType8706() { 
     assertFalse(AnnotationUtils.equals(field1.getAnnotation(TestAnnotation.class), field3.getAnnotation(TestAnnotation.class))); 
     assertFalse(AnnotationUtils.equals(field3.getAnnotation(TestAnnotation.class), field1.getAnnotation(TestAnnotation.class))); 
 }
@Test
public void testOneArgNull8771() { 
     assertFalse(AnnotationUtils.equals(field1.getAnnotation(TestAnnotation.class), null)); 
     assertFalse(AnnotationUtils.equals(null, field1.getAnnotation(TestAnnotation.class))); 
 }
@Test
public void testNonEquivalentAnnotationsOfSameType9068() { 
     assertFalse(AnnotationUtils.equals(field1.getAnnotation(TestAnnotation.class), field3.getAnnotation(TestAnnotation.class))); 
     assertFalse(AnnotationUtils.equals(field3.getAnnotation(TestAnnotation.class), field1.getAnnotation(TestAnnotation.class))); 
 }
@Test(timeout = 666000) 
 public void testHashCode9221() throws Exception { 
     final Test test = getClass().getDeclaredMethod("testHashCode").getAnnotation(Test.class); 
     assertEquals(test.hashCode(), AnnotationUtils.hashCode(test)); 
     final TestAnnotation testAnnotation1 = field1.getAnnotation(TestAnnotation.class); 
     assertEquals(testAnnotation1.hashCode(), AnnotationUtils.hashCode(testAnnotation1)); 
     final TestAnnotation testAnnotation3 = field3.getAnnotation(TestAnnotation.class); 
     assertEquals(testAnnotation3.hashCode(), AnnotationUtils.hashCode(testAnnotation3)); 
 }
@Test
public void testOneArgNull9285() { 
     assertFalse(AnnotationUtils.equals(field1.getAnnotation(TestAnnotation.class), null)); 
     assertFalse(AnnotationUtils.equals(null, field1.getAnnotation(TestAnnotation.class))); 
 }
@Test
public void testAnnotationsOfDifferingTypes9286() { 
     assertFalse(AnnotationUtils.equals(field1.getAnnotation(TestAnnotation.class), field4.getAnnotation(NestAnnotation.class))); 
     assertFalse(AnnotationUtils.equals(field4.getAnnotation(NestAnnotation.class), field1.getAnnotation(TestAnnotation.class))); 
 }
@Test
public void testOneArgNull9287() { 
     assertFalse(AnnotationUtils.equals(field1.getAnnotation(TestAnnotation.class), null)); 
     assertFalse(AnnotationUtils.equals(null, field1.getAnnotation(TestAnnotation.class))); 
 }
@Test
public void testNonEquivalentAnnotationsOfSameType9439() { 
     assertFalse(AnnotationUtils.equals(field1.getAnnotation(TestAnnotation.class), field3.getAnnotation(TestAnnotation.class))); 
     assertFalse(AnnotationUtils.equals(field3.getAnnotation(TestAnnotation.class), field1.getAnnotation(TestAnnotation.class))); 
 }
@Test
public void testOneArgNull9445() { 
     assertFalse(AnnotationUtils.equals(field1.getAnnotation(TestAnnotation.class), null)); 
     assertFalse(AnnotationUtils.equals(null, field1.getAnnotation(TestAnnotation.class))); 
 }
@Test
public void testNonEquivalentAnnotationsOfSameType9515() { 
     assertFalse(AnnotationUtils.equals(field1.getAnnotation(TestAnnotation.class), field3.getAnnotation(TestAnnotation.class))); 
     assertFalse(AnnotationUtils.equals(field3.getAnnotation(TestAnnotation.class), field1.getAnnotation(TestAnnotation.class))); 
 }
    

    

    

    

    

    

    

    

    

    

}
