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
package org.apache.commons.lang3.text;

import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;
import static org.apache.commons.lang3.JavaVersion.JAVA_1_4;

import java.text.ChoiceFormat;
import java.text.DateFormat;
import java.text.FieldPosition;
import java.text.Format;
import java.text.MessageFormat;
import java.text.NumberFormat;
import java.text.ParsePosition;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Locale;
import java.util.Map;

import org.apache.commons.lang3.SystemUtils;

/**
 * Test case for {@link ExtendedMessageFormat}.
 *
 * @since 2.4
 * @version $Id$
 */
public class ExtendedMessageFormatTest {

    private final Map<String, FormatFactory> registry = new HashMap<String, FormatFactory>();

    @Before
    public void setUp() throws Exception {
        registry.put("lower", new LowerCaseFormatFactory());
        registry.put("upper", new UpperCaseFormatFactory());
    }

    /**
     * Test extended formats.
     */
@Test
public void testExtendedAndBuiltInFormats16() { 
     final Calendar cal = Calendar.getInstance(); 
     cal.set(2007, Calendar.JANUARY, 23, 18, 33, 05); 
     final Object[] args = new Object[] { "John Doe", cal.getTime(), Double.valueOf("12345.67") }; 
     final String builtinsPattern = "DOB: {1,date,short} Salary: {2,number,currency}"; 
     final String extendedPattern = "Name: {0,upper} "; 
     final String pattern = extendedPattern + builtinsPattern; 
     final HashSet<Locale> testLocales = new HashSet<Locale>(); 
     testLocales.addAll(Arrays.asList(DateFormat.getAvailableLocales())); 
     testLocales.retainAll(Arrays.asList(NumberFormat.getAvailableLocales())); 
     testLocales.add(null); 
     for (final Locale locale : testLocales) { 
         final MessageFormat builtins = createMessageFormat(builtinsPattern, locale); 
         final String expectedPattern = extendedPattern + builtins.toPattern(); 
         DateFormat df = null; 
         NumberFormat nf = null; 
         ExtendedMessageFormat emf = null; 
         if (locale == null) { 
             df = DateFormat.getDateInstance(DateFormat.SHORT); 
             nf = NumberFormat.getCurrencyInstance(); 
             emf = new ExtendedMessageFormat(pattern, registry); 
         } else { 
             df = DateFormat.getDateInstance(DateFormat.SHORT, locale); 
             nf = NumberFormat.getCurrencyInstance(locale); 
             emf = new ExtendedMessageFormat(pattern, locale, registry); 
         } 
         final StringBuilder expected = new StringBuilder(); 
         expected.append("Name: "); 
         expected.append(args[0].toString().toUpperCase()); 
         expected.append(" DOB: "); 
         expected.append(df.format(args[1])); 
         expected.append(" Salary: "); 
         expected.append(nf.format(args[2])); 
         assertPatternsEqual("pattern comparison for locale " + locale, expectedPattern, emf.toPattern()); 
         assertEquals(String.valueOf(locale), expected.toString(), emf.format(args)); 
     } 
 }
@Test
public void testEqualsHashcode391() { 
     final Map<String, ? extends FormatFactory> registry = Collections.singletonMap("testfmt", new LowerCaseFormatFactory()); 
     final Map<String, ? extends FormatFactory> otherRegitry = Collections.singletonMap("testfmt", new UpperCaseFormatFactory()); 
     final String pattern = "Pattern: {0,testfmt}"; 
     final ExtendedMessageFormat emf = new ExtendedMessageFormat(pattern, Locale.US, registry); 
     ExtendedMessageFormat other = null; 
     assertTrue("same, equals()", emf.equals(emf)); 
     assertTrue("same, hashcode()", emf.hashCode() == emf.hashCode()); 
     other = new ExtendedMessageFormat(pattern, Locale.US, registry); 
     assertTrue("equal, equals()", emf.equals(other)); 
     assertTrue("equal, hashcode()", emf.hashCode() == other.hashCode()); 
     other = new OtherExtendedMessageFormat(pattern, Locale.US, registry); 
     assertFalse("class, equals()", emf.equals(other)); 
     assertTrue("class, hashcode()", emf.hashCode() == other.hashCode()); 
     other = new ExtendedMessageFormat("X" + pattern, Locale.US, registry); 
     assertFalse("pattern, equals()", emf.equals(other)); 
     assertFalse("pattern, hashcode()", emf.hashCode() == other.hashCode()); 
     other = new ExtendedMessageFormat(pattern, Locale.US, otherRegitry); 
     assertFalse("registry, equals()", emf.equals(other)); 
     assertFalse("registry, hashcode()", emf.hashCode() == other.hashCode()); 
     other = new ExtendedMessageFormat(pattern, Locale.FRANCE, registry); 
     assertFalse("locale, equals()", emf.equals(other)); 
     assertTrue("locale, hashcode()", emf.hashCode() == other.hashCode()); 
 }
@Test
public void testEqualsHashcode854() { 
     final Map<String, ? extends FormatFactory> registry = Collections.singletonMap("testfmt", new LowerCaseFormatFactory()); 
     final Map<String, ? extends FormatFactory> otherRegitry = Collections.singletonMap("testfmt", new UpperCaseFormatFactory()); 
     final String pattern = "Pattern: {0,testfmt}"; 
     final ExtendedMessageFormat emf = new ExtendedMessageFormat(pattern, Locale.US, registry); 
     ExtendedMessageFormat other = null; 
     assertTrue("same, equals()", emf.equals(emf)); 
     assertTrue("same, hashcode()", emf.hashCode() == emf.hashCode()); 
     other = new ExtendedMessageFormat(pattern, Locale.US, registry); 
     assertTrue("equal, equals()", emf.equals(other)); 
     assertTrue("equal, hashcode()", emf.hashCode() == other.hashCode()); 
     other = new OtherExtendedMessageFormat(pattern, Locale.US, registry); 
     assertFalse("class, equals()", emf.equals(other)); 
     assertTrue("class, hashcode()", emf.hashCode() == other.hashCode()); 
     other = new ExtendedMessageFormat("X" + pattern, Locale.US, registry); 
     assertFalse("pattern, equals()", emf.equals(other)); 
     assertFalse("pattern, hashcode()", emf.hashCode() == other.hashCode()); 
     other = new ExtendedMessageFormat(pattern, Locale.US, otherRegitry); 
     assertFalse("registry, equals()", emf.equals(other)); 
     assertFalse("registry, hashcode()", emf.hashCode() == other.hashCode()); 
     other = new ExtendedMessageFormat(pattern, Locale.FRANCE, registry); 
     assertFalse("locale, equals()", emf.equals(other)); 
     assertTrue("locale, hashcode()", emf.hashCode() == other.hashCode()); 
 }
@Test
public void testEqualsHashcode1057() { 
     final Map<String, ? extends FormatFactory> registry = Collections.singletonMap("testfmt", new LowerCaseFormatFactory()); 
     final Map<String, ? extends FormatFactory> otherRegitry = Collections.singletonMap("testfmt", new UpperCaseFormatFactory()); 
     final String pattern = "Pattern: {0,testfmt}"; 
     final ExtendedMessageFormat emf = new ExtendedMessageFormat(pattern, Locale.US, registry); 
     ExtendedMessageFormat other = null; 
     assertTrue("same, equals()", emf.equals(emf)); 
     assertTrue("same, hashcode()", emf.hashCode() == emf.hashCode()); 
     other = new ExtendedMessageFormat(pattern, Locale.US, registry); 
     assertTrue("equal, equals()", emf.equals(other)); 
     assertTrue("equal, hashcode()", emf.hashCode() == other.hashCode()); 
     other = new OtherExtendedMessageFormat(pattern, Locale.US, registry); 
     assertFalse("class, equals()", emf.equals(other)); 
     assertTrue("class, hashcode()", emf.hashCode() == other.hashCode()); 
     other = new ExtendedMessageFormat("X" + pattern, Locale.US, registry); 
     assertFalse("pattern, equals()", emf.equals(other)); 
     assertFalse("pattern, hashcode()", emf.hashCode() == other.hashCode()); 
     other = new ExtendedMessageFormat(pattern, Locale.US, otherRegitry); 
     assertFalse("registry, equals()", emf.equals(other)); 
     assertFalse("registry, hashcode()", emf.hashCode() == other.hashCode()); 
     other = new ExtendedMessageFormat(pattern, Locale.FRANCE, registry); 
     assertFalse("locale, equals()", emf.equals(other)); 
     assertTrue("locale, hashcode()", emf.hashCode() == other.hashCode()); 
 }
@Test
public void testExtendedAndBuiltInFormats1138() { 
     final Calendar cal = Calendar.getInstance(); 
     cal.set(2007, Calendar.JANUARY, 23, 18, 33, 05); 
     final Object[] args = new Object[] { "John Doe", cal.getTime(), Double.valueOf("12345.67") }; 
     final String builtinsPattern = "DOB: {1,date,short} Salary: {2,number,currency}"; 
     final String extendedPattern = "Name: {0,upper} "; 
     final String pattern = extendedPattern + builtinsPattern; 
     final HashSet<Locale> testLocales = new HashSet<Locale>(); 
     testLocales.addAll(Arrays.asList(DateFormat.getAvailableLocales())); 
     testLocales.retainAll(Arrays.asList(NumberFormat.getAvailableLocales())); 
     testLocales.add(null); 
     for (final Locale locale : testLocales) { 
         final MessageFormat builtins = createMessageFormat(builtinsPattern, locale); 
         final String expectedPattern = extendedPattern + builtins.toPattern(); 
         DateFormat df = null; 
         NumberFormat nf = null; 
         ExtendedMessageFormat emf = null; 
         if (locale == null) { 
             df = DateFormat.getDateInstance(DateFormat.SHORT); 
             nf = NumberFormat.getCurrencyInstance(); 
             emf = new ExtendedMessageFormat(pattern, registry); 
         } else { 
             df = DateFormat.getDateInstance(DateFormat.SHORT, locale); 
             nf = NumberFormat.getCurrencyInstance(locale); 
             emf = new ExtendedMessageFormat(pattern, locale, registry); 
         } 
         final StringBuilder expected = new StringBuilder(); 
         expected.append("Name: "); 
         expected.append(args[0].toString().toUpperCase()); 
         expected.append(" DOB: "); 
         expected.append(df.format(args[1])); 
         expected.append(" Salary: "); 
         expected.append(nf.format(args[2])); 
         assertPatternsEqual("pattern comparison for locale " + locale, expectedPattern, emf.toPattern()); 
         assertEquals(String.valueOf(locale), expected.toString(), emf.format(args)); 
     } 
 }
@Test
public void testEqualsHashcode1956() { 
     final Map<String, ? extends FormatFactory> registry = Collections.singletonMap("testfmt", new LowerCaseFormatFactory()); 
     final Map<String, ? extends FormatFactory> otherRegitry = Collections.singletonMap("testfmt", new UpperCaseFormatFactory()); 
     final String pattern = "Pattern: {0,testfmt}"; 
     final ExtendedMessageFormat emf = new ExtendedMessageFormat(pattern, Locale.US, registry); 
     ExtendedMessageFormat other = null; 
     assertTrue("same, equals()", emf.equals(emf)); 
     assertTrue("same, hashcode()", emf.hashCode() == emf.hashCode()); 
     other = new ExtendedMessageFormat(pattern, Locale.US, registry); 
     assertTrue("equal, equals()", emf.equals(other)); 
     assertTrue("equal, hashcode()", emf.hashCode() == other.hashCode()); 
     other = new OtherExtendedMessageFormat(pattern, Locale.US, registry); 
     assertFalse("class, equals()", emf.equals(other)); 
     assertTrue("class, hashcode()", emf.hashCode() == other.hashCode()); 
     other = new ExtendedMessageFormat("X" + pattern, Locale.US, registry); 
     assertFalse("pattern, equals()", emf.equals(other)); 
     assertFalse("pattern, hashcode()", emf.hashCode() == other.hashCode()); 
     other = new ExtendedMessageFormat(pattern, Locale.US, otherRegitry); 
     assertFalse("registry, equals()", emf.equals(other)); 
     assertFalse("registry, hashcode()", emf.hashCode() == other.hashCode()); 
     other = new ExtendedMessageFormat(pattern, Locale.FRANCE, registry); 
     assertFalse("locale, equals()", emf.equals(other)); 
     assertTrue("locale, hashcode()", emf.hashCode() == other.hashCode()); 
 }
@Test
public void testEscapedQuote_LANG_4772529() { 
     final String pattern = "it''s a {0,lower} 'test'!"; 
     final ExtendedMessageFormat emf = new ExtendedMessageFormat(pattern, registry); 
     assertEquals("it's a dummy test!", emf.format(new Object[] { "DUMMY" })); 
 }
@Test
public void testEqualsHashcode2712() { 
     final Map<String, ? extends FormatFactory> registry = Collections.singletonMap("testfmt", new LowerCaseFormatFactory()); 
     final Map<String, ? extends FormatFactory> otherRegitry = Collections.singletonMap("testfmt", new UpperCaseFormatFactory()); 
     final String pattern = "Pattern: {0,testfmt}"; 
     final ExtendedMessageFormat emf = new ExtendedMessageFormat(pattern, Locale.US, registry); 
     ExtendedMessageFormat other = null; 
     assertTrue("same, equals()", emf.equals(emf)); 
     assertTrue("same, hashcode()", emf.hashCode() == emf.hashCode()); 
     other = new ExtendedMessageFormat(pattern, Locale.US, registry); 
     assertTrue("equal, equals()", emf.equals(other)); 
     assertTrue("equal, hashcode()", emf.hashCode() == other.hashCode()); 
     other = new OtherExtendedMessageFormat(pattern, Locale.US, registry); 
     assertFalse("class, equals()", emf.equals(other)); 
     assertTrue("class, hashcode()", emf.hashCode() == other.hashCode()); 
     other = new ExtendedMessageFormat("X" + pattern, Locale.US, registry); 
     assertFalse("pattern, equals()", emf.equals(other)); 
     assertFalse("pattern, hashcode()", emf.hashCode() == other.hashCode()); 
     other = new ExtendedMessageFormat(pattern, Locale.US, otherRegitry); 
     assertFalse("registry, equals()", emf.equals(other)); 
     assertFalse("registry, hashcode()", emf.hashCode() == other.hashCode()); 
     other = new ExtendedMessageFormat(pattern, Locale.FRANCE, registry); 
     assertFalse("locale, equals()", emf.equals(other)); 
     assertTrue("locale, hashcode()", emf.hashCode() == other.hashCode()); 
 }
@Test
public void testEscapedQuote_LANG_4773138() { 
     final String pattern = "it''s a {0,lower} 'test'!"; 
     final ExtendedMessageFormat emf = new ExtendedMessageFormat(pattern, registry); 
     assertEquals("it's a dummy test!", emf.format(new Object[] { "DUMMY" })); 
 }
@Test
public void testEscapedQuote_LANG_4773208() { 
     final String pattern = "it''s a {0,lower} 'test'!"; 
     final ExtendedMessageFormat emf = new ExtendedMessageFormat(pattern, registry); 
     assertEquals("it's a dummy test!", emf.format(new Object[] { "DUMMY" })); 
 }
@Test
public void testEqualsHashcode3286() { 
     final Map<String, ? extends FormatFactory> registry = Collections.singletonMap("testfmt", new LowerCaseFormatFactory()); 
     final Map<String, ? extends FormatFactory> otherRegitry = Collections.singletonMap("testfmt", new UpperCaseFormatFactory()); 
     final String pattern = "Pattern: {0,testfmt}"; 
     final ExtendedMessageFormat emf = new ExtendedMessageFormat(pattern, Locale.US, registry); 
     ExtendedMessageFormat other = null; 
     assertTrue("same, equals()", emf.equals(emf)); 
     assertTrue("same, hashcode()", emf.hashCode() == emf.hashCode()); 
     other = new ExtendedMessageFormat(pattern, Locale.US, registry); 
     assertTrue("equal, equals()", emf.equals(other)); 
     assertTrue("equal, hashcode()", emf.hashCode() == other.hashCode()); 
     other = new OtherExtendedMessageFormat(pattern, Locale.US, registry); 
     assertFalse("class, equals()", emf.equals(other)); 
     assertTrue("class, hashcode()", emf.hashCode() == other.hashCode()); 
     other = new ExtendedMessageFormat("X" + pattern, Locale.US, registry); 
     assertFalse("pattern, equals()", emf.equals(other)); 
     assertFalse("pattern, hashcode()", emf.hashCode() == other.hashCode()); 
     other = new ExtendedMessageFormat(pattern, Locale.US, otherRegitry); 
     assertFalse("registry, equals()", emf.equals(other)); 
     assertFalse("registry, hashcode()", emf.hashCode() == other.hashCode()); 
     other = new ExtendedMessageFormat(pattern, Locale.FRANCE, registry); 
     assertFalse("locale, equals()", emf.equals(other)); 
     assertTrue("locale, hashcode()", emf.hashCode() == other.hashCode()); 
 }
@Test
public void testEqualsHashcode3590() { 
     final Map<String, ? extends FormatFactory> registry = Collections.singletonMap("testfmt", new LowerCaseFormatFactory()); 
     final Map<String, ? extends FormatFactory> otherRegitry = Collections.singletonMap("testfmt", new UpperCaseFormatFactory()); 
     final String pattern = "Pattern: {0,testfmt}"; 
     final ExtendedMessageFormat emf = new ExtendedMessageFormat(pattern, Locale.US, registry); 
     ExtendedMessageFormat other = null; 
     assertTrue("same, equals()", emf.equals(emf)); 
     assertTrue("same, hashcode()", emf.hashCode() == emf.hashCode()); 
     other = new ExtendedMessageFormat(pattern, Locale.US, registry); 
     assertTrue("equal, equals()", emf.equals(other)); 
     assertTrue("equal, hashcode()", emf.hashCode() == other.hashCode()); 
     other = new OtherExtendedMessageFormat(pattern, Locale.US, registry); 
     assertFalse("class, equals()", emf.equals(other)); 
     assertTrue("class, hashcode()", emf.hashCode() == other.hashCode()); 
     other = new ExtendedMessageFormat("X" + pattern, Locale.US, registry); 
     assertFalse("pattern, equals()", emf.equals(other)); 
     assertFalse("pattern, hashcode()", emf.hashCode() == other.hashCode()); 
     other = new ExtendedMessageFormat(pattern, Locale.US, otherRegitry); 
     assertFalse("registry, equals()", emf.equals(other)); 
     assertFalse("registry, hashcode()", emf.hashCode() == other.hashCode()); 
     other = new ExtendedMessageFormat(pattern, Locale.FRANCE, registry); 
     assertFalse("locale, equals()", emf.equals(other)); 
     assertTrue("locale, hashcode()", emf.hashCode() == other.hashCode()); 
 }
@Test
public void testEqualsHashcode3748() { 
     final Map<String, ? extends FormatFactory> registry = Collections.singletonMap("testfmt", new LowerCaseFormatFactory()); 
     final Map<String, ? extends FormatFactory> otherRegitry = Collections.singletonMap("testfmt", new UpperCaseFormatFactory()); 
     final String pattern = "Pattern: {0,testfmt}"; 
     final ExtendedMessageFormat emf = new ExtendedMessageFormat(pattern, Locale.US, registry); 
     ExtendedMessageFormat other = null; 
     assertTrue("same, equals()", emf.equals(emf)); 
     assertTrue("same, hashcode()", emf.hashCode() == emf.hashCode()); 
     other = new ExtendedMessageFormat(pattern, Locale.US, registry); 
     assertTrue("equal, equals()", emf.equals(other)); 
     assertTrue("equal, hashcode()", emf.hashCode() == other.hashCode()); 
     other = new OtherExtendedMessageFormat(pattern, Locale.US, registry); 
     assertFalse("class, equals()", emf.equals(other)); 
     assertTrue("class, hashcode()", emf.hashCode() == other.hashCode()); 
     other = new ExtendedMessageFormat("X" + pattern, Locale.US, registry); 
     assertFalse("pattern, equals()", emf.equals(other)); 
     assertFalse("pattern, hashcode()", emf.hashCode() == other.hashCode()); 
     other = new ExtendedMessageFormat(pattern, Locale.US, otherRegitry); 
     assertFalse("registry, equals()", emf.equals(other)); 
     assertFalse("registry, hashcode()", emf.hashCode() == other.hashCode()); 
     other = new ExtendedMessageFormat(pattern, Locale.FRANCE, registry); 
     assertFalse("locale, equals()", emf.equals(other)); 
     assertTrue("locale, hashcode()", emf.hashCode() == other.hashCode()); 
 }
@Test
public void testExtendedAndBuiltInFormats4109() { 
     final Calendar cal = Calendar.getInstance(); 
     cal.set(2007, Calendar.JANUARY, 23, 18, 33, 05); 
     final Object[] args = new Object[] { "John Doe", cal.getTime(), Double.valueOf("12345.67") }; 
     final String builtinsPattern = "DOB: {1,date,short} Salary: {2,number,currency}"; 
     final String extendedPattern = "Name: {0,upper} "; 
     final String pattern = extendedPattern + builtinsPattern; 
     final HashSet<Locale> testLocales = new HashSet<Locale>(); 
     testLocales.addAll(Arrays.asList(DateFormat.getAvailableLocales())); 
     testLocales.retainAll(Arrays.asList(NumberFormat.getAvailableLocales())); 
     testLocales.add(null); 
     for (final Locale locale : testLocales) { 
         final MessageFormat builtins = createMessageFormat(builtinsPattern, locale); 
         final String expectedPattern = extendedPattern + builtins.toPattern(); 
         DateFormat df = null; 
         NumberFormat nf = null; 
         ExtendedMessageFormat emf = null; 
         if (locale == null) { 
             df = DateFormat.getDateInstance(DateFormat.SHORT); 
             nf = NumberFormat.getCurrencyInstance(); 
             emf = new ExtendedMessageFormat(pattern, registry); 
         } else { 
             df = DateFormat.getDateInstance(DateFormat.SHORT, locale); 
             nf = NumberFormat.getCurrencyInstance(locale); 
             emf = new ExtendedMessageFormat(pattern, locale, registry); 
         } 
         final StringBuilder expected = new StringBuilder(); 
         expected.append("Name: "); 
         expected.append(args[0].toString().toUpperCase()); 
         expected.append(" DOB: "); 
         expected.append(df.format(args[1])); 
         expected.append(" Salary: "); 
         expected.append(nf.format(args[2])); 
         assertPatternsEqual("pattern comparison for locale " + locale, expectedPattern, emf.toPattern()); 
         assertEquals(String.valueOf(locale), expected.toString(), emf.format(args)); 
     } 
 }
@Test
public void testEscapedQuote_LANG_4774322() { 
     final String pattern = "it''s a {0,lower} 'test'!"; 
     final ExtendedMessageFormat emf = new ExtendedMessageFormat(pattern, registry); 
     assertEquals("it's a dummy test!", emf.format(new Object[] { "DUMMY" })); 
 }
@Test
public void testEscapedQuote_LANG_4774456() { 
     final String pattern = "it''s a {0,lower} 'test'!"; 
     final ExtendedMessageFormat emf = new ExtendedMessageFormat(pattern, registry); 
     assertEquals("it's a dummy test!", emf.format(new Object[] { "DUMMY" })); 
 }
@Test
public void testEscapedQuote_LANG_4774497() { 
     final String pattern = "it''s a {0,lower} 'test'!"; 
     final ExtendedMessageFormat emf = new ExtendedMessageFormat(pattern, registry); 
     assertEquals("it's a dummy test!", emf.format(new Object[] { "DUMMY" })); 
 }
@Test
public void testExtendedAndBuiltInFormats4549() { 
     final Calendar cal = Calendar.getInstance(); 
     cal.set(2007, Calendar.JANUARY, 23, 18, 33, 05); 
     final Object[] args = new Object[] { "John Doe", cal.getTime(), Double.valueOf("12345.67") }; 
     final String builtinsPattern = "DOB: {1,date,short} Salary: {2,number,currency}"; 
     final String extendedPattern = "Name: {0,upper} "; 
     final String pattern = extendedPattern + builtinsPattern; 
     final HashSet<Locale> testLocales = new HashSet<Locale>(); 
     testLocales.addAll(Arrays.asList(DateFormat.getAvailableLocales())); 
     testLocales.retainAll(Arrays.asList(NumberFormat.getAvailableLocales())); 
     testLocales.add(null); 
     for (final Locale locale : testLocales) { 
         final MessageFormat builtins = createMessageFormat(builtinsPattern, locale); 
         final String expectedPattern = extendedPattern + builtins.toPattern(); 
         DateFormat df = null; 
         NumberFormat nf = null; 
         ExtendedMessageFormat emf = null; 
         if (locale == null) { 
             df = DateFormat.getDateInstance(DateFormat.SHORT); 
             nf = NumberFormat.getCurrencyInstance(); 
             emf = new ExtendedMessageFormat(pattern, registry); 
         } else { 
             df = DateFormat.getDateInstance(DateFormat.SHORT, locale); 
             nf = NumberFormat.getCurrencyInstance(locale); 
             emf = new ExtendedMessageFormat(pattern, locale, registry); 
         } 
         final StringBuilder expected = new StringBuilder(); 
         expected.append("Name: "); 
         expected.append(args[0].toString().toUpperCase()); 
         expected.append(" DOB: "); 
         expected.append(df.format(args[1])); 
         expected.append(" Salary: "); 
         expected.append(nf.format(args[2])); 
         assertPatternsEqual("pattern comparison for locale " + locale, expectedPattern, emf.toPattern()); 
         assertEquals(String.valueOf(locale), expected.toString(), emf.format(args)); 
     } 
 }
@Test
public void testEscapedQuote_LANG_4774595() { 
     final String pattern = "it''s a {0,lower} 'test'!"; 
     final ExtendedMessageFormat emf = new ExtendedMessageFormat(pattern, registry); 
     assertEquals("it's a dummy test!", emf.format(new Object[] { "DUMMY" })); 
 }
@Test
public void testEscapedQuote_LANG_4775003() { 
     final String pattern = "it''s a {0,lower} 'test'!"; 
     final ExtendedMessageFormat emf = new ExtendedMessageFormat(pattern, registry); 
     assertEquals("it's a dummy test!", emf.format(new Object[] { "DUMMY" })); 
 }
@Test
public void testEscapedQuote_LANG_4775498() { 
     final String pattern = "it''s a {0,lower} 'test'!"; 
     final ExtendedMessageFormat emf = new ExtendedMessageFormat(pattern, registry); 
     assertEquals("it's a dummy test!", emf.format(new Object[] { "DUMMY" })); 
 }
@Test
public void testEqualsHashcode5627() { 
     final Map<String, ? extends FormatFactory> registry = Collections.singletonMap("testfmt", new LowerCaseFormatFactory()); 
     final Map<String, ? extends FormatFactory> otherRegitry = Collections.singletonMap("testfmt", new UpperCaseFormatFactory()); 
     final String pattern = "Pattern: {0,testfmt}"; 
     final ExtendedMessageFormat emf = new ExtendedMessageFormat(pattern, Locale.US, registry); 
     ExtendedMessageFormat other = null; 
     assertTrue("same, equals()", emf.equals(emf)); 
     assertTrue("same, hashcode()", emf.hashCode() == emf.hashCode()); 
     other = new ExtendedMessageFormat(pattern, Locale.US, registry); 
     assertTrue("equal, equals()", emf.equals(other)); 
     assertTrue("equal, hashcode()", emf.hashCode() == other.hashCode()); 
     other = new OtherExtendedMessageFormat(pattern, Locale.US, registry); 
     assertFalse("class, equals()", emf.equals(other)); 
     assertTrue("class, hashcode()", emf.hashCode() == other.hashCode()); 
     other = new ExtendedMessageFormat("X" + pattern, Locale.US, registry); 
     assertFalse("pattern, equals()", emf.equals(other)); 
     assertFalse("pattern, hashcode()", emf.hashCode() == other.hashCode()); 
     other = new ExtendedMessageFormat(pattern, Locale.US, otherRegitry); 
     assertFalse("registry, equals()", emf.equals(other)); 
     assertFalse("registry, hashcode()", emf.hashCode() == other.hashCode()); 
     other = new ExtendedMessageFormat(pattern, Locale.FRANCE, registry); 
     assertFalse("locale, equals()", emf.equals(other)); 
     assertTrue("locale, hashcode()", emf.hashCode() == other.hashCode()); 
 }
@Test
public void testEqualsHashcode6030() { 
     final Map<String, ? extends FormatFactory> registry = Collections.singletonMap("testfmt", new LowerCaseFormatFactory()); 
     final Map<String, ? extends FormatFactory> otherRegitry = Collections.singletonMap("testfmt", new UpperCaseFormatFactory()); 
     final String pattern = "Pattern: {0,testfmt}"; 
     final ExtendedMessageFormat emf = new ExtendedMessageFormat(pattern, Locale.US, registry); 
     ExtendedMessageFormat other = null; 
     assertTrue("same, equals()", emf.equals(emf)); 
     assertTrue("same, hashcode()", emf.hashCode() == emf.hashCode()); 
     other = new ExtendedMessageFormat(pattern, Locale.US, registry); 
     assertTrue("equal, equals()", emf.equals(other)); 
     assertTrue("equal, hashcode()", emf.hashCode() == other.hashCode()); 
     other = new OtherExtendedMessageFormat(pattern, Locale.US, registry); 
     assertFalse("class, equals()", emf.equals(other)); 
     assertTrue("class, hashcode()", emf.hashCode() == other.hashCode()); 
     other = new ExtendedMessageFormat("X" + pattern, Locale.US, registry); 
     assertFalse("pattern, equals()", emf.equals(other)); 
     assertFalse("pattern, hashcode()", emf.hashCode() == other.hashCode()); 
     other = new ExtendedMessageFormat(pattern, Locale.US, otherRegitry); 
     assertFalse("registry, equals()", emf.equals(other)); 
     assertFalse("registry, hashcode()", emf.hashCode() == other.hashCode()); 
     other = new ExtendedMessageFormat(pattern, Locale.FRANCE, registry); 
     assertFalse("locale, equals()", emf.equals(other)); 
     assertTrue("locale, hashcode()", emf.hashCode() == other.hashCode()); 
 }
@Test
public void testEscapedQuote_LANG_4776571() { 
     final String pattern = "it''s a {0,lower} 'test'!"; 
     final ExtendedMessageFormat emf = new ExtendedMessageFormat(pattern, registry); 
     assertEquals("it's a dummy test!", emf.format(new Object[] { "DUMMY" })); 
 }
@Test
public void testEscapedQuote_LANG_4776804() { 
     final String pattern = "it''s a {0,lower} 'test'!"; 
     final ExtendedMessageFormat emf = new ExtendedMessageFormat(pattern, registry); 
     assertEquals("it's a dummy test!", emf.format(new Object[] { "DUMMY" })); 
 }
@Test
public void testEscapedQuote_LANG_4777010() { 
     final String pattern = "it''s a {0,lower} 'test'!"; 
     final ExtendedMessageFormat emf = new ExtendedMessageFormat(pattern, registry); 
     assertEquals("it's a dummy test!", emf.format(new Object[] { "DUMMY" })); 
 }
@Test
public void testExtendedAndBuiltInFormats7118() { 
     final Calendar cal = Calendar.getInstance(); 
     cal.set(2007, Calendar.JANUARY, 23, 18, 33, 05); 
     final Object[] args = new Object[] { "John Doe", cal.getTime(), Double.valueOf("12345.67") }; 
     final String builtinsPattern = "DOB: {1,date,short} Salary: {2,number,currency}"; 
     final String extendedPattern = "Name: {0,upper} "; 
     final String pattern = extendedPattern + builtinsPattern; 
     final HashSet<Locale> testLocales = new HashSet<Locale>(); 
     testLocales.addAll(Arrays.asList(DateFormat.getAvailableLocales())); 
     testLocales.retainAll(Arrays.asList(NumberFormat.getAvailableLocales())); 
     testLocales.add(null); 
     for (final Locale locale : testLocales) { 
         final MessageFormat builtins = createMessageFormat(builtinsPattern, locale); 
         final String expectedPattern = extendedPattern + builtins.toPattern(); 
         DateFormat df = null; 
         NumberFormat nf = null; 
         ExtendedMessageFormat emf = null; 
         if (locale == null) { 
             df = DateFormat.getDateInstance(DateFormat.SHORT); 
             nf = NumberFormat.getCurrencyInstance(); 
             emf = new ExtendedMessageFormat(pattern, registry); 
         } else { 
             df = DateFormat.getDateInstance(DateFormat.SHORT, locale); 
             nf = NumberFormat.getCurrencyInstance(locale); 
             emf = new ExtendedMessageFormat(pattern, locale, registry); 
         } 
         final StringBuilder expected = new StringBuilder(); 
         expected.append("Name: "); 
         expected.append(args[0].toString().toUpperCase()); 
         expected.append(" DOB: "); 
         expected.append(df.format(args[1])); 
         expected.append(" Salary: "); 
         expected.append(nf.format(args[2])); 
         assertPatternsEqual("pattern comparison for locale " + locale, expectedPattern, emf.toPattern()); 
         assertEquals(String.valueOf(locale), expected.toString(), emf.format(args)); 
     } 
 }
@Test
public void testEqualsHashcode7308() { 
     final Map<String, ? extends FormatFactory> registry = Collections.singletonMap("testfmt", new LowerCaseFormatFactory()); 
     final Map<String, ? extends FormatFactory> otherRegitry = Collections.singletonMap("testfmt", new UpperCaseFormatFactory()); 
     final String pattern = "Pattern: {0,testfmt}"; 
     final ExtendedMessageFormat emf = new ExtendedMessageFormat(pattern, Locale.US, registry); 
     ExtendedMessageFormat other = null; 
     assertTrue("same, equals()", emf.equals(emf)); 
     assertTrue("same, hashcode()", emf.hashCode() == emf.hashCode()); 
     other = new ExtendedMessageFormat(pattern, Locale.US, registry); 
     assertTrue("equal, equals()", emf.equals(other)); 
     assertTrue("equal, hashcode()", emf.hashCode() == other.hashCode()); 
     other = new OtherExtendedMessageFormat(pattern, Locale.US, registry); 
     assertFalse("class, equals()", emf.equals(other)); 
     assertTrue("class, hashcode()", emf.hashCode() == other.hashCode()); 
     other = new ExtendedMessageFormat("X" + pattern, Locale.US, registry); 
     assertFalse("pattern, equals()", emf.equals(other)); 
     assertFalse("pattern, hashcode()", emf.hashCode() == other.hashCode()); 
     other = new ExtendedMessageFormat(pattern, Locale.US, otherRegitry); 
     assertFalse("registry, equals()", emf.equals(other)); 
     assertFalse("registry, hashcode()", emf.hashCode() == other.hashCode()); 
     other = new ExtendedMessageFormat(pattern, Locale.FRANCE, registry); 
     assertFalse("locale, equals()", emf.equals(other)); 
     assertTrue("locale, hashcode()", emf.hashCode() == other.hashCode()); 
 }
@Test
public void testExtendedAndBuiltInFormats7635() { 
     final Calendar cal = Calendar.getInstance(); 
     cal.set(2007, Calendar.JANUARY, 23, 18, 33, 05); 
     final Object[] args = new Object[] { "John Doe", cal.getTime(), Double.valueOf("12345.67") }; 
     final String builtinsPattern = "DOB: {1,date,short} Salary: {2,number,currency}"; 
     final String extendedPattern = "Name: {0,upper} "; 
     final String pattern = extendedPattern + builtinsPattern; 
     final HashSet<Locale> testLocales = new HashSet<Locale>(); 
     testLocales.addAll(Arrays.asList(DateFormat.getAvailableLocales())); 
     testLocales.retainAll(Arrays.asList(NumberFormat.getAvailableLocales())); 
     testLocales.add(null); 
     for (final Locale locale : testLocales) { 
         final MessageFormat builtins = createMessageFormat(builtinsPattern, locale); 
         final String expectedPattern = extendedPattern + builtins.toPattern(); 
         DateFormat df = null; 
         NumberFormat nf = null; 
         ExtendedMessageFormat emf = null; 
         if (locale == null) { 
             df = DateFormat.getDateInstance(DateFormat.SHORT); 
             nf = NumberFormat.getCurrencyInstance(); 
             emf = new ExtendedMessageFormat(pattern, registry); 
         } else { 
             df = DateFormat.getDateInstance(DateFormat.SHORT, locale); 
             nf = NumberFormat.getCurrencyInstance(locale); 
             emf = new ExtendedMessageFormat(pattern, locale, registry); 
         } 
         final StringBuilder expected = new StringBuilder(); 
         expected.append("Name: "); 
         expected.append(args[0].toString().toUpperCase()); 
         expected.append(" DOB: "); 
         expected.append(df.format(args[1])); 
         expected.append(" Salary: "); 
         expected.append(nf.format(args[2])); 
         assertPatternsEqual("pattern comparison for locale " + locale, expectedPattern, emf.toPattern()); 
         assertEquals(String.valueOf(locale), expected.toString(), emf.format(args)); 
     } 
 }
@Test
public void testEqualsHashcode7866() { 
     final Map<String, ? extends FormatFactory> registry = Collections.singletonMap("testfmt", new LowerCaseFormatFactory()); 
     final Map<String, ? extends FormatFactory> otherRegitry = Collections.singletonMap("testfmt", new UpperCaseFormatFactory()); 
     final String pattern = "Pattern: {0,testfmt}"; 
     final ExtendedMessageFormat emf = new ExtendedMessageFormat(pattern, Locale.US, registry); 
     ExtendedMessageFormat other = null; 
     assertTrue("same, equals()", emf.equals(emf)); 
     assertTrue("same, hashcode()", emf.hashCode() == emf.hashCode()); 
     other = new ExtendedMessageFormat(pattern, Locale.US, registry); 
     assertTrue("equal, equals()", emf.equals(other)); 
     assertTrue("equal, hashcode()", emf.hashCode() == other.hashCode()); 
     other = new OtherExtendedMessageFormat(pattern, Locale.US, registry); 
     assertFalse("class, equals()", emf.equals(other)); 
     assertTrue("class, hashcode()", emf.hashCode() == other.hashCode()); 
     other = new ExtendedMessageFormat("X" + pattern, Locale.US, registry); 
     assertFalse("pattern, equals()", emf.equals(other)); 
     assertFalse("pattern, hashcode()", emf.hashCode() == other.hashCode()); 
     other = new ExtendedMessageFormat(pattern, Locale.US, otherRegitry); 
     assertFalse("registry, equals()", emf.equals(other)); 
     assertFalse("registry, hashcode()", emf.hashCode() == other.hashCode()); 
     other = new ExtendedMessageFormat(pattern, Locale.FRANCE, registry); 
     assertFalse("locale, equals()", emf.equals(other)); 
     assertTrue("locale, hashcode()", emf.hashCode() == other.hashCode()); 
 }
@Test
public void testEscapedQuote_LANG_4778088() { 
     final String pattern = "it''s a {0,lower} 'test'!"; 
     final ExtendedMessageFormat emf = new ExtendedMessageFormat(pattern, registry); 
     assertEquals("it's a dummy test!", emf.format(new Object[] { "DUMMY" })); 
 }
@Test
public void testEscapedQuote_LANG_4778133() { 
     final String pattern = "it''s a {0,lower} 'test'!"; 
     final ExtendedMessageFormat emf = new ExtendedMessageFormat(pattern, registry); 
     assertEquals("it's a dummy test!", emf.format(new Object[] { "DUMMY" })); 
 }
@Test
public void testEqualsHashcode8169() { 
     final Map<String, ? extends FormatFactory> registry = Collections.singletonMap("testfmt", new LowerCaseFormatFactory()); 
     final Map<String, ? extends FormatFactory> otherRegitry = Collections.singletonMap("testfmt", new UpperCaseFormatFactory()); 
     final String pattern = "Pattern: {0,testfmt}"; 
     final ExtendedMessageFormat emf = new ExtendedMessageFormat(pattern, Locale.US, registry); 
     ExtendedMessageFormat other = null; 
     assertTrue("same, equals()", emf.equals(emf)); 
     assertTrue("same, hashcode()", emf.hashCode() == emf.hashCode()); 
     other = new ExtendedMessageFormat(pattern, Locale.US, registry); 
     assertTrue("equal, equals()", emf.equals(other)); 
     assertTrue("equal, hashcode()", emf.hashCode() == other.hashCode()); 
     other = new OtherExtendedMessageFormat(pattern, Locale.US, registry); 
     assertFalse("class, equals()", emf.equals(other)); 
     assertTrue("class, hashcode()", emf.hashCode() == other.hashCode()); 
     other = new ExtendedMessageFormat("X" + pattern, Locale.US, registry); 
     assertFalse("pattern, equals()", emf.equals(other)); 
     assertFalse("pattern, hashcode()", emf.hashCode() == other.hashCode()); 
     other = new ExtendedMessageFormat(pattern, Locale.US, otherRegitry); 
     assertFalse("registry, equals()", emf.equals(other)); 
     assertFalse("registry, hashcode()", emf.hashCode() == other.hashCode()); 
     other = new ExtendedMessageFormat(pattern, Locale.FRANCE, registry); 
     assertFalse("locale, equals()", emf.equals(other)); 
     assertTrue("locale, hashcode()", emf.hashCode() == other.hashCode()); 
 }
@Test
public void testEscapedQuote_LANG_4778346() { 
     final String pattern = "it''s a {0,lower} 'test'!"; 
     final ExtendedMessageFormat emf = new ExtendedMessageFormat(pattern, registry); 
     assertEquals("it's a dummy test!", emf.format(new Object[] { "DUMMY" })); 
 }
@Test
public void testEqualsHashcode8539() { 
     final Map<String, ? extends FormatFactory> registry = Collections.singletonMap("testfmt", new LowerCaseFormatFactory()); 
     final Map<String, ? extends FormatFactory> otherRegitry = Collections.singletonMap("testfmt", new UpperCaseFormatFactory()); 
     final String pattern = "Pattern: {0,testfmt}"; 
     final ExtendedMessageFormat emf = new ExtendedMessageFormat(pattern, Locale.US, registry); 
     ExtendedMessageFormat other = null; 
     assertTrue("same, equals()", emf.equals(emf)); 
     assertTrue("same, hashcode()", emf.hashCode() == emf.hashCode()); 
     other = new ExtendedMessageFormat(pattern, Locale.US, registry); 
     assertTrue("equal, equals()", emf.equals(other)); 
     assertTrue("equal, hashcode()", emf.hashCode() == other.hashCode()); 
     other = new OtherExtendedMessageFormat(pattern, Locale.US, registry); 
     assertFalse("class, equals()", emf.equals(other)); 
     assertTrue("class, hashcode()", emf.hashCode() == other.hashCode()); 
     other = new ExtendedMessageFormat("X" + pattern, Locale.US, registry); 
     assertFalse("pattern, equals()", emf.equals(other)); 
     assertFalse("pattern, hashcode()", emf.hashCode() == other.hashCode()); 
     other = new ExtendedMessageFormat(pattern, Locale.US, otherRegitry); 
     assertFalse("registry, equals()", emf.equals(other)); 
     assertFalse("registry, hashcode()", emf.hashCode() == other.hashCode()); 
     other = new ExtendedMessageFormat(pattern, Locale.FRANCE, registry); 
     assertFalse("locale, equals()", emf.equals(other)); 
     assertTrue("locale, hashcode()", emf.hashCode() == other.hashCode()); 
 }
@Test
public void testEqualsHashcode8686() { 
     final Map<String, ? extends FormatFactory> registry = Collections.singletonMap("testfmt", new LowerCaseFormatFactory()); 
     final Map<String, ? extends FormatFactory> otherRegitry = Collections.singletonMap("testfmt", new UpperCaseFormatFactory()); 
     final String pattern = "Pattern: {0,testfmt}"; 
     final ExtendedMessageFormat emf = new ExtendedMessageFormat(pattern, Locale.US, registry); 
     ExtendedMessageFormat other = null; 
     assertTrue("same, equals()", emf.equals(emf)); 
     assertTrue("same, hashcode()", emf.hashCode() == emf.hashCode()); 
     other = new ExtendedMessageFormat(pattern, Locale.US, registry); 
     assertTrue("equal, equals()", emf.equals(other)); 
     assertTrue("equal, hashcode()", emf.hashCode() == other.hashCode()); 
     other = new OtherExtendedMessageFormat(pattern, Locale.US, registry); 
     assertFalse("class, equals()", emf.equals(other)); 
     assertTrue("class, hashcode()", emf.hashCode() == other.hashCode()); 
     other = new ExtendedMessageFormat("X" + pattern, Locale.US, registry); 
     assertFalse("pattern, equals()", emf.equals(other)); 
     assertFalse("pattern, hashcode()", emf.hashCode() == other.hashCode()); 
     other = new ExtendedMessageFormat(pattern, Locale.US, otherRegitry); 
     assertFalse("registry, equals()", emf.equals(other)); 
     assertFalse("registry, hashcode()", emf.hashCode() == other.hashCode()); 
     other = new ExtendedMessageFormat(pattern, Locale.FRANCE, registry); 
     assertFalse("locale, equals()", emf.equals(other)); 
     assertTrue("locale, hashcode()", emf.hashCode() == other.hashCode()); 
 }
@Test
public void testEscapedQuote_LANG_4778775() { 
     final String pattern = "it''s a {0,lower} 'test'!"; 
     final ExtendedMessageFormat emf = new ExtendedMessageFormat(pattern, registry); 
     assertEquals("it's a dummy test!", emf.format(new Object[] { "DUMMY" })); 
 }
@Test
public void testEscapedQuote_LANG_4779095() { 
     final String pattern = "it''s a {0,lower} 'test'!"; 
     final ExtendedMessageFormat emf = new ExtendedMessageFormat(pattern, registry); 
     assertEquals("it's a dummy test!", emf.format(new Object[] { "DUMMY" })); 
 }
@Test
public void testEqualsHashcode9185() { 
     final Map<String, ? extends FormatFactory> registry = Collections.singletonMap("testfmt", new LowerCaseFormatFactory()); 
     final Map<String, ? extends FormatFactory> otherRegitry = Collections.singletonMap("testfmt", new UpperCaseFormatFactory()); 
     final String pattern = "Pattern: {0,testfmt}"; 
     final ExtendedMessageFormat emf = new ExtendedMessageFormat(pattern, Locale.US, registry); 
     ExtendedMessageFormat other = null; 
     assertTrue("same, equals()", emf.equals(emf)); 
     assertTrue("same, hashcode()", emf.hashCode() == emf.hashCode()); 
     other = new ExtendedMessageFormat(pattern, Locale.US, registry); 
     assertTrue("equal, equals()", emf.equals(other)); 
     assertTrue("equal, hashcode()", emf.hashCode() == other.hashCode()); 
     other = new OtherExtendedMessageFormat(pattern, Locale.US, registry); 
     assertFalse("class, equals()", emf.equals(other)); 
     assertTrue("class, hashcode()", emf.hashCode() == other.hashCode()); 
     other = new ExtendedMessageFormat("X" + pattern, Locale.US, registry); 
     assertFalse("pattern, equals()", emf.equals(other)); 
     assertFalse("pattern, hashcode()", emf.hashCode() == other.hashCode()); 
     other = new ExtendedMessageFormat(pattern, Locale.US, otherRegitry); 
     assertFalse("registry, equals()", emf.equals(other)); 
     assertFalse("registry, hashcode()", emf.hashCode() == other.hashCode()); 
     other = new ExtendedMessageFormat(pattern, Locale.FRANCE, registry); 
     assertFalse("locale, equals()", emf.equals(other)); 
     assertTrue("locale, hashcode()", emf.hashCode() == other.hashCode()); 
 }
@Test
public void testEscapedQuote_LANG_4779230() { 
     final String pattern = "it''s a {0,lower} 'test'!"; 
     final ExtendedMessageFormat emf = new ExtendedMessageFormat(pattern, registry); 
     assertEquals("it's a dummy test!", emf.format(new Object[] { "DUMMY" })); 
 }
@Test
public void testEscapedQuote_LANG_4779411() { 
     final String pattern = "it''s a {0,lower} 'test'!"; 
     final ExtendedMessageFormat emf = new ExtendedMessageFormat(pattern, registry); 
     assertEquals("it's a dummy test!", emf.format(new Object[] { "DUMMY" })); 
 }
    

