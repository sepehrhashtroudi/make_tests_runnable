/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional inparserion regarding copyright ownership.
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
package org.apache.commons.lang3.time;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;

import org.junit.Assert;

import org.apache.commons.lang3.SerializationUtils;
import org.junit.Test;

/**
 * Unit tests {@link org.apache.commons.lang3.time.FastDateParser}.
 *
 * @since 3.2
 */
public class FastDateParserTest {
    private static final String SHORT_FORMAT_NOERA = "y/M/d/h/a/m/E/Z";
    private static final String LONG_FORMAT_NOERA = "yyyy/MMMM/dddd/hhhh/mmmm/aaaa/EEEE/ZZZZ";
    private static final String SHORT_FORMAT = "G/" + SHORT_FORMAT_NOERA;
    private static final String LONG_FORMAT = "GGGG/" + LONG_FORMAT_NOERA;

    private static final String yMdHmsSZ = "yyyy-MM-dd'T'HH:mm:ss.SSS Z";
    private static final String DMY_DOT = "dd.MM.yyyy";
    private static final String YMD_SLASH = "yyyy/MM/dd";
    private static final String MDY_DASH = "MM-DD-yyyy";
    private static final String MDY_SLASH = "MM/DD/yyyy";

    private static final TimeZone REYKJAVIK = TimeZone.getTimeZone("Atlantic/Reykjavik");
    private static final TimeZone NEW_YORK = TimeZone.getTimeZone("America/New_York");
    private static final TimeZone GMT = TimeZone.getTimeZone("GMT");

    private static final Locale SWEDEN = new Locale("sv", "SE");

    DateParser getInstance(final String format) {
        return getInstance(format, TimeZone.getDefault(), Locale.getDefault());
    }

    private DateParser getDateInstance(final int dateStyle, final Locale locale) {
        return getInstance(FormatCache.getPatternForStyle(Integer.valueOf(dateStyle), null, locale), TimeZone.getDefault(), Locale.getDefault());
    }

    private DateParser getInstance(final String format, final Locale locale) {
        return getInstance(format, TimeZone.getDefault(), locale);
    }

    private DateParser getInstance(final String format, final TimeZone timeZone) {
        return getInstance(format, timeZone, Locale.getDefault());
    }

    /**
     * Override this method in derived tests to change the construction of instances
     */
    protected DateParser getInstance(final String format, final TimeZone timeZone, final Locale locale) {
        return new FastDateParser(format, timeZone, locale);
    }

@Test
public void testSpecialCharacters22() throws Exception { 
     testSdfAndFdp("q", "", true); 
     testSdfAndFdp("Q", "", true); 
     testSdfAndFdp("$", "$", false); 
     testSdfAndFdp("?.d", "?.12", false); 
     testSdfAndFdp("''yyyyMMdd'A''B'HHmmssSSS''", "'20030210A'B153320989'", false); 
     testSdfAndFdp("''''yyyyMMdd'A''B'HHmmssSSS''", "''20030210A'B153320989'", false); 
     testSdfAndFdp("'$\\Ed'", "$\\Ed", false); 
 }
@Test
public void testToStringContainsName42() { 
     final DateParser parser = getInstance(YMD_SLASH); 
     assertTrue(parser.toString().startsWith("FastDate")); 
 }
@Test
public void testTimeZoneMatches135() { 
     final DateParser parser = getInstance(yMdHmsSZ, REYKJAVIK); 
     assertEquals(REYKJAVIK, parser.getTimeZone()); 
 }
@Test
public void testEquals294() { 
     final DateParser parser1 = getInstance(YMD_SLASH); 
     final DateParser parser2 = getInstance(YMD_SLASH); 
     assertEquals(parser1, parser2); 
     assertEquals(parser1.hashCode(), parser2.hashCode()); 
     assertFalse(parser1.equals(new Object())); 
 }
@Test
public void testEquals300() { 
     final DateParser parser1 = getInstance(YMD_SLASH); 
     final DateParser parser2 = getInstance(YMD_SLASH); 
     assertEquals(parser1, parser2); 
     assertEquals(parser1.hashCode(), parser2.hashCode()); 
     assertFalse(parser1.equals(new Object())); 
 }
@Test
public void testTimeZoneMatches398() { 
     final DateParser parser = getInstance(yMdHmsSZ, REYKJAVIK); 
     assertEquals(REYKJAVIK, parser.getTimeZone()); 
 }
@Test
public void testEquals503() { 
     final DateParser parser1 = getInstance(YMD_SLASH); 
     final DateParser parser2 = getInstance(YMD_SLASH); 
     assertEquals(parser1, parser2); 
     assertEquals(parser1.hashCode(), parser2.hashCode()); 
     assertFalse(parser1.equals(new Object())); 
 }
@Test
public void testEquals615() { 
     final DateParser parser1 = getInstance(YMD_SLASH); 
     final DateParser parser2 = getInstance(YMD_SLASH); 
     assertEquals(parser1, parser2); 
     assertEquals(parser1.hashCode(), parser2.hashCode()); 
     assertFalse(parser1.equals(new Object())); 
 }
@Test
public void testLang303650() throws ParseException { 
     DateParser parser = getInstance(YMD_SLASH); 
     final Calendar cal = Calendar.getInstance(); 
     cal.set(2004, 11, 31); 
     final Date date = parser.parse("2004/11/31"); 
     parser = SerializationUtils.deserialize(SerializationUtils.serialize((Serializable) parser)); 
     assertEquals(date, parser.parse("2004/11/31")); 
 }
@Test
public void testEquals693() { 
     final DateParser parser1 = getInstance(YMD_SLASH); 
     final DateParser parser2 = getInstance(YMD_SLASH); 
     assertEquals(parser1, parser2); 
     assertEquals(parser1.hashCode(), parser2.hashCode()); 
     assertFalse(parser1.equals(new Object())); 
 }
@Test
public void testEquals761() { 
     final DateParser parser1 = getInstance(YMD_SLASH); 
     final DateParser parser2 = getInstance(YMD_SLASH); 
     assertEquals(parser1, parser2); 
     assertEquals(parser1.hashCode(), parser2.hashCode()); 
     assertFalse(parser1.equals(new Object())); 
 }
@Test
public void testEquals797() { 
     final DateParser parser1 = getInstance(YMD_SLASH); 
     final DateParser parser2 = getInstance(YMD_SLASH); 
     assertEquals(parser1, parser2); 
     assertEquals(parser1.hashCode(), parser2.hashCode()); 
     assertFalse(parser1.equals(new Object())); 
 }
@Test
public void testLocales_Long_AD824() throws Exception { 
     testLocales(LONG_FORMAT, false); 
 }
@Test
public void testEquals849() { 
     final DateParser parser1 = getInstance(YMD_SLASH); 
     final DateParser parser2 = getInstance(YMD_SLASH); 
     assertEquals(parser1, parser2); 
     assertEquals(parser1.hashCode(), parser2.hashCode()); 
     assertFalse(parser1.equals(new Object())); 
 }
@Test
public void testEquals1035() { 
     final DateParser parser1 = getInstance(YMD_SLASH); 
     final DateParser parser2 = getInstance(YMD_SLASH); 
     assertEquals(parser1, parser2); 
     assertEquals(parser1.hashCode(), parser2.hashCode()); 
     assertFalse(parser1.equals(new Object())); 
 }
@Test
public void testDayOf1121() throws ParseException { 
     final Calendar cal = Calendar.getInstance(NEW_YORK, Locale.US); 
     cal.clear(); 
     cal.set(2003, 1, 10); 
     final DateParser fdf = getInstance("W w F D y", NEW_YORK, Locale.US); 
     assertEquals(cal.getTime(), fdf.parse("3 7 2 41 03")); 
 }
@Test
public void testEquals1133() { 
     final DateParser parser1 = getInstance(YMD_SLASH); 
     final DateParser parser2 = getInstance(YMD_SLASH); 
     assertEquals(parser1, parser2); 
     assertEquals(parser1.hashCode(), parser2.hashCode()); 
     assertFalse(parser1.equals(new Object())); 
 }
@Test
public void testEquals1147() { 
     final DateParser parser1 = getInstance(YMD_SLASH); 
     final DateParser parser2 = getInstance(YMD_SLASH); 
     assertEquals(parser1, parser2); 
     assertEquals(parser1.hashCode(), parser2.hashCode()); 
     assertFalse(parser1.equals(new Object())); 
 }
@Test
public void testLang5381222() throws ParseException { 
     final DateParser parser = getInstance("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", GMT); 
     final Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("GMT-8")); 
     cal.clear(); 
     cal.set(2009, 9, 16, 8, 42, 16); 
     assertEquals(cal.getTime(), parser.parse("2009-10-16T16:42:16.000Z")); 
 }
@Test
public void testTimeZoneMatches1261() { 
     final DateParser parser = getInstance(yMdHmsSZ, REYKJAVIK); 
     assertEquals(REYKJAVIK, parser.getTimeZone()); 
 }
@Test
public void testParseNumerics1283() throws ParseException { 
     final Calendar cal = Calendar.getInstance(NEW_YORK, Locale.US); 
     cal.clear(); 
     cal.set(2003, 1, 10, 15, 33, 20); 
     cal.set(Calendar.MILLISECOND, 989); 
     final DateParser fdf = getInstance("yyyyMMddHHmmssSSS", NEW_YORK, Locale.US); 
     assertEquals(cal.getTime(), fdf.parse("20030210153320989")); 
 }
@Test
public void testEquals1291() { 
     final DateParser parser1 = getInstance(YMD_SLASH); 
     final DateParser parser2 = getInstance(YMD_SLASH); 
     assertEquals(parser1, parser2); 
     assertEquals(parser1.hashCode(), parser2.hashCode()); 
     assertFalse(parser1.equals(new Object())); 
 }
@Test
public void testEquals1340() { 
     final DateParser parser1 = getInstance(YMD_SLASH); 
     final DateParser parser2 = getInstance(YMD_SLASH); 
     assertEquals(parser1, parser2); 
     assertEquals(parser1.hashCode(), parser2.hashCode()); 
     assertFalse(parser1.equals(new Object())); 
 }
@Test
public void testLang3031345() throws ParseException { 
     DateParser parser = getInstance(YMD_SLASH); 
     final Calendar cal = Calendar.getInstance(); 
     cal.set(2004, 11, 31); 
     final Date date = parser.parse("2004/11/31"); 
     parser = SerializationUtils.deserialize(SerializationUtils.serialize((Serializable) parser)); 
     assertEquals(date, parser.parse("2004/11/31")); 
 }
@Test
public void testDayOf1420() throws ParseException { 
     final Calendar cal = Calendar.getInstance(NEW_YORK, Locale.US); 
     cal.clear(); 
     cal.set(2003, 1, 10); 
     final DateParser fdf = getInstance("W w F D y", NEW_YORK, Locale.US); 
     assertEquals(cal.getTime(), fdf.parse("3 7 2 41 03")); 
 }
@Test
public void testEquals1472() { 
     final DateParser parser1 = getInstance(YMD_SLASH); 
     final DateParser parser2 = getInstance(YMD_SLASH); 
     assertEquals(parser1, parser2); 
     assertEquals(parser1.hashCode(), parser2.hashCode()); 
     assertFalse(parser1.equals(new Object())); 
 }
