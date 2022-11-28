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

package org.apache.commons.lang3.time;

import org.junit.Test;
import static org.junit.Assert.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;
import java.util.Calendar;
import java.util.TimeZone;

/**
 * TestCase for DurationFormatUtils.
 * 
 */
public class DurationFormatUtilsTest {

    // -----------------------------------------------------------------------
@Test
public void testLexx84() { 
     assertArrayEquals(new DurationFormatUtils.Token[] { new DurationFormatUtils.Token(DurationFormatUtils.y, 1), new DurationFormatUtils.Token(DurationFormatUtils.M, 1), new DurationFormatUtils.Token(DurationFormatUtils.d, 1), new DurationFormatUtils.Token(DurationFormatUtils.H, 1), new DurationFormatUtils.Token(DurationFormatUtils.m, 1), new DurationFormatUtils.Token(DurationFormatUtils.s, 1), new DurationFormatUtils.Token(DurationFormatUtils.S, 1) }, DurationFormatUtils.lexx("yMdHmsS")); 
     assertArrayEquals(new DurationFormatUtils.Token[] { new DurationFormatUtils.Token(DurationFormatUtils.H, 1), new DurationFormatUtils.Token(new StringBuilder(":"), 1), new DurationFormatUtils.Token(DurationFormatUtils.m, 2), new DurationFormatUtils.Token(new StringBuilder(":"), 1), new DurationFormatUtils.Token(DurationFormatUtils.s, 2), new DurationFormatUtils.Token(new StringBuilder("."), 1), new DurationFormatUtils.Token(DurationFormatUtils.S, 3) }, DurationFormatUtils.lexx("H:mm:ss.SSS")); 
     assertArrayEquals(new DurationFormatUtils.Token[] { new DurationFormatUtils.Token(new StringBuilder("P"), 1), new DurationFormatUtils.Token(DurationFormatUtils.y, 4), new DurationFormatUtils.Token(new StringBuilder("Y"), 1), new DurationFormatUtils.Token(DurationFormatUtils.M, 1), new DurationFormatUtils.Token(new StringBuilder("M"), 1), new DurationFormatUtils.Token(DurationFormatUtils.d, 1), new DurationFormatUtils.Token(new StringBuilder("DT"), 1), new DurationFormatUtils.Token(DurationFormatUtils.H, 1), new DurationFormatUtils.Token(new StringBuilder("H"), 1), new DurationFormatUtils.Token(DurationFormatUtils.m, 1), new DurationFormatUtils.Token(new StringBuilder("M"), 1), new DurationFormatUtils.Token(DurationFormatUtils.s, 1), new DurationFormatUtils.Token(new StringBuilder("."), 1), new DurationFormatUtils.Token(DurationFormatUtils.S, 1), new DurationFormatUtils.Token(new StringBuilder("S"), 1) }, DurationFormatUtils.lexx(DurationFormatUtils.ISO_EXTENDED_FORMAT_PATTERN)); 
     final DurationFormatUtils.Token token = new DurationFormatUtils.Token(DurationFormatUtils.y, 4); 
     assertFalse("Token equal to non-Token class. ", token.equals(new Object())); 
     assertFalse("Token equal to Token with wrong value class. ", token.equals(new DurationFormatUtils.Token(new Object()))); 
     assertFalse("Token equal to Token with different count. ", token.equals(new DurationFormatUtils.Token(DurationFormatUtils.y, 1))); 
     final DurationFormatUtils.Token numToken = new DurationFormatUtils.Token(Integer.valueOf(1), 4); 
     assertTrue("Token with Number value not equal to itself. ", numToken.equals(numToken)); 
 }
@Test
public void testFormatPeriodISO168() { 
     final TimeZone timeZone = TimeZone.getTimeZone("GMT-3"); 
     final Calendar base = Calendar.getInstance(timeZone); 
     base.set(1970, 0, 1, 0, 0, 0); 
     base.set(Calendar.MILLISECOND, 0); 
     final Calendar cal = Calendar.getInstance(timeZone); 
     cal.set(2002, 1, 23, 9, 11, 12); 
     cal.set(Calendar.MILLISECOND, 1); 
     String text; 
     text = DateFormatUtils.ISO_DATETIME_TIME_ZONE_FORMAT.format(cal); 
     assertEquals("2002-02-23T09:11:12-03:00", text); 
     text = DurationFormatUtils.formatPeriod(base.getTime().getTime(), cal.getTime().getTime(), DurationFormatUtils.ISO_EXTENDED_FORMAT_PATTERN, false, timeZone); 
     assertEquals("P32Y1M22DT9H11M12.001S", text); 
     cal.set(1971, 1, 3, 10, 30, 0); 
     cal.set(Calendar.MILLISECOND, 0); 
     text = DurationFormatUtils.formatPeriod(base.getTime().getTime(), cal.getTime().getTime(), DurationFormatUtils.ISO_EXTENDED_FORMAT_PATTERN, false, timeZone); 
     assertEquals("P1Y1M2DT10H30M0.000S", text); 
 }
@Test
public void testLANG815288() { 
     final Calendar calendar = Calendar.getInstance(); 
     calendar.set(2012, 6, 30, 0, 0, 0); 
     final long startMillis = calendar.getTimeInMillis(); 
     calendar.set(2012, 8, 8); 
     final long endMillis = calendar.getTimeInMillis(); 
     assertEquals("1 9", DurationFormatUtils.formatPeriod(startMillis, endMillis, "M d")); 
 }
@Test
public void testLexx339() { 
     assertArrayEquals(new DurationFormatUtils.Token[] { new DurationFormatUtils.Token(DurationFormatUtils.y, 1), new DurationFormatUtils.Token(DurationFormatUtils.M, 1), new DurationFormatUtils.Token(DurationFormatUtils.d, 1), new DurationFormatUtils.Token(DurationFormatUtils.H, 1), new DurationFormatUtils.Token(DurationFormatUtils.m, 1), new DurationFormatUtils.Token(DurationFormatUtils.s, 1), new DurationFormatUtils.Token(DurationFormatUtils.S, 1) }, DurationFormatUtils.lexx("yMdHmsS")); 
     assertArrayEquals(new DurationFormatUtils.Token[] { new DurationFormatUtils.Token(DurationFormatUtils.H, 1), new DurationFormatUtils.Token(new StringBuilder(":"), 1), new DurationFormatUtils.Token(DurationFormatUtils.m, 2), new DurationFormatUtils.Token(new StringBuilder(":"), 1), new DurationFormatUtils.Token(DurationFormatUtils.s, 2), new DurationFormatUtils.Token(new StringBuilder("."), 1), new DurationFormatUtils.Token(DurationFormatUtils.S, 3) }, DurationFormatUtils.lexx("H:mm:ss.SSS")); 
     assertArrayEquals(new DurationFormatUtils.Token[] { new DurationFormatUtils.Token(new StringBuilder("P"), 1), new DurationFormatUtils.Token(DurationFormatUtils.y, 4), new DurationFormatUtils.Token(new StringBuilder("Y"), 1), new DurationFormatUtils.Token(DurationFormatUtils.M, 1), new DurationFormatUtils.Token(new StringBuilder("M"), 1), new DurationFormatUtils.Token(DurationFormatUtils.d, 1), new DurationFormatUtils.Token(new StringBuilder("DT"), 1), new DurationFormatUtils.Token(DurationFormatUtils.H, 1), new DurationFormatUtils.Token(new StringBuilder("H"), 1), new DurationFormatUtils.Token(DurationFormatUtils.m, 1), new DurationFormatUtils.Token(new StringBuilder("M"), 1), new DurationFormatUtils.Token(DurationFormatUtils.s, 1), new DurationFormatUtils.Token(new StringBuilder("."), 1), new DurationFormatUtils.Token(DurationFormatUtils.S, 1), new DurationFormatUtils.Token(new StringBuilder("S"), 1) }, DurationFormatUtils.lexx(DurationFormatUtils.ISO_EXTENDED_FORMAT_PATTERN)); 
     final DurationFormatUtils.Token token = new DurationFormatUtils.Token(DurationFormatUtils.y, 4); 
     assertFalse("Token equal to non-Token class. ", token.equals(new Object())); 
     assertFalse("Token equal to Token with wrong value class. ", token.equals(new DurationFormatUtils.Token(new Object()))); 
     assertFalse("Token equal to Token with different count. ", token.equals(new DurationFormatUtils.Token(DurationFormatUtils.y, 1))); 
     final DurationFormatUtils.Token numToken = new DurationFormatUtils.Token(Integer.valueOf(1), 4); 
     assertTrue("Token with Number value not equal to itself. ", numToken.equals(numToken)); 
 }
@Test
public void testLexx361() { 
     assertArrayEquals(new DurationFormatUtils.Token[] { new DurationFormatUtils.Token(DurationFormatUtils.y, 1), new DurationFormatUtils.Token(DurationFormatUtils.M, 1), new DurationFormatUtils.Token(DurationFormatUtils.d, 1), new DurationFormatUtils.Token(DurationFormatUtils.H, 1), new DurationFormatUtils.Token(DurationFormatUtils.m, 1), new DurationFormatUtils.Token(DurationFormatUtils.s, 1), new DurationFormatUtils.Token(DurationFormatUtils.S, 1) }, DurationFormatUtils.lexx("yMdHmsS")); 
     assertArrayEquals(new DurationFormatUtils.Token[] { new DurationFormatUtils.Token(DurationFormatUtils.H, 1), new DurationFormatUtils.Token(new StringBuilder(":"), 1), new DurationFormatUtils.Token(DurationFormatUtils.m, 2), new DurationFormatUtils.Token(new StringBuilder(":"), 1), new DurationFormatUtils.Token(DurationFormatUtils.s, 2), new DurationFormatUtils.Token(new StringBuilder("."), 1), new DurationFormatUtils.Token(DurationFormatUtils.S, 3) }, DurationFormatUtils.lexx("H:mm:ss.SSS")); 
     assertArrayEquals(new DurationFormatUtils.Token[] { new DurationFormatUtils.Token(new StringBuilder("P"), 1), new DurationFormatUtils.Token(DurationFormatUtils.y, 4), new DurationFormatUtils.Token(new StringBuilder("Y"), 1), new DurationFormatUtils.Token(DurationFormatUtils.M, 1), new DurationFormatUtils.Token(new StringBuilder("M"), 1), new DurationFormatUtils.Token(DurationFormatUtils.d, 1), new DurationFormatUtils.Token(new StringBuilder("DT"), 1), new DurationFormatUtils.Token(DurationFormatUtils.H, 1), new DurationFormatUtils.Token(new StringBuilder("H"), 1), new DurationFormatUtils.Token(DurationFormatUtils.m, 1), new DurationFormatUtils.Token(new StringBuilder("M"), 1), new DurationFormatUtils.Token(DurationFormatUtils.s, 1), new DurationFormatUtils.Token(new StringBuilder("."), 1), new DurationFormatUtils.Token(DurationFormatUtils.S, 1), new DurationFormatUtils.Token(new StringBuilder("S"), 1) }, DurationFormatUtils.lexx(DurationFormatUtils.ISO_EXTENDED_FORMAT_PATTERN)); 
     final DurationFormatUtils.Token token = new DurationFormatUtils.Token(DurationFormatUtils.y, 4); 
     assertFalse("Token equal to non-Token class. ", token.equals(new Object())); 
     assertFalse("Token equal to Token with wrong value class. ", token.equals(new DurationFormatUtils.Token(new Object()))); 
     assertFalse("Token equal to Token with different count. ", token.equals(new DurationFormatUtils.Token(DurationFormatUtils.y, 1))); 
     final DurationFormatUtils.Token numToken = new DurationFormatUtils.Token(Integer.valueOf(1), 4); 
     assertTrue("Token with Number value not equal to itself. ", numToken.equals(numToken)); 
 }
@Test
public void testFormatPeriodISO483() { 
     final TimeZone timeZone = TimeZone.getTimeZone("GMT-3"); 
     final Calendar base = Calendar.getInstance(timeZone); 
     base.set(1970, 0, 1, 0, 0, 0); 
     base.set(Calendar.MILLISECOND, 0); 
     final Calendar cal = Calendar.getInstance(timeZone); 
     cal.set(2002, 1, 23, 9, 11, 12); 
     cal.set(Calendar.MILLISECOND, 1); 
     String text; 
     text = DateFormatUtils.ISO_DATETIME_TIME_ZONE_FORMAT.format(cal); 
     assertEquals("2002-02-23T09:11:12-03:00", text); 
     text = DurationFormatUtils.formatPeriod(base.getTime().getTime(), cal.getTime().getTime(), DurationFormatUtils.ISO_EXTENDED_FORMAT_PATTERN, false, timeZone); 
     assertEquals("P32Y1M22DT9H11M12.001S", text); 
     cal.set(1971, 1, 3, 10, 30, 0); 
     cal.set(Calendar.MILLISECOND, 0); 
     text = DurationFormatUtils.formatPeriod(base.getTime().getTime(), cal.getTime().getTime(), DurationFormatUtils.ISO_EXTENDED_FORMAT_PATTERN, false, timeZone); 
     assertEquals("P1Y1M2DT10H30M0.000S", text); 
 }
@Test
public void testLexx649() { 
     assertArrayEquals(new DurationFormatUtils.Token[] { new DurationFormatUtils.Token(DurationFormatUtils.y, 1), new DurationFormatUtils.Token(DurationFormatUtils.M, 1), new DurationFormatUtils.Token(DurationFormatUtils.d, 1), new DurationFormatUtils.Token(DurationFormatUtils.H, 1), new DurationFormatUtils.Token(DurationFormatUtils.m, 1), new DurationFormatUtils.Token(DurationFormatUtils.s, 1), new DurationFormatUtils.Token(DurationFormatUtils.S, 1) }, DurationFormatUtils.lexx("yMdHmsS")); 
     assertArrayEquals(new DurationFormatUtils.Token[] { new DurationFormatUtils.Token(DurationFormatUtils.H, 1), new DurationFormatUtils.Token(new StringBuilder(":"), 1), new DurationFormatUtils.Token(DurationFormatUtils.m, 2), new DurationFormatUtils.Token(new StringBuilder(":"), 1), new DurationFormatUtils.Token(DurationFormatUtils.s, 2), new DurationFormatUtils.Token(new StringBuilder("."), 1), new DurationFormatUtils.Token(DurationFormatUtils.S, 3) }, DurationFormatUtils.lexx("H:mm:ss.SSS")); 
     assertArrayEquals(new DurationFormatUtils.Token[] { new DurationFormatUtils.Token(new StringBuilder("P"), 1), new DurationFormatUtils.Token(DurationFormatUtils.y, 4), new DurationFormatUtils.Token(new StringBuilder("Y"), 1), new DurationFormatUtils.Token(DurationFormatUtils.M, 1), new DurationFormatUtils.Token(new StringBuilder("M"), 1), new DurationFormatUtils.Token(DurationFormatUtils.d, 1), new DurationFormatUtils.Token(new StringBuilder("DT"), 1), new DurationFormatUtils.Token(DurationFormatUtils.H, 1), new DurationFormatUtils.Token(new StringBuilder("H"), 1), new DurationFormatUtils.Token(DurationFormatUtils.m, 1), new DurationFormatUtils.Token(new StringBuilder("M"), 1), new DurationFormatUtils.Token(DurationFormatUtils.s, 1), new DurationFormatUtils.Token(new StringBuilder("."), 1), new DurationFormatUtils.Token(DurationFormatUtils.S, 1), new DurationFormatUtils.Token(new StringBuilder("S"), 1) }, DurationFormatUtils.lexx(DurationFormatUtils.ISO_EXTENDED_FORMAT_PATTERN)); 
     final DurationFormatUtils.Token token = new DurationFormatUtils.Token(DurationFormatUtils.y, 4); 
     assertFalse("Token equal to non-Token class. ", token.equals(new Object())); 
     assertFalse("Token equal to Token with wrong value class. ", token.equals(new DurationFormatUtils.Token(new Object()))); 
     assertFalse("Token equal to Token with different count. ", token.equals(new DurationFormatUtils.Token(DurationFormatUtils.y, 1))); 
     final DurationFormatUtils.Token numToken = new DurationFormatUtils.Token(Integer.valueOf(1), 4); 
     assertTrue("Token with Number value not equal to itself. ", numToken.equals(numToken)); 
 }
@Test
public void testFormatPeriodISO689() { 
     final TimeZone timeZone = TimeZone.getTimeZone("GMT-3"); 
     final Calendar base = Calendar.getInstance(timeZone); 
     base.set(1970, 0, 1, 0, 0, 0); 
     base.set(Calendar.MILLISECOND, 0); 
     final Calendar cal = Calendar.getInstance(timeZone); 
     cal.set(2002, 1, 23, 9, 11, 12); 
     cal.set(Calendar.MILLISECOND, 1); 
     String text; 
     text = DateFormatUtils.ISO_DATETIME_TIME_ZONE_FORMAT.format(cal); 
     assertEquals("2002-02-23T09:11:12-03:00", text); 
     text = DurationFormatUtils.formatPeriod(base.getTime().getTime(), cal.getTime().getTime(), DurationFormatUtils.ISO_EXTENDED_FORMAT_PATTERN, false, timeZone); 
     assertEquals("P32Y1M22DT9H11M12.001S", text); 
     cal.set(1971, 1, 3, 10, 30, 0); 
     cal.set(Calendar.MILLISECOND, 0); 
     text = DurationFormatUtils.formatPeriod(base.getTime().getTime(), cal.getTime().getTime(), DurationFormatUtils.ISO_EXTENDED_FORMAT_PATTERN, false, timeZone); 
     assertEquals("P1Y1M2DT10H30M0.000S", text); 
 }
@Test
public void testLexx952() { 
     assertArrayEquals(new DurationFormatUtils.Token[] { new DurationFormatUtils.Token(DurationFormatUtils.y, 1), new DurationFormatUtils.Token(DurationFormatUtils.M, 1), new DurationFormatUtils.Token(DurationFormatUtils.d, 1), new DurationFormatUtils.Token(DurationFormatUtils.H, 1), new DurationFormatUtils.Token(DurationFormatUtils.m, 1), new DurationFormatUtils.Token(DurationFormatUtils.s, 1), new DurationFormatUtils.Token(DurationFormatUtils.S, 1) }, DurationFormatUtils.lexx("yMdHmsS")); 
     assertArrayEquals(new DurationFormatUtils.Token[] { new DurationFormatUtils.Token(DurationFormatUtils.H, 1), new DurationFormatUtils.Token(new StringBuilder(":"), 1), new DurationFormatUtils.Token(DurationFormatUtils.m, 2), new DurationFormatUtils.Token(new StringBuilder(":"), 1), new DurationFormatUtils.Token(DurationFormatUtils.s, 2), new DurationFormatUtils.Token(new StringBuilder("."), 1), new DurationFormatUtils.Token(DurationFormatUtils.S, 3) }, DurationFormatUtils.lexx("H:mm:ss.SSS")); 
     assertArrayEquals(new DurationFormatUtils.Token[] { new DurationFormatUtils.Token(new StringBuilder("P"), 1), new DurationFormatUtils.Token(DurationFormatUtils.y, 4), new DurationFormatUtils.Token(new StringBuilder("Y"), 1), new DurationFormatUtils.Token(DurationFormatUtils.M, 1), new DurationFormatUtils.Token(new StringBuilder("M"), 1), new DurationFormatUtils.Token(DurationFormatUtils.d, 1), new DurationFormatUtils.Token(new StringBuilder("DT"), 1), new DurationFormatUtils.Token(DurationFormatUtils.H, 1), new DurationFormatUtils.Token(new StringBuilder("H"), 1), new DurationFormatUtils.Token(DurationFormatUtils.m, 1), new DurationFormatUtils.Token(new StringBuilder("M"), 1), new DurationFormatUtils.Token(DurationFormatUtils.s, 1), new DurationFormatUtils.Token(new StringBuilder("."), 1), new DurationFormatUtils.Token(DurationFormatUtils.S, 1), new DurationFormatUtils.Token(new StringBuilder("S"), 1) }, DurationFormatUtils.lexx(DurationFormatUtils.ISO_EXTENDED_FORMAT_PATTERN)); 
     final DurationFormatUtils.Token token = new DurationFormatUtils.Token(DurationFormatUtils.y, 4); 
     assertFalse("Token equal to non-Token class. ", token.equals(new Object())); 
     assertFalse("Token equal to Token with wrong value class. ", token.equals(new DurationFormatUtils.Token(new Object()))); 
     assertFalse("Token equal to Token with different count. ", token.equals(new DurationFormatUtils.Token(DurationFormatUtils.y, 1))); 
     final DurationFormatUtils.Token numToken = new DurationFormatUtils.Token(Integer.valueOf(1), 4); 
     assertTrue("Token with Number value not equal to itself. ", numToken.equals(numToken)); 
 }
@Test
public void testFormatDuration1102() { 
     long duration = 0; 
     assertEquals("0", DurationFormatUtils.formatDuration(duration, "y")); 
     assertEquals("0", DurationFormatUtils.formatDuration(duration, "M")); 
     assertEquals("0", DurationFormatUtils.formatDuration(duration, "d")); 
     assertEquals("0", DurationFormatUtils.formatDuration(duration, "H")); 
     assertEquals("0", DurationFormatUtils.formatDuration(duration, "m")); 
     assertEquals("0", DurationFormatUtils.formatDuration(duration, "s")); 
     assertEquals("0", DurationFormatUtils.formatDuration(duration, "S")); 
     assertEquals("0000", DurationFormatUtils.formatDuration(duration, "SSSS")); 
     assertEquals("0000", DurationFormatUtils.formatDuration(duration, "yyyy")); 
     assertEquals("0000", DurationFormatUtils.formatDuration(duration, "yyMM")); 
     duration = 60 * 1000; 
     assertEquals("0", DurationFormatUtils.formatDuration(duration, "y")); 
     assertEquals("0", DurationFormatUtils.formatDuration(duration, "M")); 
     assertEquals("0", DurationFormatUtils.formatDuration(duration, "d")); 
     assertEquals("0", DurationFormatUtils.formatDuration(duration, "H")); 
     assertEquals("1", DurationFormatUtils.formatDuration(duration, "m")); 
     assertEquals("60", DurationFormatUtils.formatDuration(duration, "s")); 
     assertEquals("60000", DurationFormatUtils.formatDuration(duration, "S")); 
     assertEquals("01:00", DurationFormatUtils.formatDuration(duration, "mm:ss")); 
     final Calendar base = Calendar.getInstance(); 
     base.set(2000, 0, 1, 0, 0, 0); 
     base.set(Calendar.MILLISECOND, 0); 
     final Calendar cal = Calendar.getInstance(); 
     cal.set(2003, 1, 1, 0, 0, 0); 
     cal.set(Calendar.MILLISECOND, 0); 
     duration = cal.getTime().getTime() - base.getTime().getTime(); 
     final int days = 366 + 365 + 365 + 31; 
     assertEquals("0 0 " + days, DurationFormatUtils.formatDuration(duration, "y M d")); 
 }
@Test
public void testLexx1448() { 
     assertArrayEquals(new DurationFormatUtils.Token[] { new DurationFormatUtils.Token(DurationFormatUtils.y, 1), new DurationFormatUtils.Token(DurationFormatUtils.M, 1), new DurationFormatUtils.Token(DurationFormatUtils.d, 1), new DurationFormatUtils.Token(DurationFormatUtils.H, 1), new DurationFormatUtils.Token(DurationFormatUtils.m, 1), new DurationFormatUtils.Token(DurationFormatUtils.s, 1), new DurationFormatUtils.Token(DurationFormatUtils.S, 1) }, DurationFormatUtils.lexx("yMdHmsS")); 
     assertArrayEquals(new DurationFormatUtils.Token[] { new DurationFormatUtils.Token(DurationFormatUtils.H, 1), new DurationFormatUtils.Token(new StringBuilder(":"), 1), new DurationFormatUtils.Token(DurationFormatUtils.m, 2), new DurationFormatUtils.Token(new StringBuilder(":"), 1), new DurationFormatUtils.Token(DurationFormatUtils.s, 2), new DurationFormatUtils.Token(new StringBuilder("."), 1), new DurationFormatUtils.Token(DurationFormatUtils.S, 3) }, DurationFormatUtils.lexx("H:mm:ss.SSS")); 
     assertArrayEquals(new DurationFormatUtils.Token[] { new DurationFormatUtils.Token(new StringBuilder("P"), 1), new DurationFormatUtils.Token(DurationFormatUtils.y, 4), new DurationFormatUtils.Token(new StringBuilder("Y"), 1), new DurationFormatUtils.Token(DurationFormatUtils.M, 1), new DurationFormatUtils.Token(new StringBuilder("M"), 1), new DurationFormatUtils.Token(DurationFormatUtils.d, 1), new DurationFormatUtils.Token(new StringBuilder("DT"), 1), new DurationFormatUtils.Token(DurationFormatUtils.H, 1), new DurationFormatUtils.Token(new StringBuilder("H"), 1), new DurationFormatUtils.Token(DurationFormatUtils.m, 1), new DurationFormatUtils.Token(new StringBuilder("M"), 1), new DurationFormatUtils.Token(DurationFormatUtils.s, 1), new DurationFormatUtils.Token(new StringBuilder("."), 1), new DurationFormatUtils.Token(DurationFormatUtils.S, 1), new DurationFormatUtils.Token(new StringBuilder("S"), 1) }, DurationFormatUtils.lexx(DurationFormatUtils.ISO_EXTENDED_FORMAT_PATTERN)); 
     final DurationFormatUtils.Token token = new DurationFormatUtils.Token(DurationFormatUtils.y, 4); 
     assertFalse("Token equal to non-Token class. ", token.equals(new Object())); 
     assertFalse("Token equal to Token with wrong value class. ", token.equals(new DurationFormatUtils.Token(new Object()))); 
     assertFalse("Token equal to Token with different count. ", token.equals(new DurationFormatUtils.Token(DurationFormatUtils.y, 1))); 
     final DurationFormatUtils.Token numToken = new DurationFormatUtils.Token(Integer.valueOf(1), 4); 
     assertTrue("Token with Number value not equal to itself. ", numToken.equals(numToken)); 
 }
@Test
public void testLexx1836() { 
     assertArrayEquals(new DurationFormatUtils.Token[] { new DurationFormatUtils.Token(DurationFormatUtils.y, 1), new DurationFormatUtils.Token(DurationFormatUtils.M, 1), new DurationFormatUtils.Token(DurationFormatUtils.d, 1), new DurationFormatUtils.Token(DurationFormatUtils.H, 1), new DurationFormatUtils.Token(DurationFormatUtils.m, 1), new DurationFormatUtils.Token(DurationFormatUtils.s, 1), new DurationFormatUtils.Token(DurationFormatUtils.S, 1) }, DurationFormatUtils.lexx("yMdHmsS")); 
     assertArrayEquals(new DurationFormatUtils.Token[] { new DurationFormatUtils.Token(DurationFormatUtils.H, 1), new DurationFormatUtils.Token(new StringBuilder(":"), 1), new DurationFormatUtils.Token(DurationFormatUtils.m, 2), new DurationFormatUtils.Token(new StringBuilder(":"), 1), new DurationFormatUtils.Token(DurationFormatUtils.s, 2), new DurationFormatUtils.Token(new StringBuilder("."), 1), new DurationFormatUtils.Token(DurationFormatUtils.S, 3) }, DurationFormatUtils.lexx("H:mm:ss.SSS")); 
     assertArrayEquals(new DurationFormatUtils.Token[] { new DurationFormatUtils.Token(new StringBuilder("P"), 1), new DurationFormatUtils.Token(DurationFormatUtils.y, 4), new DurationFormatUtils.Token(new StringBuilder("Y"), 1), new DurationFormatUtils.Token(DurationFormatUtils.M, 1), new DurationFormatUtils.Token(new StringBuilder("M"), 1), new DurationFormatUtils.Token(DurationFormatUtils.d, 1), new DurationFormatUtils.Token(new StringBuilder("DT"), 1), new DurationFormatUtils.Token(DurationFormatUtils.H, 1), new DurationFormatUtils.Token(new StringBuilder("H"), 1), new DurationFormatUtils.Token(DurationFormatUtils.m, 1), new DurationFormatUtils.Token(new StringBuilder("M"), 1), new DurationFormatUtils.Token(DurationFormatUtils.s, 1), new DurationFormatUtils.Token(new StringBuilder("."), 1), new DurationFormatUtils.Token(DurationFormatUtils.S, 1), new DurationFormatUtils.Token(new StringBuilder("S"), 1) }, DurationFormatUtils.lexx(DurationFormatUtils.ISO_EXTENDED_FORMAT_PATTERN)); 
     final DurationFormatUtils.Token token = new DurationFormatUtils.Token(DurationFormatUtils.y, 4); 
     assertFalse("Token equal to non-Token class. ", token.equals(new Object())); 
     assertFalse("Token equal to Token with wrong value class. ", token.equals(new DurationFormatUtils.Token(new Object()))); 
     assertFalse("Token equal to Token with different count. ", token.equals(new DurationFormatUtils.Token(DurationFormatUtils.y, 1))); 
     final DurationFormatUtils.Token numToken = new DurationFormatUtils.Token(Integer.valueOf(1), 4); 
     assertTrue("Token with Number value not equal to itself. ", numToken.equals(numToken)); 
 }
@Test
public void testFormatPeriodISO2214() { 
     final TimeZone timeZone = TimeZone.getTimeZone("GMT-3"); 
     final Calendar base = Calendar.getInstance(timeZone); 
     base.set(1970, 0, 1, 0, 0, 0); 
     base.set(Calendar.MILLISECOND, 0); 
     final Calendar cal = Calendar.getInstance(timeZone); 
     cal.set(2002, 1, 23, 9, 11, 12); 
     cal.set(Calendar.MILLISECOND, 1); 
     String text; 
     text = DateFormatUtils.ISO_DATETIME_TIME_ZONE_FORMAT.format(cal); 
     assertEquals("2002-02-23T09:11:12-03:00", text); 
     text = DurationFormatUtils.formatPeriod(base.getTime().getTime(), cal.getTime().getTime(), DurationFormatUtils.ISO_EXTENDED_FORMAT_PATTERN, false, timeZone); 
     assertEquals("P32Y1M22DT9H11M12.001S", text); 
     cal.set(1971, 1, 3, 10, 30, 0); 
     cal.set(Calendar.MILLISECOND, 0); 
     text = DurationFormatUtils.formatPeriod(base.getTime().getTime(), cal.getTime().getTime(), DurationFormatUtils.ISO_EXTENDED_FORMAT_PATTERN, false, timeZone); 
     assertEquals("P1Y1M2DT10H30M0.000S", text); 
 }
@Test
public void testLexx2428() { 
     assertArrayEquals(new DurationFormatUtils.Token[] { new DurationFormatUtils.Token(DurationFormatUtils.y, 1), new DurationFormatUtils.Token(DurationFormatUtils.M, 1), new DurationFormatUtils.Token(DurationFormatUtils.d, 1), new DurationFormatUtils.Token(DurationFormatUtils.H, 1), new DurationFormatUtils.Token(DurationFormatUtils.m, 1), new DurationFormatUtils.Token(DurationFormatUtils.s, 1), new DurationFormatUtils.Token(DurationFormatUtils.S, 1) }, DurationFormatUtils.lexx("yMdHmsS")); 
     assertArrayEquals(new DurationFormatUtils.Token[] { new DurationFormatUtils.Token(DurationFormatUtils.H, 1), new DurationFormatUtils.Token(new StringBuilder(":"), 1), new DurationFormatUtils.Token(DurationFormatUtils.m, 2), new DurationFormatUtils.Token(new StringBuilder(":"), 1), new DurationFormatUtils.Token(DurationFormatUtils.s, 2), new DurationFormatUtils.Token(new StringBuilder("."), 1), new DurationFormatUtils.Token(DurationFormatUtils.S, 3) }, DurationFormatUtils.lexx("H:mm:ss.SSS")); 
     assertArrayEquals(new DurationFormatUtils.Token[] { new DurationFormatUtils.Token(new StringBuilder("P"), 1), new DurationFormatUtils.Token(DurationFormatUtils.y, 4), new DurationFormatUtils.Token(new StringBuilder("Y"), 1), new DurationFormatUtils.Token(DurationFormatUtils.M, 1), new DurationFormatUtils.Token(new StringBuilder("M"), 1), new DurationFormatUtils.Token(DurationFormatUtils.d, 1), new DurationFormatUtils.Token(new StringBuilder("DT"), 1), new DurationFormatUtils.Token(DurationFormatUtils.H, 1), new DurationFormatUtils.Token(new StringBuilder("H"), 1), new DurationFormatUtils.Token(DurationFormatUtils.m, 1), new DurationFormatUtils.Token(new StringBuilder("M"), 1), new DurationFormatUtils.Token(DurationFormatUtils.s, 1), new DurationFormatUtils.Token(new StringBuilder("."), 1), new DurationFormatUtils.Token(DurationFormatUtils.S, 1), new DurationFormatUtils.Token(new StringBuilder("S"), 1) }, DurationFormatUtils.lexx(DurationFormatUtils.ISO_EXTENDED_FORMAT_PATTERN)); 
     final DurationFormatUtils.Token token = new DurationFormatUtils.Token(DurationFormatUtils.y, 4); 
     assertFalse("Token equal to non-Token class. ", token.equals(new Object())); 
     assertFalse("Token equal to Token with wrong value class. ", token.equals(new DurationFormatUtils.Token(new Object()))); 
     assertFalse("Token equal to Token with different count. ", token.equals(new DurationFormatUtils.Token(DurationFormatUtils.y, 1))); 
     final DurationFormatUtils.Token numToken = new DurationFormatUtils.Token(Integer.valueOf(1), 4); 
     assertTrue("Token with Number value not equal to itself. ", numToken.equals(numToken)); 
 }
@Test
public void testLANG8152650() { 
     final Calendar calendar = Calendar.getInstance(); 
     calendar.set(2012, 6, 30, 0, 0, 0); 
     final long startMillis = calendar.getTimeInMillis(); 
     calendar.set(2012, 8, 8); 
     final long endMillis = calendar.getTimeInMillis(); 
     assertEquals("1 9", DurationFormatUtils.formatPeriod(startMillis, endMillis, "M d")); 
 }
@Test
public void testFormatDurationHMS3181() { 
     long time = 0; 
     assertEquals("0:00:00.000", DurationFormatUtils.formatDurationHMS(time)); 
     time = 1; 
     assertEquals("0:00:00.001", DurationFormatUtils.formatDurationHMS(time)); 
     time = 15; 
     assertEquals("0:00:00.015", DurationFormatUtils.formatDurationHMS(time)); 
     time = 165; 
     assertEquals("0:00:00.165", DurationFormatUtils.formatDurationHMS(time)); 
     time = 1675; 
     assertEquals("0:00:01.675", DurationFormatUtils.formatDurationHMS(time)); 
     time = 13465; 
     assertEquals("0:00:13.465", DurationFormatUtils.formatDurationHMS(time)); 
     time = 72789; 
     assertEquals("0:01:12.789", DurationFormatUtils.formatDurationHMS(time)); 
     time = 12789 + 32 * 60000; 
     assertEquals("0:32:12.789", DurationFormatUtils.formatDurationHMS(time)); 
     time = 12789 + 62 * 60000; 
     assertEquals("1:02:12.789", DurationFormatUtils.formatDurationHMS(time)); 
 }
@Test
public void testFormatDurationHMS3298() { 
     long time = 0; 
     assertEquals("0:00:00.000", DurationFormatUtils.formatDurationHMS(time)); 
     time = 1; 
     assertEquals("0:00:00.001", DurationFormatUtils.formatDurationHMS(time)); 
     time = 15; 
     assertEquals("0:00:00.015", DurationFormatUtils.formatDurationHMS(time)); 
     time = 165; 
     assertEquals("0:00:00.165", DurationFormatUtils.formatDurationHMS(time)); 
     time = 1675; 
     assertEquals("0:00:01.675", DurationFormatUtils.formatDurationHMS(time)); 
     time = 13465; 
     assertEquals("0:00:13.465", DurationFormatUtils.formatDurationHMS(time)); 
     time = 72789; 
     assertEquals("0:01:12.789", DurationFormatUtils.formatDurationHMS(time)); 
     time = 12789 + 32 * 60000; 
     assertEquals("0:32:12.789", DurationFormatUtils.formatDurationHMS(time)); 
     time = 12789 + 62 * 60000; 
     assertEquals("1:02:12.789", DurationFormatUtils.formatDurationHMS(time)); 
 }
@Test
public void testLexx3304() { 
     assertArrayEquals(new DurationFormatUtils.Token[] { new DurationFormatUtils.Token(DurationFormatUtils.y, 1), new DurationFormatUtils.Token(DurationFormatUtils.M, 1), new DurationFormatUtils.Token(DurationFormatUtils.d, 1), new DurationFormatUtils.Token(DurationFormatUtils.H, 1), new DurationFormatUtils.Token(DurationFormatUtils.m, 1), new DurationFormatUtils.Token(DurationFormatUtils.s, 1), new DurationFormatUtils.Token(DurationFormatUtils.S, 1) }, DurationFormatUtils.lexx("yMdHmsS")); 
     assertArrayEquals(new DurationFormatUtils.Token[] { new DurationFormatUtils.Token(DurationFormatUtils.H, 1), new DurationFormatUtils.Token(new StringBuilder(":"), 1), new DurationFormatUtils.Token(DurationFormatUtils.m, 2), new DurationFormatUtils.Token(new StringBuilder(":"), 1), new DurationFormatUtils.Token(DurationFormatUtils.s, 2), new DurationFormatUtils.Token(new StringBuilder("."), 1), new DurationFormatUtils.Token(DurationFormatUtils.S, 3) }, DurationFormatUtils.lexx("H:mm:ss.SSS")); 
     assertArrayEquals(new DurationFormatUtils.Token[] { new DurationFormatUtils.Token(new StringBuilder("P"), 1), new DurationFormatUtils.Token(DurationFormatUtils.y, 4), new DurationFormatUtils.Token(new StringBuilder("Y"), 1), new DurationFormatUtils.Token(DurationFormatUtils.M, 1), new DurationFormatUtils.Token(new StringBuilder("M"), 1), new DurationFormatUtils.Token(DurationFormatUtils.d, 1), new DurationFormatUtils.Token(new StringBuilder("DT"), 1), new DurationFormatUtils.Token(DurationFormatUtils.H, 1), new DurationFormatUtils.Token(new StringBuilder("H"), 1), new DurationFormatUtils.Token(DurationFormatUtils.m, 1), new DurationFormatUtils.Token(new StringBuilder("M"), 1), new DurationFormatUtils.Token(DurationFormatUtils.s, 1), new DurationFormatUtils.Token(new StringBuilder("."), 1), new DurationFormatUtils.Token(DurationFormatUtils.S, 1), new DurationFormatUtils.Token(new StringBuilder("S"), 1) }, DurationFormatUtils.lexx(DurationFormatUtils.ISO_EXTENDED_FORMAT_PATTERN)); 
     final DurationFormatUtils.Token token = new DurationFormatUtils.Token(DurationFormatUtils.y, 4); 
     assertFalse("Token equal to non-Token class. ", token.equals(new Object())); 
     assertFalse("Token equal to Token with wrong value class. ", token.equals(new DurationFormatUtils.Token(new Object()))); 
     assertFalse("Token equal to Token with different count. ", token.equals(new DurationFormatUtils.Token(DurationFormatUtils.y, 1))); 
     final DurationFormatUtils.Token numToken = new DurationFormatUtils.Token(Integer.valueOf(1), 4); 
     assertTrue("Token with Number value not equal to itself. ", numToken.equals(numToken)); 
 }
@Test
public void testConstructor3477() { 
     assertNotNull(new DurationFormatUtils()); 
     final Constructor<?>[] cons = DurationFormatUtils.class.getDeclaredConstructors(); 
     assertEquals(1, cons.length); 
     assertTrue(Modifier.isPublic(cons[0].getModifiers())); 
     assertTrue(Modifier.isPublic(DurationFormatUtils.class.getModifiers())); 
     assertFalse(Modifier.isFinal(DurationFormatUtils.class.getModifiers())); 
 }
@Test
public void testFormatPeriodISO3642() { 
     final TimeZone timeZone = TimeZone.getTimeZone("GMT-3"); 
     final Calendar base = Calendar.getInstance(timeZone); 
     base.set(1970, 0, 1, 0, 0, 0); 
     base.set(Calendar.MILLISECOND, 0); 
     final Calendar cal = Calendar.getInstance(timeZone); 
     cal.set(2002, 1, 23, 9, 11, 12); 
     cal.set(Calendar.MILLISECOND, 1); 
     String text; 
     text = DateFormatUtils.ISO_DATETIME_TIME_ZONE_FORMAT.format(cal); 
     assertEquals("2002-02-23T09:11:12-03:00", text); 
     text = DurationFormatUtils.formatPeriod(base.getTime().getTime(), cal.getTime().getTime(), DurationFormatUtils.ISO_EXTENDED_FORMAT_PATTERN, false, timeZone); 
     assertEquals("P32Y1M22DT9H11M12.001S", text); 
     cal.set(1971, 1, 3, 10, 30, 0); 
     cal.set(Calendar.MILLISECOND, 0); 
     text = DurationFormatUtils.formatPeriod(base.getTime().getTime(), cal.getTime().getTime(), DurationFormatUtils.ISO_EXTENDED_FORMAT_PATTERN, false, timeZone); 
     assertEquals("P1Y1M2DT10H30M0.000S", text); 
 }
@Test
public void testConstructor4056() { 
     assertNotNull(new DurationFormatUtils()); 
     final Constructor<?>[] cons = DurationFormatUtils.class.getDeclaredConstructors(); 
     assertEquals(1, cons.length); 
     assertTrue(Modifier.isPublic(cons[0].getModifiers())); 
     assertTrue(Modifier.isPublic(DurationFormatUtils.class.getModifiers())); 
     assertFalse(Modifier.isFinal(DurationFormatUtils.class.getModifiers())); 
 }
@Test
public void testFormatPeriodISO4295() { 
     final TimeZone timeZone = TimeZone.getTimeZone("GMT-3"); 
     final Calendar base = Calendar.getInstance(timeZone); 
     base.set(1970, 0, 1, 0, 0, 0); 
     base.set(Calendar.MILLISECOND, 0); 
     final Calendar cal = Calendar.getInstance(timeZone); 
     cal.set(2002, 1, 23, 9, 11, 12); 
     cal.set(Calendar.MILLISECOND, 1); 
     String text; 
     text = DateFormatUtils.ISO_DATETIME_TIME_ZONE_FORMAT.format(cal); 
     assertEquals("2002-02-23T09:11:12-03:00", text); 
     text = DurationFormatUtils.formatPeriod(base.getTime().getTime(), cal.getTime().getTime(), DurationFormatUtils.ISO_EXTENDED_FORMAT_PATTERN, false, timeZone); 
     assertEquals("P32Y1M22DT9H11M12.001S", text); 
     cal.set(1971, 1, 3, 10, 30, 0); 
     cal.set(Calendar.MILLISECOND, 0); 
     text = DurationFormatUtils.formatPeriod(base.getTime().getTime(), cal.getTime().getTime(), DurationFormatUtils.ISO_EXTENDED_FORMAT_PATTERN, false, timeZone); 
     assertEquals("P1Y1M2DT10H30M0.000S", text); 
 }
@Test
public void testFormatPeriodISO4372() { 
     final TimeZone timeZone = TimeZone.getTimeZone("GMT-3"); 
     final Calendar base = Calendar.getInstance(timeZone); 
     base.set(1970, 0, 1, 0, 0, 0); 
     base.set(Calendar.MILLISECOND, 0); 
     final Calendar cal = Calendar.getInstance(timeZone); 
     cal.set(2002, 1, 23, 9, 11, 12); 
     cal.set(Calendar.MILLISECOND, 1); 
     String text; 
     text = DateFormatUtils.ISO_DATETIME_TIME_ZONE_FORMAT.format(cal); 
     assertEquals("2002-02-23T09:11:12-03:00", text); 
     text = DurationFormatUtils.formatPeriod(base.getTime().getTime(), cal.getTime().getTime(), DurationFormatUtils.ISO_EXTENDED_FORMAT_PATTERN, false, timeZone); 
     assertEquals("P32Y1M22DT9H11M12.001S", text); 
     cal.set(1971, 1, 3, 10, 30, 0); 
     cal.set(Calendar.MILLISECOND, 0); 
     text = DurationFormatUtils.formatPeriod(base.getTime().getTime(), cal.getTime().getTime(), DurationFormatUtils.ISO_EXTENDED_FORMAT_PATTERN, false, timeZone); 
     assertEquals("P1Y1M2DT10H30M0.000S", text); 
 }
@Test
public void testLexx5824() { 
     assertArrayEquals(new DurationFormatUtils.Token[] { new DurationFormatUtils.Token(DurationFormatUtils.y, 1), new DurationFormatUtils.Token(DurationFormatUtils.M, 1), new DurationFormatUtils.Token(DurationFormatUtils.d, 1), new DurationFormatUtils.Token(DurationFormatUtils.H, 1), new DurationFormatUtils.Token(DurationFormatUtils.m, 1), new DurationFormatUtils.Token(DurationFormatUtils.s, 1), new DurationFormatUtils.Token(DurationFormatUtils.S, 1) }, DurationFormatUtils.lexx("yMdHmsS")); 
     assertArrayEquals(new DurationFormatUtils.Token[] { new DurationFormatUtils.Token(DurationFormatUtils.H, 1), new DurationFormatUtils.Token(new StringBuilder(":"), 1), new DurationFormatUtils.Token(DurationFormatUtils.m, 2), new DurationFormatUtils.Token(new StringBuilder(":"), 1), new DurationFormatUtils.Token(DurationFormatUtils.s, 2), new DurationFormatUtils.Token(new StringBuilder("."), 1), new DurationFormatUtils.Token(DurationFormatUtils.S, 3) }, DurationFormatUtils.lexx("H:mm:ss.SSS")); 
     assertArrayEquals(new DurationFormatUtils.Token[] { new DurationFormatUtils.Token(new StringBuilder("P"), 1), new DurationFormatUtils.Token(DurationFormatUtils.y, 4), new DurationFormatUtils.Token(new StringBuilder("Y"), 1), new DurationFormatUtils.Token(DurationFormatUtils.M, 1), new DurationFormatUtils.Token(new StringBuilder("M"), 1), new DurationFormatUtils.Token(DurationFormatUtils.d, 1), new DurationFormatUtils.Token(new StringBuilder("DT"), 1), new DurationFormatUtils.Token(DurationFormatUtils.H, 1), new DurationFormatUtils.Token(new StringBuilder("H"), 1), new DurationFormatUtils.Token(DurationFormatUtils.m, 1), new DurationFormatUtils.Token(new StringBuilder("M"), 1), new DurationFormatUtils.Token(DurationFormatUtils.s, 1), new DurationFormatUtils.Token(new StringBuilder("."), 1), new DurationFormatUtils.Token(DurationFormatUtils.S, 1), new DurationFormatUtils.Token(new StringBuilder("S"), 1) }, DurationFormatUtils.lexx(DurationFormatUtils.ISO_EXTENDED_FORMAT_PATTERN)); 
     final DurationFormatUtils.Token token = new DurationFormatUtils.Token(DurationFormatUtils.y, 4); 
     assertFalse("Token equal to non-Token class. ", token.equals(new Object())); 
     assertFalse("Token equal to Token with wrong value class. ", token.equals(new DurationFormatUtils.Token(new Object()))); 
     assertFalse("Token equal to Token with different count. ", token.equals(new DurationFormatUtils.Token(DurationFormatUtils.y, 1))); 
     final DurationFormatUtils.Token numToken = new DurationFormatUtils.Token(Integer.valueOf(1), 4); 
     assertTrue("Token with Number value not equal to itself. ", numToken.equals(numToken)); 
 }
@Test
public void testFormatPeriodISO6185() { 
     final TimeZone timeZone = TimeZone.getTimeZone("GMT-3"); 
     final Calendar base = Calendar.getInstance(timeZone); 
     base.set(1970, 0, 1, 0, 0, 0); 
     base.set(Calendar.MILLISECOND, 0); 
     final Calendar cal = Calendar.getInstance(timeZone); 
     cal.set(2002, 1, 23, 9, 11, 12); 
     cal.set(Calendar.MILLISECOND, 1); 
     String text; 
     text = DateFormatUtils.ISO_DATETIME_TIME_ZONE_FORMAT.format(cal); 
     assertEquals("2002-02-23T09:11:12-03:00", text); 
     text = DurationFormatUtils.formatPeriod(base.getTime().getTime(), cal.getTime().getTime(), DurationFormatUtils.ISO_EXTENDED_FORMAT_PATTERN, false, timeZone); 
     assertEquals("P32Y1M22DT9H11M12.001S", text); 
     cal.set(1971, 1, 3, 10, 30, 0); 
     cal.set(Calendar.MILLISECOND, 0); 
     text = DurationFormatUtils.formatPeriod(base.getTime().getTime(), cal.getTime().getTime(), DurationFormatUtils.ISO_EXTENDED_FORMAT_PATTERN, false, timeZone); 
     assertEquals("P1Y1M2DT10H30M0.000S", text); 
 }
@Test
public void testLexx6700() { 
     assertArrayEquals(new DurationFormatUtils.Token[] { new DurationFormatUtils.Token(DurationFormatUtils.y, 1), new DurationFormatUtils.Token(DurationFormatUtils.M, 1), new DurationFormatUtils.Token(DurationFormatUtils.d, 1), new DurationFormatUtils.Token(DurationFormatUtils.H, 1), new DurationFormatUtils.Token(DurationFormatUtils.m, 1), new DurationFormatUtils.Token(DurationFormatUtils.s, 1), new DurationFormatUtils.Token(DurationFormatUtils.S, 1) }, DurationFormatUtils.lexx("yMdHmsS")); 
     assertArrayEquals(new DurationFormatUtils.Token[] { new DurationFormatUtils.Token(DurationFormatUtils.H, 1), new DurationFormatUtils.Token(new StringBuilder(":"), 1), new DurationFormatUtils.Token(DurationFormatUtils.m, 2), new DurationFormatUtils.Token(new StringBuilder(":"), 1), new DurationFormatUtils.Token(DurationFormatUtils.s, 2), new DurationFormatUtils.Token(new StringBuilder("."), 1), new DurationFormatUtils.Token(DurationFormatUtils.S, 3) }, DurationFormatUtils.lexx("H:mm:ss.SSS")); 
     assertArrayEquals(new DurationFormatUtils.Token[] { new DurationFormatUtils.Token(new StringBuilder("P"), 1), new DurationFormatUtils.Token(DurationFormatUtils.y, 4), new DurationFormatUtils.Token(new StringBuilder("Y"), 1), new DurationFormatUtils.Token(DurationFormatUtils.M, 1), new DurationFormatUtils.Token(new StringBuilder("M"), 1), new DurationFormatUtils.Token(DurationFormatUtils.d, 1), new DurationFormatUtils.Token(new StringBuilder("DT"), 1), new DurationFormatUtils.Token(DurationFormatUtils.H, 1), new DurationFormatUtils.Token(new StringBuilder("H"), 1), new DurationFormatUtils.Token(DurationFormatUtils.m, 1), new DurationFormatUtils.Token(new StringBuilder("M"), 1), new DurationFormatUtils.Token(DurationFormatUtils.s, 1), new DurationFormatUtils.Token(new StringBuilder("."), 1), new DurationFormatUtils.Token(DurationFormatUtils.S, 1), new DurationFormatUtils.Token(new StringBuilder("S"), 1) }, DurationFormatUtils.lexx(DurationFormatUtils.ISO_EXTENDED_FORMAT_PATTERN)); 
     final DurationFormatUtils.Token token = new DurationFormatUtils.Token(DurationFormatUtils.y, 4); 
     assertFalse("Token equal to non-Token class. ", token.equals(new Object())); 
     assertFalse("Token equal to Token with wrong value class. ", token.equals(new DurationFormatUtils.Token(new Object()))); 
     assertFalse("Token equal to Token with different count. ", token.equals(new DurationFormatUtils.Token(DurationFormatUtils.y, 1))); 
     final DurationFormatUtils.Token numToken = new DurationFormatUtils.Token(Integer.valueOf(1), 4); 
     assertTrue("Token with Number value not equal to itself. ", numToken.equals(numToken)); 
 }
@Test
public void testFormatPeriodISO6759() { 
     final TimeZone timeZone = TimeZone.getTimeZone("GMT-3"); 
     final Calendar base = Calendar.getInstance(timeZone); 
     base.set(1970, 0, 1, 0, 0, 0); 
     base.set(Calendar.MILLISECOND, 0); 
     final Calendar cal = Calendar.getInstance(timeZone); 
     cal.set(2002, 1, 23, 9, 11, 12); 
     cal.set(Calendar.MILLISECOND, 1); 
     String text; 
     text = DateFormatUtils.ISO_DATETIME_TIME_ZONE_FORMAT.format(cal); 
     assertEquals("2002-02-23T09:11:12-03:00", text); 
     text = DurationFormatUtils.formatPeriod(base.getTime().getTime(), cal.getTime().getTime(), DurationFormatUtils.ISO_EXTENDED_FORMAT_PATTERN, false, timeZone); 
     assertEquals("P32Y1M22DT9H11M12.001S", text); 
     cal.set(1971, 1, 3, 10, 30, 0); 
     cal.set(Calendar.MILLISECOND, 0); 
     text = DurationFormatUtils.formatPeriod(base.getTime().getTime(), cal.getTime().getTime(), DurationFormatUtils.ISO_EXTENDED_FORMAT_PATTERN, false, timeZone); 
     assertEquals("P1Y1M2DT10H30M0.000S", text); 
 }
@Test
public void testLexx6850() { 
     assertArrayEquals(new DurationFormatUtils.Token[] { new DurationFormatUtils.Token(DurationFormatUtils.y, 1), new DurationFormatUtils.Token(DurationFormatUtils.M, 1), new DurationFormatUtils.Token(DurationFormatUtils.d, 1), new DurationFormatUtils.Token(DurationFormatUtils.H, 1), new DurationFormatUtils.Token(DurationFormatUtils.m, 1), new DurationFormatUtils.Token(DurationFormatUtils.s, 1), new DurationFormatUtils.Token(DurationFormatUtils.S, 1) }, DurationFormatUtils.lexx("yMdHmsS")); 
     assertArrayEquals(new DurationFormatUtils.Token[] { new DurationFormatUtils.Token(DurationFormatUtils.H, 1), new DurationFormatUtils.Token(new StringBuilder(":"), 1), new DurationFormatUtils.Token(DurationFormatUtils.m, 2), new DurationFormatUtils.Token(new StringBuilder(":"), 1), new DurationFormatUtils.Token(DurationFormatUtils.s, 2), new DurationFormatUtils.Token(new StringBuilder("."), 1), new DurationFormatUtils.Token(DurationFormatUtils.S, 3) }, DurationFormatUtils.lexx("H:mm:ss.SSS")); 
     assertArrayEquals(new DurationFormatUtils.Token[] { new DurationFormatUtils.Token(new StringBuilder("P"), 1), new DurationFormatUtils.Token(DurationFormatUtils.y, 4), new DurationFormatUtils.Token(new StringBuilder("Y"), 1), new DurationFormatUtils.Token(DurationFormatUtils.M, 1), new DurationFormatUtils.Token(new StringBuilder("M"), 1), new DurationFormatUtils.Token(DurationFormatUtils.d, 1), new DurationFormatUtils.Token(new StringBuilder("DT"), 1), new DurationFormatUtils.Token(DurationFormatUtils.H, 1), new DurationFormatUtils.Token(new StringBuilder("H"), 1), new DurationFormatUtils.Token(DurationFormatUtils.m, 1), new DurationFormatUtils.Token(new StringBuilder("M"), 1), new DurationFormatUtils.Token(DurationFormatUtils.s, 1), new DurationFormatUtils.Token(new StringBuilder("."), 1), new DurationFormatUtils.Token(DurationFormatUtils.S, 1), new DurationFormatUtils.Token(new StringBuilder("S"), 1) }, DurationFormatUtils.lexx(DurationFormatUtils.ISO_EXTENDED_FORMAT_PATTERN)); 
     final DurationFormatUtils.Token token = new DurationFormatUtils.Token(DurationFormatUtils.y, 4); 
     assertFalse("Token equal to non-Token class. ", token.equals(new Object())); 
     assertFalse("Token equal to Token with wrong value class. ", token.equals(new DurationFormatUtils.Token(new Object()))); 
     assertFalse("Token equal to Token with different count. ", token.equals(new DurationFormatUtils.Token(DurationFormatUtils.y, 1))); 
     final DurationFormatUtils.Token numToken = new DurationFormatUtils.Token(Integer.valueOf(1), 4); 
     assertTrue("Token with Number value not equal to itself. ", numToken.equals(numToken)); 
 }
@Test
public void testBugzilla384017121() { 
     assertEqualDuration("0000/00/30 16:00:00 000", new int[] { 2006, 0, 26, 18, 47, 34 }, new int[] { 2006, 1, 26, 10, 47, 34 }, "yyyy/MM/dd HH:mm:ss SSS"); 
 }
@Test
public void testLexx7236() { 
     assertArrayEquals(new DurationFormatUtils.Token[] { new DurationFormatUtils.Token(DurationFormatUtils.y, 1), new DurationFormatUtils.Token(DurationFormatUtils.M, 1), new DurationFormatUtils.Token(DurationFormatUtils.d, 1), new DurationFormatUtils.Token(DurationFormatUtils.H, 1), new DurationFormatUtils.Token(DurationFormatUtils.m, 1), new DurationFormatUtils.Token(DurationFormatUtils.s, 1), new DurationFormatUtils.Token(DurationFormatUtils.S, 1) }, DurationFormatUtils.lexx("yMdHmsS")); 
     assertArrayEquals(new DurationFormatUtils.Token[] { new DurationFormatUtils.Token(DurationFormatUtils.H, 1), new DurationFormatUtils.Token(new StringBuilder(":"), 1), new DurationFormatUtils.Token(DurationFormatUtils.m, 2), new DurationFormatUtils.Token(new StringBuilder(":"), 1), new DurationFormatUtils.Token(DurationFormatUtils.s, 2), new DurationFormatUtils.Token(new StringBuilder("."), 1), new DurationFormatUtils.Token(DurationFormatUtils.S, 3) }, DurationFormatUtils.lexx("H:mm:ss.SSS")); 
     assertArrayEquals(new DurationFormatUtils.Token[] { new DurationFormatUtils.Token(new StringBuilder("P"), 1), new DurationFormatUtils.Token(DurationFormatUtils.y, 4), new DurationFormatUtils.Token(new StringBuilder("Y"), 1), new DurationFormatUtils.Token(DurationFormatUtils.M, 1), new DurationFormatUtils.Token(new StringBuilder("M"), 1), new DurationFormatUtils.Token(DurationFormatUtils.d, 1), new DurationFormatUtils.Token(new StringBuilder("DT"), 1), new DurationFormatUtils.Token(DurationFormatUtils.H, 1), new DurationFormatUtils.Token(new StringBuilder("H"), 1), new DurationFormatUtils.Token(DurationFormatUtils.m, 1), new DurationFormatUtils.Token(new StringBuilder("M"), 1), new DurationFormatUtils.Token(DurationFormatUtils.s, 1), new DurationFormatUtils.Token(new StringBuilder("."), 1), new DurationFormatUtils.Token(DurationFormatUtils.S, 1), new DurationFormatUtils.Token(new StringBuilder("S"), 1) }, DurationFormatUtils.lexx(DurationFormatUtils.ISO_EXTENDED_FORMAT_PATTERN)); 
     final DurationFormatUtils.Token token = new DurationFormatUtils.Token(DurationFormatUtils.y, 4); 
     assertFalse("Token equal to non-Token class. ", token.equals(new Object())); 
     assertFalse("Token equal to Token with wrong value class. ", token.equals(new DurationFormatUtils.Token(new Object()))); 
     assertFalse("Token equal to Token with different count. ", token.equals(new DurationFormatUtils.Token(DurationFormatUtils.y, 1))); 
     final DurationFormatUtils.Token numToken = new DurationFormatUtils.Token(Integer.valueOf(1), 4); 
     assertTrue("Token with Number value not equal to itself. ", numToken.equals(numToken)); 
 }
@Test
public void testLANG8157246() { 
     final Calendar calendar = Calendar.getInstance(); 
     calendar.set(2012, 6, 30, 0, 0, 0); 
     final long startMillis = calendar.getTimeInMillis(); 
     calendar.set(2012, 8, 8); 
     final long endMillis = calendar.getTimeInMillis(); 
     assertEquals("1 9", DurationFormatUtils.formatPeriod(startMillis, endMillis, "M d")); 
 }
@Test
public void testFormatPeriodISO7407() { 
     final TimeZone timeZone = TimeZone.getTimeZone("GMT-3"); 
     final Calendar base = Calendar.getInstance(timeZone); 
     base.set(1970, 0, 1, 0, 0, 0); 
     base.set(Calendar.MILLISECOND, 0); 
     final Calendar cal = Calendar.getInstance(timeZone); 
     cal.set(2002, 1, 23, 9, 11, 12); 
     cal.set(Calendar.MILLISECOND, 1); 
     String text; 
     text = DateFormatUtils.ISO_DATETIME_TIME_ZONE_FORMAT.format(cal); 
     assertEquals("2002-02-23T09:11:12-03:00", text); 
     text = DurationFormatUtils.formatPeriod(base.getTime().getTime(), cal.getTime().getTime(), DurationFormatUtils.ISO_EXTENDED_FORMAT_PATTERN, false, timeZone); 
     assertEquals("P32Y1M22DT9H11M12.001S", text); 
     cal.set(1971, 1, 3, 10, 30, 0); 
     cal.set(Calendar.MILLISECOND, 0); 
     text = DurationFormatUtils.formatPeriod(base.getTime().getTime(), cal.getTime().getTime(), DurationFormatUtils.ISO_EXTENDED_FORMAT_PATTERN, false, timeZone); 
     assertEquals("P1Y1M2DT10H30M0.000S", text); 
 }
@Test
public void testLexx7927() { 
     assertArrayEquals(new DurationFormatUtils.Token[] { new DurationFormatUtils.Token(DurationFormatUtils.y, 1), new DurationFormatUtils.Token(DurationFormatUtils.M, 1), new DurationFormatUtils.Token(DurationFormatUtils.d, 1), new DurationFormatUtils.Token(DurationFormatUtils.H, 1), new DurationFormatUtils.Token(DurationFormatUtils.m, 1), new DurationFormatUtils.Token(DurationFormatUtils.s, 1), new DurationFormatUtils.Token(DurationFormatUtils.S, 1) }, DurationFormatUtils.lexx("yMdHmsS")); 
     assertArrayEquals(new DurationFormatUtils.Token[] { new DurationFormatUtils.Token(DurationFormatUtils.H, 1), new DurationFormatUtils.Token(new StringBuilder(":"), 1), new DurationFormatUtils.Token(DurationFormatUtils.m, 2), new DurationFormatUtils.Token(new StringBuilder(":"), 1), new DurationFormatUtils.Token(DurationFormatUtils.s, 2), new DurationFormatUtils.Token(new StringBuilder("."), 1), new DurationFormatUtils.Token(DurationFormatUtils.S, 3) }, DurationFormatUtils.lexx("H:mm:ss.SSS")); 
     assertArrayEquals(new DurationFormatUtils.Token[] { new DurationFormatUtils.Token(new StringBuilder("P"), 1), new DurationFormatUtils.Token(DurationFormatUtils.y, 4), new DurationFormatUtils.Token(new StringBuilder("Y"), 1), new DurationFormatUtils.Token(DurationFormatUtils.M, 1), new DurationFormatUtils.Token(new StringBuilder("M"), 1), new DurationFormatUtils.Token(DurationFormatUtils.d, 1), new DurationFormatUtils.Token(new StringBuilder("DT"), 1), new DurationFormatUtils.Token(DurationFormatUtils.H, 1), new DurationFormatUtils.Token(new StringBuilder("H"), 1), new DurationFormatUtils.Token(DurationFormatUtils.m, 1), new DurationFormatUtils.Token(new StringBuilder("M"), 1), new DurationFormatUtils.Token(DurationFormatUtils.s, 1), new DurationFormatUtils.Token(new StringBuilder("."), 1), new DurationFormatUtils.Token(DurationFormatUtils.S, 1), new DurationFormatUtils.Token(new StringBuilder("S"), 1) }, DurationFormatUtils.lexx(DurationFormatUtils.ISO_EXTENDED_FORMAT_PATTERN)); 
     final DurationFormatUtils.Token token = new DurationFormatUtils.Token(DurationFormatUtils.y, 4); 
     assertFalse("Token equal to non-Token class. ", token.equals(new Object())); 
     assertFalse("Token equal to Token with wrong value class. ", token.equals(new DurationFormatUtils.Token(new Object()))); 
     assertFalse("Token equal to Token with different count. ", token.equals(new DurationFormatUtils.Token(DurationFormatUtils.y, 1))); 
     final DurationFormatUtils.Token numToken = new DurationFormatUtils.Token(Integer.valueOf(1), 4); 
     assertTrue("Token with Number value not equal to itself. ", numToken.equals(numToken)); 
 }
@Test
public void testLexx8138() { 
     assertArrayEquals(new DurationFormatUtils.Token[] { new DurationFormatUtils.Token(DurationFormatUtils.y, 1), new DurationFormatUtils.Token(DurationFormatUtils.M, 1), new DurationFormatUtils.Token(DurationFormatUtils.d, 1), new DurationFormatUtils.Token(DurationFormatUtils.H, 1), new DurationFormatUtils.Token(DurationFormatUtils.m, 1), new DurationFormatUtils.Token(DurationFormatUtils.s, 1), new DurationFormatUtils.Token(DurationFormatUtils.S, 1) }, DurationFormatUtils.lexx("yMdHmsS")); 
     assertArrayEquals(new DurationFormatUtils.Token[] { new DurationFormatUtils.Token(DurationFormatUtils.H, 1), new DurationFormatUtils.Token(new StringBuilder(":"), 1), new DurationFormatUtils.Token(DurationFormatUtils.m, 2), new DurationFormatUtils.Token(new StringBuilder(":"), 1), new DurationFormatUtils.Token(DurationFormatUtils.s, 2), new DurationFormatUtils.Token(new StringBuilder("."), 1), new DurationFormatUtils.Token(DurationFormatUtils.S, 3) }, DurationFormatUtils.lexx("H:mm:ss.SSS")); 
     assertArrayEquals(new DurationFormatUtils.Token[] { new DurationFormatUtils.Token(new StringBuilder("P"), 1), new DurationFormatUtils.Token(DurationFormatUtils.y, 4), new DurationFormatUtils.Token(new StringBuilder("Y"), 1), new DurationFormatUtils.Token(DurationFormatUtils.M, 1), new DurationFormatUtils.Token(new StringBuilder("M"), 1), new DurationFormatUtils.Token(DurationFormatUtils.d, 1), new DurationFormatUtils.Token(new StringBuilder("DT"), 1), new DurationFormatUtils.Token(DurationFormatUtils.H, 1), new DurationFormatUtils.Token(new StringBuilder("H"), 1), new DurationFormatUtils.Token(DurationFormatUtils.m, 1), new DurationFormatUtils.Token(new StringBuilder("M"), 1), new DurationFormatUtils.Token(DurationFormatUtils.s, 1), new DurationFormatUtils.Token(new StringBuilder("."), 1), new DurationFormatUtils.Token(DurationFormatUtils.S, 1), new DurationFormatUtils.Token(new StringBuilder("S"), 1) }, DurationFormatUtils.lexx(DurationFormatUtils.ISO_EXTENDED_FORMAT_PATTERN)); 
     final DurationFormatUtils.Token token = new DurationFormatUtils.Token(DurationFormatUtils.y, 4); 
     assertFalse("Token equal to non-Token class. ", token.equals(new Object())); 
     assertFalse("Token equal to Token with wrong value class. ", token.equals(new DurationFormatUtils.Token(new Object()))); 
     assertFalse("Token equal to Token with different count. ", token.equals(new DurationFormatUtils.Token(DurationFormatUtils.y, 1))); 
     final DurationFormatUtils.Token numToken = new DurationFormatUtils.Token(Integer.valueOf(1), 4); 
     assertTrue("Token with Number value not equal to itself. ", numToken.equals(numToken)); 
 }
@Test
public void testLexx8361() { 
     assertArrayEquals(new DurationFormatUtils.Token[] { new DurationFormatUtils.Token(DurationFormatUtils.y, 1), new DurationFormatUtils.Token(DurationFormatUtils.M, 1), new DurationFormatUtils.Token(DurationFormatUtils.d, 1), new DurationFormatUtils.Token(DurationFormatUtils.H, 1), new DurationFormatUtils.Token(DurationFormatUtils.m, 1), new DurationFormatUtils.Token(DurationFormatUtils.s, 1), new DurationFormatUtils.Token(DurationFormatUtils.S, 1) }, DurationFormatUtils.lexx("yMdHmsS")); 
     assertArrayEquals(new DurationFormatUtils.Token[] { new DurationFormatUtils.Token(DurationFormatUtils.H, 1), new DurationFormatUtils.Token(new StringBuilder(":"), 1), new DurationFormatUtils.Token(DurationFormatUtils.m, 2), new DurationFormatUtils.Token(new StringBuilder(":"), 1), new DurationFormatUtils.Token(DurationFormatUtils.s, 2), new DurationFormatUtils.Token(new StringBuilder("."), 1), new DurationFormatUtils.Token(DurationFormatUtils.S, 3) }, DurationFormatUtils.lexx("H:mm:ss.SSS")); 
     assertArrayEquals(new DurationFormatUtils.Token[] { new DurationFormatUtils.Token(new StringBuilder("P"), 1), new DurationFormatUtils.Token(DurationFormatUtils.y, 4), new DurationFormatUtils.Token(new StringBuilder("Y"), 1), new DurationFormatUtils.Token(DurationFormatUtils.M, 1), new DurationFormatUtils.Token(new StringBuilder("M"), 1), new DurationFormatUtils.Token(DurationFormatUtils.d, 1), new DurationFormatUtils.Token(new StringBuilder("DT"), 1), new DurationFormatUtils.Token(DurationFormatUtils.H, 1), new DurationFormatUtils.Token(new StringBuilder("H"), 1), new DurationFormatUtils.Token(DurationFormatUtils.m, 1), new DurationFormatUtils.Token(new StringBuilder("M"), 1), new DurationFormatUtils.Token(DurationFormatUtils.s, 1), new DurationFormatUtils.Token(new StringBuilder("."), 1), new DurationFormatUtils.Token(DurationFormatUtils.S, 1), new DurationFormatUtils.Token(new StringBuilder("S"), 1) }, DurationFormatUtils.lexx(DurationFormatUtils.ISO_EXTENDED_FORMAT_PATTERN)); 
     final DurationFormatUtils.Token token = new DurationFormatUtils.Token(DurationFormatUtils.y, 4); 
     assertFalse("Token equal to non-Token class. ", token.equals(new Object())); 
     assertFalse("Token equal to Token with wrong value class. ", token.equals(new DurationFormatUtils.Token(new Object()))); 
     assertFalse("Token equal to Token with different count. ", token.equals(new DurationFormatUtils.Token(DurationFormatUtils.y, 1))); 
     final DurationFormatUtils.Token numToken = new DurationFormatUtils.Token(Integer.valueOf(1), 4); 
     assertTrue("Token with Number value not equal to itself. ", numToken.equals(numToken)); 
 }
@Test
public void testBugzilla384018604() { 
     assertEqualDuration("0000/00/30 16:00:00 000", new int[] { 2006, 0, 26, 18, 47, 34 }, new int[] { 2006, 1, 26, 10, 47, 34 }, "yyyy/MM/dd HH:mm:ss SSS"); 
 }
@Test
public void testLexx9056() { 
     assertArrayEquals(new DurationFormatUtils.Token[] { new DurationFormatUtils.Token(DurationFormatUtils.y, 1), new DurationFormatUtils.Token(DurationFormatUtils.M, 1), new DurationFormatUtils.Token(DurationFormatUtils.d, 1), new DurationFormatUtils.Token(DurationFormatUtils.H, 1), new DurationFormatUtils.Token(DurationFormatUtils.m, 1), new DurationFormatUtils.Token(DurationFormatUtils.s, 1), new DurationFormatUtils.Token(DurationFormatUtils.S, 1) }, DurationFormatUtils.lexx("yMdHmsS")); 
     assertArrayEquals(new DurationFormatUtils.Token[] { new DurationFormatUtils.Token(DurationFormatUtils.H, 1), new DurationFormatUtils.Token(new StringBuilder(":"), 1), new DurationFormatUtils.Token(DurationFormatUtils.m, 2), new DurationFormatUtils.Token(new StringBuilder(":"), 1), new DurationFormatUtils.Token(DurationFormatUtils.s, 2), new DurationFormatUtils.Token(new StringBuilder("."), 1), new DurationFormatUtils.Token(DurationFormatUtils.S, 3) }, DurationFormatUtils.lexx("H:mm:ss.SSS")); 
     assertArrayEquals(new DurationFormatUtils.Token[] { new DurationFormatUtils.Token(new StringBuilder("P"), 1), new DurationFormatUtils.Token(DurationFormatUtils.y, 4), new DurationFormatUtils.Token(new StringBuilder("Y"), 1), new DurationFormatUtils.Token(DurationFormatUtils.M, 1), new DurationFormatUtils.Token(new StringBuilder("M"), 1), new DurationFormatUtils.Token(DurationFormatUtils.d, 1), new DurationFormatUtils.Token(new StringBuilder("DT"), 1), new DurationFormatUtils.Token(DurationFormatUtils.H, 1), new DurationFormatUtils.Token(new StringBuilder("H"), 1), new DurationFormatUtils.Token(DurationFormatUtils.m, 1), new DurationFormatUtils.Token(new StringBuilder("M"), 1), new DurationFormatUtils.Token(DurationFormatUtils.s, 1), new DurationFormatUtils.Token(new StringBuilder("."), 1), new DurationFormatUtils.Token(DurationFormatUtils.S, 1), new DurationFormatUtils.Token(new StringBuilder("S"), 1) }, DurationFormatUtils.lexx(DurationFormatUtils.ISO_EXTENDED_FORMAT_PATTERN)); 
     final DurationFormatUtils.Token token = new DurationFormatUtils.Token(DurationFormatUtils.y, 4); 
     assertFalse("Token equal to non-Token class. ", token.equals(new Object())); 
     assertFalse("Token equal to Token with wrong value class. ", token.equals(new DurationFormatUtils.Token(new Object()))); 
     assertFalse("Token equal to Token with different count. ", token.equals(new DurationFormatUtils.Token(DurationFormatUtils.y, 1))); 
     final DurationFormatUtils.Token numToken = new DurationFormatUtils.Token(Integer.valueOf(1), 4); 
     assertTrue("Token with Number value not equal to itself. ", numToken.equals(numToken)); 
 }
@Test
public void testLexx9199() { 
     assertArrayEquals(new DurationFormatUtils.Token[] { new DurationFormatUtils.Token(DurationFormatUtils.y, 1), new DurationFormatUtils.Token(DurationFormatUtils.M, 1), new DurationFormatUtils.Token(DurationFormatUtils.d, 1), new DurationFormatUtils.Token(DurationFormatUtils.H, 1), new DurationFormatUtils.Token(DurationFormatUtils.m, 1), new DurationFormatUtils.Token(DurationFormatUtils.s, 1), new DurationFormatUtils.Token(DurationFormatUtils.S, 1) }, DurationFormatUtils.lexx("yMdHmsS")); 
     assertArrayEquals(new DurationFormatUtils.Token[] { new DurationFormatUtils.Token(DurationFormatUtils.H, 1), new DurationFormatUtils.Token(new StringBuilder(":"), 1), new DurationFormatUtils.Token(DurationFormatUtils.m, 2), new DurationFormatUtils.Token(new StringBuilder(":"), 1), new DurationFormatUtils.Token(DurationFormatUtils.s, 2), new DurationFormatUtils.Token(new StringBuilder("."), 1), new DurationFormatUtils.Token(DurationFormatUtils.S, 3) }, DurationFormatUtils.lexx("H:mm:ss.SSS")); 
     assertArrayEquals(new DurationFormatUtils.Token[] { new DurationFormatUtils.Token(new StringBuilder("P"), 1), new DurationFormatUtils.Token(DurationFormatUtils.y, 4), new DurationFormatUtils.Token(new StringBuilder("Y"), 1), new DurationFormatUtils.Token(DurationFormatUtils.M, 1), new DurationFormatUtils.Token(new StringBuilder("M"), 1), new DurationFormatUtils.Token(DurationFormatUtils.d, 1), new DurationFormatUtils.Token(new StringBuilder("DT"), 1), new DurationFormatUtils.Token(DurationFormatUtils.H, 1), new DurationFormatUtils.Token(new StringBuilder("H"), 1), new DurationFormatUtils.Token(DurationFormatUtils.m, 1), new DurationFormatUtils.Token(new StringBuilder("M"), 1), new DurationFormatUtils.Token(DurationFormatUtils.s, 1), new DurationFormatUtils.Token(new StringBuilder("."), 1), new DurationFormatUtils.Token(DurationFormatUtils.S, 1), new DurationFormatUtils.Token(new StringBuilder("S"), 1) }, DurationFormatUtils.lexx(DurationFormatUtils.ISO_EXTENDED_FORMAT_PATTERN)); 
     final DurationFormatUtils.Token token = new DurationFormatUtils.Token(DurationFormatUtils.y, 4); 
     assertFalse("Token equal to non-Token class. ", token.equals(new Object())); 
     assertFalse("Token equal to Token with wrong value class. ", token.equals(new DurationFormatUtils.Token(new Object()))); 
     assertFalse("Token equal to Token with different count. ", token.equals(new DurationFormatUtils.Token(DurationFormatUtils.y, 1))); 
     final DurationFormatUtils.Token numToken = new DurationFormatUtils.Token(Integer.valueOf(1), 4); 
     assertTrue("Token with Number value not equal to itself. ", numToken.equals(numToken)); 
 }
    