    /**
     * Test Bug LANG-477 - out of memory error with escaped quote
     */
    

    /**
     * Test extended and built in formats.
     */
    

//    /**
//     * Test extended formats with choice format.
//     *
//     * NOTE: FAILING - currently sub-formats not supported
//     */
//    public void testExtendedWithChoiceFormat() {
//        String pattern = "Choice: {0,choice,1.0#{1,lower}|2.0#{1,upper}}";
//        ExtendedMessageFormat emf = new ExtendedMessageFormat(pattern, registry);
//        assertPatterns(null, pattern, emf.toPattern());
//        try {
//            assertEquals("one", emf.format(new Object[] {Integer.valueOf(1), "ONE"}));
//            assertEquals("TWO", emf.format(new Object[] {Integer.valueOf(2), "two"}));
//        } catch (IllegalArgumentException e) {
//            // currently sub-formats not supported
//        }
//    }

//    /**
//     * Test mixed extended and built-in formats with choice format.
//     *
//     * NOTE: FAILING - currently sub-formats not supported
//     */
//    public void testExtendedAndBuiltInWithChoiceFormat() {
//        String pattern = "Choice: {0,choice,1.0#{0} {1,lower} {2,number}|2.0#{0} {1,upper} {2,number,currency}}";
//        Object[] lowArgs  = new Object[] {Integer.valueOf(1), "Low",  Double.valueOf("1234.56")};
//        Object[] highArgs = new Object[] {Integer.valueOf(2), "High", Double.valueOf("9876.54")};
//        Locale[] availableLocales = ChoiceFormat.getAvailableLocales();
//        Locale[] testLocales = new Locale[availableLocales.length + 1];
//        testLocales[0] = null;
//        System.arraycopy(availableLocales, 0, testLocales, 1, availableLocales.length);
//        for (int i = 0; i < testLocales.length; i++) {
//            NumberFormat nf = null;
//            NumberFormat cf = null;
//            ExtendedMessageFormat emf = null;
//            if (testLocales[i] == null) {
//                nf = NumberFormat.getNumberInstance();
//                cf = NumberFormat.getCurrencyInstance();
//                emf = new ExtendedMessageFormat(pattern, registry);
//            } else {
//                nf = NumberFormat.getNumberInstance(testLocales[i]);
//                cf = NumberFormat.getCurrencyInstance(testLocales[i]);
//                emf = new ExtendedMessageFormat(pattern, testLocales[i], registry);
//            }
//            assertPatterns(null, pattern, emf.toPattern());
//            try {
//                String lowExpected = lowArgs[0] + " low "    + nf.format(lowArgs[2]);
//                String highExpected = highArgs[0] + " HIGH "  + cf.format(highArgs[2]);
//                assertEquals(lowExpected,  emf.format(lowArgs));
//                assertEquals(highExpected, emf.format(highArgs));
//            } catch (IllegalArgumentException e) {
//                // currently sub-formats not supported
//            }
//        }
//    }

