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
package org.apache.commons.lang3.builder;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.math.BigInteger;

import org.junit.Test;

/**
 * Unit tests {@link org.apache.commons.lang3.builder.CompareToBuilder}.
 *
 * @version $Id$
 */
public class CompareToBuilderTest {

    //-----------------------------------------------------------------------

    static class TestObject implements Comparable<TestObject> {
        private int a;
        public TestObject(final int a) {
            this.a = a;
        }
        @Override
        public boolean equals(final Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof TestObject)) {
                return false;
            }
            final TestObject rhs = (TestObject) o;
            return a == rhs.a;
        }

        @Override
        public int hashCode() {
            return a;
        }

        public void setA(final int a) {
            this.a = a;
        }

        public int getA() {
            return a;
        }
        @Override
        public int compareTo(final TestObject rhs) {
            return a < rhs.a ? -1 : a > rhs.a ? +1 : 0;
        }
    }

    static class TestSubObject extends TestObject {
        private int b;
        public TestSubObject() {
            super(0);
        }
        public TestSubObject(final int a, final int b) {
            super(a);
            this.b = b;
        }
        @Override
        public boolean equals(final Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof TestSubObject)) {
                return false;
            }
            final TestSubObject rhs = (TestSubObject) o;
            return super.equals(o) && b == rhs.b;
        }
    }

    static class TestTransientSubObject extends TestObject {
        @SuppressWarnings("unused")
        private transient int t;
        public TestTransientSubObject(final int a, final int t) {
            super(a);
            this.t = t;
        }
    }
    
@Test
public void testDoubleArray37() { 
     final double[] obj1 = new double[2]; 
     obj1[0] = 5; 
     obj1[1] = 6; 
     final double[] obj2 = new double[2]; 
     obj2[0] = 5; 
     obj2[1] = 6; 
     final double[] obj3 = new double[3]; 
     obj3[0] = 5; 
     obj3[1] = 6; 
     obj3[2] = 7; 
     assertTrue(new CompareToBuilder().append(obj1, obj1).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(obj1, obj2).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(obj1, obj3).toComparison() < 0); 
     assertTrue(new CompareToBuilder().append(obj3, obj1).toComparison() > 0); 
     obj1[1] = 7; 
     assertTrue(new CompareToBuilder().append(obj1, obj2).toComparison() > 0); 
     assertTrue(new CompareToBuilder().append(obj2, obj1).toComparison() < 0); 
     assertTrue(new CompareToBuilder().append(obj1, null).toComparison() > 0); 
     assertTrue(new CompareToBuilder().append((double[]) null, (double[]) null).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(null, obj1).toComparison() < 0); 
 }
@Test
public void testObject52() { 
     final TestObject o1 = new TestObject(4); 
     final TestObject o2 = new TestObject(4); 
     assertTrue(new CompareToBuilder().append(o1, o1).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(o1, o2).toComparison() == 0); 
     o2.setA(5); 
     assertTrue(new CompareToBuilder().append(o1, o2).toComparison() < 0); 
     assertTrue(new CompareToBuilder().append(o2, o1).toComparison() > 0); 
     assertTrue(new CompareToBuilder().append(o1, null).toComparison() > 0); 
     assertTrue(new CompareToBuilder().append((Object) null, (Object) null).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(null, o1).toComparison() < 0); 
 }
@Test
public void testObjectArray267() { 
     final TestObject[] obj1 = new TestObject[2]; 
     obj1[0] = new TestObject(4); 
     obj1[1] = new TestObject(5); 
     final TestObject[] obj2 = new TestObject[2]; 
     obj2[0] = new TestObject(4); 
     obj2[1] = new TestObject(5); 
     final TestObject[] obj3 = new TestObject[3]; 
     obj3[0] = new TestObject(4); 
     obj3[1] = new TestObject(5); 
     obj3[2] = new TestObject(6); 
     assertTrue(new CompareToBuilder().append(obj1, obj1).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(obj1, obj2).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(obj1, obj3).toComparison() < 0); 
     assertTrue(new CompareToBuilder().append(obj3, obj1).toComparison() > 0); 
     obj1[1] = new TestObject(7); 
     assertTrue(new CompareToBuilder().append(obj1, obj2).toComparison() > 0); 
     assertTrue(new CompareToBuilder().append(obj2, obj1).toComparison() < 0); 
     assertTrue(new CompareToBuilder().append(obj1, null).toComparison() > 0); 
     assertTrue(new CompareToBuilder().append((Object[]) null, (Object[]) null).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(null, obj1).toComparison() < 0); 
 }