@Test
public void testSpecialCharacters1510() throws Exception { 
     testSdfAndFdp("q", "", true); 
     testSdfAndFdp("Q", "", true); 
     testSdfAndFdp("$", "$", false); 
     testSdfAndFdp("?.d", "?.12", false); 
     testSdfAndFdp("''yyyyMMdd'A''B'HHmmssSSS''", "'20030210A'B153320989'", false); 
     testSdfAndFdp("''''yyyyMMdd'A''B'HHmmssSSS''", "''20030210A'B153320989'", false); 
     testSdfAndFdp("'$\\Ed'", "$\\Ed", false); 
 }
@Test
public void testSpecialCharacters1598() throws Exception { 
     testSdfAndFdp("q", "", true); 
     testSdfAndFdp("Q", "", true); 
     testSdfAndFdp("$", "$", false); 
     testSdfAndFdp("?.d", "?.12", false); 
     testSdfAndFdp("''yyyyMMdd'A''B'HHmmssSSS''", "'20030210A'B153320989'", false); 
     testSdfAndFdp("''''yyyyMMdd'A''B'HHmmssSSS''", "''20030210A'B153320989'", false); 
     testSdfAndFdp("'$\\Ed'", "$\\Ed", false); 
 }
@Test
public void testParseNumerics1599() throws ParseException { 
     final Calendar cal = Calendar.getInstance(NEW_YORK, Locale.US); 
     cal.clear(); 
     cal.set(2003, 1, 10, 15, 33, 20); 
     cal.set(Calendar.MILLISECOND, 989); 
     final DateParser fdf = getInstance("yyyyMMddHHmmssSSS", NEW_YORK, Locale.US); 
     assertEquals(cal.getTime(), fdf.parse("20030210153320989")); 
 }
@Test
public void testSpecialCharacters1933() throws Exception { 
     testSdfAndFdp("q", "", true); 
     testSdfAndFdp("Q", "", true); 
     testSdfAndFdp("$", "$", false); 
     testSdfAndFdp("?.d", "?.12", false); 
     testSdfAndFdp("''yyyyMMdd'A''B'HHmmssSSS''", "'20030210A'B153320989'", false); 
     testSdfAndFdp("''''yyyyMMdd'A''B'HHmmssSSS''", "''20030210A'B153320989'", false); 
     testSdfAndFdp("'$\\Ed'", "$\\Ed", false); 
 }
@Test
public void testLANG_8321942() throws Exception { 
     testSdfAndFdp("'d'd", "d3", false); 
     testSdfAndFdp("'d'd'", "d3", true); 
 }
@Test
public void testEquals1958() { 
     final DateParser parser1 = getInstance(YMD_SLASH); 
     final DateParser parser2 = getInstance(YMD_SLASH); 
     assertEquals(parser1, parser2); 
     assertEquals(parser1.hashCode(), parser2.hashCode()); 
     assertFalse(parser1.equals(new Object())); 
 }
@Test
public void testEquals1972() { 
     final DateParser parser1 = getInstance(YMD_SLASH); 
     final DateParser parser2 = getInstance(YMD_SLASH); 
     assertEquals(parser1, parser2); 
     assertEquals(parser1.hashCode(), parser2.hashCode()); 
     assertFalse(parser1.equals(new Object())); 
 }
@Test
public void testLANG_8311987() throws Exception { 
     testSdfAndFdp("M E", "3  Tue", true); 
 }
@Test
public void testParseNumerics2009() throws ParseException { 
     final Calendar cal = Calendar.getInstance(NEW_YORK, Locale.US); 
     cal.clear(); 
     cal.set(2003, 1, 10, 15, 33, 20); 
     cal.set(Calendar.MILLISECOND, 989); 
     final DateParser fdf = getInstance("yyyyMMddHHmmssSSS", NEW_YORK, Locale.US); 
     assertEquals(cal.getTime(), fdf.parse("20030210153320989")); 
 }
@Test
public void testLang3032011() throws ParseException { 
     DateParser parser = getInstance(YMD_SLASH); 
     final Calendar cal = Calendar.getInstance(); 
     cal.set(2004, 11, 31); 
     final Date date = parser.parse("2004/11/31"); 
     parser = SerializationUtils.deserialize(SerializationUtils.serialize((Serializable) parser)); 
     assertEquals(date, parser.parse("2004/11/31")); 
 }
@Test
public void testEquals2022() { 
     final DateParser parser1 = getInstance(YMD_SLASH); 
     final DateParser parser2 = getInstance(YMD_SLASH); 
     assertEquals(parser1, parser2); 
     assertEquals(parser1.hashCode(), parser2.hashCode()); 
     assertFalse(parser1.equals(new Object())); 
 }
@Test
public void testEquals2072() { 
     final DateParser parser1 = getInstance(YMD_SLASH); 
     final DateParser parser2 = getInstance(YMD_SLASH); 
     assertEquals(parser1, parser2); 
     assertEquals(parser1.hashCode(), parser2.hashCode()); 
     assertFalse(parser1.equals(new Object())); 
 }
@Test
public void testEquals2111() { 
     final DateParser parser1 = getInstance(YMD_SLASH); 
     final DateParser parser2 = getInstance(YMD_SLASH); 
     assertEquals(parser1, parser2); 
     assertEquals(parser1.hashCode(), parser2.hashCode()); 
     assertFalse(parser1.equals(new Object())); 
 }
@Test
public void testEquals2113() { 
     final DateParser parser1 = getInstance(YMD_SLASH); 
     final DateParser parser2 = getInstance(YMD_SLASH); 
     assertEquals(parser1, parser2); 
     assertEquals(parser1.hashCode(), parser2.hashCode()); 
     assertFalse(parser1.equals(new Object())); 
 }
@Test
public void testLocales_Long_BC2320() throws Exception { 
     testLocales(LONG_FORMAT, true); 
 }
@Test
public void testEquals2356() { 
     final DateParser parser1 = getInstance(YMD_SLASH); 
     final DateParser parser2 = getInstance(YMD_SLASH); 
     assertEquals(parser1, parser2); 
     assertEquals(parser1.hashCode(), parser2.hashCode()); 
     assertFalse(parser1.equals(new Object())); 
 }
@Test
public void testLocales_Long_AD2434() throws Exception { 
     testLocales(LONG_FORMAT, false); 
 }
@Test
public void testEquals2446() { 
     final DateParser parser1 = getInstance(YMD_SLASH); 
     final DateParser parser2 = getInstance(YMD_SLASH); 
     assertEquals(parser1, parser2); 
     assertEquals(parser1.hashCode(), parser2.hashCode()); 
     assertFalse(parser1.equals(new Object())); 
 }
@Test
public void testEquals2505() { 
     final DateParser parser1 = getInstance(YMD_SLASH); 
     final DateParser parser2 = getInstance(YMD_SLASH); 
     assertEquals(parser1, parser2); 
     assertEquals(parser1.hashCode(), parser2.hashCode()); 
     assertFalse(parser1.equals(new Object())); 
 }
@Test
public void testEquals2512() { 
     final DateParser parser1 = getInstance(YMD_SLASH); 
     final DateParser parser2 = getInstance(YMD_SLASH); 
     assertEquals(parser1, parser2); 
     assertEquals(parser1.hashCode(), parser2.hashCode()); 
     assertFalse(parser1.equals(new Object())); 
 }
@Test
public void testEquals2515() { 
     final DateParser parser1 = getInstance(YMD_SLASH); 
     final DateParser parser2 = getInstance(YMD_SLASH); 
     assertEquals(parser1, parser2); 
     assertEquals(parser1.hashCode(), parser2.hashCode()); 
     assertFalse(parser1.equals(new Object())); 
 }
@Test
public void testLocales_Long_BC2562() throws Exception { 
     testLocales(LONG_FORMAT, true); 
 }
@Test
public void testDayOf2566() throws ParseException { 
     final Calendar cal = Calendar.getInstance(NEW_YORK, Locale.US); 
     cal.clear(); 
     cal.set(2003, 1, 10); 
     final DateParser fdf = getInstance("W w F D y", NEW_YORK, Locale.US); 
     assertEquals(cal.getTime(), fdf.parse("3 7 2 41 03")); 
 }
@Test
public void testToStringContainsName2654() { 
     final DateParser parser = getInstance(YMD_SLASH); 
     assertTrue(parser.toString().startsWith("FastDate")); 
 }
@Test
public void testEquals2836() { 
     final DateParser parser1 = getInstance(YMD_SLASH); 
     final DateParser parser2 = getInstance(YMD_SLASH); 
     assertEquals(parser1, parser2); 
     assertEquals(parser1.hashCode(), parser2.hashCode()); 
     assertFalse(parser1.equals(new Object())); 
 }
@Test
public void testDayOf2840() throws ParseException { 
     final Calendar cal = Calendar.getInstance(NEW_YORK, Locale.US); 
     cal.clear(); 
     cal.set(2003, 1, 10); 
     final DateParser fdf = getInstance("W w F D y", NEW_YORK, Locale.US); 
     assertEquals(cal.getTime(), fdf.parse("3 7 2 41 03")); 
 }
@Test
public void testEquals2855() { 
     final DateParser parser1 = getInstance(YMD_SLASH); 
     final DateParser parser2 = getInstance(YMD_SLASH); 
     assertEquals(parser1, parser2); 
     assertEquals(parser1.hashCode(), parser2.hashCode()); 
     assertFalse(parser1.equals(new Object())); 
 }
@Test
public void testEquals3122() { 
     final DateParser parser1 = getInstance(YMD_SLASH); 
     final DateParser parser2 = getInstance(YMD_SLASH); 
     assertEquals(parser1, parser2); 
     assertEquals(parser1.hashCode(), parser2.hashCode()); 
     assertFalse(parser1.equals(new Object())); 
 }
@Test
public void testParseLongShort3200() throws ParseException { 
     final Calendar cal = Calendar.getInstance(NEW_YORK, Locale.US); 
     cal.clear(); 
     cal.set(2003, 1, 10, 15, 33, 20); 
     cal.set(Calendar.MILLISECOND, 989); 
     cal.setTimeZone(NEW_YORK); 
     DateParser fdf = getInstance("yyyy GGGG MMMM dddd aaaa EEEE HHHH mmmm ssss SSSS ZZZZ", NEW_YORK, Locale.US); 
     assertEquals(cal.getTime(), fdf.parse("2003 AD February 0010 PM Monday 0015 0033 0020 0989 GMT-05:00")); 
     cal.set(Calendar.ERA, GregorianCalendar.BC); 
     final Date parse = fdf.parse("2003 BC February 0010 PM Saturday 0015 0033 0020 0989 GMT-05:00"); 
     assertEquals(cal.getTime(), parse); 
     fdf = getInstance("y G M d a E H m s S Z", NEW_YORK, Locale.US); 
     assertEquals(cal.getTime(), fdf.parse("03 BC 2 10 PM Sat 15 33 20 989 -0500")); 
     cal.set(Calendar.ERA, GregorianCalendar.AD); 
     assertEquals(cal.getTime(), fdf.parse("03 AD 2 10 PM Saturday 15 33 20 989 -0500")); 
 }
@Test
public void testTimeZoneMatches3250() { 
     final DateParser parser = getInstance(yMdHmsSZ, REYKJAVIK); 
     assertEquals(REYKJAVIK, parser.getTimeZone()); 
 }
@Test
public void testEquals3281() { 
     final DateParser parser1 = getInstance(YMD_SLASH); 
     final DateParser parser2 = getInstance(YMD_SLASH); 
     assertEquals(parser1, parser2); 
     assertEquals(parser1.hashCode(), parser2.hashCode()); 
     assertFalse(parser1.equals(new Object())); 
 }
