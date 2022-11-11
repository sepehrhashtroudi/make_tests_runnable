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
public void testClone54() { 
         final CloneFailedException ex = new CloneFailedException("Test"); 
         assertEquals("Test", ex.getMessage()); 
         assertNull(ex.getCause()); 
          
         final CloneFailedException ex2 = new CloneFailedException("Test"); 
         assertEquals("Test", ex2.getMessage()); 
         assertNull(ex2.getCause()); 
          
//         ex = new CloneFailedException(null);
//         assertEquals("Test", ex.getMessage());
//         assertNull(ex.getCause());
          
//         ex = new CloneFailedException("Test", null);
//         assertEquals("Test", ex.getMessage());
//
//         ex = new CloneFailedException("Test", ex);
//         assertEquals("Test", ex.getMessage());
//
//         ex = new CloneFailedException("Test", ex2);
//         assertEquals("Test", ex.getMessage());
//
//         ex = new CloneFailedException("Test", ex);
//         assertEquals("Test", ex.getMessage());
//
//         ex = new CloneFailedException("Test", ex);
//         assertEquals("Test", ex.getMessage());
     }
@Test
public void testIdentityToStringStringBuilder106() { 
         final Integer i = Integer.valueOf(45); 
         final String expected = "java.lang.Integer@" + Integer.toHexString(System.identityHashCode(i)); 
  
         final StringBuilder builder = new StringBuilder(); 
         ObjectUtils.identityToString(builder, i); 
         assertEquals(expected, builder.toString()); 
  
         try { 
             ObjectUtils.identityToString((StringBuilder)null, "tmp"); 
             fail("NullPointerException expected"); 
         } catch(final NullPointerException npe) { 
         } 
          
         try { 
             ObjectUtils.identityToString(new StringBuilder(), null); 
             fail("NullPointerException expected"); 
         } catch(final NullPointerException npe) { 
         } 
          
         try { 
             ObjectUtils.identityToString(new StringBuilder(), "tmp"); 
             fail("NullPointerException expected"); 
         } catch(final NullPointerException npe) { 
         } 
          
         try { 
             ObjectUtils.identityToString(new StringBuilder(), "tmp"); 
             fail("NullPointerException expected"); 
         } catch(final NullPointerException npe) { 
         } 
          
         try { 
             ObjectUtils.identityToString(new StringBuilder(), "tmp"); 
             fail("NullPointerException expected"); 
         } catch(final NullPointerException npe) { 
         } 
     }
@Test
public void testMode259() { 
         assertEquals(null, ObjectUtils.mode(null)); 
         assertEquals(null, ObjectUtils.mode(null, 0)); 
         assertEquals(null, ObjectUtils.mode(null, 1)); 
         assertEquals(null, ObjectUtils.mode(null, 2)); 
          
         assertEquals("foo", ObjectUtils.mode("foo", "bar")); 
         assertEquals("bar", ObjectUtils.mode("foo", "bar", "baz")); 
         assertEquals("baz", ObjectUtils.mode("foo", "bar", "baz", "blah")); 
         assertEquals("blah", ObjectUtils.mode("foo", "bar", "baz", "blah", "wah")); 
         assertEquals(null, ObjectUtils.mode(null, null, "bar", "baz", "wah")); 
         assertEquals(null, ObjectUtils.mode(null, "bar", "baz", "wah", "wah")); 
     }