@Test
public void testFloatArray286() { 
     final float[] obj1 = new float[2]; 
     obj1[0] = 5; 
     obj1[1] = 6; 
     final float[] obj2 = new float[2]; 
     obj2[0] = 5; 
     obj2[1] = 6; 
     final float[] obj3 = new float[3]; 
     obj3[0] = 5; 
     obj3[1] = 6; 
     obj3[2] = 7; 
     assertTrue(new CompareToBuilder().append(obj1, obj1).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(obj1, obj2).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(obj1, obj3).toComparison() < 0); 
     assertTrue(new CompareToBuilder().append(obj3, obj1).toComparison() > 0); 
     obj1[1] = 7; 
     assertTrue(new CompareToBuilder().append(obj1, obj2).toComparison() > 0); 
     assertTrue(new CompareToBuilder().append(obj2, obj1).toComparison() < 0); 
     assertTrue(new CompareToBuilder().append(obj1, null).toComparison() > 0); 
     assertTrue(new CompareToBuilder().append((float[]) null, (float[]) null).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(null, obj1).toComparison() < 0); 
 }
@Test
public void testAppendSuper290() { 
     final TestObject o1 = new TestObject(4); 
     final TestObject o2 = new TestObject(5); 
     assertTrue(new CompareToBuilder().appendSuper(0).append(o1, o1).toComparison() == 0); 
     assertTrue(new CompareToBuilder().appendSuper(0).append(o1, o2).toComparison() < 0); 
     assertTrue(new CompareToBuilder().appendSuper(0).append(o2, o1).toComparison() > 0); 
     assertTrue(new CompareToBuilder().appendSuper(-1).append(o1, o1).toComparison() < 0); 
     assertTrue(new CompareToBuilder().appendSuper(-1).append(o1, o2).toComparison() < 0); 
     assertTrue(new CompareToBuilder().appendSuper(1).append(o1, o1).toComparison() > 0); 
     assertTrue(new CompareToBuilder().appendSuper(1).append(o1, o2).toComparison() > 0); 
 }
@Test
public void testMultiIntArray362() { 
     final int[][] array1 = new int[2][2]; 
     final int[][] array2 = new int[2][2]; 
     final int[][] array3 = new int[2][3]; 
     for (int i = 0; i < array1.length; ++i) { 
         for (int j = 0; j < array1[0].length; j++) { 
             array1[i][j] = (i + 1) * (j + 1); 
             array2[i][j] = (i + 1) * (j + 1); 
             array3[i][j] = (i + 1) * (j + 1); 
         } 
     } 
     array3[1][2] = 100; 
     array3[1][2] = 100; 
     assertTrue(new CompareToBuilder().append(array1, array1).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(array1, array2).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(array1, array3).toComparison() < 0); 
     assertTrue(new CompareToBuilder().append(array3, array1).toComparison() > 0); 
     array1[1][1] = 200; 
     assertTrue(new CompareToBuilder().append(array1, array2).toComparison() > 0); 
     assertTrue(new CompareToBuilder().append(array2, array1).toComparison() < 0); 
 }
@Test
public void testIntArray426() { 
     final int[] obj1 = new int[2]; 
     obj1[0] = 5; 
     obj1[1] = 6; 
     final int[] obj2 = new int[2]; 
     obj2[0] = 5; 
     obj2[1] = 6; 
     final int[] obj3 = new int[3]; 
     obj3[0] = 5; 
     obj3[1] = 6; 
     obj3[2] = 7; 
     assertTrue(new CompareToBuilder().append(obj1, obj1).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(obj1, obj2).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(obj1, obj3).toComparison() < 0); 
     assertTrue(new CompareToBuilder().append(obj3, obj1).toComparison() > 0); 
     obj1[1] = 7; 
     assertTrue(new CompareToBuilder().append(obj1, obj2).toComparison() > 0); 
     assertTrue(new CompareToBuilder().append(obj2, obj1).toComparison() < 0); 
     assertTrue(new CompareToBuilder().append(obj1, null).toComparison() > 0); 
     assertTrue(new CompareToBuilder().append((int[]) null, (int[]) null).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(null, obj1).toComparison() < 0); 
 }
@Test
public void testMultiFloatArray431() { 
     final float[][] array1 = new float[2][2]; 
     final float[][] array2 = new float[2][2]; 
     final float[][] array3 = new float[2][3]; 
     for (int i = 0; i < array1.length; ++i) { 
         for (int j = 0; j < array1[0].length; j++) { 
             array1[i][j] = (i + 1) * (j + 1); 
             array2[i][j] = (i + 1) * (j + 1); 
             array3[i][j] = (i + 1) * (j + 1); 
         } 
     } 
     array3[1][2] = 100; 
     array3[1][2] = 100; 
     assertTrue(new CompareToBuilder().append(array1, array1).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(array1, array2).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(array1, array3).toComparison() < 0); 
     assertTrue(new CompareToBuilder().append(array3, array1).toComparison() > 0); 
     array1[1][1] = 127; 
     assertTrue(new CompareToBuilder().append(array1, array2).toComparison() > 0); 
     assertTrue(new CompareToBuilder().append(array2, array1).toComparison() < 0); 
 }