    /**
     * Test the built in choice format.
     */
    

    /**
     * Test the built in date/time formats
     */
    

    

    /**
     * Test the built in number formats.
     */
    

    /**
     * Test equals() and hashcode.
     */
    

    /**
     * Test a built in format for the specified Locales, plus <code>null</code> Locale.
     * @param pattern MessageFormat pattern
     * @param args MessageFormat arguments
     * @param locales to test
     */
    private void checkBuiltInFormat(final String pattern, final Object[] args, final Locale[] locales) {
        checkBuiltInFormat(pattern, null, args, locales);
    }

    /**
     * Test a built in format for the specified Locales, plus <code>null</code> Locale.
     * @param pattern MessageFormat pattern
     * @param registry FormatFactory registry to use
     * @param args MessageFormat arguments
     * @param locales to test
     */
    private void checkBuiltInFormat(final String pattern, final Map<String, ?> registry, final Object[] args, final Locale[] locales) {
        checkBuiltInFormat(pattern, registry, args, (Locale) null);
        for (final Locale locale : locales) {
            checkBuiltInFormat(pattern, registry, args, locale);
        }
    }

    /**
     * Create an ExtendedMessageFormat for the specified pattern and locale and check the
     * formated output matches the expected result for the parameters.
     * @param pattern string
     * @param registry map
     * @param args Object[]
     * @param locale Locale
     */
    private void checkBuiltInFormat(final String pattern, final Map<String, ?> registry, final Object[] args, final Locale locale) {
        final StringBuilder buffer = new StringBuilder();
        buffer.append("Pattern=[");
        buffer.append(pattern);
        buffer.append("], locale=[");
        buffer.append(locale);
        buffer.append("]");
        final MessageFormat mf = createMessageFormat(pattern, locale);
        // System.out.println(buffer + ", result=[" + mf.format(args) +"]");
        ExtendedMessageFormat emf = null;
        if (locale == null) {
            emf = new ExtendedMessageFormat(pattern);
        } else {
            emf = new ExtendedMessageFormat(pattern, locale);
        }
        assertEquals("format "    + buffer.toString(), mf.format(args), emf.format(args));
        assertPatternsEqual("toPattern " + buffer.toString(), mf.toPattern(),  emf.toPattern());
    }