@Test
public void testMode263() { 
         final Calendar calendar = Calendar.getInstance(); 
         final Date nonNullComparable1 = calendar.getTime(); 
         final Date nonNullComparable2 = calendar.getTime(); 
         final String[] nullAray = null; 
          
         calendar.set( Calendar.YEAR, calendar.get( Calendar.YEAR ) -1 ); 
         final Date minComparable = calendar.getTime(); 
          
         assertNotSame( nonNullComparable1, nonNullComparable2 ); 
          
         assertNull(ObjectUtils.mode( (String) null ) ); 
         assertNull(ObjectUtils.mode( nullAray ) ); 
         assertSame( nonNullComparable1, ObjectUtils.mode( null, nonNullComparable1 ) ); 
         assertSame( nonNullComparable1, ObjectUtils.mode( nonNullComparable1, null ) ); 
         assertSame( nonNullComparable1, ObjectUtils.mode( null, nonNullComparable1, null ) ); 
         assertSame( nonNullComparable1, ObjectUtils.mode( nonNullComparable1, nonNullComparable2 ) ); 
         assertSame( nonNullComparable2, ObjectUtils.mode( nonNullComparable2, nonNullComparable1 ) ); 
         assertSame( nonNullComparable1, ObjectUtils.mode( nonNullComparable1, minComparable ) ); 
         assertSame( nonNullComparable1, ObjectUtils.mode( minComparable, nonNullComparable1 ) ); 
         assertSame( nonNullComparable1, ObjectUtils.mode( null, minComparable, null, nonNullComparable1 ) ); 
  
         assertNull( ObjectUtils.mode((String)null, (String)null) ); 
     }
@Test
public void testMode266() { 
         assertEquals(null, ObjectUtils.mode(null, null)); 
         assertEquals(null, ObjectUtils.mode(null, "any")); 
         assertEquals(null, ObjectUtils.mode(null, "any", null)); 
         assertEquals(null, ObjectUtils.mode(null, null, "any")); 
         assertEquals(null, ObjectUtils.mode(null, "any", "other")); 
         assertEquals("", ObjectUtils.mode("", "any", null)); 
         assertEquals("", ObjectUtils.mode("", "any", "other")); 
         assertEquals("", ObjectUtils.mode("", "any", "other")); 
          
         assertEquals("foo", ObjectUtils.mode("foo", "bar", "baz", "blah")); 
         assertEquals("bar", ObjectUtils.mode("foo", "bar", "baz", "blah")); 
         assertEquals("blah", ObjectUtils.mode("foo", "bar", "baz", "blah")); 
         assertEquals("blah", ObjectUtils.mode("foo", "bar", "baz", "blah")); 
          
         assertEquals("foo", ObjectUtils.mode("foo", "bar", "baz", "blah", "wah")); 
         assertEquals("wah", ObjectUtils.mode("foo", "bar", "baz", "wah")); 
         assertEquals("wah", ObjectUtils.mode("foo", "bar", "baz", "wah")); 
     }
@Test
public void testMode269() { 
         assertEquals(null, ObjectUtils.mode(null, null)); 
         assertEquals(null, ObjectUtils.mode(null, "foo")); 
         assertEquals(null, ObjectUtils.mode(null, "foo", -1)); 
         assertEquals(null, ObjectUtils.mode(null, "foo", 0)); 
         assertEquals(null, ObjectUtils.mode(null, "foo", 1)); 
         assertEquals(null, ObjectUtils.mode(null, "foo", 2)); 
          
         assertEquals("foo", ObjectUtils.mode("foo", null, -1)); 
         assertEquals("foo", ObjectUtils.mode("foo", null, 2)); 
         assertEquals("foo", ObjectUtils.mode("foo", "bar", 0)); 
         assertEquals("foo", ObjectUtils.mode("foo", "bar", -1)); 
         assertEquals("foo", ObjectUtils.mode("foo", "bar", 2)); 
          
         assertEquals("foo", ObjectUtils.mode("foo", "bar", -1)); 
         assertEquals("foo", ObjectUtils.mode("foo", "bar", -2)); 
         assertEquals("foo", ObjectUtils.mode("foo", "bar", 1)); 
         assertEquals("foo", ObjectUtils.mode("foo", "bar", 2, -1)); 
     }