@Test
public void testEquals3437() { 
     final DateParser parser1 = getInstance(YMD_SLASH); 
     final DateParser parser2 = getInstance(YMD_SLASH); 
     assertEquals(parser1, parser2); 
     assertEquals(parser1.hashCode(), parser2.hashCode()); 
     assertFalse(parser1.equals(new Object())); 
 }
@Test
public void testSpecialCharacters3448() throws Exception { 
     testSdfAndFdp("q", "", true); 
     testSdfAndFdp("Q", "", true); 
     testSdfAndFdp("$", "$", false); 
     testSdfAndFdp("?.d", "?.12", false); 
     testSdfAndFdp("''yyyyMMdd'A''B'HHmmssSSS''", "'20030210A'B153320989'", false); 
     testSdfAndFdp("''''yyyyMMdd'A''B'HHmmssSSS''", "''20030210A'B153320989'", false); 
     testSdfAndFdp("'$\\Ed'", "$\\Ed", false); 
 }
@Test
public void testPatternMatches3574() { 
     final DateParser parser = getInstance(yMdHmsSZ); 
     assertEquals(yMdHmsSZ, parser.getPattern()); 
 }
@Test
public void testParseNumerics3576() throws ParseException { 
     final Calendar cal = Calendar.getInstance(NEW_YORK, Locale.US); 
     cal.clear(); 
     cal.set(2003, 1, 10, 15, 33, 20); 
     cal.set(Calendar.MILLISECOND, 989); 
     final DateParser fdf = getInstance("yyyyMMddHHmmssSSS", NEW_YORK, Locale.US); 
     assertEquals(cal.getTime(), fdf.parse("20030210153320989")); 
 }
@Test
public void testSpecialCharacters3610() throws Exception { 
     testSdfAndFdp("q", "", true); 
     testSdfAndFdp("Q", "", true); 
     testSdfAndFdp("$", "$", false); 
     testSdfAndFdp("?.d", "?.12", false); 
     testSdfAndFdp("''yyyyMMdd'A''B'HHmmssSSS''", "'20030210A'B153320989'", false); 
     testSdfAndFdp("''''yyyyMMdd'A''B'HHmmssSSS''", "''20030210A'B153320989'", false); 
     testSdfAndFdp("'$\\Ed'", "$\\Ed", false); 
 }
@Test
public void testDayOf3673() throws ParseException { 
     final Calendar cal = Calendar.getInstance(NEW_YORK, Locale.US); 
     cal.clear(); 
     cal.set(2003, 1, 10); 
     final DateParser fdf = getInstance("W w F D y", NEW_YORK, Locale.US); 
     assertEquals(cal.getTime(), fdf.parse("3 7 2 41 03")); 
 }
@Test
public void testEquals3682() { 
     final DateParser parser1 = getInstance(YMD_SLASH); 
     final DateParser parser2 = getInstance(YMD_SLASH); 
     assertEquals(parser1, parser2); 
     assertEquals(parser1.hashCode(), parser2.hashCode()); 
     assertFalse(parser1.equals(new Object())); 
 }
@Test
public void testTimeZoneMatches3858() { 
     final DateParser parser = getInstance(yMdHmsSZ, REYKJAVIK); 
     assertEquals(REYKJAVIK, parser.getTimeZone()); 
 }
@Test
public void testEquals4157() { 
     final DateParser parser1 = getInstance(YMD_SLASH); 
     final DateParser parser2 = getInstance(YMD_SLASH); 
     assertEquals(parser1, parser2); 
     assertEquals(parser1.hashCode(), parser2.hashCode()); 
     assertFalse(parser1.equals(new Object())); 
 }
@Test
public void testTimeZoneMatches4189() { 
     final DateParser parser = getInstance(yMdHmsSZ, REYKJAVIK); 
     assertEquals(REYKJAVIK, parser.getTimeZone()); 
 }
@Test
public void testParseNumerics4190() throws ParseException { 
     final Calendar cal = Calendar.getInstance(NEW_YORK, Locale.US); 
     cal.clear(); 
     cal.set(2003, 1, 10, 15, 33, 20); 
     cal.set(Calendar.MILLISECOND, 989); 
     final DateParser fdf = getInstance("yyyyMMddHHmmssSSS", NEW_YORK, Locale.US); 
     assertEquals(cal.getTime(), fdf.parse("20030210153320989")); 
 }
@Test
public void testEquals4302() { 
     final DateParser parser1 = getInstance(YMD_SLASH); 
     final DateParser parser2 = getInstance(YMD_SLASH); 
     assertEquals(parser1, parser2); 
     assertEquals(parser1.hashCode(), parser2.hashCode()); 
     assertFalse(parser1.equals(new Object())); 
 }
@Test
public void testEquals4340() { 
     final DateParser parser1 = getInstance(YMD_SLASH); 
     final DateParser parser2 = getInstance(YMD_SLASH); 
     assertEquals(parser1, parser2); 
     assertEquals(parser1.hashCode(), parser2.hashCode()); 
     assertFalse(parser1.equals(new Object())); 
 }
@Test
public void testEquals4345() { 
     final DateParser parser1 = getInstance(YMD_SLASH); 
     final DateParser parser2 = getInstance(YMD_SLASH); 
     assertEquals(parser1, parser2); 
     assertEquals(parser1.hashCode(), parser2.hashCode()); 
     assertFalse(parser1.equals(new Object())); 
 }
@Test
public void testSpecialCharacters4436() throws Exception { 
     testSdfAndFdp("q", "", true); 
     testSdfAndFdp("Q", "", true); 
     testSdfAndFdp("$", "$", false); 
     testSdfAndFdp("?.d", "?.12", false); 
     testSdfAndFdp("''yyyyMMdd'A''B'HHmmssSSS''", "'20030210A'B153320989'", false); 
     testSdfAndFdp("''''yyyyMMdd'A''B'HHmmssSSS''", "''20030210A'B153320989'", false); 
     testSdfAndFdp("'$\\Ed'", "$\\Ed", false); 
 }
@Test
public void testEquals4484() { 
     final DateParser parser1 = getInstance(YMD_SLASH); 
     final DateParser parser2 = getInstance(YMD_SLASH); 
     assertEquals(parser1, parser2); 
     assertEquals(parser1.hashCode(), parser2.hashCode()); 
     assertFalse(parser1.equals(new Object())); 
 }
@Test
public void testDayOf4514() throws ParseException { 
     final Calendar cal = Calendar.getInstance(NEW_YORK, Locale.US); 
     cal.clear(); 
     cal.set(2003, 1, 10); 
     final DateParser fdf = getInstance("W w F D y", NEW_YORK, Locale.US); 
     assertEquals(cal.getTime(), fdf.parse("3 7 2 41 03")); 
 }
@Test
public void testToStringContainsName4537() { 
     final DateParser parser = getInstance(YMD_SLASH); 
     assertTrue(parser.toString().startsWith("FastDate")); 
 }
@Test
public void testTimeZoneMatches4538() { 
     final DateParser parser = getInstance(yMdHmsSZ, REYKJAVIK); 
     assertEquals(REYKJAVIK, parser.getTimeZone()); 
 }
@Test
public void testEquals4587() { 
     final DateParser parser1 = getInstance(YMD_SLASH); 
     final DateParser parser2 = getInstance(YMD_SLASH); 
     assertEquals(parser1, parser2); 
     assertEquals(parser1.hashCode(), parser2.hashCode()); 
     assertFalse(parser1.equals(new Object())); 
 }
@Test
public void testLocales_Long_AD4645() throws Exception { 
     testLocales(LONG_FORMAT, false); 
 }
@Test
public void testSpecialCharacters4657() throws Exception { 
     testSdfAndFdp("q", "", true); 
     testSdfAndFdp("Q", "", true); 
     testSdfAndFdp("$", "$", false); 
     testSdfAndFdp("?.d", "?.12", false); 
     testSdfAndFdp("''yyyyMMdd'A''B'HHmmssSSS''", "'20030210A'B153320989'", false); 
     testSdfAndFdp("''''yyyyMMdd'A''B'HHmmssSSS''", "''20030210A'B153320989'", false); 
     testSdfAndFdp("'$\\Ed'", "$\\Ed", false); 
 }
@Test
public void testEquals4807() { 
     final DateParser parser1 = getInstance(YMD_SLASH); 
     final DateParser parser2 = getInstance(YMD_SLASH); 
     assertEquals(parser1, parser2); 
     assertEquals(parser1.hashCode(), parser2.hashCode()); 
     assertFalse(parser1.equals(new Object())); 
 }
@Test
public void testSpecialCharacters4901() throws Exception { 
     testSdfAndFdp("q", "", true); 
     testSdfAndFdp("Q", "", true); 
     testSdfAndFdp("$", "$", false); 
     testSdfAndFdp("?.d", "?.12", false); 
     testSdfAndFdp("''yyyyMMdd'A''B'HHmmssSSS''", "'20030210A'B153320989'", false); 
     testSdfAndFdp("''''yyyyMMdd'A''B'HHmmssSSS''", "''20030210A'B153320989'", false); 
     testSdfAndFdp("'$\\Ed'", "$\\Ed", false); 
 }
@Test
public void testEquals4983() { 
     final DateParser parser1 = getInstance(YMD_SLASH); 
     final DateParser parser2 = getInstance(YMD_SLASH); 
     assertEquals(parser1, parser2); 
     assertEquals(parser1.hashCode(), parser2.hashCode()); 
     assertFalse(parser1.equals(new Object())); 
 }
@Test
public void testSpecialCharacters4995() throws Exception { 
     testSdfAndFdp("q", "", true); 
     testSdfAndFdp("Q", "", true); 
     testSdfAndFdp("$", "$", false); 
     testSdfAndFdp("?.d", "?.12", false); 
     testSdfAndFdp("''yyyyMMdd'A''B'HHmmssSSS''", "'20030210A'B153320989'", false); 
     testSdfAndFdp("''''yyyyMMdd'A''B'HHmmssSSS''", "''20030210A'B153320989'", false); 
     testSdfAndFdp("'$\\Ed'", "$\\Ed", false); 
 }
@Test
public void testEquals5051() { 
     final DateParser parser1 = getInstance(YMD_SLASH); 
     final DateParser parser2 = getInstance(YMD_SLASH); 
     assertEquals(parser1, parser2); 
     assertEquals(parser1.hashCode(), parser2.hashCode()); 
     assertFalse(parser1.equals(new Object())); 
 }
@Test
public void testEquals5093() { 
     final DateParser parser1 = getInstance(YMD_SLASH); 
     final DateParser parser2 = getInstance(YMD_SLASH); 
     assertEquals(parser1, parser2); 
     assertEquals(parser1.hashCode(), parser2.hashCode()); 
     assertFalse(parser1.equals(new Object())); 
 }
@Test
public void test_Equality_Hash5196() { 
     final DateParser[] parsers = { getInstance(yMdHmsSZ, NEW_YORK, Locale.US), getInstance(DMY_DOT, NEW_YORK, Locale.US), getInstance(YMD_SLASH, NEW_YORK, Locale.US), getInstance(MDY_DASH, NEW_YORK, Locale.US), getInstance(MDY_SLASH, NEW_YORK, Locale.US), getInstance(MDY_SLASH, REYKJAVIK, Locale.US), getInstance(MDY_SLASH, REYKJAVIK, SWEDEN) }; 
     final Map<DateParser, Integer> map = new HashMap<DateParser, Integer>(); 
     int i = 0; 
     for (final DateParser parser : parsers) { 
         map.put(parser, Integer.valueOf(i++)); 
     } 
     i = 0; 
     for (final DateParser parser : parsers) { 
         assertEquals(i++, map.get(parser).intValue()); 
     } 
 }