@Test
public void testObjectArrayHiddenByObject436() { 
     final TestObject[] array1 = new TestObject[2]; 
     array1[0] = new TestObject(4); 
     array1[1] = new TestObject(5); 
     final TestObject[] array2 = new TestObject[2]; 
     array2[0] = new TestObject(4); 
     array2[1] = new TestObject(5); 
     final TestObject[] array3 = new TestObject[3]; 
     array3[0] = new TestObject(4); 
     array3[1] = new TestObject(5); 
     array3[2] = new TestObject(6); 
     final Object obj1 = array1; 
     final Object obj2 = array2; 
     final Object obj3 = array3; 
     assertTrue(new CompareToBuilder().append(obj1, obj1).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(obj1, obj2).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(obj1, obj3).toComparison() < 0); 
     assertTrue(new CompareToBuilder().append(obj3, obj1).toComparison() > 0); 
     array1[1] = new TestObject(7); 
     assertTrue(new CompareToBuilder().append(obj1, obj2).toComparison() > 0); 
     assertTrue(new CompareToBuilder().append(obj2, obj1).toComparison() < 0); 
 }
@Test
public void testBooleanArray447() { 
     final boolean[] obj1 = new boolean[2]; 
     obj1[0] = true; 
     obj1[1] = false; 
     final boolean[] obj2 = new boolean[2]; 
     obj2[0] = true; 
     obj2[1] = false; 
     final boolean[] obj3 = new boolean[3]; 
     obj3[0] = true; 
     obj3[1] = false; 
     obj3[2] = true; 
     assertTrue(new CompareToBuilder().append(obj1, obj1).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(obj1, obj2).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(obj1, obj3).toComparison() < 0); 
     assertTrue(new CompareToBuilder().append(obj3, obj1).toComparison() > 0); 
     obj1[1] = true; 
     assertTrue(new CompareToBuilder().append(obj1, obj2).toComparison() > 0); 
     assertTrue(new CompareToBuilder().append(obj2, obj1).toComparison() < 0); 
     assertTrue(new CompareToBuilder().append(obj1, null).toComparison() > 0); 
     assertTrue(new CompareToBuilder().append((boolean[]) null, (boolean[]) null).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(null, obj1).toComparison() < 0); 
 }
@Test(expected = ClassCastException.class) 
 public void testReflectionCompareEx2473() { 
     final TestObject o1 = new TestObject(4); 
     final Object o2 = new Object(); 
     CompareToBuilder.reflectionCompare(o1, o2); 
 }
@Test
public void testShortArray531() { 
     final short[] obj1 = new short[2]; 
     obj1[0] = 5; 
     obj1[1] = 6; 
     final short[] obj2 = new short[2]; 
     obj2[0] = 5; 
     obj2[1] = 6; 
     final short[] obj3 = new short[3]; 
     obj3[0] = 5; 
     obj3[1] = 6; 
     obj3[2] = 7; 
     assertTrue(new CompareToBuilder().append(obj1, obj1).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(obj1, obj2).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(obj1, obj3).toComparison() < 0); 
     assertTrue(new CompareToBuilder().append(obj3, obj1).toComparison() > 0); 
     obj1[1] = 7; 
     assertTrue(new CompareToBuilder().append(obj1, obj2).toComparison() > 0); 
     assertTrue(new CompareToBuilder().append(obj2, obj1).toComparison() < 0); 
     assertTrue(new CompareToBuilder().append(obj1, null).toComparison() > 0); 
     assertTrue(new CompareToBuilder().append((short[]) null, (short[]) null).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(null, obj1).toComparison() < 0); 
 }
@Test
public void testLongArray548() { 
     final long[] obj1 = new long[2]; 
     obj1[0] = 5L; 
     obj1[1] = 6L; 
     final long[] obj2 = new long[2]; 
     obj2[0] = 5L; 
     obj2[1] = 6L; 
     final long[] obj3 = new long[3]; 
     obj3[0] = 5L; 
     obj3[1] = 6L; 
     obj3[2] = 7L; 
     assertTrue(new CompareToBuilder().append(obj1, obj1).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(obj1, obj2).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(obj1, obj3).toComparison() < 0); 
     assertTrue(new CompareToBuilder().append(obj3, obj1).toComparison() > 0); 
     obj1[1] = 7; 
     assertTrue(new CompareToBuilder().append(obj1, obj2).toComparison() > 0); 
     assertTrue(new CompareToBuilder().append(obj2, obj1).toComparison() < 0); 
     assertTrue(new CompareToBuilder().append(obj1, null).toComparison() > 0); 
     assertTrue(new CompareToBuilder().append((long[]) null, (long[]) null).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(null, obj1).toComparison() < 0); 
 }