@Test
public void testMode272() { 
         final Calendar calendar = Calendar.getInstance(); 
         final Date nonNullComparable1 = calendar.getTime(); 
         final Date nonNullComparable2 = calendar.getTime(); 
         final String[] nullAray = null; 
          
         calendar.set( Calendar.YEAR, calendar.get( Calendar.YEAR ) -1 ); 
         final Date minComparable = calendar.getTime(); 
          
         assertNotSame( nonNullComparable1, nonNullComparable2 ); 
          
         assertNull(ObjectUtils.mode( (String) null ) ); 
         assertNull(ObjectUtils.mode( nullAray ) ); 
         assertSame( nonNullComparable1, ObjectUtils.mode( null, nonNullComparable1 ) ); 
         assertSame( nonNullComparable1, ObjectUtils.mode( nonNullComparable1, null ) ); 
         assertSame( nonNullComparable1, ObjectUtils.mode( null, nonNullComparable1, null ) ); 
         assertSame( nonNullComparable1, ObjectUtils.mode( nonNullComparable1, nonNullComparable2 ) ); 
         assertSame( nonNullComparable2, ObjectUtils.mode( nonNullComparable2, nonNullComparable1 ) ); 
         assertSame( nonNullComparable1, ObjectUtils.mode( nonNullComparable1, minComparable ) ); 
         assertSame( nonNullComparable1, ObjectUtils.mode( minComparable, nonNullComparable1 ) ); 
         assertSame( nonNullComparable1, ObjectUtils.mode( null, minComparable, null, nonNullComparable1 ) ); 
  
         assertNull( ObjectUtils.mode((String)null, (String)null) ); 
     }
@Test
public void testMode273() { 
         final Calendar calendar = Calendar.getInstance(); 
         final Date nonNullComparable1 = calendar.getTime(); 
         final Date nonNullComparable2 = calendar.getTime(); 
         final String[] nullAray = null; 
          
         calendar.set( Calendar.YEAR, calendar.get( Calendar.YEAR ) -1 ); 
         final Date minComparable = calendar.getTime(); 
          
         assertNotSame( nonNullComparable1, nonNullComparable2 ); 
          
         assertNull(ObjectUtils.mode( (String) null ) ); 
         assertNull(ObjectUtils.mode( nullAray ) ); 
         assertSame( nonNullComparable1, ObjectUtils.mode( null, nonNullComparable1 ) ); 
         assertSame( nonNullComparable1, ObjectUtils.mode( nonNullComparable1, null ) ); 
         assertSame( nonNullComparable1, ObjectUtils.mode( null, nonNullComparable1, null ) ); 
         assertSame( nonNullComparable1, ObjectUtils.mode( nonNullComparable1, nonNullComparable2 ) ); 
         assertSame( nonNullComparable2, ObjectUtils.mode( nonNullComparable2, nonNullComparable1 ) ); 
         assertSame( nonNullComparable1, ObjectUtils.mode( nonNullComparable1, minComparable ) ); 
         assertSame( nonNullComparable1, ObjectUtils.mode( minComparable, nonNullComparable1 ) ); 
         assertSame( nonNullComparable1, ObjectUtils.mode( null, minComparable, null, nonNullComparable1 ) ); 
  
         assertNull( ObjectUtils.mode((String)null, (String)null) ); 
     }
