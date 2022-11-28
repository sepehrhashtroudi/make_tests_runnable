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
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;

import org.junit.Test;

/**
 * Unit tests {@link org.apache.commons.lang3.builder.EqualsBuilder}.
 *
 * @version $Id$
 */
public class EqualsBuilderTest {

    //-----------------------------------------------------------------------

    static class TestObject {
        private int a;
        public TestObject() {
        }
        public TestObject(final int a) {
            this.a = a;
        }
        @Override
        public boolean equals(final Object o) {
            if (o == null) { return false; }
            if (o == this) { return true; }
            if (o.getClass() != getClass()) {
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
            if (o == null) { return false; }
            if (o == this) { return true; }
            if (o.getClass() != getClass()) {
                return false;
            }

            final TestSubObject rhs = (TestSubObject) o;
            return super.equals(o) && b == rhs.b;
        }

        @Override
        public int hashCode() {
            return b *17 + super.hashCode();
        }

        public void setB(final int b) {
            this.b = b;
        }

        public int getB() {
            return b;
        }
    }
    
    static class TestEmptySubObject extends TestObject {
        public TestEmptySubObject(final int a) {
            super(a);
        }
    }

    static class TestTSubObject extends TestObject {
        @SuppressWarnings("unused")
        private transient int t;
        public TestTSubObject(final int a, final int t) {
            super(a);
            this.t = t;
        }
    }

    static class TestTTSubObject extends TestTSubObject {
        @SuppressWarnings("unused")
        private transient int tt;
        public TestTTSubObject(final int a, final int t, final int tt) {
            super(a, t);
            this.tt = tt;
        }
    }

    static class TestTTLeafObject extends TestTTSubObject {
        @SuppressWarnings("unused")
        private final int leafValue;
        public TestTTLeafObject(final int a, final int t, final int tt, final int leafValue) {
            super(a, t, tt);
            this.leafValue = leafValue;
        }
    }

