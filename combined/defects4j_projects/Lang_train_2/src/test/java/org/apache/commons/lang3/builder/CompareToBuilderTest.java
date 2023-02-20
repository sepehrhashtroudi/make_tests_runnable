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
public void testRaggedArray954() { 
     final long[][] array1 = new long[2][]; 
     final long[][] array2 = new long[2][]; 
     final long[][] array3 = new long[3][]; 
     for (int i = 0; i < array1.length; ++i) { 
         array1[i] = new long[2]; 
         array2[i] = new long[2]; 
         array3[i] = new long[3]; 
         for (int j = 0; j < array1[i].length; ++j) { 
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
public void testReflectionHierarchyCompare955() { 
     testReflectionHierarchyCompare(false, null); 
 }
@Test
public void testReflectionCompare956() { 
     final TestObject o1 = new TestObject(4); 
     final TestObject o2 = new TestObject(4); 
     assertTrue(CompareToBuilder.reflectionCompare(o1, o1) == 0); 
     assertTrue(CompareToBuilder.reflectionCompare(o1, o2) == 0); 
     o2.setA(5); 
     assertTrue(CompareToBuilder.reflectionCompare(o1, o2) < 0); 
     assertTrue(CompareToBuilder.reflectionCompare(o2, o1) > 0); 
 }
@Test(expected = NullPointerException.class) 
 public void testReflectionCompareEx1957() { 
     final TestObject o1 = new TestObject(4); 
     CompareToBuilder.reflectionCompare(o1, null); 
 }
@Test
public void testObject958() { 
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
public void testObjectArrayHiddenByObject959() { 
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
public void testMultiIntArray960() { 
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
public void testMultiShortArray961() { 
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
public void testMultiCharArray962() { 
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
public void testDoubleArrayHiddenByObject963() { 
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
public void testMultiFloatArray964() { 
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
public void testMultiBooleanArray965() { 
     final boolean[][] array1 = new boolean[2][2]; 
     final boolean[][] array2 = new boolean[2][2]; 
     final boolean[][] array3 = new boolean[2][3]; 
     for (int i = 0; i < array1.length; ++i) { 
         for (int j = 0; j < array1[0].length; j++) { 
             array1[i][j] = i == 1 ^ j == 1; 
             array2[i][j] = i == 1 ^ j == 1; 
             array3[i][j] = i == 1 ^ j == 1; 
         } 
     } 
     array3[1][2] = false; 
     array3[1][2] = false; 
     assertTrue(new CompareToBuilder().append(array1, array1).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(array1, array2).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(array1, array3).toComparison() < 0); 
     assertTrue(new CompareToBuilder().append(array3, array1).toComparison() > 0); 
     array1[1][1] = true; 
     assertTrue(new CompareToBuilder().append(array1, array2).toComparison() > 0); 
     assertTrue(new CompareToBuilder().append(array2, array1).toComparison() < 0); 
 }
@Test
public void testObjectComparator966() { 
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
@Test
public void testShortArray967() { 
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
public void testCharArray968() { 
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
public void testDoubleArray969() { 
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
public void testObjectArray970() { 
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
public void testLongArray971() { 
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
public void testIntArray972() { 
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
public void testFloatArray973() { 
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
public void testBooleanArray974() { 
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
public void testObjectBuild975() { 
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