    //can't trust what MessageFormat does with toPattern() pre 1.4:
    private void assertPatternsEqual(final String message, final String expected, final String actual) {
        if (SystemUtils.isJavaVersionAtLeast(JAVA_1_4)) {
            assertEquals(message, expected, actual);
        }
    }

    /**
     * Replace MessageFormat(String, Locale) constructor (not available until JDK 1.4).
     * @param pattern string
     * @param locale Locale
     * @return MessageFormat
     */
    private MessageFormat createMessageFormat(final String pattern, final Locale locale) {
        final MessageFormat result = new MessageFormat(pattern);
        if (locale != null) {
            result.setLocale(locale);
            result.applyPattern(pattern);
        }
        return result;
    }

    // ------------------------ Test Formats ------------------------

    /**
     * {@link Format} implementation which converts to lower case.
     */
    private static class LowerCaseFormat extends Format {
        @Override
        public StringBuffer format(final Object obj, final StringBuffer toAppendTo, final FieldPosition pos) {
            return toAppendTo.append(((String)obj).toLowerCase());
        }
        @Override
        public Object parseObject(final String source, final ParsePosition pos) {throw new UnsupportedOperationException();}
    }

    /**
     * {@link Format} implementation which converts to upper case.
     */
    private static class UpperCaseFormat extends Format {
        @Override
        public StringBuffer format(final Object obj, final StringBuffer toAppendTo, final FieldPosition pos) {
            return toAppendTo.append(((String)obj).toUpperCase());
        }
        @Override
        public Object parseObject(final String source, final ParsePosition pos) {throw new UnsupportedOperationException();}
    }