    static class TestTSubObject2 extends TestObject {
        private transient int t;
        public TestTSubObject2(final int a, final int t) {
            super(a);
        }
        public int getT() {
            return t;
        }
        public void setT(final int t) {
            this.t = t;
        }
    }

@Test
public void testSuper53() { 
     final TestObject o1 = new TestObject(4); 
     final TestObject o2 = new TestObject(5); 
     assertTrue(new EqualsBuilder().appendSuper(true).append(o1, o1).isEquals()); 
     assertFalse(new EqualsBuilder().appendSuper(false).append(o1, o1).isEquals()); 
     assertFalse(new EqualsBuilder().appendSuper(true).append(o1, o2).isEquals()); 
     assertFalse(new EqualsBuilder().appendSuper(false).append(o1, o2).isEquals()); 
 }
@Test
public void testSuper170() { 
     final TestObject o1 = new TestObject(4); 
     final TestObject o2 = new TestObject(5); 
     assertTrue(new EqualsBuilder().appendSuper(true).append(o1, o1).isEquals()); 
     assertFalse(new EqualsBuilder().appendSuper(false).append(o1, o1).isEquals()); 
     assertFalse(new EqualsBuilder().appendSuper(true).append(o1, o2).isEquals()); 
     assertFalse(new EqualsBuilder().appendSuper(false).append(o1, o2).isEquals()); 
 }
@Test
public void testMultiDoubleArray175() { 
     final double[][] array1 = new double[2][2]; 
     final double[][] array2 = new double[2][2]; 
     for (int i = 0; i < array1.length; ++i) { 
         for (int j = 0; j < array1[0].length; j++) { 
             array1[i][j] = (i + 1) * (j + 1); 
             array2[i][j] = (i + 1) * (j + 1); 
         } 
     } 
     assertTrue(new EqualsBuilder().append(array1, array1).isEquals()); 
     assertTrue(new EqualsBuilder().append(array1, array2).isEquals()); 
     array1[1][1] = 0; 
     assertTrue(!new EqualsBuilder().append(array1, array2).isEquals()); 
 }
@Test
public void testBooleanArray206() { 
     boolean[] obj1 = new boolean[2]; 
     obj1[0] = true; 
     obj1[1] = false; 
     boolean[] obj2 = new boolean[2]; 
     obj2[0] = true; 
     obj2[1] = false; 
     assertTrue(new EqualsBuilder().append(obj1, obj1).isEquals()); 
     assertTrue(new EqualsBuilder().append(obj1, obj2).isEquals()); 
     obj1[1] = true; 
     assertTrue(!new EqualsBuilder().append(obj1, obj2).isEquals()); 
     obj2 = null; 
     assertTrue(!new EqualsBuilder().append(obj1, obj2).isEquals()); 
     obj1 = null; 
     assertTrue(new EqualsBuilder().append(obj1, obj2).isEquals()); 
 }
@Test
public void testMultiLongArray250() { 
     final long[][] array1 = new long[2][2]; 
     final long[][] array2 = new long[2][2]; 
     for (int i = 0; i < array1.length; ++i) { 
         for (int j = 0; j < array1[0].length; j++) { 
             array1[i][j] = (i + 1) * (j + 1); 
             array2[i][j] = (i + 1) * (j + 1); 
         } 
     } 
     assertTrue(new EqualsBuilder().append(array1, array1).isEquals()); 
     assertTrue(new EqualsBuilder().append(array1, array2).isEquals()); 
     array1[1][1] = 0; 
     assertTrue(!new EqualsBuilder().append(array1, array2).isEquals()); 
 }
@Test
public void testMultiShortArray279() { 
     final short[][] array1 = new short[2][2]; 
     final short[][] array2 = new short[2][2]; 
     for (short i = 0; i < array1.length; ++i) { 
         for (short j = 0; j < array1[0].length; j++) { 
             array1[i][j] = i; 
             array2[i][j] = i; 
         } 
     } 
     assertTrue(new EqualsBuilder().append(array1, array1).isEquals()); 
     assertTrue(new EqualsBuilder().append(array1, array2).isEquals()); 
     array1[1][1] = 0; 
     assertTrue(!new EqualsBuilder().append(array1, array2).isEquals()); 
 }
@Test
public void testShortArray326() { 
     short[] obj1 = new short[2]; 
     obj1[0] = 5; 
     obj1[1] = 6; 
     short[] obj2 = new short[2]; 
     obj2[0] = 5; 
     obj2[1] = 6; 
     assertTrue(new EqualsBuilder().append(obj1, obj1).isEquals()); 
     assertTrue(new EqualsBuilder().append(obj1, obj2).isEquals()); 
     obj1[1] = 7; 
     assertTrue(!new EqualsBuilder().append(obj1, obj2).isEquals()); 
     obj2 = null; 
     assertTrue(!new EqualsBuilder().append(obj1, obj2).isEquals()); 
     obj1 = null; 
     assertTrue(new EqualsBuilder().append(obj1, obj2).isEquals()); 
 }
@Test
public void testReflectionHierarchyEquals328() { 
     testReflectionHierarchyEquals(false); 
     testReflectionHierarchyEquals(true); 
     assertTrue(EqualsBuilder.reflectionEquals(new TestTTLeafObject(1, 2, 3, 4), new TestTTLeafObject(1, 2, 3, 4), true)); 
     assertTrue(EqualsBuilder.reflectionEquals(new TestTTLeafObject(1, 2, 3, 4), new TestTTLeafObject(1, 2, 3, 4), false)); 
     assertTrue(!EqualsBuilder.reflectionEquals(new TestTTLeafObject(1, 0, 0, 4), new TestTTLeafObject(1, 2, 3, 4), true)); 
     assertTrue(!EqualsBuilder.reflectionEquals(new TestTTLeafObject(1, 2, 3, 4), new TestTTLeafObject(1, 2, 3, 0), true)); 
     assertTrue(!EqualsBuilder.reflectionEquals(new TestTTLeafObject(0, 2, 3, 4), new TestTTLeafObject(1, 2, 3, 4), true)); 
 }
@Test
public void testReflectionEquals401() { 
     final TestObject o1 = new TestObject(4); 
     final TestObject o2 = new TestObject(5); 
     assertTrue(EqualsBuilder.reflectionEquals(o1, o1)); 
     assertTrue(!EqualsBuilder.reflectionEquals(o1, o2)); 
     o2.setA(4); 
     assertTrue(EqualsBuilder.reflectionEquals(o1, o2)); 
     assertTrue(!EqualsBuilder.reflectionEquals(o1, this)); 
     assertTrue(!EqualsBuilder.reflectionEquals(o1, null)); 
     assertTrue(!EqualsBuilder.reflectionEquals(null, o2)); 
     assertTrue(EqualsBuilder.reflectionEquals((Object) null, (Object) null)); 
 }
@Test
public void testCharArrayHiddenByObject420() { 
     final char[] array1 = new char[2]; 
     array1[0] = 5; 
     array1[1] = 6; 
     final char[] array2 = new char[2]; 
     array2[0] = 5; 
     array2[1] = 6; 
     final Object obj1 = array1; 
     final Object obj2 = array2; 
     assertTrue(new EqualsBuilder().append(obj1, obj1).isEquals()); 
     assertTrue(new EqualsBuilder().append(obj1, array1).isEquals()); 
     assertTrue(new EqualsBuilder().append(obj1, obj2).isEquals()); 
     assertTrue(new EqualsBuilder().append(obj1, array2).isEquals()); 
     array1[1] = 7; 
     assertTrue(!new EqualsBuilder().append(obj1, obj2).isEquals()); 
 }
@Test
public void testMultiBooleanArray491() { 
     final boolean[][] array1 = new boolean[2][2]; 
     final boolean[][] array2 = new boolean[2][2]; 
     for (int i = 0; i < array1.length; ++i) { 
         for (int j = 0; j < array1[0].length; j++) { 
             array1[i][j] = i == 1 || j == 1; 
             array2[i][j] = i == 1 || j == 1; 
         } 
     } 
     assertTrue(new EqualsBuilder().append(array1, array1).isEquals()); 
     assertTrue(new EqualsBuilder().append(array1, array2).isEquals()); 
     array1[1][1] = false; 
     assertTrue(!new EqualsBuilder().append(array1, array2).isEquals()); 
     final boolean[] array3 = new boolean[] { true, true }; 
     assertFalse(new EqualsBuilder().append(array1, array3).isEquals()); 
     assertFalse(new EqualsBuilder().append(array3, array1).isEquals()); 
     assertFalse(new EqualsBuilder().append(array2, array3).isEquals()); 
     assertFalse(new EqualsBuilder().append(array3, array2).isEquals()); 
 }
@Test
public void testByteArray569() { 
     byte[] obj1 = new byte[2]; 
     obj1[0] = 5; 
     obj1[1] = 6; 
     byte[] obj2 = new byte[2]; 
     obj2[0] = 5; 
     obj2[1] = 6; 
     assertTrue(new EqualsBuilder().append(obj1, obj1).isEquals()); 
     assertTrue(new EqualsBuilder().append(obj1, obj2).isEquals()); 
     obj1[1] = 7; 
     assertTrue(!new EqualsBuilder().append(obj1, obj2).isEquals()); 
     obj2 = null; 
     assertTrue(!new EqualsBuilder().append(obj1, obj2).isEquals()); 
     obj1 = null; 
     assertTrue(new EqualsBuilder().append(obj1, obj2).isEquals()); 
 }
@Test
public void testCharArrayHiddenByObject575() { 
     final char[] array1 = new char[2]; 
     array1[0] = 5; 
     array1[1] = 6; 
     final char[] array2 = new char[2]; 
     array2[0] = 5; 
     array2[1] = 6; 
     final Object obj1 = array1; 
     final Object obj2 = array2; 
     assertTrue(new EqualsBuilder().append(obj1, obj1).isEquals()); 
     assertTrue(new EqualsBuilder().append(obj1, array1).isEquals()); 
     assertTrue(new EqualsBuilder().append(obj1, obj2).isEquals()); 
     assertTrue(new EqualsBuilder().append(obj1, array2).isEquals()); 
     array1[1] = 7; 
     assertTrue(!new EqualsBuilder().append(obj1, obj2).isEquals()); 
 }
@Test
public void testShortArray619() { 
     short[] obj1 = new short[2]; 
     obj1[0] = 5; 
     obj1[1] = 6; 
     short[] obj2 = new short[2]; 
     obj2[0] = 5; 
     obj2[1] = 6; 
     assertTrue(new EqualsBuilder().append(obj1, obj1).isEquals()); 
     assertTrue(new EqualsBuilder().append(obj1, obj2).isEquals()); 
     obj1[1] = 7; 
     assertTrue(!new EqualsBuilder().append(obj1, obj2).isEquals()); 
     obj2 = null; 
     assertTrue(!new EqualsBuilder().append(obj1, obj2).isEquals()); 
     obj1 = null; 
     assertTrue(new EqualsBuilder().append(obj1, obj2).isEquals()); 
 }
@Test
public void testByteArray691() { 
     byte[] obj1 = new byte[2]; 
     obj1[0] = 5; 
     obj1[1] = 6; 
     byte[] obj2 = new byte[2]; 
     obj2[0] = 5; 
     obj2[1] = 6; 
     assertTrue(new EqualsBuilder().append(obj1, obj1).isEquals()); 
     assertTrue(new EqualsBuilder().append(obj1, obj2).isEquals()); 
     obj1[1] = 7; 
     assertTrue(!new EqualsBuilder().append(obj1, obj2).isEquals()); 
     obj2 = null; 
     assertTrue(!new EqualsBuilder().append(obj1, obj2).isEquals()); 
     obj1 = null; 
     assertTrue(new EqualsBuilder().append(obj1, obj2).isEquals()); 
 }
@Test
public void testBooleanArray754() { 
     boolean[] obj1 = new boolean[2]; 
     obj1[0] = true; 
     obj1[1] = false; 
     boolean[] obj2 = new boolean[2]; 
     obj2[0] = true; 
     obj2[1] = false; 
     assertTrue(new EqualsBuilder().append(obj1, obj1).isEquals()); 
     assertTrue(new EqualsBuilder().append(obj1, obj2).isEquals()); 
     obj1[1] = true; 
     assertTrue(!new EqualsBuilder().append(obj1, obj2).isEquals()); 
     obj2 = null; 
     assertTrue(!new EqualsBuilder().append(obj1, obj2).isEquals()); 
     obj1 = null; 
     assertTrue(new EqualsBuilder().append(obj1, obj2).isEquals()); 
 }
@Test
public void testBooleanArray780() { 
     boolean[] obj1 = new boolean[2]; 
     obj1[0] = true; 
     obj1[1] = false; 
     boolean[] obj2 = new boolean[2]; 
     obj2[0] = true; 
     obj2[1] = false; 
     assertTrue(new EqualsBuilder().append(obj1, obj1).isEquals()); 
     assertTrue(new EqualsBuilder().append(obj1, obj2).isEquals()); 
     obj1[1] = true; 
     assertTrue(!new EqualsBuilder().append(obj1, obj2).isEquals()); 
     obj2 = null; 
     assertTrue(!new EqualsBuilder().append(obj1, obj2).isEquals()); 
     obj1 = null; 
     assertTrue(new EqualsBuilder().append(obj1, obj2).isEquals()); 
 }
@Test
public void testCyclicalObjectReferences791() { 
     final TestObjectReference refX1 = new TestObjectReference(1); 
     final TestObjectReference x1 = new TestObjectReference(1); 
     x1.setObjectReference(refX1); 
     refX1.setObjectReference(x1); 
     final TestObjectReference refX2 = new TestObjectReference(1); 
     final TestObjectReference x2 = new TestObjectReference(1); 
     x2.setObjectReference(refX2); 
     refX2.setObjectReference(x2); 
     final TestObjectReference refX3 = new TestObjectReference(2); 
     final TestObjectReference x3 = new TestObjectReference(2); 
     x3.setObjectReference(refX3); 
     refX3.setObjectReference(x3); 
     assertTrue(x1.equals(x2)); 
     assertNull(EqualsBuilder.getRegistry()); 
     assertFalse(x1.equals(x3)); 
     assertNull(EqualsBuilder.getRegistry()); 
     assertFalse(x2.equals(x3)); 
     assertNull(EqualsBuilder.getRegistry()); 
 }
@Test
public void testByteArray847() { 
     byte[] obj1 = new byte[2]; 
     obj1[0] = 5; 
     obj1[1] = 6; 
     byte[] obj2 = new byte[2]; 
     obj2[0] = 5; 
     obj2[1] = 6; 
     assertTrue(new EqualsBuilder().append(obj1, obj1).isEquals()); 
     assertTrue(new EqualsBuilder().append(obj1, obj2).isEquals()); 
     obj1[1] = 7; 
     assertTrue(!new EqualsBuilder().append(obj1, obj2).isEquals()); 
     obj2 = null; 
     assertTrue(!new EqualsBuilder().append(obj1, obj2).isEquals()); 
     obj1 = null; 
     assertTrue(new EqualsBuilder().append(obj1, obj2).isEquals()); 
 }
@Test
public void testByteArray978() { 
     byte[] obj1 = new byte[2]; 
     obj1[0] = 5; 
     obj1[1] = 6; 
     byte[] obj2 = new byte[2]; 
     obj2[0] = 5; 
     obj2[1] = 6; 
     assertTrue(new EqualsBuilder().append(obj1, obj1).isEquals()); 
     assertTrue(new EqualsBuilder().append(obj1, obj2).isEquals()); 
     obj1[1] = 7; 
     assertTrue(!new EqualsBuilder().append(obj1, obj2).isEquals()); 
     obj2 = null; 
     assertTrue(!new EqualsBuilder().append(obj1, obj2).isEquals()); 
     obj1 = null; 
     assertTrue(new EqualsBuilder().append(obj1, obj2).isEquals()); 
 }
@Test
public void testReflectionHierarchyEquals1007() { 
     testReflectionHierarchyEquals(false); 
     testReflectionHierarchyEquals(true); 
     assertTrue(EqualsBuilder.reflectionEquals(new TestTTLeafObject(1, 2, 3, 4), new TestTTLeafObject(1, 2, 3, 4), true)); 
     assertTrue(EqualsBuilder.reflectionEquals(new TestTTLeafObject(1, 2, 3, 4), new TestTTLeafObject(1, 2, 3, 4), false)); 
     assertTrue(!EqualsBuilder.reflectionEquals(new TestTTLeafObject(1, 0, 0, 4), new TestTTLeafObject(1, 2, 3, 4), true)); 
     assertTrue(!EqualsBuilder.reflectionEquals(new TestTTLeafObject(1, 2, 3, 4), new TestTTLeafObject(1, 2, 3, 0), true)); 
     assertTrue(!EqualsBuilder.reflectionEquals(new TestTTLeafObject(0, 2, 3, 4), new TestTTLeafObject(1, 2, 3, 4), true)); 
 }
@Test
public void testShortArray1069() { 
     short[] obj1 = new short[2]; 
     obj1[0] = 5; 
     obj1[1] = 6; 
     short[] obj2 = new short[2]; 
     obj2[0] = 5; 
     obj2[1] = 6; 
     assertTrue(new EqualsBuilder().append(obj1, obj1).isEquals()); 
     assertTrue(new EqualsBuilder().append(obj1, obj2).isEquals()); 
     obj1[1] = 7; 
     assertTrue(!new EqualsBuilder().append(obj1, obj2).isEquals()); 
     obj2 = null; 
     assertTrue(!new EqualsBuilder().append(obj1, obj2).isEquals()); 
     obj1 = null; 
     assertTrue(new EqualsBuilder().append(obj1, obj2).isEquals()); 
 }
@Test
public void testByteArray1129() { 
     byte[] obj1 = new byte[2]; 
     obj1[0] = 5; 
     obj1[1] = 6; 
     byte[] obj2 = new byte[2]; 
     obj2[0] = 5; 
     obj2[1] = 6; 
     assertTrue(new EqualsBuilder().append(obj1, obj1).isEquals()); 
     assertTrue(new EqualsBuilder().append(obj1, obj2).isEquals()); 
     obj1[1] = 7; 
     assertTrue(!new EqualsBuilder().append(obj1, obj2).isEquals()); 
     obj2 = null; 
     assertTrue(!new EqualsBuilder().append(obj1, obj2).isEquals()); 
     obj1 = null; 
     assertTrue(new EqualsBuilder().append(obj1, obj2).isEquals()); 
 }
@Test
public void testDoubleArray1171() { 
     double[] obj1 = new double[2]; 
     obj1[0] = 5; 
     obj1[1] = 6; 
     double[] obj2 = new double[2]; 
     obj2[0] = 5; 
     obj2[1] = 6; 
     assertTrue(new EqualsBuilder().append(obj1, obj1).isEquals()); 
     assertTrue(new EqualsBuilder().append(obj1, obj2).isEquals()); 
     obj1[1] = 7; 
     assertTrue(!new EqualsBuilder().append(obj1, obj2).isEquals()); 
     obj2 = null; 
     assertTrue(!new EqualsBuilder().append(obj1, obj2).isEquals()); 
     obj1 = null; 
     assertTrue(new EqualsBuilder().append(obj1, obj2).isEquals()); 
 }
@Test
public void testObjectArray1205() { 
     TestObject[] obj1 = new TestObject[3]; 
     obj1[0] = new TestObject(4); 
     obj1[1] = new TestObject(5); 
     obj1[2] = null; 
     TestObject[] obj2 = new TestObject[3]; 
     obj2[0] = new TestObject(4); 
     obj2[1] = new TestObject(5); 
     obj2[2] = null; 
     assertTrue(new EqualsBuilder().append(obj1, obj1).isEquals()); 
     assertTrue(new EqualsBuilder().append(obj2, obj2).isEquals()); 
     assertTrue(new EqualsBuilder().append(obj1, obj2).isEquals()); 
     obj1[1].setA(6); 
     assertTrue(!new EqualsBuilder().append(obj1, obj2).isEquals()); 
     obj1[1].setA(5); 
     assertTrue(new EqualsBuilder().append(obj1, obj2).isEquals()); 
     obj1[2] = obj1[1]; 
     assertTrue(!new EqualsBuilder().append(obj1, obj2).isEquals()); 
     obj1[2] = null; 
     assertTrue(new EqualsBuilder().append(obj1, obj2).isEquals()); 
     obj2 = null; 
     assertTrue(!new EqualsBuilder().append(obj1, obj2).isEquals()); 
     obj1 = null; 
     assertTrue(new EqualsBuilder().append(obj1, obj2).isEquals()); 
 }
@Test
public void testObjectArray1282() { 
     TestObject[] obj1 = new TestObject[3]; 
     obj1[0] = new TestObject(4); 
     obj1[1] = new TestObject(5); 
     obj1[2] = null; 
     TestObject[] obj2 = new TestObject[3]; 
     obj2[0] = new TestObject(4); 
     obj2[1] = new TestObject(5); 
     obj2[2] = null; 
     assertTrue(new EqualsBuilder().append(obj1, obj1).isEquals()); 
     assertTrue(new EqualsBuilder().append(obj2, obj2).isEquals()); 
     assertTrue(new EqualsBuilder().append(obj1, obj2).isEquals()); 
     obj1[1].setA(6); 
     assertTrue(!new EqualsBuilder().append(obj1, obj2).isEquals()); 
     obj1[1].setA(5); 
     assertTrue(new EqualsBuilder().append(obj1, obj2).isEquals()); 
     obj1[2] = obj1[1]; 
     assertTrue(!new EqualsBuilder().append(obj1, obj2).isEquals()); 
     obj1[2] = null; 
     assertTrue(new EqualsBuilder().append(obj1, obj2).isEquals()); 
     obj2 = null; 
     assertTrue(!new EqualsBuilder().append(obj1, obj2).isEquals()); 
     obj1 = null; 
     assertTrue(new EqualsBuilder().append(obj1, obj2).isEquals()); 
 }
@Test
public void testShortArray1417() { 
     short[] obj1 = new short[2]; 
     obj1[0] = 5; 
     obj1[1] = 6; 
     short[] obj2 = new short[2]; 
     obj2[0] = 5; 
     obj2[1] = 6; 
     assertTrue(new EqualsBuilder().append(obj1, obj1).isEquals()); 
     assertTrue(new EqualsBuilder().append(obj1, obj2).isEquals()); 
     obj1[1] = 7; 
     assertTrue(!new EqualsBuilder().append(obj1, obj2).isEquals()); 
     obj2 = null; 
     assertTrue(!new EqualsBuilder().append(obj1, obj2).isEquals()); 
     obj1 = null; 
     assertTrue(new EqualsBuilder().append(obj1, obj2).isEquals()); 
 }
@Test
public void testMultiDoubleArray1509() { 
     final double[][] array1 = new double[2][2]; 
     final double[][] array2 = new double[2][2]; 
     for (int i = 0; i < array1.length; ++i) { 
         for (int j = 0; j < array1[0].length; j++) { 
             array1[i][j] = (i + 1) * (j + 1); 
             array2[i][j] = (i + 1) * (j + 1); 
         } 
     } 
     assertTrue(new EqualsBuilder().append(array1, array1).isEquals()); 
     assertTrue(new EqualsBuilder().append(array1, array2).isEquals()); 
     array1[1][1] = 0; 
     assertTrue(!new EqualsBuilder().append(array1, array2).isEquals()); 
 }
@Test
public void testLongArray1590() { 
     long[] obj1 = new long[2]; 
     obj1[0] = 5L; 
     obj1[1] = 6L; 
     long[] obj2 = new long[2]; 
     obj2[0] = 5L; 
     obj2[1] = 6L; 
     assertTrue(new EqualsBuilder().append(obj1, obj1).isEquals()); 
     assertTrue(new EqualsBuilder().append(obj1, obj2).isEquals()); 
     obj1[1] = 7; 
     assertTrue(!new EqualsBuilder().append(obj1, obj2).isEquals()); 
     obj2 = null; 
     assertTrue(!new EqualsBuilder().append(obj1, obj2).isEquals()); 
     obj1 = null; 
     assertTrue(new EqualsBuilder().append(obj1, obj2).isEquals()); 
 }
@Test
public void testFloatArray1606() { 
     float[] obj1 = new float[2]; 
     obj1[0] = 5; 
     obj1[1] = 6; 
     float[] obj2 = new float[2]; 
     obj2[0] = 5; 
     obj2[1] = 6; 
     assertTrue(new EqualsBuilder().append(obj1, obj1).isEquals()); 
     assertTrue(new EqualsBuilder().append(obj1, obj2).isEquals()); 
     obj1[1] = 7; 
     assertTrue(!new EqualsBuilder().append(obj1, obj2).isEquals()); 
     obj2 = null; 
     assertTrue(!new EqualsBuilder().append(obj1, obj2).isEquals()); 
     obj1 = null; 
     assertTrue(new EqualsBuilder().append(obj1, obj2).isEquals()); 
 }
@Test
public void testCharArrayHiddenByObject1612() { 
     final char[] array1 = new char[2]; 
     array1[0] = 5; 
     array1[1] = 6; 
     final char[] array2 = new char[2]; 
     array2[0] = 5; 
     array2[1] = 6; 
     final Object obj1 = array1; 
     final Object obj2 = array2; 
     assertTrue(new EqualsBuilder().append(obj1, obj1).isEquals()); 
     assertTrue(new EqualsBuilder().append(obj1, array1).isEquals()); 
     assertTrue(new EqualsBuilder().append(obj1, obj2).isEquals()); 
     assertTrue(new EqualsBuilder().append(obj1, array2).isEquals()); 
     array1[1] = 7; 
     assertTrue(!new EqualsBuilder().append(obj1, obj2).isEquals()); 
 }
@Test
public void testCharArray1645() { 
     char[] obj1 = new char[2]; 
     obj1[0] = 5; 
     obj1[1] = 6; 
     char[] obj2 = new char[2]; 
     obj2[0] = 5; 
     obj2[1] = 6; 
     assertTrue(new EqualsBuilder().append(obj1, obj1).isEquals()); 
     assertTrue(new EqualsBuilder().append(obj1, obj2).isEquals()); 
     obj1[1] = 7; 
     assertTrue(!new EqualsBuilder().append(obj1, obj2).isEquals()); 
     obj2 = null; 
     assertTrue(!new EqualsBuilder().append(obj1, obj2).isEquals()); 
     obj1 = null; 
     assertTrue(new EqualsBuilder().append(obj1, obj2).isEquals()); 
 }
@Test
public void testFloatArray1697() { 
     float[] obj1 = new float[2]; 
     obj1[0] = 5; 
     obj1[1] = 6; 
     float[] obj2 = new float[2]; 
     obj2[0] = 5; 
     obj2[1] = 6; 
     assertTrue(new EqualsBuilder().append(obj1, obj1).isEquals()); 
     assertTrue(new EqualsBuilder().append(obj1, obj2).isEquals()); 
     obj1[1] = 7; 
     assertTrue(!new EqualsBuilder().append(obj1, obj2).isEquals()); 
     obj2 = null; 
     assertTrue(!new EqualsBuilder().append(obj1, obj2).isEquals()); 
     obj1 = null; 
     assertTrue(new EqualsBuilder().append(obj1, obj2).isEquals()); 
 }
@Test
public void testReflectionEquals1777() { 
     final TestObject o1 = new TestObject(4); 
     final TestObject o2 = new TestObject(5); 
     assertTrue(EqualsBuilder.reflectionEquals(o1, o1)); 
     assertTrue(!EqualsBuilder.reflectionEquals(o1, o2)); 
     o2.setA(4); 
     assertTrue(EqualsBuilder.reflectionEquals(o1, o2)); 
     assertTrue(!EqualsBuilder.reflectionEquals(o1, this)); 
     assertTrue(!EqualsBuilder.reflectionEquals(o1, null)); 
     assertTrue(!EqualsBuilder.reflectionEquals(null, o2)); 
     assertTrue(EqualsBuilder.reflectionEquals((Object) null, (Object) null)); 
 }
@Test
public void testCharArray1791() { 
     char[] obj1 = new char[2]; 
     obj1[0] = 5; 
     obj1[1] = 6; 
     char[] obj2 = new char[2]; 
     obj2[0] = 5; 
     obj2[1] = 6; 
     assertTrue(new EqualsBuilder().append(obj1, obj1).isEquals()); 
     assertTrue(new EqualsBuilder().append(obj1, obj2).isEquals()); 
     obj1[1] = 7; 
     assertTrue(!new EqualsBuilder().append(obj1, obj2).isEquals()); 
     obj2 = null; 
     assertTrue(!new EqualsBuilder().append(obj1, obj2).isEquals()); 
     obj1 = null; 
     assertTrue(new EqualsBuilder().append(obj1, obj2).isEquals()); 
 }
@Test
public void testReflectionEquals1834() { 
     final TestObject o1 = new TestObject(4); 
     final TestObject o2 = new TestObject(5); 
     assertTrue(EqualsBuilder.reflectionEquals(o1, o1)); 
     assertTrue(!EqualsBuilder.reflectionEquals(o1, o2)); 
     o2.setA(4); 
     assertTrue(EqualsBuilder.reflectionEquals(o1, o2)); 
     assertTrue(!EqualsBuilder.reflectionEquals(o1, this)); 
     assertTrue(!EqualsBuilder.reflectionEquals(o1, null)); 
     assertTrue(!EqualsBuilder.reflectionEquals(null, o2)); 
     assertTrue(EqualsBuilder.reflectionEquals((Object) null, (Object) null)); 
 }
@Test
public void testByteArray1850() { 
     byte[] obj1 = new byte[2]; 
     obj1[0] = 5; 
     obj1[1] = 6; 
     byte[] obj2 = new byte[2]; 
     obj2[0] = 5; 
     obj2[1] = 6; 
     assertTrue(new EqualsBuilder().append(obj1, obj1).isEquals()); 
     assertTrue(new EqualsBuilder().append(obj1, obj2).isEquals()); 
     obj1[1] = 7; 
     assertTrue(!new EqualsBuilder().append(obj1, obj2).isEquals()); 
     obj2 = null; 
     assertTrue(!new EqualsBuilder().append(obj1, obj2).isEquals()); 
     obj1 = null; 
     assertTrue(new EqualsBuilder().append(obj1, obj2).isEquals()); 
 }
@Test
public void testMultiLongArray1882() { 
     final long[][] array1 = new long[2][2]; 
     final long[][] array2 = new long[2][2]; 
     for (int i = 0; i < array1.length; ++i) { 
         for (int j = 0; j < array1[0].length; j++) { 
             array1[i][j] = (i + 1) * (j + 1); 
             array2[i][j] = (i + 1) * (j + 1); 
         } 
     } 
     assertTrue(new EqualsBuilder().append(array1, array1).isEquals()); 
     assertTrue(new EqualsBuilder().append(array1, array2).isEquals()); 
     array1[1][1] = 0; 
     assertTrue(!new EqualsBuilder().append(array1, array2).isEquals()); 
 }
@Test
public void testCharArrayHiddenByObject1981() { 
     final char[] array1 = new char[2]; 
     array1[0] = 5; 
     array1[1] = 6; 
     final char[] array2 = new char[2]; 
     array2[0] = 5; 
     array2[1] = 6; 
     final Object obj1 = array1; 
     final Object obj2 = array2; 
     assertTrue(new EqualsBuilder().append(obj1, obj1).isEquals()); 
     assertTrue(new EqualsBuilder().append(obj1, array1).isEquals()); 
     assertTrue(new EqualsBuilder().append(obj1, obj2).isEquals()); 
     assertTrue(new EqualsBuilder().append(obj1, array2).isEquals()); 
     array1[1] = 7; 
     assertTrue(!new EqualsBuilder().append(obj1, obj2).isEquals()); 
 }
@Test
public void testByteArray1992() { 
     byte[] obj1 = new byte[2]; 
     obj1[0] = 5; 
     obj1[1] = 6; 
     byte[] obj2 = new byte[2]; 
     obj2[0] = 5; 
     obj2[1] = 6; 
     assertTrue(new EqualsBuilder().append(obj1, obj1).isEquals()); 
     assertTrue(new EqualsBuilder().append(obj1, obj2).isEquals()); 
     obj1[1] = 7; 
     assertTrue(!new EqualsBuilder().append(obj1, obj2).isEquals()); 
     obj2 = null; 
     assertTrue(!new EqualsBuilder().append(obj1, obj2).isEquals()); 
     obj1 = null; 
     assertTrue(new EqualsBuilder().append(obj1, obj2).isEquals()); 
 }
@Test
public void testReflectionEquals2024() { 
     final TestObject o1 = new TestObject(4); 
     final TestObject o2 = new TestObject(5); 
     assertTrue(EqualsBuilder.reflectionEquals(o1, o1)); 
     assertTrue(!EqualsBuilder.reflectionEquals(o1, o2)); 
     o2.setA(4); 
     assertTrue(EqualsBuilder.reflectionEquals(o1, o2)); 
     assertTrue(!EqualsBuilder.reflectionEquals(o1, this)); 
     assertTrue(!EqualsBuilder.reflectionEquals(o1, null)); 
     assertTrue(!EqualsBuilder.reflectionEquals(null, o2)); 
     assertTrue(EqualsBuilder.reflectionEquals((Object) null, (Object) null)); 
 }
@Test
public void testReflectionEquals2062() { 
     final TestObject o1 = new TestObject(4); 
     final TestObject o2 = new TestObject(5); 
     assertTrue(EqualsBuilder.reflectionEquals(o1, o1)); 
     assertTrue(!EqualsBuilder.reflectionEquals(o1, o2)); 
     o2.setA(4); 
     assertTrue(EqualsBuilder.reflectionEquals(o1, o2)); 
     assertTrue(!EqualsBuilder.reflectionEquals(o1, this)); 
     assertTrue(!EqualsBuilder.reflectionEquals(o1, null)); 
     assertTrue(!EqualsBuilder.reflectionEquals(null, o2)); 
     assertTrue(EqualsBuilder.reflectionEquals((Object) null, (Object) null)); 
 }
@Test
public void testMultiDoubleArray2070() { 
     final double[][] array1 = new double[2][2]; 
     final double[][] array2 = new double[2][2]; 
     for (int i = 0; i < array1.length; ++i) { 
         for (int j = 0; j < array1[0].length; j++) { 
             array1[i][j] = (i + 1) * (j + 1); 
             array2[i][j] = (i + 1) * (j + 1); 
         } 
     } 
     assertTrue(new EqualsBuilder().append(array1, array1).isEquals()); 
     assertTrue(new EqualsBuilder().append(array1, array2).isEquals()); 
     array1[1][1] = 0; 
     assertTrue(!new EqualsBuilder().append(array1, array2).isEquals()); 
 }
@Test
public void testBooleanArrayHiddenByObject2091() { 
     final boolean[] array1 = new boolean[2]; 
     array1[0] = true; 
     array1[1] = false; 
     final boolean[] array2 = new boolean[2]; 
     array2[0] = true; 
     array2[1] = false; 
     final Object obj1 = array1; 
     final Object obj2 = array2; 
     assertTrue(new EqualsBuilder().append(obj1, obj1).isEquals()); 
     assertTrue(new EqualsBuilder().append(obj1, array1).isEquals()); 
     assertTrue(new EqualsBuilder().append(obj1, obj2).isEquals()); 
     assertTrue(new EqualsBuilder().append(obj1, array2).isEquals()); 
     array1[1] = true; 
     assertTrue(!new EqualsBuilder().append(obj1, obj2).isEquals()); 
 }
@Test
public void testFloatArray2118() { 
     float[] obj1 = new float[2]; 
     obj1[0] = 5; 
     obj1[1] = 6; 
     float[] obj2 = new float[2]; 
     obj2[0] = 5; 
     obj2[1] = 6; 
     assertTrue(new EqualsBuilder().append(obj1, obj1).isEquals()); 
     assertTrue(new EqualsBuilder().append(obj1, obj2).isEquals()); 
     obj1[1] = 7; 
     assertTrue(!new EqualsBuilder().append(obj1, obj2).isEquals()); 
     obj2 = null; 
     assertTrue(!new EqualsBuilder().append(obj1, obj2).isEquals()); 
     obj1 = null; 
     assertTrue(new EqualsBuilder().append(obj1, obj2).isEquals()); 
 }
@Test
public void testCharArrayHiddenByObject2266() { 
     final char[] array1 = new char[2]; 
     array1[0] = 5; 
     array1[1] = 6; 
     final char[] array2 = new char[2]; 
     array2[0] = 5; 
     array2[1] = 6; 
     final Object obj1 = array1; 
     final Object obj2 = array2; 
     assertTrue(new EqualsBuilder().append(obj1, obj1).isEquals()); 
     assertTrue(new EqualsBuilder().append(obj1, array1).isEquals()); 
     assertTrue(new EqualsBuilder().append(obj1, obj2).isEquals()); 
     assertTrue(new EqualsBuilder().append(obj1, array2).isEquals()); 
     array1[1] = 7; 
     assertTrue(!new EqualsBuilder().append(obj1, obj2).isEquals()); 
 }
@Test
public void testMultiLongArray2424() { 
     final long[][] array1 = new long[2][2]; 
     final long[][] array2 = new long[2][2]; 
     for (int i = 0; i < array1.length; ++i) { 
         for (int j = 0; j < array1[0].length; j++) { 
             array1[i][j] = (i + 1) * (j + 1); 
             array2[i][j] = (i + 1) * (j + 1); 
         } 
     } 
     assertTrue(new EqualsBuilder().append(array1, array1).isEquals()); 
     assertTrue(new EqualsBuilder().append(array1, array2).isEquals()); 
     array1[1][1] = 0; 
     assertTrue(!new EqualsBuilder().append(array1, array2).isEquals()); 
 }
@Test
public void testByteArray2457() { 
     byte[] obj1 = new byte[2]; 
     obj1[0] = 5; 
     obj1[1] = 6; 
     byte[] obj2 = new byte[2]; 
     obj2[0] = 5; 
     obj2[1] = 6; 
     assertTrue(new EqualsBuilder().append(obj1, obj1).isEquals()); 
     assertTrue(new EqualsBuilder().append(obj1, obj2).isEquals()); 
     obj1[1] = 7; 
     assertTrue(!new EqualsBuilder().append(obj1, obj2).isEquals()); 
     obj2 = null; 
     assertTrue(!new EqualsBuilder().append(obj1, obj2).isEquals()); 
     obj1 = null; 
     assertTrue(new EqualsBuilder().append(obj1, obj2).isEquals()); 
 }
@Test
public void testCharArrayHiddenByObject2621() { 
     final char[] array1 = new char[2]; 
     array1[0] = 5; 
     array1[1] = 6; 
     final char[] array2 = new char[2]; 
     array2[0] = 5; 
     array2[1] = 6; 
     final Object obj1 = array1; 
     final Object obj2 = array2; 
     assertTrue(new EqualsBuilder().append(obj1, obj1).isEquals()); 
     assertTrue(new EqualsBuilder().append(obj1, array1).isEquals()); 
     assertTrue(new EqualsBuilder().append(obj1, obj2).isEquals()); 
     assertTrue(new EqualsBuilder().append(obj1, array2).isEquals()); 
     array1[1] = 7; 
     assertTrue(!new EqualsBuilder().append(obj1, obj2).isEquals()); 
 }
@Test
public void testMultiShortArray2631() { 
     final short[][] array1 = new short[2][2]; 
     final short[][] array2 = new short[2][2]; 
     for (short i = 0; i < array1.length; ++i) { 
         for (short j = 0; j < array1[0].length; j++) { 
             array1[i][j] = i; 
             array2[i][j] = i; 
         } 
     } 
     assertTrue(new EqualsBuilder().append(array1, array1).isEquals()); 
     assertTrue(new EqualsBuilder().append(array1, array2).isEquals()); 
     array1[1][1] = 0; 
     assertTrue(!new EqualsBuilder().append(array1, array2).isEquals()); 
 }
@Test
public void testFloatArray2663() { 
     float[] obj1 = new float[2]; 
     obj1[0] = 5; 
     obj1[1] = 6; 
     float[] obj2 = new float[2]; 
     obj2[0] = 5; 
     obj2[1] = 6; 
     assertTrue(new EqualsBuilder().append(obj1, obj1).isEquals()); 
     assertTrue(new EqualsBuilder().append(obj1, obj2).isEquals()); 
     obj1[1] = 7; 
     assertTrue(!new EqualsBuilder().append(obj1, obj2).isEquals()); 
     obj2 = null; 
     assertTrue(!new EqualsBuilder().append(obj1, obj2).isEquals()); 
     obj1 = null; 
     assertTrue(new EqualsBuilder().append(obj1, obj2).isEquals()); 
 }
@Test
public void testBooleanArray2668() { 
     boolean[] obj1 = new boolean[2]; 
     obj1[0] = true; 
     obj1[1] = false; 
     boolean[] obj2 = new boolean[2]; 
     obj2[0] = true; 
     obj2[1] = false; 
     assertTrue(new EqualsBuilder().append(obj1, obj1).isEquals()); 
     assertTrue(new EqualsBuilder().append(obj1, obj2).isEquals()); 
     obj1[1] = true; 
     assertTrue(!new EqualsBuilder().append(obj1, obj2).isEquals()); 
     obj2 = null; 
     assertTrue(!new EqualsBuilder().append(obj1, obj2).isEquals()); 
     obj1 = null; 
     assertTrue(new EqualsBuilder().append(obj1, obj2).isEquals()); 
 }
@Test
public void testCharArrayHiddenByObject2678() { 
     final char[] array1 = new char[2]; 
     array1[0] = 5; 
     array1[1] = 6; 
     final char[] array2 = new char[2]; 
     array2[0] = 5; 
     array2[1] = 6; 
     final Object obj1 = array1; 
     final Object obj2 = array2; 
     assertTrue(new EqualsBuilder().append(obj1, obj1).isEquals()); 
     assertTrue(new EqualsBuilder().append(obj1, array1).isEquals()); 
     assertTrue(new EqualsBuilder().append(obj1, obj2).isEquals()); 
     assertTrue(new EqualsBuilder().append(obj1, array2).isEquals()); 
     array1[1] = 7; 
     assertTrue(!new EqualsBuilder().append(obj1, obj2).isEquals()); 
 }
@Test
public void testByteArray2686() { 
     byte[] obj1 = new byte[2]; 
     obj1[0] = 5; 
     obj1[1] = 6; 
     byte[] obj2 = new byte[2]; 
     obj2[0] = 5; 
     obj2[1] = 6; 
     assertTrue(new EqualsBuilder().append(obj1, obj1).isEquals()); 
     assertTrue(new EqualsBuilder().append(obj1, obj2).isEquals()); 
     obj1[1] = 7; 
     assertTrue(!new EqualsBuilder().append(obj1, obj2).isEquals()); 
     obj2 = null; 
     assertTrue(!new EqualsBuilder().append(obj1, obj2).isEquals()); 
     obj1 = null; 
     assertTrue(new EqualsBuilder().append(obj1, obj2).isEquals()); 
 }
@Test
public void testBooleanArray2801() { 
     boolean[] obj1 = new boolean[2]; 
     obj1[0] = true; 
     obj1[1] = false; 
     boolean[] obj2 = new boolean[2]; 
     obj2[0] = true; 
     obj2[1] = false; 
     assertTrue(new EqualsBuilder().append(obj1, obj1).isEquals()); 
     assertTrue(new EqualsBuilder().append(obj1, obj2).isEquals()); 
     obj1[1] = true; 
     assertTrue(!new EqualsBuilder().append(obj1, obj2).isEquals()); 
     obj2 = null; 
     assertTrue(!new EqualsBuilder().append(obj1, obj2).isEquals()); 
     obj1 = null; 
     assertTrue(new EqualsBuilder().append(obj1, obj2).isEquals()); 
 }
@Test
public void testMultiLongArray2848() { 
     final long[][] array1 = new long[2][2]; 
     final long[][] array2 = new long[2][2]; 
     for (int i = 0; i < array1.length; ++i) { 
         for (int j = 0; j < array1[0].length; j++) { 
             array1[i][j] = (i + 1) * (j + 1); 
             array2[i][j] = (i + 1) * (j + 1); 
         } 
     } 
     assertTrue(new EqualsBuilder().append(array1, array1).isEquals()); 
     assertTrue(new EqualsBuilder().append(array1, array2).isEquals()); 
     array1[1][1] = 0; 
     assertTrue(!new EqualsBuilder().append(array1, array2).isEquals()); 
 }
@Test
public void testShortArray2870() { 
     short[] obj1 = new short[2]; 
     obj1[0] = 5; 
     obj1[1] = 6; 
     short[] obj2 = new short[2]; 
     obj2[0] = 5; 
     obj2[1] = 6; 
     assertTrue(new EqualsBuilder().append(obj1, obj1).isEquals()); 
     assertTrue(new EqualsBuilder().append(obj1, obj2).isEquals()); 
     obj1[1] = 7; 
     assertTrue(!new EqualsBuilder().append(obj1, obj2).isEquals()); 
     obj2 = null; 
     assertTrue(!new EqualsBuilder().append(obj1, obj2).isEquals()); 
     obj1 = null; 
     assertTrue(new EqualsBuilder().append(obj1, obj2).isEquals()); 
 }
@Test
public void testShortArray2937() { 
     short[] obj1 = new short[2]; 
     obj1[0] = 5; 
     obj1[1] = 6; 
     short[] obj2 = new short[2]; 
     obj2[0] = 5; 
     obj2[1] = 6; 
     assertTrue(new EqualsBuilder().append(obj1, obj1).isEquals()); 
     assertTrue(new EqualsBuilder().append(obj1, obj2).isEquals()); 
     obj1[1] = 7; 
     assertTrue(!new EqualsBuilder().append(obj1, obj2).isEquals()); 
     obj2 = null; 
     assertTrue(!new EqualsBuilder().append(obj1, obj2).isEquals()); 
     obj1 = null; 
     assertTrue(new EqualsBuilder().append(obj1, obj2).isEquals()); 
 }
@Test
public void testLongArray2949() { 
     long[] obj1 = new long[2]; 
     obj1[0] = 5L; 
     obj1[1] = 6L; 
     long[] obj2 = new long[2]; 
     obj2[0] = 5L; 
     obj2[1] = 6L; 
     assertTrue(new EqualsBuilder().append(obj1, obj1).isEquals()); 
     assertTrue(new EqualsBuilder().append(obj1, obj2).isEquals()); 
     obj1[1] = 7; 
     assertTrue(!new EqualsBuilder().append(obj1, obj2).isEquals()); 
     obj2 = null; 
     assertTrue(!new EqualsBuilder().append(obj1, obj2).isEquals()); 
     obj1 = null; 
     assertTrue(new EqualsBuilder().append(obj1, obj2).isEquals()); 
 }
@Test
public void testShortArray2954() { 
     short[] obj1 = new short[2]; 
     obj1[0] = 5; 
     obj1[1] = 6; 
     short[] obj2 = new short[2]; 
     obj2[0] = 5; 
     obj2[1] = 6; 
     assertTrue(new EqualsBuilder().append(obj1, obj1).isEquals()); 
     assertTrue(new EqualsBuilder().append(obj1, obj2).isEquals()); 
     obj1[1] = 7; 
     assertTrue(!new EqualsBuilder().append(obj1, obj2).isEquals()); 
     obj2 = null; 
     assertTrue(!new EqualsBuilder().append(obj1, obj2).isEquals()); 
     obj1 = null; 
     assertTrue(new EqualsBuilder().append(obj1, obj2).isEquals()); 
 }
@Test
public void testFloatArray3036() { 
     float[] obj1 = new float[2]; 
     obj1[0] = 5; 
     obj1[1] = 6; 
     float[] obj2 = new float[2]; 
     obj2[0] = 5; 
     obj2[1] = 6; 
     assertTrue(new EqualsBuilder().append(obj1, obj1).isEquals()); 
     assertTrue(new EqualsBuilder().append(obj1, obj2).isEquals()); 
     obj1[1] = 7; 
     assertTrue(!new EqualsBuilder().append(obj1, obj2).isEquals()); 
     obj2 = null; 
     assertTrue(!new EqualsBuilder().append(obj1, obj2).isEquals()); 
     obj1 = null; 
     assertTrue(new EqualsBuilder().append(obj1, obj2).isEquals()); 
 }
@Test
public void testReflectionHierarchyEquals3058() { 
     testReflectionHierarchyEquals(false); 
     testReflectionHierarchyEquals(true); 
     assertTrue(EqualsBuilder.reflectionEquals(new TestTTLeafObject(1, 2, 3, 4), new TestTTLeafObject(1, 2, 3, 4), true)); 
     assertTrue(EqualsBuilder.reflectionEquals(new TestTTLeafObject(1, 2, 3, 4), new TestTTLeafObject(1, 2, 3, 4), false)); 
     assertTrue(!EqualsBuilder.reflectionEquals(new TestTTLeafObject(1, 0, 0, 4), new TestTTLeafObject(1, 2, 3, 4), true)); 
     assertTrue(!EqualsBuilder.reflectionEquals(new TestTTLeafObject(1, 2, 3, 4), new TestTTLeafObject(1, 2, 3, 0), true)); 
     assertTrue(!EqualsBuilder.reflectionEquals(new TestTTLeafObject(0, 2, 3, 4), new TestTTLeafObject(1, 2, 3, 4), true)); 
 }
@Test
public void testBooleanArray3132() { 
     boolean[] obj1 = new boolean[2]; 
     obj1[0] = true; 
     obj1[1] = false; 
     boolean[] obj2 = new boolean[2]; 
     obj2[0] = true; 
     obj2[1] = false; 
     assertTrue(new EqualsBuilder().append(obj1, obj1).isEquals()); 
     assertTrue(new EqualsBuilder().append(obj1, obj2).isEquals()); 
     obj1[1] = true; 
     assertTrue(!new EqualsBuilder().append(obj1, obj2).isEquals()); 
     obj2 = null; 
     assertTrue(!new EqualsBuilder().append(obj1, obj2).isEquals()); 
     obj1 = null; 
     assertTrue(new EqualsBuilder().append(obj1, obj2).isEquals()); 
 }
@Test
public void testShortArray3234() { 
     short[] obj1 = new short[2]; 
     obj1[0] = 5; 
     obj1[1] = 6; 
     short[] obj2 = new short[2]; 
     obj2[0] = 5; 
     obj2[1] = 6; 
     assertTrue(new EqualsBuilder().append(obj1, obj1).isEquals()); 
     assertTrue(new EqualsBuilder().append(obj1, obj2).isEquals()); 
     obj1[1] = 7; 
     assertTrue(!new EqualsBuilder().append(obj1, obj2).isEquals()); 
     obj2 = null; 
     assertTrue(!new EqualsBuilder().append(obj1, obj2).isEquals()); 
     obj1 = null; 
     assertTrue(new EqualsBuilder().append(obj1, obj2).isEquals()); 
 }
@Test
public void testReflectionHierarchyEquals3338() { 
     testReflectionHierarchyEquals(false); 
     testReflectionHierarchyEquals(true); 
     assertTrue(EqualsBuilder.reflectionEquals(new TestTTLeafObject(1, 2, 3, 4), new TestTTLeafObject(1, 2, 3, 4), true)); 
     assertTrue(EqualsBuilder.reflectionEquals(new TestTTLeafObject(1, 2, 3, 4), new TestTTLeafObject(1, 2, 3, 4), false)); 
     assertTrue(!EqualsBuilder.reflectionEquals(new TestTTLeafObject(1, 0, 0, 4), new TestTTLeafObject(1, 2, 3, 4), true)); 
     assertTrue(!EqualsBuilder.reflectionEquals(new TestTTLeafObject(1, 2, 3, 4), new TestTTLeafObject(1, 2, 3, 0), true)); 
     assertTrue(!EqualsBuilder.reflectionEquals(new TestTTLeafObject(0, 2, 3, 4), new TestTTLeafObject(1, 2, 3, 4), true)); 
 }
@Test
public void testReset3389() { 
     final EqualsBuilder equalsBuilder = new EqualsBuilder(); 
     assertTrue(equalsBuilder.isEquals()); 
     equalsBuilder.setEquals(false); 
     assertFalse(equalsBuilder.isEquals()); 
     equalsBuilder.reset(); 
     assertTrue(equalsBuilder.isEquals()); 
 }
@Test
public void testShortArray3464() { 
     short[] obj1 = new short[2]; 
     obj1[0] = 5; 
     obj1[1] = 6; 
     short[] obj2 = new short[2]; 
     obj2[0] = 5; 
     obj2[1] = 6; 
     assertTrue(new EqualsBuilder().append(obj1, obj1).isEquals()); 
     assertTrue(new EqualsBuilder().append(obj1, obj2).isEquals()); 
     obj1[1] = 7; 
     assertTrue(!new EqualsBuilder().append(obj1, obj2).isEquals()); 
     obj2 = null; 
     assertTrue(!new EqualsBuilder().append(obj1, obj2).isEquals()); 
     obj1 = null; 
     assertTrue(new EqualsBuilder().append(obj1, obj2).isEquals()); 
 }
@Test
public void testByteArray3614() { 
     byte[] obj1 = new byte[2]; 
     obj1[0] = 5; 
     obj1[1] = 6; 
     byte[] obj2 = new byte[2]; 
     obj2[0] = 5; 
     obj2[1] = 6; 
     assertTrue(new EqualsBuilder().append(obj1, obj1).isEquals()); 
     assertTrue(new EqualsBuilder().append(obj1, obj2).isEquals()); 
     obj1[1] = 7; 
     assertTrue(!new EqualsBuilder().append(obj1, obj2).isEquals()); 
     obj2 = null; 
     assertTrue(!new EqualsBuilder().append(obj1, obj2).isEquals()); 
     obj1 = null; 
     assertTrue(new EqualsBuilder().append(obj1, obj2).isEquals()); 
 }
@Test
public void testObjectBuild3629() { 
     final TestObject o1 = new TestObject(4); 
     final TestObject o2 = new TestObject(5); 
     assertEquals(Boolean.TRUE, new EqualsBuilder().append(o1, o1).build()); 
     assertEquals(Boolean.FALSE, new EqualsBuilder().append(o1, o2).build()); 
     o2.setA(4); 
     assertEquals(Boolean.TRUE, new EqualsBuilder().append(o1, o2).build()); 
     assertEquals(Boolean.FALSE, new EqualsBuilder().append(o1, this).build()); 
     assertEquals(Boolean.FALSE, new EqualsBuilder().append(o1, null).build()); 
     assertEquals(Boolean.FALSE, new EqualsBuilder().append(null, o2).build()); 
     assertEquals(Boolean.TRUE, new EqualsBuilder().append((Object) null, (Object) null).build()); 
 }
@Test
public void testBooleanArray3736() { 
     boolean[] obj1 = new boolean[2]; 
     obj1[0] = true; 
     obj1[1] = false; 
     boolean[] obj2 = new boolean[2]; 
     obj2[0] = true; 
     obj2[1] = false; 
     assertTrue(new EqualsBuilder().append(obj1, obj1).isEquals()); 
     assertTrue(new EqualsBuilder().append(obj1, obj2).isEquals()); 
     obj1[1] = true; 
     assertTrue(!new EqualsBuilder().append(obj1, obj2).isEquals()); 
     obj2 = null; 
     assertTrue(!new EqualsBuilder().append(obj1, obj2).isEquals()); 
     obj1 = null; 
     assertTrue(new EqualsBuilder().append(obj1, obj2).isEquals()); 
 }
@Test
public void testShortArray3823() { 
     short[] obj1 = new short[2]; 
     obj1[0] = 5; 
     obj1[1] = 6; 
     short[] obj2 = new short[2]; 
     obj2[0] = 5; 
     obj2[1] = 6; 
     assertTrue(new EqualsBuilder().append(obj1, obj1).isEquals()); 
     assertTrue(new EqualsBuilder().append(obj1, obj2).isEquals()); 
     obj1[1] = 7; 
     assertTrue(!new EqualsBuilder().append(obj1, obj2).isEquals()); 
     obj2 = null; 
     assertTrue(!new EqualsBuilder().append(obj1, obj2).isEquals()); 
     obj1 = null; 
     assertTrue(new EqualsBuilder().append(obj1, obj2).isEquals()); 
 }
@Test
public void testBooleanArray3854() { 
     boolean[] obj1 = new boolean[2]; 
     obj1[0] = true; 
     obj1[1] = false; 
     boolean[] obj2 = new boolean[2]; 
     obj2[0] = true; 
     obj2[1] = false; 
     assertTrue(new EqualsBuilder().append(obj1, obj1).isEquals()); 
     assertTrue(new EqualsBuilder().append(obj1, obj2).isEquals()); 
     obj1[1] = true; 
     assertTrue(!new EqualsBuilder().append(obj1, obj2).isEquals()); 
     obj2 = null; 
     assertTrue(!new EqualsBuilder().append(obj1, obj2).isEquals()); 
     obj1 = null; 
     assertTrue(new EqualsBuilder().append(obj1, obj2).isEquals()); 
 }
@Test
public void testReset3865() { 
     final EqualsBuilder equalsBuilder = new EqualsBuilder(); 
     assertTrue(equalsBuilder.isEquals()); 
     equalsBuilder.setEquals(false); 
     assertFalse(equalsBuilder.isEquals()); 
     equalsBuilder.reset(); 
     assertTrue(equalsBuilder.isEquals()); 
 }
@Test
public void testFloatArray3890() { 
     float[] obj1 = new float[2]; 
     obj1[0] = 5; 
     obj1[1] = 6; 
     float[] obj2 = new float[2]; 
     obj2[0] = 5; 
     obj2[1] = 6; 
     assertTrue(new EqualsBuilder().append(obj1, obj1).isEquals()); 
     assertTrue(new EqualsBuilder().append(obj1, obj2).isEquals()); 
     obj1[1] = 7; 
     assertTrue(!new EqualsBuilder().append(obj1, obj2).isEquals()); 
     obj2 = null; 
     assertTrue(!new EqualsBuilder().append(obj1, obj2).isEquals()); 
     obj1 = null; 
     assertTrue(new EqualsBuilder().append(obj1, obj2).isEquals()); 
 }
@Test
public void testMultiLongArray3894() { 
     final long[][] array1 = new long[2][2]; 
     final long[][] array2 = new long[2][2]; 
     for (int i = 0; i < array1.length; ++i) { 
         for (int j = 0; j < array1[0].length; j++) { 
             array1[i][j] = (i + 1) * (j + 1); 
             array2[i][j] = (i + 1) * (j + 1); 
         } 
     } 
     assertTrue(new EqualsBuilder().append(array1, array1).isEquals()); 
     assertTrue(new EqualsBuilder().append(array1, array2).isEquals()); 
     array1[1][1] = 0; 
     assertTrue(!new EqualsBuilder().append(array1, array2).isEquals()); 
 }
@Test
public void testMultiDoubleArray3963() { 
     final double[][] array1 = new double[2][2]; 
     final double[][] array2 = new double[2][2]; 
     for (int i = 0; i < array1.length; ++i) { 
         for (int j = 0; j < array1[0].length; j++) { 
             array1[i][j] = (i + 1) * (j + 1); 
             array2[i][j] = (i + 1) * (j + 1); 
         } 
     } 
     assertTrue(new EqualsBuilder().append(array1, array1).isEquals()); 
     assertTrue(new EqualsBuilder().append(array1, array2).isEquals()); 
     array1[1][1] = 0; 
     assertTrue(!new EqualsBuilder().append(array1, array2).isEquals()); 
 }
@Test
public void testShortArray3964() { 
     short[] obj1 = new short[2]; 
     obj1[0] = 5; 
     obj1[1] = 6; 
     short[] obj2 = new short[2]; 
     obj2[0] = 5; 
     obj2[1] = 6; 
     assertTrue(new EqualsBuilder().append(obj1, obj1).isEquals()); 
     assertTrue(new EqualsBuilder().append(obj1, obj2).isEquals()); 
     obj1[1] = 7; 
     assertTrue(!new EqualsBuilder().append(obj1, obj2).isEquals()); 
     obj2 = null; 
     assertTrue(!new EqualsBuilder().append(obj1, obj2).isEquals()); 
     obj1 = null; 
     assertTrue(new EqualsBuilder().append(obj1, obj2).isEquals()); 
 }
@Test
public void testMultiLongArray4012() { 
     final long[][] array1 = new long[2][2]; 
     final long[][] array2 = new long[2][2]; 
     for (int i = 0; i < array1.length; ++i) { 
         for (int j = 0; j < array1[0].length; j++) { 
             array1[i][j] = (i + 1) * (j + 1); 
             array2[i][j] = (i + 1) * (j + 1); 
         } 
     } 
     assertTrue(new EqualsBuilder().append(array1, array1).isEquals()); 
     assertTrue(new EqualsBuilder().append(array1, array2).isEquals()); 
     array1[1][1] = 0; 
     assertTrue(!new EqualsBuilder().append(array1, array2).isEquals()); 
 }
@Test
public void testMultiLongArray4133() { 
     final long[][] array1 = new long[2][2]; 
     final long[][] array2 = new long[2][2]; 
     for (int i = 0; i < array1.length; ++i) { 
         for (int j = 0; j < array1[0].length; j++) { 
             array1[i][j] = (i + 1) * (j + 1); 
             array2[i][j] = (i + 1) * (j + 1); 
         } 
     } 
     assertTrue(new EqualsBuilder().append(array1, array1).isEquals()); 
     assertTrue(new EqualsBuilder().append(array1, array2).isEquals()); 
     array1[1][1] = 0; 
     assertTrue(!new EqualsBuilder().append(array1, array2).isEquals()); 
 }
@Test
public void testIntArrayHiddenByObject4172() { 
     final int[] array1 = new int[2]; 
     array1[0] = 5; 
     array1[1] = 6; 
     final int[] array2 = new int[2]; 
     array2[0] = 5; 
     array2[1] = 6; 
     final Object obj1 = array1; 
     final Object obj2 = array2; 
     assertTrue(new EqualsBuilder().append(obj1, obj1).isEquals()); 
     assertTrue(new EqualsBuilder().append(obj1, array1).isEquals()); 
     assertTrue(new EqualsBuilder().append(obj1, obj2).isEquals()); 
     assertTrue(new EqualsBuilder().append(obj1, array2).isEquals()); 
     array1[1] = 7; 
     assertTrue(!new EqualsBuilder().append(obj1, obj2).isEquals()); 
 }
@Test
public void testByteArray4183() { 
     byte[] obj1 = new byte[2]; 
     obj1[0] = 5; 
     obj1[1] = 6; 
     byte[] obj2 = new byte[2]; 
     obj2[0] = 5; 
     obj2[1] = 6; 
     assertTrue(new EqualsBuilder().append(obj1, obj1).isEquals()); 
     assertTrue(new EqualsBuilder().append(obj1, obj2).isEquals()); 
     obj1[1] = 7; 
     assertTrue(!new EqualsBuilder().append(obj1, obj2).isEquals()); 
     obj2 = null; 
     assertTrue(!new EqualsBuilder().append(obj1, obj2).isEquals()); 
     obj1 = null; 
     assertTrue(new EqualsBuilder().append(obj1, obj2).isEquals()); 
 }
@Test
public void testSuper4224() { 
     final TestObject o1 = new TestObject(4); 
     final TestObject o2 = new TestObject(5); 
     assertTrue(new EqualsBuilder().appendSuper(true).append(o1, o1).isEquals()); 
     assertFalse(new EqualsBuilder().appendSuper(false).append(o1, o1).isEquals()); 
     assertFalse(new EqualsBuilder().appendSuper(true).append(o1, o2).isEquals()); 
     assertFalse(new EqualsBuilder().appendSuper(false).append(o1, o2).isEquals()); 
 }
@Test
public void testCharArray4231() { 
     char[] obj1 = new char[2]; 
     obj1[0] = 5; 
     obj1[1] = 6; 
     char[] obj2 = new char[2]; 
     obj2[0] = 5; 
     obj2[1] = 6; 
     assertTrue(new EqualsBuilder().append(obj1, obj1).isEquals()); 
     assertTrue(new EqualsBuilder().append(obj1, obj2).isEquals()); 
     obj1[1] = 7; 
     assertTrue(!new EqualsBuilder().append(obj1, obj2).isEquals()); 
     obj2 = null; 
     assertTrue(!new EqualsBuilder().append(obj1, obj2).isEquals()); 
     obj1 = null; 
     assertTrue(new EqualsBuilder().append(obj1, obj2).isEquals()); 
 }
@Test
public void testMultiDoubleArray4347() { 
     final double[][] array1 = new double[2][2]; 
     final double[][] array2 = new double[2][2]; 
     for (int i = 0; i < array1.length; ++i) { 
         for (int j = 0; j < array1[0].length; j++) { 
             array1[i][j] = (i + 1) * (j + 1); 
             array2[i][j] = (i + 1) * (j + 1); 
         } 
     } 
     assertTrue(new EqualsBuilder().append(array1, array1).isEquals()); 
     assertTrue(new EqualsBuilder().append(array1, array2).isEquals()); 
     array1[1][1] = 0; 
     assertTrue(!new EqualsBuilder().append(array1, array2).isEquals()); 
 }
@Test
public void testMultiLongArray4435() { 
     final long[][] array1 = new long[2][2]; 
     final long[][] array2 = new long[2][2]; 
     for (int i = 0; i < array1.length; ++i) { 
         for (int j = 0; j < array1[0].length; j++) { 
             array1[i][j] = (i + 1) * (j + 1); 
             array2[i][j] = (i + 1) * (j + 1); 
         } 
     } 
     assertTrue(new EqualsBuilder().append(array1, array1).isEquals()); 
     assertTrue(new EqualsBuilder().append(array1, array2).isEquals()); 
     array1[1][1] = 0; 
     assertTrue(!new EqualsBuilder().append(array1, array2).isEquals()); 
 }
@Test
public void testDoubleArray4465() { 
     double[] obj1 = new double[2]; 
     obj1[0] = 5; 
     obj1[1] = 6; 
     double[] obj2 = new double[2]; 
     obj2[0] = 5; 
     obj2[1] = 6; 
     assertTrue(new EqualsBuilder().append(obj1, obj1).isEquals()); 
     assertTrue(new EqualsBuilder().append(obj1, obj2).isEquals()); 
     obj1[1] = 7; 
     assertTrue(!new EqualsBuilder().append(obj1, obj2).isEquals()); 
     obj2 = null; 
     assertTrue(!new EqualsBuilder().append(obj1, obj2).isEquals()); 
     obj1 = null; 
     assertTrue(new EqualsBuilder().append(obj1, obj2).isEquals()); 
 }
@Test
public void testMultiLongArray4533() { 
     final long[][] array1 = new long[2][2]; 
     final long[][] array2 = new long[2][2]; 
     for (int i = 0; i < array1.length; ++i) { 
         for (int j = 0; j < array1[0].length; j++) { 
             array1[i][j] = (i + 1) * (j + 1); 
             array2[i][j] = (i + 1) * (j + 1); 
         } 
     } 
     assertTrue(new EqualsBuilder().append(array1, array1).isEquals()); 
     assertTrue(new EqualsBuilder().append(array1, array2).isEquals()); 
     array1[1][1] = 0; 
     assertTrue(!new EqualsBuilder().append(array1, array2).isEquals()); 
 }
@Test
public void testShortArray4655() { 
     short[] obj1 = new short[2]; 
     obj1[0] = 5; 
     obj1[1] = 6; 
     short[] obj2 = new short[2]; 
     obj2[0] = 5; 
     obj2[1] = 6; 
     assertTrue(new EqualsBuilder().append(obj1, obj1).isEquals()); 
     assertTrue(new EqualsBuilder().append(obj1, obj2).isEquals()); 
     obj1[1] = 7; 
     assertTrue(!new EqualsBuilder().append(obj1, obj2).isEquals()); 
     obj2 = null; 
     assertTrue(!new EqualsBuilder().append(obj1, obj2).isEquals()); 
     obj1 = null; 
     assertTrue(new EqualsBuilder().append(obj1, obj2).isEquals()); 
 }
@Test
public void testMultiShortArray4660() { 
     final short[][] array1 = new short[2][2]; 
     final short[][] array2 = new short[2][2]; 
     for (short i = 0; i < array1.length; ++i) { 
         for (short j = 0; j < array1[0].length; j++) { 
             array1[i][j] = i; 
             array2[i][j] = i; 
         } 
     } 
     assertTrue(new EqualsBuilder().append(array1, array1).isEquals()); 
     assertTrue(new EqualsBuilder().append(array1, array2).isEquals()); 
     array1[1][1] = 0; 
     assertTrue(!new EqualsBuilder().append(array1, array2).isEquals()); 
 }
@Test
public void testBooleanArray4773() { 
     boolean[] obj1 = new boolean[2]; 
     obj1[0] = true; 
     obj1[1] = false; 
     boolean[] obj2 = new boolean[2]; 
     obj2[0] = true; 
     obj2[1] = false; 
     assertTrue(new EqualsBuilder().append(obj1, obj1).isEquals()); 
     assertTrue(new EqualsBuilder().append(obj1, obj2).isEquals()); 
     obj1[1] = true; 
     assertTrue(!new EqualsBuilder().append(obj1, obj2).isEquals()); 
     obj2 = null; 
     assertTrue(!new EqualsBuilder().append(obj1, obj2).isEquals()); 
     obj1 = null; 
     assertTrue(new EqualsBuilder().append(obj1, obj2).isEquals()); 
 }
@Test
public void testByteArray4775() { 
     byte[] obj1 = new byte[2]; 
     obj1[0] = 5; 
     obj1[1] = 6; 
     byte[] obj2 = new byte[2]; 
     obj2[0] = 5; 
     obj2[1] = 6; 
     assertTrue(new EqualsBuilder().append(obj1, obj1).isEquals()); 
     assertTrue(new EqualsBuilder().append(obj1, obj2).isEquals()); 
     obj1[1] = 7; 
     assertTrue(!new EqualsBuilder().append(obj1, obj2).isEquals()); 
     obj2 = null; 
     assertTrue(!new EqualsBuilder().append(obj1, obj2).isEquals()); 
     obj1 = null; 
     assertTrue(new EqualsBuilder().append(obj1, obj2).isEquals()); 
 }
@Test
public void testMultiDoubleArray4855() { 
     final double[][] array1 = new double[2][2]; 
     final double[][] array2 = new double[2][2]; 
     for (int i = 0; i < array1.length; ++i) { 
         for (int j = 0; j < array1[0].length; j++) { 
             array1[i][j] = (i + 1) * (j + 1); 
             array2[i][j] = (i + 1) * (j + 1); 
         } 
     } 
     assertTrue(new EqualsBuilder().append(array1, array1).isEquals()); 
     assertTrue(new EqualsBuilder().append(array1, array2).isEquals()); 
     array1[1][1] = 0; 
     assertTrue(!new EqualsBuilder().append(array1, array2).isEquals()); 
 }
@Test
public void testDoubleArray4909() { 
     double[] obj1 = new double[2]; 
     obj1[0] = 5; 
     obj1[1] = 6; 
     double[] obj2 = new double[2]; 
     obj2[0] = 5; 
     obj2[1] = 6; 
     assertTrue(new EqualsBuilder().append(obj1, obj1).isEquals()); 
     assertTrue(new EqualsBuilder().append(obj1, obj2).isEquals()); 
     obj1[1] = 7; 
     assertTrue(!new EqualsBuilder().append(obj1, obj2).isEquals()); 
     obj2 = null; 
     assertTrue(!new EqualsBuilder().append(obj1, obj2).isEquals()); 
     obj1 = null; 
     assertTrue(new EqualsBuilder().append(obj1, obj2).isEquals()); 
 }
@Test
public void testBooleanArray5031() { 
     boolean[] obj1 = new boolean[2]; 
     obj1[0] = true; 
     obj1[1] = false; 
     boolean[] obj2 = new boolean[2]; 
     obj2[0] = true; 
     obj2[1] = false; 
     assertTrue(new EqualsBuilder().append(obj1, obj1).isEquals()); 
     assertTrue(new EqualsBuilder().append(obj1, obj2).isEquals()); 
     obj1[1] = true; 
     assertTrue(!new EqualsBuilder().append(obj1, obj2).isEquals()); 
     obj2 = null; 
     assertTrue(!new EqualsBuilder().append(obj1, obj2).isEquals()); 
     obj1 = null; 
     assertTrue(new EqualsBuilder().append(obj1, obj2).isEquals()); 
 }
@Test
public void testFloatArray5085() { 
     float[] obj1 = new float[2]; 
     obj1[0] = 5; 
     obj1[1] = 6; 
     float[] obj2 = new float[2]; 
     obj2[0] = 5; 
     obj2[1] = 6; 
     assertTrue(new EqualsBuilder().append(obj1, obj1).isEquals()); 
     assertTrue(new EqualsBuilder().append(obj1, obj2).isEquals()); 
     obj1[1] = 7; 
     assertTrue(!new EqualsBuilder().append(obj1, obj2).isEquals()); 
     obj2 = null; 
     assertTrue(!new EqualsBuilder().append(obj1, obj2).isEquals()); 
     obj1 = null; 
     assertTrue(new EqualsBuilder().append(obj1, obj2).isEquals()); 
 }
@Test
public void testFloatArray5101() { 
     float[] obj1 = new float[2]; 
     obj1[0] = 5; 
     obj1[1] = 6; 
     float[] obj2 = new float[2]; 
     obj2[0] = 5; 
     obj2[1] = 6; 
     assertTrue(new EqualsBuilder().append(obj1, obj1).isEquals()); 
     assertTrue(new EqualsBuilder().append(obj1, obj2).isEquals()); 
     obj1[1] = 7; 
     assertTrue(!new EqualsBuilder().append(obj1, obj2).isEquals()); 
     obj2 = null; 
     assertTrue(!new EqualsBuilder().append(obj1, obj2).isEquals()); 
     obj1 = null; 
     assertTrue(new EqualsBuilder().append(obj1, obj2).isEquals()); 
 }
@Test
public void testFloatArray5124() { 
     float[] obj1 = new float[2]; 
     obj1[0] = 5; 
     obj1[1] = 6; 
     float[] obj2 = new float[2]; 
     obj2[0] = 5; 
     obj2[1] = 6; 
     assertTrue(new EqualsBuilder().append(obj1, obj1).isEquals()); 
     assertTrue(new EqualsBuilder().append(obj1, obj2).isEquals()); 
     obj1[1] = 7; 
     assertTrue(!new EqualsBuilder().append(obj1, obj2).isEquals()); 
     obj2 = null; 
     assertTrue(!new EqualsBuilder().append(obj1, obj2).isEquals()); 
     obj1 = null; 
     assertTrue(new EqualsBuilder().append(obj1, obj2).isEquals()); 
 }
@Test
public void testFloatArray5128() { 
     float[] obj1 = new float[2]; 
     obj1[0] = 5; 
     obj1[1] = 6; 
     float[] obj2 = new float[2]; 
     obj2[0] = 5; 
     obj2[1] = 6; 
     assertTrue(new EqualsBuilder().append(obj1, obj1).isEquals()); 
     assertTrue(new EqualsBuilder().append(obj1, obj2).isEquals()); 
     obj1[1] = 7; 
     assertTrue(!new EqualsBuilder().append(obj1, obj2).isEquals()); 
     obj2 = null; 
     assertTrue(!new EqualsBuilder().append(obj1, obj2).isEquals()); 
     obj1 = null; 
     assertTrue(new EqualsBuilder().append(obj1, obj2).isEquals()); 
 }
@Test
public void testBooleanArrayHiddenByObject5160() { 
     final boolean[] array1 = new boolean[2]; 
     array1[0] = true; 
     array1[1] = false; 
     final boolean[] array2 = new boolean[2]; 
     array2[0] = true; 
     array2[1] = false; 
     final Object obj1 = array1; 
     final Object obj2 = array2; 
     assertTrue(new EqualsBuilder().append(obj1, obj1).isEquals()); 
     assertTrue(new EqualsBuilder().append(obj1, array1).isEquals()); 
     assertTrue(new EqualsBuilder().append(obj1, obj2).isEquals()); 
     assertTrue(new EqualsBuilder().append(obj1, array2).isEquals()); 
     array1[1] = true; 
     assertTrue(!new EqualsBuilder().append(obj1, obj2).isEquals()); 
 }
@Test
public void testMultiLongArray5176() { 
     final long[][] array1 = new long[2][2]; 
     final long[][] array2 = new long[2][2]; 
     for (int i = 0; i < array1.length; ++i) { 
         for (int j = 0; j < array1[0].length; j++) { 
             array1[i][j] = (i + 1) * (j + 1); 
             array2[i][j] = (i + 1) * (j + 1); 
         } 
     } 
     assertTrue(new EqualsBuilder().append(array1, array1).isEquals()); 
     assertTrue(new EqualsBuilder().append(array1, array2).isEquals()); 
     array1[1][1] = 0; 
     assertTrue(!new EqualsBuilder().append(array1, array2).isEquals()); 
 }
@Test
public void testUnrelatedClasses5285() { 
     final Object[] x = new Object[] { new TestACanEqualB(1) }; 
     final Object[] y = new Object[] { new TestBCanEqualA(1) }; 
     assertTrue(Arrays.equals(x, x)); 
     assertTrue(Arrays.equals(y, y)); 
     assertTrue(Arrays.equals(x, y)); 
     assertTrue(Arrays.equals(y, x)); 
     assertTrue(x[0].equals(x[0])); 
     assertTrue(y[0].equals(y[0])); 
     assertTrue(x[0].equals(y[0])); 
     assertTrue(y[0].equals(x[0])); 
     assertTrue(new EqualsBuilder().append(x, x).isEquals()); 
     assertTrue(new EqualsBuilder().append(y, y).isEquals()); 
     assertTrue(new EqualsBuilder().append(x, y).isEquals()); 
     assertTrue(new EqualsBuilder().append(y, x).isEquals()); 
 }
@Test
public void testByteArray5312() { 
     byte[] obj1 = new byte[2]; 
     obj1[0] = 5; 
     obj1[1] = 6; 
     byte[] obj2 = new byte[2]; 
     obj2[0] = 5; 
     obj2[1] = 6; 
     assertTrue(new EqualsBuilder().append(obj1, obj1).isEquals()); 
     assertTrue(new EqualsBuilder().append(obj1, obj2).isEquals()); 
     obj1[1] = 7; 
     assertTrue(!new EqualsBuilder().append(obj1, obj2).isEquals()); 
     obj2 = null; 
     assertTrue(!new EqualsBuilder().append(obj1, obj2).isEquals()); 
     obj1 = null; 
     assertTrue(new EqualsBuilder().append(obj1, obj2).isEquals()); 
 }
@Test
public void testMultiLongArray5381() { 
     final long[][] array1 = new long[2][2]; 
     final long[][] array2 = new long[2][2]; 
     for (int i = 0; i < array1.length; ++i) { 
         for (int j = 0; j < array1[0].length; j++) { 
             array1[i][j] = (i + 1) * (j + 1); 
             array2[i][j] = (i + 1) * (j + 1); 
         } 
     } 
     assertTrue(new EqualsBuilder().append(array1, array1).isEquals()); 
     assertTrue(new EqualsBuilder().append(array1, array2).isEquals()); 
     array1[1][1] = 0; 
     assertTrue(!new EqualsBuilder().append(array1, array2).isEquals()); 
 }
@Test
public void testMultiFloatArray5453() { 
     final float[][] array1 = new float[2][2]; 
     final float[][] array2 = new float[2][2]; 
     for (int i = 0; i < array1.length; ++i) { 
         for (int j = 0; j < array1[0].length; j++) { 
             array1[i][j] = (i + 1) * (j + 1); 
             array2[i][j] = (i + 1) * (j + 1); 
         } 
     } 
     assertTrue(new EqualsBuilder().append(array1, array1).isEquals()); 
     assertTrue(new EqualsBuilder().append(array1, array2).isEquals()); 
     array1[1][1] = 0; 
     assertTrue(!new EqualsBuilder().append(array1, array2).isEquals()); 
 }
@Test
public void testBooleanArray5505() { 
     boolean[] obj1 = new boolean[2]; 
     obj1[0] = true; 
     obj1[1] = false; 
     boolean[] obj2 = new boolean[2]; 
     obj2[0] = true; 
     obj2[1] = false; 
     assertTrue(new EqualsBuilder().append(obj1, obj1).isEquals()); 
     assertTrue(new EqualsBuilder().append(obj1, obj2).isEquals()); 
     obj1[1] = true; 
     assertTrue(!new EqualsBuilder().append(obj1, obj2).isEquals()); 
     obj2 = null; 
     assertTrue(!new EqualsBuilder().append(obj1, obj2).isEquals()); 
     obj1 = null; 
     assertTrue(new EqualsBuilder().append(obj1, obj2).isEquals()); 
 }
@Test
public void testCharArrayHiddenByObject5800() { 
     final char[] array1 = new char[2]; 
     array1[0] = 5; 
     array1[1] = 6; 
     final char[] array2 = new char[2]; 
     array2[0] = 5; 
     array2[1] = 6; 
     final Object obj1 = array1; 
     final Object obj2 = array2; 
     assertTrue(new EqualsBuilder().append(obj1, obj1).isEquals()); 
     assertTrue(new EqualsBuilder().append(obj1, array1).isEquals()); 
     assertTrue(new EqualsBuilder().append(obj1, obj2).isEquals()); 
     assertTrue(new EqualsBuilder().append(obj1, array2).isEquals()); 
     array1[1] = 7; 
     assertTrue(!new EqualsBuilder().append(obj1, obj2).isEquals()); 
 }
@Test
public void testMultiDoubleArray5914() { 
     final double[][] array1 = new double[2][2]; 
     final double[][] array2 = new double[2][2]; 
     for (int i = 0; i < array1.length; ++i) { 
         for (int j = 0; j < array1[0].length; j++) { 
             array1[i][j] = (i + 1) * (j + 1); 
             array2[i][j] = (i + 1) * (j + 1); 
         } 
     } 
     assertTrue(new EqualsBuilder().append(array1, array1).isEquals()); 
     assertTrue(new EqualsBuilder().append(array1, array2).isEquals()); 
     array1[1][1] = 0; 
     assertTrue(!new EqualsBuilder().append(array1, array2).isEquals()); 
 }
@Test
public void testMultiDoubleArray5979() { 
     final double[][] array1 = new double[2][2]; 
     final double[][] array2 = new double[2][2]; 
     for (int i = 0; i < array1.length; ++i) { 
         for (int j = 0; j < array1[0].length; j++) { 
             array1[i][j] = (i + 1) * (j + 1); 
             array2[i][j] = (i + 1) * (j + 1); 
         } 
     } 
     assertTrue(new EqualsBuilder().append(array1, array1).isEquals()); 
     assertTrue(new EqualsBuilder().append(array1, array2).isEquals()); 
     array1[1][1] = 0; 
     assertTrue(!new EqualsBuilder().append(array1, array2).isEquals()); 
 }
@Test
public void testBooleanArray5995() { 
     boolean[] obj1 = new boolean[2]; 
     obj1[0] = true; 
     obj1[1] = false; 
     boolean[] obj2 = new boolean[2]; 
     obj2[0] = true; 
     obj2[1] = false; 
     assertTrue(new EqualsBuilder().append(obj1, obj1).isEquals()); 
     assertTrue(new EqualsBuilder().append(obj1, obj2).isEquals()); 
     obj1[1] = true; 
     assertTrue(!new EqualsBuilder().append(obj1, obj2).isEquals()); 
     obj2 = null; 
     assertTrue(!new EqualsBuilder().append(obj1, obj2).isEquals()); 
     obj1 = null; 
     assertTrue(new EqualsBuilder().append(obj1, obj2).isEquals()); 
 }
@Test
public void testShortArray6192() { 
     short[] obj1 = new short[2]; 
     obj1[0] = 5; 
     obj1[1] = 6; 
     short[] obj2 = new short[2]; 
     obj2[0] = 5; 
     obj2[1] = 6; 
     assertTrue(new EqualsBuilder().append(obj1, obj1).isEquals()); 
     assertTrue(new EqualsBuilder().append(obj1, obj2).isEquals()); 
     obj1[1] = 7; 
     assertTrue(!new EqualsBuilder().append(obj1, obj2).isEquals()); 
     obj2 = null; 
     assertTrue(!new EqualsBuilder().append(obj1, obj2).isEquals()); 
     obj1 = null; 
     assertTrue(new EqualsBuilder().append(obj1, obj2).isEquals()); 
 }
@Test
public void testMultiByteArray6310() { 
     final byte[][] array1 = new byte[2][2]; 
     final byte[][] array2 = new byte[2][2]; 
     for (byte i = 0; i < array1.length; ++i) { 
         for (byte j = 0; j < array1[0].length; j++) { 
             array1[i][j] = i; 
             array2[i][j] = i; 
         } 
     } 
     assertTrue(new EqualsBuilder().append(array1, array1).isEquals()); 
     assertTrue(new EqualsBuilder().append(array1, array2).isEquals()); 
     array1[1][1] = 0; 
     assertTrue(!new EqualsBuilder().append(array1, array2).isEquals()); 
 }
@Test
public void testMultiLongArray6314() { 
     final long[][] array1 = new long[2][2]; 
     final long[][] array2 = new long[2][2]; 
     for (int i = 0; i < array1.length; ++i) { 
         for (int j = 0; j < array1[0].length; j++) { 
             array1[i][j] = (i + 1) * (j + 1); 
             array2[i][j] = (i + 1) * (j + 1); 
         } 
     } 
     assertTrue(new EqualsBuilder().append(array1, array1).isEquals()); 
     assertTrue(new EqualsBuilder().append(array1, array2).isEquals()); 
     array1[1][1] = 0; 
     assertTrue(!new EqualsBuilder().append(array1, array2).isEquals()); 
 }
@Test
public void testMultiDoubleArray6479() { 
     final double[][] array1 = new double[2][2]; 
     final double[][] array2 = new double[2][2]; 
     for (int i = 0; i < array1.length; ++i) { 
         for (int j = 0; j < array1[0].length; j++) { 
             array1[i][j] = (i + 1) * (j + 1); 
             array2[i][j] = (i + 1) * (j + 1); 
         } 
     } 
     assertTrue(new EqualsBuilder().append(array1, array1).isEquals()); 
     assertTrue(new EqualsBuilder().append(array1, array2).isEquals()); 
     array1[1][1] = 0; 
     assertTrue(!new EqualsBuilder().append(array1, array2).isEquals()); 
 }
@Test
public void testMultiLongArray6518() { 
     final long[][] array1 = new long[2][2]; 
     final long[][] array2 = new long[2][2]; 
     for (int i = 0; i < array1.length; ++i) { 
         for (int j = 0; j < array1[0].length; j++) { 
             array1[i][j] = (i + 1) * (j + 1); 
             array2[i][j] = (i + 1) * (j + 1); 
         } 
     } 
     assertTrue(new EqualsBuilder().append(array1, array1).isEquals()); 
     assertTrue(new EqualsBuilder().append(array1, array2).isEquals()); 
     array1[1][1] = 0; 
     assertTrue(!new EqualsBuilder().append(array1, array2).isEquals()); 
 }
@Test
public void testBooleanArray6555() { 
     boolean[] obj1 = new boolean[2]; 
     obj1[0] = true; 
     obj1[1] = false; 
     boolean[] obj2 = new boolean[2]; 
     obj2[0] = true; 
     obj2[1] = false; 
     assertTrue(new EqualsBuilder().append(obj1, obj1).isEquals()); 
     assertTrue(new EqualsBuilder().append(obj1, obj2).isEquals()); 
     obj1[1] = true; 
     assertTrue(!new EqualsBuilder().append(obj1, obj2).isEquals()); 
     obj2 = null; 
     assertTrue(!new EqualsBuilder().append(obj1, obj2).isEquals()); 
     obj1 = null; 
     assertTrue(new EqualsBuilder().append(obj1, obj2).isEquals()); 
 }
@Test
public void testBooleanArrayHiddenByObject6607() { 
     final boolean[] array1 = new boolean[2]; 
     array1[0] = true; 
     array1[1] = false; 
     final boolean[] array2 = new boolean[2]; 
     array2[0] = true; 
     array2[1] = false; 
     final Object obj1 = array1; 
     final Object obj2 = array2; 
     assertTrue(new EqualsBuilder().append(obj1, obj1).isEquals()); 
     assertTrue(new EqualsBuilder().append(obj1, array1).isEquals()); 
     assertTrue(new EqualsBuilder().append(obj1, obj2).isEquals()); 
     assertTrue(new EqualsBuilder().append(obj1, array2).isEquals()); 
     array1[1] = true; 
     assertTrue(!new EqualsBuilder().append(obj1, obj2).isEquals()); 
 }
@Test
public void testFloatArray6644() { 
     float[] obj1 = new float[2]; 
     obj1[0] = 5; 
     obj1[1] = 6; 
     float[] obj2 = new float[2]; 
     obj2[0] = 5; 
     obj2[1] = 6; 
     assertTrue(new EqualsBuilder().append(obj1, obj1).isEquals()); 
     assertTrue(new EqualsBuilder().append(obj1, obj2).isEquals()); 
     obj1[1] = 7; 
     assertTrue(!new EqualsBuilder().append(obj1, obj2).isEquals()); 
     obj2 = null; 
     assertTrue(!new EqualsBuilder().append(obj1, obj2).isEquals()); 
     obj1 = null; 
     assertTrue(new EqualsBuilder().append(obj1, obj2).isEquals()); 
 }
@Test
public void testMultiDoubleArray6775() { 
     final double[][] array1 = new double[2][2]; 
     final double[][] array2 = new double[2][2]; 
     for (int i = 0; i < array1.length; ++i) { 
         for (int j = 0; j < array1[0].length; j++) { 
             array1[i][j] = (i + 1) * (j + 1); 
             array2[i][j] = (i + 1) * (j + 1); 
         } 
     } 
     assertTrue(new EqualsBuilder().append(array1, array1).isEquals()); 
     assertTrue(new EqualsBuilder().append(array1, array2).isEquals()); 
     array1[1][1] = 0; 
     assertTrue(!new EqualsBuilder().append(array1, array2).isEquals()); 
 }
@Test
public void testBooleanArray6908() { 
     boolean[] obj1 = new boolean[2]; 
     obj1[0] = true; 
     obj1[1] = false; 
     boolean[] obj2 = new boolean[2]; 
     obj2[0] = true; 
     obj2[1] = false; 
     assertTrue(new EqualsBuilder().append(obj1, obj1).isEquals()); 
     assertTrue(new EqualsBuilder().append(obj1, obj2).isEquals()); 
     obj1[1] = true; 
     assertTrue(!new EqualsBuilder().append(obj1, obj2).isEquals()); 
     obj2 = null; 
     assertTrue(!new EqualsBuilder().append(obj1, obj2).isEquals()); 
     obj1 = null; 
     assertTrue(new EqualsBuilder().append(obj1, obj2).isEquals()); 
 }
@Test
public void testLongArray6958() { 
     long[] obj1 = new long[2]; 
     obj1[0] = 5L; 
     obj1[1] = 6L; 
     long[] obj2 = new long[2]; 
     obj2[0] = 5L; 
     obj2[1] = 6L; 
     assertTrue(new EqualsBuilder().append(obj1, obj1).isEquals()); 
     assertTrue(new EqualsBuilder().append(obj1, obj2).isEquals()); 
     obj1[1] = 7; 
     assertTrue(!new EqualsBuilder().append(obj1, obj2).isEquals()); 
     obj2 = null; 
     assertTrue(!new EqualsBuilder().append(obj1, obj2).isEquals()); 
     obj1 = null; 
     assertTrue(new EqualsBuilder().append(obj1, obj2).isEquals()); 
 }
@Test
public void testSuper7076() { 
     final TestObject o1 = new TestObject(4); 
     final TestObject o2 = new TestObject(5); 
     assertTrue(new EqualsBuilder().appendSuper(true).append(o1, o1).isEquals()); 
     assertFalse(new EqualsBuilder().appendSuper(false).append(o1, o1).isEquals()); 
     assertFalse(new EqualsBuilder().appendSuper(true).append(o1, o2).isEquals()); 
     assertFalse(new EqualsBuilder().appendSuper(false).append(o1, o2).isEquals()); 
 }
@Test
public void testBooleanArrayHiddenByObject7079() { 
     final boolean[] array1 = new boolean[2]; 
     array1[0] = true; 
     array1[1] = false; 
     final boolean[] array2 = new boolean[2]; 
     array2[0] = true; 
     array2[1] = false; 
     final Object obj1 = array1; 
     final Object obj2 = array2; 
     assertTrue(new EqualsBuilder().append(obj1, obj1).isEquals()); 
     assertTrue(new EqualsBuilder().append(obj1, array1).isEquals()); 
     assertTrue(new EqualsBuilder().append(obj1, obj2).isEquals()); 
     assertTrue(new EqualsBuilder().append(obj1, array2).isEquals()); 
     array1[1] = true; 
     assertTrue(!new EqualsBuilder().append(obj1, obj2).isEquals()); 
 }
@Test
public void testMultiLongArray7113() { 
     final long[][] array1 = new long[2][2]; 
     final long[][] array2 = new long[2][2]; 
     for (int i = 0; i < array1.length; ++i) { 
         for (int j = 0; j < array1[0].length; j++) { 
             array1[i][j] = (i + 1) * (j + 1); 
             array2[i][j] = (i + 1) * (j + 1); 
         } 
     } 
     assertTrue(new EqualsBuilder().append(array1, array1).isEquals()); 
     assertTrue(new EqualsBuilder().append(array1, array2).isEquals()); 
     array1[1][1] = 0; 
     assertTrue(!new EqualsBuilder().append(array1, array2).isEquals()); 
 }
@Test
public void testSuper7132() { 
     final TestObject o1 = new TestObject(4); 
     final TestObject o2 = new TestObject(5); 
     assertTrue(new EqualsBuilder().appendSuper(true).append(o1, o1).isEquals()); 
     assertFalse(new EqualsBuilder().appendSuper(false).append(o1, o1).isEquals()); 
     assertFalse(new EqualsBuilder().appendSuper(true).append(o1, o2).isEquals()); 
     assertFalse(new EqualsBuilder().appendSuper(false).append(o1, o2).isEquals()); 
 }
@Test
public void testBooleanArrayHiddenByObject7163() { 
     final boolean[] array1 = new boolean[2]; 
     array1[0] = true; 
     array1[1] = false; 
     final boolean[] array2 = new boolean[2]; 
     array2[0] = true; 
     array2[1] = false; 
     final Object obj1 = array1; 
     final Object obj2 = array2; 
     assertTrue(new EqualsBuilder().append(obj1, obj1).isEquals()); 
     assertTrue(new EqualsBuilder().append(obj1, array1).isEquals()); 
     assertTrue(new EqualsBuilder().append(obj1, obj2).isEquals()); 
     assertTrue(new EqualsBuilder().append(obj1, array2).isEquals()); 
     array1[1] = true; 
     assertTrue(!new EqualsBuilder().append(obj1, obj2).isEquals()); 
 }
@Test
public void testReflectionEquals7178() { 
     final TestObject o1 = new TestObject(4); 
     final TestObject o2 = new TestObject(5); 
     assertTrue(EqualsBuilder.reflectionEquals(o1, o1)); 
     assertTrue(!EqualsBuilder.reflectionEquals(o1, o2)); 
     o2.setA(4); 
     assertTrue(EqualsBuilder.reflectionEquals(o1, o2)); 
     assertTrue(!EqualsBuilder.reflectionEquals(o1, this)); 
     assertTrue(!EqualsBuilder.reflectionEquals(o1, null)); 
     assertTrue(!EqualsBuilder.reflectionEquals(null, o2)); 
     assertTrue(EqualsBuilder.reflectionEquals((Object) null, (Object) null)); 
 }
@Test
public void testCharArrayHiddenByObject7249() { 
     final char[] array1 = new char[2]; 
     array1[0] = 5; 
     array1[1] = 6; 
     final char[] array2 = new char[2]; 
     array2[0] = 5; 
     array2[1] = 6; 
     final Object obj1 = array1; 
     final Object obj2 = array2; 
     assertTrue(new EqualsBuilder().append(obj1, obj1).isEquals()); 
     assertTrue(new EqualsBuilder().append(obj1, array1).isEquals()); 
     assertTrue(new EqualsBuilder().append(obj1, obj2).isEquals()); 
     assertTrue(new EqualsBuilder().append(obj1, array2).isEquals()); 
     array1[1] = 7; 
     assertTrue(!new EqualsBuilder().append(obj1, obj2).isEquals()); 
 }
@Test
public void testReflectionHierarchyEquals7254() { 
     testReflectionHierarchyEquals(false); 
     testReflectionHierarchyEquals(true); 
     assertTrue(EqualsBuilder.reflectionEquals(new TestTTLeafObject(1, 2, 3, 4), new TestTTLeafObject(1, 2, 3, 4), true)); 
     assertTrue(EqualsBuilder.reflectionEquals(new TestTTLeafObject(1, 2, 3, 4), new TestTTLeafObject(1, 2, 3, 4), false)); 
     assertTrue(!EqualsBuilder.reflectionEquals(new TestTTLeafObject(1, 0, 0, 4), new TestTTLeafObject(1, 2, 3, 4), true)); 
     assertTrue(!EqualsBuilder.reflectionEquals(new TestTTLeafObject(1, 2, 3, 4), new TestTTLeafObject(1, 2, 3, 0), true)); 
     assertTrue(!EqualsBuilder.reflectionEquals(new TestTTLeafObject(0, 2, 3, 4), new TestTTLeafObject(1, 2, 3, 4), true)); 
 }
@Test
public void testShortArray7319() { 
     short[] obj1 = new short[2]; 
     obj1[0] = 5; 
     obj1[1] = 6; 
     short[] obj2 = new short[2]; 
     obj2[0] = 5; 
     obj2[1] = 6; 
     assertTrue(new EqualsBuilder().append(obj1, obj1).isEquals()); 
     assertTrue(new EqualsBuilder().append(obj1, obj2).isEquals()); 
     obj1[1] = 7; 
     assertTrue(!new EqualsBuilder().append(obj1, obj2).isEquals()); 
     obj2 = null; 
     assertTrue(!new EqualsBuilder().append(obj1, obj2).isEquals()); 
     obj1 = null; 
     assertTrue(new EqualsBuilder().append(obj1, obj2).isEquals()); 
 }
@Test
public void testMultiLongArray7327() { 
     final long[][] array1 = new long[2][2]; 
     final long[][] array2 = new long[2][2]; 
     for (int i = 0; i < array1.length; ++i) { 
         for (int j = 0; j < array1[0].length; j++) { 
             array1[i][j] = (i + 1) * (j + 1); 
             array2[i][j] = (i + 1) * (j + 1); 
         } 
     } 
     assertTrue(new EqualsBuilder().append(array1, array1).isEquals()); 
     assertTrue(new EqualsBuilder().append(array1, array2).isEquals()); 
     array1[1][1] = 0; 
     assertTrue(!new EqualsBuilder().append(array1, array2).isEquals()); 
 }
@Test
public void testCharArrayHiddenByObject7400() { 
     final char[] array1 = new char[2]; 
     array1[0] = 5; 
     array1[1] = 6; 
     final char[] array2 = new char[2]; 
     array2[0] = 5; 
     array2[1] = 6; 
     final Object obj1 = array1; 
     final Object obj2 = array2; 
     assertTrue(new EqualsBuilder().append(obj1, obj1).isEquals()); 
     assertTrue(new EqualsBuilder().append(obj1, array1).isEquals()); 
     assertTrue(new EqualsBuilder().append(obj1, obj2).isEquals()); 
     assertTrue(new EqualsBuilder().append(obj1, array2).isEquals()); 
     array1[1] = 7; 
     assertTrue(!new EqualsBuilder().append(obj1, obj2).isEquals()); 
 }
@Test
public void testBooleanArray7629() { 
     boolean[] obj1 = new boolean[2]; 
     obj1[0] = true; 
     obj1[1] = false; 
     boolean[] obj2 = new boolean[2]; 
     obj2[0] = true; 
     obj2[1] = false; 
     assertTrue(new EqualsBuilder().append(obj1, obj1).isEquals()); 
     assertTrue(new EqualsBuilder().append(obj1, obj2).isEquals()); 
     obj1[1] = true; 
     assertTrue(!new EqualsBuilder().append(obj1, obj2).isEquals()); 
     obj2 = null; 
     assertTrue(!new EqualsBuilder().append(obj1, obj2).isEquals()); 
     obj1 = null; 
     assertTrue(new EqualsBuilder().append(obj1, obj2).isEquals()); 
 }
@Test
public void testMultiLongArray7681() { 
     final long[][] array1 = new long[2][2]; 
     final long[][] array2 = new long[2][2]; 
     for (int i = 0; i < array1.length; ++i) { 
         for (int j = 0; j < array1[0].length; j++) { 
             array1[i][j] = (i + 1) * (j + 1); 
             array2[i][j] = (i + 1) * (j + 1); 
         } 
     } 
     assertTrue(new EqualsBuilder().append(array1, array1).isEquals()); 
     assertTrue(new EqualsBuilder().append(array1, array2).isEquals()); 
     array1[1][1] = 0; 
     assertTrue(!new EqualsBuilder().append(array1, array2).isEquals()); 
 }
@Test
public void testByteArray7861() { 
     byte[] obj1 = new byte[2]; 
     obj1[0] = 5; 
     obj1[1] = 6; 
     byte[] obj2 = new byte[2]; 
     obj2[0] = 5; 
     obj2[1] = 6; 
     assertTrue(new EqualsBuilder().append(obj1, obj1).isEquals()); 
     assertTrue(new EqualsBuilder().append(obj1, obj2).isEquals()); 
     obj1[1] = 7; 
     assertTrue(!new EqualsBuilder().append(obj1, obj2).isEquals()); 
     obj2 = null; 
     assertTrue(!new EqualsBuilder().append(obj1, obj2).isEquals()); 
     obj1 = null; 
     assertTrue(new EqualsBuilder().append(obj1, obj2).isEquals()); 
 }
@Test
public void testCharArrayHiddenByObject7912() { 
     final char[] array1 = new char[2]; 
     array1[0] = 5; 
     array1[1] = 6; 
     final char[] array2 = new char[2]; 
     array2[0] = 5; 
     array2[1] = 6; 
     final Object obj1 = array1; 
     final Object obj2 = array2; 
     assertTrue(new EqualsBuilder().append(obj1, obj1).isEquals()); 
     assertTrue(new EqualsBuilder().append(obj1, array1).isEquals()); 
     assertTrue(new EqualsBuilder().append(obj1, obj2).isEquals()); 
     assertTrue(new EqualsBuilder().append(obj1, array2).isEquals()); 
     array1[1] = 7; 
     assertTrue(!new EqualsBuilder().append(obj1, obj2).isEquals()); 
 }
@Test
public void testMultiDoubleArray7949() { 
     final double[][] array1 = new double[2][2]; 
     final double[][] array2 = new double[2][2]; 
     for (int i = 0; i < array1.length; ++i) { 
         for (int j = 0; j < array1[0].length; j++) { 
             array1[i][j] = (i + 1) * (j + 1); 
             array2[i][j] = (i + 1) * (j + 1); 
         } 
     } 
     assertTrue(new EqualsBuilder().append(array1, array1).isEquals()); 
     assertTrue(new EqualsBuilder().append(array1, array2).isEquals()); 
     array1[1][1] = 0; 
     assertTrue(!new EqualsBuilder().append(array1, array2).isEquals()); 
 }
@Test
public void testMultiLongArray8051() { 
     final long[][] array1 = new long[2][2]; 
     final long[][] array2 = new long[2][2]; 
     for (int i = 0; i < array1.length; ++i) { 
         for (int j = 0; j < array1[0].length; j++) { 
             array1[i][j] = (i + 1) * (j + 1); 
             array2[i][j] = (i + 1) * (j + 1); 
         } 
     } 
     assertTrue(new EqualsBuilder().append(array1, array1).isEquals()); 
     assertTrue(new EqualsBuilder().append(array1, array2).isEquals()); 
     array1[1][1] = 0; 
     assertTrue(!new EqualsBuilder().append(array1, array2).isEquals()); 
 }
@Test
public void testBooleanArray8054() { 
     boolean[] obj1 = new boolean[2]; 
     obj1[0] = true; 
     obj1[1] = false; 
     boolean[] obj2 = new boolean[2]; 
     obj2[0] = true; 
     obj2[1] = false; 
     assertTrue(new EqualsBuilder().append(obj1, obj1).isEquals()); 
     assertTrue(new EqualsBuilder().append(obj1, obj2).isEquals()); 
     obj1[1] = true; 
     assertTrue(!new EqualsBuilder().append(obj1, obj2).isEquals()); 
     obj2 = null; 
     assertTrue(!new EqualsBuilder().append(obj1, obj2).isEquals()); 
     obj1 = null; 
     assertTrue(new EqualsBuilder().append(obj1, obj2).isEquals()); 
 }
@Test
public void testBooleanArray8096() { 
     boolean[] obj1 = new boolean[2]; 
     obj1[0] = true; 
     obj1[1] = false; 
     boolean[] obj2 = new boolean[2]; 
     obj2[0] = true; 
     obj2[1] = false; 
     assertTrue(new EqualsBuilder().append(obj1, obj1).isEquals()); 
     assertTrue(new EqualsBuilder().append(obj1, obj2).isEquals()); 
     obj1[1] = true; 
     assertTrue(!new EqualsBuilder().append(obj1, obj2).isEquals()); 
     obj2 = null; 
     assertTrue(!new EqualsBuilder().append(obj1, obj2).isEquals()); 
     obj1 = null; 
     assertTrue(new EqualsBuilder().append(obj1, obj2).isEquals()); 
 }
@Test
public void testShortArray8100() { 
     short[] obj1 = new short[2]; 
     obj1[0] = 5; 
     obj1[1] = 6; 
     short[] obj2 = new short[2]; 
     obj2[0] = 5; 
     obj2[1] = 6; 
     assertTrue(new EqualsBuilder().append(obj1, obj1).isEquals()); 
     assertTrue(new EqualsBuilder().append(obj1, obj2).isEquals()); 
     obj1[1] = 7; 
     assertTrue(!new EqualsBuilder().append(obj1, obj2).isEquals()); 
     obj2 = null; 
     assertTrue(!new EqualsBuilder().append(obj1, obj2).isEquals()); 
     obj1 = null; 
     assertTrue(new EqualsBuilder().append(obj1, obj2).isEquals()); 
 }
@Test
public void testBooleanArray8161() { 
     boolean[] obj1 = new boolean[2]; 
     obj1[0] = true; 
     obj1[1] = false; 
     boolean[] obj2 = new boolean[2]; 
     obj2[0] = true; 
     obj2[1] = false; 
     assertTrue(new EqualsBuilder().append(obj1, obj1).isEquals()); 
     assertTrue(new EqualsBuilder().append(obj1, obj2).isEquals()); 
     obj1[1] = true; 
     assertTrue(!new EqualsBuilder().append(obj1, obj2).isEquals()); 
     obj2 = null; 
     assertTrue(!new EqualsBuilder().append(obj1, obj2).isEquals()); 
     obj1 = null; 
     assertTrue(new EqualsBuilder().append(obj1, obj2).isEquals()); 
 }
@Test
public void testObjectArrayHiddenByObject8395() { 
     final TestObject[] array1 = new TestObject[2]; 
     array1[0] = new TestObject(4); 
     array1[1] = new TestObject(5); 
     final TestObject[] array2 = new TestObject[2]; 
     array2[0] = new TestObject(4); 
     array2[1] = new TestObject(5); 
     final Object obj1 = array1; 
     final Object obj2 = array2; 
     assertTrue(new EqualsBuilder().append(obj1, obj1).isEquals()); 
     assertTrue(new EqualsBuilder().append(obj1, array1).isEquals()); 
     assertTrue(new EqualsBuilder().append(obj1, obj2).isEquals()); 
     assertTrue(new EqualsBuilder().append(obj1, array2).isEquals()); 
     array1[1].setA(6); 
     assertTrue(!new EqualsBuilder().append(obj1, obj2).isEquals()); 
 }
@Test
public void testByteArray8436() { 
     byte[] obj1 = new byte[2]; 
     obj1[0] = 5; 
     obj1[1] = 6; 
     byte[] obj2 = new byte[2]; 
     obj2[0] = 5; 
     obj2[1] = 6; 
     assertTrue(new EqualsBuilder().append(obj1, obj1).isEquals()); 
     assertTrue(new EqualsBuilder().append(obj1, obj2).isEquals()); 
     obj1[1] = 7; 
     assertTrue(!new EqualsBuilder().append(obj1, obj2).isEquals()); 
     obj2 = null; 
     assertTrue(!new EqualsBuilder().append(obj1, obj2).isEquals()); 
     obj1 = null; 
     assertTrue(new EqualsBuilder().append(obj1, obj2).isEquals()); 
 }
@Test
public void testBooleanArray8670() { 
     boolean[] obj1 = new boolean[2]; 
     obj1[0] = true; 
     obj1[1] = false; 
     boolean[] obj2 = new boolean[2]; 
     obj2[0] = true; 
     obj2[1] = false; 
     assertTrue(new EqualsBuilder().append(obj1, obj1).isEquals()); 
     assertTrue(new EqualsBuilder().append(obj1, obj2).isEquals()); 
     obj1[1] = true; 
     assertTrue(!new EqualsBuilder().append(obj1, obj2).isEquals()); 
     obj2 = null; 
     assertTrue(!new EqualsBuilder().append(obj1, obj2).isEquals()); 
     obj1 = null; 
     assertTrue(new EqualsBuilder().append(obj1, obj2).isEquals()); 
 }
@Test
public void testObjectBuild8846() { 
     final TestObject o1 = new TestObject(4); 
     final TestObject o2 = new TestObject(5); 
     assertEquals(Boolean.TRUE, new EqualsBuilder().append(o1, o1).build()); 
     assertEquals(Boolean.FALSE, new EqualsBuilder().append(o1, o2).build()); 
     o2.setA(4); 
     assertEquals(Boolean.TRUE, new EqualsBuilder().append(o1, o2).build()); 
     assertEquals(Boolean.FALSE, new EqualsBuilder().append(o1, this).build()); 
     assertEquals(Boolean.FALSE, new EqualsBuilder().append(o1, null).build()); 
     assertEquals(Boolean.FALSE, new EqualsBuilder().append(null, o2).build()); 
     assertEquals(Boolean.TRUE, new EqualsBuilder().append((Object) null, (Object) null).build()); 
 }
@Test
public void testCharArrayHiddenByObject8934() { 
     final char[] array1 = new char[2]; 
     array1[0] = 5; 
     array1[1] = 6; 
     final char[] array2 = new char[2]; 
     array2[0] = 5; 
     array2[1] = 6; 
     final Object obj1 = array1; 
     final Object obj2 = array2; 
     assertTrue(new EqualsBuilder().append(obj1, obj1).isEquals()); 
     assertTrue(new EqualsBuilder().append(obj1, array1).isEquals()); 
     assertTrue(new EqualsBuilder().append(obj1, obj2).isEquals()); 
     assertTrue(new EqualsBuilder().append(obj1, array2).isEquals()); 
     array1[1] = 7; 
     assertTrue(!new EqualsBuilder().append(obj1, obj2).isEquals()); 
 }
@Test
public void testBooleanArrayHiddenByObject8935() { 
     final boolean[] array1 = new boolean[2]; 
     array1[0] = true; 
     array1[1] = false; 
     final boolean[] array2 = new boolean[2]; 
     array2[0] = true; 
     array2[1] = false; 
     final Object obj1 = array1; 
     final Object obj2 = array2; 
     assertTrue(new EqualsBuilder().append(obj1, obj1).isEquals()); 
     assertTrue(new EqualsBuilder().append(obj1, array1).isEquals()); 
     assertTrue(new EqualsBuilder().append(obj1, obj2).isEquals()); 
     assertTrue(new EqualsBuilder().append(obj1, array2).isEquals()); 
     array1[1] = true; 
     assertTrue(!new EqualsBuilder().append(obj1, obj2).isEquals()); 
 }
@Test
public void testFloatArray9010() { 
     float[] obj1 = new float[2]; 
     obj1[0] = 5; 
     obj1[1] = 6; 
     float[] obj2 = new float[2]; 
     obj2[0] = 5; 
     obj2[1] = 6; 
     assertTrue(new EqualsBuilder().append(obj1, obj1).isEquals()); 
     assertTrue(new EqualsBuilder().append(obj1, obj2).isEquals()); 
     obj1[1] = 7; 
     assertTrue(!new EqualsBuilder().append(obj1, obj2).isEquals()); 
     obj2 = null; 
     assertTrue(!new EqualsBuilder().append(obj1, obj2).isEquals()); 
     obj1 = null; 
     assertTrue(new EqualsBuilder().append(obj1, obj2).isEquals()); 
 }
@Test
public void testMultiLongArray9087() { 
     final long[][] array1 = new long[2][2]; 
     final long[][] array2 = new long[2][2]; 
     for (int i = 0; i < array1.length; ++i) { 
         for (int j = 0; j < array1[0].length; j++) { 
             array1[i][j] = (i + 1) * (j + 1); 
             array2[i][j] = (i + 1) * (j + 1); 
         } 
     } 
     assertTrue(new EqualsBuilder().append(array1, array1).isEquals()); 
     assertTrue(new EqualsBuilder().append(array1, array2).isEquals()); 
     array1[1][1] = 0; 
     assertTrue(!new EqualsBuilder().append(array1, array2).isEquals()); 
 }
@Test
public void testMultiDoubleArray9113() { 
     final double[][] array1 = new double[2][2]; 
     final double[][] array2 = new double[2][2]; 
     for (int i = 0; i < array1.length; ++i) { 
         for (int j = 0; j < array1[0].length; j++) { 
             array1[i][j] = (i + 1) * (j + 1); 
             array2[i][j] = (i + 1) * (j + 1); 
         } 
     } 
     assertTrue(new EqualsBuilder().append(array1, array1).isEquals()); 
     assertTrue(new EqualsBuilder().append(array1, array2).isEquals()); 
     array1[1][1] = 0; 
     assertTrue(!new EqualsBuilder().append(array1, array2).isEquals()); 
 }
@Test
public void testFloatArray9120() { 
     float[] obj1 = new float[2]; 
     obj1[0] = 5; 
     obj1[1] = 6; 
     float[] obj2 = new float[2]; 
     obj2[0] = 5; 
     obj2[1] = 6; 
     assertTrue(new EqualsBuilder().append(obj1, obj1).isEquals()); 
     assertTrue(new EqualsBuilder().append(obj1, obj2).isEquals()); 
     obj1[1] = 7; 
     assertTrue(!new EqualsBuilder().append(obj1, obj2).isEquals()); 
     obj2 = null; 
     assertTrue(!new EqualsBuilder().append(obj1, obj2).isEquals()); 
     obj1 = null; 
     assertTrue(new EqualsBuilder().append(obj1, obj2).isEquals()); 
 }
@Test
public void testBooleanArray9190() { 
     boolean[] obj1 = new boolean[2]; 
     obj1[0] = true; 
     obj1[1] = false; 
     boolean[] obj2 = new boolean[2]; 
     obj2[0] = true; 
     obj2[1] = false; 
     assertTrue(new EqualsBuilder().append(obj1, obj1).isEquals()); 
     assertTrue(new EqualsBuilder().append(obj1, obj2).isEquals()); 
     obj1[1] = true; 
     assertTrue(!new EqualsBuilder().append(obj1, obj2).isEquals()); 
     obj2 = null; 
     assertTrue(!new EqualsBuilder().append(obj1, obj2).isEquals()); 
     obj1 = null; 
     assertTrue(new EqualsBuilder().append(obj1, obj2).isEquals()); 
 }
@Test
public void testFloatArray9467() { 
     float[] obj1 = new float[2]; 
     obj1[0] = 5; 
     obj1[1] = 6; 
     float[] obj2 = new float[2]; 
     obj2[0] = 5; 
     obj2[1] = 6; 
     assertTrue(new EqualsBuilder().append(obj1, obj1).isEquals()); 
     assertTrue(new EqualsBuilder().append(obj1, obj2).isEquals()); 
     obj1[1] = 7; 
     assertTrue(!new EqualsBuilder().append(obj1, obj2).isEquals()); 
     obj2 = null; 
     assertTrue(!new EqualsBuilder().append(obj1, obj2).isEquals()); 
     obj1 = null; 
     assertTrue(new EqualsBuilder().append(obj1, obj2).isEquals()); 
 }
@Test
public void testMultiLongArray9485() { 
     final long[][] array1 = new long[2][2]; 
     final long[][] array2 = new long[2][2]; 
     for (int i = 0; i < array1.length; ++i) { 
         for (int j = 0; j < array1[0].length; j++) { 
             array1[i][j] = (i + 1) * (j + 1); 
             array2[i][j] = (i + 1) * (j + 1); 
         } 
     } 
     assertTrue(new EqualsBuilder().append(array1, array1).isEquals()); 
     assertTrue(new EqualsBuilder().append(array1, array2).isEquals()); 
     array1[1][1] = 0; 
     assertTrue(!new EqualsBuilder().append(array1, array2).isEquals()); 
 }
@Test
public void testCharArrayHiddenByObject9561() { 
     final char[] array1 = new char[2]; 
     array1[0] = 5; 
     array1[1] = 6; 
     final char[] array2 = new char[2]; 
     array2[0] = 5; 
     array2[1] = 6; 
     final Object obj1 = array1; 
     final Object obj2 = array2; 
     assertTrue(new EqualsBuilder().append(obj1, obj1).isEquals()); 
     assertTrue(new EqualsBuilder().append(obj1, array1).isEquals()); 
     assertTrue(new EqualsBuilder().append(obj1, obj2).isEquals()); 
     assertTrue(new EqualsBuilder().append(obj1, array2).isEquals()); 
     array1[1] = 7; 
     assertTrue(!new EqualsBuilder().append(obj1, obj2).isEquals()); 
 }
    
    
    

