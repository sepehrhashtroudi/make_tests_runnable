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
public void testMedian316() { 
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
public void testIdentityToStringAppendable450() { 
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
public void testIdentityToStringStringBuffer486() { 
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
@Test(expected = NullPointerException.class) 
 public void testComparatorMedian_nullItems616() { 
     ObjectUtils.median(new CharSequenceComparator(), (CharSequence[]) null); 
 }
@Test
public void testMax715() { 
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
public void testIdentityToStringAppendable812() { 
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
public void testMax865() { 
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
public void testHashCode936() { 
     assertEquals(0, ObjectUtils.hashCode(null)); 
     assertEquals("a".hashCode(), ObjectUtils.hashCode("a")); 
 }
@Test
public void testMax942() { 
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
public void testHashCodeMulti_multiple_emptyArray972() { 
     final Object[] array = new Object[0]; 
     assertEquals(1, ObjectUtils.hashCodeMulti(array)); 
 }
@Test
public void testConstMethods1020() { 
     assertTrue("CONST(boolean)", ObjectUtils.CONST(true)); 
     assertEquals("CONST(byte)", (byte) 3, ObjectUtils.CONST((byte) 3)); 
     assertEquals("CONST(char)", (char) 3, ObjectUtils.CONST((char) 3)); 
     assertEquals("CONST(short)", (short) 3, ObjectUtils.CONST((short) 3)); 
     assertEquals("CONST(int)", 3, ObjectUtils.CONST(3)); 
     assertEquals("CONST(long)", 3l, ObjectUtils.CONST(3l)); 
     assertEquals("CONST(float)", 3f, ObjectUtils.CONST(3f), 0); 
     assertEquals("CONST(double)", 3.0, ObjectUtils.CONST(3.0), 0); 
     assertEquals("CONST(Object)", "abc", ObjectUtils.CONST("abc")); 
     final boolean MAGIC_FLAG = ObjectUtils.CONST(true); 
     final byte MAGIC_BYTE1 = ObjectUtils.CONST((byte) 127); 
     final byte MAGIC_BYTE2 = ObjectUtils.CONST_BYTE(127); 
     final char MAGIC_CHAR = ObjectUtils.CONST('a'); 
     final short MAGIC_SHORT1 = ObjectUtils.CONST((short) 123); 
     final short MAGIC_SHORT2 = ObjectUtils.CONST_SHORT(127); 
     final int MAGIC_INT = ObjectUtils.CONST(123); 
     final long MAGIC_LONG1 = ObjectUtils.CONST(123L); 
     final long MAGIC_LONG2 = ObjectUtils.CONST(3); 
     final float MAGIC_FLOAT = ObjectUtils.CONST(1.0f); 
     final double MAGIC_DOUBLE = ObjectUtils.CONST(1.0); 
     final String MAGIC_STRING = ObjectUtils.CONST("abc"); 
     assertTrue(MAGIC_FLAG); 
     assertEquals(127, MAGIC_BYTE1); 
     assertEquals(127, MAGIC_BYTE2); 
     assertEquals('a', MAGIC_CHAR); 
     assertEquals(123, MAGIC_SHORT1); 
     assertEquals(127, MAGIC_SHORT2); 
     assertEquals(123, MAGIC_INT); 
     assertEquals(123, MAGIC_LONG1); 
     assertEquals(3, MAGIC_LONG2); 
     assertEquals(1.0f, MAGIC_FLOAT, 0.0f); 
     assertEquals(1.0, MAGIC_DOUBLE, 0.0); 
     assertEquals("abc", MAGIC_STRING); 
     try { 
         ObjectUtils.CONST_BYTE(-129); 
         fail("CONST_BYTE(-129): IllegalArgumentException should have been thrown."); 
     } catch (final IllegalArgumentException iae) { 
     } 
     try { 
         ObjectUtils.CONST_BYTE(128); 
         fail("CONST_BYTE(128): IllegalArgumentException should have been thrown."); 
     } catch (final IllegalArgumentException iae) { 
     } 
     try { 
         ObjectUtils.CONST_SHORT(-32769); 
         fail("CONST_SHORT(-32769): IllegalArgumentException should have been thrown."); 
     } catch (final IllegalArgumentException iae) { 
     } 
     try { 
         ObjectUtils.CONST_BYTE(32768); 
         fail("CONST_SHORT(32768): IllegalArgumentException should have been thrown."); 
     } catch (final IllegalArgumentException iae) { 
     } 
 }
@Test
public void testIdentityToStringStringBuffer1112() { 
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
public void testIdentityToStringStrBuilder1242() { 
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
public void testNotEqual1256() { 
     assertFalse("ObjectUtils.notEqual(null, null) returned false", ObjectUtils.notEqual(null, null)); 
     assertTrue("ObjectUtils.notEqual(\"foo\", null) returned true", ObjectUtils.notEqual(FOO, null)); 
     assertTrue("ObjectUtils.notEqual(null, \"bar\") returned true", ObjectUtils.notEqual(null, BAR)); 
     assertTrue("ObjectUtils.notEqual(\"foo\", \"bar\") returned true", ObjectUtils.notEqual(FOO, BAR)); 
     assertFalse("ObjectUtils.notEqual(\"foo\", \"foo\") returned false", ObjectUtils.notEqual(FOO, FOO)); 
 }
@Test
public void testMin1265() { 
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
public void testHashCodeMulti_multiple_emptyArray1365() { 
     final Object[] array = new Object[0]; 
     assertEquals(1, ObjectUtils.hashCodeMulti(array)); 
 }
@Test
public void testMax1481() { 
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
public void testIdentityToStringStringBuffer1593() { 
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
public void testCloneOfStringArray1701() { 
     assertTrue(Arrays.deepEquals(new String[] { "string" }, ObjectUtils.clone(new String[] { "string" }))); 
 } 
@SuppressWarnings("cast")
@Test
public void testNull1892() { 
     assertNotNull(ObjectUtils.NULL); 
     assertTrue(ObjectUtils.NULL instanceof ObjectUtils.Null); 
     assertSame(ObjectUtils.NULL, SerializationUtils.clone(ObjectUtils.NULL)); 
 }
@Test
public void testMax1974() { 
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
public void testCloneOfPrimitiveArray2032() { 
     assertTrue(Arrays.equals(new int[] { 1 }, ObjectUtils.clone(new int[] { 1 }))); 
 }
@Test
public void testMin2194() { 
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
@Test(expected = NullPointerException.class) 
 public void testMedian_nullItems2295() { 
     ObjectUtils.median((String[]) null); 
 }
@Test
public void testMedian2398() { 
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
public void testHashCodeMulti_multiple_emptyArray2444() { 
     final Object[] array = new Object[0]; 
     assertEquals(1, ObjectUtils.hashCodeMulti(array)); 
 }
@Test
public void testCompare2482() { 
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
public void testIdentityToStringAppendable2571() { 
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
public void testMax2745() { 
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
public void testMax2759() { 
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
public void testMedian2885() { 
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
public void testCloneOfStringArray2897() { 
     assertTrue(Arrays.deepEquals(new String[] { "string" }, ObjectUtils.clone(new String[] { "string" }))); 
 }
@Test
public void testNotEqual3086() { 
     assertFalse("ObjectUtils.notEqual(null, null) returned false", ObjectUtils.notEqual(null, null)); 
     assertTrue("ObjectUtils.notEqual(\"foo\", null) returned true", ObjectUtils.notEqual(FOO, null)); 
     assertTrue("ObjectUtils.notEqual(null, \"bar\") returned true", ObjectUtils.notEqual(null, BAR)); 
     assertTrue("ObjectUtils.notEqual(\"foo\", \"bar\") returned true", ObjectUtils.notEqual(FOO, BAR)); 
     assertFalse("ObjectUtils.notEqual(\"foo\", \"foo\") returned false", ObjectUtils.notEqual(FOO, FOO)); 
 }
@Test
public void testMin3221() { 
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
public void testNotEqual3228() { 
     assertFalse("ObjectUtils.notEqual(null, null) returned false", ObjectUtils.notEqual(null, null)); 
     assertTrue("ObjectUtils.notEqual(\"foo\", null) returned true", ObjectUtils.notEqual(FOO, null)); 
     assertTrue("ObjectUtils.notEqual(null, \"bar\") returned true", ObjectUtils.notEqual(null, BAR)); 
     assertTrue("ObjectUtils.notEqual(\"foo\", \"bar\") returned true", ObjectUtils.notEqual(FOO, BAR)); 
     assertFalse("ObjectUtils.notEqual(\"foo\", \"foo\") returned false", ObjectUtils.notEqual(FOO, FOO)); 
 }
@Test
public void testMax3245() { 
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
public void testCloneOfStringArray3331() { 
     assertTrue(Arrays.deepEquals(new String[] { "string" }, ObjectUtils.clone(new String[] { "string" }))); 
 }
@Test
public void testConstructor3406() { 
     assertNotNull(new ObjectUtils()); 
     final Constructor<?>[] cons = ObjectUtils.class.getDeclaredConstructors(); 
     assertEquals(1, cons.length); 
     assertTrue(Modifier.isPublic(cons[0].getModifiers())); 
     assertTrue(Modifier.isPublic(ObjectUtils.class.getModifiers())); 
     assertFalse(Modifier.isFinal(ObjectUtils.class.getModifiers())); 
 }
@Test
public void testHashCode3537() { 
     assertEquals(0, ObjectUtils.hashCode(null)); 
     assertEquals("a".hashCode(), ObjectUtils.hashCode("a")); 
 }
@Test
public void testMin3622() { 
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
public void testToString_Object3651() { 
     assertEquals("", ObjectUtils.toString((Object) null)); 
     assertEquals(Boolean.TRUE.toString(), ObjectUtils.toString(Boolean.TRUE)); 
 }
@Test
public void testIdentityToStringStrBuilder3687() { 
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
@Test(expected = NullPointerException.class) 
 public void testComparatorMedian_nullItems3757() { 
     ObjectUtils.median(new CharSequenceComparator(), (CharSequence[]) null); 
 }
@Test
public void testNotEqual3908() { 
     assertFalse("ObjectUtils.notEqual(null, null) returned false", ObjectUtils.notEqual(null, null)); 
     assertTrue("ObjectUtils.notEqual(\"foo\", null) returned true", ObjectUtils.notEqual(FOO, null)); 
     assertTrue("ObjectUtils.notEqual(null, \"bar\") returned true", ObjectUtils.notEqual(null, BAR)); 
     assertTrue("ObjectUtils.notEqual(\"foo\", \"bar\") returned true", ObjectUtils.notEqual(FOO, BAR)); 
     assertFalse("ObjectUtils.notEqual(\"foo\", \"foo\") returned false", ObjectUtils.notEqual(FOO, FOO)); 
 }
@Test
public void testConstructor4016() { 
     assertNotNull(new ObjectUtils()); 
     final Constructor<?>[] cons = ObjectUtils.class.getDeclaredConstructors(); 
     assertEquals(1, cons.length); 
     assertTrue(Modifier.isPublic(cons[0].getModifiers())); 
     assertTrue(Modifier.isPublic(ObjectUtils.class.getModifiers())); 
     assertFalse(Modifier.isFinal(ObjectUtils.class.getModifiers())); 
 }
@Test
public void testMin4047() { 
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
public void testComparatorMedian4107() { 
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
public void testHashCodeMulti_multiple_emptyArray4110() { 
     final Object[] array = new Object[0]; 
     assertEquals(1, ObjectUtils.hashCodeMulti(array)); 
 }
@Test
public void testConstMethods4118() { 
     assertTrue("CONST(boolean)", ObjectUtils.CONST(true)); 
     assertEquals("CONST(byte)", (byte) 3, ObjectUtils.CONST((byte) 3)); 
     assertEquals("CONST(char)", (char) 3, ObjectUtils.CONST((char) 3)); 
     assertEquals("CONST(short)", (short) 3, ObjectUtils.CONST((short) 3)); 
     assertEquals("CONST(int)", 3, ObjectUtils.CONST(3)); 
     assertEquals("CONST(long)", 3l, ObjectUtils.CONST(3l)); 
     assertEquals("CONST(float)", 3f, ObjectUtils.CONST(3f), 0); 
     assertEquals("CONST(double)", 3.0, ObjectUtils.CONST(3.0), 0); 
     assertEquals("CONST(Object)", "abc", ObjectUtils.CONST("abc")); 
     final boolean MAGIC_FLAG = ObjectUtils.CONST(true); 
     final byte MAGIC_BYTE1 = ObjectUtils.CONST((byte) 127); 
     final byte MAGIC_BYTE2 = ObjectUtils.CONST_BYTE(127); 
     final char MAGIC_CHAR = ObjectUtils.CONST('a'); 
     final short MAGIC_SHORT1 = ObjectUtils.CONST((short) 123); 
     final short MAGIC_SHORT2 = ObjectUtils.CONST_SHORT(127); 
     final int MAGIC_INT = ObjectUtils.CONST(123); 
     final long MAGIC_LONG1 = ObjectUtils.CONST(123L); 
     final long MAGIC_LONG2 = ObjectUtils.CONST(3); 
     final float MAGIC_FLOAT = ObjectUtils.CONST(1.0f); 
     final double MAGIC_DOUBLE = ObjectUtils.CONST(1.0); 
     final String MAGIC_STRING = ObjectUtils.CONST("abc"); 
     assertTrue(MAGIC_FLAG); 
     assertEquals(127, MAGIC_BYTE1); 
     assertEquals(127, MAGIC_BYTE2); 
     assertEquals('a', MAGIC_CHAR); 
     assertEquals(123, MAGIC_SHORT1); 
     assertEquals(127, MAGIC_SHORT2); 
     assertEquals(123, MAGIC_INT); 
     assertEquals(123, MAGIC_LONG1); 
     assertEquals(3, MAGIC_LONG2); 
     assertEquals(1.0f, MAGIC_FLOAT, 0.0f); 
     assertEquals(1.0, MAGIC_DOUBLE, 0.0); 
     assertEquals("abc", MAGIC_STRING); 
     try { 
         ObjectUtils.CONST_BYTE(-129); 
         fail("CONST_BYTE(-129): IllegalArgumentException should have been thrown."); 
     } catch (final IllegalArgumentException iae) { 
     } 
     try { 
         ObjectUtils.CONST_BYTE(128); 
         fail("CONST_BYTE(128): IllegalArgumentException should have been thrown."); 
     } catch (final IllegalArgumentException iae) { 
     } 
     try { 
         ObjectUtils.CONST_SHORT(-32769); 
         fail("CONST_SHORT(-32769): IllegalArgumentException should have been thrown."); 
     } catch (final IllegalArgumentException iae) { 
     } 
     try { 
         ObjectUtils.CONST_BYTE(32768); 
         fail("CONST_SHORT(32768): IllegalArgumentException should have been thrown."); 
     } catch (final IllegalArgumentException iae) { 
     } 
 }
@Test
public void testIsNull4187() { 
     final Object o = FOO; 
     final Object dflt = BAR; 
     assertSame("dflt was not returned when o was null", dflt, ObjectUtils.defaultIfNull(null, dflt)); 
     assertSame("dflt was returned when o was not null", o, ObjectUtils.defaultIfNull(o, dflt)); 
 }
@Test
public void testPossibleCloneOfNotCloneable4215() { 
     final String string = new String("apache"); 
     assertSame(string, ObjectUtils.cloneIfPossible(string)); 
 }
@Test
public void testFirstNonNull4310() { 
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
@Test
public void testNotEqual4400() { 
     assertFalse("ObjectUtils.notEqual(null, null) returned false", ObjectUtils.notEqual(null, null)); 
     assertTrue("ObjectUtils.notEqual(\"foo\", null) returned true", ObjectUtils.notEqual(FOO, null)); 
     assertTrue("ObjectUtils.notEqual(null, \"bar\") returned true", ObjectUtils.notEqual(null, BAR)); 
     assertTrue("ObjectUtils.notEqual(\"foo\", \"bar\") returned true", ObjectUtils.notEqual(FOO, BAR)); 
     assertFalse("ObjectUtils.notEqual(\"foo\", \"foo\") returned false", ObjectUtils.notEqual(FOO, FOO)); 
 }
@Test
public void testConstMethods4416() { 
     assertTrue("CONST(boolean)", ObjectUtils.CONST(true)); 
     assertEquals("CONST(byte)", (byte) 3, ObjectUtils.CONST((byte) 3)); 
     assertEquals("CONST(char)", (char) 3, ObjectUtils.CONST((char) 3)); 
     assertEquals("CONST(short)", (short) 3, ObjectUtils.CONST((short) 3)); 
     assertEquals("CONST(int)", 3, ObjectUtils.CONST(3)); 
     assertEquals("CONST(long)", 3l, ObjectUtils.CONST(3l)); 
     assertEquals("CONST(float)", 3f, ObjectUtils.CONST(3f), 0); 
     assertEquals("CONST(double)", 3.0, ObjectUtils.CONST(3.0), 0); 
     assertEquals("CONST(Object)", "abc", ObjectUtils.CONST("abc")); 
     final boolean MAGIC_FLAG = ObjectUtils.CONST(true); 
     final byte MAGIC_BYTE1 = ObjectUtils.CONST((byte) 127); 
     final byte MAGIC_BYTE2 = ObjectUtils.CONST_BYTE(127); 
     final char MAGIC_CHAR = ObjectUtils.CONST('a'); 
     final short MAGIC_SHORT1 = ObjectUtils.CONST((short) 123); 
     final short MAGIC_SHORT2 = ObjectUtils.CONST_SHORT(127); 
     final int MAGIC_INT = ObjectUtils.CONST(123); 
     final long MAGIC_LONG1 = ObjectUtils.CONST(123L); 
     final long MAGIC_LONG2 = ObjectUtils.CONST(3); 
     final float MAGIC_FLOAT = ObjectUtils.CONST(1.0f); 
     final double MAGIC_DOUBLE = ObjectUtils.CONST(1.0); 
     final String MAGIC_STRING = ObjectUtils.CONST("abc"); 
     assertTrue(MAGIC_FLAG); 
     assertEquals(127, MAGIC_BYTE1); 
     assertEquals(127, MAGIC_BYTE2); 
     assertEquals('a', MAGIC_CHAR); 
     assertEquals(123, MAGIC_SHORT1); 
     assertEquals(127, MAGIC_SHORT2); 
     assertEquals(123, MAGIC_INT); 
     assertEquals(123, MAGIC_LONG1); 
     assertEquals(3, MAGIC_LONG2); 
     assertEquals(1.0f, MAGIC_FLOAT, 0.0f); 
     assertEquals(1.0, MAGIC_DOUBLE, 0.0); 
     assertEquals("abc", MAGIC_STRING); 
     try { 
         ObjectUtils.CONST_BYTE(-129); 
         fail("CONST_BYTE(-129): IllegalArgumentException should have been thrown."); 
     } catch (final IllegalArgumentException iae) { 
     } 
     try { 
         ObjectUtils.CONST_BYTE(128); 
         fail("CONST_BYTE(128): IllegalArgumentException should have been thrown."); 
     } catch (final IllegalArgumentException iae) { 
     } 
     try { 
         ObjectUtils.CONST_SHORT(-32769); 
         fail("CONST_SHORT(-32769): IllegalArgumentException should have been thrown."); 
     } catch (final IllegalArgumentException iae) { 
     } 
     try { 
         ObjectUtils.CONST_BYTE(32768); 
         fail("CONST_SHORT(32768): IllegalArgumentException should have been thrown."); 
     } catch (final IllegalArgumentException iae) { 
     } 
 }
@Test
public void testConstMethods4428() { 
     assertTrue("CONST(boolean)", ObjectUtils.CONST(true)); 
     assertEquals("CONST(byte)", (byte) 3, ObjectUtils.CONST((byte) 3)); 
     assertEquals("CONST(char)", (char) 3, ObjectUtils.CONST((char) 3)); 
     assertEquals("CONST(short)", (short) 3, ObjectUtils.CONST((short) 3)); 
     assertEquals("CONST(int)", 3, ObjectUtils.CONST(3)); 
     assertEquals("CONST(long)", 3l, ObjectUtils.CONST(3l)); 
     assertEquals("CONST(float)", 3f, ObjectUtils.CONST(3f), 0); 
     assertEquals("CONST(double)", 3.0, ObjectUtils.CONST(3.0), 0); 
     assertEquals("CONST(Object)", "abc", ObjectUtils.CONST("abc")); 
     final boolean MAGIC_FLAG = ObjectUtils.CONST(true); 
     final byte MAGIC_BYTE1 = ObjectUtils.CONST((byte) 127); 
     final byte MAGIC_BYTE2 = ObjectUtils.CONST_BYTE(127); 
     final char MAGIC_CHAR = ObjectUtils.CONST('a'); 
     final short MAGIC_SHORT1 = ObjectUtils.CONST((short) 123); 
     final short MAGIC_SHORT2 = ObjectUtils.CONST_SHORT(127); 
     final int MAGIC_INT = ObjectUtils.CONST(123); 
     final long MAGIC_LONG1 = ObjectUtils.CONST(123L); 
     final long MAGIC_LONG2 = ObjectUtils.CONST(3); 
     final float MAGIC_FLOAT = ObjectUtils.CONST(1.0f); 
     final double MAGIC_DOUBLE = ObjectUtils.CONST(1.0); 
     final String MAGIC_STRING = ObjectUtils.CONST("abc"); 
     assertTrue(MAGIC_FLAG); 
     assertEquals(127, MAGIC_BYTE1); 
     assertEquals(127, MAGIC_BYTE2); 
     assertEquals('a', MAGIC_CHAR); 
     assertEquals(123, MAGIC_SHORT1); 
     assertEquals(127, MAGIC_SHORT2); 
     assertEquals(123, MAGIC_INT); 
     assertEquals(123, MAGIC_LONG1); 
     assertEquals(3, MAGIC_LONG2); 
     assertEquals(1.0f, MAGIC_FLOAT, 0.0f); 
     assertEquals(1.0, MAGIC_DOUBLE, 0.0); 
     assertEquals("abc", MAGIC_STRING); 
     try { 
         ObjectUtils.CONST_BYTE(-129); 
         fail("CONST_BYTE(-129): IllegalArgumentException should have been thrown."); 
     } catch (final IllegalArgumentException iae) { 
     } 
     try { 
         ObjectUtils.CONST_BYTE(128); 
         fail("CONST_BYTE(128): IllegalArgumentException should have been thrown."); 
     } catch (final IllegalArgumentException iae) { 
     } 
     try { 
         ObjectUtils.CONST_SHORT(-32769); 
         fail("CONST_SHORT(-32769): IllegalArgumentException should have been thrown."); 
     } catch (final IllegalArgumentException iae) { 
     } 
     try { 
         ObjectUtils.CONST_BYTE(32768); 
         fail("CONST_SHORT(32768): IllegalArgumentException should have been thrown."); 
     } catch (final IllegalArgumentException iae) { 
     } 
 }
@Test
public void testIdentityToStringStrBuilder4504() { 
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
public void testMax4532() { 
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
public void testIdentityToStringStringBuffer4543() { 
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
public void testMin4812() { 
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
public void testConstMethods5025() { 
     assertTrue("CONST(boolean)", ObjectUtils.CONST(true)); 
     assertEquals("CONST(byte)", (byte) 3, ObjectUtils.CONST((byte) 3)); 
     assertEquals("CONST(char)", (char) 3, ObjectUtils.CONST((char) 3)); 
     assertEquals("CONST(short)", (short) 3, ObjectUtils.CONST((short) 3)); 
     assertEquals("CONST(int)", 3, ObjectUtils.CONST(3)); 
     assertEquals("CONST(long)", 3l, ObjectUtils.CONST(3l)); 
     assertEquals("CONST(float)", 3f, ObjectUtils.CONST(3f), 0); 
     assertEquals("CONST(double)", 3.0, ObjectUtils.CONST(3.0), 0); 
     assertEquals("CONST(Object)", "abc", ObjectUtils.CONST("abc")); 
     final boolean MAGIC_FLAG = ObjectUtils.CONST(true); 
     final byte MAGIC_BYTE1 = ObjectUtils.CONST((byte) 127); 
     final byte MAGIC_BYTE2 = ObjectUtils.CONST_BYTE(127); 
     final char MAGIC_CHAR = ObjectUtils.CONST('a'); 
     final short MAGIC_SHORT1 = ObjectUtils.CONST((short) 123); 
     final short MAGIC_SHORT2 = ObjectUtils.CONST_SHORT(127); 
     final int MAGIC_INT = ObjectUtils.CONST(123); 
     final long MAGIC_LONG1 = ObjectUtils.CONST(123L); 
     final long MAGIC_LONG2 = ObjectUtils.CONST(3); 
     final float MAGIC_FLOAT = ObjectUtils.CONST(1.0f); 
     final double MAGIC_DOUBLE = ObjectUtils.CONST(1.0); 
     final String MAGIC_STRING = ObjectUtils.CONST("abc"); 
     assertTrue(MAGIC_FLAG); 
     assertEquals(127, MAGIC_BYTE1); 
     assertEquals(127, MAGIC_BYTE2); 
     assertEquals('a', MAGIC_CHAR); 
     assertEquals(123, MAGIC_SHORT1); 
     assertEquals(127, MAGIC_SHORT2); 
     assertEquals(123, MAGIC_INT); 
     assertEquals(123, MAGIC_LONG1); 
     assertEquals(3, MAGIC_LONG2); 
     assertEquals(1.0f, MAGIC_FLOAT, 0.0f); 
     assertEquals(1.0, MAGIC_DOUBLE, 0.0); 
     assertEquals("abc", MAGIC_STRING); 
     try { 
         ObjectUtils.CONST_BYTE(-129); 
         fail("CONST_BYTE(-129): IllegalArgumentException should have been thrown."); 
     } catch (final IllegalArgumentException iae) { 
     } 
     try { 
         ObjectUtils.CONST_BYTE(128); 
         fail("CONST_BYTE(128): IllegalArgumentException should have been thrown."); 
     } catch (final IllegalArgumentException iae) { 
     } 
     try { 
         ObjectUtils.CONST_SHORT(-32769); 
         fail("CONST_SHORT(-32769): IllegalArgumentException should have been thrown."); 
     } catch (final IllegalArgumentException iae) { 
     } 
     try { 
         ObjectUtils.CONST_BYTE(32768); 
         fail("CONST_SHORT(32768): IllegalArgumentException should have been thrown."); 
     } catch (final IllegalArgumentException iae) { 
     } 
 }
@Test
public void testFirstNonNull5040() { 
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
@Test
public void testComparatorMedian5137() { 
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
public void testFirstNonNull5163() { 
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
@Test
public void testMax5246() { 
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
public void testFirstNonNull5447() { 
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
@Test
public void testConstMethods5530() { 
     assertTrue("CONST(boolean)", ObjectUtils.CONST(true)); 
     assertEquals("CONST(byte)", (byte) 3, ObjectUtils.CONST((byte) 3)); 
     assertEquals("CONST(char)", (char) 3, ObjectUtils.CONST((char) 3)); 
     assertEquals("CONST(short)", (short) 3, ObjectUtils.CONST((short) 3)); 
     assertEquals("CONST(int)", 3, ObjectUtils.CONST(3)); 
     assertEquals("CONST(long)", 3l, ObjectUtils.CONST(3l)); 
     assertEquals("CONST(float)", 3f, ObjectUtils.CONST(3f), 0); 
     assertEquals("CONST(double)", 3.0, ObjectUtils.CONST(3.0), 0); 
     assertEquals("CONST(Object)", "abc", ObjectUtils.CONST("abc")); 
     final boolean MAGIC_FLAG = ObjectUtils.CONST(true); 
     final byte MAGIC_BYTE1 = ObjectUtils.CONST((byte) 127); 
     final byte MAGIC_BYTE2 = ObjectUtils.CONST_BYTE(127); 
     final char MAGIC_CHAR = ObjectUtils.CONST('a'); 
     final short MAGIC_SHORT1 = ObjectUtils.CONST((short) 123); 
     final short MAGIC_SHORT2 = ObjectUtils.CONST_SHORT(127); 
     final int MAGIC_INT = ObjectUtils.CONST(123); 
     final long MAGIC_LONG1 = ObjectUtils.CONST(123L); 
     final long MAGIC_LONG2 = ObjectUtils.CONST(3); 
     final float MAGIC_FLOAT = ObjectUtils.CONST(1.0f); 
     final double MAGIC_DOUBLE = ObjectUtils.CONST(1.0); 
     final String MAGIC_STRING = ObjectUtils.CONST("abc"); 
     assertTrue(MAGIC_FLAG); 
     assertEquals(127, MAGIC_BYTE1); 
     assertEquals(127, MAGIC_BYTE2); 
     assertEquals('a', MAGIC_CHAR); 
     assertEquals(123, MAGIC_SHORT1); 
     assertEquals(127, MAGIC_SHORT2); 
     assertEquals(123, MAGIC_INT); 
     assertEquals(123, MAGIC_LONG1); 
     assertEquals(3, MAGIC_LONG2); 
     assertEquals(1.0f, MAGIC_FLOAT, 0.0f); 
     assertEquals(1.0, MAGIC_DOUBLE, 0.0); 
     assertEquals("abc", MAGIC_STRING); 
     try { 
         ObjectUtils.CONST_BYTE(-129); 
         fail("CONST_BYTE(-129): IllegalArgumentException should have been thrown."); 
     } catch (final IllegalArgumentException iae) { 
     } 
     try { 
         ObjectUtils.CONST_BYTE(128); 
         fail("CONST_BYTE(128): IllegalArgumentException should have been thrown."); 
     } catch (final IllegalArgumentException iae) { 
     } 
     try { 
         ObjectUtils.CONST_SHORT(-32769); 
         fail("CONST_SHORT(-32769): IllegalArgumentException should have been thrown."); 
     } catch (final IllegalArgumentException iae) { 
     } 
     try { 
         ObjectUtils.CONST_BYTE(32768); 
         fail("CONST_SHORT(32768): IllegalArgumentException should have been thrown."); 
     } catch (final IllegalArgumentException iae) { 
     } 
 }
@Test
public void testCloneOfPrimitiveArray5595() { 
     assertTrue(Arrays.equals(new int[] { 1 }, ObjectUtils.clone(new int[] { 1 }))); 
 }
@Test
public void testConstMethods5717() { 
     assertTrue("CONST(boolean)", ObjectUtils.CONST(true)); 
     assertEquals("CONST(byte)", (byte) 3, ObjectUtils.CONST((byte) 3)); 
     assertEquals("CONST(char)", (char) 3, ObjectUtils.CONST((char) 3)); 
     assertEquals("CONST(short)", (short) 3, ObjectUtils.CONST((short) 3)); 
     assertEquals("CONST(int)", 3, ObjectUtils.CONST(3)); 
     assertEquals("CONST(long)", 3l, ObjectUtils.CONST(3l)); 
     assertEquals("CONST(float)", 3f, ObjectUtils.CONST(3f), 0); 
     assertEquals("CONST(double)", 3.0, ObjectUtils.CONST(3.0), 0); 
     assertEquals("CONST(Object)", "abc", ObjectUtils.CONST("abc")); 
     final boolean MAGIC_FLAG = ObjectUtils.CONST(true); 
     final byte MAGIC_BYTE1 = ObjectUtils.CONST((byte) 127); 
     final byte MAGIC_BYTE2 = ObjectUtils.CONST_BYTE(127); 
     final char MAGIC_CHAR = ObjectUtils.CONST('a'); 
     final short MAGIC_SHORT1 = ObjectUtils.CONST((short) 123); 
     final short MAGIC_SHORT2 = ObjectUtils.CONST_SHORT(127); 
     final int MAGIC_INT = ObjectUtils.CONST(123); 
     final long MAGIC_LONG1 = ObjectUtils.CONST(123L); 
     final long MAGIC_LONG2 = ObjectUtils.CONST(3); 
     final float MAGIC_FLOAT = ObjectUtils.CONST(1.0f); 
     final double MAGIC_DOUBLE = ObjectUtils.CONST(1.0); 
     final String MAGIC_STRING = ObjectUtils.CONST("abc"); 
     assertTrue(MAGIC_FLAG); 
     assertEquals(127, MAGIC_BYTE1); 
     assertEquals(127, MAGIC_BYTE2); 
     assertEquals('a', MAGIC_CHAR); 
     assertEquals(123, MAGIC_SHORT1); 
     assertEquals(127, MAGIC_SHORT2); 
     assertEquals(123, MAGIC_INT); 
     assertEquals(123, MAGIC_LONG1); 
     assertEquals(3, MAGIC_LONG2); 
     assertEquals(1.0f, MAGIC_FLOAT, 0.0f); 
     assertEquals(1.0, MAGIC_DOUBLE, 0.0); 
     assertEquals("abc", MAGIC_STRING); 
     try { 
         ObjectUtils.CONST_BYTE(-129); 
         fail("CONST_BYTE(-129): IllegalArgumentException should have been thrown."); 
     } catch (final IllegalArgumentException iae) { 
     } 
     try { 
         ObjectUtils.CONST_BYTE(128); 
         fail("CONST_BYTE(128): IllegalArgumentException should have been thrown."); 
     } catch (final IllegalArgumentException iae) { 
     } 
     try { 
         ObjectUtils.CONST_SHORT(-32769); 
         fail("CONST_SHORT(-32769): IllegalArgumentException should have been thrown."); 
     } catch (final IllegalArgumentException iae) { 
     } 
     try { 
         ObjectUtils.CONST_BYTE(32768); 
         fail("CONST_SHORT(32768): IllegalArgumentException should have been thrown."); 
     } catch (final IllegalArgumentException iae) { 
     } 
 }
@Test
public void testMax5819() { 
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
public void testHashCodeMulti_multiple_emptyArray5890() { 
     final Object[] array = new Object[0]; 
     assertEquals(1, ObjectUtils.hashCodeMulti(array)); 
 }
@Test
public void testConstMethods5927() { 
     assertTrue("CONST(boolean)", ObjectUtils.CONST(true)); 
     assertEquals("CONST(byte)", (byte) 3, ObjectUtils.CONST((byte) 3)); 
     assertEquals("CONST(char)", (char) 3, ObjectUtils.CONST((char) 3)); 
     assertEquals("CONST(short)", (short) 3, ObjectUtils.CONST((short) 3)); 
     assertEquals("CONST(int)", 3, ObjectUtils.CONST(3)); 
     assertEquals("CONST(long)", 3l, ObjectUtils.CONST(3l)); 
     assertEquals("CONST(float)", 3f, ObjectUtils.CONST(3f), 0); 
     assertEquals("CONST(double)", 3.0, ObjectUtils.CONST(3.0), 0); 
     assertEquals("CONST(Object)", "abc", ObjectUtils.CONST("abc")); 
     final boolean MAGIC_FLAG = ObjectUtils.CONST(true); 
     final byte MAGIC_BYTE1 = ObjectUtils.CONST((byte) 127); 
     final byte MAGIC_BYTE2 = ObjectUtils.CONST_BYTE(127); 
     final char MAGIC_CHAR = ObjectUtils.CONST('a'); 
     final short MAGIC_SHORT1 = ObjectUtils.CONST((short) 123); 
     final short MAGIC_SHORT2 = ObjectUtils.CONST_SHORT(127); 
     final int MAGIC_INT = ObjectUtils.CONST(123); 
     final long MAGIC_LONG1 = ObjectUtils.CONST(123L); 
     final long MAGIC_LONG2 = ObjectUtils.CONST(3); 
     final float MAGIC_FLOAT = ObjectUtils.CONST(1.0f); 
     final double MAGIC_DOUBLE = ObjectUtils.CONST(1.0); 
     final String MAGIC_STRING = ObjectUtils.CONST("abc"); 
     assertTrue(MAGIC_FLAG); 
     assertEquals(127, MAGIC_BYTE1); 
     assertEquals(127, MAGIC_BYTE2); 
     assertEquals('a', MAGIC_CHAR); 
     assertEquals(123, MAGIC_SHORT1); 
     assertEquals(127, MAGIC_SHORT2); 
     assertEquals(123, MAGIC_INT); 
     assertEquals(123, MAGIC_LONG1); 
     assertEquals(3, MAGIC_LONG2); 
     assertEquals(1.0f, MAGIC_FLOAT, 0.0f); 
     assertEquals(1.0, MAGIC_DOUBLE, 0.0); 
     assertEquals("abc", MAGIC_STRING); 
     try { 
         ObjectUtils.CONST_BYTE(-129); 
         fail("CONST_BYTE(-129): IllegalArgumentException should have been thrown."); 
     } catch (final IllegalArgumentException iae) { 
     } 
     try { 
         ObjectUtils.CONST_BYTE(128); 
         fail("CONST_BYTE(128): IllegalArgumentException should have been thrown."); 
     } catch (final IllegalArgumentException iae) { 
     } 
     try { 
         ObjectUtils.CONST_SHORT(-32769); 
         fail("CONST_SHORT(-32769): IllegalArgumentException should have been thrown."); 
     } catch (final IllegalArgumentException iae) { 
     } 
     try { 
         ObjectUtils.CONST_BYTE(32768); 
         fail("CONST_SHORT(32768): IllegalArgumentException should have been thrown."); 
     } catch (final IllegalArgumentException iae) { 
     } 
 }
@Test
public void testPossibleCloneOfCloneable5930() { 
     final CloneableString string = new CloneableString("apache"); 
     final CloneableString stringClone = ObjectUtils.cloneIfPossible(string); 
     assertEquals("apache", stringClone.getValue()); 
 }
@Test
public void testCompare6009() { 
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
public void testCloneOfPrimitiveArray6239() { 
     assertTrue(Arrays.equals(new int[] { 1 }, ObjectUtils.clone(new int[] { 1 }))); 
 }
@Test
public void testConstMethods6247() { 
     assertTrue("CONST(boolean)", ObjectUtils.CONST(true)); 
     assertEquals("CONST(byte)", (byte) 3, ObjectUtils.CONST((byte) 3)); 
     assertEquals("CONST(char)", (char) 3, ObjectUtils.CONST((char) 3)); 
     assertEquals("CONST(short)", (short) 3, ObjectUtils.CONST((short) 3)); 
     assertEquals("CONST(int)", 3, ObjectUtils.CONST(3)); 
     assertEquals("CONST(long)", 3l, ObjectUtils.CONST(3l)); 
     assertEquals("CONST(float)", 3f, ObjectUtils.CONST(3f), 0); 
     assertEquals("CONST(double)", 3.0, ObjectUtils.CONST(3.0), 0); 
     assertEquals("CONST(Object)", "abc", ObjectUtils.CONST("abc")); 
     final boolean MAGIC_FLAG = ObjectUtils.CONST(true); 
     final byte MAGIC_BYTE1 = ObjectUtils.CONST((byte) 127); 
     final byte MAGIC_BYTE2 = ObjectUtils.CONST_BYTE(127); 
     final char MAGIC_CHAR = ObjectUtils.CONST('a'); 
     final short MAGIC_SHORT1 = ObjectUtils.CONST((short) 123); 
     final short MAGIC_SHORT2 = ObjectUtils.CONST_SHORT(127); 
     final int MAGIC_INT = ObjectUtils.CONST(123); 
     final long MAGIC_LONG1 = ObjectUtils.CONST(123L); 
     final long MAGIC_LONG2 = ObjectUtils.CONST(3); 
     final float MAGIC_FLOAT = ObjectUtils.CONST(1.0f); 
     final double MAGIC_DOUBLE = ObjectUtils.CONST(1.0); 
     final String MAGIC_STRING = ObjectUtils.CONST("abc"); 
     assertTrue(MAGIC_FLAG); 
     assertEquals(127, MAGIC_BYTE1); 
     assertEquals(127, MAGIC_BYTE2); 
     assertEquals('a', MAGIC_CHAR); 
     assertEquals(123, MAGIC_SHORT1); 
     assertEquals(127, MAGIC_SHORT2); 
     assertEquals(123, MAGIC_INT); 
     assertEquals(123, MAGIC_LONG1); 
     assertEquals(3, MAGIC_LONG2); 
     assertEquals(1.0f, MAGIC_FLOAT, 0.0f); 
     assertEquals(1.0, MAGIC_DOUBLE, 0.0); 
     assertEquals("abc", MAGIC_STRING); 
     try { 
         ObjectUtils.CONST_BYTE(-129); 
         fail("CONST_BYTE(-129): IllegalArgumentException should have been thrown."); 
     } catch (final IllegalArgumentException iae) { 
     } 
     try { 
         ObjectUtils.CONST_BYTE(128); 
         fail("CONST_BYTE(128): IllegalArgumentException should have been thrown."); 
     } catch (final IllegalArgumentException iae) { 
     } 
     try { 
         ObjectUtils.CONST_SHORT(-32769); 
         fail("CONST_SHORT(-32769): IllegalArgumentException should have been thrown."); 
     } catch (final IllegalArgumentException iae) { 
     } 
     try { 
         ObjectUtils.CONST_BYTE(32768); 
         fail("CONST_SHORT(32768): IllegalArgumentException should have been thrown."); 
     } catch (final IllegalArgumentException iae) { 
     } 
 }
@Test
public void testConstMethods6334() { 
     assertTrue("CONST(boolean)", ObjectUtils.CONST(true)); 
     assertEquals("CONST(byte)", (byte) 3, ObjectUtils.CONST((byte) 3)); 
     assertEquals("CONST(char)", (char) 3, ObjectUtils.CONST((char) 3)); 
     assertEquals("CONST(short)", (short) 3, ObjectUtils.CONST((short) 3)); 
     assertEquals("CONST(int)", 3, ObjectUtils.CONST(3)); 
     assertEquals("CONST(long)", 3l, ObjectUtils.CONST(3l)); 
     assertEquals("CONST(float)", 3f, ObjectUtils.CONST(3f), 0); 
     assertEquals("CONST(double)", 3.0, ObjectUtils.CONST(3.0), 0); 
     assertEquals("CONST(Object)", "abc", ObjectUtils.CONST("abc")); 
     final boolean MAGIC_FLAG = ObjectUtils.CONST(true); 
     final byte MAGIC_BYTE1 = ObjectUtils.CONST((byte) 127); 
     final byte MAGIC_BYTE2 = ObjectUtils.CONST_BYTE(127); 
     final char MAGIC_CHAR = ObjectUtils.CONST('a'); 
     final short MAGIC_SHORT1 = ObjectUtils.CONST((short) 123); 
     final short MAGIC_SHORT2 = ObjectUtils.CONST_SHORT(127); 
     final int MAGIC_INT = ObjectUtils.CONST(123); 
     final long MAGIC_LONG1 = ObjectUtils.CONST(123L); 
     final long MAGIC_LONG2 = ObjectUtils.CONST(3); 
     final float MAGIC_FLOAT = ObjectUtils.CONST(1.0f); 
     final double MAGIC_DOUBLE = ObjectUtils.CONST(1.0); 
     final String MAGIC_STRING = ObjectUtils.CONST("abc"); 
     assertTrue(MAGIC_FLAG); 
     assertEquals(127, MAGIC_BYTE1); 
     assertEquals(127, MAGIC_BYTE2); 
     assertEquals('a', MAGIC_CHAR); 
     assertEquals(123, MAGIC_SHORT1); 
     assertEquals(127, MAGIC_SHORT2); 
     assertEquals(123, MAGIC_INT); 
     assertEquals(123, MAGIC_LONG1); 
     assertEquals(3, MAGIC_LONG2); 
     assertEquals(1.0f, MAGIC_FLOAT, 0.0f); 
     assertEquals(1.0, MAGIC_DOUBLE, 0.0); 
     assertEquals("abc", MAGIC_STRING); 
     try { 
         ObjectUtils.CONST_BYTE(-129); 
         fail("CONST_BYTE(-129): IllegalArgumentException should have been thrown."); 
     } catch (final IllegalArgumentException iae) { 
     } 
     try { 
         ObjectUtils.CONST_BYTE(128); 
         fail("CONST_BYTE(128): IllegalArgumentException should have been thrown."); 
     } catch (final IllegalArgumentException iae) { 
     } 
     try { 
         ObjectUtils.CONST_SHORT(-32769); 
         fail("CONST_SHORT(-32769): IllegalArgumentException should have been thrown."); 
     } catch (final IllegalArgumentException iae) { 
     } 
     try { 
         ObjectUtils.CONST_BYTE(32768); 
         fail("CONST_SHORT(32768): IllegalArgumentException should have been thrown."); 
     } catch (final IllegalArgumentException iae) { 
     } 
 }
@Test
public void testNotEqual6351() { 
     assertFalse("ObjectUtils.notEqual(null, null) returned false", ObjectUtils.notEqual(null, null)); 
     assertTrue("ObjectUtils.notEqual(\"foo\", null) returned true", ObjectUtils.notEqual(FOO, null)); 
     assertTrue("ObjectUtils.notEqual(null, \"bar\") returned true", ObjectUtils.notEqual(null, BAR)); 
     assertTrue("ObjectUtils.notEqual(\"foo\", \"bar\") returned true", ObjectUtils.notEqual(FOO, BAR)); 
     assertFalse("ObjectUtils.notEqual(\"foo\", \"foo\") returned false", ObjectUtils.notEqual(FOO, FOO)); 
 }
@Test
public void testHashCodeMulti_multiple_likeList6411() { 
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
public void testMax6477() { 
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
public void testComparatorMedian6524() { 
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
public void testNotEqual6554() { 
     assertFalse("ObjectUtils.notEqual(null, null) returned false", ObjectUtils.notEqual(null, null)); 
     assertTrue("ObjectUtils.notEqual(\"foo\", null) returned true", ObjectUtils.notEqual(FOO, null)); 
     assertTrue("ObjectUtils.notEqual(null, \"bar\") returned true", ObjectUtils.notEqual(null, BAR)); 
     assertTrue("ObjectUtils.notEqual(\"foo\", \"bar\") returned true", ObjectUtils.notEqual(FOO, BAR)); 
     assertFalse("ObjectUtils.notEqual(\"foo\", \"foo\") returned false", ObjectUtils.notEqual(FOO, FOO)); 
 }
@Test
public void testCloneOfPrimitiveArray6574() { 
     assertTrue(Arrays.equals(new int[] { 1 }, ObjectUtils.clone(new int[] { 1 }))); 
 }
@Test
public void testComparatorMedian6708() { 
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
public void testToString_ObjectString6729() { 
     assertEquals(BAR, ObjectUtils.toString((Object) null, BAR)); 
     assertEquals(Boolean.TRUE.toString(), ObjectUtils.toString(Boolean.TRUE, BAR)); 
 }
@Test
public void testConstMethods6771() { 
     assertTrue("CONST(boolean)", ObjectUtils.CONST(true)); 
     assertEquals("CONST(byte)", (byte) 3, ObjectUtils.CONST((byte) 3)); 
     assertEquals("CONST(char)", (char) 3, ObjectUtils.CONST((char) 3)); 
     assertEquals("CONST(short)", (short) 3, ObjectUtils.CONST((short) 3)); 
     assertEquals("CONST(int)", 3, ObjectUtils.CONST(3)); 
     assertEquals("CONST(long)", 3l, ObjectUtils.CONST(3l)); 
     assertEquals("CONST(float)", 3f, ObjectUtils.CONST(3f), 0); 
     assertEquals("CONST(double)", 3.0, ObjectUtils.CONST(3.0), 0); 
     assertEquals("CONST(Object)", "abc", ObjectUtils.CONST("abc")); 
     final boolean MAGIC_FLAG = ObjectUtils.CONST(true); 
     final byte MAGIC_BYTE1 = ObjectUtils.CONST((byte) 127); 
     final byte MAGIC_BYTE2 = ObjectUtils.CONST_BYTE(127); 
     final char MAGIC_CHAR = ObjectUtils.CONST('a'); 
     final short MAGIC_SHORT1 = ObjectUtils.CONST((short) 123); 
     final short MAGIC_SHORT2 = ObjectUtils.CONST_SHORT(127); 
     final int MAGIC_INT = ObjectUtils.CONST(123); 
     final long MAGIC_LONG1 = ObjectUtils.CONST(123L); 
     final long MAGIC_LONG2 = ObjectUtils.CONST(3); 
     final float MAGIC_FLOAT = ObjectUtils.CONST(1.0f); 
     final double MAGIC_DOUBLE = ObjectUtils.CONST(1.0); 
     final String MAGIC_STRING = ObjectUtils.CONST("abc"); 
     assertTrue(MAGIC_FLAG); 
     assertEquals(127, MAGIC_BYTE1); 
     assertEquals(127, MAGIC_BYTE2); 
     assertEquals('a', MAGIC_CHAR); 
     assertEquals(123, MAGIC_SHORT1); 
     assertEquals(127, MAGIC_SHORT2); 
     assertEquals(123, MAGIC_INT); 
     assertEquals(123, MAGIC_LONG1); 
     assertEquals(3, MAGIC_LONG2); 
     assertEquals(1.0f, MAGIC_FLOAT, 0.0f); 
     assertEquals(1.0, MAGIC_DOUBLE, 0.0); 
     assertEquals("abc", MAGIC_STRING); 
     try { 
         ObjectUtils.CONST_BYTE(-129); 
         fail("CONST_BYTE(-129): IllegalArgumentException should have been thrown."); 
     } catch (final IllegalArgumentException iae) { 
     } 
     try { 
         ObjectUtils.CONST_BYTE(128); 
         fail("CONST_BYTE(128): IllegalArgumentException should have been thrown."); 
     } catch (final IllegalArgumentException iae) { 
     } 
     try { 
         ObjectUtils.CONST_SHORT(-32769); 
         fail("CONST_SHORT(-32769): IllegalArgumentException should have been thrown."); 
     } catch (final IllegalArgumentException iae) { 
     } 
     try { 
         ObjectUtils.CONST_BYTE(32768); 
         fail("CONST_SHORT(32768): IllegalArgumentException should have been thrown."); 
     } catch (final IllegalArgumentException iae) { 
     } 
 }
@Test
public void testIdentityToStringStrBuilder6791() { 
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
public void testNotEqual7024() { 
     assertFalse("ObjectUtils.notEqual(null, null) returned false", ObjectUtils.notEqual(null, null)); 
     assertTrue("ObjectUtils.notEqual(\"foo\", null) returned true", ObjectUtils.notEqual(FOO, null)); 
     assertTrue("ObjectUtils.notEqual(null, \"bar\") returned true", ObjectUtils.notEqual(null, BAR)); 
     assertTrue("ObjectUtils.notEqual(\"foo\", \"bar\") returned true", ObjectUtils.notEqual(FOO, BAR)); 
     assertFalse("ObjectUtils.notEqual(\"foo\", \"foo\") returned false", ObjectUtils.notEqual(FOO, FOO)); 
 }
@Test
public void testComparatorMedian7234() { 
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
public void testMax7289() { 
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
public void testConstMethods7449() { 
     assertTrue("CONST(boolean)", ObjectUtils.CONST(true)); 
     assertEquals("CONST(byte)", (byte) 3, ObjectUtils.CONST((byte) 3)); 
     assertEquals("CONST(char)", (char) 3, ObjectUtils.CONST((char) 3)); 
     assertEquals("CONST(short)", (short) 3, ObjectUtils.CONST((short) 3)); 
     assertEquals("CONST(int)", 3, ObjectUtils.CONST(3)); 
     assertEquals("CONST(long)", 3l, ObjectUtils.CONST(3l)); 
     assertEquals("CONST(float)", 3f, ObjectUtils.CONST(3f), 0); 
     assertEquals("CONST(double)", 3.0, ObjectUtils.CONST(3.0), 0); 
     assertEquals("CONST(Object)", "abc", ObjectUtils.CONST("abc")); 
     final boolean MAGIC_FLAG = ObjectUtils.CONST(true); 
     final byte MAGIC_BYTE1 = ObjectUtils.CONST((byte) 127); 
     final byte MAGIC_BYTE2 = ObjectUtils.CONST_BYTE(127); 
     final char MAGIC_CHAR = ObjectUtils.CONST('a'); 
     final short MAGIC_SHORT1 = ObjectUtils.CONST((short) 123); 
     final short MAGIC_SHORT2 = ObjectUtils.CONST_SHORT(127); 
     final int MAGIC_INT = ObjectUtils.CONST(123); 
     final long MAGIC_LONG1 = ObjectUtils.CONST(123L); 
     final long MAGIC_LONG2 = ObjectUtils.CONST(3); 
     final float MAGIC_FLOAT = ObjectUtils.CONST(1.0f); 
     final double MAGIC_DOUBLE = ObjectUtils.CONST(1.0); 
     final String MAGIC_STRING = ObjectUtils.CONST("abc"); 
     assertTrue(MAGIC_FLAG); 
     assertEquals(127, MAGIC_BYTE1); 
     assertEquals(127, MAGIC_BYTE2); 
     assertEquals('a', MAGIC_CHAR); 
     assertEquals(123, MAGIC_SHORT1); 
     assertEquals(127, MAGIC_SHORT2); 
     assertEquals(123, MAGIC_INT); 
     assertEquals(123, MAGIC_LONG1); 
     assertEquals(3, MAGIC_LONG2); 
     assertEquals(1.0f, MAGIC_FLOAT, 0.0f); 
     assertEquals(1.0, MAGIC_DOUBLE, 0.0); 
     assertEquals("abc", MAGIC_STRING); 
     try { 
         ObjectUtils.CONST_BYTE(-129); 
         fail("CONST_BYTE(-129): IllegalArgumentException should have been thrown."); 
     } catch (final IllegalArgumentException iae) { 
     } 
     try { 
         ObjectUtils.CONST_BYTE(128); 
         fail("CONST_BYTE(128): IllegalArgumentException should have been thrown."); 
     } catch (final IllegalArgumentException iae) { 
     } 
     try { 
         ObjectUtils.CONST_SHORT(-32769); 
         fail("CONST_SHORT(-32769): IllegalArgumentException should have been thrown."); 
     } catch (final IllegalArgumentException iae) { 
     } 
     try { 
         ObjectUtils.CONST_BYTE(32768); 
         fail("CONST_SHORT(32768): IllegalArgumentException should have been thrown."); 
     } catch (final IllegalArgumentException iae) { 
     } 
 }
@Test
public void testFirstNonNull7491() { 
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
@Test
public void testMax7662() { 
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
public void testConstMethods7717() { 
     assertTrue("CONST(boolean)", ObjectUtils.CONST(true)); 
     assertEquals("CONST(byte)", (byte) 3, ObjectUtils.CONST((byte) 3)); 
     assertEquals("CONST(char)", (char) 3, ObjectUtils.CONST((char) 3)); 
     assertEquals("CONST(short)", (short) 3, ObjectUtils.CONST((short) 3)); 
     assertEquals("CONST(int)", 3, ObjectUtils.CONST(3)); 
     assertEquals("CONST(long)", 3l, ObjectUtils.CONST(3l)); 
     assertEquals("CONST(float)", 3f, ObjectUtils.CONST(3f), 0); 
     assertEquals("CONST(double)", 3.0, ObjectUtils.CONST(3.0), 0); 
     assertEquals("CONST(Object)", "abc", ObjectUtils.CONST("abc")); 
     final boolean MAGIC_FLAG = ObjectUtils.CONST(true); 
     final byte MAGIC_BYTE1 = ObjectUtils.CONST((byte) 127); 
     final byte MAGIC_BYTE2 = ObjectUtils.CONST_BYTE(127); 
     final char MAGIC_CHAR = ObjectUtils.CONST('a'); 
     final short MAGIC_SHORT1 = ObjectUtils.CONST((short) 123); 
     final short MAGIC_SHORT2 = ObjectUtils.CONST_SHORT(127); 
     final int MAGIC_INT = ObjectUtils.CONST(123); 
     final long MAGIC_LONG1 = ObjectUtils.CONST(123L); 
     final long MAGIC_LONG2 = ObjectUtils.CONST(3); 
     final float MAGIC_FLOAT = ObjectUtils.CONST(1.0f); 
     final double MAGIC_DOUBLE = ObjectUtils.CONST(1.0); 
     final String MAGIC_STRING = ObjectUtils.CONST("abc"); 
     assertTrue(MAGIC_FLAG); 
     assertEquals(127, MAGIC_BYTE1); 
     assertEquals(127, MAGIC_BYTE2); 
     assertEquals('a', MAGIC_CHAR); 
     assertEquals(123, MAGIC_SHORT1); 
     assertEquals(127, MAGIC_SHORT2); 
     assertEquals(123, MAGIC_INT); 
     assertEquals(123, MAGIC_LONG1); 
     assertEquals(3, MAGIC_LONG2); 
     assertEquals(1.0f, MAGIC_FLOAT, 0.0f); 
     assertEquals(1.0, MAGIC_DOUBLE, 0.0); 
     assertEquals("abc", MAGIC_STRING); 
     try { 
         ObjectUtils.CONST_BYTE(-129); 
         fail("CONST_BYTE(-129): IllegalArgumentException should have been thrown."); 
     } catch (final IllegalArgumentException iae) { 
     } 
     try { 
         ObjectUtils.CONST_BYTE(128); 
         fail("CONST_BYTE(128): IllegalArgumentException should have been thrown."); 
     } catch (final IllegalArgumentException iae) { 
     } 
     try { 
         ObjectUtils.CONST_SHORT(-32769); 
         fail("CONST_SHORT(-32769): IllegalArgumentException should have been thrown."); 
     } catch (final IllegalArgumentException iae) { 
     } 
     try { 
         ObjectUtils.CONST_BYTE(32768); 
         fail("CONST_SHORT(32768): IllegalArgumentException should have been thrown."); 
     } catch (final IllegalArgumentException iae) { 
     } 
 }
@Test
public void testPossibleCloneOfCloneable7719() { 
     final CloneableString string = new CloneableString("apache"); 
     final CloneableString stringClone = ObjectUtils.cloneIfPossible(string); 
     assertEquals("apache", stringClone.getValue()); 
 }
@Test
public void testCloneOfStringArray7773() { 
     assertTrue(Arrays.deepEquals(new String[] { "string" }, ObjectUtils.clone(new String[] { "string" }))); 
 }
@Test
public void testCloneOfStringArray7839() { 
     assertTrue(Arrays.deepEquals(new String[] { "string" }, ObjectUtils.clone(new String[] { "string" }))); 
 }
@Test
public void testIdentityToStringAppendable7943() { 
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
public void testConstMethods8093() { 
     assertTrue("CONST(boolean)", ObjectUtils.CONST(true)); 
     assertEquals("CONST(byte)", (byte) 3, ObjectUtils.CONST((byte) 3)); 
     assertEquals("CONST(char)", (char) 3, ObjectUtils.CONST((char) 3)); 
     assertEquals("CONST(short)", (short) 3, ObjectUtils.CONST((short) 3)); 
     assertEquals("CONST(int)", 3, ObjectUtils.CONST(3)); 
     assertEquals("CONST(long)", 3l, ObjectUtils.CONST(3l)); 
     assertEquals("CONST(float)", 3f, ObjectUtils.CONST(3f), 0); 
     assertEquals("CONST(double)", 3.0, ObjectUtils.CONST(3.0), 0); 
     assertEquals("CONST(Object)", "abc", ObjectUtils.CONST("abc")); 
     final boolean MAGIC_FLAG = ObjectUtils.CONST(true); 
     final byte MAGIC_BYTE1 = ObjectUtils.CONST((byte) 127); 
     final byte MAGIC_BYTE2 = ObjectUtils.CONST_BYTE(127); 
     final char MAGIC_CHAR = ObjectUtils.CONST('a'); 
     final short MAGIC_SHORT1 = ObjectUtils.CONST((short) 123); 
     final short MAGIC_SHORT2 = ObjectUtils.CONST_SHORT(127); 
     final int MAGIC_INT = ObjectUtils.CONST(123); 
     final long MAGIC_LONG1 = ObjectUtils.CONST(123L); 
     final long MAGIC_LONG2 = ObjectUtils.CONST(3); 
     final float MAGIC_FLOAT = ObjectUtils.CONST(1.0f); 
     final double MAGIC_DOUBLE = ObjectUtils.CONST(1.0); 
     final String MAGIC_STRING = ObjectUtils.CONST("abc"); 
     assertTrue(MAGIC_FLAG); 
     assertEquals(127, MAGIC_BYTE1); 
     assertEquals(127, MAGIC_BYTE2); 
     assertEquals('a', MAGIC_CHAR); 
     assertEquals(123, MAGIC_SHORT1); 
     assertEquals(127, MAGIC_SHORT2); 
     assertEquals(123, MAGIC_INT); 
     assertEquals(123, MAGIC_LONG1); 
     assertEquals(3, MAGIC_LONG2); 
     assertEquals(1.0f, MAGIC_FLOAT, 0.0f); 
     assertEquals(1.0, MAGIC_DOUBLE, 0.0); 
     assertEquals("abc", MAGIC_STRING); 
     try { 
         ObjectUtils.CONST_BYTE(-129); 
         fail("CONST_BYTE(-129): IllegalArgumentException should have been thrown."); 
     } catch (final IllegalArgumentException iae) { 
     } 
     try { 
         ObjectUtils.CONST_BYTE(128); 
         fail("CONST_BYTE(128): IllegalArgumentException should have been thrown."); 
     } catch (final IllegalArgumentException iae) { 
     } 
     try { 
         ObjectUtils.CONST_SHORT(-32769); 
         fail("CONST_SHORT(-32769): IllegalArgumentException should have been thrown."); 
     } catch (final IllegalArgumentException iae) { 
     } 
     try { 
         ObjectUtils.CONST_BYTE(32768); 
         fail("CONST_SHORT(32768): IllegalArgumentException should have been thrown."); 
     } catch (final IllegalArgumentException iae) { 
     } 
 }
@Test
public void testComparatorMedian8204() { 
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
public void testConstMethods8325() { 
     assertTrue("CONST(boolean)", ObjectUtils.CONST(true)); 
     assertEquals("CONST(byte)", (byte) 3, ObjectUtils.CONST((byte) 3)); 
     assertEquals("CONST(char)", (char) 3, ObjectUtils.CONST((char) 3)); 
     assertEquals("CONST(short)", (short) 3, ObjectUtils.CONST((short) 3)); 
     assertEquals("CONST(int)", 3, ObjectUtils.CONST(3)); 
     assertEquals("CONST(long)", 3l, ObjectUtils.CONST(3l)); 
     assertEquals("CONST(float)", 3f, ObjectUtils.CONST(3f), 0); 
     assertEquals("CONST(double)", 3.0, ObjectUtils.CONST(3.0), 0); 
     assertEquals("CONST(Object)", "abc", ObjectUtils.CONST("abc")); 
     final boolean MAGIC_FLAG = ObjectUtils.CONST(true); 
     final byte MAGIC_BYTE1 = ObjectUtils.CONST((byte) 127); 
     final byte MAGIC_BYTE2 = ObjectUtils.CONST_BYTE(127); 
     final char MAGIC_CHAR = ObjectUtils.CONST('a'); 
     final short MAGIC_SHORT1 = ObjectUtils.CONST((short) 123); 
     final short MAGIC_SHORT2 = ObjectUtils.CONST_SHORT(127); 
     final int MAGIC_INT = ObjectUtils.CONST(123); 
     final long MAGIC_LONG1 = ObjectUtils.CONST(123L); 
     final long MAGIC_LONG2 = ObjectUtils.CONST(3); 
     final float MAGIC_FLOAT = ObjectUtils.CONST(1.0f); 
     final double MAGIC_DOUBLE = ObjectUtils.CONST(1.0); 
     final String MAGIC_STRING = ObjectUtils.CONST("abc"); 
     assertTrue(MAGIC_FLAG); 
     assertEquals(127, MAGIC_BYTE1); 
     assertEquals(127, MAGIC_BYTE2); 
     assertEquals('a', MAGIC_CHAR); 
     assertEquals(123, MAGIC_SHORT1); 
     assertEquals(127, MAGIC_SHORT2); 
     assertEquals(123, MAGIC_INT); 
     assertEquals(123, MAGIC_LONG1); 
     assertEquals(3, MAGIC_LONG2); 
     assertEquals(1.0f, MAGIC_FLOAT, 0.0f); 
     assertEquals(1.0, MAGIC_DOUBLE, 0.0); 
     assertEquals("abc", MAGIC_STRING); 
     try { 
         ObjectUtils.CONST_BYTE(-129); 
         fail("CONST_BYTE(-129): IllegalArgumentException should have been thrown."); 
     } catch (final IllegalArgumentException iae) { 
     } 
     try { 
         ObjectUtils.CONST_BYTE(128); 
         fail("CONST_BYTE(128): IllegalArgumentException should have been thrown."); 
     } catch (final IllegalArgumentException iae) { 
     } 
     try { 
         ObjectUtils.CONST_SHORT(-32769); 
         fail("CONST_SHORT(-32769): IllegalArgumentException should have been thrown."); 
     } catch (final IllegalArgumentException iae) { 
     } 
     try { 
         ObjectUtils.CONST_BYTE(32768); 
         fail("CONST_SHORT(32768): IllegalArgumentException should have been thrown."); 
     } catch (final IllegalArgumentException iae) { 
     } 
 }
@Test
public void testToString_Object8540() { 
     assertEquals("", ObjectUtils.toString((Object) null)); 
     assertEquals(Boolean.TRUE.toString(), ObjectUtils.toString(Boolean.TRUE)); 
 }
@Test
public void testMax8635() { 
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
public void testMin8638() { 
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
public void testConstMethods8656() { 
     assertTrue("CONST(boolean)", ObjectUtils.CONST(true)); 
     assertEquals("CONST(byte)", (byte) 3, ObjectUtils.CONST((byte) 3)); 
     assertEquals("CONST(char)", (char) 3, ObjectUtils.CONST((char) 3)); 
     assertEquals("CONST(short)", (short) 3, ObjectUtils.CONST((short) 3)); 
     assertEquals("CONST(int)", 3, ObjectUtils.CONST(3)); 
     assertEquals("CONST(long)", 3l, ObjectUtils.CONST(3l)); 
     assertEquals("CONST(float)", 3f, ObjectUtils.CONST(3f), 0); 
     assertEquals("CONST(double)", 3.0, ObjectUtils.CONST(3.0), 0); 
     assertEquals("CONST(Object)", "abc", ObjectUtils.CONST("abc")); 
     final boolean MAGIC_FLAG = ObjectUtils.CONST(true); 
     final byte MAGIC_BYTE1 = ObjectUtils.CONST((byte) 127); 
     final byte MAGIC_BYTE2 = ObjectUtils.CONST_BYTE(127); 
     final char MAGIC_CHAR = ObjectUtils.CONST('a'); 
     final short MAGIC_SHORT1 = ObjectUtils.CONST((short) 123); 
     final short MAGIC_SHORT2 = ObjectUtils.CONST_SHORT(127); 
     final int MAGIC_INT = ObjectUtils.CONST(123); 
     final long MAGIC_LONG1 = ObjectUtils.CONST(123L); 
     final long MAGIC_LONG2 = ObjectUtils.CONST(3); 
     final float MAGIC_FLOAT = ObjectUtils.CONST(1.0f); 
     final double MAGIC_DOUBLE = ObjectUtils.CONST(1.0); 
     final String MAGIC_STRING = ObjectUtils.CONST("abc"); 
     assertTrue(MAGIC_FLAG); 
     assertEquals(127, MAGIC_BYTE1); 
     assertEquals(127, MAGIC_BYTE2); 
     assertEquals('a', MAGIC_CHAR); 
     assertEquals(123, MAGIC_SHORT1); 
     assertEquals(127, MAGIC_SHORT2); 
     assertEquals(123, MAGIC_INT); 
     assertEquals(123, MAGIC_LONG1); 
     assertEquals(3, MAGIC_LONG2); 
     assertEquals(1.0f, MAGIC_FLOAT, 0.0f); 
     assertEquals(1.0, MAGIC_DOUBLE, 0.0); 
     assertEquals("abc", MAGIC_STRING); 
     try { 
         ObjectUtils.CONST_BYTE(-129); 
         fail("CONST_BYTE(-129): IllegalArgumentException should have been thrown."); 
     } catch (final IllegalArgumentException iae) { 
     } 
     try { 
         ObjectUtils.CONST_BYTE(128); 
         fail("CONST_BYTE(128): IllegalArgumentException should have been thrown."); 
     } catch (final IllegalArgumentException iae) { 
     } 
     try { 
         ObjectUtils.CONST_SHORT(-32769); 
         fail("CONST_SHORT(-32769): IllegalArgumentException should have been thrown."); 
     } catch (final IllegalArgumentException iae) { 
     } 
     try { 
         ObjectUtils.CONST_BYTE(32768); 
         fail("CONST_SHORT(32768): IllegalArgumentException should have been thrown."); 
     } catch (final IllegalArgumentException iae) { 
     } 
 }
@Test(expected = NullPointerException.class) 
 public void testMedian_nullItems8697() { 
     ObjectUtils.median((String[]) null); 
 }
@Test
public void testIsNull8884() { 
     final Object o = FOO; 
     final Object dflt = BAR; 
     assertSame("dflt was not returned when o was null", dflt, ObjectUtils.defaultIfNull(null, dflt)); 
     assertSame("dflt was returned when o was not null", o, ObjectUtils.defaultIfNull(o, dflt)); 
 } 
@SuppressWarnings("cast")
@Test
public void testNull9066() { 
     assertNotNull(ObjectUtils.NULL); 
     assertTrue(ObjectUtils.NULL instanceof ObjectUtils.Null); 
     assertSame(ObjectUtils.NULL, SerializationUtils.clone(ObjectUtils.NULL)); 
 }
@Test
public void testMedian9188() { 
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
public void testMedian9260() { 
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
public void testToString_ObjectString9381() { 
     assertEquals(BAR, ObjectUtils.toString((Object) null, BAR)); 
     assertEquals(Boolean.TRUE.toString(), ObjectUtils.toString(Boolean.TRUE, BAR)); 
 }
@Test
public void testConstMethods9504() { 
     assertTrue("CONST(boolean)", ObjectUtils.CONST(true)); 
     assertEquals("CONST(byte)", (byte) 3, ObjectUtils.CONST((byte) 3)); 
     assertEquals("CONST(char)", (char) 3, ObjectUtils.CONST((char) 3)); 
     assertEquals("CONST(short)", (short) 3, ObjectUtils.CONST((short) 3)); 
     assertEquals("CONST(int)", 3, ObjectUtils.CONST(3)); 
     assertEquals("CONST(long)", 3l, ObjectUtils.CONST(3l)); 
     assertEquals("CONST(float)", 3f, ObjectUtils.CONST(3f), 0); 
     assertEquals("CONST(double)", 3.0, ObjectUtils.CONST(3.0), 0); 
     assertEquals("CONST(Object)", "abc", ObjectUtils.CONST("abc")); 
     final boolean MAGIC_FLAG = ObjectUtils.CONST(true); 
     final byte MAGIC_BYTE1 = ObjectUtils.CONST((byte) 127); 
     final byte MAGIC_BYTE2 = ObjectUtils.CONST_BYTE(127); 
     final char MAGIC_CHAR = ObjectUtils.CONST('a'); 
     final short MAGIC_SHORT1 = ObjectUtils.CONST((short) 123); 
     final short MAGIC_SHORT2 = ObjectUtils.CONST_SHORT(127); 
     final int MAGIC_INT = ObjectUtils.CONST(123); 
     final long MAGIC_LONG1 = ObjectUtils.CONST(123L); 
     final long MAGIC_LONG2 = ObjectUtils.CONST(3); 
     final float MAGIC_FLOAT = ObjectUtils.CONST(1.0f); 
     final double MAGIC_DOUBLE = ObjectUtils.CONST(1.0); 
     final String MAGIC_STRING = ObjectUtils.CONST("abc"); 
     assertTrue(MAGIC_FLAG); 
     assertEquals(127, MAGIC_BYTE1); 
     assertEquals(127, MAGIC_BYTE2); 
     assertEquals('a', MAGIC_CHAR); 
     assertEquals(123, MAGIC_SHORT1); 
     assertEquals(127, MAGIC_SHORT2); 
     assertEquals(123, MAGIC_INT); 
     assertEquals(123, MAGIC_LONG1); 
     assertEquals(3, MAGIC_LONG2); 
     assertEquals(1.0f, MAGIC_FLOAT, 0.0f); 
     assertEquals(1.0, MAGIC_DOUBLE, 0.0); 
     assertEquals("abc", MAGIC_STRING); 
     try { 
         ObjectUtils.CONST_BYTE(-129); 
         fail("CONST_BYTE(-129): IllegalArgumentException should have been thrown."); 
     } catch (final IllegalArgumentException iae) { 
     } 
     try { 
         ObjectUtils.CONST_BYTE(128); 
         fail("CONST_BYTE(128): IllegalArgumentException should have been thrown."); 
     } catch (final IllegalArgumentException iae) { 
     } 
     try { 
         ObjectUtils.CONST_SHORT(-32769); 
         fail("CONST_SHORT(-32769): IllegalArgumentException should have been thrown."); 
     } catch (final IllegalArgumentException iae) { 
     } 
     try { 
         ObjectUtils.CONST_BYTE(32768); 
         fail("CONST_SHORT(32768): IllegalArgumentException should have been thrown."); 
     } catch (final IllegalArgumentException iae) { 
     } 
 }
@Test
public void testFirstNonNull9535() { 
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