@Test
public void testMode274() { 
         final Calendar calendar = Calendar.getInstance(); 
         final Date nonNullComparable1 = calendar.getTime(); 
         final Date nonNullComparable2 = calendar.getTime(); 
         final String[] nullAray = null; 
          
         calendar.set( Calendar.YEAR, calendar.get( Calendar.YEAR ) -1 ); 
         final Date minComparable = calendar.getTime(); 
          
         assertNotSame( nonNullComparable1, nonNullComparable2 ); 
          
         assertNull(ObjectUtils.mode( (String) null ) ); 
         assertNull(ObjectUtils.mode( nullAray ) ); 
         assertSame( nonNullComparable1, ObjectUtils.mode( null, nonNullComparable1 ) ); 
         assertSame( nonNullComparable1, ObjectUtils.mode( nonNullComparable1, null ) ); 
         assertSame( nonNullComparable1, ObjectUtils.mode( null, nonNullComparable1, null ) ); 
         assertSame( nonNullComparable1, ObjectUtils.mode( nonNullComparable1, nonNullComparable2 ) ); 
         assertSame( nonNullComparable2, ObjectUtils.mode( nonNullComparable2, nonNullComparable1 ) ); 
         assertSame( nonNullComparable1, ObjectUtils.mode( nonNullComparable1, minComparable ) ); 
         assertSame( nonNullComparable1, ObjectUtils.mode( minComparable, nonNullComparable1 ) ); 
         assertSame( nonNullComparable1, ObjectUtils.mode( null, minComparable, null, nonNullComparable1 ) ); 
  
         assertNull( ObjectUtils.mode((String)null, (String)null) ); 
     }
@Test
public void testMode275() { 
         final Calendar calendar = Calendar.getInstance(); 
         final Date nonNullComparable1 = calendar.getTime(); 
         final Date nonNullComparable2 = calendar.getTime(); 
         final String[] nullAray = null; 
          
         calendar.set( Calendar.YEAR, calendar.get( Calendar.YEAR ) -1 ); 
         final Date minComparable = calendar.getTime(); 
          
         assertNotSame( nonNullComparable1, nonNullComparable2 ); 
          
         assertNull(ObjectUtils.mode( (String) null ) ); 
         assertNull(ObjectUtils.mode( nullAray ) ); 
         assertSame( nonNullComparable1, ObjectUtils.mode( null, nonNullComparable1 ) ); 
         assertSame( nonNullComparable1, ObjectUtils.mode( nonNullComparable1, null ) ); 
         assertSame( nonNullComparable1, ObjectUtils.mode( null, nonNullComparable1, null ) ); 
         assertSame( nonNullComparable1, ObjectUtils.mode( nonNullComparable1, nonNullComparable2 ) ); 
         assertSame( nonNullComparable2, ObjectUtils.mode( nonNullComparable2, nonNullComparable1 ) ); 
         assertSame( nonNullComparable1, ObjectUtils.mode( nonNullComparable1, minComparable ) ); 
         assertSame( nonNullComparable1, ObjectUtils.mode( minComparable, nonNullComparable1 ) ); 
         assertSame( nonNullComparable1, ObjectUtils.mode( null, minComparable, null, nonNullComparable1 ) ); 
  
         assertNull( ObjectUtils.mode((String)null, (String)null) ); 
     }
@Test
public void testCloneOfStringArray1805() { 
         assertTrue(Arrays.deepEquals( 
             new String[]{"string"}, ObjectUtils.clone(new String[]{"string"}))); 
     } 
  
     /** 
      * Tests {@link ObjectUtils#clone(Object)} with an array of primitives. 
      */
@Test
public void testCloneOfStringArray1806() { 
         assertTrue(Arrays.deepEquals( 
             new String[]{"string"}, ObjectUtils.clone(new String[]{"string"}))); 
     } 
  
     /** 
      * Tests {@link ObjectUtils#clone(Object)} with an array of primitives. 
      */
