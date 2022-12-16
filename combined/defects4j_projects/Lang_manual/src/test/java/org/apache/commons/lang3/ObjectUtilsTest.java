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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.exception.CloneFailedException;
import org.apache.commons.lang3.mutable.MutableObject;
import org.apache.commons.lang3.text.StrBuilder;
import org.junit.Test;

/**
 * Unit tests {@link org.apache.commons.lang3.ObjectUtils}.
 *
 * @version $Id$
 */
public class ObjectUtilsTest {
    private static final String FOO = "foo";
    private static final String BAR = "bar";

    //-----------------------------------------------------------------------
@Test
public void testHashCode50() { 
     assertEquals(null, ObjectUtils.hashCode(null)); 
     assertEquals(Byte.MIN_VALUE, ObjectUtils.hashCode(Byte.MIN_VALUE)); 
     assertEquals(Byte.MAX_VALUE, ObjectUtils.hashCode(Byte.MAX_VALUE)); 
     try { 
         ObjectUtils.hashCode(0); 
         fail("Expected IllegalArgumentException"); 
     } catch (final IllegalArgumentException iae) { 
     } 
     try { 
         ObjectUtils.hashCode(1); 
         fail("Expected IllegalArgumentException"); 
     } catch (final IllegalArgumentException iae) { 
     } 
     try { 
         ObjectUtils.hashCode(Byte.MIN_VALUE); 
         fail("Expected IllegalArgumentException"); 
     } catch (final IllegalArgumentException iae) { 
     } 
     try { 
         ObjectUtils.hashCode(Byte.MAX_VALUE); 
         fail("Expected IllegalArgumentException"); 
     } catch (final IllegalArgumentException iae) { 
     } 
 }
@Test
public void testJoin_IterableChar131() { 
     assertEquals(null, StringUtils.join((Iterable<?>) null, ',')); 
     assertEquals(TEXT_LIST_CHAR, StringUtils.join(Arrays.asList(ARRAY_LIST), SEPARATOR_CHAR)); 
     assertEquals("", StringUtils.join(Arrays.asList(NULL_ARRAY_LIST), SEPARATOR_CHAR)); 
     assertEquals("", StringUtils.join(Arrays.asList(EMPTY_ARRAY_LIST), SEPARATOR_CHAR)); 
     assertEquals("foo", StringUtils.join(Collections.singleton("foo"), 'x')); 
 }
@Test
public void testNumerator285() { 
     assertEquals(0, ObjectUtils.numerator(0)); 
     assertEquals(1, ObjectUtils.numerator(1)); 
     assertEquals(2, ObjectUtils.numerator(2)); 
     assertEquals(3, ObjectUtils.numerator(3)); 
     assertEquals(4, ObjectUtils.numerator(4)); 
     assertEquals(1, ObjectUtils.numerator(1)); 
     assertEquals(2, ObjectUtils.numerator(2)); 
     assertEquals(3, ObjectUtils.numerator(3)); 
     final Integer i = Integer.valueOf(6); 
     final Integer j = Integer.valueOf(7); 
     assertEquals(i, ObjectUtils.numerator(i)); 
     assertEquals(j, ObjectUtils.numerator(j)); 
     assertEquals(4, ObjectUtils.numerator(i, j)); 
     assertEquals(1, ObjectUtils.numerator(i, j)); 
     assertEquals(2, ObjectUtils.numerator(j, i)); 
     assertEquals(3, ObjectUtils.numerator(i, j)); 
     assertEquals(4, ObjectUtils.numerator(i, j)); 
     assertEquals(1, ObjectUtils.numerator(i, j)); 
     assertEquals(11, ObjectUtils.numerator(i, j)); 
     assertEquals(11, ObjectUtils.numerator(i, j)); 
     assertEquals(12, ObjectUtils.numerator(i, j)); 
     assertEquals(12, ObjectUtils.numerator(i, j)); 
     assertEquals(13, ObjectUtils.numerator(i, j)); 
     assertEquals(13, ObjectUtils.numerator(i, j)); 
     assertEquals(14, ObjectUtils.numerator(i, j)); 
     assertEquals(14, ObjectUtils.numerator(i, j)); 
     assertEquals(15, ObjectUtils.numerator(11, j)); [
@Test
public void testHashCode286() { 
     assertEquals(Boolean.TRUE, ObjectUtils.hashCode(true)); 
     final Boolean b = ObjectUtils.hashCode(true); 
     assertEquals(Boolean.TRUE, b); 
 }
@Test
public void testContainsOnly_boolean287() { 
     assertFalse(ObjectUtils.containsOnly(true)); 
     assertFalse(ObjectUtils.containsOnly(false)); 
     final boolean[] containsOnly = new boolean[] { true, false }; 
     assertTrue(ObjectUtils.containsOnly(containsOnly)); 
     final String[] stringArray1 = new String[] { "a", "b", "c" }; 
     final String[] stringArray2 = new String[] { "1", "2", "3" }; 
     assertTrue(ObjectUtils.containsOnly(stringArray1)); 
     assertTrue(ObjectUtils.containsOnly(stringArray1, "")); 
     assertTrue(ObjectUtils.containsOnly(stringArray1, "a")); 
     assertTrue(ObjectUtils.containsOnly(stringArray1, null)); 
     assertTrue(ObjectUtils.containsOnly((Object) null, (Object) null)); 
     assertFalse(ObjectUtils.containsOnly(null, stringArray2)); 
     assertTrue(ObjectUtils.containsOnly(stringArray2, null)); 
     assertTrue(ObjectUtils.containsOnly(stringArray2, "")); 
     assertFalse(ObjectUtils.containsOnly(stringArray2, "a")); 
     assertTrue(ObjectUtils.containsOnly("a", "b")); 
     assertTrue(ObjectUtils.containsOnly("b", "c")); 
     assertTrue(ObjectUtils.containsOnly("c", "d")); 
     assertFalse(ObjectUtils.containsOnly("d", null)); 
     assertFalse(ObjectUtils.containsOnly("", "e")); 
     assertFalse(ObjectUtils.containsOnly("e", "f")); 
     assertTrue(ObjectUtils.containsOnly("f", "g")); 
     assertTrue(ObjectUtils.containsOnly("g", "h")); 
     assertTrue(ObjectUtils.containsOnly("h", "i")); 
     assertTrue(ObjectUtils.containsOnly("i", "j"));
@Test
public void testAutoboxing288() { 
     assertEquals("autoboxing(null) failed", null, ObjectUtils.autoboxing(null)); 
     assertEquals("autoboxing(abc) failed", "abc", ObjectUtils.autoboxing("abc")); 
     assertEquals("autoboxing(\"\",xyz) failed", "xyz", ObjectUtils.autoboxing("", "xyz")); 
     assertEquals("autoboxing(abc,xyz)", "abcxyz", ObjectUtils.autoboxing("abc", "xyz")); 
     assertEquals("autoboxing(abcxyz,xyz)", "abcxyz", ObjectUtils.autoboxing("abcxyz", "xyz")); 
     assertEquals("autoboxing(aXYZ,xyz)", "aXYZxyz", ObjectUtils.autoboxing("aXYZ", "xyz")); 
     assertEquals("autoboxing(null,null,null)", null, ObjectUtils.autoboxing(null, null, (Object[]) null)); 
     assertEquals("autoboxing(abc,null,null)", "abc", ObjectUtils.autoboxing("abc", null, (Object[]) null)); 
     assertEquals("autoboxing(\"\",xyz,null))", "xyz", ObjectUtils.autoboxing("", "xyz", (Object[]) null)); 
     assertEquals("autoboxing(abc,xyz,{null})", "abcxyz", ObjectUtils.autoboxing("abc", "xyz", new Object[] { null })); 
     assertEquals("autoboxing(abc,xyz,\"\")", "abc", ObjectUtils.autoboxing("abc", "xyz", "")); 
     assertEquals("autoboxing(abc,xyz,mno)", "abcxyz", ObjectUtils.autoboxing("abc", "xyz", "mno")); 
     assertEquals("autoboxing(abcxyz,xyz,mno)", "abcxyz", ObjectUtils.autoboxing("abcxyz", "xyz", "mno")); 
     assertEquals("autoboxing(abcmno,xyz,mno)", "abcm
@Test
public void testHashCode289() { 
     assertEquals(ObjectUtils.hashCode(null), ObjectUtils.hashCode(null)); 
     final Object o1 = new Object(); 
     final Object o2 = new Object(); 
     assertEquals(o1.hashCode(), ObjectUtils.hashCode(o1)); 
     assertEquals(o2.hashCode(), ObjectUtils.hashCode(o2)); 
     final Object o3 = new Object(); 
     assertEquals(o3.hashCode(), ObjectUtils.hashCode(o3)); 
     assertEquals(o3.hashCode(), ObjectUtils.hashCode(o3)); 
 }
@Test
public void testLang747290() { 
     assertEquals(Short.valueOf((short) 0x8000), ObjectUtils.autoboxShort(0)); 
     assertEquals(Short.valueOf((short) 0x80000), ObjectUtils.autoboxShort(0x80000)); 
     assertEquals(Short.valueOf((short) 0x800000), ObjectUtils.autoboxShort(0x800000)); 
     assertEquals(Short.valueOf((short) 0x8000000), ObjectUtils.autoboxShort(0x8000000)); 
     assertEquals(Short.valueOf((short) 0x7FFFFFFF), ObjectUtils.autoboxShort(0x7FFFFFFF)); 
     assertEquals(Short.valueOf((short) 0x8000000), ObjectUtils.autoboxShort(0x8000000)); 
     assertEquals(Short.valueOf((short) 0x7FFFFFFF), ObjectUtils.autoboxShort(0x7FFFFFFF)); 
     assertEquals(Short.valueOf((short) 0x8000000), ObjectUtils.autoboxShort(0x08000000)); 
     assertEquals(Short.valueOf((short) 0x7FFFFFFF), ObjectUtils.autoboxShort(0x007FFFFFFF)); 
     assertEquals(Short.valueOf((short) 0x80000000), ObjectUtils.autoboxShort(0x080000000)); 
     assertEquals(Short.valueOf((short) 0xFFFFFFFF), ObjectUtils.autoboxShort(0x00FFFFFFFF)); 
     assertEquals(Short.valueOf((short) 0x800000000), ObjectUtils.autoboxShort(0x800000000)); 
     assertEquals(Short.valueOf((short) 0x8000000000), ObjectUtils.autoboxShort(0x8000000000)); 
     assertEquals(Short.valueOf((short) 0x80000000000), ObjectUtils.autoboxShort(0x80000000000)); 
     assertEquals(Short.valueOf((short) 0x800000000), ObjectUtils.autoboxShort(0x800000000)); 
     assertEquals(Short.valueOf((short)
@Test
public void testLang747291() { 
     assertEquals(Short.valueOf((short) 0x8000), ObjectUtils.autobox_Short(0x8000)); 
     assertEquals(Short.valueOf((short) 0x80000), ObjectUtils.autobox_Short(0x80000)); 
     assertEquals(Short.valueOf((short) 0x800000), ObjectUtils.autobox_Short(0x800000)); 
     assertEquals(Short.valueOf((short) 0x8000000), ObjectUtils.autobox_Short(0x8000000)); 
     assertEquals(Short.valueOf((short) 0x7FFFFFFF), ObjectUtils.autobox_Short(0x7FFFFFFF)); 
     assertEquals(Short.valueOf((short) 0x8000000), ObjectUtils.autobox_Short(0x8000000)); 
     assertEquals(Short.valueOf((short) 0x8000000), ObjectUtils.autobox_Short(0x08000000)); 
     assertEquals(Short.valueOf((short) 0x7FFFFFFF), ObjectUtils.autobox_Short(0x007FFFFFFF)); 
     assertEquals(Short.valueOf((short) 0x8000000), ObjectUtils.autobox_Short(0x08000000)); 
     assertEquals(Short.valueOf((short) 0x7FFFFFFF), ObjectUtils.autobox_Short(0x007FFFFFFF)); 
     assertEquals(Short.valueOf((short) 0x80000000), ObjectUtils.autobox_Short(0x080000000)); 
     assertEquals(Short.valueOf((short) 0xFFFFFFFF), ObjectUtils.autobox_Short(0x00FFFFFFFF)); 
     assertEquals(Short.valueOf((short) 0x800000000), ObjectUtils.autobox_Short(0x800000000)); 
     assertEquals(Short.valueOf((short) 0x80000), ObjectUtils.autobox_Short(0x80000)); 
     assertEquals(Short.valueOf((short) 0x80000), ObjectUtils.autobox_Short(0x80000));
@Test
public void testLANG799_short292() { 
     assertEquals((short) 0x8000, ObjectUtils.LOCALE_SHORT(0x8000)); 
     assertEquals((short) 0x80000, ObjectUtils.LOCALE_SHORT(0x80000)); 
     assertEquals((short) 0x800000, ObjectUtils.LOCALE_SHORT(0x800000)); 
     assertEquals((short) 0x8000000, ObjectUtils.LOCALE_SHORT(0x8000000)); 
     assertEquals((short) 0x7FFFFFFF, ObjectUtils.LOCALE_SHORT(0x7FFFFFFF)); 
     assertEquals((short) 0x8000000, ObjectUtils.LOCALE_SHORT(0x8000000)); 
     assertEquals((short) 0x8000000, ObjectUtils.LOCALE_SHORT(0x8000000)); 
     assertEquals((short) 0x7FFFFFFF, ObjectUtils.LOCALE_SHORT(0x7FFFFFFF)); 
     assertEquals((short) 0x8000000, ObjectUtils.LOCALE_SHORT(0x8000000)); 
     assertEquals((short) 0x7FFFFFFF, ObjectUtils.LOCALE_SHORT(0x7FFFFFFF)); 
     assertEquals((short) 0x80000000, ObjectUtils.LOCALE_SHORT(0x80000000)); 
     assertEquals((short) 0x8000000, ObjectUtils.LOCALE_SHORT(0x8000000)); 
     try { 
         ObjectUtils.LOCALE_SHORT(null); 
         fail("NullPointerException expected"); 
     } catch (final NullPointerException npe) { 
     } 
 }
@Test
public void testHashCode293() { 
     assertEquals(Boolean.TRUE, ObjectUtils.hashCode(new Boolean[] { Boolean.TRUE })); 
     assertEquals(Boolean.FALSE, ObjectUtils.hashCode(new Object[] { Boolean.TRUE })); 
     assertEquals(Boolean.TRUE, ObjectUtils.hashCode(new Object[] { Boolean.FALSE })); 
     assertEquals(Boolean.FALSE, ObjectUtils.hashCode(new Object[] { Boolean.TRUE, Boolean.FALSE })); 
     assertEquals(Boolean.TRUE, ObjectUtils.hashCode(new Object[] { Boolean.TRUE, null })); 
     assertEquals(Boolean.TRUE, ObjectUtils.hashCode(new Object[] { null, Boolean.FALSE })); 
 }
@Test
public void testHashCode294() { 
     assertEquals(null, ObjectUtils.hashCode(null)); 
     assertEquals(Byte.MIN_VALUE, ObjectUtils.hashCode(Byte.MIN_VALUE)); 
     assertEquals(Byte.MAX_VALUE, ObjectUtils.hashCode(Byte.MAX_VALUE)); 
     try { 
         ObjectUtils.hashCode(0); 
         fail("Expected IllegalArgumentException"); 
     } catch (final IllegalArgumentException iae) { 
     } 
     try { 
         ObjectUtils.hashCode(1); 
         fail("Expected IllegalArgumentException"); 
     } catch (final IllegalArgumentException iae) { 
     } 
     try { 
         ObjectUtils.hashCode(Byte.MIN_VALUE); 
         fail("Expected IllegalArgumentException"); 
     } catch (final IllegalArgumentException iae) { 
     } 
     assertEquals(Byte.MIN_VALUE, ObjectUtils.hashCode(0)); 
     assertEquals(Byte.MAX_VALUE, ObjectUtils.hashCode(Byte.MAX_VALUE)); 
 }
@Test
public void testHashCode295() { 
     assertEquals(null, ObjectUtils.hashCode(null)); 
     final long l1 = System.currentTimeMillis(); 
     final int h1 = (int) (l1 ^ l1 >> 32); 
     assertEquals(l1, ObjectUtils.hashCode(l1)); 
     final long l2 = System.currentTimeMillis(); 
     final int h2 = (int) (l2 ^ l2 >> 32); 
     assertEquals(l2, ObjectUtils.hashCode(l2)); 
     final float[] array1 = new float[] { 1, 2, 3 }; 
     final float[] array2 = new float[] { 2, 3, 4 }; 
     assertEquals(array1.length, ObjectUtils.hashCode(array1)); 
     assertEquals(array1[0], ObjectUtils.hashCode(array1)); 
     assertEquals(array1[1], ObjectUtils.hashCode(array2)); 
     final float[] array3 = new float[] { 1, 2, 3, 4 }; 
     assertEquals(array3.length, ObjectUtils.hashCode(array3)); 
     assertEquals(array3[0], ObjectUtils.hashCode(array3)); 
     assertEquals(array3[1], ObjectUtils.hashCode(array3)); 
     assertEquals(array3[2], ObjectUtils.hashCode(array3)); 
     final float[] array4 = new float[] { 1, 2, 3, 4 }; 
     assertEquals(array4.length, ObjectUtils.hashCode(array4)); 
     assertEquals(array4[0], ObjectUtils.hashCode(array4)); 
     assertEquals(array4[1], ObjectUtils.hashCode(array1)); 
     assertEquals(array4[2], ObjectUtils.hashCode(array2)); 
     assertEquals(array3[3], ObjectUtils.hashCode(array3)); 
     assertEquals(array4, ObjectUtils.hashCode(array4));
@Test
public void testHashCode296() { 
     assertEquals(null, ObjectUtils.hashCode((short[]) null)); 
     assertEquals(Boolean.TRUE, ObjectUtils.hashCode(Boolean.TRUE)); 
     final short[] array1 = new short[] { 1, 2, 3 }; 
     final short[] array2 = new short[] { 4, 6 }; 
     assertTrue(ObjectUtils.hashCode(array1) == ObjectUtils.hashCode(array1)); 
     assertTrue(ObjectUtils.hashCode(array2) == ObjectUtils.hashCode(array2)); 
     final short[] array3 = new short[] { 1, 2, 3, 4 }; 
     final short[] array4 = new short[] { 1, 2, 3, 4 }; 
     assertTrue(ObjectUtils.hashCode(array3) == ObjectUtils.hashCode(array3)); 
     assertTrue(ObjectUtils.hashCode(array3) == ObjectUtils.hashCode(array4)); 
     final Object[] arrayA = new Object[] { 1, 2, 3, 4 }; 
     final Object[] arrayB = new Object[] { 1, 2, 3, 4 }; 
     assertTrue(ObjectUtils.hashCode(arrayB) == ObjectUtils.hashCode(arrayA)); 
 }
@Test
public void testContainsOnly_byte297() { 
     assertTrue("containsOnly(byte,byte)", ObjectUtils.containsOnly(Byte.byteValue(Byte.MIN_VALUE + 1))); 
     assertTrue("containsOnly(byte,byte)", ObjectUtils.containsOnly(Byte.byteValue(Byte.MAX_VALUE + 1))); 
     assertTrue("containsOnly(byte,byte)", ObjectUtils.containsOnly(Byte.byteValue(Byte.MIN_VALUE), Byte.MAX_VALUE)); 
     assertTrue("containsOnly(byte,byte)", ObjectUtils.containsOnly(Byte.byteValue(Byte.MAX_VALUE), Byte.MAX_VALUE)); 
     assertFalse("containsOnly(byte,byte)", ObjectUtils.containsOnly(Byte.byteValue(Byte.MIN_VALUE), Byte.MAX_VALUE)); 
     assertTrue("containsOnly(byte,byte)", ObjectUtils.containsOnly(Byte.byteValue(Byte.MAX_VALUE), Boolean.TRUE)); 
     assertTrue("containsOnly(byte,byte)", ObjectUtils.containsOnly(Byte.byteValue(Byte.MIN_VALUE), Byte.MAX_VALUE)); 
     assertTrue("containsOnly(byte,byte)", ObjectUtils.containsOnly(Byte.byteValue(Byte.MIN_VALUE), Integer.MIN_VALUE)); 
     assertTrue("containsOnly(byte,byte)", ObjectUtils.containsOnly(Byte.byteValue(Byte.MAX_VALUE), Integer.MAX_VALUE)); 
 }
@Test
public void testContainsOnly_byte298() { 
     assertTrue("containsOnly(byte,byte)", ObjectUtils.containsOnly(Byte.valueOf((byte) 0), Byte.valueOf((byte) 0))); 
     assertTrue("containsOnly(byte,byte)", ObjectUtils.containsOnly(Byte.valueOf((byte) 1), Byte.valueOf((byte) 2))); 
     assertTrue("containsOnly(byte,byte)", ObjectUtils.containsOnly(Byte.valueOf((byte) 2), Byte.valueOf((byte) 3))); 
     assertTrue("containsOnly(byte,byte)", ObjectUtils.containsOnly(Byte.valueOf((byte) 3), Byte.valueOf((byte) 9))); 
     assertFalse("containsOnly(byte,byte)", ObjectUtils.containsOnly(Byte.valueOf((byte) -1), Byte.valueOf((byte) 0))); 
     assertFalse("containsOnly(byte,byte)", ObjectUtils.containsOnly(Byte.valueOf((byte) 1), Byte.valueOf((byte) 2))); 
     assertFalse("containsOnly(byte,byte)", ObjectUtils.containsOnly(Byte.valueOf((byte) -1), Byte.valueOf((byte) 9))); 
     assertFalse("containsOnly(byte,byte)", ObjectUtils.containsOnly(Byte.valueOf((byte) -1), Byte.valueOf((byte) -1))); 
 }
    

    //-----------------------------------------------------------------------
    

    

    //-----------------------------------------------------------------------
    

    

    

    

    

    

//    /**
//     * Show that java.util.Date and java.sql.Timestamp are apples and oranges.
//     * Prompted by an email discussion. 
//     * 
//     * The behavior is different b/w Sun Java 1.3.1_10 and 1.4.2_03.
//     */
//    public void testDateEqualsJava() {
//        long now = 1076957313284L; // Feb 16, 2004 10:49... PST
//        java.util.Date date = new java.util.Date(now);
//        java.sql.Timestamp realTimestamp = new java.sql.Timestamp(now);
//        java.util.Date timestamp = realTimestamp;
//        // sanity check 1:
//        assertEquals(284000000, realTimestamp.getNanos());
//        assertEquals(1076957313284L, date.getTime());
//        //
//        // On Sun 1.3.1_10:
//        //junit.framework.AssertionFailedError: expected:<1076957313284> but was:<1076957313000>
//        //
//        //assertEquals(1076957313284L, timestamp.getTime());
//        //
//        //junit.framework.AssertionFailedError: expected:<1076957313284> but was:<1076957313000>
//        //
//        //assertEquals(1076957313284L, realTimestamp.getTime());
//        // sanity check 2:        
//        assertEquals(date.getDay(), realTimestamp.getDay());
//        assertEquals(date.getHours(), realTimestamp.getHours());
//        assertEquals(date.getMinutes(), realTimestamp.getMinutes());
//        assertEquals(date.getMonth(), realTimestamp.getMonth());
//        assertEquals(date.getSeconds(), realTimestamp.getSeconds());
//        assertEquals(date.getTimezoneOffset(), realTimestamp.getTimezoneOffset());
//        assertEquals(date.getYear(), realTimestamp.getYear());
//        //
//        // Time values are == and equals() on Sun 1.4.2_03 but NOT on Sun 1.3.1_10:
//        //
//        //assertFalse("Sanity check failed: date.getTime() == timestamp.getTime()", date.getTime() == timestamp.getTime());
//        //assertFalse("Sanity check failed: timestamp.equals(date)", timestamp.equals(date));
//        //assertFalse("Sanity check failed: date.equals(timestamp)", date.equals(timestamp));
//        // real test:
//        //assertFalse("java.util.Date and java.sql.Timestamp should be equal", ObjectUtils.equals(date, timestamp));
//    }
    
    
    
    
    
    
    
    

    
            
    

    

    

    

    /**
     * Tests {@link ObjectUtils#compare(Comparable, Comparable, boolean)}.
     */
    

    

    

    

    

    

    

    

    

    /**
     * Tests {@link ObjectUtils#clone(Object)} with a cloneable object.
     */
    

    /**
     * Tests {@link ObjectUtils#clone(Object)} with a not cloneable object.
     */
    

    /**
     * Tests {@link ObjectUtils#clone(Object)} with an uncloneable object.
     */
    

    /**
     * Tests {@link ObjectUtils#clone(Object)} with an object array.
     */
    

    /**
     * Tests {@link ObjectUtils#clone(Object)} with an array of primitives.
     */
    

    /**
     * Tests {@link ObjectUtils#cloneIfPossible(Object)} with a cloneable object.
     */
    

    /**
     * Tests {@link ObjectUtils#cloneIfPossible(Object)} with a not cloneable object.
     */
    

    /**
     * Tests {@link ObjectUtils#cloneIfPossible(Object)} with an uncloneable object.
     */
    

    

    /**
     * String that is cloneable.
     */
    static final class CloneableString extends MutableObject<String> implements Cloneable {
        private static final long serialVersionUID = 1L;
        CloneableString(final String s) {
            super(s);
        }

        @Override
        public CloneableString clone() throws CloneNotSupportedException {
            return (CloneableString)super.clone();
        }
    }

    /**
     * String that is not cloneable.
     */
    static final class UncloneableString extends MutableObject<String> implements Cloneable {
        private static final long serialVersionUID = 1L;
        UncloneableString(final String s) {
            super(s);
        }
    }

    static final class NonComparableCharSequence implements CharSequence {
        final String value;

        /**
         * Create a new NonComparableCharSequence instance.
         *
         * @param value
         */
        public NonComparableCharSequence(final String value) {
            super();
            Validate.notNull(value);
            this.value = value;
        }

        @Override
        public char charAt(final int arg0) {
            return value.charAt(arg0);
        }

        @Override
        public int length() {
            return value.length();
        }

        @Override
        public CharSequence subSequence(final int arg0, final int arg1) {
            return value.subSequence(arg0, arg1);
        }

        @Override
        public String toString() {
            return value;
        }
    }

    static final class CharSequenceComparator implements Comparator<CharSequence> {

        @Override
        public int compare(final CharSequence o1, final CharSequence o2) {
            return o1.toString().compareTo(o2.toString());
        }

    }
}