    // -----------------------------------------------------------------------
    

    /**
     * Tests that "1 <unit>s" gets converted to "1 <unit>" but that "11 <unit>s" is left alone.
     */
    

    

    

    

    

    

    


    // http://issues.apache.org/bugzilla/show_bug.cgi?id=38401
    

    // https://issues.apache.org/jira/browse/LANG-281
    

    

    // Testing the under a day range in DurationFormatUtils.formatPeriod
    

    // Attempting to test edge cases in DurationFormatUtils.formatPeriod
    
    
    
    
    private static final int FOUR_YEARS = 365 * 3 + 366;
    
    // Takes a minute to run, so generally turned off
//    public void testBrutally() {
//        Calendar c = Calendar.getInstance();
//        c.set(2004, 0, 1, 0, 0, 0);
//        for (int i=0; i < FOUR_YEARS; i++) {
//            bruteForce(c.get(Calendar.YEAR), c.get(Calendar.MONTH), c.get(Calendar.DAY_OF_MONTH), "d", Calendar.DAY_OF_MONTH );
//            c.add(Calendar.DAY_OF_MONTH, 1);
//        }
//    }        
    
    private void bruteForce(final int year, final int month, final int day, final String format, final int calendarType) {
        final String msg = year + "-" + month + "-" + day + " to ";
        final Calendar c = Calendar.getInstance();
        c.set(year, month, day, 0, 0, 0);
        final int[] array1 = new int[] { year, month, day, 0, 0, 0 };
        final int[] array2 = new int[] { year, month, day, 0, 0, 0 };
        for (int i=0; i < FOUR_YEARS; i++) {
            array2[0] = c.get(Calendar.YEAR);
            array2[1] = c.get(Calendar.MONTH);
            array2[2] = c.get(Calendar.DAY_OF_MONTH);
            final String tmpMsg = msg + array2[0] + "-" + array2[1] + "-" + array2[2] + " at ";
            assertEqualDuration( tmpMsg + i, Integer.toString(i), array1, array2, format );
            c.add(calendarType, 1);
        }
    }

