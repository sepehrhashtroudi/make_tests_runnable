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
public void testConstructor868() { 
     assertNotNull(new ObjectUtils()); 
     final Constructor<?>[] cons = ObjectUtils.class.getDeclaredConstructors(); 
     assertEquals(1, cons.length); 
     assertTrue(Modifier.isPublic(cons[0].getModifiers())); 
     assertTrue(Modifier.isPublic(ObjectUtils.class.getModifiers())); 
     assertFalse(Modifier.isFinal(ObjectUtils.class.getModifiers())); 
 }
@Test
public void testEquals869() { 
     assertTrue("ObjectUtils.equals(null, null) returned false", ObjectUtils.equals(null, null)); 
     assertTrue("ObjectUtils.equals(\"foo\", null) returned true", !ObjectUtils.equals(FOO, null)); 
     assertTrue("ObjectUtils.equals(null, \"bar\") returned true", !ObjectUtils.equals(null, BAR)); 
     assertTrue("ObjectUtils.equals(\"foo\", \"bar\") returned true", !ObjectUtils.equals(FOO, BAR)); 
     assertTrue("ObjectUtils.equals(\"foo\", \"foo\") returned false", ObjectUtils.equals(FOO, FOO)); 
 }
@Test
public void testHashCodeMulti_multiple_likeList870() { 
     final List<Object> list0 = new ArrayList<Object>(Arrays.asList()); 
     assertEquals(list0.hashCode(), ObjectUtils.hashCodeMulti()); 
     final List<Object> list1 = new ArrayList<Object>(Arrays.asList("a")); 
     assertEquals(list1.hashCode(), ObjectUtils.hashCodeMulti("a")); 
     final List<Object> list2 = new ArrayList<Object>(Arrays.asList("a", "b")); 
     assertEquals(list2.hashCode(), ObjectUtils.hashCodeMulti("a", "b")); 
     final List<Object> list3 = new ArrayList<Object>(Arrays.asList("a", "b", "c")); 
     assertEquals(list3.hashCode(), ObjectUtils.hashCodeMulti("a", "b", "c")); 
 }
@Test
public void testIdentityToStringStringBuilder871() { 
     assertEquals(null, ObjectUtils.identityToString(null)); 
     assertEquals("java.lang.String@" + Integer.toHexString(System.identityHashCode(FOO)), ObjectUtils.identityToString(FOO)); 
     final Integer i = Integer.valueOf(90); 
     final String expected = "java.lang.Integer@" + Integer.toHexString(System.identityHashCode(i)); 
     assertEquals(expected, ObjectUtils.identityToString(i)); 
     final StringBuilder builder = new StringBuilder(); 
     ObjectUtils.identityToString(builder, i); 
     assertEquals(expected, builder.toString()); 
     try { 
         ObjectUtils.identityToString((StringBuilder) null, "tmp"); 
         fail("NullPointerException expected"); 
     } catch (final NullPointerException npe) { 
     } 
     try { 
         ObjectUtils.identityToString(new StringBuilder(), null); 
         fail("NullPointerException expected"); 
     } catch (final NullPointerException npe) { 
     } 
 }
@Test
public void testIdentityToStringStrBuilder872() { 
     final Integer i = Integer.valueOf(102); 
     final String expected = "java.lang.Integer@" + Integer.toHexString(System.identityHashCode(i)); 
     final StrBuilder builder = new StrBuilder(); 
     ObjectUtils.identityToString(builder, i); 
     assertEquals(expected, builder.toString()); 
     try { 
         ObjectUtils.identityToString((StrBuilder) null, "tmp"); 
         fail("NullPointerException expected"); 
     } catch (final NullPointerException npe) { 
     } 
     try { 
         ObjectUtils.identityToString(new StrBuilder(), null); 
         fail("NullPointerException expected"); 
     } catch (final NullPointerException npe) { 
     } 
 }
@Test
public void testIdentityToStringStringBuffer873() { 
     final Integer i = Integer.valueOf(45); 
     final String expected = "java.lang.Integer@" + Integer.toHexString(System.identityHashCode(i)); 
     final StringBuffer buffer = new StringBuffer(); 
     ObjectUtils.identityToString(buffer, i); 
     assertEquals(expected, buffer.toString()); 
     try { 
         ObjectUtils.identityToString((StringBuffer) null, "tmp"); 
         fail("NullPointerException expected"); 
     } catch (final NullPointerException npe) { 
     } 
     try { 
         ObjectUtils.identityToString(new StringBuffer(), null); 
         fail("NullPointerException expected"); 
     } catch (final NullPointerException npe) { 
     } 
 }
@Test
public void testToString_ObjectString874() { 
     assertEquals(BAR, ObjectUtils.toString((Object) null, BAR)); 
     assertEquals(Boolean.TRUE.toString(), ObjectUtils.toString(Boolean.TRUE, BAR)); 
 }