@Test
public void testByteArrayHiddenByObject674() { 
     final byte[] array1 = new byte[2]; 
     array1[0] = 5; 
     array1[1] = 6; 
     final byte[] array2 = new byte[2]; 
     array2[0] = 5; 
     array2[1] = 6; 
     final byte[] array3 = new byte[3]; 
     array3[0] = 5; 
     array3[1] = 6; 
     array3[2] = 7; 
     final Object obj1 = array1; 
     final Object obj2 = array2; 
     final Object obj3 = array3; 
     assertTrue(new CompareToBuilder().append(obj1, obj1).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(obj1, obj2).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(obj1, obj3).toComparison() < 0); 
     assertTrue(new CompareToBuilder().append(obj3, obj1).toComparison() > 0); 
     array1[1] = 7; 
     assertTrue(new CompareToBuilder().append(obj1, obj2).toComparison() > 0); 
     assertTrue(new CompareToBuilder().append(obj2, obj1).toComparison() < 0); 
 }
@Test
public void testMultiShortArray984() { 
     final short[][] array1 = new short[2][2]; 
     final short[][] array2 = new short[2][2]; 
     final short[][] array3 = new short[2][3]; 
     for (short i = 0; i < array1.length; ++i) { 
         for (short j = 0; j < array1[0].length; j++) { 
             array1[i][j] = (short) ((i + 1) * (j + 1)); 
             array2[i][j] = (short) ((i + 1) * (j + 1)); 
             array3[i][j] = (short) ((i + 1) * (j + 1)); 
         } 
     } 
     array3[1][2] = 100; 
     array3[1][2] = 100; 
     assertTrue(new CompareToBuilder().append(array1, array1).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(array1, array2).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(array1, array3).toComparison() < 0); 
     assertTrue(new CompareToBuilder().append(array3, array1).toComparison() > 0); 
     array1[1][1] = 200; 
     assertTrue(new CompareToBuilder().append(array1, array2).toComparison() > 0); 
     assertTrue(new CompareToBuilder().append(array2, array1).toComparison() < 0); 
 }
@Test
public void testMultiCharArray1047() { 
     final char[][] array1 = new char[2][2]; 
     final char[][] array2 = new char[2][2]; 
     final char[][] array3 = new char[2][3]; 
     for (short i = 0; i < array1.length; ++i) { 
         for (short j = 0; j < array1[0].length; j++) { 
             array1[i][j] = (char) ((i + 1) * (j + 1)); 
             array2[i][j] = (char) ((i + 1) * (j + 1)); 
             array3[i][j] = (char) ((i + 1) * (j + 1)); 
         } 
     } 
     array3[1][2] = 100; 
     array3[1][2] = 100; 
     assertTrue(new CompareToBuilder().append(array1, array1).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(array1, array2).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(array1, array3).toComparison() < 0); 
     assertTrue(new CompareToBuilder().append(array3, array1).toComparison() > 0); 
     array1[1][1] = 200; 
     assertTrue(new CompareToBuilder().append(array1, array2).toComparison() > 0); 
     assertTrue(new CompareToBuilder().append(array2, array1).toComparison() < 0); 
 }
@Test
public void testReflectionHierarchyCompare1058() { 
     testReflectionHierarchyCompare(false, null); 
 }
@Test
public void testByteArray1119() { 
     final byte[] obj1 = new byte[2]; 
     obj1[0] = 5; 
     obj1[1] = 6; 
     final byte[] obj2 = new byte[2]; 
     obj2[0] = 5; 
     obj2[1] = 6; 
     final byte[] obj3 = new byte[3]; 
     obj3[0] = 5; 
     obj3[1] = 6; 
     obj3[2] = 7; 
     assertTrue(new CompareToBuilder().append(obj1, obj1).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(obj1, obj2).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(obj1, obj3).toComparison() < 0); 
     assertTrue(new CompareToBuilder().append(obj3, obj1).toComparison() > 0); 
     obj1[1] = 7; 
     assertTrue(new CompareToBuilder().append(obj1, obj2).toComparison() > 0); 
     assertTrue(new CompareToBuilder().append(obj2, obj1).toComparison() < 0); 
     assertTrue(new CompareToBuilder().append(obj1, null).toComparison() > 0); 
     assertTrue(new CompareToBuilder().append((byte[]) null, (byte[]) null).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(null, obj1).toComparison() < 0); 
 }