    // ------------------------ Test Format Factories ---------------
    /**
     * {@link FormatFactory} implementation for lower case format.
     */
    private static class LowerCaseFormatFactory implements FormatFactory {
        private static final Format LOWER_INSTANCE = new LowerCaseFormat();
        @Override
        public Format getFormat(final String name, final String arguments, final Locale locale) {
            return LOWER_INSTANCE;
        }
    }
    /**
     * {@link FormatFactory} implementation for upper case format.
     */
    private static class UpperCaseFormatFactory implements FormatFactory {
        private static final Format UPPER_INSTANCE = new UpperCaseFormat();
        @Override
        public Format getFormat(final String name, final String arguments, final Locale locale) {
            return UPPER_INSTANCE;
        }
    }
    /**
     * {@link FormatFactory} implementation to override date format "short" to "default".
     */
    private static class OverrideShortDateFormatFactory implements FormatFactory {
        @Override
        public Format getFormat(final String name, final String arguments, final Locale locale) {
            return !"short".equals(arguments) ? null
                    : locale == null ? DateFormat
                            .getDateInstance(DateFormat.DEFAULT) : DateFormat
                            .getDateInstance(DateFormat.DEFAULT, locale);
        }
    }

    /**
     * Alternative ExtendedMessageFormat impl.
     */
    private static class OtherExtendedMessageFormat extends ExtendedMessageFormat {
        public OtherExtendedMessageFormat(final String pattern, final Locale locale,
                final Map<String, ? extends FormatFactory> registry) {
            super(pattern, locale, registry);
        }
        
    }

}
