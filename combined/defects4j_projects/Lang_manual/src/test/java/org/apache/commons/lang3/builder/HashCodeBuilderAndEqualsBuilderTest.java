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

import org.junit.Test;

/**
 * Tests {@link org.apache.commons.lang3.builder.HashCodeBuilder} and
 * {@link org.apache.commons.lang3.builder.EqualsBuilderTest} to insure that equal
 * objects must have equal hash codes.
 * 
 * @version $Id$
 */
public class HashCodeBuilderAndEqualsBuilderTest {

    //-----------------------------------------------------------------------

    private void testInteger(final boolean testTransients) {
        final Integer i1 = Integer.valueOf(12345);
        final Integer i2 = Integer.valueOf(12345);
        assertEqualsAndHashCodeContract(i1, i2, testTransients);
    }

@Test
public void testObject45() { 
     final TestObject o1 = new TestObject(4); 
     final TestObject o2 = new TestObject(5); 
     assertTrue(EqualsBuilder.isRegistered(o1, o1)); 
     assertTrue(!EqualsBuilder.isRegistered(o1, o2)); 
     o2.setA(4); 
     assertTrue(EqualsBuilder.isRegistered(o1, o2)); 
     assertTrue(!EqualsBuilder.isRegistered(o1, this)); 
     assertTrue(!EqualsBuilder.isRegistered(o1, null)); 
     assertTrue(!EqualsBuilder.isRegistered(null, o2)); 
     assertTrue(EqualsBuilder.isRegistered((Object) null, (Object) null)); 
 }
@Test
public void testReflectionObjectCycle51() { 
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
public void testObjectRegistry57() { 
     final TestObject o1 = new TestObject(4); 
     final TestObject o2 = new TestObject(5); 
     assertTrue(EqualsBuilder.isRegistered(o1, o1)); 
     assertTrue(!EqualsBuilder.isRegistered(o1, o2)); 
     o2.setA(4); 
     assertTrue(EqualsBuilder.isRegistered(o1, o2)); 
     assertTrue(!EqualsBuilder.isRegistered(o1, this)); 
     assertTrue(!EqualsBuilder.isRegistered(o1, null)); 
     assertTrue(!EqualsBuilder.isRegistered(null, o2)); 
     assertTrue(EqualsBuilder.isRegistered((Object) null, (Object) null)); 
 }
@Test
public void testObject264() { 
     final TestObject o1 = new TestObject(4); 
     final TestObject o2 = new TestObject(5); 
     assertTrue(new EqualsBuilder().append(o1, o1).isEquals()); 
     assertTrue(!new EqualsBuilder().append(o1, o2).isEquals()); 
     o2.setA(4); 
     assertTrue(new EqualsBuilder().append(o1, o2).isEquals()); 
     assertTrue(!new EqualsBuilder().append(o1, this).isEquals()); 
     assertTrue(!new EqualsBuilder().append(o1, null).isEquals()); 
     assertTrue(!new EqualsBuilder().append(null, o2).isEquals()); 
     assertTrue(new EqualsBuilder().append((Object) null, (Object) null).isEquals()); 
 }
@Test
public void testReflectionHierarchyEquals265() { 
     testReflectionHierarchyEquals(false); 
     testReflectionHierarchyEquals(true); 
     assertTrue(EqualsBuilder.reflectionEquals(new TestTTLeafObject(1, 2, 3, 4), new TestTTLeafObject(1, 2, 3, 4), true)); 
     assertTrue(EqualsBuilder.reflectionEquals(new TestTTLeafObject(1, 2, 3, 4), new TestTTLeafObject(1, 2, 3, 4), false)); 
     assertTrue(!EqualsBuilder.reflectionEquals(new TestTTLeafObject(1, 0, 0, 4), new TestTTLeafObject(1, 2, 3, 4), true)); 
     assertTrue(!EqualsBuilder.reflectionEquals(new TestTTLeafObject(1, 2, 3, 4), new TestTTLeafObject(1, 2, 3, 0), true)); 
     assertTrue(!EqualsBuilder.reflectionEquals(new TestTTLeafObject(0, 2, 3, 4), new TestTTLeafObject(1, 2, 3, 4), true)); 
     assertTrue(!EqualsBuilder.reflectionEquals(new TestTTLeafObject(0, 2, 3, 4), new TestTTLeafObject(1, 2, 3, 4), true)); 
     assertTrue(!EqualsBuilder.reflectionEquals(new TestTTLeafObject(0, 2, 3, 4), new TestTTLeafObject(1, 2, 3, 4), true)); 
 }
@Test
public void testCyclicalObjectReferences266() { 
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
     assertFalse(x2.equals(x3)); 
     assertNull(EqualsBuilder.getRegistry()); 
 }
@Test
public void testHashCode267() { 
     final TestObject o1 = new TestObject(4); 
     final TestObject o2 = new TestObject(5); 
     assertTrue(new EqualsBuilder().append(o1, o1).isEquals()); 
     assertTrue(!new EqualsBuilder().append(o1, o2).isEquals()); 
     o2.setA(4); 
     assertTrue(new EqualsBuilder().append(o1, o2).isEquals()); 
     assertTrue(!new EqualsBuilder().append(o1, this).isEquals()); 
     assertTrue(!new EqualsBuilder().append(o1, null).isEquals()); 
     assertTrue(!new EqualsBuilder().append(null, o2).isEquals()); 
     assertTrue(new EqualsBuilder().append((Object) null, (Object) null).isEquals()); 
 }
@Test
public void testRemoveMultipleTimes268() { 
     final TestObject o1 = new TestObject(4); 
     final TestObject o2 = new TestObject(5); 
     assertTrue(!EqualsBuilder.getRegistry().contains(o1)); 
     assertTrue(!EqualsBuilder.getRegistry().contains(o2)); 
     o2.setA(4); 
     assertTrue(EqualsBuilder.getRegistry().contains(o1)); 
     assertTrue(!EqualsBuilder.getRegistry().contains(o2)); 
     assertTrue(!EqualsBuilder.getRegistry().contains(o1, this)); 
     assertTrue(!EqualsBuilder.getRegistry().contains(o1, null)); 
     assertTrue(!EqualsBuilder.getRegistry().contains(null, o2)); 
     assertTrue(EqualsBuilder.getRegistry().contains((Object) null, (Object) null)); 
 }
@Test
public void testObject269() { 
     final TestObject o1 = new TestObject(4); 
     final TestObject o2 = new TestObject(5); 
     assertEquals(new Pair<IDKey, IDKey>(o1, o1), EqualsBuilder.getRegisterPair(o1, o1)); 
     assertEquals(new Pair<IDKey, IDKey>(o1, o2), EqualsBuilder.getRegisterPair(o1, o2)); 
     o2.setA(4); 
     assertEquals(new Pair<IDKey, IDKey>(o1, o2), EqualsBuilder.getRegisterPair(o1, o2)); 
     assertEquals(new Pair<IDKey, IDKey>(o1, this), EqualsBuilder.getRegisterPair(o1, this)); 
     assertEquals(new Pair<IDKey, IDKey>(o1, null), EqualsBuilder.getRegisterPair(null, o2)); 
     assertEquals(new Pair<IDKey, IDKey>(), EqualsBuilder.getRegisterPair(o1, o2)); 
     assertEquals(new Pair<IDKey, IDKey>(), EqualsBuilder.getRegistry()); 
 }
@Test
public void testReflectionHierarchyEquals270() { 
     testReflectionHierarchyEquals(false); 
     testReflectionHierarchyEquals(true); 
     assertTrue(EqualsBuilder.reflectionEquals(new TestTTLeafObject(1, 2, 3, 4), new TestTTLeafObject(1, 2, 3, 4), true)); 
     assertTrue(EqualsBuilder.reflectionEquals(new TestTTLeafObject(1, 2, 3, 4), new TestTTLeafObject(1, 2, 3, 4), false)); 
     assertTrue(!EqualsBuilder.reflectionEquals(new TestTTLeafObject(1, 0, 0, 4), new TestTTLeafObject(1, 2, 3, 4), true)); 
     assertTrue(!EqualsBuilder.reflectionEquals(new TestTTLeafObject(1, 2, 3, 4), new TestTTLeafObject(1, 2, 3, 0), true)); 
     assertTrue(!EqualsBuilder.reflectionEquals(new TestTTLeafObject(0, 2, 3, 4), new TestTTLeafObject(1, 2, 3, 4), true)); 
 }
@Test
public void testObjectRegistryRemove271() { 
     final TestObject o1 = new TestObject(4); 
     final TestObject o2 = new TestObject(5); 
     assertTrue(!EqualsBuilder.getRegistry().contains(o1)); 
     assertTrue(!EqualsBuilder.getRegistry().contains(o2)); 
     o2.setA(4); 
     assertTrue(EqualsBuilder.getRegistry().contains(o1)); 
     assertTrue(!EqualsBuilder.getRegistry().contains(o2)); 
     assertTrue(!EqualsBuilder.getRegistry().contains(o1, this)); 
     assertTrue(!EqualsBuilder.getRegistry().contains(o1, null)); 
     assertTrue(!EqualsBuilder.getRegistry().contains(null, o2)); 
     assertTrue(EqualsBuilder.getRegistry().contains((Object) null, (Object) null)); 
 }
@Test
public void testReflectionHierarchyEquals272() { 
     testReflectionHierarchyEquals(false); 
     testReflectionHierarchyEquals(true); 
     assertTrue(EqualsBuilder.reflectionEquals(new TestTTLeafObject(1, 2, 3, 4), new TestTTLeafObject(1, 2, 3, 4), true)); 
     assertTrue(EqualsBuilder.reflectionEquals(new TestTTLeafObject(1, 2, 3, 4), new TestTTLeafObject(1, 2, 3, 4), false)); 
     assertTrue(!EqualsBuilder.reflectionEquals(new TestTTLeafObject(1, 0, 0, 4), new TestTTLeafObject(1, 2, 3, 4), true)); 
     assertTrue(!EqualsBuilder.reflectionEquals(new TestTTLeafObject(1, 2, 3, 4), new TestTTLeafObject(1, 2, 3, 0), true)); 
     assertTrue(!EqualsBuilder.reflectionEquals(new TestTTLeafObject(0, 2, 3, 4), new TestTTLeafObject(1, 2, 3, 4), true)); 
     assertTrue(!EqualsBuilder.reflectionEquals(new TestTTLeafObject(0, 2, 3, 4), new TestTTLeafObject(1, 2, 3, 4), true)); 
 }
@Test
public void testObject273() { 
     final TestObject o1 = new TestObject(4); 
     final TestObject o2 = new TestObject(5); 
     assertTrue(!EqualsBuilder.isRegistered(o1, o1)); 
     assertTrue(!EqualsBuilder.isRegistered(o1, o2)); 
     o2.setA(4); 
     assertTrue(EqualsBuilder.isRegistered(o1, o2)); 
     assertTrue(!EqualsBuilder.isRegistered(o1, this)); 
     assertTrue(!EqualsBuilder.isRegistered(o1, null)); 
     assertTrue(!EqualsBuilder.isRegistered(null, o2)); 
     assertTrue(EqualsBuilder.isRegistered((Object) null, (Object) null)); 
 }
@Test
public void testObject274() { 
     final TestObject o1 = new TestObject(4); 
     final TestObject o2 = new TestObject(5); 
     assertEquals(new Pair<IDKey, IDKey>(o1, o1), EqualsBuilder.getRegisterPair(o1, o1)); 
     assertEquals(new Pair<IDKey, IDKey>(o1, o2), EqualsBuilder.getRegisterPair(o1, o2)); 
     o2.setA(4); 
     assertEquals(new Pair<IDKey, IDKey>(o1, o2), EqualsBuilder.getRegisterPair(o1, o2)); 
     assertEquals(new Pair<IDKey, IDKey>(o1, this), EqualsBuilder.getRegisterPair(o1, this)); 
     assertEquals(new Pair<IDKey, IDKey>(o1, null), EqualsBuilder.getRegisterPair(null, o2)); 
     assertEquals(new Pair<IDKey, IDKey>(), EqualsBuilder.getRegisterPair(o1, o2)); 
     assertEquals(new Pair<IDKey, IDKey>(), EqualsBuilder.getRegisterPair(o1, null)); 
     assertEquals(new Pair<IDKey, IDKey>(), EqualsBuilder.getRegisterPair(o1, o2)); 
     assertEquals(new Pair<IDKey, IDKey>(), EqualsBuilder.getRegisterPair(o1, this)); 
     assertEquals(new Pair<IDKey, IDKey>(), EqualsBuilder.getRegisterPair(o1, null)); 
     assertEquals(new Pair<IDKey, IDKey>(), EqualsBuilder.getRegisterPair(null, o2)); 
     assertEquals(new Pair<IDKey, IDKey>(), EqualsBuilder.getRegisterPair(o1,
@Test
public void testReflectionEquals275() { 
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
public void testBooleanMultiArray299() { 
     final boolean[][] obj = new boolean[2][]; 
     assertEquals(17 * 37 * 37, HashCodeBuilder.getRegistry().add(new IDKey(Boolean.class, (Object) obj).toHashCode()); 
     obj[0] = new boolean[0]; 
     assertEquals(17 * 37, HashCodeBuilder.getRegistry().add(new IDKey(Boolean.class, (Object) obj).toHashCode()); 
     obj[0] = new boolean[1]; 
     assertEquals((17 * 37 + 1) * 37, HashCodeBuilder.getRegistry().add(new IDKey(Boolean.class, (Object) obj).toHashCode()); 
     obj[0] = new boolean[2]; 
     assertEquals(((17 * 37 + 1) * 37 + 1) * 37, HashCodeBuilder.getRegistry().add(new IDKey(Boolean.class, (Object) obj).toHashCode()); 
     obj[0][0] = true; 
     assertEquals(((17 * 37 + 0) * 37 + 1) * 37, HashCodeBuilder.getRegistry().add(new IDKey(Boolean.class, (Object) obj).toHashCode()); 
     obj[1] = new boolean[1]; 
     assertEquals(((17 * 37 + 0) * 37 + 1) * 37 + 1, HashCodeBuilder.getRegistry().add(new IDKey(Boolean.class, (Object) obj).toHashCode()); 
 }
@Test
public void testBooleanMultiArray300() { 
     final boolean[][] obj = new boolean[2][]; 
     assertEquals(17 * 37 * 37, HashCodeBuilder.getRegistry().add(new HashCodeBuilder(17, 37).append(obj).toHashCode()); 
     obj[0] = new boolean[0]; 
     assertEquals(17 * 37, HashCodeBuilder.getRegistry().add(new HashCodeBuilder(17, 37).append(obj).toHashCode()); 
     obj[0] = new boolean[1]; 
     assertEquals((17 * 37 + 1) * 37, HashCodeBuilder.getRegistry().add(new HashCodeBuilder(17, 37).append(obj).toHashCode()); 
     obj[0] = new boolean[2]; 
     assertEquals(((17 * 37 + 1) * 37 + 1) * 37, HashCodeBuilder.getRegistry().add(new HashCodeBuilder(17, 37).append(obj).toHashCode()); 
     obj[0][0] = true; 
     assertEquals(((17 * 37 + 0) * 37 + 1) * 37, HashCodeBuilder.getRegistry().add(new HashCodeBuilder(17, 37).append(obj).toHashCode()); 
     obj[1] = new boolean[1]; 
     assertEquals(((17 * 37 + 0) * 37 + 1) * 37 + 1, HashCodeBuilder.getRegistry().add(new HashCodeBuilder(17, 37).append(obj).toHashCode()); 
 }
@Test
public void testIdentityHashCode301() { 
     final Integer i = Integer.valueOf(6); 
     final IDKey key = new IDKey(i); 
     assertEquals(i, key.hashCode()); 
     assertEquals(i, key.hashCode()); 
     assertEquals(i, key.hashCode()); 
     assertEquals(null, key.hashCode()); 
 }
@Test
public void testBooleanMultiArray302() { 
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
@Test(expected = IllegalArgumentException.class) 
 public void testConstructorEx2303() { 
     new HashCodeBuilder(2, 2); 
 }
@Test
public void testEquals304() { 
     final IDKey key1 = new IDKey(0); 
     final IDKey key2 = new IDKey(1); 
     assertTrue(key1.equals(key2)); 
     assertTrue(key1.equals(new IDKey(0))); 
     assertTrue(key2.equals(new IDKey(1))); 
     assertFalse(key1.equals(new Object())); 
 }
@Test
public void testBooleanMultiArray305() { 
     final boolean[][] obj = new boolean[2][]; 
     assertEquals(17 * 37 * 37, HashCodeBuilder.getRegistry(obj).append(obj).toHashCode()); 
     obj[0] = new boolean[0]; 
     assertEquals(17 * 37, HashCodeBuilder.getRegistry(obj).toHashCode()); 
     obj[0] = new boolean[1]; 
     assertEquals((17 * 37 + 1) * 37, HashCodeBuilder.getRegistry(obj).toHashCode()); 
     obj[0] = new boolean[2]; 
     assertEquals(((17 * 37 + 1) * 37 + 1) * 37, HashCodeBuilder.getRegistry(obj).toHashCode()); 
     obj[0][0] = true; 
     assertEquals(((17 * 37 + 0) * 37 + 1) * 37, HashCodeBuilder.getRegistry(obj).toHashCode()); 
     obj[1] = new boolean[1]; 
     assertEquals(((17 * 37 + 0) * 37 + 1) * 37 + 1, HashCodeBuilder.getRegistry(obj).toHashCode()); 
 }
@Test
public void testIDKey306() { 
     final Integer i = Integer.valueOf(6); 
     final IDKey key = new IDKey(i); 
     assertEquals(i, key.hashCode()); 
     assertEquals(i, key.hashCode()); 
     assertEquals(i, key.hashCode()); 
     assertEquals(null, key.hashCode()); 
 }
@Test
public void testEquals307() { 
     final IDKey key1 = new IDKey(0); 
     final IDKey key2 = new IDKey(1); 
     assertTrue(key1.equals(key2)); 
     assertTrue(key1.equals(new Object())); 
     assertTrue(key2.equals(key2)); 
     assertFalse(key1.equals(null)); 
     assertFalse(key1.equals(Integer.valueOf(1))); 
     assertFalse(key1.equals("abc")); 
 }
@Test(expected = IllegalArgumentException.class) 
 public void testReflectionHashCodeEx3308() { 
     HashCodeBuilder.reflectionHashCode(13, 19, null, true); 
 }
@Test
public void testDoubleArrayAsObject309() { 
     final double[] obj = new double[2]; 
     assertEquals(17 * 37 * 37, HashCodeBuilder.getRegistry().add(new Object()).toHashCode()); 
     obj[0] = 5.4d; 
     final long l1 = Double.doubleToLongBits(5.4d); 
     final int h1 = (int) (l1 ^ l1 >> 32); 
     assertEquals((17 * 37 + h1) * 37, HashCodeBuilder.getRegistry().get(new Object()).toHashCode()); 
     obj[1] = 6.3d; 
     final long l2 = Double.doubleToLongBits(6.3d); 
     final int h2 = (int) (l2 ^ l2 >> 32); 
     assertEquals((17 * 37 + h1) * 37 + h2, HashCodeBuilder.getRegistry().get(new Object()).toHashCode()); 
 }
@Test(expected = IllegalArgumentException.class) 
 public void testConstructorEx1310() { 
     new HashCodeBuilder(0, 0); 
 }
@Test
public void testBooleanMultiArray311() { 
     final boolean[][] obj = new boolean[2][]; 
     assertEquals(17 * 37 * 37, HashCodeBuilder.getRegistry(obj).hashCode()); 
     obj[0] = new boolean[0]; 
     assertEquals(17 * 37, HashCodeBuilder.getRegistry(obj).hashCode()); 
     obj[0] = new boolean[1]; 
     assertEquals((17 * 37 + 1) * 37, HashCodeBuilder.getRegistry(obj).hashCode()); 
     obj[0] = new boolean[2]; 
     assertEquals(((17 * 37 + 1) * 37 + 1) * 37, HashCodeBuilder.getRegistry(obj).hashCode()); 
     obj[0][0] = true; 
     assertEquals(((17 * 37 + 0) * 37 + 1) * 37, HashCodeBuilder.getRegistry(obj).hashCode()); 
     obj[1] = new boolean[1]; 
     assertEquals(((17 * 37 + 0) * 37 + 1) * 37 + 1, HashCodeBuilder.getRegistry(obj).hashCode()); 
 }
@Test
public void testHashCode312() { 
     final IDKey<String> key1 = new IDKey<String>("foo"); 
     final IDKey<String> key2 = new IDKey<String>("foo"); 
     assertEquals(key1.hashCode(), key2.hashCode()); 
     assertFalse(key1.hashCode() == key2.hashCode()); 
     assertTrue(key1.hashCode() != 0); 
 }
@Test
public void testIDKey313() { 
     final Object obj = new Object(); 
     final IDKey key = new IDKey(obj); 
     assertEquals(System.identityHashCode(obj), key.hashCode()); 
     final Integer i = Integer.valueOf(6); 
     final Integer j = Integer.valueOf(7); 
     assertEquals(i, key.hashCode()); 
     assertEquals(j, key.hashCode()); 
     assertEquals(i, key.hashCode()); 
     assertEquals(j, key.hashCode()); 
 }
@Test
public void testHashCode314() { 
     final IDKey<String> key1 = new IDKey<String>("foo"); 
     final IDKey<String> key2 = new IDKey<String>("foo"); 
     assertTrue(key1.hashCode() == key2.hashCode()); 
     key2.setValue("bar"); 
     assertTrue(key1.hashCode() != key2.hashCode()); 
     key2.setValue(null); 
     assertTrue(key1.hashCode() != key2.hashCode()); 
 }
@Test
public void testToHashCodeEqualsHashCode315() { 
     final HashCodeBuilder hcb = new HashCodeBuilder(17, 37).append(new Object()).append('a'); 
     assertEquals("hashCode() is no longer returning the same value as toHashCode() - see LANG-520", hcb.toHashCode(), hcb.hashCode()); 
 }
@Test
public void testHashCode316() { 
     final long[][] array1 = new long[][] { { 2, 5 }, { 4, 5 } }; 
     final long[][] array2 = new long[][] { { 2, 5 }, { 4, 6 } }; 
     assertTrue(ArrayUtils.hashCode(array1) == ArrayUtils.hashCode(array1)); 
     assertFalse(ArrayUtils.hashCode(array1) == ArrayUtils.hashCode(array2)); 
     final Object[] array3 = new Object[] { new String(new char[] { 'A', 'B' }) }; 
     final Object[] array4 = new Object[] { "AB" }; 
     assertTrue(ArrayUtils.hashCode(array3) == ArrayUtils.hashCode(array3)); 
     assertTrue(ArrayUtils.hashCode(array3) == ArrayUtils.hashCode(array4)); 
     final Object[] arrayA = new Object[] { new boolean[] { true, false }, new int[] { 6, 7 } }; 
     final Object[] arrayB = new Object[] { new boolean[] { true, false }, new int[] { 6, 7 } }; 
     assertTrue(ArrayUtils.hashCode(arrayB) == ArrayUtils.hashCode(arrayA)); 
 }
@Test
public void testEquals317() { 
     final IDKey key1 = new IDKey(0); 
     final IDKey key2 = new IDKey(1); 
     assertTrue(key1.equals(key2)); 
     assertTrue(key1.equals(new IDKey(0))); 
     assertTrue(key2.equals(new IDKey(1))); 
     assertFalse(key1.equals(value1)); 
     assertFalse(key1.equals(null)); 
     assertFalse(key1.equals(Integer.valueOf(1))); 
     assertFalse(key1.equals("abc")); 
 }
    

    

    

    

    private void testFixture(final boolean testTransients) {
        assertEqualsAndHashCodeContract(new TestFixture(2, 'c', "Test", (short) 2), new TestFixture(2, 'c', "Test", (short) 2), testTransients);
        assertEqualsAndHashCodeContract(
            new AllTransientFixture(2, 'c', "Test", (short) 2),
            new AllTransientFixture(2, 'c', "Test", (short) 2),
            testTransients);
        assertEqualsAndHashCodeContract(
            new SubTestFixture(2, 'c', "Test", (short) 2, "Same"),
            new SubTestFixture(2, 'c', "Test", (short) 2, "Same"),
            testTransients);
        assertEqualsAndHashCodeContract(
            new SubAllTransientFixture(2, 'c', "Test", (short) 2, "Same"),
            new SubAllTransientFixture(2, 'c', "Test", (short) 2, "Same"),
            testTransients);
    }

    /**
     * Asserts that if <code>lhs</code> equals <code>rhs</code> 
     * then their hash codes MUST be identical.
     * 
     * @param lhs The Left-Hand-Side of the equals test
     * @param rhs The Right-Hand-Side of the equals test
     * @param testTransients wether to test transient fields
     */
    private void assertEqualsAndHashCodeContract(final Object lhs, final Object rhs, final boolean testTransients) {
        if (EqualsBuilder.reflectionEquals(lhs, rhs, testTransients)) {
            // test a couple of times for consistency.
            assertEquals(HashCodeBuilder.reflectionHashCode(lhs, testTransients), HashCodeBuilder.reflectionHashCode(rhs, testTransients));
            assertEquals(HashCodeBuilder.reflectionHashCode(lhs, testTransients), HashCodeBuilder.reflectionHashCode(rhs, testTransients));
            assertEquals(HashCodeBuilder.reflectionHashCode(lhs, testTransients), HashCodeBuilder.reflectionHashCode(rhs, testTransients));
        }
    }

    static class TestFixture {
        int i;
        char c;
        String string;
        short s;

        TestFixture(final int i, final char c, final String string, final short s) {
            this.i = i;
            this.c = c;
            this.string = string;
            this.s = s;
        }
    }

    static class SubTestFixture extends TestFixture {
        transient String tString;

        SubTestFixture(final int i, final char c, final String string, final short s, final String tString) {
            super(i, c, string, s);
            this.tString = tString;
        }
    }

    static class AllTransientFixture {
        transient int i;
        transient char c;
        transient String string;
        transient short s;

        AllTransientFixture(final int i, final char c, final String string, final short s) {
            this.i = i;
            this.c = c;
            this.string = string;
            this.s = s;
        }
    }

    static class SubAllTransientFixture extends AllTransientFixture {
        transient String tString;

        SubAllTransientFixture(final int i, final char c, final String string, final short s, final String tString) {
            super(i, c, string, s);
            this.tString = tString;
        }
    }


}