@Test
public void testObjectComparator1144() { 
     final String o1 = "Fred"; 
     String o2 = "Fred"; 
     assertTrue(new CompareToBuilder().append(o1, o1, String.CASE_INSENSITIVE_ORDER).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(o1, o2, String.CASE_INSENSITIVE_ORDER).toComparison() == 0); 
     o2 = "FRED"; 
     assertTrue(new CompareToBuilder().append(o1, o2, String.CASE_INSENSITIVE_ORDER).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(o2, o1, String.CASE_INSENSITIVE_ORDER).toComparison() == 0); 
     o2 = "FREDA"; 
     assertTrue(new CompareToBuilder().append(o1, o2, String.CASE_INSENSITIVE_ORDER).toComparison() < 0); 
     assertTrue(new CompareToBuilder().append(o2, o1, String.CASE_INSENSITIVE_ORDER).toComparison() > 0); 
     assertTrue(new CompareToBuilder().append(o1, null, String.CASE_INSENSITIVE_ORDER).toComparison() > 0); 
     assertTrue(new CompareToBuilder().append((Object) null, (Object) null, String.CASE_INSENSITIVE_ORDER).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(null, o1, String.CASE_INSENSITIVE_ORDER).toComparison() < 0); 
 }
@Test(expected = NullPointerException.class) 
 public void testReflectionCompareEx11157() { 
     final TestObject o1 = new TestObject(4); 
     CompareToBuilder.reflectionCompare(o1, null); 
 }
@Test
public void testObjectBuild1233() { 
     final TestObject o1 = new TestObject(4); 
     final TestObject o2 = new TestObject(4); 
     assertEquals(Integer.valueOf(0), new CompareToBuilder().append(o1, o1).build()); 
     assertEquals(Integer.valueOf(0), new CompareToBuilder().append(o1, o2).build()); 
     o2.setA(5); 
     assertTrue(new CompareToBuilder().append(o1, o2).build().intValue() < 0); 
     assertTrue(new CompareToBuilder().append(o2, o1).build().intValue() > 0); 
     assertTrue(new CompareToBuilder().append(o1, null).build().intValue() > 0); 
     assertEquals(Integer.valueOf(0), new CompareToBuilder().append((Object) null, (Object) null).build()); 
     assertTrue(new CompareToBuilder().append(null, o1).build().intValue() < 0); 
 }
@Test
public void testDoubleArrayHiddenByObject1306() { 
     final double[] array1 = new double[2]; 
     array1[0] = 5; 
     array1[1] = 6; 
     final double[] array2 = new double[2]; 
     array2[0] = 5; 
     array2[1] = 6; 
     final double[] array3 = new double[3]; 
     array3[0] = 5; 
     array3[1] = 6; 
     array3[2] = 7; 
     final Object obj1 = array1; 
     final Object obj2 = array2; 
     final Object obj3 = array3; 
     assertTrue(new CompareToBuilder().append(obj1, obj1).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(obj1, obj2).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(obj1, obj3).toComparison() < 0); 
     assertTrue(new CompareToBuilder().append(obj3, obj1).toComparison() > 0); 
     array1[1] = 7; 
     assertTrue(new CompareToBuilder().append(obj1, obj2).toComparison() > 0); 
     assertTrue(new CompareToBuilder().append(obj2, obj1).toComparison() < 0); 
 }
@Test
public void testBooleanArray1347() { 
     final boolean[] obj1 = new boolean[2]; 
     obj1[0] = true; 
     obj1[1] = false; 
     final boolean[] obj2 = new boolean[2]; 
     obj2[0] = true; 
     obj2[1] = false; 
     final boolean[] obj3 = new boolean[3]; 
     obj3[0] = true; 
     obj3[1] = false; 
     obj3[2] = true; 
     assertTrue(new CompareToBuilder().append(obj1, obj1).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(obj1, obj2).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(obj1, obj3).toComparison() < 0); 
     assertTrue(new CompareToBuilder().append(obj3, obj1).toComparison() > 0); 
     obj1[1] = true; 
     assertTrue(new CompareToBuilder().append(obj1, obj2).toComparison() > 0); 
     assertTrue(new CompareToBuilder().append(obj2, obj1).toComparison() < 0); 
     assertTrue(new CompareToBuilder().append(obj1, null).toComparison() > 0); 
     assertTrue(new CompareToBuilder().append((boolean[]) null, (boolean[]) null).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(null, obj1).toComparison() < 0); 
 }