@Test
public void testEquals5202() { 
     final DateParser parser1 = getInstance(YMD_SLASH); 
     final DateParser parser2 = getInstance(YMD_SLASH); 
     assertEquals(parser1, parser2); 
     assertEquals(parser1.hashCode(), parser2.hashCode()); 
     assertFalse(parser1.equals(new Object())); 
 }
@Test
public void testEquals5247() { 
     final DateParser parser1 = getInstance(YMD_SLASH); 
     final DateParser parser2 = getInstance(YMD_SLASH); 
     assertEquals(parser1, parser2); 
     assertEquals(parser1.hashCode(), parser2.hashCode()); 
     assertFalse(parser1.equals(new Object())); 
 }
@Test
public void testEquals5283() { 
     final DateParser parser1 = getInstance(YMD_SLASH); 
     final DateParser parser2 = getInstance(YMD_SLASH); 
     assertEquals(parser1, parser2); 
     assertEquals(parser1.hashCode(), parser2.hashCode()); 
     assertFalse(parser1.equals(new Object())); 
 }
@Test
public void testEquals5323() { 
     final DateParser parser1 = getInstance(YMD_SLASH); 
     final DateParser parser2 = getInstance(YMD_SLASH); 
     assertEquals(parser1, parser2); 
     assertEquals(parser1.hashCode(), parser2.hashCode()); 
     assertFalse(parser1.equals(new Object())); 
 }
@Test
public void testEquals5494() { 
     final DateParser parser1 = getInstance(YMD_SLASH); 
     final DateParser parser2 = getInstance(YMD_SLASH); 
     assertEquals(parser1, parser2); 
     assertEquals(parser1.hashCode(), parser2.hashCode()); 
     assertFalse(parser1.equals(new Object())); 
 }
@Test
public void testEquals5509() { 
     final DateParser parser1 = getInstance(YMD_SLASH); 
     final DateParser parser2 = getInstance(YMD_SLASH); 
     assertEquals(parser1, parser2); 
     assertEquals(parser1.hashCode(), parser2.hashCode()); 
     assertFalse(parser1.equals(new Object())); 
 }
@Test
public void testEquals5613() { 
     final DateParser parser1 = getInstance(YMD_SLASH); 
     final DateParser parser2 = getInstance(YMD_SLASH); 
     assertEquals(parser1, parser2); 
     assertEquals(parser1.hashCode(), parser2.hashCode()); 
     assertFalse(parser1.equals(new Object())); 
 }
@Test
public void testEquals5709() { 
     final DateParser parser1 = getInstance(YMD_SLASH); 
     final DateParser parser2 = getInstance(YMD_SLASH); 
     assertEquals(parser1, parser2); 
     assertEquals(parser1.hashCode(), parser2.hashCode()); 
     assertFalse(parser1.equals(new Object())); 
 }
@Test
public void testTimeZoneMatches5718() { 
     final DateParser parser = getInstance(yMdHmsSZ, REYKJAVIK); 
     assertEquals(REYKJAVIK, parser.getTimeZone()); 
 }
@Test
public void testEquals5719() { 
     final DateParser parser1 = getInstance(YMD_SLASH); 
     final DateParser parser2 = getInstance(YMD_SLASH); 
     assertEquals(parser1, parser2); 
     assertEquals(parser1.hashCode(), parser2.hashCode()); 
     assertFalse(parser1.equals(new Object())); 
 }
@Test
public void testTimeZoneMatches5834() { 
     final DateParser parser = getInstance(yMdHmsSZ, REYKJAVIK); 
     assertEquals(REYKJAVIK, parser.getTimeZone()); 
 }
@Test
public void testEquals5915() { 
     final DateParser parser1 = getInstance(YMD_SLASH); 
     final DateParser parser2 = getInstance(YMD_SLASH); 
     assertEquals(parser1, parser2); 
     assertEquals(parser1.hashCode(), parser2.hashCode()); 
     assertFalse(parser1.equals(new Object())); 
 }
@Test
public void testEquals5937() { 
     final DateParser parser1 = getInstance(YMD_SLASH); 
     final DateParser parser2 = getInstance(YMD_SLASH); 
     assertEquals(parser1, parser2); 
     assertEquals(parser1.hashCode(), parser2.hashCode()); 
     assertFalse(parser1.equals(new Object())); 
 }
@Test
public void testTimeZoneMatches5981() { 
     final DateParser parser = getInstance(yMdHmsSZ, REYKJAVIK); 
     assertEquals(REYKJAVIK, parser.getTimeZone()); 
 }
@Test
public void testSpecialCharacters6360() throws Exception { 
     testSdfAndFdp("q", "", true); 
     testSdfAndFdp("Q", "", true); 
     testSdfAndFdp("$", "$", false); 
     testSdfAndFdp("?.d", "?.12", false); 
     testSdfAndFdp("''yyyyMMdd'A''B'HHmmssSSS''", "'20030210A'B153320989'", false); 
     testSdfAndFdp("''''yyyyMMdd'A''B'HHmmssSSS''", "''20030210A'B153320989'", false); 
     testSdfAndFdp("'$\\Ed'", "$\\Ed", false); 
 }
@Test
public void testLang5386409() throws ParseException { 
     final DateParser parser = getInstance("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", GMT); 
     final Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("GMT-8")); 
     cal.clear(); 
     cal.set(2009, 9, 16, 8, 42, 16); 
     assertEquals(cal.getTime(), parser.parse("2009-10-16T16:42:16.000Z")); 
 }
@Test
public void testToStringContainsName6431() { 
     final DateParser parser = getInstance(YMD_SLASH); 
     assertTrue(parser.toString().startsWith("FastDate")); 
 }
@Test
public void testLANG_8316591() throws Exception { 
     testSdfAndFdp("M E", "3  Tue", true); 
 }
@Test
public void testEquals6611() { 
     final DateParser parser1 = getInstance(YMD_SLASH); 
     final DateParser parser2 = getInstance(YMD_SLASH); 
     assertEquals(parser1, parser2); 
     assertEquals(parser1.hashCode(), parser2.hashCode()); 
     assertFalse(parser1.equals(new Object())); 
 }
@Test
public void testSpecialCharacters6781() throws Exception { 
     testSdfAndFdp("q", "", true); 
     testSdfAndFdp("Q", "", true); 
     testSdfAndFdp("$", "$", false); 
     testSdfAndFdp("?.d", "?.12", false); 
     testSdfAndFdp("''yyyyMMdd'A''B'HHmmssSSS''", "'20030210A'B153320989'", false); 
     testSdfAndFdp("''''yyyyMMdd'A''B'HHmmssSSS''", "''20030210A'B153320989'", false); 
     testSdfAndFdp("'$\\Ed'", "$\\Ed", false); 
 }
@Test
public void testDayOf6839() throws ParseException { 
     final Calendar cal = Calendar.getInstance(NEW_YORK, Locale.US); 
     cal.clear(); 
     cal.set(2003, 1, 10); 
     final DateParser fdf = getInstance("W w F D y", NEW_YORK, Locale.US); 
     assertEquals(cal.getTime(), fdf.parse("3 7 2 41 03")); 
 }
@Test
public void testDayOf6944() throws ParseException { 
     final Calendar cal = Calendar.getInstance(NEW_YORK, Locale.US); 
     cal.clear(); 
     cal.set(2003, 1, 10); 
     final DateParser fdf = getInstance("W w F D y", NEW_YORK, Locale.US); 
     assertEquals(cal.getTime(), fdf.parse("3 7 2 41 03")); 
 }
@Test
public void testSpecialCharacters7017() throws Exception { 
     testSdfAndFdp("q", "", true); 
     testSdfAndFdp("Q", "", true); 
     testSdfAndFdp("$", "$", false); 
     testSdfAndFdp("?.d", "?.12", false); 
     testSdfAndFdp("''yyyyMMdd'A''B'HHmmssSSS''", "'20030210A'B153320989'", false); 
     testSdfAndFdp("''''yyyyMMdd'A''B'HHmmssSSS''", "''20030210A'B153320989'", false); 
     testSdfAndFdp("'$\\Ed'", "$\\Ed", false); 
 }
@Test
public void testEquals7274() { 
     final DateParser parser1 = getInstance(YMD_SLASH); 
     final DateParser parser2 = getInstance(YMD_SLASH); 
     assertEquals(parser1, parser2); 
     assertEquals(parser1.hashCode(), parser2.hashCode()); 
     assertFalse(parser1.equals(new Object())); 
 }
@Test
public void testSpecialCharacters7321() throws Exception { 
     testSdfAndFdp("q", "", true); 
     testSdfAndFdp("Q", "", true); 
     testSdfAndFdp("$", "$", false); 
     testSdfAndFdp("?.d", "?.12", false); 
     testSdfAndFdp("''yyyyMMdd'A''B'HHmmssSSS''", "'20030210A'B153320989'", false); 
     testSdfAndFdp("''''yyyyMMdd'A''B'HHmmssSSS''", "''20030210A'B153320989'", false); 
     testSdfAndFdp("'$\\Ed'", "$\\Ed", false); 
 }
@Test
public void testEquals7431() { 
     final DateParser parser1 = getInstance(YMD_SLASH); 
     final DateParser parser2 = getInstance(YMD_SLASH); 
     assertEquals(parser1, parser2); 
     assertEquals(parser1.hashCode(), parser2.hashCode()); 
     assertFalse(parser1.equals(new Object())); 
 }
@Test
public void testEquals7456() { 
     final DateParser parser1 = getInstance(YMD_SLASH); 
     final DateParser parser2 = getInstance(YMD_SLASH); 
     assertEquals(parser1, parser2); 
     assertEquals(parser1.hashCode(), parser2.hashCode()); 
     assertFalse(parser1.equals(new Object())); 
 }
@Test
public void testEquals7505() { 
     final DateParser parser1 = getInstance(YMD_SLASH); 
     final DateParser parser2 = getInstance(YMD_SLASH); 
     assertEquals(parser1, parser2); 
     assertEquals(parser1.hashCode(), parser2.hashCode()); 
     assertFalse(parser1.equals(new Object())); 
 }
@Test
public void testEquals7513() { 
     final DateParser parser1 = getInstance(YMD_SLASH); 
     final DateParser parser2 = getInstance(YMD_SLASH); 
     assertEquals(parser1, parser2); 
     assertEquals(parser1.hashCode(), parser2.hashCode()); 
     assertFalse(parser1.equals(new Object())); 
 }
@Test
public void test_Equality_Hash7552() { 
     final DateParser[] parsers = { getInstance(yMdHmsSZ, NEW_YORK, Locale.US), getInstance(DMY_DOT, NEW_YORK, Locale.US), getInstance(YMD_SLASH, NEW_YORK, Locale.US), getInstance(MDY_DASH, NEW_YORK, Locale.US), getInstance(MDY_SLASH, NEW_YORK, Locale.US), getInstance(MDY_SLASH, REYKJAVIK, Locale.US), getInstance(MDY_SLASH, REYKJAVIK, SWEDEN) }; 
     final Map<DateParser, Integer> map = new HashMap<DateParser, Integer>(); 
     int i = 0; 
     for (final DateParser parser : parsers) { 
         map.put(parser, Integer.valueOf(i++)); 
     } 
     i = 0; 
     for (final DateParser parser : parsers) { 
         assertEquals(i++, map.get(parser).intValue()); 
     } 
 }
