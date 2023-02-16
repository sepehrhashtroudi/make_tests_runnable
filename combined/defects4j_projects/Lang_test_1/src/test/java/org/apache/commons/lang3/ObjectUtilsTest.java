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
public void testMin384() { 
     assertEquals(null, ObjectUtils.min((String) null)); 
     assertEquals("", ObjectUtils.min("")); 
     assertEquals("", ObjectUtils.min("abc")); 
     assertEquals("foo", ObjectUtils.min("foo", null)); 
     assertEquals("bar", ObjectUtils.min("foo", "bar")); 
     assertEquals("baz", ObjectUtils.min("foo", "bar", "baz")); 
     assertEquals(Integer.valueOf(5), ObjectUtils.min(Integer.valueOf(1), Integer.valueOf(5), Integer.valueOf(10))); 
     assertEquals(Integer.valueOf(7), ObjectUtils.min(Integer.valueOf(5), Integer.valueOf(6), Integer.valueOf(7), Integer.valueOf(8), Integer.valueOf(9))); 
 }
@Test
public void testMin385() { 
     assertEquals(null, ObjectUtils.min((String) null)); 
     assertEquals("", ObjectUtils.min()); 
     assertEquals("", ObjectUtils.min("foo")); 
     assertEquals("bar", ObjectUtils.min("foo", "bar")); 
     assertEquals("baz", ObjectUtils.min("foo", "bar", "baz")); 
     assertEquals("baz", ObjectUtils.min("foo", "bar", "baz", "blah")); 
     assertEquals(Integer.valueOf(5), ObjectUtils.min(Integer.valueOf(1), Integer.valueOf(5), Integer.valueOf(10))); 
     assertEquals(Integer.valueOf(7), ObjectUtils.min(Integer.valueOf(5), Integer.valueOf(6), Integer.valueOf(7), Integer.valueOf(8), Integer.valueOf(9))); 
     assertEquals(Integer.valueOf(6), ObjectUtils.min(Integer.valueOf(5), Integer.valueOf(6), Integer.valueOf(7), Integer.valueOf(8))); 
 }
@Test
public void testCompare386() { 
     final Integer one = Integer.valueOf(1); 
     final Integer two = Integer.valueOf(2); 
     final Integer nullValue = null; 
     assertEquals("Null Null false", 0, ObjectUtils.compare(nullValue, nullValue)); 
     assertEquals("Null Null true", 0, ObjectUtils.compare(nullValue, nullValue, true)); 
     assertEquals("Null one false", -1, ObjectUtils.compare(nullValue, one)); 
     assertEquals("Null one true", 1, ObjectUtils.compare(nullValue, one, true)); 
     assertEquals("one Null false", 1, ObjectUtils.compare(one, nullValue)); 
     assertEquals("one Null true", -1, ObjectUtils.compare(one, nullValue, true)); 
     assertEquals("one two false", -1, ObjectUtils.compare(one, two)); 
     assertEquals("one two true", -1, ObjectUtils.compare(one, two, true)); 
 }
@Test
public void testMedian387() { 
     assertEquals("foo", ObjectUtils.median("foo")); 
     assertEquals("bar", ObjectUtils.median("foo", "bar")); 
     assertEquals("baz", ObjectUtils.median("foo", "bar", "baz")); 
     assertEquals(Integer.valueOf(5), ObjectUtils.median(Integer.valueOf(1), Integer.valueOf(5), Integer.valueOf(10))); 
     assertEquals(Integer.valueOf(7), ObjectUtils.median(Integer.valueOf(5), Integer.valueOf(6), Integer.valueOf(7), Integer.valueOf(8), Integer.valueOf(9))); 
     assertEquals(Integer.valueOf(6), ObjectUtils.median(Integer.valueOf(5), Integer.valueOf(6), Integer.valueOf(7), Integer.valueOf(8), Integer.valueOf(9))); 
 }
@Test
public void testCloneOfPrimitiveArray389() { 
     assertTrue(Arrays.equals(new int[] { 1 }, ObjectUtils.clone(new int[] { 1 }))); 
 }
@Test
public void testCloneIfPossible390() { 
     assertEquals(null, ObjectUtils.cloneIfPossible(null)); 
     assertEquals("", ObjectUtils.cloneIfPossible("")); 
     assertEquals("abc", ObjectUtils.cloneIfPossible("abc")); 
     assertEquals(Boolean.TRUE, ObjectUtils.cloneIfPossible(Boolean.TRUE)); 
 }
@Test
public void testCloneIfPossible391() { 
     assertEquals(null, ObjectUtils.cloneIfPossible(null)); 
     assertEquals("", ObjectUtils.cloneIfPossible("")); 
     assertEquals("abc", ObjectUtils.cloneIfPossible("abc")); 
     final Integer i = Integer.valueOf(90); 
     final String expected = "abc"; 
     assertSame(expected, ObjectUtils.cloneIfPossible(i)); 
     assertEquals(expected, ObjectUtils.cloneIfPossible(i)); 
 }
@Test
public void testConstructor392() { 
     assertNotNull(new ObjectUtils()); 
     final Constructor<?>[] cons = ObjectUtils.class.getDeclaredConstructors(); 
     assertEquals(1, cons.length); 
     assertTrue(Modifier.isPublic(cons[0].getModifiers())); 
     assertTrue(Modifier.isPublic(ObjectUtils.class.getModifiers())); 
     assertFalse(Modifier.isFinal(ObjectUtils.class.getModifiers())); 
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