@Test
public void testLongArray1374() { 
     final long[] obj1 = new long[2]; 
     obj1[0] = 5L; 
     obj1[1] = 6L; 
     final long[] obj2 = new long[2]; 
     obj2[0] = 5L; 
     obj2[1] = 6L; 
     final long[] obj3 = new long[3]; 
     obj3[0] = 5L; 
     obj3[1] = 6L; 
     obj3[2] = 7L; 
     assertTrue(new CompareToBuilder().append(obj1, obj1).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(obj1, obj2).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(obj1, obj3).toComparison() < 0); 
     assertTrue(new CompareToBuilder().append(obj3, obj1).toComparison() > 0); 
     obj1[1] = 7; 
     assertTrue(new CompareToBuilder().append(obj1, obj2).toComparison() > 0); 
     assertTrue(new CompareToBuilder().append(obj2, obj1).toComparison() < 0); 
     assertTrue(new CompareToBuilder().append(obj1, null).toComparison() > 0); 
     assertTrue(new CompareToBuilder().append((long[]) null, (long[]) null).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(null, obj1).toComparison() < 0); 
 }
@Test(expected = ClassCastException.class) 
 public void testReflectionCompareEx21419() { 
     final TestObject o1 = new TestObject(4); 
     final Object o2 = new Object(); 
     CompareToBuilder.reflectionCompare(o1, o2); 
 }
@Test
public void testObjectArray1464() { 
     final TestObject[] obj1 = new TestObject[2]; 
     obj1[0] = new TestObject(4); 
     obj1[1] = new TestObject(5); 
     final TestObject[] obj2 = new TestObject[2]; 
     obj2[0] = new TestObject(4); 
     obj2[1] = new TestObject(5); 
     final TestObject[] obj3 = new TestObject[3]; 
     obj3[0] = new TestObject(4); 
     obj3[1] = new TestObject(5); 
     obj3[2] = new TestObject(6); 
     assertTrue(new CompareToBuilder().append(obj1, obj1).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(obj1, obj2).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(obj1, obj3).toComparison() < 0); 
     assertTrue(new CompareToBuilder().append(obj3, obj1).toComparison() > 0); 
     obj1[1] = new TestObject(7); 
     assertTrue(new CompareToBuilder().append(obj1, obj2).toComparison() > 0); 
     assertTrue(new CompareToBuilder().append(obj2, obj1).toComparison() < 0); 
     assertTrue(new CompareToBuilder().append(obj1, null).toComparison() > 0); 
     assertTrue(new CompareToBuilder().append((Object[]) null, (Object[]) null).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(null, obj1).toComparison() < 0); 
 }
@Test
public void testCharArray1466() { 
     final char[] obj1 = new char[2]; 
     obj1[0] = 5; 
     obj1[1] = 6; 
     final char[] obj2 = new char[2]; 
     obj2[0] = 5; 
     obj2[1] = 6; 
     final char[] obj3 = new char[3]; 
     obj3[0] = 5; 
     obj3[1] = 6; 
     obj3[2] = 7; 
     assertTrue(new CompareToBuilder().append(obj1, obj1).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(obj1, obj2).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(obj1, obj3).toComparison() < 0); 
     assertTrue(new CompareToBuilder().append(obj3, obj1).toComparison() > 0); 
     obj1[1] = 7; 
     assertTrue(new CompareToBuilder().append(obj1, obj2).toComparison() > 0); 
     assertTrue(new CompareToBuilder().append(obj2, obj1).toComparison() < 0); 
     assertTrue(new CompareToBuilder().append(obj1, null).toComparison() > 0); 
     assertTrue(new CompareToBuilder().append((char[]) null, (char[]) null).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(null, obj1).toComparison() < 0); 
 }
@Test
public void testBooleanArrayHiddenByObject1497() { 
     final boolean[] array1 = new boolean[2]; 
     array1[0] = true; 
     array1[1] = false; 
     final boolean[] array2 = new boolean[2]; 
     array2[0] = true; 
     array2[1] = false; 
     final boolean[] array3 = new boolean[3]; 
     array3[0] = true; 
     array3[1] = false; 
     array3[2] = true; 
     final Object obj1 = array1; 
     final Object obj2 = array2; 
     final Object obj3 = array3; 
     assertTrue(new CompareToBuilder().append(obj1, obj1).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(obj1, obj2).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(obj1, obj3).toComparison() < 0); 
     assertTrue(new CompareToBuilder().append(obj3, obj1).toComparison() > 0); 
     array1[1] = true; 
     assertTrue(new CompareToBuilder().append(obj1, obj2).toComparison() > 0); 
     assertTrue(new CompareToBuilder().append(obj2, obj1).toComparison() < 0); 
 }
@Test
public void testObject1571() { 
     final TestObject o1 = new TestObject(4); 
     final TestObject o2 = new TestObject(4); 
     assertTrue(new CompareToBuilder().append(o1, o1).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(o1, o2).toComparison() == 0); 
     o2.setA(5); 
     assertTrue(new CompareToBuilder().append(o1, o2).toComparison() < 0); 
     assertTrue(new CompareToBuilder().append(o2, o1).toComparison() > 0); 
     assertTrue(new CompareToBuilder().append(o1, null).toComparison() > 0); 
     assertTrue(new CompareToBuilder().append((Object) null, (Object) null).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(null, o1).toComparison() < 0); 
 }