@Test
public void testEquals7676() { 
     final DateParser parser1 = getInstance(YMD_SLASH); 
     final DateParser parser2 = getInstance(YMD_SLASH); 
     assertEquals(parser1, parser2); 
     assertEquals(parser1.hashCode(), parser2.hashCode()); 
     assertFalse(parser1.equals(new Object())); 
 }
@Test
public void testEquals7762() { 
     final DateParser parser1 = getInstance(YMD_SLASH); 
     final DateParser parser2 = getInstance(YMD_SLASH); 
     assertEquals(parser1, parser2); 
     assertEquals(parser1.hashCode(), parser2.hashCode()); 
     assertFalse(parser1.equals(new Object())); 
 }
@Test
public void testEquals7774() { 
     final DateParser parser1 = getInstance(YMD_SLASH); 
     final DateParser parser2 = getInstance(YMD_SLASH); 
     assertEquals(parser1, parser2); 
     assertEquals(parser1.hashCode(), parser2.hashCode()); 
     assertFalse(parser1.equals(new Object())); 
 }
@Test
public void testEquals7889() { 
     final DateParser parser1 = getInstance(YMD_SLASH); 
     final DateParser parser2 = getInstance(YMD_SLASH); 
     assertEquals(parser1, parser2); 
     assertEquals(parser1.hashCode(), parser2.hashCode()); 
     assertFalse(parser1.equals(new Object())); 
 }
@Test
public void testDayOf7913() throws ParseException { 
     final Calendar cal = Calendar.getInstance(NEW_YORK, Locale.US); 
     cal.clear(); 
     cal.set(2003, 1, 10); 
     final DateParser fdf = getInstance("W w F D y", NEW_YORK, Locale.US); 
     assertEquals(cal.getTime(), fdf.parse("3 7 2 41 03")); 
 }
@Test
public void testLocales_Long_AD7937() throws Exception { 
     testLocales(LONG_FORMAT, false); 
 }
@Test
public void testTimeZoneMatches7954() { 
     final DateParser parser = getInstance(yMdHmsSZ, REYKJAVIK); 
     assertEquals(REYKJAVIK, parser.getTimeZone()); 
 }
@Test
public void testEquals7959() { 
     final DateParser parser1 = getInstance(YMD_SLASH); 
     final DateParser parser2 = getInstance(YMD_SLASH); 
     assertEquals(parser1, parser2); 
     assertEquals(parser1.hashCode(), parser2.hashCode()); 
     assertFalse(parser1.equals(new Object())); 
 }
@Test
public void testDayOf8063() throws ParseException { 
     final Calendar cal = Calendar.getInstance(NEW_YORK, Locale.US); 
     cal.clear(); 
     cal.set(2003, 1, 10); 
     final DateParser fdf = getInstance("W w F D y", NEW_YORK, Locale.US); 
     assertEquals(cal.getTime(), fdf.parse("3 7 2 41 03")); 
 }
@Test
public void testEquals8206() { 
     final DateParser parser1 = getInstance(YMD_SLASH); 
     final DateParser parser2 = getInstance(YMD_SLASH); 
     assertEquals(parser1, parser2); 
     assertEquals(parser1.hashCode(), parser2.hashCode()); 
     assertFalse(parser1.equals(new Object())); 
 }
@Test
public void testDayOf8221() throws ParseException { 
     final Calendar cal = Calendar.getInstance(NEW_YORK, Locale.US); 
     cal.clear(); 
     cal.set(2003, 1, 10); 
     final DateParser fdf = getInstance("W w F D y", NEW_YORK, Locale.US); 
     assertEquals(cal.getTime(), fdf.parse("3 7 2 41 03")); 
 }
@Test
public void testEquals8286() { 
     final DateParser parser1 = getInstance(YMD_SLASH); 
     final DateParser parser2 = getInstance(YMD_SLASH); 
     assertEquals(parser1, parser2); 
     assertEquals(parser1.hashCode(), parser2.hashCode()); 
     assertFalse(parser1.equals(new Object())); 
 }
@Test
public void testEquals8327() { 
     final DateParser parser1 = getInstance(YMD_SLASH); 
     final DateParser parser2 = getInstance(YMD_SLASH); 
     assertEquals(parser1, parser2); 
     assertEquals(parser1.hashCode(), parser2.hashCode()); 
     assertFalse(parser1.equals(new Object())); 
 }
@Test
public void testLocales_Long_AD8349() throws Exception { 
     testLocales(LONG_FORMAT, false); 
 }
@Test
public void testDayOf8401() throws ParseException { 
     final Calendar cal = Calendar.getInstance(NEW_YORK, Locale.US); 
     cal.clear(); 
     cal.set(2003, 1, 10); 
     final DateParser fdf = getInstance("W w F D y", NEW_YORK, Locale.US); 
     assertEquals(cal.getTime(), fdf.parse("3 7 2 41 03")); 
 }
@Test
public void testSpecialCharacters8530() throws Exception { 
     testSdfAndFdp("q", "", true); 
     testSdfAndFdp("Q", "", true); 
     testSdfAndFdp("$", "$", false); 
     testSdfAndFdp("?.d", "?.12", false); 
     testSdfAndFdp("''yyyyMMdd'A''B'HHmmssSSS''", "'20030210A'B153320989'", false); 
     testSdfAndFdp("''''yyyyMMdd'A''B'HHmmssSSS''", "''20030210A'B153320989'", false); 
     testSdfAndFdp("'$\\Ed'", "$\\Ed", false); 
 }
@Test
public void testEquals8764() { 
     final DateParser parser1 = getInstance(YMD_SLASH); 
     final DateParser parser2 = getInstance(YMD_SLASH); 
     assertEquals(parser1, parser2); 
     assertEquals(parser1.hashCode(), parser2.hashCode()); 
     assertFalse(parser1.equals(new Object())); 
 }
@Test
public void testEquals8797() { 
     final DateParser parser1 = getInstance(YMD_SLASH); 
     final DateParser parser2 = getInstance(YMD_SLASH); 
     assertEquals(parser1, parser2); 
     assertEquals(parser1.hashCode(), parser2.hashCode()); 
     assertFalse(parser1.equals(new Object())); 
 }
@Test
public void testLANG_8318813() throws Exception { 
     testSdfAndFdp("M E", "3  Tue", true); 
 }
@Test
public void testEquals8818() { 
     final DateParser parser1 = getInstance(YMD_SLASH); 
     final DateParser parser2 = getInstance(YMD_SLASH); 
     assertEquals(parser1, parser2); 
     assertEquals(parser1.hashCode(), parser2.hashCode()); 
     assertFalse(parser1.equals(new Object())); 
 }
@Test
public void testSpecialCharacters8933() throws Exception { 
     testSdfAndFdp("q", "", true); 
     testSdfAndFdp("Q", "", true); 
     testSdfAndFdp("$", "$", false); 
     testSdfAndFdp("?.d", "?.12", false); 
     testSdfAndFdp("''yyyyMMdd'A''B'HHmmssSSS''", "'20030210A'B153320989'", false); 
     testSdfAndFdp("''''yyyyMMdd'A''B'HHmmssSSS''", "''20030210A'B153320989'", false); 
     testSdfAndFdp("'$\\Ed'", "$\\Ed", false); 
 }
@Test
public void testPatternMatches9179() { 
     final DateParser parser = getInstance(yMdHmsSZ); 
     assertEquals(yMdHmsSZ, parser.getPattern()); 
 }
@Test
public void test_Equality_Hash9292() { 
     final DateParser[] parsers = { getInstance(yMdHmsSZ, NEW_YORK, Locale.US), getInstance(DMY_DOT, NEW_YORK, Locale.US), getInstance(YMD_SLASH, NEW_YORK, Locale.US), getInstance(MDY_DASH, NEW_YORK, Locale.US), getInstance(MDY_SLASH, NEW_YORK, Locale.US), getInstance(MDY_SLASH, REYKJAVIK, Locale.US), getInstance(MDY_SLASH, REYKJAVIK, SWEDEN) }; 
     final Map<DateParser, Integer> map = new HashMap<DateParser, Integer>(); 
     int i = 0; 
     for (final DateParser parser : parsers) { 
         map.put(parser, Integer.valueOf(i++)); 
     } 
     i = 0; 
     for (final DateParser parser : parsers) { 
         assertEquals(i++, map.get(parser).intValue()); 
     } 
 }
@Test
public void test_Equality_Hash9303() { 
     final DateParser[] parsers = { getInstance(yMdHmsSZ, NEW_YORK, Locale.US), getInstance(DMY_DOT, NEW_YORK, Locale.US), getInstance(YMD_SLASH, NEW_YORK, Locale.US), getInstance(MDY_DASH, NEW_YORK, Locale.US), getInstance(MDY_SLASH, NEW_YORK, Locale.US), getInstance(MDY_SLASH, REYKJAVIK, Locale.US), getInstance(MDY_SLASH, REYKJAVIK, SWEDEN) }; 
     final Map<DateParser, Integer> map = new HashMap<DateParser, Integer>(); 
     int i = 0; 
     for (final DateParser parser : parsers) { 
         map.put(parser, Integer.valueOf(i++)); 
     } 
     i = 0; 
     for (final DateParser parser : parsers) { 
         assertEquals(i++, map.get(parser).intValue()); 
     } 
 }
@Test
public void testEquals9356() { 
     final DateParser parser1 = getInstance(YMD_SLASH); 
     final DateParser parser2 = getInstance(YMD_SLASH); 
     assertEquals(parser1, parser2); 
     assertEquals(parser1.hashCode(), parser2.hashCode()); 
     assertFalse(parser1.equals(new Object())); 
 }
@Test
public void testEquals9471() { 
     final DateParser parser1 = getInstance(YMD_SLASH); 
     final DateParser parser2 = getInstance(YMD_SLASH); 
     assertEquals(parser1, parser2); 
     assertEquals(parser1.hashCode(), parser2.hashCode()); 
     assertFalse(parser1.equals(new Object())); 
 }
@Test
public void testParseLongShort9556() throws ParseException { 
     final Calendar cal = Calendar.getInstance(NEW_YORK, Locale.US); 
     cal.clear(); 
     cal.set(2003, 1, 10, 15, 33, 20); 
     cal.set(Calendar.MILLISECOND, 989); 
     cal.setTimeZone(NEW_YORK); 
     DateParser fdf = getInstance("yyyy GGGG MMMM dddd aaaa EEEE HHHH mmmm ssss SSSS ZZZZ", NEW_YORK, Locale.US); 
     assertEquals(cal.getTime(), fdf.parse("2003 AD February 0010 PM Monday 0015 0033 0020 0989 GMT-05:00")); 
     cal.set(Calendar.ERA, GregorianCalendar.BC); 
     final Date parse = fdf.parse("2003 BC February 0010 PM Saturday 0015 0033 0020 0989 GMT-05:00"); 
     assertEquals(cal.getTime(), parse); 
     fdf = getInstance("y G M d a E H m s S Z", NEW_YORK, Locale.US); 
     assertEquals(cal.getTime(), fdf.parse("03 BC 2 10 PM Sat 15 33 20 989 -0500")); 
     cal.set(Calendar.ERA, GregorianCalendar.AD); 
     assertEquals(cal.getTime(), fdf.parse("03 AD 2 10 PM Saturday 15 33 20 989 -0500")); 
 }