@Test
public void testCloneIfPossible1807() { 
         final Calendar calendar = Calendar.getInstance(); 
         final Date nonNullComparable1 = calendar.getTime(); 
         final Date nonNullComparable2 = calendar.getTime(); 
         final String[] nullAray = null; 
          
         calendar.set( Calendar.YEAR, calendar.get( Calendar.YEAR ) -1 ); 
         final Date minComparable = calendar.getTime(); 
          
         assertNotSame( nonNullComparable1, nonNullComparable2 ); 
          
         assertNull(ObjectUtils.cloneIfPossible( (String) null ) ); 
         assertNull(ObjectUtils.cloneIfPossible( nullAray ) ); 
         assertSame( nonNullComparable1, ObjectUtils.cloneIfPossible( null ) ); 
         assertSame( nonNullComparable1, ObjectUtils.cloneIfPossible( nonNullComparable1 ) ); 
//         assertSame( nonNullComparable1, ObjectUtils.cloneIfPossible( null, nonNullComparable1 ) );
//         assertSame( nonNullComparable1, ObjectUtils.cloneIfPossible( nonNullComparable1, null ) );
//         assertSame( nonNullComparable1, ObjectUtils.cloneIfPossible( nonNullComparable1, minComparable ) );
//         assertSame( nonNullComparable1, ObjectUtils.cloneIfPossible( nonNullComparable1, null ) );
////         assertSame( nonNullComparable1, ObjectUtils.cloneIfPossible( nonNullComparable1, maxComparable ) );
////         assertSame( nonNullComparable1, ObjectUtils.cloneIfPossible( nonNullComparable1, maxComparable ) );
//
//         assertNull( ObjectUtils.cloneIfPossible((String)null, (String)null) );
     }
@Test
public void testCloneOfStringArray1808() { 
         assertTrue(Arrays.deepEquals( 
             new String[]{"string"}, ObjectUtils.clone(new String[]{"string"}))); 
     } 
  
     /** 
      * Tests {@link ObjectUtils#clone(Object)} with an array of primitives. 
      */
@Test
public void testCloneIfPossible1809() { 
         final Calendar calendar = Calendar.getInstance(); 
         final Date nonNullComparable1 = calendar.getTime(); 
         final Date nonNullComparable2 = calendar.getTime(); 
         final String[] nullAray = null; 
          
         calendar.set( Calendar.YEAR, calendar.get( Calendar.YEAR ) -1 ); 
         final Date minComparable = calendar.getTime(); 
          
         assertNotSame( nonNullComparable1, nonNullComparable2 ); 
          
         assertNull(ObjectUtils.cloneIfPossible( (String) null ) ); 
         assertNull(ObjectUtils.cloneIfPossible( nullAray ) ); 
         assertSame( nonNullComparable1, ObjectUtils.cloneIfPossible( null ) ); 
         assertSame( nonNullComparable1, ObjectUtils.cloneIfPossible( nonNullComparable1 ) ); 
         assertSame( nonNullComparable1, ObjectUtils.cloneIfPossible( nonNullComparable1 ) ); 
         assertSame( nonNullComparable1, ObjectUtils.cloneIfPossible( nonNullComparable1 ) ); 
//         assertSame( nonNullComparable1, ObjectUtils.cloneIfPossible( null, nonNullComparable1 ) );
//         assertSame( nonNullComparable1, ObjectUtils.cloneIfPossible( nonNullComparable1, null ) );
//         assertSame( nonNullComparable1, ObjectUtils.cloneIfPossible( nonNullComparable1, minComparable ) );
//         assertSame( nonNullComparable1, ObjectUtils.cloneIfPossible( null, minComparable ) );
//
//         assertNull( ObjectUtils.cloneIfPossible((String)null, (String)null) );
     }
@Test
public void testCloneOfStringArray1810() { 
         assertTrue(Arrays.deepEquals( 
             new String[]{"string"}, ObjectUtils.clone(new String[]{"string"}))); 
     } 
  
     /** 
      * Tests {@link ObjectUtils#clone(Object)} with an array of primitives. 
      */
@Test
public void testCloneOfStringArray1811() { 
         assertTrue(Arrays.deepEquals( 
             new String[]{"string"}, ObjectUtils.clone(new String[]{"string"}))); 
     } 
  
     /** 
      * Tests {@link ObjectUtils#clone(Object)} with an array of primitives. 
      */