@Test
public void testObjectArrayHiddenByObject1572() { 
     final TestObject[] array1 = new TestObject[2]; 
     array1[0] = new TestObject(4); 
     array1[1] = new TestObject(5); 
     final TestObject[] array2 = new TestObject[2]; 
     array2[0] = new TestObject(4); 
     array2[1] = new TestObject(5); 
     final TestObject[] array3 = new TestObject[3]; 
     array3[0] = new TestObject(4); 
     array3[1] = new TestObject(5); 
     array3[2] = new TestObject(6); 
     final Object obj1 = array1; 
     final Object obj2 = array2; 
     final Object obj3 = array3; 
     assertTrue(new CompareToBuilder().append(obj1, obj1).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(obj1, obj2).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(obj1, obj3).toComparison() < 0); 
     assertTrue(new CompareToBuilder().append(obj3, obj1).toComparison() > 0); 
     array1[1] = new TestObject(7); 
     assertTrue(new CompareToBuilder().append(obj1, obj2).toComparison() > 0); 
     assertTrue(new CompareToBuilder().append(obj2, obj1).toComparison() < 0); 
 }
@Test
public void testToComparison1573() { 
     final TestObject o1 = new TestObject(4); 
     final TestObject o2 = new TestObject(4); 
     assertEquals(0, new CompareToBuilder().append(o1, o1).toComparison()); 
     assertEquals(0, new CompareToBuilder().append(o1, o2).toComparison()); 
     o2.setA(5); 
     assertTrue(new CompareToBuilder().append(o1, o2).toComparison() < 0); 
     assertTrue(new CompareToBuilder().append(o2, o1).toComparison() > 0); 
     assertTrue(new CompareToBuilder().append(o1, null).toComparison() > 0); 
     assertEquals(0, new CompareToBuilder().append((Object) null, (Object) null).toComparison()); 
     assertTrue(new CompareToBuilder().append(null, o1).toComparison() < 0); 
 }
@Test
public void testObject1574() { 
     final TestObject o1 = new TestObject(4); 
     final TestObject o2 = new TestObject(4); 
     assertEquals(0, new CompareToBuilder().append(o1, o1).toComparison()); 
     assertEquals(0, new CompareToBuilder().append(o1, o2).toComparison()); 
     o2.setA(5); 
     assertTrue(new CompareToBuilder().append(o1, o2).toComparison() < 0); 
     assertTrue(new CompareToBuilder().append(o2, o1).toComparison() > 0); 
     assertTrue(new CompareToBuilder().append(o1, null).toComparison() > 0); 
     assertEquals(0, new CompareToBuilder().append((Object) null, (Object) null).toComparison()); 
     assertTrue(new CompareToBuilder().append(null, o1).toComparison() < 0); 
 }
@Test
public void testReflectionObjectCycle1742() { 
     final TestObject o1 = new TestObject(4); 
     final TestObject o2 = new TestObject(5); 
     assertTrue(new CompareToBuilder().append(o1, o1).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(o1, o2).toComparison() == 0); 
     o2.setA(4); 
     assertTrue(new CompareToBuilder().append(o1, o2).toComparison() < 0); 
     assertTrue(new CompareToBuilder().append(o2, o1).toComparison() > 0); 
     assertTrue(new CompareToBuilder().append(o1, null).toComparison() > 0); 
     assertTrue(new CompareToBuilder().append((Object) null, (Object) null).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(null, o1).toComparison() < 0); 
 }