    private void assertEqualDuration(final String expected, final int[] start, final int[] end, final String format) {
        assertEqualDuration(null, expected, start, end, format);
    }
    private void assertEqualDuration(final String message, final String expected, final int[] start, final int[] end, final String format) {
        final Calendar cal1 = Calendar.getInstance();
        cal1.set(start[0], start[1], start[2], start[3], start[4], start[5]);
        cal1.set(Calendar.MILLISECOND, 0);
        final Calendar cal2 = Calendar.getInstance();
        cal2.set(end[0], end[1], end[2], end[3], end[4], end[5]);
        cal2.set(Calendar.MILLISECOND, 0);
        final long milli1 = cal1.getTime().getTime();
        final long milli2 = cal2.getTime().getTime();
        final String result = DurationFormatUtils.formatPeriod(milli1, milli2, format);
        if (message == null) {
            assertEquals(expected, result);
        } else {
            assertEquals(message, expected, result);
        }
    }

    private void assertArrayEquals(final DurationFormatUtils.Token[] obj1, final DurationFormatUtils.Token[] obj2) {
        assertEquals("Arrays are unequal length. ", obj1.length, obj2.length);
        for (int i = 0; i < obj1.length; i++) {
            assertTrue("Index " + i + " not equal, " + obj1[i] + " vs " + obj2[i], obj1[i].equals(obj2[i]));
        }
    }

}