    private void testReflectionHierarchyEquals(final boolean testTransients) {
        final TestObject to1 = new TestObject(4);
        final TestObject to1Bis = new TestObject(4);
        final TestObject to1Ter = new TestObject(4);
        final TestObject to2 = new TestObject(5);
        final TestEmptySubObject teso = new TestEmptySubObject(4);
        final TestTSubObject ttso = new TestTSubObject(4, 1);
        final TestTTSubObject tttso = new TestTTSubObject(4, 1, 2);
        final TestTTLeafObject ttlo = new TestTTLeafObject(4, 1, 2, 3);
        final TestSubObject tso1 = new TestSubObject(1, 4);
        final TestSubObject tso1bis = new TestSubObject(1, 4);
        final TestSubObject tso1ter = new TestSubObject(1, 4);
        final TestSubObject tso2 = new TestSubObject(2, 5);

        testReflectionEqualsEquivalenceRelationship(to1, to1Bis, to1Ter, to2, new TestObject(), testTransients);
        testReflectionEqualsEquivalenceRelationship(tso1, tso1bis, tso1ter, tso2, new TestSubObject(), testTransients);

        // More sanity checks:

        // same values
        assertTrue(EqualsBuilder.reflectionEquals(ttlo, ttlo, testTransients));
        assertTrue(EqualsBuilder.reflectionEquals(new TestSubObject(1, 10), new TestSubObject(1, 10), testTransients));
        // same super values, diff sub values
        assertTrue(!EqualsBuilder.reflectionEquals(new TestSubObject(1, 10), new TestSubObject(1, 11), testTransients));
        assertTrue(!EqualsBuilder.reflectionEquals(new TestSubObject(1, 11), new TestSubObject(1, 10), testTransients));
        // diff super values, same sub values
        assertTrue(!EqualsBuilder.reflectionEquals(new TestSubObject(0, 10), new TestSubObject(1, 10), testTransients));
        assertTrue(!EqualsBuilder.reflectionEquals(new TestSubObject(1, 10), new TestSubObject(0, 10), testTransients));

        // mix super and sub types: equals
        assertTrue(EqualsBuilder.reflectionEquals(to1, teso, testTransients));
        assertTrue(EqualsBuilder.reflectionEquals(teso, to1, testTransients));

        assertTrue(EqualsBuilder.reflectionEquals(to1, ttso, false)); // Force testTransients = false for this assert
        assertTrue(EqualsBuilder.reflectionEquals(ttso, to1, false)); // Force testTransients = false for this assert

        assertTrue(EqualsBuilder.reflectionEquals(to1, tttso, false)); // Force testTransients = false for this assert
        assertTrue(EqualsBuilder.reflectionEquals(tttso, to1, false)); // Force testTransients = false for this assert

        assertTrue(EqualsBuilder.reflectionEquals(ttso, tttso, false)); // Force testTransients = false for this assert
        assertTrue(EqualsBuilder.reflectionEquals(tttso, ttso, false)); // Force testTransients = false for this assert

        // mix super and sub types: NOT equals
        assertTrue(!EqualsBuilder.reflectionEquals(new TestObject(0), new TestEmptySubObject(1), testTransients));
        assertTrue(!EqualsBuilder.reflectionEquals(new TestEmptySubObject(1), new TestObject(0), testTransients));

        assertTrue(!EqualsBuilder.reflectionEquals(new TestObject(0), new TestTSubObject(1, 1), testTransients));
        assertTrue(!EqualsBuilder.reflectionEquals(new TestTSubObject(1, 1), new TestObject(0), testTransients));

        assertTrue(!EqualsBuilder.reflectionEquals(new TestObject(1), new TestSubObject(0, 10), testTransients));
        assertTrue(!EqualsBuilder.reflectionEquals(new TestSubObject(0, 10), new TestObject(1), testTransients));

        assertTrue(!EqualsBuilder.reflectionEquals(to1, ttlo));
        assertTrue(!EqualsBuilder.reflectionEquals(tso1, this));
    }