@Test
public void testMultiCharArray1838() { 
     final char[][] array1 = new char[2][2]; 
     final char[][] array2 = new char[2][2]; 
     final char[][] array3 = new char[2][3]; 
     for (int i = 0; i < array1.length; ++i) { 
         for (int j = 0; j < array1[0].length; j++) { 
             array1[i][j] = (char) ((i + 1) * (j + 1)); 
             array2[i][j] = (char) ((i + 1) * (j + 1)); 
             array3[i][j] = (char) ((i + 1) * (j + 1)); 
         } 
     } 
     array3[1][2] = 100; 
     array3[1][2] = 100; 
     assertTrue(new CompareToBuilder().append(array1, array1).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(array1, array2).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(array1, array3).toComparison() < 0); 
     assertTrue(new CompareToBuilder().append(array3, array1).toComparison() > 0); 
     array1[1][1] = 200; 
     assertTrue(new CompareToBuilder().append(array1, array2).toComparison() > 0); 
     assertTrue(new CompareToBuilder().append(array2, array1).toComparison() < 0); 
 }
    

    

    

    
    
    
    
    
    
    private void assertXYZCompareOrder(final Object x, final Object y, final Object z, final boolean testTransients, final String[] excludeFields) {
        assertTrue(0 == CompareToBuilder.reflectionCompare(x, x, testTransients, null, excludeFields));
        assertTrue(0 == CompareToBuilder.reflectionCompare(y, y, testTransients, null, excludeFields));
        assertTrue(0 == CompareToBuilder.reflectionCompare(z, z, testTransients, null, excludeFields));
        
        assertTrue(0 > CompareToBuilder.reflectionCompare(x, y, testTransients, null, excludeFields));
        assertTrue(0 > CompareToBuilder.reflectionCompare(x, z, testTransients, null, excludeFields));
        assertTrue(0 > CompareToBuilder.reflectionCompare(y, z, testTransients, null, excludeFields));
        
        assertTrue(0 < CompareToBuilder.reflectionCompare(y, x, testTransients, null, excludeFields));
        assertTrue(0 < CompareToBuilder.reflectionCompare(z, x, testTransients, null, excludeFields));
        assertTrue(0 < CompareToBuilder.reflectionCompare(z, y, testTransients, null, excludeFields));
    }
    
    private void testReflectionHierarchyCompare(final boolean testTransients, final String[] excludeFields) {
        final TestObject to1 = new TestObject(1);
        final TestObject to2 = new TestObject(2);
        final TestObject to3 = new TestObject(3);
        final TestSubObject tso1 = new TestSubObject(1, 1);
        final TestSubObject tso2 = new TestSubObject(2, 2);
        final TestSubObject tso3 = new TestSubObject(3, 3);
        
        assertReflectionCompareContract(to1, to1, to1, false, excludeFields);
        assertReflectionCompareContract(to1, to2, to3, false, excludeFields);
        assertReflectionCompareContract(tso1, tso1, tso1, false, excludeFields);
        assertReflectionCompareContract(tso1, tso2, tso3, false, excludeFields);
        assertReflectionCompareContract("1", "2", "3", false, excludeFields);
        
        assertTrue(0 != CompareToBuilder.reflectionCompare(tso1, new TestSubObject(1, 0), testTransients));
        assertTrue(0 != CompareToBuilder.reflectionCompare(tso1, new TestSubObject(0, 1), testTransients));

        // root class
        assertXYZCompareOrder(to1, to2, to3, true, null);
        // subclass  
        assertXYZCompareOrder(tso1, tso2, tso3, true, null);  
    }

    /**
     * See "Effective Java" under "Consider Implementing Comparable".
     *  
     * @param x an object to compare 
     * @param y an object to compare
     * @param z an object to compare
     * @param testTransients Whether to include transients in the comparison
     * @param excludeFields fields to exclude
     */
    private void assertReflectionCompareContract(final Object x, final Object y, final Object z, final boolean testTransients, final String[] excludeFields) {

        // signum
        assertTrue(reflectionCompareSignum(x, y, testTransients, excludeFields) == -reflectionCompareSignum(y, x, testTransients, excludeFields));
        
        // transitive
        if (CompareToBuilder.reflectionCompare(x, y, testTransients, null, excludeFields) > 0 
                && CompareToBuilder.reflectionCompare(y, z, testTransients, null, excludeFields) > 0){
            assertTrue(CompareToBuilder.reflectionCompare(x, z, testTransients, null, excludeFields) > 0);
        }
        
        // un-named
        if (CompareToBuilder.reflectionCompare(x, y, testTransients, null, excludeFields) == 0) {
            assertTrue(reflectionCompareSignum(x, z, testTransients, excludeFields) == -reflectionCompareSignum(y, z, testTransients, excludeFields));
        }
        
        // strongly recommended but not strictly required
        assertTrue(CompareToBuilder.reflectionCompare(x, y, testTransients) ==0 == EqualsBuilder.reflectionEquals(x, y, testTransients));
    }
    
    /**
     * Returns the signum of the result of comparing x and y with
     * <code>CompareToBuilder.reflectionCompare</code>
     * 
     * @param lhs The "left-hand-side" of the comparison.
     * @param rhs The "right-hand-side" of the comparison.
     * @param testTransients Whether to include transients in the comparison
     * @param excludeFields fields to exclude
     * @return int The signum
     */
    private int reflectionCompareSignum(final Object lhs, final Object rhs, final boolean testTransients, final String[] excludeFields) {
        return BigInteger.valueOf(CompareToBuilder.reflectionCompare(lhs, rhs, testTransients)).signum();
    }
    
    
    
    
    
    

    

    
    
    

    

    

    

    

    

    

    

    

    

    

    

    

    

    

    

    

    

    

    

    

    

    
    
    

    

    

    

    

    

    

    

    

    

    

    

    

    
  
 }