//@Test
//public void testClone1812() {
//         final CloneFailedException ex = new CloneFailedException(TEST_MESSAGE_2, new Exception(TEST_MESSAGE));
//         assertEquals(TEST_MESSAGE_2, ex.getMessage());
//         assertSame(TEST_MESSAGE_2, ex.getCause());
//     }
@Test
public void testCloneOfStringArray1813() { 
         assertTrue(Arrays.deepEquals( 
             new String[]{"string"}, ObjectUtils.clone(new String[]{"string"}))); 
     } 
  
     /** 
      * Tests {@link ObjectUtils#clone(Object)} with an array of primitives. 
      */
@Test
public void testCloneOfStringArray1814() { 
         assertTrue(Arrays.deepEquals( 
             new String[]{"string"}, ObjectUtils.clone(new String[]{"string"}))); 
     } 
  
     /** 
      * Tests {@link ObjectUtils#clone(Object)} with an array of primitives. 
      */
@Test
public void testIdentityToStringStringBuilder2840() { 
         final Integer i = Integer.valueOf(45); 
         final String expected = "java.lang.Integer@" + Integer.toHexString(System.identityHashCode(i)); 
  
         final StringBuilder builder = new StringBuilder(); 
         ObjectUtils.identityToString(builder, i); 
         assertEquals(expected, builder.toString()); 
  
         try { 
             ObjectUtils.identityToString((StringBuilder)null, "tmp"); 
             fail("NullPointerException expected"); 
         } catch(final NullPointerException npe) { 
         } 
          
         try { 
             ObjectUtils.identityToString(new StringBuilder(), null); 
             fail("NullPointerException expected"); 
         } catch(final NullPointerException npe) { 
         } 
          
         try { 
             ObjectUtils.identityToString(new StringBuilder(), "tmp"); 
             fail("NullPointerException expected"); 
         } catch(final NullPointerException npe) { 
         } 
          
         try { 
             ObjectUtils.identityToString(new StringBuilder(), "tmp"); 
             fail("NullPointerException expected"); 
         } catch(final NullPointerException npe) { 
         } 
          
         try { 
             ObjectUtils.identityToString(new StringBuilder(), "tmp"); 
             fail("NullPointerException expected"); 
         } catch(final NullPointerException npe) { 
         } 
     }
@Test
public void testIdentityToStringStringBuilder2841() { 
         final Integer i = Integer.valueOf(45); 
         final String expected = "java.lang.Integer@" + Integer.toHexString(System.identityHashCode(i)); 
  
         final StringBuilder builder = new StringBuilder(); 
         ObjectUtils.identityToString(builder, i); 
         assertEquals(expected, builder.toString()); 
  
         try { 
             ObjectUtils.identityToString((StringBuilder)null, "tmp"); 
             fail("NullPointerException expected"); 
         } catch(final NullPointerException npe) { 
         } 
          
         try { 
             ObjectUtils.identityToString(new StringBuilder(), null); 
             fail("NullPointerException expected"); 
         } catch(final NullPointerException npe) { 
         } 
          
         try { 
             ObjectUtils.identityToString(new StringBuilder(), "tmp"); 
             fail("NullPointerException expected"); 
         } catch(final NullPointerException npe) { 
         } 
          
         try { 
             ObjectUtils.identityToString(new StringBuilder(), "tmp"); 
             fail("NullPointerException expected"); 
         } catch(final NullPointerException npe) { 
         } 
          
         try { 
             ObjectUtils.identityToString(new StringBuilder(), "tmp"); 
             fail("NullPointerException expected"); 
         } catch(final NullPointerException npe) { 
         } 
     }
@Test
public void testIdentityToString_Object2842() { 
         assertEquals(null, ObjectUtils.identityToString(null)); 
         assertEquals("", ObjectUtils.identityToString("")); 
         assertEquals("foo", ObjectUtils.identityToString("foo")); 
         assertEquals("foo", ObjectUtils.identityToString("foo")); 
     }