    /**
     * Equivalence relationship tests inspired by "Effective Java":
     * <ul>
     * <li>reflection</li>
     * <li>symmetry</li>
     * <li>transitive</li>
     * <li>consistency</li>
     * <li>non-null reference</li>
     * </ul>
     * @param to a TestObject
     * @param toBis a TestObject, equal to to and toTer
     * @param toTer Left hand side, equal to to and toBis
     * @param to2 a different TestObject
     * @param oToChange a TestObject that will be changed
     * @param testTransients whether to test transient instance variables 
     */
    private void testReflectionEqualsEquivalenceRelationship(
        final TestObject to,
        final TestObject toBis,
        final TestObject toTer,
        final TestObject to2,
        final TestObject oToChange,
        final boolean testTransients) {

        // reflection test
        assertTrue(EqualsBuilder.reflectionEquals(to, to, testTransients));
        assertTrue(EqualsBuilder.reflectionEquals(to2, to2, testTransients));

        // symmetry test
        assertTrue(EqualsBuilder.reflectionEquals(to, toBis, testTransients) && EqualsBuilder.reflectionEquals(toBis, to, testTransients));

        // transitive test
        assertTrue(
            EqualsBuilder.reflectionEquals(to, toBis, testTransients)
                && EqualsBuilder.reflectionEquals(toBis, toTer, testTransients)
                && EqualsBuilder.reflectionEquals(to, toTer, testTransients));

        // consistency test
        oToChange.setA(to.getA());
        if (oToChange instanceof TestSubObject) {
            ((TestSubObject) oToChange).setB(((TestSubObject) to).getB());
        }
        assertTrue(EqualsBuilder.reflectionEquals(oToChange, to, testTransients));
        assertTrue(EqualsBuilder.reflectionEquals(oToChange, to, testTransients));
        oToChange.setA(to.getA() + 1);
        if (oToChange instanceof TestSubObject) {
            ((TestSubObject) oToChange).setB(((TestSubObject) to).getB() + 1);
        }
        assertTrue(!EqualsBuilder.reflectionEquals(oToChange, to, testTransients));
        assertTrue(!EqualsBuilder.reflectionEquals(oToChange, to, testTransients));

        // non-null reference test
        assertTrue(!EqualsBuilder.reflectionEquals(to, null, testTransients));
        assertTrue(!EqualsBuilder.reflectionEquals(to2, null, testTransients));
        assertTrue(!EqualsBuilder.reflectionEquals(null, to, testTransients));
        assertTrue(!EqualsBuilder.reflectionEquals(null, to2, testTransients));
        assertTrue(EqualsBuilder.reflectionEquals((Object) null, (Object) null, testTransients));
    }

    

    
    
    

    

    

    

    

    

    

    

    

    
    
    

    

    

    

    

    

    

    

    

    

    

    

    

    

    

    

    

    

    

    

    

    

    

    

    

    

    

    

    
    