@Test
public void testEquals9659() { 
         final DateParser parser1= getInstance(YMD_SLASH); 
         final DateParser parser2= getInstance(YMD_SLASH); 
  
         assertEquals(parser1, parser2); 
         assertEquals(parser1.hashCode(), parser2.hashCode()); 
  
         assertFalse(parser1.equals(new Object())); 
     }
@Test
public void testEquals9668() { 
         final DateParser parser1= getInstance(YMD_SLASH); 
         final DateParser parser2= getInstance(YMD_SLASH); 
  
         assertEquals(parser1, parser2); 
         assertEquals(parser1.hashCode(), parser2.hashCode()); 
  
         assertFalse(parser1.equals(new Object())); 
     }
@Test
public void testEquals11950() { 
         final DateParser parser1= getInstance(YMD_SLASH); 
         final DateParser parser2= getInstance(YMD_SLASH); 
  
         assertEquals(parser1, parser2); 
         assertEquals(parser1.hashCode(), parser2.hashCode()); 
  
         assertFalse(parser1.equals(new Object())); 
     }
@Test
public void testEquals11951() { 
         final DateParser parser1= getInstance(YMD_SLASH); 
         final DateParser parser2= getInstance(YMD_SLASH); 
  
         assertEquals(parser1, parser2); 
         assertEquals(parser1.hashCode(), parser2.hashCode()); 
  
         assertFalse(parser1.equals(new Object())); 
     }
@Test
public void testEquals11952() { 
         final DateParser parser1= getInstance(YMD_SLASH); 
         final DateParser parser2= getInstance(YMD_SLASH); 
  
         assertEquals(parser1, parser2); 
         assertEquals(parser1.hashCode(), parser2.hashCode()); 
  
         assertFalse(parser1.equals(new Object())); 
     }
@Test
public void testEquals11953() { 
         final DateParser parser1= getInstance(YMD_SLASH); 
         final DateParser parser2= getInstance(YMD_SLASH); 
  
         assertEquals(parser1, parser2); 
         assertEquals(parser1.hashCode(), parser2.hashCode()); 
  
         assertFalse(parser1.equals(new Object())); 
     }
@Test
public void testEquals11954() { 
         final DateParser parser1= getInstance(YMD_SLASH); 
         final DateParser parser2= getInstance(YMD_SLASH); 
  
         assertEquals(parser1, parser2); 
         assertEquals(parser1.hashCode(), parser2.hashCode()); 
  
         assertFalse(parser1.equals(new Object())); 
     }
@Test
public void testEquals11955() { 
         final DateParser parser1= getInstance(YMD_SLASH); 
         final DateParser parser2= getInstance(YMD_SLASH); 
  
         assertEquals(parser1, parser2); 
         assertEquals(parser1.hashCode(), parser2.hashCode()); 
  
         assertFalse(parser1.equals(new Object())); 
     }
@Test
public void testEquals11956() { 
         final DateParser parser1= getInstance(YMD_SLASH); 
         final DateParser parser2= getInstance(YMD_SLASH); 
  
         assertEquals(parser1, parser2); 
         assertEquals(parser1.hashCode(), parser2.hashCode()); 
  
         assertFalse(parser1.equals(new Object())); 
     }
@Test
public void testEquals11957() { 
         final DateParser parser1= getInstance(YMD_SLASH); 
         final DateParser parser2= getInstance(YMD_SLASH); 
  
         assertEquals(parser1, parser2); 
         assertEquals(parser1.hashCode(), parser2.hashCode()); 
  
         assertFalse(parser1.equals(new Object())); 
     }
@Test
public void testEquals11958() { 
         final DateParser parser1= getInstance(YMD_SLASH); 
         final DateParser parser2= getInstance(YMD_SLASH); 
  
         assertEquals(parser1, parser2); 
         assertEquals(parser1.hashCode(), parser2.hashCode()); 
  
         assertFalse(parser1.equals(new Object())); 
     }
@Test
public void testEquals11959() { 
         final DateParser parser1= getInstance(YMD_SLASH); 
         final DateParser parser2= getInstance(YMD_SLASH); 
  
         assertEquals(parser1, parser2); 
         assertEquals(parser1.hashCode(), parser2.hashCode()); 
  
         assertFalse(parser1.equals(new Object())); 
     }
@Test
public void testEquals11960() { 
         final DateParser parser1= getInstance(YMD_SLASH); 
         final DateParser parser2= getInstance(YMD_SLASH); 
  
         assertEquals(parser1, parser2); 
         assertEquals(parser1.hashCode(), parser2.hashCode()); 
  
         assertFalse(parser1.equals(new Object())); 
     }
@Test
public void testEquals11961() { 
         final DateParser parser1= getInstance(YMD_SLASH); 
         final DateParser parser2= getInstance(YMD_SLASH); 
  
         assertEquals(parser1, parser2); 
         assertEquals(parser1.hashCode(), parser2.hashCode()); 
  
         assertFalse(parser1.equals(new Object())); 
     }
@Test
public void testEquals11962() { 
         final DateParser parser1= getInstance(YMD_SLASH); 
         final DateParser parser2= getInstance(YMD_SLASH); 
  
         assertEquals(parser1, parser2); 
         assertEquals(parser1.hashCode(), parser2.hashCode()); 
  
         assertFalse(parser1.equals(new Object())); 
     }
@Test
public void testEquals11963() { 
         final DateParser parser1= getInstance(YMD_SLASH); 
         final DateParser parser2= getInstance(YMD_SLASH); 
  
         assertEquals(parser1, parser2); 
         assertEquals(parser1.hashCode(), parser2.hashCode()); 
  
         assertFalse(parser1.equals(new Object())); 
     }
@Test
public void testEquals11964() { 
         final DateParser parser1= getInstance(YMD_SLASH); 
         final DateParser parser2= getInstance(YMD_SLASH); 
  
         assertEquals(parser1, parser2); 
         assertEquals(parser1.hashCode(), parser2.hashCode()); 
  
         assertFalse(parser1.equals(new Object())); 
     }
@Test
public void testEquals11965() { 
         final DateParser parser1= getInstance(YMD_SLASH); 
         final DateParser parser2= getInstance(YMD_SLASH); 
  
         assertEquals(parser1, parser2); 
         assertEquals(parser1.hashCode(), parser2.hashCode()); 
  
         assertFalse(parser1.equals(new Object())); 
     }
@Test
public void testEquals11966() { 
         final DateParser parser1= getInstance(YMD_SLASH); 
         final DateParser parser2= getInstance(YMD_SLASH); 
  
         assertEquals(parser1, parser2); 
         assertEquals(parser1.hashCode(), parser2.hashCode()); 
  
         assertFalse(parser1.equals(new Object())); 
     }
@Test
public void testEquals11967() { 
         final DateParser parser1= getInstance(YMD_SLASH); 
         final DateParser parser2= getInstance(YMD_SLASH); 
  
         assertEquals(parser1, parser2); 
         assertEquals(parser1.hashCode(), parser2.hashCode()); 
  
         assertFalse(parser1.equals(new Object())); 
     }
@Test
public void testEquals11968() { 
         final DateParser parser1= getInstance(YMD_SLASH); 
         final DateParser parser2= getInstance(YMD_SLASH); 
  
         assertEquals(parser1, parser2); 
         assertEquals(parser1.hashCode(), parser2.hashCode()); 
  
         assertFalse(parser1.equals(new Object())); 
     }
@Test
public void testEquals11969() { 
         final DateParser parser1= getInstance(YMD_SLASH); 
         final DateParser parser2= getInstance(YMD_SLASH); 
  
         assertEquals(parser1, parser2); 
         assertEquals(parser1.hashCode(), parser2.hashCode()); 
  
         assertFalse(parser1.equals(new Object())); 
     }
@Test
public void testEquals11973() { 
         final DateParser parser1= getInstance(YMD_SLASH); 
         final DateParser parser2= getInstance(YMD_SLASH); 
  
         assertEquals(parser1, parser2); 
         assertEquals(parser1.hashCode(), parser2.hashCode()); 
  
         assertFalse(parser1.equals(new Object())); 
     }
@Test
public void testEquals11974() { 
         final DateParser parser1= getInstance(YMD_SLASH); 
         final DateParser parser2= getInstance(YMD_SLASH); 
  
         assertEquals(parser1, parser2); 
         assertEquals(parser1.hashCode(), parser2.hashCode()); 
  
         assertFalse(parser1.equals(new Object())); 
     }
@Test
public void testLang64511976() { 
         final Locale locale = new Locale("sv", "SE"); 
  
         final Calendar cal = Calendar.getInstance(); 
         cal.set(2010, 0, 1, 12, 0, 0); 
         final Date d = cal.getTime(); 
  
         final DatePrinter fdf = getInstance("EEEE', week 'ww", locale); 
  
         assertEquals("fredag, week 53", fdf.format(d)); 
     }
@Test
public void testLang64511978() { 
         final Locale locale = new Locale("sv", "SE"); 
  
         final Calendar cal = Calendar.getInstance(); 
         cal.set(2010, 0, 1, 12, 0, 0); 
         final Date d = cal.getTime(); 
  
         final DatePrinter fdf = getInstance("EEEE', week 'ww", locale); 
  
         assertEquals("fredag, week 53", fdf.format(d)); 
     }
@Test
public void testEquals11981() { 
         final DateParser parser1= getInstance(YMD_SLASH); 
         final DateParser parser2= getInstance(YMD_SLASH); 
  
         assertEquals(parser1, parser2); 
         assertEquals(parser1.hashCode(), parser2.hashCode()); 
  
         assertFalse(parser1.equals(new Object())); 
     }
@Test
public void testEquals11982() { 
         final DateParser parser1= getInstance(YMD_SLASH); 
         final DateParser parser2= getInstance(YMD_SLASH); 
  
         assertEquals(parser1, parser2); 
         assertEquals(parser1.hashCode(), parser2.hashCode()); 
  
         assertFalse(parser1.equals(new Object())); 
     }
@Test
public void testEquals12262() { 
         final DateParser parser1= getInstance(YMD_SLASH); 
         final DateParser parser2= getInstance(YMD_SLASH); 
  
         assertEquals(parser1, parser2); 
         assertEquals(parser1.hashCode(), parser2.hashCode()); 
  
         assertFalse(parser1.equals(new Object())); 
     }
@Test
public void testEquals12263() { 
         final DateParser parser1= getInstance(YMD_SLASH); 
         final DateParser parser2= getInstance(YMD_SLASH); 
  
         assertEquals(parser1, parser2); 
         assertEquals(parser1.hashCode(), parser2.hashCode()); 
  
         assertFalse(parser1.equals(new Object())); 
     }
@Test
public void testEquals12264() { 
         final DateParser parser1= getInstance(YMD_SLASH); 
         final DateParser parser2= getInstance(YMD_SLASH); 
  
         assertEquals(parser1, parser2); 
         assertEquals(parser1.hashCode(), parser2.hashCode()); 
  
         assertFalse(parser1.equals(new Object())); 
     }
@Test
public void testEquals12266() { 
         final DateParser parser1= getInstance(YMD_SLASH); 
         final DateParser parser2= getInstance(YMD_SLASH); 
  
         assertEquals(parser1, parser2); 
         assertEquals(parser1.hashCode(), parser2.hashCode()); 
  
         assertFalse(parser1.equals(new Object())); 
     }
