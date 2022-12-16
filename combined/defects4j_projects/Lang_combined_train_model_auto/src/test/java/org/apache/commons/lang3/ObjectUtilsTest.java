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
public void testComparatorMedian91() { 
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
@Test
public void testIdentityToStringAppendable130() { 
     final Integer i = Integer.valueOf(121); 
     final String expected = "java.lang.Integer@" + Integer.toHexString(System.identityHashCode(i)); 
     try { 
         final Appendable appendable = new StringBuilder(); 
         ObjectUtils.identityToString(appendable, i); 
         assertEquals(expected, appendable.toString()); 
     } catch (IOException ex) { 
         fail("IOException unexpected"); 
     } 
     try { 
         ObjectUtils.identityToString((Appendable) null, "tmp"); 
         fail("NullPointerException expected"); 
     } catch (final NullPointerException npe) { 
     } catch (IOException ex) { 
     } 
     try { 
         ObjectUtils.identityToString((Appendable) (new StringBuilder()), null); 
         fail("NullPointerException expected"); 
     } catch (final NullPointerException npe) { 
     } catch (IOException ex) { 
     } 
 }
@Test
public void testToString_Object158() { 
     assertEquals("", ObjectUtils.toString((Object) null)); 
     assertEquals(Boolean.TRUE.toString(), ObjectUtils.toString(Boolean.TRUE)); 
 } 
@SuppressWarnings("unchecked")
@Test
public void testMode222() { 
     assertNull(ObjectUtils.mode((Object[]) null)); 
     assertNull(ObjectUtils.mode()); 
     assertNull(ObjectUtils.mode("foo", "bar", "baz")); 
     assertNull(ObjectUtils.mode("foo", "bar", "baz", "foo", "bar")); 
     assertEquals("foo", ObjectUtils.mode("foo", "bar", "baz", "foo")); 
     assertEquals(Integer.valueOf(9), ObjectUtils.mode("foo", "bar", "baz", Integer.valueOf(9), Integer.valueOf(10), Integer.valueOf(9))); 
 }
@Test
public void testCloneOfNotCloneable230() { 
     final String string = new String("apache"); 
     assertNull(ObjectUtils.clone(string)); 
 }
@Test
public void testCloneOfStringArray379() { 
     assertTrue(Arrays.deepEquals(new String[] { "string" }, ObjectUtils.clone(new String[] { "string" }))); 
 }
@Test
public void testMin387() { 
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
public void testNotEqual413() { 
     assertFalse("ObjectUtils.notEqual(null, null) returned false", ObjectUtils.notEqual(null, null)); 
     assertTrue("ObjectUtils.notEqual(\"foo\", null) returned true", ObjectUtils.notEqual(FOO, null)); 
     assertTrue("ObjectUtils.notEqual(null, \"bar\") returned true", ObjectUtils.notEqual(null, BAR)); 
     assertTrue("ObjectUtils.notEqual(\"foo\", \"bar\") returned true", ObjectUtils.notEqual(FOO, BAR)); 
     assertFalse("ObjectUtils.notEqual(\"foo\", \"foo\") returned false", ObjectUtils.notEqual(FOO, FOO)); 
 }
@Test
public void testIsNull430() { 
     final Object o = FOO; 
     final Object dflt = BAR; 
     assertSame("dflt was not returned when o was null", dflt, ObjectUtils.defaultIfNull(null, dflt)); 
     assertSame("dflt was returned when o was not null", o, ObjectUtils.defaultIfNull(o, dflt)); 
 }
@Test
public void testEquals450() { 
     assertTrue("ObjectUtils.equals(null, null) returned false", ObjectUtils.equals(null, null)); 
     assertTrue("ObjectUtils.equals(\"foo\", null) returned true", !ObjectUtils.equals(FOO, null)); 
     assertTrue("ObjectUtils.equals(null, \"bar\") returned true", !ObjectUtils.equals(null, BAR)); 
     assertTrue("ObjectUtils.equals(\"foo\", \"bar\") returned true", !ObjectUtils.equals(FOO, BAR)); 
     assertTrue("ObjectUtils.equals(\"foo\", \"foo\") returned false", ObjectUtils.equals(FOO, FOO)); 
 }
@Test
public void testHashCodeMulti_multiple_likeList507() { 
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
public void testIdentityToStringStringBuilder542() { 
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
public void testCloneOfPrimitiveArray613() { 
     assertTrue(Arrays.equals(new int[] { 1 }, ObjectUtils.clone(new int[] { 1 }))); 
 }
@Test
public void testMax672() { 
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
@Test
public void testCompare681() { 
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
@Test(expected = NoSuchMethodException.class) 
 public void testCloneOfUncloneable704() throws Throwable { 
     final UncloneableString string = new UncloneableString("apache"); 
     try { 
         ObjectUtils.clone(string); 
         fail("Thrown " + CloneFailedException.class.getName() + " expected"); 
     } catch (final CloneFailedException e) { 
         throw e.getCause(); 
     } 
 }
@Test
public void testToString_ObjectString741() { 
     assertEquals(BAR, ObjectUtils.toString((Object) null, BAR)); 
     assertEquals(Boolean.TRUE.toString(), ObjectUtils.toString(Boolean.TRUE, BAR)); 
 }
@Test
public void testConstructor748() { 
     assertNotNull(new ObjectUtils()); 
     final Constructor<?>[] cons = ObjectUtils.class.getDeclaredConstructors(); 
     assertEquals(1, cons.length); 
     assertTrue(Modifier.isPublic(cons[0].getModifiers())); 
     assertTrue(Modifier.isPublic(ObjectUtils.class.getModifiers())); 
     assertFalse(Modifier.isFinal(ObjectUtils.class.getModifiers())); 
 }
@Test
public void testIdentityToStringStrBuilder805() { 
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
public void testMedian853() { 
     assertEquals("foo", ObjectUtils.median("foo")); 
     assertEquals("bar", ObjectUtils.median("foo", "bar")); 
     assertEquals("baz", ObjectUtils.median("foo", "bar", "baz")); 
     assertEquals("baz", ObjectUtils.median("foo", "bar", "baz", "blah")); 
     assertEquals("blah", ObjectUtils.median("foo", "bar", "baz", "blah", "wah")); 
     assertEquals(Integer.valueOf(5), ObjectUtils.median(Integer.valueOf(1), Integer.valueOf(5), Integer.valueOf(10))); 
     assertEquals(Integer.valueOf(7), ObjectUtils.median(Integer.valueOf(5), Integer.valueOf(6), Integer.valueOf(7), Integer.valueOf(8), Integer.valueOf(9))); 
     assertEquals(Integer.valueOf(6), ObjectUtils.median(Integer.valueOf(5), Integer.valueOf(6), Integer.valueOf(7), Integer.valueOf(8))); 
 }
@Test
public void testFirstNonNull931() { 
     assertEquals(null, ObjectUtils.firstNonNull(null, null)); 
     assertEquals("", ObjectUtils.firstNonNull(null, "")); 
     final String firstNonNullGenerics = ObjectUtils.firstNonNull(null, null, "123", "456"); 
     assertEquals("123", firstNonNullGenerics); 
     assertEquals("123", ObjectUtils.firstNonNull("123", null, "456", null)); 
     assertEquals(null, ObjectUtils.firstNonNull()); 
     assertSame(Boolean.TRUE, ObjectUtils.firstNonNull(Boolean.TRUE)); 
     assertNull(ObjectUtils.firstNonNull()); 
     assertNull(ObjectUtils.firstNonNull(null, null)); 
     assertNull(ObjectUtils.firstNonNull((Object) null)); 
     assertNull(ObjectUtils.firstNonNull((Object[]) null)); 
 }
@Test(expected = IllegalArgumentException.class) 
 public void testMedian_emptyItems1055() { 
     ObjectUtils.<String>median(); 
 }
@Test
public void testIdentityToStringStringBuffer1070() { 
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
public void testPossibleCloneOfCloneable1108() { 
     final CloneableString string = new CloneableString("apache"); 
     final CloneableString stringClone = ObjectUtils.cloneIfPossible(string); 
     assertEquals("apache", stringClone.getValue()); 
 }
@Test
public void testHashCode1392() { 
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
public void testHashCode1631() { 
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
public void testHashCode1635() { 
     assertEquals(Boolean.TRUE, ObjectUtils.hashCode(new Boolean[] { Boolean.TRUE })); 
     assertEquals(Boolean.FALSE, ObjectUtils.hashCode(new Object[] { Boolean.TRUE })); 
     assertEquals(Boolean.TRUE, ObjectUtils.hashCode(new Object[] { Boolean.FALSE })); 
     assertEquals(Boolean.FALSE, ObjectUtils.hashCode(new Object[] { Boolean.TRUE, Boolean.FALSE })); 
     assertEquals(Boolean.TRUE, ObjectUtils.hashCode(new Object[] { Boolean.TRUE, null })); 
     assertEquals(Boolean.TRUE, ObjectUtils.hashCode(new Object[] { null, Boolean.FALSE })); 
 }
@Test
public void testHashCode1636() { 
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
public void testHashCode1637() { 
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
}

@Test
public void testHashCode1638() { 
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
