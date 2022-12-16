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
import static org.junit.Assert.assertNull;
import org.junit.Test;

/**
 * Unit tests {@link org.apache.commons.lang3.builder.HashCodeBuilder}.
 * 
 * @version $Id$
 */
public class HashCodeBuilderTest {

    /**
     * A reflection test fixture.
     */
    static class ReflectionTestCycleA {
        ReflectionTestCycleB b;

        @Override
        public int hashCode() {
            return HashCodeBuilder.reflectionHashCode(this);
        }
    }

    /**
     * A reflection test fixture.
     */
    static class ReflectionTestCycleB {
        ReflectionTestCycleA a;

        @Override
        public int hashCode() {
            return HashCodeBuilder.reflectionHashCode(this);
        }
    }

    // -----------------------------------------------------------------------

    

    

    static class TestObject {
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
    }

    static class TestSubObject extends TestObject {
        private int b;

        @SuppressWarnings("unused")
        transient private int t;

        public TestSubObject() {
            super(0);
        }

        public TestSubObject(final int a, final int b, final int t) {
            super(a);
            this.b = b;
            this.t = t;
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

        @Override
        public int hashCode() {
            return b*17 + super.hashCode();
        }

    }

    

    

    

@Test
public void testShortArray3() { 
     assertEquals(17 * 37, new HashCodeBuilder(17, 37).append((short[]) null).toHashCode()); 
     final short[] obj = new short[2]; 
     assertEquals(17 * 37 * 37, new HashCodeBuilder(17, 37).append(obj).toHashCode()); 
     obj[0] = (short) 5; 
     assertEquals((17 * 37 + 5) * 37, new HashCodeBuilder(17, 37).append(obj).toHashCode()); 
     obj[1] = (short) 6; 
     assertEquals((17 * 37 + 5) * 37 + 6, new HashCodeBuilder(17, 37).append(obj).toHashCode()); 
 }
@Test
public void testLongArray25() { 
     assertEquals(17 * 37, new HashCodeBuilder(17, 37).append((long[]) null).toHashCode()); 
     final long[] obj = new long[2]; 
     assertEquals(17 * 37 * 37, new HashCodeBuilder(17, 37).append(obj).toHashCode()); 
     obj[0] = 5L; 
     final int h1 = (int) (5L ^ 5L >> 32); 
     assertEquals((17 * 37 + h1) * 37, new HashCodeBuilder(17, 37).append(obj).toHashCode()); 
     obj[1] = 6L; 
     final int h2 = (int) (6L ^ 6L >> 32); 
     assertEquals((17 * 37 + h1) * 37 + h2, new HashCodeBuilder(17, 37).append(obj).toHashCode()); 
 }
@Test
public void testIntArray113() { 
     assertEquals(17 * 37, new HashCodeBuilder(17, 37).append((int[]) null).toHashCode()); 
     final int[] obj = new int[2]; 
     assertEquals(17 * 37 * 37, new HashCodeBuilder(17, 37).append(obj).toHashCode()); 
     obj[0] = 5; 
     assertEquals((17 * 37 + 5) * 37, new HashCodeBuilder(17, 37).append(obj).toHashCode()); 
     obj[1] = 6; 
     assertEquals((17 * 37 + 5) * 37 + 6, new HashCodeBuilder(17, 37).append(obj).toHashCode()); 
 }
@Test
public void testCharArrayAsObject262() { 
     final char[] obj = new char[2]; 
     assertEquals(17 * 37 * 37, new HashCodeBuilder(17, 37).append((Object) obj).toHashCode()); 
     obj[0] = (char) 5; 
     assertEquals((17 * 37 + 5) * 37, new HashCodeBuilder(17, 37).append((Object) obj).toHashCode()); 
     obj[1] = (char) 6; 
     assertEquals((17 * 37 + 5) * 37 + 6, new HashCodeBuilder(17, 37).append((Object) obj).toHashCode()); 
 }
@Test
@SuppressWarnings("cast") 
 public void testFloat400() { 
     assertEquals(17 * 37, new HashCodeBuilder(17, 37).append((float) 0f).toHashCode()); 
     final float f = 1234.89f; 
     final int i = Float.floatToIntBits(f); 
     assertEquals(17 * 37 + i, new HashCodeBuilder(17, 37).append(f).toHashCode()); 
 }
@Test(expected = IllegalArgumentException.class) 
 public void testReflectionHashCodeEx3442() { 
     HashCodeBuilder.reflectionHashCode(13, 19, null, true); 
 }
@Test
public void testBooleanArray456() { 
     assertEquals(17 * 37, new HashCodeBuilder(17, 37).append((boolean[]) null).toHashCode()); 
     final boolean[] obj = new boolean[2]; 
     assertEquals((17 * 37 + 1) * 37 + 1, new HashCodeBuilder(17, 37).append(obj).toHashCode()); 
     obj[0] = true; 
     assertEquals((17 * 37 + 0) * 37 + 1, new HashCodeBuilder(17, 37).append(obj).toHashCode()); 
     obj[1] = false; 
     assertEquals((17 * 37 + 0) * 37 + 1, new HashCodeBuilder(17, 37).append(obj).toHashCode()); 
 }
@Test
public void testDoubleArrayAsObject463() { 
     final double[] obj = new double[2]; 
     assertEquals(17 * 37 * 37, new HashCodeBuilder(17, 37).append((Object) obj).toHashCode()); 
     obj[0] = 5.4d; 
     final long l1 = Double.doubleToLongBits(5.4d); 
     final int h1 = (int) (l1 ^ l1 >> 32); 
     assertEquals((17 * 37 + h1) * 37, new HashCodeBuilder(17, 37).append((Object) obj).toHashCode()); 
     obj[1] = 6.3d; 
     final long l2 = Double.doubleToLongBits(6.3d); 
     final int h2 = (int) (l2 ^ l2 >> 32); 
     assertEquals((17 * 37 + h1) * 37 + h2, new HashCodeBuilder(17, 37).append((Object) obj).toHashCode()); 
 }
@Test
public void testBooleanMultiArray503() { 
     final boolean[][] obj = new boolean[2][]; 
     assertEquals(17 * 37 * 37, new HashCodeBuilder(17, 37).append(obj).toHashCode()); 
     obj[0] = new boolean[0]; 
     assertEquals(17 * 37, new HashCodeBuilder(17, 37).append(obj).toHashCode()); 
     obj[0] = new boolean[1]; 
     assertEquals((17 * 37 + 1) * 37, new HashCodeBuilder(17, 37).append(obj).toHashCode()); 
     obj[0] = new boolean[2]; 
     assertEquals(((17 * 37 + 1) * 37 + 1) * 37, new HashCodeBuilder(17, 37).append(obj).toHashCode()); 
     obj[0][0] = true; 
     assertEquals(((17 * 37 + 0) * 37 + 1) * 37, new HashCodeBuilder(17, 37).append(obj).toHashCode()); 
     obj[1] = new boolean[1]; 
     assertEquals(((17 * 37 + 0) * 37 + 1) * 37 + 1, new HashCodeBuilder(17, 37).append(obj).toHashCode()); 
 }
@Test
public void testByteArray590() { 
     assertEquals(17 * 37, new HashCodeBuilder(17, 37).append((byte[]) null).toHashCode()); 
     final byte[] obj = new byte[2]; 
     assertEquals(17 * 37 * 37, new HashCodeBuilder(17, 37).append(obj).toHashCode()); 
     obj[0] = (byte) 5; 
     assertEquals((17 * 37 + 5) * 37, new HashCodeBuilder(17, 37).append(obj).toHashCode()); 
     obj[1] = (byte) 6; 
     assertEquals((17 * 37 + 5) * 37 + 6, new HashCodeBuilder(17, 37).append(obj).toHashCode()); 
 }
@Test
public void testFloatArray642() { 
     assertEquals(17 * 37, new HashCodeBuilder(17, 37).append((float[]) null).toHashCode()); 
     final float[] obj = new float[2]; 
     assertEquals(17 * 37 * 37, new HashCodeBuilder(17, 37).append(obj).toHashCode()); 
     obj[0] = 5.4f; 
     final int h1 = Float.floatToIntBits(5.4f); 
     assertEquals((17 * 37 + h1) * 37, new HashCodeBuilder(17, 37).append(obj).toHashCode()); 
     obj[1] = 6.3f; 
     final int h2 = Float.floatToIntBits(6.3f); 
     assertEquals((17 * 37 + h1) * 37 + h2, new HashCodeBuilder(17, 37).append(obj).toHashCode()); 
 }
@Test
public void testSuper726() { 
     final Object obj = new Object(); 
     assertEquals(17 * 37 + 19 * 41 + obj.hashCode(), new HashCodeBuilder(17, 37).appendSuper(new HashCodeBuilder(19, 41).append(obj).toHashCode()).toHashCode()); 
 }
@Test
public void testCharArray961() { 
     assertEquals(17 * 37, new HashCodeBuilder(17, 37).append((char[]) null).toHashCode()); 
     final char[] obj = new char[2]; 
     assertEquals(17 * 37 * 37, new HashCodeBuilder(17, 37).append(obj).toHashCode()); 
     obj[0] = (char) 5; 
     assertEquals((17 * 37 + 5) * 37, new HashCodeBuilder(17, 37).append(obj).toHashCode()); 
     obj[1] = (char) 6; 
     assertEquals((17 * 37 + 5) * 37 + 6, new HashCodeBuilder(17, 37).append(obj).toHashCode()); 
 }
@Test
public void testShortArrayAsObject1066() { 
     final short[] obj = new short[2]; 
     assertEquals(17 * 37 * 37, new HashCodeBuilder(17, 37).append((Object) obj).toHashCode()); 
     obj[0] = (short) 5; 
     assertEquals((17 * 37 + 5) * 37, new HashCodeBuilder(17, 37).append((Object) obj).toHashCode()); 
     obj[1] = (short) 6; 
     assertEquals((17 * 37 + 5) * 37 + 6, new HashCodeBuilder(17, 37).append((Object) obj).toHashCode()); 
 }
@Test
public void testToHashCodeEqualsHashCode1114() { 
     final HashCodeBuilder hcb = new HashCodeBuilder(17, 37).append(new Object()).append('a'); 
     assertEquals("hashCode() is no longer returning the same value as toHashCode() - see LANG-520", hcb.toHashCode(), hcb.hashCode()); 
 }
@Test
public void testReflectionObjectCycle1126() { 
     final ReflectionTestCycleA a = new ReflectionTestCycleA(); 
     final ReflectionTestCycleB b = new ReflectionTestCycleB(); 
     a.b = b; 
     b.a = a; 
     a.hashCode(); 
     assertNull(HashCodeBuilder.getRegistry()); 
     b.hashCode(); 
     assertNull(HashCodeBuilder.getRegistry()); 
 }
@Test
public void testDoubleArray1166() { 
     assertEquals(17 * 37, new HashCodeBuilder(17, 37).append((double[]) null).toHashCode()); 
     final double[] obj = new double[2]; 
     assertEquals(17 * 37 * 37, new HashCodeBuilder(17, 37).append(obj).toHashCode()); 
     obj[0] = 5.4d; 
     final long l1 = Double.doubleToLongBits(5.4d); 
     final int h1 = (int) (l1 ^ l1 >> 32); 
     assertEquals((17 * 37 + h1) * 37, new HashCodeBuilder(17, 37).append(obj).toHashCode()); 
     obj[1] = 6.3d; 
     final long l2 = Double.doubleToLongBits(6.3d); 
     final int h2 = (int) (l2 ^ l2 >> 32); 
     assertEquals((17 * 37 + h1) * 37 + h2, new HashCodeBuilder(17, 37).append(obj).toHashCode()); 
 }
@Test
public void testObjectBuild1179() { 
     Object obj = null; 
     assertEquals(17 * 37, new HashCodeBuilder(17, 37).append(obj).build().intValue()); 
     obj = new Object(); 
     assertEquals(17 * 37 + obj.hashCode(), new HashCodeBuilder(17, 37).append(obj).build().intValue()); 
 }
@Test
public void testObjectArrayAsObject1180() { 
     final Object[] obj = new Object[2]; 
     assertEquals(17 * 37 * 37, new HashCodeBuilder(17, 37).append((Object) obj).toHashCode()); 
     obj[0] = new Object(); 
     assertEquals((17 * 37 + obj[0].hashCode()) * 37, new HashCodeBuilder(17, 37).append((Object) obj).toHashCode()); 
     obj[1] = new Object(); 
     assertEquals((17 * 37 + obj[0].hashCode()) * 37 + obj[1].hashCode(), new HashCodeBuilder(17, 37).append((Object) obj).toHashCode()); 
 }
@Test
public void testByteArrayAsObject1242() { 
     final byte[] obj = new byte[2]; 
     assertEquals(17 * 37 * 37, new HashCodeBuilder(17, 37).append((Object) obj).toHashCode()); 
     obj[0] = (byte) 5; 
     assertEquals((17 * 37 + 5) * 37, new HashCodeBuilder(17, 37).append((Object) obj).toHashCode()); 
     obj[1] = (byte) 6; 
     assertEquals((17 * 37 + 5) * 37 + 6, new HashCodeBuilder(17, 37).append((Object) obj).toHashCode()); 
 }
@Test(expected = IllegalArgumentException.class) 
 public void testConstructorEx11278() { 
     new HashCodeBuilder(0, 0); 
 }
@Test(expected = IllegalArgumentException.class) 
 public void testConstructorEx21294() { 
     new HashCodeBuilder(2, 2); 
 }
@Test
public void testLongArrayAsObject1322() { 
     final long[] obj = new long[2]; 
     assertEquals(17 * 37 * 37, new HashCodeBuilder(17, 37).append((Object) obj).toHashCode()); 
     obj[0] = 5L; 
     final int h1 = (int) (5L ^ 5L >> 32); 
     assertEquals((17 * 37 + h1) * 37, new HashCodeBuilder(17, 37).append((Object) obj).toHashCode()); 
     obj[1] = 6L; 
     final int h2 = (int) (6L ^ 6L >> 32); 
     assertEquals((17 * 37 + h1) * 37 + h2, new HashCodeBuilder(17, 37).append((Object) obj).toHashCode()); 
 }
@Test
public void testObjectArray1323() { 
     assertEquals(17 * 37, new HashCodeBuilder(17, 37).append((Object[]) null).toHashCode()); 
     final Object[] obj = new Object[2]; 
     assertEquals(17 * 37 * 37, new HashCodeBuilder(17, 37).append(obj).toHashCode()); 
     obj[0] = new Object(); 
     assertEquals((17 * 37 + obj[0].hashCode()) * 37, new HashCodeBuilder(17, 37).append(obj).toHashCode()); 
     obj[1] = new Object(); 
     assertEquals((17 * 37 + obj[0].hashCode()) * 37 + obj[1].hashCode(), new HashCodeBuilder(17, 37).append(obj).toHashCode()); 
 }
@Test
public void testFloatArrayAsObject1338() { 
     final float[] obj = new float[2]; 
     assertEquals(17 * 37 * 37, new HashCodeBuilder(17, 37).append((Object) obj).toHashCode()); 
     obj[0] = 5.4f; 
     final int h1 = Float.floatToIntBits(5.4f); 
     assertEquals((17 * 37 + h1) * 37, new HashCodeBuilder(17, 37).append((Object) obj).toHashCode()); 
     obj[1] = 6.3f; 
     final int h2 = Float.floatToIntBits(6.3f); 
     assertEquals((17 * 37 + h1) * 37 + h2, new HashCodeBuilder(17, 37).append((Object) obj).toHashCode()); 
 }
@Test
public void testIntArrayAsObject1341() { 
     final int[] obj = new int[2]; 
     assertEquals(17 * 37 * 37, new HashCodeBuilder(17, 37).append((Object) obj).toHashCode()); 
     obj[0] = 5; 
     assertEquals((17 * 37 + 5) * 37, new HashCodeBuilder(17, 37).append((Object) obj).toHashCode()); 
     obj[1] = 6; 
     assertEquals((17 * 37 + 5) * 37 + 6, new HashCodeBuilder(17, 37).append((Object) obj).toHashCode()); 
 }
    

    

    

    

    

    
    
    

    

    

    

    

    

    

    

    

    

    

    

    

    

    

    

    

    

    

    

    

    

    

    

    

    

    

    

    

    static class TestObjectWithMultipleFields {
        @SuppressWarnings("unused")
        private int one = 0;

        @SuppressWarnings("unused")
        private int two = 0;

        @SuppressWarnings("unused")
        private int three = 0;

        public TestObjectWithMultipleFields(final int one, final int two, final int three) {
            this.one = one;
            this.two = two;
            this.three = three;
        }
    }

    /**
     * Test Objects pointing to each other.
     */
    

    /**
     * Ensures LANG-520 remains true
     */
    

}