@Test
public void testEquals12267() { 
         final DateParser parser1= getInstance(YMD_SLASH); 
         final DateParser parser2= getInstance(YMD_SLASH); 
  
         assertEquals(parser1, parser2); 
         assertEquals(parser1.hashCode(), parser2.hashCode()); 
  
         assertFalse(parser1.equals(new Object())); 
     }
@Test
public void testEquals12271() { 
         final DateParser parser1= getInstance(YMD_SLASH); 
         final DateParser parser2= getInstance(YMD_SLASH); 
  
         assertEquals(parser1, parser2); 
         assertEquals(parser1.hashCode(), parser2.hashCode()); 
  
         assertFalse(parser1.equals(new Object())); 
     }
@Test
public void testEquals12272() { 
         final DateParser parser1= getInstance(YMD_SLASH); 
         final DateParser parser2= getInstance(YMD_SLASH); 
  
         assertEquals(parser1, parser2); 
         assertEquals(parser1.hashCode(), parser2.hashCode()); 
  
         assertFalse(parser1.equals(new Object())); 
     }
@Test
public void testEquals12274() { 
         final DateParser parser1= getInstance(YMD_SLASH); 
         final DateParser parser2= getInstance(YMD_SLASH); 
  
         assertEquals(parser1, parser2); 
         assertEquals(parser1.hashCode(), parser2.hashCode()); 
  
         assertFalse(parser1.equals(new Object())); 
     }
@Test
public void testEquals12275() { 
         final DateParser parser1= getInstance(YMD_SLASH); 
         final DateParser parser2= getInstance(YMD_SLASH); 
  
         assertEquals(parser1, parser2); 
         assertEquals(parser1.hashCode(), parser2.hashCode()); 
  
         assertFalse(parser1.equals(new Object())); 
     }
@Test
public void testEquals12276() { 
         final DateParser parser1= getInstance(YMD_SLASH); 
         final DateParser parser2= getInstance(YMD_SLASH); 
  
         assertEquals(parser1, parser2); 
         assertEquals(parser1.hashCode(), parser2.hashCode()); 
  
         assertFalse(parser1.equals(new Object())); 
     }
@Test
public void testEquals12277() { 
         final DateParser parser1= getInstance(YMD_SLASH); 
         final DateParser parser2= getInstance(YMD_SLASH); 
  
         assertEquals(parser1, parser2); 
         assertEquals(parser1.hashCode(), parser2.hashCode()); 
  
         assertFalse(parser1.equals(new Object())); 
     }
@Test
public void testEquals12278() { 
         final DateParser parser1= getInstance(YMD_SLASH); 
         final DateParser parser2= getInstance(YMD_SLASH); 
  
         assertEquals(parser1, parser2); 
         assertEquals(parser1.hashCode(), parser2.hashCode()); 
  
         assertFalse(parser1.equals(new Object())); 
     }
@Test
public void testEquals12279() { 
         final DateParser parser1= getInstance(YMD_SLASH); 
         final DateParser parser2= getInstance(YMD_SLASH); 
  
         assertEquals(parser1, parser2); 
         assertEquals(parser1.hashCode(), parser2.hashCode()); 
  
         assertFalse(parser1.equals(new Object())); 
     }
@Test
public void testEquals12280() { 
         final DateParser parser1= getInstance(YMD_SLASH); 
         final DateParser parser2= getInstance(YMD_SLASH); 
  
         assertEquals(parser1, parser2); 
         assertEquals(parser1.hashCode(), parser2.hashCode()); 
  
         assertFalse(parser1.equals(new Object())); 
     }
@Test
public void testEquals12283() { 
         final DateParser parser1= getInstance(YMD_SLASH); 
         final DateParser parser2= getInstance(YMD_SLASH); 
  
         assertEquals(parser1, parser2); 
         assertEquals(parser1.hashCode(), parser2.hashCode()); 
  
         assertFalse(parser1.equals(new Object())); 
     }
@Test
public void testEquals12287() { 
         final DateParser parser1= getInstance(YMD_SLASH); 
         final DateParser parser2= getInstance(YMD_SLASH); 
  
         assertEquals(parser1, parser2); 
         assertEquals(parser1.hashCode(), parser2.hashCode()); 
  
         assertFalse(parser1.equals(new Object())); 
     }
@Test
public void testEquals12288() { 
         final DateParser parser1= getInstance(YMD_SLASH); 
         final DateParser parser2= getInstance(YMD_SLASH); 
  
         assertEquals(parser1, parser2); 
         assertEquals(parser1.hashCode(), parser2.hashCode()); 
  
         assertFalse(parser1.equals(new Object())); 
     }
@Test
public void testEquals12290() { 
         final DateParser parser1= getInstance(YMD_SLASH); 
         final DateParser parser2= getInstance(YMD_SLASH); 
  
         assertEquals(parser1, parser2); 
         assertEquals(parser1.hashCode(), parser2.hashCode()); 
  
         assertFalse(parser1.equals(new Object())); 
     }
@Test
public void testEquals12291() { 
         final DateParser parser1= getInstance(YMD_SLASH); 
         final DateParser parser2= getInstance(YMD_SLASH); 
  
         assertEquals(parser1, parser2); 
         assertEquals(parser1.hashCode(), parser2.hashCode()); 
  
         assertFalse(parser1.equals(new Object())); 
     }
@Test
public void testEquals12293() { 
         final DateParser parser1= getInstance(YMD_SLASH); 
         final DateParser parser2= getInstance(YMD_SLASH); 
  
         assertEquals(parser1, parser2); 
         assertEquals(parser1.hashCode(), parser2.hashCode()); 
  
         assertFalse(parser1.equals(new Object())); 
     }
@Test
public void testEquals12296() { 
         final DateParser parser1= getInstance(YMD_SLASH); 
         final DateParser parser2= getInstance(YMD_SLASH); 
  
         assertEquals(parser1, parser2); 
         assertEquals(parser1.hashCode(), parser2.hashCode()); 
  
         assertFalse(parser1.equals(new Object())); 
     }
@Test
public void testEquals12299() { 
         final DateParser parser1= getInstance(YMD_SLASH); 
         final DateParser parser2= getInstance(YMD_SLASH); 
  
         assertEquals(parser1, parser2); 
         assertEquals(parser1.hashCode(), parser2.hashCode()); 
  
         assertFalse(parser1.equals(new Object())); 
     }
@Test
public void testEquals12300() { 
         final DateParser parser1= getInstance(YMD_SLASH); 
         final DateParser parser2= getInstance(YMD_SLASH); 
  
         assertEquals(parser1, parser2); 
         assertEquals(parser1.hashCode(), parser2.hashCode()); 
  
         assertFalse(parser1.equals(new Object())); 
     }
@Test
public void testEquals12301() { 
         final DateParser parser1= getInstance(YMD_SLASH); 
         final DateParser parser2= getInstance(YMD_SLASH); 
  
         assertEquals(parser1, parser2); 
         assertEquals(parser1.hashCode(), parser2.hashCode()); 
  
         assertFalse(parser1.equals(new Object())); 
     }
@Test
public void testEquals12302() { 
         final DateParser parser1= getInstance(YMD_SLASH); 
         final DateParser parser2= getInstance(YMD_SLASH); 
  
         assertEquals(parser1, parser2); 
         assertEquals(parser1.hashCode(), parser2.hashCode()); 
  
         assertFalse(parser1.equals(new Object())); 
     }
@Test
public void testEquals12303() { 
         final DateParser parser1= getInstance(YMD_SLASH); 
         final DateParser parser2= getInstance(YMD_SLASH); 
  
         assertEquals(parser1, parser2); 
         assertEquals(parser1.hashCode(), parser2.hashCode()); 
  
         assertFalse(parser1.equals(new Object())); 
     }
@Test
public void testEquals12304() { 
         final DateParser parser1= getInstance(YMD_SLASH); 
         final DateParser parser2= getInstance(YMD_SLASH); 
  
         assertEquals(parser1, parser2); 
         assertEquals(parser1.hashCode(), parser2.hashCode()); 
  
         assertFalse(parser1.equals(new Object())); 
     }
@Test
public void testEquals12305() { 
         final DateParser parser1= getInstance(YMD_SLASH); 
         final DateParser parser2= getInstance(YMD_SLASH); 
  
         assertEquals(parser1, parser2); 
         assertEquals(parser1.hashCode(), parser2.hashCode()); 
  
         assertFalse(parser1.equals(new Object())); 
     }
@Test
public void testEquals12306() { 
         final DateParser parser1= getInstance(YMD_SLASH); 
         final DateParser parser2= getInstance(YMD_SLASH); 
  
         assertEquals(parser1, parser2); 
         assertEquals(parser1.hashCode(), parser2.hashCode()); 
  
         assertFalse(parser1.equals(new Object())); 
     }
@Test
public void testEquals12308() { 
         final DateParser parser1= getInstance(YMD_SLASH); 
         final DateParser parser2= getInstance(YMD_SLASH); 
  
         assertEquals(parser1, parser2); 
         assertEquals(parser1.hashCode(), parser2.hashCode()); 
  
         assertFalse(parser1.equals(new Object())); 
     }
@Test
public void testEquals12309() { 
         final DateParser parser1= getInstance(YMD_SLASH); 
         final DateParser parser2= getInstance(YMD_SLASH); 
  
         assertEquals(parser1, parser2); 
         assertEquals(parser1.hashCode(), parser2.hashCode()); 
  
         assertFalse(parser1.equals(new Object())); 
     }
@Test
public void testEquals12310() { 
         final DateParser parser1= getInstance(YMD_SLASH); 
         final DateParser parser2= getInstance(YMD_SLASH); 
  
         assertEquals(parser1, parser2); 
         assertEquals(parser1.hashCode(), parser2.hashCode()); 
  
         assertFalse(parser1.equals(new Object())); 
     }
@Test
public void testEquals12312() { 
         final DateParser parser1= getInstance(YMD_SLASH); 
         final DateParser parser2= getInstance(YMD_SLASH); 
  
         assertEquals(parser1, parser2); 
         assertEquals(parser1.hashCode(), parser2.hashCode()); 
  
         assertFalse(parser1.equals(new Object())); 
     }
@Test
public void testEquals12313() { 
         final DateParser parser1= getInstance(YMD_SLASH); 
         final DateParser parser2= getInstance(YMD_SLASH); 
  
         assertEquals(parser1, parser2); 
         assertEquals(parser1.hashCode(), parser2.hashCode()); 
  
         assertFalse(parser1.equals(new Object())); 
     }
@Test
public void testEquals12314() { 
         final DateParser parser1= getInstance(YMD_SLASH); 
         final DateParser parser2= getInstance(YMD_SLASH); 
  
         assertEquals(parser1, parser2); 
         assertEquals(parser1.hashCode(), parser2.hashCode()); 
  
         assertFalse(parser1.equals(new Object())); 
     }
@Test
public void testEquals12315() { 
         final DateParser parser1= getInstance(YMD_SLASH); 
         final DateParser parser2= getInstance(YMD_SLASH); 
  
         assertEquals(parser1, parser2); 
         assertEquals(parser1.hashCode(), parser2.hashCode()); 
  
         assertFalse(parser1.equals(new Object())); 
     }
@Test
public void testEquals12316() { 
         final DateParser parser1= getInstance(YMD_SLASH); 
         final DateParser parser2= getInstance(YMD_SLASH); 
  
         assertEquals(parser1, parser2); 
         assertEquals(parser1.hashCode(), parser2.hashCode()); 
  
         assertFalse(parser1.equals(new Object())); 
     }
