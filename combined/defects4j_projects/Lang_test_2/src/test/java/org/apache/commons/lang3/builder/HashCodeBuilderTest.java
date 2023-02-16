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
public void testLongArrayAsObject318() { 
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
public void testByteArrayAsObject319() { 
     final byte[] obj = new byte[2]; 
     assertEquals(17 * 37 * 37, new HashCodeBuilder(17, 37).append((Object) obj).toHashCode()); 
     obj[0] = (byte) 5; 
     assertEquals((17 * 37 + 5) * 37, new HashCodeBuilder(17, 37).append((Object) obj).toHashCode()); 
     obj[1] = (byte) 6; 
     assertEquals((17 * 37 + 5) * 37 + 6, new HashCodeBuilder(17, 37).append((Object) obj).toHashCode()); 
 }
@Test
public void testBooleanMultiArray320() { 
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