@Test
public void testIdentityToString_Object2843() { 
         assertEquals(null, ObjectUtils.identityToString(null)); 
         assertEquals("", ObjectUtils.identityToString("")); 
         assertEquals("abc", ObjectUtils.identityToString("abc")); 
         assertEquals("xyz", ObjectUtils.identityToString("xyz")); 
         assertEquals("i am a robot", ObjectUtils.identityToString("I Am a robot")); 
         assertEquals("i am a machine", ObjectUtils.identityToString("i am a robot")); 
     }
@Test
public void testIdentityToString_Object2844() { 
         assertEquals(null, ObjectUtils.identityToString(null)); 
         assertEquals("", ObjectUtils.identityToString("")); 
         assertEquals("abc", ObjectUtils.identityToString("abc")); 
         assertEquals("xyz", ObjectUtils.identityToString("xyz")); 
         assertEquals("i am a robot", ObjectUtils.identityToString("I Am a robot")); 
         assertEquals("i am a machine", ObjectUtils.identityToString("i am a robot")); 
     }
@Test
public void testIdentityToString_Object2845() { 
         assertEquals(null, ObjectUtils.identityToString(null)); 
         assertEquals("", ObjectUtils.identityToString("")); 
         assertEquals("abc", ObjectUtils.identityToString("abc")); 
         assertEquals("xyz", ObjectUtils.identityToString("xyz")); 
         assertEquals("i am a robot", ObjectUtils.identityToString("I Am a robot")); 
         assertEquals("i am a machine", ObjectUtils.identityToString("i am a robot")); 
     }
@Test
public void testIdentityToStringStringBuilder2846() { 
         final Integer i = Integer.valueOf(45); 
         final String expected = "java.lang.Integer@" + Integer.toHexString(System.identityHashCode(i)); 
  
         final StringBuilder builder = new StringBuilder(); 
         ObjectUtils.identityToString(builder, i); 
         assertEquals(expected, builder.toString()); 
  
         try { 
             ObjectUtils.identityToString((StringBuilder)null, "tmp"); 
             fail("NullPointerException expected"); 
         } catch(final NullPointerException npe) { 
         } 
          
         try { 
             ObjectUtils.identityToString(new StringBuilder(), null); 
             fail("NullPointerException expected"); 
         } catch(final NullPointerException npe) { 
         } 
          
         try { 
             ObjectUtils.identityToString(new StringBuilder(), "tmp"); 
             fail("NullPointerException expected"); 
         } catch(final NullPointerException npe) { 
         } 
          
         try { 
             ObjectUtils.identityToString(new StringBuilder(), "tmp"); 
             fail("NullPointerException expected"); 
         } catch(final NullPointerException npe) { 
         } 
          
         try { 
             ObjectUtils.identityToString(new StringBuilder(), "tmp"); 
             fail("NullPointerException expected"); 
         } catch(final NullPointerException npe) { 
         } 
     }
@Test
public void testIdentityToString_Object2847() { 
         assertEquals(null, ObjectUtils.identityToString(null)); 
         assertEquals("", ObjectUtils.identityToString("")); 
         assertEquals("abc", ObjectUtils.identityToString("abc")); 
         assertEquals("xyz", ObjectUtils.identityToString("xyz")); 
         assertEquals("i am a robot", ObjectUtils.identityToString("I Am a robot")); 
         assertEquals("i am a machine", ObjectUtils.identityToString("i am a robot")); 
     }
@Test
public void testIdentityToString_Object2848() { 
         assertEquals(null, ObjectUtils.identityToString(null)); 
         assertEquals("", ObjectUtils.identityToString("")); 
         assertEquals("abc", ObjectUtils.identityToString("abc")); 
         assertEquals("xyz", ObjectUtils.identityToString("xyz")); 
         assertEquals("i am a robot", ObjectUtils.identityToString("I Am a robot")); 
         assertEquals("i am a machine", ObjectUtils.identityToString("i am a robot")); 
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