    public static class TestACanEqualB {
        private final int a;

        public TestACanEqualB(final int a) {
            this.a = a;
        }

        @Override
        public boolean equals(final Object o) {
            if (o == this) {
                return true;
            }
            if (o instanceof TestACanEqualB) {
                return this.a == ((TestACanEqualB) o).getA();
            }
            if (o instanceof TestBCanEqualA) {
                return this.a == ((TestBCanEqualA) o).getB();
            }
            return false;
        }

        @Override
        public int hashCode() {
            return a;
        }

        public int getA() {
            return this.a;
        }
    }

    public static class TestBCanEqualA {
        private final int b;

        public TestBCanEqualA(final int b) {
            this.b = b;
        }

        @Override
        public boolean equals(final Object o) {
            if (o == this) {
                return true;
            }
            if (o instanceof TestACanEqualB) {
                return this.b == ((TestACanEqualB) o).getA();
            }
            if (o instanceof TestBCanEqualA) {
                return this.b == ((TestBCanEqualA) o).getB();
            }
            return false;
        }

        @Override
        public int hashCode() {
            return b;
        }

        public int getB() {
            return this.b;
        }
    }
    
    /**
     * Tests two instances of classes that can be equal and that are not "related". The two classes are not subclasses
     * of each other and do not share a parent aside from Object.
     * See http://issues.apache.org/bugzilla/show_bug.cgi?id=33069
     */
    
    
    /**
     * Test from http://issues.apache.org/bugzilla/show_bug.cgi?id=33067
     */
    

    

    static class TestObjectWithMultipleFields {
        @SuppressWarnings("unused")
        private final TestObject one;
        @SuppressWarnings("unused")
        private final TestObject two;
        @SuppressWarnings("unused")
        private final TestObject three;

        public TestObjectWithMultipleFields(final int one, final int two, final int three) {
            this.one = new TestObject(one);
            this.two = new TestObject(two);
            this.three = new TestObject(three);
        }
    }
    
    /**
     * Test cyclical object references which cause a StackOverflowException if
     * not handled properly. s. LANG-606
     */
    

    static class TestObjectReference {
        @SuppressWarnings("unused")
        private TestObjectReference reference;
        @SuppressWarnings("unused")
        private final TestObject one;

        public TestObjectReference(final int one) {
            this.one = new TestObject(one);
        }

        public void setObjectReference(final TestObjectReference reference) {
            this.reference = reference;
        }

        @Override
        public boolean equals(final Object obj) {
            return EqualsBuilder.reflectionEquals(this, obj);
        }
    }
}