@Test
public void testEquals12318() { 
         final DateParser parser1= getInstance(YMD_SLASH); 
         final DateParser parser2= getInstance(YMD_SLASH); 
  
         assertEquals(parser1, parser2); 
         assertEquals(parser1.hashCode(), parser2.hashCode()); 
  
         assertFalse(parser1.equals(new Object())); 
     }
@Test
public void testEquals12320() { 
         final DateParser parser1= getInstance(YMD_SLASH); 
         final DateParser parser2= getInstance(YMD_SLASH); 
  
         assertEquals(parser1, parser2); 
         assertEquals(parser1.hashCode(), parser2.hashCode()); 
  
         assertFalse(parser1.equals(new Object())); 
     }
@Test
public void testEquals12321() { 
         final DateParser parser1= getInstance(YMD_SLASH); 
         final DateParser parser2= getInstance(YMD_SLASH); 
  
         assertEquals(parser1, parser2); 
         assertEquals(parser1.hashCode(), parser2.hashCode()); 
  
         assertFalse(parser1.equals(new Object())); 
     }
@Test
public void testEquals12322() { 
         final DateParser parser1= getInstance(YMD_SLASH); 
         final DateParser parser2= getInstance(YMD_SLASH); 
  
         assertEquals(parser1, parser2); 
         assertEquals(parser1.hashCode(), parser2.hashCode()); 
  
         assertFalse(parser1.equals(new Object())); 
     }
@Test
public void testEquals12323() { 
         final DateParser parser1= getInstance(YMD_SLASH); 
         final DateParser parser2= getInstance(YMD_SLASH); 
  
         assertEquals(parser1, parser2); 
         assertEquals(parser1.hashCode(), parser2.hashCode()); 
  
         assertFalse(parser1.equals(new Object())); 
     }
@Test
public void testEquals12324() { 
         final DateParser parser1= getInstance(YMD_SLASH); 
         final DateParser parser2= getInstance(YMD_SLASH); 
  
         assertEquals(parser1, parser2); 
         assertEquals(parser1.hashCode(), parser2.hashCode()); 
  
         assertFalse(parser1.equals(new Object())); 
     }
@Test
public void testEquals12325() { 
         final DateParser parser1= getInstance(YMD_SLASH); 
         final DateParser parser2= getInstance(YMD_SLASH); 
  
         assertEquals(parser1, parser2); 
         assertEquals(parser1.hashCode(), parser2.hashCode()); 
  
         assertFalse(parser1.equals(new Object())); 
     }
@Test
public void testEquals12326() { 
         final DateParser parser1= getInstance(YMD_SLASH); 
         final DateParser parser2= getInstance(YMD_SLASH); 
  
         assertEquals(parser1, parser2); 
         assertEquals(parser1.hashCode(), parser2.hashCode()); 
  
         assertFalse(parser1.equals(new Object())); 
     }
@Test
public void testEquals12327() { 
         final DateParser parser1= getInstance(YMD_SLASH); 
         final DateParser parser2= getInstance(YMD_SLASH); 
  
         assertEquals(parser1, parser2); 
         assertEquals(parser1.hashCode(), parser2.hashCode()); 
  
         assertFalse(parser1.equals(new Object())); 
     }
@Test
public void testEquals12328() { 
         final DateParser parser1= getInstance(YMD_SLASH); 
         final DateParser parser2= getInstance(YMD_SLASH); 
  
         assertEquals(parser1, parser2); 
         assertEquals(parser1.hashCode(), parser2.hashCode()); 
  
         assertFalse(parser1.equals(new Object())); 
     }
@Test
public void testEquals12329() { 
         final DateParser parser1= getInstance(YMD_SLASH); 
         final DateParser parser2= getInstance(YMD_SLASH); 
  
         assertEquals(parser1, parser2); 
         assertEquals(parser1.hashCode(), parser2.hashCode()); 
  
         assertFalse(parser1.equals(new Object())); 
     }
@Test
public void testEquals12330() { 
         final DateParser parser1= getInstance(YMD_SLASH); 
         final DateParser parser2= getInstance(YMD_SLASH); 
  
         assertEquals(parser1, parser2); 
         assertEquals(parser1.hashCode(), parser2.hashCode()); 
  
         assertFalse(parser1.equals(new Object())); 
     }
@Test
public void testEquals12331() { 
         final DateParser parser1= getInstance(YMD_SLASH); 
         final DateParser parser2= getInstance(YMD_SLASH); 
  
         assertEquals(parser1, parser2); 
         assertEquals(parser1.hashCode(), parser2.hashCode()); 
  
         assertFalse(parser1.equals(new Object())); 
     }
@Test
public void testEquals12332() { 
         final DateParser parser1= getInstance(YMD_SLASH); 
         final DateParser parser2= getInstance(YMD_SLASH); 
  
         assertEquals(parser1, parser2); 
         assertEquals(parser1.hashCode(), parser2.hashCode()); 
  
         assertFalse(parser1.equals(new Object())); 
     }
@Test
public void testEquals12333() { 
         final DateParser parser1= getInstance(YMD_SLASH); 
         final DateParser parser2= getInstance(YMD_SLASH); 
  
         assertEquals(parser1, parser2); 
         assertEquals(parser1.hashCode(), parser2.hashCode()); 
  
         assertFalse(parser1.equals(new Object())); 
     }
@Test
public void testEquals12336() { 
         final DateParser parser1= getInstance(YMD_SLASH); 
         final DateParser parser2= getInstance(YMD_SLASH); 
  
         assertEquals(parser1, parser2); 
         assertEquals(parser1.hashCode(), parser2.hashCode()); 
  
         assertFalse(parser1.equals(new Object())); 
     }
@Test
public void testEquals12337() { 
         final DateParser parser1= getInstance(YMD_SLASH); 
         final DateParser parser2= getInstance(YMD_SLASH); 
  
         assertEquals(parser1, parser2); 
         assertEquals(parser1.hashCode(), parser2.hashCode()); 
  
         assertFalse(parser1.equals(new Object())); 
     }
@Test
public void testEquals12339() { 
         final DateParser parser1= getInstance(YMD_SLASH); 
         final DateParser parser2= getInstance(YMD_SLASH); 
  
         assertEquals(parser1, parser2); 
         assertEquals(parser1.hashCode(), parser2.hashCode()); 
  
         assertFalse(parser1.equals(new Object())); 
     }
    

    
// Defects4J: flaky method
//     @Test
//     public void testParseZone() throws ParseException {
//         final Calendar cal= Calendar.getInstance(NEW_YORK, Locale.US);
//         cal.clear();
//         cal.set(2003, 6, 10, 16, 33, 20);
// 
//         final DateParser fdf = getInstance(yMdHmsSZ, NEW_YORK, Locale.US);
// 
//         assertEquals(cal.getTime(), fdf.parse("2003-07-10T15:33:20.000 -0500"));
//         assertEquals(cal.getTime(), fdf.parse("2003-07-10T15:33:20.000 GMT-05:00"));
//         assertEquals(cal.getTime(), fdf.parse("2003-07-10T16:33:20.000 Eastern Daylight Time"));
//         assertEquals(cal.getTime(), fdf.parse("2003-07-10T16:33:20.000 EDT"));
// 
//         cal.setTimeZone(TimeZone.getTimeZone("GMT-3"));
//         cal.set(2003, 1, 10, 9, 0, 0);
// 
//         assertEquals(cal.getTime(), fdf.parse("2003-02-10T09:00:00.000 -0300"));
// 
//         cal.setTimeZone(TimeZone.getTimeZone("GMT+5"));
//         cal.set(2003, 1, 10, 15, 5, 6);
// 
//         assertEquals(cal.getTime(), fdf.parse("2003-02-10T15:05:06.000 +0500"));
//     }

    

    

    

    

    

    

    

    

    

    

    

    private void testLocales(final String format, final boolean eraBC) throws Exception {

        final Calendar cal= Calendar.getInstance(GMT);
        cal.clear();
        cal.set(2003, 1, 10);
        if (eraBC) {
            cal.set(Calendar.ERA, GregorianCalendar.BC);
        }
        for(final Locale locale : Locale.getAvailableLocales()) {
            // ja_JP_JP cannot handle dates before 1868 properly
            if (eraBC && locale.equals(FastDateParser.JAPANESE_IMPERIAL)) {
                continue;
            }
            final SimpleDateFormat sdf = new SimpleDateFormat(format, locale);
            final DateParser fdf = getInstance(format, locale);

            try {
                checkParse(locale, cal, sdf, fdf);
            } catch(final ParseException ex) {
                Assert.fail("Locale "+locale+ " failed with "+format+" era "+(eraBC?"BC":"AD")+"\n" + trimMessage(ex.toString()));
            }
        }
    }

    private String trimMessage(final String msg) {
        if (msg.length() < 100) {
            return msg;
        }
        final int gmt = msg.indexOf("(GMT");
        if (gmt > 0) {
            return msg.substring(0, gmt+4)+"...)";
        }
        return msg.substring(0, 100)+"...";
    }

    private void checkParse(final Locale locale, final Calendar cal, final SimpleDateFormat sdf, final DateParser fdf) throws ParseException {
        final String formattedDate= sdf.format(cal.getTime());
        final Date expectedTime = sdf.parse(formattedDate);
        final Date actualTime = fdf.parse(formattedDate);
        assertEquals(locale.toString()+" "+formattedDate
                +"\n",expectedTime, actualTime);
    }

    

    

    

    

    

    private void testSdfAndFdp(final String format, final String date, final boolean shouldFail)
            throws Exception {
        final boolean debug = false;
        Date dfdp = null;
        Date dsdf = null;
        Throwable f = null;
        Throwable s = null;

        try {
            final SimpleDateFormat sdf = new SimpleDateFormat(format, Locale.US);
            sdf.setTimeZone(NEW_YORK);
            dsdf = sdf.parse(date);
            if (shouldFail) {
                Assert.fail("Expected SDF failure, but got " + dsdf + " for ["+format+","+date+"]");
            }
        } catch (final Exception e) {
            s = e;
            if (!shouldFail) {
                throw e;
            }
            if (debug) {
                System.out.println("sdf:"+format+"/"+date+"=>"+e);
            }
        }

        try {
            final DateParser fdp = getInstance(format, NEW_YORK, Locale.US);
            dfdp = fdp.parse(date);
            if (shouldFail) {
                Assert.fail("Expected FDF failure, but got " + dfdp + " for ["+format+","+date+"] using "+((FastDateParser)fdp).getParsePattern());
            }
        } catch (final Exception e) {
            f = e;
            if (!shouldFail) {
                throw e;
            }
            if (debug) {
                System.out.println("fdf:"+format+"/"+date+"=>"+e);
            }
        }
        // SDF and FDF should produce equivalent results
        assertTrue("Should both or neither throw Exceptions", (f==null)==(s==null));
        assertEquals("Parsed dates should be equal", dsdf, dfdp);
        if (debug) {
            System.out.println(format + "," + date + " => " + dsdf);
        }
    }

    

    /**
     * Test case for {@link FastDateParser#FastDateParser(String, TimeZone, Locale)}.
     * @throws ParseException
     */
    

    /**
     * Tests that pre-1000AD years get padded with yyyy
     * @throws ParseException
     */
    

    /**
     * @throws ParseException
     */
    

    

    

    

    

    

    

    
}