@Test
public void testMin875() { 
     final Calendar calendar = Calendar.getInstance(); 
     final Date nonNullComparable1 = calendar.getTime(); 
     final Date nonNullComparable2 = calendar.getTime(); 
     final String[] nullAray = null; 
     calendar.set(Calendar.YEAR, calendar.get(Calendar.YEAR) - 1); 
     final Date minComparable = calendar.getTime(); 
     assertNotSame(nonNullComparable1, nonNullComparable2); 
     assertNull(ObjectUtils.min((String) null)); 
     assertNull(ObjectUtils.min(nullAray)); 
     assertSame(nonNullComparable1, ObjectUtils.min(null, nonNullComparable1)); 
     assertSame(nonNullComparable1, ObjectUtils.min(nonNullComparable1, null)); 
     assertSame(nonNullComparable1, ObjectUtils.min(null, nonNullComparable1, null)); 
     assertSame(nonNullComparable1, ObjectUtils.min(nonNullComparable1, nonNullComparable2)); 
     assertSame(nonNullComparable2, ObjectUtils.min(nonNullComparable2, nonNullComparable1)); 
     assertSame(minComparable, ObjectUtils.min(nonNullComparable1, minComparable)); 
     assertSame(minComparable, ObjectUtils.min(minComparable, nonNullComparable1)); 
     assertSame(minComparable, ObjectUtils.min(null, nonNullComparable1, null, minComparable)); 
     assertNull(ObjectUtils.min((String) null, (String) null)); 
 }
@Test
public void testMax876() { 
     final Calendar calendar = Calendar.getInstance(); 
     final Date nonNullComparable1 = calendar.getTime(); 
     final Date nonNullComparable2 = calendar.getTime(); 
     final String[] nullAray = null; 
     calendar.set(Calendar.YEAR, calendar.get(Calendar.YEAR) - 1); 
     final Date minComparable = calendar.getTime(); 
     assertNotSame(nonNullComparable1, nonNullComparable2); 
     assertNull(ObjectUtils.max((String) null)); 
     assertNull(ObjectUtils.max(nullAray)); 
     assertSame(nonNullComparable1, ObjectUtils.max(null, nonNullComparable1)); 
     assertSame(nonNullComparable1, ObjectUtils.max(nonNullComparable1, null)); 
     assertSame(nonNullComparable1, ObjectUtils.max(null, nonNullComparable1, null)); 
     assertSame(nonNullComparable1, ObjectUtils.max(nonNullComparable1, nonNullComparable2)); 
     assertSame(nonNullComparable2, ObjectUtils.max(nonNullComparable2, nonNullComparable1)); 
     assertSame(nonNullComparable1, ObjectUtils.max(nonNullComparable1, minComparable)); 
     assertSame(nonNullComparable1, ObjectUtils.max(minComparable, nonNullComparable1)); 
     assertSame(nonNullComparable1, ObjectUtils.max(null, minComparable, null, nonNullComparable1)); 
     assertNull(ObjectUtils.max((String) null, (String) null)); 
 }
@Test(expected = IllegalArgumentException.class) 
 public void testMedian_emptyItems877() { 
     ObjectUtils.<String>median(); 
 }
@Test
public void testComparatorMedian878() { 
     final CharSequenceComparator cmp = new CharSequenceComparator(); 
     final NonComparableCharSequence foo = new NonComparableCharSequence("foo"); 
     final NonComparableCharSequence bar = new NonComparableCharSequence("bar"); 
     final NonComparableCharSequence baz = new NonComparableCharSequence("baz"); 
     final NonComparableCharSequence blah = new NonComparableCharSequence("blah"); 
     final NonComparableCharSequence wah = new NonComparableCharSequence("wah"); 
     assertSame(foo, ObjectUtils.median(cmp, foo)); 
     assertSame(bar, ObjectUtils.median(cmp, foo, bar)); 
     assertSame(baz, ObjectUtils.median(cmp, foo, bar, baz)); 
     assertSame(baz, ObjectUtils.median(cmp, foo, bar, baz, blah)); 
     assertSame(blah, ObjectUtils.median(cmp, foo, bar, baz, blah, wah)); 
 } 
@SuppressWarnings("unchecked")
@Test
public void testMode879() { 
     assertNull(ObjectUtils.mode((Object[]) null)); 
     assertNull(ObjectUtils.mode()); 
     assertNull(ObjectUtils.mode("foo", "bar", "baz")); 
     assertNull(ObjectUtils.mode("foo", "bar", "baz", "foo", "bar")); 
     assertEquals("foo", ObjectUtils.mode("foo", "bar", "baz", "foo")); 
     assertEquals(Integer.valueOf(9), ObjectUtils.mode("foo", "bar", "baz", Integer.valueOf(9), Integer.valueOf(10), Integer.valueOf(9))); 
 }
@Test
public void testCloneOfStringArray880() { 
     assertTrue(Arrays.deepEquals(new String[] { "string" }, ObjectUtils.clone(new String[] { "string" }))); 
 }
@Test
public void testPossibleCloneOfCloneable881() { 
     final CloneableString string = new CloneableString("apache"); 
     final CloneableString stringClone = ObjectUtils.cloneIfPossible(string); 
     assertEquals("apache", stringClone.getValue()); 
 }
@Test(expected = NoSuchMethodException.class) 
 public void testCloneOfUncloneable882() throws Throwable { 
     final UncloneableString string = new UncloneableString("apache"); 
     try { 
         ObjectUtils.clone(string); 
         fail("Thrown " + CloneFailedException.class.getName() + " expected"); 
     } catch (final CloneFailedException e) { 
         throw e.getCause(); 
     } 
 } 
@SuppressWarnings("cast")
@Test
public void testNull884() { 
     assertNotNull(ObjectUtils.NULL); 
     assertTrue(ObjectUtils.NULL instanceof ObjectUtils.Null); 
     assertSame(ObjectUtils.NULL, SerializationUtils.clone(ObjectUtils.NULL)); 
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
